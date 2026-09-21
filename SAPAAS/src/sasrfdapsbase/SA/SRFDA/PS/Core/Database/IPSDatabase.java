/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import java.sql.Connection;
import java.sql.SQLException;

@PSModelIgnoreMeta
public interface IPSDatabase {
    public String getDBType();

    public Connection getConnection() throws SQLException;

    public String getDBName();

    public String getDBSchema();

    public String getDBSchemaOrName();

    public void close();

    public boolean isLocalRes();
}

