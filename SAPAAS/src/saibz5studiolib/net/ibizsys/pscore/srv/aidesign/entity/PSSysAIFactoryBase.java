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
package net.ibizsys.pscore.srv.aidesign.entity;

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
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIChatAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIWorkerAgent;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIChatAgentService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineAgentService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIWorkerAgentService;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysAIFactoryBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysAIFactoryBase.class);
    public static final String FIELD_AIFACTORYPARAMS = "AIFACTORYPARAMS";
    public static final String FIELD_AIFACTORYTAG = "AIFACTORYTAG";
    public static final String FIELD_AIFACTORYTAG2 = "AIFACTORYTAG2";
    public static final String FIELD_AIFACTORYTYPE = "AIFACTORYTYPE";
    public static final String FIELD_AIPLATFORMTYPE = "AIPLATFORMTYPE";
    public static final String FIELD_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String FIELD_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String FIELD_AUTHMODE = "AUTHMODE";
    public static final String FIELD_AUTHPARAM = "AUTHPARAM";
    public static final String FIELD_AUTHPARAM2 = "AUTHPARAM2";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSAIFACTORYID = "PSSYSAIFACTORYID";
    public static final String FIELD_PSSYSAIFACTORYNAME = "PSSYSAIFACTORYNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_SERVICEPARAM = "SERVICEPARAM";
    public static final String FIELD_SERVICEPARAM2 = "SERVICEPARAM2";
    public static final String FIELD_SERVICEPATH = "SERVICEPATH";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_AIFACTORYPARAMS = 0;
    private static final int INDEX_AIFACTORYTAG = 1;
    private static final int INDEX_AIFACTORYTAG2 = 2;
    private static final int INDEX_AIFACTORYTYPE = 3;
    private static final int INDEX_AIPLATFORMTYPE = 4;
    private static final int INDEX_AUTHCLIENTID = 5;
    private static final int INDEX_AUTHCLIENTSECRET = 6;
    private static final int INDEX_AUTHMODE = 7;
    private static final int INDEX_AUTHPARAM = 8;
    private static final int INDEX_AUTHPARAM2 = 9;
    private static final int INDEX_CODENAME = 10;
    private static final int INDEX_CREATEDATE = 11;
    private static final int INDEX_CREATEMAN = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_ORDERVALUE = 14;
    private static final int INDEX_PSMODULEID = 15;
    private static final int INDEX_PSMODULENAME = 16;
    private static final int INDEX_PSSYSAIFACTORYID = 17;
    private static final int INDEX_PSSYSAIFACTORYNAME = 18;
    private static final int INDEX_PSSYSDYNAMODELID = 19;
    private static final int INDEX_PSSYSDYNAMODELNAME = 20;
    private static final int INDEX_PSSYSRESOURCEID = 21;
    private static final int INDEX_PSSYSRESOURCENAME = 22;
    private static final int INDEX_PSSYSSFPLUGINID = 23;
    private static final int INDEX_PSSYSSFPLUGINNAME = 24;
    private static final int INDEX_PSSYSTEMID = 25;
    private static final int INDEX_PSSYSTEMNAME = 26;
    private static final int INDEX_SERVICEPARAM = 27;
    private static final int INDEX_SERVICEPARAM2 = 28;
    private static final int INDEX_SERVICEPATH = 29;
    private static final int INDEX_UPDATEDATE = 30;
    private static final int INDEX_UPDATEMAN = 31;
    private static final int INDEX_USERCAT = 32;
    private static final int INDEX_USERTAG = 33;
    private static final int INDEX_USERTAG2 = 34;
    private static final int INDEX_USERTAG3 = 35;
    private static final int INDEX_USERTAG4 = 36;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysAIFactoryBase proxyPSSysAIFactoryBase = null;
    private boolean aifactoryparamsDirtyFlag = false;
    private boolean aifactorytagDirtyFlag = false;
    private boolean aifactorytag2DirtyFlag = false;
    private boolean aifactorytypeDirtyFlag = false;
    private boolean aiplatformtypeDirtyFlag = false;
    private boolean authclientidDirtyFlag = false;
    private boolean authclientsecretDirtyFlag = false;
    private boolean authmodeDirtyFlag = false;
    private boolean authparamDirtyFlag = false;
    private boolean authparam2DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysaifactoryidDirtyFlag = false;
    private boolean pssysaifactorynameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean serviceparamDirtyFlag = false;
    private boolean serviceparam2DirtyFlag = false;
    private boolean servicepathDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="aifactoryparams")
    private String aifactoryparams;
    @Column(name="aifactorytag")
    private String aifactorytag;
    @Column(name="aifactorytag2")
    private String aifactorytag2;
    @Column(name="aifactorytype")
    private String aifactorytype;
    @Column(name="aiplatformtype")
    private String aiplatformtype;
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
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysaifactoryid")
    private String pssysaifactoryid;
    @Column(name="pssysaifactoryname")
    private String pssysaifactoryname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="serviceparam")
    private String serviceparam;
    @Column(name="serviceparam2")
    private String serviceparam2;
    @Column(name="servicepath")
    private String servicepath;
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
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysAIChatAgentsLock = new Integer(1);
    private ArrayList<PSSysAIChatAgent> pssysaichatagents = null;
    private Integer objPSSysAIPipelineAgentsLock = new Integer(1);
    private ArrayList<PSSysAIPipelineAgent> pssysaipipelineagents = null;
    private Integer objPSSysAIWorkerAgentsLock = new Integer(1);
    private ArrayList<PSSysAIWorkerAgent> pssysaiworkeragents = null;

    public void setAIFactoryParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIFactoryParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aifactoryparams = string;
        this.aifactoryparamsDirtyFlag = true;
    }

    public String getAIFactoryParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIFactoryParams();
        }
        return this.aifactoryparams;
    }

    public boolean isAIFactoryParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIFactoryParamsDirty();
        }
        return this.aifactoryparamsDirtyFlag;
    }

    public void resetAIFactoryParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIFactoryParams();
            return;
        }
        this.aifactoryparamsDirtyFlag = false;
        this.aifactoryparams = null;
    }

    public void setAIFactoryTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIFactoryTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aifactorytag = string;
        this.aifactorytagDirtyFlag = true;
    }

    public String getAIFactoryTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIFactoryTag();
        }
        return this.aifactorytag;
    }

    public boolean isAIFactoryTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIFactoryTagDirty();
        }
        return this.aifactorytagDirtyFlag;
    }

    public void resetAIFactoryTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIFactoryTag();
            return;
        }
        this.aifactorytagDirtyFlag = false;
        this.aifactorytag = null;
    }

    public void setAIFactoryTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIFactoryTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aifactorytag2 = string;
        this.aifactorytag2DirtyFlag = true;
    }

    public String getAIFactoryTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIFactoryTag2();
        }
        return this.aifactorytag2;
    }

    public boolean isAIFactoryTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIFactoryTag2Dirty();
        }
        return this.aifactorytag2DirtyFlag;
    }

    public void resetAIFactoryTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIFactoryTag2();
            return;
        }
        this.aifactorytag2DirtyFlag = false;
        this.aifactorytag2 = null;
    }

    public void setAIFactoryType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIFactoryType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aifactorytype = string;
        this.aifactorytypeDirtyFlag = true;
    }

    public String getAIFactoryType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIFactoryType();
        }
        return this.aifactorytype;
    }

    public boolean isAIFactoryTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIFactoryTypeDirty();
        }
        return this.aifactorytypeDirtyFlag;
    }

    public void resetAIFactoryType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIFactoryType();
            return;
        }
        this.aifactorytypeDirtyFlag = false;
        this.aifactorytype = null;
    }

    public void setAIPlatformType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIPlatformType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aiplatformtype = string;
        this.aiplatformtypeDirtyFlag = true;
    }

    public String getAIPlatformType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIPlatformType();
        }
        return this.aiplatformtype;
    }

    public boolean isAIPlatformTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIPlatformTypeDirty();
        }
        return this.aiplatformtypeDirtyFlag;
    }

    public void resetAIPlatformType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIPlatformType();
            return;
        }
        this.aiplatformtypeDirtyFlag = false;
        this.aiplatformtype = null;
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

    public void setPSSysAIFactoryId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIFactoryId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaifactoryid = string;
        this.pssysaifactoryidDirtyFlag = true;
    }

    public String getPSSysAIFactoryId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIFactoryId();
        }
        return this.pssysaifactoryid;
    }

    public boolean isPSSysAIFactoryIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIFactoryIdDirty();
        }
        return this.pssysaifactoryidDirtyFlag;
    }

    public void resetPSSysAIFactoryId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIFactoryId();
            return;
        }
        this.pssysaifactoryidDirtyFlag = false;
        this.pssysaifactoryid = null;
    }

    public void setPSSysAIFactoryName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIFactoryName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaifactoryname = string;
        this.pssysaifactorynameDirtyFlag = true;
    }

    public String getPSSysAIFactoryName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIFactoryName();
        }
        return this.pssysaifactoryname;
    }

    public boolean isPSSysAIFactoryNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIFactoryNameDirty();
        }
        return this.pssysaifactorynameDirtyFlag;
    }

    public void resetPSSysAIFactoryName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIFactoryName();
            return;
        }
        this.pssysaifactorynameDirtyFlag = false;
        this.pssysaifactoryname = null;
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

    public void setPSSysResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourceid = string;
        this.pssysresourceidDirtyFlag = true;
    }

    public String getPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceId();
        }
        return this.pssysresourceid;
    }

    public boolean isPSSysResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceIdDirty();
        }
        return this.pssysresourceidDirtyFlag;
    }

    public void resetPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceId();
            return;
        }
        this.pssysresourceidDirtyFlag = false;
        this.pssysresourceid = null;
    }

    public void setPSSysResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourcename = string;
        this.pssysresourcenameDirtyFlag = true;
    }

    public String getPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceName();
        }
        return this.pssysresourcename;
    }

    public boolean isPSSysResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceNameDirty();
        }
        return this.pssysresourcenameDirtyFlag;
    }

    public void resetPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceName();
            return;
        }
        this.pssysresourcenameDirtyFlag = false;
        this.pssysresourcename = null;
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
        PSSysAIFactoryBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysAIFactoryBase pSSysAIFactoryBase) {
        pSSysAIFactoryBase.resetAIFactoryParams();
        pSSysAIFactoryBase.resetAIFactoryTag();
        pSSysAIFactoryBase.resetAIFactoryTag2();
        pSSysAIFactoryBase.resetAIFactoryType();
        pSSysAIFactoryBase.resetAIPlatformType();
        pSSysAIFactoryBase.resetAuthClientId();
        pSSysAIFactoryBase.resetAuthClientSecret();
        pSSysAIFactoryBase.resetAuthMode();
        pSSysAIFactoryBase.resetAuthParam();
        pSSysAIFactoryBase.resetAuthParam2();
        pSSysAIFactoryBase.resetCodeName();
        pSSysAIFactoryBase.resetCreateDate();
        pSSysAIFactoryBase.resetCreateMan();
        pSSysAIFactoryBase.resetMemo();
        pSSysAIFactoryBase.resetOrderValue();
        pSSysAIFactoryBase.resetPSModuleId();
        pSSysAIFactoryBase.resetPSModuleName();
        pSSysAIFactoryBase.resetPSSysAIFactoryId();
        pSSysAIFactoryBase.resetPSSysAIFactoryName();
        pSSysAIFactoryBase.resetPSSysDynaModelId();
        pSSysAIFactoryBase.resetPSSysDynaModelName();
        pSSysAIFactoryBase.resetPSSysResourceId();
        pSSysAIFactoryBase.resetPSSysResourceName();
        pSSysAIFactoryBase.resetPSSysSFPluginId();
        pSSysAIFactoryBase.resetPSSysSFPluginName();
        pSSysAIFactoryBase.resetPSSystemId();
        pSSysAIFactoryBase.resetPSSystemName();
        pSSysAIFactoryBase.resetServiceParam();
        pSSysAIFactoryBase.resetServiceParam2();
        pSSysAIFactoryBase.resetServicePath();
        pSSysAIFactoryBase.resetUpdateDate();
        pSSysAIFactoryBase.resetUpdateMan();
        pSSysAIFactoryBase.resetUserCat();
        pSSysAIFactoryBase.resetUserTag();
        pSSysAIFactoryBase.resetUserTag2();
        pSSysAIFactoryBase.resetUserTag3();
        pSSysAIFactoryBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAIFactoryParamsDirty()) {
            hashMap.put(FIELD_AIFACTORYPARAMS, this.getAIFactoryParams());
        }
        if (!bl || this.isAIFactoryTagDirty()) {
            hashMap.put(FIELD_AIFACTORYTAG, this.getAIFactoryTag());
        }
        if (!bl || this.isAIFactoryTag2Dirty()) {
            hashMap.put(FIELD_AIFACTORYTAG2, this.getAIFactoryTag2());
        }
        if (!bl || this.isAIFactoryTypeDirty()) {
            hashMap.put(FIELD_AIFACTORYTYPE, this.getAIFactoryType());
        }
        if (!bl || this.isAIPlatformTypeDirty()) {
            hashMap.put(FIELD_AIPLATFORMTYPE, this.getAIPlatformType());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
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
        if (!bl || this.isPSSysAIFactoryIdDirty()) {
            hashMap.put(FIELD_PSSYSAIFACTORYID, this.getPSSysAIFactoryId());
        }
        if (!bl || this.isPSSysAIFactoryNameDirty()) {
            hashMap.put(FIELD_PSSYSAIFACTORYNAME, this.getPSSysAIFactoryName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysResourceIdDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCEID, this.getPSSysResourceId());
        }
        if (!bl || this.isPSSysResourceNameDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCENAME, this.getPSSysResourceName());
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
        if (!bl || this.isServiceParamDirty()) {
            hashMap.put(FIELD_SERVICEPARAM, this.getServiceParam());
        }
        if (!bl || this.isServiceParam2Dirty()) {
            hashMap.put(FIELD_SERVICEPARAM2, this.getServiceParam2());
        }
        if (!bl || this.isServicePathDirty()) {
            hashMap.put(FIELD_SERVICEPATH, this.getServicePath());
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
        return PSSysAIFactoryBase.get(this, n);
    }

    private static Object get(PSSysAIFactoryBase pSSysAIFactoryBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIFactoryBase.getAIFactoryParams();
            }
            case 1: {
                return pSSysAIFactoryBase.getAIFactoryTag();
            }
            case 2: {
                return pSSysAIFactoryBase.getAIFactoryTag2();
            }
            case 3: {
                return pSSysAIFactoryBase.getAIFactoryType();
            }
            case 4: {
                return pSSysAIFactoryBase.getAIPlatformType();
            }
            case 5: {
                return pSSysAIFactoryBase.getAuthClientId();
            }
            case 6: {
                return pSSysAIFactoryBase.getAuthClientSecret();
            }
            case 7: {
                return pSSysAIFactoryBase.getAuthMode();
            }
            case 8: {
                return pSSysAIFactoryBase.getAuthParam();
            }
            case 9: {
                return pSSysAIFactoryBase.getAuthParam2();
            }
            case 10: {
                return pSSysAIFactoryBase.getCodeName();
            }
            case 11: {
                return pSSysAIFactoryBase.getCreateDate();
            }
            case 12: {
                return pSSysAIFactoryBase.getCreateMan();
            }
            case 13: {
                return pSSysAIFactoryBase.getMemo();
            }
            case 14: {
                return pSSysAIFactoryBase.getOrderValue();
            }
            case 15: {
                return pSSysAIFactoryBase.getPSModuleId();
            }
            case 16: {
                return pSSysAIFactoryBase.getPSModuleName();
            }
            case 17: {
                return pSSysAIFactoryBase.getPSSysAIFactoryId();
            }
            case 18: {
                return pSSysAIFactoryBase.getPSSysAIFactoryName();
            }
            case 19: {
                return pSSysAIFactoryBase.getPSSysDynaModelId();
            }
            case 20: {
                return pSSysAIFactoryBase.getPSSysDynaModelName();
            }
            case 21: {
                return pSSysAIFactoryBase.getPSSysResourceId();
            }
            case 22: {
                return pSSysAIFactoryBase.getPSSysResourceName();
            }
            case 23: {
                return pSSysAIFactoryBase.getPSSysSFPluginId();
            }
            case 24: {
                return pSSysAIFactoryBase.getPSSysSFPluginName();
            }
            case 25: {
                return pSSysAIFactoryBase.getPSSystemId();
            }
            case 26: {
                return pSSysAIFactoryBase.getPSSystemName();
            }
            case 27: {
                return pSSysAIFactoryBase.getServiceParam();
            }
            case 28: {
                return pSSysAIFactoryBase.getServiceParam2();
            }
            case 29: {
                return pSSysAIFactoryBase.getServicePath();
            }
            case 30: {
                return pSSysAIFactoryBase.getUpdateDate();
            }
            case 31: {
                return pSSysAIFactoryBase.getUpdateMan();
            }
            case 32: {
                return pSSysAIFactoryBase.getUserCat();
            }
            case 33: {
                return pSSysAIFactoryBase.getUserTag();
            }
            case 34: {
                return pSSysAIFactoryBase.getUserTag2();
            }
            case 35: {
                return pSSysAIFactoryBase.getUserTag3();
            }
            case 36: {
                return pSSysAIFactoryBase.getUserTag4();
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
        PSSysAIFactoryBase.set(this, n, object);
    }

    private static void set(PSSysAIFactoryBase pSSysAIFactoryBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysAIFactoryBase.setAIFactoryParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysAIFactoryBase.setAIFactoryTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysAIFactoryBase.setAIFactoryTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysAIFactoryBase.setAIFactoryType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysAIFactoryBase.setAIPlatformType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysAIFactoryBase.setAuthClientId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysAIFactoryBase.setAuthClientSecret(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysAIFactoryBase.setAuthMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysAIFactoryBase.setAuthParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysAIFactoryBase.setAuthParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysAIFactoryBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysAIFactoryBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSysAIFactoryBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysAIFactoryBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysAIFactoryBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSysAIFactoryBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysAIFactoryBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysAIFactoryBase.setPSSysAIFactoryId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysAIFactoryBase.setPSSysAIFactoryName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysAIFactoryBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysAIFactoryBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysAIFactoryBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysAIFactoryBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysAIFactoryBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysAIFactoryBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysAIFactoryBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysAIFactoryBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysAIFactoryBase.setServiceParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysAIFactoryBase.setServiceParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysAIFactoryBase.setServicePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysAIFactoryBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 31: {
                pSSysAIFactoryBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysAIFactoryBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysAIFactoryBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysAIFactoryBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysAIFactoryBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysAIFactoryBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysAIFactoryBase.isNull(this, n);
    }

    private static boolean isNull(PSSysAIFactoryBase pSSysAIFactoryBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIFactoryBase.getAIFactoryParams() == null;
            }
            case 1: {
                return pSSysAIFactoryBase.getAIFactoryTag() == null;
            }
            case 2: {
                return pSSysAIFactoryBase.getAIFactoryTag2() == null;
            }
            case 3: {
                return pSSysAIFactoryBase.getAIFactoryType() == null;
            }
            case 4: {
                return pSSysAIFactoryBase.getAIPlatformType() == null;
            }
            case 5: {
                return pSSysAIFactoryBase.getAuthClientId() == null;
            }
            case 6: {
                return pSSysAIFactoryBase.getAuthClientSecret() == null;
            }
            case 7: {
                return pSSysAIFactoryBase.getAuthMode() == null;
            }
            case 8: {
                return pSSysAIFactoryBase.getAuthParam() == null;
            }
            case 9: {
                return pSSysAIFactoryBase.getAuthParam2() == null;
            }
            case 10: {
                return pSSysAIFactoryBase.getCodeName() == null;
            }
            case 11: {
                return pSSysAIFactoryBase.getCreateDate() == null;
            }
            case 12: {
                return pSSysAIFactoryBase.getCreateMan() == null;
            }
            case 13: {
                return pSSysAIFactoryBase.getMemo() == null;
            }
            case 14: {
                return pSSysAIFactoryBase.getOrderValue() == null;
            }
            case 15: {
                return pSSysAIFactoryBase.getPSModuleId() == null;
            }
            case 16: {
                return pSSysAIFactoryBase.getPSModuleName() == null;
            }
            case 17: {
                return pSSysAIFactoryBase.getPSSysAIFactoryId() == null;
            }
            case 18: {
                return pSSysAIFactoryBase.getPSSysAIFactoryName() == null;
            }
            case 19: {
                return pSSysAIFactoryBase.getPSSysDynaModelId() == null;
            }
            case 20: {
                return pSSysAIFactoryBase.getPSSysDynaModelName() == null;
            }
            case 21: {
                return pSSysAIFactoryBase.getPSSysResourceId() == null;
            }
            case 22: {
                return pSSysAIFactoryBase.getPSSysResourceName() == null;
            }
            case 23: {
                return pSSysAIFactoryBase.getPSSysSFPluginId() == null;
            }
            case 24: {
                return pSSysAIFactoryBase.getPSSysSFPluginName() == null;
            }
            case 25: {
                return pSSysAIFactoryBase.getPSSystemId() == null;
            }
            case 26: {
                return pSSysAIFactoryBase.getPSSystemName() == null;
            }
            case 27: {
                return pSSysAIFactoryBase.getServiceParam() == null;
            }
            case 28: {
                return pSSysAIFactoryBase.getServiceParam2() == null;
            }
            case 29: {
                return pSSysAIFactoryBase.getServicePath() == null;
            }
            case 30: {
                return pSSysAIFactoryBase.getUpdateDate() == null;
            }
            case 31: {
                return pSSysAIFactoryBase.getUpdateMan() == null;
            }
            case 32: {
                return pSSysAIFactoryBase.getUserCat() == null;
            }
            case 33: {
                return pSSysAIFactoryBase.getUserTag() == null;
            }
            case 34: {
                return pSSysAIFactoryBase.getUserTag2() == null;
            }
            case 35: {
                return pSSysAIFactoryBase.getUserTag3() == null;
            }
            case 36: {
                return pSSysAIFactoryBase.getUserTag4() == null;
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
        return PSSysAIFactoryBase.contains(this, n);
    }

    private static boolean contains(PSSysAIFactoryBase pSSysAIFactoryBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIFactoryBase.isAIFactoryParamsDirty();
            }
            case 1: {
                return pSSysAIFactoryBase.isAIFactoryTagDirty();
            }
            case 2: {
                return pSSysAIFactoryBase.isAIFactoryTag2Dirty();
            }
            case 3: {
                return pSSysAIFactoryBase.isAIFactoryTypeDirty();
            }
            case 4: {
                return pSSysAIFactoryBase.isAIPlatformTypeDirty();
            }
            case 5: {
                return pSSysAIFactoryBase.isAuthClientIdDirty();
            }
            case 6: {
                return pSSysAIFactoryBase.isAuthClientSecretDirty();
            }
            case 7: {
                return pSSysAIFactoryBase.isAuthModeDirty();
            }
            case 8: {
                return pSSysAIFactoryBase.isAuthParamDirty();
            }
            case 9: {
                return pSSysAIFactoryBase.isAuthParam2Dirty();
            }
            case 10: {
                return pSSysAIFactoryBase.isCodeNameDirty();
            }
            case 11: {
                return pSSysAIFactoryBase.isCreateDateDirty();
            }
            case 12: {
                return pSSysAIFactoryBase.isCreateManDirty();
            }
            case 13: {
                return pSSysAIFactoryBase.isMemoDirty();
            }
            case 14: {
                return pSSysAIFactoryBase.isOrderValueDirty();
            }
            case 15: {
                return pSSysAIFactoryBase.isPSModuleIdDirty();
            }
            case 16: {
                return pSSysAIFactoryBase.isPSModuleNameDirty();
            }
            case 17: {
                return pSSysAIFactoryBase.isPSSysAIFactoryIdDirty();
            }
            case 18: {
                return pSSysAIFactoryBase.isPSSysAIFactoryNameDirty();
            }
            case 19: {
                return pSSysAIFactoryBase.isPSSysDynaModelIdDirty();
            }
            case 20: {
                return pSSysAIFactoryBase.isPSSysDynaModelNameDirty();
            }
            case 21: {
                return pSSysAIFactoryBase.isPSSysResourceIdDirty();
            }
            case 22: {
                return pSSysAIFactoryBase.isPSSysResourceNameDirty();
            }
            case 23: {
                return pSSysAIFactoryBase.isPSSysSFPluginIdDirty();
            }
            case 24: {
                return pSSysAIFactoryBase.isPSSysSFPluginNameDirty();
            }
            case 25: {
                return pSSysAIFactoryBase.isPSSystemIdDirty();
            }
            case 26: {
                return pSSysAIFactoryBase.isPSSystemNameDirty();
            }
            case 27: {
                return pSSysAIFactoryBase.isServiceParamDirty();
            }
            case 28: {
                return pSSysAIFactoryBase.isServiceParam2Dirty();
            }
            case 29: {
                return pSSysAIFactoryBase.isServicePathDirty();
            }
            case 30: {
                return pSSysAIFactoryBase.isUpdateDateDirty();
            }
            case 31: {
                return pSSysAIFactoryBase.isUpdateManDirty();
            }
            case 32: {
                return pSSysAIFactoryBase.isUserCatDirty();
            }
            case 33: {
                return pSSysAIFactoryBase.isUserTagDirty();
            }
            case 34: {
                return pSSysAIFactoryBase.isUserTag2Dirty();
            }
            case 35: {
                return pSSysAIFactoryBase.isUserTag3Dirty();
            }
            case 36: {
                return pSSysAIFactoryBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysAIFactoryBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysAIFactoryBase pSSysAIFactoryBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysAIFactoryBase.getAIFactoryParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aifactoryparams", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getAIFactoryParams()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getAIFactoryTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aifactorytag", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getAIFactoryTag()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getAIFactoryTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aifactorytag2", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getAIFactoryTag2()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getAIFactoryType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aifactorytype", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getAIFactoryType()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getAIPlatformType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aiplatformtype", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getAIPlatformType()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getAuthClientId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientid", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getAuthClientId()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getAuthClientSecret() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authclientsecret", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getAuthClientSecret()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getAuthMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authmode", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getAuthMode()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getAuthParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getAuthParam()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getAuthParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"authparam2", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getAuthParam2()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getPSSysAIFactoryId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryid", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getPSSysAIFactoryId()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getPSSysAIFactoryName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryname", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getPSSysAIFactoryName()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getServiceParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getServiceParam()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getServiceParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceparam2", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getServiceParam2()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getServicePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicepath", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getServicePath()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysAIFactoryBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysAIFactoryBase.getJSONValue((Object)pSSysAIFactoryBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysAIFactoryBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysAIFactoryBase pSSysAIFactoryBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysAIFactoryBase.getAIFactoryParams() != null) {
            object = pSSysAIFactoryBase.getAIFactoryParams();
            xmlNode.setAttribute(FIELD_AIFACTORYPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIFactoryBase.getAIFactoryTag() != null) {
            object = pSSysAIFactoryBase.getAIFactoryTag();
            xmlNode.setAttribute(FIELD_AIFACTORYTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIFactoryBase.getAIFactoryTag2() != null) {
            object = pSSysAIFactoryBase.getAIFactoryTag2();
            xmlNode.setAttribute(FIELD_AIFACTORYTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIFactoryBase.getAIFactoryType() != null) {
            object = pSSysAIFactoryBase.getAIFactoryType();
            xmlNode.setAttribute(FIELD_AIFACTORYTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIFactoryBase.getAIPlatformType() != null) {
            object = pSSysAIFactoryBase.getAIPlatformType();
            xmlNode.setAttribute(FIELD_AIPLATFORMTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIFactoryBase.getAuthClientId() != null) {
            object = pSSysAIFactoryBase.getAuthClientId();
            xmlNode.setAttribute(FIELD_AUTHCLIENTID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIFactoryBase.getAuthClientSecret() != null) {
            object = pSSysAIFactoryBase.getAuthClientSecret();
            xmlNode.setAttribute(FIELD_AUTHCLIENTSECRET, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIFactoryBase.getAuthMode() != null) {
            object = pSSysAIFactoryBase.getAuthMode();
            xmlNode.setAttribute(FIELD_AUTHMODE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIFactoryBase.getAuthParam() != null) {
            object = pSSysAIFactoryBase.getAuthParam();
            xmlNode.setAttribute(FIELD_AUTHPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIFactoryBase.getAuthParam2() != null) {
            object = pSSysAIFactoryBase.getAuthParam2();
            xmlNode.setAttribute(FIELD_AUTHPARAM2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIFactoryBase.getCodeName() != null) {
            object = pSSysAIFactoryBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getCreateDate() != null) {
            object = pSSysAIFactoryBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysAIFactoryBase.getCreateMan() != null) {
            object = pSSysAIFactoryBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getMemo() != null) {
            object = pSSysAIFactoryBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getOrderValue() != null) {
            object = pSSysAIFactoryBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAIFactoryBase.getPSModuleId() != null) {
            object = pSSysAIFactoryBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getPSModuleName() != null) {
            object = pSSysAIFactoryBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getPSSysAIFactoryId() != null) {
            object = pSSysAIFactoryBase.getPSSysAIFactoryId();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getPSSysAIFactoryName() != null) {
            object = pSSysAIFactoryBase.getPSSysAIFactoryName();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getPSSysDynaModelId() != null) {
            object = pSSysAIFactoryBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getPSSysDynaModelName() != null) {
            object = pSSysAIFactoryBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getPSSysResourceId() != null) {
            object = pSSysAIFactoryBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getPSSysResourceName() != null) {
            object = pSSysAIFactoryBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getPSSysSFPluginId() != null) {
            object = pSSysAIFactoryBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getPSSysSFPluginName() != null) {
            object = pSSysAIFactoryBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getPSSystemId() != null) {
            object = pSSysAIFactoryBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getPSSystemName() != null) {
            object = pSSysAIFactoryBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getServiceParam() != null) {
            object = pSSysAIFactoryBase.getServiceParam();
            xmlNode.setAttribute(FIELD_SERVICEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getServiceParam2() != null) {
            object = pSSysAIFactoryBase.getServiceParam2();
            xmlNode.setAttribute(FIELD_SERVICEPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getServicePath() != null) {
            object = pSSysAIFactoryBase.getServicePath();
            xmlNode.setAttribute(FIELD_SERVICEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getUpdateDate() != null) {
            object = pSSysAIFactoryBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysAIFactoryBase.getUpdateMan() != null) {
            object = pSSysAIFactoryBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getUserCat() != null) {
            object = pSSysAIFactoryBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getUserTag() != null) {
            object = pSSysAIFactoryBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getUserTag2() != null) {
            object = pSSysAIFactoryBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getUserTag3() != null) {
            object = pSSysAIFactoryBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIFactoryBase.getUserTag4() != null) {
            object = pSSysAIFactoryBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysAIFactoryBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysAIFactoryBase pSSysAIFactoryBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysAIFactoryBase.isAIFactoryParamsDirty() && (bl || pSSysAIFactoryBase.getAIFactoryParams() != null)) {
            iDataObject.set(FIELD_AIFACTORYPARAMS, (Object)pSSysAIFactoryBase.getAIFactoryParams());
        }
        if (pSSysAIFactoryBase.isAIFactoryTagDirty() && (bl || pSSysAIFactoryBase.getAIFactoryTag() != null)) {
            iDataObject.set(FIELD_AIFACTORYTAG, (Object)pSSysAIFactoryBase.getAIFactoryTag());
        }
        if (pSSysAIFactoryBase.isAIFactoryTag2Dirty() && (bl || pSSysAIFactoryBase.getAIFactoryTag2() != null)) {
            iDataObject.set(FIELD_AIFACTORYTAG2, (Object)pSSysAIFactoryBase.getAIFactoryTag2());
        }
        if (pSSysAIFactoryBase.isAIFactoryTypeDirty() && (bl || pSSysAIFactoryBase.getAIFactoryType() != null)) {
            iDataObject.set(FIELD_AIFACTORYTYPE, (Object)pSSysAIFactoryBase.getAIFactoryType());
        }
        if (pSSysAIFactoryBase.isAIPlatformTypeDirty() && (bl || pSSysAIFactoryBase.getAIPlatformType() != null)) {
            iDataObject.set(FIELD_AIPLATFORMTYPE, (Object)pSSysAIFactoryBase.getAIPlatformType());
        }
        if (pSSysAIFactoryBase.isAuthClientIdDirty() && (bl || pSSysAIFactoryBase.getAuthClientId() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTID, (Object)pSSysAIFactoryBase.getAuthClientId());
        }
        if (pSSysAIFactoryBase.isAuthClientSecretDirty() && (bl || pSSysAIFactoryBase.getAuthClientSecret() != null)) {
            iDataObject.set(FIELD_AUTHCLIENTSECRET, (Object)pSSysAIFactoryBase.getAuthClientSecret());
        }
        if (pSSysAIFactoryBase.isAuthModeDirty() && (bl || pSSysAIFactoryBase.getAuthMode() != null)) {
            iDataObject.set(FIELD_AUTHMODE, (Object)pSSysAIFactoryBase.getAuthMode());
        }
        if (pSSysAIFactoryBase.isAuthParamDirty() && (bl || pSSysAIFactoryBase.getAuthParam() != null)) {
            iDataObject.set(FIELD_AUTHPARAM, (Object)pSSysAIFactoryBase.getAuthParam());
        }
        if (pSSysAIFactoryBase.isAuthParam2Dirty() && (bl || pSSysAIFactoryBase.getAuthParam2() != null)) {
            iDataObject.set(FIELD_AUTHPARAM2, (Object)pSSysAIFactoryBase.getAuthParam2());
        }
        if (pSSysAIFactoryBase.isCodeNameDirty() && (bl || pSSysAIFactoryBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysAIFactoryBase.getCodeName());
        }
        if (pSSysAIFactoryBase.isCreateDateDirty() && (bl || pSSysAIFactoryBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysAIFactoryBase.getCreateDate());
        }
        if (pSSysAIFactoryBase.isCreateManDirty() && (bl || pSSysAIFactoryBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysAIFactoryBase.getCreateMan());
        }
        if (pSSysAIFactoryBase.isMemoDirty() && (bl || pSSysAIFactoryBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysAIFactoryBase.getMemo());
        }
        if (pSSysAIFactoryBase.isOrderValueDirty() && (bl || pSSysAIFactoryBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysAIFactoryBase.getOrderValue());
        }
        if (pSSysAIFactoryBase.isPSModuleIdDirty() && (bl || pSSysAIFactoryBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysAIFactoryBase.getPSModuleId());
        }
        if (pSSysAIFactoryBase.isPSModuleNameDirty() && (bl || pSSysAIFactoryBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysAIFactoryBase.getPSModuleName());
        }
        if (pSSysAIFactoryBase.isPSSysAIFactoryIdDirty() && (bl || pSSysAIFactoryBase.getPSSysAIFactoryId() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYID, (Object)pSSysAIFactoryBase.getPSSysAIFactoryId());
        }
        if (pSSysAIFactoryBase.isPSSysAIFactoryNameDirty() && (bl || pSSysAIFactoryBase.getPSSysAIFactoryName() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYNAME, (Object)pSSysAIFactoryBase.getPSSysAIFactoryName());
        }
        if (pSSysAIFactoryBase.isPSSysDynaModelIdDirty() && (bl || pSSysAIFactoryBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysAIFactoryBase.getPSSysDynaModelId());
        }
        if (pSSysAIFactoryBase.isPSSysDynaModelNameDirty() && (bl || pSSysAIFactoryBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysAIFactoryBase.getPSSysDynaModelName());
        }
        if (pSSysAIFactoryBase.isPSSysResourceIdDirty() && (bl || pSSysAIFactoryBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSSysAIFactoryBase.getPSSysResourceId());
        }
        if (pSSysAIFactoryBase.isPSSysResourceNameDirty() && (bl || pSSysAIFactoryBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSSysAIFactoryBase.getPSSysResourceName());
        }
        if (pSSysAIFactoryBase.isPSSysSFPluginIdDirty() && (bl || pSSysAIFactoryBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysAIFactoryBase.getPSSysSFPluginId());
        }
        if (pSSysAIFactoryBase.isPSSysSFPluginNameDirty() && (bl || pSSysAIFactoryBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysAIFactoryBase.getPSSysSFPluginName());
        }
        if (pSSysAIFactoryBase.isPSSystemIdDirty() && (bl || pSSysAIFactoryBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysAIFactoryBase.getPSSystemId());
        }
        if (pSSysAIFactoryBase.isPSSystemNameDirty() && (bl || pSSysAIFactoryBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysAIFactoryBase.getPSSystemName());
        }
        if (pSSysAIFactoryBase.isServiceParamDirty() && (bl || pSSysAIFactoryBase.getServiceParam() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM, (Object)pSSysAIFactoryBase.getServiceParam());
        }
        if (pSSysAIFactoryBase.isServiceParam2Dirty() && (bl || pSSysAIFactoryBase.getServiceParam2() != null)) {
            iDataObject.set(FIELD_SERVICEPARAM2, (Object)pSSysAIFactoryBase.getServiceParam2());
        }
        if (pSSysAIFactoryBase.isServicePathDirty() && (bl || pSSysAIFactoryBase.getServicePath() != null)) {
            iDataObject.set(FIELD_SERVICEPATH, (Object)pSSysAIFactoryBase.getServicePath());
        }
        if (pSSysAIFactoryBase.isUpdateDateDirty() && (bl || pSSysAIFactoryBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysAIFactoryBase.getUpdateDate());
        }
        if (pSSysAIFactoryBase.isUpdateManDirty() && (bl || pSSysAIFactoryBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysAIFactoryBase.getUpdateMan());
        }
        if (pSSysAIFactoryBase.isUserCatDirty() && (bl || pSSysAIFactoryBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysAIFactoryBase.getUserCat());
        }
        if (pSSysAIFactoryBase.isUserTagDirty() && (bl || pSSysAIFactoryBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysAIFactoryBase.getUserTag());
        }
        if (pSSysAIFactoryBase.isUserTag2Dirty() && (bl || pSSysAIFactoryBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysAIFactoryBase.getUserTag2());
        }
        if (pSSysAIFactoryBase.isUserTag3Dirty() && (bl || pSSysAIFactoryBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysAIFactoryBase.getUserTag3());
        }
        if (pSSysAIFactoryBase.isUserTag4Dirty() && (bl || pSSysAIFactoryBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysAIFactoryBase.getUserTag4());
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
        return PSSysAIFactoryBase.remove(this, n);
    }

    private static boolean remove(PSSysAIFactoryBase pSSysAIFactoryBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysAIFactoryBase.resetAIFactoryParams();
                return true;
            }
            case 1: {
                pSSysAIFactoryBase.resetAIFactoryTag();
                return true;
            }
            case 2: {
                pSSysAIFactoryBase.resetAIFactoryTag2();
                return true;
            }
            case 3: {
                pSSysAIFactoryBase.resetAIFactoryType();
                return true;
            }
            case 4: {
                pSSysAIFactoryBase.resetAIPlatformType();
                return true;
            }
            case 5: {
                pSSysAIFactoryBase.resetAuthClientId();
                return true;
            }
            case 6: {
                pSSysAIFactoryBase.resetAuthClientSecret();
                return true;
            }
            case 7: {
                pSSysAIFactoryBase.resetAuthMode();
                return true;
            }
            case 8: {
                pSSysAIFactoryBase.resetAuthParam();
                return true;
            }
            case 9: {
                pSSysAIFactoryBase.resetAuthParam2();
                return true;
            }
            case 10: {
                pSSysAIFactoryBase.resetCodeName();
                return true;
            }
            case 11: {
                pSSysAIFactoryBase.resetCreateDate();
                return true;
            }
            case 12: {
                pSSysAIFactoryBase.resetCreateMan();
                return true;
            }
            case 13: {
                pSSysAIFactoryBase.resetMemo();
                return true;
            }
            case 14: {
                pSSysAIFactoryBase.resetOrderValue();
                return true;
            }
            case 15: {
                pSSysAIFactoryBase.resetPSModuleId();
                return true;
            }
            case 16: {
                pSSysAIFactoryBase.resetPSModuleName();
                return true;
            }
            case 17: {
                pSSysAIFactoryBase.resetPSSysAIFactoryId();
                return true;
            }
            case 18: {
                pSSysAIFactoryBase.resetPSSysAIFactoryName();
                return true;
            }
            case 19: {
                pSSysAIFactoryBase.resetPSSysDynaModelId();
                return true;
            }
            case 20: {
                pSSysAIFactoryBase.resetPSSysDynaModelName();
                return true;
            }
            case 21: {
                pSSysAIFactoryBase.resetPSSysResourceId();
                return true;
            }
            case 22: {
                pSSysAIFactoryBase.resetPSSysResourceName();
                return true;
            }
            case 23: {
                pSSysAIFactoryBase.resetPSSysSFPluginId();
                return true;
            }
            case 24: {
                pSSysAIFactoryBase.resetPSSysSFPluginName();
                return true;
            }
            case 25: {
                pSSysAIFactoryBase.resetPSSystemId();
                return true;
            }
            case 26: {
                pSSysAIFactoryBase.resetPSSystemName();
                return true;
            }
            case 27: {
                pSSysAIFactoryBase.resetServiceParam();
                return true;
            }
            case 28: {
                pSSysAIFactoryBase.resetServiceParam2();
                return true;
            }
            case 29: {
                pSSysAIFactoryBase.resetServicePath();
                return true;
            }
            case 30: {
                pSSysAIFactoryBase.resetUpdateDate();
                return true;
            }
            case 31: {
                pSSysAIFactoryBase.resetUpdateMan();
                return true;
            }
            case 32: {
                pSSysAIFactoryBase.resetUserCat();
                return true;
            }
            case 33: {
                pSSysAIFactoryBase.resetUserTag();
                return true;
            }
            case 34: {
                pSSysAIFactoryBase.resetUserTag2();
                return true;
            }
            case 35: {
                pSSysAIFactoryBase.resetUserTag3();
                return true;
            }
            case 36: {
                pSSysAIFactoryBase.resetUserTag4();
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
    public PSSysResource getPSSysResource() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResource();
        }
        if (this.getPSSysResourceId() == null) {
            return null;
        }
        Integer n = this.objPSSysResourceLock;
        synchronized (n) {
            if (this.pssysresource != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysResourceId(), (Object)this.pssysresource.getPSSysResourceId()) != 0L) {
                this.pssysresource = null;
            }
            if (this.pssysresource == null) {
                PSSysResource pSSysResource = new PSSysResource();
                pSSysResource.setPSSysResourceId(this.getPSSysResourceId());
                PSSysResourceService pSSysResourceService = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
                pSSysResourceService.autoGet(pSSysResource);
                this.pssysresource = pSSysResource;
            }
            return this.pssysresource;
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
    public ArrayList<PSSysAIChatAgent> getPSSysAIChatAgents() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIChatAgents();
        }
        if (this.getPSSysAIFactoryId() == null) {
            return null;
        }
        PSSysAIChatAgentService pSSysAIChatAgentService = (PSSysAIChatAgentService)ServiceGlobal.getService(PSSysAIChatAgentService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysAIChatAgentsLock;
        synchronized (n) {
            if (this.pssysaichatagents == null) {
                this.pssysaichatagents = pSSysAIChatAgentService.selectByPSSysAIFactory(this);
            }
            return this.pssysaichatagents;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysAIPipelineAgent> getPSSysAIPipelineAgents() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIPipelineAgents();
        }
        if (this.getPSSysAIFactoryId() == null) {
            return null;
        }
        PSSysAIPipelineAgentService pSSysAIPipelineAgentService = (PSSysAIPipelineAgentService)ServiceGlobal.getService(PSSysAIPipelineAgentService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysAIPipelineAgentsLock;
        synchronized (n) {
            if (this.pssysaipipelineagents == null) {
                this.pssysaipipelineagents = pSSysAIPipelineAgentService.selectByPSSysAIFactory(this);
            }
            return this.pssysaipipelineagents;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysAIWorkerAgent> getPSSysAIWorkerAgents() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIWorkerAgents();
        }
        if (this.getPSSysAIFactoryId() == null) {
            return null;
        }
        PSSysAIWorkerAgentService pSSysAIWorkerAgentService = (PSSysAIWorkerAgentService)ServiceGlobal.getService(PSSysAIWorkerAgentService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysAIWorkerAgentsLock;
        synchronized (n) {
            if (this.pssysaiworkeragents == null) {
                this.pssysaiworkeragents = pSSysAIWorkerAgentService.selectByPSSysAIFactory(this);
            }
            return this.pssysaiworkeragents;
        }
    }

    private PSSysAIFactoryBase getProxyEntity() {
        return this.proxyPSSysAIFactoryBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysAIFactoryBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysAIFactoryBase) {
            this.proxyPSSysAIFactoryBase = (PSSysAIFactoryBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AIFACTORYPARAMS, 0);
        fieldIndexMap.put(FIELD_AIFACTORYTAG, 1);
        fieldIndexMap.put(FIELD_AIFACTORYTAG2, 2);
        fieldIndexMap.put(FIELD_AIFACTORYTYPE, 3);
        fieldIndexMap.put(FIELD_AIPLATFORMTYPE, 4);
        fieldIndexMap.put(FIELD_AUTHCLIENTID, 5);
        fieldIndexMap.put(FIELD_AUTHCLIENTSECRET, 6);
        fieldIndexMap.put(FIELD_AUTHMODE, 7);
        fieldIndexMap.put(FIELD_AUTHPARAM, 8);
        fieldIndexMap.put(FIELD_AUTHPARAM2, 9);
        fieldIndexMap.put(FIELD_CODENAME, 10);
        fieldIndexMap.put(FIELD_CREATEDATE, 11);
        fieldIndexMap.put(FIELD_CREATEMAN, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_ORDERVALUE, 14);
        fieldIndexMap.put(FIELD_PSMODULEID, 15);
        fieldIndexMap.put(FIELD_PSMODULENAME, 16);
        fieldIndexMap.put(FIELD_PSSYSAIFACTORYID, 17);
        fieldIndexMap.put(FIELD_PSSYSAIFACTORYNAME, 18);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 19);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 21);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 22);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 23);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 24);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 25);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 26);
        fieldIndexMap.put(FIELD_SERVICEPARAM, 27);
        fieldIndexMap.put(FIELD_SERVICEPARAM2, 28);
        fieldIndexMap.put(FIELD_SERVICEPATH, 29);
        fieldIndexMap.put(FIELD_UPDATEDATE, 30);
        fieldIndexMap.put(FIELD_UPDATEMAN, 31);
        fieldIndexMap.put(FIELD_USERCAT, 32);
        fieldIndexMap.put(FIELD_USERTAG, 33);
        fieldIndexMap.put(FIELD_USERTAG2, 34);
        fieldIndexMap.put(FIELD_USERTAG3, 35);
        fieldIndexMap.put(FIELD_USERTAG4, 36);
    }
}

