package Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by qaasiem on 2017-08-03.
 */
@Entity
public class Employee implements Person, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String password;
    private String jobDescription;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="employee_id")
    private List<CustomerServices> repairList;

    public Employee() {
    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public List<CustomerServices> getRepairList() {
        return repairList;
    }

    public Employee (Builder builder)
    {
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        address = builder.address;
        password = builder.password;
        jobDescription = builder.jobDescription;
        repairList = builder.repairList;
    }

    public static class Builder
    {
        private Long id;
        private String firstName;
        private String lastName;
        private String address;
        private String password;
        private String jobDescription;
        private List<CustomerServices> repairList;

        public Builder (String lastName)
        {
            this.lastName = lastName;
        }

        public Builder firstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder address(String address)
        {
            this.address = address;
            return this;
        }

        public Builder password(String password)
        {
            this.password = password;
            return this;
        }

        public Builder jobDescription(String jobDescription)
        {
            this.jobDescription = jobDescription;
            return this;
        }

        public Builder repairList(List<CustomerServices> repairList)
        {
            this.repairList = repairList;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Employee employee)
        {
            this.id = employee.id;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.address = employee.address;
            this.password = employee.password;
            this.jobDescription = employee.jobDescription;
            this.repairList = employee.repairList;

            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return id.equals(employee.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Name: " + firstName + "" + "Surname: " + lastName + "Job Desc.: " + jobDescription;
    }
}
