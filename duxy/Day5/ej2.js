var fs = require('fs');
var index;

fs.readFile("input.txt", 'utf8', function(err, data) {
  if (err) throw err;  
  code(data);

});
function code(data){  
  index = 0;
  data = data.split("\n");  
  while(index < data.length){
    data[index] = parseInt(data[index]);
    index = index + 1
  }
  var index = data[0];
  var indan = 0;
  var sum = 0
  while(index < data.length){
    sum = sum + 1;
    indan = index;
    index = index + data[index];
    if (index >= data.length){
       break;
    }
    if(data[indan] > 2){
      data[indan] = data[indan] - 1;
    } else {
      data[indan] = data[indan] + 1;
    }
  }
  console.log(sum);
}