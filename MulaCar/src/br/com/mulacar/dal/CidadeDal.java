package br.com.mulacar.dal;

    
import br.com.mulacar.model.Cidade;
import br.com.mulacar.util.Conexao;
import br.com.mulacar.util.EstadosEnum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elisabete
 */
public class CidadeDal {

    private Connection conexao;

    public CidadeDal() {
        conexao = Conexao.getConexao();
    }

    public void addCidade(Cidade obj) {
        String sql = "insert into cidade(cid_nome,cid_uf) values (?,?)";
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement(sql);
            // Parameters start with 1
            preparedStatement.setString(1, obj.getNome());
            preparedStatement.setString(2, obj.getEstado().toString());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCidade(int cidadeId) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("delete from cidade where fab_iden=?");
            // Parameters start with 1
            preparedStatement.setInt(1, cidadeId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCidade(Cidade obj) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("update cidade set fab_descricao=? where fab_iden = ?");
            // Parameters start with 1
            preparedStatement.setString(1, obj.getNome());
            preparedStatement.setInt(2, obj.getIden());
  
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cidade> getAllCidades() {
        System.out.println("estou na dal");
        List<Cidade> cidades = new ArrayList<Cidade>();
        String sql = "select * from cidade";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setIden(rs.getInt("cid_iden"));
                cidade.setNome(rs.getString("cid_nome"));
                cidade.setEstado(EstadosEnum.valueOf("cid_uf"));
                cidades.add(cidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidades;
    }

    public Cidade getCidadeById(int cidadeId) {
        Cidade cidade = new Cidade();
        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from cidade where cid_iden=?");
            preparedStatement.setInt(1, cidadeId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                cidade.setIden(rs.getInt("cid_iden"));
                cidade.setNome(rs.getString("cid_nome"));
                cidade.setEstado((EstadosEnum)(rs.getObject("cid_uf")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidade;
    }
    
    public Cidade getCidadeByName(String cidadenome) {
        Cidade cidade = new Cidade();
        try {
            PreparedStatement preparedStatement = conexao.
            prepareStatement("select * from cidade where cid_nome=?");
            preparedStatement.setString(1, cidadenome);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                cidade.setIden(rs.getInt("cid_iden"));
                cidade.setNome(rs.getString("cid_nome"));
                cidade.setEstado((EstadosEnum)(rs.getObject("cid_uf")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidade;
    }
}
