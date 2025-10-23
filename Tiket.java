public abstract class Tiket {
    protected String idBeli;
    protected String namaAcara;
    protected double hargaDasar;
    protected double diskonPromo;
    protected static int idCounter = 1;

    public Tiket(String namaAcara, double hargaDasar) {
        this.namaAcara = namaAcara;
        this.hargaDasar = hargaDasar;
        this.idBeli = "TIX-" + idCounter++;
        this.diskonPromo = 0;
    }

    public String getIdBeli() {
        return idBeli;
    }

    public abstract double hitungHargaAkhir();

    public void tampilkanInfo() {

    }
}