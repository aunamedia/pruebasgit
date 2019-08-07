package SFTP;

import java.io.IOException;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

public class SFTPConnection {
	SFTPConnector sshConnector;

	public SFTPConnection() {
		sshConnector = new SFTPConnector();
	}

	public void addFile(String USERNAME, String PASSWORD, String HOST, int PORT, String PATH, String NAMEFILE) {
		try {

			sshConnector.connect(USERNAME, PASSWORD, HOST, PORT);
			sshConnector.addFile("", PATH, NAMEFILE); // "C:\\TEMP\\FRG.txt",
														// "frg.txt");
			sshConnector.disconnect();
		} catch (JSchException ex) {
			ex.printStackTrace();

			System.out.println(ex.getMessage());
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();

			System.out.println(ex.getMessage());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SftpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception, SftpException {
		SFTPConnection s =new SFTPConnection();
		s.addFile("shs","shs2010", "10.234.254.52",22,"C:\\TEMP\\FRG.txt","frg.txt");
	}

}
