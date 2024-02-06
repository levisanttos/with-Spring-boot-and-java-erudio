package br.com.erudio.data.vo;

import java.io.Serializable;
import java.time.LocalDate;

public class BookDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5965124869275974083L;

	private Long id;

	private String author;

	private String title;

	private Double price;

	private LocalDate launch_date;

	public BookDTO() {
		
	}
	
	public BookDTO(Long id, String author, String title, Double price, LocalDate launch_date) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.price = price;
		this.launch_date = launch_date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getLaunch_date() {
		return launch_date;
	}

	public void setLaunch_date(LocalDate launch_date) {
		this.launch_date = launch_date;
	}
	
}
