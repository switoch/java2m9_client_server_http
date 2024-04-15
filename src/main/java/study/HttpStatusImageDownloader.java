package study;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;

public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code) {
        try {

            String path = "C:\\Users\\HP\\IdeaProjects\\java2m9\\src\\main\\resources\\img.jpg";
            String url = HttpStatusChecker.getStatusImage(code);
            URI uri = new URI(url);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();

            connection.setRequestMethod("GET");

            InputStream inputStream = connection.getInputStream();

            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(path);

            int bytesRead = -1;
            byte[] buffer = new byte[4096];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
