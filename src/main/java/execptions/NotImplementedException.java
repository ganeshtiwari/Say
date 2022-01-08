package execptions;

public class NotImplementedException extends Exception {
    public NotImplementedException(String msg) {
        super(msg);
    }

    public NotImplementedException(String msg, Throwable th) {
        super(msg, th);
    }
}
