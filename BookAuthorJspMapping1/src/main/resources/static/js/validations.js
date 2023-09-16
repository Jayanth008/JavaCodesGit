/**
 * 
 */
$.validator.addMethod("lettersOnly", function(value, element) {
	return this.optional(element) || /^[A-Za-z\s]+$/.test(value);
});

jQuery('#addForm').validate({
	rules: {
		authorName: {
			required: true, lettersOnly: true
		},
		city: "required",
		state: "required",
		country: "required",
		noOfBooksPublished: {
			required: true, min: 0
		},
		language: "required"
	}, messages: {
		authorName: {
			required: "Please Enter Author Name",
			lettersOnly: "Please Enter Only Alphabetic Characters"
		},
		city: "Please Enter City",
		state: "Please Enter State",
		country: "Please Enter Country",
		noOfBooksPublished: {
			required: "Please Enter No Of Books Published",
			min: "Enter only Numbers"
		},
		language: "Please Enter Language"
	}
});
jQuery('#updateform').validate({
	rules: {
		authorName: {
			required: true, lettersOnly: true
		},
		city: "required",
		state: "required",
		country: "required",
		noOfBooksPublished: {
			required: true, min: 0
		},
		language: "required"
	}, messages: {
		authorName: {
			required: "Please Enter Author Name",
			lettersOnly: "Please Enter Only Alphabetic Characters"
		},
		city: "Please Enter City",
		state: "Please Enter State",
		country: "Please Enter Country",
		noOfBooksPublished: {
			required: "Please Enter No Of Books Published",
			min: "Enter only Numbers"
		},
		language: "Please Enter Language"
	}
});



