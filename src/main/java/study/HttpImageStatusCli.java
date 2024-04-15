package study;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public static void askStatus() throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);
            int code = scanner.nextInt();
            try{
                HttpStatusImageDownloader.downloadStatusImage(code);
            } catch (Exception e){
                System.out.println("There is not image for HTTP status " + code);
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid number");
        }
    }
}
