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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNode;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDeployService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnMSDepAPIBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepAPIBase.class);
    public static final String FIELD_APIMODE = "APIMODE";
    public static final String FIELD_APITAG = "APITAG";
    public static final String FIELD_APITAG2 = "APITAG2";
    public static final String FIELD_AUTHCHECKTOKENURI = "AUTHCHECKTOKENURI";
    public static final String FIELD_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String FIELD_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String FIELD_AUTHMODE = "AUTHMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEPLOYSTATE = "DEPLOYSTATE";
    public static final String FIELD_DEPLOYTAG = "DEPLOYTAG";
    public static final String FIELD_DEPLOYTAG2 = "DEPLOYTAG2";
    public static final String FIELD_DEPLOYTAG3 = "DEPLOYTAG3";
    public static final String FIELD_DEPLOYTAG4 = "DEPLOYTAG4";
    public static final String FIELD_HTTPADDRESS = "HTTPADDRESS";
    public static final String FIELD_HTTPPORT = "HTTPPORT";
    public static final String FIELD_HTTPSPORT = "HTTPSPORT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NODEIPADDR = "NODEIPADDR";
    public static final String FIELD_NODEPORT = "NODEPORT";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDCMSPLATFORMID = "PSDCMSPLATFORMID";
    public static final String FIELD_PSDCMSPLATFORMNODEID = "PSDCMSPLATFORMNODEID";
    public static final String FIELD_PSDCMSPLATFORMNODENAME = "PSDCMSPLATFORMNODENAME";
    public static final String FIELD_PSDCREGISTRYITEMID = "PSDCREGISTRYITEMID";
    public static final String FIELD_PSDCREGISTRYITEMNAME = "PSDCREGISTRYITEMNAME";
    public static final String FIELD_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String FIELD_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNMSDEPAPIID = "PSDEVSLNMSDEPAPIID";
    public static final String FIELD_PSDEVSLNMSDEPAPINAME = "PSDEVSLNMSDEPAPINAME";
    public static final String FIELD_PSDEVSLNMSDEPLOYID = "PSDEVSLNMSDEPLOYID";
    public static final String FIELD_PSDEVSLNMSDEPLOYNAME = "PSDEVSLNMSDEPLOYNAME";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNPIPELINEID = "PSDEVSLNPIPELINEID";
    public static final String FIELD_PSDEVSLNPIPELINENAME = "PSDEVSLNPIPELINENAME";
    public static final String FIELD_PSDEVSLNSYSAPIID = "PSDEVSLNSYSAPIID";
    public static final String FIELD_PSDEVSLNSYSAPINAME = "PSDEVSLNSYSAPINAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_APIMODE = 0;
    private static final int INDEX_APITAG = 1;
    private static final int INDEX_APITAG2 = 2;
    private static final int INDEX_AUTHCHECKTOKENURI = 3;
    private static final int INDEX_AUTHCLIENTID = 4;
    private static final int INDEX_AUTHCLIENTSECRET = 5;
    private static final int INDEX_AUTHMODE = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_DEPLOYSTATE = 9;
    private static final int INDEX_DEPLOYTAG = 10;
    private static final int INDEX_DEPLOYTAG2 = 11;
    private static final int INDEX_DEPLOYTAG3 = 12;
    private static final int INDEX_DEPLOYTAG4 = 13;
    private static final int INDEX_HTTPADDRESS = 14;
    private static final int INDEX_HTTPPORT = 15;
    private static final int INDEX_HTTPSPORT = 16;
    private static final int INDEX_MEMO = 17;
    private static final int INDEX_NODEIPADDR = 18;
    private static final int INDEX_NODEPORT = 19;
    private static final int INDEX_ORDERVALUE = 20;
    private static final int INDEX_PSDCMSPLATFORMID = 21;
    private static final int INDEX_PSDCMSPLATFORMNODEID = 22;
    private static final int INDEX_PSDCMSPLATFORMNODENAME = 23;
    private static final int INDEX_PSDCREGISTRYITEMID = 24;
    private static final int INDEX_PSDCREGISTRYITEMNAME = 25;
    private static final int INDEX_PSDEVCENTERDBINSTID = 26;
    private static final int INDEX_PSDEVCENTERDBINSTNAME = 27;
    private static final int INDEX_PSDEVSLNID = 28;
    private static final int INDEX_PSDEVSLNMSDEPAPIID = 29;
    private static final int INDEX_PSDEVSLNMSDEPAPINAME = 30;
    private static final int INDEX_PSDEVSLNMSDEPLOYID = 31;
    private static final int INDEX_PSDEVSLNMSDEPLOYNAME = 32;
    private static final int INDEX_PSDEVSLNNAME = 33;
    private static final int INDEX_PSDEVSLNPIPELINEID = 34;
    private static final int INDEX_PSDEVSLNPIPELINENAME = 35;
    private static final int INDEX_PSDEVSLNSYSAPIID = 36;
    private static final int INDEX_PSDEVSLNSYSAPINAME = 37;
    private static final int INDEX_PSDEVSLNSYSID = 38;
    private static final int INDEX_PSDEVSLNSYSNAME = 39;
    private static final int INDEX_PSSYSSERVICEAPIID = 40;
    private static final int INDEX_UPDATEDATE = 41;
    private static final int INDEX_UPDATEMAN = 42;
    private static final int INDEX_USERPARAMS = 43;
    private static final int INDEX_VALIDFLAG = 44;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnMSDepAPIBase proxyPSDevSlnMSDepAPIBase = null;
    private boolean apimodeDirtyFlag = false;
    private boolean apitagDirtyFlag = false;
    private boolean apitag2DirtyFlag = false;
    private boolean authchecktokenuriDirtyFlag = false;
    private boolean authclientidDirtyFlag = false;
    private boolean authclientsecretDirtyFlag = false;
    private boolean authmodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deploystateDirtyFlag = false;
    private boolean deploytagDirtyFlag = false;
    private boolean deploytag2DirtyFlag = false;
    private boolean deploytag3DirtyFlag = false;
    private boolean deploytag4DirtyFlag = false;
    private boolean httpaddressDirtyFlag = false;
    private boolean httpportDirtyFlag = false;
    private boolean httpsportDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean nodeipaddrDirtyFlag = false;
    private boolean nodeportDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdcmsplatformidDirtyFlag = false;
    private boolean psdcmsplatformnodeidDirtyFlag = false;
    private boolean psdcmsplatformnodenameDirtyFlag = false;
    private boolean psdcregistryitemidDirtyFlag = false;
    private boolean psdcregistryitemnameDirtyFlag = false;
    private boolean psdevcenterdbinstidDirtyFlag = false;
    private boolean psdevcenterdbinstnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnmsdepapiidDirtyFlag = false;
    private boolean psdevslnmsdepapinameDirtyFlag = false;
    private boolean psdevslnmsdeployidDirtyFlag = false;
    private boolean psdevslnmsdeploynameDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnpipelineidDirtyFlag = false;
    private boolean psdevslnpipelinenameDirtyFlag = false;
    private boolean psdevslnsysapiidDirtyFlag = false;
    private boolean psdevslnsysapinameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="apimode")
    private Integer apimode;
    @Column(name="apitag")
    private String apitag;
    @Column(name="apitag2")
    private String apitag2;
    @Column(name="authchecktokenuri")
    private String authchecktokenuri;
    @Column(name="authclientid")
    private String authclientid;
    @Column(name="authclientsecret")
    private String authclientsecret;
    @Column(name="authmode")
    private String authmode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deploystate")
    private Integer deploystate;
    @Column(name="deploytag")
    private String deploytag;
    @Column(name="deploytag2")
    private String deploytag2;
    @Column(name="deploytag3")
    private String deploytag3;
    @Column(name="deploytag4")
    private String deploytag4;
    @Column(name="httpaddress")
    private String httpaddress;
    @Column(name="httpport")
    private Integer httpport;
    @Column(name="httpsport")
    private Integer httpsport;
    @Column(name="memo")
    private String memo;
    @Column(name="nodeipaddr")
    private String nodeipaddr;
    @Column(name="nodeport")
    private Integer nodeport;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdcmsplatformid")
    private String psdcmsplatformid;
    @Column(name="psdcmsplatformnodeid")
    private String psdcmsplatformnodeid;
    @Column(name="psdcmsplatformnodename")
    private String psdcmsplatformnodename;
    @Column(name="psdcregistryitemid")
    private String psdcregistryitemid;
    @Column(name="psdcregistryitemname")
    private String psdcregistryitemname;
    @Column(name="psdevcenterdbinstid")
    private String psdevcenterdbinstid;
    @Column(name="psdevcenterdbinstname")
    private String psdevcenterdbinstname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnmsdepapiid")
    private String psdevslnmsdepapiid;
    @Column(name="psdevslnmsdepapiname")
    private String psdevslnmsdepapiname;
    @Column(name="psdevslnmsdeployid")
    private String psdevslnmsdeployid;
    @Column(name="psdevslnmsdeployname")
    private String psdevslnmsdeployname;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnpipelineid")
    private String psdevslnpipelineid;
    @Column(name="psdevslnpipelinename")
    private String psdevslnpipelinename;
    @Column(name="psdevslnsysapiid")
    private String psdevslnsysapiid;
    @Column(name="psdevslnsysapiname")
    private String psdevslnsysapiname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="pssysserviceapiid")
    private String pssysserviceapiid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDCMSPlatformNodeLock = new Integer(1);
    private PSDCMSPlatformNode psdcmsplatformnode = null;
    private Integer objPSDevCenterDBInstLock = new Integer(1);
    private PSDevCenterDBInst psdevcenterdbinst = null;
    private Integer objPSDevSlnMSDeployLock = new Integer(1);
    private PSDevSlnMSDeploy psdevslnmsdeploy = null;
    private Integer objPSDevSlnPipelineLock = new Integer(1);
    private PSDevSlnPipeline psdevslnpipeline = null;
    private Integer objPSDevSlnSysAPILock = new Integer(1);
    private PSDevSlnSysAPI psdevslnsysapi = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

    public void setAPIMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIMode(n);
            return;
        }
        this.apimode = n;
        this.apimodeDirtyFlag = true;
    }

    public Integer getAPIMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIMode();
        }
        return this.apimode;
    }

    public boolean isAPIModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPIModeDirty();
        }
        return this.apimodeDirtyFlag;
    }

    public void resetAPIMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIMode();
            return;
        }
        this.apimodeDirtyFlag = false;
        this.apimode = null;
    }

    public void setAPITag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPITag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apitag = string;
        this.apitagDirtyFlag = true;
    }

    public String getAPITag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPITag();
        }
        return this.apitag;
    }

    public boolean isAPITagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPITagDirty();
        }
        return this.apitagDirtyFlag;
    }

    public void resetAPITag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPITag();
            return;
        }
        this.apitagDirtyFlag = false;
        this.apitag = null;
    }

    public void setAPITag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPITag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apitag2 = string;
        this.apitag2DirtyFlag = true;
    }

    public String getAPITag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPITag2();
        }
        return this.apitag2;
    }

    public boolean isAPITag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPITag2Dirty();
        }
        return this.apitag2DirtyFlag;
    }

    public void resetAPITag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPITag2();
            return;
        }
        this.apitag2DirtyFlag = false;
        this.apitag2 = null;
    }

    public void setAuthCheckTokenUri(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuthCheckTokenUri(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.authchecktokenuri = string;
        this.authchecktokenuriDirtyFlag = true;
    }

    public String getAuthCheckTokenUri() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuthCheckTokenUri();
        }
        return this.authchecktokenuri;
    }

    public boolean isAuthCheckTokenUriDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuthCheckTokenUriDirty();
        }
        return this.authchecktokenuriDirtyFlag;
    }

    public void resetAuthCheckTokenUri() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuthCheckTokenUri();
            return;
        }
        this.authchecktokenuriDirtyFlag = false;
        this.authchecktokenuri = null;
    }

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

    public void setDeployState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeployState(n);
            return;
        }
        this.deploystate = n;
        this.deploystateDirtyFlag = true;
    }

    public Integer getDeployState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeployState();
        }
        return this.deploystate;
    }

    public boolean isDeployStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeployStateDirty();
        }
        return this.deploystateDirtyFlag;
    }

    public void resetDeployState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeployState();
            return;
        }
        this.deploystateDirtyFlag = false;
        this.deploystate = null;
    }

    public void setDeployTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeployTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploytag = string;
        this.deploytagDirtyFlag = true;
    }

    public String getDeployTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeployTag();
        }
        return this.deploytag;
    }

    public boolean isDeployTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeployTagDirty();
        }
        return this.deploytagDirtyFlag;
    }

    public void resetDeployTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeployTag();
            return;
        }
        this.deploytagDirtyFlag = false;
        this.deploytag = null;
    }

    public void setDeployTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeployTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploytag2 = string;
        this.deploytag2DirtyFlag = true;
    }

    public String getDeployTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeployTag2();
        }
        return this.deploytag2;
    }

    public boolean isDeployTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeployTag2Dirty();
        }
        return this.deploytag2DirtyFlag;
    }

    public void resetDeployTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeployTag2();
            return;
        }
        this.deploytag2DirtyFlag = false;
        this.deploytag2 = null;
    }

    public void setDeployTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeployTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploytag3 = string;
        this.deploytag3DirtyFlag = true;
    }

    public String getDeployTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeployTag3();
        }
        return this.deploytag3;
    }

    public boolean isDeployTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeployTag3Dirty();
        }
        return this.deploytag3DirtyFlag;
    }

    public void resetDeployTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeployTag3();
            return;
        }
        this.deploytag3DirtyFlag = false;
        this.deploytag3 = null;
    }

    public void setDeployTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeployTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deploytag4 = string;
        this.deploytag4DirtyFlag = true;
    }

    public String getDeployTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeployTag4();
        }
        return this.deploytag4;
    }

    public boolean isDeployTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeployTag4Dirty();
        }
        return this.deploytag4DirtyFlag;
    }

    public void resetDeployTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeployTag4();
            return;
        }
        this.deploytag4DirtyFlag = false;
        this.deploytag4 = null;
    }

    public void setHttpAddress(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpAddress(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.httpaddress = string;
        this.httpaddressDirtyFlag = true;
    }

    public String getHttpAddress() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpAddress();
        }
        return this.httpaddress;
    }

    public boolean isHttpAddressDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpAddressDirty();
        }
        return this.httpaddressDirtyFlag;
    }

    public void resetHttpAddress() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpAddress();
            return;
        }
        this.httpaddressDirtyFlag = false;
        this.httpaddress = null;
    }

    public void setHttpPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpPort(n);
            return;
        }
        this.httpport = n;
        this.httpportDirtyFlag = true;
    }

    public Integer getHttpPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpPort();
        }
        return this.httpport;
    }

    public boolean isHttpPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpPortDirty();
        }
        return this.httpportDirtyFlag;
    }

    public void resetHttpPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpPort();
            return;
        }
        this.httpportDirtyFlag = false;
        this.httpport = null;
    }

    public void setHttpsPort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHttpsPort(n);
            return;
        }
        this.httpsport = n;
        this.httpsportDirtyFlag = true;
    }

    public Integer getHttpsPort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHttpsPort();
        }
        return this.httpsport;
    }

    public boolean isHttpsPortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHttpsPortDirty();
        }
        return this.httpsportDirtyFlag;
    }

    public void resetHttpsPort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHttpsPort();
            return;
        }
        this.httpsportDirtyFlag = false;
        this.httpsport = null;
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

    public void setNodeIPAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeIPAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodeipaddr = string;
        this.nodeipaddrDirtyFlag = true;
    }

    public String getNodeIPAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeIPAddr();
        }
        return this.nodeipaddr;
    }

    public boolean isNodeIPAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeIPAddrDirty();
        }
        return this.nodeipaddrDirtyFlag;
    }

    public void resetNodeIPAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeIPAddr();
            return;
        }
        this.nodeipaddrDirtyFlag = false;
        this.nodeipaddr = null;
    }

    public void setNodePort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodePort(n);
            return;
        }
        this.nodeport = n;
        this.nodeportDirtyFlag = true;
    }

    public Integer getNodePort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodePort();
        }
        return this.nodeport;
    }

    public boolean isNodePortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodePortDirty();
        }
        return this.nodeportDirtyFlag;
    }

    public void resetNodePort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodePort();
            return;
        }
        this.nodeportDirtyFlag = false;
        this.nodeport = null;
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

    public void setPSDCMSPlatformId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformid = string;
        this.psdcmsplatformidDirtyFlag = true;
    }

    public String getPSDCMSPlatformId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformId();
        }
        return this.psdcmsplatformid;
    }

    public boolean isPSDCMSPlatformIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformIdDirty();
        }
        return this.psdcmsplatformidDirtyFlag;
    }

    public void resetPSDCMSPlatformId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformId();
            return;
        }
        this.psdcmsplatformidDirtyFlag = false;
        this.psdcmsplatformid = null;
    }

    public void setPSDCMSPlatformNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformnodeid = string;
        this.psdcmsplatformnodeidDirtyFlag = true;
    }

    public String getPSDCMSPlatformNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformNodeId();
        }
        return this.psdcmsplatformnodeid;
    }

    public boolean isPSDCMSPlatformNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformNodeIdDirty();
        }
        return this.psdcmsplatformnodeidDirtyFlag;
    }

    public void resetPSDCMSPlatformNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformNodeId();
            return;
        }
        this.psdcmsplatformnodeidDirtyFlag = false;
        this.psdcmsplatformnodeid = null;
    }

    public void setPSDCMSPlatformNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMSPlatformNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsplatformnodename = string;
        this.psdcmsplatformnodenameDirtyFlag = true;
    }

    public String getPSDCMSPlatformNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformNodeName();
        }
        return this.psdcmsplatformnodename;
    }

    public boolean isPSDCMSPlatformNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMSPlatformNodeNameDirty();
        }
        return this.psdcmsplatformnodenameDirtyFlag;
    }

    public void resetPSDCMSPlatformNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMSPlatformNodeName();
            return;
        }
        this.psdcmsplatformnodenameDirtyFlag = false;
        this.psdcmsplatformnodename = null;
    }

    public void setPSDCRegistryItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryitemid = string;
        this.psdcregistryitemidDirtyFlag = true;
    }

    public String getPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryItemId();
        }
        return this.psdcregistryitemid;
    }

    public boolean isPSDCRegistryItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryItemIdDirty();
        }
        return this.psdcregistryitemidDirtyFlag;
    }

    public void resetPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryItemId();
            return;
        }
        this.psdcregistryitemidDirtyFlag = false;
        this.psdcregistryitemid = null;
    }

    public void setPSDCRegistryItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRegistryItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcregistryitemname = string;
        this.psdcregistryitemnameDirtyFlag = true;
    }

    public String getPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRegistryItemName();
        }
        return this.psdcregistryitemname;
    }

    public boolean isPSDCRegistryItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRegistryItemNameDirty();
        }
        return this.psdcregistryitemnameDirtyFlag;
    }

    public void resetPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRegistryItemName();
            return;
        }
        this.psdcregistryitemnameDirtyFlag = false;
        this.psdcregistryitemname = null;
    }

    public void setPSDevCenterDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstid = string;
        this.psdevcenterdbinstidDirtyFlag = true;
    }

    public String getPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstId();
        }
        return this.psdevcenterdbinstid;
    }

    public boolean isPSDevCenterDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstIdDirty();
        }
        return this.psdevcenterdbinstidDirtyFlag;
    }

    public void resetPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstId();
            return;
        }
        this.psdevcenterdbinstidDirtyFlag = false;
        this.psdevcenterdbinstid = null;
    }

    public void setPSDevCenterDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstname = string;
        this.psdevcenterdbinstnameDirtyFlag = true;
    }

    public String getPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstName();
        }
        return this.psdevcenterdbinstname;
    }

    public boolean isPSDevCenterDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstNameDirty();
        }
        return this.psdevcenterdbinstnameDirtyFlag;
    }

    public void resetPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstName();
            return;
        }
        this.psdevcenterdbinstnameDirtyFlag = false;
        this.psdevcenterdbinstname = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnMSDepAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepapiid = string;
        this.psdevslnmsdepapiidDirtyFlag = true;
    }

    public String getPSDevSlnMSDepAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAPIId();
        }
        return this.psdevslnmsdepapiid;
    }

    public boolean isPSDevSlnMSDepAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepAPIIdDirty();
        }
        return this.psdevslnmsdepapiidDirtyFlag;
    }

    public void resetPSDevSlnMSDepAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepAPIId();
            return;
        }
        this.psdevslnmsdepapiidDirtyFlag = false;
        this.psdevslnmsdepapiid = null;
    }

    public void setPSDevSlnMSDepAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDepAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdepapiname = string;
        this.psdevslnmsdepapinameDirtyFlag = true;
    }

    public String getPSDevSlnMSDepAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDepAPIName();
        }
        return this.psdevslnmsdepapiname;
    }

    public boolean isPSDevSlnMSDepAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDepAPINameDirty();
        }
        return this.psdevslnmsdepapinameDirtyFlag;
    }

    public void resetPSDevSlnMSDepAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDepAPIName();
            return;
        }
        this.psdevslnmsdepapinameDirtyFlag = false;
        this.psdevslnmsdepapiname = null;
    }

    public void setPSDevSlnMSDeployId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDeployId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdeployid = string;
        this.psdevslnmsdeployidDirtyFlag = true;
    }

    public String getPSDevSlnMSDeployId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeployId();
        }
        return this.psdevslnmsdeployid;
    }

    public boolean isPSDevSlnMSDeployIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDeployIdDirty();
        }
        return this.psdevslnmsdeployidDirtyFlag;
    }

    public void resetPSDevSlnMSDeployId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDeployId();
            return;
        }
        this.psdevslnmsdeployidDirtyFlag = false;
        this.psdevslnmsdeployid = null;
    }

    public void setPSDevSlnMSDeployName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnMSDeployName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnmsdeployname = string;
        this.psdevslnmsdeploynameDirtyFlag = true;
    }

    public String getPSDevSlnMSDeployName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeployName();
        }
        return this.psdevslnmsdeployname;
    }

    public boolean isPSDevSlnMSDeployNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnMSDeployNameDirty();
        }
        return this.psdevslnmsdeploynameDirtyFlag;
    }

    public void resetPSDevSlnMSDeployName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnMSDeployName();
            return;
        }
        this.psdevslnmsdeploynameDirtyFlag = false;
        this.psdevslnmsdeployname = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setPSDevSlnPipelineId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelineid = string;
        this.psdevslnpipelineidDirtyFlag = true;
    }

    public String getPSDevSlnPipelineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineId();
        }
        return this.psdevslnpipelineid;
    }

    public boolean isPSDevSlnPipelineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineIdDirty();
        }
        return this.psdevslnpipelineidDirtyFlag;
    }

    public void resetPSDevSlnPipelineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineId();
            return;
        }
        this.psdevslnpipelineidDirtyFlag = false;
        this.psdevslnpipelineid = null;
    }

    public void setPSDevSlnPipelineName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinename = string;
        this.psdevslnpipelinenameDirtyFlag = true;
    }

    public String getPSDevSlnPipelineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineName();
        }
        return this.psdevslnpipelinename;
    }

    public boolean isPSDevSlnPipelineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineNameDirty();
        }
        return this.psdevslnpipelinenameDirtyFlag;
    }

    public void resetPSDevSlnPipelineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineName();
            return;
        }
        this.psdevslnpipelinenameDirtyFlag = false;
        this.psdevslnpipelinename = null;
    }

    public void setPSDevSlnSysAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysapiid = string;
        this.psdevslnsysapiidDirtyFlag = true;
    }

    public String getPSDevSlnSysAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAPIId();
        }
        return this.psdevslnsysapiid;
    }

    public boolean isPSDevSlnSysAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAPIIdDirty();
        }
        return this.psdevslnsysapiidDirtyFlag;
    }

    public void resetPSDevSlnSysAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAPIId();
            return;
        }
        this.psdevslnsysapiidDirtyFlag = false;
        this.psdevslnsysapiid = null;
    }

    public void setPSDevSlnSysAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysapiname = string;
        this.psdevslnsysapinameDirtyFlag = true;
    }

    public String getPSDevSlnSysAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAPIName();
        }
        return this.psdevslnsysapiname;
    }

    public boolean isPSDevSlnSysAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysAPINameDirty();
        }
        return this.psdevslnsysapinameDirtyFlag;
    }

    public void resetPSDevSlnSysAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysAPIName();
            return;
        }
        this.psdevslnsysapinameDirtyFlag = false;
        this.psdevslnsysapiname = null;
    }

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
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
        PSDevSlnMSDepAPIBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnMSDepAPIBase pSDevSlnMSDepAPIBase) {
        pSDevSlnMSDepAPIBase.resetAPIMode();
        pSDevSlnMSDepAPIBase.resetAPITag();
        pSDevSlnMSDepAPIBase.resetAPITag2();
        pSDevSlnMSDepAPIBase.resetAuthCheckTokenUri();
        pSDevSlnMSDepAPIBase.resetAuthClientId();
        pSDevSlnMSDepAPIBase.resetAuthClientSecret();
        pSDevSlnMSDepAPIBase.resetAuthMode();
        pSDevSlnMSDepAPIBase.resetCreateDate();
        pSDevSlnMSDepAPIBase.resetCreateMan();
        pSDevSlnMSDepAPIBase.resetDeployState();
        pSDevSlnMSDepAPIBase.resetDeployTag();
        pSDevSlnMSDepAPIBase.resetDeployTag2();
        pSDevSlnMSDepAPIBase.resetDeployTag3();
        pSDevSlnMSDepAPIBase.resetDeployTag4();
        pSDevSlnMSDepAPIBase.resetHttpAddress();
        pSDevSlnMSDepAPIBase.resetHttpPort();
        pSDevSlnMSDepAPIBase.resetHttpsPort();
        pSDevSlnMSDepAPIBase.resetMemo();
        pSDevSlnMSDepAPIBase.resetNodeIPAddr();
        pSDevSlnMSDepAPIBase.resetNodePort();
        pSDevSlnMSDepAPIBase.resetOrderValue();
        pSDevSlnMSDepAPIBase.resetPSDCMSPlatformId();
        pSDevSlnMSDepAPIBase.resetPSDCMSPlatformNodeId();
        pSDevSlnMSDepAPIBase.resetPSDCMSPlatformNodeName();
        pSDevSlnMSDepAPIBase.resetPSDCRegistryItemId();
        pSDevSlnMSDepAPIBase.resetPSDCRegistryItemName();
        pSDevSlnMSDepAPIBase.resetPSDevCenterDBInstId();
        pSDevSlnMSDepAPIBase.resetPSDevCenterDBInstName();
        pSDevSlnMSDepAPIBase.resetPSDevSlnId();
        pSDevSlnMSDepAPIBase.resetPSDevSlnMSDepAPIId();
        pSDevSlnMSDepAPIBase.resetPSDevSlnMSDepAPIName();
        pSDevSlnMSDepAPIBase.resetPSDevSlnMSDeployId();
        pSDevSlnMSDepAPIBase.resetPSDevSlnMSDeployName();
        pSDevSlnMSDepAPIBase.resetPSDevSlnName();
        pSDevSlnMSDepAPIBase.resetPSDevSlnPipelineId();
        pSDevSlnMSDepAPIBase.resetPSDevSlnPipelineName();
        pSDevSlnMSDepAPIBase.resetPSDevSlnSysAPIId();
        pSDevSlnMSDepAPIBase.resetPSDevSlnSysAPIName();
        pSDevSlnMSDepAPIBase.resetPSDevSlnSysId();
        pSDevSlnMSDepAPIBase.resetPSDevSlnSysName();
        pSDevSlnMSDepAPIBase.resetPSSysServiceAPIId();
        pSDevSlnMSDepAPIBase.resetUpdateDate();
        pSDevSlnMSDepAPIBase.resetUpdateMan();
        pSDevSlnMSDepAPIBase.resetUserParams();
        pSDevSlnMSDepAPIBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAPIModeDirty()) {
            hashMap.put(FIELD_APIMODE, this.getAPIMode());
        }
        if (!bl || this.isAPITagDirty()) {
            hashMap.put(FIELD_APITAG, this.getAPITag());
        }
        if (!bl || this.isAPITag2Dirty()) {
            hashMap.put(FIELD_APITAG2, this.getAPITag2());
        }
        if (!bl || this.isAuthCheckTokenUriDirty()) {
            hashMap.put(FIELD_AUTHCHECKTOKENURI, this.getAuthCheckTokenUri());
        }
        if (!bl || this.isAuthClientIdDirty()) {
            hashMap.put(FIELD_AUTHCLIENTID, this.getAuthClientId());
        }
        if (!bl || this.isAuthClientSecretDirty()) {
            hashMap.put(FIELD_AUTHCLIENTSECRET, this.getAuthClientSecret());
        }
        if (!bl || this.isAuthModeDirty()) {
            hashMap.put(FIELD_AUTHMODE, this.getAuthMode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDeployStateDirty()) {
            hashMap.put(FIELD_DEPLOYSTATE, this.getDeployState());
        }
        if (!bl || this.isDeployTagDirty()) {
            hashMap.put(FIELD_DEPLOYTAG, this.getDeployTag());
        }
        if (!bl || this.isDeployTag2Dirty()) {
            hashMap.put(FIELD_DEPLOYTAG2, this.getDeployTag2());
        }
        if (!bl || this.isDeployTag3Dirty()) {
            hashMap.put(FIELD_DEPLOYTAG3, this.getDeployTag3());
        }
        if (!bl || this.isDeployTag4Dirty()) {
            hashMap.put(FIELD_DEPLOYTAG4, this.getDeployTag4());
        }
        if (!bl || this.isHttpAddressDirty()) {
            hashMap.put(FIELD_HTTPADDRESS, this.getHttpAddress());
        }
        if (!bl || this.isHttpPortDirty()) {
            hashMap.put(FIELD_HTTPPORT, this.getHttpPort());
        }
        if (!bl || this.isHttpsPortDirty()) {
            hashMap.put(FIELD_HTTPSPORT, this.getHttpsPort());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNodeIPAddrDirty()) {
            hashMap.put(FIELD_NODEIPADDR, this.getNodeIPAddr());
        }
        if (!bl || this.isNodePortDirty()) {
            hashMap.put(FIELD_NODEPORT, this.getNodePort());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDCMSPlatformIdDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMID, this.getPSDCMSPlatformId());
        }
        if (!bl || this.isPSDCMSPlatformNodeIdDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMNODEID, this.getPSDCMSPlatformNodeId());
        }
        if (!bl || this.isPSDCMSPlatformNodeNameDirty()) {
            hashMap.put(FIELD_PSDCMSPLATFORMNODENAME, this.getPSDCMSPlatformNodeName());
        }
        if (!bl || this.isPSDCRegistryItemIdDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYITEMID, this.getPSDCRegistryItemId());
        }
        if (!bl || this.isPSDCRegistryItemNameDirty()) {
            hashMap.put(FIELD_PSDCREGISTRYITEMNAME, this.getPSDCRegistryItemName());
        }
        if (!bl || this.isPSDevCenterDBInstIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTID, this.getPSDevCenterDBInstId());
        }
        if (!bl || this.isPSDevCenterDBInstNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTNAME, this.getPSDevCenterDBInstName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnMSDepAPIIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPAPIID, this.getPSDevSlnMSDepAPIId());
        }
        if (!bl || this.isPSDevSlnMSDepAPINameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPAPINAME, this.getPSDevSlnMSDepAPIName());
        }
        if (!bl || this.isPSDevSlnMSDeployIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPLOYID, this.getPSDevSlnMSDeployId());
        }
        if (!bl || this.isPSDevSlnMSDeployNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNMSDEPLOYNAME, this.getPSDevSlnMSDeployName());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnPipelineIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINEID, this.getPSDevSlnPipelineId());
        }
        if (!bl || this.isPSDevSlnPipelineNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINENAME, this.getPSDevSlnPipelineName());
        }
        if (!bl || this.isPSDevSlnSysAPIIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPIID, this.getPSDevSlnSysAPIId());
        }
        if (!bl || this.isPSDevSlnSysAPINameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSAPINAME, this.getPSDevSlnSysAPIName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPIID, this.getPSSysServiceAPIId());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSDevSlnMSDepAPIBase.get(this, n);
    }

    private static Object get(PSDevSlnMSDepAPIBase pSDevSlnMSDepAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDepAPIBase.getAPIMode();
            }
            case 1: {
                return pSDevSlnMSDepAPIBase.getAPITag();
            }
            case 2: {
                return pSDevSlnMSDepAPIBase.getAPITag2();
            }
            case 3: {
                return pSDevSlnMSDepAPIBase.getAuthCheckTokenUri();
            }
            case 4: {
                return pSDevSlnMSDepAPIBase.getAuthClientId();
            }
            case 5: {
                return pSDevSlnMSDepAPIBase.getAuthClientSecret();
            }
            case 6: {
                return pSDevSlnMSDepAPIBase.getAuthMode();
            }
            case 7: {
                return pSDevSlnMSDepAPIBase.getCreateDate();
            }
            case 8: {
                return pSDevSlnMSDepAPIBase.getCreateMan();
            }
            case 9: {
                return pSDevSlnMSDepAPIBase.getDeployState();
            }
            case 10: {
                return pSDevSlnMSDepAPIBase.getDeployTag();
            }
            case 11: {
                return pSDevSlnMSDepAPIBase.getDeployTag2();
            }
            case 12: {
                return pSDevSlnMSDepAPIBase.getDeployTag3();
            }
            case 13: {
                return pSDevSlnMSDepAPIBase.getDeployTag4();
            }
            case 14: {
                return pSDevSlnMSDepAPIBase.getHttpAddress();
            }
            case 15: {
                return pSDevSlnMSDepAPIBase.getHttpPort();
            }
            case 16: {
                return pSDevSlnMSDepAPIBase.getHttpsPort();
            }
            case 17: {
                return pSDevSlnMSDepAPIBase.getMemo();
            }
            case 18: {
                return pSDevSlnMSDepAPIBase.getNodeIPAddr();
            }
            case 19: {
                return pSDevSlnMSDepAPIBase.getNodePort();
            }
            case 20: {
                return pSDevSlnMSDepAPIBase.getOrderValue();
            }
            case 21: {
                return pSDevSlnMSDepAPIBase.getPSDCMSPlatformId();
            }
            case 22: {
                return pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeId();
            }
            case 23: {
                return pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeName();
            }
            case 24: {
                return pSDevSlnMSDepAPIBase.getPSDCRegistryItemId();
            }
            case 25: {
                return pSDevSlnMSDepAPIBase.getPSDCRegistryItemName();
            }
            case 26: {
                return pSDevSlnMSDepAPIBase.getPSDevCenterDBInstId();
            }
            case 27: {
                return pSDevSlnMSDepAPIBase.getPSDevCenterDBInstName();
            }
            case 28: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnId();
            }
            case 29: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIId();
            }
            case 30: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIName();
            }
            case 31: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployId();
            }
            case 32: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployName();
            }
            case 33: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnName();
            }
            case 34: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnPipelineId();
            }
            case 35: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnPipelineName();
            }
            case 36: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIId();
            }
            case 37: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIName();
            }
            case 38: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnSysId();
            }
            case 39: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnSysName();
            }
            case 40: {
                return pSDevSlnMSDepAPIBase.getPSSysServiceAPIId();
            }
            case 41: {
                return pSDevSlnMSDepAPIBase.getUpdateDate();
            }
            case 42: {
                return pSDevSlnMSDepAPIBase.getUpdateMan();
            }
            case 43: {
                return pSDevSlnMSDepAPIBase.getUserParams();
            }
            case 44: {
                return pSDevSlnMSDepAPIBase.getValidFlag();
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
        PSDevSlnMSDepAPIBase.set(this, n, object);
    }

    private static void set(PSDevSlnMSDepAPIBase pSDevSlnMSDepAPIBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnMSDepAPIBase.setAPIMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnMSDepAPIBase.setAPITag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnMSDepAPIBase.setAPITag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnMSDepAPIBase.setAuthCheckTokenUri(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnMSDepAPIBase.setAuthClientId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnMSDepAPIBase.setAuthClientSecret(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnMSDepAPIBase.setAuthMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnMSDepAPIBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnMSDepAPIBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnMSDepAPIBase.setDeployState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnMSDepAPIBase.setDeployTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnMSDepAPIBase.setDeployTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnMSDepAPIBase.setDeployTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnMSDepAPIBase.setDeployTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnMSDepAPIBase.setHttpAddress(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnMSDepAPIBase.setHttpPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnMSDepAPIBase.setHttpsPort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnMSDepAPIBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnMSDepAPIBase.setNodeIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnMSDepAPIBase.setNodePort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnMSDepAPIBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnMSDepAPIBase.setPSDCMSPlatformId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnMSDepAPIBase.setPSDCMSPlatformNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnMSDepAPIBase.setPSDCMSPlatformNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnMSDepAPIBase.setPSDCRegistryItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnMSDepAPIBase.setPSDCRegistryItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnMSDepAPIBase.setPSDevCenterDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnMSDepAPIBase.setPSDevCenterDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnMSDepAPIBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnMSDepAPIBase.setPSDevSlnMSDepAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevSlnMSDepAPIBase.setPSDevSlnMSDepAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevSlnMSDepAPIBase.setPSDevSlnMSDeployId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevSlnMSDepAPIBase.setPSDevSlnMSDeployName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevSlnMSDepAPIBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevSlnMSDepAPIBase.setPSDevSlnPipelineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDevSlnMSDepAPIBase.setPSDevSlnPipelineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDevSlnMSDepAPIBase.setPSDevSlnSysAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDevSlnMSDepAPIBase.setPSDevSlnSysAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDevSlnMSDepAPIBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDevSlnMSDepAPIBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDevSlnMSDepAPIBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDevSlnMSDepAPIBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 42: {
                pSDevSlnMSDepAPIBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDevSlnMSDepAPIBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDevSlnMSDepAPIBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnMSDepAPIBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnMSDepAPIBase pSDevSlnMSDepAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDepAPIBase.getAPIMode() == null;
            }
            case 1: {
                return pSDevSlnMSDepAPIBase.getAPITag() == null;
            }
            case 2: {
                return pSDevSlnMSDepAPIBase.getAPITag2() == null;
            }
            case 3: {
                return pSDevSlnMSDepAPIBase.getAuthCheckTokenUri() == null;
            }
            case 4: {
                return pSDevSlnMSDepAPIBase.getAuthClientId() == null;
            }
            case 5: {
                return pSDevSlnMSDepAPIBase.getAuthClientSecret() == null;
            }
            case 6: {
                return pSDevSlnMSDepAPIBase.getAuthMode() == null;
            }
            case 7: {
                return pSDevSlnMSDepAPIBase.getCreateDate() == null;
            }
            case 8: {
                return pSDevSlnMSDepAPIBase.getCreateMan() == null;
            }
            case 9: {
                return pSDevSlnMSDepAPIBase.getDeployState() == null;
            }
            case 10: {
                return pSDevSlnMSDepAPIBase.getDeployTag() == null;
            }
            case 11: {
                return pSDevSlnMSDepAPIBase.getDeployTag2() == null;
            }
            case 12: {
                return pSDevSlnMSDepAPIBase.getDeployTag3() == null;
            }
            case 13: {
                return pSDevSlnMSDepAPIBase.getDeployTag4() == null;
            }
            case 14: {
                return pSDevSlnMSDepAPIBase.getHttpAddress() == null;
            }
            case 15: {
                return pSDevSlnMSDepAPIBase.getHttpPort() == null;
            }
            case 16: {
                return pSDevSlnMSDepAPIBase.getHttpsPort() == null;
            }
            case 17: {
                return pSDevSlnMSDepAPIBase.getMemo() == null;
            }
            case 18: {
                return pSDevSlnMSDepAPIBase.getNodeIPAddr() == null;
            }
            case 19: {
                return pSDevSlnMSDepAPIBase.getNodePort() == null;
            }
            case 20: {
                return pSDevSlnMSDepAPIBase.getOrderValue() == null;
            }
            case 21: {
                return pSDevSlnMSDepAPIBase.getPSDCMSPlatformId() == null;
            }
            case 22: {
                return pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeId() == null;
            }
            case 23: {
                return pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeName() == null;
            }
            case 24: {
                return pSDevSlnMSDepAPIBase.getPSDCRegistryItemId() == null;
            }
            case 25: {
                return pSDevSlnMSDepAPIBase.getPSDCRegistryItemName() == null;
            }
            case 26: {
                return pSDevSlnMSDepAPIBase.getPSDevCenterDBInstId() == null;
            }
            case 27: {
                return pSDevSlnMSDepAPIBase.getPSDevCenterDBInstName() == null;
            }
            case 28: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnId() == null;
            }
            case 29: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIId() == null;
            }
            case 30: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIName() == null;
            }
            case 31: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployId() == null;
            }
            case 32: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployName() == null;
            }
            case 33: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnName() == null;
            }
            case 34: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnPipelineId() == null;
            }
            case 35: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnPipelineName() == null;
            }
            case 36: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIId() == null;
            }
            case 37: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIName() == null;
            }
            case 38: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnSysId() == null;
            }
            case 39: {
                return pSDevSlnMSDepAPIBase.getPSDevSlnSysName() == null;
            }
            case 40: {
                return pSDevSlnMSDepAPIBase.getPSSysServiceAPIId() == null;
            }
            case 41: {
                return pSDevSlnMSDepAPIBase.getUpdateDate() == null;
            }
            case 42: {
                return pSDevSlnMSDepAPIBase.getUpdateMan() == null;
            }
            case 43: {
                return pSDevSlnMSDepAPIBase.getUserParams() == null;
            }
            case 44: {
                return pSDevSlnMSDepAPIBase.getValidFlag() == null;
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
        return PSDevSlnMSDepAPIBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnMSDepAPIBase pSDevSlnMSDepAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnMSDepAPIBase.isAPIModeDirty();
            }
            case 1: {
                return pSDevSlnMSDepAPIBase.isAPITagDirty();
            }
            case 2: {
                return pSDevSlnMSDepAPIBase.isAPITag2Dirty();
            }
            case 3: {
                return pSDevSlnMSDepAPIBase.isAuthCheckTokenUriDirty();
            }
            case 4: {
                return pSDevSlnMSDepAPIBase.isAuthClientIdDirty();
            }
            case 5: {
                return pSDevSlnMSDepAPIBase.isAuthClientSecretDirty();
            }
            case 6: {
                return pSDevSlnMSDepAPIBase.isAuthModeDirty();
            }
            case 7: {
                return pSDevSlnMSDepAPIBase.isCreateDateDirty();
            }
            case 8: {
                return pSDevSlnMSDepAPIBase.isCreateManDirty();
            }
            case 9: {
                return pSDevSlnMSDepAPIBase.isDeployStateDirty();
            }
            case 10: {
                return pSDevSlnMSDepAPIBase.isDeployTagDirty();
            }
            case 11: {
                return pSDevSlnMSDepAPIBase.isDeployTag2Dirty();
            }
            case 12: {
                return pSDevSlnMSDepAPIBase.isDeployTag3Dirty();
            }
            case 13: {
                return pSDevSlnMSDepAPIBase.isDeployTag4Dirty();
            }
            case 14: {
                return pSDevSlnMSDepAPIBase.isHttpAddressDirty();
            }
            case 15: {
                return pSDevSlnMSDepAPIBase.isHttpPortDirty();
            }
            case 16: {
                return pSDevSlnMSDepAPIBase.isHttpsPortDirty();
            }
            case 17: {
                return pSDevSlnMSDepAPIBase.isMemoDirty();
            }
            case 18: {
                return pSDevSlnMSDepAPIBase.isNodeIPAddrDirty();
            }
            case 19: {
                return pSDevSlnMSDepAPIBase.isNodePortDirty();
            }
            case 20: {
                return pSDevSlnMSDepAPIBase.isOrderValueDirty();
            }
            case 21: {
                return pSDevSlnMSDepAPIBase.isPSDCMSPlatformIdDirty();
            }
            case 22: {
                return pSDevSlnMSDepAPIBase.isPSDCMSPlatformNodeIdDirty();
            }
            case 23: {
                return pSDevSlnMSDepAPIBase.isPSDCMSPlatformNodeNameDirty();
            }
            case 24: {
                return pSDevSlnMSDepAPIBase.isPSDCRegistryItemIdDirty();
            }
            case 25: {
                return pSDevSlnMSDepAPIBase.isPSDCRegistryItemNameDirty();
            }
            case 26: {
                return pSDevSlnMSDepAPIBase.isPSDevCenterDBInstIdDirty();
            }
            case 27: {
                return pSDevSlnMSDepAPIBase.isPSDevCenterDBInstNameDirty();
            }
            case 28: {
                return pSDevSlnMSDepAPIBase.isPSDevSlnIdDirty();
            }
            case 29: {
                return pSDevSlnMSDepAPIBase.isPSDevSlnMSDepAPIIdDirty();
            }
            case 30: {
                return pSDevSlnMSDepAPIBase.isPSDevSlnMSDepAPINameDirty();
            }
            case 31: {
                return pSDevSlnMSDepAPIBase.isPSDevSlnMSDeployIdDirty();
            }
            case 32: {
                return pSDevSlnMSDepAPIBase.isPSDevSlnMSDeployNameDirty();
            }
            case 33: {
                return pSDevSlnMSDepAPIBase.isPSDevSlnNameDirty();
            }
            case 34: {
                return pSDevSlnMSDepAPIBase.isPSDevSlnPipelineIdDirty();
            }
            case 35: {
                return pSDevSlnMSDepAPIBase.isPSDevSlnPipelineNameDirty();
            }
            case 36: {
                return pSDevSlnMSDepAPIBase.isPSDevSlnSysAPIIdDirty();
            }
            case 37: {
                return pSDevSlnMSDepAPIBase.isPSDevSlnSysAPINameDirty();
            }
            case 38: {
                return pSDevSlnMSDepAPIBase.isPSDevSlnSysIdDirty();
            }
            case 39: {
                return pSDevSlnMSDepAPIBase.isPSDevSlnSysNameDirty();
            }
            case 40: {
                return pSDevSlnMSDepAPIBase.isPSSysServiceAPIIdDirty();
            }
            case 41: {
                return pSDevSlnMSDepAPIBase.isUpdateDateDirty();
            }
            case 42: {
                return pSDevSlnMSDepAPIBase.isUpdateManDirty();
            }
            case 43: {
                return pSDevSlnMSDepAPIBase.isUserParamsDirty();
            }
            case 44: {
                return pSDevSlnMSDepAPIBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnMSDepAPIBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnMSDepAPIBase pSDevSlnMSDepAPIBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnMSDepAPIBase.getAPIMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apimode", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getAPIMode()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getAPITag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitag", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getAPITag()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getAPITag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitag2", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getAPITag2()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getAuthCheckTokenUri() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authchecktokenuri", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getAuthCheckTokenUri()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getAuthClientId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientid", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getAuthClientId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getAuthClientSecret() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientsecret", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getAuthClientSecret()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getAuthMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authmode", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getAuthMode()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getDeployState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploystate", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getDeployState()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getDeployTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploytag", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getDeployTag()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getDeployTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploytag2", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getDeployTag2()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getDeployTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploytag3", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getDeployTag3()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getDeployTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deploytag4", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getDeployTag4()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getHttpAddress() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpaddress", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getHttpAddress()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getHttpPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpport", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getHttpPort()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getHttpsPort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"httpsport", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getHttpsPort()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getNodeIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodeipaddr", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getNodeIPAddr()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getNodePort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodeport", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getNodePort()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDCMSPlatformId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformid", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDCMSPlatformId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformnodeid", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsplatformnodename", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDCRegistryItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryitemid", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDCRegistryItemId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDCRegistryItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcregistryitemname", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDCRegistryItemName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevCenterDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstid", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDevCenterDBInstId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevCenterDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstname", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDevCenterDBInstName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepapiid", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdepapiname", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdeployid", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnmsdeployname", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnPipelineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelineid", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDevSlnPipelineId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnPipelineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinename", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDevSlnPipelineName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysapiid", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysapiname", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDevSlnMSDepAPIBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnMSDepAPIBase.getJSONValue((Object)pSDevSlnMSDepAPIBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnMSDepAPIBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnMSDepAPIBase pSDevSlnMSDepAPIBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnMSDepAPIBase.getAPIMode() != null) {
            object = pSDevSlnMSDepAPIBase.getAPIMode();
            xmlNode.setAttribute(FIELD_APIMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDepAPIBase.getAPITag() != null) {
            object = pSDevSlnMSDepAPIBase.getAPITag();
            xmlNode.setAttribute(FIELD_APITAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getAPITag2() != null) {
            object = pSDevSlnMSDepAPIBase.getAPITag2();
            xmlNode.setAttribute(FIELD_APITAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getAuthCheckTokenUri() != null) {
            object = pSDevSlnMSDepAPIBase.getAuthCheckTokenUri();
            xmlNode.setAttribute(FIELD_AUTHCHECKTOKENURI, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getAuthClientId() != null) {
            object = pSDevSlnMSDepAPIBase.getAuthClientId();
            xmlNode.setAttribute(FIELD_AUTHCLIENTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getAuthClientSecret() != null) {
            object = pSDevSlnMSDepAPIBase.getAuthClientSecret();
            xmlNode.setAttribute(FIELD_AUTHCLIENTSECRET, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getAuthMode() != null) {
            object = pSDevSlnMSDepAPIBase.getAuthMode();
            xmlNode.setAttribute(FIELD_AUTHMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getCreateDate() != null) {
            object = pSDevSlnMSDepAPIBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnMSDepAPIBase.getCreateMan() != null) {
            object = pSDevSlnMSDepAPIBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getDeployState() != null) {
            object = pSDevSlnMSDepAPIBase.getDeployState();
            xmlNode.setAttribute(FIELD_DEPLOYSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDepAPIBase.getDeployTag() != null) {
            object = pSDevSlnMSDepAPIBase.getDeployTag();
            xmlNode.setAttribute(FIELD_DEPLOYTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getDeployTag2() != null) {
            object = pSDevSlnMSDepAPIBase.getDeployTag2();
            xmlNode.setAttribute(FIELD_DEPLOYTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getDeployTag3() != null) {
            object = pSDevSlnMSDepAPIBase.getDeployTag3();
            xmlNode.setAttribute(FIELD_DEPLOYTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getDeployTag4() != null) {
            object = pSDevSlnMSDepAPIBase.getDeployTag4();
            xmlNode.setAttribute(FIELD_DEPLOYTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getHttpAddress() != null) {
            object = pSDevSlnMSDepAPIBase.getHttpAddress();
            xmlNode.setAttribute(FIELD_HTTPADDRESS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getHttpPort() != null) {
            object = pSDevSlnMSDepAPIBase.getHttpPort();
            xmlNode.setAttribute(FIELD_HTTPPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDepAPIBase.getHttpsPort() != null) {
            object = pSDevSlnMSDepAPIBase.getHttpsPort();
            xmlNode.setAttribute(FIELD_HTTPSPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDepAPIBase.getMemo() != null) {
            object = pSDevSlnMSDepAPIBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getNodeIPAddr() != null) {
            object = pSDevSlnMSDepAPIBase.getNodeIPAddr();
            xmlNode.setAttribute(FIELD_NODEIPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getNodePort() != null) {
            object = pSDevSlnMSDepAPIBase.getNodePort();
            xmlNode.setAttribute(FIELD_NODEPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDepAPIBase.getOrderValue() != null) {
            object = pSDevSlnMSDepAPIBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDCMSPlatformId() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDCMSPlatformId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeId() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeId();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeName() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeName();
            xmlNode.setAttribute(FIELD_PSDCMSPLATFORMNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDCRegistryItemId() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDCRegistryItemId();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDCRegistryItemName() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDCRegistryItemName();
            xmlNode.setAttribute(FIELD_PSDCREGISTRYITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevCenterDBInstId() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDevCenterDBInstId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevCenterDBInstName() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDevCenterDBInstName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnId() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIId() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIName() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployId() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployId();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPLOYID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployName() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployName();
            xmlNode.setAttribute(FIELD_PSDEVSLNMSDEPLOYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnName() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnPipelineId() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDevSlnPipelineId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnPipelineName() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDevSlnPipelineName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIId() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIName() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnMSDepAPIBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getPSSysServiceAPIId() != null) {
            object = pSDevSlnMSDepAPIBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getUpdateDate() != null) {
            object = pSDevSlnMSDepAPIBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnMSDepAPIBase.getUpdateMan() != null) {
            object = pSDevSlnMSDepAPIBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getUserParams() != null) {
            object = pSDevSlnMSDepAPIBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnMSDepAPIBase.getValidFlag() != null) {
            object = pSDevSlnMSDepAPIBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnMSDepAPIBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnMSDepAPIBase pSDevSlnMSDepAPIBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnMSDepAPIBase.isAPIModeDirty() && (bl || pSDevSlnMSDepAPIBase.getAPIMode() != null)) {
            iDataObject.set(FIELD_APIMODE, (Object)pSDevSlnMSDepAPIBase.getAPIMode());
        }
        if (pSDevSlnMSDepAPIBase.isAPITagDirty() && (bl || pSDevSlnMSDepAPIBase.getAPITag() != null)) {
            iDataObject.set(FIELD_APITAG, (Object)pSDevSlnMSDepAPIBase.getAPITag());
        }
        if (pSDevSlnMSDepAPIBase.isAPITag2Dirty() && (bl || pSDevSlnMSDepAPIBase.getAPITag2() != null)) {
            iDataObject.set(FIELD_APITAG2, (Object)pSDevSlnMSDepAPIBase.getAPITag2());
        }
        if (pSDevSlnMSDepAPIBase.isAuthCheckTokenUriDirty() && (bl || pSDevSlnMSDepAPIBase.getAuthCheckTokenUri() != null)) {
            iDataObject.set(FIELD_AUTHCHECKTOKENURI, (Object)pSDevSlnMSDepAPIBase.getAuthCheckTokenUri());
        }
        if (pSDevSlnMSDepAPIBase.isAuthClientIdDirty() && (bl || pSDevSlnMSDepAPIBase.getAuthClientId() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTID, (Object)pSDevSlnMSDepAPIBase.getAuthClientId());
        }
        if (pSDevSlnMSDepAPIBase.isAuthClientSecretDirty() && (bl || pSDevSlnMSDepAPIBase.getAuthClientSecret() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTSECRET, (Object)pSDevSlnMSDepAPIBase.getAuthClientSecret());
        }
        if (pSDevSlnMSDepAPIBase.isAuthModeDirty() && (bl || pSDevSlnMSDepAPIBase.getAuthMode() != null)) {
            iDataObject.set(FIELD_AUTHMODE, (Object)pSDevSlnMSDepAPIBase.getAuthMode());
        }
        if (pSDevSlnMSDepAPIBase.isCreateDateDirty() && (bl || pSDevSlnMSDepAPIBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnMSDepAPIBase.getCreateDate());
        }
        if (pSDevSlnMSDepAPIBase.isCreateManDirty() && (bl || pSDevSlnMSDepAPIBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnMSDepAPIBase.getCreateMan());
        }
        if (pSDevSlnMSDepAPIBase.isDeployStateDirty() && (bl || pSDevSlnMSDepAPIBase.getDeployState() != null)) {
            iDataObject.set(FIELD_DEPLOYSTATE, (Object)pSDevSlnMSDepAPIBase.getDeployState());
        }
        if (pSDevSlnMSDepAPIBase.isDeployTagDirty() && (bl || pSDevSlnMSDepAPIBase.getDeployTag() != null)) {
            iDataObject.set(FIELD_DEPLOYTAG, (Object)pSDevSlnMSDepAPIBase.getDeployTag());
        }
        if (pSDevSlnMSDepAPIBase.isDeployTag2Dirty() && (bl || pSDevSlnMSDepAPIBase.getDeployTag2() != null)) {
            iDataObject.set(FIELD_DEPLOYTAG2, (Object)pSDevSlnMSDepAPIBase.getDeployTag2());
        }
        if (pSDevSlnMSDepAPIBase.isDeployTag3Dirty() && (bl || pSDevSlnMSDepAPIBase.getDeployTag3() != null)) {
            iDataObject.set(FIELD_DEPLOYTAG3, (Object)pSDevSlnMSDepAPIBase.getDeployTag3());
        }
        if (pSDevSlnMSDepAPIBase.isDeployTag4Dirty() && (bl || pSDevSlnMSDepAPIBase.getDeployTag4() != null)) {
            iDataObject.set(FIELD_DEPLOYTAG4, (Object)pSDevSlnMSDepAPIBase.getDeployTag4());
        }
        if (pSDevSlnMSDepAPIBase.isHttpAddressDirty() && (bl || pSDevSlnMSDepAPIBase.getHttpAddress() != null)) {
            iDataObject.set(FIELD_HTTPADDRESS, (Object)pSDevSlnMSDepAPIBase.getHttpAddress());
        }
        if (pSDevSlnMSDepAPIBase.isHttpPortDirty() && (bl || pSDevSlnMSDepAPIBase.getHttpPort() != null)) {
            iDataObject.set(FIELD_HTTPPORT, (Object)pSDevSlnMSDepAPIBase.getHttpPort());
        }
        if (pSDevSlnMSDepAPIBase.isHttpsPortDirty() && (bl || pSDevSlnMSDepAPIBase.getHttpsPort() != null)) {
            iDataObject.set(FIELD_HTTPSPORT, (Object)pSDevSlnMSDepAPIBase.getHttpsPort());
        }
        if (pSDevSlnMSDepAPIBase.isMemoDirty() && (bl || pSDevSlnMSDepAPIBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnMSDepAPIBase.getMemo());
        }
        if (pSDevSlnMSDepAPIBase.isNodeIPAddrDirty() && (bl || pSDevSlnMSDepAPIBase.getNodeIPAddr() != null)) {
            iDataObject.set(FIELD_NODEIPADDR, (Object)pSDevSlnMSDepAPIBase.getNodeIPAddr());
        }
        if (pSDevSlnMSDepAPIBase.isNodePortDirty() && (bl || pSDevSlnMSDepAPIBase.getNodePort() != null)) {
            iDataObject.set(FIELD_NODEPORT, (Object)pSDevSlnMSDepAPIBase.getNodePort());
        }
        if (pSDevSlnMSDepAPIBase.isOrderValueDirty() && (bl || pSDevSlnMSDepAPIBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDevSlnMSDepAPIBase.getOrderValue());
        }
        if (pSDevSlnMSDepAPIBase.isPSDCMSPlatformIdDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDCMSPlatformId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMID, (Object)pSDevSlnMSDepAPIBase.getPSDCMSPlatformId());
        }
        if (pSDevSlnMSDepAPIBase.isPSDCMSPlatformNodeIdDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeId() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNODEID, (Object)pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeId());
        }
        if (pSDevSlnMSDepAPIBase.isPSDCMSPlatformNodeNameDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeName() != null)) {
            iDataObject.set(FIELD_PSDCMSPLATFORMNODENAME, (Object)pSDevSlnMSDepAPIBase.getPSDCMSPlatformNodeName());
        }
        if (pSDevSlnMSDepAPIBase.isPSDCRegistryItemIdDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDCRegistryItemId() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYITEMID, (Object)pSDevSlnMSDepAPIBase.getPSDCRegistryItemId());
        }
        if (pSDevSlnMSDepAPIBase.isPSDCRegistryItemNameDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDCRegistryItemName() != null)) {
            iDataObject.set(FIELD_PSDCREGISTRYITEMNAME, (Object)pSDevSlnMSDepAPIBase.getPSDCRegistryItemName());
        }
        if (pSDevSlnMSDepAPIBase.isPSDevCenterDBInstIdDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDevCenterDBInstId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTID, (Object)pSDevSlnMSDepAPIBase.getPSDevCenterDBInstId());
        }
        if (pSDevSlnMSDepAPIBase.isPSDevCenterDBInstNameDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDevCenterDBInstName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTNAME, (Object)pSDevSlnMSDepAPIBase.getPSDevCenterDBInstName());
        }
        if (pSDevSlnMSDepAPIBase.isPSDevSlnIdDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnMSDepAPIBase.getPSDevSlnId());
        }
        if (pSDevSlnMSDepAPIBase.isPSDevSlnMSDepAPIIdDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPAPIID, (Object)pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIId());
        }
        if (pSDevSlnMSDepAPIBase.isPSDevSlnMSDepAPINameDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPAPINAME, (Object)pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIName());
        }
        if (pSDevSlnMSDepAPIBase.isPSDevSlnMSDeployIdDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPLOYID, (Object)pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployId());
        }
        if (pSDevSlnMSDepAPIBase.isPSDevSlnMSDeployNameDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNMSDEPLOYNAME, (Object)pSDevSlnMSDepAPIBase.getPSDevSlnMSDeployName());
        }
        if (pSDevSlnMSDepAPIBase.isPSDevSlnNameDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnMSDepAPIBase.getPSDevSlnName());
        }
        if (pSDevSlnMSDepAPIBase.isPSDevSlnPipelineIdDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDevSlnPipelineId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINEID, (Object)pSDevSlnMSDepAPIBase.getPSDevSlnPipelineId());
        }
        if (pSDevSlnMSDepAPIBase.isPSDevSlnPipelineNameDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDevSlnPipelineName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINENAME, (Object)pSDevSlnMSDepAPIBase.getPSDevSlnPipelineName());
        }
        if (pSDevSlnMSDepAPIBase.isPSDevSlnSysAPIIdDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPIID, (Object)pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIId());
        }
        if (pSDevSlnMSDepAPIBase.isPSDevSlnSysAPINameDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSAPINAME, (Object)pSDevSlnMSDepAPIBase.getPSDevSlnSysAPIName());
        }
        if (pSDevSlnMSDepAPIBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnMSDepAPIBase.getPSDevSlnSysId());
        }
        if (pSDevSlnMSDepAPIBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnMSDepAPIBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnMSDepAPIBase.getPSDevSlnSysName());
        }
        if (pSDevSlnMSDepAPIBase.isPSSysServiceAPIIdDirty() && (bl || pSDevSlnMSDepAPIBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSDevSlnMSDepAPIBase.getPSSysServiceAPIId());
        }
        if (pSDevSlnMSDepAPIBase.isUpdateDateDirty() && (bl || pSDevSlnMSDepAPIBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnMSDepAPIBase.getUpdateDate());
        }
        if (pSDevSlnMSDepAPIBase.isUpdateManDirty() && (bl || pSDevSlnMSDepAPIBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnMSDepAPIBase.getUpdateMan());
        }
        if (pSDevSlnMSDepAPIBase.isUserParamsDirty() && (bl || pSDevSlnMSDepAPIBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDevSlnMSDepAPIBase.getUserParams());
        }
        if (pSDevSlnMSDepAPIBase.isValidFlagDirty() && (bl || pSDevSlnMSDepAPIBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnMSDepAPIBase.getValidFlag());
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
        return PSDevSlnMSDepAPIBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnMSDepAPIBase pSDevSlnMSDepAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnMSDepAPIBase.resetAPIMode();
                return true;
            }
            case 1: {
                pSDevSlnMSDepAPIBase.resetAPITag();
                return true;
            }
            case 2: {
                pSDevSlnMSDepAPIBase.resetAPITag2();
                return true;
            }
            case 3: {
                pSDevSlnMSDepAPIBase.resetAuthCheckTokenUri();
                return true;
            }
            case 4: {
                pSDevSlnMSDepAPIBase.resetAuthClientId();
                return true;
            }
            case 5: {
                pSDevSlnMSDepAPIBase.resetAuthClientSecret();
                return true;
            }
            case 6: {
                pSDevSlnMSDepAPIBase.resetAuthMode();
                return true;
            }
            case 7: {
                pSDevSlnMSDepAPIBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSDevSlnMSDepAPIBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSDevSlnMSDepAPIBase.resetDeployState();
                return true;
            }
            case 10: {
                pSDevSlnMSDepAPIBase.resetDeployTag();
                return true;
            }
            case 11: {
                pSDevSlnMSDepAPIBase.resetDeployTag2();
                return true;
            }
            case 12: {
                pSDevSlnMSDepAPIBase.resetDeployTag3();
                return true;
            }
            case 13: {
                pSDevSlnMSDepAPIBase.resetDeployTag4();
                return true;
            }
            case 14: {
                pSDevSlnMSDepAPIBase.resetHttpAddress();
                return true;
            }
            case 15: {
                pSDevSlnMSDepAPIBase.resetHttpPort();
                return true;
            }
            case 16: {
                pSDevSlnMSDepAPIBase.resetHttpsPort();
                return true;
            }
            case 17: {
                pSDevSlnMSDepAPIBase.resetMemo();
                return true;
            }
            case 18: {
                pSDevSlnMSDepAPIBase.resetNodeIPAddr();
                return true;
            }
            case 19: {
                pSDevSlnMSDepAPIBase.resetNodePort();
                return true;
            }
            case 20: {
                pSDevSlnMSDepAPIBase.resetOrderValue();
                return true;
            }
            case 21: {
                pSDevSlnMSDepAPIBase.resetPSDCMSPlatformId();
                return true;
            }
            case 22: {
                pSDevSlnMSDepAPIBase.resetPSDCMSPlatformNodeId();
                return true;
            }
            case 23: {
                pSDevSlnMSDepAPIBase.resetPSDCMSPlatformNodeName();
                return true;
            }
            case 24: {
                pSDevSlnMSDepAPIBase.resetPSDCRegistryItemId();
                return true;
            }
            case 25: {
                pSDevSlnMSDepAPIBase.resetPSDCRegistryItemName();
                return true;
            }
            case 26: {
                pSDevSlnMSDepAPIBase.resetPSDevCenterDBInstId();
                return true;
            }
            case 27: {
                pSDevSlnMSDepAPIBase.resetPSDevCenterDBInstName();
                return true;
            }
            case 28: {
                pSDevSlnMSDepAPIBase.resetPSDevSlnId();
                return true;
            }
            case 29: {
                pSDevSlnMSDepAPIBase.resetPSDevSlnMSDepAPIId();
                return true;
            }
            case 30: {
                pSDevSlnMSDepAPIBase.resetPSDevSlnMSDepAPIName();
                return true;
            }
            case 31: {
                pSDevSlnMSDepAPIBase.resetPSDevSlnMSDeployId();
                return true;
            }
            case 32: {
                pSDevSlnMSDepAPIBase.resetPSDevSlnMSDeployName();
                return true;
            }
            case 33: {
                pSDevSlnMSDepAPIBase.resetPSDevSlnName();
                return true;
            }
            case 34: {
                pSDevSlnMSDepAPIBase.resetPSDevSlnPipelineId();
                return true;
            }
            case 35: {
                pSDevSlnMSDepAPIBase.resetPSDevSlnPipelineName();
                return true;
            }
            case 36: {
                pSDevSlnMSDepAPIBase.resetPSDevSlnSysAPIId();
                return true;
            }
            case 37: {
                pSDevSlnMSDepAPIBase.resetPSDevSlnSysAPIName();
                return true;
            }
            case 38: {
                pSDevSlnMSDepAPIBase.resetPSDevSlnSysId();
                return true;
            }
            case 39: {
                pSDevSlnMSDepAPIBase.resetPSDevSlnSysName();
                return true;
            }
            case 40: {
                pSDevSlnMSDepAPIBase.resetPSSysServiceAPIId();
                return true;
            }
            case 41: {
                pSDevSlnMSDepAPIBase.resetUpdateDate();
                return true;
            }
            case 42: {
                pSDevSlnMSDepAPIBase.resetUpdateMan();
                return true;
            }
            case 43: {
                pSDevSlnMSDepAPIBase.resetUserParams();
                return true;
            }
            case 44: {
                pSDevSlnMSDepAPIBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCMSPlatformNode getPSDCMSPlatformNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMSPlatformNode();
        }
        if (this.getPSDCMSPlatformNodeId() == null) {
            return null;
        }
        Integer n = this.objPSDCMSPlatformNodeLock;
        synchronized (n) {
            if (this.psdcmsplatformnode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCMSPlatformNodeId(), (Object)this.psdcmsplatformnode.getPSDCMSPlatformNodeId()) != 0L) {
                this.psdcmsplatformnode = null;
            }
            if (this.psdcmsplatformnode == null) {
                PSDCMSPlatformNode pSDCMSPlatformNode = new PSDCMSPlatformNode();
                pSDCMSPlatformNode.setPSDCMSPlatformNodeId(this.getPSDCMSPlatformNodeId());
                PSDCMSPlatformNodeService pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
                pSDCMSPlatformNodeService.autoGet(pSDCMSPlatformNode);
                this.psdcmsplatformnode = pSDCMSPlatformNode;
            }
            return this.psdcmsplatformnode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPSDevCenterDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInst();
        }
        if (this.getPSDevCenterDBInstId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterDBInstLock;
        synchronized (n) {
            if (this.psdevcenterdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterDBInstId(), (Object)this.psdevcenterdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.psdevcenterdbinst = null;
            }
            if (this.psdevcenterdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPSDevCenterDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet(pSDevCenterDBInst);
                this.psdevcenterdbinst = pSDevCenterDBInst;
            }
            return this.psdevcenterdbinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnMSDeploy getPSDevSlnMSDeploy() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnMSDeploy();
        }
        if (this.getPSDevSlnMSDeployId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnMSDeployLock;
        synchronized (n) {
            if (this.psdevslnmsdeploy != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnMSDeployId(), (Object)this.psdevslnmsdeploy.getPSDevSlnMSDeployId()) != 0L) {
                this.psdevslnmsdeploy = null;
            }
            if (this.psdevslnmsdeploy == null) {
                PSDevSlnMSDeploy pSDevSlnMSDeploy = new PSDevSlnMSDeploy();
                pSDevSlnMSDeploy.setPSDevSlnMSDeployId(this.getPSDevSlnMSDeployId());
                PSDevSlnMSDeployService pSDevSlnMSDeployService = (PSDevSlnMSDeployService)ServiceGlobal.getService(PSDevSlnMSDeployService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnMSDeployService.autoGet(pSDevSlnMSDeploy);
                this.psdevslnmsdeploy = pSDevSlnMSDeploy;
            }
            return this.psdevslnmsdeploy;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnPipeline getPSDevSlnPipeline() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipeline();
        }
        if (this.getPSDevSlnPipelineId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnPipelineLock;
        synchronized (n) {
            if (this.psdevslnpipeline != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnPipelineId(), (Object)this.psdevslnpipeline.getPSDevSlnPipelineId()) != 0L) {
                this.psdevslnpipeline = null;
            }
            if (this.psdevslnpipeline == null) {
                PSDevSlnPipeline pSDevSlnPipeline = new PSDevSlnPipeline();
                pSDevSlnPipeline.setPSDevSlnPipelineId(this.getPSDevSlnPipelineId());
                PSDevSlnPipelineService pSDevSlnPipelineService = (PSDevSlnPipelineService)ServiceGlobal.getService(PSDevSlnPipelineService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnPipelineService.autoGet(pSDevSlnPipeline);
                this.psdevslnpipeline = pSDevSlnPipeline;
            }
            return this.psdevslnpipeline;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysAPI getPSDevSlnSysAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysAPI();
        }
        if (this.getPSDevSlnSysAPIId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysAPILock;
        synchronized (n) {
            if (this.psdevslnsysapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysAPIId(), (Object)this.psdevslnsysapi.getPSDevSlnSysAPIId()) != 0L) {
                this.psdevslnsysapi = null;
            }
            if (this.psdevslnsysapi == null) {
                PSDevSlnSysAPI pSDevSlnSysAPI = new PSDevSlnSysAPI();
                pSDevSlnSysAPI.setPSDevSlnSysAPIId(this.getPSDevSlnSysAPIId());
                PSDevSlnSysAPIService pSDevSlnSysAPIService = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysAPIService.autoGet(pSDevSlnSysAPI);
                this.psdevslnsysapi = pSDevSlnSysAPI;
            }
            return this.psdevslnsysapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    private PSDevSlnMSDepAPIBase getProxyEntity() {
        return this.proxyPSDevSlnMSDepAPIBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnMSDepAPIBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnMSDepAPIBase) {
            this.proxyPSDevSlnMSDepAPIBase = (PSDevSlnMSDepAPIBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APIMODE, 0);
        fieldIndexMap.put(FIELD_APITAG, 1);
        fieldIndexMap.put(FIELD_APITAG2, 2);
        fieldIndexMap.put(FIELD_AUTHCHECKTOKENURI, 3);
        fieldIndexMap.put(FIELD_AUTHCLIENTID, 4);
        fieldIndexMap.put(FIELD_AUTHCLIENTSECRET, 5);
        fieldIndexMap.put(FIELD_AUTHMODE, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_DEPLOYSTATE, 9);
        fieldIndexMap.put(FIELD_DEPLOYTAG, 10);
        fieldIndexMap.put(FIELD_DEPLOYTAG2, 11);
        fieldIndexMap.put(FIELD_DEPLOYTAG3, 12);
        fieldIndexMap.put(FIELD_DEPLOYTAG4, 13);
        fieldIndexMap.put(FIELD_HTTPADDRESS, 14);
        fieldIndexMap.put(FIELD_HTTPPORT, 15);
        fieldIndexMap.put(FIELD_HTTPSPORT, 16);
        fieldIndexMap.put(FIELD_MEMO, 17);
        fieldIndexMap.put(FIELD_NODEIPADDR, 18);
        fieldIndexMap.put(FIELD_NODEPORT, 19);
        fieldIndexMap.put(FIELD_ORDERVALUE, 20);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMID, 21);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNODEID, 22);
        fieldIndexMap.put(FIELD_PSDCMSPLATFORMNODENAME, 23);
        fieldIndexMap.put(FIELD_PSDCREGISTRYITEMID, 24);
        fieldIndexMap.put(FIELD_PSDCREGISTRYITEMNAME, 25);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTID, 26);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTNAME, 27);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 28);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPAPIID, 29);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPAPINAME, 30);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPLOYID, 31);
        fieldIndexMap.put(FIELD_PSDEVSLNMSDEPLOYNAME, 32);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 33);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINEID, 34);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINENAME, 35);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPIID, 36);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSAPINAME, 37);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 38);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 39);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 40);
        fieldIndexMap.put(FIELD_UPDATEDATE, 41);
        fieldIndexMap.put(FIELD_UPDATEMAN, 42);
        fieldIndexMap.put(FIELD_USERPARAMS, 43);
        fieldIndexMap.put(FIELD_VALIDFLAG, 44);
    }
}

