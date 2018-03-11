import java.util.List;

public class MainModel implements Model {
    private ModelData modelData=new ModelData();
    private UserService userService=new UserServiceImpl();
    @Override
    public ModelData getModelData() {
        return modelData;
    }
    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        List<User>list=userService.getUsersBetweenLevels(1,100);
        modelData.setUsers(list);
    }
    @Override
    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
    }
    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }
}
