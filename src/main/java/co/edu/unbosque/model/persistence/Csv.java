package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Case;
import co.edu.unbosque.model.Report;
import co.edu.unbosque.model.dao.CaseDao;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

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
    }

    /**
     * Method to read a csv file
     * <p>pre</p>The file must be != null<br>
     * <p>post</p>The file data is saved in the Case list<br>
     *
     * @param file csv file
     * @param list case list
     */
    public void read_File(String file, List<Case> list) {
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CSVParser csvParser = null;
        try {
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Species", "Size", "Location", "Address", "Name", "Phone",
                    "Email", "Comments", "Type of case", "Date and Time").withIgnoreHeaderCase().withTrim());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            int aux = 0;
            for (CSVRecord csvRecord : csvParser) {
                if (0 != aux) {
                    String species = csvRecord.get(0);
                    String size = csvRecord.get(1);
                    String location = csvRecord.get(2);
                    String address = csvRecord.get(3);
                    String name = csvRecord.get(4);
                    String phone = csvRecord.get(5);
                    String email = csvRecord.get(6);
                    String comments = csvRecord.get(7);
                    String type_Of_Case = csvRecord.get(8);
                    String date = csvRecord.get(9);
                    report = new Report(species, size, location, address, name, phone, email, comments);
                    Case aCase = new Case(report, type_Of_Case, date);
                    list.add(aCase);
                } else {
                    aux = aux + 1;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * <p>pre</p>Must see data in the list<br>
     * <p>post</p> The list of cases is written to a csv file<br>
     *
     * @param file File where the list is written
     * @param list case list
     */
    public void write_File(String file, List<Case> list) {
        FileWriter fileWriter = null;
        CSVPrinter csvPrinter = null;
        String[] CSV_HEADER = {"Species", "Size", "Location", "Address", "Name", "Phone",
                "Email", "Comments", "Type of case", "Date and Time"};

        try {
            fileWriter = new FileWriter(file);
            csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader(CSV_HEADER));

            for (int i = 0; i < list.size(); i++) {
                List data = Arrays.asList(
                        list.get(i).getReport().getSpecies(),
                        list.get(i).getReport().getSize(),
                        list.get(i).getReport().getLocation(),
                        list.get(i).getReport().getDirection(),
                        list.get(i).getReport().getName_Of_Individual(),
                        list.get(i).getReport().getPersons_Phone(),
                        list.get(i).getReport().getEmail_Of_The_Person(),
                        list.get(i).getReport().getComments(),
                        list.get(i).getType_Of_Case(),
                        list.get(i).getDate());
                csvPrinter.printRecord(data);
            }

            System.out.println("Write CSV successfully!");
        } catch (Exception e) {
            System.out.println("Writing CSV error!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvPrinter.close();
            } catch (IOException e) {
                System.out.println("Flushing/closing error!");
                e.printStackTrace();
            }
        }
    }
}





