import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Tester {
    public FTP_Client ftp_client;

    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.start();
    }

    public void start(){
        ftp_client = new FTP_Client();
    }
}
