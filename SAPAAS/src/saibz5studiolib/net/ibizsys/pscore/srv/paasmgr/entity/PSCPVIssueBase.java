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
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdIssue;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdVer;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdIssueService;
import net.ibizsys.pscore.srv.paasmgr.service.PSCorePrdVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCPVIssueBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCPVIssueBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ISSUESN = "ISSUESN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCOREPRDISSUEID = "PSCOREPRDISSUEID";
    public static final String FIELD_PSCOREPRDISSUENAME = "PSCOREPRDISSUENAME";
    public static final String FIELD_PSCOREPRDVERID = "PSCOREPRDVERID";
    public static final String FIELD_PSCOREPRDVERNAME = "PSCOREPRDVERNAME";
    public static final String FIELD_PSCPVISSUEID = "PSCPVISSUEID";
    public static final String FIELD_PSCPVISSUENAME = "PSCPVISSUENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ISSUESN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSCOREPRDISSUEID = 4;
    private static final int INDEX_PSCOREPRDISSUENAME = 5;
    private static final int INDEX_PSCOREPRDVERID = 6;
    private static final int INDEX_PSCOREPRDVERNAME = 7;
    private static final int INDEX_PSCPVISSUEID = 8;
    private static final int INDEX_PSCPVISSUENAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCPVIssueBase proxyPSCPVIssueBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean issuesnDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pscoreprdissueidDirtyFlag = false;
    private boolean pscoreprdissuenameDirtyFlag = false;
    private boolean pscoreprdveridDirtyFlag = false;
    private boolean pscoreprdvernameDirtyFlag = false;
    private boolean pscpvissueidDirtyFlag = false;
    private boolean pscpvissuenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="issuesn")
    private Integer issuesn;
    @Column(name="memo")
    private String memo;
    @Column(name="pscoreprdissueid")
    private String pscoreprdissueid;
    @Column(name="pscoreprdissuename")
    private String pscoreprdissuename;
    @Column(name="pscoreprdverid")
    private String pscoreprdverid;
    @Column(name="pscoreprdvername")
    private String pscoreprdvername;
    @Column(name="pscpvissueid")
    private String pscpvissueid;
    @Column(name="pscpvissuename")
    private String pscpvissuename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSCorePrdIssueLock = new Integer(1);
    private PSCorePrdIssue pscoreprdissue = null;
    private Integer objPSCorePrdVerLock = new Integer(1);
    private PSCorePrdVer pscoreprdver = null;

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

    public void setIssueSN(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIssueSN(n);
            return;
        }
        this.issuesn = n;
        this.issuesnDirtyFlag = true;
    }

    public Integer getIssueSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIssueSN();
        }
        return this.issuesn;
    }

    public boolean isIssueSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIssueSNDirty();
        }
        return this.issuesnDirtyFlag;
    }

    public void resetIssueSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIssueSN();
            return;
        }
        this.issuesnDirtyFlag = false;
        this.issuesn = null;
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

    public void setPSCorePrdIssueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdIssueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdissueid = string;
        this.pscoreprdissueidDirtyFlag = true;
    }

    public String getPSCorePrdIssueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdIssueId();
        }
        return this.pscoreprdissueid;
    }

    public boolean isPSCorePrdIssueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdIssueIdDirty();
        }
        return this.pscoreprdissueidDirtyFlag;
    }

    public void resetPSCorePrdIssueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdIssueId();
            return;
        }
        this.pscoreprdissueidDirtyFlag = false;
        this.pscoreprdissueid = null;
    }

    public void setPSCorePrdIssueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdIssueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdissuename = string;
        this.pscoreprdissuenameDirtyFlag = true;
    }

    public String getPSCorePrdIssueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdIssueName();
        }
        return this.pscoreprdissuename;
    }

    public boolean isPSCorePrdIssueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdIssueNameDirty();
        }
        return this.pscoreprdissuenameDirtyFlag;
    }

    public void resetPSCorePrdIssueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdIssueName();
            return;
        }
        this.pscoreprdissuenameDirtyFlag = false;
        this.pscoreprdissuename = null;
    }

    public void setPSCorePrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdverid = string;
        this.pscoreprdveridDirtyFlag = true;
    }

    public String getPSCorePrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVerId();
        }
        return this.pscoreprdverid;
    }

    public boolean isPSCorePrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdVerIdDirty();
        }
        return this.pscoreprdveridDirtyFlag;
    }

    public void resetPSCorePrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdVerId();
            return;
        }
        this.pscoreprdveridDirtyFlag = false;
        this.pscoreprdverid = null;
    }

    public void setPSCorePrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCorePrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscoreprdvername = string;
        this.pscoreprdvernameDirtyFlag = true;
    }

    public String getPSCorePrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVerName();
        }
        return this.pscoreprdvername;
    }

    public boolean isPSCorePrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCorePrdVerNameDirty();
        }
        return this.pscoreprdvernameDirtyFlag;
    }

    public void resetPSCorePrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCorePrdVerName();
            return;
        }
        this.pscoreprdvernameDirtyFlag = false;
        this.pscoreprdvername = null;
    }

    public void setPSCPVIssueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCPVIssueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscpvissueid = string;
        this.pscpvissueidDirtyFlag = true;
    }

    public String getPSCPVIssueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCPVIssueId();
        }
        return this.pscpvissueid;
    }

    public boolean isPSCPVIssueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCPVIssueIdDirty();
        }
        return this.pscpvissueidDirtyFlag;
    }

    public void resetPSCPVIssueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCPVIssueId();
            return;
        }
        this.pscpvissueidDirtyFlag = false;
        this.pscpvissueid = null;
    }

    public void setPSCPVIssueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCPVIssueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscpvissuename = string;
        this.pscpvissuenameDirtyFlag = true;
    }

    public String getPSCPVIssueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCPVIssueName();
        }
        return this.pscpvissuename;
    }

    public boolean isPSCPVIssueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCPVIssueNameDirty();
        }
        return this.pscpvissuenameDirtyFlag;
    }

    public void resetPSCPVIssueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCPVIssueName();
            return;
        }
        this.pscpvissuenameDirtyFlag = false;
        this.pscpvissuename = null;
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
        PSCPVIssueBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCPVIssueBase pSCPVIssueBase) {
        pSCPVIssueBase.resetCreateDate();
        pSCPVIssueBase.resetCreateMan();
        pSCPVIssueBase.resetIssueSN();
        pSCPVIssueBase.resetMemo();
        pSCPVIssueBase.resetPSCorePrdIssueId();
        pSCPVIssueBase.resetPSCorePrdIssueName();
        pSCPVIssueBase.resetPSCorePrdVerId();
        pSCPVIssueBase.resetPSCorePrdVerName();
        pSCPVIssueBase.resetPSCPVIssueId();
        pSCPVIssueBase.resetPSCPVIssueName();
        pSCPVIssueBase.resetUpdateDate();
        pSCPVIssueBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIssueSNDirty()) {
            hashMap.put(FIELD_ISSUESN, this.getIssueSN());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCorePrdIssueIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDISSUEID, this.getPSCorePrdIssueId());
        }
        if (!bl || this.isPSCorePrdIssueNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDISSUENAME, this.getPSCorePrdIssueName());
        }
        if (!bl || this.isPSCorePrdVerIdDirty()) {
            hashMap.put(FIELD_PSCOREPRDVERID, this.getPSCorePrdVerId());
        }
        if (!bl || this.isPSCorePrdVerNameDirty()) {
            hashMap.put(FIELD_PSCOREPRDVERNAME, this.getPSCorePrdVerName());
        }
        if (!bl || this.isPSCPVIssueIdDirty()) {
            hashMap.put(FIELD_PSCPVISSUEID, this.getPSCPVIssueId());
        }
        if (!bl || this.isPSCPVIssueNameDirty()) {
            hashMap.put(FIELD_PSCPVISSUENAME, this.getPSCPVIssueName());
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
        return PSCPVIssueBase.get(this, n);
    }

    private static Object get(PSCPVIssueBase pSCPVIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCPVIssueBase.getCreateDate();
            }
            case 1: {
                return pSCPVIssueBase.getCreateMan();
            }
            case 2: {
                return pSCPVIssueBase.getIssueSN();
            }
            case 3: {
                return pSCPVIssueBase.getMemo();
            }
            case 4: {
                return pSCPVIssueBase.getPSCorePrdIssueId();
            }
            case 5: {
                return pSCPVIssueBase.getPSCorePrdIssueName();
            }
            case 6: {
                return pSCPVIssueBase.getPSCorePrdVerId();
            }
            case 7: {
                return pSCPVIssueBase.getPSCorePrdVerName();
            }
            case 8: {
                return pSCPVIssueBase.getPSCPVIssueId();
            }
            case 9: {
                return pSCPVIssueBase.getPSCPVIssueName();
            }
            case 10: {
                return pSCPVIssueBase.getUpdateDate();
            }
            case 11: {
                return pSCPVIssueBase.getUpdateMan();
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
        PSCPVIssueBase.set(this, n, object);
    }

    private static void set(PSCPVIssueBase pSCPVIssueBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCPVIssueBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSCPVIssueBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCPVIssueBase.setIssueSN(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSCPVIssueBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCPVIssueBase.setPSCorePrdIssueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCPVIssueBase.setPSCorePrdIssueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCPVIssueBase.setPSCorePrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCPVIssueBase.setPSCorePrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCPVIssueBase.setPSCPVIssueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCPVIssueBase.setPSCPVIssueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCPVIssueBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSCPVIssueBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCPVIssueBase.isNull(this, n);
    }

    private static boolean isNull(PSCPVIssueBase pSCPVIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCPVIssueBase.getCreateDate() == null;
            }
            case 1: {
                return pSCPVIssueBase.getCreateMan() == null;
            }
            case 2: {
                return pSCPVIssueBase.getIssueSN() == null;
            }
            case 3: {
                return pSCPVIssueBase.getMemo() == null;
            }
            case 4: {
                return pSCPVIssueBase.getPSCorePrdIssueId() == null;
            }
            case 5: {
                return pSCPVIssueBase.getPSCorePrdIssueName() == null;
            }
            case 6: {
                return pSCPVIssueBase.getPSCorePrdVerId() == null;
            }
            case 7: {
                return pSCPVIssueBase.getPSCorePrdVerName() == null;
            }
            case 8: {
                return pSCPVIssueBase.getPSCPVIssueId() == null;
            }
            case 9: {
                return pSCPVIssueBase.getPSCPVIssueName() == null;
            }
            case 10: {
                return pSCPVIssueBase.getUpdateDate() == null;
            }
            case 11: {
                return pSCPVIssueBase.getUpdateMan() == null;
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
        return PSCPVIssueBase.contains(this, n);
    }

    private static boolean contains(PSCPVIssueBase pSCPVIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCPVIssueBase.isCreateDateDirty();
            }
            case 1: {
                return pSCPVIssueBase.isCreateManDirty();
            }
            case 2: {
                return pSCPVIssueBase.isIssueSNDirty();
            }
            case 3: {
                return pSCPVIssueBase.isMemoDirty();
            }
            case 4: {
                return pSCPVIssueBase.isPSCorePrdIssueIdDirty();
            }
            case 5: {
                return pSCPVIssueBase.isPSCorePrdIssueNameDirty();
            }
            case 6: {
                return pSCPVIssueBase.isPSCorePrdVerIdDirty();
            }
            case 7: {
                return pSCPVIssueBase.isPSCorePrdVerNameDirty();
            }
            case 8: {
                return pSCPVIssueBase.isPSCPVIssueIdDirty();
            }
            case 9: {
                return pSCPVIssueBase.isPSCPVIssueNameDirty();
            }
            case 10: {
                return pSCPVIssueBase.isUpdateDateDirty();
            }
            case 11: {
                return pSCPVIssueBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCPVIssueBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCPVIssueBase pSCPVIssueBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCPVIssueBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCPVIssueBase.getJSONValue((Object)pSCPVIssueBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCPVIssueBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCPVIssueBase.getJSONValue((Object)pSCPVIssueBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCPVIssueBase.getIssueSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"issuesn", (Object)PSCPVIssueBase.getJSONValue((Object)pSCPVIssueBase.getIssueSN()), (boolean)false);
        }
        if (bl || pSCPVIssueBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCPVIssueBase.getJSONValue((Object)pSCPVIssueBase.getMemo()), (boolean)false);
        }
        if (bl || pSCPVIssueBase.getPSCorePrdIssueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdissueid", (Object)PSCPVIssueBase.getJSONValue((Object)pSCPVIssueBase.getPSCorePrdIssueId()), (boolean)false);
        }
        if (bl || pSCPVIssueBase.getPSCorePrdIssueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdissuename", (Object)PSCPVIssueBase.getJSONValue((Object)pSCPVIssueBase.getPSCorePrdIssueName()), (boolean)false);
        }
        if (bl || pSCPVIssueBase.getPSCorePrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdverid", (Object)PSCPVIssueBase.getJSONValue((Object)pSCPVIssueBase.getPSCorePrdVerId()), (boolean)false);
        }
        if (bl || pSCPVIssueBase.getPSCorePrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscoreprdvername", (Object)PSCPVIssueBase.getJSONValue((Object)pSCPVIssueBase.getPSCorePrdVerName()), (boolean)false);
        }
        if (bl || pSCPVIssueBase.getPSCPVIssueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscpvissueid", (Object)PSCPVIssueBase.getJSONValue((Object)pSCPVIssueBase.getPSCPVIssueId()), (boolean)false);
        }
        if (bl || pSCPVIssueBase.getPSCPVIssueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscpvissuename", (Object)PSCPVIssueBase.getJSONValue((Object)pSCPVIssueBase.getPSCPVIssueName()), (boolean)false);
        }
        if (bl || pSCPVIssueBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCPVIssueBase.getJSONValue((Object)pSCPVIssueBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCPVIssueBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCPVIssueBase.getJSONValue((Object)pSCPVIssueBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCPVIssueBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCPVIssueBase pSCPVIssueBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCPVIssueBase.getCreateDate() != null) {
            object = pSCPVIssueBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCPVIssueBase.getCreateMan() != null) {
            object = pSCPVIssueBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCPVIssueBase.getIssueSN() != null) {
            object = pSCPVIssueBase.getIssueSN();
            xmlNode.setAttribute(FIELD_ISSUESN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCPVIssueBase.getMemo() != null) {
            object = pSCPVIssueBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCPVIssueBase.getPSCorePrdIssueId() != null) {
            object = pSCPVIssueBase.getPSCorePrdIssueId();
            xmlNode.setAttribute(FIELD_PSCOREPRDISSUEID, object == null ? "" : (String)object);
        }
        if (bl || pSCPVIssueBase.getPSCorePrdIssueName() != null) {
            object = pSCPVIssueBase.getPSCorePrdIssueName();
            xmlNode.setAttribute(FIELD_PSCOREPRDISSUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCPVIssueBase.getPSCorePrdVerId() != null) {
            object = pSCPVIssueBase.getPSCorePrdVerId();
            xmlNode.setAttribute(FIELD_PSCOREPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSCPVIssueBase.getPSCorePrdVerName() != null) {
            object = pSCPVIssueBase.getPSCorePrdVerName();
            xmlNode.setAttribute(FIELD_PSCOREPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCPVIssueBase.getPSCPVIssueId() != null) {
            object = pSCPVIssueBase.getPSCPVIssueId();
            xmlNode.setAttribute(FIELD_PSCPVISSUEID, object == null ? "" : (String)object);
        }
        if (bl || pSCPVIssueBase.getPSCPVIssueName() != null) {
            object = pSCPVIssueBase.getPSCPVIssueName();
            xmlNode.setAttribute(FIELD_PSCPVISSUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCPVIssueBase.getUpdateDate() != null) {
            object = pSCPVIssueBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCPVIssueBase.getUpdateMan() != null) {
            object = pSCPVIssueBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCPVIssueBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCPVIssueBase pSCPVIssueBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCPVIssueBase.isCreateDateDirty() && (bl || pSCPVIssueBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCPVIssueBase.getCreateDate());
        }
        if (pSCPVIssueBase.isCreateManDirty() && (bl || pSCPVIssueBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCPVIssueBase.getCreateMan());
        }
        if (pSCPVIssueBase.isIssueSNDirty() && (bl || pSCPVIssueBase.getIssueSN() != null)) {
            iDataObject.set(FIELD_ISSUESN, (Object)pSCPVIssueBase.getIssueSN());
        }
        if (pSCPVIssueBase.isMemoDirty() && (bl || pSCPVIssueBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCPVIssueBase.getMemo());
        }
        if (pSCPVIssueBase.isPSCorePrdIssueIdDirty() && (bl || pSCPVIssueBase.getPSCorePrdIssueId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDISSUEID, (Object)pSCPVIssueBase.getPSCorePrdIssueId());
        }
        if (pSCPVIssueBase.isPSCorePrdIssueNameDirty() && (bl || pSCPVIssueBase.getPSCorePrdIssueName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDISSUENAME, (Object)pSCPVIssueBase.getPSCorePrdIssueName());
        }
        if (pSCPVIssueBase.isPSCorePrdVerIdDirty() && (bl || pSCPVIssueBase.getPSCorePrdVerId() != null)) {
            iDataObject.set(FIELD_PSCOREPRDVERID, (Object)pSCPVIssueBase.getPSCorePrdVerId());
        }
        if (pSCPVIssueBase.isPSCorePrdVerNameDirty() && (bl || pSCPVIssueBase.getPSCorePrdVerName() != null)) {
            iDataObject.set(FIELD_PSCOREPRDVERNAME, (Object)pSCPVIssueBase.getPSCorePrdVerName());
        }
        if (pSCPVIssueBase.isPSCPVIssueIdDirty() && (bl || pSCPVIssueBase.getPSCPVIssueId() != null)) {
            iDataObject.set(FIELD_PSCPVISSUEID, (Object)pSCPVIssueBase.getPSCPVIssueId());
        }
        if (pSCPVIssueBase.isPSCPVIssueNameDirty() && (bl || pSCPVIssueBase.getPSCPVIssueName() != null)) {
            iDataObject.set(FIELD_PSCPVISSUENAME, (Object)pSCPVIssueBase.getPSCPVIssueName());
        }
        if (pSCPVIssueBase.isUpdateDateDirty() && (bl || pSCPVIssueBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCPVIssueBase.getUpdateDate());
        }
        if (pSCPVIssueBase.isUpdateManDirty() && (bl || pSCPVIssueBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCPVIssueBase.getUpdateMan());
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
        return PSCPVIssueBase.remove(this, n);
    }

    private static boolean remove(PSCPVIssueBase pSCPVIssueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCPVIssueBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSCPVIssueBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSCPVIssueBase.resetIssueSN();
                return true;
            }
            case 3: {
                pSCPVIssueBase.resetMemo();
                return true;
            }
            case 4: {
                pSCPVIssueBase.resetPSCorePrdIssueId();
                return true;
            }
            case 5: {
                pSCPVIssueBase.resetPSCorePrdIssueName();
                return true;
            }
            case 6: {
                pSCPVIssueBase.resetPSCorePrdVerId();
                return true;
            }
            case 7: {
                pSCPVIssueBase.resetPSCorePrdVerName();
                return true;
            }
            case 8: {
                pSCPVIssueBase.resetPSCPVIssueId();
                return true;
            }
            case 9: {
                pSCPVIssueBase.resetPSCPVIssueName();
                return true;
            }
            case 10: {
                pSCPVIssueBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSCPVIssueBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrdIssue getPSCorePrdIssue() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdIssue();
        }
        if (this.getPSCorePrdIssueId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdIssueLock;
        synchronized (n) {
            if (this.pscoreprdissue != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdIssueId(), (Object)this.pscoreprdissue.getPSCorePrdIssueId()) != 0L) {
                this.pscoreprdissue = null;
            }
            if (this.pscoreprdissue == null) {
                PSCorePrdIssue pSCorePrdIssue = new PSCorePrdIssue();
                pSCorePrdIssue.setPSCorePrdIssueId(this.getPSCorePrdIssueId());
                PSCorePrdIssueService pSCorePrdIssueService = (PSCorePrdIssueService)ServiceGlobal.getService(PSCorePrdIssueService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdIssueService.autoGet((IEntity)pSCorePrdIssue);
                this.pscoreprdissue = pSCorePrdIssue;
            }
            return this.pscoreprdissue;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCorePrdVer getPSCorePrdVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCorePrdVer();
        }
        if (this.getPSCorePrdVerId() == null) {
            return null;
        }
        Integer n = this.objPSCorePrdVerLock;
        synchronized (n) {
            if (this.pscoreprdver != null && DataTypeHelper.compare((int)25, (Object)this.getPSCorePrdVerId(), (Object)this.pscoreprdver.getPSCorePrdVerId()) != 0L) {
                this.pscoreprdver = null;
            }
            if (this.pscoreprdver == null) {
                PSCorePrdVer pSCorePrdVer = new PSCorePrdVer();
                pSCorePrdVer.setPSCorePrdVerId(this.getPSCorePrdVerId());
                PSCorePrdVerService pSCorePrdVerService = (PSCorePrdVerService)ServiceGlobal.getService(PSCorePrdVerService.class, (SessionFactory)this.getSessionFactory());
                pSCorePrdVerService.autoGet((IEntity)pSCorePrdVer);
                this.pscoreprdver = pSCorePrdVer;
            }
            return this.pscoreprdver;
        }
    }

    private PSCPVIssueBase getProxyEntity() {
        return this.proxyPSCPVIssueBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCPVIssueBase = null;
        if (iDataObject != null && iDataObject instanceof PSCPVIssueBase) {
            this.proxyPSCPVIssueBase = (PSCPVIssueBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSCPVIssueService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ISSUESN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSCOREPRDISSUEID, 4);
        fieldIndexMap.put(FIELD_PSCOREPRDISSUENAME, 5);
        fieldIndexMap.put(FIELD_PSCOREPRDVERID, 6);
        fieldIndexMap.put(FIELD_PSCOREPRDVERNAME, 7);
        fieldIndexMap.put(FIELD_PSCPVISSUEID, 8);
        fieldIndexMap.put(FIELD_PSCPVISSUENAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

