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

public abstract class PSWXMenuFuncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWXMenuFuncBase.class);
    public static final String FIELD_CLICKTAG = "CLICKTAG";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FUNCTYPE = "FUNCTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSWXACCOUNTID = "PSWXACCOUNTID";
    public static final String FIELD_PSWXACCOUNTNAME = "PSWXACCOUNTNAME";
    public static final String FIELD_PSWXENTAPPID = "PSWXENTAPPID";
    public static final String FIELD_PSWXENTAPPNAME = "PSWXENTAPPNAME";
    public static final String FIELD_PSWXMENUFUNCID = "PSWXMENUFUNCID";
    public static final String FIELD_PSWXMENUFUNCNAME = "PSWXMENUFUNCNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VIEWURL = "VIEWURL";
    private static final int INDEX_CLICKTAG = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_FUNCTYPE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSWXACCOUNTID = 6;
    private static final int INDEX_PSWXACCOUNTNAME = 7;
    private static final int INDEX_PSWXENTAPPID = 8;
    private static final int INDEX_PSWXENTAPPNAME = 9;
    private static final int INDEX_PSWXMENUFUNCID = 10;
    private static final int INDEX_PSWXMENUFUNCNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_VIEWURL = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWXMenuFuncBase proxyPSWXMenuFuncBase = null;
    private boolean clicktagDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean functypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pswxaccountidDirtyFlag = false;
    private boolean pswxaccountnameDirtyFlag = false;
    private boolean pswxentappidDirtyFlag = false;
    private boolean pswxentappnameDirtyFlag = false;
    private boolean pswxmenufuncidDirtyFlag = false;
    private boolean pswxmenufuncnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean viewurlDirtyFlag = false;
    @Column(name="clicktag")
    private String clicktag;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="functype")
    private String functype;
    @Column(name="memo")
    private String memo;
    @Column(name="pswxaccountid")
    private String pswxaccountid;
    @Column(name="pswxaccountname")
    private String pswxaccountname;
    @Column(name="pswxentappid")
    private String pswxentappid;
    @Column(name="pswxentappname")
    private String pswxentappname;
    @Column(name="pswxmenufuncid")
    private String pswxmenufuncid;
    @Column(name="pswxmenufuncname")
    private String pswxmenufuncname;
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
    @Column(name="viewurl")
    private String viewurl;
    private Integer objPSWXAccountLock = new Integer(1);
    private PSWXAccount pswxaccount = null;
    private Integer objPSWXEntAppLock = new Integer(1);
    private PSWXEntApp pswxentapp = null;

    public void setClickTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClickTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clicktag = string;
        this.clicktagDirtyFlag = true;
    }

    public String getClickTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClickTag();
        }
        return this.clicktag;
    }

    public boolean isClickTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClickTagDirty();
        }
        return this.clicktagDirtyFlag;
    }

    public void resetClickTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClickTag();
            return;
        }
        this.clicktagDirtyFlag = false;
        this.clicktag = null;
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

    public void setFuncType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.functype = string;
        this.functypeDirtyFlag = true;
    }

    public String getFuncType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncType();
        }
        return this.functype;
    }

    public boolean isFuncTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncTypeDirty();
        }
        return this.functypeDirtyFlag;
    }

    public void resetFuncType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncType();
            return;
        }
        this.functypeDirtyFlag = false;
        this.functype = null;
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

    public void setPSWXMenuFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenuFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxmenufuncid = string;
        this.pswxmenufuncidDirtyFlag = true;
    }

    public String getPSWXMenuFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuFuncId();
        }
        return this.pswxmenufuncid;
    }

    public boolean isPSWXMenuFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenuFuncIdDirty();
        }
        return this.pswxmenufuncidDirtyFlag;
    }

    public void resetPSWXMenuFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenuFuncId();
            return;
        }
        this.pswxmenufuncidDirtyFlag = false;
        this.pswxmenufuncid = null;
    }

    public void setPSWXMenuFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWXMenuFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswxmenufuncname = string;
        this.pswxmenufuncnameDirtyFlag = true;
    }

    public String getPSWXMenuFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWXMenuFuncName();
        }
        return this.pswxmenufuncname;
    }

    public boolean isPSWXMenuFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWXMenuFuncNameDirty();
        }
        return this.pswxmenufuncnameDirtyFlag;
    }

    public void resetPSWXMenuFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWXMenuFuncName();
            return;
        }
        this.pswxmenufuncnameDirtyFlag = false;
        this.pswxmenufuncname = null;
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

    public void setViewURL(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewURL(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewurl = string;
        this.viewurlDirtyFlag = true;
    }

    public String getViewURL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewURL();
        }
        return this.viewurl;
    }

    public boolean isViewURLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewURLDirty();
        }
        return this.viewurlDirtyFlag;
    }

    public void resetViewURL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewURL();
            return;
        }
        this.viewurlDirtyFlag = false;
        this.viewurl = null;
    }

    protected void onReset() {
        PSWXMenuFuncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWXMenuFuncBase pSWXMenuFuncBase) {
        pSWXMenuFuncBase.resetClickTag();
        pSWXMenuFuncBase.resetCodeName();
        pSWXMenuFuncBase.resetCreateDate();
        pSWXMenuFuncBase.resetCreateMan();
        pSWXMenuFuncBase.resetFuncType();
        pSWXMenuFuncBase.resetMemo();
        pSWXMenuFuncBase.resetPSWXAccountId();
        pSWXMenuFuncBase.resetPSWXAccountName();
        pSWXMenuFuncBase.resetPSWXEntAppId();
        pSWXMenuFuncBase.resetPSWXEntAppName();
        pSWXMenuFuncBase.resetPSWXMenuFuncId();
        pSWXMenuFuncBase.resetPSWXMenuFuncName();
        pSWXMenuFuncBase.resetUpdateDate();
        pSWXMenuFuncBase.resetUpdateMan();
        pSWXMenuFuncBase.resetUserCat();
        pSWXMenuFuncBase.resetUserTag();
        pSWXMenuFuncBase.resetUserTag2();
        pSWXMenuFuncBase.resetUserTag3();
        pSWXMenuFuncBase.resetUserTag4();
        pSWXMenuFuncBase.resetViewURL();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isClickTagDirty()) {
            hashMap.put(FIELD_CLICKTAG, this.getClickTag());
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
        if (!bl || this.isFuncTypeDirty()) {
            hashMap.put(FIELD_FUNCTYPE, this.getFuncType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
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
        if (!bl || this.isPSWXMenuFuncIdDirty()) {
            hashMap.put(FIELD_PSWXMENUFUNCID, this.getPSWXMenuFuncId());
        }
        if (!bl || this.isPSWXMenuFuncNameDirty()) {
            hashMap.put(FIELD_PSWXMENUFUNCNAME, this.getPSWXMenuFuncName());
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
        if (!bl || this.isViewURLDirty()) {
            hashMap.put(FIELD_VIEWURL, this.getViewURL());
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
        return PSWXMenuFuncBase.get(this, n);
    }

    private static Object get(PSWXMenuFuncBase pSWXMenuFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXMenuFuncBase.getClickTag();
            }
            case 1: {
                return pSWXMenuFuncBase.getCodeName();
            }
            case 2: {
                return pSWXMenuFuncBase.getCreateDate();
            }
            case 3: {
                return pSWXMenuFuncBase.getCreateMan();
            }
            case 4: {
                return pSWXMenuFuncBase.getFuncType();
            }
            case 5: {
                return pSWXMenuFuncBase.getMemo();
            }
            case 6: {
                return pSWXMenuFuncBase.getPSWXAccountId();
            }
            case 7: {
                return pSWXMenuFuncBase.getPSWXAccountName();
            }
            case 8: {
                return pSWXMenuFuncBase.getPSWXEntAppId();
            }
            case 9: {
                return pSWXMenuFuncBase.getPSWXEntAppName();
            }
            case 10: {
                return pSWXMenuFuncBase.getPSWXMenuFuncId();
            }
            case 11: {
                return pSWXMenuFuncBase.getPSWXMenuFuncName();
            }
            case 12: {
                return pSWXMenuFuncBase.getUpdateDate();
            }
            case 13: {
                return pSWXMenuFuncBase.getUpdateMan();
            }
            case 14: {
                return pSWXMenuFuncBase.getUserCat();
            }
            case 15: {
                return pSWXMenuFuncBase.getUserTag();
            }
            case 16: {
                return pSWXMenuFuncBase.getUserTag2();
            }
            case 17: {
                return pSWXMenuFuncBase.getUserTag3();
            }
            case 18: {
                return pSWXMenuFuncBase.getUserTag4();
            }
            case 19: {
                return pSWXMenuFuncBase.getViewURL();
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
        PSWXMenuFuncBase.set(this, n, object);
    }

    private static void set(PSWXMenuFuncBase pSWXMenuFuncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWXMenuFuncBase.setClickTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWXMenuFuncBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWXMenuFuncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSWXMenuFuncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWXMenuFuncBase.setFuncType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWXMenuFuncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWXMenuFuncBase.setPSWXAccountId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWXMenuFuncBase.setPSWXAccountName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWXMenuFuncBase.setPSWXEntAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWXMenuFuncBase.setPSWXEntAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWXMenuFuncBase.setPSWXMenuFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWXMenuFuncBase.setPSWXMenuFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWXMenuFuncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSWXMenuFuncBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWXMenuFuncBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWXMenuFuncBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWXMenuFuncBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWXMenuFuncBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWXMenuFuncBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWXMenuFuncBase.setViewURL(DataObject.getStringValue((Object)object));
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
        return PSWXMenuFuncBase.isNull(this, n);
    }

    private static boolean isNull(PSWXMenuFuncBase pSWXMenuFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXMenuFuncBase.getClickTag() == null;
            }
            case 1: {
                return pSWXMenuFuncBase.getCodeName() == null;
            }
            case 2: {
                return pSWXMenuFuncBase.getCreateDate() == null;
            }
            case 3: {
                return pSWXMenuFuncBase.getCreateMan() == null;
            }
            case 4: {
                return pSWXMenuFuncBase.getFuncType() == null;
            }
            case 5: {
                return pSWXMenuFuncBase.getMemo() == null;
            }
            case 6: {
                return pSWXMenuFuncBase.getPSWXAccountId() == null;
            }
            case 7: {
                return pSWXMenuFuncBase.getPSWXAccountName() == null;
            }
            case 8: {
                return pSWXMenuFuncBase.getPSWXEntAppId() == null;
            }
            case 9: {
                return pSWXMenuFuncBase.getPSWXEntAppName() == null;
            }
            case 10: {
                return pSWXMenuFuncBase.getPSWXMenuFuncId() == null;
            }
            case 11: {
                return pSWXMenuFuncBase.getPSWXMenuFuncName() == null;
            }
            case 12: {
                return pSWXMenuFuncBase.getUpdateDate() == null;
            }
            case 13: {
                return pSWXMenuFuncBase.getUpdateMan() == null;
            }
            case 14: {
                return pSWXMenuFuncBase.getUserCat() == null;
            }
            case 15: {
                return pSWXMenuFuncBase.getUserTag() == null;
            }
            case 16: {
                return pSWXMenuFuncBase.getUserTag2() == null;
            }
            case 17: {
                return pSWXMenuFuncBase.getUserTag3() == null;
            }
            case 18: {
                return pSWXMenuFuncBase.getUserTag4() == null;
            }
            case 19: {
                return pSWXMenuFuncBase.getViewURL() == null;
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
        return PSWXMenuFuncBase.contains(this, n);
    }

    private static boolean contains(PSWXMenuFuncBase pSWXMenuFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWXMenuFuncBase.isClickTagDirty();
            }
            case 1: {
                return pSWXMenuFuncBase.isCodeNameDirty();
            }
            case 2: {
                return pSWXMenuFuncBase.isCreateDateDirty();
            }
            case 3: {
                return pSWXMenuFuncBase.isCreateManDirty();
            }
            case 4: {
                return pSWXMenuFuncBase.isFuncTypeDirty();
            }
            case 5: {
                return pSWXMenuFuncBase.isMemoDirty();
            }
            case 6: {
                return pSWXMenuFuncBase.isPSWXAccountIdDirty();
            }
            case 7: {
                return pSWXMenuFuncBase.isPSWXAccountNameDirty();
            }
            case 8: {
                return pSWXMenuFuncBase.isPSWXEntAppIdDirty();
            }
            case 9: {
                return pSWXMenuFuncBase.isPSWXEntAppNameDirty();
            }
            case 10: {
                return pSWXMenuFuncBase.isPSWXMenuFuncIdDirty();
            }
            case 11: {
                return pSWXMenuFuncBase.isPSWXMenuFuncNameDirty();
            }
            case 12: {
                return pSWXMenuFuncBase.isUpdateDateDirty();
            }
            case 13: {
                return pSWXMenuFuncBase.isUpdateManDirty();
            }
            case 14: {
                return pSWXMenuFuncBase.isUserCatDirty();
            }
            case 15: {
                return pSWXMenuFuncBase.isUserTagDirty();
            }
            case 16: {
                return pSWXMenuFuncBase.isUserTag2Dirty();
            }
            case 17: {
                return pSWXMenuFuncBase.isUserTag3Dirty();
            }
            case 18: {
                return pSWXMenuFuncBase.isUserTag4Dirty();
            }
            case 19: {
                return pSWXMenuFuncBase.isViewURLDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWXMenuFuncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWXMenuFuncBase pSWXMenuFuncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWXMenuFuncBase.getClickTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clicktag", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getClickTag()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getCodeName()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getFuncType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"functype", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getFuncType()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getMemo()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getPSWXAccountId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxaccountid", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getPSWXAccountId()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getPSWXAccountName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxaccountname", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getPSWXAccountName()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getPSWXEntAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxentappid", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getPSWXEntAppId()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getPSWXEntAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxentappname", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getPSWXEntAppName()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getPSWXMenuFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenufuncid", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getPSWXMenuFuncId()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getPSWXMenuFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswxmenufuncname", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getPSWXMenuFuncName()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSWXMenuFuncBase.getViewURL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewurl", (Object)PSWXMenuFuncBase.getJSONValue((Object)pSWXMenuFuncBase.getViewURL()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWXMenuFuncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWXMenuFuncBase pSWXMenuFuncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWXMenuFuncBase.getClickTag() != null) {
            object = pSWXMenuFuncBase.getClickTag();
            xmlNode.setAttribute(FIELD_CLICKTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSWXMenuFuncBase.getCodeName() != null) {
            object = pSWXMenuFuncBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getCreateDate() != null) {
            object = pSWXMenuFuncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWXMenuFuncBase.getCreateMan() != null) {
            object = pSWXMenuFuncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getFuncType() != null) {
            object = pSWXMenuFuncBase.getFuncType();
            xmlNode.setAttribute(FIELD_FUNCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getMemo() != null) {
            object = pSWXMenuFuncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getPSWXAccountId() != null) {
            object = pSWXMenuFuncBase.getPSWXAccountId();
            xmlNode.setAttribute(FIELD_PSWXACCOUNTID, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getPSWXAccountName() != null) {
            object = pSWXMenuFuncBase.getPSWXAccountName();
            xmlNode.setAttribute(FIELD_PSWXACCOUNTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getPSWXEntAppId() != null) {
            object = pSWXMenuFuncBase.getPSWXEntAppId();
            xmlNode.setAttribute(FIELD_PSWXENTAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getPSWXEntAppName() != null) {
            object = pSWXMenuFuncBase.getPSWXEntAppName();
            xmlNode.setAttribute(FIELD_PSWXENTAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getPSWXMenuFuncId() != null) {
            object = pSWXMenuFuncBase.getPSWXMenuFuncId();
            xmlNode.setAttribute(FIELD_PSWXMENUFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getPSWXMenuFuncName() != null) {
            object = pSWXMenuFuncBase.getPSWXMenuFuncName();
            xmlNode.setAttribute(FIELD_PSWXMENUFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getUpdateDate() != null) {
            object = pSWXMenuFuncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWXMenuFuncBase.getUpdateMan() != null) {
            object = pSWXMenuFuncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getUserCat() != null) {
            object = pSWXMenuFuncBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getUserTag() != null) {
            object = pSWXMenuFuncBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getUserTag2() != null) {
            object = pSWXMenuFuncBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getUserTag3() != null) {
            object = pSWXMenuFuncBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getUserTag4() != null) {
            object = pSWXMenuFuncBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSWXMenuFuncBase.getViewURL() != null) {
            object = pSWXMenuFuncBase.getViewURL();
            xmlNode.setAttribute(FIELD_VIEWURL, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWXMenuFuncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWXMenuFuncBase pSWXMenuFuncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWXMenuFuncBase.isClickTagDirty() && (bl || pSWXMenuFuncBase.getClickTag() != null)) {
            iDataObject.set(FIELD_CLICKTAG, (Object)pSWXMenuFuncBase.getClickTag());
        }
        if (pSWXMenuFuncBase.isCodeNameDirty() && (bl || pSWXMenuFuncBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSWXMenuFuncBase.getCodeName());
        }
        if (pSWXMenuFuncBase.isCreateDateDirty() && (bl || pSWXMenuFuncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWXMenuFuncBase.getCreateDate());
        }
        if (pSWXMenuFuncBase.isCreateManDirty() && (bl || pSWXMenuFuncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWXMenuFuncBase.getCreateMan());
        }
        if (pSWXMenuFuncBase.isFuncTypeDirty() && (bl || pSWXMenuFuncBase.getFuncType() != null)) {
            iDataObject.set(FIELD_FUNCTYPE, (Object)pSWXMenuFuncBase.getFuncType());
        }
        if (pSWXMenuFuncBase.isMemoDirty() && (bl || pSWXMenuFuncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWXMenuFuncBase.getMemo());
        }
        if (pSWXMenuFuncBase.isPSWXAccountIdDirty() && (bl || pSWXMenuFuncBase.getPSWXAccountId() != null)) {
            iDataObject.set(FIELD_PSWXACCOUNTID, (Object)pSWXMenuFuncBase.getPSWXAccountId());
        }
        if (pSWXMenuFuncBase.isPSWXAccountNameDirty() && (bl || pSWXMenuFuncBase.getPSWXAccountName() != null)) {
            iDataObject.set(FIELD_PSWXACCOUNTNAME, (Object)pSWXMenuFuncBase.getPSWXAccountName());
        }
        if (pSWXMenuFuncBase.isPSWXEntAppIdDirty() && (bl || pSWXMenuFuncBase.getPSWXEntAppId() != null)) {
            iDataObject.set(FIELD_PSWXENTAPPID, (Object)pSWXMenuFuncBase.getPSWXEntAppId());
        }
        if (pSWXMenuFuncBase.isPSWXEntAppNameDirty() && (bl || pSWXMenuFuncBase.getPSWXEntAppName() != null)) {
            iDataObject.set(FIELD_PSWXENTAPPNAME, (Object)pSWXMenuFuncBase.getPSWXEntAppName());
        }
        if (pSWXMenuFuncBase.isPSWXMenuFuncIdDirty() && (bl || pSWXMenuFuncBase.getPSWXMenuFuncId() != null)) {
            iDataObject.set(FIELD_PSWXMENUFUNCID, (Object)pSWXMenuFuncBase.getPSWXMenuFuncId());
        }
        if (pSWXMenuFuncBase.isPSWXMenuFuncNameDirty() && (bl || pSWXMenuFuncBase.getPSWXMenuFuncName() != null)) {
            iDataObject.set(FIELD_PSWXMENUFUNCNAME, (Object)pSWXMenuFuncBase.getPSWXMenuFuncName());
        }
        if (pSWXMenuFuncBase.isUpdateDateDirty() && (bl || pSWXMenuFuncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWXMenuFuncBase.getUpdateDate());
        }
        if (pSWXMenuFuncBase.isUpdateManDirty() && (bl || pSWXMenuFuncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWXMenuFuncBase.getUpdateMan());
        }
        if (pSWXMenuFuncBase.isUserCatDirty() && (bl || pSWXMenuFuncBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWXMenuFuncBase.getUserCat());
        }
        if (pSWXMenuFuncBase.isUserTagDirty() && (bl || pSWXMenuFuncBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWXMenuFuncBase.getUserTag());
        }
        if (pSWXMenuFuncBase.isUserTag2Dirty() && (bl || pSWXMenuFuncBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWXMenuFuncBase.getUserTag2());
        }
        if (pSWXMenuFuncBase.isUserTag3Dirty() && (bl || pSWXMenuFuncBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWXMenuFuncBase.getUserTag3());
        }
        if (pSWXMenuFuncBase.isUserTag4Dirty() && (bl || pSWXMenuFuncBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWXMenuFuncBase.getUserTag4());
        }
        if (pSWXMenuFuncBase.isViewURLDirty() && (bl || pSWXMenuFuncBase.getViewURL() != null)) {
            iDataObject.set(FIELD_VIEWURL, (Object)pSWXMenuFuncBase.getViewURL());
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
        return PSWXMenuFuncBase.remove(this, n);
    }

    private static boolean remove(PSWXMenuFuncBase pSWXMenuFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWXMenuFuncBase.resetClickTag();
                return true;
            }
            case 1: {
                pSWXMenuFuncBase.resetCodeName();
                return true;
            }
            case 2: {
                pSWXMenuFuncBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSWXMenuFuncBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSWXMenuFuncBase.resetFuncType();
                return true;
            }
            case 5: {
                pSWXMenuFuncBase.resetMemo();
                return true;
            }
            case 6: {
                pSWXMenuFuncBase.resetPSWXAccountId();
                return true;
            }
            case 7: {
                pSWXMenuFuncBase.resetPSWXAccountName();
                return true;
            }
            case 8: {
                pSWXMenuFuncBase.resetPSWXEntAppId();
                return true;
            }
            case 9: {
                pSWXMenuFuncBase.resetPSWXEntAppName();
                return true;
            }
            case 10: {
                pSWXMenuFuncBase.resetPSWXMenuFuncId();
                return true;
            }
            case 11: {
                pSWXMenuFuncBase.resetPSWXMenuFuncName();
                return true;
            }
            case 12: {
                pSWXMenuFuncBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSWXMenuFuncBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSWXMenuFuncBase.resetUserCat();
                return true;
            }
            case 15: {
                pSWXMenuFuncBase.resetUserTag();
                return true;
            }
            case 16: {
                pSWXMenuFuncBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSWXMenuFuncBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSWXMenuFuncBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSWXMenuFuncBase.resetViewURL();
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

    private PSWXMenuFuncBase getProxyEntity() {
        return this.proxyPSWXMenuFuncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWXMenuFuncBase = null;
        if (iDataObject != null && iDataObject instanceof PSWXMenuFuncBase) {
            this.proxyPSWXMenuFuncBase = (PSWXMenuFuncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuFuncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLICKTAG, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_FUNCTYPE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSWXACCOUNTID, 6);
        fieldIndexMap.put(FIELD_PSWXACCOUNTNAME, 7);
        fieldIndexMap.put(FIELD_PSWXENTAPPID, 8);
        fieldIndexMap.put(FIELD_PSWXENTAPPNAME, 9);
        fieldIndexMap.put(FIELD_PSWXMENUFUNCID, 10);
        fieldIndexMap.put(FIELD_PSWXMENUFUNCNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERCAT, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
        fieldIndexMap.put(FIELD_VIEWURL, 19);
    }
}

