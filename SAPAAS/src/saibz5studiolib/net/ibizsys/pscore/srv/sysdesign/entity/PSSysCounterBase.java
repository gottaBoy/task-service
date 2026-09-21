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
import net.ibizsys.pscore.srv.config.entity.PSCounter;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSCounterService;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounterItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCounterBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysCounterBase.class);
    public static final String FIELD_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COUNTERDATA = "COUNTERDATA";
    public static final String FIELD_COUNTERDATA2 = "COUNTERDATA2";
    public static final String FIELD_COUNTERPARAMS = "COUNTERPARAMS";
    public static final String FIELD_COUNTERTYPE = "COUNTERTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCOUNTERID = "PSCOUNTERID";
    public static final String FIELD_PSCOUNTERNAME = "PSCOUNTERNAME";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_RELOADTIMER = "RELOADTIMER";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_BASECLSPARAMS = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_COUNTERDATA = 2;
    private static final int INDEX_COUNTERDATA2 = 3;
    private static final int INDEX_COUNTERPARAMS = 4;
    private static final int INDEX_COUNTERTYPE = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_CUSTOMCOND = 8;
    private static final int INDEX_CUSTOMTYPE = 9;
    private static final int INDEX_LOCKFLAG = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_PSCOUNTERID = 12;
    private static final int INDEX_PSCOUNTERNAME = 13;
    private static final int INDEX_PSDEACTIONID = 14;
    private static final int INDEX_PSDEACTIONNAME = 15;
    private static final int INDEX_PSDEDATASETID = 16;
    private static final int INDEX_PSDEDATASETNAME = 17;
    private static final int INDEX_PSDEID = 18;
    private static final int INDEX_PSDENAME = 19;
    private static final int INDEX_PSMODULEID = 20;
    private static final int INDEX_PSMODULENAME = 21;
    private static final int INDEX_PSSYSCOUNTERID = 22;
    private static final int INDEX_PSSYSCOUNTERNAME = 23;
    private static final int INDEX_PSSYSDYNAMODELID = 24;
    private static final int INDEX_PSSYSDYNAMODELNAME = 25;
    private static final int INDEX_PSSYSPFPLUGINID = 26;
    private static final int INDEX_PSSYSPFPLUGINNAME = 27;
    private static final int INDEX_PSSYSSFPLUGINID = 28;
    private static final int INDEX_PSSYSSFPLUGINNAME = 29;
    private static final int INDEX_PSSYSTEMID = 30;
    private static final int INDEX_PSSYSTEMNAME = 31;
    private static final int INDEX_RELOADTIMER = 32;
    private static final int INDEX_TODOTASK = 33;
    private static final int INDEX_UPDATEDATE = 34;
    private static final int INDEX_UPDATEMAN = 35;
    private static final int INDEX_USERCAT = 36;
    private static final int INDEX_USERTAG = 37;
    private static final int INDEX_USERTAG2 = 38;
    private static final int INDEX_USERTAG3 = 39;
    private static final int INDEX_USERTAG4 = 40;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysCounterBase proxyPSSysCounterBase = null;
    private boolean baseclsparamsDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean counterdataDirtyFlag = false;
    private boolean counterdata2DirtyFlag = false;
    private boolean counterparamsDirtyFlag = false;
    private boolean countertypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pscounteridDirtyFlag = false;
    private boolean pscounternameDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean reloadtimerDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="baseclsparams")
    private String baseclsparams;
    @Column(name="codename")
    private String codename;
    @Column(name="counterdata")
    private String counterdata;
    @Column(name="counterdata2")
    private String counterdata2;
    @Column(name="counterparams")
    private String counterparams;
    @Column(name="countertype")
    private String countertype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcond")
    private String customcond;
    @Column(name="customtype")
    private String customtype;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="pscounterid")
    private String pscounterid;
    @Column(name="pscountername")
    private String pscountername;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyscounterid")
    private String pssyscounterid;
    @Column(name="pssyscountername")
    private String pssyscountername;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="reloadtimer")
    private Integer reloadtimer;
    @Column(name="todotask")
    private String todotask;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSCounterLock = new Integer(1);
    private PSCounter pscounter = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysCounterItemsLock = new Integer(1);
    private ArrayList<PSSysCounterItem> pssyscounteritems = null;

    public void setBaseClsParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseClsParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.baseclsparams = string;
        this.baseclsparamsDirtyFlag = true;
    }

    public String getBaseClsParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseClsParams();
        }
        return this.baseclsparams;
    }

    public boolean isBaseClsParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseClsParamsDirty();
        }
        return this.baseclsparamsDirtyFlag;
    }

    public void resetBaseClsParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseClsParams();
            return;
        }
        this.baseclsparamsDirtyFlag = false;
        this.baseclsparams = null;
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

    public void setCounterData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCounterData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.counterdata = string;
        this.counterdataDirtyFlag = true;
    }

    public String getCounterData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCounterData();
        }
        return this.counterdata;
    }

    public boolean isCounterDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCounterDataDirty();
        }
        return this.counterdataDirtyFlag;
    }

    public void resetCounterData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCounterData();
            return;
        }
        this.counterdataDirtyFlag = false;
        this.counterdata = null;
    }

    public void setCounterData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCounterData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.counterdata2 = string;
        this.counterdata2DirtyFlag = true;
    }

    public String getCounterData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCounterData2();
        }
        return this.counterdata2;
    }

    public boolean isCounterData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCounterData2Dirty();
        }
        return this.counterdata2DirtyFlag;
    }

    public void resetCounterData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCounterData2();
            return;
        }
        this.counterdata2DirtyFlag = false;
        this.counterdata2 = null;
    }

    public void setCounterParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCounterParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.counterparams = string;
        this.counterparamsDirtyFlag = true;
    }

    public String getCounterParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCounterParams();
        }
        return this.counterparams;
    }

    public boolean isCounterParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCounterParamsDirty();
        }
        return this.counterparamsDirtyFlag;
    }

    public void resetCounterParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCounterParams();
            return;
        }
        this.counterparamsDirtyFlag = false;
        this.counterparams = null;
    }

    public void setCounterType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCounterType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.countertype = string;
        this.countertypeDirtyFlag = true;
    }

    public String getCounterType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCounterType();
        }
        return this.countertype;
    }

    public boolean isCounterTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCounterTypeDirty();
        }
        return this.countertypeDirtyFlag;
    }

    public void resetCounterType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCounterType();
            return;
        }
        this.countertypeDirtyFlag = false;
        this.countertype = null;
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

    public void setCustomCond(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCond(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcond = string;
        this.customcondDirtyFlag = true;
    }

    public String getCustomCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCond();
        }
        return this.customcond;
    }

    public boolean isCustomCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCondDirty();
        }
        return this.customcondDirtyFlag;
    }

    public void resetCustomCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCond();
            return;
        }
        this.customcondDirtyFlag = false;
        this.customcond = null;
    }

    public void setCustomType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customtype = string;
        this.customtypeDirtyFlag = true;
    }

    public String getCustomType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomType();
        }
        return this.customtype;
    }

    public boolean isCustomTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomTypeDirty();
        }
        return this.customtypeDirtyFlag;
    }

    public void resetCustomType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomType();
            return;
        }
        this.customtypeDirtyFlag = false;
        this.customtype = null;
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

    public void setPSCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscounterid = string;
        this.pscounteridDirtyFlag = true;
    }

    public String getPSCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCounterId();
        }
        return this.pscounterid;
    }

    public boolean isPSCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCounterIdDirty();
        }
        return this.pscounteridDirtyFlag;
    }

    public void resetPSCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCounterId();
            return;
        }
        this.pscounteridDirtyFlag = false;
        this.pscounterid = null;
    }

    public void setPSCounterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCounterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscountername = string;
        this.pscounternameDirtyFlag = true;
    }

    public String getPSCounterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCounterName();
        }
        return this.pscountername;
    }

    public boolean isPSCounterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCounterNameDirty();
        }
        return this.pscounternameDirtyFlag;
    }

    public void resetPSCounterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCounterName();
            return;
        }
        this.pscounternameDirtyFlag = false;
        this.pscountername = null;
    }

    public void setPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionid = string;
        this.psdeactionidDirtyFlag = true;
    }

    public String getPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionId();
        }
        return this.psdeactionid;
    }

    public boolean isPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionIdDirty();
        }
        return this.psdeactionidDirtyFlag;
    }

    public void resetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionId();
            return;
        }
        this.psdeactionidDirtyFlag = false;
        this.psdeactionid = null;
    }

    public void setPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionname = string;
        this.psdeactionnameDirtyFlag = true;
    }

    public String getPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionName();
        }
        return this.psdeactionname;
    }

    public boolean isPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionNameDirty();
        }
        return this.psdeactionnameDirtyFlag;
    }

    public void resetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionName();
            return;
        }
        this.psdeactionnameDirtyFlag = false;
        this.psdeactionname = null;
    }

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
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

    public void setPSSysCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscounterid = string;
        this.pssyscounteridDirtyFlag = true;
    }

    public String getPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterId();
        }
        return this.pssyscounterid;
    }

    public boolean isPSSysCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterIdDirty();
        }
        return this.pssyscounteridDirtyFlag;
    }

    public void resetPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterId();
            return;
        }
        this.pssyscounteridDirtyFlag = false;
        this.pssyscounterid = null;
    }

    public void setPSSysCounterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscountername = string;
        this.pssyscounternameDirtyFlag = true;
    }

    public String getPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterName();
        }
        return this.pssyscountername;
    }

    public boolean isPSSysCounterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterNameDirty();
        }
        return this.pssyscounternameDirtyFlag;
    }

    public void resetPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterName();
            return;
        }
        this.pssyscounternameDirtyFlag = false;
        this.pssyscountername = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
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

    public void setReloadTimer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReloadTimer(n);
            return;
        }
        this.reloadtimer = n;
        this.reloadtimerDirtyFlag = true;
    }

    public Integer getReloadTimer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReloadTimer();
        }
        return this.reloadtimer;
    }

    public boolean isReloadTimerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReloadTimerDirty();
        }
        return this.reloadtimerDirtyFlag;
    }

    public void resetReloadTimer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReloadTimer();
            return;
        }
        this.reloadtimerDirtyFlag = false;
        this.reloadtimer = null;
    }

    public void setToDoTask(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToDoTask(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.todotask = string;
        this.todotaskDirtyFlag = true;
    }

    public String getToDoTask() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToDoTask();
        }
        return this.todotask;
    }

    public boolean isToDoTaskDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToDoTaskDirty();
        }
        return this.todotaskDirtyFlag;
    }

    public void resetToDoTask() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToDoTask();
            return;
        }
        this.todotaskDirtyFlag = false;
        this.todotask = null;
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

    protected void onReset() {
        PSSysCounterBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysCounterBase pSSysCounterBase) {
        pSSysCounterBase.resetBaseClsParams();
        pSSysCounterBase.resetCodeName();
        pSSysCounterBase.resetCounterData();
        pSSysCounterBase.resetCounterData2();
        pSSysCounterBase.resetCounterParams();
        pSSysCounterBase.resetCounterType();
        pSSysCounterBase.resetCreateDate();
        pSSysCounterBase.resetCreateMan();
        pSSysCounterBase.resetCustomCond();
        pSSysCounterBase.resetCustomType();
        pSSysCounterBase.resetLockFlag();
        pSSysCounterBase.resetMemo();
        pSSysCounterBase.resetPSCounterId();
        pSSysCounterBase.resetPSCounterName();
        pSSysCounterBase.resetPSDEActionId();
        pSSysCounterBase.resetPSDEActionName();
        pSSysCounterBase.resetPSDEDataSetId();
        pSSysCounterBase.resetPSDEDataSetName();
        pSSysCounterBase.resetPSDEId();
        pSSysCounterBase.resetPSDEName();
        pSSysCounterBase.resetPSModuleId();
        pSSysCounterBase.resetPSModuleName();
        pSSysCounterBase.resetPSSysCounterId();
        pSSysCounterBase.resetPSSysCounterName();
        pSSysCounterBase.resetPSSysDynaModelId();
        pSSysCounterBase.resetPSSysDynaModelName();
        pSSysCounterBase.resetPSSysPFPluginId();
        pSSysCounterBase.resetPSSysPFPluginName();
        pSSysCounterBase.resetPSSysSFPluginId();
        pSSysCounterBase.resetPSSysSFPluginName();
        pSSysCounterBase.resetPSSystemId();
        pSSysCounterBase.resetPSSystemName();
        pSSysCounterBase.resetReloadTimer();
        pSSysCounterBase.resetToDoTask();
        pSSysCounterBase.resetUpdateDate();
        pSSysCounterBase.resetUpdateMan();
        pSSysCounterBase.resetUserCat();
        pSSysCounterBase.resetUserTag();
        pSSysCounterBase.resetUserTag2();
        pSSysCounterBase.resetUserTag3();
        pSSysCounterBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBaseClsParamsDirty()) {
            hashMap.put(FIELD_BASECLSPARAMS, this.getBaseClsParams());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCounterDataDirty()) {
            hashMap.put(FIELD_COUNTERDATA, this.getCounterData());
        }
        if (!bl || this.isCounterData2Dirty()) {
            hashMap.put(FIELD_COUNTERDATA2, this.getCounterData2());
        }
        if (!bl || this.isCounterParamsDirty()) {
            hashMap.put(FIELD_COUNTERPARAMS, this.getCounterParams());
        }
        if (!bl || this.isCounterTypeDirty()) {
            hashMap.put(FIELD_COUNTERTYPE, this.getCounterType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCondDirty()) {
            hashMap.put(FIELD_CUSTOMCOND, this.getCustomCond());
        }
        if (!bl || this.isCustomTypeDirty()) {
            hashMap.put(FIELD_CUSTOMTYPE, this.getCustomType());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCounterIdDirty()) {
            hashMap.put(FIELD_PSCOUNTERID, this.getPSCounterId());
        }
        if (!bl || this.isPSCounterNameDirty()) {
            hashMap.put(FIELD_PSCOUNTERNAME, this.getPSCounterName());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysCounterIdDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERID, this.getPSSysCounterId());
        }
        if (!bl || this.isPSSysCounterNameDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERNAME, this.getPSSysCounterName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isReloadTimerDirty()) {
            hashMap.put(FIELD_RELOADTIMER, this.getReloadTimer());
        }
        if (!bl || this.isToDoTaskDirty()) {
            hashMap.put(FIELD_TODOTASK, this.getToDoTask());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
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
        return PSSysCounterBase.get(this, n);
    }

    private static Object get(PSSysCounterBase pSSysCounterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCounterBase.getBaseClsParams();
            }
            case 1: {
                return pSSysCounterBase.getCodeName();
            }
            case 2: {
                return pSSysCounterBase.getCounterData();
            }
            case 3: {
                return pSSysCounterBase.getCounterData2();
            }
            case 4: {
                return pSSysCounterBase.getCounterParams();
            }
            case 5: {
                return pSSysCounterBase.getCounterType();
            }
            case 6: {
                return pSSysCounterBase.getCreateDate();
            }
            case 7: {
                return pSSysCounterBase.getCreateMan();
            }
            case 8: {
                return pSSysCounterBase.getCustomCond();
            }
            case 9: {
                return pSSysCounterBase.getCustomType();
            }
            case 10: {
                return pSSysCounterBase.getLockFlag();
            }
            case 11: {
                return pSSysCounterBase.getMemo();
            }
            case 12: {
                return pSSysCounterBase.getPSCounterId();
            }
            case 13: {
                return pSSysCounterBase.getPSCounterName();
            }
            case 14: {
                return pSSysCounterBase.getPSDEActionId();
            }
            case 15: {
                return pSSysCounterBase.getPSDEActionName();
            }
            case 16: {
                return pSSysCounterBase.getPSDEDataSetId();
            }
            case 17: {
                return pSSysCounterBase.getPSDEDataSetName();
            }
            case 18: {
                return pSSysCounterBase.getPSDEId();
            }
            case 19: {
                return pSSysCounterBase.getPSDEName();
            }
            case 20: {
                return pSSysCounterBase.getPSModuleId();
            }
            case 21: {
                return pSSysCounterBase.getPSModuleName();
            }
            case 22: {
                return pSSysCounterBase.getPSSysCounterId();
            }
            case 23: {
                return pSSysCounterBase.getPSSysCounterName();
            }
            case 24: {
                return pSSysCounterBase.getPSSysDynaModelId();
            }
            case 25: {
                return pSSysCounterBase.getPSSysDynaModelName();
            }
            case 26: {
                return pSSysCounterBase.getPSSysPFPluginId();
            }
            case 27: {
                return pSSysCounterBase.getPSSysPFPluginName();
            }
            case 28: {
                return pSSysCounterBase.getPSSysSFPluginId();
            }
            case 29: {
                return pSSysCounterBase.getPSSysSFPluginName();
            }
            case 30: {
                return pSSysCounterBase.getPSSystemId();
            }
            case 31: {
                return pSSysCounterBase.getPSSystemName();
            }
            case 32: {
                return pSSysCounterBase.getReloadTimer();
            }
            case 33: {
                return pSSysCounterBase.getToDoTask();
            }
            case 34: {
                return pSSysCounterBase.getUpdateDate();
            }
            case 35: {
                return pSSysCounterBase.getUpdateMan();
            }
            case 36: {
                return pSSysCounterBase.getUserCat();
            }
            case 37: {
                return pSSysCounterBase.getUserTag();
            }
            case 38: {
                return pSSysCounterBase.getUserTag2();
            }
            case 39: {
                return pSSysCounterBase.getUserTag3();
            }
            case 40: {
                return pSSysCounterBase.getUserTag4();
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
        PSSysCounterBase.set(this, n, object);
    }

    private static void set(PSSysCounterBase pSSysCounterBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysCounterBase.setBaseClsParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysCounterBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysCounterBase.setCounterData(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysCounterBase.setCounterData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysCounterBase.setCounterParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysCounterBase.setCounterType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysCounterBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSysCounterBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysCounterBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysCounterBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysCounterBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysCounterBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysCounterBase.setPSCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysCounterBase.setPSCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysCounterBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysCounterBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysCounterBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysCounterBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysCounterBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysCounterBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysCounterBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysCounterBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysCounterBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysCounterBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysCounterBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysCounterBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysCounterBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysCounterBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysCounterBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysCounterBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysCounterBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysCounterBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysCounterBase.setReloadTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSSysCounterBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysCounterBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 35: {
                pSSysCounterBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysCounterBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysCounterBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysCounterBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysCounterBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysCounterBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysCounterBase.isNull(this, n);
    }

    private static boolean isNull(PSSysCounterBase pSSysCounterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCounterBase.getBaseClsParams() == null;
            }
            case 1: {
                return pSSysCounterBase.getCodeName() == null;
            }
            case 2: {
                return pSSysCounterBase.getCounterData() == null;
            }
            case 3: {
                return pSSysCounterBase.getCounterData2() == null;
            }
            case 4: {
                return pSSysCounterBase.getCounterParams() == null;
            }
            case 5: {
                return pSSysCounterBase.getCounterType() == null;
            }
            case 6: {
                return pSSysCounterBase.getCreateDate() == null;
            }
            case 7: {
                return pSSysCounterBase.getCreateMan() == null;
            }
            case 8: {
                return pSSysCounterBase.getCustomCond() == null;
            }
            case 9: {
                return pSSysCounterBase.getCustomType() == null;
            }
            case 10: {
                return pSSysCounterBase.getLockFlag() == null;
            }
            case 11: {
                return pSSysCounterBase.getMemo() == null;
            }
            case 12: {
                return pSSysCounterBase.getPSCounterId() == null;
            }
            case 13: {
                return pSSysCounterBase.getPSCounterName() == null;
            }
            case 14: {
                return pSSysCounterBase.getPSDEActionId() == null;
            }
            case 15: {
                return pSSysCounterBase.getPSDEActionName() == null;
            }
            case 16: {
                return pSSysCounterBase.getPSDEDataSetId() == null;
            }
            case 17: {
                return pSSysCounterBase.getPSDEDataSetName() == null;
            }
            case 18: {
                return pSSysCounterBase.getPSDEId() == null;
            }
            case 19: {
                return pSSysCounterBase.getPSDEName() == null;
            }
            case 20: {
                return pSSysCounterBase.getPSModuleId() == null;
            }
            case 21: {
                return pSSysCounterBase.getPSModuleName() == null;
            }
            case 22: {
                return pSSysCounterBase.getPSSysCounterId() == null;
            }
            case 23: {
                return pSSysCounterBase.getPSSysCounterName() == null;
            }
            case 24: {
                return pSSysCounterBase.getPSSysDynaModelId() == null;
            }
            case 25: {
                return pSSysCounterBase.getPSSysDynaModelName() == null;
            }
            case 26: {
                return pSSysCounterBase.getPSSysPFPluginId() == null;
            }
            case 27: {
                return pSSysCounterBase.getPSSysPFPluginName() == null;
            }
            case 28: {
                return pSSysCounterBase.getPSSysSFPluginId() == null;
            }
            case 29: {
                return pSSysCounterBase.getPSSysSFPluginName() == null;
            }
            case 30: {
                return pSSysCounterBase.getPSSystemId() == null;
            }
            case 31: {
                return pSSysCounterBase.getPSSystemName() == null;
            }
            case 32: {
                return pSSysCounterBase.getReloadTimer() == null;
            }
            case 33: {
                return pSSysCounterBase.getToDoTask() == null;
            }
            case 34: {
                return pSSysCounterBase.getUpdateDate() == null;
            }
            case 35: {
                return pSSysCounterBase.getUpdateMan() == null;
            }
            case 36: {
                return pSSysCounterBase.getUserCat() == null;
            }
            case 37: {
                return pSSysCounterBase.getUserTag() == null;
            }
            case 38: {
                return pSSysCounterBase.getUserTag2() == null;
            }
            case 39: {
                return pSSysCounterBase.getUserTag3() == null;
            }
            case 40: {
                return pSSysCounterBase.getUserTag4() == null;
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
        return PSSysCounterBase.contains(this, n);
    }

    private static boolean contains(PSSysCounterBase pSSysCounterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCounterBase.isBaseClsParamsDirty();
            }
            case 1: {
                return pSSysCounterBase.isCodeNameDirty();
            }
            case 2: {
                return pSSysCounterBase.isCounterDataDirty();
            }
            case 3: {
                return pSSysCounterBase.isCounterData2Dirty();
            }
            case 4: {
                return pSSysCounterBase.isCounterParamsDirty();
            }
            case 5: {
                return pSSysCounterBase.isCounterTypeDirty();
            }
            case 6: {
                return pSSysCounterBase.isCreateDateDirty();
            }
            case 7: {
                return pSSysCounterBase.isCreateManDirty();
            }
            case 8: {
                return pSSysCounterBase.isCustomCondDirty();
            }
            case 9: {
                return pSSysCounterBase.isCustomTypeDirty();
            }
            case 10: {
                return pSSysCounterBase.isLockFlagDirty();
            }
            case 11: {
                return pSSysCounterBase.isMemoDirty();
            }
            case 12: {
                return pSSysCounterBase.isPSCounterIdDirty();
            }
            case 13: {
                return pSSysCounterBase.isPSCounterNameDirty();
            }
            case 14: {
                return pSSysCounterBase.isPSDEActionIdDirty();
            }
            case 15: {
                return pSSysCounterBase.isPSDEActionNameDirty();
            }
            case 16: {
                return pSSysCounterBase.isPSDEDataSetIdDirty();
            }
            case 17: {
                return pSSysCounterBase.isPSDEDataSetNameDirty();
            }
            case 18: {
                return pSSysCounterBase.isPSDEIdDirty();
            }
            case 19: {
                return pSSysCounterBase.isPSDENameDirty();
            }
            case 20: {
                return pSSysCounterBase.isPSModuleIdDirty();
            }
            case 21: {
                return pSSysCounterBase.isPSModuleNameDirty();
            }
            case 22: {
                return pSSysCounterBase.isPSSysCounterIdDirty();
            }
            case 23: {
                return pSSysCounterBase.isPSSysCounterNameDirty();
            }
            case 24: {
                return pSSysCounterBase.isPSSysDynaModelIdDirty();
            }
            case 25: {
                return pSSysCounterBase.isPSSysDynaModelNameDirty();
            }
            case 26: {
                return pSSysCounterBase.isPSSysPFPluginIdDirty();
            }
            case 27: {
                return pSSysCounterBase.isPSSysPFPluginNameDirty();
            }
            case 28: {
                return pSSysCounterBase.isPSSysSFPluginIdDirty();
            }
            case 29: {
                return pSSysCounterBase.isPSSysSFPluginNameDirty();
            }
            case 30: {
                return pSSysCounterBase.isPSSystemIdDirty();
            }
            case 31: {
                return pSSysCounterBase.isPSSystemNameDirty();
            }
            case 32: {
                return pSSysCounterBase.isReloadTimerDirty();
            }
            case 33: {
                return pSSysCounterBase.isToDoTaskDirty();
            }
            case 34: {
                return pSSysCounterBase.isUpdateDateDirty();
            }
            case 35: {
                return pSSysCounterBase.isUpdateManDirty();
            }
            case 36: {
                return pSSysCounterBase.isUserCatDirty();
            }
            case 37: {
                return pSSysCounterBase.isUserTagDirty();
            }
            case 38: {
                return pSSysCounterBase.isUserTag2Dirty();
            }
            case 39: {
                return pSSysCounterBase.isUserTag3Dirty();
            }
            case 40: {
                return pSSysCounterBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysCounterBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysCounterBase pSSysCounterBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysCounterBase.getBaseClsParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclsparams", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getBaseClsParams()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getCounterData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"counterdata", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getCounterData()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getCounterData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"counterdata2", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getCounterData2()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getCounterParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"counterparams", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getCounterParams()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getCounterType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"countertype", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getCounterType()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getCustomType()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscounterid", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSCounterId()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscountername", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSCounterName()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getReloadTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reloadtimer", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getReloadTimer()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysCounterBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysCounterBase.getJSONValue((Object)pSSysCounterBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysCounterBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysCounterBase pSSysCounterBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysCounterBase.getBaseClsParams() != null) {
            object = pSSysCounterBase.getBaseClsParams();
            xmlNode.setAttribute(FIELD_BASECLSPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCounterBase.getCodeName() != null) {
            object = pSSysCounterBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCounterBase.getCounterData() != null) {
            object = pSSysCounterBase.getCounterData();
            xmlNode.setAttribute(FIELD_COUNTERDATA, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCounterBase.getCounterData2() != null) {
            object = pSSysCounterBase.getCounterData2();
            xmlNode.setAttribute(FIELD_COUNTERDATA2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCounterBase.getCounterParams() != null) {
            object = pSSysCounterBase.getCounterParams();
            xmlNode.setAttribute(FIELD_COUNTERPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCounterBase.getCounterType() != null) {
            object = pSSysCounterBase.getCounterType();
            xmlNode.setAttribute(FIELD_COUNTERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getCreateDate() != null) {
            object = pSSysCounterBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCounterBase.getCreateMan() != null) {
            object = pSSysCounterBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getCustomCond() != null) {
            object = pSSysCounterBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getCustomType() != null) {
            object = pSSysCounterBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getLockFlag() != null) {
            object = pSSysCounterBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCounterBase.getMemo() != null) {
            object = pSSysCounterBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSCounterId() != null) {
            object = pSSysCounterBase.getPSCounterId();
            xmlNode.setAttribute(FIELD_PSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSCounterName() != null) {
            object = pSSysCounterBase.getPSCounterName();
            xmlNode.setAttribute(FIELD_PSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSDEActionId() != null) {
            object = pSSysCounterBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSDEActionName() != null) {
            object = pSSysCounterBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSDEDataSetId() != null) {
            object = pSSysCounterBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSDEDataSetName() != null) {
            object = pSSysCounterBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSDEId() != null) {
            object = pSSysCounterBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSDEName() != null) {
            object = pSSysCounterBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSModuleId() != null) {
            object = pSSysCounterBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSModuleName() != null) {
            object = pSSysCounterBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSSysCounterId() != null) {
            object = pSSysCounterBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSSysCounterName() != null) {
            object = pSSysCounterBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSSysDynaModelId() != null) {
            object = pSSysCounterBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSSysDynaModelName() != null) {
            object = pSSysCounterBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSSysPFPluginId() != null) {
            object = pSSysCounterBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSSysPFPluginName() != null) {
            object = pSSysCounterBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSSysSFPluginId() != null) {
            object = pSSysCounterBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSSysSFPluginName() != null) {
            object = pSSysCounterBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSSystemId() != null) {
            object = pSSysCounterBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getPSSystemName() != null) {
            object = pSSysCounterBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getReloadTimer() != null) {
            object = pSSysCounterBase.getReloadTimer();
            xmlNode.setAttribute(FIELD_RELOADTIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCounterBase.getToDoTask() != null) {
            object = pSSysCounterBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getUpdateDate() != null) {
            object = pSSysCounterBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCounterBase.getUpdateMan() != null) {
            object = pSSysCounterBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getUserCat() != null) {
            object = pSSysCounterBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getUserTag() != null) {
            object = pSSysCounterBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getUserTag2() != null) {
            object = pSSysCounterBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getUserTag3() != null) {
            object = pSSysCounterBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterBase.getUserTag4() != null) {
            object = pSSysCounterBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysCounterBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysCounterBase pSSysCounterBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysCounterBase.isBaseClsParamsDirty() && (bl || pSSysCounterBase.getBaseClsParams() != null)) {
            iDataObject.set(FIELD_BASECLSPARAMS, (Object)pSSysCounterBase.getBaseClsParams());
        }
        if (pSSysCounterBase.isCodeNameDirty() && (bl || pSSysCounterBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysCounterBase.getCodeName());
        }
        if (pSSysCounterBase.isCounterDataDirty() && (bl || pSSysCounterBase.getCounterData() != null)) {
            iDataObject.set(FIELD_COUNTERDATA, (Object)pSSysCounterBase.getCounterData());
        }
        if (pSSysCounterBase.isCounterData2Dirty() && (bl || pSSysCounterBase.getCounterData2() != null)) {
            iDataObject.set(FIELD_COUNTERDATA2, (Object)pSSysCounterBase.getCounterData2());
        }
        if (pSSysCounterBase.isCounterParamsDirty() && (bl || pSSysCounterBase.getCounterParams() != null)) {
            iDataObject.set(FIELD_COUNTERPARAMS, (Object)pSSysCounterBase.getCounterParams());
        }
        if (pSSysCounterBase.isCounterTypeDirty() && (bl || pSSysCounterBase.getCounterType() != null)) {
            iDataObject.set(FIELD_COUNTERTYPE, (Object)pSSysCounterBase.getCounterType());
        }
        if (pSSysCounterBase.isCreateDateDirty() && (bl || pSSysCounterBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysCounterBase.getCreateDate());
        }
        if (pSSysCounterBase.isCreateManDirty() && (bl || pSSysCounterBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysCounterBase.getCreateMan());
        }
        if (pSSysCounterBase.isCustomCondDirty() && (bl || pSSysCounterBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSSysCounterBase.getCustomCond());
        }
        if (pSSysCounterBase.isCustomTypeDirty() && (bl || pSSysCounterBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSSysCounterBase.getCustomType());
        }
        if (pSSysCounterBase.isLockFlagDirty() && (bl || pSSysCounterBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysCounterBase.getLockFlag());
        }
        if (pSSysCounterBase.isMemoDirty() && (bl || pSSysCounterBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysCounterBase.getMemo());
        }
        if (pSSysCounterBase.isPSCounterIdDirty() && (bl || pSSysCounterBase.getPSCounterId() != null)) {
            iDataObject.set(FIELD_PSCOUNTERID, (Object)pSSysCounterBase.getPSCounterId());
        }
        if (pSSysCounterBase.isPSCounterNameDirty() && (bl || pSSysCounterBase.getPSCounterName() != null)) {
            iDataObject.set(FIELD_PSCOUNTERNAME, (Object)pSSysCounterBase.getPSCounterName());
        }
        if (pSSysCounterBase.isPSDEActionIdDirty() && (bl || pSSysCounterBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSSysCounterBase.getPSDEActionId());
        }
        if (pSSysCounterBase.isPSDEActionNameDirty() && (bl || pSSysCounterBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSSysCounterBase.getPSDEActionName());
        }
        if (pSSysCounterBase.isPSDEDataSetIdDirty() && (bl || pSSysCounterBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSSysCounterBase.getPSDEDataSetId());
        }
        if (pSSysCounterBase.isPSDEDataSetNameDirty() && (bl || pSSysCounterBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSSysCounterBase.getPSDEDataSetName());
        }
        if (pSSysCounterBase.isPSDEIdDirty() && (bl || pSSysCounterBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysCounterBase.getPSDEId());
        }
        if (pSSysCounterBase.isPSDENameDirty() && (bl || pSSysCounterBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysCounterBase.getPSDEName());
        }
        if (pSSysCounterBase.isPSModuleIdDirty() && (bl || pSSysCounterBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysCounterBase.getPSModuleId());
        }
        if (pSSysCounterBase.isPSModuleNameDirty() && (bl || pSSysCounterBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysCounterBase.getPSModuleName());
        }
        if (pSSysCounterBase.isPSSysCounterIdDirty() && (bl || pSSysCounterBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSSysCounterBase.getPSSysCounterId());
        }
        if (pSSysCounterBase.isPSSysCounterNameDirty() && (bl || pSSysCounterBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSSysCounterBase.getPSSysCounterName());
        }
        if (pSSysCounterBase.isPSSysDynaModelIdDirty() && (bl || pSSysCounterBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysCounterBase.getPSSysDynaModelId());
        }
        if (pSSysCounterBase.isPSSysDynaModelNameDirty() && (bl || pSSysCounterBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysCounterBase.getPSSysDynaModelName());
        }
        if (pSSysCounterBase.isPSSysPFPluginIdDirty() && (bl || pSSysCounterBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysCounterBase.getPSSysPFPluginId());
        }
        if (pSSysCounterBase.isPSSysPFPluginNameDirty() && (bl || pSSysCounterBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysCounterBase.getPSSysPFPluginName());
        }
        if (pSSysCounterBase.isPSSysSFPluginIdDirty() && (bl || pSSysCounterBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysCounterBase.getPSSysSFPluginId());
        }
        if (pSSysCounterBase.isPSSysSFPluginNameDirty() && (bl || pSSysCounterBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysCounterBase.getPSSysSFPluginName());
        }
        if (pSSysCounterBase.isPSSystemIdDirty() && (bl || pSSysCounterBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysCounterBase.getPSSystemId());
        }
        if (pSSysCounterBase.isPSSystemNameDirty() && (bl || pSSysCounterBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysCounterBase.getPSSystemName());
        }
        if (pSSysCounterBase.isReloadTimerDirty() && (bl || pSSysCounterBase.getReloadTimer() != null)) {
            iDataObject.set(FIELD_RELOADTIMER, (Object)pSSysCounterBase.getReloadTimer());
        }
        if (pSSysCounterBase.isToDoTaskDirty() && (bl || pSSysCounterBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSSysCounterBase.getToDoTask());
        }
        if (pSSysCounterBase.isUpdateDateDirty() && (bl || pSSysCounterBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysCounterBase.getUpdateDate());
        }
        if (pSSysCounterBase.isUpdateManDirty() && (bl || pSSysCounterBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysCounterBase.getUpdateMan());
        }
        if (pSSysCounterBase.isUserCatDirty() && (bl || pSSysCounterBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysCounterBase.getUserCat());
        }
        if (pSSysCounterBase.isUserTagDirty() && (bl || pSSysCounterBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysCounterBase.getUserTag());
        }
        if (pSSysCounterBase.isUserTag2Dirty() && (bl || pSSysCounterBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysCounterBase.getUserTag2());
        }
        if (pSSysCounterBase.isUserTag3Dirty() && (bl || pSSysCounterBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysCounterBase.getUserTag3());
        }
        if (pSSysCounterBase.isUserTag4Dirty() && (bl || pSSysCounterBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysCounterBase.getUserTag4());
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
        return PSSysCounterBase.remove(this, n);
    }

    private static boolean remove(PSSysCounterBase pSSysCounterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysCounterBase.resetBaseClsParams();
                return true;
            }
            case 1: {
                pSSysCounterBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSysCounterBase.resetCounterData();
                return true;
            }
            case 3: {
                pSSysCounterBase.resetCounterData2();
                return true;
            }
            case 4: {
                pSSysCounterBase.resetCounterParams();
                return true;
            }
            case 5: {
                pSSysCounterBase.resetCounterType();
                return true;
            }
            case 6: {
                pSSysCounterBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSSysCounterBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSSysCounterBase.resetCustomCond();
                return true;
            }
            case 9: {
                pSSysCounterBase.resetCustomType();
                return true;
            }
            case 10: {
                pSSysCounterBase.resetLockFlag();
                return true;
            }
            case 11: {
                pSSysCounterBase.resetMemo();
                return true;
            }
            case 12: {
                pSSysCounterBase.resetPSCounterId();
                return true;
            }
            case 13: {
                pSSysCounterBase.resetPSCounterName();
                return true;
            }
            case 14: {
                pSSysCounterBase.resetPSDEActionId();
                return true;
            }
            case 15: {
                pSSysCounterBase.resetPSDEActionName();
                return true;
            }
            case 16: {
                pSSysCounterBase.resetPSDEDataSetId();
                return true;
            }
            case 17: {
                pSSysCounterBase.resetPSDEDataSetName();
                return true;
            }
            case 18: {
                pSSysCounterBase.resetPSDEId();
                return true;
            }
            case 19: {
                pSSysCounterBase.resetPSDEName();
                return true;
            }
            case 20: {
                pSSysCounterBase.resetPSModuleId();
                return true;
            }
            case 21: {
                pSSysCounterBase.resetPSModuleName();
                return true;
            }
            case 22: {
                pSSysCounterBase.resetPSSysCounterId();
                return true;
            }
            case 23: {
                pSSysCounterBase.resetPSSysCounterName();
                return true;
            }
            case 24: {
                pSSysCounterBase.resetPSSysDynaModelId();
                return true;
            }
            case 25: {
                pSSysCounterBase.resetPSSysDynaModelName();
                return true;
            }
            case 26: {
                pSSysCounterBase.resetPSSysPFPluginId();
                return true;
            }
            case 27: {
                pSSysCounterBase.resetPSSysPFPluginName();
                return true;
            }
            case 28: {
                pSSysCounterBase.resetPSSysSFPluginId();
                return true;
            }
            case 29: {
                pSSysCounterBase.resetPSSysSFPluginName();
                return true;
            }
            case 30: {
                pSSysCounterBase.resetPSSystemId();
                return true;
            }
            case 31: {
                pSSysCounterBase.resetPSSystemName();
                return true;
            }
            case 32: {
                pSSysCounterBase.resetReloadTimer();
                return true;
            }
            case 33: {
                pSSysCounterBase.resetToDoTask();
                return true;
            }
            case 34: {
                pSSysCounterBase.resetUpdateDate();
                return true;
            }
            case 35: {
                pSSysCounterBase.resetUpdateMan();
                return true;
            }
            case 36: {
                pSSysCounterBase.resetUserCat();
                return true;
            }
            case 37: {
                pSSysCounterBase.resetUserTag();
                return true;
            }
            case 38: {
                pSSysCounterBase.resetUserTag2();
                return true;
            }
            case 39: {
                pSSysCounterBase.resetUserTag3();
                return true;
            }
            case 40: {
                pSSysCounterBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCounter getPSCounter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCounter();
        }
        if (this.getPSCounterId() == null) {
            return null;
        }
        Integer n = this.objPSCounterLock;
        synchronized (n) {
            if (this.pscounter != null && DataTypeHelper.compare((int)25, (Object)this.getPSCounterId(), (Object)this.pscounter.getPSCounterId()) != 0L) {
                this.pscounter = null;
            }
            if (this.pscounter == null) {
                PSCounter pSCounter = new PSCounter();
                pSCounter.setPSCounterId(this.getPSCounterId());
                PSCounterService pSCounterService = (PSCounterService)ServiceGlobal.getService(PSCounterService.class, (SessionFactory)this.getSessionFactory());
                pSCounterService.autoGet((IEntity)pSCounter);
                this.pscounter = pSCounter;
            }
            return this.pscounter;
        }
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAction();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSet();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSetLock;
        synchronized (n) {
            if (this.psdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSetId(), (Object)this.psdedataset.getPSDEDataSetId()) != 0L) {
                this.psdedataset = null;
            }
            if (this.psdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
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
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
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
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysCounterItem> getPSSysCounterItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterItems();
        }
        if (this.getPSSysCounterId() == null) {
            return null;
        }
        PSSysCounterItemService pSSysCounterItemService = (PSSysCounterItemService)ServiceGlobal.getService(PSSysCounterItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysCounterItemsLock;
        synchronized (n) {
            if (this.pssyscounteritems == null) {
                this.pssyscounteritems = pSSysCounterItemService.selectByPSSysCounter(this);
            }
            return this.pssyscounteritems;
        }
    }

    private PSSysCounterBase getProxyEntity() {
        return this.proxyPSSysCounterBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysCounterBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysCounterBase) {
            this.proxyPSSysCounterBase = (PSSysCounterBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BASECLSPARAMS, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_COUNTERDATA, 2);
        fieldIndexMap.put(FIELD_COUNTERDATA2, 3);
        fieldIndexMap.put(FIELD_COUNTERPARAMS, 4);
        fieldIndexMap.put(FIELD_COUNTERTYPE, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 8);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 9);
        fieldIndexMap.put(FIELD_LOCKFLAG, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_PSCOUNTERID, 12);
        fieldIndexMap.put(FIELD_PSCOUNTERNAME, 13);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 14);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 15);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 16);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 17);
        fieldIndexMap.put(FIELD_PSDEID, 18);
        fieldIndexMap.put(FIELD_PSDENAME, 19);
        fieldIndexMap.put(FIELD_PSMODULEID, 20);
        fieldIndexMap.put(FIELD_PSMODULENAME, 21);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 22);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 24);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 25);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 26);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 27);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 28);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 29);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 30);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 31);
        fieldIndexMap.put(FIELD_RELOADTIMER, 32);
        fieldIndexMap.put(FIELD_TODOTASK, 33);
        fieldIndexMap.put(FIELD_UPDATEDATE, 34);
        fieldIndexMap.put(FIELD_UPDATEMAN, 35);
        fieldIndexMap.put(FIELD_USERCAT, 36);
        fieldIndexMap.put(FIELD_USERTAG, 37);
        fieldIndexMap.put(FIELD_USERTAG2, 38);
        fieldIndexMap.put(FIELD_USERTAG3, 39);
        fieldIndexMap.put(FIELD_USERTAG4, 40);
    }
}

