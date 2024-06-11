package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    //TODO  сменить имя csv файла

    @DataProvider
    public Iterator<Object[]> userCSVFile() throws IOException {
        List<Object[]> userData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("src/test/resources/userdata.csv"))) {
            List<String[]> allRows = reader.readAll();
            for (String[] row : allRows) {
                userData.add(row);

            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return userData.iterator();
    }



}
