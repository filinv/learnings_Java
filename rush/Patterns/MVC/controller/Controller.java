public class Controller {
    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }
    public void onShowAllUsers(){
        model.loadUsers();
    }
}
