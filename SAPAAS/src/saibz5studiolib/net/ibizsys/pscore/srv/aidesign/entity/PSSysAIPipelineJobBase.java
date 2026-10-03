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
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIWorkerAgent;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineAgentService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIWorkerAgentService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysAIPipelineJobBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysAIPipelineJobBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_JOBPARAMS = "JOBPARAMS";
    public static final String FIELD_JOBTAG = "JOBTAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSAIFACTORYID = "PSSYSAIFACTORYID";
    public static final String FIELD_PSSYSAIFACTORYNAME = "PSSYSAIFACTORYNAME";
    public static final String FIELD_PSSYSAIPIPELINEAGENTID = "PSSYSAIPIPELINEAGENTID";
    public static final String FIELD_PSSYSAIPIPELINEAGENTNAME = "PSSYSAIPIPELINEAGENTNAME";
    public static final String FIELD_PSSYSAIPIPELINEJOBID = "PSSYSAIPIPELINEJOBID";
    public static final String FIELD_PSSYSAIPIPELINEJOBNAME = "PSSYSAIPIPELINEJOBNAME";
    public static final String FIELD_PSSYSAIWORKERAGENTID = "PSSYSAIWORKERAGENTID";
    public static final String FIELD_PSSYSAIWORKERAGENTNAME = "PSSYSAIWORKERAGENTNAME";
    public static final String FIELD_STEPPSCODELISTID = "STEPPSCODELISTID";
    public static final String FIELD_STEPPSCODELISTNAME = "STEPPSCODELISTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_JOBPARAMS = 2;
    private static final int INDEX_JOBTAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSDEDATASETID = 6;
    private static final int INDEX_PSDEDATASETNAME = 7;
    private static final int INDEX_PSDEID = 8;
    private static final int INDEX_PSSYSAIFACTORYID = 9;
    private static final int INDEX_PSSYSAIFACTORYNAME = 10;
    private static final int INDEX_PSSYSAIPIPELINEAGENTID = 11;
    private static final int INDEX_PSSYSAIPIPELINEAGENTNAME = 12;
    private static final int INDEX_PSSYSAIPIPELINEJOBID = 13;
    private static final int INDEX_PSSYSAIPIPELINEJOBNAME = 14;
    private static final int INDEX_PSSYSAIWORKERAGENTID = 15;
    private static final int INDEX_PSSYSAIWORKERAGENTNAME = 16;
    private static final int INDEX_STEPPSCODELISTID = 17;
    private static final int INDEX_STEPPSCODELISTNAME = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final int INDEX_USERTAG3 = 24;
    private static final int INDEX_USERTAG4 = 25;
    private static final int INDEX_VALIDFLAG = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysAIPipelineJobBase proxyPSSysAIPipelineJobBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean jobparamsDirtyFlag = false;
    private boolean jobtagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssysaifactoryidDirtyFlag = false;
    private boolean pssysaifactorynameDirtyFlag = false;
    private boolean pssysaipipelineagentidDirtyFlag = false;
    private boolean pssysaipipelineagentnameDirtyFlag = false;
    private boolean pssysaipipelinejobidDirtyFlag = false;
    private boolean pssysaipipelinejobnameDirtyFlag = false;
    private boolean pssysaiworkeragentidDirtyFlag = false;
    private boolean pssysaiworkeragentnameDirtyFlag = false;
    private boolean steppscodelistidDirtyFlag = false;
    private boolean steppscodelistnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="jobparams")
    private String jobparams;
    @Column(name="jobtag")
    private String jobtag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssysaifactoryid")
    private String pssysaifactoryid;
    @Column(name="pssysaifactoryname")
    private String pssysaifactoryname;
    @Column(name="pssysaipipelineagentid")
    private String pssysaipipelineagentid;
    @Column(name="pssysaipipelineagentname")
    private String pssysaipipelineagentname;
    @Column(name="pssysaipipelinejobid")
    private String pssysaipipelinejobid;
    @Column(name="pssysaipipelinejobname")
    private String pssysaipipelinejobname;
    @Column(name="pssysaiworkeragentid")
    private String pssysaiworkeragentid;
    @Column(name="pssysaiworkeragentname")
    private String pssysaiworkeragentname;
    @Column(name="steppscodelistid")
    private String steppscodelistid;
    @Column(name="steppscodelistname")
    private String steppscodelistname;
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
    private Integer objStepPSCodeListLock = new Integer(1);
    private PSCodeList steppscodelist = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objPSSysAIFactoryLock = new Integer(1);
    private PSSysAIFactory pssysaifactory = null;
    private Integer objPSSysAIPipelineAgentLock = new Integer(1);
    private PSSysAIPipelineAgent pssysaipipelineagent = null;
    private Integer objPSSysAIWorkerAgentLock = new Integer(1);
    private PSSysAIWorkerAgent pssysaiworkeragent = null;

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

    public void setJobParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJobParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jobparams = string;
        this.jobparamsDirtyFlag = true;
    }

    public String getJobParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJobParams();
        }
        return this.jobparams;
    }

    public boolean isJobParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJobParamsDirty();
        }
        return this.jobparamsDirtyFlag;
    }

    public void resetJobParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJobParams();
            return;
        }
        this.jobparamsDirtyFlag = false;
        this.jobparams = null;
    }

    public void setJobTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJobTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jobtag = string;
        this.jobtagDirtyFlag = true;
    }

    public String getJobTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJobTag();
        }
        return this.jobtag;
    }

    public boolean isJobTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJobTagDirty();
        }
        return this.jobtagDirtyFlag;
    }

    public void resetJobTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJobTag();
            return;
        }
        this.jobtagDirtyFlag = false;
        this.jobtag = null;
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

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
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

    public void setPSSysAIPipelineJobId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIPipelineJobId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaipipelinejobid = string;
        this.pssysaipipelinejobidDirtyFlag = true;
    }

    public String getPSSysAIPipelineJobId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIPipelineJobId();
        }
        return this.pssysaipipelinejobid;
    }

    public boolean isPSSysAIPipelineJobIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIPipelineJobIdDirty();
        }
        return this.pssysaipipelinejobidDirtyFlag;
    }

    public void resetPSSysAIPipelineJobId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIPipelineJobId();
            return;
        }
        this.pssysaipipelinejobidDirtyFlag = false;
        this.pssysaipipelinejobid = null;
    }

    public void setPSSysAIPipelineJobName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIPipelineJobName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaipipelinejobname = string;
        this.pssysaipipelinejobnameDirtyFlag = true;
    }

    public String getPSSysAIPipelineJobName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIPipelineJobName();
        }
        return this.pssysaipipelinejobname;
    }

    public boolean isPSSysAIPipelineJobNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIPipelineJobNameDirty();
        }
        return this.pssysaipipelinejobnameDirtyFlag;
    }

    public void resetPSSysAIPipelineJobName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIPipelineJobName();
            return;
        }
        this.pssysaipipelinejobnameDirtyFlag = false;
        this.pssysaipipelinejobname = null;
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

    public void setStepPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStepPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.steppscodelistid = string;
        this.steppscodelistidDirtyFlag = true;
    }

    public String getStepPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStepPSCodeListId();
        }
        return this.steppscodelistid;
    }

    public boolean isStepPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStepPSCodeListIdDirty();
        }
        return this.steppscodelistidDirtyFlag;
    }

    public void resetStepPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStepPSCodeListId();
            return;
        }
        this.steppscodelistidDirtyFlag = false;
        this.steppscodelistid = null;
    }

    public void setStepPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStepPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.steppscodelistname = string;
        this.steppscodelistnameDirtyFlag = true;
    }

    public String getStepPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStepPSCodeListName();
        }
        return this.steppscodelistname;
    }

    public boolean isStepPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStepPSCodeListNameDirty();
        }
        return this.steppscodelistnameDirtyFlag;
    }

    public void resetStepPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStepPSCodeListName();
            return;
        }
        this.steppscodelistnameDirtyFlag = false;
        this.steppscodelistname = null;
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
        PSSysAIPipelineJobBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysAIPipelineJobBase pSSysAIPipelineJobBase) {
        pSSysAIPipelineJobBase.resetCreateDate();
        pSSysAIPipelineJobBase.resetCreateMan();
        pSSysAIPipelineJobBase.resetJobParams();
        pSSysAIPipelineJobBase.resetJobTag();
        pSSysAIPipelineJobBase.resetMemo();
        pSSysAIPipelineJobBase.resetOrderValue();
        pSSysAIPipelineJobBase.resetPSDEDataSetId();
        pSSysAIPipelineJobBase.resetPSDEDataSetName();
        pSSysAIPipelineJobBase.resetPSDEId();
        pSSysAIPipelineJobBase.resetPSSysAIFactoryId();
        pSSysAIPipelineJobBase.resetPSSysAIFactoryName();
        pSSysAIPipelineJobBase.resetPSSysAIPipelineAgentId();
        pSSysAIPipelineJobBase.resetPSSysAIPipelineAgentName();
        pSSysAIPipelineJobBase.resetPSSysAIPipelineJobId();
        pSSysAIPipelineJobBase.resetPSSysAIPipelineJobName();
        pSSysAIPipelineJobBase.resetPSSysAIWorkerAgentId();
        pSSysAIPipelineJobBase.resetPSSysAIWorkerAgentName();
        pSSysAIPipelineJobBase.resetStepPSCodeListId();
        pSSysAIPipelineJobBase.resetStepPSCodeListName();
        pSSysAIPipelineJobBase.resetUpdateDate();
        pSSysAIPipelineJobBase.resetUpdateMan();
        pSSysAIPipelineJobBase.resetUserCat();
        pSSysAIPipelineJobBase.resetUserTag();
        pSSysAIPipelineJobBase.resetUserTag2();
        pSSysAIPipelineJobBase.resetUserTag3();
        pSSysAIPipelineJobBase.resetUserTag4();
        pSSysAIPipelineJobBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isJobParamsDirty()) {
            hashMap.put(FIELD_JOBPARAMS, this.getJobParams());
        }
        if (!bl || this.isJobTagDirty()) {
            hashMap.put(FIELD_JOBTAG, this.getJobTag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
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
        if (!bl || this.isPSSysAIPipelineJobIdDirty()) {
            hashMap.put(FIELD_PSSYSAIPIPELINEJOBID, this.getPSSysAIPipelineJobId());
        }
        if (!bl || this.isPSSysAIPipelineJobNameDirty()) {
            hashMap.put(FIELD_PSSYSAIPIPELINEJOBNAME, this.getPSSysAIPipelineJobName());
        }
        if (!bl || this.isPSSysAIWorkerAgentIdDirty()) {
            hashMap.put(FIELD_PSSYSAIWORKERAGENTID, this.getPSSysAIWorkerAgentId());
        }
        if (!bl || this.isPSSysAIWorkerAgentNameDirty()) {
            hashMap.put(FIELD_PSSYSAIWORKERAGENTNAME, this.getPSSysAIWorkerAgentName());
        }
        if (!bl || this.isStepPSCodeListIdDirty()) {
            hashMap.put(FIELD_STEPPSCODELISTID, this.getStepPSCodeListId());
        }
        if (!bl || this.isStepPSCodeListNameDirty()) {
            hashMap.put(FIELD_STEPPSCODELISTNAME, this.getStepPSCodeListName());
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
        return PSSysAIPipelineJobBase.get(this, n);
    }

    private static Object get(PSSysAIPipelineJobBase pSSysAIPipelineJobBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIPipelineJobBase.getCreateDate();
            }
            case 1: {
                return pSSysAIPipelineJobBase.getCreateMan();
            }
            case 2: {
                return pSSysAIPipelineJobBase.getJobParams();
            }
            case 3: {
                return pSSysAIPipelineJobBase.getJobTag();
            }
            case 4: {
                return pSSysAIPipelineJobBase.getMemo();
            }
            case 5: {
                return pSSysAIPipelineJobBase.getOrderValue();
            }
            case 6: {
                return pSSysAIPipelineJobBase.getPSDEDataSetId();
            }
            case 7: {
                return pSSysAIPipelineJobBase.getPSDEDataSetName();
            }
            case 8: {
                return pSSysAIPipelineJobBase.getPSDEId();
            }
            case 9: {
                return pSSysAIPipelineJobBase.getPSSysAIFactoryId();
            }
            case 10: {
                return pSSysAIPipelineJobBase.getPSSysAIFactoryName();
            }
            case 11: {
                return pSSysAIPipelineJobBase.getPSSysAIPipelineAgentId();
            }
            case 12: {
                return pSSysAIPipelineJobBase.getPSSysAIPipelineAgentName();
            }
            case 13: {
                return pSSysAIPipelineJobBase.getPSSysAIPipelineJobId();
            }
            case 14: {
                return pSSysAIPipelineJobBase.getPSSysAIPipelineJobName();
            }
            case 15: {
                return pSSysAIPipelineJobBase.getPSSysAIWorkerAgentId();
            }
            case 16: {
                return pSSysAIPipelineJobBase.getPSSysAIWorkerAgentName();
            }
            case 17: {
                return pSSysAIPipelineJobBase.getStepPSCodeListId();
            }
            case 18: {
                return pSSysAIPipelineJobBase.getStepPSCodeListName();
            }
            case 19: {
                return pSSysAIPipelineJobBase.getUpdateDate();
            }
            case 20: {
                return pSSysAIPipelineJobBase.getUpdateMan();
            }
            case 21: {
                return pSSysAIPipelineJobBase.getUserCat();
            }
            case 22: {
                return pSSysAIPipelineJobBase.getUserTag();
            }
            case 23: {
                return pSSysAIPipelineJobBase.getUserTag2();
            }
            case 24: {
                return pSSysAIPipelineJobBase.getUserTag3();
            }
            case 25: {
                return pSSysAIPipelineJobBase.getUserTag4();
            }
            case 26: {
                return pSSysAIPipelineJobBase.getValidFlag();
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
        PSSysAIPipelineJobBase.set(this, n, object);
    }

    private static void set(PSSysAIPipelineJobBase pSSysAIPipelineJobBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysAIPipelineJobBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysAIPipelineJobBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysAIPipelineJobBase.setJobParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysAIPipelineJobBase.setJobTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysAIPipelineJobBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysAIPipelineJobBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysAIPipelineJobBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysAIPipelineJobBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysAIPipelineJobBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysAIPipelineJobBase.setPSSysAIFactoryId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysAIPipelineJobBase.setPSSysAIFactoryName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysAIPipelineJobBase.setPSSysAIPipelineAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysAIPipelineJobBase.setPSSysAIPipelineAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysAIPipelineJobBase.setPSSysAIPipelineJobId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysAIPipelineJobBase.setPSSysAIPipelineJobName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysAIPipelineJobBase.setPSSysAIWorkerAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysAIPipelineJobBase.setPSSysAIWorkerAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysAIPipelineJobBase.setStepPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysAIPipelineJobBase.setStepPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysAIPipelineJobBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSSysAIPipelineJobBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysAIPipelineJobBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysAIPipelineJobBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysAIPipelineJobBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysAIPipelineJobBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysAIPipelineJobBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysAIPipelineJobBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysAIPipelineJobBase.isNull(this, n);
    }

    private static boolean isNull(PSSysAIPipelineJobBase pSSysAIPipelineJobBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIPipelineJobBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysAIPipelineJobBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysAIPipelineJobBase.getJobParams() == null;
            }
            case 3: {
                return pSSysAIPipelineJobBase.getJobTag() == null;
            }
            case 4: {
                return pSSysAIPipelineJobBase.getMemo() == null;
            }
            case 5: {
                return pSSysAIPipelineJobBase.getOrderValue() == null;
            }
            case 6: {
                return pSSysAIPipelineJobBase.getPSDEDataSetId() == null;
            }
            case 7: {
                return pSSysAIPipelineJobBase.getPSDEDataSetName() == null;
            }
            case 8: {
                return pSSysAIPipelineJobBase.getPSDEId() == null;
            }
            case 9: {
                return pSSysAIPipelineJobBase.getPSSysAIFactoryId() == null;
            }
            case 10: {
                return pSSysAIPipelineJobBase.getPSSysAIFactoryName() == null;
            }
            case 11: {
                return pSSysAIPipelineJobBase.getPSSysAIPipelineAgentId() == null;
            }
            case 12: {
                return pSSysAIPipelineJobBase.getPSSysAIPipelineAgentName() == null;
            }
            case 13: {
                return pSSysAIPipelineJobBase.getPSSysAIPipelineJobId() == null;
            }
            case 14: {
                return pSSysAIPipelineJobBase.getPSSysAIPipelineJobName() == null;
            }
            case 15: {
                return pSSysAIPipelineJobBase.getPSSysAIWorkerAgentId() == null;
            }
            case 16: {
                return pSSysAIPipelineJobBase.getPSSysAIWorkerAgentName() == null;
            }
            case 17: {
                return pSSysAIPipelineJobBase.getStepPSCodeListId() == null;
            }
            case 18: {
                return pSSysAIPipelineJobBase.getStepPSCodeListName() == null;
            }
            case 19: {
                return pSSysAIPipelineJobBase.getUpdateDate() == null;
            }
            case 20: {
                return pSSysAIPipelineJobBase.getUpdateMan() == null;
            }
            case 21: {
                return pSSysAIPipelineJobBase.getUserCat() == null;
            }
            case 22: {
                return pSSysAIPipelineJobBase.getUserTag() == null;
            }
            case 23: {
                return pSSysAIPipelineJobBase.getUserTag2() == null;
            }
            case 24: {
                return pSSysAIPipelineJobBase.getUserTag3() == null;
            }
            case 25: {
                return pSSysAIPipelineJobBase.getUserTag4() == null;
            }
            case 26: {
                return pSSysAIPipelineJobBase.getValidFlag() == null;
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
        return PSSysAIPipelineJobBase.contains(this, n);
    }

    private static boolean contains(PSSysAIPipelineJobBase pSSysAIPipelineJobBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIPipelineJobBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysAIPipelineJobBase.isCreateManDirty();
            }
            case 2: {
                return pSSysAIPipelineJobBase.isJobParamsDirty();
            }
            case 3: {
                return pSSysAIPipelineJobBase.isJobTagDirty();
            }
            case 4: {
                return pSSysAIPipelineJobBase.isMemoDirty();
            }
            case 5: {
                return pSSysAIPipelineJobBase.isOrderValueDirty();
            }
            case 6: {
                return pSSysAIPipelineJobBase.isPSDEDataSetIdDirty();
            }
            case 7: {
                return pSSysAIPipelineJobBase.isPSDEDataSetNameDirty();
            }
            case 8: {
                return pSSysAIPipelineJobBase.isPSDEIdDirty();
            }
            case 9: {
                return pSSysAIPipelineJobBase.isPSSysAIFactoryIdDirty();
            }
            case 10: {
                return pSSysAIPipelineJobBase.isPSSysAIFactoryNameDirty();
            }
            case 11: {
                return pSSysAIPipelineJobBase.isPSSysAIPipelineAgentIdDirty();
            }
            case 12: {
                return pSSysAIPipelineJobBase.isPSSysAIPipelineAgentNameDirty();
            }
            case 13: {
                return pSSysAIPipelineJobBase.isPSSysAIPipelineJobIdDirty();
            }
            case 14: {
                return pSSysAIPipelineJobBase.isPSSysAIPipelineJobNameDirty();
            }
            case 15: {
                return pSSysAIPipelineJobBase.isPSSysAIWorkerAgentIdDirty();
            }
            case 16: {
                return pSSysAIPipelineJobBase.isPSSysAIWorkerAgentNameDirty();
            }
            case 17: {
                return pSSysAIPipelineJobBase.isStepPSCodeListIdDirty();
            }
            case 18: {
                return pSSysAIPipelineJobBase.isStepPSCodeListNameDirty();
            }
            case 19: {
                return pSSysAIPipelineJobBase.isUpdateDateDirty();
            }
            case 20: {
                return pSSysAIPipelineJobBase.isUpdateManDirty();
            }
            case 21: {
                return pSSysAIPipelineJobBase.isUserCatDirty();
            }
            case 22: {
                return pSSysAIPipelineJobBase.isUserTagDirty();
            }
            case 23: {
                return pSSysAIPipelineJobBase.isUserTag2Dirty();
            }
            case 24: {
                return pSSysAIPipelineJobBase.isUserTag3Dirty();
            }
            case 25: {
                return pSSysAIPipelineJobBase.isUserTag4Dirty();
            }
            case 26: {
                return pSSysAIPipelineJobBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysAIPipelineJobBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysAIPipelineJobBase pSSysAIPipelineJobBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysAIPipelineJobBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getJobParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jobparams", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getJobParams()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getJobTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jobtag", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getJobTag()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIFactoryId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryid", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getPSSysAIFactoryId()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIFactoryName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryname", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getPSSysAIFactoryName()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIPipelineAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaipipelineagentid", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getPSSysAIPipelineAgentId()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIPipelineAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaipipelineagentname", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getPSSysAIPipelineAgentName()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIPipelineJobId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaipipelinejobid", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getPSSysAIPipelineJobId()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIPipelineJobName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaipipelinejobname", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getPSSysAIPipelineJobName()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIWorkerAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaiworkeragentid", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getPSSysAIWorkerAgentId()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIWorkerAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaiworkeragentname", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getPSSysAIWorkerAgentName()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getStepPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"steppscodelistid", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getStepPSCodeListId()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getStepPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"steppscodelistname", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getStepPSCodeListName()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysAIPipelineJobBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysAIPipelineJobBase.getJSONValue((Object)pSSysAIPipelineJobBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysAIPipelineJobBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysAIPipelineJobBase pSSysAIPipelineJobBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysAIPipelineJobBase.getCreateDate() != null) {
            object = pSSysAIPipelineJobBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysAIPipelineJobBase.getCreateMan() != null) {
            object = pSSysAIPipelineJobBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getJobParams() != null) {
            object = pSSysAIPipelineJobBase.getJobParams();
            xmlNode.setAttribute(FIELD_JOBPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getJobTag() != null) {
            object = pSSysAIPipelineJobBase.getJobTag();
            xmlNode.setAttribute(FIELD_JOBTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getMemo() != null) {
            object = pSSysAIPipelineJobBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getOrderValue() != null) {
            object = pSSysAIPipelineJobBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysAIPipelineJobBase.getPSDEDataSetId() != null) {
            object = pSSysAIPipelineJobBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getPSDEDataSetName() != null) {
            object = pSSysAIPipelineJobBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getPSDEId() != null) {
            object = pSSysAIPipelineJobBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIFactoryId() != null) {
            object = pSSysAIPipelineJobBase.getPSSysAIFactoryId();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIFactoryName() != null) {
            object = pSSysAIPipelineJobBase.getPSSysAIFactoryName();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIPipelineAgentId() != null) {
            object = pSSysAIPipelineJobBase.getPSSysAIPipelineAgentId();
            xmlNode.setAttribute(FIELD_PSSYSAIPIPELINEAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIPipelineAgentName() != null) {
            object = pSSysAIPipelineJobBase.getPSSysAIPipelineAgentName();
            xmlNode.setAttribute(FIELD_PSSYSAIPIPELINEAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIPipelineJobId() != null) {
            object = pSSysAIPipelineJobBase.getPSSysAIPipelineJobId();
            xmlNode.setAttribute(FIELD_PSSYSAIPIPELINEJOBID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIPipelineJobName() != null) {
            object = pSSysAIPipelineJobBase.getPSSysAIPipelineJobName();
            xmlNode.setAttribute(FIELD_PSSYSAIPIPELINEJOBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIWorkerAgentId() != null) {
            object = pSSysAIPipelineJobBase.getPSSysAIWorkerAgentId();
            xmlNode.setAttribute(FIELD_PSSYSAIWORKERAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getPSSysAIWorkerAgentName() != null) {
            object = pSSysAIPipelineJobBase.getPSSysAIWorkerAgentName();
            xmlNode.setAttribute(FIELD_PSSYSAIWORKERAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getStepPSCodeListId() != null) {
            object = pSSysAIPipelineJobBase.getStepPSCodeListId();
            xmlNode.setAttribute(FIELD_STEPPSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getStepPSCodeListName() != null) {
            object = pSSysAIPipelineJobBase.getStepPSCodeListName();
            xmlNode.setAttribute(FIELD_STEPPSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getUpdateDate() != null) {
            object = pSSysAIPipelineJobBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysAIPipelineJobBase.getUpdateMan() != null) {
            object = pSSysAIPipelineJobBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getUserCat() != null) {
            object = pSSysAIPipelineJobBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getUserTag() != null) {
            object = pSSysAIPipelineJobBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getUserTag2() != null) {
            object = pSSysAIPipelineJobBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getUserTag3() != null) {
            object = pSSysAIPipelineJobBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getUserTag4() != null) {
            object = pSSysAIPipelineJobBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineJobBase.getValidFlag() != null) {
            object = pSSysAIPipelineJobBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysAIPipelineJobBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysAIPipelineJobBase pSSysAIPipelineJobBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysAIPipelineJobBase.isCreateDateDirty() && (bl || pSSysAIPipelineJobBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysAIPipelineJobBase.getCreateDate());
        }
        if (pSSysAIPipelineJobBase.isCreateManDirty() && (bl || pSSysAIPipelineJobBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysAIPipelineJobBase.getCreateMan());
        }
        if (pSSysAIPipelineJobBase.isJobParamsDirty() && (bl || pSSysAIPipelineJobBase.getJobParams() != null)) {
            iDataObject.set(FIELD_JOBPARAMS, (Object)pSSysAIPipelineJobBase.getJobParams());
        }
        if (pSSysAIPipelineJobBase.isJobTagDirty() && (bl || pSSysAIPipelineJobBase.getJobTag() != null)) {
            iDataObject.set(FIELD_JOBTAG, (Object)pSSysAIPipelineJobBase.getJobTag());
        }
        if (pSSysAIPipelineJobBase.isMemoDirty() && (bl || pSSysAIPipelineJobBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysAIPipelineJobBase.getMemo());
        }
        if (pSSysAIPipelineJobBase.isOrderValueDirty() && (bl || pSSysAIPipelineJobBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysAIPipelineJobBase.getOrderValue());
        }
        if (pSSysAIPipelineJobBase.isPSDEDataSetIdDirty() && (bl || pSSysAIPipelineJobBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSSysAIPipelineJobBase.getPSDEDataSetId());
        }
        if (pSSysAIPipelineJobBase.isPSDEDataSetNameDirty() && (bl || pSSysAIPipelineJobBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSSysAIPipelineJobBase.getPSDEDataSetName());
        }
        if (pSSysAIPipelineJobBase.isPSDEIdDirty() && (bl || pSSysAIPipelineJobBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysAIPipelineJobBase.getPSDEId());
        }
        if (pSSysAIPipelineJobBase.isPSSysAIFactoryIdDirty() && (bl || pSSysAIPipelineJobBase.getPSSysAIFactoryId() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYID, (Object)pSSysAIPipelineJobBase.getPSSysAIFactoryId());
        }
        if (pSSysAIPipelineJobBase.isPSSysAIFactoryNameDirty() && (bl || pSSysAIPipelineJobBase.getPSSysAIFactoryName() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYNAME, (Object)pSSysAIPipelineJobBase.getPSSysAIFactoryName());
        }
        if (pSSysAIPipelineJobBase.isPSSysAIPipelineAgentIdDirty() && (bl || pSSysAIPipelineJobBase.getPSSysAIPipelineAgentId() != null)) {
            iDataObject.set(FIELD_PSSYSAIPIPELINEAGENTID, (Object)pSSysAIPipelineJobBase.getPSSysAIPipelineAgentId());
        }
        if (pSSysAIPipelineJobBase.isPSSysAIPipelineAgentNameDirty() && (bl || pSSysAIPipelineJobBase.getPSSysAIPipelineAgentName() != null)) {
            iDataObject.set(FIELD_PSSYSAIPIPELINEAGENTNAME, (Object)pSSysAIPipelineJobBase.getPSSysAIPipelineAgentName());
        }
        if (pSSysAIPipelineJobBase.isPSSysAIPipelineJobIdDirty() && (bl || pSSysAIPipelineJobBase.getPSSysAIPipelineJobId() != null)) {
            iDataObject.set(FIELD_PSSYSAIPIPELINEJOBID, (Object)pSSysAIPipelineJobBase.getPSSysAIPipelineJobId());
        }
        if (pSSysAIPipelineJobBase.isPSSysAIPipelineJobNameDirty() && (bl || pSSysAIPipelineJobBase.getPSSysAIPipelineJobName() != null)) {
            iDataObject.set(FIELD_PSSYSAIPIPELINEJOBNAME, (Object)pSSysAIPipelineJobBase.getPSSysAIPipelineJobName());
        }
        if (pSSysAIPipelineJobBase.isPSSysAIWorkerAgentIdDirty() && (bl || pSSysAIPipelineJobBase.getPSSysAIWorkerAgentId() != null)) {
            iDataObject.set(FIELD_PSSYSAIWORKERAGENTID, (Object)pSSysAIPipelineJobBase.getPSSysAIWorkerAgentId());
        }
        if (pSSysAIPipelineJobBase.isPSSysAIWorkerAgentNameDirty() && (bl || pSSysAIPipelineJobBase.getPSSysAIWorkerAgentName() != null)) {
            iDataObject.set(FIELD_PSSYSAIWORKERAGENTNAME, (Object)pSSysAIPipelineJobBase.getPSSysAIWorkerAgentName());
        }
        if (pSSysAIPipelineJobBase.isStepPSCodeListIdDirty() && (bl || pSSysAIPipelineJobBase.getStepPSCodeListId() != null)) {
            iDataObject.set(FIELD_STEPPSCODELISTID, (Object)pSSysAIPipelineJobBase.getStepPSCodeListId());
        }
        if (pSSysAIPipelineJobBase.isStepPSCodeListNameDirty() && (bl || pSSysAIPipelineJobBase.getStepPSCodeListName() != null)) {
            iDataObject.set(FIELD_STEPPSCODELISTNAME, (Object)pSSysAIPipelineJobBase.getStepPSCodeListName());
        }
        if (pSSysAIPipelineJobBase.isUpdateDateDirty() && (bl || pSSysAIPipelineJobBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysAIPipelineJobBase.getUpdateDate());
        }
        if (pSSysAIPipelineJobBase.isUpdateManDirty() && (bl || pSSysAIPipelineJobBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysAIPipelineJobBase.getUpdateMan());
        }
        if (pSSysAIPipelineJobBase.isUserCatDirty() && (bl || pSSysAIPipelineJobBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysAIPipelineJobBase.getUserCat());
        }
        if (pSSysAIPipelineJobBase.isUserTagDirty() && (bl || pSSysAIPipelineJobBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysAIPipelineJobBase.getUserTag());
        }
        if (pSSysAIPipelineJobBase.isUserTag2Dirty() && (bl || pSSysAIPipelineJobBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysAIPipelineJobBase.getUserTag2());
        }
        if (pSSysAIPipelineJobBase.isUserTag3Dirty() && (bl || pSSysAIPipelineJobBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysAIPipelineJobBase.getUserTag3());
        }
        if (pSSysAIPipelineJobBase.isUserTag4Dirty() && (bl || pSSysAIPipelineJobBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysAIPipelineJobBase.getUserTag4());
        }
        if (pSSysAIPipelineJobBase.isValidFlagDirty() && (bl || pSSysAIPipelineJobBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysAIPipelineJobBase.getValidFlag());
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
        return PSSysAIPipelineJobBase.remove(this, n);
    }

    private static boolean remove(PSSysAIPipelineJobBase pSSysAIPipelineJobBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysAIPipelineJobBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysAIPipelineJobBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysAIPipelineJobBase.resetJobParams();
                return true;
            }
            case 3: {
                pSSysAIPipelineJobBase.resetJobTag();
                return true;
            }
            case 4: {
                pSSysAIPipelineJobBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysAIPipelineJobBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSSysAIPipelineJobBase.resetPSDEDataSetId();
                return true;
            }
            case 7: {
                pSSysAIPipelineJobBase.resetPSDEDataSetName();
                return true;
            }
            case 8: {
                pSSysAIPipelineJobBase.resetPSDEId();
                return true;
            }
            case 9: {
                pSSysAIPipelineJobBase.resetPSSysAIFactoryId();
                return true;
            }
            case 10: {
                pSSysAIPipelineJobBase.resetPSSysAIFactoryName();
                return true;
            }
            case 11: {
                pSSysAIPipelineJobBase.resetPSSysAIPipelineAgentId();
                return true;
            }
            case 12: {
                pSSysAIPipelineJobBase.resetPSSysAIPipelineAgentName();
                return true;
            }
            case 13: {
                pSSysAIPipelineJobBase.resetPSSysAIPipelineJobId();
                return true;
            }
            case 14: {
                pSSysAIPipelineJobBase.resetPSSysAIPipelineJobName();
                return true;
            }
            case 15: {
                pSSysAIPipelineJobBase.resetPSSysAIWorkerAgentId();
                return true;
            }
            case 16: {
                pSSysAIPipelineJobBase.resetPSSysAIWorkerAgentName();
                return true;
            }
            case 17: {
                pSSysAIPipelineJobBase.resetStepPSCodeListId();
                return true;
            }
            case 18: {
                pSSysAIPipelineJobBase.resetStepPSCodeListName();
                return true;
            }
            case 19: {
                pSSysAIPipelineJobBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSSysAIPipelineJobBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSSysAIPipelineJobBase.resetUserCat();
                return true;
            }
            case 22: {
                pSSysAIPipelineJobBase.resetUserTag();
                return true;
            }
            case 23: {
                pSSysAIPipelineJobBase.resetUserTag2();
                return true;
            }
            case 24: {
                pSSysAIPipelineJobBase.resetUserTag3();
                return true;
            }
            case 25: {
                pSSysAIPipelineJobBase.resetUserTag4();
                return true;
            }
            case 26: {
                pSSysAIPipelineJobBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getStepPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStepPSCodeList();
        }
        if (this.getStepPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objStepPSCodeListLock;
        synchronized (n) {
            if (this.steppscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getStepPSCodeListId(), (Object)this.steppscodelist.getPSCodeListId()) != 0L) {
                this.steppscodelist = null;
            }
            if (this.steppscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getStepPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet(pSCodeList);
                this.steppscodelist = pSCodeList;
            }
            return this.steppscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSet();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSetLock;
        synchronized (n) {
            if (this.psdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSetId(), (Object)this.psdedataset.getPSDEDataSetId()) != 0L) {
                this.psdedataset = null;
            }
            if (this.psdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
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
                pSSysAIFactoryService.autoGet(pSSysAIFactory);
                this.pssysaifactory = pSSysAIFactory;
            }
            return this.pssysaifactory;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysAIPipelineAgent getPSSysAIPipelineAgent() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIPipelineAgent();
        }
        if (this.getPSSysAIPipelineAgentId() == null) {
            return null;
        }
        Integer n = this.objPSSysAIPipelineAgentLock;
        synchronized (n) {
            if (this.pssysaipipelineagent != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAIPipelineAgentId(), (Object)this.pssysaipipelineagent.getPSSysAIPipelineAgentId()) != 0L) {
                this.pssysaipipelineagent = null;
            }
            if (this.pssysaipipelineagent == null) {
                PSSysAIPipelineAgent pSSysAIPipelineAgent = new PSSysAIPipelineAgent();
                pSSysAIPipelineAgent.setPSSysAIPipelineAgentId(this.getPSSysAIPipelineAgentId());
                PSSysAIPipelineAgentService pSSysAIPipelineAgentService = (PSSysAIPipelineAgentService)ServiceGlobal.getService(PSSysAIPipelineAgentService.class, (SessionFactory)this.getSessionFactory());
                pSSysAIPipelineAgentService.autoGet(pSSysAIPipelineAgent);
                this.pssysaipipelineagent = pSSysAIPipelineAgent;
            }
            return this.pssysaipipelineagent;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysAIWorkerAgent getPSSysAIWorkerAgent() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIWorkerAgent();
        }
        if (this.getPSSysAIWorkerAgentId() == null) {
            return null;
        }
        Integer n = this.objPSSysAIWorkerAgentLock;
        synchronized (n) {
            if (this.pssysaiworkeragent != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAIWorkerAgentId(), (Object)this.pssysaiworkeragent.getPSSysAIWorkerAgentId()) != 0L) {
                this.pssysaiworkeragent = null;
            }
            if (this.pssysaiworkeragent == null) {
                PSSysAIWorkerAgent pSSysAIWorkerAgent = new PSSysAIWorkerAgent();
                pSSysAIWorkerAgent.setPSSysAIWorkerAgentId(this.getPSSysAIWorkerAgentId());
                PSSysAIWorkerAgentService pSSysAIWorkerAgentService = (PSSysAIWorkerAgentService)ServiceGlobal.getService(PSSysAIWorkerAgentService.class, (SessionFactory)this.getSessionFactory());
                pSSysAIWorkerAgentService.autoGet(pSSysAIWorkerAgent);
                this.pssysaiworkeragent = pSSysAIWorkerAgent;
            }
            return this.pssysaiworkeragent;
        }
    }

    private PSSysAIPipelineJobBase getProxyEntity() {
        return this.proxyPSSysAIPipelineJobBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysAIPipelineJobBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysAIPipelineJobBase) {
            this.proxyPSSysAIPipelineJobBase = (PSSysAIPipelineJobBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineJobService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_JOBPARAMS, 2);
        fieldIndexMap.put(FIELD_JOBTAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 6);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 7);
        fieldIndexMap.put(FIELD_PSDEID, 8);
        fieldIndexMap.put(FIELD_PSSYSAIFACTORYID, 9);
        fieldIndexMap.put(FIELD_PSSYSAIFACTORYNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSAIPIPELINEAGENTID, 11);
        fieldIndexMap.put(FIELD_PSSYSAIPIPELINEAGENTNAME, 12);
        fieldIndexMap.put(FIELD_PSSYSAIPIPELINEJOBID, 13);
        fieldIndexMap.put(FIELD_PSSYSAIPIPELINEJOBNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSAIWORKERAGENTID, 15);
        fieldIndexMap.put(FIELD_PSSYSAIWORKERAGENTNAME, 16);
        fieldIndexMap.put(FIELD_STEPPSCODELISTID, 17);
        fieldIndexMap.put(FIELD_STEPPSCODELISTNAME, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
        fieldIndexMap.put(FIELD_USERTAG3, 24);
        fieldIndexMap.put(FIELD_USERTAG4, 25);
        fieldIndexMap.put(FIELD_VALIDFLAG, 26);
    }
}

