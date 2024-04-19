import DAO.*;
import Models.*;

public class Main {
    public static void main(String[] args) {
        SetorDAO setorDAO = new SetorDAO();
        Setor setor1 = new Setor(1, "Centro Cirúrgico", "Alta");
        Setor setor2 = new Setor(2, "UTI", "Alta");
        Setor setor3 = new Setor(3, "Almoxarifado", "Baixa");
        //setorDAO.insertSetor(setor1);
        //setorDAO.insertSetor(setor2);
        //setorDAO.insertSetor(setor3);
        //setorDAO.selectSetor();
        //setorDAO.updateSetorCriticidade(3,"Média");
        //setorDAO.deleteSetor(3);
        //setorDAO.selectSetor();

        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
        Equipamento em1 = new Equipamento("BR0000002348", "Ventilador Pulmonar", "Sancont", "Ativo", 2);
        Equipamento em2 = new Equipamento("BR0000002348", "Desfibrilador", "Mindray", "Ativo", 1);
        //equipamentoDAO.insertEquipamento(em1);
        //equipamentoDAO.insertEquipamento(em2);
        //equipamentoDAO.selectEquipamento();
        //equipamentoDAO.updateEquipamentoEstado("BR0000002348","Desativado");
        //equipamentoDAO.selectEquipamento();
        //equipamentoDAO.deleteEquipamento("BR0000002348");
        //equipamentoDAO.selectEquipamento();

        TecnicoDAO tecnicoDAO = new TecnicoDAO();
        Tecnico tec1 = new Tecnico(1, "Paulo Pivoto", "Técnico Senior", "35 999241682", 1);
        Tecnico tec2 = new Tecnico(2, "Yves", "Técnico Júnior", "(33)999221111", 3);
        Tecnico tec3 = new Tecnico(3, "Luiz Gustavo", "Técnico Pleno", "(31)98888-2222", 2);
        //tecnicoDAO.insertTecnico(tec1);
        //tecnicoDAO.insertTecnico(tec2);
        //tecnicoDAO.selectTecnicos();
        //tecnicoDAO.updateTecnicoCargo(2,"Técnico Pleno");
        //tecnicoDAO.deleteTecnico(3);

        OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();
        OrdemDeServico os1 = new OrdemDeServico(0001, "15/04/2024", "",
                "", "UTI", "Paulo");
        OrdemDeServico os2 = new OrdemDeServico(0002,"01/01/2022","11/01/2022",
                "Realizada a substituição da válvula solenóide do equipamento","UTI","Paulo");

        ordemDeServicoDAO.insertOS(os1);
        ordemDeServicoDAO.insertOS(os2);
        //ordemDeServicoDAO.selectOS();
        //ordemDeServicoDAO.updateDataDeFechamento(0001,"18/04/2024");
        //ordemDeServicoDAO.updateDescricaoOS(0001,"Realizado manutenção preventiva.");
        //ordemDeServicoDAO.selectOS();
        //ordemDeServicoDAO.deleteOS(0001);
        //ordemDeServicoDAO.deleteOS(0002);
        //ordemDeServicoDAO.selectOS();

        OsEquipamentoDAO osEquipamentoDAO = new OsEquipamentoDAO();
        OrdensDeServico_Equipamentos ordensDeServicoEquipamentos1 = new OrdensDeServico_Equipamentos(os1.getNumOS(),em1.getNumDeSerie());
        //osEquipamentoDAO.selectOsEm();
        //osEquipamentoDAO.deleteOsEquip(0001,"BR0000002348");
        //osEquipamentoDAO.selectOsEm();
    }
}