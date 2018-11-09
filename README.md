# Turnip

This is just a node.js CPU sensitive operation POC.

## Usage

Kick postgres docker container in

```
./docker/start-database.sh
```

Run different stages with node, such as

```
cd src
node stage3-full-text-fuse-server.js
```

And then install Gatling load testing tool, and run scenarios from `turnip-stresser`.