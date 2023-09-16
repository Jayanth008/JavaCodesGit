package com.bookauthor.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "BookAuthor")
@Data
public class BookAuthorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence")
	@SequenceGenerator(name = "my_sequence", sequenceName = "my_sequence", allocationSize = 1)
	@Column(name = "id")
	private int bookId;
	@Column(name = "Author Name")
	private String authorName;
	private String city;
	private String state;
	private String country;
	@Column(name = "No Of Books Published")
	private Integer noOfBooksPublished;
	@Column(name = "No Of Books Published letters")
	private String noOfBooksPublishedLetters;
	private String language;
	@Column(name = "Created Date")
	@CreationTimestamp
	private Date createDate;
	@Column(name = "Updated Date")
	@UpdateTimestamp
	private Date updateDate;
	@Transient
	private int age;
	@Column(name = "Book Published Date IST")
	@CreationTimestamp
	private LocalDateTime bookPublishedDateIST;

	@Transient
	private LocalDateTime bookPublishedDateEST;
	/*
	 * public BookAuthorEntity() {
	 *
	 * }
	 *
	 * public BookAuthorEntity(int bookId, String authorName, String city, String
	 * state, String country, int noOfBooksPublished, String language, Date
	 * createDate, Date updateDate) {
	 *
	 * this.bookId = bookId; this.authorName = authorName; this.city = city;
	 * this.state = state; this.country = country; this.noOfBooksPublished =
	 * noOfBooksPublished; this.language = language; this.createDate = createDate;
	 * this.updateDate = updateDate; }
	 *
	 * public int getBookId() { return bookId; }
	 *
	 * public void setBookId(int bookId) { this.bookId = bookId; }
	 *
	 * public String getAuthorName() { return authorName; }
	 *
	 * public void setAuthorName(String authorName) { this.authorName = authorName;
	 * }
	 *
	 * public String getCity() { return city; }
	 *
	 * public void setCity(String city) { this.city = city; }
	 *
	 * public String getState() { return state; }
	 *
	 * public void setState(String state) { this.state = state; }
	 *
	 * public String getCountry() { return country; }
	 *
	 * public void setCountry(String country) { this.country = country; }
	 *
	 * public int getNoOfBooksPublished() { return noOfBooksPublished; }
	 *
	 * public void setNoOfBooksPublished(int noOfBooksPublished) {
	 * this.noOfBooksPublished = noOfBooksPublished; }
	 *
	 * public String getLanguage() { return language; }
	 *
	 * public void setLanguage(String language) { this.language = language; }
	 *
	 * public Date getCreateDate() { return createDate; }
	 *
	 * public void setCreateDate(Date createDate) { this.createDate = createDate; }
	 *
	 * public Date getUpdateDate() { return updateDate; }
	 *
	 * public void setUpdateDate(Date updateDate) { this.updateDate = updateDate; }
	 *
	 * @Override public String toString() { return "BookAuthorEntity [bookId=" +
	 * bookId + ", authorName=" + authorName + ", city=" + city + ", state=" + state
	 * + ", country=" + country + ", noOfBooksPublished=" + noOfBooksPublished +
	 * ", language=" + language + ", createDate=" + createDate + ", updateDate=" +
	 * updateDate + "]"; }
	 */

}
