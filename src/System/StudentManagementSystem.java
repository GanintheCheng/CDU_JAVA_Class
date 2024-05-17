package System;

import module.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    private final List<Student> students = new ArrayList<>();

    public void GoSystem() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n学生管理系统");
            System.out.println("1. 显示学生");
            System.out.println("2. 增加学生");
            System.out.println("3. 删除学生");
            System.out.println("4. 搜索学生");
            System.out.println("5. 退出系统");
            System.out.print("请输入选项: ");
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("choice输入不合法");
            }

            switch (choice) {
                case 1:
                    displayStudents();
                    break;
                case 2:
                    addStudent(scanner);
                    break;
                case 3:
                    deleteStudent(scanner);
                    break;
                case 4:
                    searchStudent(scanner);
                    break;
                case 5:
                    System.out.println("系统已退出。");
                    System.exit(0);
                default:
                    System.out.println("无效选项，请重新输入。");
            }
        }
    }

    private void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("没有学生信息。");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private void addStudent(Scanner scanner) {
        System.out.print("请输入学生学号: ");
        int id = 0;
        try {
            id = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("id输入格式不合法");
            return;
        }
        System.out.print("请输入学生姓名: ");
        String name = scanner.next();
        students.add(new Student(id, name));
        System.out.println("学生添加成功。");
    }

    private void deleteStudent(Scanner scanner) {
        System.out.print("请输入要删除的学生学号: ");
        int id = 0;
        try {
            id = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("id输入格式不合法");
            return;
        }
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getId() == id) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("学生删除成功。");
        } else {
            System.out.println("未找到学号为 " + id + " 的学生。");
        }
    }

    private void searchStudent(Scanner scanner) {
        System.out.print("请输入学生学号或姓名: ");
        String keyword = scanner.next();
        boolean found = false;
        for (Student student : students) {
            if ((student.getId() + "").equals(keyword) || student.getName().equalsIgnoreCase(keyword)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("未找到相关学生。");
        }
    }
}
