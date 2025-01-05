package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class JDBCPostgres {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "postgres");
            props.setProperty("ssl", "false");
            Connection conn = DriverManager.getConnection(url, props);
            System.out.println("conexao realizada com sucesso" + conn);

            String insertSql = "INSERT INTO public.tab_cadastro (\"name\", age) VALUES(?,?);";
            String name = "Giovana Passeti";
            Integer age = 24;
            PreparedStatement pst = conn.prepareStatement(insertSql);
            pst.setString(1, name);
            pst.setInt(2, age);

            pst.execute();
            System.out.println("insercao realizada com sucesso");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
