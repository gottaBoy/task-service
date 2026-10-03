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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicLink;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicLinkService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDELogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDELogicBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DEBUGMODE = "DEBUGMODE";
    public static final String FIELD_DEFAULTMSLOGIC = "DEFAULTMSLOGIC";
    public static final String FIELD_DEFLOGICMODE = "DEFLOGICMODE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_EVENTMODEL = "EVENTMODEL";
    public static final String FIELD_EVENTS = "EVENTS";
    public static final String FIELD_EXTENDMODE = "EXTENDMODE";
    public static final String FIELD_FINISHFLAG = "FINISHFLAG";
    public static final String FIELD_IGNOREEXCEPTION = "IGNOREEXCEPTION";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICHOLDER = "LOGICHOLDER";
    public static final String FIELD_LOGICMODEL = "LOGICMODEL";
    public static final String FIELD_LOGICSN = "LOGICSN";
    public static final String FIELD_LOGICSUBTYPE = "LOGICSUBTYPE";
    public static final String FIELD_LOGICTAG = "LOGICTAG";
    public static final String FIELD_LOGICTAG2 = "LOGICTAG2";
    public static final String FIELD_LOGICTAG3 = "LOGICTAG3";
    public static final String FIELD_LOGICTAG4 = "LOGICTAG4";
    public static final String FIELD_LOGICTYPE = "LOGICTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTASKID = "PSSYSTASKID";
    public static final String FIELD_PSSYSTASKNAME = "PSSYSTASKNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_SCRIPTENGINE = "SCRIPTENGINE";
    public static final String FIELD_TEMPLFLAG = "TEMPLFLAG";
    public static final String FIELD_THREADRUNMODE = "THREADRUNMODE";
    public static final String FIELD_TIMERPOLICY = "TIMERPOLICY";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMCODE = 3;
    private static final int INDEX_CUSTOMMODE = 4;
    private static final int INDEX_DEBUGMODE = 5;
    private static final int INDEX_DEFAULTMSLOGIC = 6;
    private static final int INDEX_DEFLOGICMODE = 7;
    private static final int INDEX_DYNAMODELFLAG = 8;
    private static final int INDEX_EVENTMODEL = 9;
    private static final int INDEX_EVENTS = 10;
    private static final int INDEX_EXTENDMODE = 11;
    private static final int INDEX_FINISHFLAG = 12;
    private static final int INDEX_IGNOREEXCEPTION = 13;
    private static final int INDEX_LOCKFLAG = 14;
    private static final int INDEX_LOGICHOLDER = 15;
    private static final int INDEX_LOGICMODEL = 16;
    private static final int INDEX_LOGICSN = 17;
    private static final int INDEX_LOGICSUBTYPE = 18;
    private static final int INDEX_LOGICTAG = 19;
    private static final int INDEX_LOGICTAG2 = 20;
    private static final int INDEX_LOGICTAG3 = 21;
    private static final int INDEX_LOGICTAG4 = 22;
    private static final int INDEX_LOGICTYPE = 23;
    private static final int INDEX_MEMO = 24;
    private static final int INDEX_ORDERVALUE = 25;
    private static final int INDEX_PSDEFID = 26;
    private static final int INDEX_PSDEFNAME = 27;
    private static final int INDEX_PSDEID = 28;
    private static final int INDEX_PSDELOGICID = 29;
    private static final int INDEX_PSDELOGICNAME = 30;
    private static final int INDEX_PSDENAME = 31;
    private static final int INDEX_PSDYNAINSTID = 32;
    private static final int INDEX_PSMODULEID = 33;
    private static final int INDEX_PSMODULENAME = 34;
    private static final int INDEX_PSSYSDYNAMODELID = 35;
    private static final int INDEX_PSSYSDYNAMODELNAME = 36;
    private static final int INDEX_PSSYSREQITEMID = 37;
    private static final int INDEX_PSSYSREQITEMNAME = 38;
    private static final int INDEX_PSSYSSFPLUGINID = 39;
    private static final int INDEX_PSSYSSFPLUGINNAME = 40;
    private static final int INDEX_PSSYSTASKID = 41;
    private static final int INDEX_PSSYSTASKNAME = 42;
    private static final int INDEX_PSSYSTEMID = 43;
    private static final int INDEX_PSSYSTEMNAME = 44;
    private static final int INDEX_SCRIPTENGINE = 45;
    private static final int INDEX_TEMPLFLAG = 46;
    private static final int INDEX_THREADRUNMODE = 47;
    private static final int INDEX_TIMERPOLICY = 48;
    private static final int INDEX_TODOTASK = 49;
    private static final int INDEX_UPDATEDATE = 50;
    private static final int INDEX_UPDATEMAN = 51;
    private static final int INDEX_USERCAT = 52;
    private static final int INDEX_USERTAG = 53;
    private static final int INDEX_USERTAG2 = 54;
    private static final int INDEX_USERTAG3 = 55;
    private static final int INDEX_USERTAG4 = 56;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDELogicBase proxyPSDELogicBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean debugmodeDirtyFlag = false;
    private boolean defaultmslogicDirtyFlag = false;
    private boolean deflogicmodeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean eventmodelDirtyFlag = false;
    private boolean eventsDirtyFlag = false;
    private boolean extendmodeDirtyFlag = false;
    private boolean finishflagDirtyFlag = false;
    private boolean ignoreexceptionDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicholderDirtyFlag = false;
    private boolean logicmodelDirtyFlag = false;
    private boolean logicsnDirtyFlag = false;
    private boolean logicsubtypeDirtyFlag = false;
    private boolean logictagDirtyFlag = false;
    private boolean logictag2DirtyFlag = false;
    private boolean logictag3DirtyFlag = false;
    private boolean logictag4DirtyFlag = false;
    private boolean logictypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystaskidDirtyFlag = false;
    private boolean pssystasknameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean scriptengineDirtyFlag = false;
    private boolean templflagDirtyFlag = false;
    private boolean threadrunmodeDirtyFlag = false;
    private boolean timerpolicyDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
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
    @Column(name="debugmode")
    private Integer debugmode;
    @Column(name="defaultmslogic")
    private Integer defaultmslogic;
    @Column(name="deflogicmode")
    private String deflogicmode;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="eventmodel")
    private String eventmodel;
    @Column(name="events")
    private String events;
    @Column(name="extendmode")
    private Integer extendmode;
    @Column(name="finishflag")
    private Integer finishflag;
    @Column(name="ignoreexception")
    private Integer ignoreexception;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicholder")
    private Integer logicholder;
    @Column(name="logicmodel")
    private String logicmodel;
    @Column(name="logicsn")
    private String logicsn;
    @Column(name="logicsubtype")
    private String logicsubtype;
    @Column(name="logictag")
    private String logictag;
    @Column(name="logictag2")
    private String logictag2;
    @Column(name="logictag3")
    private String logictag3;
    @Column(name="logictag4")
    private String logictag4;
    @Column(name="logictype")
    private String logictype;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystaskid")
    private String pssystaskid;
    @Column(name="pssystaskname")
    private String pssystaskname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="scriptengine")
    private String scriptengine;
    @Column(name="templflag")
    private Integer templflag;
    @Column(name="threadrunmode")
    private Integer threadrunmode;
    @Column(name="timerpolicy")
    private String timerpolicy;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSysTaskLock = new Integer(1);
    private PSSysTask pssystask = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSDELogicLinksLock = new Integer(1);
    private ArrayList<PSDELogicLink> psdelogiclinks = null;
    private Integer objPSDELogicNodesLock = new Integer(1);
    private ArrayList<PSDELogicNode> psdelogicnodes = null;
    private Integer objPSDELogicParamsLock = new Integer(1);
    private ArrayList<PSDELogicParam> psdelogicparams = null;

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

    public void setDebugMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDebugMode(n);
            return;
        }
        this.debugmode = n;
        this.debugmodeDirtyFlag = true;
    }

    public Integer getDebugMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDebugMode();
        }
        return this.debugmode;
    }

    public boolean isDebugModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDebugModeDirty();
        }
        return this.debugmodeDirtyFlag;
    }

    public void resetDebugMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDebugMode();
            return;
        }
        this.debugmodeDirtyFlag = false;
        this.debugmode = null;
    }

    public void setDefaultMSLogic(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultMSLogic(n);
            return;
        }
        this.defaultmslogic = n;
        this.defaultmslogicDirtyFlag = true;
    }

    public Integer getDefaultMSLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultMSLogic();
        }
        return this.defaultmslogic;
    }

    public boolean isDefaultMSLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultMSLogicDirty();
        }
        return this.defaultmslogicDirtyFlag;
    }

    public void resetDefaultMSLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultMSLogic();
            return;
        }
        this.defaultmslogicDirtyFlag = false;
        this.defaultmslogic = null;
    }

    public void setDEFLogicMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFLogicMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deflogicmode = string;
        this.deflogicmodeDirtyFlag = true;
    }

    public String getDEFLogicMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFLogicMode();
        }
        return this.deflogicmode;
    }

    public boolean isDEFLogicModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFLogicModeDirty();
        }
        return this.deflogicmodeDirtyFlag;
    }

    public void resetDEFLogicMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFLogicMode();
            return;
        }
        this.deflogicmodeDirtyFlag = false;
        this.deflogicmode = null;
    }

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
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

    public void setExtendMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtendMode(n);
            return;
        }
        this.extendmode = n;
        this.extendmodeDirtyFlag = true;
    }

    public Integer getExtendMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtendMode();
        }
        return this.extendmode;
    }

    public boolean isExtendModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtendModeDirty();
        }
        return this.extendmodeDirtyFlag;
    }

    public void resetExtendMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtendMode();
            return;
        }
        this.extendmodeDirtyFlag = false;
        this.extendmode = null;
    }

    public void setFinishFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishFlag(n);
            return;
        }
        this.finishflag = n;
        this.finishflagDirtyFlag = true;
    }

    public Integer getFinishFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishFlag();
        }
        return this.finishflag;
    }

    public boolean isFinishFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishFlagDirty();
        }
        return this.finishflagDirtyFlag;
    }

    public void resetFinishFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishFlag();
            return;
        }
        this.finishflagDirtyFlag = false;
        this.finishflag = null;
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

    public void setLogicHolder(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicHolder(n);
            return;
        }
        this.logicholder = n;
        this.logicholderDirtyFlag = true;
    }

    public Integer getLogicHolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicHolder();
        }
        return this.logicholder;
    }

    public boolean isLogicHolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicHolderDirty();
        }
        return this.logicholderDirtyFlag;
    }

    public void resetLogicHolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicHolder();
            return;
        }
        this.logicholderDirtyFlag = false;
        this.logicholder = null;
    }

    public void setLogicModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicmodel = string;
        this.logicmodelDirtyFlag = true;
    }

    public String getLogicModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicModel();
        }
        return this.logicmodel;
    }

    public boolean isLogicModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicModelDirty();
        }
        return this.logicmodelDirtyFlag;
    }

    public void resetLogicModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicModel();
            return;
        }
        this.logicmodelDirtyFlag = false;
        this.logicmodel = null;
    }

    public void setLogicSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicsn = string;
        this.logicsnDirtyFlag = true;
    }

    public String getLogicSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicSN();
        }
        return this.logicsn;
    }

    public boolean isLogicSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicSNDirty();
        }
        return this.logicsnDirtyFlag;
    }

    public void resetLogicSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicSN();
            return;
        }
        this.logicsnDirtyFlag = false;
        this.logicsn = null;
    }

    public void setLogicSubType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicSubType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicsubtype = string;
        this.logicsubtypeDirtyFlag = true;
    }

    public String getLogicSubType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicSubType();
        }
        return this.logicsubtype;
    }

    public boolean isLogicSubTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicSubTypeDirty();
        }
        return this.logicsubtypeDirtyFlag;
    }

    public void resetLogicSubType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicSubType();
            return;
        }
        this.logicsubtypeDirtyFlag = false;
        this.logicsubtype = null;
    }

    public void setLogicTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logictag = string;
        this.logictagDirtyFlag = true;
    }

    public String getLogicTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicTag();
        }
        return this.logictag;
    }

    public boolean isLogicTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicTagDirty();
        }
        return this.logictagDirtyFlag;
    }

    public void resetLogicTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicTag();
            return;
        }
        this.logictagDirtyFlag = false;
        this.logictag = null;
    }

    public void setLogicTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logictag2 = string;
        this.logictag2DirtyFlag = true;
    }

    public String getLogicTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicTag2();
        }
        return this.logictag2;
    }

    public boolean isLogicTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicTag2Dirty();
        }
        return this.logictag2DirtyFlag;
    }

    public void resetLogicTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicTag2();
            return;
        }
        this.logictag2DirtyFlag = false;
        this.logictag2 = null;
    }

    public void setLogicTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logictag3 = string;
        this.logictag3DirtyFlag = true;
    }

    public String getLogicTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicTag3();
        }
        return this.logictag3;
    }

    public boolean isLogicTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicTag3Dirty();
        }
        return this.logictag3DirtyFlag;
    }

    public void resetLogicTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicTag3();
            return;
        }
        this.logictag3DirtyFlag = false;
        this.logictag3 = null;
    }

    public void setLogicTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logictag4 = string;
        this.logictag4DirtyFlag = true;
    }

    public String getLogicTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicTag4();
        }
        return this.logictag4;
    }

    public boolean isLogicTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicTag4Dirty();
        }
        return this.logictag4DirtyFlag;
    }

    public void resetLogicTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicTag4();
            return;
        }
        this.logictag4DirtyFlag = false;
        this.logictag4 = null;
    }

    public void setLogicType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logictype = string;
        this.logictypeDirtyFlag = true;
    }

    public String getLogicType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicType();
        }
        return this.logictype;
    }

    public boolean isLogicTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicTypeDirty();
        }
        return this.logictypeDirtyFlag;
    }

    public void resetLogicType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicType();
            return;
        }
        this.logictypeDirtyFlag = false;
        this.logictype = null;
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

    public void setPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicid = string;
        this.psdelogicidDirtyFlag = true;
    }

    public String getPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicId();
        }
        return this.psdelogicid;
    }

    public boolean isPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicIdDirty();
        }
        return this.psdelogicidDirtyFlag;
    }

    public void resetPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicId();
            return;
        }
        this.psdelogicidDirtyFlag = false;
        this.psdelogicid = null;
    }

    public void setPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicname = string;
        this.psdelogicnameDirtyFlag = true;
    }

    public String getPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicName();
        }
        return this.psdelogicname;
    }

    public boolean isPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNameDirty();
        }
        return this.psdelogicnameDirtyFlag;
    }

    public void resetPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicName();
            return;
        }
        this.psdelogicnameDirtyFlag = false;
        this.psdelogicname = null;
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

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
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

    public void setPSSysTaskId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTaskId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystaskid = string;
        this.pssystaskidDirtyFlag = true;
    }

    public String getPSSysTaskId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTaskId();
        }
        return this.pssystaskid;
    }

    public boolean isPSSysTaskIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTaskIdDirty();
        }
        return this.pssystaskidDirtyFlag;
    }

    public void resetPSSysTaskId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTaskId();
            return;
        }
        this.pssystaskidDirtyFlag = false;
        this.pssystaskid = null;
    }

    public void setPSSysTaskName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTaskName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystaskname = string;
        this.pssystasknameDirtyFlag = true;
    }

    public String getPSSysTaskName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTaskName();
        }
        return this.pssystaskname;
    }

    public boolean isPSSysTaskNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTaskNameDirty();
        }
        return this.pssystasknameDirtyFlag;
    }

    public void resetPSSysTaskName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTaskName();
            return;
        }
        this.pssystasknameDirtyFlag = false;
        this.pssystaskname = null;
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

    public void setScriptEngine(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setScriptEngine(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.scriptengine = string;
        this.scriptengineDirtyFlag = true;
    }

    public String getScriptEngine() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getScriptEngine();
        }
        return this.scriptengine;
    }

    public boolean isScriptEngineDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isScriptEngineDirty();
        }
        return this.scriptengineDirtyFlag;
    }

    public void resetScriptEngine() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetScriptEngine();
            return;
        }
        this.scriptengineDirtyFlag = false;
        this.scriptengine = null;
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

    public void setTimerPolicy(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimerPolicy(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timerpolicy = string;
        this.timerpolicyDirtyFlag = true;
    }

    public String getTimerPolicy() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimerPolicy();
        }
        return this.timerpolicy;
    }

    public boolean isTimerPolicyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimerPolicyDirty();
        }
        return this.timerpolicyDirtyFlag;
    }

    public void resetTimerPolicy() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimerPolicy();
            return;
        }
        this.timerpolicyDirtyFlag = false;
        this.timerpolicy = null;
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
        PSDELogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDELogicBase pSDELogicBase) {
        pSDELogicBase.resetCodeName();
        pSDELogicBase.resetCreateDate();
        pSDELogicBase.resetCreateMan();
        pSDELogicBase.resetCustomCode();
        pSDELogicBase.resetCustomMode();
        pSDELogicBase.resetDebugMode();
        pSDELogicBase.resetDefaultMSLogic();
        pSDELogicBase.resetDEFLogicMode();
        pSDELogicBase.resetDynaModelFlag();
        pSDELogicBase.resetEventModel();
        pSDELogicBase.resetEvents();
        pSDELogicBase.resetExtendMode();
        pSDELogicBase.resetFinishFlag();
        pSDELogicBase.resetIgnoreException();
        pSDELogicBase.resetLockFlag();
        pSDELogicBase.resetLogicHolder();
        pSDELogicBase.resetLogicModel();
        pSDELogicBase.resetLogicSN();
        pSDELogicBase.resetLogicSubType();
        pSDELogicBase.resetLogicTag();
        pSDELogicBase.resetLogicTag2();
        pSDELogicBase.resetLogicTag3();
        pSDELogicBase.resetLogicTag4();
        pSDELogicBase.resetLogicType();
        pSDELogicBase.resetMemo();
        pSDELogicBase.resetOrderValue();
        pSDELogicBase.resetPSDEFId();
        pSDELogicBase.resetPSDEFName();
        pSDELogicBase.resetPSDEId();
        pSDELogicBase.resetPSDELogicId();
        pSDELogicBase.resetPSDELogicName();
        pSDELogicBase.resetPSDEName();
        pSDELogicBase.resetPSDynaInstId();
        pSDELogicBase.resetPSModuleId();
        pSDELogicBase.resetPSModuleName();
        pSDELogicBase.resetPSSysDynaModelId();
        pSDELogicBase.resetPSSysDynaModelName();
        pSDELogicBase.resetPSSysReqItemId();
        pSDELogicBase.resetPSSysReqItemName();
        pSDELogicBase.resetPSSysSFPluginId();
        pSDELogicBase.resetPSSysSFPluginName();
        pSDELogicBase.resetPSSysTaskId();
        pSDELogicBase.resetPSSysTaskName();
        pSDELogicBase.resetPSSystemId();
        pSDELogicBase.resetPSSystemName();
        pSDELogicBase.resetScriptEngine();
        pSDELogicBase.resetTemplFlag();
        pSDELogicBase.resetThreadRunMode();
        pSDELogicBase.resetTimerPolicy();
        pSDELogicBase.resetToDoTask();
        pSDELogicBase.resetUpdateDate();
        pSDELogicBase.resetUpdateMan();
        pSDELogicBase.resetUserCat();
        pSDELogicBase.resetUserTag();
        pSDELogicBase.resetUserTag2();
        pSDELogicBase.resetUserTag3();
        pSDELogicBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isDebugModeDirty()) {
            hashMap.put(FIELD_DEBUGMODE, this.getDebugMode());
        }
        if (!bl || this.isDefaultMSLogicDirty()) {
            hashMap.put(FIELD_DEFAULTMSLOGIC, this.getDefaultMSLogic());
        }
        if (!bl || this.isDEFLogicModeDirty()) {
            hashMap.put(FIELD_DEFLOGICMODE, this.getDEFLogicMode());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEventModelDirty()) {
            hashMap.put(FIELD_EVENTMODEL, this.getEventModel());
        }
        if (!bl || this.isEventsDirty()) {
            hashMap.put(FIELD_EVENTS, this.getEvents());
        }
        if (!bl || this.isExtendModeDirty()) {
            hashMap.put(FIELD_EXTENDMODE, this.getExtendMode());
        }
        if (!bl || this.isFinishFlagDirty()) {
            hashMap.put(FIELD_FINISHFLAG, this.getFinishFlag());
        }
        if (!bl || this.isIgnoreExceptionDirty()) {
            hashMap.put(FIELD_IGNOREEXCEPTION, this.getIgnoreException());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isLogicHolderDirty()) {
            hashMap.put(FIELD_LOGICHOLDER, this.getLogicHolder());
        }
        if (!bl || this.isLogicModelDirty()) {
            hashMap.put(FIELD_LOGICMODEL, this.getLogicModel());
        }
        if (!bl || this.isLogicSNDirty()) {
            hashMap.put(FIELD_LOGICSN, this.getLogicSN());
        }
        if (!bl || this.isLogicSubTypeDirty()) {
            hashMap.put(FIELD_LOGICSUBTYPE, this.getLogicSubType());
        }
        if (!bl || this.isLogicTagDirty()) {
            hashMap.put(FIELD_LOGICTAG, this.getLogicTag());
        }
        if (!bl || this.isLogicTag2Dirty()) {
            hashMap.put(FIELD_LOGICTAG2, this.getLogicTag2());
        }
        if (!bl || this.isLogicTag3Dirty()) {
            hashMap.put(FIELD_LOGICTAG3, this.getLogicTag3());
        }
        if (!bl || this.isLogicTag4Dirty()) {
            hashMap.put(FIELD_LOGICTAG4, this.getLogicTag4());
        }
        if (!bl || this.isLogicTypeDirty()) {
            hashMap.put(FIELD_LOGICTYPE, this.getLogicType());
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
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDELogicIdDirty()) {
            hashMap.put(FIELD_PSDELOGICID, this.getPSDELogicId());
        }
        if (!bl || this.isPSDELogicNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNAME, this.getPSDELogicName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
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
        if (!bl || this.isPSSysTaskIdDirty()) {
            hashMap.put(FIELD_PSSYSTASKID, this.getPSSysTaskId());
        }
        if (!bl || this.isPSSysTaskNameDirty()) {
            hashMap.put(FIELD_PSSYSTASKNAME, this.getPSSysTaskName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isScriptEngineDirty()) {
            hashMap.put(FIELD_SCRIPTENGINE, this.getScriptEngine());
        }
        if (!bl || this.isTemplFlagDirty()) {
            hashMap.put(FIELD_TEMPLFLAG, this.getTemplFlag());
        }
        if (!bl || this.isThreadRunModeDirty()) {
            hashMap.put(FIELD_THREADRUNMODE, this.getThreadRunMode());
        }
        if (!bl || this.isTimerPolicyDirty()) {
            hashMap.put(FIELD_TIMERPOLICY, this.getTimerPolicy());
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
        return PSDELogicBase.get(this, n);
    }

    private static Object get(PSDELogicBase pSDELogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELogicBase.getCodeName();
            }
            case 1: {
                return pSDELogicBase.getCreateDate();
            }
            case 2: {
                return pSDELogicBase.getCreateMan();
            }
            case 3: {
                return pSDELogicBase.getCustomCode();
            }
            case 4: {
                return pSDELogicBase.getCustomMode();
            }
            case 5: {
                return pSDELogicBase.getDebugMode();
            }
            case 6: {
                return pSDELogicBase.getDefaultMSLogic();
            }
            case 7: {
                return pSDELogicBase.getDEFLogicMode();
            }
            case 8: {
                return pSDELogicBase.getDynaModelFlag();
            }
            case 9: {
                return pSDELogicBase.getEventModel();
            }
            case 10: {
                return pSDELogicBase.getEvents();
            }
            case 11: {
                return pSDELogicBase.getExtendMode();
            }
            case 12: {
                return pSDELogicBase.getFinishFlag();
            }
            case 13: {
                return pSDELogicBase.getIgnoreException();
            }
            case 14: {
                return pSDELogicBase.getLockFlag();
            }
            case 15: {
                return pSDELogicBase.getLogicHolder();
            }
            case 16: {
                return pSDELogicBase.getLogicModel();
            }
            case 17: {
                return pSDELogicBase.getLogicSN();
            }
            case 18: {
                return pSDELogicBase.getLogicSubType();
            }
            case 19: {
                return pSDELogicBase.getLogicTag();
            }
            case 20: {
                return pSDELogicBase.getLogicTag2();
            }
            case 21: {
                return pSDELogicBase.getLogicTag3();
            }
            case 22: {
                return pSDELogicBase.getLogicTag4();
            }
            case 23: {
                return pSDELogicBase.getLogicType();
            }
            case 24: {
                return pSDELogicBase.getMemo();
            }
            case 25: {
                return pSDELogicBase.getOrderValue();
            }
            case 26: {
                return pSDELogicBase.getPSDEFId();
            }
            case 27: {
                return pSDELogicBase.getPSDEFName();
            }
            case 28: {
                return pSDELogicBase.getPSDEId();
            }
            case 29: {
                return pSDELogicBase.getPSDELogicId();
            }
            case 30: {
                return pSDELogicBase.getPSDELogicName();
            }
            case 31: {
                return pSDELogicBase.getPSDEName();
            }
            case 32: {
                return pSDELogicBase.getPSDynaInstId();
            }
            case 33: {
                return pSDELogicBase.getPSModuleId();
            }
            case 34: {
                return pSDELogicBase.getPSModuleName();
            }
            case 35: {
                return pSDELogicBase.getPSSysDynaModelId();
            }
            case 36: {
                return pSDELogicBase.getPSSysDynaModelName();
            }
            case 37: {
                return pSDELogicBase.getPSSysReqItemId();
            }
            case 38: {
                return pSDELogicBase.getPSSysReqItemName();
            }
            case 39: {
                return pSDELogicBase.getPSSysSFPluginId();
            }
            case 40: {
                return pSDELogicBase.getPSSysSFPluginName();
            }
            case 41: {
                return pSDELogicBase.getPSSysTaskId();
            }
            case 42: {
                return pSDELogicBase.getPSSysTaskName();
            }
            case 43: {
                return pSDELogicBase.getPSSystemId();
            }
            case 44: {
                return pSDELogicBase.getPSSystemName();
            }
            case 45: {
                return pSDELogicBase.getScriptEngine();
            }
            case 46: {
                return pSDELogicBase.getTemplFlag();
            }
            case 47: {
                return pSDELogicBase.getThreadRunMode();
            }
            case 48: {
                return pSDELogicBase.getTimerPolicy();
            }
            case 49: {
                return pSDELogicBase.getToDoTask();
            }
            case 50: {
                return pSDELogicBase.getUpdateDate();
            }
            case 51: {
                return pSDELogicBase.getUpdateMan();
            }
            case 52: {
                return pSDELogicBase.getUserCat();
            }
            case 53: {
                return pSDELogicBase.getUserTag();
            }
            case 54: {
                return pSDELogicBase.getUserTag2();
            }
            case 55: {
                return pSDELogicBase.getUserTag3();
            }
            case 56: {
                return pSDELogicBase.getUserTag4();
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
        PSDELogicBase.set(this, n, object);
    }

    private static void set(PSDELogicBase pSDELogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDELogicBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDELogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDELogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDELogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDELogicBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDELogicBase.setDebugMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDELogicBase.setDefaultMSLogic(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDELogicBase.setDEFLogicMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDELogicBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDELogicBase.setEventModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDELogicBase.setEvents(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDELogicBase.setExtendMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDELogicBase.setFinishFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDELogicBase.setIgnoreException(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDELogicBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDELogicBase.setLogicHolder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDELogicBase.setLogicModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDELogicBase.setLogicSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDELogicBase.setLogicSubType(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDELogicBase.setLogicTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDELogicBase.setLogicTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDELogicBase.setLogicTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDELogicBase.setLogicTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDELogicBase.setLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDELogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDELogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDELogicBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDELogicBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDELogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDELogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDELogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDELogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDELogicBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDELogicBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDELogicBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDELogicBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDELogicBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDELogicBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDELogicBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDELogicBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDELogicBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDELogicBase.setPSSysTaskId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDELogicBase.setPSSysTaskName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDELogicBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDELogicBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDELogicBase.setScriptEngine(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDELogicBase.setTemplFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 47: {
                pSDELogicBase.setThreadRunMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 48: {
                pSDELogicBase.setTimerPolicy(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDELogicBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDELogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 51: {
                pSDELogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDELogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDELogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDELogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDELogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDELogicBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDELogicBase.isNull(this, n);
    }

    private static boolean isNull(PSDELogicBase pSDELogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELogicBase.getCodeName() == null;
            }
            case 1: {
                return pSDELogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSDELogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSDELogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSDELogicBase.getCustomMode() == null;
            }
            case 5: {
                return pSDELogicBase.getDebugMode() == null;
            }
            case 6: {
                return pSDELogicBase.getDefaultMSLogic() == null;
            }
            case 7: {
                return pSDELogicBase.getDEFLogicMode() == null;
            }
            case 8: {
                return pSDELogicBase.getDynaModelFlag() == null;
            }
            case 9: {
                return pSDELogicBase.getEventModel() == null;
            }
            case 10: {
                return pSDELogicBase.getEvents() == null;
            }
            case 11: {
                return pSDELogicBase.getExtendMode() == null;
            }
            case 12: {
                return pSDELogicBase.getFinishFlag() == null;
            }
            case 13: {
                return pSDELogicBase.getIgnoreException() == null;
            }
            case 14: {
                return pSDELogicBase.getLockFlag() == null;
            }
            case 15: {
                return pSDELogicBase.getLogicHolder() == null;
            }
            case 16: {
                return pSDELogicBase.getLogicModel() == null;
            }
            case 17: {
                return pSDELogicBase.getLogicSN() == null;
            }
            case 18: {
                return pSDELogicBase.getLogicSubType() == null;
            }
            case 19: {
                return pSDELogicBase.getLogicTag() == null;
            }
            case 20: {
                return pSDELogicBase.getLogicTag2() == null;
            }
            case 21: {
                return pSDELogicBase.getLogicTag3() == null;
            }
            case 22: {
                return pSDELogicBase.getLogicTag4() == null;
            }
            case 23: {
                return pSDELogicBase.getLogicType() == null;
            }
            case 24: {
                return pSDELogicBase.getMemo() == null;
            }
            case 25: {
                return pSDELogicBase.getOrderValue() == null;
            }
            case 26: {
                return pSDELogicBase.getPSDEFId() == null;
            }
            case 27: {
                return pSDELogicBase.getPSDEFName() == null;
            }
            case 28: {
                return pSDELogicBase.getPSDEId() == null;
            }
            case 29: {
                return pSDELogicBase.getPSDELogicId() == null;
            }
            case 30: {
                return pSDELogicBase.getPSDELogicName() == null;
            }
            case 31: {
                return pSDELogicBase.getPSDEName() == null;
            }
            case 32: {
                return pSDELogicBase.getPSDynaInstId() == null;
            }
            case 33: {
                return pSDELogicBase.getPSModuleId() == null;
            }
            case 34: {
                return pSDELogicBase.getPSModuleName() == null;
            }
            case 35: {
                return pSDELogicBase.getPSSysDynaModelId() == null;
            }
            case 36: {
                return pSDELogicBase.getPSSysDynaModelName() == null;
            }
            case 37: {
                return pSDELogicBase.getPSSysReqItemId() == null;
            }
            case 38: {
                return pSDELogicBase.getPSSysReqItemName() == null;
            }
            case 39: {
                return pSDELogicBase.getPSSysSFPluginId() == null;
            }
            case 40: {
                return pSDELogicBase.getPSSysSFPluginName() == null;
            }
            case 41: {
                return pSDELogicBase.getPSSysTaskId() == null;
            }
            case 42: {
                return pSDELogicBase.getPSSysTaskName() == null;
            }
            case 43: {
                return pSDELogicBase.getPSSystemId() == null;
            }
            case 44: {
                return pSDELogicBase.getPSSystemName() == null;
            }
            case 45: {
                return pSDELogicBase.getScriptEngine() == null;
            }
            case 46: {
                return pSDELogicBase.getTemplFlag() == null;
            }
            case 47: {
                return pSDELogicBase.getThreadRunMode() == null;
            }
            case 48: {
                return pSDELogicBase.getTimerPolicy() == null;
            }
            case 49: {
                return pSDELogicBase.getToDoTask() == null;
            }
            case 50: {
                return pSDELogicBase.getUpdateDate() == null;
            }
            case 51: {
                return pSDELogicBase.getUpdateMan() == null;
            }
            case 52: {
                return pSDELogicBase.getUserCat() == null;
            }
            case 53: {
                return pSDELogicBase.getUserTag() == null;
            }
            case 54: {
                return pSDELogicBase.getUserTag2() == null;
            }
            case 55: {
                return pSDELogicBase.getUserTag3() == null;
            }
            case 56: {
                return pSDELogicBase.getUserTag4() == null;
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
        return PSDELogicBase.contains(this, n);
    }

    private static boolean contains(PSDELogicBase pSDELogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELogicBase.isCodeNameDirty();
            }
            case 1: {
                return pSDELogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSDELogicBase.isCreateManDirty();
            }
            case 3: {
                return pSDELogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSDELogicBase.isCustomModeDirty();
            }
            case 5: {
                return pSDELogicBase.isDebugModeDirty();
            }
            case 6: {
                return pSDELogicBase.isDefaultMSLogicDirty();
            }
            case 7: {
                return pSDELogicBase.isDEFLogicModeDirty();
            }
            case 8: {
                return pSDELogicBase.isDynaModelFlagDirty();
            }
            case 9: {
                return pSDELogicBase.isEventModelDirty();
            }
            case 10: {
                return pSDELogicBase.isEventsDirty();
            }
            case 11: {
                return pSDELogicBase.isExtendModeDirty();
            }
            case 12: {
                return pSDELogicBase.isFinishFlagDirty();
            }
            case 13: {
                return pSDELogicBase.isIgnoreExceptionDirty();
            }
            case 14: {
                return pSDELogicBase.isLockFlagDirty();
            }
            case 15: {
                return pSDELogicBase.isLogicHolderDirty();
            }
            case 16: {
                return pSDELogicBase.isLogicModelDirty();
            }
            case 17: {
                return pSDELogicBase.isLogicSNDirty();
            }
            case 18: {
                return pSDELogicBase.isLogicSubTypeDirty();
            }
            case 19: {
                return pSDELogicBase.isLogicTagDirty();
            }
            case 20: {
                return pSDELogicBase.isLogicTag2Dirty();
            }
            case 21: {
                return pSDELogicBase.isLogicTag3Dirty();
            }
            case 22: {
                return pSDELogicBase.isLogicTag4Dirty();
            }
            case 23: {
                return pSDELogicBase.isLogicTypeDirty();
            }
            case 24: {
                return pSDELogicBase.isMemoDirty();
            }
            case 25: {
                return pSDELogicBase.isOrderValueDirty();
            }
            case 26: {
                return pSDELogicBase.isPSDEFIdDirty();
            }
            case 27: {
                return pSDELogicBase.isPSDEFNameDirty();
            }
            case 28: {
                return pSDELogicBase.isPSDEIdDirty();
            }
            case 29: {
                return pSDELogicBase.isPSDELogicIdDirty();
            }
            case 30: {
                return pSDELogicBase.isPSDELogicNameDirty();
            }
            case 31: {
                return pSDELogicBase.isPSDENameDirty();
            }
            case 32: {
                return pSDELogicBase.isPSDynaInstIdDirty();
            }
            case 33: {
                return pSDELogicBase.isPSModuleIdDirty();
            }
            case 34: {
                return pSDELogicBase.isPSModuleNameDirty();
            }
            case 35: {
                return pSDELogicBase.isPSSysDynaModelIdDirty();
            }
            case 36: {
                return pSDELogicBase.isPSSysDynaModelNameDirty();
            }
            case 37: {
                return pSDELogicBase.isPSSysReqItemIdDirty();
            }
            case 38: {
                return pSDELogicBase.isPSSysReqItemNameDirty();
            }
            case 39: {
                return pSDELogicBase.isPSSysSFPluginIdDirty();
            }
            case 40: {
                return pSDELogicBase.isPSSysSFPluginNameDirty();
            }
            case 41: {
                return pSDELogicBase.isPSSysTaskIdDirty();
            }
            case 42: {
                return pSDELogicBase.isPSSysTaskNameDirty();
            }
            case 43: {
                return pSDELogicBase.isPSSystemIdDirty();
            }
            case 44: {
                return pSDELogicBase.isPSSystemNameDirty();
            }
            case 45: {
                return pSDELogicBase.isScriptEngineDirty();
            }
            case 46: {
                return pSDELogicBase.isTemplFlagDirty();
            }
            case 47: {
                return pSDELogicBase.isThreadRunModeDirty();
            }
            case 48: {
                return pSDELogicBase.isTimerPolicyDirty();
            }
            case 49: {
                return pSDELogicBase.isToDoTaskDirty();
            }
            case 50: {
                return pSDELogicBase.isUpdateDateDirty();
            }
            case 51: {
                return pSDELogicBase.isUpdateManDirty();
            }
            case 52: {
                return pSDELogicBase.isUserCatDirty();
            }
            case 53: {
                return pSDELogicBase.isUserTagDirty();
            }
            case 54: {
                return pSDELogicBase.isUserTag2Dirty();
            }
            case 55: {
                return pSDELogicBase.isUserTag3Dirty();
            }
            case 56: {
                return pSDELogicBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDELogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDELogicBase pSDELogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDELogicBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDELogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDELogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDELogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDELogicBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDELogicBase.getDebugMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"debugmode", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getDebugMode()), (boolean)false);
        }
        if (bl || pSDELogicBase.getDefaultMSLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultmslogic", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getDefaultMSLogic()), (boolean)false);
        }
        if (bl || pSDELogicBase.getDEFLogicMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deflogicmode", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getDEFLogicMode()), (boolean)false);
        }
        if (bl || pSDELogicBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDELogicBase.getEventModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventmodel", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getEventModel()), (boolean)false);
        }
        if (bl || pSDELogicBase.getEvents() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"events", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getEvents()), (boolean)false);
        }
        if (bl || pSDELogicBase.getExtendMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extendmode", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getExtendMode()), (boolean)false);
        }
        if (bl || pSDELogicBase.getFinishFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"finishflag", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getFinishFlag()), (boolean)false);
        }
        if (bl || pSDELogicBase.getIgnoreException() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreexception", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getIgnoreException()), (boolean)false);
        }
        if (bl || pSDELogicBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDELogicBase.getLogicHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicholder", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getLogicHolder()), (boolean)false);
        }
        if (bl || pSDELogicBase.getLogicModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicmodel", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getLogicModel()), (boolean)false);
        }
        if (bl || pSDELogicBase.getLogicSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicsn", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getLogicSN()), (boolean)false);
        }
        if (bl || pSDELogicBase.getLogicSubType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicsubtype", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getLogicSubType()), (boolean)false);
        }
        if (bl || pSDELogicBase.getLogicTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictag", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getLogicTag()), (boolean)false);
        }
        if (bl || pSDELogicBase.getLogicTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictag2", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getLogicTag2()), (boolean)false);
        }
        if (bl || pSDELogicBase.getLogicTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictag3", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getLogicTag3()), (boolean)false);
        }
        if (bl || pSDELogicBase.getLogicTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictag4", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getLogicTag4()), (boolean)false);
        }
        if (bl || pSDELogicBase.getLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictype", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getLogicType()), (boolean)false);
        }
        if (bl || pSDELogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSDELogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSSysTaskId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskid", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSSysTaskId()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSSysTaskName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskname", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSSysTaskName()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDELogicBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDELogicBase.getScriptEngine() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"scriptengine", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getScriptEngine()), (boolean)false);
        }
        if (bl || pSDELogicBase.getTemplFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templflag", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getTemplFlag()), (boolean)false);
        }
        if (bl || pSDELogicBase.getThreadRunMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"threadrunmode", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getThreadRunMode()), (boolean)false);
        }
        if (bl || pSDELogicBase.getTimerPolicy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timerpolicy", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getTimerPolicy()), (boolean)false);
        }
        if (bl || pSDELogicBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDELogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDELogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDELogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDELogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDELogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDELogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDELogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDELogicBase.getJSONValue((Object)pSDELogicBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDELogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDELogicBase pSDELogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDELogicBase.getCodeName() != null) {
            object = pSDELogicBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getCreateDate() != null) {
            object = pSDELogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELogicBase.getCreateMan() != null) {
            object = pSDELogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getCustomCode() != null) {
            object = pSDELogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getCustomMode() != null) {
            object = pSDELogicBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicBase.getDebugMode() != null) {
            object = pSDELogicBase.getDebugMode();
            xmlNode.setAttribute(FIELD_DEBUGMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicBase.getDefaultMSLogic() != null) {
            object = pSDELogicBase.getDefaultMSLogic();
            xmlNode.setAttribute(FIELD_DEFAULTMSLOGIC, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicBase.getDEFLogicMode() != null) {
            object = pSDELogicBase.getDEFLogicMode();
            xmlNode.setAttribute(FIELD_DEFLOGICMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getDynaModelFlag() != null) {
            object = pSDELogicBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicBase.getEventModel() != null) {
            object = pSDELogicBase.getEventModel();
            xmlNode.setAttribute(FIELD_EVENTMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getEvents() != null) {
            object = pSDELogicBase.getEvents();
            xmlNode.setAttribute(FIELD_EVENTS, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getExtendMode() != null) {
            object = pSDELogicBase.getExtendMode();
            xmlNode.setAttribute(FIELD_EXTENDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicBase.getFinishFlag() != null) {
            object = pSDELogicBase.getFinishFlag();
            xmlNode.setAttribute(FIELD_FINISHFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicBase.getIgnoreException() != null) {
            object = pSDELogicBase.getIgnoreException();
            xmlNode.setAttribute(FIELD_IGNOREEXCEPTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicBase.getLockFlag() != null) {
            object = pSDELogicBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicBase.getLogicHolder() != null) {
            object = pSDELogicBase.getLogicHolder();
            xmlNode.setAttribute(FIELD_LOGICHOLDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicBase.getLogicModel() != null) {
            object = pSDELogicBase.getLogicModel();
            xmlNode.setAttribute(FIELD_LOGICMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getLogicSN() != null) {
            object = pSDELogicBase.getLogicSN();
            xmlNode.setAttribute(FIELD_LOGICSN, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getLogicSubType() != null) {
            object = pSDELogicBase.getLogicSubType();
            xmlNode.setAttribute(FIELD_LOGICSUBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getLogicTag() != null) {
            object = pSDELogicBase.getLogicTag();
            xmlNode.setAttribute(FIELD_LOGICTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getLogicTag2() != null) {
            object = pSDELogicBase.getLogicTag2();
            xmlNode.setAttribute(FIELD_LOGICTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getLogicTag3() != null) {
            object = pSDELogicBase.getLogicTag3();
            xmlNode.setAttribute(FIELD_LOGICTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getLogicTag4() != null) {
            object = pSDELogicBase.getLogicTag4();
            xmlNode.setAttribute(FIELD_LOGICTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getLogicType() != null) {
            object = pSDELogicBase.getLogicType();
            xmlNode.setAttribute(FIELD_LOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getMemo() != null) {
            object = pSDELogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getOrderValue() != null) {
            object = pSDELogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicBase.getPSDEFId() != null) {
            object = pSDELogicBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSDEFName() != null) {
            object = pSDELogicBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSDEId() != null) {
            object = pSDELogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSDELogicId() != null) {
            object = pSDELogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSDELogicName() != null) {
            object = pSDELogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSDEName() != null) {
            object = pSDELogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSDynaInstId() != null) {
            object = pSDELogicBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSModuleId() != null) {
            object = pSDELogicBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSModuleName() != null) {
            object = pSDELogicBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSSysDynaModelId() != null) {
            object = pSDELogicBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSSysDynaModelName() != null) {
            object = pSDELogicBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSSysReqItemId() != null) {
            object = pSDELogicBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSSysReqItemName() != null) {
            object = pSDELogicBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSSysSFPluginId() != null) {
            object = pSDELogicBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSSysSFPluginName() != null) {
            object = pSDELogicBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSSysTaskId() != null) {
            object = pSDELogicBase.getPSSysTaskId();
            xmlNode.setAttribute(FIELD_PSSYSTASKID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSSysTaskName() != null) {
            object = pSDELogicBase.getPSSysTaskName();
            xmlNode.setAttribute(FIELD_PSSYSTASKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSSystemId() != null) {
            object = pSDELogicBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getPSSystemName() != null) {
            object = pSDELogicBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getScriptEngine() != null) {
            object = pSDELogicBase.getScriptEngine();
            xmlNode.setAttribute(FIELD_SCRIPTENGINE, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getTemplFlag() != null) {
            object = pSDELogicBase.getTemplFlag();
            xmlNode.setAttribute(FIELD_TEMPLFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicBase.getThreadRunMode() != null) {
            object = pSDELogicBase.getThreadRunMode();
            xmlNode.setAttribute(FIELD_THREADRUNMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicBase.getTimerPolicy() != null) {
            object = pSDELogicBase.getTimerPolicy();
            xmlNode.setAttribute(FIELD_TIMERPOLICY, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getToDoTask() != null) {
            object = pSDELogicBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getUpdateDate() != null) {
            object = pSDELogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELogicBase.getUpdateMan() != null) {
            object = pSDELogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getUserCat() != null) {
            object = pSDELogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getUserTag() != null) {
            object = pSDELogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getUserTag2() != null) {
            object = pSDELogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getUserTag3() != null) {
            object = pSDELogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicBase.getUserTag4() != null) {
            object = pSDELogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDELogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDELogicBase pSDELogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDELogicBase.isCodeNameDirty() && (bl || pSDELogicBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDELogicBase.getCodeName());
        }
        if (pSDELogicBase.isCreateDateDirty() && (bl || pSDELogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDELogicBase.getCreateDate());
        }
        if (pSDELogicBase.isCreateManDirty() && (bl || pSDELogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDELogicBase.getCreateMan());
        }
        if (pSDELogicBase.isCustomCodeDirty() && (bl || pSDELogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDELogicBase.getCustomCode());
        }
        if (pSDELogicBase.isCustomModeDirty() && (bl || pSDELogicBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDELogicBase.getCustomMode());
        }
        if (pSDELogicBase.isDebugModeDirty() && (bl || pSDELogicBase.getDebugMode() != null)) {
            iDataObject.set(FIELD_DEBUGMODE, (Object)pSDELogicBase.getDebugMode());
        }
        if (pSDELogicBase.isDefaultMSLogicDirty() && (bl || pSDELogicBase.getDefaultMSLogic() != null)) {
            iDataObject.set(FIELD_DEFAULTMSLOGIC, (Object)pSDELogicBase.getDefaultMSLogic());
        }
        if (pSDELogicBase.isDEFLogicModeDirty() && (bl || pSDELogicBase.getDEFLogicMode() != null)) {
            iDataObject.set(FIELD_DEFLOGICMODE, (Object)pSDELogicBase.getDEFLogicMode());
        }
        if (pSDELogicBase.isDynaModelFlagDirty() && (bl || pSDELogicBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDELogicBase.getDynaModelFlag());
        }
        if (pSDELogicBase.isEventModelDirty() && (bl || pSDELogicBase.getEventModel() != null)) {
            iDataObject.set(FIELD_EVENTMODEL, (Object)pSDELogicBase.getEventModel());
        }
        if (pSDELogicBase.isEventsDirty() && (bl || pSDELogicBase.getEvents() != null)) {
            iDataObject.set(FIELD_EVENTS, (Object)pSDELogicBase.getEvents());
        }
        if (pSDELogicBase.isExtendModeDirty() && (bl || pSDELogicBase.getExtendMode() != null)) {
            iDataObject.set(FIELD_EXTENDMODE, (Object)pSDELogicBase.getExtendMode());
        }
        if (pSDELogicBase.isFinishFlagDirty() && (bl || pSDELogicBase.getFinishFlag() != null)) {
            iDataObject.set(FIELD_FINISHFLAG, (Object)pSDELogicBase.getFinishFlag());
        }
        if (pSDELogicBase.isIgnoreExceptionDirty() && (bl || pSDELogicBase.getIgnoreException() != null)) {
            iDataObject.set(FIELD_IGNOREEXCEPTION, (Object)pSDELogicBase.getIgnoreException());
        }
        if (pSDELogicBase.isLockFlagDirty() && (bl || pSDELogicBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDELogicBase.getLockFlag());
        }
        if (pSDELogicBase.isLogicHolderDirty() && (bl || pSDELogicBase.getLogicHolder() != null)) {
            iDataObject.set(FIELD_LOGICHOLDER, (Object)pSDELogicBase.getLogicHolder());
        }
        if (pSDELogicBase.isLogicModelDirty() && (bl || pSDELogicBase.getLogicModel() != null)) {
            iDataObject.set(FIELD_LOGICMODEL, (Object)pSDELogicBase.getLogicModel());
        }
        if (pSDELogicBase.isLogicSNDirty() && (bl || pSDELogicBase.getLogicSN() != null)) {
            iDataObject.set(FIELD_LOGICSN, (Object)pSDELogicBase.getLogicSN());
        }
        if (pSDELogicBase.isLogicSubTypeDirty() && (bl || pSDELogicBase.getLogicSubType() != null)) {
            iDataObject.set(FIELD_LOGICSUBTYPE, (Object)pSDELogicBase.getLogicSubType());
        }
        if (pSDELogicBase.isLogicTagDirty() && (bl || pSDELogicBase.getLogicTag() != null)) {
            iDataObject.set(FIELD_LOGICTAG, (Object)pSDELogicBase.getLogicTag());
        }
        if (pSDELogicBase.isLogicTag2Dirty() && (bl || pSDELogicBase.getLogicTag2() != null)) {
            iDataObject.set(FIELD_LOGICTAG2, (Object)pSDELogicBase.getLogicTag2());
        }
        if (pSDELogicBase.isLogicTag3Dirty() && (bl || pSDELogicBase.getLogicTag3() != null)) {
            iDataObject.set(FIELD_LOGICTAG3, (Object)pSDELogicBase.getLogicTag3());
        }
        if (pSDELogicBase.isLogicTag4Dirty() && (bl || pSDELogicBase.getLogicTag4() != null)) {
            iDataObject.set(FIELD_LOGICTAG4, (Object)pSDELogicBase.getLogicTag4());
        }
        if (pSDELogicBase.isLogicTypeDirty() && (bl || pSDELogicBase.getLogicType() != null)) {
            iDataObject.set(FIELD_LOGICTYPE, (Object)pSDELogicBase.getLogicType());
        }
        if (pSDELogicBase.isMemoDirty() && (bl || pSDELogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDELogicBase.getMemo());
        }
        if (pSDELogicBase.isOrderValueDirty() && (bl || pSDELogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDELogicBase.getOrderValue());
        }
        if (pSDELogicBase.isPSDEFIdDirty() && (bl || pSDELogicBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDELogicBase.getPSDEFId());
        }
        if (pSDELogicBase.isPSDEFNameDirty() && (bl || pSDELogicBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDELogicBase.getPSDEFName());
        }
        if (pSDELogicBase.isPSDEIdDirty() && (bl || pSDELogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDELogicBase.getPSDEId());
        }
        if (pSDELogicBase.isPSDELogicIdDirty() && (bl || pSDELogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDELogicBase.getPSDELogicId());
        }
        if (pSDELogicBase.isPSDELogicNameDirty() && (bl || pSDELogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDELogicBase.getPSDELogicName());
        }
        if (pSDELogicBase.isPSDENameDirty() && (bl || pSDELogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDELogicBase.getPSDEName());
        }
        if (pSDELogicBase.isPSDynaInstIdDirty() && (bl || pSDELogicBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDELogicBase.getPSDynaInstId());
        }
        if (pSDELogicBase.isPSModuleIdDirty() && (bl || pSDELogicBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSDELogicBase.getPSModuleId());
        }
        if (pSDELogicBase.isPSModuleNameDirty() && (bl || pSDELogicBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSDELogicBase.getPSModuleName());
        }
        if (pSDELogicBase.isPSSysDynaModelIdDirty() && (bl || pSDELogicBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDELogicBase.getPSSysDynaModelId());
        }
        if (pSDELogicBase.isPSSysDynaModelNameDirty() && (bl || pSDELogicBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDELogicBase.getPSSysDynaModelName());
        }
        if (pSDELogicBase.isPSSysReqItemIdDirty() && (bl || pSDELogicBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDELogicBase.getPSSysReqItemId());
        }
        if (pSDELogicBase.isPSSysReqItemNameDirty() && (bl || pSDELogicBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDELogicBase.getPSSysReqItemName());
        }
        if (pSDELogicBase.isPSSysSFPluginIdDirty() && (bl || pSDELogicBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDELogicBase.getPSSysSFPluginId());
        }
        if (pSDELogicBase.isPSSysSFPluginNameDirty() && (bl || pSDELogicBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDELogicBase.getPSSysSFPluginName());
        }
        if (pSDELogicBase.isPSSysTaskIdDirty() && (bl || pSDELogicBase.getPSSysTaskId() != null)) {
            iDataObject.set(FIELD_PSSYSTASKID, (Object)pSDELogicBase.getPSSysTaskId());
        }
        if (pSDELogicBase.isPSSysTaskNameDirty() && (bl || pSDELogicBase.getPSSysTaskName() != null)) {
            iDataObject.set(FIELD_PSSYSTASKNAME, (Object)pSDELogicBase.getPSSysTaskName());
        }
        if (pSDELogicBase.isPSSystemIdDirty() && (bl || pSDELogicBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDELogicBase.getPSSystemId());
        }
        if (pSDELogicBase.isPSSystemNameDirty() && (bl || pSDELogicBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDELogicBase.getPSSystemName());
        }
        if (pSDELogicBase.isScriptEngineDirty() && (bl || pSDELogicBase.getScriptEngine() != null)) {
            iDataObject.set(FIELD_SCRIPTENGINE, (Object)pSDELogicBase.getScriptEngine());
        }
        if (pSDELogicBase.isTemplFlagDirty() && (bl || pSDELogicBase.getTemplFlag() != null)) {
            iDataObject.set(FIELD_TEMPLFLAG, (Object)pSDELogicBase.getTemplFlag());
        }
        if (pSDELogicBase.isThreadRunModeDirty() && (bl || pSDELogicBase.getThreadRunMode() != null)) {
            iDataObject.set(FIELD_THREADRUNMODE, (Object)pSDELogicBase.getThreadRunMode());
        }
        if (pSDELogicBase.isTimerPolicyDirty() && (bl || pSDELogicBase.getTimerPolicy() != null)) {
            iDataObject.set(FIELD_TIMERPOLICY, (Object)pSDELogicBase.getTimerPolicy());
        }
        if (pSDELogicBase.isToDoTaskDirty() && (bl || pSDELogicBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDELogicBase.getToDoTask());
        }
        if (pSDELogicBase.isUpdateDateDirty() && (bl || pSDELogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDELogicBase.getUpdateDate());
        }
        if (pSDELogicBase.isUpdateManDirty() && (bl || pSDELogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDELogicBase.getUpdateMan());
        }
        if (pSDELogicBase.isUserCatDirty() && (bl || pSDELogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDELogicBase.getUserCat());
        }
        if (pSDELogicBase.isUserTagDirty() && (bl || pSDELogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDELogicBase.getUserTag());
        }
        if (pSDELogicBase.isUserTag2Dirty() && (bl || pSDELogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDELogicBase.getUserTag2());
        }
        if (pSDELogicBase.isUserTag3Dirty() && (bl || pSDELogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDELogicBase.getUserTag3());
        }
        if (pSDELogicBase.isUserTag4Dirty() && (bl || pSDELogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDELogicBase.getUserTag4());
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
        return PSDELogicBase.remove(this, n);
    }

    private static boolean remove(PSDELogicBase pSDELogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDELogicBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDELogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDELogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDELogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSDELogicBase.resetCustomMode();
                return true;
            }
            case 5: {
                pSDELogicBase.resetDebugMode();
                return true;
            }
            case 6: {
                pSDELogicBase.resetDefaultMSLogic();
                return true;
            }
            case 7: {
                pSDELogicBase.resetDEFLogicMode();
                return true;
            }
            case 8: {
                pSDELogicBase.resetDynaModelFlag();
                return true;
            }
            case 9: {
                pSDELogicBase.resetEventModel();
                return true;
            }
            case 10: {
                pSDELogicBase.resetEvents();
                return true;
            }
            case 11: {
                pSDELogicBase.resetExtendMode();
                return true;
            }
            case 12: {
                pSDELogicBase.resetFinishFlag();
                return true;
            }
            case 13: {
                pSDELogicBase.resetIgnoreException();
                return true;
            }
            case 14: {
                pSDELogicBase.resetLockFlag();
                return true;
            }
            case 15: {
                pSDELogicBase.resetLogicHolder();
                return true;
            }
            case 16: {
                pSDELogicBase.resetLogicModel();
                return true;
            }
            case 17: {
                pSDELogicBase.resetLogicSN();
                return true;
            }
            case 18: {
                pSDELogicBase.resetLogicSubType();
                return true;
            }
            case 19: {
                pSDELogicBase.resetLogicTag();
                return true;
            }
            case 20: {
                pSDELogicBase.resetLogicTag2();
                return true;
            }
            case 21: {
                pSDELogicBase.resetLogicTag3();
                return true;
            }
            case 22: {
                pSDELogicBase.resetLogicTag4();
                return true;
            }
            case 23: {
                pSDELogicBase.resetLogicType();
                return true;
            }
            case 24: {
                pSDELogicBase.resetMemo();
                return true;
            }
            case 25: {
                pSDELogicBase.resetOrderValue();
                return true;
            }
            case 26: {
                pSDELogicBase.resetPSDEFId();
                return true;
            }
            case 27: {
                pSDELogicBase.resetPSDEFName();
                return true;
            }
            case 28: {
                pSDELogicBase.resetPSDEId();
                return true;
            }
            case 29: {
                pSDELogicBase.resetPSDELogicId();
                return true;
            }
            case 30: {
                pSDELogicBase.resetPSDELogicName();
                return true;
            }
            case 31: {
                pSDELogicBase.resetPSDEName();
                return true;
            }
            case 32: {
                pSDELogicBase.resetPSDynaInstId();
                return true;
            }
            case 33: {
                pSDELogicBase.resetPSModuleId();
                return true;
            }
            case 34: {
                pSDELogicBase.resetPSModuleName();
                return true;
            }
            case 35: {
                pSDELogicBase.resetPSSysDynaModelId();
                return true;
            }
            case 36: {
                pSDELogicBase.resetPSSysDynaModelName();
                return true;
            }
            case 37: {
                pSDELogicBase.resetPSSysReqItemId();
                return true;
            }
            case 38: {
                pSDELogicBase.resetPSSysReqItemName();
                return true;
            }
            case 39: {
                pSDELogicBase.resetPSSysSFPluginId();
                return true;
            }
            case 40: {
                pSDELogicBase.resetPSSysSFPluginName();
                return true;
            }
            case 41: {
                pSDELogicBase.resetPSSysTaskId();
                return true;
            }
            case 42: {
                pSDELogicBase.resetPSSysTaskName();
                return true;
            }
            case 43: {
                pSDELogicBase.resetPSSystemId();
                return true;
            }
            case 44: {
                pSDELogicBase.resetPSSystemName();
                return true;
            }
            case 45: {
                pSDELogicBase.resetScriptEngine();
                return true;
            }
            case 46: {
                pSDELogicBase.resetTemplFlag();
                return true;
            }
            case 47: {
                pSDELogicBase.resetThreadRunMode();
                return true;
            }
            case 48: {
                pSDELogicBase.resetTimerPolicy();
                return true;
            }
            case 49: {
                pSDELogicBase.resetToDoTask();
                return true;
            }
            case 50: {
                pSDELogicBase.resetUpdateDate();
                return true;
            }
            case 51: {
                pSDELogicBase.resetUpdateMan();
                return true;
            }
            case 52: {
                pSDELogicBase.resetUserCat();
                return true;
            }
            case 53: {
                pSDELogicBase.resetUserTag();
                return true;
            }
            case 54: {
                pSDELogicBase.resetUserTag2();
                return true;
            }
            case 55: {
                pSDELogicBase.resetUserTag3();
                return true;
            }
            case 56: {
                pSDELogicBase.resetUserTag4();
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
                pSDEFieldService.autoGet(pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
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
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
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
    public PSSysTask getPSSysTask() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTask();
        }
        if (this.getPSSysTaskId() == null) {
            return null;
        }
        Integer n = this.objPSSysTaskLock;
        synchronized (n) {
            if (this.pssystask != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTaskId(), (Object)this.pssystask.getPSSysTaskId()) != 0L) {
                this.pssystask = null;
            }
            if (this.pssystask == null) {
                PSSysTask pSSysTask = new PSSysTask();
                pSSysTask.setPSSysTaskId(this.getPSSysTaskId());
                PSSysTaskService pSSysTaskService = (PSSysTaskService)ServiceGlobal.getService(PSSysTaskService.class, (SessionFactory)this.getSessionFactory());
                pSSysTaskService.autoGet(pSSysTask);
                this.pssystask = pSSysTask;
            }
            return this.pssystask;
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
    public ArrayList<PSDELogicLink> getPSDELogicLinks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicLinks();
        }
        if (this.getPSDELogicId() == null) {
            return null;
        }
        PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
        PSDELogicLinkService pSDELogicLinkService = (PSDELogicLinkService)ServiceGlobal.getService(PSDELogicLinkService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDELogicLinksLock;
        synchronized (n) {
            if (this.psdelogiclinks == null) {
                this.psdelogiclinks = pSDELogicService.isTempData(this) ? pSDELogicLinkService.selectTempByPSDELogic(this) : pSDELogicLinkService.selectByPSDELogic(this);
            }
            return this.psdelogiclinks;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDELogicNode> getPSDELogicNodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicNodes();
        }
        if (this.getPSDELogicId() == null) {
            return null;
        }
        PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
        PSDELogicNodeService pSDELogicNodeService = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDELogicNodesLock;
        synchronized (n) {
            if (this.psdelogicnodes == null) {
                this.psdelogicnodes = pSDELogicService.isTempData(this) ? pSDELogicNodeService.selectTempByPSDELogic(this) : pSDELogicNodeService.selectByPSDELogic(this);
            }
            return this.psdelogicnodes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDELogicParam> getPSDELogicParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicParams();
        }
        if (this.getPSDELogicId() == null) {
            return null;
        }
        PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
        PSDELogicParamService pSDELogicParamService = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDELogicParamsLock;
        synchronized (n) {
            if (this.psdelogicparams == null) {
                this.psdelogicparams = pSDELogicService.isTempData(this) ? pSDELogicParamService.selectTempByPSDELogic(this) : pSDELogicParamService.selectByPSDELogic(this);
            }
            return this.psdelogicparams;
        }
    }

    private PSDELogicBase getProxyEntity() {
        return this.proxyPSDELogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDELogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSDELogicBase) {
            this.proxyPSDELogicBase = (PSDELogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 3);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 4);
        fieldIndexMap.put(FIELD_DEBUGMODE, 5);
        fieldIndexMap.put(FIELD_DEFAULTMSLOGIC, 6);
        fieldIndexMap.put(FIELD_DEFLOGICMODE, 7);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 8);
        fieldIndexMap.put(FIELD_EVENTMODEL, 9);
        fieldIndexMap.put(FIELD_EVENTS, 10);
        fieldIndexMap.put(FIELD_EXTENDMODE, 11);
        fieldIndexMap.put(FIELD_FINISHFLAG, 12);
        fieldIndexMap.put(FIELD_IGNOREEXCEPTION, 13);
        fieldIndexMap.put(FIELD_LOCKFLAG, 14);
        fieldIndexMap.put(FIELD_LOGICHOLDER, 15);
        fieldIndexMap.put(FIELD_LOGICMODEL, 16);
        fieldIndexMap.put(FIELD_LOGICSN, 17);
        fieldIndexMap.put(FIELD_LOGICSUBTYPE, 18);
        fieldIndexMap.put(FIELD_LOGICTAG, 19);
        fieldIndexMap.put(FIELD_LOGICTAG2, 20);
        fieldIndexMap.put(FIELD_LOGICTAG3, 21);
        fieldIndexMap.put(FIELD_LOGICTAG4, 22);
        fieldIndexMap.put(FIELD_LOGICTYPE, 23);
        fieldIndexMap.put(FIELD_MEMO, 24);
        fieldIndexMap.put(FIELD_ORDERVALUE, 25);
        fieldIndexMap.put(FIELD_PSDEFID, 26);
        fieldIndexMap.put(FIELD_PSDEFNAME, 27);
        fieldIndexMap.put(FIELD_PSDEID, 28);
        fieldIndexMap.put(FIELD_PSDELOGICID, 29);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 30);
        fieldIndexMap.put(FIELD_PSDENAME, 31);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 32);
        fieldIndexMap.put(FIELD_PSMODULEID, 33);
        fieldIndexMap.put(FIELD_PSMODULENAME, 34);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 35);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 36);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 37);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 38);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 39);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 40);
        fieldIndexMap.put(FIELD_PSSYSTASKID, 41);
        fieldIndexMap.put(FIELD_PSSYSTASKNAME, 42);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 43);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 44);
        fieldIndexMap.put(FIELD_SCRIPTENGINE, 45);
        fieldIndexMap.put(FIELD_TEMPLFLAG, 46);
        fieldIndexMap.put(FIELD_THREADRUNMODE, 47);
        fieldIndexMap.put(FIELD_TIMERPOLICY, 48);
        fieldIndexMap.put(FIELD_TODOTASK, 49);
        fieldIndexMap.put(FIELD_UPDATEDATE, 50);
        fieldIndexMap.put(FIELD_UPDATEMAN, 51);
        fieldIndexMap.put(FIELD_USERCAT, 52);
        fieldIndexMap.put(FIELD_USERTAG, 53);
        fieldIndexMap.put(FIELD_USERTAG2, 54);
        fieldIndexMap.put(FIELD_USERTAG3, 55);
        fieldIndexMap.put(FIELD_USERTAG4, 56);
    }
}

