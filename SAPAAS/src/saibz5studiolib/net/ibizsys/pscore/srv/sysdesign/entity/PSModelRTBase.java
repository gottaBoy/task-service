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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModelRT;
import net.ibizsys.pscore.srv.sysdesign.service.PSModelRTService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelRTBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelRTBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_LEAFFLAG = "LEAFFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_METHODNAME = "METHODNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSMODELRTID = "PPSMODELRTID";
    public static final String FIELD_PPSMODELRTNAME = "PPSMODELRTNAME";
    public static final String FIELD_PSMODELRTID = "PSMODELRTID";
    public static final String FIELD_PSMODELRTNAME = "PSMODELRTNAME";
    public static final String FIELD_RTDATA = "RTDATA";
    public static final String FIELD_RTDATA2 = "RTDATA2";
    public static final String FIELD_RTTYPE = "RTTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ICONPATH = 2;
    private static final int INDEX_LEAFFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_METHODNAME = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PPSMODELRTID = 7;
    private static final int INDEX_PPSMODELRTNAME = 8;
    private static final int INDEX_PSMODELRTID = 9;
    private static final int INDEX_PSMODELRTNAME = 10;
    private static final int INDEX_RTDATA = 11;
    private static final int INDEX_RTDATA2 = 12;
    private static final int INDEX_RTTYPE = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelRTBase proxyPSModelRTBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean leafflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean methodnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsmodelrtidDirtyFlag = false;
    private boolean ppsmodelrtnameDirtyFlag = false;
    private boolean psmodelrtidDirtyFlag = false;
    private boolean psmodelrtnameDirtyFlag = false;
    private boolean rtdataDirtyFlag = false;
    private boolean rtdata2DirtyFlag = false;
    private boolean rttypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="leafflag")
    private Integer leafflag;
    @Column(name="memo")
    private String memo;
    @Column(name="methodname")
    private String methodname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppsmodelrtid")
    private String ppsmodelrtid;
    @Column(name="ppsmodelrtname")
    private String ppsmodelrtname;
    @Column(name="psmodelrtid")
    private String psmodelrtid;
    @Column(name="psmodelrtname")
    private String psmodelrtname;
    @Column(name="rtdata")
    private String rtdata;
    @Column(name="rtdata2")
    private String rtdata2;
    @Column(name="rttype")
    private String rttype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPPSModelRTLock = new Integer(1);
    private PSModelRT ppsmodelrt = null;

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

    public void setIconPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpath = string;
        this.iconpathDirtyFlag = true;
    }

    public String getIconPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPath();
        }
        return this.iconpath;
    }

    public boolean isIconPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathDirty();
        }
        return this.iconpathDirtyFlag;
    }

    public void resetIconPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPath();
            return;
        }
        this.iconpathDirtyFlag = false;
        this.iconpath = null;
    }

    public void setLeafFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeafFlag(n);
            return;
        }
        this.leafflag = n;
        this.leafflagDirtyFlag = true;
    }

    public Integer getLeafFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeafFlag();
        }
        return this.leafflag;
    }

    public boolean isLeafFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeafFlagDirty();
        }
        return this.leafflagDirtyFlag;
    }

    public void resetLeafFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeafFlag();
            return;
        }
        this.leafflagDirtyFlag = false;
        this.leafflag = null;
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

    public void setMethodName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMethodName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.methodname = string;
        this.methodnameDirtyFlag = true;
    }

    public String getMethodName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMethodName();
        }
        return this.methodname;
    }

    public boolean isMethodNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMethodNameDirty();
        }
        return this.methodnameDirtyFlag;
    }

    public void resetMethodName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMethodName();
            return;
        }
        this.methodnameDirtyFlag = false;
        this.methodname = null;
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

    public void setPPSModelRTId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSModelRTId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmodelrtid = string;
        this.ppsmodelrtidDirtyFlag = true;
    }

    public String getPPSModelRTId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelRTId();
        }
        return this.ppsmodelrtid;
    }

    public boolean isPPSModelRTIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSModelRTIdDirty();
        }
        return this.ppsmodelrtidDirtyFlag;
    }

    public void resetPPSModelRTId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSModelRTId();
            return;
        }
        this.ppsmodelrtidDirtyFlag = false;
        this.ppsmodelrtid = null;
    }

    public void setPPSModelRTName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSModelRTName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmodelrtname = string;
        this.ppsmodelrtnameDirtyFlag = true;
    }

    public String getPPSModelRTName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelRTName();
        }
        return this.ppsmodelrtname;
    }

    public boolean isPPSModelRTNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSModelRTNameDirty();
        }
        return this.ppsmodelrtnameDirtyFlag;
    }

    public void resetPPSModelRTName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSModelRTName();
            return;
        }
        this.ppsmodelrtnameDirtyFlag = false;
        this.ppsmodelrtname = null;
    }

    public void setPSModelRTId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelRTId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelrtid = string;
        this.psmodelrtidDirtyFlag = true;
    }

    public String getPSModelRTId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelRTId();
        }
        return this.psmodelrtid;
    }

    public boolean isPSModelRTIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelRTIdDirty();
        }
        return this.psmodelrtidDirtyFlag;
    }

    public void resetPSModelRTId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelRTId();
            return;
        }
        this.psmodelrtidDirtyFlag = false;
        this.psmodelrtid = null;
    }

    public void setPSModelRTName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelRTName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelrtname = string;
        this.psmodelrtnameDirtyFlag = true;
    }

    public String getPSModelRTName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelRTName();
        }
        return this.psmodelrtname;
    }

    public boolean isPSModelRTNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelRTNameDirty();
        }
        return this.psmodelrtnameDirtyFlag;
    }

    public void resetPSModelRTName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelRTName();
            return;
        }
        this.psmodelrtnameDirtyFlag = false;
        this.psmodelrtname = null;
    }

    public void setRTData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRTData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rtdata = string;
        this.rtdataDirtyFlag = true;
    }

    public String getRTData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRTData();
        }
        return this.rtdata;
    }

    public boolean isRTDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRTDataDirty();
        }
        return this.rtdataDirtyFlag;
    }

    public void resetRTData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRTData();
            return;
        }
        this.rtdataDirtyFlag = false;
        this.rtdata = null;
    }

    public void setRTData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRTData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rtdata2 = string;
        this.rtdata2DirtyFlag = true;
    }

    public String getRTData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRTData2();
        }
        return this.rtdata2;
    }

    public boolean isRTData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRTData2Dirty();
        }
        return this.rtdata2DirtyFlag;
    }

    public void resetRTData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRTData2();
            return;
        }
        this.rtdata2DirtyFlag = false;
        this.rtdata2 = null;
    }

    public void setRTType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRTType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rttype = string;
        this.rttypeDirtyFlag = true;
    }

    public String getRTType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRTType();
        }
        return this.rttype;
    }

    public boolean isRTTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRTTypeDirty();
        }
        return this.rttypeDirtyFlag;
    }

    public void resetRTType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRTType();
            return;
        }
        this.rttypeDirtyFlag = false;
        this.rttype = null;
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

    protected void onReset() {
        PSModelRTBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelRTBase pSModelRTBase) {
        pSModelRTBase.resetCreateDate();
        pSModelRTBase.resetCreateMan();
        pSModelRTBase.resetIconPath();
        pSModelRTBase.resetLeafFlag();
        pSModelRTBase.resetMemo();
        pSModelRTBase.resetMethodName();
        pSModelRTBase.resetOrderValue();
        pSModelRTBase.resetPPSModelRTId();
        pSModelRTBase.resetPPSModelRTName();
        pSModelRTBase.resetPSModelRTId();
        pSModelRTBase.resetPSModelRTName();
        pSModelRTBase.resetRTData();
        pSModelRTBase.resetRTData2();
        pSModelRTBase.resetRTType();
        pSModelRTBase.resetUpdateDate();
        pSModelRTBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isLeafFlagDirty()) {
            hashMap.put(FIELD_LEAFFLAG, this.getLeafFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMethodNameDirty()) {
            hashMap.put(FIELD_METHODNAME, this.getMethodName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSModelRTIdDirty()) {
            hashMap.put(FIELD_PPSMODELRTID, this.getPPSModelRTId());
        }
        if (!bl || this.isPPSModelRTNameDirty()) {
            hashMap.put(FIELD_PPSMODELRTNAME, this.getPPSModelRTName());
        }
        if (!bl || this.isPSModelRTIdDirty()) {
            hashMap.put(FIELD_PSMODELRTID, this.getPSModelRTId());
        }
        if (!bl || this.isPSModelRTNameDirty()) {
            hashMap.put(FIELD_PSMODELRTNAME, this.getPSModelRTName());
        }
        if (!bl || this.isRTDataDirty()) {
            hashMap.put(FIELD_RTDATA, this.getRTData());
        }
        if (!bl || this.isRTData2Dirty()) {
            hashMap.put(FIELD_RTDATA2, this.getRTData2());
        }
        if (!bl || this.isRTTypeDirty()) {
            hashMap.put(FIELD_RTTYPE, this.getRTType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSModelRTBase.get(this, n);
    }

    private static Object get(PSModelRTBase pSModelRTBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelRTBase.getCreateDate();
            }
            case 1: {
                return pSModelRTBase.getCreateMan();
            }
            case 2: {
                return pSModelRTBase.getIconPath();
            }
            case 3: {
                return pSModelRTBase.getLeafFlag();
            }
            case 4: {
                return pSModelRTBase.getMemo();
            }
            case 5: {
                return pSModelRTBase.getMethodName();
            }
            case 6: {
                return pSModelRTBase.getOrderValue();
            }
            case 7: {
                return pSModelRTBase.getPPSModelRTId();
            }
            case 8: {
                return pSModelRTBase.getPPSModelRTName();
            }
            case 9: {
                return pSModelRTBase.getPSModelRTId();
            }
            case 10: {
                return pSModelRTBase.getPSModelRTName();
            }
            case 11: {
                return pSModelRTBase.getRTData();
            }
            case 12: {
                return pSModelRTBase.getRTData2();
            }
            case 13: {
                return pSModelRTBase.getRTType();
            }
            case 14: {
                return pSModelRTBase.getUpdateDate();
            }
            case 15: {
                return pSModelRTBase.getUpdateMan();
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
        PSModelRTBase.set(this, n, object);
    }

    private static void set(PSModelRTBase pSModelRTBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelRTBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelRTBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelRTBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelRTBase.setLeafFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSModelRTBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelRTBase.setMethodName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelRTBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSModelRTBase.setPPSModelRTId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelRTBase.setPPSModelRTName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelRTBase.setPSModelRTId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelRTBase.setPSModelRTName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelRTBase.setRTData(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelRTBase.setRTData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelRTBase.setRTType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelRTBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSModelRTBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelRTBase.isNull(this, n);
    }

    private static boolean isNull(PSModelRTBase pSModelRTBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelRTBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelRTBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelRTBase.getIconPath() == null;
            }
            case 3: {
                return pSModelRTBase.getLeafFlag() == null;
            }
            case 4: {
                return pSModelRTBase.getMemo() == null;
            }
            case 5: {
                return pSModelRTBase.getMethodName() == null;
            }
            case 6: {
                return pSModelRTBase.getOrderValue() == null;
            }
            case 7: {
                return pSModelRTBase.getPPSModelRTId() == null;
            }
            case 8: {
                return pSModelRTBase.getPPSModelRTName() == null;
            }
            case 9: {
                return pSModelRTBase.getPSModelRTId() == null;
            }
            case 10: {
                return pSModelRTBase.getPSModelRTName() == null;
            }
            case 11: {
                return pSModelRTBase.getRTData() == null;
            }
            case 12: {
                return pSModelRTBase.getRTData2() == null;
            }
            case 13: {
                return pSModelRTBase.getRTType() == null;
            }
            case 14: {
                return pSModelRTBase.getUpdateDate() == null;
            }
            case 15: {
                return pSModelRTBase.getUpdateMan() == null;
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
        return PSModelRTBase.contains(this, n);
    }

    private static boolean contains(PSModelRTBase pSModelRTBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelRTBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelRTBase.isCreateManDirty();
            }
            case 2: {
                return pSModelRTBase.isIconPathDirty();
            }
            case 3: {
                return pSModelRTBase.isLeafFlagDirty();
            }
            case 4: {
                return pSModelRTBase.isMemoDirty();
            }
            case 5: {
                return pSModelRTBase.isMethodNameDirty();
            }
            case 6: {
                return pSModelRTBase.isOrderValueDirty();
            }
            case 7: {
                return pSModelRTBase.isPPSModelRTIdDirty();
            }
            case 8: {
                return pSModelRTBase.isPPSModelRTNameDirty();
            }
            case 9: {
                return pSModelRTBase.isPSModelRTIdDirty();
            }
            case 10: {
                return pSModelRTBase.isPSModelRTNameDirty();
            }
            case 11: {
                return pSModelRTBase.isRTDataDirty();
            }
            case 12: {
                return pSModelRTBase.isRTData2Dirty();
            }
            case 13: {
                return pSModelRTBase.isRTTypeDirty();
            }
            case 14: {
                return pSModelRTBase.isUpdateDateDirty();
            }
            case 15: {
                return pSModelRTBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelRTBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelRTBase pSModelRTBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelRTBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelRTBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelRTBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getIconPath()), (boolean)false);
        }
        if (bl || pSModelRTBase.getLeafFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leafflag", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getLeafFlag()), (boolean)false);
        }
        if (bl || pSModelRTBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelRTBase.getMethodName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"methodname", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getMethodName()), (boolean)false);
        }
        if (bl || pSModelRTBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModelRTBase.getPPSModelRTId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmodelrtid", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getPPSModelRTId()), (boolean)false);
        }
        if (bl || pSModelRTBase.getPPSModelRTName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmodelrtname", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getPPSModelRTName()), (boolean)false);
        }
        if (bl || pSModelRTBase.getPSModelRTId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelrtid", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getPSModelRTId()), (boolean)false);
        }
        if (bl || pSModelRTBase.getPSModelRTName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelrtname", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getPSModelRTName()), (boolean)false);
        }
        if (bl || pSModelRTBase.getRTData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtdata", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getRTData()), (boolean)false);
        }
        if (bl || pSModelRTBase.getRTData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtdata2", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getRTData2()), (boolean)false);
        }
        if (bl || pSModelRTBase.getRTType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rttype", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getRTType()), (boolean)false);
        }
        if (bl || pSModelRTBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelRTBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelRTBase.getJSONValue((Object)pSModelRTBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelRTBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelRTBase pSModelRTBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelRTBase.getCreateDate() != null) {
            object = pSModelRTBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelRTBase.getCreateMan() != null) {
            object = pSModelRTBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTBase.getIconPath() != null) {
            object = pSModelRTBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTBase.getLeafFlag() != null) {
            object = pSModelRTBase.getLeafFlag();
            xmlNode.setAttribute(FIELD_LEAFFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelRTBase.getMemo() != null) {
            object = pSModelRTBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTBase.getMethodName() != null) {
            object = pSModelRTBase.getMethodName();
            xmlNode.setAttribute(FIELD_METHODNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTBase.getOrderValue() != null) {
            object = pSModelRTBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelRTBase.getPPSModelRTId() != null) {
            object = pSModelRTBase.getPPSModelRTId();
            xmlNode.setAttribute(FIELD_PPSMODELRTID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTBase.getPPSModelRTName() != null) {
            object = pSModelRTBase.getPPSModelRTName();
            xmlNode.setAttribute(FIELD_PPSMODELRTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTBase.getPSModelRTId() != null) {
            object = pSModelRTBase.getPSModelRTId();
            xmlNode.setAttribute(FIELD_PSMODELRTID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTBase.getPSModelRTName() != null) {
            object = pSModelRTBase.getPSModelRTName();
            xmlNode.setAttribute(FIELD_PSMODELRTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTBase.getRTData() != null) {
            object = pSModelRTBase.getRTData();
            xmlNode.setAttribute(FIELD_RTDATA, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTBase.getRTData2() != null) {
            object = pSModelRTBase.getRTData2();
            xmlNode.setAttribute(FIELD_RTDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTBase.getRTType() != null) {
            object = pSModelRTBase.getRTType();
            xmlNode.setAttribute(FIELD_RTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTBase.getUpdateDate() != null) {
            object = pSModelRTBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelRTBase.getUpdateMan() != null) {
            object = pSModelRTBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelRTBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelRTBase pSModelRTBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelRTBase.isCreateDateDirty() && (bl || pSModelRTBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelRTBase.getCreateDate());
        }
        if (pSModelRTBase.isCreateManDirty() && (bl || pSModelRTBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelRTBase.getCreateMan());
        }
        if (pSModelRTBase.isIconPathDirty() && (bl || pSModelRTBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSModelRTBase.getIconPath());
        }
        if (pSModelRTBase.isLeafFlagDirty() && (bl || pSModelRTBase.getLeafFlag() != null)) {
            iDataObject.set(FIELD_LEAFFLAG, (Object)pSModelRTBase.getLeafFlag());
        }
        if (pSModelRTBase.isMemoDirty() && (bl || pSModelRTBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelRTBase.getMemo());
        }
        if (pSModelRTBase.isMethodNameDirty() && (bl || pSModelRTBase.getMethodName() != null)) {
            iDataObject.set(FIELD_METHODNAME, (Object)pSModelRTBase.getMethodName());
        }
        if (pSModelRTBase.isOrderValueDirty() && (bl || pSModelRTBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModelRTBase.getOrderValue());
        }
        if (pSModelRTBase.isPPSModelRTIdDirty() && (bl || pSModelRTBase.getPPSModelRTId() != null)) {
            iDataObject.set(FIELD_PPSMODELRTID, (Object)pSModelRTBase.getPPSModelRTId());
        }
        if (pSModelRTBase.isPPSModelRTNameDirty() && (bl || pSModelRTBase.getPPSModelRTName() != null)) {
            iDataObject.set(FIELD_PPSMODELRTNAME, (Object)pSModelRTBase.getPPSModelRTName());
        }
        if (pSModelRTBase.isPSModelRTIdDirty() && (bl || pSModelRTBase.getPSModelRTId() != null)) {
            iDataObject.set(FIELD_PSMODELRTID, (Object)pSModelRTBase.getPSModelRTId());
        }
        if (pSModelRTBase.isPSModelRTNameDirty() && (bl || pSModelRTBase.getPSModelRTName() != null)) {
            iDataObject.set(FIELD_PSMODELRTNAME, (Object)pSModelRTBase.getPSModelRTName());
        }
        if (pSModelRTBase.isRTDataDirty() && (bl || pSModelRTBase.getRTData() != null)) {
            iDataObject.set(FIELD_RTDATA, (Object)pSModelRTBase.getRTData());
        }
        if (pSModelRTBase.isRTData2Dirty() && (bl || pSModelRTBase.getRTData2() != null)) {
            iDataObject.set(FIELD_RTDATA2, (Object)pSModelRTBase.getRTData2());
        }
        if (pSModelRTBase.isRTTypeDirty() && (bl || pSModelRTBase.getRTType() != null)) {
            iDataObject.set(FIELD_RTTYPE, (Object)pSModelRTBase.getRTType());
        }
        if (pSModelRTBase.isUpdateDateDirty() && (bl || pSModelRTBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelRTBase.getUpdateDate());
        }
        if (pSModelRTBase.isUpdateManDirty() && (bl || pSModelRTBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelRTBase.getUpdateMan());
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
        return PSModelRTBase.remove(this, n);
    }

    private static boolean remove(PSModelRTBase pSModelRTBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelRTBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelRTBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelRTBase.resetIconPath();
                return true;
            }
            case 3: {
                pSModelRTBase.resetLeafFlag();
                return true;
            }
            case 4: {
                pSModelRTBase.resetMemo();
                return true;
            }
            case 5: {
                pSModelRTBase.resetMethodName();
                return true;
            }
            case 6: {
                pSModelRTBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSModelRTBase.resetPPSModelRTId();
                return true;
            }
            case 8: {
                pSModelRTBase.resetPPSModelRTName();
                return true;
            }
            case 9: {
                pSModelRTBase.resetPSModelRTId();
                return true;
            }
            case 10: {
                pSModelRTBase.resetPSModelRTName();
                return true;
            }
            case 11: {
                pSModelRTBase.resetRTData();
                return true;
            }
            case 12: {
                pSModelRTBase.resetRTData2();
                return true;
            }
            case 13: {
                pSModelRTBase.resetRTType();
                return true;
            }
            case 14: {
                pSModelRTBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSModelRTBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelRT getPPSModelRT() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelRT();
        }
        if (this.getPPSModelRTId() == null) {
            return null;
        }
        Integer n = this.objPPSModelRTLock;
        synchronized (n) {
            if (this.ppsmodelrt != null && DataTypeHelper.compare((int)25, (Object)this.getPPSModelRTId(), (Object)this.ppsmodelrt.getPSModelRTId()) != 0L) {
                this.ppsmodelrt = null;
            }
            if (this.ppsmodelrt == null) {
                PSModelRT pSModelRT = new PSModelRT();
                pSModelRT.setPSModelRTId(this.getPPSModelRTId());
                PSModelRTService pSModelRTService = (PSModelRTService)ServiceGlobal.getService(PSModelRTService.class, (SessionFactory)this.getSessionFactory());
                pSModelRTService.autoGet((IEntity)pSModelRT);
                this.ppsmodelrt = pSModelRT;
            }
            return this.ppsmodelrt;
        }
    }

    private PSModelRTBase getProxyEntity() {
        return this.proxyPSModelRTBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelRTBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelRTBase) {
            this.proxyPSModelRTBase = (PSModelRTBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModelRTService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ICONPATH, 2);
        fieldIndexMap.put(FIELD_LEAFFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_METHODNAME, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PPSMODELRTID, 7);
        fieldIndexMap.put(FIELD_PPSMODELRTNAME, 8);
        fieldIndexMap.put(FIELD_PSMODELRTID, 9);
        fieldIndexMap.put(FIELD_PSMODELRTNAME, 10);
        fieldIndexMap.put(FIELD_RTDATA, 11);
        fieldIndexMap.put(FIELD_RTDATA2, 12);
        fieldIndexMap.put(FIELD_RTTYPE, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
    }
}

