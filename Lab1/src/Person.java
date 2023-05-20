public class Person{
    String firstName;
    String lastName;
    String PUID;
    String email;
    String phoneNumber;
    String streetAddress;
    String streetAddress2;
    String city;
    String state;
    String zipCode;
    String country;
    
    public void setFirstName(String fn){
        firstName = fn;
    }
         
    public String getFirstName(){
        return firstName;
    }    
    
    public void setLastName(String ln){
        lastName = ln;
    }
         
    public String getLastName(){
        return lastName;
    }  
        
    public void setPUID(String id){
        PUID = id;
    }
         
    public String getPUID(){
        return PUID;
    } 
    
    public void setEmail(String mail){
        email = mail;
    }
         
    public String getEmail(){
        return email;
    }  
    
    public void setPhoneNumber(String pn){
        phoneNumber = pn;
    }
         
    public String getPhoneNumber(){
        return phoneNumber;
    }
}
