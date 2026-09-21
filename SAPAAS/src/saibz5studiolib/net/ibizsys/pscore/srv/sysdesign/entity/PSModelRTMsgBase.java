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

public abstract class PSModelRTMsgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelRTMsgBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MAINCAT = "MAINCAT";
    public static final String FIELD_MSGPOS = "MSGPOS";
    public static final String FIELD_MSGTYPE = "MSGTYPE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODELRTMSGID = "PSMODELRTMSGID";
    public static final String FIELD_PSMODELRTMSGNAME = "PSMODELRTMSGNAME";
    public static final String FIELD_SRFDEID = "SRFDEID";
    public static final String FIELD_SRFDERID = "SRFDERID";
    public static final String FIELD_SRFKEY = "SRFKEY";
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
    private static final int INDEX_PSMODELRTMSGID = 7;
    private static final int INDEX_PSMODELRTMSGNAME = 8;
    private static final int INDEX_SRFDEID = 9;
    private static final int INDEX_SRFDERID = 10;
    private static final int INDEX_SRFKEY = 11;
    private static final int INDEX_SUBCAT = 12;
    private static final int INDEX_TITLE = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelRTMsgBase proxyPSModelRTMsgBase = null;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean maincatDirtyFlag = false;
    private boolean msgposDirtyFlag = false;
    private boolean msgtypeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmodelrtmsgidDirtyFlag = false;
    private boolean psmodelrtmsgnameDirtyFlag = false;
    private boolean srfdeidDirtyFlag = false;
    private boolean srfderidDirtyFlag = false;
    private boolean srfkeyDirtyFlag = false;
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
    @Column(name="psmodelrtmsgid")
    private String psmodelrtmsgid;
    @Column(name="psmodelrtmsgname")
    private String psmodelrtmsgname;
    @Column(name="srfdeid")
    private String srfdeid;
    @Column(name="srfderid")
    private String srfderid;
    @Column(name="srfkey")
    private String srfkey;
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

    public void setPSModelRTMsgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelRTMsgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelrtmsgid = string;
        this.psmodelrtmsgidDirtyFlag = true;
    }

    public String getPSModelRTMsgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelRTMsgId();
        }
        return this.psmodelrtmsgid;
    }

    public boolean isPSModelRTMsgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelRTMsgIdDirty();
        }
        return this.psmodelrtmsgidDirtyFlag;
    }

    public void resetPSModelRTMsgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelRTMsgId();
            return;
        }
        this.psmodelrtmsgidDirtyFlag = false;
        this.psmodelrtmsgid = null;
    }

    public void setPSModelRTMsgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelRTMsgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelrtmsgname = string;
        this.psmodelrtmsgnameDirtyFlag = true;
    }

    public String getPSModelRTMsgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelRTMsgName();
        }
        return this.psmodelrtmsgname;
    }

    public boolean isPSModelRTMsgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelRTMsgNameDirty();
        }
        return this.psmodelrtmsgnameDirtyFlag;
    }

    public void resetPSModelRTMsgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelRTMsgName();
            return;
        }
        this.psmodelrtmsgnameDirtyFlag = false;
        this.psmodelrtmsgname = null;
    }

    public void setSRFDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srfdeid = string;
        this.srfdeidDirtyFlag = true;
    }

    public String getSRFDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFDEId();
        }
        return this.srfdeid;
    }

    public boolean isSRFDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFDEIdDirty();
        }
        return this.srfdeidDirtyFlag;
    }

    public void resetSRFDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFDEId();
            return;
        }
        this.srfdeidDirtyFlag = false;
        this.srfdeid = null;
    }

    public void setSRFDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srfderid = string;
        this.srfderidDirtyFlag = true;
    }

    public String getSRFDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFDERId();
        }
        return this.srfderid;
    }

    public boolean isSRFDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFDERIdDirty();
        }
        return this.srfderidDirtyFlag;
    }

    public void resetSRFDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFDERId();
            return;
        }
        this.srfderidDirtyFlag = false;
        this.srfderid = null;
    }

    public void setSRFKey(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFKey(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srfkey = string;
        this.srfkeyDirtyFlag = true;
    }

    public String getSRFKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFKey();
        }
        return this.srfkey;
    }

    public boolean isSRFKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFKeyDirty();
        }
        return this.srfkeyDirtyFlag;
    }

    public void resetSRFKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFKey();
            return;
        }
        this.srfkeyDirtyFlag = false;
        this.srfkey = null;
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
        PSModelRTMsgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelRTMsgBase pSModelRTMsgBase) {
        pSModelRTMsgBase.resetContent();
        pSModelRTMsgBase.resetCreateDate();
        pSModelRTMsgBase.resetCreateMan();
        pSModelRTMsgBase.resetMainCat();
        pSModelRTMsgBase.resetMsgPos();
        pSModelRTMsgBase.resetMsgType();
        pSModelRTMsgBase.resetOrderValue();
        pSModelRTMsgBase.resetPSModelRTMsgId();
        pSModelRTMsgBase.resetPSModelRTMsgName();
        pSModelRTMsgBase.resetSRFDEId();
        pSModelRTMsgBase.resetSRFDERId();
        pSModelRTMsgBase.resetSRFKey();
        pSModelRTMsgBase.resetSubCat();
        pSModelRTMsgBase.resetTitle();
        pSModelRTMsgBase.resetUpdateDate();
        pSModelRTMsgBase.resetUpdateMan();
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
        if (!bl || this.isPSModelRTMsgIdDirty()) {
            hashMap.put(FIELD_PSMODELRTMSGID, this.getPSModelRTMsgId());
        }
        if (!bl || this.isPSModelRTMsgNameDirty()) {
            hashMap.put(FIELD_PSMODELRTMSGNAME, this.getPSModelRTMsgName());
        }
        if (!bl || this.isSRFDEIdDirty()) {
            hashMap.put(FIELD_SRFDEID, this.getSRFDEId());
        }
        if (!bl || this.isSRFDERIdDirty()) {
            hashMap.put(FIELD_SRFDERID, this.getSRFDERId());
        }
        if (!bl || this.isSRFKeyDirty()) {
            hashMap.put(FIELD_SRFKEY, this.getSRFKey());
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
        return PSModelRTMsgBase.get(this, n);
    }

    private static Object get(PSModelRTMsgBase pSModelRTMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelRTMsgBase.getContent();
            }
            case 1: {
                return pSModelRTMsgBase.getCreateDate();
            }
            case 2: {
                return pSModelRTMsgBase.getCreateMan();
            }
            case 3: {
                return pSModelRTMsgBase.getMainCat();
            }
            case 4: {
                return pSModelRTMsgBase.getMsgPos();
            }
            case 5: {
                return pSModelRTMsgBase.getMsgType();
            }
            case 6: {
                return pSModelRTMsgBase.getOrderValue();
            }
            case 7: {
                return pSModelRTMsgBase.getPSModelRTMsgId();
            }
            case 8: {
                return pSModelRTMsgBase.getPSModelRTMsgName();
            }
            case 9: {
                return pSModelRTMsgBase.getSRFDEId();
            }
            case 10: {
                return pSModelRTMsgBase.getSRFDERId();
            }
            case 11: {
                return pSModelRTMsgBase.getSRFKey();
            }
            case 12: {
                return pSModelRTMsgBase.getSubCat();
            }
            case 13: {
                return pSModelRTMsgBase.getTitle();
            }
            case 14: {
                return pSModelRTMsgBase.getUpdateDate();
            }
            case 15: {
                return pSModelRTMsgBase.getUpdateMan();
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
        PSModelRTMsgBase.set(this, n, object);
    }

    private static void set(PSModelRTMsgBase pSModelRTMsgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelRTMsgBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModelRTMsgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSModelRTMsgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelRTMsgBase.setMainCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelRTMsgBase.setMsgPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelRTMsgBase.setMsgType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelRTMsgBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSModelRTMsgBase.setPSModelRTMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelRTMsgBase.setPSModelRTMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelRTMsgBase.setSRFDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelRTMsgBase.setSRFDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelRTMsgBase.setSRFKey(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelRTMsgBase.setSubCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelRTMsgBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelRTMsgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSModelRTMsgBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelRTMsgBase.isNull(this, n);
    }

    private static boolean isNull(PSModelRTMsgBase pSModelRTMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelRTMsgBase.getContent() == null;
            }
            case 1: {
                return pSModelRTMsgBase.getCreateDate() == null;
            }
            case 2: {
                return pSModelRTMsgBase.getCreateMan() == null;
            }
            case 3: {
                return pSModelRTMsgBase.getMainCat() == null;
            }
            case 4: {
                return pSModelRTMsgBase.getMsgPos() == null;
            }
            case 5: {
                return pSModelRTMsgBase.getMsgType() == null;
            }
            case 6: {
                return pSModelRTMsgBase.getOrderValue() == null;
            }
            case 7: {
                return pSModelRTMsgBase.getPSModelRTMsgId() == null;
            }
            case 8: {
                return pSModelRTMsgBase.getPSModelRTMsgName() == null;
            }
            case 9: {
                return pSModelRTMsgBase.getSRFDEId() == null;
            }
            case 10: {
                return pSModelRTMsgBase.getSRFDERId() == null;
            }
            case 11: {
                return pSModelRTMsgBase.getSRFKey() == null;
            }
            case 12: {
                return pSModelRTMsgBase.getSubCat() == null;
            }
            case 13: {
                return pSModelRTMsgBase.getTitle() == null;
            }
            case 14: {
                return pSModelRTMsgBase.getUpdateDate() == null;
            }
            case 15: {
                return pSModelRTMsgBase.getUpdateMan() == null;
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
        return PSModelRTMsgBase.contains(this, n);
    }

    private static boolean contains(PSModelRTMsgBase pSModelRTMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelRTMsgBase.isContentDirty();
            }
            case 1: {
                return pSModelRTMsgBase.isCreateDateDirty();
            }
            case 2: {
                return pSModelRTMsgBase.isCreateManDirty();
            }
            case 3: {
                return pSModelRTMsgBase.isMainCatDirty();
            }
            case 4: {
                return pSModelRTMsgBase.isMsgPosDirty();
            }
            case 5: {
                return pSModelRTMsgBase.isMsgTypeDirty();
            }
            case 6: {
                return pSModelRTMsgBase.isOrderValueDirty();
            }
            case 7: {
                return pSModelRTMsgBase.isPSModelRTMsgIdDirty();
            }
            case 8: {
                return pSModelRTMsgBase.isPSModelRTMsgNameDirty();
            }
            case 9: {
                return pSModelRTMsgBase.isSRFDEIdDirty();
            }
            case 10: {
                return pSModelRTMsgBase.isSRFDERIdDirty();
            }
            case 11: {
                return pSModelRTMsgBase.isSRFKeyDirty();
            }
            case 12: {
                return pSModelRTMsgBase.isSubCatDirty();
            }
            case 13: {
                return pSModelRTMsgBase.isTitleDirty();
            }
            case 14: {
                return pSModelRTMsgBase.isUpdateDateDirty();
            }
            case 15: {
                return pSModelRTMsgBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelRTMsgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelRTMsgBase pSModelRTMsgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelRTMsgBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getContent()), (boolean)false);
        }
        if (bl || pSModelRTMsgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelRTMsgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelRTMsgBase.getMainCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maincat", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getMainCat()), (boolean)false);
        }
        if (bl || pSModelRTMsgBase.getMsgPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgpos", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getMsgPos()), (boolean)false);
        }
        if (bl || pSModelRTMsgBase.getMsgType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgtype", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getMsgType()), (boolean)false);
        }
        if (bl || pSModelRTMsgBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModelRTMsgBase.getPSModelRTMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelrtmsgid", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getPSModelRTMsgId()), (boolean)false);
        }
        if (bl || pSModelRTMsgBase.getPSModelRTMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelrtmsgname", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getPSModelRTMsgName()), (boolean)false);
        }
        if (bl || pSModelRTMsgBase.getSRFDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfdeid", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getSRFDEId()), (boolean)false);
        }
        if (bl || pSModelRTMsgBase.getSRFDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfderid", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getSRFDERId()), (boolean)false);
        }
        if (bl || pSModelRTMsgBase.getSRFKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfkey", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getSRFKey()), (boolean)false);
        }
        if (bl || pSModelRTMsgBase.getSubCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subcat", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getSubCat()), (boolean)false);
        }
        if (bl || pSModelRTMsgBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getTitle()), (boolean)false);
        }
        if (bl || pSModelRTMsgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelRTMsgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelRTMsgBase.getJSONValue((Object)pSModelRTMsgBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelRTMsgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelRTMsgBase pSModelRTMsgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelRTMsgBase.getContent() != null) {
            object = pSModelRTMsgBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTMsgBase.getCreateDate() != null) {
            object = pSModelRTMsgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelRTMsgBase.getCreateMan() != null) {
            object = pSModelRTMsgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTMsgBase.getMainCat() != null) {
            object = pSModelRTMsgBase.getMainCat();
            xmlNode.setAttribute(FIELD_MAINCAT, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTMsgBase.getMsgPos() != null) {
            object = pSModelRTMsgBase.getMsgPos();
            xmlNode.setAttribute(FIELD_MSGPOS, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTMsgBase.getMsgType() != null) {
            object = pSModelRTMsgBase.getMsgType();
            xmlNode.setAttribute(FIELD_MSGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTMsgBase.getOrderValue() != null) {
            object = pSModelRTMsgBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelRTMsgBase.getPSModelRTMsgId() != null) {
            object = pSModelRTMsgBase.getPSModelRTMsgId();
            xmlNode.setAttribute(FIELD_PSMODELRTMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTMsgBase.getPSModelRTMsgName() != null) {
            object = pSModelRTMsgBase.getPSModelRTMsgName();
            xmlNode.setAttribute(FIELD_PSMODELRTMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTMsgBase.getSRFDEId() != null) {
            object = pSModelRTMsgBase.getSRFDEId();
            xmlNode.setAttribute(FIELD_SRFDEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTMsgBase.getSRFDERId() != null) {
            object = pSModelRTMsgBase.getSRFDERId();
            xmlNode.setAttribute(FIELD_SRFDERID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTMsgBase.getSRFKey() != null) {
            object = pSModelRTMsgBase.getSRFKey();
            xmlNode.setAttribute(FIELD_SRFKEY, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTMsgBase.getSubCat() != null) {
            object = pSModelRTMsgBase.getSubCat();
            xmlNode.setAttribute(FIELD_SUBCAT, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTMsgBase.getTitle() != null) {
            object = pSModelRTMsgBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTMsgBase.getUpdateDate() != null) {
            object = pSModelRTMsgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelRTMsgBase.getUpdateMan() != null) {
            object = pSModelRTMsgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelRTMsgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelRTMsgBase pSModelRTMsgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelRTMsgBase.isContentDirty() && (bl || pSModelRTMsgBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSModelRTMsgBase.getContent());
        }
        if (pSModelRTMsgBase.isCreateDateDirty() && (bl || pSModelRTMsgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelRTMsgBase.getCreateDate());
        }
        if (pSModelRTMsgBase.isCreateManDirty() && (bl || pSModelRTMsgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelRTMsgBase.getCreateMan());
        }
        if (pSModelRTMsgBase.isMainCatDirty() && (bl || pSModelRTMsgBase.getMainCat() != null)) {
            iDataObject.set(FIELD_MAINCAT, (Object)pSModelRTMsgBase.getMainCat());
        }
        if (pSModelRTMsgBase.isMsgPosDirty() && (bl || pSModelRTMsgBase.getMsgPos() != null)) {
            iDataObject.set(FIELD_MSGPOS, (Object)pSModelRTMsgBase.getMsgPos());
        }
        if (pSModelRTMsgBase.isMsgTypeDirty() && (bl || pSModelRTMsgBase.getMsgType() != null)) {
            iDataObject.set(FIELD_MSGTYPE, (Object)pSModelRTMsgBase.getMsgType());
        }
        if (pSModelRTMsgBase.isOrderValueDirty() && (bl || pSModelRTMsgBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModelRTMsgBase.getOrderValue());
        }
        if (pSModelRTMsgBase.isPSModelRTMsgIdDirty() && (bl || pSModelRTMsgBase.getPSModelRTMsgId() != null)) {
            iDataObject.set(FIELD_PSMODELRTMSGID, (Object)pSModelRTMsgBase.getPSModelRTMsgId());
        }
        if (pSModelRTMsgBase.isPSModelRTMsgNameDirty() && (bl || pSModelRTMsgBase.getPSModelRTMsgName() != null)) {
            iDataObject.set(FIELD_PSMODELRTMSGNAME, (Object)pSModelRTMsgBase.getPSModelRTMsgName());
        }
        if (pSModelRTMsgBase.isSRFDEIdDirty() && (bl || pSModelRTMsgBase.getSRFDEId() != null)) {
            iDataObject.set(FIELD_SRFDEID, (Object)pSModelRTMsgBase.getSRFDEId());
        }
        if (pSModelRTMsgBase.isSRFDERIdDirty() && (bl || pSModelRTMsgBase.getSRFDERId() != null)) {
            iDataObject.set(FIELD_SRFDERID, (Object)pSModelRTMsgBase.getSRFDERId());
        }
        if (pSModelRTMsgBase.isSRFKeyDirty() && (bl || pSModelRTMsgBase.getSRFKey() != null)) {
            iDataObject.set(FIELD_SRFKEY, (Object)pSModelRTMsgBase.getSRFKey());
        }
        if (pSModelRTMsgBase.isSubCatDirty() && (bl || pSModelRTMsgBase.getSubCat() != null)) {
            iDataObject.set(FIELD_SUBCAT, (Object)pSModelRTMsgBase.getSubCat());
        }
        if (pSModelRTMsgBase.isTitleDirty() && (bl || pSModelRTMsgBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSModelRTMsgBase.getTitle());
        }
        if (pSModelRTMsgBase.isUpdateDateDirty() && (bl || pSModelRTMsgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelRTMsgBase.getUpdateDate());
        }
        if (pSModelRTMsgBase.isUpdateManDirty() && (bl || pSModelRTMsgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelRTMsgBase.getUpdateMan());
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
        return PSModelRTMsgBase.remove(this, n);
    }

    private static boolean remove(PSModelRTMsgBase pSModelRTMsgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelRTMsgBase.resetContent();
                return true;
            }
            case 1: {
                pSModelRTMsgBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSModelRTMsgBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSModelRTMsgBase.resetMainCat();
                return true;
            }
            case 4: {
                pSModelRTMsgBase.resetMsgPos();
                return true;
            }
            case 5: {
                pSModelRTMsgBase.resetMsgType();
                return true;
            }
            case 6: {
                pSModelRTMsgBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSModelRTMsgBase.resetPSModelRTMsgId();
                return true;
            }
            case 8: {
                pSModelRTMsgBase.resetPSModelRTMsgName();
                return true;
            }
            case 9: {
                pSModelRTMsgBase.resetSRFDEId();
                return true;
            }
            case 10: {
                pSModelRTMsgBase.resetSRFDERId();
                return true;
            }
            case 11: {
                pSModelRTMsgBase.resetSRFKey();
                return true;
            }
            case 12: {
                pSModelRTMsgBase.resetSubCat();
                return true;
            }
            case 13: {
                pSModelRTMsgBase.resetTitle();
                return true;
            }
            case 14: {
                pSModelRTMsgBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSModelRTMsgBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSModelRTMsgBase getProxyEntity() {
        return this.proxyPSModelRTMsgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelRTMsgBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelRTMsgBase) {
            this.proxyPSModelRTMsgBase = (PSModelRTMsgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModelRTMsgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSMODELRTMSGID, 7);
        fieldIndexMap.put(FIELD_PSMODELRTMSGNAME, 8);
        fieldIndexMap.put(FIELD_SRFDEID, 9);
        fieldIndexMap.put(FIELD_SRFDERID, 10);
        fieldIndexMap.put(FIELD_SRFKEY, 11);
        fieldIndexMap.put(FIELD_SUBCAT, 12);
        fieldIndexMap.put(FIELD_TITLE, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
    }
}

