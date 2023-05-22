package org.acme;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class RegistrationListForm implements Serializable {

    private boolean checked = true;

    @Inject
    @RestClient
    transient RegistrationClient registrationClient;

    public void setAsChecked() {
        checked = false;
    }

    public List<RegistrationDTO> getRegistrationList() {
        return registrationClient.getRegistrationList();
    }

    public String sendEmail(String email) {
        return registrationClient.sendEmail(email);
    }

    public boolean isChecked() {
        return checked;
    }
}
