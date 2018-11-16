package fr.rennes.database.Entity;

import java.util.ArrayList;

import fr.rennes.database.Contrat.SQLContrat;

public class Field extends Composite {
    boolean isFirst;

    public Field()
    {
        composites = new ArrayList<Composite>();
        this.builder = this;
    }

    public Field (Composite builder)
    {
        composites = new ArrayList<Composite>();
        this.builder = builder;
    }

    public Field addCol(String columnName, String type)
    {
        this.builder.request += (this.builder.isFirst ? " ( " : " , ");

        this.builder.request += columnName + " " + type;

        this.builder.isFirst = false;
        Field next = new Field(this.builder);
        composites.add(next);
        return next;
    }

    public Field addCol(String columnName, Type type)
    {
        SQLiteType sqLiteType = null;

        if (type == Type.STRING || type == Type.CHAR )
        {
            sqLiteType = SQLiteType.TEXT;
        }
        else if (type == Type.INT )
        {
            sqLiteType = SQLiteType.INTEGER;
        }
        else if (type == Type.DATE || type == Type.DATETIME )
        {
            sqLiteType = SQLiteType.DATETIME;
        }
        else if (type == Type.FLOAT || type == Type.DOUBLE )
        {
            sqLiteType = SQLiteType.REAL;
        }
        else if (type == Type.BLOB )
        {
            sqLiteType = SQLiteType.BLOB;
        }
        else if (type == Type.BOOL || type == Type.BOOLEAN )
        {
            sqLiteType = SQLiteType.NUMERIC;
        }

        return this.addCol(columnName, sqLiteType);
    }

    public Field addCol(String columnName, SQLiteType type)
    {
        String colType = "";

        this.builder.request += (this.builder.isFirst ? " ( " : " , ");

        this.builder.request += columnName;

        switch (type)
        {
            case BLOB:
                colType += SQLContrat.COL_TYPE_BLOB;
                break;
            case REAL:
                colType += SQLContrat.COL_TYPE_REAL;
                break;
            case TEXT:
                colType += SQLContrat.COL_TYPE_TEXT;
                break;
            case INTEGER:
                colType += SQLContrat.COL_TYPE_INTEGER;
                break;
            case NUMERIC:
                colType += SQLContrat.COL_TYPE_NUMERIC;
                break;
            case DATETIME:
                colType += SQLContrat.COL_TYPE_DATE;
                break;
            default:
        }

        this.builder.request += colType;

        this.builder.isFirst = false;
        Field next = new Field(this.builder);
        composites.add(next);
        return next;
    }

    /* PRIMARY */
    public Field addColKey(String columnName)
    {
        this.builder.request += (this.builder.isFirst ? " ( " : " , ");

        this.builder.request += columnName + SQLContrat.PRIMARY_KEY;

        this.builder.isFirst = false;
        Field next = new Field(this.builder);
        composites.add(next);
        return next;
    }

    @Override
    public String end() {

        this.builder.request += (isFirst ? "" : " ) ");
        return super.end();
    }
}
