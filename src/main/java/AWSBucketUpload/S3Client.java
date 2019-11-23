package AWSBucketUpload;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;
import java.util.List;

public class S3Client {

    private final String BUCKET_NAME = "doesthisworkthree";

    public AmazonS3Client getClient() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(Credentials.ACCESS_KEY, Credentials.SECRET_ACCESS_KEY);
        AmazonS3Client client = new AmazonS3Client(credentials);
        return client;
    }

    public  void uploadFile(File fileToUpload, String key) {
        uploadFile(fileToUpload, key, BUCKET_NAME);
    }

    public  void uploadFile(File fileToUpload, String key, String bucketName) {
        System.out.format("Uploading %s to S3 bucket %s...\n", fileToUpload.getName(), bucketName);
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
        try {
            s3.putObject(
                    new PutObjectRequest(bucketName, key, fileToUpload)
                    .withCannedAcl(CannedAccessControlList.PublicRead)
            );
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }

    public  void uploadFolder(List<File> files) {
        Integer i = 1;
        Integer size = files.size();
        for (File f: files) {
            uploadFile(f, f.getName());
            System.out.println("\n * * * * * " + i++ + " of " + size + " uploaded * * * * * \n");
        }
    }

    public void uploadFolder(List<File> files, Integer startIndex, Integer endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            uploadFile(files.get(i), files.get(i).getName());
        }
    }

//    public Integer getNumberOfFiles() {
//        AmazonS3Client client = getClient();
//        client.listObjectsV2(BUCKET_NAME).setTruncated(false);
//        System.out.println(client.listObjects(BUCKET_NAME).getMarker());
//        return client.listObjectsV2(BUCKET_NAME).getKeyCount();
//    }

}
