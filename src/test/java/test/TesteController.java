/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import controller.AtendimentoController;
import java.util.Date;
import java.util.List;
import model.AtendimentoModel;
import org.junit.Test;

/**
 *
 * @author Carolina
 */
public class TesteController {
    
    @Test
    public void testeControllerInsert(){
        
        AtendimentoModel atendimentoModel = new AtendimentoModel();
        atendimentoModel.setNome("TEST " + new Date());
        atendimentoModel.setData(new Date());
    
        AtendimentoController atendimentoController = new AtendimentoController();
    
        atendimentoController.save(atendimentoModel);
        
        Integer cod = atendimentoModel.getId();
        if(cod != null){
            System.out.println("Registro inserido " + atendimentoModel.toString());
        } else {
            System.out.println("Falha ao inserir o registro");
        }
    }
    
    @Test
    public void testGetAll(){
          
        AtendimentoController atendimentoController = new AtendimentoController();
    
        List<AtendimentoModel> atendimentoModels = atendimentoController.getAll();
        
        for (AtendimentoModel atendimentoModel : atendimentoModels) {
           System.out.println("ok" + atendimentoModel.toString());
        }
    }
    
    @Test
    public void testeGetFirst() {
        
        AtendimentoController atendimentoController = new AtendimentoController();
        
        AtendimentoModel atendimentoModel = atendimentoController.getFirst();
        
         System.out.println("ok" + atendimentoModel.toString());
    }

    @Test
    public void testeGetNextList() {
        
        AtendimentoController atendimentoController = new AtendimentoController();
        
        List<AtendimentoModel> atendimentoModels = atendimentoController.getNextList();
        
        for (AtendimentoModel atendimentoModel : atendimentoModels) {
            System.out.println("ok" + atendimentoModel.toString());
        }
    }

    @Test
    public void testeGetChamadoList() {  
        AtendimentoController atendimentoController = new AtendimentoController();
    
        List<AtendimentoModel> atendimentoModels = atendimentoController.getChamadosList();
        
        for (AtendimentoModel atendimentoModel : atendimentoModels) {
           System.out.println("ok" + atendimentoModel.toString());
        }

    }

    @Test
    public void testeGetChamado() {
        AtendimentoController atendimentoController = new AtendimentoController();
        
        AtendimentoModel atendimentoModel = atendimentoController.getChamado();
        
         System.out.println("ok" + atendimentoModel.toString());
    }

    @Test
    public void testeUpdateJaAtendido() {
        
        AtendimentoModel atendimentoModel = new AtendimentoModel();
        
        AtendimentoController atendimentoController = new AtendimentoController();
    
        atendimentoController.updateJaAtendido();
        atendimentoModel.setStatus(2);
         
        System.out.println("ok" + atendimentoModel.toString());
        
    }

    @Test
    public void testeUpdate() {
        
        AtendimentoModel atendimentoModel = new AtendimentoModel();
        atendimentoModel.setAtendimento(new Date());
        atendimentoModel.setNome("teste");  
        atendimentoModel.setStatus(1);
        atendimentoModel.setData(new Date());
        
        AtendimentoController atendimentoController = new AtendimentoController();
                
        atendimentoController.update(atendimentoModel);
        
        System.out.println("ok" + atendimentoModel.toString());
    }

}
