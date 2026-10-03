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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCaseRS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseRSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysActorBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysActorBase.class);
    public static final String FIELD_ACTORSN = "ACTORSN";
    public static final String FIELD_ACTORTAG = "ACTORTAG";
    public static final String FIELD_ACTORTAG2 = "ACTORTAG2";
    public static final String FIELD_AICHOICES = "AICHOICES";
    public static final String FIELD_AIPROMPT = "AIPROMPT";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSACTORID = "PSSYSACTORID";
    public static final String FIELD_PSSYSACTORNAME = "PSSYSACTORNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_SUBJECT = "SUBJECT";
    public static final String FIELD_TAGS = "TAGS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ACTORSN = 0;
    private static final int INDEX_ACTORTAG = 1;
    private static final int INDEX_ACTORTAG2 = 2;
    private static final int INDEX_AICHOICES = 3;
    private static final int INDEX_AIPROMPT = 4;
    private static final int INDEX_CODENAME = 5;
    private static final int INDEX_CONTENT = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PSMODULEID = 10;
    private static final int INDEX_PSMODULENAME = 11;
    private static final int INDEX_PSSYSACTORID = 12;
    private static final int INDEX_PSSYSACTORNAME = 13;
    private static final int INDEX_PSSYSTEMID = 14;
    private static final int INDEX_PSSYSTEMNAME = 15;
    private static final int INDEX_SUBJECT = 16;
    private static final int INDEX_TAGS = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final int INDEX_USERCAT = 20;
    private static final int INDEX_USERTAG = 21;
    private static final int INDEX_USERTAG2 = 22;
    private static final int INDEX_USERTAG3 = 23;
    private static final int INDEX_USERTAG4 = 24;
    private static final int INDEX_VALIDFLAG = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysActorBase proxyPSSysActorBase = null;
    private boolean actorsnDirtyFlag = false;
    private boolean actortagDirtyFlag = false;
    private boolean actortag2DirtyFlag = false;
    private boolean aichoicesDirtyFlag = false;
    private boolean aipromptDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysactoridDirtyFlag = false;
    private boolean pssysactornameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean subjectDirtyFlag = false;
    private boolean tagsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="actorsn")
    private String actorsn;
    @Column(name="actortag")
    private String actortag;
    @Column(name="actortag2")
    private String actortag2;
    @Column(name="aichoices")
    private String aichoices;
    @Column(name="aiprompt")
    private String aiprompt;
    @Column(name="codename")
    private String codename;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysactorid")
    private String pssysactorid;
    @Column(name="pssysactorname")
    private String pssysactorname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="subject")
    private String subject;
    @Column(name="tags")
    private String tags;
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
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUserCaseRSsLock = new Integer(1);
    private ArrayList<PSSysUserCaseRS> pssysusercaserss = null;

    public void setActorSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActorSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actorsn = string;
        this.actorsnDirtyFlag = true;
    }

    public String getActorSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActorSN();
        }
        return this.actorsn;
    }

    public boolean isActorSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActorSNDirty();
        }
        return this.actorsnDirtyFlag;
    }

    public void resetActorSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActorSN();
            return;
        }
        this.actorsnDirtyFlag = false;
        this.actorsn = null;
    }

    public void setActorTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActorTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actortag = string;
        this.actortagDirtyFlag = true;
    }

    public String getActorTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActorTag();
        }
        return this.actortag;
    }

    public boolean isActorTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActorTagDirty();
        }
        return this.actortagDirtyFlag;
    }

    public void resetActorTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActorTag();
            return;
        }
        this.actortagDirtyFlag = false;
        this.actortag = null;
    }

    public void setActorTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActorTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actortag2 = string;
        this.actortag2DirtyFlag = true;
    }

    public String getActorTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActorTag2();
        }
        return this.actortag2;
    }

    public boolean isActorTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActorTag2Dirty();
        }
        return this.actortag2DirtyFlag;
    }

    public void resetActorTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActorTag2();
            return;
        }
        this.actortag2DirtyFlag = false;
        this.actortag2 = null;
    }

    public void setAIChoices(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIChoices(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aichoices = string;
        this.aichoicesDirtyFlag = true;
    }

    public String getAIChoices() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIChoices();
        }
        return this.aichoices;
    }

    public boolean isAIChoicesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIChoicesDirty();
        }
        return this.aichoicesDirtyFlag;
    }

    public void resetAIChoices() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIChoices();
            return;
        }
        this.aichoicesDirtyFlag = false;
        this.aichoices = null;
    }

    public void setAIPrompt(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIPrompt(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aiprompt = string;
        this.aipromptDirtyFlag = true;
    }

    public String getAIPrompt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIPrompt();
        }
        return this.aiprompt;
    }

    public boolean isAIPromptDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIPromptDirty();
        }
        return this.aipromptDirtyFlag;
    }

    public void resetAIPrompt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIPrompt();
            return;
        }
        this.aipromptDirtyFlag = false;
        this.aiprompt = null;
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

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
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

    public void setPSSysActorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysActorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysactorid = string;
        this.pssysactoridDirtyFlag = true;
    }

    public String getPSSysActorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysActorId();
        }
        return this.pssysactorid;
    }

    public boolean isPSSysActorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysActorIdDirty();
        }
        return this.pssysactoridDirtyFlag;
    }

    public void resetPSSysActorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysActorId();
            return;
        }
        this.pssysactoridDirtyFlag = false;
        this.pssysactorid = null;
    }

    public void setPSSysActorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysActorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysactorname = string;
        this.pssysactornameDirtyFlag = true;
    }

    public String getPSSysActorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysActorName();
        }
        return this.pssysactorname;
    }

    public boolean isPSSysActorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysActorNameDirty();
        }
        return this.pssysactornameDirtyFlag;
    }

    public void resetPSSysActorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysActorName();
            return;
        }
        this.pssysactornameDirtyFlag = false;
        this.pssysactorname = null;
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

    public void setSubject(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubject(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subject = string;
        this.subjectDirtyFlag = true;
    }

    public String getSubject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubject();
        }
        return this.subject;
    }

    public boolean isSubjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubjectDirty();
        }
        return this.subjectDirtyFlag;
    }

    public void resetSubject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubject();
            return;
        }
        this.subjectDirtyFlag = false;
        this.subject = null;
    }

    public void setTags(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTags(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tags = string;
        this.tagsDirtyFlag = true;
    }

    public String getTags() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTags();
        }
        return this.tags;
    }

    public boolean isTagsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagsDirty();
        }
        return this.tagsDirtyFlag;
    }

    public void resetTags() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTags();
            return;
        }
        this.tagsDirtyFlag = false;
        this.tags = null;
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
        PSSysActorBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysActorBase pSSysActorBase) {
        pSSysActorBase.resetActorSN();
        pSSysActorBase.resetActorTag();
        pSSysActorBase.resetActorTag2();
        pSSysActorBase.resetAIChoices();
        pSSysActorBase.resetAIPrompt();
        pSSysActorBase.resetCodeName();
        pSSysActorBase.resetContent();
        pSSysActorBase.resetCreateDate();
        pSSysActorBase.resetCreateMan();
        pSSysActorBase.resetMemo();
        pSSysActorBase.resetPSModuleId();
        pSSysActorBase.resetPSModuleName();
        pSSysActorBase.resetPSSysActorId();
        pSSysActorBase.resetPSSysActorName();
        pSSysActorBase.resetPSSystemId();
        pSSysActorBase.resetPSSystemName();
        pSSysActorBase.resetSubject();
        pSSysActorBase.resetTags();
        pSSysActorBase.resetUpdateDate();
        pSSysActorBase.resetUpdateMan();
        pSSysActorBase.resetUserCat();
        pSSysActorBase.resetUserTag();
        pSSysActorBase.resetUserTag2();
        pSSysActorBase.resetUserTag3();
        pSSysActorBase.resetUserTag4();
        pSSysActorBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActorSNDirty()) {
            hashMap.put(FIELD_ACTORSN, this.getActorSN());
        }
        if (!bl || this.isActorTagDirty()) {
            hashMap.put(FIELD_ACTORTAG, this.getActorTag());
        }
        if (!bl || this.isActorTag2Dirty()) {
            hashMap.put(FIELD_ACTORTAG2, this.getActorTag2());
        }
        if (!bl || this.isAIChoicesDirty()) {
            hashMap.put(FIELD_AICHOICES, this.getAIChoices());
        }
        if (!bl || this.isAIPromptDirty()) {
            hashMap.put(FIELD_AIPROMPT, this.getAIPrompt());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
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
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysActorIdDirty()) {
            hashMap.put(FIELD_PSSYSACTORID, this.getPSSysActorId());
        }
        if (!bl || this.isPSSysActorNameDirty()) {
            hashMap.put(FIELD_PSSYSACTORNAME, this.getPSSysActorName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isSubjectDirty()) {
            hashMap.put(FIELD_SUBJECT, this.getSubject());
        }
        if (!bl || this.isTagsDirty()) {
            hashMap.put(FIELD_TAGS, this.getTags());
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
        return PSSysActorBase.get(this, n);
    }

    private static Object get(PSSysActorBase pSSysActorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysActorBase.getActorSN();
            }
            case 1: {
                return pSSysActorBase.getActorTag();
            }
            case 2: {
                return pSSysActorBase.getActorTag2();
            }
            case 3: {
                return pSSysActorBase.getAIChoices();
            }
            case 4: {
                return pSSysActorBase.getAIPrompt();
            }
            case 5: {
                return pSSysActorBase.getCodeName();
            }
            case 6: {
                return pSSysActorBase.getContent();
            }
            case 7: {
                return pSSysActorBase.getCreateDate();
            }
            case 8: {
                return pSSysActorBase.getCreateMan();
            }
            case 9: {
                return pSSysActorBase.getMemo();
            }
            case 10: {
                return pSSysActorBase.getPSModuleId();
            }
            case 11: {
                return pSSysActorBase.getPSModuleName();
            }
            case 12: {
                return pSSysActorBase.getPSSysActorId();
            }
            case 13: {
                return pSSysActorBase.getPSSysActorName();
            }
            case 14: {
                return pSSysActorBase.getPSSystemId();
            }
            case 15: {
                return pSSysActorBase.getPSSystemName();
            }
            case 16: {
                return pSSysActorBase.getSubject();
            }
            case 17: {
                return pSSysActorBase.getTags();
            }
            case 18: {
                return pSSysActorBase.getUpdateDate();
            }
            case 19: {
                return pSSysActorBase.getUpdateMan();
            }
            case 20: {
                return pSSysActorBase.getUserCat();
            }
            case 21: {
                return pSSysActorBase.getUserTag();
            }
            case 22: {
                return pSSysActorBase.getUserTag2();
            }
            case 23: {
                return pSSysActorBase.getUserTag3();
            }
            case 24: {
                return pSSysActorBase.getUserTag4();
            }
            case 25: {
                return pSSysActorBase.getValidFlag();
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
        PSSysActorBase.set(this, n, object);
    }

    private static void set(PSSysActorBase pSSysActorBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysActorBase.setActorSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysActorBase.setActorTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysActorBase.setActorTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysActorBase.setAIChoices(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysActorBase.setAIPrompt(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysActorBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysActorBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysActorBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSysActorBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysActorBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysActorBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysActorBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysActorBase.setPSSysActorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysActorBase.setPSSysActorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysActorBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysActorBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysActorBase.setSubject(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysActorBase.setTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysActorBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSSysActorBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysActorBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysActorBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysActorBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysActorBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysActorBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysActorBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysActorBase.isNull(this, n);
    }

    private static boolean isNull(PSSysActorBase pSSysActorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysActorBase.getActorSN() == null;
            }
            case 1: {
                return pSSysActorBase.getActorTag() == null;
            }
            case 2: {
                return pSSysActorBase.getActorTag2() == null;
            }
            case 3: {
                return pSSysActorBase.getAIChoices() == null;
            }
            case 4: {
                return pSSysActorBase.getAIPrompt() == null;
            }
            case 5: {
                return pSSysActorBase.getCodeName() == null;
            }
            case 6: {
                return pSSysActorBase.getContent() == null;
            }
            case 7: {
                return pSSysActorBase.getCreateDate() == null;
            }
            case 8: {
                return pSSysActorBase.getCreateMan() == null;
            }
            case 9: {
                return pSSysActorBase.getMemo() == null;
            }
            case 10: {
                return pSSysActorBase.getPSModuleId() == null;
            }
            case 11: {
                return pSSysActorBase.getPSModuleName() == null;
            }
            case 12: {
                return pSSysActorBase.getPSSysActorId() == null;
            }
            case 13: {
                return pSSysActorBase.getPSSysActorName() == null;
            }
            case 14: {
                return pSSysActorBase.getPSSystemId() == null;
            }
            case 15: {
                return pSSysActorBase.getPSSystemName() == null;
            }
            case 16: {
                return pSSysActorBase.getSubject() == null;
            }
            case 17: {
                return pSSysActorBase.getTags() == null;
            }
            case 18: {
                return pSSysActorBase.getUpdateDate() == null;
            }
            case 19: {
                return pSSysActorBase.getUpdateMan() == null;
            }
            case 20: {
                return pSSysActorBase.getUserCat() == null;
            }
            case 21: {
                return pSSysActorBase.getUserTag() == null;
            }
            case 22: {
                return pSSysActorBase.getUserTag2() == null;
            }
            case 23: {
                return pSSysActorBase.getUserTag3() == null;
            }
            case 24: {
                return pSSysActorBase.getUserTag4() == null;
            }
            case 25: {
                return pSSysActorBase.getValidFlag() == null;
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
        return PSSysActorBase.contains(this, n);
    }

    private static boolean contains(PSSysActorBase pSSysActorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysActorBase.isActorSNDirty();
            }
            case 1: {
                return pSSysActorBase.isActorTagDirty();
            }
            case 2: {
                return pSSysActorBase.isActorTag2Dirty();
            }
            case 3: {
                return pSSysActorBase.isAIChoicesDirty();
            }
            case 4: {
                return pSSysActorBase.isAIPromptDirty();
            }
            case 5: {
                return pSSysActorBase.isCodeNameDirty();
            }
            case 6: {
                return pSSysActorBase.isContentDirty();
            }
            case 7: {
                return pSSysActorBase.isCreateDateDirty();
            }
            case 8: {
                return pSSysActorBase.isCreateManDirty();
            }
            case 9: {
                return pSSysActorBase.isMemoDirty();
            }
            case 10: {
                return pSSysActorBase.isPSModuleIdDirty();
            }
            case 11: {
                return pSSysActorBase.isPSModuleNameDirty();
            }
            case 12: {
                return pSSysActorBase.isPSSysActorIdDirty();
            }
            case 13: {
                return pSSysActorBase.isPSSysActorNameDirty();
            }
            case 14: {
                return pSSysActorBase.isPSSystemIdDirty();
            }
            case 15: {
                return pSSysActorBase.isPSSystemNameDirty();
            }
            case 16: {
                return pSSysActorBase.isSubjectDirty();
            }
            case 17: {
                return pSSysActorBase.isTagsDirty();
            }
            case 18: {
                return pSSysActorBase.isUpdateDateDirty();
            }
            case 19: {
                return pSSysActorBase.isUpdateManDirty();
            }
            case 20: {
                return pSSysActorBase.isUserCatDirty();
            }
            case 21: {
                return pSSysActorBase.isUserTagDirty();
            }
            case 22: {
                return pSSysActorBase.isUserTag2Dirty();
            }
            case 23: {
                return pSSysActorBase.isUserTag3Dirty();
            }
            case 24: {
                return pSSysActorBase.isUserTag4Dirty();
            }
            case 25: {
                return pSSysActorBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysActorBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysActorBase pSSysActorBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysActorBase.getActorSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actorsn", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getActorSN()), (boolean)false);
        }
        if (bl || pSSysActorBase.getActorTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actortag", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getActorTag()), (boolean)false);
        }
        if (bl || pSSysActorBase.getActorTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actortag2", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getActorTag2()), (boolean)false);
        }
        if (bl || pSSysActorBase.getAIChoices() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aichoices", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getAIChoices()), (boolean)false);
        }
        if (bl || pSSysActorBase.getAIPrompt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aiprompt", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getAIPrompt()), (boolean)false);
        }
        if (bl || pSSysActorBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysActorBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getContent()), (boolean)false);
        }
        if (bl || pSSysActorBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysActorBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysActorBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysActorBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysActorBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysActorBase.getPSSysActorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysactorid", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getPSSysActorId()), (boolean)false);
        }
        if (bl || pSSysActorBase.getPSSysActorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysactorname", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getPSSysActorName()), (boolean)false);
        }
        if (bl || pSSysActorBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysActorBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysActorBase.getSubject() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subject", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getSubject()), (boolean)false);
        }
        if (bl || pSSysActorBase.getTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tags", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getTags()), (boolean)false);
        }
        if (bl || pSSysActorBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysActorBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysActorBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysActorBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysActorBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysActorBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysActorBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysActorBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysActorBase.getJSONValue((Object)pSSysActorBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysActorBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysActorBase pSSysActorBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysActorBase.getActorSN() != null) {
            object = pSSysActorBase.getActorSN();
            xmlNode.setAttribute(FIELD_ACTORSN, (String)(object == null ? "" : object));
        }
        if (bl || pSSysActorBase.getActorTag() != null) {
            object = pSSysActorBase.getActorTag();
            xmlNode.setAttribute(FIELD_ACTORTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysActorBase.getActorTag2() != null) {
            object = pSSysActorBase.getActorTag2();
            xmlNode.setAttribute(FIELD_ACTORTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysActorBase.getAIChoices() != null) {
            object = pSSysActorBase.getAIChoices();
            xmlNode.setAttribute(FIELD_AICHOICES, (String)(object == null ? "" : object));
        }
        if (bl || pSSysActorBase.getAIPrompt() != null) {
            object = pSSysActorBase.getAIPrompt();
            xmlNode.setAttribute(FIELD_AIPROMPT, (String)(object == null ? "" : object));
        }
        if (bl || pSSysActorBase.getCodeName() != null) {
            object = pSSysActorBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysActorBase.getContent() != null) {
            object = pSSysActorBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getCreateDate() != null) {
            object = pSSysActorBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysActorBase.getCreateMan() != null) {
            object = pSSysActorBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getMemo() != null) {
            object = pSSysActorBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getPSModuleId() != null) {
            object = pSSysActorBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getPSModuleName() != null) {
            object = pSSysActorBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getPSSysActorId() != null) {
            object = pSSysActorBase.getPSSysActorId();
            xmlNode.setAttribute(FIELD_PSSYSACTORID, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getPSSysActorName() != null) {
            object = pSSysActorBase.getPSSysActorName();
            xmlNode.setAttribute(FIELD_PSSYSACTORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getPSSystemId() != null) {
            object = pSSysActorBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getPSSystemName() != null) {
            object = pSSysActorBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getSubject() != null) {
            object = pSSysActorBase.getSubject();
            xmlNode.setAttribute(FIELD_SUBJECT, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getTags() != null) {
            object = pSSysActorBase.getTags();
            xmlNode.setAttribute(FIELD_TAGS, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getUpdateDate() != null) {
            object = pSSysActorBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysActorBase.getUpdateMan() != null) {
            object = pSSysActorBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getUserCat() != null) {
            object = pSSysActorBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getUserTag() != null) {
            object = pSSysActorBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getUserTag2() != null) {
            object = pSSysActorBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getUserTag3() != null) {
            object = pSSysActorBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getUserTag4() != null) {
            object = pSSysActorBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysActorBase.getValidFlag() != null) {
            object = pSSysActorBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysActorBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysActorBase pSSysActorBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysActorBase.isActorSNDirty() && (bl || pSSysActorBase.getActorSN() != null)) {
            iDataObject.set(FIELD_ACTORSN, (Object)pSSysActorBase.getActorSN());
        }
        if (pSSysActorBase.isActorTagDirty() && (bl || pSSysActorBase.getActorTag() != null)) {
            iDataObject.set(FIELD_ACTORTAG, (Object)pSSysActorBase.getActorTag());
        }
        if (pSSysActorBase.isActorTag2Dirty() && (bl || pSSysActorBase.getActorTag2() != null)) {
            iDataObject.set(FIELD_ACTORTAG2, (Object)pSSysActorBase.getActorTag2());
        }
        if (pSSysActorBase.isAIChoicesDirty() && (bl || pSSysActorBase.getAIChoices() != null)) {
            iDataObject.set(FIELD_AICHOICES, (Object)pSSysActorBase.getAIChoices());
        }
        if (pSSysActorBase.isAIPromptDirty() && (bl || pSSysActorBase.getAIPrompt() != null)) {
            iDataObject.set(FIELD_AIPROMPT, (Object)pSSysActorBase.getAIPrompt());
        }
        if (pSSysActorBase.isCodeNameDirty() && (bl || pSSysActorBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysActorBase.getCodeName());
        }
        if (pSSysActorBase.isContentDirty() && (bl || pSSysActorBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSSysActorBase.getContent());
        }
        if (pSSysActorBase.isCreateDateDirty() && (bl || pSSysActorBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysActorBase.getCreateDate());
        }
        if (pSSysActorBase.isCreateManDirty() && (bl || pSSysActorBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysActorBase.getCreateMan());
        }
        if (pSSysActorBase.isMemoDirty() && (bl || pSSysActorBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysActorBase.getMemo());
        }
        if (pSSysActorBase.isPSModuleIdDirty() && (bl || pSSysActorBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysActorBase.getPSModuleId());
        }
        if (pSSysActorBase.isPSModuleNameDirty() && (bl || pSSysActorBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysActorBase.getPSModuleName());
        }
        if (pSSysActorBase.isPSSysActorIdDirty() && (bl || pSSysActorBase.getPSSysActorId() != null)) {
            iDataObject.set(FIELD_PSSYSACTORID, (Object)pSSysActorBase.getPSSysActorId());
        }
        if (pSSysActorBase.isPSSysActorNameDirty() && (bl || pSSysActorBase.getPSSysActorName() != null)) {
            iDataObject.set(FIELD_PSSYSACTORNAME, (Object)pSSysActorBase.getPSSysActorName());
        }
        if (pSSysActorBase.isPSSystemIdDirty() && (bl || pSSysActorBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysActorBase.getPSSystemId());
        }
        if (pSSysActorBase.isPSSystemNameDirty() && (bl || pSSysActorBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysActorBase.getPSSystemName());
        }
        if (pSSysActorBase.isSubjectDirty() && (bl || pSSysActorBase.getSubject() != null)) {
            iDataObject.set(FIELD_SUBJECT, (Object)pSSysActorBase.getSubject());
        }
        if (pSSysActorBase.isTagsDirty() && (bl || pSSysActorBase.getTags() != null)) {
            iDataObject.set(FIELD_TAGS, (Object)pSSysActorBase.getTags());
        }
        if (pSSysActorBase.isUpdateDateDirty() && (bl || pSSysActorBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysActorBase.getUpdateDate());
        }
        if (pSSysActorBase.isUpdateManDirty() && (bl || pSSysActorBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysActorBase.getUpdateMan());
        }
        if (pSSysActorBase.isUserCatDirty() && (bl || pSSysActorBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysActorBase.getUserCat());
        }
        if (pSSysActorBase.isUserTagDirty() && (bl || pSSysActorBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysActorBase.getUserTag());
        }
        if (pSSysActorBase.isUserTag2Dirty() && (bl || pSSysActorBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysActorBase.getUserTag2());
        }
        if (pSSysActorBase.isUserTag3Dirty() && (bl || pSSysActorBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysActorBase.getUserTag3());
        }
        if (pSSysActorBase.isUserTag4Dirty() && (bl || pSSysActorBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysActorBase.getUserTag4());
        }
        if (pSSysActorBase.isValidFlagDirty() && (bl || pSSysActorBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysActorBase.getValidFlag());
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
        return PSSysActorBase.remove(this, n);
    }

    private static boolean remove(PSSysActorBase pSSysActorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysActorBase.resetActorSN();
                return true;
            }
            case 1: {
                pSSysActorBase.resetActorTag();
                return true;
            }
            case 2: {
                pSSysActorBase.resetActorTag2();
                return true;
            }
            case 3: {
                pSSysActorBase.resetAIChoices();
                return true;
            }
            case 4: {
                pSSysActorBase.resetAIPrompt();
                return true;
            }
            case 5: {
                pSSysActorBase.resetCodeName();
                return true;
            }
            case 6: {
                pSSysActorBase.resetContent();
                return true;
            }
            case 7: {
                pSSysActorBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSSysActorBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSSysActorBase.resetMemo();
                return true;
            }
            case 10: {
                pSSysActorBase.resetPSModuleId();
                return true;
            }
            case 11: {
                pSSysActorBase.resetPSModuleName();
                return true;
            }
            case 12: {
                pSSysActorBase.resetPSSysActorId();
                return true;
            }
            case 13: {
                pSSysActorBase.resetPSSysActorName();
                return true;
            }
            case 14: {
                pSSysActorBase.resetPSSystemId();
                return true;
            }
            case 15: {
                pSSysActorBase.resetPSSystemName();
                return true;
            }
            case 16: {
                pSSysActorBase.resetSubject();
                return true;
            }
            case 17: {
                pSSysActorBase.resetTags();
                return true;
            }
            case 18: {
                pSSysActorBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSSysActorBase.resetUpdateMan();
                return true;
            }
            case 20: {
                pSSysActorBase.resetUserCat();
                return true;
            }
            case 21: {
                pSSysActorBase.resetUserTag();
                return true;
            }
            case 22: {
                pSSysActorBase.resetUserTag2();
                return true;
            }
            case 23: {
                pSSysActorBase.resetUserTag3();
                return true;
            }
            case 24: {
                pSSysActorBase.resetUserTag4();
                return true;
            }
            case 25: {
                pSSysActorBase.resetValidFlag();
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
    public ArrayList<PSSysUserCaseRS> getPSSysUserCaseRSs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCaseRSs();
        }
        if (this.getPSSysActorId() == null) {
            return null;
        }
        PSSysUserCaseRSService pSSysUserCaseRSService = (PSSysUserCaseRSService)ServiceGlobal.getService(PSSysUserCaseRSService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUserCaseRSsLock;
        synchronized (n) {
            if (this.pssysusercaserss == null) {
                this.pssysusercaserss = pSSysUserCaseRSService.selectByPSSysActor(this);
            }
            return this.pssysusercaserss;
        }
    }

    private PSSysActorBase getProxyEntity() {
        return this.proxyPSSysActorBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysActorBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysActorBase) {
            this.proxyPSSysActorBase = (PSSysActorBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysActorService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTORSN, 0);
        fieldIndexMap.put(FIELD_ACTORTAG, 1);
        fieldIndexMap.put(FIELD_ACTORTAG2, 2);
        fieldIndexMap.put(FIELD_AICHOICES, 3);
        fieldIndexMap.put(FIELD_AIPROMPT, 4);
        fieldIndexMap.put(FIELD_CODENAME, 5);
        fieldIndexMap.put(FIELD_CONTENT, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PSMODULEID, 10);
        fieldIndexMap.put(FIELD_PSMODULENAME, 11);
        fieldIndexMap.put(FIELD_PSSYSACTORID, 12);
        fieldIndexMap.put(FIELD_PSSYSACTORNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 15);
        fieldIndexMap.put(FIELD_SUBJECT, 16);
        fieldIndexMap.put(FIELD_TAGS, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
        fieldIndexMap.put(FIELD_USERCAT, 20);
        fieldIndexMap.put(FIELD_USERTAG, 21);
        fieldIndexMap.put(FIELD_USERTAG2, 22);
        fieldIndexMap.put(FIELD_USERTAG3, 23);
        fieldIndexMap.put(FIELD_USERTAG4, 24);
        fieldIndexMap.put(FIELD_VALIDFLAG, 25);
    }
}

