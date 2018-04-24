package client.obj;

import org.jboss.netty.channel.Channel;
import serv.SQL.stmnts.getUserData;
import serv.SQL.stmnts.updateUserData;

public class ClientObj {

    String username;
    String password;
    String first_name;
    String last_name;
    String phone_number;
    String email;


    public ClientObj(String username, String password){

        this.username = username;
        this.password = password;
    }


    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void updateUserInformationOnSever(){

    }
}
