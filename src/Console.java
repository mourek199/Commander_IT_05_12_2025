import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private HashMap<String, Command> commands;
    private boolean isExit;
    private Scanner sc;

    public Console() {
        isExit = false;
        sc = new Scanner(System.in);
        commands = new HashMap<>();
    }

    public void innit(){
        commands.put("date", new Date());
        commands.put("stop", new Stop());
        try {
            commands.put("wisewords", new WiseWords());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void execute(){
        System.out.print(">>");
        String command = sc.next().toLowerCase().trim();

        if(commands.containsKey(command)){
            System.out.println(commands.get(command).execute());
            isExit = commands.get(command).exit();
        }else
            System.out.println("I dont understand.");
    }

    public void start(){
        innit();
        do {
            execute();
        } while (!isExit);
    }
}

