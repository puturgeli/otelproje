package tekrarSorulari.mapDeneme;

public class depo {

 private   int kitapNumarasi=100;
 private   String kitapAdi;
 private   String yazarAdi;
 private   String yayinEvi;
 private   int yayinTarihi;
 private   double fiyat;



    public int getKitapNumarasi() {
        return kitapNumarasi;
    }

    public void setKitapNumarasi(int kitapNumarasi) {
        this.kitapNumarasi = ++kitapNumarasi;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public String getYayinEvi() {
        return yayinEvi;
    }

    public void setYayinEvi(String yayinEvi) {
        this.yayinEvi = yayinEvi;
    }

    public int getYayinTarihi() {
        return yayinTarihi;
    }

    public void setYayinTarihi(int yayinTarihi) {
        this.yayinTarihi = yayinTarihi;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public depo(String kitapAdi, String yazarAdi, String yayinEvi, int yayinTarihi, double fiyat) {
        this.kitapAdi = kitapAdi;
        this.yazarAdi = yazarAdi;
        this.yayinEvi = yayinEvi;
        this.yayinTarihi = yayinTarihi;
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return  " Kitap Adı= \"" + kitapAdi + "\"" +
                ", Yazar Adı= \"" + yazarAdi + "\"" +
                ", Yayın Evi= \"" + yayinEvi + "\" " +
                ", Yayin Tarihi= " + yayinTarihi +
                ", Fiyat= " + fiyat ;
    }
}
