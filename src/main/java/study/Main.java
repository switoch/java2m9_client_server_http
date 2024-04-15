package study;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("HttpStatusChecker.getStatusImage(100) = " + HttpStatusChecker.getStatusImage(100));
        HttpStatusImageDownloader.downloadStatusImage(100);
        HttpImageStatusCli.askStatus();
    }
}
