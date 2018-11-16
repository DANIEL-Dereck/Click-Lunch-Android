package fr.rennes.database.Contrat;

/**
 * Contract of database transaction.
 */
public class SQLContrat {
    public static final String CREATE_TABLE = "CREATE TABLE ";
    public static final String DROP_TABLE = "DROP TABLE ";

    public static final String SELECT = "SELECT ";
    public static final String UPDATE = "UPDATE ";
    public static final String INSERT = "INSERT ";
    public static final String DELETE = "DELETE ";

    public static final String FROM = " FROM ";
    public static final String WHERE = " WHERE ";
    public static final String SET = " SET ";
    public static final String INTO = " INTO ";
    public static final String LIKE = " LIKE ";
    public static final String AND = " AND ";
    public static final String OR = " OR ";
    public static final String GROUPBY = " GROUP BY ";
    public static final String ORDERBY = " ORDER BY ";
    
    public static final String PRIMARY_KEY = " INTEGER PRIMARY KEY AUTOINCREMENT ";
    public static final String COL_TYPE_TEXT = " TEXT ";
    public static final String COL_TYPE_INTEGER = " INTEGER ";
    public static final String COL_TYPE_DATE =  " DATETIME ";
    public static final String COL_TYPE_REAL = " REAL ";
    public static final String COL_TYPE_BLOB = " BLOB ";
    public static final String COL_TYPE_NUMERIC = " NUMERIC ";

    public static final String NULL = " NULL ";
    public static final String NOT_NULL = " NOT NULL ";
    public static final String IF_EXIST = " IF EXISTS ";

    public static final String ASIGN = " = ";
    public static final String EQUALS = " == ";
    public static final String LT = " < ";
    public static final String LE = " <= ";
    public static final String HT = " > ";
    public static final String HE = " >= ";
    public static final String DIFF = " != ";
    public static final String BLANK = "";
    public static final String SPACE = " ";
    public static final String IN = " IN ";
    public static final String NOT_IN = " NOT IN ";
    public static final String BETWEEN = " BETWEEN ";
    public static final String IS = " IS ";
    public static final String IS_NOT = " IS NOT ";
}
