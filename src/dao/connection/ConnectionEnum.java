package dao.connection;

public enum ConnectionEnum {

    URL("jdbc:mysql://localhost:3306/movies?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"),
    USERNAME("root"),
    PASSWORD("Admin123!");

    private String value;

    private ConnectionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}