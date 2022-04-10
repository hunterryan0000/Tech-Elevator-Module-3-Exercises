package com.techelevator;

public class HomeworkAssignment {

    //instance variables
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    // constructor
    public HomeworkAssignment () {};

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
            double grade = (double) earnedMarks / possibleMarks;

            if (grade >= .9) {
                return "A";
            } else if (grade >= .8) {
                return "B";
            } else if (grade >= .7) {
                return "C";
            } else if (grade >= .6) {
                return "D";
            }

                return "F";

    }
}
