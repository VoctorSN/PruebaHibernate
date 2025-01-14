package edu.badpals;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Email {
    @Column(length = 320)
   private String email;
   protected Email() {}
   public Email(String email) {
       setEmail(email);
   }
   public String getEmail() {
       return email;
   }
   public void setEmail(String email) {
       this.email = email.toLowerCase();
   }

}