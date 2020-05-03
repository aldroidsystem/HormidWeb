package test;

import java.util.logging.Level;
import java.util.logging.Logger;







import org.springframework.beans.factory.annotation.Autowired;

import com.aldroid.hormid.lapak.bean.HargaBean;
import com.aldroid.hormid.lapak.controller.HargaController;

public class Test2 {

//    @Autowired
//    TestController testController;
    

    @Autowired
    HargaController hargaController;
    
//    public String test_run(){
//    	String result = "Awal";
//        try {
//            result  = testController.selectDual();
//            
//        } catch (Exception ex) {
//        	result = ex.getMessage();
//            Logger.getLogger(Test2.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }
    
    public void testInsert(HargaBean bean){
    	try {
			hargaController.insert(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
