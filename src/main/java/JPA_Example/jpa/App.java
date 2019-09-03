package JPA_Example.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.proje.model.Address;
import com.proje.model.Advertisement;
import com.proje.model.Education;
import com.proje.model.User;
import com.proje.model.UserDetail;
import com.proje.model.UserInfo;
import com.proje.repository.UserRepository;
import com.proje.repository.Impl.UserRepositoryImpl;

public class App 
{
	
	
	
    public static void main( String[] args )
    {
    	
    	UserRepository userRepository= new UserRepositoryImpl();
    	
    	UserDetail userDetail1 = new UserDetail("Hatip", "Oztemel", new Date());
    	
    	User user1 = new User("Hato", "Oztml",userDetail1 , new Date());
    	
    	userRepository.saveUser(user1);
    }
    
    public static void insertData() {
    	UserRepository userRepository= new UserRepositoryImpl();
    	
    	User user1 = new User("Hato", "Oztml", new Date());
    	
    	UserDetail userDetail1 = new UserDetail("Hatip", "Oztemel", new Date());
    	
    	Address address1 = new Address("10", "tuna", 10, "Istanbul");
    	
    	Advertisement advertisement1 = new Advertisement("Say Hello", "Good Bye, all you, see you later again :)", "Sanal");
    	
    	Education education1 = new Education("Software", 2019);
    	
    	userRepository.saveUser(user1);
    	
    	
    }
}
