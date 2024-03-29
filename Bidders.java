package virtualAuction.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Bidders {

    @Id
    private Integer bidderAdhar; // Unique identifier for the bidder
    private String bidderName;   // Name of the bidder
    private Integer bidderAge;   // Age of the bidder
    
    @OneToMany(mappedBy = "bidder")  // OneToMany relationship with Bidamount
    private List<Bidamount> bidamounts;  // List to hold associated Bidamount objects

    // Default constructor
    public Bidders() {
        // default constructor
    }

    // Parameterized constructor
    public Bidders(Integer bidderAdhar, String bidderName, Integer bidderAge) {
        this.bidderAdhar = bidderAdhar;
        this.bidderName = bidderName;
        this.bidderAge = bidderAge;
    }

    // Getter and setter methods for all fields

    public Integer getBidderAdhar() {
        return bidderAdhar;
    }

    public void setBidderAdhar(Integer bidderAdhar) {
        this.bidderAdhar = bidderAdhar;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public Integer getBidderAge() {
        return bidderAge;
    }

    public void setBidderAge(Integer bidderAge) {
        this.bidderAge = bidderAge;
    }

    public List<Bidamount> getBidamounts() {
        return bidamounts;
    }

    public void setBidamounts(List<Bidamount> bidamounts) {
        this.bidamounts = bidamounts;
    }
}
