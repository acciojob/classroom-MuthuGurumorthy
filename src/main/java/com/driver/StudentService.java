package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void studentTeacherMapping(String studentName,String teacherName){
        studentRepository.studentTeacherMapping(studentName,teacherName);
    }

    public Student findStudent(String studentName){
        return studentRepository.findStudentByName(studentName);
    }

    public Teacher findTeacher(String teacherName){
        return studentRepository.findTeacherByName(teacherName);
    }

    public List<String> findStudentsByTeacher(String teacher){
        return studentRepository.findStudentsByTeacherName(teacher);
    }

    public List<String> findAllStudents(){
        return studentRepository.findAllStudents();
    }

    public void deleteTeacher(String teacherName){
        studentRepository.deleteTeacherByName(teacherName);
    }

    public void deleteAll(){
        studentRepository.deleteAll();
    }
}
