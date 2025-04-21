import DataExtraction from "../assets/js/global/peticiones.js";

class ApiRest{
    _urlBase = "";
    _enpoint = "";
    _servidor = "";

    constructor(urlbase, enpoint){
        this._servidor = new DataExtraction();
        this._urlBase = urlbase + enpoint;
    }

    async getPoint(){
        let data = await this._servidor.receptorData(this._urlBase );
        return data;
    }

    async getPointId(id){
        let data = await this._servidor.receptorData(this._urlBase  + "/" + id);
        return data;
    }

    async getPointName(name){
        let data = await this._servidor.receptorData(this._urlBase  + "/nameQuery/" + name);
        return data;
    }

    async postPoint(data){
        let data_info = await this._servidor.dataCaptura(this._urlBase + "/" , data, "POST");
        return data_info;
    }

    async putPoint(data){
        let data_info = await this._servidor.dataCaptura(this._urlBase + "/"  , data, "PUT");
        return data_info;
    }

    async deletePoint(id){
        let data_info = await this._servidor.dataCaptura(this._urlBase + "/" + id , { }, "DELETE");
        return data_info;
    }
}

export default ApiRest;