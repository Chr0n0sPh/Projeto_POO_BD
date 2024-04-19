package DAO;

import Models.Setor;

import java.sql.SQLException;
import java.util.ArrayList;

public class SetorDAO extends ConnectionDAO{
    private boolean sucesso;

    //insert
    public boolean insertSetor(Setor setor){
        connectToDB();

        String sql = "INSERT INTO Setores (IdSetor,nomeSetor,Criticidade)VALUES(?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,setor.getIdSetor());
            pst.setString(2,setor.getNomeSetor());
            pst.setString(3,setor.getCriticidade());
            pst.execute();
            System.out.println("SETOR CADASTRADO COM SUCESSO!");
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
    public boolean updateSetorCriticidade(int idSetor, String criticidade) {
        connectToDB();
        String sql = "UPDATE Setores SET Criticidade=? where IdSetor=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, criticidade);
            pst.setInt(2, idSetor);
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
    public ArrayList<Setor> selectSetor(){
        ArrayList<Setor> setores = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Setores";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Setores: ");

            while (rs.next()) {

                Setor setorAux = new Setor(rs.getInt("IdSetor"), rs.getString("nomeSetor"), rs.getString("Criticidade"));

                System.out.println("Código de Cadastro: " + setorAux.getIdSetor());
                System.out.println("Nome do Setor: " + setorAux.getNomeSetor());
                System.out.println("Criticidade: " + setorAux.getCriticidade());
                System.out.println("--------------------------------");

                setores.add(setorAux);
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
        return setores;
    }

    //Delete
    public boolean deleteSetor (int idSetor) {
        connectToDB();
        String sql = "DELETE FROM Setores where IdSetor=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idSetor);
            pst.execute();
            System.out.println("Setor removido do Sistema");
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
