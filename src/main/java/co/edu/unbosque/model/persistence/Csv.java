package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.dao.CaseDao;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class Csv
 */
public class Csv {
    private CaseDao caseDao;

    /**
     * Csv class constructor
     */
    public Csv() {
    }

    /**
     * <p>pre</p> file !=null, must see data in the list<br>
     * <p>post</p> The list of cases is written to a csv file<br>
     *
     * @param file File where the list is written
     */
    public void write_File(String file) {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(file));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("Report", "Type of case", "Date and Time"));
        ) {
            for (int i = 0; i < caseDao.getCase_List().size(); i++) {
                csvPrinter.printRecord(caseDao.getCase_List().get(i).getReport(),
                        caseDao.getCase_List().get(i).getType_Of_Case(),
                        caseDao.getCase_List().get(i).getDate());
            }

            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


