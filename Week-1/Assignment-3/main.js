function countAandB(input) {
    
    let countA = 0;
    let countB = 0;
  
    for (let i = 0; i < input.length; i++) {
      
      const letter = input[i];
  
      if (letter === 'a') {
        countA++;
      } else if (letter === 'b') {
        countB++;
      }
    }
  
    return countA + countB;
}
  
function toNumber(input) {
    // convert letter to character with charCodeAt()
    // a is 97
    const result = input.map(letter => letter.charCodeAt(0) - 96);

    return result;
}
  


let input1 = ['a', 'b', 'c', 'a', 'c', 'a', 'c']; 
console.log(countAandB(input1)); // should print 4 (3 ‘a’ letters and 1 ‘b’ letter)
console.log(toNumber(input1)); // should print [1, 2, 3, 1, 3, 1, 3]

let input2 = ['e', 'd', 'c', 'd', 'e']; 
console.log(countAandB(input2)); // should print 0
console.log(toNumber(input2)); // should print [5, 4, 3, 4, 5]