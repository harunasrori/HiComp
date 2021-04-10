package com.example.hicomp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

val ListDeskripsi = ArrayList<Barang>()

class HalamanKatalog : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonInfoSSD : Button //deklarasi bahwa ada suatu button yang digunakan
    private lateinit var buttonInfoSata : Button
    private lateinit var buttonInfoImpact : Button
    private lateinit var buttonInfoKipas : Button
    private lateinit var buttonBack : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_katalog)

        buttonInfoSSD = findViewById(R.id.infoSSD) //memanggil buttonSignUp2 dari file xml
        buttonInfoSSD.setOnClickListener(this) //mengeset bahwa tombol tersebut bisa diklik
        buttonInfoSata = findViewById(R.id.infoSata) //memanggil buttonSignUp2 dari file xml
        buttonInfoSata.setOnClickListener(this) //mengeset bahwa tombol tersebut bisa diklik
        buttonInfoImpact = findViewById(R.id.infoImpact) //memanggil buttonSignUp2 dari file xml
        buttonInfoImpact.setOnClickListener(this) //mengeset bahwa tombol tersebut bisa diklik
        buttonInfoKipas = findViewById(R.id.infoKipas) //memanggil buttonSignUp2 dari file xml
        buttonInfoKipas.setOnClickListener(this) //mengeset bahwa tombol tersebut bisa diklik
        buttonBack = findViewById(R.id.backarrow)
        buttonBack.setOnClickListener(this)
    }

    private fun setRecyclerView(){
        var infoProdukAdapter = InfoProdukAdapter(ListDeskripsi)

        //R.id.teksdeskripsi.adapter = infoProdukAdapter
    }

    override fun onClick(v: View?) {
        when(v?.id){ //ketika mengklik button, maka akan dijalankan perintah di bawah
            R.id.infoSSD -> run{
                var ssd = Barang()
                ssd.namaBarang = "SSD V-GeN"
                ssd.harga = 314999
                ssd.deskripsi = "Garansi : 3 Tahun (One to One Replacement /\n" +
                        "Rusak Langsung Tukar Barang Baru)\n\n " +
                        "Dimensi : 100 x 70 x 6 mm\n" +
                        "Speed : Read up to 510 MB/s\n" +
                        "Write up to 410 MB/s\n" +
                        "Interface : SATA 3 - 6 GB/s\n" +
                        "Form Factor : 2.5 inch\n" +
                        "Type : Internal Storage\n" +
                        "Supported : UDMA Mode 6\n" +
                        "TRIM Support : Yes (Requires OS Support)\n"
                val intentSSD = Intent(this@HalamanKatalog, InfoProduk::class.java) //perintah berganti halaman
                startActivity(intentSSD) //perintah memulai variabel intentSignup
            }
            R.id.infoSata -> run{
                var sata = Barang()
                sata.namaBarang = "HL GT20F SATA"
                sata.harga = 45299
                sata.deskripsi = "Garansi : 3 Tahun (One to One Replacement /\n" +
                        "Rusak Langsung Tukar Barang Baru)\n\n " +
                        "Dimensi : 100 x 70 x 6 mm\n" +
                        "Speed : Read up to 510 MB/s\n" +
                        "Write up to 410 MB/s\n" +
                        "Interface : SATA 3 - 6 GB/s\n" +
                        "Form Factor : 2.5 inch\n" +
                        "Type : Internal Storage\n" +
                        "Supported : UDMA Mode 6\n" +
                        "TRIM Support : Yes (Requires OS Support)\n"
                val intentSata = Intent(this@HalamanKatalog, InfoProduk::class.java) //perintah berganti halaman
                startActivity(intentSata) //perintah memulai variabel intentSignup
            }
            R.id.infoImpact -> run{
                var sata = Barang()
                sata.namaBarang = "KINGSTON HyperX Impact RAM"
                sata.harga = 746599
                sata.deskripsi = "Garansi : 3 Tahun (One to One Replacement /\n" +
                        "Rusak Langsung Tukar Barang Baru)\n\n " +
                        "Dimensi : 100 x 70 x 6 mm\n" +
                        "Speed : Read up to 510 MB/s\n" +
                        "Write up to 410 MB/s\n" +
                        "Interface : SATA 3 - 6 GB/s\n" +
                        "Form Factor : 2.5 inch\n" +
                        "Type : Internal Storage\n" +
                        "Supported : UDMA Mode 6\n" +
                        "TRIM Support : Yes (Requires OS Support)\n"
                val intentImpact = Intent(this@HalamanKatalog, InfoProduk::class.java) //perintah berganti halaman
                startActivity(intentImpact) //perintah memulai variabel intentSignup
            }
            R.id.infoKipas -> run{
                var sata = Barang()
                sata.namaBarang = "KunPeng Kipas Heatsink"
                sata.harga = 43299
                sata.deskripsi = "Garansi : 3 Tahun (One to One Replacement /\n" +
                        "Rusak Langsung Tukar Barang Baru)\n\n " +
                        "Dimensi : 100 x 70 x 6 mm\n" +
                        "Speed : Read up to 510 MB/s\n" +
                        "Write up to 410 MB/s\n" +
                        "Interface : SATA 3 - 6 GB/s\n" +
                        "Form Factor : 2.5 inch\n" +
                        "Type : Internal Storage\n" +
                        "Supported : UDMA Mode 6\n" +
                        "TRIM Support : Yes (Requires OS Support)\n"
                val intentKipas = Intent(this@HalamanKatalog, InfoProduk::class.java) //perintah berganti halaman
                startActivity(intentKipas) //perintah memulai variabel intentSignup
            }
            R.id.backarrow -> run{
                val intent = Intent(this@HalamanKatalog,HomePage::class.java)
                startActivity(intent)
            }
        }
    }
}
class Barang{
    var expandable: Boolean? = null
    var namaBarang:String? = null
    var harga:Int? = null
    var deskripsi:String? = null


}