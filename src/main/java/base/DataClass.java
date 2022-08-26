package base;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class DataClass extends Base{

    @DataProvider(name = "getData")
    private static Object[][] getExcelData() throws IOException {
        Object[][] data;

        FileInputStream fis = new FileInputStream("./resources/data.xlsx");

        log.info("Successfully loaded Excel Data file.");

        XSSFWorkbook wrkbk = new XSSFWorkbook(fis);
        XSSFSheet sheet = wrkbk.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colCount = row.getLastCellNum();

        data = new Object[rowCount][colCount];

        for(int i = 0; i < rowCount; i++) {
            row = sheet.getRow(i);
            for(int j = 0; j < colCount; j++) {
                data[i][j] = row.getCell(j).toString();
            }
        }

        log.info("Successfully read all data.");
        return data;
    }
}
