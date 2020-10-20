package patterns;

public class WelcomeMailGen implements GenMail {
    @Override
    public String genMail() {
        return "Welcome client";
    }
}
