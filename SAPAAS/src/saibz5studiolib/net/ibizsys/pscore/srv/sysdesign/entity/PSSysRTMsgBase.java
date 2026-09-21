/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysRTMsgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysRTMsgBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLEREMOVE = "ENABLEREMOVE";
    public static final String FIELD_MSGPOS = "MSGPOS";
    public static final String FIELD_MSGTYPE = "MSGTYPE";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSSYSRTMSGID = "PSSYSRTMSGID";
    public static final String FIELD_PSSYSRTMSGNAME = "PSSYSRTMSGNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENABLEREMOVE = 3;
    private static final int INDEX_MSGPOS = 4;
    private static final int INDEX_MSGTYPE = 5;
    private static final int INDEX_PSOBJID = 6;
    private static final int INDEX_PSOBJTYPE = 7;
    private static final int INDEX_PSSYSRTMSGID = 8;
    private static final int INDEX_PSSYSRTMSGNAME = 9;
    private static final int INDEX_PSSYSTEMID = 10;
    private static final int INDEX_TITLE = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysRTMsgBase proxyPSSysRTMsgBase = null;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableremoveDirtyFlag = false;
    private boolean msgposDirtyFlag = false;
    private boolean msgtypeDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean pssysrtmsgidDirtyFlag = false;
    private boolean pssysrtmsgnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enableremove")
    private Integer enableremove;
    @Column(name="msgpos")
    private String msgpos;
    @Column(name="msgtype")
    private String msgtype;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="pssysrtmsgid")
    private String pssysrtmsgid;
    @Column(name="pssysrtmsgname")
    private String pssysrtmsgname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="title")
    private String title;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;

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

    public void setEnableRemove(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableRemove(n);
            return;
        }
        this.enableremove = n;
        this.enableremoveDirtyFlag = true;
    }

    public Integer getEnableRemove() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableRemove();
        }
        return this.enableremove;
    }

    public boolean isEnableRemoveDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableRemoveDirty();
        }
        return this.enableremoveDirtyFlag;
    }

    public void resetEnableRemove() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableRemove();
            return;
        }
        this.enableremoveDirtyFlag = false;
        this.enableremove = null;
    }

    public void setMsgPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgpos = string;
        this.msgposDirtyFlag = true;
    }

    public String getMsgPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgPos();
        }
        return this.msgpos;
    }

    public boolean isMsgPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgPosDirty();
        }
        return this.msgposDirtyFlag;
    }

    public void resetMsgPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgPos();
            return;
        }
        this.msgposDirtyFlag = false;
        this.msgpos = null;
    }

    public void setMsgType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgtype = string;
        this.msgtypeDirtyFlag = true;
    }

    public String getMsgType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgType();
        }
        return this.msgtype;
    }

    public boolean isMsgTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTypeDirty();
        }
        return this.msgtypeDirtyFlag;
    }

    public void resetMsgType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgType();
            return;
        }
        this.msgtypeDirtyFlag = false;
        this.msgtype = null;
    }

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtype = string;
        this.psobjtypeDirtyFlag = true;
    }

    public String getPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjType();
        }
        return this.psobjtype;
    }

    public boolean isPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeDirty();
        }
        return this.psobjtypeDirtyFlag;
    }

    public void resetPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjType();
            return;
        }
        this.psobjtypeDirtyFlag = false;
        this.psobjtype = null;
    }

    public void setPSSysRTMsgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRTMsgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrtmsgid = string;
        this.pssysrtmsgidDirtyFlag = true;
    }

    public String getPSSysRTMsgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRTMsgId();
        }
        return this.pssysrtmsgid;
    }

    public boolean isPSSysRTMsgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRTMsgIdDirty();
        }
        return this.pssysrtmsgidDirtyFlag;
    }

    public void resetPSSysRTMsgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRTMsgId();
            return;
        }
        this.pssysrtmsgidDirtyFlag = false;
        this.pssysrtmsgid = null;
    }

    public void setPSSysRTMsgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRTMsgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrtmsgname = string;
        this.pssysrtmsgnameDirtyFlag = true;
    }

    public String getPSSysRTMsgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRTMsgName();
        }
        return this.pssysrtmsgname;
    }

    public boolean isPSSysRTMsgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRTMsgNameDirty();
        }
        return this.pssysrtmsgnameDirtyFlag;
    }

    public void resetPSSysRTMsgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRTMsgName();
            return;
        }
        this.pssysrtmsgnameDirtyFlag = false;
        this.pssysrtmsgname = null;
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

    public void setTitle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.title = string;
        this.titleDirtyFlag = true;
    }

    public String getTitle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitle();
        }
        return this.title;
    }

    public boolean isTitleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleDirty();
        }
        return this.titleDirtyFlag;
    }

    public void resetTitle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitle();
            return;
        }
        this.titleDirtyFlag = false;
        this.title = null;
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

    protected void onReset() {
        PSSysRTMsgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysRTMsgBase pSSysRTMsgBase) {
        pSSysRTMsgBase.resetContent();
        pSSysRTMsgBase.resetCreateDate();
        pSSysRTMsgBase.resetCreateMan();
        pSSysRTMsgBase.resetEnableRemove();
        pSSysRTMsgBase.resetMsgPos();
        pSSysRTMsgBase.resetMsgType();
        pSSysRTMsgBase.resetPSObjId();
        pSSysRTMsgBase.resetPSObjType();
        pSSysRTMsgBase.resetPSSysRTMsgId();
        pSSysRTMsgBase.resetPSSysRTMsgName();
        pSSysRTMsgBase.resetPSSystemId();
        pSSysRTMsgBase.resetTitle();
        pSSysRTMsgBase.resetUpdateDate();
        pSSysRTMsgBase.resetUpdateMan();
        pSSysRTMsgBase.resetUserTag();
        pSSysRTMsgBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableRemoveDirty()) {
            hashMap.put(FIELD_ENABLEREMOVE, this.getEnableRemove());
        }
        if (!bl || this.isMsgPosDirty()) {
            hashMap.put(FIELD_MSGPOS, this.getMsgPos());
        }
        if (!bl || this.isMsgTypeDirty()) {
            hashMap.put(FIELD_MSGTYPE, this.getMsgType());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
        }
        if (!bl || this.isPSSysRTMsgIdDirty()) {
            hashMap.put(FIELD_PSSYSRTMSGID, this.getPSSysRTMsgId());
        }
        if (!bl || this.isPSSysRTMsgNameDirty()) {
            hashMap.put(FIELD_PSSYSRTMSGNAME, this.getPSSysRTMsgName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isTitleDirty()) {
            hashMap.put(FIELD_TITLE, this.getTitle());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSSysRTMsgBase.get(this, n);
    }

    private static Object get(PSSysRTMsgBase pSSysRTMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRTMsgBase.getContent();
            }
            case 1: {
                return pSSysRTMsgBase.getCreateDate();
            }
            case 2: {
                return pSSysRTMsgBase.getCreateMan();
            }
            case 3: {
                return pSSysRTMsgBase.getEnableRemove();
            }
            case 4: {
                return pSSysRTMsgBase.getMsgPos();
            }
            case 5: {
                return pSSysRTMsgBase.getMsgType();
            }
            case 6: {
                return pSSysRTMsgBase.getPSObjId();
            }
            case 7: {
                return pSSysRTMsgBase.getPSObjType();
            }
            case 8: {
                return pSSysRTMsgBase.getPSSysRTMsgId();
            }
            case 9: {
                return pSSysRTMsgBase.getPSSysRTMsgName();
            }
            case 10: {
                return pSSysRTMsgBase.getPSSystemId();
            }
            case 11: {
                return pSSysRTMsgBase.getTitle();
            }
            case 12: {
                return pSSysRTMsgBase.getUpdateDate();
            }
            case 13: {
                return pSSysRTMsgBase.getUpdateMan();
            }
            case 14: {
                return pSSysRTMsgBase.getUserTag();
            }
            case 15: {
                return pSSysRTMsgBase.getUserTag2();
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
        PSSysRTMsgBase.set(this, n, object);
    }

    private static void set(PSSysRTMsgBase pSSysRTMsgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysRTMsgBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysRTMsgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysRTMsgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysRTMsgBase.setEnableRemove(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysRTMsgBase.setMsgPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysRTMsgBase.setMsgType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysRTMsgBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysRTMsgBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysRTMsgBase.setPSSysRTMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysRTMsgBase.setPSSysRTMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysRTMsgBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysRTMsgBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysRTMsgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSysRTMsgBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysRTMsgBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysRTMsgBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSSysRTMsgBase.isNull(this, n);
    }

    private static boolean isNull(PSSysRTMsgBase pSSysRTMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRTMsgBase.getContent() == null;
            }
            case 1: {
                return pSSysRTMsgBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysRTMsgBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysRTMsgBase.getEnableRemove() == null;
            }
            case 4: {
                return pSSysRTMsgBase.getMsgPos() == null;
            }
            case 5: {
                return pSSysRTMsgBase.getMsgType() == null;
            }
            case 6: {
                return pSSysRTMsgBase.getPSObjId() == null;
            }
            case 7: {
                return pSSysRTMsgBase.getPSObjType() == null;
            }
            case 8: {
                return pSSysRTMsgBase.getPSSysRTMsgId() == null;
            }
            case 9: {
                return pSSysRTMsgBase.getPSSysRTMsgName() == null;
            }
            case 10: {
                return pSSysRTMsgBase.getPSSystemId() == null;
            }
            case 11: {
                return pSSysRTMsgBase.getTitle() == null;
            }
            case 12: {
                return pSSysRTMsgBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSysRTMsgBase.getUpdateMan() == null;
            }
            case 14: {
                return pSSysRTMsgBase.getUserTag() == null;
            }
            case 15: {
                return pSSysRTMsgBase.getUserTag2() == null;
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
        return PSSysRTMsgBase.contains(this, n);
    }

    private static boolean contains(PSSysRTMsgBase pSSysRTMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysRTMsgBase.isContentDirty();
            }
            case 1: {
                return pSSysRTMsgBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysRTMsgBase.isCreateManDirty();
            }
            case 3: {
                return pSSysRTMsgBase.isEnableRemoveDirty();
            }
            case 4: {
                return pSSysRTMsgBase.isMsgPosDirty();
            }
            case 5: {
                return pSSysRTMsgBase.isMsgTypeDirty();
            }
            case 6: {
                return pSSysRTMsgBase.isPSObjIdDirty();
            }
            case 7: {
                return pSSysRTMsgBase.isPSObjTypeDirty();
            }
            case 8: {
                return pSSysRTMsgBase.isPSSysRTMsgIdDirty();
            }
            case 9: {
                return pSSysRTMsgBase.isPSSysRTMsgNameDirty();
            }
            case 10: {
                return pSSysRTMsgBase.isPSSystemIdDirty();
            }
            case 11: {
                return pSSysRTMsgBase.isTitleDirty();
            }
            case 12: {
                return pSSysRTMsgBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSysRTMsgBase.isUpdateManDirty();
            }
            case 14: {
                return pSSysRTMsgBase.isUserTagDirty();
            }
            case 15: {
                return pSSysRTMsgBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysRTMsgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysRTMsgBase pSSysRTMsgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysRTMsgBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getContent()), (boolean)false);
        }
        if (bl || pSSysRTMsgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysRTMsgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysRTMsgBase.getEnableRemove() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableremove", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getEnableRemove()), (boolean)false);
        }
        if (bl || pSSysRTMsgBase.getMsgPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgpos", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getMsgPos()), (boolean)false);
        }
        if (bl || pSSysRTMsgBase.getMsgType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtype", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getMsgType()), (boolean)false);
        }
        if (bl || pSSysRTMsgBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSSysRTMsgBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSSysRTMsgBase.getPSSysRTMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrtmsgid", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getPSSysRTMsgId()), (boolean)false);
        }
        if (bl || pSSysRTMsgBase.getPSSysRTMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrtmsgname", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getPSSysRTMsgName()), (boolean)false);
        }
        if (bl || pSSysRTMsgBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysRTMsgBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getTitle()), (boolean)false);
        }
        if (bl || pSSysRTMsgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysRTMsgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysRTMsgBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysRTMsgBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysRTMsgBase.getJSONValue((Object)pSSysRTMsgBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysRTMsgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysRTMsgBase pSSysRTMsgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysRTMsgBase.getContent() != null) {
            object = pSSysRTMsgBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTMsgBase.getCreateDate() != null) {
            object = pSSysRTMsgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysRTMsgBase.getCreateMan() != null) {
            object = pSSysRTMsgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTMsgBase.getEnableRemove() != null) {
            object = pSSysRTMsgBase.getEnableRemove();
            xmlNode.setAttribute(FIELD_ENABLEREMOVE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysRTMsgBase.getMsgPos() != null) {
            object = pSSysRTMsgBase.getMsgPos();
            xmlNode.setAttribute(FIELD_MSGPOS, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTMsgBase.getMsgType() != null) {
            object = pSSysRTMsgBase.getMsgType();
            xmlNode.setAttribute(FIELD_MSGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTMsgBase.getPSObjId() != null) {
            object = pSSysRTMsgBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTMsgBase.getPSObjType() != null) {
            object = pSSysRTMsgBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTMsgBase.getPSSysRTMsgId() != null) {
            object = pSSysRTMsgBase.getPSSysRTMsgId();
            xmlNode.setAttribute(FIELD_PSSYSRTMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTMsgBase.getPSSysRTMsgName() != null) {
            object = pSSysRTMsgBase.getPSSysRTMsgName();
            xmlNode.setAttribute(FIELD_PSSYSRTMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTMsgBase.getPSSystemId() != null) {
            object = pSSysRTMsgBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTMsgBase.getTitle() != null) {
            object = pSSysRTMsgBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTMsgBase.getUpdateDate() != null) {
            object = pSSysRTMsgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysRTMsgBase.getUpdateMan() != null) {
            object = pSSysRTMsgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTMsgBase.getUserTag() != null) {
            object = pSSysRTMsgBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysRTMsgBase.getUserTag2() != null) {
            object = pSSysRTMsgBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysRTMsgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysRTMsgBase pSSysRTMsgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysRTMsgBase.isContentDirty() && (bl || pSSysRTMsgBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSSysRTMsgBase.getContent());
        }
        if (pSSysRTMsgBase.isCreateDateDirty() && (bl || pSSysRTMsgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysRTMsgBase.getCreateDate());
        }
        if (pSSysRTMsgBase.isCreateManDirty() && (bl || pSSysRTMsgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysRTMsgBase.getCreateMan());
        }
        if (pSSysRTMsgBase.isEnableRemoveDirty() && (bl || pSSysRTMsgBase.getEnableRemove() != null)) {
            iDataObject.set(FIELD_ENABLEREMOVE, (Object)pSSysRTMsgBase.getEnableRemove());
        }
        if (pSSysRTMsgBase.isMsgPosDirty() && (bl || pSSysRTMsgBase.getMsgPos() != null)) {
            iDataObject.set(FIELD_MSGPOS, (Object)pSSysRTMsgBase.getMsgPos());
        }
        if (pSSysRTMsgBase.isMsgTypeDirty() && (bl || pSSysRTMsgBase.getMsgType() != null)) {
            iDataObject.set(FIELD_MSGTYPE, (Object)pSSysRTMsgBase.getMsgType());
        }
        if (pSSysRTMsgBase.isPSObjIdDirty() && (bl || pSSysRTMsgBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSSysRTMsgBase.getPSObjId());
        }
        if (pSSysRTMsgBase.isPSObjTypeDirty() && (bl || pSSysRTMsgBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSSysRTMsgBase.getPSObjType());
        }
        if (pSSysRTMsgBase.isPSSysRTMsgIdDirty() && (bl || pSSysRTMsgBase.getPSSysRTMsgId() != null)) {
            iDataObject.set(FIELD_PSSYSRTMSGID, (Object)pSSysRTMsgBase.getPSSysRTMsgId());
        }
        if (pSSysRTMsgBase.isPSSysRTMsgNameDirty() && (bl || pSSysRTMsgBase.getPSSysRTMsgName() != null)) {
            iDataObject.set(FIELD_PSSYSRTMSGNAME, (Object)pSSysRTMsgBase.getPSSysRTMsgName());
        }
        if (pSSysRTMsgBase.isPSSystemIdDirty() && (bl || pSSysRTMsgBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysRTMsgBase.getPSSystemId());
        }
        if (pSSysRTMsgBase.isTitleDirty() && (bl || pSSysRTMsgBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSSysRTMsgBase.getTitle());
        }
        if (pSSysRTMsgBase.isUpdateDateDirty() && (bl || pSSysRTMsgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysRTMsgBase.getUpdateDate());
        }
        if (pSSysRTMsgBase.isUpdateManDirty() && (bl || pSSysRTMsgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysRTMsgBase.getUpdateMan());
        }
        if (pSSysRTMsgBase.isUserTagDirty() && (bl || pSSysRTMsgBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysRTMsgBase.getUserTag());
        }
        if (pSSysRTMsgBase.isUserTag2Dirty() && (bl || pSSysRTMsgBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysRTMsgBase.getUserTag2());
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
        return PSSysRTMsgBase.remove(this, n);
    }

    private static boolean remove(PSSysRTMsgBase pSSysRTMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysRTMsgBase.resetContent();
                return true;
            }
            case 1: {
                pSSysRTMsgBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysRTMsgBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysRTMsgBase.resetEnableRemove();
                return true;
            }
            case 4: {
                pSSysRTMsgBase.resetMsgPos();
                return true;
            }
            case 5: {
                pSSysRTMsgBase.resetMsgType();
                return true;
            }
            case 6: {
                pSSysRTMsgBase.resetPSObjId();
                return true;
            }
            case 7: {
                pSSysRTMsgBase.resetPSObjType();
                return true;
            }
            case 8: {
                pSSysRTMsgBase.resetPSSysRTMsgId();
                return true;
            }
            case 9: {
                pSSysRTMsgBase.resetPSSysRTMsgName();
                return true;
            }
            case 10: {
                pSSysRTMsgBase.resetPSSystemId();
                return true;
            }
            case 11: {
                pSSysRTMsgBase.resetTitle();
                return true;
            }
            case 12: {
                pSSysRTMsgBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSysRTMsgBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSSysRTMsgBase.resetUserTag();
                return true;
            }
            case 15: {
                pSSysRTMsgBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysRTMsgBase getProxyEntity() {
        return this.proxyPSSysRTMsgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysRTMsgBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysRTMsgBase) {
            this.proxyPSSysRTMsgBase = (PSSysRTMsgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysRTMsgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENABLEREMOVE, 3);
        fieldIndexMap.put(FIELD_MSGPOS, 4);
        fieldIndexMap.put(FIELD_MSGTYPE, 5);
        fieldIndexMap.put(FIELD_PSOBJID, 6);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 7);
        fieldIndexMap.put(FIELD_PSSYSRTMSGID, 8);
        fieldIndexMap.put(FIELD_PSSYSRTMSGNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 10);
        fieldIndexMap.put(FIELD_TITLE, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERTAG, 14);
        fieldIndexMap.put(FIELD_USERTAG2, 15);
    }
}

