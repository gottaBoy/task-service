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
package net.ibizsys.pscore.srv.search.entity;

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
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDE;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDoc;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDocService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSearchSchemeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSearchSchemeBase.class);
    public static final String FIELD_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String FIELD_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String FIELD_AUTHMODE = "AUTHMODE";
    public static final String FIELD_AUTHPARAM = "AUTHPARAM";
    public static final String FIELD_AUTHPARAM2 = "AUTHPARAM2";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DOCREPLICAS = "DOCREPLICAS";
    public static final String FIELD_DOCSHARDS = "DOCSHARDS";
    public static final String FIELD_ENABLESERVICEAPI = "ENABLESERVICEAPI";
    public static final String FIELD_ENABLESUBSYSSERVICEAPI = "ENABLESUBSYSSERVICEAPI";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OBJNAMECASE = "OBJNAMECASE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSMODELGROUPID = "PSSYSMODELGROUPID";
    public static final String FIELD_PSSYSMODELGROUPNAME = "PSSYSMODELGROUPNAME";
    public static final String FIELD_PSSYSSEARCHSCHEMEID = "PSSYSSEARCHSCHEMEID";
    public static final String FIELD_PSSYSSEARCHSCHEMENAME = "PSSYSSEARCHSCHEMENAME";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_SCHEMEPARAMS = "SCHEMEPARAMS";
    public static final String FIELD_SCHEMETAG = "SCHEMETAG";
    public static final String FIELD_SCHEMETAG2 = "SCHEMETAG2";
    public static final String FIELD_SEARCHENGINETYPE = "SEARCHENGINETYPE";
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
    private static final int INDEX_CODENAME = 5;
    private static final int INDEX_CODENAME2 = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_DOCREPLICAS = 9;
    private static final int INDEX_DOCSHARDS = 10;
    private static final int INDEX_ENABLESERVICEAPI = 11;
    private static final int INDEX_ENABLESUBSYSSERVICEAPI = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_OBJNAMECASE = 14;
    private static final int INDEX_ORDERVALUE = 15;
    private static final int INDEX_PSMODULEID = 16;
    private static final int INDEX_PSMODULENAME = 17;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 18;
    private static final int INDEX_PSSUBSYSSERVICEAPINAME = 19;
    private static final int INDEX_PSSYSDYNAMODELID = 20;
    private static final int INDEX_PSSYSDYNAMODELNAME = 21;
    private static final int INDEX_PSSYSMODELGROUPID = 22;
    private static final int INDEX_PSSYSMODELGROUPNAME = 23;
    private static final int INDEX_PSSYSSEARCHSCHEMEID = 24;
    private static final int INDEX_PSSYSSEARCHSCHEMENAME = 25;
    private static final int INDEX_PSSYSSERVICEAPIID = 26;
    private static final int INDEX_PSSYSSERVICEAPINAME = 27;
    private static final int INDEX_PSSYSSFPLUGINID = 28;
    private static final int INDEX_PSSYSSFPLUGINNAME = 29;
    private static final int INDEX_PSSYSTEMID = 30;
    private static final int INDEX_PSSYSTEMNAME = 31;
    private static final int INDEX_SCHEMEPARAMS = 32;
    private static final int INDEX_SCHEMETAG = 33;
    private static final int INDEX_SCHEMETAG2 = 34;
    private static final int INDEX_SEARCHENGINETYPE = 35;
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
    private PSSysSearchSchemeBase proxyPSSysSearchSchemeBase = null;
    private boolean authclientidDirtyFlag = false;
    private boolean authclientsecretDirtyFlag = false;
    private boolean authmodeDirtyFlag = false;
    private boolean authparamDirtyFlag = false;
    private boolean authparam2DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean docreplicasDirtyFlag = false;
    private boolean docshardsDirtyFlag = false;
    private boolean enableserviceapiDirtyFlag = false;
    private boolean enablesubsysserviceapiDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean objnamecaseDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssubsysserviceapinameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysmodelgroupidDirtyFlag = false;
    private boolean pssysmodelgroupnameDirtyFlag = false;
    private boolean pssyssearchschemeidDirtyFlag = false;
    private boolean pssyssearchschemenameDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean pssysserviceapinameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean schemeparamsDirtyFlag = false;
    private boolean schemetagDirtyFlag = false;
    private boolean schemetag2DirtyFlag = false;
    private boolean searchenginetypeDirtyFlag = false;
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
    @Column(name="codename")
    private String codename;
    @Column(name="codename2")
    private String codename2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="docreplicas")
    private Integer docreplicas;
    @Column(name="docshards")
    private Integer docshards;
    @Column(name="enableserviceapi")
    private Integer enableserviceapi;
    @Column(name="enablesubsysserviceapi")
    private Integer enablesubsysserviceapi;
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
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysmodelgroupid")
    private String pssysmodelgroupid;
    @Column(name="pssysmodelgroupname")
    private String pssysmodelgroupname;
    @Column(name="pssyssearchschemeid")
    private String pssyssearchschemeid;
    @Column(name="pssyssearchschemename")
    private String pssyssearchschemename;
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
    @Column(name="searchenginetype")
    private String searchenginetype;
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
    private Integer objPSSysSearchDEsLock = new Integer(1);
    private ArrayList<PSSysSearchDE> pssyssearchdes = null;
    private Integer objPSSysSearchDocsLock = new Integer(1);
    private ArrayList<PSSysSearchDoc> pssyssearchdocs = null;

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

    public void setDocReplicas(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDocReplicas(n);
            return;
        }
        this.docreplicas = n;
        this.docreplicasDirtyFlag = true;
    }

    public Integer getDocReplicas() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDocReplicas();
        }
        return this.docreplicas;
    }

    public boolean isDocReplicasDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDocReplicasDirty();
        }
        return this.docreplicasDirtyFlag;
    }

    public void resetDocReplicas() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDocReplicas();
            return;
        }
        this.docreplicasDirtyFlag = false;
        this.docreplicas = null;
    }

    public void setDocShards(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDocShards(n);
            return;
        }
        this.docshards = n;
        this.docshardsDirtyFlag = true;
    }

    public Integer getDocShards() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDocShards();
        }
        return this.docshards;
    }

    public boolean isDocShardsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDocShardsDirty();
        }
        return this.docshardsDirtyFlag;
    }

    public void resetDocShards() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDocShards();
            return;
        }
        this.docshardsDirtyFlag = false;
        this.docshards = null;
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

    public void setPSSysSearchSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchschemeid = string;
        this.pssyssearchschemeidDirtyFlag = true;
    }

    public String getPSSysSearchSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchSchemeId();
        }
        return this.pssyssearchschemeid;
    }

    public boolean isPSSysSearchSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchSchemeIdDirty();
        }
        return this.pssyssearchschemeidDirtyFlag;
    }

    public void resetPSSysSearchSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchSchemeId();
            return;
        }
        this.pssyssearchschemeidDirtyFlag = false;
        this.pssyssearchschemeid = null;
    }

    public void setPSSysSearchSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchschemename = string;
        this.pssyssearchschemenameDirtyFlag = true;
    }

    public String getPSSysSearchSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchSchemeName();
        }
        return this.pssyssearchschemename;
    }

    public boolean isPSSysSearchSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchSchemeNameDirty();
        }
        return this.pssyssearchschemenameDirtyFlag;
    }

    public void resetPSSysSearchSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchSchemeName();
            return;
        }
        this.pssyssearchschemenameDirtyFlag = false;
        this.pssyssearchschemename = null;
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

    public void setSearchEngineType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchEngineType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.searchenginetype = string;
        this.searchenginetypeDirtyFlag = true;
    }

    public String getSearchEngineType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchEngineType();
        }
        return this.searchenginetype;
    }

    public boolean isSearchEngineTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchEngineTypeDirty();
        }
        return this.searchenginetypeDirtyFlag;
    }

    public void resetSearchEngineType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchEngineType();
            return;
        }
        this.searchenginetypeDirtyFlag = false;
        this.searchenginetype = null;
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
        PSSysSearchSchemeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSearchSchemeBase pSSysSearchSchemeBase) {
        pSSysSearchSchemeBase.resetAuthClientId();
        pSSysSearchSchemeBase.resetAuthClientSecret();
        pSSysSearchSchemeBase.resetAuthMode();
        pSSysSearchSchemeBase.resetAuthParam();
        pSSysSearchSchemeBase.resetAuthParam2();
        pSSysSearchSchemeBase.resetCodeName();
        pSSysSearchSchemeBase.resetCodeName2();
        pSSysSearchSchemeBase.resetCreateDate();
        pSSysSearchSchemeBase.resetCreateMan();
        pSSysSearchSchemeBase.resetDocReplicas();
        pSSysSearchSchemeBase.resetDocShards();
        pSSysSearchSchemeBase.resetEnableServiceAPI();
        pSSysSearchSchemeBase.resetEnableSubSysServiceAPI();
        pSSysSearchSchemeBase.resetMemo();
        pSSysSearchSchemeBase.resetObjNameCase();
        pSSysSearchSchemeBase.resetOrderValue();
        pSSysSearchSchemeBase.resetPSModuleId();
        pSSysSearchSchemeBase.resetPSModuleName();
        pSSysSearchSchemeBase.resetPSSubSysServiceAPIId();
        pSSysSearchSchemeBase.resetPSSubSysServiceAPIName();
        pSSysSearchSchemeBase.resetPSSysDynaModelId();
        pSSysSearchSchemeBase.resetPSSysDynaModelName();
        pSSysSearchSchemeBase.resetPSSysModelGroupId();
        pSSysSearchSchemeBase.resetPSSysModelGroupName();
        pSSysSearchSchemeBase.resetPSSysSearchSchemeId();
        pSSysSearchSchemeBase.resetPSSysSearchSchemeName();
        pSSysSearchSchemeBase.resetPSSysServiceAPIId();
        pSSysSearchSchemeBase.resetPSSysServiceAPIName();
        pSSysSearchSchemeBase.resetPSSysSFPluginId();
        pSSysSearchSchemeBase.resetPSSysSFPluginName();
        pSSysSearchSchemeBase.resetPSSystemId();
        pSSysSearchSchemeBase.resetPSSystemName();
        pSSysSearchSchemeBase.resetSchemeParams();
        pSSysSearchSchemeBase.resetSchemeTag();
        pSSysSearchSchemeBase.resetSchemeTag2();
        pSSysSearchSchemeBase.resetSearchEngineType();
        pSSysSearchSchemeBase.resetServiceCodeName();
        pSSysSearchSchemeBase.resetServiceParam();
        pSSysSearchSchemeBase.resetServiceParam2();
        pSSysSearchSchemeBase.resetServicePath();
        pSSysSearchSchemeBase.resetSubSysServiceCodeName();
        pSSysSearchSchemeBase.resetUpdateDate();
        pSSysSearchSchemeBase.resetUpdateMan();
        pSSysSearchSchemeBase.resetUserCat();
        pSSysSearchSchemeBase.resetUserTag();
        pSSysSearchSchemeBase.resetUserTag2();
        pSSysSearchSchemeBase.resetUserTag3();
        pSSysSearchSchemeBase.resetUserTag4();
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
        if (!bl || this.isDocReplicasDirty()) {
            hashMap.put(FIELD_DOCREPLICAS, this.getDocReplicas());
        }
        if (!bl || this.isDocShardsDirty()) {
            hashMap.put(FIELD_DOCSHARDS, this.getDocShards());
        }
        if (!bl || this.isEnableServiceAPIDirty()) {
            hashMap.put(FIELD_ENABLESERVICEAPI, this.getEnableServiceAPI());
        }
        if (!bl || this.isEnableSubSysServiceAPIDirty()) {
            hashMap.put(FIELD_ENABLESUBSYSSERVICEAPI, this.getEnableSubSysServiceAPI());
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
        if (!bl || this.isPSSysSearchSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHSCHEMEID, this.getPSSysSearchSchemeId());
        }
        if (!bl || this.isPSSysSearchSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHSCHEMENAME, this.getPSSysSearchSchemeName());
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
        if (!bl || this.isSearchEngineTypeDirty()) {
            hashMap.put(FIELD_SEARCHENGINETYPE, this.getSearchEngineType());
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
        return PSSysSearchSchemeBase.get(this, n);
    }

    private static Object get(PSSysSearchSchemeBase pSSysSearchSchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchSchemeBase.getAuthClientId();
            }
            case 1: {
                return pSSysSearchSchemeBase.getAuthClientSecret();
            }
            case 2: {
                return pSSysSearchSchemeBase.getAuthMode();
            }
            case 3: {
                return pSSysSearchSchemeBase.getAuthParam();
            }
            case 4: {
                return pSSysSearchSchemeBase.getAuthParam2();
            }
            case 5: {
                return pSSysSearchSchemeBase.getCodeName();
            }
            case 6: {
                return pSSysSearchSchemeBase.getCodeName2();
            }
            case 7: {
                return pSSysSearchSchemeBase.getCreateDate();
            }
            case 8: {
                return pSSysSearchSchemeBase.getCreateMan();
            }
            case 9: {
                return pSSysSearchSchemeBase.getDocReplicas();
            }
            case 10: {
                return pSSysSearchSchemeBase.getDocShards();
            }
            case 11: {
                return pSSysSearchSchemeBase.getEnableServiceAPI();
            }
            case 12: {
                return pSSysSearchSchemeBase.getEnableSubSysServiceAPI();
            }
            case 13: {
                return pSSysSearchSchemeBase.getMemo();
            }
            case 14: {
                return pSSysSearchSchemeBase.getObjNameCase();
            }
            case 15: {
                return pSSysSearchSchemeBase.getOrderValue();
            }
            case 16: {
                return pSSysSearchSchemeBase.getPSModuleId();
            }
            case 17: {
                return pSSysSearchSchemeBase.getPSModuleName();
            }
            case 18: {
                return pSSysSearchSchemeBase.getPSSubSysServiceAPIId();
            }
            case 19: {
                return pSSysSearchSchemeBase.getPSSubSysServiceAPIName();
            }
            case 20: {
                return pSSysSearchSchemeBase.getPSSysDynaModelId();
            }
            case 21: {
                return pSSysSearchSchemeBase.getPSSysDynaModelName();
            }
            case 22: {
                return pSSysSearchSchemeBase.getPSSysModelGroupId();
            }
            case 23: {
                return pSSysSearchSchemeBase.getPSSysModelGroupName();
            }
            case 24: {
                return pSSysSearchSchemeBase.getPSSysSearchSchemeId();
            }
            case 25: {
                return pSSysSearchSchemeBase.getPSSysSearchSchemeName();
            }
            case 26: {
                return pSSysSearchSchemeBase.getPSSysServiceAPIId();
            }
            case 27: {
                return pSSysSearchSchemeBase.getPSSysServiceAPIName();
            }
            case 28: {
                return pSSysSearchSchemeBase.getPSSysSFPluginId();
            }
            case 29: {
                return pSSysSearchSchemeBase.getPSSysSFPluginName();
            }
            case 30: {
                return pSSysSearchSchemeBase.getPSSystemId();
            }
            case 31: {
                return pSSysSearchSchemeBase.getPSSystemName();
            }
            case 32: {
                return pSSysSearchSchemeBase.getSchemeParams();
            }
            case 33: {
                return pSSysSearchSchemeBase.getSchemeTag();
            }
            case 34: {
                return pSSysSearchSchemeBase.getSchemeTag2();
            }
            case 35: {
                return pSSysSearchSchemeBase.getSearchEngineType();
            }
            case 36: {
                return pSSysSearchSchemeBase.getServiceCodeName();
            }
            case 37: {
                return pSSysSearchSchemeBase.getServiceParam();
            }
            case 38: {
                return pSSysSearchSchemeBase.getServiceParam2();
            }
            case 39: {
                return pSSysSearchSchemeBase.getServicePath();
            }
            case 40: {
                return pSSysSearchSchemeBase.getSubSysServiceCodeName();
            }
            case 41: {
                return pSSysSearchSchemeBase.getUpdateDate();
            }
            case 42: {
                return pSSysSearchSchemeBase.getUpdateMan();
            }
            case 43: {
                return pSSysSearchSchemeBase.getUserCat();
            }
            case 44: {
                return pSSysSearchSchemeBase.getUserTag();
            }
            case 45: {
                return pSSysSearchSchemeBase.getUserTag2();
            }
            case 46: {
                return pSSysSearchSchemeBase.getUserTag3();
            }
            case 47: {
                return pSSysSearchSchemeBase.getUserTag4();
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
        PSSysSearchSchemeBase.set(this, n, object);
    }

    private static void set(PSSysSearchSchemeBase pSSysSearchSchemeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchSchemeBase.setAuthClientId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysSearchSchemeBase.setAuthClientSecret(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysSearchSchemeBase.setAuthMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSearchSchemeBase.setAuthParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysSearchSchemeBase.setAuthParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysSearchSchemeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysSearchSchemeBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysSearchSchemeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSysSearchSchemeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSearchSchemeBase.setDocReplicas(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysSearchSchemeBase.setDocShards(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysSearchSchemeBase.setEnableServiceAPI(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysSearchSchemeBase.setEnableSubSysServiceAPI(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSysSearchSchemeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSearchSchemeBase.setObjNameCase(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSearchSchemeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSysSearchSchemeBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysSearchSchemeBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSearchSchemeBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSearchSchemeBase.setPSSubSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSearchSchemeBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysSearchSchemeBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysSearchSchemeBase.setPSSysModelGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysSearchSchemeBase.setPSSysModelGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysSearchSchemeBase.setPSSysSearchSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysSearchSchemeBase.setPSSysSearchSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysSearchSchemeBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysSearchSchemeBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysSearchSchemeBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysSearchSchemeBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysSearchSchemeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysSearchSchemeBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysSearchSchemeBase.setSchemeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysSearchSchemeBase.setSchemeTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysSearchSchemeBase.setSchemeTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysSearchSchemeBase.setSearchEngineType(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysSearchSchemeBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysSearchSchemeBase.setServiceParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysSearchSchemeBase.setServiceParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysSearchSchemeBase.setServicePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysSearchSchemeBase.setSubSysServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysSearchSchemeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 42: {
                pSSysSearchSchemeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysSearchSchemeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysSearchSchemeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysSearchSchemeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysSearchSchemeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysSearchSchemeBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysSearchSchemeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSearchSchemeBase pSSysSearchSchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchSchemeBase.getAuthClientId() == null;
            }
            case 1: {
                return pSSysSearchSchemeBase.getAuthClientSecret() == null;
            }
            case 2: {
                return pSSysSearchSchemeBase.getAuthMode() == null;
            }
            case 3: {
                return pSSysSearchSchemeBase.getAuthParam() == null;
            }
            case 4: {
                return pSSysSearchSchemeBase.getAuthParam2() == null;
            }
            case 5: {
                return pSSysSearchSchemeBase.getCodeName() == null;
            }
            case 6: {
                return pSSysSearchSchemeBase.getCodeName2() == null;
            }
            case 7: {
                return pSSysSearchSchemeBase.getCreateDate() == null;
            }
            case 8: {
                return pSSysSearchSchemeBase.getCreateMan() == null;
            }
            case 9: {
                return pSSysSearchSchemeBase.getDocReplicas() == null;
            }
            case 10: {
                return pSSysSearchSchemeBase.getDocShards() == null;
            }
            case 11: {
                return pSSysSearchSchemeBase.getEnableServiceAPI() == null;
            }
            case 12: {
                return pSSysSearchSchemeBase.getEnableSubSysServiceAPI() == null;
            }
            case 13: {
                return pSSysSearchSchemeBase.getMemo() == null;
            }
            case 14: {
                return pSSysSearchSchemeBase.getObjNameCase() == null;
            }
            case 15: {
                return pSSysSearchSchemeBase.getOrderValue() == null;
            }
            case 16: {
                return pSSysSearchSchemeBase.getPSModuleId() == null;
            }
            case 17: {
                return pSSysSearchSchemeBase.getPSModuleName() == null;
            }
            case 18: {
                return pSSysSearchSchemeBase.getPSSubSysServiceAPIId() == null;
            }
            case 19: {
                return pSSysSearchSchemeBase.getPSSubSysServiceAPIName() == null;
            }
            case 20: {
                return pSSysSearchSchemeBase.getPSSysDynaModelId() == null;
            }
            case 21: {
                return pSSysSearchSchemeBase.getPSSysDynaModelName() == null;
            }
            case 22: {
                return pSSysSearchSchemeBase.getPSSysModelGroupId() == null;
            }
            case 23: {
                return pSSysSearchSchemeBase.getPSSysModelGroupName() == null;
            }
            case 24: {
                return pSSysSearchSchemeBase.getPSSysSearchSchemeId() == null;
            }
            case 25: {
                return pSSysSearchSchemeBase.getPSSysSearchSchemeName() == null;
            }
            case 26: {
                return pSSysSearchSchemeBase.getPSSysServiceAPIId() == null;
            }
            case 27: {
                return pSSysSearchSchemeBase.getPSSysServiceAPIName() == null;
            }
            case 28: {
                return pSSysSearchSchemeBase.getPSSysSFPluginId() == null;
            }
            case 29: {
                return pSSysSearchSchemeBase.getPSSysSFPluginName() == null;
            }
            case 30: {
                return pSSysSearchSchemeBase.getPSSystemId() == null;
            }
            case 31: {
                return pSSysSearchSchemeBase.getPSSystemName() == null;
            }
            case 32: {
                return pSSysSearchSchemeBase.getSchemeParams() == null;
            }
            case 33: {
                return pSSysSearchSchemeBase.getSchemeTag() == null;
            }
            case 34: {
                return pSSysSearchSchemeBase.getSchemeTag2() == null;
            }
            case 35: {
                return pSSysSearchSchemeBase.getSearchEngineType() == null;
            }
            case 36: {
                return pSSysSearchSchemeBase.getServiceCodeName() == null;
            }
            case 37: {
                return pSSysSearchSchemeBase.getServiceParam() == null;
            }
            case 38: {
                return pSSysSearchSchemeBase.getServiceParam2() == null;
            }
            case 39: {
                return pSSysSearchSchemeBase.getServicePath() == null;
            }
            case 40: {
                return pSSysSearchSchemeBase.getSubSysServiceCodeName() == null;
            }
            case 41: {
                return pSSysSearchSchemeBase.getUpdateDate() == null;
            }
            case 42: {
                return pSSysSearchSchemeBase.getUpdateMan() == null;
            }
            case 43: {
                return pSSysSearchSchemeBase.getUserCat() == null;
            }
            case 44: {
                return pSSysSearchSchemeBase.getUserTag() == null;
            }
            case 45: {
                return pSSysSearchSchemeBase.getUserTag2() == null;
            }
            case 46: {
                return pSSysSearchSchemeBase.getUserTag3() == null;
            }
            case 47: {
                return pSSysSearchSchemeBase.getUserTag4() == null;
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
        return PSSysSearchSchemeBase.contains(this, n);
    }

    private static boolean contains(PSSysSearchSchemeBase pSSysSearchSchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSearchSchemeBase.isAuthClientIdDirty();
            }
            case 1: {
                return pSSysSearchSchemeBase.isAuthClientSecretDirty();
            }
            case 2: {
                return pSSysSearchSchemeBase.isAuthModeDirty();
            }
            case 3: {
                return pSSysSearchSchemeBase.isAuthParamDirty();
            }
            case 4: {
                return pSSysSearchSchemeBase.isAuthParam2Dirty();
            }
            case 5: {
                return pSSysSearchSchemeBase.isCodeNameDirty();
            }
            case 6: {
                return pSSysSearchSchemeBase.isCodeName2Dirty();
            }
            case 7: {
                return pSSysSearchSchemeBase.isCreateDateDirty();
            }
            case 8: {
                return pSSysSearchSchemeBase.isCreateManDirty();
            }
            case 9: {
                return pSSysSearchSchemeBase.isDocReplicasDirty();
            }
            case 10: {
                return pSSysSearchSchemeBase.isDocShardsDirty();
            }
            case 11: {
                return pSSysSearchSchemeBase.isEnableServiceAPIDirty();
            }
            case 12: {
                return pSSysSearchSchemeBase.isEnableSubSysServiceAPIDirty();
            }
            case 13: {
                return pSSysSearchSchemeBase.isMemoDirty();
            }
            case 14: {
                return pSSysSearchSchemeBase.isObjNameCaseDirty();
            }
            case 15: {
                return pSSysSearchSchemeBase.isOrderValueDirty();
            }
            case 16: {
                return pSSysSearchSchemeBase.isPSModuleIdDirty();
            }
            case 17: {
                return pSSysSearchSchemeBase.isPSModuleNameDirty();
            }
            case 18: {
                return pSSysSearchSchemeBase.isPSSubSysServiceAPIIdDirty();
            }
            case 19: {
                return pSSysSearchSchemeBase.isPSSubSysServiceAPINameDirty();
            }
            case 20: {
                return pSSysSearchSchemeBase.isPSSysDynaModelIdDirty();
            }
            case 21: {
                return pSSysSearchSchemeBase.isPSSysDynaModelNameDirty();
            }
            case 22: {
                return pSSysSearchSchemeBase.isPSSysModelGroupIdDirty();
            }
            case 23: {
                return pSSysSearchSchemeBase.isPSSysModelGroupNameDirty();
            }
            case 24: {
                return pSSysSearchSchemeBase.isPSSysSearchSchemeIdDirty();
            }
            case 25: {
                return pSSysSearchSchemeBase.isPSSysSearchSchemeNameDirty();
            }
            case 26: {
                return pSSysSearchSchemeBase.isPSSysServiceAPIIdDirty();
            }
            case 27: {
                return pSSysSearchSchemeBase.isPSSysServiceAPINameDirty();
            }
            case 28: {
                return pSSysSearchSchemeBase.isPSSysSFPluginIdDirty();
            }
            case 29: {
                return pSSysSearchSchemeBase.isPSSysSFPluginNameDirty();
            }
            case 30: {
                return pSSysSearchSchemeBase.isPSSystemIdDirty();
            }
            case 31: {
                return pSSysSearchSchemeBase.isPSSystemNameDirty();
            }
            case 32: {
                return pSSysSearchSchemeBase.isSchemeParamsDirty();
            }
            case 33: {
                return pSSysSearchSchemeBase.isSchemeTagDirty();
            }
            case 34: {
                return pSSysSearchSchemeBase.isSchemeTag2Dirty();
            }
            case 35: {
                return pSSysSearchSchemeBase.isSearchEngineTypeDirty();
            }
            case 36: {
                return pSSysSearchSchemeBase.isServiceCodeNameDirty();
            }
            case 37: {
                return pSSysSearchSchemeBase.isServiceParamDirty();
            }
            case 38: {
                return pSSysSearchSchemeBase.isServiceParam2Dirty();
            }
            case 39: {
                return pSSysSearchSchemeBase.isServicePathDirty();
            }
            case 40: {
                return pSSysSearchSchemeBase.isSubSysServiceCodeNameDirty();
            }
            case 41: {
                return pSSysSearchSchemeBase.isUpdateDateDirty();
            }
            case 42: {
                return pSSysSearchSchemeBase.isUpdateManDirty();
            }
            case 43: {
                return pSSysSearchSchemeBase.isUserCatDirty();
            }
            case 44: {
                return pSSysSearchSchemeBase.isUserTagDirty();
            }
            case 45: {
                return pSSysSearchSchemeBase.isUserTag2Dirty();
            }
            case 46: {
                return pSSysSearchSchemeBase.isUserTag3Dirty();
            }
            case 47: {
                return pSSysSearchSchemeBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSearchSchemeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSearchSchemeBase pSSysSearchSchemeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSearchSchemeBase.getAuthClientId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientid", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getAuthClientId()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getAuthClientSecret() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientsecret", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getAuthClientSecret()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getAuthMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authmode", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getAuthMode()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getAuthParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getAuthParam()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getAuthParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam2", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getAuthParam2()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getDocReplicas() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"docreplicas", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getDocReplicas()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getDocShards() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"docshards", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getDocShards()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getEnableServiceAPI() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableserviceapi", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getEnableServiceAPI()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getEnableSubSysServiceAPI() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesubsysserviceapi", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getEnableSubSysServiceAPI()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getObjNameCase() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objnamecase", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getObjNameCase()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSSubSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiname", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSSubSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysModelGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupid", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSSysModelGroupId()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysModelGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupname", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSSysModelGroupName()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysSearchSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchschemeid", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSSysSearchSchemeId()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysSearchSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchschemename", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSSysSearchSchemeName()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getSchemeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"schemeparams", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getSchemeParams()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getSchemeTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"schemetag", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getSchemeTag()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getSchemeTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"schemetag2", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getSchemeTag2()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getSearchEngineType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchenginetype", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getSearchEngineType()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getServiceParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getServiceParam()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getServiceParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam2", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getServiceParam2()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getServicePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicepath", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getServicePath()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getSubSysServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subsysservicecodename", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getSubSysServiceCodeName()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysSearchSchemeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysSearchSchemeBase.getJSONValue((Object)pSSysSearchSchemeBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSearchSchemeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSearchSchemeBase pSSysSearchSchemeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSearchSchemeBase.getAuthClientId() != null) {
            object = pSSysSearchSchemeBase.getAuthClientId();
            xmlNode.setAttribute(FIELD_AUTHCLIENTID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysSearchSchemeBase.getAuthClientSecret() != null) {
            object = pSSysSearchSchemeBase.getAuthClientSecret();
            xmlNode.setAttribute(FIELD_AUTHCLIENTSECRET, (String)(object == null ? "" : object));
        }
        if (bl || pSSysSearchSchemeBase.getAuthMode() != null) {
            object = pSSysSearchSchemeBase.getAuthMode();
            xmlNode.setAttribute(FIELD_AUTHMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysSearchSchemeBase.getAuthParam() != null) {
            object = pSSysSearchSchemeBase.getAuthParam();
            xmlNode.setAttribute(FIELD_AUTHPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSSysSearchSchemeBase.getAuthParam2() != null) {
            object = pSSysSearchSchemeBase.getAuthParam2();
            xmlNode.setAttribute(FIELD_AUTHPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysSearchSchemeBase.getCodeName() != null) {
            object = pSSysSearchSchemeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysSearchSchemeBase.getCodeName2() != null) {
            object = pSSysSearchSchemeBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getCreateDate() != null) {
            object = pSSysSearchSchemeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchSchemeBase.getCreateMan() != null) {
            object = pSSysSearchSchemeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getDocReplicas() != null) {
            object = pSSysSearchSchemeBase.getDocReplicas();
            xmlNode.setAttribute(FIELD_DOCREPLICAS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchSchemeBase.getDocShards() != null) {
            object = pSSysSearchSchemeBase.getDocShards();
            xmlNode.setAttribute(FIELD_DOCSHARDS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchSchemeBase.getEnableServiceAPI() != null) {
            object = pSSysSearchSchemeBase.getEnableServiceAPI();
            xmlNode.setAttribute(FIELD_ENABLESERVICEAPI, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchSchemeBase.getEnableSubSysServiceAPI() != null) {
            object = pSSysSearchSchemeBase.getEnableSubSysServiceAPI();
            xmlNode.setAttribute(FIELD_ENABLESUBSYSSERVICEAPI, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchSchemeBase.getMemo() != null) {
            object = pSSysSearchSchemeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getObjNameCase() != null) {
            object = pSSysSearchSchemeBase.getObjNameCase();
            xmlNode.setAttribute(FIELD_OBJNAMECASE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getOrderValue() != null) {
            object = pSSysSearchSchemeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSearchSchemeBase.getPSModuleId() != null) {
            object = pSSysSearchSchemeBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getPSModuleName() != null) {
            object = pSSysSearchSchemeBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getPSSubSysServiceAPIId() != null) {
            object = pSSysSearchSchemeBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getPSSubSysServiceAPIName() != null) {
            object = pSSysSearchSchemeBase.getPSSubSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysDynaModelId() != null) {
            object = pSSysSearchSchemeBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysDynaModelName() != null) {
            object = pSSysSearchSchemeBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysModelGroupId() != null) {
            object = pSSysSearchSchemeBase.getPSSysModelGroupId();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysModelGroupName() != null) {
            object = pSSysSearchSchemeBase.getPSSysModelGroupName();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysSearchSchemeId() != null) {
            object = pSSysSearchSchemeBase.getPSSysSearchSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysSearchSchemeName() != null) {
            object = pSSysSearchSchemeBase.getPSSysSearchSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysServiceAPIId() != null) {
            object = pSSysSearchSchemeBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysServiceAPIName() != null) {
            object = pSSysSearchSchemeBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysSFPluginId() != null) {
            object = pSSysSearchSchemeBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getPSSysSFPluginName() != null) {
            object = pSSysSearchSchemeBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getPSSystemId() != null) {
            object = pSSysSearchSchemeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getPSSystemName() != null) {
            object = pSSysSearchSchemeBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getSchemeParams() != null) {
            object = pSSysSearchSchemeBase.getSchemeParams();
            xmlNode.setAttribute(FIELD_SCHEMEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getSchemeTag() != null) {
            object = pSSysSearchSchemeBase.getSchemeTag();
            xmlNode.setAttribute(FIELD_SCHEMETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getSchemeTag2() != null) {
            object = pSSysSearchSchemeBase.getSchemeTag2();
            xmlNode.setAttribute(FIELD_SCHEMETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getSearchEngineType() != null) {
            object = pSSysSearchSchemeBase.getSearchEngineType();
            xmlNode.setAttribute(FIELD_SEARCHENGINETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getServiceCodeName() != null) {
            object = pSSysSearchSchemeBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getServiceParam() != null) {
            object = pSSysSearchSchemeBase.getServiceParam();
            xmlNode.setAttribute(FIELD_SERVICEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getServiceParam2() != null) {
            object = pSSysSearchSchemeBase.getServiceParam2();
            xmlNode.setAttribute(FIELD_SERVICEPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getServicePath() != null) {
            object = pSSysSearchSchemeBase.getServicePath();
            xmlNode.setAttribute(FIELD_SERVICEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getSubSysServiceCodeName() != null) {
            object = pSSysSearchSchemeBase.getSubSysServiceCodeName();
            xmlNode.setAttribute(FIELD_SUBSYSSERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getUpdateDate() != null) {
            object = pSSysSearchSchemeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSearchSchemeBase.getUpdateMan() != null) {
            object = pSSysSearchSchemeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getUserCat() != null) {
            object = pSSysSearchSchemeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getUserTag() != null) {
            object = pSSysSearchSchemeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getUserTag2() != null) {
            object = pSSysSearchSchemeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getUserTag3() != null) {
            object = pSSysSearchSchemeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSearchSchemeBase.getUserTag4() != null) {
            object = pSSysSearchSchemeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSearchSchemeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSearchSchemeBase pSSysSearchSchemeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSearchSchemeBase.isAuthClientIdDirty() && (bl || pSSysSearchSchemeBase.getAuthClientId() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTID, (Object)pSSysSearchSchemeBase.getAuthClientId());
        }
        if (pSSysSearchSchemeBase.isAuthClientSecretDirty() && (bl || pSSysSearchSchemeBase.getAuthClientSecret() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTSECRET, (Object)pSSysSearchSchemeBase.getAuthClientSecret());
        }
        if (pSSysSearchSchemeBase.isAuthModeDirty() && (bl || pSSysSearchSchemeBase.getAuthMode() != null)) {
            iDataObject.set(FIELD_AUTHMODE, (Object)pSSysSearchSchemeBase.getAuthMode());
        }
        if (pSSysSearchSchemeBase.isAuthParamDirty() && (bl || pSSysSearchSchemeBase.getAuthParam() != null)) {
            iDataObject.set(FIELD_AUTHPARAM, (Object)pSSysSearchSchemeBase.getAuthParam());
        }
        if (pSSysSearchSchemeBase.isAuthParam2Dirty() && (bl || pSSysSearchSchemeBase.getAuthParam2() != null)) {
            iDataObject.set(FIELD_AUTHPARAM2, (Object)pSSysSearchSchemeBase.getAuthParam2());
        }
        if (pSSysSearchSchemeBase.isCodeNameDirty() && (bl || pSSysSearchSchemeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysSearchSchemeBase.getCodeName());
        }
        if (pSSysSearchSchemeBase.isCodeName2Dirty() && (bl || pSSysSearchSchemeBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSSysSearchSchemeBase.getCodeName2());
        }
        if (pSSysSearchSchemeBase.isCreateDateDirty() && (bl || pSSysSearchSchemeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSearchSchemeBase.getCreateDate());
        }
        if (pSSysSearchSchemeBase.isCreateManDirty() && (bl || pSSysSearchSchemeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSearchSchemeBase.getCreateMan());
        }
        if (pSSysSearchSchemeBase.isDocReplicasDirty() && (bl || pSSysSearchSchemeBase.getDocReplicas() != null)) {
            iDataObject.set(FIELD_DOCREPLICAS, (Object)pSSysSearchSchemeBase.getDocReplicas());
        }
        if (pSSysSearchSchemeBase.isDocShardsDirty() && (bl || pSSysSearchSchemeBase.getDocShards() != null)) {
            iDataObject.set(FIELD_DOCSHARDS, (Object)pSSysSearchSchemeBase.getDocShards());
        }
        if (pSSysSearchSchemeBase.isEnableServiceAPIDirty() && (bl || pSSysSearchSchemeBase.getEnableServiceAPI() != null)) {
            iDataObject.set(FIELD_ENABLESERVICEAPI, (Object)pSSysSearchSchemeBase.getEnableServiceAPI());
        }
        if (pSSysSearchSchemeBase.isEnableSubSysServiceAPIDirty() && (bl || pSSysSearchSchemeBase.getEnableSubSysServiceAPI() != null)) {
            iDataObject.set(FIELD_ENABLESUBSYSSERVICEAPI, (Object)pSSysSearchSchemeBase.getEnableSubSysServiceAPI());
        }
        if (pSSysSearchSchemeBase.isMemoDirty() && (bl || pSSysSearchSchemeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSearchSchemeBase.getMemo());
        }
        if (pSSysSearchSchemeBase.isObjNameCaseDirty() && (bl || pSSysSearchSchemeBase.getObjNameCase() != null)) {
            iDataObject.set(FIELD_OBJNAMECASE, (Object)pSSysSearchSchemeBase.getObjNameCase());
        }
        if (pSSysSearchSchemeBase.isOrderValueDirty() && (bl || pSSysSearchSchemeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysSearchSchemeBase.getOrderValue());
        }
        if (pSSysSearchSchemeBase.isPSModuleIdDirty() && (bl || pSSysSearchSchemeBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysSearchSchemeBase.getPSModuleId());
        }
        if (pSSysSearchSchemeBase.isPSModuleNameDirty() && (bl || pSSysSearchSchemeBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysSearchSchemeBase.getPSModuleName());
        }
        if (pSSysSearchSchemeBase.isPSSubSysServiceAPIIdDirty() && (bl || pSSysSearchSchemeBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSSysSearchSchemeBase.getPSSubSysServiceAPIId());
        }
        if (pSSysSearchSchemeBase.isPSSubSysServiceAPINameDirty() && (bl || pSSysSearchSchemeBase.getPSSubSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPINAME, (Object)pSSysSearchSchemeBase.getPSSubSysServiceAPIName());
        }
        if (pSSysSearchSchemeBase.isPSSysDynaModelIdDirty() && (bl || pSSysSearchSchemeBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysSearchSchemeBase.getPSSysDynaModelId());
        }
        if (pSSysSearchSchemeBase.isPSSysDynaModelNameDirty() && (bl || pSSysSearchSchemeBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysSearchSchemeBase.getPSSysDynaModelName());
        }
        if (pSSysSearchSchemeBase.isPSSysModelGroupIdDirty() && (bl || pSSysSearchSchemeBase.getPSSysModelGroupId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPID, (Object)pSSysSearchSchemeBase.getPSSysModelGroupId());
        }
        if (pSSysSearchSchemeBase.isPSSysModelGroupNameDirty() && (bl || pSSysSearchSchemeBase.getPSSysModelGroupName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPNAME, (Object)pSSysSearchSchemeBase.getPSSysModelGroupName());
        }
        if (pSSysSearchSchemeBase.isPSSysSearchSchemeIdDirty() && (bl || pSSysSearchSchemeBase.getPSSysSearchSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHSCHEMEID, (Object)pSSysSearchSchemeBase.getPSSysSearchSchemeId());
        }
        if (pSSysSearchSchemeBase.isPSSysSearchSchemeNameDirty() && (bl || pSSysSearchSchemeBase.getPSSysSearchSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHSCHEMENAME, (Object)pSSysSearchSchemeBase.getPSSysSearchSchemeName());
        }
        if (pSSysSearchSchemeBase.isPSSysServiceAPIIdDirty() && (bl || pSSysSearchSchemeBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSSysSearchSchemeBase.getPSSysServiceAPIId());
        }
        if (pSSysSearchSchemeBase.isPSSysServiceAPINameDirty() && (bl || pSSysSearchSchemeBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSSysSearchSchemeBase.getPSSysServiceAPIName());
        }
        if (pSSysSearchSchemeBase.isPSSysSFPluginIdDirty() && (bl || pSSysSearchSchemeBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysSearchSchemeBase.getPSSysSFPluginId());
        }
        if (pSSysSearchSchemeBase.isPSSysSFPluginNameDirty() && (bl || pSSysSearchSchemeBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysSearchSchemeBase.getPSSysSFPluginName());
        }
        if (pSSysSearchSchemeBase.isPSSystemIdDirty() && (bl || pSSysSearchSchemeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysSearchSchemeBase.getPSSystemId());
        }
        if (pSSysSearchSchemeBase.isPSSystemNameDirty() && (bl || pSSysSearchSchemeBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysSearchSchemeBase.getPSSystemName());
        }
        if (pSSysSearchSchemeBase.isSchemeParamsDirty() && (bl || pSSysSearchSchemeBase.getSchemeParams() != null)) {
            iDataObject.set(FIELD_SCHEMEPARAMS, (Object)pSSysSearchSchemeBase.getSchemeParams());
        }
        if (pSSysSearchSchemeBase.isSchemeTagDirty() && (bl || pSSysSearchSchemeBase.getSchemeTag() != null)) {
            iDataObject.set(FIELD_SCHEMETAG, (Object)pSSysSearchSchemeBase.getSchemeTag());
        }
        if (pSSysSearchSchemeBase.isSchemeTag2Dirty() && (bl || pSSysSearchSchemeBase.getSchemeTag2() != null)) {
            iDataObject.set(FIELD_SCHEMETAG2, (Object)pSSysSearchSchemeBase.getSchemeTag2());
        }
        if (pSSysSearchSchemeBase.isSearchEngineTypeDirty() && (bl || pSSysSearchSchemeBase.getSearchEngineType() != null)) {
            iDataObject.set(FIELD_SEARCHENGINETYPE, (Object)pSSysSearchSchemeBase.getSearchEngineType());
        }
        if (pSSysSearchSchemeBase.isServiceCodeNameDirty() && (bl || pSSysSearchSchemeBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSSysSearchSchemeBase.getServiceCodeName());
        }
        if (pSSysSearchSchemeBase.isServiceParamDirty() && (bl || pSSysSearchSchemeBase.getServiceParam() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM, (Object)pSSysSearchSchemeBase.getServiceParam());
        }
        if (pSSysSearchSchemeBase.isServiceParam2Dirty() && (bl || pSSysSearchSchemeBase.getServiceParam2() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM2, (Object)pSSysSearchSchemeBase.getServiceParam2());
        }
        if (pSSysSearchSchemeBase.isServicePathDirty() && (bl || pSSysSearchSchemeBase.getServicePath() != null)) {
            iDataObject.set(FIELD_SERVICEPATH, (Object)pSSysSearchSchemeBase.getServicePath());
        }
        if (pSSysSearchSchemeBase.isSubSysServiceCodeNameDirty() && (bl || pSSysSearchSchemeBase.getSubSysServiceCodeName() != null)) {
            iDataObject.set(FIELD_SUBSYSSERVICECODENAME, (Object)pSSysSearchSchemeBase.getSubSysServiceCodeName());
        }
        if (pSSysSearchSchemeBase.isUpdateDateDirty() && (bl || pSSysSearchSchemeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSearchSchemeBase.getUpdateDate());
        }
        if (pSSysSearchSchemeBase.isUpdateManDirty() && (bl || pSSysSearchSchemeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSearchSchemeBase.getUpdateMan());
        }
        if (pSSysSearchSchemeBase.isUserCatDirty() && (bl || pSSysSearchSchemeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysSearchSchemeBase.getUserCat());
        }
        if (pSSysSearchSchemeBase.isUserTagDirty() && (bl || pSSysSearchSchemeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSearchSchemeBase.getUserTag());
        }
        if (pSSysSearchSchemeBase.isUserTag2Dirty() && (bl || pSSysSearchSchemeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSearchSchemeBase.getUserTag2());
        }
        if (pSSysSearchSchemeBase.isUserTag3Dirty() && (bl || pSSysSearchSchemeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysSearchSchemeBase.getUserTag3());
        }
        if (pSSysSearchSchemeBase.isUserTag4Dirty() && (bl || pSSysSearchSchemeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysSearchSchemeBase.getUserTag4());
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
        return PSSysSearchSchemeBase.remove(this, n);
    }

    private static boolean remove(PSSysSearchSchemeBase pSSysSearchSchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSearchSchemeBase.resetAuthClientId();
                return true;
            }
            case 1: {
                pSSysSearchSchemeBase.resetAuthClientSecret();
                return true;
            }
            case 2: {
                pSSysSearchSchemeBase.resetAuthMode();
                return true;
            }
            case 3: {
                pSSysSearchSchemeBase.resetAuthParam();
                return true;
            }
            case 4: {
                pSSysSearchSchemeBase.resetAuthParam2();
                return true;
            }
            case 5: {
                pSSysSearchSchemeBase.resetCodeName();
                return true;
            }
            case 6: {
                pSSysSearchSchemeBase.resetCodeName2();
                return true;
            }
            case 7: {
                pSSysSearchSchemeBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSSysSearchSchemeBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSSysSearchSchemeBase.resetDocReplicas();
                return true;
            }
            case 10: {
                pSSysSearchSchemeBase.resetDocShards();
                return true;
            }
            case 11: {
                pSSysSearchSchemeBase.resetEnableServiceAPI();
                return true;
            }
            case 12: {
                pSSysSearchSchemeBase.resetEnableSubSysServiceAPI();
                return true;
            }
            case 13: {
                pSSysSearchSchemeBase.resetMemo();
                return true;
            }
            case 14: {
                pSSysSearchSchemeBase.resetObjNameCase();
                return true;
            }
            case 15: {
                pSSysSearchSchemeBase.resetOrderValue();
                return true;
            }
            case 16: {
                pSSysSearchSchemeBase.resetPSModuleId();
                return true;
            }
            case 17: {
                pSSysSearchSchemeBase.resetPSModuleName();
                return true;
            }
            case 18: {
                pSSysSearchSchemeBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 19: {
                pSSysSearchSchemeBase.resetPSSubSysServiceAPIName();
                return true;
            }
            case 20: {
                pSSysSearchSchemeBase.resetPSSysDynaModelId();
                return true;
            }
            case 21: {
                pSSysSearchSchemeBase.resetPSSysDynaModelName();
                return true;
            }
            case 22: {
                pSSysSearchSchemeBase.resetPSSysModelGroupId();
                return true;
            }
            case 23: {
                pSSysSearchSchemeBase.resetPSSysModelGroupName();
                return true;
            }
            case 24: {
                pSSysSearchSchemeBase.resetPSSysSearchSchemeId();
                return true;
            }
            case 25: {
                pSSysSearchSchemeBase.resetPSSysSearchSchemeName();
                return true;
            }
            case 26: {
                pSSysSearchSchemeBase.resetPSSysServiceAPIId();
                return true;
            }
            case 27: {
                pSSysSearchSchemeBase.resetPSSysServiceAPIName();
                return true;
            }
            case 28: {
                pSSysSearchSchemeBase.resetPSSysSFPluginId();
                return true;
            }
            case 29: {
                pSSysSearchSchemeBase.resetPSSysSFPluginName();
                return true;
            }
            case 30: {
                pSSysSearchSchemeBase.resetPSSystemId();
                return true;
            }
            case 31: {
                pSSysSearchSchemeBase.resetPSSystemName();
                return true;
            }
            case 32: {
                pSSysSearchSchemeBase.resetSchemeParams();
                return true;
            }
            case 33: {
                pSSysSearchSchemeBase.resetSchemeTag();
                return true;
            }
            case 34: {
                pSSysSearchSchemeBase.resetSchemeTag2();
                return true;
            }
            case 35: {
                pSSysSearchSchemeBase.resetSearchEngineType();
                return true;
            }
            case 36: {
                pSSysSearchSchemeBase.resetServiceCodeName();
                return true;
            }
            case 37: {
                pSSysSearchSchemeBase.resetServiceParam();
                return true;
            }
            case 38: {
                pSSysSearchSchemeBase.resetServiceParam2();
                return true;
            }
            case 39: {
                pSSysSearchSchemeBase.resetServicePath();
                return true;
            }
            case 40: {
                pSSysSearchSchemeBase.resetSubSysServiceCodeName();
                return true;
            }
            case 41: {
                pSSysSearchSchemeBase.resetUpdateDate();
                return true;
            }
            case 42: {
                pSSysSearchSchemeBase.resetUpdateMan();
                return true;
            }
            case 43: {
                pSSysSearchSchemeBase.resetUserCat();
                return true;
            }
            case 44: {
                pSSysSearchSchemeBase.resetUserTag();
                return true;
            }
            case 45: {
                pSSysSearchSchemeBase.resetUserTag2();
                return true;
            }
            case 46: {
                pSSysSearchSchemeBase.resetUserTag3();
                return true;
            }
            case 47: {
                pSSysSearchSchemeBase.resetUserTag4();
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
                pSModuleService.autoGet((IEntity)pSModule);
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
                pSSubSysServiceAPIService.autoGet((IEntity)pSSubSysServiceAPI);
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
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
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
                pSSysModelGroupService.autoGet((IEntity)pSSysModelGroup);
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
                pSSysServiceAPIService.autoGet((IEntity)pSSysServiceAPI);
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
    public ArrayList<PSSysSearchDE> getPSSysSearchDEs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDEs();
        }
        if (this.getPSSysSearchSchemeId() == null) {
            return null;
        }
        PSSysSearchDEService pSSysSearchDEService = (PSSysSearchDEService)ServiceGlobal.getService(PSSysSearchDEService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSearchDEsLock;
        synchronized (n) {
            if (this.pssyssearchdes == null) {
                this.pssyssearchdes = pSSysSearchDEService.selectByPSSysSearchScheme(this);
            }
            return this.pssyssearchdes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysSearchDoc> getPSSysSearchDocs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDocs();
        }
        if (this.getPSSysSearchSchemeId() == null) {
            return null;
        }
        PSSysSearchDocService pSSysSearchDocService = (PSSysSearchDocService)ServiceGlobal.getService(PSSysSearchDocService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysSearchDocsLock;
        synchronized (n) {
            if (this.pssyssearchdocs == null) {
                this.pssyssearchdocs = pSSysSearchDocService.selectByPSSysSearchScheme(this);
            }
            return this.pssyssearchdocs;
        }
    }

    private PSSysSearchSchemeBase getProxyEntity() {
        return this.proxyPSSysSearchSchemeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSearchSchemeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSearchSchemeBase) {
            this.proxyPSSysSearchSchemeBase = (PSSysSearchSchemeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AUTHCLIENTID, 0);
        fieldIndexMap.put(FIELD_AUTHCLIENTSECRET, 1);
        fieldIndexMap.put(FIELD_AUTHMODE, 2);
        fieldIndexMap.put(FIELD_AUTHPARAM, 3);
        fieldIndexMap.put(FIELD_AUTHPARAM2, 4);
        fieldIndexMap.put(FIELD_CODENAME, 5);
        fieldIndexMap.put(FIELD_CODENAME2, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_DOCREPLICAS, 9);
        fieldIndexMap.put(FIELD_DOCSHARDS, 10);
        fieldIndexMap.put(FIELD_ENABLESERVICEAPI, 11);
        fieldIndexMap.put(FIELD_ENABLESUBSYSSERVICEAPI, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_OBJNAMECASE, 14);
        fieldIndexMap.put(FIELD_ORDERVALUE, 15);
        fieldIndexMap.put(FIELD_PSMODULEID, 16);
        fieldIndexMap.put(FIELD_PSMODULENAME, 17);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 18);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPINAME, 19);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 20);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSMODELGROUPID, 22);
        fieldIndexMap.put(FIELD_PSSYSMODELGROUPNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSSEARCHSCHEMEID, 24);
        fieldIndexMap.put(FIELD_PSSYSSEARCHSCHEMENAME, 25);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 26);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPINAME, 27);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 28);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 29);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 30);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 31);
        fieldIndexMap.put(FIELD_SCHEMEPARAMS, 32);
        fieldIndexMap.put(FIELD_SCHEMETAG, 33);
        fieldIndexMap.put(FIELD_SCHEMETAG2, 34);
        fieldIndexMap.put(FIELD_SEARCHENGINETYPE, 35);
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

