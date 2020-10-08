no_nota varchar2(30 char) not null,
pabrik varchar2(50 char) not null,
supir varchar2(30 char) not null,
vehicle_id number(30) not null,
plate_number varchar2(10 char),
bruto number(10) not null,
tare number(10) not null,
netto number(10) not null,
potongan number(2) not null,
total_potongan number(10) not null,
berat_bersih number(10) not null,
harga number(10) not null,
uang_jalan  number(20),
created_by varchar2(30 char) not null,
catatan varchar2(300 char),


pajak  number(20),
total  number(20) not null,
total_pajak  number(20),
total_bayar  number(20) not null,
tanggal timestamp not null,
biaya_kendaraan  number(20),
total_biaya_kendaraan  number(20),
gaji_supir  number(20),
gaji_kuli  number(20),
flag_Kuli_Bayar number(1),
flag_Supir_Bayar number(1),
created_date timestamp default on null current_timestamp,

create or replace Procedure pr_penjualan_insert( 
in_noNota  IN VARCHAR2, 
in_username IN VARCHAR2, 
in_potongan IN NUMBER, 
in_bruto IN NUMBER, 
in_harga  IN NUMBER,
in_catatan IN VARCHAR2, 
in_createdBy IN VARCHAR2
)
IS
v_potonganTotal NUMBER(10,2);
v_bruto_floor NUMBER(10);
v_netto NUMBER(10,2);
v_totalHargaOri NUMBER(20);
v_totalHarga NUMBER(20);
v_pembulatan NUMBER(3);
BEGIN
	
	v_potonganTotal := ceil(in_bruto * in_potongan / 100);
	v_bruto_floor := floor(in_bruto);
	v_netto := v_bruto_floor - v_potonganTotal;
	v_totalHargaOri := floor(v_netto * in_harga);
	v_totalHarga := floor(v_netto * in_harga /1000)*1000;
	v_pembulatan := v_totalHargaOri - v_totalHarga;

	insert into tb_timbangGantung (no_nota, username, bruto, potongan, total_potongan, netto, harga, pembulatan, total, catatan, created_by)
	values (in_noNota, in_username, v_bruto_floor, in_potongan, v_potonganTotal, v_netto, in_harga, v_pembulatan, v_totalHarga, in_catatan, in_createdBy);
	
  commit;
   
EXCEPTION
WHEN OTHERS THEN
  ROLLBACK;

  pr_auditLog_insert(in_createdBy,'pr_timbangGantung_insert',SQLERRM,
  ''''||in_noNota||''','''||in_username||''','||in_potongan||','||in_bruto||','||in_harga||','''||in_catatan||''','''||in_createdBy||'''');

  raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
  
END;
/