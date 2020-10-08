create or replace Procedure pr_timbangJembatanTemp_insert( 
	in_noNota  IN VARCHAR2, 
	in_pengirim IN VARCHAR2, 
	in_supir IN VARCHAR2, 
	in_vehicle IN NUMBER,
	in_plateNumber IN VARCHAR2, 
	in_bruto IN NUMBER, 
	in_tare IN NUMBER, 
	in_potongan IN NUMBER, 
	in_harga  IN NUMBER,
	in_biayaBongkar  IN NUMBER,
	in_biayaMobil  IN NUMBER,
	in_potonganBon  IN NUMBER,
	in_biayaLain  IN NUMBER,
	in_keteranganBiayaLain IN VARCHAR2, 
	in_catatan IN VARCHAR2, 
	in_createdBy IN VARCHAR2
)
IS
	v_netto NUMBER(10);
	v_potonganTotal NUMBER(10);
	v_beratBersih number(10);
	v_total number(20);
	v_totalAsli number(20);
	v_totalBon number(20);
	v_sisaBon number(20);
	v_pembulatan NUMBER(3);
	v_totalBayar number(20);
	v_Tb1By VARCHAR2(30 char);
	v_Tb2By VARCHAR2(30 char);
BEGIN
	
	if in_bruto >0 and in_tare >0 then 
		v_netto := in_bruto - in_tare;
		
		if in_potongan > 0 then 
			v_potonganTotal :=  ceil(v_netto * in_potongan / 100);
			v_beratBersih := v_netto - v_potonganTotal;
			
			if in_harga > 0 then 
				v_totalAsli := v_beratBersih * in_harga;
				v_total := floor(v_totalAsli/1000)*1000;
				v_pembulatan := v_totalAsli - v_total;

				if in_pengirim is not null and in_potonganBon > 0 then
					select hutang into v_totalBon from tb_user where username = in_pengirim;
					v_sisaBon := v_totalBon - in_potonganBon;
				end if;
				
				v_totalBayar := v_total - nvl(in_biayaBongkar,0) - nvl(in_biayaMobil,0) - nvl(in_biayaLain,0) - nvl(in_potonganBon,0);
			end if;
		end if;
		
	else 
		v_netto := null;
		v_potonganTotal := null;
		v_beratBersih := null;
		v_total:= null;
		v_pembulatan:=null;
		v_totalBayar := null;
	end if;
	
	if in_bruto > 0 then
		v_Tb1By := in_createdBy;
	end if;
	
	if in_tare > 0 then
		v_Tb2By := in_createdBy;
	end if;

	insert into tb_timbangJembatanTemp 
		(no_nota, pengirim, supir, vehicle_id, plate_number, bruto, tare, netto, 
		potongan, total_potongan, beratBersih, harga, total, biaya_bongkar, biaya_mobil,  
		potongan_bon, sisa_bon, biaya_lain, keterangan_biaya_lain, pembulatan, 
		total_bayar, catatan, timbang1_by, timbang2_by, timestamp_timbang1, timestamp_timbang2)
	values
		(in_noNota, in_pengirim, in_supir, in_vehicle, in_plateNumber, in_bruto, in_tare, v_netto, 
		in_potongan, v_potonganTotal, v_beratBersih, in_harga, v_total, in_biayaBongkar, in_biayaMobil, 
		in_potonganBon, v_sisaBon, in_biayaLain, in_keteranganBiayaLain, v_pembulatan, 
		v_totalBayar, in_catatan, v_Tb1By, v_Tb2By, 
		(CASE WHEN in_bruto >0 then current_timestamp else null end), 
		(CASE WHEN in_tare >0 then current_timestamp else null end)
		)
	;
  commit;
   
EXCEPTION
WHEN OTHERS THEN
  ROLLBACK;

--  pr_auditLog_insert(in_createdBy,'pr_timbangGantung_insert',SQLERRM,
--  ''''||in_noNota||''','''||in_username||''','||in_potongan||','||in_bruto||','||in_harga||','''||in_catatan||''','''||in_createdBy||'''');

  raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
  
END;
/