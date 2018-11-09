var fs = require('fs');
var _ = require('underscore-node');

// Note the dangerous blocking operation!
var contents = fs.readFileSync('words.txt', 'utf8').split('\n');

module.exports = {
  generateSet: function (n) {
    var set = [];
    for(var i = 0; i < n; i++) {
      set.push({id: i, data: [_.sample(contents), _.sample(contents), _.sample(contents)].join(" ")});
    }
    return set;
  }
}
