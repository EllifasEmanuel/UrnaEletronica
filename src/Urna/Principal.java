package Urna;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Principal {

	public static void main(String[] args) {
		
		List<Candidato> candidatos = new ArrayList<Candidato>();
		JLabel labelNome = new JLabel("Nome");
		JTextField nome = new JTextField();
		JPanel divNome = new JPanel();
		JLabel labelNumero = new JLabel("Numero");
		JTextField numero = new JTextField();
		JPanel divNumero = new JPanel();
		JFrame janela = new JFrame("Cadastrar candidato");
		JPanel container = new JPanel();
		JButton confirmar = new JButton("Enviar");
		JButton iniciarVotacao = new JButton("Iniciar Eleicao");
		JPanel divBotoes = new JPanel();
		Boolean sair;
		
		JFrame janela2 = new JFrame("Eleicao");
		JPanel divEleicao = new JPanel();
		JPanel container2 = new JPanel();
		JLabel labelNumero2 = new JLabel("Numero");
		JLabel labelNomePesquisado = new JLabel("");
		JButton encerrar = new JButton("Encerrar");
		JButton pesquisar = new JButton("Pesquisar");
		JButton votar = new JButton("Votar");
		JPanel divBotoes2 = new JPanel();
		JTextField numero2 = new JTextField();
		int qtdCadastrada = 0;
		
		numero2.setEditable(true);
		container2.add(labelNomePesquisado);
		divEleicao.add(labelNumero2);
		divEleicao.add(numero2);
		divEleicao.add(pesquisar);
		divEleicao.setLayout(new BoxLayout(divEleicao, BoxLayout.X_AXIS));
		divBotoes2.add(votar);
		divBotoes2.add(encerrar);
		divBotoes2.setLayout(new BoxLayout(divBotoes2, BoxLayout.X_AXIS));
		container2.add(divEleicao);
		container2.add(divBotoes2);
		container2.setPreferredSize(new Dimension(400,400));
		container2.setLayout(new BoxLayout(container2, BoxLayout.Y_AXIS));
		janela2.setSize(300, 120);
		janela2.setContentPane(container2);
		
		
		nome.setEditable(true);
		divNome.add(labelNome);
		divNome.add(nome);
		//set bounds
		divNome.setPreferredSize(new Dimension(400,75));
		divNome.setLayout(new BoxLayout(divNome, BoxLayout.X_AXIS));
		container.add(divNome);
		
		numero.setEditable(true);
		divNumero.add(labelNumero);
		divNumero.add(numero);
		//set bounds
		divNumero.setPreferredSize(new Dimension(400,75));
		divNumero.setLayout(new BoxLayout(divNumero, BoxLayout.X_AXIS));
		container.add(divNumero);
		
		container.setPreferredSize(new Dimension(400,400));
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		confirmar.addActionListener(new ActionListener(){ 
			@Override 
		    public void actionPerformed(ActionEvent e){  
				String nomeText;
				String numeroText;
				Candidato novo = new Candidato();
				
				nomeText = nome.getText();
				numeroText = numero.getText();
				
				novo.setNome(nomeText);
				novo.setNumero(Integer.parseInt(numeroText));
				
				candidatos.add(novo);
				
				nome.setText("");
				numero.setText("");
				
		    }

		});  
		iniciarVotacao.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	janela.setVisible(false);
		    	janela2.setVisible(true);
		    }  
		});
		
		votar.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	for(Candidato temp: candidatos) {
					if(temp.getNumero() == Integer.parseInt(numero2.getText())) {
						temp.votar();
					}
				}
				labelNomePesquisado.setText("");
				numero2.setText("");
		    	
		    }  
		});
		
		encerrar.addActionListener(new ActionListener(){ 
			@Override 
		    public void actionPerformed(ActionEvent e){  
		    	janela2.setVisible(false);
		    	for(Candidato temp: candidatos) {
					System.out.println("Nome: "+temp.getNome()+" Votos: "+temp.getVotos());
				}
				
		    }

		});  
		pesquisar.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	for(Candidato temp: candidatos) {
					if(temp.getNumero() == Integer.parseInt(numero2.getText())) {
						labelNomePesquisado.setText(temp.getNome());
					}
				}
		    }  
		});
		
		divBotoes.add(confirmar);
		divBotoes.add(iniciarVotacao);
		divBotoes.setPreferredSize(new Dimension(400,75));
		divBotoes.setLayout(new BoxLayout(divBotoes, BoxLayout.X_AXIS));
		
		
		container.add(divBotoes);
		janela.setSize(400, 200);
		janela.setContentPane(container);
		
		janela.setVisible(true);
		
		
	}

}
