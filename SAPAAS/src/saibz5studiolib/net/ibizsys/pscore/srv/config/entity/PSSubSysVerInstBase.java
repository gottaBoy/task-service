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
import net.ibizsys.pscore.srv.config.entity.PSSubSysVer;
import net.ibizsys.pscore.srv.config.service.PSSubSysVerService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysVerInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubSysVerInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSUBSYSID = "PSSUBSYSID";
    public static final String FIELD_PSSUBSYSVERID = "PSSUBSYSVERID";
    public static final String FIELD_PSSUBSYSVERINSTID = "PSSUBSYSVERINSTID";
    public static final String FIELD_PSSUBSYSVERINSTNAME = "PSSUBSYSVERINSTNAME";
    public static final String FIELD_PSSUBSYSVERNAME = "PSSUBSYSVERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSUBSYSID = 3;
    private static final int INDEX_PSSUBSYSVERID = 4;
    private static final int INDEX_PSSUBSYSVERINSTID = 5;
    private static final int INDEX_PSSUBSYSVERINSTNAME = 6;
    private static final int INDEX_PSSUBSYSVERNAME = 7;
    private static final int INDEX_PSSVRDOMAINID = 8;
    private static final int INDEX_PSSVRDOMAINNAME = 9;
    private static final int INDEX_PSSYSMODELINSTID = 10;
    private static final int INDEX_PSSYSMODELINSTNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_VALIDFLAG = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubSysVerInstBase proxyPSSubSysVerInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssubsysidDirtyFlag = false;
    private boolean pssubsysveridDirtyFlag = false;
    private boolean pssubsysverinstidDirtyFlag = false;
    private boolean pssubsysverinstnameDirtyFlag = false;
    private boolean pssubsysvernameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pssysmodelinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssubsysid")
    private String pssubsysid;
    @Column(name="pssubsysverid")
    private String pssubsysverid;
    @Column(name="pssubsysverinstid")
    private String pssubsysverinstid;
    @Column(name="pssubsysverinstname")
    private String pssubsysverinstname;
    @Column(name="pssubsysvername")
    private String pssubsysvername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
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
    private Integer objPSSubSysVerLock = new Integer(1);
    private PSSubSysVer pssubsysver = null;
    private Integer objPssvrdomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;
    private Integer objPssysmodelinstLock = new Integer(1);
    private PSSysModelInst pssysmodelinst = null;

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

    public void setPSSubSysVerInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysVerInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysverinstid = string;
        this.pssubsysverinstidDirtyFlag = true;
    }

    public String getPSSubSysVerInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysVerInstId();
        }
        return this.pssubsysverinstid;
    }

    public boolean isPSSubSysVerInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysVerInstIdDirty();
        }
        return this.pssubsysverinstidDirtyFlag;
    }

    public void resetPSSubSysVerInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysVerInstId();
            return;
        }
        this.pssubsysverinstidDirtyFlag = false;
        this.pssubsysverinstid = null;
    }

    public void setPSSubSysVerInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysVerInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysverinstname = string;
        this.pssubsysverinstnameDirtyFlag = true;
    }

    public String getPSSubSysVerInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysVerInstName();
        }
        return this.pssubsysverinstname;
    }

    public boolean isPSSubSysVerInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysVerInstNameDirty();
        }
        return this.pssubsysverinstnameDirtyFlag;
    }

    public void resetPSSubSysVerInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysVerInstName();
            return;
        }
        this.pssubsysverinstnameDirtyFlag = false;
        this.pssubsysverinstname = null;
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

    public void setPSSvrDomainId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainid = string;
        this.pssvrdomainidDirtyFlag = true;
    }

    public String getPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainId();
        }
        return this.pssvrdomainid;
    }

    public boolean isPSSvrDomainIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainIdDirty();
        }
        return this.pssvrdomainidDirtyFlag;
    }

    public void resetPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainId();
            return;
        }
        this.pssvrdomainidDirtyFlag = false;
        this.pssvrdomainid = null;
    }

    public void setPSSvrDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainname = string;
        this.pssvrdomainnameDirtyFlag = true;
    }

    public String getPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainName();
        }
        return this.pssvrdomainname;
    }

    public boolean isPSSvrDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainNameDirty();
        }
        return this.pssvrdomainnameDirtyFlag;
    }

    public void resetPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainName();
            return;
        }
        this.pssvrdomainnameDirtyFlag = false;
        this.pssvrdomainname = null;
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

    protected void onReset() {
        PSSubSysVerInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubSysVerInstBase pSSubSysVerInstBase) {
        pSSubSysVerInstBase.resetCreateDate();
        pSSubSysVerInstBase.resetCreateMan();
        pSSubSysVerInstBase.resetMemo();
        pSSubSysVerInstBase.resetPSSubSysId();
        pSSubSysVerInstBase.resetPSSubSysVerId();
        pSSubSysVerInstBase.resetPSSubSysVerInstId();
        pSSubSysVerInstBase.resetPSSubSysVerInstName();
        pSSubSysVerInstBase.resetPSSubSysVerName();
        pSSubSysVerInstBase.resetPSSvrDomainId();
        pSSubSysVerInstBase.resetPSSvrDomainName();
        pSSubSysVerInstBase.resetPSSysModelInstId();
        pSSubSysVerInstBase.resetPSSysModelInstName();
        pSSubSysVerInstBase.resetUpdateDate();
        pSSubSysVerInstBase.resetUpdateMan();
        pSSubSysVerInstBase.resetValidFlag();
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
        if (!bl || this.isPSSubSysIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSID, this.getPSSubSysId());
        }
        if (!bl || this.isPSSubSysVerIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSVERID, this.getPSSubSysVerId());
        }
        if (!bl || this.isPSSubSysVerInstIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSVERINSTID, this.getPSSubSysVerInstId());
        }
        if (!bl || this.isPSSubSysVerInstNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSVERINSTNAME, this.getPSSubSysVerInstName());
        }
        if (!bl || this.isPSSubSysVerNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSVERNAME, this.getPSSubSysVerName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
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
        return PSSubSysVerInstBase.get(this, n);
    }

    private static Object get(PSSubSysVerInstBase pSSubSysVerInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysVerInstBase.getCreateDate();
            }
            case 1: {
                return pSSubSysVerInstBase.getCreateMan();
            }
            case 2: {
                return pSSubSysVerInstBase.getMemo();
            }
            case 3: {
                return pSSubSysVerInstBase.getPSSubSysId();
            }
            case 4: {
                return pSSubSysVerInstBase.getPSSubSysVerId();
            }
            case 5: {
                return pSSubSysVerInstBase.getPSSubSysVerInstId();
            }
            case 6: {
                return pSSubSysVerInstBase.getPSSubSysVerInstName();
            }
            case 7: {
                return pSSubSysVerInstBase.getPSSubSysVerName();
            }
            case 8: {
                return pSSubSysVerInstBase.getPSSvrDomainId();
            }
            case 9: {
                return pSSubSysVerInstBase.getPSSvrDomainName();
            }
            case 10: {
                return pSSubSysVerInstBase.getPSSysModelInstId();
            }
            case 11: {
                return pSSubSysVerInstBase.getPSSysModelInstName();
            }
            case 12: {
                return pSSubSysVerInstBase.getUpdateDate();
            }
            case 13: {
                return pSSubSysVerInstBase.getUpdateMan();
            }
            case 14: {
                return pSSubSysVerInstBase.getValidFlag();
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
        PSSubSysVerInstBase.set(this, n, object);
    }

    private static void set(PSSubSysVerInstBase pSSubSysVerInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysVerInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSubSysVerInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSubSysVerInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSubSysVerInstBase.setPSSubSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSubSysVerInstBase.setPSSubSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSubSysVerInstBase.setPSSubSysVerInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSubSysVerInstBase.setPSSubSysVerInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSubSysVerInstBase.setPSSubSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubSysVerInstBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubSysVerInstBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubSysVerInstBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSubSysVerInstBase.setPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSubSysVerInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSubSysVerInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSubSysVerInstBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSubSysVerInstBase.isNull(this, n);
    }

    private static boolean isNull(PSSubSysVerInstBase pSSubSysVerInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysVerInstBase.getCreateDate() == null;
            }
            case 1: {
                return pSSubSysVerInstBase.getCreateMan() == null;
            }
            case 2: {
                return pSSubSysVerInstBase.getMemo() == null;
            }
            case 3: {
                return pSSubSysVerInstBase.getPSSubSysId() == null;
            }
            case 4: {
                return pSSubSysVerInstBase.getPSSubSysVerId() == null;
            }
            case 5: {
                return pSSubSysVerInstBase.getPSSubSysVerInstId() == null;
            }
            case 6: {
                return pSSubSysVerInstBase.getPSSubSysVerInstName() == null;
            }
            case 7: {
                return pSSubSysVerInstBase.getPSSubSysVerName() == null;
            }
            case 8: {
                return pSSubSysVerInstBase.getPSSvrDomainId() == null;
            }
            case 9: {
                return pSSubSysVerInstBase.getPSSvrDomainName() == null;
            }
            case 10: {
                return pSSubSysVerInstBase.getPSSysModelInstId() == null;
            }
            case 11: {
                return pSSubSysVerInstBase.getPSSysModelInstName() == null;
            }
            case 12: {
                return pSSubSysVerInstBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSubSysVerInstBase.getUpdateMan() == null;
            }
            case 14: {
                return pSSubSysVerInstBase.getValidFlag() == null;
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
        return PSSubSysVerInstBase.contains(this, n);
    }

    private static boolean contains(PSSubSysVerInstBase pSSubSysVerInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysVerInstBase.isCreateDateDirty();
            }
            case 1: {
                return pSSubSysVerInstBase.isCreateManDirty();
            }
            case 2: {
                return pSSubSysVerInstBase.isMemoDirty();
            }
            case 3: {
                return pSSubSysVerInstBase.isPSSubSysIdDirty();
            }
            case 4: {
                return pSSubSysVerInstBase.isPSSubSysVerIdDirty();
            }
            case 5: {
                return pSSubSysVerInstBase.isPSSubSysVerInstIdDirty();
            }
            case 6: {
                return pSSubSysVerInstBase.isPSSubSysVerInstNameDirty();
            }
            case 7: {
                return pSSubSysVerInstBase.isPSSubSysVerNameDirty();
            }
            case 8: {
                return pSSubSysVerInstBase.isPSSvrDomainIdDirty();
            }
            case 9: {
                return pSSubSysVerInstBase.isPSSvrDomainNameDirty();
            }
            case 10: {
                return pSSubSysVerInstBase.isPSSysModelInstIdDirty();
            }
            case 11: {
                return pSSubSysVerInstBase.isPSSysModelInstNameDirty();
            }
            case 12: {
                return pSSubSysVerInstBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSubSysVerInstBase.isUpdateManDirty();
            }
            case 14: {
                return pSSubSysVerInstBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubSysVerInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubSysVerInstBase pSSubSysVerInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubSysVerInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubSysVerInstBase.getJSONValue((Object)pSSubSysVerInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubSysVerInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubSysVerInstBase.getJSONValue((Object)pSSubSysVerInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubSysVerInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubSysVerInstBase.getJSONValue((Object)pSSubSysVerInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubSysVerInstBase.getPSSubSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysid", (Object)PSSubSysVerInstBase.getJSONValue((Object)pSSubSysVerInstBase.getPSSubSysId()), (boolean)false);
        }
        if (bl || pSSubSysVerInstBase.getPSSubSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysverid", (Object)PSSubSysVerInstBase.getJSONValue((Object)pSSubSysVerInstBase.getPSSubSysVerId()), (boolean)false);
        }
        if (bl || pSSubSysVerInstBase.getPSSubSysVerInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysverinstid", (Object)PSSubSysVerInstBase.getJSONValue((Object)pSSubSysVerInstBase.getPSSubSysVerInstId()), (boolean)false);
        }
        if (bl || pSSubSysVerInstBase.getPSSubSysVerInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysverinstname", (Object)PSSubSysVerInstBase.getJSONValue((Object)pSSubSysVerInstBase.getPSSubSysVerInstName()), (boolean)false);
        }
        if (bl || pSSubSysVerInstBase.getPSSubSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysvername", (Object)PSSubSysVerInstBase.getJSONValue((Object)pSSubSysVerInstBase.getPSSubSysVerName()), (boolean)false);
        }
        if (bl || pSSubSysVerInstBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSSubSysVerInstBase.getJSONValue((Object)pSSubSysVerInstBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSSubSysVerInstBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSSubSysVerInstBase.getJSONValue((Object)pSSubSysVerInstBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSSubSysVerInstBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSSubSysVerInstBase.getJSONValue((Object)pSSubSysVerInstBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSSubSysVerInstBase.getPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstname", (Object)PSSubSysVerInstBase.getJSONValue((Object)pSSubSysVerInstBase.getPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSSubSysVerInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubSysVerInstBase.getJSONValue((Object)pSSubSysVerInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubSysVerInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubSysVerInstBase.getJSONValue((Object)pSSubSysVerInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSubSysVerInstBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSubSysVerInstBase.getJSONValue((Object)pSSubSysVerInstBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubSysVerInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubSysVerInstBase pSSubSysVerInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubSysVerInstBase.getCreateDate() != null) {
            object = pSSubSysVerInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysVerInstBase.getCreateMan() != null) {
            object = pSSubSysVerInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerInstBase.getMemo() != null) {
            object = pSSubSysVerInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerInstBase.getPSSubSysId() != null) {
            object = pSSubSysVerInstBase.getPSSubSysId();
            xmlNode.setAttribute(FIELD_PSSUBSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerInstBase.getPSSubSysVerId() != null) {
            object = pSSubSysVerInstBase.getPSSubSysVerId();
            xmlNode.setAttribute(FIELD_PSSUBSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerInstBase.getPSSubSysVerInstId() != null) {
            object = pSSubSysVerInstBase.getPSSubSysVerInstId();
            xmlNode.setAttribute(FIELD_PSSUBSYSVERINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerInstBase.getPSSubSysVerInstName() != null) {
            object = pSSubSysVerInstBase.getPSSubSysVerInstName();
            xmlNode.setAttribute(FIELD_PSSUBSYSVERINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerInstBase.getPSSubSysVerName() != null) {
            object = pSSubSysVerInstBase.getPSSubSysVerName();
            xmlNode.setAttribute(FIELD_PSSUBSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerInstBase.getPSSvrDomainId() != null) {
            object = pSSubSysVerInstBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerInstBase.getPSSvrDomainName() != null) {
            object = pSSubSysVerInstBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerInstBase.getPSSysModelInstId() != null) {
            object = pSSubSysVerInstBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerInstBase.getPSSysModelInstName() != null) {
            object = pSSubSysVerInstBase.getPSSysModelInstName();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerInstBase.getUpdateDate() != null) {
            object = pSSubSysVerInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysVerInstBase.getUpdateMan() != null) {
            object = pSSubSysVerInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysVerInstBase.getValidFlag() != null) {
            object = pSSubSysVerInstBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubSysVerInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubSysVerInstBase pSSubSysVerInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubSysVerInstBase.isCreateDateDirty() && (bl || pSSubSysVerInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubSysVerInstBase.getCreateDate());
        }
        if (pSSubSysVerInstBase.isCreateManDirty() && (bl || pSSubSysVerInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubSysVerInstBase.getCreateMan());
        }
        if (pSSubSysVerInstBase.isMemoDirty() && (bl || pSSubSysVerInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubSysVerInstBase.getMemo());
        }
        if (pSSubSysVerInstBase.isPSSubSysIdDirty() && (bl || pSSubSysVerInstBase.getPSSubSysId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSID, (Object)pSSubSysVerInstBase.getPSSubSysId());
        }
        if (pSSubSysVerInstBase.isPSSubSysVerIdDirty() && (bl || pSSubSysVerInstBase.getPSSubSysVerId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSVERID, (Object)pSSubSysVerInstBase.getPSSubSysVerId());
        }
        if (pSSubSysVerInstBase.isPSSubSysVerInstIdDirty() && (bl || pSSubSysVerInstBase.getPSSubSysVerInstId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSVERINSTID, (Object)pSSubSysVerInstBase.getPSSubSysVerInstId());
        }
        if (pSSubSysVerInstBase.isPSSubSysVerInstNameDirty() && (bl || pSSubSysVerInstBase.getPSSubSysVerInstName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSVERINSTNAME, (Object)pSSubSysVerInstBase.getPSSubSysVerInstName());
        }
        if (pSSubSysVerInstBase.isPSSubSysVerNameDirty() && (bl || pSSubSysVerInstBase.getPSSubSysVerName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSVERNAME, (Object)pSSubSysVerInstBase.getPSSubSysVerName());
        }
        if (pSSubSysVerInstBase.isPSSvrDomainIdDirty() && (bl || pSSubSysVerInstBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSSubSysVerInstBase.getPSSvrDomainId());
        }
        if (pSSubSysVerInstBase.isPSSvrDomainNameDirty() && (bl || pSSubSysVerInstBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSSubSysVerInstBase.getPSSvrDomainName());
        }
        if (pSSubSysVerInstBase.isPSSysModelInstIdDirty() && (bl || pSSubSysVerInstBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSSubSysVerInstBase.getPSSysModelInstId());
        }
        if (pSSubSysVerInstBase.isPSSysModelInstNameDirty() && (bl || pSSubSysVerInstBase.getPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTNAME, (Object)pSSubSysVerInstBase.getPSSysModelInstName());
        }
        if (pSSubSysVerInstBase.isUpdateDateDirty() && (bl || pSSubSysVerInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubSysVerInstBase.getUpdateDate());
        }
        if (pSSubSysVerInstBase.isUpdateManDirty() && (bl || pSSubSysVerInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubSysVerInstBase.getUpdateMan());
        }
        if (pSSubSysVerInstBase.isValidFlagDirty() && (bl || pSSubSysVerInstBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSubSysVerInstBase.getValidFlag());
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
        return PSSubSysVerInstBase.remove(this, n);
    }

    private static boolean remove(PSSubSysVerInstBase pSSubSysVerInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysVerInstBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSubSysVerInstBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSubSysVerInstBase.resetMemo();
                return true;
            }
            case 3: {
                pSSubSysVerInstBase.resetPSSubSysId();
                return true;
            }
            case 4: {
                pSSubSysVerInstBase.resetPSSubSysVerId();
                return true;
            }
            case 5: {
                pSSubSysVerInstBase.resetPSSubSysVerInstId();
                return true;
            }
            case 6: {
                pSSubSysVerInstBase.resetPSSubSysVerInstName();
                return true;
            }
            case 7: {
                pSSubSysVerInstBase.resetPSSubSysVerName();
                return true;
            }
            case 8: {
                pSSubSysVerInstBase.resetPSSvrDomainId();
                return true;
            }
            case 9: {
                pSSubSysVerInstBase.resetPSSvrDomainName();
                return true;
            }
            case 10: {
                pSSubSysVerInstBase.resetPSSysModelInstId();
                return true;
            }
            case 11: {
                pSSubSysVerInstBase.resetPSSysModelInstName();
                return true;
            }
            case 12: {
                pSSubSysVerInstBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSubSysVerInstBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSSubSysVerInstBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysVer getPSSubSysVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysVer();
        }
        if (this.getPSSubSysVerId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysVerLock;
        synchronized (n) {
            if (this.pssubsysver != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysVerId(), (Object)this.pssubsysver.getPSSubSysVerId()) != 0L) {
                this.pssubsysver = null;
            }
            if (this.pssubsysver == null) {
                PSSubSysVer pSSubSysVer = new PSSubSysVer();
                pSSubSysVer.setPSSubSysVerId(this.getPSSubSysVerId());
                PSSubSysVerService pSSubSysVerService = (PSSubSysVerService)ServiceGlobal.getService(PSSubSysVerService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysVerService.autoGet(pSSubSysVer);
                this.pssubsysver = pSSubSysVer;
            }
            return this.pssubsysver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrDomain getPssvrdomain() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssvrdomain();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        Integer n = this.objPssvrdomainLock;
        synchronized (n) {
            if (this.pssvrdomain != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvrDomainId(), (Object)this.pssvrdomain.getPSSvrDomainId()) != 0L) {
                this.pssvrdomain = null;
            }
            if (this.pssvrdomain == null) {
                PSSvrDomain pSSvrDomain = new PSSvrDomain();
                pSSvrDomain.setPSSvrDomainId(this.getPSSvrDomainId());
                PSSvrDomainService pSSvrDomainService = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)this.getSessionFactory());
                pSSvrDomainService.autoGet(pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelInst getPssysmodelinst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssysmodelinst();
        }
        if (this.getPSSysModelInstId() == null) {
            return null;
        }
        Integer n = this.objPssysmodelinstLock;
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

    private PSSubSysVerInstBase getProxyEntity() {
        return this.proxyPSSubSysVerInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubSysVerInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubSysVerInstBase) {
            this.proxyPSSubSysVerInstBase = (PSSubSysVerInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubSysVerInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSUBSYSID, 3);
        fieldIndexMap.put(FIELD_PSSUBSYSVERID, 4);
        fieldIndexMap.put(FIELD_PSSUBSYSVERINSTID, 5);
        fieldIndexMap.put(FIELD_PSSUBSYSVERINSTNAME, 6);
        fieldIndexMap.put(FIELD_PSSUBSYSVERNAME, 7);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 8);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 10);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_VALIDFLAG, 14);
    }
}

