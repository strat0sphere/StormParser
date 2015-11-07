import java.util.ArrayList;
import java.util.List;

/**
 * Created by stratos on 4/9/15.
 */
public class ExperimentMetrics {

    final String experimentName;

    public List<Tuple> totalEmitted;
    public List<Tuple> totalTransferred;
    public List<Tuple> totalCompleteLatency;
    public List<Tuple> totalAcked;
    public List<Tuple> totalFailed;

    public List<Tuple> ackerExecuteLatency;
    public List<Tuple> ackerProcessLatency;
    public List<Tuple> ackerEmitted;
    public List<Tuple> ackerTransferred;



    public List<Tuple> ackerAcked;
    public List<Tuple> ackerFailed;
    public List<Tuple> ackerCapacity;

    public List<Tuple> countExecuteLatency;
    public List<Tuple> countProcessLatency;
    public List<Tuple> countEmitted;
    public List<Tuple> countTransferred;
    public List<Tuple> countAcked;
    public List<Tuple> countFailed;
    public List<Tuple> countCapacity;

    public List<Tuple> splitExecuteLatency;
    public List<Tuple> splitProcessLatency;
    public List<Tuple> splitEmitted;
    public List<Tuple> splitTransferred;
    public List<Tuple> splitAcked;
    public List<Tuple> splitFailed;
    public List<Tuple> splitCapacity;

    public ExperimentMetrics(String experimentName)
    {
        this.experimentName = experimentName;

        totalEmitted = new ArrayList<Tuple>();
        totalTransferred = new ArrayList<Tuple>();
        totalAcked = new ArrayList<Tuple>();
        totalFailed = new ArrayList<Tuple>();
        totalCompleteLatency = new ArrayList<Tuple>();

        ackerExecuteLatency = new ArrayList<Tuple>();
        ackerProcessLatency = new ArrayList<Tuple>();
        ackerEmitted = new ArrayList<Tuple>();
        ackerTransferred = new ArrayList<Tuple>();
        ackerAcked = new ArrayList<Tuple>();
        ackerFailed = new ArrayList<Tuple>();
        ackerCapacity = new ArrayList<Tuple>();

        countExecuteLatency = new ArrayList<Tuple>();
        countProcessLatency = new ArrayList<Tuple>();
        countEmitted = new ArrayList<Tuple>();
        countTransferred = new ArrayList<Tuple>();
        countAcked = new ArrayList<Tuple>();
        countFailed = new ArrayList<Tuple>();
        countCapacity = new ArrayList<Tuple>();

        splitExecuteLatency = new ArrayList<Tuple>();
        splitProcessLatency = new ArrayList<Tuple>();
        splitEmitted = new ArrayList<Tuple>();
        splitTransferred = new ArrayList<Tuple>();
        splitAcked = new ArrayList<Tuple>();
        splitFailed = new ArrayList<Tuple>();
        splitCapacity = new ArrayList<Tuple>();

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

    public List<Tuple> getAckerExecuteLatency() {
        return ackerExecuteLatency;
    }

    public void setAckerExecuteLatency(List<Tuple> ackerExecuteLatency) {
        this.ackerExecuteLatency = ackerExecuteLatency;
    }

    public List<Tuple> getAckerProcessLatency() {
        return ackerProcessLatency;
    }

    public void setAckerProcessLatency(List<Tuple> ackerProcessLatency) {
        this.ackerProcessLatency = ackerProcessLatency;
    }

    public List<Tuple> getAckerEmitted() {
        return ackerEmitted;
    }

    public void setAckerEmitted(List<Tuple> ackerEmitted) {
        this.ackerEmitted = ackerEmitted;
    }

    public List<Tuple> getSplitCapacity() {
        return splitCapacity;
    }

    public void setSplitCapacity(List<Tuple> splitCapacity) {
        this.splitCapacity = splitCapacity;
    }

    public List<Tuple> getAckerTransferred() {
        return ackerTransferred;
    }

    public void setAckerTransferred(List<Tuple> ackerTransferred) {
        this.ackerTransferred = ackerTransferred;
    }

    public List<Tuple> getAckerAcked() {
        return ackerAcked;
    }

    public void setAckerAcked(List<Tuple> ackerAcked) {
        this.ackerAcked = ackerAcked;
    }

    public List<Tuple> getAckerFailed() {
        return ackerFailed;
    }

    public void setAckerFailed(List<Tuple> ackerFailed) {
        this.ackerFailed = ackerFailed;
    }

    public List<Tuple> getAckerCapacity() {
        return ackerCapacity;
    }

    public void setAckerCapacity(List<Tuple> ackerCapacity) {
        this.ackerCapacity = ackerCapacity;
    }

    public List<Tuple> getCountTransferred() {
        return countTransferred;
    }

    public void setCountTransferred(List<Tuple> countTransferred) {
        this.countTransferred = countTransferred;
    }

    public List<Tuple> getCountAcked() {
        return countAcked;
    }

    public void setCountAcked(List<Tuple> countAcked) {
        this.countAcked = countAcked;
    }

    public List<Tuple> getCountFailed() {
        return countFailed;
    }

    public void setCountFailed(List<Tuple> countFailed) {
        this.countFailed = countFailed;
    }

    public List<Tuple> getCountCapacity() {
        return countCapacity;
    }

    public void setCountCapacity(List<Tuple> countCapacity) {
        this.countCapacity = countCapacity;
    }

    public List<Tuple> getSplitTransferred() {
        return splitTransferred;
    }

    public void setSplitTransferred(List<Tuple> splitTransferred) {
        this.splitTransferred = splitTransferred;
    }

    public List<Tuple> getSplitAcked() {
        return splitAcked;
    }

    public void setSplitAcked(List<Tuple> splitAcked) {
        this.splitAcked = splitAcked;
    }

    public List<Tuple> getSplitFailed() {
        return splitFailed;
    }

    public void setSplitFailed(List<Tuple> splitFailed) {
        this.splitFailed = splitFailed;
    }

    public List<Tuple> getTotalCompleteLatency() {
        return totalCompleteLatency;
    }

    public void setTotalCompleteLatency(List<Tuple> totalCompleteLatency) {
        this.totalCompleteLatency = totalCompleteLatency;
    }

    public List<Tuple> getTotalAcked() {
        return totalAcked;
    }

    public void setTotalAcked(List<Tuple> totalAcked) {
        this.totalAcked = totalAcked;
    }

    public List<Tuple> getTotalFailed() {
        return totalFailed;
    }

    public void setTotalFailed(List<Tuple> totalFailed) {
        this.totalFailed = totalFailed;
    }
}
