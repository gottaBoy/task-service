package SA.SRFDA.EAI.Log;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import javax.sql.DataSource;
import org.apache.log4j.jdbc.JDBCAppender;
import org.apache.log4j.spi.ErrorCode;
import org.apache.log4j.spi.LoggingEvent;
import org.mule.MuleServer;
import org.mule.api.MuleContext;
import org.mule.api.context.MuleContextAware;

public class EAIJDBCAppender extends JDBCAppender implements MuleContextAware {
    protected MuleContext muleContext;
    protected String strSystemId;
    protected String strServiceId;
    protected String strDSN;
    protected String strSQL;
    protected int nBufferSize;
    protected Vector<?> list;
    protected String strLastInfo;
    protected String strLogger;
    protected long nLastTime;

    public EAIJDBCAppender() {
        this.nBufferSize = super.getBufferSize();
    }

    public void setMuleContext(MuleContext context) {
        this.muleContext = context;
    }

    protected MuleContext resolveMuleContext() {
        return this.muleContext != null ? this.muleContext : MuleServer.getMuleContext();
    }

    public String getSystemId() {
        if (this.strSystemId != null) {
            return this.strSystemId;
        }
        MuleContext context = resolveMuleContext();
        return context == null || context.getConfiguration() == null
                ? null : context.getConfiguration().getId();
    }

    public String getDSN() {
        return this.strDSN;
    }

    public void setSystemId(String systemId) {
        this.strSystemId = systemId;
    }

    public void setDSN(String dsn) {
        this.strDSN = dsn;
    }

    protected void closeConnection(Connection borrowed) {
        if (borrowed != null) {
            try {
                borrowed.close();
            } catch (SQLException ex) {
                this.errorHandler.error("Error returning EAI log connection", ex, ErrorCode.CLOSE_FAILURE);
            }
        }
    }

    protected Connection getConnection() throws SQLException {
        MuleContext context = resolveMuleContext();
        String name = this.strDSN == null || this.strDSN.trim().length() == 0
                ? "SRFDADATASOURCE" : this.strDSN.trim();
        if (context == null || context.getRegistry() == null) {
            throw new SQLException("Mule registry is unavailable for EAI log data source " + name);
        }
        Object candidate;
        try {
            candidate = context.getRegistry().lookupObject(name);
        } catch (RuntimeException ex) {
            throw new SQLException("Cannot look up EAI log data source " + name, ex);
        }
        if (!(candidate instanceof DataSource)) {
            throw new SQLException("EAI log data source is not registered: " + name);
        }
        return ((DataSource) candidate).getConnection();
    }

    protected String getLogStatement(LoggingEvent event) {
        return super.getLogStatement(event);
    }

    public void append(LoggingEvent event) {
        super.append(event);
    }

    public void flushBuffer() {
        super.flushBuffer();
    }

    public int getBufferSize() {
        return super.getBufferSize();
    }

    public void setBufferSize(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("EAI log buffer size must be positive");
        }
        super.setBufferSize(size);
        this.nBufferSize = size;
    }
}
