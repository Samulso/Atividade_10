import java.util.ArrayList;
import java.util.Scanner;


class   Veiculo {
    private int IDVeiculo;
    private int numeroVeiculo;
    private int linhaVeiculo;

        public Veiculo(int IDVeiculo, int numeroVeiculo, int linhaVeiculo) {
            this.IDVeiculo = IDVeiculo;
            this.numeroVeiculo = numeroVeiculo;
            this.linhaVeiculo = linhaVeiculo;


        }

            public int getIDVeiculo(){
                return IDVeiculo;
            }
            
            public int getnumeroVeiculo(){
                return numeroVeiculo;
            }
            
            public int getlinhaVeiculo(){
                return linhaVeiculo;
            }

            @Override
                public String toString() {
                    return "\n\nID do veiculo: " + IDVeiculo + "\nNumero do veiculo: " + numeroVeiculo + "\nLinha: "+ linhaVeiculo +"";
            }
}

public class gerenciamento_veiculos {
    private static  ArrayList<Veiculo> listaVeiculos = new ArrayList<>();

    public static void main(String[] args) {
        
            Scanner scanner = new Scanner(System.in);

            int opcao;

                do {
                    System.out.println("=== Gerenciamento veicular ===");
                    System.out.print("\nEscolha uma opção:");

                    System.out.println("\n1- Cadastrar novo veiculo.");
                    System.out.println("\n2- Remover veiculo cadastrado.");
                    System.out.println("\n3- Pesquisar veiculo.");
                    System.out.println("\n4- Listar veiculos.");                    
                    System.out.println("\n0- FECHAR PROGRAMA.");
                    opcao = scanner.nextInt();
                    scanner.nextLine();


                        switch (opcao) {
                            case 1:
                                cadastrarNovoVeiculo(scanner);
                                break;
                            case 2:
                                removerVeiculo(scanner);
                                break;
                            case 3:
                                pesquisarVeiculo(scanner);
                                break;
                            case 4:
                                listarVeiculos();
                                break;
                            case 0:
                                System.out.println("Encerrando...");
                                break;
                            default:
                                    System.out.println("Opção não existente!");
                                break;
                        }

                } while (opcao != 0);
                    scanner.close();
    }

        private static void cadastrarNovoVeiculo(Scanner scanner){ 
            System.out.println("Insira o ID do veiculo: ");
            int IDVeiculo = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Insira o numero do veiculo: ");
            int numeroVeiculo = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Insira a linha do veiculo: ");
            int linhaVeiculo = scanner.nextInt();
            scanner.nextLine();

                listaVeiculos.add(new Veiculo(IDVeiculo, numeroVeiculo, linhaVeiculo));
                System.out.println("Veiculo adicionado!");

        }

        private static void removerVeiculo(Scanner scanner){ 
            System.out.println("Digite o ID do veiculo que deseja excluir: ");
            int IDVeiculo = scanner.nextInt();
            
            boolean encontrado = listaVeiculos.removeIf(veiculo -> veiculo.getIDVeiculo() == IDVeiculo);
                if (encontrado) {
                    System.out.println("Veiculo removido com sucesso!");
                } else {
                    System.out.println("Veiculo não encontrado!");
                }
        }

        private static void pesquisarVeiculo(Scanner scanner){ 
            System.out.println("Digite o ID do veiculo para buscar");
            int IDVeiculo  = scanner.nextInt();

            int index = buscaBinaria(IDVeiculo);
                if (index >= 0) {
                    System.out.println("Veiculo encontrado!" + listaVeiculos.get(index));
                } else {
                    System.out.println("Veiculo nao encontrado");
                }
        }

        private static void listarVeiculos(){ 
            if (listaVeiculos.isEmpty()) {
                    System.out.println("Nenhum veiculo encontrado!");                
            } else {
                    System.out.println("Lista de veiculos");
                    for (Veiculo veiculo : listaVeiculos) {
                        System.out.println(veiculo);
                    }
            }
        }
        
        private static int buscaBinaria(int IDVeiculo){
            int inicio = 0;
            int fim = listaVeiculos.size() - 1;

                while (inicio <= fim) {
                    int meio = (inicio + fim) / 2;
                    Veiculo veiculo = listaVeiculos.get(meio);

                    if (veiculo.getIDVeiculo() == IDVeiculo) {
                        return meio;
                    } else if (veiculo.getIDVeiculo() < IDVeiculo){
                        inicio = meio + 1;
                    } else {
                        fim = meio - 1;
                    }
                }

                return -1;
        }
}