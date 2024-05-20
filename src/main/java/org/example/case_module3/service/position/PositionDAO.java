package org.example.case_module3.service.position;

import org.example.case_module3.model.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO implements IPositionDAO{
    private final String jdbsName = "root";
    private final String jdbcPassword = "admin123456";
    private final String jdbcURL = "jdbc:mysql://localhost:3306/EmployeeManagement";
    private static final String SELECT_ALL = "select * from Positions;";
    public PositionDAO(){}
    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(jdbcURL,jdbsName,jdbcPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    @Override
    public List<Position> findAll() {
        List<Position> positionList = new ArrayList<>();
        Connection connection = getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("position_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                positionList.add(new Position(id,name,description));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return positionList;
    }

    @Override
    public Position selectById(int id) {
        return null;
    }

    @Override
    public void insert(Position ob) throws SQLException {

    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateById(Position ob) throws SQLException {
        return false;
    }
}
