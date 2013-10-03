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
	}

	@Override
	public void jvnLockWrite() throws JvnException {
		// TODO Auto-generated method stub

	}

	@Override
	public void jvnUnLock() throws JvnException {
		// TODO Auto-generated method stub

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

	}

	@Override
	public Serializable jvnInvalidateWriter() throws JvnException {
		// TODO Auto-generated method stub
		// si le verrou courant est W
		// wait
		// si le verrou est WC
		// verrou = NL //notify dans unlock
		return null;
	}

	@Override
	public Serializable jvnInvalidateWriterForReader() throws JvnException {
		// TODO Auto-generated method stub
		return null;
	}

}
