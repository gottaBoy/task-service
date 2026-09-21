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
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelUIActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelUIActionBase.class);
    public static final String FIELD_BOTTOMCONTENT = "BOTTOMCONTENT";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_HEADERCONTENT = "HEADERCONTENT";
    public static final String FIELD_IMAGEFLAG = "IMAGEFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_PSMODELUIACTIONID = "PSMODELUIACTIONID";
    public static final String FIELD_PSMODELUIACTIONNAME = "PSMODELUIACTIONNAME";
    public static final String FIELD_UIACTIONDESC = "UIACTIONDESC";
    public static final String FIELD_UIACTIONTAG = "UIACTIONTAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BOTTOMCONTENT = 0;
    private static final int INDEX_CONTENT = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_HEADERCONTENT = 4;
    private static final int INDEX_IMAGEFLAG = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_ORDERVALUE = 7;
    private static final int INDEX_PSMODELID = 8;
    private static final int INDEX_PSMODELNAME = 9;
    private static final int INDEX_PSMODELUIACTIONID = 10;
    private static final int INDEX_PSMODELUIACTIONNAME = 11;
    private static final int INDEX_UIACTIONDESC = 12;
    private static final int INDEX_UIACTIONTAG = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_VALIDFLAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelUIActionBase proxyPSModelUIActionBase = null;
    private boolean bottomcontentDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean headercontentDirtyFlag = false;
    private boolean imageflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean psmodeluiactionidDirtyFlag = false;
    private boolean psmodeluiactionnameDirtyFlag = false;
    private boolean uiactiondescDirtyFlag = false;
    private boolean uiactiontagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
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
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="psmodeluiactionid")
    private String psmodeluiactionid;
    @Column(name="psmodeluiactionname")
    private String psmodeluiactionname;
    @Column(name="uiactiondesc")
    private String uiactiondesc;
    @Column(name="uiactiontag")
    private String uiactiontag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSModelLock = new Integer(1);
    private PSModel psmodel = null;

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

    public void setPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelid = string;
        this.psmodelidDirtyFlag = true;
    }

    public String getPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelId();
        }
        return this.psmodelid;
    }

    public boolean isPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelIdDirty();
        }
        return this.psmodelidDirtyFlag;
    }

    public void resetPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelId();
            return;
        }
        this.psmodelidDirtyFlag = false;
        this.psmodelid = null;
    }

    public void setPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelname = string;
        this.psmodelnameDirtyFlag = true;
    }

    public String getPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelName();
        }
        return this.psmodelname;
    }

    public boolean isPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelNameDirty();
        }
        return this.psmodelnameDirtyFlag;
    }

    public void resetPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelName();
            return;
        }
        this.psmodelnameDirtyFlag = false;
        this.psmodelname = null;
    }

    public void setPSModelUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodeluiactionid = string;
        this.psmodeluiactionidDirtyFlag = true;
    }

    public String getPSModelUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelUIActionId();
        }
        return this.psmodeluiactionid;
    }

    public boolean isPSModelUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelUIActionIdDirty();
        }
        return this.psmodeluiactionidDirtyFlag;
    }

    public void resetPSModelUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelUIActionId();
            return;
        }
        this.psmodeluiactionidDirtyFlag = false;
        this.psmodeluiactionid = null;
    }

    public void setPSModelUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodeluiactionname = string;
        this.psmodeluiactionnameDirtyFlag = true;
    }

    public String getPSModelUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelUIActionName();
        }
        return this.psmodeluiactionname;
    }

    public boolean isPSModelUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelUIActionNameDirty();
        }
        return this.psmodeluiactionnameDirtyFlag;
    }

    public void resetPSModelUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelUIActionName();
            return;
        }
        this.psmodeluiactionnameDirtyFlag = false;
        this.psmodeluiactionname = null;
    }

    public void setUIActionDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uiactiondesc = string;
        this.uiactiondescDirtyFlag = true;
    }

    public String getUIActionDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionDesc();
        }
        return this.uiactiondesc;
    }

    public boolean isUIActionDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionDescDirty();
        }
        return this.uiactiondescDirtyFlag;
    }

    public void resetUIActionDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionDesc();
            return;
        }
        this.uiactiondescDirtyFlag = false;
        this.uiactiondesc = null;
    }

    public void setUIActionTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uiactiontag = string;
        this.uiactiontagDirtyFlag = true;
    }

    public String getUIActionTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionTag();
        }
        return this.uiactiontag;
    }

    public boolean isUIActionTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionTagDirty();
        }
        return this.uiactiontagDirtyFlag;
    }

    public void resetUIActionTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionTag();
            return;
        }
        this.uiactiontagDirtyFlag = false;
        this.uiactiontag = null;
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
        PSModelUIActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelUIActionBase pSModelUIActionBase) {
        pSModelUIActionBase.resetBottomContent();
        pSModelUIActionBase.resetContent();
        pSModelUIActionBase.resetCreateDate();
        pSModelUIActionBase.resetCreateMan();
        pSModelUIActionBase.resetHeaderContent();
        pSModelUIActionBase.resetImageFlag();
        pSModelUIActionBase.resetMemo();
        pSModelUIActionBase.resetOrderValue();
        pSModelUIActionBase.resetPSModelId();
        pSModelUIActionBase.resetPSModelName();
        pSModelUIActionBase.resetPSModelUIActionId();
        pSModelUIActionBase.resetPSModelUIActionName();
        pSModelUIActionBase.resetUIActionDesc();
        pSModelUIActionBase.resetUIActionTag();
        pSModelUIActionBase.resetUpdateDate();
        pSModelUIActionBase.resetUpdateMan();
        pSModelUIActionBase.resetValidFlag();
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
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
        }
        if (!bl || this.isPSModelUIActionIdDirty()) {
            hashMap.put(FIELD_PSMODELUIACTIONID, this.getPSModelUIActionId());
        }
        if (!bl || this.isPSModelUIActionNameDirty()) {
            hashMap.put(FIELD_PSMODELUIACTIONNAME, this.getPSModelUIActionName());
        }
        if (!bl || this.isUIActionDescDirty()) {
            hashMap.put(FIELD_UIACTIONDESC, this.getUIActionDesc());
        }
        if (!bl || this.isUIActionTagDirty()) {
            hashMap.put(FIELD_UIACTIONTAG, this.getUIActionTag());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSModelUIActionBase.get(this, n);
    }

    private static Object get(PSModelUIActionBase pSModelUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelUIActionBase.getBottomContent();
            }
            case 1: {
                return pSModelUIActionBase.getContent();
            }
            case 2: {
                return pSModelUIActionBase.getCreateDate();
            }
            case 3: {
                return pSModelUIActionBase.getCreateMan();
            }
            case 4: {
                return pSModelUIActionBase.getHeaderContent();
            }
            case 5: {
                return pSModelUIActionBase.getImageFlag();
            }
            case 6: {
                return pSModelUIActionBase.getMemo();
            }
            case 7: {
                return pSModelUIActionBase.getOrderValue();
            }
            case 8: {
                return pSModelUIActionBase.getPSModelId();
            }
            case 9: {
                return pSModelUIActionBase.getPSModelName();
            }
            case 10: {
                return pSModelUIActionBase.getPSModelUIActionId();
            }
            case 11: {
                return pSModelUIActionBase.getPSModelUIActionName();
            }
            case 12: {
                return pSModelUIActionBase.getUIActionDesc();
            }
            case 13: {
                return pSModelUIActionBase.getUIActionTag();
            }
            case 14: {
                return pSModelUIActionBase.getUpdateDate();
            }
            case 15: {
                return pSModelUIActionBase.getUpdateMan();
            }
            case 16: {
                return pSModelUIActionBase.getValidFlag();
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
        PSModelUIActionBase.set(this, n, object);
    }

    private static void set(PSModelUIActionBase pSModelUIActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelUIActionBase.setBottomContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModelUIActionBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelUIActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSModelUIActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelUIActionBase.setHeaderContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelUIActionBase.setImageFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSModelUIActionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelUIActionBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSModelUIActionBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelUIActionBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelUIActionBase.setPSModelUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelUIActionBase.setPSModelUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelUIActionBase.setUIActionDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelUIActionBase.setUIActionTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelUIActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSModelUIActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSModelUIActionBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSModelUIActionBase.isNull(this, n);
    }

    private static boolean isNull(PSModelUIActionBase pSModelUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelUIActionBase.getBottomContent() == null;
            }
            case 1: {
                return pSModelUIActionBase.getContent() == null;
            }
            case 2: {
                return pSModelUIActionBase.getCreateDate() == null;
            }
            case 3: {
                return pSModelUIActionBase.getCreateMan() == null;
            }
            case 4: {
                return pSModelUIActionBase.getHeaderContent() == null;
            }
            case 5: {
                return pSModelUIActionBase.getImageFlag() == null;
            }
            case 6: {
                return pSModelUIActionBase.getMemo() == null;
            }
            case 7: {
                return pSModelUIActionBase.getOrderValue() == null;
            }
            case 8: {
                return pSModelUIActionBase.getPSModelId() == null;
            }
            case 9: {
                return pSModelUIActionBase.getPSModelName() == null;
            }
            case 10: {
                return pSModelUIActionBase.getPSModelUIActionId() == null;
            }
            case 11: {
                return pSModelUIActionBase.getPSModelUIActionName() == null;
            }
            case 12: {
                return pSModelUIActionBase.getUIActionDesc() == null;
            }
            case 13: {
                return pSModelUIActionBase.getUIActionTag() == null;
            }
            case 14: {
                return pSModelUIActionBase.getUpdateDate() == null;
            }
            case 15: {
                return pSModelUIActionBase.getUpdateMan() == null;
            }
            case 16: {
                return pSModelUIActionBase.getValidFlag() == null;
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
        return PSModelUIActionBase.contains(this, n);
    }

    private static boolean contains(PSModelUIActionBase pSModelUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelUIActionBase.isBottomContentDirty();
            }
            case 1: {
                return pSModelUIActionBase.isContentDirty();
            }
            case 2: {
                return pSModelUIActionBase.isCreateDateDirty();
            }
            case 3: {
                return pSModelUIActionBase.isCreateManDirty();
            }
            case 4: {
                return pSModelUIActionBase.isHeaderContentDirty();
            }
            case 5: {
                return pSModelUIActionBase.isImageFlagDirty();
            }
            case 6: {
                return pSModelUIActionBase.isMemoDirty();
            }
            case 7: {
                return pSModelUIActionBase.isOrderValueDirty();
            }
            case 8: {
                return pSModelUIActionBase.isPSModelIdDirty();
            }
            case 9: {
                return pSModelUIActionBase.isPSModelNameDirty();
            }
            case 10: {
                return pSModelUIActionBase.isPSModelUIActionIdDirty();
            }
            case 11: {
                return pSModelUIActionBase.isPSModelUIActionNameDirty();
            }
            case 12: {
                return pSModelUIActionBase.isUIActionDescDirty();
            }
            case 13: {
                return pSModelUIActionBase.isUIActionTagDirty();
            }
            case 14: {
                return pSModelUIActionBase.isUpdateDateDirty();
            }
            case 15: {
                return pSModelUIActionBase.isUpdateManDirty();
            }
            case 16: {
                return pSModelUIActionBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelUIActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelUIActionBase pSModelUIActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelUIActionBase.getBottomContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottomcontent", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getBottomContent()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getContent()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getHeaderContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headercontent", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getHeaderContent()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getImageFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imageflag", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getImageFlag()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getPSModelUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodeluiactionid", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getPSModelUIActionId()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getPSModelUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodeluiactionname", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getPSModelUIActionName()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getUIActionDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactiondesc", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getUIActionDesc()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getUIActionTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactiontag", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getUIActionTag()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelUIActionBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelUIActionBase.getJSONValue((Object)pSModelUIActionBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelUIActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelUIActionBase pSModelUIActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelUIActionBase.getBottomContent() != null) {
            object = pSModelUIActionBase.getBottomContent();
            xmlNode.setAttribute(FIELD_BOTTOMCONTENT, (String)(object == null ? "" : object));
        }
        if (bl || pSModelUIActionBase.getContent() != null) {
            object = pSModelUIActionBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelUIActionBase.getCreateDate() != null) {
            object = pSModelUIActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelUIActionBase.getCreateMan() != null) {
            object = pSModelUIActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelUIActionBase.getHeaderContent() != null) {
            object = pSModelUIActionBase.getHeaderContent();
            xmlNode.setAttribute(FIELD_HEADERCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelUIActionBase.getImageFlag() != null) {
            object = pSModelUIActionBase.getImageFlag();
            xmlNode.setAttribute(FIELD_IMAGEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelUIActionBase.getMemo() != null) {
            object = pSModelUIActionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelUIActionBase.getOrderValue() != null) {
            object = pSModelUIActionBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelUIActionBase.getPSModelId() != null) {
            object = pSModelUIActionBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelUIActionBase.getPSModelName() != null) {
            object = pSModelUIActionBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelUIActionBase.getPSModelUIActionId() != null) {
            object = pSModelUIActionBase.getPSModelUIActionId();
            xmlNode.setAttribute(FIELD_PSMODELUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSModelUIActionBase.getPSModelUIActionName() != null) {
            object = pSModelUIActionBase.getPSModelUIActionName();
            xmlNode.setAttribute(FIELD_PSMODELUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelUIActionBase.getUIActionDesc() != null) {
            object = pSModelUIActionBase.getUIActionDesc();
            xmlNode.setAttribute(FIELD_UIACTIONDESC, object == null ? "" : (String)object);
        }
        if (bl || pSModelUIActionBase.getUIActionTag() != null) {
            object = pSModelUIActionBase.getUIActionTag();
            xmlNode.setAttribute(FIELD_UIACTIONTAG, object == null ? "" : (String)object);
        }
        if (bl || pSModelUIActionBase.getUpdateDate() != null) {
            object = pSModelUIActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelUIActionBase.getUpdateMan() != null) {
            object = pSModelUIActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelUIActionBase.getValidFlag() != null) {
            object = pSModelUIActionBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelUIActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelUIActionBase pSModelUIActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelUIActionBase.isBottomContentDirty() && (bl || pSModelUIActionBase.getBottomContent() != null)) {
            iDataObject.set(FIELD_BOTTOMCONTENT, (Object)pSModelUIActionBase.getBottomContent());
        }
        if (pSModelUIActionBase.isContentDirty() && (bl || pSModelUIActionBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSModelUIActionBase.getContent());
        }
        if (pSModelUIActionBase.isCreateDateDirty() && (bl || pSModelUIActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelUIActionBase.getCreateDate());
        }
        if (pSModelUIActionBase.isCreateManDirty() && (bl || pSModelUIActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelUIActionBase.getCreateMan());
        }
        if (pSModelUIActionBase.isHeaderContentDirty() && (bl || pSModelUIActionBase.getHeaderContent() != null)) {
            iDataObject.set(FIELD_HEADERCONTENT, (Object)pSModelUIActionBase.getHeaderContent());
        }
        if (pSModelUIActionBase.isImageFlagDirty() && (bl || pSModelUIActionBase.getImageFlag() != null)) {
            iDataObject.set(FIELD_IMAGEFLAG, (Object)pSModelUIActionBase.getImageFlag());
        }
        if (pSModelUIActionBase.isMemoDirty() && (bl || pSModelUIActionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelUIActionBase.getMemo());
        }
        if (pSModelUIActionBase.isOrderValueDirty() && (bl || pSModelUIActionBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModelUIActionBase.getOrderValue());
        }
        if (pSModelUIActionBase.isPSModelIdDirty() && (bl || pSModelUIActionBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelUIActionBase.getPSModelId());
        }
        if (pSModelUIActionBase.isPSModelNameDirty() && (bl || pSModelUIActionBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSModelUIActionBase.getPSModelName());
        }
        if (pSModelUIActionBase.isPSModelUIActionIdDirty() && (bl || pSModelUIActionBase.getPSModelUIActionId() != null)) {
            iDataObject.set(FIELD_PSMODELUIACTIONID, (Object)pSModelUIActionBase.getPSModelUIActionId());
        }
        if (pSModelUIActionBase.isPSModelUIActionNameDirty() && (bl || pSModelUIActionBase.getPSModelUIActionName() != null)) {
            iDataObject.set(FIELD_PSMODELUIACTIONNAME, (Object)pSModelUIActionBase.getPSModelUIActionName());
        }
        if (pSModelUIActionBase.isUIActionDescDirty() && (bl || pSModelUIActionBase.getUIActionDesc() != null)) {
            iDataObject.set(FIELD_UIACTIONDESC, (Object)pSModelUIActionBase.getUIActionDesc());
        }
        if (pSModelUIActionBase.isUIActionTagDirty() && (bl || pSModelUIActionBase.getUIActionTag() != null)) {
            iDataObject.set(FIELD_UIACTIONTAG, (Object)pSModelUIActionBase.getUIActionTag());
        }
        if (pSModelUIActionBase.isUpdateDateDirty() && (bl || pSModelUIActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelUIActionBase.getUpdateDate());
        }
        if (pSModelUIActionBase.isUpdateManDirty() && (bl || pSModelUIActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelUIActionBase.getUpdateMan());
        }
        if (pSModelUIActionBase.isValidFlagDirty() && (bl || pSModelUIActionBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelUIActionBase.getValidFlag());
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
        return PSModelUIActionBase.remove(this, n);
    }

    private static boolean remove(PSModelUIActionBase pSModelUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelUIActionBase.resetBottomContent();
                return true;
            }
            case 1: {
                pSModelUIActionBase.resetContent();
                return true;
            }
            case 2: {
                pSModelUIActionBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSModelUIActionBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSModelUIActionBase.resetHeaderContent();
                return true;
            }
            case 5: {
                pSModelUIActionBase.resetImageFlag();
                return true;
            }
            case 6: {
                pSModelUIActionBase.resetMemo();
                return true;
            }
            case 7: {
                pSModelUIActionBase.resetOrderValue();
                return true;
            }
            case 8: {
                pSModelUIActionBase.resetPSModelId();
                return true;
            }
            case 9: {
                pSModelUIActionBase.resetPSModelName();
                return true;
            }
            case 10: {
                pSModelUIActionBase.resetPSModelUIActionId();
                return true;
            }
            case 11: {
                pSModelUIActionBase.resetPSModelUIActionName();
                return true;
            }
            case 12: {
                pSModelUIActionBase.resetUIActionDesc();
                return true;
            }
            case 13: {
                pSModelUIActionBase.resetUIActionTag();
                return true;
            }
            case 14: {
                pSModelUIActionBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSModelUIActionBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSModelUIActionBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModel getPSModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModel();
        }
        if (this.getPSModelId() == null) {
            return null;
        }
        Integer n = this.objPSModelLock;
        synchronized (n) {
            if (this.psmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelId(), (Object)this.psmodel.getPSModelId()) != 0L) {
                this.psmodel = null;
            }
            if (this.psmodel == null) {
                PSModel pSModel = new PSModel();
                pSModel.setPSModelId(this.getPSModelId());
                PSModelService pSModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
                pSModelService.autoGet((IEntity)pSModel);
                this.psmodel = pSModel;
            }
            return this.psmodel;
        }
    }

    private PSModelUIActionBase getProxyEntity() {
        return this.proxyPSModelUIActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelUIActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelUIActionBase) {
            this.proxyPSModelUIActionBase = (PSModelUIActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelUIActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSMODELID, 8);
        fieldIndexMap.put(FIELD_PSMODELNAME, 9);
        fieldIndexMap.put(FIELD_PSMODELUIACTIONID, 10);
        fieldIndexMap.put(FIELD_PSMODELUIACTIONNAME, 11);
        fieldIndexMap.put(FIELD_UIACTIONDESC, 12);
        fieldIndexMap.put(FIELD_UIACTIONTAG, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_VALIDFLAG, 16);
    }
}

