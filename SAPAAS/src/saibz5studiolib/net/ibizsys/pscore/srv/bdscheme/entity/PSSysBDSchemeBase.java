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
package net.ibizsys.pscore.srv.bdscheme.entity;

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
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDPart;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableRS;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDPartService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableRSService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService;
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

public abstract class PSSysBDSchemeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBDSchemeBase.class);
    public static final String FIELD_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String FIELD_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String FIELD_AUTHMODE = "AUTHMODE";
    public static final String FIELD_AUTHPARAM = "AUTHPARAM";
    public static final String FIELD_AUTHPARAM2 = "AUTHPARAM2";
    public static final String FIELD_BDTYPE = "BDTYPE";
    public static final String FIELD_BDTYPES = "BDTYPES";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_ENABLESERVICEAPI = "ENABLESERVICEAPI";
    public static final String FIELD_ENABLESUBSYSSERVICEAPI = "ENABLESUBSYSSERVICEAPI";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELVER = "MODELVER";
    public static final String FIELD_OBJNAMECASE = "OBJNAMECASE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSBDPARTSCNT = "PSSYSBDPARTSCNT";
    public static final String FIELD_PSSYSBDSCHEMEID = "PSSYSBDSCHEMEID";
    public static final String FIELD_PSSYSBDSCHEMENAME = "PSSYSBDSCHEMENAME";
    public static final String FIELD_PSSYSBDTABLESCNT = "PSSYSBDTABLESCNT";
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
    public static final String FIELD_ROWKEYSEPARATOR = "ROWKEYSEPARATOR";
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
    private static final int INDEX_BDTYPE = 5;
    private static final int INDEX_BDTYPES = 6;
    private static final int INDEX_CODENAME = 7;
    private static final int INDEX_CREATEDATE = 8;
    private static final int INDEX_CREATEMAN = 9;
    private static final int INDEX_DEFAULTFLAG = 10;
    private static final int INDEX_ENABLESERVICEAPI = 11;
    private static final int INDEX_ENABLESUBSYSSERVICEAPI = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_MODELVER = 14;
    private static final int INDEX_OBJNAMECASE = 15;
    private static final int INDEX_ORDERVALUE = 16;
    private static final int INDEX_PSMODULEID = 17;
    private static final int INDEX_PSMODULENAME = 18;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 19;
    private static final int INDEX_PSSUBSYSSERVICEAPINAME = 20;
    private static final int INDEX_PSSYSBDPARTSCNT = 21;
    private static final int INDEX_PSSYSBDSCHEMEID = 22;
    private static final int INDEX_PSSYSBDSCHEMENAME = 23;
    private static final int INDEX_PSSYSBDTABLESCNT = 24;
    private static final int INDEX_PSSYSDYNAMODELID = 25;
    private static final int INDEX_PSSYSDYNAMODELNAME = 26;
    private static final int INDEX_PSSYSMODELGROUPID = 27;
    private static final int INDEX_PSSYSMODELGROUPNAME = 28;
    private static final int INDEX_PSSYSSERVICEAPIID = 29;
    private static final int INDEX_PSSYSSERVICEAPINAME = 30;
    private static final int INDEX_PSSYSSFPLUGINID = 31;
    private static final int INDEX_PSSYSSFPLUGINNAME = 32;
    private static final int INDEX_PSSYSTEMID = 33;
    private static final int INDEX_PSSYSTEMNAME = 34;
    private static final int INDEX_ROWKEYSEPARATOR = 35;
    private static final int INDEX_SCHEMEPARAMS = 36;
    private static final int INDEX_SCHEMETAG = 37;
    private static final int INDEX_SCHEMETAG2 = 38;
    private static final int INDEX_SERVICECODENAME = 39;
    private static final int INDEX_SERVICEPARAM = 40;
    private static final int INDEX_SERVICEPARAM2 = 41;
    private static final int INDEX_SERVICEPATH = 42;
    private static final int INDEX_SUBSYSSERVICECODENAME = 43;
    private static final int INDEX_UPDATEDATE = 44;
    private static final int INDEX_UPDATEMAN = 45;
    private static final int INDEX_USERCAT = 46;
    private static final int INDEX_USERTAG = 47;
    private static final int INDEX_USERTAG2 = 48;
    private static final int INDEX_USERTAG3 = 49;
    private static final int INDEX_USERTAG4 = 50;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBDSchemeBase proxyPSSysBDSchemeBase = null;
    private boolean authclientidDirtyFlag = false;
    private boolean authclientsecretDirtyFlag = false;
    private boolean authmodeDirtyFlag = false;
    private boolean authparamDirtyFlag = false;
    private boolean authparam2DirtyFlag = false;
    private boolean bdtypeDirtyFlag = false;
    private boolean bdtypesDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean enableserviceapiDirtyFlag = false;
    private boolean enablesubsysserviceapiDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelverDirtyFlag = false;
    private boolean objnamecaseDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssubsysserviceapinameDirtyFlag = false;
    private boolean pssysbdpartscntDirtyFlag = false;
    private boolean pssysbdschemeidDirtyFlag = false;
    private boolean pssysbdschemenameDirtyFlag = false;
    private boolean pssysbdtablescntDirtyFlag = false;
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
    private boolean rowkeyseparatorDirtyFlag = false;
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
    @Column(name="bdtype")
    private String bdtype;
    @Column(name="bdtypes")
    private String bdtypes;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="enableserviceapi")
    private Integer enableserviceapi;
    @Column(name="enablesubsysserviceapi")
    private Integer enablesubsysserviceapi;
    @Column(name="memo")
    private String memo;
    @Column(name="modelver")
    private Integer modelver;
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
    @Column(name="pssysbdpartscnt")
    private Integer pssysbdpartscnt;
    @Column(name="pssysbdschemeid")
    private String pssysbdschemeid;
    @Column(name="pssysbdschemename")
    private String pssysbdschemename;
    @Column(name="pssysbdtablescnt")
    private Integer pssysbdtablescnt;
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
    @Column(name="rowkeyseparator")
    private String rowkeyseparator;
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
    private Integer objPSSysBDPartsLock = new Integer(1);
    private ArrayList<PSSysBDPart> pssysbdparts = null;
    private Integer objPSSysBDTableRSesLock = new Integer(1);
    private ArrayList<PSSysBDTableRS> pssysbdtablerses = null;
    private Integer objPSSysBDTablesLock = new Integer(1);
    private ArrayList<PSSysBDTable> pssysbdtables = null;

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

    public void setBDType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBDType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bdtype = string;
        this.bdtypeDirtyFlag = true;
    }

    public String getBDType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBDType();
        }
        return this.bdtype;
    }

    public boolean isBDTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBDTypeDirty();
        }
        return this.bdtypeDirtyFlag;
    }

    public void resetBDType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBDType();
            return;
        }
        this.bdtypeDirtyFlag = false;
        this.bdtype = null;
    }

    public void setBDTypes(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBDTypes(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bdtypes = string;
        this.bdtypesDirtyFlag = true;
    }

    public String getBDTypes() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBDTypes();
        }
        return this.bdtypes;
    }

    public boolean isBDTypesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBDTypesDirty();
        }
        return this.bdtypesDirtyFlag;
    }

    public void resetBDTypes() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBDTypes();
            return;
        }
        this.bdtypesDirtyFlag = false;
        this.bdtypes = null;
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

    public void setModelVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelVer(n);
            return;
        }
        this.modelver = n;
        this.modelverDirtyFlag = true;
    }

    public Integer getModelVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelVer();
        }
        return this.modelver;
    }

    public boolean isModelVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelVerDirty();
        }
        return this.modelverDirtyFlag;
    }

    public void resetModelVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelVer();
            return;
        }
        this.modelverDirtyFlag = false;
        this.modelver = null;
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

    public void setPSSysBDPartsCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDPartsCnt(n);
            return;
        }
        this.pssysbdpartscnt = n;
        this.pssysbdpartscntDirtyFlag = true;
    }

    public Integer getPSSysBDPartsCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDPartsCnt();
        }
        return this.pssysbdpartscnt;
    }

    public boolean isPSSysBDPartsCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDPartsCntDirty();
        }
        return this.pssysbdpartscntDirtyFlag;
    }

    public void resetPSSysBDPartsCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDPartsCnt();
            return;
        }
        this.pssysbdpartscntDirtyFlag = false;
        this.pssysbdpartscnt = null;
    }

    public void setPSSysBDSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdschemeid = string;
        this.pssysbdschemeidDirtyFlag = true;
    }

    public String getPSSysBDSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDSchemeId();
        }
        return this.pssysbdschemeid;
    }

    public boolean isPSSysBDSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDSchemeIdDirty();
        }
        return this.pssysbdschemeidDirtyFlag;
    }

    public void resetPSSysBDSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDSchemeId();
            return;
        }
        this.pssysbdschemeidDirtyFlag = false;
        this.pssysbdschemeid = null;
    }

    public void setPSSysBDSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdschemename = string;
        this.pssysbdschemenameDirtyFlag = true;
    }

    public String getPSSysBDSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDSchemeName();
        }
        return this.pssysbdschemename;
    }

    public boolean isPSSysBDSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDSchemeNameDirty();
        }
        return this.pssysbdschemenameDirtyFlag;
    }

    public void resetPSSysBDSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDSchemeName();
            return;
        }
        this.pssysbdschemenameDirtyFlag = false;
        this.pssysbdschemename = null;
    }

    public void setPSSysBDTablesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTablesCnt(n);
            return;
        }
        this.pssysbdtablescnt = n;
        this.pssysbdtablescntDirtyFlag = true;
    }

    public Integer getPSSysBDTablesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTablesCnt();
        }
        return this.pssysbdtablescnt;
    }

    public boolean isPSSysBDTablesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTablesCntDirty();
        }
        return this.pssysbdtablescntDirtyFlag;
    }

    public void resetPSSysBDTablesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTablesCnt();
            return;
        }
        this.pssysbdtablescntDirtyFlag = false;
        this.pssysbdtablescnt = null;
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

    public void setRowKeySeparator(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRowKeySeparator(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rowkeyseparator = string;
        this.rowkeyseparatorDirtyFlag = true;
    }

    public String getRowKeySeparator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRowKeySeparator();
        }
        return this.rowkeyseparator;
    }

    public boolean isRowKeySeparatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRowKeySeparatorDirty();
        }
        return this.rowkeyseparatorDirtyFlag;
    }

    public void resetRowKeySeparator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRowKeySeparator();
            return;
        }
        this.rowkeyseparatorDirtyFlag = false;
        this.rowkeyseparator = null;
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
        PSSysBDSchemeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBDSchemeBase pSSysBDSchemeBase) {
        pSSysBDSchemeBase.resetAuthClientId();
        pSSysBDSchemeBase.resetAuthClientSecret();
        pSSysBDSchemeBase.resetAuthMode();
        pSSysBDSchemeBase.resetAuthParam();
        pSSysBDSchemeBase.resetAuthParam2();
        pSSysBDSchemeBase.resetBDType();
        pSSysBDSchemeBase.resetBDTypes();
        pSSysBDSchemeBase.resetCodeName();
        pSSysBDSchemeBase.resetCreateDate();
        pSSysBDSchemeBase.resetCreateMan();
        pSSysBDSchemeBase.resetDefaultFlag();
        pSSysBDSchemeBase.resetEnableServiceAPI();
        pSSysBDSchemeBase.resetEnableSubSysServiceAPI();
        pSSysBDSchemeBase.resetMemo();
        pSSysBDSchemeBase.resetModelVer();
        pSSysBDSchemeBase.resetObjNameCase();
        pSSysBDSchemeBase.resetOrderValue();
        pSSysBDSchemeBase.resetPSModuleId();
        pSSysBDSchemeBase.resetPSModuleName();
        pSSysBDSchemeBase.resetPSSubSysServiceAPIId();
        pSSysBDSchemeBase.resetPSSubSysServiceAPIName();
        pSSysBDSchemeBase.resetPSSysBDPartsCnt();
        pSSysBDSchemeBase.resetPSSysBDSchemeId();
        pSSysBDSchemeBase.resetPSSysBDSchemeName();
        pSSysBDSchemeBase.resetPSSysBDTablesCnt();
        pSSysBDSchemeBase.resetPSSysDynaModelId();
        pSSysBDSchemeBase.resetPSSysDynaModelName();
        pSSysBDSchemeBase.resetPSSysModelGroupId();
        pSSysBDSchemeBase.resetPSSysModelGroupName();
        pSSysBDSchemeBase.resetPSSysServiceAPIId();
        pSSysBDSchemeBase.resetPSSysServiceAPIName();
        pSSysBDSchemeBase.resetPSSysSFPluginId();
        pSSysBDSchemeBase.resetPSSysSFPluginName();
        pSSysBDSchemeBase.resetPSSystemId();
        pSSysBDSchemeBase.resetPSSystemName();
        pSSysBDSchemeBase.resetRowKeySeparator();
        pSSysBDSchemeBase.resetSchemeParams();
        pSSysBDSchemeBase.resetSchemeTag();
        pSSysBDSchemeBase.resetSchemeTag2();
        pSSysBDSchemeBase.resetServiceCodeName();
        pSSysBDSchemeBase.resetServiceParam();
        pSSysBDSchemeBase.resetServiceParam2();
        pSSysBDSchemeBase.resetServicePath();
        pSSysBDSchemeBase.resetSubSysServiceCodeName();
        pSSysBDSchemeBase.resetUpdateDate();
        pSSysBDSchemeBase.resetUpdateMan();
        pSSysBDSchemeBase.resetUserCat();
        pSSysBDSchemeBase.resetUserTag();
        pSSysBDSchemeBase.resetUserTag2();
        pSSysBDSchemeBase.resetUserTag3();
        pSSysBDSchemeBase.resetUserTag4();
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
        if (!bl || this.isBDTypeDirty()) {
            hashMap.put(FIELD_BDTYPE, this.getBDType());
        }
        if (!bl || this.isBDTypesDirty()) {
            hashMap.put(FIELD_BDTYPES, this.getBDTypes());
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
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
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
        if (!bl || this.isModelVerDirty()) {
            hashMap.put(FIELD_MODELVER, this.getModelVer());
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
        if (!bl || this.isPSSysBDPartsCntDirty()) {
            hashMap.put(FIELD_PSSYSBDPARTSCNT, this.getPSSysBDPartsCnt());
        }
        if (!bl || this.isPSSysBDSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBDSCHEMEID, this.getPSSysBDSchemeId());
        }
        if (!bl || this.isPSSysBDSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSBDSCHEMENAME, this.getPSSysBDSchemeName());
        }
        if (!bl || this.isPSSysBDTablesCntDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLESCNT, this.getPSSysBDTablesCnt());
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
        if (!bl || this.isRowKeySeparatorDirty()) {
            hashMap.put(FIELD_ROWKEYSEPARATOR, this.getRowKeySeparator());
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
        return PSSysBDSchemeBase.get(this, n);
    }

    private static Object get(PSSysBDSchemeBase pSSysBDSchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDSchemeBase.getAuthClientId();
            }
            case 1: {
                return pSSysBDSchemeBase.getAuthClientSecret();
            }
            case 2: {
                return pSSysBDSchemeBase.getAuthMode();
            }
            case 3: {
                return pSSysBDSchemeBase.getAuthParam();
            }
            case 4: {
                return pSSysBDSchemeBase.getAuthParam2();
            }
            case 5: {
                return pSSysBDSchemeBase.getBDType();
            }
            case 6: {
                return pSSysBDSchemeBase.getBDTypes();
            }
            case 7: {
                return pSSysBDSchemeBase.getCodeName();
            }
            case 8: {
                return pSSysBDSchemeBase.getCreateDate();
            }
            case 9: {
                return pSSysBDSchemeBase.getCreateMan();
            }
            case 10: {
                return pSSysBDSchemeBase.getDefaultFlag();
            }
            case 11: {
                return pSSysBDSchemeBase.getEnableServiceAPI();
            }
            case 12: {
                return pSSysBDSchemeBase.getEnableSubSysServiceAPI();
            }
            case 13: {
                return pSSysBDSchemeBase.getMemo();
            }
            case 14: {
                return pSSysBDSchemeBase.getModelVer();
            }
            case 15: {
                return pSSysBDSchemeBase.getObjNameCase();
            }
            case 16: {
                return pSSysBDSchemeBase.getOrderValue();
            }
            case 17: {
                return pSSysBDSchemeBase.getPSModuleId();
            }
            case 18: {
                return pSSysBDSchemeBase.getPSModuleName();
            }
            case 19: {
                return pSSysBDSchemeBase.getPSSubSysServiceAPIId();
            }
            case 20: {
                return pSSysBDSchemeBase.getPSSubSysServiceAPIName();
            }
            case 21: {
                return pSSysBDSchemeBase.getPSSysBDPartsCnt();
            }
            case 22: {
                return pSSysBDSchemeBase.getPSSysBDSchemeId();
            }
            case 23: {
                return pSSysBDSchemeBase.getPSSysBDSchemeName();
            }
            case 24: {
                return pSSysBDSchemeBase.getPSSysBDTablesCnt();
            }
            case 25: {
                return pSSysBDSchemeBase.getPSSysDynaModelId();
            }
            case 26: {
                return pSSysBDSchemeBase.getPSSysDynaModelName();
            }
            case 27: {
                return pSSysBDSchemeBase.getPSSysModelGroupId();
            }
            case 28: {
                return pSSysBDSchemeBase.getPSSysModelGroupName();
            }
            case 29: {
                return pSSysBDSchemeBase.getPSSysServiceAPIId();
            }
            case 30: {
                return pSSysBDSchemeBase.getPSSysServiceAPIName();
            }
            case 31: {
                return pSSysBDSchemeBase.getPSSysSFPluginId();
            }
            case 32: {
                return pSSysBDSchemeBase.getPSSysSFPluginName();
            }
            case 33: {
                return pSSysBDSchemeBase.getPSSystemId();
            }
            case 34: {
                return pSSysBDSchemeBase.getPSSystemName();
            }
            case 35: {
                return pSSysBDSchemeBase.getRowKeySeparator();
            }
            case 36: {
                return pSSysBDSchemeBase.getSchemeParams();
            }
            case 37: {
                return pSSysBDSchemeBase.getSchemeTag();
            }
            case 38: {
                return pSSysBDSchemeBase.getSchemeTag2();
            }
            case 39: {
                return pSSysBDSchemeBase.getServiceCodeName();
            }
            case 40: {
                return pSSysBDSchemeBase.getServiceParam();
            }
            case 41: {
                return pSSysBDSchemeBase.getServiceParam2();
            }
            case 42: {
                return pSSysBDSchemeBase.getServicePath();
            }
            case 43: {
                return pSSysBDSchemeBase.getSubSysServiceCodeName();
            }
            case 44: {
                return pSSysBDSchemeBase.getUpdateDate();
            }
            case 45: {
                return pSSysBDSchemeBase.getUpdateMan();
            }
            case 46: {
                return pSSysBDSchemeBase.getUserCat();
            }
            case 47: {
                return pSSysBDSchemeBase.getUserTag();
            }
            case 48: {
                return pSSysBDSchemeBase.getUserTag2();
            }
            case 49: {
                return pSSysBDSchemeBase.getUserTag3();
            }
            case 50: {
                return pSSysBDSchemeBase.getUserTag4();
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
        PSSysBDSchemeBase.set(this, n, object);
    }

    private static void set(PSSysBDSchemeBase pSSysBDSchemeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDSchemeBase.setAuthClientId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBDSchemeBase.setAuthClientSecret(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBDSchemeBase.setAuthMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBDSchemeBase.setAuthParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBDSchemeBase.setAuthParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBDSchemeBase.setBDType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBDSchemeBase.setBDTypes(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBDSchemeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBDSchemeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSSysBDSchemeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBDSchemeBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysBDSchemeBase.setEnableServiceAPI(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysBDSchemeBase.setEnableSubSysServiceAPI(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSysBDSchemeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBDSchemeBase.setModelVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSysBDSchemeBase.setObjNameCase(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBDSchemeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSysBDSchemeBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBDSchemeBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBDSchemeBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysBDSchemeBase.setPSSubSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBDSchemeBase.setPSSysBDPartsCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSSysBDSchemeBase.setPSSysBDSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBDSchemeBase.setPSSysBDSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBDSchemeBase.setPSSysBDTablesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSSysBDSchemeBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysBDSchemeBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysBDSchemeBase.setPSSysModelGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysBDSchemeBase.setPSSysModelGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysBDSchemeBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysBDSchemeBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysBDSchemeBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysBDSchemeBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysBDSchemeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysBDSchemeBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysBDSchemeBase.setRowKeySeparator(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysBDSchemeBase.setSchemeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysBDSchemeBase.setSchemeTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysBDSchemeBase.setSchemeTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysBDSchemeBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysBDSchemeBase.setServiceParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysBDSchemeBase.setServiceParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysBDSchemeBase.setServicePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysBDSchemeBase.setSubSysServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysBDSchemeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 45: {
                pSSysBDSchemeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysBDSchemeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysBDSchemeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysBDSchemeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysBDSchemeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysBDSchemeBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysBDSchemeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBDSchemeBase pSSysBDSchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDSchemeBase.getAuthClientId() == null;
            }
            case 1: {
                return pSSysBDSchemeBase.getAuthClientSecret() == null;
            }
            case 2: {
                return pSSysBDSchemeBase.getAuthMode() == null;
            }
            case 3: {
                return pSSysBDSchemeBase.getAuthParam() == null;
            }
            case 4: {
                return pSSysBDSchemeBase.getAuthParam2() == null;
            }
            case 5: {
                return pSSysBDSchemeBase.getBDType() == null;
            }
            case 6: {
                return pSSysBDSchemeBase.getBDTypes() == null;
            }
            case 7: {
                return pSSysBDSchemeBase.getCodeName() == null;
            }
            case 8: {
                return pSSysBDSchemeBase.getCreateDate() == null;
            }
            case 9: {
                return pSSysBDSchemeBase.getCreateMan() == null;
            }
            case 10: {
                return pSSysBDSchemeBase.getDefaultFlag() == null;
            }
            case 11: {
                return pSSysBDSchemeBase.getEnableServiceAPI() == null;
            }
            case 12: {
                return pSSysBDSchemeBase.getEnableSubSysServiceAPI() == null;
            }
            case 13: {
                return pSSysBDSchemeBase.getMemo() == null;
            }
            case 14: {
                return pSSysBDSchemeBase.getModelVer() == null;
            }
            case 15: {
                return pSSysBDSchemeBase.getObjNameCase() == null;
            }
            case 16: {
                return pSSysBDSchemeBase.getOrderValue() == null;
            }
            case 17: {
                return pSSysBDSchemeBase.getPSModuleId() == null;
            }
            case 18: {
                return pSSysBDSchemeBase.getPSModuleName() == null;
            }
            case 19: {
                return pSSysBDSchemeBase.getPSSubSysServiceAPIId() == null;
            }
            case 20: {
                return pSSysBDSchemeBase.getPSSubSysServiceAPIName() == null;
            }
            case 21: {
                return pSSysBDSchemeBase.getPSSysBDPartsCnt() == null;
            }
            case 22: {
                return pSSysBDSchemeBase.getPSSysBDSchemeId() == null;
            }
            case 23: {
                return pSSysBDSchemeBase.getPSSysBDSchemeName() == null;
            }
            case 24: {
                return pSSysBDSchemeBase.getPSSysBDTablesCnt() == null;
            }
            case 25: {
                return pSSysBDSchemeBase.getPSSysDynaModelId() == null;
            }
            case 26: {
                return pSSysBDSchemeBase.getPSSysDynaModelName() == null;
            }
            case 27: {
                return pSSysBDSchemeBase.getPSSysModelGroupId() == null;
            }
            case 28: {
                return pSSysBDSchemeBase.getPSSysModelGroupName() == null;
            }
            case 29: {
                return pSSysBDSchemeBase.getPSSysServiceAPIId() == null;
            }
            case 30: {
                return pSSysBDSchemeBase.getPSSysServiceAPIName() == null;
            }
            case 31: {
                return pSSysBDSchemeBase.getPSSysSFPluginId() == null;
            }
            case 32: {
                return pSSysBDSchemeBase.getPSSysSFPluginName() == null;
            }
            case 33: {
                return pSSysBDSchemeBase.getPSSystemId() == null;
            }
            case 34: {
                return pSSysBDSchemeBase.getPSSystemName() == null;
            }
            case 35: {
                return pSSysBDSchemeBase.getRowKeySeparator() == null;
            }
            case 36: {
                return pSSysBDSchemeBase.getSchemeParams() == null;
            }
            case 37: {
                return pSSysBDSchemeBase.getSchemeTag() == null;
            }
            case 38: {
                return pSSysBDSchemeBase.getSchemeTag2() == null;
            }
            case 39: {
                return pSSysBDSchemeBase.getServiceCodeName() == null;
            }
            case 40: {
                return pSSysBDSchemeBase.getServiceParam() == null;
            }
            case 41: {
                return pSSysBDSchemeBase.getServiceParam2() == null;
            }
            case 42: {
                return pSSysBDSchemeBase.getServicePath() == null;
            }
            case 43: {
                return pSSysBDSchemeBase.getSubSysServiceCodeName() == null;
            }
            case 44: {
                return pSSysBDSchemeBase.getUpdateDate() == null;
            }
            case 45: {
                return pSSysBDSchemeBase.getUpdateMan() == null;
            }
            case 46: {
                return pSSysBDSchemeBase.getUserCat() == null;
            }
            case 47: {
                return pSSysBDSchemeBase.getUserTag() == null;
            }
            case 48: {
                return pSSysBDSchemeBase.getUserTag2() == null;
            }
            case 49: {
                return pSSysBDSchemeBase.getUserTag3() == null;
            }
            case 50: {
                return pSSysBDSchemeBase.getUserTag4() == null;
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
        return PSSysBDSchemeBase.contains(this, n);
    }

    private static boolean contains(PSSysBDSchemeBase pSSysBDSchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDSchemeBase.isAuthClientIdDirty();
            }
            case 1: {
                return pSSysBDSchemeBase.isAuthClientSecretDirty();
            }
            case 2: {
                return pSSysBDSchemeBase.isAuthModeDirty();
            }
            case 3: {
                return pSSysBDSchemeBase.isAuthParamDirty();
            }
            case 4: {
                return pSSysBDSchemeBase.isAuthParam2Dirty();
            }
            case 5: {
                return pSSysBDSchemeBase.isBDTypeDirty();
            }
            case 6: {
                return pSSysBDSchemeBase.isBDTypesDirty();
            }
            case 7: {
                return pSSysBDSchemeBase.isCodeNameDirty();
            }
            case 8: {
                return pSSysBDSchemeBase.isCreateDateDirty();
            }
            case 9: {
                return pSSysBDSchemeBase.isCreateManDirty();
            }
            case 10: {
                return pSSysBDSchemeBase.isDefaultFlagDirty();
            }
            case 11: {
                return pSSysBDSchemeBase.isEnableServiceAPIDirty();
            }
            case 12: {
                return pSSysBDSchemeBase.isEnableSubSysServiceAPIDirty();
            }
            case 13: {
                return pSSysBDSchemeBase.isMemoDirty();
            }
            case 14: {
                return pSSysBDSchemeBase.isModelVerDirty();
            }
            case 15: {
                return pSSysBDSchemeBase.isObjNameCaseDirty();
            }
            case 16: {
                return pSSysBDSchemeBase.isOrderValueDirty();
            }
            case 17: {
                return pSSysBDSchemeBase.isPSModuleIdDirty();
            }
            case 18: {
                return pSSysBDSchemeBase.isPSModuleNameDirty();
            }
            case 19: {
                return pSSysBDSchemeBase.isPSSubSysServiceAPIIdDirty();
            }
            case 20: {
                return pSSysBDSchemeBase.isPSSubSysServiceAPINameDirty();
            }
            case 21: {
                return pSSysBDSchemeBase.isPSSysBDPartsCntDirty();
            }
            case 22: {
                return pSSysBDSchemeBase.isPSSysBDSchemeIdDirty();
            }
            case 23: {
                return pSSysBDSchemeBase.isPSSysBDSchemeNameDirty();
            }
            case 24: {
                return pSSysBDSchemeBase.isPSSysBDTablesCntDirty();
            }
            case 25: {
                return pSSysBDSchemeBase.isPSSysDynaModelIdDirty();
            }
            case 26: {
                return pSSysBDSchemeBase.isPSSysDynaModelNameDirty();
            }
            case 27: {
                return pSSysBDSchemeBase.isPSSysModelGroupIdDirty();
            }
            case 28: {
                return pSSysBDSchemeBase.isPSSysModelGroupNameDirty();
            }
            case 29: {
                return pSSysBDSchemeBase.isPSSysServiceAPIIdDirty();
            }
            case 30: {
                return pSSysBDSchemeBase.isPSSysServiceAPINameDirty();
            }
            case 31: {
                return pSSysBDSchemeBase.isPSSysSFPluginIdDirty();
            }
            case 32: {
                return pSSysBDSchemeBase.isPSSysSFPluginNameDirty();
            }
            case 33: {
                return pSSysBDSchemeBase.isPSSystemIdDirty();
            }
            case 34: {
                return pSSysBDSchemeBase.isPSSystemNameDirty();
            }
            case 35: {
                return pSSysBDSchemeBase.isRowKeySeparatorDirty();
            }
            case 36: {
                return pSSysBDSchemeBase.isSchemeParamsDirty();
            }
            case 37: {
                return pSSysBDSchemeBase.isSchemeTagDirty();
            }
            case 38: {
                return pSSysBDSchemeBase.isSchemeTag2Dirty();
            }
            case 39: {
                return pSSysBDSchemeBase.isServiceCodeNameDirty();
            }
            case 40: {
                return pSSysBDSchemeBase.isServiceParamDirty();
            }
            case 41: {
                return pSSysBDSchemeBase.isServiceParam2Dirty();
            }
            case 42: {
                return pSSysBDSchemeBase.isServicePathDirty();
            }
            case 43: {
                return pSSysBDSchemeBase.isSubSysServiceCodeNameDirty();
            }
            case 44: {
                return pSSysBDSchemeBase.isUpdateDateDirty();
            }
            case 45: {
                return pSSysBDSchemeBase.isUpdateManDirty();
            }
            case 46: {
                return pSSysBDSchemeBase.isUserCatDirty();
            }
            case 47: {
                return pSSysBDSchemeBase.isUserTagDirty();
            }
            case 48: {
                return pSSysBDSchemeBase.isUserTag2Dirty();
            }
            case 49: {
                return pSSysBDSchemeBase.isUserTag3Dirty();
            }
            case 50: {
                return pSSysBDSchemeBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBDSchemeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBDSchemeBase pSSysBDSchemeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBDSchemeBase.getAuthClientId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientid", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getAuthClientId()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getAuthClientSecret() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientsecret", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getAuthClientSecret()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getAuthMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authmode", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getAuthMode()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getAuthParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getAuthParam()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getAuthParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam2", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getAuthParam2()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getBDType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bdtype", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getBDType()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getBDTypes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bdtypes", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getBDTypes()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getEnableServiceAPI() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableserviceapi", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getEnableServiceAPI()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getEnableSubSysServiceAPI() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesubsysserviceapi", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getEnableSubSysServiceAPI()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getModelVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelver", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getModelVer()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getObjNameCase() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objnamecase", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getObjNameCase()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSubSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiname", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSubSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSysBDPartsCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdpartscnt", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSysBDPartsCnt()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSysBDSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdschemeid", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSysBDSchemeId()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSysBDSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdschemename", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSysBDSchemeName()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSysBDTablesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtablescnt", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSysBDTablesCnt()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSysModelGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupid", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSysModelGroupId()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSysModelGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelgroupname", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSysModelGroupName()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getRowKeySeparator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rowkeyseparator", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getRowKeySeparator()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getSchemeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"schemeparams", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getSchemeParams()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getSchemeTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"schemetag", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getSchemeTag()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getSchemeTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"schemetag2", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getSchemeTag2()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getServiceParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getServiceParam()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getServiceParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam2", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getServiceParam2()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getServicePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicepath", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getServicePath()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getSubSysServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subsysservicecodename", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getSubSysServiceCodeName()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBDSchemeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBDSchemeBase.getJSONValue((Object)pSSysBDSchemeBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBDSchemeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBDSchemeBase pSSysBDSchemeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBDSchemeBase.getAuthClientId() != null) {
            object = pSSysBDSchemeBase.getAuthClientId();
            xmlNode.setAttribute(FIELD_AUTHCLIENTID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBDSchemeBase.getAuthClientSecret() != null) {
            object = pSSysBDSchemeBase.getAuthClientSecret();
            xmlNode.setAttribute(FIELD_AUTHCLIENTSECRET, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBDSchemeBase.getAuthMode() != null) {
            object = pSSysBDSchemeBase.getAuthMode();
            xmlNode.setAttribute(FIELD_AUTHMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBDSchemeBase.getAuthParam() != null) {
            object = pSSysBDSchemeBase.getAuthParam();
            xmlNode.setAttribute(FIELD_AUTHPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBDSchemeBase.getAuthParam2() != null) {
            object = pSSysBDSchemeBase.getAuthParam2();
            xmlNode.setAttribute(FIELD_AUTHPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBDSchemeBase.getBDType() != null) {
            object = pSSysBDSchemeBase.getBDType();
            xmlNode.setAttribute(FIELD_BDTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBDSchemeBase.getBDTypes() != null) {
            object = pSSysBDSchemeBase.getBDTypes();
            xmlNode.setAttribute(FIELD_BDTYPES, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBDSchemeBase.getCodeName() != null) {
            object = pSSysBDSchemeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getCreateDate() != null) {
            object = pSSysBDSchemeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDSchemeBase.getCreateMan() != null) {
            object = pSSysBDSchemeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getDefaultFlag() != null) {
            object = pSSysBDSchemeBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDSchemeBase.getEnableServiceAPI() != null) {
            object = pSSysBDSchemeBase.getEnableServiceAPI();
            xmlNode.setAttribute(FIELD_ENABLESERVICEAPI, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDSchemeBase.getEnableSubSysServiceAPI() != null) {
            object = pSSysBDSchemeBase.getEnableSubSysServiceAPI();
            xmlNode.setAttribute(FIELD_ENABLESUBSYSSERVICEAPI, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDSchemeBase.getMemo() != null) {
            object = pSSysBDSchemeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getModelVer() != null) {
            object = pSSysBDSchemeBase.getModelVer();
            xmlNode.setAttribute(FIELD_MODELVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDSchemeBase.getObjNameCase() != null) {
            object = pSSysBDSchemeBase.getObjNameCase();
            xmlNode.setAttribute(FIELD_OBJNAMECASE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getOrderValue() != null) {
            object = pSSysBDSchemeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDSchemeBase.getPSModuleId() != null) {
            object = pSSysBDSchemeBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getPSModuleName() != null) {
            object = pSSysBDSchemeBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getPSSubSysServiceAPIId() != null) {
            object = pSSysBDSchemeBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getPSSubSysServiceAPIName() != null) {
            object = pSSysBDSchemeBase.getPSSubSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getPSSysBDPartsCnt() != null) {
            object = pSSysBDSchemeBase.getPSSysBDPartsCnt();
            xmlNode.setAttribute(FIELD_PSSYSBDPARTSCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDSchemeBase.getPSSysBDSchemeId() != null) {
            object = pSSysBDSchemeBase.getPSSysBDSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBDSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getPSSysBDSchemeName() != null) {
            object = pSSysBDSchemeBase.getPSSysBDSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSBDSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getPSSysBDTablesCnt() != null) {
            object = pSSysBDSchemeBase.getPSSysBDTablesCnt();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDSchemeBase.getPSSysDynaModelId() != null) {
            object = pSSysBDSchemeBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getPSSysDynaModelName() != null) {
            object = pSSysBDSchemeBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getPSSysModelGroupId() != null) {
            object = pSSysBDSchemeBase.getPSSysModelGroupId();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getPSSysModelGroupName() != null) {
            object = pSSysBDSchemeBase.getPSSysModelGroupName();
            xmlNode.setAttribute(FIELD_PSSYSMODELGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getPSSysServiceAPIId() != null) {
            object = pSSysBDSchemeBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getPSSysServiceAPIName() != null) {
            object = pSSysBDSchemeBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getPSSysSFPluginId() != null) {
            object = pSSysBDSchemeBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getPSSysSFPluginName() != null) {
            object = pSSysBDSchemeBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getPSSystemId() != null) {
            object = pSSysBDSchemeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getPSSystemName() != null) {
            object = pSSysBDSchemeBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getRowKeySeparator() != null) {
            object = pSSysBDSchemeBase.getRowKeySeparator();
            xmlNode.setAttribute(FIELD_ROWKEYSEPARATOR, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getSchemeParams() != null) {
            object = pSSysBDSchemeBase.getSchemeParams();
            xmlNode.setAttribute(FIELD_SCHEMEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getSchemeTag() != null) {
            object = pSSysBDSchemeBase.getSchemeTag();
            xmlNode.setAttribute(FIELD_SCHEMETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getSchemeTag2() != null) {
            object = pSSysBDSchemeBase.getSchemeTag2();
            xmlNode.setAttribute(FIELD_SCHEMETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getServiceCodeName() != null) {
            object = pSSysBDSchemeBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getServiceParam() != null) {
            object = pSSysBDSchemeBase.getServiceParam();
            xmlNode.setAttribute(FIELD_SERVICEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getServiceParam2() != null) {
            object = pSSysBDSchemeBase.getServiceParam2();
            xmlNode.setAttribute(FIELD_SERVICEPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getServicePath() != null) {
            object = pSSysBDSchemeBase.getServicePath();
            xmlNode.setAttribute(FIELD_SERVICEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getSubSysServiceCodeName() != null) {
            object = pSSysBDSchemeBase.getSubSysServiceCodeName();
            xmlNode.setAttribute(FIELD_SUBSYSSERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getUpdateDate() != null) {
            object = pSSysBDSchemeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDSchemeBase.getUpdateMan() != null) {
            object = pSSysBDSchemeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getUserCat() != null) {
            object = pSSysBDSchemeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getUserTag() != null) {
            object = pSSysBDSchemeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getUserTag2() != null) {
            object = pSSysBDSchemeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getUserTag3() != null) {
            object = pSSysBDSchemeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDSchemeBase.getUserTag4() != null) {
            object = pSSysBDSchemeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBDSchemeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBDSchemeBase pSSysBDSchemeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBDSchemeBase.isAuthClientIdDirty() && (bl || pSSysBDSchemeBase.getAuthClientId() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTID, (Object)pSSysBDSchemeBase.getAuthClientId());
        }
        if (pSSysBDSchemeBase.isAuthClientSecretDirty() && (bl || pSSysBDSchemeBase.getAuthClientSecret() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTSECRET, (Object)pSSysBDSchemeBase.getAuthClientSecret());
        }
        if (pSSysBDSchemeBase.isAuthModeDirty() && (bl || pSSysBDSchemeBase.getAuthMode() != null)) {
            iDataObject.set(FIELD_AUTHMODE, (Object)pSSysBDSchemeBase.getAuthMode());
        }
        if (pSSysBDSchemeBase.isAuthParamDirty() && (bl || pSSysBDSchemeBase.getAuthParam() != null)) {
            iDataObject.set(FIELD_AUTHPARAM, (Object)pSSysBDSchemeBase.getAuthParam());
        }
        if (pSSysBDSchemeBase.isAuthParam2Dirty() && (bl || pSSysBDSchemeBase.getAuthParam2() != null)) {
            iDataObject.set(FIELD_AUTHPARAM2, (Object)pSSysBDSchemeBase.getAuthParam2());
        }
        if (pSSysBDSchemeBase.isBDTypeDirty() && (bl || pSSysBDSchemeBase.getBDType() != null)) {
            iDataObject.set(FIELD_BDTYPE, (Object)pSSysBDSchemeBase.getBDType());
        }
        if (pSSysBDSchemeBase.isBDTypesDirty() && (bl || pSSysBDSchemeBase.getBDTypes() != null)) {
            iDataObject.set(FIELD_BDTYPES, (Object)pSSysBDSchemeBase.getBDTypes());
        }
        if (pSSysBDSchemeBase.isCodeNameDirty() && (bl || pSSysBDSchemeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBDSchemeBase.getCodeName());
        }
        if (pSSysBDSchemeBase.isCreateDateDirty() && (bl || pSSysBDSchemeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBDSchemeBase.getCreateDate());
        }
        if (pSSysBDSchemeBase.isCreateManDirty() && (bl || pSSysBDSchemeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBDSchemeBase.getCreateMan());
        }
        if (pSSysBDSchemeBase.isDefaultFlagDirty() && (bl || pSSysBDSchemeBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSSysBDSchemeBase.getDefaultFlag());
        }
        if (pSSysBDSchemeBase.isEnableServiceAPIDirty() && (bl || pSSysBDSchemeBase.getEnableServiceAPI() != null)) {
            iDataObject.set(FIELD_ENABLESERVICEAPI, (Object)pSSysBDSchemeBase.getEnableServiceAPI());
        }
        if (pSSysBDSchemeBase.isEnableSubSysServiceAPIDirty() && (bl || pSSysBDSchemeBase.getEnableSubSysServiceAPI() != null)) {
            iDataObject.set(FIELD_ENABLESUBSYSSERVICEAPI, (Object)pSSysBDSchemeBase.getEnableSubSysServiceAPI());
        }
        if (pSSysBDSchemeBase.isMemoDirty() && (bl || pSSysBDSchemeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBDSchemeBase.getMemo());
        }
        if (pSSysBDSchemeBase.isModelVerDirty() && (bl || pSSysBDSchemeBase.getModelVer() != null)) {
            iDataObject.set(FIELD_MODELVER, (Object)pSSysBDSchemeBase.getModelVer());
        }
        if (pSSysBDSchemeBase.isObjNameCaseDirty() && (bl || pSSysBDSchemeBase.getObjNameCase() != null)) {
            iDataObject.set(FIELD_OBJNAMECASE, (Object)pSSysBDSchemeBase.getObjNameCase());
        }
        if (pSSysBDSchemeBase.isOrderValueDirty() && (bl || pSSysBDSchemeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysBDSchemeBase.getOrderValue());
        }
        if (pSSysBDSchemeBase.isPSModuleIdDirty() && (bl || pSSysBDSchemeBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysBDSchemeBase.getPSModuleId());
        }
        if (pSSysBDSchemeBase.isPSModuleNameDirty() && (bl || pSSysBDSchemeBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysBDSchemeBase.getPSModuleName());
        }
        if (pSSysBDSchemeBase.isPSSubSysServiceAPIIdDirty() && (bl || pSSysBDSchemeBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSSysBDSchemeBase.getPSSubSysServiceAPIId());
        }
        if (pSSysBDSchemeBase.isPSSubSysServiceAPINameDirty() && (bl || pSSysBDSchemeBase.getPSSubSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPINAME, (Object)pSSysBDSchemeBase.getPSSubSysServiceAPIName());
        }
        if (pSSysBDSchemeBase.isPSSysBDPartsCntDirty() && (bl || pSSysBDSchemeBase.getPSSysBDPartsCnt() != null)) {
            iDataObject.set(FIELD_PSSYSBDPARTSCNT, (Object)pSSysBDSchemeBase.getPSSysBDPartsCnt());
        }
        if (pSSysBDSchemeBase.isPSSysBDSchemeIdDirty() && (bl || pSSysBDSchemeBase.getPSSysBDSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBDSCHEMEID, (Object)pSSysBDSchemeBase.getPSSysBDSchemeId());
        }
        if (pSSysBDSchemeBase.isPSSysBDSchemeNameDirty() && (bl || pSSysBDSchemeBase.getPSSysBDSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSBDSCHEMENAME, (Object)pSSysBDSchemeBase.getPSSysBDSchemeName());
        }
        if (pSSysBDSchemeBase.isPSSysBDTablesCntDirty() && (bl || pSSysBDSchemeBase.getPSSysBDTablesCnt() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLESCNT, (Object)pSSysBDSchemeBase.getPSSysBDTablesCnt());
        }
        if (pSSysBDSchemeBase.isPSSysDynaModelIdDirty() && (bl || pSSysBDSchemeBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysBDSchemeBase.getPSSysDynaModelId());
        }
        if (pSSysBDSchemeBase.isPSSysDynaModelNameDirty() && (bl || pSSysBDSchemeBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysBDSchemeBase.getPSSysDynaModelName());
        }
        if (pSSysBDSchemeBase.isPSSysModelGroupIdDirty() && (bl || pSSysBDSchemeBase.getPSSysModelGroupId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPID, (Object)pSSysBDSchemeBase.getPSSysModelGroupId());
        }
        if (pSSysBDSchemeBase.isPSSysModelGroupNameDirty() && (bl || pSSysBDSchemeBase.getPSSysModelGroupName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELGROUPNAME, (Object)pSSysBDSchemeBase.getPSSysModelGroupName());
        }
        if (pSSysBDSchemeBase.isPSSysServiceAPIIdDirty() && (bl || pSSysBDSchemeBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSSysBDSchemeBase.getPSSysServiceAPIId());
        }
        if (pSSysBDSchemeBase.isPSSysServiceAPINameDirty() && (bl || pSSysBDSchemeBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSSysBDSchemeBase.getPSSysServiceAPIName());
        }
        if (pSSysBDSchemeBase.isPSSysSFPluginIdDirty() && (bl || pSSysBDSchemeBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysBDSchemeBase.getPSSysSFPluginId());
        }
        if (pSSysBDSchemeBase.isPSSysSFPluginNameDirty() && (bl || pSSysBDSchemeBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysBDSchemeBase.getPSSysSFPluginName());
        }
        if (pSSysBDSchemeBase.isPSSystemIdDirty() && (bl || pSSysBDSchemeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysBDSchemeBase.getPSSystemId());
        }
        if (pSSysBDSchemeBase.isPSSystemNameDirty() && (bl || pSSysBDSchemeBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysBDSchemeBase.getPSSystemName());
        }
        if (pSSysBDSchemeBase.isRowKeySeparatorDirty() && (bl || pSSysBDSchemeBase.getRowKeySeparator() != null)) {
            iDataObject.set(FIELD_ROWKEYSEPARATOR, (Object)pSSysBDSchemeBase.getRowKeySeparator());
        }
        if (pSSysBDSchemeBase.isSchemeParamsDirty() && (bl || pSSysBDSchemeBase.getSchemeParams() != null)) {
            iDataObject.set(FIELD_SCHEMEPARAMS, (Object)pSSysBDSchemeBase.getSchemeParams());
        }
        if (pSSysBDSchemeBase.isSchemeTagDirty() && (bl || pSSysBDSchemeBase.getSchemeTag() != null)) {
            iDataObject.set(FIELD_SCHEMETAG, (Object)pSSysBDSchemeBase.getSchemeTag());
        }
        if (pSSysBDSchemeBase.isSchemeTag2Dirty() && (bl || pSSysBDSchemeBase.getSchemeTag2() != null)) {
            iDataObject.set(FIELD_SCHEMETAG2, (Object)pSSysBDSchemeBase.getSchemeTag2());
        }
        if (pSSysBDSchemeBase.isServiceCodeNameDirty() && (bl || pSSysBDSchemeBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSSysBDSchemeBase.getServiceCodeName());
        }
        if (pSSysBDSchemeBase.isServiceParamDirty() && (bl || pSSysBDSchemeBase.getServiceParam() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM, (Object)pSSysBDSchemeBase.getServiceParam());
        }
        if (pSSysBDSchemeBase.isServiceParam2Dirty() && (bl || pSSysBDSchemeBase.getServiceParam2() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM2, (Object)pSSysBDSchemeBase.getServiceParam2());
        }
        if (pSSysBDSchemeBase.isServicePathDirty() && (bl || pSSysBDSchemeBase.getServicePath() != null)) {
            iDataObject.set(FIELD_SERVICEPATH, (Object)pSSysBDSchemeBase.getServicePath());
        }
        if (pSSysBDSchemeBase.isSubSysServiceCodeNameDirty() && (bl || pSSysBDSchemeBase.getSubSysServiceCodeName() != null)) {
            iDataObject.set(FIELD_SUBSYSSERVICECODENAME, (Object)pSSysBDSchemeBase.getSubSysServiceCodeName());
        }
        if (pSSysBDSchemeBase.isUpdateDateDirty() && (bl || pSSysBDSchemeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBDSchemeBase.getUpdateDate());
        }
        if (pSSysBDSchemeBase.isUpdateManDirty() && (bl || pSSysBDSchemeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBDSchemeBase.getUpdateMan());
        }
        if (pSSysBDSchemeBase.isUserCatDirty() && (bl || pSSysBDSchemeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBDSchemeBase.getUserCat());
        }
        if (pSSysBDSchemeBase.isUserTagDirty() && (bl || pSSysBDSchemeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBDSchemeBase.getUserTag());
        }
        if (pSSysBDSchemeBase.isUserTag2Dirty() && (bl || pSSysBDSchemeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBDSchemeBase.getUserTag2());
        }
        if (pSSysBDSchemeBase.isUserTag3Dirty() && (bl || pSSysBDSchemeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBDSchemeBase.getUserTag3());
        }
        if (pSSysBDSchemeBase.isUserTag4Dirty() && (bl || pSSysBDSchemeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBDSchemeBase.getUserTag4());
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
        return PSSysBDSchemeBase.remove(this, n);
    }

    private static boolean remove(PSSysBDSchemeBase pSSysBDSchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDSchemeBase.resetAuthClientId();
                return true;
            }
            case 1: {
                pSSysBDSchemeBase.resetAuthClientSecret();
                return true;
            }
            case 2: {
                pSSysBDSchemeBase.resetAuthMode();
                return true;
            }
            case 3: {
                pSSysBDSchemeBase.resetAuthParam();
                return true;
            }
            case 4: {
                pSSysBDSchemeBase.resetAuthParam2();
                return true;
            }
            case 5: {
                pSSysBDSchemeBase.resetBDType();
                return true;
            }
            case 6: {
                pSSysBDSchemeBase.resetBDTypes();
                return true;
            }
            case 7: {
                pSSysBDSchemeBase.resetCodeName();
                return true;
            }
            case 8: {
                pSSysBDSchemeBase.resetCreateDate();
                return true;
            }
            case 9: {
                pSSysBDSchemeBase.resetCreateMan();
                return true;
            }
            case 10: {
                pSSysBDSchemeBase.resetDefaultFlag();
                return true;
            }
            case 11: {
                pSSysBDSchemeBase.resetEnableServiceAPI();
                return true;
            }
            case 12: {
                pSSysBDSchemeBase.resetEnableSubSysServiceAPI();
                return true;
            }
            case 13: {
                pSSysBDSchemeBase.resetMemo();
                return true;
            }
            case 14: {
                pSSysBDSchemeBase.resetModelVer();
                return true;
            }
            case 15: {
                pSSysBDSchemeBase.resetObjNameCase();
                return true;
            }
            case 16: {
                pSSysBDSchemeBase.resetOrderValue();
                return true;
            }
            case 17: {
                pSSysBDSchemeBase.resetPSModuleId();
                return true;
            }
            case 18: {
                pSSysBDSchemeBase.resetPSModuleName();
                return true;
            }
            case 19: {
                pSSysBDSchemeBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 20: {
                pSSysBDSchemeBase.resetPSSubSysServiceAPIName();
                return true;
            }
            case 21: {
                pSSysBDSchemeBase.resetPSSysBDPartsCnt();
                return true;
            }
            case 22: {
                pSSysBDSchemeBase.resetPSSysBDSchemeId();
                return true;
            }
            case 23: {
                pSSysBDSchemeBase.resetPSSysBDSchemeName();
                return true;
            }
            case 24: {
                pSSysBDSchemeBase.resetPSSysBDTablesCnt();
                return true;
            }
            case 25: {
                pSSysBDSchemeBase.resetPSSysDynaModelId();
                return true;
            }
            case 26: {
                pSSysBDSchemeBase.resetPSSysDynaModelName();
                return true;
            }
            case 27: {
                pSSysBDSchemeBase.resetPSSysModelGroupId();
                return true;
            }
            case 28: {
                pSSysBDSchemeBase.resetPSSysModelGroupName();
                return true;
            }
            case 29: {
                pSSysBDSchemeBase.resetPSSysServiceAPIId();
                return true;
            }
            case 30: {
                pSSysBDSchemeBase.resetPSSysServiceAPIName();
                return true;
            }
            case 31: {
                pSSysBDSchemeBase.resetPSSysSFPluginId();
                return true;
            }
            case 32: {
                pSSysBDSchemeBase.resetPSSysSFPluginName();
                return true;
            }
            case 33: {
                pSSysBDSchemeBase.resetPSSystemId();
                return true;
            }
            case 34: {
                pSSysBDSchemeBase.resetPSSystemName();
                return true;
            }
            case 35: {
                pSSysBDSchemeBase.resetRowKeySeparator();
                return true;
            }
            case 36: {
                pSSysBDSchemeBase.resetSchemeParams();
                return true;
            }
            case 37: {
                pSSysBDSchemeBase.resetSchemeTag();
                return true;
            }
            case 38: {
                pSSysBDSchemeBase.resetSchemeTag2();
                return true;
            }
            case 39: {
                pSSysBDSchemeBase.resetServiceCodeName();
                return true;
            }
            case 40: {
                pSSysBDSchemeBase.resetServiceParam();
                return true;
            }
            case 41: {
                pSSysBDSchemeBase.resetServiceParam2();
                return true;
            }
            case 42: {
                pSSysBDSchemeBase.resetServicePath();
                return true;
            }
            case 43: {
                pSSysBDSchemeBase.resetSubSysServiceCodeName();
                return true;
            }
            case 44: {
                pSSysBDSchemeBase.resetUpdateDate();
                return true;
            }
            case 45: {
                pSSysBDSchemeBase.resetUpdateMan();
                return true;
            }
            case 46: {
                pSSysBDSchemeBase.resetUserCat();
                return true;
            }
            case 47: {
                pSSysBDSchemeBase.resetUserTag();
                return true;
            }
            case 48: {
                pSSysBDSchemeBase.resetUserTag2();
                return true;
            }
            case 49: {
                pSSysBDSchemeBase.resetUserTag3();
                return true;
            }
            case 50: {
                pSSysBDSchemeBase.resetUserTag4();
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
    public ArrayList<PSSysBDPart> getPSSysBDParts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDParts();
        }
        if (this.getPSSysBDSchemeId() == null) {
            return null;
        }
        PSSysBDPartService pSSysBDPartService = (PSSysBDPartService)ServiceGlobal.getService(PSSysBDPartService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBDPartsLock;
        synchronized (n) {
            if (this.pssysbdparts == null) {
                this.pssysbdparts = pSSysBDPartService.selectByPSSysBDScheme(this);
            }
            return this.pssysbdparts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBDTableRS> getPSSysBDTableRSes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableRSes();
        }
        if (this.getPSSysBDSchemeId() == null) {
            return null;
        }
        PSSysBDTableRSService pSSysBDTableRSService = (PSSysBDTableRSService)ServiceGlobal.getService(PSSysBDTableRSService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBDTableRSesLock;
        synchronized (n) {
            if (this.pssysbdtablerses == null) {
                this.pssysbdtablerses = pSSysBDTableRSService.selectByPSSysBDScheme(this);
            }
            return this.pssysbdtablerses;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBDTable> getPSSysBDTables() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTables();
        }
        if (this.getPSSysBDSchemeId() == null) {
            return null;
        }
        PSSysBDTableService pSSysBDTableService = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBDTablesLock;
        synchronized (n) {
            if (this.pssysbdtables == null) {
                this.pssysbdtables = pSSysBDTableService.selectByPSSysBDScheme(this);
            }
            return this.pssysbdtables;
        }
    }

    private PSSysBDSchemeBase getProxyEntity() {
        return this.proxyPSSysBDSchemeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBDSchemeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBDSchemeBase) {
            this.proxyPSSysBDSchemeBase = (PSSysBDSchemeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AUTHCLIENTID, 0);
        fieldIndexMap.put(FIELD_AUTHCLIENTSECRET, 1);
        fieldIndexMap.put(FIELD_AUTHMODE, 2);
        fieldIndexMap.put(FIELD_AUTHPARAM, 3);
        fieldIndexMap.put(FIELD_AUTHPARAM2, 4);
        fieldIndexMap.put(FIELD_BDTYPE, 5);
        fieldIndexMap.put(FIELD_BDTYPES, 6);
        fieldIndexMap.put(FIELD_CODENAME, 7);
        fieldIndexMap.put(FIELD_CREATEDATE, 8);
        fieldIndexMap.put(FIELD_CREATEMAN, 9);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 10);
        fieldIndexMap.put(FIELD_ENABLESERVICEAPI, 11);
        fieldIndexMap.put(FIELD_ENABLESUBSYSSERVICEAPI, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_MODELVER, 14);
        fieldIndexMap.put(FIELD_OBJNAMECASE, 15);
        fieldIndexMap.put(FIELD_ORDERVALUE, 16);
        fieldIndexMap.put(FIELD_PSMODULEID, 17);
        fieldIndexMap.put(FIELD_PSMODULENAME, 18);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 19);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPINAME, 20);
        fieldIndexMap.put(FIELD_PSSYSBDPARTSCNT, 21);
        fieldIndexMap.put(FIELD_PSSYSBDSCHEMEID, 22);
        fieldIndexMap.put(FIELD_PSSYSBDSCHEMENAME, 23);
        fieldIndexMap.put(FIELD_PSSYSBDTABLESCNT, 24);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 25);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 26);
        fieldIndexMap.put(FIELD_PSSYSMODELGROUPID, 27);
        fieldIndexMap.put(FIELD_PSSYSMODELGROUPNAME, 28);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 29);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPINAME, 30);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 31);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 32);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 33);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 34);
        fieldIndexMap.put(FIELD_ROWKEYSEPARATOR, 35);
        fieldIndexMap.put(FIELD_SCHEMEPARAMS, 36);
        fieldIndexMap.put(FIELD_SCHEMETAG, 37);
        fieldIndexMap.put(FIELD_SCHEMETAG2, 38);
        fieldIndexMap.put(FIELD_SERVICECODENAME, 39);
        fieldIndexMap.put(FIELD_SERVICEPARAM, 40);
        fieldIndexMap.put(FIELD_SERVICEPARAM2, 41);
        fieldIndexMap.put(FIELD_SERVICEPATH, 42);
        fieldIndexMap.put(FIELD_SUBSYSSERVICECODENAME, 43);
        fieldIndexMap.put(FIELD_UPDATEDATE, 44);
        fieldIndexMap.put(FIELD_UPDATEMAN, 45);
        fieldIndexMap.put(FIELD_USERCAT, 46);
        fieldIndexMap.put(FIELD_USERTAG, 47);
        fieldIndexMap.put(FIELD_USERTAG2, 48);
        fieldIndexMap.put(FIELD_USERTAG3, 49);
        fieldIndexMap.put(FIELD_USERTAG4, 50);
    }
}

