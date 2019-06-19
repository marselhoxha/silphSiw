package it.uniroma3.silphSiw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequestForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String mail;
    private String reqDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getReqDetails() {
        return reqDetails;
    }

    public void setReqDetails(String reqDetails) {
        this.reqDetails = reqDetails;
    }
}
