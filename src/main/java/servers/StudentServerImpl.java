package servers;
import com.example.StudentFormat;
import dao.StudentFormatDaoImpl;
import dao.StudentFormatDao;

public class StudentServerImpl  implements StudentsServer {
    private StudentFormatDao dao = new StudentFormatDaoImpl();

    @Override
    public void getAllStudents() {
        System.out.println(dao.getAll());
    }

    @Override
    public void findStudent(int id) {
        System.out.println(dao.get(id));
    }

    @Override
    public void findByName(String name) {
        System.out.println(dao.getByName(name));
    }

    @Override
    public void writeInNewStudent(StudentFormat format) {
        System.out.println(dao.create(format));
    }

    @Override
    public void updateInfoOfStudent(StudentFormat format) {
        System.out.println(dao.update(format));
    }

    @Override
    public void delete(int id) {
        System.out.println(dao.delete(id));
    }
}
