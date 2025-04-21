import Server from "../../models/server.js";

const modalInsert = new bootstrap.Modal(document.getElementById('modalInsert'));
const modalDelete = new bootstrap.Modal(document.querySelector("#deleteModal"));
const modalUpdate = new bootstrap.Modal(document.querySelector("#updateModal"));

const formInsert = document.querySelector("#formInsert"); // formulario

const formUpdate = document.getElementById("formUpdate");
const byIdTable = document.querySelector(".deletePreQuery");

const btnDelete = document.querySelector(".deleteform");

// modal.show();
let table = document.querySelector(".form");
let empresas = new Server("company"); 


Data();

// QUERY ALL
async function Data(){
    let htmlView = "";
    let data = await empresas.getAll();
    // console.log(data);
    data.forEach((entity,i ) => {
        htmlView+= `
        <tr>
            <td>${i + 1}</td>
            <td>${entity.com_name}</td>
            <td>${entity.com_code}</td>
            <td><i class="fas fa-edit m-2" onclick="Updateform(${entity.com_id})" ></i><i class="fas fa-trash-alt m-2" onclick="Deleteform(${entity.com_id})"></i> </td>
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

    
    let resgister = await empresas.create(data);

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
    let entity = await empresas.getById(id);

    let dataform = {
        com_name: entity.com_name,
        com_code: entity.com_code,
    }

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
        let data = Object.fromEntries(formData.entries());
        
        data.com_id = id;
    
        let updateform = await empresas.update(data);
    
        if(updateform.status){
            modalUpdate.hide();
            Data();
        }e
    })
}

let currentDeleteId = null;

btnDelete.addEventListener('click', async () => {
    if(currentDeleteId !== null){
        let deleteform = await empresas.delete(currentDeleteId);
    
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
    let data = await empresas.getById(id);
    
    htmlView=`
    <tr>
        <td>${data.com_name}</td>
        <td>${data.com_code}</td>
    </tr>`;

    byIdTable.innerHTML = htmlView;

    modalDelete.show();

}

// CARGA CONTENIDO
Data();