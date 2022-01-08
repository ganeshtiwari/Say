package platform;

import java.util.Arrays;
import java.util.List;

public class WinSay implements SayI {
    @Override
    public List<String> buildCommand(String textToSpeak) {
        return Arrays.asList(
                "powershell",
                "$voice = New-Object -ComObject Sapi.spvoice;",
                String.format("$voice.speak('%s')", textToSpeak)
        );
    }

    @Override
    public List<String> buildCommand(String text, String voice) {
        return null;
    }
}
