package DAO;

import Models.OrdemDeServico;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdemDeServicoDAO extends ConnectionDAO{
    private boolean sucesso;

    //insert
    public boolean insertOS(OrdemDeServico os){
        connectToDB();

        String sql = "INSERT INTO ordensdeserviço (numOS,dataAbertura,dataFechamento,descricaoOS,SetordeOrigem,nomedoTecico)VALUES(?,?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,os.getNumOS());
            pst.setString(2,os.getDataAbertura());
            pst.setString(3,os.getDataFechamento());
            pst.setString(4,os.getDescricaoOS());
            pst.setString(5,os.getSetorDeOrigem());
            pst.setString(6,os.getNomeDoTecnico());
            pst.execute();
            System.out.println("ORDEM DE SERVIÇO CADASTRADA COM SUCESSO!");
            sucesso = true;
        }catch (SQLException e){
            System.out.printf("Erro: " + e.getMessage());
            sucesso = false;
        }finally {
            try {
                con.close();
                pst.close();
            }catch (SQLException e){
                System.out.printf("Erro: " + e.getMessage() );
            }
        }
        return sucesso;
    }

    //Update Data de fechamento
    public boolean updateDataDeFechamento(int numOS, String data) {
        connectToDB();
        String sql = "UPDATE ordensdeserviço SET dataFechamento=? where numOS=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, data);
            pst.setInt(2, numOS);
            pst.execute();
            System.out.println("Data de Fechamento atualizada!");
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //Select
    public ArrayList<OrdemDeServico> selectOS(){
        ArrayList<OrdemDeServico> ordemDeServicos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM ordensdeserviço";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Ordens de Serviço: ");

            while (rs.next()) {

                OrdemDeServico osAux = new OrdemDeServico(rs.getInt("numOS"),rs.getString("dataAbertura"),
                        rs.getString("dataFechamento"),rs.getString("descricaoOS"),
                        rs.getString("SetordeOrigem"),rs.getString("nomedoTecico"));

                System.out.println("OS N°: " + osAux.getNumOS());
                System.out.println("Data de Abertura: " + osAux.getDataAbertura());
                System.out.println("Data de Fechamento: " + osAux.getDataFechamento());
                System.out.println("Descrição do Serviço");
                System.out.println(osAux.getDescricaoOS());
                System.out.println("Setor de Demandante: " + osAux.getSetorDeOrigem());
                System.out.println("Responsável pelo Atendimento: " + osAux.getNomeDoTecnico());
                System.out.println("--------------------------------");

                ordemDeServicos.add(osAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return ordemDeServicos;
    }

    //Update
    public boolean updateDescricaoOS(int numOS, String description) {
        connectToDB();
        String sql = "UPDATE ordensdeserviço SET descricaoOS=? where numOS=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, description);
            pst.setInt(2, numOS);
            pst.execute();
            System.out.println("Descrição atualizada!");
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //Delete
    public boolean deleteOS (int numOS) {
        connectToDB();
        String sql = "DELETE FROM ordensdeserviço where numOS=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, numOS);
            pst.execute();
            System.out.println("Ordem de Serviço removida do Sistema");
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
}