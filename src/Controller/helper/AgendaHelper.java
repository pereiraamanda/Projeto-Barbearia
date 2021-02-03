/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amanda
 */
public class AgendaHelper implements IHelper {
    
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

 

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableDados().getModel();
        tableModel.setNumRows(0);
        for (Agendamento agendamento : agendamentos) {
            tableModel.addRow(new Object[]{
               agendamento.getId(),
               agendamento.getCliente().getNome(),
               agendamento.getServico().getDescricao(),
               agendamento.getValor(),
               agendamento.getDataFormatada(),
               agendamento.getHoraFormatada(),
               agendamento.getObservacao()
            });
            
            
        }
    }

    public void preencherClientes(ArrayList<Cliente> clientes) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboCliente().getModel();
        
        for (Cliente cliente : clientes) {
            comboBoxModel.addElement(cliente);
        }
    }

    public void preencherServicos(ArrayList<Servico> servicos) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboServico().getModel();
        
        for (Servico servico : servicos) {
            comboBoxModel.addElement(servico);
            
        }
    }
     public Cliente obterCliente() {
        return (Cliente) view.getjComboCliente().getSelectedItem();
    }
     
    public Servico obterServico() {
        return (Servico) view.getjComboServico().getSelectedItem();
    }

    public void setarValor(float valor) {
        view.getjTextValor().setText(valor + "");
    }

    @Override
    public Agendamento obterModelo() {
        
        String idString = view.getjTextId().getText();
        int id = Integer.parseInt(idString);
        Cliente cliente = obterCliente();
        
        Servico servico = obterServico();
        
        String valorString = view.getjTextValor().getText();
        float valor = Float.parseFloat(valorString);
        
        String data = view.getjTextData().getText();
        String hora = view.getjTextHora().getText();
        String dataHora = data + " " + hora;
        
        String observacao = view.getjTextAObservacao().getText();
        
        Agendamento agendamento = new Agendamento(id, cliente, servico, valor, dataHora, observacao);
        
        return agendamento;
                
    }

    @Override
    public void limparTela() {
        view.getjTextId().setText("0");
        view.getjTextData().setText("");
        view.getjTextHora().setText("");
        view.getjTextAObservacao().setText("");
        
    }
    
 

 

    
    
   
}
