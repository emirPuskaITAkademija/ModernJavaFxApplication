package dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final int maxConnection = 10;

    private List<Connection> availableConnectionList = new ArrayList<>();
    private List<Connection> buisyConnectionList = new ArrayList<>();

    public ConnectionPool() throws SQLException {
        for (int i = 0; i < maxConnection; i++) {
            availableConnectionList.add(createConnection());
        }
    }

    private Connection createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(ConnectionEnum.URL.getValue(), ConnectionEnum.USERNAME.getValue(), ConnectionEnum.PASSWORD.getValue());
        System.out.println("Kreiram connection objekat..");
        return connection;
    }

    public Connection getConnection() {
        if (availableConnectionList.isEmpty()) {
            throw new RuntimeException("Nema dostupnih konekcija u bazenu");
        } else {
            Connection connection = availableConnectionList.get(availableConnectionList.size() - 1);
            availableConnectionList.remove(connection);
            buisyConnectionList.add(connection);
            return connection;
        }
    }

    public boolean releaseConnection(Connection connection) {
        if (null != connection) {
            buisyConnectionList.remove(connection);
            availableConnectionList.add(connection);
            return true;
        } else {
            return false;
        }
    }


}
