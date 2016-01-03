package com.trast.dao;

import java.util.List;

import com.trast.model.Badge;

public interface BadgeDAO {

	public List<Badge> getBadges();

	public Badge getBadgeById(Long id);

	public void ajouterBadge(Badge badge);

	public void modifierBadge(Badge badge);

	public void supprimerBadge(Badge badge);
}
