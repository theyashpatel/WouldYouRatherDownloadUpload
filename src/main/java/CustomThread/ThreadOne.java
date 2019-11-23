package CustomThread;

import Database.FetchImageURL;
import Image.DownloadFromInternet;

public class ThreadOne implements Runnable {
    @Override
    public void run() {
        FetchImageURL.fetch();
    }
}
