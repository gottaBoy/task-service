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
import net.ibizsys.pscore.srv.config.entity.PSModelExample;
import net.ibizsys.pscore.srv.config.service.PSModelExampleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelExampleStepBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelExampleStepBase.class);
    public static final String FIELD_BOTTOMCONTENT = "BOTTOMCONTENT";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CONTENTASCODE = "CONTENTASCODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_HEADERCONTENT = "HEADERCONTENT";
    public static final String FIELD_IMAGEFLAG = "IMAGEFLAG";
    public static final String FIELD_LINKFLAG = "LINKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODELEXAMPLEID = "PSMODELEXAMPLEID";
    public static final String FIELD_PSMODELEXAMPLENAME = "PSMODELEXAMPLENAME";
    public static final String FIELD_PSMODELEXAMPLESTEPID = "PSMODELEXAMPLESTEPID";
    public static final String FIELD_PSMODELEXAMPLESTEPNAME = "PSMODELEXAMPLESTEPNAME";
    public static final String FIELD_STEPSN = "STEPSN";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BOTTOMCONTENT = 0;
    private static final int INDEX_CONTENT = 1;
    private static final int INDEX_CONTENTASCODE = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_HEADERCONTENT = 5;
    private static final int INDEX_IMAGEFLAG = 6;
    private static final int INDEX_LINKFLAG = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_ORDERVALUE = 9;
    private static final int INDEX_PSMODELEXAMPLEID = 10;
    private static final int INDEX_PSMODELEXAMPLENAME = 11;
    private static final int INDEX_PSMODELEXAMPLESTEPID = 12;
    private static final int INDEX_PSMODELEXAMPLESTEPNAME = 13;
    private static final int INDEX_STEPSN = 14;
    private static final int INDEX_TITLE = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelExampleStepBase proxyPSModelExampleStepBase = null;
    private boolean bottomcontentDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean contentascodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean headercontentDirtyFlag = false;
    private boolean imageflagDirtyFlag = false;
    private boolean linkflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmodelexampleidDirtyFlag = false;
    private boolean psmodelexamplenameDirtyFlag = false;
    private boolean psmodelexamplestepidDirtyFlag = false;
    private boolean psmodelexamplestepnameDirtyFlag = false;
    private boolean stepsnDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="bottomcontent")
    private String bottomcontent;
    @Column(name="content")
    private String content;
    @Column(name="contentascode")
    private Integer contentascode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="headercontent")
    private String headercontent;
    @Column(name="imageflag")
    private Integer imageflag;
    @Column(name="linkflag")
    private Integer linkflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmodelexampleid")
    private String psmodelexampleid;
    @Column(name="psmodelexamplename")
    private String psmodelexamplename;
    @Column(name="psmodelexamplestepid")
    private String psmodelexamplestepid;
    @Column(name="psmodelexamplestepname")
    private String psmodelexamplestepname;
    @Column(name="stepsn")
    private String stepsn;
    @Column(name="title")
    private String title;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSModelExampleLock = new Integer(1);
    private PSModelExample psmodelexample = null;

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

    public void setContentAsCode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentAsCode(n);
            return;
        }
        this.contentascode = n;
        this.contentascodeDirtyFlag = true;
    }

    public Integer getContentAsCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentAsCode();
        }
        return this.contentascode;
    }

    public boolean isContentAsCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentAsCodeDirty();
        }
        return this.contentascodeDirtyFlag;
    }

    public void resetContentAsCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentAsCode();
            return;
        }
        this.contentascodeDirtyFlag = false;
        this.contentascode = null;
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

    public void setLinkFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkFlag(n);
            return;
        }
        this.linkflag = n;
        this.linkflagDirtyFlag = true;
    }

    public Integer getLinkFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkFlag();
        }
        return this.linkflag;
    }

    public boolean isLinkFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkFlagDirty();
        }
        return this.linkflagDirtyFlag;
    }

    public void resetLinkFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkFlag();
            return;
        }
        this.linkflagDirtyFlag = false;
        this.linkflag = null;
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

    public void setPSModelExampleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelExampleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelexampleid = string;
        this.psmodelexampleidDirtyFlag = true;
    }

    public String getPSModelExampleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelExampleId();
        }
        return this.psmodelexampleid;
    }

    public boolean isPSModelExampleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelExampleIdDirty();
        }
        return this.psmodelexampleidDirtyFlag;
    }

    public void resetPSModelExampleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelExampleId();
            return;
        }
        this.psmodelexampleidDirtyFlag = false;
        this.psmodelexampleid = null;
    }

    public void setPSModelExampleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelExampleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelexamplename = string;
        this.psmodelexamplenameDirtyFlag = true;
    }

    public String getPSModelExampleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelExampleName();
        }
        return this.psmodelexamplename;
    }

    public boolean isPSModelExampleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelExampleNameDirty();
        }
        return this.psmodelexamplenameDirtyFlag;
    }

    public void resetPSModelExampleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelExampleName();
            return;
        }
        this.psmodelexamplenameDirtyFlag = false;
        this.psmodelexamplename = null;
    }

    public void setPSModelExampleStepId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelExampleStepId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelexamplestepid = string;
        this.psmodelexamplestepidDirtyFlag = true;
    }

    public String getPSModelExampleStepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelExampleStepId();
        }
        return this.psmodelexamplestepid;
    }

    public boolean isPSModelExampleStepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelExampleStepIdDirty();
        }
        return this.psmodelexamplestepidDirtyFlag;
    }

    public void resetPSModelExampleStepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelExampleStepId();
            return;
        }
        this.psmodelexamplestepidDirtyFlag = false;
        this.psmodelexamplestepid = null;
    }

    public void setPSModelExampleStepName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelExampleStepName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelexamplestepname = string;
        this.psmodelexamplestepnameDirtyFlag = true;
    }

    public String getPSModelExampleStepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelExampleStepName();
        }
        return this.psmodelexamplestepname;
    }

    public boolean isPSModelExampleStepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelExampleStepNameDirty();
        }
        return this.psmodelexamplestepnameDirtyFlag;
    }

    public void resetPSModelExampleStepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelExampleStepName();
            return;
        }
        this.psmodelexamplestepnameDirtyFlag = false;
        this.psmodelexamplestepname = null;
    }

    public void setStepSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStepSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.stepsn = string;
        this.stepsnDirtyFlag = true;
    }

    public String getStepSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStepSN();
        }
        return this.stepsn;
    }

    public boolean isStepSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStepSNDirty();
        }
        return this.stepsnDirtyFlag;
    }

    public void resetStepSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStepSN();
            return;
        }
        this.stepsnDirtyFlag = false;
        this.stepsn = null;
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
        PSModelExampleStepBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelExampleStepBase pSModelExampleStepBase) {
        pSModelExampleStepBase.resetBottomContent();
        pSModelExampleStepBase.resetContent();
        pSModelExampleStepBase.resetContentAsCode();
        pSModelExampleStepBase.resetCreateDate();
        pSModelExampleStepBase.resetCreateMan();
        pSModelExampleStepBase.resetHeaderContent();
        pSModelExampleStepBase.resetImageFlag();
        pSModelExampleStepBase.resetLinkFlag();
        pSModelExampleStepBase.resetMemo();
        pSModelExampleStepBase.resetOrderValue();
        pSModelExampleStepBase.resetPSModelExampleId();
        pSModelExampleStepBase.resetPSModelExampleName();
        pSModelExampleStepBase.resetPSModelExampleStepId();
        pSModelExampleStepBase.resetPSModelExampleStepName();
        pSModelExampleStepBase.resetStepSN();
        pSModelExampleStepBase.resetTitle();
        pSModelExampleStepBase.resetUpdateDate();
        pSModelExampleStepBase.resetUpdateMan();
        pSModelExampleStepBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBottomContentDirty()) {
            hashMap.put(FIELD_BOTTOMCONTENT, this.getBottomContent());
        }
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isContentAsCodeDirty()) {
            hashMap.put(FIELD_CONTENTASCODE, this.getContentAsCode());
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
        if (!bl || this.isLinkFlagDirty()) {
            hashMap.put(FIELD_LINKFLAG, this.getLinkFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSModelExampleIdDirty()) {
            hashMap.put(FIELD_PSMODELEXAMPLEID, this.getPSModelExampleId());
        }
        if (!bl || this.isPSModelExampleNameDirty()) {
            hashMap.put(FIELD_PSMODELEXAMPLENAME, this.getPSModelExampleName());
        }
        if (!bl || this.isPSModelExampleStepIdDirty()) {
            hashMap.put(FIELD_PSMODELEXAMPLESTEPID, this.getPSModelExampleStepId());
        }
        if (!bl || this.isPSModelExampleStepNameDirty()) {
            hashMap.put(FIELD_PSMODELEXAMPLESTEPNAME, this.getPSModelExampleStepName());
        }
        if (!bl || this.isStepSNDirty()) {
            hashMap.put(FIELD_STEPSN, this.getStepSN());
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
        return PSModelExampleStepBase.get(this, n);
    }

    private static Object get(PSModelExampleStepBase pSModelExampleStepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelExampleStepBase.getBottomContent();
            }
            case 1: {
                return pSModelExampleStepBase.getContent();
            }
            case 2: {
                return pSModelExampleStepBase.getContentAsCode();
            }
            case 3: {
                return pSModelExampleStepBase.getCreateDate();
            }
            case 4: {
                return pSModelExampleStepBase.getCreateMan();
            }
            case 5: {
                return pSModelExampleStepBase.getHeaderContent();
            }
            case 6: {
                return pSModelExampleStepBase.getImageFlag();
            }
            case 7: {
                return pSModelExampleStepBase.getLinkFlag();
            }
            case 8: {
                return pSModelExampleStepBase.getMemo();
            }
            case 9: {
                return pSModelExampleStepBase.getOrderValue();
            }
            case 10: {
                return pSModelExampleStepBase.getPSModelExampleId();
            }
            case 11: {
                return pSModelExampleStepBase.getPSModelExampleName();
            }
            case 12: {
                return pSModelExampleStepBase.getPSModelExampleStepId();
            }
            case 13: {
                return pSModelExampleStepBase.getPSModelExampleStepName();
            }
            case 14: {
                return pSModelExampleStepBase.getStepSN();
            }
            case 15: {
                return pSModelExampleStepBase.getTitle();
            }
            case 16: {
                return pSModelExampleStepBase.getUpdateDate();
            }
            case 17: {
                return pSModelExampleStepBase.getUpdateMan();
            }
            case 18: {
                return pSModelExampleStepBase.getValidFlag();
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
        PSModelExampleStepBase.set(this, n, object);
    }

    private static void set(PSModelExampleStepBase pSModelExampleStepBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelExampleStepBase.setBottomContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModelExampleStepBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelExampleStepBase.setContentAsCode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSModelExampleStepBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSModelExampleStepBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelExampleStepBase.setHeaderContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelExampleStepBase.setImageFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSModelExampleStepBase.setLinkFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSModelExampleStepBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelExampleStepBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSModelExampleStepBase.setPSModelExampleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelExampleStepBase.setPSModelExampleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelExampleStepBase.setPSModelExampleStepId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelExampleStepBase.setPSModelExampleStepName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelExampleStepBase.setStepSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSModelExampleStepBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSModelExampleStepBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSModelExampleStepBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSModelExampleStepBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSModelExampleStepBase.isNull(this, n);
    }

    private static boolean isNull(PSModelExampleStepBase pSModelExampleStepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelExampleStepBase.getBottomContent() == null;
            }
            case 1: {
                return pSModelExampleStepBase.getContent() == null;
            }
            case 2: {
                return pSModelExampleStepBase.getContentAsCode() == null;
            }
            case 3: {
                return pSModelExampleStepBase.getCreateDate() == null;
            }
            case 4: {
                return pSModelExampleStepBase.getCreateMan() == null;
            }
            case 5: {
                return pSModelExampleStepBase.getHeaderContent() == null;
            }
            case 6: {
                return pSModelExampleStepBase.getImageFlag() == null;
            }
            case 7: {
                return pSModelExampleStepBase.getLinkFlag() == null;
            }
            case 8: {
                return pSModelExampleStepBase.getMemo() == null;
            }
            case 9: {
                return pSModelExampleStepBase.getOrderValue() == null;
            }
            case 10: {
                return pSModelExampleStepBase.getPSModelExampleId() == null;
            }
            case 11: {
                return pSModelExampleStepBase.getPSModelExampleName() == null;
            }
            case 12: {
                return pSModelExampleStepBase.getPSModelExampleStepId() == null;
            }
            case 13: {
                return pSModelExampleStepBase.getPSModelExampleStepName() == null;
            }
            case 14: {
                return pSModelExampleStepBase.getStepSN() == null;
            }
            case 15: {
                return pSModelExampleStepBase.getTitle() == null;
            }
            case 16: {
                return pSModelExampleStepBase.getUpdateDate() == null;
            }
            case 17: {
                return pSModelExampleStepBase.getUpdateMan() == null;
            }
            case 18: {
                return pSModelExampleStepBase.getValidFlag() == null;
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
        return PSModelExampleStepBase.contains(this, n);
    }

    private static boolean contains(PSModelExampleStepBase pSModelExampleStepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelExampleStepBase.isBottomContentDirty();
            }
            case 1: {
                return pSModelExampleStepBase.isContentDirty();
            }
            case 2: {
                return pSModelExampleStepBase.isContentAsCodeDirty();
            }
            case 3: {
                return pSModelExampleStepBase.isCreateDateDirty();
            }
            case 4: {
                return pSModelExampleStepBase.isCreateManDirty();
            }
            case 5: {
                return pSModelExampleStepBase.isHeaderContentDirty();
            }
            case 6: {
                return pSModelExampleStepBase.isImageFlagDirty();
            }
            case 7: {
                return pSModelExampleStepBase.isLinkFlagDirty();
            }
            case 8: {
                return pSModelExampleStepBase.isMemoDirty();
            }
            case 9: {
                return pSModelExampleStepBase.isOrderValueDirty();
            }
            case 10: {
                return pSModelExampleStepBase.isPSModelExampleIdDirty();
            }
            case 11: {
                return pSModelExampleStepBase.isPSModelExampleNameDirty();
            }
            case 12: {
                return pSModelExampleStepBase.isPSModelExampleStepIdDirty();
            }
            case 13: {
                return pSModelExampleStepBase.isPSModelExampleStepNameDirty();
            }
            case 14: {
                return pSModelExampleStepBase.isStepSNDirty();
            }
            case 15: {
                return pSModelExampleStepBase.isTitleDirty();
            }
            case 16: {
                return pSModelExampleStepBase.isUpdateDateDirty();
            }
            case 17: {
                return pSModelExampleStepBase.isUpdateManDirty();
            }
            case 18: {
                return pSModelExampleStepBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelExampleStepBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelExampleStepBase pSModelExampleStepBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelExampleStepBase.getBottomContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottomcontent", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getBottomContent()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getContent()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getContentAsCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentascode", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getContentAsCode()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getHeaderContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headercontent", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getHeaderContent()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getImageFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imageflag", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getImageFlag()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getLinkFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkflag", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getLinkFlag()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getPSModelExampleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelexampleid", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getPSModelExampleId()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getPSModelExampleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelexamplename", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getPSModelExampleName()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getPSModelExampleStepId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelexamplestepid", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getPSModelExampleStepId()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getPSModelExampleStepName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelexamplestepname", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getPSModelExampleStepName()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getStepSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stepsn", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getStepSN()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getTitle()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelExampleStepBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelExampleStepBase.getJSONValue((Object)pSModelExampleStepBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelExampleStepBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelExampleStepBase pSModelExampleStepBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelExampleStepBase.getBottomContent() != null) {
            object = pSModelExampleStepBase.getBottomContent();
            xmlNode.setAttribute(FIELD_BOTTOMCONTENT, (String)(object == null ? "" : object));
        }
        if (bl || pSModelExampleStepBase.getContent() != null) {
            object = pSModelExampleStepBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleStepBase.getContentAsCode() != null) {
            object = pSModelExampleStepBase.getContentAsCode();
            xmlNode.setAttribute(FIELD_CONTENTASCODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelExampleStepBase.getCreateDate() != null) {
            object = pSModelExampleStepBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelExampleStepBase.getCreateMan() != null) {
            object = pSModelExampleStepBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleStepBase.getHeaderContent() != null) {
            object = pSModelExampleStepBase.getHeaderContent();
            xmlNode.setAttribute(FIELD_HEADERCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleStepBase.getImageFlag() != null) {
            object = pSModelExampleStepBase.getImageFlag();
            xmlNode.setAttribute(FIELD_IMAGEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelExampleStepBase.getLinkFlag() != null) {
            object = pSModelExampleStepBase.getLinkFlag();
            xmlNode.setAttribute(FIELD_LINKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelExampleStepBase.getMemo() != null) {
            object = pSModelExampleStepBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleStepBase.getOrderValue() != null) {
            object = pSModelExampleStepBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelExampleStepBase.getPSModelExampleId() != null) {
            object = pSModelExampleStepBase.getPSModelExampleId();
            xmlNode.setAttribute(FIELD_PSMODELEXAMPLEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleStepBase.getPSModelExampleName() != null) {
            object = pSModelExampleStepBase.getPSModelExampleName();
            xmlNode.setAttribute(FIELD_PSMODELEXAMPLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleStepBase.getPSModelExampleStepId() != null) {
            object = pSModelExampleStepBase.getPSModelExampleStepId();
            xmlNode.setAttribute(FIELD_PSMODELEXAMPLESTEPID, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleStepBase.getPSModelExampleStepName() != null) {
            object = pSModelExampleStepBase.getPSModelExampleStepName();
            xmlNode.setAttribute(FIELD_PSMODELEXAMPLESTEPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleStepBase.getStepSN() != null) {
            object = pSModelExampleStepBase.getStepSN();
            xmlNode.setAttribute(FIELD_STEPSN, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleStepBase.getTitle() != null) {
            object = pSModelExampleStepBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleStepBase.getUpdateDate() != null) {
            object = pSModelExampleStepBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelExampleStepBase.getUpdateMan() != null) {
            object = pSModelExampleStepBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleStepBase.getValidFlag() != null) {
            object = pSModelExampleStepBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelExampleStepBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelExampleStepBase pSModelExampleStepBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelExampleStepBase.isBottomContentDirty() && (bl || pSModelExampleStepBase.getBottomContent() != null)) {
            iDataObject.set(FIELD_BOTTOMCONTENT, (Object)pSModelExampleStepBase.getBottomContent());
        }
        if (pSModelExampleStepBase.isContentDirty() && (bl || pSModelExampleStepBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSModelExampleStepBase.getContent());
        }
        if (pSModelExampleStepBase.isContentAsCodeDirty() && (bl || pSModelExampleStepBase.getContentAsCode() != null)) {
            iDataObject.set(FIELD_CONTENTASCODE, (Object)pSModelExampleStepBase.getContentAsCode());
        }
        if (pSModelExampleStepBase.isCreateDateDirty() && (bl || pSModelExampleStepBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelExampleStepBase.getCreateDate());
        }
        if (pSModelExampleStepBase.isCreateManDirty() && (bl || pSModelExampleStepBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelExampleStepBase.getCreateMan());
        }
        if (pSModelExampleStepBase.isHeaderContentDirty() && (bl || pSModelExampleStepBase.getHeaderContent() != null)) {
            iDataObject.set(FIELD_HEADERCONTENT, (Object)pSModelExampleStepBase.getHeaderContent());
        }
        if (pSModelExampleStepBase.isImageFlagDirty() && (bl || pSModelExampleStepBase.getImageFlag() != null)) {
            iDataObject.set(FIELD_IMAGEFLAG, (Object)pSModelExampleStepBase.getImageFlag());
        }
        if (pSModelExampleStepBase.isLinkFlagDirty() && (bl || pSModelExampleStepBase.getLinkFlag() != null)) {
            iDataObject.set(FIELD_LINKFLAG, (Object)pSModelExampleStepBase.getLinkFlag());
        }
        if (pSModelExampleStepBase.isMemoDirty() && (bl || pSModelExampleStepBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelExampleStepBase.getMemo());
        }
        if (pSModelExampleStepBase.isOrderValueDirty() && (bl || pSModelExampleStepBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModelExampleStepBase.getOrderValue());
        }
        if (pSModelExampleStepBase.isPSModelExampleIdDirty() && (bl || pSModelExampleStepBase.getPSModelExampleId() != null)) {
            iDataObject.set(FIELD_PSMODELEXAMPLEID, (Object)pSModelExampleStepBase.getPSModelExampleId());
        }
        if (pSModelExampleStepBase.isPSModelExampleNameDirty() && (bl || pSModelExampleStepBase.getPSModelExampleName() != null)) {
            iDataObject.set(FIELD_PSMODELEXAMPLENAME, (Object)pSModelExampleStepBase.getPSModelExampleName());
        }
        if (pSModelExampleStepBase.isPSModelExampleStepIdDirty() && (bl || pSModelExampleStepBase.getPSModelExampleStepId() != null)) {
            iDataObject.set(FIELD_PSMODELEXAMPLESTEPID, (Object)pSModelExampleStepBase.getPSModelExampleStepId());
        }
        if (pSModelExampleStepBase.isPSModelExampleStepNameDirty() && (bl || pSModelExampleStepBase.getPSModelExampleStepName() != null)) {
            iDataObject.set(FIELD_PSMODELEXAMPLESTEPNAME, (Object)pSModelExampleStepBase.getPSModelExampleStepName());
        }
        if (pSModelExampleStepBase.isStepSNDirty() && (bl || pSModelExampleStepBase.getStepSN() != null)) {
            iDataObject.set(FIELD_STEPSN, (Object)pSModelExampleStepBase.getStepSN());
        }
        if (pSModelExampleStepBase.isTitleDirty() && (bl || pSModelExampleStepBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSModelExampleStepBase.getTitle());
        }
        if (pSModelExampleStepBase.isUpdateDateDirty() && (bl || pSModelExampleStepBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelExampleStepBase.getUpdateDate());
        }
        if (pSModelExampleStepBase.isUpdateManDirty() && (bl || pSModelExampleStepBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelExampleStepBase.getUpdateMan());
        }
        if (pSModelExampleStepBase.isValidFlagDirty() && (bl || pSModelExampleStepBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelExampleStepBase.getValidFlag());
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
        return PSModelExampleStepBase.remove(this, n);
    }

    private static boolean remove(PSModelExampleStepBase pSModelExampleStepBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelExampleStepBase.resetBottomContent();
                return true;
            }
            case 1: {
                pSModelExampleStepBase.resetContent();
                return true;
            }
            case 2: {
                pSModelExampleStepBase.resetContentAsCode();
                return true;
            }
            case 3: {
                pSModelExampleStepBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSModelExampleStepBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSModelExampleStepBase.resetHeaderContent();
                return true;
            }
            case 6: {
                pSModelExampleStepBase.resetImageFlag();
                return true;
            }
            case 7: {
                pSModelExampleStepBase.resetLinkFlag();
                return true;
            }
            case 8: {
                pSModelExampleStepBase.resetMemo();
                return true;
            }
            case 9: {
                pSModelExampleStepBase.resetOrderValue();
                return true;
            }
            case 10: {
                pSModelExampleStepBase.resetPSModelExampleId();
                return true;
            }
            case 11: {
                pSModelExampleStepBase.resetPSModelExampleName();
                return true;
            }
            case 12: {
                pSModelExampleStepBase.resetPSModelExampleStepId();
                return true;
            }
            case 13: {
                pSModelExampleStepBase.resetPSModelExampleStepName();
                return true;
            }
            case 14: {
                pSModelExampleStepBase.resetStepSN();
                return true;
            }
            case 15: {
                pSModelExampleStepBase.resetTitle();
                return true;
            }
            case 16: {
                pSModelExampleStepBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSModelExampleStepBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSModelExampleStepBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelExample getPSModelExample() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelExample();
        }
        if (this.getPSModelExampleId() == null) {
            return null;
        }
        Integer n = this.objPSModelExampleLock;
        synchronized (n) {
            if (this.psmodelexample != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelExampleId(), (Object)this.psmodelexample.getPSModelExampleId()) != 0L) {
                this.psmodelexample = null;
            }
            if (this.psmodelexample == null) {
                PSModelExample pSModelExample = new PSModelExample();
                pSModelExample.setPSModelExampleId(this.getPSModelExampleId());
                PSModelExampleService pSModelExampleService = (PSModelExampleService)ServiceGlobal.getService(PSModelExampleService.class, (SessionFactory)this.getSessionFactory());
                pSModelExampleService.autoGet((IEntity)pSModelExample);
                this.psmodelexample = pSModelExample;
            }
            return this.psmodelexample;
        }
    }

    private PSModelExampleStepBase getProxyEntity() {
        return this.proxyPSModelExampleStepBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelExampleStepBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelExampleStepBase) {
            this.proxyPSModelExampleStepBase = (PSModelExampleStepBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelExampleStepService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BOTTOMCONTENT, 0);
        fieldIndexMap.put(FIELD_CONTENT, 1);
        fieldIndexMap.put(FIELD_CONTENTASCODE, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_HEADERCONTENT, 5);
        fieldIndexMap.put(FIELD_IMAGEFLAG, 6);
        fieldIndexMap.put(FIELD_LINKFLAG, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_ORDERVALUE, 9);
        fieldIndexMap.put(FIELD_PSMODELEXAMPLEID, 10);
        fieldIndexMap.put(FIELD_PSMODELEXAMPLENAME, 11);
        fieldIndexMap.put(FIELD_PSMODELEXAMPLESTEPID, 12);
        fieldIndexMap.put(FIELD_PSMODELEXAMPLESTEPNAME, 13);
        fieldIndexMap.put(FIELD_STEPSN, 14);
        fieldIndexMap.put(FIELD_TITLE, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

