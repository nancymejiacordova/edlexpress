/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 * 
 * @param {type} contenedor
 * @param {type} idInput
 * @param {type} url
 * @param {type} responseType
 * @param {type} doneFunction
 * @returns {undefined}
 */
function Autocompletar_input(contenedor,idInput, url,responseType, doneFunction)
{
    if(typeof responseType === "undefined"){
        responseType = "json";
    }

    contenedor.find("#" + idInput).autocomplete({
        source: function (request, response) {
            $.ajax({
                url: url+ request.term ,
                dataType: responseType,
                success: function (result) {
                    doneFunction(result);
                }
            });
        },
        minLength: 3,
    });
}
