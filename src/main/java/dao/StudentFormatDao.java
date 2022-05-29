package dao;

import com.example.StudentFormat;

import java.util.List;
import java.util.Optional;

public interface StudentFormatDao {

    List<StudentFormat> getAll();
    Optional<StudentFormat> get(int id);
    List<StudentFormat> getByName(String name);
    StudentFormat create(StudentFormat format );
    boolean update(StudentFormat format);
    boolean delete(int id);

}
