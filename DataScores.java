package com.example.eliasteeny.likhascore;

/**
 * Created by eliasteeny on 7/22/17.
 */

public class DataScores {
    private int id=0;
    private String name1;
    private Integer score1;
    private String name2;
    private Integer score2;
    private String name3;
    private Integer score3;
    private String name4;
    private Integer score4;
    public DataScores(int id,String name1,Integer score1,String name2,Integer score2,String name3,Integer score3,String name4,Integer score4){
        this.id=id;
        this.name1=name1;
        this.score1=score1;
        this.name2=name2;
        this.score2=score2;
        this.name3=name3;
        this.score3=score3;
        this.name4=name4;
        this.score4=score4;
    }
    public DataScores(String name1,Integer score1,String name2,Integer score2,String name3,Integer score3,String name4,Integer score4){
        this.name1=name1;
        this.score1=score1;
        this.name2=name2;
        this.score2=score2;
        this.name3=name3;
        this.score3=score3;
        this.name4=name4;
        this.score4=score4;
    }
    public DataScores(){};
    public int getid(){
        return id;
    }
    public String getName1(){
        return name1;
    }
    public Integer getScore1(){
        return score1;
    }
    public String getName2(){
        return name2;
    }
    public Integer getScore2(){
        return score2;
    }
    public String getName3(){
        return name3;
    }
    public Integer getScore3(){
        return score3;
    }
    public String getName4(){
        return name4;
    }
    public Integer getScore4(){
        return score4;
    }
    public void setid(int id){
        this.id=id;
    }
    public void setName1(String name1){
        this.name1=name1;
    }
    public void setScore1(Integer score1){
        this.score1=score1;
    }
    public void setName2(String name2){
        this.name2=name2;
    }
    public void setScore2(Integer score2){
        this.score2=score2;
    }
    public void setName3(String name3){
        this.name3=name3;
    }
    public void setScore3(Integer score3){
        this.score3=score3;
    }
    public void setName4(String name4){
        this.name4=name4;
    }
    public void setScore4(Integer score4){
        this.score4=score4;
    }
}
