package com.yedam.test;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

//리스트 더블클릭하면 창 새로 나와서 단가, 판매량 조정기능.
public class Book {
	private SimpleStringProperty bookCode;
	private SimpleStringProperty bookName;
	private SimpleStringProperty bookWriter;
	private SimpleIntegerProperty bookPrice;
	private SimpleIntegerProperty sellCount;
	
	public Book(String bookCode, String bookName, String bookWriter, int bookPrice, int sellCount) {
		this.bookCode = new SimpleStringProperty(bookCode);
		this.bookName = new SimpleStringProperty(bookName);
		this.bookWriter = new SimpleStringProperty(bookWriter);
		this.bookPrice = new SimpleIntegerProperty(bookPrice);
		this.sellCount = new SimpleIntegerProperty(sellCount);
	}
	
	public void setBookCode(String bookCode) {
		this.bookCode.set(bookCode);
	}
	public String getBookCode() {
		return this.bookCode.get();
	}
	public SimpleStringProperty bookCodeProperty() {
		return this.bookCode;
	}
	
	public void setBookName(String bookName) {
		this.bookName.set(bookName);
	}
	public String getBookName() {
		return this.bookName.get();
	}
	public SimpleStringProperty bookNameProperty() {
		return this.bookName;
	}
	
	public void setBookWriter(String bookWriter) {
		this.bookWriter.set(bookWriter);
	}
	public String getBookWriter() {
		return this.bookWriter.get();
	}
	public SimpleStringProperty bookWriterProperty() {
		return this.bookWriter;
	}
	
	public void setBookPrice(int bookPrice) {
		this.bookPrice.set(bookPrice);
	}
	public int getBookPrice() {
		return this.bookPrice.get();
	}
	public SimpleIntegerProperty bookPriceProperty() {
		return this.bookPrice;
	}
	
	public void setSellCount(int sellCount) {
		this.sellCount.set(sellCount);
	}
	public int getSellCount() {
		return this.sellCount.get();
	}
	public SimpleIntegerProperty sellCountProperty() {
		return this.sellCount;
	}
	
	
}
