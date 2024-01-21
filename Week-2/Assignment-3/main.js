function count(input) { 
  // your code here
  output = input.reduce( (res,element) => {
    if ( Object.keys(res).includes(element) ){
      res[element] += 1;  // already have the key: add 1
    }else {
      res[element] = 1;  // add the key
    }
    return res
  }  ,{})

  return output
}

let input1 = ["a", "b", "c", "a", "c", "a", "x"];
console.log(count(input1));
// should print {a:3, b:1, c:2, x:1}


function groupByKey(input) { 
  // your code here
  output = input.reduce( (res, obj) => {
    if (Object.keys(res).includes(obj.key)){
      res[obj.key] += obj.value;
    }else {
      res[obj.key] = obj.value;
    }
    return res;
  },
  {})
  return output
}

let input2 = [
{ key: "a", value: 3 },
{ key: "b", value: 1 },
{ key: "c", value: 2 },
{ key: "a", value: 3 },
{ key: "c", value: 5 },
];
console.log(groupByKey(input2)); // should print {a:6, b:1, c:7}