/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function () {

    var buscaUsuariosController = {

        loadData: function (filter) {
            return $.grep(this.info, function (info) {
                return (!filter.Autor || info.Autor.indexOf(filter.Autor) > -1)
                        && (!filter.Email || info.Email.indexOf(filter.Email) > -1);
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

    window.buscaUsuariosController = buscaUsuariosController;
    buscaUsuariosController.info = [
        {
            "Usuario": "Otto Clay",
            "Email": "oto@sdkalksj.com",
            "Administrador": false
        },
        
        {
            "Usuario": "Alan",
            "Email": "alansoarescarneiro21@gail.com",
            "Administrador": true
        },
        
    ];

}());