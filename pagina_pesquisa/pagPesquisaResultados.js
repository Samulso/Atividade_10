function carregarTodosVeic() {
    const dados = JSON.parse(localStorage.getItem("dados")) || [];

    const listaResultados = document.getElementById("listaResultados");
    listaResultados.innerHTML = "";

    if (dados.length === 0){
        listaResultados.innerHTML = "<li>Nenhum veiculo encontrado com o ID informado.</li>";
    } else {

        dados.forEach(veiculo => {
            const item = document.createElement("li")
            item.textContent = `ID: ${veiculo.id}, Número: ${veiculo.numero}, linha: ${veiculo.linha}`;
            listaResultados.appendChild(item);
        });
    }

}

function pesquisarVeiculo(event) {
    event.preventDefault();
    
    const idPesquisa = document.getElementById("idPesquisa").value.trim();
    const dados = JSON.parse(localStorage.getItem("dados")) || [];

    const listaResultados = document.getElementById("listaResultados");
    listaResultados.innerHTML = "";

    if (!idPesquisa) {
        alert("Por favor, digite o ID do veiculo para realizar a pesquisa.");
        return;
    }

    const resultados = dados.filter(veiculo => veiculo.id === idPesquisa);

    if (resultados.length === 0){
        listaResultados.innerHTML = "<li>Nenhum veiculo encontrado com o ID informado.</li>";
  
    } else {
        resultados.forEach(veiculo => {
            const item = document.createElement("li");
            item.textContent = `ID: ${veiculo.id}, Número: ${veiculo.numero}, linha: ${veiculo.linha}`;
            listaResultados.appendChild(item);
        });
    }

}