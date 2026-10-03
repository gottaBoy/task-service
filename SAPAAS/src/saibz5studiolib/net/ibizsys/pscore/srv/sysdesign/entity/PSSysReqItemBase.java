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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSpec;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemData;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemHis;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemDataService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemHisService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysReqItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysReqItemBase.class);
    public static final String FIELD_AIBUILDMODE = "AIBUILDMODE";
    public static final String FIELD_AIBUILDPARAMS = "AIBUILDPARAMS";
    public static final String FIELD_AIBUILDSTATE = "AIBUILDSTATE";
    public static final String FIELD_AICHOICES = "AICHOICES";
    public static final String FIELD_AIPROMPT = "AIPROMPT";
    public static final String FIELD_AIPROMPTCHOICES = "AIPROMPTCHOICES";
    public static final String FIELD_AIPROMPTCHOICES2 = "AIPROMPTCHOICES2";
    public static final String FIELD_AIPROMPTCHOICES3 = "AIPROMPTCHOICES3";
    public static final String FIELD_AIPROMPTCHOICES4 = "AIPROMPTCHOICES4";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ITEMSN = "ITEMSN";
    public static final String FIELD_ITEMTAG = "ITEMTAG";
    public static final String FIELD_ITEMTAG2 = "ITEMTAG2";
    public static final String FIELD_ITEMTAG3 = "ITEMTAG3";
    public static final String FIELD_ITEMTAG4 = "ITEMTAG4";
    public static final String FIELD_ITEMTYPE = "ITEMTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSSYSREQITEMID = "PPSSYSREQITEMID";
    public static final String FIELD_PPSSYSREQITEMNAME = "PPSSYSREQITEMNAME";
    public static final String FIELD_PSDEVPRDID = "PSDEVPRDID";
    public static final String FIELD_PSDEVPRDNAME = "PSDEVPRDNAME";
    public static final String FIELD_PSDEVPRDSPECID = "PSDEVPRDSPECID";
    public static final String FIELD_PSDEVPRDSPECNAME = "PSDEVPRDSPECNAME";
    public static final String FIELD_PSDEVPRDVERID = "PSDEVPRDVERID";
    public static final String FIELD_PSDEVPRDVERNAME = "PSDEVPRDVERNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSREQITEMDATASCNT = "PSSYSREQITEMDATASCNT";
    public static final String FIELD_PSSYSREQITEMHISESCNT = "PSSYSREQITEMHISESCNT";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSREQMODULEID = "PSSYSREQMODULEID";
    public static final String FIELD_PSSYSREQMODULENAME = "PSSYSREQMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUSERCASEID = "PSSYSUSERCASEID";
    public static final String FIELD_PSSYSUSERCASENAME = "PSSYSUSERCASENAME";
    public static final String FIELD_REQCONTENT = "REQCONTENT";
    public static final String FIELD_REQMODEL = "REQMODEL";
    public static final String FIELD_REQMODELTYPE = "REQMODELTYPE";
    public static final String FIELD_SUBJECT = "SUBJECT";
    public static final String FIELD_SYNCMODELMODE = "SYNCMODELMODE";
    public static final String FIELD_TAGS = "TAGS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VER = "VER";
    private static final int INDEX_AIBUILDMODE = 0;
    private static final int INDEX_AIBUILDPARAMS = 1;
    private static final int INDEX_AIBUILDSTATE = 2;
    private static final int INDEX_AICHOICES = 3;
    private static final int INDEX_AIPROMPT = 4;
    private static final int INDEX_AIPROMPTCHOICES = 5;
    private static final int INDEX_AIPROMPTCHOICES2 = 6;
    private static final int INDEX_AIPROMPTCHOICES3 = 7;
    private static final int INDEX_AIPROMPTCHOICES4 = 8;
    private static final int INDEX_CODENAME = 9;
    private static final int INDEX_CREATEDATE = 10;
    private static final int INDEX_CREATEMAN = 11;
    private static final int INDEX_ITEMSN = 12;
    private static final int INDEX_ITEMTAG = 13;
    private static final int INDEX_ITEMTAG2 = 14;
    private static final int INDEX_ITEMTAG3 = 15;
    private static final int INDEX_ITEMTAG4 = 16;
    private static final int INDEX_ITEMTYPE = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_ORDERVALUE = 19;
    private static final int INDEX_PPSSYSREQITEMID = 20;
    private static final int INDEX_PPSSYSREQITEMNAME = 21;
    private static final int INDEX_PSDEVPRDID = 22;
    private static final int INDEX_PSDEVPRDNAME = 23;
    private static final int INDEX_PSDEVPRDSPECID = 24;
    private static final int INDEX_PSDEVPRDSPECNAME = 25;
    private static final int INDEX_PSDEVPRDVERID = 26;
    private static final int INDEX_PSDEVPRDVERNAME = 27;
    private static final int INDEX_PSMODULEID = 28;
    private static final int INDEX_PSMODULENAME = 29;
    private static final int INDEX_PSSYSREQITEMDATASCNT = 30;
    private static final int INDEX_PSSYSREQITEMHISESCNT = 31;
    private static final int INDEX_PSSYSREQITEMID = 32;
    private static final int INDEX_PSSYSREQITEMNAME = 33;
    private static final int INDEX_PSSYSREQMODULEID = 34;
    private static final int INDEX_PSSYSREQMODULENAME = 35;
    private static final int INDEX_PSSYSTEMID = 36;
    private static final int INDEX_PSSYSTEMNAME = 37;
    private static final int INDEX_PSSYSUSERCASEID = 38;
    private static final int INDEX_PSSYSUSERCASENAME = 39;
    private static final int INDEX_REQCONTENT = 40;
    private static final int INDEX_REQMODEL = 41;
    private static final int INDEX_REQMODELTYPE = 42;
    private static final int INDEX_SUBJECT = 43;
    private static final int INDEX_SYNCMODELMODE = 44;
    private static final int INDEX_TAGS = 45;
    private static final int INDEX_UPDATEDATE = 46;
    private static final int INDEX_UPDATEMAN = 47;
    private static final int INDEX_USERCAT = 48;
    private static final int INDEX_USERTAG = 49;
    private static final int INDEX_USERTAG2 = 50;
    private static final int INDEX_USERTAG3 = 51;
    private static final int INDEX_USERTAG4 = 52;
    private static final int INDEX_VALIDFLAG = 53;
    private static final int INDEX_VER = 54;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysReqItemBase proxyPSSysReqItemBase = null;
    private boolean aibuildmodeDirtyFlag = false;
    private boolean aibuildparamsDirtyFlag = false;
    private boolean aibuildstateDirtyFlag = false;
    private boolean aichoicesDirtyFlag = false;
    private boolean aipromptDirtyFlag = false;
    private boolean aipromptchoicesDirtyFlag = false;
    private boolean aipromptchoices2DirtyFlag = false;
    private boolean aipromptchoices3DirtyFlag = false;
    private boolean aipromptchoices4DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean itemsnDirtyFlag = false;
    private boolean itemtagDirtyFlag = false;
    private boolean itemtag2DirtyFlag = false;
    private boolean itemtag3DirtyFlag = false;
    private boolean itemtag4DirtyFlag = false;
    private boolean itemtypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppssysreqitemidDirtyFlag = false;
    private boolean ppssysreqitemnameDirtyFlag = false;
    private boolean psdevprdidDirtyFlag = false;
    private boolean psdevprdnameDirtyFlag = false;
    private boolean psdevprdspecidDirtyFlag = false;
    private boolean psdevprdspecnameDirtyFlag = false;
    private boolean psdevprdveridDirtyFlag = false;
    private boolean psdevprdvernameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysreqitemdatascntDirtyFlag = false;
    private boolean pssysreqitemhisescntDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssysreqmoduleidDirtyFlag = false;
    private boolean pssysreqmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysusercaseidDirtyFlag = false;
    private boolean pssysusercasenameDirtyFlag = false;
    private boolean reqcontentDirtyFlag = false;
    private boolean reqmodelDirtyFlag = false;
    private boolean reqmodeltypeDirtyFlag = false;
    private boolean subjectDirtyFlag = false;
    private boolean syncmodelmodeDirtyFlag = false;
    private boolean tagsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean verDirtyFlag = false;
    @Column(name="aibuildmode")
    private Integer aibuildmode;
    @Column(name="aibuildparams")
    private String aibuildparams;
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
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="itemsn")
    private String itemsn;
    @Column(name="itemtag")
    private String itemtag;
    @Column(name="itemtag2")
    private String itemtag2;
    @Column(name="itemtag3")
    private String itemtag3;
    @Column(name="itemtag4")
    private String itemtag4;
    @Column(name="itemtype")
    private String itemtype;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppssysreqitemid")
    private String ppssysreqitemid;
    @Column(name="ppssysreqitemname")
    private String ppssysreqitemname;
    @Column(name="psdevprdid")
    private String psdevprdid;
    @Column(name="psdevprdname")
    private String psdevprdname;
    @Column(name="psdevprdspecid")
    private String psdevprdspecid;
    @Column(name="psdevprdspecname")
    private String psdevprdspecname;
    @Column(name="psdevprdverid")
    private String psdevprdverid;
    @Column(name="psdevprdvername")
    private String psdevprdvername;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysreqitemdatascnt")
    private Integer pssysreqitemdatascnt;
    @Column(name="pssysreqitemhisescnt")
    private Integer pssysreqitemhisescnt;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssysreqmoduleid")
    private String pssysreqmoduleid;
    @Column(name="pssysreqmodulename")
    private String pssysreqmodulename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysusercaseid")
    private String pssysusercaseid;
    @Column(name="pssysusercasename")
    private String pssysusercasename;
    @Column(name="reqcontent")
    private String reqcontent;
    @Column(name="reqmodel")
    private String reqmodel;
    @Column(name="reqmodeltype")
    private String reqmodeltype;
    @Column(name="subject")
    private String subject;
    @Column(name="syncmodelmode")
    private String syncmodelmode;
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
    @Column(name="ver")
    private Integer ver;
    private Integer objPSDevPrdSpecLock = new Integer(1);
    private PSDevPrdSpec psdevprdspec = null;
    private Integer objPSDevPrdVerLock = new Integer(1);
    private PSDevPrdVer psdevprdver = null;
    private Integer objPSDevPrdLock = new Integer(1);
    private PSDevPrd psdevprd = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPPSysReqItemLock = new Integer(1);
    private PSSysReqItem ppsysreqitem = null;
    private Integer objPSSysReqModuleLock = new Integer(1);
    private PSSysReqModule pssysreqmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUserCaseLock = new Integer(1);
    private PSSysUserCase pssysusercase = null;
    private Integer objPSSysReqItemDatasLock = new Integer(1);
    private ArrayList<PSSysReqItemData> pssysreqitemdatas = null;
    private Integer objPSSysReqItemHisesLock = new Integer(1);
    private ArrayList<PSSysReqItemHis> pssysreqitemhises = null;
    private Integer objPSSysReqItemsLock = new Integer(1);
    private ArrayList<PSSysReqItem> pssysreqitems = null;
    private Integer objPSSysTasksLock = new Integer(1);
    private ArrayList<PSSysTask> pssystasks = null;

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

    public void setAIBuildParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAIBuildParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aibuildparams = string;
        this.aibuildparamsDirtyFlag = true;
    }

    public String getAIBuildParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAIBuildParams();
        }
        return this.aibuildparams;
    }

    public boolean isAIBuildParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAIBuildParamsDirty();
        }
        return this.aibuildparamsDirtyFlag;
    }

    public void resetAIBuildParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAIBuildParams();
            return;
        }
        this.aibuildparamsDirtyFlag = false;
        this.aibuildparams = null;
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

    public void setItemSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemsn = string;
        this.itemsnDirtyFlag = true;
    }

    public String getItemSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemSN();
        }
        return this.itemsn;
    }

    public boolean isItemSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemSNDirty();
        }
        return this.itemsnDirtyFlag;
    }

    public void resetItemSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemSN();
            return;
        }
        this.itemsnDirtyFlag = false;
        this.itemsn = null;
    }

    public void setItemTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtag = string;
        this.itemtagDirtyFlag = true;
    }

    public String getItemTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemTag();
        }
        return this.itemtag;
    }

    public boolean isItemTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTagDirty();
        }
        return this.itemtagDirtyFlag;
    }

    public void resetItemTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemTag();
            return;
        }
        this.itemtagDirtyFlag = false;
        this.itemtag = null;
    }

    public void setItemTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtag2 = string;
        this.itemtag2DirtyFlag = true;
    }

    public String getItemTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemTag2();
        }
        return this.itemtag2;
    }

    public boolean isItemTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTag2Dirty();
        }
        return this.itemtag2DirtyFlag;
    }

    public void resetItemTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemTag2();
            return;
        }
        this.itemtag2DirtyFlag = false;
        this.itemtag2 = null;
    }

    public void setItemTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtag3 = string;
        this.itemtag3DirtyFlag = true;
    }

    public String getItemTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemTag3();
        }
        return this.itemtag3;
    }

    public boolean isItemTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTag3Dirty();
        }
        return this.itemtag3DirtyFlag;
    }

    public void resetItemTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemTag3();
            return;
        }
        this.itemtag3DirtyFlag = false;
        this.itemtag3 = null;
    }

    public void setItemTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtag4 = string;
        this.itemtag4DirtyFlag = true;
    }

    public String getItemTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemTag4();
        }
        return this.itemtag4;
    }

    public boolean isItemTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTag4Dirty();
        }
        return this.itemtag4DirtyFlag;
    }

    public void resetItemTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemTag4();
            return;
        }
        this.itemtag4DirtyFlag = false;
        this.itemtag4 = null;
    }

    public void setItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtype = string;
        this.itemtypeDirtyFlag = true;
    }

    public String getItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemType();
        }
        return this.itemtype;
    }

    public boolean isItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTypeDirty();
        }
        return this.itemtypeDirtyFlag;
    }

    public void resetItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemType();
            return;
        }
        this.itemtypeDirtyFlag = false;
        this.itemtype = null;
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

    public void setPPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysreqitemid = string;
        this.ppssysreqitemidDirtyFlag = true;
    }

    public String getPPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysReqItemId();
        }
        return this.ppssysreqitemid;
    }

    public boolean isPPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysReqItemIdDirty();
        }
        return this.ppssysreqitemidDirtyFlag;
    }

    public void resetPPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysReqItemId();
            return;
        }
        this.ppssysreqitemidDirtyFlag = false;
        this.ppssysreqitemid = null;
    }

    public void setPPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysreqitemname = string;
        this.ppssysreqitemnameDirtyFlag = true;
    }

    public String getPPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysReqItemName();
        }
        return this.ppssysreqitemname;
    }

    public boolean isPPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysReqItemNameDirty();
        }
        return this.ppssysreqitemnameDirtyFlag;
    }

    public void resetPPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysReqItemName();
            return;
        }
        this.ppssysreqitemnameDirtyFlag = false;
        this.ppssysreqitemname = null;
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

    public void setPSDevPrdSpecId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSpecId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdspecid = string;
        this.psdevprdspecidDirtyFlag = true;
    }

    public String getPSDevPrdSpecId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSpecId();
        }
        return this.psdevprdspecid;
    }

    public boolean isPSDevPrdSpecIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSpecIdDirty();
        }
        return this.psdevprdspecidDirtyFlag;
    }

    public void resetPSDevPrdSpecId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSpecId();
            return;
        }
        this.psdevprdspecidDirtyFlag = false;
        this.psdevprdspecid = null;
    }

    public void setPSDevPrdSpecName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSpecName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdspecname = string;
        this.psdevprdspecnameDirtyFlag = true;
    }

    public String getPSDevPrdSpecName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSpecName();
        }
        return this.psdevprdspecname;
    }

    public boolean isPSDevPrdSpecNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSpecNameDirty();
        }
        return this.psdevprdspecnameDirtyFlag;
    }

    public void resetPSDevPrdSpecName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSpecName();
            return;
        }
        this.psdevprdspecnameDirtyFlag = false;
        this.psdevprdspecname = null;
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

    public void setPSSysReqItemDatasCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemDatasCnt(n);
            return;
        }
        this.pssysreqitemdatascnt = n;
        this.pssysreqitemdatascntDirtyFlag = true;
    }

    public Integer getPSSysReqItemDatasCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemDatasCnt();
        }
        return this.pssysreqitemdatascnt;
    }

    public boolean isPSSysReqItemDatasCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemDatasCntDirty();
        }
        return this.pssysreqitemdatascntDirtyFlag;
    }

    public void resetPSSysReqItemDatasCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemDatasCnt();
            return;
        }
        this.pssysreqitemdatascntDirtyFlag = false;
        this.pssysreqitemdatascnt = null;
    }

    public void setPSSysReqItemHisesCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemHisesCnt(n);
            return;
        }
        this.pssysreqitemhisescnt = n;
        this.pssysreqitemhisescntDirtyFlag = true;
    }

    public Integer getPSSysReqItemHisesCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemHisesCnt();
        }
        return this.pssysreqitemhisescnt;
    }

    public boolean isPSSysReqItemHisesCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemHisesCntDirty();
        }
        return this.pssysreqitemhisescntDirtyFlag;
    }

    public void resetPSSysReqItemHisesCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemHisesCnt();
            return;
        }
        this.pssysreqitemhisescntDirtyFlag = false;
        this.pssysreqitemhisescnt = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
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

    public void setReqContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReqContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reqcontent = string;
        this.reqcontentDirtyFlag = true;
    }

    public String getReqContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReqContent();
        }
        return this.reqcontent;
    }

    public boolean isReqContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReqContentDirty();
        }
        return this.reqcontentDirtyFlag;
    }

    public void resetReqContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReqContent();
            return;
        }
        this.reqcontentDirtyFlag = false;
        this.reqcontent = null;
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

    public void setSyncModelMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncModelMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncmodelmode = string;
        this.syncmodelmodeDirtyFlag = true;
    }

    public String getSyncModelMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncModelMode();
        }
        return this.syncmodelmode;
    }

    public boolean isSyncModelModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncModelModeDirty();
        }
        return this.syncmodelmodeDirtyFlag;
    }

    public void resetSyncModelMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncModelMode();
            return;
        }
        this.syncmodelmodeDirtyFlag = false;
        this.syncmodelmode = null;
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

    public void setVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVer(n);
            return;
        }
        this.ver = n;
        this.verDirtyFlag = true;
    }

    public Integer getVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVer();
        }
        return this.ver;
    }

    public boolean isVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerDirty();
        }
        return this.verDirtyFlag;
    }

    public void resetVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVer();
            return;
        }
        this.verDirtyFlag = false;
        this.ver = null;
    }

    protected void onReset() {
        PSSysReqItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysReqItemBase pSSysReqItemBase) {
        pSSysReqItemBase.resetAIBuildMode();
        pSSysReqItemBase.resetAIBuildParams();
        pSSysReqItemBase.resetAIBuildState();
        pSSysReqItemBase.resetAIChoices();
        pSSysReqItemBase.resetAIPrompt();
        pSSysReqItemBase.resetAIPromptChoices();
        pSSysReqItemBase.resetAIPromptChoices2();
        pSSysReqItemBase.resetAIPromptChoices3();
        pSSysReqItemBase.resetAIPromptChoices4();
        pSSysReqItemBase.resetCodeName();
        pSSysReqItemBase.resetCreateDate();
        pSSysReqItemBase.resetCreateMan();
        pSSysReqItemBase.resetItemSN();
        pSSysReqItemBase.resetItemTag();
        pSSysReqItemBase.resetItemTag2();
        pSSysReqItemBase.resetItemTag3();
        pSSysReqItemBase.resetItemTag4();
        pSSysReqItemBase.resetItemType();
        pSSysReqItemBase.resetMemo();
        pSSysReqItemBase.resetOrderValue();
        pSSysReqItemBase.resetPPSSysReqItemId();
        pSSysReqItemBase.resetPPSSysReqItemName();
        pSSysReqItemBase.resetPSDevPrdId();
        pSSysReqItemBase.resetPSDevPrdName();
        pSSysReqItemBase.resetPSDevPrdSpecId();
        pSSysReqItemBase.resetPSDevPrdSpecName();
        pSSysReqItemBase.resetPSDevPrdVerId();
        pSSysReqItemBase.resetPSDevPrdVerName();
        pSSysReqItemBase.resetPSModuleId();
        pSSysReqItemBase.resetPSModuleName();
        pSSysReqItemBase.resetPSSysReqItemDatasCnt();
        pSSysReqItemBase.resetPSSysReqItemHisesCnt();
        pSSysReqItemBase.resetPSSysReqItemId();
        pSSysReqItemBase.resetPSSysReqItemName();
        pSSysReqItemBase.resetPSSysReqModuleId();
        pSSysReqItemBase.resetPSSysReqModuleName();
        pSSysReqItemBase.resetPSSystemId();
        pSSysReqItemBase.resetPSSystemName();
        pSSysReqItemBase.resetPSSysUserCaseId();
        pSSysReqItemBase.resetPSSysUserCaseName();
        pSSysReqItemBase.resetReqContent();
        pSSysReqItemBase.resetReqModel();
        pSSysReqItemBase.resetReqModelType();
        pSSysReqItemBase.resetSubject();
        pSSysReqItemBase.resetSyncModelMode();
        pSSysReqItemBase.resetTags();
        pSSysReqItemBase.resetUpdateDate();
        pSSysReqItemBase.resetUpdateMan();
        pSSysReqItemBase.resetUserCat();
        pSSysReqItemBase.resetUserTag();
        pSSysReqItemBase.resetUserTag2();
        pSSysReqItemBase.resetUserTag3();
        pSSysReqItemBase.resetUserTag4();
        pSSysReqItemBase.resetValidFlag();
        pSSysReqItemBase.resetVer();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAIBuildModeDirty()) {
            hashMap.put(FIELD_AIBUILDMODE, this.getAIBuildMode());
        }
        if (!bl || this.isAIBuildParamsDirty()) {
            hashMap.put(FIELD_AIBUILDPARAMS, this.getAIBuildParams());
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
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isItemSNDirty()) {
            hashMap.put(FIELD_ITEMSN, this.getItemSN());
        }
        if (!bl || this.isItemTagDirty()) {
            hashMap.put(FIELD_ITEMTAG, this.getItemTag());
        }
        if (!bl || this.isItemTag2Dirty()) {
            hashMap.put(FIELD_ITEMTAG2, this.getItemTag2());
        }
        if (!bl || this.isItemTag3Dirty()) {
            hashMap.put(FIELD_ITEMTAG3, this.getItemTag3());
        }
        if (!bl || this.isItemTag4Dirty()) {
            hashMap.put(FIELD_ITEMTAG4, this.getItemTag4());
        }
        if (!bl || this.isItemTypeDirty()) {
            hashMap.put(FIELD_ITEMTYPE, this.getItemType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PPSSYSREQITEMID, this.getPPSSysReqItemId());
        }
        if (!bl || this.isPPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PPSSYSREQITEMNAME, this.getPPSSysReqItemName());
        }
        if (!bl || this.isPSDevPrdIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDID, this.getPSDevPrdId());
        }
        if (!bl || this.isPSDevPrdNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDNAME, this.getPSDevPrdName());
        }
        if (!bl || this.isPSDevPrdSpecIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDSPECID, this.getPSDevPrdSpecId());
        }
        if (!bl || this.isPSDevPrdSpecNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDSPECNAME, this.getPSDevPrdSpecName());
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
        if (!bl || this.isPSSysReqItemDatasCntDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMDATASCNT, this.getPSSysReqItemDatasCnt());
        }
        if (!bl || this.isPSSysReqItemHisesCntDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMHISESCNT, this.getPSSysReqItemHisesCnt());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
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
        if (!bl || this.isPSSysUserCaseIdDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASEID, this.getPSSysUserCaseId());
        }
        if (!bl || this.isPSSysUserCaseNameDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASENAME, this.getPSSysUserCaseName());
        }
        if (!bl || this.isReqContentDirty()) {
            hashMap.put(FIELD_REQCONTENT, this.getReqContent());
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
        if (!bl || this.isSyncModelModeDirty()) {
            hashMap.put(FIELD_SYNCMODELMODE, this.getSyncModelMode());
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
        if (!bl || this.isVerDirty()) {
            hashMap.put(FIELD_VER, this.getVer());
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
        return PSSysReqItemBase.get(this, n);
    }

    private static Object get(PSSysReqItemBase pSSysReqItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysReqItemBase.getAIBuildMode();
            }
            case 1: {
                return pSSysReqItemBase.getAIBuildParams();
            }
            case 2: {
                return pSSysReqItemBase.getAIBuildState();
            }
            case 3: {
                return pSSysReqItemBase.getAIChoices();
            }
            case 4: {
                return pSSysReqItemBase.getAIPrompt();
            }
            case 5: {
                return pSSysReqItemBase.getAIPromptChoices();
            }
            case 6: {
                return pSSysReqItemBase.getAIPromptChoices2();
            }
            case 7: {
                return pSSysReqItemBase.getAIPromptChoices3();
            }
            case 8: {
                return pSSysReqItemBase.getAIPromptChoices4();
            }
            case 9: {
                return pSSysReqItemBase.getCodeName();
            }
            case 10: {
                return pSSysReqItemBase.getCreateDate();
            }
            case 11: {
                return pSSysReqItemBase.getCreateMan();
            }
            case 12: {
                return pSSysReqItemBase.getItemSN();
            }
            case 13: {
                return pSSysReqItemBase.getItemTag();
            }
            case 14: {
                return pSSysReqItemBase.getItemTag2();
            }
            case 15: {
                return pSSysReqItemBase.getItemTag3();
            }
            case 16: {
                return pSSysReqItemBase.getItemTag4();
            }
            case 17: {
                return pSSysReqItemBase.getItemType();
            }
            case 18: {
                return pSSysReqItemBase.getMemo();
            }
            case 19: {
                return pSSysReqItemBase.getOrderValue();
            }
            case 20: {
                return pSSysReqItemBase.getPPSSysReqItemId();
            }
            case 21: {
                return pSSysReqItemBase.getPPSSysReqItemName();
            }
            case 22: {
                return pSSysReqItemBase.getPSDevPrdId();
            }
            case 23: {
                return pSSysReqItemBase.getPSDevPrdName();
            }
            case 24: {
                return pSSysReqItemBase.getPSDevPrdSpecId();
            }
            case 25: {
                return pSSysReqItemBase.getPSDevPrdSpecName();
            }
            case 26: {
                return pSSysReqItemBase.getPSDevPrdVerId();
            }
            case 27: {
                return pSSysReqItemBase.getPSDevPrdVerName();
            }
            case 28: {
                return pSSysReqItemBase.getPSModuleId();
            }
            case 29: {
                return pSSysReqItemBase.getPSModuleName();
            }
            case 30: {
                return pSSysReqItemBase.getPSSysReqItemDatasCnt();
            }
            case 31: {
                return pSSysReqItemBase.getPSSysReqItemHisesCnt();
            }
            case 32: {
                return pSSysReqItemBase.getPSSysReqItemId();
            }
            case 33: {
                return pSSysReqItemBase.getPSSysReqItemName();
            }
            case 34: {
                return pSSysReqItemBase.getPSSysReqModuleId();
            }
            case 35: {
                return pSSysReqItemBase.getPSSysReqModuleName();
            }
            case 36: {
                return pSSysReqItemBase.getPSSystemId();
            }
            case 37: {
                return pSSysReqItemBase.getPSSystemName();
            }
            case 38: {
                return pSSysReqItemBase.getPSSysUserCaseId();
            }
            case 39: {
                return pSSysReqItemBase.getPSSysUserCaseName();
            }
            case 40: {
                return pSSysReqItemBase.getReqContent();
            }
            case 41: {
                return pSSysReqItemBase.getReqModel();
            }
            case 42: {
                return pSSysReqItemBase.getReqModelType();
            }
            case 43: {
                return pSSysReqItemBase.getSubject();
            }
            case 44: {
                return pSSysReqItemBase.getSyncModelMode();
            }
            case 45: {
                return pSSysReqItemBase.getTags();
            }
            case 46: {
                return pSSysReqItemBase.getUpdateDate();
            }
            case 47: {
                return pSSysReqItemBase.getUpdateMan();
            }
            case 48: {
                return pSSysReqItemBase.getUserCat();
            }
            case 49: {
                return pSSysReqItemBase.getUserTag();
            }
            case 50: {
                return pSSysReqItemBase.getUserTag2();
            }
            case 51: {
                return pSSysReqItemBase.getUserTag3();
            }
            case 52: {
                return pSSysReqItemBase.getUserTag4();
            }
            case 53: {
                return pSSysReqItemBase.getValidFlag();
            }
            case 54: {
                return pSSysReqItemBase.getVer();
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
        PSSysReqItemBase.set(this, n, object);
    }

    private static void set(PSSysReqItemBase pSSysReqItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysReqItemBase.setAIBuildMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysReqItemBase.setAIBuildParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysReqItemBase.setAIBuildState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSysReqItemBase.setAIChoices(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysReqItemBase.setAIPrompt(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysReqItemBase.setAIPromptChoices(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysReqItemBase.setAIPromptChoices2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysReqItemBase.setAIPromptChoices3(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysReqItemBase.setAIPromptChoices4(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysReqItemBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysReqItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysReqItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysReqItemBase.setItemSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysReqItemBase.setItemTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysReqItemBase.setItemTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysReqItemBase.setItemTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysReqItemBase.setItemTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysReqItemBase.setItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysReqItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysReqItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSSysReqItemBase.setPPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysReqItemBase.setPPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysReqItemBase.setPSDevPrdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysReqItemBase.setPSDevPrdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysReqItemBase.setPSDevPrdSpecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysReqItemBase.setPSDevPrdSpecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysReqItemBase.setPSDevPrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysReqItemBase.setPSDevPrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysReqItemBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysReqItemBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysReqItemBase.setPSSysReqItemDatasCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSSysReqItemBase.setPSSysReqItemHisesCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSSysReqItemBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysReqItemBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysReqItemBase.setPSSysReqModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysReqItemBase.setPSSysReqModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysReqItemBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysReqItemBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysReqItemBase.setPSSysUserCaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysReqItemBase.setPSSysUserCaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysReqItemBase.setReqContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysReqItemBase.setReqModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysReqItemBase.setReqModelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysReqItemBase.setSubject(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysReqItemBase.setSyncModelMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysReqItemBase.setTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysReqItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 47: {
                pSSysReqItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysReqItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysReqItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysReqItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysReqItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysReqItemBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysReqItemBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 54: {
                pSSysReqItemBase.setVer(DataObject.getIntegerValue((Object)object));
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
        return PSSysReqItemBase.isNull(this, n);
    }

    private static boolean isNull(PSSysReqItemBase pSSysReqItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysReqItemBase.getAIBuildMode() == null;
            }
            case 1: {
                return pSSysReqItemBase.getAIBuildParams() == null;
            }
            case 2: {
                return pSSysReqItemBase.getAIBuildState() == null;
            }
            case 3: {
                return pSSysReqItemBase.getAIChoices() == null;
            }
            case 4: {
                return pSSysReqItemBase.getAIPrompt() == null;
            }
            case 5: {
                return pSSysReqItemBase.getAIPromptChoices() == null;
            }
            case 6: {
                return pSSysReqItemBase.getAIPromptChoices2() == null;
            }
            case 7: {
                return pSSysReqItemBase.getAIPromptChoices3() == null;
            }
            case 8: {
                return pSSysReqItemBase.getAIPromptChoices4() == null;
            }
            case 9: {
                return pSSysReqItemBase.getCodeName() == null;
            }
            case 10: {
                return pSSysReqItemBase.getCreateDate() == null;
            }
            case 11: {
                return pSSysReqItemBase.getCreateMan() == null;
            }
            case 12: {
                return pSSysReqItemBase.getItemSN() == null;
            }
            case 13: {
                return pSSysReqItemBase.getItemTag() == null;
            }
            case 14: {
                return pSSysReqItemBase.getItemTag2() == null;
            }
            case 15: {
                return pSSysReqItemBase.getItemTag3() == null;
            }
            case 16: {
                return pSSysReqItemBase.getItemTag4() == null;
            }
            case 17: {
                return pSSysReqItemBase.getItemType() == null;
            }
            case 18: {
                return pSSysReqItemBase.getMemo() == null;
            }
            case 19: {
                return pSSysReqItemBase.getOrderValue() == null;
            }
            case 20: {
                return pSSysReqItemBase.getPPSSysReqItemId() == null;
            }
            case 21: {
                return pSSysReqItemBase.getPPSSysReqItemName() == null;
            }
            case 22: {
                return pSSysReqItemBase.getPSDevPrdId() == null;
            }
            case 23: {
                return pSSysReqItemBase.getPSDevPrdName() == null;
            }
            case 24: {
                return pSSysReqItemBase.getPSDevPrdSpecId() == null;
            }
            case 25: {
                return pSSysReqItemBase.getPSDevPrdSpecName() == null;
            }
            case 26: {
                return pSSysReqItemBase.getPSDevPrdVerId() == null;
            }
            case 27: {
                return pSSysReqItemBase.getPSDevPrdVerName() == null;
            }
            case 28: {
                return pSSysReqItemBase.getPSModuleId() == null;
            }
            case 29: {
                return pSSysReqItemBase.getPSModuleName() == null;
            }
            case 30: {
                return pSSysReqItemBase.getPSSysReqItemDatasCnt() == null;
            }
            case 31: {
                return pSSysReqItemBase.getPSSysReqItemHisesCnt() == null;
            }
            case 32: {
                return pSSysReqItemBase.getPSSysReqItemId() == null;
            }
            case 33: {
                return pSSysReqItemBase.getPSSysReqItemName() == null;
            }
            case 34: {
                return pSSysReqItemBase.getPSSysReqModuleId() == null;
            }
            case 35: {
                return pSSysReqItemBase.getPSSysReqModuleName() == null;
            }
            case 36: {
                return pSSysReqItemBase.getPSSystemId() == null;
            }
            case 37: {
                return pSSysReqItemBase.getPSSystemName() == null;
            }
            case 38: {
                return pSSysReqItemBase.getPSSysUserCaseId() == null;
            }
            case 39: {
                return pSSysReqItemBase.getPSSysUserCaseName() == null;
            }
            case 40: {
                return pSSysReqItemBase.getReqContent() == null;
            }
            case 41: {
                return pSSysReqItemBase.getReqModel() == null;
            }
            case 42: {
                return pSSysReqItemBase.getReqModelType() == null;
            }
            case 43: {
                return pSSysReqItemBase.getSubject() == null;
            }
            case 44: {
                return pSSysReqItemBase.getSyncModelMode() == null;
            }
            case 45: {
                return pSSysReqItemBase.getTags() == null;
            }
            case 46: {
                return pSSysReqItemBase.getUpdateDate() == null;
            }
            case 47: {
                return pSSysReqItemBase.getUpdateMan() == null;
            }
            case 48: {
                return pSSysReqItemBase.getUserCat() == null;
            }
            case 49: {
                return pSSysReqItemBase.getUserTag() == null;
            }
            case 50: {
                return pSSysReqItemBase.getUserTag2() == null;
            }
            case 51: {
                return pSSysReqItemBase.getUserTag3() == null;
            }
            case 52: {
                return pSSysReqItemBase.getUserTag4() == null;
            }
            case 53: {
                return pSSysReqItemBase.getValidFlag() == null;
            }
            case 54: {
                return pSSysReqItemBase.getVer() == null;
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
        return PSSysReqItemBase.contains(this, n);
    }

    private static boolean contains(PSSysReqItemBase pSSysReqItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysReqItemBase.isAIBuildModeDirty();
            }
            case 1: {
                return pSSysReqItemBase.isAIBuildParamsDirty();
            }
            case 2: {
                return pSSysReqItemBase.isAIBuildStateDirty();
            }
            case 3: {
                return pSSysReqItemBase.isAIChoicesDirty();
            }
            case 4: {
                return pSSysReqItemBase.isAIPromptDirty();
            }
            case 5: {
                return pSSysReqItemBase.isAIPromptChoicesDirty();
            }
            case 6: {
                return pSSysReqItemBase.isAIPromptChoices2Dirty();
            }
            case 7: {
                return pSSysReqItemBase.isAIPromptChoices3Dirty();
            }
            case 8: {
                return pSSysReqItemBase.isAIPromptChoices4Dirty();
            }
            case 9: {
                return pSSysReqItemBase.isCodeNameDirty();
            }
            case 10: {
                return pSSysReqItemBase.isCreateDateDirty();
            }
            case 11: {
                return pSSysReqItemBase.isCreateManDirty();
            }
            case 12: {
                return pSSysReqItemBase.isItemSNDirty();
            }
            case 13: {
                return pSSysReqItemBase.isItemTagDirty();
            }
            case 14: {
                return pSSysReqItemBase.isItemTag2Dirty();
            }
            case 15: {
                return pSSysReqItemBase.isItemTag3Dirty();
            }
            case 16: {
                return pSSysReqItemBase.isItemTag4Dirty();
            }
            case 17: {
                return pSSysReqItemBase.isItemTypeDirty();
            }
            case 18: {
                return pSSysReqItemBase.isMemoDirty();
            }
            case 19: {
                return pSSysReqItemBase.isOrderValueDirty();
            }
            case 20: {
                return pSSysReqItemBase.isPPSSysReqItemIdDirty();
            }
            case 21: {
                return pSSysReqItemBase.isPPSSysReqItemNameDirty();
            }
            case 22: {
                return pSSysReqItemBase.isPSDevPrdIdDirty();
            }
            case 23: {
                return pSSysReqItemBase.isPSDevPrdNameDirty();
            }
            case 24: {
                return pSSysReqItemBase.isPSDevPrdSpecIdDirty();
            }
            case 25: {
                return pSSysReqItemBase.isPSDevPrdSpecNameDirty();
            }
            case 26: {
                return pSSysReqItemBase.isPSDevPrdVerIdDirty();
            }
            case 27: {
                return pSSysReqItemBase.isPSDevPrdVerNameDirty();
            }
            case 28: {
                return pSSysReqItemBase.isPSModuleIdDirty();
            }
            case 29: {
                return pSSysReqItemBase.isPSModuleNameDirty();
            }
            case 30: {
                return pSSysReqItemBase.isPSSysReqItemDatasCntDirty();
            }
            case 31: {
                return pSSysReqItemBase.isPSSysReqItemHisesCntDirty();
            }
            case 32: {
                return pSSysReqItemBase.isPSSysReqItemIdDirty();
            }
            case 33: {
                return pSSysReqItemBase.isPSSysReqItemNameDirty();
            }
            case 34: {
                return pSSysReqItemBase.isPSSysReqModuleIdDirty();
            }
            case 35: {
                return pSSysReqItemBase.isPSSysReqModuleNameDirty();
            }
            case 36: {
                return pSSysReqItemBase.isPSSystemIdDirty();
            }
            case 37: {
                return pSSysReqItemBase.isPSSystemNameDirty();
            }
            case 38: {
                return pSSysReqItemBase.isPSSysUserCaseIdDirty();
            }
            case 39: {
                return pSSysReqItemBase.isPSSysUserCaseNameDirty();
            }
            case 40: {
                return pSSysReqItemBase.isReqContentDirty();
            }
            case 41: {
                return pSSysReqItemBase.isReqModelDirty();
            }
            case 42: {
                return pSSysReqItemBase.isReqModelTypeDirty();
            }
            case 43: {
                return pSSysReqItemBase.isSubjectDirty();
            }
            case 44: {
                return pSSysReqItemBase.isSyncModelModeDirty();
            }
            case 45: {
                return pSSysReqItemBase.isTagsDirty();
            }
            case 46: {
                return pSSysReqItemBase.isUpdateDateDirty();
            }
            case 47: {
                return pSSysReqItemBase.isUpdateManDirty();
            }
            case 48: {
                return pSSysReqItemBase.isUserCatDirty();
            }
            case 49: {
                return pSSysReqItemBase.isUserTagDirty();
            }
            case 50: {
                return pSSysReqItemBase.isUserTag2Dirty();
            }
            case 51: {
                return pSSysReqItemBase.isUserTag3Dirty();
            }
            case 52: {
                return pSSysReqItemBase.isUserTag4Dirty();
            }
            case 53: {
                return pSSysReqItemBase.isValidFlagDirty();
            }
            case 54: {
                return pSSysReqItemBase.isVerDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysReqItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysReqItemBase pSSysReqItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysReqItemBase.getAIBuildMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aibuildmode", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getAIBuildMode()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getAIBuildParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aibuildparams", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getAIBuildParams()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getAIBuildState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aibuildstate", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getAIBuildState()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getAIChoices() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aichoices", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getAIChoices()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getAIPrompt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aiprompt", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getAIPrompt()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getAIPromptChoices() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aipromptchoices", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getAIPromptChoices()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getAIPromptChoices2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aipromptchoices2", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getAIPromptChoices2()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getAIPromptChoices3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aipromptchoices3", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getAIPromptChoices3()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getAIPromptChoices4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aipromptchoices4", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getAIPromptChoices4()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getItemSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemsn", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getItemSN()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getItemTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getItemTag()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getItemTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag2", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getItemTag2()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getItemTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag3", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getItemTag3()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getItemTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtag4", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getItemTag4()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtype", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getItemType()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysreqitemid", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysreqitemname", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSDevPrdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdid", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSDevPrdId()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSDevPrdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdname", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSDevPrdName()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSDevPrdSpecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdspecid", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSDevPrdSpecId()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSDevPrdSpecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdspecname", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSDevPrdSpecName()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSDevPrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdverid", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSDevPrdVerId()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSDevPrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdvername", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSDevPrdVerName()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSSysReqItemDatasCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemdatascnt", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSSysReqItemDatasCnt()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSSysReqItemHisesCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemhisescnt", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSSysReqItemHisesCnt()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSSysReqModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqmoduleid", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSSysReqModuleId()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSSysReqModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqmodulename", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSSysReqModuleName()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSSysUserCaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercaseid", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSSysUserCaseId()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getPSSysUserCaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercasename", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getPSSysUserCaseName()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getReqContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reqcontent", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getReqContent()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getReqModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reqmodel", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getReqModel()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getReqModelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reqmodeltype", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getReqModelType()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getSubject() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subject", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getSubject()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getSyncModelMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncmodelmode", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getSyncModelMode()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tags", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getTags()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysReqItemBase.getVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ver", (Object)PSSysReqItemBase.getJSONValue((Object)pSSysReqItemBase.getVer()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysReqItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysReqItemBase pSSysReqItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysReqItemBase.getAIBuildMode() != null) {
            object = pSSysReqItemBase.getAIBuildMode();
            xmlNode.setAttribute(FIELD_AIBUILDMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysReqItemBase.getAIBuildParams() != null) {
            object = pSSysReqItemBase.getAIBuildParams();
            xmlNode.setAttribute(FIELD_AIBUILDPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getAIBuildState() != null) {
            object = pSSysReqItemBase.getAIBuildState();
            xmlNode.setAttribute(FIELD_AIBUILDSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysReqItemBase.getAIChoices() != null) {
            object = pSSysReqItemBase.getAIChoices();
            xmlNode.setAttribute(FIELD_AICHOICES, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getAIPrompt() != null) {
            object = pSSysReqItemBase.getAIPrompt();
            xmlNode.setAttribute(FIELD_AIPROMPT, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getAIPromptChoices() != null) {
            object = pSSysReqItemBase.getAIPromptChoices();
            xmlNode.setAttribute(FIELD_AIPROMPTCHOICES, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getAIPromptChoices2() != null) {
            object = pSSysReqItemBase.getAIPromptChoices2();
            xmlNode.setAttribute(FIELD_AIPROMPTCHOICES2, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getAIPromptChoices3() != null) {
            object = pSSysReqItemBase.getAIPromptChoices3();
            xmlNode.setAttribute(FIELD_AIPROMPTCHOICES3, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getAIPromptChoices4() != null) {
            object = pSSysReqItemBase.getAIPromptChoices4();
            xmlNode.setAttribute(FIELD_AIPROMPTCHOICES4, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getCodeName() != null) {
            object = pSSysReqItemBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getCreateDate() != null) {
            object = pSSysReqItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysReqItemBase.getCreateMan() != null) {
            object = pSSysReqItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getItemSN() != null) {
            object = pSSysReqItemBase.getItemSN();
            xmlNode.setAttribute(FIELD_ITEMSN, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getItemTag() != null) {
            object = pSSysReqItemBase.getItemTag();
            xmlNode.setAttribute(FIELD_ITEMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getItemTag2() != null) {
            object = pSSysReqItemBase.getItemTag2();
            xmlNode.setAttribute(FIELD_ITEMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getItemTag3() != null) {
            object = pSSysReqItemBase.getItemTag3();
            xmlNode.setAttribute(FIELD_ITEMTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getItemTag4() != null) {
            object = pSSysReqItemBase.getItemTag4();
            xmlNode.setAttribute(FIELD_ITEMTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getItemType() != null) {
            object = pSSysReqItemBase.getItemType();
            xmlNode.setAttribute(FIELD_ITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getMemo() != null) {
            object = pSSysReqItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getOrderValue() != null) {
            object = pSSysReqItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysReqItemBase.getPPSSysReqItemId() != null) {
            object = pSSysReqItemBase.getPPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PPSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPPSSysReqItemName() != null) {
            object = pSSysReqItemBase.getPPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PPSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSDevPrdId() != null) {
            object = pSSysReqItemBase.getPSDevPrdId();
            xmlNode.setAttribute(FIELD_PSDEVPRDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSDevPrdName() != null) {
            object = pSSysReqItemBase.getPSDevPrdName();
            xmlNode.setAttribute(FIELD_PSDEVPRDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSDevPrdSpecId() != null) {
            object = pSSysReqItemBase.getPSDevPrdSpecId();
            xmlNode.setAttribute(FIELD_PSDEVPRDSPECID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSDevPrdSpecName() != null) {
            object = pSSysReqItemBase.getPSDevPrdSpecName();
            xmlNode.setAttribute(FIELD_PSDEVPRDSPECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSDevPrdVerId() != null) {
            object = pSSysReqItemBase.getPSDevPrdVerId();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSDevPrdVerName() != null) {
            object = pSSysReqItemBase.getPSDevPrdVerName();
            xmlNode.setAttribute(FIELD_PSDEVPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSModuleId() != null) {
            object = pSSysReqItemBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSModuleName() != null) {
            object = pSSysReqItemBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSSysReqItemDatasCnt() != null) {
            object = pSSysReqItemBase.getPSSysReqItemDatasCnt();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMDATASCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysReqItemBase.getPSSysReqItemHisesCnt() != null) {
            object = pSSysReqItemBase.getPSSysReqItemHisesCnt();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMHISESCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysReqItemBase.getPSSysReqItemId() != null) {
            object = pSSysReqItemBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSSysReqItemName() != null) {
            object = pSSysReqItemBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSSysReqModuleId() != null) {
            object = pSSysReqItemBase.getPSSysReqModuleId();
            xmlNode.setAttribute(FIELD_PSSYSREQMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSSysReqModuleName() != null) {
            object = pSSysReqItemBase.getPSSysReqModuleName();
            xmlNode.setAttribute(FIELD_PSSYSREQMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSSystemId() != null) {
            object = pSSysReqItemBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSSystemName() != null) {
            object = pSSysReqItemBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSSysUserCaseId() != null) {
            object = pSSysReqItemBase.getPSSysUserCaseId();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getPSSysUserCaseName() != null) {
            object = pSSysReqItemBase.getPSSysUserCaseName();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getReqContent() != null) {
            object = pSSysReqItemBase.getReqContent();
            xmlNode.setAttribute(FIELD_REQCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getReqModel() != null) {
            object = pSSysReqItemBase.getReqModel();
            xmlNode.setAttribute(FIELD_REQMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getReqModelType() != null) {
            object = pSSysReqItemBase.getReqModelType();
            xmlNode.setAttribute(FIELD_REQMODELTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getSubject() != null) {
            object = pSSysReqItemBase.getSubject();
            xmlNode.setAttribute(FIELD_SUBJECT, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getSyncModelMode() != null) {
            object = pSSysReqItemBase.getSyncModelMode();
            xmlNode.setAttribute(FIELD_SYNCMODELMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getTags() != null) {
            object = pSSysReqItemBase.getTags();
            xmlNode.setAttribute(FIELD_TAGS, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getUpdateDate() != null) {
            object = pSSysReqItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysReqItemBase.getUpdateMan() != null) {
            object = pSSysReqItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getUserCat() != null) {
            object = pSSysReqItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getUserTag() != null) {
            object = pSSysReqItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getUserTag2() != null) {
            object = pSSysReqItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getUserTag3() != null) {
            object = pSSysReqItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getUserTag4() != null) {
            object = pSSysReqItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysReqItemBase.getValidFlag() != null) {
            object = pSSysReqItemBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysReqItemBase.getVer() != null) {
            object = pSSysReqItemBase.getVer();
            xmlNode.setAttribute(FIELD_VER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysReqItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysReqItemBase pSSysReqItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysReqItemBase.isAIBuildModeDirty() && (bl || pSSysReqItemBase.getAIBuildMode() != null)) {
            iDataObject.set(FIELD_AIBUILDMODE, (Object)pSSysReqItemBase.getAIBuildMode());
        }
        if (pSSysReqItemBase.isAIBuildParamsDirty() && (bl || pSSysReqItemBase.getAIBuildParams() != null)) {
            iDataObject.set(FIELD_AIBUILDPARAMS, (Object)pSSysReqItemBase.getAIBuildParams());
        }
        if (pSSysReqItemBase.isAIBuildStateDirty() && (bl || pSSysReqItemBase.getAIBuildState() != null)) {
            iDataObject.set(FIELD_AIBUILDSTATE, (Object)pSSysReqItemBase.getAIBuildState());
        }
        if (pSSysReqItemBase.isAIChoicesDirty() && (bl || pSSysReqItemBase.getAIChoices() != null)) {
            iDataObject.set(FIELD_AICHOICES, (Object)pSSysReqItemBase.getAIChoices());
        }
        if (pSSysReqItemBase.isAIPromptDirty() && (bl || pSSysReqItemBase.getAIPrompt() != null)) {
            iDataObject.set(FIELD_AIPROMPT, (Object)pSSysReqItemBase.getAIPrompt());
        }
        if (pSSysReqItemBase.isAIPromptChoicesDirty() && (bl || pSSysReqItemBase.getAIPromptChoices() != null)) {
            iDataObject.set(FIELD_AIPROMPTCHOICES, (Object)pSSysReqItemBase.getAIPromptChoices());
        }
        if (pSSysReqItemBase.isAIPromptChoices2Dirty() && (bl || pSSysReqItemBase.getAIPromptChoices2() != null)) {
            iDataObject.set(FIELD_AIPROMPTCHOICES2, (Object)pSSysReqItemBase.getAIPromptChoices2());
        }
        if (pSSysReqItemBase.isAIPromptChoices3Dirty() && (bl || pSSysReqItemBase.getAIPromptChoices3() != null)) {
            iDataObject.set(FIELD_AIPROMPTCHOICES3, (Object)pSSysReqItemBase.getAIPromptChoices3());
        }
        if (pSSysReqItemBase.isAIPromptChoices4Dirty() && (bl || pSSysReqItemBase.getAIPromptChoices4() != null)) {
            iDataObject.set(FIELD_AIPROMPTCHOICES4, (Object)pSSysReqItemBase.getAIPromptChoices4());
        }
        if (pSSysReqItemBase.isCodeNameDirty() && (bl || pSSysReqItemBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysReqItemBase.getCodeName());
        }
        if (pSSysReqItemBase.isCreateDateDirty() && (bl || pSSysReqItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysReqItemBase.getCreateDate());
        }
        if (pSSysReqItemBase.isCreateManDirty() && (bl || pSSysReqItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysReqItemBase.getCreateMan());
        }
        if (pSSysReqItemBase.isItemSNDirty() && (bl || pSSysReqItemBase.getItemSN() != null)) {
            iDataObject.set(FIELD_ITEMSN, (Object)pSSysReqItemBase.getItemSN());
        }
        if (pSSysReqItemBase.isItemTagDirty() && (bl || pSSysReqItemBase.getItemTag() != null)) {
            iDataObject.set(FIELD_ITEMTAG, (Object)pSSysReqItemBase.getItemTag());
        }
        if (pSSysReqItemBase.isItemTag2Dirty() && (bl || pSSysReqItemBase.getItemTag2() != null)) {
            iDataObject.set(FIELD_ITEMTAG2, (Object)pSSysReqItemBase.getItemTag2());
        }
        if (pSSysReqItemBase.isItemTag3Dirty() && (bl || pSSysReqItemBase.getItemTag3() != null)) {
            iDataObject.set(FIELD_ITEMTAG3, (Object)pSSysReqItemBase.getItemTag3());
        }
        if (pSSysReqItemBase.isItemTag4Dirty() && (bl || pSSysReqItemBase.getItemTag4() != null)) {
            iDataObject.set(FIELD_ITEMTAG4, (Object)pSSysReqItemBase.getItemTag4());
        }
        if (pSSysReqItemBase.isItemTypeDirty() && (bl || pSSysReqItemBase.getItemType() != null)) {
            iDataObject.set(FIELD_ITEMTYPE, (Object)pSSysReqItemBase.getItemType());
        }
        if (pSSysReqItemBase.isMemoDirty() && (bl || pSSysReqItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysReqItemBase.getMemo());
        }
        if (pSSysReqItemBase.isOrderValueDirty() && (bl || pSSysReqItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysReqItemBase.getOrderValue());
        }
        if (pSSysReqItemBase.isPPSSysReqItemIdDirty() && (bl || pSSysReqItemBase.getPPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PPSSYSREQITEMID, (Object)pSSysReqItemBase.getPPSSysReqItemId());
        }
        if (pSSysReqItemBase.isPPSSysReqItemNameDirty() && (bl || pSSysReqItemBase.getPPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PPSSYSREQITEMNAME, (Object)pSSysReqItemBase.getPPSSysReqItemName());
        }
        if (pSSysReqItemBase.isPSDevPrdIdDirty() && (bl || pSSysReqItemBase.getPSDevPrdId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDID, (Object)pSSysReqItemBase.getPSDevPrdId());
        }
        if (pSSysReqItemBase.isPSDevPrdNameDirty() && (bl || pSSysReqItemBase.getPSDevPrdName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDNAME, (Object)pSSysReqItemBase.getPSDevPrdName());
        }
        if (pSSysReqItemBase.isPSDevPrdSpecIdDirty() && (bl || pSSysReqItemBase.getPSDevPrdSpecId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSPECID, (Object)pSSysReqItemBase.getPSDevPrdSpecId());
        }
        if (pSSysReqItemBase.isPSDevPrdSpecNameDirty() && (bl || pSSysReqItemBase.getPSDevPrdSpecName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSPECNAME, (Object)pSSysReqItemBase.getPSDevPrdSpecName());
        }
        if (pSSysReqItemBase.isPSDevPrdVerIdDirty() && (bl || pSSysReqItemBase.getPSDevPrdVerId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERID, (Object)pSSysReqItemBase.getPSDevPrdVerId());
        }
        if (pSSysReqItemBase.isPSDevPrdVerNameDirty() && (bl || pSSysReqItemBase.getPSDevPrdVerName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDVERNAME, (Object)pSSysReqItemBase.getPSDevPrdVerName());
        }
        if (pSSysReqItemBase.isPSModuleIdDirty() && (bl || pSSysReqItemBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysReqItemBase.getPSModuleId());
        }
        if (pSSysReqItemBase.isPSModuleNameDirty() && (bl || pSSysReqItemBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysReqItemBase.getPSModuleName());
        }
        if (pSSysReqItemBase.isPSSysReqItemDatasCntDirty() && (bl || pSSysReqItemBase.getPSSysReqItemDatasCnt() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMDATASCNT, (Object)pSSysReqItemBase.getPSSysReqItemDatasCnt());
        }
        if (pSSysReqItemBase.isPSSysReqItemHisesCntDirty() && (bl || pSSysReqItemBase.getPSSysReqItemHisesCnt() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMHISESCNT, (Object)pSSysReqItemBase.getPSSysReqItemHisesCnt());
        }
        if (pSSysReqItemBase.isPSSysReqItemIdDirty() && (bl || pSSysReqItemBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSSysReqItemBase.getPSSysReqItemId());
        }
        if (pSSysReqItemBase.isPSSysReqItemNameDirty() && (bl || pSSysReqItemBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSSysReqItemBase.getPSSysReqItemName());
        }
        if (pSSysReqItemBase.isPSSysReqModuleIdDirty() && (bl || pSSysReqItemBase.getPSSysReqModuleId() != null)) {
            iDataObject.set(FIELD_PSSYSREQMODULEID, (Object)pSSysReqItemBase.getPSSysReqModuleId());
        }
        if (pSSysReqItemBase.isPSSysReqModuleNameDirty() && (bl || pSSysReqItemBase.getPSSysReqModuleName() != null)) {
            iDataObject.set(FIELD_PSSYSREQMODULENAME, (Object)pSSysReqItemBase.getPSSysReqModuleName());
        }
        if (pSSysReqItemBase.isPSSystemIdDirty() && (bl || pSSysReqItemBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysReqItemBase.getPSSystemId());
        }
        if (pSSysReqItemBase.isPSSystemNameDirty() && (bl || pSSysReqItemBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysReqItemBase.getPSSystemName());
        }
        if (pSSysReqItemBase.isPSSysUserCaseIdDirty() && (bl || pSSysReqItemBase.getPSSysUserCaseId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASEID, (Object)pSSysReqItemBase.getPSSysUserCaseId());
        }
        if (pSSysReqItemBase.isPSSysUserCaseNameDirty() && (bl || pSSysReqItemBase.getPSSysUserCaseName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASENAME, (Object)pSSysReqItemBase.getPSSysUserCaseName());
        }
        if (pSSysReqItemBase.isReqContentDirty() && (bl || pSSysReqItemBase.getReqContent() != null)) {
            iDataObject.set(FIELD_REQCONTENT, (Object)pSSysReqItemBase.getReqContent());
        }
        if (pSSysReqItemBase.isReqModelDirty() && (bl || pSSysReqItemBase.getReqModel() != null)) {
            iDataObject.set(FIELD_REQMODEL, (Object)pSSysReqItemBase.getReqModel());
        }
        if (pSSysReqItemBase.isReqModelTypeDirty() && (bl || pSSysReqItemBase.getReqModelType() != null)) {
            iDataObject.set(FIELD_REQMODELTYPE, (Object)pSSysReqItemBase.getReqModelType());
        }
        if (pSSysReqItemBase.isSubjectDirty() && (bl || pSSysReqItemBase.getSubject() != null)) {
            iDataObject.set(FIELD_SUBJECT, (Object)pSSysReqItemBase.getSubject());
        }
        if (pSSysReqItemBase.isSyncModelModeDirty() && (bl || pSSysReqItemBase.getSyncModelMode() != null)) {
            iDataObject.set(FIELD_SYNCMODELMODE, (Object)pSSysReqItemBase.getSyncModelMode());
        }
        if (pSSysReqItemBase.isTagsDirty() && (bl || pSSysReqItemBase.getTags() != null)) {
            iDataObject.set(FIELD_TAGS, (Object)pSSysReqItemBase.getTags());
        }
        if (pSSysReqItemBase.isUpdateDateDirty() && (bl || pSSysReqItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysReqItemBase.getUpdateDate());
        }
        if (pSSysReqItemBase.isUpdateManDirty() && (bl || pSSysReqItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysReqItemBase.getUpdateMan());
        }
        if (pSSysReqItemBase.isUserCatDirty() && (bl || pSSysReqItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysReqItemBase.getUserCat());
        }
        if (pSSysReqItemBase.isUserTagDirty() && (bl || pSSysReqItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysReqItemBase.getUserTag());
        }
        if (pSSysReqItemBase.isUserTag2Dirty() && (bl || pSSysReqItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysReqItemBase.getUserTag2());
        }
        if (pSSysReqItemBase.isUserTag3Dirty() && (bl || pSSysReqItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysReqItemBase.getUserTag3());
        }
        if (pSSysReqItemBase.isUserTag4Dirty() && (bl || pSSysReqItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysReqItemBase.getUserTag4());
        }
        if (pSSysReqItemBase.isValidFlagDirty() && (bl || pSSysReqItemBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysReqItemBase.getValidFlag());
        }
        if (pSSysReqItemBase.isVerDirty() && (bl || pSSysReqItemBase.getVer() != null)) {
            iDataObject.set(FIELD_VER, (Object)pSSysReqItemBase.getVer());
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
        return PSSysReqItemBase.remove(this, n);
    }

    private static boolean remove(PSSysReqItemBase pSSysReqItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysReqItemBase.resetAIBuildMode();
                return true;
            }
            case 1: {
                pSSysReqItemBase.resetAIBuildParams();
                return true;
            }
            case 2: {
                pSSysReqItemBase.resetAIBuildState();
                return true;
            }
            case 3: {
                pSSysReqItemBase.resetAIChoices();
                return true;
            }
            case 4: {
                pSSysReqItemBase.resetAIPrompt();
                return true;
            }
            case 5: {
                pSSysReqItemBase.resetAIPromptChoices();
                return true;
            }
            case 6: {
                pSSysReqItemBase.resetAIPromptChoices2();
                return true;
            }
            case 7: {
                pSSysReqItemBase.resetAIPromptChoices3();
                return true;
            }
            case 8: {
                pSSysReqItemBase.resetAIPromptChoices4();
                return true;
            }
            case 9: {
                pSSysReqItemBase.resetCodeName();
                return true;
            }
            case 10: {
                pSSysReqItemBase.resetCreateDate();
                return true;
            }
            case 11: {
                pSSysReqItemBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSSysReqItemBase.resetItemSN();
                return true;
            }
            case 13: {
                pSSysReqItemBase.resetItemTag();
                return true;
            }
            case 14: {
                pSSysReqItemBase.resetItemTag2();
                return true;
            }
            case 15: {
                pSSysReqItemBase.resetItemTag3();
                return true;
            }
            case 16: {
                pSSysReqItemBase.resetItemTag4();
                return true;
            }
            case 17: {
                pSSysReqItemBase.resetItemType();
                return true;
            }
            case 18: {
                pSSysReqItemBase.resetMemo();
                return true;
            }
            case 19: {
                pSSysReqItemBase.resetOrderValue();
                return true;
            }
            case 20: {
                pSSysReqItemBase.resetPPSSysReqItemId();
                return true;
            }
            case 21: {
                pSSysReqItemBase.resetPPSSysReqItemName();
                return true;
            }
            case 22: {
                pSSysReqItemBase.resetPSDevPrdId();
                return true;
            }
            case 23: {
                pSSysReqItemBase.resetPSDevPrdName();
                return true;
            }
            case 24: {
                pSSysReqItemBase.resetPSDevPrdSpecId();
                return true;
            }
            case 25: {
                pSSysReqItemBase.resetPSDevPrdSpecName();
                return true;
            }
            case 26: {
                pSSysReqItemBase.resetPSDevPrdVerId();
                return true;
            }
            case 27: {
                pSSysReqItemBase.resetPSDevPrdVerName();
                return true;
            }
            case 28: {
                pSSysReqItemBase.resetPSModuleId();
                return true;
            }
            case 29: {
                pSSysReqItemBase.resetPSModuleName();
                return true;
            }
            case 30: {
                pSSysReqItemBase.resetPSSysReqItemDatasCnt();
                return true;
            }
            case 31: {
                pSSysReqItemBase.resetPSSysReqItemHisesCnt();
                return true;
            }
            case 32: {
                pSSysReqItemBase.resetPSSysReqItemId();
                return true;
            }
            case 33: {
                pSSysReqItemBase.resetPSSysReqItemName();
                return true;
            }
            case 34: {
                pSSysReqItemBase.resetPSSysReqModuleId();
                return true;
            }
            case 35: {
                pSSysReqItemBase.resetPSSysReqModuleName();
                return true;
            }
            case 36: {
                pSSysReqItemBase.resetPSSystemId();
                return true;
            }
            case 37: {
                pSSysReqItemBase.resetPSSystemName();
                return true;
            }
            case 38: {
                pSSysReqItemBase.resetPSSysUserCaseId();
                return true;
            }
            case 39: {
                pSSysReqItemBase.resetPSSysUserCaseName();
                return true;
            }
            case 40: {
                pSSysReqItemBase.resetReqContent();
                return true;
            }
            case 41: {
                pSSysReqItemBase.resetReqModel();
                return true;
            }
            case 42: {
                pSSysReqItemBase.resetReqModelType();
                return true;
            }
            case 43: {
                pSSysReqItemBase.resetSubject();
                return true;
            }
            case 44: {
                pSSysReqItemBase.resetSyncModelMode();
                return true;
            }
            case 45: {
                pSSysReqItemBase.resetTags();
                return true;
            }
            case 46: {
                pSSysReqItemBase.resetUpdateDate();
                return true;
            }
            case 47: {
                pSSysReqItemBase.resetUpdateMan();
                return true;
            }
            case 48: {
                pSSysReqItemBase.resetUserCat();
                return true;
            }
            case 49: {
                pSSysReqItemBase.resetUserTag();
                return true;
            }
            case 50: {
                pSSysReqItemBase.resetUserTag2();
                return true;
            }
            case 51: {
                pSSysReqItemBase.resetUserTag3();
                return true;
            }
            case 52: {
                pSSysReqItemBase.resetUserTag4();
                return true;
            }
            case 53: {
                pSSysReqItemBase.resetValidFlag();
                return true;
            }
            case 54: {
                pSSysReqItemBase.resetVer();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdSpec getPSDevPrdSpec() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSpec();
        }
        if (this.getPSDevPrdSpecId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdSpecLock;
        synchronized (n) {
            if (this.psdevprdspec != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdSpecId(), (Object)this.psdevprdspec.getPSDevPrdSpecId()) != 0L) {
                this.psdevprdspec = null;
            }
            if (this.psdevprdspec == null) {
                PSDevPrdSpec pSDevPrdSpec = new PSDevPrdSpec();
                pSDevPrdSpec.setPSDevPrdSpecId(this.getPSDevPrdSpecId());
                PSDevPrdSpecService pSDevPrdSpecService = (PSDevPrdSpecService)ServiceGlobal.getService(PSDevPrdSpecService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdSpecService.autoGet(pSDevPrdSpec);
                this.psdevprdspec = pSDevPrdSpec;
            }
            return this.psdevprdspec;
        }
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
                pSDevPrdVerService.autoGet(pSDevPrdVer);
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
                pSDevPrdService.autoGet(pSDevPrd);
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
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPPSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSysReqItem();
        }
        if (this.getPPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPPSysReqItemLock;
        synchronized (n) {
            if (this.ppsysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysReqItemId(), (Object)this.ppsysreqitem.getPSSysReqItemId()) != 0L) {
                this.ppsysreqitem = null;
            }
            if (this.ppsysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet(pSSysReqItem);
                this.ppsysreqitem = pSSysReqItem;
            }
            return this.ppsysreqitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqModule getPSSysReqModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqModule();
        }
        if (this.getPSSysReqModuleId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqModuleLock;
        synchronized (n) {
            if (this.pssysreqmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqModuleId(), (Object)this.pssysreqmodule.getPSSysReqModuleId()) != 0L) {
                this.pssysreqmodule = null;
            }
            if (this.pssysreqmodule == null) {
                PSSysReqModule pSSysReqModule = new PSSysReqModule();
                pSSysReqModule.setPSSysReqModuleId(this.getPSSysReqModuleId());
                PSSysReqModuleService pSSysReqModuleService = (PSSysReqModuleService)ServiceGlobal.getService(PSSysReqModuleService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqModuleService.autoGet(pSSysReqModule);
                this.pssysreqmodule = pSSysReqModule;
            }
            return this.pssysreqmodule;
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
    public PSSysUserCase getPSSysUserCase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCase();
        }
        if (this.getPSSysUserCaseId() == null) {
            return null;
        }
        Integer n = this.objPSSysUserCaseLock;
        synchronized (n) {
            if (this.pssysusercase != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUserCaseId(), (Object)this.pssysusercase.getPSSysUserCaseId()) != 0L) {
                this.pssysusercase = null;
            }
            if (this.pssysusercase == null) {
                PSSysUserCase pSSysUserCase = new PSSysUserCase();
                pSSysUserCase.setPSSysUserCaseId(this.getPSSysUserCaseId());
                PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
                pSSysUserCaseService.autoGet(pSSysUserCase);
                this.pssysusercase = pSSysUserCase;
            }
            return this.pssysusercase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysReqItemData> getPSSysReqItemDatas() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemDatas();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        PSSysReqItemDataService pSSysReqItemDataService = (PSSysReqItemDataService)ServiceGlobal.getService(PSSysReqItemDataService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysReqItemDatasLock;
        synchronized (n) {
            if (this.pssysreqitemdatas == null) {
                this.pssysreqitemdatas = pSSysReqItemDataService.selectByPSSysReqItem(this);
            }
            return this.pssysreqitemdatas;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysReqItemHis> getPSSysReqItemHises() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemHises();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        PSSysReqItemHisService pSSysReqItemHisService = (PSSysReqItemHisService)ServiceGlobal.getService(PSSysReqItemHisService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysReqItemHisesLock;
        synchronized (n) {
            if (this.pssysreqitemhises == null) {
                this.pssysreqitemhises = pSSysReqItemHisService.selectByPSSysReqItem(this);
            }
            return this.pssysreqitemhises;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysReqItem> getPSSysReqItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItems();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysReqItemsLock;
        synchronized (n) {
            if (this.pssysreqitems == null) {
                this.pssysreqitems = pSSysReqItemService.selectByPPSysReqItem(this);
            }
            return this.pssysreqitems;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTask> getPSSysTasks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTasks();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        PSSysTaskService pSSysTaskService = (PSSysTaskService)ServiceGlobal.getService(PSSysTaskService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTasksLock;
        synchronized (n) {
            if (this.pssystasks == null) {
                this.pssystasks = pSSysTaskService.selectByPSSysReqItem(this);
            }
            return this.pssystasks;
        }
    }

    private PSSysReqItemBase getProxyEntity() {
        return this.proxyPSSysReqItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysReqItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysReqItemBase) {
            this.proxyPSSysReqItemBase = (PSSysReqItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AIBUILDMODE, 0);
        fieldIndexMap.put(FIELD_AIBUILDPARAMS, 1);
        fieldIndexMap.put(FIELD_AIBUILDSTATE, 2);
        fieldIndexMap.put(FIELD_AICHOICES, 3);
        fieldIndexMap.put(FIELD_AIPROMPT, 4);
        fieldIndexMap.put(FIELD_AIPROMPTCHOICES, 5);
        fieldIndexMap.put(FIELD_AIPROMPTCHOICES2, 6);
        fieldIndexMap.put(FIELD_AIPROMPTCHOICES3, 7);
        fieldIndexMap.put(FIELD_AIPROMPTCHOICES4, 8);
        fieldIndexMap.put(FIELD_CODENAME, 9);
        fieldIndexMap.put(FIELD_CREATEDATE, 10);
        fieldIndexMap.put(FIELD_CREATEMAN, 11);
        fieldIndexMap.put(FIELD_ITEMSN, 12);
        fieldIndexMap.put(FIELD_ITEMTAG, 13);
        fieldIndexMap.put(FIELD_ITEMTAG2, 14);
        fieldIndexMap.put(FIELD_ITEMTAG3, 15);
        fieldIndexMap.put(FIELD_ITEMTAG4, 16);
        fieldIndexMap.put(FIELD_ITEMTYPE, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_ORDERVALUE, 19);
        fieldIndexMap.put(FIELD_PPSSYSREQITEMID, 20);
        fieldIndexMap.put(FIELD_PPSSYSREQITEMNAME, 21);
        fieldIndexMap.put(FIELD_PSDEVPRDID, 22);
        fieldIndexMap.put(FIELD_PSDEVPRDNAME, 23);
        fieldIndexMap.put(FIELD_PSDEVPRDSPECID, 24);
        fieldIndexMap.put(FIELD_PSDEVPRDSPECNAME, 25);
        fieldIndexMap.put(FIELD_PSDEVPRDVERID, 26);
        fieldIndexMap.put(FIELD_PSDEVPRDVERNAME, 27);
        fieldIndexMap.put(FIELD_PSMODULEID, 28);
        fieldIndexMap.put(FIELD_PSMODULENAME, 29);
        fieldIndexMap.put(FIELD_PSSYSREQITEMDATASCNT, 30);
        fieldIndexMap.put(FIELD_PSSYSREQITEMHISESCNT, 31);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 32);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 33);
        fieldIndexMap.put(FIELD_PSSYSREQMODULEID, 34);
        fieldIndexMap.put(FIELD_PSSYSREQMODULENAME, 35);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 36);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 37);
        fieldIndexMap.put(FIELD_PSSYSUSERCASEID, 38);
        fieldIndexMap.put(FIELD_PSSYSUSERCASENAME, 39);
        fieldIndexMap.put(FIELD_REQCONTENT, 40);
        fieldIndexMap.put(FIELD_REQMODEL, 41);
        fieldIndexMap.put(FIELD_REQMODELTYPE, 42);
        fieldIndexMap.put(FIELD_SUBJECT, 43);
        fieldIndexMap.put(FIELD_SYNCMODELMODE, 44);
        fieldIndexMap.put(FIELD_TAGS, 45);
        fieldIndexMap.put(FIELD_UPDATEDATE, 46);
        fieldIndexMap.put(FIELD_UPDATEMAN, 47);
        fieldIndexMap.put(FIELD_USERCAT, 48);
        fieldIndexMap.put(FIELD_USERTAG, 49);
        fieldIndexMap.put(FIELD_USERTAG2, 50);
        fieldIndexMap.put(FIELD_USERTAG3, 51);
        fieldIndexMap.put(FIELD_USERTAG4, 52);
        fieldIndexMap.put(FIELD_VALIDFLAG, 53);
        fieldIndexMap.put(FIELD_VER, 54);
    }
}

