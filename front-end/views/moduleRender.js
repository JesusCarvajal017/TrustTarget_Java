
import Server from "../models/server.js";

const modal = new bootstrap.Modal(document.getElementById('modalInsert'));
const modalDelete = new bootstrap.Modal(document.querySelector("#modalDelete"));
const modalUpdate = new bootstrap.Modal(document.querySelector("#modalUpdate"));

const modalForm = document.querySelector("#formInsert"); // formulario
const formUpdate = document.getElementById("formUpdate");

const byIdTable = document.querySelector(".deletePreQuery");


const btnDelete = document.querySelector(".deletebtn");

// modal.show();
let table = document.querySelector(".module");

let modulee = new Server("module"); 

// alert('hola')
Datamodule();

// QUERY ALL
async function Datamodule(){
    let htmlView = "";
    let data = await modulee.getAll();
    data.forEach((modulee,i ) => {
        htmlView+= `
        <tr>
            <td>${i + 1}</td>
            <td>${modulee.name}</td>
            <td>${modulee.description}</td>
            <td><i class="fas fa-edit m-2" onclick="Update(${modulee.id})" ></i><i class="fas fa-trash-alt m-2" onclick="Delete(${modulee.id})"></i> </td>
            <!-- fas fa-plus -->
        </tr>`;
    });
    
    table.innerHTML = htmlView;
}


// INSERT module
modalForm.addEventListener('submit', async (e) => {
    e.preventDefault();

    let formData = new FormData(modalForm);
    let data = Object.fromEntries(formData.entries());

    data.nameComplet = "";
    data.status = 1;

    let resgister = await modulee.create(data);

    if(!resgister.message){
        modal.hide();
        Datamodule();
        modalForm.reset();
    }else{
        // modalForm.reset();
        //mostrar algo no se :(
        // modal.hide();
    }
});


// UPDATE module
window.Update = async (id) => {
    let moduleDto = await modulee.getById(id);

    let datamodule = {
        name: moduleDto.name,
        description: moduleDto.description
    }

    const form = document.getElementById("formUpdate");
    // coloca los datos en el formulario
    for (let key in datamodule) {
        const input = form.querySelector(`[name="${key}"]`);
        
        if(input) {
            input.value = datamodule[key];
        }
    }

    modalUpdate.show();

    formUpdate.addEventListener('submit', async (e) => {

        e.preventDefault();
    
        let formData = new FormData(formUpdate);
        let data = Object.fromEntries(formData.entries());
        
        data.status = 1;
        data.id = id;
    
        let updatemodule = await modulee.update(data);
    
        if(updatemodule.rowAfects){
            modalUpdate.hide();
            Datamodule();
        }
    })
}

// DELETE module
window.Delete = async (id) => {
    let htmlView = "";
    let data = await modulee.getById(id);
    
    htmlView=`
    <tr>
        <td>${data.name}</td>
        <td>${data.description}</td>
    </tr>`;

    byIdTable.innerHTML = htmlView;

    modalDelete.show();

    btnDelete.addEventListener('click', async () => {
        let deletemodule = await modulee.delete(id);

        if(deletemodule.status){
            modalDelete.hide();
            Datamodule();
        }
    })
}

// CARGA CONTENIDO
Datamodule();