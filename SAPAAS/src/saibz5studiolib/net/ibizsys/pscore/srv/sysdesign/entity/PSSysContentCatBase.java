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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysContent;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysContentCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysContentCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysContentService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysContentCatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysContentCatBase.class);
    public static final String FIELD_CATTAG = "CATTAG";
    public static final String FIELD_CATTAG2 = "CATTAG2";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSSYSCONTENTCATID = "PPSSYSCONTENTCATID";
    public static final String FIELD_PPSSYSCONTENTCATNAME = "PPSSYSCONTENTCATNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSCONTENTCATID = "PSSYSCONTENTCATID";
    public static final String FIELD_PSSYSCONTENTCATNAME = "PSSYSCONTENTCATNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_SUBJECT = "SUBJECT";
    public static final String FIELD_TAGS = "TAGS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CATTAG = 0;
    private static final int INDEX_CATTAG2 = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PPSSYSCONTENTCATID = 7;
    private static final int INDEX_PPSSYSCONTENTCATNAME = 8;
    private static final int INDEX_PSMODULEID = 9;
    private static final int INDEX_PSMODULENAME = 10;
    private static final int INDEX_PSSYSCONTENTCATID = 11;
    private static final int INDEX_PSSYSCONTENTCATNAME = 12;
    private static final int INDEX_PSSYSDYNAMODELID = 13;
    private static final int INDEX_PSSYSDYNAMODELNAME = 14;
    private static final int INDEX_PSSYSTEMID = 15;
    private static final int INDEX_PSSYSTEMNAME = 16;
    private static final int INDEX_SUBJECT = 17;
    private static final int INDEX_TAGS = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final int INDEX_USERTAG3 = 24;
    private static final int INDEX_USERTAG4 = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysContentCatBase proxyPSSysContentCatBase = null;
    private boolean cattagDirtyFlag = false;
    private boolean cattag2DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppssyscontentcatidDirtyFlag = false;
    private boolean ppssyscontentcatnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyscontentcatidDirtyFlag = false;
    private boolean pssyscontentcatnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean subjectDirtyFlag = false;
    private boolean tagsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="cattag")
    private String cattag;
    @Column(name="cattag2")
    private String cattag2;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppssyscontentcatid")
    private String ppssyscontentcatid;
    @Column(name="ppssyscontentcatname")
    private String ppssyscontentcatname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyscontentcatid")
    private String pssyscontentcatid;
    @Column(name="pssyscontentcatname")
    private String pssyscontentcatname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="subject")
    private String subject;
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
    private Integer objPPSSysContentCatLock = new Integer(1);
    private PSSysContentCat ppssyscontentcat = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysContentCatsLock = new Integer(1);
    private ArrayList<PSSysContentCat> pssyscontentcats = null;
    private Integer objPSSysContentsLock = new Integer(1);
    private ArrayList<PSSysContent> pssyscontents = null;

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

    public void setPPSSysContentCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysContentCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssyscontentcatid = string;
        this.ppssyscontentcatidDirtyFlag = true;
    }

    public String getPPSSysContentCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysContentCatId();
        }
        return this.ppssyscontentcatid;
    }

    public boolean isPPSSysContentCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysContentCatIdDirty();
        }
        return this.ppssyscontentcatidDirtyFlag;
    }

    public void resetPPSSysContentCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysContentCatId();
            return;
        }
        this.ppssyscontentcatidDirtyFlag = false;
        this.ppssyscontentcatid = null;
    }

    public void setPPSSysContentCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysContentCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssyscontentcatname = string;
        this.ppssyscontentcatnameDirtyFlag = true;
    }

    public String getPPSSysContentCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysContentCatName();
        }
        return this.ppssyscontentcatname;
    }

    public boolean isPPSSysContentCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysContentCatNameDirty();
        }
        return this.ppssyscontentcatnameDirtyFlag;
    }

    public void resetPPSSysContentCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysContentCatName();
            return;
        }
        this.ppssyscontentcatnameDirtyFlag = false;
        this.ppssyscontentcatname = null;
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

    public void setPSSysContentCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysContentCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscontentcatid = string;
        this.pssyscontentcatidDirtyFlag = true;
    }

    public String getPSSysContentCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysContentCatId();
        }
        return this.pssyscontentcatid;
    }

    public boolean isPSSysContentCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysContentCatIdDirty();
        }
        return this.pssyscontentcatidDirtyFlag;
    }

    public void resetPSSysContentCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysContentCatId();
            return;
        }
        this.pssyscontentcatidDirtyFlag = false;
        this.pssyscontentcatid = null;
    }

    public void setPSSysContentCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysContentCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscontentcatname = string;
        this.pssyscontentcatnameDirtyFlag = true;
    }

    public String getPSSysContentCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysContentCatName();
        }
        return this.pssyscontentcatname;
    }

    public boolean isPSSysContentCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysContentCatNameDirty();
        }
        return this.pssyscontentcatnameDirtyFlag;
    }

    public void resetPSSysContentCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysContentCatName();
            return;
        }
        this.pssyscontentcatnameDirtyFlag = false;
        this.pssyscontentcatname = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
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

    public void setSubject(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubject(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subject = string;
        this.subjectDirtyFlag = true;
    }

    public String getSubject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubject();
        }
        return this.subject;
    }

    public boolean isSubjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubjectDirty();
        }
        return this.subjectDirtyFlag;
    }

    public void resetSubject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubject();
            return;
        }
        this.subjectDirtyFlag = false;
        this.subject = null;
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
        PSSysContentCatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysContentCatBase pSSysContentCatBase) {
        pSSysContentCatBase.resetCatTag();
        pSSysContentCatBase.resetCatTag2();
        pSSysContentCatBase.resetCodeName();
        pSSysContentCatBase.resetCreateDate();
        pSSysContentCatBase.resetCreateMan();
        pSSysContentCatBase.resetMemo();
        pSSysContentCatBase.resetOrderValue();
        pSSysContentCatBase.resetPPSSysContentCatId();
        pSSysContentCatBase.resetPPSSysContentCatName();
        pSSysContentCatBase.resetPSModuleId();
        pSSysContentCatBase.resetPSModuleName();
        pSSysContentCatBase.resetPSSysContentCatId();
        pSSysContentCatBase.resetPSSysContentCatName();
        pSSysContentCatBase.resetPSSysDynaModelId();
        pSSysContentCatBase.resetPSSysDynaModelName();
        pSSysContentCatBase.resetPSSystemId();
        pSSysContentCatBase.resetPSSystemName();
        pSSysContentCatBase.resetSubject();
        pSSysContentCatBase.resetTags();
        pSSysContentCatBase.resetUpdateDate();
        pSSysContentCatBase.resetUpdateMan();
        pSSysContentCatBase.resetUserCat();
        pSSysContentCatBase.resetUserTag();
        pSSysContentCatBase.resetUserTag2();
        pSSysContentCatBase.resetUserTag3();
        pSSysContentCatBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCatTagDirty()) {
            hashMap.put(FIELD_CATTAG, this.getCatTag());
        }
        if (!bl || this.isCatTag2Dirty()) {
            hashMap.put(FIELD_CATTAG2, this.getCatTag2());
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
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSSysContentCatIdDirty()) {
            hashMap.put(FIELD_PPSSYSCONTENTCATID, this.getPPSSysContentCatId());
        }
        if (!bl || this.isPPSSysContentCatNameDirty()) {
            hashMap.put(FIELD_PPSSYSCONTENTCATNAME, this.getPPSSysContentCatName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysContentCatIdDirty()) {
            hashMap.put(FIELD_PSSYSCONTENTCATID, this.getPSSysContentCatId());
        }
        if (!bl || this.isPSSysContentCatNameDirty()) {
            hashMap.put(FIELD_PSSYSCONTENTCATNAME, this.getPSSysContentCatName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isSubjectDirty()) {
            hashMap.put(FIELD_SUBJECT, this.getSubject());
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
        return PSSysContentCatBase.get(this, n);
    }

    private static Object get(PSSysContentCatBase pSSysContentCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysContentCatBase.getCatTag();
            }
            case 1: {
                return pSSysContentCatBase.getCatTag2();
            }
            case 2: {
                return pSSysContentCatBase.getCodeName();
            }
            case 3: {
                return pSSysContentCatBase.getCreateDate();
            }
            case 4: {
                return pSSysContentCatBase.getCreateMan();
            }
            case 5: {
                return pSSysContentCatBase.getMemo();
            }
            case 6: {
                return pSSysContentCatBase.getOrderValue();
            }
            case 7: {
                return pSSysContentCatBase.getPPSSysContentCatId();
            }
            case 8: {
                return pSSysContentCatBase.getPPSSysContentCatName();
            }
            case 9: {
                return pSSysContentCatBase.getPSModuleId();
            }
            case 10: {
                return pSSysContentCatBase.getPSModuleName();
            }
            case 11: {
                return pSSysContentCatBase.getPSSysContentCatId();
            }
            case 12: {
                return pSSysContentCatBase.getPSSysContentCatName();
            }
            case 13: {
                return pSSysContentCatBase.getPSSysDynaModelId();
            }
            case 14: {
                return pSSysContentCatBase.getPSSysDynaModelName();
            }
            case 15: {
                return pSSysContentCatBase.getPSSystemId();
            }
            case 16: {
                return pSSysContentCatBase.getPSSystemName();
            }
            case 17: {
                return pSSysContentCatBase.getSubject();
            }
            case 18: {
                return pSSysContentCatBase.getTags();
            }
            case 19: {
                return pSSysContentCatBase.getUpdateDate();
            }
            case 20: {
                return pSSysContentCatBase.getUpdateMan();
            }
            case 21: {
                return pSSysContentCatBase.getUserCat();
            }
            case 22: {
                return pSSysContentCatBase.getUserTag();
            }
            case 23: {
                return pSSysContentCatBase.getUserTag2();
            }
            case 24: {
                return pSSysContentCatBase.getUserTag3();
            }
            case 25: {
                return pSSysContentCatBase.getUserTag4();
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
        PSSysContentCatBase.set(this, n, object);
    }

    private static void set(PSSysContentCatBase pSSysContentCatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysContentCatBase.setCatTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysContentCatBase.setCatTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysContentCatBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysContentCatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSysContentCatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysContentCatBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysContentCatBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysContentCatBase.setPPSSysContentCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysContentCatBase.setPPSSysContentCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysContentCatBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysContentCatBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysContentCatBase.setPSSysContentCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysContentCatBase.setPSSysContentCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysContentCatBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysContentCatBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysContentCatBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysContentCatBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysContentCatBase.setSubject(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysContentCatBase.setTags(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysContentCatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSSysContentCatBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysContentCatBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysContentCatBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysContentCatBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysContentCatBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysContentCatBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysContentCatBase.isNull(this, n);
    }

    private static boolean isNull(PSSysContentCatBase pSSysContentCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysContentCatBase.getCatTag() == null;
            }
            case 1: {
                return pSSysContentCatBase.getCatTag2() == null;
            }
            case 2: {
                return pSSysContentCatBase.getCodeName() == null;
            }
            case 3: {
                return pSSysContentCatBase.getCreateDate() == null;
            }
            case 4: {
                return pSSysContentCatBase.getCreateMan() == null;
            }
            case 5: {
                return pSSysContentCatBase.getMemo() == null;
            }
            case 6: {
                return pSSysContentCatBase.getOrderValue() == null;
            }
            case 7: {
                return pSSysContentCatBase.getPPSSysContentCatId() == null;
            }
            case 8: {
                return pSSysContentCatBase.getPPSSysContentCatName() == null;
            }
            case 9: {
                return pSSysContentCatBase.getPSModuleId() == null;
            }
            case 10: {
                return pSSysContentCatBase.getPSModuleName() == null;
            }
            case 11: {
                return pSSysContentCatBase.getPSSysContentCatId() == null;
            }
            case 12: {
                return pSSysContentCatBase.getPSSysContentCatName() == null;
            }
            case 13: {
                return pSSysContentCatBase.getPSSysDynaModelId() == null;
            }
            case 14: {
                return pSSysContentCatBase.getPSSysDynaModelName() == null;
            }
            case 15: {
                return pSSysContentCatBase.getPSSystemId() == null;
            }
            case 16: {
                return pSSysContentCatBase.getPSSystemName() == null;
            }
            case 17: {
                return pSSysContentCatBase.getSubject() == null;
            }
            case 18: {
                return pSSysContentCatBase.getTags() == null;
            }
            case 19: {
                return pSSysContentCatBase.getUpdateDate() == null;
            }
            case 20: {
                return pSSysContentCatBase.getUpdateMan() == null;
            }
            case 21: {
                return pSSysContentCatBase.getUserCat() == null;
            }
            case 22: {
                return pSSysContentCatBase.getUserTag() == null;
            }
            case 23: {
                return pSSysContentCatBase.getUserTag2() == null;
            }
            case 24: {
                return pSSysContentCatBase.getUserTag3() == null;
            }
            case 25: {
                return pSSysContentCatBase.getUserTag4() == null;
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
        return PSSysContentCatBase.contains(this, n);
    }

    private static boolean contains(PSSysContentCatBase pSSysContentCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysContentCatBase.isCatTagDirty();
            }
            case 1: {
                return pSSysContentCatBase.isCatTag2Dirty();
            }
            case 2: {
                return pSSysContentCatBase.isCodeNameDirty();
            }
            case 3: {
                return pSSysContentCatBase.isCreateDateDirty();
            }
            case 4: {
                return pSSysContentCatBase.isCreateManDirty();
            }
            case 5: {
                return pSSysContentCatBase.isMemoDirty();
            }
            case 6: {
                return pSSysContentCatBase.isOrderValueDirty();
            }
            case 7: {
                return pSSysContentCatBase.isPPSSysContentCatIdDirty();
            }
            case 8: {
                return pSSysContentCatBase.isPPSSysContentCatNameDirty();
            }
            case 9: {
                return pSSysContentCatBase.isPSModuleIdDirty();
            }
            case 10: {
                return pSSysContentCatBase.isPSModuleNameDirty();
            }
            case 11: {
                return pSSysContentCatBase.isPSSysContentCatIdDirty();
            }
            case 12: {
                return pSSysContentCatBase.isPSSysContentCatNameDirty();
            }
            case 13: {
                return pSSysContentCatBase.isPSSysDynaModelIdDirty();
            }
            case 14: {
                return pSSysContentCatBase.isPSSysDynaModelNameDirty();
            }
            case 15: {
                return pSSysContentCatBase.isPSSystemIdDirty();
            }
            case 16: {
                return pSSysContentCatBase.isPSSystemNameDirty();
            }
            case 17: {
                return pSSysContentCatBase.isSubjectDirty();
            }
            case 18: {
                return pSSysContentCatBase.isTagsDirty();
            }
            case 19: {
                return pSSysContentCatBase.isUpdateDateDirty();
            }
            case 20: {
                return pSSysContentCatBase.isUpdateManDirty();
            }
            case 21: {
                return pSSysContentCatBase.isUserCatDirty();
            }
            case 22: {
                return pSSysContentCatBase.isUserTagDirty();
            }
            case 23: {
                return pSSysContentCatBase.isUserTag2Dirty();
            }
            case 24: {
                return pSSysContentCatBase.isUserTag3Dirty();
            }
            case 25: {
                return pSSysContentCatBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysContentCatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysContentCatBase pSSysContentCatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysContentCatBase.getCatTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cattag", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getCatTag()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getCatTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cattag2", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getCatTag2()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getPPSSysContentCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssyscontentcatid", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getPPSSysContentCatId()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getPPSSysContentCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssyscontentcatname", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getPPSSysContentCatName()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getPSSysContentCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscontentcatid", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getPSSysContentCatId()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getPSSysContentCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscontentcatname", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getPSSysContentCatName()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getSubject() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subject", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getSubject()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getTags() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tags", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getTags()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysContentCatBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysContentCatBase.getJSONValue((Object)pSSysContentCatBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysContentCatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysContentCatBase pSSysContentCatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysContentCatBase.getCatTag() != null) {
            object = pSSysContentCatBase.getCatTag();
            xmlNode.setAttribute(FIELD_CATTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysContentCatBase.getCatTag2() != null) {
            object = pSSysContentCatBase.getCatTag2();
            xmlNode.setAttribute(FIELD_CATTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysContentCatBase.getCodeName() != null) {
            object = pSSysContentCatBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getCreateDate() != null) {
            object = pSSysContentCatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysContentCatBase.getCreateMan() != null) {
            object = pSSysContentCatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getMemo() != null) {
            object = pSSysContentCatBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getOrderValue() != null) {
            object = pSSysContentCatBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysContentCatBase.getPPSSysContentCatId() != null) {
            object = pSSysContentCatBase.getPPSSysContentCatId();
            xmlNode.setAttribute(FIELD_PPSSYSCONTENTCATID, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getPPSSysContentCatName() != null) {
            object = pSSysContentCatBase.getPPSSysContentCatName();
            xmlNode.setAttribute(FIELD_PPSSYSCONTENTCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getPSModuleId() != null) {
            object = pSSysContentCatBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getPSModuleName() != null) {
            object = pSSysContentCatBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getPSSysContentCatId() != null) {
            object = pSSysContentCatBase.getPSSysContentCatId();
            xmlNode.setAttribute(FIELD_PSSYSCONTENTCATID, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getPSSysContentCatName() != null) {
            object = pSSysContentCatBase.getPSSysContentCatName();
            xmlNode.setAttribute(FIELD_PSSYSCONTENTCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getPSSysDynaModelId() != null) {
            object = pSSysContentCatBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getPSSysDynaModelName() != null) {
            object = pSSysContentCatBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getPSSystemId() != null) {
            object = pSSysContentCatBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getPSSystemName() != null) {
            object = pSSysContentCatBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getSubject() != null) {
            object = pSSysContentCatBase.getSubject();
            xmlNode.setAttribute(FIELD_SUBJECT, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getTags() != null) {
            object = pSSysContentCatBase.getTags();
            xmlNode.setAttribute(FIELD_TAGS, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getUpdateDate() != null) {
            object = pSSysContentCatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysContentCatBase.getUpdateMan() != null) {
            object = pSSysContentCatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getUserCat() != null) {
            object = pSSysContentCatBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getUserTag() != null) {
            object = pSSysContentCatBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getUserTag2() != null) {
            object = pSSysContentCatBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getUserTag3() != null) {
            object = pSSysContentCatBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysContentCatBase.getUserTag4() != null) {
            object = pSSysContentCatBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysContentCatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysContentCatBase pSSysContentCatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysContentCatBase.isCatTagDirty() && (bl || pSSysContentCatBase.getCatTag() != null)) {
            iDataObject.set(FIELD_CATTAG, (Object)pSSysContentCatBase.getCatTag());
        }
        if (pSSysContentCatBase.isCatTag2Dirty() && (bl || pSSysContentCatBase.getCatTag2() != null)) {
            iDataObject.set(FIELD_CATTAG2, (Object)pSSysContentCatBase.getCatTag2());
        }
        if (pSSysContentCatBase.isCodeNameDirty() && (bl || pSSysContentCatBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysContentCatBase.getCodeName());
        }
        if (pSSysContentCatBase.isCreateDateDirty() && (bl || pSSysContentCatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysContentCatBase.getCreateDate());
        }
        if (pSSysContentCatBase.isCreateManDirty() && (bl || pSSysContentCatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysContentCatBase.getCreateMan());
        }
        if (pSSysContentCatBase.isMemoDirty() && (bl || pSSysContentCatBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysContentCatBase.getMemo());
        }
        if (pSSysContentCatBase.isOrderValueDirty() && (bl || pSSysContentCatBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysContentCatBase.getOrderValue());
        }
        if (pSSysContentCatBase.isPPSSysContentCatIdDirty() && (bl || pSSysContentCatBase.getPPSSysContentCatId() != null)) {
            iDataObject.set(FIELD_PPSSYSCONTENTCATID, (Object)pSSysContentCatBase.getPPSSysContentCatId());
        }
        if (pSSysContentCatBase.isPPSSysContentCatNameDirty() && (bl || pSSysContentCatBase.getPPSSysContentCatName() != null)) {
            iDataObject.set(FIELD_PPSSYSCONTENTCATNAME, (Object)pSSysContentCatBase.getPPSSysContentCatName());
        }
        if (pSSysContentCatBase.isPSModuleIdDirty() && (bl || pSSysContentCatBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysContentCatBase.getPSModuleId());
        }
        if (pSSysContentCatBase.isPSModuleNameDirty() && (bl || pSSysContentCatBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysContentCatBase.getPSModuleName());
        }
        if (pSSysContentCatBase.isPSSysContentCatIdDirty() && (bl || pSSysContentCatBase.getPSSysContentCatId() != null)) {
            iDataObject.set(FIELD_PSSYSCONTENTCATID, (Object)pSSysContentCatBase.getPSSysContentCatId());
        }
        if (pSSysContentCatBase.isPSSysContentCatNameDirty() && (bl || pSSysContentCatBase.getPSSysContentCatName() != null)) {
            iDataObject.set(FIELD_PSSYSCONTENTCATNAME, (Object)pSSysContentCatBase.getPSSysContentCatName());
        }
        if (pSSysContentCatBase.isPSSysDynaModelIdDirty() && (bl || pSSysContentCatBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysContentCatBase.getPSSysDynaModelId());
        }
        if (pSSysContentCatBase.isPSSysDynaModelNameDirty() && (bl || pSSysContentCatBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysContentCatBase.getPSSysDynaModelName());
        }
        if (pSSysContentCatBase.isPSSystemIdDirty() && (bl || pSSysContentCatBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysContentCatBase.getPSSystemId());
        }
        if (pSSysContentCatBase.isPSSystemNameDirty() && (bl || pSSysContentCatBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysContentCatBase.getPSSystemName());
        }
        if (pSSysContentCatBase.isSubjectDirty() && (bl || pSSysContentCatBase.getSubject() != null)) {
            iDataObject.set(FIELD_SUBJECT, (Object)pSSysContentCatBase.getSubject());
        }
        if (pSSysContentCatBase.isTagsDirty() && (bl || pSSysContentCatBase.getTags() != null)) {
            iDataObject.set(FIELD_TAGS, (Object)pSSysContentCatBase.getTags());
        }
        if (pSSysContentCatBase.isUpdateDateDirty() && (bl || pSSysContentCatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysContentCatBase.getUpdateDate());
        }
        if (pSSysContentCatBase.isUpdateManDirty() && (bl || pSSysContentCatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysContentCatBase.getUpdateMan());
        }
        if (pSSysContentCatBase.isUserCatDirty() && (bl || pSSysContentCatBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysContentCatBase.getUserCat());
        }
        if (pSSysContentCatBase.isUserTagDirty() && (bl || pSSysContentCatBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysContentCatBase.getUserTag());
        }
        if (pSSysContentCatBase.isUserTag2Dirty() && (bl || pSSysContentCatBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysContentCatBase.getUserTag2());
        }
        if (pSSysContentCatBase.isUserTag3Dirty() && (bl || pSSysContentCatBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysContentCatBase.getUserTag3());
        }
        if (pSSysContentCatBase.isUserTag4Dirty() && (bl || pSSysContentCatBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysContentCatBase.getUserTag4());
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
        return PSSysContentCatBase.remove(this, n);
    }

    private static boolean remove(PSSysContentCatBase pSSysContentCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysContentCatBase.resetCatTag();
                return true;
            }
            case 1: {
                pSSysContentCatBase.resetCatTag2();
                return true;
            }
            case 2: {
                pSSysContentCatBase.resetCodeName();
                return true;
            }
            case 3: {
                pSSysContentCatBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSysContentCatBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSysContentCatBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysContentCatBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSSysContentCatBase.resetPPSSysContentCatId();
                return true;
            }
            case 8: {
                pSSysContentCatBase.resetPPSSysContentCatName();
                return true;
            }
            case 9: {
                pSSysContentCatBase.resetPSModuleId();
                return true;
            }
            case 10: {
                pSSysContentCatBase.resetPSModuleName();
                return true;
            }
            case 11: {
                pSSysContentCatBase.resetPSSysContentCatId();
                return true;
            }
            case 12: {
                pSSysContentCatBase.resetPSSysContentCatName();
                return true;
            }
            case 13: {
                pSSysContentCatBase.resetPSSysDynaModelId();
                return true;
            }
            case 14: {
                pSSysContentCatBase.resetPSSysDynaModelName();
                return true;
            }
            case 15: {
                pSSysContentCatBase.resetPSSystemId();
                return true;
            }
            case 16: {
                pSSysContentCatBase.resetPSSystemName();
                return true;
            }
            case 17: {
                pSSysContentCatBase.resetSubject();
                return true;
            }
            case 18: {
                pSSysContentCatBase.resetTags();
                return true;
            }
            case 19: {
                pSSysContentCatBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSSysContentCatBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSSysContentCatBase.resetUserCat();
                return true;
            }
            case 22: {
                pSSysContentCatBase.resetUserTag();
                return true;
            }
            case 23: {
                pSSysContentCatBase.resetUserTag2();
                return true;
            }
            case 24: {
                pSSysContentCatBase.resetUserTag3();
                return true;
            }
            case 25: {
                pSSysContentCatBase.resetUserTag4();
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
    public PSSysContentCat getPPSSysContentCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysContentCat();
        }
        if (this.getPPSSysContentCatId() == null) {
            return null;
        }
        Integer n = this.objPPSSysContentCatLock;
        synchronized (n) {
            if (this.ppssyscontentcat != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysContentCatId(), (Object)this.ppssyscontentcat.getPSSysContentCatId()) != 0L) {
                this.ppssyscontentcat = null;
            }
            if (this.ppssyscontentcat == null) {
                PSSysContentCat pSSysContentCat = new PSSysContentCat();
                pSSysContentCat.setPSSysContentCatId(this.getPPSSysContentCatId());
                PSSysContentCatService pSSysContentCatService = (PSSysContentCatService)ServiceGlobal.getService(PSSysContentCatService.class, (SessionFactory)this.getSessionFactory());
                pSSysContentCatService.autoGet(pSSysContentCat);
                this.ppssyscontentcat = pSSysContentCat;
            }
            return this.ppssyscontentcat;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
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
    public ArrayList<PSSysContentCat> getPSSysContentCats() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysContentCats();
        }
        if (this.getPSSysContentCatId() == null) {
            return null;
        }
        PSSysContentCatService pSSysContentCatService = (PSSysContentCatService)ServiceGlobal.getService(PSSysContentCatService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysContentCatsLock;
        synchronized (n) {
            if (this.pssyscontentcats == null) {
                this.pssyscontentcats = pSSysContentCatService.selectByPPSSysContentCat(this);
            }
            return this.pssyscontentcats;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysContent> getPSSysContents() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysContents();
        }
        if (this.getPSSysContentCatId() == null) {
            return null;
        }
        PSSysContentService pSSysContentService = (PSSysContentService)ServiceGlobal.getService(PSSysContentService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysContentsLock;
        synchronized (n) {
            if (this.pssyscontents == null) {
                this.pssyscontents = pSSysContentService.selectByPSSysContentCat(this);
            }
            return this.pssyscontents;
        }
    }

    private PSSysContentCatBase getProxyEntity() {
        return this.proxyPSSysContentCatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysContentCatBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysContentCatBase) {
            this.proxyPSSysContentCatBase = (PSSysContentCatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysContentCatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CATTAG, 0);
        fieldIndexMap.put(FIELD_CATTAG2, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PPSSYSCONTENTCATID, 7);
        fieldIndexMap.put(FIELD_PPSSYSCONTENTCATNAME, 8);
        fieldIndexMap.put(FIELD_PSMODULEID, 9);
        fieldIndexMap.put(FIELD_PSMODULENAME, 10);
        fieldIndexMap.put(FIELD_PSSYSCONTENTCATID, 11);
        fieldIndexMap.put(FIELD_PSSYSCONTENTCATNAME, 12);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 13);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 15);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 16);
        fieldIndexMap.put(FIELD_SUBJECT, 17);
        fieldIndexMap.put(FIELD_TAGS, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
        fieldIndexMap.put(FIELD_USERTAG3, 24);
        fieldIndexMap.put(FIELD_USERTAG4, 25);
    }
}

