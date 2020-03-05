import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    private String path;
    private String[] files;

    public FileParser(String path) {
        this.path = path;
        this.files = this.setGroupFiles();
    }

    private String[] setGroupFiles(){
        File[] filesInFolder = new File(path).listFiles();
        int size = files.length;
        List<String> filesJSON = new ArrayList<>();
        for(int i = 0; i < size; i ++){
            File file = filesInFolder[i];
            if(file.getName().contains(".json")) {
                filesJSON.add(file.getPath());
            }
        }
        return filesJSON.toArray(new String[filesJSON.size()]);
    }

    public String[] getFiles() {
        return this.files;
    }
}

