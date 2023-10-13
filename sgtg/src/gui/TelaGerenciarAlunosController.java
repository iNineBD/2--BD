package gui;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;


import dto.GerenciarAlunoDTO;
import gui.util.LoadGerenciarAlunos;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaGerenciarAlunosController implements Initializable {

	private LoadGerenciarAlunos loadAluno;

	@FXML
	private TableView<GerenciarAlunoDTO> tableViewGerenciarAluno;
	@FXML
	private TableColumn<GerenciarAlunoDTO, String> tableColumnNome;
	@FXML
	private TableColumn<GerenciarAlunoDTO, String> tableColumnOrientador;
	@FXML
	private TableColumn<GerenciarAlunoDTO, String> tableColumnTurma;
	@FXML
	private TableColumn<GerenciarAlunoDTO, String> tableColumnTipoTG;
	@FXML
	private TableColumn<GerenciarAlunoDTO, String> tableColumnEntregas;
	@FXML
	private TableColumn<GerenciarAlunoDTO, GerenciarAlunoDTO> tableColumnEDIT;
	@FXML
	private TableColumn<GerenciarAlunoDTO, GerenciarAlunoDTO> tableColumnFEEDBACK;

	private ObservableList<GerenciarAlunoDTO> obsList;

	public void setLoadAluno(LoadGerenciarAlunos loadAluno) {
		this.loadAluno = loadAluno;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		initializeNodes();
		
	}

	private void initializeNodes() {
		// TODO Auto-generated method stub
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome_aluno"));
		tableColumnOrientador.setCellValueFactory(new PropertyValueFactory<>("nome_orientador"));
		tableColumnTurma.setCellValueFactory(new PropertyValueFactory<>("nome_turma"));
		tableColumnTipoTG.setCellValueFactory(new PropertyValueFactory<>("tipo_tg"));
		tableColumnEntregas.setCellValueFactory(new PropertyValueFactory<>("entregas_format"));
	}

	public void updateTableView() throws SQLException {
		if (loadAluno == null) {
			throw new IllegalStateException("Serviço gerenciar aluno fora do ar");
		}
		List<GerenciarAlunoDTO> listaAlunos = loadAluno.atualizarDados();
		obsList = FXCollections.observableArrayList(listaAlunos);

		tableViewGerenciarAluno.setItems(obsList);
		
		initEditButtons();
	}

	private void initEditButtons() {
		tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEDIT.setCellFactory(param -> new TableCell<GerenciarAlunoDTO, GerenciarAlunoDTO>() {
			private final Button button = new Button("edit");

			@Override
			protected void updateItem(GerenciarAlunoDTO obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(
						event -> System.out.println(obj.getNome_aluno()));
			}
		});
		
		tableColumnFEEDBACK.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnFEEDBACK.setCellFactory(param -> new TableCell<GerenciarAlunoDTO, GerenciarAlunoDTO>() {
			private final Button button = new Button("feedback");

			@Override
			protected void updateItem(GerenciarAlunoDTO obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(
						event -> System.out.println(obj.getNome_aluno()));
			}
		});
	}

}
