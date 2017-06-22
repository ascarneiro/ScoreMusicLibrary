// Code goes here

var URL_TODOS = '../../webresources/usuarios/';
var URL_CREATE = '../../webresources/usuarios/create/';
var URL_UPDATE = '../../webresources/usuarios/update/';
var URL_DELETE = '../../webresources/usuarios/delete/';


app = angular.module('modal.editing.usuario', ['ui.grid', 'ui.grid.edit', 'ui.bootstrap', 'schemaForm', "ui.bootstrap.modal"])

        .constant('PersonSchema', {
            type: 'object',
            properties: {
                nmUsuario: {type: 'string', title: 'Usuario'},
                nmUsuario: {type: 'string', title: 'Usuario'},
                dsEmail: {type: 'string', title: 'Email'},
                ieAdministrador: {type: 'string', title: 'Administrador'},
            }
        })

        .controller('MainCtrl', MainCtrl)
        .controller('RowEditCtrl', RowEditCtrl)
        .service('RowEditor', RowEditor)
        ;


app.controller('putServiceCtrl', function($scope, $http) {
    $scope.nmObra = null;
    $scope.nmAutor = null;
    $scope.ieInstrumento = null;

    $scope.create = function(nmUsuario, dsEmail, ieAdministrador) {


        var postObject = new Object();
        postObject.nmUsuario = nmUsuario;
        postObject.dsEmail = dsEmail;
        postObject.ieAdministrador = ieAdministrador


        $http({
            url: URL_CREATE + JSON.stringify(postObject),
            dataType: 'json',
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
                'Accept': 'application/json'
            }
        }).success(function(response) {
            $scope.msg = "Documento inserido com sucesso";
            $scope.response = response;
            location.reload();
        }).error(function(error) {
            $scope.msg = "Service not Exists";
            $scope.error = error;
        });
    };

    $scope.update = function(id, nmUsuario, dsEmail, ieAdministrador) {


        var postObject = new Object();
        postObject.id = id;
        postObject.nmUsuario = nmUsuario;
        postObject.dsEmail = dsEmail;
        postObject.ieAdministrador = ieAdministrador


        $http({
            url: URL_UPDATE + JSON.stringify(postObject),
            dataType: 'json',
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
                'Accept': 'application/json'
            }
        }).success(function(response) {
            $scope.msg = "Documento inserido com sucesso";
            $scope.response = response;
            location.reload();
        }).error(function(error) {
            $scope.msg = "Service not Exists";
            $scope.error = error;
        });
    };

    $scope.delete = function(id, nmUsuario, dsEmail, ieAdministrador) {


        var postObject = new Object();
        postObject.id = id;
        postObject.nmUsuario = nmUsuario;
        postObject.dsEmail = dsEmail;
        postObject.ieAdministrador = ieAdministrador


        $http({
            url: URL_DELETE + JSON.stringify(postObject),
            dataType: 'json',
            method: 'DELETE',
            headers: {
                "Content-Type": "application/json",
                'Accept': 'application/json'
            }
        }).success(function(response) {
            $scope.msg = "Documento inserido com sucesso";
            $scope.response = response;
            location.reload();
        }).error(function(error) {
            $scope.msg = "Service not Exists";
            $scope.error = error;
        });
    };

    $scope.load = function(RowEditor) {

        var id = RowEditor.entity.id;
        var nmUsuario = RowEditor.entity.nmUsuario;
        var dsEmail = RowEditor.entity.dsEmail;
        var ieAdministrador = RowEditor.entity.ieAdministrador;
        $scope.delete(id, nmUsuario, dsEmail, ieAdministrador);

    };

    $scope.open = function() {
        $scope.showModal = true;
    };

    $scope.ok = function() {
        $scope.showModal = false;
    };

    $scope.cancel = function() {
        $scope.showModal = false;
    };
});

MainCtrl.$inject = ['$http', 'RowEditor'];
function MainCtrl($http, RowEditor) {
    var vm = this;

    vm.editRow = RowEditor.editRow;

    vm.gridOptions = {
        columnDefs: [
            {field: 'id', name: '', cellTemplate: 'edit-button.html', width: 60},
            {name: 'Usuario', field: 'nmUsuario'},
            {name: 'Email', field: 'dsEmail'},
            {name: 'Administrador', field: 'ieAdministrador'},
        ]
    };

    $http.get(URL_TODOS)
            .success(function(data) {
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
                grid: function() {
                    return grid;
                },
                row: function() {
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
        'id',
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