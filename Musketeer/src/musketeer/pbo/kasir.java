 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musketeer.pbo;

/**
 *
 * @author ITD-STU
 */
public class kasir {

    private String namaPesanan;
    private String hargaPesanan;
    private int jumlah;
    private String bayar;

    public kasir() {

    }

    public kasir(String _namaPesanan, String _hargaPesanan, int _jml, String _bayar) {
        this.namaPesanan = _namaPesanan;
        this.hargaPesanan = _hargaPesanan;
        this.bayar = _bayar;
        this.jumlah = _jml;

    }
    
    public int getjumlah(){
        return jumlah;
    }
    
    public void setjumlah(int jumlah){
       this.jumlah = jumlah;
    }
    
    public String getnamaPesanan(){
        return namaPesanan;
    }
    
    public void setnamaPesanan(String namaPesanan){
        this.namaPesanan = namaPesanan;
    }
    
    public String gethargaPesanan(){
        return hargaPesanan;
    }
    
    public void sethargaPesanan(String hargaPesanan){
        this.hargaPesanan = hargaPesanan;
    }
    
    public String getbayar(){
        return bayar;
    }
    
    public void setbayar(String bayar){
        this.bayar = bayar;
    }
    
}

