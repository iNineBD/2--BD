package gui.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import conexao.DB;
import dto.EntregasDTO;

public class LoadEntregas {
	
	public List<EntregasDTO> atualizarDados(int id_turma_selecionada) throws SQLException{
		
		List<EntregasDTO> entregas = new ArrayList<EntregasDTO>();
		
		Connection conn = DB.getConnection();		
		
		PreparedStatement st = conn.prepareStatement("select id, titulo_entrega, data_entrega, descricao from entrega where id_turma = ?");
		st.setInt(1, id_turma_selecionada);
		
		ResultSet result = st.executeQuery();
		
		while (result.next()) {
			
			int id_entrega = result.getInt("id");
			String titulo = result.getString("titulo_entrega");
			String descricao = result.getString("descricao");
			Date data= result.getDate("data_entrega");
			
			entregas.add(new EntregasDTO(id_entrega, titulo, descricao, data.toLocalDate()));
		}
		
		return entregas;
		
	}

}