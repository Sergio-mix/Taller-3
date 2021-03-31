package co.edu.unbosque.model;

/**
 * Class Case
 */
public class Case {
    private Report report;
    private String type_Of_Case;
    private String date;

    /**
     * Constructor of the Case class
     *
     * @param report       Report
     * @param type_Of_Case type of report
     * @param date         Date
     */
    public Case(Report report, String type_Of_Case, String date) {
        this.report = report;
        this.type_Of_Case = type_Of_Case;
        this.date = date;
    }

    /**
     * @return returns the report made by the person
     */
    public Report getReport() {
        return report;
    }

    /**
     * @param report report that the person made
     */
    public void setReport(Report report) {
        this.report = report;
    }

    /**
     * @return returns the type of report
     */
    public String getType_Of_Case() {
        return type_Of_Case;
    }

    /**
     * @param type_Of_Case type of report
     */
    public void setType_Of_Case(String type_Of_Case) {
        this.type_Of_Case = type_Of_Case;
    }

    /**
     * @return returns the case creation date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date case date
     */
    public void setDate(String date) {
        this.date = date;
    }
}
