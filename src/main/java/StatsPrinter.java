import java.util.ArrayList;

/**
 * Created by stratos on 4/8/15.
 */
public class StatsPrinter {

    ArrayList<Tuple>  resultsArray;

    public StatsPrinter(ArrayList<Tuple> resultsArray)
    {

        this.resultsArray = resultsArray;

    }

    public void printResults()
    {
        for (Tuple tuple : resultsArray)
        {
            System.out.println(tuple.toString());
        }
    }

}
