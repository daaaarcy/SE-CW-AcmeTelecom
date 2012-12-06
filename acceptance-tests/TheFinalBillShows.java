import fit.RowFixture;

import java.util.ArrayList;
import java.util.List;


public class TheFinalBillShows extends RowFixture
{
    public static class Row
    {
        public int Line;
        public String Text;

        public Row(int line, String text)
        {
            Line = line;
            Text = text;
        }
    }

    @Override
    public Class<?> getTargetClass()
    {
        return Row.class;
    }

    @Override
    public Object[] query() throws Exception
    {
        SystemUnderTest.billingSystem.createCustomerBills();

        List<Row> rows = new ArrayList<Row>();
        for (String line : SystemUnderTest.printer.output().split("\n"))
        {
            rows.add(new Row(rows.size() + 1, line));
        }
        return rows.toArray();
    }
}
