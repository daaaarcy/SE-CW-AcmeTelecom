import fit.ColumnFixture;

public class GivenTheFollowingCalls extends ColumnFixture {

    public String Caller;
    public String Callee;
    public String Start;
    public String Duration;

    @Override
    public void reset() throws Exception {
        Caller = null;
        Callee = null;
        Start = null;
        Duration = null;
    }

    @Override
    public void execute() {
        addCall(Caller, Callee, Start, Duration);
    }

    public void addCall(String caller, String callee, String start, String duration) {
        String startString[] = start.trim().split(":");
        String durationString[] = duration.split(":");

        SystemUnderTest.clock.setTime(Integer.parseInt(startString[0]),
                Integer.parseInt(startString[1]),
                Integer.parseInt(startString[2]));
        SystemUnderTest.billingSystem.callInitiated(caller, callee);

        SystemUnderTest.clock.incrementTime(Integer.parseInt(durationString[0]),
                Integer.parseInt(durationString[1]),
                Integer.parseInt(durationString[2]));
        SystemUnderTest.billingSystem.callCompleted(caller, callee);
    }
}
