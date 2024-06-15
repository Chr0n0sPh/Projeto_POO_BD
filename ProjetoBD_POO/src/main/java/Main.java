import DAO.*;
import Models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SetorDAO setorDAO = new SetorDAO();
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
        TecnicoDAO tecnicoDAO = new TecnicoDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao,idSetor,idTecnico;
        String nomeSetor,criticidade,numDeSerie,tipoDeEquipamento,fabricante,estado;
        String nomeTecnico,cargo,telefone;

        do{
            System.out.println("Escolha uma opção");
            System.out.println("1 - Cadastrar um Setor");
            System.out.println("2 - Atualizar a criticidade de um setor");
            System.out.println("3 - Listar Setores Cadastrados");
            System.out.println("4 - Deletar um Setor Cadastrado");
            System.out.println("5 - Cadastrar um equipamento");
            System.out.println("6 - Listar os Equipamentos Cadastrados");
            System.out.println("7 - Atualizar estado do Equipamento");
            System.out.println("8 - Listar os equipamentos cadastrados");
            System.out.println("9 - Deletar um equipamento cadastrado");
            System.out.println("10 - Cadastrar um técnico");
            System.out.println("11 - Listar os técnicos cadastrados");
            System.out.println("12 - Promover um ténico");
            System.out.println("13 - Remover um Técnico da Base de Dados");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 0:
                    break;
                case 1:
                    System.out.print("Entre com o Id do Setor: ");
                    idSetor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Informe o Nome do Setor: ");
                    nomeSetor = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Informe a criticidade(Baixa, Média ou Alta): ");
                    criticidade = scanner.nextLine();
                    scanner.nextLine();
                    Setor setor = new Setor(idSetor,nomeSetor,criticidade);
                    setorDAO.insertSetor(setor);
                    break;

                case 2:
                    System.out.print("Informe o código do setor: ");
                    idSetor = scanner.nextInt();
                    System.out.print("Informe a nova criticidade: ");
                    criticidade = scanner.next();
                    setorDAO.updateSetorCriticidade(idSetor,criticidade);
                    break;

                case 3:
                    setorDAO.selectSetor();
                    break;

                case 4:
                    System.out.print("Informe o código do setor a ser excluído: ");
                    idSetor = scanner.nextInt();
                    setorDAO.deleteSetor(idSetor);
                    break;

                case 5:
                    System.out.print("Digite o Número de Série do Equipamento: ");
                    numDeSerie = scanner.next();
                    System.out.print("Informe o tipo do equipamento: ");
                    tipoDeEquipamento = scanner.next();
                    System.out.print("Informe o fabricante do equipamento: ");
                    fabricante = scanner.next();
                    System.out.print("Informe o estado do equipamento (Ativo, Em manutenção ou Desativado): ");
                    estado = scanner.next();
                    System.out.print("Informe o código do setor ao qual o equipamento pertence: ");
                    idSetor = scanner.nextInt();
                    Equipamento equipamento = new Equipamento(numDeSerie,tipoDeEquipamento,fabricante,estado,idSetor);
                    equipamentoDAO.insertEquipamento(equipamento);

                case 6:
                    equipamentoDAO.selectEquipamento();
                    break;

                case 7:
                    System.out.print("Informe o Número de Série do Equipamento: ");
                    numDeSerie = scanner.next();
                    System.out.print("Informe o novo estado (Ativo, Em Manutenção ou Desativado): ");
                    estado = scanner.nextLine();
                    equipamentoDAO.updateEquipamentoEstado(numDeSerie,estado);
                    break;

                case 8:
                    equipamentoDAO.selectEquipamento();
                    break;

                case 9:
                    System.out.print("Informe o número de série do equipamento a ser deletado: ");
                    numDeSerie = scanner.next();
                    equipamentoDAO.deleteEquipamento(numDeSerie);
                    break;

                case 10:
                    System.out.print("Informe o ID do Técnico: ");
                    idTecnico = scanner.nextInt();
                    System.out.print("Informe o nome do técnico: ");
                    nomeTecnico = scanner.next();
                    System.out.print("Informe o Cargo: ");
                    cargo = scanner.next();
                    System.out.print("Informe o telefone de contato: ");
                    telefone = scanner.next();
                    System.out.print("Informe o ID do setor atribuido ao técnico: ");
                    idSetor = scanner.nextInt();
                    Tecnico tecnico = new Tecnico(idTecnico,nomeTecnico,cargo,telefone,idSetor);
                    tecnicoDAO.insertTecnico(tecnico);
                    break;

                case 11:
                    tecnicoDAO.selectTecnicos();
                    break;

                case 12:
                    System.out.print("Digite o ID do técnico: ");
                    idTecnico = scanner.nextInt();
                    System.out.print("Informe o novo cargo: ");
                    cargo = scanner.next();
                    tecnicoDAO.updateTecnicoCargo(idTecnico,cargo);
                    break;

                case 13:
                    System.out.print("Informe o ID do Técnico a ser removido: ");
                    idTecnico = scanner.nextInt();
                    tecnicoDAO.deleteTecnico(idTecnico);
            }
        }while (opcao != 0);
    }
}