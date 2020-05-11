package com.aldroid.hormid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

//import com.aldroid.hormid.bean.lapak.HargaBean;
//import com.aldroid.hormid.service.lapak.HargaService;


@Controller
@RequestMapping(value = "/")
public class HormidController {

//	@Autowired
//	private HargaService hargaService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
    public String addViewControllers(ViewControllerRegistry registry) {
        return "test";
    }

	@RequestMapping(value="/",method=RequestMethod.GET)
    public String addView(Model m) {
        return "root";
    }
	
//	@RequestMapping(value="/harga",method=RequestMethod.GET)
//    public String selectHarga(Model m) throws Exception {
//		List<HargaBean> harga = hargaService.select();
//		for(HargaBean har : harga){
//			System.out.print(har.getTanggalMulai()+","+har.getCreatedBy()+","+har.getHargaBeli());
//		}
//		m.addAttribute("harga",harga);
//        return "harga";
//    }

}