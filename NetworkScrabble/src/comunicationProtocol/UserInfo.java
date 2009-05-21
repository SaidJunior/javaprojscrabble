package comunicationProtocol;

import java.io.Serializable;
import java.net.InetAddress;

@SuppressWarnings("serial")
public class UserInfo implements Serializable{
	private String userName = null;
	private String userPassword = null;
	private String userEMail = null;
	private InetAddress address = null;
	
	public UserInfo(InetAddress address) {
		this.address = address;
	}
	
	public InetAddress getAddress() {
		return address;
	}
	public void setAddress(InetAddress address) {
		this.address = address;
	}	
//	
//	
//	public Socket getClientSock() {
//		return clientSock;
//	}
//	public void setClientSock(Socket clientSock) {
//		this.clientSock = clientSock;
//	}
//	public Socket getServerSock() {
//		return serverSock;
//	}
//	public void setServerSock(Socket serverSock) {
//		this.serverSock = serverSock;
//	}
//	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEMail() {
		return userEMail;
	}
	public void setUserEMail(String userEMail) {
		this.userEMail = userEMail;
	}
}
