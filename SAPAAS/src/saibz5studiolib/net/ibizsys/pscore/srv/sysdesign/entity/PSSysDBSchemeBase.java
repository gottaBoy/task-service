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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBProc;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBProcService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBSchemeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDBSchemeBase.class);
    public static final String FIELD_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String FIELD_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String FIELD_AUTHMODE = "AUTHMODE";
    public static final String FIELD_AUTHPARAM = "AUTHPARAM";
    public static final String FIELD_AUTHPARAM2 = "AUTHPARAM2";
    public static final String FIELD_AUTOEXTENDMODEL = "AUTOEXTENDMODEL";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSLINK = "DSLINK";
    public static final String FIELD_ENABLESERVICEAPI = "ENABLESERVICEAPI";
    public static final String FIELD_ENABLESUBSYSSERVICEAPI = "ENABLESUBSYSSERVICEAPI";
    public static final String FIELD_EXISTINGMODEL = "EXISTINGMODEL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OBJNAMECASE = "OBJNAMECASE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSDBSCHEMEID = "PSSYSDBSCHEMEID";
    public static final String FIELD_PSSYSDBSCHEMENAME = "PSSYSDBSCHEMENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSMODELGROUPID = "PSSYSMODELGROUPID";
    public static final String FIELD_PSSYSMODELGROUPNAME = "PSSYSMODELGROUPNAME";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_SCHEMEPARAMS = "SCHEMEPARAMS";
    public static final String FIELD_SCHEMETAG = "SCHEMETAG";
    public static final String FIELD_SCHEMETAG2 = "SCHEMETAG2";
    public static final String FIELD_SERVICECODENAME = "SERVICECODENAME";
    public static final String FIELD_SERVICEPARAM = "SERVICEPARAM";
    public static final String FIELD_SERVICEPARAM2 = "SERVICEPARAM2";
    public static final String FIELD_SERVICEPATH = "SERVICEPATH";
    public static final String FIELD_SUBSYSSERVICECODENAME = "SUBSYSSERVICECODENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_AUTHCLIENTID = 0;
    private static final int INDEX_AUTHCLIENTSECRET = 1;
    private static final int INDEX_AUTHMODE = 2;
    private static final int INDEX_AUTHPARAM = 3;
    private static final int INDEX_AUTHPARAM2 = 4;
    private static final int INDEX_AUTOEXTENDMODEL = 5;
    private static final int INDEX_CODENAME = 6;
    private static final int INDEX_CODENAME2 = 7;
    private static final int INDEX_CREATEDATE = 8;
    private static final int INDEX_CREATEMAN = 9;
    private static final int INDEX_DSLINK = 10;
    private static final int INDEX_ENABLESERVICEAPI = 11;
    private static final int INDEX_ENABLESUBSYSSERVICEAPI = 12;
    private static final int INDEX_EXISTINGMODEL = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_OBJNAMECASE = 15;
    private static final int INDEX_ORDERVALUE = 16;
    private static final int INDEX_PSMODULEID = 17;
    private static final int INDEX_PSMODULENAME = 18;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 19;
    private static final int INDEX_PSSUBSYSSERVICEAPINAME = 20;
    private static final int INDEX_PSSYSDBSCHEMEID = 21;
    private static final int INDEX_PSSYSDBSCHEMENAME = 22;
    private static final int INDEX_PSSYSDYNAMODELID = 23;
    private static final int INDEX_PSSYSDYNAMODELNAME = 24;
    private static final int INDEX_PSSYSMODELGROUPID = 25;
    private static final int INDEX_PSSYSMODELGROUPNAME = 26;
    private static final int INDEX_PSSYSSERVICEAPIID = 27;
    private static final int INDEX_PSSYSSERVICEAPINAME = 28;
    private static final int INDEX_PSSYSSFPLUGINID = 29;
    private static final int INDEX_PSSYSSFPLUGINNAME = 30;
    private static final int INDEX_PSSYSTEMID = 31;
    private static final int INDEX_PSSYSTEMNAME = 32;
    private static final int INDEX_SCHEMEPARAMS = 33;
    private static final int INDEX_SCHEMETAG = 34;
    private static final int INDEX_SCHEMETAG2 = 35;
    private static final int INDEX_SERVICECODENAME = 36;
    private static final int INDEX_SERVICEPARAM = 37;
    private static final int INDEX_SERVICEPARAM2 = 38;
    private static final int INDEX_SERVICEPATH = 39;
    private static final int INDEX_SUBSYSSERVICECODENAME = 40;
    private static final int INDEX_UPDATEDATE = 41;
    private static final int INDEX_UPDATEMAN = 42;
    private static final int INDEX_USERCAT = 43;
    private static final int INDEX_USERTAG = 44;
    private static final int INDEX_USERTAG2 = 45;
    private static final int INDEX_USERTAG3 = 46;
    private static final int INDEX_USERTAG4 = 47;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDBSchemeBase proxyPSSysDBSchemeBase = null;
    private boolean authclientidDirtyFlag = false;
    private boolean authclientsecretDirtyFlag = false;
    private boolean authmodeDirtyFlag = false;
    private boolean authparamDirtyFlag = false;
    private boolean authparam2DirtyFlag = false;
    private boolean autoextendmodelDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dslinkDirtyFlag = false;
    private boolean enableserviceapiDirtyFlag = false;
    private boolean enablesubsysserviceapiDirtyFlag = false;
    private boolean existingmodelDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean objnamecaseDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssubsysserviceapinameDirtyFlag = false;
    private boolean pssysdbschemeidDirtyFlag = false;
    private boolean pssysdbschemenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysmodelgroupidDirtyFlag = false;
    private boolean pssysmodelgroupnameDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean pssysserviceapinameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean schemeparamsDirtyFlag = false;
    private boolean schemetagDirtyFlag = false;
    private boolean schemetag2DirtyFlag = false;
    private boolean servicecodenameDirtyFlag = false;
    private boolean serviceparamDirtyFlag = false;
    private boolean serviceparam2DirtyFlag = false;
    private boolean servicepathDirtyFlag = false;
    private boolean subsysservicecodenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="authclientid")
    private String authclientid;
    @Column(name="authclientsecret")
    private String authclientsecret;
    @Column(name="authmode")
    private String authmode;
    @Column(name="authparam")
    private String authparam;
    @Column(name="authparam2")
    private String authparam2;
    @Column(name="autoextendmodel")
    private Integer autoextendmodel;
    @Column(name="codename")
    private String codename;
    @Column(name="codename2")
    private String codename2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dslink")
    private String dslink;
    @Column(name="enableserviceapi")
    private Integer enableserviceapi;
    @Column(name="enablesubsysserviceapi")
    private Integer enablesubsysserviceapi;
    @Column(name="existingmodel")
    private Integer existingmodel;
    @Column(name="memo")
    private String memo;
    @Column(name="objnamecase")
    private String objnamecase;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssubsysserviceapiid")
    private String pssubsysserviceapiid;
    @Column(name="pssubsysserviceapiname")
    private String pssubsysserviceapiname;
    @Column(name="pssysdbschemeid")
    private String pssysdbschemeid;
    @Column(name="pssysdbschemename")
    private String pssysdbschemename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysmodelgroupid")
    private String pssysmodelgroupid;
    @Column(name="pssysmodelgroupname")
    private String pssysmodelgroupname;
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
    @Column(name="schemeparams")
    private String schemeparams;
    @Column(name="schemetag")
    private String schemetag;
    @Column(name="schemetag2")
    private String schemetag2;
    @Column(name="servicecodename")
    private String servicecodename;
    @Column(name="serviceparam")
    private String serviceparam;
    @Column(name="serviceparam2")
    private String serviceparam2;
    @Column(name="servicepath")
    private String servicepath;
    @Column(name="subsysservicecodename")
    private String subsysservicecodename;
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
    private Integer objPSSubSysServiceAPILock = new Integer(1);
    private PSSubSysServiceAPI pssubsysserviceapi = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysModelGroupLock = new Integer(1);
    private PSSysModelGroup pssysmodelgroup = null;
    private Integer objPSSysServiceAPILock = new Integer(1);
    private PSSysServiceAPI pssysserviceapi = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysDBProcsLock = new Integer(1);
    private ArrayList<PSSysDBProc> pssysdbprocs = null;
    private Integer objPSSysDBTablesLock = new Integer(1);
    private ArrayList<PSSysDBTable> pssysdbtables = null;

    public void setAuthClientId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthClientId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authclientid = string;
        this.authclientidDirtyFlag = true;
    }

    public String getAuthClientId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthClientId();
        }
        return this.authclientid;
    }

    public boolean isAuthClientIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthClientIdDirty();
        }
        return this.authclientidDirtyFlag;
    }

    public void resetAuthClientId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthClientId();
            return;
        }
        this.authclientidDirtyFlag = false;
        this.authclientid = null;
    }

    public void setAuthClientSecret(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthClientSecret(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authclientsecret = string;
        this.authclientsecretDirtyFlag = true;
    }

    public String getAuthClientSecret() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthClientSecret();
        }
        return this.authclientsecret;
    }

    public boolean isAuthClientSecretDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthClientSecretDirty();
        }
        return this.authclientsecretDirtyFlag;
    }

    public void resetAuthClientSecret() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthClientSecret();
            return;
        }
        this.authclientsecretDirtyFlag = false;
        this.authclientsecret = null;
    }

    public void setAuthMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authmode = string;
        this.authmodeDirtyFlag = true;
    }

    public String getAuthMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthMode();
        }
        return this.authmode;
    }

    public boolean isAuthModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthModeDirty();
        }
        return this.authmodeDirtyFlag;
    }

    public void resetAuthMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthMode();
            return;
        }
        this.authmodeDirtyFlag = false;
        this.authmode = null;
    }

    public void setAuthParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authparam = string;
        this.authparamDirtyFlag = true;
    }

    public String getAuthParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthParam();
        }
        return this.authparam;
    }

    public boolean isAuthParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthParamDirty();
        }
        return this.authparamDirtyFlag;
    }

    public void resetAuthParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthParam();
            return;
        }
        this.authparamDirtyFlag = false;
        this.authparam = null;
    }

    public void setAuthParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authparam2 = string;
        this.authparam2DirtyFlag = true;
    }

    public String getAuthParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthParam2();
        }
        return this.authparam2;
    }

    public boolean isAuthParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthParam2Dirty();
        }
        return this.authparam2DirtyFlag;
    }

    public void resetAuthParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthParam2();
            return;
        }
        this.authparam2DirtyFlag = false;
        this.authparam2 = null;
    }

    public void setAutoExtendModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAutoExtendModel(n);
            return;
        }
        this.autoextendmodel = n;
        this.autoextendmodelDirtyFlag = true;
    }

    public Integer getAutoExtendModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAutoExtendModel();
        }
        return this.autoextendmodel;
    }

    public boolean isAutoExtendModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAutoExtendModelDirty();
        }
        return this.autoextendmodelDirtyFlag;
    }

    public void resetAutoExtendModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAutoExtendModel();
            return;
        }
        this.autoextendmodelDirtyFlag = false;
        this.autoextendmodel = null;
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

    public void setCodeName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename2 = string;
        this.codename2DirtyFlag = true;
    }

    public String getCodeName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName2();
        }
        return this.codename2;
    }

    public boolean isCodeName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeName2Dirty();
        }
        return this.codename2DirtyFlag;
    }

    public void resetCodeName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName2();
            return;
        }
        this.codename2DirtyFlag = false;
        this.codename2 = null;
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

    public void setDSLink(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSLink(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dslink = string;
        this.dslinkDirtyFlag = true;
    }

    public String getDSLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSLink();
        }
        return this.dslink;
    }

    public boolean isDSLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSLinkDirty();
        }
        return this.dslinkDirtyFlag;
    }

    public void resetDSLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSLink();
            return;
        }
        this.dslinkDirtyFlag = false;
        this.dslink = null;
    }

    public void setEnableServiceAPI(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableServiceAPI(n);
            return;
        }
        this.enableserviceapi = n;
        this.enableserviceapiDirtyFlag = true;
    }

    public Integer getEnableServiceAPI() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableServiceAPI();
        }
        return this.enableserviceapi;
    }

    public boolean isEnableServiceAPIDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableServiceAPIDirty();
        }
        return this.enableserviceapiDirtyFlag;
    }

    public void resetEnableServiceAPI() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableServiceAPI();
            return;
        }
        this.enableserviceapiDirtyFlag = false;
        this.enableserviceapi = null;
    }

    public void setEnableSubSysServiceAPI(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableSubSysServiceAPI(n);
            return;
        }
        this.enablesubsysserviceapi = n;
        this.enablesubsysserviceapiDirtyFlag = true;
    }

    public Integer getEnableSubSysServiceAPI() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableSubSysServiceAPI();
        }
        return this.enablesubsysserviceapi;
    }

    public boolean isEnableSubSysServiceAPIDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableSubSysServiceAPIDirty();
        }
        return this.enablesubsysserviceapiDirtyFlag;
    }

    public void resetEnableSubSysServiceAPI() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableSubSysServiceAPI();
            return;
        }
        this.enablesubsysserviceapiDirtyFlag = false;
        this.enablesubsysserviceapi = null;
    }

    public void setExistingModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExistingModel(n);
            return;
        }
        this.existingmodel = n;
        this.existingmodelDirtyFlag = true;
    }

    public Integer getExistingModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExistingModel();
        }
        return this.existingmodel;
    }

    public boolean isExistingModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExistingModelDirty();
        }
        return this.existingmodelDirtyFlag;
    }

    public void resetExistingModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExistingModel();
            return;
        }
        this.existingmodelDirtyFlag = false;
        this.existingmodel = null;
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

    public void setObjNameCase(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjNameCase(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.objnamecase = string;
        this.objnamecaseDirtyFlag = true;
    }

    public String getObjNameCase() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjNameCase();
        }
        return this.objnamecase;
    }

    public boolean isObjNameCaseDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjNameCaseDirty();
        }
        return this.objnamecaseDirtyFlag;
    }

    public void resetObjNameCase() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjNameCase();
            return;
        }
        this.objnamecaseDirtyFlag = false;
        this.objnamecase = null;
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

    public void setPSSubSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiid = string;
        this.pssubsysserviceapiidDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIId();
        }
        return this.pssubsysserviceapiid;
    }

    public boolean isPSSubSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPIIdDirty();
        }
        return this.pssubsysserviceapiidDirtyFlag;
    }

    public void resetPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIId();
            return;
        }
        this.pssubsysserviceapiidDirtyFlag = false;
        this.pssubsysserviceapiid = null;
    }

    public void setPSSubSysServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiname = string;
        this.pssubsysserviceapinameDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIName();
        }
        return this.pssubsysserviceapiname;
    }

    public boolean isPSSubSysServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPINameDirty();
        }
        return this.pssubsysserviceapinameDirtyFlag;
    }

    public void resetPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIName();
            return;
        }
        this.pssubsysserviceapinameDirtyFlag = false;
        this.pssubsysserviceapiname = null;
    }

    public void setPSSysDBSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbschemeid = string;
        this.pssysdbschemeidDirtyFlag = true;
    }

    public String getPSSysDBSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBSchemeId();
        }
        return this.pssysdbschemeid;
    }

    public boolean isPSSysDBSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBSchemeIdDirty();
        }
        return this.pssysdbschemeidDirtyFlag;
    }

    public void resetPSSysDBSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBSchemeId();
            return;
        }
        this.pssysdbschemeidDirtyFlag = false;
        this.pssysdbschemeid = null;
    }

    public void setPSSysDBSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbschemename = string;
        this.pssysdbschemenameDirtyFlag = true;
    }

    public String getPSSysDBSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBSchemeName();
        }
        return this.pssysdbschemename;
    }

    public boolean isPSSysDBSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBSchemeNameDirty();
        }
        return this.pssysdbschemenameDirtyFlag;
    }

    public void resetPSSysDBSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBSchemeName();
            return;
        }
        this.pssysdbschemenameDirtyFlag = false;
        this.pssysdbschemename = null;
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

    public void setPSSysModelGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelgroupid = string;
        this.pssysmodelgroupidDirtyFlag = true;
    }

    public String getPSSysModelGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelGroupId();
        }
        return this.pssysmodelgroupid;
    }

    public boolean isPSSysModelGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelGroupIdDirty();
        }
        return this.pssysmodelgroupidDirtyFlag;
    }

    public void resetPSSysModelGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelGroupId();
            return;
        }
        this.pssysmodelgroupidDirtyFlag = false;
        this.pssysmodelgroupid = null;
    }

    public void setPSSysModelGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelgroupname = string;
        this.pssysmodelgroupnameDirtyFlag = true;
    }

    public String getPSSysModelGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelGroupName();
        }
        return this.pssysmodelgroupname;
    }

    public boolean isPSSysModelGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelGroupNameDirty();
        }
        return this.pssysmodelgroupnameDirtyFlag;
    }

    public void resetPSSysModelGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelGroupName();
            return;
        }
        this.pssysmodelgroupnameDirtyFlag = false;
        this.pssysmodelgroupname = null;
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

    public void setSchemeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSchemeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.schemeparams = string;
        this.schemeparamsDirtyFlag = true;
    }

    public String getSchemeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSchemeParams();
        }
        return this.schemeparams;
    }

    public boolean isSchemeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSchemeParamsDirty();
        }
        return this.schemeparamsDirtyFlag;
    }

    public void resetSchemeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSchemeParams();
            return;
        }
        this.schemeparamsDirtyFlag = false;
        this.schemeparams = null;
    }

    public void setSchemeTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSchemeTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.schemetag = string;
        this.schemetagDirtyFlag = true;
    }

    public String getSchemeTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSchemeTag();
        }
        return this.schemetag;
    }

    public boolean isSchemeTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSchemeTagDirty();
        }
        return this.schemetagDirtyFlag;
    }

    public void resetSchemeTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSchemeTag();
            return;
        }
        this.schemetagDirtyFlag = false;
        this.schemetag = null;
    }

    public void setSchemeTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSchemeTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.schemetag2 = string;
        this.schemetag2DirtyFlag = true;
    }

    public String getSchemeTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSchemeTag2();
        }
        return this.schemetag2;
    }

    public boolean isSchemeTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSchemeTag2Dirty();
        }
        return this.schemetag2DirtyFlag;
    }

    public void resetSchemeTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSchemeTag2();
            return;
        }
        this.schemetag2DirtyFlag = false;
        this.schemetag2 = null;
    }

    public void setServiceCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicecodename = string;
        this.servicecodenameDirtyFlag = true;
    }

    public String getServiceCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceCodeName();
        }
        return this.servicecodename;
    }

    public boolean isServiceCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceCodeNameDirty();
        }
        return this.servicecodenameDirtyFlag;
    }

    public void resetServiceCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceCodeName();
            return;
        }
        this.servicecodenameDirtyFlag = false;
        this.servicecodename = null;
    }

    public void setServiceParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceparam = string;
        this.serviceparamDirtyFlag = true;
    }

    public String getServiceParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceParam();
        }
        return this.serviceparam;
    }

    public boolean isServiceParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceParamDirty();
        }
        return this.serviceparamDirtyFlag;
    }

    public void resetServiceParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceParam();
            return;
        }
        this.serviceparamDirtyFlag = false;
        this.serviceparam = null;
    }

    public void setServiceParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceparam2 = string;
        this.serviceparam2DirtyFlag = true;
    }

    public String getServiceParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceParam2();
        }
        return this.serviceparam2;
    }

    public boolean isServiceParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceParam2Dirty();
        }
        return this.serviceparam2DirtyFlag;
    }

    public void resetServiceParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceParam2();
            return;
        }
        this.serviceparam2DirtyFlag = false;
        this.serviceparam2 = null;
    }

    public void setServicePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServicePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicepath = string;
        this.servicepathDirtyFlag = true;
    }

    public String getServicePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServicePath();
        }
        return this.servicepath;
    }

    public boolean isServicePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServicePathDirty();
        }
        return this.servicepathDirtyFlag;
    }

    public void resetServicePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServicePath();
            return;
        }
        this.servicepathDirtyFlag = false;
        this.servicepath = null;
    }

    public void setSubSysServiceCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubSysServiceCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subsysservicecodename = string;
        this.subsysservicecodenameDirtyFlag = true;
    }

    public String getSubSysServiceCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubSysServiceCodeName();
        }
        return this.subsysservicecodename;
    }

    public boolean isSubSysServiceCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubSysServiceCodeNameDirty();
        }
        return this.subsysservicecodenameDirtyFlag;
    }

    public void resetSubSysServiceCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubSysServiceCodeName();
            return;
        }
        this.subsysservicecodenameDirtyFlag = false;
        this.subsysservicecodename = null;
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
        PSSysDBSchemeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDBSchemeBase pSSysDBSchemeBase) {
        pSSysDBSchemeBase.resetAuthClientId();
        pSSysDBSchemeBase.resetAuthClientSecret();
        pSSysDBSchemeBase.resetAuthMode();
        pSSysDBSchemeBase.resetAuthParam();
        pSSysDBSchemeBase.resetAuthParam2();
        pSSysDBSchemeBase.resetAutoExtendModel();
        pSSysDBSchemeBase.resetCodeName();
        pSSysDBSchemeBase.resetCodeName2();
        pSSysDBSchemeBase.resetCreateDate();
        pSSysDBSchemeBase.resetCreateMan();
        pSSysDBSchemeBase.resetDSLink();
        pSSysDBSchemeBase.resetEnableServiceAPI();
        pSSysDBSchemeBase.resetEnableSubSysServiceAPI();
        pSSysDBSchemeBase.resetExistingModel();
        pSSysDBSchemeBase.resetMemo();
        pSSysDBSchemeBase.resetObjNameCase();
        pSSysDBSchemeBase.resetOrderValue();
        pSSysDBSchemeBase.resetPSModuleId();
        pSSysDBSchemeBase.resetPSModuleName();
        pSSysDBSchemeBase.resetPSSubSysServiceAPIId();
        pSSysDBSchemeBase.resetPSSubSysServiceAPIName();
        pSSysDBSchemeBase.resetPSSysDBSchemeId();
        pSSysDBSchemeBase.resetPSSysDBSchemeName();
        pSSysDBSchemeBase.resetPSSysDynaModelId();
        pSSysDBSchemeBase.resetPSSysDynaModelName();
        pSSysDBSchemeBase.resetPSSysModelGroupId();
        pSSysDBSchemeBase.resetPSSysModelGroupName();
        pSSysDBSchemeBase.resetPSSysServiceAPIId();
        pSSysDBSchemeBase.resetPSSysServiceAPIName();
        pSSysDBSchemeBase.resetPSSysSFPluginId();
        pSSysDBSchemeBase.resetPSSysSFPluginName();
        pSSysDBSchemeBase.resetPSSystemId();
        pSSysDBSchemeBase.resetPSSystemName();
        pSSysDBSchemeBase.resetSchemeParams();
        pSSysDBSchemeBase.resetSchemeTag();
        pSSysDBSchemeBase.resetSchemeTag2();
        pSSysDBSchemeBase.resetServiceCodeName();
        pSSysDBSchemeBase.resetServiceParam();
        pSSysDBSchemeBase.resetServiceParam2();
        pSSysDBSchemeBase.resetServicePath();
        pSSysDBSchemeBase.resetSubSysServiceCodeName();
        pSSysDBSchemeBase.resetUpdateDate();
        pSSysDBSchemeBase.resetUpdateMan();
        pSSysDBSchemeBase.resetUserCat();
        pSSysDBSchemeBase.resetUserTag();
        pSSysDBSchemeBase.resetUserTag2();
        pSSysDBSchemeBase.resetUserTag3();
        pSSysDBSchemeBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAuthClientIdDirty()) {
            hashMap.put(FIELD_AUTHCLIENTID, this.getAuthClientId());
        }
        if (!bl || this.isAuthClientSecretDirty()) {
            hashMap.put(FIELD_AUTHCLIENTSECRET, this.getAuthClientSecret());
        }
        if (!bl || this.isAuthModeDirty()) {
            hashMap.put(FIELD_AUTHMODE, this.getAuthMode());
        }
        if (!bl || this.isAuthParamDirty()) {
            hashMap.put(FIELD_AUTHPARAM, this.getAuthParam());
        }
        if (!bl || this.isAuthParam2Dirty()) {
            hashMap.put(FIELD_AUTHPARAM2, this.getAuthParam2());
        }
        if (!bl || this.isAutoExtendModelDirty()) {
            hashMap.put(FIELD_AUTOEXTENDMODEL, this.getAutoExtendModel());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeName2Dirty()) {
            hashMap.put(FIELD_CODENAME2, this.getCodeName2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDSLinkDirty()) {
            hashMap.put(FIELD_DSLINK, this.getDSLink());
        }
        if (!bl || this.isEnableServiceAPIDirty()) {
            hashMap.put(FIELD_ENABLESERVICEAPI, this.getEnableServiceAPI());
        }
        if (!bl || this.isEnableSubSysServiceAPIDirty()) {
            hashMap.put(FIELD_ENABLESUBSYSSERVICEAPI, this.getEnableSubSysServiceAPI());
        }
        if (!bl || this.isExistingModelDirty()) {
            hashMap.put(FIELD_EXISTINGMODEL, this.getExistingModel());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isObjNameCaseDirty()) {
            hashMap.put(FIELD_OBJNAMECASE, this.getObjNameCase());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSubSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPIID, this.getPSSubSysServiceAPIId());
        }
        if (!bl || this.isPSSubSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPINAME, this.getPSSubSysServiceAPIName());
        }
        if (!bl || this.isPSSysDBSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSDBSCHEMEID, this.getPSSysDBSchemeId());
        }
        if (!bl || this.isPSSysDBSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSDBSCHEMENAME, this.getPSSysDBSchemeName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysModelGroupIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELGROUPID, this.getPSSysModelGroupId());
        }
        if (!bl || this.isPSSysModelGroupNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELGROUPNAME, this.getPSSysModelGroupName());
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
        if (!bl || this.isSchemeParamsDirty()) {
            hashMap.put(FIELD_SCHEMEPARAMS, this.getSchemeParams());
        }
        if (!bl || this.isSchemeTagDirty()) {
            hashMap.put(FIELD_SCHEMETAG, this.getSchemeTag());
        }
        if (!bl || this.isSchemeTag2Dirty()) {
            hashMap.put(FIELD_SCHEMETAG2, this.getSchemeTag2());
        }
        if (!bl || this.isServiceCodeNameDirty()) {
            hashMap.put(FIELD_SERVICECODENAME, this.getServiceCodeName());
        }
        if (!bl || this.isServiceParamDirty()) {
            hashMap.put(FIELD_SERVICEPARAM, this.getServiceParam());
        }
        if (!bl || this.isServiceParam2Dirty()) {
            hashMap.put(FIELD_SERVICEPARAM2, this.getServiceParam2());
        }
        if (!bl || this.isServicePathDirty()) {
            hashMap.put(FIELD_SERVICEPATH, this.getServicePath());
        }
        if (!bl || this.isSubSysServiceCodeNameDirty()) {
            hashMap.put(FIELD_SUBSYSSERVICECODENAME, this.getSubSysServiceCodeName());
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
        return PSSysDBSchemeBase.get(this, n);
    }

    private static Object get(PSSysDBSchemeBase pSSysDBSchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBSchemeBase.getAuthClientId();
            }
            case 1: {
                return pSSysDBSchemeBase.getAuthClientSecret();
            }
            case 2: {
                return pSSysDBSchemeBase.getAuthMode();
            }
            case 3: {
                return pSSysDBSchemeBase.getAuthParam();
            }
            case 4: {
                return pSSysDBSchemeBase.getAuthParam2();
            }
            case 5: {
                return pSSysDBSchemeBase.getAutoExtendModel();
            }
            case 6: {
                return pSSysDBSchemeBase.getCodeName();
            }
            case 7: {
                return pSSysDBSchemeBase.getCodeName2();
            }
            case 8: {
                return pSSysDBSchemeBase.getCreateDate();
            }
            case 9: {
                return pSSysDBSchemeBase.getCreateMan();
            }
            case 10: {
                return pSSysDBSchemeBase.getDSLink();
            }
            case 11: {
                return pSSysDBSchemeBase.getEnableServiceAPI();
            }
            case 12: {
                return pSSysDBSchemeBase.getEnableSubSysServiceAPI();
            }
            case 13: {
                return pSSysDBSchemeBase.getExistingModel();
            }
            case 14: {
                return pSSysDBSchemeBase.getMemo();
            }
            case 15: {
                return pSSysDBSchemeBase.getObjNameCase();
            }
            case 16: {
                return pSSysDBSchemeBase.getOrderValue();
            }
            case 17: {
                return pSSysDBSchemeBase.getPSModuleId();
            }
            case 18: {
                return pSSysDBSchemeBase.getPSModuleName();
            }
            case 19: {
                return pSSysDBSchemeBase.getPSSubSysServiceAPIId();
            }
            case 20: {
                return pSSysDBSchemeBase.getPSSubSysServiceAPIName();
            }
            case 21: {
                return pSSysDBSchemeBase.getPSSysDBSchemeId();
            }
            case 22: {
                return pSSysDBSchemeBase.getPSSysDBSchemeName();
            }
            case 23: {
                return pSSysDBSchemeBase.getPSSysDynaModelId();
            }
            case 24: {
                return pSSysDBSchemeBase.getPSSysDynaModelName();
            }
            case 25: {
                return pSSysDBSchemeBase.getPSSysModelGroupId();
            }
            case 26: {
                return pSSysDBSchemeBase.getPSSysModelGroupName();
            }
            case 27: {
                return pSSysDBSchemeBase.getPSSysServiceAPIId();
            }
            case 28: {
                return pSSysDBSchemeBase.getPSSysServiceAPIName();
            }
            case 29: {
                return pSSysDBSchemeBase.getPSSysSFPluginId();
            }
            case 30: {
                return pSSysDBSchemeBase.getPSSysSFPluginName();
            }
            case 31: {
                return pSSysDBSchemeBase.getPSSystemId();
            }
            case 32: {
                return pSSysDBSchemeBase.getPSSystemName();
            }
            case 33: {
                return pSSysDBSchemeBase.getSchemeParams();
            }
            case 34: {
                return pSSysDBSchemeBase.getSchemeTag();
            }
            case 35: {
                return pSSysDBSchemeBase.getSchemeTag2();
            }
            case 36: {
                return pSSysDBSchemeBase.getServiceCodeName();
            }
            case 37: {
                return pSSysDBSchemeBase.getServiceParam();
            }
            case 38: {
                return pSSysDBSchemeBase.getServiceParam2();
            }
            case 39: {
                return pSSysDBSchemeBase.getServicePath();
            }
            case 40: {
                return pSSysDBSchemeBase.getSubSysServiceCodeName();
            }
            case 41: {
                return pSSysDBSchemeBase.getUpdateDate();
            }
            case 42: {
                return pSSysDBSchemeBase.getUpdateMan();
            }
            case 43: {
                return pSSysDBSchemeBase.getUserCat();
            }
            case 44: {
                return pSSysDBSchemeBase.getUserTag();
            }
            case 45: {
                return pSSysDBSchemeBase.getUserTag2();
            }
            case 46: {
                return pSSysDBSchemeBase.getUserTag3();
            }
            case 47: {
                return pSSysDBSchemeBase.getUserTag4();
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
        PSSysDBSchemeBase.set(this, n, object);
    }

    private static void set(PSSysDBSchemeBase pSSysDBSchemeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBSchemeBase.setAuthClientId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysDBSchemeBase.setAuthClientSecret(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDBSchemeBase.setAuthMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDBSchemeBase.setAuthParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDBSchemeBase.setAuthParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDBSchemeBase.setAutoExtendModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysDBSchemeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDBSchemeBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDBSchemeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSSysDBSchemeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDBSchemeBase.setDSLink(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDBSchemeBase.setEnableServiceAPI(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysDBSchemeBase.setEnableSubSysServiceAPI(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSysDBSchemeBase.setExistingModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysDBSchemeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDBSchemeBase.setObjNameCase(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDBSchemeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSysDBSchemeBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysDBSchemeBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysDBSchemeBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysDBSchemeBase.setPSSubSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysDBSchemeBase.setPSSysDBSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysDBSchemeBase.setPSSysDBSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysDBSchemeBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysDBSchemeBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysDBSchemeBase.setPSSysModelGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysDBSchemeBase.setPSSysModelGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysDBSchemeBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysDBSchemeBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysDBSchemeBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysDBSchemeBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysDBSchemeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysDBSchemeBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysDBSchemeBase.setSchemeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysDBSchemeBase.setSchemeTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysDBSchemeBase.setSchemeTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysDBSchemeBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysDBSchemeBase.setServiceParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysDBSchemeBase.setServiceParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysDBSchemeBase.setServicePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysDBSchemeBase.setSubSysServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysDBSchemeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 42: {
                pSSysDBSchemeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysDBSchemeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysDBSchemeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysDBSchemeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysDBSchemeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysDBSchemeBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysDBSchemeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDBSchemeBase pSSysDBSchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBSchemeBase.getAuthClientId() == null;
            }
            case 1: {
                return pSSysDBSchemeBase.getAuthClientSecret() == null;
            }
            case 2: {
                return pSSysDBSchemeBase.getAuthMode() == null;
            }
            case 3: {
                return pSSysDBSchemeBase.getAuthParam() == null;
            }
            case 4: {
                return pSSysDBSchemeBase.getAuthParam2() == null;
            }
            case 5: {
                return pSSysDBSchemeBase.getAutoExtendModel() == null;
            }
            case 6: {
                return pSSysDBSchemeBase.getCodeName() == null;
            }
            case 7: {
                return pSSysDBSchemeBase.getCodeName2() == null;
            }
            case 8: {
                return pSSysDBSchemeBase.getCreateDate() == null;
            }
            case 9: {
                return pSSysDBSchemeBase.getCreateMan() == null;
            }
            case 10: {
                return pSSysDBSchemeBase.getDSLink() == null;
            }
            case 11: {
                return pSSysDBSchemeBase.getEnableServiceAPI() == null;
            }
            case 12: {
                return pSSysDBSchemeBase.getEnableSubSysServiceAPI() == null;
            }
            case 13: {
                return pSSysDBSchemeBase.getExistingModel() == null;
            }
            case 14: {
                return pSSysDBSchemeBase.getMemo() == null;
            }
            case 15: {
                return pSSysDBSchemeBase.getObjNameCase() == null;
            }
            case 16: {
                return pSSysDBSchemeBase.getOrderValue() == null;
            }
            case 17: {
                return pSSysDBSchemeBase.getPSModuleId() == null;
            }
            case 18: {
                return pSSysDBSchemeBase.getPSModuleName() == null;
            }
            case 19: {
                return pSSysDBSchemeBase.getPSSubSysServiceAPIId() == null;
            }
            case 20: {
                return pSSysDBSchemeBase.getPSSubSysServiceAPIName() == null;
            }
            case 21: {
                return pSSysDBSchemeBase.getPSSysDBSchemeId() == null;
            }
            case 22: {
                return pSSysDBSchemeBase.getPSSysDBSchemeName() == null;
            }
            case 23: {
                return pSSysDBSchemeBase.getPSSysDynaModelId() == null;
            }
            case 24: {
                return pSSysDBSchemeBase.getPSSysDynaModelName() == null;
            }
            case 25: {
                return pSSysDBSchemeBase.getPSSysModelGroupId() == null;
            }
            case 26: {
                return pSSysDBSchemeBase.getPSSysModelGroupName() == null;
            }
            case 27: {
                return pSSysDBSchemeBase.getPSSysServiceAPIId() == null;
            }
            case 28: {
                return pSSysDBSchemeBase.getPSSysServiceAPIName() == null;
            }
            case 29: {
                return pSSysDBSchemeBase.getPSSysSFPluginId() == null;
            }
            case 30: {
                return pSSysDBSchemeBase.getPSSysSFPluginName() == null;
            }
            case 31: {
                return pSSysDBSchemeBase.getPSSystemId() == null;
            }
            case 32: {
                return pSSysDBSchemeBase.getPSSystemName() == null;
            }
            case 33: {
                return pSSysDBSchemeBase.getSchemeParams() == null;
            }
            case 34: {
                return pSSysDBSchemeBase.getSchemeTag() == null;
            }
            case 35: {
                return pSSysDBSchemeBase.getSchemeTag2() == null;
            }
            case 36: {
                return pSSysDBSchemeBase.getServiceCodeName() == null;
            }
            case 37: {
                return pSSysDBSchemeBase.getServiceParam() == null;
            }
            case 38: {
                return pSSysDBSchemeBase.getServiceParam2() == null;
            }
            case 39: {
                return pSSysDBSchemeBase.getServicePath() == null;
            }
            case 40: {
                return pSSysDBSchemeBase.getSubSysServiceCodeName() == null;
            }
            case 41: {
                return pSSysDBSchemeBase.getUpdateDate() == null;
            }
            case 42: {
                return pSSysDBSchemeBase.getUpdateMan() == null;
            }
            case 43: {
                return pSSysDBSchemeBase.getUserCat() == null;
            }
            case 44: {
                return pSSysDBSchemeBase.getUserTag() == null;
            }
            case 45: {
                return pSSysDBSchemeBase.getUserTag2() == null;
            }
            case 46: {
                return pSSysDBSchemeBase.getUserTag3() == null;
            }
            case 47: {
                return pSSysDBSchemeBase.getUserTag4() == null;
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
        return PSSysDBSchemeBase.contains(this, n);
    }

    private static boolean contains(PSSysDBSchemeBase pSSysDBSchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBSchemeBase.isAuthClientIdDirty();
            }
            case 1: {
                return pSSysDBSchemeBase.isAuthClientSecretDirty();
            }
            case 2: {
                return pSSysDBSchemeBase.isAuthModeDirty();
            }
            case 3: {
                return pSSysDBSchemeBase.isAuthParamDirty();
            }
            case 4: {
                return pSSysDBSchemeBase.isAuthParam2Dirty();
            }
            case 5: {
                return pSSysDBSchemeBase.isAutoExtendModelDirty();
            }
            case 6: {
                return pSSysDBSchemeBase.isCodeNameDirty();
            }
            case 7: {
                return pSSysDBSchemeBase.isCodeName2Dirty();
            }
            case 8: {
                return pSSysDBSchemeBase.isCreateDateDirty();
            }
            case 9: {
                return pSSysDBSchemeBase.isCreateManDirty();
            }
            case 10: {
                return pSSysDBSchemeBase.isDSLinkDirty();
            }
            case 11: {
                return pSSysDBSchemeBase.isEnableServiceAPIDirty();
            }
            case 12: {
                return pSSysDBSchemeBase.isEnableSubSysServiceAPIDirty();
            }
            case 13: {
                return pSSysDBSchemeBase.isExistingModelDirty();
            }
            case 14: {
                return pSSysDBSchemeBase.isMemoDirty();
            }
            case 15: {
                return pSSysDBSchemeBase.isObjNameCaseDirty();
            }
            case 16: {
                return pSSysDBSchemeBase.isOrderValueDirty();
            }
            case 17: {
                return pSSysDBSchemeBase.isPSModuleIdDirty();
            }
            case 18: {
                return pSSysDBSchemeBase.isPSModuleNameDirty();
            }
            case 19: {
                return pSSysDBSchemeBase.isPSSubSysServiceAPIIdDirty();
            }
            case 20: {
                return pSSysDBSchemeBase.isPSSubSysServiceAPINameDirty();
            }
            case 21: {
                return pSSysDBSchemeBase.isPSSysDBSchemeIdDirty();
            }
            case 22: {
                return pSSysDBSchemeBase.isPSSysDBSchemeNameDirty();
            }
            case 23: {
                return pSSysDBSchemeBase.isPSSysDynaModelIdDirty();
            }
            case 24: {
                return pSSysDBSchemeBase.isPSSysDynaModelNameDirty();
            }
            case 25: {
                return pSSysDBSchemeBase.isPSSysModelGroupIdDirty();
            }
            case 26: {
                return pSSysDBSchemeBase.isPSSysModelGroupNameDirty();
            }
            case 27: {
                return pSSysDBSchemeBase.isPSSysServiceAPIIdDirty();
            }
            case 28: {
                return pSSysDBSchemeBase.isPSSysServiceAPINameDirty();
            }
            case 29: {
                return pSSysDBSchemeBase.isPSSysSFPluginIdDirty();
            }
            case 30: {
                return pSSysDBSchemeBase.isPSSysSFPluginNameDirty();
            }
            case 31: {
                return pSSysDBSchemeBase.isPSSystemIdDirty();
            }
            case 32: {
                return pSSysDBSchemeBase.isPSSystemNameDirty();
            }
            case 33: {
                return pSSysDBSchemeBase.isSchemeParamsDirty();
            }
            case 34: {
                return pSSysDBSchemeBase.isSchemeTagDirty();
            }
            case 35: {
                return pSSysDBSchemeBase.isSchemeTag2Dirty();
            }
            case 36: {
                return pSSysDBSchemeBase.isServiceCodeNameDirty();
            }
            case 37: {
                return pSSysDBSchemeBase.isServiceParamDirty();
            }
            case 38: {
                return pSSysDBSchemeBase.isServiceParam2Dirty();
            }
            case 39: {
                return pSSysDBSchemeBase.isServicePathDirty();
            }
            case 40: {
                return pSSysDBSchemeBase.isSubSysServiceCodeNameDirty();
            }
            case 41: {
                return pSSysDBSchemeBase.isUpdateDateDirty();
            }
            case 42: {
                return pSSysDBSchemeBase.isUpdateManDirty();
            }
            case 43: {
                return pSSysDBSchemeBase.isUserCatDirty();
            }
            case 44: {
                return pSSysDBSchemeBase.isUserTagDirty();
            }
            case 45: {
                return pSSysDBSchemeBase.isUserTag2Dirty();
            }
            case 46: {
                return pSSysDBSchemeBase.isUserTag3Dirty();
            }
            case 47: {
                return pSSysDBSchemeBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDBSchemeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDBSchemeBase pSSysDBSchemeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDBSchemeBase.getAuthClientId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientid", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getAuthClientId()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getAuthClientSecret() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientsecret", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getAuthClientSecret()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getAuthMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authmode", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getAuthMode()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getAuthParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getAuthParam()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getAuthParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam2", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getAuthParam2()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getAutoExtendModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"autoextendmodel", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getAutoExtendModel()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getDSLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dslink", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getDSLink()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getEnableServiceAPI() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableserviceapi", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getEnableServiceAPI()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getEnableSubSysServiceAPI() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesubsysserviceapi", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getEnableSubSysServiceAPI()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getExistingModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"existingmodel", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getExistingModel()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getObjNameCase() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objnamecase", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getObjNameCase()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSSubSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiname", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSSubSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSSysDBSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbschemeid", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSSysDBSchemeId()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSSysDBSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbschemename", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSSysDBSchemeName()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSSysModelGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupid", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSSysModelGroupId()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSSysModelGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupname", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSSysModelGroupName()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getSchemeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"schemeparams", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getSchemeParams()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getSchemeTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"schemetag", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getSchemeTag()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getSchemeTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"schemetag2", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getSchemeTag2()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getServiceParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getServiceParam()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getServiceParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam2", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getServiceParam2()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getServicePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicepath", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getServicePath()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getSubSysServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subsysservicecodename", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getSubSysServiceCodeName()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysDBSchemeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysDBSchemeBase.getJSONValue((Object)pSSysDBSchemeBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDBSchemeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDBSchemeBase pSSysDBSchemeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDBSchemeBase.getAuthClientId() != null) {
            object = pSSysDBSchemeBase.getAuthClientId();
            xmlNode.setAttribute(FIELD_AUTHCLIENTID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysDBSchemeBase.getAuthClientSecret() != null) {
            object = pSSysDBSchemeBase.getAuthClientSecret();
            xmlNode.setAttribute(FIELD_AUTHCLIENTSECRET, (String)(object == null ? "" : object));
        }
        if (bl || pSSysDBSchemeBase.getAuthMode() != null) {
            object = pSSysDBSchemeBase.getAuthMode();
            xmlNode.setAttribute(FIELD_AUTHMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysDBSchemeBase.getAuthParam() != null) {
            object = pSSysDBSchemeBase.getAuthParam();
            xmlNode.setAttribute(FIELD_AUTHPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSSysDBSchemeBase.getAuthParam2() != null) {
            object = pSSysDBSchemeBase.getAuthParam2();
            xmlNode.setAttribute(FIELD_AUTHPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getAutoExtendModel() != null) {
            object = pSSysDBSchemeBase.getAutoExtendModel();
            xmlNode.setAttribute(FIELD_AUTOEXTENDMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBSchemeBase.getCodeName() != null) {
            object = pSSysDBSchemeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getCodeName2() != null) {
            object = pSSysDBSchemeBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getCreateDate() != null) {
            object = pSSysDBSchemeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBSchemeBase.getCreateMan() != null) {
            object = pSSysDBSchemeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getDSLink() != null) {
            object = pSSysDBSchemeBase.getDSLink();
            xmlNode.setAttribute(FIELD_DSLINK, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getEnableServiceAPI() != null) {
            object = pSSysDBSchemeBase.getEnableServiceAPI();
            xmlNode.setAttribute(FIELD_ENABLESERVICEAPI, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBSchemeBase.getEnableSubSysServiceAPI() != null) {
            object = pSSysDBSchemeBase.getEnableSubSysServiceAPI();
            xmlNode.setAttribute(FIELD_ENABLESUBSYSSERVICEAPI, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBSchemeBase.getExistingModel() != null) {
            object = pSSysDBSchemeBase.getExistingModel();
            xmlNode.setAttribute(FIELD_EXISTINGMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBSchemeBase.getMemo() != null) {
            object = pSSysDBSchemeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getObjNameCase() != null) {
            object = pSSysDBSchemeBase.getObjNameCase();
            xmlNode.setAttribute(FIELD_OBJNAMECASE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getOrderValue() != null) {
            object = pSSysDBSchemeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBSchemeBase.getPSModuleId() != null) {
            object = pSSysDBSchemeBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getPSModuleName() != null) {
            object = pSSysDBSchemeBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getPSSubSysServiceAPIId() != null) {
            object = pSSysDBSchemeBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getPSSubSysServiceAPIName() != null) {
            object = pSSysDBSchemeBase.getPSSubSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getPSSysDBSchemeId() != null) {
            object = pSSysDBSchemeBase.getPSSysDBSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSDBSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getPSSysDBSchemeName() != null) {
            object = pSSysDBSchemeBase.getPSSysDBSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSDBSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getPSSysDynaModelId() != null) {
            object = pSSysDBSchemeBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getPSSysDynaModelName() != null) {
            object = pSSysDBSchemeBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getPSSysModelGroupId() != null) {
            object = pSSysDBSchemeBase.getPSSysModelGroupId();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getPSSysModelGroupName() != null) {
            object = pSSysDBSchemeBase.getPSSysModelGroupName();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getPSSysServiceAPIId() != null) {
            object = pSSysDBSchemeBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getPSSysServiceAPIName() != null) {
            object = pSSysDBSchemeBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getPSSysSFPluginId() != null) {
            object = pSSysDBSchemeBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getPSSysSFPluginName() != null) {
            object = pSSysDBSchemeBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getPSSystemId() != null) {
            object = pSSysDBSchemeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getPSSystemName() != null) {
            object = pSSysDBSchemeBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getSchemeParams() != null) {
            object = pSSysDBSchemeBase.getSchemeParams();
            xmlNode.setAttribute(FIELD_SCHEMEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getSchemeTag() != null) {
            object = pSSysDBSchemeBase.getSchemeTag();
            xmlNode.setAttribute(FIELD_SCHEMETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getSchemeTag2() != null) {
            object = pSSysDBSchemeBase.getSchemeTag2();
            xmlNode.setAttribute(FIELD_SCHEMETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getServiceCodeName() != null) {
            object = pSSysDBSchemeBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getServiceParam() != null) {
            object = pSSysDBSchemeBase.getServiceParam();
            xmlNode.setAttribute(FIELD_SERVICEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getServiceParam2() != null) {
            object = pSSysDBSchemeBase.getServiceParam2();
            xmlNode.setAttribute(FIELD_SERVICEPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getServicePath() != null) {
            object = pSSysDBSchemeBase.getServicePath();
            xmlNode.setAttribute(FIELD_SERVICEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getSubSysServiceCodeName() != null) {
            object = pSSysDBSchemeBase.getSubSysServiceCodeName();
            xmlNode.setAttribute(FIELD_SUBSYSSERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getUpdateDate() != null) {
            object = pSSysDBSchemeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBSchemeBase.getUpdateMan() != null) {
            object = pSSysDBSchemeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getUserCat() != null) {
            object = pSSysDBSchemeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getUserTag() != null) {
            object = pSSysDBSchemeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getUserTag2() != null) {
            object = pSSysDBSchemeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getUserTag3() != null) {
            object = pSSysDBSchemeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBSchemeBase.getUserTag4() != null) {
            object = pSSysDBSchemeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDBSchemeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDBSchemeBase pSSysDBSchemeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDBSchemeBase.isAuthClientIdDirty() && (bl || pSSysDBSchemeBase.getAuthClientId() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTID, (Object)pSSysDBSchemeBase.getAuthClientId());
        }
        if (pSSysDBSchemeBase.isAuthClientSecretDirty() && (bl || pSSysDBSchemeBase.getAuthClientSecret() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTSECRET, (Object)pSSysDBSchemeBase.getAuthClientSecret());
        }
        if (pSSysDBSchemeBase.isAuthModeDirty() && (bl || pSSysDBSchemeBase.getAuthMode() != null)) {
            iDataObject.set(FIELD_AUTHMODE, (Object)pSSysDBSchemeBase.getAuthMode());
        }
        if (pSSysDBSchemeBase.isAuthParamDirty() && (bl || pSSysDBSchemeBase.getAuthParam() != null)) {
            iDataObject.set(FIELD_AUTHPARAM, (Object)pSSysDBSchemeBase.getAuthParam());
        }
        if (pSSysDBSchemeBase.isAuthParam2Dirty() && (bl || pSSysDBSchemeBase.getAuthParam2() != null)) {
            iDataObject.set(FIELD_AUTHPARAM2, (Object)pSSysDBSchemeBase.getAuthParam2());
        }
        if (pSSysDBSchemeBase.isAutoExtendModelDirty() && (bl || pSSysDBSchemeBase.getAutoExtendModel() != null)) {
            iDataObject.set(FIELD_AUTOEXTENDMODEL, (Object)pSSysDBSchemeBase.getAutoExtendModel());
        }
        if (pSSysDBSchemeBase.isCodeNameDirty() && (bl || pSSysDBSchemeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysDBSchemeBase.getCodeName());
        }
        if (pSSysDBSchemeBase.isCodeName2Dirty() && (bl || pSSysDBSchemeBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSSysDBSchemeBase.getCodeName2());
        }
        if (pSSysDBSchemeBase.isCreateDateDirty() && (bl || pSSysDBSchemeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDBSchemeBase.getCreateDate());
        }
        if (pSSysDBSchemeBase.isCreateManDirty() && (bl || pSSysDBSchemeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDBSchemeBase.getCreateMan());
        }
        if (pSSysDBSchemeBase.isDSLinkDirty() && (bl || pSSysDBSchemeBase.getDSLink() != null)) {
            iDataObject.set(FIELD_DSLINK, (Object)pSSysDBSchemeBase.getDSLink());
        }
        if (pSSysDBSchemeBase.isEnableServiceAPIDirty() && (bl || pSSysDBSchemeBase.getEnableServiceAPI() != null)) {
            iDataObject.set(FIELD_ENABLESERVICEAPI, (Object)pSSysDBSchemeBase.getEnableServiceAPI());
        }
        if (pSSysDBSchemeBase.isEnableSubSysServiceAPIDirty() && (bl || pSSysDBSchemeBase.getEnableSubSysServiceAPI() != null)) {
            iDataObject.set(FIELD_ENABLESUBSYSSERVICEAPI, (Object)pSSysDBSchemeBase.getEnableSubSysServiceAPI());
        }
        if (pSSysDBSchemeBase.isExistingModelDirty() && (bl || pSSysDBSchemeBase.getExistingModel() != null)) {
            iDataObject.set(FIELD_EXISTINGMODEL, (Object)pSSysDBSchemeBase.getExistingModel());
        }
        if (pSSysDBSchemeBase.isMemoDirty() && (bl || pSSysDBSchemeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDBSchemeBase.getMemo());
        }
        if (pSSysDBSchemeBase.isObjNameCaseDirty() && (bl || pSSysDBSchemeBase.getObjNameCase() != null)) {
            iDataObject.set(FIELD_OBJNAMECASE, (Object)pSSysDBSchemeBase.getObjNameCase());
        }
        if (pSSysDBSchemeBase.isOrderValueDirty() && (bl || pSSysDBSchemeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysDBSchemeBase.getOrderValue());
        }
        if (pSSysDBSchemeBase.isPSModuleIdDirty() && (bl || pSSysDBSchemeBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysDBSchemeBase.getPSModuleId());
        }
        if (pSSysDBSchemeBase.isPSModuleNameDirty() && (bl || pSSysDBSchemeBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysDBSchemeBase.getPSModuleName());
        }
        if (pSSysDBSchemeBase.isPSSubSysServiceAPIIdDirty() && (bl || pSSysDBSchemeBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSSysDBSchemeBase.getPSSubSysServiceAPIId());
        }
        if (pSSysDBSchemeBase.isPSSubSysServiceAPINameDirty() && (bl || pSSysDBSchemeBase.getPSSubSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPINAME, (Object)pSSysDBSchemeBase.getPSSubSysServiceAPIName());
        }
        if (pSSysDBSchemeBase.isPSSysDBSchemeIdDirty() && (bl || pSSysDBSchemeBase.getPSSysDBSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSDBSCHEMEID, (Object)pSSysDBSchemeBase.getPSSysDBSchemeId());
        }
        if (pSSysDBSchemeBase.isPSSysDBSchemeNameDirty() && (bl || pSSysDBSchemeBase.getPSSysDBSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSDBSCHEMENAME, (Object)pSSysDBSchemeBase.getPSSysDBSchemeName());
        }
        if (pSSysDBSchemeBase.isPSSysDynaModelIdDirty() && (bl || pSSysDBSchemeBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysDBSchemeBase.getPSSysDynaModelId());
        }
        if (pSSysDBSchemeBase.isPSSysDynaModelNameDirty() && (bl || pSSysDBSchemeBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysDBSchemeBase.getPSSysDynaModelName());
        }
        if (pSSysDBSchemeBase.isPSSysModelGroupIdDirty() && (bl || pSSysDBSchemeBase.getPSSysModelGroupId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPID, (Object)pSSysDBSchemeBase.getPSSysModelGroupId());
        }
        if (pSSysDBSchemeBase.isPSSysModelGroupNameDirty() && (bl || pSSysDBSchemeBase.getPSSysModelGroupName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPNAME, (Object)pSSysDBSchemeBase.getPSSysModelGroupName());
        }
        if (pSSysDBSchemeBase.isPSSysServiceAPIIdDirty() && (bl || pSSysDBSchemeBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSSysDBSchemeBase.getPSSysServiceAPIId());
        }
        if (pSSysDBSchemeBase.isPSSysServiceAPINameDirty() && (bl || pSSysDBSchemeBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSSysDBSchemeBase.getPSSysServiceAPIName());
        }
        if (pSSysDBSchemeBase.isPSSysSFPluginIdDirty() && (bl || pSSysDBSchemeBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysDBSchemeBase.getPSSysSFPluginId());
        }
        if (pSSysDBSchemeBase.isPSSysSFPluginNameDirty() && (bl || pSSysDBSchemeBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysDBSchemeBase.getPSSysSFPluginName());
        }
        if (pSSysDBSchemeBase.isPSSystemIdDirty() && (bl || pSSysDBSchemeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysDBSchemeBase.getPSSystemId());
        }
        if (pSSysDBSchemeBase.isPSSystemNameDirty() && (bl || pSSysDBSchemeBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysDBSchemeBase.getPSSystemName());
        }
        if (pSSysDBSchemeBase.isSchemeParamsDirty() && (bl || pSSysDBSchemeBase.getSchemeParams() != null)) {
            iDataObject.set(FIELD_SCHEMEPARAMS, (Object)pSSysDBSchemeBase.getSchemeParams());
        }
        if (pSSysDBSchemeBase.isSchemeTagDirty() && (bl || pSSysDBSchemeBase.getSchemeTag() != null)) {
            iDataObject.set(FIELD_SCHEMETAG, (Object)pSSysDBSchemeBase.getSchemeTag());
        }
        if (pSSysDBSchemeBase.isSchemeTag2Dirty() && (bl || pSSysDBSchemeBase.getSchemeTag2() != null)) {
            iDataObject.set(FIELD_SCHEMETAG2, (Object)pSSysDBSchemeBase.getSchemeTag2());
        }
        if (pSSysDBSchemeBase.isServiceCodeNameDirty() && (bl || pSSysDBSchemeBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSSysDBSchemeBase.getServiceCodeName());
        }
        if (pSSysDBSchemeBase.isServiceParamDirty() && (bl || pSSysDBSchemeBase.getServiceParam() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM, (Object)pSSysDBSchemeBase.getServiceParam());
        }
        if (pSSysDBSchemeBase.isServiceParam2Dirty() && (bl || pSSysDBSchemeBase.getServiceParam2() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM2, (Object)pSSysDBSchemeBase.getServiceParam2());
        }
        if (pSSysDBSchemeBase.isServicePathDirty() && (bl || pSSysDBSchemeBase.getServicePath() != null)) {
            iDataObject.set(FIELD_SERVICEPATH, (Object)pSSysDBSchemeBase.getServicePath());
        }
        if (pSSysDBSchemeBase.isSubSysServiceCodeNameDirty() && (bl || pSSysDBSchemeBase.getSubSysServiceCodeName() != null)) {
            iDataObject.set(FIELD_SUBSYSSERVICECODENAME, (Object)pSSysDBSchemeBase.getSubSysServiceCodeName());
        }
        if (pSSysDBSchemeBase.isUpdateDateDirty() && (bl || pSSysDBSchemeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDBSchemeBase.getUpdateDate());
        }
        if (pSSysDBSchemeBase.isUpdateManDirty() && (bl || pSSysDBSchemeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDBSchemeBase.getUpdateMan());
        }
        if (pSSysDBSchemeBase.isUserCatDirty() && (bl || pSSysDBSchemeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysDBSchemeBase.getUserCat());
        }
        if (pSSysDBSchemeBase.isUserTagDirty() && (bl || pSSysDBSchemeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysDBSchemeBase.getUserTag());
        }
        if (pSSysDBSchemeBase.isUserTag2Dirty() && (bl || pSSysDBSchemeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysDBSchemeBase.getUserTag2());
        }
        if (pSSysDBSchemeBase.isUserTag3Dirty() && (bl || pSSysDBSchemeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysDBSchemeBase.getUserTag3());
        }
        if (pSSysDBSchemeBase.isUserTag4Dirty() && (bl || pSSysDBSchemeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysDBSchemeBase.getUserTag4());
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
        return PSSysDBSchemeBase.remove(this, n);
    }

    private static boolean remove(PSSysDBSchemeBase pSSysDBSchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBSchemeBase.resetAuthClientId();
                return true;
            }
            case 1: {
                pSSysDBSchemeBase.resetAuthClientSecret();
                return true;
            }
            case 2: {
                pSSysDBSchemeBase.resetAuthMode();
                return true;
            }
            case 3: {
                pSSysDBSchemeBase.resetAuthParam();
                return true;
            }
            case 4: {
                pSSysDBSchemeBase.resetAuthParam2();
                return true;
            }
            case 5: {
                pSSysDBSchemeBase.resetAutoExtendModel();
                return true;
            }
            case 6: {
                pSSysDBSchemeBase.resetCodeName();
                return true;
            }
            case 7: {
                pSSysDBSchemeBase.resetCodeName2();
                return true;
            }
            case 8: {
                pSSysDBSchemeBase.resetCreateDate();
                return true;
            }
            case 9: {
                pSSysDBSchemeBase.resetCreateMan();
                return true;
            }
            case 10: {
                pSSysDBSchemeBase.resetDSLink();
                return true;
            }
            case 11: {
                pSSysDBSchemeBase.resetEnableServiceAPI();
                return true;
            }
            case 12: {
                pSSysDBSchemeBase.resetEnableSubSysServiceAPI();
                return true;
            }
            case 13: {
                pSSysDBSchemeBase.resetExistingModel();
                return true;
            }
            case 14: {
                pSSysDBSchemeBase.resetMemo();
                return true;
            }
            case 15: {
                pSSysDBSchemeBase.resetObjNameCase();
                return true;
            }
            case 16: {
                pSSysDBSchemeBase.resetOrderValue();
                return true;
            }
            case 17: {
                pSSysDBSchemeBase.resetPSModuleId();
                return true;
            }
            case 18: {
                pSSysDBSchemeBase.resetPSModuleName();
                return true;
            }
            case 19: {
                pSSysDBSchemeBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 20: {
                pSSysDBSchemeBase.resetPSSubSysServiceAPIName();
                return true;
            }
            case 21: {
                pSSysDBSchemeBase.resetPSSysDBSchemeId();
                return true;
            }
            case 22: {
                pSSysDBSchemeBase.resetPSSysDBSchemeName();
                return true;
            }
            case 23: {
                pSSysDBSchemeBase.resetPSSysDynaModelId();
                return true;
            }
            case 24: {
                pSSysDBSchemeBase.resetPSSysDynaModelName();
                return true;
            }
            case 25: {
                pSSysDBSchemeBase.resetPSSysModelGroupId();
                return true;
            }
            case 26: {
                pSSysDBSchemeBase.resetPSSysModelGroupName();
                return true;
            }
            case 27: {
                pSSysDBSchemeBase.resetPSSysServiceAPIId();
                return true;
            }
            case 28: {
                pSSysDBSchemeBase.resetPSSysServiceAPIName();
                return true;
            }
            case 29: {
                pSSysDBSchemeBase.resetPSSysSFPluginId();
                return true;
            }
            case 30: {
                pSSysDBSchemeBase.resetPSSysSFPluginName();
                return true;
            }
            case 31: {
                pSSysDBSchemeBase.resetPSSystemId();
                return true;
            }
            case 32: {
                pSSysDBSchemeBase.resetPSSystemName();
                return true;
            }
            case 33: {
                pSSysDBSchemeBase.resetSchemeParams();
                return true;
            }
            case 34: {
                pSSysDBSchemeBase.resetSchemeTag();
                return true;
            }
            case 35: {
                pSSysDBSchemeBase.resetSchemeTag2();
                return true;
            }
            case 36: {
                pSSysDBSchemeBase.resetServiceCodeName();
                return true;
            }
            case 37: {
                pSSysDBSchemeBase.resetServiceParam();
                return true;
            }
            case 38: {
                pSSysDBSchemeBase.resetServiceParam2();
                return true;
            }
            case 39: {
                pSSysDBSchemeBase.resetServicePath();
                return true;
            }
            case 40: {
                pSSysDBSchemeBase.resetSubSysServiceCodeName();
                return true;
            }
            case 41: {
                pSSysDBSchemeBase.resetUpdateDate();
                return true;
            }
            case 42: {
                pSSysDBSchemeBase.resetUpdateMan();
                return true;
            }
            case 43: {
                pSSysDBSchemeBase.resetUserCat();
                return true;
            }
            case 44: {
                pSSysDBSchemeBase.resetUserTag();
                return true;
            }
            case 45: {
                pSSysDBSchemeBase.resetUserTag2();
                return true;
            }
            case 46: {
                pSSysDBSchemeBase.resetUserTag3();
                return true;
            }
            case 47: {
                pSSysDBSchemeBase.resetUserTag4();
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
    public PSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPI();
        }
        if (this.getPSSubSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysServiceAPILock;
        synchronized (n) {
            if (this.pssubsysserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysServiceAPIId(), (Object)this.pssubsysserviceapi.getPSSubSysServiceAPIId()) != 0L) {
                this.pssubsysserviceapi = null;
            }
            if (this.pssubsysserviceapi == null) {
                PSSubSysServiceAPI pSSubSysServiceAPI = new PSSubSysServiceAPI();
                pSSubSysServiceAPI.setPSSubSysServiceAPIId(this.getPSSubSysServiceAPIId());
                PSSubSysServiceAPIService pSSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysServiceAPIService.autoGet(pSSubSysServiceAPI);
                this.pssubsysserviceapi = pSSubSysServiceAPI;
            }
            return this.pssubsysserviceapi;
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
    public PSSysModelGroup getPSSysModelGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelGroup();
        }
        if (this.getPSSysModelGroupId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelGroupLock;
        synchronized (n) {
            if (this.pssysmodelgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelGroupId(), (Object)this.pssysmodelgroup.getPSSysModelGroupId()) != 0L) {
                this.pssysmodelgroup = null;
            }
            if (this.pssysmodelgroup == null) {
                PSSysModelGroup pSSysModelGroup = new PSSysModelGroup();
                pSSysModelGroup.setPSSysModelGroupId(this.getPSSysModelGroupId());
                PSSysModelGroupService pSSysModelGroupService = (PSSysModelGroupService)ServiceGlobal.getService(PSSysModelGroupService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelGroupService.autoGet(pSSysModelGroup);
                this.pssysmodelgroup = pSSysModelGroup;
            }
            return this.pssysmodelgroup;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDBProc> getPSSysDBProcs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBProcs();
        }
        if (this.getPSSysDBSchemeId() == null) {
            return null;
        }
        PSSysDBProcService pSSysDBProcService = (PSSysDBProcService)ServiceGlobal.getService(PSSysDBProcService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDBProcsLock;
        synchronized (n) {
            if (this.pssysdbprocs == null) {
                this.pssysdbprocs = pSSysDBProcService.selectByPSSysDBScheme(this);
            }
            return this.pssysdbprocs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDBTable> getPSSysDBTables() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBTables();
        }
        if (this.getPSSysDBSchemeId() == null) {
            return null;
        }
        PSSysDBTableService pSSysDBTableService = (PSSysDBTableService)ServiceGlobal.getService(PSSysDBTableService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDBTablesLock;
        synchronized (n) {
            if (this.pssysdbtables == null) {
                this.pssysdbtables = pSSysDBTableService.selectByPSSysDBScheme(this);
            }
            return this.pssysdbtables;
        }
    }

    private PSSysDBSchemeBase getProxyEntity() {
        return this.proxyPSSysDBSchemeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDBSchemeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDBSchemeBase) {
            this.proxyPSSysDBSchemeBase = (PSSysDBSchemeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AUTHCLIENTID, 0);
        fieldIndexMap.put(FIELD_AUTHCLIENTSECRET, 1);
        fieldIndexMap.put(FIELD_AUTHMODE, 2);
        fieldIndexMap.put(FIELD_AUTHPARAM, 3);
        fieldIndexMap.put(FIELD_AUTHPARAM2, 4);
        fieldIndexMap.put(FIELD_AUTOEXTENDMODEL, 5);
        fieldIndexMap.put(FIELD_CODENAME, 6);
        fieldIndexMap.put(FIELD_CODENAME2, 7);
        fieldIndexMap.put(FIELD_CREATEDATE, 8);
        fieldIndexMap.put(FIELD_CREATEMAN, 9);
        fieldIndexMap.put(FIELD_DSLINK, 10);
        fieldIndexMap.put(FIELD_ENABLESERVICEAPI, 11);
        fieldIndexMap.put(FIELD_ENABLESUBSYSSERVICEAPI, 12);
        fieldIndexMap.put(FIELD_EXISTINGMODEL, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_OBJNAMECASE, 15);
        fieldIndexMap.put(FIELD_ORDERVALUE, 16);
        fieldIndexMap.put(FIELD_PSMODULEID, 17);
        fieldIndexMap.put(FIELD_PSMODULENAME, 18);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 19);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPINAME, 20);
        fieldIndexMap.put(FIELD_PSSYSDBSCHEMEID, 21);
        fieldIndexMap.put(FIELD_PSSYSDBSCHEMENAME, 22);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 23);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 24);
        fieldIndexMap.put(FIELD_PSSYSMODELGROUPID, 25);
        fieldIndexMap.put(FIELD_PSSYSMODELGROUPNAME, 26);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 27);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPINAME, 28);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 29);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 30);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 31);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 32);
        fieldIndexMap.put(FIELD_SCHEMEPARAMS, 33);
        fieldIndexMap.put(FIELD_SCHEMETAG, 34);
        fieldIndexMap.put(FIELD_SCHEMETAG2, 35);
        fieldIndexMap.put(FIELD_SERVICECODENAME, 36);
        fieldIndexMap.put(FIELD_SERVICEPARAM, 37);
        fieldIndexMap.put(FIELD_SERVICEPARAM2, 38);
        fieldIndexMap.put(FIELD_SERVICEPATH, 39);
        fieldIndexMap.put(FIELD_SUBSYSSERVICECODENAME, 40);
        fieldIndexMap.put(FIELD_UPDATEDATE, 41);
        fieldIndexMap.put(FIELD_UPDATEMAN, 42);
        fieldIndexMap.put(FIELD_USERCAT, 43);
        fieldIndexMap.put(FIELD_USERTAG, 44);
        fieldIndexMap.put(FIELD_USERTAG2, 45);
        fieldIndexMap.put(FIELD_USERTAG3, 46);
        fieldIndexMap.put(FIELD_USERTAG4, 47);
    }
}

