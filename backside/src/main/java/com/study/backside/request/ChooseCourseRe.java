package com.study.backside.request;

public class ChooseCourseRe {
        private String number;
        private int courseId;
        private String courseCode;
        public ChooseCourseRe(String num, int id, String code){
            this.number = num;
            this.courseId = id;
            this.courseCode = code;
        }

        public String getNumber() {
            return number;
        }

        public int getCourseId() {
            return courseId;
        }

        public String getCourseCode() {
            return courseCode;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public void setCourseCode(String courseCode) {
            this.courseCode = courseCode;
        }
    }


