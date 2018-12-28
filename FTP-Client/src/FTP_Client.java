import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.net.Socket;

public class FTP_Client extends FTPClient {

    public Interface ftp_interface;
    private User user;
    private Socket socket;

    public FTP_Client(){
        super();
        FTPClientConfig config = new FTPClientConfig();
        ftp_interface = new Interface(640, 480);
        ftp_interface.openInterface();
        setup();
    }

    public void setup(){
        try {
            int reply;
            this.connect(ftp_interface.getServerUrl());
            System.out.println("Connected to " + ftp_interface.getServerUrl());
            reply = getReplyCode();
            if(FTPReply.isPositiveCompletion(reply)){
                disconnect();
                System.err.println("FTP server refused connection.");
                System.exit(1);
            }
            logout();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
