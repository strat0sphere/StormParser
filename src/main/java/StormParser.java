import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by stratos on 4/8/15.
 */
public class StormParser {

    static final int TOTAL_RUNS = 5;
    private final String fileName;

    private Map<String, Map<String, List<Tuple>>> experimentMap; // Contains the map of results for "wordcount", "grep" etc
    private Map<String, List<Tuple>> metricsMap; // Contains the maps for the different metrics, for example totalTransferred, countExecuteLatency etc

    private ExperimentMetrics experimentMetrics;

    public StormParser(String fileName) {
        this.fileName = fileName;

        experimentMap = new HashMap<String, Map<String, List<Tuple>>>();
        parseDocument();

    }


    void createMetricsMap(String experimentName, int setBefore, int setAfter)
    {
        metricsMap = new HashMap<String, List<Tuple>>();

        metricsMap.put("totalEmitted", experimentMetrics.getTotalEmitted());
        metricsMap.put("totalTransferred", experimentMetrics.getTotalTransferred());
        metricsMap.put("totalCompleteLatency", experimentMetrics.getTotalCompleteLatency());
        metricsMap.put("totalAcked", experimentMetrics.getTotalAcked());
        metricsMap.put("totalFailed", experimentMetrics.getTotalFailed());


        metricsMap.put("ackerExecuteLatency", experimentMetrics.getAckerExecuteLatency());
        metricsMap.put("ackerProcessLatency", experimentMetrics.getAckerProcessLatency());
        metricsMap.put("ackerEmitted", experimentMetrics.getAckerEmitted());
        metricsMap.put("ackerTransferred", experimentMetrics.getAckerTransferred());
        metricsMap.put("ackerAcked", experimentMetrics.getAckerAcked());
        metricsMap.put("ackerFailed", experimentMetrics.getAckerFailed());
        metricsMap.put("ackerCapacity", experimentMetrics.getAckerCapacity());

        metricsMap.put("countExecuteLatency", experimentMetrics.getCountExecuteLatency());
        metricsMap.put("countProcessLatency", experimentMetrics.getCountProcessLatency());
        metricsMap.put("countEmitted", experimentMetrics.getCountEmitted());
        metricsMap.put("countTransferred", experimentMetrics.getCountTransferred());
        metricsMap.put("countAcked", experimentMetrics.getCountAcked());
        metricsMap.put("countFailed", experimentMetrics.getCountFailed());
        metricsMap.put("countCapacity", experimentMetrics.getCountCapacity());

        metricsMap.put("splitExecuteLatency", experimentMetrics.getSplitExecuteLatency());
        metricsMap.put("splitProcessLatency", experimentMetrics.getSplitProcessLatency());
        metricsMap.put("splitEmitted", experimentMetrics.getSplitEmitted());
        metricsMap.put("splitTransferred", experimentMetrics.getSplitTransferred());
        metricsMap.put("splitAcked", experimentMetrics.getSplitAcked());
        metricsMap.put("splitFailed", experimentMetrics.getSplitFailed());
        metricsMap.put("splitCapacity", experimentMetrics.getSplitCapacity());

        System.out.println("experimentName:" + experimentName + " before:" + setBefore + " after:" + setAfter);

        experimentMap.put(experimentName, metricsMap);
    }

    void createExperimentMetrics(int run, RunMetrics runMetrics)
    {
        experimentMetrics.getTotalTransferred().add(run, runMetrics.getTotalTransferredTuple());
        experimentMetrics.getTotalEmitted().add(run, runMetrics.getTotalEmittedTuple());
        experimentMetrics.getTotalAcked().add(run, runMetrics.getTotalAckedTuple());
        experimentMetrics.getTotalCompleteLatency().add(run, runMetrics.getTotalCompleteLatencyTuple());
        experimentMetrics.getTotalFailed().add(run, runMetrics.getTotalFailedTuple());

        experimentMetrics.getAckerExecuteLatency().add(run, runMetrics.getAckerExecuteLatencyTuple());
        experimentMetrics.getAckerProcessLatency().add(run, runMetrics.getAckerProcessLatencyTuple());
        experimentMetrics.getAckerEmitted().add(run, runMetrics.getAckerEmittedTuple());
        experimentMetrics.getAckerTransferred().add(run, runMetrics.getAckerTransferredTuple());
        experimentMetrics.getAckerAcked().add(run, runMetrics.getAckerAckedTuple());
        experimentMetrics.getAckerFailed().add(run, runMetrics.getAckerFailedTuple());
        experimentMetrics.getAckerCapacity().add(run, runMetrics.getAckerCapacityTuple());

        experimentMetrics.getCountExecuteLatency().add(run, runMetrics.getCountExecuteLatencyTuple());
        experimentMetrics.getCountProcessLatency().add(run, runMetrics.getCountProcessLatencyTuple());
        experimentMetrics.getCountEmitted().add(run, runMetrics.getCountEmittedTuple());
        experimentMetrics.getCountTransferred().add(run, runMetrics.getCountTransferredTuple());
        experimentMetrics.getCountAcked().add(run, runMetrics.getCountAckedTuple());
        experimentMetrics.getCountFailed().add(run, runMetrics.getCountFailedTuple());
        experimentMetrics.getCountCapacity().add(run, runMetrics.getCountCapacityTuple());

        experimentMetrics.getSplitExecuteLatency().add(run, runMetrics.getSplitExecuteLatencyTuple());
        experimentMetrics.getSplitProcessLatency().add(run, runMetrics.getSplitProcessLatencyTuple());
        experimentMetrics.getSplitEmitted().add(run, runMetrics.getSplitEmittedTuple());
        experimentMetrics.getSplitTransferred().add(run, runMetrics.getSplitTransferredTuple());
        experimentMetrics.getSplitAcked().add(run, runMetrics.getSplitAckedTuple());
        experimentMetrics.getSplitFailed().add(run, runMetrics.getSplitFailedTuple());
        experimentMetrics.getSplitCapacity().add(run, runMetrics.getSplitCapacityTuple());
    }

    void parseDocument() {
        String input = this.fileName;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(input));
            String line;
            int lineNo = 0;
            int run = 0;
            int setBefore = 0, setAfter = 0;
            String experimentName = "";

            RunMetrics runMetrics = new RunMetrics(run);

            while ((line = reader.readLine()) != null) {

                lineNo++;

                if (lineNo == 1) {
                    experimentName = getFirstWordFromLine(line);
                    experimentMetrics = new ExperimentMetrics(experimentName);
                    continue;
                }

                if (lineNo % 2 == 0) {

                    if (lineNo % 2 == 0 && lineNo % 4 != 0) {
                        runMetrics.setBefore(line);
                        setBefore++;

                    } else {
                        runMetrics.setAfter(line);
                        setAfter++;
                    }

                }

                if ((lineNo - 1) % 4 == 0) {
                    createExperimentMetrics(run, runMetrics);


                    run++;
                    runMetrics = new RunMetrics(run);
                }

                if ((lineNo-1) % (4 * TOTAL_RUNS) == 0) {

                    System.out.println("Line:" + lineNo + " Creating map for experiment: " +experimentName);
                    createMetricsMap(experimentName, setBefore, setAfter);
                    setBefore=0;
                    setAfter=0;
                    run=0;
                    experimentName = getFirstWordFromLine(line);
                    experimentMetrics = new ExperimentMetrics(experimentName);
                    System.out.println("experMetricsName: " + experimentMetrics.getExperimentName());

                }



            }

            //When done reading the file create the metricsMap for the last experiment
            System.out.println("Line:" + lineNo + " Creating map for experiment: " +experimentName);
            createExperimentMetrics(run, runMetrics);
            createMetricsMap(experimentName, setBefore, setAfter);

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Map<String, List<Tuple>>> getExperimentMap() {
        return experimentMap;
    }



    /*
    *  Parse storm stats output and get "before" and "after" stats for:
    *  a) Total emitted and transferred tuples
    *  b) Execute, Process Latency and emitted tuples for both bolts (Count and Split)
    *
    *  Steps:
    *  1) For each run take before and after line
    *  2) Parse line and add respective fields to appropriate data structures
    * */


    public static String getFirstWordFromLine(String line)
    {
        return line.split(" ")[0];
    }
    public static void main(String[] args)
    {
       // StormParser stormParser = new StormParser("/Users/stratos/Development/stratos-results/BigData/perf_eval/raw-data/euca-00/storm-hadoop-summer.txt");
       // StormParser stormParser = new StormParser("/Users/stratos/Development/stratos-results/BigData/perf_eval/raw-data/euca-00/storm-spark-cg-summer.txt");
        StormParser stormParser = new StormParser("/Users/stratos/Development/stratos-results/BigData/perf_eval/raw-data/eci/storm-spark-fg.txt");

        Map<String, Map<String, List<Tuple>>> experimentMap = stormParser.getExperimentMap();


        for (String key : experimentMap.keySet())
        {
            System.out.println("Experiment: " + key);

            Map<String, List<Tuple>> metricsMap = experimentMap.get(key);
            for( String metricKey : metricsMap.keySet())
            {
                System.out.println("Metric: " + metricKey);
                ArrayList<Tuple> metricList = (ArrayList) metricsMap.get(metricKey);
                StatsPrinter statsPrinter = new StatsPrinter(metricList);
                statsPrinter.printResults();

            }
        }


    }

 }
