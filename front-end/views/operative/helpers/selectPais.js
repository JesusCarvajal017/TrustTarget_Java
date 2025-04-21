import Server from "../../../models/server.js";


let pais = new Server("country"); 

export default async function listPais(dom, selectedId = null) {
    let data = await pais.getAll();
    let select = document.querySelector(dom);
    let htmlView = `<option value="" disabled ${selectedId === null ? 'selected' : ''}>seleccionar..</option>`;

    data.forEach((entity, i) => {
        const selectedAttr = entity.nation_id === selectedId ? 'selected' : '';
        htmlView += `<option value="${entity.nation_id}" ${selectedAttr}>${entity.nation_name}</option>`;
    });

    select.innerHTML = htmlView;
}