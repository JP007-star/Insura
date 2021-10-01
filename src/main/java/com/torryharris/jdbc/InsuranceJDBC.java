package com.torryharris.jdbc;
import com.torryharris.model.Insurance;
import java.sql.*;
import java.util.ArrayList;

public class InsuranceJDBC {
    public static void main(String[] args) {
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           String url = "jdbc:mysql://localhost:3306/company";
           String username = "root";
           String password = "Prasad@66";
           Connection connection = DriverManager.getConnection(url, username, password);
           System.out.println("Connected to DataBase Successfully");
           System.out.println();
           Statement statement = connection.createStatement();

           /* Inserting into data base
            ArrayList<Insurance> employeeArrayList = getInsurance();
            for (Insurance insurance:employeeArrayList) {
                String insertQuery = "insert into insurance values('" + insurance.getIns_name() + "'," + insurance.getIns_id() + "," + insurance.getSum() + ",'" + insurance.getIns_type() +  "');";
                System.out.println(insertQuery);
                statement.execute(insertQuery);
            }

            System.out.println("Insert the values Successfully");  */


           /* Retrieve Data from DataBase*/
           String query="select * from insurance";
           ResultSet result=statement.executeQuery(query);
           System.out.println("-------------Insurance Details are-------");
           while (result.next()){
               String ins_name=result.getString("ins_name");
               int ins_id=result.getInt("ins_id");
               int sum=result.getInt("sum");
               String ins_type=result.getString("ins_type");
               Insurance insurance=new Insurance(ins_name,ins_id,sum,ins_type);
               System.out.println(insurance);
           }
           System.out.println();


           /* Listing Term insurance */
           String termInsuranceQuery="select * from insurance where ins_type='Term'";
           ResultSet termInsurance=statement.executeQuery(termInsuranceQuery);
           System.out.println("------------Term Insurance Details are--------");
           while (termInsurance.next()){
               String ins_name=termInsurance.getString("ins_name");
               int ins_id=termInsurance.getInt("ins_id");
               int sum=termInsurance.getInt("sum");
               String ins_type=termInsurance.getString("ins_type");
               Insurance termInsuranceObj=new Insurance(ins_name,ins_id,sum,ins_type);
               System.out.println(termInsuranceObj);
           }
           System.out.println();
             /*Order by sum insurance */
           String queryOrderBySum="select * from insurance order by sum";
           ResultSet orderBySum= statement.executeQuery(queryOrderBySum);
           System.out.println("--------------Order by sum insurance---------");
           while(orderBySum.next()){
               String ins_name=orderBySum.getString("ins_name");
               int ins_id=orderBySum.getInt("ins_id");
               int sum=orderBySum.getInt("sum");
               String ins_type=orderBySum.getString("ins_type");
               Insurance orderBySumObj=new Insurance(ins_name,ins_id,sum,ins_type);
               System.out.println(orderBySumObj);
           }
           System.out.println();
           /*  Sum Insurance greater than  300000*/
           String sumInsuranceQuery="select * from insurance where sum>=300000";
           ResultSet sumInsurance=statement.executeQuery(sumInsuranceQuery);
           System.out.println("--------------Sum Insurance greater that 300000--------------");
           while(sumInsurance.next()){
               String ins_name=sumInsurance.getString("ins_name");
               int ins_id=sumInsurance.getInt("ins_id");
               int sum=sumInsurance.getInt("sum");
               String ins_type=sumInsurance.getString("ins_type");
               Insurance sumInsuranceObj=new Insurance(ins_name,ins_id,sum,ins_type);
               System.out.println(sumInsuranceObj);
           }
           System.out.println();

           /*Increase all sum insurance by 20%*/
           String increaseSumQuery=" select ins_name,ins_id,sum+(sum*0.25) as sumInsurance,sum,ins_type from insurance where ins_type='Health'";
           ResultSet increaseSum=statement.executeQuery(increaseSumQuery);
           System.out.println("---------------Increase the Sum Insurance By 25%-----------");
           while (increaseSum.next()){
               String ins_name=increaseSum.getString("ins_name");
               int ins_id=increaseSum.getInt("ins_id");
               int sum=increaseSum.getInt("sumInsurance");
               String ins_type=increaseSum.getString("ins_type");
               Insurance increaseSumObj=new Insurance(ins_name,ins_id,sum,ins_type);
               System.out.println(increaseSumObj);
           }
           System.out.println();


           statement.close();
           connection.close();
       }
       catch(ClassNotFoundException |  SQLException exception){
          exception.printStackTrace();
       }
    }

    private static ArrayList<Insurance> getInsurance() {
        Insurance ins1=new Insurance("HDFC",10023,3000000,"Health");
        Insurance ins2=new Insurance("LIC",10024,4000000,"Term");
        Insurance ins3=new Insurance("ICICI",10025,5000000,"Health");
        Insurance ins4=new Insurance("AXIS",10026,6000000,"Term");
        Insurance ins5=new Insurance("LIC",10027,1000000,"Term");
        Insurance ins6=new Insurance("HDFC",10028,7000000,"Health");
        ArrayList<Insurance> insuranceArrayList=new ArrayList<>();
        insuranceArrayList.add(ins1);
        insuranceArrayList.add(ins2);
        insuranceArrayList.add(ins3);
        insuranceArrayList.add(ins4);
        insuranceArrayList.add(ins5);
        insuranceArrayList.add(ins6);
        return  insuranceArrayList;

    }



}
