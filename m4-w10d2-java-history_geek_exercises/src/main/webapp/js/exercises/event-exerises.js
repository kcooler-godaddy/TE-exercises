/// <reference path="../jquery-3.1.1.js" />

$(document).ready(function () {
	
	let originalTotal = $("#grandtotal span").text();

	$("[type=checkbox]").click(function() {
			$("#ShippingAddress1").val($("#BillingAddress1").val());
	   	    $("#ShippingAddress2").val($("#BillingAddress2").val());
		    $("#ShippingCity").val($("#BillingCity").val());
		    $("#ShippingState").val($("#BillingState").val());
		    $("#ShippingPostalCode").val($("#BillingPostalCode").val());
		});
	
	$("[type=radio]").click(function() {
			let shipping = $(this).attr("data-cost");
			$("#shipping .price").text('$' + shipping);
			let newtotal = addMoney(originalTotal, shipping);
			$("#grandtotal span").text(newtotal)
		});
	
	$("body").keydown(function(event){
			if (event.key == 'ArrowDown') handleMove("down");
			if (event.key == 'ArrowUp') handleMove("up");
			if (event.key == 'ArrowLeft') handleMove("left");
			if (event.key == 'ArrowRight') handleMove("right");
		});
	
	$("#btnRestart").click(function(){
			let oldId = $(".ship").attr("id");
			let newId = 'row_0_column_0';
			$("#" + oldId).removeClass("ship");
			$("#" + newId).addClass("ship");
			
			if($("#game h2").hasClass("gamewin")) $("#game h2").removeClass("gamewin").text("Pirate Explorer");
			if($("#game h2").hasClass("gameover")) $("#game h2").removeClass("gameover").text("Pirate Explorer");
		});

});

function handleMove(direction){
	let oldId = $(".ship").attr("id");
	if(oldId == undefined) return false;
	let arr = oldId.split("_");
	let row = parseInt(arr[1]);			
	let col = parseInt(arr[3]);
	
	if(direction == "right") col ++;
	if(direction == "left") col --;
	if(direction == "up") row --;
	if(direction == "down") row ++;
	
	let newId = 'row_'+row+'_column_'+col;
	
	if(positionValid(row, col)){									
		$("#" + oldId).removeClass("ship");
		$("#" + newId).addClass("ship");
	}
	
	if($("#" + newId).hasClass("treasure")){
		$("#game h2").addClass("gamewin").text("Pirate Explorer - Winner!");
		$("#" + newId).removeClass("ship");
	}
	else if($("#" + newId).hasClass("iceberg") || $("#" + newId).hasClass("pirate")){
		$("#game h2").addClass("gameover").text("Pirate Explorer - Game Over!");
		$("#" + newId).removeClass("ship");
	}
	
}

function positionValid(row, col){												
	let gridSize = $("#gameboard tr").length;
	if (row >= 0 && row < gridSize && col >= 0 && col < gridSize) return true;
	return false;
}
	
function addMoney(str, x){
	let tot = str.substring(1);
	let result = '$' + (parseFloat(tot) + parseFloat(x));
	return result;
}

 