package it.cascino.dbas.model;

import java.io.Serializable;
import javax.persistence.*;
import org.apache.commons.lang3.StringUtils;
import javax.inject.Inject;
import org.jboss.logging.Logger;

/**
* The persistent class for the cas_dat/ancab0f database table.
* 
*/
@Entity(name="Ancab0f")
@NamedQueries({
	@NamedQuery(name = "AsAncab0f.findAll", query = "SELECT a FROM Ancab0f a"),
	@NamedQuery(name = "AsAncab0f.findByCcodb", query = "SELECT a FROM Ancab0f a WHERE a.ccodb = :ccodb"),
	@NamedQuery(name = "AsAncab0f.findByCcoda", query = "SELECT a FROM Ancab0f a WHERE a.ccoda = :ccoda")
})
public class AsAncab0f implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Logger
	 */
	@Inject
	private Logger log;
	
	private String ccodb;		// codice a barre
	private String ccoda;	// codice articolo
	
	public AsAncab0f(){
	}
	
	public AsAncab0f(String ccodb, String ccoda){
		super();
		this.ccodb = ccodb;
		this.ccoda = ccoda;
	}

	@Id
	public String getCcodb(){
		return ccodb;
	}

	public void setCcodb(String ccodb){
		this.ccodb = ccodb;
	}

	public String getCcoda(){
		return ccoda;
	}

	public void setCcoda(String ccoda){
		this.ccoda = ccoda;
	}
	
	@Override
	public boolean equals(Object obj){
		if(log != null){
			log.info("tmpDEBUGtmp: " + "> " + "equals(" + obj + ")");
			log.info("tmpDEBUGtmp: " + "ccodb: " + ccodb);
		}
		if(obj instanceof AsAncab0f){
			if(this.ccodb == ((AsAncab0f)obj).ccodb){
				return true;
			}else{
				return false;
			}
		}
		if(log != null){
			log.info("tmpDEBUGtmp: " + "< " + "equals");
		}
		return false;
	}

	@Override
	public int hashCode(){
		if(log != null){
			log.info("tmpDEBUGtmp: " + "> " + "hashCode(" + ")");
			log.info("tmpDEBUGtmp: " + "ccodb: " + ccodb);
		}
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccodb == null) ? 0 : ccodb.hashCode());
		result = prime * result + ((ccoda == null) ? 0 : ccoda.hashCode());
		if(log != null){
			log.info("tmpDEBUGtmp: " + "< " + "hashCode");
		}
		return result;
	}
	
	@Override
	public String toString(){
		if(log != null){
			log.info("tmpDEBUGtmp: " + "> " + "toString(" + ")");
			log.info("tmpDEBUGtmp: " + "ccodb: " + ccodb);
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1));
		stringBuilder.append("[");
		stringBuilder.append("ccodb=" + StringUtils.trim(ccodb)).append(", ");
		stringBuilder.append("ccoda=" + StringUtils.trim(ccoda));
		stringBuilder.append("]");
		if(log != null){
			log.info("tmpDEBUGtmp: " + "< " + "toString");
		}
		return stringBuilder.toString();
	}
}