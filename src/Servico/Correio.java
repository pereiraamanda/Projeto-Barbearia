/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Model.Agendamento;

/**
 *
 * @author Amanda
 */
public class Correio {
    public void NotificarPorEmail(Agendamento agendamento){
        String emailFormatado = formatarEmail(agendamento);
        String destinatario = agendamento.getCliente().getEmail();
        
        Email email = new Email("Agendamento ", emailFormatado, destinatario);
        email.enviar();
        
    }

    private String formatarEmail(Agendamento agendamento) {
        String nomeCliente = agendamento.getCliente().getNome();
        String servico = agendamento.getServico().getDescricao();
        String dataAgendamento = agendamento.getDataFormatada();
        String horaAgendamento = agendamento.getHoraFormatada();
        Float valorAgendamento = agendamento.getValor();
        return "Olá " + nomeCliente + " seu agendamento de " + servico + " está marcado para o dia " + dataAgendamento + " às " + horaAgendamento + "hrs "+ " valor R$" + valorAgendamento + "\n\nAté lá.";
    }
}
