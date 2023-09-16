package com.bookauthor;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.bookauthor.captialstubs.CountryInfoService;
import com.bookauthor.captialstubs.TCountryInfo;
import com.bookauthor.lettersstubs.NumberConversion;

//import com.bookauthor.stubs.CountryInfoService;
//import com.bookauthor.stubs.NumberConversion;
//import com.bookauthor.stubs.TCountryInfo;

@SpringBootApplication
public class BookAuthorJspMapping1Application {

	public static void main(String[] args) {
		SpringApplication.run(BookAuthorJspMapping1Application.class, args);
//		BookAuthorJspMapping1Application.mm();
//		BookAuthorJspMapping1Application.timedatecon();
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void mm() {
		NumberConversion n = new NumberConversion();
		System.out.println(n.getNumberConversionSoap().numberToWords(BigInteger.valueOf(9)));
//		n.getNumberConversionSoap().numberToWords(BigInteger.valueOf(9));
		CountryInfoService s = new CountryInfoService();

		String m = s.getCountryInfoServiceSoap().capitalCity(s.getCountryInfoServiceSoap().countryISOCode("India"));
		System.err.println(m);
		TCountryInfo k = s.getCountryInfoServiceSoap()
				.fullCountryInfo(s.getCountryInfoServiceSoap().countryISOCode("India"));
		System.out.println(k.getSPhoneCode());
		System.out.println("o");
		String isp = s.getCountryInfoServiceSoap().countryISOCode("India");
		System.out.println(isp);
	}

	public static void timedatecon() {
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
//		LocalDateTime estdate=convertTimeZone()
//		OffsetDateTime odt=dt.atOffset()
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
        String formattedDateTime = estDateTime.format(formatter);
		// Print the converted LocalDateTime
		System.out.println(estDateTime);
		System.out.println(formattedDateTime);
	}
}
