package com.trast.dao;

import java.util.List;
import com.trast.model.Formation;

public interface FormationDAO {
	public List<Formation> getFormations();
	public Formation getFormation(Long id);
	public void ajouterFormation(Formation formation );
	public void supprimerFormation(Long id);
	public void modifierFormation(Formation formation );

}
