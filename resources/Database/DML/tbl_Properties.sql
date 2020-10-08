/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  renaldo
 * Created: Sep 26, 2016
 */


insert into tb_properties (property_code,property_desc,datatype,property_value) values ('maxLoginAttempt','Jumlah percobaan masuk yang diperbolehkan agar Pengguna tidak terkunci. Nilai 0 utk tidak terbatas.','Angka','3');
insert into tb_properties (property_code,property_desc,datatype,property_value) values ('satuanSawit','Satuan Barang Untuk Produk Sawit','Daftar Kata','Janjang,Kg,Karung');
insert into tb_properties (property_code,property_desc,datatype,property_value) values ('idType','Tipe identitas perseorangan','Daftar Kata','KTP,SIM,PASPOR');
insert into tb_properties (property_code,property_desc,datatype,property_value) values ('village','Daftar nama desa','Daftar Kata','Makartitama,Bogatama,Gunung Tiga');
insert into tb_properties (property_code,property_desc,datatype,property_value) values ('vehicleType','Jenis angkutan yang diganakan untuk membawa barang','Daftar Kata','Tronton, Truk, Pickup, Motor');
insert into tb_properties (property_code,property_desc,datatype,property_value) values ('numberOfRecordPerPage','Jumlah baris perhalaman tabel','Angka','10');
insert into tb_properties (property_code,property_desc,datatype,property_value) values ('fieldOfWork','Bidang pekerjaan karyawan','Daftar Kata','KASIR,PEKERJA,SUPIR,PEMANEN,AGEN,PETANI');
insert into tb_properties (property_code,property_desc,datatype,property_value) values ('defaultPotongan','Potongan persen sawit secara otomatis','Angka','8');
