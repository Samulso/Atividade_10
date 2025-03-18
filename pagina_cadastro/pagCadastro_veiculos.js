function cadastrarDados(event){

    event.preventDefault();

    const id = document.getElementById("id").value.trim();
        if (!id) {
            alert("Por favor, digite o ID antes de cadastrar!");
            return;
        }
    const numero = document.getElementById("numero").value.trim();
        if (!numero) {
            alert("Por favor, digite o número antes de cadastrar!");
            return;
        }
    const linha = document.getElementById("linha").value.trim();
        if (!linha) {
            alert("Por favor, digite a linha antes de cadastrar!");
            return;
        }

        const veiculo = { id, numero, linha};

    const dados = JSON.parse(localStorage.getItem("dados")) || [];

    dados.push(veiculo);
    

    localStorage.setItem("dados", JSON.stringify(dados));

    alert("Dados salvos!");
    
    document.getElementById("id").value = "";
    document.getElementById("numero").value = "";
    document.getElementById("linha").value = "";
}

const sidebar = document.querySelector('.sidebar');
const toggleButton = document.querySelector('.toggle-sidebar');

toggleButton.addEventListener('click', () => {
    sidebar.classList.toggle('active');
});