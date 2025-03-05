package ultimatetest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelDataProviderTest {

    @DataProvider(name = "excelData")
    public Object[][] getExcelData() throws IOException {
        // Provide the file name and sheet name in the resources folder
        List<Map<String, Object>> data = ExcelUtils.readExcelData("data.xlsx", "Sheet1");

        // Convert the List<Map<String, Object>> into a 2D Object array for TestNG
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i); // Wrap the map in an Object array
        }
        return dataArray;
    }

    @Test(dataProvider = "excelData")
    public void testExcelData(Map<String, Object> rowData) {
        // Example test logic using data from the Excel sheet
        String name = (String) rowData.get("Name"); // Example: Get "Name" value
        Double age = (Double) rowData.get("Age"); // Example: Get "Age" value
        
        System.out.println("Name: " + name + ", Age: " + age);

        // Example assertion (you can customize based on your data)
        // Assert.assertTrue(age > 18, "Age must be greater than 18");
    }
}
