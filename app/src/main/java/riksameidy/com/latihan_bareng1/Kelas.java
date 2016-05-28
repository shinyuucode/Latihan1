package riksameidy.com.latihan_bareng1;

/**
 * Created by ASUS on 28/05/2016.
 */
public class Kelas {

    private int kodekelas;
    private String namaKelas,namaMK;
    private int jumlahMhs;

    public Kelas(int jumlahMhs, int kodekelas, String namaKelas, String namaMK) {
        this.jumlahMhs = jumlahMhs;
        this.kodekelas = kodekelas;
        this.namaKelas = namaKelas;
        this.namaMK = namaMK;
    }

    public int getJumlahMhs() {
        return jumlahMhs;
    }

    public void setJumlahMhs(int jumlahMhs) {
        this.jumlahMhs = jumlahMhs;
    }

    public int getKodekelas() {
        return kodekelas;
    }

    public void setKodekelas(int kodekelas) {
        this.kodekelas = kodekelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getNamaMK() {
        return namaMK;
    }

    public void setNamaMK(String namaMK) {
        this.namaMK = namaMK;
    }
}
