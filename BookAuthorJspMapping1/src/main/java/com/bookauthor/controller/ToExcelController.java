package com.bookauthor.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.runners.model.TestClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookauthor.entity.BookAuthorEntity;
import com.bookauthor.entity.ImportDataCSVEntity;
import com.bookauthor.repo.ImportDataCSVRepo;
import com.bookauthor.service.BookAuthorService;

@Controller
public class ToExcelController {
	@Autowired
	private BookAuthorService bookAuthorService;

	@Autowired
	private ImportDataCSVRepo importDataCSVRepo;

	@PostMapping("/export")
	@ResponseBody
	public ResponseEntity<byte[]> exportToExcel() throws IOException {
		List<BookAuthorEntity> list = bookAuthorService.allAuthorList();

		// Create a new workbook
		Workbook workbook = new XSSFWorkbook();

		// Create a sheet in the workbook
		Sheet sheet = workbook.createSheet("Book Authors");
		InputStream inputStream1 = TestClass.class.getClassLoader().getResourceAsStream("BookAuthorsLogo.PNG");

		byte[] inputImageBytes1 = IOUtils.toByteArray(inputStream1);

		int inputImagePictureID1 = workbook.addPicture(inputImageBytes1, Workbook.PICTURE_TYPE_PNG);
		XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
		XSSFClientAnchor ironManAnchor = new XSSFClientAnchor();
		ironManAnchor.setCol1(6); // Sets the column (0 based) of the first cell.
		ironManAnchor.setCol2(7); // Sets the column (0 based) of the Second cell.
		ironManAnchor.setRow1(0); // Sets the row (0 based) of the first cell.
		ironManAnchor.setRow2(6); // Sets the row (0 based) of the Second cell.
		drawing.createPicture(ironManAnchor, inputImagePictureID1);

		// Create header row
		Row headerRow = sheet.createRow(6);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Author Name");
		headerRow.createCell(2).setCellValue("City");
		headerRow.createCell(3).setCellValue("State");
		headerRow.createCell(4).setCellValue("Country");
		headerRow.createCell(5).setCellValue("No of Books Published ");
		headerRow.createCell(6).setCellValue("No of Books Published in letters");
		headerRow.createCell(7).setCellValue("Language");
		headerRow.createCell(8).setCellValue("Created Date");
		headerRow.createCell(9).setCellValue("Updated Date");
		headerRow.createCell(10).setCellValue("Age");

		// Populate data rows
		int rowNumber = 7;

		for (BookAuthorEntity bookAuthor : list) {
			Row dataRow = sheet.createRow(rowNumber++);

			dataRow.createCell(0).setCellValue(bookAuthor.getBookId());
			dataRow.createCell(1).setCellValue(bookAuthor.getAuthorName());
			dataRow.createCell(2).setCellValue(bookAuthor.getCity());
			dataRow.createCell(3).setCellValue(bookAuthor.getState());
			dataRow.createCell(4).setCellValue(bookAuthor.getCountry());
			dataRow.createCell(5).setCellValue(bookAuthor.getNoOfBooksPublished());
			dataRow.createCell(6).setCellValue(bookAuthor.getNoOfBooksPublishedLetters());
			dataRow.createCell(7).setCellValue(bookAuthor.getLanguage());
//			String createdDate=new SimpleDateFormat("yyyy-MM-dd").format(bookAuthor.getCreateDate());
//			String updatedDate=new SimpleDateFormat("yyyy-MM-dd").format(bookAuthor.getUpdateDate());
			dataRow.createCell(8).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(bookAuthor.getCreateDate()));
			dataRow.createCell(9).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(bookAuthor.getUpdateDate()));
			dataRow.createCell(10).setCellValue(bookAuthor.getAge());
		}

		// Auto-size columns
		for (int i = 0; i < headerRow.getLastCellNum(); i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the workbook content to a ByteArrayOutputStream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		workbook.write(outputStream);
		workbook.close();

		// Create the ResponseEntity with the Excel content and appropriate headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "book_authors.xlsx");
		return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);

	}

	@PostMapping("/exportToCsv")
	public ResponseEntity<ByteArrayResource> exportToCsv() throws IOException {
//        List<Author> authors = getAuthors(); // Replace with your actual data source
		List<BookAuthorEntity> authors = bookAuthorService.allAuthorList();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);

		writer.write(
				"Book Id,Author Name,Age,City,State,Country,No Of Books Published,No Of Books Published in letters,Language,Created Date,Updated Date,Book Published DateTime IST,Book Published DateTime EST\n");

		for (BookAuthorEntity author : authors) {
			writer.write(
					author.getBookId() + "," + author.getAuthorName() + "," + author.getAge() + "," + author.getCity()
							+ "," + author.getState() + "," + author.getCountry() + "," + author.getNoOfBooksPublished()
							+ "," + author.getNoOfBooksPublishedLetters() + "," + author.getLanguage() + ",");
//                    author.getCreateDate() + "," +
//                    author.getUpdateDate() + "," +
//                    author.getBookPublishedDateIST() + "," +
//                    author.getBookPublishedDateEST() + "\n");
		}

		writer.flush();
		writer.close();

		byte[] csvBytes = outputStream.toByteArray();

		ByteArrayResource resource = new ByteArrayResource(csvBytes);

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"table.csv\"")
				.contentType(MediaType.parseMediaType("text/csv")).contentLength(csvBytes.length).body(resource);
	}

	@GetMapping("/dataFromCsv")
	public String getAllCSVData(Model model) throws IOException {
		List<ImportDataCSVEntity> csvdataList = new ArrayList<>();
		String csvFile = "C:\\Users\\BUDDPRAS\\Desktop\\Tasks Subaru\\CustomCsvFile.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			String line;
			// Skip the header line if it exists
			br.readLine();

			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				if (data.length == 4) {
					int id = Integer.parseInt(data[0].trim());
					String name = data[1].trim();
					int age = Integer.parseInt(data[2].trim());
					String email = data[3].trim();

					ImportDataCSVEntity csvdata = new ImportDataCSVEntity(id, name, age, email);
					csvdataList.add(csvdata);
				}
			}

			// Save the CSV data to the database using your service or repository

//	 csvdataservice.saveAllCSVDATA(csvdataList)
			for (ImportDataCSVEntity csvdataList1 : csvdataList) {
				importDataCSVRepo.save(csvdataList1);
			}
//	 importDataCSVRepo.saveAll(csvdataList)

		}
		List<ImportDataCSVEntity> e = importDataCSVRepo.findAll();
//		System.err.println(e);
		model.addAttribute("data", e);
		return "ImportValuesFromCsv";
	}
}
