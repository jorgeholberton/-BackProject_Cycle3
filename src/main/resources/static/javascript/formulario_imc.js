document.addEventListener
("DOMContentLoaded", function () {
        document.getElementById("registro").addEventListener('submit', validarFormulario);
    }
);

function validarFormulario(evento) {
    evento.preventDefault();
    var est = document.getElementById('est').value;
    var peso = document.getElementById('peso').value;

    if (est.length == 0) {
        alert('Campo Estatura Vacio');
        return;
    }

    if (peso.length == 0) {
        alert('Campo Peso Vacio');
        return;
    }

    var cat_normal = 'Normal';
    var cat_bajopeso = 'Bajo Peso';
    var cat_sobrepeso = 'Sobre Peso';
    var cat_obeso = 'Obeso';

    var normal = 'Su peso está en la categoría Normal para adultos de su misma estatura. Para su estatura, un peso normal variaría entre 53.5  a  72 kilogramos. Mantener un peso saludable puede reducir el riesgo de enfermedades crónicas asociadas al sobrepeso y la obesidad.';
    var bajopeso = 'Su peso está en la categoría de Bajo peso para adultos de su misma estatura. Para su estatura, un peso normal variaría entre 53.5  a  72 kilogramos. Hable con su proveedor de atención médica para establecer las posibles causas del bajo peso y si necesita ganar peso. ';
    var sobrepeso = 'Su peso está en la categoría de Sobrepeso para adultos de su misma estatura. Para su estatura, un peso normal variaría entre 49.2 a 66.2 kilogramos. Las personas que tienen sobrepeso o son obesas tienen un mayor riesgo de afecciones crónicas, tales como hipertensión arterial, diabetes y colesterol alto.     Toda persona que tenga sobrepeso debería tratar de evitar ganar más peso. Además, si usted tiene sobrepeso junto con otros factores de riesgo (como niveles altos de colesterol LDL, niveles bajos de colesterol HDL o hipertensión arterial), debería tratar de perder peso. Incluso una pequeña disminución (tan solo 10 % de su peso actual) puede ayudar a disminuir el riesgo de enfermedades. Hable con su proveedor de atención médica para establecer maneras adecuadas de perder peso.';
    var obeso = 'Su peso está en la categoría de Obeso para adultos de su misma estatura. Para su estatura, un peso normal variaría entre 47.4 a 63.7 kilogramos. Las personas que tienen sobrepeso o son obesas tienen un mayor riesgo de afecciones crónicas, tales como hipertensión arterial, diabetes y colesterol alto. Toda persona que tenga sobrepeso debería tratar de evitar ganar más peso. Además, si usted tiene sobrepeso junto con otros factores de riesgo (como niveles altos de colesterol LDL, niveles bajos de colesterol HDL o hipertensión arterial), debería tratar de perder peso. Incluso una pequeña disminución (tan solo 10 % de su peso actual) puede ayudar a disminuir el riesgo de enfermedades. Hable con su proveedor de atención médica para establecer maneras adecuadas de perder peso.';


    var masa = (peso / Math.pow(est, 2)).toFixed(2);//dos posiciones decimales
    var resultado;
    var res_categoria;
    document.registro.imcobtenido.value = masa;

    if (masa >= 20) {
        if (masa <= 27) {
            document.registro.msg.value = normal;

            document.registro.categoria_obtenida.value = cat_normal;
            resultado = normal;
            res_categoria = cat_normal
        } else if (masa <= 30) {
            document.registro.msg.value = sobrepeso;
            document.registro.categoria_obtenida.value = cat_sobrepeso;
            resultado = sobrepeso;
            res_categoria = cat_sobrepeso;
        } else {
            document.registro.msg.value = obeso;
            document.registro.categoria_obtenida.value = cat_obeso;
            resultado = obeso;
            res_categoria = cat_bajopeso
        }
    } else {
        document.registro.msg.value = bajopeso;
        document.registro.categoria_obtenida.value = cat_bajopeso;
        resultado = bajopeso;
        res_categoria = cat_bajopeso;
    }


    // PREPARE FORM DATA
    var formData = {
        "paciente": "E123457",
        "estatura": est,
        "peso": peso,
        "imc": masa,
        "clasificacion": res_categoria,
        "recomendacion": resultado,
        "cod_paciente": "123457"
    }

    // DO POST
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/api/v1/informacion",
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
