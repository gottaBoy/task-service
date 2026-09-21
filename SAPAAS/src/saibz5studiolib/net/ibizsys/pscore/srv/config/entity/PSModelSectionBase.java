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
import net.ibizsys.pscore.srv.config.entity.PSModelModule;
import net.ibizsys.pscore.srv.config.entity.PSModelSection;
import net.ibizsys.pscore.srv.config.service.PSModelModuleService;
import net.ibizsys.pscore.srv.config.service.PSModelSectionService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelSectionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelSectionBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSMODELSECTIONID = "PPSMODELSECTIONID";
    public static final String FIELD_PPSMODELSECTIONNAME = "PPSMODELSECTIONNAME";
    public static final String FIELD_PSMODELMODULEID = "PSMODELMODULEID";
    public static final String FIELD_PSMODELMODULENAME = "PSMODELMODULENAME";
    public static final String FIELD_PSMODELSECTIONID = "PSMODELSECTIONID";
    public static final String FIELD_PSMODELSECTIONNAME = "PSMODELSECTIONNAME";
    public static final String FIELD_SECTIONTYPE = "SECTIONTYPE";
    public static final String FIELD_SUBCAPTION = "SUBCAPTION";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PPSMODELSECTIONID = 5;
    private static final int INDEX_PPSMODELSECTIONNAME = 6;
    private static final int INDEX_PSMODELMODULEID = 7;
    private static final int INDEX_PSMODELMODULENAME = 8;
    private static final int INDEX_PSMODELSECTIONID = 9;
    private static final int INDEX_PSMODELSECTIONNAME = 10;
    private static final int INDEX_SECTIONTYPE = 11;
    private static final int INDEX_SUBCAPTION = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelSectionBase proxyPSModelSectionBase = null;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsmodelsectionidDirtyFlag = false;
    private boolean ppsmodelsectionnameDirtyFlag = false;
    private boolean psmodelmoduleidDirtyFlag = false;
    private boolean psmodelmodulenameDirtyFlag = false;
    private boolean psmodelsectionidDirtyFlag = false;
    private boolean psmodelsectionnameDirtyFlag = false;
    private boolean sectiontypeDirtyFlag = false;
    private boolean subcaptionDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
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
    @Column(name="ppsmodelsectionid")
    private String ppsmodelsectionid;
    @Column(name="ppsmodelsectionname")
    private String ppsmodelsectionname;
    @Column(name="psmodelmoduleid")
    private String psmodelmoduleid;
    @Column(name="psmodelmodulename")
    private String psmodelmodulename;
    @Column(name="psmodelsectionid")
    private String psmodelsectionid;
    @Column(name="psmodelsectionname")
    private String psmodelsectionname;
    @Column(name="sectiontype")
    private String sectiontype;
    @Column(name="subcaption")
    private String subcaption;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
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
    private Integer objPsmodelmoduleLock = new Integer(1);
    private PSModelModule psmodelmodule = null;
    private Integer objPpsmodelsectionLock = new Integer(1);
    private PSModelSection ppsmodelsection = null;

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

    public void setPPSModelSectionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSModelSectionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmodelsectionid = string;
        this.ppsmodelsectionidDirtyFlag = true;
    }

    public String getPPSModelSectionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelSectionId();
        }
        return this.ppsmodelsectionid;
    }

    public boolean isPPSModelSectionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSModelSectionIdDirty();
        }
        return this.ppsmodelsectionidDirtyFlag;
    }

    public void resetPPSModelSectionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSModelSectionId();
            return;
        }
        this.ppsmodelsectionidDirtyFlag = false;
        this.ppsmodelsectionid = null;
    }

    public void setPPSModelSectionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSModelSectionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmodelsectionname = string;
        this.ppsmodelsectionnameDirtyFlag = true;
    }

    public String getPPSModelSectionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelSectionName();
        }
        return this.ppsmodelsectionname;
    }

    public boolean isPPSModelSectionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSModelSectionNameDirty();
        }
        return this.ppsmodelsectionnameDirtyFlag;
    }

    public void resetPPSModelSectionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSModelSectionName();
            return;
        }
        this.ppsmodelsectionnameDirtyFlag = false;
        this.ppsmodelsectionname = null;
    }

    public void setPSModelModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelmoduleid = string;
        this.psmodelmoduleidDirtyFlag = true;
    }

    public String getPSModelModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelModuleId();
        }
        return this.psmodelmoduleid;
    }

    public boolean isPSModelModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelModuleIdDirty();
        }
        return this.psmodelmoduleidDirtyFlag;
    }

    public void resetPSModelModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelModuleId();
            return;
        }
        this.psmodelmoduleidDirtyFlag = false;
        this.psmodelmoduleid = null;
    }

    public void setPSModelModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelmodulename = string;
        this.psmodelmodulenameDirtyFlag = true;
    }

    public String getPSModelModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelModuleName();
        }
        return this.psmodelmodulename;
    }

    public boolean isPSModelModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelModuleNameDirty();
        }
        return this.psmodelmodulenameDirtyFlag;
    }

    public void resetPSModelModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelModuleName();
            return;
        }
        this.psmodelmodulenameDirtyFlag = false;
        this.psmodelmodulename = null;
    }

    public void setPSModelSectionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelSectionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelsectionid = string;
        this.psmodelsectionidDirtyFlag = true;
    }

    public String getPSModelSectionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelSectionId();
        }
        return this.psmodelsectionid;
    }

    public boolean isPSModelSectionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelSectionIdDirty();
        }
        return this.psmodelsectionidDirtyFlag;
    }

    public void resetPSModelSectionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelSectionId();
            return;
        }
        this.psmodelsectionidDirtyFlag = false;
        this.psmodelsectionid = null;
    }

    public void setPSModelSectionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelSectionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelsectionname = string;
        this.psmodelsectionnameDirtyFlag = true;
    }

    public String getPSModelSectionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelSectionName();
        }
        return this.psmodelsectionname;
    }

    public boolean isPSModelSectionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelSectionNameDirty();
        }
        return this.psmodelsectionnameDirtyFlag;
    }

    public void resetPSModelSectionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelSectionName();
            return;
        }
        this.psmodelsectionnameDirtyFlag = false;
        this.psmodelsectionname = null;
    }

    public void setSectionType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSectionType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sectiontype = string;
        this.sectiontypeDirtyFlag = true;
    }

    public String getSectionType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSectionType();
        }
        return this.sectiontype;
    }

    public boolean isSectionTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSectionTypeDirty();
        }
        return this.sectiontypeDirtyFlag;
    }

    public void resetSectionType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSectionType();
            return;
        }
        this.sectiontypeDirtyFlag = false;
        this.sectiontype = null;
    }

    public void setSubCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subcaption = string;
        this.subcaptionDirtyFlag = true;
    }

    public String getSubCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubCaption();
        }
        return this.subcaption;
    }

    public boolean isSubCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubCaptionDirty();
        }
        return this.subcaptionDirtyFlag;
    }

    public void resetSubCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubCaption();
            return;
        }
        this.subcaptionDirtyFlag = false;
        this.subcaption = null;
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
        PSModelSectionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelSectionBase pSModelSectionBase) {
        pSModelSectionBase.resetContent();
        pSModelSectionBase.resetCreateDate();
        pSModelSectionBase.resetCreateMan();
        pSModelSectionBase.resetMemo();
        pSModelSectionBase.resetOrderValue();
        pSModelSectionBase.resetPPSModelSectionId();
        pSModelSectionBase.resetPPSModelSectionName();
        pSModelSectionBase.resetPSModelModuleId();
        pSModelSectionBase.resetPSModelModuleName();
        pSModelSectionBase.resetPSModelSectionId();
        pSModelSectionBase.resetPSModelSectionName();
        pSModelSectionBase.resetSectionType();
        pSModelSectionBase.resetSubCaption();
        pSModelSectionBase.resetUpdateDate();
        pSModelSectionBase.resetUpdateMan();
        pSModelSectionBase.resetUserTag();
        pSModelSectionBase.resetUserTag2();
        pSModelSectionBase.resetUserTag3();
        pSModelSectionBase.resetUserTag4();
        pSModelSectionBase.resetValidFlag();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSModelSectionIdDirty()) {
            hashMap.put(FIELD_PPSMODELSECTIONID, this.getPPSModelSectionId());
        }
        if (!bl || this.isPPSModelSectionNameDirty()) {
            hashMap.put(FIELD_PPSMODELSECTIONNAME, this.getPPSModelSectionName());
        }
        if (!bl || this.isPSModelModuleIdDirty()) {
            hashMap.put(FIELD_PSMODELMODULEID, this.getPSModelModuleId());
        }
        if (!bl || this.isPSModelModuleNameDirty()) {
            hashMap.put(FIELD_PSMODELMODULENAME, this.getPSModelModuleName());
        }
        if (!bl || this.isPSModelSectionIdDirty()) {
            hashMap.put(FIELD_PSMODELSECTIONID, this.getPSModelSectionId());
        }
        if (!bl || this.isPSModelSectionNameDirty()) {
            hashMap.put(FIELD_PSMODELSECTIONNAME, this.getPSModelSectionName());
        }
        if (!bl || this.isSectionTypeDirty()) {
            hashMap.put(FIELD_SECTIONTYPE, this.getSectionType());
        }
        if (!bl || this.isSubCaptionDirty()) {
            hashMap.put(FIELD_SUBCAPTION, this.getSubCaption());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSModelSectionBase.get(this, n);
    }

    private static Object get(PSModelSectionBase pSModelSectionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelSectionBase.getContent();
            }
            case 1: {
                return pSModelSectionBase.getCreateDate();
            }
            case 2: {
                return pSModelSectionBase.getCreateMan();
            }
            case 3: {
                return pSModelSectionBase.getMemo();
            }
            case 4: {
                return pSModelSectionBase.getOrderValue();
            }
            case 5: {
                return pSModelSectionBase.getPPSModelSectionId();
            }
            case 6: {
                return pSModelSectionBase.getPPSModelSectionName();
            }
            case 7: {
                return pSModelSectionBase.getPSModelModuleId();
            }
            case 8: {
                return pSModelSectionBase.getPSModelModuleName();
            }
            case 9: {
                return pSModelSectionBase.getPSModelSectionId();
            }
            case 10: {
                return pSModelSectionBase.getPSModelSectionName();
            }
            case 11: {
                return pSModelSectionBase.getSectionType();
            }
            case 12: {
                return pSModelSectionBase.getSubCaption();
            }
            case 13: {
                return pSModelSectionBase.getUpdateDate();
            }
            case 14: {
                return pSModelSectionBase.getUpdateMan();
            }
            case 15: {
                return pSModelSectionBase.getUserTag();
            }
            case 16: {
                return pSModelSectionBase.getUserTag2();
            }
            case 17: {
                return pSModelSectionBase.getUserTag3();
            }
            case 18: {
                return pSModelSectionBase.getUserTag4();
            }
            case 19: {
                return pSModelSectionBase.getValidFlag();
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
        PSModelSectionBase.set(this, n, object);
    }

    private static void set(PSModelSectionBase pSModelSectionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelSectionBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModelSectionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSModelSectionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelSectionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelSectionBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSModelSectionBase.setPPSModelSectionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelSectionBase.setPPSModelSectionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelSectionBase.setPSModelModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelSectionBase.setPSModelModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelSectionBase.setPSModelSectionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelSectionBase.setPSModelSectionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelSectionBase.setSectionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelSectionBase.setSubCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelSectionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSModelSectionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSModelSectionBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSModelSectionBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSModelSectionBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSModelSectionBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSModelSectionBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSModelSectionBase.isNull(this, n);
    }

    private static boolean isNull(PSModelSectionBase pSModelSectionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelSectionBase.getContent() == null;
            }
            case 1: {
                return pSModelSectionBase.getCreateDate() == null;
            }
            case 2: {
                return pSModelSectionBase.getCreateMan() == null;
            }
            case 3: {
                return pSModelSectionBase.getMemo() == null;
            }
            case 4: {
                return pSModelSectionBase.getOrderValue() == null;
            }
            case 5: {
                return pSModelSectionBase.getPPSModelSectionId() == null;
            }
            case 6: {
                return pSModelSectionBase.getPPSModelSectionName() == null;
            }
            case 7: {
                return pSModelSectionBase.getPSModelModuleId() == null;
            }
            case 8: {
                return pSModelSectionBase.getPSModelModuleName() == null;
            }
            case 9: {
                return pSModelSectionBase.getPSModelSectionId() == null;
            }
            case 10: {
                return pSModelSectionBase.getPSModelSectionName() == null;
            }
            case 11: {
                return pSModelSectionBase.getSectionType() == null;
            }
            case 12: {
                return pSModelSectionBase.getSubCaption() == null;
            }
            case 13: {
                return pSModelSectionBase.getUpdateDate() == null;
            }
            case 14: {
                return pSModelSectionBase.getUpdateMan() == null;
            }
            case 15: {
                return pSModelSectionBase.getUserTag() == null;
            }
            case 16: {
                return pSModelSectionBase.getUserTag2() == null;
            }
            case 17: {
                return pSModelSectionBase.getUserTag3() == null;
            }
            case 18: {
                return pSModelSectionBase.getUserTag4() == null;
            }
            case 19: {
                return pSModelSectionBase.getValidFlag() == null;
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
        return PSModelSectionBase.contains(this, n);
    }

    private static boolean contains(PSModelSectionBase pSModelSectionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelSectionBase.isContentDirty();
            }
            case 1: {
                return pSModelSectionBase.isCreateDateDirty();
            }
            case 2: {
                return pSModelSectionBase.isCreateManDirty();
            }
            case 3: {
                return pSModelSectionBase.isMemoDirty();
            }
            case 4: {
                return pSModelSectionBase.isOrderValueDirty();
            }
            case 5: {
                return pSModelSectionBase.isPPSModelSectionIdDirty();
            }
            case 6: {
                return pSModelSectionBase.isPPSModelSectionNameDirty();
            }
            case 7: {
                return pSModelSectionBase.isPSModelModuleIdDirty();
            }
            case 8: {
                return pSModelSectionBase.isPSModelModuleNameDirty();
            }
            case 9: {
                return pSModelSectionBase.isPSModelSectionIdDirty();
            }
            case 10: {
                return pSModelSectionBase.isPSModelSectionNameDirty();
            }
            case 11: {
                return pSModelSectionBase.isSectionTypeDirty();
            }
            case 12: {
                return pSModelSectionBase.isSubCaptionDirty();
            }
            case 13: {
                return pSModelSectionBase.isUpdateDateDirty();
            }
            case 14: {
                return pSModelSectionBase.isUpdateManDirty();
            }
            case 15: {
                return pSModelSectionBase.isUserTagDirty();
            }
            case 16: {
                return pSModelSectionBase.isUserTag2Dirty();
            }
            case 17: {
                return pSModelSectionBase.isUserTag3Dirty();
            }
            case 18: {
                return pSModelSectionBase.isUserTag4Dirty();
            }
            case 19: {
                return pSModelSectionBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelSectionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelSectionBase pSModelSectionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelSectionBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getContent()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getPPSModelSectionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmodelsectionid", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getPPSModelSectionId()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getPPSModelSectionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmodelsectionname", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getPPSModelSectionName()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getPSModelModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelmoduleid", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getPSModelModuleId()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getPSModelModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelmodulename", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getPSModelModuleName()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getPSModelSectionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelsectionid", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getPSModelSectionId()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getPSModelSectionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelsectionname", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getPSModelSectionName()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getSectionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sectiontype", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getSectionType()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getSubCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subcaption", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getSubCaption()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getUserTag()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSModelSectionBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelSectionBase.getJSONValue((Object)pSModelSectionBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelSectionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelSectionBase pSModelSectionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelSectionBase.getContent() != null) {
            object = pSModelSectionBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getCreateDate() != null) {
            object = pSModelSectionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelSectionBase.getCreateMan() != null) {
            object = pSModelSectionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getMemo() != null) {
            object = pSModelSectionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getOrderValue() != null) {
            object = pSModelSectionBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelSectionBase.getPPSModelSectionId() != null) {
            object = pSModelSectionBase.getPPSModelSectionId();
            xmlNode.setAttribute(FIELD_PPSMODELSECTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getPPSModelSectionName() != null) {
            object = pSModelSectionBase.getPPSModelSectionName();
            xmlNode.setAttribute(FIELD_PPSMODELSECTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getPSModelModuleId() != null) {
            object = pSModelSectionBase.getPSModelModuleId();
            xmlNode.setAttribute(FIELD_PSMODELMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getPSModelModuleName() != null) {
            object = pSModelSectionBase.getPSModelModuleName();
            xmlNode.setAttribute(FIELD_PSMODELMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getPSModelSectionId() != null) {
            object = pSModelSectionBase.getPSModelSectionId();
            xmlNode.setAttribute(FIELD_PSMODELSECTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getPSModelSectionName() != null) {
            object = pSModelSectionBase.getPSModelSectionName();
            xmlNode.setAttribute(FIELD_PSMODELSECTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getSectionType() != null) {
            object = pSModelSectionBase.getSectionType();
            xmlNode.setAttribute(FIELD_SECTIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getSubCaption() != null) {
            object = pSModelSectionBase.getSubCaption();
            xmlNode.setAttribute(FIELD_SUBCAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getUpdateDate() != null) {
            object = pSModelSectionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelSectionBase.getUpdateMan() != null) {
            object = pSModelSectionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getUserTag() != null) {
            object = pSModelSectionBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getUserTag2() != null) {
            object = pSModelSectionBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getUserTag3() != null) {
            object = pSModelSectionBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getUserTag4() != null) {
            object = pSModelSectionBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSModelSectionBase.getValidFlag() != null) {
            object = pSModelSectionBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelSectionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelSectionBase pSModelSectionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelSectionBase.isContentDirty() && (bl || pSModelSectionBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSModelSectionBase.getContent());
        }
        if (pSModelSectionBase.isCreateDateDirty() && (bl || pSModelSectionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelSectionBase.getCreateDate());
        }
        if (pSModelSectionBase.isCreateManDirty() && (bl || pSModelSectionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelSectionBase.getCreateMan());
        }
        if (pSModelSectionBase.isMemoDirty() && (bl || pSModelSectionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelSectionBase.getMemo());
        }
        if (pSModelSectionBase.isOrderValueDirty() && (bl || pSModelSectionBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModelSectionBase.getOrderValue());
        }
        if (pSModelSectionBase.isPPSModelSectionIdDirty() && (bl || pSModelSectionBase.getPPSModelSectionId() != null)) {
            iDataObject.set(FIELD_PPSMODELSECTIONID, (Object)pSModelSectionBase.getPPSModelSectionId());
        }
        if (pSModelSectionBase.isPPSModelSectionNameDirty() && (bl || pSModelSectionBase.getPPSModelSectionName() != null)) {
            iDataObject.set(FIELD_PPSMODELSECTIONNAME, (Object)pSModelSectionBase.getPPSModelSectionName());
        }
        if (pSModelSectionBase.isPSModelModuleIdDirty() && (bl || pSModelSectionBase.getPSModelModuleId() != null)) {
            iDataObject.set(FIELD_PSMODELMODULEID, (Object)pSModelSectionBase.getPSModelModuleId());
        }
        if (pSModelSectionBase.isPSModelModuleNameDirty() && (bl || pSModelSectionBase.getPSModelModuleName() != null)) {
            iDataObject.set(FIELD_PSMODELMODULENAME, (Object)pSModelSectionBase.getPSModelModuleName());
        }
        if (pSModelSectionBase.isPSModelSectionIdDirty() && (bl || pSModelSectionBase.getPSModelSectionId() != null)) {
            iDataObject.set(FIELD_PSMODELSECTIONID, (Object)pSModelSectionBase.getPSModelSectionId());
        }
        if (pSModelSectionBase.isPSModelSectionNameDirty() && (bl || pSModelSectionBase.getPSModelSectionName() != null)) {
            iDataObject.set(FIELD_PSMODELSECTIONNAME, (Object)pSModelSectionBase.getPSModelSectionName());
        }
        if (pSModelSectionBase.isSectionTypeDirty() && (bl || pSModelSectionBase.getSectionType() != null)) {
            iDataObject.set(FIELD_SECTIONTYPE, (Object)pSModelSectionBase.getSectionType());
        }
        if (pSModelSectionBase.isSubCaptionDirty() && (bl || pSModelSectionBase.getSubCaption() != null)) {
            iDataObject.set(FIELD_SUBCAPTION, (Object)pSModelSectionBase.getSubCaption());
        }
        if (pSModelSectionBase.isUpdateDateDirty() && (bl || pSModelSectionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelSectionBase.getUpdateDate());
        }
        if (pSModelSectionBase.isUpdateManDirty() && (bl || pSModelSectionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelSectionBase.getUpdateMan());
        }
        if (pSModelSectionBase.isUserTagDirty() && (bl || pSModelSectionBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSModelSectionBase.getUserTag());
        }
        if (pSModelSectionBase.isUserTag2Dirty() && (bl || pSModelSectionBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSModelSectionBase.getUserTag2());
        }
        if (pSModelSectionBase.isUserTag3Dirty() && (bl || pSModelSectionBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSModelSectionBase.getUserTag3());
        }
        if (pSModelSectionBase.isUserTag4Dirty() && (bl || pSModelSectionBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSModelSectionBase.getUserTag4());
        }
        if (pSModelSectionBase.isValidFlagDirty() && (bl || pSModelSectionBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelSectionBase.getValidFlag());
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
        return PSModelSectionBase.remove(this, n);
    }

    private static boolean remove(PSModelSectionBase pSModelSectionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelSectionBase.resetContent();
                return true;
            }
            case 1: {
                pSModelSectionBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSModelSectionBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSModelSectionBase.resetMemo();
                return true;
            }
            case 4: {
                pSModelSectionBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSModelSectionBase.resetPPSModelSectionId();
                return true;
            }
            case 6: {
                pSModelSectionBase.resetPPSModelSectionName();
                return true;
            }
            case 7: {
                pSModelSectionBase.resetPSModelModuleId();
                return true;
            }
            case 8: {
                pSModelSectionBase.resetPSModelModuleName();
                return true;
            }
            case 9: {
                pSModelSectionBase.resetPSModelSectionId();
                return true;
            }
            case 10: {
                pSModelSectionBase.resetPSModelSectionName();
                return true;
            }
            case 11: {
                pSModelSectionBase.resetSectionType();
                return true;
            }
            case 12: {
                pSModelSectionBase.resetSubCaption();
                return true;
            }
            case 13: {
                pSModelSectionBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSModelSectionBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSModelSectionBase.resetUserTag();
                return true;
            }
            case 16: {
                pSModelSectionBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSModelSectionBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSModelSectionBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSModelSectionBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelModule getPsmodelmodule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsmodelmodule();
        }
        if (this.getPSModelModuleId() == null) {
            return null;
        }
        Integer n = this.objPsmodelmoduleLock;
        synchronized (n) {
            if (this.psmodelmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelModuleId(), (Object)this.psmodelmodule.getPSModelModuleId()) != 0L) {
                this.psmodelmodule = null;
            }
            if (this.psmodelmodule == null) {
                PSModelModule pSModelModule = new PSModelModule();
                pSModelModule.setPSModelModuleId(this.getPSModelModuleId());
                PSModelModuleService pSModelModuleService = (PSModelModuleService)ServiceGlobal.getService(PSModelModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModelModuleService.autoGet((IEntity)pSModelModule);
                this.psmodelmodule = pSModelModule;
            }
            return this.psmodelmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelSection getPpsmodelsection() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPpsmodelsection();
        }
        if (this.getPPSModelSectionId() == null) {
            return null;
        }
        Integer n = this.objPpsmodelsectionLock;
        synchronized (n) {
            if (this.ppsmodelsection != null && DataTypeHelper.compare((int)25, (Object)this.getPPSModelSectionId(), (Object)this.ppsmodelsection.getPSModelSectionId()) != 0L) {
                this.ppsmodelsection = null;
            }
            if (this.ppsmodelsection == null) {
                PSModelSection pSModelSection = new PSModelSection();
                pSModelSection.setPSModelSectionId(this.getPPSModelSectionId());
                PSModelSectionService pSModelSectionService = (PSModelSectionService)ServiceGlobal.getService(PSModelSectionService.class, (SessionFactory)this.getSessionFactory());
                pSModelSectionService.autoGet((IEntity)pSModelSection);
                this.ppsmodelsection = pSModelSection;
            }
            return this.ppsmodelsection;
        }
    }

    private PSModelSectionBase getProxyEntity() {
        return this.proxyPSModelSectionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelSectionBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelSectionBase) {
            this.proxyPSModelSectionBase = (PSModelSectionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelSectionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PPSMODELSECTIONID, 5);
        fieldIndexMap.put(FIELD_PPSMODELSECTIONNAME, 6);
        fieldIndexMap.put(FIELD_PSMODELMODULEID, 7);
        fieldIndexMap.put(FIELD_PSMODELMODULENAME, 8);
        fieldIndexMap.put(FIELD_PSMODELSECTIONID, 9);
        fieldIndexMap.put(FIELD_PSMODELSECTIONNAME, 10);
        fieldIndexMap.put(FIELD_SECTIONTYPE, 11);
        fieldIndexMap.put(FIELD_SUBCAPTION, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

