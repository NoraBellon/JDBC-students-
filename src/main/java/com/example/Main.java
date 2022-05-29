package com.example;

import servers.StudentServerImpl;
import servers.StudentsServer;

public class Main {
    public static void main(String[] args) {
    /*StudentFormatDaoImpl first = new StudentFormatDaoImpl();
    Optional<StudentFormat> student = first.get(146);
    List<StudentFormat> student1 = first.getByName("Tolik");
    System.out.println(student1);
    //System.out.println(format);
        StudentFormat st = new StudentFormat();
        st.setId(103);
        st.setTitle("Lera");
       System.out.println(first.update(st)); */

        StudentsServer server = new StudentServerImpl();
        server.findByName("Tolik");
        server.getAllStudents();

    }
}
