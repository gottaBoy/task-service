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
package net.ibizsys.pscore.srv.helpdesign.entity;

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
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModule;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpPrj;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpModuleService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpPrjService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpModuleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSHelpModuleBase.class);
    public static final String FIELD_ARTICLEURL = "ARTICLEURL";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODPARAM = "MODPARAM";
    public static final String FIELD_MODPARAM2 = "MODPARAM2";
    public static final String FIELD_MODULESN = "MODULESN";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSHELPMODULEID = "PPSHELPMODULEID";
    public static final String FIELD_PPSHELPMODULENAME = "PPSHELPMODULENAME";
    public static final String FIELD_PSHELPARTICLEID = "PSHELPARTICLEID";
    public static final String FIELD_PSHELPARTICLENAME = "PSHELPARTICLENAME";
    public static final String FIELD_PSHELPMODULEID = "PSHELPMODULEID";
    public static final String FIELD_PSHELPMODULENAME = "PSHELPMODULENAME";
    public static final String FIELD_PSHELPPRJID = "PSHELPPRJID";
    public static final String FIELD_PSHELPPRJNAME = "PSHELPPRJNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ARTICLEURL = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MODPARAM = 5;
    private static final int INDEX_MODPARAM2 = 6;
    private static final int INDEX_MODULESN = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PPSHELPMODULEID = 9;
    private static final int INDEX_PPSHELPMODULENAME = 10;
    private static final int INDEX_PSHELPARTICLEID = 11;
    private static final int INDEX_PSHELPARTICLENAME = 12;
    private static final int INDEX_PSHELPMODULEID = 13;
    private static final int INDEX_PSHELPMODULENAME = 14;
    private static final int INDEX_PSHELPPRJID = 15;
    private static final int INDEX_PSHELPPRJNAME = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_USERCAT = 19;
    private static final int INDEX_USERTAG = 20;
    private static final int INDEX_USERTAG2 = 21;
    private static final int INDEX_USERTAG3 = 22;
    private static final int INDEX_USERTAG4 = 23;
    private static final int INDEX_VALIDFLAG = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSHelpModuleBase proxyPSHelpModuleBase = null;
    private boolean articleurlDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modparamDirtyFlag = false;
    private boolean modparam2DirtyFlag = false;
    private boolean modulesnDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppshelpmoduleidDirtyFlag = false;
    private boolean ppshelpmodulenameDirtyFlag = false;
    private boolean pshelparticleidDirtyFlag = false;
    private boolean pshelparticlenameDirtyFlag = false;
    private boolean pshelpmoduleidDirtyFlag = false;
    private boolean pshelpmodulenameDirtyFlag = false;
    private boolean pshelpprjidDirtyFlag = false;
    private boolean pshelpprjnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="articleurl")
    private String articleurl;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="modparam")
    private String modparam;
    @Column(name="modparam2")
    private String modparam2;
    @Column(name="modulesn")
    private String modulesn;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppshelpmoduleid")
    private String ppshelpmoduleid;
    @Column(name="ppshelpmodulename")
    private String ppshelpmodulename;
    @Column(name="pshelparticleid")
    private String pshelparticleid;
    @Column(name="pshelparticlename")
    private String pshelparticlename;
    @Column(name="pshelpmoduleid")
    private String pshelpmoduleid;
    @Column(name="pshelpmodulename")
    private String pshelpmodulename;
    @Column(name="pshelpprjid")
    private String pshelpprjid;
    @Column(name="pshelpprjname")
    private String pshelpprjname;
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
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSHelpArticleLock = new Integer(1);
    private PSHelpArticle pshelparticle = null;
    private Integer objPPSHelpModuleLock = new Integer(1);
    private PSHelpModule ppshelpmodule = null;
    private Integer objPSHelpPrjLock = new Integer(1);
    private PSHelpPrj pshelpprj = null;

    public void setArticleUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.articleurl = string;
        this.articleurlDirtyFlag = true;
    }

    public String getArticleUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleUrl();
        }
        return this.articleurl;
    }

    public boolean isArticleUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleUrlDirty();
        }
        return this.articleurlDirtyFlag;
    }

    public void resetArticleUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleUrl();
            return;
        }
        this.articleurlDirtyFlag = false;
        this.articleurl = null;
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

    public void setModParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modparam = string;
        this.modparamDirtyFlag = true;
    }

    public String getModParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModParam();
        }
        return this.modparam;
    }

    public boolean isModParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModParamDirty();
        }
        return this.modparamDirtyFlag;
    }

    public void resetModParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModParam();
            return;
        }
        this.modparamDirtyFlag = false;
        this.modparam = null;
    }

    public void setModParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modparam2 = string;
        this.modparam2DirtyFlag = true;
    }

    public String getModParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModParam2();
        }
        return this.modparam2;
    }

    public boolean isModParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModParam2Dirty();
        }
        return this.modparam2DirtyFlag;
    }

    public void resetModParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModParam2();
            return;
        }
        this.modparam2DirtyFlag = false;
        this.modparam2 = null;
    }

    public void setModuleSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modulesn = string;
        this.modulesnDirtyFlag = true;
    }

    public String getModuleSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleSN();
        }
        return this.modulesn;
    }

    public boolean isModuleSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleSNDirty();
        }
        return this.modulesnDirtyFlag;
    }

    public void resetModuleSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleSN();
            return;
        }
        this.modulesnDirtyFlag = false;
        this.modulesn = null;
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

    public void setPPSHelpModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSHelpModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppshelpmoduleid = string;
        this.ppshelpmoduleidDirtyFlag = true;
    }

    public String getPPSHelpModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSHelpModuleId();
        }
        return this.ppshelpmoduleid;
    }

    public boolean isPPSHelpModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSHelpModuleIdDirty();
        }
        return this.ppshelpmoduleidDirtyFlag;
    }

    public void resetPPSHelpModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSHelpModuleId();
            return;
        }
        this.ppshelpmoduleidDirtyFlag = false;
        this.ppshelpmoduleid = null;
    }

    public void setPPSHelpModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSHelpModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppshelpmodulename = string;
        this.ppshelpmodulenameDirtyFlag = true;
    }

    public String getPPSHelpModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSHelpModuleName();
        }
        return this.ppshelpmodulename;
    }

    public boolean isPPSHelpModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSHelpModuleNameDirty();
        }
        return this.ppshelpmodulenameDirtyFlag;
    }

    public void resetPPSHelpModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSHelpModuleName();
            return;
        }
        this.ppshelpmodulenameDirtyFlag = false;
        this.ppshelpmodulename = null;
    }

    public void setPSHelpArticleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticleid = string;
        this.pshelparticleidDirtyFlag = true;
    }

    public String getPSHelpArticleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleId();
        }
        return this.pshelparticleid;
    }

    public boolean isPSHelpArticleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleIdDirty();
        }
        return this.pshelparticleidDirtyFlag;
    }

    public void resetPSHelpArticleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleId();
            return;
        }
        this.pshelparticleidDirtyFlag = false;
        this.pshelparticleid = null;
    }

    public void setPSHelpArticleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpArticleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelparticlename = string;
        this.pshelparticlenameDirtyFlag = true;
    }

    public String getPSHelpArticleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticleName();
        }
        return this.pshelparticlename;
    }

    public boolean isPSHelpArticleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpArticleNameDirty();
        }
        return this.pshelparticlenameDirtyFlag;
    }

    public void resetPSHelpArticleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpArticleName();
            return;
        }
        this.pshelparticlenameDirtyFlag = false;
        this.pshelparticlename = null;
    }

    public void setPSHelpModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpmoduleid = string;
        this.pshelpmoduleidDirtyFlag = true;
    }

    public String getPSHelpModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpModuleId();
        }
        return this.pshelpmoduleid;
    }

    public boolean isPSHelpModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpModuleIdDirty();
        }
        return this.pshelpmoduleidDirtyFlag;
    }

    public void resetPSHelpModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpModuleId();
            return;
        }
        this.pshelpmoduleidDirtyFlag = false;
        this.pshelpmoduleid = null;
    }

    public void setPSHelpModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpmodulename = string;
        this.pshelpmodulenameDirtyFlag = true;
    }

    public String getPSHelpModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpModuleName();
        }
        return this.pshelpmodulename;
    }

    public boolean isPSHelpModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpModuleNameDirty();
        }
        return this.pshelpmodulenameDirtyFlag;
    }

    public void resetPSHelpModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpModuleName();
            return;
        }
        this.pshelpmodulenameDirtyFlag = false;
        this.pshelpmodulename = null;
    }

    public void setPSHelpPrjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpPrjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpprjid = string;
        this.pshelpprjidDirtyFlag = true;
    }

    public String getPSHelpPrjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpPrjId();
        }
        return this.pshelpprjid;
    }

    public boolean isPSHelpPrjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpPrjIdDirty();
        }
        return this.pshelpprjidDirtyFlag;
    }

    public void resetPSHelpPrjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpPrjId();
            return;
        }
        this.pshelpprjidDirtyFlag = false;
        this.pshelpprjid = null;
    }

    public void setPSHelpPrjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpPrjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpprjname = string;
        this.pshelpprjnameDirtyFlag = true;
    }

    public String getPSHelpPrjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpPrjName();
        }
        return this.pshelpprjname;
    }

    public boolean isPSHelpPrjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpPrjNameDirty();
        }
        return this.pshelpprjnameDirtyFlag;
    }

    public void resetPSHelpPrjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpPrjName();
            return;
        }
        this.pshelpprjnameDirtyFlag = false;
        this.pshelpprjname = null;
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
        PSHelpModuleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSHelpModuleBase pSHelpModuleBase) {
        pSHelpModuleBase.resetArticleUrl();
        pSHelpModuleBase.resetCodeName();
        pSHelpModuleBase.resetCreateDate();
        pSHelpModuleBase.resetCreateMan();
        pSHelpModuleBase.resetMemo();
        pSHelpModuleBase.resetModParam();
        pSHelpModuleBase.resetModParam2();
        pSHelpModuleBase.resetModuleSN();
        pSHelpModuleBase.resetOrderValue();
        pSHelpModuleBase.resetPPSHelpModuleId();
        pSHelpModuleBase.resetPPSHelpModuleName();
        pSHelpModuleBase.resetPSHelpArticleId();
        pSHelpModuleBase.resetPSHelpArticleName();
        pSHelpModuleBase.resetPSHelpModuleId();
        pSHelpModuleBase.resetPSHelpModuleName();
        pSHelpModuleBase.resetPSHelpPrjId();
        pSHelpModuleBase.resetPSHelpPrjName();
        pSHelpModuleBase.resetUpdateDate();
        pSHelpModuleBase.resetUpdateMan();
        pSHelpModuleBase.resetUserCat();
        pSHelpModuleBase.resetUserTag();
        pSHelpModuleBase.resetUserTag2();
        pSHelpModuleBase.resetUserTag3();
        pSHelpModuleBase.resetUserTag4();
        pSHelpModuleBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isArticleUrlDirty()) {
            hashMap.put(FIELD_ARTICLEURL, this.getArticleUrl());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
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
        if (!bl || this.isModParamDirty()) {
            hashMap.put(FIELD_MODPARAM, this.getModParam());
        }
        if (!bl || this.isModParam2Dirty()) {
            hashMap.put(FIELD_MODPARAM2, this.getModParam2());
        }
        if (!bl || this.isModuleSNDirty()) {
            hashMap.put(FIELD_MODULESN, this.getModuleSN());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSHelpModuleIdDirty()) {
            hashMap.put(FIELD_PPSHELPMODULEID, this.getPPSHelpModuleId());
        }
        if (!bl || this.isPPSHelpModuleNameDirty()) {
            hashMap.put(FIELD_PPSHELPMODULENAME, this.getPPSHelpModuleName());
        }
        if (!bl || this.isPSHelpArticleIdDirty()) {
            hashMap.put(FIELD_PSHELPARTICLEID, this.getPSHelpArticleId());
        }
        if (!bl || this.isPSHelpArticleNameDirty()) {
            hashMap.put(FIELD_PSHELPARTICLENAME, this.getPSHelpArticleName());
        }
        if (!bl || this.isPSHelpModuleIdDirty()) {
            hashMap.put(FIELD_PSHELPMODULEID, this.getPSHelpModuleId());
        }
        if (!bl || this.isPSHelpModuleNameDirty()) {
            hashMap.put(FIELD_PSHELPMODULENAME, this.getPSHelpModuleName());
        }
        if (!bl || this.isPSHelpPrjIdDirty()) {
            hashMap.put(FIELD_PSHELPPRJID, this.getPSHelpPrjId());
        }
        if (!bl || this.isPSHelpPrjNameDirty()) {
            hashMap.put(FIELD_PSHELPPRJNAME, this.getPSHelpPrjName());
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
        return PSHelpModuleBase.get(this, n);
    }

    private static Object get(PSHelpModuleBase pSHelpModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpModuleBase.getArticleUrl();
            }
            case 1: {
                return pSHelpModuleBase.getCodeName();
            }
            case 2: {
                return pSHelpModuleBase.getCreateDate();
            }
            case 3: {
                return pSHelpModuleBase.getCreateMan();
            }
            case 4: {
                return pSHelpModuleBase.getMemo();
            }
            case 5: {
                return pSHelpModuleBase.getModParam();
            }
            case 6: {
                return pSHelpModuleBase.getModParam2();
            }
            case 7: {
                return pSHelpModuleBase.getModuleSN();
            }
            case 8: {
                return pSHelpModuleBase.getOrderValue();
            }
            case 9: {
                return pSHelpModuleBase.getPPSHelpModuleId();
            }
            case 10: {
                return pSHelpModuleBase.getPPSHelpModuleName();
            }
            case 11: {
                return pSHelpModuleBase.getPSHelpArticleId();
            }
            case 12: {
                return pSHelpModuleBase.getPSHelpArticleName();
            }
            case 13: {
                return pSHelpModuleBase.getPSHelpModuleId();
            }
            case 14: {
                return pSHelpModuleBase.getPSHelpModuleName();
            }
            case 15: {
                return pSHelpModuleBase.getPSHelpPrjId();
            }
            case 16: {
                return pSHelpModuleBase.getPSHelpPrjName();
            }
            case 17: {
                return pSHelpModuleBase.getUpdateDate();
            }
            case 18: {
                return pSHelpModuleBase.getUpdateMan();
            }
            case 19: {
                return pSHelpModuleBase.getUserCat();
            }
            case 20: {
                return pSHelpModuleBase.getUserTag();
            }
            case 21: {
                return pSHelpModuleBase.getUserTag2();
            }
            case 22: {
                return pSHelpModuleBase.getUserTag3();
            }
            case 23: {
                return pSHelpModuleBase.getUserTag4();
            }
            case 24: {
                return pSHelpModuleBase.getValidFlag();
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
        PSHelpModuleBase.set(this, n, object);
    }

    private static void set(PSHelpModuleBase pSHelpModuleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSHelpModuleBase.setArticleUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSHelpModuleBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSHelpModuleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSHelpModuleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSHelpModuleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSHelpModuleBase.setModParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSHelpModuleBase.setModParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSHelpModuleBase.setModuleSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSHelpModuleBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSHelpModuleBase.setPPSHelpModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSHelpModuleBase.setPPSHelpModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSHelpModuleBase.setPSHelpArticleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSHelpModuleBase.setPSHelpArticleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSHelpModuleBase.setPSHelpModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSHelpModuleBase.setPSHelpModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSHelpModuleBase.setPSHelpPrjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSHelpModuleBase.setPSHelpPrjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSHelpModuleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSHelpModuleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSHelpModuleBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSHelpModuleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSHelpModuleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSHelpModuleBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSHelpModuleBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSHelpModuleBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSHelpModuleBase.isNull(this, n);
    }

    private static boolean isNull(PSHelpModuleBase pSHelpModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpModuleBase.getArticleUrl() == null;
            }
            case 1: {
                return pSHelpModuleBase.getCodeName() == null;
            }
            case 2: {
                return pSHelpModuleBase.getCreateDate() == null;
            }
            case 3: {
                return pSHelpModuleBase.getCreateMan() == null;
            }
            case 4: {
                return pSHelpModuleBase.getMemo() == null;
            }
            case 5: {
                return pSHelpModuleBase.getModParam() == null;
            }
            case 6: {
                return pSHelpModuleBase.getModParam2() == null;
            }
            case 7: {
                return pSHelpModuleBase.getModuleSN() == null;
            }
            case 8: {
                return pSHelpModuleBase.getOrderValue() == null;
            }
            case 9: {
                return pSHelpModuleBase.getPPSHelpModuleId() == null;
            }
            case 10: {
                return pSHelpModuleBase.getPPSHelpModuleName() == null;
            }
            case 11: {
                return pSHelpModuleBase.getPSHelpArticleId() == null;
            }
            case 12: {
                return pSHelpModuleBase.getPSHelpArticleName() == null;
            }
            case 13: {
                return pSHelpModuleBase.getPSHelpModuleId() == null;
            }
            case 14: {
                return pSHelpModuleBase.getPSHelpModuleName() == null;
            }
            case 15: {
                return pSHelpModuleBase.getPSHelpPrjId() == null;
            }
            case 16: {
                return pSHelpModuleBase.getPSHelpPrjName() == null;
            }
            case 17: {
                return pSHelpModuleBase.getUpdateDate() == null;
            }
            case 18: {
                return pSHelpModuleBase.getUpdateMan() == null;
            }
            case 19: {
                return pSHelpModuleBase.getUserCat() == null;
            }
            case 20: {
                return pSHelpModuleBase.getUserTag() == null;
            }
            case 21: {
                return pSHelpModuleBase.getUserTag2() == null;
            }
            case 22: {
                return pSHelpModuleBase.getUserTag3() == null;
            }
            case 23: {
                return pSHelpModuleBase.getUserTag4() == null;
            }
            case 24: {
                return pSHelpModuleBase.getValidFlag() == null;
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
        return PSHelpModuleBase.contains(this, n);
    }

    private static boolean contains(PSHelpModuleBase pSHelpModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpModuleBase.isArticleUrlDirty();
            }
            case 1: {
                return pSHelpModuleBase.isCodeNameDirty();
            }
            case 2: {
                return pSHelpModuleBase.isCreateDateDirty();
            }
            case 3: {
                return pSHelpModuleBase.isCreateManDirty();
            }
            case 4: {
                return pSHelpModuleBase.isMemoDirty();
            }
            case 5: {
                return pSHelpModuleBase.isModParamDirty();
            }
            case 6: {
                return pSHelpModuleBase.isModParam2Dirty();
            }
            case 7: {
                return pSHelpModuleBase.isModuleSNDirty();
            }
            case 8: {
                return pSHelpModuleBase.isOrderValueDirty();
            }
            case 9: {
                return pSHelpModuleBase.isPPSHelpModuleIdDirty();
            }
            case 10: {
                return pSHelpModuleBase.isPPSHelpModuleNameDirty();
            }
            case 11: {
                return pSHelpModuleBase.isPSHelpArticleIdDirty();
            }
            case 12: {
                return pSHelpModuleBase.isPSHelpArticleNameDirty();
            }
            case 13: {
                return pSHelpModuleBase.isPSHelpModuleIdDirty();
            }
            case 14: {
                return pSHelpModuleBase.isPSHelpModuleNameDirty();
            }
            case 15: {
                return pSHelpModuleBase.isPSHelpPrjIdDirty();
            }
            case 16: {
                return pSHelpModuleBase.isPSHelpPrjNameDirty();
            }
            case 17: {
                return pSHelpModuleBase.isUpdateDateDirty();
            }
            case 18: {
                return pSHelpModuleBase.isUpdateManDirty();
            }
            case 19: {
                return pSHelpModuleBase.isUserCatDirty();
            }
            case 20: {
                return pSHelpModuleBase.isUserTagDirty();
            }
            case 21: {
                return pSHelpModuleBase.isUserTag2Dirty();
            }
            case 22: {
                return pSHelpModuleBase.isUserTag3Dirty();
            }
            case 23: {
                return pSHelpModuleBase.isUserTag4Dirty();
            }
            case 24: {
                return pSHelpModuleBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSHelpModuleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSHelpModuleBase pSHelpModuleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSHelpModuleBase.getArticleUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articleurl", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getArticleUrl()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getCodeName()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getMemo()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getModParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modparam", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getModParam()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getModParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modparam2", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getModParam2()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getModuleSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modulesn", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getModuleSN()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getPPSHelpModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppshelpmoduleid", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getPPSHelpModuleId()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getPPSHelpModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppshelpmodulename", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getPPSHelpModuleName()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getPSHelpArticleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticleid", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getPSHelpArticleId()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getPSHelpArticleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelparticlename", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getPSHelpArticleName()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getPSHelpModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpmoduleid", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getPSHelpModuleId()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getPSHelpModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpmodulename", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getPSHelpModuleName()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getPSHelpPrjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpprjid", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getPSHelpPrjId()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getPSHelpPrjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpprjname", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getPSHelpPrjName()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getUserCat()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSHelpModuleBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSHelpModuleBase.getJSONValue((Object)pSHelpModuleBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSHelpModuleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSHelpModuleBase pSHelpModuleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSHelpModuleBase.getArticleUrl() != null) {
            object = pSHelpModuleBase.getArticleUrl();
            xmlNode.setAttribute(FIELD_ARTICLEURL, (String)(object == null ? "" : object));
        }
        if (bl || pSHelpModuleBase.getCodeName() != null) {
            object = pSHelpModuleBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getCreateDate() != null) {
            object = pSHelpModuleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpModuleBase.getCreateMan() != null) {
            object = pSHelpModuleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getMemo() != null) {
            object = pSHelpModuleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getModParam() != null) {
            object = pSHelpModuleBase.getModParam();
            xmlNode.setAttribute(FIELD_MODPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getModParam2() != null) {
            object = pSHelpModuleBase.getModParam2();
            xmlNode.setAttribute(FIELD_MODPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getModuleSN() != null) {
            object = pSHelpModuleBase.getModuleSN();
            xmlNode.setAttribute(FIELD_MODULESN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getOrderValue() != null) {
            object = pSHelpModuleBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSHelpModuleBase.getPPSHelpModuleId() != null) {
            object = pSHelpModuleBase.getPPSHelpModuleId();
            xmlNode.setAttribute(FIELD_PPSHELPMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getPPSHelpModuleName() != null) {
            object = pSHelpModuleBase.getPPSHelpModuleName();
            xmlNode.setAttribute(FIELD_PPSHELPMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getPSHelpArticleId() != null) {
            object = pSHelpModuleBase.getPSHelpArticleId();
            xmlNode.setAttribute(FIELD_PSHELPARTICLEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getPSHelpArticleName() != null) {
            object = pSHelpModuleBase.getPSHelpArticleName();
            xmlNode.setAttribute(FIELD_PSHELPARTICLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getPSHelpModuleId() != null) {
            object = pSHelpModuleBase.getPSHelpModuleId();
            xmlNode.setAttribute(FIELD_PSHELPMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getPSHelpModuleName() != null) {
            object = pSHelpModuleBase.getPSHelpModuleName();
            xmlNode.setAttribute(FIELD_PSHELPMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getPSHelpPrjId() != null) {
            object = pSHelpModuleBase.getPSHelpPrjId();
            xmlNode.setAttribute(FIELD_PSHELPPRJID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getPSHelpPrjName() != null) {
            object = pSHelpModuleBase.getPSHelpPrjName();
            xmlNode.setAttribute(FIELD_PSHELPPRJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getUpdateDate() != null) {
            object = pSHelpModuleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpModuleBase.getUpdateMan() != null) {
            object = pSHelpModuleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getUserCat() != null) {
            object = pSHelpModuleBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getUserTag() != null) {
            object = pSHelpModuleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getUserTag2() != null) {
            object = pSHelpModuleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getUserTag3() != null) {
            object = pSHelpModuleBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getUserTag4() != null) {
            object = pSHelpModuleBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSHelpModuleBase.getValidFlag() != null) {
            object = pSHelpModuleBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSHelpModuleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSHelpModuleBase pSHelpModuleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSHelpModuleBase.isArticleUrlDirty() && (bl || pSHelpModuleBase.getArticleUrl() != null)) {
            iDataObject.set(FIELD_ARTICLEURL, (Object)pSHelpModuleBase.getArticleUrl());
        }
        if (pSHelpModuleBase.isCodeNameDirty() && (bl || pSHelpModuleBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSHelpModuleBase.getCodeName());
        }
        if (pSHelpModuleBase.isCreateDateDirty() && (bl || pSHelpModuleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSHelpModuleBase.getCreateDate());
        }
        if (pSHelpModuleBase.isCreateManDirty() && (bl || pSHelpModuleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSHelpModuleBase.getCreateMan());
        }
        if (pSHelpModuleBase.isMemoDirty() && (bl || pSHelpModuleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSHelpModuleBase.getMemo());
        }
        if (pSHelpModuleBase.isModParamDirty() && (bl || pSHelpModuleBase.getModParam() != null)) {
            iDataObject.set(FIELD_MODPARAM, (Object)pSHelpModuleBase.getModParam());
        }
        if (pSHelpModuleBase.isModParam2Dirty() && (bl || pSHelpModuleBase.getModParam2() != null)) {
            iDataObject.set(FIELD_MODPARAM2, (Object)pSHelpModuleBase.getModParam2());
        }
        if (pSHelpModuleBase.isModuleSNDirty() && (bl || pSHelpModuleBase.getModuleSN() != null)) {
            iDataObject.set(FIELD_MODULESN, (Object)pSHelpModuleBase.getModuleSN());
        }
        if (pSHelpModuleBase.isOrderValueDirty() && (bl || pSHelpModuleBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSHelpModuleBase.getOrderValue());
        }
        if (pSHelpModuleBase.isPPSHelpModuleIdDirty() && (bl || pSHelpModuleBase.getPPSHelpModuleId() != null)) {
            iDataObject.set(FIELD_PPSHELPMODULEID, (Object)pSHelpModuleBase.getPPSHelpModuleId());
        }
        if (pSHelpModuleBase.isPPSHelpModuleNameDirty() && (bl || pSHelpModuleBase.getPPSHelpModuleName() != null)) {
            iDataObject.set(FIELD_PPSHELPMODULENAME, (Object)pSHelpModuleBase.getPPSHelpModuleName());
        }
        if (pSHelpModuleBase.isPSHelpArticleIdDirty() && (bl || pSHelpModuleBase.getPSHelpArticleId() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLEID, (Object)pSHelpModuleBase.getPSHelpArticleId());
        }
        if (pSHelpModuleBase.isPSHelpArticleNameDirty() && (bl || pSHelpModuleBase.getPSHelpArticleName() != null)) {
            iDataObject.set(FIELD_PSHELPARTICLENAME, (Object)pSHelpModuleBase.getPSHelpArticleName());
        }
        if (pSHelpModuleBase.isPSHelpModuleIdDirty() && (bl || pSHelpModuleBase.getPSHelpModuleId() != null)) {
            iDataObject.set(FIELD_PSHELPMODULEID, (Object)pSHelpModuleBase.getPSHelpModuleId());
        }
        if (pSHelpModuleBase.isPSHelpModuleNameDirty() && (bl || pSHelpModuleBase.getPSHelpModuleName() != null)) {
            iDataObject.set(FIELD_PSHELPMODULENAME, (Object)pSHelpModuleBase.getPSHelpModuleName());
        }
        if (pSHelpModuleBase.isPSHelpPrjIdDirty() && (bl || pSHelpModuleBase.getPSHelpPrjId() != null)) {
            iDataObject.set(FIELD_PSHELPPRJID, (Object)pSHelpModuleBase.getPSHelpPrjId());
        }
        if (pSHelpModuleBase.isPSHelpPrjNameDirty() && (bl || pSHelpModuleBase.getPSHelpPrjName() != null)) {
            iDataObject.set(FIELD_PSHELPPRJNAME, (Object)pSHelpModuleBase.getPSHelpPrjName());
        }
        if (pSHelpModuleBase.isUpdateDateDirty() && (bl || pSHelpModuleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSHelpModuleBase.getUpdateDate());
        }
        if (pSHelpModuleBase.isUpdateManDirty() && (bl || pSHelpModuleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSHelpModuleBase.getUpdateMan());
        }
        if (pSHelpModuleBase.isUserCatDirty() && (bl || pSHelpModuleBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSHelpModuleBase.getUserCat());
        }
        if (pSHelpModuleBase.isUserTagDirty() && (bl || pSHelpModuleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSHelpModuleBase.getUserTag());
        }
        if (pSHelpModuleBase.isUserTag2Dirty() && (bl || pSHelpModuleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSHelpModuleBase.getUserTag2());
        }
        if (pSHelpModuleBase.isUserTag3Dirty() && (bl || pSHelpModuleBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSHelpModuleBase.getUserTag3());
        }
        if (pSHelpModuleBase.isUserTag4Dirty() && (bl || pSHelpModuleBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSHelpModuleBase.getUserTag4());
        }
        if (pSHelpModuleBase.isValidFlagDirty() && (bl || pSHelpModuleBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSHelpModuleBase.getValidFlag());
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
        return PSHelpModuleBase.remove(this, n);
    }

    private static boolean remove(PSHelpModuleBase pSHelpModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSHelpModuleBase.resetArticleUrl();
                return true;
            }
            case 1: {
                pSHelpModuleBase.resetCodeName();
                return true;
            }
            case 2: {
                pSHelpModuleBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSHelpModuleBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSHelpModuleBase.resetMemo();
                return true;
            }
            case 5: {
                pSHelpModuleBase.resetModParam();
                return true;
            }
            case 6: {
                pSHelpModuleBase.resetModParam2();
                return true;
            }
            case 7: {
                pSHelpModuleBase.resetModuleSN();
                return true;
            }
            case 8: {
                pSHelpModuleBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSHelpModuleBase.resetPPSHelpModuleId();
                return true;
            }
            case 10: {
                pSHelpModuleBase.resetPPSHelpModuleName();
                return true;
            }
            case 11: {
                pSHelpModuleBase.resetPSHelpArticleId();
                return true;
            }
            case 12: {
                pSHelpModuleBase.resetPSHelpArticleName();
                return true;
            }
            case 13: {
                pSHelpModuleBase.resetPSHelpModuleId();
                return true;
            }
            case 14: {
                pSHelpModuleBase.resetPSHelpModuleName();
                return true;
            }
            case 15: {
                pSHelpModuleBase.resetPSHelpPrjId();
                return true;
            }
            case 16: {
                pSHelpModuleBase.resetPSHelpPrjName();
                return true;
            }
            case 17: {
                pSHelpModuleBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSHelpModuleBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSHelpModuleBase.resetUserCat();
                return true;
            }
            case 20: {
                pSHelpModuleBase.resetUserTag();
                return true;
            }
            case 21: {
                pSHelpModuleBase.resetUserTag2();
                return true;
            }
            case 22: {
                pSHelpModuleBase.resetUserTag3();
                return true;
            }
            case 23: {
                pSHelpModuleBase.resetUserTag4();
                return true;
            }
            case 24: {
                pSHelpModuleBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpArticle getPSHelpArticle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpArticle();
        }
        if (this.getPSHelpArticleId() == null) {
            return null;
        }
        Integer n = this.objPSHelpArticleLock;
        synchronized (n) {
            if (this.pshelparticle != null && DataTypeHelper.compare((int)25, (Object)this.getPSHelpArticleId(), (Object)this.pshelparticle.getPSHelpArticleId()) != 0L) {
                this.pshelparticle = null;
            }
            if (this.pshelparticle == null) {
                PSHelpArticle pSHelpArticle = new PSHelpArticle();
                pSHelpArticle.setPSHelpArticleId(this.getPSHelpArticleId());
                PSHelpArticleService pSHelpArticleService = (PSHelpArticleService)ServiceGlobal.getService(PSHelpArticleService.class, (SessionFactory)this.getSessionFactory());
                pSHelpArticleService.autoGet((IEntity)pSHelpArticle);
                this.pshelparticle = pSHelpArticle;
            }
            return this.pshelparticle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpModule getPPSHelpModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSHelpModule();
        }
        if (this.getPPSHelpModuleId() == null) {
            return null;
        }
        Integer n = this.objPPSHelpModuleLock;
        synchronized (n) {
            if (this.ppshelpmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPPSHelpModuleId(), (Object)this.ppshelpmodule.getPSHelpModuleId()) != 0L) {
                this.ppshelpmodule = null;
            }
            if (this.ppshelpmodule == null) {
                PSHelpModule pSHelpModule = new PSHelpModule();
                pSHelpModule.setPSHelpModuleId(this.getPPSHelpModuleId());
                PSHelpModuleService pSHelpModuleService = (PSHelpModuleService)ServiceGlobal.getService(PSHelpModuleService.class, (SessionFactory)this.getSessionFactory());
                pSHelpModuleService.autoGet((IEntity)pSHelpModule);
                this.ppshelpmodule = pSHelpModule;
            }
            return this.ppshelpmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpPrj getPSHelpPrj() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpPrj();
        }
        if (this.getPSHelpPrjId() == null) {
            return null;
        }
        Integer n = this.objPSHelpPrjLock;
        synchronized (n) {
            if (this.pshelpprj != null && DataTypeHelper.compare((int)25, (Object)this.getPSHelpPrjId(), (Object)this.pshelpprj.getPSHelpPrjId()) != 0L) {
                this.pshelpprj = null;
            }
            if (this.pshelpprj == null) {
                PSHelpPrj pSHelpPrj = new PSHelpPrj();
                pSHelpPrj.setPSHelpPrjId(this.getPSHelpPrjId());
                PSHelpPrjService pSHelpPrjService = (PSHelpPrjService)ServiceGlobal.getService(PSHelpPrjService.class, (SessionFactory)this.getSessionFactory());
                pSHelpPrjService.autoGet((IEntity)pSHelpPrj);
                this.pshelpprj = pSHelpPrj;
            }
            return this.pshelpprj;
        }
    }

    private PSHelpModuleBase getProxyEntity() {
        return this.proxyPSHelpModuleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSHelpModuleBase = null;
        if (iDataObject != null && iDataObject instanceof PSHelpModuleBase) {
            this.proxyPSHelpModuleBase = (PSHelpModuleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpModuleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ARTICLEURL, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MODPARAM, 5);
        fieldIndexMap.put(FIELD_MODPARAM2, 6);
        fieldIndexMap.put(FIELD_MODULESN, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PPSHELPMODULEID, 9);
        fieldIndexMap.put(FIELD_PPSHELPMODULENAME, 10);
        fieldIndexMap.put(FIELD_PSHELPARTICLEID, 11);
        fieldIndexMap.put(FIELD_PSHELPARTICLENAME, 12);
        fieldIndexMap.put(FIELD_PSHELPMODULEID, 13);
        fieldIndexMap.put(FIELD_PSHELPMODULENAME, 14);
        fieldIndexMap.put(FIELD_PSHELPPRJID, 15);
        fieldIndexMap.put(FIELD_PSHELPPRJNAME, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_USERCAT, 19);
        fieldIndexMap.put(FIELD_USERTAG, 20);
        fieldIndexMap.put(FIELD_USERTAG2, 21);
        fieldIndexMap.put(FIELD_USERTAG3, 22);
        fieldIndexMap.put(FIELD_USERTAG4, 23);
        fieldIndexMap.put(FIELD_VALIDFLAG, 24);
    }
}

