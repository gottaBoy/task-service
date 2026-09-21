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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBDevInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDBDevInstBase.class);
    public static final String FIELD_ALLOCSIZE = "ALLOCSIZE";
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CONNSTRFMT = "CONNSTRFMT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURDBACTION = "CURDBACTION";
    public static final String FIELD_DBNAME = "DBNAME";
    public static final String FIELD_DBSCHEMA = "DBSCHEMA";
    public static final String FIELD_DBTYPE = "DBTYPE";
    public static final String FIELD_DMPASSWD = "DMPASSWD";
    public static final String FIELD_DMUSERNAME = "DMUSERNAME";
    public static final String FIELD_INSTSTATE = "INSTSTATE";
    public static final String FIELD_LOCALRES = "LOCALRES";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PARAM5 = "PARAM5";
    public static final String FIELD_PARAM6 = "PARAM6";
    public static final String FIELD_PARAM7 = "PARAM7";
    public static final String FIELD_PARAM8 = "PARAM8";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PSAPPSERVERID = "PSAPPSERVERID";
    public static final String FIELD_PSAPPSERVERNAME = "PSAPPSERVERNAME";
    public static final String FIELD_PSDBDEVINSTID = "PSDBDEVINSTID";
    public static final String FIELD_PSDBDEVINSTNAME = "PSDBDEVINSTNAME";
    public static final String FIELD_PSDBSERVERID = "PSDBSERVERID";
    public static final String FIELD_PSDBSERVERNAME = "PSDBSERVERNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_REFINFO = "REFINFO";
    public static final String FIELD_REFOBJID = "REFOBJID";
    public static final String FIELD_TIMESHAREMODE = "TIMESHAREMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USAGEMODE = "USAGEMODE";
    public static final String FIELD_USEDSIZE = "USEDSIZE";
    public static final String FIELD_USERNAME = "USERNAME";
    public static final String FIELD_WEBCONSOLEPATH = "WEBCONSOLEPATH";
    private static final int INDEX_ALLOCSIZE = 0;
    private static final int INDEX_CONNSTR = 1;
    private static final int INDEX_CONNSTRFMT = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_CURDBACTION = 5;
    private static final int INDEX_DBNAME = 6;
    private static final int INDEX_DBSCHEMA = 7;
    private static final int INDEX_DBTYPE = 8;
    private static final int INDEX_DMPASSWD = 9;
    private static final int INDEX_DMUSERNAME = 10;
    private static final int INDEX_INSTSTATE = 11;
    private static final int INDEX_LOCALRES = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_PARAM = 14;
    private static final int INDEX_PARAM2 = 15;
    private static final int INDEX_PARAM3 = 16;
    private static final int INDEX_PARAM4 = 17;
    private static final int INDEX_PARAM5 = 18;
    private static final int INDEX_PARAM6 = 19;
    private static final int INDEX_PARAM7 = 20;
    private static final int INDEX_PARAM8 = 21;
    private static final int INDEX_PASSWD = 22;
    private static final int INDEX_PSAPPSERVERID = 23;
    private static final int INDEX_PSAPPSERVERNAME = 24;
    private static final int INDEX_PSDBDEVINSTID = 25;
    private static final int INDEX_PSDBDEVINSTNAME = 26;
    private static final int INDEX_PSDBSERVERID = 27;
    private static final int INDEX_PSDBSERVERNAME = 28;
    private static final int INDEX_PSDEVCENTERID = 29;
    private static final int INDEX_PSDEVCENTERNAME = 30;
    private static final int INDEX_PSSVRDOMAINID = 31;
    private static final int INDEX_PSSVRDOMAINNAME = 32;
    private static final int INDEX_REFINFO = 33;
    private static final int INDEX_REFOBJID = 34;
    private static final int INDEX_TIMESHAREMODE = 35;
    private static final int INDEX_UPDATEDATE = 36;
    private static final int INDEX_UPDATEMAN = 37;
    private static final int INDEX_USAGEMODE = 38;
    private static final int INDEX_USEDSIZE = 39;
    private static final int INDEX_USERNAME = 40;
    private static final int INDEX_WEBCONSOLEPATH = 41;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDBDevInstBase proxyPSDBDevInstBase = null;
    private boolean allocsizeDirtyFlag = false;
    private boolean connstrDirtyFlag = false;
    private boolean connstrfmtDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curdbactionDirtyFlag = false;
    private boolean dbnameDirtyFlag = false;
    private boolean dbschemaDirtyFlag = false;
    private boolean dbtypeDirtyFlag = false;
    private boolean dmpasswdDirtyFlag = false;
    private boolean dmusernameDirtyFlag = false;
    private boolean inststateDirtyFlag = false;
    private boolean localresDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean psappserveridDirtyFlag = false;
    private boolean psappservernameDirtyFlag = false;
    private boolean psdbdevinstidDirtyFlag = false;
    private boolean psdbdevinstnameDirtyFlag = false;
    private boolean psdbserveridDirtyFlag = false;
    private boolean psdbservernameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean refinfoDirtyFlag = false;
    private boolean refobjidDirtyFlag = false;
    private boolean timesharemodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usagemodeDirtyFlag = false;
    private boolean usedsizeDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    private boolean webconsolepathDirtyFlag = false;
    @Column(name="allocsize")
    private Integer allocsize;
    @Column(name="connstr")
    private String connstr;
    @Column(name="connstrfmt")
    private String connstrfmt;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curdbaction")
    private String curdbaction;
    @Column(name="dbname")
    private String dbname;
    @Column(name="dbschema")
    private String dbschema;
    @Column(name="dbtype")
    private String dbtype;
    @Column(name="dmpasswd")
    private String dmpasswd;
    @Column(name="dmusername")
    private String dmusername;
    @Column(name="inststate")
    private Integer inststate;
    @Column(name="localres")
    private Integer localres;
    @Column(name="memo")
    private String memo;
    @Column(name="param")
    private String param;
    @Column(name="param2")
    private String param2;
    @Column(name="param3")
    private String param3;
    @Column(name="param4")
    private String param4;
    @Column(name="param5")
    private Integer param5;
    @Column(name="param6")
    private Integer param6;
    @Column(name="param7")
    private Integer param7;
    @Column(name="param8")
    private Integer param8;
    @Column(name="passwd")
    private String passwd;
    @Column(name="psappserverid")
    private String psappserverid;
    @Column(name="psappservername")
    private String psappservername;
    @Column(name="psdbdevinstid")
    private String psdbdevinstid;
    @Column(name="psdbdevinstname")
    private String psdbdevinstname;
    @Column(name="psdbserverid")
    private String psdbserverid;
    @Column(name="psdbservername")
    private String psdbservername;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="refinfo")
    private String refinfo;
    @Column(name="refobjid")
    private String refobjid;
    @Column(name="timesharemode")
    private Integer timesharemode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usagemode")
    private String usagemode;
    @Column(name="usedsize")
    private Integer usedsize;
    @Column(name="username")
    private String username;
    @Column(name="webconsolepath")
    private String webconsolepath;
    private Integer objPSAppServerLock = new Integer(1);
    private PSAppServer psappserver = null;
    private Integer objPSDBServerLock = new Integer(1);
    private PSDBServer psdbserver = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

    public void setAllocSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllocSize(n);
            return;
        }
        this.allocsize = n;
        this.allocsizeDirtyFlag = true;
    }

    public Integer getAllocSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllocSize();
        }
        return this.allocsize;
    }

    public boolean isAllocSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllocSizeDirty();
        }
        return this.allocsizeDirtyFlag;
    }

    public void resetAllocSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllocSize();
            return;
        }
        this.allocsizeDirtyFlag = false;
        this.allocsize = null;
    }

    public void setConnStr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConnStr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.connstr = string;
        this.connstrDirtyFlag = true;
    }

    public String getConnStr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConnStr();
        }
        return this.connstr;
    }

    public boolean isConnStrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConnStrDirty();
        }
        return this.connstrDirtyFlag;
    }

    public void resetConnStr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConnStr();
            return;
        }
        this.connstrDirtyFlag = false;
        this.connstr = null;
    }

    public void setConnStrFmt(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConnStrFmt(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.connstrfmt = string;
        this.connstrfmtDirtyFlag = true;
    }

    public String getConnStrFmt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConnStrFmt();
        }
        return this.connstrfmt;
    }

    public boolean isConnStrFmtDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConnStrFmtDirty();
        }
        return this.connstrfmtDirtyFlag;
    }

    public void resetConnStrFmt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConnStrFmt();
            return;
        }
        this.connstrfmtDirtyFlag = false;
        this.connstrfmt = null;
    }

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

    public void setCurDBAction(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurDBAction(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.curdbaction = string;
        this.curdbactionDirtyFlag = true;
    }

    public String getCurDBAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurDBAction();
        }
        return this.curdbaction;
    }

    public boolean isCurDBActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurDBActionDirty();
        }
        return this.curdbactionDirtyFlag;
    }

    public void resetCurDBAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurDBAction();
            return;
        }
        this.curdbactionDirtyFlag = false;
        this.curdbaction = null;
    }

    public void setDBName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbname = string;
        this.dbnameDirtyFlag = true;
    }

    public String getDBName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBName();
        }
        return this.dbname;
    }

    public boolean isDBNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBNameDirty();
        }
        return this.dbnameDirtyFlag;
    }

    public void resetDBName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBName();
            return;
        }
        this.dbnameDirtyFlag = false;
        this.dbname = null;
    }

    public void setDBSchema(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBSchema(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbschema = string;
        this.dbschemaDirtyFlag = true;
    }

    public String getDBSchema() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBSchema();
        }
        return this.dbschema;
    }

    public boolean isDBSchemaDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBSchemaDirty();
        }
        return this.dbschemaDirtyFlag;
    }

    public void resetDBSchema() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBSchema();
            return;
        }
        this.dbschemaDirtyFlag = false;
        this.dbschema = null;
    }

    public void setDBType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbtype = string;
        this.dbtypeDirtyFlag = true;
    }

    public String getDBType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBType();
        }
        return this.dbtype;
    }

    public boolean isDBTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBTypeDirty();
        }
        return this.dbtypeDirtyFlag;
    }

    public void resetDBType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBType();
            return;
        }
        this.dbtypeDirtyFlag = false;
        this.dbtype = null;
    }

    public void setDMPassWD(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDMPassWD(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dmpasswd = string;
        this.dmpasswdDirtyFlag = true;
    }

    public String getDMPassWD() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDMPassWD();
        }
        return this.dmpasswd;
    }

    public boolean isDMPassWDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDMPassWDDirty();
        }
        return this.dmpasswdDirtyFlag;
    }

    public void resetDMPassWD() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDMPassWD();
            return;
        }
        this.dmpasswdDirtyFlag = false;
        this.dmpasswd = null;
    }

    public void setDMUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDMUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dmusername = string;
        this.dmusernameDirtyFlag = true;
    }

    public String getDMUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDMUserName();
        }
        return this.dmusername;
    }

    public boolean isDMUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDMUserNameDirty();
        }
        return this.dmusernameDirtyFlag;
    }

    public void resetDMUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDMUserName();
            return;
        }
        this.dmusernameDirtyFlag = false;
        this.dmusername = null;
    }

    public void setInstState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstState(n);
            return;
        }
        this.inststate = n;
        this.inststateDirtyFlag = true;
    }

    public Integer getInstState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstState();
        }
        return this.inststate;
    }

    public boolean isInstStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstStateDirty();
        }
        return this.inststateDirtyFlag;
    }

    public void resetInstState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstState();
            return;
        }
        this.inststateDirtyFlag = false;
        this.inststate = null;
    }

    public void setLocalRes(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLocalRes(n);
            return;
        }
        this.localres = n;
        this.localresDirtyFlag = true;
    }

    public Integer getLocalRes() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLocalRes();
        }
        return this.localres;
    }

    public boolean isLocalResDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLocalResDirty();
        }
        return this.localresDirtyFlag;
    }

    public void resetLocalRes() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLocalRes();
            return;
        }
        this.localresDirtyFlag = false;
        this.localres = null;
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

    public void setParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param = string;
        this.paramDirtyFlag = true;
    }

    public String getParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam();
        }
        return this.param;
    }

    public boolean isParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDirty();
        }
        return this.paramDirtyFlag;
    }

    public void resetParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam();
            return;
        }
        this.paramDirtyFlag = false;
        this.param = null;
    }

    public void setParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param2 = string;
        this.param2DirtyFlag = true;
    }

    public String getParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam2();
        }
        return this.param2;
    }

    public boolean isParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam2Dirty();
        }
        return this.param2DirtyFlag;
    }

    public void resetParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam2();
            return;
        }
        this.param2DirtyFlag = false;
        this.param2 = null;
    }

    public void setParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param3 = string;
        this.param3DirtyFlag = true;
    }

    public String getParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam3();
        }
        return this.param3;
    }

    public boolean isParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam3Dirty();
        }
        return this.param3DirtyFlag;
    }

    public void resetParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam3();
            return;
        }
        this.param3DirtyFlag = false;
        this.param3 = null;
    }

    public void setParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param4 = string;
        this.param4DirtyFlag = true;
    }

    public String getParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam4();
        }
        return this.param4;
    }

    public boolean isParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam4Dirty();
        }
        return this.param4DirtyFlag;
    }

    public void resetParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam4();
            return;
        }
        this.param4DirtyFlag = false;
        this.param4 = null;
    }

    public void setParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam5(n);
            return;
        }
        this.param5 = n;
        this.param5DirtyFlag = true;
    }

    public Integer getParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam5();
        }
        return this.param5;
    }

    public boolean isParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam5Dirty();
        }
        return this.param5DirtyFlag;
    }

    public void resetParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam5();
            return;
        }
        this.param5DirtyFlag = false;
        this.param5 = null;
    }

    public void setParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam6(n);
            return;
        }
        this.param6 = n;
        this.param6DirtyFlag = true;
    }

    public Integer getParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam6();
        }
        return this.param6;
    }

    public boolean isParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam6Dirty();
        }
        return this.param6DirtyFlag;
    }

    public void resetParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam6();
            return;
        }
        this.param6DirtyFlag = false;
        this.param6 = null;
    }

    public void setParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam7(n);
            return;
        }
        this.param7 = n;
        this.param7DirtyFlag = true;
    }

    public Integer getParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam7();
        }
        return this.param7;
    }

    public boolean isParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam7Dirty();
        }
        return this.param7DirtyFlag;
    }

    public void resetParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam7();
            return;
        }
        this.param7DirtyFlag = false;
        this.param7 = null;
    }

    public void setParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam8(n);
            return;
        }
        this.param8 = n;
        this.param8DirtyFlag = true;
    }

    public Integer getParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam8();
        }
        return this.param8;
    }

    public boolean isParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam8Dirty();
        }
        return this.param8DirtyFlag;
    }

    public void resetParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam8();
            return;
        }
        this.param8DirtyFlag = false;
        this.param8 = null;
    }

    public void setPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.passwd = string;
        this.passwdDirtyFlag = true;
    }

    public String getPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPasswd();
        }
        return this.passwd;
    }

    public boolean isPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPasswdDirty();
        }
        return this.passwdDirtyFlag;
    }

    public void resetPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPasswd();
            return;
        }
        this.passwdDirtyFlag = false;
        this.passwd = null;
    }

    public void setPSAppServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappserverid = string;
        this.psappserveridDirtyFlag = true;
    }

    public String getPSAppServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppServerId();
        }
        return this.psappserverid;
    }

    public boolean isPSAppServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppServerIdDirty();
        }
        return this.psappserveridDirtyFlag;
    }

    public void resetPSAppServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppServerId();
            return;
        }
        this.psappserveridDirtyFlag = false;
        this.psappserverid = null;
    }

    public void setPSAppServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappservername = string;
        this.psappservernameDirtyFlag = true;
    }

    public String getPSAppServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppServerName();
        }
        return this.psappservername;
    }

    public boolean isPSAppServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppServerNameDirty();
        }
        return this.psappservernameDirtyFlag;
    }

    public void resetPSAppServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppServerName();
            return;
        }
        this.psappservernameDirtyFlag = false;
        this.psappservername = null;
    }

    public void setPSDBDevInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBDevInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbdevinstid = string;
        this.psdbdevinstidDirtyFlag = true;
    }

    public String getPSDBDevInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBDevInstId();
        }
        return this.psdbdevinstid;
    }

    public boolean isPSDBDevInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBDevInstIdDirty();
        }
        return this.psdbdevinstidDirtyFlag;
    }

    public void resetPSDBDevInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBDevInstId();
            return;
        }
        this.psdbdevinstidDirtyFlag = false;
        this.psdbdevinstid = null;
    }

    public void setPSDBDevInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBDevInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbdevinstname = string;
        this.psdbdevinstnameDirtyFlag = true;
    }

    public String getPSDBDevInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBDevInstName();
        }
        return this.psdbdevinstname;
    }

    public boolean isPSDBDevInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBDevInstNameDirty();
        }
        return this.psdbdevinstnameDirtyFlag;
    }

    public void resetPSDBDevInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBDevInstName();
            return;
        }
        this.psdbdevinstnameDirtyFlag = false;
        this.psdbdevinstname = null;
    }

    public void setPSDBServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbserverid = string;
        this.psdbserveridDirtyFlag = true;
    }

    public String getPSDBServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBServerId();
        }
        return this.psdbserverid;
    }

    public boolean isPSDBServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBServerIdDirty();
        }
        return this.psdbserveridDirtyFlag;
    }

    public void resetPSDBServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBServerId();
            return;
        }
        this.psdbserveridDirtyFlag = false;
        this.psdbserverid = null;
    }

    public void setPSDBServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbservername = string;
        this.psdbservernameDirtyFlag = true;
    }

    public String getPSDBServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBServerName();
        }
        return this.psdbservername;
    }

    public boolean isPSDBServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBServerNameDirty();
        }
        return this.psdbservernameDirtyFlag;
    }

    public void resetPSDBServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBServerName();
            return;
        }
        this.psdbservernameDirtyFlag = false;
        this.psdbservername = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSSvrDomainId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainid = string;
        this.pssvrdomainidDirtyFlag = true;
    }

    public String getPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainId();
        }
        return this.pssvrdomainid;
    }

    public boolean isPSSvrDomainIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainIdDirty();
        }
        return this.pssvrdomainidDirtyFlag;
    }

    public void resetPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainId();
            return;
        }
        this.pssvrdomainidDirtyFlag = false;
        this.pssvrdomainid = null;
    }

    public void setPSSvrDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainname = string;
        this.pssvrdomainnameDirtyFlag = true;
    }

    public String getPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainName();
        }
        return this.pssvrdomainname;
    }

    public boolean isPSSvrDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainNameDirty();
        }
        return this.pssvrdomainnameDirtyFlag;
    }

    public void resetPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainName();
            return;
        }
        this.pssvrdomainnameDirtyFlag = false;
        this.pssvrdomainname = null;
    }

    public void setRefInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refinfo = string;
        this.refinfoDirtyFlag = true;
    }

    public String getRefInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefInfo();
        }
        return this.refinfo;
    }

    public boolean isRefInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefInfoDirty();
        }
        return this.refinfoDirtyFlag;
    }

    public void resetRefInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefInfo();
            return;
        }
        this.refinfoDirtyFlag = false;
        this.refinfo = null;
    }

    public void setRefObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjid = string;
        this.refobjidDirtyFlag = true;
    }

    public String getRefObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjId();
        }
        return this.refobjid;
    }

    public boolean isRefObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjIdDirty();
        }
        return this.refobjidDirtyFlag;
    }

    public void resetRefObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjId();
            return;
        }
        this.refobjidDirtyFlag = false;
        this.refobjid = null;
    }

    public void setTimeShareMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeShareMode(n);
            return;
        }
        this.timesharemode = n;
        this.timesharemodeDirtyFlag = true;
    }

    public Integer getTimeShareMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeShareMode();
        }
        return this.timesharemode;
    }

    public boolean isTimeShareModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeShareModeDirty();
        }
        return this.timesharemodeDirtyFlag;
    }

    public void resetTimeShareMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeShareMode();
            return;
        }
        this.timesharemodeDirtyFlag = false;
        this.timesharemode = null;
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

    public void setUsageMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsageMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usagemode = string;
        this.usagemodeDirtyFlag = true;
    }

    public String getUsageMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsageMode();
        }
        return this.usagemode;
    }

    public boolean isUsageModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsageModeDirty();
        }
        return this.usagemodeDirtyFlag;
    }

    public void resetUsageMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsageMode();
            return;
        }
        this.usagemodeDirtyFlag = false;
        this.usagemode = null;
    }

    public void setUsedSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsedSize(n);
            return;
        }
        this.usedsize = n;
        this.usedsizeDirtyFlag = true;
    }

    public Integer getUsedSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsedSize();
        }
        return this.usedsize;
    }

    public boolean isUsedSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsedSizeDirty();
        }
        return this.usedsizeDirtyFlag;
    }

    public void resetUsedSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsedSize();
            return;
        }
        this.usedsizeDirtyFlag = false;
        this.usedsize = null;
    }

    public void setUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.username = string;
        this.usernameDirtyFlag = true;
    }

    public String getUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserName();
        }
        return this.username;
    }

    public boolean isUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserNameDirty();
        }
        return this.usernameDirtyFlag;
    }

    public void resetUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserName();
            return;
        }
        this.usernameDirtyFlag = false;
        this.username = null;
    }

    public void setWebConsolePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWebConsolePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.webconsolepath = string;
        this.webconsolepathDirtyFlag = true;
    }

    public String getWebConsolePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWebConsolePath();
        }
        return this.webconsolepath;
    }

    public boolean isWebConsolePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWebConsolePathDirty();
        }
        return this.webconsolepathDirtyFlag;
    }

    public void resetWebConsolePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWebConsolePath();
            return;
        }
        this.webconsolepathDirtyFlag = false;
        this.webconsolepath = null;
    }

    protected void onReset() {
        PSDBDevInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDBDevInstBase pSDBDevInstBase) {
        pSDBDevInstBase.resetAllocSize();
        pSDBDevInstBase.resetConnStr();
        pSDBDevInstBase.resetConnStrFmt();
        pSDBDevInstBase.resetCreateDate();
        pSDBDevInstBase.resetCreateMan();
        pSDBDevInstBase.resetCurDBAction();
        pSDBDevInstBase.resetDBName();
        pSDBDevInstBase.resetDBSchema();
        pSDBDevInstBase.resetDBType();
        pSDBDevInstBase.resetDMPassWD();
        pSDBDevInstBase.resetDMUserName();
        pSDBDevInstBase.resetInstState();
        pSDBDevInstBase.resetLocalRes();
        pSDBDevInstBase.resetMemo();
        pSDBDevInstBase.resetParam();
        pSDBDevInstBase.resetParam2();
        pSDBDevInstBase.resetParam3();
        pSDBDevInstBase.resetParam4();
        pSDBDevInstBase.resetParam5();
        pSDBDevInstBase.resetParam6();
        pSDBDevInstBase.resetParam7();
        pSDBDevInstBase.resetParam8();
        pSDBDevInstBase.resetPasswd();
        pSDBDevInstBase.resetPSAppServerId();
        pSDBDevInstBase.resetPSAppServerName();
        pSDBDevInstBase.resetPSDBDevInstId();
        pSDBDevInstBase.resetPSDBDevInstName();
        pSDBDevInstBase.resetPSDBServerId();
        pSDBDevInstBase.resetPSDBServerName();
        pSDBDevInstBase.resetPSDevCenterId();
        pSDBDevInstBase.resetPSDevCenterName();
        pSDBDevInstBase.resetPSSvrDomainId();
        pSDBDevInstBase.resetPSSvrDomainName();
        pSDBDevInstBase.resetRefInfo();
        pSDBDevInstBase.resetRefObjId();
        pSDBDevInstBase.resetTimeShareMode();
        pSDBDevInstBase.resetUpdateDate();
        pSDBDevInstBase.resetUpdateMan();
        pSDBDevInstBase.resetUsageMode();
        pSDBDevInstBase.resetUsedSize();
        pSDBDevInstBase.resetUserName();
        pSDBDevInstBase.resetWebConsolePath();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllocSizeDirty()) {
            hashMap.put(FIELD_ALLOCSIZE, this.getAllocSize());
        }
        if (!bl || this.isConnStrDirty()) {
            hashMap.put(FIELD_CONNSTR, this.getConnStr());
        }
        if (!bl || this.isConnStrFmtDirty()) {
            hashMap.put(FIELD_CONNSTRFMT, this.getConnStrFmt());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurDBActionDirty()) {
            hashMap.put(FIELD_CURDBACTION, this.getCurDBAction());
        }
        if (!bl || this.isDBNameDirty()) {
            hashMap.put(FIELD_DBNAME, this.getDBName());
        }
        if (!bl || this.isDBSchemaDirty()) {
            hashMap.put(FIELD_DBSCHEMA, this.getDBSchema());
        }
        if (!bl || this.isDBTypeDirty()) {
            hashMap.put(FIELD_DBTYPE, this.getDBType());
        }
        if (!bl || this.isDMPassWDDirty()) {
            hashMap.put(FIELD_DMPASSWD, this.getDMPassWD());
        }
        if (!bl || this.isDMUserNameDirty()) {
            hashMap.put(FIELD_DMUSERNAME, this.getDMUserName());
        }
        if (!bl || this.isInstStateDirty()) {
            hashMap.put(FIELD_INSTSTATE, this.getInstState());
        }
        if (!bl || this.isLocalResDirty()) {
            hashMap.put(FIELD_LOCALRES, this.getLocalRes());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isParamDirty()) {
            hashMap.put(FIELD_PARAM, this.getParam());
        }
        if (!bl || this.isParam2Dirty()) {
            hashMap.put(FIELD_PARAM2, this.getParam2());
        }
        if (!bl || this.isParam3Dirty()) {
            hashMap.put(FIELD_PARAM3, this.getParam3());
        }
        if (!bl || this.isParam4Dirty()) {
            hashMap.put(FIELD_PARAM4, this.getParam4());
        }
        if (!bl || this.isParam5Dirty()) {
            hashMap.put(FIELD_PARAM5, this.getParam5());
        }
        if (!bl || this.isParam6Dirty()) {
            hashMap.put(FIELD_PARAM6, this.getParam6());
        }
        if (!bl || this.isParam7Dirty()) {
            hashMap.put(FIELD_PARAM7, this.getParam7());
        }
        if (!bl || this.isParam8Dirty()) {
            hashMap.put(FIELD_PARAM8, this.getParam8());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPSAppServerIdDirty()) {
            hashMap.put(FIELD_PSAPPSERVERID, this.getPSAppServerId());
        }
        if (!bl || this.isPSAppServerNameDirty()) {
            hashMap.put(FIELD_PSAPPSERVERNAME, this.getPSAppServerName());
        }
        if (!bl || this.isPSDBDevInstIdDirty()) {
            hashMap.put(FIELD_PSDBDEVINSTID, this.getPSDBDevInstId());
        }
        if (!bl || this.isPSDBDevInstNameDirty()) {
            hashMap.put(FIELD_PSDBDEVINSTNAME, this.getPSDBDevInstName());
        }
        if (!bl || this.isPSDBServerIdDirty()) {
            hashMap.put(FIELD_PSDBSERVERID, this.getPSDBServerId());
        }
        if (!bl || this.isPSDBServerNameDirty()) {
            hashMap.put(FIELD_PSDBSERVERNAME, this.getPSDBServerName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isRefInfoDirty()) {
            hashMap.put(FIELD_REFINFO, this.getRefInfo());
        }
        if (!bl || this.isRefObjIdDirty()) {
            hashMap.put(FIELD_REFOBJID, this.getRefObjId());
        }
        if (!bl || this.isTimeShareModeDirty()) {
            hashMap.put(FIELD_TIMESHAREMODE, this.getTimeShareMode());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsageModeDirty()) {
            hashMap.put(FIELD_USAGEMODE, this.getUsageMode());
        }
        if (!bl || this.isUsedSizeDirty()) {
            hashMap.put(FIELD_USEDSIZE, this.getUsedSize());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
        }
        if (!bl || this.isWebConsolePathDirty()) {
            hashMap.put(FIELD_WEBCONSOLEPATH, this.getWebConsolePath());
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
        return PSDBDevInstBase.get(this, n);
    }

    private static Object get(PSDBDevInstBase pSDBDevInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBDevInstBase.getAllocSize();
            }
            case 1: {
                return pSDBDevInstBase.getConnStr();
            }
            case 2: {
                return pSDBDevInstBase.getConnStrFmt();
            }
            case 3: {
                return pSDBDevInstBase.getCreateDate();
            }
            case 4: {
                return pSDBDevInstBase.getCreateMan();
            }
            case 5: {
                return pSDBDevInstBase.getCurDBAction();
            }
            case 6: {
                return pSDBDevInstBase.getDBName();
            }
            case 7: {
                return pSDBDevInstBase.getDBSchema();
            }
            case 8: {
                return pSDBDevInstBase.getDBType();
            }
            case 9: {
                return pSDBDevInstBase.getDMPassWD();
            }
            case 10: {
                return pSDBDevInstBase.getDMUserName();
            }
            case 11: {
                return pSDBDevInstBase.getInstState();
            }
            case 12: {
                return pSDBDevInstBase.getLocalRes();
            }
            case 13: {
                return pSDBDevInstBase.getMemo();
            }
            case 14: {
                return pSDBDevInstBase.getParam();
            }
            case 15: {
                return pSDBDevInstBase.getParam2();
            }
            case 16: {
                return pSDBDevInstBase.getParam3();
            }
            case 17: {
                return pSDBDevInstBase.getParam4();
            }
            case 18: {
                return pSDBDevInstBase.getParam5();
            }
            case 19: {
                return pSDBDevInstBase.getParam6();
            }
            case 20: {
                return pSDBDevInstBase.getParam7();
            }
            case 21: {
                return pSDBDevInstBase.getParam8();
            }
            case 22: {
                return pSDBDevInstBase.getPasswd();
            }
            case 23: {
                return pSDBDevInstBase.getPSAppServerId();
            }
            case 24: {
                return pSDBDevInstBase.getPSAppServerName();
            }
            case 25: {
                return pSDBDevInstBase.getPSDBDevInstId();
            }
            case 26: {
                return pSDBDevInstBase.getPSDBDevInstName();
            }
            case 27: {
                return pSDBDevInstBase.getPSDBServerId();
            }
            case 28: {
                return pSDBDevInstBase.getPSDBServerName();
            }
            case 29: {
                return pSDBDevInstBase.getPSDevCenterId();
            }
            case 30: {
                return pSDBDevInstBase.getPSDevCenterName();
            }
            case 31: {
                return pSDBDevInstBase.getPSSvrDomainId();
            }
            case 32: {
                return pSDBDevInstBase.getPSSvrDomainName();
            }
            case 33: {
                return pSDBDevInstBase.getRefInfo();
            }
            case 34: {
                return pSDBDevInstBase.getRefObjId();
            }
            case 35: {
                return pSDBDevInstBase.getTimeShareMode();
            }
            case 36: {
                return pSDBDevInstBase.getUpdateDate();
            }
            case 37: {
                return pSDBDevInstBase.getUpdateMan();
            }
            case 38: {
                return pSDBDevInstBase.getUsageMode();
            }
            case 39: {
                return pSDBDevInstBase.getUsedSize();
            }
            case 40: {
                return pSDBDevInstBase.getUserName();
            }
            case 41: {
                return pSDBDevInstBase.getWebConsolePath();
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
        PSDBDevInstBase.set(this, n, object);
    }

    private static void set(PSDBDevInstBase pSDBDevInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDBDevInstBase.setAllocSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDBDevInstBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDBDevInstBase.setConnStrFmt(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDBDevInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDBDevInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDBDevInstBase.setCurDBAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDBDevInstBase.setDBName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDBDevInstBase.setDBSchema(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDBDevInstBase.setDBType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDBDevInstBase.setDMPassWD(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDBDevInstBase.setDMUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDBDevInstBase.setInstState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDBDevInstBase.setLocalRes(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDBDevInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDBDevInstBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDBDevInstBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDBDevInstBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDBDevInstBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDBDevInstBase.setParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDBDevInstBase.setParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDBDevInstBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDBDevInstBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDBDevInstBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDBDevInstBase.setPSAppServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDBDevInstBase.setPSAppServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDBDevInstBase.setPSDBDevInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDBDevInstBase.setPSDBDevInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDBDevInstBase.setPSDBServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDBDevInstBase.setPSDBServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDBDevInstBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDBDevInstBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDBDevInstBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDBDevInstBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDBDevInstBase.setRefInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDBDevInstBase.setRefObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDBDevInstBase.setTimeShareMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSDBDevInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 37: {
                pSDBDevInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDBDevInstBase.setUsageMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDBDevInstBase.setUsedSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSDBDevInstBase.setUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDBDevInstBase.setWebConsolePath(DataObject.getStringValue((Object)object));
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
        return PSDBDevInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDBDevInstBase pSDBDevInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBDevInstBase.getAllocSize() == null;
            }
            case 1: {
                return pSDBDevInstBase.getConnStr() == null;
            }
            case 2: {
                return pSDBDevInstBase.getConnStrFmt() == null;
            }
            case 3: {
                return pSDBDevInstBase.getCreateDate() == null;
            }
            case 4: {
                return pSDBDevInstBase.getCreateMan() == null;
            }
            case 5: {
                return pSDBDevInstBase.getCurDBAction() == null;
            }
            case 6: {
                return pSDBDevInstBase.getDBName() == null;
            }
            case 7: {
                return pSDBDevInstBase.getDBSchema() == null;
            }
            case 8: {
                return pSDBDevInstBase.getDBType() == null;
            }
            case 9: {
                return pSDBDevInstBase.getDMPassWD() == null;
            }
            case 10: {
                return pSDBDevInstBase.getDMUserName() == null;
            }
            case 11: {
                return pSDBDevInstBase.getInstState() == null;
            }
            case 12: {
                return pSDBDevInstBase.getLocalRes() == null;
            }
            case 13: {
                return pSDBDevInstBase.getMemo() == null;
            }
            case 14: {
                return pSDBDevInstBase.getParam() == null;
            }
            case 15: {
                return pSDBDevInstBase.getParam2() == null;
            }
            case 16: {
                return pSDBDevInstBase.getParam3() == null;
            }
            case 17: {
                return pSDBDevInstBase.getParam4() == null;
            }
            case 18: {
                return pSDBDevInstBase.getParam5() == null;
            }
            case 19: {
                return pSDBDevInstBase.getParam6() == null;
            }
            case 20: {
                return pSDBDevInstBase.getParam7() == null;
            }
            case 21: {
                return pSDBDevInstBase.getParam8() == null;
            }
            case 22: {
                return pSDBDevInstBase.getPasswd() == null;
            }
            case 23: {
                return pSDBDevInstBase.getPSAppServerId() == null;
            }
            case 24: {
                return pSDBDevInstBase.getPSAppServerName() == null;
            }
            case 25: {
                return pSDBDevInstBase.getPSDBDevInstId() == null;
            }
            case 26: {
                return pSDBDevInstBase.getPSDBDevInstName() == null;
            }
            case 27: {
                return pSDBDevInstBase.getPSDBServerId() == null;
            }
            case 28: {
                return pSDBDevInstBase.getPSDBServerName() == null;
            }
            case 29: {
                return pSDBDevInstBase.getPSDevCenterId() == null;
            }
            case 30: {
                return pSDBDevInstBase.getPSDevCenterName() == null;
            }
            case 31: {
                return pSDBDevInstBase.getPSSvrDomainId() == null;
            }
            case 32: {
                return pSDBDevInstBase.getPSSvrDomainName() == null;
            }
            case 33: {
                return pSDBDevInstBase.getRefInfo() == null;
            }
            case 34: {
                return pSDBDevInstBase.getRefObjId() == null;
            }
            case 35: {
                return pSDBDevInstBase.getTimeShareMode() == null;
            }
            case 36: {
                return pSDBDevInstBase.getUpdateDate() == null;
            }
            case 37: {
                return pSDBDevInstBase.getUpdateMan() == null;
            }
            case 38: {
                return pSDBDevInstBase.getUsageMode() == null;
            }
            case 39: {
                return pSDBDevInstBase.getUsedSize() == null;
            }
            case 40: {
                return pSDBDevInstBase.getUserName() == null;
            }
            case 41: {
                return pSDBDevInstBase.getWebConsolePath() == null;
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
        return PSDBDevInstBase.contains(this, n);
    }

    private static boolean contains(PSDBDevInstBase pSDBDevInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBDevInstBase.isAllocSizeDirty();
            }
            case 1: {
                return pSDBDevInstBase.isConnStrDirty();
            }
            case 2: {
                return pSDBDevInstBase.isConnStrFmtDirty();
            }
            case 3: {
                return pSDBDevInstBase.isCreateDateDirty();
            }
            case 4: {
                return pSDBDevInstBase.isCreateManDirty();
            }
            case 5: {
                return pSDBDevInstBase.isCurDBActionDirty();
            }
            case 6: {
                return pSDBDevInstBase.isDBNameDirty();
            }
            case 7: {
                return pSDBDevInstBase.isDBSchemaDirty();
            }
            case 8: {
                return pSDBDevInstBase.isDBTypeDirty();
            }
            case 9: {
                return pSDBDevInstBase.isDMPassWDDirty();
            }
            case 10: {
                return pSDBDevInstBase.isDMUserNameDirty();
            }
            case 11: {
                return pSDBDevInstBase.isInstStateDirty();
            }
            case 12: {
                return pSDBDevInstBase.isLocalResDirty();
            }
            case 13: {
                return pSDBDevInstBase.isMemoDirty();
            }
            case 14: {
                return pSDBDevInstBase.isParamDirty();
            }
            case 15: {
                return pSDBDevInstBase.isParam2Dirty();
            }
            case 16: {
                return pSDBDevInstBase.isParam3Dirty();
            }
            case 17: {
                return pSDBDevInstBase.isParam4Dirty();
            }
            case 18: {
                return pSDBDevInstBase.isParam5Dirty();
            }
            case 19: {
                return pSDBDevInstBase.isParam6Dirty();
            }
            case 20: {
                return pSDBDevInstBase.isParam7Dirty();
            }
            case 21: {
                return pSDBDevInstBase.isParam8Dirty();
            }
            case 22: {
                return pSDBDevInstBase.isPasswdDirty();
            }
            case 23: {
                return pSDBDevInstBase.isPSAppServerIdDirty();
            }
            case 24: {
                return pSDBDevInstBase.isPSAppServerNameDirty();
            }
            case 25: {
                return pSDBDevInstBase.isPSDBDevInstIdDirty();
            }
            case 26: {
                return pSDBDevInstBase.isPSDBDevInstNameDirty();
            }
            case 27: {
                return pSDBDevInstBase.isPSDBServerIdDirty();
            }
            case 28: {
                return pSDBDevInstBase.isPSDBServerNameDirty();
            }
            case 29: {
                return pSDBDevInstBase.isPSDevCenterIdDirty();
            }
            case 30: {
                return pSDBDevInstBase.isPSDevCenterNameDirty();
            }
            case 31: {
                return pSDBDevInstBase.isPSSvrDomainIdDirty();
            }
            case 32: {
                return pSDBDevInstBase.isPSSvrDomainNameDirty();
            }
            case 33: {
                return pSDBDevInstBase.isRefInfoDirty();
            }
            case 34: {
                return pSDBDevInstBase.isRefObjIdDirty();
            }
            case 35: {
                return pSDBDevInstBase.isTimeShareModeDirty();
            }
            case 36: {
                return pSDBDevInstBase.isUpdateDateDirty();
            }
            case 37: {
                return pSDBDevInstBase.isUpdateManDirty();
            }
            case 38: {
                return pSDBDevInstBase.isUsageModeDirty();
            }
            case 39: {
                return pSDBDevInstBase.isUsedSizeDirty();
            }
            case 40: {
                return pSDBDevInstBase.isUserNameDirty();
            }
            case 41: {
                return pSDBDevInstBase.isWebConsolePathDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDBDevInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDBDevInstBase pSDBDevInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDBDevInstBase.getAllocSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allocsize", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getAllocSize()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getConnStr()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getConnStrFmt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstrfmt", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getConnStrFmt()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getCurDBAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curdbaction", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getCurDBAction()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getDBName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbname", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getDBName()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getDBSchema() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbschema", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getDBSchema()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getDBType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtype", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getDBType()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getDMPassWD() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dmpasswd", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getDMPassWD()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getDMUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dmusername", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getDMUserName()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getInstState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inststate", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getInstState()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getLocalRes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"localres", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getLocalRes()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getParam()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getParam2()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getParam3()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getParam4()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getParam5()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getParam6()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getParam7()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getParam8()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getPSAppServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappserverid", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getPSAppServerId()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getPSAppServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappservername", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getPSAppServerName()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getPSDBDevInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbdevinstid", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getPSDBDevInstId()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getPSDBDevInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbdevinstname", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getPSDBDevInstName()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getPSDBServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbserverid", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getPSDBServerId()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getPSDBServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbservername", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getPSDBServerName()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getRefInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refinfo", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getRefInfo()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getRefObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjid", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getRefObjId()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getTimeShareMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timesharemode", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getTimeShareMode()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getUsageMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usagemode", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getUsageMode()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getUsedSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usedsize", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getUsedSize()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getUserName()), (boolean)false);
        }
        if (bl || pSDBDevInstBase.getWebConsolePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"webconsolepath", (Object)PSDBDevInstBase.getJSONValue((Object)pSDBDevInstBase.getWebConsolePath()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDBDevInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDBDevInstBase pSDBDevInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDBDevInstBase.getAllocSize() != null) {
            object = pSDBDevInstBase.getAllocSize();
            xmlNode.setAttribute(FIELD_ALLOCSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBDevInstBase.getConnStr() != null) {
            object = pSDBDevInstBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getConnStrFmt() != null) {
            object = pSDBDevInstBase.getConnStrFmt();
            xmlNode.setAttribute(FIELD_CONNSTRFMT, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getCreateDate() != null) {
            object = pSDBDevInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBDevInstBase.getCreateMan() != null) {
            object = pSDBDevInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getCurDBAction() != null) {
            object = pSDBDevInstBase.getCurDBAction();
            xmlNode.setAttribute(FIELD_CURDBACTION, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getDBName() != null) {
            object = pSDBDevInstBase.getDBName();
            xmlNode.setAttribute(FIELD_DBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getDBSchema() != null) {
            object = pSDBDevInstBase.getDBSchema();
            xmlNode.setAttribute(FIELD_DBSCHEMA, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getDBType() != null) {
            object = pSDBDevInstBase.getDBType();
            xmlNode.setAttribute(FIELD_DBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getDMPassWD() != null) {
            object = pSDBDevInstBase.getDMPassWD();
            xmlNode.setAttribute(FIELD_DMPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getDMUserName() != null) {
            object = pSDBDevInstBase.getDMUserName();
            xmlNode.setAttribute(FIELD_DMUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getInstState() != null) {
            object = pSDBDevInstBase.getInstState();
            xmlNode.setAttribute(FIELD_INSTSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBDevInstBase.getLocalRes() != null) {
            object = pSDBDevInstBase.getLocalRes();
            xmlNode.setAttribute(FIELD_LOCALRES, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBDevInstBase.getMemo() != null) {
            object = pSDBDevInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getParam() != null) {
            object = pSDBDevInstBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getParam2() != null) {
            object = pSDBDevInstBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getParam3() != null) {
            object = pSDBDevInstBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getParam4() != null) {
            object = pSDBDevInstBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getParam5() != null) {
            object = pSDBDevInstBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBDevInstBase.getParam6() != null) {
            object = pSDBDevInstBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBDevInstBase.getParam7() != null) {
            object = pSDBDevInstBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBDevInstBase.getParam8() != null) {
            object = pSDBDevInstBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBDevInstBase.getPasswd() != null) {
            object = pSDBDevInstBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getPSAppServerId() != null) {
            object = pSDBDevInstBase.getPSAppServerId();
            xmlNode.setAttribute(FIELD_PSAPPSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getPSAppServerName() != null) {
            object = pSDBDevInstBase.getPSAppServerName();
            xmlNode.setAttribute(FIELD_PSAPPSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getPSDBDevInstId() != null) {
            object = pSDBDevInstBase.getPSDBDevInstId();
            xmlNode.setAttribute(FIELD_PSDBDEVINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getPSDBDevInstName() != null) {
            object = pSDBDevInstBase.getPSDBDevInstName();
            xmlNode.setAttribute(FIELD_PSDBDEVINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getPSDBServerId() != null) {
            object = pSDBDevInstBase.getPSDBServerId();
            xmlNode.setAttribute(FIELD_PSDBSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getPSDBServerName() != null) {
            object = pSDBDevInstBase.getPSDBServerName();
            xmlNode.setAttribute(FIELD_PSDBSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getPSDevCenterId() != null) {
            object = pSDBDevInstBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getPSDevCenterName() != null) {
            object = pSDBDevInstBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getPSSvrDomainId() != null) {
            object = pSDBDevInstBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getPSSvrDomainName() != null) {
            object = pSDBDevInstBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getRefInfo() != null) {
            object = pSDBDevInstBase.getRefInfo();
            xmlNode.setAttribute(FIELD_REFINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getRefObjId() != null) {
            object = pSDBDevInstBase.getRefObjId();
            xmlNode.setAttribute(FIELD_REFOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getTimeShareMode() != null) {
            object = pSDBDevInstBase.getTimeShareMode();
            xmlNode.setAttribute(FIELD_TIMESHAREMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBDevInstBase.getUpdateDate() != null) {
            object = pSDBDevInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBDevInstBase.getUpdateMan() != null) {
            object = pSDBDevInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getUsageMode() != null) {
            object = pSDBDevInstBase.getUsageMode();
            xmlNode.setAttribute(FIELD_USAGEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getUsedSize() != null) {
            object = pSDBDevInstBase.getUsedSize();
            xmlNode.setAttribute(FIELD_USEDSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBDevInstBase.getUserName() != null) {
            object = pSDBDevInstBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBase.getWebConsolePath() != null) {
            object = pSDBDevInstBase.getWebConsolePath();
            xmlNode.setAttribute(FIELD_WEBCONSOLEPATH, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDBDevInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDBDevInstBase pSDBDevInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDBDevInstBase.isAllocSizeDirty() && (bl || pSDBDevInstBase.getAllocSize() != null)) {
            iDataObject.set(FIELD_ALLOCSIZE, (Object)pSDBDevInstBase.getAllocSize());
        }
        if (pSDBDevInstBase.isConnStrDirty() && (bl || pSDBDevInstBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSDBDevInstBase.getConnStr());
        }
        if (pSDBDevInstBase.isConnStrFmtDirty() && (bl || pSDBDevInstBase.getConnStrFmt() != null)) {
            iDataObject.set(FIELD_CONNSTRFMT, (Object)pSDBDevInstBase.getConnStrFmt());
        }
        if (pSDBDevInstBase.isCreateDateDirty() && (bl || pSDBDevInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDBDevInstBase.getCreateDate());
        }
        if (pSDBDevInstBase.isCreateManDirty() && (bl || pSDBDevInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDBDevInstBase.getCreateMan());
        }
        if (pSDBDevInstBase.isCurDBActionDirty() && (bl || pSDBDevInstBase.getCurDBAction() != null)) {
            iDataObject.set(FIELD_CURDBACTION, (Object)pSDBDevInstBase.getCurDBAction());
        }
        if (pSDBDevInstBase.isDBNameDirty() && (bl || pSDBDevInstBase.getDBName() != null)) {
            iDataObject.set(FIELD_DBNAME, (Object)pSDBDevInstBase.getDBName());
        }
        if (pSDBDevInstBase.isDBSchemaDirty() && (bl || pSDBDevInstBase.getDBSchema() != null)) {
            iDataObject.set(FIELD_DBSCHEMA, (Object)pSDBDevInstBase.getDBSchema());
        }
        if (pSDBDevInstBase.isDBTypeDirty() && (bl || pSDBDevInstBase.getDBType() != null)) {
            iDataObject.set(FIELD_DBTYPE, (Object)pSDBDevInstBase.getDBType());
        }
        if (pSDBDevInstBase.isDMPassWDDirty() && (bl || pSDBDevInstBase.getDMPassWD() != null)) {
            iDataObject.set(FIELD_DMPASSWD, (Object)pSDBDevInstBase.getDMPassWD());
        }
        if (pSDBDevInstBase.isDMUserNameDirty() && (bl || pSDBDevInstBase.getDMUserName() != null)) {
            iDataObject.set(FIELD_DMUSERNAME, (Object)pSDBDevInstBase.getDMUserName());
        }
        if (pSDBDevInstBase.isInstStateDirty() && (bl || pSDBDevInstBase.getInstState() != null)) {
            iDataObject.set(FIELD_INSTSTATE, (Object)pSDBDevInstBase.getInstState());
        }
        if (pSDBDevInstBase.isLocalResDirty() && (bl || pSDBDevInstBase.getLocalRes() != null)) {
            iDataObject.set(FIELD_LOCALRES, (Object)pSDBDevInstBase.getLocalRes());
        }
        if (pSDBDevInstBase.isMemoDirty() && (bl || pSDBDevInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDBDevInstBase.getMemo());
        }
        if (pSDBDevInstBase.isParamDirty() && (bl || pSDBDevInstBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSDBDevInstBase.getParam());
        }
        if (pSDBDevInstBase.isParam2Dirty() && (bl || pSDBDevInstBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSDBDevInstBase.getParam2());
        }
        if (pSDBDevInstBase.isParam3Dirty() && (bl || pSDBDevInstBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSDBDevInstBase.getParam3());
        }
        if (pSDBDevInstBase.isParam4Dirty() && (bl || pSDBDevInstBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSDBDevInstBase.getParam4());
        }
        if (pSDBDevInstBase.isParam5Dirty() && (bl || pSDBDevInstBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSDBDevInstBase.getParam5());
        }
        if (pSDBDevInstBase.isParam6Dirty() && (bl || pSDBDevInstBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSDBDevInstBase.getParam6());
        }
        if (pSDBDevInstBase.isParam7Dirty() && (bl || pSDBDevInstBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSDBDevInstBase.getParam7());
        }
        if (pSDBDevInstBase.isParam8Dirty() && (bl || pSDBDevInstBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSDBDevInstBase.getParam8());
        }
        if (pSDBDevInstBase.isPasswdDirty() && (bl || pSDBDevInstBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDBDevInstBase.getPasswd());
        }
        if (pSDBDevInstBase.isPSAppServerIdDirty() && (bl || pSDBDevInstBase.getPSAppServerId() != null)) {
            iDataObject.set(FIELD_PSAPPSERVERID, (Object)pSDBDevInstBase.getPSAppServerId());
        }
        if (pSDBDevInstBase.isPSAppServerNameDirty() && (bl || pSDBDevInstBase.getPSAppServerName() != null)) {
            iDataObject.set(FIELD_PSAPPSERVERNAME, (Object)pSDBDevInstBase.getPSAppServerName());
        }
        if (pSDBDevInstBase.isPSDBDevInstIdDirty() && (bl || pSDBDevInstBase.getPSDBDevInstId() != null)) {
            iDataObject.set(FIELD_PSDBDEVINSTID, (Object)pSDBDevInstBase.getPSDBDevInstId());
        }
        if (pSDBDevInstBase.isPSDBDevInstNameDirty() && (bl || pSDBDevInstBase.getPSDBDevInstName() != null)) {
            iDataObject.set(FIELD_PSDBDEVINSTNAME, (Object)pSDBDevInstBase.getPSDBDevInstName());
        }
        if (pSDBDevInstBase.isPSDBServerIdDirty() && (bl || pSDBDevInstBase.getPSDBServerId() != null)) {
            iDataObject.set(FIELD_PSDBSERVERID, (Object)pSDBDevInstBase.getPSDBServerId());
        }
        if (pSDBDevInstBase.isPSDBServerNameDirty() && (bl || pSDBDevInstBase.getPSDBServerName() != null)) {
            iDataObject.set(FIELD_PSDBSERVERNAME, (Object)pSDBDevInstBase.getPSDBServerName());
        }
        if (pSDBDevInstBase.isPSDevCenterIdDirty() && (bl || pSDBDevInstBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDBDevInstBase.getPSDevCenterId());
        }
        if (pSDBDevInstBase.isPSDevCenterNameDirty() && (bl || pSDBDevInstBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDBDevInstBase.getPSDevCenterName());
        }
        if (pSDBDevInstBase.isPSSvrDomainIdDirty() && (bl || pSDBDevInstBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSDBDevInstBase.getPSSvrDomainId());
        }
        if (pSDBDevInstBase.isPSSvrDomainNameDirty() && (bl || pSDBDevInstBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSDBDevInstBase.getPSSvrDomainName());
        }
        if (pSDBDevInstBase.isRefInfoDirty() && (bl || pSDBDevInstBase.getRefInfo() != null)) {
            iDataObject.set(FIELD_REFINFO, (Object)pSDBDevInstBase.getRefInfo());
        }
        if (pSDBDevInstBase.isRefObjIdDirty() && (bl || pSDBDevInstBase.getRefObjId() != null)) {
            iDataObject.set(FIELD_REFOBJID, (Object)pSDBDevInstBase.getRefObjId());
        }
        if (pSDBDevInstBase.isTimeShareModeDirty() && (bl || pSDBDevInstBase.getTimeShareMode() != null)) {
            iDataObject.set(FIELD_TIMESHAREMODE, (Object)pSDBDevInstBase.getTimeShareMode());
        }
        if (pSDBDevInstBase.isUpdateDateDirty() && (bl || pSDBDevInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDBDevInstBase.getUpdateDate());
        }
        if (pSDBDevInstBase.isUpdateManDirty() && (bl || pSDBDevInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDBDevInstBase.getUpdateMan());
        }
        if (pSDBDevInstBase.isUsageModeDirty() && (bl || pSDBDevInstBase.getUsageMode() != null)) {
            iDataObject.set(FIELD_USAGEMODE, (Object)pSDBDevInstBase.getUsageMode());
        }
        if (pSDBDevInstBase.isUsedSizeDirty() && (bl || pSDBDevInstBase.getUsedSize() != null)) {
            iDataObject.set(FIELD_USEDSIZE, (Object)pSDBDevInstBase.getUsedSize());
        }
        if (pSDBDevInstBase.isUserNameDirty() && (bl || pSDBDevInstBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSDBDevInstBase.getUserName());
        }
        if (pSDBDevInstBase.isWebConsolePathDirty() && (bl || pSDBDevInstBase.getWebConsolePath() != null)) {
            iDataObject.set(FIELD_WEBCONSOLEPATH, (Object)pSDBDevInstBase.getWebConsolePath());
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
        return PSDBDevInstBase.remove(this, n);
    }

    private static boolean remove(PSDBDevInstBase pSDBDevInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDBDevInstBase.resetAllocSize();
                return true;
            }
            case 1: {
                pSDBDevInstBase.resetConnStr();
                return true;
            }
            case 2: {
                pSDBDevInstBase.resetConnStrFmt();
                return true;
            }
            case 3: {
                pSDBDevInstBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDBDevInstBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDBDevInstBase.resetCurDBAction();
                return true;
            }
            case 6: {
                pSDBDevInstBase.resetDBName();
                return true;
            }
            case 7: {
                pSDBDevInstBase.resetDBSchema();
                return true;
            }
            case 8: {
                pSDBDevInstBase.resetDBType();
                return true;
            }
            case 9: {
                pSDBDevInstBase.resetDMPassWD();
                return true;
            }
            case 10: {
                pSDBDevInstBase.resetDMUserName();
                return true;
            }
            case 11: {
                pSDBDevInstBase.resetInstState();
                return true;
            }
            case 12: {
                pSDBDevInstBase.resetLocalRes();
                return true;
            }
            case 13: {
                pSDBDevInstBase.resetMemo();
                return true;
            }
            case 14: {
                pSDBDevInstBase.resetParam();
                return true;
            }
            case 15: {
                pSDBDevInstBase.resetParam2();
                return true;
            }
            case 16: {
                pSDBDevInstBase.resetParam3();
                return true;
            }
            case 17: {
                pSDBDevInstBase.resetParam4();
                return true;
            }
            case 18: {
                pSDBDevInstBase.resetParam5();
                return true;
            }
            case 19: {
                pSDBDevInstBase.resetParam6();
                return true;
            }
            case 20: {
                pSDBDevInstBase.resetParam7();
                return true;
            }
            case 21: {
                pSDBDevInstBase.resetParam8();
                return true;
            }
            case 22: {
                pSDBDevInstBase.resetPasswd();
                return true;
            }
            case 23: {
                pSDBDevInstBase.resetPSAppServerId();
                return true;
            }
            case 24: {
                pSDBDevInstBase.resetPSAppServerName();
                return true;
            }
            case 25: {
                pSDBDevInstBase.resetPSDBDevInstId();
                return true;
            }
            case 26: {
                pSDBDevInstBase.resetPSDBDevInstName();
                return true;
            }
            case 27: {
                pSDBDevInstBase.resetPSDBServerId();
                return true;
            }
            case 28: {
                pSDBDevInstBase.resetPSDBServerName();
                return true;
            }
            case 29: {
                pSDBDevInstBase.resetPSDevCenterId();
                return true;
            }
            case 30: {
                pSDBDevInstBase.resetPSDevCenterName();
                return true;
            }
            case 31: {
                pSDBDevInstBase.resetPSSvrDomainId();
                return true;
            }
            case 32: {
                pSDBDevInstBase.resetPSSvrDomainName();
                return true;
            }
            case 33: {
                pSDBDevInstBase.resetRefInfo();
                return true;
            }
            case 34: {
                pSDBDevInstBase.resetRefObjId();
                return true;
            }
            case 35: {
                pSDBDevInstBase.resetTimeShareMode();
                return true;
            }
            case 36: {
                pSDBDevInstBase.resetUpdateDate();
                return true;
            }
            case 37: {
                pSDBDevInstBase.resetUpdateMan();
                return true;
            }
            case 38: {
                pSDBDevInstBase.resetUsageMode();
                return true;
            }
            case 39: {
                pSDBDevInstBase.resetUsedSize();
                return true;
            }
            case 40: {
                pSDBDevInstBase.resetUserName();
                return true;
            }
            case 41: {
                pSDBDevInstBase.resetWebConsolePath();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppServer getPSAppServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppServer();
        }
        if (this.getPSAppServerId() == null) {
            return null;
        }
        Integer n = this.objPSAppServerLock;
        synchronized (n) {
            if (this.psappserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppServerId(), (Object)this.psappserver.getPSAppServerId()) != 0L) {
                this.psappserver = null;
            }
            if (this.psappserver == null) {
                PSAppServer pSAppServer = new PSAppServer();
                pSAppServer.setPSAppServerId(this.getPSAppServerId());
                PSAppServerService pSAppServerService = (PSAppServerService)ServiceGlobal.getService(PSAppServerService.class, (SessionFactory)this.getSessionFactory());
                pSAppServerService.autoGet((IEntity)pSAppServer);
                this.psappserver = pSAppServer;
            }
            return this.psappserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBServer getPSDBServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBServer();
        }
        if (this.getPSDBServerId() == null) {
            return null;
        }
        Integer n = this.objPSDBServerLock;
        synchronized (n) {
            if (this.psdbserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBServerId(), (Object)this.psdbserver.getPSDBServerId()) != 0L) {
                this.psdbserver = null;
            }
            if (this.psdbserver == null) {
                PSDBServer pSDBServer = new PSDBServer();
                pSDBServer.setPSDBServerId(this.getPSDBServerId());
                PSDBServerService pSDBServerService = (PSDBServerService)ServiceGlobal.getService(PSDBServerService.class, (SessionFactory)this.getSessionFactory());
                pSDBServerService.autoGet((IEntity)pSDBServer);
                this.psdbserver = pSDBServer;
            }
            return this.psdbserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrDomain getPSSvrDomain() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomain();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        Integer n = this.objPSSvrDomainLock;
        synchronized (n) {
            if (this.pssvrdomain != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvrDomainId(), (Object)this.pssvrdomain.getPSSvrDomainId()) != 0L) {
                this.pssvrdomain = null;
            }
            if (this.pssvrdomain == null) {
                PSSvrDomain pSSvrDomain = new PSSvrDomain();
                pSSvrDomain.setPSSvrDomainId(this.getPSSvrDomainId());
                PSSvrDomainService pSSvrDomainService = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)this.getSessionFactory());
                pSSvrDomainService.autoGet((IEntity)pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    private PSDBDevInstBase getProxyEntity() {
        return this.proxyPSDBDevInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDBDevInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDBDevInstBase) {
            this.proxyPSDBDevInstBase = (PSDBDevInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOCSIZE, 0);
        fieldIndexMap.put(FIELD_CONNSTR, 1);
        fieldIndexMap.put(FIELD_CONNSTRFMT, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_CURDBACTION, 5);
        fieldIndexMap.put(FIELD_DBNAME, 6);
        fieldIndexMap.put(FIELD_DBSCHEMA, 7);
        fieldIndexMap.put(FIELD_DBTYPE, 8);
        fieldIndexMap.put(FIELD_DMPASSWD, 9);
        fieldIndexMap.put(FIELD_DMUSERNAME, 10);
        fieldIndexMap.put(FIELD_INSTSTATE, 11);
        fieldIndexMap.put(FIELD_LOCALRES, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_PARAM, 14);
        fieldIndexMap.put(FIELD_PARAM2, 15);
        fieldIndexMap.put(FIELD_PARAM3, 16);
        fieldIndexMap.put(FIELD_PARAM4, 17);
        fieldIndexMap.put(FIELD_PARAM5, 18);
        fieldIndexMap.put(FIELD_PARAM6, 19);
        fieldIndexMap.put(FIELD_PARAM7, 20);
        fieldIndexMap.put(FIELD_PARAM8, 21);
        fieldIndexMap.put(FIELD_PASSWD, 22);
        fieldIndexMap.put(FIELD_PSAPPSERVERID, 23);
        fieldIndexMap.put(FIELD_PSAPPSERVERNAME, 24);
        fieldIndexMap.put(FIELD_PSDBDEVINSTID, 25);
        fieldIndexMap.put(FIELD_PSDBDEVINSTNAME, 26);
        fieldIndexMap.put(FIELD_PSDBSERVERID, 27);
        fieldIndexMap.put(FIELD_PSDBSERVERNAME, 28);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 29);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 30);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 31);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 32);
        fieldIndexMap.put(FIELD_REFINFO, 33);
        fieldIndexMap.put(FIELD_REFOBJID, 34);
        fieldIndexMap.put(FIELD_TIMESHAREMODE, 35);
        fieldIndexMap.put(FIELD_UPDATEDATE, 36);
        fieldIndexMap.put(FIELD_UPDATEMAN, 37);
        fieldIndexMap.put(FIELD_USAGEMODE, 38);
        fieldIndexMap.put(FIELD_USEDSIZE, 39);
        fieldIndexMap.put(FIELD_USERNAME, 40);
        fieldIndexMap.put(FIELD_WEBCONSOLEPATH, 41);
    }
}

