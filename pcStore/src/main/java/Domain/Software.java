package Domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by qaasiem on 2017-08-05.
 */
@Entity
public class Software implements Inventory, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String manufacturer;
    private String name;
    private String category;
    private double price;

    public Software() {
    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public Software(Builder builder){
        id = builder.id;
        manufacturer = builder.manufacturer;
        name = builder.name;
        category = builder.category;
        price = builder.price;
    }

    public static class Builder
    {
        private Long id;
        private String manufacturer;
        private String name;
        private String category;
        private double price;

        public Builder(String name)
        {
            this.name = name;
        }

        public Builder manufacturer(String manufacturer)
        {
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder category(String category)
        {
            this.category = category;
            return this;
        }

        public Builder price(double price)
        {
            this.price = price;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Software software)
        {
            this.id = software.id;
            this.manufacturer = software.manufacturer;
            this.name = software.name;
            this.category = software.category;
            this.price = software.price;

            return this;
        }

        public Software build()
        {
            return new Software(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Software software = (Software) o;

        return id.equals(software.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Item Name: " + name + "" + "Manufacturer: " + manufacturer + "" + "Price: R" + price;
    }
}
