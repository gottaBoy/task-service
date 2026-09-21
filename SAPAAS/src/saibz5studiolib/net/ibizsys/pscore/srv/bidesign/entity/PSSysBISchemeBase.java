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
package net.ibizsys.pscore.srv.bidesign.entity;

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
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIAggTable;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICube;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReport;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggTableService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportService;
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

public abstract class PSSysBISchemeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBISchemeBase.class);
    public static final String FIELD_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String FIELD_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String FIELD_AUTHMODE = "AUTHMODE";
    public static final String FIELD_AUTHPARAM = "AUTHPARAM";
    public static final String FIELD_AUTHPARAM2 = "AUTHPARAM2";
    public static final String FIELD_BIENGINETYPE = "BIENGINETYPE";
    public static final String FIELD_BISCHEMETAG = "BISCHEMETAG";
    public static final String FIELD_BISCHEMETAG2 = "BISCHEMETAG2";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String FIELD_ENABLESERVICEAPI = "ENABLESERVICEAPI";
    public static final String FIELD_ENABLESUBSYSSERVICEAPI = "ENABLESUBSYSSERVICEAPI";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OBJNAMECASE = "OBJNAMECASE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String FIELD_PSSYSBISCHEMENAME = "PSSYSBISCHEMENAME";
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
    private static final int INDEX_BIENGINETYPE = 5;
    private static final int INDEX_BISCHEMETAG = 6;
    private static final int INDEX_BISCHEMETAG2 = 7;
    private static final int INDEX_CODENAME = 8;
    private static final int INDEX_CREATEDATE = 9;
    private static final int INDEX_CREATEMAN = 10;
    private static final int INDEX_ENABLECUSTOMIZED = 11;
    private static final int INDEX_ENABLESERVICEAPI = 12;
    private static final int INDEX_ENABLESUBSYSSERVICEAPI = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_OBJNAMECASE = 15;
    private static final int INDEX_ORDERVALUE = 16;
    private static final int INDEX_PSMODULEID = 17;
    private static final int INDEX_PSMODULENAME = 18;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 19;
    private static final int INDEX_PSSUBSYSSERVICEAPINAME = 20;
    private static final int INDEX_PSSYSBISCHEMEID = 21;
    private static final int INDEX_PSSYSBISCHEMENAME = 22;
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
    private static final int INDEX_SERVICECODENAME = 34;
    private static final int INDEX_SERVICEPARAM = 35;
    private static final int INDEX_SERVICEPARAM2 = 36;
    private static final int INDEX_SERVICEPATH = 37;
    private static final int INDEX_SUBSYSSERVICECODENAME = 38;
    private static final int INDEX_UPDATEDATE = 39;
    private static final int INDEX_UPDATEMAN = 40;
    private static final int INDEX_USERCAT = 41;
    private static final int INDEX_USERTAG = 42;
    private static final int INDEX_USERTAG2 = 43;
    private static final int INDEX_USERTAG3 = 44;
    private static final int INDEX_USERTAG4 = 45;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBISchemeBase proxyPSSysBISchemeBase = null;
    private boolean authclientidDirtyFlag = false;
    private boolean authclientsecretDirtyFlag = false;
    private boolean authmodeDirtyFlag = false;
    private boolean authparamDirtyFlag = false;
    private boolean authparam2DirtyFlag = false;
    private boolean bienginetypeDirtyFlag = false;
    private boolean bischemetagDirtyFlag = false;
    private boolean bischemetag2DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablecustomizedDirtyFlag = false;
    private boolean enableserviceapiDirtyFlag = false;
    private boolean enablesubsysserviceapiDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean objnamecaseDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssubsysserviceapinameDirtyFlag = false;
    private boolean pssysbischemeidDirtyFlag = false;
    private boolean pssysbischemenameDirtyFlag = false;
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
    @Column(name="bienginetype")
    private String bienginetype;
    @Column(name="bischemetag")
    private String bischemetag;
    @Column(name="bischemetag2")
    private String bischemetag2;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enablecustomized")
    private Integer enablecustomized;
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
    @Column(name="pssysbischemeid")
    private String pssysbischemeid;
    @Column(name="pssysbischemename")
    private String pssysbischemename;
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
    private Integer objPSSysBIAggTablesLock = new Integer(1);
    private ArrayList<PSSysBIAggTable> pssysbiaggtables = null;
    private Integer objPSSysBICubesLock = new Integer(1);
    private ArrayList<PSSysBICube> pssysbicubes = null;
    private Integer objPSSysBIReportsLock = new Integer(1);
    private ArrayList<PSSysBIReport> pssysbireports = null;

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

    public void setBIEngineType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIEngineType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bienginetype = string;
        this.bienginetypeDirtyFlag = true;
    }

    public String getBIEngineType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIEngineType();
        }
        return this.bienginetype;
    }

    public boolean isBIEngineTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIEngineTypeDirty();
        }
        return this.bienginetypeDirtyFlag;
    }

    public void resetBIEngineType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIEngineType();
            return;
        }
        this.bienginetypeDirtyFlag = false;
        this.bienginetype = null;
    }

    public void setBISchemeTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBISchemeTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bischemetag = string;
        this.bischemetagDirtyFlag = true;
    }

    public String getBISchemeTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBISchemeTag();
        }
        return this.bischemetag;
    }

    public boolean isBISchemeTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBISchemeTagDirty();
        }
        return this.bischemetagDirtyFlag;
    }

    public void resetBISchemeTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBISchemeTag();
            return;
        }
        this.bischemetagDirtyFlag = false;
        this.bischemetag = null;
    }

    public void setBISchemeTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBISchemeTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bischemetag2 = string;
        this.bischemetag2DirtyFlag = true;
    }

    public String getBISchemeTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBISchemeTag2();
        }
        return this.bischemetag2;
    }

    public boolean isBISchemeTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBISchemeTag2Dirty();
        }
        return this.bischemetag2DirtyFlag;
    }

    public void resetBISchemeTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBISchemeTag2();
            return;
        }
        this.bischemetag2DirtyFlag = false;
        this.bischemetag2 = null;
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

    public void setEnableCustomized(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCustomized(n);
            return;
        }
        this.enablecustomized = n;
        this.enablecustomizedDirtyFlag = true;
    }

    public Integer getEnableCustomized() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCustomized();
        }
        return this.enablecustomized;
    }

    public boolean isEnableCustomizedDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCustomizedDirty();
        }
        return this.enablecustomizedDirtyFlag;
    }

    public void resetEnableCustomized() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCustomized();
            return;
        }
        this.enablecustomizedDirtyFlag = false;
        this.enablecustomized = null;
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

    public void setPSSysBISchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBISchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbischemeid = string;
        this.pssysbischemeidDirtyFlag = true;
    }

    public String getPSSysBISchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBISchemeId();
        }
        return this.pssysbischemeid;
    }

    public boolean isPSSysBISchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBISchemeIdDirty();
        }
        return this.pssysbischemeidDirtyFlag;
    }

    public void resetPSSysBISchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBISchemeId();
            return;
        }
        this.pssysbischemeidDirtyFlag = false;
        this.pssysbischemeid = null;
    }

    public void setPSSysBISchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBISchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbischemename = string;
        this.pssysbischemenameDirtyFlag = true;
    }

    public String getPSSysBISchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBISchemeName();
        }
        return this.pssysbischemename;
    }

    public boolean isPSSysBISchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBISchemeNameDirty();
        }
        return this.pssysbischemenameDirtyFlag;
    }

    public void resetPSSysBISchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBISchemeName();
            return;
        }
        this.pssysbischemenameDirtyFlag = false;
        this.pssysbischemename = null;
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
        PSSysBISchemeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBISchemeBase pSSysBISchemeBase) {
        pSSysBISchemeBase.resetAuthClientId();
        pSSysBISchemeBase.resetAuthClientSecret();
        pSSysBISchemeBase.resetAuthMode();
        pSSysBISchemeBase.resetAuthParam();
        pSSysBISchemeBase.resetAuthParam2();
        pSSysBISchemeBase.resetBIEngineType();
        pSSysBISchemeBase.resetBISchemeTag();
        pSSysBISchemeBase.resetBISchemeTag2();
        pSSysBISchemeBase.resetCodeName();
        pSSysBISchemeBase.resetCreateDate();
        pSSysBISchemeBase.resetCreateMan();
        pSSysBISchemeBase.resetEnableCustomized();
        pSSysBISchemeBase.resetEnableServiceAPI();
        pSSysBISchemeBase.resetEnableSubSysServiceAPI();
        pSSysBISchemeBase.resetMemo();
        pSSysBISchemeBase.resetObjNameCase();
        pSSysBISchemeBase.resetOrderValue();
        pSSysBISchemeBase.resetPSModuleId();
        pSSysBISchemeBase.resetPSModuleName();
        pSSysBISchemeBase.resetPSSubSysServiceAPIId();
        pSSysBISchemeBase.resetPSSubSysServiceAPIName();
        pSSysBISchemeBase.resetPSSysBISchemeId();
        pSSysBISchemeBase.resetPSSysBISchemeName();
        pSSysBISchemeBase.resetPSSysDynaModelId();
        pSSysBISchemeBase.resetPSSysDynaModelName();
        pSSysBISchemeBase.resetPSSysModelGroupId();
        pSSysBISchemeBase.resetPSSysModelGroupName();
        pSSysBISchemeBase.resetPSSysServiceAPIId();
        pSSysBISchemeBase.resetPSSysServiceAPIName();
        pSSysBISchemeBase.resetPSSysSFPluginId();
        pSSysBISchemeBase.resetPSSysSFPluginName();
        pSSysBISchemeBase.resetPSSystemId();
        pSSysBISchemeBase.resetPSSystemName();
        pSSysBISchemeBase.resetSchemeParams();
        pSSysBISchemeBase.resetServiceCodeName();
        pSSysBISchemeBase.resetServiceParam();
        pSSysBISchemeBase.resetServiceParam2();
        pSSysBISchemeBase.resetServicePath();
        pSSysBISchemeBase.resetSubSysServiceCodeName();
        pSSysBISchemeBase.resetUpdateDate();
        pSSysBISchemeBase.resetUpdateMan();
        pSSysBISchemeBase.resetUserCat();
        pSSysBISchemeBase.resetUserTag();
        pSSysBISchemeBase.resetUserTag2();
        pSSysBISchemeBase.resetUserTag3();
        pSSysBISchemeBase.resetUserTag4();
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
        if (!bl || this.isBIEngineTypeDirty()) {
            hashMap.put(FIELD_BIENGINETYPE, this.getBIEngineType());
        }
        if (!bl || this.isBISchemeTagDirty()) {
            hashMap.put(FIELD_BISCHEMETAG, this.getBISchemeTag());
        }
        if (!bl || this.isBISchemeTag2Dirty()) {
            hashMap.put(FIELD_BISCHEMETAG2, this.getBISchemeTag2());
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
        if (!bl || this.isEnableCustomizedDirty()) {
            hashMap.put(FIELD_ENABLECUSTOMIZED, this.getEnableCustomized());
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
        if (!bl || this.isPSSysBISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMEID, this.getPSSysBISchemeId());
        }
        if (!bl || this.isPSSysBISchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMENAME, this.getPSSysBISchemeName());
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
        return PSSysBISchemeBase.get(this, n);
    }

    private static Object get(PSSysBISchemeBase pSSysBISchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBISchemeBase.getAuthClientId();
            }
            case 1: {
                return pSSysBISchemeBase.getAuthClientSecret();
            }
            case 2: {
                return pSSysBISchemeBase.getAuthMode();
            }
            case 3: {
                return pSSysBISchemeBase.getAuthParam();
            }
            case 4: {
                return pSSysBISchemeBase.getAuthParam2();
            }
            case 5: {
                return pSSysBISchemeBase.getBIEngineType();
            }
            case 6: {
                return pSSysBISchemeBase.getBISchemeTag();
            }
            case 7: {
                return pSSysBISchemeBase.getBISchemeTag2();
            }
            case 8: {
                return pSSysBISchemeBase.getCodeName();
            }
            case 9: {
                return pSSysBISchemeBase.getCreateDate();
            }
            case 10: {
                return pSSysBISchemeBase.getCreateMan();
            }
            case 11: {
                return pSSysBISchemeBase.getEnableCustomized();
            }
            case 12: {
                return pSSysBISchemeBase.getEnableServiceAPI();
            }
            case 13: {
                return pSSysBISchemeBase.getEnableSubSysServiceAPI();
            }
            case 14: {
                return pSSysBISchemeBase.getMemo();
            }
            case 15: {
                return pSSysBISchemeBase.getObjNameCase();
            }
            case 16: {
                return pSSysBISchemeBase.getOrderValue();
            }
            case 17: {
                return pSSysBISchemeBase.getPSModuleId();
            }
            case 18: {
                return pSSysBISchemeBase.getPSModuleName();
            }
            case 19: {
                return pSSysBISchemeBase.getPSSubSysServiceAPIId();
            }
            case 20: {
                return pSSysBISchemeBase.getPSSubSysServiceAPIName();
            }
            case 21: {
                return pSSysBISchemeBase.getPSSysBISchemeId();
            }
            case 22: {
                return pSSysBISchemeBase.getPSSysBISchemeName();
            }
            case 23: {
                return pSSysBISchemeBase.getPSSysDynaModelId();
            }
            case 24: {
                return pSSysBISchemeBase.getPSSysDynaModelName();
            }
            case 25: {
                return pSSysBISchemeBase.getPSSysModelGroupId();
            }
            case 26: {
                return pSSysBISchemeBase.getPSSysModelGroupName();
            }
            case 27: {
                return pSSysBISchemeBase.getPSSysServiceAPIId();
            }
            case 28: {
                return pSSysBISchemeBase.getPSSysServiceAPIName();
            }
            case 29: {
                return pSSysBISchemeBase.getPSSysSFPluginId();
            }
            case 30: {
                return pSSysBISchemeBase.getPSSysSFPluginName();
            }
            case 31: {
                return pSSysBISchemeBase.getPSSystemId();
            }
            case 32: {
                return pSSysBISchemeBase.getPSSystemName();
            }
            case 33: {
                return pSSysBISchemeBase.getSchemeParams();
            }
            case 34: {
                return pSSysBISchemeBase.getServiceCodeName();
            }
            case 35: {
                return pSSysBISchemeBase.getServiceParam();
            }
            case 36: {
                return pSSysBISchemeBase.getServiceParam2();
            }
            case 37: {
                return pSSysBISchemeBase.getServicePath();
            }
            case 38: {
                return pSSysBISchemeBase.getSubSysServiceCodeName();
            }
            case 39: {
                return pSSysBISchemeBase.getUpdateDate();
            }
            case 40: {
                return pSSysBISchemeBase.getUpdateMan();
            }
            case 41: {
                return pSSysBISchemeBase.getUserCat();
            }
            case 42: {
                return pSSysBISchemeBase.getUserTag();
            }
            case 43: {
                return pSSysBISchemeBase.getUserTag2();
            }
            case 44: {
                return pSSysBISchemeBase.getUserTag3();
            }
            case 45: {
                return pSSysBISchemeBase.getUserTag4();
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
        PSSysBISchemeBase.set(this, n, object);
    }

    private static void set(PSSysBISchemeBase pSSysBISchemeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBISchemeBase.setAuthClientId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBISchemeBase.setAuthClientSecret(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBISchemeBase.setAuthMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBISchemeBase.setAuthParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBISchemeBase.setAuthParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBISchemeBase.setBIEngineType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBISchemeBase.setBISchemeTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBISchemeBase.setBISchemeTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBISchemeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBISchemeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSSysBISchemeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBISchemeBase.setEnableCustomized(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysBISchemeBase.setEnableServiceAPI(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSysBISchemeBase.setEnableSubSysServiceAPI(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysBISchemeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBISchemeBase.setObjNameCase(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBISchemeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSysBISchemeBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBISchemeBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBISchemeBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysBISchemeBase.setPSSubSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBISchemeBase.setPSSysBISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBISchemeBase.setPSSysBISchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBISchemeBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBISchemeBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysBISchemeBase.setPSSysModelGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysBISchemeBase.setPSSysModelGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysBISchemeBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysBISchemeBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysBISchemeBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysBISchemeBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysBISchemeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysBISchemeBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysBISchemeBase.setSchemeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysBISchemeBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysBISchemeBase.setServiceParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysBISchemeBase.setServiceParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysBISchemeBase.setServicePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysBISchemeBase.setSubSysServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysBISchemeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 40: {
                pSSysBISchemeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysBISchemeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysBISchemeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysBISchemeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysBISchemeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysBISchemeBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysBISchemeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBISchemeBase pSSysBISchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBISchemeBase.getAuthClientId() == null;
            }
            case 1: {
                return pSSysBISchemeBase.getAuthClientSecret() == null;
            }
            case 2: {
                return pSSysBISchemeBase.getAuthMode() == null;
            }
            case 3: {
                return pSSysBISchemeBase.getAuthParam() == null;
            }
            case 4: {
                return pSSysBISchemeBase.getAuthParam2() == null;
            }
            case 5: {
                return pSSysBISchemeBase.getBIEngineType() == null;
            }
            case 6: {
                return pSSysBISchemeBase.getBISchemeTag() == null;
            }
            case 7: {
                return pSSysBISchemeBase.getBISchemeTag2() == null;
            }
            case 8: {
                return pSSysBISchemeBase.getCodeName() == null;
            }
            case 9: {
                return pSSysBISchemeBase.getCreateDate() == null;
            }
            case 10: {
                return pSSysBISchemeBase.getCreateMan() == null;
            }
            case 11: {
                return pSSysBISchemeBase.getEnableCustomized() == null;
            }
            case 12: {
                return pSSysBISchemeBase.getEnableServiceAPI() == null;
            }
            case 13: {
                return pSSysBISchemeBase.getEnableSubSysServiceAPI() == null;
            }
            case 14: {
                return pSSysBISchemeBase.getMemo() == null;
            }
            case 15: {
                return pSSysBISchemeBase.getObjNameCase() == null;
            }
            case 16: {
                return pSSysBISchemeBase.getOrderValue() == null;
            }
            case 17: {
                return pSSysBISchemeBase.getPSModuleId() == null;
            }
            case 18: {
                return pSSysBISchemeBase.getPSModuleName() == null;
            }
            case 19: {
                return pSSysBISchemeBase.getPSSubSysServiceAPIId() == null;
            }
            case 20: {
                return pSSysBISchemeBase.getPSSubSysServiceAPIName() == null;
            }
            case 21: {
                return pSSysBISchemeBase.getPSSysBISchemeId() == null;
            }
            case 22: {
                return pSSysBISchemeBase.getPSSysBISchemeName() == null;
            }
            case 23: {
                return pSSysBISchemeBase.getPSSysDynaModelId() == null;
            }
            case 24: {
                return pSSysBISchemeBase.getPSSysDynaModelName() == null;
            }
            case 25: {
                return pSSysBISchemeBase.getPSSysModelGroupId() == null;
            }
            case 26: {
                return pSSysBISchemeBase.getPSSysModelGroupName() == null;
            }
            case 27: {
                return pSSysBISchemeBase.getPSSysServiceAPIId() == null;
            }
            case 28: {
                return pSSysBISchemeBase.getPSSysServiceAPIName() == null;
            }
            case 29: {
                return pSSysBISchemeBase.getPSSysSFPluginId() == null;
            }
            case 30: {
                return pSSysBISchemeBase.getPSSysSFPluginName() == null;
            }
            case 31: {
                return pSSysBISchemeBase.getPSSystemId() == null;
            }
            case 32: {
                return pSSysBISchemeBase.getPSSystemName() == null;
            }
            case 33: {
                return pSSysBISchemeBase.getSchemeParams() == null;
            }
            case 34: {
                return pSSysBISchemeBase.getServiceCodeName() == null;
            }
            case 35: {
                return pSSysBISchemeBase.getServiceParam() == null;
            }
            case 36: {
                return pSSysBISchemeBase.getServiceParam2() == null;
            }
            case 37: {
                return pSSysBISchemeBase.getServicePath() == null;
            }
            case 38: {
                return pSSysBISchemeBase.getSubSysServiceCodeName() == null;
            }
            case 39: {
                return pSSysBISchemeBase.getUpdateDate() == null;
            }
            case 40: {
                return pSSysBISchemeBase.getUpdateMan() == null;
            }
            case 41: {
                return pSSysBISchemeBase.getUserCat() == null;
            }
            case 42: {
                return pSSysBISchemeBase.getUserTag() == null;
            }
            case 43: {
                return pSSysBISchemeBase.getUserTag2() == null;
            }
            case 44: {
                return pSSysBISchemeBase.getUserTag3() == null;
            }
            case 45: {
                return pSSysBISchemeBase.getUserTag4() == null;
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
        return PSSysBISchemeBase.contains(this, n);
    }

    private static boolean contains(PSSysBISchemeBase pSSysBISchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBISchemeBase.isAuthClientIdDirty();
            }
            case 1: {
                return pSSysBISchemeBase.isAuthClientSecretDirty();
            }
            case 2: {
                return pSSysBISchemeBase.isAuthModeDirty();
            }
            case 3: {
                return pSSysBISchemeBase.isAuthParamDirty();
            }
            case 4: {
                return pSSysBISchemeBase.isAuthParam2Dirty();
            }
            case 5: {
                return pSSysBISchemeBase.isBIEngineTypeDirty();
            }
            case 6: {
                return pSSysBISchemeBase.isBISchemeTagDirty();
            }
            case 7: {
                return pSSysBISchemeBase.isBISchemeTag2Dirty();
            }
            case 8: {
                return pSSysBISchemeBase.isCodeNameDirty();
            }
            case 9: {
                return pSSysBISchemeBase.isCreateDateDirty();
            }
            case 10: {
                return pSSysBISchemeBase.isCreateManDirty();
            }
            case 11: {
                return pSSysBISchemeBase.isEnableCustomizedDirty();
            }
            case 12: {
                return pSSysBISchemeBase.isEnableServiceAPIDirty();
            }
            case 13: {
                return pSSysBISchemeBase.isEnableSubSysServiceAPIDirty();
            }
            case 14: {
                return pSSysBISchemeBase.isMemoDirty();
            }
            case 15: {
                return pSSysBISchemeBase.isObjNameCaseDirty();
            }
            case 16: {
                return pSSysBISchemeBase.isOrderValueDirty();
            }
            case 17: {
                return pSSysBISchemeBase.isPSModuleIdDirty();
            }
            case 18: {
                return pSSysBISchemeBase.isPSModuleNameDirty();
            }
            case 19: {
                return pSSysBISchemeBase.isPSSubSysServiceAPIIdDirty();
            }
            case 20: {
                return pSSysBISchemeBase.isPSSubSysServiceAPINameDirty();
            }
            case 21: {
                return pSSysBISchemeBase.isPSSysBISchemeIdDirty();
            }
            case 22: {
                return pSSysBISchemeBase.isPSSysBISchemeNameDirty();
            }
            case 23: {
                return pSSysBISchemeBase.isPSSysDynaModelIdDirty();
            }
            case 24: {
                return pSSysBISchemeBase.isPSSysDynaModelNameDirty();
            }
            case 25: {
                return pSSysBISchemeBase.isPSSysModelGroupIdDirty();
            }
            case 26: {
                return pSSysBISchemeBase.isPSSysModelGroupNameDirty();
            }
            case 27: {
                return pSSysBISchemeBase.isPSSysServiceAPIIdDirty();
            }
            case 28: {
                return pSSysBISchemeBase.isPSSysServiceAPINameDirty();
            }
            case 29: {
                return pSSysBISchemeBase.isPSSysSFPluginIdDirty();
            }
            case 30: {
                return pSSysBISchemeBase.isPSSysSFPluginNameDirty();
            }
            case 31: {
                return pSSysBISchemeBase.isPSSystemIdDirty();
            }
            case 32: {
                return pSSysBISchemeBase.isPSSystemNameDirty();
            }
            case 33: {
                return pSSysBISchemeBase.isSchemeParamsDirty();
            }
            case 34: {
                return pSSysBISchemeBase.isServiceCodeNameDirty();
            }
            case 35: {
                return pSSysBISchemeBase.isServiceParamDirty();
            }
            case 36: {
                return pSSysBISchemeBase.isServiceParam2Dirty();
            }
            case 37: {
                return pSSysBISchemeBase.isServicePathDirty();
            }
            case 38: {
                return pSSysBISchemeBase.isSubSysServiceCodeNameDirty();
            }
            case 39: {
                return pSSysBISchemeBase.isUpdateDateDirty();
            }
            case 40: {
                return pSSysBISchemeBase.isUpdateManDirty();
            }
            case 41: {
                return pSSysBISchemeBase.isUserCatDirty();
            }
            case 42: {
                return pSSysBISchemeBase.isUserTagDirty();
            }
            case 43: {
                return pSSysBISchemeBase.isUserTag2Dirty();
            }
            case 44: {
                return pSSysBISchemeBase.isUserTag3Dirty();
            }
            case 45: {
                return pSSysBISchemeBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBISchemeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBISchemeBase pSSysBISchemeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBISchemeBase.getAuthClientId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientid", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getAuthClientId()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getAuthClientSecret() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientsecret", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getAuthClientSecret()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getAuthMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authmode", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getAuthMode()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getAuthParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getAuthParam()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getAuthParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam2", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getAuthParam2()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getBIEngineType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bienginetype", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getBIEngineType()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getBISchemeTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bischemetag", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getBISchemeTag()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getBISchemeTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bischemetag2", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getBISchemeTag2()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getEnableCustomized() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecustomized", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getEnableCustomized()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getEnableServiceAPI() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableserviceapi", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getEnableServiceAPI()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getEnableSubSysServiceAPI() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesubsysserviceapi", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getEnableSubSysServiceAPI()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getObjNameCase() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objnamecase", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getObjNameCase()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSSubSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiname", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSSubSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSSysBISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemeid", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSSysBISchemeId()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSSysBISchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemename", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSSysBISchemeName()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSSysModelGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupid", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSSysModelGroupId()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSSysModelGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupname", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSSysModelGroupName()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getSchemeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"schemeparams", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getSchemeParams()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getServiceParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getServiceParam()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getServiceParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam2", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getServiceParam2()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getServicePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicepath", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getServicePath()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getSubSysServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subsysservicecodename", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getSubSysServiceCodeName()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBISchemeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBISchemeBase.getJSONValue((Object)pSSysBISchemeBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBISchemeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBISchemeBase pSSysBISchemeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBISchemeBase.getAuthClientId() != null) {
            object = pSSysBISchemeBase.getAuthClientId();
            xmlNode.setAttribute(FIELD_AUTHCLIENTID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBISchemeBase.getAuthClientSecret() != null) {
            object = pSSysBISchemeBase.getAuthClientSecret();
            xmlNode.setAttribute(FIELD_AUTHCLIENTSECRET, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBISchemeBase.getAuthMode() != null) {
            object = pSSysBISchemeBase.getAuthMode();
            xmlNode.setAttribute(FIELD_AUTHMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBISchemeBase.getAuthParam() != null) {
            object = pSSysBISchemeBase.getAuthParam();
            xmlNode.setAttribute(FIELD_AUTHPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBISchemeBase.getAuthParam2() != null) {
            object = pSSysBISchemeBase.getAuthParam2();
            xmlNode.setAttribute(FIELD_AUTHPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBISchemeBase.getBIEngineType() != null) {
            object = pSSysBISchemeBase.getBIEngineType();
            xmlNode.setAttribute(FIELD_BIENGINETYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBISchemeBase.getBISchemeTag() != null) {
            object = pSSysBISchemeBase.getBISchemeTag();
            xmlNode.setAttribute(FIELD_BISCHEMETAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBISchemeBase.getBISchemeTag2() != null) {
            object = pSSysBISchemeBase.getBISchemeTag2();
            xmlNode.setAttribute(FIELD_BISCHEMETAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBISchemeBase.getCodeName() != null) {
            object = pSSysBISchemeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getCreateDate() != null) {
            object = pSSysBISchemeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBISchemeBase.getCreateMan() != null) {
            object = pSSysBISchemeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getEnableCustomized() != null) {
            object = pSSysBISchemeBase.getEnableCustomized();
            xmlNode.setAttribute(FIELD_ENABLECUSTOMIZED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBISchemeBase.getEnableServiceAPI() != null) {
            object = pSSysBISchemeBase.getEnableServiceAPI();
            xmlNode.setAttribute(FIELD_ENABLESERVICEAPI, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBISchemeBase.getEnableSubSysServiceAPI() != null) {
            object = pSSysBISchemeBase.getEnableSubSysServiceAPI();
            xmlNode.setAttribute(FIELD_ENABLESUBSYSSERVICEAPI, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBISchemeBase.getMemo() != null) {
            object = pSSysBISchemeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getObjNameCase() != null) {
            object = pSSysBISchemeBase.getObjNameCase();
            xmlNode.setAttribute(FIELD_OBJNAMECASE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getOrderValue() != null) {
            object = pSSysBISchemeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBISchemeBase.getPSModuleId() != null) {
            object = pSSysBISchemeBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getPSModuleName() != null) {
            object = pSSysBISchemeBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getPSSubSysServiceAPIId() != null) {
            object = pSSysBISchemeBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getPSSubSysServiceAPIName() != null) {
            object = pSSysBISchemeBase.getPSSubSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getPSSysBISchemeId() != null) {
            object = pSSysBISchemeBase.getPSSysBISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getPSSysBISchemeName() != null) {
            object = pSSysBISchemeBase.getPSSysBISchemeName();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getPSSysDynaModelId() != null) {
            object = pSSysBISchemeBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getPSSysDynaModelName() != null) {
            object = pSSysBISchemeBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getPSSysModelGroupId() != null) {
            object = pSSysBISchemeBase.getPSSysModelGroupId();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getPSSysModelGroupName() != null) {
            object = pSSysBISchemeBase.getPSSysModelGroupName();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getPSSysServiceAPIId() != null) {
            object = pSSysBISchemeBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getPSSysServiceAPIName() != null) {
            object = pSSysBISchemeBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getPSSysSFPluginId() != null) {
            object = pSSysBISchemeBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getPSSysSFPluginName() != null) {
            object = pSSysBISchemeBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getPSSystemId() != null) {
            object = pSSysBISchemeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getPSSystemName() != null) {
            object = pSSysBISchemeBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getSchemeParams() != null) {
            object = pSSysBISchemeBase.getSchemeParams();
            xmlNode.setAttribute(FIELD_SCHEMEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getServiceCodeName() != null) {
            object = pSSysBISchemeBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getServiceParam() != null) {
            object = pSSysBISchemeBase.getServiceParam();
            xmlNode.setAttribute(FIELD_SERVICEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getServiceParam2() != null) {
            object = pSSysBISchemeBase.getServiceParam2();
            xmlNode.setAttribute(FIELD_SERVICEPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getServicePath() != null) {
            object = pSSysBISchemeBase.getServicePath();
            xmlNode.setAttribute(FIELD_SERVICEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getSubSysServiceCodeName() != null) {
            object = pSSysBISchemeBase.getSubSysServiceCodeName();
            xmlNode.setAttribute(FIELD_SUBSYSSERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getUpdateDate() != null) {
            object = pSSysBISchemeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBISchemeBase.getUpdateMan() != null) {
            object = pSSysBISchemeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getUserCat() != null) {
            object = pSSysBISchemeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getUserTag() != null) {
            object = pSSysBISchemeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getUserTag2() != null) {
            object = pSSysBISchemeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getUserTag3() != null) {
            object = pSSysBISchemeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBISchemeBase.getUserTag4() != null) {
            object = pSSysBISchemeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBISchemeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBISchemeBase pSSysBISchemeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBISchemeBase.isAuthClientIdDirty() && (bl || pSSysBISchemeBase.getAuthClientId() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTID, (Object)pSSysBISchemeBase.getAuthClientId());
        }
        if (pSSysBISchemeBase.isAuthClientSecretDirty() && (bl || pSSysBISchemeBase.getAuthClientSecret() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTSECRET, (Object)pSSysBISchemeBase.getAuthClientSecret());
        }
        if (pSSysBISchemeBase.isAuthModeDirty() && (bl || pSSysBISchemeBase.getAuthMode() != null)) {
            iDataObject.set(FIELD_AUTHMODE, (Object)pSSysBISchemeBase.getAuthMode());
        }
        if (pSSysBISchemeBase.isAuthParamDirty() && (bl || pSSysBISchemeBase.getAuthParam() != null)) {
            iDataObject.set(FIELD_AUTHPARAM, (Object)pSSysBISchemeBase.getAuthParam());
        }
        if (pSSysBISchemeBase.isAuthParam2Dirty() && (bl || pSSysBISchemeBase.getAuthParam2() != null)) {
            iDataObject.set(FIELD_AUTHPARAM2, (Object)pSSysBISchemeBase.getAuthParam2());
        }
        if (pSSysBISchemeBase.isBIEngineTypeDirty() && (bl || pSSysBISchemeBase.getBIEngineType() != null)) {
            iDataObject.set(FIELD_BIENGINETYPE, (Object)pSSysBISchemeBase.getBIEngineType());
        }
        if (pSSysBISchemeBase.isBISchemeTagDirty() && (bl || pSSysBISchemeBase.getBISchemeTag() != null)) {
            iDataObject.set(FIELD_BISCHEMETAG, (Object)pSSysBISchemeBase.getBISchemeTag());
        }
        if (pSSysBISchemeBase.isBISchemeTag2Dirty() && (bl || pSSysBISchemeBase.getBISchemeTag2() != null)) {
            iDataObject.set(FIELD_BISCHEMETAG2, (Object)pSSysBISchemeBase.getBISchemeTag2());
        }
        if (pSSysBISchemeBase.isCodeNameDirty() && (bl || pSSysBISchemeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBISchemeBase.getCodeName());
        }
        if (pSSysBISchemeBase.isCreateDateDirty() && (bl || pSSysBISchemeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBISchemeBase.getCreateDate());
        }
        if (pSSysBISchemeBase.isCreateManDirty() && (bl || pSSysBISchemeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBISchemeBase.getCreateMan());
        }
        if (pSSysBISchemeBase.isEnableCustomizedDirty() && (bl || pSSysBISchemeBase.getEnableCustomized() != null)) {
            iDataObject.set(FIELD_ENABLECUSTOMIZED, (Object)pSSysBISchemeBase.getEnableCustomized());
        }
        if (pSSysBISchemeBase.isEnableServiceAPIDirty() && (bl || pSSysBISchemeBase.getEnableServiceAPI() != null)) {
            iDataObject.set(FIELD_ENABLESERVICEAPI, (Object)pSSysBISchemeBase.getEnableServiceAPI());
        }
        if (pSSysBISchemeBase.isEnableSubSysServiceAPIDirty() && (bl || pSSysBISchemeBase.getEnableSubSysServiceAPI() != null)) {
            iDataObject.set(FIELD_ENABLESUBSYSSERVICEAPI, (Object)pSSysBISchemeBase.getEnableSubSysServiceAPI());
        }
        if (pSSysBISchemeBase.isMemoDirty() && (bl || pSSysBISchemeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBISchemeBase.getMemo());
        }
        if (pSSysBISchemeBase.isObjNameCaseDirty() && (bl || pSSysBISchemeBase.getObjNameCase() != null)) {
            iDataObject.set(FIELD_OBJNAMECASE, (Object)pSSysBISchemeBase.getObjNameCase());
        }
        if (pSSysBISchemeBase.isOrderValueDirty() && (bl || pSSysBISchemeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysBISchemeBase.getOrderValue());
        }
        if (pSSysBISchemeBase.isPSModuleIdDirty() && (bl || pSSysBISchemeBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysBISchemeBase.getPSModuleId());
        }
        if (pSSysBISchemeBase.isPSModuleNameDirty() && (bl || pSSysBISchemeBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysBISchemeBase.getPSModuleName());
        }
        if (pSSysBISchemeBase.isPSSubSysServiceAPIIdDirty() && (bl || pSSysBISchemeBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSSysBISchemeBase.getPSSubSysServiceAPIId());
        }
        if (pSSysBISchemeBase.isPSSubSysServiceAPINameDirty() && (bl || pSSysBISchemeBase.getPSSubSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPINAME, (Object)pSSysBISchemeBase.getPSSubSysServiceAPIName());
        }
        if (pSSysBISchemeBase.isPSSysBISchemeIdDirty() && (bl || pSSysBISchemeBase.getPSSysBISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMEID, (Object)pSSysBISchemeBase.getPSSysBISchemeId());
        }
        if (pSSysBISchemeBase.isPSSysBISchemeNameDirty() && (bl || pSSysBISchemeBase.getPSSysBISchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMENAME, (Object)pSSysBISchemeBase.getPSSysBISchemeName());
        }
        if (pSSysBISchemeBase.isPSSysDynaModelIdDirty() && (bl || pSSysBISchemeBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysBISchemeBase.getPSSysDynaModelId());
        }
        if (pSSysBISchemeBase.isPSSysDynaModelNameDirty() && (bl || pSSysBISchemeBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysBISchemeBase.getPSSysDynaModelName());
        }
        if (pSSysBISchemeBase.isPSSysModelGroupIdDirty() && (bl || pSSysBISchemeBase.getPSSysModelGroupId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPID, (Object)pSSysBISchemeBase.getPSSysModelGroupId());
        }
        if (pSSysBISchemeBase.isPSSysModelGroupNameDirty() && (bl || pSSysBISchemeBase.getPSSysModelGroupName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPNAME, (Object)pSSysBISchemeBase.getPSSysModelGroupName());
        }
        if (pSSysBISchemeBase.isPSSysServiceAPIIdDirty() && (bl || pSSysBISchemeBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSSysBISchemeBase.getPSSysServiceAPIId());
        }
        if (pSSysBISchemeBase.isPSSysServiceAPINameDirty() && (bl || pSSysBISchemeBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSSysBISchemeBase.getPSSysServiceAPIName());
        }
        if (pSSysBISchemeBase.isPSSysSFPluginIdDirty() && (bl || pSSysBISchemeBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysBISchemeBase.getPSSysSFPluginId());
        }
        if (pSSysBISchemeBase.isPSSysSFPluginNameDirty() && (bl || pSSysBISchemeBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysBISchemeBase.getPSSysSFPluginName());
        }
        if (pSSysBISchemeBase.isPSSystemIdDirty() && (bl || pSSysBISchemeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysBISchemeBase.getPSSystemId());
        }
        if (pSSysBISchemeBase.isPSSystemNameDirty() && (bl || pSSysBISchemeBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysBISchemeBase.getPSSystemName());
        }
        if (pSSysBISchemeBase.isSchemeParamsDirty() && (bl || pSSysBISchemeBase.getSchemeParams() != null)) {
            iDataObject.set(FIELD_SCHEMEPARAMS, (Object)pSSysBISchemeBase.getSchemeParams());
        }
        if (pSSysBISchemeBase.isServiceCodeNameDirty() && (bl || pSSysBISchemeBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSSysBISchemeBase.getServiceCodeName());
        }
        if (pSSysBISchemeBase.isServiceParamDirty() && (bl || pSSysBISchemeBase.getServiceParam() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM, (Object)pSSysBISchemeBase.getServiceParam());
        }
        if (pSSysBISchemeBase.isServiceParam2Dirty() && (bl || pSSysBISchemeBase.getServiceParam2() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM2, (Object)pSSysBISchemeBase.getServiceParam2());
        }
        if (pSSysBISchemeBase.isServicePathDirty() && (bl || pSSysBISchemeBase.getServicePath() != null)) {
            iDataObject.set(FIELD_SERVICEPATH, (Object)pSSysBISchemeBase.getServicePath());
        }
        if (pSSysBISchemeBase.isSubSysServiceCodeNameDirty() && (bl || pSSysBISchemeBase.getSubSysServiceCodeName() != null)) {
            iDataObject.set(FIELD_SUBSYSSERVICECODENAME, (Object)pSSysBISchemeBase.getSubSysServiceCodeName());
        }
        if (pSSysBISchemeBase.isUpdateDateDirty() && (bl || pSSysBISchemeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBISchemeBase.getUpdateDate());
        }
        if (pSSysBISchemeBase.isUpdateManDirty() && (bl || pSSysBISchemeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBISchemeBase.getUpdateMan());
        }
        if (pSSysBISchemeBase.isUserCatDirty() && (bl || pSSysBISchemeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBISchemeBase.getUserCat());
        }
        if (pSSysBISchemeBase.isUserTagDirty() && (bl || pSSysBISchemeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBISchemeBase.getUserTag());
        }
        if (pSSysBISchemeBase.isUserTag2Dirty() && (bl || pSSysBISchemeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBISchemeBase.getUserTag2());
        }
        if (pSSysBISchemeBase.isUserTag3Dirty() && (bl || pSSysBISchemeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBISchemeBase.getUserTag3());
        }
        if (pSSysBISchemeBase.isUserTag4Dirty() && (bl || pSSysBISchemeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBISchemeBase.getUserTag4());
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
        return PSSysBISchemeBase.remove(this, n);
    }

    private static boolean remove(PSSysBISchemeBase pSSysBISchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBISchemeBase.resetAuthClientId();
                return true;
            }
            case 1: {
                pSSysBISchemeBase.resetAuthClientSecret();
                return true;
            }
            case 2: {
                pSSysBISchemeBase.resetAuthMode();
                return true;
            }
            case 3: {
                pSSysBISchemeBase.resetAuthParam();
                return true;
            }
            case 4: {
                pSSysBISchemeBase.resetAuthParam2();
                return true;
            }
            case 5: {
                pSSysBISchemeBase.resetBIEngineType();
                return true;
            }
            case 6: {
                pSSysBISchemeBase.resetBISchemeTag();
                return true;
            }
            case 7: {
                pSSysBISchemeBase.resetBISchemeTag2();
                return true;
            }
            case 8: {
                pSSysBISchemeBase.resetCodeName();
                return true;
            }
            case 9: {
                pSSysBISchemeBase.resetCreateDate();
                return true;
            }
            case 10: {
                pSSysBISchemeBase.resetCreateMan();
                return true;
            }
            case 11: {
                pSSysBISchemeBase.resetEnableCustomized();
                return true;
            }
            case 12: {
                pSSysBISchemeBase.resetEnableServiceAPI();
                return true;
            }
            case 13: {
                pSSysBISchemeBase.resetEnableSubSysServiceAPI();
                return true;
            }
            case 14: {
                pSSysBISchemeBase.resetMemo();
                return true;
            }
            case 15: {
                pSSysBISchemeBase.resetObjNameCase();
                return true;
            }
            case 16: {
                pSSysBISchemeBase.resetOrderValue();
                return true;
            }
            case 17: {
                pSSysBISchemeBase.resetPSModuleId();
                return true;
            }
            case 18: {
                pSSysBISchemeBase.resetPSModuleName();
                return true;
            }
            case 19: {
                pSSysBISchemeBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 20: {
                pSSysBISchemeBase.resetPSSubSysServiceAPIName();
                return true;
            }
            case 21: {
                pSSysBISchemeBase.resetPSSysBISchemeId();
                return true;
            }
            case 22: {
                pSSysBISchemeBase.resetPSSysBISchemeName();
                return true;
            }
            case 23: {
                pSSysBISchemeBase.resetPSSysDynaModelId();
                return true;
            }
            case 24: {
                pSSysBISchemeBase.resetPSSysDynaModelName();
                return true;
            }
            case 25: {
                pSSysBISchemeBase.resetPSSysModelGroupId();
                return true;
            }
            case 26: {
                pSSysBISchemeBase.resetPSSysModelGroupName();
                return true;
            }
            case 27: {
                pSSysBISchemeBase.resetPSSysServiceAPIId();
                return true;
            }
            case 28: {
                pSSysBISchemeBase.resetPSSysServiceAPIName();
                return true;
            }
            case 29: {
                pSSysBISchemeBase.resetPSSysSFPluginId();
                return true;
            }
            case 30: {
                pSSysBISchemeBase.resetPSSysSFPluginName();
                return true;
            }
            case 31: {
                pSSysBISchemeBase.resetPSSystemId();
                return true;
            }
            case 32: {
                pSSysBISchemeBase.resetPSSystemName();
                return true;
            }
            case 33: {
                pSSysBISchemeBase.resetSchemeParams();
                return true;
            }
            case 34: {
                pSSysBISchemeBase.resetServiceCodeName();
                return true;
            }
            case 35: {
                pSSysBISchemeBase.resetServiceParam();
                return true;
            }
            case 36: {
                pSSysBISchemeBase.resetServiceParam2();
                return true;
            }
            case 37: {
                pSSysBISchemeBase.resetServicePath();
                return true;
            }
            case 38: {
                pSSysBISchemeBase.resetSubSysServiceCodeName();
                return true;
            }
            case 39: {
                pSSysBISchemeBase.resetUpdateDate();
                return true;
            }
            case 40: {
                pSSysBISchemeBase.resetUpdateMan();
                return true;
            }
            case 41: {
                pSSysBISchemeBase.resetUserCat();
                return true;
            }
            case 42: {
                pSSysBISchemeBase.resetUserTag();
                return true;
            }
            case 43: {
                pSSysBISchemeBase.resetUserTag2();
                return true;
            }
            case 44: {
                pSSysBISchemeBase.resetUserTag3();
                return true;
            }
            case 45: {
                pSSysBISchemeBase.resetUserTag4();
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
    public ArrayList<PSSysBIAggTable> getPSSysBIAggTables() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIAggTables();
        }
        if (this.getPSSysBISchemeId() == null) {
            return null;
        }
        PSSysBIAggTableService pSSysBIAggTableService = (PSSysBIAggTableService)ServiceGlobal.getService(PSSysBIAggTableService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBIAggTablesLock;
        synchronized (n) {
            if (this.pssysbiaggtables == null) {
                this.pssysbiaggtables = pSSysBIAggTableService.selectByPSSysBIScheme(this);
            }
            return this.pssysbiaggtables;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBICube> getPSSysBICubes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubes();
        }
        if (this.getPSSysBISchemeId() == null) {
            return null;
        }
        PSSysBICubeService pSSysBICubeService = (PSSysBICubeService)ServiceGlobal.getService(PSSysBICubeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBICubesLock;
        synchronized (n) {
            if (this.pssysbicubes == null) {
                this.pssysbicubes = pSSysBICubeService.selectByPSSysBIScheme(this);
            }
            return this.pssysbicubes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBIReport> getPSSysBIReports() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIReports();
        }
        if (this.getPSSysBISchemeId() == null) {
            return null;
        }
        PSSysBIReportService pSSysBIReportService = (PSSysBIReportService)ServiceGlobal.getService(PSSysBIReportService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBIReportsLock;
        synchronized (n) {
            if (this.pssysbireports == null) {
                this.pssysbireports = pSSysBIReportService.selectByPSSysBIScheme(this);
            }
            return this.pssysbireports;
        }
    }

    private PSSysBISchemeBase getProxyEntity() {
        return this.proxyPSSysBISchemeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBISchemeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBISchemeBase) {
            this.proxyPSSysBISchemeBase = (PSSysBISchemeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AUTHCLIENTID, 0);
        fieldIndexMap.put(FIELD_AUTHCLIENTSECRET, 1);
        fieldIndexMap.put(FIELD_AUTHMODE, 2);
        fieldIndexMap.put(FIELD_AUTHPARAM, 3);
        fieldIndexMap.put(FIELD_AUTHPARAM2, 4);
        fieldIndexMap.put(FIELD_BIENGINETYPE, 5);
        fieldIndexMap.put(FIELD_BISCHEMETAG, 6);
        fieldIndexMap.put(FIELD_BISCHEMETAG2, 7);
        fieldIndexMap.put(FIELD_CODENAME, 8);
        fieldIndexMap.put(FIELD_CREATEDATE, 9);
        fieldIndexMap.put(FIELD_CREATEMAN, 10);
        fieldIndexMap.put(FIELD_ENABLECUSTOMIZED, 11);
        fieldIndexMap.put(FIELD_ENABLESERVICEAPI, 12);
        fieldIndexMap.put(FIELD_ENABLESUBSYSSERVICEAPI, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_OBJNAMECASE, 15);
        fieldIndexMap.put(FIELD_ORDERVALUE, 16);
        fieldIndexMap.put(FIELD_PSMODULEID, 17);
        fieldIndexMap.put(FIELD_PSMODULENAME, 18);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 19);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPINAME, 20);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMEID, 21);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMENAME, 22);
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
        fieldIndexMap.put(FIELD_SERVICECODENAME, 34);
        fieldIndexMap.put(FIELD_SERVICEPARAM, 35);
        fieldIndexMap.put(FIELD_SERVICEPARAM2, 36);
        fieldIndexMap.put(FIELD_SERVICEPATH, 37);
        fieldIndexMap.put(FIELD_SUBSYSSERVICECODENAME, 38);
        fieldIndexMap.put(FIELD_UPDATEDATE, 39);
        fieldIndexMap.put(FIELD_UPDATEMAN, 40);
        fieldIndexMap.put(FIELD_USERCAT, 41);
        fieldIndexMap.put(FIELD_USERTAG, 42);
        fieldIndexMap.put(FIELD_USERTAG2, 43);
        fieldIndexMap.put(FIELD_USERTAG3, 44);
        fieldIndexMap.put(FIELD_USERTAG4, 45);
    }
}

