const express = require('express');
const data = require('./data.js');
const Fuse = require('fuse.js');
const app = express();

var entries = data.generateSet(6000);
var fuseConfig = {
  shouldSort: true,
  threshold: 0.6,
  location: 0,
  distance: 100,
  maxPatternLength: 32,
  minMatchCharLength: 1,
  keys: [
    "data"
  ]
};
var fuse = new Fuse(entries, fuseConfig);

app.get('/favicon.ico', (req, res) => res.status(204));

app.get('/', (req, res) => {
  res.send(entries);
});

app.get('/search', (req, res) => {
  console.log('Querying: ' + req.query.q);
  res.send(fuse.search(req.query.q))
});

app.get('/:id', (req, res) => {
  res.send(entries.find((e) => e.id == req.params.id));
});



app.listen(3000, () => console.log('Turnip Fuse.js listening on port 3000!'))