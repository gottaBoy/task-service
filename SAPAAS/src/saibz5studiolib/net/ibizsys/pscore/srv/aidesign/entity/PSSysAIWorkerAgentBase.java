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
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysAIWorkerAgentBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysAIWorkerAgentBase.class);
    public static final String FIELD_AGENTINFO = "AGENTINFO";
    public static final String FIELD_AIPLATFORMTYPE = "AIPLATFORMTYPE";
    public static final String FIELD_AIWORKERAGENTPARAMS = "AIWORKERAGENTPARAMS";
    public static final String FIELD_AIWORKERAGENTTAG = "AIWORKERAGENTTAG";
    public static final String FIELD_AIWORKERAGENTTAG2 = "AIWORKERAGENTTAG2";
    public static final String FIELD_AIWORKERAGENTTYPE = "AIWORKERAGENTTYPE";
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
    public static final String FIELD_PSSYSAIWORKERAGENTID = "PSSYSAIWORKERAGENTID";
    public static final String FIELD_PSSYSAIWORKERAGENTNAME = "PSSYSAIWORKERAGENTNAME";
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
    private static final int INDEX_AIPLATFORMTYPE = 1;
    private static final int INDEX_AIWORKERAGENTPARAMS = 2;
    private static final int INDEX_AIWORKERAGENTTAG = 3;
    private static final int INDEX_AIWORKERAGENTTAG2 = 4;
    private static final int INDEX_AIWORKERAGENTTYPE = 5;
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
    private static final int INDEX_PSSYSAIWORKERAGENTID = 16;
    private static final int INDEX_PSSYSAIWORKERAGENTNAME = 17;
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
    private PSSysAIWorkerAgentBase proxyPSSysAIWorkerAgentBase = null;
    private boolean agentinfoDirtyFlag = false;
    private boolean aiplatformtypeDirtyFlag = false;
    private boolean aiworkeragentparamsDirtyFlag = false;
    private boolean aiworkeragenttagDirtyFlag = false;
    private boolean aiworkeragenttag2DirtyFlag = false;
    private boolean aiworkeragenttypeDirtyFlag = false;
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
    private boolean pssysaiworkeragentidDirtyFlag = false;
    private boolean pssysaiworkeragentnameDirtyFlag = false;
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
    @Column(name="aiplatformtype")
    private String aiplatformtype;
    @Column(name="aiworkeragentparams")
    private String aiworkeragentparams;
    @Column(name="aiworkeragenttag")
    private String aiworkeragenttag;
    @Column(name="aiworkeragenttag2")
    private String aiworkeragenttag2;
    @Column(name="aiworkeragenttype")
    private String aiworkeragenttype;
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
    @Column(name="pssysaiworkeragentid")
    private String pssysaiworkeragentid;
    @Column(name="pssysaiworkeragentname")
    private String pssysaiworkeragentname;
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

    public void setAIWorkerAgentParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIWorkerAgentParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aiworkeragentparams = string;
        this.aiworkeragentparamsDirtyFlag = true;
    }

    public String getAIWorkerAgentParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIWorkerAgentParams();
        }
        return this.aiworkeragentparams;
    }

    public boolean isAIWorkerAgentParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIWorkerAgentParamsDirty();
        }
        return this.aiworkeragentparamsDirtyFlag;
    }

    public void resetAIWorkerAgentParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIWorkerAgentParams();
            return;
        }
        this.aiworkeragentparamsDirtyFlag = false;
        this.aiworkeragentparams = null;
    }

    public void setAIWorkerAgentTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIWorkerAgentTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aiworkeragenttag = string;
        this.aiworkeragenttagDirtyFlag = true;
    }

    public String getAIWorkerAgentTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIWorkerAgentTag();
        }
        return this.aiworkeragenttag;
    }

    public boolean isAIWorkerAgentTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIWorkerAgentTagDirty();
        }
        return this.aiworkeragenttagDirtyFlag;
    }

    public void resetAIWorkerAgentTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIWorkerAgentTag();
            return;
        }
        this.aiworkeragenttagDirtyFlag = false;
        this.aiworkeragenttag = null;
    }

    public void setAIWorkerAgentTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIWorkerAgentTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aiworkeragenttag2 = string;
        this.aiworkeragenttag2DirtyFlag = true;
    }

    public String getAIWorkerAgentTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIWorkerAgentTag2();
        }
        return this.aiworkeragenttag2;
    }

    public boolean isAIWorkerAgentTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIWorkerAgentTag2Dirty();
        }
        return this.aiworkeragenttag2DirtyFlag;
    }

    public void resetAIWorkerAgentTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIWorkerAgentTag2();
            return;
        }
        this.aiworkeragenttag2DirtyFlag = false;
        this.aiworkeragenttag2 = null;
    }

    public void setAIWorkerAgentType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIWorkerAgentType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aiworkeragenttype = string;
        this.aiworkeragenttypeDirtyFlag = true;
    }

    public String getAIWorkerAgentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIWorkerAgentType();
        }
        return this.aiworkeragenttype;
    }

    public boolean isAIWorkerAgentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIWorkerAgentTypeDirty();
        }
        return this.aiworkeragenttypeDirtyFlag;
    }

    public void resetAIWorkerAgentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIWorkerAgentType();
            return;
        }
        this.aiworkeragenttypeDirtyFlag = false;
        this.aiworkeragenttype = null;
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

    public void setPSSysAIWorkerAgentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIWorkerAgentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaiworkeragentid = string;
        this.pssysaiworkeragentidDirtyFlag = true;
    }

    public String getPSSysAIWorkerAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIWorkerAgentId();
        }
        return this.pssysaiworkeragentid;
    }

    public boolean isPSSysAIWorkerAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIWorkerAgentIdDirty();
        }
        return this.pssysaiworkeragentidDirtyFlag;
    }

    public void resetPSSysAIWorkerAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIWorkerAgentId();
            return;
        }
        this.pssysaiworkeragentidDirtyFlag = false;
        this.pssysaiworkeragentid = null;
    }

    public void setPSSysAIWorkerAgentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIWorkerAgentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaiworkeragentname = string;
        this.pssysaiworkeragentnameDirtyFlag = true;
    }

    public String getPSSysAIWorkerAgentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIWorkerAgentName();
        }
        return this.pssysaiworkeragentname;
    }

    public boolean isPSSysAIWorkerAgentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIWorkerAgentNameDirty();
        }
        return this.pssysaiworkeragentnameDirtyFlag;
    }

    public void resetPSSysAIWorkerAgentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIWorkerAgentName();
            return;
        }
        this.pssysaiworkeragentnameDirtyFlag = false;
        this.pssysaiworkeragentname = null;
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
        PSSysAIWorkerAgentBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase) {
        pSSysAIWorkerAgentBase.resetAgentInfo();
        pSSysAIWorkerAgentBase.resetAIPlatformType();
        pSSysAIWorkerAgentBase.resetAIWorkerAgentParams();
        pSSysAIWorkerAgentBase.resetAIWorkerAgentTag();
        pSSysAIWorkerAgentBase.resetAIWorkerAgentTag2();
        pSSysAIWorkerAgentBase.resetAIWorkerAgentType();
        pSSysAIWorkerAgentBase.resetCodeName();
        pSSysAIWorkerAgentBase.resetCreateDate();
        pSSysAIWorkerAgentBase.resetCreateMan();
        pSSysAIWorkerAgentBase.resetCustomCode();
        pSSysAIWorkerAgentBase.resetCustomMode();
        pSSysAIWorkerAgentBase.resetMemo();
        pSSysAIWorkerAgentBase.resetPSDEId();
        pSSysAIWorkerAgentBase.resetPSDEName();
        pSSysAIWorkerAgentBase.resetPSSysAIFactoryId();
        pSSysAIWorkerAgentBase.resetPSSysAIFactoryName();
        pSSysAIWorkerAgentBase.resetPSSysAIWorkerAgentId();
        pSSysAIWorkerAgentBase.resetPSSysAIWorkerAgentName();
        pSSysAIWorkerAgentBase.resetPSSysSFPluginId();
        pSSysAIWorkerAgentBase.resetPSSysSFPluginName();
        pSSysAIWorkerAgentBase.resetUpdateDate();
        pSSysAIWorkerAgentBase.resetUpdateMan();
        pSSysAIWorkerAgentBase.resetUserCat();
        pSSysAIWorkerAgentBase.resetUserTag();
        pSSysAIWorkerAgentBase.resetUserTag2();
        pSSysAIWorkerAgentBase.resetUserTag3();
        pSSysAIWorkerAgentBase.resetUserTag4();
        pSSysAIWorkerAgentBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAgentInfoDirty()) {
            hashMap.put(FIELD_AGENTINFO, this.getAgentInfo());
        }
        if (!bl || this.isAIPlatformTypeDirty()) {
            hashMap.put(FIELD_AIPLATFORMTYPE, this.getAIPlatformType());
        }
        if (!bl || this.isAIWorkerAgentParamsDirty()) {
            hashMap.put(FIELD_AIWORKERAGENTPARAMS, this.getAIWorkerAgentParams());
        }
        if (!bl || this.isAIWorkerAgentTagDirty()) {
            hashMap.put(FIELD_AIWORKERAGENTTAG, this.getAIWorkerAgentTag());
        }
        if (!bl || this.isAIWorkerAgentTag2Dirty()) {
            hashMap.put(FIELD_AIWORKERAGENTTAG2, this.getAIWorkerAgentTag2());
        }
        if (!bl || this.isAIWorkerAgentTypeDirty()) {
            hashMap.put(FIELD_AIWORKERAGENTTYPE, this.getAIWorkerAgentType());
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
        if (!bl || this.isPSSysAIWorkerAgentIdDirty()) {
            hashMap.put(FIELD_PSSYSAIWORKERAGENTID, this.getPSSysAIWorkerAgentId());
        }
        if (!bl || this.isPSSysAIWorkerAgentNameDirty()) {
            hashMap.put(FIELD_PSSYSAIWORKERAGENTNAME, this.getPSSysAIWorkerAgentName());
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
        return PSSysAIWorkerAgentBase.get(this, n);
    }

    private static Object get(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIWorkerAgentBase.getAgentInfo();
            }
            case 1: {
                return pSSysAIWorkerAgentBase.getAIPlatformType();
            }
            case 2: {
                return pSSysAIWorkerAgentBase.getAIWorkerAgentParams();
            }
            case 3: {
                return pSSysAIWorkerAgentBase.getAIWorkerAgentTag();
            }
            case 4: {
                return pSSysAIWorkerAgentBase.getAIWorkerAgentTag2();
            }
            case 5: {
                return pSSysAIWorkerAgentBase.getAIWorkerAgentType();
            }
            case 6: {
                return pSSysAIWorkerAgentBase.getCodeName();
            }
            case 7: {
                return pSSysAIWorkerAgentBase.getCreateDate();
            }
            case 8: {
                return pSSysAIWorkerAgentBase.getCreateMan();
            }
            case 9: {
                return pSSysAIWorkerAgentBase.getCustomCode();
            }
            case 10: {
                return pSSysAIWorkerAgentBase.getCustomMode();
            }
            case 11: {
                return pSSysAIWorkerAgentBase.getMemo();
            }
            case 12: {
                return pSSysAIWorkerAgentBase.getPSDEId();
            }
            case 13: {
                return pSSysAIWorkerAgentBase.getPSDEName();
            }
            case 14: {
                return pSSysAIWorkerAgentBase.getPSSysAIFactoryId();
            }
            case 15: {
                return pSSysAIWorkerAgentBase.getPSSysAIFactoryName();
            }
            case 16: {
                return pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentId();
            }
            case 17: {
                return pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentName();
            }
            case 18: {
                return pSSysAIWorkerAgentBase.getPSSysSFPluginId();
            }
            case 19: {
                return pSSysAIWorkerAgentBase.getPSSysSFPluginName();
            }
            case 20: {
                return pSSysAIWorkerAgentBase.getUpdateDate();
            }
            case 21: {
                return pSSysAIWorkerAgentBase.getUpdateMan();
            }
            case 22: {
                return pSSysAIWorkerAgentBase.getUserCat();
            }
            case 23: {
                return pSSysAIWorkerAgentBase.getUserTag();
            }
            case 24: {
                return pSSysAIWorkerAgentBase.getUserTag2();
            }
            case 25: {
                return pSSysAIWorkerAgentBase.getUserTag3();
            }
            case 26: {
                return pSSysAIWorkerAgentBase.getUserTag4();
            }
            case 27: {
                return pSSysAIWorkerAgentBase.getValidFlag();
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
        PSSysAIWorkerAgentBase.set(this, n, object);
    }

    private static void set(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysAIWorkerAgentBase.setAgentInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysAIWorkerAgentBase.setAIPlatformType(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysAIWorkerAgentBase.setAIWorkerAgentParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysAIWorkerAgentBase.setAIWorkerAgentTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysAIWorkerAgentBase.setAIWorkerAgentTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysAIWorkerAgentBase.setAIWorkerAgentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysAIWorkerAgentBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysAIWorkerAgentBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSysAIWorkerAgentBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysAIWorkerAgentBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysAIWorkerAgentBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysAIWorkerAgentBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysAIWorkerAgentBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysAIWorkerAgentBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysAIWorkerAgentBase.setPSSysAIFactoryId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysAIWorkerAgentBase.setPSSysAIFactoryName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysAIWorkerAgentBase.setPSSysAIWorkerAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysAIWorkerAgentBase.setPSSysAIWorkerAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysAIWorkerAgentBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysAIWorkerAgentBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysAIWorkerAgentBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSSysAIWorkerAgentBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysAIWorkerAgentBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysAIWorkerAgentBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysAIWorkerAgentBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysAIWorkerAgentBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysAIWorkerAgentBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysAIWorkerAgentBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysAIWorkerAgentBase.isNull(this, n);
    }

    private static boolean isNull(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIWorkerAgentBase.getAgentInfo() == null;
            }
            case 1: {
                return pSSysAIWorkerAgentBase.getAIPlatformType() == null;
            }
            case 2: {
                return pSSysAIWorkerAgentBase.getAIWorkerAgentParams() == null;
            }
            case 3: {
                return pSSysAIWorkerAgentBase.getAIWorkerAgentTag() == null;
            }
            case 4: {
                return pSSysAIWorkerAgentBase.getAIWorkerAgentTag2() == null;
            }
            case 5: {
                return pSSysAIWorkerAgentBase.getAIWorkerAgentType() == null;
            }
            case 6: {
                return pSSysAIWorkerAgentBase.getCodeName() == null;
            }
            case 7: {
                return pSSysAIWorkerAgentBase.getCreateDate() == null;
            }
            case 8: {
                return pSSysAIWorkerAgentBase.getCreateMan() == null;
            }
            case 9: {
                return pSSysAIWorkerAgentBase.getCustomCode() == null;
            }
            case 10: {
                return pSSysAIWorkerAgentBase.getCustomMode() == null;
            }
            case 11: {
                return pSSysAIWorkerAgentBase.getMemo() == null;
            }
            case 12: {
                return pSSysAIWorkerAgentBase.getPSDEId() == null;
            }
            case 13: {
                return pSSysAIWorkerAgentBase.getPSDEName() == null;
            }
            case 14: {
                return pSSysAIWorkerAgentBase.getPSSysAIFactoryId() == null;
            }
            case 15: {
                return pSSysAIWorkerAgentBase.getPSSysAIFactoryName() == null;
            }
            case 16: {
                return pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentId() == null;
            }
            case 17: {
                return pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentName() == null;
            }
            case 18: {
                return pSSysAIWorkerAgentBase.getPSSysSFPluginId() == null;
            }
            case 19: {
                return pSSysAIWorkerAgentBase.getPSSysSFPluginName() == null;
            }
            case 20: {
                return pSSysAIWorkerAgentBase.getUpdateDate() == null;
            }
            case 21: {
                return pSSysAIWorkerAgentBase.getUpdateMan() == null;
            }
            case 22: {
                return pSSysAIWorkerAgentBase.getUserCat() == null;
            }
            case 23: {
                return pSSysAIWorkerAgentBase.getUserTag() == null;
            }
            case 24: {
                return pSSysAIWorkerAgentBase.getUserTag2() == null;
            }
            case 25: {
                return pSSysAIWorkerAgentBase.getUserTag3() == null;
            }
            case 26: {
                return pSSysAIWorkerAgentBase.getUserTag4() == null;
            }
            case 27: {
                return pSSysAIWorkerAgentBase.getValidFlag() == null;
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
        return PSSysAIWorkerAgentBase.contains(this, n);
    }

    private static boolean contains(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIWorkerAgentBase.isAgentInfoDirty();
            }
            case 1: {
                return pSSysAIWorkerAgentBase.isAIPlatformTypeDirty();
            }
            case 2: {
                return pSSysAIWorkerAgentBase.isAIWorkerAgentParamsDirty();
            }
            case 3: {
                return pSSysAIWorkerAgentBase.isAIWorkerAgentTagDirty();
            }
            case 4: {
                return pSSysAIWorkerAgentBase.isAIWorkerAgentTag2Dirty();
            }
            case 5: {
                return pSSysAIWorkerAgentBase.isAIWorkerAgentTypeDirty();
            }
            case 6: {
                return pSSysAIWorkerAgentBase.isCodeNameDirty();
            }
            case 7: {
                return pSSysAIWorkerAgentBase.isCreateDateDirty();
            }
            case 8: {
                return pSSysAIWorkerAgentBase.isCreateManDirty();
            }
            case 9: {
                return pSSysAIWorkerAgentBase.isCustomCodeDirty();
            }
            case 10: {
                return pSSysAIWorkerAgentBase.isCustomModeDirty();
            }
            case 11: {
                return pSSysAIWorkerAgentBase.isMemoDirty();
            }
            case 12: {
                return pSSysAIWorkerAgentBase.isPSDEIdDirty();
            }
            case 13: {
                return pSSysAIWorkerAgentBase.isPSDENameDirty();
            }
            case 14: {
                return pSSysAIWorkerAgentBase.isPSSysAIFactoryIdDirty();
            }
            case 15: {
                return pSSysAIWorkerAgentBase.isPSSysAIFactoryNameDirty();
            }
            case 16: {
                return pSSysAIWorkerAgentBase.isPSSysAIWorkerAgentIdDirty();
            }
            case 17: {
                return pSSysAIWorkerAgentBase.isPSSysAIWorkerAgentNameDirty();
            }
            case 18: {
                return pSSysAIWorkerAgentBase.isPSSysSFPluginIdDirty();
            }
            case 19: {
                return pSSysAIWorkerAgentBase.isPSSysSFPluginNameDirty();
            }
            case 20: {
                return pSSysAIWorkerAgentBase.isUpdateDateDirty();
            }
            case 21: {
                return pSSysAIWorkerAgentBase.isUpdateManDirty();
            }
            case 22: {
                return pSSysAIWorkerAgentBase.isUserCatDirty();
            }
            case 23: {
                return pSSysAIWorkerAgentBase.isUserTagDirty();
            }
            case 24: {
                return pSSysAIWorkerAgentBase.isUserTag2Dirty();
            }
            case 25: {
                return pSSysAIWorkerAgentBase.isUserTag3Dirty();
            }
            case 26: {
                return pSSysAIWorkerAgentBase.isUserTag4Dirty();
            }
            case 27: {
                return pSSysAIWorkerAgentBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysAIWorkerAgentBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysAIWorkerAgentBase.getAgentInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agentinfo", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getAgentInfo()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getAIPlatformType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aiplatformtype", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getAIPlatformType()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getAIWorkerAgentParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aiworkeragentparams", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getAIWorkerAgentParams()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getAIWorkerAgentTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aiworkeragenttag", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getAIWorkerAgentTag()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getAIWorkerAgentTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aiworkeragenttag2", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getAIWorkerAgentTag2()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getAIWorkerAgentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aiworkeragenttype", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getAIWorkerAgentType()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSSysAIFactoryId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryid", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getPSSysAIFactoryId()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSSysAIFactoryName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryname", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getPSSysAIFactoryName()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaiworkeragentid", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentId()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaiworkeragentname", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentName()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysAIWorkerAgentBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysAIWorkerAgentBase.getJSONValue((Object)pSSysAIWorkerAgentBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysAIWorkerAgentBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysAIWorkerAgentBase.getAgentInfo() != null) {
            object = pSSysAIWorkerAgentBase.getAgentInfo();
            xmlNode.setAttribute(FIELD_AGENTINFO, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIWorkerAgentBase.getAIPlatformType() != null) {
            object = pSSysAIWorkerAgentBase.getAIPlatformType();
            xmlNode.setAttribute(FIELD_AIPLATFORMTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIWorkerAgentBase.getAIWorkerAgentParams() != null) {
            object = pSSysAIWorkerAgentBase.getAIWorkerAgentParams();
            xmlNode.setAttribute(FIELD_AIWORKERAGENTPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIWorkerAgentBase.getAIWorkerAgentTag() != null) {
            object = pSSysAIWorkerAgentBase.getAIWorkerAgentTag();
            xmlNode.setAttribute(FIELD_AIWORKERAGENTTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIWorkerAgentBase.getAIWorkerAgentTag2() != null) {
            object = pSSysAIWorkerAgentBase.getAIWorkerAgentTag2();
            xmlNode.setAttribute(FIELD_AIWORKERAGENTTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIWorkerAgentBase.getAIWorkerAgentType() != null) {
            object = pSSysAIWorkerAgentBase.getAIWorkerAgentType();
            xmlNode.setAttribute(FIELD_AIWORKERAGENTTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIWorkerAgentBase.getCodeName() != null) {
            object = pSSysAIWorkerAgentBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getCreateDate() != null) {
            object = pSSysAIWorkerAgentBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysAIWorkerAgentBase.getCreateMan() != null) {
            object = pSSysAIWorkerAgentBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getCustomCode() != null) {
            object = pSSysAIWorkerAgentBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getCustomMode() != null) {
            object = pSSysAIWorkerAgentBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAIWorkerAgentBase.getMemo() != null) {
            object = pSSysAIWorkerAgentBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSDEId() != null) {
            object = pSSysAIWorkerAgentBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSDEName() != null) {
            object = pSSysAIWorkerAgentBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSSysAIFactoryId() != null) {
            object = pSSysAIWorkerAgentBase.getPSSysAIFactoryId();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSSysAIFactoryName() != null) {
            object = pSSysAIWorkerAgentBase.getPSSysAIFactoryName();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentId() != null) {
            object = pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentId();
            xmlNode.setAttribute(FIELD_PSSYSAIWORKERAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentName() != null) {
            object = pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentName();
            xmlNode.setAttribute(FIELD_PSSYSAIWORKERAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSSysSFPluginId() != null) {
            object = pSSysAIWorkerAgentBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getPSSysSFPluginName() != null) {
            object = pSSysAIWorkerAgentBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getUpdateDate() != null) {
            object = pSSysAIWorkerAgentBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysAIWorkerAgentBase.getUpdateMan() != null) {
            object = pSSysAIWorkerAgentBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getUserCat() != null) {
            object = pSSysAIWorkerAgentBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getUserTag() != null) {
            object = pSSysAIWorkerAgentBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getUserTag2() != null) {
            object = pSSysAIWorkerAgentBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getUserTag3() != null) {
            object = pSSysAIWorkerAgentBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getUserTag4() != null) {
            object = pSSysAIWorkerAgentBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIWorkerAgentBase.getValidFlag() != null) {
            object = pSSysAIWorkerAgentBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysAIWorkerAgentBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysAIWorkerAgentBase.isAgentInfoDirty() && (bl || pSSysAIWorkerAgentBase.getAgentInfo() != null)) {
            iDataObject.set(FIELD_AGENTINFO, (Object)pSSysAIWorkerAgentBase.getAgentInfo());
        }
        if (pSSysAIWorkerAgentBase.isAIPlatformTypeDirty() && (bl || pSSysAIWorkerAgentBase.getAIPlatformType() != null)) {
            iDataObject.set(FIELD_AIPLATFORMTYPE, (Object)pSSysAIWorkerAgentBase.getAIPlatformType());
        }
        if (pSSysAIWorkerAgentBase.isAIWorkerAgentParamsDirty() && (bl || pSSysAIWorkerAgentBase.getAIWorkerAgentParams() != null)) {
            iDataObject.set(FIELD_AIWORKERAGENTPARAMS, (Object)pSSysAIWorkerAgentBase.getAIWorkerAgentParams());
        }
        if (pSSysAIWorkerAgentBase.isAIWorkerAgentTagDirty() && (bl || pSSysAIWorkerAgentBase.getAIWorkerAgentTag() != null)) {
            iDataObject.set(FIELD_AIWORKERAGENTTAG, (Object)pSSysAIWorkerAgentBase.getAIWorkerAgentTag());
        }
        if (pSSysAIWorkerAgentBase.isAIWorkerAgentTag2Dirty() && (bl || pSSysAIWorkerAgentBase.getAIWorkerAgentTag2() != null)) {
            iDataObject.set(FIELD_AIWORKERAGENTTAG2, (Object)pSSysAIWorkerAgentBase.getAIWorkerAgentTag2());
        }
        if (pSSysAIWorkerAgentBase.isAIWorkerAgentTypeDirty() && (bl || pSSysAIWorkerAgentBase.getAIWorkerAgentType() != null)) {
            iDataObject.set(FIELD_AIWORKERAGENTTYPE, (Object)pSSysAIWorkerAgentBase.getAIWorkerAgentType());
        }
        if (pSSysAIWorkerAgentBase.isCodeNameDirty() && (bl || pSSysAIWorkerAgentBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysAIWorkerAgentBase.getCodeName());
        }
        if (pSSysAIWorkerAgentBase.isCreateDateDirty() && (bl || pSSysAIWorkerAgentBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysAIWorkerAgentBase.getCreateDate());
        }
        if (pSSysAIWorkerAgentBase.isCreateManDirty() && (bl || pSSysAIWorkerAgentBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysAIWorkerAgentBase.getCreateMan());
        }
        if (pSSysAIWorkerAgentBase.isCustomCodeDirty() && (bl || pSSysAIWorkerAgentBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysAIWorkerAgentBase.getCustomCode());
        }
        if (pSSysAIWorkerAgentBase.isCustomModeDirty() && (bl || pSSysAIWorkerAgentBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysAIWorkerAgentBase.getCustomMode());
        }
        if (pSSysAIWorkerAgentBase.isMemoDirty() && (bl || pSSysAIWorkerAgentBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysAIWorkerAgentBase.getMemo());
        }
        if (pSSysAIWorkerAgentBase.isPSDEIdDirty() && (bl || pSSysAIWorkerAgentBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysAIWorkerAgentBase.getPSDEId());
        }
        if (pSSysAIWorkerAgentBase.isPSDENameDirty() && (bl || pSSysAIWorkerAgentBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysAIWorkerAgentBase.getPSDEName());
        }
        if (pSSysAIWorkerAgentBase.isPSSysAIFactoryIdDirty() && (bl || pSSysAIWorkerAgentBase.getPSSysAIFactoryId() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYID, (Object)pSSysAIWorkerAgentBase.getPSSysAIFactoryId());
        }
        if (pSSysAIWorkerAgentBase.isPSSysAIFactoryNameDirty() && (bl || pSSysAIWorkerAgentBase.getPSSysAIFactoryName() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYNAME, (Object)pSSysAIWorkerAgentBase.getPSSysAIFactoryName());
        }
        if (pSSysAIWorkerAgentBase.isPSSysAIWorkerAgentIdDirty() && (bl || pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentId() != null)) {
            iDataObject.set(FIELD_PSSYSAIWORKERAGENTID, (Object)pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentId());
        }
        if (pSSysAIWorkerAgentBase.isPSSysAIWorkerAgentNameDirty() && (bl || pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentName() != null)) {
            iDataObject.set(FIELD_PSSYSAIWORKERAGENTNAME, (Object)pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentName());
        }
        if (pSSysAIWorkerAgentBase.isPSSysSFPluginIdDirty() && (bl || pSSysAIWorkerAgentBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysAIWorkerAgentBase.getPSSysSFPluginId());
        }
        if (pSSysAIWorkerAgentBase.isPSSysSFPluginNameDirty() && (bl || pSSysAIWorkerAgentBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysAIWorkerAgentBase.getPSSysSFPluginName());
        }
        if (pSSysAIWorkerAgentBase.isUpdateDateDirty() && (bl || pSSysAIWorkerAgentBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysAIWorkerAgentBase.getUpdateDate());
        }
        if (pSSysAIWorkerAgentBase.isUpdateManDirty() && (bl || pSSysAIWorkerAgentBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysAIWorkerAgentBase.getUpdateMan());
        }
        if (pSSysAIWorkerAgentBase.isUserCatDirty() && (bl || pSSysAIWorkerAgentBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysAIWorkerAgentBase.getUserCat());
        }
        if (pSSysAIWorkerAgentBase.isUserTagDirty() && (bl || pSSysAIWorkerAgentBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysAIWorkerAgentBase.getUserTag());
        }
        if (pSSysAIWorkerAgentBase.isUserTag2Dirty() && (bl || pSSysAIWorkerAgentBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysAIWorkerAgentBase.getUserTag2());
        }
        if (pSSysAIWorkerAgentBase.isUserTag3Dirty() && (bl || pSSysAIWorkerAgentBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysAIWorkerAgentBase.getUserTag3());
        }
        if (pSSysAIWorkerAgentBase.isUserTag4Dirty() && (bl || pSSysAIWorkerAgentBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysAIWorkerAgentBase.getUserTag4());
        }
        if (pSSysAIWorkerAgentBase.isValidFlagDirty() && (bl || pSSysAIWorkerAgentBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysAIWorkerAgentBase.getValidFlag());
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
        return PSSysAIWorkerAgentBase.remove(this, n);
    }

    private static boolean remove(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysAIWorkerAgentBase.resetAgentInfo();
                return true;
            }
            case 1: {
                pSSysAIWorkerAgentBase.resetAIPlatformType();
                return true;
            }
            case 2: {
                pSSysAIWorkerAgentBase.resetAIWorkerAgentParams();
                return true;
            }
            case 3: {
                pSSysAIWorkerAgentBase.resetAIWorkerAgentTag();
                return true;
            }
            case 4: {
                pSSysAIWorkerAgentBase.resetAIWorkerAgentTag2();
                return true;
            }
            case 5: {
                pSSysAIWorkerAgentBase.resetAIWorkerAgentType();
                return true;
            }
            case 6: {
                pSSysAIWorkerAgentBase.resetCodeName();
                return true;
            }
            case 7: {
                pSSysAIWorkerAgentBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSSysAIWorkerAgentBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSSysAIWorkerAgentBase.resetCustomCode();
                return true;
            }
            case 10: {
                pSSysAIWorkerAgentBase.resetCustomMode();
                return true;
            }
            case 11: {
                pSSysAIWorkerAgentBase.resetMemo();
                return true;
            }
            case 12: {
                pSSysAIWorkerAgentBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSSysAIWorkerAgentBase.resetPSDEName();
                return true;
            }
            case 14: {
                pSSysAIWorkerAgentBase.resetPSSysAIFactoryId();
                return true;
            }
            case 15: {
                pSSysAIWorkerAgentBase.resetPSSysAIFactoryName();
                return true;
            }
            case 16: {
                pSSysAIWorkerAgentBase.resetPSSysAIWorkerAgentId();
                return true;
            }
            case 17: {
                pSSysAIWorkerAgentBase.resetPSSysAIWorkerAgentName();
                return true;
            }
            case 18: {
                pSSysAIWorkerAgentBase.resetPSSysSFPluginId();
                return true;
            }
            case 19: {
                pSSysAIWorkerAgentBase.resetPSSysSFPluginName();
                return true;
            }
            case 20: {
                pSSysAIWorkerAgentBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSSysAIWorkerAgentBase.resetUpdateMan();
                return true;
            }
            case 22: {
                pSSysAIWorkerAgentBase.resetUserCat();
                return true;
            }
            case 23: {
                pSSysAIWorkerAgentBase.resetUserTag();
                return true;
            }
            case 24: {
                pSSysAIWorkerAgentBase.resetUserTag2();
                return true;
            }
            case 25: {
                pSSysAIWorkerAgentBase.resetUserTag3();
                return true;
            }
            case 26: {
                pSSysAIWorkerAgentBase.resetUserTag4();
                return true;
            }
            case 27: {
                pSSysAIWorkerAgentBase.resetValidFlag();
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

    private PSSysAIWorkerAgentBase getProxyEntity() {
        return this.proxyPSSysAIWorkerAgentBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysAIWorkerAgentBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysAIWorkerAgentBase) {
            this.proxyPSSysAIWorkerAgentBase = (PSSysAIWorkerAgentBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIWorkerAgentService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AGENTINFO, 0);
        fieldIndexMap.put(FIELD_AIPLATFORMTYPE, 1);
        fieldIndexMap.put(FIELD_AIWORKERAGENTPARAMS, 2);
        fieldIndexMap.put(FIELD_AIWORKERAGENTTAG, 3);
        fieldIndexMap.put(FIELD_AIWORKERAGENTTAG2, 4);
        fieldIndexMap.put(FIELD_AIWORKERAGENTTYPE, 5);
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
        fieldIndexMap.put(FIELD_PSSYSAIWORKERAGENTID, 16);
        fieldIndexMap.put(FIELD_PSSYSAIWORKERAGENTNAME, 17);
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

