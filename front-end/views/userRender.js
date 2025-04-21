import Server from "../models/server.js";

const modalInsert = new bootstrap.Modal(document.getElementById('modalInsert'));
const modalDelete = new bootstrap.Modal(document.querySelector("#deleteModal"));
const modalUpdate = new bootstrap.Modal(document.querySelector("#updateModal"));

const formInsert = document.querySelector("#formInsert"); // formulario

const formUpdate = document.getElementById("formUpdate");
const byIdTable = document.querySelector(".deletePreQuery");

const btnDelete = document.querySelector(".deletebtn");

let table = document.querySelector(".user");

let userRol = new Server("userRol"); 
let user = new Server("user"); 
let person = new Server("person");


async function listPerson(dom, selectedId = null) {
    let data = await person.getAll();
    let select = document.querySelector(dom);
    let htmlView = `<option value="" disabled ${selectedId === null ? 'selected' : ''}>seleccionar..</option>`;

    data.forEach((person, i) => {
        const selectedAttr = person.id === selectedId ? 'selected' : '';
        htmlView += `<option value="${person.id}" ${selectedAttr}>${person.nameComplet}</option>`;
    });

    select.innerHTML = htmlView;
}

// async function listRol() {
//     htmlView = "";
//     let data = await user.getAll();
//     let select = document.querySelector("#rolId"); 

//     data.forEach((rol, i) => {
//         htmlView += `
//         <option value="${rol.id}">${rol.name}</option>`;
//     });

//     select.innerHTML = htmlView;
// }

Data();
listPerson("#personId");

// QUERY ALL
async function Data(){
    let htmlView = "";
    let data = await user.getAll();
    data.forEach((ur,i ) => {
        htmlView+= `
        <tr>
            <td>${i + 1}</td>
            <td>${ur.userName}</td>
            <td>${ur.personName}</td>
            <td><i class="fas fa-edit m-2" onclick="Updateform(${ur.id})" ></i><i class="fas fa-trash-alt m-2" onclick="Deleteform(${ur.id})"></i> </td>
            <!-- fas fa-plus -->
        </tr>`;
    });
    
    table.innerHTML = htmlView;
}

// INSERT form
formInsert.addEventListener('submit', async (e) => {
    e.preventDefault();

    let formData = new FormData(formInsert);
    let data = Object.fromEntries(formData.entries());

    data.status = 1;
    data.personId = parseInt(formData.get("personId"));

    let resgister = await user.create(data);

    console.log(resgister);

    if(!resgister.message){
        modalInsert.hide();
        Data();
        modalForm.reset();
    }else{
        // modalForm.reset();
        //mostrar algo no se :(
        // modal.hide();
    }
});


// UPDATE form
window.Updateform = async (id) => {
    let formDto = await user.getById(id);
    // listPerson();

    let dataform = {
        userName: formDto.userName,
        password: formDto.password,
        personName: formDto.personName,
        personId: formDto.personId,
    }

    const formF = document.getElementById("formUpdate");

    listPerson("#personIdUp", dataform.personId);

    // coloca los datos en el formulario
    for (let key in dataform) {
        const input = formF.querySelector(`[name="${key}"]`);
    
        if(input) {
            input.value = dataform[key];
        }
    }

    modalUpdate.show();

    formUpdate.addEventListener('submit', async (e) => {

        e.preventDefault();
    
        let formData = new FormData(formUpdate);
        let data = Object.fromEntries(formData.entries());
        
        data.status = 1;
        data.id = id;
        data.personId = parseInt(formData.get("personIdUp"));
    
        let updateform = await user.update(data);

        // console.log(updateform);
    
        if(updateform){
            modalUpdate.hide();
            Data();
        }
    })
}

// DELETE form
window.Deleteform = async (id) => {
    let htmlView = "";
    let data = await user.getById(id);
    
    htmlView=`
    <tr>
        <td>${data.userName}</td>
        <td>${data.personName}</td>
    </tr>`;

    byIdTable.innerHTML = htmlView;

    modalDelete.show();

    btnDelete.addEventListener('click', async () => {
        let deleteform = await user.delete(id);

        if(deleteform.status){
            modalDelete.hide();
            Data();
        }
    })
}

// CARGA CONTENIDO
Data();