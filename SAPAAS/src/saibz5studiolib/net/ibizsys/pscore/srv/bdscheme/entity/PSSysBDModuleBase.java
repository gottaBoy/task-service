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
package net.ibizsys.pscore.srv.bdscheme.entity;

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
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDScheme;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDModuleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBDModuleBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DENAMES = "DENAMES";
    public static final String FIELD_IMPDEMODE = "IMPDEMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSBDMODULEID = "PSSYSBDMODULEID";
    public static final String FIELD_PSSYSBDMODULENAME = "PSSYSBDMODULENAME";
    public static final String FIELD_PSSYSBDSCHEMEID = "PSSYSBDSCHEMEID";
    public static final String FIELD_PSSYSBDSCHEMENAME = "PSSYSBDSCHEMENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DENAMES = 3;
    private static final int INDEX_IMPDEMODE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSMODULEID = 6;
    private static final int INDEX_PSMODULENAME = 7;
    private static final int INDEX_PSSYSBDMODULEID = 8;
    private static final int INDEX_PSSYSBDMODULENAME = 9;
    private static final int INDEX_PSSYSBDSCHEMEID = 10;
    private static final int INDEX_PSSYSBDSCHEMENAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBDModuleBase proxyPSSysBDModuleBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean denamesDirtyFlag = false;
    private boolean impdemodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysbdmoduleidDirtyFlag = false;
    private boolean pssysbdmodulenameDirtyFlag = false;
    private boolean pssysbdschemeidDirtyFlag = false;
    private boolean pssysbdschemenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="denames")
    private String denames;
    @Column(name="impdemode")
    private Integer impdemode;
    @Column(name="memo")
    private String memo;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysbdmoduleid")
    private String pssysbdmoduleid;
    @Column(name="pssysbdmodulename")
    private String pssysbdmodulename;
    @Column(name="pssysbdschemeid")
    private String pssysbdschemeid;
    @Column(name="pssysbdschemename")
    private String pssysbdschemename;
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
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysBDSchemeLock = new Integer(1);
    private PSSysBDScheme pssysbdscheme = null;

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

    public void setDENames(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDENames(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.denames = string;
        this.denamesDirtyFlag = true;
    }

    public String getDENames() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDENames();
        }
        return this.denames;
    }

    public boolean isDENamesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDENamesDirty();
        }
        return this.denamesDirtyFlag;
    }

    public void resetDENames() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDENames();
            return;
        }
        this.denamesDirtyFlag = false;
        this.denames = null;
    }

    public void setImpDEMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImpDEMode(n);
            return;
        }
        this.impdemode = n;
        this.impdemodeDirtyFlag = true;
    }

    public Integer getImpDEMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImpDEMode();
        }
        return this.impdemode;
    }

    public boolean isImpDEModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImpDEModeDirty();
        }
        return this.impdemodeDirtyFlag;
    }

    public void resetImpDEMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImpDEMode();
            return;
        }
        this.impdemodeDirtyFlag = false;
        this.impdemode = null;
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

    public void setPSSysBDModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdmoduleid = string;
        this.pssysbdmoduleidDirtyFlag = true;
    }

    public String getPSSysBDModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDModuleId();
        }
        return this.pssysbdmoduleid;
    }

    public boolean isPSSysBDModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDModuleIdDirty();
        }
        return this.pssysbdmoduleidDirtyFlag;
    }

    public void resetPSSysBDModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDModuleId();
            return;
        }
        this.pssysbdmoduleidDirtyFlag = false;
        this.pssysbdmoduleid = null;
    }

    public void setPSSysBDModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdmodulename = string;
        this.pssysbdmodulenameDirtyFlag = true;
    }

    public String getPSSysBDModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDModuleName();
        }
        return this.pssysbdmodulename;
    }

    public boolean isPSSysBDModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDModuleNameDirty();
        }
        return this.pssysbdmodulenameDirtyFlag;
    }

    public void resetPSSysBDModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDModuleName();
            return;
        }
        this.pssysbdmodulenameDirtyFlag = false;
        this.pssysbdmodulename = null;
    }

    public void setPSSysBDSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdschemeid = string;
        this.pssysbdschemeidDirtyFlag = true;
    }

    public String getPSSysBDSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDSchemeId();
        }
        return this.pssysbdschemeid;
    }

    public boolean isPSSysBDSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDSchemeIdDirty();
        }
        return this.pssysbdschemeidDirtyFlag;
    }

    public void resetPSSysBDSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDSchemeId();
            return;
        }
        this.pssysbdschemeidDirtyFlag = false;
        this.pssysbdschemeid = null;
    }

    public void setPSSysBDSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdschemename = string;
        this.pssysbdschemenameDirtyFlag = true;
    }

    public String getPSSysBDSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDSchemeName();
        }
        return this.pssysbdschemename;
    }

    public boolean isPSSysBDSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDSchemeNameDirty();
        }
        return this.pssysbdschemenameDirtyFlag;
    }

    public void resetPSSysBDSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDSchemeName();
            return;
        }
        this.pssysbdschemenameDirtyFlag = false;
        this.pssysbdschemename = null;
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
        PSSysBDModuleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBDModuleBase pSSysBDModuleBase) {
        pSSysBDModuleBase.resetCodeName();
        pSSysBDModuleBase.resetCreateDate();
        pSSysBDModuleBase.resetCreateMan();
        pSSysBDModuleBase.resetDENames();
        pSSysBDModuleBase.resetImpDEMode();
        pSSysBDModuleBase.resetMemo();
        pSSysBDModuleBase.resetPSModuleId();
        pSSysBDModuleBase.resetPSModuleName();
        pSSysBDModuleBase.resetPSSysBDModuleId();
        pSSysBDModuleBase.resetPSSysBDModuleName();
        pSSysBDModuleBase.resetPSSysBDSchemeId();
        pSSysBDModuleBase.resetPSSysBDSchemeName();
        pSSysBDModuleBase.resetUpdateDate();
        pSSysBDModuleBase.resetUpdateMan();
        pSSysBDModuleBase.resetUserCat();
        pSSysBDModuleBase.resetUserTag();
        pSSysBDModuleBase.resetUserTag2();
        pSSysBDModuleBase.resetUserTag3();
        pSSysBDModuleBase.resetUserTag4();
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
        if (!bl || this.isDENamesDirty()) {
            hashMap.put(FIELD_DENAMES, this.getDENames());
        }
        if (!bl || this.isImpDEModeDirty()) {
            hashMap.put(FIELD_IMPDEMODE, this.getImpDEMode());
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
        if (!bl || this.isPSSysBDModuleIdDirty()) {
            hashMap.put(FIELD_PSSYSBDMODULEID, this.getPSSysBDModuleId());
        }
        if (!bl || this.isPSSysBDModuleNameDirty()) {
            hashMap.put(FIELD_PSSYSBDMODULENAME, this.getPSSysBDModuleName());
        }
        if (!bl || this.isPSSysBDSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBDSCHEMEID, this.getPSSysBDSchemeId());
        }
        if (!bl || this.isPSSysBDSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSBDSCHEMENAME, this.getPSSysBDSchemeName());
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
        return PSSysBDModuleBase.get(this, n);
    }

    private static Object get(PSSysBDModuleBase pSSysBDModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDModuleBase.getCodeName();
            }
            case 1: {
                return pSSysBDModuleBase.getCreateDate();
            }
            case 2: {
                return pSSysBDModuleBase.getCreateMan();
            }
            case 3: {
                return pSSysBDModuleBase.getDENames();
            }
            case 4: {
                return pSSysBDModuleBase.getImpDEMode();
            }
            case 5: {
                return pSSysBDModuleBase.getMemo();
            }
            case 6: {
                return pSSysBDModuleBase.getPSModuleId();
            }
            case 7: {
                return pSSysBDModuleBase.getPSModuleName();
            }
            case 8: {
                return pSSysBDModuleBase.getPSSysBDModuleId();
            }
            case 9: {
                return pSSysBDModuleBase.getPSSysBDModuleName();
            }
            case 10: {
                return pSSysBDModuleBase.getPSSysBDSchemeId();
            }
            case 11: {
                return pSSysBDModuleBase.getPSSysBDSchemeName();
            }
            case 12: {
                return pSSysBDModuleBase.getUpdateDate();
            }
            case 13: {
                return pSSysBDModuleBase.getUpdateMan();
            }
            case 14: {
                return pSSysBDModuleBase.getUserCat();
            }
            case 15: {
                return pSSysBDModuleBase.getUserTag();
            }
            case 16: {
                return pSSysBDModuleBase.getUserTag2();
            }
            case 17: {
                return pSSysBDModuleBase.getUserTag3();
            }
            case 18: {
                return pSSysBDModuleBase.getUserTag4();
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
        PSSysBDModuleBase.set(this, n, object);
    }

    private static void set(PSSysBDModuleBase pSSysBDModuleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDModuleBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBDModuleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysBDModuleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBDModuleBase.setDENames(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBDModuleBase.setImpDEMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysBDModuleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBDModuleBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBDModuleBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBDModuleBase.setPSSysBDModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBDModuleBase.setPSSysBDModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBDModuleBase.setPSSysBDSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBDModuleBase.setPSSysBDSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBDModuleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSysBDModuleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBDModuleBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBDModuleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBDModuleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysBDModuleBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBDModuleBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysBDModuleBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBDModuleBase pSSysBDModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDModuleBase.getCodeName() == null;
            }
            case 1: {
                return pSSysBDModuleBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysBDModuleBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysBDModuleBase.getDENames() == null;
            }
            case 4: {
                return pSSysBDModuleBase.getImpDEMode() == null;
            }
            case 5: {
                return pSSysBDModuleBase.getMemo() == null;
            }
            case 6: {
                return pSSysBDModuleBase.getPSModuleId() == null;
            }
            case 7: {
                return pSSysBDModuleBase.getPSModuleName() == null;
            }
            case 8: {
                return pSSysBDModuleBase.getPSSysBDModuleId() == null;
            }
            case 9: {
                return pSSysBDModuleBase.getPSSysBDModuleName() == null;
            }
            case 10: {
                return pSSysBDModuleBase.getPSSysBDSchemeId() == null;
            }
            case 11: {
                return pSSysBDModuleBase.getPSSysBDSchemeName() == null;
            }
            case 12: {
                return pSSysBDModuleBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSysBDModuleBase.getUpdateMan() == null;
            }
            case 14: {
                return pSSysBDModuleBase.getUserCat() == null;
            }
            case 15: {
                return pSSysBDModuleBase.getUserTag() == null;
            }
            case 16: {
                return pSSysBDModuleBase.getUserTag2() == null;
            }
            case 17: {
                return pSSysBDModuleBase.getUserTag3() == null;
            }
            case 18: {
                return pSSysBDModuleBase.getUserTag4() == null;
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
        return PSSysBDModuleBase.contains(this, n);
    }

    private static boolean contains(PSSysBDModuleBase pSSysBDModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDModuleBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysBDModuleBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysBDModuleBase.isCreateManDirty();
            }
            case 3: {
                return pSSysBDModuleBase.isDENamesDirty();
            }
            case 4: {
                return pSSysBDModuleBase.isImpDEModeDirty();
            }
            case 5: {
                return pSSysBDModuleBase.isMemoDirty();
            }
            case 6: {
                return pSSysBDModuleBase.isPSModuleIdDirty();
            }
            case 7: {
                return pSSysBDModuleBase.isPSModuleNameDirty();
            }
            case 8: {
                return pSSysBDModuleBase.isPSSysBDModuleIdDirty();
            }
            case 9: {
                return pSSysBDModuleBase.isPSSysBDModuleNameDirty();
            }
            case 10: {
                return pSSysBDModuleBase.isPSSysBDSchemeIdDirty();
            }
            case 11: {
                return pSSysBDModuleBase.isPSSysBDSchemeNameDirty();
            }
            case 12: {
                return pSSysBDModuleBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSysBDModuleBase.isUpdateManDirty();
            }
            case 14: {
                return pSSysBDModuleBase.isUserCatDirty();
            }
            case 15: {
                return pSSysBDModuleBase.isUserTagDirty();
            }
            case 16: {
                return pSSysBDModuleBase.isUserTag2Dirty();
            }
            case 17: {
                return pSSysBDModuleBase.isUserTag3Dirty();
            }
            case 18: {
                return pSSysBDModuleBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBDModuleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBDModuleBase pSSysBDModuleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBDModuleBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getDENames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"denames", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getDENames()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getImpDEMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"impdemode", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getImpDEMode()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getPSSysBDModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdmoduleid", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getPSSysBDModuleId()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getPSSysBDModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdmodulename", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getPSSysBDModuleName()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getPSSysBDSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdschemeid", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getPSSysBDSchemeId()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getPSSysBDSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdschemename", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getPSSysBDSchemeName()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBDModuleBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBDModuleBase.getJSONValue((Object)pSSysBDModuleBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBDModuleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBDModuleBase pSSysBDModuleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBDModuleBase.getCodeName() != null) {
            object = pSSysBDModuleBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDModuleBase.getCreateDate() != null) {
            object = pSSysBDModuleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDModuleBase.getCreateMan() != null) {
            object = pSSysBDModuleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDModuleBase.getDENames() != null) {
            object = pSSysBDModuleBase.getDENames();
            xmlNode.setAttribute(FIELD_DENAMES, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDModuleBase.getImpDEMode() != null) {
            object = pSSysBDModuleBase.getImpDEMode();
            xmlNode.setAttribute(FIELD_IMPDEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBDModuleBase.getMemo() != null) {
            object = pSSysBDModuleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDModuleBase.getPSModuleId() != null) {
            object = pSSysBDModuleBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDModuleBase.getPSModuleName() != null) {
            object = pSSysBDModuleBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDModuleBase.getPSSysBDModuleId() != null) {
            object = pSSysBDModuleBase.getPSSysBDModuleId();
            xmlNode.setAttribute(FIELD_PSSYSBDMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDModuleBase.getPSSysBDModuleName() != null) {
            object = pSSysBDModuleBase.getPSSysBDModuleName();
            xmlNode.setAttribute(FIELD_PSSYSBDMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDModuleBase.getPSSysBDSchemeId() != null) {
            object = pSSysBDModuleBase.getPSSysBDSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBDSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDModuleBase.getPSSysBDSchemeName() != null) {
            object = pSSysBDModuleBase.getPSSysBDSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSBDSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDModuleBase.getUpdateDate() != null) {
            object = pSSysBDModuleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDModuleBase.getUpdateMan() != null) {
            object = pSSysBDModuleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDModuleBase.getUserCat() != null) {
            object = pSSysBDModuleBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDModuleBase.getUserTag() != null) {
            object = pSSysBDModuleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDModuleBase.getUserTag2() != null) {
            object = pSSysBDModuleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDModuleBase.getUserTag3() != null) {
            object = pSSysBDModuleBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDModuleBase.getUserTag4() != null) {
            object = pSSysBDModuleBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBDModuleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBDModuleBase pSSysBDModuleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBDModuleBase.isCodeNameDirty() && (bl || pSSysBDModuleBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBDModuleBase.getCodeName());
        }
        if (pSSysBDModuleBase.isCreateDateDirty() && (bl || pSSysBDModuleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBDModuleBase.getCreateDate());
        }
        if (pSSysBDModuleBase.isCreateManDirty() && (bl || pSSysBDModuleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBDModuleBase.getCreateMan());
        }
        if (pSSysBDModuleBase.isDENamesDirty() && (bl || pSSysBDModuleBase.getDENames() != null)) {
            iDataObject.set(FIELD_DENAMES, (Object)pSSysBDModuleBase.getDENames());
        }
        if (pSSysBDModuleBase.isImpDEModeDirty() && (bl || pSSysBDModuleBase.getImpDEMode() != null)) {
            iDataObject.set(FIELD_IMPDEMODE, (Object)pSSysBDModuleBase.getImpDEMode());
        }
        if (pSSysBDModuleBase.isMemoDirty() && (bl || pSSysBDModuleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBDModuleBase.getMemo());
        }
        if (pSSysBDModuleBase.isPSModuleIdDirty() && (bl || pSSysBDModuleBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysBDModuleBase.getPSModuleId());
        }
        if (pSSysBDModuleBase.isPSModuleNameDirty() && (bl || pSSysBDModuleBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysBDModuleBase.getPSModuleName());
        }
        if (pSSysBDModuleBase.isPSSysBDModuleIdDirty() && (bl || pSSysBDModuleBase.getPSSysBDModuleId() != null)) {
            iDataObject.set(FIELD_PSSYSBDMODULEID, (Object)pSSysBDModuleBase.getPSSysBDModuleId());
        }
        if (pSSysBDModuleBase.isPSSysBDModuleNameDirty() && (bl || pSSysBDModuleBase.getPSSysBDModuleName() != null)) {
            iDataObject.set(FIELD_PSSYSBDMODULENAME, (Object)pSSysBDModuleBase.getPSSysBDModuleName());
        }
        if (pSSysBDModuleBase.isPSSysBDSchemeIdDirty() && (bl || pSSysBDModuleBase.getPSSysBDSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBDSCHEMEID, (Object)pSSysBDModuleBase.getPSSysBDSchemeId());
        }
        if (pSSysBDModuleBase.isPSSysBDSchemeNameDirty() && (bl || pSSysBDModuleBase.getPSSysBDSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSBDSCHEMENAME, (Object)pSSysBDModuleBase.getPSSysBDSchemeName());
        }
        if (pSSysBDModuleBase.isUpdateDateDirty() && (bl || pSSysBDModuleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBDModuleBase.getUpdateDate());
        }
        if (pSSysBDModuleBase.isUpdateManDirty() && (bl || pSSysBDModuleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBDModuleBase.getUpdateMan());
        }
        if (pSSysBDModuleBase.isUserCatDirty() && (bl || pSSysBDModuleBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBDModuleBase.getUserCat());
        }
        if (pSSysBDModuleBase.isUserTagDirty() && (bl || pSSysBDModuleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBDModuleBase.getUserTag());
        }
        if (pSSysBDModuleBase.isUserTag2Dirty() && (bl || pSSysBDModuleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBDModuleBase.getUserTag2());
        }
        if (pSSysBDModuleBase.isUserTag3Dirty() && (bl || pSSysBDModuleBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBDModuleBase.getUserTag3());
        }
        if (pSSysBDModuleBase.isUserTag4Dirty() && (bl || pSSysBDModuleBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBDModuleBase.getUserTag4());
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
        return PSSysBDModuleBase.remove(this, n);
    }

    private static boolean remove(PSSysBDModuleBase pSSysBDModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDModuleBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysBDModuleBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysBDModuleBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysBDModuleBase.resetDENames();
                return true;
            }
            case 4: {
                pSSysBDModuleBase.resetImpDEMode();
                return true;
            }
            case 5: {
                pSSysBDModuleBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysBDModuleBase.resetPSModuleId();
                return true;
            }
            case 7: {
                pSSysBDModuleBase.resetPSModuleName();
                return true;
            }
            case 8: {
                pSSysBDModuleBase.resetPSSysBDModuleId();
                return true;
            }
            case 9: {
                pSSysBDModuleBase.resetPSSysBDModuleName();
                return true;
            }
            case 10: {
                pSSysBDModuleBase.resetPSSysBDSchemeId();
                return true;
            }
            case 11: {
                pSSysBDModuleBase.resetPSSysBDSchemeName();
                return true;
            }
            case 12: {
                pSSysBDModuleBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSysBDModuleBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSSysBDModuleBase.resetUserCat();
                return true;
            }
            case 15: {
                pSSysBDModuleBase.resetUserTag();
                return true;
            }
            case 16: {
                pSSysBDModuleBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSSysBDModuleBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSSysBDModuleBase.resetUserTag4();
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
    public PSSysBDScheme getPSSysBDScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDScheme();
        }
        if (this.getPSSysBDSchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysBDSchemeLock;
        synchronized (n) {
            if (this.pssysbdscheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBDSchemeId(), (Object)this.pssysbdscheme.getPSSysBDSchemeId()) != 0L) {
                this.pssysbdscheme = null;
            }
            if (this.pssysbdscheme == null) {
                PSSysBDScheme pSSysBDScheme = new PSSysBDScheme();
                pSSysBDScheme.setPSSysBDSchemeId(this.getPSSysBDSchemeId());
                PSSysBDSchemeService pSSysBDSchemeService = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDSchemeService.autoGet((IEntity)pSSysBDScheme);
                this.pssysbdscheme = pSSysBDScheme;
            }
            return this.pssysbdscheme;
        }
    }

    private PSSysBDModuleBase getProxyEntity() {
        return this.proxyPSSysBDModuleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBDModuleBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBDModuleBase) {
            this.proxyPSSysBDModuleBase = (PSSysBDModuleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDModuleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DENAMES, 3);
        fieldIndexMap.put(FIELD_IMPDEMODE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSMODULEID, 6);
        fieldIndexMap.put(FIELD_PSMODULENAME, 7);
        fieldIndexMap.put(FIELD_PSSYSBDMODULEID, 8);
        fieldIndexMap.put(FIELD_PSSYSBDMODULENAME, 9);
        fieldIndexMap.put(FIELD_PSSYSBDSCHEMEID, 10);
        fieldIndexMap.put(FIELD_PSSYSBDSCHEMENAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERCAT, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
    }
}

