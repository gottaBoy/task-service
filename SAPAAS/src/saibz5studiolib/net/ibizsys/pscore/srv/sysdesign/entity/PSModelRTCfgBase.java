/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelRTCfgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelRTCfgBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELRTCFGID = "PSMODELRTCFGID";
    public static final String FIELD_PSMODELRTCFGNAME = "PSMODELRTCFGNAME";
    public static final String FIELD_PSMODELTYPE = "PSMODELTYPE";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_RTMODEL = "RTMODEL";
    public static final String FIELD_RTMODELID = "RTMODELID";
    public static final String FIELD_RTMODELPATH = "RTMODELPATH";
    public static final String FIELD_RTTAG = "RTTAG";
    public static final String FIELD_RTTAG2 = "RTTAG2";
    public static final String FIELD_RTTYPE = "RTTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PSDYNAINSTID = 4;
    private static final int INDEX_PSMODELID = 5;
    private static final int INDEX_PSMODELRTCFGID = 6;
    private static final int INDEX_PSMODELRTCFGNAME = 7;
    private static final int INDEX_PSMODELTYPE = 8;
    private static final int INDEX_PSSYSTEMID = 9;
    private static final int INDEX_RTMODEL = 10;
    private static final int INDEX_RTMODELID = 11;
    private static final int INDEX_RTMODELPATH = 12;
    private static final int INDEX_RTTAG = 13;
    private static final int INDEX_RTTAG2 = 14;
    private static final int INDEX_RTTYPE = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelRTCfgBase proxyPSModelRTCfgBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelrtcfgidDirtyFlag = false;
    private boolean psmodelrtcfgnameDirtyFlag = false;
    private boolean psmodeltypeDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean rtmodelDirtyFlag = false;
    private boolean rtmodelidDirtyFlag = false;
    private boolean rtmodelpathDirtyFlag = false;
    private boolean rttagDirtyFlag = false;
    private boolean rttag2DirtyFlag = false;
    private boolean rttypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelrtcfgid")
    private String psmodelrtcfgid;
    @Column(name="psmodelrtcfgname")
    private String psmodelrtcfgname;
    @Column(name="psmodeltype")
    private String psmodeltype;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="rtmodel")
    private String rtmodel;
    @Column(name="rtmodelid")
    private String rtmodelid;
    @Column(name="rtmodelpath")
    private String rtmodelpath;
    @Column(name="rttag")
    private String rttag;
    @Column(name="rttag2")
    private String rttag2;
    @Column(name="rttype")
    private String rttype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

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

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelid = string;
        this.psmodelidDirtyFlag = true;
    }

    public String getPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelId();
        }
        return this.psmodelid;
    }

    public boolean isPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelIdDirty();
        }
        return this.psmodelidDirtyFlag;
    }

    public void resetPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelId();
            return;
        }
        this.psmodelidDirtyFlag = false;
        this.psmodelid = null;
    }

    public void setPSModelRTCfgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelRTCfgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelrtcfgid = string;
        this.psmodelrtcfgidDirtyFlag = true;
    }

    public String getPSModelRTCfgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelRTCfgId();
        }
        return this.psmodelrtcfgid;
    }

    public boolean isPSModelRTCfgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelRTCfgIdDirty();
        }
        return this.psmodelrtcfgidDirtyFlag;
    }

    public void resetPSModelRTCfgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelRTCfgId();
            return;
        }
        this.psmodelrtcfgidDirtyFlag = false;
        this.psmodelrtcfgid = null;
    }

    public void setPSModelRTCfgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelRTCfgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelrtcfgname = string;
        this.psmodelrtcfgnameDirtyFlag = true;
    }

    public String getPSModelRTCfgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelRTCfgName();
        }
        return this.psmodelrtcfgname;
    }

    public boolean isPSModelRTCfgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelRTCfgNameDirty();
        }
        return this.psmodelrtcfgnameDirtyFlag;
    }

    public void resetPSModelRTCfgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelRTCfgName();
            return;
        }
        this.psmodelrtcfgnameDirtyFlag = false;
        this.psmodelrtcfgname = null;
    }

    public void setPSModelType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodeltype = string;
        this.psmodeltypeDirtyFlag = true;
    }

    public String getPSModelType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelType();
        }
        return this.psmodeltype;
    }

    public boolean isPSModelTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelTypeDirty();
        }
        return this.psmodeltypeDirtyFlag;
    }

    public void resetPSModelType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelType();
            return;
        }
        this.psmodeltypeDirtyFlag = false;
        this.psmodeltype = null;
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

    public void setRTModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRTModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rtmodel = string;
        this.rtmodelDirtyFlag = true;
    }

    public String getRTModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRTModel();
        }
        return this.rtmodel;
    }

    public boolean isRTModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRTModelDirty();
        }
        return this.rtmodelDirtyFlag;
    }

    public void resetRTModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRTModel();
            return;
        }
        this.rtmodelDirtyFlag = false;
        this.rtmodel = null;
    }

    public void setRTModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRTModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rtmodelid = string;
        this.rtmodelidDirtyFlag = true;
    }

    public String getRTModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRTModelId();
        }
        return this.rtmodelid;
    }

    public boolean isRTModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRTModelIdDirty();
        }
        return this.rtmodelidDirtyFlag;
    }

    public void resetRTModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRTModelId();
            return;
        }
        this.rtmodelidDirtyFlag = false;
        this.rtmodelid = null;
    }

    public void setRTModelPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRTModelPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rtmodelpath = string;
        this.rtmodelpathDirtyFlag = true;
    }

    public String getRTModelPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRTModelPath();
        }
        return this.rtmodelpath;
    }

    public boolean isRTModelPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRTModelPathDirty();
        }
        return this.rtmodelpathDirtyFlag;
    }

    public void resetRTModelPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRTModelPath();
            return;
        }
        this.rtmodelpathDirtyFlag = false;
        this.rtmodelpath = null;
    }

    public void setRTTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRTTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rttag = string;
        this.rttagDirtyFlag = true;
    }

    public String getRTTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRTTag();
        }
        return this.rttag;
    }

    public boolean isRTTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRTTagDirty();
        }
        return this.rttagDirtyFlag;
    }

    public void resetRTTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRTTag();
            return;
        }
        this.rttagDirtyFlag = false;
        this.rttag = null;
    }

    public void setRTTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRTTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rttag2 = string;
        this.rttag2DirtyFlag = true;
    }

    public String getRTTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRTTag2();
        }
        return this.rttag2;
    }

    public boolean isRTTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRTTag2Dirty();
        }
        return this.rttag2DirtyFlag;
    }

    public void resetRTTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRTTag2();
            return;
        }
        this.rttag2DirtyFlag = false;
        this.rttag2 = null;
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
        PSModelRTCfgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelRTCfgBase pSModelRTCfgBase) {
        pSModelRTCfgBase.resetCreateDate();
        pSModelRTCfgBase.resetCreateMan();
        pSModelRTCfgBase.resetMemo();
        pSModelRTCfgBase.resetOrderValue();
        pSModelRTCfgBase.resetPSDynaInstId();
        pSModelRTCfgBase.resetPSModelId();
        pSModelRTCfgBase.resetPSModelRTCfgId();
        pSModelRTCfgBase.resetPSModelRTCfgName();
        pSModelRTCfgBase.resetPSModelType();
        pSModelRTCfgBase.resetPSSystemId();
        pSModelRTCfgBase.resetRTModel();
        pSModelRTCfgBase.resetRTModelId();
        pSModelRTCfgBase.resetRTModelPath();
        pSModelRTCfgBase.resetRTTag();
        pSModelRTCfgBase.resetRTTag2();
        pSModelRTCfgBase.resetRTType();
        pSModelRTCfgBase.resetUpdateDate();
        pSModelRTCfgBase.resetUpdateMan();
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
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelRTCfgIdDirty()) {
            hashMap.put(FIELD_PSMODELRTCFGID, this.getPSModelRTCfgId());
        }
        if (!bl || this.isPSModelRTCfgNameDirty()) {
            hashMap.put(FIELD_PSMODELRTCFGNAME, this.getPSModelRTCfgName());
        }
        if (!bl || this.isPSModelTypeDirty()) {
            hashMap.put(FIELD_PSMODELTYPE, this.getPSModelType());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isRTModelDirty()) {
            hashMap.put(FIELD_RTMODEL, this.getRTModel());
        }
        if (!bl || this.isRTModelIdDirty()) {
            hashMap.put(FIELD_RTMODELID, this.getRTModelId());
        }
        if (!bl || this.isRTModelPathDirty()) {
            hashMap.put(FIELD_RTMODELPATH, this.getRTModelPath());
        }
        if (!bl || this.isRTTagDirty()) {
            hashMap.put(FIELD_RTTAG, this.getRTTag());
        }
        if (!bl || this.isRTTag2Dirty()) {
            hashMap.put(FIELD_RTTAG2, this.getRTTag2());
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
        return PSModelRTCfgBase.get(this, n);
    }

    private static Object get(PSModelRTCfgBase pSModelRTCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelRTCfgBase.getCreateDate();
            }
            case 1: {
                return pSModelRTCfgBase.getCreateMan();
            }
            case 2: {
                return pSModelRTCfgBase.getMemo();
            }
            case 3: {
                return pSModelRTCfgBase.getOrderValue();
            }
            case 4: {
                return pSModelRTCfgBase.getPSDynaInstId();
            }
            case 5: {
                return pSModelRTCfgBase.getPSModelId();
            }
            case 6: {
                return pSModelRTCfgBase.getPSModelRTCfgId();
            }
            case 7: {
                return pSModelRTCfgBase.getPSModelRTCfgName();
            }
            case 8: {
                return pSModelRTCfgBase.getPSModelType();
            }
            case 9: {
                return pSModelRTCfgBase.getPSSystemId();
            }
            case 10: {
                return pSModelRTCfgBase.getRTModel();
            }
            case 11: {
                return pSModelRTCfgBase.getRTModelId();
            }
            case 12: {
                return pSModelRTCfgBase.getRTModelPath();
            }
            case 13: {
                return pSModelRTCfgBase.getRTTag();
            }
            case 14: {
                return pSModelRTCfgBase.getRTTag2();
            }
            case 15: {
                return pSModelRTCfgBase.getRTType();
            }
            case 16: {
                return pSModelRTCfgBase.getUpdateDate();
            }
            case 17: {
                return pSModelRTCfgBase.getUpdateMan();
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
        PSModelRTCfgBase.set(this, n, object);
    }

    private static void set(PSModelRTCfgBase pSModelRTCfgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelRTCfgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelRTCfgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelRTCfgBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelRTCfgBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSModelRTCfgBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelRTCfgBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelRTCfgBase.setPSModelRTCfgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelRTCfgBase.setPSModelRTCfgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelRTCfgBase.setPSModelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelRTCfgBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelRTCfgBase.setRTModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelRTCfgBase.setRTModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelRTCfgBase.setRTModelPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelRTCfgBase.setRTTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelRTCfgBase.setRTTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSModelRTCfgBase.setRTType(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSModelRTCfgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSModelRTCfgBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelRTCfgBase.isNull(this, n);
    }

    private static boolean isNull(PSModelRTCfgBase pSModelRTCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelRTCfgBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelRTCfgBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelRTCfgBase.getMemo() == null;
            }
            case 3: {
                return pSModelRTCfgBase.getOrderValue() == null;
            }
            case 4: {
                return pSModelRTCfgBase.getPSDynaInstId() == null;
            }
            case 5: {
                return pSModelRTCfgBase.getPSModelId() == null;
            }
            case 6: {
                return pSModelRTCfgBase.getPSModelRTCfgId() == null;
            }
            case 7: {
                return pSModelRTCfgBase.getPSModelRTCfgName() == null;
            }
            case 8: {
                return pSModelRTCfgBase.getPSModelType() == null;
            }
            case 9: {
                return pSModelRTCfgBase.getPSSystemId() == null;
            }
            case 10: {
                return pSModelRTCfgBase.getRTModel() == null;
            }
            case 11: {
                return pSModelRTCfgBase.getRTModelId() == null;
            }
            case 12: {
                return pSModelRTCfgBase.getRTModelPath() == null;
            }
            case 13: {
                return pSModelRTCfgBase.getRTTag() == null;
            }
            case 14: {
                return pSModelRTCfgBase.getRTTag2() == null;
            }
            case 15: {
                return pSModelRTCfgBase.getRTType() == null;
            }
            case 16: {
                return pSModelRTCfgBase.getUpdateDate() == null;
            }
            case 17: {
                return pSModelRTCfgBase.getUpdateMan() == null;
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
        return PSModelRTCfgBase.contains(this, n);
    }

    private static boolean contains(PSModelRTCfgBase pSModelRTCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelRTCfgBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelRTCfgBase.isCreateManDirty();
            }
            case 2: {
                return pSModelRTCfgBase.isMemoDirty();
            }
            case 3: {
                return pSModelRTCfgBase.isOrderValueDirty();
            }
            case 4: {
                return pSModelRTCfgBase.isPSDynaInstIdDirty();
            }
            case 5: {
                return pSModelRTCfgBase.isPSModelIdDirty();
            }
            case 6: {
                return pSModelRTCfgBase.isPSModelRTCfgIdDirty();
            }
            case 7: {
                return pSModelRTCfgBase.isPSModelRTCfgNameDirty();
            }
            case 8: {
                return pSModelRTCfgBase.isPSModelTypeDirty();
            }
            case 9: {
                return pSModelRTCfgBase.isPSSystemIdDirty();
            }
            case 10: {
                return pSModelRTCfgBase.isRTModelDirty();
            }
            case 11: {
                return pSModelRTCfgBase.isRTModelIdDirty();
            }
            case 12: {
                return pSModelRTCfgBase.isRTModelPathDirty();
            }
            case 13: {
                return pSModelRTCfgBase.isRTTagDirty();
            }
            case 14: {
                return pSModelRTCfgBase.isRTTag2Dirty();
            }
            case 15: {
                return pSModelRTCfgBase.isRTTypeDirty();
            }
            case 16: {
                return pSModelRTCfgBase.isUpdateDateDirty();
            }
            case 17: {
                return pSModelRTCfgBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelRTCfgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelRTCfgBase pSModelRTCfgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelRTCfgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getPSModelRTCfgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelrtcfgid", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getPSModelRTCfgId()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getPSModelRTCfgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelrtcfgname", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getPSModelRTCfgName()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getPSModelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodeltype", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getPSModelType()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getRTModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtmodel", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getRTModel()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getRTModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtmodelid", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getRTModelId()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getRTModelPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rtmodelpath", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getRTModelPath()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getRTTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rttag", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getRTTag()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getRTTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rttag2", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getRTTag2()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getRTType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rttype", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getRTType()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelRTCfgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelRTCfgBase.getJSONValue((Object)pSModelRTCfgBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelRTCfgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelRTCfgBase pSModelRTCfgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelRTCfgBase.getCreateDate() != null) {
            object = pSModelRTCfgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelRTCfgBase.getCreateMan() != null) {
            object = pSModelRTCfgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTCfgBase.getMemo() != null) {
            object = pSModelRTCfgBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTCfgBase.getOrderValue() != null) {
            object = pSModelRTCfgBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelRTCfgBase.getPSDynaInstId() != null) {
            object = pSModelRTCfgBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTCfgBase.getPSModelId() != null) {
            object = pSModelRTCfgBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTCfgBase.getPSModelRTCfgId() != null) {
            object = pSModelRTCfgBase.getPSModelRTCfgId();
            xmlNode.setAttribute(FIELD_PSMODELRTCFGID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTCfgBase.getPSModelRTCfgName() != null) {
            object = pSModelRTCfgBase.getPSModelRTCfgName();
            xmlNode.setAttribute(FIELD_PSMODELRTCFGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTCfgBase.getPSModelType() != null) {
            object = pSModelRTCfgBase.getPSModelType();
            xmlNode.setAttribute(FIELD_PSMODELTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTCfgBase.getPSSystemId() != null) {
            object = pSModelRTCfgBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTCfgBase.getRTModel() != null) {
            object = pSModelRTCfgBase.getRTModel();
            xmlNode.setAttribute(FIELD_RTMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTCfgBase.getRTModelId() != null) {
            object = pSModelRTCfgBase.getRTModelId();
            xmlNode.setAttribute(FIELD_RTMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTCfgBase.getRTModelPath() != null) {
            object = pSModelRTCfgBase.getRTModelPath();
            xmlNode.setAttribute(FIELD_RTMODELPATH, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTCfgBase.getRTTag() != null) {
            object = pSModelRTCfgBase.getRTTag();
            xmlNode.setAttribute(FIELD_RTTAG, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTCfgBase.getRTTag2() != null) {
            object = pSModelRTCfgBase.getRTTag2();
            xmlNode.setAttribute(FIELD_RTTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTCfgBase.getRTType() != null) {
            object = pSModelRTCfgBase.getRTType();
            xmlNode.setAttribute(FIELD_RTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelRTCfgBase.getUpdateDate() != null) {
            object = pSModelRTCfgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelRTCfgBase.getUpdateMan() != null) {
            object = pSModelRTCfgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelRTCfgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelRTCfgBase pSModelRTCfgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelRTCfgBase.isCreateDateDirty() && (bl || pSModelRTCfgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelRTCfgBase.getCreateDate());
        }
        if (pSModelRTCfgBase.isCreateManDirty() && (bl || pSModelRTCfgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelRTCfgBase.getCreateMan());
        }
        if (pSModelRTCfgBase.isMemoDirty() && (bl || pSModelRTCfgBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelRTCfgBase.getMemo());
        }
        if (pSModelRTCfgBase.isOrderValueDirty() && (bl || pSModelRTCfgBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModelRTCfgBase.getOrderValue());
        }
        if (pSModelRTCfgBase.isPSDynaInstIdDirty() && (bl || pSModelRTCfgBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSModelRTCfgBase.getPSDynaInstId());
        }
        if (pSModelRTCfgBase.isPSModelIdDirty() && (bl || pSModelRTCfgBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelRTCfgBase.getPSModelId());
        }
        if (pSModelRTCfgBase.isPSModelRTCfgIdDirty() && (bl || pSModelRTCfgBase.getPSModelRTCfgId() != null)) {
            iDataObject.set(FIELD_PSMODELRTCFGID, (Object)pSModelRTCfgBase.getPSModelRTCfgId());
        }
        if (pSModelRTCfgBase.isPSModelRTCfgNameDirty() && (bl || pSModelRTCfgBase.getPSModelRTCfgName() != null)) {
            iDataObject.set(FIELD_PSMODELRTCFGNAME, (Object)pSModelRTCfgBase.getPSModelRTCfgName());
        }
        if (pSModelRTCfgBase.isPSModelTypeDirty() && (bl || pSModelRTCfgBase.getPSModelType() != null)) {
            iDataObject.set(FIELD_PSMODELTYPE, (Object)pSModelRTCfgBase.getPSModelType());
        }
        if (pSModelRTCfgBase.isPSSystemIdDirty() && (bl || pSModelRTCfgBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSModelRTCfgBase.getPSSystemId());
        }
        if (pSModelRTCfgBase.isRTModelDirty() && (bl || pSModelRTCfgBase.getRTModel() != null)) {
            iDataObject.set(FIELD_RTMODEL, (Object)pSModelRTCfgBase.getRTModel());
        }
        if (pSModelRTCfgBase.isRTModelIdDirty() && (bl || pSModelRTCfgBase.getRTModelId() != null)) {
            iDataObject.set(FIELD_RTMODELID, (Object)pSModelRTCfgBase.getRTModelId());
        }
        if (pSModelRTCfgBase.isRTModelPathDirty() && (bl || pSModelRTCfgBase.getRTModelPath() != null)) {
            iDataObject.set(FIELD_RTMODELPATH, (Object)pSModelRTCfgBase.getRTModelPath());
        }
        if (pSModelRTCfgBase.isRTTagDirty() && (bl || pSModelRTCfgBase.getRTTag() != null)) {
            iDataObject.set(FIELD_RTTAG, (Object)pSModelRTCfgBase.getRTTag());
        }
        if (pSModelRTCfgBase.isRTTag2Dirty() && (bl || pSModelRTCfgBase.getRTTag2() != null)) {
            iDataObject.set(FIELD_RTTAG2, (Object)pSModelRTCfgBase.getRTTag2());
        }
        if (pSModelRTCfgBase.isRTTypeDirty() && (bl || pSModelRTCfgBase.getRTType() != null)) {
            iDataObject.set(FIELD_RTTYPE, (Object)pSModelRTCfgBase.getRTType());
        }
        if (pSModelRTCfgBase.isUpdateDateDirty() && (bl || pSModelRTCfgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelRTCfgBase.getUpdateDate());
        }
        if (pSModelRTCfgBase.isUpdateManDirty() && (bl || pSModelRTCfgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelRTCfgBase.getUpdateMan());
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
        return PSModelRTCfgBase.remove(this, n);
    }

    private static boolean remove(PSModelRTCfgBase pSModelRTCfgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelRTCfgBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelRTCfgBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelRTCfgBase.resetMemo();
                return true;
            }
            case 3: {
                pSModelRTCfgBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSModelRTCfgBase.resetPSDynaInstId();
                return true;
            }
            case 5: {
                pSModelRTCfgBase.resetPSModelId();
                return true;
            }
            case 6: {
                pSModelRTCfgBase.resetPSModelRTCfgId();
                return true;
            }
            case 7: {
                pSModelRTCfgBase.resetPSModelRTCfgName();
                return true;
            }
            case 8: {
                pSModelRTCfgBase.resetPSModelType();
                return true;
            }
            case 9: {
                pSModelRTCfgBase.resetPSSystemId();
                return true;
            }
            case 10: {
                pSModelRTCfgBase.resetRTModel();
                return true;
            }
            case 11: {
                pSModelRTCfgBase.resetRTModelId();
                return true;
            }
            case 12: {
                pSModelRTCfgBase.resetRTModelPath();
                return true;
            }
            case 13: {
                pSModelRTCfgBase.resetRTTag();
                return true;
            }
            case 14: {
                pSModelRTCfgBase.resetRTTag2();
                return true;
            }
            case 15: {
                pSModelRTCfgBase.resetRTType();
                return true;
            }
            case 16: {
                pSModelRTCfgBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSModelRTCfgBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSModelRTCfgBase getProxyEntity() {
        return this.proxyPSModelRTCfgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelRTCfgBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelRTCfgBase) {
            this.proxyPSModelRTCfgBase = (PSModelRTCfgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModelRTCfgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 4);
        fieldIndexMap.put(FIELD_PSMODELID, 5);
        fieldIndexMap.put(FIELD_PSMODELRTCFGID, 6);
        fieldIndexMap.put(FIELD_PSMODELRTCFGNAME, 7);
        fieldIndexMap.put(FIELD_PSMODELTYPE, 8);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 9);
        fieldIndexMap.put(FIELD_RTMODEL, 10);
        fieldIndexMap.put(FIELD_RTMODELID, 11);
        fieldIndexMap.put(FIELD_RTMODELPATH, 12);
        fieldIndexMap.put(FIELD_RTTAG, 13);
        fieldIndexMap.put(FIELD_RTTAG2, 14);
        fieldIndexMap.put(FIELD_RTTYPE, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
    }
}

