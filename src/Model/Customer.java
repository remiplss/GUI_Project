package Model;

public class Customer
{
    private String email;
    private String password;
    private String type;
    private String firstName;
    private String lastName;
    protected int id;

    public Customer(){}
    public Customer(String email, String password, String type, String firstName, String lastName,int id) 
    {
        this.email = email;
        this.password = password;
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
    
    public Customer(String email,String firstName,String lastName)
    {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return this.type;
    }
    
    public int getId() {
        return this.id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
            " email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", type='" + getType() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }
    
}