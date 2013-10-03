package jvn;

public class Register {
	private String jvnName;
	private JvnObject jvnObj;
	private JvnRemoteServer jvnServer;
	
	public Register (String name, JvnObject obj, JvnRemoteServer js){
		jvnServer = js;
		jvnName = name;
		jvnObj = obj;
	}
	public JvnRemoteServer getJvnServer() {
		return jvnServer;
	}
	public void setJvnServer(JvnRemoteServer jvnServer) {
		this.jvnServer = jvnServer;
	}
	public String getJvnName() {
		return jvnName;
	}
	public void setJvnName(String jvnName) {
		this.jvnName = jvnName;
	}
	public JvnObject getJvnObj() {
		return jvnObj;
	}
	public void setJvnObj(JvnObject jvnObj) {
		this.jvnObj = jvnObj;
	}

}
