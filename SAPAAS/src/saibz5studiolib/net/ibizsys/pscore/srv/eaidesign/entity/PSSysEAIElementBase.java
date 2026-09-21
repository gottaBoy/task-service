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
package net.ibizsys.pscore.srv.eaidesign.entity;

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
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementAttr;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementRE;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIScheme;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementAttrService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementREService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAIElementBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysEAIElementBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EAIELEMENTTAG = "EAIELEMENTTAG";
    public static final String FIELD_EAIELEMENTTAG2 = "EAIELEMENTTAG2";
    public static final String FIELD_EAIELEMENTTYPE = "EAIELEMENTTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERMODE = "ORDERMODE";
    public static final String FIELD_PSSYSEAIELEMENTID = "PSSYSEAIELEMENTID";
    public static final String FIELD_PSSYSEAIELEMENTNAME = "PSSYSEAIELEMENTNAME";
    public static final String FIELD_PSSYSEAISCHEMEID = "PSSYSEAISCHEMEID";
    public static final String FIELD_PSSYSEAISCHEMENAME = "PSSYSEAISCHEMENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_EAIELEMENTTAG = 3;
    private static final int INDEX_EAIELEMENTTAG2 = 4;
    private static final int INDEX_EAIELEMENTTYPE = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_ORDERMODE = 7;
    private static final int INDEX_PSSYSEAIELEMENTID = 8;
    private static final int INDEX_PSSYSEAIELEMENTNAME = 9;
    private static final int INDEX_PSSYSEAISCHEMEID = 10;
    private static final int INDEX_PSSYSEAISCHEMENAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysEAIElementBase proxyPSSysEAIElementBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean eaielementtagDirtyFlag = false;
    private boolean eaielementtag2DirtyFlag = false;
    private boolean eaielementtypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordermodeDirtyFlag = false;
    private boolean pssyseaielementidDirtyFlag = false;
    private boolean pssyseaielementnameDirtyFlag = false;
    private boolean pssyseaischemeidDirtyFlag = false;
    private boolean pssyseaischemenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="eaielementtag")
    private String eaielementtag;
    @Column(name="eaielementtag2")
    private String eaielementtag2;
    @Column(name="eaielementtype")
    private String eaielementtype;
    @Column(name="memo")
    private String memo;
    @Column(name="ordermode")
    private String ordermode;
    @Column(name="pssyseaielementid")
    private String pssyseaielementid;
    @Column(name="pssyseaielementname")
    private String pssyseaielementname;
    @Column(name="pssyseaischemeid")
    private String pssyseaischemeid;
    @Column(name="pssyseaischemename")
    private String pssyseaischemename;
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
    private Integer objPSSysEAISchemeLock = new Integer(1);
    private PSSysEAIScheme pssyseaischeme = null;
    private Integer objPSSysEAIElementAttrsLock = new Integer(1);
    private ArrayList<PSSysEAIElementAttr> pssyseaielementattrs = null;
    private Integer objPSSysEAIElementREsLock = new Integer(1);
    private ArrayList<PSSysEAIElementRE> pssyseaielementres = null;

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

    public void setEAIElementTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAIElementTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaielementtag = string;
        this.eaielementtagDirtyFlag = true;
    }

    public String getEAIElementTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAIElementTag();
        }
        return this.eaielementtag;
    }

    public boolean isEAIElementTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAIElementTagDirty();
        }
        return this.eaielementtagDirtyFlag;
    }

    public void resetEAIElementTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAIElementTag();
            return;
        }
        this.eaielementtagDirtyFlag = false;
        this.eaielementtag = null;
    }

    public void setEAIElementTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAIElementTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaielementtag2 = string;
        this.eaielementtag2DirtyFlag = true;
    }

    public String getEAIElementTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAIElementTag2();
        }
        return this.eaielementtag2;
    }

    public boolean isEAIElementTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAIElementTag2Dirty();
        }
        return this.eaielementtag2DirtyFlag;
    }

    public void resetEAIElementTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAIElementTag2();
            return;
        }
        this.eaielementtag2DirtyFlag = false;
        this.eaielementtag2 = null;
    }

    public void setEAIElementType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAIElementType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaielementtype = string;
        this.eaielementtypeDirtyFlag = true;
    }

    public String getEAIElementType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAIElementType();
        }
        return this.eaielementtype;
    }

    public boolean isEAIElementTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAIElementTypeDirty();
        }
        return this.eaielementtypeDirtyFlag;
    }

    public void resetEAIElementType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAIElementType();
            return;
        }
        this.eaielementtypeDirtyFlag = false;
        this.eaielementtype = null;
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

    public void setOrderMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ordermode = string;
        this.ordermodeDirtyFlag = true;
    }

    public String getOrderMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderMode();
        }
        return this.ordermode;
    }

    public boolean isOrderModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderModeDirty();
        }
        return this.ordermodeDirtyFlag;
    }

    public void resetOrderMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderMode();
            return;
        }
        this.ordermodeDirtyFlag = false;
        this.ordermode = null;
    }

    public void setPSSysEAIElementId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementid = string;
        this.pssyseaielementidDirtyFlag = true;
    }

    public String getPSSysEAIElementId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementId();
        }
        return this.pssyseaielementid;
    }

    public boolean isPSSysEAIElementIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementIdDirty();
        }
        return this.pssyseaielementidDirtyFlag;
    }

    public void resetPSSysEAIElementId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementId();
            return;
        }
        this.pssyseaielementidDirtyFlag = false;
        this.pssyseaielementid = null;
    }

    public void setPSSysEAIElementName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementname = string;
        this.pssyseaielementnameDirtyFlag = true;
    }

    public String getPSSysEAIElementName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementName();
        }
        return this.pssyseaielementname;
    }

    public boolean isPSSysEAIElementNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementNameDirty();
        }
        return this.pssyseaielementnameDirtyFlag;
    }

    public void resetPSSysEAIElementName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementName();
            return;
        }
        this.pssyseaielementnameDirtyFlag = false;
        this.pssyseaielementname = null;
    }

    public void setPSSysEAISchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAISchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaischemeid = string;
        this.pssyseaischemeidDirtyFlag = true;
    }

    public String getPSSysEAISchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAISchemeId();
        }
        return this.pssyseaischemeid;
    }

    public boolean isPSSysEAISchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAISchemeIdDirty();
        }
        return this.pssyseaischemeidDirtyFlag;
    }

    public void resetPSSysEAISchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAISchemeId();
            return;
        }
        this.pssyseaischemeidDirtyFlag = false;
        this.pssyseaischemeid = null;
    }

    public void setPSSysEAISchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAISchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaischemename = string;
        this.pssyseaischemenameDirtyFlag = true;
    }

    public String getPSSysEAISchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAISchemeName();
        }
        return this.pssyseaischemename;
    }

    public boolean isPSSysEAISchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAISchemeNameDirty();
        }
        return this.pssyseaischemenameDirtyFlag;
    }

    public void resetPSSysEAISchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAISchemeName();
            return;
        }
        this.pssyseaischemenameDirtyFlag = false;
        this.pssyseaischemename = null;
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
        PSSysEAIElementBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysEAIElementBase pSSysEAIElementBase) {
        pSSysEAIElementBase.resetCodeName();
        pSSysEAIElementBase.resetCreateDate();
        pSSysEAIElementBase.resetCreateMan();
        pSSysEAIElementBase.resetEAIElementTag();
        pSSysEAIElementBase.resetEAIElementTag2();
        pSSysEAIElementBase.resetEAIElementType();
        pSSysEAIElementBase.resetMemo();
        pSSysEAIElementBase.resetOrderMode();
        pSSysEAIElementBase.resetPSSysEAIElementId();
        pSSysEAIElementBase.resetPSSysEAIElementName();
        pSSysEAIElementBase.resetPSSysEAISchemeId();
        pSSysEAIElementBase.resetPSSysEAISchemeName();
        pSSysEAIElementBase.resetUpdateDate();
        pSSysEAIElementBase.resetUpdateMan();
        pSSysEAIElementBase.resetUserCat();
        pSSysEAIElementBase.resetUserTag();
        pSSysEAIElementBase.resetUserTag2();
        pSSysEAIElementBase.resetUserTag3();
        pSSysEAIElementBase.resetUserTag4();
        pSSysEAIElementBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEAIElementTagDirty()) {
            hashMap.put(FIELD_EAIELEMENTTAG, this.getEAIElementTag());
        }
        if (!bl || this.isEAIElementTag2Dirty()) {
            hashMap.put(FIELD_EAIELEMENTTAG2, this.getEAIElementTag2());
        }
        if (!bl || this.isEAIElementTypeDirty()) {
            hashMap.put(FIELD_EAIELEMENTTYPE, this.getEAIElementType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderModeDirty()) {
            hashMap.put(FIELD_ORDERMODE, this.getOrderMode());
        }
        if (!bl || this.isPSSysEAIElementIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTID, this.getPSSysEAIElementId());
        }
        if (!bl || this.isPSSysEAIElementNameDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTNAME, this.getPSSysEAIElementName());
        }
        if (!bl || this.isPSSysEAISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSEAISCHEMEID, this.getPSSysEAISchemeId());
        }
        if (!bl || this.isPSSysEAISchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSEAISCHEMENAME, this.getPSSysEAISchemeName());
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
        return PSSysEAIElementBase.get(this, n);
    }

    private static Object get(PSSysEAIElementBase pSSysEAIElementBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIElementBase.getCodeName();
            }
            case 1: {
                return pSSysEAIElementBase.getCreateDate();
            }
            case 2: {
                return pSSysEAIElementBase.getCreateMan();
            }
            case 3: {
                return pSSysEAIElementBase.getEAIElementTag();
            }
            case 4: {
                return pSSysEAIElementBase.getEAIElementTag2();
            }
            case 5: {
                return pSSysEAIElementBase.getEAIElementType();
            }
            case 6: {
                return pSSysEAIElementBase.getMemo();
            }
            case 7: {
                return pSSysEAIElementBase.getOrderMode();
            }
            case 8: {
                return pSSysEAIElementBase.getPSSysEAIElementId();
            }
            case 9: {
                return pSSysEAIElementBase.getPSSysEAIElementName();
            }
            case 10: {
                return pSSysEAIElementBase.getPSSysEAISchemeId();
            }
            case 11: {
                return pSSysEAIElementBase.getPSSysEAISchemeName();
            }
            case 12: {
                return pSSysEAIElementBase.getUpdateDate();
            }
            case 13: {
                return pSSysEAIElementBase.getUpdateMan();
            }
            case 14: {
                return pSSysEAIElementBase.getUserCat();
            }
            case 15: {
                return pSSysEAIElementBase.getUserTag();
            }
            case 16: {
                return pSSysEAIElementBase.getUserTag2();
            }
            case 17: {
                return pSSysEAIElementBase.getUserTag3();
            }
            case 18: {
                return pSSysEAIElementBase.getUserTag4();
            }
            case 19: {
                return pSSysEAIElementBase.getValidFlag();
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
        PSSysEAIElementBase.set(this, n, object);
    }

    private static void set(PSSysEAIElementBase pSSysEAIElementBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIElementBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysEAIElementBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysEAIElementBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysEAIElementBase.setEAIElementTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysEAIElementBase.setEAIElementTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysEAIElementBase.setEAIElementType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysEAIElementBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysEAIElementBase.setOrderMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysEAIElementBase.setPSSysEAIElementId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysEAIElementBase.setPSSysEAIElementName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysEAIElementBase.setPSSysEAISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysEAIElementBase.setPSSysEAISchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysEAIElementBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSysEAIElementBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysEAIElementBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysEAIElementBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysEAIElementBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysEAIElementBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysEAIElementBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysEAIElementBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysEAIElementBase.isNull(this, n);
    }

    private static boolean isNull(PSSysEAIElementBase pSSysEAIElementBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIElementBase.getCodeName() == null;
            }
            case 1: {
                return pSSysEAIElementBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysEAIElementBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysEAIElementBase.getEAIElementTag() == null;
            }
            case 4: {
                return pSSysEAIElementBase.getEAIElementTag2() == null;
            }
            case 5: {
                return pSSysEAIElementBase.getEAIElementType() == null;
            }
            case 6: {
                return pSSysEAIElementBase.getMemo() == null;
            }
            case 7: {
                return pSSysEAIElementBase.getOrderMode() == null;
            }
            case 8: {
                return pSSysEAIElementBase.getPSSysEAIElementId() == null;
            }
            case 9: {
                return pSSysEAIElementBase.getPSSysEAIElementName() == null;
            }
            case 10: {
                return pSSysEAIElementBase.getPSSysEAISchemeId() == null;
            }
            case 11: {
                return pSSysEAIElementBase.getPSSysEAISchemeName() == null;
            }
            case 12: {
                return pSSysEAIElementBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSysEAIElementBase.getUpdateMan() == null;
            }
            case 14: {
                return pSSysEAIElementBase.getUserCat() == null;
            }
            case 15: {
                return pSSysEAIElementBase.getUserTag() == null;
            }
            case 16: {
                return pSSysEAIElementBase.getUserTag2() == null;
            }
            case 17: {
                return pSSysEAIElementBase.getUserTag3() == null;
            }
            case 18: {
                return pSSysEAIElementBase.getUserTag4() == null;
            }
            case 19: {
                return pSSysEAIElementBase.getValidFlag() == null;
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
        return PSSysEAIElementBase.contains(this, n);
    }

    private static boolean contains(PSSysEAIElementBase pSSysEAIElementBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIElementBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysEAIElementBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysEAIElementBase.isCreateManDirty();
            }
            case 3: {
                return pSSysEAIElementBase.isEAIElementTagDirty();
            }
            case 4: {
                return pSSysEAIElementBase.isEAIElementTag2Dirty();
            }
            case 5: {
                return pSSysEAIElementBase.isEAIElementTypeDirty();
            }
            case 6: {
                return pSSysEAIElementBase.isMemoDirty();
            }
            case 7: {
                return pSSysEAIElementBase.isOrderModeDirty();
            }
            case 8: {
                return pSSysEAIElementBase.isPSSysEAIElementIdDirty();
            }
            case 9: {
                return pSSysEAIElementBase.isPSSysEAIElementNameDirty();
            }
            case 10: {
                return pSSysEAIElementBase.isPSSysEAISchemeIdDirty();
            }
            case 11: {
                return pSSysEAIElementBase.isPSSysEAISchemeNameDirty();
            }
            case 12: {
                return pSSysEAIElementBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSysEAIElementBase.isUpdateManDirty();
            }
            case 14: {
                return pSSysEAIElementBase.isUserCatDirty();
            }
            case 15: {
                return pSSysEAIElementBase.isUserTagDirty();
            }
            case 16: {
                return pSSysEAIElementBase.isUserTag2Dirty();
            }
            case 17: {
                return pSSysEAIElementBase.isUserTag3Dirty();
            }
            case 18: {
                return pSSysEAIElementBase.isUserTag4Dirty();
            }
            case 19: {
                return pSSysEAIElementBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysEAIElementBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysEAIElementBase pSSysEAIElementBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysEAIElementBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getEAIElementTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaielementtag", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getEAIElementTag()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getEAIElementTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaielementtag2", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getEAIElementTag2()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getEAIElementType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaielementtype", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getEAIElementType()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getOrderMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordermode", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getOrderMode()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getPSSysEAIElementId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementid", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getPSSysEAIElementId()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getPSSysEAIElementName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementname", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getPSSysEAIElementName()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getPSSysEAISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaischemeid", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getPSSysEAISchemeId()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getPSSysEAISchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaischemename", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getPSSysEAISchemeName()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysEAIElementBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysEAIElementBase.getJSONValue((Object)pSSysEAIElementBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysEAIElementBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysEAIElementBase pSSysEAIElementBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysEAIElementBase.getCodeName() != null) {
            object = pSSysEAIElementBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getCreateDate() != null) {
            object = pSSysEAIElementBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIElementBase.getCreateMan() != null) {
            object = pSSysEAIElementBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getEAIElementTag() != null) {
            object = pSSysEAIElementBase.getEAIElementTag();
            xmlNode.setAttribute(FIELD_EAIELEMENTTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getEAIElementTag2() != null) {
            object = pSSysEAIElementBase.getEAIElementTag2();
            xmlNode.setAttribute(FIELD_EAIELEMENTTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getEAIElementType() != null) {
            object = pSSysEAIElementBase.getEAIElementType();
            xmlNode.setAttribute(FIELD_EAIELEMENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getMemo() != null) {
            object = pSSysEAIElementBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getOrderMode() != null) {
            object = pSSysEAIElementBase.getOrderMode();
            xmlNode.setAttribute(FIELD_ORDERMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getPSSysEAIElementId() != null) {
            object = pSSysEAIElementBase.getPSSysEAIElementId();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getPSSysEAIElementName() != null) {
            object = pSSysEAIElementBase.getPSSysEAIElementName();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getPSSysEAISchemeId() != null) {
            object = pSSysEAIElementBase.getPSSysEAISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSEAISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getPSSysEAISchemeName() != null) {
            object = pSSysEAIElementBase.getPSSysEAISchemeName();
            xmlNode.setAttribute(FIELD_PSSYSEAISCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getUpdateDate() != null) {
            object = pSSysEAIElementBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIElementBase.getUpdateMan() != null) {
            object = pSSysEAIElementBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getUserCat() != null) {
            object = pSSysEAIElementBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getUserTag() != null) {
            object = pSSysEAIElementBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getUserTag2() != null) {
            object = pSSysEAIElementBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getUserTag3() != null) {
            object = pSSysEAIElementBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getUserTag4() != null) {
            object = pSSysEAIElementBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementBase.getValidFlag() != null) {
            object = pSSysEAIElementBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysEAIElementBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysEAIElementBase pSSysEAIElementBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysEAIElementBase.isCodeNameDirty() && (bl || pSSysEAIElementBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysEAIElementBase.getCodeName());
        }
        if (pSSysEAIElementBase.isCreateDateDirty() && (bl || pSSysEAIElementBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysEAIElementBase.getCreateDate());
        }
        if (pSSysEAIElementBase.isCreateManDirty() && (bl || pSSysEAIElementBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysEAIElementBase.getCreateMan());
        }
        if (pSSysEAIElementBase.isEAIElementTagDirty() && (bl || pSSysEAIElementBase.getEAIElementTag() != null)) {
            iDataObject.set(FIELD_EAIELEMENTTAG, (Object)pSSysEAIElementBase.getEAIElementTag());
        }
        if (pSSysEAIElementBase.isEAIElementTag2Dirty() && (bl || pSSysEAIElementBase.getEAIElementTag2() != null)) {
            iDataObject.set(FIELD_EAIELEMENTTAG2, (Object)pSSysEAIElementBase.getEAIElementTag2());
        }
        if (pSSysEAIElementBase.isEAIElementTypeDirty() && (bl || pSSysEAIElementBase.getEAIElementType() != null)) {
            iDataObject.set(FIELD_EAIELEMENTTYPE, (Object)pSSysEAIElementBase.getEAIElementType());
        }
        if (pSSysEAIElementBase.isMemoDirty() && (bl || pSSysEAIElementBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysEAIElementBase.getMemo());
        }
        if (pSSysEAIElementBase.isOrderModeDirty() && (bl || pSSysEAIElementBase.getOrderMode() != null)) {
            iDataObject.set(FIELD_ORDERMODE, (Object)pSSysEAIElementBase.getOrderMode());
        }
        if (pSSysEAIElementBase.isPSSysEAIElementIdDirty() && (bl || pSSysEAIElementBase.getPSSysEAIElementId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTID, (Object)pSSysEAIElementBase.getPSSysEAIElementId());
        }
        if (pSSysEAIElementBase.isPSSysEAIElementNameDirty() && (bl || pSSysEAIElementBase.getPSSysEAIElementName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTNAME, (Object)pSSysEAIElementBase.getPSSysEAIElementName());
        }
        if (pSSysEAIElementBase.isPSSysEAISchemeIdDirty() && (bl || pSSysEAIElementBase.getPSSysEAISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSEAISCHEMEID, (Object)pSSysEAIElementBase.getPSSysEAISchemeId());
        }
        if (pSSysEAIElementBase.isPSSysEAISchemeNameDirty() && (bl || pSSysEAIElementBase.getPSSysEAISchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSEAISCHEMENAME, (Object)pSSysEAIElementBase.getPSSysEAISchemeName());
        }
        if (pSSysEAIElementBase.isUpdateDateDirty() && (bl || pSSysEAIElementBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysEAIElementBase.getUpdateDate());
        }
        if (pSSysEAIElementBase.isUpdateManDirty() && (bl || pSSysEAIElementBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysEAIElementBase.getUpdateMan());
        }
        if (pSSysEAIElementBase.isUserCatDirty() && (bl || pSSysEAIElementBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysEAIElementBase.getUserCat());
        }
        if (pSSysEAIElementBase.isUserTagDirty() && (bl || pSSysEAIElementBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysEAIElementBase.getUserTag());
        }
        if (pSSysEAIElementBase.isUserTag2Dirty() && (bl || pSSysEAIElementBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysEAIElementBase.getUserTag2());
        }
        if (pSSysEAIElementBase.isUserTag3Dirty() && (bl || pSSysEAIElementBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysEAIElementBase.getUserTag3());
        }
        if (pSSysEAIElementBase.isUserTag4Dirty() && (bl || pSSysEAIElementBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysEAIElementBase.getUserTag4());
        }
        if (pSSysEAIElementBase.isValidFlagDirty() && (bl || pSSysEAIElementBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysEAIElementBase.getValidFlag());
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
        return PSSysEAIElementBase.remove(this, n);
    }

    private static boolean remove(PSSysEAIElementBase pSSysEAIElementBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIElementBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysEAIElementBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysEAIElementBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysEAIElementBase.resetEAIElementTag();
                return true;
            }
            case 4: {
                pSSysEAIElementBase.resetEAIElementTag2();
                return true;
            }
            case 5: {
                pSSysEAIElementBase.resetEAIElementType();
                return true;
            }
            case 6: {
                pSSysEAIElementBase.resetMemo();
                return true;
            }
            case 7: {
                pSSysEAIElementBase.resetOrderMode();
                return true;
            }
            case 8: {
                pSSysEAIElementBase.resetPSSysEAIElementId();
                return true;
            }
            case 9: {
                pSSysEAIElementBase.resetPSSysEAIElementName();
                return true;
            }
            case 10: {
                pSSysEAIElementBase.resetPSSysEAISchemeId();
                return true;
            }
            case 11: {
                pSSysEAIElementBase.resetPSSysEAISchemeName();
                return true;
            }
            case 12: {
                pSSysEAIElementBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSysEAIElementBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSSysEAIElementBase.resetUserCat();
                return true;
            }
            case 15: {
                pSSysEAIElementBase.resetUserTag();
                return true;
            }
            case 16: {
                pSSysEAIElementBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSSysEAIElementBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSSysEAIElementBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSSysEAIElementBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEAIScheme getPSSysEAIScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIScheme();
        }
        if (this.getPSSysEAISchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysEAISchemeLock;
        synchronized (n) {
            if (this.pssyseaischeme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEAISchemeId(), (Object)this.pssyseaischeme.getPSSysEAISchemeId()) != 0L) {
                this.pssyseaischeme = null;
            }
            if (this.pssyseaischeme == null) {
                PSSysEAIScheme pSSysEAIScheme = new PSSysEAIScheme();
                pSSysEAIScheme.setPSSysEAISchemeId(this.getPSSysEAISchemeId());
                PSSysEAISchemeService pSSysEAISchemeService = (PSSysEAISchemeService)ServiceGlobal.getService(PSSysEAISchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysEAISchemeService.autoGet((IEntity)pSSysEAIScheme);
                this.pssyseaischeme = pSSysEAIScheme;
            }
            return this.pssyseaischeme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysEAIElementAttr> getPSSysEAIElementAttrs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementAttrs();
        }
        if (this.getPSSysEAIElementId() == null) {
            return null;
        }
        PSSysEAIElementService pSSysEAIElementService = (PSSysEAIElementService)ServiceGlobal.getService(PSSysEAIElementService.class, (SessionFactory)this.getSessionFactory());
        PSSysEAIElementAttrService pSSysEAIElementAttrService = (PSSysEAIElementAttrService)ServiceGlobal.getService(PSSysEAIElementAttrService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysEAIElementAttrsLock;
        synchronized (n) {
            if (this.pssyseaielementattrs == null) {
                this.pssyseaielementattrs = pSSysEAIElementService.isTempData((IEntity)this) ? pSSysEAIElementAttrService.selectTempByPSSysEAIElement(this) : pSSysEAIElementAttrService.selectByPSSysEAIElement(this);
            }
            return this.pssyseaielementattrs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysEAIElementRE> getPSSysEAIElementREs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementREs();
        }
        if (this.getPSSysEAIElementId() == null) {
            return null;
        }
        PSSysEAIElementService pSSysEAIElementService = (PSSysEAIElementService)ServiceGlobal.getService(PSSysEAIElementService.class, (SessionFactory)this.getSessionFactory());
        PSSysEAIElementREService pSSysEAIElementREService = (PSSysEAIElementREService)ServiceGlobal.getService(PSSysEAIElementREService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysEAIElementREsLock;
        synchronized (n) {
            if (this.pssyseaielementres == null) {
                this.pssyseaielementres = pSSysEAIElementService.isTempData((IEntity)this) ? pSSysEAIElementREService.selectTempByPSSysEAIElement(this) : pSSysEAIElementREService.selectByPSSysEAIElement(this);
            }
            return this.pssyseaielementres;
        }
    }

    private PSSysEAIElementBase getProxyEntity() {
        return this.proxyPSSysEAIElementBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysEAIElementBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysEAIElementBase) {
            this.proxyPSSysEAIElementBase = (PSSysEAIElementBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_EAIELEMENTTAG, 3);
        fieldIndexMap.put(FIELD_EAIELEMENTTAG2, 4);
        fieldIndexMap.put(FIELD_EAIELEMENTTYPE, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_ORDERMODE, 7);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTID, 8);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSEAISCHEMEID, 10);
        fieldIndexMap.put(FIELD_PSSYSEAISCHEMENAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERCAT, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

