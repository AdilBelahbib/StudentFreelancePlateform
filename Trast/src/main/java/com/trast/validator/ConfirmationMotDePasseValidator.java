package com.trast.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator( value = "confirmationMotDePasseValidator" )
public class ConfirmationMotDePasseValidator implements Validator {
	
    private static final String CHAMP_MOT_DE_PASSE       = "composantMotDePasse";
    private static final String MOTS_DE_PASSE_DIFFERENTS = "Le mot de passe et la confirmation doivent être identiques !!";
    
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
        
        //Récupération de l'attribut mot de passe parmi la liste des attributs
			//du composant confirmation
        UIInput composantMotDePasse = (UIInput) component.getAttributes().get( CHAMP_MOT_DE_PASSE );
        
        //Récupération du mot de passe saisi        
        String motDePasse = (String) composantMotDePasse.getValue();
        
        //Récupération du mot de passe confirmé
        String confirmation = (String) value;

        //Envoi de message d'erreur en cas de non correspondance entre les mots de passes
        if ( confirmation != null && !confirmation.equals( motDePasse ) ) {
            
            throw new ValidatorException(
                    new FacesMessage( FacesMessage.SEVERITY_ERROR, MOTS_DE_PASSE_DIFFERENTS, null ) );
        }
	}

}
