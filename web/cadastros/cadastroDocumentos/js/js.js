// Code goes here
var portaServer = 8084;
var URL_NOVO = '../../webresources/documentos/create/';
var URL_INSTRUMENTOS = '../../webresources/instrumentos';
var URL_TODOS = '../../webresources/documentos/';
var app = angular.module('modal.editing.documento', ['ui.grid', 'ui.grid.edit', 'ui.bootstrap', 'schemaForm'])

        .constant('PersonSchema', {
            type: 'object',
            properties: {
                autor: {type: 'string', title: 'Autor'},
                livro: {type: 'string', title: 'Livro'},
                instrumento: {type: 'string', title: 'Instrumento'},
                obra: {type: 'string', title: 'Obra'}
            }
        })

        .controller('MainCtrl', MainCtrl)
        .controller('RowEditCtrl', RowEditCtrl)
        .service('RowEditor', RowEditor)
        ;


app.controller('InstrumentosControl', function ($scope, $http) {
    $scope.instrumentos = null;

    $http({
        method: 'GET',
        url: URL_INSTRUMENTOS,
    }).success(function (result) {
        $scope.instrumentos = result;
    });
});
app.controller('putServiceCtrl', function ($scope, $http) {
    $scope.obra = null;
    $scope.autor = null;
    $scope.instrumento = null;
    $scope.putdata = function (obra, autor, livro) {


        var postObject = new Object();
        postObject.obra = obra;
        postObject.autor = autor;
        postObject.livro = livro;
        postObject.instrumento = $('#instrumento :selected').text();

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
            {name: 'autor', field: 'autor'},
            {name: 'livro', field: 'livro'},
            {name: 'instrumento', field: 'instrumento'},
            {name: 'obra', field: 'Obra'}
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
        'autor',
        'livro',
        'instrumento',
        'obra'
    ];

    vm.save = save;

    function save() {
        // Copy row values over
        row.entity = angular.extend(row.entity, vm.entity);
        $modalInstance.close(row.entity);
    }
}