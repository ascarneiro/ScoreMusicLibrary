// Code goes here

var URL_NOVO = '../../webresources/usuarios/create/';
var URL_TODOS = '../../webresources/usuarios/';
app = angular.module('modal.editing.usuario', ['ui.grid', 'ui.grid.edit', 'ui.bootstrap', 'schemaForm'])

        .constant('PersonSchema', {
            type: 'object',
            properties: {
                nmUsuario: {type: 'string', title: 'Usuario'},
                dsEmail: {type: 'string', title: 'Email'},
                ieAdministrador: {type: 'string', title: 'Administrador'},
            }
        })

        .controller('MainCtrl', MainCtrl)
        .controller('RowEditCtrl', RowEditCtrl)
        .service('RowEditor', RowEditor)
        ;


app.controller('putServiceCtrl', function ($scope, $http) {
    $scope.nmObra = null;
    $scope.nmAutor = null;
    $scope.ieInstrumento = null;
    $scope.putdata = function (nmUsuario, dsEmail, ieAdministrador) {


        var postObject = new Object();
        postObject.nmUsuario = nmUsuario;
        postObject.dsEmail = dsEmail;
        postObject.ieAdministrador = ieAdministrador
        

        $http({
            url: URL_NOVO + JSON.stringify(postObject),
            dataType: 'json',
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
                'Accept': 'application/json'
            }
        }).success(function (response) {
            $scope.msg = "Documento inserido com sucesso";
            $scope.response = response;
        }).error(function (error) {
            $scope.msg = "Service not Exists";
            $scope.error = error;
        });
    };
});

MainCtrl.$inject = ['$http', 'RowEditor'];
function MainCtrl($http, RowEditor) {
    var vm = this;

    vm.editRow = RowEditor.editRow;

    vm.gridOptions = {
        columnDefs: [
            {field: 'id', name: '', cellTemplate: 'edit-button.html', width: 34},
            {name: 'Usuario', field: 'nmUsuario'},
            {name: 'Email', field: 'dsEmail'},
            {name: 'Administrador', field: 'ieAdministrador'},
        ]
    };

    $http.get(URL_TODOS)
            .success(function (data) {
                vm.gridOptions.data = data;
            });
}

RowEditor.$inject = ['$rootScope', '$modal'];
function RowEditor($rootScope, $modal) {
    var service = {};
    service.editRow = editRow;

    function editRow(grid, row) {
        $modal.open({
            templateUrl: 'edit-modal.html',
            controller: ['$modalInstance', 'PersonSchema', 'grid', 'row', RowEditCtrl],
            controllerAs: 'vm',
            resolve: {
                grid: function () {
                    return grid;
                },
                row: function () {
                    return row;
                }
            }
        });
    }

    return service;
}

function RowEditCtrl($modalInstance, PersonSchema, grid, row) {
    var vm = this;

    vm.schema = PersonSchema;
    vm.entity = angular.copy(row.entity);
    vm.form = [
        'nmUsuario',
        'dsEmail',
        'ieAdministrador'
    ];

    vm.save = save;

    function save() {
        // Copy row values over
        row.entity = angular.extend(row.entity, vm.entity);
        $modalInstance.close(row.entity);
    }
}