package it.cascino.utils;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;

public class Resources{
	
	@Produces
	@PersistenceContext(unitName = "Postgresql")
    @DatabasePostgresqlDS
	private EntityManager emPg;
	
	@Produces
	@PersistenceContext(unitName = "DB2AS400")
    @DatabaseDB2AS400DS
	private EntityManager emAs;
	
	@Produces
	public Logger produceLog(InjectionPoint injectionPoint){
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
}
