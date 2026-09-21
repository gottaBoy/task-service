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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysActor;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysActorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysReqModuleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysReqModuleBase.class);
    public static final String FIELD_AIBUILDMODE = "AIBUILDMODE";
    public static final String FIELD_AIBUILDSTATE = "AIBUILDSTATE";
    public static final String FIELD_AICHOICES = "AICHOICES";
    public static final String FIELD_AIPROMPT = "AIPROMPT";
    public static final String FIELD_AIPROMPTCHOICES = "AIPROMPTCHOICES";
    public static final String FIELD_AIPROMPTCHOICES2 = "AIPROMPTCHOICES2";
    public static final String FIELD_AIPROMPTCHOICES3 = "AIPROMPTCHOICES3";
    public static final String FIELD_AIPROMPTCHOICES4 = "AIPROMPTCHOICES4";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODULESN = "MODULESN";
    public static final String FIELD_MODULETAG = "MODULETAG";
    public static final String FIELD_MODULETAG2 = "MODULETAG2";
    public static final String FIELD_MODULETAG3 = "MODULETAG3";
    public static final String FIELD_MODULETAG4 = "MODULETAG4";
    public static final String FIELD_MODULETYPE = "MODULETYPE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSSYSREQMODULEID = "PPSSYSREQMODULEID";
    public static final String FIELD_PPSSYSREQMODULENAME = "PPSSYSREQMODULENAME";
    public static final String FIELD_PSDEVPRDID = "PSDEVPRDID";
    public static final String FIELD_PSDEVPRDNAME = "PSDEVPRDNAME";
    public static final String FIELD_PSDEVPRDVERID = "PSDEVPRDVERID";
    public static final String FIELD_PSDEVPRDVERNAME = "PSDEVPRDVERNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSACTORID = "PSSYSACTORID";
    public static final String FIELD_PSSYSACTORNAME = "PSSYSACTORNAME";
    public static final String FIELD_PSSYSREQMODULEID = "PSSYSREQMODULEID";
    public static final String FIELD_PSSYSREQMODULENAME = "PSSYSREQMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUSECASEID = "PSSYSUSECASEID";
    public static final String FIELD_PSSYSUSECASENAME = "PSSYSUSECASENAME";
    public static final String FIELD_REQMODEL = "REQMODEL";
    public static final String FIELD_REQMODELTYPE = "REQMODELTYPE";
    public static final String FIELD_SUBJECT = "SUBJECT";
    public static final String FIELD_TAGS = "TAGS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_AIBUILDMODE = 0;
    private static final int INDEX_AIBUILDSTATE = 1;
    private static final int INDEX_AICHOICES = 2;
    private static final int INDEX_AIPROMPT = 3;
    private static final int INDEX_AIPROMPTCHOICES = 4;
    private static final int INDEX_AIPROMPTCHOICES2 = 5;
    private static final int INDEX_AIPROMPTCHOICES3 = 6;
    private static final int INDEX_AIPROMPTCHOICES4 = 7;
    private static final int INDEX_CODENAME = 8;
    private static final int INDEX_CONTENT = 9;
    private static final int INDEX_CONTENTTYPE = 10;
    private static final int INDEX_CREATEDATE = 11;
    private static final int INDEX_CREATEMAN = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_MODULESN = 14;
    private static final int INDEX_MODULETAG = 15;
    private static final int INDEX_MODULETAG2 = 16;
    private static final int INDEX_MODULETAG3 = 17;
    private static final int INDEX_MODULETAG4 = 18;
    private static final int INDEX_MODULETYPE = 19;
    private static final int INDEX_ORDERVALUE = 20;
    private static final int INDEX_PPSSYSREQMODULEID = 21;
    private static final int INDEX_PPSSYSREQMODULENAME = 22;
    private static final int INDEX_PSDEVPRDID = 23;
    private static final int INDEX_PSDEVPRDNAME = 24;
    private static final int INDEX_PSDEVPRDVERID = 25;
    private static final int INDEX_PSDEVPRDVERNAME = 26;
    private static final int INDEX_PSMODULEID = 27;
    private static final int INDEX_PSMODULENAME = 28;
    private static final int INDEX_PSSYSACTORID = 29;
    private static final int INDEX_PSSYSACTORNAME = 30;
    private static final int INDEX_PSSYSREQMODULEID = 31;
    private static final int INDEX_PSSYSREQMODULENAME = 32;
    private static final int INDEX_PSSYSTEMID = 33;
    private static final int INDEX_PSSYSTEMNAME = 34;
    private static final int INDEX_PSSYSUSECASEID = 35;
    private static final int INDEX_PSSYSUSECASENAME = 36;
    private static final int INDEX_REQMODEL = 37;
    private static final int INDEX_REQMODELTYPE = 38;
    private static final int INDEX_SUBJECT = 39;
    private static final int INDEX_TAGS = 40;
    private static final int INDEX_UPDATEDATE = 41;
    private static final int INDEX_UPDATEMAN = 42;
    private static final int INDEX_USERCAT = 43;
    private static final int INDEX_USERTAG = 44;
    private static final int INDEX_USERTAG2 = 45;
    private static final int INDEX_USERTAG3 = 46;
    private static final int INDEX_USERTAG4 = 47;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysReqModuleBase proxyPSSysReqModuleBase = null;
    private boolean aibuildmodeDirtyFlag = false;
    private boolean aibuildstateDirtyFlag = false;
    private boolean aichoicesDirtyFlag = false;
    private boolean aipromptDirtyFlag = false;
    private boolean aipromptchoicesDirtyFlag = false;
    private boolean aipromptchoices2DirtyFlag = false;
    private boolean aipromptchoices3DirtyFlag = false;
    private boolean aipromptchoices4DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modulesnDirtyFlag = false;
    private boolean moduletagDirtyFlag = false;
    private boolean moduletag2DirtyFlag = false;
    private boolean moduletag3DirtyFlag = false;
    private boolean moduletag4DirtyFlag = false;
    private boolean moduletypeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppssysreqmoduleidDirtyFlag = false;
    private boolean ppssysreqmodulenameDirtyFlag = false;
    private boolean psdevprdidDirtyFlag = false;
    private boolean psdevprdnameDirtyFlag = false;
    private boolean psdevprdveridDirtyFlag = false;
    private boolean psdevprdvernameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysactoridDirtyFlag = false;
    private boolean pssysactornameDirtyFlag = false;
    private boolean pssysreqmoduleidDirtyFlag = false;
    private boolean pssysreqmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysusecaseidDirtyFlag = false;
    private boolean pssysusecasenameDirtyFlag = false;
    private boolean reqmodelDirtyFlag = false;
    private boolean reqmodeltypeDirtyFlag = false;
    private boolean subjectDirtyFlag = false;
    private boolean tagsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="aibuildmode")
    private Integer aibuildmode;
    @Column(name="aibuildstate")
    private Integer aibuildstate;
    @Column(name="aichoices")
    private String aichoices;
    @Column(name="aiprompt")
    private String aiprompt;
    @Column(name="aipromptchoices")
    private String aipromptchoices;
    @Column(name="aipromptchoices2")
    private String aipromptchoices2;
    @Column(name="aipromptchoices3")
    private String aipromptchoices3;
    @Column(name="aipromptchoices4")
    private String aipromptchoices4;
    @Column(name="codename")
    private String codename;
    @Column(name="content")
    private String content;
    @Column(name="contenttype")
    private String contenttype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="modulesn")
    private String modulesn;
    @Column(name="moduletag")
    private String moduletag;
    @Column(name="moduletag2")
    private String moduletag2;
    @Column(name="moduletag3")
    private String moduletag3;
    @Column(name="moduletag4")
    private String moduletag4;
    @Column(name="moduletype")
    private String moduletype;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppssysreqmoduleid")
    private String ppssysreqmoduleid;
    @Column(name="ppssysreqmodulename")
    private String ppssysreqmodulename;
    @Column(name="psdevprdid")
    private String psdevprdid;
    @Column(name="psdevprdname")
    private String psdevprdname;
    @Column(name="psdevprdverid")
    private String psdevprdverid;
    @Column(name="psdevprdvername")
    private String psdevprdvername;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysactorid")
    private String pssysactorid;
    @Column(name="pssysactorname")
    private String pssysactorname;
    @Column(name="pssysreqmoduleid")
    private String pssysreqmoduleid;
    @Column(name="pssysreqmodulename")
    private String pssysreqmodulename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysusecaseid")
    private String pssysusecaseid;
    @Column(name="pssysusecasename")
    private String pssysusecasename;
    @Column(name="reqmodel")
    private String reqmodel;
    @Column(name="reqmodeltype")
    private String reqmodeltype;
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
    private Integer objPSDevPrdVerLock = new Integer(1);
    private PSDevPrdVer psdevprdver = null;
    private Integer objPSDevPrdLock = new Integer(1);
    private PSDevPrd psdevprd = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysActorLock = new Integer(1);
    private PSSysActor pssysactor = null;
    private Integer objPPSysReqModuleLock = new Integer(1);
    private PSSysReqModule ppsysreqmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUseCaseLock = new Integer(1);
    private PSSysUserCase pssysusecase = null;

    public void setAIBuildMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIBuildMode(n);
            return;
        }
        this.aibuildmode = n;
        this.aibuildmodeDirtyFlag = true;
    }

    public Integer getAIBuildMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIBuildMode();
        }
        return this.aibuildmode;
    }

    public boolean isAIBuildModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIBuildModeDirty();
        }
        return this.aibuildmodeDirtyFlag;
    }

    public void resetAIBuildMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIBuildMode();
            return;
        }
        this.aibuildmodeDirtyFlag = false;
        this.aibuildmode = null;
    }

    public void setAIBuildState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIBuildState(n);
            return;
        }
        this.aibuildstate = n;
        this.aibuildstateDirtyFlag = true;
    }

    public Integer getAIBuildState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIBuildState();
        }
        return this.aibuildstate;
    }

    public boolean isAIBuildStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIBuildStateDirty();
        }
        return this.aibuildstateDirtyFlag;
    }

    public void resetAIBuildState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIBuildState();
            return;
        }
        this.aibuildstateDirtyFlag = false;
        this.aibuildstate = null;
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

    public void setAIPromptChoices(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIPromptChoices(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aipromptchoices = string;
        this.aipromptchoicesDirtyFlag = true;
    }

    public String getAIPromptChoices() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIPromptChoices();
        }
        return this.aipromptchoices;
    }

    public boolean isAIPromptChoicesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIPromptChoicesDirty();
        }
        return this.aipromptchoicesDirtyFlag;
    }

    public void resetAIPromptChoices() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIPromptChoices();
            return;
        }
        this.aipromptchoicesDirtyFlag = false;
        this.aipromptchoices = null;
    }

    public void setAIPromptChoices2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIPromptChoices2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aipromptchoices2 = string;
        this.aipromptchoices2DirtyFlag = true;
    }

    public String getAIPromptChoices2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIPromptChoices2();
        }
        return this.aipromptchoices2;
    }

    public boolean isAIPromptChoices2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIPromptChoices2Dirty();
        }
        return this.aipromptchoices2DirtyFlag;
    }

    public void resetAIPromptChoices2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIPromptChoices2();
            return;
        }
        this.aipromptchoices2DirtyFlag = false;
        this.aipromptchoices2 = null;
    }

    public void setAIPromptChoices3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIPromptChoices3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aipromptchoices3 = string;
        this.aipromptchoices3DirtyFlag = true;
    }

    public String getAIPromptChoices3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIPromptChoices3();
        }
        return this.aipromptchoices3;
    }

    public boolean isAIPromptChoices3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIPromptChoices3Dirty();
        }
        return this.aipromptchoices3DirtyFlag;
    }

    public void resetAIPromptChoices3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIPromptChoices3();
            return;
        }
        this.aipromptchoices3DirtyFlag = false;
        this.aipromptchoices3 = null;
    }

    public void setAIPromptChoices4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIPromptChoices4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aipromptchoices4 = string;
        this.aipromptchoices4DirtyFlag = true;
    }

    public String getAIPromptChoices4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIPromptChoices4();
        }
        return this.aipromptchoices4;
    }

    public boolean isAIPromptChoices4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIPromptChoices4Dirty();
        }
        return this.aipromptchoices4DirtyFlag;
    }

    public void resetAIPromptChoices4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIPromptChoices4();
            return;
        }
        this.aipromptchoices4DirtyFlag = false;
        this.aipromptchoices4 = null;
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

    public void setContentType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttype = string;
        this.contenttypeDirtyFlag = true;
    }

    public String getContentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentType();
        }
        return this.contenttype;
    }

    public boolean isContentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTypeDirty();
        }
        return this.contenttypeDirtyFlag;
    }

    public void resetContentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentType();
            return;
        }
        this.contenttypeDirtyFlag = false;
        this.contenttype = null;
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

    public void setModuleSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modulesn = string;
        this.modulesnDirtyFlag = true;
    }

    public String getModuleSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleSN();
        }
        return this.modulesn;
    }

    public boolean isModuleSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleSNDirty();
        }
        return this.modulesnDirtyFlag;
    }

    public void resetModuleSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleSN();
            return;
        }
        this.modulesnDirtyFlag = false;
        this.modulesn = null;
    }

    public void setModuleTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.moduletag = string;
        this.moduletagDirtyFlag = true;
    }

    public String getModuleTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleTag();
        }
        return this.moduletag;
    }

    public boolean isModuleTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleTagDirty();
        }
        return this.moduletagDirtyFlag;
    }

    public void resetModuleTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleTag();
            return;
        }
        this.moduletagDirtyFlag = false;
        this.moduletag = null;
    }

    public void setModuleTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.moduletag2 = string;
        this.moduletag2DirtyFlag = true;
    }

    public String getModuleTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleTag2();
        }
        return this.moduletag2;
    }

    public boolean isModuleTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleTag2Dirty();
        }
        return this.moduletag2DirtyFlag;
    }

    public void resetModuleTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleTag2();
            return;
        }
        this.moduletag2DirtyFlag = false;
        this.moduletag2 = null;
    }

    public void setModuleTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.moduletag3 = string;
        this.moduletag3DirtyFlag = true;
    }

    public String getModuleTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleTag3();
        }
        return this.moduletag3;
    }

    public boolean isModuleTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleTag3Dirty();
        }
        return this.moduletag3DirtyFlag;
    }

    public void resetModuleTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleTag3();
            return;
        }
        this.moduletag3DirtyFlag = false;
        this.moduletag3 = null;
    }

    public void setModuleTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.moduletag4 = string;
        this.moduletag4DirtyFlag = true;
    }

    public String getModuleTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleTag4();
        }
        return this.moduletag4;
    }

    public boolean isModuleTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleTag4Dirty();
        }
        return this.moduletag4DirtyFlag;
    }

    public void resetModuleTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleTag4();
            return;
        }
        this.moduletag4DirtyFlag = false;
        this.moduletag4 = null;
    }

    public void setModuleType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.moduletype = string;
        this.moduletypeDirtyFlag = true;
    }

    public String getModuleType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleType();
        }
        return this.moduletype;
    }

    public boolean isModuleTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleTypeDirty();
        }
        return this.moduletypeDirtyFlag;
    }

    public void resetModuleType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleType();
            return;
        }
        this.moduletypeDirtyFlag = false;
        this.moduletype = null;
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

    public void setPPSSysReqModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysReqModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysreqmoduleid = string;
        this.ppssysreqmoduleidDirtyFlag = true;
    }

    public String getPPSSysReqModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysReqModuleId();
        }
        return this.ppssysreqmoduleid;
    }

    public boolean isPPSSysReqModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysReqModuleIdDirty();
        }
        return this.ppssysreqmoduleidDirtyFlag;
    }

    public void resetPPSSysReqModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysReqModuleId();
            return;
        }
        this.ppssysreqmoduleidDirtyFlag = false;
        this.ppssysreqmoduleid = null;
    }

    public void setPPSSysReqModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysReqModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysreqmodulename = string;
        this.ppssysreqmodulenameDirtyFlag = true;
    }

    public String getPPSSysReqModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysReqModuleName();
        }
        return this.ppssysreqmodulename;
    }

    public boolean isPPSSysReqModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysReqModuleNameDirty();
        }
        return this.ppssysreqmodulenameDirtyFlag;
    }

    public void resetPPSSysReqModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysReqModuleName();
            return;
        }
        this.ppssysreqmodulenameDirtyFlag = false;
        this.ppssysreqmodulename = null;
    }

    public void setPSDevPrdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdid = string;
        this.psdevprdidDirtyFlag = true;
    }

    public String getPSDevPrdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdId();
        }
        return this.psdevprdid;
    }

    public boolean isPSDevPrdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdIdDirty();
        }
        return this.psdevprdidDirtyFlag;
    }

    public void resetPSDevPrdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdId();
            return;
        }
        this.psdevprdidDirtyFlag = false;
        this.psdevprdid = null;
    }

    public void setPSDevPrdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdname = string;
        this.psdevprdnameDirtyFlag = true;
    }

    public String getPSDevPrdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdName();
        }
        return this.psdevprdname;
    }

    public boolean isPSDevPrdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdNameDirty();
        }
        return this.psdevprdnameDirtyFlag;
    }

    public void resetPSDevPrdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdName();
            return;
        }
        this.psdevprdnameDirtyFlag = false;
        this.psdevprdname = null;
    }

    public void setPSDevPrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdverid = string;
        this.psdevprdveridDirtyFlag = true;
    }

    public String getPSDevPrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVerId();
        }
        return this.psdevprdverid;
    }

    public boolean isPSDevPrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdVerIdDirty();
        }
        return this.psdevprdveridDirtyFlag;
    }

    public void resetPSDevPrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdVerId();
            return;
        }
        this.psdevprdveridDirtyFlag = false;
        this.psdevprdverid = null;
    }

    public void setPSDevPrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdvername = string;
        this.psdevprdvernameDirtyFlag = true;
    }

    public String getPSDevPrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVerName();
        }
        return this.psdevprdvername;
    }

    public boolean isPSDevPrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdVerNameDirty();
        }
        return this.psdevprdvernameDirtyFlag;
    }

    public void resetPSDevPrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdVerName();
            return;
        }
        this.psdevprdvernameDirtyFlag = false;
        this.psdevprdvername = null;
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

    public void setPSSysReqModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqmoduleid = string;
        this.pssysreqmoduleidDirtyFlag = true;
    }

    public String getPSSysReqModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqModuleId();
        }
        return this.pssysreqmoduleid;
    }

    public boolean isPSSysReqModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqModuleIdDirty();
        }
        return this.pssysreqmoduleidDirtyFlag;
    }

    public void resetPSSysReqModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqModuleId();
            return;
        }
        this.pssysreqmoduleidDirtyFlag = false;
        this.pssysreqmoduleid = null;
    }

    public void setPSSysReqModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqmodulename = string;
        this.pssysreqmodulenameDirtyFlag = true;
    }

    public String getPSSysReqModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqModuleName();
        }
        return this.pssysreqmodulename;
    }

    public boolean isPSSysReqModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqModuleNameDirty();
        }
        return this.pssysreqmodulenameDirtyFlag;
    }

    public void resetPSSysReqModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqModuleName();
            return;
        }
        this.pssysreqmodulenameDirtyFlag = false;
        this.pssysreqmodulename = null;
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

    public void setPSSysUseCaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUseCaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusecaseid = string;
        this.pssysusecaseidDirtyFlag = true;
    }

    public String getPSSysUseCaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUseCaseId();
        }
        return this.pssysusecaseid;
    }

    public boolean isPSSysUseCaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUseCaseIdDirty();
        }
        return this.pssysusecaseidDirtyFlag;
    }

    public void resetPSSysUseCaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUseCaseId();
            return;
        }
        this.pssysusecaseidDirtyFlag = false;
        this.pssysusecaseid = null;
    }

    public void setPSSysUseCaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUseCaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusecasename = string;
        this.pssysusecasenameDirtyFlag = true;
    }

    public String getPSSysUseCaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUseCaseName();
        }
        return this.pssysusecasename;
    }

    public boolean isPSSysUseCaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUseCaseNameDirty();
        }
        return this.pssysusecasenameDirtyFlag;
    }

    public void resetPSSysUseCaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUseCaseName();
            return;
        }
        this.pssysusecasenameDirtyFlag = false;
        this.pssysusecasename = null;
    }

    public void setReqModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReqModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reqmodel = string;
        this.reqmodelDirtyFlag = true;
    }

    public String getReqModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReqModel();
        }
        return this.reqmodel;
    }

    public boolean isReqModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReqModelDirty();
        }
        return this.reqmodelDirtyFlag;
    }

    public void resetReqModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReqModel();
            return;
        }
        this.reqmodelDirtyFlag = false;
        this.reqmodel = null;
    }

    public void setReqModelType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReqModelType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reqmodeltype = string;
        this.reqmodeltypeDirtyFlag = true;
    }

    public String getReqModelType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReqModelType();
        }
        return this.reqmodeltype;
    }

    public boolean isReqModelTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReqModelTypeDirty();
        }
        return this.reqmodeltypeDirtyFlag;
    }

    public void resetReqModelType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReqModelType();
            return;
        }
        this.reqmodeltypeDirtyFlag = false;
        this.reqmodeltype = null;
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

    protected void onReset() {
        PSSysReqModuleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysReqModuleBase pSSysReqModuleBase) {
        pSSysReqModuleBase.resetAIBuildMode();
        pSSysReqModuleBase.resetAIBuildState();
        pSSysReqModuleBase.resetAIChoices();
        pSSysReqModuleBase.resetAIPrompt();
        pSSysReqModuleBase.resetAIPromptChoices();
        pSSysReqModuleBase.resetAIPromptChoices2();
        pSSysReqModuleBase.resetAIPromptChoices3();
        pSSysReqModuleBase.resetAIPromptChoices4();
        pSSysReqModuleBase.resetCodeName();
        pSSysReqModuleBase.resetContent();
        pSSysReqModuleBase.resetContentType();
        pSSysReqModuleBase.resetCreateDate();
        pSSysReqModuleBase.resetCreateMan();
        pSSysReqModuleBase.resetMemo();
        pSSysReqModuleBase.resetModuleSN();
        pSSysReqModuleBase.resetModuleTag();
        pSSysReqModuleBase.resetModuleTag2();
        pSSysReqModuleBase.resetModuleTag3();
        pSSysReqModuleBase.resetModuleTag4();
        pSSysReqModuleBase.resetModuleType();
        pSSysReqModuleBase.resetOrderValue();
        pSSysReqModuleBase.resetPPSSysReqModuleId();
        pSSysReqModuleBase.resetPPSSysReqModuleName();
        pSSysReqModuleBase.resetPSDevPrdId();
        pSSysReqModuleBase.resetPSDevPrdName();
        pSSysReqModuleBase.resetPSDevPrdVerId();
        pSSysReqModuleBase.resetPSDevPrdVerName();
        pSSysReqModuleBase.resetPSModuleId();
        pSSysReqModuleBase.resetPSModuleName();
        pSSysReqModuleBase.resetPSSysActorId();
        pSSysReqModuleBase.resetPSSysActorName();
        pSSysReqModuleBase.resetPSSysReqModuleId();
        pSSysReqModuleBase.resetPSSysReqModuleName();
        pSSysReqModuleBase.resetPSSystemId();
        pSSysReqModuleBase.resetPSSystemName();
        pSSysReqModuleBase.resetPSSysUseCaseId();
        pSSysReqModuleBase.resetPSSysUseCaseName();
        pSSysReqModuleBase.resetReqModel();
        pSSysReqModuleBase.resetReqModelType();
        pSSysReqModuleBase.resetSubject();
        pSSysReqModuleBase.resetTags();
        pSSysReqModuleBase.resetUpdateDate();
        pSSysReqModuleBase.resetUpdateMan();
        pSSysReqModuleBase.resetUserCat();
        pSSysReqModuleBase.resetUserTag();
        pSSysReqModuleBase.resetUserTag2();
        pSSysReqModuleBase.resetUserTag3();
        pSSysReqModuleBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAIBuildModeDirty()) {
            hashMap.put(FIELD_AIBUILDMODE, this.getAIBuildMode());
        }
        if (!bl || this.isAIBuildStateDirty()) {
            hashMap.put(FIELD_AIBUILDSTATE, this.getAIBuildState());
        }
        if (!bl || this.isAIChoicesDirty()) {
            hashMap.put(FIELD_AICHOICES, this.getAIChoices());
        }
        if (!bl || this.isAIPromptDirty()) {
            hashMap.put(FIELD_AIPROMPT, this.getAIPrompt());
        }
        if (!bl || this.isAIPromptChoicesDirty()) {
            hashMap.put(FIELD_AIPROMPTCHOICES, this.getAIPromptChoices());
        }
        if (!bl || this.isAIPromptChoices2Dirty()) {
            hashMap.put(FIELD_AIPROMPTCHOICES2, this.getAIPromptChoices2());
        }
        if (!bl || this.isAIPromptChoices3Dirty()) {
            hashMap.put(FIELD_AIPROMPTCHOICES3, this.getAIPromptChoices3());
        }
        if (!bl || this.isAIPromptChoices4Dirty()) {
            hashMap.put(FIELD_AIPROMPTCHOICES4, this.getAIPromptChoices4());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isContentTypeDirty()) {
            hashMap.put(FIELD_CONTENTTYPE, this.getContentType());
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
        if (!bl || this.isModuleSNDirty()) {
            hashMap.put(FIELD_MODULESN, this.getModuleSN());
        }
        if (!bl || this.isModuleTagDirty()) {
            hashMap.put(FIELD_MODULETAG, this.getModuleTag());
        }
        if (!bl || this.isModuleTag2Dirty()) {
            hashMap.put(FIELD_MODULETAG2, this.getModuleTag2());
        }
        if (!bl || this.isModuleTag3Dirty()) {
            hashMap.put(FIELD_MODULETAG3, this.getModuleTag3());
        }
        if (!bl || this.isModuleTag4Dirty()) {
            hashMap.put(FIELD_MODULETAG4, this.getModuleTag4());
        }
        if (!bl || this.isModuleTypeDirty()) {
            hashMap.put(FIELD_MODULETYPE, this.getModuleType());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSSysReqModuleIdDirty()) {
            hashMap.put(FIELD_PPSSYSREQMODULEID, this.getPPSSysReqModuleId());
        }
        if (!bl || this.isPPSSysReqModuleNameDirty()) {
            hashMap.put(FIELD_PPSSYSREQMODULENAME, this.getPPSSysReqModuleName());
        }
        if (!bl || this.isPSDevPrdIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDID, this.getPSDevPrdId());
        }
        if (!bl || this.isPSDevPrdNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDNAME, this.getPSDevPrdName());
        }
        if (!bl || this.isPSDevPrdVerIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDVERID, this.getPSDevPrdVerId());
        }
        if (!bl || this.isPSDevPrdVerNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDVERNAME, this.getPSDevPrdVerName());
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
        if (!bl || this.isPSSysReqModuleIdDirty()) {
            hashMap.put(FIELD_PSSYSREQMODULEID, this.getPSSysReqModuleId());
        }
        if (!bl || this.isPSSysReqModuleNameDirty()) {
            hashMap.put(FIELD_PSSYSREQMODULENAME, this.getPSSysReqModuleName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysUseCaseIdDirty()) {
            hashMap.put(FIELD_PSSYSUSECASEID, this.getPSSysUseCaseId());
        }
        if (!bl || this.isPSSysUseCaseNameDirty()) {
            hashMap.put(FIELD_PSSYSUSECASENAME, this.getPSSysUseCaseName());
        }
        if (!bl || this.isReqModelDirty()) {
            hashMap.put(FIELD_REQMODEL, this.getReqModel());
        }
        if (!bl || this.isReqModelTypeDirty()) {
            hashMap.put(FIELD_REQMODELTYPE, this.getReqModelType());
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
        return PSSysReqModuleBase.get(this, n);
    }

    private static Object get(PSSysReqModuleBase pSSysReqModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysReqModuleBase.getAIBuildMode();
            }
            case 1: {
                return pSSysReqModuleBase.getAIBuildState();
            }
            case 2: {
                return pSSysReqModuleBase.getAIChoices();
            }
            case 3: {
                return pSSysReqModuleBase.getAIPrompt();
            }
            case 4: {
                return pSSysReqModuleBase.getAIPromptChoices();
            }
            case 5: {
                return pSSysReqModuleBase.getAIPromptChoices2();
            }
            case 6: {
                return pSSysReqModuleBase.getAIPromptChoices3();
            }
            case 7: {
                return pSSysReqModuleBase.getAIPromptChoices4();
            }
            case 8: {
                return pSSysReqModuleBase.getCodeName();
            }
            case 9: {
                return pSSysReqModuleBase.getContent();
            }
            case 10: {
                return pSSysReqModuleBase.getContentType();
            }
            case 11: {
                return pSSysReqModuleBase.getCreateDate();
            }
            case 12: {
                return pSSysReqModuleBase.getCreateMan();
            }
            case 13: {
                return pSSysReqModuleBase.getMemo();
            }
            case 14: {
                return pSSysReqModuleBase.getModuleSN();
            }
            case 15: {
                return pSSysReqModuleBase.getModuleTag();
            }
            case 16: {
                return pSSysReqModuleBase.getModuleTag2();
            }
            case 17: {
                return pSSysReqModuleBase.getModuleTag3();
            }
            case 18: {
                return pSSysReqModuleBase.getModuleTag4();
            }
            case 19: {
                return pSSysReqModuleBase.getModuleType();
            }
            case 20: {
                return pSSysReqModuleBase.getOrderValue();
            }
            case 21: {
                return pSSysReqModuleBase.getPPSSysReqModuleId();
            }
            case 22: {
                return pSSysReqModuleBase.getPPSSysReqModuleName();
            }
            case 23: {
                return pSSysReqModuleBase.getPSDevPrdId();
            }
            case 24: {
                return pSSysReqModuleBase.getPSDevPrdName();
            }
            case 25: {
                return pSSysReqModuleBase.getPSDevPrdVerId();
            }
            case 26: {
                return pSSysReqModuleBase.getPSDevPrdVerName();
            }
            case 27: {
                return pSSysReqModuleBase.getPSModuleId();
            }
            case 28: {
                return pSSysReqModuleBase.getPSModuleName();
            }
            case 29: {
                return pSSysReqModuleBase.getPSSysActorId();
            }
            case 30: {
                return pSSysReqModuleBase.getPSSysActorName();
            }
            case 31: {
                return pSSysReqModuleBase.getPSSysReqModuleId();
            }
            case 32: {
                return pSSysReqModuleBase.getPSSysReqModuleName();
            }
            case 33: {
                return pSSysReqModuleBase.getPSSystemId();
            }
            case 34: {
                return pSSysReqModuleBase.getPSSystemName();
            }
            case 35: {
                return pSSysReqModuleBase.getPSSysUseCaseId();
            }
            case 36: {
                return pSSysReqModuleBase.getPSSysUseCaseName();
            }
            case 37: {
                return pSSysReqModuleBase.getReqModel();
            }
            case 38: {
                return pSSysReqModuleBase.getReqModelType();
            }
            case 39: {
                return pSSysReqModuleBase.getSubject();
            }
            case 40: {
                return pSSysReqModuleBase.getTags();
            }
            case 41: {
                return pSSysReqModuleBase.getUpdateDate();
            }
            case 42: {
                return pSSysReqModuleBase.getUpdateMan();
            }
            case 43: {
                return pSSysReqModuleBase.getUserCat();
            }
            case 44: {
                return pSSysReqModuleBase.getUserTag();
            }
            case 45: {
                return pSSysReqModuleBase.getUserTag2();
            }
            case 46: {
                return pSSysReqModuleBase.getUserTag3();
            }
            case 47: {
                return pSSysReqModuleBase.getUserTag4();
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
        PSSysReqModuleBase.set(this, n, object);
    }

    private static void set(PSSysReqModuleBase pSSysReqModuleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysReqModuleBase.setAIBuildMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysReqModuleBase.setAIBuildState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSSysReqModuleBase.setAIChoices(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysReqModuleBase.setAIPrompt(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysReqModuleBase.setAIPromptChoices(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysReqModuleBase.setAIPromptChoices2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysReqModuleBase.setAIPromptChoices3(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysReqModuleBase.setAIPromptChoices4(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysReqModuleBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysReqModuleBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysReqModuleBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysReqModuleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSysReqModuleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysReqModuleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysReqModuleBase.setModuleSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysReqModuleBase.setModuleTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysReqModuleBase.setModuleTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysReqModuleBase.setModuleTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysReqModuleBase.setModuleTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysReqModuleBase.setModuleType(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysReqModuleBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSSysReqModuleBase.setPPSSysReqModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysReqModuleBase.setPPSSysReqModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysReqModuleBase.setPSDevPrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysReqModuleBase.setPSDevPrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysReqModuleBase.setPSDevPrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysReqModuleBase.setPSDevPrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysReqModuleBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysReqModuleBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysReqModuleBase.setPSSysActorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysReqModuleBase.setPSSysActorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysReqModuleBase.setPSSysReqModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysReqModuleBase.setPSSysReqModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysReqModuleBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysReqModuleBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysReqModuleBase.setPSSysUseCaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysReqModuleBase.setPSSysUseCaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysReqModuleBase.setReqModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysReqModuleBase.setReqModelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysReqModuleBase.setSubject(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysReqModuleBase.setTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysReqModuleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 42: {
                pSSysReqModuleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysReqModuleBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysReqModuleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysReqModuleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysReqModuleBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysReqModuleBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysReqModuleBase.isNull(this, n);
    }

    private static boolean isNull(PSSysReqModuleBase pSSysReqModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysReqModuleBase.getAIBuildMode() == null;
            }
            case 1: {
                return pSSysReqModuleBase.getAIBuildState() == null;
            }
            case 2: {
                return pSSysReqModuleBase.getAIChoices() == null;
            }
            case 3: {
                return pSSysReqModuleBase.getAIPrompt() == null;
            }
            case 4: {
                return pSSysReqModuleBase.getAIPromptChoices() == null;
            }
            case 5: {
                return pSSysReqModuleBase.getAIPromptChoices2() == null;
            }
            case 6: {
                return pSSysReqModuleBase.getAIPromptChoices3() == null;
            }
            case 7: {
                return pSSysReqModuleBase.getAIPromptChoices4() == null;
            }
            case 8: {
                return pSSysReqModuleBase.getCodeName() == null;
            }
            case 9: {
                return pSSysReqModuleBase.getContent() == null;
            }
            case 10: {
                return pSSysReqModuleBase.getContentType() == null;
            }
            case 11: {
                return pSSysReqModuleBase.getCreateDate() == null;
            }
            case 12: {
                return pSSysReqModuleBase.getCreateMan() == null;
            }
            case 13: {
                return pSSysReqModuleBase.getMemo() == null;
            }
            case 14: {
                return pSSysReqModuleBase.getModuleSN() == null;
            }
            case 15: {
                return pSSysReqModuleBase.getModuleTag() == null;
            }
            case 16: {
                return pSSysReqModuleBase.getModuleTag2() == null;
            }
            case 17: {
                return pSSysReqModuleBase.getModuleTag3() == null;
            }
            case 18: {
                return pSSysReqModuleBase.getModuleTag4() == null;
            }
            case 19: {
                return pSSysReqModuleBase.getModuleType() == null;
            }
            case 20: {
                return pSSysReqModuleBase.getOrderValue() == null;
            }
            case 21: {
                return pSSysReqModuleBase.getPPSSysReqModuleId() == null;
            }
            case 22: {
                return pSSysReqModuleBase.getPPSSysReqModuleName() == null;
            }
            case 23: {
                return pSSysReqModuleBase.getPSDevPrdId() == null;
            }
            case 24: {
                return pSSysReqModuleBase.getPSDevPrdName() == null;
            }
            case 25: {
                return pSSysReqModuleBase.getPSDevPrdVerId() == null;
            }
            case 26: {
                return pSSysReqModuleBase.getPSDevPrdVerName() == null;
            }
            case 27: {
                return pSSysReqModuleBase.getPSModuleId() == null;
            }
            case 28: {
                return pSSysReqModuleBase.getPSModuleName() == null;
            }
            case 29: {
                return pSSysReqModuleBase.getPSSysActorId() == null;
            }
            case 30: {
                return pSSysReqModuleBase.getPSSysActorName() == null;
            }
            case 31: {
                return pSSysReqModuleBase.getPSSysReqModuleId() == null;
            }
            case 32: {
                return pSSysReqModuleBase.getPSSysReqModuleName() == null;
            }
            case 33: {
                return pSSysReqModuleBase.getPSSystemId() == null;
            }
            case 34: {
                return pSSysReqModuleBase.getPSSystemName() == null;
            }
            case 35: {
                return pSSysReqModuleBase.getPSSysUseCaseId() == null;
            }
            case 36: {
                return pSSysReqModuleBase.getPSSysUseCaseName() == null;
            }
            case 37: {
                return pSSysReqModuleBase.getReqModel() == null;
            }
            case 38: {
                return pSSysReqModuleBase.getReqModelType() == null;
            }
            case 39: {
                return pSSysReqModuleBase.getSubject() == null;
            }
            case 40: {
                return pSSysReqModuleBase.getTags() == null;
            }
            case 41: {
                return pSSysReqModuleBase.getUpdateDate() == null;
            }
            case 42: {
                return pSSysReqModuleBase.getUpdateMan() == null;
            }
            case 43: {
                return pSSysReqModuleBase.getUserCat() == null;
            }
            case 44: {
                return pSSysReqModuleBase.getUserTag() == null;
            }
            case 45: {
                return pSSysReqModuleBase.getUserTag2() == null;
            }
            case 46: {
                return pSSysReqModuleBase.getUserTag3() == null;
            }
            case 47: {
                return pSSysReqModuleBase.getUserTag4() == null;
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
        return PSSysReqModuleBase.contains(this, n);
    }

    private static boolean contains(PSSysReqModuleBase pSSysReqModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysReqModuleBase.isAIBuildModeDirty();
            }
            case 1: {
                return pSSysReqModuleBase.isAIBuildStateDirty();
            }
            case 2: {
                return pSSysReqModuleBase.isAIChoicesDirty();
            }
            case 3: {
                return pSSysReqModuleBase.isAIPromptDirty();
            }
            case 4: {
                return pSSysReqModuleBase.isAIPromptChoicesDirty();
            }
            case 5: {
                return pSSysReqModuleBase.isAIPromptChoices2Dirty();
            }
            case 6: {
                return pSSysReqModuleBase.isAIPromptChoices3Dirty();
            }
            case 7: {
                return pSSysReqModuleBase.isAIPromptChoices4Dirty();
            }
            case 8: {
                return pSSysReqModuleBase.isCodeNameDirty();
            }
            case 9: {
                return pSSysReqModuleBase.isContentDirty();
            }
            case 10: {
                return pSSysReqModuleBase.isContentTypeDirty();
            }
            case 11: {
                return pSSysReqModuleBase.isCreateDateDirty();
            }
            case 12: {
                return pSSysReqModuleBase.isCreateManDirty();
            }
            case 13: {
                return pSSysReqModuleBase.isMemoDirty();
            }
            case 14: {
                return pSSysReqModuleBase.isModuleSNDirty();
            }
            case 15: {
                return pSSysReqModuleBase.isModuleTagDirty();
            }
            case 16: {
                return pSSysReqModuleBase.isModuleTag2Dirty();
            }
            case 17: {
                return pSSysReqModuleBase.isModuleTag3Dirty();
            }
            case 18: {
                return pSSysReqModuleBase.isModuleTag4Dirty();
            }
            case 19: {
                return pSSysReqModuleBase.isModuleTypeDirty();
            }
            case 20: {
                return pSSysReqModuleBase.isOrderValueDirty();
            }
            case 21: {
                return pSSysReqModuleBase.isPPSSysReqModuleIdDirty();
            }
            case 22: {
                return pSSysReqModuleBase.isPPSSysReqModuleNameDirty();
            }
            case 23: {
                return pSSysReqModuleBase.isPSDevPrdIdDirty();
            }
            case 24: {
                return pSSysReqModuleBase.isPSDevPrdNameDirty();
            }
            case 25: {
                return pSSysReqModuleBase.isPSDevPrdVerIdDirty();
            }
            case 26: {
                return pSSysReqModuleBase.isPSDevPrdVerNameDirty();
            }
            case 27: {
                return pSSysReqModuleBase.isPSModuleIdDirty();
            }
            case 28: {
                return pSSysReqModuleBase.isPSModuleNameDirty();
            }
            case 29: {
                return pSSysReqModuleBase.isPSSysActorIdDirty();
            }
            case 30: {
                return pSSysReqModuleBase.isPSSysActorNameDirty();
            }
            case 31: {
                return pSSysReqModuleBase.isPSSysReqModuleIdDirty();
            }
            case 32: {
                return pSSysReqModuleBase.isPSSysReqModuleNameDirty();
            }
            case 33: {
                return pSSysReqModuleBase.isPSSystemIdDirty();
            }
            case 34: {
                return pSSysReqModuleBase.isPSSystemNameDirty();
            }
            case 35: {
                return pSSysReqModuleBase.isPSSysUseCaseIdDirty();
            }
            case 36: {
                return pSSysReqModuleBase.isPSSysUseCaseNameDirty();
            }
            case 37: {
                return pSSysReqModuleBase.isReqModelDirty();
            }
            case 38: {
                return pSSysReqModuleBase.isReqModelTypeDirty();
            }
            case 39: {
                return pSSysReqModuleBase.isSubjectDirty();
            }
            case 40: {
                return pSSysReqModuleBase.isTagsDirty();
            }
            case 41: {
                return pSSysReqModuleBase.isUpdateDateDirty();
            }
            case 42: {
                return pSSysReqModuleBase.isUpdateManDirty();
            }
            case 43: {
                return pSSysReqModuleBase.isUserCatDirty();
            }
            case 44: {
                return pSSysReqModuleBase.isUserTagDirty();
            }
            case 45: {
                return pSSysReqModuleBase.isUserTag2Dirty();
            }
            case 46: {
                return pSSysReqModuleBase.isUserTag3Dirty();
            }
            case 47: {
                return pSSysReqModuleBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysReqModuleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysReqModuleBase pSSysReqModuleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysReqModuleBase.getAIBuildMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aibuildmode", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getAIBuildMode()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getAIBuildState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aibuildstate", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getAIBuildState()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getAIChoices() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aichoices", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getAIChoices()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getAIPrompt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aiprompt", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getAIPrompt()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getAIPromptChoices() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aipromptchoices", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getAIPromptChoices()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getAIPromptChoices2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aipromptchoices2", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getAIPromptChoices2()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getAIPromptChoices3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aipromptchoices3", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getAIPromptChoices3()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getAIPromptChoices4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aipromptchoices4", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getAIPromptChoices4()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getContent()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getContentType()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getModuleSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modulesn", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getModuleSN()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getModuleTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"moduletag", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getModuleTag()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getModuleTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"moduletag2", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getModuleTag2()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getModuleTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"moduletag3", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getModuleTag3()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getModuleTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"moduletag4", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getModuleTag4()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getModuleType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"moduletype", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getModuleType()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPPSSysReqModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysreqmoduleid", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPPSSysReqModuleId()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPPSSysReqModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysreqmodulename", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPPSSysReqModuleName()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPSDevPrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdid", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPSDevPrdId()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPSDevPrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdname", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPSDevPrdName()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPSDevPrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdverid", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPSDevPrdVerId()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPSDevPrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdvername", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPSDevPrdVerName()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPSSysActorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysactorid", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPSSysActorId()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPSSysActorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysactorname", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPSSysActorName()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPSSysReqModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqmoduleid", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPSSysReqModuleId()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPSSysReqModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqmodulename", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPSSysReqModuleName()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPSSysUseCaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusecaseid", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPSSysUseCaseId()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getPSSysUseCaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusecasename", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getPSSysUseCaseName()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getReqModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reqmodel", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getReqModel()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getReqModelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reqmodeltype", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getReqModelType()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getSubject() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subject", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getSubject()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tags", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getTags()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysReqModuleBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysReqModuleBase.getJSONValue((Object)pSSysReqModuleBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysReqModuleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysReqModuleBase pSSysReqModuleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysReqModuleBase.getAIBuildMode() != null) {
            object = pSSysReqModuleBase.getAIBuildMode();
            xmlNode.setAttribute(FIELD_AIBUILDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysReqModuleBase.getAIBuildState() != null) {
            object = pSSysReqModuleBase.getAIBuildState();
            xmlNode.setAttribute(FIELD_AIBUILDSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysReqModuleBase.getAIChoices() != null) {
            object = pSSysReqModuleBase.getAIChoices();
            xmlNode.setAttribute(FIELD_AICHOICES, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getAIPrompt() != null) {
            object = pSSysReqModuleBase.getAIPrompt();
            xmlNode.setAttribute(FIELD_AIPROMPT, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getAIPromptChoices() != null) {
            object = pSSysReqModuleBase.getAIPromptChoices();
            xmlNode.setAttribute(FIELD_AIPROMPTCHOICES, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getAIPromptChoices2() != null) {
            object = pSSysReqModuleBase.getAIPromptChoices2();
            xmlNode.setAttribute(FIELD_AIPROMPTCHOICES2, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getAIPromptChoices3() != null) {
            object = pSSysReqModuleBase.getAIPromptChoices3();
            xmlNode.setAttribute(FIELD_AIPROMPTCHOICES3, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getAIPromptChoices4() != null) {
            object = pSSysReqModuleBase.getAIPromptChoices4();
            xmlNode.setAttribute(FIELD_AIPROMPTCHOICES4, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getCodeName() != null) {
            object = pSSysReqModuleBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getContent() != null) {
            object = pSSysReqModuleBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getContentType() != null) {
            object = pSSysReqModuleBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getCreateDate() != null) {
            object = pSSysReqModuleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysReqModuleBase.getCreateMan() != null) {
            object = pSSysReqModuleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getMemo() != null) {
            object = pSSysReqModuleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getModuleSN() != null) {
            object = pSSysReqModuleBase.getModuleSN();
            xmlNode.setAttribute(FIELD_MODULESN, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getModuleTag() != null) {
            object = pSSysReqModuleBase.getModuleTag();
            xmlNode.setAttribute(FIELD_MODULETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getModuleTag2() != null) {
            object = pSSysReqModuleBase.getModuleTag2();
            xmlNode.setAttribute(FIELD_MODULETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getModuleTag3() != null) {
            object = pSSysReqModuleBase.getModuleTag3();
            xmlNode.setAttribute(FIELD_MODULETAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getModuleTag4() != null) {
            object = pSSysReqModuleBase.getModuleTag4();
            xmlNode.setAttribute(FIELD_MODULETAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getModuleType() != null) {
            object = pSSysReqModuleBase.getModuleType();
            xmlNode.setAttribute(FIELD_MODULETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getOrderValue() != null) {
            object = pSSysReqModuleBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysReqModuleBase.getPPSSysReqModuleId() != null) {
            object = pSSysReqModuleBase.getPPSSysReqModuleId();
            xmlNode.setAttribute(FIELD_PPSSYSREQMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getPPSSysReqModuleName() != null) {
            object = pSSysReqModuleBase.getPPSSysReqModuleName();
            xmlNode.setAttribute(FIELD_PPSSYSREQMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getPSDevPrdId() != null) {
            object = pSSysReqModuleBase.getPSDevPrdId();
            xmlNode.setAttribute(FIELD_PSDEVPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getPSDevPrdName() != null) {
            object = pSSysReqModuleBase.getPSDevPrdName();
            xmlNode.setAttribute(FIELD_PSDEVPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getPSDevPrdVerId() != null) {
            object = pSSysReqModuleBase.getPSDevPrdVerId();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getPSDevPrdVerName() != null) {
            object = pSSysReqModuleBase.getPSDevPrdVerName();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getPSModuleId() != null) {
            object = pSSysReqModuleBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getPSModuleName() != null) {
            object = pSSysReqModuleBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getPSSysActorId() != null) {
            object = pSSysReqModuleBase.getPSSysActorId();
            xmlNode.setAttribute(FIELD_PSSYSACTORID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getPSSysActorName() != null) {
            object = pSSysReqModuleBase.getPSSysActorName();
            xmlNode.setAttribute(FIELD_PSSYSACTORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getPSSysReqModuleId() != null) {
            object = pSSysReqModuleBase.getPSSysReqModuleId();
            xmlNode.setAttribute(FIELD_PSSYSREQMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getPSSysReqModuleName() != null) {
            object = pSSysReqModuleBase.getPSSysReqModuleName();
            xmlNode.setAttribute(FIELD_PSSYSREQMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getPSSystemId() != null) {
            object = pSSysReqModuleBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getPSSystemName() != null) {
            object = pSSysReqModuleBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getPSSysUseCaseId() != null) {
            object = pSSysReqModuleBase.getPSSysUseCaseId();
            xmlNode.setAttribute(FIELD_PSSYSUSECASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getPSSysUseCaseName() != null) {
            object = pSSysReqModuleBase.getPSSysUseCaseName();
            xmlNode.setAttribute(FIELD_PSSYSUSECASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getReqModel() != null) {
            object = pSSysReqModuleBase.getReqModel();
            xmlNode.setAttribute(FIELD_REQMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getReqModelType() != null) {
            object = pSSysReqModuleBase.getReqModelType();
            xmlNode.setAttribute(FIELD_REQMODELTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getSubject() != null) {
            object = pSSysReqModuleBase.getSubject();
            xmlNode.setAttribute(FIELD_SUBJECT, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getTags() != null) {
            object = pSSysReqModuleBase.getTags();
            xmlNode.setAttribute(FIELD_TAGS, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getUpdateDate() != null) {
            object = pSSysReqModuleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysReqModuleBase.getUpdateMan() != null) {
            object = pSSysReqModuleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getUserCat() != null) {
            object = pSSysReqModuleBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getUserTag() != null) {
            object = pSSysReqModuleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getUserTag2() != null) {
            object = pSSysReqModuleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getUserTag3() != null) {
            object = pSSysReqModuleBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqModuleBase.getUserTag4() != null) {
            object = pSSysReqModuleBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysReqModuleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysReqModuleBase pSSysReqModuleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysReqModuleBase.isAIBuildModeDirty() && (bl || pSSysReqModuleBase.getAIBuildMode() != null)) {
            iDataObject.set(FIELD_AIBUILDMODE, (Object)pSSysReqModuleBase.getAIBuildMode());
        }
        if (pSSysReqModuleBase.isAIBuildStateDirty() && (bl || pSSysReqModuleBase.getAIBuildState() != null)) {
            iDataObject.set(FIELD_AIBUILDSTATE, (Object)pSSysReqModuleBase.getAIBuildState());
        }
        if (pSSysReqModuleBase.isAIChoicesDirty() && (bl || pSSysReqModuleBase.getAIChoices() != null)) {
            iDataObject.set(FIELD_AICHOICES, (Object)pSSysReqModuleBase.getAIChoices());
        }
        if (pSSysReqModuleBase.isAIPromptDirty() && (bl || pSSysReqModuleBase.getAIPrompt() != null)) {
            iDataObject.set(FIELD_AIPROMPT, (Object)pSSysReqModuleBase.getAIPrompt());
        }
        if (pSSysReqModuleBase.isAIPromptChoicesDirty() && (bl || pSSysReqModuleBase.getAIPromptChoices() != null)) {
            iDataObject.set(FIELD_AIPROMPTCHOICES, (Object)pSSysReqModuleBase.getAIPromptChoices());
        }
        if (pSSysReqModuleBase.isAIPromptChoices2Dirty() && (bl || pSSysReqModuleBase.getAIPromptChoices2() != null)) {
            iDataObject.set(FIELD_AIPROMPTCHOICES2, (Object)pSSysReqModuleBase.getAIPromptChoices2());
        }
        if (pSSysReqModuleBase.isAIPromptChoices3Dirty() && (bl || pSSysReqModuleBase.getAIPromptChoices3() != null)) {
            iDataObject.set(FIELD_AIPROMPTCHOICES3, (Object)pSSysReqModuleBase.getAIPromptChoices3());
        }
        if (pSSysReqModuleBase.isAIPromptChoices4Dirty() && (bl || pSSysReqModuleBase.getAIPromptChoices4() != null)) {
            iDataObject.set(FIELD_AIPROMPTCHOICES4, (Object)pSSysReqModuleBase.getAIPromptChoices4());
        }
        if (pSSysReqModuleBase.isCodeNameDirty() && (bl || pSSysReqModuleBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysReqModuleBase.getCodeName());
        }
        if (pSSysReqModuleBase.isContentDirty() && (bl || pSSysReqModuleBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSSysReqModuleBase.getContent());
        }
        if (pSSysReqModuleBase.isContentTypeDirty() && (bl || pSSysReqModuleBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSSysReqModuleBase.getContentType());
        }
        if (pSSysReqModuleBase.isCreateDateDirty() && (bl || pSSysReqModuleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysReqModuleBase.getCreateDate());
        }
        if (pSSysReqModuleBase.isCreateManDirty() && (bl || pSSysReqModuleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysReqModuleBase.getCreateMan());
        }
        if (pSSysReqModuleBase.isMemoDirty() && (bl || pSSysReqModuleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysReqModuleBase.getMemo());
        }
        if (pSSysReqModuleBase.isModuleSNDirty() && (bl || pSSysReqModuleBase.getModuleSN() != null)) {
            iDataObject.set(FIELD_MODULESN, (Object)pSSysReqModuleBase.getModuleSN());
        }
        if (pSSysReqModuleBase.isModuleTagDirty() && (bl || pSSysReqModuleBase.getModuleTag() != null)) {
            iDataObject.set(FIELD_MODULETAG, (Object)pSSysReqModuleBase.getModuleTag());
        }
        if (pSSysReqModuleBase.isModuleTag2Dirty() && (bl || pSSysReqModuleBase.getModuleTag2() != null)) {
            iDataObject.set(FIELD_MODULETAG2, (Object)pSSysReqModuleBase.getModuleTag2());
        }
        if (pSSysReqModuleBase.isModuleTag3Dirty() && (bl || pSSysReqModuleBase.getModuleTag3() != null)) {
            iDataObject.set(FIELD_MODULETAG3, (Object)pSSysReqModuleBase.getModuleTag3());
        }
        if (pSSysReqModuleBase.isModuleTag4Dirty() && (bl || pSSysReqModuleBase.getModuleTag4() != null)) {
            iDataObject.set(FIELD_MODULETAG4, (Object)pSSysReqModuleBase.getModuleTag4());
        }
        if (pSSysReqModuleBase.isModuleTypeDirty() && (bl || pSSysReqModuleBase.getModuleType() != null)) {
            iDataObject.set(FIELD_MODULETYPE, (Object)pSSysReqModuleBase.getModuleType());
        }
        if (pSSysReqModuleBase.isOrderValueDirty() && (bl || pSSysReqModuleBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysReqModuleBase.getOrderValue());
        }
        if (pSSysReqModuleBase.isPPSSysReqModuleIdDirty() && (bl || pSSysReqModuleBase.getPPSSysReqModuleId() != null)) {
            iDataObject.set(FIELD_PPSSYSREQMODULEID, (Object)pSSysReqModuleBase.getPPSSysReqModuleId());
        }
        if (pSSysReqModuleBase.isPPSSysReqModuleNameDirty() && (bl || pSSysReqModuleBase.getPPSSysReqModuleName() != null)) {
            iDataObject.set(FIELD_PPSSYSREQMODULENAME, (Object)pSSysReqModuleBase.getPPSSysReqModuleName());
        }
        if (pSSysReqModuleBase.isPSDevPrdIdDirty() && (bl || pSSysReqModuleBase.getPSDevPrdId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDID, (Object)pSSysReqModuleBase.getPSDevPrdId());
        }
        if (pSSysReqModuleBase.isPSDevPrdNameDirty() && (bl || pSSysReqModuleBase.getPSDevPrdName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDNAME, (Object)pSSysReqModuleBase.getPSDevPrdName());
        }
        if (pSSysReqModuleBase.isPSDevPrdVerIdDirty() && (bl || pSSysReqModuleBase.getPSDevPrdVerId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERID, (Object)pSSysReqModuleBase.getPSDevPrdVerId());
        }
        if (pSSysReqModuleBase.isPSDevPrdVerNameDirty() && (bl || pSSysReqModuleBase.getPSDevPrdVerName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERNAME, (Object)pSSysReqModuleBase.getPSDevPrdVerName());
        }
        if (pSSysReqModuleBase.isPSModuleIdDirty() && (bl || pSSysReqModuleBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysReqModuleBase.getPSModuleId());
        }
        if (pSSysReqModuleBase.isPSModuleNameDirty() && (bl || pSSysReqModuleBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysReqModuleBase.getPSModuleName());
        }
        if (pSSysReqModuleBase.isPSSysActorIdDirty() && (bl || pSSysReqModuleBase.getPSSysActorId() != null)) {
            iDataObject.set(FIELD_PSSYSACTORID, (Object)pSSysReqModuleBase.getPSSysActorId());
        }
        if (pSSysReqModuleBase.isPSSysActorNameDirty() && (bl || pSSysReqModuleBase.getPSSysActorName() != null)) {
            iDataObject.set(FIELD_PSSYSACTORNAME, (Object)pSSysReqModuleBase.getPSSysActorName());
        }
        if (pSSysReqModuleBase.isPSSysReqModuleIdDirty() && (bl || pSSysReqModuleBase.getPSSysReqModuleId() != null)) {
            iDataObject.set(FIELD_PSSYSREQMODULEID, (Object)pSSysReqModuleBase.getPSSysReqModuleId());
        }
        if (pSSysReqModuleBase.isPSSysReqModuleNameDirty() && (bl || pSSysReqModuleBase.getPSSysReqModuleName() != null)) {
            iDataObject.set(FIELD_PSSYSREQMODULENAME, (Object)pSSysReqModuleBase.getPSSysReqModuleName());
        }
        if (pSSysReqModuleBase.isPSSystemIdDirty() && (bl || pSSysReqModuleBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysReqModuleBase.getPSSystemId());
        }
        if (pSSysReqModuleBase.isPSSystemNameDirty() && (bl || pSSysReqModuleBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysReqModuleBase.getPSSystemName());
        }
        if (pSSysReqModuleBase.isPSSysUseCaseIdDirty() && (bl || pSSysReqModuleBase.getPSSysUseCaseId() != null)) {
            iDataObject.set(FIELD_PSSYSUSECASEID, (Object)pSSysReqModuleBase.getPSSysUseCaseId());
        }
        if (pSSysReqModuleBase.isPSSysUseCaseNameDirty() && (bl || pSSysReqModuleBase.getPSSysUseCaseName() != null)) {
            iDataObject.set(FIELD_PSSYSUSECASENAME, (Object)pSSysReqModuleBase.getPSSysUseCaseName());
        }
        if (pSSysReqModuleBase.isReqModelDirty() && (bl || pSSysReqModuleBase.getReqModel() != null)) {
            iDataObject.set(FIELD_REQMODEL, (Object)pSSysReqModuleBase.getReqModel());
        }
        if (pSSysReqModuleBase.isReqModelTypeDirty() && (bl || pSSysReqModuleBase.getReqModelType() != null)) {
            iDataObject.set(FIELD_REQMODELTYPE, (Object)pSSysReqModuleBase.getReqModelType());
        }
        if (pSSysReqModuleBase.isSubjectDirty() && (bl || pSSysReqModuleBase.getSubject() != null)) {
            iDataObject.set(FIELD_SUBJECT, (Object)pSSysReqModuleBase.getSubject());
        }
        if (pSSysReqModuleBase.isTagsDirty() && (bl || pSSysReqModuleBase.getTags() != null)) {
            iDataObject.set(FIELD_TAGS, (Object)pSSysReqModuleBase.getTags());
        }
        if (pSSysReqModuleBase.isUpdateDateDirty() && (bl || pSSysReqModuleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysReqModuleBase.getUpdateDate());
        }
        if (pSSysReqModuleBase.isUpdateManDirty() && (bl || pSSysReqModuleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysReqModuleBase.getUpdateMan());
        }
        if (pSSysReqModuleBase.isUserCatDirty() && (bl || pSSysReqModuleBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysReqModuleBase.getUserCat());
        }
        if (pSSysReqModuleBase.isUserTagDirty() && (bl || pSSysReqModuleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysReqModuleBase.getUserTag());
        }
        if (pSSysReqModuleBase.isUserTag2Dirty() && (bl || pSSysReqModuleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysReqModuleBase.getUserTag2());
        }
        if (pSSysReqModuleBase.isUserTag3Dirty() && (bl || pSSysReqModuleBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysReqModuleBase.getUserTag3());
        }
        if (pSSysReqModuleBase.isUserTag4Dirty() && (bl || pSSysReqModuleBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysReqModuleBase.getUserTag4());
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
        return PSSysReqModuleBase.remove(this, n);
    }

    private static boolean remove(PSSysReqModuleBase pSSysReqModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysReqModuleBase.resetAIBuildMode();
                return true;
            }
            case 1: {
                pSSysReqModuleBase.resetAIBuildState();
                return true;
            }
            case 2: {
                pSSysReqModuleBase.resetAIChoices();
                return true;
            }
            case 3: {
                pSSysReqModuleBase.resetAIPrompt();
                return true;
            }
            case 4: {
                pSSysReqModuleBase.resetAIPromptChoices();
                return true;
            }
            case 5: {
                pSSysReqModuleBase.resetAIPromptChoices2();
                return true;
            }
            case 6: {
                pSSysReqModuleBase.resetAIPromptChoices3();
                return true;
            }
            case 7: {
                pSSysReqModuleBase.resetAIPromptChoices4();
                return true;
            }
            case 8: {
                pSSysReqModuleBase.resetCodeName();
                return true;
            }
            case 9: {
                pSSysReqModuleBase.resetContent();
                return true;
            }
            case 10: {
                pSSysReqModuleBase.resetContentType();
                return true;
            }
            case 11: {
                pSSysReqModuleBase.resetCreateDate();
                return true;
            }
            case 12: {
                pSSysReqModuleBase.resetCreateMan();
                return true;
            }
            case 13: {
                pSSysReqModuleBase.resetMemo();
                return true;
            }
            case 14: {
                pSSysReqModuleBase.resetModuleSN();
                return true;
            }
            case 15: {
                pSSysReqModuleBase.resetModuleTag();
                return true;
            }
            case 16: {
                pSSysReqModuleBase.resetModuleTag2();
                return true;
            }
            case 17: {
                pSSysReqModuleBase.resetModuleTag3();
                return true;
            }
            case 18: {
                pSSysReqModuleBase.resetModuleTag4();
                return true;
            }
            case 19: {
                pSSysReqModuleBase.resetModuleType();
                return true;
            }
            case 20: {
                pSSysReqModuleBase.resetOrderValue();
                return true;
            }
            case 21: {
                pSSysReqModuleBase.resetPPSSysReqModuleId();
                return true;
            }
            case 22: {
                pSSysReqModuleBase.resetPPSSysReqModuleName();
                return true;
            }
            case 23: {
                pSSysReqModuleBase.resetPSDevPrdId();
                return true;
            }
            case 24: {
                pSSysReqModuleBase.resetPSDevPrdName();
                return true;
            }
            case 25: {
                pSSysReqModuleBase.resetPSDevPrdVerId();
                return true;
            }
            case 26: {
                pSSysReqModuleBase.resetPSDevPrdVerName();
                return true;
            }
            case 27: {
                pSSysReqModuleBase.resetPSModuleId();
                return true;
            }
            case 28: {
                pSSysReqModuleBase.resetPSModuleName();
                return true;
            }
            case 29: {
                pSSysReqModuleBase.resetPSSysActorId();
                return true;
            }
            case 30: {
                pSSysReqModuleBase.resetPSSysActorName();
                return true;
            }
            case 31: {
                pSSysReqModuleBase.resetPSSysReqModuleId();
                return true;
            }
            case 32: {
                pSSysReqModuleBase.resetPSSysReqModuleName();
                return true;
            }
            case 33: {
                pSSysReqModuleBase.resetPSSystemId();
                return true;
            }
            case 34: {
                pSSysReqModuleBase.resetPSSystemName();
                return true;
            }
            case 35: {
                pSSysReqModuleBase.resetPSSysUseCaseId();
                return true;
            }
            case 36: {
                pSSysReqModuleBase.resetPSSysUseCaseName();
                return true;
            }
            case 37: {
                pSSysReqModuleBase.resetReqModel();
                return true;
            }
            case 38: {
                pSSysReqModuleBase.resetReqModelType();
                return true;
            }
            case 39: {
                pSSysReqModuleBase.resetSubject();
                return true;
            }
            case 40: {
                pSSysReqModuleBase.resetTags();
                return true;
            }
            case 41: {
                pSSysReqModuleBase.resetUpdateDate();
                return true;
            }
            case 42: {
                pSSysReqModuleBase.resetUpdateMan();
                return true;
            }
            case 43: {
                pSSysReqModuleBase.resetUserCat();
                return true;
            }
            case 44: {
                pSSysReqModuleBase.resetUserTag();
                return true;
            }
            case 45: {
                pSSysReqModuleBase.resetUserTag2();
                return true;
            }
            case 46: {
                pSSysReqModuleBase.resetUserTag3();
                return true;
            }
            case 47: {
                pSSysReqModuleBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdVer getPSDevPrdVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdVer();
        }
        if (this.getPSDevPrdVerId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdVerLock;
        synchronized (n) {
            if (this.psdevprdver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdVerId(), (Object)this.psdevprdver.getPSDevPrdVerId()) != 0L) {
                this.psdevprdver = null;
            }
            if (this.psdevprdver == null) {
                PSDevPrdVer pSDevPrdVer = new PSDevPrdVer();
                pSDevPrdVer.setPSDevPrdVerId(this.getPSDevPrdVerId());
                PSDevPrdVerService pSDevPrdVerService = (PSDevPrdVerService)ServiceGlobal.getService(PSDevPrdVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdVerService.autoGet((IEntity)pSDevPrdVer);
                this.psdevprdver = pSDevPrdVer;
            }
            return this.psdevprdver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrd getPSDevPrd() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrd();
        }
        if (this.getPSDevPrdId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdLock;
        synchronized (n) {
            if (this.psdevprd != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdId(), (Object)this.psdevprd.getPSDevPrdId()) != 0L) {
                this.psdevprd = null;
            }
            if (this.psdevprd == null) {
                PSDevPrd pSDevPrd = new PSDevPrd();
                pSDevPrd.setPSDevPrdId(this.getPSDevPrdId());
                PSDevPrdService pSDevPrdService = (PSDevPrdService)ServiceGlobal.getService(PSDevPrdService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdService.autoGet((IEntity)pSDevPrd);
                this.psdevprd = pSDevPrd;
            }
            return this.psdevprd;
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
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysActor getPSSysActor() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysActor();
        }
        if (this.getPSSysActorId() == null) {
            return null;
        }
        Integer n = this.objPSSysActorLock;
        synchronized (n) {
            if (this.pssysactor != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysActorId(), (Object)this.pssysactor.getPSSysActorId()) != 0L) {
                this.pssysactor = null;
            }
            if (this.pssysactor == null) {
                PSSysActor pSSysActor = new PSSysActor();
                pSSysActor.setPSSysActorId(this.getPSSysActorId());
                PSSysActorService pSSysActorService = (PSSysActorService)ServiceGlobal.getService(PSSysActorService.class, (SessionFactory)this.getSessionFactory());
                pSSysActorService.autoGet((IEntity)pSSysActor);
                this.pssysactor = pSSysActor;
            }
            return this.pssysactor;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqModule getPPSysReqModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSysReqModule();
        }
        if (this.getPPSSysReqModuleId() == null) {
            return null;
        }
        Integer n = this.objPPSysReqModuleLock;
        synchronized (n) {
            if (this.ppsysreqmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysReqModuleId(), (Object)this.ppsysreqmodule.getPSSysReqModuleId()) != 0L) {
                this.ppsysreqmodule = null;
            }
            if (this.ppsysreqmodule == null) {
                PSSysReqModule pSSysReqModule = new PSSysReqModule();
                pSSysReqModule.setPSSysReqModuleId(this.getPPSSysReqModuleId());
                PSSysReqModuleService pSSysReqModuleService = (PSSysReqModuleService)ServiceGlobal.getService(PSSysReqModuleService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqModuleService.autoGet((IEntity)pSSysReqModule);
                this.ppsysreqmodule = pSSysReqModule;
            }
            return this.ppsysreqmodule;
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
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUserCase getPSSysUseCase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUseCase();
        }
        if (this.getPSSysUseCaseId() == null) {
            return null;
        }
        Integer n = this.objPSSysUseCaseLock;
        synchronized (n) {
            if (this.pssysusecase != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUseCaseId(), (Object)this.pssysusecase.getPSSysUserCaseId()) != 0L) {
                this.pssysusecase = null;
            }
            if (this.pssysusecase == null) {
                PSSysUserCase pSSysUserCase = new PSSysUserCase();
                pSSysUserCase.setPSSysUserCaseId(this.getPSSysUseCaseId());
                PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
                pSSysUserCaseService.autoGet((IEntity)pSSysUserCase);
                this.pssysusecase = pSSysUserCase;
            }
            return this.pssysusecase;
        }
    }

    private PSSysReqModuleBase getProxyEntity() {
        return this.proxyPSSysReqModuleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysReqModuleBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysReqModuleBase) {
            this.proxyPSSysReqModuleBase = (PSSysReqModuleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqModuleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AIBUILDMODE, 0);
        fieldIndexMap.put(FIELD_AIBUILDSTATE, 1);
        fieldIndexMap.put(FIELD_AICHOICES, 2);
        fieldIndexMap.put(FIELD_AIPROMPT, 3);
        fieldIndexMap.put(FIELD_AIPROMPTCHOICES, 4);
        fieldIndexMap.put(FIELD_AIPROMPTCHOICES2, 5);
        fieldIndexMap.put(FIELD_AIPROMPTCHOICES3, 6);
        fieldIndexMap.put(FIELD_AIPROMPTCHOICES4, 7);
        fieldIndexMap.put(FIELD_CODENAME, 8);
        fieldIndexMap.put(FIELD_CONTENT, 9);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 10);
        fieldIndexMap.put(FIELD_CREATEDATE, 11);
        fieldIndexMap.put(FIELD_CREATEMAN, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_MODULESN, 14);
        fieldIndexMap.put(FIELD_MODULETAG, 15);
        fieldIndexMap.put(FIELD_MODULETAG2, 16);
        fieldIndexMap.put(FIELD_MODULETAG3, 17);
        fieldIndexMap.put(FIELD_MODULETAG4, 18);
        fieldIndexMap.put(FIELD_MODULETYPE, 19);
        fieldIndexMap.put(FIELD_ORDERVALUE, 20);
        fieldIndexMap.put(FIELD_PPSSYSREQMODULEID, 21);
        fieldIndexMap.put(FIELD_PPSSYSREQMODULENAME, 22);
        fieldIndexMap.put(FIELD_PSDEVPRDID, 23);
        fieldIndexMap.put(FIELD_PSDEVPRDNAME, 24);
        fieldIndexMap.put(FIELD_PSDEVPRDVERID, 25);
        fieldIndexMap.put(FIELD_PSDEVPRDVERNAME, 26);
        fieldIndexMap.put(FIELD_PSMODULEID, 27);
        fieldIndexMap.put(FIELD_PSMODULENAME, 28);
        fieldIndexMap.put(FIELD_PSSYSACTORID, 29);
        fieldIndexMap.put(FIELD_PSSYSACTORNAME, 30);
        fieldIndexMap.put(FIELD_PSSYSREQMODULEID, 31);
        fieldIndexMap.put(FIELD_PSSYSREQMODULENAME, 32);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 33);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 34);
        fieldIndexMap.put(FIELD_PSSYSUSECASEID, 35);
        fieldIndexMap.put(FIELD_PSSYSUSECASENAME, 36);
        fieldIndexMap.put(FIELD_REQMODEL, 37);
        fieldIndexMap.put(FIELD_REQMODELTYPE, 38);
        fieldIndexMap.put(FIELD_SUBJECT, 39);
        fieldIndexMap.put(FIELD_TAGS, 40);
        fieldIndexMap.put(FIELD_UPDATEDATE, 41);
        fieldIndexMap.put(FIELD_UPDATEMAN, 42);
        fieldIndexMap.put(FIELD_USERCAT, 43);
        fieldIndexMap.put(FIELD_USERTAG, 44);
        fieldIndexMap.put(FIELD_USERTAG2, 45);
        fieldIndexMap.put(FIELD_USERTAG3, 46);
        fieldIndexMap.put(FIELD_USERTAG4, 47);
    }
}

