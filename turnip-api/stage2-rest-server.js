const express = require('express');
const data = require('./data.js');
const app = express();

var entries = data.generateSet(6000);

app.get('/favicon.ico', (req, res) => res.status(204));

app.get('/', (req, res) => {
  res.send(entries);
});

app.get('/:id', (req, res) => {
  // console.log is suprisingly expensive operation
  console.log('/' + req.params.id);
  res.send(entries.find((e) => e.id == req.params.id));
});

app.listen(3000, () => console.log('Turnip get entity on 3000!'))