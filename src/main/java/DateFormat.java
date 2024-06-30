import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormat {
    public static void main(String[] args) {
//        // The date string in ISO 8601 format with a 'Z' indicating UTC
//        String dateString = "2021-05-31T18:30:00.000Z";
//
//        // Parse the string to a ZonedDateTime object
//        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateString, DateTimeFormatter.ISO_ZONED_DATE_TIME);
//
//        // Convert the ZonedDateTime to an Instant
//        Instant instant = zonedDateTime.toInstant();
//
//        // Convert the Instant to a java.util.Date
//        Date date = Date.from(instant);
//
//        // Format the Instant to a string in UTC
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").withZone(ZoneOffset.UTC);
//        String formattedDate = formatter.format(instant);
//
//        // Print the date
//        System.out.println("Converted Date: " + formattedDate);
//

        String dateString = "2021-05-31T18:30:00.000Z";

        // Parse the string to a ZonedDateTime object in UTC
        ZonedDateTime utcZonedDateTime = ZonedDateTime.parse(dateString, DateTimeFormatter.ISO_ZONED_DATE_TIME);

        // Convert the UTC ZonedDateTime to the Indian time zone (Asia/Kolkata)
        ZoneId indiaZoneId = ZoneId.of("Asia/Kolkata");
        ZonedDateTime indiaZonedDateTime = utcZonedDateTime.withZoneSameInstant(indiaZoneId);

        // Format the ZonedDateTime to a string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String formattedDate = formatter.format(indiaZonedDateTime);

        // Print the converted date
        System.out.println("Converted Date in India Time Zone: " + formattedDate);
    }
}
