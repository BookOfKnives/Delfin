package com.eksamen2002.demo.model;

public class Project {
//MIND MIG LIGE OM AT LAVE ALLE DE HER TING OM
        private int deptno;
        private String deptName;
        private String location;

        public Project(int deptno, String deptName, String location) {
            this.deptno = deptno;
            this.deptName = deptName;
            this.location = location;
        }

        public int getDeptno() {
            return this.deptno;
        }

        public void setDeptno(int deptno) {
            this.deptno = deptno;
        }

        public String getDeptName() {
            return this.deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public String getLocation() {
            return this.location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "deptno=" + deptno +
                    ", deptName='" + deptName + '\'' +
                    ", location='" + location + '\'' +
                    '}';
        }
    }
