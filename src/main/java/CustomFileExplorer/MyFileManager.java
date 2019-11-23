package CustomFileExplorer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class MyFileManager {

    private final String folderPath = "/Users/yash/Yash/work/WouldYouRather/images_o";

    private List<File> files;

    public MyFileManager() {
        files = new ArrayList<File>(FileUtils.listFiles(new File(folderPath), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE));
    }

    public Integer size() {
        return files.size();
    }

    public List<File> getAll() {
        return files;
    }

    public String getFileName(File file) {
        return file.getName();
    }
}
