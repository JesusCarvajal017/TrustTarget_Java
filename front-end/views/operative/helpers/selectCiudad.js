import Server from "../../../models/server.js";

let cuidad = new Server("city"); 

export default async function listCuidad(dom, selectedId = null) {
    let data = await cuidad.getAll();
    let select = document.querySelector(dom);
    let htmlView = `<option value="" disabled ${selectedId === null ? 'selected' : ''}>seleccionar..</option>`;

    data.forEach((entity, i) => {
        const selectedAttr = entity.city_id === selectedId ? 'selected' : '';
        htmlView += `<option value="${entity.city_id}" ${selectedAttr}>${entity.city_name}</option>`;
    });

    select.innerHTML = htmlView;
}