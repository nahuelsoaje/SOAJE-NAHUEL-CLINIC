window.addEventListener("load", function () {
    const nombre = document.querySelector("#nombre");
    const apellido = document.querySelector("#apellido");
    const matricula = document.querySelector("#matricula");
    const urlAgregar = "http://localhost:8081/odontologos/registrar"
    const formCrearPaciente = document.forms[0];
  
    formCrearPaciente.addEventListener("submit", function (event) {
      event.preventDefault();
  
      const payload = {
        nombre: nombre.value,
        apellido: apellido.value,
        matricula: matricula.value,
        
      }
  
      console.log("Payload:", payload);
  
      const settings = {
        method: "POST",
        body: JSON.stringify(payload),
        headers: {
          "Content-Type": "application/json",
        },
      };
      console.log("Enviando solicitud...");
      
    fetch(urlAgregar, settings)
    .then((response) => {
        console.log("Respuesta del servidor (raw):", response);
        return response.json();
    })
    .then((odontologo) => {
        console.log("Respuesta del servidor (parsed):", odontologo);
        alert("odontologo guardado")
        window.location.href = "../index.html";
    })
    .catch((err) => {
        console.warn("Promesa rechazada");
        console.log(err);
          if (err.status == 400) {
            console.warn("id inválido");
            alert("id inválido");
          } else if (err.status == 401) {
            console.warn("Requiere Autorización");
            alert("Requiere Autorización");
          } else if (err.status == 404) {
            console.warn("Paciente inexistente");
            alert("Paciente inexistente");
          } else {
            console.error("Error del servidor");
            alert("Error del servidor");
          }
        });
  
  
        });
    });