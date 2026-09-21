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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDataSyncAgentBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDataSyncAgentBase.class);
    public static final String FIELD_AGENTPARAMS = "AGENTPARAMS";
    public static final String FIELD_AGENTTAG = "AGENTTAG";
    public static final String FIELD_AGENTTAG2 = "AGENTTAG2";
    public static final String FIELD_AGENTTYPE = "AGENTTYPE";
    public static final String FIELD_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String FIELD_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String FIELD_AUTHMODE = "AUTHMODE";
    public static final String FIELD_AUTHPARAM = "AUTHPARAM";
    public static final String FIELD_AUTHPARAM2 = "AUTHPARAM2";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_GROUPID = "GROUPID";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSDATASYNCAGENTID = "PSSYSDATASYNCAGENTID";
    public static final String FIELD_PSSYSDATASYNCAGENTNAME = "PSSYSDATASYNCAGENTNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_RAWDATAMODE = "RAWDATAMODE";
    public static final String FIELD_SERVICEPARAM = "SERVICEPARAM";
    public static final String FIELD_SERVICEPARAM2 = "SERVICEPARAM2";
    public static final String FIELD_SERVICEPATH = "SERVICEPATH";
    public static final String FIELD_SYNCDIR = "SYNCDIR";
    public static final String FIELD_TOPIC = "TOPIC";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_AGENTPARAMS = 0;
    private static final int INDEX_AGENTTAG = 1;
    private static final int INDEX_AGENTTAG2 = 2;
    private static final int INDEX_AGENTTYPE = 3;
    private static final int INDEX_AUTHCLIENTID = 4;
    private static final int INDEX_AUTHCLIENTSECRET = 5;
    private static final int INDEX_AUTHMODE = 6;
    private static final int INDEX_AUTHPARAM = 7;
    private static final int INDEX_AUTHPARAM2 = 8;
    private static final int INDEX_CODENAME = 9;
    private static final int INDEX_CREATEDATE = 10;
    private static final int INDEX_CREATEMAN = 11;
    private static final int INDEX_CUSTOMCODE = 12;
    private static final int INDEX_CUSTOMMODE = 13;
    private static final int INDEX_GROUPID = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_PSMODULEID = 16;
    private static final int INDEX_PSMODULENAME = 17;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 18;
    private static final int INDEX_PSSUBSYSSERVICEAPINAME = 19;
    private static final int INDEX_PSSYSDATASYNCAGENTID = 20;
    private static final int INDEX_PSSYSDATASYNCAGENTNAME = 21;
    private static final int INDEX_PSSYSDYNAMODELID = 22;
    private static final int INDEX_PSSYSDYNAMODELNAME = 23;
    private static final int INDEX_PSSYSSFPLUGINID = 24;
    private static final int INDEX_PSSYSSFPLUGINNAME = 25;
    private static final int INDEX_PSSYSTEMID = 26;
    private static final int INDEX_PSSYSTEMNAME = 27;
    private static final int INDEX_RAWDATAMODE = 28;
    private static final int INDEX_SERVICEPARAM = 29;
    private static final int INDEX_SERVICEPARAM2 = 30;
    private static final int INDEX_SERVICEPATH = 31;
    private static final int INDEX_SYNCDIR = 32;
    private static final int INDEX_TOPIC = 33;
    private static final int INDEX_UPDATEDATE = 34;
    private static final int INDEX_UPDATEMAN = 35;
    private static final int INDEX_USERCAT = 36;
    private static final int INDEX_USERTAG = 37;
    private static final int INDEX_USERTAG2 = 38;
    private static final int INDEX_USERTAG3 = 39;
    private static final int INDEX_USERTAG4 = 40;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDataSyncAgentBase proxyPSSysDataSyncAgentBase = null;
    private boolean agentparamsDirtyFlag = false;
    private boolean agenttagDirtyFlag = false;
    private boolean agenttag2DirtyFlag = false;
    private boolean agenttypeDirtyFlag = false;
    private boolean authclientidDirtyFlag = false;
    private boolean authclientsecretDirtyFlag = false;
    private boolean authmodeDirtyFlag = false;
    private boolean authparamDirtyFlag = false;
    private boolean authparam2DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean groupidDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssubsysserviceapinameDirtyFlag = false;
    private boolean pssysdatasyncagentidDirtyFlag = false;
    private boolean pssysdatasyncagentnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean rawdatamodeDirtyFlag = false;
    private boolean serviceparamDirtyFlag = false;
    private boolean serviceparam2DirtyFlag = false;
    private boolean servicepathDirtyFlag = false;
    private boolean syncdirDirtyFlag = false;
    private boolean topicDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="agentparams")
    private String agentparams;
    @Column(name="agenttag")
    private String agenttag;
    @Column(name="agenttag2")
    private String agenttag2;
    @Column(name="agenttype")
    private String agenttype;
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
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="groupid")
    private String groupid;
    @Column(name="memo")
    private String memo;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssubsysserviceapiid")
    private String pssubsysserviceapiid;
    @Column(name="pssubsysserviceapiname")
    private String pssubsysserviceapiname;
    @Column(name="pssysdatasyncagentid")
    private String pssysdatasyncagentid;
    @Column(name="pssysdatasyncagentname")
    private String pssysdatasyncagentname;
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
    @Column(name="rawdatamode")
    private Integer rawdatamode;
    @Column(name="serviceparam")
    private String serviceparam;
    @Column(name="serviceparam2")
    private String serviceparam2;
    @Column(name="servicepath")
    private String servicepath;
    @Column(name="syncdir")
    private String syncdir;
    @Column(name="topic")
    private String topic;
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
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setAgentParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.agentparams = string;
        this.agentparamsDirtyFlag = true;
    }

    public String getAgentParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentParams();
        }
        return this.agentparams;
    }

    public boolean isAgentParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentParamsDirty();
        }
        return this.agentparamsDirtyFlag;
    }

    public void resetAgentParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentParams();
            return;
        }
        this.agentparamsDirtyFlag = false;
        this.agentparams = null;
    }

    public void setAgentTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.agenttag = string;
        this.agenttagDirtyFlag = true;
    }

    public String getAgentTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentTag();
        }
        return this.agenttag;
    }

    public boolean isAgentTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentTagDirty();
        }
        return this.agenttagDirtyFlag;
    }

    public void resetAgentTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentTag();
            return;
        }
        this.agenttagDirtyFlag = false;
        this.agenttag = null;
    }

    public void setAgentTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.agenttag2 = string;
        this.agenttag2DirtyFlag = true;
    }

    public String getAgentTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentTag2();
        }
        return this.agenttag2;
    }

    public boolean isAgentTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentTag2Dirty();
        }
        return this.agenttag2DirtyFlag;
    }

    public void resetAgentTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentTag2();
            return;
        }
        this.agenttag2DirtyFlag = false;
        this.agenttag2 = null;
    }

    public void setAgentType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.agenttype = string;
        this.agenttypeDirtyFlag = true;
    }

    public String getAgentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentType();
        }
        return this.agenttype;
    }

    public boolean isAgentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentTypeDirty();
        }
        return this.agenttypeDirtyFlag;
    }

    public void resetAgentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentType();
            return;
        }
        this.agenttypeDirtyFlag = false;
        this.agenttype = null;
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

    public void setGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupid = string;
        this.groupidDirtyFlag = true;
    }

    public String getGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupId();
        }
        return this.groupid;
    }

    public boolean isGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupIdDirty();
        }
        return this.groupidDirtyFlag;
    }

    public void resetGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupId();
            return;
        }
        this.groupidDirtyFlag = false;
        this.groupid = null;
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

    public void setPSSysDataSyncAgentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDataSyncAgentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdatasyncagentid = string;
        this.pssysdatasyncagentidDirtyFlag = true;
    }

    public String getPSSysDataSyncAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDataSyncAgentId();
        }
        return this.pssysdatasyncagentid;
    }

    public boolean isPSSysDataSyncAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDataSyncAgentIdDirty();
        }
        return this.pssysdatasyncagentidDirtyFlag;
    }

    public void resetPSSysDataSyncAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDataSyncAgentId();
            return;
        }
        this.pssysdatasyncagentidDirtyFlag = false;
        this.pssysdatasyncagentid = null;
    }

    public void setPSSysDataSyncAgentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDataSyncAgentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdatasyncagentname = string;
        this.pssysdatasyncagentnameDirtyFlag = true;
    }

    public String getPSSysDataSyncAgentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDataSyncAgentName();
        }
        return this.pssysdatasyncagentname;
    }

    public boolean isPSSysDataSyncAgentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDataSyncAgentNameDirty();
        }
        return this.pssysdatasyncagentnameDirtyFlag;
    }

    public void resetPSSysDataSyncAgentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDataSyncAgentName();
            return;
        }
        this.pssysdatasyncagentnameDirtyFlag = false;
        this.pssysdatasyncagentname = null;
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

    public void setRawDataMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawDataMode(n);
            return;
        }
        this.rawdatamode = n;
        this.rawdatamodeDirtyFlag = true;
    }

    public Integer getRawDataMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawDataMode();
        }
        return this.rawdatamode;
    }

    public boolean isRawDataModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawDataModeDirty();
        }
        return this.rawdatamodeDirtyFlag;
    }

    public void resetRawDataMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawDataMode();
            return;
        }
        this.rawdatamodeDirtyFlag = false;
        this.rawdatamode = null;
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

    public void setSyncDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncdir = string;
        this.syncdirDirtyFlag = true;
    }

    public String getSyncDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncDir();
        }
        return this.syncdir;
    }

    public boolean isSyncDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncDirDirty();
        }
        return this.syncdirDirtyFlag;
    }

    public void resetSyncDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncDir();
            return;
        }
        this.syncdirDirtyFlag = false;
        this.syncdir = null;
    }

    public void setTopic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTopic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.topic = string;
        this.topicDirtyFlag = true;
    }

    public String getTopic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopic();
        }
        return this.topic;
    }

    public boolean isTopicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTopicDirty();
        }
        return this.topicDirtyFlag;
    }

    public void resetTopic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTopic();
            return;
        }
        this.topicDirtyFlag = false;
        this.topic = null;
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
        PSSysDataSyncAgentBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDataSyncAgentBase pSSysDataSyncAgentBase) {
        pSSysDataSyncAgentBase.resetAgentParams();
        pSSysDataSyncAgentBase.resetAgentTag();
        pSSysDataSyncAgentBase.resetAgentTag2();
        pSSysDataSyncAgentBase.resetAgentType();
        pSSysDataSyncAgentBase.resetAuthClientId();
        pSSysDataSyncAgentBase.resetAuthClientSecret();
        pSSysDataSyncAgentBase.resetAuthMode();
        pSSysDataSyncAgentBase.resetAuthParam();
        pSSysDataSyncAgentBase.resetAuthParam2();
        pSSysDataSyncAgentBase.resetCodeName();
        pSSysDataSyncAgentBase.resetCreateDate();
        pSSysDataSyncAgentBase.resetCreateMan();
        pSSysDataSyncAgentBase.resetCustomCode();
        pSSysDataSyncAgentBase.resetCustomMode();
        pSSysDataSyncAgentBase.resetGroupId();
        pSSysDataSyncAgentBase.resetMemo();
        pSSysDataSyncAgentBase.resetPSModuleId();
        pSSysDataSyncAgentBase.resetPSModuleName();
        pSSysDataSyncAgentBase.resetPSSubSysServiceAPIId();
        pSSysDataSyncAgentBase.resetPSSubSysServiceAPIName();
        pSSysDataSyncAgentBase.resetPSSysDataSyncAgentId();
        pSSysDataSyncAgentBase.resetPSSysDataSyncAgentName();
        pSSysDataSyncAgentBase.resetPSSysDynaModelId();
        pSSysDataSyncAgentBase.resetPSSysDynaModelName();
        pSSysDataSyncAgentBase.resetPSSysSFPluginId();
        pSSysDataSyncAgentBase.resetPSSysSFPluginName();
        pSSysDataSyncAgentBase.resetPSSystemId();
        pSSysDataSyncAgentBase.resetPSSystemName();
        pSSysDataSyncAgentBase.resetRawDataMode();
        pSSysDataSyncAgentBase.resetServiceParam();
        pSSysDataSyncAgentBase.resetServiceParam2();
        pSSysDataSyncAgentBase.resetServicePath();
        pSSysDataSyncAgentBase.resetSyncDir();
        pSSysDataSyncAgentBase.resetTopic();
        pSSysDataSyncAgentBase.resetUpdateDate();
        pSSysDataSyncAgentBase.resetUpdateMan();
        pSSysDataSyncAgentBase.resetUserCat();
        pSSysDataSyncAgentBase.resetUserTag();
        pSSysDataSyncAgentBase.resetUserTag2();
        pSSysDataSyncAgentBase.resetUserTag3();
        pSSysDataSyncAgentBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAgentParamsDirty()) {
            hashMap.put(FIELD_AGENTPARAMS, this.getAgentParams());
        }
        if (!bl || this.isAgentTagDirty()) {
            hashMap.put(FIELD_AGENTTAG, this.getAgentTag());
        }
        if (!bl || this.isAgentTag2Dirty()) {
            hashMap.put(FIELD_AGENTTAG2, this.getAgentTag2());
        }
        if (!bl || this.isAgentTypeDirty()) {
            hashMap.put(FIELD_AGENTTYPE, this.getAgentType());
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
        if (!bl || this.isAuthParamDirty()) {
            hashMap.put(FIELD_AUTHPARAM, this.getAuthParam());
        }
        if (!bl || this.isAuthParam2Dirty()) {
            hashMap.put(FIELD_AUTHPARAM2, this.getAuthParam2());
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
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isGroupIdDirty()) {
            hashMap.put(FIELD_GROUPID, this.getGroupId());
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
        if (!bl || this.isPSSubSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPIID, this.getPSSubSysServiceAPIId());
        }
        if (!bl || this.isPSSubSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPINAME, this.getPSSubSysServiceAPIName());
        }
        if (!bl || this.isPSSysDataSyncAgentIdDirty()) {
            hashMap.put(FIELD_PSSYSDATASYNCAGENTID, this.getPSSysDataSyncAgentId());
        }
        if (!bl || this.isPSSysDataSyncAgentNameDirty()) {
            hashMap.put(FIELD_PSSYSDATASYNCAGENTNAME, this.getPSSysDataSyncAgentName());
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
        if (!bl || this.isRawDataModeDirty()) {
            hashMap.put(FIELD_RAWDATAMODE, this.getRawDataMode());
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
        if (!bl || this.isSyncDirDirty()) {
            hashMap.put(FIELD_SYNCDIR, this.getSyncDir());
        }
        if (!bl || this.isTopicDirty()) {
            hashMap.put(FIELD_TOPIC, this.getTopic());
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
        return PSSysDataSyncAgentBase.get(this, n);
    }

    private static Object get(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDataSyncAgentBase.getAgentParams();
            }
            case 1: {
                return pSSysDataSyncAgentBase.getAgentTag();
            }
            case 2: {
                return pSSysDataSyncAgentBase.getAgentTag2();
            }
            case 3: {
                return pSSysDataSyncAgentBase.getAgentType();
            }
            case 4: {
                return pSSysDataSyncAgentBase.getAuthClientId();
            }
            case 5: {
                return pSSysDataSyncAgentBase.getAuthClientSecret();
            }
            case 6: {
                return pSSysDataSyncAgentBase.getAuthMode();
            }
            case 7: {
                return pSSysDataSyncAgentBase.getAuthParam();
            }
            case 8: {
                return pSSysDataSyncAgentBase.getAuthParam2();
            }
            case 9: {
                return pSSysDataSyncAgentBase.getCodeName();
            }
            case 10: {
                return pSSysDataSyncAgentBase.getCreateDate();
            }
            case 11: {
                return pSSysDataSyncAgentBase.getCreateMan();
            }
            case 12: {
                return pSSysDataSyncAgentBase.getCustomCode();
            }
            case 13: {
                return pSSysDataSyncAgentBase.getCustomMode();
            }
            case 14: {
                return pSSysDataSyncAgentBase.getGroupId();
            }
            case 15: {
                return pSSysDataSyncAgentBase.getMemo();
            }
            case 16: {
                return pSSysDataSyncAgentBase.getPSModuleId();
            }
            case 17: {
                return pSSysDataSyncAgentBase.getPSModuleName();
            }
            case 18: {
                return pSSysDataSyncAgentBase.getPSSubSysServiceAPIId();
            }
            case 19: {
                return pSSysDataSyncAgentBase.getPSSubSysServiceAPIName();
            }
            case 20: {
                return pSSysDataSyncAgentBase.getPSSysDataSyncAgentId();
            }
            case 21: {
                return pSSysDataSyncAgentBase.getPSSysDataSyncAgentName();
            }
            case 22: {
                return pSSysDataSyncAgentBase.getPSSysDynaModelId();
            }
            case 23: {
                return pSSysDataSyncAgentBase.getPSSysDynaModelName();
            }
            case 24: {
                return pSSysDataSyncAgentBase.getPSSysSFPluginId();
            }
            case 25: {
                return pSSysDataSyncAgentBase.getPSSysSFPluginName();
            }
            case 26: {
                return pSSysDataSyncAgentBase.getPSSystemId();
            }
            case 27: {
                return pSSysDataSyncAgentBase.getPSSystemName();
            }
            case 28: {
                return pSSysDataSyncAgentBase.getRawDataMode();
            }
            case 29: {
                return pSSysDataSyncAgentBase.getServiceParam();
            }
            case 30: {
                return pSSysDataSyncAgentBase.getServiceParam2();
            }
            case 31: {
                return pSSysDataSyncAgentBase.getServicePath();
            }
            case 32: {
                return pSSysDataSyncAgentBase.getSyncDir();
            }
            case 33: {
                return pSSysDataSyncAgentBase.getTopic();
            }
            case 34: {
                return pSSysDataSyncAgentBase.getUpdateDate();
            }
            case 35: {
                return pSSysDataSyncAgentBase.getUpdateMan();
            }
            case 36: {
                return pSSysDataSyncAgentBase.getUserCat();
            }
            case 37: {
                return pSSysDataSyncAgentBase.getUserTag();
            }
            case 38: {
                return pSSysDataSyncAgentBase.getUserTag2();
            }
            case 39: {
                return pSSysDataSyncAgentBase.getUserTag3();
            }
            case 40: {
                return pSSysDataSyncAgentBase.getUserTag4();
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
        PSSysDataSyncAgentBase.set(this, n, object);
    }

    private static void set(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDataSyncAgentBase.setAgentParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysDataSyncAgentBase.setAgentTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDataSyncAgentBase.setAgentTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDataSyncAgentBase.setAgentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDataSyncAgentBase.setAuthClientId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDataSyncAgentBase.setAuthClientSecret(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDataSyncAgentBase.setAuthMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDataSyncAgentBase.setAuthParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDataSyncAgentBase.setAuthParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDataSyncAgentBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDataSyncAgentBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysDataSyncAgentBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDataSyncAgentBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDataSyncAgentBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysDataSyncAgentBase.setGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDataSyncAgentBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDataSyncAgentBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDataSyncAgentBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysDataSyncAgentBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysDataSyncAgentBase.setPSSubSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysDataSyncAgentBase.setPSSysDataSyncAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysDataSyncAgentBase.setPSSysDataSyncAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysDataSyncAgentBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysDataSyncAgentBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysDataSyncAgentBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysDataSyncAgentBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysDataSyncAgentBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysDataSyncAgentBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysDataSyncAgentBase.setRawDataMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSSysDataSyncAgentBase.setServiceParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysDataSyncAgentBase.setServiceParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysDataSyncAgentBase.setServicePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysDataSyncAgentBase.setSyncDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysDataSyncAgentBase.setTopic(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysDataSyncAgentBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 35: {
                pSSysDataSyncAgentBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysDataSyncAgentBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysDataSyncAgentBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysDataSyncAgentBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysDataSyncAgentBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysDataSyncAgentBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysDataSyncAgentBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDataSyncAgentBase.getAgentParams() == null;
            }
            case 1: {
                return pSSysDataSyncAgentBase.getAgentTag() == null;
            }
            case 2: {
                return pSSysDataSyncAgentBase.getAgentTag2() == null;
            }
            case 3: {
                return pSSysDataSyncAgentBase.getAgentType() == null;
            }
            case 4: {
                return pSSysDataSyncAgentBase.getAuthClientId() == null;
            }
            case 5: {
                return pSSysDataSyncAgentBase.getAuthClientSecret() == null;
            }
            case 6: {
                return pSSysDataSyncAgentBase.getAuthMode() == null;
            }
            case 7: {
                return pSSysDataSyncAgentBase.getAuthParam() == null;
            }
            case 8: {
                return pSSysDataSyncAgentBase.getAuthParam2() == null;
            }
            case 9: {
                return pSSysDataSyncAgentBase.getCodeName() == null;
            }
            case 10: {
                return pSSysDataSyncAgentBase.getCreateDate() == null;
            }
            case 11: {
                return pSSysDataSyncAgentBase.getCreateMan() == null;
            }
            case 12: {
                return pSSysDataSyncAgentBase.getCustomCode() == null;
            }
            case 13: {
                return pSSysDataSyncAgentBase.getCustomMode() == null;
            }
            case 14: {
                return pSSysDataSyncAgentBase.getGroupId() == null;
            }
            case 15: {
                return pSSysDataSyncAgentBase.getMemo() == null;
            }
            case 16: {
                return pSSysDataSyncAgentBase.getPSModuleId() == null;
            }
            case 17: {
                return pSSysDataSyncAgentBase.getPSModuleName() == null;
            }
            case 18: {
                return pSSysDataSyncAgentBase.getPSSubSysServiceAPIId() == null;
            }
            case 19: {
                return pSSysDataSyncAgentBase.getPSSubSysServiceAPIName() == null;
            }
            case 20: {
                return pSSysDataSyncAgentBase.getPSSysDataSyncAgentId() == null;
            }
            case 21: {
                return pSSysDataSyncAgentBase.getPSSysDataSyncAgentName() == null;
            }
            case 22: {
                return pSSysDataSyncAgentBase.getPSSysDynaModelId() == null;
            }
            case 23: {
                return pSSysDataSyncAgentBase.getPSSysDynaModelName() == null;
            }
            case 24: {
                return pSSysDataSyncAgentBase.getPSSysSFPluginId() == null;
            }
            case 25: {
                return pSSysDataSyncAgentBase.getPSSysSFPluginName() == null;
            }
            case 26: {
                return pSSysDataSyncAgentBase.getPSSystemId() == null;
            }
            case 27: {
                return pSSysDataSyncAgentBase.getPSSystemName() == null;
            }
            case 28: {
                return pSSysDataSyncAgentBase.getRawDataMode() == null;
            }
            case 29: {
                return pSSysDataSyncAgentBase.getServiceParam() == null;
            }
            case 30: {
                return pSSysDataSyncAgentBase.getServiceParam2() == null;
            }
            case 31: {
                return pSSysDataSyncAgentBase.getServicePath() == null;
            }
            case 32: {
                return pSSysDataSyncAgentBase.getSyncDir() == null;
            }
            case 33: {
                return pSSysDataSyncAgentBase.getTopic() == null;
            }
            case 34: {
                return pSSysDataSyncAgentBase.getUpdateDate() == null;
            }
            case 35: {
                return pSSysDataSyncAgentBase.getUpdateMan() == null;
            }
            case 36: {
                return pSSysDataSyncAgentBase.getUserCat() == null;
            }
            case 37: {
                return pSSysDataSyncAgentBase.getUserTag() == null;
            }
            case 38: {
                return pSSysDataSyncAgentBase.getUserTag2() == null;
            }
            case 39: {
                return pSSysDataSyncAgentBase.getUserTag3() == null;
            }
            case 40: {
                return pSSysDataSyncAgentBase.getUserTag4() == null;
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
        return PSSysDataSyncAgentBase.contains(this, n);
    }

    private static boolean contains(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDataSyncAgentBase.isAgentParamsDirty();
            }
            case 1: {
                return pSSysDataSyncAgentBase.isAgentTagDirty();
            }
            case 2: {
                return pSSysDataSyncAgentBase.isAgentTag2Dirty();
            }
            case 3: {
                return pSSysDataSyncAgentBase.isAgentTypeDirty();
            }
            case 4: {
                return pSSysDataSyncAgentBase.isAuthClientIdDirty();
            }
            case 5: {
                return pSSysDataSyncAgentBase.isAuthClientSecretDirty();
            }
            case 6: {
                return pSSysDataSyncAgentBase.isAuthModeDirty();
            }
            case 7: {
                return pSSysDataSyncAgentBase.isAuthParamDirty();
            }
            case 8: {
                return pSSysDataSyncAgentBase.isAuthParam2Dirty();
            }
            case 9: {
                return pSSysDataSyncAgentBase.isCodeNameDirty();
            }
            case 10: {
                return pSSysDataSyncAgentBase.isCreateDateDirty();
            }
            case 11: {
                return pSSysDataSyncAgentBase.isCreateManDirty();
            }
            case 12: {
                return pSSysDataSyncAgentBase.isCustomCodeDirty();
            }
            case 13: {
                return pSSysDataSyncAgentBase.isCustomModeDirty();
            }
            case 14: {
                return pSSysDataSyncAgentBase.isGroupIdDirty();
            }
            case 15: {
                return pSSysDataSyncAgentBase.isMemoDirty();
            }
            case 16: {
                return pSSysDataSyncAgentBase.isPSModuleIdDirty();
            }
            case 17: {
                return pSSysDataSyncAgentBase.isPSModuleNameDirty();
            }
            case 18: {
                return pSSysDataSyncAgentBase.isPSSubSysServiceAPIIdDirty();
            }
            case 19: {
                return pSSysDataSyncAgentBase.isPSSubSysServiceAPINameDirty();
            }
            case 20: {
                return pSSysDataSyncAgentBase.isPSSysDataSyncAgentIdDirty();
            }
            case 21: {
                return pSSysDataSyncAgentBase.isPSSysDataSyncAgentNameDirty();
            }
            case 22: {
                return pSSysDataSyncAgentBase.isPSSysDynaModelIdDirty();
            }
            case 23: {
                return pSSysDataSyncAgentBase.isPSSysDynaModelNameDirty();
            }
            case 24: {
                return pSSysDataSyncAgentBase.isPSSysSFPluginIdDirty();
            }
            case 25: {
                return pSSysDataSyncAgentBase.isPSSysSFPluginNameDirty();
            }
            case 26: {
                return pSSysDataSyncAgentBase.isPSSystemIdDirty();
            }
            case 27: {
                return pSSysDataSyncAgentBase.isPSSystemNameDirty();
            }
            case 28: {
                return pSSysDataSyncAgentBase.isRawDataModeDirty();
            }
            case 29: {
                return pSSysDataSyncAgentBase.isServiceParamDirty();
            }
            case 30: {
                return pSSysDataSyncAgentBase.isServiceParam2Dirty();
            }
            case 31: {
                return pSSysDataSyncAgentBase.isServicePathDirty();
            }
            case 32: {
                return pSSysDataSyncAgentBase.isSyncDirDirty();
            }
            case 33: {
                return pSSysDataSyncAgentBase.isTopicDirty();
            }
            case 34: {
                return pSSysDataSyncAgentBase.isUpdateDateDirty();
            }
            case 35: {
                return pSSysDataSyncAgentBase.isUpdateManDirty();
            }
            case 36: {
                return pSSysDataSyncAgentBase.isUserCatDirty();
            }
            case 37: {
                return pSSysDataSyncAgentBase.isUserTagDirty();
            }
            case 38: {
                return pSSysDataSyncAgentBase.isUserTag2Dirty();
            }
            case 39: {
                return pSSysDataSyncAgentBase.isUserTag3Dirty();
            }
            case 40: {
                return pSSysDataSyncAgentBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDataSyncAgentBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDataSyncAgentBase.getAgentParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agentparams", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getAgentParams()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getAgentTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agenttag", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getAgentTag()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getAgentTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agenttag2", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getAgentTag2()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getAgentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agenttype", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getAgentType()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getAuthClientId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientid", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getAuthClientId()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getAuthClientSecret() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientsecret", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getAuthClientSecret()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getAuthMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authmode", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getAuthMode()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getAuthParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getAuthParam()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getAuthParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam2", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getAuthParam2()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupid", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getGroupId()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSubSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiname", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getPSSubSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSysDataSyncAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdatasyncagentid", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getPSSysDataSyncAgentId()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSysDataSyncAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdatasyncagentname", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getPSSysDataSyncAgentName()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getRawDataMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawdatamode", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getRawDataMode()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getServiceParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getServiceParam()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getServiceParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam2", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getServiceParam2()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getServicePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicepath", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getServicePath()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getSyncDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncdir", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getSyncDir()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getTopic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"topic", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getTopic()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysDataSyncAgentBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysDataSyncAgentBase.getJSONValue((Object)pSSysDataSyncAgentBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDataSyncAgentBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDataSyncAgentBase.getAgentParams() != null) {
            object = pSSysDataSyncAgentBase.getAgentParams();
            xmlNode.setAttribute(FIELD_AGENTPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSSysDataSyncAgentBase.getAgentTag() != null) {
            object = pSSysDataSyncAgentBase.getAgentTag();
            xmlNode.setAttribute(FIELD_AGENTTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysDataSyncAgentBase.getAgentTag2() != null) {
            object = pSSysDataSyncAgentBase.getAgentTag2();
            xmlNode.setAttribute(FIELD_AGENTTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysDataSyncAgentBase.getAgentType() != null) {
            object = pSSysDataSyncAgentBase.getAgentType();
            xmlNode.setAttribute(FIELD_AGENTTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysDataSyncAgentBase.getAuthClientId() != null) {
            object = pSSysDataSyncAgentBase.getAuthClientId();
            xmlNode.setAttribute(FIELD_AUTHCLIENTID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysDataSyncAgentBase.getAuthClientSecret() != null) {
            object = pSSysDataSyncAgentBase.getAuthClientSecret();
            xmlNode.setAttribute(FIELD_AUTHCLIENTSECRET, (String)(object == null ? "" : object));
        }
        if (bl || pSSysDataSyncAgentBase.getAuthMode() != null) {
            object = pSSysDataSyncAgentBase.getAuthMode();
            xmlNode.setAttribute(FIELD_AUTHMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysDataSyncAgentBase.getAuthParam() != null) {
            object = pSSysDataSyncAgentBase.getAuthParam();
            xmlNode.setAttribute(FIELD_AUTHPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSSysDataSyncAgentBase.getAuthParam2() != null) {
            object = pSSysDataSyncAgentBase.getAuthParam2();
            xmlNode.setAttribute(FIELD_AUTHPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysDataSyncAgentBase.getCodeName() != null) {
            object = pSSysDataSyncAgentBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getCreateDate() != null) {
            object = pSSysDataSyncAgentBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDataSyncAgentBase.getCreateMan() != null) {
            object = pSSysDataSyncAgentBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getCustomCode() != null) {
            object = pSSysDataSyncAgentBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getCustomMode() != null) {
            object = pSSysDataSyncAgentBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDataSyncAgentBase.getGroupId() != null) {
            object = pSSysDataSyncAgentBase.getGroupId();
            xmlNode.setAttribute(FIELD_GROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getMemo() != null) {
            object = pSSysDataSyncAgentBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getPSModuleId() != null) {
            object = pSSysDataSyncAgentBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getPSModuleName() != null) {
            object = pSSysDataSyncAgentBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSubSysServiceAPIId() != null) {
            object = pSSysDataSyncAgentBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSubSysServiceAPIName() != null) {
            object = pSSysDataSyncAgentBase.getPSSubSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSysDataSyncAgentId() != null) {
            object = pSSysDataSyncAgentBase.getPSSysDataSyncAgentId();
            xmlNode.setAttribute(FIELD_PSSYSDATASYNCAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSysDataSyncAgentName() != null) {
            object = pSSysDataSyncAgentBase.getPSSysDataSyncAgentName();
            xmlNode.setAttribute(FIELD_PSSYSDATASYNCAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSysDynaModelId() != null) {
            object = pSSysDataSyncAgentBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSysDynaModelName() != null) {
            object = pSSysDataSyncAgentBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSysSFPluginId() != null) {
            object = pSSysDataSyncAgentBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSysSFPluginName() != null) {
            object = pSSysDataSyncAgentBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSystemId() != null) {
            object = pSSysDataSyncAgentBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getPSSystemName() != null) {
            object = pSSysDataSyncAgentBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getRawDataMode() != null) {
            object = pSSysDataSyncAgentBase.getRawDataMode();
            xmlNode.setAttribute(FIELD_RAWDATAMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDataSyncAgentBase.getServiceParam() != null) {
            object = pSSysDataSyncAgentBase.getServiceParam();
            xmlNode.setAttribute(FIELD_SERVICEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getServiceParam2() != null) {
            object = pSSysDataSyncAgentBase.getServiceParam2();
            xmlNode.setAttribute(FIELD_SERVICEPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getServicePath() != null) {
            object = pSSysDataSyncAgentBase.getServicePath();
            xmlNode.setAttribute(FIELD_SERVICEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getSyncDir() != null) {
            object = pSSysDataSyncAgentBase.getSyncDir();
            xmlNode.setAttribute(FIELD_SYNCDIR, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getTopic() != null) {
            object = pSSysDataSyncAgentBase.getTopic();
            xmlNode.setAttribute(FIELD_TOPIC, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getUpdateDate() != null) {
            object = pSSysDataSyncAgentBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDataSyncAgentBase.getUpdateMan() != null) {
            object = pSSysDataSyncAgentBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getUserCat() != null) {
            object = pSSysDataSyncAgentBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getUserTag() != null) {
            object = pSSysDataSyncAgentBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getUserTag2() != null) {
            object = pSSysDataSyncAgentBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getUserTag3() != null) {
            object = pSSysDataSyncAgentBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDataSyncAgentBase.getUserTag4() != null) {
            object = pSSysDataSyncAgentBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDataSyncAgentBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDataSyncAgentBase.isAgentParamsDirty() && (bl || pSSysDataSyncAgentBase.getAgentParams() != null)) {
            iDataObject.set(FIELD_AGENTPARAMS, (Object)pSSysDataSyncAgentBase.getAgentParams());
        }
        if (pSSysDataSyncAgentBase.isAgentTagDirty() && (bl || pSSysDataSyncAgentBase.getAgentTag() != null)) {
            iDataObject.set(FIELD_AGENTTAG, (Object)pSSysDataSyncAgentBase.getAgentTag());
        }
        if (pSSysDataSyncAgentBase.isAgentTag2Dirty() && (bl || pSSysDataSyncAgentBase.getAgentTag2() != null)) {
            iDataObject.set(FIELD_AGENTTAG2, (Object)pSSysDataSyncAgentBase.getAgentTag2());
        }
        if (pSSysDataSyncAgentBase.isAgentTypeDirty() && (bl || pSSysDataSyncAgentBase.getAgentType() != null)) {
            iDataObject.set(FIELD_AGENTTYPE, (Object)pSSysDataSyncAgentBase.getAgentType());
        }
        if (pSSysDataSyncAgentBase.isAuthClientIdDirty() && (bl || pSSysDataSyncAgentBase.getAuthClientId() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTID, (Object)pSSysDataSyncAgentBase.getAuthClientId());
        }
        if (pSSysDataSyncAgentBase.isAuthClientSecretDirty() && (bl || pSSysDataSyncAgentBase.getAuthClientSecret() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTSECRET, (Object)pSSysDataSyncAgentBase.getAuthClientSecret());
        }
        if (pSSysDataSyncAgentBase.isAuthModeDirty() && (bl || pSSysDataSyncAgentBase.getAuthMode() != null)) {
            iDataObject.set(FIELD_AUTHMODE, (Object)pSSysDataSyncAgentBase.getAuthMode());
        }
        if (pSSysDataSyncAgentBase.isAuthParamDirty() && (bl || pSSysDataSyncAgentBase.getAuthParam() != null)) {
            iDataObject.set(FIELD_AUTHPARAM, (Object)pSSysDataSyncAgentBase.getAuthParam());
        }
        if (pSSysDataSyncAgentBase.isAuthParam2Dirty() && (bl || pSSysDataSyncAgentBase.getAuthParam2() != null)) {
            iDataObject.set(FIELD_AUTHPARAM2, (Object)pSSysDataSyncAgentBase.getAuthParam2());
        }
        if (pSSysDataSyncAgentBase.isCodeNameDirty() && (bl || pSSysDataSyncAgentBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysDataSyncAgentBase.getCodeName());
        }
        if (pSSysDataSyncAgentBase.isCreateDateDirty() && (bl || pSSysDataSyncAgentBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDataSyncAgentBase.getCreateDate());
        }
        if (pSSysDataSyncAgentBase.isCreateManDirty() && (bl || pSSysDataSyncAgentBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDataSyncAgentBase.getCreateMan());
        }
        if (pSSysDataSyncAgentBase.isCustomCodeDirty() && (bl || pSSysDataSyncAgentBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysDataSyncAgentBase.getCustomCode());
        }
        if (pSSysDataSyncAgentBase.isCustomModeDirty() && (bl || pSSysDataSyncAgentBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysDataSyncAgentBase.getCustomMode());
        }
        if (pSSysDataSyncAgentBase.isGroupIdDirty() && (bl || pSSysDataSyncAgentBase.getGroupId() != null)) {
            iDataObject.set(FIELD_GROUPID, (Object)pSSysDataSyncAgentBase.getGroupId());
        }
        if (pSSysDataSyncAgentBase.isMemoDirty() && (bl || pSSysDataSyncAgentBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDataSyncAgentBase.getMemo());
        }
        if (pSSysDataSyncAgentBase.isPSModuleIdDirty() && (bl || pSSysDataSyncAgentBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysDataSyncAgentBase.getPSModuleId());
        }
        if (pSSysDataSyncAgentBase.isPSModuleNameDirty() && (bl || pSSysDataSyncAgentBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysDataSyncAgentBase.getPSModuleName());
        }
        if (pSSysDataSyncAgentBase.isPSSubSysServiceAPIIdDirty() && (bl || pSSysDataSyncAgentBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSSysDataSyncAgentBase.getPSSubSysServiceAPIId());
        }
        if (pSSysDataSyncAgentBase.isPSSubSysServiceAPINameDirty() && (bl || pSSysDataSyncAgentBase.getPSSubSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPINAME, (Object)pSSysDataSyncAgentBase.getPSSubSysServiceAPIName());
        }
        if (pSSysDataSyncAgentBase.isPSSysDataSyncAgentIdDirty() && (bl || pSSysDataSyncAgentBase.getPSSysDataSyncAgentId() != null)) {
            iDataObject.set(FIELD_PSSYSDATASYNCAGENTID, (Object)pSSysDataSyncAgentBase.getPSSysDataSyncAgentId());
        }
        if (pSSysDataSyncAgentBase.isPSSysDataSyncAgentNameDirty() && (bl || pSSysDataSyncAgentBase.getPSSysDataSyncAgentName() != null)) {
            iDataObject.set(FIELD_PSSYSDATASYNCAGENTNAME, (Object)pSSysDataSyncAgentBase.getPSSysDataSyncAgentName());
        }
        if (pSSysDataSyncAgentBase.isPSSysDynaModelIdDirty() && (bl || pSSysDataSyncAgentBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysDataSyncAgentBase.getPSSysDynaModelId());
        }
        if (pSSysDataSyncAgentBase.isPSSysDynaModelNameDirty() && (bl || pSSysDataSyncAgentBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysDataSyncAgentBase.getPSSysDynaModelName());
        }
        if (pSSysDataSyncAgentBase.isPSSysSFPluginIdDirty() && (bl || pSSysDataSyncAgentBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysDataSyncAgentBase.getPSSysSFPluginId());
        }
        if (pSSysDataSyncAgentBase.isPSSysSFPluginNameDirty() && (bl || pSSysDataSyncAgentBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysDataSyncAgentBase.getPSSysSFPluginName());
        }
        if (pSSysDataSyncAgentBase.isPSSystemIdDirty() && (bl || pSSysDataSyncAgentBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysDataSyncAgentBase.getPSSystemId());
        }
        if (pSSysDataSyncAgentBase.isPSSystemNameDirty() && (bl || pSSysDataSyncAgentBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysDataSyncAgentBase.getPSSystemName());
        }
        if (pSSysDataSyncAgentBase.isRawDataModeDirty() && (bl || pSSysDataSyncAgentBase.getRawDataMode() != null)) {
            iDataObject.set(FIELD_RAWDATAMODE, (Object)pSSysDataSyncAgentBase.getRawDataMode());
        }
        if (pSSysDataSyncAgentBase.isServiceParamDirty() && (bl || pSSysDataSyncAgentBase.getServiceParam() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM, (Object)pSSysDataSyncAgentBase.getServiceParam());
        }
        if (pSSysDataSyncAgentBase.isServiceParam2Dirty() && (bl || pSSysDataSyncAgentBase.getServiceParam2() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM2, (Object)pSSysDataSyncAgentBase.getServiceParam2());
        }
        if (pSSysDataSyncAgentBase.isServicePathDirty() && (bl || pSSysDataSyncAgentBase.getServicePath() != null)) {
            iDataObject.set(FIELD_SERVICEPATH, (Object)pSSysDataSyncAgentBase.getServicePath());
        }
        if (pSSysDataSyncAgentBase.isSyncDirDirty() && (bl || pSSysDataSyncAgentBase.getSyncDir() != null)) {
            iDataObject.set(FIELD_SYNCDIR, (Object)pSSysDataSyncAgentBase.getSyncDir());
        }
        if (pSSysDataSyncAgentBase.isTopicDirty() && (bl || pSSysDataSyncAgentBase.getTopic() != null)) {
            iDataObject.set(FIELD_TOPIC, (Object)pSSysDataSyncAgentBase.getTopic());
        }
        if (pSSysDataSyncAgentBase.isUpdateDateDirty() && (bl || pSSysDataSyncAgentBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDataSyncAgentBase.getUpdateDate());
        }
        if (pSSysDataSyncAgentBase.isUpdateManDirty() && (bl || pSSysDataSyncAgentBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDataSyncAgentBase.getUpdateMan());
        }
        if (pSSysDataSyncAgentBase.isUserCatDirty() && (bl || pSSysDataSyncAgentBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysDataSyncAgentBase.getUserCat());
        }
        if (pSSysDataSyncAgentBase.isUserTagDirty() && (bl || pSSysDataSyncAgentBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysDataSyncAgentBase.getUserTag());
        }
        if (pSSysDataSyncAgentBase.isUserTag2Dirty() && (bl || pSSysDataSyncAgentBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysDataSyncAgentBase.getUserTag2());
        }
        if (pSSysDataSyncAgentBase.isUserTag3Dirty() && (bl || pSSysDataSyncAgentBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysDataSyncAgentBase.getUserTag3());
        }
        if (pSSysDataSyncAgentBase.isUserTag4Dirty() && (bl || pSSysDataSyncAgentBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysDataSyncAgentBase.getUserTag4());
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
        return PSSysDataSyncAgentBase.remove(this, n);
    }

    private static boolean remove(PSSysDataSyncAgentBase pSSysDataSyncAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDataSyncAgentBase.resetAgentParams();
                return true;
            }
            case 1: {
                pSSysDataSyncAgentBase.resetAgentTag();
                return true;
            }
            case 2: {
                pSSysDataSyncAgentBase.resetAgentTag2();
                return true;
            }
            case 3: {
                pSSysDataSyncAgentBase.resetAgentType();
                return true;
            }
            case 4: {
                pSSysDataSyncAgentBase.resetAuthClientId();
                return true;
            }
            case 5: {
                pSSysDataSyncAgentBase.resetAuthClientSecret();
                return true;
            }
            case 6: {
                pSSysDataSyncAgentBase.resetAuthMode();
                return true;
            }
            case 7: {
                pSSysDataSyncAgentBase.resetAuthParam();
                return true;
            }
            case 8: {
                pSSysDataSyncAgentBase.resetAuthParam2();
                return true;
            }
            case 9: {
                pSSysDataSyncAgentBase.resetCodeName();
                return true;
            }
            case 10: {
                pSSysDataSyncAgentBase.resetCreateDate();
                return true;
            }
            case 11: {
                pSSysDataSyncAgentBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSSysDataSyncAgentBase.resetCustomCode();
                return true;
            }
            case 13: {
                pSSysDataSyncAgentBase.resetCustomMode();
                return true;
            }
            case 14: {
                pSSysDataSyncAgentBase.resetGroupId();
                return true;
            }
            case 15: {
                pSSysDataSyncAgentBase.resetMemo();
                return true;
            }
            case 16: {
                pSSysDataSyncAgentBase.resetPSModuleId();
                return true;
            }
            case 17: {
                pSSysDataSyncAgentBase.resetPSModuleName();
                return true;
            }
            case 18: {
                pSSysDataSyncAgentBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 19: {
                pSSysDataSyncAgentBase.resetPSSubSysServiceAPIName();
                return true;
            }
            case 20: {
                pSSysDataSyncAgentBase.resetPSSysDataSyncAgentId();
                return true;
            }
            case 21: {
                pSSysDataSyncAgentBase.resetPSSysDataSyncAgentName();
                return true;
            }
            case 22: {
                pSSysDataSyncAgentBase.resetPSSysDynaModelId();
                return true;
            }
            case 23: {
                pSSysDataSyncAgentBase.resetPSSysDynaModelName();
                return true;
            }
            case 24: {
                pSSysDataSyncAgentBase.resetPSSysSFPluginId();
                return true;
            }
            case 25: {
                pSSysDataSyncAgentBase.resetPSSysSFPluginName();
                return true;
            }
            case 26: {
                pSSysDataSyncAgentBase.resetPSSystemId();
                return true;
            }
            case 27: {
                pSSysDataSyncAgentBase.resetPSSystemName();
                return true;
            }
            case 28: {
                pSSysDataSyncAgentBase.resetRawDataMode();
                return true;
            }
            case 29: {
                pSSysDataSyncAgentBase.resetServiceParam();
                return true;
            }
            case 30: {
                pSSysDataSyncAgentBase.resetServiceParam2();
                return true;
            }
            case 31: {
                pSSysDataSyncAgentBase.resetServicePath();
                return true;
            }
            case 32: {
                pSSysDataSyncAgentBase.resetSyncDir();
                return true;
            }
            case 33: {
                pSSysDataSyncAgentBase.resetTopic();
                return true;
            }
            case 34: {
                pSSysDataSyncAgentBase.resetUpdateDate();
                return true;
            }
            case 35: {
                pSSysDataSyncAgentBase.resetUpdateMan();
                return true;
            }
            case 36: {
                pSSysDataSyncAgentBase.resetUserCat();
                return true;
            }
            case 37: {
                pSSysDataSyncAgentBase.resetUserTag();
                return true;
            }
            case 38: {
                pSSysDataSyncAgentBase.resetUserTag2();
                return true;
            }
            case 39: {
                pSSysDataSyncAgentBase.resetUserTag3();
                return true;
            }
            case 40: {
                pSSysDataSyncAgentBase.resetUserTag4();
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

    private PSSysDataSyncAgentBase getProxyEntity() {
        return this.proxyPSSysDataSyncAgentBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDataSyncAgentBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDataSyncAgentBase) {
            this.proxyPSSysDataSyncAgentBase = (PSSysDataSyncAgentBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDataSyncAgentService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AGENTPARAMS, 0);
        fieldIndexMap.put(FIELD_AGENTTAG, 1);
        fieldIndexMap.put(FIELD_AGENTTAG2, 2);
        fieldIndexMap.put(FIELD_AGENTTYPE, 3);
        fieldIndexMap.put(FIELD_AUTHCLIENTID, 4);
        fieldIndexMap.put(FIELD_AUTHCLIENTSECRET, 5);
        fieldIndexMap.put(FIELD_AUTHMODE, 6);
        fieldIndexMap.put(FIELD_AUTHPARAM, 7);
        fieldIndexMap.put(FIELD_AUTHPARAM2, 8);
        fieldIndexMap.put(FIELD_CODENAME, 9);
        fieldIndexMap.put(FIELD_CREATEDATE, 10);
        fieldIndexMap.put(FIELD_CREATEMAN, 11);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 12);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 13);
        fieldIndexMap.put(FIELD_GROUPID, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_PSMODULEID, 16);
        fieldIndexMap.put(FIELD_PSMODULENAME, 17);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 18);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPINAME, 19);
        fieldIndexMap.put(FIELD_PSSYSDATASYNCAGENTID, 20);
        fieldIndexMap.put(FIELD_PSSYSDATASYNCAGENTNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 22);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 24);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 25);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 26);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 27);
        fieldIndexMap.put(FIELD_RAWDATAMODE, 28);
        fieldIndexMap.put(FIELD_SERVICEPARAM, 29);
        fieldIndexMap.put(FIELD_SERVICEPARAM2, 30);
        fieldIndexMap.put(FIELD_SERVICEPATH, 31);
        fieldIndexMap.put(FIELD_SYNCDIR, 32);
        fieldIndexMap.put(FIELD_TOPIC, 33);
        fieldIndexMap.put(FIELD_UPDATEDATE, 34);
        fieldIndexMap.put(FIELD_UPDATEMAN, 35);
        fieldIndexMap.put(FIELD_USERCAT, 36);
        fieldIndexMap.put(FIELD_USERTAG, 37);
        fieldIndexMap.put(FIELD_USERTAG2, 38);
        fieldIndexMap.put(FIELD_USERTAG3, 39);
        fieldIndexMap.put(FIELD_USERTAG4, 40);
    }
}

