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
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactory;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineJob;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineWorker;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineAgentService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineJobService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineWorkerService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysAIPipelineAgentBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysAIPipelineAgentBase.class);
    public static final String FIELD_AGENTINFO = "AGENTINFO";
    public static final String FIELD_AIPIPELINEAGENTPARAMS = "AIPIPELINEAGENTPARAMS";
    public static final String FIELD_AIPIPELINEAGENTTAG = "AIPIPELINEAGENTTAG";
    public static final String FIELD_AIPIPELINEAGENTTAG2 = "AIPIPELINEAGENTTAG2";
    public static final String FIELD_AIPIPELINEAGENTTYPE = "AIPIPELINEAGENTTYPE";
    public static final String FIELD_AIPLATFORMTYPE = "AIPLATFORMTYPE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSAIFACTORYID = "PSSYSAIFACTORYID";
    public static final String FIELD_PSSYSAIFACTORYNAME = "PSSYSAIFACTORYNAME";
    public static final String FIELD_PSSYSAIPIPELINEAGENTID = "PSSYSAIPIPELINEAGENTID";
    public static final String FIELD_PSSYSAIPIPELINEAGENTNAME = "PSSYSAIPIPELINEAGENTNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_AGENTINFO = 0;
    private static final int INDEX_AIPIPELINEAGENTPARAMS = 1;
    private static final int INDEX_AIPIPELINEAGENTTAG = 2;
    private static final int INDEX_AIPIPELINEAGENTTAG2 = 3;
    private static final int INDEX_AIPIPELINEAGENTTYPE = 4;
    private static final int INDEX_AIPLATFORMTYPE = 5;
    private static final int INDEX_CODENAME = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_CUSTOMCODE = 9;
    private static final int INDEX_CUSTOMMODE = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_PSDEID = 12;
    private static final int INDEX_PSDENAME = 13;
    private static final int INDEX_PSSYSAIFACTORYID = 14;
    private static final int INDEX_PSSYSAIFACTORYNAME = 15;
    private static final int INDEX_PSSYSAIPIPELINEAGENTID = 16;
    private static final int INDEX_PSSYSAIPIPELINEAGENTNAME = 17;
    private static final int INDEX_PSSYSSFPLUGINID = 18;
    private static final int INDEX_PSSYSSFPLUGINNAME = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final int INDEX_USERCAT = 22;
    private static final int INDEX_USERTAG = 23;
    private static final int INDEX_USERTAG2 = 24;
    private static final int INDEX_USERTAG3 = 25;
    private static final int INDEX_USERTAG4 = 26;
    private static final int INDEX_VALIDFLAG = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysAIPipelineAgentBase proxyPSSysAIPipelineAgentBase = null;
    private boolean agentinfoDirtyFlag = false;
    private boolean aipipelineagentparamsDirtyFlag = false;
    private boolean aipipelineagenttagDirtyFlag = false;
    private boolean aipipelineagenttag2DirtyFlag = false;
    private boolean aipipelineagenttypeDirtyFlag = false;
    private boolean aiplatformtypeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssysaifactoryidDirtyFlag = false;
    private boolean pssysaifactorynameDirtyFlag = false;
    private boolean pssysaipipelineagentidDirtyFlag = false;
    private boolean pssysaipipelineagentnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="agentinfo")
    private String agentinfo;
    @Column(name="aipipelineagentparams")
    private String aipipelineagentparams;
    @Column(name="aipipelineagenttag")
    private String aipipelineagenttag;
    @Column(name="aipipelineagenttag2")
    private String aipipelineagenttag2;
    @Column(name="aipipelineagenttype")
    private String aipipelineagenttype;
    @Column(name="aiplatformtype")
    private String aiplatformtype;
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
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssysaifactoryid")
    private String pssysaifactoryid;
    @Column(name="pssysaifactoryname")
    private String pssysaifactoryname;
    @Column(name="pssysaipipelineagentid")
    private String pssysaipipelineagentid;
    @Column(name="pssysaipipelineagentname")
    private String pssysaipipelineagentname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
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
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSSysAIFactoryLock = new Integer(1);
    private PSSysAIFactory pssysaifactory = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSysAIPipelineJobsLock = new Integer(1);
    private ArrayList<PSSysAIPipelineJob> pssysaipipelinejobs = null;
    private Integer objPSSysAIPipelineWorkersLock = new Integer(1);
    private ArrayList<PSSysAIPipelineWorker> pssysaipipelineworkers = null;

    public void setAgentInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.agentinfo = string;
        this.agentinfoDirtyFlag = true;
    }

    public String getAgentInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentInfo();
        }
        return this.agentinfo;
    }

    public boolean isAgentInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentInfoDirty();
        }
        return this.agentinfoDirtyFlag;
    }

    public void resetAgentInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentInfo();
            return;
        }
        this.agentinfoDirtyFlag = false;
        this.agentinfo = null;
    }

    public void setAIPipelineAgentParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIPipelineAgentParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aipipelineagentparams = string;
        this.aipipelineagentparamsDirtyFlag = true;
    }

    public String getAIPipelineAgentParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIPipelineAgentParams();
        }
        return this.aipipelineagentparams;
    }

    public boolean isAIPipelineAgentParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIPipelineAgentParamsDirty();
        }
        return this.aipipelineagentparamsDirtyFlag;
    }

    public void resetAIPipelineAgentParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIPipelineAgentParams();
            return;
        }
        this.aipipelineagentparamsDirtyFlag = false;
        this.aipipelineagentparams = null;
    }

    public void setAIPipelineAgentTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIPipelineAgentTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aipipelineagenttag = string;
        this.aipipelineagenttagDirtyFlag = true;
    }

    public String getAIPipelineAgentTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIPipelineAgentTag();
        }
        return this.aipipelineagenttag;
    }

    public boolean isAIPipelineAgentTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIPipelineAgentTagDirty();
        }
        return this.aipipelineagenttagDirtyFlag;
    }

    public void resetAIPipelineAgentTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIPipelineAgentTag();
            return;
        }
        this.aipipelineagenttagDirtyFlag = false;
        this.aipipelineagenttag = null;
    }

    public void setAIPipelineAgentTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIPipelineAgentTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aipipelineagenttag2 = string;
        this.aipipelineagenttag2DirtyFlag = true;
    }

    public String getAIPipelineAgentTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIPipelineAgentTag2();
        }
        return this.aipipelineagenttag2;
    }

    public boolean isAIPipelineAgentTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIPipelineAgentTag2Dirty();
        }
        return this.aipipelineagenttag2DirtyFlag;
    }

    public void resetAIPipelineAgentTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIPipelineAgentTag2();
            return;
        }
        this.aipipelineagenttag2DirtyFlag = false;
        this.aipipelineagenttag2 = null;
    }

    public void setAIPipelineAgentType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIPipelineAgentType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aipipelineagenttype = string;
        this.aipipelineagenttypeDirtyFlag = true;
    }

    public String getAIPipelineAgentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIPipelineAgentType();
        }
        return this.aipipelineagenttype;
    }

    public boolean isAIPipelineAgentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIPipelineAgentTypeDirty();
        }
        return this.aipipelineagenttypeDirtyFlag;
    }

    public void resetAIPipelineAgentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIPipelineAgentType();
            return;
        }
        this.aipipelineagenttypeDirtyFlag = false;
        this.aipipelineagenttype = null;
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

    public void setPSSysAIPipelineAgentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIPipelineAgentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaipipelineagentid = string;
        this.pssysaipipelineagentidDirtyFlag = true;
    }

    public String getPSSysAIPipelineAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIPipelineAgentId();
        }
        return this.pssysaipipelineagentid;
    }

    public boolean isPSSysAIPipelineAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIPipelineAgentIdDirty();
        }
        return this.pssysaipipelineagentidDirtyFlag;
    }

    public void resetPSSysAIPipelineAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIPipelineAgentId();
            return;
        }
        this.pssysaipipelineagentidDirtyFlag = false;
        this.pssysaipipelineagentid = null;
    }

    public void setPSSysAIPipelineAgentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIPipelineAgentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaipipelineagentname = string;
        this.pssysaipipelineagentnameDirtyFlag = true;
    }

    public String getPSSysAIPipelineAgentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIPipelineAgentName();
        }
        return this.pssysaipipelineagentname;
    }

    public boolean isPSSysAIPipelineAgentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIPipelineAgentNameDirty();
        }
        return this.pssysaipipelineagentnameDirtyFlag;
    }

    public void resetPSSysAIPipelineAgentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIPipelineAgentName();
            return;
        }
        this.pssysaipipelineagentnameDirtyFlag = false;
        this.pssysaipipelineagentname = null;
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
        PSSysAIPipelineAgentBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase) {
        pSSysAIPipelineAgentBase.resetAgentInfo();
        pSSysAIPipelineAgentBase.resetAIPipelineAgentParams();
        pSSysAIPipelineAgentBase.resetAIPipelineAgentTag();
        pSSysAIPipelineAgentBase.resetAIPipelineAgentTag2();
        pSSysAIPipelineAgentBase.resetAIPipelineAgentType();
        pSSysAIPipelineAgentBase.resetAIPlatformType();
        pSSysAIPipelineAgentBase.resetCodeName();
        pSSysAIPipelineAgentBase.resetCreateDate();
        pSSysAIPipelineAgentBase.resetCreateMan();
        pSSysAIPipelineAgentBase.resetCustomCode();
        pSSysAIPipelineAgentBase.resetCustomMode();
        pSSysAIPipelineAgentBase.resetMemo();
        pSSysAIPipelineAgentBase.resetPSDEId();
        pSSysAIPipelineAgentBase.resetPSDEName();
        pSSysAIPipelineAgentBase.resetPSSysAIFactoryId();
        pSSysAIPipelineAgentBase.resetPSSysAIFactoryName();
        pSSysAIPipelineAgentBase.resetPSSysAIPipelineAgentId();
        pSSysAIPipelineAgentBase.resetPSSysAIPipelineAgentName();
        pSSysAIPipelineAgentBase.resetPSSysSFPluginId();
        pSSysAIPipelineAgentBase.resetPSSysSFPluginName();
        pSSysAIPipelineAgentBase.resetUpdateDate();
        pSSysAIPipelineAgentBase.resetUpdateMan();
        pSSysAIPipelineAgentBase.resetUserCat();
        pSSysAIPipelineAgentBase.resetUserTag();
        pSSysAIPipelineAgentBase.resetUserTag2();
        pSSysAIPipelineAgentBase.resetUserTag3();
        pSSysAIPipelineAgentBase.resetUserTag4();
        pSSysAIPipelineAgentBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAgentInfoDirty()) {
            hashMap.put(FIELD_AGENTINFO, this.getAgentInfo());
        }
        if (!bl || this.isAIPipelineAgentParamsDirty()) {
            hashMap.put(FIELD_AIPIPELINEAGENTPARAMS, this.getAIPipelineAgentParams());
        }
        if (!bl || this.isAIPipelineAgentTagDirty()) {
            hashMap.put(FIELD_AIPIPELINEAGENTTAG, this.getAIPipelineAgentTag());
        }
        if (!bl || this.isAIPipelineAgentTag2Dirty()) {
            hashMap.put(FIELD_AIPIPELINEAGENTTAG2, this.getAIPipelineAgentTag2());
        }
        if (!bl || this.isAIPipelineAgentTypeDirty()) {
            hashMap.put(FIELD_AIPIPELINEAGENTTYPE, this.getAIPipelineAgentType());
        }
        if (!bl || this.isAIPlatformTypeDirty()) {
            hashMap.put(FIELD_AIPLATFORMTYPE, this.getAIPlatformType());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSysAIFactoryIdDirty()) {
            hashMap.put(FIELD_PSSYSAIFACTORYID, this.getPSSysAIFactoryId());
        }
        if (!bl || this.isPSSysAIFactoryNameDirty()) {
            hashMap.put(FIELD_PSSYSAIFACTORYNAME, this.getPSSysAIFactoryName());
        }
        if (!bl || this.isPSSysAIPipelineAgentIdDirty()) {
            hashMap.put(FIELD_PSSYSAIPIPELINEAGENTID, this.getPSSysAIPipelineAgentId());
        }
        if (!bl || this.isPSSysAIPipelineAgentNameDirty()) {
            hashMap.put(FIELD_PSSYSAIPIPELINEAGENTNAME, this.getPSSysAIPipelineAgentName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
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
        return PSSysAIPipelineAgentBase.get(this, n);
    }

    private static Object get(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIPipelineAgentBase.getAgentInfo();
            }
            case 1: {
                return pSSysAIPipelineAgentBase.getAIPipelineAgentParams();
            }
            case 2: {
                return pSSysAIPipelineAgentBase.getAIPipelineAgentTag();
            }
            case 3: {
                return pSSysAIPipelineAgentBase.getAIPipelineAgentTag2();
            }
            case 4: {
                return pSSysAIPipelineAgentBase.getAIPipelineAgentType();
            }
            case 5: {
                return pSSysAIPipelineAgentBase.getAIPlatformType();
            }
            case 6: {
                return pSSysAIPipelineAgentBase.getCodeName();
            }
            case 7: {
                return pSSysAIPipelineAgentBase.getCreateDate();
            }
            case 8: {
                return pSSysAIPipelineAgentBase.getCreateMan();
            }
            case 9: {
                return pSSysAIPipelineAgentBase.getCustomCode();
            }
            case 10: {
                return pSSysAIPipelineAgentBase.getCustomMode();
            }
            case 11: {
                return pSSysAIPipelineAgentBase.getMemo();
            }
            case 12: {
                return pSSysAIPipelineAgentBase.getPSDEId();
            }
            case 13: {
                return pSSysAIPipelineAgentBase.getPSDEName();
            }
            case 14: {
                return pSSysAIPipelineAgentBase.getPSSysAIFactoryId();
            }
            case 15: {
                return pSSysAIPipelineAgentBase.getPSSysAIFactoryName();
            }
            case 16: {
                return pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentId();
            }
            case 17: {
                return pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentName();
            }
            case 18: {
                return pSSysAIPipelineAgentBase.getPSSysSFPluginId();
            }
            case 19: {
                return pSSysAIPipelineAgentBase.getPSSysSFPluginName();
            }
            case 20: {
                return pSSysAIPipelineAgentBase.getUpdateDate();
            }
            case 21: {
                return pSSysAIPipelineAgentBase.getUpdateMan();
            }
            case 22: {
                return pSSysAIPipelineAgentBase.getUserCat();
            }
            case 23: {
                return pSSysAIPipelineAgentBase.getUserTag();
            }
            case 24: {
                return pSSysAIPipelineAgentBase.getUserTag2();
            }
            case 25: {
                return pSSysAIPipelineAgentBase.getUserTag3();
            }
            case 26: {
                return pSSysAIPipelineAgentBase.getUserTag4();
            }
            case 27: {
                return pSSysAIPipelineAgentBase.getValidFlag();
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
        PSSysAIPipelineAgentBase.set(this, n, object);
    }

    private static void set(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysAIPipelineAgentBase.setAgentInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysAIPipelineAgentBase.setAIPipelineAgentParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysAIPipelineAgentBase.setAIPipelineAgentTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysAIPipelineAgentBase.setAIPipelineAgentTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysAIPipelineAgentBase.setAIPipelineAgentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysAIPipelineAgentBase.setAIPlatformType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysAIPipelineAgentBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysAIPipelineAgentBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSysAIPipelineAgentBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysAIPipelineAgentBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysAIPipelineAgentBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysAIPipelineAgentBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysAIPipelineAgentBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysAIPipelineAgentBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysAIPipelineAgentBase.setPSSysAIFactoryId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysAIPipelineAgentBase.setPSSysAIFactoryName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysAIPipelineAgentBase.setPSSysAIPipelineAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysAIPipelineAgentBase.setPSSysAIPipelineAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysAIPipelineAgentBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysAIPipelineAgentBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysAIPipelineAgentBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSSysAIPipelineAgentBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysAIPipelineAgentBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysAIPipelineAgentBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysAIPipelineAgentBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysAIPipelineAgentBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysAIPipelineAgentBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysAIPipelineAgentBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysAIPipelineAgentBase.isNull(this, n);
    }

    private static boolean isNull(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIPipelineAgentBase.getAgentInfo() == null;
            }
            case 1: {
                return pSSysAIPipelineAgentBase.getAIPipelineAgentParams() == null;
            }
            case 2: {
                return pSSysAIPipelineAgentBase.getAIPipelineAgentTag() == null;
            }
            case 3: {
                return pSSysAIPipelineAgentBase.getAIPipelineAgentTag2() == null;
            }
            case 4: {
                return pSSysAIPipelineAgentBase.getAIPipelineAgentType() == null;
            }
            case 5: {
                return pSSysAIPipelineAgentBase.getAIPlatformType() == null;
            }
            case 6: {
                return pSSysAIPipelineAgentBase.getCodeName() == null;
            }
            case 7: {
                return pSSysAIPipelineAgentBase.getCreateDate() == null;
            }
            case 8: {
                return pSSysAIPipelineAgentBase.getCreateMan() == null;
            }
            case 9: {
                return pSSysAIPipelineAgentBase.getCustomCode() == null;
            }
            case 10: {
                return pSSysAIPipelineAgentBase.getCustomMode() == null;
            }
            case 11: {
                return pSSysAIPipelineAgentBase.getMemo() == null;
            }
            case 12: {
                return pSSysAIPipelineAgentBase.getPSDEId() == null;
            }
            case 13: {
                return pSSysAIPipelineAgentBase.getPSDEName() == null;
            }
            case 14: {
                return pSSysAIPipelineAgentBase.getPSSysAIFactoryId() == null;
            }
            case 15: {
                return pSSysAIPipelineAgentBase.getPSSysAIFactoryName() == null;
            }
            case 16: {
                return pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentId() == null;
            }
            case 17: {
                return pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentName() == null;
            }
            case 18: {
                return pSSysAIPipelineAgentBase.getPSSysSFPluginId() == null;
            }
            case 19: {
                return pSSysAIPipelineAgentBase.getPSSysSFPluginName() == null;
            }
            case 20: {
                return pSSysAIPipelineAgentBase.getUpdateDate() == null;
            }
            case 21: {
                return pSSysAIPipelineAgentBase.getUpdateMan() == null;
            }
            case 22: {
                return pSSysAIPipelineAgentBase.getUserCat() == null;
            }
            case 23: {
                return pSSysAIPipelineAgentBase.getUserTag() == null;
            }
            case 24: {
                return pSSysAIPipelineAgentBase.getUserTag2() == null;
            }
            case 25: {
                return pSSysAIPipelineAgentBase.getUserTag3() == null;
            }
            case 26: {
                return pSSysAIPipelineAgentBase.getUserTag4() == null;
            }
            case 27: {
                return pSSysAIPipelineAgentBase.getValidFlag() == null;
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
        return PSSysAIPipelineAgentBase.contains(this, n);
    }

    private static boolean contains(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIPipelineAgentBase.isAgentInfoDirty();
            }
            case 1: {
                return pSSysAIPipelineAgentBase.isAIPipelineAgentParamsDirty();
            }
            case 2: {
                return pSSysAIPipelineAgentBase.isAIPipelineAgentTagDirty();
            }
            case 3: {
                return pSSysAIPipelineAgentBase.isAIPipelineAgentTag2Dirty();
            }
            case 4: {
                return pSSysAIPipelineAgentBase.isAIPipelineAgentTypeDirty();
            }
            case 5: {
                return pSSysAIPipelineAgentBase.isAIPlatformTypeDirty();
            }
            case 6: {
                return pSSysAIPipelineAgentBase.isCodeNameDirty();
            }
            case 7: {
                return pSSysAIPipelineAgentBase.isCreateDateDirty();
            }
            case 8: {
                return pSSysAIPipelineAgentBase.isCreateManDirty();
            }
            case 9: {
                return pSSysAIPipelineAgentBase.isCustomCodeDirty();
            }
            case 10: {
                return pSSysAIPipelineAgentBase.isCustomModeDirty();
            }
            case 11: {
                return pSSysAIPipelineAgentBase.isMemoDirty();
            }
            case 12: {
                return pSSysAIPipelineAgentBase.isPSDEIdDirty();
            }
            case 13: {
                return pSSysAIPipelineAgentBase.isPSDENameDirty();
            }
            case 14: {
                return pSSysAIPipelineAgentBase.isPSSysAIFactoryIdDirty();
            }
            case 15: {
                return pSSysAIPipelineAgentBase.isPSSysAIFactoryNameDirty();
            }
            case 16: {
                return pSSysAIPipelineAgentBase.isPSSysAIPipelineAgentIdDirty();
            }
            case 17: {
                return pSSysAIPipelineAgentBase.isPSSysAIPipelineAgentNameDirty();
            }
            case 18: {
                return pSSysAIPipelineAgentBase.isPSSysSFPluginIdDirty();
            }
            case 19: {
                return pSSysAIPipelineAgentBase.isPSSysSFPluginNameDirty();
            }
            case 20: {
                return pSSysAIPipelineAgentBase.isUpdateDateDirty();
            }
            case 21: {
                return pSSysAIPipelineAgentBase.isUpdateManDirty();
            }
            case 22: {
                return pSSysAIPipelineAgentBase.isUserCatDirty();
            }
            case 23: {
                return pSSysAIPipelineAgentBase.isUserTagDirty();
            }
            case 24: {
                return pSSysAIPipelineAgentBase.isUserTag2Dirty();
            }
            case 25: {
                return pSSysAIPipelineAgentBase.isUserTag3Dirty();
            }
            case 26: {
                return pSSysAIPipelineAgentBase.isUserTag4Dirty();
            }
            case 27: {
                return pSSysAIPipelineAgentBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysAIPipelineAgentBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysAIPipelineAgentBase.getAgentInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agentinfo", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getAgentInfo()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getAIPipelineAgentParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aipipelineagentparams", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getAIPipelineAgentParams()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getAIPipelineAgentTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aipipelineagenttag", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getAIPipelineAgentTag()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getAIPipelineAgentTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aipipelineagenttag2", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getAIPipelineAgentTag2()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getAIPipelineAgentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aipipelineagenttype", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getAIPipelineAgentType()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getAIPlatformType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aiplatformtype", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getAIPlatformType()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSSysAIFactoryId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryid", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getPSSysAIFactoryId()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSSysAIFactoryName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryname", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getPSSysAIFactoryName()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaipipelineagentid", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentId()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaipipelineagentname", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentName()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysAIPipelineAgentBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysAIPipelineAgentBase.getJSONValue((Object)pSSysAIPipelineAgentBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysAIPipelineAgentBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysAIPipelineAgentBase.getAgentInfo() != null) {
            object = pSSysAIPipelineAgentBase.getAgentInfo();
            xmlNode.setAttribute(FIELD_AGENTINFO, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIPipelineAgentBase.getAIPipelineAgentParams() != null) {
            object = pSSysAIPipelineAgentBase.getAIPipelineAgentParams();
            xmlNode.setAttribute(FIELD_AIPIPELINEAGENTPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIPipelineAgentBase.getAIPipelineAgentTag() != null) {
            object = pSSysAIPipelineAgentBase.getAIPipelineAgentTag();
            xmlNode.setAttribute(FIELD_AIPIPELINEAGENTTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIPipelineAgentBase.getAIPipelineAgentTag2() != null) {
            object = pSSysAIPipelineAgentBase.getAIPipelineAgentTag2();
            xmlNode.setAttribute(FIELD_AIPIPELINEAGENTTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIPipelineAgentBase.getAIPipelineAgentType() != null) {
            object = pSSysAIPipelineAgentBase.getAIPipelineAgentType();
            xmlNode.setAttribute(FIELD_AIPIPELINEAGENTTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIPipelineAgentBase.getAIPlatformType() != null) {
            object = pSSysAIPipelineAgentBase.getAIPlatformType();
            xmlNode.setAttribute(FIELD_AIPLATFORMTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIPipelineAgentBase.getCodeName() != null) {
            object = pSSysAIPipelineAgentBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getCreateDate() != null) {
            object = pSSysAIPipelineAgentBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysAIPipelineAgentBase.getCreateMan() != null) {
            object = pSSysAIPipelineAgentBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getCustomCode() != null) {
            object = pSSysAIPipelineAgentBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getCustomMode() != null) {
            object = pSSysAIPipelineAgentBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAIPipelineAgentBase.getMemo() != null) {
            object = pSSysAIPipelineAgentBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSDEId() != null) {
            object = pSSysAIPipelineAgentBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSDEName() != null) {
            object = pSSysAIPipelineAgentBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSSysAIFactoryId() != null) {
            object = pSSysAIPipelineAgentBase.getPSSysAIFactoryId();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSSysAIFactoryName() != null) {
            object = pSSysAIPipelineAgentBase.getPSSysAIFactoryName();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentId() != null) {
            object = pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentId();
            xmlNode.setAttribute(FIELD_PSSYSAIPIPELINEAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentName() != null) {
            object = pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentName();
            xmlNode.setAttribute(FIELD_PSSYSAIPIPELINEAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSSysSFPluginId() != null) {
            object = pSSysAIPipelineAgentBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getPSSysSFPluginName() != null) {
            object = pSSysAIPipelineAgentBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getUpdateDate() != null) {
            object = pSSysAIPipelineAgentBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysAIPipelineAgentBase.getUpdateMan() != null) {
            object = pSSysAIPipelineAgentBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getUserCat() != null) {
            object = pSSysAIPipelineAgentBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getUserTag() != null) {
            object = pSSysAIPipelineAgentBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getUserTag2() != null) {
            object = pSSysAIPipelineAgentBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getUserTag3() != null) {
            object = pSSysAIPipelineAgentBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getUserTag4() != null) {
            object = pSSysAIPipelineAgentBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineAgentBase.getValidFlag() != null) {
            object = pSSysAIPipelineAgentBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysAIPipelineAgentBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysAIPipelineAgentBase.isAgentInfoDirty() && (bl || pSSysAIPipelineAgentBase.getAgentInfo() != null)) {
            iDataObject.set(FIELD_AGENTINFO, (Object)pSSysAIPipelineAgentBase.getAgentInfo());
        }
        if (pSSysAIPipelineAgentBase.isAIPipelineAgentParamsDirty() && (bl || pSSysAIPipelineAgentBase.getAIPipelineAgentParams() != null)) {
            iDataObject.set(FIELD_AIPIPELINEAGENTPARAMS, (Object)pSSysAIPipelineAgentBase.getAIPipelineAgentParams());
        }
        if (pSSysAIPipelineAgentBase.isAIPipelineAgentTagDirty() && (bl || pSSysAIPipelineAgentBase.getAIPipelineAgentTag() != null)) {
            iDataObject.set(FIELD_AIPIPELINEAGENTTAG, (Object)pSSysAIPipelineAgentBase.getAIPipelineAgentTag());
        }
        if (pSSysAIPipelineAgentBase.isAIPipelineAgentTag2Dirty() && (bl || pSSysAIPipelineAgentBase.getAIPipelineAgentTag2() != null)) {
            iDataObject.set(FIELD_AIPIPELINEAGENTTAG2, (Object)pSSysAIPipelineAgentBase.getAIPipelineAgentTag2());
        }
        if (pSSysAIPipelineAgentBase.isAIPipelineAgentTypeDirty() && (bl || pSSysAIPipelineAgentBase.getAIPipelineAgentType() != null)) {
            iDataObject.set(FIELD_AIPIPELINEAGENTTYPE, (Object)pSSysAIPipelineAgentBase.getAIPipelineAgentType());
        }
        if (pSSysAIPipelineAgentBase.isAIPlatformTypeDirty() && (bl || pSSysAIPipelineAgentBase.getAIPlatformType() != null)) {
            iDataObject.set(FIELD_AIPLATFORMTYPE, (Object)pSSysAIPipelineAgentBase.getAIPlatformType());
        }
        if (pSSysAIPipelineAgentBase.isCodeNameDirty() && (bl || pSSysAIPipelineAgentBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysAIPipelineAgentBase.getCodeName());
        }
        if (pSSysAIPipelineAgentBase.isCreateDateDirty() && (bl || pSSysAIPipelineAgentBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysAIPipelineAgentBase.getCreateDate());
        }
        if (pSSysAIPipelineAgentBase.isCreateManDirty() && (bl || pSSysAIPipelineAgentBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysAIPipelineAgentBase.getCreateMan());
        }
        if (pSSysAIPipelineAgentBase.isCustomCodeDirty() && (bl || pSSysAIPipelineAgentBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysAIPipelineAgentBase.getCustomCode());
        }
        if (pSSysAIPipelineAgentBase.isCustomModeDirty() && (bl || pSSysAIPipelineAgentBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysAIPipelineAgentBase.getCustomMode());
        }
        if (pSSysAIPipelineAgentBase.isMemoDirty() && (bl || pSSysAIPipelineAgentBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysAIPipelineAgentBase.getMemo());
        }
        if (pSSysAIPipelineAgentBase.isPSDEIdDirty() && (bl || pSSysAIPipelineAgentBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysAIPipelineAgentBase.getPSDEId());
        }
        if (pSSysAIPipelineAgentBase.isPSDENameDirty() && (bl || pSSysAIPipelineAgentBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysAIPipelineAgentBase.getPSDEName());
        }
        if (pSSysAIPipelineAgentBase.isPSSysAIFactoryIdDirty() && (bl || pSSysAIPipelineAgentBase.getPSSysAIFactoryId() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYID, (Object)pSSysAIPipelineAgentBase.getPSSysAIFactoryId());
        }
        if (pSSysAIPipelineAgentBase.isPSSysAIFactoryNameDirty() && (bl || pSSysAIPipelineAgentBase.getPSSysAIFactoryName() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYNAME, (Object)pSSysAIPipelineAgentBase.getPSSysAIFactoryName());
        }
        if (pSSysAIPipelineAgentBase.isPSSysAIPipelineAgentIdDirty() && (bl || pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentId() != null)) {
            iDataObject.set(FIELD_PSSYSAIPIPELINEAGENTID, (Object)pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentId());
        }
        if (pSSysAIPipelineAgentBase.isPSSysAIPipelineAgentNameDirty() && (bl || pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentName() != null)) {
            iDataObject.set(FIELD_PSSYSAIPIPELINEAGENTNAME, (Object)pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentName());
        }
        if (pSSysAIPipelineAgentBase.isPSSysSFPluginIdDirty() && (bl || pSSysAIPipelineAgentBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysAIPipelineAgentBase.getPSSysSFPluginId());
        }
        if (pSSysAIPipelineAgentBase.isPSSysSFPluginNameDirty() && (bl || pSSysAIPipelineAgentBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysAIPipelineAgentBase.getPSSysSFPluginName());
        }
        if (pSSysAIPipelineAgentBase.isUpdateDateDirty() && (bl || pSSysAIPipelineAgentBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysAIPipelineAgentBase.getUpdateDate());
        }
        if (pSSysAIPipelineAgentBase.isUpdateManDirty() && (bl || pSSysAIPipelineAgentBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysAIPipelineAgentBase.getUpdateMan());
        }
        if (pSSysAIPipelineAgentBase.isUserCatDirty() && (bl || pSSysAIPipelineAgentBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysAIPipelineAgentBase.getUserCat());
        }
        if (pSSysAIPipelineAgentBase.isUserTagDirty() && (bl || pSSysAIPipelineAgentBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysAIPipelineAgentBase.getUserTag());
        }
        if (pSSysAIPipelineAgentBase.isUserTag2Dirty() && (bl || pSSysAIPipelineAgentBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysAIPipelineAgentBase.getUserTag2());
        }
        if (pSSysAIPipelineAgentBase.isUserTag3Dirty() && (bl || pSSysAIPipelineAgentBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysAIPipelineAgentBase.getUserTag3());
        }
        if (pSSysAIPipelineAgentBase.isUserTag4Dirty() && (bl || pSSysAIPipelineAgentBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysAIPipelineAgentBase.getUserTag4());
        }
        if (pSSysAIPipelineAgentBase.isValidFlagDirty() && (bl || pSSysAIPipelineAgentBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysAIPipelineAgentBase.getValidFlag());
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
        return PSSysAIPipelineAgentBase.remove(this, n);
    }

    private static boolean remove(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysAIPipelineAgentBase.resetAgentInfo();
                return true;
            }
            case 1: {
                pSSysAIPipelineAgentBase.resetAIPipelineAgentParams();
                return true;
            }
            case 2: {
                pSSysAIPipelineAgentBase.resetAIPipelineAgentTag();
                return true;
            }
            case 3: {
                pSSysAIPipelineAgentBase.resetAIPipelineAgentTag2();
                return true;
            }
            case 4: {
                pSSysAIPipelineAgentBase.resetAIPipelineAgentType();
                return true;
            }
            case 5: {
                pSSysAIPipelineAgentBase.resetAIPlatformType();
                return true;
            }
            case 6: {
                pSSysAIPipelineAgentBase.resetCodeName();
                return true;
            }
            case 7: {
                pSSysAIPipelineAgentBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSSysAIPipelineAgentBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSSysAIPipelineAgentBase.resetCustomCode();
                return true;
            }
            case 10: {
                pSSysAIPipelineAgentBase.resetCustomMode();
                return true;
            }
            case 11: {
                pSSysAIPipelineAgentBase.resetMemo();
                return true;
            }
            case 12: {
                pSSysAIPipelineAgentBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSSysAIPipelineAgentBase.resetPSDEName();
                return true;
            }
            case 14: {
                pSSysAIPipelineAgentBase.resetPSSysAIFactoryId();
                return true;
            }
            case 15: {
                pSSysAIPipelineAgentBase.resetPSSysAIFactoryName();
                return true;
            }
            case 16: {
                pSSysAIPipelineAgentBase.resetPSSysAIPipelineAgentId();
                return true;
            }
            case 17: {
                pSSysAIPipelineAgentBase.resetPSSysAIPipelineAgentName();
                return true;
            }
            case 18: {
                pSSysAIPipelineAgentBase.resetPSSysSFPluginId();
                return true;
            }
            case 19: {
                pSSysAIPipelineAgentBase.resetPSSysSFPluginName();
                return true;
            }
            case 20: {
                pSSysAIPipelineAgentBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSSysAIPipelineAgentBase.resetUpdateMan();
                return true;
            }
            case 22: {
                pSSysAIPipelineAgentBase.resetUserCat();
                return true;
            }
            case 23: {
                pSSysAIPipelineAgentBase.resetUserTag();
                return true;
            }
            case 24: {
                pSSysAIPipelineAgentBase.resetUserTag2();
                return true;
            }
            case 25: {
                pSSysAIPipelineAgentBase.resetUserTag3();
                return true;
            }
            case 26: {
                pSSysAIPipelineAgentBase.resetUserTag4();
                return true;
            }
            case 27: {
                pSSysAIPipelineAgentBase.resetValidFlag();
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysAIFactory getPSSysAIFactory() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIFactory();
        }
        if (this.getPSSysAIFactoryId() == null) {
            return null;
        }
        Integer n = this.objPSSysAIFactoryLock;
        synchronized (n) {
            if (this.pssysaifactory != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAIFactoryId(), (Object)this.pssysaifactory.getPSSysAIFactoryId()) != 0L) {
                this.pssysaifactory = null;
            }
            if (this.pssysaifactory == null) {
                PSSysAIFactory pSSysAIFactory = new PSSysAIFactory();
                pSSysAIFactory.setPSSysAIFactoryId(this.getPSSysAIFactoryId());
                PSSysAIFactoryService pSSysAIFactoryService = (PSSysAIFactoryService)ServiceGlobal.getService(PSSysAIFactoryService.class, (SessionFactory)this.getSessionFactory());
                pSSysAIFactoryService.autoGet((IEntity)pSSysAIFactory);
                this.pssysaifactory = pSSysAIFactory;
            }
            return this.pssysaifactory;
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
    public ArrayList<PSSysAIPipelineJob> getPSSysAIPipelineJobs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIPipelineJobs();
        }
        if (this.getPSSysAIPipelineAgentId() == null) {
            return null;
        }
        PSSysAIPipelineAgentService pSSysAIPipelineAgentService = (PSSysAIPipelineAgentService)ServiceGlobal.getService(PSSysAIPipelineAgentService.class, (SessionFactory)this.getSessionFactory());
        PSSysAIPipelineJobService pSSysAIPipelineJobService = (PSSysAIPipelineJobService)ServiceGlobal.getService(PSSysAIPipelineJobService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysAIPipelineJobsLock;
        synchronized (n) {
            if (this.pssysaipipelinejobs == null) {
                this.pssysaipipelinejobs = pSSysAIPipelineAgentService.isTempData((IEntity)this) ? pSSysAIPipelineJobService.selectTempByPSSysAIPipelineAgent(this) : pSSysAIPipelineJobService.selectByPSSysAIPipelineAgent(this);
            }
            return this.pssysaipipelinejobs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysAIPipelineWorker> getPSSysAIPipelineWorkers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIPipelineWorkers();
        }
        if (this.getPSSysAIPipelineAgentId() == null) {
            return null;
        }
        PSSysAIPipelineAgentService pSSysAIPipelineAgentService = (PSSysAIPipelineAgentService)ServiceGlobal.getService(PSSysAIPipelineAgentService.class, (SessionFactory)this.getSessionFactory());
        PSSysAIPipelineWorkerService pSSysAIPipelineWorkerService = (PSSysAIPipelineWorkerService)ServiceGlobal.getService(PSSysAIPipelineWorkerService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysAIPipelineWorkersLock;
        synchronized (n) {
            if (this.pssysaipipelineworkers == null) {
                this.pssysaipipelineworkers = pSSysAIPipelineAgentService.isTempData((IEntity)this) ? pSSysAIPipelineWorkerService.selectTempByPSSysAIPipelineAgent(this) : pSSysAIPipelineWorkerService.selectByPSSysAIPipelineAgent(this);
            }
            return this.pssysaipipelineworkers;
        }
    }

    private PSSysAIPipelineAgentBase getProxyEntity() {
        return this.proxyPSSysAIPipelineAgentBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysAIPipelineAgentBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysAIPipelineAgentBase) {
            this.proxyPSSysAIPipelineAgentBase = (PSSysAIPipelineAgentBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineAgentService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AGENTINFO, 0);
        fieldIndexMap.put(FIELD_AIPIPELINEAGENTPARAMS, 1);
        fieldIndexMap.put(FIELD_AIPIPELINEAGENTTAG, 2);
        fieldIndexMap.put(FIELD_AIPIPELINEAGENTTAG2, 3);
        fieldIndexMap.put(FIELD_AIPIPELINEAGENTTYPE, 4);
        fieldIndexMap.put(FIELD_AIPLATFORMTYPE, 5);
        fieldIndexMap.put(FIELD_CODENAME, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 9);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_PSDEID, 12);
        fieldIndexMap.put(FIELD_PSDENAME, 13);
        fieldIndexMap.put(FIELD_PSSYSAIFACTORYID, 14);
        fieldIndexMap.put(FIELD_PSSYSAIFACTORYNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSAIPIPELINEAGENTID, 16);
        fieldIndexMap.put(FIELD_PSSYSAIPIPELINEAGENTNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 18);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
        fieldIndexMap.put(FIELD_USERCAT, 22);
        fieldIndexMap.put(FIELD_USERTAG, 23);
        fieldIndexMap.put(FIELD_USERTAG2, 24);
        fieldIndexMap.put(FIELD_USERTAG3, 25);
        fieldIndexMap.put(FIELD_USERTAG4, 26);
        fieldIndexMap.put(FIELD_VALIDFLAG, 27);
    }
}

