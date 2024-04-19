package DAO;

import Models.Equipamento;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class EquipamentoDAO extends ConnectionDAO{
    boolean sucesso = false;

    public boolean insertEquipamento(Equipamento equipamento){
        connectToDB();

        //Insert
        String sql = "INSERT INTO Equipamentos (numDeSerie, TipodeEquipamento, Fabricante, Estado, Setor_IdSetor) VALUES(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,equipamento.getNumDeSerie());
            pst.setString(2,equipamento.getTipoDeEquipamento());
            pst.setString(3,equipamento.getFabricante());
            pst.setString(4,equipamento.getEstado());
            pst.setInt(5,equipamento.getSetor_idSetor());
            pst.execute();
            System.out.println("EQUIPAMENTO CADASTRADO!");
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

    //Update
    public boolean updateEquipamentoEstado(String numDeSerie, String estado) {
        connectToDB();
        String sql = "UPDATE Equipamentos SET Estado=? where numDeSerie=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, estado);
            pst.setString(2, numDeSerie);
            pst.execute();
            System.out.println("Alteração efetuada!");
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
    public boolean deleteEquipamento(String numDeSerie) {
        connectToDB();
        String sql = "DELETE FROM Equipamentos where numDeSerie=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, numDeSerie);
            pst.execute();
            System.out.println("Equipamento removido do Sistema");
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
    public ArrayList<Equipamento> selectEquipamento(){
        ArrayList<Equipamento> equipamentos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Equipamentos";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Equipamentos: ");

            while (rs.next()) {

                Equipamento equipAux = new Equipamento(rs.getString("numDeSerie"), rs.getString("TipoDeEquipamento"), rs.getString("Fabricante"), rs.getString("Estado"),rs.getInt("Setor_IdSetor"));

                System.out.println("Tipo de Equipamento: " + equipAux.getTipoDeEquipamento());
                System.out.println("Fabricante: " + equipAux.getFabricante());
                System.out.println("Número de Série: " + equipAux.getNumDeSerie());
                System.out.println("Estado: " + equipAux.getEstado());
                System.out.println("Código do Setor: " + equipAux.getSetor_idSetor());
                System.out.println("--------------------------------");

                equipamentos.add(equipAux);
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
        return equipamentos;
    }
}
