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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysOUTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysOUTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSSYSOUTYPEID = "PSSYSOUTYPEID";
    public static final String FIELD_PSSYSOUTYPENAME = "PSSYSOUTYPENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_ROOTFLAG = "ROOTFLAG";
    public static final String FIELD_TYPECODE = "TYPECODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PSSYSOUTYPEID = 4;
    private static final int INDEX_PSSYSOUTYPENAME = 5;
    private static final int INDEX_PSSYSTEMID = 6;
    private static final int INDEX_PSSYSTEMNAME = 7;
    private static final int INDEX_ROOTFLAG = 8;
    private static final int INDEX_TYPECODE = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERCAT = 12;
    private static final int INDEX_USERTAG = 13;
    private static final int INDEX_USERTAG2 = 14;
    private static final int INDEX_USERTAG3 = 15;
    private static final int INDEX_USERTAG4 = 16;
    private static final int INDEX_VALIDFLAG = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysOUTypeBase proxyPSSysOUTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pssysoutypeidDirtyFlag = false;
    private boolean pssysoutypenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean rootflagDirtyFlag = false;
    private boolean typecodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pssysoutypeid")
    private String pssysoutypeid;
    @Column(name="pssysoutypename")
    private String pssysoutypename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="rootflag")
    private Integer rootflag;
    @Column(name="typecode")
    private String typecode;
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
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setPSSysOUTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysOUTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysoutypeid = string;
        this.pssysoutypeidDirtyFlag = true;
    }

    public String getPSSysOUTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOUTypeId();
        }
        return this.pssysoutypeid;
    }

    public boolean isPSSysOUTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysOUTypeIdDirty();
        }
        return this.pssysoutypeidDirtyFlag;
    }

    public void resetPSSysOUTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysOUTypeId();
            return;
        }
        this.pssysoutypeidDirtyFlag = false;
        this.pssysoutypeid = null;
    }

    public void setPSSysOUTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysOUTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysoutypename = string;
        this.pssysoutypenameDirtyFlag = true;
    }

    public String getPSSysOUTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOUTypeName();
        }
        return this.pssysoutypename;
    }

    public boolean isPSSysOUTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysOUTypeNameDirty();
        }
        return this.pssysoutypenameDirtyFlag;
    }

    public void resetPSSysOUTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysOUTypeName();
            return;
        }
        this.pssysoutypenameDirtyFlag = false;
        this.pssysoutypename = null;
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

    public void setRootFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRootFlag(n);
            return;
        }
        this.rootflag = n;
        this.rootflagDirtyFlag = true;
    }

    public Integer getRootFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRootFlag();
        }
        return this.rootflag;
    }

    public boolean isRootFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRootFlagDirty();
        }
        return this.rootflagDirtyFlag;
    }

    public void resetRootFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRootFlag();
            return;
        }
        this.rootflagDirtyFlag = false;
        this.rootflag = null;
    }

    public void setTypeCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typecode = string;
        this.typecodeDirtyFlag = true;
    }

    public String getTypeCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeCode();
        }
        return this.typecode;
    }

    public boolean isTypeCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeCodeDirty();
        }
        return this.typecodeDirtyFlag;
    }

    public void resetTypeCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeCode();
            return;
        }
        this.typecodeDirtyFlag = false;
        this.typecode = null;
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
        PSSysOUTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysOUTypeBase pSSysOUTypeBase) {
        pSSysOUTypeBase.resetCreateDate();
        pSSysOUTypeBase.resetCreateMan();
        pSSysOUTypeBase.resetMemo();
        pSSysOUTypeBase.resetOrderValue();
        pSSysOUTypeBase.resetPSSysOUTypeId();
        pSSysOUTypeBase.resetPSSysOUTypeName();
        pSSysOUTypeBase.resetPSSystemId();
        pSSysOUTypeBase.resetPSSystemName();
        pSSysOUTypeBase.resetRootFlag();
        pSSysOUTypeBase.resetTypeCode();
        pSSysOUTypeBase.resetUpdateDate();
        pSSysOUTypeBase.resetUpdateMan();
        pSSysOUTypeBase.resetUserCat();
        pSSysOUTypeBase.resetUserTag();
        pSSysOUTypeBase.resetUserTag2();
        pSSysOUTypeBase.resetUserTag3();
        pSSysOUTypeBase.resetUserTag4();
        pSSysOUTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isPSSysOUTypeIdDirty()) {
            hashMap.put(FIELD_PSSYSOUTYPEID, this.getPSSysOUTypeId());
        }
        if (!bl || this.isPSSysOUTypeNameDirty()) {
            hashMap.put(FIELD_PSSYSOUTYPENAME, this.getPSSysOUTypeName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isRootFlagDirty()) {
            hashMap.put(FIELD_ROOTFLAG, this.getRootFlag());
        }
        if (!bl || this.isTypeCodeDirty()) {
            hashMap.put(FIELD_TYPECODE, this.getTypeCode());
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
        return PSSysOUTypeBase.get(this, n);
    }

    private static Object get(PSSysOUTypeBase pSSysOUTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysOUTypeBase.getCreateDate();
            }
            case 1: {
                return pSSysOUTypeBase.getCreateMan();
            }
            case 2: {
                return pSSysOUTypeBase.getMemo();
            }
            case 3: {
                return pSSysOUTypeBase.getOrderValue();
            }
            case 4: {
                return pSSysOUTypeBase.getPSSysOUTypeId();
            }
            case 5: {
                return pSSysOUTypeBase.getPSSysOUTypeName();
            }
            case 6: {
                return pSSysOUTypeBase.getPSSystemId();
            }
            case 7: {
                return pSSysOUTypeBase.getPSSystemName();
            }
            case 8: {
                return pSSysOUTypeBase.getRootFlag();
            }
            case 9: {
                return pSSysOUTypeBase.getTypeCode();
            }
            case 10: {
                return pSSysOUTypeBase.getUpdateDate();
            }
            case 11: {
                return pSSysOUTypeBase.getUpdateMan();
            }
            case 12: {
                return pSSysOUTypeBase.getUserCat();
            }
            case 13: {
                return pSSysOUTypeBase.getUserTag();
            }
            case 14: {
                return pSSysOUTypeBase.getUserTag2();
            }
            case 15: {
                return pSSysOUTypeBase.getUserTag3();
            }
            case 16: {
                return pSSysOUTypeBase.getUserTag4();
            }
            case 17: {
                return pSSysOUTypeBase.getValidFlag();
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
        PSSysOUTypeBase.set(this, n, object);
    }

    private static void set(PSSysOUTypeBase pSSysOUTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysOUTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysOUTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysOUTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysOUTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysOUTypeBase.setPSSysOUTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysOUTypeBase.setPSSysOUTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysOUTypeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysOUTypeBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysOUTypeBase.setRootFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysOUTypeBase.setTypeCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysOUTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysOUTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysOUTypeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysOUTypeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysOUTypeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysOUTypeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysOUTypeBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysOUTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysOUTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysOUTypeBase pSSysOUTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysOUTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysOUTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysOUTypeBase.getMemo() == null;
            }
            case 3: {
                return pSSysOUTypeBase.getOrderValue() == null;
            }
            case 4: {
                return pSSysOUTypeBase.getPSSysOUTypeId() == null;
            }
            case 5: {
                return pSSysOUTypeBase.getPSSysOUTypeName() == null;
            }
            case 6: {
                return pSSysOUTypeBase.getPSSystemId() == null;
            }
            case 7: {
                return pSSysOUTypeBase.getPSSystemName() == null;
            }
            case 8: {
                return pSSysOUTypeBase.getRootFlag() == null;
            }
            case 9: {
                return pSSysOUTypeBase.getTypeCode() == null;
            }
            case 10: {
                return pSSysOUTypeBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysOUTypeBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSysOUTypeBase.getUserCat() == null;
            }
            case 13: {
                return pSSysOUTypeBase.getUserTag() == null;
            }
            case 14: {
                return pSSysOUTypeBase.getUserTag2() == null;
            }
            case 15: {
                return pSSysOUTypeBase.getUserTag3() == null;
            }
            case 16: {
                return pSSysOUTypeBase.getUserTag4() == null;
            }
            case 17: {
                return pSSysOUTypeBase.getValidFlag() == null;
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
        return PSSysOUTypeBase.contains(this, n);
    }

    private static boolean contains(PSSysOUTypeBase pSSysOUTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysOUTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysOUTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSSysOUTypeBase.isMemoDirty();
            }
            case 3: {
                return pSSysOUTypeBase.isOrderValueDirty();
            }
            case 4: {
                return pSSysOUTypeBase.isPSSysOUTypeIdDirty();
            }
            case 5: {
                return pSSysOUTypeBase.isPSSysOUTypeNameDirty();
            }
            case 6: {
                return pSSysOUTypeBase.isPSSystemIdDirty();
            }
            case 7: {
                return pSSysOUTypeBase.isPSSystemNameDirty();
            }
            case 8: {
                return pSSysOUTypeBase.isRootFlagDirty();
            }
            case 9: {
                return pSSysOUTypeBase.isTypeCodeDirty();
            }
            case 10: {
                return pSSysOUTypeBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysOUTypeBase.isUpdateManDirty();
            }
            case 12: {
                return pSSysOUTypeBase.isUserCatDirty();
            }
            case 13: {
                return pSSysOUTypeBase.isUserTagDirty();
            }
            case 14: {
                return pSSysOUTypeBase.isUserTag2Dirty();
            }
            case 15: {
                return pSSysOUTypeBase.isUserTag3Dirty();
            }
            case 16: {
                return pSSysOUTypeBase.isUserTag4Dirty();
            }
            case 17: {
                return pSSysOUTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysOUTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysOUTypeBase pSSysOUTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysOUTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getPSSysOUTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysoutypeid", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getPSSysOUTypeId()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getPSSysOUTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysoutypename", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getPSSysOUTypeName()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getRootFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rootflag", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getRootFlag()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getTypeCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typecode", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getTypeCode()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysOUTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysOUTypeBase.getJSONValue((Object)pSSysOUTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysOUTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysOUTypeBase pSSysOUTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysOUTypeBase.getCreateDate() != null) {
            object = pSSysOUTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysOUTypeBase.getCreateMan() != null) {
            object = pSSysOUTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeBase.getMemo() != null) {
            object = pSSysOUTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeBase.getOrderValue() != null) {
            object = pSSysOUTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysOUTypeBase.getPSSysOUTypeId() != null) {
            object = pSSysOUTypeBase.getPSSysOUTypeId();
            xmlNode.setAttribute(FIELD_PSSYSOUTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeBase.getPSSysOUTypeName() != null) {
            object = pSSysOUTypeBase.getPSSysOUTypeName();
            xmlNode.setAttribute(FIELD_PSSYSOUTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeBase.getPSSystemId() != null) {
            object = pSSysOUTypeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeBase.getPSSystemName() != null) {
            object = pSSysOUTypeBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeBase.getRootFlag() != null) {
            object = pSSysOUTypeBase.getRootFlag();
            xmlNode.setAttribute(FIELD_ROOTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysOUTypeBase.getTypeCode() != null) {
            object = pSSysOUTypeBase.getTypeCode();
            xmlNode.setAttribute(FIELD_TYPECODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeBase.getUpdateDate() != null) {
            object = pSSysOUTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysOUTypeBase.getUpdateMan() != null) {
            object = pSSysOUTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeBase.getUserCat() != null) {
            object = pSSysOUTypeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeBase.getUserTag() != null) {
            object = pSSysOUTypeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeBase.getUserTag2() != null) {
            object = pSSysOUTypeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeBase.getUserTag3() != null) {
            object = pSSysOUTypeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeBase.getUserTag4() != null) {
            object = pSSysOUTypeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysOUTypeBase.getValidFlag() != null) {
            object = pSSysOUTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysOUTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysOUTypeBase pSSysOUTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysOUTypeBase.isCreateDateDirty() && (bl || pSSysOUTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysOUTypeBase.getCreateDate());
        }
        if (pSSysOUTypeBase.isCreateManDirty() && (bl || pSSysOUTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysOUTypeBase.getCreateMan());
        }
        if (pSSysOUTypeBase.isMemoDirty() && (bl || pSSysOUTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysOUTypeBase.getMemo());
        }
        if (pSSysOUTypeBase.isOrderValueDirty() && (bl || pSSysOUTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysOUTypeBase.getOrderValue());
        }
        if (pSSysOUTypeBase.isPSSysOUTypeIdDirty() && (bl || pSSysOUTypeBase.getPSSysOUTypeId() != null)) {
            iDataObject.set(FIELD_PSSYSOUTYPEID, (Object)pSSysOUTypeBase.getPSSysOUTypeId());
        }
        if (pSSysOUTypeBase.isPSSysOUTypeNameDirty() && (bl || pSSysOUTypeBase.getPSSysOUTypeName() != null)) {
            iDataObject.set(FIELD_PSSYSOUTYPENAME, (Object)pSSysOUTypeBase.getPSSysOUTypeName());
        }
        if (pSSysOUTypeBase.isPSSystemIdDirty() && (bl || pSSysOUTypeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysOUTypeBase.getPSSystemId());
        }
        if (pSSysOUTypeBase.isPSSystemNameDirty() && (bl || pSSysOUTypeBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysOUTypeBase.getPSSystemName());
        }
        if (pSSysOUTypeBase.isRootFlagDirty() && (bl || pSSysOUTypeBase.getRootFlag() != null)) {
            iDataObject.set(FIELD_ROOTFLAG, (Object)pSSysOUTypeBase.getRootFlag());
        }
        if (pSSysOUTypeBase.isTypeCodeDirty() && (bl || pSSysOUTypeBase.getTypeCode() != null)) {
            iDataObject.set(FIELD_TYPECODE, (Object)pSSysOUTypeBase.getTypeCode());
        }
        if (pSSysOUTypeBase.isUpdateDateDirty() && (bl || pSSysOUTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysOUTypeBase.getUpdateDate());
        }
        if (pSSysOUTypeBase.isUpdateManDirty() && (bl || pSSysOUTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysOUTypeBase.getUpdateMan());
        }
        if (pSSysOUTypeBase.isUserCatDirty() && (bl || pSSysOUTypeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysOUTypeBase.getUserCat());
        }
        if (pSSysOUTypeBase.isUserTagDirty() && (bl || pSSysOUTypeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysOUTypeBase.getUserTag());
        }
        if (pSSysOUTypeBase.isUserTag2Dirty() && (bl || pSSysOUTypeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysOUTypeBase.getUserTag2());
        }
        if (pSSysOUTypeBase.isUserTag3Dirty() && (bl || pSSysOUTypeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysOUTypeBase.getUserTag3());
        }
        if (pSSysOUTypeBase.isUserTag4Dirty() && (bl || pSSysOUTypeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysOUTypeBase.getUserTag4());
        }
        if (pSSysOUTypeBase.isValidFlagDirty() && (bl || pSSysOUTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysOUTypeBase.getValidFlag());
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
        return PSSysOUTypeBase.remove(this, n);
    }

    private static boolean remove(PSSysOUTypeBase pSSysOUTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysOUTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysOUTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysOUTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysOUTypeBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSSysOUTypeBase.resetPSSysOUTypeId();
                return true;
            }
            case 5: {
                pSSysOUTypeBase.resetPSSysOUTypeName();
                return true;
            }
            case 6: {
                pSSysOUTypeBase.resetPSSystemId();
                return true;
            }
            case 7: {
                pSSysOUTypeBase.resetPSSystemName();
                return true;
            }
            case 8: {
                pSSysOUTypeBase.resetRootFlag();
                return true;
            }
            case 9: {
                pSSysOUTypeBase.resetTypeCode();
                return true;
            }
            case 10: {
                pSSysOUTypeBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysOUTypeBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSysOUTypeBase.resetUserCat();
                return true;
            }
            case 13: {
                pSSysOUTypeBase.resetUserTag();
                return true;
            }
            case 14: {
                pSSysOUTypeBase.resetUserTag2();
                return true;
            }
            case 15: {
                pSSysOUTypeBase.resetUserTag3();
                return true;
            }
            case 16: {
                pSSysOUTypeBase.resetUserTag4();
                return true;
            }
            case 17: {
                pSSysOUTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSSysOUTypeBase getProxyEntity() {
        return this.proxyPSSysOUTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysOUTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysOUTypeBase) {
            this.proxyPSSysOUTypeBase = (PSSysOUTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysOUTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PSSYSOUTYPEID, 4);
        fieldIndexMap.put(FIELD_PSSYSOUTYPENAME, 5);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 6);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 7);
        fieldIndexMap.put(FIELD_ROOTFLAG, 8);
        fieldIndexMap.put(FIELD_TYPECODE, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERCAT, 12);
        fieldIndexMap.put(FIELD_USERTAG, 13);
        fieldIndexMap.put(FIELD_USERTAG2, 14);
        fieldIndexMap.put(FIELD_USERTAG3, 15);
        fieldIndexMap.put(FIELD_USERTAG4, 16);
        fieldIndexMap.put(FIELD_VALIDFLAG, 17);
    }
}

