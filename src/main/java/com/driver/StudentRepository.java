package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    private HashMap<String,Student> studentHashMap;
    private HashMap<String,Teacher> teacherHashMap;
    private HashMap<String,List<String>> studentTeacherMap;

    public StudentRepository(HashMap<String, Student> studentHashMap, HashMap<String, Teacher> teacherHashMap, HashMap<String, List<String>> studentTeacherMap) {
        this.studentHashMap = studentHashMap;
        this.teacherHashMap = teacherHashMap;
        this.studentTeacherMap = studentTeacherMap;
    }

    public void addStudent(Student student){
        studentHashMap.put(student.getName() , student);
    }

    public void addTeacher(Teacher teacher){
        teacherHashMap.put(teacher.getName(), teacher);
    }

    public void studentTeacherMapping(String studentName, String teacherName){
        if(studentHashMap.containsKey(studentName)&&teacherHashMap.containsKey(teacherName)){
            List<String> studentsList = new ArrayList<>();
            if(studentTeacherMap.containsKey(teacherName))
                    studentsList = studentTeacherMap.get(teacherName);
            studentsList.add(studentName);
            studentTeacherMap.put(teacherName,studentsList);
        }
    }

    public Student findStudentByName(String studentName){
        return studentHashMap.get(studentName);
    }

    public Teacher findTeacherByName(String teacherName){
        return teacherHashMap.get(teacherName);
    }

    public List<String> findStudentsByTeacherName(String teacherName){
        List<String> students=new ArrayList<>();
        if(studentTeacherMap.containsKey(teacherName))
            students = studentTeacherMap.get(teacherName);
        return students;
    }

    public List<String> findAllStudents(){
        List<String> students = new ArrayList<>();
        for(String studentName: studentHashMap.keySet())
            students.add(studentName);
        return students;
    }

    public void deleteTeacherByName(String teacherName){
        List<String> students = new ArrayList<>();
        if (studentTeacherMap.containsKey(teacherName))
            students = studentTeacherMap.get(teacherName);
        for(String studentName : students)
            if(studentHashMap.containsKey(studentName))
                studentHashMap.remove(studentName);
        teacherHashMap.remove(teacherName);
        studentTeacherMap.remove(teacherName);
    }

    public void deleteAll(){
        List<String> teacher = new ArrayList<>();
        teacher.addAll(studentTeacherMap.keySet());
        for(String teacherName : teacher)
            studentTeacherMap.remove(teacherName);
        List<String> student = new ArrayList<>();
        student.addAll(studentHashMap.keySet());
        for(String studentName : student)
            studentHashMap.remove(studentName);
        List<String> studentTeacher =new ArrayList<>();
        for(String teacherName : studentTeacher)
            teacherHashMap.remove(teacherName);
    }
}
