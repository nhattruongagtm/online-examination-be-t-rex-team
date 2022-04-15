@Service 
public class UserService {
    @Autowired 
    UserRepository repo;

    public void addUser(String userName) {
        User c = new Users();
        c.userName = userName;
        repo.save(c);
    }	
}