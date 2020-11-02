import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeOperations implements CRUD{
    List<Employee> employee_list = new ArrayList<>();

    @Override
    public void readData(Connection con) throws CustomException {
        try{
            String query = "Select * from employee";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                char gender = rs.getString(3).charAt(0);
                double salary = rs.getDouble(4);
                Date date = rs.getDate(5);
                long phone = rs.getLong(6);
                String address = rs.getString(7);
                String department = rs.getString(8);

                Employee emp = new Employee(id,name,gender,salary,date,phone,address,department);
                employee_list.add(emp);
            }
        }catch(Exception e){
            throw new CustomException("Read Process Unsuccessful");
        }
    }

    @Override
    public void insertData() {

    }

    @Override
    public void updateData() {

    }

    @Override
    public void deleteData() {

    }
}