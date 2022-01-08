package platform;

import java.util.List;

public interface SayI {
    List<String> buildCommand(String text);
    List<String> buildCommand(String text, String voice);
}
