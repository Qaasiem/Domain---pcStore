package Domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Created by qaasiem on 2017-08-05.
 */
@Entity
public class Supplier implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String contactNumber;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="supplier_id")
    private List<Branch> branches;

    public Supplier() {
    }

    public Long getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public List<Branch> getBramches() {
        return branches;
    }

    public Supplier (Builder builder)
    {
        id = builder.id;
        name = builder.name;
        address = builder.address;
        contactNumber = builder.contactNumber;
        branches = builder.branches;
    }

    public static class Builder
    {
        private Long id;
        private String name;
        private String address;
        private String contactNumber;
        private List<Branch> branches;

        public Builder(String name)
        {
            this.name = name;
        }

        public Builder address(String address)
        {
            this.address = address;
            return this;
        }

        public Builder contactNumber(String contactNumber)
        {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder branches(List<Branch> branches)
        {
            this.branches = branches;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Supplier supplier)
        {
            this.id = supplier.id;
            this.name = supplier.name;
            this.address = supplier.address;
            this.contactNumber = supplier.contactNumber;
            this.branches = supplier.branches;

            return this;
        }

        public Supplier build()
        {
            return new Supplier(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        return id.equals(supplier.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Name: " + name + "" + "Address: " + address;
    }
}

