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

public abstract class PSSysAIChatAgentBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysAIChatAgentBase.class);
    public static final String FIELD_AGENTINFO = "AGENTINFO";
    public static final String FIELD_AICHATAGENTPARAMS = "AICHATAGENTPARAMS";
    public static final String FIELD_AICHATAGENTTAG = "AICHATAGENTTAG";
    public static final String FIELD_AICHATAGENTTAG2 = "AICHATAGENTTAG2";
    public static final String FIELD_AICHATAGENTTYPE = "AICHATAGENTTYPE";
    public static final String FIELD_AIPLATFORMTYPE = "AIPLATFORMTYPE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PROMPTSOURCE = "PROMPTSOURCE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSAICHATAGENTID = "PSSYSAICHATAGENTID";
    public static final String FIELD_PSSYSAICHATAGENTNAME = "PSSYSAICHATAGENTNAME";
    public static final String FIELD_PSSYSAIFACTORYID = "PSSYSAIFACTORYID";
    public static final String FIELD_PSSYSAIFACTORYNAME = "PSSYSAIFACTORYNAME";
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
    private static final int INDEX_AICHATAGENTPARAMS = 1;
    private static final int INDEX_AICHATAGENTTAG = 2;
    private static final int INDEX_AICHATAGENTTAG2 = 3;
    private static final int INDEX_AICHATAGENTTYPE = 4;
    private static final int INDEX_AIPLATFORMTYPE = 5;
    private static final int INDEX_CODENAME = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_CUSTOMCODE = 9;
    private static final int INDEX_CUSTOMMODE = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_PROMPTSOURCE = 12;
    private static final int INDEX_PSDEID = 13;
    private static final int INDEX_PSDENAME = 14;
    private static final int INDEX_PSSYSAICHATAGENTID = 15;
    private static final int INDEX_PSSYSAICHATAGENTNAME = 16;
    private static final int INDEX_PSSYSAIFACTORYID = 17;
    private static final int INDEX_PSSYSAIFACTORYNAME = 18;
    private static final int INDEX_PSSYSSFPLUGINID = 19;
    private static final int INDEX_PSSYSSFPLUGINNAME = 20;
    private static final int INDEX_UPDATEDATE = 21;
    private static final int INDEX_UPDATEMAN = 22;
    private static final int INDEX_USERCAT = 23;
    private static final int INDEX_USERTAG = 24;
    private static final int INDEX_USERTAG2 = 25;
    private static final int INDEX_USERTAG3 = 26;
    private static final int INDEX_USERTAG4 = 27;
    private static final int INDEX_VALIDFLAG = 28;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysAIChatAgentBase proxyPSSysAIChatAgentBase = null;
    private boolean agentinfoDirtyFlag = false;
    private boolean aichatagentparamsDirtyFlag = false;
    private boolean aichatagenttagDirtyFlag = false;
    private boolean aichatagenttag2DirtyFlag = false;
    private boolean aichatagenttypeDirtyFlag = false;
    private boolean aiplatformtypeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean promptsourceDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssysaichatagentidDirtyFlag = false;
    private boolean pssysaichatagentnameDirtyFlag = false;
    private boolean pssysaifactoryidDirtyFlag = false;
    private boolean pssysaifactorynameDirtyFlag = false;
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
    @Column(name="aichatagentparams")
    private String aichatagentparams;
    @Column(name="aichatagenttag")
    private String aichatagenttag;
    @Column(name="aichatagenttag2")
    private String aichatagenttag2;
    @Column(name="aichatagenttype")
    private String aichatagenttype;
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
    @Column(name="promptsource")
    private String promptsource;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssysaichatagentid")
    private String pssysaichatagentid;
    @Column(name="pssysaichatagentname")
    private String pssysaichatagentname;
    @Column(name="pssysaifactoryid")
    private String pssysaifactoryid;
    @Column(name="pssysaifactoryname")
    private String pssysaifactoryname;
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

    public void setAIChatAgentParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIChatAgentParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aichatagentparams = string;
        this.aichatagentparamsDirtyFlag = true;
    }

    public String getAIChatAgentParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIChatAgentParams();
        }
        return this.aichatagentparams;
    }

    public boolean isAIChatAgentParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIChatAgentParamsDirty();
        }
        return this.aichatagentparamsDirtyFlag;
    }

    public void resetAIChatAgentParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIChatAgentParams();
            return;
        }
        this.aichatagentparamsDirtyFlag = false;
        this.aichatagentparams = null;
    }

    public void setAIChatAgentTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIChatAgentTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aichatagenttag = string;
        this.aichatagenttagDirtyFlag = true;
    }

    public String getAIChatAgentTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIChatAgentTag();
        }
        return this.aichatagenttag;
    }

    public boolean isAIChatAgentTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIChatAgentTagDirty();
        }
        return this.aichatagenttagDirtyFlag;
    }

    public void resetAIChatAgentTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIChatAgentTag();
            return;
        }
        this.aichatagenttagDirtyFlag = false;
        this.aichatagenttag = null;
    }

    public void setAIChatAgentTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIChatAgentTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aichatagenttag2 = string;
        this.aichatagenttag2DirtyFlag = true;
    }

    public String getAIChatAgentTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIChatAgentTag2();
        }
        return this.aichatagenttag2;
    }

    public boolean isAIChatAgentTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIChatAgentTag2Dirty();
        }
        return this.aichatagenttag2DirtyFlag;
    }

    public void resetAIChatAgentTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIChatAgentTag2();
            return;
        }
        this.aichatagenttag2DirtyFlag = false;
        this.aichatagenttag2 = null;
    }

    public void setAIChatAgentType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIChatAgentType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aichatagenttype = string;
        this.aichatagenttypeDirtyFlag = true;
    }

    public String getAIChatAgentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIChatAgentType();
        }
        return this.aichatagenttype;
    }

    public boolean isAIChatAgentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIChatAgentTypeDirty();
        }
        return this.aichatagenttypeDirtyFlag;
    }

    public void resetAIChatAgentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIChatAgentType();
            return;
        }
        this.aichatagenttypeDirtyFlag = false;
        this.aichatagenttype = null;
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

    public void setPromptSource(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPromptSource(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.promptsource = string;
        this.promptsourceDirtyFlag = true;
    }

    public String getPromptSource() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPromptSource();
        }
        return this.promptsource;
    }

    public boolean isPromptSourceDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPromptSourceDirty();
        }
        return this.promptsourceDirtyFlag;
    }

    public void resetPromptSource() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPromptSource();
            return;
        }
        this.promptsourceDirtyFlag = false;
        this.promptsource = null;
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

    public void setPSSysAIChatAgentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIChatAgentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaichatagentid = string;
        this.pssysaichatagentidDirtyFlag = true;
    }

    public String getPSSysAIChatAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIChatAgentId();
        }
        return this.pssysaichatagentid;
    }

    public boolean isPSSysAIChatAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIChatAgentIdDirty();
        }
        return this.pssysaichatagentidDirtyFlag;
    }

    public void resetPSSysAIChatAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIChatAgentId();
            return;
        }
        this.pssysaichatagentidDirtyFlag = false;
        this.pssysaichatagentid = null;
    }

    public void setPSSysAIChatAgentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIChatAgentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaichatagentname = string;
        this.pssysaichatagentnameDirtyFlag = true;
    }

    public String getPSSysAIChatAgentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIChatAgentName();
        }
        return this.pssysaichatagentname;
    }

    public boolean isPSSysAIChatAgentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIChatAgentNameDirty();
        }
        return this.pssysaichatagentnameDirtyFlag;
    }

    public void resetPSSysAIChatAgentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIChatAgentName();
            return;
        }
        this.pssysaichatagentnameDirtyFlag = false;
        this.pssysaichatagentname = null;
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
        PSSysAIChatAgentBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysAIChatAgentBase pSSysAIChatAgentBase) {
        pSSysAIChatAgentBase.resetAgentInfo();
        pSSysAIChatAgentBase.resetAIChatAgentParams();
        pSSysAIChatAgentBase.resetAIChatAgentTag();
        pSSysAIChatAgentBase.resetAIChatAgentTag2();
        pSSysAIChatAgentBase.resetAIChatAgentType();
        pSSysAIChatAgentBase.resetAIPlatformType();
        pSSysAIChatAgentBase.resetCodeName();
        pSSysAIChatAgentBase.resetCreateDate();
        pSSysAIChatAgentBase.resetCreateMan();
        pSSysAIChatAgentBase.resetCustomCode();
        pSSysAIChatAgentBase.resetCustomMode();
        pSSysAIChatAgentBase.resetMemo();
        pSSysAIChatAgentBase.resetPromptSource();
        pSSysAIChatAgentBase.resetPSDEId();
        pSSysAIChatAgentBase.resetPSDEName();
        pSSysAIChatAgentBase.resetPSSysAIChatAgentId();
        pSSysAIChatAgentBase.resetPSSysAIChatAgentName();
        pSSysAIChatAgentBase.resetPSSysAIFactoryId();
        pSSysAIChatAgentBase.resetPSSysAIFactoryName();
        pSSysAIChatAgentBase.resetPSSysSFPluginId();
        pSSysAIChatAgentBase.resetPSSysSFPluginName();
        pSSysAIChatAgentBase.resetUpdateDate();
        pSSysAIChatAgentBase.resetUpdateMan();
        pSSysAIChatAgentBase.resetUserCat();
        pSSysAIChatAgentBase.resetUserTag();
        pSSysAIChatAgentBase.resetUserTag2();
        pSSysAIChatAgentBase.resetUserTag3();
        pSSysAIChatAgentBase.resetUserTag4();
        pSSysAIChatAgentBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAgentInfoDirty()) {
            hashMap.put(FIELD_AGENTINFO, this.getAgentInfo());
        }
        if (!bl || this.isAIChatAgentParamsDirty()) {
            hashMap.put(FIELD_AICHATAGENTPARAMS, this.getAIChatAgentParams());
        }
        if (!bl || this.isAIChatAgentTagDirty()) {
            hashMap.put(FIELD_AICHATAGENTTAG, this.getAIChatAgentTag());
        }
        if (!bl || this.isAIChatAgentTag2Dirty()) {
            hashMap.put(FIELD_AICHATAGENTTAG2, this.getAIChatAgentTag2());
        }
        if (!bl || this.isAIChatAgentTypeDirty()) {
            hashMap.put(FIELD_AICHATAGENTTYPE, this.getAIChatAgentType());
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
        if (!bl || this.isPromptSourceDirty()) {
            hashMap.put(FIELD_PROMPTSOURCE, this.getPromptSource());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSysAIChatAgentIdDirty()) {
            hashMap.put(FIELD_PSSYSAICHATAGENTID, this.getPSSysAIChatAgentId());
        }
        if (!bl || this.isPSSysAIChatAgentNameDirty()) {
            hashMap.put(FIELD_PSSYSAICHATAGENTNAME, this.getPSSysAIChatAgentName());
        }
        if (!bl || this.isPSSysAIFactoryIdDirty()) {
            hashMap.put(FIELD_PSSYSAIFACTORYID, this.getPSSysAIFactoryId());
        }
        if (!bl || this.isPSSysAIFactoryNameDirty()) {
            hashMap.put(FIELD_PSSYSAIFACTORYNAME, this.getPSSysAIFactoryName());
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
        return PSSysAIChatAgentBase.get(this, n);
    }

    private static Object get(PSSysAIChatAgentBase pSSysAIChatAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIChatAgentBase.getAgentInfo();
            }
            case 1: {
                return pSSysAIChatAgentBase.getAIChatAgentParams();
            }
            case 2: {
                return pSSysAIChatAgentBase.getAIChatAgentTag();
            }
            case 3: {
                return pSSysAIChatAgentBase.getAIChatAgentTag2();
            }
            case 4: {
                return pSSysAIChatAgentBase.getAIChatAgentType();
            }
            case 5: {
                return pSSysAIChatAgentBase.getAIPlatformType();
            }
            case 6: {
                return pSSysAIChatAgentBase.getCodeName();
            }
            case 7: {
                return pSSysAIChatAgentBase.getCreateDate();
            }
            case 8: {
                return pSSysAIChatAgentBase.getCreateMan();
            }
            case 9: {
                return pSSysAIChatAgentBase.getCustomCode();
            }
            case 10: {
                return pSSysAIChatAgentBase.getCustomMode();
            }
            case 11: {
                return pSSysAIChatAgentBase.getMemo();
            }
            case 12: {
                return pSSysAIChatAgentBase.getPromptSource();
            }
            case 13: {
                return pSSysAIChatAgentBase.getPSDEId();
            }
            case 14: {
                return pSSysAIChatAgentBase.getPSDEName();
            }
            case 15: {
                return pSSysAIChatAgentBase.getPSSysAIChatAgentId();
            }
            case 16: {
                return pSSysAIChatAgentBase.getPSSysAIChatAgentName();
            }
            case 17: {
                return pSSysAIChatAgentBase.getPSSysAIFactoryId();
            }
            case 18: {
                return pSSysAIChatAgentBase.getPSSysAIFactoryName();
            }
            case 19: {
                return pSSysAIChatAgentBase.getPSSysSFPluginId();
            }
            case 20: {
                return pSSysAIChatAgentBase.getPSSysSFPluginName();
            }
            case 21: {
                return pSSysAIChatAgentBase.getUpdateDate();
            }
            case 22: {
                return pSSysAIChatAgentBase.getUpdateMan();
            }
            case 23: {
                return pSSysAIChatAgentBase.getUserCat();
            }
            case 24: {
                return pSSysAIChatAgentBase.getUserTag();
            }
            case 25: {
                return pSSysAIChatAgentBase.getUserTag2();
            }
            case 26: {
                return pSSysAIChatAgentBase.getUserTag3();
            }
            case 27: {
                return pSSysAIChatAgentBase.getUserTag4();
            }
            case 28: {
                return pSSysAIChatAgentBase.getValidFlag();
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
        PSSysAIChatAgentBase.set(this, n, object);
    }

    private static void set(PSSysAIChatAgentBase pSSysAIChatAgentBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysAIChatAgentBase.setAgentInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysAIChatAgentBase.setAIChatAgentParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysAIChatAgentBase.setAIChatAgentTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysAIChatAgentBase.setAIChatAgentTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysAIChatAgentBase.setAIChatAgentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysAIChatAgentBase.setAIPlatformType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysAIChatAgentBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysAIChatAgentBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSysAIChatAgentBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysAIChatAgentBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysAIChatAgentBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysAIChatAgentBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysAIChatAgentBase.setPromptSource(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysAIChatAgentBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysAIChatAgentBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysAIChatAgentBase.setPSSysAIChatAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysAIChatAgentBase.setPSSysAIChatAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysAIChatAgentBase.setPSSysAIFactoryId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysAIChatAgentBase.setPSSysAIFactoryName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysAIChatAgentBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysAIChatAgentBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysAIChatAgentBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 22: {
                pSSysAIChatAgentBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysAIChatAgentBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysAIChatAgentBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysAIChatAgentBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysAIChatAgentBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysAIChatAgentBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysAIChatAgentBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysAIChatAgentBase.isNull(this, n);
    }

    private static boolean isNull(PSSysAIChatAgentBase pSSysAIChatAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIChatAgentBase.getAgentInfo() == null;
            }
            case 1: {
                return pSSysAIChatAgentBase.getAIChatAgentParams() == null;
            }
            case 2: {
                return pSSysAIChatAgentBase.getAIChatAgentTag() == null;
            }
            case 3: {
                return pSSysAIChatAgentBase.getAIChatAgentTag2() == null;
            }
            case 4: {
                return pSSysAIChatAgentBase.getAIChatAgentType() == null;
            }
            case 5: {
                return pSSysAIChatAgentBase.getAIPlatformType() == null;
            }
            case 6: {
                return pSSysAIChatAgentBase.getCodeName() == null;
            }
            case 7: {
                return pSSysAIChatAgentBase.getCreateDate() == null;
            }
            case 8: {
                return pSSysAIChatAgentBase.getCreateMan() == null;
            }
            case 9: {
                return pSSysAIChatAgentBase.getCustomCode() == null;
            }
            case 10: {
                return pSSysAIChatAgentBase.getCustomMode() == null;
            }
            case 11: {
                return pSSysAIChatAgentBase.getMemo() == null;
            }
            case 12: {
                return pSSysAIChatAgentBase.getPromptSource() == null;
            }
            case 13: {
                return pSSysAIChatAgentBase.getPSDEId() == null;
            }
            case 14: {
                return pSSysAIChatAgentBase.getPSDEName() == null;
            }
            case 15: {
                return pSSysAIChatAgentBase.getPSSysAIChatAgentId() == null;
            }
            case 16: {
                return pSSysAIChatAgentBase.getPSSysAIChatAgentName() == null;
            }
            case 17: {
                return pSSysAIChatAgentBase.getPSSysAIFactoryId() == null;
            }
            case 18: {
                return pSSysAIChatAgentBase.getPSSysAIFactoryName() == null;
            }
            case 19: {
                return pSSysAIChatAgentBase.getPSSysSFPluginId() == null;
            }
            case 20: {
                return pSSysAIChatAgentBase.getPSSysSFPluginName() == null;
            }
            case 21: {
                return pSSysAIChatAgentBase.getUpdateDate() == null;
            }
            case 22: {
                return pSSysAIChatAgentBase.getUpdateMan() == null;
            }
            case 23: {
                return pSSysAIChatAgentBase.getUserCat() == null;
            }
            case 24: {
                return pSSysAIChatAgentBase.getUserTag() == null;
            }
            case 25: {
                return pSSysAIChatAgentBase.getUserTag2() == null;
            }
            case 26: {
                return pSSysAIChatAgentBase.getUserTag3() == null;
            }
            case 27: {
                return pSSysAIChatAgentBase.getUserTag4() == null;
            }
            case 28: {
                return pSSysAIChatAgentBase.getValidFlag() == null;
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
        return PSSysAIChatAgentBase.contains(this, n);
    }

    private static boolean contains(PSSysAIChatAgentBase pSSysAIChatAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIChatAgentBase.isAgentInfoDirty();
            }
            case 1: {
                return pSSysAIChatAgentBase.isAIChatAgentParamsDirty();
            }
            case 2: {
                return pSSysAIChatAgentBase.isAIChatAgentTagDirty();
            }
            case 3: {
                return pSSysAIChatAgentBase.isAIChatAgentTag2Dirty();
            }
            case 4: {
                return pSSysAIChatAgentBase.isAIChatAgentTypeDirty();
            }
            case 5: {
                return pSSysAIChatAgentBase.isAIPlatformTypeDirty();
            }
            case 6: {
                return pSSysAIChatAgentBase.isCodeNameDirty();
            }
            case 7: {
                return pSSysAIChatAgentBase.isCreateDateDirty();
            }
            case 8: {
                return pSSysAIChatAgentBase.isCreateManDirty();
            }
            case 9: {
                return pSSysAIChatAgentBase.isCustomCodeDirty();
            }
            case 10: {
                return pSSysAIChatAgentBase.isCustomModeDirty();
            }
            case 11: {
                return pSSysAIChatAgentBase.isMemoDirty();
            }
            case 12: {
                return pSSysAIChatAgentBase.isPromptSourceDirty();
            }
            case 13: {
                return pSSysAIChatAgentBase.isPSDEIdDirty();
            }
            case 14: {
                return pSSysAIChatAgentBase.isPSDENameDirty();
            }
            case 15: {
                return pSSysAIChatAgentBase.isPSSysAIChatAgentIdDirty();
            }
            case 16: {
                return pSSysAIChatAgentBase.isPSSysAIChatAgentNameDirty();
            }
            case 17: {
                return pSSysAIChatAgentBase.isPSSysAIFactoryIdDirty();
            }
            case 18: {
                return pSSysAIChatAgentBase.isPSSysAIFactoryNameDirty();
            }
            case 19: {
                return pSSysAIChatAgentBase.isPSSysSFPluginIdDirty();
            }
            case 20: {
                return pSSysAIChatAgentBase.isPSSysSFPluginNameDirty();
            }
            case 21: {
                return pSSysAIChatAgentBase.isUpdateDateDirty();
            }
            case 22: {
                return pSSysAIChatAgentBase.isUpdateManDirty();
            }
            case 23: {
                return pSSysAIChatAgentBase.isUserCatDirty();
            }
            case 24: {
                return pSSysAIChatAgentBase.isUserTagDirty();
            }
            case 25: {
                return pSSysAIChatAgentBase.isUserTag2Dirty();
            }
            case 26: {
                return pSSysAIChatAgentBase.isUserTag3Dirty();
            }
            case 27: {
                return pSSysAIChatAgentBase.isUserTag4Dirty();
            }
            case 28: {
                return pSSysAIChatAgentBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysAIChatAgentBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysAIChatAgentBase pSSysAIChatAgentBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysAIChatAgentBase.getAgentInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agentinfo", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getAgentInfo()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getAIChatAgentParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aichatagentparams", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getAIChatAgentParams()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getAIChatAgentTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aichatagenttag", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getAIChatAgentTag()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getAIChatAgentTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aichatagenttag2", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getAIChatAgentTag2()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getAIChatAgentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aichatagenttype", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getAIChatAgentType()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getAIPlatformType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aiplatformtype", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getAIPlatformType()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getPromptSource() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"promptsource", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getPromptSource()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getPSSysAIChatAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaichatagentid", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getPSSysAIChatAgentId()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getPSSysAIChatAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaichatagentname", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getPSSysAIChatAgentName()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getPSSysAIFactoryId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryid", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getPSSysAIFactoryId()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getPSSysAIFactoryName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryname", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getPSSysAIFactoryName()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysAIChatAgentBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysAIChatAgentBase.getJSONValue((Object)pSSysAIChatAgentBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysAIChatAgentBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysAIChatAgentBase pSSysAIChatAgentBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysAIChatAgentBase.getAgentInfo() != null) {
            object = pSSysAIChatAgentBase.getAgentInfo();
            xmlNode.setAttribute(FIELD_AGENTINFO, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIChatAgentBase.getAIChatAgentParams() != null) {
            object = pSSysAIChatAgentBase.getAIChatAgentParams();
            xmlNode.setAttribute(FIELD_AICHATAGENTPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIChatAgentBase.getAIChatAgentTag() != null) {
            object = pSSysAIChatAgentBase.getAIChatAgentTag();
            xmlNode.setAttribute(FIELD_AICHATAGENTTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIChatAgentBase.getAIChatAgentTag2() != null) {
            object = pSSysAIChatAgentBase.getAIChatAgentTag2();
            xmlNode.setAttribute(FIELD_AICHATAGENTTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIChatAgentBase.getAIChatAgentType() != null) {
            object = pSSysAIChatAgentBase.getAIChatAgentType();
            xmlNode.setAttribute(FIELD_AICHATAGENTTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIChatAgentBase.getAIPlatformType() != null) {
            object = pSSysAIChatAgentBase.getAIPlatformType();
            xmlNode.setAttribute(FIELD_AIPLATFORMTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysAIChatAgentBase.getCodeName() != null) {
            object = pSSysAIChatAgentBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getCreateDate() != null) {
            object = pSSysAIChatAgentBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysAIChatAgentBase.getCreateMan() != null) {
            object = pSSysAIChatAgentBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getCustomCode() != null) {
            object = pSSysAIChatAgentBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getCustomMode() != null) {
            object = pSSysAIChatAgentBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAIChatAgentBase.getMemo() != null) {
            object = pSSysAIChatAgentBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getPromptSource() != null) {
            object = pSSysAIChatAgentBase.getPromptSource();
            xmlNode.setAttribute(FIELD_PROMPTSOURCE, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getPSDEId() != null) {
            object = pSSysAIChatAgentBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getPSDEName() != null) {
            object = pSSysAIChatAgentBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getPSSysAIChatAgentId() != null) {
            object = pSSysAIChatAgentBase.getPSSysAIChatAgentId();
            xmlNode.setAttribute(FIELD_PSSYSAICHATAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getPSSysAIChatAgentName() != null) {
            object = pSSysAIChatAgentBase.getPSSysAIChatAgentName();
            xmlNode.setAttribute(FIELD_PSSYSAICHATAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getPSSysAIFactoryId() != null) {
            object = pSSysAIChatAgentBase.getPSSysAIFactoryId();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getPSSysAIFactoryName() != null) {
            object = pSSysAIChatAgentBase.getPSSysAIFactoryName();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getPSSysSFPluginId() != null) {
            object = pSSysAIChatAgentBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getPSSysSFPluginName() != null) {
            object = pSSysAIChatAgentBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getUpdateDate() != null) {
            object = pSSysAIChatAgentBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysAIChatAgentBase.getUpdateMan() != null) {
            object = pSSysAIChatAgentBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getUserCat() != null) {
            object = pSSysAIChatAgentBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getUserTag() != null) {
            object = pSSysAIChatAgentBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getUserTag2() != null) {
            object = pSSysAIChatAgentBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getUserTag3() != null) {
            object = pSSysAIChatAgentBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getUserTag4() != null) {
            object = pSSysAIChatAgentBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIChatAgentBase.getValidFlag() != null) {
            object = pSSysAIChatAgentBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysAIChatAgentBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysAIChatAgentBase pSSysAIChatAgentBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysAIChatAgentBase.isAgentInfoDirty() && (bl || pSSysAIChatAgentBase.getAgentInfo() != null)) {
            iDataObject.set(FIELD_AGENTINFO, (Object)pSSysAIChatAgentBase.getAgentInfo());
        }
        if (pSSysAIChatAgentBase.isAIChatAgentParamsDirty() && (bl || pSSysAIChatAgentBase.getAIChatAgentParams() != null)) {
            iDataObject.set(FIELD_AICHATAGENTPARAMS, (Object)pSSysAIChatAgentBase.getAIChatAgentParams());
        }
        if (pSSysAIChatAgentBase.isAIChatAgentTagDirty() && (bl || pSSysAIChatAgentBase.getAIChatAgentTag() != null)) {
            iDataObject.set(FIELD_AICHATAGENTTAG, (Object)pSSysAIChatAgentBase.getAIChatAgentTag());
        }
        if (pSSysAIChatAgentBase.isAIChatAgentTag2Dirty() && (bl || pSSysAIChatAgentBase.getAIChatAgentTag2() != null)) {
            iDataObject.set(FIELD_AICHATAGENTTAG2, (Object)pSSysAIChatAgentBase.getAIChatAgentTag2());
        }
        if (pSSysAIChatAgentBase.isAIChatAgentTypeDirty() && (bl || pSSysAIChatAgentBase.getAIChatAgentType() != null)) {
            iDataObject.set(FIELD_AICHATAGENTTYPE, (Object)pSSysAIChatAgentBase.getAIChatAgentType());
        }
        if (pSSysAIChatAgentBase.isAIPlatformTypeDirty() && (bl || pSSysAIChatAgentBase.getAIPlatformType() != null)) {
            iDataObject.set(FIELD_AIPLATFORMTYPE, (Object)pSSysAIChatAgentBase.getAIPlatformType());
        }
        if (pSSysAIChatAgentBase.isCodeNameDirty() && (bl || pSSysAIChatAgentBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysAIChatAgentBase.getCodeName());
        }
        if (pSSysAIChatAgentBase.isCreateDateDirty() && (bl || pSSysAIChatAgentBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysAIChatAgentBase.getCreateDate());
        }
        if (pSSysAIChatAgentBase.isCreateManDirty() && (bl || pSSysAIChatAgentBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysAIChatAgentBase.getCreateMan());
        }
        if (pSSysAIChatAgentBase.isCustomCodeDirty() && (bl || pSSysAIChatAgentBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysAIChatAgentBase.getCustomCode());
        }
        if (pSSysAIChatAgentBase.isCustomModeDirty() && (bl || pSSysAIChatAgentBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysAIChatAgentBase.getCustomMode());
        }
        if (pSSysAIChatAgentBase.isMemoDirty() && (bl || pSSysAIChatAgentBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysAIChatAgentBase.getMemo());
        }
        if (pSSysAIChatAgentBase.isPromptSourceDirty() && (bl || pSSysAIChatAgentBase.getPromptSource() != null)) {
            iDataObject.set(FIELD_PROMPTSOURCE, (Object)pSSysAIChatAgentBase.getPromptSource());
        }
        if (pSSysAIChatAgentBase.isPSDEIdDirty() && (bl || pSSysAIChatAgentBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysAIChatAgentBase.getPSDEId());
        }
        if (pSSysAIChatAgentBase.isPSDENameDirty() && (bl || pSSysAIChatAgentBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysAIChatAgentBase.getPSDEName());
        }
        if (pSSysAIChatAgentBase.isPSSysAIChatAgentIdDirty() && (bl || pSSysAIChatAgentBase.getPSSysAIChatAgentId() != null)) {
            iDataObject.set(FIELD_PSSYSAICHATAGENTID, (Object)pSSysAIChatAgentBase.getPSSysAIChatAgentId());
        }
        if (pSSysAIChatAgentBase.isPSSysAIChatAgentNameDirty() && (bl || pSSysAIChatAgentBase.getPSSysAIChatAgentName() != null)) {
            iDataObject.set(FIELD_PSSYSAICHATAGENTNAME, (Object)pSSysAIChatAgentBase.getPSSysAIChatAgentName());
        }
        if (pSSysAIChatAgentBase.isPSSysAIFactoryIdDirty() && (bl || pSSysAIChatAgentBase.getPSSysAIFactoryId() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYID, (Object)pSSysAIChatAgentBase.getPSSysAIFactoryId());
        }
        if (pSSysAIChatAgentBase.isPSSysAIFactoryNameDirty() && (bl || pSSysAIChatAgentBase.getPSSysAIFactoryName() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYNAME, (Object)pSSysAIChatAgentBase.getPSSysAIFactoryName());
        }
        if (pSSysAIChatAgentBase.isPSSysSFPluginIdDirty() && (bl || pSSysAIChatAgentBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysAIChatAgentBase.getPSSysSFPluginId());
        }
        if (pSSysAIChatAgentBase.isPSSysSFPluginNameDirty() && (bl || pSSysAIChatAgentBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysAIChatAgentBase.getPSSysSFPluginName());
        }
        if (pSSysAIChatAgentBase.isUpdateDateDirty() && (bl || pSSysAIChatAgentBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysAIChatAgentBase.getUpdateDate());
        }
        if (pSSysAIChatAgentBase.isUpdateManDirty() && (bl || pSSysAIChatAgentBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysAIChatAgentBase.getUpdateMan());
        }
        if (pSSysAIChatAgentBase.isUserCatDirty() && (bl || pSSysAIChatAgentBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysAIChatAgentBase.getUserCat());
        }
        if (pSSysAIChatAgentBase.isUserTagDirty() && (bl || pSSysAIChatAgentBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysAIChatAgentBase.getUserTag());
        }
        if (pSSysAIChatAgentBase.isUserTag2Dirty() && (bl || pSSysAIChatAgentBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysAIChatAgentBase.getUserTag2());
        }
        if (pSSysAIChatAgentBase.isUserTag3Dirty() && (bl || pSSysAIChatAgentBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysAIChatAgentBase.getUserTag3());
        }
        if (pSSysAIChatAgentBase.isUserTag4Dirty() && (bl || pSSysAIChatAgentBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysAIChatAgentBase.getUserTag4());
        }
        if (pSSysAIChatAgentBase.isValidFlagDirty() && (bl || pSSysAIChatAgentBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysAIChatAgentBase.getValidFlag());
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
        return PSSysAIChatAgentBase.remove(this, n);
    }

    private static boolean remove(PSSysAIChatAgentBase pSSysAIChatAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysAIChatAgentBase.resetAgentInfo();
                return true;
            }
            case 1: {
                pSSysAIChatAgentBase.resetAIChatAgentParams();
                return true;
            }
            case 2: {
                pSSysAIChatAgentBase.resetAIChatAgentTag();
                return true;
            }
            case 3: {
                pSSysAIChatAgentBase.resetAIChatAgentTag2();
                return true;
            }
            case 4: {
                pSSysAIChatAgentBase.resetAIChatAgentType();
                return true;
            }
            case 5: {
                pSSysAIChatAgentBase.resetAIPlatformType();
                return true;
            }
            case 6: {
                pSSysAIChatAgentBase.resetCodeName();
                return true;
            }
            case 7: {
                pSSysAIChatAgentBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSSysAIChatAgentBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSSysAIChatAgentBase.resetCustomCode();
                return true;
            }
            case 10: {
                pSSysAIChatAgentBase.resetCustomMode();
                return true;
            }
            case 11: {
                pSSysAIChatAgentBase.resetMemo();
                return true;
            }
            case 12: {
                pSSysAIChatAgentBase.resetPromptSource();
                return true;
            }
            case 13: {
                pSSysAIChatAgentBase.resetPSDEId();
                return true;
            }
            case 14: {
                pSSysAIChatAgentBase.resetPSDEName();
                return true;
            }
            case 15: {
                pSSysAIChatAgentBase.resetPSSysAIChatAgentId();
                return true;
            }
            case 16: {
                pSSysAIChatAgentBase.resetPSSysAIChatAgentName();
                return true;
            }
            case 17: {
                pSSysAIChatAgentBase.resetPSSysAIFactoryId();
                return true;
            }
            case 18: {
                pSSysAIChatAgentBase.resetPSSysAIFactoryName();
                return true;
            }
            case 19: {
                pSSysAIChatAgentBase.resetPSSysSFPluginId();
                return true;
            }
            case 20: {
                pSSysAIChatAgentBase.resetPSSysSFPluginName();
                return true;
            }
            case 21: {
                pSSysAIChatAgentBase.resetUpdateDate();
                return true;
            }
            case 22: {
                pSSysAIChatAgentBase.resetUpdateMan();
                return true;
            }
            case 23: {
                pSSysAIChatAgentBase.resetUserCat();
                return true;
            }
            case 24: {
                pSSysAIChatAgentBase.resetUserTag();
                return true;
            }
            case 25: {
                pSSysAIChatAgentBase.resetUserTag2();
                return true;
            }
            case 26: {
                pSSysAIChatAgentBase.resetUserTag3();
                return true;
            }
            case 27: {
                pSSysAIChatAgentBase.resetUserTag4();
                return true;
            }
            case 28: {
                pSSysAIChatAgentBase.resetValidFlag();
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

    private PSSysAIChatAgentBase getProxyEntity() {
        return this.proxyPSSysAIChatAgentBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysAIChatAgentBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysAIChatAgentBase) {
            this.proxyPSSysAIChatAgentBase = (PSSysAIChatAgentBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIChatAgentService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AGENTINFO, 0);
        fieldIndexMap.put(FIELD_AICHATAGENTPARAMS, 1);
        fieldIndexMap.put(FIELD_AICHATAGENTTAG, 2);
        fieldIndexMap.put(FIELD_AICHATAGENTTAG2, 3);
        fieldIndexMap.put(FIELD_AICHATAGENTTYPE, 4);
        fieldIndexMap.put(FIELD_AIPLATFORMTYPE, 5);
        fieldIndexMap.put(FIELD_CODENAME, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 9);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_PROMPTSOURCE, 12);
        fieldIndexMap.put(FIELD_PSDEID, 13);
        fieldIndexMap.put(FIELD_PSDENAME, 14);
        fieldIndexMap.put(FIELD_PSSYSAICHATAGENTID, 15);
        fieldIndexMap.put(FIELD_PSSYSAICHATAGENTNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSAIFACTORYID, 17);
        fieldIndexMap.put(FIELD_PSSYSAIFACTORYNAME, 18);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 19);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 20);
        fieldIndexMap.put(FIELD_UPDATEDATE, 21);
        fieldIndexMap.put(FIELD_UPDATEMAN, 22);
        fieldIndexMap.put(FIELD_USERCAT, 23);
        fieldIndexMap.put(FIELD_USERTAG, 24);
        fieldIndexMap.put(FIELD_USERTAG2, 25);
        fieldIndexMap.put(FIELD_USERTAG3, 26);
        fieldIndexMap.put(FIELD_USERTAG4, 27);
        fieldIndexMap.put(FIELD_VALIDFLAG, 28);
    }
}

