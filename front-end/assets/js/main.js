import Loader from './animation/loader.js';

// carga de achivos por medio del cache
window.addEventListener("pageshow", (event) => {
if (event.persisted) {
    window.location.reload();
    // alert('la pagina debe volve a cargar')
}
});


// ------------------------------------ start variables globales ------------------------------------
    // loader default
    const loader_default = document.querySelector('.loader-default');
    const loader = new Loader(loader_default);

    // niveles de direccionamiento 
    const nevels = [
        ' ', 
        '../',
        '../../',
        '../../../'
    ];

    const rutas = {
        "index.html": {
            "dirreccion": nevels[0], 
            "scripts": ["../../assets/js/prueba.js",]
        },
        "tipoIdentificaion.html":{
            "dirreccion": nevels[2], 
            "scripts": [
                "../../views/config/typeIdentification.js",
            ]
        },
        "pais.html":{
            "dirreccion": nevels[2], 
            "scripts": [
                "../../views/config/paisRender.js",
            ]
        },
        "region.html":{
            "dirreccion": nevels[2], 
            "scripts": [
                "../../views/config/regionRender.js",
            ]
        },
        "ciudad.html":{
            "dirreccion": nevels[2], 
            "scripts": [
                "../../views/config/cityRender.js",
            ]
        },
        "profesion.html":{
            "dirreccion": nevels[2], 
            "scripts": [
                "../../views/config/profesionRender.js",
            ]
        },
        "nivelConfianza.html":{
            "dirreccion": nevels[2], 
            "scripts": [
                "../../views/config/nivelTrustRender.js",
            ]
        },
        "empresas.html":{
            "dirreccion": nevels[2], 
            "scripts": [
                "../../views/config/empresasRender.js",
            ]
        },
        "usuarios.html":{
            "dirreccion": nevels[2], 
            "scripts": [
                "../../views/operative/userRender.js",
            ]
        },
    };

// ------------------------------------ end variables globales ------------------------------------

// lectura de url fichero
function lecturaUrl(){
    const pathname = window.location.pathname;
    const url = pathname.split("/").pop();

    return url;
}

// crea los script en el DOM
function file(url){
    const script = document.createElement('script');
    script.type = "module";
    script.src = url;

    document.body.appendChild(script);
}

window.addEventListener('load', ()=>{
    // se oculta el loader cuando los recursos han cargado
    loader.hidde();
});

// -------------------------------------- carga de ficheros --------------------------------------
window.addEventListener('DOMContentLoaded', ()=>{
    // loader.show();
    let url = lecturaUrl();

    let path = url != "" ? rutas[url].scripts : rutas["index.html"].scripts;
    if(Array.isArray(path)){
        // console.log('detecto que es un array')
        path.forEach(urls => {
            file(urls)
        });
    }else{
        file(rutas[url]);
    }
    
})