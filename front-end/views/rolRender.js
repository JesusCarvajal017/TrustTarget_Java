
// alert('holaaaaaaaa')
import Server from "../models/server.js";

const modal = new bootstrap.Modal(document.getElementById('rolModal'));
const modalDelete = new bootstrap.Modal(document.querySelector("#deleteModal"));
const modalUpdate = new bootstrap.Modal(document.querySelector("#rolModalUpdate"));

const modalForm = document.querySelector("#rolForm"); // formulario

const formUpdate = document.getElementById("rolFormUpdate");
const byIdTable = document.querySelector(".rolDelete");


const btnDelete = document.querySelector(".deleteRol");

// modal.show();
let table = document.querySelector(".rol");

let rol = new Server("rol"); 

DataRol();

// QUERY ALL
async function DataRol(){
    let htmlView = "";
    let data = await rol.getAll();
    data.forEach((rol,i ) => {
        htmlView+= `
        <tr>
            <td>${i + 1}</td>
            <td>${rol.name}</td>
            <td>${rol.description}</td>
            <td><i class="fas fa-edit m-2" onclick="UpdateRol(${rol.id})" ></i><i class="fas fa-trash-alt m-2" onclick="DeleteRol(${rol.id})"></i> </td>
            <!-- fas fa-plus -->
        </tr>`;
    });
    
    table.innerHTML = htmlView;
}


// INSERT Rol
modalForm.addEventListener('submit', async (e) => {
    e.preventDefault();

    let formData = new FormData(modalForm);
    let data = Object.fromEntries(formData.entries());

    data.nameComplet = "";
    data.status = 1;

    let resgister = await rol.create(data);

    if(!resgister.errors){
        modal.hide();
        DataRol();
        modalForm.reset();
    }else{
        // modalForm.reset();
        //mostrar algo no se :(
        // modal.hide();
    }
});


// UPDATE Rol
window.UpdateRol = async (id) => {
    let RolDto = await rol.getById(id);

    let dataRol = {
        name: RolDto.name,
        description: RolDto.description
    }

    const form = document.getElementById("rolFormUpdate");
    // coloca los datos en el formulario
    for (let key in dataRol) {
        const input = form.querySelector(`[name="${key}"]`);
        
        if(input) {
            input.value = dataRol[key];
        }
    }

    modalUpdate.show();

    formUpdate.addEventListener('submit', async (e) => {

        e.preventDefault();
    
        let formData = new FormData(formUpdate);
        let data = Object.fromEntries(formData.entries());
        
        data.status = 1;
        data.id = id;
    
        let updateRol = await rol.update(data);
    
        if(updateRol.rowAfects){
            modalUpdate.hide();
            DataRol();
        }
    })
}

// DELETE Rol
window.DeleteRol = async (id) => {
    let htmlView = "";
    let data = await rol.getById(id);
    
    htmlView=`
    <tr>
        <td>${data.name}</td>
        <td>${data.description}</td>
    </tr>`;

    byIdTable.innerHTML = htmlView;

    modalDelete.show();

    btnDelete.addEventListener('click', async () => {
        let deleteRol = await rol.delete(id);

        if(deleteRol.status){
            modalDelete.hide();
            DataRol();
        }
    })
}

// CARGA CONTENIDO
DataRol();