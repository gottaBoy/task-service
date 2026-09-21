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
import net.ibizsys.pscore.srv.config.entity.PSModelUIAction;
import net.ibizsys.pscore.srv.config.entity.PSModelView;
import net.ibizsys.pscore.srv.config.service.PSModelUIActionService;
import net.ibizsys.pscore.srv.config.service.PSModelViewService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelViewUIActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelViewUIActionBase.class);
    public static final String FIELD_BOTTOMCONTENT = "BOTTOMCONTENT";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_HEADERCONTENT = "HEADERCONTENT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODELUIACTIONID = "PSMODELUIACTIONID";
    public static final String FIELD_PSMODELUIACTIONNAME = "PSMODELUIACTIONNAME";
    public static final String FIELD_PSMODELVIEWID = "PSMODELVIEWID";
    public static final String FIELD_PSMODELVIEWNAME = "PSMODELVIEWNAME";
    public static final String FIELD_PSMODELVIEWUIACTIONID = "PSMODELVIEWUIACTIONID";
    public static final String FIELD_PSMODELVIEWUIACTIONNAME = "PSMODELVIEWUIACTIONNAME";
    public static final String FIELD_UIACTIONDESC = "UIACTIONDESC";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BOTTOMCONTENT = 0;
    private static final int INDEX_CONTENT = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_HEADERCONTENT = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSMODELUIACTIONID = 7;
    private static final int INDEX_PSMODELUIACTIONNAME = 8;
    private static final int INDEX_PSMODELVIEWID = 9;
    private static final int INDEX_PSMODELVIEWNAME = 10;
    private static final int INDEX_PSMODELVIEWUIACTIONID = 11;
    private static final int INDEX_PSMODELVIEWUIACTIONNAME = 12;
    private static final int INDEX_UIACTIONDESC = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_VALIDFLAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelViewUIActionBase proxyPSModelViewUIActionBase = null;
    private boolean bottomcontentDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean headercontentDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmodeluiactionidDirtyFlag = false;
    private boolean psmodeluiactionnameDirtyFlag = false;
    private boolean psmodelviewidDirtyFlag = false;
    private boolean psmodelviewnameDirtyFlag = false;
    private boolean psmodelviewuiactionidDirtyFlag = false;
    private boolean psmodelviewuiactionnameDirtyFlag = false;
    private boolean uiactiondescDirtyFlag = false;
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
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmodeluiactionid")
    private String psmodeluiactionid;
    @Column(name="psmodeluiactionname")
    private String psmodeluiactionname;
    @Column(name="psmodelviewid")
    private String psmodelviewid;
    @Column(name="psmodelviewname")
    private String psmodelviewname;
    @Column(name="psmodelviewuiactionid")
    private String psmodelviewuiactionid;
    @Column(name="psmodelviewuiactionname")
    private String psmodelviewuiactionname;
    @Column(name="uiactiondesc")
    private String uiactiondesc;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSModelUIActionLock = new Integer(1);
    private PSModelUIAction psmodeluiaction = null;
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

    public void setPSModelViewUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelViewUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelviewuiactionid = string;
        this.psmodelviewuiactionidDirtyFlag = true;
    }

    public String getPSModelViewUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelViewUIActionId();
        }
        return this.psmodelviewuiactionid;
    }

    public boolean isPSModelViewUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelViewUIActionIdDirty();
        }
        return this.psmodelviewuiactionidDirtyFlag;
    }

    public void resetPSModelViewUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelViewUIActionId();
            return;
        }
        this.psmodelviewuiactionidDirtyFlag = false;
        this.psmodelviewuiactionid = null;
    }

    public void setPSModelViewUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelViewUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelviewuiactionname = string;
        this.psmodelviewuiactionnameDirtyFlag = true;
    }

    public String getPSModelViewUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelViewUIActionName();
        }
        return this.psmodelviewuiactionname;
    }

    public boolean isPSModelViewUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelViewUIActionNameDirty();
        }
        return this.psmodelviewuiactionnameDirtyFlag;
    }

    public void resetPSModelViewUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelViewUIActionName();
            return;
        }
        this.psmodelviewuiactionnameDirtyFlag = false;
        this.psmodelviewuiactionname = null;
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
        PSModelViewUIActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelViewUIActionBase pSModelViewUIActionBase) {
        pSModelViewUIActionBase.resetBottomContent();
        pSModelViewUIActionBase.resetContent();
        pSModelViewUIActionBase.resetCreateDate();
        pSModelViewUIActionBase.resetCreateMan();
        pSModelViewUIActionBase.resetHeaderContent();
        pSModelViewUIActionBase.resetMemo();
        pSModelViewUIActionBase.resetOrderValue();
        pSModelViewUIActionBase.resetPSModelUIActionId();
        pSModelViewUIActionBase.resetPSModelUIActionName();
        pSModelViewUIActionBase.resetPSModelViewId();
        pSModelViewUIActionBase.resetPSModelViewName();
        pSModelViewUIActionBase.resetPSModelViewUIActionId();
        pSModelViewUIActionBase.resetPSModelViewUIActionName();
        pSModelViewUIActionBase.resetUIActionDesc();
        pSModelViewUIActionBase.resetUpdateDate();
        pSModelViewUIActionBase.resetUpdateMan();
        pSModelViewUIActionBase.resetValidFlag();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSModelUIActionIdDirty()) {
            hashMap.put(FIELD_PSMODELUIACTIONID, this.getPSModelUIActionId());
        }
        if (!bl || this.isPSModelUIActionNameDirty()) {
            hashMap.put(FIELD_PSMODELUIACTIONNAME, this.getPSModelUIActionName());
        }
        if (!bl || this.isPSModelViewIdDirty()) {
            hashMap.put(FIELD_PSMODELVIEWID, this.getPSModelViewId());
        }
        if (!bl || this.isPSModelViewNameDirty()) {
            hashMap.put(FIELD_PSMODELVIEWNAME, this.getPSModelViewName());
        }
        if (!bl || this.isPSModelViewUIActionIdDirty()) {
            hashMap.put(FIELD_PSMODELVIEWUIACTIONID, this.getPSModelViewUIActionId());
        }
        if (!bl || this.isPSModelViewUIActionNameDirty()) {
            hashMap.put(FIELD_PSMODELVIEWUIACTIONNAME, this.getPSModelViewUIActionName());
        }
        if (!bl || this.isUIActionDescDirty()) {
            hashMap.put(FIELD_UIACTIONDESC, this.getUIActionDesc());
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
        return PSModelViewUIActionBase.get(this, n);
    }

    private static Object get(PSModelViewUIActionBase pSModelViewUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelViewUIActionBase.getBottomContent();
            }
            case 1: {
                return pSModelViewUIActionBase.getContent();
            }
            case 2: {
                return pSModelViewUIActionBase.getCreateDate();
            }
            case 3: {
                return pSModelViewUIActionBase.getCreateMan();
            }
            case 4: {
                return pSModelViewUIActionBase.getHeaderContent();
            }
            case 5: {
                return pSModelViewUIActionBase.getMemo();
            }
            case 6: {
                return pSModelViewUIActionBase.getOrderValue();
            }
            case 7: {
                return pSModelViewUIActionBase.getPSModelUIActionId();
            }
            case 8: {
                return pSModelViewUIActionBase.getPSModelUIActionName();
            }
            case 9: {
                return pSModelViewUIActionBase.getPSModelViewId();
            }
            case 10: {
                return pSModelViewUIActionBase.getPSModelViewName();
            }
            case 11: {
                return pSModelViewUIActionBase.getPSModelViewUIActionId();
            }
            case 12: {
                return pSModelViewUIActionBase.getPSModelViewUIActionName();
            }
            case 13: {
                return pSModelViewUIActionBase.getUIActionDesc();
            }
            case 14: {
                return pSModelViewUIActionBase.getUpdateDate();
            }
            case 15: {
                return pSModelViewUIActionBase.getUpdateMan();
            }
            case 16: {
                return pSModelViewUIActionBase.getValidFlag();
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
        PSModelViewUIActionBase.set(this, n, object);
    }

    private static void set(PSModelViewUIActionBase pSModelViewUIActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelViewUIActionBase.setBottomContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModelViewUIActionBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelViewUIActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSModelViewUIActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelViewUIActionBase.setHeaderContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelViewUIActionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelViewUIActionBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSModelViewUIActionBase.setPSModelUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelViewUIActionBase.setPSModelUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelViewUIActionBase.setPSModelViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelViewUIActionBase.setPSModelViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelViewUIActionBase.setPSModelViewUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelViewUIActionBase.setPSModelViewUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelViewUIActionBase.setUIActionDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelViewUIActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSModelViewUIActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSModelViewUIActionBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSModelViewUIActionBase.isNull(this, n);
    }

    private static boolean isNull(PSModelViewUIActionBase pSModelViewUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelViewUIActionBase.getBottomContent() == null;
            }
            case 1: {
                return pSModelViewUIActionBase.getContent() == null;
            }
            case 2: {
                return pSModelViewUIActionBase.getCreateDate() == null;
            }
            case 3: {
                return pSModelViewUIActionBase.getCreateMan() == null;
            }
            case 4: {
                return pSModelViewUIActionBase.getHeaderContent() == null;
            }
            case 5: {
                return pSModelViewUIActionBase.getMemo() == null;
            }
            case 6: {
                return pSModelViewUIActionBase.getOrderValue() == null;
            }
            case 7: {
                return pSModelViewUIActionBase.getPSModelUIActionId() == null;
            }
            case 8: {
                return pSModelViewUIActionBase.getPSModelUIActionName() == null;
            }
            case 9: {
                return pSModelViewUIActionBase.getPSModelViewId() == null;
            }
            case 10: {
                return pSModelViewUIActionBase.getPSModelViewName() == null;
            }
            case 11: {
                return pSModelViewUIActionBase.getPSModelViewUIActionId() == null;
            }
            case 12: {
                return pSModelViewUIActionBase.getPSModelViewUIActionName() == null;
            }
            case 13: {
                return pSModelViewUIActionBase.getUIActionDesc() == null;
            }
            case 14: {
                return pSModelViewUIActionBase.getUpdateDate() == null;
            }
            case 15: {
                return pSModelViewUIActionBase.getUpdateMan() == null;
            }
            case 16: {
                return pSModelViewUIActionBase.getValidFlag() == null;
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
        return PSModelViewUIActionBase.contains(this, n);
    }

    private static boolean contains(PSModelViewUIActionBase pSModelViewUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelViewUIActionBase.isBottomContentDirty();
            }
            case 1: {
                return pSModelViewUIActionBase.isContentDirty();
            }
            case 2: {
                return pSModelViewUIActionBase.isCreateDateDirty();
            }
            case 3: {
                return pSModelViewUIActionBase.isCreateManDirty();
            }
            case 4: {
                return pSModelViewUIActionBase.isHeaderContentDirty();
            }
            case 5: {
                return pSModelViewUIActionBase.isMemoDirty();
            }
            case 6: {
                return pSModelViewUIActionBase.isOrderValueDirty();
            }
            case 7: {
                return pSModelViewUIActionBase.isPSModelUIActionIdDirty();
            }
            case 8: {
                return pSModelViewUIActionBase.isPSModelUIActionNameDirty();
            }
            case 9: {
                return pSModelViewUIActionBase.isPSModelViewIdDirty();
            }
            case 10: {
                return pSModelViewUIActionBase.isPSModelViewNameDirty();
            }
            case 11: {
                return pSModelViewUIActionBase.isPSModelViewUIActionIdDirty();
            }
            case 12: {
                return pSModelViewUIActionBase.isPSModelViewUIActionNameDirty();
            }
            case 13: {
                return pSModelViewUIActionBase.isUIActionDescDirty();
            }
            case 14: {
                return pSModelViewUIActionBase.isUpdateDateDirty();
            }
            case 15: {
                return pSModelViewUIActionBase.isUpdateManDirty();
            }
            case 16: {
                return pSModelViewUIActionBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelViewUIActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelViewUIActionBase pSModelViewUIActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelViewUIActionBase.getBottomContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottomcontent", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getBottomContent()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getContent()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getHeaderContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headercontent", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getHeaderContent()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getPSModelUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodeluiactionid", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getPSModelUIActionId()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getPSModelUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodeluiactionname", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getPSModelUIActionName()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getPSModelViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelviewid", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getPSModelViewId()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getPSModelViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelviewname", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getPSModelViewName()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getPSModelViewUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelviewuiactionid", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getPSModelViewUIActionId()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getPSModelViewUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelviewuiactionname", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getPSModelViewUIActionName()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getUIActionDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactiondesc", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getUIActionDesc()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelViewUIActionBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelViewUIActionBase.getJSONValue((Object)pSModelViewUIActionBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelViewUIActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelViewUIActionBase pSModelViewUIActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelViewUIActionBase.getBottomContent() != null) {
            object = pSModelViewUIActionBase.getBottomContent();
            xmlNode.setAttribute(FIELD_BOTTOMCONTENT, (String)(object == null ? "" : object));
        }
        if (bl || pSModelViewUIActionBase.getContent() != null) {
            object = pSModelViewUIActionBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewUIActionBase.getCreateDate() != null) {
            object = pSModelViewUIActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelViewUIActionBase.getCreateMan() != null) {
            object = pSModelViewUIActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewUIActionBase.getHeaderContent() != null) {
            object = pSModelViewUIActionBase.getHeaderContent();
            xmlNode.setAttribute(FIELD_HEADERCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewUIActionBase.getMemo() != null) {
            object = pSModelViewUIActionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewUIActionBase.getOrderValue() != null) {
            object = pSModelViewUIActionBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelViewUIActionBase.getPSModelUIActionId() != null) {
            object = pSModelViewUIActionBase.getPSModelUIActionId();
            xmlNode.setAttribute(FIELD_PSMODELUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewUIActionBase.getPSModelUIActionName() != null) {
            object = pSModelViewUIActionBase.getPSModelUIActionName();
            xmlNode.setAttribute(FIELD_PSMODELUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewUIActionBase.getPSModelViewId() != null) {
            object = pSModelViewUIActionBase.getPSModelViewId();
            xmlNode.setAttribute(FIELD_PSMODELVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewUIActionBase.getPSModelViewName() != null) {
            object = pSModelViewUIActionBase.getPSModelViewName();
            xmlNode.setAttribute(FIELD_PSMODELVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewUIActionBase.getPSModelViewUIActionId() != null) {
            object = pSModelViewUIActionBase.getPSModelViewUIActionId();
            xmlNode.setAttribute(FIELD_PSMODELVIEWUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewUIActionBase.getPSModelViewUIActionName() != null) {
            object = pSModelViewUIActionBase.getPSModelViewUIActionName();
            xmlNode.setAttribute(FIELD_PSMODELVIEWUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewUIActionBase.getUIActionDesc() != null) {
            object = pSModelViewUIActionBase.getUIActionDesc();
            xmlNode.setAttribute(FIELD_UIACTIONDESC, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewUIActionBase.getUpdateDate() != null) {
            object = pSModelViewUIActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelViewUIActionBase.getUpdateMan() != null) {
            object = pSModelViewUIActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewUIActionBase.getValidFlag() != null) {
            object = pSModelViewUIActionBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelViewUIActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelViewUIActionBase pSModelViewUIActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelViewUIActionBase.isBottomContentDirty() && (bl || pSModelViewUIActionBase.getBottomContent() != null)) {
            iDataObject.set(FIELD_BOTTOMCONTENT, (Object)pSModelViewUIActionBase.getBottomContent());
        }
        if (pSModelViewUIActionBase.isContentDirty() && (bl || pSModelViewUIActionBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSModelViewUIActionBase.getContent());
        }
        if (pSModelViewUIActionBase.isCreateDateDirty() && (bl || pSModelViewUIActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelViewUIActionBase.getCreateDate());
        }
        if (pSModelViewUIActionBase.isCreateManDirty() && (bl || pSModelViewUIActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelViewUIActionBase.getCreateMan());
        }
        if (pSModelViewUIActionBase.isHeaderContentDirty() && (bl || pSModelViewUIActionBase.getHeaderContent() != null)) {
            iDataObject.set(FIELD_HEADERCONTENT, (Object)pSModelViewUIActionBase.getHeaderContent());
        }
        if (pSModelViewUIActionBase.isMemoDirty() && (bl || pSModelViewUIActionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelViewUIActionBase.getMemo());
        }
        if (pSModelViewUIActionBase.isOrderValueDirty() && (bl || pSModelViewUIActionBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModelViewUIActionBase.getOrderValue());
        }
        if (pSModelViewUIActionBase.isPSModelUIActionIdDirty() && (bl || pSModelViewUIActionBase.getPSModelUIActionId() != null)) {
            iDataObject.set(FIELD_PSMODELUIACTIONID, (Object)pSModelViewUIActionBase.getPSModelUIActionId());
        }
        if (pSModelViewUIActionBase.isPSModelUIActionNameDirty() && (bl || pSModelViewUIActionBase.getPSModelUIActionName() != null)) {
            iDataObject.set(FIELD_PSMODELUIACTIONNAME, (Object)pSModelViewUIActionBase.getPSModelUIActionName());
        }
        if (pSModelViewUIActionBase.isPSModelViewIdDirty() && (bl || pSModelViewUIActionBase.getPSModelViewId() != null)) {
            iDataObject.set(FIELD_PSMODELVIEWID, (Object)pSModelViewUIActionBase.getPSModelViewId());
        }
        if (pSModelViewUIActionBase.isPSModelViewNameDirty() && (bl || pSModelViewUIActionBase.getPSModelViewName() != null)) {
            iDataObject.set(FIELD_PSMODELVIEWNAME, (Object)pSModelViewUIActionBase.getPSModelViewName());
        }
        if (pSModelViewUIActionBase.isPSModelViewUIActionIdDirty() && (bl || pSModelViewUIActionBase.getPSModelViewUIActionId() != null)) {
            iDataObject.set(FIELD_PSMODELVIEWUIACTIONID, (Object)pSModelViewUIActionBase.getPSModelViewUIActionId());
        }
        if (pSModelViewUIActionBase.isPSModelViewUIActionNameDirty() && (bl || pSModelViewUIActionBase.getPSModelViewUIActionName() != null)) {
            iDataObject.set(FIELD_PSMODELVIEWUIACTIONNAME, (Object)pSModelViewUIActionBase.getPSModelViewUIActionName());
        }
        if (pSModelViewUIActionBase.isUIActionDescDirty() && (bl || pSModelViewUIActionBase.getUIActionDesc() != null)) {
            iDataObject.set(FIELD_UIACTIONDESC, (Object)pSModelViewUIActionBase.getUIActionDesc());
        }
        if (pSModelViewUIActionBase.isUpdateDateDirty() && (bl || pSModelViewUIActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelViewUIActionBase.getUpdateDate());
        }
        if (pSModelViewUIActionBase.isUpdateManDirty() && (bl || pSModelViewUIActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelViewUIActionBase.getUpdateMan());
        }
        if (pSModelViewUIActionBase.isValidFlagDirty() && (bl || pSModelViewUIActionBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelViewUIActionBase.getValidFlag());
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
        return PSModelViewUIActionBase.remove(this, n);
    }

    private static boolean remove(PSModelViewUIActionBase pSModelViewUIActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelViewUIActionBase.resetBottomContent();
                return true;
            }
            case 1: {
                pSModelViewUIActionBase.resetContent();
                return true;
            }
            case 2: {
                pSModelViewUIActionBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSModelViewUIActionBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSModelViewUIActionBase.resetHeaderContent();
                return true;
            }
            case 5: {
                pSModelViewUIActionBase.resetMemo();
                return true;
            }
            case 6: {
                pSModelViewUIActionBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSModelViewUIActionBase.resetPSModelUIActionId();
                return true;
            }
            case 8: {
                pSModelViewUIActionBase.resetPSModelUIActionName();
                return true;
            }
            case 9: {
                pSModelViewUIActionBase.resetPSModelViewId();
                return true;
            }
            case 10: {
                pSModelViewUIActionBase.resetPSModelViewName();
                return true;
            }
            case 11: {
                pSModelViewUIActionBase.resetPSModelViewUIActionId();
                return true;
            }
            case 12: {
                pSModelViewUIActionBase.resetPSModelViewUIActionName();
                return true;
            }
            case 13: {
                pSModelViewUIActionBase.resetUIActionDesc();
                return true;
            }
            case 14: {
                pSModelViewUIActionBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSModelViewUIActionBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSModelViewUIActionBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelUIAction getPSModelUIAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelUIAction();
        }
        if (this.getPSModelUIActionId() == null) {
            return null;
        }
        Integer n = this.objPSModelUIActionLock;
        synchronized (n) {
            if (this.psmodeluiaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelUIActionId(), (Object)this.psmodeluiaction.getPSModelUIActionId()) != 0L) {
                this.psmodeluiaction = null;
            }
            if (this.psmodeluiaction == null) {
                PSModelUIAction pSModelUIAction = new PSModelUIAction();
                pSModelUIAction.setPSModelUIActionId(this.getPSModelUIActionId());
                PSModelUIActionService pSModelUIActionService = (PSModelUIActionService)ServiceGlobal.getService(PSModelUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSModelUIActionService.autoGet((IEntity)pSModelUIAction);
                this.psmodeluiaction = pSModelUIAction;
            }
            return this.psmodeluiaction;
        }
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
                pSModelViewService.autoGet((IEntity)pSModelView);
                this.psmodelview = pSModelView;
            }
            return this.psmodelview;
        }
    }

    private PSModelViewUIActionBase getProxyEntity() {
        return this.proxyPSModelViewUIActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelViewUIActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelViewUIActionBase) {
            this.proxyPSModelViewUIActionBase = (PSModelViewUIActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelViewUIActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BOTTOMCONTENT, 0);
        fieldIndexMap.put(FIELD_CONTENT, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_HEADERCONTENT, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSMODELUIACTIONID, 7);
        fieldIndexMap.put(FIELD_PSMODELUIACTIONNAME, 8);
        fieldIndexMap.put(FIELD_PSMODELVIEWID, 9);
        fieldIndexMap.put(FIELD_PSMODELVIEWNAME, 10);
        fieldIndexMap.put(FIELD_PSMODELVIEWUIACTIONID, 11);
        fieldIndexMap.put(FIELD_PSMODELVIEWUIACTIONNAME, 12);
        fieldIndexMap.put(FIELD_UIACTIONDESC, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_VALIDFLAG, 16);
    }
}

