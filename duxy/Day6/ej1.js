var fs = require('fs');
var index;

fs.readFile("input.txt", 'utf8', function(err, data) {
  if (err) throw err;  
  code(data);

});

function code(data){ 
  data = data.split("\t").map(function(item) {
    return parseInt(item, 10);
  });; 
  var sum = 0;
  list_of_states = [] 
  actual_state = data
  end = true
  while(end){ 
    //console.log(actual_state); 
    for(var jj = 0; jj < list_of_states.length;jj++){
      sum_2 = 0;
      for(var ii = 0; ii < list_of_states[jj].length;ii++){        
        if(list_of_states[jj][ii] != actual_state[ii]){
          break;
        }
        sum_2 = sum_2 + 1;
      }
      if(sum_2 == list_of_states[jj].length){        
        sum = sum - 1;
        end = false
        break;
      }      
    } 
    list_of_states.push(actual_state.slice());
    sum = sum + 1;
    var i = data.indexOf(Math.max(...data));
    var rep = actual_state[i];
    actual_state[i] = 0;
    i = (i + 1)% actual_state.length;
    for(var x = 0; x < rep; x++){
      actual_state[i] = actual_state[i] + 1;
      i = (i + 1)% actual_state.length;
    } 
  }
  console.log(sum);
}