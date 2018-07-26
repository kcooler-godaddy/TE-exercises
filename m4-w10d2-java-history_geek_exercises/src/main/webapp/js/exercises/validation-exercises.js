/// <reference path="../jquery-3.1.1.js" />
/// <reference path="../jquery.validate.js" />

$(document).ready(function () {

	$("#register").children().filter("#form0").validate({
		debug: false,
		rules: {
			email: {
				required: true,
				email: true,
				govEmail: true
			},
			password: {
				required: true,
				minlength: 8
			},
			confirmPassword: {
				equalTo: "#password"
			}
		},
		messages: {
			
		},
		errorClass: "field-validation-error",
        validClass: "valid"
	})
	
	$("#login").children().filter("#form0").validate({
		debug: false,
		rules: {
			email: {
				required: true,
				email: true,
				govEmail: true
			},
			password: {
				required: true
			}
		},
		messages: {
			
		},
		errorClass: "field-validation-error",
        validClass: "valid"
	})
	
	$("#checkout").validate({
		debug: false,
		rules: {
			BillingAddress1: {
				required: true
			},
			BillingCity: {
				required: true
			},
			BillingState: {
				required: true,
				stateUS: true
			},
			BillingPostalCode: {
				required: true,
				zipcodeUS: true
			},
			ShippingAddress1: {
				required: true
			},
			ShippingCity: {
				required: true
			},
			ShippingState: {
				required: true,
				stateUS: true
			},
			ShippingPostalCode: {
				required: true,
				zipcodeUS: true
			},
			ShippingType: {
				required: true
			},
			NameOnCard: {
				required: true
			},
			CreditCardNumber: {
				required: true,
				creditcard:true
			},
			ExpirationDate: {
				required: true
			}
		},
		messages: {
			BillingAddress1: {
				required: "Blling Address is Required"
			},
			BillingCity: {
				required: "Billing City is Required"
			},
			BillingState: {
				required: "Billing State is Required"
			},
			BillingPostalCode: {
				required: "Billing Zip Code is Required",
			},
			ShippingAddress1: {
				required: "Shipping Address is Required"
			},
			ShippingCity: {
				required: "Shipping City is Required"
			},
			ShippingState: {
				required: "Shipping State is Required"
			},
			ShippingPostalCode: {
				required: "Shipping Postal Code is Required"
			},
			ShippingType: {
				required: "Shipping Method is Required"
			},
			NameOnCard: {
				required: "Name on Card is Required"
			},
			CreditCardNumber: {
				required: "Credit Card Number is Required"
			},
			ExpirationDate: {
				required: "Expiration Date is Required"
			}
		},
		errorClass: "field-validation-error",
        validClass: "valid",
        errorElement: "li",
        errorLabelContainer: "#errors",
        errorContainer: "#errorSummary"
	})
	
	
});

$.validator.addMethod("govEmail", function(value){
		return value.toLowerCase().endsWith(".gov");
	}, "Must be .gov email address");

$.validator.addMethod( "zipcodeUS", function( value, element ) {
	return this.optional( element ) || /^\d{5}(-\d{4})?$/.test( value );
}, "The specified US ZIP Code is invalid" );

$.validator.addMethod( "stateUS", function( value, element, options ) {
	var isDefault = typeof options === "undefined",
		caseSensitive = ( isDefault || typeof options.caseSensitive === "undefined" ) ? false : options.caseSensitive,
		includeTerritories = ( isDefault || typeof options.includeTerritories === "undefined" ) ? false : options.includeTerritories,
		includeMilitary = ( isDefault || typeof options.includeMilitary === "undefined" ) ? false : options.includeMilitary,
		regex;

	if ( !includeTerritories && !includeMilitary ) {
		regex = "^(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|PA|RI|S[CD]|T[NX]|UT|V[AT]|W[AIVY])$";
	} else if ( includeTerritories && includeMilitary ) {
		regex = "^(A[AEKLPRSZ]|C[AOT]|D[CE]|FL|G[AU]|HI|I[ADLN]|K[SY]|LA|M[ADEINOPST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY])$";
	} else if ( includeTerritories ) {
		regex = "^(A[KLRSZ]|C[AOT]|D[CE]|FL|G[AU]|HI|I[ADLN]|K[SY]|LA|M[ADEINOPST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY])$";
	} else {
		regex = "^(A[AEKLPRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|PA|RI|S[CD]|T[NX]|UT|V[AT]|W[AIVY])$";
	}

	regex = caseSensitive ? new RegExp( regex ) : new RegExp( regex, "i" );
	return this.optional( element ) || regex.test( value );
}, "Please specify a valid state" );

$.validator.addMethod( "creditcard", function( value, element ) {
	if ( this.optional( element ) ) {
		return "dependency-mismatch";
	}

	// Accept only spaces, digits and dashes
	if ( /[^0-9 \-]+/.test( value ) ) {
		return false;
	}

	var nCheck = 0,
		nDigit = 0,
		bEven = false,
		n, cDigit;

	value = value.replace( /\D/g, "" );

	// Basing min and max length on
	// https://dev.ean.com/general-info/valid-card-types/
	if ( value.length < 13 || value.length > 19 ) {
		return false;
	}

	for ( n = value.length - 1; n >= 0; n-- ) {
		cDigit = value.charAt( n );
		nDigit = parseInt( cDigit, 10 );
		if ( bEven ) {
			if ( ( nDigit *= 2 ) > 9 ) {
				nDigit -= 9;
			}
		}

		nCheck += nDigit;
		bEven = !bEven;
	}

	return ( nCheck % 10 ) === 0;
}, "Please enter a valid credit card number." );





