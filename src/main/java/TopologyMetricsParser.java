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
    private int totalTransferred;
    private float countExecuteLatency;
    private float countProcessLatency;
    private int countEmitted;
    private float splitExecuteLatency;
    private float splitProcessLatency;
    private int splitEmitted;


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

        List<JsonNode> executeLatencies = myTree.findValue("bolts").findValues("executeLatency");
        setCountExecuteLatencyTuple((float) executeLatencies.get(0).asDouble());
        setSplitExecuteLatencyTuple((float) executeLatencies.get(1).asDouble());

        List<JsonNode> processLatencies = myTree.findValue("bolts").findValues("processLatency");
        setCountProcessLatency((float) processLatencies.get(0).asDouble());
        setSplitProcessLatency((float) processLatencies.get(1).asDouble());

        List<JsonNode> emitted = myTree.findValue("bolts").findValues("emitted");
        setCountEmitted(emitted.get(0).asInt());
        setSplitEmitted(emitted.get(1).asInt());

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


}
