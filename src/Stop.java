public class Stop implements Command {

    @Override
    public String execute() {
        return "Nevermore.";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
