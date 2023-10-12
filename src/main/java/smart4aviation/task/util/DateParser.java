package smart4aviation.task.util;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

public class DateParser {

    static public Optional<Date> parseDateFromString(String dateString) {
        return Optional.of(
                Date.from(
                        Instant.parse(dateString)
                ));
    }

}
