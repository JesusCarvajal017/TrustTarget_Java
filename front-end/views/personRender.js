import Server from "../models/server.js";

const modal = new bootstrap.Modal(document.getElementById('personModal'));
const modalDelete = new bootstrap.Modal(document.querySelector("#deleteModal"));
const modalUpdate = new bootstrap.Modal(document.querySelector("#personModalUpdate"));


const modalForm = document.querySelector("#personForm"); // modal de inpust
const formUpdate = document.getElementById("personFormUpdate");
const byIdTable = document.querySelector(".personDelete");


const btnDelete = document.querySelector(".deletePerson");

// modal.show();
let table = document.querySelector(".person");

let person = new Server("person"); 

// QUERY ALL
async function DataPerson(){
    let htmlView = "";
    let data = await person.getAll();
    data.forEach((person,i ) => {
        htmlView+= `
        <tr>
            <td>${i + 1}</td>
            <td>${person.nameComplet}</td>
            <td>${person.email}</td>
            <td>${person.identification}</td>
            <td>${person.age}</td>
            <td><i class="fas fa-edit m-2" onclick="UpdatePerson(${person.id})" ></i><i class="fas fa-trash-alt m-2" onclick="DeletePerson(${person.id})"></i> </td>
            <!-- fas fa-plus -->
        </tr>`;
    });
    
    table.innerHTML = htmlView;
}


// INSERT PERSON
modalForm.addEventListener('submit', async (e) => {
    e.preventDefault();

    let formData = new FormData(modalForm);
    let data = Object.fromEntries(formData.entries());

    data.nameComplet = "";
    data.status = 1;

    let resgister = await person.create(data);

    if(!resgister.errors){
        modal.hide();
        DataPerson();
        modalForm.reset();
    }else{
        // modalForm.reset();
        //mostrar algo no se :(
        // modal.hide();
    }
});


// UPDATE PERSON
window.UpdatePerson = async (id) => {
    let personDto = await person.getById(id);

    let dataPerson = {
        name: personDto.name,
        lastName: personDto.lastName,
        email: personDto.email,
        identification: personDto.identification,
        age: personDto.age
    }

    const form = document.getElementById("personFormUpdate");
    // coloca los datos en el formulario
    for (let key in dataPerson) {
        const input = form.querySelector(`[name="${key}"]`);
        console.log(key)
        
        if(input) {
            input.value = dataPerson[key];
        }
    }

    modalUpdate.show();

    formUpdate.addEventListener('submit', async (e) => {

        e.preventDefault();
    
        let formData = new FormData(formUpdate);
        let data = Object.fromEntries(formData.entries());
        
        data.nameComplet = "";
        data.status = 1;
        data.id = id;
    
        let updatePerson = await person.update(data);
    
        if(updatePerson.rowAfects){
            modalUpdate.hide();
            DataPerson();
        }
    })
}

// DELETE PERSON
window.DeletePerson = async (id) => {
    let htmlView = "";
    let data = await person.getById(id);
    
    htmlView=`
    <tr>
        <td>${data.nameComplet}</td>
        <td>${data.identification}</td>
    </tr>`;

    byIdTable.innerHTML = htmlView;

    modalDelete.show();

    btnDelete.addEventListener('click', async () => {
        let deletePerson = await person.delete(id);

        if(deletePerson.status){
            modalDelete.hide();
            DataPerson();
        }
    })
}

// CARGA CONTENIDO
DataPerson();