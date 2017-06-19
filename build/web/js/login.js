/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $('#signin').click(function () {
        $.ajax({
            url: '../LoginServlet',
            method: 'POST',
            data: {
                email: $('#email').val(),
                senha: $('#senha').val()
            },
            success: function (responseText) {
                window.location.href = "../menu/principal.html";
            },
         
        });
    });

    $('#cadastrar').click(function () {
        $.ajax({
            url: '../NovoUsuarioServlet',
            method: 'POST',
            data: {
                usuario: $('#usuario').val(),
                senha1: $('#senha1').val(),
                senha2: $('#senha2').val(),
                email1: $('#email1').val(),
                email2: $('#email2').val(),
            },
            success: function (responseText) {
               window.location.href = "../login/login.html"; 
            },
        
        });
    });

});