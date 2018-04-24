package serv.obj;

import org.jboss.netty.channel.Channel;
import serv.SQL.stmnts.getUserData;
import serv.SQL.stmnts.updateUserData;

public class Client {

    Channel client_channel;
    String username;
    String password;
    String first_name;
    String last_name;
    String phone_number;
    String email;


    public Client (Channel ctx, String username, String password){
        this.client_channel = ctx;
        this.username = username;
        this.password = password;
    }

    public Channel getClient_channel() {
        return client_channel;
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

    public void getUserInformationFromDB(){
        getUserData userDataGrabber = new getUserData();
        userDataGrabber.setQuery(this.username);
        userDataGrabber.query(); //execute query
        //fill data
        this.setEmail(userDataGrabber.getEmail());
        this.setPhone_number(userDataGrabber.getPhoneNumber());
        this.setFirst_name(userDataGrabber.getFirstName());
        this.setLast_name(userDataGrabber.getLastName());
    }

    public void updateUserInformationOnDB(){
        updateUserData userDataUpdater = new updateUserData();
        userDataUpdater.setQuery(this.username,this.password,this.first_name,this.last_name,this.email,this.phone_number);
        boolean update = userDataUpdater.query();
        if(update){
            System.out.println("User data update success");

        } else {
            System.out.println("User data update fail");
        }
    }
}
