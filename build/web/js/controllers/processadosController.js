/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function () {

    var processadosController = {
        loadData: function (filter) {
            return $.grep(this.info, function (info) {
                return (!filter.Autor || info.Autor.indexOf(filter.Autor) > -1)
                        && (!filter.Instrumento || info.Instrumento.indexOf(filter.Instrumento) > -1)
                        && (!filter.Livro || info.Livro.indexOf(filter.Livro) > -1);
            });
        },
        insertItem: function (insertingInfo) {
            this.info.push(insertingInfo);
        },
        updateItem: function (updatingInfo) {
        },
        deleteItem: function (deletingInfo) {
            var infoIndex = $.inArray(deletingInfo, this.info);
            this.info.splice(infoIndex, 1);
        }

    };

    window.processadosController = processadosController;
    processadosController.info = [
        {
            "Autor": "Otto Clay",
            "Instrumento": "Trompete",
            "Livro": 6,
        },
        {
            "Autor": "ALan",
            "Instrumento": "Trompete",
            "Livro": 6,
        },
    ];

}());
