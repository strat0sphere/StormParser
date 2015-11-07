import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by stratos on 4/8/15.
 */

public class TopologyMetricsParser {

    final String line = "";

    public int totalEmitted;
    private int totalAcked;
    private int totalTransferred;
    private int totalFailed;
    private float totalCompleteLatency;

    private float ackerExecuteLatency;
    private float ackerProcessLatency;
    private int ackerEmitted;
    private int ackerTransferred;
    private float ackerCapacity;
    private int ackerFailed;
    private int ackerAcked;

    private float countExecuteLatency;
    private float countProcessLatency;
    private int countEmitted;
    private int countTransferred;
    private float countCapacity;
    private int countFailed;
    private int countAcked;

    private float splitExecuteLatency;
    private float splitProcessLatency;
    private int splitEmitted;
    private int splitTransferred;
    private float splitCapacity;
    private int splitFailed;
    private int splitAcked;



    public TopologyMetricsParser()
    {
        try {
            parseJSONFile(this.line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TopologyMetricsParser(String fileName)
    {
        try {
            parseJSONFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        try {
            StringBuffer sb = new StringBuffer();
            Class<?> objClass = this.getClass();

            Field[] fields = objClass.getDeclaredFields();
            for(Field field : fields) {
                String name = field.getName();
                Object value = field.get(this);

                sb.append(name + ": " + value.toString() + "\n");
            }

            return sb.toString();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void parseJSONFile (String line) throws IOException {
        //byte[] mapData = Files.readAllBytes(Paths.get(fileName));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode myTree = objectMapper.readTree(line);

        setTotalEmitted(myTree.findValue("topologyStats").findValue("emitted").asInt());
        setTotalTransferred(myTree.findValue("topologyStats").findValue("transferred").asInt());
        setTotalCompleteLatency((float)myTree.findValue("topologyStats").findValue("completeLatency").asDouble());
        setTotalAcked(myTree.findValue("topologyStats").findValue("acked").asInt());
        setTotalFailed(myTree.findValue("topologyStats").findValue("failed").asInt());

        List<JsonNode> executeLatencies = myTree.findValue("bolts").findValues("executeLatency");

        //System.out.println(executeLatencies);
        setAckerExecuteLatencyTuple((float) executeLatencies.get(0).asDouble());
        setCountExecuteLatencyTuple((float) executeLatencies.get(1).asDouble());
        setSplitExecuteLatencyTuple((float) executeLatencies.get(2).asDouble());

        List<JsonNode> processLatencies = myTree.findValue("bolts").findValues("processLatency");
        setAckerProcessLatency((float) processLatencies.get(0).asDouble());
        setCountProcessLatency((float) processLatencies.get(1).asDouble());
        setSplitProcessLatency((float) processLatencies.get(2).asDouble());

        List<JsonNode> emitted = myTree.findValue("bolts").findValues("emitted");
        setAckerEmitted(emitted.get(0).asInt());
        setCountEmitted(emitted.get(1).asInt());
        setSplitEmitted(emitted.get(2).asInt());

        List<JsonNode> transferred = myTree.findValue("bolts").findValues("transferred");
        setAckerTransferred(transferred.get(0).asInt());
        setCountTransferred(transferred.get(1).asInt());
        setSplitTransferred(transferred.get(2).asInt());

        List<JsonNode> acked = myTree.findValue("bolts").findValues("acked");
        //System.out.println(acked);
        setAckerAcked(acked.get(0).asInt());
        setCountAcked(acked.get(1).asInt());
        setSplitAcked(acked.get(2).asInt());

        List<JsonNode> failed = myTree.findValue("bolts").findValues("failed");
        setAckerFailed(failed.get(0).asInt());
        setCountFailed(failed.get(1).asInt());
        setSplitFailed(failed.get(2).asInt());

        List<JsonNode> capacity = myTree.findValue("bolts").findValues("capacity");
        setAckerCapacity(capacity.get(0).asInt());
        setCountCapacity(capacity.get(1).asInt());
        setSplitCapacity(capacity.get(2).asInt());


        //System.out.println(this.toString());

    }



    public static void main(String[] args)
    {
        TopologyMetricsParser topologyMetricsParser = new TopologyMetricsParser();

    }


    public int getTotalEmitted() {
        return totalEmitted;
    }

    public void setTotalEmitted(int totalEmitted) {
        this.totalEmitted = totalEmitted;
    }

    public int getTotalTransferred() {
        return totalTransferred;
    }

    public void setTotalTransferred(int totalTransferred) {
        this.totalTransferred = totalTransferred;
    }

    public float getCountExecuteLatency() {
        return countExecuteLatency;
    }

    public void setCountExecuteLatencyTuple(float countExecuteLatencyTuple) {
        this.countExecuteLatency = countExecuteLatencyTuple;
    }

    public void setAckerExecuteLatencyTuple(float ackerExecuteLatencyTuple) {
        this.ackerExecuteLatency = ackerExecuteLatencyTuple;
    }

    public float getCountProcessLatency() {
        return countProcessLatency;
    }

    public void setCountProcessLatency(float countProcessLatency) {
        this.countProcessLatency = countProcessLatency;
    }

    public int getCountEmitted() {
        return countEmitted;
    }

    public void setCountEmitted(int countEmitted) {
        this.countEmitted = countEmitted;
    }

    public float getSplitExecuteLatency() {
        return splitExecuteLatency;
    }

    public void setSplitExecuteLatencyTuple(float splitExecuteLatencyTuple) {
        this.splitExecuteLatency = splitExecuteLatencyTuple;
    }

    public float getSplitProcessLatency() {
        return splitProcessLatency;
    }

    public void setSplitProcessLatency(float splitProcessLatency) {
        this.splitProcessLatency = splitProcessLatency;
    }

    public int getSplitEmitted() {
        return splitEmitted;
    }

    public void setSplitEmitted(int splitEmitted) {
        this.splitEmitted = splitEmitted;
    }

    public int getAckerEmitted() {
        return ackerEmitted;
    }

    public void setAckerEmitted(int ackerEmitted) {
        this.ackerEmitted = ackerEmitted;
    }

    public float getAckerExecuteLatency() {
        return ackerExecuteLatency;
    }

    public void setAckerExecuteLatency(float ackerExecuteLatency) {
        this.ackerExecuteLatency = ackerExecuteLatency;
    }

    public float getAckerProcessLatency() {
        return ackerProcessLatency;
    }

    public void setAckerProcessLatency(float ackerProcessLatency) {
        this.ackerProcessLatency = ackerProcessLatency;
    }


    public int getSplitTransferred() {
        return splitTransferred;
    }

    public void setSplitTransferred(int splitTransferred) {
        this.splitTransferred = splitTransferred;
    }

    public float getSplitCapacity() {
        return splitCapacity;
    }

    public void setSplitCapacity(float splitCapacity) {
        this.splitCapacity = splitCapacity;
    }

    public float getCountCapacity() {
        return countCapacity;
    }

    public void setCountCapacity(float countCapacity) {
        this.countCapacity = countCapacity;
    }

    public int getCountTransferred() {
        return countTransferred;
    }

    public void setCountTransferred(int countTransferred) {
        this.countTransferred = countTransferred;
    }

    public float getAckerCapacity() {
        return ackerCapacity;
    }

    public void setAckerCapacity(float ackerCapacity) {
        this.ackerCapacity = ackerCapacity;
    }

    public int getAckerTransferred() {
        return ackerTransferred;
    }

    public void setAckerTransferred(int ackerTransferred) {
        this.ackerTransferred = ackerTransferred;
    }

    public int getAckerFailed() {
        return ackerFailed;
    }

    public void setAckerFailed(int ackerFailed) {
        this.ackerFailed = ackerFailed;
    }

    public int getCountFailed() {
        return countFailed;
    }

    public void setCountFailed(int countFailed) {
        this.countFailed = countFailed;
    }

    public int getSplitFailed() {
        return splitFailed;
    }

    public void setSplitFailed(int splitFailed) {
        this.splitFailed = splitFailed;
    }

    public int getAckerAcked() {
        return ackerAcked;
    }

    public void setAckerAcked(int ackerAcked) {
        this.ackerAcked = ackerAcked;
    }

    public int getCountAcked() {
        return countAcked;
    }

    public void setCountAcked(int countAcked) {
        this.countAcked = countAcked;
    }

    public int getSplitAcked() {
        return splitAcked;
    }

    public void setSplitAcked(int splitAcked) {
        this.splitAcked = splitAcked;
    }

    public float getTotalCompleteLatency() {
        return totalCompleteLatency;
    }

    public void setTotalCompleteLatency(float totalCompleteLatency) {
        this.totalCompleteLatency = totalCompleteLatency;
    }

    public int getTotalAcked() {
        return totalAcked;
    }

    public void setTotalAcked(int totalAcked) {
        this.totalAcked = totalAcked;
    }

    public int getTotalFailed() {
        return totalFailed;
    }

    public void setTotalFailed(int totalFailed) {
        this.totalFailed = totalFailed;
    }

}
