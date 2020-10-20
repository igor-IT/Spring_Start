package patterns;

public class Main {
    public static void main(String[] args) {
        DistributionService distributionService = new DistributionService();
        while (true){
            try {
                GenMail mail = distributionService.sendMail(DBUtils.getMailCode());
                System.out.println(mail.genMail());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
