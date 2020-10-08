<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/rest" var="restURL" />

<spring:url value="/resources/plugins/jquery-validation/jquery.validate.min.js" var="valJs" />
<script src="${valJs}"></script>
<spring:url value="/resources/plugins/jquery-validation/additional-methods.min.js" var="addmethJs" />
<script src="${addmethJs}"></script> 
<spring:url value="/resources/plugins/toastr/toastr.min.js" var="toastr" />
<script src="${toastr}"></script>   
<spring:url value="/resources/plugins/select2/js/select2.full.min.js" var="select2Jss" />
<script src="${select2Jss}"></script>
  
  
<script type="text/javascript">
$(function () {
    //Initialize Select2 Elements
    $('.select2').select2()
  })
  
  function numberFormat(num) {
  return num.toLocaleString('in');
}

  function calculateTimbangan(){
		var bruto = $("#idInputBruto").val();
		var tare = $("#idInputTare").val();
		if (tare >0 && bruto > 0 ){
			var netto = bruto - tare;
			$("#idInputNetto").val(numberFormat(netto));

  			var potongan = $("#idInputPotongan").val();
			if (potongan > 0){
				var potonganTotal = Math.ceil(netto * potongan / 100);
				$("#idInputTotalPotongan").val(numberFormat(potonganTotal));
				
				var beratBersih = netto - potonganTotal;
				$("#idInputBeratBersih").val(numberFormat(beratBersih));
				
				var harga = $("#idInputHarga").val();
				if (harga > 0){
					var totAwal = beratBersih*harga;
					var total = Math.floor(totAwal/1000)*1000;
					$("#idInputTotal").val(numberFormat(total));
					
					var potonganBon = $("#idInputPotonganBon").val();
					var biayaBongkar = $("#idInputBongkar").val();
					var potonganLain = $("#idInputBiayaLain").val();
					var biayaMobil = $("#idInputBiayaMobil").val();
					var totalBayar = total;
					if (potonganBon > 0){
						totalBayar=totalBayar - potonganBon;
					}
					if (biayaBongkar > 0){
						totalBayar=totalBayar - biayaBongkar;
					}
					if (potonganLain > 0){
						totalBayar=totalBayar - potonganLain;
					}
					if (biayaMobil > 0){
						totalBayar=totalBayar - biayaMobil;
					}
					$("#idInputTotalBayar").val(numberFormat(totalBayar));
				} else {
					$("#idInputTotal").val(0);
					$("#idInputTotalBayar").val(0);
				}
			} else {
				$("#idInputTotalPotongan").val(0);
				$("#idInputBeratBersih").val(0);
				$("#idInputTotal").val(0);
				$("#idInputTotalBayar").val(0);
			}
		} else { 
			$("#idInputNetto").val(0)
			$("#idInputTotalPotongan").val(0);
			$("#idInputBeratBersih").val(0);
			$("#idInputTotal").val(0);
			$("#idInputTotalBayar").val(0);
		} 
	}
  
$(document).ready(function () {

  		
  		var noNota = $("#idInputNoNota").val();;
  		console.log(noNota);
  		if (noNota != null && noNota !=""){
  			var potonganBon = $("#idFieldPotonganBon").val();
  			if (potonganBon > 0){
  				$("#idFieldPotonganBon").show();
  			} else {
  				$("#idFieldPotonganBon").hide();
  			}
  	  		var biayaMobil = $("#idFieldBiayaMobil").val();
  			if (biayaMobil > 0){
  				$("#idFieldBiayaMobil").show();
  			} else {
  				$("#idFieldBiayaMobil").hide();
  			}
  			
  			var catatanVehicle = '${jembatanForm.getCatatanVehicle()}';
    		if (catatanVehicle != null && catatanVehicle != ""){
	    		$("#idCatatanVehicle").empty();
	    		$("#idCatatanVehicle").show();
        		$("#idCatatanVehicle").append("<small>Catatan kendaraan: "+catatanVehicle+"</small>");    			
    		} else {
	    		$("#idCatatanVehicle").hide();
    		}
  			var catatanSupir = '${jembatanForm.getCatatanSupir()}';
    		if (catatanSupir != null && catatanSupir != ""){
	    		$("#idCatatanSupir").empty();
	    		$("#idCatatanSupir").show();
        		$("#idCatatanSupir").append("<small>Catatan supir: "+catatanSupir+"</small>");    			
    		} else {
	    		$("#idCatatanSupir").hide();
    		}
    		var catatanPengirim = '${jembatanForm.getCatatanPengirim()}';
    		if (catatanPengirim != null && catatanPengirim != ""){
	    		$("#idCatatanPengirim").empty();
	    		$("#idCatatanPengirim").show();
        		$("#idCatatanPengirim").append("<small>Catatan pengirim: "+catatanPengirim+"</small>");    			
    		} else {
	    		$("#idCatatanPengirim").hide();
    		}
    		var hutangPengirim = '${jembatanForm.getHutangPengirim()}';
    		if (hutangPengirim > 0){
	    		$("#idCatatanHutangPengirim").empty();
	    		$("#idCatatanHutangPengirim").show();
        		$("#idCatatanHutangPengirim").append("<small>Sisa hutang pengirim: "+numberFormat(hutangPengirim)+"</small>");    			
    		} else {
	    		$("#idCatatanHutangPengirim").hide();
    		}
  		} else {
  			$("#idCatatanVehicle").hide();
  	  		$("#idCatatanPengirim").hide();
  	  		$("#idCatatanSupir").hide();
  	  		$("#idCatatanHutangPengirim").hide();
  	  		$("#idCatatanHutangSupir").hide();
  	  		$("#idFieldPotonganBon").hide();
  	  		$("#idFieldBiayaMobil").hide();
  		}
  		
  		
  		$("#idInputBruto").on("change",function(){
  			calculateTimbangan();
  		});
  		
  		$("#idInputTare").on("change",function(){
  			calculateTimbangan();
  		});
  		
  		$("#idInputPotongan").on("change",function(){
  			calculateTimbangan();
  		});
  		
  		$("#idInputHarga").on("change",function(){
  			calculateTimbangan();
  		});
  		
  		$("#idInputBongkar").on("change",function(){
  			calculateTimbangan();
  		});
  		
  		$("#idInputPotonganBon").on("change",function(){
  			calculateTimbangan();
  		});
  		
  		$("#idInputBiayaMobil").on("change",function(){
  			calculateTimbangan();
  		});
  		
  		$("#idInputBiayaLain").on("change",function(){
  			calculateTimbangan();
  		});
	
	$("#idInputVehicle").on("change",function(){
        var vehicleId=$("#idInputVehicle").val();
        
        $.ajax({
            type:"get",
            dataType:"json",
            url:"${restURL}/ajaxVehicle",
            data:"vehicleId="+vehicleId,
            success:function(response){
            	var defaultBiayaBongkar = response['defaultBiayaBongkar'];
                $("#idInputBongkar").val(defaultBiayaBongkar).trigger('change');
                
                
                var supir = response['supir'];
                var len = supir.length;

                $("#idInputSupir").empty();
                $("#idInputSupir").append("<option value=''>Pilih Supir</option>");
                for( var i = 0; i<len; i++){
                    var id = supir[i]['username'];
                    var name = supir[i]['fullname'];
                    $("#idInputSupir").append("<option value='"+id+"'>"+name+"</option>");
                  }
                

                var pengirim = response['pengirim'];
                var len = pengirim.length;

                $("#idInputPengirim").empty();
                $("#idInputPengirim").append("<option value=''>Pilih Pengirim</option>");
                for( var i = 0; i<len; i++){
                    var id = pengirim[i]['username'];
                    var name = pengirim[i]['fullname'];
                    $("#idInputPengirim").append("<option value='"+id+"'>"+name+"</option>");
                  }
                

                var catatan = response['catatan'];
      	    	if (catatan != undefined && 
                		catatan != null &&
                		catatan != ""){
                    $("#idCatatanVehicle").empty();
      	    		$("#idCatatanVehicle").show();
                    $("#idCatatanVehicle").append("<small>Catatan kendaraan: "+catatan+"</small>");
                } else {
      	    		$("#idCatatanVehicle").hide();
                }
      	  		
      	  		
                var pengirim = response['flagHormid'];
                if (pengirim == 1){
      	    		$("#idFieldBiayaMobil").show();
                } else {
                	$("#idInputBiayaMobil").val("").trigger('change');
      	    		$("#idFieldBiayaMobil").hide();
                }
            },
            error:function(data){
                alert(data);
            }
        });
	});
        

     	$("#idInputPengirim").on("change",function(){
            var usernameInput=$("#idInputPengirim").val();
            
            $.ajax({
                type:"get",
                dataType:"json",
                url:"${restURL}/ajaxPengguna",
                data:"username="+usernameInput,
                success:function(response){                	    
                	    
                	var defaultPotongan = response['defaultPotongan'];
                	if (defaultPotongan > 0){
                		$("#idInputPotongan").val(defaultPotongan).trigger('change');
                	}

                    var fullname = response['fullname'];
                	var hutang = response['hutang'];

                    if (hutang > 0){

                  		$("#idFieldPotonganBon").show();
                        $("#idCatatanHutangPengirim").empty();
          	    		$("#idCatatanHutangPengirim").show();
                		$("#idCatatanHutangPengirim").append("<small>Sisa hutang pengirim: "+numberFormat(hutang)+"</small>");
                    } else {
          	    		$("#idCatatanHutangPengirim").hide();
                  		$("#idFieldPotonganBon").hide();
              	  		$("#idInputPotonganBon").val("").trigger('change');
                    }
                	
                	
                    var catatan = response['catatan'];
                    if (catatan != undefined && 
                    		catatan != null &&
                    		catatan != ""){
                        $("#idCatatanPengirim").empty();
          	    		$("#idCatatanPengirim").show();
                    	$("#idCatatanPengirim").append("<small>Catatan pengirim: "+catatan+"</small>");
                    } else {
          	    		$("#idCatatanPengirim").hide();
                    }
                },
                error:function(data){
                    alert(data);
                }
    		});
    	});


         	$("#idInputSupir").on("change",function(){ 
                var usernameInput=$("#idInputSupir").val();
                
                $.ajax({
                    type:"get",
                    dataType:"json",
                    url:"${restURL}/ajaxPengguna",
                    data:"username="+usernameInput,
                    success:function(response){
                        var fullname = response['fullname'];
                        var catatan = response['catatan'];
                        if (catatan != undefined && 
                        		catatan != null &&
                        		catatan != ""){
                            $("#idCatatanSupir").empty();
              	    		$("#idCatatanSupir").show();
                        	$("#idCatatanSupir").append("<small>Catatan supir: "+catatan+"</small>");
                        } else {
              	    		$("#idCatatanSupir").hide();
                        }
                    },
                    error:function(data){
                        alert(data);
                    }
            	});
        });
	
	
  $('#jembatanForm').validate({
    rules: {
    	bruto:{
    		required: true,
    		digits: true
    	},
    	tare:{
            digits:true
    	},
    	potongan:{
	        maxlength: 2,
	        digits:true
    	},
    	harga: {
    		required: true,
            digits:true
    	},
    	biayaBongkar: {
	        required: true,
	        digits:true
      	},
      	biayaMobil: {
	        digits:true
		},
		potonganBon: {
	        digits:true		
	    }
    },
    messages: {
    	bruto:{
    		required: "<spring:message code='validation.notEmpty' />",
    		digits: "<spring:message code='validation.notNumber' />"
    	},
    	tare:{
            digits: "<spring:message code='validation.notNumber' />"
    	},
    	potongan:{
	        maxlength: "<spring:message code='validation.maxlength' /> 2",
	        digits: "<spring:message code='validation.notNumber' />"
    	},
    	harga: {
    		required: "<spring:message code='validation.notEmpty' />",
            digits: "<spring:message code='validation.notNumber' />"
    	},
    	biayaBongkar: {
	        required: "<spring:message code='validation.notEmpty' />",
	        digits: "<spring:message code='validation.notNumber' />"
      	},
      	biayaMobil: {
	        digits: "<spring:message code='validation.notNumber' />"
		},
		potonganBon: {
	        digits: "<spring:message code='validation.notNumber' />"	
	    }
    },
    errorElement: 'span',
    errorPlacement: function (error, element) {
      error.addClass('invalid-feedback');
      element.closest('.form-group').append(error);
    },
    highlight: function (element, errorClass, validClass) {
      $(element).addClass('is-invalid');
    },
    unhighlight: function (element, errorClass, validClass) {
      $(element).removeClass('is-invalid');
    }
  });


/* 	 $("#idInputVehicle").change(); */
});
</script>

