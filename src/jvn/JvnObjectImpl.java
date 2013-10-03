package jvn;

import java.io.Serializable;

public class JvnObjectImpl implements JvnObject {

	/**
	 * Cette classe implement l'interface jvnObject
	 */
	private static final long serialVersionUID = 1L;
	//variable permettant de garder le verou en cours.
	private String lock;
	//référence vers l'objet partégé applicatif
	private Object objet;
	//l'identicateur unique
	private int id;
	
	//l'id du serveur local
	private JvnLocalServer jvnServ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Object getObjet() {
		return objet;
	}
	public void setObjet(Object objet) {
		this.objet = objet;
	}
	public String getlock() {
		return lock;
	}
	public void setlock(String lock) {
		this.lock = lock;
	}
	
	

	@Override
	public void jvnLockRead() throws JvnException {
		// TODO Auto-generated method stub
			jvnServ.jvnLockRead(id);			
	}

	@Override
	public void jvnLockWrite() throws JvnException {
		// TODO Auto-generated method stub
			jvnServ.jvnLockWrite(id);
		
	}

	@Override
	public void jvnUnLock() throws JvnException {
		// TODO Auto-generated method stub
		notify();

	}

	@Override
	public int jvnGetObjectId() throws JvnException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Serializable jvnGetObjectState() throws JvnException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void jvnInvalidateReader() throws JvnException {
		// TODO Auto-generated method stub
		if (lock.compareTo("R")==0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (lock.compareTo("RC")==0) {
			lock="NL";
			return;
		}
		lock="NL";
		return;
	}

	@Override
	public Serializable jvnInvalidateWriter() throws JvnException {
		// TODO Auto-generated method stub
		if (lock.compareTo("W")==0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (lock.compareTo("WC")==0) {
			lock="NL";
			return this;
		}
		lock="NL";
		return null;
	}

	@Override
	public Serializable jvnInvalidateWriterForReader() throws JvnException {
		// TODO Auto-generated method stub
		if (lock.compareTo("RWC")==0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (lock.compareTo("WC")==0) {
			lock="NL";
			return this;
		}
		lock="NL";
		return null;
	}

}
