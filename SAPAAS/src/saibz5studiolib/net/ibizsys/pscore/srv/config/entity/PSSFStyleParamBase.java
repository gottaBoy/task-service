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
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFStyleParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFStyleParamBase.class);
    public static final String FIELD_ALLDCFLAG = "ALLDCFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PSSFSTYLEPARAMID = "PSSFSTYLEPARAMID";
    public static final String FIELD_PSSFSTYLEPARAMNAME = "PSSFSTYLEPARAMNAME";
    public static final String FIELD_STYLEPARAMS = "STYLEPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLDCFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEVCENTERID = 4;
    private static final int INDEX_PSDEVCENTERNAME = 5;
    private static final int INDEX_PSSFID = 6;
    private static final int INDEX_PSSFNAME = 7;
    private static final int INDEX_PSSFSTYLEID = 8;
    private static final int INDEX_PSSFSTYLENAME = 9;
    private static final int INDEX_PSSFSTYLEPARAMID = 10;
    private static final int INDEX_PSSFSTYLEPARAMNAME = 11;
    private static final int INDEX_STYLEPARAMS = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_VALIDFLAG = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFStyleParamBase proxyPSSFStyleParamBase = null;
    private boolean alldcflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean pssfstyleparamidDirtyFlag = false;
    private boolean pssfstyleparamnameDirtyFlag = false;
    private boolean styleparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="alldcflag")
    private Integer alldcflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="pssfstyleparamid")
    private String pssfstyleparamid;
    @Column(name="pssfstyleparamname")
    private String pssfstyleparamname;
    @Column(name="styleparams")
    private String styleparams;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;

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

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
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

    public void setPSSFStyleParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleparamid = string;
        this.pssfstyleparamidDirtyFlag = true;
    }

    public String getPSSFStyleParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleParamId();
        }
        return this.pssfstyleparamid;
    }

    public boolean isPSSFStyleParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleParamIdDirty();
        }
        return this.pssfstyleparamidDirtyFlag;
    }

    public void resetPSSFStyleParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleParamId();
            return;
        }
        this.pssfstyleparamidDirtyFlag = false;
        this.pssfstyleparamid = null;
    }

    public void setPSSFStyleParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleparamname = string;
        this.pssfstyleparamnameDirtyFlag = true;
    }

    public String getPSSFStyleParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleParamName();
        }
        return this.pssfstyleparamname;
    }

    public boolean isPSSFStyleParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleParamNameDirty();
        }
        return this.pssfstyleparamnameDirtyFlag;
    }

    public void resetPSSFStyleParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleParamName();
            return;
        }
        this.pssfstyleparamnameDirtyFlag = false;
        this.pssfstyleparamname = null;
    }

    public void setStyleParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStyleParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.styleparams = string;
        this.styleparamsDirtyFlag = true;
    }

    public String getStyleParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStyleParams();
        }
        return this.styleparams;
    }

    public boolean isStyleParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStyleParamsDirty();
        }
        return this.styleparamsDirtyFlag;
    }

    public void resetStyleParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStyleParams();
            return;
        }
        this.styleparamsDirtyFlag = false;
        this.styleparams = null;
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
        PSSFStyleParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFStyleParamBase pSSFStyleParamBase) {
        pSSFStyleParamBase.resetAllDCFlag();
        pSSFStyleParamBase.resetCreateDate();
        pSSFStyleParamBase.resetCreateMan();
        pSSFStyleParamBase.resetMemo();
        pSSFStyleParamBase.resetPSDevCenterId();
        pSSFStyleParamBase.resetPSDevCenterName();
        pSSFStyleParamBase.resetPSSFId();
        pSSFStyleParamBase.resetPSSFName();
        pSSFStyleParamBase.resetPSSFStyleId();
        pSSFStyleParamBase.resetPSSFStyleName();
        pSSFStyleParamBase.resetPSSFStyleParamId();
        pSSFStyleParamBase.resetPSSFStyleParamName();
        pSSFStyleParamBase.resetStyleParams();
        pSSFStyleParamBase.resetUpdateDate();
        pSSFStyleParamBase.resetUpdateMan();
        pSSFStyleParamBase.resetValidFlag();
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
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
        }
        if (!bl || this.isPSSFStyleParamIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEPARAMID, this.getPSSFStyleParamId());
        }
        if (!bl || this.isPSSFStyleParamNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLEPARAMNAME, this.getPSSFStyleParamName());
        }
        if (!bl || this.isStyleParamsDirty()) {
            hashMap.put(FIELD_STYLEPARAMS, this.getStyleParams());
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
        return PSSFStyleParamBase.get(this, n);
    }

    private static Object get(PSSFStyleParamBase pSSFStyleParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleParamBase.getAllDCFlag();
            }
            case 1: {
                return pSSFStyleParamBase.getCreateDate();
            }
            case 2: {
                return pSSFStyleParamBase.getCreateMan();
            }
            case 3: {
                return pSSFStyleParamBase.getMemo();
            }
            case 4: {
                return pSSFStyleParamBase.getPSDevCenterId();
            }
            case 5: {
                return pSSFStyleParamBase.getPSDevCenterName();
            }
            case 6: {
                return pSSFStyleParamBase.getPSSFId();
            }
            case 7: {
                return pSSFStyleParamBase.getPSSFName();
            }
            case 8: {
                return pSSFStyleParamBase.getPSSFStyleId();
            }
            case 9: {
                return pSSFStyleParamBase.getPSSFStyleName();
            }
            case 10: {
                return pSSFStyleParamBase.getPSSFStyleParamId();
            }
            case 11: {
                return pSSFStyleParamBase.getPSSFStyleParamName();
            }
            case 12: {
                return pSSFStyleParamBase.getStyleParams();
            }
            case 13: {
                return pSSFStyleParamBase.getUpdateDate();
            }
            case 14: {
                return pSSFStyleParamBase.getUpdateMan();
            }
            case 15: {
                return pSSFStyleParamBase.getValidFlag();
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
        PSSFStyleParamBase.set(this, n, object);
    }

    private static void set(PSSFStyleParamBase pSSFStyleParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFStyleParamBase.setAllDCFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSFStyleParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSFStyleParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFStyleParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFStyleParamBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFStyleParamBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFStyleParamBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFStyleParamBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFStyleParamBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFStyleParamBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFStyleParamBase.setPSSFStyleParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFStyleParamBase.setPSSFStyleParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFStyleParamBase.setStyleParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSFStyleParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSSFStyleParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSFStyleParamBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSFStyleParamBase.isNull(this, n);
    }

    private static boolean isNull(PSSFStyleParamBase pSSFStyleParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleParamBase.getAllDCFlag() == null;
            }
            case 1: {
                return pSSFStyleParamBase.getCreateDate() == null;
            }
            case 2: {
                return pSSFStyleParamBase.getCreateMan() == null;
            }
            case 3: {
                return pSSFStyleParamBase.getMemo() == null;
            }
            case 4: {
                return pSSFStyleParamBase.getPSDevCenterId() == null;
            }
            case 5: {
                return pSSFStyleParamBase.getPSDevCenterName() == null;
            }
            case 6: {
                return pSSFStyleParamBase.getPSSFId() == null;
            }
            case 7: {
                return pSSFStyleParamBase.getPSSFName() == null;
            }
            case 8: {
                return pSSFStyleParamBase.getPSSFStyleId() == null;
            }
            case 9: {
                return pSSFStyleParamBase.getPSSFStyleName() == null;
            }
            case 10: {
                return pSSFStyleParamBase.getPSSFStyleParamId() == null;
            }
            case 11: {
                return pSSFStyleParamBase.getPSSFStyleParamName() == null;
            }
            case 12: {
                return pSSFStyleParamBase.getStyleParams() == null;
            }
            case 13: {
                return pSSFStyleParamBase.getUpdateDate() == null;
            }
            case 14: {
                return pSSFStyleParamBase.getUpdateMan() == null;
            }
            case 15: {
                return pSSFStyleParamBase.getValidFlag() == null;
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
        return PSSFStyleParamBase.contains(this, n);
    }

    private static boolean contains(PSSFStyleParamBase pSSFStyleParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleParamBase.isAllDCFlagDirty();
            }
            case 1: {
                return pSSFStyleParamBase.isCreateDateDirty();
            }
            case 2: {
                return pSSFStyleParamBase.isCreateManDirty();
            }
            case 3: {
                return pSSFStyleParamBase.isMemoDirty();
            }
            case 4: {
                return pSSFStyleParamBase.isPSDevCenterIdDirty();
            }
            case 5: {
                return pSSFStyleParamBase.isPSDevCenterNameDirty();
            }
            case 6: {
                return pSSFStyleParamBase.isPSSFIdDirty();
            }
            case 7: {
                return pSSFStyleParamBase.isPSSFNameDirty();
            }
            case 8: {
                return pSSFStyleParamBase.isPSSFStyleIdDirty();
            }
            case 9: {
                return pSSFStyleParamBase.isPSSFStyleNameDirty();
            }
            case 10: {
                return pSSFStyleParamBase.isPSSFStyleParamIdDirty();
            }
            case 11: {
                return pSSFStyleParamBase.isPSSFStyleParamNameDirty();
            }
            case 12: {
                return pSSFStyleParamBase.isStyleParamsDirty();
            }
            case 13: {
                return pSSFStyleParamBase.isUpdateDateDirty();
            }
            case 14: {
                return pSSFStyleParamBase.isUpdateManDirty();
            }
            case 15: {
                return pSSFStyleParamBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFStyleParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFStyleParamBase pSSFStyleParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFStyleParamBase.getAllDCFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alldcflag", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getAllDCFlag()), (boolean)false);
        }
        if (bl || pSSFStyleParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFStyleParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFStyleParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFStyleParamBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSSFStyleParamBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSSFStyleParamBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFStyleParamBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSFStyleParamBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFStyleParamBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFStyleParamBase.getPSSFStyleParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleparamid", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getPSSFStyleParamId()), (boolean)false);
        }
        if (bl || pSSFStyleParamBase.getPSSFStyleParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleparamname", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getPSSFStyleParamName()), (boolean)false);
        }
        if (bl || pSSFStyleParamBase.getStyleParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"styleparams", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getStyleParams()), (boolean)false);
        }
        if (bl || pSSFStyleParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFStyleParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFStyleParamBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSFStyleParamBase.getJSONValue((Object)pSSFStyleParamBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFStyleParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFStyleParamBase pSSFStyleParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFStyleParamBase.getAllDCFlag() != null) {
            object = pSSFStyleParamBase.getAllDCFlag();
            xmlNode.setAttribute(FIELD_ALLDCFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStyleParamBase.getCreateDate() != null) {
            object = pSSFStyleParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStyleParamBase.getCreateMan() != null) {
            object = pSSFStyleParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleParamBase.getMemo() != null) {
            object = pSSFStyleParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleParamBase.getPSDevCenterId() != null) {
            object = pSSFStyleParamBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleParamBase.getPSDevCenterName() != null) {
            object = pSSFStyleParamBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleParamBase.getPSSFId() != null) {
            object = pSSFStyleParamBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleParamBase.getPSSFName() != null) {
            object = pSSFStyleParamBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleParamBase.getPSSFStyleId() != null) {
            object = pSSFStyleParamBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleParamBase.getPSSFStyleName() != null) {
            object = pSSFStyleParamBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleParamBase.getPSSFStyleParamId() != null) {
            object = pSSFStyleParamBase.getPSSFStyleParamId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleParamBase.getPSSFStyleParamName() != null) {
            object = pSSFStyleParamBase.getPSSFStyleParamName();
            xmlNode.setAttribute(FIELD_PSSFSTYLEPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleParamBase.getStyleParams() != null) {
            object = pSSFStyleParamBase.getStyleParams();
            xmlNode.setAttribute(FIELD_STYLEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleParamBase.getUpdateDate() != null) {
            object = pSSFStyleParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStyleParamBase.getUpdateMan() != null) {
            object = pSSFStyleParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleParamBase.getValidFlag() != null) {
            object = pSSFStyleParamBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFStyleParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFStyleParamBase pSSFStyleParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFStyleParamBase.isAllDCFlagDirty() && (bl || pSSFStyleParamBase.getAllDCFlag() != null)) {
            iDataObject.set(FIELD_ALLDCFLAG, (Object)pSSFStyleParamBase.getAllDCFlag());
        }
        if (pSSFStyleParamBase.isCreateDateDirty() && (bl || pSSFStyleParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFStyleParamBase.getCreateDate());
        }
        if (pSSFStyleParamBase.isCreateManDirty() && (bl || pSSFStyleParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFStyleParamBase.getCreateMan());
        }
        if (pSSFStyleParamBase.isMemoDirty() && (bl || pSSFStyleParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFStyleParamBase.getMemo());
        }
        if (pSSFStyleParamBase.isPSDevCenterIdDirty() && (bl || pSSFStyleParamBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSSFStyleParamBase.getPSDevCenterId());
        }
        if (pSSFStyleParamBase.isPSDevCenterNameDirty() && (bl || pSSFStyleParamBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSSFStyleParamBase.getPSDevCenterName());
        }
        if (pSSFStyleParamBase.isPSSFIdDirty() && (bl || pSSFStyleParamBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFStyleParamBase.getPSSFId());
        }
        if (pSSFStyleParamBase.isPSSFNameDirty() && (bl || pSSFStyleParamBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSFStyleParamBase.getPSSFName());
        }
        if (pSSFStyleParamBase.isPSSFStyleIdDirty() && (bl || pSSFStyleParamBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSFStyleParamBase.getPSSFStyleId());
        }
        if (pSSFStyleParamBase.isPSSFStyleNameDirty() && (bl || pSSFStyleParamBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSFStyleParamBase.getPSSFStyleName());
        }
        if (pSSFStyleParamBase.isPSSFStyleParamIdDirty() && (bl || pSSFStyleParamBase.getPSSFStyleParamId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEPARAMID, (Object)pSSFStyleParamBase.getPSSFStyleParamId());
        }
        if (pSSFStyleParamBase.isPSSFStyleParamNameDirty() && (bl || pSSFStyleParamBase.getPSSFStyleParamName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEPARAMNAME, (Object)pSSFStyleParamBase.getPSSFStyleParamName());
        }
        if (pSSFStyleParamBase.isStyleParamsDirty() && (bl || pSSFStyleParamBase.getStyleParams() != null)) {
            iDataObject.set(FIELD_STYLEPARAMS, (Object)pSSFStyleParamBase.getStyleParams());
        }
        if (pSSFStyleParamBase.isUpdateDateDirty() && (bl || pSSFStyleParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFStyleParamBase.getUpdateDate());
        }
        if (pSSFStyleParamBase.isUpdateManDirty() && (bl || pSSFStyleParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFStyleParamBase.getUpdateMan());
        }
        if (pSSFStyleParamBase.isValidFlagDirty() && (bl || pSSFStyleParamBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSFStyleParamBase.getValidFlag());
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
        return PSSFStyleParamBase.remove(this, n);
    }

    private static boolean remove(PSSFStyleParamBase pSSFStyleParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFStyleParamBase.resetAllDCFlag();
                return true;
            }
            case 1: {
                pSSFStyleParamBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSFStyleParamBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSFStyleParamBase.resetMemo();
                return true;
            }
            case 4: {
                pSSFStyleParamBase.resetPSDevCenterId();
                return true;
            }
            case 5: {
                pSSFStyleParamBase.resetPSDevCenterName();
                return true;
            }
            case 6: {
                pSSFStyleParamBase.resetPSSFId();
                return true;
            }
            case 7: {
                pSSFStyleParamBase.resetPSSFName();
                return true;
            }
            case 8: {
                pSSFStyleParamBase.resetPSSFStyleId();
                return true;
            }
            case 9: {
                pSSFStyleParamBase.resetPSSFStyleName();
                return true;
            }
            case 10: {
                pSSFStyleParamBase.resetPSSFStyleParamId();
                return true;
            }
            case 11: {
                pSSFStyleParamBase.resetPSSFStyleParamName();
                return true;
            }
            case 12: {
                pSSFStyleParamBase.resetStyleParams();
                return true;
            }
            case 13: {
                pSSFStyleParamBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSSFStyleParamBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSSFStyleParamBase.resetValidFlag();
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
                pSSFStyleService.autoGet((IEntity)pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSF getPSSF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSF();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        Integer n = this.objPSSFLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFId(), (Object)this.pssf.getPSSFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSSF pSSF = new PSSF();
                pSSF.setPSSFId(this.getPSSFId());
                PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
                pSSFService.autoGet((IEntity)pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
        }
    }

    private PSSFStyleParamBase getProxyEntity() {
        return this.proxyPSSFStyleParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFStyleParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFStyleParamBase) {
            this.proxyPSSFStyleParamBase = (PSSFStyleParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLDCFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 5);
        fieldIndexMap.put(FIELD_PSSFID, 6);
        fieldIndexMap.put(FIELD_PSSFNAME, 7);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 8);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 9);
        fieldIndexMap.put(FIELD_PSSFSTYLEPARAMID, 10);
        fieldIndexMap.put(FIELD_PSSFSTYLEPARAMNAME, 11);
        fieldIndexMap.put(FIELD_STYLEPARAMS, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_VALIDFLAG, 15);
    }
}

