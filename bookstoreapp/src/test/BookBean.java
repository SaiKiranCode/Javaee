package test;
import java.io.*;
public class BookBean implements Serializable {
	private String bcode,bauthor,bname;
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public float getBprice() {
		return bprice;
	}
	public void setBprice(float bprice) {
		this.bprice = bprice;
	}
	public int getBqty() {
		return bqty;
	}
	public void setBqty(int bqty) {
		this.bqty = bqty;
	}
	private float bprice;
	private int bqty;
	public BookBean() {}
	public String getBcode() {
		return bcode;
	}
	public void setBcode(String bcode) {
		this.bcode = bcode;
	}
	

}
