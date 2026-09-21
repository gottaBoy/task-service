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
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelInstBase.class);
    public static final String FIELD_BEGINCALCTIME = "BEGINCALCTIME";
    public static final String FIELD_BEGINMAINTAINTIME = "BEGINMAINTAINTIME";
    public static final String FIELD_CONFPSSYSMODELINSTID = "CONFPSSYSMODELINSTID";
    public static final String FIELD_CONFPSSYSMODELINSTNAME = "CONFPSSYSMODELINSTNAME";
    public static final String FIELD_CONNSTR = "CONNSTR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURDBACTION = "CURDBACTION";
    public static final String FIELD_DBNAME = "DBNAME";
    public static final String FIELD_DBTYPE = "DBTYPE";
    public static final String FIELD_ENDCALCTIME = "ENDCALCTIME";
    public static final String FIELD_ENDMAINTAINTIME = "ENDMAINTAINTIME";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_INITPOOLSIZE = "INITPOOLSIZE";
    public static final String FIELD_INSTGROUP = "INSTGROUP";
    public static final String FIELD_INSTSTATE = "INSTSTATE";
    public static final String FIELD_MAXPOOLSIZE = "MAXPOOLSIZE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINPOOLSIZE = "MINPOOLSIZE";
    public static final String FIELD_MODELVER = "MODELVER";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PARAM5 = "PARAM5";
    public static final String FIELD_PARAM6 = "PARAM6";
    public static final String FIELD_PARAM7 = "PARAM7";
    public static final String FIELD_PARAM8 = "PARAM8";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PATCHNUM = "PATCHNUM";
    public static final String FIELD_PSDBSERVERID = "PSDBSERVERID";
    public static final String FIELD_PSDBSERVERNAME = "PSDBSERVERNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String FIELD_REFINFO = "REFINFO";
    public static final String FIELD_ROWCNT = "ROWCNT";
    public static final String FIELD_SHAREFLAG = "SHAREFLAG";
    public static final String FIELD_SYSROWKEY = "SYSROWKEY";
    public static final String FIELD_SYSTYPE = "SYSTYPE";
    public static final String FIELD_TEMPPSSYSMODELINSTID = "TEMPPSSYSMODELINSTID";
    public static final String FIELD_TEMPPSSYSMODELINSTNAME = "TEMPPSSYSMODELINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USEDSIZE = "USEDSIZE";
    public static final String FIELD_USERNAME = "USERNAME";
    private static final int INDEX_BEGINCALCTIME = 0;
    private static final int INDEX_BEGINMAINTAINTIME = 1;
    private static final int INDEX_CONFPSSYSMODELINSTID = 2;
    private static final int INDEX_CONFPSSYSMODELINSTNAME = 3;
    private static final int INDEX_CONNSTR = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_CURDBACTION = 7;
    private static final int INDEX_DBNAME = 8;
    private static final int INDEX_DBTYPE = 9;
    private static final int INDEX_ENDCALCTIME = 10;
    private static final int INDEX_ENDMAINTAINTIME = 11;
    private static final int INDEX_EXPRIEDTIME = 12;
    private static final int INDEX_INITPOOLSIZE = 13;
    private static final int INDEX_INSTGROUP = 14;
    private static final int INDEX_INSTSTATE = 15;
    private static final int INDEX_MAXPOOLSIZE = 16;
    private static final int INDEX_MEMO = 17;
    private static final int INDEX_MINPOOLSIZE = 18;
    private static final int INDEX_MODELVER = 19;
    private static final int INDEX_ORDERVALUE = 20;
    private static final int INDEX_PARAM = 21;
    private static final int INDEX_PARAM2 = 22;
    private static final int INDEX_PARAM3 = 23;
    private static final int INDEX_PARAM4 = 24;
    private static final int INDEX_PARAM5 = 25;
    private static final int INDEX_PARAM6 = 26;
    private static final int INDEX_PARAM7 = 27;
    private static final int INDEX_PARAM8 = 28;
    private static final int INDEX_PASSWD = 29;
    private static final int INDEX_PATCHNUM = 30;
    private static final int INDEX_PSDBSERVERID = 31;
    private static final int INDEX_PSDBSERVERNAME = 32;
    private static final int INDEX_PSDEVCENTERID = 33;
    private static final int INDEX_PSDEVCENTERNAME = 34;
    private static final int INDEX_PSSVRDOMAINID = 35;
    private static final int INDEX_PSSVRDOMAINNAME = 36;
    private static final int INDEX_PSSYSMODELINSTID = 37;
    private static final int INDEX_PSSYSMODELINSTNAME = 38;
    private static final int INDEX_REFINFO = 39;
    private static final int INDEX_ROWCNT = 40;
    private static final int INDEX_SHAREFLAG = 41;
    private static final int INDEX_SYSROWKEY = 42;
    private static final int INDEX_SYSTYPE = 43;
    private static final int INDEX_TEMPPSSYSMODELINSTID = 44;
    private static final int INDEX_TEMPPSSYSMODELINSTNAME = 45;
    private static final int INDEX_UPDATEDATE = 46;
    private static final int INDEX_UPDATEMAN = 47;
    private static final int INDEX_USEDSIZE = 48;
    private static final int INDEX_USERNAME = 49;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelInstBase proxyPSSysModelInstBase = null;
    private boolean begincalctimeDirtyFlag = false;
    private boolean beginmaintaintimeDirtyFlag = false;
    private boolean confpssysmodelinstidDirtyFlag = false;
    private boolean confpssysmodelinstnameDirtyFlag = false;
    private boolean connstrDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curdbactionDirtyFlag = false;
    private boolean dbnameDirtyFlag = false;
    private boolean dbtypeDirtyFlag = false;
    private boolean endcalctimeDirtyFlag = false;
    private boolean endmaintaintimeDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean initpoolsizeDirtyFlag = false;
    private boolean instgroupDirtyFlag = false;
    private boolean inststateDirtyFlag = false;
    private boolean maxpoolsizeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minpoolsizeDirtyFlag = false;
    private boolean modelverDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean patchnumDirtyFlag = false;
    private boolean psdbserveridDirtyFlag = false;
    private boolean psdbservernameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pssysmodelinstnameDirtyFlag = false;
    private boolean refinfoDirtyFlag = false;
    private boolean rowcntDirtyFlag = false;
    private boolean shareflagDirtyFlag = false;
    private boolean sysrowkeyDirtyFlag = false;
    private boolean systypeDirtyFlag = false;
    private boolean temppssysmodelinstidDirtyFlag = false;
    private boolean temppssysmodelinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usedsizeDirtyFlag = false;
    private boolean usernameDirtyFlag = false;
    @Column(name="begincalctime")
    private Timestamp begincalctime;
    @Column(name="beginmaintaintime")
    private Timestamp beginmaintaintime;
    @Column(name="confpssysmodelinstid")
    private String confpssysmodelinstid;
    @Column(name="confpssysmodelinstname")
    private String confpssysmodelinstname;
    @Column(name="connstr")
    private String connstr;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curdbaction")
    private String curdbaction;
    @Column(name="dbname")
    private String dbname;
    @Column(name="dbtype")
    private String dbtype;
    @Column(name="endcalctime")
    private Timestamp endcalctime;
    @Column(name="endmaintaintime")
    private Timestamp endmaintaintime;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="initpoolsize")
    private Integer initpoolsize;
    @Column(name="instgroup")
    private String instgroup;
    @Column(name="inststate")
    private String inststate;
    @Column(name="maxpoolsize")
    private Integer maxpoolsize;
    @Column(name="memo")
    private String memo;
    @Column(name="minpoolsize")
    private Integer minpoolsize;
    @Column(name="modelver")
    private Integer modelver;
    @Column(name="ordervalue")
    private Integer ordervalue;
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
    @Column(name="patchnum")
    private Integer patchnum;
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
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
    @Column(name="pssysmodelinstname")
    private String pssysmodelinstname;
    @Column(name="refinfo")
    private String refinfo;
    @Column(name="rowcnt")
    private Integer rowcnt;
    @Column(name="shareflag")
    private Integer shareflag;
    @Column(name="sysrowkey")
    private String sysrowkey;
    @Column(name="systype")
    private String systype;
    @Column(name="temppssysmodelinstid")
    private String temppssysmodelinstid;
    @Column(name="temppssysmodelinstname")
    private String temppssysmodelinstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usedsize")
    private Integer usedsize;
    @Column(name="username")
    private String username;
    private Integer objPSDBServerLock = new Integer(1);
    private PSDBServer psdbserver = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;
    private Integer objConfPSSysModelInstLock = new Integer(1);
    private PSSysModelInst confpssysmodelinst = null;
    private Integer objTempPSSysModelInstLock = new Integer(1);
    private PSSysModelInst temppssysmodelinst = null;

    public void setBeginCalcTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginCalcTime(timestamp);
            return;
        }
        this.begincalctime = timestamp;
        this.begincalctimeDirtyFlag = true;
    }

    public Timestamp getBeginCalcTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginCalcTime();
        }
        return this.begincalctime;
    }

    public boolean isBeginCalcTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginCalcTimeDirty();
        }
        return this.begincalctimeDirtyFlag;
    }

    public void resetBeginCalcTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginCalcTime();
            return;
        }
        this.begincalctimeDirtyFlag = false;
        this.begincalctime = null;
    }

    public void setBeginMaintainTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginMaintainTime(timestamp);
            return;
        }
        this.beginmaintaintime = timestamp;
        this.beginmaintaintimeDirtyFlag = true;
    }

    public Timestamp getBeginMaintainTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginMaintainTime();
        }
        return this.beginmaintaintime;
    }

    public boolean isBeginMaintainTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginMaintainTimeDirty();
        }
        return this.beginmaintaintimeDirtyFlag;
    }

    public void resetBeginMaintainTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginMaintainTime();
            return;
        }
        this.beginmaintaintimeDirtyFlag = false;
        this.beginmaintaintime = null;
    }

    public void setConfPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConfPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.confpssysmodelinstid = string;
        this.confpssysmodelinstidDirtyFlag = true;
    }

    public String getConfPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConfPSSysModelInstId();
        }
        return this.confpssysmodelinstid;
    }

    public boolean isConfPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConfPSSysModelInstIdDirty();
        }
        return this.confpssysmodelinstidDirtyFlag;
    }

    public void resetConfPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConfPSSysModelInstId();
            return;
        }
        this.confpssysmodelinstidDirtyFlag = false;
        this.confpssysmodelinstid = null;
    }

    public void setConfPSSysModelInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConfPSSysModelInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.confpssysmodelinstname = string;
        this.confpssysmodelinstnameDirtyFlag = true;
    }

    public String getConfPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConfPSSysModelInstName();
        }
        return this.confpssysmodelinstname;
    }

    public boolean isConfPSSysModelInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConfPSSysModelInstNameDirty();
        }
        return this.confpssysmodelinstnameDirtyFlag;
    }

    public void resetConfPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConfPSSysModelInstName();
            return;
        }
        this.confpssysmodelinstnameDirtyFlag = false;
        this.confpssysmodelinstname = null;
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

    public void setEndCalcTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndCalcTime(timestamp);
            return;
        }
        this.endcalctime = timestamp;
        this.endcalctimeDirtyFlag = true;
    }

    public Timestamp getEndCalcTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndCalcTime();
        }
        return this.endcalctime;
    }

    public boolean isEndCalcTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndCalcTimeDirty();
        }
        return this.endcalctimeDirtyFlag;
    }

    public void resetEndCalcTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndCalcTime();
            return;
        }
        this.endcalctimeDirtyFlag = false;
        this.endcalctime = null;
    }

    public void setEndMaintainTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndMaintainTime(timestamp);
            return;
        }
        this.endmaintaintime = timestamp;
        this.endmaintaintimeDirtyFlag = true;
    }

    public Timestamp getEndMaintainTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndMaintainTime();
        }
        return this.endmaintaintime;
    }

    public boolean isEndMaintainTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndMaintainTimeDirty();
        }
        return this.endmaintaintimeDirtyFlag;
    }

    public void resetEndMaintainTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndMaintainTime();
            return;
        }
        this.endmaintaintimeDirtyFlag = false;
        this.endmaintaintime = null;
    }

    public void setExpriedTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpriedTime(timestamp);
            return;
        }
        this.expriedtime = timestamp;
        this.expriedtimeDirtyFlag = true;
    }

    public Timestamp getExpriedTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpriedTime();
        }
        return this.expriedtime;
    }

    public boolean isExpriedTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpriedTimeDirty();
        }
        return this.expriedtimeDirtyFlag;
    }

    public void resetExpriedTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpriedTime();
            return;
        }
        this.expriedtimeDirtyFlag = false;
        this.expriedtime = null;
    }

    public void setInitPoolSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitPoolSize(n);
            return;
        }
        this.initpoolsize = n;
        this.initpoolsizeDirtyFlag = true;
    }

    public Integer getInitPoolSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPoolSize();
        }
        return this.initpoolsize;
    }

    public boolean isInitPoolSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitPoolSizeDirty();
        }
        return this.initpoolsizeDirtyFlag;
    }

    public void resetInitPoolSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitPoolSize();
            return;
        }
        this.initpoolsizeDirtyFlag = false;
        this.initpoolsize = null;
    }

    public void setInstGroup(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstGroup(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.instgroup = string;
        this.instgroupDirtyFlag = true;
    }

    public String getInstGroup() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstGroup();
        }
        return this.instgroup;
    }

    public boolean isInstGroupDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstGroupDirty();
        }
        return this.instgroupDirtyFlag;
    }

    public void resetInstGroup() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstGroup();
            return;
        }
        this.instgroupDirtyFlag = false;
        this.instgroup = null;
    }

    public void setInstState(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstState(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inststate = string;
        this.inststateDirtyFlag = true;
    }

    public String getInstState() {
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

    public void setMaxPoolSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxPoolSize(n);
            return;
        }
        this.maxpoolsize = n;
        this.maxpoolsizeDirtyFlag = true;
    }

    public Integer getMaxPoolSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxPoolSize();
        }
        return this.maxpoolsize;
    }

    public boolean isMaxPoolSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxPoolSizeDirty();
        }
        return this.maxpoolsizeDirtyFlag;
    }

    public void resetMaxPoolSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxPoolSize();
            return;
        }
        this.maxpoolsizeDirtyFlag = false;
        this.maxpoolsize = null;
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

    public void setMinPoolSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinPoolSize(n);
            return;
        }
        this.minpoolsize = n;
        this.minpoolsizeDirtyFlag = true;
    }

    public Integer getMinPoolSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinPoolSize();
        }
        return this.minpoolsize;
    }

    public boolean isMinPoolSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinPoolSizeDirty();
        }
        return this.minpoolsizeDirtyFlag;
    }

    public void resetMinPoolSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinPoolSize();
            return;
        }
        this.minpoolsizeDirtyFlag = false;
        this.minpoolsize = null;
    }

    public void setModelVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelVer(n);
            return;
        }
        this.modelver = n;
        this.modelverDirtyFlag = true;
    }

    public Integer getModelVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelVer();
        }
        return this.modelver;
    }

    public boolean isModelVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelVerDirty();
        }
        return this.modelverDirtyFlag;
    }

    public void resetModelVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelVer();
            return;
        }
        this.modelverDirtyFlag = false;
        this.modelver = null;
    }

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
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

    public void setPassWD(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPassWD(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.passwd = string;
        this.passwdDirtyFlag = true;
    }

    public String getPassWD() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPassWD();
        }
        return this.passwd;
    }

    public boolean isPassWDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPassWDDirty();
        }
        return this.passwdDirtyFlag;
    }

    public void resetPassWD() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPassWD();
            return;
        }
        this.passwdDirtyFlag = false;
        this.passwd = null;
    }

    public void setPatchNum(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPatchNum(n);
            return;
        }
        this.patchnum = n;
        this.patchnumDirtyFlag = true;
    }

    public Integer getPatchNum() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPatchNum();
        }
        return this.patchnum;
    }

    public boolean isPatchNumDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPatchNumDirty();
        }
        return this.patchnumDirtyFlag;
    }

    public void resetPatchNum() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPatchNum();
            return;
        }
        this.patchnumDirtyFlag = false;
        this.patchnum = null;
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

    public void setPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstid = string;
        this.pssysmodelinstidDirtyFlag = true;
    }

    public String getPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstId();
        }
        return this.pssysmodelinstid;
    }

    public boolean isPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstIdDirty();
        }
        return this.pssysmodelinstidDirtyFlag;
    }

    public void resetPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstId();
            return;
        }
        this.pssysmodelinstidDirtyFlag = false;
        this.pssysmodelinstid = null;
    }

    public void setPSSysModelInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstname = string;
        this.pssysmodelinstnameDirtyFlag = true;
    }

    public String getPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstName();
        }
        return this.pssysmodelinstname;
    }

    public boolean isPSSysModelInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstNameDirty();
        }
        return this.pssysmodelinstnameDirtyFlag;
    }

    public void resetPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstName();
            return;
        }
        this.pssysmodelinstnameDirtyFlag = false;
        this.pssysmodelinstname = null;
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

    public void setRowCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRowCnt(n);
            return;
        }
        this.rowcnt = n;
        this.rowcntDirtyFlag = true;
    }

    public Integer getRowCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRowCnt();
        }
        return this.rowcnt;
    }

    public boolean isRowCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRowCntDirty();
        }
        return this.rowcntDirtyFlag;
    }

    public void resetRowCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRowCnt();
            return;
        }
        this.rowcntDirtyFlag = false;
        this.rowcnt = null;
    }

    public void setShareFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShareFlag(n);
            return;
        }
        this.shareflag = n;
        this.shareflagDirtyFlag = true;
    }

    public Integer getShareFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShareFlag();
        }
        return this.shareflag;
    }

    public boolean isShareFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShareFlagDirty();
        }
        return this.shareflagDirtyFlag;
    }

    public void resetShareFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShareFlag();
            return;
        }
        this.shareflagDirtyFlag = false;
        this.shareflag = null;
    }

    public void setSysRowKey(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysRowKey(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysrowkey = string;
        this.sysrowkeyDirtyFlag = true;
    }

    public String getSysRowKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysRowKey();
        }
        return this.sysrowkey;
    }

    public boolean isSysRowKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysRowKeyDirty();
        }
        return this.sysrowkeyDirtyFlag;
    }

    public void resetSysRowKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysRowKey();
            return;
        }
        this.sysrowkeyDirtyFlag = false;
        this.sysrowkey = null;
    }

    public void setSysType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systype = string;
        this.systypeDirtyFlag = true;
    }

    public String getSysType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysType();
        }
        return this.systype;
    }

    public boolean isSysTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTypeDirty();
        }
        return this.systypeDirtyFlag;
    }

    public void resetSysType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysType();
            return;
        }
        this.systypeDirtyFlag = false;
        this.systype = null;
    }

    public void setTempPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTempPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.temppssysmodelinstid = string;
        this.temppssysmodelinstidDirtyFlag = true;
    }

    public String getTempPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTempPSSysModelInstId();
        }
        return this.temppssysmodelinstid;
    }

    public boolean isTempPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTempPSSysModelInstIdDirty();
        }
        return this.temppssysmodelinstidDirtyFlag;
    }

    public void resetTempPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTempPSSysModelInstId();
            return;
        }
        this.temppssysmodelinstidDirtyFlag = false;
        this.temppssysmodelinstid = null;
    }

    public void setTempPSSysModelInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTempPSSysModelInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.temppssysmodelinstname = string;
        this.temppssysmodelinstnameDirtyFlag = true;
    }

    public String getTempPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTempPSSysModelInstName();
        }
        return this.temppssysmodelinstname;
    }

    public boolean isTempPSSysModelInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTempPSSysModelInstNameDirty();
        }
        return this.temppssysmodelinstnameDirtyFlag;
    }

    public void resetTempPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTempPSSysModelInstName();
            return;
        }
        this.temppssysmodelinstnameDirtyFlag = false;
        this.temppssysmodelinstname = null;
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

    protected void onReset() {
        PSSysModelInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelInstBase pSSysModelInstBase) {
        pSSysModelInstBase.resetBeginCalcTime();
        pSSysModelInstBase.resetBeginMaintainTime();
        pSSysModelInstBase.resetConfPSSysModelInstId();
        pSSysModelInstBase.resetConfPSSysModelInstName();
        pSSysModelInstBase.resetConnStr();
        pSSysModelInstBase.resetCreateDate();
        pSSysModelInstBase.resetCreateMan();
        pSSysModelInstBase.resetCurDBAction();
        pSSysModelInstBase.resetDBName();
        pSSysModelInstBase.resetDBType();
        pSSysModelInstBase.resetEndCalcTime();
        pSSysModelInstBase.resetEndMaintainTime();
        pSSysModelInstBase.resetExpriedTime();
        pSSysModelInstBase.resetInitPoolSize();
        pSSysModelInstBase.resetInstGroup();
        pSSysModelInstBase.resetInstState();
        pSSysModelInstBase.resetMaxPoolSize();
        pSSysModelInstBase.resetMemo();
        pSSysModelInstBase.resetMinPoolSize();
        pSSysModelInstBase.resetModelVer();
        pSSysModelInstBase.resetOrderValue();
        pSSysModelInstBase.resetParam();
        pSSysModelInstBase.resetParam2();
        pSSysModelInstBase.resetParam3();
        pSSysModelInstBase.resetParam4();
        pSSysModelInstBase.resetParam5();
        pSSysModelInstBase.resetParam6();
        pSSysModelInstBase.resetParam7();
        pSSysModelInstBase.resetParam8();
        pSSysModelInstBase.resetPassWD();
        pSSysModelInstBase.resetPatchNum();
        pSSysModelInstBase.resetPSDBServerId();
        pSSysModelInstBase.resetPSDBServerName();
        pSSysModelInstBase.resetPSDevCenterId();
        pSSysModelInstBase.resetPSDevCenterName();
        pSSysModelInstBase.resetPSSvrDomainId();
        pSSysModelInstBase.resetPSSvrDomainName();
        pSSysModelInstBase.resetPSSysModelInstId();
        pSSysModelInstBase.resetPSSysModelInstName();
        pSSysModelInstBase.resetRefInfo();
        pSSysModelInstBase.resetRowCnt();
        pSSysModelInstBase.resetShareFlag();
        pSSysModelInstBase.resetSysRowKey();
        pSSysModelInstBase.resetSysType();
        pSSysModelInstBase.resetTempPSSysModelInstId();
        pSSysModelInstBase.resetTempPSSysModelInstName();
        pSSysModelInstBase.resetUpdateDate();
        pSSysModelInstBase.resetUpdateMan();
        pSSysModelInstBase.resetUsedSize();
        pSSysModelInstBase.resetUserName();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBeginCalcTimeDirty()) {
            hashMap.put(FIELD_BEGINCALCTIME, this.getBeginCalcTime());
        }
        if (!bl || this.isBeginMaintainTimeDirty()) {
            hashMap.put(FIELD_BEGINMAINTAINTIME, this.getBeginMaintainTime());
        }
        if (!bl || this.isConfPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_CONFPSSYSMODELINSTID, this.getConfPSSysModelInstId());
        }
        if (!bl || this.isConfPSSysModelInstNameDirty()) {
            hashMap.put(FIELD_CONFPSSYSMODELINSTNAME, this.getConfPSSysModelInstName());
        }
        if (!bl || this.isConnStrDirty()) {
            hashMap.put(FIELD_CONNSTR, this.getConnStr());
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
        if (!bl || this.isDBTypeDirty()) {
            hashMap.put(FIELD_DBTYPE, this.getDBType());
        }
        if (!bl || this.isEndCalcTimeDirty()) {
            hashMap.put(FIELD_ENDCALCTIME, this.getEndCalcTime());
        }
        if (!bl || this.isEndMaintainTimeDirty()) {
            hashMap.put(FIELD_ENDMAINTAINTIME, this.getEndMaintainTime());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isInitPoolSizeDirty()) {
            hashMap.put(FIELD_INITPOOLSIZE, this.getInitPoolSize());
        }
        if (!bl || this.isInstGroupDirty()) {
            hashMap.put(FIELD_INSTGROUP, this.getInstGroup());
        }
        if (!bl || this.isInstStateDirty()) {
            hashMap.put(FIELD_INSTSTATE, this.getInstState());
        }
        if (!bl || this.isMaxPoolSizeDirty()) {
            hashMap.put(FIELD_MAXPOOLSIZE, this.getMaxPoolSize());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinPoolSizeDirty()) {
            hashMap.put(FIELD_MINPOOLSIZE, this.getMinPoolSize());
        }
        if (!bl || this.isModelVerDirty()) {
            hashMap.put(FIELD_MODELVER, this.getModelVer());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
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
        if (!bl || this.isPassWDDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPassWD());
        }
        if (!bl || this.isPatchNumDirty()) {
            hashMap.put(FIELD_PATCHNUM, this.getPatchNum());
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
        if (!bl || this.isPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTID, this.getPSSysModelInstId());
        }
        if (!bl || this.isPSSysModelInstNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTNAME, this.getPSSysModelInstName());
        }
        if (!bl || this.isRefInfoDirty()) {
            hashMap.put(FIELD_REFINFO, this.getRefInfo());
        }
        if (!bl || this.isRowCntDirty()) {
            hashMap.put(FIELD_ROWCNT, this.getRowCnt());
        }
        if (!bl || this.isShareFlagDirty()) {
            hashMap.put(FIELD_SHAREFLAG, this.getShareFlag());
        }
        if (!bl || this.isSysRowKeyDirty()) {
            hashMap.put(FIELD_SYSROWKEY, this.getSysRowKey());
        }
        if (!bl || this.isSysTypeDirty()) {
            hashMap.put(FIELD_SYSTYPE, this.getSysType());
        }
        if (!bl || this.isTempPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_TEMPPSSYSMODELINSTID, this.getTempPSSysModelInstId());
        }
        if (!bl || this.isTempPSSysModelInstNameDirty()) {
            hashMap.put(FIELD_TEMPPSSYSMODELINSTNAME, this.getTempPSSysModelInstName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsedSizeDirty()) {
            hashMap.put(FIELD_USEDSIZE, this.getUsedSize());
        }
        if (!bl || this.isUserNameDirty()) {
            hashMap.put(FIELD_USERNAME, this.getUserName());
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
        return PSSysModelInstBase.get(this, n);
    }

    private static Object get(PSSysModelInstBase pSSysModelInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelInstBase.getBeginCalcTime();
            }
            case 1: {
                return pSSysModelInstBase.getBeginMaintainTime();
            }
            case 2: {
                return pSSysModelInstBase.getConfPSSysModelInstId();
            }
            case 3: {
                return pSSysModelInstBase.getConfPSSysModelInstName();
            }
            case 4: {
                return pSSysModelInstBase.getConnStr();
            }
            case 5: {
                return pSSysModelInstBase.getCreateDate();
            }
            case 6: {
                return pSSysModelInstBase.getCreateMan();
            }
            case 7: {
                return pSSysModelInstBase.getCurDBAction();
            }
            case 8: {
                return pSSysModelInstBase.getDBName();
            }
            case 9: {
                return pSSysModelInstBase.getDBType();
            }
            case 10: {
                return pSSysModelInstBase.getEndCalcTime();
            }
            case 11: {
                return pSSysModelInstBase.getEndMaintainTime();
            }
            case 12: {
                return pSSysModelInstBase.getExpriedTime();
            }
            case 13: {
                return pSSysModelInstBase.getInitPoolSize();
            }
            case 14: {
                return pSSysModelInstBase.getInstGroup();
            }
            case 15: {
                return pSSysModelInstBase.getInstState();
            }
            case 16: {
                return pSSysModelInstBase.getMaxPoolSize();
            }
            case 17: {
                return pSSysModelInstBase.getMemo();
            }
            case 18: {
                return pSSysModelInstBase.getMinPoolSize();
            }
            case 19: {
                return pSSysModelInstBase.getModelVer();
            }
            case 20: {
                return pSSysModelInstBase.getOrderValue();
            }
            case 21: {
                return pSSysModelInstBase.getParam();
            }
            case 22: {
                return pSSysModelInstBase.getParam2();
            }
            case 23: {
                return pSSysModelInstBase.getParam3();
            }
            case 24: {
                return pSSysModelInstBase.getParam4();
            }
            case 25: {
                return pSSysModelInstBase.getParam5();
            }
            case 26: {
                return pSSysModelInstBase.getParam6();
            }
            case 27: {
                return pSSysModelInstBase.getParam7();
            }
            case 28: {
                return pSSysModelInstBase.getParam8();
            }
            case 29: {
                return pSSysModelInstBase.getPassWD();
            }
            case 30: {
                return pSSysModelInstBase.getPatchNum();
            }
            case 31: {
                return pSSysModelInstBase.getPSDBServerId();
            }
            case 32: {
                return pSSysModelInstBase.getPSDBServerName();
            }
            case 33: {
                return pSSysModelInstBase.getPSDevCenterId();
            }
            case 34: {
                return pSSysModelInstBase.getPSDevCenterName();
            }
            case 35: {
                return pSSysModelInstBase.getPSSvrDomainId();
            }
            case 36: {
                return pSSysModelInstBase.getPSSvrDomainName();
            }
            case 37: {
                return pSSysModelInstBase.getPSSysModelInstId();
            }
            case 38: {
                return pSSysModelInstBase.getPSSysModelInstName();
            }
            case 39: {
                return pSSysModelInstBase.getRefInfo();
            }
            case 40: {
                return pSSysModelInstBase.getRowCnt();
            }
            case 41: {
                return pSSysModelInstBase.getShareFlag();
            }
            case 42: {
                return pSSysModelInstBase.getSysRowKey();
            }
            case 43: {
                return pSSysModelInstBase.getSysType();
            }
            case 44: {
                return pSSysModelInstBase.getTempPSSysModelInstId();
            }
            case 45: {
                return pSSysModelInstBase.getTempPSSysModelInstName();
            }
            case 46: {
                return pSSysModelInstBase.getUpdateDate();
            }
            case 47: {
                return pSSysModelInstBase.getUpdateMan();
            }
            case 48: {
                return pSSysModelInstBase.getUsedSize();
            }
            case 49: {
                return pSSysModelInstBase.getUserName();
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
        PSSysModelInstBase.set(this, n, object);
    }

    private static void set(PSSysModelInstBase pSSysModelInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelInstBase.setBeginCalcTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelInstBase.setBeginMaintainTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelInstBase.setConfPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelInstBase.setConfPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelInstBase.setConnStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelInstBase.setCurDBAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelInstBase.setDBName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelInstBase.setDBType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysModelInstBase.setEndCalcTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysModelInstBase.setEndMaintainTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSysModelInstBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSysModelInstBase.setInitPoolSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysModelInstBase.setInstGroup(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysModelInstBase.setInstState(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysModelInstBase.setMaxPoolSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSysModelInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysModelInstBase.setMinPoolSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSSysModelInstBase.setModelVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSSysModelInstBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSSysModelInstBase.setParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysModelInstBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysModelInstBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysModelInstBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysModelInstBase.setParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSSysModelInstBase.setParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSSysModelInstBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSSysModelInstBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSSysModelInstBase.setPassWD(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysModelInstBase.setPatchNum(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSSysModelInstBase.setPSDBServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysModelInstBase.setPSDBServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysModelInstBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysModelInstBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysModelInstBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysModelInstBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysModelInstBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysModelInstBase.setPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysModelInstBase.setRefInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysModelInstBase.setRowCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 41: {
                pSSysModelInstBase.setShareFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSSysModelInstBase.setSysRowKey(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysModelInstBase.setSysType(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysModelInstBase.setTempPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysModelInstBase.setTempPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysModelInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 47: {
                pSSysModelInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysModelInstBase.setUsedSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 49: {
                pSSysModelInstBase.setUserName(DataObject.getStringValue((Object)object));
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
        return PSSysModelInstBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelInstBase pSSysModelInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelInstBase.getBeginCalcTime() == null;
            }
            case 1: {
                return pSSysModelInstBase.getBeginMaintainTime() == null;
            }
            case 2: {
                return pSSysModelInstBase.getConfPSSysModelInstId() == null;
            }
            case 3: {
                return pSSysModelInstBase.getConfPSSysModelInstName() == null;
            }
            case 4: {
                return pSSysModelInstBase.getConnStr() == null;
            }
            case 5: {
                return pSSysModelInstBase.getCreateDate() == null;
            }
            case 6: {
                return pSSysModelInstBase.getCreateMan() == null;
            }
            case 7: {
                return pSSysModelInstBase.getCurDBAction() == null;
            }
            case 8: {
                return pSSysModelInstBase.getDBName() == null;
            }
            case 9: {
                return pSSysModelInstBase.getDBType() == null;
            }
            case 10: {
                return pSSysModelInstBase.getEndCalcTime() == null;
            }
            case 11: {
                return pSSysModelInstBase.getEndMaintainTime() == null;
            }
            case 12: {
                return pSSysModelInstBase.getExpriedTime() == null;
            }
            case 13: {
                return pSSysModelInstBase.getInitPoolSize() == null;
            }
            case 14: {
                return pSSysModelInstBase.getInstGroup() == null;
            }
            case 15: {
                return pSSysModelInstBase.getInstState() == null;
            }
            case 16: {
                return pSSysModelInstBase.getMaxPoolSize() == null;
            }
            case 17: {
                return pSSysModelInstBase.getMemo() == null;
            }
            case 18: {
                return pSSysModelInstBase.getMinPoolSize() == null;
            }
            case 19: {
                return pSSysModelInstBase.getModelVer() == null;
            }
            case 20: {
                return pSSysModelInstBase.getOrderValue() == null;
            }
            case 21: {
                return pSSysModelInstBase.getParam() == null;
            }
            case 22: {
                return pSSysModelInstBase.getParam2() == null;
            }
            case 23: {
                return pSSysModelInstBase.getParam3() == null;
            }
            case 24: {
                return pSSysModelInstBase.getParam4() == null;
            }
            case 25: {
                return pSSysModelInstBase.getParam5() == null;
            }
            case 26: {
                return pSSysModelInstBase.getParam6() == null;
            }
            case 27: {
                return pSSysModelInstBase.getParam7() == null;
            }
            case 28: {
                return pSSysModelInstBase.getParam8() == null;
            }
            case 29: {
                return pSSysModelInstBase.getPassWD() == null;
            }
            case 30: {
                return pSSysModelInstBase.getPatchNum() == null;
            }
            case 31: {
                return pSSysModelInstBase.getPSDBServerId() == null;
            }
            case 32: {
                return pSSysModelInstBase.getPSDBServerName() == null;
            }
            case 33: {
                return pSSysModelInstBase.getPSDevCenterId() == null;
            }
            case 34: {
                return pSSysModelInstBase.getPSDevCenterName() == null;
            }
            case 35: {
                return pSSysModelInstBase.getPSSvrDomainId() == null;
            }
            case 36: {
                return pSSysModelInstBase.getPSSvrDomainName() == null;
            }
            case 37: {
                return pSSysModelInstBase.getPSSysModelInstId() == null;
            }
            case 38: {
                return pSSysModelInstBase.getPSSysModelInstName() == null;
            }
            case 39: {
                return pSSysModelInstBase.getRefInfo() == null;
            }
            case 40: {
                return pSSysModelInstBase.getRowCnt() == null;
            }
            case 41: {
                return pSSysModelInstBase.getShareFlag() == null;
            }
            case 42: {
                return pSSysModelInstBase.getSysRowKey() == null;
            }
            case 43: {
                return pSSysModelInstBase.getSysType() == null;
            }
            case 44: {
                return pSSysModelInstBase.getTempPSSysModelInstId() == null;
            }
            case 45: {
                return pSSysModelInstBase.getTempPSSysModelInstName() == null;
            }
            case 46: {
                return pSSysModelInstBase.getUpdateDate() == null;
            }
            case 47: {
                return pSSysModelInstBase.getUpdateMan() == null;
            }
            case 48: {
                return pSSysModelInstBase.getUsedSize() == null;
            }
            case 49: {
                return pSSysModelInstBase.getUserName() == null;
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
        return PSSysModelInstBase.contains(this, n);
    }

    private static boolean contains(PSSysModelInstBase pSSysModelInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelInstBase.isBeginCalcTimeDirty();
            }
            case 1: {
                return pSSysModelInstBase.isBeginMaintainTimeDirty();
            }
            case 2: {
                return pSSysModelInstBase.isConfPSSysModelInstIdDirty();
            }
            case 3: {
                return pSSysModelInstBase.isConfPSSysModelInstNameDirty();
            }
            case 4: {
                return pSSysModelInstBase.isConnStrDirty();
            }
            case 5: {
                return pSSysModelInstBase.isCreateDateDirty();
            }
            case 6: {
                return pSSysModelInstBase.isCreateManDirty();
            }
            case 7: {
                return pSSysModelInstBase.isCurDBActionDirty();
            }
            case 8: {
                return pSSysModelInstBase.isDBNameDirty();
            }
            case 9: {
                return pSSysModelInstBase.isDBTypeDirty();
            }
            case 10: {
                return pSSysModelInstBase.isEndCalcTimeDirty();
            }
            case 11: {
                return pSSysModelInstBase.isEndMaintainTimeDirty();
            }
            case 12: {
                return pSSysModelInstBase.isExpriedTimeDirty();
            }
            case 13: {
                return pSSysModelInstBase.isInitPoolSizeDirty();
            }
            case 14: {
                return pSSysModelInstBase.isInstGroupDirty();
            }
            case 15: {
                return pSSysModelInstBase.isInstStateDirty();
            }
            case 16: {
                return pSSysModelInstBase.isMaxPoolSizeDirty();
            }
            case 17: {
                return pSSysModelInstBase.isMemoDirty();
            }
            case 18: {
                return pSSysModelInstBase.isMinPoolSizeDirty();
            }
            case 19: {
                return pSSysModelInstBase.isModelVerDirty();
            }
            case 20: {
                return pSSysModelInstBase.isOrderValueDirty();
            }
            case 21: {
                return pSSysModelInstBase.isParamDirty();
            }
            case 22: {
                return pSSysModelInstBase.isParam2Dirty();
            }
            case 23: {
                return pSSysModelInstBase.isParam3Dirty();
            }
            case 24: {
                return pSSysModelInstBase.isParam4Dirty();
            }
            case 25: {
                return pSSysModelInstBase.isParam5Dirty();
            }
            case 26: {
                return pSSysModelInstBase.isParam6Dirty();
            }
            case 27: {
                return pSSysModelInstBase.isParam7Dirty();
            }
            case 28: {
                return pSSysModelInstBase.isParam8Dirty();
            }
            case 29: {
                return pSSysModelInstBase.isPassWDDirty();
            }
            case 30: {
                return pSSysModelInstBase.isPatchNumDirty();
            }
            case 31: {
                return pSSysModelInstBase.isPSDBServerIdDirty();
            }
            case 32: {
                return pSSysModelInstBase.isPSDBServerNameDirty();
            }
            case 33: {
                return pSSysModelInstBase.isPSDevCenterIdDirty();
            }
            case 34: {
                return pSSysModelInstBase.isPSDevCenterNameDirty();
            }
            case 35: {
                return pSSysModelInstBase.isPSSvrDomainIdDirty();
            }
            case 36: {
                return pSSysModelInstBase.isPSSvrDomainNameDirty();
            }
            case 37: {
                return pSSysModelInstBase.isPSSysModelInstIdDirty();
            }
            case 38: {
                return pSSysModelInstBase.isPSSysModelInstNameDirty();
            }
            case 39: {
                return pSSysModelInstBase.isRefInfoDirty();
            }
            case 40: {
                return pSSysModelInstBase.isRowCntDirty();
            }
            case 41: {
                return pSSysModelInstBase.isShareFlagDirty();
            }
            case 42: {
                return pSSysModelInstBase.isSysRowKeyDirty();
            }
            case 43: {
                return pSSysModelInstBase.isSysTypeDirty();
            }
            case 44: {
                return pSSysModelInstBase.isTempPSSysModelInstIdDirty();
            }
            case 45: {
                return pSSysModelInstBase.isTempPSSysModelInstNameDirty();
            }
            case 46: {
                return pSSysModelInstBase.isUpdateDateDirty();
            }
            case 47: {
                return pSSysModelInstBase.isUpdateManDirty();
            }
            case 48: {
                return pSSysModelInstBase.isUsedSizeDirty();
            }
            case 49: {
                return pSSysModelInstBase.isUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelInstBase pSSysModelInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelInstBase.getBeginCalcTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begincalctime", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getBeginCalcTime()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getBeginMaintainTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beginmaintaintime", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getBeginMaintainTime()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getConfPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"confpssysmodelinstid", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getConfPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getConfPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"confpssysmodelinstname", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getConfPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getConnStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"connstr", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getConnStr()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getCurDBAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curdbaction", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getCurDBAction()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getDBName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbname", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getDBName()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getDBType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtype", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getDBType()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getEndCalcTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endcalctime", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getEndCalcTime()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getEndMaintainTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endmaintaintime", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getEndMaintainTime()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getInitPoolSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initpoolsize", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getInitPoolSize()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getInstGroup() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"instgroup", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getInstGroup()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getInstState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inststate", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getInstState()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getMaxPoolSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxpoolsize", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getMaxPoolSize()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getMinPoolSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minpoolsize", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getMinPoolSize()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getModelVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelver", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getModelVer()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getParam()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getParam2()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getParam3()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getParam4()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getParam5()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getParam6()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getParam7()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getParam8()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getPassWD() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getPassWD()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getPatchNum() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"patchnum", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getPatchNum()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getPSDBServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbserverid", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getPSDBServerId()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getPSDBServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbservername", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getPSDBServerName()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstname", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getRefInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refinfo", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getRefInfo()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getRowCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rowcnt", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getRowCnt()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getShareFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shareflag", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getShareFlag()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getSysRowKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysrowkey", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getSysRowKey()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getSysType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systype", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getSysType()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getTempPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"temppssysmodelinstid", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getTempPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getTempPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"temppssysmodelinstname", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getTempPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getUsedSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usedsize", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getUsedSize()), (boolean)false);
        }
        if (bl || pSSysModelInstBase.getUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"username", (Object)PSSysModelInstBase.getJSONValue((Object)pSSysModelInstBase.getUserName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelInstBase pSSysModelInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelInstBase.getBeginCalcTime() != null) {
            object = pSSysModelInstBase.getBeginCalcTime();
            xmlNode.setAttribute(FIELD_BEGINCALCTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelInstBase.getBeginMaintainTime() != null) {
            object = pSSysModelInstBase.getBeginMaintainTime();
            xmlNode.setAttribute(FIELD_BEGINMAINTAINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelInstBase.getConfPSSysModelInstId() != null) {
            object = pSSysModelInstBase.getConfPSSysModelInstId();
            xmlNode.setAttribute(FIELD_CONFPSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getConfPSSysModelInstName() != null) {
            object = pSSysModelInstBase.getConfPSSysModelInstName();
            xmlNode.setAttribute(FIELD_CONFPSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getConnStr() != null) {
            object = pSSysModelInstBase.getConnStr();
            xmlNode.setAttribute(FIELD_CONNSTR, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getCreateDate() != null) {
            object = pSSysModelInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelInstBase.getCreateMan() != null) {
            object = pSSysModelInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getCurDBAction() != null) {
            object = pSSysModelInstBase.getCurDBAction();
            xmlNode.setAttribute(FIELD_CURDBACTION, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getDBName() != null) {
            object = pSSysModelInstBase.getDBName();
            xmlNode.setAttribute(FIELD_DBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getDBType() != null) {
            object = pSSysModelInstBase.getDBType();
            xmlNode.setAttribute(FIELD_DBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getEndCalcTime() != null) {
            object = pSSysModelInstBase.getEndCalcTime();
            xmlNode.setAttribute(FIELD_ENDCALCTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelInstBase.getEndMaintainTime() != null) {
            object = pSSysModelInstBase.getEndMaintainTime();
            xmlNode.setAttribute(FIELD_ENDMAINTAINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelInstBase.getExpriedTime() != null) {
            object = pSSysModelInstBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelInstBase.getInitPoolSize() != null) {
            object = pSSysModelInstBase.getInitPoolSize();
            xmlNode.setAttribute(FIELD_INITPOOLSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstBase.getInstGroup() != null) {
            object = pSSysModelInstBase.getInstGroup();
            xmlNode.setAttribute(FIELD_INSTGROUP, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getInstState() != null) {
            object = pSSysModelInstBase.getInstState();
            xmlNode.setAttribute(FIELD_INSTSTATE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getMaxPoolSize() != null) {
            object = pSSysModelInstBase.getMaxPoolSize();
            xmlNode.setAttribute(FIELD_MAXPOOLSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstBase.getMemo() != null) {
            object = pSSysModelInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getMinPoolSize() != null) {
            object = pSSysModelInstBase.getMinPoolSize();
            xmlNode.setAttribute(FIELD_MINPOOLSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstBase.getModelVer() != null) {
            object = pSSysModelInstBase.getModelVer();
            xmlNode.setAttribute(FIELD_MODELVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstBase.getOrderValue() != null) {
            object = pSSysModelInstBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstBase.getParam() != null) {
            object = pSSysModelInstBase.getParam();
            xmlNode.setAttribute(FIELD_PARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getParam2() != null) {
            object = pSSysModelInstBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getParam3() != null) {
            object = pSSysModelInstBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getParam4() != null) {
            object = pSSysModelInstBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getParam5() != null) {
            object = pSSysModelInstBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstBase.getParam6() != null) {
            object = pSSysModelInstBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstBase.getParam7() != null) {
            object = pSSysModelInstBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstBase.getParam8() != null) {
            object = pSSysModelInstBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstBase.getPassWD() != null) {
            object = pSSysModelInstBase.getPassWD();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getPatchNum() != null) {
            object = pSSysModelInstBase.getPatchNum();
            xmlNode.setAttribute(FIELD_PATCHNUM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstBase.getPSDBServerId() != null) {
            object = pSSysModelInstBase.getPSDBServerId();
            xmlNode.setAttribute(FIELD_PSDBSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getPSDBServerName() != null) {
            object = pSSysModelInstBase.getPSDBServerName();
            xmlNode.setAttribute(FIELD_PSDBSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getPSDevCenterId() != null) {
            object = pSSysModelInstBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getPSDevCenterName() != null) {
            object = pSSysModelInstBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getPSSvrDomainId() != null) {
            object = pSSysModelInstBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getPSSvrDomainName() != null) {
            object = pSSysModelInstBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getPSSysModelInstId() != null) {
            object = pSSysModelInstBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getPSSysModelInstName() != null) {
            object = pSSysModelInstBase.getPSSysModelInstName();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getRefInfo() != null) {
            object = pSSysModelInstBase.getRefInfo();
            xmlNode.setAttribute(FIELD_REFINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getRowCnt() != null) {
            object = pSSysModelInstBase.getRowCnt();
            xmlNode.setAttribute(FIELD_ROWCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstBase.getShareFlag() != null) {
            object = pSSysModelInstBase.getShareFlag();
            xmlNode.setAttribute(FIELD_SHAREFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstBase.getSysRowKey() != null) {
            object = pSSysModelInstBase.getSysRowKey();
            xmlNode.setAttribute(FIELD_SYSROWKEY, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getSysType() != null) {
            object = pSSysModelInstBase.getSysType();
            xmlNode.setAttribute(FIELD_SYSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getTempPSSysModelInstId() != null) {
            object = pSSysModelInstBase.getTempPSSysModelInstId();
            xmlNode.setAttribute(FIELD_TEMPPSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getTempPSSysModelInstName() != null) {
            object = pSSysModelInstBase.getTempPSSysModelInstName();
            xmlNode.setAttribute(FIELD_TEMPPSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getUpdateDate() != null) {
            object = pSSysModelInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelInstBase.getUpdateMan() != null) {
            object = pSSysModelInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBase.getUsedSize() != null) {
            object = pSSysModelInstBase.getUsedSize();
            xmlNode.setAttribute(FIELD_USEDSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstBase.getUserName() != null) {
            object = pSSysModelInstBase.getUserName();
            xmlNode.setAttribute(FIELD_USERNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelInstBase pSSysModelInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelInstBase.isBeginCalcTimeDirty() && (bl || pSSysModelInstBase.getBeginCalcTime() != null)) {
            iDataObject.set(FIELD_BEGINCALCTIME, (Object)pSSysModelInstBase.getBeginCalcTime());
        }
        if (pSSysModelInstBase.isBeginMaintainTimeDirty() && (bl || pSSysModelInstBase.getBeginMaintainTime() != null)) {
            iDataObject.set(FIELD_BEGINMAINTAINTIME, (Object)pSSysModelInstBase.getBeginMaintainTime());
        }
        if (pSSysModelInstBase.isConfPSSysModelInstIdDirty() && (bl || pSSysModelInstBase.getConfPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_CONFPSSYSMODELINSTID, (Object)pSSysModelInstBase.getConfPSSysModelInstId());
        }
        if (pSSysModelInstBase.isConfPSSysModelInstNameDirty() && (bl || pSSysModelInstBase.getConfPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_CONFPSSYSMODELINSTNAME, (Object)pSSysModelInstBase.getConfPSSysModelInstName());
        }
        if (pSSysModelInstBase.isConnStrDirty() && (bl || pSSysModelInstBase.getConnStr() != null)) {
            iDataObject.set(FIELD_CONNSTR, (Object)pSSysModelInstBase.getConnStr());
        }
        if (pSSysModelInstBase.isCreateDateDirty() && (bl || pSSysModelInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelInstBase.getCreateDate());
        }
        if (pSSysModelInstBase.isCreateManDirty() && (bl || pSSysModelInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelInstBase.getCreateMan());
        }
        if (pSSysModelInstBase.isCurDBActionDirty() && (bl || pSSysModelInstBase.getCurDBAction() != null)) {
            iDataObject.set(FIELD_CURDBACTION, (Object)pSSysModelInstBase.getCurDBAction());
        }
        if (pSSysModelInstBase.isDBNameDirty() && (bl || pSSysModelInstBase.getDBName() != null)) {
            iDataObject.set(FIELD_DBNAME, (Object)pSSysModelInstBase.getDBName());
        }
        if (pSSysModelInstBase.isDBTypeDirty() && (bl || pSSysModelInstBase.getDBType() != null)) {
            iDataObject.set(FIELD_DBTYPE, (Object)pSSysModelInstBase.getDBType());
        }
        if (pSSysModelInstBase.isEndCalcTimeDirty() && (bl || pSSysModelInstBase.getEndCalcTime() != null)) {
            iDataObject.set(FIELD_ENDCALCTIME, (Object)pSSysModelInstBase.getEndCalcTime());
        }
        if (pSSysModelInstBase.isEndMaintainTimeDirty() && (bl || pSSysModelInstBase.getEndMaintainTime() != null)) {
            iDataObject.set(FIELD_ENDMAINTAINTIME, (Object)pSSysModelInstBase.getEndMaintainTime());
        }
        if (pSSysModelInstBase.isExpriedTimeDirty() && (bl || pSSysModelInstBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSSysModelInstBase.getExpriedTime());
        }
        if (pSSysModelInstBase.isInitPoolSizeDirty() && (bl || pSSysModelInstBase.getInitPoolSize() != null)) {
            iDataObject.set(FIELD_INITPOOLSIZE, (Object)pSSysModelInstBase.getInitPoolSize());
        }
        if (pSSysModelInstBase.isInstGroupDirty() && (bl || pSSysModelInstBase.getInstGroup() != null)) {
            iDataObject.set(FIELD_INSTGROUP, (Object)pSSysModelInstBase.getInstGroup());
        }
        if (pSSysModelInstBase.isInstStateDirty() && (bl || pSSysModelInstBase.getInstState() != null)) {
            iDataObject.set(FIELD_INSTSTATE, (Object)pSSysModelInstBase.getInstState());
        }
        if (pSSysModelInstBase.isMaxPoolSizeDirty() && (bl || pSSysModelInstBase.getMaxPoolSize() != null)) {
            iDataObject.set(FIELD_MAXPOOLSIZE, (Object)pSSysModelInstBase.getMaxPoolSize());
        }
        if (pSSysModelInstBase.isMemoDirty() && (bl || pSSysModelInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysModelInstBase.getMemo());
        }
        if (pSSysModelInstBase.isMinPoolSizeDirty() && (bl || pSSysModelInstBase.getMinPoolSize() != null)) {
            iDataObject.set(FIELD_MINPOOLSIZE, (Object)pSSysModelInstBase.getMinPoolSize());
        }
        if (pSSysModelInstBase.isModelVerDirty() && (bl || pSSysModelInstBase.getModelVer() != null)) {
            iDataObject.set(FIELD_MODELVER, (Object)pSSysModelInstBase.getModelVer());
        }
        if (pSSysModelInstBase.isOrderValueDirty() && (bl || pSSysModelInstBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysModelInstBase.getOrderValue());
        }
        if (pSSysModelInstBase.isParamDirty() && (bl || pSSysModelInstBase.getParam() != null)) {
            iDataObject.set(FIELD_PARAM, (Object)pSSysModelInstBase.getParam());
        }
        if (pSSysModelInstBase.isParam2Dirty() && (bl || pSSysModelInstBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSSysModelInstBase.getParam2());
        }
        if (pSSysModelInstBase.isParam3Dirty() && (bl || pSSysModelInstBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSSysModelInstBase.getParam3());
        }
        if (pSSysModelInstBase.isParam4Dirty() && (bl || pSSysModelInstBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSSysModelInstBase.getParam4());
        }
        if (pSSysModelInstBase.isParam5Dirty() && (bl || pSSysModelInstBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSSysModelInstBase.getParam5());
        }
        if (pSSysModelInstBase.isParam6Dirty() && (bl || pSSysModelInstBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSSysModelInstBase.getParam6());
        }
        if (pSSysModelInstBase.isParam7Dirty() && (bl || pSSysModelInstBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSSysModelInstBase.getParam7());
        }
        if (pSSysModelInstBase.isParam8Dirty() && (bl || pSSysModelInstBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSSysModelInstBase.getParam8());
        }
        if (pSSysModelInstBase.isPassWDDirty() && (bl || pSSysModelInstBase.getPassWD() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSSysModelInstBase.getPassWD());
        }
        if (pSSysModelInstBase.isPatchNumDirty() && (bl || pSSysModelInstBase.getPatchNum() != null)) {
            iDataObject.set(FIELD_PATCHNUM, (Object)pSSysModelInstBase.getPatchNum());
        }
        if (pSSysModelInstBase.isPSDBServerIdDirty() && (bl || pSSysModelInstBase.getPSDBServerId() != null)) {
            iDataObject.set(FIELD_PSDBSERVERID, (Object)pSSysModelInstBase.getPSDBServerId());
        }
        if (pSSysModelInstBase.isPSDBServerNameDirty() && (bl || pSSysModelInstBase.getPSDBServerName() != null)) {
            iDataObject.set(FIELD_PSDBSERVERNAME, (Object)pSSysModelInstBase.getPSDBServerName());
        }
        if (pSSysModelInstBase.isPSDevCenterIdDirty() && (bl || pSSysModelInstBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSSysModelInstBase.getPSDevCenterId());
        }
        if (pSSysModelInstBase.isPSDevCenterNameDirty() && (bl || pSSysModelInstBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSSysModelInstBase.getPSDevCenterName());
        }
        if (pSSysModelInstBase.isPSSvrDomainIdDirty() && (bl || pSSysModelInstBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSSysModelInstBase.getPSSvrDomainId());
        }
        if (pSSysModelInstBase.isPSSvrDomainNameDirty() && (bl || pSSysModelInstBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSSysModelInstBase.getPSSvrDomainName());
        }
        if (pSSysModelInstBase.isPSSysModelInstIdDirty() && (bl || pSSysModelInstBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSSysModelInstBase.getPSSysModelInstId());
        }
        if (pSSysModelInstBase.isPSSysModelInstNameDirty() && (bl || pSSysModelInstBase.getPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTNAME, (Object)pSSysModelInstBase.getPSSysModelInstName());
        }
        if (pSSysModelInstBase.isRefInfoDirty() && (bl || pSSysModelInstBase.getRefInfo() != null)) {
            iDataObject.set(FIELD_REFINFO, (Object)pSSysModelInstBase.getRefInfo());
        }
        if (pSSysModelInstBase.isRowCntDirty() && (bl || pSSysModelInstBase.getRowCnt() != null)) {
            iDataObject.set(FIELD_ROWCNT, (Object)pSSysModelInstBase.getRowCnt());
        }
        if (pSSysModelInstBase.isShareFlagDirty() && (bl || pSSysModelInstBase.getShareFlag() != null)) {
            iDataObject.set(FIELD_SHAREFLAG, (Object)pSSysModelInstBase.getShareFlag());
        }
        if (pSSysModelInstBase.isSysRowKeyDirty() && (bl || pSSysModelInstBase.getSysRowKey() != null)) {
            iDataObject.set(FIELD_SYSROWKEY, (Object)pSSysModelInstBase.getSysRowKey());
        }
        if (pSSysModelInstBase.isSysTypeDirty() && (bl || pSSysModelInstBase.getSysType() != null)) {
            iDataObject.set(FIELD_SYSTYPE, (Object)pSSysModelInstBase.getSysType());
        }
        if (pSSysModelInstBase.isTempPSSysModelInstIdDirty() && (bl || pSSysModelInstBase.getTempPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_TEMPPSSYSMODELINSTID, (Object)pSSysModelInstBase.getTempPSSysModelInstId());
        }
        if (pSSysModelInstBase.isTempPSSysModelInstNameDirty() && (bl || pSSysModelInstBase.getTempPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_TEMPPSSYSMODELINSTNAME, (Object)pSSysModelInstBase.getTempPSSysModelInstName());
        }
        if (pSSysModelInstBase.isUpdateDateDirty() && (bl || pSSysModelInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelInstBase.getUpdateDate());
        }
        if (pSSysModelInstBase.isUpdateManDirty() && (bl || pSSysModelInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelInstBase.getUpdateMan());
        }
        if (pSSysModelInstBase.isUsedSizeDirty() && (bl || pSSysModelInstBase.getUsedSize() != null)) {
            iDataObject.set(FIELD_USEDSIZE, (Object)pSSysModelInstBase.getUsedSize());
        }
        if (pSSysModelInstBase.isUserNameDirty() && (bl || pSSysModelInstBase.getUserName() != null)) {
            iDataObject.set(FIELD_USERNAME, (Object)pSSysModelInstBase.getUserName());
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
        return PSSysModelInstBase.remove(this, n);
    }

    private static boolean remove(PSSysModelInstBase pSSysModelInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelInstBase.resetBeginCalcTime();
                return true;
            }
            case 1: {
                pSSysModelInstBase.resetBeginMaintainTime();
                return true;
            }
            case 2: {
                pSSysModelInstBase.resetConfPSSysModelInstId();
                return true;
            }
            case 3: {
                pSSysModelInstBase.resetConfPSSysModelInstName();
                return true;
            }
            case 4: {
                pSSysModelInstBase.resetConnStr();
                return true;
            }
            case 5: {
                pSSysModelInstBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSSysModelInstBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSSysModelInstBase.resetCurDBAction();
                return true;
            }
            case 8: {
                pSSysModelInstBase.resetDBName();
                return true;
            }
            case 9: {
                pSSysModelInstBase.resetDBType();
                return true;
            }
            case 10: {
                pSSysModelInstBase.resetEndCalcTime();
                return true;
            }
            case 11: {
                pSSysModelInstBase.resetEndMaintainTime();
                return true;
            }
            case 12: {
                pSSysModelInstBase.resetExpriedTime();
                return true;
            }
            case 13: {
                pSSysModelInstBase.resetInitPoolSize();
                return true;
            }
            case 14: {
                pSSysModelInstBase.resetInstGroup();
                return true;
            }
            case 15: {
                pSSysModelInstBase.resetInstState();
                return true;
            }
            case 16: {
                pSSysModelInstBase.resetMaxPoolSize();
                return true;
            }
            case 17: {
                pSSysModelInstBase.resetMemo();
                return true;
            }
            case 18: {
                pSSysModelInstBase.resetMinPoolSize();
                return true;
            }
            case 19: {
                pSSysModelInstBase.resetModelVer();
                return true;
            }
            case 20: {
                pSSysModelInstBase.resetOrderValue();
                return true;
            }
            case 21: {
                pSSysModelInstBase.resetParam();
                return true;
            }
            case 22: {
                pSSysModelInstBase.resetParam2();
                return true;
            }
            case 23: {
                pSSysModelInstBase.resetParam3();
                return true;
            }
            case 24: {
                pSSysModelInstBase.resetParam4();
                return true;
            }
            case 25: {
                pSSysModelInstBase.resetParam5();
                return true;
            }
            case 26: {
                pSSysModelInstBase.resetParam6();
                return true;
            }
            case 27: {
                pSSysModelInstBase.resetParam7();
                return true;
            }
            case 28: {
                pSSysModelInstBase.resetParam8();
                return true;
            }
            case 29: {
                pSSysModelInstBase.resetPassWD();
                return true;
            }
            case 30: {
                pSSysModelInstBase.resetPatchNum();
                return true;
            }
            case 31: {
                pSSysModelInstBase.resetPSDBServerId();
                return true;
            }
            case 32: {
                pSSysModelInstBase.resetPSDBServerName();
                return true;
            }
            case 33: {
                pSSysModelInstBase.resetPSDevCenterId();
                return true;
            }
            case 34: {
                pSSysModelInstBase.resetPSDevCenterName();
                return true;
            }
            case 35: {
                pSSysModelInstBase.resetPSSvrDomainId();
                return true;
            }
            case 36: {
                pSSysModelInstBase.resetPSSvrDomainName();
                return true;
            }
            case 37: {
                pSSysModelInstBase.resetPSSysModelInstId();
                return true;
            }
            case 38: {
                pSSysModelInstBase.resetPSSysModelInstName();
                return true;
            }
            case 39: {
                pSSysModelInstBase.resetRefInfo();
                return true;
            }
            case 40: {
                pSSysModelInstBase.resetRowCnt();
                return true;
            }
            case 41: {
                pSSysModelInstBase.resetShareFlag();
                return true;
            }
            case 42: {
                pSSysModelInstBase.resetSysRowKey();
                return true;
            }
            case 43: {
                pSSysModelInstBase.resetSysType();
                return true;
            }
            case 44: {
                pSSysModelInstBase.resetTempPSSysModelInstId();
                return true;
            }
            case 45: {
                pSSysModelInstBase.resetTempPSSysModelInstName();
                return true;
            }
            case 46: {
                pSSysModelInstBase.resetUpdateDate();
                return true;
            }
            case 47: {
                pSSysModelInstBase.resetUpdateMan();
                return true;
            }
            case 48: {
                pSSysModelInstBase.resetUsedSize();
                return true;
            }
            case 49: {
                pSSysModelInstBase.resetUserName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelInst getConfPSSysModelInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConfPSSysModelInst();
        }
        if (this.getConfPSSysModelInstId() == null) {
            return null;
        }
        Integer n = this.objConfPSSysModelInstLock;
        synchronized (n) {
            if (this.confpssysmodelinst != null && DataTypeHelper.compare((int)25, (Object)this.getConfPSSysModelInstId(), (Object)this.confpssysmodelinst.getPSSysModelInstId()) != 0L) {
                this.confpssysmodelinst = null;
            }
            if (this.confpssysmodelinst == null) {
                PSSysModelInst pSSysModelInst = new PSSysModelInst();
                pSSysModelInst.setPSSysModelInstId(this.getConfPSSysModelInstId());
                PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelInstService.autoGet((IEntity)pSSysModelInst);
                this.confpssysmodelinst = pSSysModelInst;
            }
            return this.confpssysmodelinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelInst getTempPSSysModelInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTempPSSysModelInst();
        }
        if (this.getTempPSSysModelInstId() == null) {
            return null;
        }
        Integer n = this.objTempPSSysModelInstLock;
        synchronized (n) {
            if (this.temppssysmodelinst != null && DataTypeHelper.compare((int)25, (Object)this.getTempPSSysModelInstId(), (Object)this.temppssysmodelinst.getPSSysModelInstId()) != 0L) {
                this.temppssysmodelinst = null;
            }
            if (this.temppssysmodelinst == null) {
                PSSysModelInst pSSysModelInst = new PSSysModelInst();
                pSSysModelInst.setPSSysModelInstId(this.getTempPSSysModelInstId());
                PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelInstService.autoGet((IEntity)pSSysModelInst);
                this.temppssysmodelinst = pSSysModelInst;
            }
            return this.temppssysmodelinst;
        }
    }

    private PSSysModelInstBase getProxyEntity() {
        return this.proxyPSSysModelInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelInstBase) {
            this.proxyPSSysModelInstBase = (PSSysModelInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINCALCTIME, 0);
        fieldIndexMap.put(FIELD_BEGINMAINTAINTIME, 1);
        fieldIndexMap.put(FIELD_CONFPSSYSMODELINSTID, 2);
        fieldIndexMap.put(FIELD_CONFPSSYSMODELINSTNAME, 3);
        fieldIndexMap.put(FIELD_CONNSTR, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_CURDBACTION, 7);
        fieldIndexMap.put(FIELD_DBNAME, 8);
        fieldIndexMap.put(FIELD_DBTYPE, 9);
        fieldIndexMap.put(FIELD_ENDCALCTIME, 10);
        fieldIndexMap.put(FIELD_ENDMAINTAINTIME, 11);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 12);
        fieldIndexMap.put(FIELD_INITPOOLSIZE, 13);
        fieldIndexMap.put(FIELD_INSTGROUP, 14);
        fieldIndexMap.put(FIELD_INSTSTATE, 15);
        fieldIndexMap.put(FIELD_MAXPOOLSIZE, 16);
        fieldIndexMap.put(FIELD_MEMO, 17);
        fieldIndexMap.put(FIELD_MINPOOLSIZE, 18);
        fieldIndexMap.put(FIELD_MODELVER, 19);
        fieldIndexMap.put(FIELD_ORDERVALUE, 20);
        fieldIndexMap.put(FIELD_PARAM, 21);
        fieldIndexMap.put(FIELD_PARAM2, 22);
        fieldIndexMap.put(FIELD_PARAM3, 23);
        fieldIndexMap.put(FIELD_PARAM4, 24);
        fieldIndexMap.put(FIELD_PARAM5, 25);
        fieldIndexMap.put(FIELD_PARAM6, 26);
        fieldIndexMap.put(FIELD_PARAM7, 27);
        fieldIndexMap.put(FIELD_PARAM8, 28);
        fieldIndexMap.put(FIELD_PASSWD, 29);
        fieldIndexMap.put(FIELD_PATCHNUM, 30);
        fieldIndexMap.put(FIELD_PSDBSERVERID, 31);
        fieldIndexMap.put(FIELD_PSDBSERVERNAME, 32);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 33);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 34);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 35);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 36);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 37);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTNAME, 38);
        fieldIndexMap.put(FIELD_REFINFO, 39);
        fieldIndexMap.put(FIELD_ROWCNT, 40);
        fieldIndexMap.put(FIELD_SHAREFLAG, 41);
        fieldIndexMap.put(FIELD_SYSROWKEY, 42);
        fieldIndexMap.put(FIELD_SYSTYPE, 43);
        fieldIndexMap.put(FIELD_TEMPPSSYSMODELINSTID, 44);
        fieldIndexMap.put(FIELD_TEMPPSSYSMODELINSTNAME, 45);
        fieldIndexMap.put(FIELD_UPDATEDATE, 46);
        fieldIndexMap.put(FIELD_UPDATEMAN, 47);
        fieldIndexMap.put(FIELD_USEDSIZE, 48);
        fieldIndexMap.put(FIELD_USERNAME, 49);
    }
}

