import FakeClasses.FakeClock;
import com.acmetelecom.Call;
import com.acmetelecom.CallEnd;
import com.acmetelecom.CallStart;
import fit.ColumnFixture;

public class GivenTheFollowingCalls extends ColumnFixture {

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
        CallStart callStart = new CallStart(caller,callee,new FakeClock(start));
        CallEnd callEnd = new CallEnd(caller,callee,new FakeClock(end));
        SystemUnderTest.Calls.add(new Call(callStart,callEnd));
    }
}
