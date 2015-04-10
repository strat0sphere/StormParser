import java.util.ArrayList;
import java.util.List;

/**
 * Created by stratos on 4/9/15.
 */
public class ExperimentMetrics {

    final String experimentName;

    public List<Tuple> totalEmitted;
    public List<Tuple> totalTransferred;
    public List<Tuple> countExecuteLatency;
    public List<Tuple> countProcessLatency;
    public List<Tuple> countEmitted;
    public List<Tuple> splitExecuteLatency;
    public List<Tuple> splitProcessLatency;
    public List<Tuple> splitEmitted;

    public ExperimentMetrics(String experimentName)
    {
        this.experimentName = experimentName;

        totalEmitted = new ArrayList<Tuple>();
        totalTransferred = new ArrayList<Tuple>();
        countExecuteLatency = new ArrayList<Tuple>();
        countProcessLatency = new ArrayList<Tuple>();
        countEmitted = new ArrayList<Tuple>();
        splitExecuteLatency = new ArrayList<Tuple>();
        splitProcessLatency = new ArrayList<Tuple>();
        splitEmitted = new ArrayList<Tuple>();

    }


    public String getExperimentName() {
        return experimentName;
    }

    public List<Tuple> getTotalEmitted() {
        return totalEmitted;
    }

    public void setTotalEmitted(List<Tuple> totalEmitted) {
        this.totalEmitted = totalEmitted;
    }

    public List<Tuple> getTotalTransferred() {
        return totalTransferred;
    }

    public void setTotalTransferred(List<Tuple> totalTransferred) {
        this.totalTransferred = totalTransferred;
    }

    public List<Tuple> getCountExecuteLatency() {
        return countExecuteLatency;
    }

    public void setCountExecuteLatency(List<Tuple> countExecuteLatency) {
        this.countExecuteLatency = countExecuteLatency;
    }

    public List<Tuple> getCountProcessLatency() {
        return countProcessLatency;
    }

    public void setCountProcessLatency(List<Tuple> countProcessLatency) {
        this.countProcessLatency = countProcessLatency;
    }

    public List<Tuple> getCountEmitted() {
        return countEmitted;
    }

    public void setCountEmitted(List<Tuple> countEmitted) {
        this.countEmitted = countEmitted;
    }

    public List<Tuple> getSplitExecuteLatency() {
        return splitExecuteLatency;
    }

    public void setSplitExecuteLatency(List<Tuple> splitExecuteLatency) {
        this.splitExecuteLatency = splitExecuteLatency;
    }

    public List<Tuple> getSplitProcessLatency() {
        return splitProcessLatency;
    }

    public void setSplitProcessLatency(List<Tuple> splitProcessLatency) {
        this.splitProcessLatency = splitProcessLatency;
    }

    public List<Tuple> getSplitEmitted() {
        return splitEmitted;
    }

    public void setSplitEmitted(List<Tuple> splitEmitted) {
        this.splitEmitted = splitEmitted;
    }

}
