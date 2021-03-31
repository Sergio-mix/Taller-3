package co.edu.unbosque.controller;

import co.edu.unbosque.model.dao.CaseDao;
import co.edu.unbosque.model.persistence.Csv;
import co.edu.unbosque.model.Report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class Controller
 */
public class Controller {
    private CaseDao caseDao;
    private Report report;
    private Csv cvs;

    /**
     * Controller class constructor
     */
    public Controller() {

    }

    /**
     * Method to register a report
     * <p>pre</p> All entries must be != null, the file records! = null<br>
     * <p>post</p> A Report object is created, with the report object and the type of case,
     * the registe_Case request of the CaseDao class is executed,
     * the case list data is saved in the records file<br>
     *
     * @param species             report species
     * @param size                report size
     * @param location            report location
     * @param direction           report direction
     * @param name_Of_Individual  report name
     * @param persons_Phone       report phone
     * @param email_Of_The_Person report email
     * @param comments            report comments
     * @param type_Of_Case        type of case
     */
    public void register_Report(String species, String size, String location, String direction,
                                String name_Of_Individual, int persons_Phone, String email_Of_The_Person,
                                String comments, String type_Of_Case) {
        //Report log
        report = new Report(species, size, location, direction, name_Of_Individual, persons_Phone, email_Of_The_Person, comments);
        //Case record
        caseDao.registe_Case(report, type_Of_Case, get_Date_And_Time());
        cvs.write_File("./records.csv");
    }

    /**
     * Method to get the date and time
     *
     * @return returns the date and time in a String
     */
    public String get_Date_And_Time() {
        Date date = new Date();
        //hourly format
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        //format by date
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //Date and time
        String date_Case = "Date: " + dateFormat.format(date) + " Hour: " + hourFormat.format(date);

        return date_Case;
    }
}
