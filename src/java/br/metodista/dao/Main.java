/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.metodista.dao;

import gerais.ValueByName;
import gerais.User;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ascarneiro
 */
public class Main {

    public static void main(String[] args) {
        try {
            User user = new User("root", "aloisk");
            DAO dao = new DAO(user);


//            dao.delete("pesquisa");
//            
//            ValueByName valueByName = new ValueByName();
//            valueByName.clear();
//            valueByName.put("DS_PESQUISA", "Aprovacao governo Michel Temmer");
//            valueByName.put("DT_INICIO", "2016-01-01");
//            dao.insert("pesquisa", valueByName);
//
//            valueByName.clear();
//            valueByName.put("DS_PESQUISA", "Utilizacao de dispositivos moveis");
//            valueByName.put("DT_INICIO", "2016-01-01");
//            dao.insert("pesquisa", valueByName);
//
//
//
//            valueByName.clear();
//            valueByName.put("DS_PESQUISA", "Redes Sociais");
//            valueByName.put("DT_INICIO", "2016-01-01");
//            dao.insert("pesquisa", valueByName);
//        
//            valueByName.clear();
//            valueByName.put("DS_PESQUISA", "Desarmamento");
//            valueByName.put("DT_INICIO", "2016-01-01");
//            dao.insert("pesquisa", valueByName);
//
//            valueByName.clear();
//            valueByName.put("DS_PESQUISA", "Pena de morte");
//            valueByName.put("DT_INICIO", "2016-01-01");
//            dao.insert("pesquisa", valueByName);

//
//            ValueByName valueByName = new ValueByName();
//            valueByName.clear();
//            valueByName.put("DS_QUESTAO", "Favor do governo Michel Temmer");
//            valueByName.put("NR_SEQ_PESQUISA", "11");
//            dao.insert("questao", valueByName);
//
//            valueByName.clear();
//            valueByName.put("DS_QUESTAO", "Utiliza dispositivo movel?");
//            valueByName.put("NR_SEQ_PESQUISA", "12");
//            dao.insert("questao", valueByName);
//
//            valueByName.clear();
//            valueByName.put("DS_QUESTAO", "Utiliza alguma das redes sociais abaixo?");
//            valueByName.put("NR_SEQ_PESQUISA", "13");
//            dao.insert("questao", valueByName);
//
//            valueByName.clear();
//            valueByName.put("DS_QUESTAO", "Favor do desarmamento no Brasil?");
//            valueByName.put("NR_SEQ_PESQUISA", "14");
//            dao.insert("questao", valueByName);
//
//            valueByName.clear();
//            valueByName.put("DS_QUESTAO", "Favor a pena de morte?");
//            valueByName.put("NR_SEQ_PESQUISA", "15");
//            dao.insert("questao", valueByName);


//            ValueByName valueByName = new ValueByName();
//            valueByName.put("DS_ALTERNATIVA", "Sim");
//            dao.insert("alternativa", valueByName);
//            
//            valueByName.clear();
//            valueByName.put("DS_ALTERNATIVA", "Nao");
//            dao.insert("alternativa", valueByName);
//
//            valueByName.clear();
//            valueByName.put("DS_ALTERNATIVA", "Facebook");
//            dao.insert("alternativa", valueByName);
//
//            valueByName.clear();
//            valueByName.put("DS_ALTERNATIVA", "G+");
//            dao.insert("alternativa", valueByName);
//            
//            valueByName.clear();
//            valueByName.put("DS_ALTERNATIVA", "Linkedin");
//            dao.insert("alternativa", valueByName);
//
//            valueByName.clear();
//            valueByName.put("DS_ALTERNATIVA", "Outras");
//            dao.insert("alternativa", valueByName);

//            ValueByName valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_QUESTAO", "1");
//            valueByName.put("NR_SEQ_ALTERNATIVA", "1");
//            dao.insert("alternativa_questao", valueByName);
//
//            valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_QUESTAO", "1");
//            valueByName.put("NR_SEQ_ALTERNATIVA", "2");
//            dao.insert("alternativa_questao", valueByName);
//
//
//
//            valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_QUESTAO", "2");
//            valueByName.put("NR_SEQ_ALTERNATIVA", "1");
//            dao.insert("alternativa_questao", valueByName);
//
//            valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_QUESTAO", "2");
//            valueByName.put("NR_SEQ_ALTERNATIVA", "2");
//            dao.insert("alternativa_questao", valueByName);
//
//
//            valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_QUESTAO", "4");
//            valueByName.put("NR_SEQ_ALTERNATIVA", "1");
//            dao.insert("alternativa_questao", valueByName);
//
//            valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_QUESTAO", "4");
//            valueByName.put("NR_SEQ_ALTERNATIVA", "2");
//            dao.insert("alternativa_questao", valueByName);
//
//
//            valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_QUESTAO", "5");
//            valueByName.put("NR_SEQ_ALTERNATIVA", "1");
//            dao.insert("alternativa_questao", valueByName);
//
//            valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_QUESTAO", "5");
//            valueByName.put("NR_SEQ_ALTERNATIVA", "2");
//            dao.insert("alternativa_questao", valueByName);



//            valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_QUESTAO", "3");
//            valueByName.put("NR_SEQ_ALTERNATIVA", "3");
//            dao.insert("alternativa_questao", valueByName);
//
//            valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_QUESTAO", "3");
//            valueByName.put("NR_SEQ_ALTERNATIVA", "4");
//            dao.insert("alternativa_questao", valueByName);
//
//
//            valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_QUESTAO", "3");
//            valueByName.put("NR_SEQ_ALTERNATIVA", "5");
//            dao.insert("alternativa_questao", valueByName);
//
//
//            valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_QUESTAO", "3");
//            valueByName.put("NR_SEQ_ALTERNATIVA", "6");
//            dao.insert("alternativa_questao", valueByName);

            ValueByName valueByName = new ValueByName();
//            valueByName.put("DS_QUESTAO", "Acessa pelo menos uma vez de manh? e ma a tarde todos os dias?");
//            valueByName.put("NR_SEQ_PESQUISA", "13");
//            dao.insert("questao", valueByName);
//            

            valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_QUESTAO", "6");
//            valueByName.put("NR_SEQ_ALTERNATIVA", "1");
//            dao.insert("alternativa_questao", valueByName);
//
//            valueByName = new ValueByName();
//            valueByName.put("NR_SEQ_QUESTAO", "6");
//            valueByName.put("NR_SEQ_ALTERNATIVA", "2");
//            dao.insert("alternativa_questao", valueByName);


            
            //Descomentar
           /* valueByName.clear();
            valueByName.put("DS_PESQUISA", "Governo Lula");
            valueByName.put("DT_INICIO", "2016-01-01");
            dao.insert("pesquisa", valueByName);


            valueByName.clear();
            valueByName.put("DS_QUESTAO", "Caso Lula se cadidatasse a presidencia voce votaria nele?");
            valueByName.put("NR_SEQ_PESQUISA", "16");
            dao.insert("questao", valueByName);

            valueByName.put("NR_SEQ_QUESTAO", "7");
            valueByName.put("NR_SEQ_ALTERNATIVA", "1");
            dao.insert("alternativa_questao", valueByName);

            valueByName = new ValueByName();
            valueByName.put("NR_SEQ_QUESTAO", "7");
            valueByName.put("NR_SEQ_ALTERNATIVA", "2");
            dao.insert("alternativa_questao", valueByName);

            
            valueByName.clear();
            valueByName.put("DS_QUESTAO", "Votaria caso fosse outro candidato do partido PT?");
            valueByName.put("NR_SEQ_PESQUISA", "17");
            dao.insert("questao", valueByName);

            valueByName.put("NR_SEQ_QUESTAO", "8");
            valueByName.put("NR_SEQ_ALTERNATIVA", "1");
            dao.insert("alternativa_questao", valueByName);

            valueByName = new ValueByName();
            valueByName.put("NR_SEQ_QUESTAO", "8");
            valueByName.put("NR_SEQ_ALTERNATIVA", "2");
            dao.insert("alternativa_questao", valueByName);*/
            


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
