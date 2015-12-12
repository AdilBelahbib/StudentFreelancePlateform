package com.trast.dao;

import java.util.List;
import com.trast.model.Particulier;

public interface ParticulierDAO {
	public List<Particulier> getParticuliers();
	public Particulier getParticulier(Long id);
	public void ajouterParticulier(Particulier particulier );
	public void supprimerParticulier(Long id);
	public void modifierParticulier(Particulier particulier );
	public boolean nomUtilisateurExiste(String nomUtilisateur);

}
