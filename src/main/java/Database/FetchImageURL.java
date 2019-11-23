package Database;

import Image.DownloadFromInternet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static Image.DownloadFromInternet.downloadFromInternet;

public class FetchImageURL {

    private static final Connection CONN = DBConnection.getConnection();
    private static Statement STMT = null;
    private static ResultSet RS = null;

    public static final String IMAGE_QUERY = "select id, oneimage, twoimage from Question where id > 100000";

    public static void fetch() {
        try {
            STMT = CONN.createStatement();
            RS = STMT.executeQuery(IMAGE_QUERY);
            while (RS.next()) {
                Question q = new Question();
                q.setId(RS.getInt("id"));
                q.setOneImage(RS.getString("oneimage"));
                q.setTwoImage(RS.getString("twoimage"));

                download(q);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void download(Question question) {
        System.out.println("Thread: " + Thread.currentThread().getId());
        System.out.println(question.getId() + "\n");
        downloadFromInternet(question.getOneImage());
        System.out.println(question.getOneImage() + " downloaded\n");
        downloadFromInternet(question.getTwoImage());
        System.out.println(question.getTwoImage() + " downloaded\n\n");
    }
}
