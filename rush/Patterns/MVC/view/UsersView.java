public class UsersView implements View {
    private Controller controller;
    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }
    @Override
    public void refresh(ModelData modelData) {
        if(modelData.isDisplayDeletedUserList())System.out.println("All deleted users:");
        else System.out.println("All users:");
        for(User user:modelData.getUsers()){
            System.out.println("\t"+user);
        }
        System.out.println("===================================================");
    }
    @Override
    public void setController(Controller controller) {
        this.controller=controller;
    }
}
