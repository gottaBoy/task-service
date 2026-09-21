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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSVarSampleValueBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSVarSampleValueBase.class);
    public static final String FIELD_ALLDCFLAG = "ALLDCFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSVARSAMPLEVALUEID = "PSVARSAMPLEVALUEID";
    public static final String FIELD_PSVARSAMPLEVALUENAME = "PSVARSAMPLEVALUENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUE = "VALUE";
    public static final String FIELD_VALUE2 = "VALUE2";
    public static final String FIELD_VARCAT = "VARCAT";
    public static final String FIELD_VARTYPE = "VARTYPE";
    private static final int INDEX_ALLDCFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PSDEVCENTERID = 5;
    private static final int INDEX_PSDEVCENTERNAME = 6;
    private static final int INDEX_PSVARSAMPLEVALUEID = 7;
    private static final int INDEX_PSVARSAMPLEVALUENAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_USERTAG = 11;
    private static final int INDEX_USERTAG2 = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final int INDEX_VALUE = 14;
    private static final int INDEX_VALUE2 = 15;
    private static final int INDEX_VARCAT = 16;
    private static final int INDEX_VARTYPE = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSVarSampleValueBase proxyPSVarSampleValueBase = null;
    private boolean alldcflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psvarsamplevalueidDirtyFlag = false;
    private boolean psvarsamplevaluenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valueDirtyFlag = false;
    private boolean value2DirtyFlag = false;
    private boolean varcatDirtyFlag = false;
    private boolean vartypeDirtyFlag = false;
    @Column(name="alldcflag")
    private Integer alldcflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psvarsamplevalueid")
    private String psvarsamplevalueid;
    @Column(name="psvarsamplevaluename")
    private String psvarsamplevaluename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="value")
    private String value;
    @Column(name="value2")
    private String value2;
    @Column(name="varcat")
    private String varcat;
    @Column(name="vartype")
    private String vartype;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

    public void setAllDCFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllDCFlag(n);
            return;
        }
        this.alldcflag = n;
        this.alldcflagDirtyFlag = true;
    }

    public Integer getAllDCFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllDCFlag();
        }
        return this.alldcflag;
    }

    public boolean isAllDCFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllDCFlagDirty();
        }
        return this.alldcflagDirtyFlag;
    }

    public void resetAllDCFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllDCFlag();
            return;
        }
        this.alldcflagDirtyFlag = false;
        this.alldcflag = null;
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

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSVarSampleValueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVarSampleValueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvarsamplevalueid = string;
        this.psvarsamplevalueidDirtyFlag = true;
    }

    public String getPSVarSampleValueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVarSampleValueId();
        }
        return this.psvarsamplevalueid;
    }

    public boolean isPSVarSampleValueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVarSampleValueIdDirty();
        }
        return this.psvarsamplevalueidDirtyFlag;
    }

    public void resetPSVarSampleValueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVarSampleValueId();
            return;
        }
        this.psvarsamplevalueidDirtyFlag = false;
        this.psvarsamplevalueid = null;
    }

    public void setPSVarSampleValueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVarSampleValueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvarsamplevaluename = string;
        this.psvarsamplevaluenameDirtyFlag = true;
    }

    public String getPSVarSampleValueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVarSampleValueName();
        }
        return this.psvarsamplevaluename;
    }

    public boolean isPSVarSampleValueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVarSampleValueNameDirty();
        }
        return this.psvarsamplevaluenameDirtyFlag;
    }

    public void resetPSVarSampleValueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVarSampleValueName();
            return;
        }
        this.psvarsamplevaluenameDirtyFlag = false;
        this.psvarsamplevaluename = null;
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

    public void setValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.value = string;
        this.valueDirtyFlag = true;
    }

    public String getValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValue();
        }
        return this.value;
    }

    public boolean isValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueDirty();
        }
        return this.valueDirtyFlag;
    }

    public void resetValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValue();
            return;
        }
        this.valueDirtyFlag = false;
        this.value = null;
    }

    public void setValue2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValue2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.value2 = string;
        this.value2DirtyFlag = true;
    }

    public String getValue2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValue2();
        }
        return this.value2;
    }

    public boolean isValue2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValue2Dirty();
        }
        return this.value2DirtyFlag;
    }

    public void resetValue2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValue2();
            return;
        }
        this.value2DirtyFlag = false;
        this.value2 = null;
    }

    public void setVarCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVarCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.varcat = string;
        this.varcatDirtyFlag = true;
    }

    public String getVarCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVarCat();
        }
        return this.varcat;
    }

    public boolean isVarCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVarCatDirty();
        }
        return this.varcatDirtyFlag;
    }

    public void resetVarCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVarCat();
            return;
        }
        this.varcatDirtyFlag = false;
        this.varcat = null;
    }

    public void setVarType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVarType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vartype = string;
        this.vartypeDirtyFlag = true;
    }

    public String getVarType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVarType();
        }
        return this.vartype;
    }

    public boolean isVarTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVarTypeDirty();
        }
        return this.vartypeDirtyFlag;
    }

    public void resetVarType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVarType();
            return;
        }
        this.vartypeDirtyFlag = false;
        this.vartype = null;
    }

    protected void onReset() {
        PSVarSampleValueBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSVarSampleValueBase pSVarSampleValueBase) {
        pSVarSampleValueBase.resetAllDCFlag();
        pSVarSampleValueBase.resetCreateDate();
        pSVarSampleValueBase.resetCreateMan();
        pSVarSampleValueBase.resetMemo();
        pSVarSampleValueBase.resetOrderValue();
        pSVarSampleValueBase.resetPSDevCenterId();
        pSVarSampleValueBase.resetPSDevCenterName();
        pSVarSampleValueBase.resetPSVarSampleValueId();
        pSVarSampleValueBase.resetPSVarSampleValueName();
        pSVarSampleValueBase.resetUpdateDate();
        pSVarSampleValueBase.resetUpdateMan();
        pSVarSampleValueBase.resetUserTag();
        pSVarSampleValueBase.resetUserTag2();
        pSVarSampleValueBase.resetValidFlag();
        pSVarSampleValueBase.resetValue();
        pSVarSampleValueBase.resetValue2();
        pSVarSampleValueBase.resetVarCat();
        pSVarSampleValueBase.resetVarType();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllDCFlagDirty()) {
            hashMap.put(FIELD_ALLDCFLAG, this.getAllDCFlag());
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
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSVarSampleValueIdDirty()) {
            hashMap.put(FIELD_PSVARSAMPLEVALUEID, this.getPSVarSampleValueId());
        }
        if (!bl || this.isPSVarSampleValueNameDirty()) {
            hashMap.put(FIELD_PSVARSAMPLEVALUENAME, this.getPSVarSampleValueName());
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
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isValueDirty()) {
            hashMap.put(FIELD_VALUE, this.getValue());
        }
        if (!bl || this.isValue2Dirty()) {
            hashMap.put(FIELD_VALUE2, this.getValue2());
        }
        if (!bl || this.isVarCatDirty()) {
            hashMap.put(FIELD_VARCAT, this.getVarCat());
        }
        if (!bl || this.isVarTypeDirty()) {
            hashMap.put(FIELD_VARTYPE, this.getVarType());
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
        return PSVarSampleValueBase.get(this, n);
    }

    private static Object get(PSVarSampleValueBase pSVarSampleValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVarSampleValueBase.getAllDCFlag();
            }
            case 1: {
                return pSVarSampleValueBase.getCreateDate();
            }
            case 2: {
                return pSVarSampleValueBase.getCreateMan();
            }
            case 3: {
                return pSVarSampleValueBase.getMemo();
            }
            case 4: {
                return pSVarSampleValueBase.getOrderValue();
            }
            case 5: {
                return pSVarSampleValueBase.getPSDevCenterId();
            }
            case 6: {
                return pSVarSampleValueBase.getPSDevCenterName();
            }
            case 7: {
                return pSVarSampleValueBase.getPSVarSampleValueId();
            }
            case 8: {
                return pSVarSampleValueBase.getPSVarSampleValueName();
            }
            case 9: {
                return pSVarSampleValueBase.getUpdateDate();
            }
            case 10: {
                return pSVarSampleValueBase.getUpdateMan();
            }
            case 11: {
                return pSVarSampleValueBase.getUserTag();
            }
            case 12: {
                return pSVarSampleValueBase.getUserTag2();
            }
            case 13: {
                return pSVarSampleValueBase.getValidFlag();
            }
            case 14: {
                return pSVarSampleValueBase.getValue();
            }
            case 15: {
                return pSVarSampleValueBase.getValue2();
            }
            case 16: {
                return pSVarSampleValueBase.getVarCat();
            }
            case 17: {
                return pSVarSampleValueBase.getVarType();
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
        PSVarSampleValueBase.set(this, n, object);
    }

    private static void set(PSVarSampleValueBase pSVarSampleValueBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSVarSampleValueBase.setAllDCFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSVarSampleValueBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSVarSampleValueBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSVarSampleValueBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSVarSampleValueBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSVarSampleValueBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSVarSampleValueBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSVarSampleValueBase.setPSVarSampleValueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSVarSampleValueBase.setPSVarSampleValueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSVarSampleValueBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSVarSampleValueBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSVarSampleValueBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSVarSampleValueBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSVarSampleValueBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSVarSampleValueBase.setValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSVarSampleValueBase.setValue2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSVarSampleValueBase.setVarCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSVarSampleValueBase.setVarType(DataObject.getStringValue((Object)object));
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
        return PSVarSampleValueBase.isNull(this, n);
    }

    private static boolean isNull(PSVarSampleValueBase pSVarSampleValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVarSampleValueBase.getAllDCFlag() == null;
            }
            case 1: {
                return pSVarSampleValueBase.getCreateDate() == null;
            }
            case 2: {
                return pSVarSampleValueBase.getCreateMan() == null;
            }
            case 3: {
                return pSVarSampleValueBase.getMemo() == null;
            }
            case 4: {
                return pSVarSampleValueBase.getOrderValue() == null;
            }
            case 5: {
                return pSVarSampleValueBase.getPSDevCenterId() == null;
            }
            case 6: {
                return pSVarSampleValueBase.getPSDevCenterName() == null;
            }
            case 7: {
                return pSVarSampleValueBase.getPSVarSampleValueId() == null;
            }
            case 8: {
                return pSVarSampleValueBase.getPSVarSampleValueName() == null;
            }
            case 9: {
                return pSVarSampleValueBase.getUpdateDate() == null;
            }
            case 10: {
                return pSVarSampleValueBase.getUpdateMan() == null;
            }
            case 11: {
                return pSVarSampleValueBase.getUserTag() == null;
            }
            case 12: {
                return pSVarSampleValueBase.getUserTag2() == null;
            }
            case 13: {
                return pSVarSampleValueBase.getValidFlag() == null;
            }
            case 14: {
                return pSVarSampleValueBase.getValue() == null;
            }
            case 15: {
                return pSVarSampleValueBase.getValue2() == null;
            }
            case 16: {
                return pSVarSampleValueBase.getVarCat() == null;
            }
            case 17: {
                return pSVarSampleValueBase.getVarType() == null;
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
        return PSVarSampleValueBase.contains(this, n);
    }

    private static boolean contains(PSVarSampleValueBase pSVarSampleValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVarSampleValueBase.isAllDCFlagDirty();
            }
            case 1: {
                return pSVarSampleValueBase.isCreateDateDirty();
            }
            case 2: {
                return pSVarSampleValueBase.isCreateManDirty();
            }
            case 3: {
                return pSVarSampleValueBase.isMemoDirty();
            }
            case 4: {
                return pSVarSampleValueBase.isOrderValueDirty();
            }
            case 5: {
                return pSVarSampleValueBase.isPSDevCenterIdDirty();
            }
            case 6: {
                return pSVarSampleValueBase.isPSDevCenterNameDirty();
            }
            case 7: {
                return pSVarSampleValueBase.isPSVarSampleValueIdDirty();
            }
            case 8: {
                return pSVarSampleValueBase.isPSVarSampleValueNameDirty();
            }
            case 9: {
                return pSVarSampleValueBase.isUpdateDateDirty();
            }
            case 10: {
                return pSVarSampleValueBase.isUpdateManDirty();
            }
            case 11: {
                return pSVarSampleValueBase.isUserTagDirty();
            }
            case 12: {
                return pSVarSampleValueBase.isUserTag2Dirty();
            }
            case 13: {
                return pSVarSampleValueBase.isValidFlagDirty();
            }
            case 14: {
                return pSVarSampleValueBase.isValueDirty();
            }
            case 15: {
                return pSVarSampleValueBase.isValue2Dirty();
            }
            case 16: {
                return pSVarSampleValueBase.isVarCatDirty();
            }
            case 17: {
                return pSVarSampleValueBase.isVarTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSVarSampleValueBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSVarSampleValueBase pSVarSampleValueBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSVarSampleValueBase.getAllDCFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alldcflag", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getAllDCFlag()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getMemo()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getPSVarSampleValueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvarsamplevalueid", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getPSVarSampleValueId()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getPSVarSampleValueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvarsamplevaluename", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getPSVarSampleValueName()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getUserTag()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getValue()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getValue2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value2", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getValue2()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getVarCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"varcat", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getVarCat()), (boolean)false);
        }
        if (bl || pSVarSampleValueBase.getVarType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vartype", (Object)PSVarSampleValueBase.getJSONValue((Object)pSVarSampleValueBase.getVarType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSVarSampleValueBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSVarSampleValueBase pSVarSampleValueBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSVarSampleValueBase.getAllDCFlag() != null) {
            object = pSVarSampleValueBase.getAllDCFlag();
            xmlNode.setAttribute(FIELD_ALLDCFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVarSampleValueBase.getCreateDate() != null) {
            object = pSVarSampleValueBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSVarSampleValueBase.getCreateMan() != null) {
            object = pSVarSampleValueBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSVarSampleValueBase.getMemo() != null) {
            object = pSVarSampleValueBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSVarSampleValueBase.getOrderValue() != null) {
            object = pSVarSampleValueBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVarSampleValueBase.getPSDevCenterId() != null) {
            object = pSVarSampleValueBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSVarSampleValueBase.getPSDevCenterName() != null) {
            object = pSVarSampleValueBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSVarSampleValueBase.getPSVarSampleValueId() != null) {
            object = pSVarSampleValueBase.getPSVarSampleValueId();
            xmlNode.setAttribute(FIELD_PSVARSAMPLEVALUEID, object == null ? "" : (String)object);
        }
        if (bl || pSVarSampleValueBase.getPSVarSampleValueName() != null) {
            object = pSVarSampleValueBase.getPSVarSampleValueName();
            xmlNode.setAttribute(FIELD_PSVARSAMPLEVALUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSVarSampleValueBase.getUpdateDate() != null) {
            object = pSVarSampleValueBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSVarSampleValueBase.getUpdateMan() != null) {
            object = pSVarSampleValueBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSVarSampleValueBase.getUserTag() != null) {
            object = pSVarSampleValueBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSVarSampleValueBase.getUserTag2() != null) {
            object = pSVarSampleValueBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSVarSampleValueBase.getValidFlag() != null) {
            object = pSVarSampleValueBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVarSampleValueBase.getValue() != null) {
            object = pSVarSampleValueBase.getValue();
            xmlNode.setAttribute(FIELD_VALUE, object == null ? "" : (String)object);
        }
        if (bl || pSVarSampleValueBase.getValue2() != null) {
            object = pSVarSampleValueBase.getValue2();
            xmlNode.setAttribute(FIELD_VALUE2, object == null ? "" : (String)object);
        }
        if (bl || pSVarSampleValueBase.getVarCat() != null) {
            object = pSVarSampleValueBase.getVarCat();
            xmlNode.setAttribute(FIELD_VARCAT, object == null ? "" : (String)object);
        }
        if (bl || pSVarSampleValueBase.getVarType() != null) {
            object = pSVarSampleValueBase.getVarType();
            xmlNode.setAttribute(FIELD_VARTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSVarSampleValueBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSVarSampleValueBase pSVarSampleValueBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSVarSampleValueBase.isAllDCFlagDirty() && (bl || pSVarSampleValueBase.getAllDCFlag() != null)) {
            iDataObject.set(FIELD_ALLDCFLAG, (Object)pSVarSampleValueBase.getAllDCFlag());
        }
        if (pSVarSampleValueBase.isCreateDateDirty() && (bl || pSVarSampleValueBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSVarSampleValueBase.getCreateDate());
        }
        if (pSVarSampleValueBase.isCreateManDirty() && (bl || pSVarSampleValueBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSVarSampleValueBase.getCreateMan());
        }
        if (pSVarSampleValueBase.isMemoDirty() && (bl || pSVarSampleValueBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSVarSampleValueBase.getMemo());
        }
        if (pSVarSampleValueBase.isOrderValueDirty() && (bl || pSVarSampleValueBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSVarSampleValueBase.getOrderValue());
        }
        if (pSVarSampleValueBase.isPSDevCenterIdDirty() && (bl || pSVarSampleValueBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSVarSampleValueBase.getPSDevCenterId());
        }
        if (pSVarSampleValueBase.isPSDevCenterNameDirty() && (bl || pSVarSampleValueBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSVarSampleValueBase.getPSDevCenterName());
        }
        if (pSVarSampleValueBase.isPSVarSampleValueIdDirty() && (bl || pSVarSampleValueBase.getPSVarSampleValueId() != null)) {
            iDataObject.set(FIELD_PSVARSAMPLEVALUEID, (Object)pSVarSampleValueBase.getPSVarSampleValueId());
        }
        if (pSVarSampleValueBase.isPSVarSampleValueNameDirty() && (bl || pSVarSampleValueBase.getPSVarSampleValueName() != null)) {
            iDataObject.set(FIELD_PSVARSAMPLEVALUENAME, (Object)pSVarSampleValueBase.getPSVarSampleValueName());
        }
        if (pSVarSampleValueBase.isUpdateDateDirty() && (bl || pSVarSampleValueBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSVarSampleValueBase.getUpdateDate());
        }
        if (pSVarSampleValueBase.isUpdateManDirty() && (bl || pSVarSampleValueBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSVarSampleValueBase.getUpdateMan());
        }
        if (pSVarSampleValueBase.isUserTagDirty() && (bl || pSVarSampleValueBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSVarSampleValueBase.getUserTag());
        }
        if (pSVarSampleValueBase.isUserTag2Dirty() && (bl || pSVarSampleValueBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSVarSampleValueBase.getUserTag2());
        }
        if (pSVarSampleValueBase.isValidFlagDirty() && (bl || pSVarSampleValueBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSVarSampleValueBase.getValidFlag());
        }
        if (pSVarSampleValueBase.isValueDirty() && (bl || pSVarSampleValueBase.getValue() != null)) {
            iDataObject.set(FIELD_VALUE, (Object)pSVarSampleValueBase.getValue());
        }
        if (pSVarSampleValueBase.isValue2Dirty() && (bl || pSVarSampleValueBase.getValue2() != null)) {
            iDataObject.set(FIELD_VALUE2, (Object)pSVarSampleValueBase.getValue2());
        }
        if (pSVarSampleValueBase.isVarCatDirty() && (bl || pSVarSampleValueBase.getVarCat() != null)) {
            iDataObject.set(FIELD_VARCAT, (Object)pSVarSampleValueBase.getVarCat());
        }
        if (pSVarSampleValueBase.isVarTypeDirty() && (bl || pSVarSampleValueBase.getVarType() != null)) {
            iDataObject.set(FIELD_VARTYPE, (Object)pSVarSampleValueBase.getVarType());
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
        return PSVarSampleValueBase.remove(this, n);
    }

    private static boolean remove(PSVarSampleValueBase pSVarSampleValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSVarSampleValueBase.resetAllDCFlag();
                return true;
            }
            case 1: {
                pSVarSampleValueBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSVarSampleValueBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSVarSampleValueBase.resetMemo();
                return true;
            }
            case 4: {
                pSVarSampleValueBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSVarSampleValueBase.resetPSDevCenterId();
                return true;
            }
            case 6: {
                pSVarSampleValueBase.resetPSDevCenterName();
                return true;
            }
            case 7: {
                pSVarSampleValueBase.resetPSVarSampleValueId();
                return true;
            }
            case 8: {
                pSVarSampleValueBase.resetPSVarSampleValueName();
                return true;
            }
            case 9: {
                pSVarSampleValueBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSVarSampleValueBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSVarSampleValueBase.resetUserTag();
                return true;
            }
            case 12: {
                pSVarSampleValueBase.resetUserTag2();
                return true;
            }
            case 13: {
                pSVarSampleValueBase.resetValidFlag();
                return true;
            }
            case 14: {
                pSVarSampleValueBase.resetValue();
                return true;
            }
            case 15: {
                pSVarSampleValueBase.resetValue2();
                return true;
            }
            case 16: {
                pSVarSampleValueBase.resetVarCat();
                return true;
            }
            case 17: {
                pSVarSampleValueBase.resetVarType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSVarSampleValueBase getProxyEntity() {
        return this.proxyPSVarSampleValueBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSVarSampleValueBase = null;
        if (iDataObject != null && iDataObject instanceof PSVarSampleValueBase) {
            this.proxyPSVarSampleValueBase = (PSVarSampleValueBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSVarSampleValueService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLDCFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 6);
        fieldIndexMap.put(FIELD_PSVARSAMPLEVALUEID, 7);
        fieldIndexMap.put(FIELD_PSVARSAMPLEVALUENAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_USERTAG, 11);
        fieldIndexMap.put(FIELD_USERTAG2, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
        fieldIndexMap.put(FIELD_VALUE, 14);
        fieldIndexMap.put(FIELD_VALUE2, 15);
        fieldIndexMap.put(FIELD_VARCAT, 16);
        fieldIndexMap.put(FIELD_VARTYPE, 17);
    }
}

