/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  renaldo
 * Created: Sep 26, 2016
 */

insert into tbl_properties (code,"name",description,datatype,"value")
values 
('satuanSawit','Satuan Barang Sawit','Satuan Barang Untuk Produk Sawit','List<String>','["Janjang","Kg","Karung"]'),
('idType','Tipe Identitas','Tipe identitas perseorangan','List<String>','["KTP","SIM","PASPOR"]'),
('village','Nama Desa','Daftar nama desa','List<String>','["Makartitama","Bogatama","Gunung Tiga"]'),
('vehicleType','Jenis Angkutan','Daftar jenis angkutan yang diganakan untuk membawa barang','List<String>','["Gerobak","Cold Diesel","Pickup","Fuso"]'),
('fieldOfWork','Bidang Pekerjaan','Bidang pekerjaan karyawan','List<String>','["KASIR","KULI MUAT","SUPIR","PEMANEN"]')--,
--('timbangMuatGajiKaryawan','Penggajian Karyawan Muat Sawit','Gaji Karyawan Muat Sawit Rp/Kg','Map<String,String>','{"KULI MUAT":"10","SUPIR":"5"}')
;