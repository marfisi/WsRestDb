package it.cascino.dbas.dao;

import java.util.List;
import it.cascino.dbas.model.AsAncab0f;

public interface AsAncab0fDao{
	List<AsAncab0f> getAll();
	
//	void salva(AsAncab0f a);
//	
//	void aggiorna(AsAncab0f a);
//	
//	void elimina(AsAncab0f a);

	//AsAncab0f getArticoloDaBarcode(Integer ccodb);
	List<AsAncab0f> getArticoloDaBarcode(String ccobd); //Integer ccodb);
	
	List<AsAncab0f> getBarcodeDaArticolo(String ccoda);
}
