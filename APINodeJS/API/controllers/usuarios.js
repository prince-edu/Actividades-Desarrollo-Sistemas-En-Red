const {response} = require('express');
const usuariosGet = (req, res = response) => {
    const {q,apikey, fuck=true,limit} = req.query;
    res.json({
        msg:" api GET desde controlador",
        q,
        apikey,
        fuck,
        limit,
    });
}
const usuariosPost = (req, res = response) => {
    const {nombre, edad} = req.body;
    res.json({
        msg:" api POST desde controlador",
        nombre: nombre, 
        edad: edad,
    });
}
const usuariosPut = (req, res = response) => {
    const{id} = req.params;
    res.json({
        msg:" api PUT desde controlador",
        id
    });
}
const usuariosDelete = (req, res = response) => {
    res.json({
        msg:" api DELETE desde controlador"
    });
}
const usuariosPatch = (req, res = response) => {
    res.json({
        msg:" api PATCH desde controlador"
    });
}

module.exports = {
    usuariosGet,
    usuariosPost,
    usuariosPut,
    usuariosDelete,
    usuariosPatch,
};
