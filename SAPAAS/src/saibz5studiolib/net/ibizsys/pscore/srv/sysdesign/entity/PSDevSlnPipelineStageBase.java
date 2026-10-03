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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStep;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnPipelineStageBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnPipelineStageBase.class);
    public static final String FIELD_AGENTDOCKERFILE = "AGENTDOCKERFILE";
    public static final String FIELD_AGENTIMAGE = "AGENTIMAGE";
    public static final String FIELD_AGENTIMAGEARGS = "AGENTIMAGEARGS";
    public static final String FIELD_AGENTPSDCREGISTRYITEMID = "AGENTPSDCREGISTRYITEMID";
    public static final String FIELD_AGENTPSDCREGISTRYITEMNAME = "AGENTPSDCREGISTRYITEMNAME";
    public static final String FIELD_AGENTREUSEMODE = "AGENTREUSEMODE";
    public static final String FIELD_AGENTTAGS = "AGENTTAGS";
    public static final String FIELD_AGENTTYPE = "AGENTTYPE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONDMODEL = "CONDMODEL";
    public static final String FIELD_CONDMODELFLAG = "CONDMODELFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_POSTMODE = "POSTMODE";
    public static final String FIELD_PSDCCODESNIPPETID = "PSDCCODESNIPPETID";
    public static final String FIELD_PSDCCODESNIPPETNAME = "PSDCCODESNIPPETNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNPIPELINEID = "PSDEVSLNPIPELINEID";
    public static final String FIELD_PSDEVSLNPIPELINENAME = "PSDEVSLNPIPELINENAME";
    public static final String FIELD_PSDEVSLNPIPELINESTAGEID = "PSDEVSLNPIPELINESTAGEID";
    public static final String FIELD_PSDEVSLNPIPELINESTAGENAME = "PSDEVSLNPIPELINESTAGENAME";
    public static final String FIELD_STAGEPARAMS = "STAGEPARAMS";
    public static final String FIELD_STAGETYPE = "STAGETYPE";
    public static final String FIELD_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_AGENTDOCKERFILE = 0;
    private static final int INDEX_AGENTIMAGE = 1;
    private static final int INDEX_AGENTIMAGEARGS = 2;
    private static final int INDEX_AGENTPSDCREGISTRYITEMID = 3;
    private static final int INDEX_AGENTPSDCREGISTRYITEMNAME = 4;
    private static final int INDEX_AGENTREUSEMODE = 5;
    private static final int INDEX_AGENTTAGS = 6;
    private static final int INDEX_AGENTTYPE = 7;
    private static final int INDEX_CODENAME = 8;
    private static final int INDEX_CONDMODEL = 9;
    private static final int INDEX_CONDMODELFLAG = 10;
    private static final int INDEX_CREATEDATE = 11;
    private static final int INDEX_CREATEMAN = 12;
    private static final int INDEX_CUSTOMCODE = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_ORDERVALUE = 15;
    private static final int INDEX_POSTMODE = 16;
    private static final int INDEX_PSDCCODESNIPPETID = 17;
    private static final int INDEX_PSDCCODESNIPPETNAME = 18;
    private static final int INDEX_PSDEVSLNID = 19;
    private static final int INDEX_PSDEVSLNPIPELINEID = 20;
    private static final int INDEX_PSDEVSLNPIPELINENAME = 21;
    private static final int INDEX_PSDEVSLNPIPELINESTAGEID = 22;
    private static final int INDEX_PSDEVSLNPIPELINESTAGENAME = 23;
    private static final int INDEX_STAGEPARAMS = 24;
    private static final int INDEX_STAGETYPE = 25;
    private static final int INDEX_TEMPLATEMODE = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_USERCAT = 29;
    private static final int INDEX_USERTAG = 30;
    private static final int INDEX_USERTAG2 = 31;
    private static final int INDEX_USERTAG3 = 32;
    private static final int INDEX_USERTAG4 = 33;
    private static final int INDEX_VALIDFLAG = 34;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnPipelineStageBase proxyPSDevSlnPipelineStageBase = null;
    private boolean agentdockerfileDirtyFlag = false;
    private boolean agentimageDirtyFlag = false;
    private boolean agentimageargsDirtyFlag = false;
    private boolean agentpsdcregistryitemidDirtyFlag = false;
    private boolean agentpsdcregistryitemnameDirtyFlag = false;
    private boolean agentreusemodeDirtyFlag = false;
    private boolean agenttagsDirtyFlag = false;
    private boolean agenttypeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean condmodelDirtyFlag = false;
    private boolean condmodelflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean postmodeDirtyFlag = false;
    private boolean psdccodesnippetidDirtyFlag = false;
    private boolean psdccodesnippetnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnpipelineidDirtyFlag = false;
    private boolean psdevslnpipelinenameDirtyFlag = false;
    private boolean psdevslnpipelinestageidDirtyFlag = false;
    private boolean psdevslnpipelinestagenameDirtyFlag = false;
    private boolean stageparamsDirtyFlag = false;
    private boolean stagetypeDirtyFlag = false;
    private boolean templatemodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="agentdockerfile")
    private String agentdockerfile;
    @Column(name="agentimage")
    private String agentimage;
    @Column(name="agentimageargs")
    private String agentimageargs;
    @Column(name="agentpsdcregistryitemid")
    private String agentpsdcregistryitemid;
    @Column(name="agentpsdcregistryitemname")
    private String agentpsdcregistryitemname;
    @Column(name="agentreusemode")
    private Integer agentreusemode;
    @Column(name="agenttags")
    private String agenttags;
    @Column(name="agenttype")
    private String agenttype;
    @Column(name="codename")
    private String codename;
    @Column(name="condmodel")
    private String condmodel;
    @Column(name="condmodelflag")
    private Integer condmodelflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="postmode")
    private String postmode;
    @Column(name="psdccodesnippetid")
    private String psdccodesnippetid;
    @Column(name="psdccodesnippetname")
    private String psdccodesnippetname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnpipelineid")
    private String psdevslnpipelineid;
    @Column(name="psdevslnpipelinename")
    private String psdevslnpipelinename;
    @Column(name="psdevslnpipelinestageid")
    private String psdevslnpipelinestageid;
    @Column(name="psdevslnpipelinestagename")
    private String psdevslnpipelinestagename;
    @Column(name="stageparams")
    private String stageparams;
    @Column(name="stagetype")
    private String stagetype;
    @Column(name="templatemode")
    private Integer templatemode;
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
    private Integer objPSDCCodeSnippetLock = new Integer(1);
    private PSDCCodeSnippet psdccodesnippet = null;
    private Integer objAgentPSDCRegistryItemLock = new Integer(1);
    private PSDCRegistryItem agentpsdcregistryitem = null;
    private Integer objPSDevSlnPipelineLock = new Integer(1);
    private PSDevSlnPipeline psdevslnpipeline = null;
    private Integer objPSDevSlnPipelineStepsLock = new Integer(1);
    private ArrayList<PSDevSlnPipelineStep> psdevslnpipelinesteps = null;

    public void setAgentDockerFile(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentDockerFile(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.agentdockerfile = string;
        this.agentdockerfileDirtyFlag = true;
    }

    public String getAgentDockerFile() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentDockerFile();
        }
        return this.agentdockerfile;
    }

    public boolean isAgentDockerFileDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentDockerFileDirty();
        }
        return this.agentdockerfileDirtyFlag;
    }

    public void resetAgentDockerFile() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentDockerFile();
            return;
        }
        this.agentdockerfileDirtyFlag = false;
        this.agentdockerfile = null;
    }

    public void setAgentImage(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentImage(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.agentimage = string;
        this.agentimageDirtyFlag = true;
    }

    public String getAgentImage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentImage();
        }
        return this.agentimage;
    }

    public boolean isAgentImageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentImageDirty();
        }
        return this.agentimageDirtyFlag;
    }

    public void resetAgentImage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentImage();
            return;
        }
        this.agentimageDirtyFlag = false;
        this.agentimage = null;
    }

    public void setAgentImageArgs(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentImageArgs(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.agentimageargs = string;
        this.agentimageargsDirtyFlag = true;
    }

    public String getAgentImageArgs() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentImageArgs();
        }
        return this.agentimageargs;
    }

    public boolean isAgentImageArgsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentImageArgsDirty();
        }
        return this.agentimageargsDirtyFlag;
    }

    public void resetAgentImageArgs() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentImageArgs();
            return;
        }
        this.agentimageargsDirtyFlag = false;
        this.agentimageargs = null;
    }

    public void setAgentPSDCRegistryItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentPSDCRegistryItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.agentpsdcregistryitemid = string;
        this.agentpsdcregistryitemidDirtyFlag = true;
    }

    public String getAgentPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentPSDCRegistryItemId();
        }
        return this.agentpsdcregistryitemid;
    }

    public boolean isAgentPSDCRegistryItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentPSDCRegistryItemIdDirty();
        }
        return this.agentpsdcregistryitemidDirtyFlag;
    }

    public void resetAgentPSDCRegistryItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentPSDCRegistryItemId();
            return;
        }
        this.agentpsdcregistryitemidDirtyFlag = false;
        this.agentpsdcregistryitemid = null;
    }

    public void setAgentPSDCRegistryItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentPSDCRegistryItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.agentpsdcregistryitemname = string;
        this.agentpsdcregistryitemnameDirtyFlag = true;
    }

    public String getAgentPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentPSDCRegistryItemName();
        }
        return this.agentpsdcregistryitemname;
    }

    public boolean isAgentPSDCRegistryItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentPSDCRegistryItemNameDirty();
        }
        return this.agentpsdcregistryitemnameDirtyFlag;
    }

    public void resetAgentPSDCRegistryItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentPSDCRegistryItemName();
            return;
        }
        this.agentpsdcregistryitemnameDirtyFlag = false;
        this.agentpsdcregistryitemname = null;
    }

    public void setAgentReuseMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentReuseMode(n);
            return;
        }
        this.agentreusemode = n;
        this.agentreusemodeDirtyFlag = true;
    }

    public Integer getAgentReuseMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentReuseMode();
        }
        return this.agentreusemode;
    }

    public boolean isAgentReuseModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentReuseModeDirty();
        }
        return this.agentreusemodeDirtyFlag;
    }

    public void resetAgentReuseMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentReuseMode();
            return;
        }
        this.agentreusemodeDirtyFlag = false;
        this.agentreusemode = null;
    }

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

    public void setCondModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condmodel = string;
        this.condmodelDirtyFlag = true;
    }

    public String getCondModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondModel();
        }
        return this.condmodel;
    }

    public boolean isCondModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondModelDirty();
        }
        return this.condmodelDirtyFlag;
    }

    public void resetCondModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondModel();
            return;
        }
        this.condmodelDirtyFlag = false;
        this.condmodel = null;
    }

    public void setCondModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondModelFlag(n);
            return;
        }
        this.condmodelflag = n;
        this.condmodelflagDirtyFlag = true;
    }

    public Integer getCondModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondModelFlag();
        }
        return this.condmodelflag;
    }

    public boolean isCondModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondModelFlagDirty();
        }
        return this.condmodelflagDirtyFlag;
    }

    public void resetCondModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondModelFlag();
            return;
        }
        this.condmodelflagDirtyFlag = false;
        this.condmodelflag = null;
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

    public void setPostMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPostMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.postmode = string;
        this.postmodeDirtyFlag = true;
    }

    public String getPostMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPostMode();
        }
        return this.postmode;
    }

    public boolean isPostModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPostModeDirty();
        }
        return this.postmodeDirtyFlag;
    }

    public void resetPostMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPostMode();
            return;
        }
        this.postmodeDirtyFlag = false;
        this.postmode = null;
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

    public void setPSDevSlnPipelineStageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineStageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinestageid = string;
        this.psdevslnpipelinestageidDirtyFlag = true;
    }

    public String getPSDevSlnPipelineStageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineStageId();
        }
        return this.psdevslnpipelinestageid;
    }

    public boolean isPSDevSlnPipelineStageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineStageIdDirty();
        }
        return this.psdevslnpipelinestageidDirtyFlag;
    }

    public void resetPSDevSlnPipelineStageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineStageId();
            return;
        }
        this.psdevslnpipelinestageidDirtyFlag = false;
        this.psdevslnpipelinestageid = null;
    }

    public void setPSDevSlnPipelineStageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnPipelineStageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnpipelinestagename = string;
        this.psdevslnpipelinestagenameDirtyFlag = true;
    }

    public String getPSDevSlnPipelineStageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineStageName();
        }
        return this.psdevslnpipelinestagename;
    }

    public boolean isPSDevSlnPipelineStageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnPipelineStageNameDirty();
        }
        return this.psdevslnpipelinestagenameDirtyFlag;
    }

    public void resetPSDevSlnPipelineStageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnPipelineStageName();
            return;
        }
        this.psdevslnpipelinestagenameDirtyFlag = false;
        this.psdevslnpipelinestagename = null;
    }

    public void setStageParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStageParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.stageparams = string;
        this.stageparamsDirtyFlag = true;
    }

    public String getStageParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStageParams();
        }
        return this.stageparams;
    }

    public boolean isStageParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStageParamsDirty();
        }
        return this.stageparamsDirtyFlag;
    }

    public void resetStageParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStageParams();
            return;
        }
        this.stageparamsDirtyFlag = false;
        this.stageparams = null;
    }

    public void setStageType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStageType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.stagetype = string;
        this.stagetypeDirtyFlag = true;
    }

    public String getStageType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStageType();
        }
        return this.stagetype;
    }

    public boolean isStageTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStageTypeDirty();
        }
        return this.stagetypeDirtyFlag;
    }

    public void resetStageType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStageType();
            return;
        }
        this.stagetypeDirtyFlag = false;
        this.stagetype = null;
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
        PSDevSlnPipelineStageBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase) {
        pSDevSlnPipelineStageBase.resetAgentDockerFile();
        pSDevSlnPipelineStageBase.resetAgentImage();
        pSDevSlnPipelineStageBase.resetAgentImageArgs();
        pSDevSlnPipelineStageBase.resetAgentPSDCRegistryItemId();
        pSDevSlnPipelineStageBase.resetAgentPSDCRegistryItemName();
        pSDevSlnPipelineStageBase.resetAgentReuseMode();
        pSDevSlnPipelineStageBase.resetAgentTags();
        pSDevSlnPipelineStageBase.resetAgentType();
        pSDevSlnPipelineStageBase.resetCodeName();
        pSDevSlnPipelineStageBase.resetCondModel();
        pSDevSlnPipelineStageBase.resetCondModelFlag();
        pSDevSlnPipelineStageBase.resetCreateDate();
        pSDevSlnPipelineStageBase.resetCreateMan();
        pSDevSlnPipelineStageBase.resetCustomCode();
        pSDevSlnPipelineStageBase.resetMemo();
        pSDevSlnPipelineStageBase.resetOrderValue();
        pSDevSlnPipelineStageBase.resetPostMode();
        pSDevSlnPipelineStageBase.resetPSDCCodeSnippetId();
        pSDevSlnPipelineStageBase.resetPSDCCodeSnippetName();
        pSDevSlnPipelineStageBase.resetPSDevSlnId();
        pSDevSlnPipelineStageBase.resetPSDevSlnPipelineId();
        pSDevSlnPipelineStageBase.resetPSDevSlnPipelineName();
        pSDevSlnPipelineStageBase.resetPSDevSlnPipelineStageId();
        pSDevSlnPipelineStageBase.resetPSDevSlnPipelineStageName();
        pSDevSlnPipelineStageBase.resetStageParams();
        pSDevSlnPipelineStageBase.resetStageType();
        pSDevSlnPipelineStageBase.resetTemplateMode();
        pSDevSlnPipelineStageBase.resetUpdateDate();
        pSDevSlnPipelineStageBase.resetUpdateMan();
        pSDevSlnPipelineStageBase.resetUserCat();
        pSDevSlnPipelineStageBase.resetUserTag();
        pSDevSlnPipelineStageBase.resetUserTag2();
        pSDevSlnPipelineStageBase.resetUserTag3();
        pSDevSlnPipelineStageBase.resetUserTag4();
        pSDevSlnPipelineStageBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAgentDockerFileDirty()) {
            hashMap.put(FIELD_AGENTDOCKERFILE, this.getAgentDockerFile());
        }
        if (!bl || this.isAgentImageDirty()) {
            hashMap.put(FIELD_AGENTIMAGE, this.getAgentImage());
        }
        if (!bl || this.isAgentImageArgsDirty()) {
            hashMap.put(FIELD_AGENTIMAGEARGS, this.getAgentImageArgs());
        }
        if (!bl || this.isAgentPSDCRegistryItemIdDirty()) {
            hashMap.put(FIELD_AGENTPSDCREGISTRYITEMID, this.getAgentPSDCRegistryItemId());
        }
        if (!bl || this.isAgentPSDCRegistryItemNameDirty()) {
            hashMap.put(FIELD_AGENTPSDCREGISTRYITEMNAME, this.getAgentPSDCRegistryItemName());
        }
        if (!bl || this.isAgentReuseModeDirty()) {
            hashMap.put(FIELD_AGENTREUSEMODE, this.getAgentReuseMode());
        }
        if (!bl || this.isAgentTagsDirty()) {
            hashMap.put(FIELD_AGENTTAGS, this.getAgentTags());
        }
        if (!bl || this.isAgentTypeDirty()) {
            hashMap.put(FIELD_AGENTTYPE, this.getAgentType());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCondModelDirty()) {
            hashMap.put(FIELD_CONDMODEL, this.getCondModel());
        }
        if (!bl || this.isCondModelFlagDirty()) {
            hashMap.put(FIELD_CONDMODELFLAG, this.getCondModelFlag());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPostModeDirty()) {
            hashMap.put(FIELD_POSTMODE, this.getPostMode());
        }
        if (!bl || this.isPSDCCodeSnippetIdDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETID, this.getPSDCCodeSnippetId());
        }
        if (!bl || this.isPSDCCodeSnippetNameDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETNAME, this.getPSDCCodeSnippetName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnPipelineIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINEID, this.getPSDevSlnPipelineId());
        }
        if (!bl || this.isPSDevSlnPipelineNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINENAME, this.getPSDevSlnPipelineName());
        }
        if (!bl || this.isPSDevSlnPipelineStageIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINESTAGEID, this.getPSDevSlnPipelineStageId());
        }
        if (!bl || this.isPSDevSlnPipelineStageNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNPIPELINESTAGENAME, this.getPSDevSlnPipelineStageName());
        }
        if (!bl || this.isStageParamsDirty()) {
            hashMap.put(FIELD_STAGEPARAMS, this.getStageParams());
        }
        if (!bl || this.isStageTypeDirty()) {
            hashMap.put(FIELD_STAGETYPE, this.getStageType());
        }
        if (!bl || this.isTemplateModeDirty()) {
            hashMap.put(FIELD_TEMPLATEMODE, this.getTemplateMode());
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
        return PSDevSlnPipelineStageBase.get(this, n);
    }

    private static Object get(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnPipelineStageBase.getAgentDockerFile();
            }
            case 1: {
                return pSDevSlnPipelineStageBase.getAgentImage();
            }
            case 2: {
                return pSDevSlnPipelineStageBase.getAgentImageArgs();
            }
            case 3: {
                return pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemId();
            }
            case 4: {
                return pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemName();
            }
            case 5: {
                return pSDevSlnPipelineStageBase.getAgentReuseMode();
            }
            case 6: {
                return pSDevSlnPipelineStageBase.getAgentTags();
            }
            case 7: {
                return pSDevSlnPipelineStageBase.getAgentType();
            }
            case 8: {
                return pSDevSlnPipelineStageBase.getCodeName();
            }
            case 9: {
                return pSDevSlnPipelineStageBase.getCondModel();
            }
            case 10: {
                return pSDevSlnPipelineStageBase.getCondModelFlag();
            }
            case 11: {
                return pSDevSlnPipelineStageBase.getCreateDate();
            }
            case 12: {
                return pSDevSlnPipelineStageBase.getCreateMan();
            }
            case 13: {
                return pSDevSlnPipelineStageBase.getCustomCode();
            }
            case 14: {
                return pSDevSlnPipelineStageBase.getMemo();
            }
            case 15: {
                return pSDevSlnPipelineStageBase.getOrderValue();
            }
            case 16: {
                return pSDevSlnPipelineStageBase.getPostMode();
            }
            case 17: {
                return pSDevSlnPipelineStageBase.getPSDCCodeSnippetId();
            }
            case 18: {
                return pSDevSlnPipelineStageBase.getPSDCCodeSnippetName();
            }
            case 19: {
                return pSDevSlnPipelineStageBase.getPSDevSlnId();
            }
            case 20: {
                return pSDevSlnPipelineStageBase.getPSDevSlnPipelineId();
            }
            case 21: {
                return pSDevSlnPipelineStageBase.getPSDevSlnPipelineName();
            }
            case 22: {
                return pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageId();
            }
            case 23: {
                return pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageName();
            }
            case 24: {
                return pSDevSlnPipelineStageBase.getStageParams();
            }
            case 25: {
                return pSDevSlnPipelineStageBase.getStageType();
            }
            case 26: {
                return pSDevSlnPipelineStageBase.getTemplateMode();
            }
            case 27: {
                return pSDevSlnPipelineStageBase.getUpdateDate();
            }
            case 28: {
                return pSDevSlnPipelineStageBase.getUpdateMan();
            }
            case 29: {
                return pSDevSlnPipelineStageBase.getUserCat();
            }
            case 30: {
                return pSDevSlnPipelineStageBase.getUserTag();
            }
            case 31: {
                return pSDevSlnPipelineStageBase.getUserTag2();
            }
            case 32: {
                return pSDevSlnPipelineStageBase.getUserTag3();
            }
            case 33: {
                return pSDevSlnPipelineStageBase.getUserTag4();
            }
            case 34: {
                return pSDevSlnPipelineStageBase.getValidFlag();
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
        PSDevSlnPipelineStageBase.set(this, n, object);
    }

    private static void set(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnPipelineStageBase.setAgentDockerFile(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnPipelineStageBase.setAgentImage(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnPipelineStageBase.setAgentImageArgs(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnPipelineStageBase.setAgentPSDCRegistryItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnPipelineStageBase.setAgentPSDCRegistryItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnPipelineStageBase.setAgentReuseMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnPipelineStageBase.setAgentTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnPipelineStageBase.setAgentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnPipelineStageBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnPipelineStageBase.setCondModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnPipelineStageBase.setCondModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnPipelineStageBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnPipelineStageBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnPipelineStageBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnPipelineStageBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnPipelineStageBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnPipelineStageBase.setPostMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnPipelineStageBase.setPSDCCodeSnippetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnPipelineStageBase.setPSDCCodeSnippetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnPipelineStageBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnPipelineStageBase.setPSDevSlnPipelineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnPipelineStageBase.setPSDevSlnPipelineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnPipelineStageBase.setPSDevSlnPipelineStageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnPipelineStageBase.setPSDevSlnPipelineStageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnPipelineStageBase.setStageParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnPipelineStageBase.setStageType(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnPipelineStageBase.setTemplateMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnPipelineStageBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnPipelineStageBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnPipelineStageBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevSlnPipelineStageBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevSlnPipelineStageBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevSlnPipelineStageBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevSlnPipelineStageBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevSlnPipelineStageBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnPipelineStageBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnPipelineStageBase.getAgentDockerFile() == null;
            }
            case 1: {
                return pSDevSlnPipelineStageBase.getAgentImage() == null;
            }
            case 2: {
                return pSDevSlnPipelineStageBase.getAgentImageArgs() == null;
            }
            case 3: {
                return pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemId() == null;
            }
            case 4: {
                return pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemName() == null;
            }
            case 5: {
                return pSDevSlnPipelineStageBase.getAgentReuseMode() == null;
            }
            case 6: {
                return pSDevSlnPipelineStageBase.getAgentTags() == null;
            }
            case 7: {
                return pSDevSlnPipelineStageBase.getAgentType() == null;
            }
            case 8: {
                return pSDevSlnPipelineStageBase.getCodeName() == null;
            }
            case 9: {
                return pSDevSlnPipelineStageBase.getCondModel() == null;
            }
            case 10: {
                return pSDevSlnPipelineStageBase.getCondModelFlag() == null;
            }
            case 11: {
                return pSDevSlnPipelineStageBase.getCreateDate() == null;
            }
            case 12: {
                return pSDevSlnPipelineStageBase.getCreateMan() == null;
            }
            case 13: {
                return pSDevSlnPipelineStageBase.getCustomCode() == null;
            }
            case 14: {
                return pSDevSlnPipelineStageBase.getMemo() == null;
            }
            case 15: {
                return pSDevSlnPipelineStageBase.getOrderValue() == null;
            }
            case 16: {
                return pSDevSlnPipelineStageBase.getPostMode() == null;
            }
            case 17: {
                return pSDevSlnPipelineStageBase.getPSDCCodeSnippetId() == null;
            }
            case 18: {
                return pSDevSlnPipelineStageBase.getPSDCCodeSnippetName() == null;
            }
            case 19: {
                return pSDevSlnPipelineStageBase.getPSDevSlnId() == null;
            }
            case 20: {
                return pSDevSlnPipelineStageBase.getPSDevSlnPipelineId() == null;
            }
            case 21: {
                return pSDevSlnPipelineStageBase.getPSDevSlnPipelineName() == null;
            }
            case 22: {
                return pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageId() == null;
            }
            case 23: {
                return pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageName() == null;
            }
            case 24: {
                return pSDevSlnPipelineStageBase.getStageParams() == null;
            }
            case 25: {
                return pSDevSlnPipelineStageBase.getStageType() == null;
            }
            case 26: {
                return pSDevSlnPipelineStageBase.getTemplateMode() == null;
            }
            case 27: {
                return pSDevSlnPipelineStageBase.getUpdateDate() == null;
            }
            case 28: {
                return pSDevSlnPipelineStageBase.getUpdateMan() == null;
            }
            case 29: {
                return pSDevSlnPipelineStageBase.getUserCat() == null;
            }
            case 30: {
                return pSDevSlnPipelineStageBase.getUserTag() == null;
            }
            case 31: {
                return pSDevSlnPipelineStageBase.getUserTag2() == null;
            }
            case 32: {
                return pSDevSlnPipelineStageBase.getUserTag3() == null;
            }
            case 33: {
                return pSDevSlnPipelineStageBase.getUserTag4() == null;
            }
            case 34: {
                return pSDevSlnPipelineStageBase.getValidFlag() == null;
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
        return PSDevSlnPipelineStageBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnPipelineStageBase.isAgentDockerFileDirty();
            }
            case 1: {
                return pSDevSlnPipelineStageBase.isAgentImageDirty();
            }
            case 2: {
                return pSDevSlnPipelineStageBase.isAgentImageArgsDirty();
            }
            case 3: {
                return pSDevSlnPipelineStageBase.isAgentPSDCRegistryItemIdDirty();
            }
            case 4: {
                return pSDevSlnPipelineStageBase.isAgentPSDCRegistryItemNameDirty();
            }
            case 5: {
                return pSDevSlnPipelineStageBase.isAgentReuseModeDirty();
            }
            case 6: {
                return pSDevSlnPipelineStageBase.isAgentTagsDirty();
            }
            case 7: {
                return pSDevSlnPipelineStageBase.isAgentTypeDirty();
            }
            case 8: {
                return pSDevSlnPipelineStageBase.isCodeNameDirty();
            }
            case 9: {
                return pSDevSlnPipelineStageBase.isCondModelDirty();
            }
            case 10: {
                return pSDevSlnPipelineStageBase.isCondModelFlagDirty();
            }
            case 11: {
                return pSDevSlnPipelineStageBase.isCreateDateDirty();
            }
            case 12: {
                return pSDevSlnPipelineStageBase.isCreateManDirty();
            }
            case 13: {
                return pSDevSlnPipelineStageBase.isCustomCodeDirty();
            }
            case 14: {
                return pSDevSlnPipelineStageBase.isMemoDirty();
            }
            case 15: {
                return pSDevSlnPipelineStageBase.isOrderValueDirty();
            }
            case 16: {
                return pSDevSlnPipelineStageBase.isPostModeDirty();
            }
            case 17: {
                return pSDevSlnPipelineStageBase.isPSDCCodeSnippetIdDirty();
            }
            case 18: {
                return pSDevSlnPipelineStageBase.isPSDCCodeSnippetNameDirty();
            }
            case 19: {
                return pSDevSlnPipelineStageBase.isPSDevSlnIdDirty();
            }
            case 20: {
                return pSDevSlnPipelineStageBase.isPSDevSlnPipelineIdDirty();
            }
            case 21: {
                return pSDevSlnPipelineStageBase.isPSDevSlnPipelineNameDirty();
            }
            case 22: {
                return pSDevSlnPipelineStageBase.isPSDevSlnPipelineStageIdDirty();
            }
            case 23: {
                return pSDevSlnPipelineStageBase.isPSDevSlnPipelineStageNameDirty();
            }
            case 24: {
                return pSDevSlnPipelineStageBase.isStageParamsDirty();
            }
            case 25: {
                return pSDevSlnPipelineStageBase.isStageTypeDirty();
            }
            case 26: {
                return pSDevSlnPipelineStageBase.isTemplateModeDirty();
            }
            case 27: {
                return pSDevSlnPipelineStageBase.isUpdateDateDirty();
            }
            case 28: {
                return pSDevSlnPipelineStageBase.isUpdateManDirty();
            }
            case 29: {
                return pSDevSlnPipelineStageBase.isUserCatDirty();
            }
            case 30: {
                return pSDevSlnPipelineStageBase.isUserTagDirty();
            }
            case 31: {
                return pSDevSlnPipelineStageBase.isUserTag2Dirty();
            }
            case 32: {
                return pSDevSlnPipelineStageBase.isUserTag3Dirty();
            }
            case 33: {
                return pSDevSlnPipelineStageBase.isUserTag4Dirty();
            }
            case 34: {
                return pSDevSlnPipelineStageBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnPipelineStageBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnPipelineStageBase.getAgentDockerFile() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agentdockerfile", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getAgentDockerFile()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getAgentImage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agentimage", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getAgentImage()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getAgentImageArgs() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agentimageargs", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getAgentImageArgs()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agentpsdcregistryitemid", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agentpsdcregistryitemname", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getAgentReuseMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agentreusemode", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getAgentReuseMode()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getAgentTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agenttags", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getAgentTags()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getAgentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agenttype", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getAgentType()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getCondModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condmodel", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getCondModel()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getCondModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condmodelflag", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getCondModelFlag()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getPostMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"postmode", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getPostMode()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getPSDCCodeSnippetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetid", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getPSDCCodeSnippetId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getPSDCCodeSnippetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetname", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getPSDCCodeSnippetName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getPSDevSlnPipelineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelineid", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getPSDevSlnPipelineId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getPSDevSlnPipelineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinename", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getPSDevSlnPipelineName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinestageid", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageId()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnpipelinestagename", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageName()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getStageParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stageparams", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getStageParams()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getStageType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stagetype", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getStageType()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getTemplateMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templatemode", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getTemplateMode()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDevSlnPipelineStageBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnPipelineStageBase.getJSONValue((Object)pSDevSlnPipelineStageBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnPipelineStageBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnPipelineStageBase.getAgentDockerFile() != null) {
            object = pSDevSlnPipelineStageBase.getAgentDockerFile();
            xmlNode.setAttribute(FIELD_AGENTDOCKERFILE, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnPipelineStageBase.getAgentImage() != null) {
            object = pSDevSlnPipelineStageBase.getAgentImage();
            xmlNode.setAttribute(FIELD_AGENTIMAGE, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnPipelineStageBase.getAgentImageArgs() != null) {
            object = pSDevSlnPipelineStageBase.getAgentImageArgs();
            xmlNode.setAttribute(FIELD_AGENTIMAGEARGS, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemId() != null) {
            object = pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemId();
            xmlNode.setAttribute(FIELD_AGENTPSDCREGISTRYITEMID, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemName() != null) {
            object = pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemName();
            xmlNode.setAttribute(FIELD_AGENTPSDCREGISTRYITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getAgentReuseMode() != null) {
            object = pSDevSlnPipelineStageBase.getAgentReuseMode();
            xmlNode.setAttribute(FIELD_AGENTREUSEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineStageBase.getAgentTags() != null) {
            object = pSDevSlnPipelineStageBase.getAgentTags();
            xmlNode.setAttribute(FIELD_AGENTTAGS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getAgentType() != null) {
            object = pSDevSlnPipelineStageBase.getAgentType();
            xmlNode.setAttribute(FIELD_AGENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getCodeName() != null) {
            object = pSDevSlnPipelineStageBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getCondModel() != null) {
            object = pSDevSlnPipelineStageBase.getCondModel();
            xmlNode.setAttribute(FIELD_CONDMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getCondModelFlag() != null) {
            object = pSDevSlnPipelineStageBase.getCondModelFlag();
            xmlNode.setAttribute(FIELD_CONDMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineStageBase.getCreateDate() != null) {
            object = pSDevSlnPipelineStageBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnPipelineStageBase.getCreateMan() != null) {
            object = pSDevSlnPipelineStageBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getCustomCode() != null) {
            object = pSDevSlnPipelineStageBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getMemo() != null) {
            object = pSDevSlnPipelineStageBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getOrderValue() != null) {
            object = pSDevSlnPipelineStageBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineStageBase.getPostMode() != null) {
            object = pSDevSlnPipelineStageBase.getPostMode();
            xmlNode.setAttribute(FIELD_POSTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getPSDCCodeSnippetId() != null) {
            object = pSDevSlnPipelineStageBase.getPSDCCodeSnippetId();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getPSDCCodeSnippetName() != null) {
            object = pSDevSlnPipelineStageBase.getPSDCCodeSnippetName();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getPSDevSlnId() != null) {
            object = pSDevSlnPipelineStageBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getPSDevSlnPipelineId() != null) {
            object = pSDevSlnPipelineStageBase.getPSDevSlnPipelineId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getPSDevSlnPipelineName() != null) {
            object = pSDevSlnPipelineStageBase.getPSDevSlnPipelineName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageId() != null) {
            object = pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageId();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINESTAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageName() != null) {
            object = pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageName();
            xmlNode.setAttribute(FIELD_PSDEVSLNPIPELINESTAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getStageParams() != null) {
            object = pSDevSlnPipelineStageBase.getStageParams();
            xmlNode.setAttribute(FIELD_STAGEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getStageType() != null) {
            object = pSDevSlnPipelineStageBase.getStageType();
            xmlNode.setAttribute(FIELD_STAGETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getTemplateMode() != null) {
            object = pSDevSlnPipelineStageBase.getTemplateMode();
            xmlNode.setAttribute(FIELD_TEMPLATEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnPipelineStageBase.getUpdateDate() != null) {
            object = pSDevSlnPipelineStageBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnPipelineStageBase.getUpdateMan() != null) {
            object = pSDevSlnPipelineStageBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getUserCat() != null) {
            object = pSDevSlnPipelineStageBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getUserTag() != null) {
            object = pSDevSlnPipelineStageBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getUserTag2() != null) {
            object = pSDevSlnPipelineStageBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getUserTag3() != null) {
            object = pSDevSlnPipelineStageBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getUserTag4() != null) {
            object = pSDevSlnPipelineStageBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnPipelineStageBase.getValidFlag() != null) {
            object = pSDevSlnPipelineStageBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnPipelineStageBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnPipelineStageBase.isAgentDockerFileDirty() && (bl || pSDevSlnPipelineStageBase.getAgentDockerFile() != null)) {
            iDataObject.set(FIELD_AGENTDOCKERFILE, (Object)pSDevSlnPipelineStageBase.getAgentDockerFile());
        }
        if (pSDevSlnPipelineStageBase.isAgentImageDirty() && (bl || pSDevSlnPipelineStageBase.getAgentImage() != null)) {
            iDataObject.set(FIELD_AGENTIMAGE, (Object)pSDevSlnPipelineStageBase.getAgentImage());
        }
        if (pSDevSlnPipelineStageBase.isAgentImageArgsDirty() && (bl || pSDevSlnPipelineStageBase.getAgentImageArgs() != null)) {
            iDataObject.set(FIELD_AGENTIMAGEARGS, (Object)pSDevSlnPipelineStageBase.getAgentImageArgs());
        }
        if (pSDevSlnPipelineStageBase.isAgentPSDCRegistryItemIdDirty() && (bl || pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemId() != null)) {
            iDataObject.set(FIELD_AGENTPSDCREGISTRYITEMID, (Object)pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemId());
        }
        if (pSDevSlnPipelineStageBase.isAgentPSDCRegistryItemNameDirty() && (bl || pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemName() != null)) {
            iDataObject.set(FIELD_AGENTPSDCREGISTRYITEMNAME, (Object)pSDevSlnPipelineStageBase.getAgentPSDCRegistryItemName());
        }
        if (pSDevSlnPipelineStageBase.isAgentReuseModeDirty() && (bl || pSDevSlnPipelineStageBase.getAgentReuseMode() != null)) {
            iDataObject.set(FIELD_AGENTREUSEMODE, (Object)pSDevSlnPipelineStageBase.getAgentReuseMode());
        }
        if (pSDevSlnPipelineStageBase.isAgentTagsDirty() && (bl || pSDevSlnPipelineStageBase.getAgentTags() != null)) {
            iDataObject.set(FIELD_AGENTTAGS, (Object)pSDevSlnPipelineStageBase.getAgentTags());
        }
        if (pSDevSlnPipelineStageBase.isAgentTypeDirty() && (bl || pSDevSlnPipelineStageBase.getAgentType() != null)) {
            iDataObject.set(FIELD_AGENTTYPE, (Object)pSDevSlnPipelineStageBase.getAgentType());
        }
        if (pSDevSlnPipelineStageBase.isCodeNameDirty() && (bl || pSDevSlnPipelineStageBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDevSlnPipelineStageBase.getCodeName());
        }
        if (pSDevSlnPipelineStageBase.isCondModelDirty() && (bl || pSDevSlnPipelineStageBase.getCondModel() != null)) {
            iDataObject.set(FIELD_CONDMODEL, (Object)pSDevSlnPipelineStageBase.getCondModel());
        }
        if (pSDevSlnPipelineStageBase.isCondModelFlagDirty() && (bl || pSDevSlnPipelineStageBase.getCondModelFlag() != null)) {
            iDataObject.set(FIELD_CONDMODELFLAG, (Object)pSDevSlnPipelineStageBase.getCondModelFlag());
        }
        if (pSDevSlnPipelineStageBase.isCreateDateDirty() && (bl || pSDevSlnPipelineStageBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnPipelineStageBase.getCreateDate());
        }
        if (pSDevSlnPipelineStageBase.isCreateManDirty() && (bl || pSDevSlnPipelineStageBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnPipelineStageBase.getCreateMan());
        }
        if (pSDevSlnPipelineStageBase.isCustomCodeDirty() && (bl || pSDevSlnPipelineStageBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDevSlnPipelineStageBase.getCustomCode());
        }
        if (pSDevSlnPipelineStageBase.isMemoDirty() && (bl || pSDevSlnPipelineStageBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnPipelineStageBase.getMemo());
        }
        if (pSDevSlnPipelineStageBase.isOrderValueDirty() && (bl || pSDevSlnPipelineStageBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDevSlnPipelineStageBase.getOrderValue());
        }
        if (pSDevSlnPipelineStageBase.isPostModeDirty() && (bl || pSDevSlnPipelineStageBase.getPostMode() != null)) {
            iDataObject.set(FIELD_POSTMODE, (Object)pSDevSlnPipelineStageBase.getPostMode());
        }
        if (pSDevSlnPipelineStageBase.isPSDCCodeSnippetIdDirty() && (bl || pSDevSlnPipelineStageBase.getPSDCCodeSnippetId() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETID, (Object)pSDevSlnPipelineStageBase.getPSDCCodeSnippetId());
        }
        if (pSDevSlnPipelineStageBase.isPSDCCodeSnippetNameDirty() && (bl || pSDevSlnPipelineStageBase.getPSDCCodeSnippetName() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETNAME, (Object)pSDevSlnPipelineStageBase.getPSDCCodeSnippetName());
        }
        if (pSDevSlnPipelineStageBase.isPSDevSlnIdDirty() && (bl || pSDevSlnPipelineStageBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnPipelineStageBase.getPSDevSlnId());
        }
        if (pSDevSlnPipelineStageBase.isPSDevSlnPipelineIdDirty() && (bl || pSDevSlnPipelineStageBase.getPSDevSlnPipelineId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINEID, (Object)pSDevSlnPipelineStageBase.getPSDevSlnPipelineId());
        }
        if (pSDevSlnPipelineStageBase.isPSDevSlnPipelineNameDirty() && (bl || pSDevSlnPipelineStageBase.getPSDevSlnPipelineName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINENAME, (Object)pSDevSlnPipelineStageBase.getPSDevSlnPipelineName());
        }
        if (pSDevSlnPipelineStageBase.isPSDevSlnPipelineStageIdDirty() && (bl || pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINESTAGEID, (Object)pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageId());
        }
        if (pSDevSlnPipelineStageBase.isPSDevSlnPipelineStageNameDirty() && (bl || pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNPIPELINESTAGENAME, (Object)pSDevSlnPipelineStageBase.getPSDevSlnPipelineStageName());
        }
        if (pSDevSlnPipelineStageBase.isStageParamsDirty() && (bl || pSDevSlnPipelineStageBase.getStageParams() != null)) {
            iDataObject.set(FIELD_STAGEPARAMS, (Object)pSDevSlnPipelineStageBase.getStageParams());
        }
        if (pSDevSlnPipelineStageBase.isStageTypeDirty() && (bl || pSDevSlnPipelineStageBase.getStageType() != null)) {
            iDataObject.set(FIELD_STAGETYPE, (Object)pSDevSlnPipelineStageBase.getStageType());
        }
        if (pSDevSlnPipelineStageBase.isTemplateModeDirty() && (bl || pSDevSlnPipelineStageBase.getTemplateMode() != null)) {
            iDataObject.set(FIELD_TEMPLATEMODE, (Object)pSDevSlnPipelineStageBase.getTemplateMode());
        }
        if (pSDevSlnPipelineStageBase.isUpdateDateDirty() && (bl || pSDevSlnPipelineStageBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnPipelineStageBase.getUpdateDate());
        }
        if (pSDevSlnPipelineStageBase.isUpdateManDirty() && (bl || pSDevSlnPipelineStageBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnPipelineStageBase.getUpdateMan());
        }
        if (pSDevSlnPipelineStageBase.isUserCatDirty() && (bl || pSDevSlnPipelineStageBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDevSlnPipelineStageBase.getUserCat());
        }
        if (pSDevSlnPipelineStageBase.isUserTagDirty() && (bl || pSDevSlnPipelineStageBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevSlnPipelineStageBase.getUserTag());
        }
        if (pSDevSlnPipelineStageBase.isUserTag2Dirty() && (bl || pSDevSlnPipelineStageBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevSlnPipelineStageBase.getUserTag2());
        }
        if (pSDevSlnPipelineStageBase.isUserTag3Dirty() && (bl || pSDevSlnPipelineStageBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevSlnPipelineStageBase.getUserTag3());
        }
        if (pSDevSlnPipelineStageBase.isUserTag4Dirty() && (bl || pSDevSlnPipelineStageBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevSlnPipelineStageBase.getUserTag4());
        }
        if (pSDevSlnPipelineStageBase.isValidFlagDirty() && (bl || pSDevSlnPipelineStageBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnPipelineStageBase.getValidFlag());
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
        return PSDevSlnPipelineStageBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnPipelineStageBase pSDevSlnPipelineStageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnPipelineStageBase.resetAgentDockerFile();
                return true;
            }
            case 1: {
                pSDevSlnPipelineStageBase.resetAgentImage();
                return true;
            }
            case 2: {
                pSDevSlnPipelineStageBase.resetAgentImageArgs();
                return true;
            }
            case 3: {
                pSDevSlnPipelineStageBase.resetAgentPSDCRegistryItemId();
                return true;
            }
            case 4: {
                pSDevSlnPipelineStageBase.resetAgentPSDCRegistryItemName();
                return true;
            }
            case 5: {
                pSDevSlnPipelineStageBase.resetAgentReuseMode();
                return true;
            }
            case 6: {
                pSDevSlnPipelineStageBase.resetAgentTags();
                return true;
            }
            case 7: {
                pSDevSlnPipelineStageBase.resetAgentType();
                return true;
            }
            case 8: {
                pSDevSlnPipelineStageBase.resetCodeName();
                return true;
            }
            case 9: {
                pSDevSlnPipelineStageBase.resetCondModel();
                return true;
            }
            case 10: {
                pSDevSlnPipelineStageBase.resetCondModelFlag();
                return true;
            }
            case 11: {
                pSDevSlnPipelineStageBase.resetCreateDate();
                return true;
            }
            case 12: {
                pSDevSlnPipelineStageBase.resetCreateMan();
                return true;
            }
            case 13: {
                pSDevSlnPipelineStageBase.resetCustomCode();
                return true;
            }
            case 14: {
                pSDevSlnPipelineStageBase.resetMemo();
                return true;
            }
            case 15: {
                pSDevSlnPipelineStageBase.resetOrderValue();
                return true;
            }
            case 16: {
                pSDevSlnPipelineStageBase.resetPostMode();
                return true;
            }
            case 17: {
                pSDevSlnPipelineStageBase.resetPSDCCodeSnippetId();
                return true;
            }
            case 18: {
                pSDevSlnPipelineStageBase.resetPSDCCodeSnippetName();
                return true;
            }
            case 19: {
                pSDevSlnPipelineStageBase.resetPSDevSlnId();
                return true;
            }
            case 20: {
                pSDevSlnPipelineStageBase.resetPSDevSlnPipelineId();
                return true;
            }
            case 21: {
                pSDevSlnPipelineStageBase.resetPSDevSlnPipelineName();
                return true;
            }
            case 22: {
                pSDevSlnPipelineStageBase.resetPSDevSlnPipelineStageId();
                return true;
            }
            case 23: {
                pSDevSlnPipelineStageBase.resetPSDevSlnPipelineStageName();
                return true;
            }
            case 24: {
                pSDevSlnPipelineStageBase.resetStageParams();
                return true;
            }
            case 25: {
                pSDevSlnPipelineStageBase.resetStageType();
                return true;
            }
            case 26: {
                pSDevSlnPipelineStageBase.resetTemplateMode();
                return true;
            }
            case 27: {
                pSDevSlnPipelineStageBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSDevSlnPipelineStageBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSDevSlnPipelineStageBase.resetUserCat();
                return true;
            }
            case 30: {
                pSDevSlnPipelineStageBase.resetUserTag();
                return true;
            }
            case 31: {
                pSDevSlnPipelineStageBase.resetUserTag2();
                return true;
            }
            case 32: {
                pSDevSlnPipelineStageBase.resetUserTag3();
                return true;
            }
            case 33: {
                pSDevSlnPipelineStageBase.resetUserTag4();
                return true;
            }
            case 34: {
                pSDevSlnPipelineStageBase.resetValidFlag();
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
                pSDCCodeSnippetService.autoGet(pSDCCodeSnippet);
                this.psdccodesnippet = pSDCCodeSnippet;
            }
            return this.psdccodesnippet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCRegistryItem getAgentPSDCRegistryItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentPSDCRegistryItem();
        }
        if (this.getAgentPSDCRegistryItemId() == null) {
            return null;
        }
        Integer n = this.objAgentPSDCRegistryItemLock;
        synchronized (n) {
            if (this.agentpsdcregistryitem != null && DataTypeHelper.compare((int)25, (Object)this.getAgentPSDCRegistryItemId(), (Object)this.agentpsdcregistryitem.getPSDCRegistryItemId()) != 0L) {
                this.agentpsdcregistryitem = null;
            }
            if (this.agentpsdcregistryitem == null) {
                PSDCRegistryItem pSDCRegistryItem = new PSDCRegistryItem();
                pSDCRegistryItem.setPSDCRegistryItemId(this.getAgentPSDCRegistryItemId());
                PSDCRegistryItemService pSDCRegistryItemService = (PSDCRegistryItemService)ServiceGlobal.getService(PSDCRegistryItemService.class, (SessionFactory)this.getSessionFactory());
                pSDCRegistryItemService.autoGet(pSDCRegistryItem);
                this.agentpsdcregistryitem = pSDCRegistryItem;
            }
            return this.agentpsdcregistryitem;
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
    public ArrayList<PSDevSlnPipelineStep> getPSDevSlnPipelineSteps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnPipelineSteps();
        }
        if (this.getPSDevSlnPipelineStageId() == null) {
            return null;
        }
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnPipelineStepsLock;
        synchronized (n) {
            if (this.psdevslnpipelinesteps == null) {
                this.psdevslnpipelinesteps = pSDevSlnPipelineStepService.selectByPSDevSlnPipelineStage(this);
            }
            return this.psdevslnpipelinesteps;
        }
    }

    private PSDevSlnPipelineStageBase getProxyEntity() {
        return this.proxyPSDevSlnPipelineStageBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnPipelineStageBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnPipelineStageBase) {
            this.proxyPSDevSlnPipelineStageBase = (PSDevSlnPipelineStageBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStageService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AGENTDOCKERFILE, 0);
        fieldIndexMap.put(FIELD_AGENTIMAGE, 1);
        fieldIndexMap.put(FIELD_AGENTIMAGEARGS, 2);
        fieldIndexMap.put(FIELD_AGENTPSDCREGISTRYITEMID, 3);
        fieldIndexMap.put(FIELD_AGENTPSDCREGISTRYITEMNAME, 4);
        fieldIndexMap.put(FIELD_AGENTREUSEMODE, 5);
        fieldIndexMap.put(FIELD_AGENTTAGS, 6);
        fieldIndexMap.put(FIELD_AGENTTYPE, 7);
        fieldIndexMap.put(FIELD_CODENAME, 8);
        fieldIndexMap.put(FIELD_CONDMODEL, 9);
        fieldIndexMap.put(FIELD_CONDMODELFLAG, 10);
        fieldIndexMap.put(FIELD_CREATEDATE, 11);
        fieldIndexMap.put(FIELD_CREATEMAN, 12);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_ORDERVALUE, 15);
        fieldIndexMap.put(FIELD_POSTMODE, 16);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETID, 17);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETNAME, 18);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 19);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINEID, 20);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINENAME, 21);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINESTAGEID, 22);
        fieldIndexMap.put(FIELD_PSDEVSLNPIPELINESTAGENAME, 23);
        fieldIndexMap.put(FIELD_STAGEPARAMS, 24);
        fieldIndexMap.put(FIELD_STAGETYPE, 25);
        fieldIndexMap.put(FIELD_TEMPLATEMODE, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_USERCAT, 29);
        fieldIndexMap.put(FIELD_USERTAG, 30);
        fieldIndexMap.put(FIELD_USERTAG2, 31);
        fieldIndexMap.put(FIELD_USERTAG3, 32);
        fieldIndexMap.put(FIELD_USERTAG4, 33);
        fieldIndexMap.put(FIELD_VALIDFLAG, 34);
    }
}

