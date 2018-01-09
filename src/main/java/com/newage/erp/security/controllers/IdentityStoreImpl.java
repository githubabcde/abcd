package com.newage.erp.security.controllers;

import static java.util.Arrays.asList;
import java.util.HashSet;
import javax.enterprise.context.RequestScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import static javax.security.enterprise.identitystore.CredentialValidationResult.NOT_VALIDATED_RESULT;
import javax.security.enterprise.identitystore.IdentityStore;

/**
 *
 * @author mohammed
 */
@RequestScoped
public class IdentityStoreImpl implements IdentityStore {

    @Override
    public CredentialValidationResult validate(Credential credential) {
        System.out.println("com.newage.erp.security.controllers.IdentityStoreImpl.validate()");
        if (credential instanceof UsernamePasswordCredential) {
            return validate((UsernamePasswordCredential) credential);
        }
        return NOT_VALIDATED_RESULT;
    }

    private CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        if (usernamePasswordCredential.getCaller().equals("reza") && usernamePasswordCredential.getPassword().compareTo("secret1")) {
            return new CredentialValidationResult("reza", new HashSet<>(asList("foo", "bar")));
        }
        return INVALID_RESULT;
    }
}
