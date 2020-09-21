package com.aldroid.hormid.controller;


import java.util.ArrayList;
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
import com.aldroid.hormid.model.lapak.Harga;
import com.aldroid.hormid.model.lapak.Petani;
import com.aldroid.hormid.model.lapak.Supir;
import com.aldroid.hormid.model.lapak.Vehicle;
import com.aldroid.hormid.service.lapak.HargaService;
import com.aldroid.hormid.service.lapak.PetaniService;
import com.aldroid.hormid.service.lapak.SupirService;
import com.aldroid.hormid.service.lapak.VehicleService;
import com.aldroid.hormid.validator.lapak.HargaValidator;
import com.aldroid.hormid.validator.lapak.VehicleValidator;


@Controller
@RequestMapping("/kasir")
public class KasirController {

	@Autowired
	private HargaValidator hargaValidator;

    @Autowired
    private HargaService hargaService;

    @Autowired
	private GlobalSessionObject globalSessionObject;

    @Autowired
    private SupirService supirService;

    @Autowired
    private PetaniService petaniService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleValidator vehicleValidator;
    
    
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
	

	@RequestMapping(value="/supir",method=RequestMethod.GET)
    public String supir(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("supirSearchForm", new Supir());
		model.addAttribute("listSupir", new ArrayList<Supir>());
        return "supir";
    }
	
	@RequestMapping(value="/supir",method=RequestMethod.POST)
    public String supirSearch(@ModelAttribute("supirForm")Supir supir, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("supirSearchForm", supir);
		model.addAttribute("listSupir", supirService.searchSupirByFullname(supir.getFullname()));
        return "supir";
    }
	
	@RequestMapping(value="/supirForm", 
			method=RequestMethod.GET)
    public String supirForm(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("supirForm", new Supir());
        model.addAttribute("newSupirMap", supirService.selectNewSupir());
		model.addAttribute("listVehicle", vehicleService.loadAllVehicle());
        return "supirForm";
    }

	@RequestMapping(value="/supirForm", 
			params = {"username"},
			method=RequestMethod.GET)
    public String supirFormUpdate(@RequestParam(value = "username")String username,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		Supir supir;
		if(username == null || username.equals("")){
            return "redirect:supirForm";
		} else {
			supir = supirService.selectSupirDetail(username);
			
			if (supir == null || supir.getUsername() == null){
	            return "redirect:supirForm";
			}
		}

		model.addAttribute("supirForm",supir);
		model.addAttribute("listVehicle", vehicleService.loadAllVehicle());
        return "supirForm";
    }
	
	@RequestMapping(value="/supirForm", 
			method=RequestMethod.POST)
    public String supirFormUpsert(@ModelAttribute("supirForm")Supir supir, BindingResult bindingResult,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());

        try{
        	Supir upsertSupir = supirService.upsert(supir);
            model.addAttribute("notification", "success");
    		model.addAttribute("supirForm",upsertSupir);
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());      
    		model.addAttribute("supirForm",supir);  
            model.addAttribute("newSupirMap", supirService.selectNewSupir());
            model.addAttribute("notification", "fail");
        }

		model.addAttribute("listVehicle", vehicleService.loadAllVehicle());
        return "supirForm";
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
        model.addAttribute("listSupirMap", supirService.selectSupirList());
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
        model.addAttribute("listSupirMap", supirService.selectSupirList());
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
        model.addAttribute("listSupirMap", supirService.selectSupirList());
        return "vehicleForm";
    }
	


	@RequestMapping(value="/petani",method=RequestMethod.GET)
    public String petani(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("petaniSearchForm", new Petani());
		model.addAttribute("listPetani", new ArrayList<Petani>());
        return "petani";
    }
	@RequestMapping(value="/petani",method=RequestMethod.POST)
    public String petaniSearch(@ModelAttribute("petaniForm")Petani petani, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("petaniSearchForm", petani);
		model.addAttribute("listPetani", petaniService.searchPetaniByFullname(petani.getFullname()));
        return "petani";
    }
	
	@RequestMapping(value="/petaniForm", 
			method=RequestMethod.GET)
    public String petaniForm(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("petaniForm", new Petani());
        model.addAttribute("newPetaniMap", petaniService.selectNewPetani());
		model.addAttribute("listVehicle", vehicleService.loadAllVehicle());
        return "petaniForm";
    }

	@RequestMapping(value="/petaniForm", 
			params = {"username"},
			method=RequestMethod.GET)
    public String petaniFormUpdate(@RequestParam(value = "username")String username,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		Petani petani;
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
    public String petaniFormUpsert(@ModelAttribute("petaniForm")Petani petani, BindingResult bindingResult,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());

        try{
        	Petani upsertPetani = petaniService.upsert(petani);
            model.addAttribute("notification", "success");
    		model.addAttribute("petaniForm",upsertPetani);
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());      
    		model.addAttribute("petaniForm",petani);  
            model.addAttribute("newPetaniMap", petaniService.selectNewPetani());
            model.addAttribute("notification", "fail");
        }

		model.addAttribute("listVehicle", vehicleService.loadAllVehicle());
        return "petaniForm";
    }
}