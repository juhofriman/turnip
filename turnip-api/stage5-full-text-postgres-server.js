const express = require('express');
const data = require('./data.js');
const pgp = require('pg-promise');
const app = express();

const db = pgp()({
  host: 'localhost',
  user: 'postgres',
  password: 'password',
  database: 'postgres'
});

db.task((t) => {
  return t.none('DROP TABLE IF EXISTS turnip').then(() => {
    return t.none('CREATE TABLE turnip (id INTEGER PRIMARY KEY, data TEXT, query_v tsvector)', []).then(() => {

        var inserts = data.generateSet(6000).map((entry) => {
          return t.none("INSERT INTO turnip VALUES($1, $2, to_tsvector($3))", [entry.id, entry.data, entry.data]);
        });
        return t.batch(inserts);
      });

  }).then(() => {
    console.log('Done inserting the data. SAFE TESTINGS!');
  });
})

app.get('/favicon.ico', (req, res) => res.status(204));

app.get('/', (req, res) => {
  db.many('SELECT * FROM turnip', []).then((data) => {
    res.send(data);
  })
});

app.get('/search', (req, res) => {
  console.log('Querying: ' + req.query.q);
  db.manyOrNone("SELECT id, data FROM turnip WHERE query_v @@ to_tsquery('english', $1)", [req.query.q]).then((data) => {
    res.send(data);
  })
});

app.get('/:id', (req, res) => {
  db.oneOrNone('SELECT id, data FROM turnip WHERE id = $1', [req.params.id]).then((data) => {
    res.send(data);
  })
});



app.listen(3000, () => console.log('Turnip postgres listening on port 3000!'))