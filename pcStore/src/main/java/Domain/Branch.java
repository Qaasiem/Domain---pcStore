package Domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * Created by qaasiem on 2017-08-02.
 */
@Entity
public class Branch implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private String phoneNumber;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="branch_id")
    private List<Employee> employees;


    public Branch() {
    }

    public Long getID() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Branch (Builder builder)
    {
        id = builder.id;
        address = builder.address;
        phoneNumber = builder.phoneNumber;
        employees = builder.employees;
    }

    public static class Builder
    {
        private Long id;
        private String address;
        private String phoneNumber;
        private List<Employee> employees;

        public Builder (String address)
        {
            this.address = address;
        }

        public Builder phoneNumber(String phoneNumber)
        {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder employees(List<Employee> employees)
        {
            this.employees = employees;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Branch branch)
        {
            this.id = branch.id;
            this.address = branch.address;
            this.phoneNumber = branch.phoneNumber;
            this.employees = branch.employees;

            return this;
        }

        public Branch build()
        {
            return new Branch(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Branch branch = (Branch) o;

        return id.equals(branch.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Address: " + address;
    }
}
