package enumeration;

public enum CategoryEnum {

    BOOK("livres"),
    FOOD("nourriture"),
    MEDECINE("médecine"),
    OTHER("autre catégorie")
    ;

    private CategoryEnum(String description){
        this.description = description;
    }

    private String description;
}
