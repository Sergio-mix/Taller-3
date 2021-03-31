package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.Case;
import co.edu.unbosque.model.Report;

import java.util.ArrayList;
import java.util.List;

/**
 * Class CaseDao
 */
public class CaseDao {
    private List<Case> Case_List;

    /**
     * Constructor of the CaseDao class
     */
    public CaseDao() {
        Case_List = new ArrayList<>();
    }

    /**
     * Method to create a case0
     * <p>pre</p> the report and the type must be! = of null<br>
     * <p>post</p> a case will be added to the list Case_List<br>
     *
     * @param report       Report
     * @param type_Of_Case type-of-report
     * @param data         fata
     */
    public void registe_Case(Report report, String type_Of_Case, String data) {
        Case create_Case = new Case(report, type_Of_Case, data);
        Case_List.add(create_Case);
    }

    /**
     * @return returns the case list
     */
    public List<Case> getCase_List() {
        return Case_List;
    }

    /**
     * @param case_List case list
     */
    public void setCase_List(List<Case> case_List) {
        Case_List = case_List;
    }
}
