package patterns;

public class CallbackMailGen implements GenMail {
    @Override
    public String genMail() {
        return "Do not call us ";
    }
}
