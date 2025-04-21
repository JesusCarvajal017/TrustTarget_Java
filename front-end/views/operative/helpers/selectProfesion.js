import Server from "../../../models/server.js";

let profesion = new Server("profession"); 

export default async function listProfesion(dom, selectedId = null) {
    let data = await profesion.getAll();
    let select = document.querySelector(dom);
    let htmlView = `<option value="" disabled ${selectedId === null ? 'selected' : ''}>seleccionar..</option>`;

    data.forEach((entity, i) => {
        const selectedAttr = entity.prof_id === selectedId ? 'selected' : '';
        htmlView += `<option value="${entity.prof_id}" ${selectedAttr}>${entity.prof_name}</option>`;
    });

    select.innerHTML = htmlView;
}