package com.newage.erp.security.controllers;

import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

@Named
@RequestScoped
public class LoginBacking {
    
    @Inject
    private SecurityContext securityContext;

    @NotNull
    private String username;
    
    @NotNull
    private String password;
    
    public void login() {
        
        System.out.println("com.newage.erp.security.controllers.LoginBacking.login()");
        FacesContext context = FacesContext.getCurrentInstance();
        Credential credential = new UsernamePasswordCredential(username, new Password(password));
        
        AuthenticationStatus status = securityContext.authenticate(
            getRequest(context),
            getResponse(context), 
            withParams().credential(credential));
        
    }
    
    private static HttpServletResponse getResponse(FacesContext context) {
        return (HttpServletResponse) context
            .getExternalContext()
            .getResponse();
    }
    
    private static HttpServletRequest getRequest(FacesContext context) {
        return (HttpServletRequest) context
            .getExternalContext()
            .getRequest();
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
