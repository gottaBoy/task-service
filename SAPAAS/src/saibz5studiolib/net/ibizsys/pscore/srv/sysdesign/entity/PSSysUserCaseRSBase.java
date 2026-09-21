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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysActor;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysActorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUserCaseRSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysUserCaseRSBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSSYSACTORID = "PPSSYSACTORID";
    public static final String FIELD_PPSSYSACTORNAME = "PPSSYSACTORNAME";
    public static final String FIELD_PPSSYSUSERCASEID = "PPSSYSUSERCASEID";
    public static final String FIELD_PPSSYSUSERCASENAME = "PPSSYSUSERCASENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSACTORID = "PSSYSACTORID";
    public static final String FIELD_PSSYSACTORNAME = "PSSYSACTORNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUSERCASEID = "PSSYSUSERCASEID";
    public static final String FIELD_PSSYSUSERCASENAME = "PSSYSUSERCASENAME";
    public static final String FIELD_PSSYSUSERCASERSID = "PSSYSUSERCASERSID";
    public static final String FIELD_PSSYSUSERCASERSNAME = "PSSYSUSERCASERSNAME";
    public static final String FIELD_RSMODE = "RSMODE";
    public static final String FIELD_RSTAG = "RSTAG";
    public static final String FIELD_RSTAG2 = "RSTAG2";
    public static final String FIELD_RSTAG3 = "RSTAG3";
    public static final String FIELD_RSTAG4 = "RSTAG4";
    public static final String FIELD_RSTYPE = "RSTYPE";
    public static final String FIELD_TAGS = "TAGS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_COLOR = 1;
    private static final int INDEX_CONTENT = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PPSSYSACTORID = 7;
    private static final int INDEX_PPSSYSACTORNAME = 8;
    private static final int INDEX_PPSSYSUSERCASEID = 9;
    private static final int INDEX_PPSSYSUSERCASENAME = 10;
    private static final int INDEX_PSMODULEID = 11;
    private static final int INDEX_PSMODULENAME = 12;
    private static final int INDEX_PSSYSACTORID = 13;
    private static final int INDEX_PSSYSACTORNAME = 14;
    private static final int INDEX_PSSYSTEMID = 15;
    private static final int INDEX_PSSYSTEMNAME = 16;
    private static final int INDEX_PSSYSUSERCASEID = 17;
    private static final int INDEX_PSSYSUSERCASENAME = 18;
    private static final int INDEX_PSSYSUSERCASERSID = 19;
    private static final int INDEX_PSSYSUSERCASERSNAME = 20;
    private static final int INDEX_RSMODE = 21;
    private static final int INDEX_RSTAG = 22;
    private static final int INDEX_RSTAG2 = 23;
    private static final int INDEX_RSTAG3 = 24;
    private static final int INDEX_RSTAG4 = 25;
    private static final int INDEX_RSTYPE = 26;
    private static final int INDEX_TAGS = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final int INDEX_USERCAT = 30;
    private static final int INDEX_USERTAG = 31;
    private static final int INDEX_USERTAG2 = 32;
    private static final int INDEX_USERTAG3 = 33;
    private static final int INDEX_USERTAG4 = 34;
    private static final int INDEX_VALIDFLAG = 35;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysUserCaseRSBase proxyPSSysUserCaseRSBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean colorDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppssysactoridDirtyFlag = false;
    private boolean ppssysactornameDirtyFlag = false;
    private boolean ppssysusercaseidDirtyFlag = false;
    private boolean ppssysusercasenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysactoridDirtyFlag = false;
    private boolean pssysactornameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysusercaseidDirtyFlag = false;
    private boolean pssysusercasenameDirtyFlag = false;
    private boolean pssysusercasersidDirtyFlag = false;
    private boolean pssysusercasersnameDirtyFlag = false;
    private boolean rsmodeDirtyFlag = false;
    private boolean rstagDirtyFlag = false;
    private boolean rstag2DirtyFlag = false;
    private boolean rstag3DirtyFlag = false;
    private boolean rstag4DirtyFlag = false;
    private boolean rstypeDirtyFlag = false;
    private boolean tagsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
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
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppssysactorid")
    private String ppssysactorid;
    @Column(name="ppssysactorname")
    private String ppssysactorname;
    @Column(name="ppssysusercaseid")
    private String ppssysusercaseid;
    @Column(name="ppssysusercasename")
    private String ppssysusercasename;
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
    @Column(name="pssysusercaseid")
    private String pssysusercaseid;
    @Column(name="pssysusercasename")
    private String pssysusercasename;
    @Column(name="pssysusercasersid")
    private String pssysusercasersid;
    @Column(name="pssysusercasersname")
    private String pssysusercasersname;
    @Column(name="rsmode")
    private String rsmode;
    @Column(name="rstag")
    private String rstag;
    @Column(name="rstag2")
    private String rstag2;
    @Column(name="rstag3")
    private String rstag3;
    @Column(name="rstag4")
    private String rstag4;
    @Column(name="rstype")
    private String rstype;
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
    private Integer objPPSSysActorLock = new Integer(1);
    private PSSysActor ppssysactor = null;
    private Integer objPSSysActorLock = new Integer(1);
    private PSSysActor pssysactor = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPPSSysUserCaseLock = new Integer(1);
    private PSSysUserCase ppssysusercase = null;
    private Integer objPSSysUserCaseLock = new Integer(1);
    private PSSysUserCase pssysusercase = null;

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

    public void setPPSSysActorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysActorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysactorid = string;
        this.ppssysactoridDirtyFlag = true;
    }

    public String getPPSSysActorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysActorId();
        }
        return this.ppssysactorid;
    }

    public boolean isPPSSysActorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysActorIdDirty();
        }
        return this.ppssysactoridDirtyFlag;
    }

    public void resetPPSSysActorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysActorId();
            return;
        }
        this.ppssysactoridDirtyFlag = false;
        this.ppssysactorid = null;
    }

    public void setPPSSysActorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysActorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysactorname = string;
        this.ppssysactornameDirtyFlag = true;
    }

    public String getPPSSysActorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysActorName();
        }
        return this.ppssysactorname;
    }

    public boolean isPPSSysActorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysActorNameDirty();
        }
        return this.ppssysactornameDirtyFlag;
    }

    public void resetPPSSysActorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysActorName();
            return;
        }
        this.ppssysactornameDirtyFlag = false;
        this.ppssysactorname = null;
    }

    public void setPPSSysUserCaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysUserCaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysusercaseid = string;
        this.ppssysusercaseidDirtyFlag = true;
    }

    public String getPPSSysUserCaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysUserCaseId();
        }
        return this.ppssysusercaseid;
    }

    public boolean isPPSSysUserCaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysUserCaseIdDirty();
        }
        return this.ppssysusercaseidDirtyFlag;
    }

    public void resetPPSSysUserCaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysUserCaseId();
            return;
        }
        this.ppssysusercaseidDirtyFlag = false;
        this.ppssysusercaseid = null;
    }

    public void setPPSSysUserCaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysUserCaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysusercasename = string;
        this.ppssysusercasenameDirtyFlag = true;
    }

    public String getPPSSysUserCaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysUserCaseName();
        }
        return this.ppssysusercasename;
    }

    public boolean isPPSSysUserCaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysUserCaseNameDirty();
        }
        return this.ppssysusercasenameDirtyFlag;
    }

    public void resetPPSSysUserCaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysUserCaseName();
            return;
        }
        this.ppssysusercasenameDirtyFlag = false;
        this.ppssysusercasename = null;
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

    public void setPSSysUserCaseRSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserCaseRSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusercasersid = string;
        this.pssysusercasersidDirtyFlag = true;
    }

    public String getPSSysUserCaseRSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCaseRSId();
        }
        return this.pssysusercasersid;
    }

    public boolean isPSSysUserCaseRSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserCaseRSIdDirty();
        }
        return this.pssysusercasersidDirtyFlag;
    }

    public void resetPSSysUserCaseRSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserCaseRSId();
            return;
        }
        this.pssysusercasersidDirtyFlag = false;
        this.pssysusercasersid = null;
    }

    public void setPSSysUserCaseRSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserCaseRSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusercasersname = string;
        this.pssysusercasersnameDirtyFlag = true;
    }

    public String getPSSysUserCaseRSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCaseRSName();
        }
        return this.pssysusercasersname;
    }

    public boolean isPSSysUserCaseRSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserCaseRSNameDirty();
        }
        return this.pssysusercasersnameDirtyFlag;
    }

    public void resetPSSysUserCaseRSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserCaseRSName();
            return;
        }
        this.pssysusercasersnameDirtyFlag = false;
        this.pssysusercasersname = null;
    }

    public void setRSMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rsmode = string;
        this.rsmodeDirtyFlag = true;
    }

    public String getRSMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSMode();
        }
        return this.rsmode;
    }

    public boolean isRSModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSModeDirty();
        }
        return this.rsmodeDirtyFlag;
    }

    public void resetRSMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSMode();
            return;
        }
        this.rsmodeDirtyFlag = false;
        this.rsmode = null;
    }

    public void setRSTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rstag = string;
        this.rstagDirtyFlag = true;
    }

    public String getRSTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSTag();
        }
        return this.rstag;
    }

    public boolean isRSTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSTagDirty();
        }
        return this.rstagDirtyFlag;
    }

    public void resetRSTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSTag();
            return;
        }
        this.rstagDirtyFlag = false;
        this.rstag = null;
    }

    public void setRSTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rstag2 = string;
        this.rstag2DirtyFlag = true;
    }

    public String getRSTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSTag2();
        }
        return this.rstag2;
    }

    public boolean isRSTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSTag2Dirty();
        }
        return this.rstag2DirtyFlag;
    }

    public void resetRSTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSTag2();
            return;
        }
        this.rstag2DirtyFlag = false;
        this.rstag2 = null;
    }

    public void setRSTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rstag3 = string;
        this.rstag3DirtyFlag = true;
    }

    public String getRSTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSTag3();
        }
        return this.rstag3;
    }

    public boolean isRSTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSTag3Dirty();
        }
        return this.rstag3DirtyFlag;
    }

    public void resetRSTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSTag3();
            return;
        }
        this.rstag3DirtyFlag = false;
        this.rstag3 = null;
    }

    public void setRSTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rstag4 = string;
        this.rstag4DirtyFlag = true;
    }

    public String getRSTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSTag4();
        }
        return this.rstag4;
    }

    public boolean isRSTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSTag4Dirty();
        }
        return this.rstag4DirtyFlag;
    }

    public void resetRSTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSTag4();
            return;
        }
        this.rstag4DirtyFlag = false;
        this.rstag4 = null;
    }

    public void setRSType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRSType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rstype = string;
        this.rstypeDirtyFlag = true;
    }

    public String getRSType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRSType();
        }
        return this.rstype;
    }

    public boolean isRSTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRSTypeDirty();
        }
        return this.rstypeDirtyFlag;
    }

    public void resetRSType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRSType();
            return;
        }
        this.rstypeDirtyFlag = false;
        this.rstype = null;
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
        PSSysUserCaseRSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysUserCaseRSBase pSSysUserCaseRSBase) {
        pSSysUserCaseRSBase.resetCodeName();
        pSSysUserCaseRSBase.resetColor();
        pSSysUserCaseRSBase.resetContent();
        pSSysUserCaseRSBase.resetCreateDate();
        pSSysUserCaseRSBase.resetCreateMan();
        pSSysUserCaseRSBase.resetMemo();
        pSSysUserCaseRSBase.resetOrderValue();
        pSSysUserCaseRSBase.resetPPSSysActorId();
        pSSysUserCaseRSBase.resetPPSSysActorName();
        pSSysUserCaseRSBase.resetPPSSysUserCaseId();
        pSSysUserCaseRSBase.resetPPSSysUserCaseName();
        pSSysUserCaseRSBase.resetPSModuleId();
        pSSysUserCaseRSBase.resetPSModuleName();
        pSSysUserCaseRSBase.resetPSSysActorId();
        pSSysUserCaseRSBase.resetPSSysActorName();
        pSSysUserCaseRSBase.resetPSSystemId();
        pSSysUserCaseRSBase.resetPSSystemName();
        pSSysUserCaseRSBase.resetPSSysUserCaseId();
        pSSysUserCaseRSBase.resetPSSysUserCaseName();
        pSSysUserCaseRSBase.resetPSSysUserCaseRSId();
        pSSysUserCaseRSBase.resetPSSysUserCaseRSName();
        pSSysUserCaseRSBase.resetRSMode();
        pSSysUserCaseRSBase.resetRSTag();
        pSSysUserCaseRSBase.resetRSTag2();
        pSSysUserCaseRSBase.resetRSTag3();
        pSSysUserCaseRSBase.resetRSTag4();
        pSSysUserCaseRSBase.resetRSType();
        pSSysUserCaseRSBase.resetTags();
        pSSysUserCaseRSBase.resetUpdateDate();
        pSSysUserCaseRSBase.resetUpdateMan();
        pSSysUserCaseRSBase.resetUserCat();
        pSSysUserCaseRSBase.resetUserTag();
        pSSysUserCaseRSBase.resetUserTag2();
        pSSysUserCaseRSBase.resetUserTag3();
        pSSysUserCaseRSBase.resetUserTag4();
        pSSysUserCaseRSBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSSysActorIdDirty()) {
            hashMap.put(FIELD_PPSSYSACTORID, this.getPPSSysActorId());
        }
        if (!bl || this.isPPSSysActorNameDirty()) {
            hashMap.put(FIELD_PPSSYSACTORNAME, this.getPPSSysActorName());
        }
        if (!bl || this.isPPSSysUserCaseIdDirty()) {
            hashMap.put(FIELD_PPSSYSUSERCASEID, this.getPPSSysUserCaseId());
        }
        if (!bl || this.isPPSSysUserCaseNameDirty()) {
            hashMap.put(FIELD_PPSSYSUSERCASENAME, this.getPPSSysUserCaseName());
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
        if (!bl || this.isPSSysUserCaseIdDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASEID, this.getPSSysUserCaseId());
        }
        if (!bl || this.isPSSysUserCaseNameDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASENAME, this.getPSSysUserCaseName());
        }
        if (!bl || this.isPSSysUserCaseRSIdDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASERSID, this.getPSSysUserCaseRSId());
        }
        if (!bl || this.isPSSysUserCaseRSNameDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASERSNAME, this.getPSSysUserCaseRSName());
        }
        if (!bl || this.isRSModeDirty()) {
            hashMap.put(FIELD_RSMODE, this.getRSMode());
        }
        if (!bl || this.isRSTagDirty()) {
            hashMap.put(FIELD_RSTAG, this.getRSTag());
        }
        if (!bl || this.isRSTag2Dirty()) {
            hashMap.put(FIELD_RSTAG2, this.getRSTag2());
        }
        if (!bl || this.isRSTag3Dirty()) {
            hashMap.put(FIELD_RSTAG3, this.getRSTag3());
        }
        if (!bl || this.isRSTag4Dirty()) {
            hashMap.put(FIELD_RSTAG4, this.getRSTag4());
        }
        if (!bl || this.isRSTypeDirty()) {
            hashMap.put(FIELD_RSTYPE, this.getRSType());
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
        return PSSysUserCaseRSBase.get(this, n);
    }

    private static Object get(PSSysUserCaseRSBase pSSysUserCaseRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserCaseRSBase.getCodeName();
            }
            case 1: {
                return pSSysUserCaseRSBase.getColor();
            }
            case 2: {
                return pSSysUserCaseRSBase.getContent();
            }
            case 3: {
                return pSSysUserCaseRSBase.getCreateDate();
            }
            case 4: {
                return pSSysUserCaseRSBase.getCreateMan();
            }
            case 5: {
                return pSSysUserCaseRSBase.getMemo();
            }
            case 6: {
                return pSSysUserCaseRSBase.getOrderValue();
            }
            case 7: {
                return pSSysUserCaseRSBase.getPPSSysActorId();
            }
            case 8: {
                return pSSysUserCaseRSBase.getPPSSysActorName();
            }
            case 9: {
                return pSSysUserCaseRSBase.getPPSSysUserCaseId();
            }
            case 10: {
                return pSSysUserCaseRSBase.getPPSSysUserCaseName();
            }
            case 11: {
                return pSSysUserCaseRSBase.getPSModuleId();
            }
            case 12: {
                return pSSysUserCaseRSBase.getPSModuleName();
            }
            case 13: {
                return pSSysUserCaseRSBase.getPSSysActorId();
            }
            case 14: {
                return pSSysUserCaseRSBase.getPSSysActorName();
            }
            case 15: {
                return pSSysUserCaseRSBase.getPSSystemId();
            }
            case 16: {
                return pSSysUserCaseRSBase.getPSSystemName();
            }
            case 17: {
                return pSSysUserCaseRSBase.getPSSysUserCaseId();
            }
            case 18: {
                return pSSysUserCaseRSBase.getPSSysUserCaseName();
            }
            case 19: {
                return pSSysUserCaseRSBase.getPSSysUserCaseRSId();
            }
            case 20: {
                return pSSysUserCaseRSBase.getPSSysUserCaseRSName();
            }
            case 21: {
                return pSSysUserCaseRSBase.getRSMode();
            }
            case 22: {
                return pSSysUserCaseRSBase.getRSTag();
            }
            case 23: {
                return pSSysUserCaseRSBase.getRSTag2();
            }
            case 24: {
                return pSSysUserCaseRSBase.getRSTag3();
            }
            case 25: {
                return pSSysUserCaseRSBase.getRSTag4();
            }
            case 26: {
                return pSSysUserCaseRSBase.getRSType();
            }
            case 27: {
                return pSSysUserCaseRSBase.getTags();
            }
            case 28: {
                return pSSysUserCaseRSBase.getUpdateDate();
            }
            case 29: {
                return pSSysUserCaseRSBase.getUpdateMan();
            }
            case 30: {
                return pSSysUserCaseRSBase.getUserCat();
            }
            case 31: {
                return pSSysUserCaseRSBase.getUserTag();
            }
            case 32: {
                return pSSysUserCaseRSBase.getUserTag2();
            }
            case 33: {
                return pSSysUserCaseRSBase.getUserTag3();
            }
            case 34: {
                return pSSysUserCaseRSBase.getUserTag4();
            }
            case 35: {
                return pSSysUserCaseRSBase.getValidFlag();
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
        PSSysUserCaseRSBase.set(this, n, object);
    }

    private static void set(PSSysUserCaseRSBase pSSysUserCaseRSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysUserCaseRSBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysUserCaseRSBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysUserCaseRSBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysUserCaseRSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSysUserCaseRSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysUserCaseRSBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysUserCaseRSBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysUserCaseRSBase.setPPSSysActorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysUserCaseRSBase.setPPSSysActorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysUserCaseRSBase.setPPSSysUserCaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysUserCaseRSBase.setPPSSysUserCaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysUserCaseRSBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysUserCaseRSBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysUserCaseRSBase.setPSSysActorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysUserCaseRSBase.setPSSysActorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysUserCaseRSBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysUserCaseRSBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysUserCaseRSBase.setPSSysUserCaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysUserCaseRSBase.setPSSysUserCaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysUserCaseRSBase.setPSSysUserCaseRSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysUserCaseRSBase.setPSSysUserCaseRSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysUserCaseRSBase.setRSMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysUserCaseRSBase.setRSTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysUserCaseRSBase.setRSTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysUserCaseRSBase.setRSTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysUserCaseRSBase.setRSTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysUserCaseRSBase.setRSType(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysUserCaseRSBase.setTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysUserCaseRSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSSysUserCaseRSBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysUserCaseRSBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysUserCaseRSBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysUserCaseRSBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysUserCaseRSBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysUserCaseRSBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysUserCaseRSBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysUserCaseRSBase.isNull(this, n);
    }

    private static boolean isNull(PSSysUserCaseRSBase pSSysUserCaseRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserCaseRSBase.getCodeName() == null;
            }
            case 1: {
                return pSSysUserCaseRSBase.getColor() == null;
            }
            case 2: {
                return pSSysUserCaseRSBase.getContent() == null;
            }
            case 3: {
                return pSSysUserCaseRSBase.getCreateDate() == null;
            }
            case 4: {
                return pSSysUserCaseRSBase.getCreateMan() == null;
            }
            case 5: {
                return pSSysUserCaseRSBase.getMemo() == null;
            }
            case 6: {
                return pSSysUserCaseRSBase.getOrderValue() == null;
            }
            case 7: {
                return pSSysUserCaseRSBase.getPPSSysActorId() == null;
            }
            case 8: {
                return pSSysUserCaseRSBase.getPPSSysActorName() == null;
            }
            case 9: {
                return pSSysUserCaseRSBase.getPPSSysUserCaseId() == null;
            }
            case 10: {
                return pSSysUserCaseRSBase.getPPSSysUserCaseName() == null;
            }
            case 11: {
                return pSSysUserCaseRSBase.getPSModuleId() == null;
            }
            case 12: {
                return pSSysUserCaseRSBase.getPSModuleName() == null;
            }
            case 13: {
                return pSSysUserCaseRSBase.getPSSysActorId() == null;
            }
            case 14: {
                return pSSysUserCaseRSBase.getPSSysActorName() == null;
            }
            case 15: {
                return pSSysUserCaseRSBase.getPSSystemId() == null;
            }
            case 16: {
                return pSSysUserCaseRSBase.getPSSystemName() == null;
            }
            case 17: {
                return pSSysUserCaseRSBase.getPSSysUserCaseId() == null;
            }
            case 18: {
                return pSSysUserCaseRSBase.getPSSysUserCaseName() == null;
            }
            case 19: {
                return pSSysUserCaseRSBase.getPSSysUserCaseRSId() == null;
            }
            case 20: {
                return pSSysUserCaseRSBase.getPSSysUserCaseRSName() == null;
            }
            case 21: {
                return pSSysUserCaseRSBase.getRSMode() == null;
            }
            case 22: {
                return pSSysUserCaseRSBase.getRSTag() == null;
            }
            case 23: {
                return pSSysUserCaseRSBase.getRSTag2() == null;
            }
            case 24: {
                return pSSysUserCaseRSBase.getRSTag3() == null;
            }
            case 25: {
                return pSSysUserCaseRSBase.getRSTag4() == null;
            }
            case 26: {
                return pSSysUserCaseRSBase.getRSType() == null;
            }
            case 27: {
                return pSSysUserCaseRSBase.getTags() == null;
            }
            case 28: {
                return pSSysUserCaseRSBase.getUpdateDate() == null;
            }
            case 29: {
                return pSSysUserCaseRSBase.getUpdateMan() == null;
            }
            case 30: {
                return pSSysUserCaseRSBase.getUserCat() == null;
            }
            case 31: {
                return pSSysUserCaseRSBase.getUserTag() == null;
            }
            case 32: {
                return pSSysUserCaseRSBase.getUserTag2() == null;
            }
            case 33: {
                return pSSysUserCaseRSBase.getUserTag3() == null;
            }
            case 34: {
                return pSSysUserCaseRSBase.getUserTag4() == null;
            }
            case 35: {
                return pSSysUserCaseRSBase.getValidFlag() == null;
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
        return PSSysUserCaseRSBase.contains(this, n);
    }

    private static boolean contains(PSSysUserCaseRSBase pSSysUserCaseRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserCaseRSBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysUserCaseRSBase.isColorDirty();
            }
            case 2: {
                return pSSysUserCaseRSBase.isContentDirty();
            }
            case 3: {
                return pSSysUserCaseRSBase.isCreateDateDirty();
            }
            case 4: {
                return pSSysUserCaseRSBase.isCreateManDirty();
            }
            case 5: {
                return pSSysUserCaseRSBase.isMemoDirty();
            }
            case 6: {
                return pSSysUserCaseRSBase.isOrderValueDirty();
            }
            case 7: {
                return pSSysUserCaseRSBase.isPPSSysActorIdDirty();
            }
            case 8: {
                return pSSysUserCaseRSBase.isPPSSysActorNameDirty();
            }
            case 9: {
                return pSSysUserCaseRSBase.isPPSSysUserCaseIdDirty();
            }
            case 10: {
                return pSSysUserCaseRSBase.isPPSSysUserCaseNameDirty();
            }
            case 11: {
                return pSSysUserCaseRSBase.isPSModuleIdDirty();
            }
            case 12: {
                return pSSysUserCaseRSBase.isPSModuleNameDirty();
            }
            case 13: {
                return pSSysUserCaseRSBase.isPSSysActorIdDirty();
            }
            case 14: {
                return pSSysUserCaseRSBase.isPSSysActorNameDirty();
            }
            case 15: {
                return pSSysUserCaseRSBase.isPSSystemIdDirty();
            }
            case 16: {
                return pSSysUserCaseRSBase.isPSSystemNameDirty();
            }
            case 17: {
                return pSSysUserCaseRSBase.isPSSysUserCaseIdDirty();
            }
            case 18: {
                return pSSysUserCaseRSBase.isPSSysUserCaseNameDirty();
            }
            case 19: {
                return pSSysUserCaseRSBase.isPSSysUserCaseRSIdDirty();
            }
            case 20: {
                return pSSysUserCaseRSBase.isPSSysUserCaseRSNameDirty();
            }
            case 21: {
                return pSSysUserCaseRSBase.isRSModeDirty();
            }
            case 22: {
                return pSSysUserCaseRSBase.isRSTagDirty();
            }
            case 23: {
                return pSSysUserCaseRSBase.isRSTag2Dirty();
            }
            case 24: {
                return pSSysUserCaseRSBase.isRSTag3Dirty();
            }
            case 25: {
                return pSSysUserCaseRSBase.isRSTag4Dirty();
            }
            case 26: {
                return pSSysUserCaseRSBase.isRSTypeDirty();
            }
            case 27: {
                return pSSysUserCaseRSBase.isTagsDirty();
            }
            case 28: {
                return pSSysUserCaseRSBase.isUpdateDateDirty();
            }
            case 29: {
                return pSSysUserCaseRSBase.isUpdateManDirty();
            }
            case 30: {
                return pSSysUserCaseRSBase.isUserCatDirty();
            }
            case 31: {
                return pSSysUserCaseRSBase.isUserTagDirty();
            }
            case 32: {
                return pSSysUserCaseRSBase.isUserTag2Dirty();
            }
            case 33: {
                return pSSysUserCaseRSBase.isUserTag3Dirty();
            }
            case 34: {
                return pSSysUserCaseRSBase.isUserTag4Dirty();
            }
            case 35: {
                return pSSysUserCaseRSBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysUserCaseRSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysUserCaseRSBase pSSysUserCaseRSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysUserCaseRSBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getColor()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getContent()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getPPSSysActorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysactorid", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getPPSSysActorId()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getPPSSysActorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysactorname", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getPPSSysActorName()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getPPSSysUserCaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysusercaseid", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getPPSSysUserCaseId()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getPPSSysUserCaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysusercasename", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getPPSSysUserCaseName()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getPSSysActorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysactorid", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getPSSysActorId()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getPSSysActorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysactorname", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getPSSysActorName()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getPSSysUserCaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercaseid", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getPSSysUserCaseId()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getPSSysUserCaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercasename", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getPSSysUserCaseName()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getPSSysUserCaseRSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercasersid", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getPSSysUserCaseRSId()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getPSSysUserCaseRSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercasersname", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getPSSysUserCaseRSName()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getRSMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rsmode", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getRSMode()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getRSTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rstag", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getRSTag()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getRSTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rstag2", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getRSTag2()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getRSTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rstag3", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getRSTag3()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getRSTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rstag4", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getRSTag4()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getRSType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rstype", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getRSType()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tags", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getTags()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysUserCaseRSBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysUserCaseRSBase.getJSONValue((Object)pSSysUserCaseRSBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysUserCaseRSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysUserCaseRSBase pSSysUserCaseRSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysUserCaseRSBase.getCodeName() != null) {
            object = pSSysUserCaseRSBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUserCaseRSBase.getColor() != null) {
            object = pSSysUserCaseRSBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUserCaseRSBase.getContent() != null) {
            object = pSSysUserCaseRSBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getCreateDate() != null) {
            object = pSSysUserCaseRSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUserCaseRSBase.getCreateMan() != null) {
            object = pSSysUserCaseRSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getMemo() != null) {
            object = pSSysUserCaseRSBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getOrderValue() != null) {
            object = pSSysUserCaseRSBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUserCaseRSBase.getPPSSysActorId() != null) {
            object = pSSysUserCaseRSBase.getPPSSysActorId();
            xmlNode.setAttribute(FIELD_PPSSYSACTORID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getPPSSysActorName() != null) {
            object = pSSysUserCaseRSBase.getPPSSysActorName();
            xmlNode.setAttribute(FIELD_PPSSYSACTORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getPPSSysUserCaseId() != null) {
            object = pSSysUserCaseRSBase.getPPSSysUserCaseId();
            xmlNode.setAttribute(FIELD_PPSSYSUSERCASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getPPSSysUserCaseName() != null) {
            object = pSSysUserCaseRSBase.getPPSSysUserCaseName();
            xmlNode.setAttribute(FIELD_PPSSYSUSERCASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getPSModuleId() != null) {
            object = pSSysUserCaseRSBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getPSModuleName() != null) {
            object = pSSysUserCaseRSBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getPSSysActorId() != null) {
            object = pSSysUserCaseRSBase.getPSSysActorId();
            xmlNode.setAttribute(FIELD_PSSYSACTORID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getPSSysActorName() != null) {
            object = pSSysUserCaseRSBase.getPSSysActorName();
            xmlNode.setAttribute(FIELD_PSSYSACTORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getPSSystemId() != null) {
            object = pSSysUserCaseRSBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getPSSystemName() != null) {
            object = pSSysUserCaseRSBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getPSSysUserCaseId() != null) {
            object = pSSysUserCaseRSBase.getPSSysUserCaseId();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getPSSysUserCaseName() != null) {
            object = pSSysUserCaseRSBase.getPSSysUserCaseName();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getPSSysUserCaseRSId() != null) {
            object = pSSysUserCaseRSBase.getPSSysUserCaseRSId();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASERSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getPSSysUserCaseRSName() != null) {
            object = pSSysUserCaseRSBase.getPSSysUserCaseRSName();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASERSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getRSMode() != null) {
            object = pSSysUserCaseRSBase.getRSMode();
            xmlNode.setAttribute(FIELD_RSMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getRSTag() != null) {
            object = pSSysUserCaseRSBase.getRSTag();
            xmlNode.setAttribute(FIELD_RSTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getRSTag2() != null) {
            object = pSSysUserCaseRSBase.getRSTag2();
            xmlNode.setAttribute(FIELD_RSTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getRSTag3() != null) {
            object = pSSysUserCaseRSBase.getRSTag3();
            xmlNode.setAttribute(FIELD_RSTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getRSTag4() != null) {
            object = pSSysUserCaseRSBase.getRSTag4();
            xmlNode.setAttribute(FIELD_RSTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getRSType() != null) {
            object = pSSysUserCaseRSBase.getRSType();
            xmlNode.setAttribute(FIELD_RSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getTags() != null) {
            object = pSSysUserCaseRSBase.getTags();
            xmlNode.setAttribute(FIELD_TAGS, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getUpdateDate() != null) {
            object = pSSysUserCaseRSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUserCaseRSBase.getUpdateMan() != null) {
            object = pSSysUserCaseRSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getUserCat() != null) {
            object = pSSysUserCaseRSBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getUserTag() != null) {
            object = pSSysUserCaseRSBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getUserTag2() != null) {
            object = pSSysUserCaseRSBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getUserTag3() != null) {
            object = pSSysUserCaseRSBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getUserTag4() != null) {
            object = pSSysUserCaseRSBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserCaseRSBase.getValidFlag() != null) {
            object = pSSysUserCaseRSBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysUserCaseRSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysUserCaseRSBase pSSysUserCaseRSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysUserCaseRSBase.isCodeNameDirty() && (bl || pSSysUserCaseRSBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysUserCaseRSBase.getCodeName());
        }
        if (pSSysUserCaseRSBase.isColorDirty() && (bl || pSSysUserCaseRSBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSSysUserCaseRSBase.getColor());
        }
        if (pSSysUserCaseRSBase.isContentDirty() && (bl || pSSysUserCaseRSBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSSysUserCaseRSBase.getContent());
        }
        if (pSSysUserCaseRSBase.isCreateDateDirty() && (bl || pSSysUserCaseRSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysUserCaseRSBase.getCreateDate());
        }
        if (pSSysUserCaseRSBase.isCreateManDirty() && (bl || pSSysUserCaseRSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysUserCaseRSBase.getCreateMan());
        }
        if (pSSysUserCaseRSBase.isMemoDirty() && (bl || pSSysUserCaseRSBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysUserCaseRSBase.getMemo());
        }
        if (pSSysUserCaseRSBase.isOrderValueDirty() && (bl || pSSysUserCaseRSBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysUserCaseRSBase.getOrderValue());
        }
        if (pSSysUserCaseRSBase.isPPSSysActorIdDirty() && (bl || pSSysUserCaseRSBase.getPPSSysActorId() != null)) {
            iDataObject.set(FIELD_PPSSYSACTORID, (Object)pSSysUserCaseRSBase.getPPSSysActorId());
        }
        if (pSSysUserCaseRSBase.isPPSSysActorNameDirty() && (bl || pSSysUserCaseRSBase.getPPSSysActorName() != null)) {
            iDataObject.set(FIELD_PPSSYSACTORNAME, (Object)pSSysUserCaseRSBase.getPPSSysActorName());
        }
        if (pSSysUserCaseRSBase.isPPSSysUserCaseIdDirty() && (bl || pSSysUserCaseRSBase.getPPSSysUserCaseId() != null)) {
            iDataObject.set(FIELD_PPSSYSUSERCASEID, (Object)pSSysUserCaseRSBase.getPPSSysUserCaseId());
        }
        if (pSSysUserCaseRSBase.isPPSSysUserCaseNameDirty() && (bl || pSSysUserCaseRSBase.getPPSSysUserCaseName() != null)) {
            iDataObject.set(FIELD_PPSSYSUSERCASENAME, (Object)pSSysUserCaseRSBase.getPPSSysUserCaseName());
        }
        if (pSSysUserCaseRSBase.isPSModuleIdDirty() && (bl || pSSysUserCaseRSBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysUserCaseRSBase.getPSModuleId());
        }
        if (pSSysUserCaseRSBase.isPSModuleNameDirty() && (bl || pSSysUserCaseRSBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysUserCaseRSBase.getPSModuleName());
        }
        if (pSSysUserCaseRSBase.isPSSysActorIdDirty() && (bl || pSSysUserCaseRSBase.getPSSysActorId() != null)) {
            iDataObject.set(FIELD_PSSYSACTORID, (Object)pSSysUserCaseRSBase.getPSSysActorId());
        }
        if (pSSysUserCaseRSBase.isPSSysActorNameDirty() && (bl || pSSysUserCaseRSBase.getPSSysActorName() != null)) {
            iDataObject.set(FIELD_PSSYSACTORNAME, (Object)pSSysUserCaseRSBase.getPSSysActorName());
        }
        if (pSSysUserCaseRSBase.isPSSystemIdDirty() && (bl || pSSysUserCaseRSBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysUserCaseRSBase.getPSSystemId());
        }
        if (pSSysUserCaseRSBase.isPSSystemNameDirty() && (bl || pSSysUserCaseRSBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysUserCaseRSBase.getPSSystemName());
        }
        if (pSSysUserCaseRSBase.isPSSysUserCaseIdDirty() && (bl || pSSysUserCaseRSBase.getPSSysUserCaseId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASEID, (Object)pSSysUserCaseRSBase.getPSSysUserCaseId());
        }
        if (pSSysUserCaseRSBase.isPSSysUserCaseNameDirty() && (bl || pSSysUserCaseRSBase.getPSSysUserCaseName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASENAME, (Object)pSSysUserCaseRSBase.getPSSysUserCaseName());
        }
        if (pSSysUserCaseRSBase.isPSSysUserCaseRSIdDirty() && (bl || pSSysUserCaseRSBase.getPSSysUserCaseRSId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASERSID, (Object)pSSysUserCaseRSBase.getPSSysUserCaseRSId());
        }
        if (pSSysUserCaseRSBase.isPSSysUserCaseRSNameDirty() && (bl || pSSysUserCaseRSBase.getPSSysUserCaseRSName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASERSNAME, (Object)pSSysUserCaseRSBase.getPSSysUserCaseRSName());
        }
        if (pSSysUserCaseRSBase.isRSModeDirty() && (bl || pSSysUserCaseRSBase.getRSMode() != null)) {
            iDataObject.set(FIELD_RSMODE, (Object)pSSysUserCaseRSBase.getRSMode());
        }
        if (pSSysUserCaseRSBase.isRSTagDirty() && (bl || pSSysUserCaseRSBase.getRSTag() != null)) {
            iDataObject.set(FIELD_RSTAG, (Object)pSSysUserCaseRSBase.getRSTag());
        }
        if (pSSysUserCaseRSBase.isRSTag2Dirty() && (bl || pSSysUserCaseRSBase.getRSTag2() != null)) {
            iDataObject.set(FIELD_RSTAG2, (Object)pSSysUserCaseRSBase.getRSTag2());
        }
        if (pSSysUserCaseRSBase.isRSTag3Dirty() && (bl || pSSysUserCaseRSBase.getRSTag3() != null)) {
            iDataObject.set(FIELD_RSTAG3, (Object)pSSysUserCaseRSBase.getRSTag3());
        }
        if (pSSysUserCaseRSBase.isRSTag4Dirty() && (bl || pSSysUserCaseRSBase.getRSTag4() != null)) {
            iDataObject.set(FIELD_RSTAG4, (Object)pSSysUserCaseRSBase.getRSTag4());
        }
        if (pSSysUserCaseRSBase.isRSTypeDirty() && (bl || pSSysUserCaseRSBase.getRSType() != null)) {
            iDataObject.set(FIELD_RSTYPE, (Object)pSSysUserCaseRSBase.getRSType());
        }
        if (pSSysUserCaseRSBase.isTagsDirty() && (bl || pSSysUserCaseRSBase.getTags() != null)) {
            iDataObject.set(FIELD_TAGS, (Object)pSSysUserCaseRSBase.getTags());
        }
        if (pSSysUserCaseRSBase.isUpdateDateDirty() && (bl || pSSysUserCaseRSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysUserCaseRSBase.getUpdateDate());
        }
        if (pSSysUserCaseRSBase.isUpdateManDirty() && (bl || pSSysUserCaseRSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysUserCaseRSBase.getUpdateMan());
        }
        if (pSSysUserCaseRSBase.isUserCatDirty() && (bl || pSSysUserCaseRSBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysUserCaseRSBase.getUserCat());
        }
        if (pSSysUserCaseRSBase.isUserTagDirty() && (bl || pSSysUserCaseRSBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysUserCaseRSBase.getUserTag());
        }
        if (pSSysUserCaseRSBase.isUserTag2Dirty() && (bl || pSSysUserCaseRSBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysUserCaseRSBase.getUserTag2());
        }
        if (pSSysUserCaseRSBase.isUserTag3Dirty() && (bl || pSSysUserCaseRSBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysUserCaseRSBase.getUserTag3());
        }
        if (pSSysUserCaseRSBase.isUserTag4Dirty() && (bl || pSSysUserCaseRSBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysUserCaseRSBase.getUserTag4());
        }
        if (pSSysUserCaseRSBase.isValidFlagDirty() && (bl || pSSysUserCaseRSBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysUserCaseRSBase.getValidFlag());
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
        return PSSysUserCaseRSBase.remove(this, n);
    }

    private static boolean remove(PSSysUserCaseRSBase pSSysUserCaseRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysUserCaseRSBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysUserCaseRSBase.resetColor();
                return true;
            }
            case 2: {
                pSSysUserCaseRSBase.resetContent();
                return true;
            }
            case 3: {
                pSSysUserCaseRSBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSysUserCaseRSBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSysUserCaseRSBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysUserCaseRSBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSSysUserCaseRSBase.resetPPSSysActorId();
                return true;
            }
            case 8: {
                pSSysUserCaseRSBase.resetPPSSysActorName();
                return true;
            }
            case 9: {
                pSSysUserCaseRSBase.resetPPSSysUserCaseId();
                return true;
            }
            case 10: {
                pSSysUserCaseRSBase.resetPPSSysUserCaseName();
                return true;
            }
            case 11: {
                pSSysUserCaseRSBase.resetPSModuleId();
                return true;
            }
            case 12: {
                pSSysUserCaseRSBase.resetPSModuleName();
                return true;
            }
            case 13: {
                pSSysUserCaseRSBase.resetPSSysActorId();
                return true;
            }
            case 14: {
                pSSysUserCaseRSBase.resetPSSysActorName();
                return true;
            }
            case 15: {
                pSSysUserCaseRSBase.resetPSSystemId();
                return true;
            }
            case 16: {
                pSSysUserCaseRSBase.resetPSSystemName();
                return true;
            }
            case 17: {
                pSSysUserCaseRSBase.resetPSSysUserCaseId();
                return true;
            }
            case 18: {
                pSSysUserCaseRSBase.resetPSSysUserCaseName();
                return true;
            }
            case 19: {
                pSSysUserCaseRSBase.resetPSSysUserCaseRSId();
                return true;
            }
            case 20: {
                pSSysUserCaseRSBase.resetPSSysUserCaseRSName();
                return true;
            }
            case 21: {
                pSSysUserCaseRSBase.resetRSMode();
                return true;
            }
            case 22: {
                pSSysUserCaseRSBase.resetRSTag();
                return true;
            }
            case 23: {
                pSSysUserCaseRSBase.resetRSTag2();
                return true;
            }
            case 24: {
                pSSysUserCaseRSBase.resetRSTag3();
                return true;
            }
            case 25: {
                pSSysUserCaseRSBase.resetRSTag4();
                return true;
            }
            case 26: {
                pSSysUserCaseRSBase.resetRSType();
                return true;
            }
            case 27: {
                pSSysUserCaseRSBase.resetTags();
                return true;
            }
            case 28: {
                pSSysUserCaseRSBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSSysUserCaseRSBase.resetUpdateMan();
                return true;
            }
            case 30: {
                pSSysUserCaseRSBase.resetUserCat();
                return true;
            }
            case 31: {
                pSSysUserCaseRSBase.resetUserTag();
                return true;
            }
            case 32: {
                pSSysUserCaseRSBase.resetUserTag2();
                return true;
            }
            case 33: {
                pSSysUserCaseRSBase.resetUserTag3();
                return true;
            }
            case 34: {
                pSSysUserCaseRSBase.resetUserTag4();
                return true;
            }
            case 35: {
                pSSysUserCaseRSBase.resetValidFlag();
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
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysActor getPPSSysActor() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysActor();
        }
        if (this.getPPSSysActorId() == null) {
            return null;
        }
        Integer n = this.objPPSSysActorLock;
        synchronized (n) {
            if (this.ppssysactor != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysActorId(), (Object)this.ppssysactor.getPSSysActorId()) != 0L) {
                this.ppssysactor = null;
            }
            if (this.ppssysactor == null) {
                PSSysActor pSSysActor = new PSSysActor();
                pSSysActor.setPSSysActorId(this.getPPSSysActorId());
                PSSysActorService pSSysActorService = (PSSysActorService)ServiceGlobal.getService(PSSysActorService.class, (SessionFactory)this.getSessionFactory());
                pSSysActorService.autoGet((IEntity)pSSysActor);
                this.ppssysactor = pSSysActor;
            }
            return this.ppssysactor;
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
    public PSSysUserCase getPPSSysUserCase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysUserCase();
        }
        if (this.getPPSSysUserCaseId() == null) {
            return null;
        }
        Integer n = this.objPPSSysUserCaseLock;
        synchronized (n) {
            if (this.ppssysusercase != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysUserCaseId(), (Object)this.ppssysusercase.getPSSysUserCaseId()) != 0L) {
                this.ppssysusercase = null;
            }
            if (this.ppssysusercase == null) {
                PSSysUserCase pSSysUserCase = new PSSysUserCase();
                pSSysUserCase.setPSSysUserCaseId(this.getPPSSysUserCaseId());
                PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
                pSSysUserCaseService.autoGet((IEntity)pSSysUserCase);
                this.ppssysusercase = pSSysUserCase;
            }
            return this.ppssysusercase;
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
                pSSysUserCaseService.autoGet((IEntity)pSSysUserCase);
                this.pssysusercase = pSSysUserCase;
            }
            return this.pssysusercase;
        }
    }

    private PSSysUserCaseRSBase getProxyEntity() {
        return this.proxyPSSysUserCaseRSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysUserCaseRSBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysUserCaseRSBase) {
            this.proxyPSSysUserCaseRSBase = (PSSysUserCaseRSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseRSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_COLOR, 1);
        fieldIndexMap.put(FIELD_CONTENT, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PPSSYSACTORID, 7);
        fieldIndexMap.put(FIELD_PPSSYSACTORNAME, 8);
        fieldIndexMap.put(FIELD_PPSSYSUSERCASEID, 9);
        fieldIndexMap.put(FIELD_PPSSYSUSERCASENAME, 10);
        fieldIndexMap.put(FIELD_PSMODULEID, 11);
        fieldIndexMap.put(FIELD_PSMODULENAME, 12);
        fieldIndexMap.put(FIELD_PSSYSACTORID, 13);
        fieldIndexMap.put(FIELD_PSSYSACTORNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 15);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSUSERCASEID, 17);
        fieldIndexMap.put(FIELD_PSSYSUSERCASENAME, 18);
        fieldIndexMap.put(FIELD_PSSYSUSERCASERSID, 19);
        fieldIndexMap.put(FIELD_PSSYSUSERCASERSNAME, 20);
        fieldIndexMap.put(FIELD_RSMODE, 21);
        fieldIndexMap.put(FIELD_RSTAG, 22);
        fieldIndexMap.put(FIELD_RSTAG2, 23);
        fieldIndexMap.put(FIELD_RSTAG3, 24);
        fieldIndexMap.put(FIELD_RSTAG4, 25);
        fieldIndexMap.put(FIELD_RSTYPE, 26);
        fieldIndexMap.put(FIELD_TAGS, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
        fieldIndexMap.put(FIELD_USERCAT, 30);
        fieldIndexMap.put(FIELD_USERTAG, 31);
        fieldIndexMap.put(FIELD_USERTAG2, 32);
        fieldIndexMap.put(FIELD_USERTAG3, 33);
        fieldIndexMap.put(FIELD_USERTAG4, 34);
        fieldIndexMap.put(FIELD_VALIDFLAG, 35);
    }
}

