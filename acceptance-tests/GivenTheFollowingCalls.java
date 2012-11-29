import com.acmetelecom.Call;
import com.acmetelecom.CallStart;
import fit.ColumnFixture;

public class GivenTheFollowingCalls extends ColumnFixture {

    public int Caller;
    public int Callee;
    public String Start;
    public String End;

	@Override
	public void reset() {

	}
	
	@Override
	public void execute() {
        public CallStart(String caller, String callee, Clock clock) {
            super(caller, callee, clock.currentTime());
        }
        CallStart s =
        SystemUnderTest.Calls.add(new Call(new CallStart()))
	}
}
