package food.track;

public class User {
    private String nick;
    private String login;
    private String password;
    private String email;

    public User () {}
    public String getNick(){
        return nick;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }


    public void setNick(String nick){
        this.nick = nick;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
}