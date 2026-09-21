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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardStep;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEWizardFormBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEWizardFormBase.class);
    public static final String FIELD_CMPSLANRESID = "CMPSLANRESID";
    public static final String FIELD_CMPSLANRESID2 = "CMPSLANRESID2";
    public static final String FIELD_CMPSLANRESNAME = "CMPSLANRESNAME";
    public static final String FIELD_CMPSLANRESNAME2 = "CMPSLANRESNAME2";
    public static final String FIELD_CONFIRMINFO = "CONFIRMINFO";
    public static final String FIELD_CONFIRMINFO2 = "CONFIRMINFO2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FINISHENABLELOGIC = "FINISHENABLELOGIC";
    public static final String FIELD_FIRSTFORM = "FIRSTFORM";
    public static final String FIELD_FORMTAG = "FORMTAG";
    public static final String FIELD_LOADPSDEACTIONID = "LOADPSDEACTIONID";
    public static final String FIELD_LOADPSDEACTIONNAME = "LOADPSDEACTIONNAME";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBPSDEFORMID = "MOBPSDEFORMID";
    public static final String FIELD_MOBPSDEFORMNAME = "MOBPSDEFORMNAME";
    public static final String FIELD_NEXTENABLELOGIC = "NEXTENABLELOGIC";
    public static final String FIELD_PREVENABLELOGIC = "PREVENABLELOGIC";
    public static final String FIELD_PREVPSDEACTIONID = "PREVPSDEACTIONID";
    public static final String FIELD_PREVPSDEACTIONNAME = "PREVPSDEACTIONNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEWIZARDFORMID = "PSDEWIZARDFORMID";
    public static final String FIELD_PSDEWIZARDFORMNAME = "PSDEWIZARDFORMNAME";
    public static final String FIELD_PSDEWIZARDID = "PSDEWIZARDID";
    public static final String FIELD_PSDEWIZARDNAME = "PSDEWIZARDNAME";
    public static final String FIELD_PSDEWIZARDSTEPID = "PSDEWIZARDSTEPID";
    public static final String FIELD_PSDEWIZARDSTEPNAME = "PSDEWIZARDSTEPNAME";
    public static final String FIELD_SAVEPSDEACTIONID = "SAVEPSDEACTIONID";
    public static final String FIELD_SAVEPSDEACTIONNAME = "SAVEPSDEACTIONNAME";
    public static final String FIELD_STEPACTIONS = "STEPACTIONS";
    public static final String FIELD_STEPORDERVALUE = "STEPORDERVALUE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CMPSLANRESID = 0;
    private static final int INDEX_CMPSLANRESID2 = 1;
    private static final int INDEX_CMPSLANRESNAME = 2;
    private static final int INDEX_CMPSLANRESNAME2 = 3;
    private static final int INDEX_CONFIRMINFO = 4;
    private static final int INDEX_CONFIRMINFO2 = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_FINISHENABLELOGIC = 8;
    private static final int INDEX_FIRSTFORM = 9;
    private static final int INDEX_FORMTAG = 10;
    private static final int INDEX_LOADPSDEACTIONID = 11;
    private static final int INDEX_LOADPSDEACTIONNAME = 12;
    private static final int INDEX_LOGICNAME = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_MOBPSDEFORMID = 15;
    private static final int INDEX_MOBPSDEFORMNAME = 16;
    private static final int INDEX_NEXTENABLELOGIC = 17;
    private static final int INDEX_PREVENABLELOGIC = 18;
    private static final int INDEX_PREVPSDEACTIONID = 19;
    private static final int INDEX_PREVPSDEACTIONNAME = 20;
    private static final int INDEX_PSDEFORMID = 21;
    private static final int INDEX_PSDEFORMNAME = 22;
    private static final int INDEX_PSDEID = 23;
    private static final int INDEX_PSDEWIZARDFORMID = 24;
    private static final int INDEX_PSDEWIZARDFORMNAME = 25;
    private static final int INDEX_PSDEWIZARDID = 26;
    private static final int INDEX_PSDEWIZARDNAME = 27;
    private static final int INDEX_PSDEWIZARDSTEPID = 28;
    private static final int INDEX_PSDEWIZARDSTEPNAME = 29;
    private static final int INDEX_SAVEPSDEACTIONID = 30;
    private static final int INDEX_SAVEPSDEACTIONNAME = 31;
    private static final int INDEX_STEPACTIONS = 32;
    private static final int INDEX_STEPORDERVALUE = 33;
    private static final int INDEX_UPDATEDATE = 34;
    private static final int INDEX_UPDATEMAN = 35;
    private static final int INDEX_USERCAT = 36;
    private static final int INDEX_USERTAG = 37;
    private static final int INDEX_USERTAG2 = 38;
    private static final int INDEX_USERTAG3 = 39;
    private static final int INDEX_USERTAG4 = 40;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEWizardFormBase proxyPSDEWizardFormBase = null;
    private boolean cmpslanresidDirtyFlag = false;
    private boolean cmpslanresid2DirtyFlag = false;
    private boolean cmpslanresnameDirtyFlag = false;
    private boolean cmpslanresname2DirtyFlag = false;
    private boolean confirminfoDirtyFlag = false;
    private boolean confirminfo2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean finishenablelogicDirtyFlag = false;
    private boolean firstformDirtyFlag = false;
    private boolean formtagDirtyFlag = false;
    private boolean loadpsdeactionidDirtyFlag = false;
    private boolean loadpsdeactionnameDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobpsdeformidDirtyFlag = false;
    private boolean mobpsdeformnameDirtyFlag = false;
    private boolean nextenablelogicDirtyFlag = false;
    private boolean prevenablelogicDirtyFlag = false;
    private boolean prevpsdeactionidDirtyFlag = false;
    private boolean prevpsdeactionnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdewizardformidDirtyFlag = false;
    private boolean psdewizardformnameDirtyFlag = false;
    private boolean psdewizardidDirtyFlag = false;
    private boolean psdewizardnameDirtyFlag = false;
    private boolean psdewizardstepidDirtyFlag = false;
    private boolean psdewizardstepnameDirtyFlag = false;
    private boolean savepsdeactionidDirtyFlag = false;
    private boolean savepsdeactionnameDirtyFlag = false;
    private boolean stepactionsDirtyFlag = false;
    private boolean stepordervalueDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="cmpslanresid")
    private String cmpslanresid;
    @Column(name="cmpslanresid2")
    private String cmpslanresid2;
    @Column(name="cmpslanresname")
    private String cmpslanresname;
    @Column(name="cmpslanresname2")
    private String cmpslanresname2;
    @Column(name="confirminfo")
    private String confirminfo;
    @Column(name="confirminfo2")
    private String confirminfo2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="finishenablelogic")
    private String finishenablelogic;
    @Column(name="firstform")
    private Integer firstform;
    @Column(name="formtag")
    private String formtag;
    @Column(name="loadpsdeactionid")
    private String loadpsdeactionid;
    @Column(name="loadpsdeactionname")
    private String loadpsdeactionname;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="mobpsdeformid")
    private String mobpsdeformid;
    @Column(name="mobpsdeformname")
    private String mobpsdeformname;
    @Column(name="nextenablelogic")
    private String nextenablelogic;
    @Column(name="prevenablelogic")
    private String prevenablelogic;
    @Column(name="prevpsdeactionid")
    private String prevpsdeactionid;
    @Column(name="prevpsdeactionname")
    private String prevpsdeactionname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdewizardformid")
    private String psdewizardformid;
    @Column(name="psdewizardformname")
    private String psdewizardformname;
    @Column(name="psdewizardid")
    private String psdewizardid;
    @Column(name="psdewizardname")
    private String psdewizardname;
    @Column(name="psdewizardstepid")
    private String psdewizardstepid;
    @Column(name="psdewizardstepname")
    private String psdewizardstepname;
    @Column(name="savepsdeactionid")
    private String savepsdeactionid;
    @Column(name="savepsdeactionname")
    private String savepsdeactionname;
    @Column(name="stepactions")
    private String stepactions;
    @Column(name="stepordervalue")
    private Integer stepordervalue;
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
    private Integer objLoadPSDEActionLock = new Integer(1);
    private PSDEAction loadpsdeaction = null;
    private Integer objPrevPSDEActionLock = new Integer(1);
    private PSDEAction prevpsdeaction = null;
    private Integer objSavePSDEActionLock = new Integer(1);
    private PSDEAction savepsdeaction = null;
    private Integer objMobPSDEFormLock = new Integer(1);
    private PSDEForm mobpsdeform = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objPSDEWizardStepLock = new Integer(1);
    private PSDEWizardStep psdewizardstep = null;
    private Integer objPSDEWizardLock = new Integer(1);
    private PSDEWizard psdewizard = null;
    private Integer objCMPSLanResLock = new Integer(1);
    private PSLanguageRes cmpslanres = null;
    private Integer objCM2PSLanResLock = new Integer(1);
    private PSLanguageRes cm2pslanres = null;

    public void setCMPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCMPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cmpslanresid = string;
        this.cmpslanresidDirtyFlag = true;
    }

    public String getCMPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCMPSLanResId();
        }
        return this.cmpslanresid;
    }

    public boolean isCMPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCMPSLanResIdDirty();
        }
        return this.cmpslanresidDirtyFlag;
    }

    public void resetCMPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCMPSLanResId();
            return;
        }
        this.cmpslanresidDirtyFlag = false;
        this.cmpslanresid = null;
    }

    public void setCMPSLanResId2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCMPSLanResId2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cmpslanresid2 = string;
        this.cmpslanresid2DirtyFlag = true;
    }

    public String getCMPSLanResId2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCMPSLanResId2();
        }
        return this.cmpslanresid2;
    }

    public boolean isCMPSLanResId2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCMPSLanResId2Dirty();
        }
        return this.cmpslanresid2DirtyFlag;
    }

    public void resetCMPSLanResId2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCMPSLanResId2();
            return;
        }
        this.cmpslanresid2DirtyFlag = false;
        this.cmpslanresid2 = null;
    }

    public void setCMPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCMPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cmpslanresname = string;
        this.cmpslanresnameDirtyFlag = true;
    }

    public String getCMPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCMPSLanResName();
        }
        return this.cmpslanresname;
    }

    public boolean isCMPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCMPSLanResNameDirty();
        }
        return this.cmpslanresnameDirtyFlag;
    }

    public void resetCMPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCMPSLanResName();
            return;
        }
        this.cmpslanresnameDirtyFlag = false;
        this.cmpslanresname = null;
    }

    public void setCMPSLanResName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCMPSLanResName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cmpslanresname2 = string;
        this.cmpslanresname2DirtyFlag = true;
    }

    public String getCMPSLanResName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCMPSLanResName2();
        }
        return this.cmpslanresname2;
    }

    public boolean isCMPSLanResName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCMPSLanResName2Dirty();
        }
        return this.cmpslanresname2DirtyFlag;
    }

    public void resetCMPSLanResName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCMPSLanResName2();
            return;
        }
        this.cmpslanresname2DirtyFlag = false;
        this.cmpslanresname2 = null;
    }

    public void setConfirmInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConfirmInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.confirminfo = string;
        this.confirminfoDirtyFlag = true;
    }

    public String getConfirmInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConfirmInfo();
        }
        return this.confirminfo;
    }

    public boolean isConfirmInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConfirmInfoDirty();
        }
        return this.confirminfoDirtyFlag;
    }

    public void resetConfirmInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConfirmInfo();
            return;
        }
        this.confirminfoDirtyFlag = false;
        this.confirminfo = null;
    }

    public void setConfirmInfo2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConfirmInfo2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.confirminfo2 = string;
        this.confirminfo2DirtyFlag = true;
    }

    public String getConfirmInfo2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConfirmInfo2();
        }
        return this.confirminfo2;
    }

    public boolean isConfirmInfo2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConfirmInfo2Dirty();
        }
        return this.confirminfo2DirtyFlag;
    }

    public void resetConfirmInfo2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConfirmInfo2();
            return;
        }
        this.confirminfo2DirtyFlag = false;
        this.confirminfo2 = null;
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

    public void setFinishEnableLogic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishEnableLogic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.finishenablelogic = string;
        this.finishenablelogicDirtyFlag = true;
    }

    public String getFinishEnableLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishEnableLogic();
        }
        return this.finishenablelogic;
    }

    public boolean isFinishEnableLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishEnableLogicDirty();
        }
        return this.finishenablelogicDirtyFlag;
    }

    public void resetFinishEnableLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishEnableLogic();
            return;
        }
        this.finishenablelogicDirtyFlag = false;
        this.finishenablelogic = null;
    }

    public void setFirstForm(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFirstForm(n);
            return;
        }
        this.firstform = n;
        this.firstformDirtyFlag = true;
    }

    public Integer getFirstForm() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFirstForm();
        }
        return this.firstform;
    }

    public boolean isFirstFormDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFirstFormDirty();
        }
        return this.firstformDirtyFlag;
    }

    public void resetFirstForm() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFirstForm();
            return;
        }
        this.firstformDirtyFlag = false;
        this.firstform = null;
    }

    public void setFormTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formtag = string;
        this.formtagDirtyFlag = true;
    }

    public String getFormTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormTag();
        }
        return this.formtag;
    }

    public boolean isFormTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormTagDirty();
        }
        return this.formtagDirtyFlag;
    }

    public void resetFormTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormTag();
            return;
        }
        this.formtagDirtyFlag = false;
        this.formtag = null;
    }

    public void setLoadPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoadPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.loadpsdeactionid = string;
        this.loadpsdeactionidDirtyFlag = true;
    }

    public String getLoadPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoadPSDEActionId();
        }
        return this.loadpsdeactionid;
    }

    public boolean isLoadPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoadPSDEActionIdDirty();
        }
        return this.loadpsdeactionidDirtyFlag;
    }

    public void resetLoadPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoadPSDEActionId();
            return;
        }
        this.loadpsdeactionidDirtyFlag = false;
        this.loadpsdeactionid = null;
    }

    public void setLoadPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoadPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.loadpsdeactionname = string;
        this.loadpsdeactionnameDirtyFlag = true;
    }

    public String getLoadPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoadPSDEActionName();
        }
        return this.loadpsdeactionname;
    }

    public boolean isLoadPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoadPSDEActionNameDirty();
        }
        return this.loadpsdeactionnameDirtyFlag;
    }

    public void resetLoadPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoadPSDEActionName();
            return;
        }
        this.loadpsdeactionnameDirtyFlag = false;
        this.loadpsdeactionname = null;
    }

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setMobPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobpsdeformid = string;
        this.mobpsdeformidDirtyFlag = true;
    }

    public String getMobPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEFormId();
        }
        return this.mobpsdeformid;
    }

    public boolean isMobPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSDEFormIdDirty();
        }
        return this.mobpsdeformidDirtyFlag;
    }

    public void resetMobPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSDEFormId();
            return;
        }
        this.mobpsdeformidDirtyFlag = false;
        this.mobpsdeformid = null;
    }

    public void setMobPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mobpsdeformname = string;
        this.mobpsdeformnameDirtyFlag = true;
    }

    public String getMobPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEFormName();
        }
        return this.mobpsdeformname;
    }

    public boolean isMobPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobPSDEFormNameDirty();
        }
        return this.mobpsdeformnameDirtyFlag;
    }

    public void resetMobPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobPSDEFormName();
            return;
        }
        this.mobpsdeformnameDirtyFlag = false;
        this.mobpsdeformname = null;
    }

    public void setNextEnableLogic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNextEnableLogic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nextenablelogic = string;
        this.nextenablelogicDirtyFlag = true;
    }

    public String getNextEnableLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextEnableLogic();
        }
        return this.nextenablelogic;
    }

    public boolean isNextEnableLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNextEnableLogicDirty();
        }
        return this.nextenablelogicDirtyFlag;
    }

    public void resetNextEnableLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNextEnableLogic();
            return;
        }
        this.nextenablelogicDirtyFlag = false;
        this.nextenablelogic = null;
    }

    public void setPrevEnableLogic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrevEnableLogic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prevenablelogic = string;
        this.prevenablelogicDirtyFlag = true;
    }

    public String getPrevEnableLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrevEnableLogic();
        }
        return this.prevenablelogic;
    }

    public boolean isPrevEnableLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrevEnableLogicDirty();
        }
        return this.prevenablelogicDirtyFlag;
    }

    public void resetPrevEnableLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrevEnableLogic();
            return;
        }
        this.prevenablelogicDirtyFlag = false;
        this.prevenablelogic = null;
    }

    public void setPrevPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrevPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prevpsdeactionid = string;
        this.prevpsdeactionidDirtyFlag = true;
    }

    public String getPrevPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrevPSDEActionId();
        }
        return this.prevpsdeactionid;
    }

    public boolean isPrevPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrevPSDEActionIdDirty();
        }
        return this.prevpsdeactionidDirtyFlag;
    }

    public void resetPrevPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrevPSDEActionId();
            return;
        }
        this.prevpsdeactionidDirtyFlag = false;
        this.prevpsdeactionid = null;
    }

    public void setPrevPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrevPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prevpsdeactionname = string;
        this.prevpsdeactionnameDirtyFlag = true;
    }

    public String getPrevPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrevPSDEActionName();
        }
        return this.prevpsdeactionname;
    }

    public boolean isPrevPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrevPSDEActionNameDirty();
        }
        return this.prevpsdeactionnameDirtyFlag;
    }

    public void resetPrevPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrevPSDEActionName();
            return;
        }
        this.prevpsdeactionnameDirtyFlag = false;
        this.prevpsdeactionname = null;
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

    public void setPSDEWizardFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardformid = string;
        this.psdewizardformidDirtyFlag = true;
    }

    public String getPSDEWizardFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardFormId();
        }
        return this.psdewizardformid;
    }

    public boolean isPSDEWizardFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardFormIdDirty();
        }
        return this.psdewizardformidDirtyFlag;
    }

    public void resetPSDEWizardFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardFormId();
            return;
        }
        this.psdewizardformidDirtyFlag = false;
        this.psdewizardformid = null;
    }

    public void setPSDEWizardFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardformname = string;
        this.psdewizardformnameDirtyFlag = true;
    }

    public String getPSDEWizardFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardFormName();
        }
        return this.psdewizardformname;
    }

    public boolean isPSDEWizardFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardFormNameDirty();
        }
        return this.psdewizardformnameDirtyFlag;
    }

    public void resetPSDEWizardFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardFormName();
            return;
        }
        this.psdewizardformnameDirtyFlag = false;
        this.psdewizardformname = null;
    }

    public void setPSDEWizardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardid = string;
        this.psdewizardidDirtyFlag = true;
    }

    public String getPSDEWizardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardId();
        }
        return this.psdewizardid;
    }

    public boolean isPSDEWizardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardIdDirty();
        }
        return this.psdewizardidDirtyFlag;
    }

    public void resetPSDEWizardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardId();
            return;
        }
        this.psdewizardidDirtyFlag = false;
        this.psdewizardid = null;
    }

    public void setPSDEWizardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardname = string;
        this.psdewizardnameDirtyFlag = true;
    }

    public String getPSDEWizardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardName();
        }
        return this.psdewizardname;
    }

    public boolean isPSDEWizardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardNameDirty();
        }
        return this.psdewizardnameDirtyFlag;
    }

    public void resetPSDEWizardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardName();
            return;
        }
        this.psdewizardnameDirtyFlag = false;
        this.psdewizardname = null;
    }

    public void setPSDEWizardStepId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardStepId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardstepid = string;
        this.psdewizardstepidDirtyFlag = true;
    }

    public String getPSDEWizardStepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardStepId();
        }
        return this.psdewizardstepid;
    }

    public boolean isPSDEWizardStepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardStepIdDirty();
        }
        return this.psdewizardstepidDirtyFlag;
    }

    public void resetPSDEWizardStepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardStepId();
            return;
        }
        this.psdewizardstepidDirtyFlag = false;
        this.psdewizardstepid = null;
    }

    public void setPSDEWizardStepName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEWizardStepName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdewizardstepname = string;
        this.psdewizardstepnameDirtyFlag = true;
    }

    public String getPSDEWizardStepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardStepName();
        }
        return this.psdewizardstepname;
    }

    public boolean isPSDEWizardStepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEWizardStepNameDirty();
        }
        return this.psdewizardstepnameDirtyFlag;
    }

    public void resetPSDEWizardStepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEWizardStepName();
            return;
        }
        this.psdewizardstepnameDirtyFlag = false;
        this.psdewizardstepname = null;
    }

    public void setSavePSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSavePSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.savepsdeactionid = string;
        this.savepsdeactionidDirtyFlag = true;
    }

    public String getSavePSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSavePSDEActionId();
        }
        return this.savepsdeactionid;
    }

    public boolean isSavePSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSavePSDEActionIdDirty();
        }
        return this.savepsdeactionidDirtyFlag;
    }

    public void resetSavePSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSavePSDEActionId();
            return;
        }
        this.savepsdeactionidDirtyFlag = false;
        this.savepsdeactionid = null;
    }

    public void setSavePSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSavePSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.savepsdeactionname = string;
        this.savepsdeactionnameDirtyFlag = true;
    }

    public String getSavePSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSavePSDEActionName();
        }
        return this.savepsdeactionname;
    }

    public boolean isSavePSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSavePSDEActionNameDirty();
        }
        return this.savepsdeactionnameDirtyFlag;
    }

    public void resetSavePSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSavePSDEActionName();
            return;
        }
        this.savepsdeactionnameDirtyFlag = false;
        this.savepsdeactionname = null;
    }

    public void setStepActions(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStepActions(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.stepactions = string;
        this.stepactionsDirtyFlag = true;
    }

    public String getStepActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStepActions();
        }
        return this.stepactions;
    }

    public boolean isStepActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStepActionsDirty();
        }
        return this.stepactionsDirtyFlag;
    }

    public void resetStepActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStepActions();
            return;
        }
        this.stepactionsDirtyFlag = false;
        this.stepactions = null;
    }

    public void setStepOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStepOrderValue(n);
            return;
        }
        this.stepordervalue = n;
        this.stepordervalueDirtyFlag = true;
    }

    public Integer getStepOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStepOrderValue();
        }
        return this.stepordervalue;
    }

    public boolean isStepOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStepOrderValueDirty();
        }
        return this.stepordervalueDirtyFlag;
    }

    public void resetStepOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStepOrderValue();
            return;
        }
        this.stepordervalueDirtyFlag = false;
        this.stepordervalue = null;
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
        PSDEWizardFormBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEWizardFormBase pSDEWizardFormBase) {
        pSDEWizardFormBase.resetCMPSLanResId();
        pSDEWizardFormBase.resetCMPSLanResId2();
        pSDEWizardFormBase.resetCMPSLanResName();
        pSDEWizardFormBase.resetCMPSLanResName2();
        pSDEWizardFormBase.resetConfirmInfo();
        pSDEWizardFormBase.resetConfirmInfo2();
        pSDEWizardFormBase.resetCreateDate();
        pSDEWizardFormBase.resetCreateMan();
        pSDEWizardFormBase.resetFinishEnableLogic();
        pSDEWizardFormBase.resetFirstForm();
        pSDEWizardFormBase.resetFormTag();
        pSDEWizardFormBase.resetLoadPSDEActionId();
        pSDEWizardFormBase.resetLoadPSDEActionName();
        pSDEWizardFormBase.resetLogicName();
        pSDEWizardFormBase.resetMemo();
        pSDEWizardFormBase.resetMobPSDEFormId();
        pSDEWizardFormBase.resetMobPSDEFormName();
        pSDEWizardFormBase.resetNextEnableLogic();
        pSDEWizardFormBase.resetPrevEnableLogic();
        pSDEWizardFormBase.resetPrevPSDEActionId();
        pSDEWizardFormBase.resetPrevPSDEActionName();
        pSDEWizardFormBase.resetPSDEFormId();
        pSDEWizardFormBase.resetPSDEFormName();
        pSDEWizardFormBase.resetPSDEId();
        pSDEWizardFormBase.resetPSDEWizardFormId();
        pSDEWizardFormBase.resetPSDEWizardFormName();
        pSDEWizardFormBase.resetPSDEWizardId();
        pSDEWizardFormBase.resetPSDEWizardName();
        pSDEWizardFormBase.resetPSDEWizardStepId();
        pSDEWizardFormBase.resetPSDEWizardStepName();
        pSDEWizardFormBase.resetSavePSDEActionId();
        pSDEWizardFormBase.resetSavePSDEActionName();
        pSDEWizardFormBase.resetStepActions();
        pSDEWizardFormBase.resetStepOrderValue();
        pSDEWizardFormBase.resetUpdateDate();
        pSDEWizardFormBase.resetUpdateMan();
        pSDEWizardFormBase.resetUserCat();
        pSDEWizardFormBase.resetUserTag();
        pSDEWizardFormBase.resetUserTag2();
        pSDEWizardFormBase.resetUserTag3();
        pSDEWizardFormBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCMPSLanResIdDirty()) {
            hashMap.put(FIELD_CMPSLANRESID, this.getCMPSLanResId());
        }
        if (!bl || this.isCMPSLanResId2Dirty()) {
            hashMap.put(FIELD_CMPSLANRESID2, this.getCMPSLanResId2());
        }
        if (!bl || this.isCMPSLanResNameDirty()) {
            hashMap.put(FIELD_CMPSLANRESNAME, this.getCMPSLanResName());
        }
        if (!bl || this.isCMPSLanResName2Dirty()) {
            hashMap.put(FIELD_CMPSLANRESNAME2, this.getCMPSLanResName2());
        }
        if (!bl || this.isConfirmInfoDirty()) {
            hashMap.put(FIELD_CONFIRMINFO, this.getConfirmInfo());
        }
        if (!bl || this.isConfirmInfo2Dirty()) {
            hashMap.put(FIELD_CONFIRMINFO2, this.getConfirmInfo2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFinishEnableLogicDirty()) {
            hashMap.put(FIELD_FINISHENABLELOGIC, this.getFinishEnableLogic());
        }
        if (!bl || this.isFirstFormDirty()) {
            hashMap.put(FIELD_FIRSTFORM, this.getFirstForm());
        }
        if (!bl || this.isFormTagDirty()) {
            hashMap.put(FIELD_FORMTAG, this.getFormTag());
        }
        if (!bl || this.isLoadPSDEActionIdDirty()) {
            hashMap.put(FIELD_LOADPSDEACTIONID, this.getLoadPSDEActionId());
        }
        if (!bl || this.isLoadPSDEActionNameDirty()) {
            hashMap.put(FIELD_LOADPSDEACTIONNAME, this.getLoadPSDEActionName());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobPSDEFormIdDirty()) {
            hashMap.put(FIELD_MOBPSDEFORMID, this.getMobPSDEFormId());
        }
        if (!bl || this.isMobPSDEFormNameDirty()) {
            hashMap.put(FIELD_MOBPSDEFORMNAME, this.getMobPSDEFormName());
        }
        if (!bl || this.isNextEnableLogicDirty()) {
            hashMap.put(FIELD_NEXTENABLELOGIC, this.getNextEnableLogic());
        }
        if (!bl || this.isPrevEnableLogicDirty()) {
            hashMap.put(FIELD_PREVENABLELOGIC, this.getPrevEnableLogic());
        }
        if (!bl || this.isPrevPSDEActionIdDirty()) {
            hashMap.put(FIELD_PREVPSDEACTIONID, this.getPrevPSDEActionId());
        }
        if (!bl || this.isPrevPSDEActionNameDirty()) {
            hashMap.put(FIELD_PREVPSDEACTIONNAME, this.getPrevPSDEActionName());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEWizardFormIdDirty()) {
            hashMap.put(FIELD_PSDEWIZARDFORMID, this.getPSDEWizardFormId());
        }
        if (!bl || this.isPSDEWizardFormNameDirty()) {
            hashMap.put(FIELD_PSDEWIZARDFORMNAME, this.getPSDEWizardFormName());
        }
        if (!bl || this.isPSDEWizardIdDirty()) {
            hashMap.put(FIELD_PSDEWIZARDID, this.getPSDEWizardId());
        }
        if (!bl || this.isPSDEWizardNameDirty()) {
            hashMap.put(FIELD_PSDEWIZARDNAME, this.getPSDEWizardName());
        }
        if (!bl || this.isPSDEWizardStepIdDirty()) {
            hashMap.put(FIELD_PSDEWIZARDSTEPID, this.getPSDEWizardStepId());
        }
        if (!bl || this.isPSDEWizardStepNameDirty()) {
            hashMap.put(FIELD_PSDEWIZARDSTEPNAME, this.getPSDEWizardStepName());
        }
        if (!bl || this.isSavePSDEActionIdDirty()) {
            hashMap.put(FIELD_SAVEPSDEACTIONID, this.getSavePSDEActionId());
        }
        if (!bl || this.isSavePSDEActionNameDirty()) {
            hashMap.put(FIELD_SAVEPSDEACTIONNAME, this.getSavePSDEActionName());
        }
        if (!bl || this.isStepActionsDirty()) {
            hashMap.put(FIELD_STEPACTIONS, this.getStepActions());
        }
        if (!bl || this.isStepOrderValueDirty()) {
            hashMap.put(FIELD_STEPORDERVALUE, this.getStepOrderValue());
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
        return PSDEWizardFormBase.get(this, n);
    }

    private static Object get(PSDEWizardFormBase pSDEWizardFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEWizardFormBase.getCMPSLanResId();
            }
            case 1: {
                return pSDEWizardFormBase.getCMPSLanResId2();
            }
            case 2: {
                return pSDEWizardFormBase.getCMPSLanResName();
            }
            case 3: {
                return pSDEWizardFormBase.getCMPSLanResName2();
            }
            case 4: {
                return pSDEWizardFormBase.getConfirmInfo();
            }
            case 5: {
                return pSDEWizardFormBase.getConfirmInfo2();
            }
            case 6: {
                return pSDEWizardFormBase.getCreateDate();
            }
            case 7: {
                return pSDEWizardFormBase.getCreateMan();
            }
            case 8: {
                return pSDEWizardFormBase.getFinishEnableLogic();
            }
            case 9: {
                return pSDEWizardFormBase.getFirstForm();
            }
            case 10: {
                return pSDEWizardFormBase.getFormTag();
            }
            case 11: {
                return pSDEWizardFormBase.getLoadPSDEActionId();
            }
            case 12: {
                return pSDEWizardFormBase.getLoadPSDEActionName();
            }
            case 13: {
                return pSDEWizardFormBase.getLogicName();
            }
            case 14: {
                return pSDEWizardFormBase.getMemo();
            }
            case 15: {
                return pSDEWizardFormBase.getMobPSDEFormId();
            }
            case 16: {
                return pSDEWizardFormBase.getMobPSDEFormName();
            }
            case 17: {
                return pSDEWizardFormBase.getNextEnableLogic();
            }
            case 18: {
                return pSDEWizardFormBase.getPrevEnableLogic();
            }
            case 19: {
                return pSDEWizardFormBase.getPrevPSDEActionId();
            }
            case 20: {
                return pSDEWizardFormBase.getPrevPSDEActionName();
            }
            case 21: {
                return pSDEWizardFormBase.getPSDEFormId();
            }
            case 22: {
                return pSDEWizardFormBase.getPSDEFormName();
            }
            case 23: {
                return pSDEWizardFormBase.getPSDEId();
            }
            case 24: {
                return pSDEWizardFormBase.getPSDEWizardFormId();
            }
            case 25: {
                return pSDEWizardFormBase.getPSDEWizardFormName();
            }
            case 26: {
                return pSDEWizardFormBase.getPSDEWizardId();
            }
            case 27: {
                return pSDEWizardFormBase.getPSDEWizardName();
            }
            case 28: {
                return pSDEWizardFormBase.getPSDEWizardStepId();
            }
            case 29: {
                return pSDEWizardFormBase.getPSDEWizardStepName();
            }
            case 30: {
                return pSDEWizardFormBase.getSavePSDEActionId();
            }
            case 31: {
                return pSDEWizardFormBase.getSavePSDEActionName();
            }
            case 32: {
                return pSDEWizardFormBase.getStepActions();
            }
            case 33: {
                return pSDEWizardFormBase.getStepOrderValue();
            }
            case 34: {
                return pSDEWizardFormBase.getUpdateDate();
            }
            case 35: {
                return pSDEWizardFormBase.getUpdateMan();
            }
            case 36: {
                return pSDEWizardFormBase.getUserCat();
            }
            case 37: {
                return pSDEWizardFormBase.getUserTag();
            }
            case 38: {
                return pSDEWizardFormBase.getUserTag2();
            }
            case 39: {
                return pSDEWizardFormBase.getUserTag3();
            }
            case 40: {
                return pSDEWizardFormBase.getUserTag4();
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
        PSDEWizardFormBase.set(this, n, object);
    }

    private static void set(PSDEWizardFormBase pSDEWizardFormBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEWizardFormBase.setCMPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEWizardFormBase.setCMPSLanResId2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEWizardFormBase.setCMPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEWizardFormBase.setCMPSLanResName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEWizardFormBase.setConfirmInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEWizardFormBase.setConfirmInfo2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEWizardFormBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDEWizardFormBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEWizardFormBase.setFinishEnableLogic(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEWizardFormBase.setFirstForm(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEWizardFormBase.setFormTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEWizardFormBase.setLoadPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEWizardFormBase.setLoadPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEWizardFormBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEWizardFormBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEWizardFormBase.setMobPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEWizardFormBase.setMobPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEWizardFormBase.setNextEnableLogic(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEWizardFormBase.setPrevEnableLogic(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEWizardFormBase.setPrevPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEWizardFormBase.setPrevPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEWizardFormBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEWizardFormBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEWizardFormBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEWizardFormBase.setPSDEWizardFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEWizardFormBase.setPSDEWizardFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEWizardFormBase.setPSDEWizardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEWizardFormBase.setPSDEWizardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEWizardFormBase.setPSDEWizardStepId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEWizardFormBase.setPSDEWizardStepName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEWizardFormBase.setSavePSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEWizardFormBase.setSavePSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEWizardFormBase.setStepActions(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEWizardFormBase.setStepOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDEWizardFormBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 35: {
                pSDEWizardFormBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEWizardFormBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEWizardFormBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEWizardFormBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEWizardFormBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEWizardFormBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEWizardFormBase.isNull(this, n);
    }

    private static boolean isNull(PSDEWizardFormBase pSDEWizardFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEWizardFormBase.getCMPSLanResId() == null;
            }
            case 1: {
                return pSDEWizardFormBase.getCMPSLanResId2() == null;
            }
            case 2: {
                return pSDEWizardFormBase.getCMPSLanResName() == null;
            }
            case 3: {
                return pSDEWizardFormBase.getCMPSLanResName2() == null;
            }
            case 4: {
                return pSDEWizardFormBase.getConfirmInfo() == null;
            }
            case 5: {
                return pSDEWizardFormBase.getConfirmInfo2() == null;
            }
            case 6: {
                return pSDEWizardFormBase.getCreateDate() == null;
            }
            case 7: {
                return pSDEWizardFormBase.getCreateMan() == null;
            }
            case 8: {
                return pSDEWizardFormBase.getFinishEnableLogic() == null;
            }
            case 9: {
                return pSDEWizardFormBase.getFirstForm() == null;
            }
            case 10: {
                return pSDEWizardFormBase.getFormTag() == null;
            }
            case 11: {
                return pSDEWizardFormBase.getLoadPSDEActionId() == null;
            }
            case 12: {
                return pSDEWizardFormBase.getLoadPSDEActionName() == null;
            }
            case 13: {
                return pSDEWizardFormBase.getLogicName() == null;
            }
            case 14: {
                return pSDEWizardFormBase.getMemo() == null;
            }
            case 15: {
                return pSDEWizardFormBase.getMobPSDEFormId() == null;
            }
            case 16: {
                return pSDEWizardFormBase.getMobPSDEFormName() == null;
            }
            case 17: {
                return pSDEWizardFormBase.getNextEnableLogic() == null;
            }
            case 18: {
                return pSDEWizardFormBase.getPrevEnableLogic() == null;
            }
            case 19: {
                return pSDEWizardFormBase.getPrevPSDEActionId() == null;
            }
            case 20: {
                return pSDEWizardFormBase.getPrevPSDEActionName() == null;
            }
            case 21: {
                return pSDEWizardFormBase.getPSDEFormId() == null;
            }
            case 22: {
                return pSDEWizardFormBase.getPSDEFormName() == null;
            }
            case 23: {
                return pSDEWizardFormBase.getPSDEId() == null;
            }
            case 24: {
                return pSDEWizardFormBase.getPSDEWizardFormId() == null;
            }
            case 25: {
                return pSDEWizardFormBase.getPSDEWizardFormName() == null;
            }
            case 26: {
                return pSDEWizardFormBase.getPSDEWizardId() == null;
            }
            case 27: {
                return pSDEWizardFormBase.getPSDEWizardName() == null;
            }
            case 28: {
                return pSDEWizardFormBase.getPSDEWizardStepId() == null;
            }
            case 29: {
                return pSDEWizardFormBase.getPSDEWizardStepName() == null;
            }
            case 30: {
                return pSDEWizardFormBase.getSavePSDEActionId() == null;
            }
            case 31: {
                return pSDEWizardFormBase.getSavePSDEActionName() == null;
            }
            case 32: {
                return pSDEWizardFormBase.getStepActions() == null;
            }
            case 33: {
                return pSDEWizardFormBase.getStepOrderValue() == null;
            }
            case 34: {
                return pSDEWizardFormBase.getUpdateDate() == null;
            }
            case 35: {
                return pSDEWizardFormBase.getUpdateMan() == null;
            }
            case 36: {
                return pSDEWizardFormBase.getUserCat() == null;
            }
            case 37: {
                return pSDEWizardFormBase.getUserTag() == null;
            }
            case 38: {
                return pSDEWizardFormBase.getUserTag2() == null;
            }
            case 39: {
                return pSDEWizardFormBase.getUserTag3() == null;
            }
            case 40: {
                return pSDEWizardFormBase.getUserTag4() == null;
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
        return PSDEWizardFormBase.contains(this, n);
    }

    private static boolean contains(PSDEWizardFormBase pSDEWizardFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEWizardFormBase.isCMPSLanResIdDirty();
            }
            case 1: {
                return pSDEWizardFormBase.isCMPSLanResId2Dirty();
            }
            case 2: {
                return pSDEWizardFormBase.isCMPSLanResNameDirty();
            }
            case 3: {
                return pSDEWizardFormBase.isCMPSLanResName2Dirty();
            }
            case 4: {
                return pSDEWizardFormBase.isConfirmInfoDirty();
            }
            case 5: {
                return pSDEWizardFormBase.isConfirmInfo2Dirty();
            }
            case 6: {
                return pSDEWizardFormBase.isCreateDateDirty();
            }
            case 7: {
                return pSDEWizardFormBase.isCreateManDirty();
            }
            case 8: {
                return pSDEWizardFormBase.isFinishEnableLogicDirty();
            }
            case 9: {
                return pSDEWizardFormBase.isFirstFormDirty();
            }
            case 10: {
                return pSDEWizardFormBase.isFormTagDirty();
            }
            case 11: {
                return pSDEWizardFormBase.isLoadPSDEActionIdDirty();
            }
            case 12: {
                return pSDEWizardFormBase.isLoadPSDEActionNameDirty();
            }
            case 13: {
                return pSDEWizardFormBase.isLogicNameDirty();
            }
            case 14: {
                return pSDEWizardFormBase.isMemoDirty();
            }
            case 15: {
                return pSDEWizardFormBase.isMobPSDEFormIdDirty();
            }
            case 16: {
                return pSDEWizardFormBase.isMobPSDEFormNameDirty();
            }
            case 17: {
                return pSDEWizardFormBase.isNextEnableLogicDirty();
            }
            case 18: {
                return pSDEWizardFormBase.isPrevEnableLogicDirty();
            }
            case 19: {
                return pSDEWizardFormBase.isPrevPSDEActionIdDirty();
            }
            case 20: {
                return pSDEWizardFormBase.isPrevPSDEActionNameDirty();
            }
            case 21: {
                return pSDEWizardFormBase.isPSDEFormIdDirty();
            }
            case 22: {
                return pSDEWizardFormBase.isPSDEFormNameDirty();
            }
            case 23: {
                return pSDEWizardFormBase.isPSDEIdDirty();
            }
            case 24: {
                return pSDEWizardFormBase.isPSDEWizardFormIdDirty();
            }
            case 25: {
                return pSDEWizardFormBase.isPSDEWizardFormNameDirty();
            }
            case 26: {
                return pSDEWizardFormBase.isPSDEWizardIdDirty();
            }
            case 27: {
                return pSDEWizardFormBase.isPSDEWizardNameDirty();
            }
            case 28: {
                return pSDEWizardFormBase.isPSDEWizardStepIdDirty();
            }
            case 29: {
                return pSDEWizardFormBase.isPSDEWizardStepNameDirty();
            }
            case 30: {
                return pSDEWizardFormBase.isSavePSDEActionIdDirty();
            }
            case 31: {
                return pSDEWizardFormBase.isSavePSDEActionNameDirty();
            }
            case 32: {
                return pSDEWizardFormBase.isStepActionsDirty();
            }
            case 33: {
                return pSDEWizardFormBase.isStepOrderValueDirty();
            }
            case 34: {
                return pSDEWizardFormBase.isUpdateDateDirty();
            }
            case 35: {
                return pSDEWizardFormBase.isUpdateManDirty();
            }
            case 36: {
                return pSDEWizardFormBase.isUserCatDirty();
            }
            case 37: {
                return pSDEWizardFormBase.isUserTagDirty();
            }
            case 38: {
                return pSDEWizardFormBase.isUserTag2Dirty();
            }
            case 39: {
                return pSDEWizardFormBase.isUserTag3Dirty();
            }
            case 40: {
                return pSDEWizardFormBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEWizardFormBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEWizardFormBase pSDEWizardFormBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEWizardFormBase.getCMPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cmpslanresid", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getCMPSLanResId()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getCMPSLanResId2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cmpslanresid2", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getCMPSLanResId2()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getCMPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cmpslanresname", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getCMPSLanResName()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getCMPSLanResName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cmpslanresname2", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getCMPSLanResName2()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getConfirmInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"confirminfo", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getConfirmInfo()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getConfirmInfo2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"confirminfo2", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getConfirmInfo2()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getFinishEnableLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishenablelogic", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getFinishEnableLogic()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getFirstForm() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"firstform", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getFirstForm()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getFormTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formtag", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getFormTag()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getLoadPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loadpsdeactionid", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getLoadPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getLoadPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loadpsdeactionname", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getLoadPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getMobPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeformid", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getMobPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getMobPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobpsdeformname", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getMobPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getNextEnableLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nextenablelogic", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getNextEnableLogic()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getPrevEnableLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prevenablelogic", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getPrevEnableLogic()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getPrevPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prevpsdeactionid", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getPrevPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getPrevPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prevpsdeactionname", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getPrevPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getPSDEWizardFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardformid", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getPSDEWizardFormId()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getPSDEWizardFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardformname", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getPSDEWizardFormName()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getPSDEWizardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardid", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getPSDEWizardId()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getPSDEWizardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardname", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getPSDEWizardName()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getPSDEWizardStepId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardstepid", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getPSDEWizardStepId()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getPSDEWizardStepName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardstepname", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getPSDEWizardStepName()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getSavePSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"savepsdeactionid", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getSavePSDEActionId()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getSavePSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"savepsdeactionname", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getSavePSDEActionName()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getStepActions() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stepactions", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getStepActions()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getStepOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stepordervalue", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getStepOrderValue()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEWizardFormBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEWizardFormBase.getJSONValue((Object)pSDEWizardFormBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEWizardFormBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEWizardFormBase pSDEWizardFormBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEWizardFormBase.getCMPSLanResId() != null) {
            object = pSDEWizardFormBase.getCMPSLanResId();
            xmlNode.setAttribute(FIELD_CMPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEWizardFormBase.getCMPSLanResId2() != null) {
            object = pSDEWizardFormBase.getCMPSLanResId2();
            xmlNode.setAttribute(FIELD_CMPSLANRESID2, (String)(object == null ? "" : object));
        }
        if (bl || pSDEWizardFormBase.getCMPSLanResName() != null) {
            object = pSDEWizardFormBase.getCMPSLanResName();
            xmlNode.setAttribute(FIELD_CMPSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEWizardFormBase.getCMPSLanResName2() != null) {
            object = pSDEWizardFormBase.getCMPSLanResName2();
            xmlNode.setAttribute(FIELD_CMPSLANRESNAME2, (String)(object == null ? "" : object));
        }
        if (bl || pSDEWizardFormBase.getConfirmInfo() != null) {
            object = pSDEWizardFormBase.getConfirmInfo();
            xmlNode.setAttribute(FIELD_CONFIRMINFO, (String)(object == null ? "" : object));
        }
        if (bl || pSDEWizardFormBase.getConfirmInfo2() != null) {
            object = pSDEWizardFormBase.getConfirmInfo2();
            xmlNode.setAttribute(FIELD_CONFIRMINFO2, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getCreateDate() != null) {
            object = pSDEWizardFormBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEWizardFormBase.getCreateMan() != null) {
            object = pSDEWizardFormBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getFinishEnableLogic() != null) {
            object = pSDEWizardFormBase.getFinishEnableLogic();
            xmlNode.setAttribute(FIELD_FINISHENABLELOGIC, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getFirstForm() != null) {
            object = pSDEWizardFormBase.getFirstForm();
            xmlNode.setAttribute(FIELD_FIRSTFORM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEWizardFormBase.getFormTag() != null) {
            object = pSDEWizardFormBase.getFormTag();
            xmlNode.setAttribute(FIELD_FORMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getLoadPSDEActionId() != null) {
            object = pSDEWizardFormBase.getLoadPSDEActionId();
            xmlNode.setAttribute(FIELD_LOADPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getLoadPSDEActionName() != null) {
            object = pSDEWizardFormBase.getLoadPSDEActionName();
            xmlNode.setAttribute(FIELD_LOADPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getLogicName() != null) {
            object = pSDEWizardFormBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getMemo() != null) {
            object = pSDEWizardFormBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getMobPSDEFormId() != null) {
            object = pSDEWizardFormBase.getMobPSDEFormId();
            xmlNode.setAttribute(FIELD_MOBPSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getMobPSDEFormName() != null) {
            object = pSDEWizardFormBase.getMobPSDEFormName();
            xmlNode.setAttribute(FIELD_MOBPSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getNextEnableLogic() != null) {
            object = pSDEWizardFormBase.getNextEnableLogic();
            xmlNode.setAttribute(FIELD_NEXTENABLELOGIC, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getPrevEnableLogic() != null) {
            object = pSDEWizardFormBase.getPrevEnableLogic();
            xmlNode.setAttribute(FIELD_PREVENABLELOGIC, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getPrevPSDEActionId() != null) {
            object = pSDEWizardFormBase.getPrevPSDEActionId();
            xmlNode.setAttribute(FIELD_PREVPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getPrevPSDEActionName() != null) {
            object = pSDEWizardFormBase.getPrevPSDEActionName();
            xmlNode.setAttribute(FIELD_PREVPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getPSDEFormId() != null) {
            object = pSDEWizardFormBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getPSDEFormName() != null) {
            object = pSDEWizardFormBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getPSDEId() != null) {
            object = pSDEWizardFormBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getPSDEWizardFormId() != null) {
            object = pSDEWizardFormBase.getPSDEWizardFormId();
            xmlNode.setAttribute(FIELD_PSDEWIZARDFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getPSDEWizardFormName() != null) {
            object = pSDEWizardFormBase.getPSDEWizardFormName();
            xmlNode.setAttribute(FIELD_PSDEWIZARDFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getPSDEWizardId() != null) {
            object = pSDEWizardFormBase.getPSDEWizardId();
            xmlNode.setAttribute(FIELD_PSDEWIZARDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getPSDEWizardName() != null) {
            object = pSDEWizardFormBase.getPSDEWizardName();
            xmlNode.setAttribute(FIELD_PSDEWIZARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getPSDEWizardStepId() != null) {
            object = pSDEWizardFormBase.getPSDEWizardStepId();
            xmlNode.setAttribute(FIELD_PSDEWIZARDSTEPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getPSDEWizardStepName() != null) {
            object = pSDEWizardFormBase.getPSDEWizardStepName();
            xmlNode.setAttribute(FIELD_PSDEWIZARDSTEPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getSavePSDEActionId() != null) {
            object = pSDEWizardFormBase.getSavePSDEActionId();
            xmlNode.setAttribute(FIELD_SAVEPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getSavePSDEActionName() != null) {
            object = pSDEWizardFormBase.getSavePSDEActionName();
            xmlNode.setAttribute(FIELD_SAVEPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getStepActions() != null) {
            object = pSDEWizardFormBase.getStepActions();
            xmlNode.setAttribute(FIELD_STEPACTIONS, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getStepOrderValue() != null) {
            object = pSDEWizardFormBase.getStepOrderValue();
            xmlNode.setAttribute(FIELD_STEPORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEWizardFormBase.getUpdateDate() != null) {
            object = pSDEWizardFormBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEWizardFormBase.getUpdateMan() != null) {
            object = pSDEWizardFormBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getUserCat() != null) {
            object = pSDEWizardFormBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getUserTag() != null) {
            object = pSDEWizardFormBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getUserTag2() != null) {
            object = pSDEWizardFormBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getUserTag3() != null) {
            object = pSDEWizardFormBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardFormBase.getUserTag4() != null) {
            object = pSDEWizardFormBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEWizardFormBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEWizardFormBase pSDEWizardFormBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEWizardFormBase.isCMPSLanResIdDirty() && (bl || pSDEWizardFormBase.getCMPSLanResId() != null)) {
            iDataObject.set(FIELD_CMPSLANRESID, (Object)pSDEWizardFormBase.getCMPSLanResId());
        }
        if (pSDEWizardFormBase.isCMPSLanResId2Dirty() && (bl || pSDEWizardFormBase.getCMPSLanResId2() != null)) {
            iDataObject.set(FIELD_CMPSLANRESID2, (Object)pSDEWizardFormBase.getCMPSLanResId2());
        }
        if (pSDEWizardFormBase.isCMPSLanResNameDirty() && (bl || pSDEWizardFormBase.getCMPSLanResName() != null)) {
            iDataObject.set(FIELD_CMPSLANRESNAME, (Object)pSDEWizardFormBase.getCMPSLanResName());
        }
        if (pSDEWizardFormBase.isCMPSLanResName2Dirty() && (bl || pSDEWizardFormBase.getCMPSLanResName2() != null)) {
            iDataObject.set(FIELD_CMPSLANRESNAME2, (Object)pSDEWizardFormBase.getCMPSLanResName2());
        }
        if (pSDEWizardFormBase.isConfirmInfoDirty() && (bl || pSDEWizardFormBase.getConfirmInfo() != null)) {
            iDataObject.set(FIELD_CONFIRMINFO, (Object)pSDEWizardFormBase.getConfirmInfo());
        }
        if (pSDEWizardFormBase.isConfirmInfo2Dirty() && (bl || pSDEWizardFormBase.getConfirmInfo2() != null)) {
            iDataObject.set(FIELD_CONFIRMINFO2, (Object)pSDEWizardFormBase.getConfirmInfo2());
        }
        if (pSDEWizardFormBase.isCreateDateDirty() && (bl || pSDEWizardFormBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEWizardFormBase.getCreateDate());
        }
        if (pSDEWizardFormBase.isCreateManDirty() && (bl || pSDEWizardFormBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEWizardFormBase.getCreateMan());
        }
        if (pSDEWizardFormBase.isFinishEnableLogicDirty() && (bl || pSDEWizardFormBase.getFinishEnableLogic() != null)) {
            iDataObject.set(FIELD_FINISHENABLELOGIC, (Object)pSDEWizardFormBase.getFinishEnableLogic());
        }
        if (pSDEWizardFormBase.isFirstFormDirty() && (bl || pSDEWizardFormBase.getFirstForm() != null)) {
            iDataObject.set(FIELD_FIRSTFORM, (Object)pSDEWizardFormBase.getFirstForm());
        }
        if (pSDEWizardFormBase.isFormTagDirty() && (bl || pSDEWizardFormBase.getFormTag() != null)) {
            iDataObject.set(FIELD_FORMTAG, (Object)pSDEWizardFormBase.getFormTag());
        }
        if (pSDEWizardFormBase.isLoadPSDEActionIdDirty() && (bl || pSDEWizardFormBase.getLoadPSDEActionId() != null)) {
            iDataObject.set(FIELD_LOADPSDEACTIONID, (Object)pSDEWizardFormBase.getLoadPSDEActionId());
        }
        if (pSDEWizardFormBase.isLoadPSDEActionNameDirty() && (bl || pSDEWizardFormBase.getLoadPSDEActionName() != null)) {
            iDataObject.set(FIELD_LOADPSDEACTIONNAME, (Object)pSDEWizardFormBase.getLoadPSDEActionName());
        }
        if (pSDEWizardFormBase.isLogicNameDirty() && (bl || pSDEWizardFormBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEWizardFormBase.getLogicName());
        }
        if (pSDEWizardFormBase.isMemoDirty() && (bl || pSDEWizardFormBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEWizardFormBase.getMemo());
        }
        if (pSDEWizardFormBase.isMobPSDEFormIdDirty() && (bl || pSDEWizardFormBase.getMobPSDEFormId() != null)) {
            iDataObject.set(FIELD_MOBPSDEFORMID, (Object)pSDEWizardFormBase.getMobPSDEFormId());
        }
        if (pSDEWizardFormBase.isMobPSDEFormNameDirty() && (bl || pSDEWizardFormBase.getMobPSDEFormName() != null)) {
            iDataObject.set(FIELD_MOBPSDEFORMNAME, (Object)pSDEWizardFormBase.getMobPSDEFormName());
        }
        if (pSDEWizardFormBase.isNextEnableLogicDirty() && (bl || pSDEWizardFormBase.getNextEnableLogic() != null)) {
            iDataObject.set(FIELD_NEXTENABLELOGIC, (Object)pSDEWizardFormBase.getNextEnableLogic());
        }
        if (pSDEWizardFormBase.isPrevEnableLogicDirty() && (bl || pSDEWizardFormBase.getPrevEnableLogic() != null)) {
            iDataObject.set(FIELD_PREVENABLELOGIC, (Object)pSDEWizardFormBase.getPrevEnableLogic());
        }
        if (pSDEWizardFormBase.isPrevPSDEActionIdDirty() && (bl || pSDEWizardFormBase.getPrevPSDEActionId() != null)) {
            iDataObject.set(FIELD_PREVPSDEACTIONID, (Object)pSDEWizardFormBase.getPrevPSDEActionId());
        }
        if (pSDEWizardFormBase.isPrevPSDEActionNameDirty() && (bl || pSDEWizardFormBase.getPrevPSDEActionName() != null)) {
            iDataObject.set(FIELD_PREVPSDEACTIONNAME, (Object)pSDEWizardFormBase.getPrevPSDEActionName());
        }
        if (pSDEWizardFormBase.isPSDEFormIdDirty() && (bl || pSDEWizardFormBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDEWizardFormBase.getPSDEFormId());
        }
        if (pSDEWizardFormBase.isPSDEFormNameDirty() && (bl || pSDEWizardFormBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDEWizardFormBase.getPSDEFormName());
        }
        if (pSDEWizardFormBase.isPSDEIdDirty() && (bl || pSDEWizardFormBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEWizardFormBase.getPSDEId());
        }
        if (pSDEWizardFormBase.isPSDEWizardFormIdDirty() && (bl || pSDEWizardFormBase.getPSDEWizardFormId() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDFORMID, (Object)pSDEWizardFormBase.getPSDEWizardFormId());
        }
        if (pSDEWizardFormBase.isPSDEWizardFormNameDirty() && (bl || pSDEWizardFormBase.getPSDEWizardFormName() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDFORMNAME, (Object)pSDEWizardFormBase.getPSDEWizardFormName());
        }
        if (pSDEWizardFormBase.isPSDEWizardIdDirty() && (bl || pSDEWizardFormBase.getPSDEWizardId() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDID, (Object)pSDEWizardFormBase.getPSDEWizardId());
        }
        if (pSDEWizardFormBase.isPSDEWizardNameDirty() && (bl || pSDEWizardFormBase.getPSDEWizardName() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDNAME, (Object)pSDEWizardFormBase.getPSDEWizardName());
        }
        if (pSDEWizardFormBase.isPSDEWizardStepIdDirty() && (bl || pSDEWizardFormBase.getPSDEWizardStepId() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDSTEPID, (Object)pSDEWizardFormBase.getPSDEWizardStepId());
        }
        if (pSDEWizardFormBase.isPSDEWizardStepNameDirty() && (bl || pSDEWizardFormBase.getPSDEWizardStepName() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDSTEPNAME, (Object)pSDEWizardFormBase.getPSDEWizardStepName());
        }
        if (pSDEWizardFormBase.isSavePSDEActionIdDirty() && (bl || pSDEWizardFormBase.getSavePSDEActionId() != null)) {
            iDataObject.set(FIELD_SAVEPSDEACTIONID, (Object)pSDEWizardFormBase.getSavePSDEActionId());
        }
        if (pSDEWizardFormBase.isSavePSDEActionNameDirty() && (bl || pSDEWizardFormBase.getSavePSDEActionName() != null)) {
            iDataObject.set(FIELD_SAVEPSDEACTIONNAME, (Object)pSDEWizardFormBase.getSavePSDEActionName());
        }
        if (pSDEWizardFormBase.isStepActionsDirty() && (bl || pSDEWizardFormBase.getStepActions() != null)) {
            iDataObject.set(FIELD_STEPACTIONS, (Object)pSDEWizardFormBase.getStepActions());
        }
        if (pSDEWizardFormBase.isStepOrderValueDirty() && (bl || pSDEWizardFormBase.getStepOrderValue() != null)) {
            iDataObject.set(FIELD_STEPORDERVALUE, (Object)pSDEWizardFormBase.getStepOrderValue());
        }
        if (pSDEWizardFormBase.isUpdateDateDirty() && (bl || pSDEWizardFormBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEWizardFormBase.getUpdateDate());
        }
        if (pSDEWizardFormBase.isUpdateManDirty() && (bl || pSDEWizardFormBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEWizardFormBase.getUpdateMan());
        }
        if (pSDEWizardFormBase.isUserCatDirty() && (bl || pSDEWizardFormBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEWizardFormBase.getUserCat());
        }
        if (pSDEWizardFormBase.isUserTagDirty() && (bl || pSDEWizardFormBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEWizardFormBase.getUserTag());
        }
        if (pSDEWizardFormBase.isUserTag2Dirty() && (bl || pSDEWizardFormBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEWizardFormBase.getUserTag2());
        }
        if (pSDEWizardFormBase.isUserTag3Dirty() && (bl || pSDEWizardFormBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEWizardFormBase.getUserTag3());
        }
        if (pSDEWizardFormBase.isUserTag4Dirty() && (bl || pSDEWizardFormBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEWizardFormBase.getUserTag4());
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
        return PSDEWizardFormBase.remove(this, n);
    }

    private static boolean remove(PSDEWizardFormBase pSDEWizardFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEWizardFormBase.resetCMPSLanResId();
                return true;
            }
            case 1: {
                pSDEWizardFormBase.resetCMPSLanResId2();
                return true;
            }
            case 2: {
                pSDEWizardFormBase.resetCMPSLanResName();
                return true;
            }
            case 3: {
                pSDEWizardFormBase.resetCMPSLanResName2();
                return true;
            }
            case 4: {
                pSDEWizardFormBase.resetConfirmInfo();
                return true;
            }
            case 5: {
                pSDEWizardFormBase.resetConfirmInfo2();
                return true;
            }
            case 6: {
                pSDEWizardFormBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSDEWizardFormBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSDEWizardFormBase.resetFinishEnableLogic();
                return true;
            }
            case 9: {
                pSDEWizardFormBase.resetFirstForm();
                return true;
            }
            case 10: {
                pSDEWizardFormBase.resetFormTag();
                return true;
            }
            case 11: {
                pSDEWizardFormBase.resetLoadPSDEActionId();
                return true;
            }
            case 12: {
                pSDEWizardFormBase.resetLoadPSDEActionName();
                return true;
            }
            case 13: {
                pSDEWizardFormBase.resetLogicName();
                return true;
            }
            case 14: {
                pSDEWizardFormBase.resetMemo();
                return true;
            }
            case 15: {
                pSDEWizardFormBase.resetMobPSDEFormId();
                return true;
            }
            case 16: {
                pSDEWizardFormBase.resetMobPSDEFormName();
                return true;
            }
            case 17: {
                pSDEWizardFormBase.resetNextEnableLogic();
                return true;
            }
            case 18: {
                pSDEWizardFormBase.resetPrevEnableLogic();
                return true;
            }
            case 19: {
                pSDEWizardFormBase.resetPrevPSDEActionId();
                return true;
            }
            case 20: {
                pSDEWizardFormBase.resetPrevPSDEActionName();
                return true;
            }
            case 21: {
                pSDEWizardFormBase.resetPSDEFormId();
                return true;
            }
            case 22: {
                pSDEWizardFormBase.resetPSDEFormName();
                return true;
            }
            case 23: {
                pSDEWizardFormBase.resetPSDEId();
                return true;
            }
            case 24: {
                pSDEWizardFormBase.resetPSDEWizardFormId();
                return true;
            }
            case 25: {
                pSDEWizardFormBase.resetPSDEWizardFormName();
                return true;
            }
            case 26: {
                pSDEWizardFormBase.resetPSDEWizardId();
                return true;
            }
            case 27: {
                pSDEWizardFormBase.resetPSDEWizardName();
                return true;
            }
            case 28: {
                pSDEWizardFormBase.resetPSDEWizardStepId();
                return true;
            }
            case 29: {
                pSDEWizardFormBase.resetPSDEWizardStepName();
                return true;
            }
            case 30: {
                pSDEWizardFormBase.resetSavePSDEActionId();
                return true;
            }
            case 31: {
                pSDEWizardFormBase.resetSavePSDEActionName();
                return true;
            }
            case 32: {
                pSDEWizardFormBase.resetStepActions();
                return true;
            }
            case 33: {
                pSDEWizardFormBase.resetStepOrderValue();
                return true;
            }
            case 34: {
                pSDEWizardFormBase.resetUpdateDate();
                return true;
            }
            case 35: {
                pSDEWizardFormBase.resetUpdateMan();
                return true;
            }
            case 36: {
                pSDEWizardFormBase.resetUserCat();
                return true;
            }
            case 37: {
                pSDEWizardFormBase.resetUserTag();
                return true;
            }
            case 38: {
                pSDEWizardFormBase.resetUserTag2();
                return true;
            }
            case 39: {
                pSDEWizardFormBase.resetUserTag3();
                return true;
            }
            case 40: {
                pSDEWizardFormBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getLoadPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoadPSDEAction();
        }
        if (this.getLoadPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objLoadPSDEActionLock;
        synchronized (n) {
            if (this.loadpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getLoadPSDEActionId(), (Object)this.loadpsdeaction.getPSDEActionId()) != 0L) {
                this.loadpsdeaction = null;
            }
            if (this.loadpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getLoadPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.loadpsdeaction = pSDEAction;
            }
            return this.loadpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getPrevPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrevPSDEAction();
        }
        if (this.getPrevPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPrevPSDEActionLock;
        synchronized (n) {
            if (this.prevpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPrevPSDEActionId(), (Object)this.prevpsdeaction.getPSDEActionId()) != 0L) {
                this.prevpsdeaction = null;
            }
            if (this.prevpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPrevPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.prevpsdeaction = pSDEAction;
            }
            return this.prevpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getSavePSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSavePSDEAction();
        }
        if (this.getSavePSDEActionId() == null) {
            return null;
        }
        Integer n = this.objSavePSDEActionLock;
        synchronized (n) {
            if (this.savepsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getSavePSDEActionId(), (Object)this.savepsdeaction.getPSDEActionId()) != 0L) {
                this.savepsdeaction = null;
            }
            if (this.savepsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getSavePSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.savepsdeaction = pSDEAction;
            }
            return this.savepsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getMobPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobPSDEForm();
        }
        if (this.getMobPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objMobPSDEFormLock;
        synchronized (n) {
            if (this.mobpsdeform != null && DataTypeHelper.compare((int)25, (Object)this.getMobPSDEFormId(), (Object)this.mobpsdeform.getPSDEFormId()) != 0L) {
                this.mobpsdeform = null;
            }
            if (this.mobpsdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getMobPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.mobpsdeform = pSDEForm;
            }
            return this.mobpsdeform;
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
    public PSDEWizardStep getPSDEWizardStep() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardStep();
        }
        if (this.getPSDEWizardStepId() == null) {
            return null;
        }
        Integer n = this.objPSDEWizardStepLock;
        synchronized (n) {
            if (this.psdewizardstep != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEWizardStepId(), (Object)this.psdewizardstep.getPSDEWizardStepId()) != 0L) {
                this.psdewizardstep = null;
            }
            if (this.psdewizardstep == null) {
                PSDEWizardStep pSDEWizardStep = new PSDEWizardStep();
                pSDEWizardStep.setPSDEWizardStepId(this.getPSDEWizardStepId());
                PSDEWizardStepService pSDEWizardStepService = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
                pSDEWizardStepService.autoGet((IEntity)pSDEWizardStep);
                this.psdewizardstep = pSDEWizardStep;
            }
            return this.psdewizardstep;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEWizard getPSDEWizard() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizard();
        }
        if (this.getPSDEWizardId() == null) {
            return null;
        }
        Integer n = this.objPSDEWizardLock;
        synchronized (n) {
            if (this.psdewizard != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEWizardId(), (Object)this.psdewizard.getPSDEWizardId()) != 0L) {
                this.psdewizard = null;
            }
            if (this.psdewizard == null) {
                PSDEWizard pSDEWizard = new PSDEWizard();
                pSDEWizard.setPSDEWizardId(this.getPSDEWizardId());
                PSDEWizardService pSDEWizardService = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
                pSDEWizardService.autoGet((IEntity)pSDEWizard);
                this.psdewizard = pSDEWizard;
            }
            return this.psdewizard;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getCMPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCMPSLanRes();
        }
        if (this.getCMPSLanResId() == null) {
            return null;
        }
        Integer n = this.objCMPSLanResLock;
        synchronized (n) {
            if (this.cmpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getCMPSLanResId(), (Object)this.cmpslanres.getPSLanguageResId()) != 0L) {
                this.cmpslanres = null;
            }
            if (this.cmpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getCMPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.cmpslanres = pSLanguageRes;
            }
            return this.cmpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getCM2PSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCM2PSLanRes();
        }
        if (this.getCMPSLanResId2() == null) {
            return null;
        }
        Integer n = this.objCM2PSLanResLock;
        synchronized (n) {
            if (this.cm2pslanres != null && DataTypeHelper.compare((int)25, (Object)this.getCMPSLanResId2(), (Object)this.cm2pslanres.getPSLanguageResId()) != 0L) {
                this.cm2pslanres = null;
            }
            if (this.cm2pslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getCMPSLanResId2());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.cm2pslanres = pSLanguageRes;
            }
            return this.cm2pslanres;
        }
    }

    private PSDEWizardFormBase getProxyEntity() {
        return this.proxyPSDEWizardFormBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEWizardFormBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEWizardFormBase) {
            this.proxyPSDEWizardFormBase = (PSDEWizardFormBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardFormService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CMPSLANRESID, 0);
        fieldIndexMap.put(FIELD_CMPSLANRESID2, 1);
        fieldIndexMap.put(FIELD_CMPSLANRESNAME, 2);
        fieldIndexMap.put(FIELD_CMPSLANRESNAME2, 3);
        fieldIndexMap.put(FIELD_CONFIRMINFO, 4);
        fieldIndexMap.put(FIELD_CONFIRMINFO2, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_FINISHENABLELOGIC, 8);
        fieldIndexMap.put(FIELD_FIRSTFORM, 9);
        fieldIndexMap.put(FIELD_FORMTAG, 10);
        fieldIndexMap.put(FIELD_LOADPSDEACTIONID, 11);
        fieldIndexMap.put(FIELD_LOADPSDEACTIONNAME, 12);
        fieldIndexMap.put(FIELD_LOGICNAME, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_MOBPSDEFORMID, 15);
        fieldIndexMap.put(FIELD_MOBPSDEFORMNAME, 16);
        fieldIndexMap.put(FIELD_NEXTENABLELOGIC, 17);
        fieldIndexMap.put(FIELD_PREVENABLELOGIC, 18);
        fieldIndexMap.put(FIELD_PREVPSDEACTIONID, 19);
        fieldIndexMap.put(FIELD_PREVPSDEACTIONNAME, 20);
        fieldIndexMap.put(FIELD_PSDEFORMID, 21);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 22);
        fieldIndexMap.put(FIELD_PSDEID, 23);
        fieldIndexMap.put(FIELD_PSDEWIZARDFORMID, 24);
        fieldIndexMap.put(FIELD_PSDEWIZARDFORMNAME, 25);
        fieldIndexMap.put(FIELD_PSDEWIZARDID, 26);
        fieldIndexMap.put(FIELD_PSDEWIZARDNAME, 27);
        fieldIndexMap.put(FIELD_PSDEWIZARDSTEPID, 28);
        fieldIndexMap.put(FIELD_PSDEWIZARDSTEPNAME, 29);
        fieldIndexMap.put(FIELD_SAVEPSDEACTIONID, 30);
        fieldIndexMap.put(FIELD_SAVEPSDEACTIONNAME, 31);
        fieldIndexMap.put(FIELD_STEPACTIONS, 32);
        fieldIndexMap.put(FIELD_STEPORDERVALUE, 33);
        fieldIndexMap.put(FIELD_UPDATEDATE, 34);
        fieldIndexMap.put(FIELD_UPDATEMAN, 35);
        fieldIndexMap.put(FIELD_USERCAT, 36);
        fieldIndexMap.put(FIELD_USERTAG, 37);
        fieldIndexMap.put(FIELD_USERTAG2, 38);
        fieldIndexMap.put(FIELD_USERTAG3, 39);
        fieldIndexMap.put(FIELD_USERTAG4, 40);
    }
}

