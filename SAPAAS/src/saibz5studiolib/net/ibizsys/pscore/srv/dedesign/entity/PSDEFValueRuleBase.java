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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFVRCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFValueRuleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFValueRuleBase.class);
    public static final String FIELD_CHECKDEFAULT = "CHECKDEFAULT";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DEFAULTMODE = "DEFAULTMODE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEFVALUERULEID = "PSDEFVALUERULEID";
    public static final String FIELD_PSDEFVALUERULENAME = "PSDEFVALUERULENAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_RIPSLANRESID = "RIPSLANRESID";
    public static final String FIELD_RIPSLANRESNAME = "RIPSLANRESNAME";
    public static final String FIELD_RULEHOLDER = "RULEHOLDER";
    public static final String FIELD_RULEINFO = "RULEINFO";
    public static final String FIELD_RULETAG = "RULETAG";
    public static final String FIELD_RULETAG2 = "RULETAG2";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VRMODE = "VRMODE";
    public static final String FIELD_VRMODEL = "VRMODEL";
    public static final String FIELD_VRTYPE = "VRTYPE";
    private static final int INDEX_CHECKDEFAULT = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_CUSTOMCODE = 4;
    private static final int INDEX_CUSTOMMODE = 5;
    private static final int INDEX_DEFAULTMODE = 6;
    private static final int INDEX_LOCKFLAG = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_ORDERVALUE = 9;
    private static final int INDEX_PSDEFID = 10;
    private static final int INDEX_PSDEFNAME = 11;
    private static final int INDEX_PSDEFORMID = 12;
    private static final int INDEX_PSDEFORMNAME = 13;
    private static final int INDEX_PSDEFVALUERULEID = 14;
    private static final int INDEX_PSDEFVALUERULENAME = 15;
    private static final int INDEX_PSDEID = 16;
    private static final int INDEX_PSDENAME = 17;
    private static final int INDEX_PSSYSDYNAMODELID = 18;
    private static final int INDEX_PSSYSDYNAMODELNAME = 19;
    private static final int INDEX_PSSYSPFPLUGINID = 20;
    private static final int INDEX_PSSYSPFPLUGINNAME = 21;
    private static final int INDEX_PSSYSREQITEMID = 22;
    private static final int INDEX_PSSYSREQITEMNAME = 23;
    private static final int INDEX_PSSYSSFPLUGINID = 24;
    private static final int INDEX_PSSYSSFPLUGINNAME = 25;
    private static final int INDEX_RIPSLANRESID = 26;
    private static final int INDEX_RIPSLANRESNAME = 27;
    private static final int INDEX_RULEHOLDER = 28;
    private static final int INDEX_RULEINFO = 29;
    private static final int INDEX_RULETAG = 30;
    private static final int INDEX_RULETAG2 = 31;
    private static final int INDEX_TODOTASK = 32;
    private static final int INDEX_UPDATEDATE = 33;
    private static final int INDEX_UPDATEMAN = 34;
    private static final int INDEX_USERCAT = 35;
    private static final int INDEX_USERTAG = 36;
    private static final int INDEX_USERTAG2 = 37;
    private static final int INDEX_USERTAG3 = 38;
    private static final int INDEX_USERTAG4 = 39;
    private static final int INDEX_VRMODE = 40;
    private static final int INDEX_VRMODEL = 41;
    private static final int INDEX_VRTYPE = 42;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFValueRuleBase proxyPSDEFValueRuleBase = null;
    private boolean checkdefaultDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean defaultmodeDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdefvalueruleidDirtyFlag = false;
    private boolean psdefvaluerulenameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean ripslanresidDirtyFlag = false;
    private boolean ripslanresnameDirtyFlag = false;
    private boolean ruleholderDirtyFlag = false;
    private boolean ruleinfoDirtyFlag = false;
    private boolean ruletagDirtyFlag = false;
    private boolean ruletag2DirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean vrmodeDirtyFlag = false;
    private boolean vrmodelDirtyFlag = false;
    private boolean vrtypeDirtyFlag = false;
    @Column(name="checkdefault")
    private Integer checkdefault;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="defaultmode")
    private Integer defaultmode;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdefvalueruleid")
    private String psdefvalueruleid;
    @Column(name="psdefvaluerulename")
    private String psdefvaluerulename;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="ripslanresid")
    private String ripslanresid;
    @Column(name="ripslanresname")
    private String ripslanresname;
    @Column(name="ruleholder")
    private Integer ruleholder;
    @Column(name="ruleinfo")
    private String ruleinfo;
    @Column(name="ruletag")
    private String ruletag;
    @Column(name="ruletag2")
    private String ruletag2;
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
    @Column(name="vrmode")
    private String vrmode;
    @Column(name="vrmodel")
    private String vrmodel;
    @Column(name="vrtype")
    private String vrtype;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objRIPSLanResLock = new Integer(1);
    private PSLanguageRes ripslanres = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSDEFVRCondsLock = new Integer(1);
    private ArrayList<PSDEFVRCond> psdefvrconds = null;

    public void setCheckDefault(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCheckDefault(n);
            return;
        }
        this.checkdefault = n;
        this.checkdefaultDirtyFlag = true;
    }

    public Integer getCheckDefault() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCheckDefault();
        }
        return this.checkdefault;
    }

    public boolean isCheckDefaultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCheckDefaultDirty();
        }
        return this.checkdefaultDirtyFlag;
    }

    public void resetCheckDefault() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCheckDefault();
            return;
        }
        this.checkdefaultDirtyFlag = false;
        this.checkdefault = null;
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

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
    }

    public void setDefaultMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultMode(n);
            return;
        }
        this.defaultmode = n;
        this.defaultmodeDirtyFlag = true;
    }

    public Integer getDefaultMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultMode();
        }
        return this.defaultmode;
    }

    public boolean isDefaultModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultModeDirty();
        }
        return this.defaultmodeDirtyFlag;
    }

    public void resetDefaultMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultMode();
            return;
        }
        this.defaultmodeDirtyFlag = false;
        this.defaultmode = null;
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

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
    }

    public void setPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformid = string;
        this.psdeformidDirtyFlag = true;
    }

    public String getPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormId();
        }
        return this.psdeformid;
    }

    public boolean isPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormIdDirty();
        }
        return this.psdeformidDirtyFlag;
    }

    public void resetPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormId();
            return;
        }
        this.psdeformidDirtyFlag = false;
        this.psdeformid = null;
    }

    public void setPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformname = string;
        this.psdeformnameDirtyFlag = true;
    }

    public String getPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormName();
        }
        return this.psdeformname;
    }

    public boolean isPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormNameDirty();
        }
        return this.psdeformnameDirtyFlag;
    }

    public void resetPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormName();
            return;
        }
        this.psdeformnameDirtyFlag = false;
        this.psdeformname = null;
    }

    public void setPSDEFValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvalueruleid = string;
        this.psdefvalueruleidDirtyFlag = true;
    }

    public String getPSDEFValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRuleId();
        }
        return this.psdefvalueruleid;
    }

    public boolean isPSDEFValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFValueRuleIdDirty();
        }
        return this.psdefvalueruleidDirtyFlag;
    }

    public void resetPSDEFValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFValueRuleId();
            return;
        }
        this.psdefvalueruleidDirtyFlag = false;
        this.psdefvalueruleid = null;
    }

    public void setPSDEFValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvaluerulename = string;
        this.psdefvaluerulenameDirtyFlag = true;
    }

    public String getPSDEFValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFValueRuleName();
        }
        return this.psdefvaluerulename;
    }

    public boolean isPSDEFValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFValueRuleNameDirty();
        }
        return this.psdefvaluerulenameDirtyFlag;
    }

    public void resetPSDEFValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFValueRuleName();
            return;
        }
        this.psdefvaluerulenameDirtyFlag = false;
        this.psdefvaluerulename = null;
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

    public void setRIPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRIPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ripslanresid = string;
        this.ripslanresidDirtyFlag = true;
    }

    public String getRIPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRIPSLanResId();
        }
        return this.ripslanresid;
    }

    public boolean isRIPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRIPSLanResIdDirty();
        }
        return this.ripslanresidDirtyFlag;
    }

    public void resetRIPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRIPSLanResId();
            return;
        }
        this.ripslanresidDirtyFlag = false;
        this.ripslanresid = null;
    }

    public void setRIPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRIPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ripslanresname = string;
        this.ripslanresnameDirtyFlag = true;
    }

    public String getRIPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRIPSLanResName();
        }
        return this.ripslanresname;
    }

    public boolean isRIPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRIPSLanResNameDirty();
        }
        return this.ripslanresnameDirtyFlag;
    }

    public void resetRIPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRIPSLanResName();
            return;
        }
        this.ripslanresnameDirtyFlag = false;
        this.ripslanresname = null;
    }

    public void setRuleHolder(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRuleHolder(n);
            return;
        }
        this.ruleholder = n;
        this.ruleholderDirtyFlag = true;
    }

    public Integer getRuleHolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRuleHolder();
        }
        return this.ruleholder;
    }

    public boolean isRuleHolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRuleHolderDirty();
        }
        return this.ruleholderDirtyFlag;
    }

    public void resetRuleHolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRuleHolder();
            return;
        }
        this.ruleholderDirtyFlag = false;
        this.ruleholder = null;
    }

    public void setRuleInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRuleInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ruleinfo = string;
        this.ruleinfoDirtyFlag = true;
    }

    public String getRuleInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRuleInfo();
        }
        return this.ruleinfo;
    }

    public boolean isRuleInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRuleInfoDirty();
        }
        return this.ruleinfoDirtyFlag;
    }

    public void resetRuleInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRuleInfo();
            return;
        }
        this.ruleinfoDirtyFlag = false;
        this.ruleinfo = null;
    }

    public void setRuleTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRuleTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ruletag = string;
        this.ruletagDirtyFlag = true;
    }

    public String getRuleTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRuleTag();
        }
        return this.ruletag;
    }

    public boolean isRuleTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRuleTagDirty();
        }
        return this.ruletagDirtyFlag;
    }

    public void resetRuleTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRuleTag();
            return;
        }
        this.ruletagDirtyFlag = false;
        this.ruletag = null;
    }

    public void setRuleTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRuleTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ruletag2 = string;
        this.ruletag2DirtyFlag = true;
    }

    public String getRuleTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRuleTag2();
        }
        return this.ruletag2;
    }

    public boolean isRuleTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRuleTag2Dirty();
        }
        return this.ruletag2DirtyFlag;
    }

    public void resetRuleTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRuleTag2();
            return;
        }
        this.ruletag2DirtyFlag = false;
        this.ruletag2 = null;
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

    public void setVRMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVRMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vrmode = string;
        this.vrmodeDirtyFlag = true;
    }

    public String getVRMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVRMode();
        }
        return this.vrmode;
    }

    public boolean isVRModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVRModeDirty();
        }
        return this.vrmodeDirtyFlag;
    }

    public void resetVRMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVRMode();
            return;
        }
        this.vrmodeDirtyFlag = false;
        this.vrmode = null;
    }

    public void setVRModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVRModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vrmodel = string;
        this.vrmodelDirtyFlag = true;
    }

    public String getVRModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVRModel();
        }
        return this.vrmodel;
    }

    public boolean isVRModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVRModelDirty();
        }
        return this.vrmodelDirtyFlag;
    }

    public void resetVRModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVRModel();
            return;
        }
        this.vrmodelDirtyFlag = false;
        this.vrmodel = null;
    }

    public void setVRType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVRType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vrtype = string;
        this.vrtypeDirtyFlag = true;
    }

    public String getVRType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVRType();
        }
        return this.vrtype;
    }

    public boolean isVRTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVRTypeDirty();
        }
        return this.vrtypeDirtyFlag;
    }

    public void resetVRType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVRType();
            return;
        }
        this.vrtypeDirtyFlag = false;
        this.vrtype = null;
    }

    protected void onReset() {
        PSDEFValueRuleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFValueRuleBase pSDEFValueRuleBase) {
        pSDEFValueRuleBase.resetCheckDefault();
        pSDEFValueRuleBase.resetCodeName();
        pSDEFValueRuleBase.resetCreateDate();
        pSDEFValueRuleBase.resetCreateMan();
        pSDEFValueRuleBase.resetCustomCode();
        pSDEFValueRuleBase.resetCustomMode();
        pSDEFValueRuleBase.resetDefaultMode();
        pSDEFValueRuleBase.resetLockFlag();
        pSDEFValueRuleBase.resetMemo();
        pSDEFValueRuleBase.resetOrderValue();
        pSDEFValueRuleBase.resetPSDEFId();
        pSDEFValueRuleBase.resetPSDEFName();
        pSDEFValueRuleBase.resetPSDEFormId();
        pSDEFValueRuleBase.resetPSDEFormName();
        pSDEFValueRuleBase.resetPSDEFValueRuleId();
        pSDEFValueRuleBase.resetPSDEFValueRuleName();
        pSDEFValueRuleBase.resetPSDEId();
        pSDEFValueRuleBase.resetPSDEName();
        pSDEFValueRuleBase.resetPSSysDynaModelId();
        pSDEFValueRuleBase.resetPSSysDynaModelName();
        pSDEFValueRuleBase.resetPSSysPFPluginId();
        pSDEFValueRuleBase.resetPSSysPFPluginName();
        pSDEFValueRuleBase.resetPSSysReqItemId();
        pSDEFValueRuleBase.resetPSSysReqItemName();
        pSDEFValueRuleBase.resetPSSysSFPluginId();
        pSDEFValueRuleBase.resetPSSysSFPluginName();
        pSDEFValueRuleBase.resetRIPSLanResId();
        pSDEFValueRuleBase.resetRIPSLanResName();
        pSDEFValueRuleBase.resetRuleHolder();
        pSDEFValueRuleBase.resetRuleInfo();
        pSDEFValueRuleBase.resetRuleTag();
        pSDEFValueRuleBase.resetRuleTag2();
        pSDEFValueRuleBase.resetToDoTask();
        pSDEFValueRuleBase.resetUpdateDate();
        pSDEFValueRuleBase.resetUpdateMan();
        pSDEFValueRuleBase.resetUserCat();
        pSDEFValueRuleBase.resetUserTag();
        pSDEFValueRuleBase.resetUserTag2();
        pSDEFValueRuleBase.resetUserTag3();
        pSDEFValueRuleBase.resetUserTag4();
        pSDEFValueRuleBase.resetVRMode();
        pSDEFValueRuleBase.resetVRModel();
        pSDEFValueRuleBase.resetVRType();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCheckDefaultDirty()) {
            hashMap.put(FIELD_CHECKDEFAULT, this.getCheckDefault());
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
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDefaultModeDirty()) {
            hashMap.put(FIELD_DEFAULTMODE, this.getDefaultMode());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
        }
        if (!bl || this.isPSDEFValueRuleIdDirty()) {
            hashMap.put(FIELD_PSDEFVALUERULEID, this.getPSDEFValueRuleId());
        }
        if (!bl || this.isPSDEFValueRuleNameDirty()) {
            hashMap.put(FIELD_PSDEFVALUERULENAME, this.getPSDEFValueRuleName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
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
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isRIPSLanResIdDirty()) {
            hashMap.put(FIELD_RIPSLANRESID, this.getRIPSLanResId());
        }
        if (!bl || this.isRIPSLanResNameDirty()) {
            hashMap.put(FIELD_RIPSLANRESNAME, this.getRIPSLanResName());
        }
        if (!bl || this.isRuleHolderDirty()) {
            hashMap.put(FIELD_RULEHOLDER, this.getRuleHolder());
        }
        if (!bl || this.isRuleInfoDirty()) {
            hashMap.put(FIELD_RULEINFO, this.getRuleInfo());
        }
        if (!bl || this.isRuleTagDirty()) {
            hashMap.put(FIELD_RULETAG, this.getRuleTag());
        }
        if (!bl || this.isRuleTag2Dirty()) {
            hashMap.put(FIELD_RULETAG2, this.getRuleTag2());
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
        if (!bl || this.isVRModeDirty()) {
            hashMap.put(FIELD_VRMODE, this.getVRMode());
        }
        if (!bl || this.isVRModelDirty()) {
            hashMap.put(FIELD_VRMODEL, this.getVRModel());
        }
        if (!bl || this.isVRTypeDirty()) {
            hashMap.put(FIELD_VRTYPE, this.getVRType());
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
        return PSDEFValueRuleBase.get(this, n);
    }

    private static Object get(PSDEFValueRuleBase pSDEFValueRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFValueRuleBase.getCheckDefault();
            }
            case 1: {
                return pSDEFValueRuleBase.getCodeName();
            }
            case 2: {
                return pSDEFValueRuleBase.getCreateDate();
            }
            case 3: {
                return pSDEFValueRuleBase.getCreateMan();
            }
            case 4: {
                return pSDEFValueRuleBase.getCustomCode();
            }
            case 5: {
                return pSDEFValueRuleBase.getCustomMode();
            }
            case 6: {
                return pSDEFValueRuleBase.getDefaultMode();
            }
            case 7: {
                return pSDEFValueRuleBase.getLockFlag();
            }
            case 8: {
                return pSDEFValueRuleBase.getMemo();
            }
            case 9: {
                return pSDEFValueRuleBase.getOrderValue();
            }
            case 10: {
                return pSDEFValueRuleBase.getPSDEFId();
            }
            case 11: {
                return pSDEFValueRuleBase.getPSDEFName();
            }
            case 12: {
                return pSDEFValueRuleBase.getPSDEFormId();
            }
            case 13: {
                return pSDEFValueRuleBase.getPSDEFormName();
            }
            case 14: {
                return pSDEFValueRuleBase.getPSDEFValueRuleId();
            }
            case 15: {
                return pSDEFValueRuleBase.getPSDEFValueRuleName();
            }
            case 16: {
                return pSDEFValueRuleBase.getPSDEId();
            }
            case 17: {
                return pSDEFValueRuleBase.getPSDEName();
            }
            case 18: {
                return pSDEFValueRuleBase.getPSSysDynaModelId();
            }
            case 19: {
                return pSDEFValueRuleBase.getPSSysDynaModelName();
            }
            case 20: {
                return pSDEFValueRuleBase.getPSSysPFPluginId();
            }
            case 21: {
                return pSDEFValueRuleBase.getPSSysPFPluginName();
            }
            case 22: {
                return pSDEFValueRuleBase.getPSSysReqItemId();
            }
            case 23: {
                return pSDEFValueRuleBase.getPSSysReqItemName();
            }
            case 24: {
                return pSDEFValueRuleBase.getPSSysSFPluginId();
            }
            case 25: {
                return pSDEFValueRuleBase.getPSSysSFPluginName();
            }
            case 26: {
                return pSDEFValueRuleBase.getRIPSLanResId();
            }
            case 27: {
                return pSDEFValueRuleBase.getRIPSLanResName();
            }
            case 28: {
                return pSDEFValueRuleBase.getRuleHolder();
            }
            case 29: {
                return pSDEFValueRuleBase.getRuleInfo();
            }
            case 30: {
                return pSDEFValueRuleBase.getRuleTag();
            }
            case 31: {
                return pSDEFValueRuleBase.getRuleTag2();
            }
            case 32: {
                return pSDEFValueRuleBase.getToDoTask();
            }
            case 33: {
                return pSDEFValueRuleBase.getUpdateDate();
            }
            case 34: {
                return pSDEFValueRuleBase.getUpdateMan();
            }
            case 35: {
                return pSDEFValueRuleBase.getUserCat();
            }
            case 36: {
                return pSDEFValueRuleBase.getUserTag();
            }
            case 37: {
                return pSDEFValueRuleBase.getUserTag2();
            }
            case 38: {
                return pSDEFValueRuleBase.getUserTag3();
            }
            case 39: {
                return pSDEFValueRuleBase.getUserTag4();
            }
            case 40: {
                return pSDEFValueRuleBase.getVRMode();
            }
            case 41: {
                return pSDEFValueRuleBase.getVRModel();
            }
            case 42: {
                return pSDEFValueRuleBase.getVRType();
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
        PSDEFValueRuleBase.set(this, n, object);
    }

    private static void set(PSDEFValueRuleBase pSDEFValueRuleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFValueRuleBase.setCheckDefault(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEFValueRuleBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFValueRuleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDEFValueRuleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFValueRuleBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFValueRuleBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEFValueRuleBase.setDefaultMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEFValueRuleBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEFValueRuleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEFValueRuleBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEFValueRuleBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFValueRuleBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEFValueRuleBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEFValueRuleBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFValueRuleBase.setPSDEFValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEFValueRuleBase.setPSDEFValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEFValueRuleBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEFValueRuleBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEFValueRuleBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEFValueRuleBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEFValueRuleBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEFValueRuleBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEFValueRuleBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEFValueRuleBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEFValueRuleBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEFValueRuleBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEFValueRuleBase.setRIPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEFValueRuleBase.setRIPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEFValueRuleBase.setRuleHolder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDEFValueRuleBase.setRuleInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEFValueRuleBase.setRuleTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEFValueRuleBase.setRuleTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEFValueRuleBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEFValueRuleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 34: {
                pSDEFValueRuleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEFValueRuleBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEFValueRuleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEFValueRuleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEFValueRuleBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEFValueRuleBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEFValueRuleBase.setVRMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEFValueRuleBase.setVRModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEFValueRuleBase.setVRType(DataObject.getStringValue((Object)object));
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
        return PSDEFValueRuleBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFValueRuleBase pSDEFValueRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFValueRuleBase.getCheckDefault() == null;
            }
            case 1: {
                return pSDEFValueRuleBase.getCodeName() == null;
            }
            case 2: {
                return pSDEFValueRuleBase.getCreateDate() == null;
            }
            case 3: {
                return pSDEFValueRuleBase.getCreateMan() == null;
            }
            case 4: {
                return pSDEFValueRuleBase.getCustomCode() == null;
            }
            case 5: {
                return pSDEFValueRuleBase.getCustomMode() == null;
            }
            case 6: {
                return pSDEFValueRuleBase.getDefaultMode() == null;
            }
            case 7: {
                return pSDEFValueRuleBase.getLockFlag() == null;
            }
            case 8: {
                return pSDEFValueRuleBase.getMemo() == null;
            }
            case 9: {
                return pSDEFValueRuleBase.getOrderValue() == null;
            }
            case 10: {
                return pSDEFValueRuleBase.getPSDEFId() == null;
            }
            case 11: {
                return pSDEFValueRuleBase.getPSDEFName() == null;
            }
            case 12: {
                return pSDEFValueRuleBase.getPSDEFormId() == null;
            }
            case 13: {
                return pSDEFValueRuleBase.getPSDEFormName() == null;
            }
            case 14: {
                return pSDEFValueRuleBase.getPSDEFValueRuleId() == null;
            }
            case 15: {
                return pSDEFValueRuleBase.getPSDEFValueRuleName() == null;
            }
            case 16: {
                return pSDEFValueRuleBase.getPSDEId() == null;
            }
            case 17: {
                return pSDEFValueRuleBase.getPSDEName() == null;
            }
            case 18: {
                return pSDEFValueRuleBase.getPSSysDynaModelId() == null;
            }
            case 19: {
                return pSDEFValueRuleBase.getPSSysDynaModelName() == null;
            }
            case 20: {
                return pSDEFValueRuleBase.getPSSysPFPluginId() == null;
            }
            case 21: {
                return pSDEFValueRuleBase.getPSSysPFPluginName() == null;
            }
            case 22: {
                return pSDEFValueRuleBase.getPSSysReqItemId() == null;
            }
            case 23: {
                return pSDEFValueRuleBase.getPSSysReqItemName() == null;
            }
            case 24: {
                return pSDEFValueRuleBase.getPSSysSFPluginId() == null;
            }
            case 25: {
                return pSDEFValueRuleBase.getPSSysSFPluginName() == null;
            }
            case 26: {
                return pSDEFValueRuleBase.getRIPSLanResId() == null;
            }
            case 27: {
                return pSDEFValueRuleBase.getRIPSLanResName() == null;
            }
            case 28: {
                return pSDEFValueRuleBase.getRuleHolder() == null;
            }
            case 29: {
                return pSDEFValueRuleBase.getRuleInfo() == null;
            }
            case 30: {
                return pSDEFValueRuleBase.getRuleTag() == null;
            }
            case 31: {
                return pSDEFValueRuleBase.getRuleTag2() == null;
            }
            case 32: {
                return pSDEFValueRuleBase.getToDoTask() == null;
            }
            case 33: {
                return pSDEFValueRuleBase.getUpdateDate() == null;
            }
            case 34: {
                return pSDEFValueRuleBase.getUpdateMan() == null;
            }
            case 35: {
                return pSDEFValueRuleBase.getUserCat() == null;
            }
            case 36: {
                return pSDEFValueRuleBase.getUserTag() == null;
            }
            case 37: {
                return pSDEFValueRuleBase.getUserTag2() == null;
            }
            case 38: {
                return pSDEFValueRuleBase.getUserTag3() == null;
            }
            case 39: {
                return pSDEFValueRuleBase.getUserTag4() == null;
            }
            case 40: {
                return pSDEFValueRuleBase.getVRMode() == null;
            }
            case 41: {
                return pSDEFValueRuleBase.getVRModel() == null;
            }
            case 42: {
                return pSDEFValueRuleBase.getVRType() == null;
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
        return PSDEFValueRuleBase.contains(this, n);
    }

    private static boolean contains(PSDEFValueRuleBase pSDEFValueRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFValueRuleBase.isCheckDefaultDirty();
            }
            case 1: {
                return pSDEFValueRuleBase.isCodeNameDirty();
            }
            case 2: {
                return pSDEFValueRuleBase.isCreateDateDirty();
            }
            case 3: {
                return pSDEFValueRuleBase.isCreateManDirty();
            }
            case 4: {
                return pSDEFValueRuleBase.isCustomCodeDirty();
            }
            case 5: {
                return pSDEFValueRuleBase.isCustomModeDirty();
            }
            case 6: {
                return pSDEFValueRuleBase.isDefaultModeDirty();
            }
            case 7: {
                return pSDEFValueRuleBase.isLockFlagDirty();
            }
            case 8: {
                return pSDEFValueRuleBase.isMemoDirty();
            }
            case 9: {
                return pSDEFValueRuleBase.isOrderValueDirty();
            }
            case 10: {
                return pSDEFValueRuleBase.isPSDEFIdDirty();
            }
            case 11: {
                return pSDEFValueRuleBase.isPSDEFNameDirty();
            }
            case 12: {
                return pSDEFValueRuleBase.isPSDEFormIdDirty();
            }
            case 13: {
                return pSDEFValueRuleBase.isPSDEFormNameDirty();
            }
            case 14: {
                return pSDEFValueRuleBase.isPSDEFValueRuleIdDirty();
            }
            case 15: {
                return pSDEFValueRuleBase.isPSDEFValueRuleNameDirty();
            }
            case 16: {
                return pSDEFValueRuleBase.isPSDEIdDirty();
            }
            case 17: {
                return pSDEFValueRuleBase.isPSDENameDirty();
            }
            case 18: {
                return pSDEFValueRuleBase.isPSSysDynaModelIdDirty();
            }
            case 19: {
                return pSDEFValueRuleBase.isPSSysDynaModelNameDirty();
            }
            case 20: {
                return pSDEFValueRuleBase.isPSSysPFPluginIdDirty();
            }
            case 21: {
                return pSDEFValueRuleBase.isPSSysPFPluginNameDirty();
            }
            case 22: {
                return pSDEFValueRuleBase.isPSSysReqItemIdDirty();
            }
            case 23: {
                return pSDEFValueRuleBase.isPSSysReqItemNameDirty();
            }
            case 24: {
                return pSDEFValueRuleBase.isPSSysSFPluginIdDirty();
            }
            case 25: {
                return pSDEFValueRuleBase.isPSSysSFPluginNameDirty();
            }
            case 26: {
                return pSDEFValueRuleBase.isRIPSLanResIdDirty();
            }
            case 27: {
                return pSDEFValueRuleBase.isRIPSLanResNameDirty();
            }
            case 28: {
                return pSDEFValueRuleBase.isRuleHolderDirty();
            }
            case 29: {
                return pSDEFValueRuleBase.isRuleInfoDirty();
            }
            case 30: {
                return pSDEFValueRuleBase.isRuleTagDirty();
            }
            case 31: {
                return pSDEFValueRuleBase.isRuleTag2Dirty();
            }
            case 32: {
                return pSDEFValueRuleBase.isToDoTaskDirty();
            }
            case 33: {
                return pSDEFValueRuleBase.isUpdateDateDirty();
            }
            case 34: {
                return pSDEFValueRuleBase.isUpdateManDirty();
            }
            case 35: {
                return pSDEFValueRuleBase.isUserCatDirty();
            }
            case 36: {
                return pSDEFValueRuleBase.isUserTagDirty();
            }
            case 37: {
                return pSDEFValueRuleBase.isUserTag2Dirty();
            }
            case 38: {
                return pSDEFValueRuleBase.isUserTag3Dirty();
            }
            case 39: {
                return pSDEFValueRuleBase.isUserTag4Dirty();
            }
            case 40: {
                return pSDEFValueRuleBase.isVRModeDirty();
            }
            case 41: {
                return pSDEFValueRuleBase.isVRModelDirty();
            }
            case 42: {
                return pSDEFValueRuleBase.isVRTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFValueRuleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFValueRuleBase pSDEFValueRuleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFValueRuleBase.getCheckDefault() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"checkdefault", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getCheckDefault()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getDefaultMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultmode", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getDefaultMode()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSDEFValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvalueruleid", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSDEFValueRuleId()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSDEFValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvaluerulename", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSDEFValueRuleName()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getRIPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ripslanresid", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getRIPSLanResId()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getRIPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ripslanresname", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getRIPSLanResName()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getRuleHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ruleholder", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getRuleHolder()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getRuleInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ruleinfo", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getRuleInfo()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getRuleTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ruletag", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getRuleTag()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getRuleTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ruletag2", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getRuleTag2()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getVRMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vrmode", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getVRMode()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getVRModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vrmodel", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getVRModel()), (boolean)false);
        }
        if (bl || pSDEFValueRuleBase.getVRType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vrtype", (Object)PSDEFValueRuleBase.getJSONValue((Object)pSDEFValueRuleBase.getVRType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFValueRuleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFValueRuleBase pSDEFValueRuleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFValueRuleBase.getCheckDefault() != null) {
            object = pSDEFValueRuleBase.getCheckDefault();
            xmlNode.setAttribute(FIELD_CHECKDEFAULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFValueRuleBase.getCodeName() != null) {
            object = pSDEFValueRuleBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getCreateDate() != null) {
            object = pSDEFValueRuleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFValueRuleBase.getCreateMan() != null) {
            object = pSDEFValueRuleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getCustomCode() != null) {
            object = pSDEFValueRuleBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getCustomMode() != null) {
            object = pSDEFValueRuleBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFValueRuleBase.getDefaultMode() != null) {
            object = pSDEFValueRuleBase.getDefaultMode();
            xmlNode.setAttribute(FIELD_DEFAULTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFValueRuleBase.getLockFlag() != null) {
            object = pSDEFValueRuleBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFValueRuleBase.getMemo() != null) {
            object = pSDEFValueRuleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getOrderValue() != null) {
            object = pSDEFValueRuleBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFValueRuleBase.getPSDEFId() != null) {
            object = pSDEFValueRuleBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getPSDEFName() != null) {
            object = pSDEFValueRuleBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getPSDEFormId() != null) {
            object = pSDEFValueRuleBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getPSDEFormName() != null) {
            object = pSDEFValueRuleBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getPSDEFValueRuleId() != null) {
            object = pSDEFValueRuleBase.getPSDEFValueRuleId();
            xmlNode.setAttribute(FIELD_PSDEFVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getPSDEFValueRuleName() != null) {
            object = pSDEFValueRuleBase.getPSDEFValueRuleName();
            xmlNode.setAttribute(FIELD_PSDEFVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getPSDEId() != null) {
            object = pSDEFValueRuleBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getPSDEName() != null) {
            object = pSDEFValueRuleBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getPSSysDynaModelId() != null) {
            object = pSDEFValueRuleBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getPSSysDynaModelName() != null) {
            object = pSDEFValueRuleBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getPSSysPFPluginId() != null) {
            object = pSDEFValueRuleBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getPSSysPFPluginName() != null) {
            object = pSDEFValueRuleBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getPSSysReqItemId() != null) {
            object = pSDEFValueRuleBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getPSSysReqItemName() != null) {
            object = pSDEFValueRuleBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getPSSysSFPluginId() != null) {
            object = pSDEFValueRuleBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getPSSysSFPluginName() != null) {
            object = pSDEFValueRuleBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getRIPSLanResId() != null) {
            object = pSDEFValueRuleBase.getRIPSLanResId();
            xmlNode.setAttribute(FIELD_RIPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getRIPSLanResName() != null) {
            object = pSDEFValueRuleBase.getRIPSLanResName();
            xmlNode.setAttribute(FIELD_RIPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getRuleHolder() != null) {
            object = pSDEFValueRuleBase.getRuleHolder();
            xmlNode.setAttribute(FIELD_RULEHOLDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFValueRuleBase.getRuleInfo() != null) {
            object = pSDEFValueRuleBase.getRuleInfo();
            xmlNode.setAttribute(FIELD_RULEINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getRuleTag() != null) {
            object = pSDEFValueRuleBase.getRuleTag();
            xmlNode.setAttribute(FIELD_RULETAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getRuleTag2() != null) {
            object = pSDEFValueRuleBase.getRuleTag2();
            xmlNode.setAttribute(FIELD_RULETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getToDoTask() != null) {
            object = pSDEFValueRuleBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getUpdateDate() != null) {
            object = pSDEFValueRuleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFValueRuleBase.getUpdateMan() != null) {
            object = pSDEFValueRuleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getUserCat() != null) {
            object = pSDEFValueRuleBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getUserTag() != null) {
            object = pSDEFValueRuleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getUserTag2() != null) {
            object = pSDEFValueRuleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getUserTag3() != null) {
            object = pSDEFValueRuleBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getUserTag4() != null) {
            object = pSDEFValueRuleBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getVRMode() != null) {
            object = pSDEFValueRuleBase.getVRMode();
            xmlNode.setAttribute(FIELD_VRMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getVRModel() != null) {
            object = pSDEFValueRuleBase.getVRModel();
            xmlNode.setAttribute(FIELD_VRMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEFValueRuleBase.getVRType() != null) {
            object = pSDEFValueRuleBase.getVRType();
            xmlNode.setAttribute(FIELD_VRTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFValueRuleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFValueRuleBase pSDEFValueRuleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFValueRuleBase.isCheckDefaultDirty() && (bl || pSDEFValueRuleBase.getCheckDefault() != null)) {
            iDataObject.set(FIELD_CHECKDEFAULT, (Object)pSDEFValueRuleBase.getCheckDefault());
        }
        if (pSDEFValueRuleBase.isCodeNameDirty() && (bl || pSDEFValueRuleBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEFValueRuleBase.getCodeName());
        }
        if (pSDEFValueRuleBase.isCreateDateDirty() && (bl || pSDEFValueRuleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFValueRuleBase.getCreateDate());
        }
        if (pSDEFValueRuleBase.isCreateManDirty() && (bl || pSDEFValueRuleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFValueRuleBase.getCreateMan());
        }
        if (pSDEFValueRuleBase.isCustomCodeDirty() && (bl || pSDEFValueRuleBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEFValueRuleBase.getCustomCode());
        }
        if (pSDEFValueRuleBase.isCustomModeDirty() && (bl || pSDEFValueRuleBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEFValueRuleBase.getCustomMode());
        }
        if (pSDEFValueRuleBase.isDefaultModeDirty() && (bl || pSDEFValueRuleBase.getDefaultMode() != null)) {
            iDataObject.set(FIELD_DEFAULTMODE, (Object)pSDEFValueRuleBase.getDefaultMode());
        }
        if (pSDEFValueRuleBase.isLockFlagDirty() && (bl || pSDEFValueRuleBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEFValueRuleBase.getLockFlag());
        }
        if (pSDEFValueRuleBase.isMemoDirty() && (bl || pSDEFValueRuleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFValueRuleBase.getMemo());
        }
        if (pSDEFValueRuleBase.isOrderValueDirty() && (bl || pSDEFValueRuleBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEFValueRuleBase.getOrderValue());
        }
        if (pSDEFValueRuleBase.isPSDEFIdDirty() && (bl || pSDEFValueRuleBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEFValueRuleBase.getPSDEFId());
        }
        if (pSDEFValueRuleBase.isPSDEFNameDirty() && (bl || pSDEFValueRuleBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEFValueRuleBase.getPSDEFName());
        }
        if (pSDEFValueRuleBase.isPSDEFormIdDirty() && (bl || pSDEFValueRuleBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDEFValueRuleBase.getPSDEFormId());
        }
        if (pSDEFValueRuleBase.isPSDEFormNameDirty() && (bl || pSDEFValueRuleBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDEFValueRuleBase.getPSDEFormName());
        }
        if (pSDEFValueRuleBase.isPSDEFValueRuleIdDirty() && (bl || pSDEFValueRuleBase.getPSDEFValueRuleId() != null)) {
            iDataObject.set(FIELD_PSDEFVALUERULEID, (Object)pSDEFValueRuleBase.getPSDEFValueRuleId());
        }
        if (pSDEFValueRuleBase.isPSDEFValueRuleNameDirty() && (bl || pSDEFValueRuleBase.getPSDEFValueRuleName() != null)) {
            iDataObject.set(FIELD_PSDEFVALUERULENAME, (Object)pSDEFValueRuleBase.getPSDEFValueRuleName());
        }
        if (pSDEFValueRuleBase.isPSDEIdDirty() && (bl || pSDEFValueRuleBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEFValueRuleBase.getPSDEId());
        }
        if (pSDEFValueRuleBase.isPSDENameDirty() && (bl || pSDEFValueRuleBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEFValueRuleBase.getPSDEName());
        }
        if (pSDEFValueRuleBase.isPSSysDynaModelIdDirty() && (bl || pSDEFValueRuleBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEFValueRuleBase.getPSSysDynaModelId());
        }
        if (pSDEFValueRuleBase.isPSSysDynaModelNameDirty() && (bl || pSDEFValueRuleBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEFValueRuleBase.getPSSysDynaModelName());
        }
        if (pSDEFValueRuleBase.isPSSysPFPluginIdDirty() && (bl || pSDEFValueRuleBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEFValueRuleBase.getPSSysPFPluginId());
        }
        if (pSDEFValueRuleBase.isPSSysPFPluginNameDirty() && (bl || pSDEFValueRuleBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEFValueRuleBase.getPSSysPFPluginName());
        }
        if (pSDEFValueRuleBase.isPSSysReqItemIdDirty() && (bl || pSDEFValueRuleBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEFValueRuleBase.getPSSysReqItemId());
        }
        if (pSDEFValueRuleBase.isPSSysReqItemNameDirty() && (bl || pSDEFValueRuleBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEFValueRuleBase.getPSSysReqItemName());
        }
        if (pSDEFValueRuleBase.isPSSysSFPluginIdDirty() && (bl || pSDEFValueRuleBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEFValueRuleBase.getPSSysSFPluginId());
        }
        if (pSDEFValueRuleBase.isPSSysSFPluginNameDirty() && (bl || pSDEFValueRuleBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEFValueRuleBase.getPSSysSFPluginName());
        }
        if (pSDEFValueRuleBase.isRIPSLanResIdDirty() && (bl || pSDEFValueRuleBase.getRIPSLanResId() != null)) {
            iDataObject.set(FIELD_RIPSLANRESID, (Object)pSDEFValueRuleBase.getRIPSLanResId());
        }
        if (pSDEFValueRuleBase.isRIPSLanResNameDirty() && (bl || pSDEFValueRuleBase.getRIPSLanResName() != null)) {
            iDataObject.set(FIELD_RIPSLANRESNAME, (Object)pSDEFValueRuleBase.getRIPSLanResName());
        }
        if (pSDEFValueRuleBase.isRuleHolderDirty() && (bl || pSDEFValueRuleBase.getRuleHolder() != null)) {
            iDataObject.set(FIELD_RULEHOLDER, (Object)pSDEFValueRuleBase.getRuleHolder());
        }
        if (pSDEFValueRuleBase.isRuleInfoDirty() && (bl || pSDEFValueRuleBase.getRuleInfo() != null)) {
            iDataObject.set(FIELD_RULEINFO, (Object)pSDEFValueRuleBase.getRuleInfo());
        }
        if (pSDEFValueRuleBase.isRuleTagDirty() && (bl || pSDEFValueRuleBase.getRuleTag() != null)) {
            iDataObject.set(FIELD_RULETAG, (Object)pSDEFValueRuleBase.getRuleTag());
        }
        if (pSDEFValueRuleBase.isRuleTag2Dirty() && (bl || pSDEFValueRuleBase.getRuleTag2() != null)) {
            iDataObject.set(FIELD_RULETAG2, (Object)pSDEFValueRuleBase.getRuleTag2());
        }
        if (pSDEFValueRuleBase.isToDoTaskDirty() && (bl || pSDEFValueRuleBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEFValueRuleBase.getToDoTask());
        }
        if (pSDEFValueRuleBase.isUpdateDateDirty() && (bl || pSDEFValueRuleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFValueRuleBase.getUpdateDate());
        }
        if (pSDEFValueRuleBase.isUpdateManDirty() && (bl || pSDEFValueRuleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFValueRuleBase.getUpdateMan());
        }
        if (pSDEFValueRuleBase.isUserCatDirty() && (bl || pSDEFValueRuleBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEFValueRuleBase.getUserCat());
        }
        if (pSDEFValueRuleBase.isUserTagDirty() && (bl || pSDEFValueRuleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEFValueRuleBase.getUserTag());
        }
        if (pSDEFValueRuleBase.isUserTag2Dirty() && (bl || pSDEFValueRuleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEFValueRuleBase.getUserTag2());
        }
        if (pSDEFValueRuleBase.isUserTag3Dirty() && (bl || pSDEFValueRuleBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEFValueRuleBase.getUserTag3());
        }
        if (pSDEFValueRuleBase.isUserTag4Dirty() && (bl || pSDEFValueRuleBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEFValueRuleBase.getUserTag4());
        }
        if (pSDEFValueRuleBase.isVRModeDirty() && (bl || pSDEFValueRuleBase.getVRMode() != null)) {
            iDataObject.set(FIELD_VRMODE, (Object)pSDEFValueRuleBase.getVRMode());
        }
        if (pSDEFValueRuleBase.isVRModelDirty() && (bl || pSDEFValueRuleBase.getVRModel() != null)) {
            iDataObject.set(FIELD_VRMODEL, (Object)pSDEFValueRuleBase.getVRModel());
        }
        if (pSDEFValueRuleBase.isVRTypeDirty() && (bl || pSDEFValueRuleBase.getVRType() != null)) {
            iDataObject.set(FIELD_VRTYPE, (Object)pSDEFValueRuleBase.getVRType());
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
        return PSDEFValueRuleBase.remove(this, n);
    }

    private static boolean remove(PSDEFValueRuleBase pSDEFValueRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFValueRuleBase.resetCheckDefault();
                return true;
            }
            case 1: {
                pSDEFValueRuleBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDEFValueRuleBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDEFValueRuleBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDEFValueRuleBase.resetCustomCode();
                return true;
            }
            case 5: {
                pSDEFValueRuleBase.resetCustomMode();
                return true;
            }
            case 6: {
                pSDEFValueRuleBase.resetDefaultMode();
                return true;
            }
            case 7: {
                pSDEFValueRuleBase.resetLockFlag();
                return true;
            }
            case 8: {
                pSDEFValueRuleBase.resetMemo();
                return true;
            }
            case 9: {
                pSDEFValueRuleBase.resetOrderValue();
                return true;
            }
            case 10: {
                pSDEFValueRuleBase.resetPSDEFId();
                return true;
            }
            case 11: {
                pSDEFValueRuleBase.resetPSDEFName();
                return true;
            }
            case 12: {
                pSDEFValueRuleBase.resetPSDEFormId();
                return true;
            }
            case 13: {
                pSDEFValueRuleBase.resetPSDEFormName();
                return true;
            }
            case 14: {
                pSDEFValueRuleBase.resetPSDEFValueRuleId();
                return true;
            }
            case 15: {
                pSDEFValueRuleBase.resetPSDEFValueRuleName();
                return true;
            }
            case 16: {
                pSDEFValueRuleBase.resetPSDEId();
                return true;
            }
            case 17: {
                pSDEFValueRuleBase.resetPSDEName();
                return true;
            }
            case 18: {
                pSDEFValueRuleBase.resetPSSysDynaModelId();
                return true;
            }
            case 19: {
                pSDEFValueRuleBase.resetPSSysDynaModelName();
                return true;
            }
            case 20: {
                pSDEFValueRuleBase.resetPSSysPFPluginId();
                return true;
            }
            case 21: {
                pSDEFValueRuleBase.resetPSSysPFPluginName();
                return true;
            }
            case 22: {
                pSDEFValueRuleBase.resetPSSysReqItemId();
                return true;
            }
            case 23: {
                pSDEFValueRuleBase.resetPSSysReqItemName();
                return true;
            }
            case 24: {
                pSDEFValueRuleBase.resetPSSysSFPluginId();
                return true;
            }
            case 25: {
                pSDEFValueRuleBase.resetPSSysSFPluginName();
                return true;
            }
            case 26: {
                pSDEFValueRuleBase.resetRIPSLanResId();
                return true;
            }
            case 27: {
                pSDEFValueRuleBase.resetRIPSLanResName();
                return true;
            }
            case 28: {
                pSDEFValueRuleBase.resetRuleHolder();
                return true;
            }
            case 29: {
                pSDEFValueRuleBase.resetRuleInfo();
                return true;
            }
            case 30: {
                pSDEFValueRuleBase.resetRuleTag();
                return true;
            }
            case 31: {
                pSDEFValueRuleBase.resetRuleTag2();
                return true;
            }
            case 32: {
                pSDEFValueRuleBase.resetToDoTask();
                return true;
            }
            case 33: {
                pSDEFValueRuleBase.resetUpdateDate();
                return true;
            }
            case 34: {
                pSDEFValueRuleBase.resetUpdateMan();
                return true;
            }
            case 35: {
                pSDEFValueRuleBase.resetUserCat();
                return true;
            }
            case 36: {
                pSDEFValueRuleBase.resetUserTag();
                return true;
            }
            case 37: {
                pSDEFValueRuleBase.resetUserTag2();
                return true;
            }
            case 38: {
                pSDEFValueRuleBase.resetUserTag3();
                return true;
            }
            case 39: {
                pSDEFValueRuleBase.resetUserTag4();
                return true;
            }
            case 40: {
                pSDEFValueRuleBase.resetVRMode();
                return true;
            }
            case 41: {
                pSDEFValueRuleBase.resetVRModel();
                return true;
            }
            case 42: {
                pSDEFValueRuleBase.resetVRType();
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEForm();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormLock;
        synchronized (n) {
            if (this.psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormId(), (Object)this.psdeform.getPSDEFormId()) != 0L) {
                this.psdeform = null;
            }
            if (this.psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getRIPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRIPSLanRes();
        }
        if (this.getRIPSLanResId() == null) {
            return null;
        }
        Integer n = this.objRIPSLanResLock;
        synchronized (n) {
            if (this.ripslanres != null && DataTypeHelper.compare((int)25, (Object)this.getRIPSLanResId(), (Object)this.ripslanres.getPSLanguageResId()) != 0L) {
                this.ripslanres = null;
            }
            if (this.ripslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getRIPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.ripslanres = pSLanguageRes;
            }
            return this.ripslanres;
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
                pSSysReqItemService.autoGet((IEntity)pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
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
    public ArrayList<PSDEFVRCond> getPSDEFVRConds() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRConds();
        }
        if (this.getPSDEFValueRuleId() == null) {
            return null;
        }
        PSDEFValueRuleService pSDEFValueRuleService = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFVRCondsLock;
        synchronized (n) {
            if (this.psdefvrconds == null) {
                this.psdefvrconds = pSDEFValueRuleService.isTempData((IEntity)this) ? pSDEFVRCondService.selectTempByPSDEFVR(this) : pSDEFVRCondService.selectByPSDEFVR(this);
            }
            return this.psdefvrconds;
        }
    }

    private PSDEFValueRuleBase getProxyEntity() {
        return this.proxyPSDEFValueRuleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFValueRuleBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFValueRuleBase) {
            this.proxyPSDEFValueRuleBase = (PSDEFValueRuleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CHECKDEFAULT, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 4);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 5);
        fieldIndexMap.put(FIELD_DEFAULTMODE, 6);
        fieldIndexMap.put(FIELD_LOCKFLAG, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_ORDERVALUE, 9);
        fieldIndexMap.put(FIELD_PSDEFID, 10);
        fieldIndexMap.put(FIELD_PSDEFNAME, 11);
        fieldIndexMap.put(FIELD_PSDEFORMID, 12);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 13);
        fieldIndexMap.put(FIELD_PSDEFVALUERULEID, 14);
        fieldIndexMap.put(FIELD_PSDEFVALUERULENAME, 15);
        fieldIndexMap.put(FIELD_PSDEID, 16);
        fieldIndexMap.put(FIELD_PSDENAME, 17);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 18);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 20);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 22);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 24);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 25);
        fieldIndexMap.put(FIELD_RIPSLANRESID, 26);
        fieldIndexMap.put(FIELD_RIPSLANRESNAME, 27);
        fieldIndexMap.put(FIELD_RULEHOLDER, 28);
        fieldIndexMap.put(FIELD_RULEINFO, 29);
        fieldIndexMap.put(FIELD_RULETAG, 30);
        fieldIndexMap.put(FIELD_RULETAG2, 31);
        fieldIndexMap.put(FIELD_TODOTASK, 32);
        fieldIndexMap.put(FIELD_UPDATEDATE, 33);
        fieldIndexMap.put(FIELD_UPDATEMAN, 34);
        fieldIndexMap.put(FIELD_USERCAT, 35);
        fieldIndexMap.put(FIELD_USERTAG, 36);
        fieldIndexMap.put(FIELD_USERTAG2, 37);
        fieldIndexMap.put(FIELD_USERTAG3, 38);
        fieldIndexMap.put(FIELD_USERTAG4, 39);
        fieldIndexMap.put(FIELD_VRMODE, 40);
        fieldIndexMap.put(FIELD_VRMODEL, 41);
        fieldIndexMap.put(FIELD_VRTYPE, 42);
    }
}

