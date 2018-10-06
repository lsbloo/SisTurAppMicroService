package com.apps4society.rolesmoldes;
import com.apps4society.model.Municipios;
import com.apps4society.model.AreaDeInteresseTuristico;
import com.apps4society.model.AreaMunicipio;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface AmService {
	
	
	List<Municipios> searchMunicipio(String namemunicipio);
	List<AreaDeInteresseTuristico> searchAreaInteresse(String nameAreaInteresse);
	List<AreaMunicipio> searchAreaMunicipio(String nameAreaMunicipio);
	
	
	

}
