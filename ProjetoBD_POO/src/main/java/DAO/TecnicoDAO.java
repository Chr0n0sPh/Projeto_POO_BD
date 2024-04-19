package DAO;

import Models.Setor;
import Models.Tecnico;

import java.sql.SQLException;
import java.util.ArrayList;

public class TecnicoDAO extends ConnectionDAO{
    private boolean sucesso;

    //insert
    public boolean insertTecnico(Tecnico tecnico){
        connectToDB();

        String sql = "INSERT INTO Tecnicos (idTecnico,Nome,Cargo,telefone,Setor_IdSetor)VALUES(?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,tecnico.getIdTecnico());
            pst.setString(2,tecnico.getNome());
            pst.setString(3,tecnico.getCargo());
            pst.setString(4,tecnico.getTelefone());
            pst.setInt(5,tecnico.getSetorIdSetor());
            pst.execute();
            System.out.println("TÉCNICO CADASTRADO COM SUCESSO!");
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
    public boolean updateTecnicoCargo(int idTecnico, String cargo) {
        connectToDB();
        String sql = "UPDATE Tecnicos SET Cargo=? where idTecnico=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cargo);
            pst.setInt(2, idTecnico);
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

    //Select
    public ArrayList<Tecnico> selectTecnicos(){
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Tecnicos";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Tecnicos: ");

            while (rs.next()) {

                Tecnico tecnicoAux = new Tecnico(rs.getInt("idTecnico"), rs.getString("Nome"), rs.getString("Cargo"),rs.getString("telefone"),rs.getInt("Setor_IdSetor"));

                System.out.println("Código de Cadastro: " + tecnicoAux.getIdTecnico());
                System.out.println("Nome: " + tecnicoAux.getNome());
                System.out.println("Cargo: " + tecnicoAux.getCargo());
                System.out.println("Telefone: " + tecnicoAux.getTelefone());
                System.out.println("Código do Setor Responsável: " +tecnicoAux.getSetorIdSetor());
                System.out.println("--------------------------------");

                tecnicos.add(tecnicoAux);
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
        return tecnicos;
    }

    //Delete
    public boolean deleteTecnico (int idTecnico) {
        connectToDB();
        String sql = "DELETE FROM Tecnicos where idTecnico=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idTecnico);
            pst.execute();
            System.out.println("Técnico removido do Sistema");
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
