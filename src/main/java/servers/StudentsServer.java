package servers;
import com.example.StudentFormat;
import dao.StudentFormatDao;
import dao.StudentFormatDaoImpl;

import java.util.List;
import java.util.Optional;

public interface StudentsServer {

    void getAllStudents();

    void findStudent(int id);

    void findByName(String name);

    void writeInNewStudent(StudentFormat format );

    void updateInfoOfStudent(StudentFormat format);

    void delete(int id);

}
