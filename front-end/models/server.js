import ApiRest from '../service/api.js';

export default class Server {
    _apiRest = null;
    _urlBase = "http://localhost:8085/api/v1/"; // puerto de conexion db
    _enpoint = "";

    constructor(enpoint) {
        this._apiRest = new ApiRest(this._urlBase, enpoint);
    }

    async getAll() {
        return await this._apiRest.getPoint();
    }

    async getById(id) {
        return await this._apiRest.getPointId(id);
    }

    async getByName(name) {
        return await this._apiRest.getPointName(name);
    }

    async create(data) {
        return await this._apiRest.postPoint(data);
    }

    async update(data) {
        return await this._apiRest.putPoint(data);
    }

    async delete(id) {
        return await this._apiRest.deletePoint(id);
    }

}