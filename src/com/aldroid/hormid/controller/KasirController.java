package com.aldroid.hormid.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aldroid.hormid.generic.process.CommonProcess;
import com.aldroid.hormid.generic.process.GlobalSessionObject;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.model.lapak.Vehicle;
import com.aldroid.hormid.model.transaksi.Harga;
import com.aldroid.hormid.model.transaksi.Piutang;
import com.aldroid.hormid.model.transaksi.TimbangGantung;
import com.aldroid.hormid.service.generic.UserService;
import com.aldroid.hormid.service.lapak.AgenService;
import com.aldroid.hormid.service.lapak.PetaniService;
import com.aldroid.hormid.service.lapak.VehicleService;
import com.aldroid.hormid.service.transaksi.HargaService;
import com.aldroid.hormid.service.transaksi.PiutangService;
import com.aldroid.hormid.validator.lapak.HargaValidator;
import com.aldroid.hormid.validator.lapak.VehicleValidator;
import com.aldroid.hormid.validator.transaksi.PiutangValidator;
import com.aldroid.hormid.service.transaksi.TimbangGantungService;
import com.aldroid.hormid.validator.transaksi.TimbangGantungValidator;


@Controller
@RequestMapping("/kasir")
public class KasirController {

    @Autowired
	private GlobalSessionObject globalSessionObject;

	@Autowired
	private HargaValidator hargaValidator;

    @Autowired
    private HargaService hargaService;

    @Autowired
    private UserService userService;
    
    @Autowired
    private PetaniService petaniService;

    @Autowired
    private AgenService agenService;
    
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleValidator vehicleValidator;

    @Autowired
    private PiutangService piutangService;

    @Autowired
    private PiutangValidator piutangValidator;

    @Autowired
    private TimbangGantungValidator timbangGantungValidator;
    
    @Autowired
    private TimbangGantungService timbangGantungService;
    
    
	@RequestMapping(value="/harga",method=RequestMethod.GET)
    public String loadHarga(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("hargaForm", new Harga());
        model.addAttribute("hargaSekarang", globalSessionObject.getHargaSekarang());
        return "harga";
    }
	

	@RequestMapping(value="/harga",method=RequestMethod.POST)
    public String insertHarga(@ModelAttribute("hargaForm")Harga harga, BindingResult bindingResult,  Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		hargaValidator.validate(harga, bindingResult);

        if (bindingResult.hasErrors()) {
            return "harga";
        }

        try{
        	hargaService.insert(harga);
            model.addAttribute("notification", "success");
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());        
            model.addAttribute("notification", "fail");
        }
        
        model.addAttribute("hargaForm", new Harga());
        model.addAttribute("hargaSekarang", globalSessionObject.getHargaSekarang());
        return "harga";
    }
	


	@RequestMapping(value="/vehicle",method=RequestMethod.GET)
    public String vehicle(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("vehicleSearchForm", new Vehicle());
		model.addAttribute("listVehicle", new ArrayList<Vehicle>());
        return "vehicle";
    }

	@RequestMapping(value="/vehicle",method=RequestMethod.POST)
    public String vehicleSearch(@ModelAttribute("vehicleForm")Vehicle vehicle, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("vehicleSearchForm", vehicle);
		model.addAttribute("listVehicle", vehicleService.findByPlateNumber(vehicle.getPlateNumber()));
        return "vehicle";
    }
	
	@RequestMapping(value="/vehicleForm", 
			method=RequestMethod.GET)
    public String vehicleForm(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());

		model.addAttribute("vehicleForm",new Vehicle());
		model.addAttribute("listVehicleType", globalSessionObject.getPropertiesByCode("vehicleType").getDaftarKata());
        model.addAttribute("listSupirMap", globalSessionObject.getListSupir());
        return "vehicleForm";
    }

	@RequestMapping(value="/vehicleForm", 
			params = {"vehicleId"},
			method=RequestMethod.GET)
    public String userForm(@RequestParam(value = "vehicleId")Integer vehicleId,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		Vehicle vehicle;
		if(vehicleId == null || vehicleId.equals("")){
            return "redirect:vehicleForm";
		} else {
			vehicle = vehicleService.selectVehicleByVehicleID(vehicleId);
			
			if (vehicle == null || vehicle.getVehicleId() == null){
	            return "redirect:vehicleForm";
			}
		}

		model.addAttribute("vehicleForm",vehicle);
		model.addAttribute("listVehicleType", globalSessionObject.getPropertiesByCode("vehicleType").getDaftarKata());
        model.addAttribute("listSupirMap", globalSessionObject.getListSupir());
        return "vehicleForm";
    }
	
	@RequestMapping(value="/vehicleForm", 
			method=RequestMethod.POST)
    public String vehicleFormUpsert(@ModelAttribute("vehicleForm")Vehicle vehicle, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		
		vehicleValidator.validate(vehicle, bindingResult);

        if (bindingResult.hasErrors()) {
            return "vehicleForm";
        }
        
        try{
        	Vehicle lastVeh = vehicleService.upsert(vehicle);
        	model.addAttribute("vehicleForm",lastVeh);
            model.addAttribute("notification", "success");
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());        
            model.addAttribute("notification", "fail");
            model.addAttribute("vehicleForm",vehicle);
        }
		
		model.addAttribute("listVehicleType", globalSessionObject.getPropertiesByCode("vehicleType").getDaftarKata());
        model.addAttribute("listSupirMap", globalSessionObject.getListSupir());
        return "vehicleForm";
    }
	


	@RequestMapping(value="/petani",method=RequestMethod.GET)
    public String petani(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("petaniSearchForm", new User());
		model.addAttribute("listPetani", new ArrayList<User>());
        return "petani";
    }
	@RequestMapping(value="/petani",method=RequestMethod.POST)
    public String petaniSearch(@ModelAttribute("petaniForm")User petani, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("petaniSearchForm", petani);
		model.addAttribute("listPetani", petaniService.searchPetaniByFullname(petani.getFullname()));
        return "petani";
    }
	

	@RequestMapping(value="/petaniForm", 
			params = {"username"},
			method=RequestMethod.GET)
    public String petaniFormUpdate(@RequestParam(value = "username")String username,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		User petani;
		if(username == null || username.equals("")){
            return "redirect:petaniForm";
		} else {
			petani = petaniService.selectPetaniDetail(username);
			
			if (petani == null || petani.getUsername() == null){
	            return "redirect:petaniForm";
			}
		}

		model.addAttribute("petaniForm",petani);
		model.addAttribute("listVehicle", vehicleService.loadAllVehicle());
        return "petaniForm";
    }
	
	@RequestMapping(value="/petaniForm", 
			method=RequestMethod.POST)
    public String petaniFormUpsert(@ModelAttribute("petaniForm")User petani, BindingResult bindingResult,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());

        try{
        	petaniService.update(petani);
        	User upsertPetani = petaniService.selectPetaniDetail(petani.getUsername());
            model.addAttribute("notification", "success");
    		model.addAttribute("petaniForm",upsertPetani);
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());      
    		model.addAttribute("petaniForm",petani);  
            model.addAttribute("notification", "fail");
        }

		model.addAttribute("listVehicle", vehicleService.loadAllVehicle());
        return "petaniForm";
    }
	//----------------------------------------------------------------


	@RequestMapping(value="/agen",method=RequestMethod.GET)
    public String agen(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("agenSearchForm", new User());
		model.addAttribute("listAgen", new ArrayList<User>());
        return "agen";
    }
	@RequestMapping(value="/agen",method=RequestMethod.POST)
    public String agenSearch(@ModelAttribute("agenForm")User agen, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("agenSearchForm", agen);
		model.addAttribute("listAgen", agenService.searchAgenByFullname(agen.getFullname()));
        return "agen";
    }
	

	@RequestMapping(value="/agenForm", 
			params = {"username"},
			method=RequestMethod.GET)
    public String agenFormUpdate(@RequestParam(value = "username")String username,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		User agen;
		model.addAttribute("listPetani", globalSessionObject.getListPetani());
		if(username == null || username.equals("")){
            return "redirect:agenForm";
		} else {
			agen = agenService.selectAgenDetail(username);
			
			if (agen == null || agen.getUsername() == null){
	            return "redirect:agenForm";
			}
		}

		model.addAttribute("agenForm",agen);
		model.addAttribute("listVehicle", vehicleService.loadAllVehicle());
        return "agenForm";
    }
	
	@RequestMapping(value="/agenForm", 
			method=RequestMethod.POST)
    public String agenFormUpsert(@ModelAttribute("agenForm")User agen, BindingResult bindingResult,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());

		model.addAttribute("listPetani", globalSessionObject.getListPetani());
        try{
        	agenService.update(agen);
        	User upsertAgen = agenService.selectAgenDetail(agen.getUsername());
            model.addAttribute("notification", "success");
    		model.addAttribute("agenForm",upsertAgen);
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());      
    		model.addAttribute("agenForm",agen);  
            model.addAttribute("notification", "fail");
        }

		model.addAttribute("listVehicle", vehicleService.loadAllVehicle());
        return "agenForm";
    }

	//----------------------------------------------------------------------

    
	@RequestMapping(value="/piutang",method=RequestMethod.GET)
    public String loadPiutang(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		model.addAttribute("listUser", new ArrayList<User>());
        model.addAttribute("piutangSearchForm", new User());
        return "piutang";
    }

	@RequestMapping(value="/piutang",method=RequestMethod.POST)
    public String piutangSearch(@ModelAttribute("userForm") User user, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("piutangSearchForm", user);
		model.addAttribute("listUser", piutangService.searchUserPiutangByFullname(user.getFullname()));
        return "piutang";
    }
	

	@RequestMapping(value="/piutangTransaction", 
			params = {"username"},
			method=RequestMethod.GET)
    public String piutangUpdate(@RequestParam(value = "username")String username,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		Piutang piutang;
		if(username == null || username.equals("")){
            return "redirect:notfound";
		} else {
			piutang = piutangService.selectUserPiutangDetail(username);
			
			if (piutang == null || piutang.getUsername() == null){
	            return "redirect:notfound";
			}
		}

		model.addAttribute("piutangForm",piutang);
        return "piutang.transaction";
    }
	
	@RequestMapping(value="/piutangTransaction", 
			method=RequestMethod.POST)
    public String piutangUpdateProcess(@ModelAttribute("piutangForm")Piutang piutang, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		piutangValidator.validate(piutang, bindingResult);


        if (bindingResult.hasErrors()) {
            return "piutang.transaction";
        }

        try{
        	piutangService.insert(piutang);
    		model.addAttribute("piutangForm",piutangService.selectPiutangDetail(piutang.getPiutangId()));
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());
            model.addAttribute("piutangForm", piutang);
        }

        return "piutang.invoice";
    }
	

	@RequestMapping(value="/piutangHistory", 
			params = {"username"},
			method=RequestMethod.GET)
    public String piutangHistory(@RequestParam(value = "username")String username,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		Piutang piutang;
		if(username == null || username.equals("")){
            return "redirect:notfound";
		} else {
			piutang = piutangService.selectUserPiutangDetail(username);
			
			if (piutang == null || piutang.getUsername() == null){
	            return "redirect:notfound";
			}
		}

		model.addAttribute("piutangForm",piutang);
		model.addAttribute("listPiutangHistory",new ArrayList<Piutang>());
        return "piutang.history";
    }
	@RequestMapping(value="/piutangHistory", 
			params = {"username"},
			method=RequestMethod.POST)
    public String piutangHistoryResult(@ModelAttribute("piutangForm")Piutang piutang, BindingResult bindingResult,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		Piutang piutangOri;
		List<Piutang> listPiutang;
		if(piutang.getUsername() == null || piutang.getUsername().equals("")){
            return "redirect:notfound";
		} else {
			piutangOri = piutangService.selectUserPiutangDetail(piutang.getUsername());
			listPiutang = piutangService.searchUserPiutangHistory(piutang);
			
			if (piutangOri == null || piutang.getUsername() == null){
	            return "redirect:notfound";
			}
		}

		piutangOri.setJenisTransaksi(piutang.getJenisTransaksi());
		piutangOri.setDariTanggal(piutang.getDariTanggal());
		piutangOri.setSampaiTanggal(piutang.getSampaiTanggal());
		model.addAttribute("piutangForm",piutangOri);
		model.addAttribute("listPiutangHistory",listPiutang);
        return "piutang.history";
    }
	
	

	
	@RequestMapping(value="/piutangInvoice", 
			method=RequestMethod.GET)
    public String piutangInvoice(@RequestParam(value = "piutangId")String piutangId, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());

		model.addAttribute("piutangForm",piutangService.selectPiutangDetail(piutangId));

        return "piutang.invoice";
    }
	
	
	@RequestMapping(value="/piutangInvoicePrint", 
			method=RequestMethod.GET)
    public String piutangInvoicePrint(@RequestParam(value = "piutangId")String piutangId, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());

		model.addAttribute("piutangForm",piutangService.selectPiutangDetail(piutangId));

        return "piutang.invoice.print";
    }
	

	//----------------------------------------------------------------------
	

	@RequestMapping(value="/timbangGantung",method=RequestMethod.GET)
    public String timbangGantungTransactionForm(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		TimbangGantung gantung = new TimbangGantung();
		gantung.setHarga(globalSessionObject.getHargaSekarang().getHargaBeliGantung());
		gantung.setPotongan(globalSessionObject.getPropertiesByCode("defaultPotongan").getAngka());
		model.addAttribute("gantungForm",gantung);
        model.addAttribute("newPetaniMap", globalSessionObject.getListPetani());
        return "timbang.gantung.transaction";
    }

	@RequestMapping(value="/timbangGantung",method=RequestMethod.POST)
    public String timbangGantungTransaction(@ModelAttribute("gantungForm")TimbangGantung gantung, BindingResult bindingResult,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		timbangGantungValidator.validate(gantung, bindingResult);

        if (bindingResult.hasErrors()) {
            return "timbang.gantung.transaction";
        }

        try{
        	timbangGantungService.insert(gantung);
        	TimbangGantung gantungInserted = timbangGantungService.selectTimbangGantungDetail(gantung.getNoNota());
    		model.addAttribute("gantungForm",gantungInserted);
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());
    		model.addAttribute("gantungForm", gantung);
            return "timbang.gantung.transaction";
        }
		
        return "timbang.gantung.invoice";
    }

	@RequestMapping(value="/timbangGantungInvoice",method=RequestMethod.GET)
    public String timbangGantungTransaction(@RequestParam(value = "gantungId")String gantungId,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());

        try{
        	TimbangGantung gantungInserted = timbangGantungService.selectTimbangGantungDetail(gantungId);
    		model.addAttribute("gantungForm",gantungInserted);
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());
            return "timbang.gantung.transaction";
        }
		
        return "timbang.gantung.invoice";
    }
}