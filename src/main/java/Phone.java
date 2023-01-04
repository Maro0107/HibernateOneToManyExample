import javax.persistence.*;


@Entity
@Table(name="phones")
public class Phone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private long id;
    private String type;
    private String number;

    public Phone() {
    }

    public Phone(String type, String number) {

        this.type = type;
        this.number = number;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
