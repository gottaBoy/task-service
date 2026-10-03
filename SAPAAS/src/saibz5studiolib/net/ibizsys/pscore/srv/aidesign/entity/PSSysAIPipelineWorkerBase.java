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
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysAIPipelineWorkerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysAIPipelineWorkerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSAIFACTORYID = "PSSYSAIFACTORYID";
    public static final String FIELD_PSSYSAIFACTORYNAME = "PSSYSAIFACTORYNAME";
    public static final String FIELD_PSSYSAIPIPELINEAGENTID = "PSSYSAIPIPELINEAGENTID";
    public static final String FIELD_PSSYSAIPIPELINEAGENTNAME = "PSSYSAIPIPELINEAGENTNAME";
    public static final String FIELD_PSSYSAIPIPELINEWORKERID = "PSSYSAIPIPELINEWORKERID";
    public static final String FIELD_PSSYSAIPIPELINEWORKERNAME = "PSSYSAIPIPELINEWORKERNAME";
    public static final String FIELD_PSSYSAIWORKERAGENTID = "PSSYSAIWORKERAGENTID";
    public static final String FIELD_PSSYSAIWORKERAGENTNAME = "PSSYSAIWORKERAGENTNAME";
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
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSYSAIFACTORYID = 3;
    private static final int INDEX_PSSYSAIFACTORYNAME = 4;
    private static final int INDEX_PSSYSAIPIPELINEAGENTID = 5;
    private static final int INDEX_PSSYSAIPIPELINEAGENTNAME = 6;
    private static final int INDEX_PSSYSAIPIPELINEWORKERID = 7;
    private static final int INDEX_PSSYSAIPIPELINEWORKERNAME = 8;
    private static final int INDEX_PSSYSAIWORKERAGENTID = 9;
    private static final int INDEX_PSSYSAIWORKERAGENTNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCAT = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final int INDEX_USERTAG3 = 16;
    private static final int INDEX_USERTAG4 = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysAIPipelineWorkerBase proxyPSSysAIPipelineWorkerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysaifactoryidDirtyFlag = false;
    private boolean pssysaifactorynameDirtyFlag = false;
    private boolean pssysaipipelineagentidDirtyFlag = false;
    private boolean pssysaipipelineagentnameDirtyFlag = false;
    private boolean pssysaipipelineworkeridDirtyFlag = false;
    private boolean pssysaipipelineworkernameDirtyFlag = false;
    private boolean pssysaiworkeragentidDirtyFlag = false;
    private boolean pssysaiworkeragentnameDirtyFlag = false;
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
    @Column(name="memo")
    private String memo;
    @Column(name="pssysaifactoryid")
    private String pssysaifactoryid;
    @Column(name="pssysaifactoryname")
    private String pssysaifactoryname;
    @Column(name="pssysaipipelineagentid")
    private String pssysaipipelineagentid;
    @Column(name="pssysaipipelineagentname")
    private String pssysaipipelineagentname;
    @Column(name="pssysaipipelineworkerid")
    private String pssysaipipelineworkerid;
    @Column(name="pssysaipipelineworkername")
    private String pssysaipipelineworkername;
    @Column(name="pssysaiworkeragentid")
    private String pssysaiworkeragentid;
    @Column(name="pssysaiworkeragentname")
    private String pssysaiworkeragentname;
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

    public void setPSSysAIPipelineWorkerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIPipelineWorkerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaipipelineworkerid = string;
        this.pssysaipipelineworkeridDirtyFlag = true;
    }

    public String getPSSysAIPipelineWorkerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIPipelineWorkerId();
        }
        return this.pssysaipipelineworkerid;
    }

    public boolean isPSSysAIPipelineWorkerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIPipelineWorkerIdDirty();
        }
        return this.pssysaipipelineworkeridDirtyFlag;
    }

    public void resetPSSysAIPipelineWorkerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIPipelineWorkerId();
            return;
        }
        this.pssysaipipelineworkeridDirtyFlag = false;
        this.pssysaipipelineworkerid = null;
    }

    public void setPSSysAIPipelineWorkerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIPipelineWorkerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaipipelineworkername = string;
        this.pssysaipipelineworkernameDirtyFlag = true;
    }

    public String getPSSysAIPipelineWorkerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIPipelineWorkerName();
        }
        return this.pssysaipipelineworkername;
    }

    public boolean isPSSysAIPipelineWorkerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIPipelineWorkerNameDirty();
        }
        return this.pssysaipipelineworkernameDirtyFlag;
    }

    public void resetPSSysAIPipelineWorkerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIPipelineWorkerName();
            return;
        }
        this.pssysaipipelineworkernameDirtyFlag = false;
        this.pssysaipipelineworkername = null;
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
        PSSysAIPipelineWorkerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysAIPipelineWorkerBase pSSysAIPipelineWorkerBase) {
        pSSysAIPipelineWorkerBase.resetCreateDate();
        pSSysAIPipelineWorkerBase.resetCreateMan();
        pSSysAIPipelineWorkerBase.resetMemo();
        pSSysAIPipelineWorkerBase.resetPSSysAIFactoryId();
        pSSysAIPipelineWorkerBase.resetPSSysAIFactoryName();
        pSSysAIPipelineWorkerBase.resetPSSysAIPipelineAgentId();
        pSSysAIPipelineWorkerBase.resetPSSysAIPipelineAgentName();
        pSSysAIPipelineWorkerBase.resetPSSysAIPipelineWorkerId();
        pSSysAIPipelineWorkerBase.resetPSSysAIPipelineWorkerName();
        pSSysAIPipelineWorkerBase.resetPSSysAIWorkerAgentId();
        pSSysAIPipelineWorkerBase.resetPSSysAIWorkerAgentName();
        pSSysAIPipelineWorkerBase.resetUpdateDate();
        pSSysAIPipelineWorkerBase.resetUpdateMan();
        pSSysAIPipelineWorkerBase.resetUserCat();
        pSSysAIPipelineWorkerBase.resetUserTag();
        pSSysAIPipelineWorkerBase.resetUserTag2();
        pSSysAIPipelineWorkerBase.resetUserTag3();
        pSSysAIPipelineWorkerBase.resetUserTag4();
        pSSysAIPipelineWorkerBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
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
        if (!bl || this.isPSSysAIPipelineWorkerIdDirty()) {
            hashMap.put(FIELD_PSSYSAIPIPELINEWORKERID, this.getPSSysAIPipelineWorkerId());
        }
        if (!bl || this.isPSSysAIPipelineWorkerNameDirty()) {
            hashMap.put(FIELD_PSSYSAIPIPELINEWORKERNAME, this.getPSSysAIPipelineWorkerName());
        }
        if (!bl || this.isPSSysAIWorkerAgentIdDirty()) {
            hashMap.put(FIELD_PSSYSAIWORKERAGENTID, this.getPSSysAIWorkerAgentId());
        }
        if (!bl || this.isPSSysAIWorkerAgentNameDirty()) {
            hashMap.put(FIELD_PSSYSAIWORKERAGENTNAME, this.getPSSysAIWorkerAgentName());
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
        return PSSysAIPipelineWorkerBase.get(this, n);
    }

    private static Object get(PSSysAIPipelineWorkerBase pSSysAIPipelineWorkerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIPipelineWorkerBase.getCreateDate();
            }
            case 1: {
                return pSSysAIPipelineWorkerBase.getCreateMan();
            }
            case 2: {
                return pSSysAIPipelineWorkerBase.getMemo();
            }
            case 3: {
                return pSSysAIPipelineWorkerBase.getPSSysAIFactoryId();
            }
            case 4: {
                return pSSysAIPipelineWorkerBase.getPSSysAIFactoryName();
            }
            case 5: {
                return pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentId();
            }
            case 6: {
                return pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentName();
            }
            case 7: {
                return pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerId();
            }
            case 8: {
                return pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerName();
            }
            case 9: {
                return pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentId();
            }
            case 10: {
                return pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentName();
            }
            case 11: {
                return pSSysAIPipelineWorkerBase.getUpdateDate();
            }
            case 12: {
                return pSSysAIPipelineWorkerBase.getUpdateMan();
            }
            case 13: {
                return pSSysAIPipelineWorkerBase.getUserCat();
            }
            case 14: {
                return pSSysAIPipelineWorkerBase.getUserTag();
            }
            case 15: {
                return pSSysAIPipelineWorkerBase.getUserTag2();
            }
            case 16: {
                return pSSysAIPipelineWorkerBase.getUserTag3();
            }
            case 17: {
                return pSSysAIPipelineWorkerBase.getUserTag4();
            }
            case 18: {
                return pSSysAIPipelineWorkerBase.getValidFlag();
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
        PSSysAIPipelineWorkerBase.set(this, n, object);
    }

    private static void set(PSSysAIPipelineWorkerBase pSSysAIPipelineWorkerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysAIPipelineWorkerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysAIPipelineWorkerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysAIPipelineWorkerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysAIPipelineWorkerBase.setPSSysAIFactoryId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysAIPipelineWorkerBase.setPSSysAIFactoryName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysAIPipelineWorkerBase.setPSSysAIPipelineAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysAIPipelineWorkerBase.setPSSysAIPipelineAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysAIPipelineWorkerBase.setPSSysAIPipelineWorkerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysAIPipelineWorkerBase.setPSSysAIPipelineWorkerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysAIPipelineWorkerBase.setPSSysAIWorkerAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysAIPipelineWorkerBase.setPSSysAIWorkerAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysAIPipelineWorkerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSysAIPipelineWorkerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysAIPipelineWorkerBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysAIPipelineWorkerBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysAIPipelineWorkerBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysAIPipelineWorkerBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysAIPipelineWorkerBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysAIPipelineWorkerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysAIPipelineWorkerBase.isNull(this, n);
    }

    private static boolean isNull(PSSysAIPipelineWorkerBase pSSysAIPipelineWorkerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIPipelineWorkerBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysAIPipelineWorkerBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysAIPipelineWorkerBase.getMemo() == null;
            }
            case 3: {
                return pSSysAIPipelineWorkerBase.getPSSysAIFactoryId() == null;
            }
            case 4: {
                return pSSysAIPipelineWorkerBase.getPSSysAIFactoryName() == null;
            }
            case 5: {
                return pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentId() == null;
            }
            case 6: {
                return pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentName() == null;
            }
            case 7: {
                return pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerId() == null;
            }
            case 8: {
                return pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerName() == null;
            }
            case 9: {
                return pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentId() == null;
            }
            case 10: {
                return pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentName() == null;
            }
            case 11: {
                return pSSysAIPipelineWorkerBase.getUpdateDate() == null;
            }
            case 12: {
                return pSSysAIPipelineWorkerBase.getUpdateMan() == null;
            }
            case 13: {
                return pSSysAIPipelineWorkerBase.getUserCat() == null;
            }
            case 14: {
                return pSSysAIPipelineWorkerBase.getUserTag() == null;
            }
            case 15: {
                return pSSysAIPipelineWorkerBase.getUserTag2() == null;
            }
            case 16: {
                return pSSysAIPipelineWorkerBase.getUserTag3() == null;
            }
            case 17: {
                return pSSysAIPipelineWorkerBase.getUserTag4() == null;
            }
            case 18: {
                return pSSysAIPipelineWorkerBase.getValidFlag() == null;
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
        return PSSysAIPipelineWorkerBase.contains(this, n);
    }

    private static boolean contains(PSSysAIPipelineWorkerBase pSSysAIPipelineWorkerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysAIPipelineWorkerBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysAIPipelineWorkerBase.isCreateManDirty();
            }
            case 2: {
                return pSSysAIPipelineWorkerBase.isMemoDirty();
            }
            case 3: {
                return pSSysAIPipelineWorkerBase.isPSSysAIFactoryIdDirty();
            }
            case 4: {
                return pSSysAIPipelineWorkerBase.isPSSysAIFactoryNameDirty();
            }
            case 5: {
                return pSSysAIPipelineWorkerBase.isPSSysAIPipelineAgentIdDirty();
            }
            case 6: {
                return pSSysAIPipelineWorkerBase.isPSSysAIPipelineAgentNameDirty();
            }
            case 7: {
                return pSSysAIPipelineWorkerBase.isPSSysAIPipelineWorkerIdDirty();
            }
            case 8: {
                return pSSysAIPipelineWorkerBase.isPSSysAIPipelineWorkerNameDirty();
            }
            case 9: {
                return pSSysAIPipelineWorkerBase.isPSSysAIWorkerAgentIdDirty();
            }
            case 10: {
                return pSSysAIPipelineWorkerBase.isPSSysAIWorkerAgentNameDirty();
            }
            case 11: {
                return pSSysAIPipelineWorkerBase.isUpdateDateDirty();
            }
            case 12: {
                return pSSysAIPipelineWorkerBase.isUpdateManDirty();
            }
            case 13: {
                return pSSysAIPipelineWorkerBase.isUserCatDirty();
            }
            case 14: {
                return pSSysAIPipelineWorkerBase.isUserTagDirty();
            }
            case 15: {
                return pSSysAIPipelineWorkerBase.isUserTag2Dirty();
            }
            case 16: {
                return pSSysAIPipelineWorkerBase.isUserTag3Dirty();
            }
            case 17: {
                return pSSysAIPipelineWorkerBase.isUserTag4Dirty();
            }
            case 18: {
                return pSSysAIPipelineWorkerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysAIPipelineWorkerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysAIPipelineWorkerBase pSSysAIPipelineWorkerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysAIPipelineWorkerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIFactoryId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryid", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getPSSysAIFactoryId()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIFactoryName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryname", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getPSSysAIFactoryName()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaipipelineagentid", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentId()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaipipelineagentname", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentName()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaipipelineworkerid", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerId()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaipipelineworkername", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerName()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaiworkeragentid", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentId()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaiworkeragentname", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentName()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysAIPipelineWorkerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysAIPipelineWorkerBase.getJSONValue((Object)pSSysAIPipelineWorkerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysAIPipelineWorkerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysAIPipelineWorkerBase pSSysAIPipelineWorkerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysAIPipelineWorkerBase.getCreateDate() != null) {
            object = pSSysAIPipelineWorkerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysAIPipelineWorkerBase.getCreateMan() != null) {
            object = pSSysAIPipelineWorkerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getMemo() != null) {
            object = pSSysAIPipelineWorkerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIFactoryId() != null) {
            object = pSSysAIPipelineWorkerBase.getPSSysAIFactoryId();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIFactoryName() != null) {
            object = pSSysAIPipelineWorkerBase.getPSSysAIFactoryName();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentId() != null) {
            object = pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentId();
            xmlNode.setAttribute(FIELD_PSSYSAIPIPELINEAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentName() != null) {
            object = pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentName();
            xmlNode.setAttribute(FIELD_PSSYSAIPIPELINEAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerId() != null) {
            object = pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerId();
            xmlNode.setAttribute(FIELD_PSSYSAIPIPELINEWORKERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerName() != null) {
            object = pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerName();
            xmlNode.setAttribute(FIELD_PSSYSAIPIPELINEWORKERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentId() != null) {
            object = pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentId();
            xmlNode.setAttribute(FIELD_PSSYSAIWORKERAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentName() != null) {
            object = pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentName();
            xmlNode.setAttribute(FIELD_PSSYSAIWORKERAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getUpdateDate() != null) {
            object = pSSysAIPipelineWorkerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysAIPipelineWorkerBase.getUpdateMan() != null) {
            object = pSSysAIPipelineWorkerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getUserCat() != null) {
            object = pSSysAIPipelineWorkerBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getUserTag() != null) {
            object = pSSysAIPipelineWorkerBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getUserTag2() != null) {
            object = pSSysAIPipelineWorkerBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getUserTag3() != null) {
            object = pSSysAIPipelineWorkerBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getUserTag4() != null) {
            object = pSSysAIPipelineWorkerBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysAIPipelineWorkerBase.getValidFlag() != null) {
            object = pSSysAIPipelineWorkerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysAIPipelineWorkerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysAIPipelineWorkerBase pSSysAIPipelineWorkerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysAIPipelineWorkerBase.isCreateDateDirty() && (bl || pSSysAIPipelineWorkerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysAIPipelineWorkerBase.getCreateDate());
        }
        if (pSSysAIPipelineWorkerBase.isCreateManDirty() && (bl || pSSysAIPipelineWorkerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysAIPipelineWorkerBase.getCreateMan());
        }
        if (pSSysAIPipelineWorkerBase.isMemoDirty() && (bl || pSSysAIPipelineWorkerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysAIPipelineWorkerBase.getMemo());
        }
        if (pSSysAIPipelineWorkerBase.isPSSysAIFactoryIdDirty() && (bl || pSSysAIPipelineWorkerBase.getPSSysAIFactoryId() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYID, (Object)pSSysAIPipelineWorkerBase.getPSSysAIFactoryId());
        }
        if (pSSysAIPipelineWorkerBase.isPSSysAIFactoryNameDirty() && (bl || pSSysAIPipelineWorkerBase.getPSSysAIFactoryName() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYNAME, (Object)pSSysAIPipelineWorkerBase.getPSSysAIFactoryName());
        }
        if (pSSysAIPipelineWorkerBase.isPSSysAIPipelineAgentIdDirty() && (bl || pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentId() != null)) {
            iDataObject.set(FIELD_PSSYSAIPIPELINEAGENTID, (Object)pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentId());
        }
        if (pSSysAIPipelineWorkerBase.isPSSysAIPipelineAgentNameDirty() && (bl || pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentName() != null)) {
            iDataObject.set(FIELD_PSSYSAIPIPELINEAGENTNAME, (Object)pSSysAIPipelineWorkerBase.getPSSysAIPipelineAgentName());
        }
        if (pSSysAIPipelineWorkerBase.isPSSysAIPipelineWorkerIdDirty() && (bl || pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerId() != null)) {
            iDataObject.set(FIELD_PSSYSAIPIPELINEWORKERID, (Object)pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerId());
        }
        if (pSSysAIPipelineWorkerBase.isPSSysAIPipelineWorkerNameDirty() && (bl || pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerName() != null)) {
            iDataObject.set(FIELD_PSSYSAIPIPELINEWORKERNAME, (Object)pSSysAIPipelineWorkerBase.getPSSysAIPipelineWorkerName());
        }
        if (pSSysAIPipelineWorkerBase.isPSSysAIWorkerAgentIdDirty() && (bl || pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentId() != null)) {
            iDataObject.set(FIELD_PSSYSAIWORKERAGENTID, (Object)pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentId());
        }
        if (pSSysAIPipelineWorkerBase.isPSSysAIWorkerAgentNameDirty() && (bl || pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentName() != null)) {
            iDataObject.set(FIELD_PSSYSAIWORKERAGENTNAME, (Object)pSSysAIPipelineWorkerBase.getPSSysAIWorkerAgentName());
        }
        if (pSSysAIPipelineWorkerBase.isUpdateDateDirty() && (bl || pSSysAIPipelineWorkerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysAIPipelineWorkerBase.getUpdateDate());
        }
        if (pSSysAIPipelineWorkerBase.isUpdateManDirty() && (bl || pSSysAIPipelineWorkerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysAIPipelineWorkerBase.getUpdateMan());
        }
        if (pSSysAIPipelineWorkerBase.isUserCatDirty() && (bl || pSSysAIPipelineWorkerBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysAIPipelineWorkerBase.getUserCat());
        }
        if (pSSysAIPipelineWorkerBase.isUserTagDirty() && (bl || pSSysAIPipelineWorkerBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysAIPipelineWorkerBase.getUserTag());
        }
        if (pSSysAIPipelineWorkerBase.isUserTag2Dirty() && (bl || pSSysAIPipelineWorkerBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysAIPipelineWorkerBase.getUserTag2());
        }
        if (pSSysAIPipelineWorkerBase.isUserTag3Dirty() && (bl || pSSysAIPipelineWorkerBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysAIPipelineWorkerBase.getUserTag3());
        }
        if (pSSysAIPipelineWorkerBase.isUserTag4Dirty() && (bl || pSSysAIPipelineWorkerBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysAIPipelineWorkerBase.getUserTag4());
        }
        if (pSSysAIPipelineWorkerBase.isValidFlagDirty() && (bl || pSSysAIPipelineWorkerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysAIPipelineWorkerBase.getValidFlag());
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
        return PSSysAIPipelineWorkerBase.remove(this, n);
    }

    private static boolean remove(PSSysAIPipelineWorkerBase pSSysAIPipelineWorkerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysAIPipelineWorkerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysAIPipelineWorkerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysAIPipelineWorkerBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysAIPipelineWorkerBase.resetPSSysAIFactoryId();
                return true;
            }
            case 4: {
                pSSysAIPipelineWorkerBase.resetPSSysAIFactoryName();
                return true;
            }
            case 5: {
                pSSysAIPipelineWorkerBase.resetPSSysAIPipelineAgentId();
                return true;
            }
            case 6: {
                pSSysAIPipelineWorkerBase.resetPSSysAIPipelineAgentName();
                return true;
            }
            case 7: {
                pSSysAIPipelineWorkerBase.resetPSSysAIPipelineWorkerId();
                return true;
            }
            case 8: {
                pSSysAIPipelineWorkerBase.resetPSSysAIPipelineWorkerName();
                return true;
            }
            case 9: {
                pSSysAIPipelineWorkerBase.resetPSSysAIWorkerAgentId();
                return true;
            }
            case 10: {
                pSSysAIPipelineWorkerBase.resetPSSysAIWorkerAgentName();
                return true;
            }
            case 11: {
                pSSysAIPipelineWorkerBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSSysAIPipelineWorkerBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSSysAIPipelineWorkerBase.resetUserCat();
                return true;
            }
            case 14: {
                pSSysAIPipelineWorkerBase.resetUserTag();
                return true;
            }
            case 15: {
                pSSysAIPipelineWorkerBase.resetUserTag2();
                return true;
            }
            case 16: {
                pSSysAIPipelineWorkerBase.resetUserTag3();
                return true;
            }
            case 17: {
                pSSysAIPipelineWorkerBase.resetUserTag4();
                return true;
            }
            case 18: {
                pSSysAIPipelineWorkerBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSSysAIPipelineWorkerBase getProxyEntity() {
        return this.proxyPSSysAIPipelineWorkerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysAIPipelineWorkerBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysAIPipelineWorkerBase) {
            this.proxyPSSysAIPipelineWorkerBase = (PSSysAIPipelineWorkerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineWorkerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSYSAIFACTORYID, 3);
        fieldIndexMap.put(FIELD_PSSYSAIFACTORYNAME, 4);
        fieldIndexMap.put(FIELD_PSSYSAIPIPELINEAGENTID, 5);
        fieldIndexMap.put(FIELD_PSSYSAIPIPELINEAGENTNAME, 6);
        fieldIndexMap.put(FIELD_PSSYSAIPIPELINEWORKERID, 7);
        fieldIndexMap.put(FIELD_PSSYSAIPIPELINEWORKERNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSAIWORKERAGENTID, 9);
        fieldIndexMap.put(FIELD_PSSYSAIWORKERAGENTNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERCAT, 13);
        fieldIndexMap.put(FIELD_USERTAG, 14);
        fieldIndexMap.put(FIELD_USERTAG2, 15);
        fieldIndexMap.put(FIELD_USERTAG3, 16);
        fieldIndexMap.put(FIELD_USERTAG4, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

