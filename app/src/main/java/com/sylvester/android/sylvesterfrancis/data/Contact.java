package com.sylvester.android.sylvesterfrancis.data;

/**
 * Created by sylvester on 10/08/17.
 */

public class Contact {
    private String name;
    private String email;
    private String subject;
    private String message_contact;

    //Empty Constructor
    public Contact () {}
    public Contact(String name,String email ,String subject ,String message_contact) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message_contact = message_contact;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getSubject() {return subject;}

    public void setSubject(String subject) {this.subject = subject;}

    public String getMessage_contact() {return message_contact;}

    public void setMessage_contact(String message_contact) {this.message_contact = message_contact;}

}
