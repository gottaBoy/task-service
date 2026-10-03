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
package net.ibizsys.pscore.srv.systest.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleData;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.systest.entity.PSSysTDItem;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import net.ibizsys.pscore.srv.systest.service.PSSysTDItemService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTestDataBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysTestDataBase.class);
    public static final String FIELD_BASEMODE = "BASEMODE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MAINPSSYSTDID = "MAINPSSYSTDID";
    public static final String FIELD_MAINPSSYSTDNAME = "MAINPSSYSTDNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String FIELD_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDESAMPLEDATAID = "PSDESAMPLEDATAID";
    public static final String FIELD_PSDESAMPLEDATANAME = "PSDESAMPLEDATANAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSTESTDATAID = "PSSYSTESTDATAID";
    public static final String FIELD_PSSYSTESTDATANAME = "PSSYSTESTDATANAME";
    public static final String FIELD_RANDOMCOUNT = "RANDOMCOUNT";
    public static final String FIELD_TESTDATATAG = "TESTDATATAG";
    public static final String FIELD_TESTDATATAG2 = "TESTDATATAG2";
    public static final String FIELD_TESTDATATYPE = "TESTDATATYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USAGE = "USAGE";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERFLAG = "USERFLAG";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BASEMODE = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_CUSTOMCODE = 4;
    private static final int INDEX_DATA = 5;
    private static final int INDEX_LOCKFLAG = 6;
    private static final int INDEX_MAINPSSYSTDID = 7;
    private static final int INDEX_MAINPSSYSTDNAME = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_ORDERVALUE = 10;
    private static final int INDEX_PSDEID = 11;
    private static final int INDEX_PSDEMAINSTATEID = 12;
    private static final int INDEX_PSDEMAINSTATENAME = 13;
    private static final int INDEX_PSDENAME = 14;
    private static final int INDEX_PSDESAMPLEDATAID = 15;
    private static final int INDEX_PSDESAMPLEDATANAME = 16;
    private static final int INDEX_PSMODULEID = 17;
    private static final int INDEX_PSMODULENAME = 18;
    private static final int INDEX_PSSYSREQITEMID = 19;
    private static final int INDEX_PSSYSREQITEMNAME = 20;
    private static final int INDEX_PSSYSTEMID = 21;
    private static final int INDEX_PSSYSTEMNAME = 22;
    private static final int INDEX_PSSYSTESTDATAID = 23;
    private static final int INDEX_PSSYSTESTDATANAME = 24;
    private static final int INDEX_RANDOMCOUNT = 25;
    private static final int INDEX_TESTDATATAG = 26;
    private static final int INDEX_TESTDATATAG2 = 27;
    private static final int INDEX_TESTDATATYPE = 28;
    private static final int INDEX_UPDATEDATE = 29;
    private static final int INDEX_UPDATEMAN = 30;
    private static final int INDEX_USAGE = 31;
    private static final int INDEX_USERCAT = 32;
    private static final int INDEX_USERFLAG = 33;
    private static final int INDEX_USERTAG = 34;
    private static final int INDEX_USERTAG2 = 35;
    private static final int INDEX_USERTAG3 = 36;
    private static final int INDEX_USERTAG4 = 37;
    private static final int INDEX_VALIDFLAG = 38;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysTestDataBase proxyPSSysTestDataBase = null;
    private boolean basemodeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean mainpssystdidDirtyFlag = false;
    private boolean mainpssystdnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemainstateidDirtyFlag = false;
    private boolean psdemainstatenameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdesampledataidDirtyFlag = false;
    private boolean psdesampledatanameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssystestdataidDirtyFlag = false;
    private boolean pssystestdatanameDirtyFlag = false;
    private boolean randomcountDirtyFlag = false;
    private boolean testdatatagDirtyFlag = false;
    private boolean testdatatag2DirtyFlag = false;
    private boolean testdatatypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usageDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userflagDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="basemode")
    private Integer basemode;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="data")
    private String data;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="mainpssystdid")
    private String mainpssystdid;
    @Column(name="mainpssystdname")
    private String mainpssystdname;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemainstateid")
    private String psdemainstateid;
    @Column(name="psdemainstatename")
    private String psdemainstatename;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdesampledataid")
    private String psdesampledataid;
    @Column(name="psdesampledataname")
    private String psdesampledataname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssystestdataid")
    private String pssystestdataid;
    @Column(name="pssystestdataname")
    private String pssystestdataname;
    @Column(name="randomcount")
    private Integer randomcount;
    @Column(name="testdatatag")
    private String testdatatag;
    @Column(name="testdatatag2")
    private String testdatatag2;
    @Column(name="testdatatype")
    private String testdatatype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usage")
    private String usage;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userflag")
    private Integer userflag;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEMainStateLock = new Integer(1);
    private PSDEMainState psdemainstate = null;
    private Integer objPSDESampleDataLock = new Integer(1);
    private PSDESampleData psdesampledata = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objMainPSSysTDLock = new Integer(1);
    private PSSysTestData mainpssystd = null;
    private Integer objPSSysTDItemsLock = new Integer(1);
    private ArrayList<PSSysTDItem> pssystditems = null;

    public void setBaseMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseMode(n);
            return;
        }
        this.basemode = n;
        this.basemodeDirtyFlag = true;
    }

    public Integer getBaseMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseMode();
        }
        return this.basemode;
    }

    public boolean isBaseModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseModeDirty();
        }
        return this.basemodeDirtyFlag;
    }

    public void resetBaseMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseMode();
            return;
        }
        this.basemodeDirtyFlag = false;
        this.basemode = null;
    }

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data = string;
        this.dataDirtyFlag = true;
    }

    public String getData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData();
        }
        return this.data;
    }

    public boolean isDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataDirty();
        }
        return this.dataDirtyFlag;
    }

    public void resetData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData();
            return;
        }
        this.dataDirtyFlag = false;
        this.data = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
    }

    public void setMainPSSysTDId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainPSSysTDId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mainpssystdid = string;
        this.mainpssystdidDirtyFlag = true;
    }

    public String getMainPSSysTDId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainPSSysTDId();
        }
        return this.mainpssystdid;
    }

    public boolean isMainPSSysTDIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainPSSysTDIdDirty();
        }
        return this.mainpssystdidDirtyFlag;
    }

    public void resetMainPSSysTDId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainPSSysTDId();
            return;
        }
        this.mainpssystdidDirtyFlag = false;
        this.mainpssystdid = null;
    }

    public void setMainPSSysTDName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainPSSysTDName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mainpssystdname = string;
        this.mainpssystdnameDirtyFlag = true;
    }

    public String getMainPSSysTDName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainPSSysTDName();
        }
        return this.mainpssystdname;
    }

    public boolean isMainPSSysTDNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainPSSysTDNameDirty();
        }
        return this.mainpssystdnameDirtyFlag;
    }

    public void resetMainPSSysTDName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainPSSysTDName();
            return;
        }
        this.mainpssystdnameDirtyFlag = false;
        this.mainpssystdname = null;
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

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEMainStateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstateid = string;
        this.psdemainstateidDirtyFlag = true;
    }

    public String getPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateId();
        }
        return this.psdemainstateid;
    }

    public boolean isPSDEMainStateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateIdDirty();
        }
        return this.psdemainstateidDirtyFlag;
    }

    public void resetPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateId();
            return;
        }
        this.psdemainstateidDirtyFlag = false;
        this.psdemainstateid = null;
    }

    public void setPSDEMainStateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstatename = string;
        this.psdemainstatenameDirtyFlag = true;
    }

    public String getPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateName();
        }
        return this.psdemainstatename;
    }

    public boolean isPSDEMainStateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateNameDirty();
        }
        return this.psdemainstatenameDirtyFlag;
    }

    public void resetPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateName();
            return;
        }
        this.psdemainstatenameDirtyFlag = false;
        this.psdemainstatename = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSDESampleDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESampleDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesampledataid = string;
        this.psdesampledataidDirtyFlag = true;
    }

    public String getPSDESampleDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESampleDataId();
        }
        return this.psdesampledataid;
    }

    public boolean isPSDESampleDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESampleDataIdDirty();
        }
        return this.psdesampledataidDirtyFlag;
    }

    public void resetPSDESampleDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESampleDataId();
            return;
        }
        this.psdesampledataidDirtyFlag = false;
        this.psdesampledataid = null;
    }

    public void setPSDESampleDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESampleDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesampledataname = string;
        this.psdesampledatanameDirtyFlag = true;
    }

    public String getPSDESampleDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESampleDataName();
        }
        return this.psdesampledataname;
    }

    public boolean isPSDESampleDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESampleDataNameDirty();
        }
        return this.psdesampledatanameDirtyFlag;
    }

    public void resetPSDESampleDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESampleDataName();
            return;
        }
        this.psdesampledatanameDirtyFlag = false;
        this.psdesampledataname = null;
    }

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setPSSysTestDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestdataid = string;
        this.pssystestdataidDirtyFlag = true;
    }

    public String getPSSysTestDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestDataId();
        }
        return this.pssystestdataid;
    }

    public boolean isPSSysTestDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestDataIdDirty();
        }
        return this.pssystestdataidDirtyFlag;
    }

    public void resetPSSysTestDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestDataId();
            return;
        }
        this.pssystestdataidDirtyFlag = false;
        this.pssystestdataid = null;
    }

    public void setPSSysTestDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestdataname = string;
        this.pssystestdatanameDirtyFlag = true;
    }

    public String getPSSysTestDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestDataName();
        }
        return this.pssystestdataname;
    }

    public boolean isPSSysTestDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestDataNameDirty();
        }
        return this.pssystestdatanameDirtyFlag;
    }

    public void resetPSSysTestDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestDataName();
            return;
        }
        this.pssystestdatanameDirtyFlag = false;
        this.pssystestdataname = null;
    }

    public void setRandomCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRandomCount(n);
            return;
        }
        this.randomcount = n;
        this.randomcountDirtyFlag = true;
    }

    public Integer getRandomCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRandomCount();
        }
        return this.randomcount;
    }

    public boolean isRandomCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRandomCountDirty();
        }
        return this.randomcountDirtyFlag;
    }

    public void resetRandomCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRandomCount();
            return;
        }
        this.randomcountDirtyFlag = false;
        this.randomcount = null;
    }

    public void setTestDataTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestDataTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testdatatag = string;
        this.testdatatagDirtyFlag = true;
    }

    public String getTestDataTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestDataTag();
        }
        return this.testdatatag;
    }

    public boolean isTestDataTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestDataTagDirty();
        }
        return this.testdatatagDirtyFlag;
    }

    public void resetTestDataTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestDataTag();
            return;
        }
        this.testdatatagDirtyFlag = false;
        this.testdatatag = null;
    }

    public void setTestDataTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestDataTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testdatatag2 = string;
        this.testdatatag2DirtyFlag = true;
    }

    public String getTestDataTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestDataTag2();
        }
        return this.testdatatag2;
    }

    public boolean isTestDataTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestDataTag2Dirty();
        }
        return this.testdatatag2DirtyFlag;
    }

    public void resetTestDataTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestDataTag2();
            return;
        }
        this.testdatatag2DirtyFlag = false;
        this.testdatatag2 = null;
    }

    public void setTestDataType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestDataType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testdatatype = string;
        this.testdatatypeDirtyFlag = true;
    }

    public String getTestDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestDataType();
        }
        return this.testdatatype;
    }

    public boolean isTestDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestDataTypeDirty();
        }
        return this.testdatatypeDirtyFlag;
    }

    public void resetTestDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestDataType();
            return;
        }
        this.testdatatypeDirtyFlag = false;
        this.testdatatype = null;
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

    public void setUsage(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsage(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usage = string;
        this.usageDirtyFlag = true;
    }

    public String getUsage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsage();
        }
        return this.usage;
    }

    public boolean isUsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsageDirty();
        }
        return this.usageDirtyFlag;
    }

    public void resetUsage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsage();
            return;
        }
        this.usageDirtyFlag = false;
        this.usage = null;
    }

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserFlag(n);
            return;
        }
        this.userflag = n;
        this.userflagDirtyFlag = true;
    }

    public Integer getUserFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserFlag();
        }
        return this.userflag;
    }

    public boolean isUserFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserFlagDirty();
        }
        return this.userflagDirtyFlag;
    }

    public void resetUserFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserFlag();
            return;
        }
        this.userflagDirtyFlag = false;
        this.userflag = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSSysTestDataBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysTestDataBase pSSysTestDataBase) {
        pSSysTestDataBase.resetBaseMode();
        pSSysTestDataBase.resetCodeName();
        pSSysTestDataBase.resetCreateDate();
        pSSysTestDataBase.resetCreateMan();
        pSSysTestDataBase.resetCustomCode();
        pSSysTestDataBase.resetData();
        pSSysTestDataBase.resetLockFlag();
        pSSysTestDataBase.resetMainPSSysTDId();
        pSSysTestDataBase.resetMainPSSysTDName();
        pSSysTestDataBase.resetMemo();
        pSSysTestDataBase.resetOrderValue();
        pSSysTestDataBase.resetPSDEId();
        pSSysTestDataBase.resetPSDEMainStateId();
        pSSysTestDataBase.resetPSDEMainStateName();
        pSSysTestDataBase.resetPSDEName();
        pSSysTestDataBase.resetPSDESampleDataId();
        pSSysTestDataBase.resetPSDESampleDataName();
        pSSysTestDataBase.resetPSModuleId();
        pSSysTestDataBase.resetPSModuleName();
        pSSysTestDataBase.resetPSSysReqItemId();
        pSSysTestDataBase.resetPSSysReqItemName();
        pSSysTestDataBase.resetPSSystemId();
        pSSysTestDataBase.resetPSSystemName();
        pSSysTestDataBase.resetPSSysTestDataId();
        pSSysTestDataBase.resetPSSysTestDataName();
        pSSysTestDataBase.resetRandomCount();
        pSSysTestDataBase.resetTestDataTag();
        pSSysTestDataBase.resetTestDataTag2();
        pSSysTestDataBase.resetTestDataType();
        pSSysTestDataBase.resetUpdateDate();
        pSSysTestDataBase.resetUpdateMan();
        pSSysTestDataBase.resetUsage();
        pSSysTestDataBase.resetUserCat();
        pSSysTestDataBase.resetUserFlag();
        pSSysTestDataBase.resetUserTag();
        pSSysTestDataBase.resetUserTag2();
        pSSysTestDataBase.resetUserTag3();
        pSSysTestDataBase.resetUserTag4();
        pSSysTestDataBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBaseModeDirty()) {
            hashMap.put(FIELD_BASEMODE, this.getBaseMode());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMainPSSysTDIdDirty()) {
            hashMap.put(FIELD_MAINPSSYSTDID, this.getMainPSSysTDId());
        }
        if (!bl || this.isMainPSSysTDNameDirty()) {
            hashMap.put(FIELD_MAINPSSYSTDNAME, this.getMainPSSysTDName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEMainStateIdDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATEID, this.getPSDEMainStateId());
        }
        if (!bl || this.isPSDEMainStateNameDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATENAME, this.getPSDEMainStateName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDESampleDataIdDirty()) {
            hashMap.put(FIELD_PSDESAMPLEDATAID, this.getPSDESampleDataId());
        }
        if (!bl || this.isPSDESampleDataNameDirty()) {
            hashMap.put(FIELD_PSDESAMPLEDATANAME, this.getPSDESampleDataName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysTestDataIdDirty()) {
            hashMap.put(FIELD_PSSYSTESTDATAID, this.getPSSysTestDataId());
        }
        if (!bl || this.isPSSysTestDataNameDirty()) {
            hashMap.put(FIELD_PSSYSTESTDATANAME, this.getPSSysTestDataName());
        }
        if (!bl || this.isRandomCountDirty()) {
            hashMap.put(FIELD_RANDOMCOUNT, this.getRandomCount());
        }
        if (!bl || this.isTestDataTagDirty()) {
            hashMap.put(FIELD_TESTDATATAG, this.getTestDataTag());
        }
        if (!bl || this.isTestDataTag2Dirty()) {
            hashMap.put(FIELD_TESTDATATAG2, this.getTestDataTag2());
        }
        if (!bl || this.isTestDataTypeDirty()) {
            hashMap.put(FIELD_TESTDATATYPE, this.getTestDataType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsageDirty()) {
            hashMap.put(FIELD_USAGE, this.getUsage());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserFlagDirty()) {
            hashMap.put(FIELD_USERFLAG, this.getUserFlag());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSSysTestDataBase.get(this, n);
    }

    private static Object get(PSSysTestDataBase pSSysTestDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTestDataBase.getBaseMode();
            }
            case 1: {
                return pSSysTestDataBase.getCodeName();
            }
            case 2: {
                return pSSysTestDataBase.getCreateDate();
            }
            case 3: {
                return pSSysTestDataBase.getCreateMan();
            }
            case 4: {
                return pSSysTestDataBase.getCustomCode();
            }
            case 5: {
                return pSSysTestDataBase.getData();
            }
            case 6: {
                return pSSysTestDataBase.getLockFlag();
            }
            case 7: {
                return pSSysTestDataBase.getMainPSSysTDId();
            }
            case 8: {
                return pSSysTestDataBase.getMainPSSysTDName();
            }
            case 9: {
                return pSSysTestDataBase.getMemo();
            }
            case 10: {
                return pSSysTestDataBase.getOrderValue();
            }
            case 11: {
                return pSSysTestDataBase.getPSDEId();
            }
            case 12: {
                return pSSysTestDataBase.getPSDEMainStateId();
            }
            case 13: {
                return pSSysTestDataBase.getPSDEMainStateName();
            }
            case 14: {
                return pSSysTestDataBase.getPSDEName();
            }
            case 15: {
                return pSSysTestDataBase.getPSDESampleDataId();
            }
            case 16: {
                return pSSysTestDataBase.getPSDESampleDataName();
            }
            case 17: {
                return pSSysTestDataBase.getPSModuleId();
            }
            case 18: {
                return pSSysTestDataBase.getPSModuleName();
            }
            case 19: {
                return pSSysTestDataBase.getPSSysReqItemId();
            }
            case 20: {
                return pSSysTestDataBase.getPSSysReqItemName();
            }
            case 21: {
                return pSSysTestDataBase.getPSSystemId();
            }
            case 22: {
                return pSSysTestDataBase.getPSSystemName();
            }
            case 23: {
                return pSSysTestDataBase.getPSSysTestDataId();
            }
            case 24: {
                return pSSysTestDataBase.getPSSysTestDataName();
            }
            case 25: {
                return pSSysTestDataBase.getRandomCount();
            }
            case 26: {
                return pSSysTestDataBase.getTestDataTag();
            }
            case 27: {
                return pSSysTestDataBase.getTestDataTag2();
            }
            case 28: {
                return pSSysTestDataBase.getTestDataType();
            }
            case 29: {
                return pSSysTestDataBase.getUpdateDate();
            }
            case 30: {
                return pSSysTestDataBase.getUpdateMan();
            }
            case 31: {
                return pSSysTestDataBase.getUsage();
            }
            case 32: {
                return pSSysTestDataBase.getUserCat();
            }
            case 33: {
                return pSSysTestDataBase.getUserFlag();
            }
            case 34: {
                return pSSysTestDataBase.getUserTag();
            }
            case 35: {
                return pSSysTestDataBase.getUserTag2();
            }
            case 36: {
                return pSSysTestDataBase.getUserTag3();
            }
            case 37: {
                return pSSysTestDataBase.getUserTag4();
            }
            case 38: {
                return pSSysTestDataBase.getValidFlag();
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
        PSSysTestDataBase.set(this, n, object);
    }

    private static void set(PSSysTestDataBase pSSysTestDataBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysTestDataBase.setBaseMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysTestDataBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysTestDataBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSysTestDataBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysTestDataBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysTestDataBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysTestDataBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysTestDataBase.setMainPSSysTDId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysTestDataBase.setMainPSSysTDName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysTestDataBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysTestDataBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysTestDataBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysTestDataBase.setPSDEMainStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysTestDataBase.setPSDEMainStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysTestDataBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysTestDataBase.setPSDESampleDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysTestDataBase.setPSDESampleDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysTestDataBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysTestDataBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysTestDataBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysTestDataBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysTestDataBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysTestDataBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysTestDataBase.setPSSysTestDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysTestDataBase.setPSSysTestDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysTestDataBase.setRandomCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSSysTestDataBase.setTestDataTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysTestDataBase.setTestDataTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysTestDataBase.setTestDataType(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysTestDataBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 30: {
                pSSysTestDataBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysTestDataBase.setUsage(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysTestDataBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysTestDataBase.setUserFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSSysTestDataBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysTestDataBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysTestDataBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysTestDataBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysTestDataBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysTestDataBase.isNull(this, n);
    }

    private static boolean isNull(PSSysTestDataBase pSSysTestDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTestDataBase.getBaseMode() == null;
            }
            case 1: {
                return pSSysTestDataBase.getCodeName() == null;
            }
            case 2: {
                return pSSysTestDataBase.getCreateDate() == null;
            }
            case 3: {
                return pSSysTestDataBase.getCreateMan() == null;
            }
            case 4: {
                return pSSysTestDataBase.getCustomCode() == null;
            }
            case 5: {
                return pSSysTestDataBase.getData() == null;
            }
            case 6: {
                return pSSysTestDataBase.getLockFlag() == null;
            }
            case 7: {
                return pSSysTestDataBase.getMainPSSysTDId() == null;
            }
            case 8: {
                return pSSysTestDataBase.getMainPSSysTDName() == null;
            }
            case 9: {
                return pSSysTestDataBase.getMemo() == null;
            }
            case 10: {
                return pSSysTestDataBase.getOrderValue() == null;
            }
            case 11: {
                return pSSysTestDataBase.getPSDEId() == null;
            }
            case 12: {
                return pSSysTestDataBase.getPSDEMainStateId() == null;
            }
            case 13: {
                return pSSysTestDataBase.getPSDEMainStateName() == null;
            }
            case 14: {
                return pSSysTestDataBase.getPSDEName() == null;
            }
            case 15: {
                return pSSysTestDataBase.getPSDESampleDataId() == null;
            }
            case 16: {
                return pSSysTestDataBase.getPSDESampleDataName() == null;
            }
            case 17: {
                return pSSysTestDataBase.getPSModuleId() == null;
            }
            case 18: {
                return pSSysTestDataBase.getPSModuleName() == null;
            }
            case 19: {
                return pSSysTestDataBase.getPSSysReqItemId() == null;
            }
            case 20: {
                return pSSysTestDataBase.getPSSysReqItemName() == null;
            }
            case 21: {
                return pSSysTestDataBase.getPSSystemId() == null;
            }
            case 22: {
                return pSSysTestDataBase.getPSSystemName() == null;
            }
            case 23: {
                return pSSysTestDataBase.getPSSysTestDataId() == null;
            }
            case 24: {
                return pSSysTestDataBase.getPSSysTestDataName() == null;
            }
            case 25: {
                return pSSysTestDataBase.getRandomCount() == null;
            }
            case 26: {
                return pSSysTestDataBase.getTestDataTag() == null;
            }
            case 27: {
                return pSSysTestDataBase.getTestDataTag2() == null;
            }
            case 28: {
                return pSSysTestDataBase.getTestDataType() == null;
            }
            case 29: {
                return pSSysTestDataBase.getUpdateDate() == null;
            }
            case 30: {
                return pSSysTestDataBase.getUpdateMan() == null;
            }
            case 31: {
                return pSSysTestDataBase.getUsage() == null;
            }
            case 32: {
                return pSSysTestDataBase.getUserCat() == null;
            }
            case 33: {
                return pSSysTestDataBase.getUserFlag() == null;
            }
            case 34: {
                return pSSysTestDataBase.getUserTag() == null;
            }
            case 35: {
                return pSSysTestDataBase.getUserTag2() == null;
            }
            case 36: {
                return pSSysTestDataBase.getUserTag3() == null;
            }
            case 37: {
                return pSSysTestDataBase.getUserTag4() == null;
            }
            case 38: {
                return pSSysTestDataBase.getValidFlag() == null;
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
        return PSSysTestDataBase.contains(this, n);
    }

    private static boolean contains(PSSysTestDataBase pSSysTestDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTestDataBase.isBaseModeDirty();
            }
            case 1: {
                return pSSysTestDataBase.isCodeNameDirty();
            }
            case 2: {
                return pSSysTestDataBase.isCreateDateDirty();
            }
            case 3: {
                return pSSysTestDataBase.isCreateManDirty();
            }
            case 4: {
                return pSSysTestDataBase.isCustomCodeDirty();
            }
            case 5: {
                return pSSysTestDataBase.isDataDirty();
            }
            case 6: {
                return pSSysTestDataBase.isLockFlagDirty();
            }
            case 7: {
                return pSSysTestDataBase.isMainPSSysTDIdDirty();
            }
            case 8: {
                return pSSysTestDataBase.isMainPSSysTDNameDirty();
            }
            case 9: {
                return pSSysTestDataBase.isMemoDirty();
            }
            case 10: {
                return pSSysTestDataBase.isOrderValueDirty();
            }
            case 11: {
                return pSSysTestDataBase.isPSDEIdDirty();
            }
            case 12: {
                return pSSysTestDataBase.isPSDEMainStateIdDirty();
            }
            case 13: {
                return pSSysTestDataBase.isPSDEMainStateNameDirty();
            }
            case 14: {
                return pSSysTestDataBase.isPSDENameDirty();
            }
            case 15: {
                return pSSysTestDataBase.isPSDESampleDataIdDirty();
            }
            case 16: {
                return pSSysTestDataBase.isPSDESampleDataNameDirty();
            }
            case 17: {
                return pSSysTestDataBase.isPSModuleIdDirty();
            }
            case 18: {
                return pSSysTestDataBase.isPSModuleNameDirty();
            }
            case 19: {
                return pSSysTestDataBase.isPSSysReqItemIdDirty();
            }
            case 20: {
                return pSSysTestDataBase.isPSSysReqItemNameDirty();
            }
            case 21: {
                return pSSysTestDataBase.isPSSystemIdDirty();
            }
            case 22: {
                return pSSysTestDataBase.isPSSystemNameDirty();
            }
            case 23: {
                return pSSysTestDataBase.isPSSysTestDataIdDirty();
            }
            case 24: {
                return pSSysTestDataBase.isPSSysTestDataNameDirty();
            }
            case 25: {
                return pSSysTestDataBase.isRandomCountDirty();
            }
            case 26: {
                return pSSysTestDataBase.isTestDataTagDirty();
            }
            case 27: {
                return pSSysTestDataBase.isTestDataTag2Dirty();
            }
            case 28: {
                return pSSysTestDataBase.isTestDataTypeDirty();
            }
            case 29: {
                return pSSysTestDataBase.isUpdateDateDirty();
            }
            case 30: {
                return pSSysTestDataBase.isUpdateManDirty();
            }
            case 31: {
                return pSSysTestDataBase.isUsageDirty();
            }
            case 32: {
                return pSSysTestDataBase.isUserCatDirty();
            }
            case 33: {
                return pSSysTestDataBase.isUserFlagDirty();
            }
            case 34: {
                return pSSysTestDataBase.isUserTagDirty();
            }
            case 35: {
                return pSSysTestDataBase.isUserTag2Dirty();
            }
            case 36: {
                return pSSysTestDataBase.isUserTag3Dirty();
            }
            case 37: {
                return pSSysTestDataBase.isUserTag4Dirty();
            }
            case 38: {
                return pSSysTestDataBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysTestDataBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysTestDataBase pSSysTestDataBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysTestDataBase.getBaseMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"basemode", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getBaseMode()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getData()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getMainPSSysTDId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mainpssystdid", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getMainPSSysTDId()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getMainPSSysTDName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mainpssystdname", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getMainPSSysTDName()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getPSDEMainStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstateid", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getPSDEMainStateId()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getPSDEMainStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstatename", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getPSDEMainStateName()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getPSDESampleDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesampledataid", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getPSDESampleDataId()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getPSDESampleDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesampledataname", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getPSDESampleDataName()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getPSSysTestDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestdataid", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getPSSysTestDataId()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getPSSysTestDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestdataname", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getPSSysTestDataName()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getRandomCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"randomcount", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getRandomCount()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getTestDataTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testdatatag", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getTestDataTag()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getTestDataTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testdatatag2", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getTestDataTag2()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getTestDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testdatatype", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getTestDataType()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getUsage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usage", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getUsage()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getUserFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userflag", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getUserFlag()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysTestDataBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysTestDataBase.getJSONValue((Object)pSSysTestDataBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysTestDataBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysTestDataBase pSSysTestDataBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysTestDataBase.getBaseMode() != null) {
            object = pSSysTestDataBase.getBaseMode();
            xmlNode.setAttribute(FIELD_BASEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTestDataBase.getCodeName() != null) {
            object = pSSysTestDataBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getCreateDate() != null) {
            object = pSSysTestDataBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTestDataBase.getCreateMan() != null) {
            object = pSSysTestDataBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getCustomCode() != null) {
            object = pSSysTestDataBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getData() != null) {
            object = pSSysTestDataBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getLockFlag() != null) {
            object = pSSysTestDataBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTestDataBase.getMainPSSysTDId() != null) {
            object = pSSysTestDataBase.getMainPSSysTDId();
            xmlNode.setAttribute(FIELD_MAINPSSYSTDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getMainPSSysTDName() != null) {
            object = pSSysTestDataBase.getMainPSSysTDName();
            xmlNode.setAttribute(FIELD_MAINPSSYSTDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getMemo() != null) {
            object = pSSysTestDataBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getOrderValue() != null) {
            object = pSSysTestDataBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTestDataBase.getPSDEId() != null) {
            object = pSSysTestDataBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getPSDEMainStateId() != null) {
            object = pSSysTestDataBase.getPSDEMainStateId();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getPSDEMainStateName() != null) {
            object = pSSysTestDataBase.getPSDEMainStateName();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getPSDEName() != null) {
            object = pSSysTestDataBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getPSDESampleDataId() != null) {
            object = pSSysTestDataBase.getPSDESampleDataId();
            xmlNode.setAttribute(FIELD_PSDESAMPLEDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getPSDESampleDataName() != null) {
            object = pSSysTestDataBase.getPSDESampleDataName();
            xmlNode.setAttribute(FIELD_PSDESAMPLEDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getPSModuleId() != null) {
            object = pSSysTestDataBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getPSModuleName() != null) {
            object = pSSysTestDataBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getPSSysReqItemId() != null) {
            object = pSSysTestDataBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getPSSysReqItemName() != null) {
            object = pSSysTestDataBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getPSSystemId() != null) {
            object = pSSysTestDataBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getPSSystemName() != null) {
            object = pSSysTestDataBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getPSSysTestDataId() != null) {
            object = pSSysTestDataBase.getPSSysTestDataId();
            xmlNode.setAttribute(FIELD_PSSYSTESTDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getPSSysTestDataName() != null) {
            object = pSSysTestDataBase.getPSSysTestDataName();
            xmlNode.setAttribute(FIELD_PSSYSTESTDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getRandomCount() != null) {
            object = pSSysTestDataBase.getRandomCount();
            xmlNode.setAttribute(FIELD_RANDOMCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTestDataBase.getTestDataTag() != null) {
            object = pSSysTestDataBase.getTestDataTag();
            xmlNode.setAttribute(FIELD_TESTDATATAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getTestDataTag2() != null) {
            object = pSSysTestDataBase.getTestDataTag2();
            xmlNode.setAttribute(FIELD_TESTDATATAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getTestDataType() != null) {
            object = pSSysTestDataBase.getTestDataType();
            xmlNode.setAttribute(FIELD_TESTDATATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getUpdateDate() != null) {
            object = pSSysTestDataBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTestDataBase.getUpdateMan() != null) {
            object = pSSysTestDataBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getUsage() != null) {
            object = pSSysTestDataBase.getUsage();
            xmlNode.setAttribute(FIELD_USAGE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getUserCat() != null) {
            object = pSSysTestDataBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getUserFlag() != null) {
            object = pSSysTestDataBase.getUserFlag();
            xmlNode.setAttribute(FIELD_USERFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTestDataBase.getUserTag() != null) {
            object = pSSysTestDataBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getUserTag2() != null) {
            object = pSSysTestDataBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getUserTag3() != null) {
            object = pSSysTestDataBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getUserTag4() != null) {
            object = pSSysTestDataBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestDataBase.getValidFlag() != null) {
            object = pSSysTestDataBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysTestDataBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysTestDataBase pSSysTestDataBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysTestDataBase.isBaseModeDirty() && (bl || pSSysTestDataBase.getBaseMode() != null)) {
            iDataObject.set(FIELD_BASEMODE, (Object)pSSysTestDataBase.getBaseMode());
        }
        if (pSSysTestDataBase.isCodeNameDirty() && (bl || pSSysTestDataBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysTestDataBase.getCodeName());
        }
        if (pSSysTestDataBase.isCreateDateDirty() && (bl || pSSysTestDataBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysTestDataBase.getCreateDate());
        }
        if (pSSysTestDataBase.isCreateManDirty() && (bl || pSSysTestDataBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysTestDataBase.getCreateMan());
        }
        if (pSSysTestDataBase.isCustomCodeDirty() && (bl || pSSysTestDataBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysTestDataBase.getCustomCode());
        }
        if (pSSysTestDataBase.isDataDirty() && (bl || pSSysTestDataBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSSysTestDataBase.getData());
        }
        if (pSSysTestDataBase.isLockFlagDirty() && (bl || pSSysTestDataBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysTestDataBase.getLockFlag());
        }
        if (pSSysTestDataBase.isMainPSSysTDIdDirty() && (bl || pSSysTestDataBase.getMainPSSysTDId() != null)) {
            iDataObject.set(FIELD_MAINPSSYSTDID, (Object)pSSysTestDataBase.getMainPSSysTDId());
        }
        if (pSSysTestDataBase.isMainPSSysTDNameDirty() && (bl || pSSysTestDataBase.getMainPSSysTDName() != null)) {
            iDataObject.set(FIELD_MAINPSSYSTDNAME, (Object)pSSysTestDataBase.getMainPSSysTDName());
        }
        if (pSSysTestDataBase.isMemoDirty() && (bl || pSSysTestDataBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysTestDataBase.getMemo());
        }
        if (pSSysTestDataBase.isOrderValueDirty() && (bl || pSSysTestDataBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysTestDataBase.getOrderValue());
        }
        if (pSSysTestDataBase.isPSDEIdDirty() && (bl || pSSysTestDataBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysTestDataBase.getPSDEId());
        }
        if (pSSysTestDataBase.isPSDEMainStateIdDirty() && (bl || pSSysTestDataBase.getPSDEMainStateId() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATEID, (Object)pSSysTestDataBase.getPSDEMainStateId());
        }
        if (pSSysTestDataBase.isPSDEMainStateNameDirty() && (bl || pSSysTestDataBase.getPSDEMainStateName() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATENAME, (Object)pSSysTestDataBase.getPSDEMainStateName());
        }
        if (pSSysTestDataBase.isPSDENameDirty() && (bl || pSSysTestDataBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysTestDataBase.getPSDEName());
        }
        if (pSSysTestDataBase.isPSDESampleDataIdDirty() && (bl || pSSysTestDataBase.getPSDESampleDataId() != null)) {
            iDataObject.set(FIELD_PSDESAMPLEDATAID, (Object)pSSysTestDataBase.getPSDESampleDataId());
        }
        if (pSSysTestDataBase.isPSDESampleDataNameDirty() && (bl || pSSysTestDataBase.getPSDESampleDataName() != null)) {
            iDataObject.set(FIELD_PSDESAMPLEDATANAME, (Object)pSSysTestDataBase.getPSDESampleDataName());
        }
        if (pSSysTestDataBase.isPSModuleIdDirty() && (bl || pSSysTestDataBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysTestDataBase.getPSModuleId());
        }
        if (pSSysTestDataBase.isPSModuleNameDirty() && (bl || pSSysTestDataBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysTestDataBase.getPSModuleName());
        }
        if (pSSysTestDataBase.isPSSysReqItemIdDirty() && (bl || pSSysTestDataBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSSysTestDataBase.getPSSysReqItemId());
        }
        if (pSSysTestDataBase.isPSSysReqItemNameDirty() && (bl || pSSysTestDataBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSSysTestDataBase.getPSSysReqItemName());
        }
        if (pSSysTestDataBase.isPSSystemIdDirty() && (bl || pSSysTestDataBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysTestDataBase.getPSSystemId());
        }
        if (pSSysTestDataBase.isPSSystemNameDirty() && (bl || pSSysTestDataBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysTestDataBase.getPSSystemName());
        }
        if (pSSysTestDataBase.isPSSysTestDataIdDirty() && (bl || pSSysTestDataBase.getPSSysTestDataId() != null)) {
            iDataObject.set(FIELD_PSSYSTESTDATAID, (Object)pSSysTestDataBase.getPSSysTestDataId());
        }
        if (pSSysTestDataBase.isPSSysTestDataNameDirty() && (bl || pSSysTestDataBase.getPSSysTestDataName() != null)) {
            iDataObject.set(FIELD_PSSYSTESTDATANAME, (Object)pSSysTestDataBase.getPSSysTestDataName());
        }
        if (pSSysTestDataBase.isRandomCountDirty() && (bl || pSSysTestDataBase.getRandomCount() != null)) {
            iDataObject.set(FIELD_RANDOMCOUNT, (Object)pSSysTestDataBase.getRandomCount());
        }
        if (pSSysTestDataBase.isTestDataTagDirty() && (bl || pSSysTestDataBase.getTestDataTag() != null)) {
            iDataObject.set(FIELD_TESTDATATAG, (Object)pSSysTestDataBase.getTestDataTag());
        }
        if (pSSysTestDataBase.isTestDataTag2Dirty() && (bl || pSSysTestDataBase.getTestDataTag2() != null)) {
            iDataObject.set(FIELD_TESTDATATAG2, (Object)pSSysTestDataBase.getTestDataTag2());
        }
        if (pSSysTestDataBase.isTestDataTypeDirty() && (bl || pSSysTestDataBase.getTestDataType() != null)) {
            iDataObject.set(FIELD_TESTDATATYPE, (Object)pSSysTestDataBase.getTestDataType());
        }
        if (pSSysTestDataBase.isUpdateDateDirty() && (bl || pSSysTestDataBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysTestDataBase.getUpdateDate());
        }
        if (pSSysTestDataBase.isUpdateManDirty() && (bl || pSSysTestDataBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysTestDataBase.getUpdateMan());
        }
        if (pSSysTestDataBase.isUsageDirty() && (bl || pSSysTestDataBase.getUsage() != null)) {
            iDataObject.set(FIELD_USAGE, (Object)pSSysTestDataBase.getUsage());
        }
        if (pSSysTestDataBase.isUserCatDirty() && (bl || pSSysTestDataBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysTestDataBase.getUserCat());
        }
        if (pSSysTestDataBase.isUserFlagDirty() && (bl || pSSysTestDataBase.getUserFlag() != null)) {
            iDataObject.set(FIELD_USERFLAG, (Object)pSSysTestDataBase.getUserFlag());
        }
        if (pSSysTestDataBase.isUserTagDirty() && (bl || pSSysTestDataBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysTestDataBase.getUserTag());
        }
        if (pSSysTestDataBase.isUserTag2Dirty() && (bl || pSSysTestDataBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysTestDataBase.getUserTag2());
        }
        if (pSSysTestDataBase.isUserTag3Dirty() && (bl || pSSysTestDataBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysTestDataBase.getUserTag3());
        }
        if (pSSysTestDataBase.isUserTag4Dirty() && (bl || pSSysTestDataBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysTestDataBase.getUserTag4());
        }
        if (pSSysTestDataBase.isValidFlagDirty() && (bl || pSSysTestDataBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysTestDataBase.getValidFlag());
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
        return PSSysTestDataBase.remove(this, n);
    }

    private static boolean remove(PSSysTestDataBase pSSysTestDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysTestDataBase.resetBaseMode();
                return true;
            }
            case 1: {
                pSSysTestDataBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSysTestDataBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSysTestDataBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSysTestDataBase.resetCustomCode();
                return true;
            }
            case 5: {
                pSSysTestDataBase.resetData();
                return true;
            }
            case 6: {
                pSSysTestDataBase.resetLockFlag();
                return true;
            }
            case 7: {
                pSSysTestDataBase.resetMainPSSysTDId();
                return true;
            }
            case 8: {
                pSSysTestDataBase.resetMainPSSysTDName();
                return true;
            }
            case 9: {
                pSSysTestDataBase.resetMemo();
                return true;
            }
            case 10: {
                pSSysTestDataBase.resetOrderValue();
                return true;
            }
            case 11: {
                pSSysTestDataBase.resetPSDEId();
                return true;
            }
            case 12: {
                pSSysTestDataBase.resetPSDEMainStateId();
                return true;
            }
            case 13: {
                pSSysTestDataBase.resetPSDEMainStateName();
                return true;
            }
            case 14: {
                pSSysTestDataBase.resetPSDEName();
                return true;
            }
            case 15: {
                pSSysTestDataBase.resetPSDESampleDataId();
                return true;
            }
            case 16: {
                pSSysTestDataBase.resetPSDESampleDataName();
                return true;
            }
            case 17: {
                pSSysTestDataBase.resetPSModuleId();
                return true;
            }
            case 18: {
                pSSysTestDataBase.resetPSModuleName();
                return true;
            }
            case 19: {
                pSSysTestDataBase.resetPSSysReqItemId();
                return true;
            }
            case 20: {
                pSSysTestDataBase.resetPSSysReqItemName();
                return true;
            }
            case 21: {
                pSSysTestDataBase.resetPSSystemId();
                return true;
            }
            case 22: {
                pSSysTestDataBase.resetPSSystemName();
                return true;
            }
            case 23: {
                pSSysTestDataBase.resetPSSysTestDataId();
                return true;
            }
            case 24: {
                pSSysTestDataBase.resetPSSysTestDataName();
                return true;
            }
            case 25: {
                pSSysTestDataBase.resetRandomCount();
                return true;
            }
            case 26: {
                pSSysTestDataBase.resetTestDataTag();
                return true;
            }
            case 27: {
                pSSysTestDataBase.resetTestDataTag2();
                return true;
            }
            case 28: {
                pSSysTestDataBase.resetTestDataType();
                return true;
            }
            case 29: {
                pSSysTestDataBase.resetUpdateDate();
                return true;
            }
            case 30: {
                pSSysTestDataBase.resetUpdateMan();
                return true;
            }
            case 31: {
                pSSysTestDataBase.resetUsage();
                return true;
            }
            case 32: {
                pSSysTestDataBase.resetUserCat();
                return true;
            }
            case 33: {
                pSSysTestDataBase.resetUserFlag();
                return true;
            }
            case 34: {
                pSSysTestDataBase.resetUserTag();
                return true;
            }
            case 35: {
                pSSysTestDataBase.resetUserTag2();
                return true;
            }
            case 36: {
                pSSysTestDataBase.resetUserTag3();
                return true;
            }
            case 37: {
                pSSysTestDataBase.resetUserTag4();
                return true;
            }
            case 38: {
                pSSysTestDataBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEMainState getPSDEMainState() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainState();
        }
        if (this.getPSDEMainStateId() == null) {
            return null;
        }
        Integer n = this.objPSDEMainStateLock;
        synchronized (n) {
            if (this.psdemainstate != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEMainStateId(), (Object)this.psdemainstate.getPSDEMainStateId()) != 0L) {
                this.psdemainstate = null;
            }
            if (this.psdemainstate == null) {
                PSDEMainState pSDEMainState = new PSDEMainState();
                pSDEMainState.setPSDEMainStateId(this.getPSDEMainStateId());
                PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
                pSDEMainStateService.autoGet(pSDEMainState);
                this.psdemainstate = pSDEMainState;
            }
            return this.psdemainstate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDESampleData getPSDESampleData() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESampleData();
        }
        if (this.getPSDESampleDataId() == null) {
            return null;
        }
        Integer n = this.objPSDESampleDataLock;
        synchronized (n) {
            if (this.psdesampledata != null && DataTypeHelper.compare((int)25, (Object)this.getPSDESampleDataId(), (Object)this.psdesampledata.getPSDESampleDataId()) != 0L) {
                this.psdesampledata = null;
            }
            if (this.psdesampledata == null) {
                PSDESampleData pSDESampleData = new PSDESampleData();
                pSDESampleData.setPSDESampleDataId(this.getPSDESampleDataId());
                PSDESampleDataService pSDESampleDataService = (PSDESampleDataService)ServiceGlobal.getService(PSDESampleDataService.class, (SessionFactory)this.getSessionFactory());
                pSDESampleDataService.autoGet(pSDESampleData);
                this.psdesampledata = pSDESampleData;
            }
            return this.psdesampledata;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet(pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTestData getMainPSSysTD() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainPSSysTD();
        }
        if (this.getMainPSSysTDId() == null) {
            return null;
        }
        Integer n = this.objMainPSSysTDLock;
        synchronized (n) {
            if (this.mainpssystd != null && DataTypeHelper.compare((int)25, (Object)this.getMainPSSysTDId(), (Object)this.mainpssystd.getPSSysTestDataId()) != 0L) {
                this.mainpssystd = null;
            }
            if (this.mainpssystd == null) {
                PSSysTestData pSSysTestData = new PSSysTestData();
                pSSysTestData.setPSSysTestDataId(this.getMainPSSysTDId());
                PSSysTestDataService pSSysTestDataService = (PSSysTestDataService)ServiceGlobal.getService(PSSysTestDataService.class, (SessionFactory)this.getSessionFactory());
                pSSysTestDataService.autoGet(pSSysTestData);
                this.mainpssystd = pSSysTestData;
            }
            return this.mainpssystd;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTDItem> getPSSysTDItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTDItems();
        }
        if (this.getPSSysTestDataId() == null) {
            return null;
        }
        PSSysTestDataService pSSysTestDataService = (PSSysTestDataService)ServiceGlobal.getService(PSSysTestDataService.class, (SessionFactory)this.getSessionFactory());
        PSSysTDItemService pSSysTDItemService = (PSSysTDItemService)ServiceGlobal.getService(PSSysTDItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTDItemsLock;
        synchronized (n) {
            if (this.pssystditems == null) {
                this.pssystditems = pSSysTestDataService.isTempData(this) ? pSSysTDItemService.selectTempByPSSysTestData(this) : pSSysTDItemService.selectByPSSysTestData(this);
            }
            return this.pssystditems;
        }
    }

    private PSSysTestDataBase getProxyEntity() {
        return this.proxyPSSysTestDataBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysTestDataBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysTestDataBase) {
            this.proxyPSSysTestDataBase = (PSSysTestDataBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestDataService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BASEMODE, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 4);
        fieldIndexMap.put(FIELD_DATA, 5);
        fieldIndexMap.put(FIELD_LOCKFLAG, 6);
        fieldIndexMap.put(FIELD_MAINPSSYSTDID, 7);
        fieldIndexMap.put(FIELD_MAINPSSYSTDNAME, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_ORDERVALUE, 10);
        fieldIndexMap.put(FIELD_PSDEID, 11);
        fieldIndexMap.put(FIELD_PSDEMAINSTATEID, 12);
        fieldIndexMap.put(FIELD_PSDEMAINSTATENAME, 13);
        fieldIndexMap.put(FIELD_PSDENAME, 14);
        fieldIndexMap.put(FIELD_PSDESAMPLEDATAID, 15);
        fieldIndexMap.put(FIELD_PSDESAMPLEDATANAME, 16);
        fieldIndexMap.put(FIELD_PSMODULEID, 17);
        fieldIndexMap.put(FIELD_PSMODULENAME, 18);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 19);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 22);
        fieldIndexMap.put(FIELD_PSSYSTESTDATAID, 23);
        fieldIndexMap.put(FIELD_PSSYSTESTDATANAME, 24);
        fieldIndexMap.put(FIELD_RANDOMCOUNT, 25);
        fieldIndexMap.put(FIELD_TESTDATATAG, 26);
        fieldIndexMap.put(FIELD_TESTDATATAG2, 27);
        fieldIndexMap.put(FIELD_TESTDATATYPE, 28);
        fieldIndexMap.put(FIELD_UPDATEDATE, 29);
        fieldIndexMap.put(FIELD_UPDATEMAN, 30);
        fieldIndexMap.put(FIELD_USAGE, 31);
        fieldIndexMap.put(FIELD_USERCAT, 32);
        fieldIndexMap.put(FIELD_USERFLAG, 33);
        fieldIndexMap.put(FIELD_USERTAG, 34);
        fieldIndexMap.put(FIELD_USERTAG2, 35);
        fieldIndexMap.put(FIELD_USERTAG3, 36);
        fieldIndexMap.put(FIELD_USERTAG4, 37);
        fieldIndexMap.put(FIELD_VALIDFLAG, 38);
    }
}

