package myshop.op.board;

import java.sql.Timestamp;

public class OperatordDTO {

	private String writer;
    private String phone_num;
    private String content;
    private Timestamp writer_date;
    

    public void setWriter(String writer){
    	this.writer=writer;
    }
    public void setPhone_num(String phone_num){
    	this.phone_num=phone_num;
    }
    public void setContent(String content){
    	this.content=content;
    }
    public void setWriter_date (Timestamp writer_date) {
        this.writer_date = writer_date;
    }
    

    public Timestamp getWriter_date () {
        return writer_date;
    }
    public String getWriter(){
    	return writer;
    }
    public String getPhone_num(){
    	return phone_num;
    }
    public String getContent(){
    	return content;
    }
}