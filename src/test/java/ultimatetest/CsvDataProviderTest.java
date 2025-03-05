package ultimatetest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.CsvUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvDataProviderTest {

    @DataProvider(name = "csvData")
    public Object[][] getCsvData() throws IOException {
        // Read the CSV data from the resources folder (located in src/main/resources)
        List<Map<String, String>> data = CsvUtils.readCsvData("data.csv");

        // Convert List<Map<String, String>> into 2D Object array for TestNG
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i); // Wrap each map into an object array
        }
        return dataArray;
    }

    @Test(dataProvider = "csvData")
    public void testCsvData(Map<String, String> rowData) {
        // Access data from the map using the column names as keys
        String name = rowData.get("Name");
        String age = rowData.get("Age");
        String country = rowData.get("Country");

        // Example of what we might do with this data
        System.out.println("Name: " + name + ", Age: " + age + ", Country: " + country);

        // Example assertion (you can customize based on your data)
        // Example: Assert.assertTrue(Integer.parseInt(age) > 18, "Age must be greater than 18");
    }
}

