package com.newage.erp.security;

import com.newage.erp.security.entities.SecurityUser;
import com.newage.erp.security.services.SecurityUserService;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.security.enterprise.CallerPrincipal;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import static javax.security.enterprise.identitystore.CredentialValidationResult.NOT_VALIDATED_RESULT;
import javax.security.enterprise.identitystore.IdentityStore;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author mohammed
 */
@RequestScoped
public class IdentityStoreImpl implements IdentityStore {

    @Inject
    private SecurityUserService userService;

    @Override
    public CredentialValidationResult validate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            return validate((UsernamePasswordCredential) credential);
        }
        return NOT_VALIDATED_RESULT;
    }

    private CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        SecurityUser user = userService.findByUserNamePassword(usernamePasswordCredential.getCaller(), usernamePasswordCredential.getPasswordAsString());
        if (Objects.nonNull(user)) {
            Set<String> groups = new HashSet<>();
            user.getGroups().forEach((group) -> {
                group.getPermissions().forEach((permission) -> {
                    groups.add(permission.getName());
                });
            });
            user.getPermissions().forEach((permission) -> {
                groups.add(permission.getName());
            });
            return new CredentialValidationResult(new CallerPrincipal("reza"), groups);
        }
        return INVALID_RESULT;
    }
}
