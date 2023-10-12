package smart4aviation.task.util;

import java.util.Set;

public class IATACodeValidator {
    private final static Set<String> departureIATACode = Set.of("SEA", "YYZ", "YYT", "ANC", "LAX");
    private final static Set<String> arrivalIATACode = Set.of("MIT", "LEW", "GDN", "KRK", "PPX");

    public static boolean isValidIATADepartureCode(String IATACode) {
        return departureIATACode.contains(IATACode);
    }

    public static boolean isValidIATAArrivalsCode(String IATACode) {
        return arrivalIATACode.contains(IATACode);
    }
}
