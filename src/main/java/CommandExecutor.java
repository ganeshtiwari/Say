import execptions.UnsupportedEnvException;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Getter
public class CommandExecutor {
    private InputStream inputStream;
    private long pid;

    public int executeCommand(List<String> command)
            throws UnsupportedEnvException, IOException, InterruptedException {

        ProcessBuilder builder = new ProcessBuilder();
        builder.command(command);
        builder.redirectErrorStream(true);

        Process process = builder.start();

        pid = process.pid();
        inputStream = process.getInputStream();

        return process.waitFor();
    }

    public String getOutput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();

        String line;
        while (true) {
            line = reader.readLine();
            if (line == null) break;
            builder.append(line);
        }
        return builder.toString();
    }
}
