package com.techelevator;

public class HomeworkAssignment {

    //instance variables
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    // constructor

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;

    }


        public String getSubmitterName () {
            return submitterName;
        }


    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getLetterGrade() {
            int grade = earnedMarks / possibleMarks;

            if (grade == 100) {
                return "100";
            } else if (grade >= 90) {
                return "A";
            } else if (grade >= 80) {
                return "B";
            } else if (grade >= 70) {
                return "C";
            } else if (grade >= 60) {
                return "D";
            }
            {
                return "F";
            }

    }
}
