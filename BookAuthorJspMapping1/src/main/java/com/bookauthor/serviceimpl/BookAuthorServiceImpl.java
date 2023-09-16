package com.bookauthor.serviceimpl;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookauthor.entity.BookAuthorEntity;
import com.bookauthor.entity.UserInfo;
import com.bookauthor.lettersstubs.NumberConversion;
import com.bookauthor.repo.BookAuthorRepo;
import com.bookauthor.repo.UserInfoRepo;
import com.bookauthor.service.BookAuthorService;
import com.bookauthor.service.SecurityInterface;
import com.fasterxml.jackson.databind.JsonNode;
//import com.bookauthor.stubs.NumberConversion;

@Service
public class BookAuthorServiceImpl implements BookAuthorService, SecurityInterface {
	@Autowired
	private BookAuthorRepo Repo;
	@Autowired
	private UserInfoRepo userInfoRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RestTemplate restTemplate;
	@Value("${spring.link}")
	private String resourceUrl;

	@Override
	public List<BookAuthorEntity> allAuthorList() {
//		List<BookAuthorEntity> allAuthor = Repo.findAll();
		List<BookAuthorEntity> allAuthor = Repo.findAllByOrderByBookIdDesc();

//		String resourceUrl = "https://api.agify.io/?name=";
//		allAuthor.stream().forEach(o ->o.setAge( (int) restTemplate.getForObject(resourceUrl+o.getAuthorName(), Object.class)));
		for (BookAuthorEntity e : allAuthor) {
			JsonNode data = restTemplate.getForObject(resourceUrl + e.getAuthorName(), JsonNode.class);
//			System.err.println(data.get("age").asInt());
			e.setAge(data.get("age").asInt());
			if (e.getBookPublishedDateIST() != null) {
				LocalDateTime dt = e.getBookPublishedDateIST();
//				System.err.println(dt);
//				LocalDateTime estdate=convertTimeZone()
//				OffsetDateTime odt=dt.atOffset()
				// Specify the source time zone as IST
				ZoneId sourceZone = ZoneId.of("Asia/Kolkata");

				// Specify the target time zone as EST
				ZoneId targetZone = ZoneId.of("America/New_York");

				// Convert LocalDateTime from sourceZone to targetZone
				ZonedDateTime sourceZonedDateTime = dt.atZone(sourceZone);
				ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(targetZone);
				LocalDateTime estDateTime = targetZonedDateTime.toLocalDateTime();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm");

				// Format the date and time using the formatter
				@SuppressWarnings("unused")
				String formattedDateTime = estDateTime.format(formatter);
				// Print the converted LocalDateTime
//				System.err.println(estDateTime);
//				System.err.println(formattedDateTime);
				e.setBookPublishedDateEST(estDateTime);
			}
		}
//		System.err.println(allAuthor);
		return allAuthor;
	}

	@Override
	public void addAuthor(BookAuthorEntity model) {
		Repo.save(model);
	}

	@Override
	public void saveAuthor(BookAuthorEntity model) {
//		System.out.println("one rec");
//		NumberConversion n=new NumberConversion();
//		n.getNumberConversionSoap().numberToWords(BigInteger.valueOf(model.getNoOfBooksPublished()));
		model.setNoOfBooksPublishedLetters(new NumberConversion().getNumberConversionSoap()
				.numberToWords(BigInteger.valueOf(model.getNoOfBooksPublished())));
		Repo.save(model);

	}

//............................................................................................................
	@Override
	public BookAuthorEntity findAuthorById(int bookid) {
		BookAuthorEntity author = Repo.findById(bookid).get();
		JsonNode data = restTemplate.getForObject(resourceUrl + author.getAuthorName(), JsonNode.class);
		author.setAge(data.get("age").asInt());
		return author;
	}

	@Override
	public void updateAuthor(BookAuthorEntity entity) {
		entity.setNoOfBooksPublishedLetters(new NumberConversion().getNumberConversionSoap()
				.numberToWords(BigInteger.valueOf(entity.getNoOfBooksPublished())));
		Repo.save(entity);

	}

	@Override
	public void deleteAuthor(int bookid) {
		Repo.deleteById(bookid);

	}

	//////// add user to bd
	@Override
	public String adduser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userInfoRepo.save(userInfo);
		return "user added";
	}

	@Override
	public void saveuser(UserInfo userInfo) {
		// TODO Auto-generated method stub

		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userInfoRepo.save(userInfo);

	}

	@Override
	public boolean userExists(String userName) {
		// TODO Auto-generated method stub
		return userInfoRepo.existsByUserName(userName);
	}

	@Override
	public List<BookAuthorEntity> testing() {
		// TODO Auto-generated method stub
		return Repo.findAll();
	}

	@Override
	public List<BookAuthorEntity> findbyAuthorName(String authorName) {
		return Repo.findByAuthorName(authorName);
	}

}
