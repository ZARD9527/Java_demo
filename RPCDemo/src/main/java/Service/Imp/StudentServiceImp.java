package Service.Imp;

import Entity.Student;
import Service.StudentService;

/**
 * @author y1881
 * @date 2020.3.28 9:50
 */
public class StudentServiceImp implements StudentService {
    @Override
    public Student getInfo(){
        Student stu = new Student();
        stu.setID("9527");
        stu.setAge(10);
        stu.setName("yang");
        return stu;
    }
    @Override
    public void print(Student stu) {

    }
}
