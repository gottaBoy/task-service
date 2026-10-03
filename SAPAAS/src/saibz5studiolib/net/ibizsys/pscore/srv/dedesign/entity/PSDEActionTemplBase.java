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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEActionTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEActionTemplBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PDTTEMPL = "PDTTEMPL";
    public static final String FIELD_PSDCCODESNIPPETID = "PSDCCODESNIPPETID";
    public static final String FIELD_PSDCCODESNIPPETNAME = "PSDCCODESNIPPETNAME";
    public static final String FIELD_PSDEACTIONTEMPLID = "PSDEACTIONTEMPLID";
    public static final String FIELD_PSDEACTIONTEMPLNAME = "PSDEACTIONTEMPLNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_TEMPLCODE2EX = "TEMPLCODE2EX";
    public static final String FIELD_TEMPLCODEEX = "TEMPLCODEEX";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_LOCKFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PDTTEMPL = 5;
    private static final int INDEX_PSDCCODESNIPPETID = 6;
    private static final int INDEX_PSDCCODESNIPPETNAME = 7;
    private static final int INDEX_PSDEACTIONTEMPLID = 8;
    private static final int INDEX_PSDEACTIONTEMPLNAME = 9;
    private static final int INDEX_PSMODULEID = 10;
    private static final int INDEX_PSMODULENAME = 11;
    private static final int INDEX_PSSYSTEMID = 12;
    private static final int INDEX_PSSYSTEMNAME = 13;
    private static final int INDEX_TEMPLCODE = 14;
    private static final int INDEX_TEMPLCODE2 = 15;
    private static final int INDEX_TEMPLCODE2EX = 16;
    private static final int INDEX_TEMPLCODEEX = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final int INDEX_USERCAT = 20;
    private static final int INDEX_USERTAG = 21;
    private static final int INDEX_USERTAG2 = 22;
    private static final int INDEX_USERTAG3 = 23;
    private static final int INDEX_USERTAG4 = 24;
    private static final int INDEX_VALIDFLAG = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEActionTemplBase proxyPSDEActionTemplBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pdttemplDirtyFlag = false;
    private boolean psdccodesnippetidDirtyFlag = false;
    private boolean psdccodesnippetnameDirtyFlag = false;
    private boolean psdeactiontemplidDirtyFlag = false;
    private boolean psdeactiontemplnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean templcode2exDirtyFlag = false;
    private boolean templcodeexDirtyFlag = false;
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
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="pdttempl")
    private String pdttempl;
    @Column(name="psdccodesnippetid")
    private String psdccodesnippetid;
    @Column(name="psdccodesnippetname")
    private String psdccodesnippetname;
    @Column(name="psdeactiontemplid")
    private String psdeactiontemplid;
    @Column(name="psdeactiontemplname")
    private String psdeactiontemplname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="templcode")
    private String templcode;
    @Column(name="templcode2")
    private String templcode2;
    @Column(name="templcode2ex")
    private String templcode2ex;
    @Column(name="templcodeex")
    private String templcodeex;
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
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
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

    public void setPDTTempl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPDTTempl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pdttempl = string;
        this.pdttemplDirtyFlag = true;
    }

    public String getPDTTempl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPDTTempl();
        }
        return this.pdttempl;
    }

    public boolean isPDTTemplDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPDTTemplDirty();
        }
        return this.pdttemplDirtyFlag;
    }

    public void resetPDTTempl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPDTTempl();
            return;
        }
        this.pdttemplDirtyFlag = false;
        this.pdttempl = null;
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

    public void setPSDEActionTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactiontemplid = string;
        this.psdeactiontemplidDirtyFlag = true;
    }

    public String getPSDEActionTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionTemplId();
        }
        return this.psdeactiontemplid;
    }

    public boolean isPSDEActionTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionTemplIdDirty();
        }
        return this.psdeactiontemplidDirtyFlag;
    }

    public void resetPSDEActionTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionTemplId();
            return;
        }
        this.psdeactiontemplidDirtyFlag = false;
        this.psdeactiontemplid = null;
    }

    public void setPSDEActionTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactiontemplname = string;
        this.psdeactiontemplnameDirtyFlag = true;
    }

    public String getPSDEActionTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionTemplName();
        }
        return this.psdeactiontemplname;
    }

    public boolean isPSDEActionTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionTemplNameDirty();
        }
        return this.psdeactiontemplnameDirtyFlag;
    }

    public void resetPSDEActionTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionTemplName();
            return;
        }
        this.psdeactiontemplnameDirtyFlag = false;
        this.psdeactiontemplname = null;
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

    public void setTemplCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode = string;
        this.templcodeDirtyFlag = true;
    }

    public String getTemplCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode();
        }
        return this.templcode;
    }

    public boolean isTemplCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeDirty();
        }
        return this.templcodeDirtyFlag;
    }

    public void resetTemplCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode();
            return;
        }
        this.templcodeDirtyFlag = false;
        this.templcode = null;
    }

    public void setTemplCode2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode2 = string;
        this.templcode2DirtyFlag = true;
    }

    public String getTemplCode2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode2();
        }
        return this.templcode2;
    }

    public boolean isTemplCode2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode2Dirty();
        }
        return this.templcode2DirtyFlag;
    }

    public void resetTemplCode2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode2();
            return;
        }
        this.templcode2DirtyFlag = false;
        this.templcode2 = null;
    }

    public void setTemplCode2Ex(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode2Ex(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode2ex = string;
        this.templcode2exDirtyFlag = true;
    }

    public String getTemplCode2Ex() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode2Ex();
        }
        return this.templcode2ex;
    }

    public boolean isTemplCode2ExDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode2ExDirty();
        }
        return this.templcode2exDirtyFlag;
    }

    public void resetTemplCode2Ex() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode2Ex();
            return;
        }
        this.templcode2exDirtyFlag = false;
        this.templcode2ex = null;
    }

    public void setTemplCodeEx(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCodeEx(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcodeex = string;
        this.templcodeexDirtyFlag = true;
    }

    public String getTemplCodeEx() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCodeEx();
        }
        return this.templcodeex;
    }

    public boolean isTemplCodeExDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeExDirty();
        }
        return this.templcodeexDirtyFlag;
    }

    public void resetTemplCodeEx() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCodeEx();
            return;
        }
        this.templcodeexDirtyFlag = false;
        this.templcodeex = null;
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
        PSDEActionTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEActionTemplBase pSDEActionTemplBase) {
        pSDEActionTemplBase.resetCodeName();
        pSDEActionTemplBase.resetCreateDate();
        pSDEActionTemplBase.resetCreateMan();
        pSDEActionTemplBase.resetLockFlag();
        pSDEActionTemplBase.resetMemo();
        pSDEActionTemplBase.resetPDTTempl();
        pSDEActionTemplBase.resetPSDCCodeSnippetId();
        pSDEActionTemplBase.resetPSDCCodeSnippetName();
        pSDEActionTemplBase.resetPSDEActionTemplId();
        pSDEActionTemplBase.resetPSDEActionTemplName();
        pSDEActionTemplBase.resetPSModuleId();
        pSDEActionTemplBase.resetPSModuleName();
        pSDEActionTemplBase.resetPSSystemId();
        pSDEActionTemplBase.resetPSSystemName();
        pSDEActionTemplBase.resetTemplCode();
        pSDEActionTemplBase.resetTemplCode2();
        pSDEActionTemplBase.resetTemplCode2Ex();
        pSDEActionTemplBase.resetTemplCodeEx();
        pSDEActionTemplBase.resetUpdateDate();
        pSDEActionTemplBase.resetUpdateMan();
        pSDEActionTemplBase.resetUserCat();
        pSDEActionTemplBase.resetUserTag();
        pSDEActionTemplBase.resetUserTag2();
        pSDEActionTemplBase.resetUserTag3();
        pSDEActionTemplBase.resetUserTag4();
        pSDEActionTemplBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPDTTemplDirty()) {
            hashMap.put(FIELD_PDTTEMPL, this.getPDTTempl());
        }
        if (!bl || this.isPSDCCodeSnippetIdDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETID, this.getPSDCCodeSnippetId());
        }
        if (!bl || this.isPSDCCodeSnippetNameDirty()) {
            hashMap.put(FIELD_PSDCCODESNIPPETNAME, this.getPSDCCodeSnippetName());
        }
        if (!bl || this.isPSDEActionTemplIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONTEMPLID, this.getPSDEActionTemplId());
        }
        if (!bl || this.isPSDEActionTemplNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONTEMPLNAME, this.getPSDEActionTemplName());
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
        if (!bl || this.isTemplCodeDirty()) {
            hashMap.put(FIELD_TEMPLCODE, this.getTemplCode());
        }
        if (!bl || this.isTemplCode2Dirty()) {
            hashMap.put(FIELD_TEMPLCODE2, this.getTemplCode2());
        }
        if (!bl || this.isTemplCode2ExDirty()) {
            hashMap.put(FIELD_TEMPLCODE2EX, this.getTemplCode2Ex());
        }
        if (!bl || this.isTemplCodeExDirty()) {
            hashMap.put(FIELD_TEMPLCODEEX, this.getTemplCodeEx());
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
        return PSDEActionTemplBase.get(this, n);
    }

    private static Object get(PSDEActionTemplBase pSDEActionTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionTemplBase.getCodeName();
            }
            case 1: {
                return pSDEActionTemplBase.getCreateDate();
            }
            case 2: {
                return pSDEActionTemplBase.getCreateMan();
            }
            case 3: {
                return pSDEActionTemplBase.getLockFlag();
            }
            case 4: {
                return pSDEActionTemplBase.getMemo();
            }
            case 5: {
                return pSDEActionTemplBase.getPDTTempl();
            }
            case 6: {
                return pSDEActionTemplBase.getPSDCCodeSnippetId();
            }
            case 7: {
                return pSDEActionTemplBase.getPSDCCodeSnippetName();
            }
            case 8: {
                return pSDEActionTemplBase.getPSDEActionTemplId();
            }
            case 9: {
                return pSDEActionTemplBase.getPSDEActionTemplName();
            }
            case 10: {
                return pSDEActionTemplBase.getPSModuleId();
            }
            case 11: {
                return pSDEActionTemplBase.getPSModuleName();
            }
            case 12: {
                return pSDEActionTemplBase.getPSSystemId();
            }
            case 13: {
                return pSDEActionTemplBase.getPSSystemName();
            }
            case 14: {
                return pSDEActionTemplBase.getTemplCode();
            }
            case 15: {
                return pSDEActionTemplBase.getTemplCode2();
            }
            case 16: {
                return pSDEActionTemplBase.getTemplCode2Ex();
            }
            case 17: {
                return pSDEActionTemplBase.getTemplCodeEx();
            }
            case 18: {
                return pSDEActionTemplBase.getUpdateDate();
            }
            case 19: {
                return pSDEActionTemplBase.getUpdateMan();
            }
            case 20: {
                return pSDEActionTemplBase.getUserCat();
            }
            case 21: {
                return pSDEActionTemplBase.getUserTag();
            }
            case 22: {
                return pSDEActionTemplBase.getUserTag2();
            }
            case 23: {
                return pSDEActionTemplBase.getUserTag3();
            }
            case 24: {
                return pSDEActionTemplBase.getUserTag4();
            }
            case 25: {
                return pSDEActionTemplBase.getValidFlag();
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
        PSDEActionTemplBase.set(this, n, object);
    }

    private static void set(PSDEActionTemplBase pSDEActionTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionTemplBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEActionTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEActionTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEActionTemplBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEActionTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEActionTemplBase.setPDTTempl(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEActionTemplBase.setPSDCCodeSnippetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEActionTemplBase.setPSDCCodeSnippetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEActionTemplBase.setPSDEActionTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEActionTemplBase.setPSDEActionTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEActionTemplBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEActionTemplBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEActionTemplBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEActionTemplBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEActionTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEActionTemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEActionTemplBase.setTemplCode2Ex(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEActionTemplBase.setTemplCodeEx(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEActionTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSDEActionTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEActionTemplBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEActionTemplBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEActionTemplBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEActionTemplBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEActionTemplBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEActionTemplBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEActionTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSDEActionTemplBase pSDEActionTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionTemplBase.getCodeName() == null;
            }
            case 1: {
                return pSDEActionTemplBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEActionTemplBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEActionTemplBase.getLockFlag() == null;
            }
            case 4: {
                return pSDEActionTemplBase.getMemo() == null;
            }
            case 5: {
                return pSDEActionTemplBase.getPDTTempl() == null;
            }
            case 6: {
                return pSDEActionTemplBase.getPSDCCodeSnippetId() == null;
            }
            case 7: {
                return pSDEActionTemplBase.getPSDCCodeSnippetName() == null;
            }
            case 8: {
                return pSDEActionTemplBase.getPSDEActionTemplId() == null;
            }
            case 9: {
                return pSDEActionTemplBase.getPSDEActionTemplName() == null;
            }
            case 10: {
                return pSDEActionTemplBase.getPSModuleId() == null;
            }
            case 11: {
                return pSDEActionTemplBase.getPSModuleName() == null;
            }
            case 12: {
                return pSDEActionTemplBase.getPSSystemId() == null;
            }
            case 13: {
                return pSDEActionTemplBase.getPSSystemName() == null;
            }
            case 14: {
                return pSDEActionTemplBase.getTemplCode() == null;
            }
            case 15: {
                return pSDEActionTemplBase.getTemplCode2() == null;
            }
            case 16: {
                return pSDEActionTemplBase.getTemplCode2Ex() == null;
            }
            case 17: {
                return pSDEActionTemplBase.getTemplCodeEx() == null;
            }
            case 18: {
                return pSDEActionTemplBase.getUpdateDate() == null;
            }
            case 19: {
                return pSDEActionTemplBase.getUpdateMan() == null;
            }
            case 20: {
                return pSDEActionTemplBase.getUserCat() == null;
            }
            case 21: {
                return pSDEActionTemplBase.getUserTag() == null;
            }
            case 22: {
                return pSDEActionTemplBase.getUserTag2() == null;
            }
            case 23: {
                return pSDEActionTemplBase.getUserTag3() == null;
            }
            case 24: {
                return pSDEActionTemplBase.getUserTag4() == null;
            }
            case 25: {
                return pSDEActionTemplBase.getValidFlag() == null;
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
        return PSDEActionTemplBase.contains(this, n);
    }

    private static boolean contains(PSDEActionTemplBase pSDEActionTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionTemplBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEActionTemplBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEActionTemplBase.isCreateManDirty();
            }
            case 3: {
                return pSDEActionTemplBase.isLockFlagDirty();
            }
            case 4: {
                return pSDEActionTemplBase.isMemoDirty();
            }
            case 5: {
                return pSDEActionTemplBase.isPDTTemplDirty();
            }
            case 6: {
                return pSDEActionTemplBase.isPSDCCodeSnippetIdDirty();
            }
            case 7: {
                return pSDEActionTemplBase.isPSDCCodeSnippetNameDirty();
            }
            case 8: {
                return pSDEActionTemplBase.isPSDEActionTemplIdDirty();
            }
            case 9: {
                return pSDEActionTemplBase.isPSDEActionTemplNameDirty();
            }
            case 10: {
                return pSDEActionTemplBase.isPSModuleIdDirty();
            }
            case 11: {
                return pSDEActionTemplBase.isPSModuleNameDirty();
            }
            case 12: {
                return pSDEActionTemplBase.isPSSystemIdDirty();
            }
            case 13: {
                return pSDEActionTemplBase.isPSSystemNameDirty();
            }
            case 14: {
                return pSDEActionTemplBase.isTemplCodeDirty();
            }
            case 15: {
                return pSDEActionTemplBase.isTemplCode2Dirty();
            }
            case 16: {
                return pSDEActionTemplBase.isTemplCode2ExDirty();
            }
            case 17: {
                return pSDEActionTemplBase.isTemplCodeExDirty();
            }
            case 18: {
                return pSDEActionTemplBase.isUpdateDateDirty();
            }
            case 19: {
                return pSDEActionTemplBase.isUpdateManDirty();
            }
            case 20: {
                return pSDEActionTemplBase.isUserCatDirty();
            }
            case 21: {
                return pSDEActionTemplBase.isUserTagDirty();
            }
            case 22: {
                return pSDEActionTemplBase.isUserTag2Dirty();
            }
            case 23: {
                return pSDEActionTemplBase.isUserTag3Dirty();
            }
            case 24: {
                return pSDEActionTemplBase.isUserTag4Dirty();
            }
            case 25: {
                return pSDEActionTemplBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEActionTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEActionTemplBase pSDEActionTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEActionTemplBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getPDTTempl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pdttempl", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getPDTTempl()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getPSDCCodeSnippetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetid", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getPSDCCodeSnippetId()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getPSDCCodeSnippetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccodesnippetname", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getPSDCCodeSnippetName()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getPSDEActionTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactiontemplid", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getPSDEActionTemplId()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getPSDEActionTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactiontemplname", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getPSDEActionTemplName()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getTemplCode2Ex() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2ex", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getTemplCode2Ex()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getTemplCodeEx() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcodeex", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getTemplCodeEx()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEActionTemplBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEActionTemplBase.getJSONValue((Object)pSDEActionTemplBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEActionTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEActionTemplBase pSDEActionTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEActionTemplBase.getCodeName() != null) {
            object = pSDEActionTemplBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getCreateDate() != null) {
            object = pSDEActionTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionTemplBase.getCreateMan() != null) {
            object = pSDEActionTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getLockFlag() != null) {
            object = pSDEActionTemplBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEActionTemplBase.getMemo() != null) {
            object = pSDEActionTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getPDTTempl() != null) {
            object = pSDEActionTemplBase.getPDTTempl();
            xmlNode.setAttribute(FIELD_PDTTEMPL, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getPSDCCodeSnippetId() != null) {
            object = pSDEActionTemplBase.getPSDCCodeSnippetId();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getPSDCCodeSnippetName() != null) {
            object = pSDEActionTemplBase.getPSDCCodeSnippetName();
            xmlNode.setAttribute(FIELD_PSDCCODESNIPPETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getPSDEActionTemplId() != null) {
            object = pSDEActionTemplBase.getPSDEActionTemplId();
            xmlNode.setAttribute(FIELD_PSDEACTIONTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getPSDEActionTemplName() != null) {
            object = pSDEActionTemplBase.getPSDEActionTemplName();
            xmlNode.setAttribute(FIELD_PSDEACTIONTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getPSModuleId() != null) {
            object = pSDEActionTemplBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getPSModuleName() != null) {
            object = pSDEActionTemplBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getPSSystemId() != null) {
            object = pSDEActionTemplBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getPSSystemName() != null) {
            object = pSDEActionTemplBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getTemplCode() != null) {
            object = pSDEActionTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getTemplCode2() != null) {
            object = pSDEActionTemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getTemplCode2Ex() != null) {
            object = pSDEActionTemplBase.getTemplCode2Ex();
            xmlNode.setAttribute(FIELD_TEMPLCODE2EX, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getTemplCodeEx() != null) {
            object = pSDEActionTemplBase.getTemplCodeEx();
            xmlNode.setAttribute(FIELD_TEMPLCODEEX, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getUpdateDate() != null) {
            object = pSDEActionTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionTemplBase.getUpdateMan() != null) {
            object = pSDEActionTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getUserCat() != null) {
            object = pSDEActionTemplBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getUserTag() != null) {
            object = pSDEActionTemplBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getUserTag2() != null) {
            object = pSDEActionTemplBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getUserTag3() != null) {
            object = pSDEActionTemplBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getUserTag4() != null) {
            object = pSDEActionTemplBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTemplBase.getValidFlag() != null) {
            object = pSDEActionTemplBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEActionTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEActionTemplBase pSDEActionTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEActionTemplBase.isCodeNameDirty() && (bl || pSDEActionTemplBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEActionTemplBase.getCodeName());
        }
        if (pSDEActionTemplBase.isCreateDateDirty() && (bl || pSDEActionTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEActionTemplBase.getCreateDate());
        }
        if (pSDEActionTemplBase.isCreateManDirty() && (bl || pSDEActionTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEActionTemplBase.getCreateMan());
        }
        if (pSDEActionTemplBase.isLockFlagDirty() && (bl || pSDEActionTemplBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEActionTemplBase.getLockFlag());
        }
        if (pSDEActionTemplBase.isMemoDirty() && (bl || pSDEActionTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEActionTemplBase.getMemo());
        }
        if (pSDEActionTemplBase.isPDTTemplDirty() && (bl || pSDEActionTemplBase.getPDTTempl() != null)) {
            iDataObject.set(FIELD_PDTTEMPL, (Object)pSDEActionTemplBase.getPDTTempl());
        }
        if (pSDEActionTemplBase.isPSDCCodeSnippetIdDirty() && (bl || pSDEActionTemplBase.getPSDCCodeSnippetId() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETID, (Object)pSDEActionTemplBase.getPSDCCodeSnippetId());
        }
        if (pSDEActionTemplBase.isPSDCCodeSnippetNameDirty() && (bl || pSDEActionTemplBase.getPSDCCodeSnippetName() != null)) {
            iDataObject.set(FIELD_PSDCCODESNIPPETNAME, (Object)pSDEActionTemplBase.getPSDCCodeSnippetName());
        }
        if (pSDEActionTemplBase.isPSDEActionTemplIdDirty() && (bl || pSDEActionTemplBase.getPSDEActionTemplId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONTEMPLID, (Object)pSDEActionTemplBase.getPSDEActionTemplId());
        }
        if (pSDEActionTemplBase.isPSDEActionTemplNameDirty() && (bl || pSDEActionTemplBase.getPSDEActionTemplName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONTEMPLNAME, (Object)pSDEActionTemplBase.getPSDEActionTemplName());
        }
        if (pSDEActionTemplBase.isPSModuleIdDirty() && (bl || pSDEActionTemplBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSDEActionTemplBase.getPSModuleId());
        }
        if (pSDEActionTemplBase.isPSModuleNameDirty() && (bl || pSDEActionTemplBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSDEActionTemplBase.getPSModuleName());
        }
        if (pSDEActionTemplBase.isPSSystemIdDirty() && (bl || pSDEActionTemplBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEActionTemplBase.getPSSystemId());
        }
        if (pSDEActionTemplBase.isPSSystemNameDirty() && (bl || pSDEActionTemplBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDEActionTemplBase.getPSSystemName());
        }
        if (pSDEActionTemplBase.isTemplCodeDirty() && (bl || pSDEActionTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSDEActionTemplBase.getTemplCode());
        }
        if (pSDEActionTemplBase.isTemplCode2Dirty() && (bl || pSDEActionTemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSDEActionTemplBase.getTemplCode2());
        }
        if (pSDEActionTemplBase.isTemplCode2ExDirty() && (bl || pSDEActionTemplBase.getTemplCode2Ex() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2EX, (Object)pSDEActionTemplBase.getTemplCode2Ex());
        }
        if (pSDEActionTemplBase.isTemplCodeExDirty() && (bl || pSDEActionTemplBase.getTemplCodeEx() != null)) {
            iDataObject.set(FIELD_TEMPLCODEEX, (Object)pSDEActionTemplBase.getTemplCodeEx());
        }
        if (pSDEActionTemplBase.isUpdateDateDirty() && (bl || pSDEActionTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEActionTemplBase.getUpdateDate());
        }
        if (pSDEActionTemplBase.isUpdateManDirty() && (bl || pSDEActionTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEActionTemplBase.getUpdateMan());
        }
        if (pSDEActionTemplBase.isUserCatDirty() && (bl || pSDEActionTemplBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEActionTemplBase.getUserCat());
        }
        if (pSDEActionTemplBase.isUserTagDirty() && (bl || pSDEActionTemplBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEActionTemplBase.getUserTag());
        }
        if (pSDEActionTemplBase.isUserTag2Dirty() && (bl || pSDEActionTemplBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEActionTemplBase.getUserTag2());
        }
        if (pSDEActionTemplBase.isUserTag3Dirty() && (bl || pSDEActionTemplBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEActionTemplBase.getUserTag3());
        }
        if (pSDEActionTemplBase.isUserTag4Dirty() && (bl || pSDEActionTemplBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEActionTemplBase.getUserTag4());
        }
        if (pSDEActionTemplBase.isValidFlagDirty() && (bl || pSDEActionTemplBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEActionTemplBase.getValidFlag());
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
        return PSDEActionTemplBase.remove(this, n);
    }

    private static boolean remove(PSDEActionTemplBase pSDEActionTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionTemplBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEActionTemplBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEActionTemplBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEActionTemplBase.resetLockFlag();
                return true;
            }
            case 4: {
                pSDEActionTemplBase.resetMemo();
                return true;
            }
            case 5: {
                pSDEActionTemplBase.resetPDTTempl();
                return true;
            }
            case 6: {
                pSDEActionTemplBase.resetPSDCCodeSnippetId();
                return true;
            }
            case 7: {
                pSDEActionTemplBase.resetPSDCCodeSnippetName();
                return true;
            }
            case 8: {
                pSDEActionTemplBase.resetPSDEActionTemplId();
                return true;
            }
            case 9: {
                pSDEActionTemplBase.resetPSDEActionTemplName();
                return true;
            }
            case 10: {
                pSDEActionTemplBase.resetPSModuleId();
                return true;
            }
            case 11: {
                pSDEActionTemplBase.resetPSModuleName();
                return true;
            }
            case 12: {
                pSDEActionTemplBase.resetPSSystemId();
                return true;
            }
            case 13: {
                pSDEActionTemplBase.resetPSSystemName();
                return true;
            }
            case 14: {
                pSDEActionTemplBase.resetTemplCode();
                return true;
            }
            case 15: {
                pSDEActionTemplBase.resetTemplCode2();
                return true;
            }
            case 16: {
                pSDEActionTemplBase.resetTemplCode2Ex();
                return true;
            }
            case 17: {
                pSDEActionTemplBase.resetTemplCodeEx();
                return true;
            }
            case 18: {
                pSDEActionTemplBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSDEActionTemplBase.resetUpdateMan();
                return true;
            }
            case 20: {
                pSDEActionTemplBase.resetUserCat();
                return true;
            }
            case 21: {
                pSDEActionTemplBase.resetUserTag();
                return true;
            }
            case 22: {
                pSDEActionTemplBase.resetUserTag2();
                return true;
            }
            case 23: {
                pSDEActionTemplBase.resetUserTag3();
                return true;
            }
            case 24: {
                pSDEActionTemplBase.resetUserTag4();
                return true;
            }
            case 25: {
                pSDEActionTemplBase.resetValidFlag();
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

    private PSDEActionTemplBase getProxyEntity() {
        return this.proxyPSDEActionTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEActionTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEActionTemplBase) {
            this.proxyPSDEActionTemplBase = (PSDEActionTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOCKFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PDTTEMPL, 5);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETID, 6);
        fieldIndexMap.put(FIELD_PSDCCODESNIPPETNAME, 7);
        fieldIndexMap.put(FIELD_PSDEACTIONTEMPLID, 8);
        fieldIndexMap.put(FIELD_PSDEACTIONTEMPLNAME, 9);
        fieldIndexMap.put(FIELD_PSMODULEID, 10);
        fieldIndexMap.put(FIELD_PSMODULENAME, 11);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 12);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 13);
        fieldIndexMap.put(FIELD_TEMPLCODE, 14);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 15);
        fieldIndexMap.put(FIELD_TEMPLCODE2EX, 16);
        fieldIndexMap.put(FIELD_TEMPLCODEEX, 17);
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

