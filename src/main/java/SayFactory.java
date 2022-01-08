import constant.Constant;
import execptions.NotImplementedException;
import platform.FedoraSay;
import platform.SayI;
import platform.UbuntuSay;
import platform.WinSay;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SayFactory {
    private static final Map<String, Supplier<SayI>> mapOfPlatForm = new HashMap<>();

    static {
        mapOfPlatForm.put(Constant.PLATFORM_WIN, WinSay::new);
        mapOfPlatForm.put(Constant.PLATFORM_UBUNTU, UbuntuSay::new);
        mapOfPlatForm.put(Constant.PLATFORM_FEDORA, FedoraSay::new);
    }

    public static SayI getSay(String os) throws NotImplementedException {
        String key = os.toLowerCase().startsWith("win") ? Constant.PLATFORM_WIN : os;

        if (mapOfPlatForm.containsKey(key)) {
            return mapOfPlatForm.get(key).get();
        }
        throw new NotImplementedException("Say not implemented for " + os);
    }
}
