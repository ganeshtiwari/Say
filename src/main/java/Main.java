import execptions.UnsupportedEnvException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... args) {
        CommandExecutor executor = new CommandExecutor();

        String textToSpeak = "This is a test text.";

        List<String> command = new ArrayList<>();
        command.add("$voice = New-Object -ComObject Sapi.spvoice;");
        command.add(String.format("$voice.speak('%s')", textToSpeak));
        try {
            int status = executor.executeCommand(command);
            System.out.println(executor.getOutput());
            System.out.println("Exit code: " + status);
        } catch (UnsupportedEnvException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
