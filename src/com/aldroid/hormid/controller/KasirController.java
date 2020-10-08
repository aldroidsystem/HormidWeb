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
import com.aldroid.hormid.model.lapak.Pabrik;
import com.aldroid.hormid.model.lapak.Vehicle;
import com.aldroid.hormid.model.transaksi.Harga;
import com.aldroid.hormid.model.transaksi.Piutang;
import com.aldroid.hormid.model.transaksi.TimbangGantung;
import com.aldroid.hormid.model.transaksi.TimbangJembatan;
import com.aldroid.hormid.service.generic.UserService;
import com.aldroid.hormid.service.lapak.AgenService;
import com.aldroid.hormid.service.lapak.PetaniService;
import com.aldroid.hormid.service.lapak.VehicleService;
import com.aldroid.hormid.service.transaksi.HargaService;
import com.aldroid.hormid.service.transaksi.PabrikService;
import com.aldroid.hormid.service.transaksi.PiutangService;
import com.aldroid.hormid.service.transaksi.TimbangJembatanService;
import com.aldroid.hormid.validator.lapak.HargaValidator;
import com.aldroid.hormid.validator.lapak.VehicleValidator;
import com.aldroid.hormid.validator.transaksi.PiutangValidator;
import com.aldroid.hormid.validator.transaksi.TimbangJembatanBayarValidator;
import com.aldroid.hormid.validator.transaksi.TimbangJembatanValidator;
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
    
    @Autowired
    private TimbangJembatanService timbangJembatanService;
    
    @Autowired
    private TimbangJembatanValidator timbangJembatanValidator;
    
    @Autowired
    private TimbangJembatanBayarValidator timbangJembatanBayarValidator;

    @Autowired
    private PabrikService pabrikService;
    
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
		model.addAttribute("listVehicle", globalSessionObject.getListKendaraan());
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

		model.addAttribute("listVehicle", globalSessionObject.getListKendaraan());
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
		model.addAttribute("listVehicle", globalSessionObject.getListKendaraan());
        return "agenForm";
    }
	
	@RequestMapping(value="/agenForm", 
			method=RequestMethod.POST)
    public String agenFormUpsert(@ModelAttribute("agenForm")User agen, BindingResult bindingResult,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());

		model.addAttribute("listPetani", globalSessionObject.getListPetani());
        try{
        	agenService.update(agen);
        	User updatedAgen = agenService.selectAgenDetail(agen.getUsername());
            model.addAttribute("notification", "success");
    		model.addAttribute("agenForm",updatedAgen);
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());      
    		model.addAttribute("agenForm",agen);  
            model.addAttribute("notification", "fail");
        }

		model.addAttribute("listVehicle", globalSessionObject.getListKendaraan());
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

	//----------------------------------------------------------------------

	@RequestMapping(value="/timbangJembatanList",method=RequestMethod.GET)
    public String timbangJembatanList(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		List<TimbangJembatan> listJembatan = timbangJembatanService.selectTimbangJembatanNotComplete();
		model.addAttribute("listJembatan", listJembatan);
        return "timbang.jembatan.list";
    }
	
	@RequestMapping(value="/timbangJembatan",method=RequestMethod.GET)
    public String timbangJembatanTransactionForm(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		TimbangJembatan jembatan = new TimbangJembatan();
		jembatan.setHarga(globalSessionObject.getHargaSekarang().getHargaBeliJembatan());
		jembatan.setPotongan(globalSessionObject.getPropertiesByCode("defaultPotongan").getAngka());
		model.addAttribute("jembatanForm",jembatan);
        model.addAttribute("listVehicle", globalSessionObject.getListKendaraan());
        return "timbang.jembatan.transaction";
    }
	
	@RequestMapping(value="/timbangJembatan", 
			params = {"noNota"},method=RequestMethod.GET)
    public String timbangJembatanTransactionUpdateForm(@RequestParam(value = "noNota")String noNota, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());

		TimbangJembatan jembatan = timbangJembatanService.selectTimbangJembatanTempDetail(noNota);
    	
    	model.addAttribute("jembatanForm",jembatan);
        model.addAttribute("listVehicle", globalSessionObject.getListKendaraan());
        model.addAttribute("listSupir", vehicleService.selectSupirOfVehicleMap(jembatan.getVehicleId()));
        model.addAttribute("listPengirim", vehicleService.selectPengirimOfVehicleMap(jembatan.getVehicleId()));
        return "timbang.jembatan.transaction";
    }

	@RequestMapping(value="/timbangJembatan",method=RequestMethod.POST)
    public String timbangJembatanTransactionInsert(@ModelAttribute("jembatanForm")TimbangJembatan jembatan, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		timbangJembatanValidator.validate(jembatan, bindingResult);
		
        if (bindingResult.hasErrors()) {
            return "timbang.jembatan.transaction";
        }
        
        try{
        	timbangJembatanService.upsert(jembatan);
        	jembatan = timbangJembatanService.selectTimbangJembatanTempDetail(jembatan.getNoNota());
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());
        	jembatan.setNoNota(null);
            return "timbang.jembatan.transaction";
        }

    	model.addAttribute("jembatanForm",jembatan);
        model.addAttribute("listVehicle", globalSessionObject.getListKendaraan());
        model.addAttribute("listSupir", vehicleService.selectSupirOfVehicleMap(jembatan.getVehicleId()));
        model.addAttribute("listPengirim", vehicleService.selectPengirimOfVehicleMap(jembatan.getVehicleId()));
        return "timbang.jembatan.transaction";
    }

	@RequestMapping(value="/timbangJembatanBayar",method=RequestMethod.POST)
    public String timbangJembatanTransactionBayar(@ModelAttribute("jembatanForm")TimbangJembatan jembatan, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		timbangJembatanBayarValidator.validate(jembatan, bindingResult);
		
        if (bindingResult.hasErrors()) {
            return "timbang.jembatan.transaction";
        }
        
        try{
        	timbangJembatanService.bayar(jembatan);
        	jembatan = timbangJembatanService.selectTimbangJembatanPaidDetail(jembatan.getNoNota());
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());
        	jembatan = timbangJembatanService.selectTimbangJembatanTempDetail(jembatan.getNoNota());
            model.addAttribute("listVehicle", globalSessionObject.getListKendaraan());
            model.addAttribute("listSupir", vehicleService.selectSupirOfVehicleMap(jembatan.getVehicleId()));
            model.addAttribute("listPengirim", vehicleService.selectPengirimOfVehicleMap(jembatan.getVehicleId()));
            return "timbang.jembatan.transaction";
        }

    	model.addAttribute("jembatanForm",jembatan);
        return "timbang.jembatan.invoice";
    }
	


	@RequestMapping(value="/timbangJembatanInvoice",method=RequestMethod.POST)
    public String timbangJembatanTransactionInvoice(@RequestParam(value = "noNota")String noNota, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		TimbangJembatan jembatan;
        try{
        	jembatan = timbangJembatanService.selectTimbangJembatanPaidDetail( noNota);
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());
        	return "timbang.jembatan.transaction";
        }

    	model.addAttribute("jembatanForm",jembatan);
        return "timbang.jembatan.invoice";
    }
	//----------------------------------------------------------------------
	@RequestMapping(value="/pabrik",method=RequestMethod.GET)
    public String pabrikList(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		List<Pabrik> listPabrik = pabrikService.selectPabrikAll();
		model.addAttribute("listPabrik", listPabrik);
        return "pabrik.list";
    }

	@RequestMapping(value="/pabrikForm",method=RequestMethod.GET)
    public String pabrikUpdate(@ModelAttribute("pabrikForm")Pabrik pabrik, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        
    	model.addAttribute("pabrikForm",new Pabrik());
        return "pabrik.upsert";
    }

	@RequestMapping(value="/pabrikForm", 
			params = {"pabrikId"},method=RequestMethod.GET)
    public String pabrikInsert(@RequestParam(value = "pabrikId")Integer pabrikId,  Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());

    	Pabrik pabrik = pabrikService.selectPabrikDetil(pabrikId);
    	model.addAttribute("pabrikForm", pabrik);
        return "pabrik.upsert";
    }

	@RequestMapping(value="/pabrikForm",method=RequestMethod.POST)
    public String pabrikUpsert(@ModelAttribute("pabrikForm")Pabrik pabrik, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        
        try{
        	pabrikService.upsert(pabrik);
        	pabrik = pabrikService.selectPabrikDetil(pabrik.getPabrikId());
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());
        }

    	model.addAttribute("pabrikForm",pabrik);
        return "pabrik.upsert";
    }
}