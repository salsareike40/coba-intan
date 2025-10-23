public class TiketKonser extends Tiket implements IPromo {
    private String namaArtis;
    private String kelas;
    private static int promoUsageCount = 0;
    private static final int MAX_PROMO_USAGE = 2;

    public TiketKonser(String nama, double harga, String artis, String kelas) {
        super(nama, harga);
        this.namaArtis = artis;
        this.kelas = kelas;
    }

    @Override
    public double hitungHargaAkhir() {
        double subtotal;
        if (kelas.equalsIgnoreCase("VIP")) {
            subtotal = hargaDasar * 2.0;
        } else if (kelas.equalsIgnoreCase("REGULER")) {
            subtotal = hargaDasar * 1.2;
        } else {
            subtotal = hargaDasar;
        }
        return subtotal - diskonPromo;
    }

    public double hitungSubtotal() {
        if (kelas.equalsIgnoreCase("VIP")) {
            return hargaDasar * 2.0;
        } else if (kelas.equalsIgnoreCase("REGULER")) {
            return hargaDasar * 1.2;
        } else {
            return hargaDasar;
        }
    }

    @Override
    public double terapkanKodePromo(String kode) {
        System.out.print("Mencoba promo '" + kode + "' untuk " + namaAcara + "\n");
        
        if (kode.equalsIgnoreCase("KONSERHEMAT")) {
            if (promoUsageCount < MAX_PROMO_USAGE) {
                diskonPromo = 50000;
                promoUsageCount++;
                System.out.println("Berhasil! Diskon Rp 50000. Sisa penggunaan: " + (MAX_PROMO_USAGE - promoUsageCount));
            } else {
                System.out.println("Gagal! Promo 'KONSERHEMAT' sudah habis.");
            }
        } else {
            System.out.println("Kode promo tidak valid.");
        }

        return diskonPromo; 
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("ID Pemesanan : " + idBeli);
        System.out.println("Nama Acara   : " + namaAcara);
        System.out.println("Harga Dasar  : Rp " + hargaDasar);
        System.out.println("Artis        : " + namaArtis);
        System.out.println("Kelas Tiket  : " + kelas);
        System.out.println("Subtotal     : Rp " + hitungSubtotal());
        if (diskonPromo > 0) {
            System.out.println("Diskon Promo : -Rp " + diskonPromo);
        }
    }
}