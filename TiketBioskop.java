public class TiketBioskop extends Tiket implements IPromo {
    private String kursi;
    private String kelas;
    private static int promoUsageCount = 0;
    private static final int MAX_PROMO_USAGE = 2;

    public TiketBioskop(String nama, double harga, String kursi, String kelas) {
        super(nama, harga);
        this.kursi = kursi;
        this.kelas = kelas;
    }

    @Override
    public double hitungHargaAkhir() {
        double subtotal;
        if (kelas.equalsIgnoreCase("GOLD")) {
            subtotal = hargaDasar * 1.5;
        } else if (kelas.equalsIgnoreCase("REGULER")) {
            subtotal = hargaDasar * 1.1;
        } else {
            subtotal = hargaDasar;
        }
        return subtotal - diskonPromo;
    }

    public double hitungSubtotal() {
        if (kelas.equalsIgnoreCase("GOLD")) {
            return hargaDasar * 1.5;
        } else if (kelas.equalsIgnoreCase("REGULER")) {
            return hargaDasar * 1.1;
        } else {
            return hargaDasar;
        }
    }

    @Override
    public double terapkanKodePromo(String kode) {
        System.out.print("Mencoba promo '" + kode + "' untuk " + namaAcara + "\n");
        
        if (kode.equalsIgnoreCase("HEMATXXI")) {
            if (promoUsageCount < MAX_PROMO_USAGE) {
                diskonPromo = 10000;
                promoUsageCount++;
                System.out.println("Berhasil! Diskon Rp 10000. Sisa penggunaan: " + (MAX_PROMO_USAGE - promoUsageCount));
            } else {
                System.out.println("Gagal! Promo 'HEMATXXI' sudah habis.");
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
        System.out.println("Nomor Kursi  : " + kursi);
        System.out.println("Kelas Tiket  : " + kelas);
        System.out.println("Subtotal     : Rp " + hitungSubtotal());
        if (diskonPromo > 0) {
            System.out.println("Diskon Promo : -Rp " + diskonPromo);
        }
    }
}