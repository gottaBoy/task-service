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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOUType;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysOUTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysOUTypeRSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysOUTypeRSBase.class);
    public static final String FIELD_CPSSYSOUTYPEID = "CPSSYSOUTYPEID";
    public static final String FIELD_CPSSYSOUTYPENAME = "CPSSYSOUTYPENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSSYSOUTYPEID = "PPSSYSOUTYPEID";
    public static final String FIELD_PPSSYSOUTYPENAME = "PPSSYSOUTYPENAME";
    public static final String FIELD_PSSYSOUTYPERSID = "PSSYSOUTYPERSID";
    public static final String FIELD_PSSYSOUTYPERSNAME = "PSSYSOUTYPERSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CPSSYSOUTYPEID = 0;
    private static final int INDEX_CPSSYSOUTYPENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PPSSYSOUTYPEID = 5;
    private static final int INDEX_PPSSYSOUTYPENAME = 6;
    private static final int INDEX_PSSYSOUTYPERSID = 7;
    private static final int INDEX_PSSYSOUTYPERSNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_USERCAT = 11;
    private static final int INDEX_USERTAG = 12;
    private static final int INDEX_USERTAG2 = 13;
    private static final int INDEX_USERTAG3 = 14;
    private static final int INDEX_USERTAG4 = 15;
    private static final int INDEX_VALIDFLAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysOUTypeRSBase proxyPSSysOUTypeRSBase = null;
    private boolean cpssysoutypeidDirtyFlag = false;
    private boolean cpssysoutypenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppssysoutypeidDirtyFlag = false;
    private boolean ppssysoutypenameDirtyFlag = false;
    private boolean pssysoutypersidDirtyFlag = false;
    private boolean pssysoutypersnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="cpssysoutypeid")
    private String cpssysoutypeid;
    @Column(name="cpssysoutypename")
    private String cpssysoutypename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppssysoutypeid")
    private String ppssysoutypeid;
    @Column(name="ppssysoutypename")
    private String ppssysoutypename;
    @Column(name="pssysoutypersid")
    private String pssysoutypersid;
    @Column(name="pssysoutypersname")
    private String pssysoutypersname;
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
    private Integer objCPSSysOUTypeLock = new Integer(1);
    private PSSysOUType cpssysoutype = null;
    private Integer objPPSSsysOUTypeLock = new Integer(1);
    private PSSysOUType ppsssysoutype = null;

    public void setCPSSYSOUTypeID(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCPSSYSOUTypeID(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cpssysoutypeid = string;
        this.cpssysoutypeidDirtyFlag = true;
    }

    public String getCPSSYSOUTypeID() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSSYSOUTypeID();
        }
        return this.cpssysoutypeid;
    }

    public boolean isCPSSYSOUTypeIDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCPSSYSOUTypeIDDirty();
        }
        return this.cpssysoutypeidDirtyFlag;
    }

    public void resetCPSSYSOUTypeID() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCPSSYSOUTypeID();
            return;
        }
        this.cpssysoutypeidDirtyFlag = false;
        this.cpssysoutypeid = null;
    }

    public void setCPSSYSOUTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCPSSYSOUTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cpssysoutypename = string;
        this.cpssysoutypenameDirtyFlag = true;
    }

    public String getCPSSYSOUTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSSYSOUTypeName();
        }
        return this.cpssysoutypename;
    }

    public boolean isCPSSYSOUTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCPSSYSOUTypeNameDirty();
        }
        return this.cpssysoutypenameDirtyFlag;
    }

    public void resetCPSSYSOUTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCPSSYSOUTypeName();
            return;
        }
        this.cpssysoutypenameDirtyFlag = false;
        this.cpssysoutypename = null;
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

    public void setPPSSysOUTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysOUTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysoutypeid = string;
        this.ppssysoutypeidDirtyFlag = true;
    }

    public String getPPSSysOUTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysOUTypeId();
        }
        return this.ppssysoutypeid;
    }

    public boolean isPPSSysOUTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysOUTypeIdDirty();
        }
        return this.ppssysoutypeidDirtyFlag;
    }

    public void resetPPSSysOUTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysOUTypeId();
            return;
        }
        this.ppssysoutypeidDirtyFlag = false;
        this.ppssysoutypeid = null;
    }

    public void setPPSSYSOUTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSYSOUTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysoutypename = string;
        this.ppssysoutypenameDirtyFlag = true;
    }

    public String getPPSSYSOUTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSYSOUTypeName();
        }
        return this.ppssysoutypename;
    }

    public boolean isPPSSYSOUTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSYSOUTypeNameDirty();
        }
        return this.ppssysoutypenameDirtyFlag;
    }

    public void resetPPSSYSOUTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSYSOUTypeName();
            return;
        }
        this.ppssysoutypenameDirtyFlag = false;
        this.ppssysoutypename = null;
    }

    public void setPSSysOUTypeRSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysOUTypeRSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysoutypersid = string;
        this.pssysoutypersidDirtyFlag = true;
    }

    public String getPSSysOUTypeRSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOUTypeRSId();
        }
        return this.pssysoutypersid;
    }

    public boolean isPSSysOUTypeRSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysOUTypeRSIdDirty();
        }
        return this.pssysoutypersidDirtyFlag;
    }

    public void resetPSSysOUTypeRSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysOUTypeRSId();
            return;
        }
        this.pssysoutypersidDirtyFlag = false;
        this.pssysoutypersid = null;
    }

    public void setPSSysOUTypeRSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysOUTypeRSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysoutypersname = string;
        this.pssysoutypersnameDirtyFlag = true;
    }

    public String getPSSysOUTypeRSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOUTypeRSName();
        }
        return this.pssysoutypersname;
    }

    public boolean isPSSysOUTypeRSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysOUTypeRSNameDirty();
        }
        return this.pssysoutypersnameDirtyFlag;
    }

    public void resetPSSysOUTypeRSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysOUTypeRSName();
            return;
        }
        this.pssysoutypersnameDirtyFlag = false;
        this.pssysoutypersname = null;
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
        PSSysOUTypeRSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysOUTypeRSBase pSSysOUTypeRSBase) {
        pSSysOUTypeRSBase.resetCPSSYSOUTypeID();
        pSSysOUTypeRSBase.resetCPSSYSOUTypeName();
        pSSysOUTypeRSBase.resetCreateDate();
        pSSysOUTypeRSBase.resetCreateMan();
        pSSysOUTypeRSBase.resetOrderValue();
        pSSysOUTypeRSBase.resetPPSSysOUTypeId();
        pSSysOUTypeRSBase.resetPPSSYSOUTypeName();
        pSSysOUTypeRSBase.resetPSSysOUTypeRSId();
        pSSysOUTypeRSBase.resetPSSysOUTypeRSName();
        pSSysOUTypeRSBase.resetUpdateDate();
        pSSysOUTypeRSBase.resetUpdateMan();
        pSSysOUTypeRSBase.resetUserCat();
        pSSysOUTypeRSBase.resetUserTag();
        pSSysOUTypeRSBase.resetUserTag2();
        pSSysOUTypeRSBase.resetUserTag3();
        pSSysOUTypeRSBase.resetUserTag4();
        pSSysOUTypeRSBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCPSSYSOUTypeIDDirty()) {
            hashMap.put(FIELD_CPSSYSOUTYPEID, this.getCPSSYSOUTypeID());
        }
        if (!bl || this.isCPSSYSOUTypeNameDirty()) {
            hashMap.put(FIELD_CPSSYSOUTYPENAME, this.getCPSSYSOUTypeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSSysOUTypeIdDirty()) {
            hashMap.put(FIELD_PPSSYSOUTYPEID, this.getPPSSysOUTypeId());
        }
        if (!bl || this.isPPSSYSOUTypeNameDirty()) {
            hashMap.put(FIELD_PPSSYSOUTYPENAME, this.getPPSSYSOUTypeName());
        }
        if (!bl || this.isPSSysOUTypeRSIdDirty()) {
            hashMap.put(FIELD_PSSYSOUTYPERSID, this.getPSSysOUTypeRSId());
        }
        if (!bl || this.isPSSysOUTypeRSNameDirty()) {
            hashMap.put(FIELD_PSSYSOUTYPERSNAME, this.getPSSysOUTypeRSName());
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
        return PSSysOUTypeRSBase.get(this, n);
    }

    private static Object get(PSSysOUTypeRSBase pSSysOUTypeRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysOUTypeRSBase.getCPSSYSOUTypeID();
            }
            case 1: {
                return pSSysOUTypeRSBase.getCPSSYSOUTypeName();
            }
            case 2: {
                return pSSysOUTypeRSBase.getCreateDate();
            }
            case 3: {
                return pSSysOUTypeRSBase.getCreateMan();
            }
            case 4: {
                return pSSysOUTypeRSBase.getOrderValue();
            }
            case 5: {
                return pSSysOUTypeRSBase.getPPSSysOUTypeId();
            }
            case 6: {
                return pSSysOUTypeRSBase.getPPSSYSOUTypeName();
            }
            case 7: {
                return pSSysOUTypeRSBase.getPSSysOUTypeRSId();
            }
            case 8: {
                return pSSysOUTypeRSBase.getPSSysOUTypeRSName();
            }
            case 9: {
                return pSSysOUTypeRSBase.getUpdateDate();
            }
            case 10: {
                return pSSysOUTypeRSBase.getUpdateMan();
            }
            case 11: {
                return pSSysOUTypeRSBase.getUserCat();
            }
            case 12: {
                return pSSysOUTypeRSBase.getUserTag();
            }
            case 13: {
                return pSSysOUTypeRSBase.getUserTag2();
            }
            case 14: {
                return pSSysOUTypeRSBase.getUserTag3();
            }
            case 15: {
                return pSSysOUTypeRSBase.getUserTag4();
            }
            case 16: {
                return pSSysOUTypeRSBase.getValidFlag();
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
        PSSysOUTypeRSBase.set(this, n, object);
    }

    private static void set(PSSysOUTypeRSBase pSSysOUTypeRSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysOUTypeRSBase.setCPSSYSOUTypeID(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysOUTypeRSBase.setCPSSYSOUTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysOUTypeRSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSysOUTypeRSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysOUTypeRSBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysOUTypeRSBase.setPPSSysOUTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysOUTypeRSBase.setPPSSYSOUTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysOUTypeRSBase.setPSSysOUTypeRSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysOUTypeRSBase.setPSSysOUTypeRSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysOUTypeRSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSSysOUTypeRSBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysOUTypeRSBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysOUTypeRSBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysOUTypeRSBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysOUTypeRSBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysOUTypeRSBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysOUTypeRSBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysOUTypeRSBase.isNull(this, n);
    }

    private static boolean isNull(PSSysOUTypeRSBase pSSysOUTypeRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysOUTypeRSBase.getCPSSYSOUTypeID() == null;
            }
            case 1: {
                return pSSysOUTypeRSBase.getCPSSYSOUTypeName() == null;
            }
            case 2: {
                return pSSysOUTypeRSBase.getCreateDate() == null;
            }
            case 3: {
                return pSSysOUTypeRSBase.getCreateMan() == null;
            }
            case 4: {
                return pSSysOUTypeRSBase.getOrderValue() == null;
            }
            case 5: {
                return pSSysOUTypeRSBase.getPPSSysOUTypeId() == null;
            }
            case 6: {
                return pSSysOUTypeRSBase.getPPSSYSOUTypeName() == null;
            }
            case 7: {
                return pSSysOUTypeRSBase.getPSSysOUTypeRSId() == null;
            }
            case 8: {
                return pSSysOUTypeRSBase.getPSSysOUTypeRSName() == null;
            }
            case 9: {
                return pSSysOUTypeRSBase.getUpdateDate() == null;
            }
            case 10: {
                return pSSysOUTypeRSBase.getUpdateMan() == null;
            }
            case 11: {
                return pSSysOUTypeRSBase.getUserCat() == null;
            }
            case 12: {
                return pSSysOUTypeRSBase.getUserTag() == null;
            }
            case 13: {
                return pSSysOUTypeRSBase.getUserTag2() == null;
            }
            case 14: {
                return pSSysOUTypeRSBase.getUserTag3() == null;
            }
            case 15: {
                return pSSysOUTypeRSBase.getUserTag4() == null;
            }
            case 16: {
                return pSSysOUTypeRSBase.getValidFlag() == null;
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
        return PSSysOUTypeRSBase.contains(this, n);
    }

    private static boolean contains(PSSysOUTypeRSBase pSSysOUTypeRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysOUTypeRSBase.isCPSSYSOUTypeIDDirty();
            }
            case 1: {
                return pSSysOUTypeRSBase.isCPSSYSOUTypeNameDirty();
            }
            case 2: {
                return pSSysOUTypeRSBase.isCreateDateDirty();
            }
            case 3: {
                return pSSysOUTypeRSBase.isCreateManDirty();
            }
            case 4: {
                return pSSysOUTypeRSBase.isOrderValueDirty();
            }
            case 5: {
                return pSSysOUTypeRSBase.isPPSSysOUTypeIdDirty();
            }
            case 6: {
                return pSSysOUTypeRSBase.isPPSSYSOUTypeNameDirty();
            }
            case 7: {
                return pSSysOUTypeRSBase.isPSSysOUTypeRSIdDirty();
            }
            case 8: {
                return pSSysOUTypeRSBase.isPSSysOUTypeRSNameDirty();
            }
            case 9: {
                return pSSysOUTypeRSBase.isUpdateDateDirty();
            }
            case 10: {
                return pSSysOUTypeRSBase.isUpdateManDirty();
            }
            case 11: {
                return pSSysOUTypeRSBase.isUserCatDirty();
            }
            case 12: {
                return pSSysOUTypeRSBase.isUserTagDirty();
            }
            case 13: {
                return pSSysOUTypeRSBase.isUserTag2Dirty();
            }
            case 14: {
                return pSSysOUTypeRSBase.isUserTag3Dirty();
            }
            case 15: {
                return pSSysOUTypeRSBase.isUserTag4Dirty();
            }
            case 16: {
                return pSSysOUTypeRSBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysOUTypeRSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysOUTypeRSBase pSSysOUTypeRSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysOUTypeRSBase.getCPSSYSOUTypeID() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cpssysoutypeid", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getCPSSYSOUTypeID()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getCPSSYSOUTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cpssysoutypename", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getCPSSYSOUTypeName()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getPPSSysOUTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysoutypeid", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getPPSSysOUTypeId()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getPPSSYSOUTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysoutypename", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getPPSSYSOUTypeName()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getPSSysOUTypeRSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysoutypersid", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getPSSysOUTypeRSId()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getPSSysOUTypeRSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysoutypersname", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getPSSysOUTypeRSName()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysOUTypeRSBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysOUTypeRSBase.getJSONValue((Object)pSSysOUTypeRSBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysOUTypeRSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysOUTypeRSBase pSSysOUTypeRSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysOUTypeRSBase.getCPSSYSOUTypeID() != null) {
            object = pSSysOUTypeRSBase.getCPSSYSOUTypeID();
            xmlNode.setAttribute(FIELD_CPSSYSOUTYPEID, (String)(object == null ? "" : object));
        }
        if (bl || pSSysOUTypeRSBase.getCPSSYSOUTypeName() != null) {
            object = pSSysOUTypeRSBase.getCPSSYSOUTypeName();
            xmlNode.setAttribute(FIELD_CPSSYSOUTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeRSBase.getCreateDate() != null) {
            object = pSSysOUTypeRSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysOUTypeRSBase.getCreateMan() != null) {
            object = pSSysOUTypeRSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeRSBase.getOrderValue() != null) {
            object = pSSysOUTypeRSBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysOUTypeRSBase.getPPSSysOUTypeId() != null) {
            object = pSSysOUTypeRSBase.getPPSSysOUTypeId();
            xmlNode.setAttribute(FIELD_PPSSYSOUTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeRSBase.getPPSSYSOUTypeName() != null) {
            object = pSSysOUTypeRSBase.getPPSSYSOUTypeName();
            xmlNode.setAttribute(FIELD_PPSSYSOUTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeRSBase.getPSSysOUTypeRSId() != null) {
            object = pSSysOUTypeRSBase.getPSSysOUTypeRSId();
            xmlNode.setAttribute(FIELD_PSSYSOUTYPERSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeRSBase.getPSSysOUTypeRSName() != null) {
            object = pSSysOUTypeRSBase.getPSSysOUTypeRSName();
            xmlNode.setAttribute(FIELD_PSSYSOUTYPERSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeRSBase.getUpdateDate() != null) {
            object = pSSysOUTypeRSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysOUTypeRSBase.getUpdateMan() != null) {
            object = pSSysOUTypeRSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeRSBase.getUserCat() != null) {
            object = pSSysOUTypeRSBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeRSBase.getUserTag() != null) {
            object = pSSysOUTypeRSBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeRSBase.getUserTag2() != null) {
            object = pSSysOUTypeRSBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeRSBase.getUserTag3() != null) {
            object = pSSysOUTypeRSBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeRSBase.getUserTag4() != null) {
            object = pSSysOUTypeRSBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeRSBase.getValidFlag() != null) {
            object = pSSysOUTypeRSBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysOUTypeRSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysOUTypeRSBase pSSysOUTypeRSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysOUTypeRSBase.isCPSSYSOUTypeIDDirty() && (bl || pSSysOUTypeRSBase.getCPSSYSOUTypeID() != null)) {
            iDataObject.set(FIELD_CPSSYSOUTYPEID, (Object)pSSysOUTypeRSBase.getCPSSYSOUTypeID());
        }
        if (pSSysOUTypeRSBase.isCPSSYSOUTypeNameDirty() && (bl || pSSysOUTypeRSBase.getCPSSYSOUTypeName() != null)) {
            iDataObject.set(FIELD_CPSSYSOUTYPENAME, (Object)pSSysOUTypeRSBase.getCPSSYSOUTypeName());
        }
        if (pSSysOUTypeRSBase.isCreateDateDirty() && (bl || pSSysOUTypeRSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysOUTypeRSBase.getCreateDate());
        }
        if (pSSysOUTypeRSBase.isCreateManDirty() && (bl || pSSysOUTypeRSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysOUTypeRSBase.getCreateMan());
        }
        if (pSSysOUTypeRSBase.isOrderValueDirty() && (bl || pSSysOUTypeRSBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysOUTypeRSBase.getOrderValue());
        }
        if (pSSysOUTypeRSBase.isPPSSysOUTypeIdDirty() && (bl || pSSysOUTypeRSBase.getPPSSysOUTypeId() != null)) {
            iDataObject.set(FIELD_PPSSYSOUTYPEID, (Object)pSSysOUTypeRSBase.getPPSSysOUTypeId());
        }
        if (pSSysOUTypeRSBase.isPPSSYSOUTypeNameDirty() && (bl || pSSysOUTypeRSBase.getPPSSYSOUTypeName() != null)) {
            iDataObject.set(FIELD_PPSSYSOUTYPENAME, (Object)pSSysOUTypeRSBase.getPPSSYSOUTypeName());
        }
        if (pSSysOUTypeRSBase.isPSSysOUTypeRSIdDirty() && (bl || pSSysOUTypeRSBase.getPSSysOUTypeRSId() != null)) {
            iDataObject.set(FIELD_PSSYSOUTYPERSID, (Object)pSSysOUTypeRSBase.getPSSysOUTypeRSId());
        }
        if (pSSysOUTypeRSBase.isPSSysOUTypeRSNameDirty() && (bl || pSSysOUTypeRSBase.getPSSysOUTypeRSName() != null)) {
            iDataObject.set(FIELD_PSSYSOUTYPERSNAME, (Object)pSSysOUTypeRSBase.getPSSysOUTypeRSName());
        }
        if (pSSysOUTypeRSBase.isUpdateDateDirty() && (bl || pSSysOUTypeRSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysOUTypeRSBase.getUpdateDate());
        }
        if (pSSysOUTypeRSBase.isUpdateManDirty() && (bl || pSSysOUTypeRSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysOUTypeRSBase.getUpdateMan());
        }
        if (pSSysOUTypeRSBase.isUserCatDirty() && (bl || pSSysOUTypeRSBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysOUTypeRSBase.getUserCat());
        }
        if (pSSysOUTypeRSBase.isUserTagDirty() && (bl || pSSysOUTypeRSBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysOUTypeRSBase.getUserTag());
        }
        if (pSSysOUTypeRSBase.isUserTag2Dirty() && (bl || pSSysOUTypeRSBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysOUTypeRSBase.getUserTag2());
        }
        if (pSSysOUTypeRSBase.isUserTag3Dirty() && (bl || pSSysOUTypeRSBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysOUTypeRSBase.getUserTag3());
        }
        if (pSSysOUTypeRSBase.isUserTag4Dirty() && (bl || pSSysOUTypeRSBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysOUTypeRSBase.getUserTag4());
        }
        if (pSSysOUTypeRSBase.isValidFlagDirty() && (bl || pSSysOUTypeRSBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysOUTypeRSBase.getValidFlag());
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
        return PSSysOUTypeRSBase.remove(this, n);
    }

    private static boolean remove(PSSysOUTypeRSBase pSSysOUTypeRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysOUTypeRSBase.resetCPSSYSOUTypeID();
                return true;
            }
            case 1: {
                pSSysOUTypeRSBase.resetCPSSYSOUTypeName();
                return true;
            }
            case 2: {
                pSSysOUTypeRSBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSysOUTypeRSBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSysOUTypeRSBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSSysOUTypeRSBase.resetPPSSysOUTypeId();
                return true;
            }
            case 6: {
                pSSysOUTypeRSBase.resetPPSSYSOUTypeName();
                return true;
            }
            case 7: {
                pSSysOUTypeRSBase.resetPSSysOUTypeRSId();
                return true;
            }
            case 8: {
                pSSysOUTypeRSBase.resetPSSysOUTypeRSName();
                return true;
            }
            case 9: {
                pSSysOUTypeRSBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSSysOUTypeRSBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSSysOUTypeRSBase.resetUserCat();
                return true;
            }
            case 12: {
                pSSysOUTypeRSBase.resetUserTag();
                return true;
            }
            case 13: {
                pSSysOUTypeRSBase.resetUserTag2();
                return true;
            }
            case 14: {
                pSSysOUTypeRSBase.resetUserTag3();
                return true;
            }
            case 15: {
                pSSysOUTypeRSBase.resetUserTag4();
                return true;
            }
            case 16: {
                pSSysOUTypeRSBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysOUType getCPSSysOUType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSSysOUType();
        }
        if (this.getCPSSYSOUTypeID() == null) {
            return null;
        }
        Integer n = this.objCPSSysOUTypeLock;
        synchronized (n) {
            if (this.cpssysoutype != null && DataTypeHelper.compare((int)25, (Object)this.getCPSSYSOUTypeID(), (Object)this.cpssysoutype.getPSSysOUTypeId()) != 0L) {
                this.cpssysoutype = null;
            }
            if (this.cpssysoutype == null) {
                PSSysOUType pSSysOUType = new PSSysOUType();
                pSSysOUType.setPSSysOUTypeId(this.getCPSSYSOUTypeID());
                PSSysOUTypeService pSSysOUTypeService = (PSSysOUTypeService)ServiceGlobal.getService(PSSysOUTypeService.class, (SessionFactory)this.getSessionFactory());
                pSSysOUTypeService.autoGet((IEntity)pSSysOUType);
                this.cpssysoutype = pSSysOUType;
            }
            return this.cpssysoutype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysOUType getPPSSsysOUType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSsysOUType();
        }
        if (this.getPPSSysOUTypeId() == null) {
            return null;
        }
        Integer n = this.objPPSSsysOUTypeLock;
        synchronized (n) {
            if (this.ppsssysoutype != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysOUTypeId(), (Object)this.ppsssysoutype.getPSSysOUTypeId()) != 0L) {
                this.ppsssysoutype = null;
            }
            if (this.ppsssysoutype == null) {
                PSSysOUType pSSysOUType = new PSSysOUType();
                pSSysOUType.setPSSysOUTypeId(this.getPPSSysOUTypeId());
                PSSysOUTypeService pSSysOUTypeService = (PSSysOUTypeService)ServiceGlobal.getService(PSSysOUTypeService.class, (SessionFactory)this.getSessionFactory());
                pSSysOUTypeService.autoGet((IEntity)pSSysOUType);
                this.ppsssysoutype = pSSysOUType;
            }
            return this.ppsssysoutype;
        }
    }

    private PSSysOUTypeRSBase getProxyEntity() {
        return this.proxyPSSysOUTypeRSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysOUTypeRSBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysOUTypeRSBase) {
            this.proxyPSSysOUTypeRSBase = (PSSysOUTypeRSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysOUTypeRSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CPSSYSOUTYPEID, 0);
        fieldIndexMap.put(FIELD_CPSSYSOUTYPENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PPSSYSOUTYPEID, 5);
        fieldIndexMap.put(FIELD_PPSSYSOUTYPENAME, 6);
        fieldIndexMap.put(FIELD_PSSYSOUTYPERSID, 7);
        fieldIndexMap.put(FIELD_PSSYSOUTYPERSNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_USERCAT, 11);
        fieldIndexMap.put(FIELD_USERTAG, 12);
        fieldIndexMap.put(FIELD_USERTAG2, 13);
        fieldIndexMap.put(FIELD_USERTAG3, 14);
        fieldIndexMap.put(FIELD_USERTAG4, 15);
        fieldIndexMap.put(FIELD_VALIDFLAG, 16);
    }
}

