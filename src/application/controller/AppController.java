package application.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import application.model.Clinica;
import application.model.Consulta;
import application.model.Medico;
import application.model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AppController {

    @FXML
    private Button btnAlterarClinica;

    @FXML
    private Button btnAlterarConsulta;

    @FXML
    private Button btnAlterarEspecialidade;

    @FXML
    private Button btnAlterarMedico;

    @FXML
    private Button btnAtualizarPaciente;

    @FXML
    private Button btnAtualizarReceituario;

    @FXML
    private Button btnBuscarClinica;

    @FXML
    private Button btnBuscarConsulta;

    @FXML
    private Button btnBuscarEspecialidade;

    @FXML
    private Button btnBuscarMedico;

    @FXML
    private Button btnBuscarPaciente;

    @FXML
    private Button btnBuscarReceituario;

    @FXML
    private Button btnExcluirClinica;

    @FXML
    private Button btnExcluirConsulta;

    @FXML
    private Button btnExcluirEspecialidade;

    @FXML
    private Button btnExcluirMedico;

    @FXML
    private Button btnExcluirPaciente;

    @FXML
    private Button btnExcluirReceituario;

    @FXML
    private Button btnInserirClinica;

    @FXML
    private Button btnInserirConsulta;

    @FXML
    private Button btnInserirEspecialidade;

    @FXML
    private Button btnInserirMedico;

    @FXML
    private Button btnInserirPaciente;

    @FXML
    private Button btnInserirReceituario;

    @FXML
    private Button btnListarClinica;

    @FXML
    private Button btnListarConsulta;

    @FXML
    private Button btnListarEspecialidade;

    @FXML
    private Button btnListarMedico;

    @FXML
    private Button btnListarPaciente;

    @FXML
    private Button btnListarReceituario;

    @FXML
    private TextArea taListaClinica;

    @FXML
    private TextArea taListaConsulta;

    @FXML
    private TextArea taListaEspecialidade;

    @FXML
    private TextArea taListarMedicos;

    @FXML
    private TextArea taListarPaciente;

    @FXML
    private TextField tfCepClinica;

    @FXML
    private TextField tfCepMedico;

    @FXML
    private TextField tfCepPaciente;

    @FXML
    private TextField tfClinicaConsulta;

    @FXML
    private TextField tfComplClinica;

    @FXML
    private TextField tfComplMedico;

    @FXML
    private TextField tfComplePaciente;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfCrm;

    @FXML
    private TextField tfDataConsulta;

    @FXML
    private TextField tfEmailClinica;

    @FXML
    private TextField tfEmailMedico;

    @FXML
    private TextField tfEmailPaciente;

    @FXML
    private TextField tfEspecialidade;

    @FXML
    private TextField tfEspecialidadeConsulta;

    @FXML
    private TextField tfHoraConsulta;

    @FXML
    private TextField tfIdClinica;

    @FXML
    private TextField tfIdConsulta;

    @FXML
    private TextField tfIdConsultaReceituario;

    @FXML
    private TextField tfIdEspecialidade;

    @FXML
    private TextField tfIdReceituario;

    @FXML
    private TextField tfLogradouroClinica;

    @FXML
    private TextField tfLogradouroMedico;

    @FXML
    private TextField tfLogradouroPaciente;

    @FXML
    private TextField tfMedicoConsulta;

    @FXML
    private TextField tfNomeClinica;

    @FXML
    private TextField tfNomeMedico;

    @FXML
    private TextField tfNomePaciente;

    @FXML
    private TextField tfNumClinica;

    @FXML
    private TextField tfNumMedico;

    @FXML
    private TextField tfNumPaciente;

    @FXML
    private TextField tfObserConsulta;

    @FXML
    private TextField tfPacienteConsulta;

    @FXML
    private TextField tfPrescricao;

    @FXML
    private TextField tfSanguePaciente;

    @FXML
    private TextField tfTelClinica;

    @FXML
    private TextField tfTelMedico;

    @FXML
    private TextField tfTelPaciente;

    @FXML
    void acaoClinica(ActionEvent event) {
        String cmd = event.getSource().toString();
    	System.out.println(cmd);
    	
    	ClinicaController clinicaController = 
    			new ClinicaController(tfIdClinica, tfNomeClinica, tfTelClinica, tfEmailClinica, tfLogradouroClinica, 
    					tfCepClinica, tfComplClinica, tfNumClinica, taListaClinica);
    	
    	if ((cmd.contains("Inserir") || cmd.contains("Atualizar")) && 
    				(tfIdClinica.getText().isEmpty() 
    				|| tfNomeClinica.getText().isEmpty() || tfTelClinica.getText().isEmpty() 
    				|| tfEmailClinica.getText().isEmpty() || tfLogradouroClinica.getText().isEmpty() 
    				|| tfCepClinica.getText().isEmpty() || tfComplClinica.getText().isEmpty() 
    				|| tfNumClinica.getText().isEmpty())) {
    		JOptionPane.showMessageDialog(null, "Preencha os campos", "Erro", JOptionPane.ERROR_MESSAGE);
    	} else {
    		if ((cmd.contains("Excluir") || cmd.contains("Buscar") || cmd.contains("tfIdClinica") 
    				&& tfIdClinica.getText().isEmpty())) {
    		JOptionPane.showMessageDialog(null, "Preencha o cÃ³digo", "Erro", JOptionPane.ERROR_MESSAGE);
    	} else {
    		try {
    			if (cmd.contains("Listar")) {
    				clinicaController.buscarClinicas();
    			} else {
    				Clinica c = new Clinica();
    				c.setId(Integer.parseInt(tfIdClinica.getText()));
    				c.setNumEnd(Integer.parseInt(tfNumClinica.getText()));
    				c.setNome(tfNomeClinica.getText());
    				c.setTelefone(tfTelClinica.getText());
    				c.setEmail(tfEmailClinica.getText());
    				c.setLogradouro(tfLogradouroClinica.getText());
    				c.setCep(tfCepClinica.getText());
    				c.setComplemento(tfComplClinica.getText());

                    if (cmd.contains("Inserir")) {
                        clinicaController.insereClinica(c);
                    } else if (cmd.contains("Atualizar")) {
                        clinicaController.atualizaClinica(c);
                    } else if (cmd.contains("Excluir")) {
                        clinicaController.excluiClinica(c);
                    } else if (cmd.contains("Buscar")) {
                        clinicaController.consultaClinica(c);
                    } 
    			} 
    		} catch (ClassNotFoundException | SQLException e) {
    			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
    			e.printStackTrace();
    			
    		}
    	}
    	}
    }

    @FXML
    void acaoConsulta(ActionEvent event) {
        ConsultaController consultaController =
				new ConsultaController(tfIdConsulta, tfPacienteConsulta, tfMedicoConsulta, 
						tfClinicaConsulta, tfDataConsulta, tfHoraConsulta, 
						tfObserConsulta, taListaConsulta);
		
		String cmd = event.getSource().toString();
		System.out.println(cmd);
		
		if((cmd.contains("Adicionar") || cmd.contains("Atualizar")) && 
				(tfIdConsulta.getText().isEmpty()
				|| tfPacienteConsulta.getText().isEmpty()
				|| tfMedicoConsulta.getText().isEmpty()
				|| tfClinicaConsulta.getText().isEmpty()
				|| tfDataConsulta.getText().isEmpty()
				|| tfHoraConsulta.getText().isEmpty()
				|| tfObserConsulta.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
		} else {
			if ((cmd.contains("Excluir") || cmd.contains("Buscar") || cmd.contains("txtCpfPacienteConsulta") 
					|| cmd.contains("txtCrmMedicoConsulta")|| cmd.contains("txtCrmMedicoConsulta")
					|| cmd.contains("txtIdClinicaConsulta")
					&& tfIdConsulta.getText().isEmpty())){
				JOptionPane.showMessageDialog(null, "Preencha o Id", "ERRO", JOptionPane.ERROR_MESSAGE);	
			}
			else {
				try {
					if (cmd.contains("Listar")) {
						consultaController.buscarConsultas();
					} else {
						Consulta co = new Consulta();
						co.setId(Integer.parseInt(tfIdConsulta.getText()));
						co.setData((null));
						co.setHora(null);
						co.setObservacao(tfObserConsulta.getText());

						if(!tfPacienteConsulta.getText().isEmpty()){
							Paciente pa = new Paciente();
							pa.setCpf((tfPacienteConsulta.getText()));
							co.setPacienteCpf(pa);;
						}

						if(!tfMedicoConsulta.getText().isEmpty()){
							Medico me = new Medico();
							me.setCrm(tfMedicoConsulta.getText());
							//co.setMedico(me);
							
							if (!tfClinicaConsulta.getText().isEmpty()) {
								Clinica cl = new Clinica();
								cl.setId(Integer.parseInt(tfClinicaConsulta.getText()));
							}

						if (cmd.contains("Adicionar")) {
							consultaController.adicionarConsulta(co);
						} else if (cmd.contains("Atualizar")) {
							consultaController.atualizarConsulta(co);
						} else if (cmd.contains("Excluir")) {
							consultaController.excluirConsulta(co);
						} else if (cmd.contains("Buscar") || cmd.contains("txtIdConsulta")) {
							consultaController.buscarConsulta(co);
						}
					}
					}
					
				} catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		}
    }

    @FXML
    void acaoEspecialidade(ActionEvent event) {

    }

    @FXML
    void acaoMedico(ActionEvent event) {

    }

    @FXML
    void acaoPaciente(ActionEvent event) {
        String cmd = event.getSource().toString();
        System.out.println(cmd);

        PacienteController pCon = new PacienteController(tfCpf, tfNomePaciente, tfLogradouroPaciente, tfNumPaciente, tfCepPaciente, tfComplePaciente, tfTelPaciente, tfSanguePaciente, tfEmailPaciente, taListarPaciente);

        if((cmd.contains("inserir") || cmd.contains("atualizar")) && 
        (tfCpf.getText().isEmpty()
            || tfNomePaciente.getText().isEmpty()
            || tfLogradouroPaciente.getText().isEmpty()
            || tfNumPaciente.getText().isEmpty()
            || tfCepPaciente.getText().isEmpty()
            || tfComplePaciente.getText().isEmpty()
            || tfTelPaciente.getText().isEmpty()
            || tfSanguePaciente.getText().isEmpty()
            || tfEmailPaciente.getText().isEmpty())){

                JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else{
            if ((cmd.contains("Excluir") || cmd.contains("Buscar")) && tfCpf.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Preencha o CPF", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    if (cmd.contains("Listar")){
                        pCon.buscarPacientes();
                    } else{
                        Paciente p = new Paciente();
                        p.setCpf(tfCpf.getText());
                        p.setNome(tfNomePaciente.getText());
                        p.setLogradouro(tfLogradouroPaciente.getText());
                        p.setNumero(Integer.parseInt(tfNumPaciente.getText()));
                        p.setCep(tfCepPaciente.getText());
                        p.setComplemento(tfComplePaciente.getText());
                        p.setTelefone(tfTelPaciente.getText());
                        p.setTipoSanguineo(tfSanguePaciente.getText());
                        p.setEmail(tfEmailPaciente.getText());
                        if (cmd.contains("Inserir")){
                            pCon.inserirPaciente(p);
                        } else if (cmd.contains("Atualizar")){
                            pCon.atualizarPaciente(p);
                        } else if (cmd.contains("Excluir")){
                            pCon.excluirPaciente(p);
                        } else if (cmd.contains("Buscar")){
                            pCon.buscarPaciente(p);
                        }
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    void acaoReceituario(ActionEvent event) {

    }

}
