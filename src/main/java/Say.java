import execptions.NotImplementedException;
import execptions.UnsupportedEnvException;
import platform.SayI;
import utility.CommandExecutor;
import utility.OsUtil;

import java.io.IOException;
import java.util.List;

/**
 * <h1>Say Main Class</h1>
 * TODO: add option to select voice (throw exception if voice is unavailable
 * TODO: allow concurrent calls
 * TODO: Kill process on demand
 * TODO: Use design properly
 * TODO: Configure a debugger
 */
public class Say {
    public static void say(String text) throws NotImplementedException {
        CommandExecutor executor = new CommandExecutor();

        SayI say = SayFactory.getSay(OsUtil.getOsName());
        List<String> command = say.buildCommand(text);

        try {
            int status = executor.executeCommand(command);
            System.out.println(executor.getOutput());
            System.out.println("Exit code: " + status);
        } catch (UnsupportedEnvException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) throws NotImplementedException {
        say("This is a test text");
    }
}
