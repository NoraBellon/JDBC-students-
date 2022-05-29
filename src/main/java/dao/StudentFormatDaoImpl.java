package dao;

import com.example.StudentFormat;
import util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentFormatDaoImpl implements StudentFormatDao {

    @Override
    public Optional<StudentFormat> get(int id){
       StudentFormat student = new StudentFormat();
        String s ="select * from students where id =" + id;
       // String s = "SELECT id, name FROM students WHERE id = ?";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(s);
             ResultSet resultSet = statement.executeQuery();
             ) {
              if(resultSet.next()) {
                  student.setId(resultSet.getInt(1));
                  student.setTitle(resultSet.getString(2));
                  student.setIs_deleted(resultSet.getBoolean(3));
                  return Optional.of(student);
              }
              else return Optional.empty();

        }

        catch(SQLException e ){
            throw new RuntimeException("There is no such student", e);
        }
        //return student;
    }

    @Override
   public  List<StudentFormat> getAll(){
        List<StudentFormat> allFormats = new ArrayList<>();
    try ( Connection connection = ConnectionUtil.getConnection();
              Statement getALLstudentsStatement = connection.createStatement();
                ){

            ResultSet resultSet =
                    getALLstudentsStatement.executeQuery("SELECT *   from students");

            while(resultSet.next()){
                String name = resultSet.getString("name");
                Integer id = resultSet.getObject("id", Integer.class);
                StudentFormat literaryFormat = new StudentFormat();
                literaryFormat.setId(id);
                literaryFormat.setTitle(name);
                allFormats.add(literaryFormat);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Can not execute db", e);
        }
        return allFormats;
    }

    @Override
    public StudentFormat create(StudentFormat format)
    {
        try ( Connection connection = ConnectionUtil.getConnection();
              Statement createFormatStatement = connection.createStatement();

        ){
            String insertFormatRequest = "INSERT INTO students(id, name) VALUES('"+ format.getId() +"','"+ format.getName() +"')";
            createFormatStatement.executeUpdate(insertFormatRequest);
        }catch (SQLException e) {
            throw new RuntimeException("Can`t insert format to db", e);

       }
        return null;
    }

    @Override
    //метод котрый должен найти по индексу этот элемент и заменить данные(имя) в нем на новые
    public boolean update(StudentFormat format) {
        int id = format.getId();
        String name = format.getName();
        String updateInfoOfStudnet = "UPDATE students SET name = '"+ format.getName()+"' WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateInfoOfStudnet);
        ){
             statement.setInt(1, id);
            return statement.executeUpdate() >= 1;
        }catch (SQLException e) {
            throw new RuntimeException("Can`t find such student", e);

        }


    }



    @Override
    public List<StudentFormat> getByName(String name){

        List<StudentFormat> allFormats = new ArrayList<>();
      //  String s = "SELECT *  FROM students WHERE name =" + name;

        try ( Connection connection = ConnectionUtil.getConnection();
              Statement getALLstudentsStatement = connection.createStatement();
              ResultSet resultSet =
                      getALLstudentsStatement.executeQuery("SELECT *  FROM students WHERE name = '"+ name + "' ");

        ){

            //ResultSetMetaData colums = resultSet.getMetaData();

            while(resultSet.next()){
                StudentFormat literaryFormat = new StudentFormat();

                literaryFormat.setId(resultSet.getObject("id", Integer.class));
                literaryFormat.setTitle(resultSet.getString("name"));
                allFormats.add(literaryFormat);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Can not execute db", e);
        }
        return allFormats;
    }

    @Override
    public boolean delete(int id) {
        String deletedRequest = "UPDATE students SET is_deleted = true where id = ?";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement createFormatStatement =
                     connection.prepareStatement(deletedRequest);
             ){
            createFormatStatement.setInt(1, id);
           return createFormatStatement.executeUpdate() >= 1;

        }catch (SQLException e) {
            throw new RuntimeException("Can`t delete format from db", e);

        }
    }
}
