const express = require('express');
const cors = require('cors');

class Server{

    constructor(){
        this.app = express();

        this.port = 8083;

        this.middlewares();

        this.routes();
        
    }

    middlewares(){
        this.app.use(cors());
        //lectura y parseo del body
        this.app.use(express.json());
        this.app.use(express.static('public'));
    }

    routes(){
        this.app.use('/api/usuarios', require('../routes/usuarios'));
    }

    listen(){
        this.app.listen(this.port, () => {
            console.log(`Server listening on port ${this.port}`)
        })
    }
        
}

module.exports = Server;