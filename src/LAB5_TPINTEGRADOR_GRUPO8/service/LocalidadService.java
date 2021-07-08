package LAB5_TPINTEGRADOR_GRUPO8.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LAB5_TPINTEGRADOR_GRUPO8.dao.LocalidadDao;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Localidad;
import LAB5_TPINTEGRADOR_GRUPO8.entidad.Provincia;

public class LocalidadService {
	public static Map<Provincia,List<Localidad>> obtenerLocalidadesXProvincia(){
		Map<Provincia,List<Localidad>> result = new HashMap<Provincia,List<Localidad>>();
		try {
			List<Localidad> localidades = LocalidadDao.obtenerTodasLasLocalidades();
			for(Localidad loc : localidades) {
				if(!result.containsKey(loc.getProvincia())) {
					result.put(loc.getProvincia(), new ArrayList<Localidad>());
				}
				result.get(loc.getProvincia()).add(loc);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("@@ Localidades size "+result.size());
		return result;
	}
	
	public static Localidad obtenerLocalidadPorId(Integer localidadId){ 
		try {
			return LocalidadDao.obtenerLocalidadPorId(localidadId); 
		} catch (Exception ex) {
			return null;
		}  
	}
	
	
	
}
