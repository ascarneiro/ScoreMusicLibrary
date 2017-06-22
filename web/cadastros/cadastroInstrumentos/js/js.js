// Code goes here

var URL_CREATE = '../../webresources/instrumentos/create/';
var URL_UPDATE = '../../webresources/instrumentos/update/';
var URL_DELETE = '../../webresources/instrumentos/delete/';



var URL_TODOS = '../../webresources/instrumentos/';
app = angular.module('modal.editing.instrumentos', ['ui.grid', 'ui.grid.edit', 'ui.bootstrap', 'schemaForm', "ui.bootstrap.modal"])

        .constant('PersonSchema', {
            type: 'object',
            properties: {
                dsInstrumento: {type: 'string', title: 'Instrumento'},
                dsFamilia: {type: 'string', title: 'Familia'}
            }
        })

        .controller('MainCtrl', MainCtrl)
        .controller('RowEditCtrl', RowEditCtrl)
        .service('RowEditor', RowEditor)
        ;


app.controller('putServiceCtrl', function($scope, $http) {
    $scope.dsInstrumento = null;
    $scope.dsFamilia = null;

    $scope.create = function(dsInstrumeto, dsFamilia) {


        var postObject = new Object();
        postObject.dsInstrumento = dsInstrumeto;
        postObject.dsFamilia = dsFamilia;


        $http({
            url: URL_CREATE + JSON.stringify(postObject),
            dataType: 'json',
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
                'Accept': 'application/json'
            }
        }).success(function(response) {
            $scope.msg = "Instrumento inserido com sucesso";
            $scope.response = response;
            location.reload();
        }).error(function(error) {
            $scope.error = error;
        });
    };

    $scope.update = function(id, dsInstrumeto, dsFamilia) {


        var postObject = new Object();
        postObject.id = id;
        postObject.dsInstrumento = dsInstrumeto;
        postObject.dsFamilia = dsFamilia;


        $http({
            url: URL_UPDATE + JSON.stringify(postObject),
            dataType: 'json',
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
                'Accept': 'application/json'
            }
        }).success(function(response) {
            $scope.response = response;
            location.reload();
        }).error(function(error) {
            $scope.msg = "Service not Exists";
            $scope.error = error;
        });
    };

    $scope.delete = function(id, dsInstrumeto, dsFamilia) {


        var postObject = new Object();
        postObject.id = id;
        postObject.dsInstrumento = dsInstrumeto;
        postObject.dsFamilia = dsFamilia;


        $http({
            url: URL_DELETE + JSON.stringify(postObject),
            dataType: 'json',
            method: 'DELETE',
            headers: {
                "Content-Type": "application/json",
                'Accept': 'application/json'
            }
        }).success(function(response) {
            $scope.response = response;
            location.reload();
        }).error(function(error) {
            $scope.msg = "Service not Exists";
            $scope.error = error;
        });
    };

    $scope.load = function(RowEditor) {

        id = RowEditor.entity.id;
        dsInstrumento = RowEditor.entity.dsInstrumento;
        dsFamilia = RowEditor.entity.dsFamilia;
        $scope.delete(id, dsInstrumento, dsFamilia)


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
            {name: 'Instrumento', field: 'dsInstrumento'},
            {name: 'Familia', field: 'dsFamilia'}
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
        'Instrumento',
        'Familia'
    ];

    vm.save = save;

    function save() {
        // Copy row values over
        row.entity = angular.extend(row.entity, vm.entity);
        $modalInstance.close(row.entity);
    }
}