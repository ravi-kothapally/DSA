//package com.dsa.test;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.sql.Timestamp;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeParseException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVRecord;
//
////@RestController
//public class CSVController {
//
////  @GetMapping("/analyze-csv")
//public static void main(String[] args) throws IOException {
//  final Map<String, String> stringStringMap = analyzeCsv();
//  stringStringMap.forEach((s, s2) -> {
//    System.out.println(s+" :"+s2);
//  });
//
//}
//  public static Map<String, String> analyzeCsv() throws IOException {
//    URL url = new URL("https://cdn.aidtaas.com/124/125/123/3e24a0c6-da61-45fe-a16e-2e2738bbd52f_$$data.csv");
//    InputStream inputStream = url.openStream();
//
//    // Read the CSV file using Apache Commons CSV
//    CSVParser csvParser = CSVFormat.DEFAULT.parse(new InputStreamReader(inputStream));
//
//    // Get the first few records to determine keys and data types
//    CSVRecord headers = csvParser.iterator().next();
//    CSVRecord secondRecord= csvParser.iterator().next();
//
//    // Map to store keys and their data types
//    Map<String, String> keyDataTypes = new HashMap<>();
//
//    // Analyze the  record to determine keys and data types
//    for (int i = 0; i < headers.size(); i++) {
//      String key = headers.get(i);
//      Class<?> dataType = inferDataType(secondRecord.get(i));
//      keyDataTypes.put(key, dataType.getSimpleName().toLowerCase());
//    }
//
//    return keyDataTypes;
//  }
//
//  private static Class<?> inferDataType(String value) {
//    if ("true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value)) {
//      return Boolean.class;
//    }
//    try {
//      Integer.parseInt(value);
//      return Integer.class;
//    } catch (NumberFormatException e1) {
//      try {
//        Double.parseDouble(value);
//        return Double.class;
//      } catch (NumberFormatException e2) {
//        try {
//          // Attempt to parse as LocalDate
//          LocalDate.parse(value);
//          return Date.class;
//        } catch (DateTimeParseException e3) {
//          try {
//            SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = timestampFormat.parse(value);
//            return Timestamp.class;
//          } catch (ParseException e4) {
//            // If parsing fails, consider it as String
//            return String.class;
//          }
//        }
//      }
//    }
//  }
//
//}
//
