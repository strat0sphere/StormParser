/**
 * Created by stratos on 4/8/15.
 */
public class RunMetrics {

    private int run;

    private Tuple<Integer> totalEmittedTuple;
    private Tuple<Integer> totalTransferredTuple;
    private Tuple<Float> totalCompleteLatencyTuple;
    private Tuple<Integer> totalAckedTuple;
    private Tuple<Integer> totalFailedTuple;

    private Tuple<Float> ackerExecuteLatencyTuple;
    private Tuple<Float> ackerProcessLatencyTuple;
    private Tuple<Integer> ackerEmittedTuple;
    private Tuple<Integer> ackerTransferredTuple;
    private Tuple<Integer> ackerAckedTuple;
    private Tuple<Float> ackerCapacityTuple;
    private Tuple<Integer> ackerFailedTuple;

    private Tuple<Float> countExecuteLatencyTuple;
    private Tuple<Float> countProcessLatencyTuple;
    private Tuple<Integer> countEmittedTuple;
    private Tuple<Integer> countTransferredTuple;
    private Tuple<Integer> countAckedTuple;
    private Tuple<Float> countCapacityTuple;
    private Tuple<Integer> countFailedTuple;

    private Tuple<Float> splitExecuteLatencyTuple;
    private Tuple<Float> splitProcessLatencyTuple;
    private Tuple<Integer> splitEmittedTuple;
    private Tuple<Integer> splitTransferredTuple;
    private Tuple<Integer> splitAckedTuple;
    private Tuple<Float> splitCapacityTuple;
    private Tuple<Integer> splitFailedTuple;

    TopologyMetricsParser topologyMetricsParser;

    public RunMetrics(int run)
    {
        this.run = run;
        totalEmittedTuple = new Tuple<Integer>();
        totalTransferredTuple = new Tuple<Integer>();
        totalAckedTuple = new Tuple<Integer>();
        totalFailedTuple = new Tuple<Integer>();
        totalCompleteLatencyTuple = new Tuple<Float>();

        ackerExecuteLatencyTuple = new Tuple<Float>();
        ackerProcessLatencyTuple = new Tuple<Float>();
        ackerEmittedTuple = new Tuple<Integer>();
        ackerTransferredTuple = new Tuple<Integer>();
        ackerAckedTuple = new Tuple<Integer>();
        ackerFailedTuple = new Tuple<Integer>();
        ackerCapacityTuple = new Tuple<Float>();

        countExecuteLatencyTuple = new Tuple<Float>();
        countProcessLatencyTuple = new Tuple<Float>();
        countEmittedTuple = new Tuple<Integer>();
        countTransferredTuple = new Tuple<Integer>();
        countAckedTuple = new Tuple<Integer>();
        countFailedTuple = new Tuple<Integer>();
        countCapacityTuple = new Tuple<Float>();

        splitExecuteLatencyTuple = new Tuple<Float>();
        splitProcessLatencyTuple = new Tuple<Float>();
        splitEmittedTuple = new Tuple<Integer>();
        splitTransferredTuple = new Tuple<Integer>();
        splitAckedTuple = new Tuple<Integer>();
        splitFailedTuple = new Tuple<Integer>();
        splitCapacityTuple = new Tuple<Float>();

    }


    public void setBefore(String line)
    {

        topologyMetricsParser = new TopologyMetricsParser(line);

        totalEmittedTuple.setBefore(topologyMetricsParser.getTotalEmitted());
        totalTransferredTuple.setBefore(topologyMetricsParser.getTotalTransferred());
        totalAckedTuple.setBefore(topologyMetricsParser.getTotalAcked());
        totalFailedTuple.setBefore(topologyMetricsParser.getTotalFailed());
        totalCompleteLatencyTuple.setBefore(topologyMetricsParser.getTotalCompleteLatency());

        ackerExecuteLatencyTuple.setBefore(topologyMetricsParser.getAckerExecuteLatency());
        ackerProcessLatencyTuple.setBefore(topologyMetricsParser.getAckerProcessLatency());
        ackerEmittedTuple.setBefore(topologyMetricsParser.getAckerEmitted());
        ackerAckedTuple.setBefore(topologyMetricsParser.getAckerAcked());
        ackerTransferredTuple.setBefore(topologyMetricsParser.getAckerTransferred());
        ackerFailedTuple.setBefore(topologyMetricsParser.getAckerFailed());
        ackerCapacityTuple.setBefore(topologyMetricsParser.getAckerCapacity());

        countExecuteLatencyTuple.setBefore(topologyMetricsParser.getCountExecuteLatency());
        countProcessLatencyTuple.setBefore(topologyMetricsParser.getCountProcessLatency());
        countEmittedTuple.setBefore(topologyMetricsParser.getCountEmitted());
        countAckedTuple.setBefore(topologyMetricsParser.getCountAcked());
        countTransferredTuple.setBefore(topologyMetricsParser.getCountTransferred());
        countFailedTuple.setBefore(topologyMetricsParser.getCountFailed());
        countCapacityTuple.setBefore(topologyMetricsParser.getCountCapacity());

        splitExecuteLatencyTuple.setBefore(topologyMetricsParser.getSplitExecuteLatency());
        splitProcessLatencyTuple.setBefore(topologyMetricsParser.getSplitProcessLatency());
        splitEmittedTuple.setBefore(topologyMetricsParser.getSplitEmitted());
        splitAckedTuple.setBefore(topologyMetricsParser.getSplitAcked());
        splitTransferredTuple.setBefore(topologyMetricsParser.getSplitTransferred());
        splitFailedTuple.setBefore(topologyMetricsParser.getSplitFailed());
        splitCapacityTuple.setBefore(topologyMetricsParser.getSplitCapacity());

    }


    public void setAfter(String line)
    {

        topologyMetricsParser = new TopologyMetricsParser(line);

        totalEmittedTuple.setAfter(topologyMetricsParser.getTotalEmitted());
        totalTransferredTuple.setAfter(topologyMetricsParser.getTotalTransferred());
        totalAckedTuple.setAfter(topologyMetricsParser.getTotalAcked());
        totalFailedTuple.setAfter(topologyMetricsParser.getTotalFailed());
        totalCompleteLatencyTuple.setAfter(topologyMetricsParser.getTotalCompleteLatency());


        ackerExecuteLatencyTuple.setAfter(topologyMetricsParser.getAckerExecuteLatency());
        ackerProcessLatencyTuple.setAfter(topologyMetricsParser.getAckerProcessLatency());
        ackerEmittedTuple.setAfter(topologyMetricsParser.getAckerEmitted());
        ackerAckedTuple.setAfter(topologyMetricsParser.getAckerAcked());
        ackerTransferredTuple.setAfter(topologyMetricsParser.getAckerTransferred());
        ackerFailedTuple.setAfter(topologyMetricsParser.getAckerFailed());
        ackerCapacityTuple.setAfter(topologyMetricsParser.getAckerCapacity());


        countExecuteLatencyTuple.setAfter(topologyMetricsParser.getCountExecuteLatency());
        countProcessLatencyTuple.setAfter(topologyMetricsParser.getCountProcessLatency());
        countEmittedTuple.setAfter(topologyMetricsParser.getCountEmitted());
        countAckedTuple.setAfter(topologyMetricsParser.getCountAcked());
        countTransferredTuple.setAfter(topologyMetricsParser.getCountTransferred());
        countFailedTuple.setAfter(topologyMetricsParser.getCountFailed());
        countCapacityTuple.setAfter(topologyMetricsParser.getCountCapacity());

        splitExecuteLatencyTuple.setAfter(topologyMetricsParser.getSplitExecuteLatency());
        splitProcessLatencyTuple.setAfter(topologyMetricsParser.getSplitProcessLatency());
        splitEmittedTuple.setAfter(topologyMetricsParser.getSplitEmitted());
        splitAckedTuple.setAfter(topologyMetricsParser.getSplitAcked());
        splitTransferredTuple.setAfter(topologyMetricsParser.getSplitTransferred());
        splitFailedTuple.setAfter(topologyMetricsParser.getSplitFailed());
        splitCapacityTuple.setAfter(topologyMetricsParser.getSplitCapacity());

    }

    public Tuple<Integer> getTotalEmittedTuple() {
        return totalEmittedTuple;
    }

    public void setTotalEmittedTuple(Tuple<Integer> totalEmittedTuple) {
        this.totalEmittedTuple = totalEmittedTuple;
    }

    public Tuple<Integer> getTotalTransferredTuple() {
        return totalTransferredTuple;
    }

    public void setTotalTransferredTuple(Tuple<Integer> totalTransferredTuple) {
        this.totalTransferredTuple = totalTransferredTuple;
    }

    public Tuple<Float> getCountExecuteLatencyTuple() {
        return countExecuteLatencyTuple;
    }

    public void setCountExecuteLatencyTuple(Tuple<Float> countExecuteLatencyTuple) {
        this.countExecuteLatencyTuple = countExecuteLatencyTuple;
    }

    public Tuple<Float> getCountProcessLatencyTuple() {
        return countProcessLatencyTuple;
    }

    public void setCountProcessLatencyTuple(Tuple<Float> countProcessLatencyTuple) {
        this.countProcessLatencyTuple = countProcessLatencyTuple;
    }

    public Tuple<Integer> getCountEmittedTuple() {
        return countEmittedTuple;
    }

    public void setCountEmittedTuple(Tuple<Integer> countEmittedTuple) {
        this.countEmittedTuple = countEmittedTuple;
    }

    public Tuple<Float> getSplitExecuteLatencyTuple() {
        return splitExecuteLatencyTuple;
    }

    public void setSplitExecuteLatencyTuple(Tuple<Float> splitExecuteLatencyTuple) {
        this.splitExecuteLatencyTuple = splitExecuteLatencyTuple;
    }

    public Tuple<Float> getSplitProcessLatencyTuple() {
        return splitProcessLatencyTuple;
    }

    public void setSplitProcessLatencyTuple(Tuple<Float> splitProcessLatencyTuple) {
        this.splitProcessLatencyTuple = splitProcessLatencyTuple;
    }

    public Tuple<Integer> getSplitEmittedTuple() {
        return splitEmittedTuple;
    }

    public void setSplitEmittedTuple(Tuple<Integer> splitEmittedTuple) {
        this.splitEmittedTuple = splitEmittedTuple;
    }

    public Tuple<Float> getAckerExecuteLatencyTuple() {
        return ackerExecuteLatencyTuple;
    }

    public void setAckerExecuteLatencyTuple(Tuple<Float> ackerExecuteLatencyTuple) {
        this.ackerExecuteLatencyTuple = ackerExecuteLatencyTuple;
    }

    public Tuple<Float> getAckerProcessLatencyTuple() {
        return ackerProcessLatencyTuple;
    }

    public void setAckerProcessLatencyTuple(Tuple<Float> ackerProcessLatencyTuple) {
        this.ackerProcessLatencyTuple = ackerProcessLatencyTuple;
    }

    public Tuple<Integer> getAckerEmittedTuple() {
        return ackerEmittedTuple;
    }

    public void setAckerEmittedTuple(Tuple<Integer> ackerEmittedTuple) {
        this.ackerEmittedTuple = ackerEmittedTuple;
    }

    public Tuple<Float> getTotalCompleteLatencyTuple() {
        return totalCompleteLatencyTuple;
    }

    public void setTotalCompleteLatencyTuple(Tuple<Float> totalCompleteLatencyTuple) {
        this.totalCompleteLatencyTuple = totalCompleteLatencyTuple;
    }

    public Tuple<Integer> getTotalAckedTuple() {
        return totalAckedTuple;
    }

    public void setTotalAckedTuple(Tuple<Integer> totalAckedTuple) {
        this.totalAckedTuple = totalAckedTuple;
    }

    public Tuple<Integer> getTotalFailedTuple() {
        return totalFailedTuple;
    }

    public void setTotalFailedTuple(Tuple<Integer> totalFailedTuple) {
        this.totalFailedTuple = totalFailedTuple;
    }



    public Tuple<Integer> getAckerAckedTuple() {
        return ackerAckedTuple;
    }

    public Tuple<Integer> getAckerFailedTuple() {
        return ackerFailedTuple;
    }

    public Tuple<Float> getAckerCapacityTuple() {
        return ackerCapacityTuple;
    }

    public Tuple<Integer> getCountAckedTuple() {
        return countAckedTuple;
    }

    public Tuple<Integer> getCountTransferredTuple() {
        return countTransferredTuple;
    }

    public Tuple<Float> getCountCapacityTuple() {
        return countCapacityTuple;
    }

    public Tuple<Integer> getCountFailedTuple() {
        return countFailedTuple;
    }

    public Tuple<Integer> getSplitTransferredTuple() {
        return splitTransferredTuple;
    }

    public Tuple<Integer> getSplitAckedTuple() {
        return splitAckedTuple;
    }

    public Tuple<Float> getSplitCapacityTuple() {
        return splitCapacityTuple;
    }

    public Tuple<Integer> getSplitFailedTuple() {
        return splitFailedTuple;
    }

    public Tuple<Integer> getAckerTransferredTuple() {
        return ackerTransferredTuple;
    }

}
