import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class savefile {
    static String savefile(String path) {
        File f = new File(path);
        try {
            FileInputStream fis = new FileInputStream(f);
            String extension = path.substring(path.lastIndexOf("."));
            System.out.println("Extension" + extension);
            String fpath = System.getProperty("user.home")+"\\screenshots\\" + System.currentTimeMillis() + "" + extension;
            FileOutputStream fos = new FileOutputStream(fpath);
            long fsize = f.length();
            int r = 0, count = 0;
            byte b[] = new byte[100000];
            while (true) {
                r = fis.read(b, 0, b.length);
                fos.write(b, 0, r);
                count = count + r;
                if (count == fsize) {
                    break;
                }

            }
            fis.close();
            fos.close();
            System.out.println("File copied");
            return fpath;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
