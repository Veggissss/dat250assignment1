package dat250assignment1;

import io.javalin.Javalin;

public class App {
    private static final String WEBPAGE = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Convert units</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>Unit converter</h1>\n" +
            "<form action=\"/convert\" method=\"post\">\n" +
            "    <fieldset>\n" +
            "    <label for=\"val\">Value:</label>" +
            "    <input id=\"val\" type=\"text\" name=\"value\"><br />\n" +
            "    <label for=\"source-unit\">From unit:</label>\n" +
            "    <select name=\"sunit\" id=\"source-unit\">\n" +
            "        <option value=\"in\">Inches</option>\n" +
            "        <option value=\"ft\">Feet</option>\n" +
            "        <option value=\"mi\">Miles</option>\n" +
            "        <option value=\"m\">Metres</option>\n" +
            "    </select><br />\n" +
            "    <label for=\"target-unit\">To unit:</label>\n" +
            "    <select name=\"tunit\" id=\"target-unit\">\n" +
            "        <option value=\"in\">Inches</option>\n" +
            "        <option value=\"ft\">Feet</option>\n" +
            "        <option value=\"mi\">Miles</option>\n" +
            "        <option value=\"m\">Metres</option>\n" +
            "    </select><br />\n" +
            "    <input type=\"submit\" value=\"Calculate\" />\n" +
            "    </fieldset>\n" +
            "</form>\n" +
            "</body>\n" +
            "</html>";

    public static void main(String[] args) {
        Javalin.create()
                .get("/", ctx -> {
                    ctx.html(WEBPAGE);
                })
                .post("/convert", ctx -> {
                    double value = Double.parseDouble(ctx.formParam("value"));
                    String fromUnit = ctx.formParam("sunit");
                    String toUnit = ctx.formParam("tunit");
                    ctx.result(Double.toString(convertUnit(value, fromUnit, toUnit)));
                })
                .start(9000);
    }

    /**
     * Convert between two different units.
     *
     * @param value    : number value to convert.
     * @param fromUnit : Unit to convert from ["in","ft","mi","m"].
     * @param toUnit   : Unit to convert to ["in","ft","mi","m"].
     * @return converted value in toUnits.
     */
    public static double convertUnit(double value, String fromUnit, String toUnit) {
        final double IN_TO_METER = 0.0254;
        final double FT_TO_METER = 0.3048;
        final double MI_TO_METER = 1609.344;

        // Convert fromUnit to meters
        double inMeters = switch (fromUnit) {
            case "in" -> value * IN_TO_METER;
            case "ft" -> value * FT_TO_METER;
            case "mi" -> value * MI_TO_METER;
            case "m" -> value;
            default -> Double.NaN;
        };

        // Convert fromUnit in meters to toUnits
        return switch (toUnit) {
            case "in" -> inMeters / IN_TO_METER;
            case "ft" -> inMeters / FT_TO_METER;
            case "mi" -> inMeters / MI_TO_METER;
            case "m" -> inMeters;
            default -> Double.NaN;
        };
    }

}