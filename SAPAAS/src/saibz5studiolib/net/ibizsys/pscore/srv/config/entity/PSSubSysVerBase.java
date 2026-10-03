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
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubSysVerBase.class);
    public static final String FIELD_CLSPKGPARAMS = "CLSPKGPARAMS";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSUBSYSID = "PSSUBSYSID";
    public static final String FIELD_PSSUBSYSNAME = "PSSUBSYSNAME";
    public static final String FIELD_PSSUBSYSVERID = "PSSUBSYSVERID";
    public static final String FIELD_PSSUBSYSVERNAME = "PSSUBSYSVERNAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VERDETAIL = "VERDETAIL";
    public static final String FIELD_VERLOG = "VERLOG";
    public static final String FIELD_VERSION = "VERSION";
    private static final int INDEX_CLSPKGPARAMS = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSSUBSYSID = 4;
    private static final int INDEX_PSSUBSYSNAME = 5;
    private static final int INDEX_PSSUBSYSVERID = 6;
    private static final int INDEX_PSSUBSYSVERNAME = 7;
    private static final int INDEX_PSSYSMODELINSTID = 8;
    private static final int INDEX_PSSYSMODELINSTNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final int INDEX_VERDETAIL = 13;
    private static final int INDEX_VERLOG = 14;
    private static final int INDEX_VERSION = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubSysVerBase proxyPSSubSysVerBase = null;
    private boolean clspkgparamsDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssubsysidDirtyFlag = false;
    private boolean pssubsysnameDirtyFlag = false;
    private boolean pssubsysveridDirtyFlag = false;
    private boolean pssubsysvernameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pssysmodelinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean verdetailDirtyFlag = false;
    private boolean verlogDirtyFlag = false;
    private boolean versionDirtyFlag = false;
    @Column(name="clspkgparams")
    private String clspkgparams;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssubsysid")
    private String pssubsysid;
    @Column(name="pssubsysname")
    private String pssubsysname;
    @Column(name="pssubsysverid")
    private String pssubsysverid;
    @Column(name="pssubsysvername")
    private String pssubsysvername;
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
    @Column(name="pssysmodelinstname")
    private String pssysmodelinstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="verdetail")
    private String verdetail;
    @Column(name="verlog")
    private String verlog;
    @Column(name="version")
    private Integer version;
    private Integer objPSSubSysLock = new Integer(1);
    private PSSubSys pssubsys = null;
    private Integer objPSSysModelInstLock = new Integer(1);
    private PSSysModelInst pssysmodelinst = null;

    public void setClsPkgParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setClsPkgParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clspkgparams = string;
        this.clspkgparamsDirtyFlag = true;
    }

    public String getClsPkgParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getClsPkgParams();
        }
        return this.clspkgparams;
    }

    public boolean isClsPkgParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isClsPkgParamsDirty();
        }
        return this.clspkgparamsDirtyFlag;
    }

    public void resetClsPkgParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetClsPkgParams();
            return;
        }
        this.clspkgparamsDirtyFlag = false;
        this.clspkgparams = null;
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

    public void setPSSubSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysid = string;
        this.pssubsysidDirtyFlag = true;
    }

    public String getPSSubSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysId();
        }
        return this.pssubsysid;
    }

    public boolean isPSSubSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysIdDirty();
        }
        return this.pssubsysidDirtyFlag;
    }

    public void resetPSSubSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysId();
            return;
        }
        this.pssubsysidDirtyFlag = false;
        this.pssubsysid = null;
    }

    public void setPSSubSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysname = string;
        this.pssubsysnameDirtyFlag = true;
    }

    public String getPSSubSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysName();
        }
        return this.pssubsysname;
    }

    public boolean isPSSubSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysNameDirty();
        }
        return this.pssubsysnameDirtyFlag;
    }

    public void resetPSSubSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysName();
            return;
        }
        this.pssubsysnameDirtyFlag = false;
        this.pssubsysname = null;
    }

    public void setPSSubSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysverid = string;
        this.pssubsysveridDirtyFlag = true;
    }

    public String getPSSubSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysVerId();
        }
        return this.pssubsysverid;
    }

    public boolean isPSSubSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysVerIdDirty();
        }
        return this.pssubsysveridDirtyFlag;
    }

    public void resetPSSubSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysVerId();
            return;
        }
        this.pssubsysveridDirtyFlag = false;
        this.pssubsysverid = null;
    }

    public void setPSSubSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysvername = string;
        this.pssubsysvernameDirtyFlag = true;
    }

    public String getPSSubSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysVerName();
        }
        return this.pssubsysvername;
    }

    public boolean isPSSubSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysVerNameDirty();
        }
        return this.pssubsysvernameDirtyFlag;
    }

    public void resetPSSubSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysVerName();
            return;
        }
        this.pssubsysvernameDirtyFlag = false;
        this.pssubsysvername = null;
    }

    public void setPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstid = string;
        this.pssysmodelinstidDirtyFlag = true;
    }

    public String getPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstId();
        }
        return this.pssysmodelinstid;
    }

    public boolean isPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstIdDirty();
        }
        return this.pssysmodelinstidDirtyFlag;
    }

    public void resetPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstId();
            return;
        }
        this.pssysmodelinstidDirtyFlag = false;
        this.pssysmodelinstid = null;
    }

    public void setPSSysModelInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstname = string;
        this.pssysmodelinstnameDirtyFlag = true;
    }

    public String getPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstName();
        }
        return this.pssysmodelinstname;
    }

    public boolean isPSSysModelInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstNameDirty();
        }
        return this.pssysmodelinstnameDirtyFlag;
    }

    public void resetPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstName();
            return;
        }
        this.pssysmodelinstnameDirtyFlag = false;
        this.pssysmodelinstname = null;
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

    public void setVerDetail(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerDetail(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.verdetail = string;
        this.verdetailDirtyFlag = true;
    }

    public String getVerDetail() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerDetail();
        }
        return this.verdetail;
    }

    public boolean isVerDetailDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerDetailDirty();
        }
        return this.verdetailDirtyFlag;
    }

    public void resetVerDetail() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerDetail();
            return;
        }
        this.verdetailDirtyFlag = false;
        this.verdetail = null;
    }

    public void setVerLog(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerLog(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.verlog = string;
        this.verlogDirtyFlag = true;
    }

    public String getVerLog() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerLog();
        }
        return this.verlog;
    }

    public boolean isVerLogDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerLogDirty();
        }
        return this.verlogDirtyFlag;
    }

    public void resetVerLog() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerLog();
            return;
        }
        this.verlogDirtyFlag = false;
        this.verlog = null;
    }

    public void setVersion(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVersion(n);
            return;
        }
        this.version = n;
        this.versionDirtyFlag = true;
    }

    public Integer getVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVersion();
        }
        return this.version;
    }

    public boolean isVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVersionDirty();
        }
        return this.versionDirtyFlag;
    }

    public void resetVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVersion();
            return;
        }
        this.versionDirtyFlag = false;
        this.version = null;
    }

    protected void onReset() {
        PSSubSysVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubSysVerBase pSSubSysVerBase) {
        pSSubSysVerBase.resetClsPkgParams();
        pSSubSysVerBase.resetCreateDate();
        pSSubSysVerBase.resetCreateMan();
        pSSubSysVerBase.resetMemo();
        pSSubSysVerBase.resetPSSubSysId();
        pSSubSysVerBase.resetPSSubSysName();
        pSSubSysVerBase.resetPSSubSysVerId();
        pSSubSysVerBase.resetPSSubSysVerName();
        pSSubSysVerBase.resetPSSysModelInstId();
        pSSubSysVerBase.resetPSSysModelInstName();
        pSSubSysVerBase.resetUpdateDate();
        pSSubSysVerBase.resetUpdateMan();
        pSSubSysVerBase.resetValidFlag();
        pSSubSysVerBase.resetVerDetail();
        pSSubSysVerBase.resetVerLog();
        pSSubSysVerBase.resetVersion();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isClsPkgParamsDirty()) {
            hashMap.put(FIELD_CLSPKGPARAMS, this.getClsPkgParams());
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
        if (!bl || this.isPSSubSysIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSID, this.getPSSubSysId());
        }
        if (!bl || this.isPSSubSysNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSNAME, this.getPSSubSysName());
        }
        if (!bl || this.isPSSubSysVerIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSVERID, this.getPSSubSysVerId());
        }
        if (!bl || this.isPSSubSysVerNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSVERNAME, this.getPSSubSysVerName());
        }
        if (!bl || this.isPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTID, this.getPSSysModelInstId());
        }
        if (!bl || this.isPSSysModelInstNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTNAME, this.getPSSysModelInstName());
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
        if (!bl || this.isVerDetailDirty()) {
            hashMap.put(FIELD_VERDETAIL, this.getVerDetail());
        }
        if (!bl || this.isVerLogDirty()) {
            hashMap.put(FIELD_VERLOG, this.getVerLog());
        }
        if (!bl || this.isVersionDirty()) {
            hashMap.put(FIELD_VERSION, this.getVersion());
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
        return PSSubSysVerBase.get(this, n);
    }

    private static Object get(PSSubSysVerBase pSSubSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysVerBase.getClsPkgParams();
            }
            case 1: {
                return pSSubSysVerBase.getCreateDate();
            }
            case 2: {
                return pSSubSysVerBase.getCreateMan();
            }
            case 3: {
                return pSSubSysVerBase.getMemo();
            }
            case 4: {
                return pSSubSysVerBase.getPSSubSysId();
            }
            case 5: {
                return pSSubSysVerBase.getPSSubSysName();
            }
            case 6: {
                return pSSubSysVerBase.getPSSubSysVerId();
            }
            case 7: {
                return pSSubSysVerBase.getPSSubSysVerName();
            }
            case 8: {
                return pSSubSysVerBase.getPSSysModelInstId();
            }
            case 9: {
                return pSSubSysVerBase.getPSSysModelInstName();
            }
            case 10: {
                return pSSubSysVerBase.getUpdateDate();
            }
            case 11: {
                return pSSubSysVerBase.getUpdateMan();
            }
            case 12: {
                return pSSubSysVerBase.getValidFlag();
            }
            case 13: {
                return pSSubSysVerBase.getVerDetail();
            }
            case 14: {
                return pSSubSysVerBase.getVerLog();
            }
            case 15: {
                return pSSubSysVerBase.getVersion();
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
        PSSubSysVerBase.set(this, n, object);
    }

    private static void set(PSSubSysVerBase pSSubSysVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysVerBase.setClsPkgParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSubSysVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSubSysVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSubSysVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSubSysVerBase.setPSSubSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSubSysVerBase.setPSSubSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSubSysVerBase.setPSSubSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSubSysVerBase.setPSSubSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubSysVerBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubSysVerBase.setPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubSysVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSubSysVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSubSysVerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSSubSysVerBase.setVerDetail(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSubSysVerBase.setVerLog(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSubSysVerBase.setVersion(DataObject.getIntegerValue((Object)object));
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
        return PSSubSysVerBase.isNull(this, n);
    }

    private static boolean isNull(PSSubSysVerBase pSSubSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysVerBase.getClsPkgParams() == null;
            }
            case 1: {
                return pSSubSysVerBase.getCreateDate() == null;
            }
            case 2: {
                return pSSubSysVerBase.getCreateMan() == null;
            }
            case 3: {
                return pSSubSysVerBase.getMemo() == null;
            }
            case 4: {
                return pSSubSysVerBase.getPSSubSysId() == null;
            }
            case 5: {
                return pSSubSysVerBase.getPSSubSysName() == null;
            }
            case 6: {
                return pSSubSysVerBase.getPSSubSysVerId() == null;
            }
            case 7: {
                return pSSubSysVerBase.getPSSubSysVerName() == null;
            }
            case 8: {
                return pSSubSysVerBase.getPSSysModelInstId() == null;
            }
            case 9: {
                return pSSubSysVerBase.getPSSysModelInstName() == null;
            }
            case 10: {
                return pSSubSysVerBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSubSysVerBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSubSysVerBase.getValidFlag() == null;
            }
            case 13: {
                return pSSubSysVerBase.getVerDetail() == null;
            }
            case 14: {
                return pSSubSysVerBase.getVerLog() == null;
            }
            case 15: {
                return pSSubSysVerBase.getVersion() == null;
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
        return PSSubSysVerBase.contains(this, n);
    }

    private static boolean contains(PSSubSysVerBase pSSubSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysVerBase.isClsPkgParamsDirty();
            }
            case 1: {
                return pSSubSysVerBase.isCreateDateDirty();
            }
            case 2: {
                return pSSubSysVerBase.isCreateManDirty();
            }
            case 3: {
                return pSSubSysVerBase.isMemoDirty();
            }
            case 4: {
                return pSSubSysVerBase.isPSSubSysIdDirty();
            }
            case 5: {
                return pSSubSysVerBase.isPSSubSysNameDirty();
            }
            case 6: {
                return pSSubSysVerBase.isPSSubSysVerIdDirty();
            }
            case 7: {
                return pSSubSysVerBase.isPSSubSysVerNameDirty();
            }
            case 8: {
                return pSSubSysVerBase.isPSSysModelInstIdDirty();
            }
            case 9: {
                return pSSubSysVerBase.isPSSysModelInstNameDirty();
            }
            case 10: {
                return pSSubSysVerBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSubSysVerBase.isUpdateManDirty();
            }
            case 12: {
                return pSSubSysVerBase.isValidFlagDirty();
            }
            case 13: {
                return pSSubSysVerBase.isVerDetailDirty();
            }
            case 14: {
                return pSSubSysVerBase.isVerLogDirty();
            }
            case 15: {
                return pSSubSysVerBase.isVersionDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubSysVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubSysVerBase pSSubSysVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubSysVerBase.getClsPkgParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clspkgparams", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getClsPkgParams()), (boolean)false);
        }
        if (bl || pSSubSysVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubSysVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubSysVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubSysVerBase.getPSSubSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysid", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getPSSubSysId()), (boolean)false);
        }
        if (bl || pSSubSysVerBase.getPSSubSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysname", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getPSSubSysName()), (boolean)false);
        }
        if (bl || pSSubSysVerBase.getPSSubSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysverid", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getPSSubSysVerId()), (boolean)false);
        }
        if (bl || pSSubSysVerBase.getPSSubSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysvername", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getPSSubSysVerName()), (boolean)false);
        }
        if (bl || pSSubSysVerBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSSubSysVerBase.getPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstname", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSSubSysVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubSysVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSubSysVerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSubSysVerBase.getVerDetail() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"verdetail", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getVerDetail()), (boolean)false);
        }
        if (bl || pSSubSysVerBase.getVerLog() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"verlog", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getVerLog()), (boolean)false);
        }
        if (bl || pSSubSysVerBase.getVersion() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"version", (Object)PSSubSysVerBase.getJSONValue((Object)pSSubSysVerBase.getVersion()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubSysVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubSysVerBase pSSubSysVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubSysVerBase.getClsPkgParams() != null) {
            object = pSSubSysVerBase.getClsPkgParams();
            xmlNode.setAttribute(FIELD_CLSPKGPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerBase.getCreateDate() != null) {
            object = pSSubSysVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysVerBase.getCreateMan() != null) {
            object = pSSubSysVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerBase.getMemo() != null) {
            object = pSSubSysVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerBase.getPSSubSysId() != null) {
            object = pSSubSysVerBase.getPSSubSysId();
            xmlNode.setAttribute(FIELD_PSSUBSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerBase.getPSSubSysName() != null) {
            object = pSSubSysVerBase.getPSSubSysName();
            xmlNode.setAttribute(FIELD_PSSUBSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerBase.getPSSubSysVerId() != null) {
            object = pSSubSysVerBase.getPSSubSysVerId();
            xmlNode.setAttribute(FIELD_PSSUBSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerBase.getPSSubSysVerName() != null) {
            object = pSSubSysVerBase.getPSSubSysVerName();
            xmlNode.setAttribute(FIELD_PSSUBSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerBase.getPSSysModelInstId() != null) {
            object = pSSubSysVerBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerBase.getPSSysModelInstName() != null) {
            object = pSSubSysVerBase.getPSSysModelInstName();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerBase.getUpdateDate() != null) {
            object = pSSubSysVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysVerBase.getUpdateMan() != null) {
            object = pSSubSysVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerBase.getValidFlag() != null) {
            object = pSSubSysVerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSubSysVerBase.getVerDetail() != null) {
            object = pSSubSysVerBase.getVerDetail();
            xmlNode.setAttribute(FIELD_VERDETAIL, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerBase.getVerLog() != null) {
            object = pSSubSysVerBase.getVerLog();
            xmlNode.setAttribute(FIELD_VERLOG, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerBase.getVersion() != null) {
            object = pSSubSysVerBase.getVersion();
            xmlNode.setAttribute(FIELD_VERSION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubSysVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubSysVerBase pSSubSysVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubSysVerBase.isClsPkgParamsDirty() && (bl || pSSubSysVerBase.getClsPkgParams() != null)) {
            iDataObject.set(FIELD_CLSPKGPARAMS, (Object)pSSubSysVerBase.getClsPkgParams());
        }
        if (pSSubSysVerBase.isCreateDateDirty() && (bl || pSSubSysVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubSysVerBase.getCreateDate());
        }
        if (pSSubSysVerBase.isCreateManDirty() && (bl || pSSubSysVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubSysVerBase.getCreateMan());
        }
        if (pSSubSysVerBase.isMemoDirty() && (bl || pSSubSysVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubSysVerBase.getMemo());
        }
        if (pSSubSysVerBase.isPSSubSysIdDirty() && (bl || pSSubSysVerBase.getPSSubSysId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSID, (Object)pSSubSysVerBase.getPSSubSysId());
        }
        if (pSSubSysVerBase.isPSSubSysNameDirty() && (bl || pSSubSysVerBase.getPSSubSysName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSNAME, (Object)pSSubSysVerBase.getPSSubSysName());
        }
        if (pSSubSysVerBase.isPSSubSysVerIdDirty() && (bl || pSSubSysVerBase.getPSSubSysVerId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSVERID, (Object)pSSubSysVerBase.getPSSubSysVerId());
        }
        if (pSSubSysVerBase.isPSSubSysVerNameDirty() && (bl || pSSubSysVerBase.getPSSubSysVerName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSVERNAME, (Object)pSSubSysVerBase.getPSSubSysVerName());
        }
        if (pSSubSysVerBase.isPSSysModelInstIdDirty() && (bl || pSSubSysVerBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSSubSysVerBase.getPSSysModelInstId());
        }
        if (pSSubSysVerBase.isPSSysModelInstNameDirty() && (bl || pSSubSysVerBase.getPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTNAME, (Object)pSSubSysVerBase.getPSSysModelInstName());
        }
        if (pSSubSysVerBase.isUpdateDateDirty() && (bl || pSSubSysVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubSysVerBase.getUpdateDate());
        }
        if (pSSubSysVerBase.isUpdateManDirty() && (bl || pSSubSysVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubSysVerBase.getUpdateMan());
        }
        if (pSSubSysVerBase.isValidFlagDirty() && (bl || pSSubSysVerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSubSysVerBase.getValidFlag());
        }
        if (pSSubSysVerBase.isVerDetailDirty() && (bl || pSSubSysVerBase.getVerDetail() != null)) {
            iDataObject.set(FIELD_VERDETAIL, (Object)pSSubSysVerBase.getVerDetail());
        }
        if (pSSubSysVerBase.isVerLogDirty() && (bl || pSSubSysVerBase.getVerLog() != null)) {
            iDataObject.set(FIELD_VERLOG, (Object)pSSubSysVerBase.getVerLog());
        }
        if (pSSubSysVerBase.isVersionDirty() && (bl || pSSubSysVerBase.getVersion() != null)) {
            iDataObject.set(FIELD_VERSION, (Object)pSSubSysVerBase.getVersion());
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
        return PSSubSysVerBase.remove(this, n);
    }

    private static boolean remove(PSSubSysVerBase pSSubSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysVerBase.resetClsPkgParams();
                return true;
            }
            case 1: {
                pSSubSysVerBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSubSysVerBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSubSysVerBase.resetMemo();
                return true;
            }
            case 4: {
                pSSubSysVerBase.resetPSSubSysId();
                return true;
            }
            case 5: {
                pSSubSysVerBase.resetPSSubSysName();
                return true;
            }
            case 6: {
                pSSubSysVerBase.resetPSSubSysVerId();
                return true;
            }
            case 7: {
                pSSubSysVerBase.resetPSSubSysVerName();
                return true;
            }
            case 8: {
                pSSubSysVerBase.resetPSSysModelInstId();
                return true;
            }
            case 9: {
                pSSubSysVerBase.resetPSSysModelInstName();
                return true;
            }
            case 10: {
                pSSubSysVerBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSubSysVerBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSubSysVerBase.resetValidFlag();
                return true;
            }
            case 13: {
                pSSubSysVerBase.resetVerDetail();
                return true;
            }
            case 14: {
                pSSubSysVerBase.resetVerLog();
                return true;
            }
            case 15: {
                pSSubSysVerBase.resetVersion();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSys getPSSubSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSys();
        }
        if (this.getPSSubSysId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysLock;
        synchronized (n) {
            if (this.pssubsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysId(), (Object)this.pssubsys.getPSSubSysId()) != 0L) {
                this.pssubsys = null;
            }
            if (this.pssubsys == null) {
                PSSubSys pSSubSys = new PSSubSys();
                pSSubSys.setPSSubSysId(this.getPSSubSysId());
                PSSubSysService pSSubSysService = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysService.autoGet(pSSubSys);
                this.pssubsys = pSSubSys;
            }
            return this.pssubsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelInst getPSSysModelInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInst();
        }
        if (this.getPSSysModelInstId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelInstLock;
        synchronized (n) {
            if (this.pssysmodelinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelInstId(), (Object)this.pssysmodelinst.getPSSysModelInstId()) != 0L) {
                this.pssysmodelinst = null;
            }
            if (this.pssysmodelinst == null) {
                PSSysModelInst pSSysModelInst = new PSSysModelInst();
                pSSysModelInst.setPSSysModelInstId(this.getPSSysModelInstId());
                PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelInstService.autoGet(pSSysModelInst);
                this.pssysmodelinst = pSSysModelInst;
            }
            return this.pssysmodelinst;
        }
    }

    private PSSubSysVerBase getProxyEntity() {
        return this.proxyPSSubSysVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubSysVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubSysVerBase) {
            this.proxyPSSubSysVerBase = (PSSubSysVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubSysVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLSPKGPARAMS, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSSUBSYSID, 4);
        fieldIndexMap.put(FIELD_PSSUBSYSNAME, 5);
        fieldIndexMap.put(FIELD_PSSUBSYSVERID, 6);
        fieldIndexMap.put(FIELD_PSSUBSYSVERNAME, 7);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 8);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
        fieldIndexMap.put(FIELD_VERDETAIL, 13);
        fieldIndexMap.put(FIELD_VERLOG, 14);
        fieldIndexMap.put(FIELD_VERSION, 15);
    }
}

