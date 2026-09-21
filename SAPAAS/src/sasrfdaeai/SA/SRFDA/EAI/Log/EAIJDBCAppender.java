/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  MuleContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  org.apache.log4j.jdbc.JDBCAppender
 *  org.apache.log4j.spi.LoggingEvent
 */
package SA.SRFDA.EAI.Log;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import org.apache.log4j.jdbc.JDBCAppender;
import org.apache.log4j.spi.LoggingEvent;

public class EAIJDBCAppender
extends JDBCAppender {
    protected MuleContext muleContext;
    protected String strSystemId;
    protected String strServiceId;
    protected String strDSN;
    protected String strSQL;
    protected int nBufferSize;
    protected Vector<BaseDataEntity> list;
    protected String strLastInfo;
    protected String strLogger;
    protected long nLastTime;

    public EAIJDBCAppender() {
        throw new Error("Unresolved compilation problems: \n\tThe import org.enhydra cannot be resolved\n\tThe import org.mule cannot be resolved\n\tThe import org.mule cannot be resolved\n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tMuleServer cannot be resolved\n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tMuleServer cannot be resolved\n\tMuleContext cannot be resolved to a type\n\tStandardDataSource cannot be resolved to a type\n\tStandardDataSource cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n");
    }

    public String getSystemId() {
        throw new Error("Unresolved compilation problems: \n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tMuleServer cannot be resolved\n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n");
    }

    public String getDSN() {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void setSystemId(String string) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void setDSN(String string) {
        throw new Error("Unresolved compilation problem: \n");
    }

    protected void closeConnection(Connection connection) {
        throw new Error("Unresolved compilation problem: \n");
    }

    protected Connection getConnection() throws SQLException {
        throw new Error("Unresolved compilation problems: \n\tMuleContext cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n\tMuleServer cannot be resolved\n\tMuleContext cannot be resolved to a type\n\tStandardDataSource cannot be resolved to a type\n\tStandardDataSource cannot be resolved to a type\n\tMuleContext cannot be resolved to a type\n");
    }

    protected String getLogStatement(LoggingEvent loggingEvent) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void append(LoggingEvent loggingEvent) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void flushBuffer() {
        throw new Error("Unresolved compilation problem: \n");
    }

    public int getBufferSize() {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void setBufferSize(int n) {
        throw new Error("Unresolved compilation problem: \n");
    }

    private static final String DealInfo(String string) {
        throw new Error("Unresolved compilation problem: \n");
    }
}

