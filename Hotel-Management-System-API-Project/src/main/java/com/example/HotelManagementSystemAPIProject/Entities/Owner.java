package com.example.HotelManagementSystemAPIProject.Entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Owner {
    @Id
    private  int ownerId;
    @Column(nullable = false)
    private String oname,oemail,ocontact, oaddress;

    public Owner(){}

    public Owner(int ownerId, String oname, String oemail, String ocontact, String oaddress) {
        this.ownerId = ownerId;
        this.oname = oname;
        this.oemail = oemail;
        this.ocontact = ocontact;
        this.oaddress = oaddress;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getOemail() {
        return oemail;
    }

    public void setOemail(String oemail) {
        this.oemail = oemail;
    }

    public String getOcontact() {
        return ocontact;
    }

    public void setOcontact(String ocontact) {
        this.ocontact = ocontact;
    }

    public String getOaddress() {
        return oaddress;
    }

    public void setOaddress(String oaddress) {
        this.oaddress = oaddress;
    }
}
