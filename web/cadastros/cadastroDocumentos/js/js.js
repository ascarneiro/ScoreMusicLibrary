// Code goes here
var portaServer = 8084;
var URL_CREATE = '../../webresources/documentos/create/';
var URL_UPDATE = '../../webresources/documentos/update/';
var URL_DELETE = '../../webresources/documentos/delete/';

var URL_INSTRUMENTOS = '../../webresources/instrumentos';
var URL_TODOS = '../../webresources/documentos/';
var app = angular.module('modal.editing.documento', ['ui.grid', 'ui.grid.edit', 'ui.bootstrap', 'schemaForm', "ui.bootstrap.modal"])

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




app.controller('InstrumentosControl', function($scope, $http) {
    $scope.instrumentos = null;

    $http({
        method: 'GET',
        url: URL_INSTRUMENTOS,
    }).success(function(result) {
        $scope.instrumentos = result;
    });
});
app.controller('putServiceCtrl', function($scope, $http) {
    $scope.obra = null;
    $scope.autor = null;
    $scope.instrumento = null;
    $scope.create = function(obra, autor, livro) {


        var postObject = new Object();
        postObject.obra = obra;
        postObject.autor = autor;
        postObject.livro = livro;
        postObject.instrumento = $('#instrumento :selected').text();

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

    $scope.update = function(id, obra, autor, livro) {


        var postObject = new Object();
        postObject.id = id;
        postObject.obra = obra;
        postObject.autor = autor;
        postObject.livro = livro;
        postObject.instrumento = $('#instrumento :selected').text();

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

    $scope.delete = function(id, obra, autor, livro) {


        var postObject = new Object();
        postObject.id = id;
        postObject.obra = obra;
        postObject.autor = autor;
        postObject.livro = livro;
        postObject.instrumento = $('#instrumento :selected').text();

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

    $scope.remove = function(RowEditor) {

        var id = RowEditor.entity.id;
        var obra = RowEditor.entity.obra;
        var autor = RowEditor.entity.autor;
        var livro = RowEditor.entity.livro;
        var instrumento = RowEditor.entity.instrumento;
        $scope.delete(id, obra, autor, livro, instrumento);

    };

    $scope.edit = function(RowEditor) {

        var id = RowEditor.entity.id;
        var obra = RowEditor.entity.obra;
        var autor = RowEditor.entity.autor;
        var livro = RowEditor.entity.livro;
        var instrumento = RowEditor.entity.instrumento;

        //$scope.update(id, obra, autor, livro, instrumento);
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
            {name: 'autor', field: 'autor'},
            {name: 'livro', field: 'livro'},
            {name: 'instrumento', field: 'instrumento'},
            {name: 'obra', field: 'obra'}

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

$(document).ready(function(){
    $("a[rel=modal]").click( function(ev){
        ev.preventDefault();
 
        var id = $(this).attr("href");
 
        var alturaTela = $(document).height();
        var larguraTela = $(window).width();
     
        //colocando o fundo preto
        $('#mascara').css({'width':larguraTela,'height':alturaTela});
        $('#mascara').fadeIn(1000); 
        $('#mascara').fadeTo("slow",0.8);
 
        var left = ($(window).width() /2) - ( $(id).width() / 2 );
        var top = ($(window).height() / 2) - ( $(id).height() / 2 );
     
        $(id).css({'top':top,'left':left});
        $(id).show();   
    });
 
    $("#mascara").click( function(){
        $(this).hide();
        $(".window").hide();
    });
 
    $('.fechar').click(function(ev){
        ev.preventDefault();
        $("#mascara").hide();
        $(".window").hide();
    });
});