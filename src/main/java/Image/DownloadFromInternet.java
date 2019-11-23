package Image;

import java.io.*;
import java.net.URL;

public class DownloadFromInternet {

    public static final String FOLDER_DEST = "/Users/yash/Yash/work/WouldYouRather/n/";

    public static void downloadFromInternet(String InternetPath) {
        String destPath = FOLDER_DEST + getFileName(InternetPath);
        process(InternetPath, destPath);
    }

    private static void process(String internetSource, String destination) {
        try {
            URL url = new URL(internetSource);
            InputStream in = null;
            in = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1!=(n=in.read(buf)))
            {
                out.write(buf, 0, n);
            }
            out.close();
            in.close();
            byte[] response = out.toByteArray();

            FileOutputStream fos = new FileOutputStream(destination);
            fos.write(response);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getFileName(String filePath) {
        return filePath.substring(filePath.lastIndexOf("/") + 1);
    }
}
