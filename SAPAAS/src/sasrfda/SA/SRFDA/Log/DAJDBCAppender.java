/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Log.LogParam
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  org.apache.log4j.jdbc.JDBCAppender
 *  org.apache.log4j.spi.LoggingEvent
 */
package SA.SRFDA.Log;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Log.LogParam;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ISRFExWebContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.jdbc.JDBCAppender;
import org.apache.log4j.spi.LoggingEvent;

public class DAJDBCAppender
extends JDBCAppender
implements Runnable {
    protected InitialContext ctx = null;
    protected String strSystemId = "";
    protected String strSystemName = "";
    protected String strSubSystemId = "";
    protected String strSubSystemName = "";
    protected String strDSN = "";
    protected static final String strSQL = "INSERT INTO T_SRFSYSLOG \t(SYSLOGID, SYSLOGNAME, CREATEMAN, CREATEDATE, UPDATEMAN, UPDATEDATE, SYSTEMID, LOGLEVEL, LOGINFO,LOGLEVEL2,LOGSHORTINFO,OPPERSONID,USERDATA,USERDATA2,USERDATA3,USERDATA4,SYSTEMNAME,SUBSYSTEMID,SUBSYSTEMNAME) VALUES (?, ?, 'SYSTEM', ? , 'SYSTEM', ? , ?, ?, ?,?,?,?,?,?,?,?,?,?,?) ";
    protected int nBufferSize = 0;
    protected Vector<BaseDataEntity> list = new Vector();
    protected Boolean bRunThread = false;
    private Object objRunThread = new Object();

    public String getSystemId() {
        return this.strSystemId;
    }

    public String getDSN() {
        return this.strDSN;
    }

    public void setSystemId(String strSystemId) {
        this.strSystemId = strSystemId;
    }

    public void setSystemName(String strSystemName) {
        this.strSystemName = strSystemName;
    }

    public void setSubSystemId(String strSubSystemId) {
        this.strSubSystemId = strSubSystemId;
    }

    public void setSubSystemName(String strSubSystemName) {
        this.strSubSystemName = strSubSystemName;
    }

    public void setDSN(String strDSN) {
        this.strDSN = strDSN;
    }

    protected void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected Connection getConnection() throws SQLException {
        try {
            if (this.ctx == null) {
                this.ctx = new InitialContext();
            }
            DataSource ds = (DataSource)this.ctx.lookup(this.getDSN());
            return ds.getConnection();
        }
        catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected String getLogStatement(LoggingEvent event) {
        return "";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void append(LoggingEvent event) {
        BaseDataEntity baseDataEntity = new BaseDataEntity();
        String strLogInfo = "";
        String strUserData = null;
        String strUserData2 = null;
        String strUserData3 = null;
        String strUserData4 = null;
        String strPersonId = null;
        if (event.getMessage() != null) {
            if (event.getMessage() instanceof String) {
                strLogInfo = (String)event.getMessage();
            } else if (event.getMessage() instanceof LogParam) {
                LogParam logParam = (LogParam)event.getMessage();
                strLogInfo = logParam.getLogInfo();
                strUserData = logParam.getUserData();
                strUserData2 = logParam.getUserData2();
                strUserData3 = logParam.getUserData3();
                strUserData4 = logParam.getUserData4();
                if (logParam.getObjContext() != null && logParam.getObjContext() instanceof ISRFExWebContext) {
                    ISRFExWebContext webContext = (ISRFExWebContext)logParam.getObjContext();
                    strPersonId = webContext.getCurUserId();
                }
            }
        }
        baseDataEntity.SetParamValue("1", (Object)Helper.GenGuidEx());
        baseDataEntity.SetParamValue("2", (Object)this.OnDealInfo(event.getLoggerName()));
        baseDataEntity.SetParamValue("3", (Object)new Timestamp(event.timeStamp));
        baseDataEntity.SetParamValue("4", (Object)new Timestamp(event.timeStamp));
        baseDataEntity.SetParamValue("5", (Object)this.getSystemId());
        baseDataEntity.SetParamValue("6", (Object)event.getLevel().toString());
        if (strLogInfo.length() > 500) {
            baseDataEntity.SetParamValue("7", (Object)this.OnDealInfo(strLogInfo));
            baseDataEntity.SetParamValue("9", (Object)(String.valueOf(this.OnDealInfo(strLogInfo).substring(0, 497)) + "..."));
        } else {
            baseDataEntity.SetParamValue("7", null);
            baseDataEntity.SetParamValue("9", (Object)this.OnDealInfo(strLogInfo));
        }
        baseDataEntity.SetParamValue("8", (Object)event.getLevel().toInt());
        baseDataEntity.SetParamValue("10", (Object)strPersonId);
        baseDataEntity.SetParamValue("11", (Object)strUserData);
        baseDataEntity.SetParamValue("12", (Object)strUserData2);
        baseDataEntity.SetParamValue("13", (Object)strUserData3);
        baseDataEntity.SetParamValue("14", (Object)strUserData4);
        baseDataEntity.SetParamValue("15", (Object)this.strSystemName);
        baseDataEntity.SetParamValue("16", (Object)this.strSubSystemId);
        baseDataEntity.SetParamValue("17", (Object)this.strSubSystemName);
        Vector<BaseDataEntity> vector = this.list;
        synchronized (vector) {
            this.list.add(baseDataEntity);
        }
        if (this.list.size() > this.nBufferSize) {
            this.flushBuffer2();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void flushBuffer2() {
        Object object = this.objRunThread;
        synchronized (object) {
            if (this.bRunThread.booleanValue()) {
                return;
            }
            this.bRunThread = true;
        }
        Thread flushBufferThread = new Thread(this);
        flushBufferThread.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void flushBuffer() {
        Vector<BaseDataEntity> list2 = new Vector<BaseDataEntity>();
        Vector<BaseDataEntity> vector = this.list;
        synchronized (vector) {
            if (this.list.size() == 0) {
                return;
            }
            list2.addAll(this.list);
            this.list.clear();
        }
        try {
            Connection conn = this.getConnection();
            if (conn == null) {
                System.err.print(StringHelper.Format((String)"\u65e5\u5fd7\u6a21\u5757\u6570\u636e\u5e93\u94fe\u63a5\u65e0\u6548"));
                return;
            }
            PreparedStatement cstmt = null;
            try {
                try {
                    cstmt = conn.prepareStatement(strSQL);
                    for (BaseDataEntity dataEntity : list2) {
                        Integer i = 1;
                        while (i <= 17) {
                            Object objValue = dataEntity.GetParamValue(i.toString());
                            if (objValue == null) {
                                cstmt.setNull(i, 12);
                            } else {
                                cstmt.setObject(i, objValue);
                            }
                            i = i + 1;
                        }
                        cstmt.execute();
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.err);
                    if (cstmt != null) {
                        cstmt.close();
                    }
                    this.closeConnection(conn);
                }
            }
            finally {
                if (cstmt != null) {
                    cstmt.close();
                }
                this.closeConnection(conn);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getBufferSize() {
        return this.list.size();
    }

    public void setBufferSize(int newBufferSize) {
        this.nBufferSize = newBufferSize;
    }

    public String getSystemName() {
        return this.strSystemName;
    }

    public String getSubSystemId() {
        return this.strSubSystemId;
    }

    public String getSubSystemName() {
        return this.strSubSystemName;
    }

    protected String OnDealInfo(String strInfo) {
        if (StringHelper.IsNullOrEmpty((String)strInfo)) {
            return strInfo;
        }
        return strInfo;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        this.flushBuffer();
        Object object = this.objRunThread;
        synchronized (object) {
            this.bRunThread = false;
        }
    }
}

