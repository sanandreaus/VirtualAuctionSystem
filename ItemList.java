package virtualAuction.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemNumber; // Unique identifier for the item
    private String itemName;    // Name of the item
    private String itemOrigin;  // Origin or location of the item
    private Integer itemStartPrice; // Starting price for the item

    // Default constructor
    public ItemList() {
    }

    // Parameterized constructor
    public ItemList(Integer itemNumber, String itemName, String itemOrigin, Integer itemStartPrice) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.itemOrigin = itemOrigin;
        this.itemStartPrice = itemStartPrice;
    }

    // Getter and setter methods for all fields

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemOrigin() {
        return itemOrigin;
    }

    public void setItemOrigin(String itemOrigin) {
        this.itemOrigin = itemOrigin;
    }

    public Integer getItemStartPrice() {
        return itemStartPrice;
    }

    public void setItemStartPrice(Integer itemStartPrice) {
        this.itemStartPrice = itemStartPrice;
    }
}
