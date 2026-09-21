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
import net.ibizsys.pscore.srv.config.entity.PSBackService;
import net.ibizsys.pscore.srv.config.service.PSBackServiceService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBackServiceBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBackServiceBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTAINERTAG = "CONTAINERTAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PSBACKSERVICEID = "PSBACKSERVICEID";
    public static final String FIELD_PSBACKSERVICENAME = "PSBACKSERVICENAME";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEDSID = "PSDEDSID";
    public static final String FIELD_PSDEDSNAME = "PSDEDSNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSBACKSERVICEID = "PSSYSBACKSERVICEID";
    public static final String FIELD_PSSYSBACKSERVICENAME = "PSSYSBACKSERVICENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUTILDEID = "PSSYSUTILDEID";
    public static final String FIELD_PSSYSUTILDENAME = "PSSYSUTILDENAME";
    public static final String FIELD_RUNORDER = "RUNORDER";
    public static final String FIELD_SERVICECONTAINER = "SERVICECONTAINER";
    public static final String FIELD_SERVICEOBJ = "SERVICEOBJ";
    public static final String FIELD_SERVICEPARAMS = "SERVICEPARAMS";
    public static final String FIELD_SERVICEPOLICY = "SERVICEPOLICY";
    public static final String FIELD_SERVICEPOLICY2 = "SERVICEPOLICY2";
    public static final String FIELD_SERVICETAG = "SERVICETAG";
    public static final String FIELD_SERVICETAG2 = "SERVICETAG2";
    public static final String FIELD_STARTMODE = "STARTMODE";
    public static final String FIELD_TASKTYPE = "TASKTYPE";
    public static final String FIELD_TIMERMODE = "TIMERMODE";
    public static final String FIELD_TIMERPOLICY = "TIMERPOLICY";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CONTAINERTAG = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_CUSTOMCODE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PREDEFINEDTYPE = 6;
    private static final int INDEX_PSBACKSERVICEID = 7;
    private static final int INDEX_PSBACKSERVICENAME = 8;
    private static final int INDEX_PSDEACTIONID = 9;
    private static final int INDEX_PSDEACTIONNAME = 10;
    private static final int INDEX_PSDEDSID = 11;
    private static final int INDEX_PSDEDSNAME = 12;
    private static final int INDEX_PSDEID = 13;
    private static final int INDEX_PSDENAME = 14;
    private static final int INDEX_PSMODULEID = 15;
    private static final int INDEX_PSMODULENAME = 16;
    private static final int INDEX_PSSYSBACKSERVICEID = 17;
    private static final int INDEX_PSSYSBACKSERVICENAME = 18;
    private static final int INDEX_PSSYSDYNAMODELID = 19;
    private static final int INDEX_PSSYSDYNAMODELNAME = 20;
    private static final int INDEX_PSSYSSFPLUGINID = 21;
    private static final int INDEX_PSSYSSFPLUGINNAME = 22;
    private static final int INDEX_PSSYSTEMID = 23;
    private static final int INDEX_PSSYSTEMNAME = 24;
    private static final int INDEX_PSSYSUTILDEID = 25;
    private static final int INDEX_PSSYSUTILDENAME = 26;
    private static final int INDEX_RUNORDER = 27;
    private static final int INDEX_SERVICECONTAINER = 28;
    private static final int INDEX_SERVICEOBJ = 29;
    private static final int INDEX_SERVICEPARAMS = 30;
    private static final int INDEX_SERVICEPOLICY = 31;
    private static final int INDEX_SERVICEPOLICY2 = 32;
    private static final int INDEX_SERVICETAG = 33;
    private static final int INDEX_SERVICETAG2 = 34;
    private static final int INDEX_STARTMODE = 35;
    private static final int INDEX_TASKTYPE = 36;
    private static final int INDEX_TIMERMODE = 37;
    private static final int INDEX_TIMERPOLICY = 38;
    private static final int INDEX_UPDATEDATE = 39;
    private static final int INDEX_UPDATEMAN = 40;
    private static final int INDEX_USERCAT = 41;
    private static final int INDEX_USERPARAMS = 42;
    private static final int INDEX_USERTAG = 43;
    private static final int INDEX_USERTAG2 = 44;
    private static final int INDEX_USERTAG3 = 45;
    private static final int INDEX_USERTAG4 = 46;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBackServiceBase proxyPSSysBackServiceBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean containertagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean psbackserviceidDirtyFlag = false;
    private boolean psbackservicenameDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdedsidDirtyFlag = false;
    private boolean psdedsnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysbackserviceidDirtyFlag = false;
    private boolean pssysbackservicenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysutildeidDirtyFlag = false;
    private boolean pssysutildenameDirtyFlag = false;
    private boolean runorderDirtyFlag = false;
    private boolean servicecontainerDirtyFlag = false;
    private boolean serviceobjDirtyFlag = false;
    private boolean serviceparamsDirtyFlag = false;
    private boolean servicepolicyDirtyFlag = false;
    private boolean servicepolicy2DirtyFlag = false;
    private boolean servicetagDirtyFlag = false;
    private boolean servicetag2DirtyFlag = false;
    private boolean startmodeDirtyFlag = false;
    private boolean tasktypeDirtyFlag = false;
    private boolean timermodeDirtyFlag = false;
    private boolean timerpolicyDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="containertag")
    private String containertag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="memo")
    private String memo;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="psbackserviceid")
    private String psbackserviceid;
    @Column(name="psbackservicename")
    private String psbackservicename;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdedsid")
    private String psdedsid;
    @Column(name="psdedsname")
    private String psdedsname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysbackserviceid")
    private String pssysbackserviceid;
    @Column(name="pssysbackservicename")
    private String pssysbackservicename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysutildeid")
    private String pssysutildeid;
    @Column(name="pssysutildename")
    private String pssysutildename;
    @Column(name="runorder")
    private Integer runorder;
    @Column(name="servicecontainer")
    private String servicecontainer;
    @Column(name="serviceobj")
    private String serviceobj;
    @Column(name="serviceparams")
    private String serviceparams;
    @Column(name="servicepolicy")
    private String servicepolicy;
    @Column(name="servicepolicy2")
    private String servicepolicy2;
    @Column(name="servicetag")
    private String servicetag;
    @Column(name="servicetag2")
    private String servicetag2;
    @Column(name="startmode")
    private String startmode;
    @Column(name="tasktype")
    private String tasktype;
    @Column(name="timermode")
    private Integer timermode;
    @Column(name="timerpolicy")
    private String timerpolicy;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSBackServiceLock = new Integer(1);
    private PSBackService psbackservice = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objPSDEDSLock = new Integer(1);
    private PSDEDataSet psdeds = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUtilDELock = new Integer(1);
    private PSSysUtilDE pssysutilde = null;

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

    public void setContainerTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContainerTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.containertag = string;
        this.containertagDirtyFlag = true;
    }

    public String getContainerTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContainerTag();
        }
        return this.containertag;
    }

    public boolean isContainerTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContainerTagDirty();
        }
        return this.containertagDirtyFlag;
    }

    public void resetContainerTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContainerTag();
            return;
        }
        this.containertagDirtyFlag = false;
        this.containertag = null;
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

    public void setPredefinedType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtype = string;
        this.predefinedtypeDirtyFlag = true;
    }

    public String getPredefinedType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedType();
        }
        return this.predefinedtype;
    }

    public boolean isPredefinedTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeDirty();
        }
        return this.predefinedtypeDirtyFlag;
    }

    public void resetPredefinedType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedType();
            return;
        }
        this.predefinedtypeDirtyFlag = false;
        this.predefinedtype = null;
    }

    public void setPSBackServiceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBackServiceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbackserviceid = string;
        this.psbackserviceidDirtyFlag = true;
    }

    public String getPSBackServiceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBackServiceId();
        }
        return this.psbackserviceid;
    }

    public boolean isPSBackServiceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBackServiceIdDirty();
        }
        return this.psbackserviceidDirtyFlag;
    }

    public void resetPSBackServiceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBackServiceId();
            return;
        }
        this.psbackserviceidDirtyFlag = false;
        this.psbackserviceid = null;
    }

    public void setPSBackServiceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBackServiceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbackservicename = string;
        this.psbackservicenameDirtyFlag = true;
    }

    public String getPSBackServiceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBackServiceName();
        }
        return this.psbackservicename;
    }

    public boolean isPSBackServiceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBackServiceNameDirty();
        }
        return this.psbackservicenameDirtyFlag;
    }

    public void resetPSBackServiceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBackServiceName();
            return;
        }
        this.psbackservicenameDirtyFlag = false;
        this.psbackservicename = null;
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

    public void setPSSysBackServiceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBackServiceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbackserviceid = string;
        this.pssysbackserviceidDirtyFlag = true;
    }

    public String getPSSysBackServiceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBackServiceId();
        }
        return this.pssysbackserviceid;
    }

    public boolean isPSSysBackServiceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBackServiceIdDirty();
        }
        return this.pssysbackserviceidDirtyFlag;
    }

    public void resetPSSysBackServiceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBackServiceId();
            return;
        }
        this.pssysbackserviceidDirtyFlag = false;
        this.pssysbackserviceid = null;
    }

    public void setPSSysBackServiceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBackServiceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbackservicename = string;
        this.pssysbackservicenameDirtyFlag = true;
    }

    public String getPSSysBackServiceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBackServiceName();
        }
        return this.pssysbackservicename;
    }

    public boolean isPSSysBackServiceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBackServiceNameDirty();
        }
        return this.pssysbackservicenameDirtyFlag;
    }

    public void resetPSSysBackServiceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBackServiceName();
            return;
        }
        this.pssysbackservicenameDirtyFlag = false;
        this.pssysbackservicename = null;
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

    public void setPSSysUtilDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUtilDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysutildeid = string;
        this.pssysutildeidDirtyFlag = true;
    }

    public String getPSSysUtilDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDEId();
        }
        return this.pssysutildeid;
    }

    public boolean isPSSysUtilDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUtilDEIdDirty();
        }
        return this.pssysutildeidDirtyFlag;
    }

    public void resetPSSysUtilDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUtilDEId();
            return;
        }
        this.pssysutildeidDirtyFlag = false;
        this.pssysutildeid = null;
    }

    public void setPSSysUtilDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUtilDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysutildename = string;
        this.pssysutildenameDirtyFlag = true;
    }

    public String getPSSysUtilDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDEName();
        }
        return this.pssysutildename;
    }

    public boolean isPSSysUtilDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUtilDENameDirty();
        }
        return this.pssysutildenameDirtyFlag;
    }

    public void resetPSSysUtilDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUtilDEName();
            return;
        }
        this.pssysutildenameDirtyFlag = false;
        this.pssysutildename = null;
    }

    public void setRunOrder(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunOrder(n);
            return;
        }
        this.runorder = n;
        this.runorderDirtyFlag = true;
    }

    public Integer getRunOrder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunOrder();
        }
        return this.runorder;
    }

    public boolean isRunOrderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunOrderDirty();
        }
        return this.runorderDirtyFlag;
    }

    public void resetRunOrder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunOrder();
            return;
        }
        this.runorderDirtyFlag = false;
        this.runorder = null;
    }

    public void setServiceContainer(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceContainer(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicecontainer = string;
        this.servicecontainerDirtyFlag = true;
    }

    public String getServiceContainer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceContainer();
        }
        return this.servicecontainer;
    }

    public boolean isServiceContainerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceContainerDirty();
        }
        return this.servicecontainerDirtyFlag;
    }

    public void resetServiceContainer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceContainer();
            return;
        }
        this.servicecontainerDirtyFlag = false;
        this.servicecontainer = null;
    }

    public void setServiceObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceobj = string;
        this.serviceobjDirtyFlag = true;
    }

    public String getServiceObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceObj();
        }
        return this.serviceobj;
    }

    public boolean isServiceObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceObjDirty();
        }
        return this.serviceobjDirtyFlag;
    }

    public void resetServiceObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceObj();
            return;
        }
        this.serviceobjDirtyFlag = false;
        this.serviceobj = null;
    }

    public void setServiceParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceparams = string;
        this.serviceparamsDirtyFlag = true;
    }

    public String getServiceParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceParams();
        }
        return this.serviceparams;
    }

    public boolean isServiceParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceParamsDirty();
        }
        return this.serviceparamsDirtyFlag;
    }

    public void resetServiceParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceParams();
            return;
        }
        this.serviceparamsDirtyFlag = false;
        this.serviceparams = null;
    }

    public void setServicePolicy(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServicePolicy(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicepolicy = string;
        this.servicepolicyDirtyFlag = true;
    }

    public String getServicePolicy() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServicePolicy();
        }
        return this.servicepolicy;
    }

    public boolean isServicePolicyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServicePolicyDirty();
        }
        return this.servicepolicyDirtyFlag;
    }

    public void resetServicePolicy() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServicePolicy();
            return;
        }
        this.servicepolicyDirtyFlag = false;
        this.servicepolicy = null;
    }

    public void setServicePolicy2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServicePolicy2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicepolicy2 = string;
        this.servicepolicy2DirtyFlag = true;
    }

    public String getServicePolicy2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServicePolicy2();
        }
        return this.servicepolicy2;
    }

    public boolean isServicePolicy2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServicePolicy2Dirty();
        }
        return this.servicepolicy2DirtyFlag;
    }

    public void resetServicePolicy2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServicePolicy2();
            return;
        }
        this.servicepolicy2DirtyFlag = false;
        this.servicepolicy2 = null;
    }

    public void setServiceTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicetag = string;
        this.servicetagDirtyFlag = true;
    }

    public String getServiceTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceTag();
        }
        return this.servicetag;
    }

    public boolean isServiceTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceTagDirty();
        }
        return this.servicetagDirtyFlag;
    }

    public void resetServiceTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceTag();
            return;
        }
        this.servicetagDirtyFlag = false;
        this.servicetag = null;
    }

    public void setServiceTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicetag2 = string;
        this.servicetag2DirtyFlag = true;
    }

    public String getServiceTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceTag2();
        }
        return this.servicetag2;
    }

    public boolean isServiceTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceTag2Dirty();
        }
        return this.servicetag2DirtyFlag;
    }

    public void resetServiceTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceTag2();
            return;
        }
        this.servicetag2DirtyFlag = false;
        this.servicetag2 = null;
    }

    public void setStartMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.startmode = string;
        this.startmodeDirtyFlag = true;
    }

    public String getStartMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartMode();
        }
        return this.startmode;
    }

    public boolean isStartModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartModeDirty();
        }
        return this.startmodeDirtyFlag;
    }

    public void resetStartMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartMode();
            return;
        }
        this.startmodeDirtyFlag = false;
        this.startmode = null;
    }

    public void setTaskType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tasktype = string;
        this.tasktypeDirtyFlag = true;
    }

    public String getTaskType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskType();
        }
        return this.tasktype;
    }

    public boolean isTaskTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskTypeDirty();
        }
        return this.tasktypeDirtyFlag;
    }

    public void resetTaskType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskType();
            return;
        }
        this.tasktypeDirtyFlag = false;
        this.tasktype = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
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
        PSSysBackServiceBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBackServiceBase pSSysBackServiceBase) {
        pSSysBackServiceBase.resetCodeName();
        pSSysBackServiceBase.resetContainerTag();
        pSSysBackServiceBase.resetCreateDate();
        pSSysBackServiceBase.resetCreateMan();
        pSSysBackServiceBase.resetCustomCode();
        pSSysBackServiceBase.resetMemo();
        pSSysBackServiceBase.resetPredefinedType();
        pSSysBackServiceBase.resetPSBackServiceId();
        pSSysBackServiceBase.resetPSBackServiceName();
        pSSysBackServiceBase.resetPSDEActionId();
        pSSysBackServiceBase.resetPSDEActionName();
        pSSysBackServiceBase.resetPSDEDSId();
        pSSysBackServiceBase.resetPSDEDSName();
        pSSysBackServiceBase.resetPSDEId();
        pSSysBackServiceBase.resetPSDEName();
        pSSysBackServiceBase.resetPSModuleId();
        pSSysBackServiceBase.resetPSModuleName();
        pSSysBackServiceBase.resetPSSysBackServiceId();
        pSSysBackServiceBase.resetPSSysBackServiceName();
        pSSysBackServiceBase.resetPSSysDynaModelId();
        pSSysBackServiceBase.resetPSSysDynaModelName();
        pSSysBackServiceBase.resetPSSysSFPluginId();
        pSSysBackServiceBase.resetPSSysSFPluginName();
        pSSysBackServiceBase.resetPSSystemId();
        pSSysBackServiceBase.resetPSSystemName();
        pSSysBackServiceBase.resetPSSysUtilDEId();
        pSSysBackServiceBase.resetPSSysUtilDEName();
        pSSysBackServiceBase.resetRunOrder();
        pSSysBackServiceBase.resetServiceContainer();
        pSSysBackServiceBase.resetServiceObj();
        pSSysBackServiceBase.resetServiceParams();
        pSSysBackServiceBase.resetServicePolicy();
        pSSysBackServiceBase.resetServicePolicy2();
        pSSysBackServiceBase.resetServiceTag();
        pSSysBackServiceBase.resetServiceTag2();
        pSSysBackServiceBase.resetStartMode();
        pSSysBackServiceBase.resetTaskType();
        pSSysBackServiceBase.resetTimerMode();
        pSSysBackServiceBase.resetTimerPolicy();
        pSSysBackServiceBase.resetUpdateDate();
        pSSysBackServiceBase.resetUpdateMan();
        pSSysBackServiceBase.resetUserCat();
        pSSysBackServiceBase.resetUserParams();
        pSSysBackServiceBase.resetUserTag();
        pSSysBackServiceBase.resetUserTag2();
        pSSysBackServiceBase.resetUserTag3();
        pSSysBackServiceBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContainerTagDirty()) {
            hashMap.put(FIELD_CONTAINERTAG, this.getContainerTag());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPSBackServiceIdDirty()) {
            hashMap.put(FIELD_PSBACKSERVICEID, this.getPSBackServiceId());
        }
        if (!bl || this.isPSBackServiceNameDirty()) {
            hashMap.put(FIELD_PSBACKSERVICENAME, this.getPSBackServiceName());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
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
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysBackServiceIdDirty()) {
            hashMap.put(FIELD_PSSYSBACKSERVICEID, this.getPSSysBackServiceId());
        }
        if (!bl || this.isPSSysBackServiceNameDirty()) {
            hashMap.put(FIELD_PSSYSBACKSERVICENAME, this.getPSSysBackServiceName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
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
        if (!bl || this.isPSSysUtilDEIdDirty()) {
            hashMap.put(FIELD_PSSYSUTILDEID, this.getPSSysUtilDEId());
        }
        if (!bl || this.isPSSysUtilDENameDirty()) {
            hashMap.put(FIELD_PSSYSUTILDENAME, this.getPSSysUtilDEName());
        }
        if (!bl || this.isRunOrderDirty()) {
            hashMap.put(FIELD_RUNORDER, this.getRunOrder());
        }
        if (!bl || this.isServiceContainerDirty()) {
            hashMap.put(FIELD_SERVICECONTAINER, this.getServiceContainer());
        }
        if (!bl || this.isServiceObjDirty()) {
            hashMap.put(FIELD_SERVICEOBJ, this.getServiceObj());
        }
        if (!bl || this.isServiceParamsDirty()) {
            hashMap.put(FIELD_SERVICEPARAMS, this.getServiceParams());
        }
        if (!bl || this.isServicePolicyDirty()) {
            hashMap.put(FIELD_SERVICEPOLICY, this.getServicePolicy());
        }
        if (!bl || this.isServicePolicy2Dirty()) {
            hashMap.put(FIELD_SERVICEPOLICY2, this.getServicePolicy2());
        }
        if (!bl || this.isServiceTagDirty()) {
            hashMap.put(FIELD_SERVICETAG, this.getServiceTag());
        }
        if (!bl || this.isServiceTag2Dirty()) {
            hashMap.put(FIELD_SERVICETAG2, this.getServiceTag2());
        }
        if (!bl || this.isStartModeDirty()) {
            hashMap.put(FIELD_STARTMODE, this.getStartMode());
        }
        if (!bl || this.isTaskTypeDirty()) {
            hashMap.put(FIELD_TASKTYPE, this.getTaskType());
        }
        if (!bl || this.isTimerModeDirty()) {
            hashMap.put(FIELD_TIMERMODE, this.getTimerMode());
        }
        if (!bl || this.isTimerPolicyDirty()) {
            hashMap.put(FIELD_TIMERPOLICY, this.getTimerPolicy());
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
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSSysBackServiceBase.get(this, n);
    }

    private static Object get(PSSysBackServiceBase pSSysBackServiceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBackServiceBase.getCodeName();
            }
            case 1: {
                return pSSysBackServiceBase.getContainerTag();
            }
            case 2: {
                return pSSysBackServiceBase.getCreateDate();
            }
            case 3: {
                return pSSysBackServiceBase.getCreateMan();
            }
            case 4: {
                return pSSysBackServiceBase.getCustomCode();
            }
            case 5: {
                return pSSysBackServiceBase.getMemo();
            }
            case 6: {
                return pSSysBackServiceBase.getPredefinedType();
            }
            case 7: {
                return pSSysBackServiceBase.getPSBackServiceId();
            }
            case 8: {
                return pSSysBackServiceBase.getPSBackServiceName();
            }
            case 9: {
                return pSSysBackServiceBase.getPSDEActionId();
            }
            case 10: {
                return pSSysBackServiceBase.getPSDEActionName();
            }
            case 11: {
                return pSSysBackServiceBase.getPSDEDSId();
            }
            case 12: {
                return pSSysBackServiceBase.getPSDEDSName();
            }
            case 13: {
                return pSSysBackServiceBase.getPSDEId();
            }
            case 14: {
                return pSSysBackServiceBase.getPSDEName();
            }
            case 15: {
                return pSSysBackServiceBase.getPSModuleId();
            }
            case 16: {
                return pSSysBackServiceBase.getPSModuleName();
            }
            case 17: {
                return pSSysBackServiceBase.getPSSysBackServiceId();
            }
            case 18: {
                return pSSysBackServiceBase.getPSSysBackServiceName();
            }
            case 19: {
                return pSSysBackServiceBase.getPSSysDynaModelId();
            }
            case 20: {
                return pSSysBackServiceBase.getPSSysDynaModelName();
            }
            case 21: {
                return pSSysBackServiceBase.getPSSysSFPluginId();
            }
            case 22: {
                return pSSysBackServiceBase.getPSSysSFPluginName();
            }
            case 23: {
                return pSSysBackServiceBase.getPSSystemId();
            }
            case 24: {
                return pSSysBackServiceBase.getPSSystemName();
            }
            case 25: {
                return pSSysBackServiceBase.getPSSysUtilDEId();
            }
            case 26: {
                return pSSysBackServiceBase.getPSSysUtilDEName();
            }
            case 27: {
                return pSSysBackServiceBase.getRunOrder();
            }
            case 28: {
                return pSSysBackServiceBase.getServiceContainer();
            }
            case 29: {
                return pSSysBackServiceBase.getServiceObj();
            }
            case 30: {
                return pSSysBackServiceBase.getServiceParams();
            }
            case 31: {
                return pSSysBackServiceBase.getServicePolicy();
            }
            case 32: {
                return pSSysBackServiceBase.getServicePolicy2();
            }
            case 33: {
                return pSSysBackServiceBase.getServiceTag();
            }
            case 34: {
                return pSSysBackServiceBase.getServiceTag2();
            }
            case 35: {
                return pSSysBackServiceBase.getStartMode();
            }
            case 36: {
                return pSSysBackServiceBase.getTaskType();
            }
            case 37: {
                return pSSysBackServiceBase.getTimerMode();
            }
            case 38: {
                return pSSysBackServiceBase.getTimerPolicy();
            }
            case 39: {
                return pSSysBackServiceBase.getUpdateDate();
            }
            case 40: {
                return pSSysBackServiceBase.getUpdateMan();
            }
            case 41: {
                return pSSysBackServiceBase.getUserCat();
            }
            case 42: {
                return pSSysBackServiceBase.getUserParams();
            }
            case 43: {
                return pSSysBackServiceBase.getUserTag();
            }
            case 44: {
                return pSSysBackServiceBase.getUserTag2();
            }
            case 45: {
                return pSSysBackServiceBase.getUserTag3();
            }
            case 46: {
                return pSSysBackServiceBase.getUserTag4();
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
        PSSysBackServiceBase.set(this, n, object);
    }

    private static void set(PSSysBackServiceBase pSSysBackServiceBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBackServiceBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBackServiceBase.setContainerTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBackServiceBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSysBackServiceBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBackServiceBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBackServiceBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBackServiceBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBackServiceBase.setPSBackServiceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBackServiceBase.setPSBackServiceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBackServiceBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBackServiceBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBackServiceBase.setPSDEDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBackServiceBase.setPSDEDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBackServiceBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBackServiceBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBackServiceBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBackServiceBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysBackServiceBase.setPSSysBackServiceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBackServiceBase.setPSSysBackServiceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBackServiceBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysBackServiceBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBackServiceBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBackServiceBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBackServiceBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBackServiceBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysBackServiceBase.setPSSysUtilDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysBackServiceBase.setPSSysUtilDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysBackServiceBase.setRunOrder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSSysBackServiceBase.setServiceContainer(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysBackServiceBase.setServiceObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysBackServiceBase.setServiceParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysBackServiceBase.setServicePolicy(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysBackServiceBase.setServicePolicy2(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysBackServiceBase.setServiceTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysBackServiceBase.setServiceTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysBackServiceBase.setStartMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysBackServiceBase.setTaskType(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysBackServiceBase.setTimerMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSSysBackServiceBase.setTimerPolicy(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysBackServiceBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 40: {
                pSSysBackServiceBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysBackServiceBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysBackServiceBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysBackServiceBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysBackServiceBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysBackServiceBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysBackServiceBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysBackServiceBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBackServiceBase pSSysBackServiceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBackServiceBase.getCodeName() == null;
            }
            case 1: {
                return pSSysBackServiceBase.getContainerTag() == null;
            }
            case 2: {
                return pSSysBackServiceBase.getCreateDate() == null;
            }
            case 3: {
                return pSSysBackServiceBase.getCreateMan() == null;
            }
            case 4: {
                return pSSysBackServiceBase.getCustomCode() == null;
            }
            case 5: {
                return pSSysBackServiceBase.getMemo() == null;
            }
            case 6: {
                return pSSysBackServiceBase.getPredefinedType() == null;
            }
            case 7: {
                return pSSysBackServiceBase.getPSBackServiceId() == null;
            }
            case 8: {
                return pSSysBackServiceBase.getPSBackServiceName() == null;
            }
            case 9: {
                return pSSysBackServiceBase.getPSDEActionId() == null;
            }
            case 10: {
                return pSSysBackServiceBase.getPSDEActionName() == null;
            }
            case 11: {
                return pSSysBackServiceBase.getPSDEDSId() == null;
            }
            case 12: {
                return pSSysBackServiceBase.getPSDEDSName() == null;
            }
            case 13: {
                return pSSysBackServiceBase.getPSDEId() == null;
            }
            case 14: {
                return pSSysBackServiceBase.getPSDEName() == null;
            }
            case 15: {
                return pSSysBackServiceBase.getPSModuleId() == null;
            }
            case 16: {
                return pSSysBackServiceBase.getPSModuleName() == null;
            }
            case 17: {
                return pSSysBackServiceBase.getPSSysBackServiceId() == null;
            }
            case 18: {
                return pSSysBackServiceBase.getPSSysBackServiceName() == null;
            }
            case 19: {
                return pSSysBackServiceBase.getPSSysDynaModelId() == null;
            }
            case 20: {
                return pSSysBackServiceBase.getPSSysDynaModelName() == null;
            }
            case 21: {
                return pSSysBackServiceBase.getPSSysSFPluginId() == null;
            }
            case 22: {
                return pSSysBackServiceBase.getPSSysSFPluginName() == null;
            }
            case 23: {
                return pSSysBackServiceBase.getPSSystemId() == null;
            }
            case 24: {
                return pSSysBackServiceBase.getPSSystemName() == null;
            }
            case 25: {
                return pSSysBackServiceBase.getPSSysUtilDEId() == null;
            }
            case 26: {
                return pSSysBackServiceBase.getPSSysUtilDEName() == null;
            }
            case 27: {
                return pSSysBackServiceBase.getRunOrder() == null;
            }
            case 28: {
                return pSSysBackServiceBase.getServiceContainer() == null;
            }
            case 29: {
                return pSSysBackServiceBase.getServiceObj() == null;
            }
            case 30: {
                return pSSysBackServiceBase.getServiceParams() == null;
            }
            case 31: {
                return pSSysBackServiceBase.getServicePolicy() == null;
            }
            case 32: {
                return pSSysBackServiceBase.getServicePolicy2() == null;
            }
            case 33: {
                return pSSysBackServiceBase.getServiceTag() == null;
            }
            case 34: {
                return pSSysBackServiceBase.getServiceTag2() == null;
            }
            case 35: {
                return pSSysBackServiceBase.getStartMode() == null;
            }
            case 36: {
                return pSSysBackServiceBase.getTaskType() == null;
            }
            case 37: {
                return pSSysBackServiceBase.getTimerMode() == null;
            }
            case 38: {
                return pSSysBackServiceBase.getTimerPolicy() == null;
            }
            case 39: {
                return pSSysBackServiceBase.getUpdateDate() == null;
            }
            case 40: {
                return pSSysBackServiceBase.getUpdateMan() == null;
            }
            case 41: {
                return pSSysBackServiceBase.getUserCat() == null;
            }
            case 42: {
                return pSSysBackServiceBase.getUserParams() == null;
            }
            case 43: {
                return pSSysBackServiceBase.getUserTag() == null;
            }
            case 44: {
                return pSSysBackServiceBase.getUserTag2() == null;
            }
            case 45: {
                return pSSysBackServiceBase.getUserTag3() == null;
            }
            case 46: {
                return pSSysBackServiceBase.getUserTag4() == null;
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
        return PSSysBackServiceBase.contains(this, n);
    }

    private static boolean contains(PSSysBackServiceBase pSSysBackServiceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBackServiceBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysBackServiceBase.isContainerTagDirty();
            }
            case 2: {
                return pSSysBackServiceBase.isCreateDateDirty();
            }
            case 3: {
                return pSSysBackServiceBase.isCreateManDirty();
            }
            case 4: {
                return pSSysBackServiceBase.isCustomCodeDirty();
            }
            case 5: {
                return pSSysBackServiceBase.isMemoDirty();
            }
            case 6: {
                return pSSysBackServiceBase.isPredefinedTypeDirty();
            }
            case 7: {
                return pSSysBackServiceBase.isPSBackServiceIdDirty();
            }
            case 8: {
                return pSSysBackServiceBase.isPSBackServiceNameDirty();
            }
            case 9: {
                return pSSysBackServiceBase.isPSDEActionIdDirty();
            }
            case 10: {
                return pSSysBackServiceBase.isPSDEActionNameDirty();
            }
            case 11: {
                return pSSysBackServiceBase.isPSDEDSIdDirty();
            }
            case 12: {
                return pSSysBackServiceBase.isPSDEDSNameDirty();
            }
            case 13: {
                return pSSysBackServiceBase.isPSDEIdDirty();
            }
            case 14: {
                return pSSysBackServiceBase.isPSDENameDirty();
            }
            case 15: {
                return pSSysBackServiceBase.isPSModuleIdDirty();
            }
            case 16: {
                return pSSysBackServiceBase.isPSModuleNameDirty();
            }
            case 17: {
                return pSSysBackServiceBase.isPSSysBackServiceIdDirty();
            }
            case 18: {
                return pSSysBackServiceBase.isPSSysBackServiceNameDirty();
            }
            case 19: {
                return pSSysBackServiceBase.isPSSysDynaModelIdDirty();
            }
            case 20: {
                return pSSysBackServiceBase.isPSSysDynaModelNameDirty();
            }
            case 21: {
                return pSSysBackServiceBase.isPSSysSFPluginIdDirty();
            }
            case 22: {
                return pSSysBackServiceBase.isPSSysSFPluginNameDirty();
            }
            case 23: {
                return pSSysBackServiceBase.isPSSystemIdDirty();
            }
            case 24: {
                return pSSysBackServiceBase.isPSSystemNameDirty();
            }
            case 25: {
                return pSSysBackServiceBase.isPSSysUtilDEIdDirty();
            }
            case 26: {
                return pSSysBackServiceBase.isPSSysUtilDENameDirty();
            }
            case 27: {
                return pSSysBackServiceBase.isRunOrderDirty();
            }
            case 28: {
                return pSSysBackServiceBase.isServiceContainerDirty();
            }
            case 29: {
                return pSSysBackServiceBase.isServiceObjDirty();
            }
            case 30: {
                return pSSysBackServiceBase.isServiceParamsDirty();
            }
            case 31: {
                return pSSysBackServiceBase.isServicePolicyDirty();
            }
            case 32: {
                return pSSysBackServiceBase.isServicePolicy2Dirty();
            }
            case 33: {
                return pSSysBackServiceBase.isServiceTagDirty();
            }
            case 34: {
                return pSSysBackServiceBase.isServiceTag2Dirty();
            }
            case 35: {
                return pSSysBackServiceBase.isStartModeDirty();
            }
            case 36: {
                return pSSysBackServiceBase.isTaskTypeDirty();
            }
            case 37: {
                return pSSysBackServiceBase.isTimerModeDirty();
            }
            case 38: {
                return pSSysBackServiceBase.isTimerPolicyDirty();
            }
            case 39: {
                return pSSysBackServiceBase.isUpdateDateDirty();
            }
            case 40: {
                return pSSysBackServiceBase.isUpdateManDirty();
            }
            case 41: {
                return pSSysBackServiceBase.isUserCatDirty();
            }
            case 42: {
                return pSSysBackServiceBase.isUserParamsDirty();
            }
            case 43: {
                return pSSysBackServiceBase.isUserTagDirty();
            }
            case 44: {
                return pSSysBackServiceBase.isUserTag2Dirty();
            }
            case 45: {
                return pSSysBackServiceBase.isUserTag3Dirty();
            }
            case 46: {
                return pSSysBackServiceBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBackServiceBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBackServiceBase pSSysBackServiceBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBackServiceBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getContainerTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"containertag", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getContainerTag()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSBackServiceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbackserviceid", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSBackServiceId()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSBackServiceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbackservicename", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSBackServiceName()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSDEDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsid", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSDEDSId()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSDEDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsname", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSDEDSName()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSSysBackServiceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbackserviceid", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSSysBackServiceId()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSSysBackServiceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbackservicename", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSSysBackServiceName()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSSysUtilDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysutildeid", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSSysUtilDEId()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getPSSysUtilDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysutildename", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getPSSysUtilDEName()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getRunOrder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runorder", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getRunOrder()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getServiceContainer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecontainer", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getServiceContainer()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getServiceObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceobj", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getServiceObj()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getServiceParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparams", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getServiceParams()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getServicePolicy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicepolicy", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getServicePolicy()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getServicePolicy2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicepolicy2", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getServicePolicy2()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getServiceTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicetag", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getServiceTag()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getServiceTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicetag2", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getServiceTag2()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getStartMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"startmode", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getStartMode()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getTaskType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tasktype", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getTaskType()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getTimerMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timermode", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getTimerMode()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getTimerPolicy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timerpolicy", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getTimerPolicy()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getUserParams()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBackServiceBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBackServiceBase.getJSONValue((Object)pSSysBackServiceBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBackServiceBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBackServiceBase pSSysBackServiceBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBackServiceBase.getCodeName() != null) {
            object = pSSysBackServiceBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBackServiceBase.getContainerTag() != null) {
            object = pSSysBackServiceBase.getContainerTag();
            xmlNode.setAttribute(FIELD_CONTAINERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getCreateDate() != null) {
            object = pSSysBackServiceBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBackServiceBase.getCreateMan() != null) {
            object = pSSysBackServiceBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getCustomCode() != null) {
            object = pSSysBackServiceBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getMemo() != null) {
            object = pSSysBackServiceBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPredefinedType() != null) {
            object = pSSysBackServiceBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSBackServiceId() != null) {
            object = pSSysBackServiceBase.getPSBackServiceId();
            xmlNode.setAttribute(FIELD_PSBACKSERVICEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSBackServiceName() != null) {
            object = pSSysBackServiceBase.getPSBackServiceName();
            xmlNode.setAttribute(FIELD_PSBACKSERVICENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSDEActionId() != null) {
            object = pSSysBackServiceBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSDEActionName() != null) {
            object = pSSysBackServiceBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSDEDSId() != null) {
            object = pSSysBackServiceBase.getPSDEDSId();
            xmlNode.setAttribute(FIELD_PSDEDSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSDEDSName() != null) {
            object = pSSysBackServiceBase.getPSDEDSName();
            xmlNode.setAttribute(FIELD_PSDEDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSDEId() != null) {
            object = pSSysBackServiceBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSDEName() != null) {
            object = pSSysBackServiceBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSModuleId() != null) {
            object = pSSysBackServiceBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSModuleName() != null) {
            object = pSSysBackServiceBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSSysBackServiceId() != null) {
            object = pSSysBackServiceBase.getPSSysBackServiceId();
            xmlNode.setAttribute(FIELD_PSSYSBACKSERVICEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSSysBackServiceName() != null) {
            object = pSSysBackServiceBase.getPSSysBackServiceName();
            xmlNode.setAttribute(FIELD_PSSYSBACKSERVICENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSSysDynaModelId() != null) {
            object = pSSysBackServiceBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSSysDynaModelName() != null) {
            object = pSSysBackServiceBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSSysSFPluginId() != null) {
            object = pSSysBackServiceBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSSysSFPluginName() != null) {
            object = pSSysBackServiceBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSSystemId() != null) {
            object = pSSysBackServiceBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSSystemName() != null) {
            object = pSSysBackServiceBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSSysUtilDEId() != null) {
            object = pSSysBackServiceBase.getPSSysUtilDEId();
            xmlNode.setAttribute(FIELD_PSSYSUTILDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getPSSysUtilDEName() != null) {
            object = pSSysBackServiceBase.getPSSysUtilDEName();
            xmlNode.setAttribute(FIELD_PSSYSUTILDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getRunOrder() != null) {
            object = pSSysBackServiceBase.getRunOrder();
            xmlNode.setAttribute(FIELD_RUNORDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBackServiceBase.getServiceContainer() != null) {
            object = pSSysBackServiceBase.getServiceContainer();
            xmlNode.setAttribute(FIELD_SERVICECONTAINER, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getServiceObj() != null) {
            object = pSSysBackServiceBase.getServiceObj();
            xmlNode.setAttribute(FIELD_SERVICEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getServiceParams() != null) {
            object = pSSysBackServiceBase.getServiceParams();
            xmlNode.setAttribute(FIELD_SERVICEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getServicePolicy() != null) {
            object = pSSysBackServiceBase.getServicePolicy();
            xmlNode.setAttribute(FIELD_SERVICEPOLICY, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getServicePolicy2() != null) {
            object = pSSysBackServiceBase.getServicePolicy2();
            xmlNode.setAttribute(FIELD_SERVICEPOLICY2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getServiceTag() != null) {
            object = pSSysBackServiceBase.getServiceTag();
            xmlNode.setAttribute(FIELD_SERVICETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getServiceTag2() != null) {
            object = pSSysBackServiceBase.getServiceTag2();
            xmlNode.setAttribute(FIELD_SERVICETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getStartMode() != null) {
            object = pSSysBackServiceBase.getStartMode();
            xmlNode.setAttribute(FIELD_STARTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getTaskType() != null) {
            object = pSSysBackServiceBase.getTaskType();
            xmlNode.setAttribute(FIELD_TASKTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getTimerMode() != null) {
            object = pSSysBackServiceBase.getTimerMode();
            xmlNode.setAttribute(FIELD_TIMERMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBackServiceBase.getTimerPolicy() != null) {
            object = pSSysBackServiceBase.getTimerPolicy();
            xmlNode.setAttribute(FIELD_TIMERPOLICY, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getUpdateDate() != null) {
            object = pSSysBackServiceBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBackServiceBase.getUpdateMan() != null) {
            object = pSSysBackServiceBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getUserCat() != null) {
            object = pSSysBackServiceBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getUserParams() != null) {
            object = pSSysBackServiceBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getUserTag() != null) {
            object = pSSysBackServiceBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getUserTag2() != null) {
            object = pSSysBackServiceBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getUserTag3() != null) {
            object = pSSysBackServiceBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBackServiceBase.getUserTag4() != null) {
            object = pSSysBackServiceBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBackServiceBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBackServiceBase pSSysBackServiceBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBackServiceBase.isCodeNameDirty() && (bl || pSSysBackServiceBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBackServiceBase.getCodeName());
        }
        if (pSSysBackServiceBase.isContainerTagDirty() && (bl || pSSysBackServiceBase.getContainerTag() != null)) {
            iDataObject.set(FIELD_CONTAINERTAG, (Object)pSSysBackServiceBase.getContainerTag());
        }
        if (pSSysBackServiceBase.isCreateDateDirty() && (bl || pSSysBackServiceBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBackServiceBase.getCreateDate());
        }
        if (pSSysBackServiceBase.isCreateManDirty() && (bl || pSSysBackServiceBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBackServiceBase.getCreateMan());
        }
        if (pSSysBackServiceBase.isCustomCodeDirty() && (bl || pSSysBackServiceBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysBackServiceBase.getCustomCode());
        }
        if (pSSysBackServiceBase.isMemoDirty() && (bl || pSSysBackServiceBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBackServiceBase.getMemo());
        }
        if (pSSysBackServiceBase.isPredefinedTypeDirty() && (bl || pSSysBackServiceBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSSysBackServiceBase.getPredefinedType());
        }
        if (pSSysBackServiceBase.isPSBackServiceIdDirty() && (bl || pSSysBackServiceBase.getPSBackServiceId() != null)) {
            iDataObject.set(FIELD_PSBACKSERVICEID, (Object)pSSysBackServiceBase.getPSBackServiceId());
        }
        if (pSSysBackServiceBase.isPSBackServiceNameDirty() && (bl || pSSysBackServiceBase.getPSBackServiceName() != null)) {
            iDataObject.set(FIELD_PSBACKSERVICENAME, (Object)pSSysBackServiceBase.getPSBackServiceName());
        }
        if (pSSysBackServiceBase.isPSDEActionIdDirty() && (bl || pSSysBackServiceBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSSysBackServiceBase.getPSDEActionId());
        }
        if (pSSysBackServiceBase.isPSDEActionNameDirty() && (bl || pSSysBackServiceBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSSysBackServiceBase.getPSDEActionName());
        }
        if (pSSysBackServiceBase.isPSDEDSIdDirty() && (bl || pSSysBackServiceBase.getPSDEDSId() != null)) {
            iDataObject.set(FIELD_PSDEDSID, (Object)pSSysBackServiceBase.getPSDEDSId());
        }
        if (pSSysBackServiceBase.isPSDEDSNameDirty() && (bl || pSSysBackServiceBase.getPSDEDSName() != null)) {
            iDataObject.set(FIELD_PSDEDSNAME, (Object)pSSysBackServiceBase.getPSDEDSName());
        }
        if (pSSysBackServiceBase.isPSDEIdDirty() && (bl || pSSysBackServiceBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysBackServiceBase.getPSDEId());
        }
        if (pSSysBackServiceBase.isPSDENameDirty() && (bl || pSSysBackServiceBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysBackServiceBase.getPSDEName());
        }
        if (pSSysBackServiceBase.isPSModuleIdDirty() && (bl || pSSysBackServiceBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysBackServiceBase.getPSModuleId());
        }
        if (pSSysBackServiceBase.isPSModuleNameDirty() && (bl || pSSysBackServiceBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysBackServiceBase.getPSModuleName());
        }
        if (pSSysBackServiceBase.isPSSysBackServiceIdDirty() && (bl || pSSysBackServiceBase.getPSSysBackServiceId() != null)) {
            iDataObject.set(FIELD_PSSYSBACKSERVICEID, (Object)pSSysBackServiceBase.getPSSysBackServiceId());
        }
        if (pSSysBackServiceBase.isPSSysBackServiceNameDirty() && (bl || pSSysBackServiceBase.getPSSysBackServiceName() != null)) {
            iDataObject.set(FIELD_PSSYSBACKSERVICENAME, (Object)pSSysBackServiceBase.getPSSysBackServiceName());
        }
        if (pSSysBackServiceBase.isPSSysDynaModelIdDirty() && (bl || pSSysBackServiceBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysBackServiceBase.getPSSysDynaModelId());
        }
        if (pSSysBackServiceBase.isPSSysDynaModelNameDirty() && (bl || pSSysBackServiceBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysBackServiceBase.getPSSysDynaModelName());
        }
        if (pSSysBackServiceBase.isPSSysSFPluginIdDirty() && (bl || pSSysBackServiceBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysBackServiceBase.getPSSysSFPluginId());
        }
        if (pSSysBackServiceBase.isPSSysSFPluginNameDirty() && (bl || pSSysBackServiceBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysBackServiceBase.getPSSysSFPluginName());
        }
        if (pSSysBackServiceBase.isPSSystemIdDirty() && (bl || pSSysBackServiceBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysBackServiceBase.getPSSystemId());
        }
        if (pSSysBackServiceBase.isPSSystemNameDirty() && (bl || pSSysBackServiceBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysBackServiceBase.getPSSystemName());
        }
        if (pSSysBackServiceBase.isPSSysUtilDEIdDirty() && (bl || pSSysBackServiceBase.getPSSysUtilDEId() != null)) {
            iDataObject.set(FIELD_PSSYSUTILDEID, (Object)pSSysBackServiceBase.getPSSysUtilDEId());
        }
        if (pSSysBackServiceBase.isPSSysUtilDENameDirty() && (bl || pSSysBackServiceBase.getPSSysUtilDEName() != null)) {
            iDataObject.set(FIELD_PSSYSUTILDENAME, (Object)pSSysBackServiceBase.getPSSysUtilDEName());
        }
        if (pSSysBackServiceBase.isRunOrderDirty() && (bl || pSSysBackServiceBase.getRunOrder() != null)) {
            iDataObject.set(FIELD_RUNORDER, (Object)pSSysBackServiceBase.getRunOrder());
        }
        if (pSSysBackServiceBase.isServiceContainerDirty() && (bl || pSSysBackServiceBase.getServiceContainer() != null)) {
            iDataObject.set(FIELD_SERVICECONTAINER, (Object)pSSysBackServiceBase.getServiceContainer());
        }
        if (pSSysBackServiceBase.isServiceObjDirty() && (bl || pSSysBackServiceBase.getServiceObj() != null)) {
            iDataObject.set(FIELD_SERVICEOBJ, (Object)pSSysBackServiceBase.getServiceObj());
        }
        if (pSSysBackServiceBase.isServiceParamsDirty() && (bl || pSSysBackServiceBase.getServiceParams() != null)) {
            iDataObject.set(FIELD_SERVICEPARAMS, (Object)pSSysBackServiceBase.getServiceParams());
        }
        if (pSSysBackServiceBase.isServicePolicyDirty() && (bl || pSSysBackServiceBase.getServicePolicy() != null)) {
            iDataObject.set(FIELD_SERVICEPOLICY, (Object)pSSysBackServiceBase.getServicePolicy());
        }
        if (pSSysBackServiceBase.isServicePolicy2Dirty() && (bl || pSSysBackServiceBase.getServicePolicy2() != null)) {
            iDataObject.set(FIELD_SERVICEPOLICY2, (Object)pSSysBackServiceBase.getServicePolicy2());
        }
        if (pSSysBackServiceBase.isServiceTagDirty() && (bl || pSSysBackServiceBase.getServiceTag() != null)) {
            iDataObject.set(FIELD_SERVICETAG, (Object)pSSysBackServiceBase.getServiceTag());
        }
        if (pSSysBackServiceBase.isServiceTag2Dirty() && (bl || pSSysBackServiceBase.getServiceTag2() != null)) {
            iDataObject.set(FIELD_SERVICETAG2, (Object)pSSysBackServiceBase.getServiceTag2());
        }
        if (pSSysBackServiceBase.isStartModeDirty() && (bl || pSSysBackServiceBase.getStartMode() != null)) {
            iDataObject.set(FIELD_STARTMODE, (Object)pSSysBackServiceBase.getStartMode());
        }
        if (pSSysBackServiceBase.isTaskTypeDirty() && (bl || pSSysBackServiceBase.getTaskType() != null)) {
            iDataObject.set(FIELD_TASKTYPE, (Object)pSSysBackServiceBase.getTaskType());
        }
        if (pSSysBackServiceBase.isTimerModeDirty() && (bl || pSSysBackServiceBase.getTimerMode() != null)) {
            iDataObject.set(FIELD_TIMERMODE, (Object)pSSysBackServiceBase.getTimerMode());
        }
        if (pSSysBackServiceBase.isTimerPolicyDirty() && (bl || pSSysBackServiceBase.getTimerPolicy() != null)) {
            iDataObject.set(FIELD_TIMERPOLICY, (Object)pSSysBackServiceBase.getTimerPolicy());
        }
        if (pSSysBackServiceBase.isUpdateDateDirty() && (bl || pSSysBackServiceBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBackServiceBase.getUpdateDate());
        }
        if (pSSysBackServiceBase.isUpdateManDirty() && (bl || pSSysBackServiceBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBackServiceBase.getUpdateMan());
        }
        if (pSSysBackServiceBase.isUserCatDirty() && (bl || pSSysBackServiceBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBackServiceBase.getUserCat());
        }
        if (pSSysBackServiceBase.isUserParamsDirty() && (bl || pSSysBackServiceBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSSysBackServiceBase.getUserParams());
        }
        if (pSSysBackServiceBase.isUserTagDirty() && (bl || pSSysBackServiceBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBackServiceBase.getUserTag());
        }
        if (pSSysBackServiceBase.isUserTag2Dirty() && (bl || pSSysBackServiceBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBackServiceBase.getUserTag2());
        }
        if (pSSysBackServiceBase.isUserTag3Dirty() && (bl || pSSysBackServiceBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBackServiceBase.getUserTag3());
        }
        if (pSSysBackServiceBase.isUserTag4Dirty() && (bl || pSSysBackServiceBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBackServiceBase.getUserTag4());
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
        return PSSysBackServiceBase.remove(this, n);
    }

    private static boolean remove(PSSysBackServiceBase pSSysBackServiceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBackServiceBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysBackServiceBase.resetContainerTag();
                return true;
            }
            case 2: {
                pSSysBackServiceBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSysBackServiceBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSysBackServiceBase.resetCustomCode();
                return true;
            }
            case 5: {
                pSSysBackServiceBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysBackServiceBase.resetPredefinedType();
                return true;
            }
            case 7: {
                pSSysBackServiceBase.resetPSBackServiceId();
                return true;
            }
            case 8: {
                pSSysBackServiceBase.resetPSBackServiceName();
                return true;
            }
            case 9: {
                pSSysBackServiceBase.resetPSDEActionId();
                return true;
            }
            case 10: {
                pSSysBackServiceBase.resetPSDEActionName();
                return true;
            }
            case 11: {
                pSSysBackServiceBase.resetPSDEDSId();
                return true;
            }
            case 12: {
                pSSysBackServiceBase.resetPSDEDSName();
                return true;
            }
            case 13: {
                pSSysBackServiceBase.resetPSDEId();
                return true;
            }
            case 14: {
                pSSysBackServiceBase.resetPSDEName();
                return true;
            }
            case 15: {
                pSSysBackServiceBase.resetPSModuleId();
                return true;
            }
            case 16: {
                pSSysBackServiceBase.resetPSModuleName();
                return true;
            }
            case 17: {
                pSSysBackServiceBase.resetPSSysBackServiceId();
                return true;
            }
            case 18: {
                pSSysBackServiceBase.resetPSSysBackServiceName();
                return true;
            }
            case 19: {
                pSSysBackServiceBase.resetPSSysDynaModelId();
                return true;
            }
            case 20: {
                pSSysBackServiceBase.resetPSSysDynaModelName();
                return true;
            }
            case 21: {
                pSSysBackServiceBase.resetPSSysSFPluginId();
                return true;
            }
            case 22: {
                pSSysBackServiceBase.resetPSSysSFPluginName();
                return true;
            }
            case 23: {
                pSSysBackServiceBase.resetPSSystemId();
                return true;
            }
            case 24: {
                pSSysBackServiceBase.resetPSSystemName();
                return true;
            }
            case 25: {
                pSSysBackServiceBase.resetPSSysUtilDEId();
                return true;
            }
            case 26: {
                pSSysBackServiceBase.resetPSSysUtilDEName();
                return true;
            }
            case 27: {
                pSSysBackServiceBase.resetRunOrder();
                return true;
            }
            case 28: {
                pSSysBackServiceBase.resetServiceContainer();
                return true;
            }
            case 29: {
                pSSysBackServiceBase.resetServiceObj();
                return true;
            }
            case 30: {
                pSSysBackServiceBase.resetServiceParams();
                return true;
            }
            case 31: {
                pSSysBackServiceBase.resetServicePolicy();
                return true;
            }
            case 32: {
                pSSysBackServiceBase.resetServicePolicy2();
                return true;
            }
            case 33: {
                pSSysBackServiceBase.resetServiceTag();
                return true;
            }
            case 34: {
                pSSysBackServiceBase.resetServiceTag2();
                return true;
            }
            case 35: {
                pSSysBackServiceBase.resetStartMode();
                return true;
            }
            case 36: {
                pSSysBackServiceBase.resetTaskType();
                return true;
            }
            case 37: {
                pSSysBackServiceBase.resetTimerMode();
                return true;
            }
            case 38: {
                pSSysBackServiceBase.resetTimerPolicy();
                return true;
            }
            case 39: {
                pSSysBackServiceBase.resetUpdateDate();
                return true;
            }
            case 40: {
                pSSysBackServiceBase.resetUpdateMan();
                return true;
            }
            case 41: {
                pSSysBackServiceBase.resetUserCat();
                return true;
            }
            case 42: {
                pSSysBackServiceBase.resetUserParams();
                return true;
            }
            case 43: {
                pSSysBackServiceBase.resetUserTag();
                return true;
            }
            case 44: {
                pSSysBackServiceBase.resetUserTag2();
                return true;
            }
            case 45: {
                pSSysBackServiceBase.resetUserTag3();
                return true;
            }
            case 46: {
                pSSysBackServiceBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSBackService getPSBackService() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBackService();
        }
        if (this.getPSBackServiceId() == null) {
            return null;
        }
        Integer n = this.objPSBackServiceLock;
        synchronized (n) {
            if (this.psbackservice != null && DataTypeHelper.compare((int)25, (Object)this.getPSBackServiceId(), (Object)this.psbackservice.getPSBackServiceId()) != 0L) {
                this.psbackservice = null;
            }
            if (this.psbackservice == null) {
                PSBackService pSBackService = new PSBackService();
                pSBackService.setPSBackServiceId(this.getPSBackServiceId());
                PSBackServiceService pSBackServiceService = (PSBackServiceService)ServiceGlobal.getService(PSBackServiceService.class, (SessionFactory)this.getSessionFactory());
                pSBackServiceService.autoGet((IEntity)pSBackService);
                this.psbackservice = pSBackService;
            }
            return this.psbackservice;
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
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.psdeds = pSDEDataSet;
            }
            return this.psdeds;
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
    public PSSysUtilDE getPSSysUtilDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDE();
        }
        if (this.getPSSysUtilDEId() == null) {
            return null;
        }
        Integer n = this.objPSSysUtilDELock;
        synchronized (n) {
            if (this.pssysutilde != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUtilDEId(), (Object)this.pssysutilde.getPSSysUtilDEId()) != 0L) {
                this.pssysutilde = null;
            }
            if (this.pssysutilde == null) {
                PSSysUtilDE pSSysUtilDE = new PSSysUtilDE();
                pSSysUtilDE.setPSSysUtilDEId(this.getPSSysUtilDEId());
                PSSysUtilDEService pSSysUtilDEService = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
                pSSysUtilDEService.autoGet((IEntity)pSSysUtilDE);
                this.pssysutilde = pSSysUtilDE;
            }
            return this.pssysutilde;
        }
    }

    private PSSysBackServiceBase getProxyEntity() {
        return this.proxyPSSysBackServiceBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBackServiceBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBackServiceBase) {
            this.proxyPSSysBackServiceBase = (PSSysBackServiceBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysBackServiceService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CONTAINERTAG, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 6);
        fieldIndexMap.put(FIELD_PSBACKSERVICEID, 7);
        fieldIndexMap.put(FIELD_PSBACKSERVICENAME, 8);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 9);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 10);
        fieldIndexMap.put(FIELD_PSDEDSID, 11);
        fieldIndexMap.put(FIELD_PSDEDSNAME, 12);
        fieldIndexMap.put(FIELD_PSDEID, 13);
        fieldIndexMap.put(FIELD_PSDENAME, 14);
        fieldIndexMap.put(FIELD_PSMODULEID, 15);
        fieldIndexMap.put(FIELD_PSMODULENAME, 16);
        fieldIndexMap.put(FIELD_PSSYSBACKSERVICEID, 17);
        fieldIndexMap.put(FIELD_PSSYSBACKSERVICENAME, 18);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 19);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 21);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 22);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 23);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 24);
        fieldIndexMap.put(FIELD_PSSYSUTILDEID, 25);
        fieldIndexMap.put(FIELD_PSSYSUTILDENAME, 26);
        fieldIndexMap.put(FIELD_RUNORDER, 27);
        fieldIndexMap.put(FIELD_SERVICECONTAINER, 28);
        fieldIndexMap.put(FIELD_SERVICEOBJ, 29);
        fieldIndexMap.put(FIELD_SERVICEPARAMS, 30);
        fieldIndexMap.put(FIELD_SERVICEPOLICY, 31);
        fieldIndexMap.put(FIELD_SERVICEPOLICY2, 32);
        fieldIndexMap.put(FIELD_SERVICETAG, 33);
        fieldIndexMap.put(FIELD_SERVICETAG2, 34);
        fieldIndexMap.put(FIELD_STARTMODE, 35);
        fieldIndexMap.put(FIELD_TASKTYPE, 36);
        fieldIndexMap.put(FIELD_TIMERMODE, 37);
        fieldIndexMap.put(FIELD_TIMERPOLICY, 38);
        fieldIndexMap.put(FIELD_UPDATEDATE, 39);
        fieldIndexMap.put(FIELD_UPDATEMAN, 40);
        fieldIndexMap.put(FIELD_USERCAT, 41);
        fieldIndexMap.put(FIELD_USERPARAMS, 42);
        fieldIndexMap.put(FIELD_USERTAG, 43);
        fieldIndexMap.put(FIELD_USERTAG2, 44);
        fieldIndexMap.put(FIELD_USERTAG3, 45);
        fieldIndexMap.put(FIELD_USERTAG4, 46);
    }
}

