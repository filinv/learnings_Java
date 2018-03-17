import java.util.LinkedList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData=new ModelData();
    @Override
    public ModelData getModelData() {
        return modelData;
    }
    @Override
    public void loadUsers() {
        List<User> list=new LinkedList<>();
        list.add(new User("Name1",1,1));
        list.add(new User("Name2",2,1));
        modelData.setUsers(list);
    }
    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }
    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
