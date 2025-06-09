
function validateCardLength(array){
	if(array.length >= 13 && array.length <= 16){
		return true;
	}
		return false;
}
function checkCardType(array){
	if(array.length >= 13 && array.length <= 16){
		if(array[0] == 4){
			return "Visa Card";
		}
		else if(array[0] == 5){
			return "MasterCard";
		}
		else if(array[0] == 6){
			return "Discover Card";
		}
		else if(array[0] == 3 && array[1] == 7){
			return "American Express Card";
		}else{
			return "Invalid Card";
		}
	}
		return "Invalid Card";
}	
function getCardLength(array){
	return array.length;
}
function checkForNegative(array){
	for(let counter = 0; counter < array.length; counter++){
		if(array[counter] < 0 || array[counter] > 9){
			return true;
		}
	}
	return false;
}
function firstStep(array){
	let result = 0;
	let sum = 0;
	for(let counter = 0; counter < array.length; counter++){
		if(counter % 2 == 0){
			result = array[counter] * 2;
			if(result > 9){
				result -= 9;
			}
			sum += result;
		}
			 
	}
	return sum;
}
function addDigitsInOdd(array){
	let total = 0;
	for(let counter = 0; counter < array.length; counter++){
		if(counter % 2 != 0){
			total += array[counter];
		}
	}
	return total;
}
function getSum(array){
	let evenTotal = firstStep(array);
	let oddTotal =  addDigitsInOdd(array);
	return evenTotal + oddTotal;
}
function checkCard(array){
	let total = getSum(array);
	if(total % 10 == 0){
		return true;
	}
	return false;
}
function showStatus(status){
	if(status){
		return "Valid";
	}
	return "Invalid";
} 
function printCardDetails(array) {
    const cardType = checkCardType(array);
    const cardNumber = array.join('');// Convert array to string
    const cardLength = array.length;
    const validity = showStatus(checkCard(array));
    const now = new Date();

    const message = `
**********************************************
** Credit Card Type: ${cardType}
** Credit Card Number: ${cardNumber}
** Credit Card Length: ${cardLength}
** Credit Card Validity Status: ${validity}

    Date: ${now.toLocaleDateString()} ${now.toLocaleTimeString()}
**********************************************
    `;

    return message;
}
function convertStringToArray(strNumbers) {
    const numbers = [];

    for (let i = 0; i < strNumbers.length; i++) {
        const ch_number = strNumbers.charAt(i);
        const number = parseInt(ch_number, 10); 
        numbers.push(number);
    }

    return numbers;
}


const prompt = require('prompt-sync')();
cardNo = prompt("Hello, Kindly Enter Card details to verify: ");
cardNos = convertStringToArray(cardNo);
console.log(printCardDetails(cardNos));





