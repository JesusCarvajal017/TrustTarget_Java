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
let typeIdentification = new Server("identificationType"); 


Data();

// QUERY ALL
async function Data(){
    let htmlView = "";
    let data = await typeIdentification.getAll();
    // console.log(data);
    data.forEach((identification,i ) => {
        htmlView+= `
        <tr>
            <td>${i + 1}</td>
            <td>${identification.ident_name}</td>
            <td>${identification.ident_acronym}</td>
            <td><i class="fas fa-edit m-2" onclick="Updateform(${identification.ident_id})" ></i><i class="fas fa-trash-alt m-2" onclick="Deleteform(${identification.ident_id})"></i> </td>
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

    
    let resgister = await typeIdentification.create(data);

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
    let entity = await typeIdentification.getById(id);

    let dataform = {
        ident_name: entity.ident_name,
        ident_acronym : entity.ident_acronym
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
        
        data.ident_id = id;
    
        let updateform = await typeIdentification.update(data);
    
        if(updateform){
            modalUpdate.hide();
            Data();
        }e
    })
}

let currentDeleteId = null;

btnDelete.addEventListener('click', async () => {
    if(currentDeleteId !== null){
        let deleteform = await typeIdentification.delete(currentDeleteId);
    
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
    let data = await typeIdentification.getById(id);
    
    htmlView=`
    <tr>
        <td>${data.ident_name}</td>
        <td>${data.ident_acronym}</td>
    </tr>`;

    byIdTable.innerHTML = htmlView;

    modalDelete.show();

}

// CARGA CONTENIDO
Data();