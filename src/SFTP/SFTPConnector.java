package SFTP;

import java.io.IOException;
import java.util.Properties;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SFTPConnector {
	private Session session;
	public void connect(String username, String password, String host, int port)
			throws JSchException, IllegalAccessException {
		if (this.session == null || !this.session.isConnected()) {
			JSch jsch = new JSch();

			this.session = jsch.getSession(username, host, port);
			this.session.setPassword(password);

			// Parametro para no validar key de conexion.
			
			Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
			this.session.setConfig(config);

			this.session.connect();
		} else {
			throw new IllegalAccessException("Sesion SFTP ya iniciada.");
		}
	}
	
	public final void addFile(String ftpPath, String filePath, String fileName)
			throws IllegalAccessException, IOException, SftpException, JSchException {
		if (this.session != null && this.session.isConnected()) {

			// Abrimos un canal SFTP. Es como abrir una consola.
			ChannelSftp channelSftp = (ChannelSftp) this.session.openChannel("sftp");

			// Nos ubicamos en el directorio del FTP.
			
			
			channelSftp.connect();
			channelSftp.cd("/ftp/SHS");;
			System.out.println(String.format("Creando archivo %s en el " + "directorio %s", fileName, channelSftp.getHome()));
			channelSftp.put(filePath, fileName);

			System.out.println("Archivo subido exitosamente");

			channelSftp.exit();
			channelSftp.disconnect();
		} else {
			throw new IllegalAccessException("No existe sesion SFTP iniciada.");
		}
	}

	/**
	 * Cierra la sesi&oacute;n SFTP.
	 */
	public final void disconnect() {
		this.session.disconnect();
	}
}
