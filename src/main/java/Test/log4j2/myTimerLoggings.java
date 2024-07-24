package Test.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class myTimerLoggings {
    private static Logger logger = LogManager.getLogger(myTimerLoggings.class);
    private static DateTimeFormatter toSecondsDateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static DateTimeFormatter toMinuteDateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:00");
    private static DateTimeFormatter toHourDateTimeFormatter = DateTimeFormatter.ofPattern("HH:00:00");

    public static void main(String[] args) {
        Timer debugTimer = new Timer();
        Timer infoTimer = new Timer();
        Timer errorTimer = new Timer();

        debugTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.debug(LocalDateTime.now().format(toSecondsDateTimeFormatter));
            }
        }, 0, 1000);

        infoTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.info(LocalDateTime.now().format(toMinuteDateTimeFormatter));
            }
        }, 0, 60000);

        errorTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.error(LocalDateTime.now().format(toHourDateTimeFormatter));
            }
        }, 0, 3600000);
    }
}
