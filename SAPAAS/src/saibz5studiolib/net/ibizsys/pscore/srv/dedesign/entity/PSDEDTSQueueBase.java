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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDTSQueueBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDTSQueueBase.class);
    public static final String FIELD_CANCELLEDSTATE = "CANCELLEDSTATE";
    public static final String FIELD_CANCELLEDSTATETEXT = "CANCELLEDSTATETEXT";
    public static final String FIELD_CANCELPSDEACTIONID = "CANCELPSDEACTIONID";
    public static final String FIELD_CANCELPSDEACTIONNAME = "CANCELPSDEACTIONNAME";
    public static final String FIELD_CANCELTIMEOUT = "CANCELTIMEOUT";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEDSTATE = "CREATEDSTATE";
    public static final String FIELD_CREATEDSTATETEXT = "CREATEDSTATETEXT";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_ERRORPSDEFID = "ERRORPSDEFID";
    public static final String FIELD_ERRORPSDEFNAME = "ERRORPSDEFNAME";
    public static final String FIELD_FAILEDSTATE = "FAILEDSTATE";
    public static final String FIELD_FAILEDSTATETEXT = "FAILEDSTATETEXT";
    public static final String FIELD_FINISHEDSTATE = "FINISHEDSTATE";
    public static final String FIELD_FINISHEDSTATETEXT = "FINISHEDSTATETEXT";
    public static final String FIELD_FINISHPSDEACTIONID = "FINISHPSDEACTIONID";
    public static final String FIELD_FINISHPSDEACTIONNAME = "FINISHPSDEACTIONNAME";
    public static final String FIELD_HISTORYPSDEID = "HISTORYPSDEID";
    public static final String FIELD_HISTORYPSDENAME = "HISTORYPSDENAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PROCESSINGSTATE = "PROCESSINGSTATE";
    public static final String FIELD_PROCESSINGSTATETEXT = "PROCESSINGSTATETEXT";
    public static final String FIELD_PSDEDTSQUEUEID = "PSDEDTSQUEUEID";
    public static final String FIELD_PSDEDTSQUEUENAME = "PSDEDTSQUEUENAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PUSHPSDEACTIONID = "PUSHPSDEACTIONID";
    public static final String FIELD_PUSHPSDEACTIONNAME = "PUSHPSDEACTIONNAME";
    public static final String FIELD_QUEUEPARAMS = "QUEUEPARAMS";
    public static final String FIELD_REFRESHPSDEACTIONID = "REFRESHPSDEACTIONID";
    public static final String FIELD_REFRESHPSDEACTIONNAME = "REFRESHPSDEACTIONNAME";
    public static final String FIELD_REFRESHTIMER = "REFRESHTIMER";
    public static final String FIELD_STATEPSDEFID = "STATEPSDEFID";
    public static final String FIELD_STATEPSDEFNAME = "STATEPSDEFNAME";
    public static final String FIELD_TIMEPSDEFID = "TIMEPSDEFID";
    public static final String FIELD_TIMEPSDEFNAME = "TIMEPSDEFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CANCELLEDSTATE = 0;
    private static final int INDEX_CANCELLEDSTATETEXT = 1;
    private static final int INDEX_CANCELPSDEACTIONID = 2;
    private static final int INDEX_CANCELPSDEACTIONNAME = 3;
    private static final int INDEX_CANCELTIMEOUT = 4;
    private static final int INDEX_CODENAME = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEDSTATE = 7;
    private static final int INDEX_CREATEDSTATETEXT = 8;
    private static final int INDEX_CREATEMAN = 9;
    private static final int INDEX_DEFAULTFLAG = 10;
    private static final int INDEX_ERRORPSDEFID = 11;
    private static final int INDEX_ERRORPSDEFNAME = 12;
    private static final int INDEX_FAILEDSTATE = 13;
    private static final int INDEX_FAILEDSTATETEXT = 14;
    private static final int INDEX_FINISHEDSTATE = 15;
    private static final int INDEX_FINISHEDSTATETEXT = 16;
    private static final int INDEX_FINISHPSDEACTIONID = 17;
    private static final int INDEX_FINISHPSDEACTIONNAME = 18;
    private static final int INDEX_HISTORYPSDEID = 19;
    private static final int INDEX_HISTORYPSDENAME = 20;
    private static final int INDEX_LOCKFLAG = 21;
    private static final int INDEX_MEMO = 22;
    private static final int INDEX_PROCESSINGSTATE = 23;
    private static final int INDEX_PROCESSINGSTATETEXT = 24;
    private static final int INDEX_PSDEDTSQUEUEID = 25;
    private static final int INDEX_PSDEDTSQUEUENAME = 26;
    private static final int INDEX_PSDEID = 27;
    private static final int INDEX_PSDENAME = 28;
    private static final int INDEX_PSSYSSFPLUGINID = 29;
    private static final int INDEX_PSSYSSFPLUGINNAME = 30;
    private static final int INDEX_PSSYSTEMID = 31;
    private static final int INDEX_PSSYSTEMNAME = 32;
    private static final int INDEX_PUSHPSDEACTIONID = 33;
    private static final int INDEX_PUSHPSDEACTIONNAME = 34;
    private static final int INDEX_QUEUEPARAMS = 35;
    private static final int INDEX_REFRESHPSDEACTIONID = 36;
    private static final int INDEX_REFRESHPSDEACTIONNAME = 37;
    private static final int INDEX_REFRESHTIMER = 38;
    private static final int INDEX_STATEPSDEFID = 39;
    private static final int INDEX_STATEPSDEFNAME = 40;
    private static final int INDEX_TIMEPSDEFID = 41;
    private static final int INDEX_TIMEPSDEFNAME = 42;
    private static final int INDEX_UPDATEDATE = 43;
    private static final int INDEX_UPDATEMAN = 44;
    private static final int INDEX_USERCAT = 45;
    private static final int INDEX_USERTAG = 46;
    private static final int INDEX_USERTAG2 = 47;
    private static final int INDEX_USERTAG3 = 48;
    private static final int INDEX_USERTAG4 = 49;
    private static final int INDEX_VALIDFLAG = 50;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDTSQueueBase proxyPSDEDTSQueueBase = null;
    private boolean cancelledstateDirtyFlag = false;
    private boolean cancelledstatetextDirtyFlag = false;
    private boolean cancelpsdeactionidDirtyFlag = false;
    private boolean cancelpsdeactionnameDirtyFlag = false;
    private boolean canceltimeoutDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createdstateDirtyFlag = false;
    private boolean createdstatetextDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean errorpsdefidDirtyFlag = false;
    private boolean errorpsdefnameDirtyFlag = false;
    private boolean failedstateDirtyFlag = false;
    private boolean failedstatetextDirtyFlag = false;
    private boolean finishedstateDirtyFlag = false;
    private boolean finishedstatetextDirtyFlag = false;
    private boolean finishpsdeactionidDirtyFlag = false;
    private boolean finishpsdeactionnameDirtyFlag = false;
    private boolean historypsdeidDirtyFlag = false;
    private boolean historypsdenameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean processingstateDirtyFlag = false;
    private boolean processingstatetextDirtyFlag = false;
    private boolean psdedtsqueueidDirtyFlag = false;
    private boolean psdedtsqueuenameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pushpsdeactionidDirtyFlag = false;
    private boolean pushpsdeactionnameDirtyFlag = false;
    private boolean queueparamsDirtyFlag = false;
    private boolean refreshpsdeactionidDirtyFlag = false;
    private boolean refreshpsdeactionnameDirtyFlag = false;
    private boolean refreshtimerDirtyFlag = false;
    private boolean statepsdefidDirtyFlag = false;
    private boolean statepsdefnameDirtyFlag = false;
    private boolean timepsdefidDirtyFlag = false;
    private boolean timepsdefnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="cancelledstate")
    private String cancelledstate;
    @Column(name="cancelledstatetext")
    private String cancelledstatetext;
    @Column(name="cancelpsdeactionid")
    private String cancelpsdeactionid;
    @Column(name="cancelpsdeactionname")
    private String cancelpsdeactionname;
    @Column(name="canceltimeout")
    private Integer canceltimeout;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createdstate")
    private String createdstate;
    @Column(name="createdstatetext")
    private String createdstatetext;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="errorpsdefid")
    private String errorpsdefid;
    @Column(name="errorpsdefname")
    private String errorpsdefname;
    @Column(name="failedstate")
    private String failedstate;
    @Column(name="failedstatetext")
    private String failedstatetext;
    @Column(name="finishedstate")
    private String finishedstate;
    @Column(name="finishedstatetext")
    private String finishedstatetext;
    @Column(name="finishpsdeactionid")
    private String finishpsdeactionid;
    @Column(name="finishpsdeactionname")
    private String finishpsdeactionname;
    @Column(name="historypsdeid")
    private String historypsdeid;
    @Column(name="historypsdename")
    private String historypsdename;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="processingstate")
    private String processingstate;
    @Column(name="processingstatetext")
    private String processingstatetext;
    @Column(name="psdedtsqueueid")
    private String psdedtsqueueid;
    @Column(name="psdedtsqueuename")
    private String psdedtsqueuename;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pushpsdeactionid")
    private String pushpsdeactionid;
    @Column(name="pushpsdeactionname")
    private String pushpsdeactionname;
    @Column(name="queueparams")
    private String queueparams;
    @Column(name="refreshpsdeactionid")
    private String refreshpsdeactionid;
    @Column(name="refreshpsdeactionname")
    private String refreshpsdeactionname;
    @Column(name="refreshtimer")
    private Integer refreshtimer;
    @Column(name="statepsdefid")
    private String statepsdefid;
    @Column(name="statepsdefname")
    private String statepsdefname;
    @Column(name="timepsdefid")
    private String timepsdefid;
    @Column(name="timepsdefname")
    private String timepsdefname;
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
    @Column(name="validflag")
    private Integer validflag;
    private Integer objHistoryPSDELock = new Integer(1);
    private PSDataEntity historypsde = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objFinishPSDEActionLock = new Integer(1);
    private PSDEAction finishpsdeaction = null;
    private Integer objPushPSDEActionLock = new Integer(1);
    private PSDEAction pushpsdeaction = null;
    private Integer objRefreshPSDEActionLock = new Integer(1);
    private PSDEAction refreshpsdeaction = null;
    private Integer objErrorPSDEFLock = new Integer(1);
    private PSDEField errorpsdef = null;
    private Integer objStatePSDEFLock = new Integer(1);
    private PSDEField statepsdef = null;
    private Integer objTimePSDEFLock = new Integer(1);
    private PSDEField timepsdef = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setCancelledState(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCancelledState(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cancelledstate = string;
        this.cancelledstateDirtyFlag = true;
    }

    public String getCancelledState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCancelledState();
        }
        return this.cancelledstate;
    }

    public boolean isCancelledStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCancelledStateDirty();
        }
        return this.cancelledstateDirtyFlag;
    }

    public void resetCancelledState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCancelledState();
            return;
        }
        this.cancelledstateDirtyFlag = false;
        this.cancelledstate = null;
    }

    public void setCancelledStateText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCancelledStateText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cancelledstatetext = string;
        this.cancelledstatetextDirtyFlag = true;
    }

    public String getCancelledStateText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCancelledStateText();
        }
        return this.cancelledstatetext;
    }

    public boolean isCancelledStateTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCancelledStateTextDirty();
        }
        return this.cancelledstatetextDirtyFlag;
    }

    public void resetCancelledStateText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCancelledStateText();
            return;
        }
        this.cancelledstatetextDirtyFlag = false;
        this.cancelledstatetext = null;
    }

    public void setCancelPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCancelPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cancelpsdeactionid = string;
        this.cancelpsdeactionidDirtyFlag = true;
    }

    public String getCancelPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCancelPSDEActionId();
        }
        return this.cancelpsdeactionid;
    }

    public boolean isCancelPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCancelPSDEActionIdDirty();
        }
        return this.cancelpsdeactionidDirtyFlag;
    }

    public void resetCancelPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCancelPSDEActionId();
            return;
        }
        this.cancelpsdeactionidDirtyFlag = false;
        this.cancelpsdeactionid = null;
    }

    public void setCancelPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCancelPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cancelpsdeactionname = string;
        this.cancelpsdeactionnameDirtyFlag = true;
    }

    public String getCancelPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCancelPSDEActionName();
        }
        return this.cancelpsdeactionname;
    }

    public boolean isCancelPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCancelPSDEActionNameDirty();
        }
        return this.cancelpsdeactionnameDirtyFlag;
    }

    public void resetCancelPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCancelPSDEActionName();
            return;
        }
        this.cancelpsdeactionnameDirtyFlag = false;
        this.cancelpsdeactionname = null;
    }

    public void setCancelTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCancelTimeout(n);
            return;
        }
        this.canceltimeout = n;
        this.canceltimeoutDirtyFlag = true;
    }

    public Integer getCancelTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCancelTimeout();
        }
        return this.canceltimeout;
    }

    public boolean isCancelTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCancelTimeoutDirty();
        }
        return this.canceltimeoutDirtyFlag;
    }

    public void resetCancelTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCancelTimeout();
            return;
        }
        this.canceltimeoutDirtyFlag = false;
        this.canceltimeout = null;
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

    public void setCreatedState(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatedState(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createdstate = string;
        this.createdstateDirtyFlag = true;
    }

    public String getCreatedState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatedState();
        }
        return this.createdstate;
    }

    public boolean isCreatedStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatedStateDirty();
        }
        return this.createdstateDirtyFlag;
    }

    public void resetCreatedState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatedState();
            return;
        }
        this.createdstateDirtyFlag = false;
        this.createdstate = null;
    }

    public void setCreatedStateText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreatedStateText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createdstatetext = string;
        this.createdstatetextDirtyFlag = true;
    }

    public String getCreatedStateText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreatedStateText();
        }
        return this.createdstatetext;
    }

    public boolean isCreatedStateTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreatedStateTextDirty();
        }
        return this.createdstatetextDirtyFlag;
    }

    public void resetCreatedStateText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreatedStateText();
            return;
        }
        this.createdstatetextDirtyFlag = false;
        this.createdstatetext = null;
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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setErrorPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setErrorPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.errorpsdefid = string;
        this.errorpsdefidDirtyFlag = true;
    }

    public String getErrorPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorPSDEFId();
        }
        return this.errorpsdefid;
    }

    public boolean isErrorPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrorPSDEFIdDirty();
        }
        return this.errorpsdefidDirtyFlag;
    }

    public void resetErrorPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetErrorPSDEFId();
            return;
        }
        this.errorpsdefidDirtyFlag = false;
        this.errorpsdefid = null;
    }

    public void setErrorPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setErrorPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.errorpsdefname = string;
        this.errorpsdefnameDirtyFlag = true;
    }

    public String getErrorPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorPSDEFName();
        }
        return this.errorpsdefname;
    }

    public boolean isErrorPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrorPSDEFNameDirty();
        }
        return this.errorpsdefnameDirtyFlag;
    }

    public void resetErrorPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetErrorPSDEFName();
            return;
        }
        this.errorpsdefnameDirtyFlag = false;
        this.errorpsdefname = null;
    }

    public void setFailedState(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFailedState(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.failedstate = string;
        this.failedstateDirtyFlag = true;
    }

    public String getFailedState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFailedState();
        }
        return this.failedstate;
    }

    public boolean isFailedStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFailedStateDirty();
        }
        return this.failedstateDirtyFlag;
    }

    public void resetFailedState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFailedState();
            return;
        }
        this.failedstateDirtyFlag = false;
        this.failedstate = null;
    }

    public void setFailedStateText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFailedStateText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.failedstatetext = string;
        this.failedstatetextDirtyFlag = true;
    }

    public String getFailedStateText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFailedStateText();
        }
        return this.failedstatetext;
    }

    public boolean isFailedStateTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFailedStateTextDirty();
        }
        return this.failedstatetextDirtyFlag;
    }

    public void resetFailedStateText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFailedStateText();
            return;
        }
        this.failedstatetextDirtyFlag = false;
        this.failedstatetext = null;
    }

    public void setFinishedState(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishedState(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.finishedstate = string;
        this.finishedstateDirtyFlag = true;
    }

    public String getFinishedState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishedState();
        }
        return this.finishedstate;
    }

    public boolean isFinishedStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishedStateDirty();
        }
        return this.finishedstateDirtyFlag;
    }

    public void resetFinishedState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishedState();
            return;
        }
        this.finishedstateDirtyFlag = false;
        this.finishedstate = null;
    }

    public void setFinishedStateText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishedStateText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.finishedstatetext = string;
        this.finishedstatetextDirtyFlag = true;
    }

    public String getFinishedStateText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishedStateText();
        }
        return this.finishedstatetext;
    }

    public boolean isFinishedStateTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishedStateTextDirty();
        }
        return this.finishedstatetextDirtyFlag;
    }

    public void resetFinishedStateText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishedStateText();
            return;
        }
        this.finishedstatetextDirtyFlag = false;
        this.finishedstatetext = null;
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

    public void setHistoryPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHistoryPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.historypsdeid = string;
        this.historypsdeidDirtyFlag = true;
    }

    public String getHistoryPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHistoryPSDEId();
        }
        return this.historypsdeid;
    }

    public boolean isHistoryPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHistoryPSDEIdDirty();
        }
        return this.historypsdeidDirtyFlag;
    }

    public void resetHistoryPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHistoryPSDEId();
            return;
        }
        this.historypsdeidDirtyFlag = false;
        this.historypsdeid = null;
    }

    public void setHistoryPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHistoryPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.historypsdename = string;
        this.historypsdenameDirtyFlag = true;
    }

    public String getHistoryPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHistoryPSDEName();
        }
        return this.historypsdename;
    }

    public boolean isHistoryPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHistoryPSDENameDirty();
        }
        return this.historypsdenameDirtyFlag;
    }

    public void resetHistoryPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHistoryPSDEName();
            return;
        }
        this.historypsdenameDirtyFlag = false;
        this.historypsdename = null;
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

    public void setProcessingState(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProcessingState(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.processingstate = string;
        this.processingstateDirtyFlag = true;
    }

    public String getProcessingState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProcessingState();
        }
        return this.processingstate;
    }

    public boolean isProcessingStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProcessingStateDirty();
        }
        return this.processingstateDirtyFlag;
    }

    public void resetProcessingState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProcessingState();
            return;
        }
        this.processingstateDirtyFlag = false;
        this.processingstate = null;
    }

    public void setProcessingStateText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProcessingStateText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.processingstatetext = string;
        this.processingstatetextDirtyFlag = true;
    }

    public String getProcessingStateText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProcessingStateText();
        }
        return this.processingstatetext;
    }

    public boolean isProcessingStateTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProcessingStateTextDirty();
        }
        return this.processingstatetextDirtyFlag;
    }

    public void resetProcessingStateText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProcessingStateText();
            return;
        }
        this.processingstatetextDirtyFlag = false;
        this.processingstatetext = null;
    }

    public void setPSDEDTSQueueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDTSQueueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedtsqueueid = string;
        this.psdedtsqueueidDirtyFlag = true;
    }

    public String getPSDEDTSQueueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDTSQueueId();
        }
        return this.psdedtsqueueid;
    }

    public boolean isPSDEDTSQueueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDTSQueueIdDirty();
        }
        return this.psdedtsqueueidDirtyFlag;
    }

    public void resetPSDEDTSQueueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDTSQueueId();
            return;
        }
        this.psdedtsqueueidDirtyFlag = false;
        this.psdedtsqueueid = null;
    }

    public void setPSDEDTSQueueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDTSQueueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedtsqueuename = string;
        this.psdedtsqueuenameDirtyFlag = true;
    }

    public String getPSDEDTSQueueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDTSQueueName();
        }
        return this.psdedtsqueuename;
    }

    public boolean isPSDEDTSQueueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDTSQueueNameDirty();
        }
        return this.psdedtsqueuenameDirtyFlag;
    }

    public void resetPSDEDTSQueueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDTSQueueName();
            return;
        }
        this.psdedtsqueuenameDirtyFlag = false;
        this.psdedtsqueuename = null;
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

    public void setPushPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPushPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pushpsdeactionid = string;
        this.pushpsdeactionidDirtyFlag = true;
    }

    public String getPushPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPushPSDEActionId();
        }
        return this.pushpsdeactionid;
    }

    public boolean isPushPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPushPSDEActionIdDirty();
        }
        return this.pushpsdeactionidDirtyFlag;
    }

    public void resetPushPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPushPSDEActionId();
            return;
        }
        this.pushpsdeactionidDirtyFlag = false;
        this.pushpsdeactionid = null;
    }

    public void setPushPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPushPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pushpsdeactionname = string;
        this.pushpsdeactionnameDirtyFlag = true;
    }

    public String getPushPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPushPSDEActionName();
        }
        return this.pushpsdeactionname;
    }

    public boolean isPushPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPushPSDEActionNameDirty();
        }
        return this.pushpsdeactionnameDirtyFlag;
    }

    public void resetPushPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPushPSDEActionName();
            return;
        }
        this.pushpsdeactionnameDirtyFlag = false;
        this.pushpsdeactionname = null;
    }

    public void setQueueParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueueParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.queueparams = string;
        this.queueparamsDirtyFlag = true;
    }

    public String getQueueParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueueParams();
        }
        return this.queueparams;
    }

    public boolean isQueueParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueueParamsDirty();
        }
        return this.queueparamsDirtyFlag;
    }

    public void resetQueueParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueueParams();
            return;
        }
        this.queueparamsDirtyFlag = false;
        this.queueparams = null;
    }

    public void setRefreshPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefreshPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refreshpsdeactionid = string;
        this.refreshpsdeactionidDirtyFlag = true;
    }

    public String getRefreshPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefreshPSDEActionId();
        }
        return this.refreshpsdeactionid;
    }

    public boolean isRefreshPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefreshPSDEActionIdDirty();
        }
        return this.refreshpsdeactionidDirtyFlag;
    }

    public void resetRefreshPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefreshPSDEActionId();
            return;
        }
        this.refreshpsdeactionidDirtyFlag = false;
        this.refreshpsdeactionid = null;
    }

    public void setRefreshPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefreshPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refreshpsdeactionname = string;
        this.refreshpsdeactionnameDirtyFlag = true;
    }

    public String getRefreshPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefreshPSDEActionName();
        }
        return this.refreshpsdeactionname;
    }

    public boolean isRefreshPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefreshPSDEActionNameDirty();
        }
        return this.refreshpsdeactionnameDirtyFlag;
    }

    public void resetRefreshPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefreshPSDEActionName();
            return;
        }
        this.refreshpsdeactionnameDirtyFlag = false;
        this.refreshpsdeactionname = null;
    }

    public void setRefreshTimer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefreshTimer(n);
            return;
        }
        this.refreshtimer = n;
        this.refreshtimerDirtyFlag = true;
    }

    public Integer getRefreshTimer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefreshTimer();
        }
        return this.refreshtimer;
    }

    public boolean isRefreshTimerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefreshTimerDirty();
        }
        return this.refreshtimerDirtyFlag;
    }

    public void resetRefreshTimer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefreshTimer();
            return;
        }
        this.refreshtimerDirtyFlag = false;
        this.refreshtimer = null;
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

    public void setTimePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timepsdefid = string;
        this.timepsdefidDirtyFlag = true;
    }

    public String getTimePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimePSDEFId();
        }
        return this.timepsdefid;
    }

    public boolean isTimePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimePSDEFIdDirty();
        }
        return this.timepsdefidDirtyFlag;
    }

    public void resetTimePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimePSDEFId();
            return;
        }
        this.timepsdefidDirtyFlag = false;
        this.timepsdefid = null;
    }

    public void setTimePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timepsdefname = string;
        this.timepsdefnameDirtyFlag = true;
    }

    public String getTimePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimePSDEFName();
        }
        return this.timepsdefname;
    }

    public boolean isTimePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimePSDEFNameDirty();
        }
        return this.timepsdefnameDirtyFlag;
    }

    public void resetTimePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimePSDEFName();
            return;
        }
        this.timepsdefnameDirtyFlag = false;
        this.timepsdefname = null;
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
        PSDEDTSQueueBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDTSQueueBase pSDEDTSQueueBase) {
        pSDEDTSQueueBase.resetCancelledState();
        pSDEDTSQueueBase.resetCancelledStateText();
        pSDEDTSQueueBase.resetCancelPSDEActionId();
        pSDEDTSQueueBase.resetCancelPSDEActionName();
        pSDEDTSQueueBase.resetCancelTimeout();
        pSDEDTSQueueBase.resetCodeName();
        pSDEDTSQueueBase.resetCreateDate();
        pSDEDTSQueueBase.resetCreatedState();
        pSDEDTSQueueBase.resetCreatedStateText();
        pSDEDTSQueueBase.resetCreateMan();
        pSDEDTSQueueBase.resetDefaultFlag();
        pSDEDTSQueueBase.resetErrorPSDEFId();
        pSDEDTSQueueBase.resetErrorPSDEFName();
        pSDEDTSQueueBase.resetFailedState();
        pSDEDTSQueueBase.resetFailedStateText();
        pSDEDTSQueueBase.resetFinishedState();
        pSDEDTSQueueBase.resetFinishedStateText();
        pSDEDTSQueueBase.resetFinishPSDEActionId();
        pSDEDTSQueueBase.resetFinishPSDEActionName();
        pSDEDTSQueueBase.resetHistoryPSDEId();
        pSDEDTSQueueBase.resetHistoryPSDEName();
        pSDEDTSQueueBase.resetLockFlag();
        pSDEDTSQueueBase.resetMemo();
        pSDEDTSQueueBase.resetProcessingState();
        pSDEDTSQueueBase.resetProcessingStateText();
        pSDEDTSQueueBase.resetPSDEDTSQueueId();
        pSDEDTSQueueBase.resetPSDEDTSQueueName();
        pSDEDTSQueueBase.resetPSDEId();
        pSDEDTSQueueBase.resetPSDEName();
        pSDEDTSQueueBase.resetPSSysSFPluginId();
        pSDEDTSQueueBase.resetPSSysSFPluginName();
        pSDEDTSQueueBase.resetPSSystemId();
        pSDEDTSQueueBase.resetPSSystemName();
        pSDEDTSQueueBase.resetPushPSDEActionId();
        pSDEDTSQueueBase.resetPushPSDEActionName();
        pSDEDTSQueueBase.resetQueueParams();
        pSDEDTSQueueBase.resetRefreshPSDEActionId();
        pSDEDTSQueueBase.resetRefreshPSDEActionName();
        pSDEDTSQueueBase.resetRefreshTimer();
        pSDEDTSQueueBase.resetStatePSDEFId();
        pSDEDTSQueueBase.resetStatePSDEFName();
        pSDEDTSQueueBase.resetTimePSDEFId();
        pSDEDTSQueueBase.resetTimePSDEFName();
        pSDEDTSQueueBase.resetUpdateDate();
        pSDEDTSQueueBase.resetUpdateMan();
        pSDEDTSQueueBase.resetUserCat();
        pSDEDTSQueueBase.resetUserTag();
        pSDEDTSQueueBase.resetUserTag2();
        pSDEDTSQueueBase.resetUserTag3();
        pSDEDTSQueueBase.resetUserTag4();
        pSDEDTSQueueBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCancelledStateDirty()) {
            hashMap.put(FIELD_CANCELLEDSTATE, this.getCancelledState());
        }
        if (!bl || this.isCancelledStateTextDirty()) {
            hashMap.put(FIELD_CANCELLEDSTATETEXT, this.getCancelledStateText());
        }
        if (!bl || this.isCancelPSDEActionIdDirty()) {
            hashMap.put(FIELD_CANCELPSDEACTIONID, this.getCancelPSDEActionId());
        }
        if (!bl || this.isCancelPSDEActionNameDirty()) {
            hashMap.put(FIELD_CANCELPSDEACTIONNAME, this.getCancelPSDEActionName());
        }
        if (!bl || this.isCancelTimeoutDirty()) {
            hashMap.put(FIELD_CANCELTIMEOUT, this.getCancelTimeout());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreatedStateDirty()) {
            hashMap.put(FIELD_CREATEDSTATE, this.getCreatedState());
        }
        if (!bl || this.isCreatedStateTextDirty()) {
            hashMap.put(FIELD_CREATEDSTATETEXT, this.getCreatedStateText());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isErrorPSDEFIdDirty()) {
            hashMap.put(FIELD_ERRORPSDEFID, this.getErrorPSDEFId());
        }
        if (!bl || this.isErrorPSDEFNameDirty()) {
            hashMap.put(FIELD_ERRORPSDEFNAME, this.getErrorPSDEFName());
        }
        if (!bl || this.isFailedStateDirty()) {
            hashMap.put(FIELD_FAILEDSTATE, this.getFailedState());
        }
        if (!bl || this.isFailedStateTextDirty()) {
            hashMap.put(FIELD_FAILEDSTATETEXT, this.getFailedStateText());
        }
        if (!bl || this.isFinishedStateDirty()) {
            hashMap.put(FIELD_FINISHEDSTATE, this.getFinishedState());
        }
        if (!bl || this.isFinishedStateTextDirty()) {
            hashMap.put(FIELD_FINISHEDSTATETEXT, this.getFinishedStateText());
        }
        if (!bl || this.isFinishPSDEActionIdDirty()) {
            hashMap.put(FIELD_FINISHPSDEACTIONID, this.getFinishPSDEActionId());
        }
        if (!bl || this.isFinishPSDEActionNameDirty()) {
            hashMap.put(FIELD_FINISHPSDEACTIONNAME, this.getFinishPSDEActionName());
        }
        if (!bl || this.isHistoryPSDEIdDirty()) {
            hashMap.put(FIELD_HISTORYPSDEID, this.getHistoryPSDEId());
        }
        if (!bl || this.isHistoryPSDENameDirty()) {
            hashMap.put(FIELD_HISTORYPSDENAME, this.getHistoryPSDEName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isProcessingStateDirty()) {
            hashMap.put(FIELD_PROCESSINGSTATE, this.getProcessingState());
        }
        if (!bl || this.isProcessingStateTextDirty()) {
            hashMap.put(FIELD_PROCESSINGSTATETEXT, this.getProcessingStateText());
        }
        if (!bl || this.isPSDEDTSQueueIdDirty()) {
            hashMap.put(FIELD_PSDEDTSQUEUEID, this.getPSDEDTSQueueId());
        }
        if (!bl || this.isPSDEDTSQueueNameDirty()) {
            hashMap.put(FIELD_PSDEDTSQUEUENAME, this.getPSDEDTSQueueName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
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
        if (!bl || this.isPushPSDEActionIdDirty()) {
            hashMap.put(FIELD_PUSHPSDEACTIONID, this.getPushPSDEActionId());
        }
        if (!bl || this.isPushPSDEActionNameDirty()) {
            hashMap.put(FIELD_PUSHPSDEACTIONNAME, this.getPushPSDEActionName());
        }
        if (!bl || this.isQueueParamsDirty()) {
            hashMap.put(FIELD_QUEUEPARAMS, this.getQueueParams());
        }
        if (!bl || this.isRefreshPSDEActionIdDirty()) {
            hashMap.put(FIELD_REFRESHPSDEACTIONID, this.getRefreshPSDEActionId());
        }
        if (!bl || this.isRefreshPSDEActionNameDirty()) {
            hashMap.put(FIELD_REFRESHPSDEACTIONNAME, this.getRefreshPSDEActionName());
        }
        if (!bl || this.isRefreshTimerDirty()) {
            hashMap.put(FIELD_REFRESHTIMER, this.getRefreshTimer());
        }
        if (!bl || this.isStatePSDEFIdDirty()) {
            hashMap.put(FIELD_STATEPSDEFID, this.getStatePSDEFId());
        }
        if (!bl || this.isStatePSDEFNameDirty()) {
            hashMap.put(FIELD_STATEPSDEFNAME, this.getStatePSDEFName());
        }
        if (!bl || this.isTimePSDEFIdDirty()) {
            hashMap.put(FIELD_TIMEPSDEFID, this.getTimePSDEFId());
        }
        if (!bl || this.isTimePSDEFNameDirty()) {
            hashMap.put(FIELD_TIMEPSDEFNAME, this.getTimePSDEFName());
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
        return PSDEDTSQueueBase.get(this, n);
    }

    private static Object get(PSDEDTSQueueBase pSDEDTSQueueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDTSQueueBase.getCancelledState();
            }
            case 1: {
                return pSDEDTSQueueBase.getCancelledStateText();
            }
            case 2: {
                return pSDEDTSQueueBase.getCancelPSDEActionId();
            }
            case 3: {
                return pSDEDTSQueueBase.getCancelPSDEActionName();
            }
            case 4: {
                return pSDEDTSQueueBase.getCancelTimeout();
            }
            case 5: {
                return pSDEDTSQueueBase.getCodeName();
            }
            case 6: {
                return pSDEDTSQueueBase.getCreateDate();
            }
            case 7: {
                return pSDEDTSQueueBase.getCreatedState();
            }
            case 8: {
                return pSDEDTSQueueBase.getCreatedStateText();
            }
            case 9: {
                return pSDEDTSQueueBase.getCreateMan();
            }
            case 10: {
                return pSDEDTSQueueBase.getDefaultFlag();
            }
            case 11: {
                return pSDEDTSQueueBase.getErrorPSDEFId();
            }
            case 12: {
                return pSDEDTSQueueBase.getErrorPSDEFName();
            }
            case 13: {
                return pSDEDTSQueueBase.getFailedState();
            }
            case 14: {
                return pSDEDTSQueueBase.getFailedStateText();
            }
            case 15: {
                return pSDEDTSQueueBase.getFinishedState();
            }
            case 16: {
                return pSDEDTSQueueBase.getFinishedStateText();
            }
            case 17: {
                return pSDEDTSQueueBase.getFinishPSDEActionId();
            }
            case 18: {
                return pSDEDTSQueueBase.getFinishPSDEActionName();
            }
            case 19: {
                return pSDEDTSQueueBase.getHistoryPSDEId();
            }
            case 20: {
                return pSDEDTSQueueBase.getHistoryPSDEName();
            }
            case 21: {
                return pSDEDTSQueueBase.getLockFlag();
            }
            case 22: {
                return pSDEDTSQueueBase.getMemo();
            }
            case 23: {
                return pSDEDTSQueueBase.getProcessingState();
            }
            case 24: {
                return pSDEDTSQueueBase.getProcessingStateText();
            }
            case 25: {
                return pSDEDTSQueueBase.getPSDEDTSQueueId();
            }
            case 26: {
                return pSDEDTSQueueBase.getPSDEDTSQueueName();
            }
            case 27: {
                return pSDEDTSQueueBase.getPSDEId();
            }
            case 28: {
                return pSDEDTSQueueBase.getPSDEName();
            }
            case 29: {
                return pSDEDTSQueueBase.getPSSysSFPluginId();
            }
            case 30: {
                return pSDEDTSQueueBase.getPSSysSFPluginName();
            }
            case 31: {
                return pSDEDTSQueueBase.getPSSystemId();
            }
            case 32: {
                return pSDEDTSQueueBase.getPSSystemName();
            }
            case 33: {
                return pSDEDTSQueueBase.getPushPSDEActionId();
            }
            case 34: {
                return pSDEDTSQueueBase.getPushPSDEActionName();
            }
            case 35: {
                return pSDEDTSQueueBase.getQueueParams();
            }
            case 36: {
                return pSDEDTSQueueBase.getRefreshPSDEActionId();
            }
            case 37: {
                return pSDEDTSQueueBase.getRefreshPSDEActionName();
            }
            case 38: {
                return pSDEDTSQueueBase.getRefreshTimer();
            }
            case 39: {
                return pSDEDTSQueueBase.getStatePSDEFId();
            }
            case 40: {
                return pSDEDTSQueueBase.getStatePSDEFName();
            }
            case 41: {
                return pSDEDTSQueueBase.getTimePSDEFId();
            }
            case 42: {
                return pSDEDTSQueueBase.getTimePSDEFName();
            }
            case 43: {
                return pSDEDTSQueueBase.getUpdateDate();
            }
            case 44: {
                return pSDEDTSQueueBase.getUpdateMan();
            }
            case 45: {
                return pSDEDTSQueueBase.getUserCat();
            }
            case 46: {
                return pSDEDTSQueueBase.getUserTag();
            }
            case 47: {
                return pSDEDTSQueueBase.getUserTag2();
            }
            case 48: {
                return pSDEDTSQueueBase.getUserTag3();
            }
            case 49: {
                return pSDEDTSQueueBase.getUserTag4();
            }
            case 50: {
                return pSDEDTSQueueBase.getValidFlag();
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
        PSDEDTSQueueBase.set(this, n, object);
    }

    private static void set(PSDEDTSQueueBase pSDEDTSQueueBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDTSQueueBase.setCancelledState(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEDTSQueueBase.setCancelledStateText(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDTSQueueBase.setCancelPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDTSQueueBase.setCancelPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDTSQueueBase.setCancelTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEDTSQueueBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDTSQueueBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDEDTSQueueBase.setCreatedState(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDTSQueueBase.setCreatedStateText(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDTSQueueBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDTSQueueBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDEDTSQueueBase.setErrorPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEDTSQueueBase.setErrorPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDTSQueueBase.setFailedState(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEDTSQueueBase.setFailedStateText(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDTSQueueBase.setFinishedState(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEDTSQueueBase.setFinishedStateText(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDTSQueueBase.setFinishPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEDTSQueueBase.setFinishPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEDTSQueueBase.setHistoryPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDTSQueueBase.setHistoryPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDTSQueueBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEDTSQueueBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEDTSQueueBase.setProcessingState(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDTSQueueBase.setProcessingStateText(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDTSQueueBase.setPSDEDTSQueueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDTSQueueBase.setPSDEDTSQueueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDTSQueueBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEDTSQueueBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEDTSQueueBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEDTSQueueBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEDTSQueueBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEDTSQueueBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEDTSQueueBase.setPushPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEDTSQueueBase.setPushPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEDTSQueueBase.setQueueParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEDTSQueueBase.setRefreshPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEDTSQueueBase.setRefreshPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEDTSQueueBase.setRefreshTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSDEDTSQueueBase.setStatePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEDTSQueueBase.setStatePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEDTSQueueBase.setTimePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEDTSQueueBase.setTimePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEDTSQueueBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 44: {
                pSDEDTSQueueBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEDTSQueueBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEDTSQueueBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEDTSQueueBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEDTSQueueBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEDTSQueueBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEDTSQueueBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEDTSQueueBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDTSQueueBase pSDEDTSQueueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDTSQueueBase.getCancelledState() == null;
            }
            case 1: {
                return pSDEDTSQueueBase.getCancelledStateText() == null;
            }
            case 2: {
                return pSDEDTSQueueBase.getCancelPSDEActionId() == null;
            }
            case 3: {
                return pSDEDTSQueueBase.getCancelPSDEActionName() == null;
            }
            case 4: {
                return pSDEDTSQueueBase.getCancelTimeout() == null;
            }
            case 5: {
                return pSDEDTSQueueBase.getCodeName() == null;
            }
            case 6: {
                return pSDEDTSQueueBase.getCreateDate() == null;
            }
            case 7: {
                return pSDEDTSQueueBase.getCreatedState() == null;
            }
            case 8: {
                return pSDEDTSQueueBase.getCreatedStateText() == null;
            }
            case 9: {
                return pSDEDTSQueueBase.getCreateMan() == null;
            }
            case 10: {
                return pSDEDTSQueueBase.getDefaultFlag() == null;
            }
            case 11: {
                return pSDEDTSQueueBase.getErrorPSDEFId() == null;
            }
            case 12: {
                return pSDEDTSQueueBase.getErrorPSDEFName() == null;
            }
            case 13: {
                return pSDEDTSQueueBase.getFailedState() == null;
            }
            case 14: {
                return pSDEDTSQueueBase.getFailedStateText() == null;
            }
            case 15: {
                return pSDEDTSQueueBase.getFinishedState() == null;
            }
            case 16: {
                return pSDEDTSQueueBase.getFinishedStateText() == null;
            }
            case 17: {
                return pSDEDTSQueueBase.getFinishPSDEActionId() == null;
            }
            case 18: {
                return pSDEDTSQueueBase.getFinishPSDEActionName() == null;
            }
            case 19: {
                return pSDEDTSQueueBase.getHistoryPSDEId() == null;
            }
            case 20: {
                return pSDEDTSQueueBase.getHistoryPSDEName() == null;
            }
            case 21: {
                return pSDEDTSQueueBase.getLockFlag() == null;
            }
            case 22: {
                return pSDEDTSQueueBase.getMemo() == null;
            }
            case 23: {
                return pSDEDTSQueueBase.getProcessingState() == null;
            }
            case 24: {
                return pSDEDTSQueueBase.getProcessingStateText() == null;
            }
            case 25: {
                return pSDEDTSQueueBase.getPSDEDTSQueueId() == null;
            }
            case 26: {
                return pSDEDTSQueueBase.getPSDEDTSQueueName() == null;
            }
            case 27: {
                return pSDEDTSQueueBase.getPSDEId() == null;
            }
            case 28: {
                return pSDEDTSQueueBase.getPSDEName() == null;
            }
            case 29: {
                return pSDEDTSQueueBase.getPSSysSFPluginId() == null;
            }
            case 30: {
                return pSDEDTSQueueBase.getPSSysSFPluginName() == null;
            }
            case 31: {
                return pSDEDTSQueueBase.getPSSystemId() == null;
            }
            case 32: {
                return pSDEDTSQueueBase.getPSSystemName() == null;
            }
            case 33: {
                return pSDEDTSQueueBase.getPushPSDEActionId() == null;
            }
            case 34: {
                return pSDEDTSQueueBase.getPushPSDEActionName() == null;
            }
            case 35: {
                return pSDEDTSQueueBase.getQueueParams() == null;
            }
            case 36: {
                return pSDEDTSQueueBase.getRefreshPSDEActionId() == null;
            }
            case 37: {
                return pSDEDTSQueueBase.getRefreshPSDEActionName() == null;
            }
            case 38: {
                return pSDEDTSQueueBase.getRefreshTimer() == null;
            }
            case 39: {
                return pSDEDTSQueueBase.getStatePSDEFId() == null;
            }
            case 40: {
                return pSDEDTSQueueBase.getStatePSDEFName() == null;
            }
            case 41: {
                return pSDEDTSQueueBase.getTimePSDEFId() == null;
            }
            case 42: {
                return pSDEDTSQueueBase.getTimePSDEFName() == null;
            }
            case 43: {
                return pSDEDTSQueueBase.getUpdateDate() == null;
            }
            case 44: {
                return pSDEDTSQueueBase.getUpdateMan() == null;
            }
            case 45: {
                return pSDEDTSQueueBase.getUserCat() == null;
            }
            case 46: {
                return pSDEDTSQueueBase.getUserTag() == null;
            }
            case 47: {
                return pSDEDTSQueueBase.getUserTag2() == null;
            }
            case 48: {
                return pSDEDTSQueueBase.getUserTag3() == null;
            }
            case 49: {
                return pSDEDTSQueueBase.getUserTag4() == null;
            }
            case 50: {
                return pSDEDTSQueueBase.getValidFlag() == null;
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
        return PSDEDTSQueueBase.contains(this, n);
    }

    private static boolean contains(PSDEDTSQueueBase pSDEDTSQueueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDTSQueueBase.isCancelledStateDirty();
            }
            case 1: {
                return pSDEDTSQueueBase.isCancelledStateTextDirty();
            }
            case 2: {
                return pSDEDTSQueueBase.isCancelPSDEActionIdDirty();
            }
            case 3: {
                return pSDEDTSQueueBase.isCancelPSDEActionNameDirty();
            }
            case 4: {
                return pSDEDTSQueueBase.isCancelTimeoutDirty();
            }
            case 5: {
                return pSDEDTSQueueBase.isCodeNameDirty();
            }
            case 6: {
                return pSDEDTSQueueBase.isCreateDateDirty();
            }
            case 7: {
                return pSDEDTSQueueBase.isCreatedStateDirty();
            }
            case 8: {
                return pSDEDTSQueueBase.isCreatedStateTextDirty();
            }
            case 9: {
                return pSDEDTSQueueBase.isCreateManDirty();
            }
            case 10: {
                return pSDEDTSQueueBase.isDefaultFlagDirty();
            }
            case 11: {
                return pSDEDTSQueueBase.isErrorPSDEFIdDirty();
            }
            case 12: {
                return pSDEDTSQueueBase.isErrorPSDEFNameDirty();
            }
            case 13: {
                return pSDEDTSQueueBase.isFailedStateDirty();
            }
            case 14: {
                return pSDEDTSQueueBase.isFailedStateTextDirty();
            }
            case 15: {
                return pSDEDTSQueueBase.isFinishedStateDirty();
            }
            case 16: {
                return pSDEDTSQueueBase.isFinishedStateTextDirty();
            }
            case 17: {
                return pSDEDTSQueueBase.isFinishPSDEActionIdDirty();
            }
            case 18: {
                return pSDEDTSQueueBase.isFinishPSDEActionNameDirty();
            }
            case 19: {
                return pSDEDTSQueueBase.isHistoryPSDEIdDirty();
            }
            case 20: {
                return pSDEDTSQueueBase.isHistoryPSDENameDirty();
            }
            case 21: {
                return pSDEDTSQueueBase.isLockFlagDirty();
            }
            case 22: {
                return pSDEDTSQueueBase.isMemoDirty();
            }
            case 23: {
                return pSDEDTSQueueBase.isProcessingStateDirty();
            }
            case 24: {
                return pSDEDTSQueueBase.isProcessingStateTextDirty();
            }
            case 25: {
                return pSDEDTSQueueBase.isPSDEDTSQueueIdDirty();
            }
            case 26: {
                return pSDEDTSQueueBase.isPSDEDTSQueueNameDirty();
            }
            case 27: {
                return pSDEDTSQueueBase.isPSDEIdDirty();
            }
            case 28: {
                return pSDEDTSQueueBase.isPSDENameDirty();
            }
            case 29: {
                return pSDEDTSQueueBase.isPSSysSFPluginIdDirty();
            }
            case 30: {
                return pSDEDTSQueueBase.isPSSysSFPluginNameDirty();
            }
            case 31: {
                return pSDEDTSQueueBase.isPSSystemIdDirty();
            }
            case 32: {
                return pSDEDTSQueueBase.isPSSystemNameDirty();
            }
            case 33: {
                return pSDEDTSQueueBase.isPushPSDEActionIdDirty();
            }
            case 34: {
                return pSDEDTSQueueBase.isPushPSDEActionNameDirty();
            }
            case 35: {
                return pSDEDTSQueueBase.isQueueParamsDirty();
            }
            case 36: {
                return pSDEDTSQueueBase.isRefreshPSDEActionIdDirty();
            }
            case 37: {
                return pSDEDTSQueueBase.isRefreshPSDEActionNameDirty();
            }
            case 38: {
                return pSDEDTSQueueBase.isRefreshTimerDirty();
            }
            case 39: {
                return pSDEDTSQueueBase.isStatePSDEFIdDirty();
            }
            case 40: {
                return pSDEDTSQueueBase.isStatePSDEFNameDirty();
            }
            case 41: {
                return pSDEDTSQueueBase.isTimePSDEFIdDirty();
            }
            case 42: {
                return pSDEDTSQueueBase.isTimePSDEFNameDirty();
            }
            case 43: {
                return pSDEDTSQueueBase.isUpdateDateDirty();
            }
            case 44: {
                return pSDEDTSQueueBase.isUpdateManDirty();
            }
            case 45: {
                return pSDEDTSQueueBase.isUserCatDirty();
            }
            case 46: {
                return pSDEDTSQueueBase.isUserTagDirty();
            }
            case 47: {
                return pSDEDTSQueueBase.isUserTag2Dirty();
            }
            case 48: {
                return pSDEDTSQueueBase.isUserTag3Dirty();
            }
            case 49: {
                return pSDEDTSQueueBase.isUserTag4Dirty();
            }
            case 50: {
                return pSDEDTSQueueBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDTSQueueBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDTSQueueBase pSDEDTSQueueBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDTSQueueBase.getCancelledState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cancelledstate", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getCancelledState()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getCancelledStateText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cancelledstatetext", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getCancelledStateText()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getCancelPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cancelpsdeactionid", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getCancelPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getCancelPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cancelpsdeactionname", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getCancelPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getCancelTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"canceltimeout", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getCancelTimeout()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getCreatedState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdstate", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getCreatedState()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getCreatedStateText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdstatetext", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getCreatedStateText()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getErrorPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"errorpsdefid", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getErrorPSDEFId()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getErrorPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"errorpsdefname", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getErrorPSDEFName()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getFailedState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"failedstate", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getFailedState()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getFailedStateText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"failedstatetext", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getFailedStateText()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getFinishedState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishedstate", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getFinishedState()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getFinishedStateText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishedstatetext", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getFinishedStateText()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getFinishPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishpsdeactionid", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getFinishPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getFinishPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishpsdeactionname", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getFinishPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getHistoryPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"historypsdeid", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getHistoryPSDEId()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getHistoryPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"historypsdename", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getHistoryPSDEName()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getProcessingState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"processingstate", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getProcessingState()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getProcessingStateText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"processingstatetext", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getProcessingStateText()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getPSDEDTSQueueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedtsqueueid", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getPSDEDTSQueueId()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getPSDEDTSQueueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedtsqueuename", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getPSDEDTSQueueName()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getPushPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pushpsdeactionid", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getPushPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getPushPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pushpsdeactionname", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getPushPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getQueueParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"queueparams", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getQueueParams()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getRefreshPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refreshpsdeactionid", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getRefreshPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getRefreshPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refreshpsdeactionname", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getRefreshPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getRefreshTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refreshtimer", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getRefreshTimer()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getStatePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statepsdefid", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getStatePSDEFId()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getStatePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"statepsdefname", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getStatePSDEFName()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getTimePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timepsdefid", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getTimePSDEFId()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getTimePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timepsdefname", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getTimePSDEFName()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEDTSQueueBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEDTSQueueBase.getJSONValue((Object)pSDEDTSQueueBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDTSQueueBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDTSQueueBase pSDEDTSQueueBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDTSQueueBase.getCancelledState() != null) {
            object = pSDEDTSQueueBase.getCancelledState();
            xmlNode.setAttribute(FIELD_CANCELLEDSTATE, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDTSQueueBase.getCancelledStateText() != null) {
            object = pSDEDTSQueueBase.getCancelledStateText();
            xmlNode.setAttribute(FIELD_CANCELLEDSTATETEXT, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDTSQueueBase.getCancelPSDEActionId() != null) {
            object = pSDEDTSQueueBase.getCancelPSDEActionId();
            xmlNode.setAttribute(FIELD_CANCELPSDEACTIONID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDTSQueueBase.getCancelPSDEActionName() != null) {
            object = pSDEDTSQueueBase.getCancelPSDEActionName();
            xmlNode.setAttribute(FIELD_CANCELPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getCancelTimeout() != null) {
            object = pSDEDTSQueueBase.getCancelTimeout();
            xmlNode.setAttribute(FIELD_CANCELTIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDTSQueueBase.getCodeName() != null) {
            object = pSDEDTSQueueBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getCreateDate() != null) {
            object = pSDEDTSQueueBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDTSQueueBase.getCreatedState() != null) {
            object = pSDEDTSQueueBase.getCreatedState();
            xmlNode.setAttribute(FIELD_CREATEDSTATE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getCreatedStateText() != null) {
            object = pSDEDTSQueueBase.getCreatedStateText();
            xmlNode.setAttribute(FIELD_CREATEDSTATETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getCreateMan() != null) {
            object = pSDEDTSQueueBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getDefaultFlag() != null) {
            object = pSDEDTSQueueBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDTSQueueBase.getErrorPSDEFId() != null) {
            object = pSDEDTSQueueBase.getErrorPSDEFId();
            xmlNode.setAttribute(FIELD_ERRORPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getErrorPSDEFName() != null) {
            object = pSDEDTSQueueBase.getErrorPSDEFName();
            xmlNode.setAttribute(FIELD_ERRORPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getFailedState() != null) {
            object = pSDEDTSQueueBase.getFailedState();
            xmlNode.setAttribute(FIELD_FAILEDSTATE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getFailedStateText() != null) {
            object = pSDEDTSQueueBase.getFailedStateText();
            xmlNode.setAttribute(FIELD_FAILEDSTATETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getFinishedState() != null) {
            object = pSDEDTSQueueBase.getFinishedState();
            xmlNode.setAttribute(FIELD_FINISHEDSTATE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getFinishedStateText() != null) {
            object = pSDEDTSQueueBase.getFinishedStateText();
            xmlNode.setAttribute(FIELD_FINISHEDSTATETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getFinishPSDEActionId() != null) {
            object = pSDEDTSQueueBase.getFinishPSDEActionId();
            xmlNode.setAttribute(FIELD_FINISHPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getFinishPSDEActionName() != null) {
            object = pSDEDTSQueueBase.getFinishPSDEActionName();
            xmlNode.setAttribute(FIELD_FINISHPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getHistoryPSDEId() != null) {
            object = pSDEDTSQueueBase.getHistoryPSDEId();
            xmlNode.setAttribute(FIELD_HISTORYPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getHistoryPSDEName() != null) {
            object = pSDEDTSQueueBase.getHistoryPSDEName();
            xmlNode.setAttribute(FIELD_HISTORYPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getLockFlag() != null) {
            object = pSDEDTSQueueBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDTSQueueBase.getMemo() != null) {
            object = pSDEDTSQueueBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getProcessingState() != null) {
            object = pSDEDTSQueueBase.getProcessingState();
            xmlNode.setAttribute(FIELD_PROCESSINGSTATE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getProcessingStateText() != null) {
            object = pSDEDTSQueueBase.getProcessingStateText();
            xmlNode.setAttribute(FIELD_PROCESSINGSTATETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getPSDEDTSQueueId() != null) {
            object = pSDEDTSQueueBase.getPSDEDTSQueueId();
            xmlNode.setAttribute(FIELD_PSDEDTSQUEUEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getPSDEDTSQueueName() != null) {
            object = pSDEDTSQueueBase.getPSDEDTSQueueName();
            xmlNode.setAttribute(FIELD_PSDEDTSQUEUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getPSDEId() != null) {
            object = pSDEDTSQueueBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getPSDEName() != null) {
            object = pSDEDTSQueueBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getPSSysSFPluginId() != null) {
            object = pSDEDTSQueueBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getPSSysSFPluginName() != null) {
            object = pSDEDTSQueueBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getPSSystemId() != null) {
            object = pSDEDTSQueueBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getPSSystemName() != null) {
            object = pSDEDTSQueueBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getPushPSDEActionId() != null) {
            object = pSDEDTSQueueBase.getPushPSDEActionId();
            xmlNode.setAttribute(FIELD_PUSHPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getPushPSDEActionName() != null) {
            object = pSDEDTSQueueBase.getPushPSDEActionName();
            xmlNode.setAttribute(FIELD_PUSHPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getQueueParams() != null) {
            object = pSDEDTSQueueBase.getQueueParams();
            xmlNode.setAttribute(FIELD_QUEUEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getRefreshPSDEActionId() != null) {
            object = pSDEDTSQueueBase.getRefreshPSDEActionId();
            xmlNode.setAttribute(FIELD_REFRESHPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getRefreshPSDEActionName() != null) {
            object = pSDEDTSQueueBase.getRefreshPSDEActionName();
            xmlNode.setAttribute(FIELD_REFRESHPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getRefreshTimer() != null) {
            object = pSDEDTSQueueBase.getRefreshTimer();
            xmlNode.setAttribute(FIELD_REFRESHTIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDTSQueueBase.getStatePSDEFId() != null) {
            object = pSDEDTSQueueBase.getStatePSDEFId();
            xmlNode.setAttribute(FIELD_STATEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getStatePSDEFName() != null) {
            object = pSDEDTSQueueBase.getStatePSDEFName();
            xmlNode.setAttribute(FIELD_STATEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getTimePSDEFId() != null) {
            object = pSDEDTSQueueBase.getTimePSDEFId();
            xmlNode.setAttribute(FIELD_TIMEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getTimePSDEFName() != null) {
            object = pSDEDTSQueueBase.getTimePSDEFName();
            xmlNode.setAttribute(FIELD_TIMEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getUpdateDate() != null) {
            object = pSDEDTSQueueBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDTSQueueBase.getUpdateMan() != null) {
            object = pSDEDTSQueueBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getUserCat() != null) {
            object = pSDEDTSQueueBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getUserTag() != null) {
            object = pSDEDTSQueueBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getUserTag2() != null) {
            object = pSDEDTSQueueBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getUserTag3() != null) {
            object = pSDEDTSQueueBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getUserTag4() != null) {
            object = pSDEDTSQueueBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDTSQueueBase.getValidFlag() != null) {
            object = pSDEDTSQueueBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDTSQueueBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDTSQueueBase pSDEDTSQueueBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDTSQueueBase.isCancelledStateDirty() && (bl || pSDEDTSQueueBase.getCancelledState() != null)) {
            iDataObject.set(FIELD_CANCELLEDSTATE, (Object)pSDEDTSQueueBase.getCancelledState());
        }
        if (pSDEDTSQueueBase.isCancelledStateTextDirty() && (bl || pSDEDTSQueueBase.getCancelledStateText() != null)) {
            iDataObject.set(FIELD_CANCELLEDSTATETEXT, (Object)pSDEDTSQueueBase.getCancelledStateText());
        }
        if (pSDEDTSQueueBase.isCancelPSDEActionIdDirty() && (bl || pSDEDTSQueueBase.getCancelPSDEActionId() != null)) {
            iDataObject.set(FIELD_CANCELPSDEACTIONID, (Object)pSDEDTSQueueBase.getCancelPSDEActionId());
        }
        if (pSDEDTSQueueBase.isCancelPSDEActionNameDirty() && (bl || pSDEDTSQueueBase.getCancelPSDEActionName() != null)) {
            iDataObject.set(FIELD_CANCELPSDEACTIONNAME, (Object)pSDEDTSQueueBase.getCancelPSDEActionName());
        }
        if (pSDEDTSQueueBase.isCancelTimeoutDirty() && (bl || pSDEDTSQueueBase.getCancelTimeout() != null)) {
            iDataObject.set(FIELD_CANCELTIMEOUT, (Object)pSDEDTSQueueBase.getCancelTimeout());
        }
        if (pSDEDTSQueueBase.isCodeNameDirty() && (bl || pSDEDTSQueueBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEDTSQueueBase.getCodeName());
        }
        if (pSDEDTSQueueBase.isCreateDateDirty() && (bl || pSDEDTSQueueBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDTSQueueBase.getCreateDate());
        }
        if (pSDEDTSQueueBase.isCreatedStateDirty() && (bl || pSDEDTSQueueBase.getCreatedState() != null)) {
            iDataObject.set(FIELD_CREATEDSTATE, (Object)pSDEDTSQueueBase.getCreatedState());
        }
        if (pSDEDTSQueueBase.isCreatedStateTextDirty() && (bl || pSDEDTSQueueBase.getCreatedStateText() != null)) {
            iDataObject.set(FIELD_CREATEDSTATETEXT, (Object)pSDEDTSQueueBase.getCreatedStateText());
        }
        if (pSDEDTSQueueBase.isCreateManDirty() && (bl || pSDEDTSQueueBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDTSQueueBase.getCreateMan());
        }
        if (pSDEDTSQueueBase.isDefaultFlagDirty() && (bl || pSDEDTSQueueBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDEDTSQueueBase.getDefaultFlag());
        }
        if (pSDEDTSQueueBase.isErrorPSDEFIdDirty() && (bl || pSDEDTSQueueBase.getErrorPSDEFId() != null)) {
            iDataObject.set(FIELD_ERRORPSDEFID, (Object)pSDEDTSQueueBase.getErrorPSDEFId());
        }
        if (pSDEDTSQueueBase.isErrorPSDEFNameDirty() && (bl || pSDEDTSQueueBase.getErrorPSDEFName() != null)) {
            iDataObject.set(FIELD_ERRORPSDEFNAME, (Object)pSDEDTSQueueBase.getErrorPSDEFName());
        }
        if (pSDEDTSQueueBase.isFailedStateDirty() && (bl || pSDEDTSQueueBase.getFailedState() != null)) {
            iDataObject.set(FIELD_FAILEDSTATE, (Object)pSDEDTSQueueBase.getFailedState());
        }
        if (pSDEDTSQueueBase.isFailedStateTextDirty() && (bl || pSDEDTSQueueBase.getFailedStateText() != null)) {
            iDataObject.set(FIELD_FAILEDSTATETEXT, (Object)pSDEDTSQueueBase.getFailedStateText());
        }
        if (pSDEDTSQueueBase.isFinishedStateDirty() && (bl || pSDEDTSQueueBase.getFinishedState() != null)) {
            iDataObject.set(FIELD_FINISHEDSTATE, (Object)pSDEDTSQueueBase.getFinishedState());
        }
        if (pSDEDTSQueueBase.isFinishedStateTextDirty() && (bl || pSDEDTSQueueBase.getFinishedStateText() != null)) {
            iDataObject.set(FIELD_FINISHEDSTATETEXT, (Object)pSDEDTSQueueBase.getFinishedStateText());
        }
        if (pSDEDTSQueueBase.isFinishPSDEActionIdDirty() && (bl || pSDEDTSQueueBase.getFinishPSDEActionId() != null)) {
            iDataObject.set(FIELD_FINISHPSDEACTIONID, (Object)pSDEDTSQueueBase.getFinishPSDEActionId());
        }
        if (pSDEDTSQueueBase.isFinishPSDEActionNameDirty() && (bl || pSDEDTSQueueBase.getFinishPSDEActionName() != null)) {
            iDataObject.set(FIELD_FINISHPSDEACTIONNAME, (Object)pSDEDTSQueueBase.getFinishPSDEActionName());
        }
        if (pSDEDTSQueueBase.isHistoryPSDEIdDirty() && (bl || pSDEDTSQueueBase.getHistoryPSDEId() != null)) {
            iDataObject.set(FIELD_HISTORYPSDEID, (Object)pSDEDTSQueueBase.getHistoryPSDEId());
        }
        if (pSDEDTSQueueBase.isHistoryPSDENameDirty() && (bl || pSDEDTSQueueBase.getHistoryPSDEName() != null)) {
            iDataObject.set(FIELD_HISTORYPSDENAME, (Object)pSDEDTSQueueBase.getHistoryPSDEName());
        }
        if (pSDEDTSQueueBase.isLockFlagDirty() && (bl || pSDEDTSQueueBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEDTSQueueBase.getLockFlag());
        }
        if (pSDEDTSQueueBase.isMemoDirty() && (bl || pSDEDTSQueueBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDTSQueueBase.getMemo());
        }
        if (pSDEDTSQueueBase.isProcessingStateDirty() && (bl || pSDEDTSQueueBase.getProcessingState() != null)) {
            iDataObject.set(FIELD_PROCESSINGSTATE, (Object)pSDEDTSQueueBase.getProcessingState());
        }
        if (pSDEDTSQueueBase.isProcessingStateTextDirty() && (bl || pSDEDTSQueueBase.getProcessingStateText() != null)) {
            iDataObject.set(FIELD_PROCESSINGSTATETEXT, (Object)pSDEDTSQueueBase.getProcessingStateText());
        }
        if (pSDEDTSQueueBase.isPSDEDTSQueueIdDirty() && (bl || pSDEDTSQueueBase.getPSDEDTSQueueId() != null)) {
            iDataObject.set(FIELD_PSDEDTSQUEUEID, (Object)pSDEDTSQueueBase.getPSDEDTSQueueId());
        }
        if (pSDEDTSQueueBase.isPSDEDTSQueueNameDirty() && (bl || pSDEDTSQueueBase.getPSDEDTSQueueName() != null)) {
            iDataObject.set(FIELD_PSDEDTSQUEUENAME, (Object)pSDEDTSQueueBase.getPSDEDTSQueueName());
        }
        if (pSDEDTSQueueBase.isPSDEIdDirty() && (bl || pSDEDTSQueueBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDTSQueueBase.getPSDEId());
        }
        if (pSDEDTSQueueBase.isPSDENameDirty() && (bl || pSDEDTSQueueBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEDTSQueueBase.getPSDEName());
        }
        if (pSDEDTSQueueBase.isPSSysSFPluginIdDirty() && (bl || pSDEDTSQueueBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEDTSQueueBase.getPSSysSFPluginId());
        }
        if (pSDEDTSQueueBase.isPSSysSFPluginNameDirty() && (bl || pSDEDTSQueueBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEDTSQueueBase.getPSSysSFPluginName());
        }
        if (pSDEDTSQueueBase.isPSSystemIdDirty() && (bl || pSDEDTSQueueBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEDTSQueueBase.getPSSystemId());
        }
        if (pSDEDTSQueueBase.isPSSystemNameDirty() && (bl || pSDEDTSQueueBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDEDTSQueueBase.getPSSystemName());
        }
        if (pSDEDTSQueueBase.isPushPSDEActionIdDirty() && (bl || pSDEDTSQueueBase.getPushPSDEActionId() != null)) {
            iDataObject.set(FIELD_PUSHPSDEACTIONID, (Object)pSDEDTSQueueBase.getPushPSDEActionId());
        }
        if (pSDEDTSQueueBase.isPushPSDEActionNameDirty() && (bl || pSDEDTSQueueBase.getPushPSDEActionName() != null)) {
            iDataObject.set(FIELD_PUSHPSDEACTIONNAME, (Object)pSDEDTSQueueBase.getPushPSDEActionName());
        }
        if (pSDEDTSQueueBase.isQueueParamsDirty() && (bl || pSDEDTSQueueBase.getQueueParams() != null)) {
            iDataObject.set(FIELD_QUEUEPARAMS, (Object)pSDEDTSQueueBase.getQueueParams());
        }
        if (pSDEDTSQueueBase.isRefreshPSDEActionIdDirty() && (bl || pSDEDTSQueueBase.getRefreshPSDEActionId() != null)) {
            iDataObject.set(FIELD_REFRESHPSDEACTIONID, (Object)pSDEDTSQueueBase.getRefreshPSDEActionId());
        }
        if (pSDEDTSQueueBase.isRefreshPSDEActionNameDirty() && (bl || pSDEDTSQueueBase.getRefreshPSDEActionName() != null)) {
            iDataObject.set(FIELD_REFRESHPSDEACTIONNAME, (Object)pSDEDTSQueueBase.getRefreshPSDEActionName());
        }
        if (pSDEDTSQueueBase.isRefreshTimerDirty() && (bl || pSDEDTSQueueBase.getRefreshTimer() != null)) {
            iDataObject.set(FIELD_REFRESHTIMER, (Object)pSDEDTSQueueBase.getRefreshTimer());
        }
        if (pSDEDTSQueueBase.isStatePSDEFIdDirty() && (bl || pSDEDTSQueueBase.getStatePSDEFId() != null)) {
            iDataObject.set(FIELD_STATEPSDEFID, (Object)pSDEDTSQueueBase.getStatePSDEFId());
        }
        if (pSDEDTSQueueBase.isStatePSDEFNameDirty() && (bl || pSDEDTSQueueBase.getStatePSDEFName() != null)) {
            iDataObject.set(FIELD_STATEPSDEFNAME, (Object)pSDEDTSQueueBase.getStatePSDEFName());
        }
        if (pSDEDTSQueueBase.isTimePSDEFIdDirty() && (bl || pSDEDTSQueueBase.getTimePSDEFId() != null)) {
            iDataObject.set(FIELD_TIMEPSDEFID, (Object)pSDEDTSQueueBase.getTimePSDEFId());
        }
        if (pSDEDTSQueueBase.isTimePSDEFNameDirty() && (bl || pSDEDTSQueueBase.getTimePSDEFName() != null)) {
            iDataObject.set(FIELD_TIMEPSDEFNAME, (Object)pSDEDTSQueueBase.getTimePSDEFName());
        }
        if (pSDEDTSQueueBase.isUpdateDateDirty() && (bl || pSDEDTSQueueBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDTSQueueBase.getUpdateDate());
        }
        if (pSDEDTSQueueBase.isUpdateManDirty() && (bl || pSDEDTSQueueBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDTSQueueBase.getUpdateMan());
        }
        if (pSDEDTSQueueBase.isUserCatDirty() && (bl || pSDEDTSQueueBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDTSQueueBase.getUserCat());
        }
        if (pSDEDTSQueueBase.isUserTagDirty() && (bl || pSDEDTSQueueBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDTSQueueBase.getUserTag());
        }
        if (pSDEDTSQueueBase.isUserTag2Dirty() && (bl || pSDEDTSQueueBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDTSQueueBase.getUserTag2());
        }
        if (pSDEDTSQueueBase.isUserTag3Dirty() && (bl || pSDEDTSQueueBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDTSQueueBase.getUserTag3());
        }
        if (pSDEDTSQueueBase.isUserTag4Dirty() && (bl || pSDEDTSQueueBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDTSQueueBase.getUserTag4());
        }
        if (pSDEDTSQueueBase.isValidFlagDirty() && (bl || pSDEDTSQueueBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEDTSQueueBase.getValidFlag());
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
        return PSDEDTSQueueBase.remove(this, n);
    }

    private static boolean remove(PSDEDTSQueueBase pSDEDTSQueueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDTSQueueBase.resetCancelledState();
                return true;
            }
            case 1: {
                pSDEDTSQueueBase.resetCancelledStateText();
                return true;
            }
            case 2: {
                pSDEDTSQueueBase.resetCancelPSDEActionId();
                return true;
            }
            case 3: {
                pSDEDTSQueueBase.resetCancelPSDEActionName();
                return true;
            }
            case 4: {
                pSDEDTSQueueBase.resetCancelTimeout();
                return true;
            }
            case 5: {
                pSDEDTSQueueBase.resetCodeName();
                return true;
            }
            case 6: {
                pSDEDTSQueueBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSDEDTSQueueBase.resetCreatedState();
                return true;
            }
            case 8: {
                pSDEDTSQueueBase.resetCreatedStateText();
                return true;
            }
            case 9: {
                pSDEDTSQueueBase.resetCreateMan();
                return true;
            }
            case 10: {
                pSDEDTSQueueBase.resetDefaultFlag();
                return true;
            }
            case 11: {
                pSDEDTSQueueBase.resetErrorPSDEFId();
                return true;
            }
            case 12: {
                pSDEDTSQueueBase.resetErrorPSDEFName();
                return true;
            }
            case 13: {
                pSDEDTSQueueBase.resetFailedState();
                return true;
            }
            case 14: {
                pSDEDTSQueueBase.resetFailedStateText();
                return true;
            }
            case 15: {
                pSDEDTSQueueBase.resetFinishedState();
                return true;
            }
            case 16: {
                pSDEDTSQueueBase.resetFinishedStateText();
                return true;
            }
            case 17: {
                pSDEDTSQueueBase.resetFinishPSDEActionId();
                return true;
            }
            case 18: {
                pSDEDTSQueueBase.resetFinishPSDEActionName();
                return true;
            }
            case 19: {
                pSDEDTSQueueBase.resetHistoryPSDEId();
                return true;
            }
            case 20: {
                pSDEDTSQueueBase.resetHistoryPSDEName();
                return true;
            }
            case 21: {
                pSDEDTSQueueBase.resetLockFlag();
                return true;
            }
            case 22: {
                pSDEDTSQueueBase.resetMemo();
                return true;
            }
            case 23: {
                pSDEDTSQueueBase.resetProcessingState();
                return true;
            }
            case 24: {
                pSDEDTSQueueBase.resetProcessingStateText();
                return true;
            }
            case 25: {
                pSDEDTSQueueBase.resetPSDEDTSQueueId();
                return true;
            }
            case 26: {
                pSDEDTSQueueBase.resetPSDEDTSQueueName();
                return true;
            }
            case 27: {
                pSDEDTSQueueBase.resetPSDEId();
                return true;
            }
            case 28: {
                pSDEDTSQueueBase.resetPSDEName();
                return true;
            }
            case 29: {
                pSDEDTSQueueBase.resetPSSysSFPluginId();
                return true;
            }
            case 30: {
                pSDEDTSQueueBase.resetPSSysSFPluginName();
                return true;
            }
            case 31: {
                pSDEDTSQueueBase.resetPSSystemId();
                return true;
            }
            case 32: {
                pSDEDTSQueueBase.resetPSSystemName();
                return true;
            }
            case 33: {
                pSDEDTSQueueBase.resetPushPSDEActionId();
                return true;
            }
            case 34: {
                pSDEDTSQueueBase.resetPushPSDEActionName();
                return true;
            }
            case 35: {
                pSDEDTSQueueBase.resetQueueParams();
                return true;
            }
            case 36: {
                pSDEDTSQueueBase.resetRefreshPSDEActionId();
                return true;
            }
            case 37: {
                pSDEDTSQueueBase.resetRefreshPSDEActionName();
                return true;
            }
            case 38: {
                pSDEDTSQueueBase.resetRefreshTimer();
                return true;
            }
            case 39: {
                pSDEDTSQueueBase.resetStatePSDEFId();
                return true;
            }
            case 40: {
                pSDEDTSQueueBase.resetStatePSDEFName();
                return true;
            }
            case 41: {
                pSDEDTSQueueBase.resetTimePSDEFId();
                return true;
            }
            case 42: {
                pSDEDTSQueueBase.resetTimePSDEFName();
                return true;
            }
            case 43: {
                pSDEDTSQueueBase.resetUpdateDate();
                return true;
            }
            case 44: {
                pSDEDTSQueueBase.resetUpdateMan();
                return true;
            }
            case 45: {
                pSDEDTSQueueBase.resetUserCat();
                return true;
            }
            case 46: {
                pSDEDTSQueueBase.resetUserTag();
                return true;
            }
            case 47: {
                pSDEDTSQueueBase.resetUserTag2();
                return true;
            }
            case 48: {
                pSDEDTSQueueBase.resetUserTag3();
                return true;
            }
            case 49: {
                pSDEDTSQueueBase.resetUserTag4();
                return true;
            }
            case 50: {
                pSDEDTSQueueBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getHistoryPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHistoryPSDE();
        }
        if (this.getHistoryPSDEId() == null) {
            return null;
        }
        Integer n = this.objHistoryPSDELock;
        synchronized (n) {
            if (this.historypsde != null && DataTypeHelper.compare((int)25, (Object)this.getHistoryPSDEId(), (Object)this.historypsde.getPSDataEntityId()) != 0L) {
                this.historypsde = null;
            }
            if (this.historypsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getHistoryPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.historypsde = pSDataEntity;
            }
            return this.historypsde;
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
        if (this.getCancelPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getCancelPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getCancelPSDEActionId());
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
    public PSDEAction getPushPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPushPSDEAction();
        }
        if (this.getPushPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPushPSDEActionLock;
        synchronized (n) {
            if (this.pushpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPushPSDEActionId(), (Object)this.pushpsdeaction.getPSDEActionId()) != 0L) {
                this.pushpsdeaction = null;
            }
            if (this.pushpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPushPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.pushpsdeaction = pSDEAction;
            }
            return this.pushpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getRefreshPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefreshPSDEAction();
        }
        if (this.getRefreshPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objRefreshPSDEActionLock;
        synchronized (n) {
            if (this.refreshpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getRefreshPSDEActionId(), (Object)this.refreshpsdeaction.getPSDEActionId()) != 0L) {
                this.refreshpsdeaction = null;
            }
            if (this.refreshpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getRefreshPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.refreshpsdeaction = pSDEAction;
            }
            return this.refreshpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getErrorPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorPSDEF();
        }
        if (this.getErrorPSDEFId() == null) {
            return null;
        }
        Integer n = this.objErrorPSDEFLock;
        synchronized (n) {
            if (this.errorpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getErrorPSDEFId(), (Object)this.errorpsdef.getPSDEFieldId()) != 0L) {
                this.errorpsdef = null;
            }
            if (this.errorpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getErrorPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.errorpsdef = pSDEField;
            }
            return this.errorpsdef;
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
    public PSDEField getTimePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimePSDEF();
        }
        if (this.getTimePSDEFId() == null) {
            return null;
        }
        Integer n = this.objTimePSDEFLock;
        synchronized (n) {
            if (this.timepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTimePSDEFId(), (Object)this.timepsdef.getPSDEFieldId()) != 0L) {
                this.timepsdef = null;
            }
            if (this.timepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTimePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.timepsdef = pSDEField;
            }
            return this.timepsdef;
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

    private PSDEDTSQueueBase getProxyEntity() {
        return this.proxyPSDEDTSQueueBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDTSQueueBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDTSQueueBase) {
            this.proxyPSDEDTSQueueBase = (PSDEDTSQueueBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDTSQueueService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CANCELLEDSTATE, 0);
        fieldIndexMap.put(FIELD_CANCELLEDSTATETEXT, 1);
        fieldIndexMap.put(FIELD_CANCELPSDEACTIONID, 2);
        fieldIndexMap.put(FIELD_CANCELPSDEACTIONNAME, 3);
        fieldIndexMap.put(FIELD_CANCELTIMEOUT, 4);
        fieldIndexMap.put(FIELD_CODENAME, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEDSTATE, 7);
        fieldIndexMap.put(FIELD_CREATEDSTATETEXT, 8);
        fieldIndexMap.put(FIELD_CREATEMAN, 9);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 10);
        fieldIndexMap.put(FIELD_ERRORPSDEFID, 11);
        fieldIndexMap.put(FIELD_ERRORPSDEFNAME, 12);
        fieldIndexMap.put(FIELD_FAILEDSTATE, 13);
        fieldIndexMap.put(FIELD_FAILEDSTATETEXT, 14);
        fieldIndexMap.put(FIELD_FINISHEDSTATE, 15);
        fieldIndexMap.put(FIELD_FINISHEDSTATETEXT, 16);
        fieldIndexMap.put(FIELD_FINISHPSDEACTIONID, 17);
        fieldIndexMap.put(FIELD_FINISHPSDEACTIONNAME, 18);
        fieldIndexMap.put(FIELD_HISTORYPSDEID, 19);
        fieldIndexMap.put(FIELD_HISTORYPSDENAME, 20);
        fieldIndexMap.put(FIELD_LOCKFLAG, 21);
        fieldIndexMap.put(FIELD_MEMO, 22);
        fieldIndexMap.put(FIELD_PROCESSINGSTATE, 23);
        fieldIndexMap.put(FIELD_PROCESSINGSTATETEXT, 24);
        fieldIndexMap.put(FIELD_PSDEDTSQUEUEID, 25);
        fieldIndexMap.put(FIELD_PSDEDTSQUEUENAME, 26);
        fieldIndexMap.put(FIELD_PSDEID, 27);
        fieldIndexMap.put(FIELD_PSDENAME, 28);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 29);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 30);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 31);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 32);
        fieldIndexMap.put(FIELD_PUSHPSDEACTIONID, 33);
        fieldIndexMap.put(FIELD_PUSHPSDEACTIONNAME, 34);
        fieldIndexMap.put(FIELD_QUEUEPARAMS, 35);
        fieldIndexMap.put(FIELD_REFRESHPSDEACTIONID, 36);
        fieldIndexMap.put(FIELD_REFRESHPSDEACTIONNAME, 37);
        fieldIndexMap.put(FIELD_REFRESHTIMER, 38);
        fieldIndexMap.put(FIELD_STATEPSDEFID, 39);
        fieldIndexMap.put(FIELD_STATEPSDEFNAME, 40);
        fieldIndexMap.put(FIELD_TIMEPSDEFID, 41);
        fieldIndexMap.put(FIELD_TIMEPSDEFNAME, 42);
        fieldIndexMap.put(FIELD_UPDATEDATE, 43);
        fieldIndexMap.put(FIELD_UPDATEMAN, 44);
        fieldIndexMap.put(FIELD_USERCAT, 45);
        fieldIndexMap.put(FIELD_USERTAG, 46);
        fieldIndexMap.put(FIELD_USERTAG2, 47);
        fieldIndexMap.put(FIELD_USERTAG3, 48);
        fieldIndexMap.put(FIELD_USERTAG4, 49);
        fieldIndexMap.put(FIELD_VALIDFLAG, 50);
    }
}

