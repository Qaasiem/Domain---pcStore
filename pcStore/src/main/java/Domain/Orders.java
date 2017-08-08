package Domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * Created by qaasiem on 2017-08-04.
 */
@Entity
public class Orders implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="order_id")
    private List<Software> softwareList;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="order_id")
    private List<Hardware> hardwareList;
    private double totalPrice = 0;

    public Orders() {
    }

    public Long getID() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public List getSoftware() {
        return softwareList;
    }

    public List getHardware() {
        return hardwareList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Orders(Builder builder)
    {
        id = builder.id;
        date = builder.date;
        softwareList = builder.softwareList;
        hardwareList = builder.hardwareList;
        totalPrice = builder.totalPrice;
    }

    public static class Builder
    {
        private Long id;
        private String date;
        private List<Software> softwareList;
        private List<Hardware> hardwareList;
        private double totalPrice = 0;

        public Builder(String date)
        {
            this.date = date;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder softwareList(List softwareList)
        {
            this.softwareList = softwareList;
            return this;
        }

        public Builder hardwareList(List hardwareList)
        {
            this.hardwareList = hardwareList;
            return this;
        }

        public Builder totalPrice(double totalPrice)
        {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder copy(Orders orders)
        {
            this.date = orders.date;
            this.id = orders.id;
            this.softwareList = orders.softwareList;
            this.hardwareList = orders.hardwareList;
            this.totalPrice = orders.totalPrice;

            return this;
        }

        public Orders build()
        {
            return new Orders(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        return id.equals(orders.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Date: " + date + "" + "Total Price: R" + totalPrice;
    }
}


