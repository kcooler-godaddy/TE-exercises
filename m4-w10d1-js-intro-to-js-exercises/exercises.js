
// 1 
function sumDouble(x, y){
    let sum = x + y;
    if(x === y){
        sum *= 2;
    }
    return sum;
}

// 2
function hasTeen(x, y, z){
    function isTeen(a){
        if(a >= 13 && a <= 19) return true;
    }
    let count = 0;
    if(isTeen(x)) count++;
    if(isTeen(y)) count++;
    if(isTeen(z)) count++;

    if (count) return true;

    return false;
}

// 3
function lastDigit(x, y){
    if (x % 10 == y % 10) return true;
    return false;
}

// 4 
function seeColor(a){
    if (a.startsWith('red')) return 'red';
    if (a.startsWith('blue')) return 'blue';
    return '';
}

// 5
function middleThree(a){
    let cut = (a.length - 3) / 2;
    return a.substring(cut, a.length - cut);
}

// 6
function frontAgain(a){
    let front = a.substring(0, 2);
    if (a.endsWith(front)) return true;
    return false;
}

// 7
function alarmClock(x, b){
    let time = '10:00';
    if(b){
        if (x == 0 || x == 6) time = 'off';
    }
    else if(x > 0 && x < 6) time = '7:00';
    if(x == 0) return `Sunday ${time}`;
    if(x == 1) return `Monday ${time}`;
    if(x == 2) return `Tuesday ${time}`;
    if(x == 3) return `Wednesday ${time}`;
    if(x == 4) return `Thursday ${time}`;
    if(x == 5) return `Friday ${time}`;
    return `Saturday ${time}`;
}

// 8
function makeMiddle(array){
    if (array.length % 2 != 0 || array.length < 2) return [];
    let cut = (array.length - 2) / 2;
    let newArray = [];
    for(let i = cut; i < array.length - cut; i++){
        newArray.push(array[i]);
    }
    return newArray;
}

// 9 
function oddOnly(array){
    let newArray = [];
    for (let i = 0; i < array.length; i++){
        if (array[i] % 2 == 1) newArray.push(array[i]);
    }
    return newArray;
}

// 10
function weave(a, b){
    let array = [];
    for (let i = 0; i < (a.length + b.length); i++){
        if (i % 2 == 0) {
            if(a[i / 2]) array.push(a[i / 2]);
            else array.push(b[parseInt(i / 2)]);
        }
        else {
            if (b[parseInt(i / 2)]) array.push(b[parseInt(i / 2)]);
            else array.push(a[i / 2]);
        }
    }
    return array;
}

// 11
function cigarParty(x, isWeekend){
    if (x >= 40){
        if (isWeekend) return true;
        else if (x <= 60) return true;
    }
    return false;
}

// 12
function stringSplosion(s){
    let result = '';
    for (let i = 0; i < s.length; i++){
        result += s.substring(0, i + 1);
    }
    return result;
}

// 13 
function fizzBuzz(x){
    let result = '';
    if(x % 3 == 0) result += 'Fizz';
    if(x % 5 == 0) result += 'Buzz';
    if(result == '') result = x;
    return result;
}

// 14

function countValues(arr) {

    let ret = {};
    
    arr.forEach(function(value) {
        ret[value] = ret.hasOwnProperty(value) ? ret[value] + 1 : 1;
    });
    
    return ret;
}

// 15
function reverseArray(arr){
    let result = []
    for(let i = 0; arr.length > 0; i++){
        result.push(arr.pop());
    }
    return result;
}