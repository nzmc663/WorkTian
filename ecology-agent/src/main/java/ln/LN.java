package ln;

import java.io.File;

public class LN {
    public int CkHrmnum() {
       return 999999;
    }

    public int CkUnusedHrmnum() {
       return 999997;
    }

    public int CkUsedHrmnum() {
       return 2;
    }

    public String getScCount() {
        return String.valueOf(999999);
    }

    public String CkLicense(String currentdate) {
        return String.valueOf(1);
    }

    public boolean checkLicense(String licensefilepath) {
        return true;
    }

}
