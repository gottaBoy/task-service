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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTipSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFInputTipBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFInputTipBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CONTENTPSLANRESID = "CONTENTPSLANRESID";
    public static final String FIELD_CONTENTPSLANRESNAME = "CONTENTPSLANRESNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_ENABLECLOSE = "ENABLECLOSE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOREURL = "MOREURL";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFINPUTTIPID = "PSDEFINPUTTIPID";
    public static final String FIELD_PSDEFINPUTTIPNAME = "PSDEFINPUTTIPNAME";
    public static final String FIELD_PSDEFINPUTTIPSETID = "PSDEFINPUTTIPSETID";
    public static final String FIELD_PSDEFINPUTTIPSETNAME = "PSDEFINPUTTIPSETNAME";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_RAWCONTENT = "RAWCONTENT";
    public static final String FIELD_TIPMODE = "TIPMODE";
    public static final String FIELD_UNIQUETAG = "UNIQUETAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CONTENT = 1;
    private static final int INDEX_CONTENTPSLANRESID = 2;
    private static final int INDEX_CONTENTPSLANRESNAME = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_DEFAULTFLAG = 6;
    private static final int INDEX_ENABLECLOSE = 7;
    private static final int INDEX_LOCKFLAG = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_MOREURL = 10;
    private static final int INDEX_PSDEFID = 11;
    private static final int INDEX_PSDEFINPUTTIPID = 12;
    private static final int INDEX_PSDEFINPUTTIPNAME = 13;
    private static final int INDEX_PSDEFINPUTTIPSETID = 14;
    private static final int INDEX_PSDEFINPUTTIPSETNAME = 15;
    private static final int INDEX_PSDEFNAME = 16;
    private static final int INDEX_PSDEID = 17;
    private static final int INDEX_PSDENAME = 18;
    private static final int INDEX_PSMODULEID = 19;
    private static final int INDEX_PSMODULENAME = 20;
    private static final int INDEX_PSSYSTEMID = 21;
    private static final int INDEX_PSSYSTEMNAME = 22;
    private static final int INDEX_RAWCONTENT = 23;
    private static final int INDEX_TIPMODE = 24;
    private static final int INDEX_UNIQUETAG = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USERCAT = 28;
    private static final int INDEX_USERTAG = 29;
    private static final int INDEX_USERTAG2 = 30;
    private static final int INDEX_USERTAG3 = 31;
    private static final int INDEX_USERTAG4 = 32;
    private static final int INDEX_VALIDFLAG = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFInputTipBase proxyPSDEFInputTipBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean contentpslanresidDirtyFlag = false;
    private boolean contentpslanresnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean enablecloseDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean moreurlDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefinputtipidDirtyFlag = false;
    private boolean psdefinputtipnameDirtyFlag = false;
    private boolean psdefinputtipsetidDirtyFlag = false;
    private boolean psdefinputtipsetnameDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean rawcontentDirtyFlag = false;
    private boolean tipmodeDirtyFlag = false;
    private boolean uniquetagDirtyFlag = false;
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
    @Column(name="content")
    private String content;
    @Column(name="contentpslanresid")
    private String contentpslanresid;
    @Column(name="contentpslanresname")
    private String contentpslanresname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="enableclose")
    private Integer enableclose;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="moreurl")
    private String moreurl;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefinputtipid")
    private String psdefinputtipid;
    @Column(name="psdefinputtipname")
    private String psdefinputtipname;
    @Column(name="psdefinputtipsetid")
    private String psdefinputtipsetid;
    @Column(name="psdefinputtipsetname")
    private String psdefinputtipsetname;
    @Column(name="psdefname")
    private String psdefname;
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
    @Column(name="rawcontent")
    private String rawcontent;
    @Column(name="tipmode")
    private String tipmode;
    @Column(name="uniquetag")
    private String uniquetag;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSDEFInputTipSetLock = new Integer(1);
    private PSDEFInputTipSet psdefinputtipset = null;
    private Integer objContentPSLanResLock = new Integer(1);
    private PSLanguageRes contentpslanres = null;
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

    public void setContentPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpslanresid = string;
        this.contentpslanresidDirtyFlag = true;
    }

    public String getContentPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSLanResId();
        }
        return this.contentpslanresid;
    }

    public boolean isContentPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSLanResIdDirty();
        }
        return this.contentpslanresidDirtyFlag;
    }

    public void resetContentPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSLanResId();
            return;
        }
        this.contentpslanresidDirtyFlag = false;
        this.contentpslanresid = null;
    }

    public void setContentPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contentpslanresname = string;
        this.contentpslanresnameDirtyFlag = true;
    }

    public String getContentPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSLanResName();
        }
        return this.contentpslanresname;
    }

    public boolean isContentPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentPSLanResNameDirty();
        }
        return this.contentpslanresnameDirtyFlag;
    }

    public void resetContentPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentPSLanResName();
            return;
        }
        this.contentpslanresnameDirtyFlag = false;
        this.contentpslanresname = null;
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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setEnableClose(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableClose(n);
            return;
        }
        this.enableclose = n;
        this.enablecloseDirtyFlag = true;
    }

    public Integer getEnableClose() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableClose();
        }
        return this.enableclose;
    }

    public boolean isEnableCloseDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCloseDirty();
        }
        return this.enablecloseDirtyFlag;
    }

    public void resetEnableClose() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableClose();
            return;
        }
        this.enablecloseDirtyFlag = false;
        this.enableclose = null;
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

    public void setMoreUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMoreUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.moreurl = string;
        this.moreurlDirtyFlag = true;
    }

    public String getMoreUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMoreUrl();
        }
        return this.moreurl;
    }

    public boolean isMoreUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMoreUrlDirty();
        }
        return this.moreurlDirtyFlag;
    }

    public void resetMoreUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMoreUrl();
            return;
        }
        this.moreurlDirtyFlag = false;
        this.moreurl = null;
    }

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFInputTipId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFInputTipId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefinputtipid = string;
        this.psdefinputtipidDirtyFlag = true;
    }

    public String getPSDEFInputTipId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipId();
        }
        return this.psdefinputtipid;
    }

    public boolean isPSDEFInputTipIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFInputTipIdDirty();
        }
        return this.psdefinputtipidDirtyFlag;
    }

    public void resetPSDEFInputTipId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFInputTipId();
            return;
        }
        this.psdefinputtipidDirtyFlag = false;
        this.psdefinputtipid = null;
    }

    public void setPSDEFInputTipName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFInputTipName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefinputtipname = string;
        this.psdefinputtipnameDirtyFlag = true;
    }

    public String getPSDEFInputTipName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipName();
        }
        return this.psdefinputtipname;
    }

    public boolean isPSDEFInputTipNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFInputTipNameDirty();
        }
        return this.psdefinputtipnameDirtyFlag;
    }

    public void resetPSDEFInputTipName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFInputTipName();
            return;
        }
        this.psdefinputtipnameDirtyFlag = false;
        this.psdefinputtipname = null;
    }

    public void setPSDEFInputTipSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFInputTipSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefinputtipsetid = string;
        this.psdefinputtipsetidDirtyFlag = true;
    }

    public String getPSDEFInputTipSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipSetId();
        }
        return this.psdefinputtipsetid;
    }

    public boolean isPSDEFInputTipSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFInputTipSetIdDirty();
        }
        return this.psdefinputtipsetidDirtyFlag;
    }

    public void resetPSDEFInputTipSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFInputTipSetId();
            return;
        }
        this.psdefinputtipsetidDirtyFlag = false;
        this.psdefinputtipsetid = null;
    }

    public void setPSDEFInputTipSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFInputTipSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefinputtipsetname = string;
        this.psdefinputtipsetnameDirtyFlag = true;
    }

    public String getPSDEFInputTipSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipSetName();
        }
        return this.psdefinputtipsetname;
    }

    public boolean isPSDEFInputTipSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFInputTipSetNameDirty();
        }
        return this.psdefinputtipsetnameDirtyFlag;
    }

    public void resetPSDEFInputTipSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFInputTipSetName();
            return;
        }
        this.psdefinputtipsetnameDirtyFlag = false;
        this.psdefinputtipsetname = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
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

    public void setRawContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rawcontent = string;
        this.rawcontentDirtyFlag = true;
    }

    public String getRawContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawContent();
        }
        return this.rawcontent;
    }

    public boolean isRawContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawContentDirty();
        }
        return this.rawcontentDirtyFlag;
    }

    public void resetRawContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawContent();
            return;
        }
        this.rawcontentDirtyFlag = false;
        this.rawcontent = null;
    }

    public void setTipMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tipmode = string;
        this.tipmodeDirtyFlag = true;
    }

    public String getTipMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipMode();
        }
        return this.tipmode;
    }

    public boolean isTipModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipModeDirty();
        }
        return this.tipmodeDirtyFlag;
    }

    public void resetTipMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipMode();
            return;
        }
        this.tipmodeDirtyFlag = false;
        this.tipmode = null;
    }

    public void setUniqueTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniqueTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uniquetag = string;
        this.uniquetagDirtyFlag = true;
    }

    public String getUniqueTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniqueTag();
        }
        return this.uniquetag;
    }

    public boolean isUniqueTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniqueTagDirty();
        }
        return this.uniquetagDirtyFlag;
    }

    public void resetUniqueTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniqueTag();
            return;
        }
        this.uniquetagDirtyFlag = false;
        this.uniquetag = null;
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
        PSDEFInputTipBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFInputTipBase pSDEFInputTipBase) {
        pSDEFInputTipBase.resetCodeName();
        pSDEFInputTipBase.resetContent();
        pSDEFInputTipBase.resetContentPSLanResId();
        pSDEFInputTipBase.resetContentPSLanResName();
        pSDEFInputTipBase.resetCreateDate();
        pSDEFInputTipBase.resetCreateMan();
        pSDEFInputTipBase.resetDefaultFlag();
        pSDEFInputTipBase.resetEnableClose();
        pSDEFInputTipBase.resetLockFlag();
        pSDEFInputTipBase.resetMemo();
        pSDEFInputTipBase.resetMoreUrl();
        pSDEFInputTipBase.resetPSDEFId();
        pSDEFInputTipBase.resetPSDEFInputTipId();
        pSDEFInputTipBase.resetPSDEFInputTipName();
        pSDEFInputTipBase.resetPSDEFInputTipSetId();
        pSDEFInputTipBase.resetPSDEFInputTipSetName();
        pSDEFInputTipBase.resetPSDEFName();
        pSDEFInputTipBase.resetPSDEId();
        pSDEFInputTipBase.resetPSDEName();
        pSDEFInputTipBase.resetPSModuleId();
        pSDEFInputTipBase.resetPSModuleName();
        pSDEFInputTipBase.resetPSSystemId();
        pSDEFInputTipBase.resetPSSystemName();
        pSDEFInputTipBase.resetRawContent();
        pSDEFInputTipBase.resetTipMode();
        pSDEFInputTipBase.resetUniqueTag();
        pSDEFInputTipBase.resetUpdateDate();
        pSDEFInputTipBase.resetUpdateMan();
        pSDEFInputTipBase.resetUserCat();
        pSDEFInputTipBase.resetUserTag();
        pSDEFInputTipBase.resetUserTag2();
        pSDEFInputTipBase.resetUserTag3();
        pSDEFInputTipBase.resetUserTag4();
        pSDEFInputTipBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isContentPSLanResIdDirty()) {
            hashMap.put(FIELD_CONTENTPSLANRESID, this.getContentPSLanResId());
        }
        if (!bl || this.isContentPSLanResNameDirty()) {
            hashMap.put(FIELD_CONTENTPSLANRESNAME, this.getContentPSLanResName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isEnableCloseDirty()) {
            hashMap.put(FIELD_ENABLECLOSE, this.getEnableClose());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMoreUrlDirty()) {
            hashMap.put(FIELD_MOREURL, this.getMoreUrl());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFInputTipIdDirty()) {
            hashMap.put(FIELD_PSDEFINPUTTIPID, this.getPSDEFInputTipId());
        }
        if (!bl || this.isPSDEFInputTipNameDirty()) {
            hashMap.put(FIELD_PSDEFINPUTTIPNAME, this.getPSDEFInputTipName());
        }
        if (!bl || this.isPSDEFInputTipSetIdDirty()) {
            hashMap.put(FIELD_PSDEFINPUTTIPSETID, this.getPSDEFInputTipSetId());
        }
        if (!bl || this.isPSDEFInputTipSetNameDirty()) {
            hashMap.put(FIELD_PSDEFINPUTTIPSETNAME, this.getPSDEFInputTipSetName());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
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
        if (!bl || this.isRawContentDirty()) {
            hashMap.put(FIELD_RAWCONTENT, this.getRawContent());
        }
        if (!bl || this.isTipModeDirty()) {
            hashMap.put(FIELD_TIPMODE, this.getTipMode());
        }
        if (!bl || this.isUniqueTagDirty()) {
            hashMap.put(FIELD_UNIQUETAG, this.getUniqueTag());
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
        return PSDEFInputTipBase.get(this, n);
    }

    private static Object get(PSDEFInputTipBase pSDEFInputTipBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFInputTipBase.getCodeName();
            }
            case 1: {
                return pSDEFInputTipBase.getContent();
            }
            case 2: {
                return pSDEFInputTipBase.getContentPSLanResId();
            }
            case 3: {
                return pSDEFInputTipBase.getContentPSLanResName();
            }
            case 4: {
                return pSDEFInputTipBase.getCreateDate();
            }
            case 5: {
                return pSDEFInputTipBase.getCreateMan();
            }
            case 6: {
                return pSDEFInputTipBase.getDefaultFlag();
            }
            case 7: {
                return pSDEFInputTipBase.getEnableClose();
            }
            case 8: {
                return pSDEFInputTipBase.getLockFlag();
            }
            case 9: {
                return pSDEFInputTipBase.getMemo();
            }
            case 10: {
                return pSDEFInputTipBase.getMoreUrl();
            }
            case 11: {
                return pSDEFInputTipBase.getPSDEFId();
            }
            case 12: {
                return pSDEFInputTipBase.getPSDEFInputTipId();
            }
            case 13: {
                return pSDEFInputTipBase.getPSDEFInputTipName();
            }
            case 14: {
                return pSDEFInputTipBase.getPSDEFInputTipSetId();
            }
            case 15: {
                return pSDEFInputTipBase.getPSDEFInputTipSetName();
            }
            case 16: {
                return pSDEFInputTipBase.getPSDEFName();
            }
            case 17: {
                return pSDEFInputTipBase.getPSDEId();
            }
            case 18: {
                return pSDEFInputTipBase.getPSDEName();
            }
            case 19: {
                return pSDEFInputTipBase.getPSModuleId();
            }
            case 20: {
                return pSDEFInputTipBase.getPSModuleName();
            }
            case 21: {
                return pSDEFInputTipBase.getPSSystemId();
            }
            case 22: {
                return pSDEFInputTipBase.getPSSystemName();
            }
            case 23: {
                return pSDEFInputTipBase.getRawContent();
            }
            case 24: {
                return pSDEFInputTipBase.getTipMode();
            }
            case 25: {
                return pSDEFInputTipBase.getUniqueTag();
            }
            case 26: {
                return pSDEFInputTipBase.getUpdateDate();
            }
            case 27: {
                return pSDEFInputTipBase.getUpdateMan();
            }
            case 28: {
                return pSDEFInputTipBase.getUserCat();
            }
            case 29: {
                return pSDEFInputTipBase.getUserTag();
            }
            case 30: {
                return pSDEFInputTipBase.getUserTag2();
            }
            case 31: {
                return pSDEFInputTipBase.getUserTag3();
            }
            case 32: {
                return pSDEFInputTipBase.getUserTag4();
            }
            case 33: {
                return pSDEFInputTipBase.getValidFlag();
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
        PSDEFInputTipBase.set(this, n, object);
    }

    private static void set(PSDEFInputTipBase pSDEFInputTipBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFInputTipBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEFInputTipBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFInputTipBase.setContentPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFInputTipBase.setContentPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFInputTipBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDEFInputTipBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFInputTipBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEFInputTipBase.setEnableClose(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEFInputTipBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEFInputTipBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFInputTipBase.setMoreUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFInputTipBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEFInputTipBase.setPSDEFInputTipId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEFInputTipBase.setPSDEFInputTipName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFInputTipBase.setPSDEFInputTipSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEFInputTipBase.setPSDEFInputTipSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEFInputTipBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEFInputTipBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEFInputTipBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEFInputTipBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEFInputTipBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEFInputTipBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEFInputTipBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEFInputTipBase.setRawContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEFInputTipBase.setTipMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEFInputTipBase.setUniqueTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEFInputTipBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSDEFInputTipBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEFInputTipBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEFInputTipBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEFInputTipBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEFInputTipBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEFInputTipBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEFInputTipBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEFInputTipBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFInputTipBase pSDEFInputTipBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFInputTipBase.getCodeName() == null;
            }
            case 1: {
                return pSDEFInputTipBase.getContent() == null;
            }
            case 2: {
                return pSDEFInputTipBase.getContentPSLanResId() == null;
            }
            case 3: {
                return pSDEFInputTipBase.getContentPSLanResName() == null;
            }
            case 4: {
                return pSDEFInputTipBase.getCreateDate() == null;
            }
            case 5: {
                return pSDEFInputTipBase.getCreateMan() == null;
            }
            case 6: {
                return pSDEFInputTipBase.getDefaultFlag() == null;
            }
            case 7: {
                return pSDEFInputTipBase.getEnableClose() == null;
            }
            case 8: {
                return pSDEFInputTipBase.getLockFlag() == null;
            }
            case 9: {
                return pSDEFInputTipBase.getMemo() == null;
            }
            case 10: {
                return pSDEFInputTipBase.getMoreUrl() == null;
            }
            case 11: {
                return pSDEFInputTipBase.getPSDEFId() == null;
            }
            case 12: {
                return pSDEFInputTipBase.getPSDEFInputTipId() == null;
            }
            case 13: {
                return pSDEFInputTipBase.getPSDEFInputTipName() == null;
            }
            case 14: {
                return pSDEFInputTipBase.getPSDEFInputTipSetId() == null;
            }
            case 15: {
                return pSDEFInputTipBase.getPSDEFInputTipSetName() == null;
            }
            case 16: {
                return pSDEFInputTipBase.getPSDEFName() == null;
            }
            case 17: {
                return pSDEFInputTipBase.getPSDEId() == null;
            }
            case 18: {
                return pSDEFInputTipBase.getPSDEName() == null;
            }
            case 19: {
                return pSDEFInputTipBase.getPSModuleId() == null;
            }
            case 20: {
                return pSDEFInputTipBase.getPSModuleName() == null;
            }
            case 21: {
                return pSDEFInputTipBase.getPSSystemId() == null;
            }
            case 22: {
                return pSDEFInputTipBase.getPSSystemName() == null;
            }
            case 23: {
                return pSDEFInputTipBase.getRawContent() == null;
            }
            case 24: {
                return pSDEFInputTipBase.getTipMode() == null;
            }
            case 25: {
                return pSDEFInputTipBase.getUniqueTag() == null;
            }
            case 26: {
                return pSDEFInputTipBase.getUpdateDate() == null;
            }
            case 27: {
                return pSDEFInputTipBase.getUpdateMan() == null;
            }
            case 28: {
                return pSDEFInputTipBase.getUserCat() == null;
            }
            case 29: {
                return pSDEFInputTipBase.getUserTag() == null;
            }
            case 30: {
                return pSDEFInputTipBase.getUserTag2() == null;
            }
            case 31: {
                return pSDEFInputTipBase.getUserTag3() == null;
            }
            case 32: {
                return pSDEFInputTipBase.getUserTag4() == null;
            }
            case 33: {
                return pSDEFInputTipBase.getValidFlag() == null;
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
        return PSDEFInputTipBase.contains(this, n);
    }

    private static boolean contains(PSDEFInputTipBase pSDEFInputTipBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFInputTipBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEFInputTipBase.isContentDirty();
            }
            case 2: {
                return pSDEFInputTipBase.isContentPSLanResIdDirty();
            }
            case 3: {
                return pSDEFInputTipBase.isContentPSLanResNameDirty();
            }
            case 4: {
                return pSDEFInputTipBase.isCreateDateDirty();
            }
            case 5: {
                return pSDEFInputTipBase.isCreateManDirty();
            }
            case 6: {
                return pSDEFInputTipBase.isDefaultFlagDirty();
            }
            case 7: {
                return pSDEFInputTipBase.isEnableCloseDirty();
            }
            case 8: {
                return pSDEFInputTipBase.isLockFlagDirty();
            }
            case 9: {
                return pSDEFInputTipBase.isMemoDirty();
            }
            case 10: {
                return pSDEFInputTipBase.isMoreUrlDirty();
            }
            case 11: {
                return pSDEFInputTipBase.isPSDEFIdDirty();
            }
            case 12: {
                return pSDEFInputTipBase.isPSDEFInputTipIdDirty();
            }
            case 13: {
                return pSDEFInputTipBase.isPSDEFInputTipNameDirty();
            }
            case 14: {
                return pSDEFInputTipBase.isPSDEFInputTipSetIdDirty();
            }
            case 15: {
                return pSDEFInputTipBase.isPSDEFInputTipSetNameDirty();
            }
            case 16: {
                return pSDEFInputTipBase.isPSDEFNameDirty();
            }
            case 17: {
                return pSDEFInputTipBase.isPSDEIdDirty();
            }
            case 18: {
                return pSDEFInputTipBase.isPSDENameDirty();
            }
            case 19: {
                return pSDEFInputTipBase.isPSModuleIdDirty();
            }
            case 20: {
                return pSDEFInputTipBase.isPSModuleNameDirty();
            }
            case 21: {
                return pSDEFInputTipBase.isPSSystemIdDirty();
            }
            case 22: {
                return pSDEFInputTipBase.isPSSystemNameDirty();
            }
            case 23: {
                return pSDEFInputTipBase.isRawContentDirty();
            }
            case 24: {
                return pSDEFInputTipBase.isTipModeDirty();
            }
            case 25: {
                return pSDEFInputTipBase.isUniqueTagDirty();
            }
            case 26: {
                return pSDEFInputTipBase.isUpdateDateDirty();
            }
            case 27: {
                return pSDEFInputTipBase.isUpdateManDirty();
            }
            case 28: {
                return pSDEFInputTipBase.isUserCatDirty();
            }
            case 29: {
                return pSDEFInputTipBase.isUserTagDirty();
            }
            case 30: {
                return pSDEFInputTipBase.isUserTag2Dirty();
            }
            case 31: {
                return pSDEFInputTipBase.isUserTag3Dirty();
            }
            case 32: {
                return pSDEFInputTipBase.isUserTag4Dirty();
            }
            case 33: {
                return pSDEFInputTipBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFInputTipBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFInputTipBase pSDEFInputTipBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFInputTipBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getContent()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getContentPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpslanresid", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getContentPSLanResId()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getContentPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpslanresname", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getContentPSLanResName()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getEnableClose() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableclose", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getEnableClose()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getMoreUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"moreurl", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getMoreUrl()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getPSDEFInputTipId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefinputtipid", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getPSDEFInputTipId()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getPSDEFInputTipName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefinputtipname", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getPSDEFInputTipName()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getPSDEFInputTipSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefinputtipsetid", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getPSDEFInputTipSetId()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getPSDEFInputTipSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefinputtipsetname", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getPSDEFInputTipSetName()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getRawContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcontent", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getRawContent()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getTipMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tipmode", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getTipMode()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getUniqueTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uniquetag", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getUniqueTag()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEFInputTipBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEFInputTipBase.getJSONValue((Object)pSDEFInputTipBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFInputTipBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFInputTipBase pSDEFInputTipBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFInputTipBase.getCodeName() != null) {
            object = pSDEFInputTipBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEFInputTipBase.getContent() != null) {
            object = pSDEFInputTipBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, (String)(object == null ? "" : object));
        }
        if (bl || pSDEFInputTipBase.getContentPSLanResId() != null) {
            object = pSDEFInputTipBase.getContentPSLanResId();
            xmlNode.setAttribute(FIELD_CONTENTPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEFInputTipBase.getContentPSLanResName() != null) {
            object = pSDEFInputTipBase.getContentPSLanResName();
            xmlNode.setAttribute(FIELD_CONTENTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getCreateDate() != null) {
            object = pSDEFInputTipBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFInputTipBase.getCreateMan() != null) {
            object = pSDEFInputTipBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getDefaultFlag() != null) {
            object = pSDEFInputTipBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFInputTipBase.getEnableClose() != null) {
            object = pSDEFInputTipBase.getEnableClose();
            xmlNode.setAttribute(FIELD_ENABLECLOSE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFInputTipBase.getLockFlag() != null) {
            object = pSDEFInputTipBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFInputTipBase.getMemo() != null) {
            object = pSDEFInputTipBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getMoreUrl() != null) {
            object = pSDEFInputTipBase.getMoreUrl();
            xmlNode.setAttribute(FIELD_MOREURL, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getPSDEFId() != null) {
            object = pSDEFInputTipBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getPSDEFInputTipId() != null) {
            object = pSDEFInputTipBase.getPSDEFInputTipId();
            xmlNode.setAttribute(FIELD_PSDEFINPUTTIPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getPSDEFInputTipName() != null) {
            object = pSDEFInputTipBase.getPSDEFInputTipName();
            xmlNode.setAttribute(FIELD_PSDEFINPUTTIPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getPSDEFInputTipSetId() != null) {
            object = pSDEFInputTipBase.getPSDEFInputTipSetId();
            xmlNode.setAttribute(FIELD_PSDEFINPUTTIPSETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getPSDEFInputTipSetName() != null) {
            object = pSDEFInputTipBase.getPSDEFInputTipSetName();
            xmlNode.setAttribute(FIELD_PSDEFINPUTTIPSETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getPSDEFName() != null) {
            object = pSDEFInputTipBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getPSDEId() != null) {
            object = pSDEFInputTipBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getPSDEName() != null) {
            object = pSDEFInputTipBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getPSModuleId() != null) {
            object = pSDEFInputTipBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getPSModuleName() != null) {
            object = pSDEFInputTipBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getPSSystemId() != null) {
            object = pSDEFInputTipBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getPSSystemName() != null) {
            object = pSDEFInputTipBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getRawContent() != null) {
            object = pSDEFInputTipBase.getRawContent();
            xmlNode.setAttribute(FIELD_RAWCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getTipMode() != null) {
            object = pSDEFInputTipBase.getTipMode();
            xmlNode.setAttribute(FIELD_TIPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getUniqueTag() != null) {
            object = pSDEFInputTipBase.getUniqueTag();
            xmlNode.setAttribute(FIELD_UNIQUETAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getUpdateDate() != null) {
            object = pSDEFInputTipBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFInputTipBase.getUpdateMan() != null) {
            object = pSDEFInputTipBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getUserCat() != null) {
            object = pSDEFInputTipBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getUserTag() != null) {
            object = pSDEFInputTipBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getUserTag2() != null) {
            object = pSDEFInputTipBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getUserTag3() != null) {
            object = pSDEFInputTipBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getUserTag4() != null) {
            object = pSDEFInputTipBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEFInputTipBase.getValidFlag() != null) {
            object = pSDEFInputTipBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFInputTipBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFInputTipBase pSDEFInputTipBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFInputTipBase.isCodeNameDirty() && (bl || pSDEFInputTipBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEFInputTipBase.getCodeName());
        }
        if (pSDEFInputTipBase.isContentDirty() && (bl || pSDEFInputTipBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSDEFInputTipBase.getContent());
        }
        if (pSDEFInputTipBase.isContentPSLanResIdDirty() && (bl || pSDEFInputTipBase.getContentPSLanResId() != null)) {
            iDataObject.set(FIELD_CONTENTPSLANRESID, (Object)pSDEFInputTipBase.getContentPSLanResId());
        }
        if (pSDEFInputTipBase.isContentPSLanResNameDirty() && (bl || pSDEFInputTipBase.getContentPSLanResName() != null)) {
            iDataObject.set(FIELD_CONTENTPSLANRESNAME, (Object)pSDEFInputTipBase.getContentPSLanResName());
        }
        if (pSDEFInputTipBase.isCreateDateDirty() && (bl || pSDEFInputTipBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFInputTipBase.getCreateDate());
        }
        if (pSDEFInputTipBase.isCreateManDirty() && (bl || pSDEFInputTipBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFInputTipBase.getCreateMan());
        }
        if (pSDEFInputTipBase.isDefaultFlagDirty() && (bl || pSDEFInputTipBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSDEFInputTipBase.getDefaultFlag());
        }
        if (pSDEFInputTipBase.isEnableCloseDirty() && (bl || pSDEFInputTipBase.getEnableClose() != null)) {
            iDataObject.set(FIELD_ENABLECLOSE, (Object)pSDEFInputTipBase.getEnableClose());
        }
        if (pSDEFInputTipBase.isLockFlagDirty() && (bl || pSDEFInputTipBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEFInputTipBase.getLockFlag());
        }
        if (pSDEFInputTipBase.isMemoDirty() && (bl || pSDEFInputTipBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFInputTipBase.getMemo());
        }
        if (pSDEFInputTipBase.isMoreUrlDirty() && (bl || pSDEFInputTipBase.getMoreUrl() != null)) {
            iDataObject.set(FIELD_MOREURL, (Object)pSDEFInputTipBase.getMoreUrl());
        }
        if (pSDEFInputTipBase.isPSDEFIdDirty() && (bl || pSDEFInputTipBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEFInputTipBase.getPSDEFId());
        }
        if (pSDEFInputTipBase.isPSDEFInputTipIdDirty() && (bl || pSDEFInputTipBase.getPSDEFInputTipId() != null)) {
            iDataObject.set(FIELD_PSDEFINPUTTIPID, (Object)pSDEFInputTipBase.getPSDEFInputTipId());
        }
        if (pSDEFInputTipBase.isPSDEFInputTipNameDirty() && (bl || pSDEFInputTipBase.getPSDEFInputTipName() != null)) {
            iDataObject.set(FIELD_PSDEFINPUTTIPNAME, (Object)pSDEFInputTipBase.getPSDEFInputTipName());
        }
        if (pSDEFInputTipBase.isPSDEFInputTipSetIdDirty() && (bl || pSDEFInputTipBase.getPSDEFInputTipSetId() != null)) {
            iDataObject.set(FIELD_PSDEFINPUTTIPSETID, (Object)pSDEFInputTipBase.getPSDEFInputTipSetId());
        }
        if (pSDEFInputTipBase.isPSDEFInputTipSetNameDirty() && (bl || pSDEFInputTipBase.getPSDEFInputTipSetName() != null)) {
            iDataObject.set(FIELD_PSDEFINPUTTIPSETNAME, (Object)pSDEFInputTipBase.getPSDEFInputTipSetName());
        }
        if (pSDEFInputTipBase.isPSDEFNameDirty() && (bl || pSDEFInputTipBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEFInputTipBase.getPSDEFName());
        }
        if (pSDEFInputTipBase.isPSDEIdDirty() && (bl || pSDEFInputTipBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEFInputTipBase.getPSDEId());
        }
        if (pSDEFInputTipBase.isPSDENameDirty() && (bl || pSDEFInputTipBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEFInputTipBase.getPSDEName());
        }
        if (pSDEFInputTipBase.isPSModuleIdDirty() && (bl || pSDEFInputTipBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSDEFInputTipBase.getPSModuleId());
        }
        if (pSDEFInputTipBase.isPSModuleNameDirty() && (bl || pSDEFInputTipBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSDEFInputTipBase.getPSModuleName());
        }
        if (pSDEFInputTipBase.isPSSystemIdDirty() && (bl || pSDEFInputTipBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEFInputTipBase.getPSSystemId());
        }
        if (pSDEFInputTipBase.isPSSystemNameDirty() && (bl || pSDEFInputTipBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDEFInputTipBase.getPSSystemName());
        }
        if (pSDEFInputTipBase.isRawContentDirty() && (bl || pSDEFInputTipBase.getRawContent() != null)) {
            iDataObject.set(FIELD_RAWCONTENT, (Object)pSDEFInputTipBase.getRawContent());
        }
        if (pSDEFInputTipBase.isTipModeDirty() && (bl || pSDEFInputTipBase.getTipMode() != null)) {
            iDataObject.set(FIELD_TIPMODE, (Object)pSDEFInputTipBase.getTipMode());
        }
        if (pSDEFInputTipBase.isUniqueTagDirty() && (bl || pSDEFInputTipBase.getUniqueTag() != null)) {
            iDataObject.set(FIELD_UNIQUETAG, (Object)pSDEFInputTipBase.getUniqueTag());
        }
        if (pSDEFInputTipBase.isUpdateDateDirty() && (bl || pSDEFInputTipBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFInputTipBase.getUpdateDate());
        }
        if (pSDEFInputTipBase.isUpdateManDirty() && (bl || pSDEFInputTipBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFInputTipBase.getUpdateMan());
        }
        if (pSDEFInputTipBase.isUserCatDirty() && (bl || pSDEFInputTipBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEFInputTipBase.getUserCat());
        }
        if (pSDEFInputTipBase.isUserTagDirty() && (bl || pSDEFInputTipBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEFInputTipBase.getUserTag());
        }
        if (pSDEFInputTipBase.isUserTag2Dirty() && (bl || pSDEFInputTipBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEFInputTipBase.getUserTag2());
        }
        if (pSDEFInputTipBase.isUserTag3Dirty() && (bl || pSDEFInputTipBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEFInputTipBase.getUserTag3());
        }
        if (pSDEFInputTipBase.isUserTag4Dirty() && (bl || pSDEFInputTipBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEFInputTipBase.getUserTag4());
        }
        if (pSDEFInputTipBase.isValidFlagDirty() && (bl || pSDEFInputTipBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEFInputTipBase.getValidFlag());
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
        return PSDEFInputTipBase.remove(this, n);
    }

    private static boolean remove(PSDEFInputTipBase pSDEFInputTipBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFInputTipBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEFInputTipBase.resetContent();
                return true;
            }
            case 2: {
                pSDEFInputTipBase.resetContentPSLanResId();
                return true;
            }
            case 3: {
                pSDEFInputTipBase.resetContentPSLanResName();
                return true;
            }
            case 4: {
                pSDEFInputTipBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSDEFInputTipBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSDEFInputTipBase.resetDefaultFlag();
                return true;
            }
            case 7: {
                pSDEFInputTipBase.resetEnableClose();
                return true;
            }
            case 8: {
                pSDEFInputTipBase.resetLockFlag();
                return true;
            }
            case 9: {
                pSDEFInputTipBase.resetMemo();
                return true;
            }
            case 10: {
                pSDEFInputTipBase.resetMoreUrl();
                return true;
            }
            case 11: {
                pSDEFInputTipBase.resetPSDEFId();
                return true;
            }
            case 12: {
                pSDEFInputTipBase.resetPSDEFInputTipId();
                return true;
            }
            case 13: {
                pSDEFInputTipBase.resetPSDEFInputTipName();
                return true;
            }
            case 14: {
                pSDEFInputTipBase.resetPSDEFInputTipSetId();
                return true;
            }
            case 15: {
                pSDEFInputTipBase.resetPSDEFInputTipSetName();
                return true;
            }
            case 16: {
                pSDEFInputTipBase.resetPSDEFName();
                return true;
            }
            case 17: {
                pSDEFInputTipBase.resetPSDEId();
                return true;
            }
            case 18: {
                pSDEFInputTipBase.resetPSDEName();
                return true;
            }
            case 19: {
                pSDEFInputTipBase.resetPSModuleId();
                return true;
            }
            case 20: {
                pSDEFInputTipBase.resetPSModuleName();
                return true;
            }
            case 21: {
                pSDEFInputTipBase.resetPSSystemId();
                return true;
            }
            case 22: {
                pSDEFInputTipBase.resetPSSystemName();
                return true;
            }
            case 23: {
                pSDEFInputTipBase.resetRawContent();
                return true;
            }
            case 24: {
                pSDEFInputTipBase.resetTipMode();
                return true;
            }
            case 25: {
                pSDEFInputTipBase.resetUniqueTag();
                return true;
            }
            case 26: {
                pSDEFInputTipBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSDEFInputTipBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSDEFInputTipBase.resetUserCat();
                return true;
            }
            case 29: {
                pSDEFInputTipBase.resetUserTag();
                return true;
            }
            case 30: {
                pSDEFInputTipBase.resetUserTag2();
                return true;
            }
            case 31: {
                pSDEFInputTipBase.resetUserTag3();
                return true;
            }
            case 32: {
                pSDEFInputTipBase.resetUserTag4();
                return true;
            }
            case 33: {
                pSDEFInputTipBase.resetValidFlag();
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
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFInputTipSet getPSDEFInputTipSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFInputTipSet();
        }
        if (this.getPSDEFInputTipSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEFInputTipSetLock;
        synchronized (n) {
            if (this.psdefinputtipset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFInputTipSetId(), (Object)this.psdefinputtipset.getPSDEFInputTipSetId()) != 0L) {
                this.psdefinputtipset = null;
            }
            if (this.psdefinputtipset == null) {
                PSDEFInputTipSet pSDEFInputTipSet = new PSDEFInputTipSet();
                pSDEFInputTipSet.setPSDEFInputTipSetId(this.getPSDEFInputTipSetId());
                PSDEFInputTipSetService pSDEFInputTipSetService = (PSDEFInputTipSetService)ServiceGlobal.getService(PSDEFInputTipSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEFInputTipSetService.autoGet(pSDEFInputTipSet);
                this.psdefinputtipset = pSDEFInputTipSet;
            }
            return this.psdefinputtipset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getContentPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentPSLanRes();
        }
        if (this.getContentPSLanResId() == null) {
            return null;
        }
        Integer n = this.objContentPSLanResLock;
        synchronized (n) {
            if (this.contentpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getContentPSLanResId(), (Object)this.contentpslanres.getPSLanguageResId()) != 0L) {
                this.contentpslanres = null;
            }
            if (this.contentpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getContentPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.contentpslanres = pSLanguageRes;
            }
            return this.contentpslanres;
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

    private PSDEFInputTipBase getProxyEntity() {
        return this.proxyPSDEFInputTipBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFInputTipBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFInputTipBase) {
            this.proxyPSDEFInputTipBase = (PSDEFInputTipBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CONTENT, 1);
        fieldIndexMap.put(FIELD_CONTENTPSLANRESID, 2);
        fieldIndexMap.put(FIELD_CONTENTPSLANRESNAME, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 6);
        fieldIndexMap.put(FIELD_ENABLECLOSE, 7);
        fieldIndexMap.put(FIELD_LOCKFLAG, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_MOREURL, 10);
        fieldIndexMap.put(FIELD_PSDEFID, 11);
        fieldIndexMap.put(FIELD_PSDEFINPUTTIPID, 12);
        fieldIndexMap.put(FIELD_PSDEFINPUTTIPNAME, 13);
        fieldIndexMap.put(FIELD_PSDEFINPUTTIPSETID, 14);
        fieldIndexMap.put(FIELD_PSDEFINPUTTIPSETNAME, 15);
        fieldIndexMap.put(FIELD_PSDEFNAME, 16);
        fieldIndexMap.put(FIELD_PSDEID, 17);
        fieldIndexMap.put(FIELD_PSDENAME, 18);
        fieldIndexMap.put(FIELD_PSMODULEID, 19);
        fieldIndexMap.put(FIELD_PSMODULENAME, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 22);
        fieldIndexMap.put(FIELD_RAWCONTENT, 23);
        fieldIndexMap.put(FIELD_TIPMODE, 24);
        fieldIndexMap.put(FIELD_UNIQUETAG, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USERCAT, 28);
        fieldIndexMap.put(FIELD_USERTAG, 29);
        fieldIndexMap.put(FIELD_USERTAG2, 30);
        fieldIndexMap.put(FIELD_USERTAG3, 31);
        fieldIndexMap.put(FIELD_USERTAG4, 32);
        fieldIndexMap.put(FIELD_VALIDFLAG, 33);
    }
}

