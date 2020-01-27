package com.example.kulinarskiDnevnik.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.kulinarskiDnevnik.model.Kategorija;
import com.example.kulinarskiDnevnik.model.Korisnik;
import com.example.kulinarskiDnevnik.model.Omiljenakat;
import com.example.kulinarskiDnevnik.model.Omiljenirecept;
import com.example.kulinarskiDnevnik.model.Poruka;
import com.example.kulinarskiDnevnik.model.Recept;
import com.example.kulinarskiDnevnik.model.Sastojak;
import com.example.kulinarskiDnevnik.model.Slika;
import com.example.kulinarskiDnevnik.model.Zahtev;
import com.example.kulinarskiDnevnik.repository.KategorijaJpaRepo;
import com.example.kulinarskiDnevnik.repository.KorisnikJpaRepo;
import com.example.kulinarskiDnevnik.repository.OmiljenaKategorijaJpaRepo;
import com.example.kulinarskiDnevnik.repository.OmiljeniReceptJpaRepo;
import com.example.kulinarskiDnevnik.repository.PorukaJpaRepo;
import com.example.kulinarskiDnevnik.repository.ReceptJpaRepo;
import com.example.kulinarskiDnevnik.repository.SastojakJpaRepo;
import com.example.kulinarskiDnevnik.repository.SlikaJpaRepo;
import com.example.kulinarskiDnevnik.repository.UlogaKorisnikaJpaRepo;
import com.example.kulinarskiDnevnik.repository.ZahtevJpaRepo;


@Controller
@RequestMapping(value="/korisnik")
public class KorisnikController {
	List<Sastojak> sastojci = new ArrayList<>();
	
	@Autowired
	KorisnikJpaRepo korisnikRepo;
	
	@Autowired
	UlogaKorisnikaJpaRepo ulogaRepo;
	
	@Autowired
	ReceptJpaRepo receptRepo;
	
	@Autowired
	SlikaJpaRepo slikaRepo;
	
	@Autowired
	KategorijaJpaRepo kategorijaRepo;
	
	@Autowired
	SastojakJpaRepo sastojakRepo;
	
	@Autowired
	ZahtevJpaRepo zahtevRepo;
	
	@Autowired
	PorukaJpaRepo porukaRepo;
	
	@Autowired
	OmiljenaKategorijaJpaRepo omiljenakatRepo;
	
	@Autowired
	OmiljeniReceptJpaRepo omiljenireceptRepo;
	
	@RequestMapping(value="index", method=RequestMethod.GET)
	public String sviRecepti(HttpServletRequest request, HttpServletResponse response, Model m) {
		List<Recept> sviRecepti = receptRepo.findAll();
		List<Zahtev> zahtevi = new ArrayList<>();
		Korisnik ulogovani = (Korisnik)request.getSession().getAttribute("user");
		if(ulogovani!=null ) {
			for(Recept r: sviRecepti) {
				if(zahtevRepo.findByKorisnik1AndKorisnik2(ulogovani, r.getKorisnikBean())==null 
						&& zahtevRepo.findByKorisnik1AndKorisnik2(r.getKorisnikBean(), ulogovani)==null) {
					zahtevi.add(null);
				}else if(zahtevRepo.findByKorisnik1AndKorisnik2(ulogovani, r.getKorisnikBean())!=null) {
					Zahtev z = zahtevRepo.findByKorisnik1AndKorisnik2(ulogovani, r.getKorisnikBean());
					zahtevi.add(z);
				}else if(zahtevRepo.findByKorisnik1AndKorisnik2(r.getKorisnikBean(), ulogovani)!=null) {
					Zahtev z = zahtevRepo.findByKorisnik1AndKorisnik2(r.getKorisnikBean(), ulogovani);
					zahtevi.add(z);
				}
			}
			int neodgovoreni=0;
			List<Zahtev> primljeniZahtevi =zahtevRepo.findByKorisnik1(ulogovani);
			for(Zahtev z: primljeniZahtevi) {
				if(z.getStatus().equals("cekanje")) {
					neodgovoreni++;
				}
			}
			m.addAttribute("msg", "Imate "+ neodgovoreni+" neodgovorenih zahteva");
			
			List<Poruka> neprocitane = porukaRepo.neprocitanePorukeKorisnika(ulogovani.getIdKorisnik());
			int neprocitanePor=neprocitane.size();
			m.addAttribute("msgPor", "Imate "+neprocitanePor+" neprocitanih poruka");
		}
		m.addAttribute("zahtevi", zahtevi);
		m.addAttribute("recepti", sviRecepti);
		return "index";
	}
	
	@RequestMapping(value="loginForm", method=RequestMethod.GET)
	public String loginForm(HttpServletRequest request, Model m) {
		return "login";
	}
	
	@RequestMapping(value="signUpForm", method=RequestMethod.GET)
	public String signUpForm(HttpServletRequest request, Model m) {
		return "signUp";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(HttpServletRequest request, Model m) {
		Korisnik user = (Korisnik) korisnikRepo.findByUsernameAndPassword(request.getParameter("username"), request.getParameter("password"));
		if (user !=null) {
	    	request.getSession().setAttribute("user", user);
	    } else {
	    	m.addAttribute("message", "Username ili password nisu korektni!");
	    	return "login";
	  	}
		return "redirect:/korisnik/index";
	}
	
	@RequestMapping(value="signUp", method=RequestMethod.POST)
	public String signUp(HttpServletRequest request, Model m) {
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("passwordPotvrda");
		Korisnik user = (Korisnik) korisnikRepo.findByUsername(request.getParameter("username"));
		if(user!=null) {
			String err1 = "Korisnik sa ovim username-om vec postoji!";
			m.addAttribute("err1", err1);
			return "signUp";
		}
		if(!password.equals(password2)) {
			String err2= "Uneti passwordi se ne poklapaju!";
			m.addAttribute("err2", err2);
			return "signUp";
		}
		Korisnik korisnik = new Korisnik();
		korisnik.setIme(ime);
		korisnik.setPrezime(prezime);
		korisnik.setUsername(username);
		korisnik.setPassword(password);
		korisnik.setUlogakorisnika(ulogaRepo.findByNazivUloge("korisnik"));
		Korisnik sacuvan = korisnikRepo.save(korisnik);
		if(sacuvan==null) {
			m.addAttribute("message", "Registracija nije uspela!Pokusajte ponovo");
			return "signUp";
		}
		m.addAttribute("msgreg", "Uspesno ste se registrovali! Mozete se ulogovati!");
		return "login";
	}
	
	@RequestMapping(value="odjava")
	public String odjava(HttpServletRequest request, Model m) {
		request.getSession().removeAttribute("user");
		return "redirect:/korisnik/index";
	}
	
	@RequestMapping(value= "dodavanjeRecepta", method=RequestMethod.GET)
	public String dodavanjeRecepta(HttpServletRequest request, Model m) {
		if(request.getSession().getAttribute("user")==null)
			return "redirect:/korisnik/loginForm";
		List<Kategorija> kategorije = kategorijaRepo.findAll();
		m.addAttribute("kategorije", kategorije);
		sastojci.clear();
		return "dodavanjeRecepta";
	}
	
	@RequestMapping(value="dodavanjeSastojka", method=RequestMethod.GET)
	public String dodavanjeSastojaka(HttpServletRequest request, Model m, RedirectAttributes redirectAttributes) {
		Korisnik korisnik = (Korisnik) request.getSession().getAttribute("user");
		if(korisnik==null) {
			return "login";
		}
		if(!request.getParameter("sastojak").equals("") && !request.getParameter("kolicina").equals("")) {
			Sastojak s = new Sastojak();
			s.setSastojak(request.getParameter("sastojak"));
			s.setKolicina(request.getParameter("kolicina"));
			sastojci.add(s);
		}
		List<Kategorija> kategorije = kategorijaRepo.findAll();
		m.addAttribute("kategorije", kategorije);
		m.addAttribute("sastojci", sastojci);
		return "dodavanjeRecepta";
	}
	
	@RequestMapping(value="dodavanjeRecepta", method=RequestMethod.POST)
	public String dodavanjeRecepta(HttpServletRequest request, @RequestParam("slike") MultipartFile[] slike, Model m) {
		if(request.getSession().getAttribute("user")==null)
			return "redirect:/korisnik/loginForm";
		String nazivRecepta = request.getParameter("nazivRecepta");
		String nacinPripreme = request.getParameter("nacinPripreme");
		int kategorija = Integer.parseInt(request.getParameter("kategorija"));
		Recept recept = new Recept();
		recept.setNaziv(nazivRecepta);
		recept.setNacinPripreme(nacinPripreme);
		recept.setKategorijaBean(kategorijaRepo.findById(kategorija).get());
		recept.setDatumPostavke(new Date());
		recept.setKorisnikBean((Korisnik)request.getSession().getAttribute("user"));
		
		Recept sacuvan=receptRepo.save(recept);
		sacuvan.setSastojaks(sastojci);
		for(Sastojak s: sastojci) {
			s.setReceptBean(sacuvan);
			sastojakRepo.save(s);
		}
		for(MultipartFile slika: slike) {
			Slika s = new Slika();
			s.setReceptBean(sacuvan);
			try {
				s.setSlika(slika.getBytes());
				slikaRepo.save(s);
				m.addAttribute("msg", "Uspesno snimljeno");
			} catch (IOException e) {
				m.addAttribute("msg", "Nesto je poslo po zlu!");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return "dodavanjeRecepta";
	}
	
	
	@RequestMapping(value="prikazRecepta/{id}")
	public String prikazRecepta(@PathVariable(name="id") int idRecepta, HttpServletRequest request, Model m) {
		Recept recept = receptRepo.getOne(idRecepta);
		Korisnik ulogovan = (Korisnik)request.getSession().getAttribute("user");
		if(ulogovan!=null) {
			Omiljenirecept omrec = omiljenireceptRepo.omiljenReceptKorisnika(recept.getIdRecept(), ulogovan.getIdKorisnik());
			List<Omiljenakat> omiljenekat = omiljenakatRepo.findByKorisnikBean(ulogovan);
			m.addAttribute("omiljenekat", omiljenekat);
			m.addAttribute("omiljeni", omrec);
		}
		m.addAttribute("recept", recept);
		
		return "prikazRecepta";
	}
	
	@RequestMapping(value = "vratiPocetnuSliku")
	public void vratiPocetnuSliku(HttpServletResponse response, @RequestParam("id") int idRecept) throws Exception {
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		Slika s =receptRepo.getOne(idRecept).getSlikas().get(0);
		byte[] bytes = s.getSlika();
	    response.getOutputStream().write(bytes);
	    response.getOutputStream().close();
	}
	
	@RequestMapping(value="vratiSlike")
	public void vratiSlike(@RequestParam("idSlika") int idSlika, HttpServletResponse response) throws Exception{
		Slika slika = slikaRepo.getOne(idSlika);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		byte[] bytes = slika.getSlika();
		response.getOutputStream().write(bytes);
		
		response.getOutputStream().close();
	}
	@RequestMapping(value="posaljiZahtev")
	public String posaljiZahtev(@RequestParam("idKorisnik") int idKorisnik,HttpServletRequest request, Model m) {
		Korisnik korisnik = (Korisnik) request.getSession().getAttribute("user");
		if(korisnik==null) {
			return "login";
		}
		Zahtev zahtev = new Zahtev();
		zahtev.setDatum(new Date());
		zahtev.setKorisnik1(korisnikRepo.getOne(idKorisnik));
		zahtev.setKorisnik2((Korisnik)request.getSession().getAttribute("user"));
		zahtev.setStatus("cekanje");
		zahtevRepo.save(zahtev);
		return "redirect:/korisnik/index";
	}
	
	@RequestMapping(value="prikazZahteva")
	public String prikazZahteva(HttpServletRequest request, Model m) {
		Korisnik korisnik = (Korisnik) request.getSession().getAttribute("user");
		if(korisnik==null) {
			return "login";
		}
		List<Zahtev> zahtevi = zahtevRepo.findByKorisnik1(korisnik);
		m.addAttribute("zahteviKorisnika", zahtevi);
		return "prikazZahteva";
	}
	
	@RequestMapping(value="prihvatiZahtev")
	public String prihvatiZahtev(@RequestParam("idZahtev") int idZahtev, HttpServletRequest request, Model m) {
		if(request.getSession().getAttribute("user")==null)
			return "redirect:/korisnik/loginForm";
		Zahtev zahtev = zahtevRepo.getOne(idZahtev);
		zahtev.setStatus("prihvacen");
		zahtev.setDatum(new Date());
		zahtevRepo.save(zahtev);	
		return "redirect:/korisnik/prikazZahteva";
	}
	@RequestMapping(value="posaljiPoruku")
	public String formaPoruke(@RequestParam("idKorisnik") int idKorisnikPr, HttpServletRequest request, Model m) {
		Korisnik ulogovan = (Korisnik)request.getSession().getAttribute("user");
		if(ulogovan==null) {
			return "login";
		}
		List<Poruka> poruke = porukaRepo.svePorukeKorisnika(idKorisnikPr, ulogovan.getIdKorisnik()); 
		for(Poruka p:poruke) {
			if(p.getKorisnik2().getIdKorisnik()==ulogovan.getIdKorisnik()) {
				p.setStatus("procitana");
				porukaRepo.save(p);
			}
			
		}
		m.addAttribute("poruke", poruke);
		m.addAttribute("korisnik", idKorisnikPr);
		return "posaljiPoruku";
	}
	
	@RequestMapping(value="posaljiPoruku", method=RequestMethod.POST)
	public String posaljiPoruku(@RequestParam("idKorisnik")int idKorisnika, HttpServletRequest request, Model m) {
		Korisnik ulogovan = (Korisnik)request.getSession().getAttribute("user");
		if(ulogovan==null) {
			return "login";
		}
		String text = request.getParameter("text");
		Poruka p = new Poruka();
		p.setDatumSlanja(new Date());
		p.setText(text);
		p.setStatus("neprocitana");
		p.setKorisnik1(ulogovan);
		p.setKorisnik2(korisnikRepo.getOne(idKorisnika));
		porukaRepo.save(p);
		return "redirect:/korisnik/posaljiPoruku/?idKorisnik="+idKorisnika;
	}
	
	@RequestMapping(value="pregledPrijatelja", method=RequestMethod.GET)
	public String pregledPrijatelja(HttpServletRequest request, Model m) {
		Korisnik ulogovan = (Korisnik)request.getSession().getAttribute("user");
		if(ulogovan==null) {
			return "login";
		}
		List<Zahtev> prijatelji = zahtevRepo.prijateljiKorisnika(ulogovan);
		m.addAttribute("prijatelji", prijatelji);
		return "pregledPrijatelja";
	}
	
	@RequestMapping(value="neprocitanePoruke", method=RequestMethod.GET)
	public String neprocitanePoruke(HttpServletRequest request, Model m) {
		Korisnik ulogovan = (Korisnik)request.getSession().getAttribute("user");
		if(ulogovan==null ) {
			return "login";
		}
		List<Poruka> neprocitane = porukaRepo.neprocitanePorukeKorisnika(ulogovan.getIdKorisnik());
		m.addAttribute("neprocitane", neprocitane);
		return "neprocitanePoruke";
	}
	
	@RequestMapping(value="dodajUOmiljene", method=RequestMethod.POST)
	public String dodajUOmiljene(@RequestParam("idRecepta")int idRecepta, HttpServletRequest request, Model m) {
		if(request.getSession().getAttribute("user")==null )
			return "redirect:/korisnik/loginForm";
		Recept recept = receptRepo.getOne(idRecepta);
		String kat = request.getParameter("kat");
		Omiljenakat kateg = null;
		
		if(kat.equals("-1")) {
			kat = request.getParameter("omkateg");
			if(!kat.equals("") && !kat.equals(" ")){
				kateg = new Omiljenakat();
				kateg.setNaziv(kat);
				kateg.setKorisnikBean((Korisnik)request.getSession().getAttribute("user"));
				omiljenakatRepo.save(kateg);
				Omiljenirecept omrecept = new Omiljenirecept();
				omrecept.setReceptBean(recept);
				omrecept.setOmiljenakat(kateg);
				omiljenireceptRepo.save(omrecept);
				
				
			}else {
				m.addAttribute("msg1", "Morate izabrati omiljenu kategoriju");
			}
		}else {
			kateg = omiljenakatRepo.getOne(Integer.parseInt(request.getParameter("kat")));
			Omiljenirecept omrecept = new Omiljenirecept();
			omrecept.setReceptBean(recept);
			omrecept.setOmiljenakat(kateg);
			omiljenireceptRepo.save(omrecept);
			
		}
		
		return "redirect:/korisnik/prikazRecepta/"+idRecepta;
	}
	@RequestMapping(value="dodajKategoriju", method=RequestMethod.POST)
	public String dodajKategoriju(HttpServletRequest request, Model m) {
		Korisnik korisnik = (Korisnik) request.getSession().getAttribute("user");
		if(korisnik!=null && korisnik.getUlogakorisnika().getNazivUloge().equals("admin")) {
			String nazivkat = request.getParameter("naziv");
			Kategorija k = new Kategorija();
			k.setNazivKategorije(nazivkat);
			kategorijaRepo.save(k);
			return "redirect:/korisnik/index";
		}else {
			m.addAttribute("porukaAdmin", "Niste admin ne mozete dodavati kategoriju");
			return "redirect:/korisnik/index";
		}
	}
	
	@RequestMapping(value="dodajKategorijuForma", method=RequestMethod.GET)
	public String dodajKategorijuForma(HttpServletRequest request, Model m) {
		Korisnik korisnik = (Korisnik) request.getSession().getAttribute("user");
		if(korisnik!=null && korisnik.getUlogakorisnika().getNazivUloge().equals("admin")) {
			return "dodajKategoriju";
		}else {
			m.addAttribute("porukaAdmin", "Niste admin ne mozete dodavati kategoriju");
			return "redirect:/korisnik/index";
		}
	}
	
}
