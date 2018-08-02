
$(document).ready(function () {

	$.validator.addMethod("complexPassword", function(value) {
		
		var rulesPassed = 0;
		
		if( /[A-Z]/.test(value) ) {
			rulesPassed++;
		}
		if( /[a-z]/.test(value) ) {
			rulesPassed++;
		}
		if( /[0-9]/.test(value) ) {
			rulesPassed++;
		}
		if( /[^a-zA-Z0-9]/.test(value) ) {
			rulesPassed++;
		}
		
		return rulesPassed >= 3;
		
	}, "Password is not complex enough.");

	$.validator.addMethod("noMoreThan2Duplicates", function(value) {
		
		for(var i = 0; i < value.length - 2; i++) {
			if(value.charAt(i) == value.charAt(i+1) &&
				value.charAt(i) == value.charAt(i+2)) {
				return false;
			} 
		}
		return true;
	}, "Password must not contain more than two duplicate characters in a row");
});

