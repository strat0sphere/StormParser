/**
 * Created by stratos on 4/8/15.
 */
public class RunMetrics {

    private int run;

    private Tuple<Integer> totalEmittedTuple;
    private Tuple<Integer> totalTransferredTuple;
    private Tuple<Float> countExecuteLatencyTuple;
    private Tuple<Float> countProcessLatencyTuple;
    private Tuple<Integer> countEmittedTuple;
    private Tuple<Float> splitExecuteLatencyTuple;
    private Tuple<Float> splitProcessLatencyTuple;
    private Tuple<Integer> splitEmittedTuple;

    TopologyMetricsParser topologyMetricsParser;

    public RunMetrics(int run)
    {
        this.run = run;
        totalEmittedTuple = new Tuple<Integer>();
        totalTransferredTuple = new Tuple<Integer>();
        countExecuteLatencyTuple = new Tuple<Float>();
        countProcessLatencyTuple = new Tuple<Float>();
        countEmittedTuple = new Tuple<Integer>();
        splitExecuteLatencyTuple = new Tuple<Float>();
        splitProcessLatencyTuple = new Tuple<Float>();
        splitEmittedTuple = new Tuple<Integer>();
    }


    public void setBefore(String line)
    {

        topologyMetricsParser = new TopologyMetricsParser(line);

        getTotalEmittedTuple().setBefore(topologyMetricsParser.getTotalEmitted());
        getTotalTransferredTuple().setBefore(topologyMetricsParser.getTotalTransferred());
        countExecuteLatencyTuple.setBefore(topologyMetricsParser.getCountExecuteLatency());
        countProcessLatencyTuple.setBefore(topologyMetricsParser.getCountProcessLatency());
        countEmittedTuple.setBefore(topologyMetricsParser.getCountEmitted());
        splitExecuteLatencyTuple.setBefore(topologyMetricsParser.getSplitExecuteLatency());
        splitProcessLatencyTuple.setBefore(topologyMetricsParser.getSplitProcessLatency());
        splitEmittedTuple.setBefore(topologyMetricsParser.getSplitEmitted());

    }


    public void setAfter(String line)
    {

        topologyMetricsParser = new TopologyMetricsParser(line);

        getTotalEmittedTuple().setAfter(topologyMetricsParser.getTotalEmitted());
        getTotalTransferredTuple().setAfter(topologyMetricsParser.getTotalTransferred());
        countExecuteLatencyTuple.setAfter(topologyMetricsParser.getCountExecuteLatency());
        countProcessLatencyTuple.setAfter(topologyMetricsParser.getCountProcessLatency());
        countEmittedTuple.setAfter(topologyMetricsParser.getCountEmitted());
        splitExecuteLatencyTuple.setAfter(topologyMetricsParser.getSplitExecuteLatency());
        splitProcessLatencyTuple.setAfter(topologyMetricsParser.getSplitProcessLatency());
        splitEmittedTuple.setAfter(topologyMetricsParser.getSplitEmitted());

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
}
