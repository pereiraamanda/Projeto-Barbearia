
package View;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;


public class Main {
    
    public static void main(String[] args) {
        
        Servico servico = new Servico(1, "barba", 30);
        System.out.println(servico.getDescricao());
        System.out.println(servico.getValor());
        
        Cliente cliente = new Cliente(1, "Amanda", "Rua Céu", "00000-000");
        System.out.println(cliente.getNome());
        
        Usuario usuario = new Usuario("senha", 1, "barbeiro");
        System.out.println(usuario.getNome());
        
        Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "31/02/2021 09:00");
        System.out.println(agendamento.getCliente().getNome());
    }
}
