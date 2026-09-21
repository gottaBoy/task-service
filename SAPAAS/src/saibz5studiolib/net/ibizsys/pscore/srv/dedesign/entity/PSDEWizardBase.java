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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardStep;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEWizardBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEWizardBase.class);
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLEMSLOGIC = "ENABLEMSLOGIC";
    public static final String FIELD_FINISHCAPTION = "FINISHCAPTION";
    public static final String FIELD_FINISHPSDEACTIONID = "FINISHPSDEACTIONID";
    public static final String FIELD_FINISHPSDEACTIONNAME = "FINISHPSDEACTIONNAME";
    public static final String FIELD_FINISHPSLANRESID = "FINISHPSLANRESID";
    public static final String FIELD_FINISHPSLANRESNAME = "FINISHPSLANRESNAME";
    public static final String FIELD_INITPSDEACTIONID = "INITPSDEACTIONID";
    public static final String FIELD_INITPSDEACTIONNAME = "INITPSDEACTIONNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NEXTCAPTION = "NEXTCAPTION";
    public static final String FIELD_NEXTPSLANRESID = "NEXTPSLANRESID";
    public static final String FIELD_NEXTPSLANRESNAME = "NEXTPSLANRESNAME";
    public static final String FIELD_PREVCAPTION = "PREVCAPTION";
    public static final String FIELD_PREVPSLANRESID = "PREVPSLANRESID";
    public static final String FIELD_PREVPSLANRESNAME = "PREVPSLANRESNAME";
    public static final String FIELD_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String FIELD_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String FIELD_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMSLOGICID = "PSDEMSLOGICID";
    public static final String FIELD_PSDEMSLOGICNAME = "PSDEMSLOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEWIZARDID = "PSDEWIZARDID";
    public static final String FIELD_PSDEWIZARDNAME = "PSDEWIZARDNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_STATEPSDEFID = "STATEPSDEFID";
    public static final String FIELD_STATEPSDEFNAME = "STATEPSDEFNAME";
    public static final String FIELD_STATEWIZARDFLAG = "STATEWIZARDFLAG";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_WIZARDSTYLE = "WIZARDSTYLE";
    private static final int INDEX_BUSYINDICATOR = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_ENABLEMSLOGIC = 4;
    private static final int INDEX_FINISHCAPTION = 5;
    private static final int INDEX_FINISHPSDEACTIONID = 6;
    private static final int INDEX_FINISHPSDEACTIONNAME = 7;
    private static final int INDEX_FINISHPSLANRESID = 8;
    private static final int INDEX_FINISHPSLANRESNAME = 9;
    private static final int INDEX_INITPSDEACTIONID = 10;
    private static final int INDEX_INITPSDEACTIONNAME = 11;
    private static final int INDEX_LOCKFLAG = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_NEXTCAPTION = 14;
    private static final int INDEX_NEXTPSLANRESID = 15;
    private static final int INDEX_NEXTPSLANRESNAME = 16;
    private static final int INDEX_PREVCAPTION = 17;
    private static final int INDEX_PREVPSLANRESID = 18;
    private static final int INDEX_PREVPSLANRESNAME = 19;
    private static final int INDEX_PSCTRLLOGICGROUPID = 20;
    private static final int INDEX_PSCTRLLOGICGROUPNAME = 21;
    private static final int INDEX_PSCTRLMSGID = 22;
    private static final int INDEX_PSCTRLMSGNAME = 23;
    private static final int INDEX_PSDEID = 24;
    private static final int INDEX_PSDEMSLOGICID = 25;
    private static final int INDEX_PSDEMSLOGICNAME = 26;
    private static final int INDEX_PSDENAME = 27;
    private static final int INDEX_PSDEWIZARDID = 28;
    private static final int INDEX_PSDEWIZARDNAME = 29;
    private static final int INDEX_PSSYSCSSID = 30;
    private static final int INDEX_PSSYSCSSNAME = 31;
    private static final int INDEX_PSSYSPFPLUGINID = 32;
    private static final int INDEX_PSSYSPFPLUGINNAME = 33;
    private static final int INDEX_PSSYSREQITEMID = 34;
    private static final int INDEX_PSSYSREQITEMNAME = 35;
    private static final int INDEX_PSVIEWMSGGROUPID = 36;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 37;
    private static final int INDEX_STATEPSDEFID = 38;
    private static final int INDEX_STATEPSDEFNAME = 39;
    private static final int INDEX_STATEWIZARDFLAG = 40;
    private static final int INDEX_TODOTASK = 41;
    private static final int INDEX_UPDATEDATE = 42;
    private static final int INDEX_UPDATEMAN = 43;
    private static final int INDEX_USERCAT = 44;
    private static final int INDEX_USERTAG = 45;
    private static final int INDEX_USERTAG2 = 46;
    private static final int INDEX_USERTAG3 = 47;
    private static final int INDEX_USERTAG4 = 48;
    private static final int INDEX_WIZARDSTYLE = 49;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEWizardBase proxyPSDEWizardBase = null;
    private boolean busyindicatorDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablemslogicDirtyFlag = false;
    private boolean finishcaptionDirtyFlag = false;
    private boolean finishpsdeactionidDirtyFlag = false;
    private boolean finishpsdeactionnameDirtyFlag = false;
    private boolean finishpslanresidDirtyFlag = false;
    private boolean finishpslanresnameDirtyFlag = false;
    private boolean initpsdeactionidDirtyFlag = false;
    private boolean initpsdeactionnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean nextcaptionDirtyFlag = false;
    private boolean nextpslanresidDirtyFlag = false;
    private boolean nextpslanresnameDirtyFlag = false;
    private boolean prevcaptionDirtyFlag = false;
    private boolean prevpslanresidDirtyFlag = false;
    private boolean prevpslanresnameDirtyFlag = false;
    private boolean psctrllogicgroupidDirtyFlag = false;
    private boolean psctrllogicgroupnameDirtyFlag = false;
    private boolean psctrlmsgidDirtyFlag = false;
    private boolean psctrlmsgnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemslogicidDirtyFlag = false;
    private boolean psdemslogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdewizardidDirtyFlag = false;
    private boolean psdewizardnameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean statepsdefidDirtyFlag = false;
    private boolean statepsdefnameDirtyFlag = false;
    private boolean statewizardflagDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean wizardstyleDirtyFlag = false;
    @Column(name="busyindicator")
    private Integer busyindicator;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enablemslogic")
    private Integer enablemslogic;
    @Column(name="finishcaption")
    private String finishcaption;
    @Column(name="finishpsdeactionid")
    private String finishpsdeactionid;
    @Column(name="finishpsdeactionname")
    private String finishpsdeactionname;
    @Column(name="finishpslanresid")
    private String finishpslanresid;
    @Column(name="finishpslanresname")
    private String finishpslanresname;
    @Column(name="initpsdeactionid")
    private String initpsdeactionid;
    @Column(name="initpsdeactionname")
    private String initpsdeactionname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="nextcaption")
    private String nextcaption;
    @Column(name="nextpslanresid")
    private String nextpslanresid;
    @Column(name="nextpslanresname")
    private String nextpslanresname;
    @Column(name="prevcaption")
    private String prevcaption;
    @Column(name="prevpslanresid")
    private String prevpslanresid;
    @Column(name="prevpslanresname")
    private String prevpslanresname;
    @Column(name="psctrllogicgroupid")
    private String psctrllogicgroupid;
    @Column(name="psctrllogicgroupname")
    private String psctrllogicgroupname;
    @Column(name="psctrlmsgid")
    private String psctrlmsgid;
    @Column(name="psctrlmsgname")
    private String psctrlmsgname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemslogicid")
    private String psdemslogicid;
    @Column(name="psdemslogicname")
    private String psdemslogicname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdewizardid")
    private String psdewizardid;
    @Column(name="psdewizardname")
    private String psdewizardname;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
    @Column(name="statepsdefid")
    private String statepsdefid;
    @Column(name="statepsdefname")
    private String statepsdefname;
    @Column(name="statewizardflag")
    private Integer statewizardflag;
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
    @Column(name="wizardstyle")
    private String wizardstyle;
    private Integer objPSCtrlLogicGroupLock = new Integer(1);
    private PSCtrlLogicGroup psctrllogicgroup = null;
    private Integer objPSCtrlMsgLock = new Integer(1);
    private PSCtrlMsg psctrlmsg = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objFinishPSDEActionLock = new Integer(1);
    private PSDEAction finishpsdeaction = null;
    private Integer objInitPSDEActionLock = new Integer(1);
    private PSDEAction initpsdeaction = null;
    private Integer objStatePSDEFLock = new Integer(1);
    private PSDEField statepsdef = null;
    private Integer objPSDEMSLogicLock = new Integer(1);
    private PSDELogic psdemslogic = null;
    private Integer objFinishPSLanResLock = new Integer(1);
    private PSLanguageRes finishpslanres = null;
    private Integer objNextPSLanResLock = new Integer(1);
    private PSLanguageRes nextpslanres = null;
    private Integer objPrevPSLanResLock = new Integer(1);
    private PSLanguageRes prevpslanres = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSDEWizardLogicsLock = new Integer(1);
    private ArrayList<PSDEWizardLogic> psdewizardlogics = null;
    private Integer objPSDEWizardStepsLock = new Integer(1);
    private ArrayList<PSDEWizardStep> psdewizardsteps = null;

    public void setBusyIndicator(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBusyIndicator(n);
            return;
        }
        this.busyindicator = n;
        this.busyindicatorDirtyFlag = true;
    }

    public Integer getBusyIndicator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBusyIndicator();
        }
        return this.busyindicator;
    }

    public boolean isBusyIndicatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBusyIndicatorDirty();
        }
        return this.busyindicatorDirtyFlag;
    }

    public void resetBusyIndicator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBusyIndicator();
            return;
        }
        this.busyindicatorDirtyFlag = false;
        this.busyindicator = null;
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

    public void setEnableMSLogic(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableMSLogic(n);
            return;
        }
        this.enablemslogic = n;
        this.enablemslogicDirtyFlag = true;
    }

    public Integer getEnableMSLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableMSLogic();
        }
        return this.enablemslogic;
    }

    public boolean isEnableMSLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableMSLogicDirty();
        }
        return this.enablemslogicDirtyFlag;
    }

    public void resetEnableMSLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableMSLogic();
            return;
        }
        this.enablemslogicDirtyFlag = false;
        this.enablemslogic = null;
    }

    public void setFinishCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.finishcaption = string;
        this.finishcaptionDirtyFlag = true;
    }

    public String getFinishCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishCaption();
        }
        return this.finishcaption;
    }

    public boolean isFinishCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishCaptionDirty();
        }
        return this.finishcaptionDirtyFlag;
    }

    public void resetFinishCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishCaption();
            return;
        }
        this.finishcaptionDirtyFlag = false;
        this.finishcaption = null;
    }

    public void setFinishPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.finishpsdeactionid = string;
        this.finishpsdeactionidDirtyFlag = true;
    }

    public String getFinishPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishPSDEActionId();
        }
        return this.finishpsdeactionid;
    }

    public boolean isFinishPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishPSDEActionIdDirty();
        }
        return this.finishpsdeactionidDirtyFlag;
    }

    public void resetFinishPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishPSDEActionId();
            return;
        }
        this.finishpsdeactionidDirtyFlag = false;
        this.finishpsdeactionid = null;
    }

    public void setFinishPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.finishpsdeactionname = string;
        this.finishpsdeactionnameDirtyFlag = true;
    }

    public String getFinishPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishPSDEActionName();
        }
        return this.finishpsdeactionname;
    }

    public boolean isFinishPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishPSDEActionNameDirty();
        }
        return this.finishpsdeactionnameDirtyFlag;
    }

    public void resetFinishPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishPSDEActionName();
            return;
        }
        this.finishpsdeactionnameDirtyFlag = false;
        this.finishpsdeactionname = null;
    }

    public void setFinishPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.finishpslanresid = string;
        this.finishpslanresidDirtyFlag = true;
    }

    public String getFinishPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishPSLanResId();
        }
        return this.finishpslanresid;
    }

    public boolean isFinishPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishPSLanResIdDirty();
        }
        return this.finishpslanresidDirtyFlag;
    }

    public void resetFinishPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishPSLanResId();
            return;
        }
        this.finishpslanresidDirtyFlag = false;
        this.finishpslanresid = null;
    }

    public void setFinishPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.finishpslanresname = string;
        this.finishpslanresnameDirtyFlag = true;
    }

    public String getFinishPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishPSLanResName();
        }
        return this.finishpslanresname;
    }

    public boolean isFinishPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishPSLanResNameDirty();
        }
        return this.finishpslanresnameDirtyFlag;
    }

    public void resetFinishPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishPSLanResName();
            return;
        }
        this.finishpslanresnameDirtyFlag = false;
        this.finishpslanresname = null;
    }

    public void setInitPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.initpsdeactionid = string;
        this.initpsdeactionidDirtyFlag = true;
    }

    public String getInitPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPSDEActionId();
        }
        return this.initpsdeactionid;
    }

    public boolean isInitPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitPSDEActionIdDirty();
        }
        return this.initpsdeactionidDirtyFlag;
    }

    public void resetInitPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitPSDEActionId();
            return;
        }
        this.initpsdeactionidDirtyFlag = false;
        this.initpsdeactionid = null;
    }

    public void setInitPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInitPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.initpsdeactionname = string;
        this.initpsdeactionnameDirtyFlag = true;
    }

    public String getInitPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPSDEActionName();
        }
        return this.initpsdeactionname;
    }

    public boolean isInitPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInitPSDEActionNameDirty();
        }
        return this.initpsdeactionnameDirtyFlag;
    }

    public void resetInitPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInitPSDEActionName();
            return;
        }
        this.initpsdeactionnameDirtyFlag = false;
        this.initpsdeactionname = null;
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

    public void setNextCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNextCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nextcaption = string;
        this.nextcaptionDirtyFlag = true;
    }

    public String getNextCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextCaption();
        }
        return this.nextcaption;
    }

    public boolean isNextCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNextCaptionDirty();
        }
        return this.nextcaptionDirtyFlag;
    }

    public void resetNextCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNextCaption();
            return;
        }
        this.nextcaptionDirtyFlag = false;
        this.nextcaption = null;
    }

    public void setNextPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNextPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nextpslanresid = string;
        this.nextpslanresidDirtyFlag = true;
    }

    public String getNextPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextPSLanResId();
        }
        return this.nextpslanresid;
    }

    public boolean isNextPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNextPSLanResIdDirty();
        }
        return this.nextpslanresidDirtyFlag;
    }

    public void resetNextPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNextPSLanResId();
            return;
        }
        this.nextpslanresidDirtyFlag = false;
        this.nextpslanresid = null;
    }

    public void setNextPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNextPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nextpslanresname = string;
        this.nextpslanresnameDirtyFlag = true;
    }

    public String getNextPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextPSLanResName();
        }
        return this.nextpslanresname;
    }

    public boolean isNextPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNextPSLanResNameDirty();
        }
        return this.nextpslanresnameDirtyFlag;
    }

    public void resetNextPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNextPSLanResName();
            return;
        }
        this.nextpslanresnameDirtyFlag = false;
        this.nextpslanresname = null;
    }

    public void setPrevCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrevCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prevcaption = string;
        this.prevcaptionDirtyFlag = true;
    }

    public String getPrevCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrevCaption();
        }
        return this.prevcaption;
    }

    public boolean isPrevCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrevCaptionDirty();
        }
        return this.prevcaptionDirtyFlag;
    }

    public void resetPrevCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrevCaption();
            return;
        }
        this.prevcaptionDirtyFlag = false;
        this.prevcaption = null;
    }

    public void setPrevPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrevPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prevpslanresid = string;
        this.prevpslanresidDirtyFlag = true;
    }

    public String getPrevPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrevPSLanResId();
        }
        return this.prevpslanresid;
    }

    public boolean isPrevPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrevPSLanResIdDirty();
        }
        return this.prevpslanresidDirtyFlag;
    }

    public void resetPrevPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrevPSLanResId();
            return;
        }
        this.prevpslanresidDirtyFlag = false;
        this.prevpslanresid = null;
    }

    public void setPrevPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrevPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prevpslanresname = string;
        this.prevpslanresnameDirtyFlag = true;
    }

    public String getPrevPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrevPSLanResName();
        }
        return this.prevpslanresname;
    }

    public boolean isPrevPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrevPSLanResNameDirty();
        }
        return this.prevpslanresnameDirtyFlag;
    }

    public void resetPrevPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrevPSLanResName();
            return;
        }
        this.prevpslanresnameDirtyFlag = false;
        this.prevpslanresname = null;
    }

    public void setPSCtrlLogicGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupid = string;
        this.psctrllogicgroupidDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupId();
        }
        return this.psctrllogicgroupid;
    }

    public boolean isPSCtrlLogicGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupIdDirty();
        }
        return this.psctrllogicgroupidDirtyFlag;
    }

    public void resetPSCtrlLogicGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupId();
            return;
        }
        this.psctrllogicgroupidDirtyFlag = false;
        this.psctrllogicgroupid = null;
    }

    public void setPSCtrlLogicGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlLogicGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrllogicgroupname = string;
        this.psctrllogicgroupnameDirtyFlag = true;
    }

    public String getPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroupName();
        }
        return this.psctrllogicgroupname;
    }

    public boolean isPSCtrlLogicGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlLogicGroupNameDirty();
        }
        return this.psctrllogicgroupnameDirtyFlag;
    }

    public void resetPSCtrlLogicGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlLogicGroupName();
            return;
        }
        this.psctrllogicgroupnameDirtyFlag = false;
        this.psctrllogicgroupname = null;
    }

    public void setPSCtrlMsgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgid = string;
        this.psctrlmsgidDirtyFlag = true;
    }

    public String getPSCtrlMsgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgId();
        }
        return this.psctrlmsgid;
    }

    public boolean isPSCtrlMsgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgIdDirty();
        }
        return this.psctrlmsgidDirtyFlag;
    }

    public void resetPSCtrlMsgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgId();
            return;
        }
        this.psctrlmsgidDirtyFlag = false;
        this.psctrlmsgid = null;
    }

    public void setPSCtrlMsgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgname = string;
        this.psctrlmsgnameDirtyFlag = true;
    }

    public String getPSCtrlMsgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgName();
        }
        return this.psctrlmsgname;
    }

    public boolean isPSCtrlMsgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgNameDirty();
        }
        return this.psctrlmsgnameDirtyFlag;
    }

    public void resetPSCtrlMsgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgName();
            return;
        }
        this.psctrlmsgnameDirtyFlag = false;
        this.psctrlmsgname = null;
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

    public void setPSDEMSLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMSLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemslogicid = string;
        this.psdemslogicidDirtyFlag = true;
    }

    public String getPSDEMSLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSLogicId();
        }
        return this.psdemslogicid;
    }

    public boolean isPSDEMSLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMSLogicIdDirty();
        }
        return this.psdemslogicidDirtyFlag;
    }

    public void resetPSDEMSLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMSLogicId();
            return;
        }
        this.psdemslogicidDirtyFlag = false;
        this.psdemslogicid = null;
    }

    public void setPSDEMSLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMSLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemslogicname = string;
        this.psdemslogicnameDirtyFlag = true;
    }

    public String getPSDEMSLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSLogicName();
        }
        return this.psdemslogicname;
    }

    public boolean isPSDEMSLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMSLogicNameDirty();
        }
        return this.psdemslogicnameDirtyFlag;
    }

    public void resetPSDEMSLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMSLogicName();
            return;
        }
        this.psdemslogicnameDirtyFlag = false;
        this.psdemslogicname = null;
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

    public void setPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssid = string;
        this.pssyscssidDirtyFlag = true;
    }

    public String getPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssId();
        }
        return this.pssyscssid;
    }

    public boolean isPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssIdDirty();
        }
        return this.pssyscssidDirtyFlag;
    }

    public void resetPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssId();
            return;
        }
        this.pssyscssidDirtyFlag = false;
        this.pssyscssid = null;
    }

    public void setPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssname = string;
        this.pssyscssnameDirtyFlag = true;
    }

    public String getPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssName();
        }
        return this.pssyscssname;
    }

    public boolean isPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssNameDirty();
        }
        return this.pssyscssnameDirtyFlag;
    }

    public void resetPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssName();
            return;
        }
        this.pssyscssnameDirtyFlag = false;
        this.pssyscssname = null;
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

    public void setPSViewMsgGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupid = string;
        this.psviewmsggroupidDirtyFlag = true;
    }

    public String getPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupId();
        }
        return this.psviewmsggroupid;
    }

    public boolean isPSViewMsgGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupIdDirty();
        }
        return this.psviewmsggroupidDirtyFlag;
    }

    public void resetPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupId();
            return;
        }
        this.psviewmsggroupidDirtyFlag = false;
        this.psviewmsggroupid = null;
    }

    public void setPSViewMsgGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupname = string;
        this.psviewmsggroupnameDirtyFlag = true;
    }

    public String getPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupName();
        }
        return this.psviewmsggroupname;
    }

    public boolean isPSViewMsgGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupNameDirty();
        }
        return this.psviewmsggroupnameDirtyFlag;
    }

    public void resetPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupName();
            return;
        }
        this.psviewmsggroupnameDirtyFlag = false;
        this.psviewmsggroupname = null;
    }

    public void setStatePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStatePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.statepsdefid = string;
        this.statepsdefidDirtyFlag = true;
    }

    public String getStatePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStatePSDEFId();
        }
        return this.statepsdefid;
    }

    public boolean isStatePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStatePSDEFIdDirty();
        }
        return this.statepsdefidDirtyFlag;
    }

    public void resetStatePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStatePSDEFId();
            return;
        }
        this.statepsdefidDirtyFlag = false;
        this.statepsdefid = null;
    }

    public void setStatePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStatePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.statepsdefname = string;
        this.statepsdefnameDirtyFlag = true;
    }

    public String getStatePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStatePSDEFName();
        }
        return this.statepsdefname;
    }

    public boolean isStatePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStatePSDEFNameDirty();
        }
        return this.statepsdefnameDirtyFlag;
    }

    public void resetStatePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStatePSDEFName();
            return;
        }
        this.statepsdefnameDirtyFlag = false;
        this.statepsdefname = null;
    }

    public void setStateWizardFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStateWizardFlag(n);
            return;
        }
        this.statewizardflag = n;
        this.statewizardflagDirtyFlag = true;
    }

    public Integer getStateWizardFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStateWizardFlag();
        }
        return this.statewizardflag;
    }

    public boolean isStateWizardFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStateWizardFlagDirty();
        }
        return this.statewizardflagDirtyFlag;
    }

    public void resetStateWizardFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStateWizardFlag();
            return;
        }
        this.statewizardflagDirtyFlag = false;
        this.statewizardflag = null;
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

    public void setWizardStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardstyle = string;
        this.wizardstyleDirtyFlag = true;
    }

    public String getWizardStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardStyle();
        }
        return this.wizardstyle;
    }

    public boolean isWizardStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardStyleDirty();
        }
        return this.wizardstyleDirtyFlag;
    }

    public void resetWizardStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardStyle();
            return;
        }
        this.wizardstyleDirtyFlag = false;
        this.wizardstyle = null;
    }

    protected void onReset() {
        PSDEWizardBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEWizardBase pSDEWizardBase) {
        pSDEWizardBase.resetBusyIndicator();
        pSDEWizardBase.resetCodeName();
        pSDEWizardBase.resetCreateDate();
        pSDEWizardBase.resetCreateMan();
        pSDEWizardBase.resetEnableMSLogic();
        pSDEWizardBase.resetFinishCaption();
        pSDEWizardBase.resetFinishPSDEActionId();
        pSDEWizardBase.resetFinishPSDEActionName();
        pSDEWizardBase.resetFinishPSLanResId();
        pSDEWizardBase.resetFinishPSLanResName();
        pSDEWizardBase.resetInitPSDEActionId();
        pSDEWizardBase.resetInitPSDEActionName();
        pSDEWizardBase.resetLockFlag();
        pSDEWizardBase.resetMemo();
        pSDEWizardBase.resetNextCaption();
        pSDEWizardBase.resetNextPSLanResId();
        pSDEWizardBase.resetNextPSLanResName();
        pSDEWizardBase.resetPrevCaption();
        pSDEWizardBase.resetPrevPSLanResId();
        pSDEWizardBase.resetPrevPSLanResName();
        pSDEWizardBase.resetPSCtrlLogicGroupId();
        pSDEWizardBase.resetPSCtrlLogicGroupName();
        pSDEWizardBase.resetPSCtrlMsgId();
        pSDEWizardBase.resetPSCtrlMsgName();
        pSDEWizardBase.resetPSDEId();
        pSDEWizardBase.resetPSDEMSLogicId();
        pSDEWizardBase.resetPSDEMSLogicName();
        pSDEWizardBase.resetPSDEName();
        pSDEWizardBase.resetPSDEWizardId();
        pSDEWizardBase.resetPSDEWizardName();
        pSDEWizardBase.resetPSSysCssId();
        pSDEWizardBase.resetPSSysCssName();
        pSDEWizardBase.resetPSSysPFPluginId();
        pSDEWizardBase.resetPSSysPFPluginName();
        pSDEWizardBase.resetPSSysReqItemId();
        pSDEWizardBase.resetPSSysReqItemName();
        pSDEWizardBase.resetPSViewMsgGroupId();
        pSDEWizardBase.resetPSViewMsgGroupName();
        pSDEWizardBase.resetStatePSDEFId();
        pSDEWizardBase.resetStatePSDEFName();
        pSDEWizardBase.resetStateWizardFlag();
        pSDEWizardBase.resetToDoTask();
        pSDEWizardBase.resetUpdateDate();
        pSDEWizardBase.resetUpdateMan();
        pSDEWizardBase.resetUserCat();
        pSDEWizardBase.resetUserTag();
        pSDEWizardBase.resetUserTag2();
        pSDEWizardBase.resetUserTag3();
        pSDEWizardBase.resetUserTag4();
        pSDEWizardBase.resetWizardStyle();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBusyIndicatorDirty()) {
            hashMap.put(FIELD_BUSYINDICATOR, this.getBusyIndicator());
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
        if (!bl || this.isEnableMSLogicDirty()) {
            hashMap.put(FIELD_ENABLEMSLOGIC, this.getEnableMSLogic());
        }
        if (!bl || this.isFinishCaptionDirty()) {
            hashMap.put(FIELD_FINISHCAPTION, this.getFinishCaption());
        }
        if (!bl || this.isFinishPSDEActionIdDirty()) {
            hashMap.put(FIELD_FINISHPSDEACTIONID, this.getFinishPSDEActionId());
        }
        if (!bl || this.isFinishPSDEActionNameDirty()) {
            hashMap.put(FIELD_FINISHPSDEACTIONNAME, this.getFinishPSDEActionName());
        }
        if (!bl || this.isFinishPSLanResIdDirty()) {
            hashMap.put(FIELD_FINISHPSLANRESID, this.getFinishPSLanResId());
        }
        if (!bl || this.isFinishPSLanResNameDirty()) {
            hashMap.put(FIELD_FINISHPSLANRESNAME, this.getFinishPSLanResName());
        }
        if (!bl || this.isInitPSDEActionIdDirty()) {
            hashMap.put(FIELD_INITPSDEACTIONID, this.getInitPSDEActionId());
        }
        if (!bl || this.isInitPSDEActionNameDirty()) {
            hashMap.put(FIELD_INITPSDEACTIONNAME, this.getInitPSDEActionName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNextCaptionDirty()) {
            hashMap.put(FIELD_NEXTCAPTION, this.getNextCaption());
        }
        if (!bl || this.isNextPSLanResIdDirty()) {
            hashMap.put(FIELD_NEXTPSLANRESID, this.getNextPSLanResId());
        }
        if (!bl || this.isNextPSLanResNameDirty()) {
            hashMap.put(FIELD_NEXTPSLANRESNAME, this.getNextPSLanResName());
        }
        if (!bl || this.isPrevCaptionDirty()) {
            hashMap.put(FIELD_PREVCAPTION, this.getPrevCaption());
        }
        if (!bl || this.isPrevPSLanResIdDirty()) {
            hashMap.put(FIELD_PREVPSLANRESID, this.getPrevPSLanResId());
        }
        if (!bl || this.isPrevPSLanResNameDirty()) {
            hashMap.put(FIELD_PREVPSLANRESNAME, this.getPrevPSLanResName());
        }
        if (!bl || this.isPSCtrlLogicGroupIdDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPID, this.getPSCtrlLogicGroupId());
        }
        if (!bl || this.isPSCtrlLogicGroupNameDirty()) {
            hashMap.put(FIELD_PSCTRLLOGICGROUPNAME, this.getPSCtrlLogicGroupName());
        }
        if (!bl || this.isPSCtrlMsgIdDirty()) {
            hashMap.put(FIELD_PSCTRLMSGID, this.getPSCtrlMsgId());
        }
        if (!bl || this.isPSCtrlMsgNameDirty()) {
            hashMap.put(FIELD_PSCTRLMSGNAME, this.getPSCtrlMsgName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEMSLogicIdDirty()) {
            hashMap.put(FIELD_PSDEMSLOGICID, this.getPSDEMSLogicId());
        }
        if (!bl || this.isPSDEMSLogicNameDirty()) {
            hashMap.put(FIELD_PSDEMSLOGICNAME, this.getPSDEMSLogicName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEWizardIdDirty()) {
            hashMap.put(FIELD_PSDEWIZARDID, this.getPSDEWizardId());
        }
        if (!bl || this.isPSDEWizardNameDirty()) {
            hashMap.put(FIELD_PSDEWIZARDNAME, this.getPSDEWizardName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
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
        if (!bl || this.isPSViewMsgGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPID, this.getPSViewMsgGroupId());
        }
        if (!bl || this.isPSViewMsgGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPNAME, this.getPSViewMsgGroupName());
        }
        if (!bl || this.isStatePSDEFIdDirty()) {
            hashMap.put(FIELD_STATEPSDEFID, this.getStatePSDEFId());
        }
        if (!bl || this.isStatePSDEFNameDirty()) {
            hashMap.put(FIELD_STATEPSDEFNAME, this.getStatePSDEFName());
        }
        if (!bl || this.isStateWizardFlagDirty()) {
            hashMap.put(FIELD_STATEWIZARDFLAG, this.getStateWizardFlag());
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
        if (!bl || this.isWizardStyleDirty()) {
            hashMap.put(FIELD_WIZARDSTYLE, this.getWizardStyle());
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
        return PSDEWizardBase.get(this, n);
    }

    private static Object get(PSDEWizardBase pSDEWizardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEWizardBase.getBusyIndicator();
            }
            case 1: {
                return pSDEWizardBase.getCodeName();
            }
            case 2: {
                return pSDEWizardBase.getCreateDate();
            }
            case 3: {
                return pSDEWizardBase.getCreateMan();
            }
            case 4: {
                return pSDEWizardBase.getEnableMSLogic();
            }
            case 5: {
                return pSDEWizardBase.getFinishCaption();
            }
            case 6: {
                return pSDEWizardBase.getFinishPSDEActionId();
            }
            case 7: {
                return pSDEWizardBase.getFinishPSDEActionName();
            }
            case 8: {
                return pSDEWizardBase.getFinishPSLanResId();
            }
            case 9: {
                return pSDEWizardBase.getFinishPSLanResName();
            }
            case 10: {
                return pSDEWizardBase.getInitPSDEActionId();
            }
            case 11: {
                return pSDEWizardBase.getInitPSDEActionName();
            }
            case 12: {
                return pSDEWizardBase.getLockFlag();
            }
            case 13: {
                return pSDEWizardBase.getMemo();
            }
            case 14: {
                return pSDEWizardBase.getNextCaption();
            }
            case 15: {
                return pSDEWizardBase.getNextPSLanResId();
            }
            case 16: {
                return pSDEWizardBase.getNextPSLanResName();
            }
            case 17: {
                return pSDEWizardBase.getPrevCaption();
            }
            case 18: {
                return pSDEWizardBase.getPrevPSLanResId();
            }
            case 19: {
                return pSDEWizardBase.getPrevPSLanResName();
            }
            case 20: {
                return pSDEWizardBase.getPSCtrlLogicGroupId();
            }
            case 21: {
                return pSDEWizardBase.getPSCtrlLogicGroupName();
            }
            case 22: {
                return pSDEWizardBase.getPSCtrlMsgId();
            }
            case 23: {
                return pSDEWizardBase.getPSCtrlMsgName();
            }
            case 24: {
                return pSDEWizardBase.getPSDEId();
            }
            case 25: {
                return pSDEWizardBase.getPSDEMSLogicId();
            }
            case 26: {
                return pSDEWizardBase.getPSDEMSLogicName();
            }
            case 27: {
                return pSDEWizardBase.getPSDEName();
            }
            case 28: {
                return pSDEWizardBase.getPSDEWizardId();
            }
            case 29: {
                return pSDEWizardBase.getPSDEWizardName();
            }
            case 30: {
                return pSDEWizardBase.getPSSysCssId();
            }
            case 31: {
                return pSDEWizardBase.getPSSysCssName();
            }
            case 32: {
                return pSDEWizardBase.getPSSysPFPluginId();
            }
            case 33: {
                return pSDEWizardBase.getPSSysPFPluginName();
            }
            case 34: {
                return pSDEWizardBase.getPSSysReqItemId();
            }
            case 35: {
                return pSDEWizardBase.getPSSysReqItemName();
            }
            case 36: {
                return pSDEWizardBase.getPSViewMsgGroupId();
            }
            case 37: {
                return pSDEWizardBase.getPSViewMsgGroupName();
            }
            case 38: {
                return pSDEWizardBase.getStatePSDEFId();
            }
            case 39: {
                return pSDEWizardBase.getStatePSDEFName();
            }
            case 40: {
                return pSDEWizardBase.getStateWizardFlag();
            }
            case 41: {
                return pSDEWizardBase.getToDoTask();
            }
            case 42: {
                return pSDEWizardBase.getUpdateDate();
            }
            case 43: {
                return pSDEWizardBase.getUpdateMan();
            }
            case 44: {
                return pSDEWizardBase.getUserCat();
            }
            case 45: {
                return pSDEWizardBase.getUserTag();
            }
            case 46: {
                return pSDEWizardBase.getUserTag2();
            }
            case 47: {
                return pSDEWizardBase.getUserTag3();
            }
            case 48: {
                return pSDEWizardBase.getUserTag4();
            }
            case 49: {
                return pSDEWizardBase.getWizardStyle();
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
        PSDEWizardBase.set(this, n, object);
    }

    private static void set(PSDEWizardBase pSDEWizardBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEWizardBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEWizardBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEWizardBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDEWizardBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEWizardBase.setEnableMSLogic(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEWizardBase.setFinishCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEWizardBase.setFinishPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEWizardBase.setFinishPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEWizardBase.setFinishPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEWizardBase.setFinishPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEWizardBase.setInitPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEWizardBase.setInitPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEWizardBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEWizardBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEWizardBase.setNextCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEWizardBase.setNextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEWizardBase.setNextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEWizardBase.setPrevCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEWizardBase.setPrevPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEWizardBase.setPrevPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEWizardBase.setPSCtrlLogicGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEWizardBase.setPSCtrlLogicGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEWizardBase.setPSCtrlMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEWizardBase.setPSCtrlMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEWizardBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEWizardBase.setPSDEMSLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEWizardBase.setPSDEMSLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEWizardBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEWizardBase.setPSDEWizardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEWizardBase.setPSDEWizardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEWizardBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEWizardBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEWizardBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEWizardBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEWizardBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEWizardBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEWizardBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEWizardBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEWizardBase.setStatePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEWizardBase.setStatePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEWizardBase.setStateWizardFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 41: {
                pSDEWizardBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEWizardBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 43: {
                pSDEWizardBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEWizardBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEWizardBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEWizardBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEWizardBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEWizardBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEWizardBase.setWizardStyle(DataObject.getStringValue((Object)object));
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
        return PSDEWizardBase.isNull(this, n);
    }

    private static boolean isNull(PSDEWizardBase pSDEWizardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEWizardBase.getBusyIndicator() == null;
            }
            case 1: {
                return pSDEWizardBase.getCodeName() == null;
            }
            case 2: {
                return pSDEWizardBase.getCreateDate() == null;
            }
            case 3: {
                return pSDEWizardBase.getCreateMan() == null;
            }
            case 4: {
                return pSDEWizardBase.getEnableMSLogic() == null;
            }
            case 5: {
                return pSDEWizardBase.getFinishCaption() == null;
            }
            case 6: {
                return pSDEWizardBase.getFinishPSDEActionId() == null;
            }
            case 7: {
                return pSDEWizardBase.getFinishPSDEActionName() == null;
            }
            case 8: {
                return pSDEWizardBase.getFinishPSLanResId() == null;
            }
            case 9: {
                return pSDEWizardBase.getFinishPSLanResName() == null;
            }
            case 10: {
                return pSDEWizardBase.getInitPSDEActionId() == null;
            }
            case 11: {
                return pSDEWizardBase.getInitPSDEActionName() == null;
            }
            case 12: {
                return pSDEWizardBase.getLockFlag() == null;
            }
            case 13: {
                return pSDEWizardBase.getMemo() == null;
            }
            case 14: {
                return pSDEWizardBase.getNextCaption() == null;
            }
            case 15: {
                return pSDEWizardBase.getNextPSLanResId() == null;
            }
            case 16: {
                return pSDEWizardBase.getNextPSLanResName() == null;
            }
            case 17: {
                return pSDEWizardBase.getPrevCaption() == null;
            }
            case 18: {
                return pSDEWizardBase.getPrevPSLanResId() == null;
            }
            case 19: {
                return pSDEWizardBase.getPrevPSLanResName() == null;
            }
            case 20: {
                return pSDEWizardBase.getPSCtrlLogicGroupId() == null;
            }
            case 21: {
                return pSDEWizardBase.getPSCtrlLogicGroupName() == null;
            }
            case 22: {
                return pSDEWizardBase.getPSCtrlMsgId() == null;
            }
            case 23: {
                return pSDEWizardBase.getPSCtrlMsgName() == null;
            }
            case 24: {
                return pSDEWizardBase.getPSDEId() == null;
            }
            case 25: {
                return pSDEWizardBase.getPSDEMSLogicId() == null;
            }
            case 26: {
                return pSDEWizardBase.getPSDEMSLogicName() == null;
            }
            case 27: {
                return pSDEWizardBase.getPSDEName() == null;
            }
            case 28: {
                return pSDEWizardBase.getPSDEWizardId() == null;
            }
            case 29: {
                return pSDEWizardBase.getPSDEWizardName() == null;
            }
            case 30: {
                return pSDEWizardBase.getPSSysCssId() == null;
            }
            case 31: {
                return pSDEWizardBase.getPSSysCssName() == null;
            }
            case 32: {
                return pSDEWizardBase.getPSSysPFPluginId() == null;
            }
            case 33: {
                return pSDEWizardBase.getPSSysPFPluginName() == null;
            }
            case 34: {
                return pSDEWizardBase.getPSSysReqItemId() == null;
            }
            case 35: {
                return pSDEWizardBase.getPSSysReqItemName() == null;
            }
            case 36: {
                return pSDEWizardBase.getPSViewMsgGroupId() == null;
            }
            case 37: {
                return pSDEWizardBase.getPSViewMsgGroupName() == null;
            }
            case 38: {
                return pSDEWizardBase.getStatePSDEFId() == null;
            }
            case 39: {
                return pSDEWizardBase.getStatePSDEFName() == null;
            }
            case 40: {
                return pSDEWizardBase.getStateWizardFlag() == null;
            }
            case 41: {
                return pSDEWizardBase.getToDoTask() == null;
            }
            case 42: {
                return pSDEWizardBase.getUpdateDate() == null;
            }
            case 43: {
                return pSDEWizardBase.getUpdateMan() == null;
            }
            case 44: {
                return pSDEWizardBase.getUserCat() == null;
            }
            case 45: {
                return pSDEWizardBase.getUserTag() == null;
            }
            case 46: {
                return pSDEWizardBase.getUserTag2() == null;
            }
            case 47: {
                return pSDEWizardBase.getUserTag3() == null;
            }
            case 48: {
                return pSDEWizardBase.getUserTag4() == null;
            }
            case 49: {
                return pSDEWizardBase.getWizardStyle() == null;
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
        return PSDEWizardBase.contains(this, n);
    }

    private static boolean contains(PSDEWizardBase pSDEWizardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEWizardBase.isBusyIndicatorDirty();
            }
            case 1: {
                return pSDEWizardBase.isCodeNameDirty();
            }
            case 2: {
                return pSDEWizardBase.isCreateDateDirty();
            }
            case 3: {
                return pSDEWizardBase.isCreateManDirty();
            }
            case 4: {
                return pSDEWizardBase.isEnableMSLogicDirty();
            }
            case 5: {
                return pSDEWizardBase.isFinishCaptionDirty();
            }
            case 6: {
                return pSDEWizardBase.isFinishPSDEActionIdDirty();
            }
            case 7: {
                return pSDEWizardBase.isFinishPSDEActionNameDirty();
            }
            case 8: {
                return pSDEWizardBase.isFinishPSLanResIdDirty();
            }
            case 9: {
                return pSDEWizardBase.isFinishPSLanResNameDirty();
            }
            case 10: {
                return pSDEWizardBase.isInitPSDEActionIdDirty();
            }
            case 11: {
                return pSDEWizardBase.isInitPSDEActionNameDirty();
            }
            case 12: {
                return pSDEWizardBase.isLockFlagDirty();
            }
            case 13: {
                return pSDEWizardBase.isMemoDirty();
            }
            case 14: {
                return pSDEWizardBase.isNextCaptionDirty();
            }
            case 15: {
                return pSDEWizardBase.isNextPSLanResIdDirty();
            }
            case 16: {
                return pSDEWizardBase.isNextPSLanResNameDirty();
            }
            case 17: {
                return pSDEWizardBase.isPrevCaptionDirty();
            }
            case 18: {
                return pSDEWizardBase.isPrevPSLanResIdDirty();
            }
            case 19: {
                return pSDEWizardBase.isPrevPSLanResNameDirty();
            }
            case 20: {
                return pSDEWizardBase.isPSCtrlLogicGroupIdDirty();
            }
            case 21: {
                return pSDEWizardBase.isPSCtrlLogicGroupNameDirty();
            }
            case 22: {
                return pSDEWizardBase.isPSCtrlMsgIdDirty();
            }
            case 23: {
                return pSDEWizardBase.isPSCtrlMsgNameDirty();
            }
            case 24: {
                return pSDEWizardBase.isPSDEIdDirty();
            }
            case 25: {
                return pSDEWizardBase.isPSDEMSLogicIdDirty();
            }
            case 26: {
                return pSDEWizardBase.isPSDEMSLogicNameDirty();
            }
            case 27: {
                return pSDEWizardBase.isPSDENameDirty();
            }
            case 28: {
                return pSDEWizardBase.isPSDEWizardIdDirty();
            }
            case 29: {
                return pSDEWizardBase.isPSDEWizardNameDirty();
            }
            case 30: {
                return pSDEWizardBase.isPSSysCssIdDirty();
            }
            case 31: {
                return pSDEWizardBase.isPSSysCssNameDirty();
            }
            case 32: {
                return pSDEWizardBase.isPSSysPFPluginIdDirty();
            }
            case 33: {
                return pSDEWizardBase.isPSSysPFPluginNameDirty();
            }
            case 34: {
                return pSDEWizardBase.isPSSysReqItemIdDirty();
            }
            case 35: {
                return pSDEWizardBase.isPSSysReqItemNameDirty();
            }
            case 36: {
                return pSDEWizardBase.isPSViewMsgGroupIdDirty();
            }
            case 37: {
                return pSDEWizardBase.isPSViewMsgGroupNameDirty();
            }
            case 38: {
                return pSDEWizardBase.isStatePSDEFIdDirty();
            }
            case 39: {
                return pSDEWizardBase.isStatePSDEFNameDirty();
            }
            case 40: {
                return pSDEWizardBase.isStateWizardFlagDirty();
            }
            case 41: {
                return pSDEWizardBase.isToDoTaskDirty();
            }
            case 42: {
                return pSDEWizardBase.isUpdateDateDirty();
            }
            case 43: {
                return pSDEWizardBase.isUpdateManDirty();
            }
            case 44: {
                return pSDEWizardBase.isUserCatDirty();
            }
            case 45: {
                return pSDEWizardBase.isUserTagDirty();
            }
            case 46: {
                return pSDEWizardBase.isUserTag2Dirty();
            }
            case 47: {
                return pSDEWizardBase.isUserTag3Dirty();
            }
            case 48: {
                return pSDEWizardBase.isUserTag4Dirty();
            }
            case 49: {
                return pSDEWizardBase.isWizardStyleDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEWizardBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEWizardBase pSDEWizardBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEWizardBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getEnableMSLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablemslogic", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getEnableMSLogic()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getFinishCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishcaption", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getFinishCaption()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getFinishPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishpsdeactionid", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getFinishPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getFinishPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishpsdeactionname", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getFinishPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getFinishPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishpslanresid", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getFinishPSLanResId()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getFinishPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishpslanresname", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getFinishPSLanResName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getInitPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initpsdeactionid", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getInitPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getInitPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"initpsdeactionname", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getInitPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getNextCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nextcaption", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getNextCaption()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getNextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nextpslanresid", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getNextPSLanResId()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getNextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nextpslanresname", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getNextPSLanResName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPrevCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prevcaption", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPrevCaption()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPrevPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prevpslanresid", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPrevPSLanResId()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPrevPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prevpslanresname", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPrevPSLanResName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSCtrlLogicGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupid", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSCtrlLogicGroupId()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSCtrlLogicGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrllogicgroupname", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSCtrlLogicGroupName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSCtrlMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgid", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSCtrlMsgId()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSCtrlMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgname", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSCtrlMsgName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSDEMSLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemslogicid", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSDEMSLogicId()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSDEMSLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemslogicname", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSDEMSLogicName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSDEWizardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardid", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSDEWizardId()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSDEWizardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdewizardname", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSDEWizardName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getStatePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statepsdefid", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getStatePSDEFId()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getStatePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statepsdefname", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getStatePSDEFName()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getStateWizardFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statewizardflag", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getStateWizardFlag()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEWizardBase.getWizardStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardstyle", (Object)PSDEWizardBase.getJSONValue((Object)pSDEWizardBase.getWizardStyle()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEWizardBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEWizardBase pSDEWizardBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEWizardBase.getBusyIndicator() != null) {
            object = pSDEWizardBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEWizardBase.getCodeName() != null) {
            object = pSDEWizardBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getCreateDate() != null) {
            object = pSDEWizardBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEWizardBase.getCreateMan() != null) {
            object = pSDEWizardBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getEnableMSLogic() != null) {
            object = pSDEWizardBase.getEnableMSLogic();
            xmlNode.setAttribute(FIELD_ENABLEMSLOGIC, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEWizardBase.getFinishCaption() != null) {
            object = pSDEWizardBase.getFinishCaption();
            xmlNode.setAttribute(FIELD_FINISHCAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getFinishPSDEActionId() != null) {
            object = pSDEWizardBase.getFinishPSDEActionId();
            xmlNode.setAttribute(FIELD_FINISHPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getFinishPSDEActionName() != null) {
            object = pSDEWizardBase.getFinishPSDEActionName();
            xmlNode.setAttribute(FIELD_FINISHPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getFinishPSLanResId() != null) {
            object = pSDEWizardBase.getFinishPSLanResId();
            xmlNode.setAttribute(FIELD_FINISHPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getFinishPSLanResName() != null) {
            object = pSDEWizardBase.getFinishPSLanResName();
            xmlNode.setAttribute(FIELD_FINISHPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getInitPSDEActionId() != null) {
            object = pSDEWizardBase.getInitPSDEActionId();
            xmlNode.setAttribute(FIELD_INITPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getInitPSDEActionName() != null) {
            object = pSDEWizardBase.getInitPSDEActionName();
            xmlNode.setAttribute(FIELD_INITPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getLockFlag() != null) {
            object = pSDEWizardBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEWizardBase.getMemo() != null) {
            object = pSDEWizardBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getNextCaption() != null) {
            object = pSDEWizardBase.getNextCaption();
            xmlNode.setAttribute(FIELD_NEXTCAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getNextPSLanResId() != null) {
            object = pSDEWizardBase.getNextPSLanResId();
            xmlNode.setAttribute(FIELD_NEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getNextPSLanResName() != null) {
            object = pSDEWizardBase.getNextPSLanResName();
            xmlNode.setAttribute(FIELD_NEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPrevCaption() != null) {
            object = pSDEWizardBase.getPrevCaption();
            xmlNode.setAttribute(FIELD_PREVCAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPrevPSLanResId() != null) {
            object = pSDEWizardBase.getPrevPSLanResId();
            xmlNode.setAttribute(FIELD_PREVPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPrevPSLanResName() != null) {
            object = pSDEWizardBase.getPrevPSLanResName();
            xmlNode.setAttribute(FIELD_PREVPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSCtrlLogicGroupId() != null) {
            object = pSDEWizardBase.getPSCtrlLogicGroupId();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSCtrlLogicGroupName() != null) {
            object = pSDEWizardBase.getPSCtrlLogicGroupName();
            xmlNode.setAttribute(FIELD_PSCTRLLOGICGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSCtrlMsgId() != null) {
            object = pSDEWizardBase.getPSCtrlMsgId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSCtrlMsgName() != null) {
            object = pSDEWizardBase.getPSCtrlMsgName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSDEId() != null) {
            object = pSDEWizardBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSDEMSLogicId() != null) {
            object = pSDEWizardBase.getPSDEMSLogicId();
            xmlNode.setAttribute(FIELD_PSDEMSLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSDEMSLogicName() != null) {
            object = pSDEWizardBase.getPSDEMSLogicName();
            xmlNode.setAttribute(FIELD_PSDEMSLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSDEName() != null) {
            object = pSDEWizardBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSDEWizardId() != null) {
            object = pSDEWizardBase.getPSDEWizardId();
            xmlNode.setAttribute(FIELD_PSDEWIZARDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSDEWizardName() != null) {
            object = pSDEWizardBase.getPSDEWizardName();
            xmlNode.setAttribute(FIELD_PSDEWIZARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSSysCssId() != null) {
            object = pSDEWizardBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSSysCssName() != null) {
            object = pSDEWizardBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSSysPFPluginId() != null) {
            object = pSDEWizardBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSSysPFPluginName() != null) {
            object = pSDEWizardBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSSysReqItemId() != null) {
            object = pSDEWizardBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSSysReqItemName() != null) {
            object = pSDEWizardBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSViewMsgGroupId() != null) {
            object = pSDEWizardBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getPSViewMsgGroupName() != null) {
            object = pSDEWizardBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getStatePSDEFId() != null) {
            object = pSDEWizardBase.getStatePSDEFId();
            xmlNode.setAttribute(FIELD_STATEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getStatePSDEFName() != null) {
            object = pSDEWizardBase.getStatePSDEFName();
            xmlNode.setAttribute(FIELD_STATEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getStateWizardFlag() != null) {
            object = pSDEWizardBase.getStateWizardFlag();
            xmlNode.setAttribute(FIELD_STATEWIZARDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEWizardBase.getToDoTask() != null) {
            object = pSDEWizardBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getUpdateDate() != null) {
            object = pSDEWizardBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEWizardBase.getUpdateMan() != null) {
            object = pSDEWizardBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getUserCat() != null) {
            object = pSDEWizardBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getUserTag() != null) {
            object = pSDEWizardBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getUserTag2() != null) {
            object = pSDEWizardBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getUserTag3() != null) {
            object = pSDEWizardBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getUserTag4() != null) {
            object = pSDEWizardBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEWizardBase.getWizardStyle() != null) {
            object = pSDEWizardBase.getWizardStyle();
            xmlNode.setAttribute(FIELD_WIZARDSTYLE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEWizardBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEWizardBase pSDEWizardBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEWizardBase.isBusyIndicatorDirty() && (bl || pSDEWizardBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSDEWizardBase.getBusyIndicator());
        }
        if (pSDEWizardBase.isCodeNameDirty() && (bl || pSDEWizardBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEWizardBase.getCodeName());
        }
        if (pSDEWizardBase.isCreateDateDirty() && (bl || pSDEWizardBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEWizardBase.getCreateDate());
        }
        if (pSDEWizardBase.isCreateManDirty() && (bl || pSDEWizardBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEWizardBase.getCreateMan());
        }
        if (pSDEWizardBase.isEnableMSLogicDirty() && (bl || pSDEWizardBase.getEnableMSLogic() != null)) {
            iDataObject.set(FIELD_ENABLEMSLOGIC, (Object)pSDEWizardBase.getEnableMSLogic());
        }
        if (pSDEWizardBase.isFinishCaptionDirty() && (bl || pSDEWizardBase.getFinishCaption() != null)) {
            iDataObject.set(FIELD_FINISHCAPTION, (Object)pSDEWizardBase.getFinishCaption());
        }
        if (pSDEWizardBase.isFinishPSDEActionIdDirty() && (bl || pSDEWizardBase.getFinishPSDEActionId() != null)) {
            iDataObject.set(FIELD_FINISHPSDEACTIONID, (Object)pSDEWizardBase.getFinishPSDEActionId());
        }
        if (pSDEWizardBase.isFinishPSDEActionNameDirty() && (bl || pSDEWizardBase.getFinishPSDEActionName() != null)) {
            iDataObject.set(FIELD_FINISHPSDEACTIONNAME, (Object)pSDEWizardBase.getFinishPSDEActionName());
        }
        if (pSDEWizardBase.isFinishPSLanResIdDirty() && (bl || pSDEWizardBase.getFinishPSLanResId() != null)) {
            iDataObject.set(FIELD_FINISHPSLANRESID, (Object)pSDEWizardBase.getFinishPSLanResId());
        }
        if (pSDEWizardBase.isFinishPSLanResNameDirty() && (bl || pSDEWizardBase.getFinishPSLanResName() != null)) {
            iDataObject.set(FIELD_FINISHPSLANRESNAME, (Object)pSDEWizardBase.getFinishPSLanResName());
        }
        if (pSDEWizardBase.isInitPSDEActionIdDirty() && (bl || pSDEWizardBase.getInitPSDEActionId() != null)) {
            iDataObject.set(FIELD_INITPSDEACTIONID, (Object)pSDEWizardBase.getInitPSDEActionId());
        }
        if (pSDEWizardBase.isInitPSDEActionNameDirty() && (bl || pSDEWizardBase.getInitPSDEActionName() != null)) {
            iDataObject.set(FIELD_INITPSDEACTIONNAME, (Object)pSDEWizardBase.getInitPSDEActionName());
        }
        if (pSDEWizardBase.isLockFlagDirty() && (bl || pSDEWizardBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEWizardBase.getLockFlag());
        }
        if (pSDEWizardBase.isMemoDirty() && (bl || pSDEWizardBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEWizardBase.getMemo());
        }
        if (pSDEWizardBase.isNextCaptionDirty() && (bl || pSDEWizardBase.getNextCaption() != null)) {
            iDataObject.set(FIELD_NEXTCAPTION, (Object)pSDEWizardBase.getNextCaption());
        }
        if (pSDEWizardBase.isNextPSLanResIdDirty() && (bl || pSDEWizardBase.getNextPSLanResId() != null)) {
            iDataObject.set(FIELD_NEXTPSLANRESID, (Object)pSDEWizardBase.getNextPSLanResId());
        }
        if (pSDEWizardBase.isNextPSLanResNameDirty() && (bl || pSDEWizardBase.getNextPSLanResName() != null)) {
            iDataObject.set(FIELD_NEXTPSLANRESNAME, (Object)pSDEWizardBase.getNextPSLanResName());
        }
        if (pSDEWizardBase.isPrevCaptionDirty() && (bl || pSDEWizardBase.getPrevCaption() != null)) {
            iDataObject.set(FIELD_PREVCAPTION, (Object)pSDEWizardBase.getPrevCaption());
        }
        if (pSDEWizardBase.isPrevPSLanResIdDirty() && (bl || pSDEWizardBase.getPrevPSLanResId() != null)) {
            iDataObject.set(FIELD_PREVPSLANRESID, (Object)pSDEWizardBase.getPrevPSLanResId());
        }
        if (pSDEWizardBase.isPrevPSLanResNameDirty() && (bl || pSDEWizardBase.getPrevPSLanResName() != null)) {
            iDataObject.set(FIELD_PREVPSLANRESNAME, (Object)pSDEWizardBase.getPrevPSLanResName());
        }
        if (pSDEWizardBase.isPSCtrlLogicGroupIdDirty() && (bl || pSDEWizardBase.getPSCtrlLogicGroupId() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPID, (Object)pSDEWizardBase.getPSCtrlLogicGroupId());
        }
        if (pSDEWizardBase.isPSCtrlLogicGroupNameDirty() && (bl || pSDEWizardBase.getPSCtrlLogicGroupName() != null)) {
            iDataObject.set(FIELD_PSCTRLLOGICGROUPNAME, (Object)pSDEWizardBase.getPSCtrlLogicGroupName());
        }
        if (pSDEWizardBase.isPSCtrlMsgIdDirty() && (bl || pSDEWizardBase.getPSCtrlMsgId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGID, (Object)pSDEWizardBase.getPSCtrlMsgId());
        }
        if (pSDEWizardBase.isPSCtrlMsgNameDirty() && (bl || pSDEWizardBase.getPSCtrlMsgName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGNAME, (Object)pSDEWizardBase.getPSCtrlMsgName());
        }
        if (pSDEWizardBase.isPSDEIdDirty() && (bl || pSDEWizardBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEWizardBase.getPSDEId());
        }
        if (pSDEWizardBase.isPSDEMSLogicIdDirty() && (bl || pSDEWizardBase.getPSDEMSLogicId() != null)) {
            iDataObject.set(FIELD_PSDEMSLOGICID, (Object)pSDEWizardBase.getPSDEMSLogicId());
        }
        if (pSDEWizardBase.isPSDEMSLogicNameDirty() && (bl || pSDEWizardBase.getPSDEMSLogicName() != null)) {
            iDataObject.set(FIELD_PSDEMSLOGICNAME, (Object)pSDEWizardBase.getPSDEMSLogicName());
        }
        if (pSDEWizardBase.isPSDENameDirty() && (bl || pSDEWizardBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEWizardBase.getPSDEName());
        }
        if (pSDEWizardBase.isPSDEWizardIdDirty() && (bl || pSDEWizardBase.getPSDEWizardId() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDID, (Object)pSDEWizardBase.getPSDEWizardId());
        }
        if (pSDEWizardBase.isPSDEWizardNameDirty() && (bl || pSDEWizardBase.getPSDEWizardName() != null)) {
            iDataObject.set(FIELD_PSDEWIZARDNAME, (Object)pSDEWizardBase.getPSDEWizardName());
        }
        if (pSDEWizardBase.isPSSysCssIdDirty() && (bl || pSDEWizardBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDEWizardBase.getPSSysCssId());
        }
        if (pSDEWizardBase.isPSSysCssNameDirty() && (bl || pSDEWizardBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDEWizardBase.getPSSysCssName());
        }
        if (pSDEWizardBase.isPSSysPFPluginIdDirty() && (bl || pSDEWizardBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEWizardBase.getPSSysPFPluginId());
        }
        if (pSDEWizardBase.isPSSysPFPluginNameDirty() && (bl || pSDEWizardBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEWizardBase.getPSSysPFPluginName());
        }
        if (pSDEWizardBase.isPSSysReqItemIdDirty() && (bl || pSDEWizardBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEWizardBase.getPSSysReqItemId());
        }
        if (pSDEWizardBase.isPSSysReqItemNameDirty() && (bl || pSDEWizardBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEWizardBase.getPSSysReqItemName());
        }
        if (pSDEWizardBase.isPSViewMsgGroupIdDirty() && (bl || pSDEWizardBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSDEWizardBase.getPSViewMsgGroupId());
        }
        if (pSDEWizardBase.isPSViewMsgGroupNameDirty() && (bl || pSDEWizardBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSDEWizardBase.getPSViewMsgGroupName());
        }
        if (pSDEWizardBase.isStatePSDEFIdDirty() && (bl || pSDEWizardBase.getStatePSDEFId() != null)) {
            iDataObject.set(FIELD_STATEPSDEFID, (Object)pSDEWizardBase.getStatePSDEFId());
        }
        if (pSDEWizardBase.isStatePSDEFNameDirty() && (bl || pSDEWizardBase.getStatePSDEFName() != null)) {
            iDataObject.set(FIELD_STATEPSDEFNAME, (Object)pSDEWizardBase.getStatePSDEFName());
        }
        if (pSDEWizardBase.isStateWizardFlagDirty() && (bl || pSDEWizardBase.getStateWizardFlag() != null)) {
            iDataObject.set(FIELD_STATEWIZARDFLAG, (Object)pSDEWizardBase.getStateWizardFlag());
        }
        if (pSDEWizardBase.isToDoTaskDirty() && (bl || pSDEWizardBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEWizardBase.getToDoTask());
        }
        if (pSDEWizardBase.isUpdateDateDirty() && (bl || pSDEWizardBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEWizardBase.getUpdateDate());
        }
        if (pSDEWizardBase.isUpdateManDirty() && (bl || pSDEWizardBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEWizardBase.getUpdateMan());
        }
        if (pSDEWizardBase.isUserCatDirty() && (bl || pSDEWizardBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEWizardBase.getUserCat());
        }
        if (pSDEWizardBase.isUserTagDirty() && (bl || pSDEWizardBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEWizardBase.getUserTag());
        }
        if (pSDEWizardBase.isUserTag2Dirty() && (bl || pSDEWizardBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEWizardBase.getUserTag2());
        }
        if (pSDEWizardBase.isUserTag3Dirty() && (bl || pSDEWizardBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEWizardBase.getUserTag3());
        }
        if (pSDEWizardBase.isUserTag4Dirty() && (bl || pSDEWizardBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEWizardBase.getUserTag4());
        }
        if (pSDEWizardBase.isWizardStyleDirty() && (bl || pSDEWizardBase.getWizardStyle() != null)) {
            iDataObject.set(FIELD_WIZARDSTYLE, (Object)pSDEWizardBase.getWizardStyle());
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
        return PSDEWizardBase.remove(this, n);
    }

    private static boolean remove(PSDEWizardBase pSDEWizardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEWizardBase.resetBusyIndicator();
                return true;
            }
            case 1: {
                pSDEWizardBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDEWizardBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDEWizardBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDEWizardBase.resetEnableMSLogic();
                return true;
            }
            case 5: {
                pSDEWizardBase.resetFinishCaption();
                return true;
            }
            case 6: {
                pSDEWizardBase.resetFinishPSDEActionId();
                return true;
            }
            case 7: {
                pSDEWizardBase.resetFinishPSDEActionName();
                return true;
            }
            case 8: {
                pSDEWizardBase.resetFinishPSLanResId();
                return true;
            }
            case 9: {
                pSDEWizardBase.resetFinishPSLanResName();
                return true;
            }
            case 10: {
                pSDEWizardBase.resetInitPSDEActionId();
                return true;
            }
            case 11: {
                pSDEWizardBase.resetInitPSDEActionName();
                return true;
            }
            case 12: {
                pSDEWizardBase.resetLockFlag();
                return true;
            }
            case 13: {
                pSDEWizardBase.resetMemo();
                return true;
            }
            case 14: {
                pSDEWizardBase.resetNextCaption();
                return true;
            }
            case 15: {
                pSDEWizardBase.resetNextPSLanResId();
                return true;
            }
            case 16: {
                pSDEWizardBase.resetNextPSLanResName();
                return true;
            }
            case 17: {
                pSDEWizardBase.resetPrevCaption();
                return true;
            }
            case 18: {
                pSDEWizardBase.resetPrevPSLanResId();
                return true;
            }
            case 19: {
                pSDEWizardBase.resetPrevPSLanResName();
                return true;
            }
            case 20: {
                pSDEWizardBase.resetPSCtrlLogicGroupId();
                return true;
            }
            case 21: {
                pSDEWizardBase.resetPSCtrlLogicGroupName();
                return true;
            }
            case 22: {
                pSDEWizardBase.resetPSCtrlMsgId();
                return true;
            }
            case 23: {
                pSDEWizardBase.resetPSCtrlMsgName();
                return true;
            }
            case 24: {
                pSDEWizardBase.resetPSDEId();
                return true;
            }
            case 25: {
                pSDEWizardBase.resetPSDEMSLogicId();
                return true;
            }
            case 26: {
                pSDEWizardBase.resetPSDEMSLogicName();
                return true;
            }
            case 27: {
                pSDEWizardBase.resetPSDEName();
                return true;
            }
            case 28: {
                pSDEWizardBase.resetPSDEWizardId();
                return true;
            }
            case 29: {
                pSDEWizardBase.resetPSDEWizardName();
                return true;
            }
            case 30: {
                pSDEWizardBase.resetPSSysCssId();
                return true;
            }
            case 31: {
                pSDEWizardBase.resetPSSysCssName();
                return true;
            }
            case 32: {
                pSDEWizardBase.resetPSSysPFPluginId();
                return true;
            }
            case 33: {
                pSDEWizardBase.resetPSSysPFPluginName();
                return true;
            }
            case 34: {
                pSDEWizardBase.resetPSSysReqItemId();
                return true;
            }
            case 35: {
                pSDEWizardBase.resetPSSysReqItemName();
                return true;
            }
            case 36: {
                pSDEWizardBase.resetPSViewMsgGroupId();
                return true;
            }
            case 37: {
                pSDEWizardBase.resetPSViewMsgGroupName();
                return true;
            }
            case 38: {
                pSDEWizardBase.resetStatePSDEFId();
                return true;
            }
            case 39: {
                pSDEWizardBase.resetStatePSDEFName();
                return true;
            }
            case 40: {
                pSDEWizardBase.resetStateWizardFlag();
                return true;
            }
            case 41: {
                pSDEWizardBase.resetToDoTask();
                return true;
            }
            case 42: {
                pSDEWizardBase.resetUpdateDate();
                return true;
            }
            case 43: {
                pSDEWizardBase.resetUpdateMan();
                return true;
            }
            case 44: {
                pSDEWizardBase.resetUserCat();
                return true;
            }
            case 45: {
                pSDEWizardBase.resetUserTag();
                return true;
            }
            case 46: {
                pSDEWizardBase.resetUserTag2();
                return true;
            }
            case 47: {
                pSDEWizardBase.resetUserTag3();
                return true;
            }
            case 48: {
                pSDEWizardBase.resetUserTag4();
                return true;
            }
            case 49: {
                pSDEWizardBase.resetWizardStyle();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlLogicGroup getPSCtrlLogicGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlLogicGroup();
        }
        if (this.getPSCtrlLogicGroupId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlLogicGroupLock;
        synchronized (n) {
            if (this.psctrllogicgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlLogicGroupId(), (Object)this.psctrllogicgroup.getPSCtrlLogicGroupId()) != 0L) {
                this.psctrllogicgroup = null;
            }
            if (this.psctrllogicgroup == null) {
                PSCtrlLogicGroup pSCtrlLogicGroup = new PSCtrlLogicGroup();
                pSCtrlLogicGroup.setPSCtrlLogicGroupId(this.getPSCtrlLogicGroupId());
                PSCtrlLogicGroupService pSCtrlLogicGroupService = (PSCtrlLogicGroupService)ServiceGlobal.getService(PSCtrlLogicGroupService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlLogicGroupService.autoGet((IEntity)pSCtrlLogicGroup);
                this.psctrllogicgroup = pSCtrlLogicGroup;
            }
            return this.psctrllogicgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlMsg getPSCtrlMsg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsg();
        }
        if (this.getPSCtrlMsgId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlMsgLock;
        synchronized (n) {
            if (this.psctrlmsg != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlMsgId(), (Object)this.psctrlmsg.getPSCtrlMsgId()) != 0L) {
                this.psctrlmsg = null;
            }
            if (this.psctrlmsg == null) {
                PSCtrlMsg pSCtrlMsg = new PSCtrlMsg();
                pSCtrlMsg.setPSCtrlMsgId(this.getPSCtrlMsgId());
                PSCtrlMsgService pSCtrlMsgService = (PSCtrlMsgService)ServiceGlobal.getService(PSCtrlMsgService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlMsgService.autoGet((IEntity)pSCtrlMsg);
                this.psctrlmsg = pSCtrlMsg;
            }
            return this.psctrlmsg;
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
    public PSDEAction getFinishPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishPSDEAction();
        }
        if (this.getFinishPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objFinishPSDEActionLock;
        synchronized (n) {
            if (this.finishpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getFinishPSDEActionId(), (Object)this.finishpsdeaction.getPSDEActionId()) != 0L) {
                this.finishpsdeaction = null;
            }
            if (this.finishpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getFinishPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.finishpsdeaction = pSDEAction;
            }
            return this.finishpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getInitPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInitPSDEAction();
        }
        if (this.getInitPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objInitPSDEActionLock;
        synchronized (n) {
            if (this.initpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getInitPSDEActionId(), (Object)this.initpsdeaction.getPSDEActionId()) != 0L) {
                this.initpsdeaction = null;
            }
            if (this.initpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getInitPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.initpsdeaction = pSDEAction;
            }
            return this.initpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getStatePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStatePSDEF();
        }
        if (this.getStatePSDEFId() == null) {
            return null;
        }
        Integer n = this.objStatePSDEFLock;
        synchronized (n) {
            if (this.statepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getStatePSDEFId(), (Object)this.statepsdef.getPSDEFieldId()) != 0L) {
                this.statepsdef = null;
            }
            if (this.statepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getStatePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.statepsdef = pSDEField;
            }
            return this.statepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getPSDEMSLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMSLogic();
        }
        if (this.getPSDEMSLogicId() == null) {
            return null;
        }
        Integer n = this.objPSDEMSLogicLock;
        synchronized (n) {
            if (this.psdemslogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEMSLogicId(), (Object)this.psdemslogic.getPSDELogicId()) != 0L) {
                this.psdemslogic = null;
            }
            if (this.psdemslogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getPSDEMSLogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.psdemslogic = pSDELogic;
            }
            return this.psdemslogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getFinishPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishPSLanRes();
        }
        if (this.getFinishPSLanResId() == null) {
            return null;
        }
        Integer n = this.objFinishPSLanResLock;
        synchronized (n) {
            if (this.finishpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getFinishPSLanResId(), (Object)this.finishpslanres.getPSLanguageResId()) != 0L) {
                this.finishpslanres = null;
            }
            if (this.finishpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getFinishPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.finishpslanres = pSLanguageRes;
            }
            return this.finishpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getNextPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNextPSLanRes();
        }
        if (this.getNextPSLanResId() == null) {
            return null;
        }
        Integer n = this.objNextPSLanResLock;
        synchronized (n) {
            if (this.nextpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getNextPSLanResId(), (Object)this.nextpslanres.getPSLanguageResId()) != 0L) {
                this.nextpslanres = null;
            }
            if (this.nextpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getNextPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.nextpslanres = pSLanguageRes;
            }
            return this.nextpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getPrevPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrevPSLanRes();
        }
        if (this.getPrevPSLanResId() == null) {
            return null;
        }
        Integer n = this.objPrevPSLanResLock;
        synchronized (n) {
            if (this.prevpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getPrevPSLanResId(), (Object)this.prevpslanres.getPSLanguageResId()) != 0L) {
                this.prevpslanres = null;
            }
            if (this.prevpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getPrevPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.prevpslanres = pSLanguageRes;
            }
            return this.prevpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCss();
        }
        if (this.getPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objPSSysCssLock;
        synchronized (n) {
            if (this.pssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCssId(), (Object)this.pssyscss.getPSSysCssId()) != 0L) {
                this.pssyscss = null;
            }
            if (this.pssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
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
    public PSViewMsgGroup getPSViewMsgGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroup();
        }
        if (this.getPSViewMsgGroupId() == null) {
            return null;
        }
        Integer n = this.objPSViewMsgGroupLock;
        synchronized (n) {
            if (this.psviewmsggroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewMsgGroupId(), (Object)this.psviewmsggroup.getPSViewMsgGroupId()) != 0L) {
                this.psviewmsggroup = null;
            }
            if (this.psviewmsggroup == null) {
                PSViewMsgGroup pSViewMsgGroup = new PSViewMsgGroup();
                pSViewMsgGroup.setPSViewMsgGroupId(this.getPSViewMsgGroupId());
                PSViewMsgGroupService pSViewMsgGroupService = (PSViewMsgGroupService)ServiceGlobal.getService(PSViewMsgGroupService.class, (SessionFactory)this.getSessionFactory());
                pSViewMsgGroupService.autoGet((IEntity)pSViewMsgGroup);
                this.psviewmsggroup = pSViewMsgGroup;
            }
            return this.psviewmsggroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEWizardLogic> getPSDEWizardLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardLogics();
        }
        if (this.getPSDEWizardId() == null) {
            return null;
        }
        PSDEWizardService pSDEWizardService = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
        PSDEWizardLogicService pSDEWizardLogicService = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEWizardLogicsLock;
        synchronized (n) {
            if (this.psdewizardlogics == null) {
                this.psdewizardlogics = pSDEWizardService.isTempData((IEntity)this) ? pSDEWizardLogicService.selectTempByPSDEWizard(this) : pSDEWizardLogicService.selectByPSDEWizard(this);
            }
            return this.psdewizardlogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEWizardStep> getPSDEWizardSteps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEWizardSteps();
        }
        if (this.getPSDEWizardId() == null) {
            return null;
        }
        PSDEWizardService pSDEWizardService = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
        PSDEWizardStepService pSDEWizardStepService = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEWizardStepsLock;
        synchronized (n) {
            if (this.psdewizardsteps == null) {
                this.psdewizardsteps = pSDEWizardService.isTempData((IEntity)this) ? pSDEWizardStepService.selectTempByPSDEWizard(this) : pSDEWizardStepService.selectByPSDEWizard(this);
            }
            return this.psdewizardsteps;
        }
    }

    private PSDEWizardBase getProxyEntity() {
        return this.proxyPSDEWizardBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEWizardBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEWizardBase) {
            this.proxyPSDEWizardBase = (PSDEWizardBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_ENABLEMSLOGIC, 4);
        fieldIndexMap.put(FIELD_FINISHCAPTION, 5);
        fieldIndexMap.put(FIELD_FINISHPSDEACTIONID, 6);
        fieldIndexMap.put(FIELD_FINISHPSDEACTIONNAME, 7);
        fieldIndexMap.put(FIELD_FINISHPSLANRESID, 8);
        fieldIndexMap.put(FIELD_FINISHPSLANRESNAME, 9);
        fieldIndexMap.put(FIELD_INITPSDEACTIONID, 10);
        fieldIndexMap.put(FIELD_INITPSDEACTIONNAME, 11);
        fieldIndexMap.put(FIELD_LOCKFLAG, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_NEXTCAPTION, 14);
        fieldIndexMap.put(FIELD_NEXTPSLANRESID, 15);
        fieldIndexMap.put(FIELD_NEXTPSLANRESNAME, 16);
        fieldIndexMap.put(FIELD_PREVCAPTION, 17);
        fieldIndexMap.put(FIELD_PREVPSLANRESID, 18);
        fieldIndexMap.put(FIELD_PREVPSLANRESNAME, 19);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPID, 20);
        fieldIndexMap.put(FIELD_PSCTRLLOGICGROUPNAME, 21);
        fieldIndexMap.put(FIELD_PSCTRLMSGID, 22);
        fieldIndexMap.put(FIELD_PSCTRLMSGNAME, 23);
        fieldIndexMap.put(FIELD_PSDEID, 24);
        fieldIndexMap.put(FIELD_PSDEMSLOGICID, 25);
        fieldIndexMap.put(FIELD_PSDEMSLOGICNAME, 26);
        fieldIndexMap.put(FIELD_PSDENAME, 27);
        fieldIndexMap.put(FIELD_PSDEWIZARDID, 28);
        fieldIndexMap.put(FIELD_PSDEWIZARDNAME, 29);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 30);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 31);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 32);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 33);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 34);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 35);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 36);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 37);
        fieldIndexMap.put(FIELD_STATEPSDEFID, 38);
        fieldIndexMap.put(FIELD_STATEPSDEFNAME, 39);
        fieldIndexMap.put(FIELD_STATEWIZARDFLAG, 40);
        fieldIndexMap.put(FIELD_TODOTASK, 41);
        fieldIndexMap.put(FIELD_UPDATEDATE, 42);
        fieldIndexMap.put(FIELD_UPDATEMAN, 43);
        fieldIndexMap.put(FIELD_USERCAT, 44);
        fieldIndexMap.put(FIELD_USERTAG, 45);
        fieldIndexMap.put(FIELD_USERTAG2, 46);
        fieldIndexMap.put(FIELD_USERTAG3, 47);
        fieldIndexMap.put(FIELD_USERTAG4, 48);
        fieldIndexMap.put(FIELD_WIZARDSTYLE, 49);
    }
}

