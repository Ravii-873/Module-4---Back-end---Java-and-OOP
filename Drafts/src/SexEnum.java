public enum SexEnum {
    MALE("Male"),
    FEMALE("Female"),
    TRANS("Trans"),
    ELETROLUX("Eletrolux"),
    OTHER("Other"),
    PREFERNOTTOINFORM("Did not inform");

    private String description;

    SexEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
