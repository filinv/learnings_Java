public class UsersView implements View {
    private Controller controller;
    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("All users:");
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
