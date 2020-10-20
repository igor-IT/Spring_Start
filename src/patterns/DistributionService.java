package patterns;

import java.util.HashMap;
import java.util.Map;

public class DistributionService {

    public GenMail sendMail(int i){
        Map<Integer,GenMail> map = new HashMap<>();
        map.put(1, new WelcomeMailGen());
        map.put(2, new CallbackMailGen());

        return map.get(i);
    }
}
