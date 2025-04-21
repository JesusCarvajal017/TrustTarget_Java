import Server from "../../../models/server.js";

let identificacion = new Server("identificationType"); 

export default async function listIdentification(dom, selectedId = null) {
    let data = await identificacion.getAll();
    let select = document.querySelector(dom);
    let htmlView = `<option value="" disabled ${selectedId === null ? 'selected' : ''}>seleccionar..</option>`;

    data.forEach((entity, i) => {
        const selectedAttr = entity.ident_id === selectedId ? 'selected' : '';
        htmlView += `<option value="${entity.ident_id}" ${selectedAttr}>${entity.ident_name}</option>`;
    });

    select.innerHTML = htmlView;
}