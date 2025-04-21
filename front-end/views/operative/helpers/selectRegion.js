import Server from "../../../models/server.js";

let region = new Server("region"); 

export default async function listRegion(dom, selectedId = null) {
    let data = await region.getAll();
    let select = document.querySelector(dom);
    let htmlView = `<option value="" disabled ${selectedId === null ? 'selected' : ''}>seleccionar..</option>`;

    data.forEach((entity, i) => {
        const selectedAttr = entity.reg_id === selectedId ? 'selected' : '';
        htmlView += `<option value="${entity.reg_id}" ${selectedAttr}>${entity.reg_name}</option>`;
    });

    select.innerHTML = htmlView;
}