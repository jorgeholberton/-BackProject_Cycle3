document.addEventListener
("DOMContentLoaded", function () {
        document.getElementById("registro").addEventListener('submit', validarFormulario);
    }
);

function validarFormulario(evento) {
    evento.preventDefault();
    var codigo = document.getElementById('cod_pa').value;
    var dependencia = document.getElementById('cod_dep').value;
    var nombre = document.getElementById('nomb').value;
    var apellido = document.getElementById('ape').value;
    var direccion = document.getElementById('dir_pa').value;
    var telefono = document.getElementById('tel_pa').value;
    var email1 = document.getElementById('email').value;
    var email2 = document.getElementById('Username').value;
    var email3 = email1+"@"+email2;

    // PREPARE FORM DATA
    var formData = {
        "codigo": codigo,
        "cod_dependencia": dependencia,
        "nombre": nombre,
        "apellido": apellido,
        "direccion": direccion,
        "correo": email3,
        "telefono": telefono,
        "codigo_rol": 123456
    }

    // DO POST
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/api/v1/paciente",
        data: JSON.stringify(formData),
        dataType: 'json',
        success: function (result) {
            if (result.status == "success") {
                $("#postResultDiv").html(
                    "" + result.data.informacion
                    + "Post Successfully! <br>"
                    + "---> Congrats !!" + "</p>");
            } else {
                $("#postResultDiv").html("<strong>Error</strong>");
            }
            console.log(result);
        },
        error: function (e) {
            alert("Error!")
            console.log("ERROR: ", e);
        }
    });


    //this.submit();
}
