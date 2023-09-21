package gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Telas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainMenuBarController implements Initializable{
	
	private Telas loadTelas = new Telas();

	@FXML
	private MenuItem menuItemCarregarCsv;
	
	@FXML
	private MenuItem menuItemConfirmarCsv;
	
	@FXML
	private MenuItem menuItemGerenciarAluno;
	
	@FXML
	private MenuItem menuItemEditarAluno;

	@FXML
	private MenuItem menuItemNovaEntrega;
	
	@FXML
	private MenuItem menuItemSobre;
	
	
	@FXML
	public void onMenuItemCarregarCsvAction() {
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            System.out.println("Arquivo selecionado: " + selectedFile.getAbsolutePath());
        }
	}
	
	@FXML
	public void onMenuItemConfirmarCsvAction() {
		loadTelas.loadView("/gui/TelaConfirmarCsv.fxml");
	}
	
	@FXML
	public void onMenuItemGerenciarAlunoAction() {
		loadTelas.loadView("/gui/TelaGerenciarAlunos.fxml");
	}
	
	@FXML
	public void onMenuItemEditarAluno() {
		loadTelas.loadView("/gui/TelaEditarAluno.fxml");
	}
	
	@FXML
	public void onMenuItemSobreAction() {
		loadTelas.loadView("/gui/TelaSobre.fxml");
	}
	
	@FXML
	public void onMenuItemNovaEntrega() {
		loadTelas.loadView("/gui/TelaCadastrarEntregas.fxml");
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {

	}

}
