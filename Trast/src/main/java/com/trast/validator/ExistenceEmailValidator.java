package com.trast.validator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.trast.dao.UtilisateurDAO;

@ManagedBean(name = "existenceEmailValidator", eager = true)
@SessionScoped
public class ExistenceEmailValidator implements Validator {
	private static final String EMAIL_EXISTE_DEJA = "Cette adresse email est déjà utilisée !!";
	
	@ManagedProperty(value = "#{utilisateurDao}")
	private UtilisateurDAO utilisateurDao;
	
	
	
	public UtilisateurDAO getUtilisateurDao() {
		return utilisateurDao;
	}



	public void setUtilisateurDao(UtilisateurDAO utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}



	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String email = (String)value;
		try{
			if(utilisateurDao.emailExiste(email))
			{
				  throw new ValidatorException(
	                        new FacesMessage( FacesMessage.SEVERITY_ERROR, EMAIL_EXISTE_DEJA, null ) );
			}
		}
		catch(Exception e){
			//Cas d'erreurs imprévus de la base de données
            FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_ERROR, e.getMessage(), null );
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage( component.getClientId( facesContext ), message );
		}
	}

}
