(function () {

    var uploadController = {

        loadData: function (filter) {
            return $.grep(this.info, function (info) {
                return (!filter.Autor || info.Autor.indexOf(filter.Autor) > -1)
                        && (!filter.Instrumento || info.Instrumento.indexOf(filter.Instrumento) > -1)
                        && (!filter.Livro || info.Livro.indexOf(filter.Livro) > -1)
                        && (!filter.Usuario || info.Usuario.indexOf(filter.Usuario) > -1);
            });
        },

        insertItem: function (insertingInfo) {
            this.info.push(insertingInfo);
        },

        updateItem: function (updatingInfo) { },

        deleteItem: function (deletingInfo) {
            var infoIndex = $.inArray(deletingInfo, this.info);
            this.info.splice(infoIndex, 1);
        }

    };

    window. uploadController = uploadController;
    uploadController.info = [
        {
            "Autor": "Otto Clay",
            "Instrumento": "Trompete",
            "Livro": 6,
            "Usuario": "Alan",
            "Download": false
        },
        {
            "Autor": "ALan",
            "Instrumento": "Trompete",
            "Livro": 6,
            "Usuario": "Alan",
            "Download": false
        },
    ];

}());