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
import net.ibizsys.pscore.srv.config.entity.PSLanguage;
import net.ibizsys.pscore.srv.config.service.PSLanguageService;
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

public abstract class PSLanguageItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSLanguageItemBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CONTENT2 = "CONTENT2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFCONTENT = "DEFCONTENT";
    public static final String FIELD_LANRESTAG = "LANRESTAG";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSLANGUAGEID = "PSLANGUAGEID";
    public static final String FIELD_PSLANGUAGEITEMID = "PSLANGUAGEITEMID";
    public static final String FIELD_PSLANGUAGEITEMNAME = "PSLANGUAGEITEMNAME";
    public static final String FIELD_PSLANGUAGENAME = "PSLANGUAGENAME";
    public static final String FIELD_PSLANGUAGERESID = "PSLANGUAGERESID";
    public static final String FIELD_PSLANGUAGERESNAME = "PSLANGUAGERESNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CONTENT2 = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DEFCONTENT = 4;
    private static final int INDEX_LANRESTAG = 5;
    private static final int INDEX_LOCKFLAG = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSLANGUAGEID = 8;
    private static final int INDEX_PSLANGUAGEITEMID = 9;
    private static final int INDEX_PSLANGUAGEITEMNAME = 10;
    private static final int INDEX_PSLANGUAGENAME = 11;
    private static final int INDEX_PSLANGUAGERESID = 12;
    private static final int INDEX_PSLANGUAGERESNAME = 13;
    private static final int INDEX_PSMODULEID = 14;
    private static final int INDEX_PSMODULENAME = 15;
    private static final int INDEX_PSSYSTEMID = 16;
    private static final int INDEX_PSSYSTEMNAME = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSLanguageItemBase proxyPSLanguageItemBase = null;
    private boolean contentDirtyFlag = false;
    private boolean content2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defcontentDirtyFlag = false;
    private boolean lanrestagDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pslanguageidDirtyFlag = false;
    private boolean pslanguageitemidDirtyFlag = false;
    private boolean pslanguageitemnameDirtyFlag = false;
    private boolean pslanguagenameDirtyFlag = false;
    private boolean pslanguageresidDirtyFlag = false;
    private boolean pslanguageresnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="content2")
    private String content2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defcontent")
    private String defcontent;
    @Column(name="lanrestag")
    private String lanrestag;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="pslanguageid")
    private String pslanguageid;
    @Column(name="pslanguageitemid")
    private String pslanguageitemid;
    @Column(name="pslanguageitemname")
    private String pslanguageitemname;
    @Column(name="pslanguagename")
    private String pslanguagename;
    @Column(name="pslanguageresid")
    private String pslanguageresid;
    @Column(name="pslanguageresname")
    private String pslanguageresname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSLanguageResLock = new Integer(1);
    private PSLanguageRes pslanguageres = null;
    private Integer objPSLanguageLock = new Integer(1);
    private PSLanguage pslanguage = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setContent2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content2 = string;
        this.content2DirtyFlag = true;
    }

    public String getContent2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent2();
        }
        return this.content2;
    }

    public boolean isContent2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContent2Dirty();
        }
        return this.content2DirtyFlag;
    }

    public void resetContent2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent2();
            return;
        }
        this.content2DirtyFlag = false;
        this.content2 = null;
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

    public void setDefContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defcontent = string;
        this.defcontentDirtyFlag = true;
    }

    public String getDefContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefContent();
        }
        return this.defcontent;
    }

    public boolean isDefContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefContentDirty();
        }
        return this.defcontentDirtyFlag;
    }

    public void resetDefContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefContent();
            return;
        }
        this.defcontentDirtyFlag = false;
        this.defcontent = null;
    }

    public void setLanResTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLanResTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lanrestag = string;
        this.lanrestagDirtyFlag = true;
    }

    public String getLanResTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLanResTag();
        }
        return this.lanrestag;
    }

    public boolean isLanResTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLanResTagDirty();
        }
        return this.lanrestagDirtyFlag;
    }

    public void resetLanResTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLanResTag();
            return;
        }
        this.lanrestagDirtyFlag = false;
        this.lanrestag = null;
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

    public void setPSLanguageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLanguageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslanguageid = string;
        this.pslanguageidDirtyFlag = true;
    }

    public String getPSLanguageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageId();
        }
        return this.pslanguageid;
    }

    public boolean isPSLanguageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLanguageIdDirty();
        }
        return this.pslanguageidDirtyFlag;
    }

    public void resetPSLanguageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLanguageId();
            return;
        }
        this.pslanguageidDirtyFlag = false;
        this.pslanguageid = null;
    }

    public void setPSLanguageItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLanguageItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslanguageitemid = string;
        this.pslanguageitemidDirtyFlag = true;
    }

    public String getPSLanguageItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageItemId();
        }
        return this.pslanguageitemid;
    }

    public boolean isPSLanguageItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLanguageItemIdDirty();
        }
        return this.pslanguageitemidDirtyFlag;
    }

    public void resetPSLanguageItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLanguageItemId();
            return;
        }
        this.pslanguageitemidDirtyFlag = false;
        this.pslanguageitemid = null;
    }

    public void setPSLanguageItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLanguageItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslanguageitemname = string;
        this.pslanguageitemnameDirtyFlag = true;
    }

    public String getPSLanguageItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageItemName();
        }
        return this.pslanguageitemname;
    }

    public boolean isPSLanguageItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLanguageItemNameDirty();
        }
        return this.pslanguageitemnameDirtyFlag;
    }

    public void resetPSLanguageItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLanguageItemName();
            return;
        }
        this.pslanguageitemnameDirtyFlag = false;
        this.pslanguageitemname = null;
    }

    public void setPSLanguageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLanguageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslanguagename = string;
        this.pslanguagenameDirtyFlag = true;
    }

    public String getPSLanguageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageName();
        }
        return this.pslanguagename;
    }

    public boolean isPSLanguageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLanguageNameDirty();
        }
        return this.pslanguagenameDirtyFlag;
    }

    public void resetPSLanguageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLanguageName();
            return;
        }
        this.pslanguagenameDirtyFlag = false;
        this.pslanguagename = null;
    }

    public void setPSLanguageResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLanguageResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslanguageresid = string;
        this.pslanguageresidDirtyFlag = true;
    }

    public String getPSLanguageResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageResId();
        }
        return this.pslanguageresid;
    }

    public boolean isPSLanguageResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLanguageResIdDirty();
        }
        return this.pslanguageresidDirtyFlag;
    }

    public void resetPSLanguageResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLanguageResId();
            return;
        }
        this.pslanguageresidDirtyFlag = false;
        this.pslanguageresid = null;
    }

    public void setPSLanguageResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLanguageResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslanguageresname = string;
        this.pslanguageresnameDirtyFlag = true;
    }

    public String getPSLanguageResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageResName();
        }
        return this.pslanguageresname;
    }

    public boolean isPSLanguageResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLanguageResNameDirty();
        }
        return this.pslanguageresnameDirtyFlag;
    }

    public void resetPSLanguageResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLanguageResName();
            return;
        }
        this.pslanguageresnameDirtyFlag = false;
        this.pslanguageresname = null;
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

    protected void onReset() {
        PSLanguageItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSLanguageItemBase pSLanguageItemBase) {
        pSLanguageItemBase.resetContent();
        pSLanguageItemBase.resetContent2();
        pSLanguageItemBase.resetCreateDate();
        pSLanguageItemBase.resetCreateMan();
        pSLanguageItemBase.resetDefContent();
        pSLanguageItemBase.resetLanResTag();
        pSLanguageItemBase.resetLockFlag();
        pSLanguageItemBase.resetMemo();
        pSLanguageItemBase.resetPSLanguageId();
        pSLanguageItemBase.resetPSLanguageItemId();
        pSLanguageItemBase.resetPSLanguageItemName();
        pSLanguageItemBase.resetPSLanguageName();
        pSLanguageItemBase.resetPSLanguageResId();
        pSLanguageItemBase.resetPSLanguageResName();
        pSLanguageItemBase.resetPSModuleId();
        pSLanguageItemBase.resetPSModuleName();
        pSLanguageItemBase.resetPSSystemId();
        pSLanguageItemBase.resetPSSystemName();
        pSLanguageItemBase.resetUpdateDate();
        pSLanguageItemBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isContent2Dirty()) {
            hashMap.put(FIELD_CONTENT2, this.getContent2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefContentDirty()) {
            hashMap.put(FIELD_DEFCONTENT, this.getDefContent());
        }
        if (!bl || this.isLanResTagDirty()) {
            hashMap.put(FIELD_LANRESTAG, this.getLanResTag());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSLanguageIdDirty()) {
            hashMap.put(FIELD_PSLANGUAGEID, this.getPSLanguageId());
        }
        if (!bl || this.isPSLanguageItemIdDirty()) {
            hashMap.put(FIELD_PSLANGUAGEITEMID, this.getPSLanguageItemId());
        }
        if (!bl || this.isPSLanguageItemNameDirty()) {
            hashMap.put(FIELD_PSLANGUAGEITEMNAME, this.getPSLanguageItemName());
        }
        if (!bl || this.isPSLanguageNameDirty()) {
            hashMap.put(FIELD_PSLANGUAGENAME, this.getPSLanguageName());
        }
        if (!bl || this.isPSLanguageResIdDirty()) {
            hashMap.put(FIELD_PSLANGUAGERESID, this.getPSLanguageResId());
        }
        if (!bl || this.isPSLanguageResNameDirty()) {
            hashMap.put(FIELD_PSLANGUAGERESNAME, this.getPSLanguageResName());
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
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSLanguageItemBase.get(this, n);
    }

    private static Object get(PSLanguageItemBase pSLanguageItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSLanguageItemBase.getContent();
            }
            case 1: {
                return pSLanguageItemBase.getContent2();
            }
            case 2: {
                return pSLanguageItemBase.getCreateDate();
            }
            case 3: {
                return pSLanguageItemBase.getCreateMan();
            }
            case 4: {
                return pSLanguageItemBase.getDefContent();
            }
            case 5: {
                return pSLanguageItemBase.getLanResTag();
            }
            case 6: {
                return pSLanguageItemBase.getLockFlag();
            }
            case 7: {
                return pSLanguageItemBase.getMemo();
            }
            case 8: {
                return pSLanguageItemBase.getPSLanguageId();
            }
            case 9: {
                return pSLanguageItemBase.getPSLanguageItemId();
            }
            case 10: {
                return pSLanguageItemBase.getPSLanguageItemName();
            }
            case 11: {
                return pSLanguageItemBase.getPSLanguageName();
            }
            case 12: {
                return pSLanguageItemBase.getPSLanguageResId();
            }
            case 13: {
                return pSLanguageItemBase.getPSLanguageResName();
            }
            case 14: {
                return pSLanguageItemBase.getPSModuleId();
            }
            case 15: {
                return pSLanguageItemBase.getPSModuleName();
            }
            case 16: {
                return pSLanguageItemBase.getPSSystemId();
            }
            case 17: {
                return pSLanguageItemBase.getPSSystemName();
            }
            case 18: {
                return pSLanguageItemBase.getUpdateDate();
            }
            case 19: {
                return pSLanguageItemBase.getUpdateMan();
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
        PSLanguageItemBase.set(this, n, object);
    }

    private static void set(PSLanguageItemBase pSLanguageItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSLanguageItemBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSLanguageItemBase.setContent2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSLanguageItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSLanguageItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSLanguageItemBase.setDefContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSLanguageItemBase.setLanResTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSLanguageItemBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSLanguageItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSLanguageItemBase.setPSLanguageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSLanguageItemBase.setPSLanguageItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSLanguageItemBase.setPSLanguageItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSLanguageItemBase.setPSLanguageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSLanguageItemBase.setPSLanguageResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSLanguageItemBase.setPSLanguageResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSLanguageItemBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSLanguageItemBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSLanguageItemBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSLanguageItemBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSLanguageItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSLanguageItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSLanguageItemBase.isNull(this, n);
    }

    private static boolean isNull(PSLanguageItemBase pSLanguageItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSLanguageItemBase.getContent() == null;
            }
            case 1: {
                return pSLanguageItemBase.getContent2() == null;
            }
            case 2: {
                return pSLanguageItemBase.getCreateDate() == null;
            }
            case 3: {
                return pSLanguageItemBase.getCreateMan() == null;
            }
            case 4: {
                return pSLanguageItemBase.getDefContent() == null;
            }
            case 5: {
                return pSLanguageItemBase.getLanResTag() == null;
            }
            case 6: {
                return pSLanguageItemBase.getLockFlag() == null;
            }
            case 7: {
                return pSLanguageItemBase.getMemo() == null;
            }
            case 8: {
                return pSLanguageItemBase.getPSLanguageId() == null;
            }
            case 9: {
                return pSLanguageItemBase.getPSLanguageItemId() == null;
            }
            case 10: {
                return pSLanguageItemBase.getPSLanguageItemName() == null;
            }
            case 11: {
                return pSLanguageItemBase.getPSLanguageName() == null;
            }
            case 12: {
                return pSLanguageItemBase.getPSLanguageResId() == null;
            }
            case 13: {
                return pSLanguageItemBase.getPSLanguageResName() == null;
            }
            case 14: {
                return pSLanguageItemBase.getPSModuleId() == null;
            }
            case 15: {
                return pSLanguageItemBase.getPSModuleName() == null;
            }
            case 16: {
                return pSLanguageItemBase.getPSSystemId() == null;
            }
            case 17: {
                return pSLanguageItemBase.getPSSystemName() == null;
            }
            case 18: {
                return pSLanguageItemBase.getUpdateDate() == null;
            }
            case 19: {
                return pSLanguageItemBase.getUpdateMan() == null;
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
        return PSLanguageItemBase.contains(this, n);
    }

    private static boolean contains(PSLanguageItemBase pSLanguageItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSLanguageItemBase.isContentDirty();
            }
            case 1: {
                return pSLanguageItemBase.isContent2Dirty();
            }
            case 2: {
                return pSLanguageItemBase.isCreateDateDirty();
            }
            case 3: {
                return pSLanguageItemBase.isCreateManDirty();
            }
            case 4: {
                return pSLanguageItemBase.isDefContentDirty();
            }
            case 5: {
                return pSLanguageItemBase.isLanResTagDirty();
            }
            case 6: {
                return pSLanguageItemBase.isLockFlagDirty();
            }
            case 7: {
                return pSLanguageItemBase.isMemoDirty();
            }
            case 8: {
                return pSLanguageItemBase.isPSLanguageIdDirty();
            }
            case 9: {
                return pSLanguageItemBase.isPSLanguageItemIdDirty();
            }
            case 10: {
                return pSLanguageItemBase.isPSLanguageItemNameDirty();
            }
            case 11: {
                return pSLanguageItemBase.isPSLanguageNameDirty();
            }
            case 12: {
                return pSLanguageItemBase.isPSLanguageResIdDirty();
            }
            case 13: {
                return pSLanguageItemBase.isPSLanguageResNameDirty();
            }
            case 14: {
                return pSLanguageItemBase.isPSModuleIdDirty();
            }
            case 15: {
                return pSLanguageItemBase.isPSModuleNameDirty();
            }
            case 16: {
                return pSLanguageItemBase.isPSSystemIdDirty();
            }
            case 17: {
                return pSLanguageItemBase.isPSSystemNameDirty();
            }
            case 18: {
                return pSLanguageItemBase.isUpdateDateDirty();
            }
            case 19: {
                return pSLanguageItemBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSLanguageItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSLanguageItemBase pSLanguageItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSLanguageItemBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getContent()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getContent2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content2", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getContent2()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getDefContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defcontent", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getDefContent()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getLanResTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lanrestag", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getLanResTag()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getPSLanguageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslanguageid", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getPSLanguageId()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getPSLanguageItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslanguageitemid", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getPSLanguageItemId()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getPSLanguageItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslanguageitemname", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getPSLanguageItemName()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getPSLanguageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslanguagename", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getPSLanguageName()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getPSLanguageResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslanguageresid", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getPSLanguageResId()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getPSLanguageResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslanguageresname", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getPSLanguageResName()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSLanguageItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSLanguageItemBase.getJSONValue((Object)pSLanguageItemBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSLanguageItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSLanguageItemBase pSLanguageItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSLanguageItemBase.getContent() != null) {
            object = pSLanguageItemBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, (String)(object == null ? "" : object));
        }
        if (bl || pSLanguageItemBase.getContent2() != null) {
            object = pSLanguageItemBase.getContent2();
            xmlNode.setAttribute(FIELD_CONTENT2, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageItemBase.getCreateDate() != null) {
            object = pSLanguageItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSLanguageItemBase.getCreateMan() != null) {
            object = pSLanguageItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageItemBase.getDefContent() != null) {
            object = pSLanguageItemBase.getDefContent();
            xmlNode.setAttribute(FIELD_DEFCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageItemBase.getLanResTag() != null) {
            object = pSLanguageItemBase.getLanResTag();
            xmlNode.setAttribute(FIELD_LANRESTAG, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageItemBase.getLockFlag() != null) {
            object = pSLanguageItemBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSLanguageItemBase.getMemo() != null) {
            object = pSLanguageItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageItemBase.getPSLanguageId() != null) {
            object = pSLanguageItemBase.getPSLanguageId();
            xmlNode.setAttribute(FIELD_PSLANGUAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageItemBase.getPSLanguageItemId() != null) {
            object = pSLanguageItemBase.getPSLanguageItemId();
            xmlNode.setAttribute(FIELD_PSLANGUAGEITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageItemBase.getPSLanguageItemName() != null) {
            object = pSLanguageItemBase.getPSLanguageItemName();
            xmlNode.setAttribute(FIELD_PSLANGUAGEITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageItemBase.getPSLanguageName() != null) {
            object = pSLanguageItemBase.getPSLanguageName();
            xmlNode.setAttribute(FIELD_PSLANGUAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageItemBase.getPSLanguageResId() != null) {
            object = pSLanguageItemBase.getPSLanguageResId();
            xmlNode.setAttribute(FIELD_PSLANGUAGERESID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageItemBase.getPSLanguageResName() != null) {
            object = pSLanguageItemBase.getPSLanguageResName();
            xmlNode.setAttribute(FIELD_PSLANGUAGERESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageItemBase.getPSModuleId() != null) {
            object = pSLanguageItemBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageItemBase.getPSModuleName() != null) {
            object = pSLanguageItemBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageItemBase.getPSSystemId() != null) {
            object = pSLanguageItemBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageItemBase.getPSSystemName() != null) {
            object = pSLanguageItemBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageItemBase.getUpdateDate() != null) {
            object = pSLanguageItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSLanguageItemBase.getUpdateMan() != null) {
            object = pSLanguageItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSLanguageItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSLanguageItemBase pSLanguageItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSLanguageItemBase.isContentDirty() && (bl || pSLanguageItemBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSLanguageItemBase.getContent());
        }
        if (pSLanguageItemBase.isContent2Dirty() && (bl || pSLanguageItemBase.getContent2() != null)) {
            iDataObject.set(FIELD_CONTENT2, (Object)pSLanguageItemBase.getContent2());
        }
        if (pSLanguageItemBase.isCreateDateDirty() && (bl || pSLanguageItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSLanguageItemBase.getCreateDate());
        }
        if (pSLanguageItemBase.isCreateManDirty() && (bl || pSLanguageItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSLanguageItemBase.getCreateMan());
        }
        if (pSLanguageItemBase.isDefContentDirty() && (bl || pSLanguageItemBase.getDefContent() != null)) {
            iDataObject.set(FIELD_DEFCONTENT, (Object)pSLanguageItemBase.getDefContent());
        }
        if (pSLanguageItemBase.isLanResTagDirty() && (bl || pSLanguageItemBase.getLanResTag() != null)) {
            iDataObject.set(FIELD_LANRESTAG, (Object)pSLanguageItemBase.getLanResTag());
        }
        if (pSLanguageItemBase.isLockFlagDirty() && (bl || pSLanguageItemBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSLanguageItemBase.getLockFlag());
        }
        if (pSLanguageItemBase.isMemoDirty() && (bl || pSLanguageItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSLanguageItemBase.getMemo());
        }
        if (pSLanguageItemBase.isPSLanguageIdDirty() && (bl || pSLanguageItemBase.getPSLanguageId() != null)) {
            iDataObject.set(FIELD_PSLANGUAGEID, (Object)pSLanguageItemBase.getPSLanguageId());
        }
        if (pSLanguageItemBase.isPSLanguageItemIdDirty() && (bl || pSLanguageItemBase.getPSLanguageItemId() != null)) {
            iDataObject.set(FIELD_PSLANGUAGEITEMID, (Object)pSLanguageItemBase.getPSLanguageItemId());
        }
        if (pSLanguageItemBase.isPSLanguageItemNameDirty() && (bl || pSLanguageItemBase.getPSLanguageItemName() != null)) {
            iDataObject.set(FIELD_PSLANGUAGEITEMNAME, (Object)pSLanguageItemBase.getPSLanguageItemName());
        }
        if (pSLanguageItemBase.isPSLanguageNameDirty() && (bl || pSLanguageItemBase.getPSLanguageName() != null)) {
            iDataObject.set(FIELD_PSLANGUAGENAME, (Object)pSLanguageItemBase.getPSLanguageName());
        }
        if (pSLanguageItemBase.isPSLanguageResIdDirty() && (bl || pSLanguageItemBase.getPSLanguageResId() != null)) {
            iDataObject.set(FIELD_PSLANGUAGERESID, (Object)pSLanguageItemBase.getPSLanguageResId());
        }
        if (pSLanguageItemBase.isPSLanguageResNameDirty() && (bl || pSLanguageItemBase.getPSLanguageResName() != null)) {
            iDataObject.set(FIELD_PSLANGUAGERESNAME, (Object)pSLanguageItemBase.getPSLanguageResName());
        }
        if (pSLanguageItemBase.isPSModuleIdDirty() && (bl || pSLanguageItemBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSLanguageItemBase.getPSModuleId());
        }
        if (pSLanguageItemBase.isPSModuleNameDirty() && (bl || pSLanguageItemBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSLanguageItemBase.getPSModuleName());
        }
        if (pSLanguageItemBase.isPSSystemIdDirty() && (bl || pSLanguageItemBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSLanguageItemBase.getPSSystemId());
        }
        if (pSLanguageItemBase.isPSSystemNameDirty() && (bl || pSLanguageItemBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSLanguageItemBase.getPSSystemName());
        }
        if (pSLanguageItemBase.isUpdateDateDirty() && (bl || pSLanguageItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSLanguageItemBase.getUpdateDate());
        }
        if (pSLanguageItemBase.isUpdateManDirty() && (bl || pSLanguageItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSLanguageItemBase.getUpdateMan());
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
        return PSLanguageItemBase.remove(this, n);
    }

    private static boolean remove(PSLanguageItemBase pSLanguageItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSLanguageItemBase.resetContent();
                return true;
            }
            case 1: {
                pSLanguageItemBase.resetContent2();
                return true;
            }
            case 2: {
                pSLanguageItemBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSLanguageItemBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSLanguageItemBase.resetDefContent();
                return true;
            }
            case 5: {
                pSLanguageItemBase.resetLanResTag();
                return true;
            }
            case 6: {
                pSLanguageItemBase.resetLockFlag();
                return true;
            }
            case 7: {
                pSLanguageItemBase.resetMemo();
                return true;
            }
            case 8: {
                pSLanguageItemBase.resetPSLanguageId();
                return true;
            }
            case 9: {
                pSLanguageItemBase.resetPSLanguageItemId();
                return true;
            }
            case 10: {
                pSLanguageItemBase.resetPSLanguageItemName();
                return true;
            }
            case 11: {
                pSLanguageItemBase.resetPSLanguageName();
                return true;
            }
            case 12: {
                pSLanguageItemBase.resetPSLanguageResId();
                return true;
            }
            case 13: {
                pSLanguageItemBase.resetPSLanguageResName();
                return true;
            }
            case 14: {
                pSLanguageItemBase.resetPSModuleId();
                return true;
            }
            case 15: {
                pSLanguageItemBase.resetPSModuleName();
                return true;
            }
            case 16: {
                pSLanguageItemBase.resetPSSystemId();
                return true;
            }
            case 17: {
                pSLanguageItemBase.resetPSSystemName();
                return true;
            }
            case 18: {
                pSLanguageItemBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSLanguageItemBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getPSLanguageRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageRes();
        }
        if (this.getPSLanguageResId() == null) {
            return null;
        }
        Integer n = this.objPSLanguageResLock;
        synchronized (n) {
            if (this.pslanguageres != null && DataTypeHelper.compare((int)25, (Object)this.getPSLanguageResId(), (Object)this.pslanguageres.getPSLanguageResId()) != 0L) {
                this.pslanguageres = null;
            }
            if (this.pslanguageres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getPSLanguageResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.pslanguageres = pSLanguageRes;
            }
            return this.pslanguageres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguage getPSLanguage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguage();
        }
        if (this.getPSLanguageId() == null) {
            return null;
        }
        Integer n = this.objPSLanguageLock;
        synchronized (n) {
            if (this.pslanguage != null && DataTypeHelper.compare((int)25, (Object)this.getPSLanguageId(), (Object)this.pslanguage.getPSLanguageId()) != 0L) {
                this.pslanguage = null;
            }
            if (this.pslanguage == null) {
                PSLanguage pSLanguage = new PSLanguage();
                pSLanguage.setPSLanguageId(this.getPSLanguageId());
                PSLanguageService pSLanguageService = (PSLanguageService)ServiceGlobal.getService(PSLanguageService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageService.autoGet(pSLanguage);
                this.pslanguage = pSLanguage;
            }
            return this.pslanguage;
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

    private PSLanguageItemBase getProxyEntity() {
        return this.proxyPSLanguageItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSLanguageItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSLanguageItemBase) {
            this.proxyPSLanguageItemBase = (PSLanguageItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CONTENT2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DEFCONTENT, 4);
        fieldIndexMap.put(FIELD_LANRESTAG, 5);
        fieldIndexMap.put(FIELD_LOCKFLAG, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSLANGUAGEID, 8);
        fieldIndexMap.put(FIELD_PSLANGUAGEITEMID, 9);
        fieldIndexMap.put(FIELD_PSLANGUAGEITEMNAME, 10);
        fieldIndexMap.put(FIELD_PSLANGUAGENAME, 11);
        fieldIndexMap.put(FIELD_PSLANGUAGERESID, 12);
        fieldIndexMap.put(FIELD_PSLANGUAGERESNAME, 13);
        fieldIndexMap.put(FIELD_PSMODULEID, 14);
        fieldIndexMap.put(FIELD_PSMODULENAME, 15);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 16);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
    }
}

