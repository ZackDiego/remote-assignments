function max(numbers) {
// your code here, for-loop method preferred
    let max_num = numbers[0] ;
    for (let i = 1 ; i < numbers.length; i++){
        if (max_num < numbers[i]){
            max_num = numbers[i] // replace max_num with value
        }
    }
    return max_num;
}

function findPosition(numbers, target) {
// your code here, for-loop method preferred
    let pos = -1 ;   // if not replace, it didn't find the target, return -1
    for (let i = 0 ; i < numbers.length; i++){
        if (numbers[i] === target){
            pos = i  // replace pos with target index
            break;  // insure it take the first position
        }
    }
    return pos;
}
console.log(max([1, 2, 4, 5])); // should print 5
console.log(max([5, 2, 7, 1, 6])); // should print 7


console.log(findPosition([5, 2, 7, 1, 6], 5)); // should print 0
console.log(findPosition([5, 2, 7, 1, 6], 7)); // should print 2
console.log(findPosition([5, 2, 7, 7, 7, 1, 6], 7)); // should print 2 (the first position) 
console.log(findPosition([5, 2, 7, 1, 6], 8)); // should print -1
    
    