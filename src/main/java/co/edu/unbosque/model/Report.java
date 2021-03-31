package co.edu.unbosque.model;

/**
 * Class Report
 */
public class Report {
    private String species;
    private String size;
    private String location;
    public String direction;
    private String name_Of_Individual;
    private int persons_Phone;
    private String email_Of_The_Person;
    private String comments;

    /**
     * Report class constructor
     *
     * @param species             report species
     * @param size                report size
     * @param location            report location
     * @param direction           report direction
     * @param name_Of_Individual  report name
     * @param persons_Phone       report phone
     * @param email_Of_The_Person report email
     * @param comments            report comments
     */
    public Report(String species, String size, String location, String direction, String name_Of_Individual, int persons_Phone, String email_Of_The_Person, String comments) {
        this.species = species;
        this.size = size;
        this.location = location;
        this.direction = direction;
        this.name_Of_Individual = name_Of_Individual;
        this.persons_Phone = persons_Phone;
        this.email_Of_The_Person = email_Of_The_Person;
        this.comments = comments;
    }

    /**
     * @return the species returns
     */
    public String getSpecies() {
        return species;
    }

    /**
     * @param species pet species reported
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * @return return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size reported pet size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return return the locality
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location locality of the reported animal
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return returns the address of the reported pet
     */
    public String getDirection() {
        return direction;
    }

    /**
     * @param direction mascot address
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * @return returns the name of the person making the report
     */
    public String getName_Of_Individual() {
        return name_Of_Individual;
    }

    /**
     * @param name_Of_Individual Name of individual
     */
    public void setName_Of_Individual(String name_Of_Individual) {
        this.name_Of_Individual = name_Of_Individual;
    }

    /**
     * @return returns the phone number of the person who reports
     */
    public int getPersons_Phone() {
        return persons_Phone;
    }

    /**
     * @param persons_Phone phone number
     */
    public void setPersons_Phone(int persons_Phone) {
        this.persons_Phone = persons_Phone;
    }

    /**
     * @return return the email of the person making the report
     */
    public String getEmail_Of_The_Person() {
        return email_Of_The_Person;
    }

    /**
     * @param email_Of_The_Person email from a person
     */
    public void setEmail_Of_The_Person(String email_Of_The_Person) {
        this.email_Of_The_Person = email_Of_The_Person;
    }

    /**
     * @return returns the comment made by the person who reports
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments report comment
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}
