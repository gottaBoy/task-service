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
import net.ibizsys.pscore.srv.config.entity.PSModelExample;
import net.ibizsys.pscore.srv.config.entity.PSModelExampleCat;
import net.ibizsys.pscore.srv.config.service.PSModelExampleCatService;
import net.ibizsys.pscore.srv.config.service.PSModelExampleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelExampleCatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelExampleCatBase.class);
    public static final String FIELD_ARTICLEMODE = "ARTICLEMODE";
    public static final String FIELD_BOTTOMCONTENT = "BOTTOMCONTENT";
    public static final String FIELD_CATSN = "CATSN";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXAMPLETYPE = "EXAMPLETYPE";
    public static final String FIELD_HEADERCONTENT = "HEADERCONTENT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSMODELEXAMPLECATID = "PPSMODELEXAMPLECATID";
    public static final String FIELD_PPSMODELEXAMPLECATNAME = "PPSMODELEXAMPLECATNAME";
    public static final String FIELD_PSMODELEXAMPLECATID = "PSMODELEXAMPLECATID";
    public static final String FIELD_PSMODELEXAMPLECATNAME = "PSMODELEXAMPLECATNAME";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ARTICLEMODE = 0;
    private static final int INDEX_BOTTOMCONTENT = 1;
    private static final int INDEX_CATSN = 2;
    private static final int INDEX_CONTENT = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_EXAMPLETYPE = 6;
    private static final int INDEX_HEADERCONTENT = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_ORDERVALUE = 9;
    private static final int INDEX_PPSMODELEXAMPLECATID = 10;
    private static final int INDEX_PPSMODELEXAMPLECATNAME = 11;
    private static final int INDEX_PSMODELEXAMPLECATID = 12;
    private static final int INDEX_PSMODELEXAMPLECATNAME = 13;
    private static final int INDEX_TITLE = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_VALIDFLAG = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelExampleCatBase proxyPSModelExampleCatBase = null;
    private boolean articlemodeDirtyFlag = false;
    private boolean bottomcontentDirtyFlag = false;
    private boolean catsnDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean exampletypeDirtyFlag = false;
    private boolean headercontentDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsmodelexamplecatidDirtyFlag = false;
    private boolean ppsmodelexamplecatnameDirtyFlag = false;
    private boolean psmodelexamplecatidDirtyFlag = false;
    private boolean psmodelexamplecatnameDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="articlemode")
    private Integer articlemode;
    @Column(name="bottomcontent")
    private String bottomcontent;
    @Column(name="catsn")
    private String catsn;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="exampletype")
    private String exampletype;
    @Column(name="headercontent")
    private String headercontent;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppsmodelexamplecatid")
    private String ppsmodelexamplecatid;
    @Column(name="ppsmodelexamplecatname")
    private String ppsmodelexamplecatname;
    @Column(name="psmodelexamplecatid")
    private String psmodelexamplecatid;
    @Column(name="psmodelexamplecatname")
    private String psmodelexamplecatname;
    @Column(name="title")
    private String title;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPPSModelExampleCatLock = new Integer(1);
    private PSModelExampleCat ppsmodelexamplecat = null;
    private Integer objPSModelExampleCatsLock = new Integer(1);
    private ArrayList<PSModelExampleCat> psmodelexamplecats = null;
    private Integer objPSModelExamplesLock = new Integer(1);
    private ArrayList<PSModelExample> psmodelexamples = null;

    public void setArticleMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleMode(n);
            return;
        }
        this.articlemode = n;
        this.articlemodeDirtyFlag = true;
    }

    public Integer getArticleMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleMode();
        }
        return this.articlemode;
    }

    public boolean isArticleModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleModeDirty();
        }
        return this.articlemodeDirtyFlag;
    }

    public void resetArticleMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleMode();
            return;
        }
        this.articlemodeDirtyFlag = false;
        this.articlemode = null;
    }

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

    public void setCatSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCatSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.catsn = string;
        this.catsnDirtyFlag = true;
    }

    public String getCatSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCatSN();
        }
        return this.catsn;
    }

    public boolean isCatSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCatSNDirty();
        }
        return this.catsnDirtyFlag;
    }

    public void resetCatSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCatSN();
            return;
        }
        this.catsnDirtyFlag = false;
        this.catsn = null;
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

    public void setPPSModelExampleCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSModelExampleCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmodelexamplecatid = string;
        this.ppsmodelexamplecatidDirtyFlag = true;
    }

    public String getPPSModelExampleCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelExampleCatId();
        }
        return this.ppsmodelexamplecatid;
    }

    public boolean isPPSModelExampleCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSModelExampleCatIdDirty();
        }
        return this.ppsmodelexamplecatidDirtyFlag;
    }

    public void resetPPSModelExampleCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSModelExampleCatId();
            return;
        }
        this.ppsmodelexamplecatidDirtyFlag = false;
        this.ppsmodelexamplecatid = null;
    }

    public void setPPSModelExampleCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSModelExampleCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmodelexamplecatname = string;
        this.ppsmodelexamplecatnameDirtyFlag = true;
    }

    public String getPPSModelExampleCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelExampleCatName();
        }
        return this.ppsmodelexamplecatname;
    }

    public boolean isPPSModelExampleCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSModelExampleCatNameDirty();
        }
        return this.ppsmodelexamplecatnameDirtyFlag;
    }

    public void resetPPSModelExampleCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSModelExampleCatName();
            return;
        }
        this.ppsmodelexamplecatnameDirtyFlag = false;
        this.ppsmodelexamplecatname = null;
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
        PSModelExampleCatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelExampleCatBase pSModelExampleCatBase) {
        pSModelExampleCatBase.resetArticleMode();
        pSModelExampleCatBase.resetBottomContent();
        pSModelExampleCatBase.resetCatSN();
        pSModelExampleCatBase.resetContent();
        pSModelExampleCatBase.resetCreateDate();
        pSModelExampleCatBase.resetCreateMan();
        pSModelExampleCatBase.resetExampleType();
        pSModelExampleCatBase.resetHeaderContent();
        pSModelExampleCatBase.resetMemo();
        pSModelExampleCatBase.resetOrderValue();
        pSModelExampleCatBase.resetPPSModelExampleCatId();
        pSModelExampleCatBase.resetPPSModelExampleCatName();
        pSModelExampleCatBase.resetPSModelExampleCatId();
        pSModelExampleCatBase.resetPSModelExampleCatName();
        pSModelExampleCatBase.resetTitle();
        pSModelExampleCatBase.resetUpdateDate();
        pSModelExampleCatBase.resetUpdateMan();
        pSModelExampleCatBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isArticleModeDirty()) {
            hashMap.put(FIELD_ARTICLEMODE, this.getArticleMode());
        }
        if (!bl || this.isBottomContentDirty()) {
            hashMap.put(FIELD_BOTTOMCONTENT, this.getBottomContent());
        }
        if (!bl || this.isCatSNDirty()) {
            hashMap.put(FIELD_CATSN, this.getCatSN());
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
        if (!bl || this.isExampleTypeDirty()) {
            hashMap.put(FIELD_EXAMPLETYPE, this.getExampleType());
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
        if (!bl || this.isPPSModelExampleCatIdDirty()) {
            hashMap.put(FIELD_PPSMODELEXAMPLECATID, this.getPPSModelExampleCatId());
        }
        if (!bl || this.isPPSModelExampleCatNameDirty()) {
            hashMap.put(FIELD_PPSMODELEXAMPLECATNAME, this.getPPSModelExampleCatName());
        }
        if (!bl || this.isPSModelExampleCatIdDirty()) {
            hashMap.put(FIELD_PSMODELEXAMPLECATID, this.getPSModelExampleCatId());
        }
        if (!bl || this.isPSModelExampleCatNameDirty()) {
            hashMap.put(FIELD_PSMODELEXAMPLECATNAME, this.getPSModelExampleCatName());
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
        return PSModelExampleCatBase.get(this, n);
    }

    private static Object get(PSModelExampleCatBase pSModelExampleCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelExampleCatBase.getArticleMode();
            }
            case 1: {
                return pSModelExampleCatBase.getBottomContent();
            }
            case 2: {
                return pSModelExampleCatBase.getCatSN();
            }
            case 3: {
                return pSModelExampleCatBase.getContent();
            }
            case 4: {
                return pSModelExampleCatBase.getCreateDate();
            }
            case 5: {
                return pSModelExampleCatBase.getCreateMan();
            }
            case 6: {
                return pSModelExampleCatBase.getExampleType();
            }
            case 7: {
                return pSModelExampleCatBase.getHeaderContent();
            }
            case 8: {
                return pSModelExampleCatBase.getMemo();
            }
            case 9: {
                return pSModelExampleCatBase.getOrderValue();
            }
            case 10: {
                return pSModelExampleCatBase.getPPSModelExampleCatId();
            }
            case 11: {
                return pSModelExampleCatBase.getPPSModelExampleCatName();
            }
            case 12: {
                return pSModelExampleCatBase.getPSModelExampleCatId();
            }
            case 13: {
                return pSModelExampleCatBase.getPSModelExampleCatName();
            }
            case 14: {
                return pSModelExampleCatBase.getTitle();
            }
            case 15: {
                return pSModelExampleCatBase.getUpdateDate();
            }
            case 16: {
                return pSModelExampleCatBase.getUpdateMan();
            }
            case 17: {
                return pSModelExampleCatBase.getValidFlag();
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
        PSModelExampleCatBase.set(this, n, object);
    }

    private static void set(PSModelExampleCatBase pSModelExampleCatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelExampleCatBase.setArticleMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSModelExampleCatBase.setBottomContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelExampleCatBase.setCatSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelExampleCatBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelExampleCatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSModelExampleCatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelExampleCatBase.setExampleType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelExampleCatBase.setHeaderContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelExampleCatBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelExampleCatBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSModelExampleCatBase.setPPSModelExampleCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelExampleCatBase.setPPSModelExampleCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelExampleCatBase.setPSModelExampleCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelExampleCatBase.setPSModelExampleCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelExampleCatBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSModelExampleCatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSModelExampleCatBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSModelExampleCatBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSModelExampleCatBase.isNull(this, n);
    }

    private static boolean isNull(PSModelExampleCatBase pSModelExampleCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelExampleCatBase.getArticleMode() == null;
            }
            case 1: {
                return pSModelExampleCatBase.getBottomContent() == null;
            }
            case 2: {
                return pSModelExampleCatBase.getCatSN() == null;
            }
            case 3: {
                return pSModelExampleCatBase.getContent() == null;
            }
            case 4: {
                return pSModelExampleCatBase.getCreateDate() == null;
            }
            case 5: {
                return pSModelExampleCatBase.getCreateMan() == null;
            }
            case 6: {
                return pSModelExampleCatBase.getExampleType() == null;
            }
            case 7: {
                return pSModelExampleCatBase.getHeaderContent() == null;
            }
            case 8: {
                return pSModelExampleCatBase.getMemo() == null;
            }
            case 9: {
                return pSModelExampleCatBase.getOrderValue() == null;
            }
            case 10: {
                return pSModelExampleCatBase.getPPSModelExampleCatId() == null;
            }
            case 11: {
                return pSModelExampleCatBase.getPPSModelExampleCatName() == null;
            }
            case 12: {
                return pSModelExampleCatBase.getPSModelExampleCatId() == null;
            }
            case 13: {
                return pSModelExampleCatBase.getPSModelExampleCatName() == null;
            }
            case 14: {
                return pSModelExampleCatBase.getTitle() == null;
            }
            case 15: {
                return pSModelExampleCatBase.getUpdateDate() == null;
            }
            case 16: {
                return pSModelExampleCatBase.getUpdateMan() == null;
            }
            case 17: {
                return pSModelExampleCatBase.getValidFlag() == null;
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
        return PSModelExampleCatBase.contains(this, n);
    }

    private static boolean contains(PSModelExampleCatBase pSModelExampleCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelExampleCatBase.isArticleModeDirty();
            }
            case 1: {
                return pSModelExampleCatBase.isBottomContentDirty();
            }
            case 2: {
                return pSModelExampleCatBase.isCatSNDirty();
            }
            case 3: {
                return pSModelExampleCatBase.isContentDirty();
            }
            case 4: {
                return pSModelExampleCatBase.isCreateDateDirty();
            }
            case 5: {
                return pSModelExampleCatBase.isCreateManDirty();
            }
            case 6: {
                return pSModelExampleCatBase.isExampleTypeDirty();
            }
            case 7: {
                return pSModelExampleCatBase.isHeaderContentDirty();
            }
            case 8: {
                return pSModelExampleCatBase.isMemoDirty();
            }
            case 9: {
                return pSModelExampleCatBase.isOrderValueDirty();
            }
            case 10: {
                return pSModelExampleCatBase.isPPSModelExampleCatIdDirty();
            }
            case 11: {
                return pSModelExampleCatBase.isPPSModelExampleCatNameDirty();
            }
            case 12: {
                return pSModelExampleCatBase.isPSModelExampleCatIdDirty();
            }
            case 13: {
                return pSModelExampleCatBase.isPSModelExampleCatNameDirty();
            }
            case 14: {
                return pSModelExampleCatBase.isTitleDirty();
            }
            case 15: {
                return pSModelExampleCatBase.isUpdateDateDirty();
            }
            case 16: {
                return pSModelExampleCatBase.isUpdateManDirty();
            }
            case 17: {
                return pSModelExampleCatBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelExampleCatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelExampleCatBase pSModelExampleCatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelExampleCatBase.getArticleMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articlemode", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getArticleMode()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getBottomContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottomcontent", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getBottomContent()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getCatSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"catsn", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getCatSN()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getContent()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getExampleType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exampletype", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getExampleType()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getHeaderContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headercontent", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getHeaderContent()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getPPSModelExampleCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmodelexamplecatid", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getPPSModelExampleCatId()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getPPSModelExampleCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmodelexamplecatname", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getPPSModelExampleCatName()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getPSModelExampleCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelexamplecatid", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getPSModelExampleCatId()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getPSModelExampleCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelexamplecatname", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getPSModelExampleCatName()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getTitle()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelExampleCatBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelExampleCatBase.getJSONValue((Object)pSModelExampleCatBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelExampleCatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelExampleCatBase pSModelExampleCatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelExampleCatBase.getArticleMode() != null) {
            object = pSModelExampleCatBase.getArticleMode();
            xmlNode.setAttribute(FIELD_ARTICLEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelExampleCatBase.getBottomContent() != null) {
            object = pSModelExampleCatBase.getBottomContent();
            xmlNode.setAttribute(FIELD_BOTTOMCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleCatBase.getCatSN() != null) {
            object = pSModelExampleCatBase.getCatSN();
            xmlNode.setAttribute(FIELD_CATSN, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleCatBase.getContent() != null) {
            object = pSModelExampleCatBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleCatBase.getCreateDate() != null) {
            object = pSModelExampleCatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelExampleCatBase.getCreateMan() != null) {
            object = pSModelExampleCatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleCatBase.getExampleType() != null) {
            object = pSModelExampleCatBase.getExampleType();
            xmlNode.setAttribute(FIELD_EXAMPLETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleCatBase.getHeaderContent() != null) {
            object = pSModelExampleCatBase.getHeaderContent();
            xmlNode.setAttribute(FIELD_HEADERCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleCatBase.getMemo() != null) {
            object = pSModelExampleCatBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleCatBase.getOrderValue() != null) {
            object = pSModelExampleCatBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelExampleCatBase.getPPSModelExampleCatId() != null) {
            object = pSModelExampleCatBase.getPPSModelExampleCatId();
            xmlNode.setAttribute(FIELD_PPSMODELEXAMPLECATID, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleCatBase.getPPSModelExampleCatName() != null) {
            object = pSModelExampleCatBase.getPPSModelExampleCatName();
            xmlNode.setAttribute(FIELD_PPSMODELEXAMPLECATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleCatBase.getPSModelExampleCatId() != null) {
            object = pSModelExampleCatBase.getPSModelExampleCatId();
            xmlNode.setAttribute(FIELD_PSMODELEXAMPLECATID, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleCatBase.getPSModelExampleCatName() != null) {
            object = pSModelExampleCatBase.getPSModelExampleCatName();
            xmlNode.setAttribute(FIELD_PSMODELEXAMPLECATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleCatBase.getTitle() != null) {
            object = pSModelExampleCatBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleCatBase.getUpdateDate() != null) {
            object = pSModelExampleCatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelExampleCatBase.getUpdateMan() != null) {
            object = pSModelExampleCatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelExampleCatBase.getValidFlag() != null) {
            object = pSModelExampleCatBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelExampleCatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelExampleCatBase pSModelExampleCatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelExampleCatBase.isArticleModeDirty() && (bl || pSModelExampleCatBase.getArticleMode() != null)) {
            iDataObject.set(FIELD_ARTICLEMODE, (Object)pSModelExampleCatBase.getArticleMode());
        }
        if (pSModelExampleCatBase.isBottomContentDirty() && (bl || pSModelExampleCatBase.getBottomContent() != null)) {
            iDataObject.set(FIELD_BOTTOMCONTENT, (Object)pSModelExampleCatBase.getBottomContent());
        }
        if (pSModelExampleCatBase.isCatSNDirty() && (bl || pSModelExampleCatBase.getCatSN() != null)) {
            iDataObject.set(FIELD_CATSN, (Object)pSModelExampleCatBase.getCatSN());
        }
        if (pSModelExampleCatBase.isContentDirty() && (bl || pSModelExampleCatBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSModelExampleCatBase.getContent());
        }
        if (pSModelExampleCatBase.isCreateDateDirty() && (bl || pSModelExampleCatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelExampleCatBase.getCreateDate());
        }
        if (pSModelExampleCatBase.isCreateManDirty() && (bl || pSModelExampleCatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelExampleCatBase.getCreateMan());
        }
        if (pSModelExampleCatBase.isExampleTypeDirty() && (bl || pSModelExampleCatBase.getExampleType() != null)) {
            iDataObject.set(FIELD_EXAMPLETYPE, (Object)pSModelExampleCatBase.getExampleType());
        }
        if (pSModelExampleCatBase.isHeaderContentDirty() && (bl || pSModelExampleCatBase.getHeaderContent() != null)) {
            iDataObject.set(FIELD_HEADERCONTENT, (Object)pSModelExampleCatBase.getHeaderContent());
        }
        if (pSModelExampleCatBase.isMemoDirty() && (bl || pSModelExampleCatBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelExampleCatBase.getMemo());
        }
        if (pSModelExampleCatBase.isOrderValueDirty() && (bl || pSModelExampleCatBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModelExampleCatBase.getOrderValue());
        }
        if (pSModelExampleCatBase.isPPSModelExampleCatIdDirty() && (bl || pSModelExampleCatBase.getPPSModelExampleCatId() != null)) {
            iDataObject.set(FIELD_PPSMODELEXAMPLECATID, (Object)pSModelExampleCatBase.getPPSModelExampleCatId());
        }
        if (pSModelExampleCatBase.isPPSModelExampleCatNameDirty() && (bl || pSModelExampleCatBase.getPPSModelExampleCatName() != null)) {
            iDataObject.set(FIELD_PPSMODELEXAMPLECATNAME, (Object)pSModelExampleCatBase.getPPSModelExampleCatName());
        }
        if (pSModelExampleCatBase.isPSModelExampleCatIdDirty() && (bl || pSModelExampleCatBase.getPSModelExampleCatId() != null)) {
            iDataObject.set(FIELD_PSMODELEXAMPLECATID, (Object)pSModelExampleCatBase.getPSModelExampleCatId());
        }
        if (pSModelExampleCatBase.isPSModelExampleCatNameDirty() && (bl || pSModelExampleCatBase.getPSModelExampleCatName() != null)) {
            iDataObject.set(FIELD_PSMODELEXAMPLECATNAME, (Object)pSModelExampleCatBase.getPSModelExampleCatName());
        }
        if (pSModelExampleCatBase.isTitleDirty() && (bl || pSModelExampleCatBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSModelExampleCatBase.getTitle());
        }
        if (pSModelExampleCatBase.isUpdateDateDirty() && (bl || pSModelExampleCatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelExampleCatBase.getUpdateDate());
        }
        if (pSModelExampleCatBase.isUpdateManDirty() && (bl || pSModelExampleCatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelExampleCatBase.getUpdateMan());
        }
        if (pSModelExampleCatBase.isValidFlagDirty() && (bl || pSModelExampleCatBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelExampleCatBase.getValidFlag());
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
        return PSModelExampleCatBase.remove(this, n);
    }

    private static boolean remove(PSModelExampleCatBase pSModelExampleCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelExampleCatBase.resetArticleMode();
                return true;
            }
            case 1: {
                pSModelExampleCatBase.resetBottomContent();
                return true;
            }
            case 2: {
                pSModelExampleCatBase.resetCatSN();
                return true;
            }
            case 3: {
                pSModelExampleCatBase.resetContent();
                return true;
            }
            case 4: {
                pSModelExampleCatBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSModelExampleCatBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSModelExampleCatBase.resetExampleType();
                return true;
            }
            case 7: {
                pSModelExampleCatBase.resetHeaderContent();
                return true;
            }
            case 8: {
                pSModelExampleCatBase.resetMemo();
                return true;
            }
            case 9: {
                pSModelExampleCatBase.resetOrderValue();
                return true;
            }
            case 10: {
                pSModelExampleCatBase.resetPPSModelExampleCatId();
                return true;
            }
            case 11: {
                pSModelExampleCatBase.resetPPSModelExampleCatName();
                return true;
            }
            case 12: {
                pSModelExampleCatBase.resetPSModelExampleCatId();
                return true;
            }
            case 13: {
                pSModelExampleCatBase.resetPSModelExampleCatName();
                return true;
            }
            case 14: {
                pSModelExampleCatBase.resetTitle();
                return true;
            }
            case 15: {
                pSModelExampleCatBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSModelExampleCatBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSModelExampleCatBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelExampleCat getPPSModelExampleCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelExampleCat();
        }
        if (this.getPPSModelExampleCatId() == null) {
            return null;
        }
        Integer n = this.objPPSModelExampleCatLock;
        synchronized (n) {
            if (this.ppsmodelexamplecat != null && DataTypeHelper.compare((int)25, (Object)this.getPPSModelExampleCatId(), (Object)this.ppsmodelexamplecat.getPSModelExampleCatId()) != 0L) {
                this.ppsmodelexamplecat = null;
            }
            if (this.ppsmodelexamplecat == null) {
                PSModelExampleCat pSModelExampleCat = new PSModelExampleCat();
                pSModelExampleCat.setPSModelExampleCatId(this.getPPSModelExampleCatId());
                PSModelExampleCatService pSModelExampleCatService = (PSModelExampleCatService)ServiceGlobal.getService(PSModelExampleCatService.class, (SessionFactory)this.getSessionFactory());
                pSModelExampleCatService.autoGet(pSModelExampleCat);
                this.ppsmodelexamplecat = pSModelExampleCat;
            }
            return this.ppsmodelexamplecat;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSModelExampleCat> getPSModelExampleCats() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelExampleCats();
        }
        if (this.getPSModelExampleCatId() == null) {
            return null;
        }
        PSModelExampleCatService pSModelExampleCatService = (PSModelExampleCatService)ServiceGlobal.getService(PSModelExampleCatService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSModelExampleCatsLock;
        synchronized (n) {
            if (this.psmodelexamplecats == null) {
                this.psmodelexamplecats = pSModelExampleCatService.selectByPPSModelExampleCat(this);
            }
            return this.psmodelexamplecats;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSModelExample> getPSModelExamples() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelExamples();
        }
        if (this.getPSModelExampleCatId() == null) {
            return null;
        }
        PSModelExampleService pSModelExampleService = (PSModelExampleService)ServiceGlobal.getService(PSModelExampleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSModelExamplesLock;
        synchronized (n) {
            if (this.psmodelexamples == null) {
                this.psmodelexamples = pSModelExampleService.selectByPSModelExampleCat(this);
            }
            return this.psmodelexamples;
        }
    }

    private PSModelExampleCatBase getProxyEntity() {
        return this.proxyPSModelExampleCatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelExampleCatBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelExampleCatBase) {
            this.proxyPSModelExampleCatBase = (PSModelExampleCatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelExampleCatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ARTICLEMODE, 0);
        fieldIndexMap.put(FIELD_BOTTOMCONTENT, 1);
        fieldIndexMap.put(FIELD_CATSN, 2);
        fieldIndexMap.put(FIELD_CONTENT, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_EXAMPLETYPE, 6);
        fieldIndexMap.put(FIELD_HEADERCONTENT, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_ORDERVALUE, 9);
        fieldIndexMap.put(FIELD_PPSMODELEXAMPLECATID, 10);
        fieldIndexMap.put(FIELD_PPSMODELEXAMPLECATNAME, 11);
        fieldIndexMap.put(FIELD_PSMODELEXAMPLECATID, 12);
        fieldIndexMap.put(FIELD_PSMODELEXAMPLECATNAME, 13);
        fieldIndexMap.put(FIELD_TITLE, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_VALIDFLAG, 17);
    }
}

