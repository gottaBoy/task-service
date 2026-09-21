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
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlMsgItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCtrlMsgItemBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CONTENTPSLANRESID = "CONTENTPSLANRESID";
    public static final String FIELD_CONTENTPSLANRESNAME = "CONTENTPSLANRESNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String FIELD_PSCTRLMSGITEMID = "PSCTRLMSGITEMID";
    public static final String FIELD_PSCTRLMSGITEMNAME = "PSCTRLMSGITEMNAME";
    public static final String FIELD_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String FIELD_TIMEOUT = "TIMEOUT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CONTENTPSLANRESID = 1;
    private static final int INDEX_CONTENTPSLANRESNAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSCTRLMSGID = 6;
    private static final int INDEX_PSCTRLMSGITEMID = 7;
    private static final int INDEX_PSCTRLMSGITEMNAME = 8;
    private static final int INDEX_PSCTRLMSGNAME = 9;
    private static final int INDEX_TIMEOUT = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCAT = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final int INDEX_USERTAG3 = 16;
    private static final int INDEX_USERTAG4 = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCtrlMsgItemBase proxyPSCtrlMsgItemBase = null;
    private boolean contentDirtyFlag = false;
    private boolean contentpslanresidDirtyFlag = false;
    private boolean contentpslanresnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psctrlmsgidDirtyFlag = false;
    private boolean psctrlmsgitemidDirtyFlag = false;
    private boolean psctrlmsgitemnameDirtyFlag = false;
    private boolean psctrlmsgnameDirtyFlag = false;
    private boolean timeoutDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
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
    @Column(name="memo")
    private String memo;
    @Column(name="psctrlmsgid")
    private String psctrlmsgid;
    @Column(name="psctrlmsgitemid")
    private String psctrlmsgitemid;
    @Column(name="psctrlmsgitemname")
    private String psctrlmsgitemname;
    @Column(name="psctrlmsgname")
    private String psctrlmsgname;
    @Column(name="timeout")
    private Integer timeout;
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
    private Integer objPSCtrlMsgLock = new Integer(1);
    private PSCtrlMsg psctrlmsg = null;
    private Integer objContentPSLanResLock = new Integer(1);
    private PSLanguageRes contentpslanres = null;

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

    public void setPSCtrlMsgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgid = string;
        this.psctrlmsgidDirtyFlag = true;
    }

    public String getPSCtrlMsgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgId();
        }
        return this.psctrlmsgid;
    }

    public boolean isPSCtrlMsgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgIdDirty();
        }
        return this.psctrlmsgidDirtyFlag;
    }

    public void resetPSCtrlMsgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgId();
            return;
        }
        this.psctrlmsgidDirtyFlag = false;
        this.psctrlmsgid = null;
    }

    public void setPSCtrlMsgItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgitemid = string;
        this.psctrlmsgitemidDirtyFlag = true;
    }

    public String getPSCtrlMsgItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgItemId();
        }
        return this.psctrlmsgitemid;
    }

    public boolean isPSCtrlMsgItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgItemIdDirty();
        }
        return this.psctrlmsgitemidDirtyFlag;
    }

    public void resetPSCtrlMsgItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgItemId();
            return;
        }
        this.psctrlmsgitemidDirtyFlag = false;
        this.psctrlmsgitemid = null;
    }

    public void setPSCtrlMsgItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgitemname = string;
        this.psctrlmsgitemnameDirtyFlag = true;
    }

    public String getPSCtrlMsgItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgItemName();
        }
        return this.psctrlmsgitemname;
    }

    public boolean isPSCtrlMsgItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgItemNameDirty();
        }
        return this.psctrlmsgitemnameDirtyFlag;
    }

    public void resetPSCtrlMsgItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgItemName();
            return;
        }
        this.psctrlmsgitemnameDirtyFlag = false;
        this.psctrlmsgitemname = null;
    }

    public void setPSCtrlMsgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgname = string;
        this.psctrlmsgnameDirtyFlag = true;
    }

    public String getPSCtrlMsgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgName();
        }
        return this.psctrlmsgname;
    }

    public boolean isPSCtrlMsgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgNameDirty();
        }
        return this.psctrlmsgnameDirtyFlag;
    }

    public void resetPSCtrlMsgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgName();
            return;
        }
        this.psctrlmsgnameDirtyFlag = false;
        this.psctrlmsgname = null;
    }

    public void setTimeout(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeout(n);
            return;
        }
        this.timeout = n;
        this.timeoutDirtyFlag = true;
    }

    public Integer getTimeout() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeout();
        }
        return this.timeout;
    }

    public boolean isTimeoutDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeoutDirty();
        }
        return this.timeoutDirtyFlag;
    }

    public void resetTimeout() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeout();
            return;
        }
        this.timeoutDirtyFlag = false;
        this.timeout = null;
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
        PSCtrlMsgItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCtrlMsgItemBase pSCtrlMsgItemBase) {
        pSCtrlMsgItemBase.resetContent();
        pSCtrlMsgItemBase.resetContentPSLanResId();
        pSCtrlMsgItemBase.resetContentPSLanResName();
        pSCtrlMsgItemBase.resetCreateDate();
        pSCtrlMsgItemBase.resetCreateMan();
        pSCtrlMsgItemBase.resetMemo();
        pSCtrlMsgItemBase.resetPSCtrlMsgId();
        pSCtrlMsgItemBase.resetPSCtrlMsgItemId();
        pSCtrlMsgItemBase.resetPSCtrlMsgItemName();
        pSCtrlMsgItemBase.resetPSCtrlMsgName();
        pSCtrlMsgItemBase.resetTimeout();
        pSCtrlMsgItemBase.resetUpdateDate();
        pSCtrlMsgItemBase.resetUpdateMan();
        pSCtrlMsgItemBase.resetUserCat();
        pSCtrlMsgItemBase.resetUserTag();
        pSCtrlMsgItemBase.resetUserTag2();
        pSCtrlMsgItemBase.resetUserTag3();
        pSCtrlMsgItemBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCtrlMsgIdDirty()) {
            hashMap.put(FIELD_PSCTRLMSGID, this.getPSCtrlMsgId());
        }
        if (!bl || this.isPSCtrlMsgItemIdDirty()) {
            hashMap.put(FIELD_PSCTRLMSGITEMID, this.getPSCtrlMsgItemId());
        }
        if (!bl || this.isPSCtrlMsgItemNameDirty()) {
            hashMap.put(FIELD_PSCTRLMSGITEMNAME, this.getPSCtrlMsgItemName());
        }
        if (!bl || this.isPSCtrlMsgNameDirty()) {
            hashMap.put(FIELD_PSCTRLMSGNAME, this.getPSCtrlMsgName());
        }
        if (!bl || this.isTimeoutDirty()) {
            hashMap.put(FIELD_TIMEOUT, this.getTimeout());
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
        return PSCtrlMsgItemBase.get(this, n);
    }

    private static Object get(PSCtrlMsgItemBase pSCtrlMsgItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlMsgItemBase.getContent();
            }
            case 1: {
                return pSCtrlMsgItemBase.getContentPSLanResId();
            }
            case 2: {
                return pSCtrlMsgItemBase.getContentPSLanResName();
            }
            case 3: {
                return pSCtrlMsgItemBase.getCreateDate();
            }
            case 4: {
                return pSCtrlMsgItemBase.getCreateMan();
            }
            case 5: {
                return pSCtrlMsgItemBase.getMemo();
            }
            case 6: {
                return pSCtrlMsgItemBase.getPSCtrlMsgId();
            }
            case 7: {
                return pSCtrlMsgItemBase.getPSCtrlMsgItemId();
            }
            case 8: {
                return pSCtrlMsgItemBase.getPSCtrlMsgItemName();
            }
            case 9: {
                return pSCtrlMsgItemBase.getPSCtrlMsgName();
            }
            case 10: {
                return pSCtrlMsgItemBase.getTimeout();
            }
            case 11: {
                return pSCtrlMsgItemBase.getUpdateDate();
            }
            case 12: {
                return pSCtrlMsgItemBase.getUpdateMan();
            }
            case 13: {
                return pSCtrlMsgItemBase.getUserCat();
            }
            case 14: {
                return pSCtrlMsgItemBase.getUserTag();
            }
            case 15: {
                return pSCtrlMsgItemBase.getUserTag2();
            }
            case 16: {
                return pSCtrlMsgItemBase.getUserTag3();
            }
            case 17: {
                return pSCtrlMsgItemBase.getUserTag4();
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
        PSCtrlMsgItemBase.set(this, n, object);
    }

    private static void set(PSCtrlMsgItemBase pSCtrlMsgItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlMsgItemBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCtrlMsgItemBase.setContentPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCtrlMsgItemBase.setContentPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCtrlMsgItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSCtrlMsgItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCtrlMsgItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCtrlMsgItemBase.setPSCtrlMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCtrlMsgItemBase.setPSCtrlMsgItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCtrlMsgItemBase.setPSCtrlMsgItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCtrlMsgItemBase.setPSCtrlMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCtrlMsgItemBase.setTimeout(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSCtrlMsgItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSCtrlMsgItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCtrlMsgItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSCtrlMsgItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSCtrlMsgItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSCtrlMsgItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSCtrlMsgItemBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSCtrlMsgItemBase.isNull(this, n);
    }

    private static boolean isNull(PSCtrlMsgItemBase pSCtrlMsgItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlMsgItemBase.getContent() == null;
            }
            case 1: {
                return pSCtrlMsgItemBase.getContentPSLanResId() == null;
            }
            case 2: {
                return pSCtrlMsgItemBase.getContentPSLanResName() == null;
            }
            case 3: {
                return pSCtrlMsgItemBase.getCreateDate() == null;
            }
            case 4: {
                return pSCtrlMsgItemBase.getCreateMan() == null;
            }
            case 5: {
                return pSCtrlMsgItemBase.getMemo() == null;
            }
            case 6: {
                return pSCtrlMsgItemBase.getPSCtrlMsgId() == null;
            }
            case 7: {
                return pSCtrlMsgItemBase.getPSCtrlMsgItemId() == null;
            }
            case 8: {
                return pSCtrlMsgItemBase.getPSCtrlMsgItemName() == null;
            }
            case 9: {
                return pSCtrlMsgItemBase.getPSCtrlMsgName() == null;
            }
            case 10: {
                return pSCtrlMsgItemBase.getTimeout() == null;
            }
            case 11: {
                return pSCtrlMsgItemBase.getUpdateDate() == null;
            }
            case 12: {
                return pSCtrlMsgItemBase.getUpdateMan() == null;
            }
            case 13: {
                return pSCtrlMsgItemBase.getUserCat() == null;
            }
            case 14: {
                return pSCtrlMsgItemBase.getUserTag() == null;
            }
            case 15: {
                return pSCtrlMsgItemBase.getUserTag2() == null;
            }
            case 16: {
                return pSCtrlMsgItemBase.getUserTag3() == null;
            }
            case 17: {
                return pSCtrlMsgItemBase.getUserTag4() == null;
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
        return PSCtrlMsgItemBase.contains(this, n);
    }

    private static boolean contains(PSCtrlMsgItemBase pSCtrlMsgItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlMsgItemBase.isContentDirty();
            }
            case 1: {
                return pSCtrlMsgItemBase.isContentPSLanResIdDirty();
            }
            case 2: {
                return pSCtrlMsgItemBase.isContentPSLanResNameDirty();
            }
            case 3: {
                return pSCtrlMsgItemBase.isCreateDateDirty();
            }
            case 4: {
                return pSCtrlMsgItemBase.isCreateManDirty();
            }
            case 5: {
                return pSCtrlMsgItemBase.isMemoDirty();
            }
            case 6: {
                return pSCtrlMsgItemBase.isPSCtrlMsgIdDirty();
            }
            case 7: {
                return pSCtrlMsgItemBase.isPSCtrlMsgItemIdDirty();
            }
            case 8: {
                return pSCtrlMsgItemBase.isPSCtrlMsgItemNameDirty();
            }
            case 9: {
                return pSCtrlMsgItemBase.isPSCtrlMsgNameDirty();
            }
            case 10: {
                return pSCtrlMsgItemBase.isTimeoutDirty();
            }
            case 11: {
                return pSCtrlMsgItemBase.isUpdateDateDirty();
            }
            case 12: {
                return pSCtrlMsgItemBase.isUpdateManDirty();
            }
            case 13: {
                return pSCtrlMsgItemBase.isUserCatDirty();
            }
            case 14: {
                return pSCtrlMsgItemBase.isUserTagDirty();
            }
            case 15: {
                return pSCtrlMsgItemBase.isUserTag2Dirty();
            }
            case 16: {
                return pSCtrlMsgItemBase.isUserTag3Dirty();
            }
            case 17: {
                return pSCtrlMsgItemBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCtrlMsgItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCtrlMsgItemBase pSCtrlMsgItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCtrlMsgItemBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getContent()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getContentPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpslanresid", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getContentPSLanResId()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getContentPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentpslanresname", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getContentPSLanResName()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getPSCtrlMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgid", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getPSCtrlMsgId()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getPSCtrlMsgItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgitemid", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getPSCtrlMsgItemId()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getPSCtrlMsgItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgitemname", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getPSCtrlMsgItemName()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getPSCtrlMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgname", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getPSCtrlMsgName()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getTimeout() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timeout", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getTimeout()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSCtrlMsgItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSCtrlMsgItemBase.getJSONValue((Object)pSCtrlMsgItemBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCtrlMsgItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCtrlMsgItemBase pSCtrlMsgItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCtrlMsgItemBase.getContent() != null) {
            object = pSCtrlMsgItemBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, (String)(object == null ? "" : object));
        }
        if (bl || pSCtrlMsgItemBase.getContentPSLanResId() != null) {
            object = pSCtrlMsgItemBase.getContentPSLanResId();
            xmlNode.setAttribute(FIELD_CONTENTPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSCtrlMsgItemBase.getContentPSLanResName() != null) {
            object = pSCtrlMsgItemBase.getContentPSLanResName();
            xmlNode.setAttribute(FIELD_CONTENTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgItemBase.getCreateDate() != null) {
            object = pSCtrlMsgItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlMsgItemBase.getCreateMan() != null) {
            object = pSCtrlMsgItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgItemBase.getMemo() != null) {
            object = pSCtrlMsgItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgItemBase.getPSCtrlMsgId() != null) {
            object = pSCtrlMsgItemBase.getPSCtrlMsgId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgItemBase.getPSCtrlMsgItemId() != null) {
            object = pSCtrlMsgItemBase.getPSCtrlMsgItemId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgItemBase.getPSCtrlMsgItemName() != null) {
            object = pSCtrlMsgItemBase.getPSCtrlMsgItemName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgItemBase.getPSCtrlMsgName() != null) {
            object = pSCtrlMsgItemBase.getPSCtrlMsgName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgItemBase.getTimeout() != null) {
            object = pSCtrlMsgItemBase.getTimeout();
            xmlNode.setAttribute(FIELD_TIMEOUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCtrlMsgItemBase.getUpdateDate() != null) {
            object = pSCtrlMsgItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlMsgItemBase.getUpdateMan() != null) {
            object = pSCtrlMsgItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgItemBase.getUserCat() != null) {
            object = pSCtrlMsgItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgItemBase.getUserTag() != null) {
            object = pSCtrlMsgItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgItemBase.getUserTag2() != null) {
            object = pSCtrlMsgItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgItemBase.getUserTag3() != null) {
            object = pSCtrlMsgItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgItemBase.getUserTag4() != null) {
            object = pSCtrlMsgItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCtrlMsgItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCtrlMsgItemBase pSCtrlMsgItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCtrlMsgItemBase.isContentDirty() && (bl || pSCtrlMsgItemBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSCtrlMsgItemBase.getContent());
        }
        if (pSCtrlMsgItemBase.isContentPSLanResIdDirty() && (bl || pSCtrlMsgItemBase.getContentPSLanResId() != null)) {
            iDataObject.set(FIELD_CONTENTPSLANRESID, (Object)pSCtrlMsgItemBase.getContentPSLanResId());
        }
        if (pSCtrlMsgItemBase.isContentPSLanResNameDirty() && (bl || pSCtrlMsgItemBase.getContentPSLanResName() != null)) {
            iDataObject.set(FIELD_CONTENTPSLANRESNAME, (Object)pSCtrlMsgItemBase.getContentPSLanResName());
        }
        if (pSCtrlMsgItemBase.isCreateDateDirty() && (bl || pSCtrlMsgItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCtrlMsgItemBase.getCreateDate());
        }
        if (pSCtrlMsgItemBase.isCreateManDirty() && (bl || pSCtrlMsgItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCtrlMsgItemBase.getCreateMan());
        }
        if (pSCtrlMsgItemBase.isMemoDirty() && (bl || pSCtrlMsgItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCtrlMsgItemBase.getMemo());
        }
        if (pSCtrlMsgItemBase.isPSCtrlMsgIdDirty() && (bl || pSCtrlMsgItemBase.getPSCtrlMsgId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGID, (Object)pSCtrlMsgItemBase.getPSCtrlMsgId());
        }
        if (pSCtrlMsgItemBase.isPSCtrlMsgItemIdDirty() && (bl || pSCtrlMsgItemBase.getPSCtrlMsgItemId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGITEMID, (Object)pSCtrlMsgItemBase.getPSCtrlMsgItemId());
        }
        if (pSCtrlMsgItemBase.isPSCtrlMsgItemNameDirty() && (bl || pSCtrlMsgItemBase.getPSCtrlMsgItemName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGITEMNAME, (Object)pSCtrlMsgItemBase.getPSCtrlMsgItemName());
        }
        if (pSCtrlMsgItemBase.isPSCtrlMsgNameDirty() && (bl || pSCtrlMsgItemBase.getPSCtrlMsgName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGNAME, (Object)pSCtrlMsgItemBase.getPSCtrlMsgName());
        }
        if (pSCtrlMsgItemBase.isTimeoutDirty() && (bl || pSCtrlMsgItemBase.getTimeout() != null)) {
            iDataObject.set(FIELD_TIMEOUT, (Object)pSCtrlMsgItemBase.getTimeout());
        }
        if (pSCtrlMsgItemBase.isUpdateDateDirty() && (bl || pSCtrlMsgItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCtrlMsgItemBase.getUpdateDate());
        }
        if (pSCtrlMsgItemBase.isUpdateManDirty() && (bl || pSCtrlMsgItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCtrlMsgItemBase.getUpdateMan());
        }
        if (pSCtrlMsgItemBase.isUserCatDirty() && (bl || pSCtrlMsgItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSCtrlMsgItemBase.getUserCat());
        }
        if (pSCtrlMsgItemBase.isUserTagDirty() && (bl || pSCtrlMsgItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSCtrlMsgItemBase.getUserTag());
        }
        if (pSCtrlMsgItemBase.isUserTag2Dirty() && (bl || pSCtrlMsgItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSCtrlMsgItemBase.getUserTag2());
        }
        if (pSCtrlMsgItemBase.isUserTag3Dirty() && (bl || pSCtrlMsgItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSCtrlMsgItemBase.getUserTag3());
        }
        if (pSCtrlMsgItemBase.isUserTag4Dirty() && (bl || pSCtrlMsgItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSCtrlMsgItemBase.getUserTag4());
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
        return PSCtrlMsgItemBase.remove(this, n);
    }

    private static boolean remove(PSCtrlMsgItemBase pSCtrlMsgItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlMsgItemBase.resetContent();
                return true;
            }
            case 1: {
                pSCtrlMsgItemBase.resetContentPSLanResId();
                return true;
            }
            case 2: {
                pSCtrlMsgItemBase.resetContentPSLanResName();
                return true;
            }
            case 3: {
                pSCtrlMsgItemBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSCtrlMsgItemBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSCtrlMsgItemBase.resetMemo();
                return true;
            }
            case 6: {
                pSCtrlMsgItemBase.resetPSCtrlMsgId();
                return true;
            }
            case 7: {
                pSCtrlMsgItemBase.resetPSCtrlMsgItemId();
                return true;
            }
            case 8: {
                pSCtrlMsgItemBase.resetPSCtrlMsgItemName();
                return true;
            }
            case 9: {
                pSCtrlMsgItemBase.resetPSCtrlMsgName();
                return true;
            }
            case 10: {
                pSCtrlMsgItemBase.resetTimeout();
                return true;
            }
            case 11: {
                pSCtrlMsgItemBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSCtrlMsgItemBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSCtrlMsgItemBase.resetUserCat();
                return true;
            }
            case 14: {
                pSCtrlMsgItemBase.resetUserTag();
                return true;
            }
            case 15: {
                pSCtrlMsgItemBase.resetUserTag2();
                return true;
            }
            case 16: {
                pSCtrlMsgItemBase.resetUserTag3();
                return true;
            }
            case 17: {
                pSCtrlMsgItemBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlMsg getPSCtrlMsg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsg();
        }
        if (this.getPSCtrlMsgId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlMsgLock;
        synchronized (n) {
            if (this.psctrlmsg != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlMsgId(), (Object)this.psctrlmsg.getPSCtrlMsgId()) != 0L) {
                this.psctrlmsg = null;
            }
            if (this.psctrlmsg == null) {
                PSCtrlMsg pSCtrlMsg = new PSCtrlMsg();
                pSCtrlMsg.setPSCtrlMsgId(this.getPSCtrlMsgId());
                PSCtrlMsgService pSCtrlMsgService = (PSCtrlMsgService)ServiceGlobal.getService(PSCtrlMsgService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlMsgService.autoGet((IEntity)pSCtrlMsg);
                this.psctrlmsg = pSCtrlMsg;
            }
            return this.psctrlmsg;
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
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.contentpslanres = pSLanguageRes;
            }
            return this.contentpslanres;
        }
    }

    private PSCtrlMsgItemBase getProxyEntity() {
        return this.proxyPSCtrlMsgItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCtrlMsgItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSCtrlMsgItemBase) {
            this.proxyPSCtrlMsgItemBase = (PSCtrlMsgItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CONTENTPSLANRESID, 1);
        fieldIndexMap.put(FIELD_CONTENTPSLANRESNAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSCTRLMSGID, 6);
        fieldIndexMap.put(FIELD_PSCTRLMSGITEMID, 7);
        fieldIndexMap.put(FIELD_PSCTRLMSGITEMNAME, 8);
        fieldIndexMap.put(FIELD_PSCTRLMSGNAME, 9);
        fieldIndexMap.put(FIELD_TIMEOUT, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERCAT, 13);
        fieldIndexMap.put(FIELD_USERTAG, 14);
        fieldIndexMap.put(FIELD_USERTAG2, 15);
        fieldIndexMap.put(FIELD_USERTAG3, 16);
        fieldIndexMap.put(FIELD_USERTAG4, 17);
    }
}

