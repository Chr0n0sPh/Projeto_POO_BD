package DAO;

import Models.OrdemDeServico;
import Models.OrdensDeServico_Equipamentos;
import Models.Setor;
import Models.Tecnico;

import java.sql.SQLException;
import java.util.ArrayList;

public class OsEquipamentoDAO extends ConnectionDAO{
    private boolean sucesso;

    //insert
    public boolean insertOsEm(int numOS, String numDeSerie){
        connectToDB();

        String sql = "INSERT INTO ordensdeserviço_has_equipamento (OrdemdeServiço_numOS, Equipamento_numDeSerie)VALUES(?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,numOS);
            pst.setString(2,numDeSerie);
            pst.execute();
            System.out.println("Linkagem de OS e EM Realizada");
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

    //Select
    public ArrayList<OrdensDeServico_Equipamentos> selectOsEm(){
        ArrayList<OrdensDeServico_Equipamentos> ordensDeServicoEquipamentos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM ordensdeserviço_has_equipamento";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Ordens de Serviço por numero de série: ");

            while (rs.next()) {

                OrdensDeServico_Equipamentos osEmAux = new OrdensDeServico_Equipamentos(rs.getInt("OrdemdeServiço_numOS"),rs.getString("Equipamento_numDeSerie"));

                System.out.println("OS N°: " + osEmAux.getNumOS());
                System.out.println("Número de Série do Equipamento: " + osEmAux.getNumDeSerie());
                System.out.println("--------------------------------");

                ordensDeServicoEquipamentos.add(osEmAux);
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
        return ordensDeServicoEquipamentos;
    }


    //Delete
    public boolean deleteOsEquip (int numOS, String numDeSerie) {
        connectToDB();
        String sql = "DELETE FROM ordensdeserviço_has_equipamento WHERE OrdemdeServiço_numOS=? AND Equipamento_numDeSerie=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, numOS);
            pst.setString(2,numDeSerie);
            pst.execute();
            System.out.println("Linkagem de OS e Equipamento deletada do sistema");
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
