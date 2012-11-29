package FakeClasses;

import com.acmetelecom.test.TestClock;
import com.acmetelecom.time.Clock;

/**
 * Created with IntelliJ IDEA.
 * User: Chuckie
 * Date: 29/11/12
 * Time: 16:12
 * To change this template use File | Settings | File Templates.
 */
public class FakeClock extends TestClock {

    private static int fakeday = 15;
    private static int fakemonth = 6;
    private static int fakeyear = 2012;

    public FakeClock(String time){
        super(fakeyear,fakemonth,fakeday);
        String[] hrmins = time.split(":");
        incrementTime(Integer.parseInt(hrmins[0]),Integer.parseInt(hrmins[1]),Integer.parseInt(hrmins[2]));
    }

}

