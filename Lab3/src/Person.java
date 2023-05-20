/*
Jack Mahedy

This is the Person class. It holds the persons username, idnum, ipaddress, and port.
All of the data is private so getter and setters are created to access it.
*/

public class Person {
    private String username;
    private String idNum;
    private String ipAddress;
    private int port;
    
    public Person(String user, String id, String ip, int p){
        username = user;
        idNum = id;
        ipAddress = ip;
        port = p;
    }
    
    public void setUsername(String x){
        username = x;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setIdNum(String x){
        idNum = x;
    }
    
    public String getIdNum(){
        return idNum;
    }
    
    public void setIpAddress(String x){
        ipAddress = x;
    }
    
    public String getIpAddress(){
        return ipAddress;
    }
    
    public void setPort(int x){
        port = x;
    }
    
    public int getPort(){
        return port;
    }
}