package it.cascino.dbas.managementbean;

import java.io.Serializable;
import java.util.List;
//import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import org.jboss.logging.Logger;
import it.cascino.dbas.dao.AsAncab0fDao;
import it.cascino.dbas.model.AsAncab0f;
import it.cascino.utils.DatabaseDB2AS400DS;
import it.cascino.utils.Utility;

//@SessionScoped
public class AsAncab0fDaoManBean implements AsAncab0fDao, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Logger
	 */
	@Inject
	private Logger log;
	
	@DatabaseDB2AS400DS
	@Inject
	private EntityManager emAS;
	
	@Inject
	private UserTransaction utx;
	
	@SuppressWarnings("unchecked")
	public List<AsAncab0f> getAll(){
		List<AsAncab0f> cod = null;
		try{
			try{
				utx.begin();
				Query query = emAS.createNamedQuery("AsAncab0f.findAll");
				cod = (List<AsAncab0f>)query.getResultList();
			}catch(NoResultException e){
				cod = null;
			}
			utx.commit();
		}catch(Exception e){
			Utility.manageException(e, utx, log);
		}
		return cod;
	}
	
//	public void salva(AsAncab0f a){
//		try{
//			try{
//				utx.begin();
//				// precodice.setId(null);
//				log.info("salva: " + a.toString());
//				em.persist(a);
//			}finally{
//				utx.commit();
//			}
//		}catch(Exception e){
//			Utility.manageException(e, utx, log);
//		}
//	}
//	
//	public void aggiorna(AsAncab0f a){
//		try{
//			try{
//				utx.begin();
//				log.info("aggiorna: " + a.toString());
//				em.merge(a);
//			}finally{
//				utx.commit();
//			}
	//	}catch(Exception e){
	//	Utility.manageException(e, utx, log);
	//}
//	}
//	
//	public void elimina(AsAncab0f aElimina){
//		// log.info("tmpDEBUGtmp: " + "> " + "elimina(" + produttoreElimina + ")");
//		try{
//			try{
//				utx.begin();
//				AsAncab0f a = em.find(AsAncab0f.class, aElimina.getMcoda());
//				log.info("elimina: " + a.toString());
//				em.remove(a);
//			}finally{
//				utx.commit();
//			}
//	}catch(Exception e){
//	Utility.manageException(e, utx, log);
//}
//	}
	
	@SuppressWarnings("unchecked")
	public List<AsAncab0f> getArticoloDaBarcode(String ccodb){ //Integer ccodb){
		List<AsAncab0f> cod = null;
		try{
			try{
				utx.begin();
				Query query = emAS.createNamedQuery("AsAncab0f.findByCcodb");
				query.setParameter("ccodb", ccodb);
				cod = (List<AsAncab0f>)query.getResultList();
			}catch(NoResultException e){
				cod = null;
			}
			utx.commit();
		}catch(Exception e){
			Utility.manageException(e, utx, log);
		}
		return cod;
	}
	
	@SuppressWarnings("unchecked")
	public List<AsAncab0f> getBarcodeDaArticolo(String ccoda){
		List<AsAncab0f> cod = null;
		try{
			try{
				utx.begin();
				Query query = emAS.createNamedQuery("AsAncab0f.findByCcoda");
				query.setParameter("ccoda", ccoda);
				cod = (List<AsAncab0f>)query.getResultList();
			}catch(NoResultException e){
				cod = null;
			}
			utx.commit();
		}catch(Exception e){
			Utility.manageException(e, utx, log);
		}
		return cod;
	}
}
