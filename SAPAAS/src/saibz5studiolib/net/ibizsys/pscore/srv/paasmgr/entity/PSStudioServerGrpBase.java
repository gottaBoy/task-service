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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSStudioServerGrpBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSStudioServerGrpBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DOMAINPARAMS = "DOMAINPARAMS";
    public static final String FIELD_IPADDR = "IPADDR";
    public static final String FIELD_IPADDR2 = "IPADDR2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSTUDIOSERVERGRPID = "PSSTUDIOSERVERGRPID";
    public static final String FIELD_PSSTUDIOSERVERGRPNAME = "PSSTUDIOSERVERGRPNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_SERVERPARAMS = "SERVERPARAMS";
    public static final String FIELD_SERVERURL = "SERVERURL";
    public static final String FIELD_SERVERURL2 = "SERVERURL2";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DOMAINPARAMS = 2;
    private static final int INDEX_IPADDR = 3;
    private static final int INDEX_IPADDR2 = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSSTUDIOSERVERGRPID = 6;
    private static final int INDEX_PSSTUDIOSERVERGRPNAME = 7;
    private static final int INDEX_PSSVRDOMAINID = 8;
    private static final int INDEX_PSSVRDOMAINNAME = 9;
    private static final int INDEX_SERVERPARAMS = 10;
    private static final int INDEX_SERVERURL = 11;
    private static final int INDEX_SERVERURL2 = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_VALIDFLAG = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSStudioServerGrpBase proxyPSStudioServerGrpBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean domainparamsDirtyFlag = false;
    private boolean ipaddrDirtyFlag = false;
    private boolean ipaddr2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psstudioservergrpidDirtyFlag = false;
    private boolean psstudioservergrpnameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean serverparamsDirtyFlag = false;
    private boolean serverurlDirtyFlag = false;
    private boolean serverurl2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="domainparams")
    private String domainparams;
    @Column(name="ipaddr")
    private String ipaddr;
    @Column(name="ipaddr2")
    private String ipaddr2;
    @Column(name="memo")
    private String memo;
    @Column(name="psstudioservergrpid")
    private String psstudioservergrpid;
    @Column(name="psstudioservergrpname")
    private String psstudioservergrpname;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="serverparams")
    private String serverparams;
    @Column(name="serverurl")
    private String serverurl;
    @Column(name="serverurl2")
    private String serverurl2;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

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

    public void setDomainParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDomainParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.domainparams = string;
        this.domainparamsDirtyFlag = true;
    }

    public String getDomainParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDomainParams();
        }
        return this.domainparams;
    }

    public boolean isDomainParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDomainParamsDirty();
        }
        return this.domainparamsDirtyFlag;
    }

    public void resetDomainParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDomainParams();
            return;
        }
        this.domainparamsDirtyFlag = false;
        this.domainparams = null;
    }

    public void setIPAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIPAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr = string;
        this.ipaddrDirtyFlag = true;
    }

    public String getIPAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIPAddr();
        }
        return this.ipaddr;
    }

    public boolean isIPAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIPAddrDirty();
        }
        return this.ipaddrDirtyFlag;
    }

    public void resetIPAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIPAddr();
            return;
        }
        this.ipaddrDirtyFlag = false;
        this.ipaddr = null;
    }

    public void setIPAddr2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIPAddr2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ipaddr2 = string;
        this.ipaddr2DirtyFlag = true;
    }

    public String getIPAddr2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIPAddr2();
        }
        return this.ipaddr2;
    }

    public boolean isIPAddr2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIPAddr2Dirty();
        }
        return this.ipaddr2DirtyFlag;
    }

    public void resetIPAddr2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIPAddr2();
            return;
        }
        this.ipaddr2DirtyFlag = false;
        this.ipaddr2 = null;
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

    public void setPSStudioServerGrpId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioServerGrpId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioservergrpid = string;
        this.psstudioservergrpidDirtyFlag = true;
    }

    public String getPSStudioServerGrpId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerGrpId();
        }
        return this.psstudioservergrpid;
    }

    public boolean isPSStudioServerGrpIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioServerGrpIdDirty();
        }
        return this.psstudioservergrpidDirtyFlag;
    }

    public void resetPSStudioServerGrpId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioServerGrpId();
            return;
        }
        this.psstudioservergrpidDirtyFlag = false;
        this.psstudioservergrpid = null;
    }

    public void setPSStudioServerGrpName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSStudioServerGrpName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psstudioservergrpname = string;
        this.psstudioservergrpnameDirtyFlag = true;
    }

    public String getPSStudioServerGrpName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSStudioServerGrpName();
        }
        return this.psstudioservergrpname;
    }

    public boolean isPSStudioServerGrpNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSStudioServerGrpNameDirty();
        }
        return this.psstudioservergrpnameDirtyFlag;
    }

    public void resetPSStudioServerGrpName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSStudioServerGrpName();
            return;
        }
        this.psstudioservergrpnameDirtyFlag = false;
        this.psstudioservergrpname = null;
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

    public void setServerParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServerParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serverparams = string;
        this.serverparamsDirtyFlag = true;
    }

    public String getServerParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServerParams();
        }
        return this.serverparams;
    }

    public boolean isServerParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServerParamsDirty();
        }
        return this.serverparamsDirtyFlag;
    }

    public void resetServerParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServerParams();
            return;
        }
        this.serverparamsDirtyFlag = false;
        this.serverparams = null;
    }

    public void setServerUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServerUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serverurl = string;
        this.serverurlDirtyFlag = true;
    }

    public String getServerUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServerUrl();
        }
        return this.serverurl;
    }

    public boolean isServerUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServerUrlDirty();
        }
        return this.serverurlDirtyFlag;
    }

    public void resetServerUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServerUrl();
            return;
        }
        this.serverurlDirtyFlag = false;
        this.serverurl = null;
    }

    public void setServerUrl2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServerUrl2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serverurl2 = string;
        this.serverurl2DirtyFlag = true;
    }

    public String getServerUrl2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServerUrl2();
        }
        return this.serverurl2;
    }

    public boolean isServerUrl2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServerUrl2Dirty();
        }
        return this.serverurl2DirtyFlag;
    }

    public void resetServerUrl2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServerUrl2();
            return;
        }
        this.serverurl2DirtyFlag = false;
        this.serverurl2 = null;
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
        PSStudioServerGrpBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSStudioServerGrpBase pSStudioServerGrpBase) {
        pSStudioServerGrpBase.resetCreateDate();
        pSStudioServerGrpBase.resetCreateMan();
        pSStudioServerGrpBase.resetDomainParams();
        pSStudioServerGrpBase.resetIPAddr();
        pSStudioServerGrpBase.resetIPAddr2();
        pSStudioServerGrpBase.resetMemo();
        pSStudioServerGrpBase.resetPSStudioServerGrpId();
        pSStudioServerGrpBase.resetPSStudioServerGrpName();
        pSStudioServerGrpBase.resetPSSvrDomainId();
        pSStudioServerGrpBase.resetPSSvrDomainName();
        pSStudioServerGrpBase.resetServerParams();
        pSStudioServerGrpBase.resetServerUrl();
        pSStudioServerGrpBase.resetServerUrl2();
        pSStudioServerGrpBase.resetUpdateDate();
        pSStudioServerGrpBase.resetUpdateMan();
        pSStudioServerGrpBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDomainParamsDirty()) {
            hashMap.put(FIELD_DOMAINPARAMS, this.getDomainParams());
        }
        if (!bl || this.isIPAddrDirty()) {
            hashMap.put(FIELD_IPADDR, this.getIPAddr());
        }
        if (!bl || this.isIPAddr2Dirty()) {
            hashMap.put(FIELD_IPADDR2, this.getIPAddr2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSStudioServerGrpIdDirty()) {
            hashMap.put(FIELD_PSSTUDIOSERVERGRPID, this.getPSStudioServerGrpId());
        }
        if (!bl || this.isPSStudioServerGrpNameDirty()) {
            hashMap.put(FIELD_PSSTUDIOSERVERGRPNAME, this.getPSStudioServerGrpName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isServerParamsDirty()) {
            hashMap.put(FIELD_SERVERPARAMS, this.getServerParams());
        }
        if (!bl || this.isServerUrlDirty()) {
            hashMap.put(FIELD_SERVERURL, this.getServerUrl());
        }
        if (!bl || this.isServerUrl2Dirty()) {
            hashMap.put(FIELD_SERVERURL2, this.getServerUrl2());
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
        return PSStudioServerGrpBase.get(this, n);
    }

    private static Object get(PSStudioServerGrpBase pSStudioServerGrpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioServerGrpBase.getCreateDate();
            }
            case 1: {
                return pSStudioServerGrpBase.getCreateMan();
            }
            case 2: {
                return pSStudioServerGrpBase.getDomainParams();
            }
            case 3: {
                return pSStudioServerGrpBase.getIPAddr();
            }
            case 4: {
                return pSStudioServerGrpBase.getIPAddr2();
            }
            case 5: {
                return pSStudioServerGrpBase.getMemo();
            }
            case 6: {
                return pSStudioServerGrpBase.getPSStudioServerGrpId();
            }
            case 7: {
                return pSStudioServerGrpBase.getPSStudioServerGrpName();
            }
            case 8: {
                return pSStudioServerGrpBase.getPSSvrDomainId();
            }
            case 9: {
                return pSStudioServerGrpBase.getPSSvrDomainName();
            }
            case 10: {
                return pSStudioServerGrpBase.getServerParams();
            }
            case 11: {
                return pSStudioServerGrpBase.getServerUrl();
            }
            case 12: {
                return pSStudioServerGrpBase.getServerUrl2();
            }
            case 13: {
                return pSStudioServerGrpBase.getUpdateDate();
            }
            case 14: {
                return pSStudioServerGrpBase.getUpdateMan();
            }
            case 15: {
                return pSStudioServerGrpBase.getValidFlag();
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
        PSStudioServerGrpBase.set(this, n, object);
    }

    private static void set(PSStudioServerGrpBase pSStudioServerGrpBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSStudioServerGrpBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSStudioServerGrpBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSStudioServerGrpBase.setDomainParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSStudioServerGrpBase.setIPAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSStudioServerGrpBase.setIPAddr2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSStudioServerGrpBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSStudioServerGrpBase.setPSStudioServerGrpId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSStudioServerGrpBase.setPSStudioServerGrpName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSStudioServerGrpBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSStudioServerGrpBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSStudioServerGrpBase.setServerParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSStudioServerGrpBase.setServerUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSStudioServerGrpBase.setServerUrl2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSStudioServerGrpBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSStudioServerGrpBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSStudioServerGrpBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSStudioServerGrpBase.isNull(this, n);
    }

    private static boolean isNull(PSStudioServerGrpBase pSStudioServerGrpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioServerGrpBase.getCreateDate() == null;
            }
            case 1: {
                return pSStudioServerGrpBase.getCreateMan() == null;
            }
            case 2: {
                return pSStudioServerGrpBase.getDomainParams() == null;
            }
            case 3: {
                return pSStudioServerGrpBase.getIPAddr() == null;
            }
            case 4: {
                return pSStudioServerGrpBase.getIPAddr2() == null;
            }
            case 5: {
                return pSStudioServerGrpBase.getMemo() == null;
            }
            case 6: {
                return pSStudioServerGrpBase.getPSStudioServerGrpId() == null;
            }
            case 7: {
                return pSStudioServerGrpBase.getPSStudioServerGrpName() == null;
            }
            case 8: {
                return pSStudioServerGrpBase.getPSSvrDomainId() == null;
            }
            case 9: {
                return pSStudioServerGrpBase.getPSSvrDomainName() == null;
            }
            case 10: {
                return pSStudioServerGrpBase.getServerParams() == null;
            }
            case 11: {
                return pSStudioServerGrpBase.getServerUrl() == null;
            }
            case 12: {
                return pSStudioServerGrpBase.getServerUrl2() == null;
            }
            case 13: {
                return pSStudioServerGrpBase.getUpdateDate() == null;
            }
            case 14: {
                return pSStudioServerGrpBase.getUpdateMan() == null;
            }
            case 15: {
                return pSStudioServerGrpBase.getValidFlag() == null;
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
        return PSStudioServerGrpBase.contains(this, n);
    }

    private static boolean contains(PSStudioServerGrpBase pSStudioServerGrpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSStudioServerGrpBase.isCreateDateDirty();
            }
            case 1: {
                return pSStudioServerGrpBase.isCreateManDirty();
            }
            case 2: {
                return pSStudioServerGrpBase.isDomainParamsDirty();
            }
            case 3: {
                return pSStudioServerGrpBase.isIPAddrDirty();
            }
            case 4: {
                return pSStudioServerGrpBase.isIPAddr2Dirty();
            }
            case 5: {
                return pSStudioServerGrpBase.isMemoDirty();
            }
            case 6: {
                return pSStudioServerGrpBase.isPSStudioServerGrpIdDirty();
            }
            case 7: {
                return pSStudioServerGrpBase.isPSStudioServerGrpNameDirty();
            }
            case 8: {
                return pSStudioServerGrpBase.isPSSvrDomainIdDirty();
            }
            case 9: {
                return pSStudioServerGrpBase.isPSSvrDomainNameDirty();
            }
            case 10: {
                return pSStudioServerGrpBase.isServerParamsDirty();
            }
            case 11: {
                return pSStudioServerGrpBase.isServerUrlDirty();
            }
            case 12: {
                return pSStudioServerGrpBase.isServerUrl2Dirty();
            }
            case 13: {
                return pSStudioServerGrpBase.isUpdateDateDirty();
            }
            case 14: {
                return pSStudioServerGrpBase.isUpdateManDirty();
            }
            case 15: {
                return pSStudioServerGrpBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSStudioServerGrpBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSStudioServerGrpBase pSStudioServerGrpBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSStudioServerGrpBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSStudioServerGrpBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSStudioServerGrpBase.getDomainParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"domainparams", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getDomainParams()), (boolean)false);
        }
        if (bl || pSStudioServerGrpBase.getIPAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getIPAddr()), (boolean)false);
        }
        if (bl || pSStudioServerGrpBase.getIPAddr2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ipaddr2", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getIPAddr2()), (boolean)false);
        }
        if (bl || pSStudioServerGrpBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getMemo()), (boolean)false);
        }
        if (bl || pSStudioServerGrpBase.getPSStudioServerGrpId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioservergrpid", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getPSStudioServerGrpId()), (boolean)false);
        }
        if (bl || pSStudioServerGrpBase.getPSStudioServerGrpName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psstudioservergrpname", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getPSStudioServerGrpName()), (boolean)false);
        }
        if (bl || pSStudioServerGrpBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSStudioServerGrpBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSStudioServerGrpBase.getServerParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serverparams", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getServerParams()), (boolean)false);
        }
        if (bl || pSStudioServerGrpBase.getServerUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serverurl", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getServerUrl()), (boolean)false);
        }
        if (bl || pSStudioServerGrpBase.getServerUrl2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serverurl2", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getServerUrl2()), (boolean)false);
        }
        if (bl || pSStudioServerGrpBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSStudioServerGrpBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSStudioServerGrpBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSStudioServerGrpBase.getJSONValue((Object)pSStudioServerGrpBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSStudioServerGrpBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSStudioServerGrpBase pSStudioServerGrpBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSStudioServerGrpBase.getCreateDate() != null) {
            object = pSStudioServerGrpBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSStudioServerGrpBase.getCreateMan() != null) {
            object = pSStudioServerGrpBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerGrpBase.getDomainParams() != null) {
            object = pSStudioServerGrpBase.getDomainParams();
            xmlNode.setAttribute(FIELD_DOMAINPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerGrpBase.getIPAddr() != null) {
            object = pSStudioServerGrpBase.getIPAddr();
            xmlNode.setAttribute(FIELD_IPADDR, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerGrpBase.getIPAddr2() != null) {
            object = pSStudioServerGrpBase.getIPAddr2();
            xmlNode.setAttribute(FIELD_IPADDR2, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerGrpBase.getMemo() != null) {
            object = pSStudioServerGrpBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerGrpBase.getPSStudioServerGrpId() != null) {
            object = pSStudioServerGrpBase.getPSStudioServerGrpId();
            xmlNode.setAttribute(FIELD_PSSTUDIOSERVERGRPID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerGrpBase.getPSStudioServerGrpName() != null) {
            object = pSStudioServerGrpBase.getPSStudioServerGrpName();
            xmlNode.setAttribute(FIELD_PSSTUDIOSERVERGRPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerGrpBase.getPSSvrDomainId() != null) {
            object = pSStudioServerGrpBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerGrpBase.getPSSvrDomainName() != null) {
            object = pSStudioServerGrpBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerGrpBase.getServerParams() != null) {
            object = pSStudioServerGrpBase.getServerParams();
            xmlNode.setAttribute(FIELD_SERVERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerGrpBase.getServerUrl() != null) {
            object = pSStudioServerGrpBase.getServerUrl();
            xmlNode.setAttribute(FIELD_SERVERURL, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerGrpBase.getServerUrl2() != null) {
            object = pSStudioServerGrpBase.getServerUrl2();
            xmlNode.setAttribute(FIELD_SERVERURL2, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerGrpBase.getUpdateDate() != null) {
            object = pSStudioServerGrpBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSStudioServerGrpBase.getUpdateMan() != null) {
            object = pSStudioServerGrpBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSStudioServerGrpBase.getValidFlag() != null) {
            object = pSStudioServerGrpBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSStudioServerGrpBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSStudioServerGrpBase pSStudioServerGrpBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSStudioServerGrpBase.isCreateDateDirty() && (bl || pSStudioServerGrpBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSStudioServerGrpBase.getCreateDate());
        }
        if (pSStudioServerGrpBase.isCreateManDirty() && (bl || pSStudioServerGrpBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSStudioServerGrpBase.getCreateMan());
        }
        if (pSStudioServerGrpBase.isDomainParamsDirty() && (bl || pSStudioServerGrpBase.getDomainParams() != null)) {
            iDataObject.set(FIELD_DOMAINPARAMS, (Object)pSStudioServerGrpBase.getDomainParams());
        }
        if (pSStudioServerGrpBase.isIPAddrDirty() && (bl || pSStudioServerGrpBase.getIPAddr() != null)) {
            iDataObject.set(FIELD_IPADDR, (Object)pSStudioServerGrpBase.getIPAddr());
        }
        if (pSStudioServerGrpBase.isIPAddr2Dirty() && (bl || pSStudioServerGrpBase.getIPAddr2() != null)) {
            iDataObject.set(FIELD_IPADDR2, (Object)pSStudioServerGrpBase.getIPAddr2());
        }
        if (pSStudioServerGrpBase.isMemoDirty() && (bl || pSStudioServerGrpBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSStudioServerGrpBase.getMemo());
        }
        if (pSStudioServerGrpBase.isPSStudioServerGrpIdDirty() && (bl || pSStudioServerGrpBase.getPSStudioServerGrpId() != null)) {
            iDataObject.set(FIELD_PSSTUDIOSERVERGRPID, (Object)pSStudioServerGrpBase.getPSStudioServerGrpId());
        }
        if (pSStudioServerGrpBase.isPSStudioServerGrpNameDirty() && (bl || pSStudioServerGrpBase.getPSStudioServerGrpName() != null)) {
            iDataObject.set(FIELD_PSSTUDIOSERVERGRPNAME, (Object)pSStudioServerGrpBase.getPSStudioServerGrpName());
        }
        if (pSStudioServerGrpBase.isPSSvrDomainIdDirty() && (bl || pSStudioServerGrpBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSStudioServerGrpBase.getPSSvrDomainId());
        }
        if (pSStudioServerGrpBase.isPSSvrDomainNameDirty() && (bl || pSStudioServerGrpBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSStudioServerGrpBase.getPSSvrDomainName());
        }
        if (pSStudioServerGrpBase.isServerParamsDirty() && (bl || pSStudioServerGrpBase.getServerParams() != null)) {
            iDataObject.set(FIELD_SERVERPARAMS, (Object)pSStudioServerGrpBase.getServerParams());
        }
        if (pSStudioServerGrpBase.isServerUrlDirty() && (bl || pSStudioServerGrpBase.getServerUrl() != null)) {
            iDataObject.set(FIELD_SERVERURL, (Object)pSStudioServerGrpBase.getServerUrl());
        }
        if (pSStudioServerGrpBase.isServerUrl2Dirty() && (bl || pSStudioServerGrpBase.getServerUrl2() != null)) {
            iDataObject.set(FIELD_SERVERURL2, (Object)pSStudioServerGrpBase.getServerUrl2());
        }
        if (pSStudioServerGrpBase.isUpdateDateDirty() && (bl || pSStudioServerGrpBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSStudioServerGrpBase.getUpdateDate());
        }
        if (pSStudioServerGrpBase.isUpdateManDirty() && (bl || pSStudioServerGrpBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSStudioServerGrpBase.getUpdateMan());
        }
        if (pSStudioServerGrpBase.isValidFlagDirty() && (bl || pSStudioServerGrpBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSStudioServerGrpBase.getValidFlag());
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
        return PSStudioServerGrpBase.remove(this, n);
    }

    private static boolean remove(PSStudioServerGrpBase pSStudioServerGrpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSStudioServerGrpBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSStudioServerGrpBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSStudioServerGrpBase.resetDomainParams();
                return true;
            }
            case 3: {
                pSStudioServerGrpBase.resetIPAddr();
                return true;
            }
            case 4: {
                pSStudioServerGrpBase.resetIPAddr2();
                return true;
            }
            case 5: {
                pSStudioServerGrpBase.resetMemo();
                return true;
            }
            case 6: {
                pSStudioServerGrpBase.resetPSStudioServerGrpId();
                return true;
            }
            case 7: {
                pSStudioServerGrpBase.resetPSStudioServerGrpName();
                return true;
            }
            case 8: {
                pSStudioServerGrpBase.resetPSSvrDomainId();
                return true;
            }
            case 9: {
                pSStudioServerGrpBase.resetPSSvrDomainName();
                return true;
            }
            case 10: {
                pSStudioServerGrpBase.resetServerParams();
                return true;
            }
            case 11: {
                pSStudioServerGrpBase.resetServerUrl();
                return true;
            }
            case 12: {
                pSStudioServerGrpBase.resetServerUrl2();
                return true;
            }
            case 13: {
                pSStudioServerGrpBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSStudioServerGrpBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSStudioServerGrpBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrDomain getPSSvrDomain() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomain();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        Integer n = this.objPSSvrDomainLock;
        synchronized (n) {
            if (this.pssvrdomain != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvrDomainId(), (Object)this.pssvrdomain.getPSSvrDomainId()) != 0L) {
                this.pssvrdomain = null;
            }
            if (this.pssvrdomain == null) {
                PSSvrDomain pSSvrDomain = new PSSvrDomain();
                pSSvrDomain.setPSSvrDomainId(this.getPSSvrDomainId());
                PSSvrDomainService pSSvrDomainService = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)this.getSessionFactory());
                pSSvrDomainService.autoGet((IEntity)pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    private PSStudioServerGrpBase getProxyEntity() {
        return this.proxyPSStudioServerGrpBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSStudioServerGrpBase = null;
        if (iDataObject != null && iDataObject instanceof PSStudioServerGrpBase) {
            this.proxyPSStudioServerGrpBase = (PSStudioServerGrpBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerGrpService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DOMAINPARAMS, 2);
        fieldIndexMap.put(FIELD_IPADDR, 3);
        fieldIndexMap.put(FIELD_IPADDR2, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSSTUDIOSERVERGRPID, 6);
        fieldIndexMap.put(FIELD_PSSTUDIOSERVERGRPNAME, 7);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 8);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 9);
        fieldIndexMap.put(FIELD_SERVERPARAMS, 10);
        fieldIndexMap.put(FIELD_SERVERURL, 11);
        fieldIndexMap.put(FIELD_SERVERURL2, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_VALIDFLAG, 15);
    }
}

