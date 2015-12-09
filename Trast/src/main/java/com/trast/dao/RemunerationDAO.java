package com.trast.dao;

import java.util.List;
import com.trast.model.Remuneration;

public interface RemunerationDAO {
	public List<Remuneration> getRemunerations();
	public Remuneration getRemuneration(Long id);
	public void ajouterRemuneration(Remuneration remuneration );
	public void supprimerRemuneration(Long id);
	public void modifierRemuneration(Remuneration remuneration );

}
