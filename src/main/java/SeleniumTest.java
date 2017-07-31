import com.jcraft.jsch.*;

/**
 * Created by omm on 6/23/2017.
 */
public class SeleniumTest {

    public static void main(String[] args) throws JSchException, SftpException {
        try {
            JSch jsch = new JSch();

            String user = "ontour-stg";
            String host = "492565-srv29.eceit.net";
            int port = 22;
            String privateKey = "C:\\Users\\omm\\SFTP3.ppk";

            jsch.addIdentity(privateKey);
            System.out.println("identity added ");

            Session session = jsch.getSession(user, host, port);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            System.out.println("session created.");

            session.connect();
            System.out.println("session connected.....");

            Channel channel = session.openChannel("sftp");
            channel.setInputStream(System.in);
            channel.setOutputStream(System.out);
            channel.connect();
            System.out.println("shell channel connected....");

            ChannelSftp c = (ChannelSftp) channel;

            String fileName = "test.txt";
            c.put(fileName, "/ontour-stg/export");
            c.exit();
            System.out.println("done");

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
