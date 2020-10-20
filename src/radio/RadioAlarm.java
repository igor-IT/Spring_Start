package radio;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;

@AllArgsConstructor
public class RadioAlarm implements Radio,Alarm {

    @Delegate
    private Radio radio = new RadioImp();
    @Delegate(excludes = AlarmExc.class)
    private Alarm alarm = new AlarmImp();

    @Override
    public void c(){
        System.out.println("Override - C");

    }

}
