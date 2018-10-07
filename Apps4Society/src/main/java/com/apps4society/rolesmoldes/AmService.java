package com.apps4society.rolesmoldes;
import com.apps4society.model.Municipios;
import com.apps4society.exceptions.ValidatorNullPointer;
import com.apps4society.model.AreaDeInteresseTuristico;
import com.apps4society.model.AreaMunicipio;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface AmService {
	
	
	List<Municipios> searchMunicipio(String namemunicipio) throws ValidatorNullPointer;
	List<AreaDeInteresseTuristico> searchAreaInteresse(String nameAreaInteresse) throws ValidatorNullPointer;
	AreaMunicipio searchAreaMunicipio(Long municipioId, Long AreaInteresseId) throws ValidatorNullPointer;
	List<AreaMunicipio> searchAllMunicipiosArea(Long id_area_interesse) throws ValidatorNullPointer;
	
	
	
	

}
