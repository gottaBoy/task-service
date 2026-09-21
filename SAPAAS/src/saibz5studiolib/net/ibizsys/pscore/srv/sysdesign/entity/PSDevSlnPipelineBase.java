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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStep;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnPipelineBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnPipelineBase.class);
    public static final String FIELD_AGENTTAGS = "AGENTTAGS";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_MAJORFLAG = "MAJORFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODEL = "MODEL";
    public static final String FIELD_PIPELINEMODEL = "PIPELINEMODEL";
    public static final String FIELD_PIPELINEPARAMS = "PIPELINEPARAMS";
    public static final String FIELD_PIPELINETAG = "PIPELINETAG";
    public static final String FIELD_PIPELINETAG2 = "PIPELINETAG2";
    public static final String FIELD_PIPELINETAG3 = "PIPELINETAG3";
    public static final String FIELD_PIPELINETAG4 = "PIPELINETAG4";
    public static final String FIELD_PIPELINETYPE = "PIPELINETYPE";
    public static final String FIELD_PSDCCODESNIPPETID = "PSDCCODESNIPPETID";
    public static final String FIELD_PSDCCODESNIPPETNAME = "PSDCCODESNIPPETNAME";
    public static final String FIELD_PSDCDEPLOYCENTERID = "PSDCDEPLOYCENTERID";
    public static final String FIELD_PSDCDEPLOYCENTERNAME = "PSDCDEPLOYCENTERNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String FIELD_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNPIPELINEID = "PSDEVSLNPIPELINEID";
    public static final String FIELD_PSDEVSLNPIPELINENAME = "PSDEVSLNPIPELINENAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String FIELD_TRIGGERPARAMS = "TRIGGERPARAMS";
    public static final String FIELD_TRIGGERTYPE = "TRIGGERTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_AGENTTAGS = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_CUSTOMCODE = 4;
    private static final int INDEX_MAJORFLAG = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_MODEL = 7;
    private static final int INDEX_PIPELINEMODEL = 8;
    private static final int INDEX_PIPELINEPARAMS = 9;
    private static final int INDEX_PIPELINETAG = 10;
    private static final int INDEX_PIPELINETAG2 = 11;
    private static final int INDEX_PIPELINETAG3 = 12;
    private static final int INDEX_PIPELINETAG4 = 13;
    private static final int INDEX_PIPELINETYPE = 14;
    private static final int INDEX_PSDCCODESNIPPETID = 15;
    private static final int INDEX_PSDCCODESNIPPETNAME = 16;
    private static final int INDEX_PSDCDEPLOYCENTERID = 17;
    private static final int INDEX_PSDCDEPLOYCENTERNAME = 18;
    private static final int INDEX_PSDEVCENTERID = 19;
    private static final int INDEX_PSDEVCENTERSVNID = 20;
    private static final int INDEX_PSDEVCENTERSVNNAME = 21;
    private static final int INDEX_PSDEVSLNID = 22;
    private static final int INDEX_PSDEVSLNNAME = 23;
    private static final int INDEX_PSDEVSLNPIPELINEID = 24;
    private static final int INDEX_PSDEVSLNPIPELINENAME = 25;
    private static final int INDEX_PSDEVSLNSYSID = 26;
    private static final int INDEX_PSDEVSLNSYSNAME = 27;
    private static final int INDEX_TEMPLATEMODE = 28;
    private static final int INDEX_TRIGGERPARAMS = 29;
    private static final int INDEX_TRIGGERTYPE = 30;
    private static final int INDEX_UPDATEDATE = 31;
    private static final int INDEX_UPDATEMAN = 32;
    private static final int INDEX_USERCAT = 33;
    private static final int INDEX_USERTAG = 34;
    private static final int INDEX_USERTAG2 = 35;
    private static final int INDEX_USERTAG3 = 36;
    private static final int INDEX_USERTAG4 = 37;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnPipelineBase proxyPSDevSlnPipelineBase = null;
    private boolean agenttagsDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean majorflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelDirtyFlag = false;
    private boolean pipelinemodelDirtyFlag = false;
    private boolean pipelineparamsDirtyFlag = false;
    private boolean pipelinetagDirtyFlag = false;
    private boolean pipelinetag2DirtyFlag = false;
    private boolean pipelinetag3DirtyFlag = false;
    private boolean pipelinetag4DirtyFlag = false;
    private boolean pipelinetypeDirtyFlag = false;
    private boolean psdccodesnippetidDirtyFlag = false;
    private boolean psdccodesnippetnameDirtyFlag = false;
    private boolean psdcdeploycenteridDirtyFlag = false;
    private boolean psdcdeploycenternameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcentersvnidDirtyFlag = false;
    private boolean psdevcentersvnnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnpipelineidDirtyFlag = false;
    private boolean psdevslnpipelinenameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean templatemodeDirtyFlag = false;
    private boolean triggerparamsDirtyFlag = false;
    private boolean triggertypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="agenttags")
    private String agenttags;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="majorflag")
    private Integer majorflag;
    @Column(name="memo")
    private String memo;
    @Column(name="model")
    private String model;
    @Column(name="pipelinemodel")
    private String pipelinemodel;
    @Column(name="pipelineparams")
    private String pipelineparams;
    @Column(name="pipelinetag")
    private String pipelinetag;
    @Column(name="pipelinetag2")
    private String pipelinetag2;
    @Column(name="pipelinetag3")
    private String pipelinetag3;
    @Column(name="pipelinetag4")
    private String pipelinetag4;
    @Column(name="pipelinetype")
    private String pipelinetype;
    @Column(name="psdccodesnippetid")
    private String psdccodesnippetid;
    @Column(name="psdccodesnippetname")
    private String psdccodesnippetname;
    @Column(name="psdcdeploycenterid")
    private String psdcdeploycenterid;
    @Column(name="psdcdeploycentername")
    private String psdcdeploycentername;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentersvnid")
    private String psdevcentersvnid;
    @Column(name="psdevcentersvnname")
    private String psdevcentersvnname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnpipelineid")
    private String psdevslnpipelineid;
    @Column(name="psdevslnpipelinename")
    private String psdevslnpipelinename;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="templatemode")
    private Integer templatemode;
    @Column(name="triggerparams")
    private String triggerparams;
    @Column(name="triggertype")
    private String triggertype;
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
    private Integer objPSDCCodeSnippetLock = new Integer(1);
    private PSDCCodeSnippet psdccodesnippet = null;
    private Integer objPSDCDeployCenterLock = new Integer(1);
    private PSDCDeployCenter psdcdeploycenter = null;
    private Integer objPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN psdevcentersvn = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSDevSlnPipelineStepsLock = new Integer(1);
    private ArrayList<PSDevSlnPipelineStep> psdevslnpipelinesteps = null;

    public void setAgentTags(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentTags(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.agenttags = string;
        this.agenttagsDirtyFlag = true;
    }

    public String getAgentTags() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentTags();
        }
        return this.agenttags;
    }

    public boolean isAgentTagsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentTagsDirty();
        }
        return this.agenttagsDirtyFlag;
    }

    public void resetAgentTags() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentTags();
            return;
        }
        this.agenttagsDirtyFlag = false;
        this.agenttags = null;
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

    public void setMajorFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorFlag(n);
            return;
        }
        this.majorflag = n;
        this.majorflagDirtyFlag = true;
    }

    public Integer getMajorFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorFlag();
        }
        return this.majorflag;
    }

    public boolean isMajorFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorFlagDirty();
        }
        return this.majorflagDirtyFlag;
    }

    public void resetMajorFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorFlag();
            return;
        }
        this.majorflagDirtyFlag = false;
        this.majorflag = null;
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

    public void setModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.model = string;
        this.modelDirtyFlag = true;
    }

    public String getModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModel();
        }
        return this.model;
    }

    public boolean isModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelDirty();
        }
        return this.modelDirtyFlag;
    }

    public void resetModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModel();
            return;
        }
        this.modelDirtyFlag = false;
        this.model = null;
    }

    public void setPipelineModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPipelineModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pipelinemodel = string;
        this.pipelinemodelDirtyFlag = true;
    }

    public String getPipelineModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPipelineModel();
        }
        return this.pipelinemodel;
    }

    public boolean isPipelineModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPipelineModelDirty();
        }
        return this.pipelinemodelDirtyFlag;
    }

    public void resetPipelineModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPipelineModel();
            return;
        }
        this.pipelinemodelDirtyFlag = false;
        this.pipelinemodel = null;
    }

    public void setPipelineParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPipelineParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pipelineparams = string;
        this.pipelineparamsDirtyFlag = true;
    }

    public String getPipelineParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPipelineParams();
        }
        return this.pipelineparams;
    }

    public boolean isPipelineParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPipelineParamsDirty();
        }
        return this.pipelineparamsDirtyFlag;
    }

    public void resetPipelineParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPipelineParams();
            return;
        }
        this.pipelineparamsDirtyFlag = false;
        this.pipelineparams = null;
    }

    public void setPipelineTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPipelineTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pipelinetag = string;
        this.pipelinetagDirtyFlag = true;
    }

    public String getPipelineTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPipelineTag();
        }
        return this.pipelinetag;
    }

    public boolean isPipelineTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPipelineTagDirty();
        }
        return this.pipelinetagDirtyFlag;
    }

    public void resetPipelineTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPipelineTag();
            return;
        }
        this.pipelinetagDirtyFlag = false;
        this.pipelinetag = null;
    }

    public void setPipelineTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPipelineTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pipelinetag2 = string;
        this.pipelinetag2DirtyFlag = true;
    }

    public String getPipelineTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPipelineTag2();
        }
        return this.pipelinetag2;
    }

    public boolean isPipelineTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPipelineTag2Dirty();
        }
        return this.pipelinetag2DirtyFlag;
    }

    public void resetPipelineTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPipelineTag2();
            return;
        }
        this.pipelinetag2DirtyFlag = false;
        this.pipelinetag2 = null;
    }

    public void setPipelineTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPipelineTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pipelinetag3 = string;
        this.pipelinetag3DirtyFlag = true;
    }

    public String getPipelineTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPipelineTag3();
        }
        return this.pipelinetag3;
    }

    public boolean isPipelineTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPipelineTag3Dirty();
        }
        return this.pipelinetag3DirtyFlag;
    }

    public void resetPipelineTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPipelineTag3();
            return;
        }
        this.pipelinetag3DirtyFlag = false;
        this.pipelinetag3 = null;
    }

    public void setPipelineTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPipelineTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pipelinetag4 = string;
        this.pipelinetag4DirtyFlag = true;
    }

    public String getPipelineTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPipelineTag4();
        }
        return this.pipelinetag4;
    }

    public boolean isPipelineTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPipelineTag4Dirty();
        }
        return this.pipelinetag4DirtyFlag;
    }

    public void resetPipelineTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPipelineTag4();
            return;
        }
        this.pipelinetag4DirtyFlag = false;
        this.pipelinetag4 = null;
    }

    public void setPipelineType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPipelineType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pipelinetype = string;
        this.pipelinetypeDirtyFlag = true;
    }

    public String getPipelineType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPipelineType();
        }
        return this.pipelinetype;
    }

    public boolean isPipelineTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPipelineTypeDirty();
        }
        return this.pipelinetypeDirtyFlag;
    }

    public void resetPipelineType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPipelineType();
            return;
        }
        this.pipelinetypeDirtyFlag = false;
        this.pipelinetype = null;
    }

    public void setPSDCCodeSnippetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCCodeSnippetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccodesnippetid = string;
        this.psdccodesnippetidDirtyFlag = true;
    }

    public String getPSDCCodeSnippetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippetId();
        }
        return this.psdccodesnippetid;
    }

    public boolean isPSDCCodeSnippetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCCodeSnippetIdDirty();
        }
        return this.psdccodesnippetidDirtyFlag;
    }

    public void resetPSDCCodeSnippetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCCodeSnippetId();
            return;
        }
        this.psdccodesnippetidDirtyFlag = false;
        this.psdccodesnippetid = null;
    }

    public void setPSDCCodeSnippetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCCodeSnippetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccodesnippetname = string;
        this.psdccodesnippetnameDirtyFlag = true;
    }

    public String getPSDCCodeSnippetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippetName();
        }
        return this.psdccodesnippetname;
    }

    public boolean isPSDCCodeSnippetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCCodeSnippetNameDirty();
        }
        return this.psdccodesnippetnameDirtyFlag;
    }

    public void resetPSDCCodeSnippetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCCodeSnippetName();
            return;
        }
        this.psdccodesnippetnameDirtyFlag = false;
        this.psdccodesnippetname = null;
    }

    public void setPSDCDeployCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDeployCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdeploycenterid = string;
        this.psdcdeploycenteridDirtyFlag = true;
    }

    public String getPSDCDeployCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployCenterId();
        }
        return this.psdcdeploycenterid;
    }

    public boolean isPSDCDeployCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDeployCenterIdDirty();
        }
        return this.psdcdeploycenteridDirtyFlag;
    }

    public void resetPSDCDeployCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDeployCenterId();
            return;
        }
        this.psdcdeploycenteridDirtyFlag = false;
        this.psdcdeploycenterid = null;
    }

    public void setPSDCDeployCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDeployCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdeploycentername = string;
        this.psdcdeploycenternameDirtyFlag = true;
    }

    public String getPSDCDeployCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployCenterName();
        }
        return this.psdcdeploycentername;
    }

    public boolean isPSDCDeployCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDeployCenterNameDirty();
        }
        return this.psdcdeploycenternameDirtyFlag;
    }

    public void resetPSDCDeployCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDeployCenterName();
            return;
        }
        this.psdcdeploycenternameDirtyFlag = false;
        this.psdcdeploycentername = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnid = string;
        this.psdevcentersvnidDirtyFlag = true;
    }

    public String getPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNId();
        }
        return this.psdevcentersvnid;
    }

    public boolean isPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNIdDirty();
        }
        return this.psdevcentersvnidDirtyFlag;
    }

    public void resetPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNId();
            return;
        }
        this.psdevcentersvnidDirtyFlag = false;
        this.psdevcentersvnid = null;
    }

    public void setPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersvnname = string;
        this.psdevcentersvnnameDirtyFlag = true;
    }

    public String getPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVNName();
        }
        return this.psdevcentersvnname;
    }

    public boolean isPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSVNNameDirty();
        }
        return this.psdevcentersvnnameDirtyFlag;
    }

    public void resetPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSVNName();
            return;
        }
        this.psdevcentersvnnameDirtyFlag = false;
        this.psdevcentersvnname = null;
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

    public void setTemplateMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplateMode(n);
            return;
        }
        this.templatemode = n;
        this.templatemodeDirtyFlag = true;
    }

    public Integer getTemplateMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplateMode();
        }
        return this.templatemode;
    }

    public boolean isTemplateModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplateModeDirty();
        }
        return this.templatemodeDirtyFlag;
    }

    public void resetTemplateMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplateMode();
            return;
        }
        this.templatemodeDirtyFlag = false;
        this.templatemode = null;
    }

    public void setTriggerParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTriggerParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.triggerparams = string;
        this.triggerparamsDirtyFlag = true;
    }

    public String getTriggerParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTriggerParams();
        }
        return this.triggerparams;
    }

    public boolean isTriggerParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTriggerParamsDirty();
        }
        return this.triggerparamsDirtyFlag;
    }

    public void resetTriggerParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTriggerParams();
            return;
        }
        this.triggerparamsDirtyFlag = false;
        this.triggerparams = null;
    }

    public void setTriggerType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTriggerType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.triggertype = string;
        this.triggertypeDirtyFlag = true;
    }

    public String getTriggerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTriggerType();
        }
        return this.triggertype;
    }

    public boolean isTriggerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTriggerTypeDirty();
        }
        return this.triggertypeDirtyFlag;
    }

    public void resetTriggerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTriggerType();
            return;
        }
        this.triggertypeDirtyFlag = false;
        this.triggertype = null;
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
        PSDevSlnPipelineBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnPipelineBase pSDevSlnPipelineBase) {
        pSDevSlnPipelineBase.resetAgentTags();
        pSDevSlnPipelineBase.resetCodeName();
        pSDevSlnPipelineBase.resetCreateDate();
        pSDevSlnPipelineBase.resetCreateMan();
        pSDevSlnPipelineBase.resetCustomCode();
        pSDevSlnPipelineBase.resetMajorFlag();
        pSDevSlnPipelineBase.resetMemo();
        pSDevSlnPipelineBase.resetModel();
        pSDevSlnPipelineBase.resetPipelineModel();
        pSDevSlnPipelineBase.resetPipelineParams();
        pSDevSlnPipelineBase.resetPipelineTag();
        pSDevSlnPipelineBase.resetPipelineTag2();
        pSDevSlnPipelineBase.resetPipelineTag3();
        pSDevSlnPipelineBase.resetPipelineTag4();
        pSDevSlnPipelineBase.resetPipelineType();
        pSDevSlnPipelineBase.resetPSDCCodeSnippetId();
        pSDevSlnPipelineBase.resetPSDCCodeSnippetName();
        pSDevSlnPipelineBase.resetPSDCDeployCenterId();
        pSDevSlnPipelineBase.resetPSDCDeployCenterName();
        pSDevSlnPipelineBase.resetPSDevCenterId();
        pSDevSlnPipelineBase.resetPSDevCenterSVNId();
        pSDevSlnPipelineBase.resetPSDevCenterSVNName();
        pSDevSlnPipelineBase.resetPSDevSlnId();
        pSDevSlnPipelineBase.resetPSDevSlnName();
        pSDevSlnPipelineBase.resetPSDevSlnPipelineId();
        pSDevSlnPipelineBase.resetPSDevSlnPipelineName();
        pSDevSlnPipelineBase.resetPSDevSlnSysId();
        pSDevSlnPipelineBase.resetPSDevSlnSysName();
        pSDevSlnPipelineBase.resetTemplateMode();
        pSDevSlnPipelineBase.resetTriggerParams();
        pSDevSlnPipelineBase.resetTriggerType();
        pSDevSlnPipelineBase.resetUpdateDate();
        pSDevSlnPipelineBase.resetUpdateMan();
        pSDevSlnPipelineBase.resetUserCat();
        pSDevSlnPipelineBase.resetUserTag();
        pSDevSlnPipelineBase.resetUserTag2();
        pSDevSlnPipelineBase.resetUserTag3();
        pSDevSlnPipelineBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAgentTagsDirty()) {
            hashMap.put(FIELD_AGENTTAGS, this.getAgentTags());
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
        if (!bl || this.isMajorFlagDirty()) {
            hashMap.put(FIELD_MAJORFLAG, this.getMajorFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelDirty()) {
            hashMap.put(FIELD_MODEL, this.getModel());
        }
        if (!bl || this.isPipelineModelDirty()) {
            hashMap.put(FIELD_PIPELINEMODEL, this.getPipelineModel());
        }
        if (!bl || this.isPipelineParamsDirty()) {
            hashMap.put(FIELD_PIPELINEPARAMS, this.getPipelineParams());
        }
        if (!bl || this.isPipelineTagDirty()) {
            hashMap.put(FIELD_PIPELINETAG, this.getPipelineTag());
        }
        if (!bl || this.isPipelineTag2Dirty()) {
            hashMap.put(FIELD_PIPELINETAG2, this.getPipelineTag2());
        }
        if (!bl || this.isPipelineTag3Dirty()) {
            hashMap.put(FIELD_PIPELINETAG3, this.getPipelineTag3());
        }
        if (!bl || this.isPipelineTag4Dirty()) {
            hashMap.put(FIELD_PIPELINETAG4, this.getPipelineTag4());
        }
        if (!bl || this.isPipelineTypeDirty()) {
            hashMap.put(FIELD_PIPELINETYPE, this.getPipelineType());
        }
        if (!bl || this.isPSDCCodeSnippetIdDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETID, this.getPSDCCodeSnippetId());
        }
        if (!bl || this.isPSDCCodeSnippetNameDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETNAME, this.getPSDCCodeSnippetName());
        }
        if (!bl || this.isPSDCDeployCenterIdDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYCENTERID, this.getPSDCDeployCenterId());
        }
        if (!bl || this.isPSDCDeployCenterNameDirty()) {
            hashMap.put(FIELD_PSDCDEPLOYCENTERNAME, this.getPSDCDeployCenterName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNID, this.getPSDevCenterSVNId());
        }
        if (!bl || this.isPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSVNNAME, this.getPSDevCenterSVNName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
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
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isTemplateModeDirty()) {
            hashMap.put(FIELD_TEMPLATEMODE, this.getTemplateMode());
        }
        if (!bl || this.isTriggerParamsDirty()) {
            hashMap.put(FIELD_TRIGGERPARAMS, this.getTriggerParams());
        }
        if (!bl || this.isTriggerTypeDirty()) {
            hashMap.put(FIELD_TRIGGERTYPE, this.getTriggerType());
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
        return PSDevSlnPipelineBase.get(this, n);
    }

    private static Object get(PSDevSlnPipelineBase pSDevSlnPipelineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnPipelineBase.getAgentTags();
            }
            case 1: {
                return pSDevSlnPipelineBase.getCodeName();
            }
            case 2: {
                return pSDevSlnPipelineBase.getCreateDate();
            }
            case 3: {
                return pSDevSlnPipelineBase.getCreateMan();
            }
            case 4: {
                return pSDevSlnPipelineBase.getCustomCode();
            }
            case 5: {
                return pSDevSlnPipelineBase.getMajorFlag();
            }
            case 6: {
                return pSDevSlnPipelineBase.getMemo();
            }
            case 7: {
                return pSDevSlnPipelineBase.getModel();
            }
            case 8: {
                return pSDevSlnPipelineBase.getPipelineModel();
            }
            case 9: {
                return pSDevSlnPipelineBase.getPipelineParams();
            }
            case 10: {
                return pSDevSlnPipelineBase.getPipelineTag();
            }
            case 11: {
                return pSDevSlnPipelineBase.getPipelineTag2();
            }
            case 12: {
                return pSDevSlnPipelineBase.getPipelineTag3();
            }
            case 13: {
                return pSDevSlnPipelineBase.getPipelineTag4();
            }
            case 14: {
                return pSDevSlnPipelineBase.getPipelineType();
            }
            case 15: {
                return pSDevSlnPipelineBase.getPSDCCodeSnippetId();
            }
            case 16: {
                return pSDevSlnPipelineBase.getPSDCCodeSnippetName();
            }
            case 17: {
                return pSDevSlnPipelineBase.getPSDCDeployCenterId();
            }
            case 18: {
                return pSDevSlnPipelineBase.getPSDCDeployCenterName();
            }
            case 19: {
                return pSDevSlnPipelineBase.getPSDevCenterId();
            }
            case 20: {
                return pSDevSlnPipelineBase.getPSDevCenterSVNId();
            }
            case 21: {
                return pSDevSlnPipelineBase.getPSDevCenterSVNName();
            }
            case 22: {
                return pSDevSlnPipelineBase.getPSDevSlnId();
            }
            case 23: {
                return pSDevSlnPipelineBase.getPSDevSlnName();
            }
            case 24: {
                return pSDevSlnPipelineBase.getPSDevSlnPipelineId();
            }
            case 25: {
                return pSDevSlnPipelineBase.getPSDevSlnPipelineName();
            }
            case 26: {
                return pSDevSlnPipelineBase.getPSDevSlnSysId();
            }
            case 27: {
                return pSDevSlnPipelineBase.getPSDevSlnSysName();
            }
            case 28: {
                return pSDevSlnPipelineBase.getTemplateMode();
            }
            case 29: {
                return pSDevSlnPipelineBase.getTriggerParams();
            }
            case 30: {
                return pSDevSlnPipelineBase.getTriggerType();
            }
            case 31: {
                return pSDevSlnPipelineBase.getUpdateDate();
            }
            case 32: {
                return pSDevSlnPipelineBase.getUpdateMan();
            }
            case 33: {
                return pSDevSlnPipelineBase.getUserCat();
            }
            case 34: {
                return pSDevSlnPipelineBase.getUserTag();
            }
            case 35: {
                return pSDevSlnPipelineBase.getUserTag2();
            }
            case 36: {
                return pSDevSlnPipelineBase.getUserTag3();
            }
            case 37: {
                return pSDevSlnPipelineBase.getUserTag4();
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
        PSDevSlnPipelineBase.set(this, n, object);
    }

    private static void set(PSDevSlnPipelineBase pSDevSlnPipelineBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnPipelineBase.setAgentTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnPipelineBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnPipelineBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnPipelineBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnPipelineBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnPipelineBase.setMajorFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnPipelineBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnPipelineBase.setModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnPipelineBase.setPipelineModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnPipelineBase.setPipelineParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnPipelineBase.setPipelineTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnPipelineBase.setPipelineTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnPipelineBase.setPipelineTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnPipelineBase.setPipelineTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnPipelineBase.setPipelineType(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnPipelineBase.setPSDCCodeSnippetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnPipelineBase.setPSDCCodeSnippetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnPipelineBase.setPSDCDeployCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnPipelineBase.setPSDCDeployCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnPipelineBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnPipelineBase.setPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnPipelineBase.setPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnPipelineBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnPipelineBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnPipelineBase.setPSDevSlnPipelineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnPipelineBase.setPSDevSlnPipelineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnPipelineBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnPipelineBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnPipelineBase.setTemplateMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnPipelineBase.setTriggerParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevSlnPipelineBase.setTriggerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevSlnPipelineBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 32: {
                pSDevSlnPipelineBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevSlnPipelineBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevSlnPipelineBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDevSlnPipelineBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDevSlnPipelineBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDevSlnPipelineBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDevSlnPipelineBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnPipelineBase pSDevSlnPipelineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnPipelineBase.getAgentTags() == null;
            }
            case 1: {
                return pSDevSlnPipelineBase.getCodeName() == null;
            }
            case 2: {
                return pSDevSlnPipelineBase.getCreateDate() == null;
            }
            case 3: {
                return pSDevSlnPipelineBase.getCreateMan() == null;
            }
            case 4: {
                return pSDevSlnPipelineBase.getCustomCode() == null;
            }
            case 5: {
                return pSDevSlnPipelineBase.getMajorFlag() == null;
            }
            case 6: {
                return pSDevSlnPipelineBase.getMemo() == null;
            }
            case 7: {
                return pSDevSlnPipelineBase.getModel() == null;
            }
            case 8: {
                return pSDevSlnPipelineBase.getPipelineModel() == null;
            }
            case 9: {
                return pSDevSlnPipelineBase.getPipelineParams() == null;
            }
            case 10: {
                return pSDevSlnPipelineBase.getPipelineTag() == null;
            }
            case 11: {
                return pSDevSlnPipelineBase.getPipelineTag2() == null;
            }
            case 12: {
                return pSDevSlnPipelineBase.getPipelineTag3() == null;
            }
            case 13: {
                return pSDevSlnPipelineBase.getPipelineTag4() == null;
            }
            case 14: {
                return pSDevSlnPipelineBase.getPipelineType() == null;
            }
            case 15: {
                return pSDevSlnPipelineBase.getPSDCCodeSnippetId() == null;
            }
            case 16: {
                return pSDevSlnPipelineBase.getPSDCCodeSnippetName() == null;
            }
            case 17: {
                return pSDevSlnPipelineBase.getPSDCDeployCenterId() == null;
            }
            case 18: {
                return pSDevSlnPipelineBase.getPSDCDeployCenterName() == null;
            }
            case 19: {
                return pSDevSlnPipelineBase.getPSDevCenterId() == null;
            }
            case 20: {
                return pSDevSlnPipelineBase.getPSDevCenterSVNId() == null;
            }
            case 21: {
                return pSDevSlnPipelineBase.getPSDevCenterSVNName() == null;
            }
            case 22: {
                return pSDevSlnPipelineBase.getPSDevSlnId() == null;
            }
            case 23: {
                return pSDevSlnPipelineBase.getPSDevSlnName() == null;
            }
            case 24: {
                return pSDevSlnPipelineBase.getPSDevSlnPipelineId() == null;
            }
            case 25: {
                return pSDevSlnPipelineBase.getPSDevSlnPipelineName() == null;
            }
            case 26: {
                return pSDevSlnPipelineBase.getPSDevSlnSysId() == null;
            }
            case 27: {
                return pSDevSlnPipelineBase.getPSDevSlnSysName() == null;
            }
            case 28: {
                return pSDevSlnPipelineBase.getTemplateMode() == null;
            }
            case 29: {
                return pSDevSlnPipelineBase.getTriggerParams() == null;
            }
            case 30: {
                return pSDevSlnPipelineBase.getTriggerType() == null;
            }
            case 31: {
                return pSDevSlnPipelineBase.getUpdateDate() == null;
            }
            case 32: {
                return pSDevSlnPipelineBase.getUpdateMan() == null;
            }
            case 33: {
                return pSDevSlnPipelineBase.getUserCat() == null;
            }
            case 34: {
                return pSDevSlnPipelineBase.getUserTag() == null;
            }
            case 35: {
                return pSDevSlnPipelineBase.getUserTag2() == null;
            }
            case 36: {
                return pSDevSlnPipelineBase.getUserTag3() == null;
            }
            case 37: {
                return pSDevSlnPipelineBase.getUserTag4() == null;
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
        return PSDevSlnPipelineBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnPipelineBase pSDevSlnPipelineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnPipelineBase.isAgentTagsDirty();
            }
            case 1: {
                return pSDevSlnPipelineBase.isCodeNameDirty();
            }
            case 2: {
                return pSDevSlnPipelineBase.isCreateDateDirty();
            }
            case 3: {
                return pSDevSlnPipelineBase.isCreateManDirty();
            }
            case 4: {
                return pSDevSlnPipelineBase.isCustomCodeDirty();
            }
            case 5: {
                return pSDevSlnPipelineBase.isMajorFlagDirty();
            }
            case 6: {
                return pSDevSlnPipelineBase.isMemoDirty();
            }
            case 7: {
                return pSDevSlnPipelineBase.isModelDirty();
            }
            case 8: {
                return pSDevSlnPipelineBase.isPipelineModelDirty();
            }
            case 9: {
                return pSDevSlnPipelineBase.isPipelineParamsDirty();
            }
            case 10: {
                return pSDevSlnPipelineBase.isPipelineTagDirty();
            }
            case 11: {
                return pSDevSlnPipelineBase.isPipelineTag2Dirty();
            }
            case 12: {
                return pSDevSlnPipelineBase.isPipelineTag3Dirty();
            }
            case 13: {
                return pSDevSlnPipelineBase.isPipelineTag4Dirty();
            }
            case 14: {
                return pSDevSlnPipelineBase.isPipelineTypeDirty();
            }
            case 15: {
                return pSDevSlnPipelineBase.isPSDCCodeSnippetIdDirty();
            }
            case 16: {
                return pSDevSlnPipelineBase.isPSDCCodeSnippetNameDirty();
            }
            case 17: {
                return pSDevSlnPipelineBase.isPSDCDeployCenterIdDirty();
            }
            case 18: {
                return pSDevSlnPipelineBase.isPSDCDeployCenterNameDirty();
            }
            case 19: {
                return pSDevSlnPipelineBase.isPSDevCenterIdDirty();
            }
            case 20: {
                return pSDevSlnPipelineBase.isPSDevCenterSVNIdDirty();
            }
            case 21: {
                return pSDevSlnPipelineBase.isPSDevCenterSVNNameDirty();
            }
            case 22: {
                return pSDevSlnPipelineBase.isPSDevSlnIdDirty();
            }
            case 23: {
                return pSDevSlnPipelineBase.isPSDevSlnNameDirty();
            }
            case 24: {
                return pSDevSlnPipelineBase.isPSDevSlnPipelineIdDirty();
            }
            case 25: {
                return pSDevSlnPipelineBase.isPSDevSlnPipelineNameDirty();
            }
            case 26: {
                return pSDevSlnPipelineBase.isPSDevSlnSysIdDirty();
            }
            case 27: {
                return pSDevSlnPipelineBase.isPSDevSlnSysNameDirty();
            }
            case 28: {
                return pSDevSlnPipelineBase.isTemplateModeDirty();
            }
            case 29: {
                return pSDevSlnPipelineBase.isTriggerParamsDirty();
            }
            case 30: {
                return pSDevSlnPipelineBase.isTriggerTypeDirty();
            }
            case 31: {
                return pSDevSlnPipelineBase.isUpdateDateDirty();
            }
            case 32: {
                return pSDevSlnPipelineBase.isUpdateManDirty();
            }
            case 33: {
                return pSDevSlnPipelineBase.isUserCatDirty();
            }
            case 34: {
                return pSDevSlnPipelineBase.isUserTagDirty();
            }
            case 35: {
                return pSDevSlnPipelineBase.isUserTag2Dirty();
            }
            case 36: {
                return pSDevSlnPipelineBase.isUserTag3Dirty();
            }
            case 37: {
                return pSDevSlnPipelineBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnPipelineBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnPipelineBase pSDevSlnPipelineBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnPipelineBase.getAgentTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agenttags", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getAgentTags()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getMajorFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorflag", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getMajorFlag()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"model", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getModel()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPipelineModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pipelinemodel", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPipelineModel()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPipelineParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pipelineparams", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPipelineParams()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPipelineTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pipelinetag", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPipelineTag()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPipelineTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pipelinetag2", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPipelineTag2()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPipelineTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pipelinetag3", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPipelineTag3()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPipelineTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pipelinetag4", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPipelineTag4()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPipelineType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pipelinetype", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPipelineType()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPSDCCodeSnippetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetid", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPSDCCodeSnippetId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPSDCCodeSnippetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetname", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPSDCCodeSnippetName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPSDCDeployCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeploycenterid", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPSDCDeployCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPSDCDeployCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdeploycentername", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPSDCDeployCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnid", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersvnname", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevSlnPipelineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelineid", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPSDevSlnPipelineId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevSlnPipelineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinename", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPSDevSlnPipelineName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getTemplateMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templatemode", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getTemplateMode()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getTriggerParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggerparams", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getTriggerParams()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getTriggerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"triggertype", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getTriggerType()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevSlnPipelineBase.getJSONValue((Object)pSDevSlnPipelineBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnPipelineBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnPipelineBase pSDevSlnPipelineBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnPipelineBase.getAgentTags() != null) {
            object = pSDevSlnPipelineBase.getAgentTags();
            xmlNode.setAttribute(FIELD_AGENTTAGS, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnPipelineBase.getCodeName() != null) {
            object = pSDevSlnPipelineBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getCreateDate() != null) {
            object = pSDevSlnPipelineBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnPipelineBase.getCreateMan() != null) {
            object = pSDevSlnPipelineBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getCustomCode() != null) {
            object = pSDevSlnPipelineBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getMajorFlag() != null) {
            object = pSDevSlnPipelineBase.getMajorFlag();
            xmlNode.setAttribute(FIELD_MAJORFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineBase.getMemo() != null) {
            object = pSDevSlnPipelineBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getModel() != null) {
            object = pSDevSlnPipelineBase.getModel();
            xmlNode.setAttribute(FIELD_MODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPipelineModel() != null) {
            object = pSDevSlnPipelineBase.getPipelineModel();
            xmlNode.setAttribute(FIELD_PIPELINEMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPipelineParams() != null) {
            object = pSDevSlnPipelineBase.getPipelineParams();
            xmlNode.setAttribute(FIELD_PIPELINEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPipelineTag() != null) {
            object = pSDevSlnPipelineBase.getPipelineTag();
            xmlNode.setAttribute(FIELD_PIPELINETAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPipelineTag2() != null) {
            object = pSDevSlnPipelineBase.getPipelineTag2();
            xmlNode.setAttribute(FIELD_PIPELINETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPipelineTag3() != null) {
            object = pSDevSlnPipelineBase.getPipelineTag3();
            xmlNode.setAttribute(FIELD_PIPELINETAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPipelineTag4() != null) {
            object = pSDevSlnPipelineBase.getPipelineTag4();
            xmlNode.setAttribute(FIELD_PIPELINETAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPipelineType() != null) {
            object = pSDevSlnPipelineBase.getPipelineType();
            xmlNode.setAttribute(FIELD_PIPELINETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPSDCCodeSnippetId() != null) {
            object = pSDevSlnPipelineBase.getPSDCCodeSnippetId();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPSDCCodeSnippetName() != null) {
            object = pSDevSlnPipelineBase.getPSDCCodeSnippetName();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPSDCDeployCenterId() != null) {
            object = pSDevSlnPipelineBase.getPSDCDeployCenterId();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPSDCDeployCenterName() != null) {
            object = pSDevSlnPipelineBase.getPSDCDeployCenterName();
            xmlNode.setAttribute(FIELD_PSDCDEPLOYCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevCenterId() != null) {
            object = pSDevSlnPipelineBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevCenterSVNId() != null) {
            object = pSDevSlnPipelineBase.getPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevCenterSVNName() != null) {
            object = pSDevSlnPipelineBase.getPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevSlnId() != null) {
            object = pSDevSlnPipelineBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevSlnName() != null) {
            object = pSDevSlnPipelineBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevSlnPipelineId() != null) {
            object = pSDevSlnPipelineBase.getPSDevSlnPipelineId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevSlnPipelineName() != null) {
            object = pSDevSlnPipelineBase.getPSDevSlnPipelineName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnPipelineBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnPipelineBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getTemplateMode() != null) {
            object = pSDevSlnPipelineBase.getTemplateMode();
            xmlNode.setAttribute(FIELD_TEMPLATEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineBase.getTriggerParams() != null) {
            object = pSDevSlnPipelineBase.getTriggerParams();
            xmlNode.setAttribute(FIELD_TRIGGERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getTriggerType() != null) {
            object = pSDevSlnPipelineBase.getTriggerType();
            xmlNode.setAttribute(FIELD_TRIGGERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getUpdateDate() != null) {
            object = pSDevSlnPipelineBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnPipelineBase.getUpdateMan() != null) {
            object = pSDevSlnPipelineBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getUserCat() != null) {
            object = pSDevSlnPipelineBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getUserTag() != null) {
            object = pSDevSlnPipelineBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getUserTag2() != null) {
            object = pSDevSlnPipelineBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getUserTag3() != null) {
            object = pSDevSlnPipelineBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineBase.getUserTag4() != null) {
            object = pSDevSlnPipelineBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnPipelineBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnPipelineBase pSDevSlnPipelineBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnPipelineBase.isAgentTagsDirty() && (bl || pSDevSlnPipelineBase.getAgentTags() != null)) {
            iDataObject.set(FIELD_AGENTTAGS, (Object)pSDevSlnPipelineBase.getAgentTags());
        }
        if (pSDevSlnPipelineBase.isCodeNameDirty() && (bl || pSDevSlnPipelineBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDevSlnPipelineBase.getCodeName());
        }
        if (pSDevSlnPipelineBase.isCreateDateDirty() && (bl || pSDevSlnPipelineBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnPipelineBase.getCreateDate());
        }
        if (pSDevSlnPipelineBase.isCreateManDirty() && (bl || pSDevSlnPipelineBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnPipelineBase.getCreateMan());
        }
        if (pSDevSlnPipelineBase.isCustomCodeDirty() && (bl || pSDevSlnPipelineBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDevSlnPipelineBase.getCustomCode());
        }
        if (pSDevSlnPipelineBase.isMajorFlagDirty() && (bl || pSDevSlnPipelineBase.getMajorFlag() != null)) {
            iDataObject.set(FIELD_MAJORFLAG, (Object)pSDevSlnPipelineBase.getMajorFlag());
        }
        if (pSDevSlnPipelineBase.isMemoDirty() && (bl || pSDevSlnPipelineBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnPipelineBase.getMemo());
        }
        if (pSDevSlnPipelineBase.isModelDirty() && (bl || pSDevSlnPipelineBase.getModel() != null)) {
            iDataObject.set(FIELD_MODEL, (Object)pSDevSlnPipelineBase.getModel());
        }
        if (pSDevSlnPipelineBase.isPipelineModelDirty() && (bl || pSDevSlnPipelineBase.getPipelineModel() != null)) {
            iDataObject.set(FIELD_PIPELINEMODEL, (Object)pSDevSlnPipelineBase.getPipelineModel());
        }
        if (pSDevSlnPipelineBase.isPipelineParamsDirty() && (bl || pSDevSlnPipelineBase.getPipelineParams() != null)) {
            iDataObject.set(FIELD_PIPELINEPARAMS, (Object)pSDevSlnPipelineBase.getPipelineParams());
        }
        if (pSDevSlnPipelineBase.isPipelineTagDirty() && (bl || pSDevSlnPipelineBase.getPipelineTag() != null)) {
            iDataObject.set(FIELD_PIPELINETAG, (Object)pSDevSlnPipelineBase.getPipelineTag());
        }
        if (pSDevSlnPipelineBase.isPipelineTag2Dirty() && (bl || pSDevSlnPipelineBase.getPipelineTag2() != null)) {
            iDataObject.set(FIELD_PIPELINETAG2, (Object)pSDevSlnPipelineBase.getPipelineTag2());
        }
        if (pSDevSlnPipelineBase.isPipelineTag3Dirty() && (bl || pSDevSlnPipelineBase.getPipelineTag3() != null)) {
            iDataObject.set(FIELD_PIPELINETAG3, (Object)pSDevSlnPipelineBase.getPipelineTag3());
        }
        if (pSDevSlnPipelineBase.isPipelineTag4Dirty() && (bl || pSDevSlnPipelineBase.getPipelineTag4() != null)) {
            iDataObject.set(FIELD_PIPELINETAG4, (Object)pSDevSlnPipelineBase.getPipelineTag4());
        }
        if (pSDevSlnPipelineBase.isPipelineTypeDirty() && (bl || pSDevSlnPipelineBase.getPipelineType() != null)) {
            iDataObject.set(FIELD_PIPELINETYPE, (Object)pSDevSlnPipelineBase.getPipelineType());
        }
        if (pSDevSlnPipelineBase.isPSDCCodeSnippetIdDirty() && (bl || pSDevSlnPipelineBase.getPSDCCodeSnippetId() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETID, (Object)pSDevSlnPipelineBase.getPSDCCodeSnippetId());
        }
        if (pSDevSlnPipelineBase.isPSDCCodeSnippetNameDirty() && (bl || pSDevSlnPipelineBase.getPSDCCodeSnippetName() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETNAME, (Object)pSDevSlnPipelineBase.getPSDCCodeSnippetName());
        }
        if (pSDevSlnPipelineBase.isPSDCDeployCenterIdDirty() && (bl || pSDevSlnPipelineBase.getPSDCDeployCenterId() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYCENTERID, (Object)pSDevSlnPipelineBase.getPSDCDeployCenterId());
        }
        if (pSDevSlnPipelineBase.isPSDCDeployCenterNameDirty() && (bl || pSDevSlnPipelineBase.getPSDCDeployCenterName() != null)) {
            iDataObject.set(FIELD_PSDCDEPLOYCENTERNAME, (Object)pSDevSlnPipelineBase.getPSDCDeployCenterName());
        }
        if (pSDevSlnPipelineBase.isPSDevCenterIdDirty() && (bl || pSDevSlnPipelineBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevSlnPipelineBase.getPSDevCenterId());
        }
        if (pSDevSlnPipelineBase.isPSDevCenterSVNIdDirty() && (bl || pSDevSlnPipelineBase.getPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNID, (Object)pSDevSlnPipelineBase.getPSDevCenterSVNId());
        }
        if (pSDevSlnPipelineBase.isPSDevCenterSVNNameDirty() && (bl || pSDevSlnPipelineBase.getPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSVNNAME, (Object)pSDevSlnPipelineBase.getPSDevCenterSVNName());
        }
        if (pSDevSlnPipelineBase.isPSDevSlnIdDirty() && (bl || pSDevSlnPipelineBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnPipelineBase.getPSDevSlnId());
        }
        if (pSDevSlnPipelineBase.isPSDevSlnNameDirty() && (bl || pSDevSlnPipelineBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnPipelineBase.getPSDevSlnName());
        }
        if (pSDevSlnPipelineBase.isPSDevSlnPipelineIdDirty() && (bl || pSDevSlnPipelineBase.getPSDevSlnPipelineId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINEID, (Object)pSDevSlnPipelineBase.getPSDevSlnPipelineId());
        }
        if (pSDevSlnPipelineBase.isPSDevSlnPipelineNameDirty() && (bl || pSDevSlnPipelineBase.getPSDevSlnPipelineName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINENAME, (Object)pSDevSlnPipelineBase.getPSDevSlnPipelineName());
        }
        if (pSDevSlnPipelineBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnPipelineBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnPipelineBase.getPSDevSlnSysId());
        }
        if (pSDevSlnPipelineBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnPipelineBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnPipelineBase.getPSDevSlnSysName());
        }
        if (pSDevSlnPipelineBase.isTemplateModeDirty() && (bl || pSDevSlnPipelineBase.getTemplateMode() != null)) {
            iDataObject.set(FIELD_TEMPLATEMODE, (Object)pSDevSlnPipelineBase.getTemplateMode());
        }
        if (pSDevSlnPipelineBase.isTriggerParamsDirty() && (bl || pSDevSlnPipelineBase.getTriggerParams() != null)) {
            iDataObject.set(FIELD_TRIGGERPARAMS, (Object)pSDevSlnPipelineBase.getTriggerParams());
        }
        if (pSDevSlnPipelineBase.isTriggerTypeDirty() && (bl || pSDevSlnPipelineBase.getTriggerType() != null)) {
            iDataObject.set(FIELD_TRIGGERTYPE, (Object)pSDevSlnPipelineBase.getTriggerType());
        }
        if (pSDevSlnPipelineBase.isUpdateDateDirty() && (bl || pSDevSlnPipelineBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnPipelineBase.getUpdateDate());
        }
        if (pSDevSlnPipelineBase.isUpdateManDirty() && (bl || pSDevSlnPipelineBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnPipelineBase.getUpdateMan());
        }
        if (pSDevSlnPipelineBase.isUserCatDirty() && (bl || pSDevSlnPipelineBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDevSlnPipelineBase.getUserCat());
        }
        if (pSDevSlnPipelineBase.isUserTagDirty() && (bl || pSDevSlnPipelineBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevSlnPipelineBase.getUserTag());
        }
        if (pSDevSlnPipelineBase.isUserTag2Dirty() && (bl || pSDevSlnPipelineBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevSlnPipelineBase.getUserTag2());
        }
        if (pSDevSlnPipelineBase.isUserTag3Dirty() && (bl || pSDevSlnPipelineBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevSlnPipelineBase.getUserTag3());
        }
        if (pSDevSlnPipelineBase.isUserTag4Dirty() && (bl || pSDevSlnPipelineBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevSlnPipelineBase.getUserTag4());
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
        return PSDevSlnPipelineBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnPipelineBase pSDevSlnPipelineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnPipelineBase.resetAgentTags();
                return true;
            }
            case 1: {
                pSDevSlnPipelineBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDevSlnPipelineBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDevSlnPipelineBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDevSlnPipelineBase.resetCustomCode();
                return true;
            }
            case 5: {
                pSDevSlnPipelineBase.resetMajorFlag();
                return true;
            }
            case 6: {
                pSDevSlnPipelineBase.resetMemo();
                return true;
            }
            case 7: {
                pSDevSlnPipelineBase.resetModel();
                return true;
            }
            case 8: {
                pSDevSlnPipelineBase.resetPipelineModel();
                return true;
            }
            case 9: {
                pSDevSlnPipelineBase.resetPipelineParams();
                return true;
            }
            case 10: {
                pSDevSlnPipelineBase.resetPipelineTag();
                return true;
            }
            case 11: {
                pSDevSlnPipelineBase.resetPipelineTag2();
                return true;
            }
            case 12: {
                pSDevSlnPipelineBase.resetPipelineTag3();
                return true;
            }
            case 13: {
                pSDevSlnPipelineBase.resetPipelineTag4();
                return true;
            }
            case 14: {
                pSDevSlnPipelineBase.resetPipelineType();
                return true;
            }
            case 15: {
                pSDevSlnPipelineBase.resetPSDCCodeSnippetId();
                return true;
            }
            case 16: {
                pSDevSlnPipelineBase.resetPSDCCodeSnippetName();
                return true;
            }
            case 17: {
                pSDevSlnPipelineBase.resetPSDCDeployCenterId();
                return true;
            }
            case 18: {
                pSDevSlnPipelineBase.resetPSDCDeployCenterName();
                return true;
            }
            case 19: {
                pSDevSlnPipelineBase.resetPSDevCenterId();
                return true;
            }
            case 20: {
                pSDevSlnPipelineBase.resetPSDevCenterSVNId();
                return true;
            }
            case 21: {
                pSDevSlnPipelineBase.resetPSDevCenterSVNName();
                return true;
            }
            case 22: {
                pSDevSlnPipelineBase.resetPSDevSlnId();
                return true;
            }
            case 23: {
                pSDevSlnPipelineBase.resetPSDevSlnName();
                return true;
            }
            case 24: {
                pSDevSlnPipelineBase.resetPSDevSlnPipelineId();
                return true;
            }
            case 25: {
                pSDevSlnPipelineBase.resetPSDevSlnPipelineName();
                return true;
            }
            case 26: {
                pSDevSlnPipelineBase.resetPSDevSlnSysId();
                return true;
            }
            case 27: {
                pSDevSlnPipelineBase.resetPSDevSlnSysName();
                return true;
            }
            case 28: {
                pSDevSlnPipelineBase.resetTemplateMode();
                return true;
            }
            case 29: {
                pSDevSlnPipelineBase.resetTriggerParams();
                return true;
            }
            case 30: {
                pSDevSlnPipelineBase.resetTriggerType();
                return true;
            }
            case 31: {
                pSDevSlnPipelineBase.resetUpdateDate();
                return true;
            }
            case 32: {
                pSDevSlnPipelineBase.resetUpdateMan();
                return true;
            }
            case 33: {
                pSDevSlnPipelineBase.resetUserCat();
                return true;
            }
            case 34: {
                pSDevSlnPipelineBase.resetUserTag();
                return true;
            }
            case 35: {
                pSDevSlnPipelineBase.resetUserTag2();
                return true;
            }
            case 36: {
                pSDevSlnPipelineBase.resetUserTag3();
                return true;
            }
            case 37: {
                pSDevSlnPipelineBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCCodeSnippet getPSDCCodeSnippet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCodeSnippet();
        }
        if (this.getPSDCCodeSnippetId() == null) {
            return null;
        }
        Integer n = this.objPSDCCodeSnippetLock;
        synchronized (n) {
            if (this.psdccodesnippet != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCCodeSnippetId(), (Object)this.psdccodesnippet.getPSDCCodeSnippetId()) != 0L) {
                this.psdccodesnippet = null;
            }
            if (this.psdccodesnippet == null) {
                PSDCCodeSnippet pSDCCodeSnippet = new PSDCCodeSnippet();
                pSDCCodeSnippet.setPSDCCodeSnippetId(this.getPSDCCodeSnippetId());
                PSDCCodeSnippetService pSDCCodeSnippetService = (PSDCCodeSnippetService)ServiceGlobal.getService(PSDCCodeSnippetService.class, (SessionFactory)this.getSessionFactory());
                pSDCCodeSnippetService.autoGet((IEntity)pSDCCodeSnippet);
                this.psdccodesnippet = pSDCCodeSnippet;
            }
            return this.psdccodesnippet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCDeployCenter getPSDCDeployCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDeployCenter();
        }
        if (this.getPSDCDeployCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDCDeployCenterLock;
        synchronized (n) {
            if (this.psdcdeploycenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCDeployCenterId(), (Object)this.psdcdeploycenter.getPSDCDeployCenterId()) != 0L) {
                this.psdcdeploycenter = null;
            }
            if (this.psdcdeploycenter == null) {
                PSDCDeployCenter pSDCDeployCenter = new PSDCDeployCenter();
                pSDCDeployCenter.setPSDCDeployCenterId(this.getPSDCDeployCenterId());
                PSDCDeployCenterService pSDCDeployCenterService = (PSDCDeployCenterService)ServiceGlobal.getService(PSDCDeployCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDCDeployCenterService.autoGet((IEntity)pSDCDeployCenter);
                this.psdcdeploycenter = pSDCDeployCenter;
            }
            return this.psdcdeploycenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSVN();
        }
        if (this.getPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterSVNLock;
        synchronized (n) {
            if (this.psdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterSVNId(), (Object)this.psdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.psdevcentersvn = null;
            }
            if (this.psdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet((IEntity)pSDevCenterSVN);
                this.psdevcentersvn = pSDevCenterSVN;
            }
            return this.psdevcentersvn;
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
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
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
                pSDevSlnService.autoGet((IEntity)pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnPipelineStep> getPSDevSlnPipelineSteps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineSteps();
        }
        if (this.getPSDevSlnPipelineId() == null) {
            return null;
        }
        PSDevSlnPipelineService pSDevSlnPipelineService = (PSDevSlnPipelineService)ServiceGlobal.getService(PSDevSlnPipelineService.class, (SessionFactory)this.getSessionFactory());
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnPipelineStepsLock;
        synchronized (n) {
            if (this.psdevslnpipelinesteps == null) {
                this.psdevslnpipelinesteps = pSDevSlnPipelineService.isTempData((IEntity)this) ? pSDevSlnPipelineStepService.selectTempByPSDevSlnPipeline(this) : pSDevSlnPipelineStepService.selectByPSDevSlnPipeline(this);
            }
            return this.psdevslnpipelinesteps;
        }
    }

    private PSDevSlnPipelineBase getProxyEntity() {
        return this.proxyPSDevSlnPipelineBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnPipelineBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnPipelineBase) {
            this.proxyPSDevSlnPipelineBase = (PSDevSlnPipelineBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AGENTTAGS, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 4);
        fieldIndexMap.put(FIELD_MAJORFLAG, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_MODEL, 7);
        fieldIndexMap.put(FIELD_PIPELINEMODEL, 8);
        fieldIndexMap.put(FIELD_PIPELINEPARAMS, 9);
        fieldIndexMap.put(FIELD_PIPELINETAG, 10);
        fieldIndexMap.put(FIELD_PIPELINETAG2, 11);
        fieldIndexMap.put(FIELD_PIPELINETAG3, 12);
        fieldIndexMap.put(FIELD_PIPELINETAG4, 13);
        fieldIndexMap.put(FIELD_PIPELINETYPE, 14);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETID, 15);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETNAME, 16);
        fieldIndexMap.put(FIELD_PSDCDEPLOYCENTERID, 17);
        fieldIndexMap.put(FIELD_PSDCDEPLOYCENTERNAME, 18);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 19);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNID, 20);
        fieldIndexMap.put(FIELD_PSDEVCENTERSVNNAME, 21);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 22);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 23);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINEID, 24);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINENAME, 25);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 26);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 27);
        fieldIndexMap.put(FIELD_TEMPLATEMODE, 28);
        fieldIndexMap.put(FIELD_TRIGGERPARAMS, 29);
        fieldIndexMap.put(FIELD_TRIGGERTYPE, 30);
        fieldIndexMap.put(FIELD_UPDATEDATE, 31);
        fieldIndexMap.put(FIELD_UPDATEMAN, 32);
        fieldIndexMap.put(FIELD_USERCAT, 33);
        fieldIndexMap.put(FIELD_USERTAG, 34);
        fieldIndexMap.put(FIELD_USERTAG2, 35);
        fieldIndexMap.put(FIELD_USERTAG3, 36);
        fieldIndexMap.put(FIELD_USERTAG4, 37);
    }
}

