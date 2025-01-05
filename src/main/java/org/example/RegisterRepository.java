package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegisterRepository {
    private Connection connection;
    public RegisterRepository() {
        connection = ConnectionFactory.getConnection();
    }
    public void save(Register register){
        try {
            String insertSql = "INSERT INTO public.tab_cadastro (\"name\", age) VALUES(?,?);";
            PreparedStatement pst = connection.prepareStatement(insertSql);
            pst.setString(1, register.getName());
            pst.setInt(2, register.getAge());
            pst.execute();
            System.out.println("insercao realizada com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public void update(Register register){
        try {
            String updateSql = "UPDATE public.tab_cadastro SET \"name\"=?, age=? WHERE id=?;";
            PreparedStatement pst = connection.prepareStatement(updateSql);
            pst.setString(1, register.getName());
            pst.setInt(2, register.getAge());
            pst.setInt(3, register.getId());
            pst.executeUpdate();
            System.out.println("update realizado com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void remove(Integer id){
        try {
            String removeSql = "DELETE FROM public.tab_cadastro WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(removeSql);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Registro deletado com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public List<Register> list(){
        List<Register> list = new ArrayList<>();
        try {
            String selectSql = "SELECT id, name, age FROM public.tab_cadastro";
            PreparedStatement pst = connection.prepareStatement(selectSql);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                Integer resultId = result.getInt("id");
                String resultName = result.getString("name");
                Integer resultAge = result.getInt("age");

                Register register = new Register();
                register.setName(resultName);
                register.setAge(resultAge);
                register.setId(resultId);

                list.add(register);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }
    public Register search(Integer id){
        Register register = null;
        try {
            String searchSql = "SELECT id, \"name\", age FROM public.tab_cadastro WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(searchSql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            if(result.next()) {
                Integer resultId = result.getInt("id");
                String resultName = result.getString("name");
                Integer resultAge = result.getInt("age");

                register = new Register();
                register.setName(resultName);
                register.setAge(resultAge);
                register.setId(resultId);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return register;
    }

}
