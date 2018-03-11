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
        List<User>list=userService.getUsersBetweenLevels(1,100);
        modelData.setUsers(list);
    }
    @Override
    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
    }
}
