package app.model;

import javafx.beans.property.*;

public class Employee {
    //Declare Employees Table Columns
    private StringProperty employee_id;
    private  StringProperty first_name;
    private  StringProperty last_name;
    private  StringProperty email;
    private  StringProperty phone_number;
//    private SimpleObjectProperty<String> hire_date;
//    private StringProperty job_id;
//    private IntegerProperty salary;

    public Employee() {
        this("","","","","");
    }

    public Employee(String employee_id, String first_name, String last_name, String email, String phone_number) {
        this.employee_id = new SimpleStringProperty(employee_id);
        this.first_name = new SimpleStringProperty(first_name);
        this.last_name = new SimpleStringProperty(last_name);
        this.email = new SimpleStringProperty(email);
        this.phone_number = new SimpleStringProperty(phone_number);
//        this.hire_date = new SimpleObjectProperty<>(hire_date);
//        this.job_id = new SimpleStringProperty(job_id);
//        this.salary = new SimpleIntegerProperty(salary);
    }
    public String getEmployee_id() {
        return employee_id.get();
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id= new SimpleStringProperty(employee_id);
    }

    public String getFirst_name() {
        return first_name.get();
    }

    public void setFirst_name(String first_name) {
        this.first_name= new SimpleStringProperty(first_name);
    }

    public String getLast_name() {
        return last_name.get();
    }

    public void setLast_name(String last_name) {
        this.last_name = new SimpleStringProperty(last_name);
    }

    public String getEmail() {
        return email.get();
    }


    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public String getPhone_number() {
        return phone_number.get();
    }


    public void setPhone_number(String phone_number) {
        this.phone_number = new SimpleStringProperty(phone_number);
    }

//    public String getHire_date() {
//        return hire_date.get();
//    }
//
//    public void setHire_date(String hire_date) {
//        this.hire_date = new SimpleObjectProperty<>(hire_date);
//    }
//
//    public String getJob_id() {
//        return job_id.get();
//    }
//
//
//    public void setJob_id(String job_id) {
//        this.job_id = new SimpleStringProperty(job_id);
//    }

//    public int getSalary() {
//        return salary.get();
//    }
//
//
//    public void setSalary(int salary) {
//        this.salary = new SimpleIntegerProperty(salary);
//    }
   }