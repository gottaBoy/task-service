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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUseCaseCatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysUseCaseCatBase.class);
    public static final String FIELD_CATSN = "CATSN";
    public static final String FIELD_CATTAG = "CATTAG";
    public static final String FIELD_CATTAG2 = "CATTAG2";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUSECASECATID = "PSSYSUSECASECATID";
    public static final String FIELD_PSSYSUSECASECATNAME = "PSSYSUSECASECATNAME";
    public static final String FIELD_TAGS = "TAGS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CATSN = 0;
    private static final int INDEX_CATTAG = 1;
    private static final int INDEX_CATTAG2 = 2;
    private static final int INDEX_CODENAME = 3;
    private static final int INDEX_CONTENT = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PSMODULEID = 9;
    private static final int INDEX_PSMODULENAME = 10;
    private static final int INDEX_PSSYSTEMID = 11;
    private static final int INDEX_PSSYSTEMNAME = 12;
    private static final int INDEX_PSSYSUSECASECATID = 13;
    private static final int INDEX_PSSYSUSECASECATNAME = 14;
    private static final int INDEX_TAGS = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCAT = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysUseCaseCatBase proxyPSSysUseCaseCatBase = null;
    private boolean catsnDirtyFlag = false;
    private boolean cattagDirtyFlag = false;
    private boolean cattag2DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysusecasecatidDirtyFlag = false;
    private boolean pssysusecasecatnameDirtyFlag = false;
    private boolean tagsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="catsn")
    private String catsn;
    @Column(name="cattag")
    private String cattag;
    @Column(name="cattag2")
    private String cattag2;
    @Column(name="codename")
    private String codename;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysusecasecatid")
    private String pssysusecasecatid;
    @Column(name="pssysusecasecatname")
    private String pssysusecasecatname;
    @Column(name="tags")
    private String tags;
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
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUseCasesLock = new Integer(1);
    private ArrayList<PSSysUserCase> pssysusecases = null;

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

    public void setCatTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCatTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cattag = string;
        this.cattagDirtyFlag = true;
    }

    public String getCatTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCatTag();
        }
        return this.cattag;
    }

    public boolean isCatTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCatTagDirty();
        }
        return this.cattagDirtyFlag;
    }

    public void resetCatTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCatTag();
            return;
        }
        this.cattagDirtyFlag = false;
        this.cattag = null;
    }

    public void setCatTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCatTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cattag2 = string;
        this.cattag2DirtyFlag = true;
    }

    public String getCatTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCatTag2();
        }
        return this.cattag2;
    }

    public boolean isCatTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCatTag2Dirty();
        }
        return this.cattag2DirtyFlag;
    }

    public void resetCatTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCatTag2();
            return;
        }
        this.cattag2DirtyFlag = false;
        this.cattag2 = null;
    }

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
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

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setPSSysUseCaseCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUseCaseCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusecasecatid = string;
        this.pssysusecasecatidDirtyFlag = true;
    }

    public String getPSSysUseCaseCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUseCaseCatId();
        }
        return this.pssysusecasecatid;
    }

    public boolean isPSSysUseCaseCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUseCaseCatIdDirty();
        }
        return this.pssysusecasecatidDirtyFlag;
    }

    public void resetPSSysUseCaseCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUseCaseCatId();
            return;
        }
        this.pssysusecasecatidDirtyFlag = false;
        this.pssysusecasecatid = null;
    }

    public void setPSSysUseCaseCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUseCaseCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusecasecatname = string;
        this.pssysusecasecatnameDirtyFlag = true;
    }

    public String getPSSysUseCaseCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUseCaseCatName();
        }
        return this.pssysusecasecatname;
    }

    public boolean isPSSysUseCaseCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUseCaseCatNameDirty();
        }
        return this.pssysusecasecatnameDirtyFlag;
    }

    public void resetPSSysUseCaseCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUseCaseCatName();
            return;
        }
        this.pssysusecasecatnameDirtyFlag = false;
        this.pssysusecasecatname = null;
    }

    public void setTags(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTags(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tags = string;
        this.tagsDirtyFlag = true;
    }

    public String getTags() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTags();
        }
        return this.tags;
    }

    public boolean isTagsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagsDirty();
        }
        return this.tagsDirtyFlag;
    }

    public void resetTags() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTags();
            return;
        }
        this.tagsDirtyFlag = false;
        this.tags = null;
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
        PSSysUseCaseCatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysUseCaseCatBase pSSysUseCaseCatBase) {
        pSSysUseCaseCatBase.resetCatSN();
        pSSysUseCaseCatBase.resetCatTag();
        pSSysUseCaseCatBase.resetCatTag2();
        pSSysUseCaseCatBase.resetCodeName();
        pSSysUseCaseCatBase.resetContent();
        pSSysUseCaseCatBase.resetCreateDate();
        pSSysUseCaseCatBase.resetCreateMan();
        pSSysUseCaseCatBase.resetMemo();
        pSSysUseCaseCatBase.resetOrderValue();
        pSSysUseCaseCatBase.resetPSModuleId();
        pSSysUseCaseCatBase.resetPSModuleName();
        pSSysUseCaseCatBase.resetPSSystemId();
        pSSysUseCaseCatBase.resetPSSystemName();
        pSSysUseCaseCatBase.resetPSSysUseCaseCatId();
        pSSysUseCaseCatBase.resetPSSysUseCaseCatName();
        pSSysUseCaseCatBase.resetTags();
        pSSysUseCaseCatBase.resetUpdateDate();
        pSSysUseCaseCatBase.resetUpdateMan();
        pSSysUseCaseCatBase.resetUserCat();
        pSSysUseCaseCatBase.resetUserTag();
        pSSysUseCaseCatBase.resetUserTag2();
        pSSysUseCaseCatBase.resetUserTag3();
        pSSysUseCaseCatBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCatSNDirty()) {
            hashMap.put(FIELD_CATSN, this.getCatSN());
        }
        if (!bl || this.isCatTagDirty()) {
            hashMap.put(FIELD_CATTAG, this.getCatTag());
        }
        if (!bl || this.isCatTag2Dirty()) {
            hashMap.put(FIELD_CATTAG2, this.getCatTag2());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysUseCaseCatIdDirty()) {
            hashMap.put(FIELD_PSSYSUSECASECATID, this.getPSSysUseCaseCatId());
        }
        if (!bl || this.isPSSysUseCaseCatNameDirty()) {
            hashMap.put(FIELD_PSSYSUSECASECATNAME, this.getPSSysUseCaseCatName());
        }
        if (!bl || this.isTagsDirty()) {
            hashMap.put(FIELD_TAGS, this.getTags());
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
        return PSSysUseCaseCatBase.get(this, n);
    }

    private static Object get(PSSysUseCaseCatBase pSSysUseCaseCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUseCaseCatBase.getCatSN();
            }
            case 1: {
                return pSSysUseCaseCatBase.getCatTag();
            }
            case 2: {
                return pSSysUseCaseCatBase.getCatTag2();
            }
            case 3: {
                return pSSysUseCaseCatBase.getCodeName();
            }
            case 4: {
                return pSSysUseCaseCatBase.getContent();
            }
            case 5: {
                return pSSysUseCaseCatBase.getCreateDate();
            }
            case 6: {
                return pSSysUseCaseCatBase.getCreateMan();
            }
            case 7: {
                return pSSysUseCaseCatBase.getMemo();
            }
            case 8: {
                return pSSysUseCaseCatBase.getOrderValue();
            }
            case 9: {
                return pSSysUseCaseCatBase.getPSModuleId();
            }
            case 10: {
                return pSSysUseCaseCatBase.getPSModuleName();
            }
            case 11: {
                return pSSysUseCaseCatBase.getPSSystemId();
            }
            case 12: {
                return pSSysUseCaseCatBase.getPSSystemName();
            }
            case 13: {
                return pSSysUseCaseCatBase.getPSSysUseCaseCatId();
            }
            case 14: {
                return pSSysUseCaseCatBase.getPSSysUseCaseCatName();
            }
            case 15: {
                return pSSysUseCaseCatBase.getTags();
            }
            case 16: {
                return pSSysUseCaseCatBase.getUpdateDate();
            }
            case 17: {
                return pSSysUseCaseCatBase.getUpdateMan();
            }
            case 18: {
                return pSSysUseCaseCatBase.getUserCat();
            }
            case 19: {
                return pSSysUseCaseCatBase.getUserTag();
            }
            case 20: {
                return pSSysUseCaseCatBase.getUserTag2();
            }
            case 21: {
                return pSSysUseCaseCatBase.getUserTag3();
            }
            case 22: {
                return pSSysUseCaseCatBase.getUserTag4();
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
        PSSysUseCaseCatBase.set(this, n, object);
    }

    private static void set(PSSysUseCaseCatBase pSSysUseCaseCatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysUseCaseCatBase.setCatSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysUseCaseCatBase.setCatTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysUseCaseCatBase.setCatTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysUseCaseCatBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysUseCaseCatBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysUseCaseCatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSSysUseCaseCatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysUseCaseCatBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysUseCaseCatBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysUseCaseCatBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysUseCaseCatBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysUseCaseCatBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysUseCaseCatBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysUseCaseCatBase.setPSSysUseCaseCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysUseCaseCatBase.setPSSysUseCaseCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysUseCaseCatBase.setTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysUseCaseCatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSysUseCaseCatBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysUseCaseCatBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysUseCaseCatBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysUseCaseCatBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysUseCaseCatBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysUseCaseCatBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysUseCaseCatBase.isNull(this, n);
    }

    private static boolean isNull(PSSysUseCaseCatBase pSSysUseCaseCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUseCaseCatBase.getCatSN() == null;
            }
            case 1: {
                return pSSysUseCaseCatBase.getCatTag() == null;
            }
            case 2: {
                return pSSysUseCaseCatBase.getCatTag2() == null;
            }
            case 3: {
                return pSSysUseCaseCatBase.getCodeName() == null;
            }
            case 4: {
                return pSSysUseCaseCatBase.getContent() == null;
            }
            case 5: {
                return pSSysUseCaseCatBase.getCreateDate() == null;
            }
            case 6: {
                return pSSysUseCaseCatBase.getCreateMan() == null;
            }
            case 7: {
                return pSSysUseCaseCatBase.getMemo() == null;
            }
            case 8: {
                return pSSysUseCaseCatBase.getOrderValue() == null;
            }
            case 9: {
                return pSSysUseCaseCatBase.getPSModuleId() == null;
            }
            case 10: {
                return pSSysUseCaseCatBase.getPSModuleName() == null;
            }
            case 11: {
                return pSSysUseCaseCatBase.getPSSystemId() == null;
            }
            case 12: {
                return pSSysUseCaseCatBase.getPSSystemName() == null;
            }
            case 13: {
                return pSSysUseCaseCatBase.getPSSysUseCaseCatId() == null;
            }
            case 14: {
                return pSSysUseCaseCatBase.getPSSysUseCaseCatName() == null;
            }
            case 15: {
                return pSSysUseCaseCatBase.getTags() == null;
            }
            case 16: {
                return pSSysUseCaseCatBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSysUseCaseCatBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSysUseCaseCatBase.getUserCat() == null;
            }
            case 19: {
                return pSSysUseCaseCatBase.getUserTag() == null;
            }
            case 20: {
                return pSSysUseCaseCatBase.getUserTag2() == null;
            }
            case 21: {
                return pSSysUseCaseCatBase.getUserTag3() == null;
            }
            case 22: {
                return pSSysUseCaseCatBase.getUserTag4() == null;
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
        return PSSysUseCaseCatBase.contains(this, n);
    }

    private static boolean contains(PSSysUseCaseCatBase pSSysUseCaseCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUseCaseCatBase.isCatSNDirty();
            }
            case 1: {
                return pSSysUseCaseCatBase.isCatTagDirty();
            }
            case 2: {
                return pSSysUseCaseCatBase.isCatTag2Dirty();
            }
            case 3: {
                return pSSysUseCaseCatBase.isCodeNameDirty();
            }
            case 4: {
                return pSSysUseCaseCatBase.isContentDirty();
            }
            case 5: {
                return pSSysUseCaseCatBase.isCreateDateDirty();
            }
            case 6: {
                return pSSysUseCaseCatBase.isCreateManDirty();
            }
            case 7: {
                return pSSysUseCaseCatBase.isMemoDirty();
            }
            case 8: {
                return pSSysUseCaseCatBase.isOrderValueDirty();
            }
            case 9: {
                return pSSysUseCaseCatBase.isPSModuleIdDirty();
            }
            case 10: {
                return pSSysUseCaseCatBase.isPSModuleNameDirty();
            }
            case 11: {
                return pSSysUseCaseCatBase.isPSSystemIdDirty();
            }
            case 12: {
                return pSSysUseCaseCatBase.isPSSystemNameDirty();
            }
            case 13: {
                return pSSysUseCaseCatBase.isPSSysUseCaseCatIdDirty();
            }
            case 14: {
                return pSSysUseCaseCatBase.isPSSysUseCaseCatNameDirty();
            }
            case 15: {
                return pSSysUseCaseCatBase.isTagsDirty();
            }
            case 16: {
                return pSSysUseCaseCatBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSysUseCaseCatBase.isUpdateManDirty();
            }
            case 18: {
                return pSSysUseCaseCatBase.isUserCatDirty();
            }
            case 19: {
                return pSSysUseCaseCatBase.isUserTagDirty();
            }
            case 20: {
                return pSSysUseCaseCatBase.isUserTag2Dirty();
            }
            case 21: {
                return pSSysUseCaseCatBase.isUserTag3Dirty();
            }
            case 22: {
                return pSSysUseCaseCatBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysUseCaseCatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysUseCaseCatBase pSSysUseCaseCatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysUseCaseCatBase.getCatSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"catsn", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getCatSN()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getCatTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cattag", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getCatTag()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getCatTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cattag2", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getCatTag2()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getContent()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getPSSysUseCaseCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusecasecatid", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getPSSysUseCaseCatId()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getPSSysUseCaseCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusecasecatname", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getPSSysUseCaseCatName()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tags", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getTags()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysUseCaseCatBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysUseCaseCatBase.getJSONValue((Object)pSSysUseCaseCatBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysUseCaseCatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysUseCaseCatBase pSSysUseCaseCatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysUseCaseCatBase.getCatSN() != null) {
            object = pSSysUseCaseCatBase.getCatSN();
            xmlNode.setAttribute(FIELD_CATSN, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUseCaseCatBase.getCatTag() != null) {
            object = pSSysUseCaseCatBase.getCatTag();
            xmlNode.setAttribute(FIELD_CATTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUseCaseCatBase.getCatTag2() != null) {
            object = pSSysUseCaseCatBase.getCatTag2();
            xmlNode.setAttribute(FIELD_CATTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUseCaseCatBase.getCodeName() != null) {
            object = pSSysUseCaseCatBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSSysUseCaseCatBase.getContent() != null) {
            object = pSSysUseCaseCatBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUseCaseCatBase.getCreateDate() != null) {
            object = pSSysUseCaseCatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUseCaseCatBase.getCreateMan() != null) {
            object = pSSysUseCaseCatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUseCaseCatBase.getMemo() != null) {
            object = pSSysUseCaseCatBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysUseCaseCatBase.getOrderValue() != null) {
            object = pSSysUseCaseCatBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUseCaseCatBase.getPSModuleId() != null) {
            object = pSSysUseCaseCatBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUseCaseCatBase.getPSModuleName() != null) {
            object = pSSysUseCaseCatBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUseCaseCatBase.getPSSystemId() != null) {
            object = pSSysUseCaseCatBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUseCaseCatBase.getPSSystemName() != null) {
            object = pSSysUseCaseCatBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUseCaseCatBase.getPSSysUseCaseCatId() != null) {
            object = pSSysUseCaseCatBase.getPSSysUseCaseCatId();
            xmlNode.setAttribute(FIELD_PSSYSUSECASECATID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUseCaseCatBase.getPSSysUseCaseCatName() != null) {
            object = pSSysUseCaseCatBase.getPSSysUseCaseCatName();
            xmlNode.setAttribute(FIELD_PSSYSUSECASECATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUseCaseCatBase.getTags() != null) {
            object = pSSysUseCaseCatBase.getTags();
            xmlNode.setAttribute(FIELD_TAGS, object == null ? "" : (String)object);
        }
        if (bl || pSSysUseCaseCatBase.getUpdateDate() != null) {
            object = pSSysUseCaseCatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUseCaseCatBase.getUpdateMan() != null) {
            object = pSSysUseCaseCatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUseCaseCatBase.getUserCat() != null) {
            object = pSSysUseCaseCatBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUseCaseCatBase.getUserTag() != null) {
            object = pSSysUseCaseCatBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUseCaseCatBase.getUserTag2() != null) {
            object = pSSysUseCaseCatBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUseCaseCatBase.getUserTag3() != null) {
            object = pSSysUseCaseCatBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUseCaseCatBase.getUserTag4() != null) {
            object = pSSysUseCaseCatBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysUseCaseCatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysUseCaseCatBase pSSysUseCaseCatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysUseCaseCatBase.isCatSNDirty() && (bl || pSSysUseCaseCatBase.getCatSN() != null)) {
            iDataObject.set(FIELD_CATSN, (Object)pSSysUseCaseCatBase.getCatSN());
        }
        if (pSSysUseCaseCatBase.isCatTagDirty() && (bl || pSSysUseCaseCatBase.getCatTag() != null)) {
            iDataObject.set(FIELD_CATTAG, (Object)pSSysUseCaseCatBase.getCatTag());
        }
        if (pSSysUseCaseCatBase.isCatTag2Dirty() && (bl || pSSysUseCaseCatBase.getCatTag2() != null)) {
            iDataObject.set(FIELD_CATTAG2, (Object)pSSysUseCaseCatBase.getCatTag2());
        }
        if (pSSysUseCaseCatBase.isCodeNameDirty() && (bl || pSSysUseCaseCatBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysUseCaseCatBase.getCodeName());
        }
        if (pSSysUseCaseCatBase.isContentDirty() && (bl || pSSysUseCaseCatBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSSysUseCaseCatBase.getContent());
        }
        if (pSSysUseCaseCatBase.isCreateDateDirty() && (bl || pSSysUseCaseCatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysUseCaseCatBase.getCreateDate());
        }
        if (pSSysUseCaseCatBase.isCreateManDirty() && (bl || pSSysUseCaseCatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysUseCaseCatBase.getCreateMan());
        }
        if (pSSysUseCaseCatBase.isMemoDirty() && (bl || pSSysUseCaseCatBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysUseCaseCatBase.getMemo());
        }
        if (pSSysUseCaseCatBase.isOrderValueDirty() && (bl || pSSysUseCaseCatBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysUseCaseCatBase.getOrderValue());
        }
        if (pSSysUseCaseCatBase.isPSModuleIdDirty() && (bl || pSSysUseCaseCatBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysUseCaseCatBase.getPSModuleId());
        }
        if (pSSysUseCaseCatBase.isPSModuleNameDirty() && (bl || pSSysUseCaseCatBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysUseCaseCatBase.getPSModuleName());
        }
        if (pSSysUseCaseCatBase.isPSSystemIdDirty() && (bl || pSSysUseCaseCatBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysUseCaseCatBase.getPSSystemId());
        }
        if (pSSysUseCaseCatBase.isPSSystemNameDirty() && (bl || pSSysUseCaseCatBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysUseCaseCatBase.getPSSystemName());
        }
        if (pSSysUseCaseCatBase.isPSSysUseCaseCatIdDirty() && (bl || pSSysUseCaseCatBase.getPSSysUseCaseCatId() != null)) {
            iDataObject.set(FIELD_PSSYSUSECASECATID, (Object)pSSysUseCaseCatBase.getPSSysUseCaseCatId());
        }
        if (pSSysUseCaseCatBase.isPSSysUseCaseCatNameDirty() && (bl || pSSysUseCaseCatBase.getPSSysUseCaseCatName() != null)) {
            iDataObject.set(FIELD_PSSYSUSECASECATNAME, (Object)pSSysUseCaseCatBase.getPSSysUseCaseCatName());
        }
        if (pSSysUseCaseCatBase.isTagsDirty() && (bl || pSSysUseCaseCatBase.getTags() != null)) {
            iDataObject.set(FIELD_TAGS, (Object)pSSysUseCaseCatBase.getTags());
        }
        if (pSSysUseCaseCatBase.isUpdateDateDirty() && (bl || pSSysUseCaseCatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysUseCaseCatBase.getUpdateDate());
        }
        if (pSSysUseCaseCatBase.isUpdateManDirty() && (bl || pSSysUseCaseCatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysUseCaseCatBase.getUpdateMan());
        }
        if (pSSysUseCaseCatBase.isUserCatDirty() && (bl || pSSysUseCaseCatBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysUseCaseCatBase.getUserCat());
        }
        if (pSSysUseCaseCatBase.isUserTagDirty() && (bl || pSSysUseCaseCatBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysUseCaseCatBase.getUserTag());
        }
        if (pSSysUseCaseCatBase.isUserTag2Dirty() && (bl || pSSysUseCaseCatBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysUseCaseCatBase.getUserTag2());
        }
        if (pSSysUseCaseCatBase.isUserTag3Dirty() && (bl || pSSysUseCaseCatBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysUseCaseCatBase.getUserTag3());
        }
        if (pSSysUseCaseCatBase.isUserTag4Dirty() && (bl || pSSysUseCaseCatBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysUseCaseCatBase.getUserTag4());
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
        return PSSysUseCaseCatBase.remove(this, n);
    }

    private static boolean remove(PSSysUseCaseCatBase pSSysUseCaseCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysUseCaseCatBase.resetCatSN();
                return true;
            }
            case 1: {
                pSSysUseCaseCatBase.resetCatTag();
                return true;
            }
            case 2: {
                pSSysUseCaseCatBase.resetCatTag2();
                return true;
            }
            case 3: {
                pSSysUseCaseCatBase.resetCodeName();
                return true;
            }
            case 4: {
                pSSysUseCaseCatBase.resetContent();
                return true;
            }
            case 5: {
                pSSysUseCaseCatBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSSysUseCaseCatBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSSysUseCaseCatBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysUseCaseCatBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSSysUseCaseCatBase.resetPSModuleId();
                return true;
            }
            case 10: {
                pSSysUseCaseCatBase.resetPSModuleName();
                return true;
            }
            case 11: {
                pSSysUseCaseCatBase.resetPSSystemId();
                return true;
            }
            case 12: {
                pSSysUseCaseCatBase.resetPSSystemName();
                return true;
            }
            case 13: {
                pSSysUseCaseCatBase.resetPSSysUseCaseCatId();
                return true;
            }
            case 14: {
                pSSysUseCaseCatBase.resetPSSysUseCaseCatName();
                return true;
            }
            case 15: {
                pSSysUseCaseCatBase.resetTags();
                return true;
            }
            case 16: {
                pSSysUseCaseCatBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSysUseCaseCatBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSysUseCaseCatBase.resetUserCat();
                return true;
            }
            case 19: {
                pSSysUseCaseCatBase.resetUserTag();
                return true;
            }
            case 20: {
                pSSysUseCaseCatBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSSysUseCaseCatBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSSysUseCaseCatBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUserCase> getPSSysUseCases() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUseCases();
        }
        if (this.getPSSysUseCaseCatId() == null) {
            return null;
        }
        PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUseCasesLock;
        synchronized (n) {
            if (this.pssysusecases == null) {
                this.pssysusecases = pSSysUserCaseService.selectByPSSysUseCaseCat(this);
            }
            return this.pssysusecases;
        }
    }

    private PSSysUseCaseCatBase getProxyEntity() {
        return this.proxyPSSysUseCaseCatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysUseCaseCatBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysUseCaseCatBase) {
            this.proxyPSSysUseCaseCatBase = (PSSysUseCaseCatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUseCaseCatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CATSN, 0);
        fieldIndexMap.put(FIELD_CATTAG, 1);
        fieldIndexMap.put(FIELD_CATTAG2, 2);
        fieldIndexMap.put(FIELD_CODENAME, 3);
        fieldIndexMap.put(FIELD_CONTENT, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PSMODULEID, 9);
        fieldIndexMap.put(FIELD_PSMODULENAME, 10);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 11);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 12);
        fieldIndexMap.put(FIELD_PSSYSUSECASECATID, 13);
        fieldIndexMap.put(FIELD_PSSYSUSECASECATNAME, 14);
        fieldIndexMap.put(FIELD_TAGS, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCAT, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
    }
}

