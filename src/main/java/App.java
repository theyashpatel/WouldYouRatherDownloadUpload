import AWSBucketUpload.S3Client;
import CustomFileExplorer.MyFileManager;
import CustomThread.ThreadOne;
import CustomThread.UploadThread;
import com.amazonaws.services.s3.AmazonS3Client;

import java.io.File;
import java.util.List;

public class App {
    public static void main(String[] args) {
//        for (int i = 0; i < 11; i++) {
//            Thread t = new Thread(new ThreadOne());
//            t.start();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
        MyFileManager fileManager = new MyFileManager();
        List<File> files = fileManager.getAll();
        Thread t1 = new Thread(new UploadThread(files, 0, 25000));
        Thread t11 = new Thread(new UploadThread(files, 25001, 50000));
        Thread t2 = new Thread(new UploadThread(files, 50001, 75000));
        Thread t22 = new Thread(new UploadThread(files, 75001, 100000));
        Thread t3 = new Thread(new UploadThread(files, 100001, 125000));
        Thread t33 = new Thread(new UploadThread(files, 125001, 150000));
        Thread t4 = new Thread(new UploadThread(files, 150001, 175000));
        Thread t44 = new Thread(new UploadThread(files, 175001, files.size() - 1));


        t1.start();
        t11.start();
        t2.start();
        t22.start();
        t3.start();
        t33.start();
        t4.start();
        t44.start();
    }
}