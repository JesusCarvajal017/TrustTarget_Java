import Server from "../../models/server.js";
import listPais from './helpers/selectPais.js'
import listProfesion from './helpers/selectProfesion.js'
import listCuidad from './helpers/selectCiudad.js' 
import listRegion from './helpers/selectRegion.js' 
import listIdentification from './helpers/selectIdentificacion.js' 

const modalInsert = new bootstrap.Modal(document.getElementById('modalInsert'));
const modalDelete = new bootstrap.Modal(document.querySelector("#deleteModal"));
const modalUpdate = new bootstrap.Modal(document.querySelector("#updateModal"));

const formInsert = document.querySelector("#formInsert"); // formulario

const formUpdate = document.getElementById("formUpdate");
const byIdTable = document.querySelector(".deletePreQuery");

const btnDelete = document.querySelector(".deleteform");

// modal.show();
let table = document.querySelector(".form");
let user = new Server("user"); 
let target = new Server("trustTarget"); 

Data();
listPais("#nation_id");
listProfesion("#prof_id");
listCuidad("#city_id");
listRegion("#reg_id");
listIdentification("#ident_id");

// QUERY ALL
async function Data(){
    let htmlView = "";
    let data = await user.getAll();
    // console.log(data);
    data.forEach((entity,i ) => {
        htmlView+= `
        <tr>
            <td>${i + 1}</td>
            <td>${entity.identificationType.ident_acronym}</td>
            <td>${entity.user_num_ident}</td>
            <td>${entity.user_names + " " + entity.user_first_surname }</td>
            <td>${entity.profession.prof_name}</td>
            <td><i class="fas fa-edit m-2" onclick="Updateform(${entity.user_id})" ></i><i class="fas fa-trash-alt m-2" onclick="Deleteform(${entity.user_id})"></i> </td>
            <!-- fas fa-plus -->
        </tr>`;
    });
    
    table.innerHTML = htmlView;
}

function maperUser(data){
    return {
        "user_names": data.user_names,
        "user_first_surname": data.user_first_surname,
        "user_second_surname": data.user_second_surname,
        "user_num_ident": parseInt(data.user_num_ident),
        "identificationType": {
            "ident_id": parseInt(data.ident_id)
        },
        "profession": {
            "prof_id": parseInt(data.prof_id)
        },
        "country": {
            "nation_id": parseInt(data.nation_id)
        },
        "city": {
            "city_id": parseInt(data.city_id)
        },
        "region": {
            "reg_id": parseInt(data.reg_id)
        }
    }
}

// INSERT form
formInsert.addEventListener('submit', async (e) => {
    e.preventDefault();

    let formData = new FormData(formInsert);
    let data = maperUser(Object.fromEntries(formData.entries()));

    let resgister = await user.create(data); // crea el usuario

    let queryUser = await user.getByName(data.user_names); // consulta para optener el id

    let dataTarget = {
        "user": {
            "user_id": queryUser.user_id
        },
        "target_create_date": dataFormato(),
        "trustNivel": null

    }

    await target.create(dataTarget); // crea la targeta

    // console.log(resgister);

    if(resgister.status){
        formInsert.reset();
        modalInsert.hide();
        Data();
    }else{
        // modalForm.reset();
        //mostrar algo no se :(
        // modal.hide();
    }
});

// UPDATE form
window.Updateform = async (id) => {
    let entity = await user.getById(id);

    let dataform = {
        "user_names": entity.user_names,
        "user_first_surname": entity.user_first_surname,
        "user_second_surname": entity.user_second_surname,
        "user_num_ident": parseInt(entity.user_num_ident),
        "ident_id": parseInt(entity.identificationType.ident_id),
        "prof_id":entity.profession.prof_id,
        "nation_id": entity.country.nation_id,
        "city_id": entity.city.city_id,
        "reg_id": entity.region.reg_id
    }

    listPais(".upNation", dataform.nation_id);
    listProfesion(".upProfesion", dataform.prof_id);
    listCuidad(".upCity", dataform.city_id);
    listRegion(".upRegion",dataform.reg_id );
    listIdentification(".upIdentification", dataform.ident_id);

    const formF = document.getElementById("formUpdate");
    // coloca los datos en el formulario
    for (let key in dataform) {
        const input = formF.querySelector(`[name="${key}"]`);
        
        if(input) {
            input.value = dataform[key];
        }
    }

    modalUpdate.show(); // se muestra el modal

    formUpdate.addEventListener('submit', async (e) => {

        e.preventDefault();
    
        let formData = new FormData(formUpdate);
        let data = maperUser(Object.fromEntries(formData.entries()));
        
        data.user_id = id;
    
        let updateform = await user.update(data);
    
        if(updateform.status){
            modalUpdate.hide();
            Data();
        }e
    })
}

let currentDeleteId = null;

btnDelete.addEventListener('click', async () => {
    if(currentDeleteId !== null){
        let deleteform = await user.delete(currentDeleteId);
    
        if(deleteform.status){
            modalDelete.hide();
            Data();
        }
    }
})

// DELETE form
window.Deleteform = async (id) => {
    currentDeleteId = id;
    let htmlView = "";
    let data = await user.getById(id);
    
    htmlView=`
    <tr>
        <td>${data.user_names}</td>
        <td>${data.user_num_ident}</td>
    </tr>`;

    byIdTable.innerHTML = htmlView;

    modalDelete.show();

}

// CARGA CONTENIDO
Data();

function dataFormato(){
    const fecha = new Date();

    const dia = String(fecha.getDate()).padStart(2, '0');
    const mes = String(fecha.getMonth() + 1).padStart(2, '0'); // Enero es 0
    const anio = String(fecha.getFullYear()).slice(-2); // Solo los últimos 2 dígitos

    const formato = `${dia}-${mes}-${anio}`;
    return formato;
}