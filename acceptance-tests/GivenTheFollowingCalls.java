import com.acmetelecom.Call;
import com.acmetelecom.CallEnd;
import com.acmetelecom.CallStart;
import com.acmetelecom.test.TestClock;

import fit.ColumnFixture;

public class GivenTheFollowingCalls extends ColumnFixture {
	private static final int fakeday = 15;
    private static final int fakemonth = 6;
    private static final int fakeyear = 2012;

    public String Caller;
    public String Callee;
    public String Start;
    public String End;

	@Override
	public void reset() {

	}
	
	@Override
	public void execute() {
        addCall(Caller,Callee,Start,End);
	}

    public void addCall(String caller, String callee, String start, String end){
        CallStart callStart = new CallStart(caller, callee, new TestClock(fakeyear, fakemonth, fakeday, start));
        CallEnd callEnd = new CallEnd(caller, callee, new TestClock(fakeyear, fakemonth, fakeday, end));
        SystemUnderTest.Calls.add(new Call(callStart,callEnd));
    }
}
