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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSModelView;
import net.ibizsys.pscore.srv.config.service.PSModelViewService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelSubViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelSubViewBase.class);
    public static final String FIELD_BOTTOMCONTENT = "BOTTOMCONTENT";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_HEADERCONTENT = "HEADERCONTENT";
    public static final String FIELD_IMAGEFLAG = "IMAGEFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODELSUBVIEWID = "PSMODELSUBVIEWID";
    public static final String FIELD_PSMODELSUBVIEWNAME = "PSMODELSUBVIEWNAME";
    public static final String FIELD_PSMODELVIEWID = "PSMODELVIEWID";
    public static final String FIELD_PSMODELVIEWNAME = "PSMODELVIEWNAME";
    public static final String FIELD_SUBVIEWDESC = "SUBVIEWDESC";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BOTTOMCONTENT = 0;
    private static final int INDEX_CONTENT = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_HEADERCONTENT = 4;
    private static final int INDEX_IMAGEFLAG = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_ORDERVALUE = 7;
    private static final int INDEX_PSMODELSUBVIEWID = 8;
    private static final int INDEX_PSMODELSUBVIEWNAME = 9;
    private static final int INDEX_PSMODELVIEWID = 10;
    private static final int INDEX_PSMODELVIEWNAME = 11;
    private static final int INDEX_SUBVIEWDESC = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelSubViewBase proxyPSModelSubViewBase = null;
    private boolean bottomcontentDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean headercontentDirtyFlag = false;
    private boolean imageflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmodelsubviewidDirtyFlag = false;
    private boolean psmodelsubviewnameDirtyFlag = false;
    private boolean psmodelviewidDirtyFlag = false;
    private boolean psmodelviewnameDirtyFlag = false;
    private boolean subviewdescDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="bottomcontent")
    private String bottomcontent;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="headercontent")
    private String headercontent;
    @Column(name="imageflag")
    private Integer imageflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmodelsubviewid")
    private String psmodelsubviewid;
    @Column(name="psmodelsubviewname")
    private String psmodelsubviewname;
    @Column(name="psmodelviewid")
    private String psmodelviewid;
    @Column(name="psmodelviewname")
    private String psmodelviewname;
    @Column(name="subviewdesc")
    private String subviewdesc;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSModelViewLock = new Integer(1);
    private PSModelView psmodelview = null;

    public void setBottomContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBottomContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bottomcontent = string;
        this.bottomcontentDirtyFlag = true;
    }

    public String getBottomContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBottomContent();
        }
        return this.bottomcontent;
    }

    public boolean isBottomContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBottomContentDirty();
        }
        return this.bottomcontentDirtyFlag;
    }

    public void resetBottomContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBottomContent();
            return;
        }
        this.bottomcontentDirtyFlag = false;
        this.bottomcontent = null;
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

    public void setHeaderContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeaderContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.headercontent = string;
        this.headercontentDirtyFlag = true;
    }

    public String getHeaderContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderContent();
        }
        return this.headercontent;
    }

    public boolean isHeaderContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeaderContentDirty();
        }
        return this.headercontentDirtyFlag;
    }

    public void resetHeaderContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeaderContent();
            return;
        }
        this.headercontentDirtyFlag = false;
        this.headercontent = null;
    }

    public void setImageFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImageFlag(n);
            return;
        }
        this.imageflag = n;
        this.imageflagDirtyFlag = true;
    }

    public Integer getImageFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImageFlag();
        }
        return this.imageflag;
    }

    public boolean isImageFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImageFlagDirty();
        }
        return this.imageflagDirtyFlag;
    }

    public void resetImageFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImageFlag();
            return;
        }
        this.imageflagDirtyFlag = false;
        this.imageflag = null;
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

    public void setPSModelSubViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelSubViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelsubviewid = string;
        this.psmodelsubviewidDirtyFlag = true;
    }

    public String getPSModelSubViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelSubViewId();
        }
        return this.psmodelsubviewid;
    }

    public boolean isPSModelSubViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelSubViewIdDirty();
        }
        return this.psmodelsubviewidDirtyFlag;
    }

    public void resetPSModelSubViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelSubViewId();
            return;
        }
        this.psmodelsubviewidDirtyFlag = false;
        this.psmodelsubviewid = null;
    }

    public void setPSModelSubViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelSubViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelsubviewname = string;
        this.psmodelsubviewnameDirtyFlag = true;
    }

    public String getPSModelSubViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelSubViewName();
        }
        return this.psmodelsubviewname;
    }

    public boolean isPSModelSubViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelSubViewNameDirty();
        }
        return this.psmodelsubviewnameDirtyFlag;
    }

    public void resetPSModelSubViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelSubViewName();
            return;
        }
        this.psmodelsubviewnameDirtyFlag = false;
        this.psmodelsubviewname = null;
    }

    public void setPSModelViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelviewid = string;
        this.psmodelviewidDirtyFlag = true;
    }

    public String getPSModelViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelViewId();
        }
        return this.psmodelviewid;
    }

    public boolean isPSModelViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelViewIdDirty();
        }
        return this.psmodelviewidDirtyFlag;
    }

    public void resetPSModelViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelViewId();
            return;
        }
        this.psmodelviewidDirtyFlag = false;
        this.psmodelviewid = null;
    }

    public void setPSModelViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelviewname = string;
        this.psmodelviewnameDirtyFlag = true;
    }

    public String getPSModelViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelViewName();
        }
        return this.psmodelviewname;
    }

    public boolean isPSModelViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelViewNameDirty();
        }
        return this.psmodelviewnameDirtyFlag;
    }

    public void resetPSModelViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelViewName();
            return;
        }
        this.psmodelviewnameDirtyFlag = false;
        this.psmodelviewname = null;
    }

    public void setSubViewDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubViewDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subviewdesc = string;
        this.subviewdescDirtyFlag = true;
    }

    public String getSubViewDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubViewDesc();
        }
        return this.subviewdesc;
    }

    public boolean isSubViewDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubViewDescDirty();
        }
        return this.subviewdescDirtyFlag;
    }

    public void resetSubViewDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubViewDesc();
            return;
        }
        this.subviewdescDirtyFlag = false;
        this.subviewdesc = null;
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
        PSModelSubViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelSubViewBase pSModelSubViewBase) {
        pSModelSubViewBase.resetBottomContent();
        pSModelSubViewBase.resetContent();
        pSModelSubViewBase.resetCreateDate();
        pSModelSubViewBase.resetCreateMan();
        pSModelSubViewBase.resetHeaderContent();
        pSModelSubViewBase.resetImageFlag();
        pSModelSubViewBase.resetMemo();
        pSModelSubViewBase.resetOrderValue();
        pSModelSubViewBase.resetPSModelSubViewId();
        pSModelSubViewBase.resetPSModelSubViewName();
        pSModelSubViewBase.resetPSModelViewId();
        pSModelSubViewBase.resetPSModelViewName();
        pSModelSubViewBase.resetSubViewDesc();
        pSModelSubViewBase.resetUpdateDate();
        pSModelSubViewBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBottomContentDirty()) {
            hashMap.put(FIELD_BOTTOMCONTENT, this.getBottomContent());
        }
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isHeaderContentDirty()) {
            hashMap.put(FIELD_HEADERCONTENT, this.getHeaderContent());
        }
        if (!bl || this.isImageFlagDirty()) {
            hashMap.put(FIELD_IMAGEFLAG, this.getImageFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSModelSubViewIdDirty()) {
            hashMap.put(FIELD_PSMODELSUBVIEWID, this.getPSModelSubViewId());
        }
        if (!bl || this.isPSModelSubViewNameDirty()) {
            hashMap.put(FIELD_PSMODELSUBVIEWNAME, this.getPSModelSubViewName());
        }
        if (!bl || this.isPSModelViewIdDirty()) {
            hashMap.put(FIELD_PSMODELVIEWID, this.getPSModelViewId());
        }
        if (!bl || this.isPSModelViewNameDirty()) {
            hashMap.put(FIELD_PSMODELVIEWNAME, this.getPSModelViewName());
        }
        if (!bl || this.isSubViewDescDirty()) {
            hashMap.put(FIELD_SUBVIEWDESC, this.getSubViewDesc());
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
        return PSModelSubViewBase.get(this, n);
    }

    private static Object get(PSModelSubViewBase pSModelSubViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelSubViewBase.getBottomContent();
            }
            case 1: {
                return pSModelSubViewBase.getContent();
            }
            case 2: {
                return pSModelSubViewBase.getCreateDate();
            }
            case 3: {
                return pSModelSubViewBase.getCreateMan();
            }
            case 4: {
                return pSModelSubViewBase.getHeaderContent();
            }
            case 5: {
                return pSModelSubViewBase.getImageFlag();
            }
            case 6: {
                return pSModelSubViewBase.getMemo();
            }
            case 7: {
                return pSModelSubViewBase.getOrderValue();
            }
            case 8: {
                return pSModelSubViewBase.getPSModelSubViewId();
            }
            case 9: {
                return pSModelSubViewBase.getPSModelSubViewName();
            }
            case 10: {
                return pSModelSubViewBase.getPSModelViewId();
            }
            case 11: {
                return pSModelSubViewBase.getPSModelViewName();
            }
            case 12: {
                return pSModelSubViewBase.getSubViewDesc();
            }
            case 13: {
                return pSModelSubViewBase.getUpdateDate();
            }
            case 14: {
                return pSModelSubViewBase.getUpdateMan();
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
        PSModelSubViewBase.set(this, n, object);
    }

    private static void set(PSModelSubViewBase pSModelSubViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelSubViewBase.setBottomContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModelSubViewBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelSubViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSModelSubViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelSubViewBase.setHeaderContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelSubViewBase.setImageFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSModelSubViewBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelSubViewBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSModelSubViewBase.setPSModelSubViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelSubViewBase.setPSModelSubViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelSubViewBase.setPSModelViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelSubViewBase.setPSModelViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelSubViewBase.setSubViewDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelSubViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSModelSubViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelSubViewBase.isNull(this, n);
    }

    private static boolean isNull(PSModelSubViewBase pSModelSubViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelSubViewBase.getBottomContent() == null;
            }
            case 1: {
                return pSModelSubViewBase.getContent() == null;
            }
            case 2: {
                return pSModelSubViewBase.getCreateDate() == null;
            }
            case 3: {
                return pSModelSubViewBase.getCreateMan() == null;
            }
            case 4: {
                return pSModelSubViewBase.getHeaderContent() == null;
            }
            case 5: {
                return pSModelSubViewBase.getImageFlag() == null;
            }
            case 6: {
                return pSModelSubViewBase.getMemo() == null;
            }
            case 7: {
                return pSModelSubViewBase.getOrderValue() == null;
            }
            case 8: {
                return pSModelSubViewBase.getPSModelSubViewId() == null;
            }
            case 9: {
                return pSModelSubViewBase.getPSModelSubViewName() == null;
            }
            case 10: {
                return pSModelSubViewBase.getPSModelViewId() == null;
            }
            case 11: {
                return pSModelSubViewBase.getPSModelViewName() == null;
            }
            case 12: {
                return pSModelSubViewBase.getSubViewDesc() == null;
            }
            case 13: {
                return pSModelSubViewBase.getUpdateDate() == null;
            }
            case 14: {
                return pSModelSubViewBase.getUpdateMan() == null;
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
        return PSModelSubViewBase.contains(this, n);
    }

    private static boolean contains(PSModelSubViewBase pSModelSubViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelSubViewBase.isBottomContentDirty();
            }
            case 1: {
                return pSModelSubViewBase.isContentDirty();
            }
            case 2: {
                return pSModelSubViewBase.isCreateDateDirty();
            }
            case 3: {
                return pSModelSubViewBase.isCreateManDirty();
            }
            case 4: {
                return pSModelSubViewBase.isHeaderContentDirty();
            }
            case 5: {
                return pSModelSubViewBase.isImageFlagDirty();
            }
            case 6: {
                return pSModelSubViewBase.isMemoDirty();
            }
            case 7: {
                return pSModelSubViewBase.isOrderValueDirty();
            }
            case 8: {
                return pSModelSubViewBase.isPSModelSubViewIdDirty();
            }
            case 9: {
                return pSModelSubViewBase.isPSModelSubViewNameDirty();
            }
            case 10: {
                return pSModelSubViewBase.isPSModelViewIdDirty();
            }
            case 11: {
                return pSModelSubViewBase.isPSModelViewNameDirty();
            }
            case 12: {
                return pSModelSubViewBase.isSubViewDescDirty();
            }
            case 13: {
                return pSModelSubViewBase.isUpdateDateDirty();
            }
            case 14: {
                return pSModelSubViewBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelSubViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelSubViewBase pSModelSubViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelSubViewBase.getBottomContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottomcontent", (Object)PSModelSubViewBase.getJSONValue((Object)pSModelSubViewBase.getBottomContent()), (boolean)false);
        }
        if (bl || pSModelSubViewBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSModelSubViewBase.getJSONValue((Object)pSModelSubViewBase.getContent()), (boolean)false);
        }
        if (bl || pSModelSubViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelSubViewBase.getJSONValue((Object)pSModelSubViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelSubViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelSubViewBase.getJSONValue((Object)pSModelSubViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelSubViewBase.getHeaderContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headercontent", (Object)PSModelSubViewBase.getJSONValue((Object)pSModelSubViewBase.getHeaderContent()), (boolean)false);
        }
        if (bl || pSModelSubViewBase.getImageFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imageflag", (Object)PSModelSubViewBase.getJSONValue((Object)pSModelSubViewBase.getImageFlag()), (boolean)false);
        }
        if (bl || pSModelSubViewBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelSubViewBase.getJSONValue((Object)pSModelSubViewBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelSubViewBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModelSubViewBase.getJSONValue((Object)pSModelSubViewBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModelSubViewBase.getPSModelSubViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelsubviewid", (Object)PSModelSubViewBase.getJSONValue((Object)pSModelSubViewBase.getPSModelSubViewId()), (boolean)false);
        }
        if (bl || pSModelSubViewBase.getPSModelSubViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelsubviewname", (Object)PSModelSubViewBase.getJSONValue((Object)pSModelSubViewBase.getPSModelSubViewName()), (boolean)false);
        }
        if (bl || pSModelSubViewBase.getPSModelViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelviewid", (Object)PSModelSubViewBase.getJSONValue((Object)pSModelSubViewBase.getPSModelViewId()), (boolean)false);
        }
        if (bl || pSModelSubViewBase.getPSModelViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelviewname", (Object)PSModelSubViewBase.getJSONValue((Object)pSModelSubViewBase.getPSModelViewName()), (boolean)false);
        }
        if (bl || pSModelSubViewBase.getSubViewDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subviewdesc", (Object)PSModelSubViewBase.getJSONValue((Object)pSModelSubViewBase.getSubViewDesc()), (boolean)false);
        }
        if (bl || pSModelSubViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelSubViewBase.getJSONValue((Object)pSModelSubViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelSubViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelSubViewBase.getJSONValue((Object)pSModelSubViewBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelSubViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelSubViewBase pSModelSubViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelSubViewBase.getBottomContent() != null) {
            object = pSModelSubViewBase.getBottomContent();
            xmlNode.setAttribute(FIELD_BOTTOMCONTENT, (String)(object == null ? "" : object));
        }
        if (bl || pSModelSubViewBase.getContent() != null) {
            object = pSModelSubViewBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelSubViewBase.getCreateDate() != null) {
            object = pSModelSubViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelSubViewBase.getCreateMan() != null) {
            object = pSModelSubViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelSubViewBase.getHeaderContent() != null) {
            object = pSModelSubViewBase.getHeaderContent();
            xmlNode.setAttribute(FIELD_HEADERCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelSubViewBase.getImageFlag() != null) {
            object = pSModelSubViewBase.getImageFlag();
            xmlNode.setAttribute(FIELD_IMAGEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelSubViewBase.getMemo() != null) {
            object = pSModelSubViewBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelSubViewBase.getOrderValue() != null) {
            object = pSModelSubViewBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelSubViewBase.getPSModelSubViewId() != null) {
            object = pSModelSubViewBase.getPSModelSubViewId();
            xmlNode.setAttribute(FIELD_PSMODELSUBVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSModelSubViewBase.getPSModelSubViewName() != null) {
            object = pSModelSubViewBase.getPSModelSubViewName();
            xmlNode.setAttribute(FIELD_PSMODELSUBVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelSubViewBase.getPSModelViewId() != null) {
            object = pSModelSubViewBase.getPSModelViewId();
            xmlNode.setAttribute(FIELD_PSMODELVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSModelSubViewBase.getPSModelViewName() != null) {
            object = pSModelSubViewBase.getPSModelViewName();
            xmlNode.setAttribute(FIELD_PSMODELVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelSubViewBase.getSubViewDesc() != null) {
            object = pSModelSubViewBase.getSubViewDesc();
            xmlNode.setAttribute(FIELD_SUBVIEWDESC, object == null ? "" : (String)object);
        }
        if (bl || pSModelSubViewBase.getUpdateDate() != null) {
            object = pSModelSubViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelSubViewBase.getUpdateMan() != null) {
            object = pSModelSubViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelSubViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelSubViewBase pSModelSubViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelSubViewBase.isBottomContentDirty() && (bl || pSModelSubViewBase.getBottomContent() != null)) {
            iDataObject.set(FIELD_BOTTOMCONTENT, (Object)pSModelSubViewBase.getBottomContent());
        }
        if (pSModelSubViewBase.isContentDirty() && (bl || pSModelSubViewBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSModelSubViewBase.getContent());
        }
        if (pSModelSubViewBase.isCreateDateDirty() && (bl || pSModelSubViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelSubViewBase.getCreateDate());
        }
        if (pSModelSubViewBase.isCreateManDirty() && (bl || pSModelSubViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelSubViewBase.getCreateMan());
        }
        if (pSModelSubViewBase.isHeaderContentDirty() && (bl || pSModelSubViewBase.getHeaderContent() != null)) {
            iDataObject.set(FIELD_HEADERCONTENT, (Object)pSModelSubViewBase.getHeaderContent());
        }
        if (pSModelSubViewBase.isImageFlagDirty() && (bl || pSModelSubViewBase.getImageFlag() != null)) {
            iDataObject.set(FIELD_IMAGEFLAG, (Object)pSModelSubViewBase.getImageFlag());
        }
        if (pSModelSubViewBase.isMemoDirty() && (bl || pSModelSubViewBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelSubViewBase.getMemo());
        }
        if (pSModelSubViewBase.isOrderValueDirty() && (bl || pSModelSubViewBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModelSubViewBase.getOrderValue());
        }
        if (pSModelSubViewBase.isPSModelSubViewIdDirty() && (bl || pSModelSubViewBase.getPSModelSubViewId() != null)) {
            iDataObject.set(FIELD_PSMODELSUBVIEWID, (Object)pSModelSubViewBase.getPSModelSubViewId());
        }
        if (pSModelSubViewBase.isPSModelSubViewNameDirty() && (bl || pSModelSubViewBase.getPSModelSubViewName() != null)) {
            iDataObject.set(FIELD_PSMODELSUBVIEWNAME, (Object)pSModelSubViewBase.getPSModelSubViewName());
        }
        if (pSModelSubViewBase.isPSModelViewIdDirty() && (bl || pSModelSubViewBase.getPSModelViewId() != null)) {
            iDataObject.set(FIELD_PSMODELVIEWID, (Object)pSModelSubViewBase.getPSModelViewId());
        }
        if (pSModelSubViewBase.isPSModelViewNameDirty() && (bl || pSModelSubViewBase.getPSModelViewName() != null)) {
            iDataObject.set(FIELD_PSMODELVIEWNAME, (Object)pSModelSubViewBase.getPSModelViewName());
        }
        if (pSModelSubViewBase.isSubViewDescDirty() && (bl || pSModelSubViewBase.getSubViewDesc() != null)) {
            iDataObject.set(FIELD_SUBVIEWDESC, (Object)pSModelSubViewBase.getSubViewDesc());
        }
        if (pSModelSubViewBase.isUpdateDateDirty() && (bl || pSModelSubViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelSubViewBase.getUpdateDate());
        }
        if (pSModelSubViewBase.isUpdateManDirty() && (bl || pSModelSubViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelSubViewBase.getUpdateMan());
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
        return PSModelSubViewBase.remove(this, n);
    }

    private static boolean remove(PSModelSubViewBase pSModelSubViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelSubViewBase.resetBottomContent();
                return true;
            }
            case 1: {
                pSModelSubViewBase.resetContent();
                return true;
            }
            case 2: {
                pSModelSubViewBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSModelSubViewBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSModelSubViewBase.resetHeaderContent();
                return true;
            }
            case 5: {
                pSModelSubViewBase.resetImageFlag();
                return true;
            }
            case 6: {
                pSModelSubViewBase.resetMemo();
                return true;
            }
            case 7: {
                pSModelSubViewBase.resetOrderValue();
                return true;
            }
            case 8: {
                pSModelSubViewBase.resetPSModelSubViewId();
                return true;
            }
            case 9: {
                pSModelSubViewBase.resetPSModelSubViewName();
                return true;
            }
            case 10: {
                pSModelSubViewBase.resetPSModelViewId();
                return true;
            }
            case 11: {
                pSModelSubViewBase.resetPSModelViewName();
                return true;
            }
            case 12: {
                pSModelSubViewBase.resetSubViewDesc();
                return true;
            }
            case 13: {
                pSModelSubViewBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSModelSubViewBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelView getPSModelView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelView();
        }
        if (this.getPSModelViewId() == null) {
            return null;
        }
        Integer n = this.objPSModelViewLock;
        synchronized (n) {
            if (this.psmodelview != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelViewId(), (Object)this.psmodelview.getPSModelViewId()) != 0L) {
                this.psmodelview = null;
            }
            if (this.psmodelview == null) {
                PSModelView pSModelView = new PSModelView();
                pSModelView.setPSModelViewId(this.getPSModelViewId());
                PSModelViewService pSModelViewService = (PSModelViewService)ServiceGlobal.getService(PSModelViewService.class, (SessionFactory)this.getSessionFactory());
                pSModelViewService.autoGet(pSModelView);
                this.psmodelview = pSModelView;
            }
            return this.psmodelview;
        }
    }

    private PSModelSubViewBase getProxyEntity() {
        return this.proxyPSModelSubViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelSubViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelSubViewBase) {
            this.proxyPSModelSubViewBase = (PSModelSubViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelSubViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BOTTOMCONTENT, 0);
        fieldIndexMap.put(FIELD_CONTENT, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_HEADERCONTENT, 4);
        fieldIndexMap.put(FIELD_IMAGEFLAG, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_ORDERVALUE, 7);
        fieldIndexMap.put(FIELD_PSMODELSUBVIEWID, 8);
        fieldIndexMap.put(FIELD_PSMODELSUBVIEWNAME, 9);
        fieldIndexMap.put(FIELD_PSMODELVIEWID, 10);
        fieldIndexMap.put(FIELD_PSMODELVIEWNAME, 11);
        fieldIndexMap.put(FIELD_SUBVIEWDESC, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

