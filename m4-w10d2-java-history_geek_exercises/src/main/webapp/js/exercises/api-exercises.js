/// <reference path="../jquery-3.1.1.js" />
$(document).ready(function () {
	
    $("#BillingPostalCode").on("change", function (event) {
    	let originalTotal = $("#grandtotal span").text();
    	
    	$.ajax({
    		url: "/m4-java-historygeek-exercises/api/getTax",
    		type: "GET",
    		dataType: "json",
    		data: {
    			billingZipCode: $("#BillingPostalCode").val(),
    			subtotal: parseFloat($("#subtotal .price").text().substring(1))
    		}
    	}).done(function (data) {
    		$("#tax .price").text("$" + data);
    	}).fail(function (xhr, status, error) {
            console.log(error); 
    	});
    });

});

