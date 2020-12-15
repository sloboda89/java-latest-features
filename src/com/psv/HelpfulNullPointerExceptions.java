package com.psv;

public class HelpfulNullPointerExceptions {
    public static void main(String[] args) {
        Student student = new Student();
        student.getCourse().getMark().isPositive();
        /*
        Exception in thread "main" java.lang.NullPointerException: Cannot invoke "com.psv.HelpfulNullPointerExceptions$Student$Course.getMark()" because the return value of "com.psv.HelpfulNullPointerExceptions$Student.getCourse()" is null
	at com.psv.HelpfulNullPointerExceptions.main(HelpfulNullPointerExceptions.java:6)
         */
    }

    static class Student {

        Course getCourse() {
            return null;
        }

        static class Course {

            Mark getMark() {
                return null;
            }

            static class Mark {

                Boolean isPositive() {
                    return null;
                }
            }
        }
    }
}
