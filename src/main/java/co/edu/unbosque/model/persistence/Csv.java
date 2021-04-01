package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Report;
import co.edu.unbosque.model.dao.CaseDao;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class Csv
 */
public class Csv {
    private CaseDao caseDao;
    private Report report;

    /**
     * Csv class constructor
     */
    public Csv() {
        caseDao = new CaseDao();
        read_File("./records.csv");
    }

    /**
     * Method to read a csv file
     * <p>pre</p>The file must be != null<br>
     * <p>post</p>The file data is saved in the Case list<br>
     *
     * @param file csv file
     */
    public void read_File(String file) {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(file));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String species = csvRecord.get(0);
                String size = csvRecord.get(1);
                String location = csvRecord.get(2);
                String address = csvRecord.get(3);
                String name = csvRecord.get(4);
                String phone = csvRecord.get(5);
                String email = csvRecord.get(6);
                String comments = csvRecord.get(7);

                String type_Of_Case = csvRecord.get(8);
                String date_And_Time = csvRecord.get(9);

                report = new Report(species, size, location, address, name, Integer.parseInt(phone), email, comments);
                caseDao.registe_Case(report, type_Of_Case, date_And_Time);
            }
            write_File("./records.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                        .withHeader("Species", "Size", "Location", "Address", "Name", "Phone",
                                "Email", "Comments", "Type of case", "Date and Time"))
        ) {
            for (int i = 0; i < caseDao.getCase_List().size(); i++) {
                csvPrinter.printRecord(caseDao.getCase_List().get(i).getReport().getSpecies(),
                        caseDao.getCase_List().get(i).getReport().getSize(),
                        caseDao.getCase_List().get(i).getReport().getLocation(),
                        caseDao.getCase_List().get(i).getReport().getDirection(),
                        caseDao.getCase_List().get(i).getReport().getName_Of_Individual(),
                        caseDao.getCase_List().get(i).getReport().getPersons_Phone(),
                        caseDao.getCase_List().get(i).getReport().getEmail_Of_The_Person(),
                        caseDao.getCase_List().get(i).getReport().getComments(),
                        caseDao.getCase_List().get(i).getType_Of_Case(),
                        caseDao.getCase_List().get(i).getDate());
            }

            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


