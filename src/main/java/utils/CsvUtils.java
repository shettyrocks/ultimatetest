package utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CsvUtils {

    // Method to read CSV data from the resources folder (located in src/main/resources)
    public static List<Map<String, String>> readCsvData(String fileName) throws IOException {
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();

        // Get InputStream for the file in resources folder
        try (Reader reader = new InputStreamReader(
                CsvUtils.class.getClassLoader().getResourceAsStream(fileName))) {

            if (reader == null) {
                throw new IOException("File not found in resources: " + fileName);
            }

            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()  // Skip the header row
                    .parse(reader);

            // Iterate through CSV records and map them to a List of Maps
            for (CSVRecord record : records) {
                Map<String, String> rowMap = new java.util.HashMap<>();
                for (String header : record.toMap().keySet()) {
                    rowMap.put(header, record.get(header));
                }
                dataList.add(rowMap);
            }
        }
        return dataList;
    }
}
