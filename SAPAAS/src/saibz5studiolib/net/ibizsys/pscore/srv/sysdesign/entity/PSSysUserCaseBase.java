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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUseCaseCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUseCaseCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUserCaseBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysUserCaseBase.class);
    public static final String FIELD_AICHOICES = "AICHOICES";
    public static final String FIELD_AIPROMPT = "AIPROMPT";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUSECASECATID = "PSSYSUSECASECATID";
    public static final String FIELD_PSSYSUSECASECATNAME = "PSSYSUSECASECATNAME";
    public static final String FIELD_PSSYSUSERCASEID = "PSSYSUSERCASEID";
    public static final String FIELD_PSSYSUSERCASENAME = "PSSYSUSERCASENAME";
    public static final String FIELD_SUBJECT = "SUBJECT";
    public static final String FIELD_TAGS = "TAGS";
    public static final String FIELD_UCTAG = "UCTAG";
    public static final String FIELD_UCTAG2 = "UCTAG2";
    public static final String FIELD_UCTAG3 = "UCTAG3";
    public static final String FIELD_UCTAG4 = "UCTAG4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCASESN = "USERCASESN";
    public static final String FIELD_USERCASETAG = "USERCASETAG";
    public static final String FIELD_USERCASETAG2 = "USERCASETAG2";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_AICHOICES = 0;
    private static final int INDEX_AIPROMPT = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_COLOR = 3;
    private static final int INDEX_CONTENT = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSDEID = 8;
    private static final int INDEX_PSDENAME = 9;
    private static final int INDEX_PSMODULEID = 10;
    private static final int INDEX_PSMODULENAME = 11;
    private static final int INDEX_PSSYSTEMID = 12;
    private static final int INDEX_PSSYSTEMNAME = 13;
    private static final int INDEX_PSSYSUSECASECATID = 14;
    private static final int INDEX_PSSYSUSECASECATNAME = 15;
    private static final int INDEX_PSSYSUSERCASEID = 16;
    private static final int INDEX_PSSYSUSERCASENAME = 17;
    private static final int INDEX_SUBJECT = 18;
    private static final int INDEX_TAGS = 19;
    private static final int INDEX_UCTAG = 20;
    private static final int INDEX_UCTAG2 = 21;
    private static final int INDEX_UCTAG3 = 22;
    private static final int INDEX_UCTAG4 = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final int INDEX_USERCASESN = 26;
    private static final int INDEX_USERCASETAG = 27;
    private static final int INDEX_USERCASETAG2 = 28;
    private static final int INDEX_USERCAT = 29;
    private static final int INDEX_USERTAG = 30;
    private static final int INDEX_USERTAG2 = 31;
    private static final int INDEX_USERTAG3 = 32;
    private static final int INDEX_USERTAG4 = 33;
    private static final int INDEX_VALIDFLAG = 34;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysUserCaseBase proxyPSSysUserCaseBase = null;
    private boolean aichoicesDirtyFlag = false;
    private boolean aipromptDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean colorDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysusecasecatidDirtyFlag = false;
    private boolean pssysusecasecatnameDirtyFlag = false;
    private boolean pssysusercaseidDirtyFlag = false;
    private boolean pssysusercasenameDirtyFlag = false;
    private boolean subjectDirtyFlag = false;
    private boolean tagsDirtyFlag = false;
    private boolean uctagDirtyFlag = false;
    private boolean uctag2DirtyFlag = false;
    private boolean uctag3DirtyFlag = false;
    private boolean uctag4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercasesnDirtyFlag = false;
    private boolean usercasetagDirtyFlag = false;
    private boolean usercasetag2DirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="aichoices")
    private String aichoices;
    @Column(name="aiprompt")
    private String aiprompt;
    @Column(name="codename")
    private String codename;
    @Column(name="color")
    private String color;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysusecasecatid")
    private String pssysusecasecatid;
    @Column(name="pssysusecasecatname")
    private String pssysusecasecatname;
    @Column(name="pssysusercaseid")
    private String pssysusercaseid;
    @Column(name="pssysusercasename")
    private String pssysusercasename;
    @Column(name="subject")
    private String subject;
    @Column(name="tags")
    private String tags;
    @Column(name="uctag")
    private String uctag;
    @Column(name="uctag2")
    private String uctag2;
    @Column(name="uctag3")
    private String uctag3;
    @Column(name="uctag4")
    private String uctag4;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercasesn")
    private String usercasesn;
    @Column(name="usercasetag")
    private String usercasetag;
    @Column(name="usercasetag2")
    private String usercasetag2;
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
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUseCaseCatLock = new Integer(1);
    private PSSysUseCaseCat pssysusecasecat = null;

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

    public void setColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.color = string;
        this.colorDirtyFlag = true;
    }

    public String getColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColor();
        }
        return this.color;
    }

    public boolean isColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorDirty();
        }
        return this.colorDirtyFlag;
    }

    public void resetColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColor();
            return;
        }
        this.colorDirtyFlag = false;
        this.color = null;
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

    public void setPSSysUseCaseCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUseCaseCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusecasecatid = string;
        this.pssysusecasecatidDirtyFlag = true;
    }

    public String getPSSysUseCaseCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUseCaseCatId();
        }
        return this.pssysusecasecatid;
    }

    public boolean isPSSysUseCaseCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUseCaseCatIdDirty();
        }
        return this.pssysusecasecatidDirtyFlag;
    }

    public void resetPSSysUseCaseCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUseCaseCatId();
            return;
        }
        this.pssysusecasecatidDirtyFlag = false;
        this.pssysusecasecatid = null;
    }

    public void setPSSysUseCaseCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUseCaseCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusecasecatname = string;
        this.pssysusecasecatnameDirtyFlag = true;
    }

    public String getPSSysUseCaseCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUseCaseCatName();
        }
        return this.pssysusecasecatname;
    }

    public boolean isPSSysUseCaseCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUseCaseCatNameDirty();
        }
        return this.pssysusecasecatnameDirtyFlag;
    }

    public void resetPSSysUseCaseCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUseCaseCatName();
            return;
        }
        this.pssysusecasecatnameDirtyFlag = false;
        this.pssysusecasecatname = null;
    }

    public void setPSSysUserCaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserCaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusercaseid = string;
        this.pssysusercaseidDirtyFlag = true;
    }

    public String getPSSysUserCaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCaseId();
        }
        return this.pssysusercaseid;
    }

    public boolean isPSSysUserCaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserCaseIdDirty();
        }
        return this.pssysusercaseidDirtyFlag;
    }

    public void resetPSSysUserCaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserCaseId();
            return;
        }
        this.pssysusercaseidDirtyFlag = false;
        this.pssysusercaseid = null;
    }

    public void setPSSysUserCaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserCaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusercasename = string;
        this.pssysusercasenameDirtyFlag = true;
    }

    public String getPSSysUserCaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCaseName();
        }
        return this.pssysusercasename;
    }

    public boolean isPSSysUserCaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserCaseNameDirty();
        }
        return this.pssysusercasenameDirtyFlag;
    }

    public void resetPSSysUserCaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserCaseName();
            return;
        }
        this.pssysusercasenameDirtyFlag = false;
        this.pssysusercasename = null;
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

    public void setUCTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUCTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uctag = string;
        this.uctagDirtyFlag = true;
    }

    public String getUCTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUCTag();
        }
        return this.uctag;
    }

    public boolean isUCTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUCTagDirty();
        }
        return this.uctagDirtyFlag;
    }

    public void resetUCTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUCTag();
            return;
        }
        this.uctagDirtyFlag = false;
        this.uctag = null;
    }

    public void setUCTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUCTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uctag2 = string;
        this.uctag2DirtyFlag = true;
    }

    public String getUCTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUCTag2();
        }
        return this.uctag2;
    }

    public boolean isUCTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUCTag2Dirty();
        }
        return this.uctag2DirtyFlag;
    }

    public void resetUCTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUCTag2();
            return;
        }
        this.uctag2DirtyFlag = false;
        this.uctag2 = null;
    }

    public void setUCTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUCTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uctag3 = string;
        this.uctag3DirtyFlag = true;
    }

    public String getUCTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUCTag3();
        }
        return this.uctag3;
    }

    public boolean isUCTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUCTag3Dirty();
        }
        return this.uctag3DirtyFlag;
    }

    public void resetUCTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUCTag3();
            return;
        }
        this.uctag3DirtyFlag = false;
        this.uctag3 = null;
    }

    public void setUCTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUCTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uctag4 = string;
        this.uctag4DirtyFlag = true;
    }

    public String getUCTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUCTag4();
        }
        return this.uctag4;
    }

    public boolean isUCTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUCTag4Dirty();
        }
        return this.uctag4DirtyFlag;
    }

    public void resetUCTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUCTag4();
            return;
        }
        this.uctag4DirtyFlag = false;
        this.uctag4 = null;
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

    public void setUserCaseSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCaseSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercasesn = string;
        this.usercasesnDirtyFlag = true;
    }

    public String getUserCaseSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCaseSN();
        }
        return this.usercasesn;
    }

    public boolean isUserCaseSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCaseSNDirty();
        }
        return this.usercasesnDirtyFlag;
    }

    public void resetUserCaseSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCaseSN();
            return;
        }
        this.usercasesnDirtyFlag = false;
        this.usercasesn = null;
    }

    public void setUserCaseTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCaseTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercasetag = string;
        this.usercasetagDirtyFlag = true;
    }

    public String getUserCaseTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCaseTag();
        }
        return this.usercasetag;
    }

    public boolean isUserCaseTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCaseTagDirty();
        }
        return this.usercasetagDirtyFlag;
    }

    public void resetUserCaseTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCaseTag();
            return;
        }
        this.usercasetagDirtyFlag = false;
        this.usercasetag = null;
    }

    public void setUserCaseTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCaseTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercasetag2 = string;
        this.usercasetag2DirtyFlag = true;
    }

    public String getUserCaseTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCaseTag2();
        }
        return this.usercasetag2;
    }

    public boolean isUserCaseTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCaseTag2Dirty();
        }
        return this.usercasetag2DirtyFlag;
    }

    public void resetUserCaseTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCaseTag2();
            return;
        }
        this.usercasetag2DirtyFlag = false;
        this.usercasetag2 = null;
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
        PSSysUserCaseBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysUserCaseBase pSSysUserCaseBase) {
        pSSysUserCaseBase.resetAIChoices();
        pSSysUserCaseBase.resetAIPrompt();
        pSSysUserCaseBase.resetCodeName();
        pSSysUserCaseBase.resetColor();
        pSSysUserCaseBase.resetContent();
        pSSysUserCaseBase.resetCreateDate();
        pSSysUserCaseBase.resetCreateMan();
        pSSysUserCaseBase.resetMemo();
        pSSysUserCaseBase.resetPSDEId();
        pSSysUserCaseBase.resetPSDEName();
        pSSysUserCaseBase.resetPSModuleId();
        pSSysUserCaseBase.resetPSModuleName();
        pSSysUserCaseBase.resetPSSystemId();
        pSSysUserCaseBase.resetPSSystemName();
        pSSysUserCaseBase.resetPSSysUseCaseCatId();
        pSSysUserCaseBase.resetPSSysUseCaseCatName();
        pSSysUserCaseBase.resetPSSysUserCaseId();
        pSSysUserCaseBase.resetPSSysUserCaseName();
        pSSysUserCaseBase.resetSubject();
        pSSysUserCaseBase.resetTags();
        pSSysUserCaseBase.resetUCTag();
        pSSysUserCaseBase.resetUCTag2();
        pSSysUserCaseBase.resetUCTag3();
        pSSysUserCaseBase.resetUCTag4();
        pSSysUserCaseBase.resetUpdateDate();
        pSSysUserCaseBase.resetUpdateMan();
        pSSysUserCaseBase.resetUserCaseSN();
        pSSysUserCaseBase.resetUserCaseTag();
        pSSysUserCaseBase.resetUserCaseTag2();
        pSSysUserCaseBase.resetUserCat();
        pSSysUserCaseBase.resetUserTag();
        pSSysUserCaseBase.resetUserTag2();
        pSSysUserCaseBase.resetUserTag3();
        pSSysUserCaseBase.resetUserTag4();
        pSSysUserCaseBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAIChoicesDirty()) {
            hashMap.put(FIELD_AICHOICES, this.getAIChoices());
        }
        if (!bl || this.isAIPromptDirty()) {
            hashMap.put(FIELD_AIPROMPT, this.getAIPrompt());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isColorDirty()) {
            hashMap.put(FIELD_COLOR, this.getColor());
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
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysUseCaseCatIdDirty()) {
            hashMap.put(FIELD_PSSYSUSECASECATID, this.getPSSysUseCaseCatId());
        }
        if (!bl || this.isPSSysUseCaseCatNameDirty()) {
            hashMap.put(FIELD_PSSYSUSECASECATNAME, this.getPSSysUseCaseCatName());
        }
        if (!bl || this.isPSSysUserCaseIdDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASEID, this.getPSSysUserCaseId());
        }
        if (!bl || this.isPSSysUserCaseNameDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASENAME, this.getPSSysUserCaseName());
        }
        if (!bl || this.isSubjectDirty()) {
            hashMap.put(FIELD_SUBJECT, this.getSubject());
        }
        if (!bl || this.isTagsDirty()) {
            hashMap.put(FIELD_TAGS, this.getTags());
        }
        if (!bl || this.isUCTagDirty()) {
            hashMap.put(FIELD_UCTAG, this.getUCTag());
        }
        if (!bl || this.isUCTag2Dirty()) {
            hashMap.put(FIELD_UCTAG2, this.getUCTag2());
        }
        if (!bl || this.isUCTag3Dirty()) {
            hashMap.put(FIELD_UCTAG3, this.getUCTag3());
        }
        if (!bl || this.isUCTag4Dirty()) {
            hashMap.put(FIELD_UCTAG4, this.getUCTag4());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCaseSNDirty()) {
            hashMap.put(FIELD_USERCASESN, this.getUserCaseSN());
        }
        if (!bl || this.isUserCaseTagDirty()) {
            hashMap.put(FIELD_USERCASETAG, this.getUserCaseTag());
        }
        if (!bl || this.isUserCaseTag2Dirty()) {
            hashMap.put(FIELD_USERCASETAG2, this.getUserCaseTag2());
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
        return PSSysUserCaseBase.get(this, n);
    }

    private static Object get(PSSysUserCaseBase pSSysUserCaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserCaseBase.getAIChoices();
            }
            case 1: {
                return pSSysUserCaseBase.getAIPrompt();
            }
            case 2: {
                return pSSysUserCaseBase.getCodeName();
            }
            case 3: {
                return pSSysUserCaseBase.getColor();
            }
            case 4: {
                return pSSysUserCaseBase.getContent();
            }
            case 5: {
                return pSSysUserCaseBase.getCreateDate();
            }
            case 6: {
                return pSSysUserCaseBase.getCreateMan();
            }
            case 7: {
                return pSSysUserCaseBase.getMemo();
            }
            case 8: {
                return pSSysUserCaseBase.getPSDEId();
            }
            case 9: {
                return pSSysUserCaseBase.getPSDEName();
            }
            case 10: {
                return pSSysUserCaseBase.getPSModuleId();
            }
            case 11: {
                return pSSysUserCaseBase.getPSModuleName();
            }
            case 12: {
                return pSSysUserCaseBase.getPSSystemId();
            }
            case 13: {
                return pSSysUserCaseBase.getPSSystemName();
            }
            case 14: {
                return pSSysUserCaseBase.getPSSysUseCaseCatId();
            }
            case 15: {
                return pSSysUserCaseBase.getPSSysUseCaseCatName();
            }
            case 16: {
                return pSSysUserCaseBase.getPSSysUserCaseId();
            }
            case 17: {
                return pSSysUserCaseBase.getPSSysUserCaseName();
            }
            case 18: {
                return pSSysUserCaseBase.getSubject();
            }
            case 19: {
                return pSSysUserCaseBase.getTags();
            }
            case 20: {
                return pSSysUserCaseBase.getUCTag();
            }
            case 21: {
                return pSSysUserCaseBase.getUCTag2();
            }
            case 22: {
                return pSSysUserCaseBase.getUCTag3();
            }
            case 23: {
                return pSSysUserCaseBase.getUCTag4();
            }
            case 24: {
                return pSSysUserCaseBase.getUpdateDate();
            }
            case 25: {
                return pSSysUserCaseBase.getUpdateMan();
            }
            case 26: {
                return pSSysUserCaseBase.getUserCaseSN();
            }
            case 27: {
                return pSSysUserCaseBase.getUserCaseTag();
            }
            case 28: {
                return pSSysUserCaseBase.getUserCaseTag2();
            }
            case 29: {
                return pSSysUserCaseBase.getUserCat();
            }
            case 30: {
                return pSSysUserCaseBase.getUserTag();
            }
            case 31: {
                return pSSysUserCaseBase.getUserTag2();
            }
            case 32: {
                return pSSysUserCaseBase.getUserTag3();
            }
            case 33: {
                return pSSysUserCaseBase.getUserTag4();
            }
            case 34: {
                return pSSysUserCaseBase.getValidFlag();
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
        PSSysUserCaseBase.set(this, n, object);
    }

    private static void set(PSSysUserCaseBase pSSysUserCaseBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysUserCaseBase.setAIChoices(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysUserCaseBase.setAIPrompt(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysUserCaseBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysUserCaseBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysUserCaseBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysUserCaseBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSSysUserCaseBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysUserCaseBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysUserCaseBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysUserCaseBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysUserCaseBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysUserCaseBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysUserCaseBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysUserCaseBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysUserCaseBase.setPSSysUseCaseCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysUserCaseBase.setPSSysUseCaseCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysUserCaseBase.setPSSysUserCaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysUserCaseBase.setPSSysUserCaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysUserCaseBase.setSubject(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysUserCaseBase.setTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysUserCaseBase.setUCTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysUserCaseBase.setUCTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysUserCaseBase.setUCTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysUserCaseBase.setUCTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysUserCaseBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSSysUserCaseBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysUserCaseBase.setUserCaseSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysUserCaseBase.setUserCaseTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysUserCaseBase.setUserCaseTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysUserCaseBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysUserCaseBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysUserCaseBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysUserCaseBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysUserCaseBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysUserCaseBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysUserCaseBase.isNull(this, n);
    }

    private static boolean isNull(PSSysUserCaseBase pSSysUserCaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserCaseBase.getAIChoices() == null;
            }
            case 1: {
                return pSSysUserCaseBase.getAIPrompt() == null;
            }
            case 2: {
                return pSSysUserCaseBase.getCodeName() == null;
            }
            case 3: {
                return pSSysUserCaseBase.getColor() == null;
            }
            case 4: {
                return pSSysUserCaseBase.getContent() == null;
            }
            case 5: {
                return pSSysUserCaseBase.getCreateDate() == null;
            }
            case 6: {
                return pSSysUserCaseBase.getCreateMan() == null;
            }
            case 7: {
                return pSSysUserCaseBase.getMemo() == null;
            }
            case 8: {
                return pSSysUserCaseBase.getPSDEId() == null;
            }
            case 9: {
                return pSSysUserCaseBase.getPSDEName() == null;
            }
            case 10: {
                return pSSysUserCaseBase.getPSModuleId() == null;
            }
            case 11: {
                return pSSysUserCaseBase.getPSModuleName() == null;
            }
            case 12: {
                return pSSysUserCaseBase.getPSSystemId() == null;
            }
            case 13: {
                return pSSysUserCaseBase.getPSSystemName() == null;
            }
            case 14: {
                return pSSysUserCaseBase.getPSSysUseCaseCatId() == null;
            }
            case 15: {
                return pSSysUserCaseBase.getPSSysUseCaseCatName() == null;
            }
            case 16: {
                return pSSysUserCaseBase.getPSSysUserCaseId() == null;
            }
            case 17: {
                return pSSysUserCaseBase.getPSSysUserCaseName() == null;
            }
            case 18: {
                return pSSysUserCaseBase.getSubject() == null;
            }
            case 19: {
                return pSSysUserCaseBase.getTags() == null;
            }
            case 20: {
                return pSSysUserCaseBase.getUCTag() == null;
            }
            case 21: {
                return pSSysUserCaseBase.getUCTag2() == null;
            }
            case 22: {
                return pSSysUserCaseBase.getUCTag3() == null;
            }
            case 23: {
                return pSSysUserCaseBase.getUCTag4() == null;
            }
            case 24: {
                return pSSysUserCaseBase.getUpdateDate() == null;
            }
            case 25: {
                return pSSysUserCaseBase.getUpdateMan() == null;
            }
            case 26: {
                return pSSysUserCaseBase.getUserCaseSN() == null;
            }
            case 27: {
                return pSSysUserCaseBase.getUserCaseTag() == null;
            }
            case 28: {
                return pSSysUserCaseBase.getUserCaseTag2() == null;
            }
            case 29: {
                return pSSysUserCaseBase.getUserCat() == null;
            }
            case 30: {
                return pSSysUserCaseBase.getUserTag() == null;
            }
            case 31: {
                return pSSysUserCaseBase.getUserTag2() == null;
            }
            case 32: {
                return pSSysUserCaseBase.getUserTag3() == null;
            }
            case 33: {
                return pSSysUserCaseBase.getUserTag4() == null;
            }
            case 34: {
                return pSSysUserCaseBase.getValidFlag() == null;
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
        return PSSysUserCaseBase.contains(this, n);
    }

    private static boolean contains(PSSysUserCaseBase pSSysUserCaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserCaseBase.isAIChoicesDirty();
            }
            case 1: {
                return pSSysUserCaseBase.isAIPromptDirty();
            }
            case 2: {
                return pSSysUserCaseBase.isCodeNameDirty();
            }
            case 3: {
                return pSSysUserCaseBase.isColorDirty();
            }
            case 4: {
                return pSSysUserCaseBase.isContentDirty();
            }
            case 5: {
                return pSSysUserCaseBase.isCreateDateDirty();
            }
            case 6: {
                return pSSysUserCaseBase.isCreateManDirty();
            }
            case 7: {
                return pSSysUserCaseBase.isMemoDirty();
            }
            case 8: {
                return pSSysUserCaseBase.isPSDEIdDirty();
            }
            case 9: {
                return pSSysUserCaseBase.isPSDENameDirty();
            }
            case 10: {
                return pSSysUserCaseBase.isPSModuleIdDirty();
            }
            case 11: {
                return pSSysUserCaseBase.isPSModuleNameDirty();
            }
            case 12: {
                return pSSysUserCaseBase.isPSSystemIdDirty();
            }
            case 13: {
                return pSSysUserCaseBase.isPSSystemNameDirty();
            }
            case 14: {
                return pSSysUserCaseBase.isPSSysUseCaseCatIdDirty();
            }
            case 15: {
                return pSSysUserCaseBase.isPSSysUseCaseCatNameDirty();
            }
            case 16: {
                return pSSysUserCaseBase.isPSSysUserCaseIdDirty();
            }
            case 17: {
                return pSSysUserCaseBase.isPSSysUserCaseNameDirty();
            }
            case 18: {
                return pSSysUserCaseBase.isSubjectDirty();
            }
            case 19: {
                return pSSysUserCaseBase.isTagsDirty();
            }
            case 20: {
                return pSSysUserCaseBase.isUCTagDirty();
            }
            case 21: {
                return pSSysUserCaseBase.isUCTag2Dirty();
            }
            case 22: {
                return pSSysUserCaseBase.isUCTag3Dirty();
            }
            case 23: {
                return pSSysUserCaseBase.isUCTag4Dirty();
            }
            case 24: {
                return pSSysUserCaseBase.isUpdateDateDirty();
            }
            case 25: {
                return pSSysUserCaseBase.isUpdateManDirty();
            }
            case 26: {
                return pSSysUserCaseBase.isUserCaseSNDirty();
            }
            case 27: {
                return pSSysUserCaseBase.isUserCaseTagDirty();
            }
            case 28: {
                return pSSysUserCaseBase.isUserCaseTag2Dirty();
            }
            case 29: {
                return pSSysUserCaseBase.isUserCatDirty();
            }
            case 30: {
                return pSSysUserCaseBase.isUserTagDirty();
            }
            case 31: {
                return pSSysUserCaseBase.isUserTag2Dirty();
            }
            case 32: {
                return pSSysUserCaseBase.isUserTag3Dirty();
            }
            case 33: {
                return pSSysUserCaseBase.isUserTag4Dirty();
            }
            case 34: {
                return pSSysUserCaseBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysUserCaseBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysUserCaseBase pSSysUserCaseBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysUserCaseBase.getAIChoices() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aichoices", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getAIChoices()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getAIPrompt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aiprompt", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getAIPrompt()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getColor()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getContent()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getPSSysUseCaseCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusecasecatid", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getPSSysUseCaseCatId()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getPSSysUseCaseCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusecasecatname", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getPSSysUseCaseCatName()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getPSSysUserCaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercaseid", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getPSSysUserCaseId()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getPSSysUserCaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercasename", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getPSSysUserCaseName()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getSubject() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subject", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getSubject()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tags", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getTags()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getUCTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uctag", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getUCTag()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getUCTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uctag2", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getUCTag2()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getUCTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uctag3", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getUCTag3()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getUCTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uctag4", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getUCTag4()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getUserCaseSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercasesn", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getUserCaseSN()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getUserCaseTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercasetag", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getUserCaseTag()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getUserCaseTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercasetag2", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getUserCaseTag2()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysUserCaseBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysUserCaseBase.getJSONValue((Object)pSSysUserCaseBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysUserCaseBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysUserCaseBase pSSysUserCaseBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysUserCaseBase.getAIChoices() != null) {
            object = pSSysUserCaseBase.getAIChoices();
            xmlNode.setAttribute(FIELD_AICHOICES, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUserCaseBase.getAIPrompt() != null) {
            object = pSSysUserCaseBase.getAIPrompt();
            xmlNode.setAttribute(FIELD_AIPROMPT, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUserCaseBase.getCodeName() != null) {
            object = pSSysUserCaseBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUserCaseBase.getColor() != null) {
            object = pSSysUserCaseBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUserCaseBase.getContent() != null) {
            object = pSSysUserCaseBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getCreateDate() != null) {
            object = pSSysUserCaseBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUserCaseBase.getCreateMan() != null) {
            object = pSSysUserCaseBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getMemo() != null) {
            object = pSSysUserCaseBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getPSDEId() != null) {
            object = pSSysUserCaseBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getPSDEName() != null) {
            object = pSSysUserCaseBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getPSModuleId() != null) {
            object = pSSysUserCaseBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getPSModuleName() != null) {
            object = pSSysUserCaseBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getPSSystemId() != null) {
            object = pSSysUserCaseBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getPSSystemName() != null) {
            object = pSSysUserCaseBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getPSSysUseCaseCatId() != null) {
            object = pSSysUserCaseBase.getPSSysUseCaseCatId();
            xmlNode.setAttribute(FIELD_PSSYSUSECASECATID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getPSSysUseCaseCatName() != null) {
            object = pSSysUserCaseBase.getPSSysUseCaseCatName();
            xmlNode.setAttribute(FIELD_PSSYSUSECASECATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getPSSysUserCaseId() != null) {
            object = pSSysUserCaseBase.getPSSysUserCaseId();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getPSSysUserCaseName() != null) {
            object = pSSysUserCaseBase.getPSSysUserCaseName();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getSubject() != null) {
            object = pSSysUserCaseBase.getSubject();
            xmlNode.setAttribute(FIELD_SUBJECT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getTags() != null) {
            object = pSSysUserCaseBase.getTags();
            xmlNode.setAttribute(FIELD_TAGS, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getUCTag() != null) {
            object = pSSysUserCaseBase.getUCTag();
            xmlNode.setAttribute(FIELD_UCTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getUCTag2() != null) {
            object = pSSysUserCaseBase.getUCTag2();
            xmlNode.setAttribute(FIELD_UCTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getUCTag3() != null) {
            object = pSSysUserCaseBase.getUCTag3();
            xmlNode.setAttribute(FIELD_UCTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getUCTag4() != null) {
            object = pSSysUserCaseBase.getUCTag4();
            xmlNode.setAttribute(FIELD_UCTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getUpdateDate() != null) {
            object = pSSysUserCaseBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUserCaseBase.getUpdateMan() != null) {
            object = pSSysUserCaseBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getUserCaseSN() != null) {
            object = pSSysUserCaseBase.getUserCaseSN();
            xmlNode.setAttribute(FIELD_USERCASESN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getUserCaseTag() != null) {
            object = pSSysUserCaseBase.getUserCaseTag();
            xmlNode.setAttribute(FIELD_USERCASETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getUserCaseTag2() != null) {
            object = pSSysUserCaseBase.getUserCaseTag2();
            xmlNode.setAttribute(FIELD_USERCASETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getUserCat() != null) {
            object = pSSysUserCaseBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getUserTag() != null) {
            object = pSSysUserCaseBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getUserTag2() != null) {
            object = pSSysUserCaseBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getUserTag3() != null) {
            object = pSSysUserCaseBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getUserTag4() != null) {
            object = pSSysUserCaseBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseBase.getValidFlag() != null) {
            object = pSSysUserCaseBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysUserCaseBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysUserCaseBase pSSysUserCaseBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysUserCaseBase.isAIChoicesDirty() && (bl || pSSysUserCaseBase.getAIChoices() != null)) {
            iDataObject.set(FIELD_AICHOICES, (Object)pSSysUserCaseBase.getAIChoices());
        }
        if (pSSysUserCaseBase.isAIPromptDirty() && (bl || pSSysUserCaseBase.getAIPrompt() != null)) {
            iDataObject.set(FIELD_AIPROMPT, (Object)pSSysUserCaseBase.getAIPrompt());
        }
        if (pSSysUserCaseBase.isCodeNameDirty() && (bl || pSSysUserCaseBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysUserCaseBase.getCodeName());
        }
        if (pSSysUserCaseBase.isColorDirty() && (bl || pSSysUserCaseBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSSysUserCaseBase.getColor());
        }
        if (pSSysUserCaseBase.isContentDirty() && (bl || pSSysUserCaseBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSSysUserCaseBase.getContent());
        }
        if (pSSysUserCaseBase.isCreateDateDirty() && (bl || pSSysUserCaseBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysUserCaseBase.getCreateDate());
        }
        if (pSSysUserCaseBase.isCreateManDirty() && (bl || pSSysUserCaseBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysUserCaseBase.getCreateMan());
        }
        if (pSSysUserCaseBase.isMemoDirty() && (bl || pSSysUserCaseBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysUserCaseBase.getMemo());
        }
        if (pSSysUserCaseBase.isPSDEIdDirty() && (bl || pSSysUserCaseBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysUserCaseBase.getPSDEId());
        }
        if (pSSysUserCaseBase.isPSDENameDirty() && (bl || pSSysUserCaseBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysUserCaseBase.getPSDEName());
        }
        if (pSSysUserCaseBase.isPSModuleIdDirty() && (bl || pSSysUserCaseBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysUserCaseBase.getPSModuleId());
        }
        if (pSSysUserCaseBase.isPSModuleNameDirty() && (bl || pSSysUserCaseBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysUserCaseBase.getPSModuleName());
        }
        if (pSSysUserCaseBase.isPSSystemIdDirty() && (bl || pSSysUserCaseBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysUserCaseBase.getPSSystemId());
        }
        if (pSSysUserCaseBase.isPSSystemNameDirty() && (bl || pSSysUserCaseBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysUserCaseBase.getPSSystemName());
        }
        if (pSSysUserCaseBase.isPSSysUseCaseCatIdDirty() && (bl || pSSysUserCaseBase.getPSSysUseCaseCatId() != null)) {
            iDataObject.set(FIELD_PSSYSUSECASECATID, (Object)pSSysUserCaseBase.getPSSysUseCaseCatId());
        }
        if (pSSysUserCaseBase.isPSSysUseCaseCatNameDirty() && (bl || pSSysUserCaseBase.getPSSysUseCaseCatName() != null)) {
            iDataObject.set(FIELD_PSSYSUSECASECATNAME, (Object)pSSysUserCaseBase.getPSSysUseCaseCatName());
        }
        if (pSSysUserCaseBase.isPSSysUserCaseIdDirty() && (bl || pSSysUserCaseBase.getPSSysUserCaseId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASEID, (Object)pSSysUserCaseBase.getPSSysUserCaseId());
        }
        if (pSSysUserCaseBase.isPSSysUserCaseNameDirty() && (bl || pSSysUserCaseBase.getPSSysUserCaseName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASENAME, (Object)pSSysUserCaseBase.getPSSysUserCaseName());
        }
        if (pSSysUserCaseBase.isSubjectDirty() && (bl || pSSysUserCaseBase.getSubject() != null)) {
            iDataObject.set(FIELD_SUBJECT, (Object)pSSysUserCaseBase.getSubject());
        }
        if (pSSysUserCaseBase.isTagsDirty() && (bl || pSSysUserCaseBase.getTags() != null)) {
            iDataObject.set(FIELD_TAGS, (Object)pSSysUserCaseBase.getTags());
        }
        if (pSSysUserCaseBase.isUCTagDirty() && (bl || pSSysUserCaseBase.getUCTag() != null)) {
            iDataObject.set(FIELD_UCTAG, (Object)pSSysUserCaseBase.getUCTag());
        }
        if (pSSysUserCaseBase.isUCTag2Dirty() && (bl || pSSysUserCaseBase.getUCTag2() != null)) {
            iDataObject.set(FIELD_UCTAG2, (Object)pSSysUserCaseBase.getUCTag2());
        }
        if (pSSysUserCaseBase.isUCTag3Dirty() && (bl || pSSysUserCaseBase.getUCTag3() != null)) {
            iDataObject.set(FIELD_UCTAG3, (Object)pSSysUserCaseBase.getUCTag3());
        }
        if (pSSysUserCaseBase.isUCTag4Dirty() && (bl || pSSysUserCaseBase.getUCTag4() != null)) {
            iDataObject.set(FIELD_UCTAG4, (Object)pSSysUserCaseBase.getUCTag4());
        }
        if (pSSysUserCaseBase.isUpdateDateDirty() && (bl || pSSysUserCaseBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysUserCaseBase.getUpdateDate());
        }
        if (pSSysUserCaseBase.isUpdateManDirty() && (bl || pSSysUserCaseBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysUserCaseBase.getUpdateMan());
        }
        if (pSSysUserCaseBase.isUserCaseSNDirty() && (bl || pSSysUserCaseBase.getUserCaseSN() != null)) {
            iDataObject.set(FIELD_USERCASESN, (Object)pSSysUserCaseBase.getUserCaseSN());
        }
        if (pSSysUserCaseBase.isUserCaseTagDirty() && (bl || pSSysUserCaseBase.getUserCaseTag() != null)) {
            iDataObject.set(FIELD_USERCASETAG, (Object)pSSysUserCaseBase.getUserCaseTag());
        }
        if (pSSysUserCaseBase.isUserCaseTag2Dirty() && (bl || pSSysUserCaseBase.getUserCaseTag2() != null)) {
            iDataObject.set(FIELD_USERCASETAG2, (Object)pSSysUserCaseBase.getUserCaseTag2());
        }
        if (pSSysUserCaseBase.isUserCatDirty() && (bl || pSSysUserCaseBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysUserCaseBase.getUserCat());
        }
        if (pSSysUserCaseBase.isUserTagDirty() && (bl || pSSysUserCaseBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysUserCaseBase.getUserTag());
        }
        if (pSSysUserCaseBase.isUserTag2Dirty() && (bl || pSSysUserCaseBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysUserCaseBase.getUserTag2());
        }
        if (pSSysUserCaseBase.isUserTag3Dirty() && (bl || pSSysUserCaseBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysUserCaseBase.getUserTag3());
        }
        if (pSSysUserCaseBase.isUserTag4Dirty() && (bl || pSSysUserCaseBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysUserCaseBase.getUserTag4());
        }
        if (pSSysUserCaseBase.isValidFlagDirty() && (bl || pSSysUserCaseBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysUserCaseBase.getValidFlag());
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
        return PSSysUserCaseBase.remove(this, n);
    }

    private static boolean remove(PSSysUserCaseBase pSSysUserCaseBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysUserCaseBase.resetAIChoices();
                return true;
            }
            case 1: {
                pSSysUserCaseBase.resetAIPrompt();
                return true;
            }
            case 2: {
                pSSysUserCaseBase.resetCodeName();
                return true;
            }
            case 3: {
                pSSysUserCaseBase.resetColor();
                return true;
            }
            case 4: {
                pSSysUserCaseBase.resetContent();
                return true;
            }
            case 5: {
                pSSysUserCaseBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSSysUserCaseBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSSysUserCaseBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysUserCaseBase.resetPSDEId();
                return true;
            }
            case 9: {
                pSSysUserCaseBase.resetPSDEName();
                return true;
            }
            case 10: {
                pSSysUserCaseBase.resetPSModuleId();
                return true;
            }
            case 11: {
                pSSysUserCaseBase.resetPSModuleName();
                return true;
            }
            case 12: {
                pSSysUserCaseBase.resetPSSystemId();
                return true;
            }
            case 13: {
                pSSysUserCaseBase.resetPSSystemName();
                return true;
            }
            case 14: {
                pSSysUserCaseBase.resetPSSysUseCaseCatId();
                return true;
            }
            case 15: {
                pSSysUserCaseBase.resetPSSysUseCaseCatName();
                return true;
            }
            case 16: {
                pSSysUserCaseBase.resetPSSysUserCaseId();
                return true;
            }
            case 17: {
                pSSysUserCaseBase.resetPSSysUserCaseName();
                return true;
            }
            case 18: {
                pSSysUserCaseBase.resetSubject();
                return true;
            }
            case 19: {
                pSSysUserCaseBase.resetTags();
                return true;
            }
            case 20: {
                pSSysUserCaseBase.resetUCTag();
                return true;
            }
            case 21: {
                pSSysUserCaseBase.resetUCTag2();
                return true;
            }
            case 22: {
                pSSysUserCaseBase.resetUCTag3();
                return true;
            }
            case 23: {
                pSSysUserCaseBase.resetUCTag4();
                return true;
            }
            case 24: {
                pSSysUserCaseBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSSysUserCaseBase.resetUpdateMan();
                return true;
            }
            case 26: {
                pSSysUserCaseBase.resetUserCaseSN();
                return true;
            }
            case 27: {
                pSSysUserCaseBase.resetUserCaseTag();
                return true;
            }
            case 28: {
                pSSysUserCaseBase.resetUserCaseTag2();
                return true;
            }
            case 29: {
                pSSysUserCaseBase.resetUserCat();
                return true;
            }
            case 30: {
                pSSysUserCaseBase.resetUserTag();
                return true;
            }
            case 31: {
                pSSysUserCaseBase.resetUserTag2();
                return true;
            }
            case 32: {
                pSSysUserCaseBase.resetUserTag3();
                return true;
            }
            case 33: {
                pSSysUserCaseBase.resetUserTag4();
                return true;
            }
            case 34: {
                pSSysUserCaseBase.resetValidFlag();
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
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
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
    public PSSysUseCaseCat getPSSysUseCaseCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUseCaseCat();
        }
        if (this.getPSSysUseCaseCatId() == null) {
            return null;
        }
        Integer n = this.objPSSysUseCaseCatLock;
        synchronized (n) {
            if (this.pssysusecasecat != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUseCaseCatId(), (Object)this.pssysusecasecat.getPSSysUseCaseCatId()) != 0L) {
                this.pssysusecasecat = null;
            }
            if (this.pssysusecasecat == null) {
                PSSysUseCaseCat pSSysUseCaseCat = new PSSysUseCaseCat();
                pSSysUseCaseCat.setPSSysUseCaseCatId(this.getPSSysUseCaseCatId());
                PSSysUseCaseCatService pSSysUseCaseCatService = (PSSysUseCaseCatService)ServiceGlobal.getService(PSSysUseCaseCatService.class, (SessionFactory)this.getSessionFactory());
                pSSysUseCaseCatService.autoGet(pSSysUseCaseCat);
                this.pssysusecasecat = pSSysUseCaseCat;
            }
            return this.pssysusecasecat;
        }
    }

    private PSSysUserCaseBase getProxyEntity() {
        return this.proxyPSSysUserCaseBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysUserCaseBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysUserCaseBase) {
            this.proxyPSSysUserCaseBase = (PSSysUserCaseBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AICHOICES, 0);
        fieldIndexMap.put(FIELD_AIPROMPT, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_COLOR, 3);
        fieldIndexMap.put(FIELD_CONTENT, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSDEID, 8);
        fieldIndexMap.put(FIELD_PSDENAME, 9);
        fieldIndexMap.put(FIELD_PSMODULEID, 10);
        fieldIndexMap.put(FIELD_PSMODULENAME, 11);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 12);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSUSECASECATID, 14);
        fieldIndexMap.put(FIELD_PSSYSUSECASECATNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSUSERCASEID, 16);
        fieldIndexMap.put(FIELD_PSSYSUSERCASENAME, 17);
        fieldIndexMap.put(FIELD_SUBJECT, 18);
        fieldIndexMap.put(FIELD_TAGS, 19);
        fieldIndexMap.put(FIELD_UCTAG, 20);
        fieldIndexMap.put(FIELD_UCTAG2, 21);
        fieldIndexMap.put(FIELD_UCTAG3, 22);
        fieldIndexMap.put(FIELD_UCTAG4, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
        fieldIndexMap.put(FIELD_USERCASESN, 26);
        fieldIndexMap.put(FIELD_USERCASETAG, 27);
        fieldIndexMap.put(FIELD_USERCASETAG2, 28);
        fieldIndexMap.put(FIELD_USERCAT, 29);
        fieldIndexMap.put(FIELD_USERTAG, 30);
        fieldIndexMap.put(FIELD_USERTAG2, 31);
        fieldIndexMap.put(FIELD_USERTAG3, 32);
        fieldIndexMap.put(FIELD_USERTAG4, 33);
        fieldIndexMap.put(FIELD_VALIDFLAG, 34);
    }
}

