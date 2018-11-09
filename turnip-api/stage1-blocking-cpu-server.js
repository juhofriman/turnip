const express = require('express');
const data = require('./data.js');
const app = express();

app.get('/favicon.ico', (req, res) => res.status(204));

// curl localhost:3000/alive
app.get('/alive', (req, res) => {
  console.log('/alive called');
  res.send('Ready to launch the rockets!');
});

// curl localhost:3000/cpu-bomb
app.get('/cpu-bomb', (req, res) => {
  console.log('/cpu-bomb called');
  x = false;
  while(true) {
    x = !x;
  }
  res.send('Will block CPU eternally');
});

// curl localhost:3000/non-blocking
app.get('/non-blocking', (req, res) => {
  console.log('/non-blocking called');
  setTimeout(() => {
    res.send('It was a tough job, but results done!');
  }, 10000);
});

app.listen(3000, () => console.log('Blocking CPU on port 3000!'))