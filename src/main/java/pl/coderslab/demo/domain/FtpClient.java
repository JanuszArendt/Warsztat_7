package pl.coderslab.demo.domain;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.PrintWriter;

public class FtpClient {

    private static FTPClient ftp;

    // constructor

    public static FTPClient open(String server, int port, String user, String password) throws IOException {
        if(ftp!=null){
          return ftp;
        }
        ftp = new FTPClient();

        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));

        ftp.connect(server, port);
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new IOException("Exception in connecting to FTP Server");
        }

        ftp.login(user, password);
        return ftp;
    }

    public static void close() throws IOException {
        ftp.disconnect();
        ftp = null;
    }
}
