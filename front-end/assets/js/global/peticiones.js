class DataExtraction{
    _url;
    _response;
    // _metodo;

    //  ---------------------------------- envio y captura ----------------------------------
    async dataCaptura(url, data, metodo){
        try {
            let data_info = await fetch(url, {
                method: metodo, // POST, PUT, DELETE, GET
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data)
            });
            this._response = await data_info.json();
            
        } catch (error) {
            this._response = error;            
        }

        return this._response;
    }

    // ----------------------------------  solo recibe ----------------------------------
    async receptorData(url){
        try {
            let data_info = await fetch(url);
            this._response = await data_info.json();
            
        } catch (error) {
            this._response = error;            
        }

        return this._response;
    }

}

export default DataExtraction;