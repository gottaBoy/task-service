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
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFStyleRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFStyleRefBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PSSFSTYLEREFID = "PSSFSTYLEREFID";
    public static final String FIELD_PSSFSTYLEREFNAME = "PSSFSTYLEREFNAME";
    public static final String FIELD_REFMODE = "REFMODE";
    public static final String FIELD_REFPSSFSTYLEID = "REFPSSFSTYLEID";
    public static final String FIELD_REFPSSFSTYLENAME = "REFPSSFSTYLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENDTIME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSSFSTYLEID = 6;
    private static final int INDEX_PSSFSTYLENAME = 7;
    private static final int INDEX_PSSFSTYLEREFID = 8;
    private static final int INDEX_PSSFSTYLEREFNAME = 9;
    private static final int INDEX_REFMODE = 10;
    private static final int INDEX_REFPSSFSTYLEID = 11;
    private static final int INDEX_REFPSSFSTYLENAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_VALIDFLAG = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFStyleRefBase proxyPSSFStyleRefBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean pssfstylerefidDirtyFlag = false;
    private boolean pssfstylerefnameDirtyFlag = false;
    private boolean refmodeDirtyFlag = false;
    private boolean refpssfstyleidDirtyFlag = false;
    private boolean refpssfstylenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="pssfstylerefid")
    private String pssfstylerefid;
    @Column(name="pssfstylerefname")
    private String pssfstylerefname;
    @Column(name="refmode")
    private String refmode;
    @Column(name="refpssfstyleid")
    private String refpssfstyleid;
    @Column(name="refpssfstylename")
    private String refpssfstylename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;
    private Integer objRefPSSFStyleLock = new Integer(1);
    private PSSFStyle refpssfstyle = null;

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
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

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
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

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
    }

    public void setPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylename = string;
        this.pssfstylenameDirtyFlag = true;
    }

    public String getPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleName();
        }
        return this.pssfstylename;
    }

    public boolean isPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleNameDirty();
        }
        return this.pssfstylenameDirtyFlag;
    }

    public void resetPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleName();
            return;
        }
        this.pssfstylenameDirtyFlag = false;
        this.pssfstylename = null;
    }

    public void setPSSFStyleRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylerefid = string;
        this.pssfstylerefidDirtyFlag = true;
    }

    public String getPSSFStyleRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleRefId();
        }
        return this.pssfstylerefid;
    }

    public boolean isPSSFStyleRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleRefIdDirty();
        }
        return this.pssfstylerefidDirtyFlag;
    }

    public void resetPSSFStyleRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleRefId();
            return;
        }
        this.pssfstylerefidDirtyFlag = false;
        this.pssfstylerefid = null;
    }

    public void setPSSFStyleRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylerefname = string;
        this.pssfstylerefnameDirtyFlag = true;
    }

    public String getPSSFStyleRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleRefName();
        }
        return this.pssfstylerefname;
    }

    public boolean isPSSFStyleRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleRefNameDirty();
        }
        return this.pssfstylerefnameDirtyFlag;
    }

    public void resetPSSFStyleRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleRefName();
            return;
        }
        this.pssfstylerefnameDirtyFlag = false;
        this.pssfstylerefname = null;
    }

    public void setRefMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmode = string;
        this.refmodeDirtyFlag = true;
    }

    public String getRefMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMode();
        }
        return this.refmode;
    }

    public boolean isRefModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModeDirty();
        }
        return this.refmodeDirtyFlag;
    }

    public void resetRefMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMode();
            return;
        }
        this.refmodeDirtyFlag = false;
        this.refmode = null;
    }

    public void setRefPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssfstyleid = string;
        this.refpssfstyleidDirtyFlag = true;
    }

    public String getRefPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSFStyleId();
        }
        return this.refpssfstyleid;
    }

    public boolean isRefPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSFStyleIdDirty();
        }
        return this.refpssfstyleidDirtyFlag;
    }

    public void resetRefPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSFStyleId();
            return;
        }
        this.refpssfstyleidDirtyFlag = false;
        this.refpssfstyleid = null;
    }

    public void setRefPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssfstylename = string;
        this.refpssfstylenameDirtyFlag = true;
    }

    public String getRefPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSFStyleName();
        }
        return this.refpssfstylename;
    }

    public boolean isRefPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSFStyleNameDirty();
        }
        return this.refpssfstylenameDirtyFlag;
    }

    public void resetRefPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSFStyleName();
            return;
        }
        this.refpssfstylenameDirtyFlag = false;
        this.refpssfstylename = null;
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
        PSSFStyleRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFStyleRefBase pSSFStyleRefBase) {
        pSSFStyleRefBase.resetBeginTime();
        pSSFStyleRefBase.resetCreateDate();
        pSSFStyleRefBase.resetCreateMan();
        pSSFStyleRefBase.resetEndTime();
        pSSFStyleRefBase.resetMemo();
        pSSFStyleRefBase.resetOrderValue();
        pSSFStyleRefBase.resetPSSFStyleId();
        pSSFStyleRefBase.resetPSSFStyleName();
        pSSFStyleRefBase.resetPSSFStyleRefId();
        pSSFStyleRefBase.resetPSSFStyleRefName();
        pSSFStyleRefBase.resetRefMode();
        pSSFStyleRefBase.resetRefPSSFStyleId();
        pSSFStyleRefBase.resetRefPSSFStyleName();
        pSSFStyleRefBase.resetUpdateDate();
        pSSFStyleRefBase.resetUpdateMan();
        pSSFStyleRefBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
        }
        if (!bl || this.isPSSFStyleRefIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEREFID, this.getPSSFStyleRefId());
        }
        if (!bl || this.isPSSFStyleRefNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLEREFNAME, this.getPSSFStyleRefName());
        }
        if (!bl || this.isRefModeDirty()) {
            hashMap.put(FIELD_REFMODE, this.getRefMode());
        }
        if (!bl || this.isRefPSSFStyleIdDirty()) {
            hashMap.put(FIELD_REFPSSFSTYLEID, this.getRefPSSFStyleId());
        }
        if (!bl || this.isRefPSSFStyleNameDirty()) {
            hashMap.put(FIELD_REFPSSFSTYLENAME, this.getRefPSSFStyleName());
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
        return PSSFStyleRefBase.get(this, n);
    }

    private static Object get(PSSFStyleRefBase pSSFStyleRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleRefBase.getBeginTime();
            }
            case 1: {
                return pSSFStyleRefBase.getCreateDate();
            }
            case 2: {
                return pSSFStyleRefBase.getCreateMan();
            }
            case 3: {
                return pSSFStyleRefBase.getEndTime();
            }
            case 4: {
                return pSSFStyleRefBase.getMemo();
            }
            case 5: {
                return pSSFStyleRefBase.getOrderValue();
            }
            case 6: {
                return pSSFStyleRefBase.getPSSFStyleId();
            }
            case 7: {
                return pSSFStyleRefBase.getPSSFStyleName();
            }
            case 8: {
                return pSSFStyleRefBase.getPSSFStyleRefId();
            }
            case 9: {
                return pSSFStyleRefBase.getPSSFStyleRefName();
            }
            case 10: {
                return pSSFStyleRefBase.getRefMode();
            }
            case 11: {
                return pSSFStyleRefBase.getRefPSSFStyleId();
            }
            case 12: {
                return pSSFStyleRefBase.getRefPSSFStyleName();
            }
            case 13: {
                return pSSFStyleRefBase.getUpdateDate();
            }
            case 14: {
                return pSSFStyleRefBase.getUpdateMan();
            }
            case 15: {
                return pSSFStyleRefBase.getValidFlag();
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
        PSSFStyleRefBase.set(this, n, object);
    }

    private static void set(PSSFStyleRefBase pSSFStyleRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFStyleRefBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFStyleRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSFStyleRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFStyleRefBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSFStyleRefBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFStyleRefBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSFStyleRefBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFStyleRefBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFStyleRefBase.setPSSFStyleRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFStyleRefBase.setPSSFStyleRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFStyleRefBase.setRefMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFStyleRefBase.setRefPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFStyleRefBase.setRefPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSFStyleRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSSFStyleRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSFStyleRefBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSFStyleRefBase.isNull(this, n);
    }

    private static boolean isNull(PSSFStyleRefBase pSSFStyleRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleRefBase.getBeginTime() == null;
            }
            case 1: {
                return pSSFStyleRefBase.getCreateDate() == null;
            }
            case 2: {
                return pSSFStyleRefBase.getCreateMan() == null;
            }
            case 3: {
                return pSSFStyleRefBase.getEndTime() == null;
            }
            case 4: {
                return pSSFStyleRefBase.getMemo() == null;
            }
            case 5: {
                return pSSFStyleRefBase.getOrderValue() == null;
            }
            case 6: {
                return pSSFStyleRefBase.getPSSFStyleId() == null;
            }
            case 7: {
                return pSSFStyleRefBase.getPSSFStyleName() == null;
            }
            case 8: {
                return pSSFStyleRefBase.getPSSFStyleRefId() == null;
            }
            case 9: {
                return pSSFStyleRefBase.getPSSFStyleRefName() == null;
            }
            case 10: {
                return pSSFStyleRefBase.getRefMode() == null;
            }
            case 11: {
                return pSSFStyleRefBase.getRefPSSFStyleId() == null;
            }
            case 12: {
                return pSSFStyleRefBase.getRefPSSFStyleName() == null;
            }
            case 13: {
                return pSSFStyleRefBase.getUpdateDate() == null;
            }
            case 14: {
                return pSSFStyleRefBase.getUpdateMan() == null;
            }
            case 15: {
                return pSSFStyleRefBase.getValidFlag() == null;
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
        return PSSFStyleRefBase.contains(this, n);
    }

    private static boolean contains(PSSFStyleRefBase pSSFStyleRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleRefBase.isBeginTimeDirty();
            }
            case 1: {
                return pSSFStyleRefBase.isCreateDateDirty();
            }
            case 2: {
                return pSSFStyleRefBase.isCreateManDirty();
            }
            case 3: {
                return pSSFStyleRefBase.isEndTimeDirty();
            }
            case 4: {
                return pSSFStyleRefBase.isMemoDirty();
            }
            case 5: {
                return pSSFStyleRefBase.isOrderValueDirty();
            }
            case 6: {
                return pSSFStyleRefBase.isPSSFStyleIdDirty();
            }
            case 7: {
                return pSSFStyleRefBase.isPSSFStyleNameDirty();
            }
            case 8: {
                return pSSFStyleRefBase.isPSSFStyleRefIdDirty();
            }
            case 9: {
                return pSSFStyleRefBase.isPSSFStyleRefNameDirty();
            }
            case 10: {
                return pSSFStyleRefBase.isRefModeDirty();
            }
            case 11: {
                return pSSFStyleRefBase.isRefPSSFStyleIdDirty();
            }
            case 12: {
                return pSSFStyleRefBase.isRefPSSFStyleNameDirty();
            }
            case 13: {
                return pSSFStyleRefBase.isUpdateDateDirty();
            }
            case 14: {
                return pSSFStyleRefBase.isUpdateManDirty();
            }
            case 15: {
                return pSSFStyleRefBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFStyleRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFStyleRefBase pSSFStyleRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFStyleRefBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSSFStyleRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFStyleRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFStyleRefBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getEndTime()), (boolean)false);
        }
        if (bl || pSSFStyleRefBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFStyleRefBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSFStyleRefBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFStyleRefBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFStyleRefBase.getPSSFStyleRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylerefid", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getPSSFStyleRefId()), (boolean)false);
        }
        if (bl || pSSFStyleRefBase.getPSSFStyleRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylerefname", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getPSSFStyleRefName()), (boolean)false);
        }
        if (bl || pSSFStyleRefBase.getRefMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmode", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getRefMode()), (boolean)false);
        }
        if (bl || pSSFStyleRefBase.getRefPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssfstyleid", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getRefPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFStyleRefBase.getRefPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssfstylename", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getRefPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFStyleRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFStyleRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFStyleRefBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSFStyleRefBase.getJSONValue((Object)pSSFStyleRefBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFStyleRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFStyleRefBase pSSFStyleRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFStyleRefBase.getBeginTime() != null) {
            object = pSSFStyleRefBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStyleRefBase.getCreateDate() != null) {
            object = pSSFStyleRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStyleRefBase.getCreateMan() != null) {
            object = pSSFStyleRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleRefBase.getEndTime() != null) {
            object = pSSFStyleRefBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStyleRefBase.getMemo() != null) {
            object = pSSFStyleRefBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleRefBase.getOrderValue() != null) {
            object = pSSFStyleRefBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleRefBase.getPSSFStyleId() != null) {
            object = pSSFStyleRefBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleRefBase.getPSSFStyleName() != null) {
            object = pSSFStyleRefBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleRefBase.getPSSFStyleRefId() != null) {
            object = pSSFStyleRefBase.getPSSFStyleRefId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEREFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleRefBase.getPSSFStyleRefName() != null) {
            object = pSSFStyleRefBase.getPSSFStyleRefName();
            xmlNode.setAttribute(FIELD_PSSFSTYLEREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleRefBase.getRefMode() != null) {
            object = pSSFStyleRefBase.getRefMode();
            xmlNode.setAttribute(FIELD_REFMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleRefBase.getRefPSSFStyleId() != null) {
            object = pSSFStyleRefBase.getRefPSSFStyleId();
            xmlNode.setAttribute(FIELD_REFPSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleRefBase.getRefPSSFStyleName() != null) {
            object = pSSFStyleRefBase.getRefPSSFStyleName();
            xmlNode.setAttribute(FIELD_REFPSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleRefBase.getUpdateDate() != null) {
            object = pSSFStyleRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStyleRefBase.getUpdateMan() != null) {
            object = pSSFStyleRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleRefBase.getValidFlag() != null) {
            object = pSSFStyleRefBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFStyleRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFStyleRefBase pSSFStyleRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFStyleRefBase.isBeginTimeDirty() && (bl || pSSFStyleRefBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSSFStyleRefBase.getBeginTime());
        }
        if (pSSFStyleRefBase.isCreateDateDirty() && (bl || pSSFStyleRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFStyleRefBase.getCreateDate());
        }
        if (pSSFStyleRefBase.isCreateManDirty() && (bl || pSSFStyleRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFStyleRefBase.getCreateMan());
        }
        if (pSSFStyleRefBase.isEndTimeDirty() && (bl || pSSFStyleRefBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSSFStyleRefBase.getEndTime());
        }
        if (pSSFStyleRefBase.isMemoDirty() && (bl || pSSFStyleRefBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFStyleRefBase.getMemo());
        }
        if (pSSFStyleRefBase.isOrderValueDirty() && (bl || pSSFStyleRefBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSFStyleRefBase.getOrderValue());
        }
        if (pSSFStyleRefBase.isPSSFStyleIdDirty() && (bl || pSSFStyleRefBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSFStyleRefBase.getPSSFStyleId());
        }
        if (pSSFStyleRefBase.isPSSFStyleNameDirty() && (bl || pSSFStyleRefBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSFStyleRefBase.getPSSFStyleName());
        }
        if (pSSFStyleRefBase.isPSSFStyleRefIdDirty() && (bl || pSSFStyleRefBase.getPSSFStyleRefId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEREFID, (Object)pSSFStyleRefBase.getPSSFStyleRefId());
        }
        if (pSSFStyleRefBase.isPSSFStyleRefNameDirty() && (bl || pSSFStyleRefBase.getPSSFStyleRefName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEREFNAME, (Object)pSSFStyleRefBase.getPSSFStyleRefName());
        }
        if (pSSFStyleRefBase.isRefModeDirty() && (bl || pSSFStyleRefBase.getRefMode() != null)) {
            iDataObject.set(FIELD_REFMODE, (Object)pSSFStyleRefBase.getRefMode());
        }
        if (pSSFStyleRefBase.isRefPSSFStyleIdDirty() && (bl || pSSFStyleRefBase.getRefPSSFStyleId() != null)) {
            iDataObject.set(FIELD_REFPSSFSTYLEID, (Object)pSSFStyleRefBase.getRefPSSFStyleId());
        }
        if (pSSFStyleRefBase.isRefPSSFStyleNameDirty() && (bl || pSSFStyleRefBase.getRefPSSFStyleName() != null)) {
            iDataObject.set(FIELD_REFPSSFSTYLENAME, (Object)pSSFStyleRefBase.getRefPSSFStyleName());
        }
        if (pSSFStyleRefBase.isUpdateDateDirty() && (bl || pSSFStyleRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFStyleRefBase.getUpdateDate());
        }
        if (pSSFStyleRefBase.isUpdateManDirty() && (bl || pSSFStyleRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFStyleRefBase.getUpdateMan());
        }
        if (pSSFStyleRefBase.isValidFlagDirty() && (bl || pSSFStyleRefBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSFStyleRefBase.getValidFlag());
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
        return PSSFStyleRefBase.remove(this, n);
    }

    private static boolean remove(PSSFStyleRefBase pSSFStyleRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFStyleRefBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSSFStyleRefBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSFStyleRefBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSFStyleRefBase.resetEndTime();
                return true;
            }
            case 4: {
                pSSFStyleRefBase.resetMemo();
                return true;
            }
            case 5: {
                pSSFStyleRefBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSSFStyleRefBase.resetPSSFStyleId();
                return true;
            }
            case 7: {
                pSSFStyleRefBase.resetPSSFStyleName();
                return true;
            }
            case 8: {
                pSSFStyleRefBase.resetPSSFStyleRefId();
                return true;
            }
            case 9: {
                pSSFStyleRefBase.resetPSSFStyleRefName();
                return true;
            }
            case 10: {
                pSSFStyleRefBase.resetRefMode();
                return true;
            }
            case 11: {
                pSSFStyleRefBase.resetRefPSSFStyleId();
                return true;
            }
            case 12: {
                pSSFStyleRefBase.resetRefPSSFStyleName();
                return true;
            }
            case 13: {
                pSSFStyleRefBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSSFStyleRefBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSSFStyleRefBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyle();
        }
        if (this.getPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleLock;
        synchronized (n) {
            if (this.pssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleId(), (Object)this.pssfstyle.getPSSFStyleId()) != 0L) {
                this.pssfstyle = null;
            }
            if (this.pssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet(pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getRefPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSFStyle();
        }
        if (this.getRefPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objRefPSSFStyleLock;
        synchronized (n) {
            if (this.refpssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSSFStyleId(), (Object)this.refpssfstyle.getPSSFStyleId()) != 0L) {
                this.refpssfstyle = null;
            }
            if (this.refpssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getRefPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet(pSSFStyle);
                this.refpssfstyle = pSSFStyle;
            }
            return this.refpssfstyle;
        }
    }

    private PSSFStyleRefBase getProxyEntity() {
        return this.proxyPSSFStyleRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFStyleRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFStyleRefBase) {
            this.proxyPSSFStyleRefBase = (PSSFStyleRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENDTIME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 6);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 7);
        fieldIndexMap.put(FIELD_PSSFSTYLEREFID, 8);
        fieldIndexMap.put(FIELD_PSSFSTYLEREFNAME, 9);
        fieldIndexMap.put(FIELD_REFMODE, 10);
        fieldIndexMap.put(FIELD_REFPSSFSTYLEID, 11);
        fieldIndexMap.put(FIELD_REFPSSFSTYLENAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_VALIDFLAG, 15);
    }
}

