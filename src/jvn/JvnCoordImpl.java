/***
 * JAVANAISE Implementation
 * JvnServerImpl class
 * Contact: 
 *
 * Authors: 
 */

package jvn;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.io.Serializable;


public class JvnCoordImpl 	
              extends UnicastRemoteObject 
							implements JvnRemoteCoord{
	

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//table d'objet partagé
	private HashMap<Integer, JvnObject> jvnTableJvnObjet;
	//Liste des objets avec leurs noms
	private ArrayList<Register> jvnRegister;
	//Liste des objet avec leurs verrous
	private ArrayList<Verrou> jvnListVerrou;
	//identifiant des objet JVN
	private int jvnIdentifiant;
	//condition pour l'exclusion mutuelle
	private final Lock jvnLock = new ReentrantLock();
	

/**
  * Default constructor
  * @throws JvnException
  **/
	private JvnCoordImpl() throws Exception {
		jvnIdentifiant = 0;
		jvnTableJvnObjet = new HashMap<Integer, JvnObject>();
		jvnRegister = new ArrayList<Register>();
		jvnListVerrou = new ArrayList<Verrou>(); 
		jvnTableJvnObjet = new HashMap<Integer, JvnObject>();
		
	}

  /**
  *  Allocate a NEW JVN object id (usually allocated to a 
  *  newly created JVN object)
  * @throws java.rmi.RemoteException,JvnException
  **/
  synchronized public int jvnGetObjectId()
  throws java.rmi.RemoteException,jvn.JvnException {
		return jvnIdentifiant; 
  }
  
  /**
  * Associate a symbolic name with a JVN object
  * @param jon : the JVN object name
  * @param jo  : the JVN object 
  * @param joi : the JVN object identification
  * @param js  : the remote reference of the JVNServer
  * @throws java.rmi.RemoteException,JvnException
  **/
  synchronized public void jvnRegisterObject(String jon, JvnObject jo, JvnRemoteServer js)
  throws java.rmi.RemoteException,jvn.JvnException{
    Register jvnRegis = new Register(jon, jo, js);
    jvnRegister.add(jvnRegis);
    Verrou verrou = new Verrou(jo.getlock(), js);
    jvnListVerrou.add(verrou);
    jvnTableJvnObjet.put(jvnIdentifiant++, jo);
  }
  
  /**
  * Get the reference of a JVN object managed by a given JVN server 
  * @param jon : the JVN object name
  * @param js : the remote reference of the JVNServer
  * @throws java.rmi.RemoteException,JvnException
  **/
  synchronized public JvnObject jvnLookupObject(String jon, JvnRemoteServer js)
  throws java.rmi.RemoteException,jvn.JvnException{
    for(Register r:jvnRegister){
    	if (jon.compareTo(r.getJvnName())==0)
    		return r.getJvnObj();
    }
    return null;
  }
  
  /**
  * Get a Read lock on a JVN object managed by a given JVN server 
  * @param joi : the JVN object identification
  * @param js  : the remote reference of the server
  * @return the current JVN object state
  * @throws java.rmi.RemoteException, JvnException
  **/
  synchronized public Serializable jvnLockRead(int joi, JvnRemoteServer js)
   throws java.rmi.RemoteException, JvnException{
    JvnObject jo = jvnTableJvnObjet.get(joi);
    return null;
   }

  /**
  * Get a Write lock on a JVN object managed by a given JVN server 
  * @param joi : the JVN object identification
  * @param js  : the remote reference of the server
  * @return the current JVN object state
  * @throws java.rmi.RemoteException, JvnException
  **/
  synchronized public Serializable jvnLockWrite(int joi, JvnRemoteServer js)
   throws java.rmi.RemoteException, JvnException{
    // to be completed
    return null;
   }

	/**
	* A JVN server terminates
	* @param js  : the remote reference of the server
	* @throws java.rmi.RemoteException, JvnException
	**/
  synchronized public void jvnTerminate(JvnRemoteServer js)
	 throws java.rmi.RemoteException, JvnException {
	 // to be completed
    }
}

 
