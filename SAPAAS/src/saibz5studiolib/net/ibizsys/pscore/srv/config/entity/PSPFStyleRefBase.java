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
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFStyleRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFStyleRefBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSPFSTYLEREFID = "PSPFSTYLEREFID";
    public static final String FIELD_PSPFSTYLEREFNAME = "PSPFSTYLEREFNAME";
    public static final String FIELD_REFMODE = "REFMODE";
    public static final String FIELD_REFPFPFSTYLEID = "REFPSPFSTYLEID";
    public static final String FIELD_REFPFPFSTYLENAME = "REFPSPFSTYLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENDTIME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSPFSTYLEID = 6;
    private static final int INDEX_PSPFSTYLENAME = 7;
    private static final int INDEX_PSPFSTYLEREFID = 8;
    private static final int INDEX_PSPFSTYLEREFNAME = 9;
    private static final int INDEX_REFMODE = 10;
    private static final int INDEX_REFPFPFSTYLEID = 11;
    private static final int INDEX_REFPFPFSTYLENAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_VALIDFLAG = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFStyleRefBase proxyPSPFStyleRefBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pspfstylerefidDirtyFlag = false;
    private boolean pspfstylerefnameDirtyFlag = false;
    private boolean refmodeDirtyFlag = false;
    private boolean refpfpfstyleidDirtyFlag = false;
    private boolean refpfpfstylenameDirtyFlag = false;
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
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="pspfstylerefid")
    private String pspfstylerefid;
    @Column(name="pspfstylerefname")
    private String pspfstylerefname;
    @Column(name="refmode")
    private String refmode;
    @Column(name="refpfpfstyleid")
    private String refpfpfstyleid;
    @Column(name="refpfpfstylename")
    private String refpfpfstylename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objRefPSPFStyleLock = new Integer(1);
    private PSPFStyle refpspfstyle = null;

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

    public void setPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleid = string;
        this.pspfstyleidDirtyFlag = true;
    }

    public String getPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleId();
        }
        return this.pspfstyleid;
    }

    public boolean isPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleIdDirty();
        }
        return this.pspfstyleidDirtyFlag;
    }

    public void resetPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleId();
            return;
        }
        this.pspfstyleidDirtyFlag = false;
        this.pspfstyleid = null;
    }

    public void setPSPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylename = string;
        this.pspfstylenameDirtyFlag = true;
    }

    public String getPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleName();
        }
        return this.pspfstylename;
    }

    public boolean isPSPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleNameDirty();
        }
        return this.pspfstylenameDirtyFlag;
    }

    public void resetPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleName();
            return;
        }
        this.pspfstylenameDirtyFlag = false;
        this.pspfstylename = null;
    }

    public void setPSPFStyleRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylerefid = string;
        this.pspfstylerefidDirtyFlag = true;
    }

    public String getPSPFStyleRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleRefId();
        }
        return this.pspfstylerefid;
    }

    public boolean isPSPFStyleRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleRefIdDirty();
        }
        return this.pspfstylerefidDirtyFlag;
    }

    public void resetPSPFStyleRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleRefId();
            return;
        }
        this.pspfstylerefidDirtyFlag = false;
        this.pspfstylerefid = null;
    }

    public void setPSPFStyleRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylerefname = string;
        this.pspfstylerefnameDirtyFlag = true;
    }

    public String getPSPFStyleRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleRefName();
        }
        return this.pspfstylerefname;
    }

    public boolean isPSPFStyleRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleRefNameDirty();
        }
        return this.pspfstylerefnameDirtyFlag;
    }

    public void resetPSPFStyleRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleRefName();
            return;
        }
        this.pspfstylerefnameDirtyFlag = false;
        this.pspfstylerefname = null;
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

    public void setRefPFPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPFPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpfpfstyleid = string;
        this.refpfpfstyleidDirtyFlag = true;
    }

    public String getRefPFPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPFPFStyleId();
        }
        return this.refpfpfstyleid;
    }

    public boolean isRefPFPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPFPFStyleIdDirty();
        }
        return this.refpfpfstyleidDirtyFlag;
    }

    public void resetRefPFPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPFPFStyleId();
            return;
        }
        this.refpfpfstyleidDirtyFlag = false;
        this.refpfpfstyleid = null;
    }

    public void setRefPFPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPFPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpfpfstylename = string;
        this.refpfpfstylenameDirtyFlag = true;
    }

    public String getRefPFPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPFPFStyleName();
        }
        return this.refpfpfstylename;
    }

    public boolean isRefPFPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPFPFStyleNameDirty();
        }
        return this.refpfpfstylenameDirtyFlag;
    }

    public void resetRefPFPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPFPFStyleName();
            return;
        }
        this.refpfpfstylenameDirtyFlag = false;
        this.refpfpfstylename = null;
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
        PSPFStyleRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFStyleRefBase pSPFStyleRefBase) {
        pSPFStyleRefBase.resetBeginTime();
        pSPFStyleRefBase.resetCreateDate();
        pSPFStyleRefBase.resetCreateMan();
        pSPFStyleRefBase.resetEndTime();
        pSPFStyleRefBase.resetMemo();
        pSPFStyleRefBase.resetOrderValue();
        pSPFStyleRefBase.resetPSPFStyleId();
        pSPFStyleRefBase.resetPSPFStyleName();
        pSPFStyleRefBase.resetPSPFStyleRefId();
        pSPFStyleRefBase.resetPSPFStyleRefName();
        pSPFStyleRefBase.resetRefMode();
        pSPFStyleRefBase.resetRefPFPFStyleId();
        pSPFStyleRefBase.resetRefPFPFStyleName();
        pSPFStyleRefBase.resetUpdateDate();
        pSPFStyleRefBase.resetUpdateMan();
        pSPFStyleRefBase.resetValidFlag();
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
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
        }
        if (!bl || this.isPSPFStyleRefIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEREFID, this.getPSPFStyleRefId());
        }
        if (!bl || this.isPSPFStyleRefNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLEREFNAME, this.getPSPFStyleRefName());
        }
        if (!bl || this.isRefModeDirty()) {
            hashMap.put(FIELD_REFMODE, this.getRefMode());
        }
        if (!bl || this.isRefPFPFStyleIdDirty()) {
            hashMap.put(FIELD_REFPFPFSTYLEID, this.getRefPFPFStyleId());
        }
        if (!bl || this.isRefPFPFStyleNameDirty()) {
            hashMap.put(FIELD_REFPFPFSTYLENAME, this.getRefPFPFStyleName());
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
        return PSPFStyleRefBase.get(this, n);
    }

    private static Object get(PSPFStyleRefBase pSPFStyleRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStyleRefBase.getBeginTime();
            }
            case 1: {
                return pSPFStyleRefBase.getCreateDate();
            }
            case 2: {
                return pSPFStyleRefBase.getCreateMan();
            }
            case 3: {
                return pSPFStyleRefBase.getEndTime();
            }
            case 4: {
                return pSPFStyleRefBase.getMemo();
            }
            case 5: {
                return pSPFStyleRefBase.getOrderValue();
            }
            case 6: {
                return pSPFStyleRefBase.getPSPFStyleId();
            }
            case 7: {
                return pSPFStyleRefBase.getPSPFStyleName();
            }
            case 8: {
                return pSPFStyleRefBase.getPSPFStyleRefId();
            }
            case 9: {
                return pSPFStyleRefBase.getPSPFStyleRefName();
            }
            case 10: {
                return pSPFStyleRefBase.getRefMode();
            }
            case 11: {
                return pSPFStyleRefBase.getRefPFPFStyleId();
            }
            case 12: {
                return pSPFStyleRefBase.getRefPFPFStyleName();
            }
            case 13: {
                return pSPFStyleRefBase.getUpdateDate();
            }
            case 14: {
                return pSPFStyleRefBase.getUpdateMan();
            }
            case 15: {
                return pSPFStyleRefBase.getValidFlag();
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
        PSPFStyleRefBase.set(this, n, object);
    }

    private static void set(PSPFStyleRefBase pSPFStyleRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFStyleRefBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFStyleRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSPFStyleRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFStyleRefBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSPFStyleRefBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFStyleRefBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSPFStyleRefBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFStyleRefBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFStyleRefBase.setPSPFStyleRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFStyleRefBase.setPSPFStyleRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFStyleRefBase.setRefMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFStyleRefBase.setRefPFPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFStyleRefBase.setRefPFPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFStyleRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSPFStyleRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFStyleRefBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSPFStyleRefBase.isNull(this, n);
    }

    private static boolean isNull(PSPFStyleRefBase pSPFStyleRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStyleRefBase.getBeginTime() == null;
            }
            case 1: {
                return pSPFStyleRefBase.getCreateDate() == null;
            }
            case 2: {
                return pSPFStyleRefBase.getCreateMan() == null;
            }
            case 3: {
                return pSPFStyleRefBase.getEndTime() == null;
            }
            case 4: {
                return pSPFStyleRefBase.getMemo() == null;
            }
            case 5: {
                return pSPFStyleRefBase.getOrderValue() == null;
            }
            case 6: {
                return pSPFStyleRefBase.getPSPFStyleId() == null;
            }
            case 7: {
                return pSPFStyleRefBase.getPSPFStyleName() == null;
            }
            case 8: {
                return pSPFStyleRefBase.getPSPFStyleRefId() == null;
            }
            case 9: {
                return pSPFStyleRefBase.getPSPFStyleRefName() == null;
            }
            case 10: {
                return pSPFStyleRefBase.getRefMode() == null;
            }
            case 11: {
                return pSPFStyleRefBase.getRefPFPFStyleId() == null;
            }
            case 12: {
                return pSPFStyleRefBase.getRefPFPFStyleName() == null;
            }
            case 13: {
                return pSPFStyleRefBase.getUpdateDate() == null;
            }
            case 14: {
                return pSPFStyleRefBase.getUpdateMan() == null;
            }
            case 15: {
                return pSPFStyleRefBase.getValidFlag() == null;
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
        return PSPFStyleRefBase.contains(this, n);
    }

    private static boolean contains(PSPFStyleRefBase pSPFStyleRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStyleRefBase.isBeginTimeDirty();
            }
            case 1: {
                return pSPFStyleRefBase.isCreateDateDirty();
            }
            case 2: {
                return pSPFStyleRefBase.isCreateManDirty();
            }
            case 3: {
                return pSPFStyleRefBase.isEndTimeDirty();
            }
            case 4: {
                return pSPFStyleRefBase.isMemoDirty();
            }
            case 5: {
                return pSPFStyleRefBase.isOrderValueDirty();
            }
            case 6: {
                return pSPFStyleRefBase.isPSPFStyleIdDirty();
            }
            case 7: {
                return pSPFStyleRefBase.isPSPFStyleNameDirty();
            }
            case 8: {
                return pSPFStyleRefBase.isPSPFStyleRefIdDirty();
            }
            case 9: {
                return pSPFStyleRefBase.isPSPFStyleRefNameDirty();
            }
            case 10: {
                return pSPFStyleRefBase.isRefModeDirty();
            }
            case 11: {
                return pSPFStyleRefBase.isRefPFPFStyleIdDirty();
            }
            case 12: {
                return pSPFStyleRefBase.isRefPFPFStyleNameDirty();
            }
            case 13: {
                return pSPFStyleRefBase.isUpdateDateDirty();
            }
            case 14: {
                return pSPFStyleRefBase.isUpdateManDirty();
            }
            case 15: {
                return pSPFStyleRefBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFStyleRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFStyleRefBase pSPFStyleRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFStyleRefBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSPFStyleRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFStyleRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFStyleRefBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getEndTime()), (boolean)false);
        }
        if (bl || pSPFStyleRefBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFStyleRefBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSPFStyleRefBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFStyleRefBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFStyleRefBase.getPSPFStyleRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylerefid", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getPSPFStyleRefId()), (boolean)false);
        }
        if (bl || pSPFStyleRefBase.getPSPFStyleRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylerefname", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getPSPFStyleRefName()), (boolean)false);
        }
        if (bl || pSPFStyleRefBase.getRefMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmode", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getRefMode()), (boolean)false);
        }
        if (bl || pSPFStyleRefBase.getRefPFPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpspfstyleid", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getRefPFPFStyleId()), (boolean)false);
        }
        if (bl || pSPFStyleRefBase.getRefPFPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpspfstylename", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getRefPFPFStyleName()), (boolean)false);
        }
        if (bl || pSPFStyleRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFStyleRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPFStyleRefBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSPFStyleRefBase.getJSONValue((Object)pSPFStyleRefBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFStyleRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFStyleRefBase pSPFStyleRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFStyleRefBase.getBeginTime() != null) {
            object = pSPFStyleRefBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFStyleRefBase.getCreateDate() != null) {
            object = pSPFStyleRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFStyleRefBase.getCreateMan() != null) {
            object = pSPFStyleRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleRefBase.getEndTime() != null) {
            object = pSPFStyleRefBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFStyleRefBase.getMemo() != null) {
            object = pSPFStyleRefBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleRefBase.getOrderValue() != null) {
            object = pSPFStyleRefBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFStyleRefBase.getPSPFStyleId() != null) {
            object = pSPFStyleRefBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleRefBase.getPSPFStyleName() != null) {
            object = pSPFStyleRefBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleRefBase.getPSPFStyleRefId() != null) {
            object = pSPFStyleRefBase.getPSPFStyleRefId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEREFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleRefBase.getPSPFStyleRefName() != null) {
            object = pSPFStyleRefBase.getPSPFStyleRefName();
            xmlNode.setAttribute(FIELD_PSPFSTYLEREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleRefBase.getRefMode() != null) {
            object = pSPFStyleRefBase.getRefMode();
            xmlNode.setAttribute(FIELD_REFMODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleRefBase.getRefPFPFStyleId() != null) {
            object = pSPFStyleRefBase.getRefPFPFStyleId();
            xmlNode.setAttribute("REFPFPFSTYLEID", object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleRefBase.getRefPFPFStyleName() != null) {
            object = pSPFStyleRefBase.getRefPFPFStyleName();
            xmlNode.setAttribute("REFPFPFSTYLENAME", object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleRefBase.getUpdateDate() != null) {
            object = pSPFStyleRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFStyleRefBase.getUpdateMan() != null) {
            object = pSPFStyleRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFStyleRefBase.getValidFlag() != null) {
            object = pSPFStyleRefBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFStyleRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFStyleRefBase pSPFStyleRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFStyleRefBase.isBeginTimeDirty() && (bl || pSPFStyleRefBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSPFStyleRefBase.getBeginTime());
        }
        if (pSPFStyleRefBase.isCreateDateDirty() && (bl || pSPFStyleRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFStyleRefBase.getCreateDate());
        }
        if (pSPFStyleRefBase.isCreateManDirty() && (bl || pSPFStyleRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFStyleRefBase.getCreateMan());
        }
        if (pSPFStyleRefBase.isEndTimeDirty() && (bl || pSPFStyleRefBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSPFStyleRefBase.getEndTime());
        }
        if (pSPFStyleRefBase.isMemoDirty() && (bl || pSPFStyleRefBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFStyleRefBase.getMemo());
        }
        if (pSPFStyleRefBase.isOrderValueDirty() && (bl || pSPFStyleRefBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSPFStyleRefBase.getOrderValue());
        }
        if (pSPFStyleRefBase.isPSPFStyleIdDirty() && (bl || pSPFStyleRefBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFStyleRefBase.getPSPFStyleId());
        }
        if (pSPFStyleRefBase.isPSPFStyleNameDirty() && (bl || pSPFStyleRefBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFStyleRefBase.getPSPFStyleName());
        }
        if (pSPFStyleRefBase.isPSPFStyleRefIdDirty() && (bl || pSPFStyleRefBase.getPSPFStyleRefId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEREFID, (Object)pSPFStyleRefBase.getPSPFStyleRefId());
        }
        if (pSPFStyleRefBase.isPSPFStyleRefNameDirty() && (bl || pSPFStyleRefBase.getPSPFStyleRefName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEREFNAME, (Object)pSPFStyleRefBase.getPSPFStyleRefName());
        }
        if (pSPFStyleRefBase.isRefModeDirty() && (bl || pSPFStyleRefBase.getRefMode() != null)) {
            iDataObject.set(FIELD_REFMODE, (Object)pSPFStyleRefBase.getRefMode());
        }
        if (pSPFStyleRefBase.isRefPFPFStyleIdDirty() && (bl || pSPFStyleRefBase.getRefPFPFStyleId() != null)) {
            iDataObject.set(FIELD_REFPFPFSTYLEID, (Object)pSPFStyleRefBase.getRefPFPFStyleId());
        }
        if (pSPFStyleRefBase.isRefPFPFStyleNameDirty() && (bl || pSPFStyleRefBase.getRefPFPFStyleName() != null)) {
            iDataObject.set(FIELD_REFPFPFSTYLENAME, (Object)pSPFStyleRefBase.getRefPFPFStyleName());
        }
        if (pSPFStyleRefBase.isUpdateDateDirty() && (bl || pSPFStyleRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFStyleRefBase.getUpdateDate());
        }
        if (pSPFStyleRefBase.isUpdateManDirty() && (bl || pSPFStyleRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFStyleRefBase.getUpdateMan());
        }
        if (pSPFStyleRefBase.isValidFlagDirty() && (bl || pSPFStyleRefBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSPFStyleRefBase.getValidFlag());
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
        return PSPFStyleRefBase.remove(this, n);
    }

    private static boolean remove(PSPFStyleRefBase pSPFStyleRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFStyleRefBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSPFStyleRefBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSPFStyleRefBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSPFStyleRefBase.resetEndTime();
                return true;
            }
            case 4: {
                pSPFStyleRefBase.resetMemo();
                return true;
            }
            case 5: {
                pSPFStyleRefBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSPFStyleRefBase.resetPSPFStyleId();
                return true;
            }
            case 7: {
                pSPFStyleRefBase.resetPSPFStyleName();
                return true;
            }
            case 8: {
                pSPFStyleRefBase.resetPSPFStyleRefId();
                return true;
            }
            case 9: {
                pSPFStyleRefBase.resetPSPFStyleRefName();
                return true;
            }
            case 10: {
                pSPFStyleRefBase.resetRefMode();
                return true;
            }
            case 11: {
                pSPFStyleRefBase.resetRefPFPFStyleId();
                return true;
            }
            case 12: {
                pSPFStyleRefBase.resetRefPFPFStyleName();
                return true;
            }
            case 13: {
                pSPFStyleRefBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSPFStyleRefBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSPFStyleRefBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFStyle getPSPFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyle();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSPFStyleLock;
        synchronized (n) {
            if (this.pspfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFStyleId(), (Object)this.pspfstyle.getPSPFStyleId()) != 0L) {
                this.pspfstyle = null;
            }
            if (this.pspfstyle == null) {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(this.getPSPFStyleId());
                PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSPFStyleService.autoGet(pSPFStyle);
                this.pspfstyle = pSPFStyle;
            }
            return this.pspfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFStyle getRefPSPFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSPFStyle();
        }
        if (this.getRefPFPFStyleId() == null) {
            return null;
        }
        Integer n = this.objRefPSPFStyleLock;
        synchronized (n) {
            if (this.refpspfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getRefPFPFStyleId(), (Object)this.refpspfstyle.getPSPFStyleId()) != 0L) {
                this.refpspfstyle = null;
            }
            if (this.refpspfstyle == null) {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(this.getRefPFPFStyleId());
                PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSPFStyleService.autoGet(pSPFStyle);
                this.refpspfstyle = pSPFStyle;
            }
            return this.refpspfstyle;
        }
    }

    private PSPFStyleRefBase getProxyEntity() {
        return this.proxyPSPFStyleRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFStyleRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFStyleRefBase) {
            this.proxyPSPFStyleRefBase = (PSPFStyleRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 6);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 7);
        fieldIndexMap.put(FIELD_PSPFSTYLEREFID, 8);
        fieldIndexMap.put(FIELD_PSPFSTYLEREFNAME, 9);
        fieldIndexMap.put(FIELD_REFMODE, 10);
        fieldIndexMap.put(FIELD_REFPFPFSTYLEID, 11);
        fieldIndexMap.put(FIELD_REFPFPFSTYLENAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_VALIDFLAG, 15);
    }
}

