
// alert('holaaaaaaaa')
import Server from "../models/server.js";

const modalInsert = new bootstrap.Modal(document.getElementById('modalInsert'));
const modalDelete = new bootstrap.Modal(document.querySelector("#deleteModal"));
const modalUpdate = new bootstrap.Modal(document.querySelector("#updateModal"));

const formInsert = document.querySelector("#formInsert"); // formulario

const formUpdate = document.getElementById("formUpdate");
const byIdTable = document.querySelector(".deletePreQuery");


const btnDelete = document.querySelector(".deleteform");

// modal.show();
let table = document.querySelector(".permission");

let permission = new Server("permission"); 

Data();

// QUERY ALL
async function Data(){
    let htmlView = "";
    let data = await permission.getAll();
    data.forEach((permission,i ) => {
        htmlView+= `
        <tr>
            <td>${i + 1}</td>
            <td>${permission.name}</td>
            <td>${permission.description}</td>
            <td><i class="fas fa-edit m-2" onclick="Updateform(${permission.id})" ></i><i class="fas fa-trash-alt m-2" onclick="Deleteform(${permission.id})"></i> </td>
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

    data.nameComplet = "";
    data.status = 1;

    let resgister = await permission.create(data);

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
    let formDto = await permission.getById(id);

    let dataform = {
        name: formDto.name,
        description: formDto.description
    }

    const formF = document.getElementById("formUpdate");
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
    
        let updateform = await permission.update(data);
    
        if(updateform.rowAfects){
            modalUpdate.hide();
            Data();
        }
    })
}

// DELETE form
window.Deleteform = async (id) => {
    let htmlView = "";
    let data = await permission.getById(id);
    
    htmlView=`
    <tr>
        <td>${data.name}</td>
        <td>${data.description}</td>
    </tr>`;

    byIdTable.innerHTML = htmlView;

    modalDelete.show();

    btnDelete.addEventListener('click', async () => {
        let deleteform = await permission.delete(id);

        if(deleteform.status){
            modalDelete.hide();
            Data();
        }
    })
}

// CARGA CONTENIDO
Data();