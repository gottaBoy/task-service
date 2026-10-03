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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUniResBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysUniResBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_RESCODE = "RESCODE";
    public static final String FIELD_RESMODEL = "RESMODEL";
    public static final String FIELD_RESTAG = "RESTAG";
    public static final String FIELD_RESTAG2 = "RESTAG2";
    public static final String FIELD_RESTYPE = "RESTYPE";
    public static final String FIELD_TESTCUSTOMCODE = "TESTCUSTOMCODE";
    public static final String FIELD_TESTCUSTOMMODE = "TESTCUSTOMMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DYNAMODELFLAG = 2;
    private static final int INDEX_LOCKFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSMODULEID = 5;
    private static final int INDEX_PSMODULENAME = 6;
    private static final int INDEX_PSSYSAPPID = 7;
    private static final int INDEX_PSSYSAPPNAME = 8;
    private static final int INDEX_PSSYSDYNAMODELID = 9;
    private static final int INDEX_PSSYSDYNAMODELNAME = 10;
    private static final int INDEX_PSSYSSERVICEAPIID = 11;
    private static final int INDEX_PSSYSSERVICEAPINAME = 12;
    private static final int INDEX_PSSYSSFPLUGINID = 13;
    private static final int INDEX_PSSYSSFPLUGINNAME = 14;
    private static final int INDEX_PSSYSTEMID = 15;
    private static final int INDEX_PSSYSTEMNAME = 16;
    private static final int INDEX_PSSYSUNIRESID = 17;
    private static final int INDEX_PSSYSUNIRESNAME = 18;
    private static final int INDEX_RESCODE = 19;
    private static final int INDEX_RESMODEL = 20;
    private static final int INDEX_RESTAG = 21;
    private static final int INDEX_RESTAG2 = 22;
    private static final int INDEX_RESTYPE = 23;
    private static final int INDEX_TESTCUSTOMCODE = 24;
    private static final int INDEX_TESTCUSTOMMODE = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USERCAT = 28;
    private static final int INDEX_USERTAG = 29;
    private static final int INDEX_USERTAG2 = 30;
    private static final int INDEX_USERTAG3 = 31;
    private static final int INDEX_USERTAG4 = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysUniResBase proxyPSSysUniResBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean pssysserviceapinameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean rescodeDirtyFlag = false;
    private boolean resmodelDirtyFlag = false;
    private boolean restagDirtyFlag = false;
    private boolean restag2DirtyFlag = false;
    private boolean restypeDirtyFlag = false;
    private boolean testcustomcodeDirtyFlag = false;
    private boolean testcustommodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysserviceapiid")
    private String pssysserviceapiid;
    @Column(name="pssysserviceapiname")
    private String pssysserviceapiname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
    @Column(name="rescode")
    private String rescode;
    @Column(name="resmodel")
    private String resmodel;
    @Column(name="restag")
    private String restag;
    @Column(name="restag2")
    private String restag2;
    @Column(name="restype")
    private String restype;
    @Column(name="testcustomcode")
    private String testcustomcode;
    @Column(name="testcustommode")
    private Integer testcustommode;
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
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysServiceAPILock = new Integer(1);
    private PSSysServiceAPI pssysserviceapi = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
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

    public void setPSSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiid = string;
        this.pssysserviceapiidDirtyFlag = true;
    }

    public String getPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIId();
        }
        return this.pssysserviceapiid;
    }

    public boolean isPSSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPIIdDirty();
        }
        return this.pssysserviceapiidDirtyFlag;
    }

    public void resetPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIId();
            return;
        }
        this.pssysserviceapiidDirtyFlag = false;
        this.pssysserviceapiid = null;
    }

    public void setPSSysServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiname = string;
        this.pssysserviceapinameDirtyFlag = true;
    }

    public String getPSSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIName();
        }
        return this.pssysserviceapiname;
    }

    public boolean isPSSysServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPINameDirty();
        }
        return this.pssysserviceapinameDirtyFlag;
    }

    public void resetPSSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIName();
            return;
        }
        this.pssysserviceapinameDirtyFlag = false;
        this.pssysserviceapiname = null;
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

    public void setPSSysUniResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresid = string;
        this.pssysuniresidDirtyFlag = true;
    }

    public String getPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResId();
        }
        return this.pssysuniresid;
    }

    public boolean isPSSysUniResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResIdDirty();
        }
        return this.pssysuniresidDirtyFlag;
    }

    public void resetPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResId();
            return;
        }
        this.pssysuniresidDirtyFlag = false;
        this.pssysuniresid = null;
    }

    public void setPSSysUniResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresname = string;
        this.pssysuniresnameDirtyFlag = true;
    }

    public String getPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResName();
        }
        return this.pssysuniresname;
    }

    public boolean isPSSysUniResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResNameDirty();
        }
        return this.pssysuniresnameDirtyFlag;
    }

    public void resetPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResName();
            return;
        }
        this.pssysuniresnameDirtyFlag = false;
        this.pssysuniresname = null;
    }

    public void setResCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.rescode = string;
        this.rescodeDirtyFlag = true;
    }

    public String getResCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResCode();
        }
        return this.rescode;
    }

    public boolean isResCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResCodeDirty();
        }
        return this.rescodeDirtyFlag;
    }

    public void resetResCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResCode();
            return;
        }
        this.rescodeDirtyFlag = false;
        this.rescode = null;
    }

    public void setResModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resmodel = string;
        this.resmodelDirtyFlag = true;
    }

    public String getResModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResModel();
        }
        return this.resmodel;
    }

    public boolean isResModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResModelDirty();
        }
        return this.resmodelDirtyFlag;
    }

    public void resetResModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResModel();
            return;
        }
        this.resmodelDirtyFlag = false;
        this.resmodel = null;
    }

    public void setResTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.restag = string;
        this.restagDirtyFlag = true;
    }

    public String getResTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResTag();
        }
        return this.restag;
    }

    public boolean isResTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResTagDirty();
        }
        return this.restagDirtyFlag;
    }

    public void resetResTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResTag();
            return;
        }
        this.restagDirtyFlag = false;
        this.restag = null;
    }

    public void setResTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.restag2 = string;
        this.restag2DirtyFlag = true;
    }

    public String getResTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResTag2();
        }
        return this.restag2;
    }

    public boolean isResTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResTag2Dirty();
        }
        return this.restag2DirtyFlag;
    }

    public void resetResTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResTag2();
            return;
        }
        this.restag2DirtyFlag = false;
        this.restag2 = null;
    }

    public void setResType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.restype = string;
        this.restypeDirtyFlag = true;
    }

    public String getResType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResType();
        }
        return this.restype;
    }

    public boolean isResTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResTypeDirty();
        }
        return this.restypeDirtyFlag;
    }

    public void resetResType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResType();
            return;
        }
        this.restypeDirtyFlag = false;
        this.restype = null;
    }

    public void setTestCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testcustomcode = string;
        this.testcustomcodeDirtyFlag = true;
    }

    public String getTestCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestCustomCode();
        }
        return this.testcustomcode;
    }

    public boolean isTestCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestCustomCodeDirty();
        }
        return this.testcustomcodeDirtyFlag;
    }

    public void resetTestCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestCustomCode();
            return;
        }
        this.testcustomcodeDirtyFlag = false;
        this.testcustomcode = null;
    }

    public void setTestCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestCustomMode(n);
            return;
        }
        this.testcustommode = n;
        this.testcustommodeDirtyFlag = true;
    }

    public Integer getTestCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestCustomMode();
        }
        return this.testcustommode;
    }

    public boolean isTestCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestCustomModeDirty();
        }
        return this.testcustommodeDirtyFlag;
    }

    public void resetTestCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestCustomMode();
            return;
        }
        this.testcustommodeDirtyFlag = false;
        this.testcustommode = null;
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
        PSSysUniResBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysUniResBase pSSysUniResBase) {
        pSSysUniResBase.resetCreateDate();
        pSSysUniResBase.resetCreateMan();
        pSSysUniResBase.resetDynaModelFlag();
        pSSysUniResBase.resetLockFlag();
        pSSysUniResBase.resetMemo();
        pSSysUniResBase.resetPSModuleId();
        pSSysUniResBase.resetPSModuleName();
        pSSysUniResBase.resetPSSysAppId();
        pSSysUniResBase.resetPSSysAppName();
        pSSysUniResBase.resetPSSysDynaModelId();
        pSSysUniResBase.resetPSSysDynaModelName();
        pSSysUniResBase.resetPSSysServiceAPIId();
        pSSysUniResBase.resetPSSysServiceAPIName();
        pSSysUniResBase.resetPSSysSFPluginId();
        pSSysUniResBase.resetPSSysSFPluginName();
        pSSysUniResBase.resetPSSystemId();
        pSSysUniResBase.resetPSSystemName();
        pSSysUniResBase.resetPSSysUniResId();
        pSSysUniResBase.resetPSSysUniResName();
        pSSysUniResBase.resetResCode();
        pSSysUniResBase.resetResModel();
        pSSysUniResBase.resetResTag();
        pSSysUniResBase.resetResTag2();
        pSSysUniResBase.resetResType();
        pSSysUniResBase.resetTestCustomCode();
        pSSysUniResBase.resetTestCustomMode();
        pSSysUniResBase.resetUpdateDate();
        pSSysUniResBase.resetUpdateMan();
        pSSysUniResBase.resetUserCat();
        pSSysUniResBase.resetUserTag();
        pSSysUniResBase.resetUserTag2();
        pSSysUniResBase.resetUserTag3();
        pSSysUniResBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPIID, this.getPSSysServiceAPIId());
        }
        if (!bl || this.isPSSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPINAME, this.getPSSysServiceAPIName());
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
        if (!bl || this.isPSSysUniResIdDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESID, this.getPSSysUniResId());
        }
        if (!bl || this.isPSSysUniResNameDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESNAME, this.getPSSysUniResName());
        }
        if (!bl || this.isResCodeDirty()) {
            hashMap.put(FIELD_RESCODE, this.getResCode());
        }
        if (!bl || this.isResModelDirty()) {
            hashMap.put(FIELD_RESMODEL, this.getResModel());
        }
        if (!bl || this.isResTagDirty()) {
            hashMap.put(FIELD_RESTAG, this.getResTag());
        }
        if (!bl || this.isResTag2Dirty()) {
            hashMap.put(FIELD_RESTAG2, this.getResTag2());
        }
        if (!bl || this.isResTypeDirty()) {
            hashMap.put(FIELD_RESTYPE, this.getResType());
        }
        if (!bl || this.isTestCustomCodeDirty()) {
            hashMap.put(FIELD_TESTCUSTOMCODE, this.getTestCustomCode());
        }
        if (!bl || this.isTestCustomModeDirty()) {
            hashMap.put(FIELD_TESTCUSTOMMODE, this.getTestCustomMode());
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
        return PSSysUniResBase.get(this, n);
    }

    private static Object get(PSSysUniResBase pSSysUniResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUniResBase.getCreateDate();
            }
            case 1: {
                return pSSysUniResBase.getCreateMan();
            }
            case 2: {
                return pSSysUniResBase.getDynaModelFlag();
            }
            case 3: {
                return pSSysUniResBase.getLockFlag();
            }
            case 4: {
                return pSSysUniResBase.getMemo();
            }
            case 5: {
                return pSSysUniResBase.getPSModuleId();
            }
            case 6: {
                return pSSysUniResBase.getPSModuleName();
            }
            case 7: {
                return pSSysUniResBase.getPSSysAppId();
            }
            case 8: {
                return pSSysUniResBase.getPSSysAppName();
            }
            case 9: {
                return pSSysUniResBase.getPSSysDynaModelId();
            }
            case 10: {
                return pSSysUniResBase.getPSSysDynaModelName();
            }
            case 11: {
                return pSSysUniResBase.getPSSysServiceAPIId();
            }
            case 12: {
                return pSSysUniResBase.getPSSysServiceAPIName();
            }
            case 13: {
                return pSSysUniResBase.getPSSysSFPluginId();
            }
            case 14: {
                return pSSysUniResBase.getPSSysSFPluginName();
            }
            case 15: {
                return pSSysUniResBase.getPSSystemId();
            }
            case 16: {
                return pSSysUniResBase.getPSSystemName();
            }
            case 17: {
                return pSSysUniResBase.getPSSysUniResId();
            }
            case 18: {
                return pSSysUniResBase.getPSSysUniResName();
            }
            case 19: {
                return pSSysUniResBase.getResCode();
            }
            case 20: {
                return pSSysUniResBase.getResModel();
            }
            case 21: {
                return pSSysUniResBase.getResTag();
            }
            case 22: {
                return pSSysUniResBase.getResTag2();
            }
            case 23: {
                return pSSysUniResBase.getResType();
            }
            case 24: {
                return pSSysUniResBase.getTestCustomCode();
            }
            case 25: {
                return pSSysUniResBase.getTestCustomMode();
            }
            case 26: {
                return pSSysUniResBase.getUpdateDate();
            }
            case 27: {
                return pSSysUniResBase.getUpdateMan();
            }
            case 28: {
                return pSSysUniResBase.getUserCat();
            }
            case 29: {
                return pSSysUniResBase.getUserTag();
            }
            case 30: {
                return pSSysUniResBase.getUserTag2();
            }
            case 31: {
                return pSSysUniResBase.getUserTag3();
            }
            case 32: {
                return pSSysUniResBase.getUserTag4();
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
        PSSysUniResBase.set(this, n, object);
    }

    private static void set(PSSysUniResBase pSSysUniResBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysUniResBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysUniResBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysUniResBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSysUniResBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysUniResBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysUniResBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysUniResBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysUniResBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysUniResBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysUniResBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysUniResBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysUniResBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysUniResBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysUniResBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysUniResBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysUniResBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysUniResBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysUniResBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysUniResBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysUniResBase.setResCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysUniResBase.setResModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysUniResBase.setResTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysUniResBase.setResTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysUniResBase.setResType(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysUniResBase.setTestCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysUniResBase.setTestCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSSysUniResBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSSysUniResBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysUniResBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysUniResBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysUniResBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysUniResBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysUniResBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysUniResBase.isNull(this, n);
    }

    private static boolean isNull(PSSysUniResBase pSSysUniResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUniResBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysUniResBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysUniResBase.getDynaModelFlag() == null;
            }
            case 3: {
                return pSSysUniResBase.getLockFlag() == null;
            }
            case 4: {
                return pSSysUniResBase.getMemo() == null;
            }
            case 5: {
                return pSSysUniResBase.getPSModuleId() == null;
            }
            case 6: {
                return pSSysUniResBase.getPSModuleName() == null;
            }
            case 7: {
                return pSSysUniResBase.getPSSysAppId() == null;
            }
            case 8: {
                return pSSysUniResBase.getPSSysAppName() == null;
            }
            case 9: {
                return pSSysUniResBase.getPSSysDynaModelId() == null;
            }
            case 10: {
                return pSSysUniResBase.getPSSysDynaModelName() == null;
            }
            case 11: {
                return pSSysUniResBase.getPSSysServiceAPIId() == null;
            }
            case 12: {
                return pSSysUniResBase.getPSSysServiceAPIName() == null;
            }
            case 13: {
                return pSSysUniResBase.getPSSysSFPluginId() == null;
            }
            case 14: {
                return pSSysUniResBase.getPSSysSFPluginName() == null;
            }
            case 15: {
                return pSSysUniResBase.getPSSystemId() == null;
            }
            case 16: {
                return pSSysUniResBase.getPSSystemName() == null;
            }
            case 17: {
                return pSSysUniResBase.getPSSysUniResId() == null;
            }
            case 18: {
                return pSSysUniResBase.getPSSysUniResName() == null;
            }
            case 19: {
                return pSSysUniResBase.getResCode() == null;
            }
            case 20: {
                return pSSysUniResBase.getResModel() == null;
            }
            case 21: {
                return pSSysUniResBase.getResTag() == null;
            }
            case 22: {
                return pSSysUniResBase.getResTag2() == null;
            }
            case 23: {
                return pSSysUniResBase.getResType() == null;
            }
            case 24: {
                return pSSysUniResBase.getTestCustomCode() == null;
            }
            case 25: {
                return pSSysUniResBase.getTestCustomMode() == null;
            }
            case 26: {
                return pSSysUniResBase.getUpdateDate() == null;
            }
            case 27: {
                return pSSysUniResBase.getUpdateMan() == null;
            }
            case 28: {
                return pSSysUniResBase.getUserCat() == null;
            }
            case 29: {
                return pSSysUniResBase.getUserTag() == null;
            }
            case 30: {
                return pSSysUniResBase.getUserTag2() == null;
            }
            case 31: {
                return pSSysUniResBase.getUserTag3() == null;
            }
            case 32: {
                return pSSysUniResBase.getUserTag4() == null;
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
        return PSSysUniResBase.contains(this, n);
    }

    private static boolean contains(PSSysUniResBase pSSysUniResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUniResBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysUniResBase.isCreateManDirty();
            }
            case 2: {
                return pSSysUniResBase.isDynaModelFlagDirty();
            }
            case 3: {
                return pSSysUniResBase.isLockFlagDirty();
            }
            case 4: {
                return pSSysUniResBase.isMemoDirty();
            }
            case 5: {
                return pSSysUniResBase.isPSModuleIdDirty();
            }
            case 6: {
                return pSSysUniResBase.isPSModuleNameDirty();
            }
            case 7: {
                return pSSysUniResBase.isPSSysAppIdDirty();
            }
            case 8: {
                return pSSysUniResBase.isPSSysAppNameDirty();
            }
            case 9: {
                return pSSysUniResBase.isPSSysDynaModelIdDirty();
            }
            case 10: {
                return pSSysUniResBase.isPSSysDynaModelNameDirty();
            }
            case 11: {
                return pSSysUniResBase.isPSSysServiceAPIIdDirty();
            }
            case 12: {
                return pSSysUniResBase.isPSSysServiceAPINameDirty();
            }
            case 13: {
                return pSSysUniResBase.isPSSysSFPluginIdDirty();
            }
            case 14: {
                return pSSysUniResBase.isPSSysSFPluginNameDirty();
            }
            case 15: {
                return pSSysUniResBase.isPSSystemIdDirty();
            }
            case 16: {
                return pSSysUniResBase.isPSSystemNameDirty();
            }
            case 17: {
                return pSSysUniResBase.isPSSysUniResIdDirty();
            }
            case 18: {
                return pSSysUniResBase.isPSSysUniResNameDirty();
            }
            case 19: {
                return pSSysUniResBase.isResCodeDirty();
            }
            case 20: {
                return pSSysUniResBase.isResModelDirty();
            }
            case 21: {
                return pSSysUniResBase.isResTagDirty();
            }
            case 22: {
                return pSSysUniResBase.isResTag2Dirty();
            }
            case 23: {
                return pSSysUniResBase.isResTypeDirty();
            }
            case 24: {
                return pSSysUniResBase.isTestCustomCodeDirty();
            }
            case 25: {
                return pSSysUniResBase.isTestCustomModeDirty();
            }
            case 26: {
                return pSSysUniResBase.isUpdateDateDirty();
            }
            case 27: {
                return pSSysUniResBase.isUpdateManDirty();
            }
            case 28: {
                return pSSysUniResBase.isUserCatDirty();
            }
            case 29: {
                return pSSysUniResBase.isUserTagDirty();
            }
            case 30: {
                return pSSysUniResBase.isUserTag2Dirty();
            }
            case 31: {
                return pSSysUniResBase.isUserTag3Dirty();
            }
            case 32: {
                return pSSysUniResBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysUniResBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysUniResBase pSSysUniResBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysUniResBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getResCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rescode", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getResCode()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getResModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resmodel", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getResModel()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getResTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restag", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getResTag()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getResTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restag2", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getResTag2()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getResType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restype", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getResType()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getTestCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testcustomcode", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getTestCustomCode()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getTestCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testcustommode", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getTestCustomMode()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysUniResBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysUniResBase.getJSONValue((Object)pSSysUniResBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysUniResBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysUniResBase pSSysUniResBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysUniResBase.getCreateDate() != null) {
            object = pSSysUniResBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUniResBase.getCreateMan() != null) {
            object = pSSysUniResBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getDynaModelFlag() != null) {
            object = pSSysUniResBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUniResBase.getLockFlag() != null) {
            object = pSSysUniResBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUniResBase.getMemo() != null) {
            object = pSSysUniResBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getPSModuleId() != null) {
            object = pSSysUniResBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getPSModuleName() != null) {
            object = pSSysUniResBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getPSSysAppId() != null) {
            object = pSSysUniResBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getPSSysAppName() != null) {
            object = pSSysUniResBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getPSSysDynaModelId() != null) {
            object = pSSysUniResBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getPSSysDynaModelName() != null) {
            object = pSSysUniResBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getPSSysServiceAPIId() != null) {
            object = pSSysUniResBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getPSSysServiceAPIName() != null) {
            object = pSSysUniResBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getPSSysSFPluginId() != null) {
            object = pSSysUniResBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getPSSysSFPluginName() != null) {
            object = pSSysUniResBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getPSSystemId() != null) {
            object = pSSysUniResBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getPSSystemName() != null) {
            object = pSSysUniResBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getPSSysUniResId() != null) {
            object = pSSysUniResBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getPSSysUniResName() != null) {
            object = pSSysUniResBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getResCode() != null) {
            object = pSSysUniResBase.getResCode();
            xmlNode.setAttribute(FIELD_RESCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getResModel() != null) {
            object = pSSysUniResBase.getResModel();
            xmlNode.setAttribute(FIELD_RESMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getResTag() != null) {
            object = pSSysUniResBase.getResTag();
            xmlNode.setAttribute(FIELD_RESTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getResTag2() != null) {
            object = pSSysUniResBase.getResTag2();
            xmlNode.setAttribute(FIELD_RESTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getResType() != null) {
            object = pSSysUniResBase.getResType();
            xmlNode.setAttribute(FIELD_RESTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getTestCustomCode() != null) {
            object = pSSysUniResBase.getTestCustomCode();
            xmlNode.setAttribute(FIELD_TESTCUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getTestCustomMode() != null) {
            object = pSSysUniResBase.getTestCustomMode();
            xmlNode.setAttribute(FIELD_TESTCUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUniResBase.getUpdateDate() != null) {
            object = pSSysUniResBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUniResBase.getUpdateMan() != null) {
            object = pSSysUniResBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getUserCat() != null) {
            object = pSSysUniResBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getUserTag() != null) {
            object = pSSysUniResBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getUserTag2() != null) {
            object = pSSysUniResBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getUserTag3() != null) {
            object = pSSysUniResBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUniResBase.getUserTag4() != null) {
            object = pSSysUniResBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysUniResBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysUniResBase pSSysUniResBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysUniResBase.isCreateDateDirty() && (bl || pSSysUniResBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysUniResBase.getCreateDate());
        }
        if (pSSysUniResBase.isCreateManDirty() && (bl || pSSysUniResBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysUniResBase.getCreateMan());
        }
        if (pSSysUniResBase.isDynaModelFlagDirty() && (bl || pSSysUniResBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSSysUniResBase.getDynaModelFlag());
        }
        if (pSSysUniResBase.isLockFlagDirty() && (bl || pSSysUniResBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysUniResBase.getLockFlag());
        }
        if (pSSysUniResBase.isMemoDirty() && (bl || pSSysUniResBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysUniResBase.getMemo());
        }
        if (pSSysUniResBase.isPSModuleIdDirty() && (bl || pSSysUniResBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysUniResBase.getPSModuleId());
        }
        if (pSSysUniResBase.isPSModuleNameDirty() && (bl || pSSysUniResBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysUniResBase.getPSModuleName());
        }
        if (pSSysUniResBase.isPSSysAppIdDirty() && (bl || pSSysUniResBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysUniResBase.getPSSysAppId());
        }
        if (pSSysUniResBase.isPSSysAppNameDirty() && (bl || pSSysUniResBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysUniResBase.getPSSysAppName());
        }
        if (pSSysUniResBase.isPSSysDynaModelIdDirty() && (bl || pSSysUniResBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysUniResBase.getPSSysDynaModelId());
        }
        if (pSSysUniResBase.isPSSysDynaModelNameDirty() && (bl || pSSysUniResBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysUniResBase.getPSSysDynaModelName());
        }
        if (pSSysUniResBase.isPSSysServiceAPIIdDirty() && (bl || pSSysUniResBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSSysUniResBase.getPSSysServiceAPIId());
        }
        if (pSSysUniResBase.isPSSysServiceAPINameDirty() && (bl || pSSysUniResBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSSysUniResBase.getPSSysServiceAPIName());
        }
        if (pSSysUniResBase.isPSSysSFPluginIdDirty() && (bl || pSSysUniResBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysUniResBase.getPSSysSFPluginId());
        }
        if (pSSysUniResBase.isPSSysSFPluginNameDirty() && (bl || pSSysUniResBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysUniResBase.getPSSysSFPluginName());
        }
        if (pSSysUniResBase.isPSSystemIdDirty() && (bl || pSSysUniResBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysUniResBase.getPSSystemId());
        }
        if (pSSysUniResBase.isPSSystemNameDirty() && (bl || pSSysUniResBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysUniResBase.getPSSystemName());
        }
        if (pSSysUniResBase.isPSSysUniResIdDirty() && (bl || pSSysUniResBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSSysUniResBase.getPSSysUniResId());
        }
        if (pSSysUniResBase.isPSSysUniResNameDirty() && (bl || pSSysUniResBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSSysUniResBase.getPSSysUniResName());
        }
        if (pSSysUniResBase.isResCodeDirty() && (bl || pSSysUniResBase.getResCode() != null)) {
            iDataObject.set(FIELD_RESCODE, (Object)pSSysUniResBase.getResCode());
        }
        if (pSSysUniResBase.isResModelDirty() && (bl || pSSysUniResBase.getResModel() != null)) {
            iDataObject.set(FIELD_RESMODEL, (Object)pSSysUniResBase.getResModel());
        }
        if (pSSysUniResBase.isResTagDirty() && (bl || pSSysUniResBase.getResTag() != null)) {
            iDataObject.set(FIELD_RESTAG, (Object)pSSysUniResBase.getResTag());
        }
        if (pSSysUniResBase.isResTag2Dirty() && (bl || pSSysUniResBase.getResTag2() != null)) {
            iDataObject.set(FIELD_RESTAG2, (Object)pSSysUniResBase.getResTag2());
        }
        if (pSSysUniResBase.isResTypeDirty() && (bl || pSSysUniResBase.getResType() != null)) {
            iDataObject.set(FIELD_RESTYPE, (Object)pSSysUniResBase.getResType());
        }
        if (pSSysUniResBase.isTestCustomCodeDirty() && (bl || pSSysUniResBase.getTestCustomCode() != null)) {
            iDataObject.set(FIELD_TESTCUSTOMCODE, (Object)pSSysUniResBase.getTestCustomCode());
        }
        if (pSSysUniResBase.isTestCustomModeDirty() && (bl || pSSysUniResBase.getTestCustomMode() != null)) {
            iDataObject.set(FIELD_TESTCUSTOMMODE, (Object)pSSysUniResBase.getTestCustomMode());
        }
        if (pSSysUniResBase.isUpdateDateDirty() && (bl || pSSysUniResBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysUniResBase.getUpdateDate());
        }
        if (pSSysUniResBase.isUpdateManDirty() && (bl || pSSysUniResBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysUniResBase.getUpdateMan());
        }
        if (pSSysUniResBase.isUserCatDirty() && (bl || pSSysUniResBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysUniResBase.getUserCat());
        }
        if (pSSysUniResBase.isUserTagDirty() && (bl || pSSysUniResBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysUniResBase.getUserTag());
        }
        if (pSSysUniResBase.isUserTag2Dirty() && (bl || pSSysUniResBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysUniResBase.getUserTag2());
        }
        if (pSSysUniResBase.isUserTag3Dirty() && (bl || pSSysUniResBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysUniResBase.getUserTag3());
        }
        if (pSSysUniResBase.isUserTag4Dirty() && (bl || pSSysUniResBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysUniResBase.getUserTag4());
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
        return PSSysUniResBase.remove(this, n);
    }

    private static boolean remove(PSSysUniResBase pSSysUniResBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysUniResBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysUniResBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysUniResBase.resetDynaModelFlag();
                return true;
            }
            case 3: {
                pSSysUniResBase.resetLockFlag();
                return true;
            }
            case 4: {
                pSSysUniResBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysUniResBase.resetPSModuleId();
                return true;
            }
            case 6: {
                pSSysUniResBase.resetPSModuleName();
                return true;
            }
            case 7: {
                pSSysUniResBase.resetPSSysAppId();
                return true;
            }
            case 8: {
                pSSysUniResBase.resetPSSysAppName();
                return true;
            }
            case 9: {
                pSSysUniResBase.resetPSSysDynaModelId();
                return true;
            }
            case 10: {
                pSSysUniResBase.resetPSSysDynaModelName();
                return true;
            }
            case 11: {
                pSSysUniResBase.resetPSSysServiceAPIId();
                return true;
            }
            case 12: {
                pSSysUniResBase.resetPSSysServiceAPIName();
                return true;
            }
            case 13: {
                pSSysUniResBase.resetPSSysSFPluginId();
                return true;
            }
            case 14: {
                pSSysUniResBase.resetPSSysSFPluginName();
                return true;
            }
            case 15: {
                pSSysUniResBase.resetPSSystemId();
                return true;
            }
            case 16: {
                pSSysUniResBase.resetPSSystemName();
                return true;
            }
            case 17: {
                pSSysUniResBase.resetPSSysUniResId();
                return true;
            }
            case 18: {
                pSSysUniResBase.resetPSSysUniResName();
                return true;
            }
            case 19: {
                pSSysUniResBase.resetResCode();
                return true;
            }
            case 20: {
                pSSysUniResBase.resetResModel();
                return true;
            }
            case 21: {
                pSSysUniResBase.resetResTag();
                return true;
            }
            case 22: {
                pSSysUniResBase.resetResTag2();
                return true;
            }
            case 23: {
                pSSysUniResBase.resetResType();
                return true;
            }
            case 24: {
                pSSysUniResBase.resetTestCustomCode();
                return true;
            }
            case 25: {
                pSSysUniResBase.resetTestCustomMode();
                return true;
            }
            case 26: {
                pSSysUniResBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSSysUniResBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSSysUniResBase.resetUserCat();
                return true;
            }
            case 29: {
                pSSysUniResBase.resetUserTag();
                return true;
            }
            case 30: {
                pSSysUniResBase.resetUserTag2();
                return true;
            }
            case 31: {
                pSSysUniResBase.resetUserTag3();
                return true;
            }
            case 32: {
                pSSysUniResBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
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
    public PSSysServiceAPI getPSSysServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPI();
        }
        if (this.getPSSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSysServiceAPILock;
        synchronized (n) {
            if (this.pssysserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysServiceAPIId(), (Object)this.pssysserviceapi.getPSSysServiceAPIId()) != 0L) {
                this.pssysserviceapi = null;
            }
            if (this.pssysserviceapi == null) {
                PSSysServiceAPI pSSysServiceAPI = new PSSysServiceAPI();
                pSSysServiceAPI.setPSSysServiceAPIId(this.getPSSysServiceAPIId());
                PSSysServiceAPIService pSSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSysServiceAPIService.autoGet(pSSysServiceAPI);
                this.pssysserviceapi = pSSysServiceAPI;
            }
            return this.pssysserviceapi;
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

    private PSSysUniResBase getProxyEntity() {
        return this.proxyPSSysUniResBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysUniResBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysUniResBase) {
            this.proxyPSSysUniResBase = (PSSysUniResBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 2);
        fieldIndexMap.put(FIELD_LOCKFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSMODULEID, 5);
        fieldIndexMap.put(FIELD_PSMODULENAME, 6);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 7);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 9);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 11);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPINAME, 12);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 13);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 15);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 17);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 18);
        fieldIndexMap.put(FIELD_RESCODE, 19);
        fieldIndexMap.put(FIELD_RESMODEL, 20);
        fieldIndexMap.put(FIELD_RESTAG, 21);
        fieldIndexMap.put(FIELD_RESTAG2, 22);
        fieldIndexMap.put(FIELD_RESTYPE, 23);
        fieldIndexMap.put(FIELD_TESTCUSTOMCODE, 24);
        fieldIndexMap.put(FIELD_TESTCUSTOMMODE, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USERCAT, 28);
        fieldIndexMap.put(FIELD_USERTAG, 29);
        fieldIndexMap.put(FIELD_USERTAG2, 30);
        fieldIndexMap.put(FIELD_USERTAG3, 31);
        fieldIndexMap.put(FIELD_USERTAG4, 32);
    }
}

