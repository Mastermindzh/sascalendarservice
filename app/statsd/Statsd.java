package statsd;

/**
 * This class will be the connection between Datadog and the application.
 */
public class Statsd {

    private static final StatsDClient statsd = new NonBlockingStatsDClient(
            "sascalendar",                          /* prefix to any stats; may be null or empty string */
            "localhost",                        /* common case: localhost */
            8125,                                 /* port */
            new String[]{"tag:value"}            /* Datadog extension: Constant tags, always applied */
    );

    /**
     * This method will increment the specified metic on Datadog.
     * @param metric The metic to increment
     */
    public static void increment(String metric) {
        statsd.increment(metric);
        serviceCheck();
    }

    /**
     * This method will send a recorded time to Datadog.
     * @param metric The metic to send the time to
     * @param timeInNano The time in Nanoseconds
     * @param miliseconds If the time needs to be converted to miliseconds or seconds. (Miliseconds if true, seconds if false)
     */
    public static void recordHistogramValue(String metric, long timeInNano, boolean miliseconds) {
        if (miliseconds == true) {
            statsd.recordHistogramValue(metric, timeInNano / 1000000); // to miliseconds
        } else {
            statsd.recordHistogramValue(metric, timeInNano / 1000000000); // to seconds
        }
        serviceCheck();
    }

    /**
     * Gets the statsdClient.
     * @return StatsDClient
     */
    public static StatsDClient statsd() {
        return statsd;
    }

    /**
     * Will send the info to Datadog and checks the service.
     */
    private static void serviceCheck() {

        ServiceCheck sc = ServiceCheck
                .builder()
                .withName("my.check.name")
                .withStatus(ServiceCheck.Status.OK)
                .build();
        statsd.serviceCheck(sc); /* Datadog extension: send service check status */

    }
}
