package execptions;

public class UnsupportedEnvException extends Exception {
    public UnsupportedEnvException(String msg) {
        super(msg);
    }

    public UnsupportedEnvException(String msg, Throwable th) {
        super(msg, th);
    }
}
