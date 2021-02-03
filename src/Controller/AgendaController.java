
package Controller;

import Controller.helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import Servico.Correio;
import View.Agenda;
import java.util.ArrayList;

public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela(){
        
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        
        helper.preencherTabela(agendamentos);
        
    }
    
    public void atualizaCliente(){
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        
        helper.preencherClientes(clientes);
        
    }
    
    public void atualizaServico(){
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        helper.preencherServicos(servicos);
    }
    
    public void atualizaValor(){
       Servico servico = helper.obterServico();
       helper.setarValor(servico.getValor());
    }
    
    public void agendar(){
        Agendamento agendamento = helper.obterModelo();
        new AgendamentoDAO().insert(agendamento);
        
        Correio correio = new Correio();
        correio.NotificarPorEmail(agendamento);
        
        atualizaTabela();
        helper.limparTela();
        
    }
}
