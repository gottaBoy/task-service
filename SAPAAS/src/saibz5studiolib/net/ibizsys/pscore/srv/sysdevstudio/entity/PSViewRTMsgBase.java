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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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

public abstract class PSViewRTMsgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSViewRTMsgBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MAINCAT = "MAINCAT";
    public static final String FIELD_MSGPOS = "MSGPOS";
    public static final String FIELD_MSGTYPE = "MSGTYPE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSVIEWRTMSGID = "PSVIEWRTMSGID";
    public static final String FIELD_PSVIEWRTMSGNAME = "PSVIEWRTMSGNAME";
    public static final String FIELD_SRFVIEWID = "SRFVIEWID";
    public static final String FIELD_SUBCAT = "SUBCAT";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MAINCAT = 3;
    private static final int INDEX_MSGPOS = 4;
    private static final int INDEX_MSGTYPE = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSVIEWRTMSGID = 7;
    private static final int INDEX_PSVIEWRTMSGNAME = 8;
    private static final int INDEX_SRFVIEWID = 9;
    private static final int INDEX_SUBCAT = 10;
    private static final int INDEX_TITLE = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSViewRTMsgBase proxyPSViewRTMsgBase = null;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean maincatDirtyFlag = false;
    private boolean msgposDirtyFlag = false;
    private boolean msgtypeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psviewrtmsgidDirtyFlag = false;
    private boolean psviewrtmsgnameDirtyFlag = false;
    private boolean srfviewidDirtyFlag = false;
    private boolean subcatDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="maincat")
    private String maincat;
    @Column(name="msgpos")
    private String msgpos;
    @Column(name="msgtype")
    private String msgtype;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psviewrtmsgid")
    private String psviewrtmsgid;
    @Column(name="psviewrtmsgname")
    private String psviewrtmsgname;
    @Column(name="srfviewid")
    private String srfviewid;
    @Column(name="subcat")
    private String subcat;
    @Column(name="title")
    private String title;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

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

    public void setMainCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maincat = string;
        this.maincatDirtyFlag = true;
    }

    public String getMainCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainCat();
        }
        return this.maincat;
    }

    public boolean isMainCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainCatDirty();
        }
        return this.maincatDirtyFlag;
    }

    public void resetMainCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainCat();
            return;
        }
        this.maincatDirtyFlag = false;
        this.maincat = null;
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

    public void setPSViewRTMsgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewRTMsgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewrtmsgid = string;
        this.psviewrtmsgidDirtyFlag = true;
    }

    public String getPSViewRTMsgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewRTMsgId();
        }
        return this.psviewrtmsgid;
    }

    public boolean isPSViewRTMsgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewRTMsgIdDirty();
        }
        return this.psviewrtmsgidDirtyFlag;
    }

    public void resetPSViewRTMsgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewRTMsgId();
            return;
        }
        this.psviewrtmsgidDirtyFlag = false;
        this.psviewrtmsgid = null;
    }

    public void setPSViewRTMsgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewRTMsgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewrtmsgname = string;
        this.psviewrtmsgnameDirtyFlag = true;
    }

    public String getPSViewRTMsgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewRTMsgName();
        }
        return this.psviewrtmsgname;
    }

    public boolean isPSViewRTMsgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewRTMsgNameDirty();
        }
        return this.psviewrtmsgnameDirtyFlag;
    }

    public void resetPSViewRTMsgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewRTMsgName();
            return;
        }
        this.psviewrtmsgnameDirtyFlag = false;
        this.psviewrtmsgname = null;
    }

    public void setSRFViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srfviewid = string;
        this.srfviewidDirtyFlag = true;
    }

    public String getSRFViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFViewId();
        }
        return this.srfviewid;
    }

    public boolean isSRFViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFViewIdDirty();
        }
        return this.srfviewidDirtyFlag;
    }

    public void resetSRFViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFViewId();
            return;
        }
        this.srfviewidDirtyFlag = false;
        this.srfviewid = null;
    }

    public void setSubCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subcat = string;
        this.subcatDirtyFlag = true;
    }

    public String getSubCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubCat();
        }
        return this.subcat;
    }

    public boolean isSubCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubCatDirty();
        }
        return this.subcatDirtyFlag;
    }

    public void resetSubCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubCat();
            return;
        }
        this.subcatDirtyFlag = false;
        this.subcat = null;
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

    protected void onReset() {
        PSViewRTMsgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSViewRTMsgBase pSViewRTMsgBase) {
        pSViewRTMsgBase.resetContent();
        pSViewRTMsgBase.resetCreateDate();
        pSViewRTMsgBase.resetCreateMan();
        pSViewRTMsgBase.resetMainCat();
        pSViewRTMsgBase.resetMsgPos();
        pSViewRTMsgBase.resetMsgType();
        pSViewRTMsgBase.resetOrderValue();
        pSViewRTMsgBase.resetPSViewRTMsgId();
        pSViewRTMsgBase.resetPSViewRTMsgName();
        pSViewRTMsgBase.resetSRFViewId();
        pSViewRTMsgBase.resetSubCat();
        pSViewRTMsgBase.resetTitle();
        pSViewRTMsgBase.resetUpdateDate();
        pSViewRTMsgBase.resetUpdateMan();
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
        if (!bl || this.isMainCatDirty()) {
            hashMap.put(FIELD_MAINCAT, this.getMainCat());
        }
        if (!bl || this.isMsgPosDirty()) {
            hashMap.put(FIELD_MSGPOS, this.getMsgPos());
        }
        if (!bl || this.isMsgTypeDirty()) {
            hashMap.put(FIELD_MSGTYPE, this.getMsgType());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSViewRTMsgIdDirty()) {
            hashMap.put(FIELD_PSVIEWRTMSGID, this.getPSViewRTMsgId());
        }
        if (!bl || this.isPSViewRTMsgNameDirty()) {
            hashMap.put(FIELD_PSVIEWRTMSGNAME, this.getPSViewRTMsgName());
        }
        if (!bl || this.isSRFViewIdDirty()) {
            hashMap.put(FIELD_SRFVIEWID, this.getSRFViewId());
        }
        if (!bl || this.isSubCatDirty()) {
            hashMap.put(FIELD_SUBCAT, this.getSubCat());
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
        return PSViewRTMsgBase.get(this, n);
    }

    private static Object get(PSViewRTMsgBase pSViewRTMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewRTMsgBase.getContent();
            }
            case 1: {
                return pSViewRTMsgBase.getCreateDate();
            }
            case 2: {
                return pSViewRTMsgBase.getCreateMan();
            }
            case 3: {
                return pSViewRTMsgBase.getMainCat();
            }
            case 4: {
                return pSViewRTMsgBase.getMsgPos();
            }
            case 5: {
                return pSViewRTMsgBase.getMsgType();
            }
            case 6: {
                return pSViewRTMsgBase.getOrderValue();
            }
            case 7: {
                return pSViewRTMsgBase.getPSViewRTMsgId();
            }
            case 8: {
                return pSViewRTMsgBase.getPSViewRTMsgName();
            }
            case 9: {
                return pSViewRTMsgBase.getSRFViewId();
            }
            case 10: {
                return pSViewRTMsgBase.getSubCat();
            }
            case 11: {
                return pSViewRTMsgBase.getTitle();
            }
            case 12: {
                return pSViewRTMsgBase.getUpdateDate();
            }
            case 13: {
                return pSViewRTMsgBase.getUpdateMan();
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
        PSViewRTMsgBase.set(this, n, object);
    }

    private static void set(PSViewRTMsgBase pSViewRTMsgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSViewRTMsgBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSViewRTMsgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSViewRTMsgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSViewRTMsgBase.setMainCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSViewRTMsgBase.setMsgPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSViewRTMsgBase.setMsgType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSViewRTMsgBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSViewRTMsgBase.setPSViewRTMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSViewRTMsgBase.setPSViewRTMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSViewRTMsgBase.setSRFViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSViewRTMsgBase.setSubCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSViewRTMsgBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSViewRTMsgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSViewRTMsgBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSViewRTMsgBase.isNull(this, n);
    }

    private static boolean isNull(PSViewRTMsgBase pSViewRTMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewRTMsgBase.getContent() == null;
            }
            case 1: {
                return pSViewRTMsgBase.getCreateDate() == null;
            }
            case 2: {
                return pSViewRTMsgBase.getCreateMan() == null;
            }
            case 3: {
                return pSViewRTMsgBase.getMainCat() == null;
            }
            case 4: {
                return pSViewRTMsgBase.getMsgPos() == null;
            }
            case 5: {
                return pSViewRTMsgBase.getMsgType() == null;
            }
            case 6: {
                return pSViewRTMsgBase.getOrderValue() == null;
            }
            case 7: {
                return pSViewRTMsgBase.getPSViewRTMsgId() == null;
            }
            case 8: {
                return pSViewRTMsgBase.getPSViewRTMsgName() == null;
            }
            case 9: {
                return pSViewRTMsgBase.getSRFViewId() == null;
            }
            case 10: {
                return pSViewRTMsgBase.getSubCat() == null;
            }
            case 11: {
                return pSViewRTMsgBase.getTitle() == null;
            }
            case 12: {
                return pSViewRTMsgBase.getUpdateDate() == null;
            }
            case 13: {
                return pSViewRTMsgBase.getUpdateMan() == null;
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
        return PSViewRTMsgBase.contains(this, n);
    }

    private static boolean contains(PSViewRTMsgBase pSViewRTMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewRTMsgBase.isContentDirty();
            }
            case 1: {
                return pSViewRTMsgBase.isCreateDateDirty();
            }
            case 2: {
                return pSViewRTMsgBase.isCreateManDirty();
            }
            case 3: {
                return pSViewRTMsgBase.isMainCatDirty();
            }
            case 4: {
                return pSViewRTMsgBase.isMsgPosDirty();
            }
            case 5: {
                return pSViewRTMsgBase.isMsgTypeDirty();
            }
            case 6: {
                return pSViewRTMsgBase.isOrderValueDirty();
            }
            case 7: {
                return pSViewRTMsgBase.isPSViewRTMsgIdDirty();
            }
            case 8: {
                return pSViewRTMsgBase.isPSViewRTMsgNameDirty();
            }
            case 9: {
                return pSViewRTMsgBase.isSRFViewIdDirty();
            }
            case 10: {
                return pSViewRTMsgBase.isSubCatDirty();
            }
            case 11: {
                return pSViewRTMsgBase.isTitleDirty();
            }
            case 12: {
                return pSViewRTMsgBase.isUpdateDateDirty();
            }
            case 13: {
                return pSViewRTMsgBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSViewRTMsgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSViewRTMsgBase pSViewRTMsgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSViewRTMsgBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSViewRTMsgBase.getJSONValue((Object)pSViewRTMsgBase.getContent()), (boolean)false);
        }
        if (bl || pSViewRTMsgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSViewRTMsgBase.getJSONValue((Object)pSViewRTMsgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSViewRTMsgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSViewRTMsgBase.getJSONValue((Object)pSViewRTMsgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSViewRTMsgBase.getMainCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maincat", (Object)PSViewRTMsgBase.getJSONValue((Object)pSViewRTMsgBase.getMainCat()), (boolean)false);
        }
        if (bl || pSViewRTMsgBase.getMsgPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgpos", (Object)PSViewRTMsgBase.getJSONValue((Object)pSViewRTMsgBase.getMsgPos()), (boolean)false);
        }
        if (bl || pSViewRTMsgBase.getMsgType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtype", (Object)PSViewRTMsgBase.getJSONValue((Object)pSViewRTMsgBase.getMsgType()), (boolean)false);
        }
        if (bl || pSViewRTMsgBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSViewRTMsgBase.getJSONValue((Object)pSViewRTMsgBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSViewRTMsgBase.getPSViewRTMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewrtmsgid", (Object)PSViewRTMsgBase.getJSONValue((Object)pSViewRTMsgBase.getPSViewRTMsgId()), (boolean)false);
        }
        if (bl || pSViewRTMsgBase.getPSViewRTMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewrtmsgname", (Object)PSViewRTMsgBase.getJSONValue((Object)pSViewRTMsgBase.getPSViewRTMsgName()), (boolean)false);
        }
        if (bl || pSViewRTMsgBase.getSRFViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfviewid", (Object)PSViewRTMsgBase.getJSONValue((Object)pSViewRTMsgBase.getSRFViewId()), (boolean)false);
        }
        if (bl || pSViewRTMsgBase.getSubCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subcat", (Object)PSViewRTMsgBase.getJSONValue((Object)pSViewRTMsgBase.getSubCat()), (boolean)false);
        }
        if (bl || pSViewRTMsgBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSViewRTMsgBase.getJSONValue((Object)pSViewRTMsgBase.getTitle()), (boolean)false);
        }
        if (bl || pSViewRTMsgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSViewRTMsgBase.getJSONValue((Object)pSViewRTMsgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSViewRTMsgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSViewRTMsgBase.getJSONValue((Object)pSViewRTMsgBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSViewRTMsgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSViewRTMsgBase pSViewRTMsgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSViewRTMsgBase.getContent() != null) {
            object = pSViewRTMsgBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSViewRTMsgBase.getCreateDate() != null) {
            object = pSViewRTMsgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewRTMsgBase.getCreateMan() != null) {
            object = pSViewRTMsgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewRTMsgBase.getMainCat() != null) {
            object = pSViewRTMsgBase.getMainCat();
            xmlNode.setAttribute(FIELD_MAINCAT, object == null ? "" : (String)object);
        }
        if (bl || pSViewRTMsgBase.getMsgPos() != null) {
            object = pSViewRTMsgBase.getMsgPos();
            xmlNode.setAttribute(FIELD_MSGPOS, object == null ? "" : (String)object);
        }
        if (bl || pSViewRTMsgBase.getMsgType() != null) {
            object = pSViewRTMsgBase.getMsgType();
            xmlNode.setAttribute(FIELD_MSGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSViewRTMsgBase.getOrderValue() != null) {
            object = pSViewRTMsgBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewRTMsgBase.getPSViewRTMsgId() != null) {
            object = pSViewRTMsgBase.getPSViewRTMsgId();
            xmlNode.setAttribute(FIELD_PSVIEWRTMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSViewRTMsgBase.getPSViewRTMsgName() != null) {
            object = pSViewRTMsgBase.getPSViewRTMsgName();
            xmlNode.setAttribute(FIELD_PSVIEWRTMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewRTMsgBase.getSRFViewId() != null) {
            object = pSViewRTMsgBase.getSRFViewId();
            xmlNode.setAttribute(FIELD_SRFVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSViewRTMsgBase.getSubCat() != null) {
            object = pSViewRTMsgBase.getSubCat();
            xmlNode.setAttribute(FIELD_SUBCAT, object == null ? "" : (String)object);
        }
        if (bl || pSViewRTMsgBase.getTitle() != null) {
            object = pSViewRTMsgBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSViewRTMsgBase.getUpdateDate() != null) {
            object = pSViewRTMsgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewRTMsgBase.getUpdateMan() != null) {
            object = pSViewRTMsgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSViewRTMsgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSViewRTMsgBase pSViewRTMsgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSViewRTMsgBase.isContentDirty() && (bl || pSViewRTMsgBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSViewRTMsgBase.getContent());
        }
        if (pSViewRTMsgBase.isCreateDateDirty() && (bl || pSViewRTMsgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSViewRTMsgBase.getCreateDate());
        }
        if (pSViewRTMsgBase.isCreateManDirty() && (bl || pSViewRTMsgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSViewRTMsgBase.getCreateMan());
        }
        if (pSViewRTMsgBase.isMainCatDirty() && (bl || pSViewRTMsgBase.getMainCat() != null)) {
            iDataObject.set(FIELD_MAINCAT, (Object)pSViewRTMsgBase.getMainCat());
        }
        if (pSViewRTMsgBase.isMsgPosDirty() && (bl || pSViewRTMsgBase.getMsgPos() != null)) {
            iDataObject.set(FIELD_MSGPOS, (Object)pSViewRTMsgBase.getMsgPos());
        }
        if (pSViewRTMsgBase.isMsgTypeDirty() && (bl || pSViewRTMsgBase.getMsgType() != null)) {
            iDataObject.set(FIELD_MSGTYPE, (Object)pSViewRTMsgBase.getMsgType());
        }
        if (pSViewRTMsgBase.isOrderValueDirty() && (bl || pSViewRTMsgBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSViewRTMsgBase.getOrderValue());
        }
        if (pSViewRTMsgBase.isPSViewRTMsgIdDirty() && (bl || pSViewRTMsgBase.getPSViewRTMsgId() != null)) {
            iDataObject.set(FIELD_PSVIEWRTMSGID, (Object)pSViewRTMsgBase.getPSViewRTMsgId());
        }
        if (pSViewRTMsgBase.isPSViewRTMsgNameDirty() && (bl || pSViewRTMsgBase.getPSViewRTMsgName() != null)) {
            iDataObject.set(FIELD_PSVIEWRTMSGNAME, (Object)pSViewRTMsgBase.getPSViewRTMsgName());
        }
        if (pSViewRTMsgBase.isSRFViewIdDirty() && (bl || pSViewRTMsgBase.getSRFViewId() != null)) {
            iDataObject.set(FIELD_SRFVIEWID, (Object)pSViewRTMsgBase.getSRFViewId());
        }
        if (pSViewRTMsgBase.isSubCatDirty() && (bl || pSViewRTMsgBase.getSubCat() != null)) {
            iDataObject.set(FIELD_SUBCAT, (Object)pSViewRTMsgBase.getSubCat());
        }
        if (pSViewRTMsgBase.isTitleDirty() && (bl || pSViewRTMsgBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSViewRTMsgBase.getTitle());
        }
        if (pSViewRTMsgBase.isUpdateDateDirty() && (bl || pSViewRTMsgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSViewRTMsgBase.getUpdateDate());
        }
        if (pSViewRTMsgBase.isUpdateManDirty() && (bl || pSViewRTMsgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSViewRTMsgBase.getUpdateMan());
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
        return PSViewRTMsgBase.remove(this, n);
    }

    private static boolean remove(PSViewRTMsgBase pSViewRTMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSViewRTMsgBase.resetContent();
                return true;
            }
            case 1: {
                pSViewRTMsgBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSViewRTMsgBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSViewRTMsgBase.resetMainCat();
                return true;
            }
            case 4: {
                pSViewRTMsgBase.resetMsgPos();
                return true;
            }
            case 5: {
                pSViewRTMsgBase.resetMsgType();
                return true;
            }
            case 6: {
                pSViewRTMsgBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSViewRTMsgBase.resetPSViewRTMsgId();
                return true;
            }
            case 8: {
                pSViewRTMsgBase.resetPSViewRTMsgName();
                return true;
            }
            case 9: {
                pSViewRTMsgBase.resetSRFViewId();
                return true;
            }
            case 10: {
                pSViewRTMsgBase.resetSubCat();
                return true;
            }
            case 11: {
                pSViewRTMsgBase.resetTitle();
                return true;
            }
            case 12: {
                pSViewRTMsgBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSViewRTMsgBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSViewRTMsgBase getProxyEntity() {
        return this.proxyPSViewRTMsgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSViewRTMsgBase = null;
        if (iDataObject != null && iDataObject instanceof PSViewRTMsgBase) {
            this.proxyPSViewRTMsgBase = (PSViewRTMsgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSViewRTMsgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MAINCAT, 3);
        fieldIndexMap.put(FIELD_MSGPOS, 4);
        fieldIndexMap.put(FIELD_MSGTYPE, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSVIEWRTMSGID, 7);
        fieldIndexMap.put(FIELD_PSVIEWRTMSGNAME, 8);
        fieldIndexMap.put(FIELD_SRFVIEWID, 9);
        fieldIndexMap.put(FIELD_SUBCAT, 10);
        fieldIndexMap.put(FIELD_TITLE, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

