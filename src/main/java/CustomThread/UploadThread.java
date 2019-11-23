package CustomThread;

import AWSBucketUpload.S3Client;

import java.io.File;
import java.util.List;

public class UploadThread implements Runnable {

    private Integer startIndex;
    private Integer endIndex;
    private List<File> files;

    public UploadThread(List<File> files, Integer startIndex, Integer endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.files = files;
    }

    @Override
    public void run() {
        S3Client client = new S3Client();
        client.uploadFolder(this.files, this.startIndex, this.endIndex);
    }
}
