package com.trast.dao;

import java.util.List;

import com.trast.model.Livrable;

public interface LivrableDAO {

	public List<Livrable> getLivrables();

	public Livrable getLivrableById(Long id);

	public void ajouterLivrable(Livrable livrable);

	public void modifierLivrable(Livrable livrable);

	public void supprimerLivrable(Livrable livrable);

}
