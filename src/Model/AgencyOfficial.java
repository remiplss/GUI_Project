package Model;


public class AgencyOfficial extends Customer 
{
    public AgencyOfficial() {
    }

    public AgencyOfficial(String email, String password, String type, String firstName, String lastName,int id) {
        super(email, password, type, firstName, lastName,id);
    }
    
}
