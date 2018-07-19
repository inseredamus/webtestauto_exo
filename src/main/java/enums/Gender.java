package enums;

public enum Gender {
    MALE("Mr"),
    FEMALE("Mrs"),
    ;

    String title;

    Gender(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
