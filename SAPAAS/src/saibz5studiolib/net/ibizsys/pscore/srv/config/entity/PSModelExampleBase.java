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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.config.entity.PSModelExample;
import net.ibizsys.pscore.srv.config.entity.PSModelExampleCat;
import net.ibizsys.pscore.srv.config.entity.PSModelExampleStep;
import net.ibizsys.pscore.srv.config.service.PSModelExampleCatService;
import net.ibizsys.pscore.srv.config.service.PSModelExampleService;
import net.ibizsys.pscore.srv.config.service.PSModelExampleStepService;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelExampleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelExampleBase.class);
    public static final String FIELD_BOTTOMCONTENT = "BOTTOMCONTENT";
    public static final String FIELD_CATORDERVALUE = "CATORDERVALUE";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CONTENTASCODE = "CONTENTASCODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DOCURL = "DOCURL";
    public static final String FIELD_EXAMDESC = "EXAMDESC";
    public static final String FIELD_EXAMPLESN = "EXAMPLESN";
    public static final String FIELD_EXAMPLETYPE = "EXAMPLETYPE";
    public static final String FIELD_EXAMPLEURL = "EXAMPLEURL";
    public static final String FIELD_HEADERCONTENT = "HEADERCONTENT";
    public static final String FIELD_IMAGEFLAG = "IMAGEFLAG";
    public static final String FIELD_LINKFLAG = "LINKFLAG";
    public static final String FIELD_MAJORFLAG = "MAJORFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODELEXAMPLECATID = "PSMODELEXAMPLECATID";
    public static final String FIELD_PSMODELEXAMPLECATNAME = "PSMODELEXAMPLECATNAME";
    public static final String FIELD_PSMODELEXAMPLEID = "PSMODELEXAMPLEID";
    public static final String FIELD_PSMODELEXAMPLENAME = "PSMODELEXAMPLENAME";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_REFPSMODELEXAMPLEID = "REFPSMODELEXAMPLEID";
    public static final String FIELD_REFPSMODELEXAMPLENAME = "REFPSMODELEXAMPLENAME";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_UIACTIONSN = "UIACTIONSN";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BOTTOMCONTENT = 0;
    private static final int INDEX_CATORDERVALUE = 1;
    private static final int INDEX_CONTENT = 2;
    private static final int INDEX_CONTENTASCODE = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_DOCURL = 6;
    private static final int INDEX_EXAMDESC = 7;
    private static final int INDEX_EXAMPLESN = 8;
    private static final int INDEX_EXAMPLETYPE = 9;
    private static final int INDEX_EXAMPLEURL = 10;
    private static final int INDEX_HEADERCONTENT = 11;
    private static final int INDEX_IMAGEFLAG = 12;
    private static final int INDEX_LINKFLAG = 13;
    private static final int INDEX_MAJORFLAG = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_ORDERVALUE = 16;
    private static final int INDEX_PSMODELEXAMPLECATID = 17;
    private static final int INDEX_PSMODELEXAMPLECATNAME = 18;
    private static final int INDEX_PSMODELEXAMPLEID = 19;
    private static final int INDEX_PSMODELEXAMPLENAME = 20;
    private static final int INDEX_PSMODELID = 21;
    private static final int INDEX_PSMODELNAME = 22;
    private static final int INDEX_REFPSMODELEXAMPLEID = 23;
    private static final int INDEX_REFPSMODELEXAMPLENAME = 24;
    private static final int INDEX_TITLE = 25;
    private static final int INDEX_UIACTIONSN = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_VALIDFLAG = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelExampleBase proxyPSModelExampleBase = null;
    private boolean bottomcontentDirtyFlag = false;
    private boolean catordervalueDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean contentascodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean docurlDirtyFlag = false;
    private boolean examdescDirtyFlag = false;
    private boolean examplesnDirtyFlag = false;
    private boolean exampletypeDirtyFlag = false;
    private boolean exampleurlDirtyFlag = false;
    private boolean headercontentDirtyFlag = false;
    private boolean imageflagDirtyFlag = false;
    private boolean linkflagDirtyFlag = false;
    private boolean majorflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmodelexamplecatidDirtyFlag = false;
    private boolean psmodelexamplecatnameDirtyFlag = false;
    private boolean psmodelexampleidDirtyFlag = false;
    private boolean psmodelexamplenameDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean refpsmodelexampleidDirtyFlag = false;
    private boolean refpsmodelexamplenameDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean uiactionsnDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="bottomcontent")
    private String bottomcontent;
    @Column(name="catordervalue")
    private Integer catordervalue;
    @Column(name="content")
    private String content;
    @Column(name="contentascode")
    private Integer contentascode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="docurl")
    private String docurl;
    @Column(name="examdesc")
    private String examdesc;
    @Column(name="examplesn")
    private String examplesn;
    @Column(name="exampletype")
    private String exampletype;
    @Column(name="exampleurl")
    private String exampleurl;
    @Column(name="headercontent")
    private String headercontent;
    @Column(name="imageflag")
    private Integer imageflag;
    @Column(name="linkflag")
    private Integer linkflag;
    @Column(name="majorflag")
    private Integer majorflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmodelexamplecatid")
    private String psmodelexamplecatid;
    @Column(name="psmodelexamplecatname")
    private String psmodelexamplecatname;
    @Column(name="psmodelexampleid")
    private String psmodelexampleid;
    @Column(name="psmodelexamplename")
    private String psmodelexamplename;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="refpsmodelexampleid")
    private String refpsmodelexampleid;
    @Column(name="refpsmodelexamplename")
    private String refpsmodelexamplename;
    @Column(name="title")
    private String title;
    @Column(name="uiactionsn")
    private String uiactionsn;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSModelExampleCatLock = new Integer(1);
    private PSModelExampleCat psmodelexamplecat = null;
    private Integer objRefPSModelExampleLock = new Integer(1);
    private PSModelExample refpsmodelexample = null;
    private Integer objPSModelLock = new Integer(1);
    private PSModel psmodel = null;
    private Integer objPSModelExampleStepsLock = new Integer(1);
    private ArrayList<PSModelExampleStep> psmodelexamplesteps = null;

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

    public void setCatOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCatOrderValue(n);
            return;
        }
        this.catordervalue = n;
        this.catordervalueDirtyFlag = true;
    }

    public Integer getCatOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCatOrderValue();
        }
        return this.catordervalue;
    }

    public boolean isCatOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCatOrderValueDirty();
        }
        return this.catordervalueDirtyFlag;
    }

    public void resetCatOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCatOrderValue();
            return;
        }
        this.catordervalueDirtyFlag = false;
        this.catordervalue = null;
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

    public void setDocUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDocUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.docurl = string;
        this.docurlDirtyFlag = true;
    }

    public String getDocUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDocUrl();
        }
        return this.docurl;
    }

    public boolean isDocUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDocUrlDirty();
        }
        return this.docurlDirtyFlag;
    }

    public void resetDocUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDocUrl();
            return;
        }
        this.docurlDirtyFlag = false;
        this.docurl = null;
    }

    public void setExamDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExamDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.examdesc = string;
        this.examdescDirtyFlag = true;
    }

    public String getExamDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExamDesc();
        }
        return this.examdesc;
    }

    public boolean isExamDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExamDescDirty();
        }
        return this.examdescDirtyFlag;
    }

    public void resetExamDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExamDesc();
            return;
        }
        this.examdescDirtyFlag = false;
        this.examdesc = null;
    }

    public void setExampleSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExampleSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.examplesn = string;
        this.examplesnDirtyFlag = true;
    }

    public String getExampleSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExampleSN();
        }
        return this.examplesn;
    }

    public boolean isExampleSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExampleSNDirty();
        }
        return this.examplesnDirtyFlag;
    }

    public void resetExampleSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExampleSN();
            return;
        }
        this.examplesnDirtyFlag = false;
        this.examplesn = null;
    }

    public void setExampleType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExampleType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exampletype = string;
        this.exampletypeDirtyFlag = true;
    }

    public String getExampleType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExampleType();
        }
        return this.exampletype;
    }

    public boolean isExampleTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExampleTypeDirty();
        }
        return this.exampletypeDirtyFlag;
    }

    public void resetExampleType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExampleType();
            return;
        }
        this.exampletypeDirtyFlag = false;
        this.exampletype = null;
    }

    public void setExampleUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExampleUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.exampleurl = string;
        this.exampleurlDirtyFlag = true;
    }

    public String getExampleUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExampleUrl();
        }
        return this.exampleurl;
    }

    public boolean isExampleUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExampleUrlDirty();
        }
        return this.exampleurlDirtyFlag;
    }

    public void resetExampleUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExampleUrl();
            return;
        }
        this.exampleurlDirtyFlag = false;
        this.exampleurl = null;
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

    public void setMajorFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorFlag(n);
            return;
        }
        this.majorflag = n;
        this.majorflagDirtyFlag = true;
    }

    public Integer getMajorFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorFlag();
        }
        return this.majorflag;
    }

    public boolean isMajorFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorFlagDirty();
        }
        return this.majorflagDirtyFlag;
    }

    public void resetMajorFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorFlag();
            return;
        }
        this.majorflagDirtyFlag = false;
        this.majorflag = null;
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

    public void setPSModelExampleCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelExampleCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelexamplecatid = string;
        this.psmodelexamplecatidDirtyFlag = true;
    }

    public String getPSModelExampleCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelExampleCatId();
        }
        return this.psmodelexamplecatid;
    }

    public boolean isPSModelExampleCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelExampleCatIdDirty();
        }
        return this.psmodelexamplecatidDirtyFlag;
    }

    public void resetPSModelExampleCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelExampleCatId();
            return;
        }
        this.psmodelexamplecatidDirtyFlag = false;
        this.psmodelexamplecatid = null;
    }

    public void setPSModelExampleCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelExampleCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelexamplecatname = string;
        this.psmodelexamplecatnameDirtyFlag = true;
    }

    public String getPSModelExampleCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelExampleCatName();
        }
        return this.psmodelexamplecatname;
    }

    public boolean isPSModelExampleCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelExampleCatNameDirty();
        }
        return this.psmodelexamplecatnameDirtyFlag;
    }

    public void resetPSModelExampleCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelExampleCatName();
            return;
        }
        this.psmodelexamplecatnameDirtyFlag = false;
        this.psmodelexamplecatname = null;
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

    public void setRefPSModelExampleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSModelExampleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsmodelexampleid = string;
        this.refpsmodelexampleidDirtyFlag = true;
    }

    public String getRefPSModelExampleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSModelExampleId();
        }
        return this.refpsmodelexampleid;
    }

    public boolean isRefPSModelExampleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSModelExampleIdDirty();
        }
        return this.refpsmodelexampleidDirtyFlag;
    }

    public void resetRefPSModelExampleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSModelExampleId();
            return;
        }
        this.refpsmodelexampleidDirtyFlag = false;
        this.refpsmodelexampleid = null;
    }

    public void setRefPSModelExampleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSModelExampleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsmodelexamplename = string;
        this.refpsmodelexamplenameDirtyFlag = true;
    }

    public String getRefPSModelExampleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSModelExampleName();
        }
        return this.refpsmodelexamplename;
    }

    public boolean isRefPSModelExampleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSModelExampleNameDirty();
        }
        return this.refpsmodelexamplenameDirtyFlag;
    }

    public void resetRefPSModelExampleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSModelExampleName();
            return;
        }
        this.refpsmodelexamplenameDirtyFlag = false;
        this.refpsmodelexamplename = null;
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

    public void setUIActionSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uiactionsn = string;
        this.uiactionsnDirtyFlag = true;
    }

    public String getUIActionSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionSN();
        }
        return this.uiactionsn;
    }

    public boolean isUIActionSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionSNDirty();
        }
        return this.uiactionsnDirtyFlag;
    }

    public void resetUIActionSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionSN();
            return;
        }
        this.uiactionsnDirtyFlag = false;
        this.uiactionsn = null;
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
        PSModelExampleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelExampleBase pSModelExampleBase) {
        pSModelExampleBase.resetBottomContent();
        pSModelExampleBase.resetCatOrderValue();
        pSModelExampleBase.resetContent();
        pSModelExampleBase.resetContentAsCode();
        pSModelExampleBase.resetCreateDate();
        pSModelExampleBase.resetCreateMan();
        pSModelExampleBase.resetDocUrl();
        pSModelExampleBase.resetExamDesc();
        pSModelExampleBase.resetExampleSN();
        pSModelExampleBase.resetExampleType();
        pSModelExampleBase.resetExampleUrl();
        pSModelExampleBase.resetHeaderContent();
        pSModelExampleBase.resetImageFlag();
        pSModelExampleBase.resetLinkFlag();
        pSModelExampleBase.resetMajorFlag();
        pSModelExampleBase.resetMemo();
        pSModelExampleBase.resetOrderValue();
        pSModelExampleBase.resetPSModelExampleCatId();
        pSModelExampleBase.resetPSModelExampleCatName();
        pSModelExampleBase.resetPSModelExampleId();
        pSModelExampleBase.resetPSModelExampleName();
        pSModelExampleBase.resetPSModelId();
        pSModelExampleBase.resetPSModelName();
        pSModelExampleBase.resetRefPSModelExampleId();
        pSModelExampleBase.resetRefPSModelExampleName();
        pSModelExampleBase.resetTitle();
        pSModelExampleBase.resetUIActionSN();
        pSModelExampleBase.resetUpdateDate();
        pSModelExampleBase.resetUpdateMan();
        pSModelExampleBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBottomContentDirty()) {
            hashMap.put(FIELD_BOTTOMCONTENT, this.getBottomContent());
        }
        if (!bl || this.isCatOrderValueDirty()) {
            hashMap.put(FIELD_CATORDERVALUE, this.getCatOrderValue());
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
        if (!bl || this.isDocUrlDirty()) {
            hashMap.put(FIELD_DOCURL, this.getDocUrl());
        }
        if (!bl || this.isExamDescDirty()) {
            hashMap.put(FIELD_EXAMDESC, this.getExamDesc());
        }
        if (!bl || this.isExampleSNDirty()) {
            hashMap.put(FIELD_EXAMPLESN, this.getExampleSN());
        }
        if (!bl || this.isExampleTypeDirty()) {
            hashMap.put(FIELD_EXAMPLETYPE, this.getExampleType());
        }
        if (!bl || this.isExampleUrlDirty()) {
            hashMap.put(FIELD_EXAMPLEURL, this.getExampleUrl());
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
        if (!bl || this.isMajorFlagDirty()) {
            hashMap.put(FIELD_MAJORFLAG, this.getMajorFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSModelExampleCatIdDirty()) {
            hashMap.put(FIELD_PSMODELEXAMPLECATID, this.getPSModelExampleCatId());
        }
        if (!bl || this.isPSModelExampleCatNameDirty()) {
            hashMap.put(FIELD_PSMODELEXAMPLECATNAME, this.getPSModelExampleCatName());
        }
        if (!bl || this.isPSModelExampleIdDirty()) {
            hashMap.put(FIELD_PSMODELEXAMPLEID, this.getPSModelExampleId());
        }
        if (!bl || this.isPSModelExampleNameDirty()) {
            hashMap.put(FIELD_PSMODELEXAMPLENAME, this.getPSModelExampleName());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
        }
        if (!bl || this.isRefPSModelExampleIdDirty()) {
            hashMap.put(FIELD_REFPSMODELEXAMPLEID, this.getRefPSModelExampleId());
        }
        if (!bl || this.isRefPSModelExampleNameDirty()) {
            hashMap.put(FIELD_REFPSMODELEXAMPLENAME, this.getRefPSModelExampleName());
        }
        if (!bl || this.isTitleDirty()) {
            hashMap.put(FIELD_TITLE, this.getTitle());
        }
        if (!bl || this.isUIActionSNDirty()) {
            hashMap.put(FIELD_UIACTIONSN, this.getUIActionSN());
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
        return PSModelExampleBase.get(this, n);
    }

    private static Object get(PSModelExampleBase pSModelExampleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelExampleBase.getBottomContent();
            }
            case 1: {
                return pSModelExampleBase.getCatOrderValue();
            }
            case 2: {
                return pSModelExampleBase.getContent();
            }
            case 3: {
                return pSModelExampleBase.getContentAsCode();
            }
            case 4: {
                return pSModelExampleBase.getCreateDate();
            }
            case 5: {
                return pSModelExampleBase.getCreateMan();
            }
            case 6: {
                return pSModelExampleBase.getDocUrl();
            }
            case 7: {
                return pSModelExampleBase.getExamDesc();
            }
            case 8: {
                return pSModelExampleBase.getExampleSN();
            }
            case 9: {
                return pSModelExampleBase.getExampleType();
            }
            case 10: {
                return pSModelExampleBase.getExampleUrl();
            }
            case 11: {
                return pSModelExampleBase.getHeaderContent();
            }
            case 12: {
                return pSModelExampleBase.getImageFlag();
            }
            case 13: {
                return pSModelExampleBase.getLinkFlag();
            }
            case 14: {
                return pSModelExampleBase.getMajorFlag();
            }
            case 15: {
                return pSModelExampleBase.getMemo();
            }
            case 16: {
                return pSModelExampleBase.getOrderValue();
            }
            case 17: {
                return pSModelExampleBase.getPSModelExampleCatId();
            }
            case 18: {
                return pSModelExampleBase.getPSModelExampleCatName();
            }
            case 19: {
                return pSModelExampleBase.getPSModelExampleId();
            }
            case 20: {
                return pSModelExampleBase.getPSModelExampleName();
            }
            case 21: {
                return pSModelExampleBase.getPSModelId();
            }
            case 22: {
                return pSModelExampleBase.getPSModelName();
            }
            case 23: {
                return pSModelExampleBase.getRefPSModelExampleId();
            }
            case 24: {
                return pSModelExampleBase.getRefPSModelExampleName();
            }
            case 25: {
                return pSModelExampleBase.getTitle();
            }
            case 26: {
                return pSModelExampleBase.getUIActionSN();
            }
            case 27: {
                return pSModelExampleBase.getUpdateDate();
            }
            case 28: {
                return pSModelExampleBase.getUpdateMan();
            }
            case 29: {
                return pSModelExampleBase.getValidFlag();
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
        PSModelExampleBase.set(this, n, object);
    }

    private static void set(PSModelExampleBase pSModelExampleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelExampleBase.setBottomContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModelExampleBase.setCatOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSModelExampleBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelExampleBase.setContentAsCode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSModelExampleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSModelExampleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelExampleBase.setDocUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelExampleBase.setExamDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelExampleBase.setExampleSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelExampleBase.setExampleType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelExampleBase.setExampleUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelExampleBase.setHeaderContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelExampleBase.setImageFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSModelExampleBase.setLinkFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSModelExampleBase.setMajorFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSModelExampleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSModelExampleBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSModelExampleBase.setPSModelExampleCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSModelExampleBase.setPSModelExampleCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSModelExampleBase.setPSModelExampleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSModelExampleBase.setPSModelExampleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSModelExampleBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSModelExampleBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSModelExampleBase.setRefPSModelExampleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSModelExampleBase.setRefPSModelExampleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSModelExampleBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSModelExampleBase.setUIActionSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSModelExampleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSModelExampleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSModelExampleBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSModelExampleBase.isNull(this, n);
    }

    private static boolean isNull(PSModelExampleBase pSModelExampleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelExampleBase.getBottomContent() == null;
            }
            case 1: {
                return pSModelExampleBase.getCatOrderValue() == null;
            }
            case 2: {
                return pSModelExampleBase.getContent() == null;
            }
            case 3: {
                return pSModelExampleBase.getContentAsCode() == null;
            }
            case 4: {
                return pSModelExampleBase.getCreateDate() == null;
            }
            case 5: {
                return pSModelExampleBase.getCreateMan() == null;
            }
            case 6: {
                return pSModelExampleBase.getDocUrl() == null;
            }
            case 7: {
                return pSModelExampleBase.getExamDesc() == null;
            }
            case 8: {
                return pSModelExampleBase.getExampleSN() == null;
            }
            case 9: {
                return pSModelExampleBase.getExampleType() == null;
            }
            case 10: {
                return pSModelExampleBase.getExampleUrl() == null;
            }
            case 11: {
                return pSModelExampleBase.getHeaderContent() == null;
            }
            case 12: {
                return pSModelExampleBase.getImageFlag() == null;
            }
            case 13: {
                return pSModelExampleBase.getLinkFlag() == null;
            }
            case 14: {
                return pSModelExampleBase.getMajorFlag() == null;
            }
            case 15: {
                return pSModelExampleBase.getMemo() == null;
            }
            case 16: {
                return pSModelExampleBase.getOrderValue() == null;
            }
            case 17: {
                return pSModelExampleBase.getPSModelExampleCatId() == null;
            }
            case 18: {
                return pSModelExampleBase.getPSModelExampleCatName() == null;
            }
            case 19: {
                return pSModelExampleBase.getPSModelExampleId() == null;
            }
            case 20: {
                return pSModelExampleBase.getPSModelExampleName() == null;
            }
            case 21: {
                return pSModelExampleBase.getPSModelId() == null;
            }
            case 22: {
                return pSModelExampleBase.getPSModelName() == null;
            }
            case 23: {
                return pSModelExampleBase.getRefPSModelExampleId() == null;
            }
            case 24: {
                return pSModelExampleBase.getRefPSModelExampleName() == null;
            }
            case 25: {
                return pSModelExampleBase.getTitle() == null;
            }
            case 26: {
                return pSModelExampleBase.getUIActionSN() == null;
            }
            case 27: {
                return pSModelExampleBase.getUpdateDate() == null;
            }
            case 28: {
                return pSModelExampleBase.getUpdateMan() == null;
            }
            case 29: {
                return pSModelExampleBase.getValidFlag() == null;
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
        return PSModelExampleBase.contains(this, n);
    }

    private static boolean contains(PSModelExampleBase pSModelExampleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelExampleBase.isBottomContentDirty();
            }
            case 1: {
                return pSModelExampleBase.isCatOrderValueDirty();
            }
            case 2: {
                return pSModelExampleBase.isContentDirty();
            }
            case 3: {
                return pSModelExampleBase.isContentAsCodeDirty();
            }
            case 4: {
                return pSModelExampleBase.isCreateDateDirty();
            }
            case 5: {
                return pSModelExampleBase.isCreateManDirty();
            }
            case 6: {
                return pSModelExampleBase.isDocUrlDirty();
            }
            case 7: {
                return pSModelExampleBase.isExamDescDirty();
            }
            case 8: {
                return pSModelExampleBase.isExampleSNDirty();
            }
            case 9: {
                return pSModelExampleBase.isExampleTypeDirty();
            }
            case 10: {
                return pSModelExampleBase.isExampleUrlDirty();
            }
            case 11: {
                return pSModelExampleBase.isHeaderContentDirty();
            }
            case 12: {
                return pSModelExampleBase.isImageFlagDirty();
            }
            case 13: {
                return pSModelExampleBase.isLinkFlagDirty();
            }
            case 14: {
                return pSModelExampleBase.isMajorFlagDirty();
            }
            case 15: {
                return pSModelExampleBase.isMemoDirty();
            }
            case 16: {
                return pSModelExampleBase.isOrderValueDirty();
            }
            case 17: {
                return pSModelExampleBase.isPSModelExampleCatIdDirty();
            }
            case 18: {
                return pSModelExampleBase.isPSModelExampleCatNameDirty();
            }
            case 19: {
                return pSModelExampleBase.isPSModelExampleIdDirty();
            }
            case 20: {
                return pSModelExampleBase.isPSModelExampleNameDirty();
            }
            case 21: {
                return pSModelExampleBase.isPSModelIdDirty();
            }
            case 22: {
                return pSModelExampleBase.isPSModelNameDirty();
            }
            case 23: {
                return pSModelExampleBase.isRefPSModelExampleIdDirty();
            }
            case 24: {
                return pSModelExampleBase.isRefPSModelExampleNameDirty();
            }
            case 25: {
                return pSModelExampleBase.isTitleDirty();
            }
            case 26: {
                return pSModelExampleBase.isUIActionSNDirty();
            }
            case 27: {
                return pSModelExampleBase.isUpdateDateDirty();
            }
            case 28: {
                return pSModelExampleBase.isUpdateManDirty();
            }
            case 29: {
                return pSModelExampleBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelExampleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelExampleBase pSModelExampleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelExampleBase.getBottomContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottomcontent", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getBottomContent()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getCatOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"catordervalue", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getCatOrderValue()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getContent()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getContentAsCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contentascode", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getContentAsCode()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getDocUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"docurl", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getDocUrl()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getExamDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"examdesc", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getExamDesc()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getExampleSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"examplesn", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getExampleSN()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getExampleType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exampletype", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getExampleType()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getExampleUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exampleurl", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getExampleUrl()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getHeaderContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headercontent", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getHeaderContent()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getImageFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imageflag", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getImageFlag()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getLinkFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkflag", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getLinkFlag()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getMajorFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorflag", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getMajorFlag()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getPSModelExampleCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelexamplecatid", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getPSModelExampleCatId()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getPSModelExampleCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelexamplecatname", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getPSModelExampleCatName()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getPSModelExampleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelexampleid", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getPSModelExampleId()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getPSModelExampleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelexamplename", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getPSModelExampleName()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getRefPSModelExampleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsmodelexampleid", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getRefPSModelExampleId()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getRefPSModelExampleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsmodelexamplename", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getRefPSModelExampleName()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getTitle()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getUIActionSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionsn", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getUIActionSN()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelExampleBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelExampleBase.getJSONValue((Object)pSModelExampleBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelExampleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelExampleBase pSModelExampleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelExampleBase.getBottomContent() != null) {
            object = pSModelExampleBase.getBottomContent();
            xmlNode.setAttribute(FIELD_BOTTOMCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getCatOrderValue() != null) {
            object = pSModelExampleBase.getCatOrderValue();
            xmlNode.setAttribute(FIELD_CATORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelExampleBase.getContent() != null) {
            object = pSModelExampleBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getContentAsCode() != null) {
            object = pSModelExampleBase.getContentAsCode();
            xmlNode.setAttribute(FIELD_CONTENTASCODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelExampleBase.getCreateDate() != null) {
            object = pSModelExampleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelExampleBase.getCreateMan() != null) {
            object = pSModelExampleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getDocUrl() != null) {
            object = pSModelExampleBase.getDocUrl();
            xmlNode.setAttribute(FIELD_DOCURL, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getExamDesc() != null) {
            object = pSModelExampleBase.getExamDesc();
            xmlNode.setAttribute(FIELD_EXAMDESC, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getExampleSN() != null) {
            object = pSModelExampleBase.getExampleSN();
            xmlNode.setAttribute(FIELD_EXAMPLESN, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getExampleType() != null) {
            object = pSModelExampleBase.getExampleType();
            xmlNode.setAttribute(FIELD_EXAMPLETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getExampleUrl() != null) {
            object = pSModelExampleBase.getExampleUrl();
            xmlNode.setAttribute(FIELD_EXAMPLEURL, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getHeaderContent() != null) {
            object = pSModelExampleBase.getHeaderContent();
            xmlNode.setAttribute(FIELD_HEADERCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getImageFlag() != null) {
            object = pSModelExampleBase.getImageFlag();
            xmlNode.setAttribute(FIELD_IMAGEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelExampleBase.getLinkFlag() != null) {
            object = pSModelExampleBase.getLinkFlag();
            xmlNode.setAttribute(FIELD_LINKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelExampleBase.getMajorFlag() != null) {
            object = pSModelExampleBase.getMajorFlag();
            xmlNode.setAttribute(FIELD_MAJORFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelExampleBase.getMemo() != null) {
            object = pSModelExampleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getOrderValue() != null) {
            object = pSModelExampleBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelExampleBase.getPSModelExampleCatId() != null) {
            object = pSModelExampleBase.getPSModelExampleCatId();
            xmlNode.setAttribute(FIELD_PSMODELEXAMPLECATID, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getPSModelExampleCatName() != null) {
            object = pSModelExampleBase.getPSModelExampleCatName();
            xmlNode.setAttribute(FIELD_PSMODELEXAMPLECATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getPSModelExampleId() != null) {
            object = pSModelExampleBase.getPSModelExampleId();
            xmlNode.setAttribute(FIELD_PSMODELEXAMPLEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getPSModelExampleName() != null) {
            object = pSModelExampleBase.getPSModelExampleName();
            xmlNode.setAttribute(FIELD_PSMODELEXAMPLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getPSModelId() != null) {
            object = pSModelExampleBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getPSModelName() != null) {
            object = pSModelExampleBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getRefPSModelExampleId() != null) {
            object = pSModelExampleBase.getRefPSModelExampleId();
            xmlNode.setAttribute(FIELD_REFPSMODELEXAMPLEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getRefPSModelExampleName() != null) {
            object = pSModelExampleBase.getRefPSModelExampleName();
            xmlNode.setAttribute(FIELD_REFPSMODELEXAMPLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getTitle() != null) {
            object = pSModelExampleBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getUIActionSN() != null) {
            object = pSModelExampleBase.getUIActionSN();
            xmlNode.setAttribute(FIELD_UIACTIONSN, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getUpdateDate() != null) {
            object = pSModelExampleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelExampleBase.getUpdateMan() != null) {
            object = pSModelExampleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleBase.getValidFlag() != null) {
            object = pSModelExampleBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelExampleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelExampleBase pSModelExampleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelExampleBase.isBottomContentDirty() && (bl || pSModelExampleBase.getBottomContent() != null)) {
            iDataObject.set(FIELD_BOTTOMCONTENT, (Object)pSModelExampleBase.getBottomContent());
        }
        if (pSModelExampleBase.isCatOrderValueDirty() && (bl || pSModelExampleBase.getCatOrderValue() != null)) {
            iDataObject.set(FIELD_CATORDERVALUE, (Object)pSModelExampleBase.getCatOrderValue());
        }
        if (pSModelExampleBase.isContentDirty() && (bl || pSModelExampleBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSModelExampleBase.getContent());
        }
        if (pSModelExampleBase.isContentAsCodeDirty() && (bl || pSModelExampleBase.getContentAsCode() != null)) {
            iDataObject.set(FIELD_CONTENTASCODE, (Object)pSModelExampleBase.getContentAsCode());
        }
        if (pSModelExampleBase.isCreateDateDirty() && (bl || pSModelExampleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelExampleBase.getCreateDate());
        }
        if (pSModelExampleBase.isCreateManDirty() && (bl || pSModelExampleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelExampleBase.getCreateMan());
        }
        if (pSModelExampleBase.isDocUrlDirty() && (bl || pSModelExampleBase.getDocUrl() != null)) {
            iDataObject.set(FIELD_DOCURL, (Object)pSModelExampleBase.getDocUrl());
        }
        if (pSModelExampleBase.isExamDescDirty() && (bl || pSModelExampleBase.getExamDesc() != null)) {
            iDataObject.set(FIELD_EXAMDESC, (Object)pSModelExampleBase.getExamDesc());
        }
        if (pSModelExampleBase.isExampleSNDirty() && (bl || pSModelExampleBase.getExampleSN() != null)) {
            iDataObject.set(FIELD_EXAMPLESN, (Object)pSModelExampleBase.getExampleSN());
        }
        if (pSModelExampleBase.isExampleTypeDirty() && (bl || pSModelExampleBase.getExampleType() != null)) {
            iDataObject.set(FIELD_EXAMPLETYPE, (Object)pSModelExampleBase.getExampleType());
        }
        if (pSModelExampleBase.isExampleUrlDirty() && (bl || pSModelExampleBase.getExampleUrl() != null)) {
            iDataObject.set(FIELD_EXAMPLEURL, (Object)pSModelExampleBase.getExampleUrl());
        }
        if (pSModelExampleBase.isHeaderContentDirty() && (bl || pSModelExampleBase.getHeaderContent() != null)) {
            iDataObject.set(FIELD_HEADERCONTENT, (Object)pSModelExampleBase.getHeaderContent());
        }
        if (pSModelExampleBase.isImageFlagDirty() && (bl || pSModelExampleBase.getImageFlag() != null)) {
            iDataObject.set(FIELD_IMAGEFLAG, (Object)pSModelExampleBase.getImageFlag());
        }
        if (pSModelExampleBase.isLinkFlagDirty() && (bl || pSModelExampleBase.getLinkFlag() != null)) {
            iDataObject.set(FIELD_LINKFLAG, (Object)pSModelExampleBase.getLinkFlag());
        }
        if (pSModelExampleBase.isMajorFlagDirty() && (bl || pSModelExampleBase.getMajorFlag() != null)) {
            iDataObject.set(FIELD_MAJORFLAG, (Object)pSModelExampleBase.getMajorFlag());
        }
        if (pSModelExampleBase.isMemoDirty() && (bl || pSModelExampleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelExampleBase.getMemo());
        }
        if (pSModelExampleBase.isOrderValueDirty() && (bl || pSModelExampleBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModelExampleBase.getOrderValue());
        }
        if (pSModelExampleBase.isPSModelExampleCatIdDirty() && (bl || pSModelExampleBase.getPSModelExampleCatId() != null)) {
            iDataObject.set(FIELD_PSMODELEXAMPLECATID, (Object)pSModelExampleBase.getPSModelExampleCatId());
        }
        if (pSModelExampleBase.isPSModelExampleCatNameDirty() && (bl || pSModelExampleBase.getPSModelExampleCatName() != null)) {
            iDataObject.set(FIELD_PSMODELEXAMPLECATNAME, (Object)pSModelExampleBase.getPSModelExampleCatName());
        }
        if (pSModelExampleBase.isPSModelExampleIdDirty() && (bl || pSModelExampleBase.getPSModelExampleId() != null)) {
            iDataObject.set(FIELD_PSMODELEXAMPLEID, (Object)pSModelExampleBase.getPSModelExampleId());
        }
        if (pSModelExampleBase.isPSModelExampleNameDirty() && (bl || pSModelExampleBase.getPSModelExampleName() != null)) {
            iDataObject.set(FIELD_PSMODELEXAMPLENAME, (Object)pSModelExampleBase.getPSModelExampleName());
        }
        if (pSModelExampleBase.isPSModelIdDirty() && (bl || pSModelExampleBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelExampleBase.getPSModelId());
        }
        if (pSModelExampleBase.isPSModelNameDirty() && (bl || pSModelExampleBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSModelExampleBase.getPSModelName());
        }
        if (pSModelExampleBase.isRefPSModelExampleIdDirty() && (bl || pSModelExampleBase.getRefPSModelExampleId() != null)) {
            iDataObject.set(FIELD_REFPSMODELEXAMPLEID, (Object)pSModelExampleBase.getRefPSModelExampleId());
        }
        if (pSModelExampleBase.isRefPSModelExampleNameDirty() && (bl || pSModelExampleBase.getRefPSModelExampleName() != null)) {
            iDataObject.set(FIELD_REFPSMODELEXAMPLENAME, (Object)pSModelExampleBase.getRefPSModelExampleName());
        }
        if (pSModelExampleBase.isTitleDirty() && (bl || pSModelExampleBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSModelExampleBase.getTitle());
        }
        if (pSModelExampleBase.isUIActionSNDirty() && (bl || pSModelExampleBase.getUIActionSN() != null)) {
            iDataObject.set(FIELD_UIACTIONSN, (Object)pSModelExampleBase.getUIActionSN());
        }
        if (pSModelExampleBase.isUpdateDateDirty() && (bl || pSModelExampleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelExampleBase.getUpdateDate());
        }
        if (pSModelExampleBase.isUpdateManDirty() && (bl || pSModelExampleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelExampleBase.getUpdateMan());
        }
        if (pSModelExampleBase.isValidFlagDirty() && (bl || pSModelExampleBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelExampleBase.getValidFlag());
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
        return PSModelExampleBase.remove(this, n);
    }

    private static boolean remove(PSModelExampleBase pSModelExampleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelExampleBase.resetBottomContent();
                return true;
            }
            case 1: {
                pSModelExampleBase.resetCatOrderValue();
                return true;
            }
            case 2: {
                pSModelExampleBase.resetContent();
                return true;
            }
            case 3: {
                pSModelExampleBase.resetContentAsCode();
                return true;
            }
            case 4: {
                pSModelExampleBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSModelExampleBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSModelExampleBase.resetDocUrl();
                return true;
            }
            case 7: {
                pSModelExampleBase.resetExamDesc();
                return true;
            }
            case 8: {
                pSModelExampleBase.resetExampleSN();
                return true;
            }
            case 9: {
                pSModelExampleBase.resetExampleType();
                return true;
            }
            case 10: {
                pSModelExampleBase.resetExampleUrl();
                return true;
            }
            case 11: {
                pSModelExampleBase.resetHeaderContent();
                return true;
            }
            case 12: {
                pSModelExampleBase.resetImageFlag();
                return true;
            }
            case 13: {
                pSModelExampleBase.resetLinkFlag();
                return true;
            }
            case 14: {
                pSModelExampleBase.resetMajorFlag();
                return true;
            }
            case 15: {
                pSModelExampleBase.resetMemo();
                return true;
            }
            case 16: {
                pSModelExampleBase.resetOrderValue();
                return true;
            }
            case 17: {
                pSModelExampleBase.resetPSModelExampleCatId();
                return true;
            }
            case 18: {
                pSModelExampleBase.resetPSModelExampleCatName();
                return true;
            }
            case 19: {
                pSModelExampleBase.resetPSModelExampleId();
                return true;
            }
            case 20: {
                pSModelExampleBase.resetPSModelExampleName();
                return true;
            }
            case 21: {
                pSModelExampleBase.resetPSModelId();
                return true;
            }
            case 22: {
                pSModelExampleBase.resetPSModelName();
                return true;
            }
            case 23: {
                pSModelExampleBase.resetRefPSModelExampleId();
                return true;
            }
            case 24: {
                pSModelExampleBase.resetRefPSModelExampleName();
                return true;
            }
            case 25: {
                pSModelExampleBase.resetTitle();
                return true;
            }
            case 26: {
                pSModelExampleBase.resetUIActionSN();
                return true;
            }
            case 27: {
                pSModelExampleBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSModelExampleBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSModelExampleBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelExampleCat getPSModelExampleCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelExampleCat();
        }
        if (this.getPSModelExampleCatId() == null) {
            return null;
        }
        Integer n = this.objPSModelExampleCatLock;
        synchronized (n) {
            if (this.psmodelexamplecat != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelExampleCatId(), (Object)this.psmodelexamplecat.getPSModelExampleCatId()) != 0L) {
                this.psmodelexamplecat = null;
            }
            if (this.psmodelexamplecat == null) {
                PSModelExampleCat pSModelExampleCat = new PSModelExampleCat();
                pSModelExampleCat.setPSModelExampleCatId(this.getPSModelExampleCatId());
                PSModelExampleCatService pSModelExampleCatService = (PSModelExampleCatService)ServiceGlobal.getService(PSModelExampleCatService.class, (SessionFactory)this.getSessionFactory());
                pSModelExampleCatService.autoGet((IEntity)pSModelExampleCat);
                this.psmodelexamplecat = pSModelExampleCat;
            }
            return this.psmodelexamplecat;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelExample getRefPSModelExample() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSModelExample();
        }
        if (this.getRefPSModelExampleId() == null) {
            return null;
        }
        Integer n = this.objRefPSModelExampleLock;
        synchronized (n) {
            if (this.refpsmodelexample != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSModelExampleId(), (Object)this.refpsmodelexample.getPSModelExampleId()) != 0L) {
                this.refpsmodelexample = null;
            }
            if (this.refpsmodelexample == null) {
                PSModelExample pSModelExample = new PSModelExample();
                pSModelExample.setPSModelExampleId(this.getRefPSModelExampleId());
                PSModelExampleService pSModelExampleService = (PSModelExampleService)ServiceGlobal.getService(PSModelExampleService.class, (SessionFactory)this.getSessionFactory());
                pSModelExampleService.autoGet((IEntity)pSModelExample);
                this.refpsmodelexample = pSModelExample;
            }
            return this.refpsmodelexample;
        }
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSModelExampleStep> getPSModelExampleSteps() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelExampleSteps();
        }
        if (this.getPSModelExampleId() == null) {
            return null;
        }
        PSModelExampleStepService pSModelExampleStepService = (PSModelExampleStepService)ServiceGlobal.getService(PSModelExampleStepService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSModelExampleStepsLock;
        synchronized (n) {
            if (this.psmodelexamplesteps == null) {
                this.psmodelexamplesteps = pSModelExampleStepService.selectByPSModelExample(this);
            }
            return this.psmodelexamplesteps;
        }
    }

    private PSModelExampleBase getProxyEntity() {
        return this.proxyPSModelExampleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelExampleBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelExampleBase) {
            this.proxyPSModelExampleBase = (PSModelExampleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelExampleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BOTTOMCONTENT, 0);
        fieldIndexMap.put(FIELD_CATORDERVALUE, 1);
        fieldIndexMap.put(FIELD_CONTENT, 2);
        fieldIndexMap.put(FIELD_CONTENTASCODE, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_DOCURL, 6);
        fieldIndexMap.put(FIELD_EXAMDESC, 7);
        fieldIndexMap.put(FIELD_EXAMPLESN, 8);
        fieldIndexMap.put(FIELD_EXAMPLETYPE, 9);
        fieldIndexMap.put(FIELD_EXAMPLEURL, 10);
        fieldIndexMap.put(FIELD_HEADERCONTENT, 11);
        fieldIndexMap.put(FIELD_IMAGEFLAG, 12);
        fieldIndexMap.put(FIELD_LINKFLAG, 13);
        fieldIndexMap.put(FIELD_MAJORFLAG, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_ORDERVALUE, 16);
        fieldIndexMap.put(FIELD_PSMODELEXAMPLECATID, 17);
        fieldIndexMap.put(FIELD_PSMODELEXAMPLECATNAME, 18);
        fieldIndexMap.put(FIELD_PSMODELEXAMPLEID, 19);
        fieldIndexMap.put(FIELD_PSMODELEXAMPLENAME, 20);
        fieldIndexMap.put(FIELD_PSMODELID, 21);
        fieldIndexMap.put(FIELD_PSMODELNAME, 22);
        fieldIndexMap.put(FIELD_REFPSMODELEXAMPLEID, 23);
        fieldIndexMap.put(FIELD_REFPSMODELEXAMPLENAME, 24);
        fieldIndexMap.put(FIELD_TITLE, 25);
        fieldIndexMap.put(FIELD_UIACTIONSN, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_VALIDFLAG, 29);
    }
}

