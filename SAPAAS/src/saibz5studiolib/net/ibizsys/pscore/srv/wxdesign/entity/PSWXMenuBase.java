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
package net.ibizsys.pscore.srv.wxdesign.entity;

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
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXAccount;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntApp;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXAccountService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWXMenuBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWXMenuBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MENUMODEL = "MENUMODEL";
    public static final String FIELD_PSWXACCOUNTID = "PSWXACCOUNTID";
    public static final String FIELD_PSWXACCOUNTNAME = "PSWXACCOUNTNAME";
    public static final String FIELD_PSWXENTAPPID = "PSWXENTAPPID";
    public static final String FIELD_PSWXENTAPPNAME = "PSWXENTAPPNAME";
    public static final String FIELD_PSWXMENUID = "PSWXMENUID";
    public static final String FIELD_PSWXMENUNAME = "PSWXMENUNAME";
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
    private static final int INDEX_DEFAULTFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MENUMODEL = 5;
    private static final int INDEX_PSWXACCOUNTID = 6;
    private static final int INDEX_PSWXACCOUNTNAME = 7;
    private static final int INDEX_PSWXENTAPPID = 8;
    private static final int INDEX_PSWXENTAPPNAME = 9;
    private static final int INDEX_PSWXMENUID = 10;
    private static final int INDEX_PSWXMENUNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWXMenuBase proxyPSWXMenuBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean menumodelDirtyFlag = false;
    private boolean pswxaccountidDirtyFlag = false;
    private boolean pswxaccountnameDirtyFlag = false;
    private boolean pswxentappidDirtyFlag = false;
    private boolean pswxentappnameDirtyFlag = false;
    private boolean pswxmenuidDirtyFlag = false;
    private boolean pswxmenunameDirtyFlag = false;
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
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="memo")
    private String memo;
    @Column(name="menumodel")
    private String menumodel;
    @Column(name="pswxaccountid")
    private String pswxaccountid;
    @Column(name="pswxaccountname")
    private String pswxaccountname;
    @Column(name="pswxentappid")
    private String pswxentappid;
    @Column(name="pswxentappname")
    private String pswxentappname;
    @Column(name="pswxmenuid")
    private String pswxmenuid;
    @Column(name="pswxmenuname")
    private String pswxmenuname;
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
    private Integer objPSWXAccountLock = new Integer(1);
    private PSWXAccount pswxaccount = null;
    private Integer objPSWXEntAppLock = new Integer(1);
    private PSWXEntApp pswxentapp = null;

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

    public void setMenuModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMenuModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.menumodel = string;
        this.menumodelDirtyFlag = true;
    }

    public String getMenuModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMenuModel();
        }
        return this.menumodel;
    }

    public boolean isMenuModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMenuModelDirty();
        }
        return this.menumodelDirtyFlag;
    }

    public void resetMenuModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMenuModel();
            return;
        }
        this.menumodelDirtyFlag = false;
        this.menumodel = null;
    }

    public void setPSWXAccountId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXAccountId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxaccountid = string;
        this.pswxaccountidDirtyFlag = true;
    }

    public String getPSWXAccountId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXAccountId();
        }
        return this.pswxaccountid;
    }

    public boolean isPSWXAccountIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXAccountIdDirty();
        }
        return this.pswxaccountidDirtyFlag;
    }

    public void resetPSWXAccountId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXAccountId();
            return;
        }
        this.pswxaccountidDirtyFlag = false;
        this.pswxaccountid = null;
    }

    public void setPSWXAccountName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXAccountName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxaccountname = string;
        this.pswxaccountnameDirtyFlag = true;
    }

    public String getPSWXAccountName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXAccountName();
        }
        return this.pswxaccountname;
    }

    public boolean isPSWXAccountNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXAccountNameDirty();
        }
        return this.pswxaccountnameDirtyFlag;
    }

    public void resetPSWXAccountName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXAccountName();
            return;
        }
        this.pswxaccountnameDirtyFlag = false;
        this.pswxaccountname = null;
    }

    public void setPSWXEntAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXEntAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxentappid = string;
        this.pswxentappidDirtyFlag = true;
    }

    public String getPSWXEntAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXEntAppId();
        }
        return this.pswxentappid;
    }

    public boolean isPSWXEntAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXEntAppIdDirty();
        }
        return this.pswxentappidDirtyFlag;
    }

    public void resetPSWXEntAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXEntAppId();
            return;
        }
        this.pswxentappidDirtyFlag = false;
        this.pswxentappid = null;
    }

    public void setPSWXEntAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXEntAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxentappname = string;
        this.pswxentappnameDirtyFlag = true;
    }

    public String getPSWXEntAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXEntAppName();
        }
        return this.pswxentappname;
    }

    public boolean isPSWXEntAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXEntAppNameDirty();
        }
        return this.pswxentappnameDirtyFlag;
    }

    public void resetPSWXEntAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXEntAppName();
            return;
        }
        this.pswxentappnameDirtyFlag = false;
        this.pswxentappname = null;
    }

    public void setPSWXMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxmenuid = string;
        this.pswxmenuidDirtyFlag = true;
    }

    public String getPSWXMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuId();
        }
        return this.pswxmenuid;
    }

    public boolean isPSWXMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenuIdDirty();
        }
        return this.pswxmenuidDirtyFlag;
    }

    public void resetPSWXMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenuId();
            return;
        }
        this.pswxmenuidDirtyFlag = false;
        this.pswxmenuid = null;
    }

    public void setPSWXMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxmenuname = string;
        this.pswxmenunameDirtyFlag = true;
    }

    public String getPSWXMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuName();
        }
        return this.pswxmenuname;
    }

    public boolean isPSWXMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenuNameDirty();
        }
        return this.pswxmenunameDirtyFlag;
    }

    public void resetPSWXMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenuName();
            return;
        }
        this.pswxmenunameDirtyFlag = false;
        this.pswxmenuname = null;
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
        PSWXMenuBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWXMenuBase pSWXMenuBase) {
        pSWXMenuBase.resetCodeName();
        pSWXMenuBase.resetCreateDate();
        pSWXMenuBase.resetCreateMan();
        pSWXMenuBase.resetDefaultFlag();
        pSWXMenuBase.resetMemo();
        pSWXMenuBase.resetMenuModel();
        pSWXMenuBase.resetPSWXAccountId();
        pSWXMenuBase.resetPSWXAccountName();
        pSWXMenuBase.resetPSWXEntAppId();
        pSWXMenuBase.resetPSWXEntAppName();
        pSWXMenuBase.resetPSWXMenuId();
        pSWXMenuBase.resetPSWXMenuName();
        pSWXMenuBase.resetUpdateDate();
        pSWXMenuBase.resetUpdateMan();
        pSWXMenuBase.resetUserCat();
        pSWXMenuBase.resetUserTag();
        pSWXMenuBase.resetUserTag2();
        pSWXMenuBase.resetUserTag3();
        pSWXMenuBase.resetUserTag4();
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
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMenuModelDirty()) {
            hashMap.put(FIELD_MENUMODEL, this.getMenuModel());
        }
        if (!bl || this.isPSWXAccountIdDirty()) {
            hashMap.put(FIELD_PSWXACCOUNTID, this.getPSWXAccountId());
        }
        if (!bl || this.isPSWXAccountNameDirty()) {
            hashMap.put(FIELD_PSWXACCOUNTNAME, this.getPSWXAccountName());
        }
        if (!bl || this.isPSWXEntAppIdDirty()) {
            hashMap.put(FIELD_PSWXENTAPPID, this.getPSWXEntAppId());
        }
        if (!bl || this.isPSWXEntAppNameDirty()) {
            hashMap.put(FIELD_PSWXENTAPPNAME, this.getPSWXEntAppName());
        }
        if (!bl || this.isPSWXMenuIdDirty()) {
            hashMap.put(FIELD_PSWXMENUID, this.getPSWXMenuId());
        }
        if (!bl || this.isPSWXMenuNameDirty()) {
            hashMap.put(FIELD_PSWXMENUNAME, this.getPSWXMenuName());
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
        return PSWXMenuBase.get(this, n);
    }

    private static Object get(PSWXMenuBase pSWXMenuBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXMenuBase.getCodeName();
            }
            case 1: {
                return pSWXMenuBase.getCreateDate();
            }
            case 2: {
                return pSWXMenuBase.getCreateMan();
            }
            case 3: {
                return pSWXMenuBase.getDefaultFlag();
            }
            case 4: {
                return pSWXMenuBase.getMemo();
            }
            case 5: {
                return pSWXMenuBase.getMenuModel();
            }
            case 6: {
                return pSWXMenuBase.getPSWXAccountId();
            }
            case 7: {
                return pSWXMenuBase.getPSWXAccountName();
            }
            case 8: {
                return pSWXMenuBase.getPSWXEntAppId();
            }
            case 9: {
                return pSWXMenuBase.getPSWXEntAppName();
            }
            case 10: {
                return pSWXMenuBase.getPSWXMenuId();
            }
            case 11: {
                return pSWXMenuBase.getPSWXMenuName();
            }
            case 12: {
                return pSWXMenuBase.getUpdateDate();
            }
            case 13: {
                return pSWXMenuBase.getUpdateMan();
            }
            case 14: {
                return pSWXMenuBase.getUserCat();
            }
            case 15: {
                return pSWXMenuBase.getUserTag();
            }
            case 16: {
                return pSWXMenuBase.getUserTag2();
            }
            case 17: {
                return pSWXMenuBase.getUserTag3();
            }
            case 18: {
                return pSWXMenuBase.getUserTag4();
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
        PSWXMenuBase.set(this, n, object);
    }

    private static void set(PSWXMenuBase pSWXMenuBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWXMenuBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWXMenuBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSWXMenuBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWXMenuBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSWXMenuBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWXMenuBase.setMenuModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWXMenuBase.setPSWXAccountId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWXMenuBase.setPSWXAccountName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWXMenuBase.setPSWXEntAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWXMenuBase.setPSWXEntAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWXMenuBase.setPSWXMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWXMenuBase.setPSWXMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWXMenuBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSWXMenuBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWXMenuBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWXMenuBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWXMenuBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWXMenuBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWXMenuBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSWXMenuBase.isNull(this, n);
    }

    private static boolean isNull(PSWXMenuBase pSWXMenuBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXMenuBase.getCodeName() == null;
            }
            case 1: {
                return pSWXMenuBase.getCreateDate() == null;
            }
            case 2: {
                return pSWXMenuBase.getCreateMan() == null;
            }
            case 3: {
                return pSWXMenuBase.getDefaultFlag() == null;
            }
            case 4: {
                return pSWXMenuBase.getMemo() == null;
            }
            case 5: {
                return pSWXMenuBase.getMenuModel() == null;
            }
            case 6: {
                return pSWXMenuBase.getPSWXAccountId() == null;
            }
            case 7: {
                return pSWXMenuBase.getPSWXAccountName() == null;
            }
            case 8: {
                return pSWXMenuBase.getPSWXEntAppId() == null;
            }
            case 9: {
                return pSWXMenuBase.getPSWXEntAppName() == null;
            }
            case 10: {
                return pSWXMenuBase.getPSWXMenuId() == null;
            }
            case 11: {
                return pSWXMenuBase.getPSWXMenuName() == null;
            }
            case 12: {
                return pSWXMenuBase.getUpdateDate() == null;
            }
            case 13: {
                return pSWXMenuBase.getUpdateMan() == null;
            }
            case 14: {
                return pSWXMenuBase.getUserCat() == null;
            }
            case 15: {
                return pSWXMenuBase.getUserTag() == null;
            }
            case 16: {
                return pSWXMenuBase.getUserTag2() == null;
            }
            case 17: {
                return pSWXMenuBase.getUserTag3() == null;
            }
            case 18: {
                return pSWXMenuBase.getUserTag4() == null;
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
        return PSWXMenuBase.contains(this, n);
    }

    private static boolean contains(PSWXMenuBase pSWXMenuBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXMenuBase.isCodeNameDirty();
            }
            case 1: {
                return pSWXMenuBase.isCreateDateDirty();
            }
            case 2: {
                return pSWXMenuBase.isCreateManDirty();
            }
            case 3: {
                return pSWXMenuBase.isDefaultFlagDirty();
            }
            case 4: {
                return pSWXMenuBase.isMemoDirty();
            }
            case 5: {
                return pSWXMenuBase.isMenuModelDirty();
            }
            case 6: {
                return pSWXMenuBase.isPSWXAccountIdDirty();
            }
            case 7: {
                return pSWXMenuBase.isPSWXAccountNameDirty();
            }
            case 8: {
                return pSWXMenuBase.isPSWXEntAppIdDirty();
            }
            case 9: {
                return pSWXMenuBase.isPSWXEntAppNameDirty();
            }
            case 10: {
                return pSWXMenuBase.isPSWXMenuIdDirty();
            }
            case 11: {
                return pSWXMenuBase.isPSWXMenuNameDirty();
            }
            case 12: {
                return pSWXMenuBase.isUpdateDateDirty();
            }
            case 13: {
                return pSWXMenuBase.isUpdateManDirty();
            }
            case 14: {
                return pSWXMenuBase.isUserCatDirty();
            }
            case 15: {
                return pSWXMenuBase.isUserTagDirty();
            }
            case 16: {
                return pSWXMenuBase.isUserTag2Dirty();
            }
            case 17: {
                return pSWXMenuBase.isUserTag3Dirty();
            }
            case 18: {
                return pSWXMenuBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWXMenuBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWXMenuBase pSWXMenuBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWXMenuBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getCodeName()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getMemo()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getMenuModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"menumodel", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getMenuModel()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getPSWXAccountId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxaccountid", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getPSWXAccountId()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getPSWXAccountName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxaccountname", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getPSWXAccountName()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getPSWXEntAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxentappid", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getPSWXEntAppId()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getPSWXEntAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxentappname", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getPSWXEntAppName()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getPSWXMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenuid", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getPSWXMenuId()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getPSWXMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenuname", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getPSWXMenuName()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWXMenuBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWXMenuBase.getJSONValue((Object)pSWXMenuBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWXMenuBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWXMenuBase pSWXMenuBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWXMenuBase.getCodeName() != null) {
            object = pSWXMenuBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuBase.getCreateDate() != null) {
            object = pSWXMenuBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWXMenuBase.getCreateMan() != null) {
            object = pSWXMenuBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuBase.getDefaultFlag() != null) {
            object = pSWXMenuBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWXMenuBase.getMemo() != null) {
            object = pSWXMenuBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuBase.getMenuModel() != null) {
            object = pSWXMenuBase.getMenuModel();
            xmlNode.setAttribute(FIELD_MENUMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuBase.getPSWXAccountId() != null) {
            object = pSWXMenuBase.getPSWXAccountId();
            xmlNode.setAttribute(FIELD_PSWXACCOUNTID, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuBase.getPSWXAccountName() != null) {
            object = pSWXMenuBase.getPSWXAccountName();
            xmlNode.setAttribute(FIELD_PSWXACCOUNTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuBase.getPSWXEntAppId() != null) {
            object = pSWXMenuBase.getPSWXEntAppId();
            xmlNode.setAttribute(FIELD_PSWXENTAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuBase.getPSWXEntAppName() != null) {
            object = pSWXMenuBase.getPSWXEntAppName();
            xmlNode.setAttribute(FIELD_PSWXENTAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuBase.getPSWXMenuId() != null) {
            object = pSWXMenuBase.getPSWXMenuId();
            xmlNode.setAttribute(FIELD_PSWXMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuBase.getPSWXMenuName() != null) {
            object = pSWXMenuBase.getPSWXMenuName();
            xmlNode.setAttribute(FIELD_PSWXMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuBase.getUpdateDate() != null) {
            object = pSWXMenuBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWXMenuBase.getUpdateMan() != null) {
            object = pSWXMenuBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuBase.getUserCat() != null) {
            object = pSWXMenuBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuBase.getUserTag() != null) {
            object = pSWXMenuBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuBase.getUserTag2() != null) {
            object = pSWXMenuBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuBase.getUserTag3() != null) {
            object = pSWXMenuBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuBase.getUserTag4() != null) {
            object = pSWXMenuBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWXMenuBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWXMenuBase pSWXMenuBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWXMenuBase.isCodeNameDirty() && (bl || pSWXMenuBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSWXMenuBase.getCodeName());
        }
        if (pSWXMenuBase.isCreateDateDirty() && (bl || pSWXMenuBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWXMenuBase.getCreateDate());
        }
        if (pSWXMenuBase.isCreateManDirty() && (bl || pSWXMenuBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWXMenuBase.getCreateMan());
        }
        if (pSWXMenuBase.isDefaultFlagDirty() && (bl || pSWXMenuBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSWXMenuBase.getDefaultFlag());
        }
        if (pSWXMenuBase.isMemoDirty() && (bl || pSWXMenuBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWXMenuBase.getMemo());
        }
        if (pSWXMenuBase.isMenuModelDirty() && (bl || pSWXMenuBase.getMenuModel() != null)) {
            iDataObject.set(FIELD_MENUMODEL, (Object)pSWXMenuBase.getMenuModel());
        }
        if (pSWXMenuBase.isPSWXAccountIdDirty() && (bl || pSWXMenuBase.getPSWXAccountId() != null)) {
            iDataObject.set(FIELD_PSWXACCOUNTID, (Object)pSWXMenuBase.getPSWXAccountId());
        }
        if (pSWXMenuBase.isPSWXAccountNameDirty() && (bl || pSWXMenuBase.getPSWXAccountName() != null)) {
            iDataObject.set(FIELD_PSWXACCOUNTNAME, (Object)pSWXMenuBase.getPSWXAccountName());
        }
        if (pSWXMenuBase.isPSWXEntAppIdDirty() && (bl || pSWXMenuBase.getPSWXEntAppId() != null)) {
            iDataObject.set(FIELD_PSWXENTAPPID, (Object)pSWXMenuBase.getPSWXEntAppId());
        }
        if (pSWXMenuBase.isPSWXEntAppNameDirty() && (bl || pSWXMenuBase.getPSWXEntAppName() != null)) {
            iDataObject.set(FIELD_PSWXENTAPPNAME, (Object)pSWXMenuBase.getPSWXEntAppName());
        }
        if (pSWXMenuBase.isPSWXMenuIdDirty() && (bl || pSWXMenuBase.getPSWXMenuId() != null)) {
            iDataObject.set(FIELD_PSWXMENUID, (Object)pSWXMenuBase.getPSWXMenuId());
        }
        if (pSWXMenuBase.isPSWXMenuNameDirty() && (bl || pSWXMenuBase.getPSWXMenuName() != null)) {
            iDataObject.set(FIELD_PSWXMENUNAME, (Object)pSWXMenuBase.getPSWXMenuName());
        }
        if (pSWXMenuBase.isUpdateDateDirty() && (bl || pSWXMenuBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWXMenuBase.getUpdateDate());
        }
        if (pSWXMenuBase.isUpdateManDirty() && (bl || pSWXMenuBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWXMenuBase.getUpdateMan());
        }
        if (pSWXMenuBase.isUserCatDirty() && (bl || pSWXMenuBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWXMenuBase.getUserCat());
        }
        if (pSWXMenuBase.isUserTagDirty() && (bl || pSWXMenuBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWXMenuBase.getUserTag());
        }
        if (pSWXMenuBase.isUserTag2Dirty() && (bl || pSWXMenuBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWXMenuBase.getUserTag2());
        }
        if (pSWXMenuBase.isUserTag3Dirty() && (bl || pSWXMenuBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWXMenuBase.getUserTag3());
        }
        if (pSWXMenuBase.isUserTag4Dirty() && (bl || pSWXMenuBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWXMenuBase.getUserTag4());
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
        return PSWXMenuBase.remove(this, n);
    }

    private static boolean remove(PSWXMenuBase pSWXMenuBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWXMenuBase.resetCodeName();
                return true;
            }
            case 1: {
                pSWXMenuBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSWXMenuBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSWXMenuBase.resetDefaultFlag();
                return true;
            }
            case 4: {
                pSWXMenuBase.resetMemo();
                return true;
            }
            case 5: {
                pSWXMenuBase.resetMenuModel();
                return true;
            }
            case 6: {
                pSWXMenuBase.resetPSWXAccountId();
                return true;
            }
            case 7: {
                pSWXMenuBase.resetPSWXAccountName();
                return true;
            }
            case 8: {
                pSWXMenuBase.resetPSWXEntAppId();
                return true;
            }
            case 9: {
                pSWXMenuBase.resetPSWXEntAppName();
                return true;
            }
            case 10: {
                pSWXMenuBase.resetPSWXMenuId();
                return true;
            }
            case 11: {
                pSWXMenuBase.resetPSWXMenuName();
                return true;
            }
            case 12: {
                pSWXMenuBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSWXMenuBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSWXMenuBase.resetUserCat();
                return true;
            }
            case 15: {
                pSWXMenuBase.resetUserTag();
                return true;
            }
            case 16: {
                pSWXMenuBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSWXMenuBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSWXMenuBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWXAccount getPSWXAccount() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXAccount();
        }
        if (this.getPSWXAccountId() == null) {
            return null;
        }
        Integer n = this.objPSWXAccountLock;
        synchronized (n) {
            if (this.pswxaccount != null && DataTypeHelper.compare((int)25, (Object)this.getPSWXAccountId(), (Object)this.pswxaccount.getPSWXAccountId()) != 0L) {
                this.pswxaccount = null;
            }
            if (this.pswxaccount == null) {
                PSWXAccount pSWXAccount = new PSWXAccount();
                pSWXAccount.setPSWXAccountId(this.getPSWXAccountId());
                PSWXAccountService pSWXAccountService = (PSWXAccountService)ServiceGlobal.getService(PSWXAccountService.class, (SessionFactory)this.getSessionFactory());
                pSWXAccountService.autoGet(pSWXAccount);
                this.pswxaccount = pSWXAccount;
            }
            return this.pswxaccount;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWXEntApp getPSWXEntApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXEntApp();
        }
        if (this.getPSWXEntAppId() == null) {
            return null;
        }
        Integer n = this.objPSWXEntAppLock;
        synchronized (n) {
            if (this.pswxentapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSWXEntAppId(), (Object)this.pswxentapp.getPSWXEntAppId()) != 0L) {
                this.pswxentapp = null;
            }
            if (this.pswxentapp == null) {
                PSWXEntApp pSWXEntApp = new PSWXEntApp();
                pSWXEntApp.setPSWXEntAppId(this.getPSWXEntAppId());
                PSWXEntAppService pSWXEntAppService = (PSWXEntAppService)ServiceGlobal.getService(PSWXEntAppService.class, (SessionFactory)this.getSessionFactory());
                pSWXEntAppService.autoGet(pSWXEntApp);
                this.pswxentapp = pSWXEntApp;
            }
            return this.pswxentapp;
        }
    }

    private PSWXMenuBase getProxyEntity() {
        return this.proxyPSWXMenuBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWXMenuBase = null;
        if (iDataObject != null && iDataObject instanceof PSWXMenuBase) {
            this.proxyPSWXMenuBase = (PSWXMenuBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MENUMODEL, 5);
        fieldIndexMap.put(FIELD_PSWXACCOUNTID, 6);
        fieldIndexMap.put(FIELD_PSWXACCOUNTNAME, 7);
        fieldIndexMap.put(FIELD_PSWXENTAPPID, 8);
        fieldIndexMap.put(FIELD_PSWXENTAPPNAME, 9);
        fieldIndexMap.put(FIELD_PSWXMENUID, 10);
        fieldIndexMap.put(FIELD_PSWXMENUNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERCAT, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
    }
}

