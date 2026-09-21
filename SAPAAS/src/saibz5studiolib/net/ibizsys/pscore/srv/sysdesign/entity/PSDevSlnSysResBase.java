/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployServer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployServerService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysResBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysResBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DB2PSDCDBINSTID = "DB2PSDCDBINSTID";
    public static final String FIELD_DB2PSDCDBINSTNAME = "DB2PSDCDBINSTNAME";
    public static final String FIELD_HBASEPSDCBDINSTID = "HBASEPSDCBDINSTID";
    public static final String FIELD_HBASEPSDCBDINSTNAME = "HBASEPSDCBDINSTNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MSSQLPSDCDBINSTID = "MSSQLPSDCDBINSTID";
    public static final String FIELD_MSSQLPSDCDBINSTNAME = "MSSQLPSDCDBINSTNAME";
    public static final String FIELD_MYSQLPSDCDBINSTID = "MYSQLPSDCDBINSTID";
    public static final String FIELD_MYSQLPSDCDBINSTNAME = "MYSQLPSDCDBINSTNAME";
    public static final String FIELD_ORAPSDCDBINSTID = "ORAPSDCDBINSTID";
    public static final String FIELD_ORAPSDCDBINSTNAME = "ORAPSDCDBINSTNAME";
    public static final String FIELD_PGSQLPSDCDBINSTID = "PGSQLPSDCDBINSTID";
    public static final String FIELD_PGSQLPSDCDBINSTNAME = "PGSQLPSDCDBINSTNAME";
    public static final String FIELD_PPASPSDCDBINSTID = "PPASPSDCDBINSTID";
    public static final String FIELD_PPASPSDCDBINSTNAME = "PPASPSDCDBINSTNAME";
    public static final String FIELD_PSDCDEPLOYSERVERID = "PSDCDEPLOYSERVERID";
    public static final String FIELD_PSDCDEPLOYSERVERNAME = "PSDCDEPLOYSERVERNAME";
    public static final String FIELD_PSDEVCENTERASID = "PSDEVCENTERASID";
    public static final String FIELD_PSDEVCENTERASID2 = "PSDEVCENTERASID2";
    public static final String FIELD_PSDEVCENTERASNAME = "PSDEVCENTERASNAME";
    public static final String FIELD_PSDEVCENTERASNAME2 = "PSDEVCENTERASNAME2";
    public static final String FIELD_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String FIELD_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSRESID = "PSDEVSLNSYSRESID";
    public static final String FIELD_PSDEVSLNSYSRESNAME = "PSDEVSLNSYSRESNAME";
    public static final String FIELD_RESINFO = "RESINFO";
    public static final String FIELD_RESPOS = "RESPOS";
    public static final String FIELD_ROPSDEVCENTERSVNID = "ROPSDEVCENTERSVNID";
    public static final String FIELD_ROPSDEVCENTERSVNNAME = "ROPSDEVCENTERSVNNAME";
    public static final String FIELD_UDB2PSDCDBINSTID = "UDB2PSDCDBINSTID";
    public static final String FIELD_UDB2PSDCDBINSTNAME = "UDB2PSDCDBINSTNAME";
    public static final String FIELD_UHBASEPSDCBDINSTID = "UHBASEPSDCBDINSTID";
    public static final String FIELD_UHBASEPSDCBDINSTNAME = "UHBASEPSDCBDINSTNAME";
    public static final String FIELD_UMSSQLPSDCDBINSTID = "UMSSQLPSDCDBINSTID";
    public static final String FIELD_UMSSQLPSDCDBINSTNAME = "UMSSQLPSDCDBINSTNAME";
    public static final String FIELD_UMYSQLPSDCDBINSTID = "UMYSQLPSDCDBINSTID";
    public static final String FIELD_UMYSQLPSDCDBINSTNAME = "UMYSQLPSDCDBINSTNAME";
    public static final String FIELD_UORAPSDCDBINSTID = "UORAPSDCDBINSTID";
    public static final String FIELD_UORAPSDCDBINSTNAME = "UORAPSDCDBINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPGSQLPSDCDBINSTID = "UPGSQLPSDCDBINSTID";
    public static final String FIELD_UPGSQLPSDCDBINSTNAME = "UPGSQLPSDCDBINSTNAME";
    public static final String FIELD_UPPASPSDCDBINSTID = "UPPASPSDCDBINSTID";
    public static final String FIELD_UPPASPSDCDBINSTNAME = "UPPASPSDCDBINSTNAME";
    public static final String FIELD_UPSDEVCENTERASID = "UPSDEVCENTERASID";
    public static final String FIELD_UPSDEVCENTERASID2 = "UPSDEVCENTERASID2";
    public static final String FIELD_UPSDEVCENTERASNAME = "UPSDEVCENTERASNAME";
    public static final String FIELD_UPSDEVCENTERASNAME2 = "UPSDEVCENTERASNAME2";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DB2PSDCDBINSTID = 2;
    private static final int INDEX_DB2PSDCDBINSTNAME = 3;
    private static final int INDEX_HBASEPSDCBDINSTID = 4;
    private static final int INDEX_HBASEPSDCBDINSTNAME = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_MSSQLPSDCDBINSTID = 7;
    private static final int INDEX_MSSQLPSDCDBINSTNAME = 8;
    private static final int INDEX_MYSQLPSDCDBINSTID = 9;
    private static final int INDEX_MYSQLPSDCDBINSTNAME = 10;
    private static final int INDEX_ORAPSDCDBINSTID = 11;
    private static final int INDEX_ORAPSDCDBINSTNAME = 12;
    private static final int INDEX_PGSQLPSDCDBINSTID = 13;
    private static final int INDEX_PGSQLPSDCDBINSTNAME = 14;
    private static final int INDEX_PPASPSDCDBINSTID = 15;
    private static final int INDEX_PPASPSDCDBINSTNAME = 16;
    private static final int INDEX_PSDCDEPLOYSERVERID = 17;
    private static final int INDEX_PSDCDEPLOYSERVERNAME = 18;
    private static final int INDEX_PSDEVCENTERASID = 19;
    private static final int INDEX_PSDEVCENTERASID2 = 20;
    private static final int INDEX_PSDEVCENTERASNAME = 21;
    private static final int INDEX_PSDEVCENTERASNAME2 = 22;
    private static final int INDEX_PSDEVCENTERSVNID = 23;
    private static final int INDEX_PSDEVCENTERSVNNAME = 24;
    private static final int INDEX_PSDEVSLNID = 25;
    private static final int INDEX_PSDEVSLNNAME = 26;
    private static final int INDEX_PSDEVSLNSYSRESID = 27;
    private static final int INDEX_PSDEVSLNSYSRESNAME = 28;
    private static final int INDEX_RESINFO = 29;
    private static final int INDEX_RESPOS = 30;
    private static final int INDEX_ROPSDEVCENTERSVNID = 31;
    private static final int INDEX_ROPSDEVCENTERSVNNAME = 32;
    private static final int INDEX_UDB2PSDCDBINSTID = 33;
    private static final int INDEX_UDB2PSDCDBINSTNAME = 34;
    private static final int INDEX_UHBASEPSDCBDINSTID = 35;
    private static final int INDEX_UHBASEPSDCBDINSTNAME = 36;
    private static final int INDEX_UMSSQLPSDCDBINSTID = 37;
    private static final int INDEX_UMSSQLPSDCDBINSTNAME = 38;
    private static final int INDEX_UMYSQLPSDCDBINSTID = 39;
    private static final int INDEX_UMYSQLPSDCDBINSTNAME = 40;
    private static final int INDEX_UORAPSDCDBINSTID = 41;
    private static final int INDEX_UORAPSDCDBINSTNAME = 42;
    private static final int INDEX_UPDATEDATE = 43;
    private static final int INDEX_UPDATEMAN = 44;
    private static final int INDEX_UPGSQLPSDCDBINSTID = 45;
    private static final int INDEX_UPGSQLPSDCDBINSTNAME = 46;
    private static final int INDEX_UPPASPSDCDBINSTID = 47;
    private static final int INDEX_UPPASPSDCDBINSTNAME = 48;
    private static final int INDEX_UPSDEVCENTERASID = 49;
    private static final int INDEX_UPSDEVCENTERASID2 = 50;
    private static final int INDEX_UPSDEVCENTERASNAME = 51;
    private static final int INDEX_UPSDEVCENTERASNAME2 = 52;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysResBase proxyPSDevSlnSysResBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean db2psdcdbinstidDirtyFlag = false;
    private boolean db2psdcdbinstnameDirtyFlag = false;
    private boolean hbasepsdcbdinstidDirtyFlag = false;
    private boolean hbasepsdcbdinstnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mssqlpsdcdbinstidDirtyFlag = false;
    private boolean mssqlpsdcdbinstnameDirtyFlag = false;
    private boolean mysqlpsdcdbinstidDirtyFlag = false;
    private boolean mysqlpsdcdbinstnameDirtyFlag = false;
    private boolean orapsdcdbinstidDirtyFlag = false;
    private boolean orapsdcdbinstnameDirtyFlag = false;
    private boolean pgsqlpsdcdbinstidDirtyFlag = false;
    private boolean pgsqlpsdcdbinstnameDirtyFlag = false;
    private boolean ppaspsdcdbinstidDirtyFlag = false;
    private boolean ppaspsdcdbinstnameDirtyFlag = false;
    private boolean psdcdeployserveridDirtyFlag = false;
    private boolean psdcdeployservernameDirtyFlag = false;
    private boolean psdevcenterasidDirtyFlag = false;
    private boolean psdevcenterasid2DirtyFlag = false;
    private boolean psdevcenterasnameDirtyFlag = false;
    private boolean psdevcenterasname2DirtyFlag = false;
    private boolean psdevcentersvnidDirtyFlag = false;
    private boolean psdevcentersvnnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysresidDirtyFlag = false;
    private boolean psdevslnsysresnameDirtyFlag = false;
    private boolean resinfoDirtyFlag = false;
    private boolean resposDirtyFlag = false;
    private boolean ropsdevcentersvnidDirtyFlag = false;
    private boolean ropsdevcentersvnnameDirtyFlag = false;
    private boolean udb2psdcdbinstidDirtyFlag = false;
    private boolean udb2psdcdbinstnameDirtyFlag = false;
    private boolean uhbasepsdcbdinstidDirtyFlag = false;
    private boolean uhbasepsdcbdinstnameDirtyFlag = false;
    private boolean umssqlpsdcdbinstidDirtyFlag = false;
    private boolean umssqlpsdcdbinstnameDirtyFlag = false;
    private boolean umysqlpsdcdbinstidDirtyFlag = false;
    private boolean umysqlpsdcdbinstnameDirtyFlag = false;
    private boolean uorapsdcdbinstidDirtyFlag = false;
    private boolean uorapsdcdbinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean upgsqlpsdcdbinstidDirtyFlag = false;
    private boolean upgsqlpsdcdbinstnameDirtyFlag = false;
    private boolean uppaspsdcdbinstidDirtyFlag = false;
    private boolean uppaspsdcdbinstnameDirtyFlag = false;
    private boolean upsdevcenterasidDirtyFlag = false;
    private boolean upsdevcenterasid2DirtyFlag = false;
    private boolean upsdevcenterasnameDirtyFlag = false;
    private boolean upsdevcenterasname2DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="db2psdcdbinstid")
    private String db2psdcdbinstid;
    @Column(name="db2psdcdbinstname")
    private String db2psdcdbinstname;
    @Column(name="hbasepsdcbdinstid")
    private String hbasepsdcbdinstid;
    @Column(name="hbasepsdcbdinstname")
    private String hbasepsdcbdinstname;
    @Column(name="memo")
    private String memo;
    @Column(name="mssqlpsdcdbinstid")
    private String mssqlpsdcdbinstid;
    @Column(name="mssqlpsdcdbinstname")
    private String mssqlpsdcdbinstname;
    @Column(name="mysqlpsdcdbinstid")
    private String mysqlpsdcdbinstid;
    @Column(name="mysqlpsdcdbinstname")
    private String mysqlpsdcdbinstname;
    @Column(name="orapsdcdbinstid")
    private String orapsdcdbinstid;
    @Column(name="orapsdcdbinstname")
    private String orapsdcdbinstname;
    @Column(name="pgsqlpsdcdbinstid")
    private String pgsqlpsdcdbinstid;
    @Column(name="pgsqlpsdcdbinstname")
    private String pgsqlpsdcdbinstname;
    @Column(name="ppaspsdcdbinstid")
    private String ppaspsdcdbinstid;
    @Column(name="ppaspsdcdbinstname")
    private String ppaspsdcdbinstname;
    @Column(name="psdcdeployserverid")
    private String psdcdeployserverid;
    @Column(name="psdcdeployservername")
    private String psdcdeployservername;
    @Column(name="psdevcenterasid")
    private String psdevcenterasid;
    @Column(name="psdevcenterasid2")
    private String psdevcenterasid2;
    @Column(name="psdevcenterasname")
    private String psdevcenterasname;
    @Column(name="psdevcenterasname2")
    private String psdevcenterasname2;
    @Column(name="psdevcentersvnid")
    private String psdevcentersvnid;
    @Column(name="psdevcentersvnname")
    private String psdevcentersvnname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysresid")
    private String psdevslnsysresid;
    @Column(name="psdevslnsysresname")
    private String psdevslnsysresname;
    @Column(name="resinfo")
    private String resinfo;
    @Column(name="respos")
    private Integer respos;
    @Column(name="ropsdevcentersvnid")
    private String ropsdevcentersvnid;
    @Column(name="ropsdevcentersvnname")
    private String ropsdevcentersvnname;
    @Column(name="udb2psdcdbinstid")
    private String udb2psdcdbinstid;
    @Column(name="udb2psdcdbinstname")
    private String udb2psdcdbinstname;
    @Column(name="uhbasepsdcbdinstid")
    private String uhbasepsdcbdinstid;
    @Column(name="uhbasepsdcbdinstname")
    private String uhbasepsdcbdinstname;
    @Column(name="umssqlpsdcdbinstid")
    private String umssqlpsdcdbinstid;
    @Column(name="umssqlpsdcdbinstname")
    private String umssqlpsdcdbinstname;
    @Column(name="umysqlpsdcdbinstid")
    private String umysqlpsdcdbinstid;
    @Column(name="umysqlpsdcdbinstname")
    private String umysqlpsdcdbinstname;
    @Column(name="uorapsdcdbinstid")
    private String uorapsdcdbinstid;
    @Column(name="uorapsdcdbinstname")
    private String uorapsdcdbinstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="upgsqlpsdcdbinstid")
    private String upgsqlpsdcdbinstid;
    @Column(name="upgsqlpsdcdbinstname")
    private String upgsqlpsdcdbinstname;
    @Column(name="uppaspsdcdbinstid")
    private String uppaspsdcdbinstid;
    @Column(name="uppaspsdcdbinstname")
    private String uppaspsdcdbinstname;
    @Column(name="upsdevcenterasid")
    private String upsdevcenterasid;
    @Column(name="upsdevcenterasid2")
    private String upsdevcenterasid2;
    @Column(name="upsdevcenterasname")
    private String upsdevcenterasname;
    @Column(name="upsdevcenterasname2")
    private String upsdevcenterasname2;
    private Integer objHBasePSDCBDInstLock = new Integer(1);
    private PSDCBDInst hbasepsdcbdinst = null;
    private Integer objUHBasePSDCBDInstLock = new Integer(1);
    private PSDCBDInst uhbasepsdcbdinst = null;
    private Integer objPSDCDeployServerLock = new Integer(1);
    private PSDCDeployServer psdcdeployserver = null;
    private Integer objPSDevCenterASLock = new Integer(1);
    private PSDevCenterAS psdevcenteras = null;
    private Integer objPSDevCenterAS2Lock = new Integer(1);
    private PSDevCenterAS psdevcenteras2 = null;
    private Integer objUPSDevCenterASLock = new Integer(1);
    private PSDevCenterAS upsdevcenteras = null;
    private Integer objUPSDevCenterAS2Lock = new Integer(1);
    private PSDevCenterAS upsdevcenteras2 = null;
    private Integer objDB2PSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst db2psdcdbinst = null;
    private Integer objMSSqlPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst mssqlpsdcdbinst = null;
    private Integer objMySQLPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst mysqlpsdcdbinst = null;
    private Integer objOraPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst orapsdcdbinst = null;
    private Integer objPGSQLPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst pgsqlpsdcdbinst = null;
    private Integer objPPASPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst ppaspsdcdbinst = null;
    private Integer objUDB2PSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst udb2psdcdbinst = null;
    private Integer objUMSSqlPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst umssqlpsdcdbinst = null;
    private Integer objUMySQLPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst umysqlpsdcdbinst = null;
    private Integer objUOraPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst uorapsdcdbinst = null;
    private Integer objUPGSQLPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst upgsqlpsdcdbinst = null;
    private Integer objUPPASPSDCDBInstLock = new Integer(1);
    private PSDevCenterDBInst uppaspsdcdbinst = null;
    private Integer objPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN psdevcentersvn = null;
    private Integer objROPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN ropsdevcentersvn = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
        this.createdateDirtyFlag = true;
    }

    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    public void setCreateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createman = string;
        this.createmanDirtyFlag = true;
    }

    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setDB2PSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDB2PSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.db2psdcdbinstid = string;
        this.db2psdcdbinstidDirtyFlag = true;
    }

    public String getDB2PSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDB2PSDCDBInstId();
        }
        return this.db2psdcdbinstid;
    }

    public boolean isDB2PSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDB2PSDCDBInstIdDirty();
        }
        return this.db2psdcdbinstidDirtyFlag;
    }

    public void resetDB2PSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDB2PSDCDBInstId();
            return;
        }
        this.db2psdcdbinstidDirtyFlag = false;
        this.db2psdcdbinstid = null;
    }

    public void setDB2PSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDB2PSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.db2psdcdbinstname = string;
        this.db2psdcdbinstnameDirtyFlag = true;
    }

    public String getDB2PSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDB2PSDCDBInstName();
        }
        return this.db2psdcdbinstname;
    }

    public boolean isDB2PSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDB2PSDCDBInstNameDirty();
        }
        return this.db2psdcdbinstnameDirtyFlag;
    }

    public void resetDB2PSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDB2PSDCDBInstName();
            return;
        }
        this.db2psdcdbinstnameDirtyFlag = false;
        this.db2psdcdbinstname = null;
    }

    public void setHBasePSDCBDInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHBasePSDCBDInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hbasepsdcbdinstid = string;
        this.hbasepsdcbdinstidDirtyFlag = true;
    }

    public String getHBasePSDCBDInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHBasePSDCBDInstId();
        }
        return this.hbasepsdcbdinstid;
    }

    public boolean isHBasePSDCBDInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHBasePSDCBDInstIdDirty();
        }
        return this.hbasepsdcbdinstidDirtyFlag;
    }

    public void resetHBasePSDCBDInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHBasePSDCBDInstId();
            return;
        }
        this.hbasepsdcbdinstidDirtyFlag = false;
        this.hbasepsdcbdinstid = null;
    }

    public void setHBasePSDCBDInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHBasePSDCBDInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hbasepsdcbdinstname = string;
        this.hbasepsdcbdinstnameDirtyFlag = true;
    }

    public String getHBasePSDCBDInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHBasePSDCBDInstName();
        }
        return this.hbasepsdcbdinstname;
    }

    public boolean isHBasePSDCBDInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHBasePSDCBDInstNameDirty();
        }
        return this.hbasepsdcbdinstnameDirtyFlag;
    }

    public void resetHBasePSDCBDInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHBasePSDCBDInstName();
            return;
        }
        this.hbasepsdcbdinstnameDirtyFlag = false;
        this.hbasepsdcbdinstname = null;
    }

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
        this.memoDirtyFlag = true;
    }

    public String getMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    public boolean isMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    public void resetMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemo();
            return;
        }
        this.memoDirtyFlag = false;
        this.memo = null;
    }

    public void setMSSQLPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSSQLPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mssqlpsdcdbinstid = string;
        this.mssqlpsdcdbinstidDirtyFlag = true;
    }

    public String getMSSQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSSQLPSDCDBInstId();
        }
        return this.mssqlpsdcdbinstid;
    }

    public boolean isMSSQLPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSSQLPSDCDBInstIdDirty();
        }
        return this.mssqlpsdcdbinstidDirtyFlag;
    }

    public void resetMSSQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSSQLPSDCDBInstId();
            return;
        }
        this.mssqlpsdcdbinstidDirtyFlag = false;
        this.mssqlpsdcdbinstid = null;
    }

    public void setMSSQLPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMSSQLPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mssqlpsdcdbinstname = string;
        this.mssqlpsdcdbinstnameDirtyFlag = true;
    }

    public String getMSSQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSSQLPSDCDBInstName();
        }
        return this.mssqlpsdcdbinstname;
    }

    public boolean isMSSQLPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMSSQLPSDCDBInstNameDirty();
        }
        return this.mssqlpsdcdbinstnameDirtyFlag;
    }

    public void resetMSSQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMSSQLPSDCDBInstName();
            return;
        }
        this.mssqlpsdcdbinstnameDirtyFlag = false;
        this.mssqlpsdcdbinstname = null;
    }

    public void setMySQLPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMySQLPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mysqlpsdcdbinstid = string;
        this.mysqlpsdcdbinstidDirtyFlag = true;
    }

    public String getMySQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMySQLPSDCDBInstId();
        }
        return this.mysqlpsdcdbinstid;
    }

    public boolean isMySQLPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMySQLPSDCDBInstIdDirty();
        }
        return this.mysqlpsdcdbinstidDirtyFlag;
    }

    public void resetMySQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMySQLPSDCDBInstId();
            return;
        }
        this.mysqlpsdcdbinstidDirtyFlag = false;
        this.mysqlpsdcdbinstid = null;
    }

    public void setMySQLPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMySQLPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mysqlpsdcdbinstname = string;
        this.mysqlpsdcdbinstnameDirtyFlag = true;
    }

    public String getMySQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMySQLPSDCDBInstName();
        }
        return this.mysqlpsdcdbinstname;
    }

    public boolean isMySQLPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMySQLPSDCDBInstNameDirty();
        }
        return this.mysqlpsdcdbinstnameDirtyFlag;
    }

    public void resetMySQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMySQLPSDCDBInstName();
            return;
        }
        this.mysqlpsdcdbinstnameDirtyFlag = false;
        this.mysqlpsdcdbinstname = null;
    }

    public void setOraPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOraPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.orapsdcdbinstid = string;
        this.orapsdcdbinstidDirtyFlag = true;
    }

    public String getOraPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOraPSDCDBInstId();
        }
        return this.orapsdcdbinstid;
    }

    public boolean isOraPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOraPSDCDBInstIdDirty();
        }
        return this.orapsdcdbinstidDirtyFlag;
    }

    public void resetOraPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOraPSDCDBInstId();
            return;
        }
        this.orapsdcdbinstidDirtyFlag = false;
        this.orapsdcdbinstid = null;
    }

    public void setOraPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOraPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.orapsdcdbinstname = string;
        this.orapsdcdbinstnameDirtyFlag = true;
    }

    public String getOraPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOraPSDCDBInstName();
        }
        return this.orapsdcdbinstname;
    }

    public boolean isOraPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOraPSDCDBInstNameDirty();
        }
        return this.orapsdcdbinstnameDirtyFlag;
    }

    public void resetOraPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOraPSDCDBInstName();
            return;
        }
        this.orapsdcdbinstnameDirtyFlag = false;
        this.orapsdcdbinstname = null;
    }

    public void setPGSQLPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPGSQLPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pgsqlpsdcdbinstid = string;
        this.pgsqlpsdcdbinstidDirtyFlag = true;
    }

    public String getPGSQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPGSQLPSDCDBInstId();
        }
        return this.pgsqlpsdcdbinstid;
    }

    public boolean isPGSQLPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPGSQLPSDCDBInstIdDirty();
        }
        return this.pgsqlpsdcdbinstidDirtyFlag;
    }

    public void resetPGSQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPGSQLPSDCDBInstId();
            return;
        }
        this.pgsqlpsdcdbinstidDirtyFlag = false;
        this.pgsqlpsdcdbinstid = null;
    }

    public void setPGSQLPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPGSQLPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pgsqlpsdcdbinstname = string;
        this.pgsqlpsdcdbinstnameDirtyFlag = true;
    }

    public String getPGSQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPGSQLPSDCDBInstName();
        }
        return this.pgsqlpsdcdbinstname;
    }

    public boolean isPGSQLPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPGSQLPSDCDBInstNameDirty();
        }
        return this.pgsqlpsdcdbinstnameDirtyFlag;
    }

    public void resetPGSQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPGSQLPSDCDBInstName();
            return;
        }
        this.pgsqlpsdcdbinstnameDirtyFlag = false;
        this.pgsqlpsdcdbinstname = null;
    }

    public void setPPASPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPASPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppaspsdcdbinstid = string;
        this.ppaspsdcdbinstidDirtyFlag = true;
    }

    public String getPPASPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPASPSDCDBInstId();
        }
        return this.ppaspsdcdbinstid;
    }

    public boolean isPPASPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPASPSDCDBInstIdDirty();
        }
        return this.ppaspsdcdbinstidDirtyFlag;
    }

    public void resetPPASPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPASPSDCDBInstId();
            return;
        }
        this.ppaspsdcdbinstidDirtyFlag = false;
        this.ppaspsdcdbinstid = null;
    }

    public void setPPASPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPASPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppaspsdcdbinstname = string;
        this.ppaspsdcdbinstnameDirtyFlag = true;
    }

    public String getPPASPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPASPSDCDBInstName();
        }
        return this.ppaspsdcdbinstname;
    }

    public boolean isPPASPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPASPSDCDBInstNameDirty();
        }
        return this.ppaspsdcdbinstnameDirtyFlag;
    }

    public void resetPPASPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPASPSDCDBInstName();
            return;
        }
        this.ppaspsdcdbinstnameDirtyFlag = false;
        this.ppaspsdcdbinstname = null;
    }

    public void setPSDCDeployServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDeployServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdeployserverid = string;
        this.psdcdeployserveridDirtyFlag = true;
    }

    public String getPSDCDeployServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployServerId();
        }
        return this.psdcdeployserverid;
    }

    public boolean isPSDCDeployServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDeployServerIdDirty();
        }
        return this.psdcdeployserveridDirtyFlag;
    }

    public void resetPSDCDeployServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDeployServerId();
            return;
        }
        this.psdcdeployserveridDirtyFlag = false;
        this.psdcdeployserverid = null;
    }

    public void setPSDCDeployServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDeployServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdeployservername = string;
        this.psdcdeployservernameDirtyFlag = true;
    }

    public String getPSDCDeployServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployServerName();
        }
        return this.psdcdeployservername;
    }

    public boolean isPSDCDeployServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDeployServerNameDirty();
        }
        return this.psdcdeployservernameDirtyFlag;
    }

    public void resetPSDCDeployServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDeployServerName();
            return;
        }
        this.psdcdeployservernameDirtyFlag = false;
        this.psdcdeployservername = null;
    }

    public void setPSDevCenterASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasid = string;
        this.psdevcenterasidDirtyFlag = true;
    }

    public String getPSDevCenterASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASId();
        }
        return this.psdevcenterasid;
    }

    public boolean isPSDevCenterASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASIdDirty();
        }
        return this.psdevcenterasidDirtyFlag;
    }

    public void resetPSDevCenterASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASId();
            return;
        }
        this.psdevcenterasidDirtyFlag = false;
        this.psdevcenterasid = null;
    }

    public void setPSDevCenterASId2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASId2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasid2 = string;
        this.psdevcenterasid2DirtyFlag = true;
    }

    public String getPSDevCenterASId2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASId2();
        }
        return this.psdevcenterasid2;
    }

    public boolean isPSDevCenterASId2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASId2Dirty();
        }
        return this.psdevcenterasid2DirtyFlag;
    }

    public void resetPSDevCenterASId2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASId2();
            return;
        }
        this.psdevcenterasid2DirtyFlag = false;
        this.psdevcenterasid2 = null;
    }

    public void setPSDevCenterASName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasname = string;
        this.psdevcenterasnameDirtyFlag = true;
    }

    public String getPSDevCenterASName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASName();
        }
        return this.psdevcenterasname;
    }

    public boolean isPSDevCenterASNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASNameDirty();
        }
        return this.psdevcenterasnameDirtyFlag;
    }

    public void resetPSDevCenterASName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASName();
            return;
        }
        this.psdevcenterasnameDirtyFlag = false;
        this.psdevcenterasname = null;
    }

    public void setPSDevCenterASName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasname2 = string;
        this.psdevcenterasname2DirtyFlag = true;
    }

    public String getPSDevCenterASName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASName2();
        }
        return this.psdevcenterasname2;
    }

    public boolean isPSDevCenterASName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASName2Dirty();
        }
        return this.psdevcenterasname2DirtyFlag;
    }

    public void resetPSDevCenterASName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASName2();
            return;
        }
        this.psdevcenterasname2DirtyFlag = false;
        this.psdevcenterasname2 = null;
    }

    public void setPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnid = string;
        this.psdevcentersvnidDirtyFlag = true;
    }

    public String getPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNId();
        }
        return this.psdevcentersvnid;
    }

    public boolean isPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNIdDirty();
        }
        return this.psdevcentersvnidDirtyFlag;
    }

    public void resetPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNId();
            return;
        }
        this.psdevcentersvnidDirtyFlag = false;
        this.psdevcentersvnid = null;
    }

    public void setPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnname = string;
        this.psdevcentersvnnameDirtyFlag = true;
    }

    public String getPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNName();
        }
        return this.psdevcentersvnname;
    }

    public boolean isPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNNameDirty();
        }
        return this.psdevcentersvnnameDirtyFlag;
    }

    public void resetPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNName();
            return;
        }
        this.psdevcentersvnnameDirtyFlag = false;
        this.psdevcentersvnname = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setPSDevSlnSysResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysresid = string;
        this.psdevslnsysresidDirtyFlag = true;
    }

    public String getPSDevSlnSysResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysResId();
        }
        return this.psdevslnsysresid;
    }

    public boolean isPSDevSlnSysResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysResIdDirty();
        }
        return this.psdevslnsysresidDirtyFlag;
    }

    public void resetPSDevSlnSysResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysResId();
            return;
        }
        this.psdevslnsysresidDirtyFlag = false;
        this.psdevslnsysresid = null;
    }

    public void setPSDevSlnSysResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysresname = string;
        this.psdevslnsysresnameDirtyFlag = true;
    }

    public String getPSDevSlnSysResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysResName();
        }
        return this.psdevslnsysresname;
    }

    public boolean isPSDevSlnSysResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysResNameDirty();
        }
        return this.psdevslnsysresnameDirtyFlag;
    }

    public void resetPSDevSlnSysResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysResName();
            return;
        }
        this.psdevslnsysresnameDirtyFlag = false;
        this.psdevslnsysresname = null;
    }

    public void setResInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resinfo = string;
        this.resinfoDirtyFlag = true;
    }

    public String getResInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResInfo();
        }
        return this.resinfo;
    }

    public boolean isResInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResInfoDirty();
        }
        return this.resinfoDirtyFlag;
    }

    public void resetResInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResInfo();
            return;
        }
        this.resinfoDirtyFlag = false;
        this.resinfo = null;
    }

    public void setResPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResPos(n);
            return;
        }
        this.respos = n;
        this.resposDirtyFlag = true;
    }

    public Integer getResPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResPos();
        }
        return this.respos;
    }

    public boolean isResPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResPosDirty();
        }
        return this.resposDirtyFlag;
    }

    public void resetResPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResPos();
            return;
        }
        this.resposDirtyFlag = false;
        this.respos = null;
    }

    public void setROPSDevCenterSvnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROPSDevCenterSvnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ropsdevcentersvnid = string;
        this.ropsdevcentersvnidDirtyFlag = true;
    }

    public String getROPSDevCenterSvnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSDevCenterSvnId();
        }
        return this.ropsdevcentersvnid;
    }

    public boolean isROPSDevCenterSvnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROPSDevCenterSvnIdDirty();
        }
        return this.ropsdevcentersvnidDirtyFlag;
    }

    public void resetROPSDevCenterSvnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROPSDevCenterSvnId();
            return;
        }
        this.ropsdevcentersvnidDirtyFlag = false;
        this.ropsdevcentersvnid = null;
    }

    public void setROPSDevCenterSvnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setROPSDevCenterSvnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ropsdevcentersvnname = string;
        this.ropsdevcentersvnnameDirtyFlag = true;
    }

    public String getROPSDevCenterSvnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSDevCenterSvnName();
        }
        return this.ropsdevcentersvnname;
    }

    public boolean isROPSDevCenterSvnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isROPSDevCenterSvnNameDirty();
        }
        return this.ropsdevcentersvnnameDirtyFlag;
    }

    public void resetROPSDevCenterSvnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetROPSDevCenterSvnName();
            return;
        }
        this.ropsdevcentersvnnameDirtyFlag = false;
        this.ropsdevcentersvnname = null;
    }

    public void setUDB2PSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUDB2PSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.udb2psdcdbinstid = string;
        this.udb2psdcdbinstidDirtyFlag = true;
    }

    public String getUDB2PSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUDB2PSDCDBInstId();
        }
        return this.udb2psdcdbinstid;
    }

    public boolean isUDB2PSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUDB2PSDCDBInstIdDirty();
        }
        return this.udb2psdcdbinstidDirtyFlag;
    }

    public void resetUDB2PSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUDB2PSDCDBInstId();
            return;
        }
        this.udb2psdcdbinstidDirtyFlag = false;
        this.udb2psdcdbinstid = null;
    }

    public void setUDB2PSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUDB2PSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.udb2psdcdbinstname = string;
        this.udb2psdcdbinstnameDirtyFlag = true;
    }

    public String getUDB2PSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUDB2PSDCDBInstName();
        }
        return this.udb2psdcdbinstname;
    }

    public boolean isUDB2PSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUDB2PSDCDBInstNameDirty();
        }
        return this.udb2psdcdbinstnameDirtyFlag;
    }

    public void resetUDB2PSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUDB2PSDCDBInstName();
            return;
        }
        this.udb2psdcdbinstnameDirtyFlag = false;
        this.udb2psdcdbinstname = null;
    }

    public void setUHBasePSDCBDInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUHBasePSDCBDInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uhbasepsdcbdinstid = string;
        this.uhbasepsdcbdinstidDirtyFlag = true;
    }

    public String getUHBasePSDCBDInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUHBasePSDCBDInstId();
        }
        return this.uhbasepsdcbdinstid;
    }

    public boolean isUHBasePSDCBDInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUHBasePSDCBDInstIdDirty();
        }
        return this.uhbasepsdcbdinstidDirtyFlag;
    }

    public void resetUHBasePSDCBDInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUHBasePSDCBDInstId();
            return;
        }
        this.uhbasepsdcbdinstidDirtyFlag = false;
        this.uhbasepsdcbdinstid = null;
    }

    public void setUHBasePSDCBDInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUHBasePSDCBDInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uhbasepsdcbdinstname = string;
        this.uhbasepsdcbdinstnameDirtyFlag = true;
    }

    public String getUHBasePSDCBDInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUHBasePSDCBDInstName();
        }
        return this.uhbasepsdcbdinstname;
    }

    public boolean isUHBasePSDCBDInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUHBasePSDCBDInstNameDirty();
        }
        return this.uhbasepsdcbdinstnameDirtyFlag;
    }

    public void resetUHBasePSDCBDInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUHBasePSDCBDInstName();
            return;
        }
        this.uhbasepsdcbdinstnameDirtyFlag = false;
        this.uhbasepsdcbdinstname = null;
    }

    public void setUMSSQLPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUMSSQLPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.umssqlpsdcdbinstid = string;
        this.umssqlpsdcdbinstidDirtyFlag = true;
    }

    public String getUMSSQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUMSSQLPSDCDBInstId();
        }
        return this.umssqlpsdcdbinstid;
    }

    public boolean isUMSSQLPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUMSSQLPSDCDBInstIdDirty();
        }
        return this.umssqlpsdcdbinstidDirtyFlag;
    }

    public void resetUMSSQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUMSSQLPSDCDBInstId();
            return;
        }
        this.umssqlpsdcdbinstidDirtyFlag = false;
        this.umssqlpsdcdbinstid = null;
    }

    public void setUMSSQLPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUMSSQLPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.umssqlpsdcdbinstname = string;
        this.umssqlpsdcdbinstnameDirtyFlag = true;
    }

    public String getUMSSQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUMSSQLPSDCDBInstName();
        }
        return this.umssqlpsdcdbinstname;
    }

    public boolean isUMSSQLPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUMSSQLPSDCDBInstNameDirty();
        }
        return this.umssqlpsdcdbinstnameDirtyFlag;
    }

    public void resetUMSSQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUMSSQLPSDCDBInstName();
            return;
        }
        this.umssqlpsdcdbinstnameDirtyFlag = false;
        this.umssqlpsdcdbinstname = null;
    }

    public void setUMySQLPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUMySQLPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.umysqlpsdcdbinstid = string;
        this.umysqlpsdcdbinstidDirtyFlag = true;
    }

    public String getUMySQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUMySQLPSDCDBInstId();
        }
        return this.umysqlpsdcdbinstid;
    }

    public boolean isUMySQLPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUMySQLPSDCDBInstIdDirty();
        }
        return this.umysqlpsdcdbinstidDirtyFlag;
    }

    public void resetUMySQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUMySQLPSDCDBInstId();
            return;
        }
        this.umysqlpsdcdbinstidDirtyFlag = false;
        this.umysqlpsdcdbinstid = null;
    }

    public void setUMySQLPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUMySQLPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.umysqlpsdcdbinstname = string;
        this.umysqlpsdcdbinstnameDirtyFlag = true;
    }

    public String getUMySQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUMySQLPSDCDBInstName();
        }
        return this.umysqlpsdcdbinstname;
    }

    public boolean isUMySQLPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUMySQLPSDCDBInstNameDirty();
        }
        return this.umysqlpsdcdbinstnameDirtyFlag;
    }

    public void resetUMySQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUMySQLPSDCDBInstName();
            return;
        }
        this.umysqlpsdcdbinstnameDirtyFlag = false;
        this.umysqlpsdcdbinstname = null;
    }

    public void setUOraPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUOraPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uorapsdcdbinstid = string;
        this.uorapsdcdbinstidDirtyFlag = true;
    }

    public String getUOraPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUOraPSDCDBInstId();
        }
        return this.uorapsdcdbinstid;
    }

    public boolean isUOraPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUOraPSDCDBInstIdDirty();
        }
        return this.uorapsdcdbinstidDirtyFlag;
    }

    public void resetUOraPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUOraPSDCDBInstId();
            return;
        }
        this.uorapsdcdbinstidDirtyFlag = false;
        this.uorapsdcdbinstid = null;
    }

    public void setUOraPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUOraPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uorapsdcdbinstname = string;
        this.uorapsdcdbinstnameDirtyFlag = true;
    }

    public String getUOraPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUOraPSDCDBInstName();
        }
        return this.uorapsdcdbinstname;
    }

    public boolean isUOraPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUOraPSDCDBInstNameDirty();
        }
        return this.uorapsdcdbinstnameDirtyFlag;
    }

    public void resetUOraPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUOraPSDCDBInstName();
            return;
        }
        this.uorapsdcdbinstnameDirtyFlag = false;
        this.uorapsdcdbinstname = null;
    }

    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
        this.updatedateDirtyFlag = true;
    }

    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    public void setUpdateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updateman = string;
        this.updatemanDirtyFlag = true;
    }

    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    public void setUPGSQLPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUPGSQLPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.upgsqlpsdcdbinstid = string;
        this.upgsqlpsdcdbinstidDirtyFlag = true;
    }

    public String getUPGSQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUPGSQLPSDCDBInstId();
        }
        return this.upgsqlpsdcdbinstid;
    }

    public boolean isUPGSQLPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUPGSQLPSDCDBInstIdDirty();
        }
        return this.upgsqlpsdcdbinstidDirtyFlag;
    }

    public void resetUPGSQLPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUPGSQLPSDCDBInstId();
            return;
        }
        this.upgsqlpsdcdbinstidDirtyFlag = false;
        this.upgsqlpsdcdbinstid = null;
    }

    public void setUPGSQLPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUPGSQLPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.upgsqlpsdcdbinstname = string;
        this.upgsqlpsdcdbinstnameDirtyFlag = true;
    }

    public String getUPGSQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUPGSQLPSDCDBInstName();
        }
        return this.upgsqlpsdcdbinstname;
    }

    public boolean isUPGSQLPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUPGSQLPSDCDBInstNameDirty();
        }
        return this.upgsqlpsdcdbinstnameDirtyFlag;
    }

    public void resetUPGSQLPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUPGSQLPSDCDBInstName();
            return;
        }
        this.upgsqlpsdcdbinstnameDirtyFlag = false;
        this.upgsqlpsdcdbinstname = null;
    }

    public void setUPPASPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUPPASPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uppaspsdcdbinstid = string;
        this.uppaspsdcdbinstidDirtyFlag = true;
    }

    public String getUPPASPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUPPASPSDCDBInstId();
        }
        return this.uppaspsdcdbinstid;
    }

    public boolean isUPPASPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUPPASPSDCDBInstIdDirty();
        }
        return this.uppaspsdcdbinstidDirtyFlag;
    }

    public void resetUPPASPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUPPASPSDCDBInstId();
            return;
        }
        this.uppaspsdcdbinstidDirtyFlag = false;
        this.uppaspsdcdbinstid = null;
    }

    public void setUPPASPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUPPASPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uppaspsdcdbinstname = string;
        this.uppaspsdcdbinstnameDirtyFlag = true;
    }

    public String getUPPASPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUPPASPSDCDBInstName();
        }
        return this.uppaspsdcdbinstname;
    }

    public boolean isUPPASPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUPPASPSDCDBInstNameDirty();
        }
        return this.uppaspsdcdbinstnameDirtyFlag;
    }

    public void resetUPPASPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUPPASPSDCDBInstName();
            return;
        }
        this.uppaspsdcdbinstnameDirtyFlag = false;
        this.uppaspsdcdbinstname = null;
    }

    public void setUPSDevCenterASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUPSDevCenterASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.upsdevcenterasid = string;
        this.upsdevcenterasidDirtyFlag = true;
    }

    public String getUPSDevCenterASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUPSDevCenterASId();
        }
        return this.upsdevcenterasid;
    }

    public boolean isUPSDevCenterASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUPSDevCenterASIdDirty();
        }
        return this.upsdevcenterasidDirtyFlag;
    }

    public void resetUPSDevCenterASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUPSDevCenterASId();
            return;
        }
        this.upsdevcenterasidDirtyFlag = false;
        this.upsdevcenterasid = null;
    }

    public void setUPSDevCenterASId2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUPSDevCenterASId2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.upsdevcenterasid2 = string;
        this.upsdevcenterasid2DirtyFlag = true;
    }

    public String getUPSDevCenterASId2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUPSDevCenterASId2();
        }
        return this.upsdevcenterasid2;
    }

    public boolean isUPSDevCenterASId2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUPSDevCenterASId2Dirty();
        }
        return this.upsdevcenterasid2DirtyFlag;
    }

    public void resetUPSDevCenterASId2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUPSDevCenterASId2();
            return;
        }
        this.upsdevcenterasid2DirtyFlag = false;
        this.upsdevcenterasid2 = null;
    }

    public void setUPSDevCenterASName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUPSDevCenterASName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.upsdevcenterasname = string;
        this.upsdevcenterasnameDirtyFlag = true;
    }

    public String getUPSDevCenterASName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUPSDevCenterASName();
        }
        return this.upsdevcenterasname;
    }

    public boolean isUPSDevCenterASNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUPSDevCenterASNameDirty();
        }
        return this.upsdevcenterasnameDirtyFlag;
    }

    public void resetUPSDevCenterASName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUPSDevCenterASName();
            return;
        }
        this.upsdevcenterasnameDirtyFlag = false;
        this.upsdevcenterasname = null;
    }

    public void setUPSDevCenterASName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUPSDevCenterASName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.upsdevcenterasname2 = string;
        this.upsdevcenterasname2DirtyFlag = true;
    }

    public String getUPSDevCenterASName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUPSDevCenterASName2();
        }
        return this.upsdevcenterasname2;
    }

    public boolean isUPSDevCenterASName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUPSDevCenterASName2Dirty();
        }
        return this.upsdevcenterasname2DirtyFlag;
    }

    public void resetUPSDevCenterASName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUPSDevCenterASName2();
            return;
        }
        this.upsdevcenterasname2DirtyFlag = false;
        this.upsdevcenterasname2 = null;
    }

    protected void onReset() {
        PSDevSlnSysResBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysResBase pSDevSlnSysResBase) {
        pSDevSlnSysResBase.resetCreateDate();
        pSDevSlnSysResBase.resetCreateMan();
        pSDevSlnSysResBase.resetDB2PSDCDBInstId();
        pSDevSlnSysResBase.resetDB2PSDCDBInstName();
        pSDevSlnSysResBase.resetHBasePSDCBDInstId();
        pSDevSlnSysResBase.resetHBasePSDCBDInstName();
        pSDevSlnSysResBase.resetMemo();
        pSDevSlnSysResBase.resetMSSQLPSDCDBInstId();
        pSDevSlnSysResBase.resetMSSQLPSDCDBInstName();
        pSDevSlnSysResBase.resetMySQLPSDCDBInstId();
        pSDevSlnSysResBase.resetMySQLPSDCDBInstName();
        pSDevSlnSysResBase.resetOraPSDCDBInstId();
        pSDevSlnSysResBase.resetOraPSDCDBInstName();
        pSDevSlnSysResBase.resetPGSQLPSDCDBInstId();
        pSDevSlnSysResBase.resetPGSQLPSDCDBInstName();
        pSDevSlnSysResBase.resetPPASPSDCDBInstId();
        pSDevSlnSysResBase.resetPPASPSDCDBInstName();
        pSDevSlnSysResBase.resetPSDCDeployServerId();
        pSDevSlnSysResBase.resetPSDCDeployServerName();
        pSDevSlnSysResBase.resetPSDevCenterASId();
        pSDevSlnSysResBase.resetPSDevCenterASId2();
        pSDevSlnSysResBase.resetPSDevCenterASName();
        pSDevSlnSysResBase.resetPSDevCenterASName2();
        pSDevSlnSysResBase.resetPSDevCenterSVNId();
        pSDevSlnSysResBase.resetPSDevCenterSVNName();
        pSDevSlnSysResBase.resetPSDevSlnId();
        pSDevSlnSysResBase.resetPSDevSlnName();
        pSDevSlnSysResBase.resetPSDevSlnSysResId();
        pSDevSlnSysResBase.resetPSDevSlnSysResName();
        pSDevSlnSysResBase.resetResInfo();
        pSDevSlnSysResBase.resetResPos();
        pSDevSlnSysResBase.resetROPSDevCenterSvnId();
        pSDevSlnSysResBase.resetROPSDevCenterSvnName();
        pSDevSlnSysResBase.resetUDB2PSDCDBInstId();
        pSDevSlnSysResBase.resetUDB2PSDCDBInstName();
        pSDevSlnSysResBase.resetUHBasePSDCBDInstId();
        pSDevSlnSysResBase.resetUHBasePSDCBDInstName();
        pSDevSlnSysResBase.resetUMSSQLPSDCDBInstId();
        pSDevSlnSysResBase.resetUMSSQLPSDCDBInstName();
        pSDevSlnSysResBase.resetUMySQLPSDCDBInstId();
        pSDevSlnSysResBase.resetUMySQLPSDCDBInstName();
        pSDevSlnSysResBase.resetUOraPSDCDBInstId();
        pSDevSlnSysResBase.resetUOraPSDCDBInstName();
        pSDevSlnSysResBase.resetUpdateDate();
        pSDevSlnSysResBase.resetUpdateMan();
        pSDevSlnSysResBase.resetUPGSQLPSDCDBInstId();
        pSDevSlnSysResBase.resetUPGSQLPSDCDBInstName();
        pSDevSlnSysResBase.resetUPPASPSDCDBInstId();
        pSDevSlnSysResBase.resetUPPASPSDCDBInstName();
        pSDevSlnSysResBase.resetUPSDevCenterASId();
        pSDevSlnSysResBase.resetUPSDevCenterASId2();
        pSDevSlnSysResBase.resetUPSDevCenterASName();
        pSDevSlnSysResBase.resetUPSDevCenterASName2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDB2PSDCDBInstIdDirty()) {
            hashMap.put(FIELD_DB2PSDCDBINSTID, this.getDB2PSDCDBInstId());
        }
        if (!bl || this.isDB2PSDCDBInstNameDirty()) {
            hashMap.put(FIELD_DB2PSDCDBINSTNAME, this.getDB2PSDCDBInstName());
        }
        if (!bl || this.isHBasePSDCBDInstIdDirty()) {
            hashMap.put(FIELD_HBASEPSDCBDINSTID, this.getHBasePSDCBDInstId());
        }
        if (!bl || this.isHBasePSDCBDInstNameDirty()) {
            hashMap.put(FIELD_HBASEPSDCBDINSTNAME, this.getHBasePSDCBDInstName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMSSQLPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_MSSQLPSDCDBINSTID, this.getMSSQLPSDCDBInstId());
        }
        if (!bl || this.isMSSQLPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_MSSQLPSDCDBINSTNAME, this.getMSSQLPSDCDBInstName());
        }
        if (!bl || this.isMySQLPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_MYSQLPSDCDBINSTID, this.getMySQLPSDCDBInstId());
        }
        if (!bl || this.isMySQLPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_MYSQLPSDCDBINSTNAME, this.getMySQLPSDCDBInstName());
        }
        if (!bl || this.isOraPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_ORAPSDCDBINSTID, this.getOraPSDCDBInstId());
        }
        if (!bl || this.isOraPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_ORAPSDCDBINSTNAME, this.getOraPSDCDBInstName());
        }
        if (!bl || this.isPGSQLPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_PGSQLPSDCDBINSTID, this.getPGSQLPSDCDBInstId());
        }
        if (!bl || this.isPGSQLPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_PGSQLPSDCDBINSTNAME, this.getPGSQLPSDCDBInstName());
        }
        if (!bl || this.isPPASPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_PPASPSDCDBINSTID, this.getPPASPSDCDBInstId());
        }
        if (!bl || this.isPPASPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_PPASPSDCDBINSTNAME, this.getPPASPSDCDBInstName());
        }
        if (!bl || this.isPSDCDeployServerIdDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYSERVERID, this.getPSDCDeployServerId());
        }
        if (!bl || this.isPSDCDeployServerNameDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYSERVERNAME, this.getPSDCDeployServerName());
        }
        if (!bl || this.isPSDevCenterASIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERASID, this.getPSDevCenterASId());
        }
        if (!bl || this.isPSDevCenterASId2Dirty()) {
            hashMap.put(FIELD_PSDEVCENTERASID2, this.getPSDevCenterASId2());
        }
        if (!bl || this.isPSDevCenterASNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERASNAME, this.getPSDevCenterASName());
        }
        if (!bl || this.isPSDevCenterASName2Dirty()) {
            hashMap.put(FIELD_PSDEVCENTERASNAME2, this.getPSDevCenterASName2());
        }
        if (!bl || this.isPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNID, this.getPSDevCenterSVNId());
        }
        if (!bl || this.isPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNNAME, this.getPSDevCenterSVNName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnSysResIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSRESID, this.getPSDevSlnSysResId());
        }
        if (!bl || this.isPSDevSlnSysResNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSRESNAME, this.getPSDevSlnSysResName());
        }
        if (!bl || this.isResInfoDirty()) {
            hashMap.put(FIELD_RESINFO, this.getResInfo());
        }
        if (!bl || this.isResPosDirty()) {
            hashMap.put(FIELD_RESPOS, this.getResPos());
        }
        if (!bl || this.isROPSDevCenterSvnIdDirty()) {
            hashMap.put(FIELD_ROPSDEVCENTERSVNID, this.getROPSDevCenterSvnId());
        }
        if (!bl || this.isROPSDevCenterSvnNameDirty()) {
            hashMap.put(FIELD_ROPSDEVCENTERSVNNAME, this.getROPSDevCenterSvnName());
        }
        if (!bl || this.isUDB2PSDCDBInstIdDirty()) {
            hashMap.put(FIELD_UDB2PSDCDBINSTID, this.getUDB2PSDCDBInstId());
        }
        if (!bl || this.isUDB2PSDCDBInstNameDirty()) {
            hashMap.put(FIELD_UDB2PSDCDBINSTNAME, this.getUDB2PSDCDBInstName());
        }
        if (!bl || this.isUHBasePSDCBDInstIdDirty()) {
            hashMap.put(FIELD_UHBASEPSDCBDINSTID, this.getUHBasePSDCBDInstId());
        }
        if (!bl || this.isUHBasePSDCBDInstNameDirty()) {
            hashMap.put(FIELD_UHBASEPSDCBDINSTNAME, this.getUHBasePSDCBDInstName());
        }
        if (!bl || this.isUMSSQLPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_UMSSQLPSDCDBINSTID, this.getUMSSQLPSDCDBInstId());
        }
        if (!bl || this.isUMSSQLPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_UMSSQLPSDCDBINSTNAME, this.getUMSSQLPSDCDBInstName());
        }
        if (!bl || this.isUMySQLPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_UMYSQLPSDCDBINSTID, this.getUMySQLPSDCDBInstId());
        }
        if (!bl || this.isUMySQLPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_UMYSQLPSDCDBINSTNAME, this.getUMySQLPSDCDBInstName());
        }
        if (!bl || this.isUOraPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_UORAPSDCDBINSTID, this.getUOraPSDCDBInstId());
        }
        if (!bl || this.isUOraPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_UORAPSDCDBINSTNAME, this.getUOraPSDCDBInstName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUPGSQLPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_UPGSQLPSDCDBINSTID, this.getUPGSQLPSDCDBInstId());
        }
        if (!bl || this.isUPGSQLPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_UPGSQLPSDCDBINSTNAME, this.getUPGSQLPSDCDBInstName());
        }
        if (!bl || this.isUPPASPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_UPPASPSDCDBINSTID, this.getUPPASPSDCDBInstId());
        }
        if (!bl || this.isUPPASPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_UPPASPSDCDBINSTNAME, this.getUPPASPSDCDBInstName());
        }
        if (!bl || this.isUPSDevCenterASIdDirty()) {
            hashMap.put(FIELD_UPSDEVCENTERASID, this.getUPSDevCenterASId());
        }
        if (!bl || this.isUPSDevCenterASId2Dirty()) {
            hashMap.put(FIELD_UPSDEVCENTERASID2, this.getUPSDevCenterASId2());
        }
        if (!bl || this.isUPSDevCenterASNameDirty()) {
            hashMap.put(FIELD_UPSDEVCENTERASNAME, this.getUPSDevCenterASName());
        }
        if (!bl || this.isUPSDevCenterASName2Dirty()) {
            hashMap.put(FIELD_UPSDEVCENTERASNAME2, this.getUPSDevCenterASName2());
        }
        super.onFillMap(hashMap, bl);
    }

    public Object get(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.get(string);
        }
        return PSDevSlnSysResBase.get(this, n);
    }

    private static Object get(PSDevSlnSysResBase pSDevSlnSysResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysResBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnSysResBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnSysResBase.getDB2PSDCDBInstId();
            }
            case 3: {
                return pSDevSlnSysResBase.getDB2PSDCDBInstName();
            }
            case 4: {
                return pSDevSlnSysResBase.getHBasePSDCBDInstId();
            }
            case 5: {
                return pSDevSlnSysResBase.getHBasePSDCBDInstName();
            }
            case 6: {
                return pSDevSlnSysResBase.getMemo();
            }
            case 7: {
                return pSDevSlnSysResBase.getMSSQLPSDCDBInstId();
            }
            case 8: {
                return pSDevSlnSysResBase.getMSSQLPSDCDBInstName();
            }
            case 9: {
                return pSDevSlnSysResBase.getMySQLPSDCDBInstId();
            }
            case 10: {
                return pSDevSlnSysResBase.getMySQLPSDCDBInstName();
            }
            case 11: {
                return pSDevSlnSysResBase.getOraPSDCDBInstId();
            }
            case 12: {
                return pSDevSlnSysResBase.getOraPSDCDBInstName();
            }
            case 13: {
                return pSDevSlnSysResBase.getPGSQLPSDCDBInstId();
            }
            case 14: {
                return pSDevSlnSysResBase.getPGSQLPSDCDBInstName();
            }
            case 15: {
                return pSDevSlnSysResBase.getPPASPSDCDBInstId();
            }
            case 16: {
                return pSDevSlnSysResBase.getPPASPSDCDBInstName();
            }
            case 17: {
                return pSDevSlnSysResBase.getPSDCDeployServerId();
            }
            case 18: {
                return pSDevSlnSysResBase.getPSDCDeployServerName();
            }
            case 19: {
                return pSDevSlnSysResBase.getPSDevCenterASId();
            }
            case 20: {
                return pSDevSlnSysResBase.getPSDevCenterASId2();
            }
            case 21: {
                return pSDevSlnSysResBase.getPSDevCenterASName();
            }
            case 22: {
                return pSDevSlnSysResBase.getPSDevCenterASName2();
            }
            case 23: {
                return pSDevSlnSysResBase.getPSDevCenterSVNId();
            }
            case 24: {
                return pSDevSlnSysResBase.getPSDevCenterSVNName();
            }
            case 25: {
                return pSDevSlnSysResBase.getPSDevSlnId();
            }
            case 26: {
                return pSDevSlnSysResBase.getPSDevSlnName();
            }
            case 27: {
                return pSDevSlnSysResBase.getPSDevSlnSysResId();
            }
            case 28: {
                return pSDevSlnSysResBase.getPSDevSlnSysResName();
            }
            case 29: {
                return pSDevSlnSysResBase.getResInfo();
            }
            case 30: {
                return pSDevSlnSysResBase.getResPos();
            }
            case 31: {
                return pSDevSlnSysResBase.getROPSDevCenterSvnId();
            }
            case 32: {
                return pSDevSlnSysResBase.getROPSDevCenterSvnName();
            }
            case 33: {
                return pSDevSlnSysResBase.getUDB2PSDCDBInstId();
            }
            case 34: {
                return pSDevSlnSysResBase.getUDB2PSDCDBInstName();
            }
            case 35: {
                return pSDevSlnSysResBase.getUHBasePSDCBDInstId();
            }
            case 36: {
                return pSDevSlnSysResBase.getUHBasePSDCBDInstName();
            }
            case 37: {
                return pSDevSlnSysResBase.getUMSSQLPSDCDBInstId();
            }
            case 38: {
                return pSDevSlnSysResBase.getUMSSQLPSDCDBInstName();
            }
            case 39: {
                return pSDevSlnSysResBase.getUMySQLPSDCDBInstId();
            }
            case 40: {
                return pSDevSlnSysResBase.getUMySQLPSDCDBInstName();
            }
            case 41: {
                return pSDevSlnSysResBase.getUOraPSDCDBInstId();
            }
            case 42: {
                return pSDevSlnSysResBase.getUOraPSDCDBInstName();
            }
            case 43: {
                return pSDevSlnSysResBase.getUpdateDate();
            }
            case 44: {
                return pSDevSlnSysResBase.getUpdateMan();
            }
            case 45: {
                return pSDevSlnSysResBase.getUPGSQLPSDCDBInstId();
            }
            case 46: {
                return pSDevSlnSysResBase.getUPGSQLPSDCDBInstName();
            }
            case 47: {
                return pSDevSlnSysResBase.getUPPASPSDCDBInstId();
            }
            case 48: {
                return pSDevSlnSysResBase.getUPPASPSDCDBInstName();
            }
            case 49: {
                return pSDevSlnSysResBase.getUPSDevCenterASId();
            }
            case 50: {
                return pSDevSlnSysResBase.getUPSDevCenterASId2();
            }
            case 51: {
                return pSDevSlnSysResBase.getUPSDevCenterASName();
            }
            case 52: {
                return pSDevSlnSysResBase.getUPSDevCenterASName2();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public void set(String string, Object object) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(string, object);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            super.set(string, object);
            return;
        }
        PSDevSlnSysResBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysResBase pSDevSlnSysResBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysResBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysResBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysResBase.setDB2PSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysResBase.setDB2PSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysResBase.setHBasePSDCBDInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysResBase.setHBasePSDCBDInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysResBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysResBase.setMSSQLPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysResBase.setMSSQLPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysResBase.setMySQLPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysResBase.setMySQLPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysResBase.setOraPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysResBase.setOraPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysResBase.setPGSQLPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnSysResBase.setPGSQLPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnSysResBase.setPPASPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnSysResBase.setPPASPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnSysResBase.setPSDCDeployServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnSysResBase.setPSDCDeployServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnSysResBase.setPSDevCenterASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnSysResBase.setPSDevCenterASId2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnSysResBase.setPSDevCenterASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnSysResBase.setPSDevCenterASName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnSysResBase.setPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnSysResBase.setPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnSysResBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnSysResBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnSysResBase.setPSDevSlnSysResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnSysResBase.setPSDevSlnSysResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnSysResBase.setResInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevSlnSysResBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDevSlnSysResBase.setROPSDevCenterSvnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevSlnSysResBase.setROPSDevCenterSvnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevSlnSysResBase.setUDB2PSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevSlnSysResBase.setUDB2PSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDevSlnSysResBase.setUHBasePSDCBDInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDevSlnSysResBase.setUHBasePSDCBDInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDevSlnSysResBase.setUMSSQLPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDevSlnSysResBase.setUMSSQLPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDevSlnSysResBase.setUMySQLPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDevSlnSysResBase.setUMySQLPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDevSlnSysResBase.setUOraPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDevSlnSysResBase.setUOraPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDevSlnSysResBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 44: {
                pSDevSlnSysResBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDevSlnSysResBase.setUPGSQLPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDevSlnSysResBase.setUPGSQLPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDevSlnSysResBase.setUPPASPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDevSlnSysResBase.setUPPASPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDevSlnSysResBase.setUPSDevCenterASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDevSlnSysResBase.setUPSDevCenterASId2(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDevSlnSysResBase.setUPSDevCenterASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDevSlnSysResBase.setUPSDevCenterASName2(DataObject.getStringValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean isNull(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.isNull(string);
        }
        return PSDevSlnSysResBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysResBase pSDevSlnSysResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysResBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnSysResBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnSysResBase.getDB2PSDCDBInstId() == null;
            }
            case 3: {
                return pSDevSlnSysResBase.getDB2PSDCDBInstName() == null;
            }
            case 4: {
                return pSDevSlnSysResBase.getHBasePSDCBDInstId() == null;
            }
            case 5: {
                return pSDevSlnSysResBase.getHBasePSDCBDInstName() == null;
            }
            case 6: {
                return pSDevSlnSysResBase.getMemo() == null;
            }
            case 7: {
                return pSDevSlnSysResBase.getMSSQLPSDCDBInstId() == null;
            }
            case 8: {
                return pSDevSlnSysResBase.getMSSQLPSDCDBInstName() == null;
            }
            case 9: {
                return pSDevSlnSysResBase.getMySQLPSDCDBInstId() == null;
            }
            case 10: {
                return pSDevSlnSysResBase.getMySQLPSDCDBInstName() == null;
            }
            case 11: {
                return pSDevSlnSysResBase.getOraPSDCDBInstId() == null;
            }
            case 12: {
                return pSDevSlnSysResBase.getOraPSDCDBInstName() == null;
            }
            case 13: {
                return pSDevSlnSysResBase.getPGSQLPSDCDBInstId() == null;
            }
            case 14: {
                return pSDevSlnSysResBase.getPGSQLPSDCDBInstName() == null;
            }
            case 15: {
                return pSDevSlnSysResBase.getPPASPSDCDBInstId() == null;
            }
            case 16: {
                return pSDevSlnSysResBase.getPPASPSDCDBInstName() == null;
            }
            case 17: {
                return pSDevSlnSysResBase.getPSDCDeployServerId() == null;
            }
            case 18: {
                return pSDevSlnSysResBase.getPSDCDeployServerName() == null;
            }
            case 19: {
                return pSDevSlnSysResBase.getPSDevCenterASId() == null;
            }
            case 20: {
                return pSDevSlnSysResBase.getPSDevCenterASId2() == null;
            }
            case 21: {
                return pSDevSlnSysResBase.getPSDevCenterASName() == null;
            }
            case 22: {
                return pSDevSlnSysResBase.getPSDevCenterASName2() == null;
            }
            case 23: {
                return pSDevSlnSysResBase.getPSDevCenterSVNId() == null;
            }
            case 24: {
                return pSDevSlnSysResBase.getPSDevCenterSVNName() == null;
            }
            case 25: {
                return pSDevSlnSysResBase.getPSDevSlnId() == null;
            }
            case 26: {
                return pSDevSlnSysResBase.getPSDevSlnName() == null;
            }
            case 27: {
                return pSDevSlnSysResBase.getPSDevSlnSysResId() == null;
            }
            case 28: {
                return pSDevSlnSysResBase.getPSDevSlnSysResName() == null;
            }
            case 29: {
                return pSDevSlnSysResBase.getResInfo() == null;
            }
            case 30: {
                return pSDevSlnSysResBase.getResPos() == null;
            }
            case 31: {
                return pSDevSlnSysResBase.getROPSDevCenterSvnId() == null;
            }
            case 32: {
                return pSDevSlnSysResBase.getROPSDevCenterSvnName() == null;
            }
            case 33: {
                return pSDevSlnSysResBase.getUDB2PSDCDBInstId() == null;
            }
            case 34: {
                return pSDevSlnSysResBase.getUDB2PSDCDBInstName() == null;
            }
            case 35: {
                return pSDevSlnSysResBase.getUHBasePSDCBDInstId() == null;
            }
            case 36: {
                return pSDevSlnSysResBase.getUHBasePSDCBDInstName() == null;
            }
            case 37: {
                return pSDevSlnSysResBase.getUMSSQLPSDCDBInstId() == null;
            }
            case 38: {
                return pSDevSlnSysResBase.getUMSSQLPSDCDBInstName() == null;
            }
            case 39: {
                return pSDevSlnSysResBase.getUMySQLPSDCDBInstId() == null;
            }
            case 40: {
                return pSDevSlnSysResBase.getUMySQLPSDCDBInstName() == null;
            }
            case 41: {
                return pSDevSlnSysResBase.getUOraPSDCDBInstId() == null;
            }
            case 42: {
                return pSDevSlnSysResBase.getUOraPSDCDBInstName() == null;
            }
            case 43: {
                return pSDevSlnSysResBase.getUpdateDate() == null;
            }
            case 44: {
                return pSDevSlnSysResBase.getUpdateMan() == null;
            }
            case 45: {
                return pSDevSlnSysResBase.getUPGSQLPSDCDBInstId() == null;
            }
            case 46: {
                return pSDevSlnSysResBase.getUPGSQLPSDCDBInstName() == null;
            }
            case 47: {
                return pSDevSlnSysResBase.getUPPASPSDCDBInstId() == null;
            }
            case 48: {
                return pSDevSlnSysResBase.getUPPASPSDCDBInstName() == null;
            }
            case 49: {
                return pSDevSlnSysResBase.getUPSDevCenterASId() == null;
            }
            case 50: {
                return pSDevSlnSysResBase.getUPSDevCenterASId2() == null;
            }
            case 51: {
                return pSDevSlnSysResBase.getUPSDevCenterASName() == null;
            }
            case 52: {
                return pSDevSlnSysResBase.getUPSDevCenterASName2() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean contains(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.contains(string);
        }
        return PSDevSlnSysResBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysResBase pSDevSlnSysResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysResBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnSysResBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnSysResBase.isDB2PSDCDBInstIdDirty();
            }
            case 3: {
                return pSDevSlnSysResBase.isDB2PSDCDBInstNameDirty();
            }
            case 4: {
                return pSDevSlnSysResBase.isHBasePSDCBDInstIdDirty();
            }
            case 5: {
                return pSDevSlnSysResBase.isHBasePSDCBDInstNameDirty();
            }
            case 6: {
                return pSDevSlnSysResBase.isMemoDirty();
            }
            case 7: {
                return pSDevSlnSysResBase.isMSSQLPSDCDBInstIdDirty();
            }
            case 8: {
                return pSDevSlnSysResBase.isMSSQLPSDCDBInstNameDirty();
            }
            case 9: {
                return pSDevSlnSysResBase.isMySQLPSDCDBInstIdDirty();
            }
            case 10: {
                return pSDevSlnSysResBase.isMySQLPSDCDBInstNameDirty();
            }
            case 11: {
                return pSDevSlnSysResBase.isOraPSDCDBInstIdDirty();
            }
            case 12: {
                return pSDevSlnSysResBase.isOraPSDCDBInstNameDirty();
            }
            case 13: {
                return pSDevSlnSysResBase.isPGSQLPSDCDBInstIdDirty();
            }
            case 14: {
                return pSDevSlnSysResBase.isPGSQLPSDCDBInstNameDirty();
            }
            case 15: {
                return pSDevSlnSysResBase.isPPASPSDCDBInstIdDirty();
            }
            case 16: {
                return pSDevSlnSysResBase.isPPASPSDCDBInstNameDirty();
            }
            case 17: {
                return pSDevSlnSysResBase.isPSDCDeployServerIdDirty();
            }
            case 18: {
                return pSDevSlnSysResBase.isPSDCDeployServerNameDirty();
            }
            case 19: {
                return pSDevSlnSysResBase.isPSDevCenterASIdDirty();
            }
            case 20: {
                return pSDevSlnSysResBase.isPSDevCenterASId2Dirty();
            }
            case 21: {
                return pSDevSlnSysResBase.isPSDevCenterASNameDirty();
            }
            case 22: {
                return pSDevSlnSysResBase.isPSDevCenterASName2Dirty();
            }
            case 23: {
                return pSDevSlnSysResBase.isPSDevCenterSVNIdDirty();
            }
            case 24: {
                return pSDevSlnSysResBase.isPSDevCenterSVNNameDirty();
            }
            case 25: {
                return pSDevSlnSysResBase.isPSDevSlnIdDirty();
            }
            case 26: {
                return pSDevSlnSysResBase.isPSDevSlnNameDirty();
            }
            case 27: {
                return pSDevSlnSysResBase.isPSDevSlnSysResIdDirty();
            }
            case 28: {
                return pSDevSlnSysResBase.isPSDevSlnSysResNameDirty();
            }
            case 29: {
                return pSDevSlnSysResBase.isResInfoDirty();
            }
            case 30: {
                return pSDevSlnSysResBase.isResPosDirty();
            }
            case 31: {
                return pSDevSlnSysResBase.isROPSDevCenterSvnIdDirty();
            }
            case 32: {
                return pSDevSlnSysResBase.isROPSDevCenterSvnNameDirty();
            }
            case 33: {
                return pSDevSlnSysResBase.isUDB2PSDCDBInstIdDirty();
            }
            case 34: {
                return pSDevSlnSysResBase.isUDB2PSDCDBInstNameDirty();
            }
            case 35: {
                return pSDevSlnSysResBase.isUHBasePSDCBDInstIdDirty();
            }
            case 36: {
                return pSDevSlnSysResBase.isUHBasePSDCBDInstNameDirty();
            }
            case 37: {
                return pSDevSlnSysResBase.isUMSSQLPSDCDBInstIdDirty();
            }
            case 38: {
                return pSDevSlnSysResBase.isUMSSQLPSDCDBInstNameDirty();
            }
            case 39: {
                return pSDevSlnSysResBase.isUMySQLPSDCDBInstIdDirty();
            }
            case 40: {
                return pSDevSlnSysResBase.isUMySQLPSDCDBInstNameDirty();
            }
            case 41: {
                return pSDevSlnSysResBase.isUOraPSDCDBInstIdDirty();
            }
            case 42: {
                return pSDevSlnSysResBase.isUOraPSDCDBInstNameDirty();
            }
            case 43: {
                return pSDevSlnSysResBase.isUpdateDateDirty();
            }
            case 44: {
                return pSDevSlnSysResBase.isUpdateManDirty();
            }
            case 45: {
                return pSDevSlnSysResBase.isUPGSQLPSDCDBInstIdDirty();
            }
            case 46: {
                return pSDevSlnSysResBase.isUPGSQLPSDCDBInstNameDirty();
            }
            case 47: {
                return pSDevSlnSysResBase.isUPPASPSDCDBInstIdDirty();
            }
            case 48: {
                return pSDevSlnSysResBase.isUPPASPSDCDBInstNameDirty();
            }
            case 49: {
                return pSDevSlnSysResBase.isUPSDevCenterASIdDirty();
            }
            case 50: {
                return pSDevSlnSysResBase.isUPSDevCenterASId2Dirty();
            }
            case 51: {
                return pSDevSlnSysResBase.isUPSDevCenterASNameDirty();
            }
            case 52: {
                return pSDevSlnSysResBase.isUPSDevCenterASName2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysResBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysResBase pSDevSlnSysResBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysResBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getDB2PSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"db2psdcdbinstid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getDB2PSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getDB2PSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"db2psdcdbinstname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getDB2PSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getHBasePSDCBDInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hbasepsdcbdinstid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getHBasePSDCBDInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getHBasePSDCBDInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hbasepsdcbdinstname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getHBasePSDCBDInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getMSSQLPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mssqlpsdcdbinstid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getMSSQLPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getMSSQLPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mssqlpsdcdbinstname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getMSSQLPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getMySQLPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mysqlpsdcdbinstid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getMySQLPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getMySQLPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mysqlpsdcdbinstname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getMySQLPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getOraPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"orapsdcdbinstid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getOraPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getOraPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"orapsdcdbinstname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getOraPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPGSQLPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pgsqlpsdcdbinstid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPGSQLPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPGSQLPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pgsqlpsdcdbinstname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPGSQLPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPPASPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppaspsdcdbinstid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPPASPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPPASPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppaspsdcdbinstname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPPASPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPSDCDeployServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeployserverid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPSDCDeployServerId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPSDCDeployServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeployservername", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPSDCDeployServerName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPSDevCenterASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPSDevCenterASId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPSDevCenterASId2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasid2", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPSDevCenterASId2()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPSDevCenterASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPSDevCenterASName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPSDevCenterASName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasname2", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPSDevCenterASName2()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPSDevSlnSysResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysresid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPSDevSlnSysResId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getPSDevSlnSysResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysresname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getPSDevSlnSysResName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getResInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resinfo", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getResInfo()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getResPos()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getROPSDevCenterSvnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropsdevcentersvnid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getROPSDevCenterSvnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getROPSDevCenterSvnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ropsdevcentersvnname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getROPSDevCenterSvnName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUDB2PSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"udb2psdcdbinstid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUDB2PSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUDB2PSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"udb2psdcdbinstname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUDB2PSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUHBasePSDCBDInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uhbasepsdcbdinstid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUHBasePSDCBDInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUHBasePSDCBDInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uhbasepsdcbdinstname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUHBasePSDCBDInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUMSSQLPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"umssqlpsdcdbinstid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUMSSQLPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUMSSQLPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"umssqlpsdcdbinstname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUMSSQLPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUMySQLPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"umysqlpsdcdbinstid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUMySQLPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUMySQLPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"umysqlpsdcdbinstname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUMySQLPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUOraPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uorapsdcdbinstid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUOraPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUOraPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uorapsdcdbinstname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUOraPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUPGSQLPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"upgsqlpsdcdbinstid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUPGSQLPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUPGSQLPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"upgsqlpsdcdbinstname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUPGSQLPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUPPASPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uppaspsdcdbinstid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUPPASPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUPPASPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uppaspsdcdbinstname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUPPASPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUPSDevCenterASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"upsdevcenterasid", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUPSDevCenterASId()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUPSDevCenterASId2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"upsdevcenterasid2", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUPSDevCenterASId2()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUPSDevCenterASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"upsdevcenterasname", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUPSDevCenterASName()), (boolean)false);
        }
        if (bl || pSDevSlnSysResBase.getUPSDevCenterASName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"upsdevcenterasname2", (Object)PSDevSlnSysResBase.getJSONValue((Object)pSDevSlnSysResBase.getUPSDevCenterASName2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysResBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysResBase pSDevSlnSysResBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysResBase.getCreateDate() != null) {
            object = pSDevSlnSysResBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysResBase.getCreateMan() != null) {
            object = pSDevSlnSysResBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getDB2PSDCDBInstId() != null) {
            object = pSDevSlnSysResBase.getDB2PSDCDBInstId();
            xmlNode.setAttribute(FIELD_DB2PSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getDB2PSDCDBInstName() != null) {
            object = pSDevSlnSysResBase.getDB2PSDCDBInstName();
            xmlNode.setAttribute(FIELD_DB2PSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getHBasePSDCBDInstId() != null) {
            object = pSDevSlnSysResBase.getHBasePSDCBDInstId();
            xmlNode.setAttribute(FIELD_HBASEPSDCBDINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getHBasePSDCBDInstName() != null) {
            object = pSDevSlnSysResBase.getHBasePSDCBDInstName();
            xmlNode.setAttribute(FIELD_HBASEPSDCBDINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getMemo() != null) {
            object = pSDevSlnSysResBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getMSSQLPSDCDBInstId() != null) {
            object = pSDevSlnSysResBase.getMSSQLPSDCDBInstId();
            xmlNode.setAttribute(FIELD_MSSQLPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getMSSQLPSDCDBInstName() != null) {
            object = pSDevSlnSysResBase.getMSSQLPSDCDBInstName();
            xmlNode.setAttribute(FIELD_MSSQLPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getMySQLPSDCDBInstId() != null) {
            object = pSDevSlnSysResBase.getMySQLPSDCDBInstId();
            xmlNode.setAttribute(FIELD_MYSQLPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getMySQLPSDCDBInstName() != null) {
            object = pSDevSlnSysResBase.getMySQLPSDCDBInstName();
            xmlNode.setAttribute(FIELD_MYSQLPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getOraPSDCDBInstId() != null) {
            object = pSDevSlnSysResBase.getOraPSDCDBInstId();
            xmlNode.setAttribute(FIELD_ORAPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getOraPSDCDBInstName() != null) {
            object = pSDevSlnSysResBase.getOraPSDCDBInstName();
            xmlNode.setAttribute(FIELD_ORAPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPGSQLPSDCDBInstId() != null) {
            object = pSDevSlnSysResBase.getPGSQLPSDCDBInstId();
            xmlNode.setAttribute(FIELD_PGSQLPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPGSQLPSDCDBInstName() != null) {
            object = pSDevSlnSysResBase.getPGSQLPSDCDBInstName();
            xmlNode.setAttribute(FIELD_PGSQLPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPPASPSDCDBInstId() != null) {
            object = pSDevSlnSysResBase.getPPASPSDCDBInstId();
            xmlNode.setAttribute(FIELD_PPASPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPPASPSDCDBInstName() != null) {
            object = pSDevSlnSysResBase.getPPASPSDCDBInstName();
            xmlNode.setAttribute(FIELD_PPASPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPSDCDeployServerId() != null) {
            object = pSDevSlnSysResBase.getPSDCDeployServerId();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPSDCDeployServerName() != null) {
            object = pSDevSlnSysResBase.getPSDCDeployServerName();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPSDevCenterASId() != null) {
            object = pSDevSlnSysResBase.getPSDevCenterASId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPSDevCenterASId2() != null) {
            object = pSDevSlnSysResBase.getPSDevCenterASId2();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASID2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPSDevCenterASName() != null) {
            object = pSDevSlnSysResBase.getPSDevCenterASName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPSDevCenterASName2() != null) {
            object = pSDevSlnSysResBase.getPSDevCenterASName2();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASNAME2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPSDevCenterSVNId() != null) {
            object = pSDevSlnSysResBase.getPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPSDevCenterSVNName() != null) {
            object = pSDevSlnSysResBase.getPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPSDevSlnId() != null) {
            object = pSDevSlnSysResBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPSDevSlnName() != null) {
            object = pSDevSlnSysResBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPSDevSlnSysResId() != null) {
            object = pSDevSlnSysResBase.getPSDevSlnSysResId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getPSDevSlnSysResName() != null) {
            object = pSDevSlnSysResBase.getPSDevSlnSysResName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getResInfo() != null) {
            object = pSDevSlnSysResBase.getResInfo();
            xmlNode.setAttribute(FIELD_RESINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getResPos() != null) {
            object = pSDevSlnSysResBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysResBase.getROPSDevCenterSvnId() != null) {
            object = pSDevSlnSysResBase.getROPSDevCenterSvnId();
            xmlNode.setAttribute(FIELD_ROPSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getROPSDevCenterSvnName() != null) {
            object = pSDevSlnSysResBase.getROPSDevCenterSvnName();
            xmlNode.setAttribute(FIELD_ROPSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUDB2PSDCDBInstId() != null) {
            object = pSDevSlnSysResBase.getUDB2PSDCDBInstId();
            xmlNode.setAttribute(FIELD_UDB2PSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUDB2PSDCDBInstName() != null) {
            object = pSDevSlnSysResBase.getUDB2PSDCDBInstName();
            xmlNode.setAttribute(FIELD_UDB2PSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUHBasePSDCBDInstId() != null) {
            object = pSDevSlnSysResBase.getUHBasePSDCBDInstId();
            xmlNode.setAttribute(FIELD_UHBASEPSDCBDINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUHBasePSDCBDInstName() != null) {
            object = pSDevSlnSysResBase.getUHBasePSDCBDInstName();
            xmlNode.setAttribute(FIELD_UHBASEPSDCBDINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUMSSQLPSDCDBInstId() != null) {
            object = pSDevSlnSysResBase.getUMSSQLPSDCDBInstId();
            xmlNode.setAttribute(FIELD_UMSSQLPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUMSSQLPSDCDBInstName() != null) {
            object = pSDevSlnSysResBase.getUMSSQLPSDCDBInstName();
            xmlNode.setAttribute(FIELD_UMSSQLPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUMySQLPSDCDBInstId() != null) {
            object = pSDevSlnSysResBase.getUMySQLPSDCDBInstId();
            xmlNode.setAttribute(FIELD_UMYSQLPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUMySQLPSDCDBInstName() != null) {
            object = pSDevSlnSysResBase.getUMySQLPSDCDBInstName();
            xmlNode.setAttribute(FIELD_UMYSQLPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUOraPSDCDBInstId() != null) {
            object = pSDevSlnSysResBase.getUOraPSDCDBInstId();
            xmlNode.setAttribute(FIELD_UORAPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUOraPSDCDBInstName() != null) {
            object = pSDevSlnSysResBase.getUOraPSDCDBInstName();
            xmlNode.setAttribute(FIELD_UORAPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUpdateDate() != null) {
            object = pSDevSlnSysResBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysResBase.getUpdateMan() != null) {
            object = pSDevSlnSysResBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUPGSQLPSDCDBInstId() != null) {
            object = pSDevSlnSysResBase.getUPGSQLPSDCDBInstId();
            xmlNode.setAttribute(FIELD_UPGSQLPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUPGSQLPSDCDBInstName() != null) {
            object = pSDevSlnSysResBase.getUPGSQLPSDCDBInstName();
            xmlNode.setAttribute(FIELD_UPGSQLPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUPPASPSDCDBInstId() != null) {
            object = pSDevSlnSysResBase.getUPPASPSDCDBInstId();
            xmlNode.setAttribute(FIELD_UPPASPSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUPPASPSDCDBInstName() != null) {
            object = pSDevSlnSysResBase.getUPPASPSDCDBInstName();
            xmlNode.setAttribute(FIELD_UPPASPSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUPSDevCenterASId() != null) {
            object = pSDevSlnSysResBase.getUPSDevCenterASId();
            xmlNode.setAttribute(FIELD_UPSDEVCENTERASID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUPSDevCenterASId2() != null) {
            object = pSDevSlnSysResBase.getUPSDevCenterASId2();
            xmlNode.setAttribute(FIELD_UPSDEVCENTERASID2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUPSDevCenterASName() != null) {
            object = pSDevSlnSysResBase.getUPSDevCenterASName();
            xmlNode.setAttribute(FIELD_UPSDEVCENTERASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysResBase.getUPSDevCenterASName2() != null) {
            object = pSDevSlnSysResBase.getUPSDevCenterASName2();
            xmlNode.setAttribute(FIELD_UPSDEVCENTERASNAME2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysResBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysResBase pSDevSlnSysResBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysResBase.isCreateDateDirty() && (bl || pSDevSlnSysResBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysResBase.getCreateDate());
        }
        if (pSDevSlnSysResBase.isCreateManDirty() && (bl || pSDevSlnSysResBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysResBase.getCreateMan());
        }
        if (pSDevSlnSysResBase.isDB2PSDCDBInstIdDirty() && (bl || pSDevSlnSysResBase.getDB2PSDCDBInstId() != null)) {
            iDataObject.set(FIELD_DB2PSDCDBINSTID, (Object)pSDevSlnSysResBase.getDB2PSDCDBInstId());
        }
        if (pSDevSlnSysResBase.isDB2PSDCDBInstNameDirty() && (bl || pSDevSlnSysResBase.getDB2PSDCDBInstName() != null)) {
            iDataObject.set(FIELD_DB2PSDCDBINSTNAME, (Object)pSDevSlnSysResBase.getDB2PSDCDBInstName());
        }
        if (pSDevSlnSysResBase.isHBasePSDCBDInstIdDirty() && (bl || pSDevSlnSysResBase.getHBasePSDCBDInstId() != null)) {
            iDataObject.set(FIELD_HBASEPSDCBDINSTID, (Object)pSDevSlnSysResBase.getHBasePSDCBDInstId());
        }
        if (pSDevSlnSysResBase.isHBasePSDCBDInstNameDirty() && (bl || pSDevSlnSysResBase.getHBasePSDCBDInstName() != null)) {
            iDataObject.set(FIELD_HBASEPSDCBDINSTNAME, (Object)pSDevSlnSysResBase.getHBasePSDCBDInstName());
        }
        if (pSDevSlnSysResBase.isMemoDirty() && (bl || pSDevSlnSysResBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysResBase.getMemo());
        }
        if (pSDevSlnSysResBase.isMSSQLPSDCDBInstIdDirty() && (bl || pSDevSlnSysResBase.getMSSQLPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_MSSQLPSDCDBINSTID, (Object)pSDevSlnSysResBase.getMSSQLPSDCDBInstId());
        }
        if (pSDevSlnSysResBase.isMSSQLPSDCDBInstNameDirty() && (bl || pSDevSlnSysResBase.getMSSQLPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_MSSQLPSDCDBINSTNAME, (Object)pSDevSlnSysResBase.getMSSQLPSDCDBInstName());
        }
        if (pSDevSlnSysResBase.isMySQLPSDCDBInstIdDirty() && (bl || pSDevSlnSysResBase.getMySQLPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_MYSQLPSDCDBINSTID, (Object)pSDevSlnSysResBase.getMySQLPSDCDBInstId());
        }
        if (pSDevSlnSysResBase.isMySQLPSDCDBInstNameDirty() && (bl || pSDevSlnSysResBase.getMySQLPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_MYSQLPSDCDBINSTNAME, (Object)pSDevSlnSysResBase.getMySQLPSDCDBInstName());
        }
        if (pSDevSlnSysResBase.isOraPSDCDBInstIdDirty() && (bl || pSDevSlnSysResBase.getOraPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_ORAPSDCDBINSTID, (Object)pSDevSlnSysResBase.getOraPSDCDBInstId());
        }
        if (pSDevSlnSysResBase.isOraPSDCDBInstNameDirty() && (bl || pSDevSlnSysResBase.getOraPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_ORAPSDCDBINSTNAME, (Object)pSDevSlnSysResBase.getOraPSDCDBInstName());
        }
        if (pSDevSlnSysResBase.isPGSQLPSDCDBInstIdDirty() && (bl || pSDevSlnSysResBase.getPGSQLPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_PGSQLPSDCDBINSTID, (Object)pSDevSlnSysResBase.getPGSQLPSDCDBInstId());
        }
        if (pSDevSlnSysResBase.isPGSQLPSDCDBInstNameDirty() && (bl || pSDevSlnSysResBase.getPGSQLPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_PGSQLPSDCDBINSTNAME, (Object)pSDevSlnSysResBase.getPGSQLPSDCDBInstName());
        }
        if (pSDevSlnSysResBase.isPPASPSDCDBInstIdDirty() && (bl || pSDevSlnSysResBase.getPPASPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_PPASPSDCDBINSTID, (Object)pSDevSlnSysResBase.getPPASPSDCDBInstId());
        }
        if (pSDevSlnSysResBase.isPPASPSDCDBInstNameDirty() && (bl || pSDevSlnSysResBase.getPPASPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_PPASPSDCDBINSTNAME, (Object)pSDevSlnSysResBase.getPPASPSDCDBInstName());
        }
        if (pSDevSlnSysResBase.isPSDCDeployServerIdDirty() && (bl || pSDevSlnSysResBase.getPSDCDeployServerId() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYSERVERID, (Object)pSDevSlnSysResBase.getPSDCDeployServerId());
        }
        if (pSDevSlnSysResBase.isPSDCDeployServerNameDirty() && (bl || pSDevSlnSysResBase.getPSDCDeployServerName() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYSERVERNAME, (Object)pSDevSlnSysResBase.getPSDCDeployServerName());
        }
        if (pSDevSlnSysResBase.isPSDevCenterASIdDirty() && (bl || pSDevSlnSysResBase.getPSDevCenterASId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASID, (Object)pSDevSlnSysResBase.getPSDevCenterASId());
        }
        if (pSDevSlnSysResBase.isPSDevCenterASId2Dirty() && (bl || pSDevSlnSysResBase.getPSDevCenterASId2() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASID2, (Object)pSDevSlnSysResBase.getPSDevCenterASId2());
        }
        if (pSDevSlnSysResBase.isPSDevCenterASNameDirty() && (bl || pSDevSlnSysResBase.getPSDevCenterASName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASNAME, (Object)pSDevSlnSysResBase.getPSDevCenterASName());
        }
        if (pSDevSlnSysResBase.isPSDevCenterASName2Dirty() && (bl || pSDevSlnSysResBase.getPSDevCenterASName2() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASNAME2, (Object)pSDevSlnSysResBase.getPSDevCenterASName2());
        }
        if (pSDevSlnSysResBase.isPSDevCenterSVNIdDirty() && (bl || pSDevSlnSysResBase.getPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNID, (Object)pSDevSlnSysResBase.getPSDevCenterSVNId());
        }
        if (pSDevSlnSysResBase.isPSDevCenterSVNNameDirty() && (bl || pSDevSlnSysResBase.getPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNNAME, (Object)pSDevSlnSysResBase.getPSDevCenterSVNName());
        }
        if (pSDevSlnSysResBase.isPSDevSlnIdDirty() && (bl || pSDevSlnSysResBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnSysResBase.getPSDevSlnId());
        }
        if (pSDevSlnSysResBase.isPSDevSlnNameDirty() && (bl || pSDevSlnSysResBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnSysResBase.getPSDevSlnName());
        }
        if (pSDevSlnSysResBase.isPSDevSlnSysResIdDirty() && (bl || pSDevSlnSysResBase.getPSDevSlnSysResId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSRESID, (Object)pSDevSlnSysResBase.getPSDevSlnSysResId());
        }
        if (pSDevSlnSysResBase.isPSDevSlnSysResNameDirty() && (bl || pSDevSlnSysResBase.getPSDevSlnSysResName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSRESNAME, (Object)pSDevSlnSysResBase.getPSDevSlnSysResName());
        }
        if (pSDevSlnSysResBase.isResInfoDirty() && (bl || pSDevSlnSysResBase.getResInfo() != null)) {
            iDataObject.set(FIELD_RESINFO, (Object)pSDevSlnSysResBase.getResInfo());
        }
        if (pSDevSlnSysResBase.isResPosDirty() && (bl || pSDevSlnSysResBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDevSlnSysResBase.getResPos());
        }
        if (pSDevSlnSysResBase.isROPSDevCenterSvnIdDirty() && (bl || pSDevSlnSysResBase.getROPSDevCenterSvnId() != null)) {
            iDataObject.set(FIELD_ROPSDEVCENTERSVNID, (Object)pSDevSlnSysResBase.getROPSDevCenterSvnId());
        }
        if (pSDevSlnSysResBase.isROPSDevCenterSvnNameDirty() && (bl || pSDevSlnSysResBase.getROPSDevCenterSvnName() != null)) {
            iDataObject.set(FIELD_ROPSDEVCENTERSVNNAME, (Object)pSDevSlnSysResBase.getROPSDevCenterSvnName());
        }
        if (pSDevSlnSysResBase.isUDB2PSDCDBInstIdDirty() && (bl || pSDevSlnSysResBase.getUDB2PSDCDBInstId() != null)) {
            iDataObject.set(FIELD_UDB2PSDCDBINSTID, (Object)pSDevSlnSysResBase.getUDB2PSDCDBInstId());
        }
        if (pSDevSlnSysResBase.isUDB2PSDCDBInstNameDirty() && (bl || pSDevSlnSysResBase.getUDB2PSDCDBInstName() != null)) {
            iDataObject.set(FIELD_UDB2PSDCDBINSTNAME, (Object)pSDevSlnSysResBase.getUDB2PSDCDBInstName());
        }
        if (pSDevSlnSysResBase.isUHBasePSDCBDInstIdDirty() && (bl || pSDevSlnSysResBase.getUHBasePSDCBDInstId() != null)) {
            iDataObject.set(FIELD_UHBASEPSDCBDINSTID, (Object)pSDevSlnSysResBase.getUHBasePSDCBDInstId());
        }
        if (pSDevSlnSysResBase.isUHBasePSDCBDInstNameDirty() && (bl || pSDevSlnSysResBase.getUHBasePSDCBDInstName() != null)) {
            iDataObject.set(FIELD_UHBASEPSDCBDINSTNAME, (Object)pSDevSlnSysResBase.getUHBasePSDCBDInstName());
        }
        if (pSDevSlnSysResBase.isUMSSQLPSDCDBInstIdDirty() && (bl || pSDevSlnSysResBase.getUMSSQLPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_UMSSQLPSDCDBINSTID, (Object)pSDevSlnSysResBase.getUMSSQLPSDCDBInstId());
        }
        if (pSDevSlnSysResBase.isUMSSQLPSDCDBInstNameDirty() && (bl || pSDevSlnSysResBase.getUMSSQLPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_UMSSQLPSDCDBINSTNAME, (Object)pSDevSlnSysResBase.getUMSSQLPSDCDBInstName());
        }
        if (pSDevSlnSysResBase.isUMySQLPSDCDBInstIdDirty() && (bl || pSDevSlnSysResBase.getUMySQLPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_UMYSQLPSDCDBINSTID, (Object)pSDevSlnSysResBase.getUMySQLPSDCDBInstId());
        }
        if (pSDevSlnSysResBase.isUMySQLPSDCDBInstNameDirty() && (bl || pSDevSlnSysResBase.getUMySQLPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_UMYSQLPSDCDBINSTNAME, (Object)pSDevSlnSysResBase.getUMySQLPSDCDBInstName());
        }
        if (pSDevSlnSysResBase.isUOraPSDCDBInstIdDirty() && (bl || pSDevSlnSysResBase.getUOraPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_UORAPSDCDBINSTID, (Object)pSDevSlnSysResBase.getUOraPSDCDBInstId());
        }
        if (pSDevSlnSysResBase.isUOraPSDCDBInstNameDirty() && (bl || pSDevSlnSysResBase.getUOraPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_UORAPSDCDBINSTNAME, (Object)pSDevSlnSysResBase.getUOraPSDCDBInstName());
        }
        if (pSDevSlnSysResBase.isUpdateDateDirty() && (bl || pSDevSlnSysResBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysResBase.getUpdateDate());
        }
        if (pSDevSlnSysResBase.isUpdateManDirty() && (bl || pSDevSlnSysResBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysResBase.getUpdateMan());
        }
        if (pSDevSlnSysResBase.isUPGSQLPSDCDBInstIdDirty() && (bl || pSDevSlnSysResBase.getUPGSQLPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_UPGSQLPSDCDBINSTID, (Object)pSDevSlnSysResBase.getUPGSQLPSDCDBInstId());
        }
        if (pSDevSlnSysResBase.isUPGSQLPSDCDBInstNameDirty() && (bl || pSDevSlnSysResBase.getUPGSQLPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_UPGSQLPSDCDBINSTNAME, (Object)pSDevSlnSysResBase.getUPGSQLPSDCDBInstName());
        }
        if (pSDevSlnSysResBase.isUPPASPSDCDBInstIdDirty() && (bl || pSDevSlnSysResBase.getUPPASPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_UPPASPSDCDBINSTID, (Object)pSDevSlnSysResBase.getUPPASPSDCDBInstId());
        }
        if (pSDevSlnSysResBase.isUPPASPSDCDBInstNameDirty() && (bl || pSDevSlnSysResBase.getUPPASPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_UPPASPSDCDBINSTNAME, (Object)pSDevSlnSysResBase.getUPPASPSDCDBInstName());
        }
        if (pSDevSlnSysResBase.isUPSDevCenterASIdDirty() && (bl || pSDevSlnSysResBase.getUPSDevCenterASId() != null)) {
            iDataObject.set(FIELD_UPSDEVCENTERASID, (Object)pSDevSlnSysResBase.getUPSDevCenterASId());
        }
        if (pSDevSlnSysResBase.isUPSDevCenterASId2Dirty() && (bl || pSDevSlnSysResBase.getUPSDevCenterASId2() != null)) {
            iDataObject.set(FIELD_UPSDEVCENTERASID2, (Object)pSDevSlnSysResBase.getUPSDevCenterASId2());
        }
        if (pSDevSlnSysResBase.isUPSDevCenterASNameDirty() && (bl || pSDevSlnSysResBase.getUPSDevCenterASName() != null)) {
            iDataObject.set(FIELD_UPSDEVCENTERASNAME, (Object)pSDevSlnSysResBase.getUPSDevCenterASName());
        }
        if (pSDevSlnSysResBase.isUPSDevCenterASName2Dirty() && (bl || pSDevSlnSysResBase.getUPSDevCenterASName2() != null)) {
            iDataObject.set(FIELD_UPSDEVCENTERASNAME2, (Object)pSDevSlnSysResBase.getUPSDevCenterASName2());
        }
    }

    public boolean remove(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.remove(string);
        }
        return PSDevSlnSysResBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysResBase pSDevSlnSysResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysResBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnSysResBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnSysResBase.resetDB2PSDCDBInstId();
                return true;
            }
            case 3: {
                pSDevSlnSysResBase.resetDB2PSDCDBInstName();
                return true;
            }
            case 4: {
                pSDevSlnSysResBase.resetHBasePSDCBDInstId();
                return true;
            }
            case 5: {
                pSDevSlnSysResBase.resetHBasePSDCBDInstName();
                return true;
            }
            case 6: {
                pSDevSlnSysResBase.resetMemo();
                return true;
            }
            case 7: {
                pSDevSlnSysResBase.resetMSSQLPSDCDBInstId();
                return true;
            }
            case 8: {
                pSDevSlnSysResBase.resetMSSQLPSDCDBInstName();
                return true;
            }
            case 9: {
                pSDevSlnSysResBase.resetMySQLPSDCDBInstId();
                return true;
            }
            case 10: {
                pSDevSlnSysResBase.resetMySQLPSDCDBInstName();
                return true;
            }
            case 11: {
                pSDevSlnSysResBase.resetOraPSDCDBInstId();
                return true;
            }
            case 12: {
                pSDevSlnSysResBase.resetOraPSDCDBInstName();
                return true;
            }
            case 13: {
                pSDevSlnSysResBase.resetPGSQLPSDCDBInstId();
                return true;
            }
            case 14: {
                pSDevSlnSysResBase.resetPGSQLPSDCDBInstName();
                return true;
            }
            case 15: {
                pSDevSlnSysResBase.resetPPASPSDCDBInstId();
                return true;
            }
            case 16: {
                pSDevSlnSysResBase.resetPPASPSDCDBInstName();
                return true;
            }
            case 17: {
                pSDevSlnSysResBase.resetPSDCDeployServerId();
                return true;
            }
            case 18: {
                pSDevSlnSysResBase.resetPSDCDeployServerName();
                return true;
            }
            case 19: {
                pSDevSlnSysResBase.resetPSDevCenterASId();
                return true;
            }
            case 20: {
                pSDevSlnSysResBase.resetPSDevCenterASId2();
                return true;
            }
            case 21: {
                pSDevSlnSysResBase.resetPSDevCenterASName();
                return true;
            }
            case 22: {
                pSDevSlnSysResBase.resetPSDevCenterASName2();
                return true;
            }
            case 23: {
                pSDevSlnSysResBase.resetPSDevCenterSVNId();
                return true;
            }
            case 24: {
                pSDevSlnSysResBase.resetPSDevCenterSVNName();
                return true;
            }
            case 25: {
                pSDevSlnSysResBase.resetPSDevSlnId();
                return true;
            }
            case 26: {
                pSDevSlnSysResBase.resetPSDevSlnName();
                return true;
            }
            case 27: {
                pSDevSlnSysResBase.resetPSDevSlnSysResId();
                return true;
            }
            case 28: {
                pSDevSlnSysResBase.resetPSDevSlnSysResName();
                return true;
            }
            case 29: {
                pSDevSlnSysResBase.resetResInfo();
                return true;
            }
            case 30: {
                pSDevSlnSysResBase.resetResPos();
                return true;
            }
            case 31: {
                pSDevSlnSysResBase.resetROPSDevCenterSvnId();
                return true;
            }
            case 32: {
                pSDevSlnSysResBase.resetROPSDevCenterSvnName();
                return true;
            }
            case 33: {
                pSDevSlnSysResBase.resetUDB2PSDCDBInstId();
                return true;
            }
            case 34: {
                pSDevSlnSysResBase.resetUDB2PSDCDBInstName();
                return true;
            }
            case 35: {
                pSDevSlnSysResBase.resetUHBasePSDCBDInstId();
                return true;
            }
            case 36: {
                pSDevSlnSysResBase.resetUHBasePSDCBDInstName();
                return true;
            }
            case 37: {
                pSDevSlnSysResBase.resetUMSSQLPSDCDBInstId();
                return true;
            }
            case 38: {
                pSDevSlnSysResBase.resetUMSSQLPSDCDBInstName();
                return true;
            }
            case 39: {
                pSDevSlnSysResBase.resetUMySQLPSDCDBInstId();
                return true;
            }
            case 40: {
                pSDevSlnSysResBase.resetUMySQLPSDCDBInstName();
                return true;
            }
            case 41: {
                pSDevSlnSysResBase.resetUOraPSDCDBInstId();
                return true;
            }
            case 42: {
                pSDevSlnSysResBase.resetUOraPSDCDBInstName();
                return true;
            }
            case 43: {
                pSDevSlnSysResBase.resetUpdateDate();
                return true;
            }
            case 44: {
                pSDevSlnSysResBase.resetUpdateMan();
                return true;
            }
            case 45: {
                pSDevSlnSysResBase.resetUPGSQLPSDCDBInstId();
                return true;
            }
            case 46: {
                pSDevSlnSysResBase.resetUPGSQLPSDCDBInstName();
                return true;
            }
            case 47: {
                pSDevSlnSysResBase.resetUPPASPSDCDBInstId();
                return true;
            }
            case 48: {
                pSDevSlnSysResBase.resetUPPASPSDCDBInstName();
                return true;
            }
            case 49: {
                pSDevSlnSysResBase.resetUPSDevCenterASId();
                return true;
            }
            case 50: {
                pSDevSlnSysResBase.resetUPSDevCenterASId2();
                return true;
            }
            case 51: {
                pSDevSlnSysResBase.resetUPSDevCenterASName();
                return true;
            }
            case 52: {
                pSDevSlnSysResBase.resetUPSDevCenterASName2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCBDInst getHBasePSDCBDInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHBasePSDCBDInst();
        }
        if (this.getHBasePSDCBDInstId() == null) {
            return null;
        }
        Integer n = this.objHBasePSDCBDInstLock;
        synchronized (n) {
            if (this.hbasepsdcbdinst != null && DataTypeHelper.compare((int)25, (Object)this.getHBasePSDCBDInstId(), (Object)this.hbasepsdcbdinst.getPSDCBDInstId()) != 0L) {
                this.hbasepsdcbdinst = null;
            }
            if (this.hbasepsdcbdinst == null) {
                PSDCBDInst pSDCBDInst = new PSDCBDInst();
                pSDCBDInst.setPSDCBDInstId(this.getHBasePSDCBDInstId());
                PSDCBDInstService pSDCBDInstService = (PSDCBDInstService)ServiceGlobal.getService(PSDCBDInstService.class, (SessionFactory)this.getSessionFactory());
                pSDCBDInstService.autoGet((IEntity)pSDCBDInst);
                this.hbasepsdcbdinst = pSDCBDInst;
            }
            return this.hbasepsdcbdinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCBDInst getUHBasePSDCBDInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUHBasePSDCBDInst();
        }
        if (this.getUHBasePSDCBDInstId() == null) {
            return null;
        }
        Integer n = this.objUHBasePSDCBDInstLock;
        synchronized (n) {
            if (this.uhbasepsdcbdinst != null && DataTypeHelper.compare((int)25, (Object)this.getUHBasePSDCBDInstId(), (Object)this.uhbasepsdcbdinst.getPSDCBDInstId()) != 0L) {
                this.uhbasepsdcbdinst = null;
            }
            if (this.uhbasepsdcbdinst == null) {
                PSDCBDInst pSDCBDInst = new PSDCBDInst();
                pSDCBDInst.setPSDCBDInstId(this.getUHBasePSDCBDInstId());
                PSDCBDInstService pSDCBDInstService = (PSDCBDInstService)ServiceGlobal.getService(PSDCBDInstService.class, (SessionFactory)this.getSessionFactory());
                pSDCBDInstService.autoGet((IEntity)pSDCBDInst);
                this.uhbasepsdcbdinst = pSDCBDInst;
            }
            return this.uhbasepsdcbdinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCDeployServer getPSDCDeployServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployServer();
        }
        if (this.getPSDCDeployServerId() == null) {
            return null;
        }
        Integer n = this.objPSDCDeployServerLock;
        synchronized (n) {
            if (this.psdcdeployserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCDeployServerId(), (Object)this.psdcdeployserver.getPSDCDeployServerId()) != 0L) {
                this.psdcdeployserver = null;
            }
            if (this.psdcdeployserver == null) {
                PSDCDeployServer pSDCDeployServer = new PSDCDeployServer();
                pSDCDeployServer.setPSDCDeployServerId(this.getPSDCDeployServerId());
                PSDCDeployServerService pSDCDeployServerService = (PSDCDeployServerService)ServiceGlobal.getService(PSDCDeployServerService.class, (SessionFactory)this.getSessionFactory());
                pSDCDeployServerService.autoGet((IEntity)pSDCDeployServer);
                this.psdcdeployserver = pSDCDeployServer;
            }
            return this.psdcdeployserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterAS getPSDevCenterAS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterAS();
        }
        if (this.getPSDevCenterASId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterASLock;
        synchronized (n) {
            if (this.psdevcenteras != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterASId(), (Object)this.psdevcenteras.getPSDevCenterASId()) != 0L) {
                this.psdevcenteras = null;
            }
            if (this.psdevcenteras == null) {
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(this.getPSDevCenterASId());
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterASService.autoGet((IEntity)pSDevCenterAS);
                this.psdevcenteras = pSDevCenterAS;
            }
            return this.psdevcenteras;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterAS getPSDevCenterAS2() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterAS2();
        }
        if (this.getPSDevCenterASId2() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterAS2Lock;
        synchronized (n) {
            if (this.psdevcenteras2 != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterASId2(), (Object)this.psdevcenteras2.getPSDevCenterASId()) != 0L) {
                this.psdevcenteras2 = null;
            }
            if (this.psdevcenteras2 == null) {
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(this.getPSDevCenterASId2());
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterASService.autoGet((IEntity)pSDevCenterAS);
                this.psdevcenteras2 = pSDevCenterAS;
            }
            return this.psdevcenteras2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterAS getUPSDevCenterAS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUPSDevCenterAS();
        }
        if (this.getUPSDevCenterASId() == null) {
            return null;
        }
        Integer n = this.objUPSDevCenterASLock;
        synchronized (n) {
            if (this.upsdevcenteras != null && DataTypeHelper.compare((int)25, (Object)this.getUPSDevCenterASId(), (Object)this.upsdevcenteras.getPSDevCenterASId()) != 0L) {
                this.upsdevcenteras = null;
            }
            if (this.upsdevcenteras == null) {
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(this.getUPSDevCenterASId());
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterASService.autoGet((IEntity)pSDevCenterAS);
                this.upsdevcenteras = pSDevCenterAS;
            }
            return this.upsdevcenteras;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterAS getUPSDevCenterAS2() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUPSDevCenterAS2();
        }
        if (this.getUPSDevCenterASId2() == null) {
            return null;
        }
        Integer n = this.objUPSDevCenterAS2Lock;
        synchronized (n) {
            if (this.upsdevcenteras2 != null && DataTypeHelper.compare((int)25, (Object)this.getUPSDevCenterASId2(), (Object)this.upsdevcenteras2.getPSDevCenterASId()) != 0L) {
                this.upsdevcenteras2 = null;
            }
            if (this.upsdevcenteras2 == null) {
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(this.getUPSDevCenterASId2());
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterASService.autoGet((IEntity)pSDevCenterAS);
                this.upsdevcenteras2 = pSDevCenterAS;
            }
            return this.upsdevcenteras2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getDB2PSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDB2PSDCDBInst();
        }
        if (this.getDB2PSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objDB2PSDCDBInstLock;
        synchronized (n) {
            if (this.db2psdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getDB2PSDCDBInstId(), (Object)this.db2psdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.db2psdcdbinst = null;
            }
            if (this.db2psdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getDB2PSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.db2psdcdbinst = pSDevCenterDBInst;
            }
            return this.db2psdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getMSSqlPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMSSqlPSDCDBInst();
        }
        if (this.getMSSQLPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objMSSqlPSDCDBInstLock;
        synchronized (n) {
            if (this.mssqlpsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getMSSQLPSDCDBInstId(), (Object)this.mssqlpsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.mssqlpsdcdbinst = null;
            }
            if (this.mssqlpsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getMSSQLPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.mssqlpsdcdbinst = pSDevCenterDBInst;
            }
            return this.mssqlpsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getMySQLPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMySQLPSDCDBInst();
        }
        if (this.getMySQLPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objMySQLPSDCDBInstLock;
        synchronized (n) {
            if (this.mysqlpsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getMySQLPSDCDBInstId(), (Object)this.mysqlpsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.mysqlpsdcdbinst = null;
            }
            if (this.mysqlpsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getMySQLPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.mysqlpsdcdbinst = pSDevCenterDBInst;
            }
            return this.mysqlpsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getOraPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOraPSDCDBInst();
        }
        if (this.getOraPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objOraPSDCDBInstLock;
        synchronized (n) {
            if (this.orapsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getOraPSDCDBInstId(), (Object)this.orapsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.orapsdcdbinst = null;
            }
            if (this.orapsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getOraPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.orapsdcdbinst = pSDevCenterDBInst;
            }
            return this.orapsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPGSQLPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPGSQLPSDCDBInst();
        }
        if (this.getPGSQLPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objPGSQLPSDCDBInstLock;
        synchronized (n) {
            if (this.pgsqlpsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPGSQLPSDCDBInstId(), (Object)this.pgsqlpsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.pgsqlpsdcdbinst = null;
            }
            if (this.pgsqlpsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPGSQLPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.pgsqlpsdcdbinst = pSDevCenterDBInst;
            }
            return this.pgsqlpsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPPASPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPASPSDCDBInst();
        }
        if (this.getPPASPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objPPASPSDCDBInstLock;
        synchronized (n) {
            if (this.ppaspsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPPASPSDCDBInstId(), (Object)this.ppaspsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.ppaspsdcdbinst = null;
            }
            if (this.ppaspsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPPASPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.ppaspsdcdbinst = pSDevCenterDBInst;
            }
            return this.ppaspsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getUDB2PSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUDB2PSDCDBInst();
        }
        if (this.getUDB2PSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objUDB2PSDCDBInstLock;
        synchronized (n) {
            if (this.udb2psdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getUDB2PSDCDBInstId(), (Object)this.udb2psdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.udb2psdcdbinst = null;
            }
            if (this.udb2psdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getUDB2PSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.udb2psdcdbinst = pSDevCenterDBInst;
            }
            return this.udb2psdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getUMSSqlPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUMSSqlPSDCDBInst();
        }
        if (this.getUMSSQLPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objUMSSqlPSDCDBInstLock;
        synchronized (n) {
            if (this.umssqlpsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getUMSSQLPSDCDBInstId(), (Object)this.umssqlpsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.umssqlpsdcdbinst = null;
            }
            if (this.umssqlpsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getUMSSQLPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.umssqlpsdcdbinst = pSDevCenterDBInst;
            }
            return this.umssqlpsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getUMySQLPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUMySQLPSDCDBInst();
        }
        if (this.getUMySQLPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objUMySQLPSDCDBInstLock;
        synchronized (n) {
            if (this.umysqlpsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getUMySQLPSDCDBInstId(), (Object)this.umysqlpsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.umysqlpsdcdbinst = null;
            }
            if (this.umysqlpsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getUMySQLPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.umysqlpsdcdbinst = pSDevCenterDBInst;
            }
            return this.umysqlpsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getUOraPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUOraPSDCDBInst();
        }
        if (this.getUOraPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objUOraPSDCDBInstLock;
        synchronized (n) {
            if (this.uorapsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getUOraPSDCDBInstId(), (Object)this.uorapsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.uorapsdcdbinst = null;
            }
            if (this.uorapsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getUOraPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.uorapsdcdbinst = pSDevCenterDBInst;
            }
            return this.uorapsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getUPGSQLPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUPGSQLPSDCDBInst();
        }
        if (this.getUPGSQLPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objUPGSQLPSDCDBInstLock;
        synchronized (n) {
            if (this.upgsqlpsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getUPGSQLPSDCDBInstId(), (Object)this.upgsqlpsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.upgsqlpsdcdbinst = null;
            }
            if (this.upgsqlpsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getUPGSQLPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.upgsqlpsdcdbinst = pSDevCenterDBInst;
            }
            return this.upgsqlpsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getUPPASPSDCDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUPPASPSDCDBInst();
        }
        if (this.getUPPASPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objUPPASPSDCDBInstLock;
        synchronized (n) {
            if (this.uppaspsdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getUPPASPSDCDBInstId(), (Object)this.uppaspsdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.uppaspsdcdbinst = null;
            }
            if (this.uppaspsdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getUPPASPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.uppaspsdcdbinst = pSDevCenterDBInst;
            }
            return this.uppaspsdcdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVN();
        }
        if (this.getPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterSVNLock;
        synchronized (n) {
            if (this.psdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterSVNId(), (Object)this.psdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.psdevcentersvn = null;
            }
            if (this.psdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet((IEntity)pSDevCenterSVN);
                this.psdevcentersvn = pSDevCenterSVN;
            }
            return this.psdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getROPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getROPSDevCenterSVN();
        }
        if (this.getROPSDevCenterSvnId() == null) {
            return null;
        }
        Integer n = this.objROPSDevCenterSVNLock;
        synchronized (n) {
            if (this.ropsdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getROPSDevCenterSvnId(), (Object)this.ropsdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.ropsdevcentersvn = null;
            }
            if (this.ropsdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getROPSDevCenterSvnId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet((IEntity)pSDevCenterSVN);
                this.ropsdevcentersvn = pSDevCenterSVN;
            }
            return this.ropsdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet((IEntity)pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    private PSDevSlnSysResBase getProxyEntity() {
        return this.proxyPSDevSlnSysResBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysResBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysResBase) {
            this.proxyPSDevSlnSysResBase = (PSDevSlnSysResBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysResService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DB2PSDCDBINSTID, 2);
        fieldIndexMap.put(FIELD_DB2PSDCDBINSTNAME, 3);
        fieldIndexMap.put(FIELD_HBASEPSDCBDINSTID, 4);
        fieldIndexMap.put(FIELD_HBASEPSDCBDINSTNAME, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_MSSQLPSDCDBINSTID, 7);
        fieldIndexMap.put(FIELD_MSSQLPSDCDBINSTNAME, 8);
        fieldIndexMap.put(FIELD_MYSQLPSDCDBINSTID, 9);
        fieldIndexMap.put(FIELD_MYSQLPSDCDBINSTNAME, 10);
        fieldIndexMap.put(FIELD_ORAPSDCDBINSTID, 11);
        fieldIndexMap.put(FIELD_ORAPSDCDBINSTNAME, 12);
        fieldIndexMap.put(FIELD_PGSQLPSDCDBINSTID, 13);
        fieldIndexMap.put(FIELD_PGSQLPSDCDBINSTNAME, 14);
        fieldIndexMap.put(FIELD_PPASPSDCDBINSTID, 15);
        fieldIndexMap.put(FIELD_PPASPSDCDBINSTNAME, 16);
        fieldIndexMap.put(FIELD_PSDCDEPLOYSERVERID, 17);
        fieldIndexMap.put(FIELD_PSDCDEPLOYSERVERNAME, 18);
        fieldIndexMap.put(FIELD_PSDEVCENTERASID, 19);
        fieldIndexMap.put(FIELD_PSDEVCENTERASID2, 20);
        fieldIndexMap.put(FIELD_PSDEVCENTERASNAME, 21);
        fieldIndexMap.put(FIELD_PSDEVCENTERASNAME2, 22);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNID, 23);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNNAME, 24);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 25);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 26);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSRESID, 27);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSRESNAME, 28);
        fieldIndexMap.put(FIELD_RESINFO, 29);
        fieldIndexMap.put(FIELD_RESPOS, 30);
        fieldIndexMap.put(FIELD_ROPSDEVCENTERSVNID, 31);
        fieldIndexMap.put(FIELD_ROPSDEVCENTERSVNNAME, 32);
        fieldIndexMap.put(FIELD_UDB2PSDCDBINSTID, 33);
        fieldIndexMap.put(FIELD_UDB2PSDCDBINSTNAME, 34);
        fieldIndexMap.put(FIELD_UHBASEPSDCBDINSTID, 35);
        fieldIndexMap.put(FIELD_UHBASEPSDCBDINSTNAME, 36);
        fieldIndexMap.put(FIELD_UMSSQLPSDCDBINSTID, 37);
        fieldIndexMap.put(FIELD_UMSSQLPSDCDBINSTNAME, 38);
        fieldIndexMap.put(FIELD_UMYSQLPSDCDBINSTID, 39);
        fieldIndexMap.put(FIELD_UMYSQLPSDCDBINSTNAME, 40);
        fieldIndexMap.put(FIELD_UORAPSDCDBINSTID, 41);
        fieldIndexMap.put(FIELD_UORAPSDCDBINSTNAME, 42);
        fieldIndexMap.put(FIELD_UPDATEDATE, 43);
        fieldIndexMap.put(FIELD_UPDATEMAN, 44);
        fieldIndexMap.put(FIELD_UPGSQLPSDCDBINSTID, 45);
        fieldIndexMap.put(FIELD_UPGSQLPSDCDBINSTNAME, 46);
        fieldIndexMap.put(FIELD_UPPASPSDCDBINSTID, 47);
        fieldIndexMap.put(FIELD_UPPASPSDCDBINSTNAME, 48);
        fieldIndexMap.put(FIELD_UPSDEVCENTERASID, 49);
        fieldIndexMap.put(FIELD_UPSDEVCENTERASID2, 50);
        fieldIndexMap.put(FIELD_UPSDEVCENTERASNAME, 51);
        fieldIndexMap.put(FIELD_UPSDEVCENTERASNAME2, 52);
    }
}

