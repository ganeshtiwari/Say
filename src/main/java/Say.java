import execptions.NotImplementedException;
import execptions.UnsupportedEnvException;
import platform.SayI;

import java.io.IOException;
import java.util.List;

/**
 * Say Main Class
 * TODO: allow concurrent calls
 * TODO: Kill process on demand
 * TODO: Use design properly
 */
public class Say {

    public static void main(String... args) throws NotImplementedException {
        CommandExecutor executor = new CommandExecutor();

        SayI say = SayFactory.getSay(OsUtil.getOsName());
        List<String> command = say.buildCommand("Hello this is ganesh");

        try {
            int status = executor.executeCommand(command);
            System.out.println(executor.getOutput());
            System.out.println("Exit code: " + status);
        } catch (UnsupportedEnvException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
