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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppPFPluginBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppPFPluginBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPPFPLUGINID = "PSAPPPFPLUGINID";
    public static final String FIELD_PSAPPPFPLUGINNAME = "PSAPPPFPLUGINNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
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
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSAPPPFPLUGINID = 4;
    private static final int INDEX_PSAPPPFPLUGINNAME = 5;
    private static final int INDEX_PSSYSAPPID = 6;
    private static final int INDEX_PSSYSAPPNAME = 7;
    private static final int INDEX_PSSYSPFPLUGINID = 8;
    private static final int INDEX_PSSYSPFPLUGINNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERCAT = 12;
    private static final int INDEX_USERTAG = 13;
    private static final int INDEX_USERTAG2 = 14;
    private static final int INDEX_USERTAG3 = 15;
    private static final int INDEX_USERTAG4 = 16;
    private static final int INDEX_VALIDFLAG = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppPFPluginBase proxyPSAppPFPluginBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psapppfpluginidDirtyFlag = false;
    private boolean psapppfpluginnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
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
    @Column(name="memo")
    private String memo;
    @Column(name="psapppfpluginid")
    private String psapppfpluginid;
    @Column(name="psapppfpluginname")
    private String psapppfpluginname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
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
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;

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

    public void setPSAppPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapppfpluginid = string;
        this.psapppfpluginidDirtyFlag = true;
    }

    public String getPSAppPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPFPluginId();
        }
        return this.psapppfpluginid;
    }

    public boolean isPSAppPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPFPluginIdDirty();
        }
        return this.psapppfpluginidDirtyFlag;
    }

    public void resetPSAppPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPFPluginId();
            return;
        }
        this.psapppfpluginidDirtyFlag = false;
        this.psapppfpluginid = null;
    }

    public void setPSAppPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapppfpluginname = string;
        this.psapppfpluginnameDirtyFlag = true;
    }

    public String getPSAppPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppPFPluginName();
        }
        return this.psapppfpluginname;
    }

    public boolean isPSAppPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppPFPluginNameDirty();
        }
        return this.psapppfpluginnameDirtyFlag;
    }

    public void resetPSAppPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppPFPluginName();
            return;
        }
        this.psapppfpluginnameDirtyFlag = false;
        this.psapppfpluginname = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
    }

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
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
        PSAppPFPluginBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppPFPluginBase pSAppPFPluginBase) {
        pSAppPFPluginBase.resetCodeName();
        pSAppPFPluginBase.resetCreateDate();
        pSAppPFPluginBase.resetCreateMan();
        pSAppPFPluginBase.resetMemo();
        pSAppPFPluginBase.resetPSAppPFPluginId();
        pSAppPFPluginBase.resetPSAppPFPluginName();
        pSAppPFPluginBase.resetPSSysAppId();
        pSAppPFPluginBase.resetPSSysAppName();
        pSAppPFPluginBase.resetPSSysPFPluginId();
        pSAppPFPluginBase.resetPSSysPFPluginName();
        pSAppPFPluginBase.resetUpdateDate();
        pSAppPFPluginBase.resetUpdateMan();
        pSAppPFPluginBase.resetUserCat();
        pSAppPFPluginBase.resetUserTag();
        pSAppPFPluginBase.resetUserTag2();
        pSAppPFPluginBase.resetUserTag3();
        pSAppPFPluginBase.resetUserTag4();
        pSAppPFPluginBase.resetValidFlag();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAppPFPluginIdDirty()) {
            hashMap.put(FIELD_PSAPPPFPLUGINID, this.getPSAppPFPluginId());
        }
        if (!bl || this.isPSAppPFPluginNameDirty()) {
            hashMap.put(FIELD_PSAPPPFPLUGINNAME, this.getPSAppPFPluginName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
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
        return PSAppPFPluginBase.get(this, n);
    }

    private static Object get(PSAppPFPluginBase pSAppPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppPFPluginBase.getCodeName();
            }
            case 1: {
                return pSAppPFPluginBase.getCreateDate();
            }
            case 2: {
                return pSAppPFPluginBase.getCreateMan();
            }
            case 3: {
                return pSAppPFPluginBase.getMemo();
            }
            case 4: {
                return pSAppPFPluginBase.getPSAppPFPluginId();
            }
            case 5: {
                return pSAppPFPluginBase.getPSAppPFPluginName();
            }
            case 6: {
                return pSAppPFPluginBase.getPSSysAppId();
            }
            case 7: {
                return pSAppPFPluginBase.getPSSysAppName();
            }
            case 8: {
                return pSAppPFPluginBase.getPSSysPFPluginId();
            }
            case 9: {
                return pSAppPFPluginBase.getPSSysPFPluginName();
            }
            case 10: {
                return pSAppPFPluginBase.getUpdateDate();
            }
            case 11: {
                return pSAppPFPluginBase.getUpdateMan();
            }
            case 12: {
                return pSAppPFPluginBase.getUserCat();
            }
            case 13: {
                return pSAppPFPluginBase.getUserTag();
            }
            case 14: {
                return pSAppPFPluginBase.getUserTag2();
            }
            case 15: {
                return pSAppPFPluginBase.getUserTag3();
            }
            case 16: {
                return pSAppPFPluginBase.getUserTag4();
            }
            case 17: {
                return pSAppPFPluginBase.getValidFlag();
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
        PSAppPFPluginBase.set(this, n, object);
    }

    private static void set(PSAppPFPluginBase pSAppPFPluginBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppPFPluginBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppPFPluginBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSAppPFPluginBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppPFPluginBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppPFPluginBase.setPSAppPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppPFPluginBase.setPSAppPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppPFPluginBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppPFPluginBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppPFPluginBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppPFPluginBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppPFPluginBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSAppPFPluginBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppPFPluginBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppPFPluginBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSAppPFPluginBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSAppPFPluginBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSAppPFPluginBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSAppPFPluginBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppPFPluginBase.isNull(this, n);
    }

    private static boolean isNull(PSAppPFPluginBase pSAppPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppPFPluginBase.getCodeName() == null;
            }
            case 1: {
                return pSAppPFPluginBase.getCreateDate() == null;
            }
            case 2: {
                return pSAppPFPluginBase.getCreateMan() == null;
            }
            case 3: {
                return pSAppPFPluginBase.getMemo() == null;
            }
            case 4: {
                return pSAppPFPluginBase.getPSAppPFPluginId() == null;
            }
            case 5: {
                return pSAppPFPluginBase.getPSAppPFPluginName() == null;
            }
            case 6: {
                return pSAppPFPluginBase.getPSSysAppId() == null;
            }
            case 7: {
                return pSAppPFPluginBase.getPSSysAppName() == null;
            }
            case 8: {
                return pSAppPFPluginBase.getPSSysPFPluginId() == null;
            }
            case 9: {
                return pSAppPFPluginBase.getPSSysPFPluginName() == null;
            }
            case 10: {
                return pSAppPFPluginBase.getUpdateDate() == null;
            }
            case 11: {
                return pSAppPFPluginBase.getUpdateMan() == null;
            }
            case 12: {
                return pSAppPFPluginBase.getUserCat() == null;
            }
            case 13: {
                return pSAppPFPluginBase.getUserTag() == null;
            }
            case 14: {
                return pSAppPFPluginBase.getUserTag2() == null;
            }
            case 15: {
                return pSAppPFPluginBase.getUserTag3() == null;
            }
            case 16: {
                return pSAppPFPluginBase.getUserTag4() == null;
            }
            case 17: {
                return pSAppPFPluginBase.getValidFlag() == null;
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
        return PSAppPFPluginBase.contains(this, n);
    }

    private static boolean contains(PSAppPFPluginBase pSAppPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppPFPluginBase.isCodeNameDirty();
            }
            case 1: {
                return pSAppPFPluginBase.isCreateDateDirty();
            }
            case 2: {
                return pSAppPFPluginBase.isCreateManDirty();
            }
            case 3: {
                return pSAppPFPluginBase.isMemoDirty();
            }
            case 4: {
                return pSAppPFPluginBase.isPSAppPFPluginIdDirty();
            }
            case 5: {
                return pSAppPFPluginBase.isPSAppPFPluginNameDirty();
            }
            case 6: {
                return pSAppPFPluginBase.isPSSysAppIdDirty();
            }
            case 7: {
                return pSAppPFPluginBase.isPSSysAppNameDirty();
            }
            case 8: {
                return pSAppPFPluginBase.isPSSysPFPluginIdDirty();
            }
            case 9: {
                return pSAppPFPluginBase.isPSSysPFPluginNameDirty();
            }
            case 10: {
                return pSAppPFPluginBase.isUpdateDateDirty();
            }
            case 11: {
                return pSAppPFPluginBase.isUpdateManDirty();
            }
            case 12: {
                return pSAppPFPluginBase.isUserCatDirty();
            }
            case 13: {
                return pSAppPFPluginBase.isUserTagDirty();
            }
            case 14: {
                return pSAppPFPluginBase.isUserTag2Dirty();
            }
            case 15: {
                return pSAppPFPluginBase.isUserTag3Dirty();
            }
            case 16: {
                return pSAppPFPluginBase.isUserTag4Dirty();
            }
            case 17: {
                return pSAppPFPluginBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppPFPluginBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppPFPluginBase pSAppPFPluginBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppPFPluginBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getCodeName()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getPSAppPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapppfpluginid", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getPSAppPFPluginId()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getPSAppPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapppfpluginname", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getPSAppPFPluginName()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getUserCat()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getUserTag()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSAppPFPluginBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppPFPluginBase.getJSONValue((Object)pSAppPFPluginBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppPFPluginBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppPFPluginBase pSAppPFPluginBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppPFPluginBase.getCodeName() != null) {
            object = pSAppPFPluginBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPFPluginBase.getCreateDate() != null) {
            object = pSAppPFPluginBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppPFPluginBase.getCreateMan() != null) {
            object = pSAppPFPluginBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPFPluginBase.getMemo() != null) {
            object = pSAppPFPluginBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppPFPluginBase.getPSAppPFPluginId() != null) {
            object = pSAppPFPluginBase.getPSAppPFPluginId();
            xmlNode.setAttribute(FIELD_PSAPPPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPFPluginBase.getPSAppPFPluginName() != null) {
            object = pSAppPFPluginBase.getPSAppPFPluginName();
            xmlNode.setAttribute(FIELD_PSAPPPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPFPluginBase.getPSSysAppId() != null) {
            object = pSAppPFPluginBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPFPluginBase.getPSSysAppName() != null) {
            object = pSAppPFPluginBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPFPluginBase.getPSSysPFPluginId() != null) {
            object = pSAppPFPluginBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSAppPFPluginBase.getPSSysPFPluginName() != null) {
            object = pSAppPFPluginBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppPFPluginBase.getUpdateDate() != null) {
            object = pSAppPFPluginBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppPFPluginBase.getUpdateMan() != null) {
            object = pSAppPFPluginBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppPFPluginBase.getUserCat() != null) {
            object = pSAppPFPluginBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSAppPFPluginBase.getUserTag() != null) {
            object = pSAppPFPluginBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSAppPFPluginBase.getUserTag2() != null) {
            object = pSAppPFPluginBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSAppPFPluginBase.getUserTag3() != null) {
            object = pSAppPFPluginBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSAppPFPluginBase.getUserTag4() != null) {
            object = pSAppPFPluginBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSAppPFPluginBase.getValidFlag() != null) {
            object = pSAppPFPluginBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppPFPluginBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppPFPluginBase pSAppPFPluginBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppPFPluginBase.isCodeNameDirty() && (bl || pSAppPFPluginBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSAppPFPluginBase.getCodeName());
        }
        if (pSAppPFPluginBase.isCreateDateDirty() && (bl || pSAppPFPluginBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppPFPluginBase.getCreateDate());
        }
        if (pSAppPFPluginBase.isCreateManDirty() && (bl || pSAppPFPluginBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppPFPluginBase.getCreateMan());
        }
        if (pSAppPFPluginBase.isMemoDirty() && (bl || pSAppPFPluginBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppPFPluginBase.getMemo());
        }
        if (pSAppPFPluginBase.isPSAppPFPluginIdDirty() && (bl || pSAppPFPluginBase.getPSAppPFPluginId() != null)) {
            iDataObject.set(FIELD_PSAPPPFPLUGINID, (Object)pSAppPFPluginBase.getPSAppPFPluginId());
        }
        if (pSAppPFPluginBase.isPSAppPFPluginNameDirty() && (bl || pSAppPFPluginBase.getPSAppPFPluginName() != null)) {
            iDataObject.set(FIELD_PSAPPPFPLUGINNAME, (Object)pSAppPFPluginBase.getPSAppPFPluginName());
        }
        if (pSAppPFPluginBase.isPSSysAppIdDirty() && (bl || pSAppPFPluginBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppPFPluginBase.getPSSysAppId());
        }
        if (pSAppPFPluginBase.isPSSysAppNameDirty() && (bl || pSAppPFPluginBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppPFPluginBase.getPSSysAppName());
        }
        if (pSAppPFPluginBase.isPSSysPFPluginIdDirty() && (bl || pSAppPFPluginBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSAppPFPluginBase.getPSSysPFPluginId());
        }
        if (pSAppPFPluginBase.isPSSysPFPluginNameDirty() && (bl || pSAppPFPluginBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSAppPFPluginBase.getPSSysPFPluginName());
        }
        if (pSAppPFPluginBase.isUpdateDateDirty() && (bl || pSAppPFPluginBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppPFPluginBase.getUpdateDate());
        }
        if (pSAppPFPluginBase.isUpdateManDirty() && (bl || pSAppPFPluginBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppPFPluginBase.getUpdateMan());
        }
        if (pSAppPFPluginBase.isUserCatDirty() && (bl || pSAppPFPluginBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSAppPFPluginBase.getUserCat());
        }
        if (pSAppPFPluginBase.isUserTagDirty() && (bl || pSAppPFPluginBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSAppPFPluginBase.getUserTag());
        }
        if (pSAppPFPluginBase.isUserTag2Dirty() && (bl || pSAppPFPluginBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSAppPFPluginBase.getUserTag2());
        }
        if (pSAppPFPluginBase.isUserTag3Dirty() && (bl || pSAppPFPluginBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSAppPFPluginBase.getUserTag3());
        }
        if (pSAppPFPluginBase.isUserTag4Dirty() && (bl || pSAppPFPluginBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSAppPFPluginBase.getUserTag4());
        }
        if (pSAppPFPluginBase.isValidFlagDirty() && (bl || pSAppPFPluginBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppPFPluginBase.getValidFlag());
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
        return PSAppPFPluginBase.remove(this, n);
    }

    private static boolean remove(PSAppPFPluginBase pSAppPFPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppPFPluginBase.resetCodeName();
                return true;
            }
            case 1: {
                pSAppPFPluginBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSAppPFPluginBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSAppPFPluginBase.resetMemo();
                return true;
            }
            case 4: {
                pSAppPFPluginBase.resetPSAppPFPluginId();
                return true;
            }
            case 5: {
                pSAppPFPluginBase.resetPSAppPFPluginName();
                return true;
            }
            case 6: {
                pSAppPFPluginBase.resetPSSysAppId();
                return true;
            }
            case 7: {
                pSAppPFPluginBase.resetPSSysAppName();
                return true;
            }
            case 8: {
                pSAppPFPluginBase.resetPSSysPFPluginId();
                return true;
            }
            case 9: {
                pSAppPFPluginBase.resetPSSysPFPluginName();
                return true;
            }
            case 10: {
                pSAppPFPluginBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSAppPFPluginBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSAppPFPluginBase.resetUserCat();
                return true;
            }
            case 13: {
                pSAppPFPluginBase.resetUserTag();
                return true;
            }
            case 14: {
                pSAppPFPluginBase.resetUserTag2();
                return true;
            }
            case 15: {
                pSAppPFPluginBase.resetUserTag3();
                return true;
            }
            case 16: {
                pSAppPFPluginBase.resetUserTag4();
                return true;
            }
            case 17: {
                pSAppPFPluginBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    private PSAppPFPluginBase getProxyEntity() {
        return this.proxyPSAppPFPluginBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppPFPluginBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppPFPluginBase) {
            this.proxyPSAppPFPluginBase = (PSAppPFPluginBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppPFPluginService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSAPPPFPLUGINID, 4);
        fieldIndexMap.put(FIELD_PSAPPPFPLUGINNAME, 5);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 6);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 7);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 8);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERCAT, 12);
        fieldIndexMap.put(FIELD_USERTAG, 13);
        fieldIndexMap.put(FIELD_USERTAG2, 14);
        fieldIndexMap.put(FIELD_USERTAG3, 15);
        fieldIndexMap.put(FIELD_USERTAG4, 16);
        fieldIndexMap.put(FIELD_VALIDFLAG, 17);
    }
}

