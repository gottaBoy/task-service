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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDENotifyTarget;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEPrint;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReport;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyService;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyTargetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgQueue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgQueueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDENotifyBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDENotifyBase.class);
    public static final String FIELD_ATTACHMENTTYPE = "ATTACHMENTTYPE";
    public static final String FIELD_BEGINPSDEFID = "BEGINPSDEFID";
    public static final String FIELD_BEGINPSDEFNAME = "BEGINPSDEFNAME";
    public static final String FIELD_CHECKTIMER = "CHECKTIMER";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_ENDPSDEFID = "ENDPSDEFID";
    public static final String FIELD_ENDPSDEFNAME = "ENDPSDEFNAME";
    public static final String FIELD_EVENTMODEL = "EVENTMODEL";
    public static final String FIELD_EVENTS = "EVENTS";
    public static final String FIELD_FILTERMODEL = "FILTERMODEL";
    public static final String FIELD_IGNOREEXCEPTION = "IGNOREEXCEPTION";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MSGTYPE = "MSGTYPE";
    public static final String FIELD_NOTIFYEND = "NOTIFYEND";
    public static final String FIELD_NOTIFYSTART = "NOTIFYSTART";
    public static final String FIELD_NOTIFYSUBTYPE = "NOTIFYSUBTYPE";
    public static final String FIELD_NOTIFYTAG = "NOTIFYTAG";
    public static final String FIELD_NOTIFYTAG2 = "NOTIFYTAG2";
    public static final String FIELD_PROPERTYMAP = "PROPERTYMAP";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDENOTIFYID = "PSDENOTIFYID";
    public static final String FIELD_PSDENOTIFYNAME = "PSDENOTIFYNAME";
    public static final String FIELD_PSDEPRINTID = "PSDEPRINTID";
    public static final String FIELD_PSDEPRINTNAME = "PSDEPRINTNAME";
    public static final String FIELD_PSDEREPORTID = "PSDEREPORTID";
    public static final String FIELD_PSDEREPORTNAME = "PSDEREPORTNAME";
    public static final String FIELD_PSSYSMSGQUEUEID = "PSSYSMSGQUEUEID";
    public static final String FIELD_PSSYSMSGQUEUENAME = "PSSYSMSGQUEUENAME";
    public static final String FIELD_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String FIELD_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_TASKMODE = "TASKMODE";
    public static final String FIELD_TEMPLFLAG = "TEMPLFLAG";
    public static final String FIELD_THREADRUNMODE = "THREADRUNMODE";
    public static final String FIELD_TIMERMODE = "TIMERMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ATTACHMENTTYPE = 0;
    private static final int INDEX_BEGINPSDEFID = 1;
    private static final int INDEX_BEGINPSDEFNAME = 2;
    private static final int INDEX_CHECKTIMER = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_CUSTOMCODE = 7;
    private static final int INDEX_CUSTOMCOND = 8;
    private static final int INDEX_CUSTOMMODE = 9;
    private static final int INDEX_CUSTOMTYPE = 10;
    private static final int INDEX_ENDPSDEFID = 11;
    private static final int INDEX_ENDPSDEFNAME = 12;
    private static final int INDEX_EVENTMODEL = 13;
    private static final int INDEX_EVENTS = 14;
    private static final int INDEX_FILTERMODEL = 15;
    private static final int INDEX_IGNOREEXCEPTION = 16;
    private static final int INDEX_MEMO = 17;
    private static final int INDEX_MSGTYPE = 18;
    private static final int INDEX_NOTIFYEND = 19;
    private static final int INDEX_NOTIFYSTART = 20;
    private static final int INDEX_NOTIFYSUBTYPE = 21;
    private static final int INDEX_NOTIFYTAG = 22;
    private static final int INDEX_NOTIFYTAG2 = 23;
    private static final int INDEX_PROPERTYMAP = 24;
    private static final int INDEX_PSDEDSID = 25;
    private static final int INDEX_PSDEDSNAME = 26;
    private static final int INDEX_PSDEID = 27;
    private static final int INDEX_PSDENAME = 28;
    private static final int INDEX_PSDENOTIFYID = 29;
    private static final int INDEX_PSDENOTIFYNAME = 30;
    private static final int INDEX_PSDEPRINTID = 31;
    private static final int INDEX_PSDEPRINTNAME = 32;
    private static final int INDEX_PSDEREPORTID = 33;
    private static final int INDEX_PSDEREPORTNAME = 34;
    private static final int INDEX_PSSYSMSGQUEUEID = 35;
    private static final int INDEX_PSSYSMSGQUEUENAME = 36;
    private static final int INDEX_PSSYSMSGTEMPLID = 37;
    private static final int INDEX_PSSYSMSGTEMPLNAME = 38;
    private static final int INDEX_PSSYSSFPLUGINID = 39;
    private static final int INDEX_PSSYSSFPLUGINNAME = 40;
    private static final int INDEX_TASKMODE = 41;
    private static final int INDEX_TEMPLFLAG = 42;
    private static final int INDEX_THREADRUNMODE = 43;
    private static final int INDEX_TIMERMODE = 44;
    private static final int INDEX_UPDATEDATE = 45;
    private static final int INDEX_UPDATEMAN = 46;
    private static final int INDEX_USERCAT = 47;
    private static final int INDEX_USERTAG = 48;
    private static final int INDEX_USERTAG2 = 49;
    private static final int INDEX_USERTAG3 = 50;
    private static final int INDEX_USERTAG4 = 51;
    private static final int INDEX_VALIDFLAG = 52;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDENotifyBase proxyPSDENotifyBase = null;
    private boolean attachmenttypeDirtyFlag = false;
    private boolean beginpsdefidDirtyFlag = false;
    private boolean beginpsdefnameDirtyFlag = false;
    private boolean checktimerDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean endpsdefidDirtyFlag = false;
    private boolean endpsdefnameDirtyFlag = false;
    private boolean eventmodelDirtyFlag = false;
    private boolean eventsDirtyFlag = false;
    private boolean filtermodelDirtyFlag = false;
    private boolean ignoreexceptionDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean msgtypeDirtyFlag = false;
    private boolean notifyendDirtyFlag = false;
    private boolean notifystartDirtyFlag = false;
    private boolean notifysubtypeDirtyFlag = false;
    private boolean notifytagDirtyFlag = false;
    private boolean notifytag2DirtyFlag = false;
    private boolean propertymapDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdenotifyidDirtyFlag = false;
    private boolean psdenotifynameDirtyFlag = false;
    private boolean psdeprintidDirtyFlag = false;
    private boolean psdeprintnameDirtyFlag = false;
    private boolean psdereportidDirtyFlag = false;
    private boolean psdereportnameDirtyFlag = false;
    private boolean pssysmsgqueueidDirtyFlag = false;
    private boolean pssysmsgqueuenameDirtyFlag = false;
    private boolean pssysmsgtemplidDirtyFlag = false;
    private boolean pssysmsgtemplnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean taskmodeDirtyFlag = false;
    private boolean templflagDirtyFlag = false;
    private boolean threadrunmodeDirtyFlag = false;
    private boolean timermodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="attachmenttype")
    private String attachmenttype;
    @Column(name="beginpsdefid")
    private String beginpsdefid;
    @Column(name="beginpsdefname")
    private String beginpsdefname;
    @Column(name="checktimer")
    private Integer checktimer;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="customcond")
    private String customcond;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="customtype")
    private String customtype;
    @Column(name="endpsdefid")
    private String endpsdefid;
    @Column(name="endpsdefname")
    private String endpsdefname;
    @Column(name="eventmodel")
    private String eventmodel;
    @Column(name="events")
    private String events;
    @Column(name="filtermodel")
    private String filtermodel;
    @Column(name="ignoreexception")
    private Integer ignoreexception;
    @Column(name="memo")
    private String memo;
    @Column(name="msgtype")
    private Integer msgtype;
    @Column(name="notifyend")
    private Integer notifyend;
    @Column(name="notifystart")
    private Integer notifystart;
    @Column(name="notifysubtype")
    private String notifysubtype;
    @Column(name="notifytag")
    private String notifytag;
    @Column(name="notifytag2")
    private String notifytag2;
    @Column(name="propertymap")
    private String propertymap;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdenotifyid")
    private String psdenotifyid;
    @Column(name="psdenotifyname")
    private String psdenotifyname;
    @Column(name="psdeprintid")
    private String psdeprintid;
    @Column(name="psdeprintname")
    private String psdeprintname;
    @Column(name="psdereportid")
    private String psdereportid;
    @Column(name="psdereportname")
    private String psdereportname;
    @Column(name="pssysmsgqueueid")
    private String pssysmsgqueueid;
    @Column(name="pssysmsgqueuename")
    private String pssysmsgqueuename;
    @Column(name="pssysmsgtemplid")
    private String pssysmsgtemplid;
    @Column(name="pssysmsgtemplname")
    private String pssysmsgtemplname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="taskmode")
    private Integer taskmode;
    @Column(name="templflag")
    private Integer templflag;
    @Column(name="threadrunmode")
    private Integer threadrunmode;
    @Column(name="timermode")
    private Integer timermode;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objBeginPSDEFLock = new Integer(1);
    private PSDEField beginpsdef = null;
    private Integer objEndPSDEFLock = new Integer(1);
    private PSDEField endpsdef = null;
    private Integer objPSDEPrintLock = new Integer(1);
    private PSDEPrint psdeprint = null;
    private Integer objPSDEReportLock = new Integer(1);
    private PSDEReport psdereport = null;
    private Integer objPSSysMsgQueueLock = new Integer(1);
    private PSSysMsgQueue pssysmsgqueue = null;
    private Integer objPSSysMsgTemplLock = new Integer(1);
    private PSSysMsgTempl pssysmsgtempl = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSDENotifyTargetsLock = new Integer(1);
    private ArrayList<PSDENotifyTarget> psdenotifytargets = null;

    public void setAttachmentType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttachmentType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attachmenttype = string;
        this.attachmenttypeDirtyFlag = true;
    }

    public String getAttachmentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttachmentType();
        }
        return this.attachmenttype;
    }

    public boolean isAttachmentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttachmentTypeDirty();
        }
        return this.attachmenttypeDirtyFlag;
    }

    public void resetAttachmentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttachmentType();
            return;
        }
        this.attachmenttypeDirtyFlag = false;
        this.attachmenttype = null;
    }

    public void setBeginPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.beginpsdefid = string;
        this.beginpsdefidDirtyFlag = true;
    }

    public String getBeginPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginPSDEFId();
        }
        return this.beginpsdefid;
    }

    public boolean isBeginPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginPSDEFIdDirty();
        }
        return this.beginpsdefidDirtyFlag;
    }

    public void resetBeginPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginPSDEFId();
            return;
        }
        this.beginpsdefidDirtyFlag = false;
        this.beginpsdefid = null;
    }

    public void setBeginPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.beginpsdefname = string;
        this.beginpsdefnameDirtyFlag = true;
    }

    public String getBeginPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginPSDEFName();
        }
        return this.beginpsdefname;
    }

    public boolean isBeginPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginPSDEFNameDirty();
        }
        return this.beginpsdefnameDirtyFlag;
    }

    public void resetBeginPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginPSDEFName();
            return;
        }
        this.beginpsdefnameDirtyFlag = false;
        this.beginpsdefname = null;
    }

    public void setCheckTimer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCheckTimer(n);
            return;
        }
        this.checktimer = n;
        this.checktimerDirtyFlag = true;
    }

    public Integer getCheckTimer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCheckTimer();
        }
        return this.checktimer;
    }

    public boolean isCheckTimerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCheckTimerDirty();
        }
        return this.checktimerDirtyFlag;
    }

    public void resetCheckTimer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCheckTimer();
            return;
        }
        this.checktimerDirtyFlag = false;
        this.checktimer = null;
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

    public void setEndPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.endpsdefid = string;
        this.endpsdefidDirtyFlag = true;
    }

    public String getEndPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndPSDEFId();
        }
        return this.endpsdefid;
    }

    public boolean isEndPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndPSDEFIdDirty();
        }
        return this.endpsdefidDirtyFlag;
    }

    public void resetEndPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndPSDEFId();
            return;
        }
        this.endpsdefidDirtyFlag = false;
        this.endpsdefid = null;
    }

    public void setEndPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.endpsdefname = string;
        this.endpsdefnameDirtyFlag = true;
    }

    public String getEndPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndPSDEFName();
        }
        return this.endpsdefname;
    }

    public boolean isEndPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndPSDEFNameDirty();
        }
        return this.endpsdefnameDirtyFlag;
    }

    public void resetEndPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndPSDEFName();
            return;
        }
        this.endpsdefnameDirtyFlag = false;
        this.endpsdefname = null;
    }

    public void setEventModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEventModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eventmodel = string;
        this.eventmodelDirtyFlag = true;
    }

    public String getEventModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEventModel();
        }
        return this.eventmodel;
    }

    public boolean isEventModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEventModelDirty();
        }
        return this.eventmodelDirtyFlag;
    }

    public void resetEventModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEventModel();
            return;
        }
        this.eventmodelDirtyFlag = false;
        this.eventmodel = null;
    }

    public void setEvents(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEvents(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.events = string;
        this.eventsDirtyFlag = true;
    }

    public String getEvents() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEvents();
        }
        return this.events;
    }

    public boolean isEventsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEventsDirty();
        }
        return this.eventsDirtyFlag;
    }

    public void resetEvents() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEvents();
            return;
        }
        this.eventsDirtyFlag = false;
        this.events = null;
    }

    public void setFilterModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFilterModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filtermodel = string;
        this.filtermodelDirtyFlag = true;
    }

    public String getFilterModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilterModel();
        }
        return this.filtermodel;
    }

    public boolean isFilterModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFilterModelDirty();
        }
        return this.filtermodelDirtyFlag;
    }

    public void resetFilterModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFilterModel();
            return;
        }
        this.filtermodelDirtyFlag = false;
        this.filtermodel = null;
    }

    public void setIgnoreException(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreException(n);
            return;
        }
        this.ignoreexception = n;
        this.ignoreexceptionDirtyFlag = true;
    }

    public Integer getIgnoreException() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreException();
        }
        return this.ignoreexception;
    }

    public boolean isIgnoreExceptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreExceptionDirty();
        }
        return this.ignoreexceptionDirtyFlag;
    }

    public void resetIgnoreException() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreException();
            return;
        }
        this.ignoreexceptionDirtyFlag = false;
        this.ignoreexception = null;
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

    public void setMsgType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgType(n);
            return;
        }
        this.msgtype = n;
        this.msgtypeDirtyFlag = true;
    }

    public Integer getMsgType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgType();
        }
        return this.msgtype;
    }

    public boolean isMsgTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTypeDirty();
        }
        return this.msgtypeDirtyFlag;
    }

    public void resetMsgType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgType();
            return;
        }
        this.msgtypeDirtyFlag = false;
        this.msgtype = null;
    }

    public void setNotifyEnd(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNotifyEnd(n);
            return;
        }
        this.notifyend = n;
        this.notifyendDirtyFlag = true;
    }

    public Integer getNotifyEnd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNotifyEnd();
        }
        return this.notifyend;
    }

    public boolean isNotifyEndDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNotifyEndDirty();
        }
        return this.notifyendDirtyFlag;
    }

    public void resetNotifyEnd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNotifyEnd();
            return;
        }
        this.notifyendDirtyFlag = false;
        this.notifyend = null;
    }

    public void setNotifyStart(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNotifyStart(n);
            return;
        }
        this.notifystart = n;
        this.notifystartDirtyFlag = true;
    }

    public Integer getNotifyStart() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNotifyStart();
        }
        return this.notifystart;
    }

    public boolean isNotifyStartDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNotifyStartDirty();
        }
        return this.notifystartDirtyFlag;
    }

    public void resetNotifyStart() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNotifyStart();
            return;
        }
        this.notifystartDirtyFlag = false;
        this.notifystart = null;
    }

    public void setNotifySubType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNotifySubType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.notifysubtype = string;
        this.notifysubtypeDirtyFlag = true;
    }

    public String getNotifySubType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNotifySubType();
        }
        return this.notifysubtype;
    }

    public boolean isNotifySubTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNotifySubTypeDirty();
        }
        return this.notifysubtypeDirtyFlag;
    }

    public void resetNotifySubType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNotifySubType();
            return;
        }
        this.notifysubtypeDirtyFlag = false;
        this.notifysubtype = null;
    }

    public void setNotifyTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNotifyTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.notifytag = string;
        this.notifytagDirtyFlag = true;
    }

    public String getNotifyTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNotifyTag();
        }
        return this.notifytag;
    }

    public boolean isNotifyTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNotifyTagDirty();
        }
        return this.notifytagDirtyFlag;
    }

    public void resetNotifyTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNotifyTag();
            return;
        }
        this.notifytagDirtyFlag = false;
        this.notifytag = null;
    }

    public void setNotifyTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNotifyTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.notifytag2 = string;
        this.notifytag2DirtyFlag = true;
    }

    public String getNotifyTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNotifyTag2();
        }
        return this.notifytag2;
    }

    public boolean isNotifyTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNotifyTag2Dirty();
        }
        return this.notifytag2DirtyFlag;
    }

    public void resetNotifyTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNotifyTag2();
            return;
        }
        this.notifytag2DirtyFlag = false;
        this.notifytag2 = null;
    }

    public void setPropertyMap(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPropertyMap(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.propertymap = string;
        this.propertymapDirtyFlag = true;
    }

    public String getPropertyMap() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPropertyMap();
        }
        return this.propertymap;
    }

    public boolean isPropertyMapDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPropertyMapDirty();
        }
        return this.propertymapDirtyFlag;
    }

    public void resetPropertyMap() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPropertyMap();
            return;
        }
        this.propertymapDirtyFlag = false;
        this.propertymap = null;
    }

    public void setPSDEDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsid = string;
        this.psdedsidDirtyFlag = true;
    }

    public String getPSDEDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSId();
        }
        return this.psdedsid;
    }

    public boolean isPSDEDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSIdDirty();
        }
        return this.psdedsidDirtyFlag;
    }

    public void resetPSDEDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSId();
            return;
        }
        this.psdedsidDirtyFlag = false;
        this.psdedsid = null;
    }

    public void setPSDEDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsname = string;
        this.psdedsnameDirtyFlag = true;
    }

    public String getPSDEDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSName();
        }
        return this.psdedsname;
    }

    public boolean isPSDEDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSNameDirty();
        }
        return this.psdedsnameDirtyFlag;
    }

    public void resetPSDEDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSName();
            return;
        }
        this.psdedsnameDirtyFlag = false;
        this.psdedsname = null;
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

    public void setPSDENotifyId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDENotifyId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdenotifyid = string;
        this.psdenotifyidDirtyFlag = true;
    }

    public String getPSDENotifyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDENotifyId();
        }
        return this.psdenotifyid;
    }

    public boolean isPSDENotifyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENotifyIdDirty();
        }
        return this.psdenotifyidDirtyFlag;
    }

    public void resetPSDENotifyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDENotifyId();
            return;
        }
        this.psdenotifyidDirtyFlag = false;
        this.psdenotifyid = null;
    }

    public void setPSDENotifyName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDENotifyName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdenotifyname = string;
        this.psdenotifynameDirtyFlag = true;
    }

    public String getPSDENotifyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDENotifyName();
        }
        return this.psdenotifyname;
    }

    public boolean isPSDENotifyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENotifyNameDirty();
        }
        return this.psdenotifynameDirtyFlag;
    }

    public void resetPSDENotifyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDENotifyName();
            return;
        }
        this.psdenotifynameDirtyFlag = false;
        this.psdenotifyname = null;
    }

    public void setPSDEPrintId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEPrintId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeprintid = string;
        this.psdeprintidDirtyFlag = true;
    }

    public String getPSDEPrintId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEPrintId();
        }
        return this.psdeprintid;
    }

    public boolean isPSDEPrintIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEPrintIdDirty();
        }
        return this.psdeprintidDirtyFlag;
    }

    public void resetPSDEPrintId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEPrintId();
            return;
        }
        this.psdeprintidDirtyFlag = false;
        this.psdeprintid = null;
    }

    public void setPSDEPrintName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEPrintName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeprintname = string;
        this.psdeprintnameDirtyFlag = true;
    }

    public String getPSDEPrintName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEPrintName();
        }
        return this.psdeprintname;
    }

    public boolean isPSDEPrintNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEPrintNameDirty();
        }
        return this.psdeprintnameDirtyFlag;
    }

    public void resetPSDEPrintName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEPrintName();
            return;
        }
        this.psdeprintnameDirtyFlag = false;
        this.psdeprintname = null;
    }

    public void setPSDEReportId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEReportId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdereportid = string;
        this.psdereportidDirtyFlag = true;
    }

    public String getPSDEReportId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEReportId();
        }
        return this.psdereportid;
    }

    public boolean isPSDEReportIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEReportIdDirty();
        }
        return this.psdereportidDirtyFlag;
    }

    public void resetPSDEReportId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEReportId();
            return;
        }
        this.psdereportidDirtyFlag = false;
        this.psdereportid = null;
    }

    public void setPSDEReportName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEReportName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdereportname = string;
        this.psdereportnameDirtyFlag = true;
    }

    public String getPSDEReportName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEReportName();
        }
        return this.psdereportname;
    }

    public boolean isPSDEReportNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEReportNameDirty();
        }
        return this.psdereportnameDirtyFlag;
    }

    public void resetPSDEReportName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEReportName();
            return;
        }
        this.psdereportnameDirtyFlag = false;
        this.psdereportname = null;
    }

    public void setPSSysMsgQueueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgQueueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgqueueid = string;
        this.pssysmsgqueueidDirtyFlag = true;
    }

    public String getPSSysMsgQueueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgQueueId();
        }
        return this.pssysmsgqueueid;
    }

    public boolean isPSSysMsgQueueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgQueueIdDirty();
        }
        return this.pssysmsgqueueidDirtyFlag;
    }

    public void resetPSSysMsgQueueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgQueueId();
            return;
        }
        this.pssysmsgqueueidDirtyFlag = false;
        this.pssysmsgqueueid = null;
    }

    public void setPSSysMsgQueueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgQueueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgqueuename = string;
        this.pssysmsgqueuenameDirtyFlag = true;
    }

    public String getPSSysMsgQueueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgQueueName();
        }
        return this.pssysmsgqueuename;
    }

    public boolean isPSSysMsgQueueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgQueueNameDirty();
        }
        return this.pssysmsgqueuenameDirtyFlag;
    }

    public void resetPSSysMsgQueueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgQueueName();
            return;
        }
        this.pssysmsgqueuenameDirtyFlag = false;
        this.pssysmsgqueuename = null;
    }

    public void setPSSysMsgTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplid = string;
        this.pssysmsgtemplidDirtyFlag = true;
    }

    public String getPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplId();
        }
        return this.pssysmsgtemplid;
    }

    public boolean isPSSysMsgTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplIdDirty();
        }
        return this.pssysmsgtemplidDirtyFlag;
    }

    public void resetPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplId();
            return;
        }
        this.pssysmsgtemplidDirtyFlag = false;
        this.pssysmsgtemplid = null;
    }

    public void setPSSysMsgTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplname = string;
        this.pssysmsgtemplnameDirtyFlag = true;
    }

    public String getPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplName();
        }
        return this.pssysmsgtemplname;
    }

    public boolean isPSSysMsgTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplNameDirty();
        }
        return this.pssysmsgtemplnameDirtyFlag;
    }

    public void resetPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplName();
            return;
        }
        this.pssysmsgtemplnameDirtyFlag = false;
        this.pssysmsgtemplname = null;
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

    public void setTaskMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskMode(n);
            return;
        }
        this.taskmode = n;
        this.taskmodeDirtyFlag = true;
    }

    public Integer getTaskMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskMode();
        }
        return this.taskmode;
    }

    public boolean isTaskModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskModeDirty();
        }
        return this.taskmodeDirtyFlag;
    }

    public void resetTaskMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskMode();
            return;
        }
        this.taskmodeDirtyFlag = false;
        this.taskmode = null;
    }

    public void setTemplFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplFlag(n);
            return;
        }
        this.templflag = n;
        this.templflagDirtyFlag = true;
    }

    public Integer getTemplFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplFlag();
        }
        return this.templflag;
    }

    public boolean isTemplFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplFlagDirty();
        }
        return this.templflagDirtyFlag;
    }

    public void resetTemplFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplFlag();
            return;
        }
        this.templflagDirtyFlag = false;
        this.templflag = null;
    }

    public void setThreadRunMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThreadRunMode(n);
            return;
        }
        this.threadrunmode = n;
        this.threadrunmodeDirtyFlag = true;
    }

    public Integer getThreadRunMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThreadRunMode();
        }
        return this.threadrunmode;
    }

    public boolean isThreadRunModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThreadRunModeDirty();
        }
        return this.threadrunmodeDirtyFlag;
    }

    public void resetThreadRunMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThreadRunMode();
            return;
        }
        this.threadrunmodeDirtyFlag = false;
        this.threadrunmode = null;
    }

    public void setTimerMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimerMode(n);
            return;
        }
        this.timermode = n;
        this.timermodeDirtyFlag = true;
    }

    public Integer getTimerMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimerMode();
        }
        return this.timermode;
    }

    public boolean isTimerModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimerModeDirty();
        }
        return this.timermodeDirtyFlag;
    }

    public void resetTimerMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimerMode();
            return;
        }
        this.timermodeDirtyFlag = false;
        this.timermode = null;
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
        PSDENotifyBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDENotifyBase pSDENotifyBase) {
        pSDENotifyBase.resetAttachmentType();
        pSDENotifyBase.resetBeginPSDEFId();
        pSDENotifyBase.resetBeginPSDEFName();
        pSDENotifyBase.resetCheckTimer();
        pSDENotifyBase.resetCodeName();
        pSDENotifyBase.resetCreateDate();
        pSDENotifyBase.resetCreateMan();
        pSDENotifyBase.resetCustomCode();
        pSDENotifyBase.resetCustomCond();
        pSDENotifyBase.resetCustomMode();
        pSDENotifyBase.resetCustomType();
        pSDENotifyBase.resetEndPSDEFId();
        pSDENotifyBase.resetEndPSDEFName();
        pSDENotifyBase.resetEventModel();
        pSDENotifyBase.resetEvents();
        pSDENotifyBase.resetFilterModel();
        pSDENotifyBase.resetIgnoreException();
        pSDENotifyBase.resetMemo();
        pSDENotifyBase.resetMsgType();
        pSDENotifyBase.resetNotifyEnd();
        pSDENotifyBase.resetNotifyStart();
        pSDENotifyBase.resetNotifySubType();
        pSDENotifyBase.resetNotifyTag();
        pSDENotifyBase.resetNotifyTag2();
        pSDENotifyBase.resetPropertyMap();
        pSDENotifyBase.resetPSDEDSId();
        pSDENotifyBase.resetPSDEDSName();
        pSDENotifyBase.resetPSDEId();
        pSDENotifyBase.resetPSDEName();
        pSDENotifyBase.resetPSDENotifyId();
        pSDENotifyBase.resetPSDENotifyName();
        pSDENotifyBase.resetPSDEPrintId();
        pSDENotifyBase.resetPSDEPrintName();
        pSDENotifyBase.resetPSDEReportId();
        pSDENotifyBase.resetPSDEReportName();
        pSDENotifyBase.resetPSSysMsgQueueId();
        pSDENotifyBase.resetPSSysMsgQueueName();
        pSDENotifyBase.resetPSSysMsgTemplId();
        pSDENotifyBase.resetPSSysMsgTemplName();
        pSDENotifyBase.resetPSSysSFPluginId();
        pSDENotifyBase.resetPSSysSFPluginName();
        pSDENotifyBase.resetTaskMode();
        pSDENotifyBase.resetTemplFlag();
        pSDENotifyBase.resetThreadRunMode();
        pSDENotifyBase.resetTimerMode();
        pSDENotifyBase.resetUpdateDate();
        pSDENotifyBase.resetUpdateMan();
        pSDENotifyBase.resetUserCat();
        pSDENotifyBase.resetUserTag();
        pSDENotifyBase.resetUserTag2();
        pSDENotifyBase.resetUserTag3();
        pSDENotifyBase.resetUserTag4();
        pSDENotifyBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAttachmentTypeDirty()) {
            hashMap.put(FIELD_ATTACHMENTTYPE, this.getAttachmentType());
        }
        if (!bl || this.isBeginPSDEFIdDirty()) {
            hashMap.put(FIELD_BEGINPSDEFID, this.getBeginPSDEFId());
        }
        if (!bl || this.isBeginPSDEFNameDirty()) {
            hashMap.put(FIELD_BEGINPSDEFNAME, this.getBeginPSDEFName());
        }
        if (!bl || this.isCheckTimerDirty()) {
            hashMap.put(FIELD_CHECKTIMER, this.getCheckTimer());
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
        if (!bl || this.isCustomCondDirty()) {
            hashMap.put(FIELD_CUSTOMCOND, this.getCustomCond());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isCustomTypeDirty()) {
            hashMap.put(FIELD_CUSTOMTYPE, this.getCustomType());
        }
        if (!bl || this.isEndPSDEFIdDirty()) {
            hashMap.put(FIELD_ENDPSDEFID, this.getEndPSDEFId());
        }
        if (!bl || this.isEndPSDEFNameDirty()) {
            hashMap.put(FIELD_ENDPSDEFNAME, this.getEndPSDEFName());
        }
        if (!bl || this.isEventModelDirty()) {
            hashMap.put(FIELD_EVENTMODEL, this.getEventModel());
        }
        if (!bl || this.isEventsDirty()) {
            hashMap.put(FIELD_EVENTS, this.getEvents());
        }
        if (!bl || this.isFilterModelDirty()) {
            hashMap.put(FIELD_FILTERMODEL, this.getFilterModel());
        }
        if (!bl || this.isIgnoreExceptionDirty()) {
            hashMap.put(FIELD_IGNOREEXCEPTION, this.getIgnoreException());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMsgTypeDirty()) {
            hashMap.put(FIELD_MSGTYPE, this.getMsgType());
        }
        if (!bl || this.isNotifyEndDirty()) {
            hashMap.put(FIELD_NOTIFYEND, this.getNotifyEnd());
        }
        if (!bl || this.isNotifyStartDirty()) {
            hashMap.put(FIELD_NOTIFYSTART, this.getNotifyStart());
        }
        if (!bl || this.isNotifySubTypeDirty()) {
            hashMap.put(FIELD_NOTIFYSUBTYPE, this.getNotifySubType());
        }
        if (!bl || this.isNotifyTagDirty()) {
            hashMap.put(FIELD_NOTIFYTAG, this.getNotifyTag());
        }
        if (!bl || this.isNotifyTag2Dirty()) {
            hashMap.put(FIELD_NOTIFYTAG2, this.getNotifyTag2());
        }
        if (!bl || this.isPropertyMapDirty()) {
            hashMap.put(FIELD_PROPERTYMAP, this.getPropertyMap());
        }
        if (!bl || this.isPSDEDSIdDirty()) {
            hashMap.put(FIELD_PSDEDSID, this.getPSDEDSId());
        }
        if (!bl || this.isPSDEDSNameDirty()) {
            hashMap.put(FIELD_PSDEDSNAME, this.getPSDEDSName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDENotifyIdDirty()) {
            hashMap.put(FIELD_PSDENOTIFYID, this.getPSDENotifyId());
        }
        if (!bl || this.isPSDENotifyNameDirty()) {
            hashMap.put(FIELD_PSDENOTIFYNAME, this.getPSDENotifyName());
        }
        if (!bl || this.isPSDEPrintIdDirty()) {
            hashMap.put(FIELD_PSDEPRINTID, this.getPSDEPrintId());
        }
        if (!bl || this.isPSDEPrintNameDirty()) {
            hashMap.put(FIELD_PSDEPRINTNAME, this.getPSDEPrintName());
        }
        if (!bl || this.isPSDEReportIdDirty()) {
            hashMap.put(FIELD_PSDEREPORTID, this.getPSDEReportId());
        }
        if (!bl || this.isPSDEReportNameDirty()) {
            hashMap.put(FIELD_PSDEREPORTNAME, this.getPSDEReportName());
        }
        if (!bl || this.isPSSysMsgQueueIdDirty()) {
            hashMap.put(FIELD_PSSYSMSGQUEUEID, this.getPSSysMsgQueueId());
        }
        if (!bl || this.isPSSysMsgQueueNameDirty()) {
            hashMap.put(FIELD_PSSYSMSGQUEUENAME, this.getPSSysMsgQueueName());
        }
        if (!bl || this.isPSSysMsgTemplIdDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLID, this.getPSSysMsgTemplId());
        }
        if (!bl || this.isPSSysMsgTemplNameDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLNAME, this.getPSSysMsgTemplName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isTaskModeDirty()) {
            hashMap.put(FIELD_TASKMODE, this.getTaskMode());
        }
        if (!bl || this.isTemplFlagDirty()) {
            hashMap.put(FIELD_TEMPLFLAG, this.getTemplFlag());
        }
        if (!bl || this.isThreadRunModeDirty()) {
            hashMap.put(FIELD_THREADRUNMODE, this.getThreadRunMode());
        }
        if (!bl || this.isTimerModeDirty()) {
            hashMap.put(FIELD_TIMERMODE, this.getTimerMode());
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
        return PSDENotifyBase.get(this, n);
    }

    private static Object get(PSDENotifyBase pSDENotifyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDENotifyBase.getAttachmentType();
            }
            case 1: {
                return pSDENotifyBase.getBeginPSDEFId();
            }
            case 2: {
                return pSDENotifyBase.getBeginPSDEFName();
            }
            case 3: {
                return pSDENotifyBase.getCheckTimer();
            }
            case 4: {
                return pSDENotifyBase.getCodeName();
            }
            case 5: {
                return pSDENotifyBase.getCreateDate();
            }
            case 6: {
                return pSDENotifyBase.getCreateMan();
            }
            case 7: {
                return pSDENotifyBase.getCustomCode();
            }
            case 8: {
                return pSDENotifyBase.getCustomCond();
            }
            case 9: {
                return pSDENotifyBase.getCustomMode();
            }
            case 10: {
                return pSDENotifyBase.getCustomType();
            }
            case 11: {
                return pSDENotifyBase.getEndPSDEFId();
            }
            case 12: {
                return pSDENotifyBase.getEndPSDEFName();
            }
            case 13: {
                return pSDENotifyBase.getEventModel();
            }
            case 14: {
                return pSDENotifyBase.getEvents();
            }
            case 15: {
                return pSDENotifyBase.getFilterModel();
            }
            case 16: {
                return pSDENotifyBase.getIgnoreException();
            }
            case 17: {
                return pSDENotifyBase.getMemo();
            }
            case 18: {
                return pSDENotifyBase.getMsgType();
            }
            case 19: {
                return pSDENotifyBase.getNotifyEnd();
            }
            case 20: {
                return pSDENotifyBase.getNotifyStart();
            }
            case 21: {
                return pSDENotifyBase.getNotifySubType();
            }
            case 22: {
                return pSDENotifyBase.getNotifyTag();
            }
            case 23: {
                return pSDENotifyBase.getNotifyTag2();
            }
            case 24: {
                return pSDENotifyBase.getPropertyMap();
            }
            case 25: {
                return pSDENotifyBase.getPSDEDSId();
            }
            case 26: {
                return pSDENotifyBase.getPSDEDSName();
            }
            case 27: {
                return pSDENotifyBase.getPSDEId();
            }
            case 28: {
                return pSDENotifyBase.getPSDEName();
            }
            case 29: {
                return pSDENotifyBase.getPSDENotifyId();
            }
            case 30: {
                return pSDENotifyBase.getPSDENotifyName();
            }
            case 31: {
                return pSDENotifyBase.getPSDEPrintId();
            }
            case 32: {
                return pSDENotifyBase.getPSDEPrintName();
            }
            case 33: {
                return pSDENotifyBase.getPSDEReportId();
            }
            case 34: {
                return pSDENotifyBase.getPSDEReportName();
            }
            case 35: {
                return pSDENotifyBase.getPSSysMsgQueueId();
            }
            case 36: {
                return pSDENotifyBase.getPSSysMsgQueueName();
            }
            case 37: {
                return pSDENotifyBase.getPSSysMsgTemplId();
            }
            case 38: {
                return pSDENotifyBase.getPSSysMsgTemplName();
            }
            case 39: {
                return pSDENotifyBase.getPSSysSFPluginId();
            }
            case 40: {
                return pSDENotifyBase.getPSSysSFPluginName();
            }
            case 41: {
                return pSDENotifyBase.getTaskMode();
            }
            case 42: {
                return pSDENotifyBase.getTemplFlag();
            }
            case 43: {
                return pSDENotifyBase.getThreadRunMode();
            }
            case 44: {
                return pSDENotifyBase.getTimerMode();
            }
            case 45: {
                return pSDENotifyBase.getUpdateDate();
            }
            case 46: {
                return pSDENotifyBase.getUpdateMan();
            }
            case 47: {
                return pSDENotifyBase.getUserCat();
            }
            case 48: {
                return pSDENotifyBase.getUserTag();
            }
            case 49: {
                return pSDENotifyBase.getUserTag2();
            }
            case 50: {
                return pSDENotifyBase.getUserTag3();
            }
            case 51: {
                return pSDENotifyBase.getUserTag4();
            }
            case 52: {
                return pSDENotifyBase.getValidFlag();
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
        PSDENotifyBase.set(this, n, object);
    }

    private static void set(PSDENotifyBase pSDENotifyBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDENotifyBase.setAttachmentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDENotifyBase.setBeginPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDENotifyBase.setBeginPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDENotifyBase.setCheckTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDENotifyBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDENotifyBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDENotifyBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDENotifyBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDENotifyBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDENotifyBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDENotifyBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDENotifyBase.setEndPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDENotifyBase.setEndPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDENotifyBase.setEventModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDENotifyBase.setEvents(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDENotifyBase.setFilterModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDENotifyBase.setIgnoreException(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDENotifyBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDENotifyBase.setMsgType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDENotifyBase.setNotifyEnd(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDENotifyBase.setNotifyStart(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDENotifyBase.setNotifySubType(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDENotifyBase.setNotifyTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDENotifyBase.setNotifyTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDENotifyBase.setPropertyMap(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDENotifyBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDENotifyBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDENotifyBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDENotifyBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDENotifyBase.setPSDENotifyId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDENotifyBase.setPSDENotifyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDENotifyBase.setPSDEPrintId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDENotifyBase.setPSDEPrintName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDENotifyBase.setPSDEReportId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDENotifyBase.setPSDEReportName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDENotifyBase.setPSSysMsgQueueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDENotifyBase.setPSSysMsgQueueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDENotifyBase.setPSSysMsgTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDENotifyBase.setPSSysMsgTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDENotifyBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDENotifyBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDENotifyBase.setTaskMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSDENotifyBase.setTemplFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSDENotifyBase.setThreadRunMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSDENotifyBase.setTimerMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 45: {
                pSDENotifyBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 46: {
                pSDENotifyBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDENotifyBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDENotifyBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDENotifyBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDENotifyBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDENotifyBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDENotifyBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDENotifyBase.isNull(this, n);
    }

    private static boolean isNull(PSDENotifyBase pSDENotifyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDENotifyBase.getAttachmentType() == null;
            }
            case 1: {
                return pSDENotifyBase.getBeginPSDEFId() == null;
            }
            case 2: {
                return pSDENotifyBase.getBeginPSDEFName() == null;
            }
            case 3: {
                return pSDENotifyBase.getCheckTimer() == null;
            }
            case 4: {
                return pSDENotifyBase.getCodeName() == null;
            }
            case 5: {
                return pSDENotifyBase.getCreateDate() == null;
            }
            case 6: {
                return pSDENotifyBase.getCreateMan() == null;
            }
            case 7: {
                return pSDENotifyBase.getCustomCode() == null;
            }
            case 8: {
                return pSDENotifyBase.getCustomCond() == null;
            }
            case 9: {
                return pSDENotifyBase.getCustomMode() == null;
            }
            case 10: {
                return pSDENotifyBase.getCustomType() == null;
            }
            case 11: {
                return pSDENotifyBase.getEndPSDEFId() == null;
            }
            case 12: {
                return pSDENotifyBase.getEndPSDEFName() == null;
            }
            case 13: {
                return pSDENotifyBase.getEventModel() == null;
            }
            case 14: {
                return pSDENotifyBase.getEvents() == null;
            }
            case 15: {
                return pSDENotifyBase.getFilterModel() == null;
            }
            case 16: {
                return pSDENotifyBase.getIgnoreException() == null;
            }
            case 17: {
                return pSDENotifyBase.getMemo() == null;
            }
            case 18: {
                return pSDENotifyBase.getMsgType() == null;
            }
            case 19: {
                return pSDENotifyBase.getNotifyEnd() == null;
            }
            case 20: {
                return pSDENotifyBase.getNotifyStart() == null;
            }
            case 21: {
                return pSDENotifyBase.getNotifySubType() == null;
            }
            case 22: {
                return pSDENotifyBase.getNotifyTag() == null;
            }
            case 23: {
                return pSDENotifyBase.getNotifyTag2() == null;
            }
            case 24: {
                return pSDENotifyBase.getPropertyMap() == null;
            }
            case 25: {
                return pSDENotifyBase.getPSDEDSId() == null;
            }
            case 26: {
                return pSDENotifyBase.getPSDEDSName() == null;
            }
            case 27: {
                return pSDENotifyBase.getPSDEId() == null;
            }
            case 28: {
                return pSDENotifyBase.getPSDEName() == null;
            }
            case 29: {
                return pSDENotifyBase.getPSDENotifyId() == null;
            }
            case 30: {
                return pSDENotifyBase.getPSDENotifyName() == null;
            }
            case 31: {
                return pSDENotifyBase.getPSDEPrintId() == null;
            }
            case 32: {
                return pSDENotifyBase.getPSDEPrintName() == null;
            }
            case 33: {
                return pSDENotifyBase.getPSDEReportId() == null;
            }
            case 34: {
                return pSDENotifyBase.getPSDEReportName() == null;
            }
            case 35: {
                return pSDENotifyBase.getPSSysMsgQueueId() == null;
            }
            case 36: {
                return pSDENotifyBase.getPSSysMsgQueueName() == null;
            }
            case 37: {
                return pSDENotifyBase.getPSSysMsgTemplId() == null;
            }
            case 38: {
                return pSDENotifyBase.getPSSysMsgTemplName() == null;
            }
            case 39: {
                return pSDENotifyBase.getPSSysSFPluginId() == null;
            }
            case 40: {
                return pSDENotifyBase.getPSSysSFPluginName() == null;
            }
            case 41: {
                return pSDENotifyBase.getTaskMode() == null;
            }
            case 42: {
                return pSDENotifyBase.getTemplFlag() == null;
            }
            case 43: {
                return pSDENotifyBase.getThreadRunMode() == null;
            }
            case 44: {
                return pSDENotifyBase.getTimerMode() == null;
            }
            case 45: {
                return pSDENotifyBase.getUpdateDate() == null;
            }
            case 46: {
                return pSDENotifyBase.getUpdateMan() == null;
            }
            case 47: {
                return pSDENotifyBase.getUserCat() == null;
            }
            case 48: {
                return pSDENotifyBase.getUserTag() == null;
            }
            case 49: {
                return pSDENotifyBase.getUserTag2() == null;
            }
            case 50: {
                return pSDENotifyBase.getUserTag3() == null;
            }
            case 51: {
                return pSDENotifyBase.getUserTag4() == null;
            }
            case 52: {
                return pSDENotifyBase.getValidFlag() == null;
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
        return PSDENotifyBase.contains(this, n);
    }

    private static boolean contains(PSDENotifyBase pSDENotifyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDENotifyBase.isAttachmentTypeDirty();
            }
            case 1: {
                return pSDENotifyBase.isBeginPSDEFIdDirty();
            }
            case 2: {
                return pSDENotifyBase.isBeginPSDEFNameDirty();
            }
            case 3: {
                return pSDENotifyBase.isCheckTimerDirty();
            }
            case 4: {
                return pSDENotifyBase.isCodeNameDirty();
            }
            case 5: {
                return pSDENotifyBase.isCreateDateDirty();
            }
            case 6: {
                return pSDENotifyBase.isCreateManDirty();
            }
            case 7: {
                return pSDENotifyBase.isCustomCodeDirty();
            }
            case 8: {
                return pSDENotifyBase.isCustomCondDirty();
            }
            case 9: {
                return pSDENotifyBase.isCustomModeDirty();
            }
            case 10: {
                return pSDENotifyBase.isCustomTypeDirty();
            }
            case 11: {
                return pSDENotifyBase.isEndPSDEFIdDirty();
            }
            case 12: {
                return pSDENotifyBase.isEndPSDEFNameDirty();
            }
            case 13: {
                return pSDENotifyBase.isEventModelDirty();
            }
            case 14: {
                return pSDENotifyBase.isEventsDirty();
            }
            case 15: {
                return pSDENotifyBase.isFilterModelDirty();
            }
            case 16: {
                return pSDENotifyBase.isIgnoreExceptionDirty();
            }
            case 17: {
                return pSDENotifyBase.isMemoDirty();
            }
            case 18: {
                return pSDENotifyBase.isMsgTypeDirty();
            }
            case 19: {
                return pSDENotifyBase.isNotifyEndDirty();
            }
            case 20: {
                return pSDENotifyBase.isNotifyStartDirty();
            }
            case 21: {
                return pSDENotifyBase.isNotifySubTypeDirty();
            }
            case 22: {
                return pSDENotifyBase.isNotifyTagDirty();
            }
            case 23: {
                return pSDENotifyBase.isNotifyTag2Dirty();
            }
            case 24: {
                return pSDENotifyBase.isPropertyMapDirty();
            }
            case 25: {
                return pSDENotifyBase.isPSDEDSIdDirty();
            }
            case 26: {
                return pSDENotifyBase.isPSDEDSNameDirty();
            }
            case 27: {
                return pSDENotifyBase.isPSDEIdDirty();
            }
            case 28: {
                return pSDENotifyBase.isPSDENameDirty();
            }
            case 29: {
                return pSDENotifyBase.isPSDENotifyIdDirty();
            }
            case 30: {
                return pSDENotifyBase.isPSDENotifyNameDirty();
            }
            case 31: {
                return pSDENotifyBase.isPSDEPrintIdDirty();
            }
            case 32: {
                return pSDENotifyBase.isPSDEPrintNameDirty();
            }
            case 33: {
                return pSDENotifyBase.isPSDEReportIdDirty();
            }
            case 34: {
                return pSDENotifyBase.isPSDEReportNameDirty();
            }
            case 35: {
                return pSDENotifyBase.isPSSysMsgQueueIdDirty();
            }
            case 36: {
                return pSDENotifyBase.isPSSysMsgQueueNameDirty();
            }
            case 37: {
                return pSDENotifyBase.isPSSysMsgTemplIdDirty();
            }
            case 38: {
                return pSDENotifyBase.isPSSysMsgTemplNameDirty();
            }
            case 39: {
                return pSDENotifyBase.isPSSysSFPluginIdDirty();
            }
            case 40: {
                return pSDENotifyBase.isPSSysSFPluginNameDirty();
            }
            case 41: {
                return pSDENotifyBase.isTaskModeDirty();
            }
            case 42: {
                return pSDENotifyBase.isTemplFlagDirty();
            }
            case 43: {
                return pSDENotifyBase.isThreadRunModeDirty();
            }
            case 44: {
                return pSDENotifyBase.isTimerModeDirty();
            }
            case 45: {
                return pSDENotifyBase.isUpdateDateDirty();
            }
            case 46: {
                return pSDENotifyBase.isUpdateManDirty();
            }
            case 47: {
                return pSDENotifyBase.isUserCatDirty();
            }
            case 48: {
                return pSDENotifyBase.isUserTagDirty();
            }
            case 49: {
                return pSDENotifyBase.isUserTag2Dirty();
            }
            case 50: {
                return pSDENotifyBase.isUserTag3Dirty();
            }
            case 51: {
                return pSDENotifyBase.isUserTag4Dirty();
            }
            case 52: {
                return pSDENotifyBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDENotifyBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDENotifyBase pSDENotifyBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDENotifyBase.getAttachmentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attachmenttype", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getAttachmentType()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getBeginPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beginpsdefid", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getBeginPSDEFId()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getBeginPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beginpsdefname", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getBeginPSDEFName()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getCheckTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"checktimer", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getCheckTimer()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getCustomType()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getEndPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endpsdefid", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getEndPSDEFId()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getEndPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endpsdefname", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getEndPSDEFName()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getEventModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventmodel", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getEventModel()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getEvents() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"events", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getEvents()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getFilterModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filtermodel", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getFilterModel()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getIgnoreException() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreexception", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getIgnoreException()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getMemo()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getMsgType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtype", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getMsgType()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getNotifyEnd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"notifyend", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getNotifyEnd()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getNotifyStart() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"notifystart", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getNotifyStart()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getNotifySubType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"notifysubtype", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getNotifySubType()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getNotifyTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"notifytag", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getNotifyTag()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getNotifyTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"notifytag2", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getNotifyTag2()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPropertyMap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"propertymap", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPropertyMap()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSDENotifyId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdenotifyid", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSDENotifyId()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSDENotifyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdenotifyname", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSDENotifyName()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSDEPrintId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeprintid", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSDEPrintId()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSDEPrintName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeprintname", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSDEPrintName()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSDEReportId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdereportid", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSDEReportId()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSDEReportName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdereportname", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSDEReportName()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSSysMsgQueueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgqueueid", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSSysMsgQueueId()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSSysMsgQueueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgqueuename", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSSysMsgQueueName()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSSysMsgTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplid", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSSysMsgTemplId()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSSysMsgTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplname", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSSysMsgTemplName()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getTaskMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskmode", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getTaskMode()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getTemplFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templflag", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getTemplFlag()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getThreadRunMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"threadrunmode", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getThreadRunMode()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getTimerMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timermode", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getTimerMode()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDENotifyBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDENotifyBase.getJSONValue((Object)pSDENotifyBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDENotifyBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDENotifyBase pSDENotifyBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDENotifyBase.getAttachmentType() != null) {
            object = pSDENotifyBase.getAttachmentType();
            xmlNode.setAttribute(FIELD_ATTACHMENTTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSDENotifyBase.getBeginPSDEFId() != null) {
            object = pSDENotifyBase.getBeginPSDEFId();
            xmlNode.setAttribute(FIELD_BEGINPSDEFID, (String)(object == null ? "" : object));
        }
        if (bl || pSDENotifyBase.getBeginPSDEFName() != null) {
            object = pSDENotifyBase.getBeginPSDEFName();
            xmlNode.setAttribute(FIELD_BEGINPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getCheckTimer() != null) {
            object = pSDENotifyBase.getCheckTimer();
            xmlNode.setAttribute(FIELD_CHECKTIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDENotifyBase.getCodeName() != null) {
            object = pSDENotifyBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getCreateDate() != null) {
            object = pSDENotifyBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDENotifyBase.getCreateMan() != null) {
            object = pSDENotifyBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getCustomCode() != null) {
            object = pSDENotifyBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getCustomCond() != null) {
            object = pSDENotifyBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getCustomMode() != null) {
            object = pSDENotifyBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDENotifyBase.getCustomType() != null) {
            object = pSDENotifyBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getEndPSDEFId() != null) {
            object = pSDENotifyBase.getEndPSDEFId();
            xmlNode.setAttribute(FIELD_ENDPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getEndPSDEFName() != null) {
            object = pSDENotifyBase.getEndPSDEFName();
            xmlNode.setAttribute(FIELD_ENDPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getEventModel() != null) {
            object = pSDENotifyBase.getEventModel();
            xmlNode.setAttribute(FIELD_EVENTMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getEvents() != null) {
            object = pSDENotifyBase.getEvents();
            xmlNode.setAttribute(FIELD_EVENTS, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getFilterModel() != null) {
            object = pSDENotifyBase.getFilterModel();
            xmlNode.setAttribute(FIELD_FILTERMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getIgnoreException() != null) {
            object = pSDENotifyBase.getIgnoreException();
            xmlNode.setAttribute(FIELD_IGNOREEXCEPTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDENotifyBase.getMemo() != null) {
            object = pSDENotifyBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getMsgType() != null) {
            object = pSDENotifyBase.getMsgType();
            xmlNode.setAttribute(FIELD_MSGTYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDENotifyBase.getNotifyEnd() != null) {
            object = pSDENotifyBase.getNotifyEnd();
            xmlNode.setAttribute(FIELD_NOTIFYEND, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDENotifyBase.getNotifyStart() != null) {
            object = pSDENotifyBase.getNotifyStart();
            xmlNode.setAttribute(FIELD_NOTIFYSTART, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDENotifyBase.getNotifySubType() != null) {
            object = pSDENotifyBase.getNotifySubType();
            xmlNode.setAttribute(FIELD_NOTIFYSUBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getNotifyTag() != null) {
            object = pSDENotifyBase.getNotifyTag();
            xmlNode.setAttribute(FIELD_NOTIFYTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getNotifyTag2() != null) {
            object = pSDENotifyBase.getNotifyTag2();
            xmlNode.setAttribute(FIELD_NOTIFYTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPropertyMap() != null) {
            object = pSDENotifyBase.getPropertyMap();
            xmlNode.setAttribute(FIELD_PROPERTYMAP, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSDEDSId() != null) {
            object = pSDENotifyBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSDEDSName() != null) {
            object = pSDENotifyBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSDEId() != null) {
            object = pSDENotifyBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSDEName() != null) {
            object = pSDENotifyBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSDENotifyId() != null) {
            object = pSDENotifyBase.getPSDENotifyId();
            xmlNode.setAttribute(FIELD_PSDENOTIFYID, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSDENotifyName() != null) {
            object = pSDENotifyBase.getPSDENotifyName();
            xmlNode.setAttribute(FIELD_PSDENOTIFYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSDEPrintId() != null) {
            object = pSDENotifyBase.getPSDEPrintId();
            xmlNode.setAttribute(FIELD_PSDEPRINTID, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSDEPrintName() != null) {
            object = pSDENotifyBase.getPSDEPrintName();
            xmlNode.setAttribute(FIELD_PSDEPRINTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSDEReportId() != null) {
            object = pSDENotifyBase.getPSDEReportId();
            xmlNode.setAttribute(FIELD_PSDEREPORTID, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSDEReportName() != null) {
            object = pSDENotifyBase.getPSDEReportName();
            xmlNode.setAttribute(FIELD_PSDEREPORTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSSysMsgQueueId() != null) {
            object = pSDENotifyBase.getPSSysMsgQueueId();
            xmlNode.setAttribute(FIELD_PSSYSMSGQUEUEID, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSSysMsgQueueName() != null) {
            object = pSDENotifyBase.getPSSysMsgQueueName();
            xmlNode.setAttribute(FIELD_PSSYSMSGQUEUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSSysMsgTemplId() != null) {
            object = pSDENotifyBase.getPSSysMsgTemplId();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSSysMsgTemplName() != null) {
            object = pSDENotifyBase.getPSSysMsgTemplName();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSSysSFPluginId() != null) {
            object = pSDENotifyBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getPSSysSFPluginName() != null) {
            object = pSDENotifyBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getTaskMode() != null) {
            object = pSDENotifyBase.getTaskMode();
            xmlNode.setAttribute(FIELD_TASKMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDENotifyBase.getTemplFlag() != null) {
            object = pSDENotifyBase.getTemplFlag();
            xmlNode.setAttribute(FIELD_TEMPLFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDENotifyBase.getThreadRunMode() != null) {
            object = pSDENotifyBase.getThreadRunMode();
            xmlNode.setAttribute(FIELD_THREADRUNMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDENotifyBase.getTimerMode() != null) {
            object = pSDENotifyBase.getTimerMode();
            xmlNode.setAttribute(FIELD_TIMERMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDENotifyBase.getUpdateDate() != null) {
            object = pSDENotifyBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDENotifyBase.getUpdateMan() != null) {
            object = pSDENotifyBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getUserCat() != null) {
            object = pSDENotifyBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getUserTag() != null) {
            object = pSDENotifyBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getUserTag2() != null) {
            object = pSDENotifyBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getUserTag3() != null) {
            object = pSDENotifyBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getUserTag4() != null) {
            object = pSDENotifyBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDENotifyBase.getValidFlag() != null) {
            object = pSDENotifyBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDENotifyBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDENotifyBase pSDENotifyBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDENotifyBase.isAttachmentTypeDirty() && (bl || pSDENotifyBase.getAttachmentType() != null)) {
            iDataObject.set(FIELD_ATTACHMENTTYPE, (Object)pSDENotifyBase.getAttachmentType());
        }
        if (pSDENotifyBase.isBeginPSDEFIdDirty() && (bl || pSDENotifyBase.getBeginPSDEFId() != null)) {
            iDataObject.set(FIELD_BEGINPSDEFID, (Object)pSDENotifyBase.getBeginPSDEFId());
        }
        if (pSDENotifyBase.isBeginPSDEFNameDirty() && (bl || pSDENotifyBase.getBeginPSDEFName() != null)) {
            iDataObject.set(FIELD_BEGINPSDEFNAME, (Object)pSDENotifyBase.getBeginPSDEFName());
        }
        if (pSDENotifyBase.isCheckTimerDirty() && (bl || pSDENotifyBase.getCheckTimer() != null)) {
            iDataObject.set(FIELD_CHECKTIMER, (Object)pSDENotifyBase.getCheckTimer());
        }
        if (pSDENotifyBase.isCodeNameDirty() && (bl || pSDENotifyBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDENotifyBase.getCodeName());
        }
        if (pSDENotifyBase.isCreateDateDirty() && (bl || pSDENotifyBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDENotifyBase.getCreateDate());
        }
        if (pSDENotifyBase.isCreateManDirty() && (bl || pSDENotifyBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDENotifyBase.getCreateMan());
        }
        if (pSDENotifyBase.isCustomCodeDirty() && (bl || pSDENotifyBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDENotifyBase.getCustomCode());
        }
        if (pSDENotifyBase.isCustomCondDirty() && (bl || pSDENotifyBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSDENotifyBase.getCustomCond());
        }
        if (pSDENotifyBase.isCustomModeDirty() && (bl || pSDENotifyBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDENotifyBase.getCustomMode());
        }
        if (pSDENotifyBase.isCustomTypeDirty() && (bl || pSDENotifyBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSDENotifyBase.getCustomType());
        }
        if (pSDENotifyBase.isEndPSDEFIdDirty() && (bl || pSDENotifyBase.getEndPSDEFId() != null)) {
            iDataObject.set(FIELD_ENDPSDEFID, (Object)pSDENotifyBase.getEndPSDEFId());
        }
        if (pSDENotifyBase.isEndPSDEFNameDirty() && (bl || pSDENotifyBase.getEndPSDEFName() != null)) {
            iDataObject.set(FIELD_ENDPSDEFNAME, (Object)pSDENotifyBase.getEndPSDEFName());
        }
        if (pSDENotifyBase.isEventModelDirty() && (bl || pSDENotifyBase.getEventModel() != null)) {
            iDataObject.set(FIELD_EVENTMODEL, (Object)pSDENotifyBase.getEventModel());
        }
        if (pSDENotifyBase.isEventsDirty() && (bl || pSDENotifyBase.getEvents() != null)) {
            iDataObject.set(FIELD_EVENTS, (Object)pSDENotifyBase.getEvents());
        }
        if (pSDENotifyBase.isFilterModelDirty() && (bl || pSDENotifyBase.getFilterModel() != null)) {
            iDataObject.set(FIELD_FILTERMODEL, (Object)pSDENotifyBase.getFilterModel());
        }
        if (pSDENotifyBase.isIgnoreExceptionDirty() && (bl || pSDENotifyBase.getIgnoreException() != null)) {
            iDataObject.set(FIELD_IGNOREEXCEPTION, (Object)pSDENotifyBase.getIgnoreException());
        }
        if (pSDENotifyBase.isMemoDirty() && (bl || pSDENotifyBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDENotifyBase.getMemo());
        }
        if (pSDENotifyBase.isMsgTypeDirty() && (bl || pSDENotifyBase.getMsgType() != null)) {
            iDataObject.set(FIELD_MSGTYPE, (Object)pSDENotifyBase.getMsgType());
        }
        if (pSDENotifyBase.isNotifyEndDirty() && (bl || pSDENotifyBase.getNotifyEnd() != null)) {
            iDataObject.set(FIELD_NOTIFYEND, (Object)pSDENotifyBase.getNotifyEnd());
        }
        if (pSDENotifyBase.isNotifyStartDirty() && (bl || pSDENotifyBase.getNotifyStart() != null)) {
            iDataObject.set(FIELD_NOTIFYSTART, (Object)pSDENotifyBase.getNotifyStart());
        }
        if (pSDENotifyBase.isNotifySubTypeDirty() && (bl || pSDENotifyBase.getNotifySubType() != null)) {
            iDataObject.set(FIELD_NOTIFYSUBTYPE, (Object)pSDENotifyBase.getNotifySubType());
        }
        if (pSDENotifyBase.isNotifyTagDirty() && (bl || pSDENotifyBase.getNotifyTag() != null)) {
            iDataObject.set(FIELD_NOTIFYTAG, (Object)pSDENotifyBase.getNotifyTag());
        }
        if (pSDENotifyBase.isNotifyTag2Dirty() && (bl || pSDENotifyBase.getNotifyTag2() != null)) {
            iDataObject.set(FIELD_NOTIFYTAG2, (Object)pSDENotifyBase.getNotifyTag2());
        }
        if (pSDENotifyBase.isPropertyMapDirty() && (bl || pSDENotifyBase.getPropertyMap() != null)) {
            iDataObject.set(FIELD_PROPERTYMAP, (Object)pSDENotifyBase.getPropertyMap());
        }
        if (pSDENotifyBase.isPSDEDSIdDirty() && (bl || pSDENotifyBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSDENotifyBase.getPSDEDSId());
        }
        if (pSDENotifyBase.isPSDEDSNameDirty() && (bl || pSDENotifyBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSDENotifyBase.getPSDEDSName());
        }
        if (pSDENotifyBase.isPSDEIdDirty() && (bl || pSDENotifyBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDENotifyBase.getPSDEId());
        }
        if (pSDENotifyBase.isPSDENameDirty() && (bl || pSDENotifyBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDENotifyBase.getPSDEName());
        }
        if (pSDENotifyBase.isPSDENotifyIdDirty() && (bl || pSDENotifyBase.getPSDENotifyId() != null)) {
            iDataObject.set(FIELD_PSDENOTIFYID, (Object)pSDENotifyBase.getPSDENotifyId());
        }
        if (pSDENotifyBase.isPSDENotifyNameDirty() && (bl || pSDENotifyBase.getPSDENotifyName() != null)) {
            iDataObject.set(FIELD_PSDENOTIFYNAME, (Object)pSDENotifyBase.getPSDENotifyName());
        }
        if (pSDENotifyBase.isPSDEPrintIdDirty() && (bl || pSDENotifyBase.getPSDEPrintId() != null)) {
            iDataObject.set(FIELD_PSDEPRINTID, (Object)pSDENotifyBase.getPSDEPrintId());
        }
        if (pSDENotifyBase.isPSDEPrintNameDirty() && (bl || pSDENotifyBase.getPSDEPrintName() != null)) {
            iDataObject.set(FIELD_PSDEPRINTNAME, (Object)pSDENotifyBase.getPSDEPrintName());
        }
        if (pSDENotifyBase.isPSDEReportIdDirty() && (bl || pSDENotifyBase.getPSDEReportId() != null)) {
            iDataObject.set(FIELD_PSDEREPORTID, (Object)pSDENotifyBase.getPSDEReportId());
        }
        if (pSDENotifyBase.isPSDEReportNameDirty() && (bl || pSDENotifyBase.getPSDEReportName() != null)) {
            iDataObject.set(FIELD_PSDEREPORTNAME, (Object)pSDENotifyBase.getPSDEReportName());
        }
        if (pSDENotifyBase.isPSSysMsgQueueIdDirty() && (bl || pSDENotifyBase.getPSSysMsgQueueId() != null)) {
            iDataObject.set(FIELD_PSSYSMSGQUEUEID, (Object)pSDENotifyBase.getPSSysMsgQueueId());
        }
        if (pSDENotifyBase.isPSSysMsgQueueNameDirty() && (bl || pSDENotifyBase.getPSSysMsgQueueName() != null)) {
            iDataObject.set(FIELD_PSSYSMSGQUEUENAME, (Object)pSDENotifyBase.getPSSysMsgQueueName());
        }
        if (pSDENotifyBase.isPSSysMsgTemplIdDirty() && (bl || pSDENotifyBase.getPSSysMsgTemplId() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLID, (Object)pSDENotifyBase.getPSSysMsgTemplId());
        }
        if (pSDENotifyBase.isPSSysMsgTemplNameDirty() && (bl || pSDENotifyBase.getPSSysMsgTemplName() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLNAME, (Object)pSDENotifyBase.getPSSysMsgTemplName());
        }
        if (pSDENotifyBase.isPSSysSFPluginIdDirty() && (bl || pSDENotifyBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDENotifyBase.getPSSysSFPluginId());
        }
        if (pSDENotifyBase.isPSSysSFPluginNameDirty() && (bl || pSDENotifyBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDENotifyBase.getPSSysSFPluginName());
        }
        if (pSDENotifyBase.isTaskModeDirty() && (bl || pSDENotifyBase.getTaskMode() != null)) {
            iDataObject.set(FIELD_TASKMODE, (Object)pSDENotifyBase.getTaskMode());
        }
        if (pSDENotifyBase.isTemplFlagDirty() && (bl || pSDENotifyBase.getTemplFlag() != null)) {
            iDataObject.set(FIELD_TEMPLFLAG, (Object)pSDENotifyBase.getTemplFlag());
        }
        if (pSDENotifyBase.isThreadRunModeDirty() && (bl || pSDENotifyBase.getThreadRunMode() != null)) {
            iDataObject.set(FIELD_THREADRUNMODE, (Object)pSDENotifyBase.getThreadRunMode());
        }
        if (pSDENotifyBase.isTimerModeDirty() && (bl || pSDENotifyBase.getTimerMode() != null)) {
            iDataObject.set(FIELD_TIMERMODE, (Object)pSDENotifyBase.getTimerMode());
        }
        if (pSDENotifyBase.isUpdateDateDirty() && (bl || pSDENotifyBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDENotifyBase.getUpdateDate());
        }
        if (pSDENotifyBase.isUpdateManDirty() && (bl || pSDENotifyBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDENotifyBase.getUpdateMan());
        }
        if (pSDENotifyBase.isUserCatDirty() && (bl || pSDENotifyBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDENotifyBase.getUserCat());
        }
        if (pSDENotifyBase.isUserTagDirty() && (bl || pSDENotifyBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDENotifyBase.getUserTag());
        }
        if (pSDENotifyBase.isUserTag2Dirty() && (bl || pSDENotifyBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDENotifyBase.getUserTag2());
        }
        if (pSDENotifyBase.isUserTag3Dirty() && (bl || pSDENotifyBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDENotifyBase.getUserTag3());
        }
        if (pSDENotifyBase.isUserTag4Dirty() && (bl || pSDENotifyBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDENotifyBase.getUserTag4());
        }
        if (pSDENotifyBase.isValidFlagDirty() && (bl || pSDENotifyBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDENotifyBase.getValidFlag());
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
        return PSDENotifyBase.remove(this, n);
    }

    private static boolean remove(PSDENotifyBase pSDENotifyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDENotifyBase.resetAttachmentType();
                return true;
            }
            case 1: {
                pSDENotifyBase.resetBeginPSDEFId();
                return true;
            }
            case 2: {
                pSDENotifyBase.resetBeginPSDEFName();
                return true;
            }
            case 3: {
                pSDENotifyBase.resetCheckTimer();
                return true;
            }
            case 4: {
                pSDENotifyBase.resetCodeName();
                return true;
            }
            case 5: {
                pSDENotifyBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSDENotifyBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSDENotifyBase.resetCustomCode();
                return true;
            }
            case 8: {
                pSDENotifyBase.resetCustomCond();
                return true;
            }
            case 9: {
                pSDENotifyBase.resetCustomMode();
                return true;
            }
            case 10: {
                pSDENotifyBase.resetCustomType();
                return true;
            }
            case 11: {
                pSDENotifyBase.resetEndPSDEFId();
                return true;
            }
            case 12: {
                pSDENotifyBase.resetEndPSDEFName();
                return true;
            }
            case 13: {
                pSDENotifyBase.resetEventModel();
                return true;
            }
            case 14: {
                pSDENotifyBase.resetEvents();
                return true;
            }
            case 15: {
                pSDENotifyBase.resetFilterModel();
                return true;
            }
            case 16: {
                pSDENotifyBase.resetIgnoreException();
                return true;
            }
            case 17: {
                pSDENotifyBase.resetMemo();
                return true;
            }
            case 18: {
                pSDENotifyBase.resetMsgType();
                return true;
            }
            case 19: {
                pSDENotifyBase.resetNotifyEnd();
                return true;
            }
            case 20: {
                pSDENotifyBase.resetNotifyStart();
                return true;
            }
            case 21: {
                pSDENotifyBase.resetNotifySubType();
                return true;
            }
            case 22: {
                pSDENotifyBase.resetNotifyTag();
                return true;
            }
            case 23: {
                pSDENotifyBase.resetNotifyTag2();
                return true;
            }
            case 24: {
                pSDENotifyBase.resetPropertyMap();
                return true;
            }
            case 25: {
                pSDENotifyBase.resetPSDEDSId();
                return true;
            }
            case 26: {
                pSDENotifyBase.resetPSDEDSName();
                return true;
            }
            case 27: {
                pSDENotifyBase.resetPSDEId();
                return true;
            }
            case 28: {
                pSDENotifyBase.resetPSDEName();
                return true;
            }
            case 29: {
                pSDENotifyBase.resetPSDENotifyId();
                return true;
            }
            case 30: {
                pSDENotifyBase.resetPSDENotifyName();
                return true;
            }
            case 31: {
                pSDENotifyBase.resetPSDEPrintId();
                return true;
            }
            case 32: {
                pSDENotifyBase.resetPSDEPrintName();
                return true;
            }
            case 33: {
                pSDENotifyBase.resetPSDEReportId();
                return true;
            }
            case 34: {
                pSDENotifyBase.resetPSDEReportName();
                return true;
            }
            case 35: {
                pSDENotifyBase.resetPSSysMsgQueueId();
                return true;
            }
            case 36: {
                pSDENotifyBase.resetPSSysMsgQueueName();
                return true;
            }
            case 37: {
                pSDENotifyBase.resetPSSysMsgTemplId();
                return true;
            }
            case 38: {
                pSDENotifyBase.resetPSSysMsgTemplName();
                return true;
            }
            case 39: {
                pSDENotifyBase.resetPSSysSFPluginId();
                return true;
            }
            case 40: {
                pSDENotifyBase.resetPSSysSFPluginName();
                return true;
            }
            case 41: {
                pSDENotifyBase.resetTaskMode();
                return true;
            }
            case 42: {
                pSDENotifyBase.resetTemplFlag();
                return true;
            }
            case 43: {
                pSDENotifyBase.resetThreadRunMode();
                return true;
            }
            case 44: {
                pSDENotifyBase.resetTimerMode();
                return true;
            }
            case 45: {
                pSDENotifyBase.resetUpdateDate();
                return true;
            }
            case 46: {
                pSDENotifyBase.resetUpdateMan();
                return true;
            }
            case 47: {
                pSDENotifyBase.resetUserCat();
                return true;
            }
            case 48: {
                pSDENotifyBase.resetUserTag();
                return true;
            }
            case 49: {
                pSDENotifyBase.resetUserTag2();
                return true;
            }
            case 50: {
                pSDENotifyBase.resetUserTag3();
                return true;
            }
            case 51: {
                pSDENotifyBase.resetUserTag4();
                return true;
            }
            case 52: {
                pSDENotifyBase.resetValidFlag();
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
    public PSDEDataSet getPSDEDS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDS();
        }
        if (this.getPSDEDSId() == null) {
            return null;
        }
        Integer n = this.objPSDEDSLock;
        synchronized (n) {
            if (this.psdeds != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSId(), (Object)this.psdeds.getPSDEDataSetId()) != 0L) {
                this.psdeds = null;
            }
            if (this.psdeds == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDSId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getBeginPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginPSDEF();
        }
        if (this.getBeginPSDEFId() == null) {
            return null;
        }
        Integer n = this.objBeginPSDEFLock;
        synchronized (n) {
            if (this.beginpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getBeginPSDEFId(), (Object)this.beginpsdef.getPSDEFieldId()) != 0L) {
                this.beginpsdef = null;
            }
            if (this.beginpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getBeginPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.beginpsdef = pSDEField;
            }
            return this.beginpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getEndPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndPSDEF();
        }
        if (this.getEndPSDEFId() == null) {
            return null;
        }
        Integer n = this.objEndPSDEFLock;
        synchronized (n) {
            if (this.endpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getEndPSDEFId(), (Object)this.endpsdef.getPSDEFieldId()) != 0L) {
                this.endpsdef = null;
            }
            if (this.endpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getEndPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.endpsdef = pSDEField;
            }
            return this.endpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEPrint getPSDEPrint() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEPrint();
        }
        if (this.getPSDEPrintId() == null) {
            return null;
        }
        Integer n = this.objPSDEPrintLock;
        synchronized (n) {
            if (this.psdeprint != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEPrintId(), (Object)this.psdeprint.getPSDEPrintId()) != 0L) {
                this.psdeprint = null;
            }
            if (this.psdeprint == null) {
                PSDEPrint pSDEPrint = new PSDEPrint();
                pSDEPrint.setPSDEPrintId(this.getPSDEPrintId());
                PSDEPrintService pSDEPrintService = (PSDEPrintService)ServiceGlobal.getService(PSDEPrintService.class, (SessionFactory)this.getSessionFactory());
                pSDEPrintService.autoGet(pSDEPrint);
                this.psdeprint = pSDEPrint;
            }
            return this.psdeprint;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEReport getPSDEReport() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEReport();
        }
        if (this.getPSDEReportId() == null) {
            return null;
        }
        Integer n = this.objPSDEReportLock;
        synchronized (n) {
            if (this.psdereport != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEReportId(), (Object)this.psdereport.getPSDEReportId()) != 0L) {
                this.psdereport = null;
            }
            if (this.psdereport == null) {
                PSDEReport pSDEReport = new PSDEReport();
                pSDEReport.setPSDEReportId(this.getPSDEReportId());
                PSDEReportService pSDEReportService = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
                pSDEReportService.autoGet(pSDEReport);
                this.psdereport = pSDEReport;
            }
            return this.psdereport;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysMsgQueue getPSSysMsgQueue() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgQueue();
        }
        if (this.getPSSysMsgQueueId() == null) {
            return null;
        }
        Integer n = this.objPSSysMsgQueueLock;
        synchronized (n) {
            if (this.pssysmsgqueue != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysMsgQueueId(), (Object)this.pssysmsgqueue.getPSSysMsgQueueId()) != 0L) {
                this.pssysmsgqueue = null;
            }
            if (this.pssysmsgqueue == null) {
                PSSysMsgQueue pSSysMsgQueue = new PSSysMsgQueue();
                pSSysMsgQueue.setPSSysMsgQueueId(this.getPSSysMsgQueueId());
                PSSysMsgQueueService pSSysMsgQueueService = (PSSysMsgQueueService)ServiceGlobal.getService(PSSysMsgQueueService.class, (SessionFactory)this.getSessionFactory());
                pSSysMsgQueueService.autoGet(pSSysMsgQueue);
                this.pssysmsgqueue = pSSysMsgQueue;
            }
            return this.pssysmsgqueue;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysMsgTempl getPSSysMsgTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTempl();
        }
        if (this.getPSSysMsgTemplId() == null) {
            return null;
        }
        Integer n = this.objPSSysMsgTemplLock;
        synchronized (n) {
            if (this.pssysmsgtempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysMsgTemplId(), (Object)this.pssysmsgtempl.getPSSysMsgTemplId()) != 0L) {
                this.pssysmsgtempl = null;
            }
            if (this.pssysmsgtempl == null) {
                PSSysMsgTempl pSSysMsgTempl = new PSSysMsgTempl();
                pSSysMsgTempl.setPSSysMsgTemplId(this.getPSSysMsgTemplId());
                PSSysMsgTemplService pSSysMsgTemplService = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
                pSSysMsgTemplService.autoGet(pSSysMsgTempl);
                this.pssysmsgtempl = pSSysMsgTempl;
            }
            return this.pssysmsgtempl;
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
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDENotifyTarget> getPSDENotifyTargets() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDENotifyTargets();
        }
        if (this.getPSDENotifyId() == null) {
            return null;
        }
        PSDENotifyService pSDENotifyService = (PSDENotifyService)ServiceGlobal.getService(PSDENotifyService.class, (SessionFactory)this.getSessionFactory());
        PSDENotifyTargetService pSDENotifyTargetService = (PSDENotifyTargetService)ServiceGlobal.getService(PSDENotifyTargetService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDENotifyTargetsLock;
        synchronized (n) {
            if (this.psdenotifytargets == null) {
                this.psdenotifytargets = pSDENotifyService.isTempData(this) ? pSDENotifyTargetService.selectTempByPSDENotify(this) : pSDENotifyTargetService.selectByPSDENotify(this);
            }
            return this.psdenotifytargets;
        }
    }

    private PSDENotifyBase getProxyEntity() {
        return this.proxyPSDENotifyBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDENotifyBase = null;
        if (iDataObject != null && iDataObject instanceof PSDENotifyBase) {
            this.proxyPSDENotifyBase = (PSDENotifyBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDENotifyService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ATTACHMENTTYPE, 0);
        fieldIndexMap.put(FIELD_BEGINPSDEFID, 1);
        fieldIndexMap.put(FIELD_BEGINPSDEFNAME, 2);
        fieldIndexMap.put(FIELD_CHECKTIMER, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 7);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 8);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 9);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 10);
        fieldIndexMap.put(FIELD_ENDPSDEFID, 11);
        fieldIndexMap.put(FIELD_ENDPSDEFNAME, 12);
        fieldIndexMap.put(FIELD_EVENTMODEL, 13);
        fieldIndexMap.put(FIELD_EVENTS, 14);
        fieldIndexMap.put(FIELD_FILTERMODEL, 15);
        fieldIndexMap.put(FIELD_IGNOREEXCEPTION, 16);
        fieldIndexMap.put(FIELD_MEMO, 17);
        fieldIndexMap.put(FIELD_MSGTYPE, 18);
        fieldIndexMap.put(FIELD_NOTIFYEND, 19);
        fieldIndexMap.put(FIELD_NOTIFYSTART, 20);
        fieldIndexMap.put(FIELD_NOTIFYSUBTYPE, 21);
        fieldIndexMap.put(FIELD_NOTIFYTAG, 22);
        fieldIndexMap.put(FIELD_NOTIFYTAG2, 23);
        fieldIndexMap.put(FIELD_PROPERTYMAP, 24);
        fieldIndexMap.put(FIELD_PSDEDSID, 25);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 26);
        fieldIndexMap.put(FIELD_PSDEID, 27);
        fieldIndexMap.put(FIELD_PSDENAME, 28);
        fieldIndexMap.put(FIELD_PSDENOTIFYID, 29);
        fieldIndexMap.put(FIELD_PSDENOTIFYNAME, 30);
        fieldIndexMap.put(FIELD_PSDEPRINTID, 31);
        fieldIndexMap.put(FIELD_PSDEPRINTNAME, 32);
        fieldIndexMap.put(FIELD_PSDEREPORTID, 33);
        fieldIndexMap.put(FIELD_PSDEREPORTNAME, 34);
        fieldIndexMap.put(FIELD_PSSYSMSGQUEUEID, 35);
        fieldIndexMap.put(FIELD_PSSYSMSGQUEUENAME, 36);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLID, 37);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLNAME, 38);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 39);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 40);
        fieldIndexMap.put(FIELD_TASKMODE, 41);
        fieldIndexMap.put(FIELD_TEMPLFLAG, 42);
        fieldIndexMap.put(FIELD_THREADRUNMODE, 43);
        fieldIndexMap.put(FIELD_TIMERMODE, 44);
        fieldIndexMap.put(FIELD_UPDATEDATE, 45);
        fieldIndexMap.put(FIELD_UPDATEMAN, 46);
        fieldIndexMap.put(FIELD_USERCAT, 47);
        fieldIndexMap.put(FIELD_USERTAG, 48);
        fieldIndexMap.put(FIELD_USERTAG2, 49);
        fieldIndexMap.put(FIELD_USERTAG3, 50);
        fieldIndexMap.put(FIELD_USERTAG4, 51);
        fieldIndexMap.put(FIELD_VALIDFLAG, 52);
    }
}

