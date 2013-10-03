package jvn;

public class Verrou {
	
	private String jvnLock;
	private JvnRemoteServer js;
	
	public Verrou (String lock, JvnRemoteServer obj){
		jvnLock = lock;
		js = obj;
	}
	
	public String getLock() {
		return jvnLock;
	}
	public void setLock(String lock) {
		this.jvnLock = lock;
	}
	public JvnRemoteServer getObj() {
		return js;
	}
	public void setObj(JvnRemoteServer obj) {
		this.js = obj;
	}
	

}
