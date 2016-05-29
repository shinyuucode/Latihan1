package riksameidy.com.latihan_bareng1;

/**
 * Created by ASUS on 28/05/2016.
 */
public class Dosen {

    private long nim;
    private  String name,email,password;
    private Kelas[] kelas;
    private int jumlahKelas = 0;
    private final int MAX_KELAS = 10;

    public Dosen(String name, long nim, String password, String email) {
        this.name = name;
        this.nim = nim;
        this.password = password;
        this.email = email;
    }

    public Kelas getKelas(int n){
        return kelas[n];
    }

    public void addKelas(int jumlahMhs, int kodekelas, String namaKelas, String namaMK){
        if(jumlahKelas<MAX_KELAS){
            kelas[jumlahKelas] = new Kelas(jumlahMhs,kodekelas,namaKelas,namaMK);
            jumlahKelas++;
        }
    }

    public int getJumlahKelas(){
        return jumlahKelas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNim() {
        return nim;
    }

    public void setNim(long nim) {
        this.nim = nim;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
}
