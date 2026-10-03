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
import net.ibizsys.pscore.srv.config.entity.PSSFPkg;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgVer;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSSFPkgService;
import net.ibizsys.pscore.srv.config.service.PSSFPkgVerService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFStylePkgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFStylePkgBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSSFPKGID = "PSSFPKGID";
    public static final String FIELD_PSSFPKGNAME = "PSSFPKGNAME";
    public static final String FIELD_PSSFPKGVERID = "PSSFPKGVERID";
    public static final String FIELD_PSSFPKGVERNAME = "PSSFPKGVERNAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PSSFSTYLEPKGID = "PSSFSTYLEPKGID";
    public static final String FIELD_PSSFSTYLEPKGNAME = "PSSFSTYLEPKGNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PSSFPKGID = 4;
    private static final int INDEX_PSSFPKGNAME = 5;
    private static final int INDEX_PSSFPKGVERID = 6;
    private static final int INDEX_PSSFPKGVERNAME = 7;
    private static final int INDEX_PSSFSTYLEID = 8;
    private static final int INDEX_PSSFSTYLENAME = 9;
    private static final int INDEX_PSSFSTYLEPKGID = 10;
    private static final int INDEX_PSSFSTYLEPKGNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFStylePkgBase proxyPSSFStylePkgBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pssfpkgidDirtyFlag = false;
    private boolean pssfpkgnameDirtyFlag = false;
    private boolean pssfpkgveridDirtyFlag = false;
    private boolean pssfpkgvernameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean pssfstylepkgidDirtyFlag = false;
    private boolean pssfstylepkgnameDirtyFlag = false;
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
    @Column(name="pssfpkgid")
    private String pssfpkgid;
    @Column(name="pssfpkgname")
    private String pssfpkgname;
    @Column(name="pssfpkgverid")
    private String pssfpkgverid;
    @Column(name="pssfpkgvername")
    private String pssfpkgvername;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="pssfstylepkgid")
    private String pssfstylepkgid;
    @Column(name="pssfstylepkgname")
    private String pssfstylepkgname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSFPkgVerLock = new Integer(1);
    private PSSFPkgVer pssfpkgver = null;
    private Integer objPSSFPkgLock = new Integer(1);
    private PSSFPkg pssfpkg = null;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;

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

    public void setPSSFPkgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPkgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpkgid = string;
        this.pssfpkgidDirtyFlag = true;
    }

    public String getPSSFPkgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgId();
        }
        return this.pssfpkgid;
    }

    public boolean isPSSFPkgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPkgIdDirty();
        }
        return this.pssfpkgidDirtyFlag;
    }

    public void resetPSSFPkgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPkgId();
            return;
        }
        this.pssfpkgidDirtyFlag = false;
        this.pssfpkgid = null;
    }

    public void setPSSFPkgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPkgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpkgname = string;
        this.pssfpkgnameDirtyFlag = true;
    }

    public String getPSSFPkgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgName();
        }
        return this.pssfpkgname;
    }

    public boolean isPSSFPkgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPkgNameDirty();
        }
        return this.pssfpkgnameDirtyFlag;
    }

    public void resetPSSFPkgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPkgName();
            return;
        }
        this.pssfpkgnameDirtyFlag = false;
        this.pssfpkgname = null;
    }

    public void setPSSFPkgVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPkgVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpkgverid = string;
        this.pssfpkgveridDirtyFlag = true;
    }

    public String getPSSFPkgVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgVerId();
        }
        return this.pssfpkgverid;
    }

    public boolean isPSSFPkgVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPkgVerIdDirty();
        }
        return this.pssfpkgveridDirtyFlag;
    }

    public void resetPSSFPkgVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPkgVerId();
            return;
        }
        this.pssfpkgveridDirtyFlag = false;
        this.pssfpkgverid = null;
    }

    public void setPSSFPkgVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPkgVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpkgvername = string;
        this.pssfpkgvernameDirtyFlag = true;
    }

    public String getPSSFPkgVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgVerName();
        }
        return this.pssfpkgvername;
    }

    public boolean isPSSFPkgVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPkgVerNameDirty();
        }
        return this.pssfpkgvernameDirtyFlag;
    }

    public void resetPSSFPkgVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPkgVerName();
            return;
        }
        this.pssfpkgvernameDirtyFlag = false;
        this.pssfpkgvername = null;
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

    public void setPSSFStylePkgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStylePkgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylepkgid = string;
        this.pssfstylepkgidDirtyFlag = true;
    }

    public String getPSSFStylePkgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStylePkgId();
        }
        return this.pssfstylepkgid;
    }

    public boolean isPSSFStylePkgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStylePkgIdDirty();
        }
        return this.pssfstylepkgidDirtyFlag;
    }

    public void resetPSSFStylePkgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStylePkgId();
            return;
        }
        this.pssfstylepkgidDirtyFlag = false;
        this.pssfstylepkgid = null;
    }

    public void setPSSFStylePkgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStylePkgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylepkgname = string;
        this.pssfstylepkgnameDirtyFlag = true;
    }

    public String getPSSFStylePkgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStylePkgName();
        }
        return this.pssfstylepkgname;
    }

    public boolean isPSSFStylePkgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStylePkgNameDirty();
        }
        return this.pssfstylepkgnameDirtyFlag;
    }

    public void resetPSSFStylePkgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStylePkgName();
            return;
        }
        this.pssfstylepkgnameDirtyFlag = false;
        this.pssfstylepkgname = null;
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
        PSSFStylePkgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFStylePkgBase pSSFStylePkgBase) {
        pSSFStylePkgBase.resetCreateDate();
        pSSFStylePkgBase.resetCreateMan();
        pSSFStylePkgBase.resetMemo();
        pSSFStylePkgBase.resetOrderValue();
        pSSFStylePkgBase.resetPSSFPkgId();
        pSSFStylePkgBase.resetPSSFPkgName();
        pSSFStylePkgBase.resetPSSFPkgVerId();
        pSSFStylePkgBase.resetPSSFPkgVerName();
        pSSFStylePkgBase.resetPSSFStyleId();
        pSSFStylePkgBase.resetPSSFStyleName();
        pSSFStylePkgBase.resetPSSFStylePkgId();
        pSSFStylePkgBase.resetPSSFStylePkgName();
        pSSFStylePkgBase.resetUpdateDate();
        pSSFStylePkgBase.resetUpdateMan();
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
        if (!bl || this.isPSSFPkgIdDirty()) {
            hashMap.put(FIELD_PSSFPKGID, this.getPSSFPkgId());
        }
        if (!bl || this.isPSSFPkgNameDirty()) {
            hashMap.put(FIELD_PSSFPKGNAME, this.getPSSFPkgName());
        }
        if (!bl || this.isPSSFPkgVerIdDirty()) {
            hashMap.put(FIELD_PSSFPKGVERID, this.getPSSFPkgVerId());
        }
        if (!bl || this.isPSSFPkgVerNameDirty()) {
            hashMap.put(FIELD_PSSFPKGVERNAME, this.getPSSFPkgVerName());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
        }
        if (!bl || this.isPSSFStylePkgIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEPKGID, this.getPSSFStylePkgId());
        }
        if (!bl || this.isPSSFStylePkgNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLEPKGNAME, this.getPSSFStylePkgName());
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
        return PSSFStylePkgBase.get(this, n);
    }

    private static Object get(PSSFStylePkgBase pSSFStylePkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStylePkgBase.getCreateDate();
            }
            case 1: {
                return pSSFStylePkgBase.getCreateMan();
            }
            case 2: {
                return pSSFStylePkgBase.getMemo();
            }
            case 3: {
                return pSSFStylePkgBase.getOrderValue();
            }
            case 4: {
                return pSSFStylePkgBase.getPSSFPkgId();
            }
            case 5: {
                return pSSFStylePkgBase.getPSSFPkgName();
            }
            case 6: {
                return pSSFStylePkgBase.getPSSFPkgVerId();
            }
            case 7: {
                return pSSFStylePkgBase.getPSSFPkgVerName();
            }
            case 8: {
                return pSSFStylePkgBase.getPSSFStyleId();
            }
            case 9: {
                return pSSFStylePkgBase.getPSSFStyleName();
            }
            case 10: {
                return pSSFStylePkgBase.getPSSFStylePkgId();
            }
            case 11: {
                return pSSFStylePkgBase.getPSSFStylePkgName();
            }
            case 12: {
                return pSSFStylePkgBase.getUpdateDate();
            }
            case 13: {
                return pSSFStylePkgBase.getUpdateMan();
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
        PSSFStylePkgBase.set(this, n, object);
    }

    private static void set(PSSFStylePkgBase pSSFStylePkgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFStylePkgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFStylePkgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFStylePkgBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFStylePkgBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSFStylePkgBase.setPSSFPkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFStylePkgBase.setPSSFPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFStylePkgBase.setPSSFPkgVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFStylePkgBase.setPSSFPkgVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFStylePkgBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFStylePkgBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFStylePkgBase.setPSSFStylePkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFStylePkgBase.setPSSFStylePkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFStylePkgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSFStylePkgBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSFStylePkgBase.isNull(this, n);
    }

    private static boolean isNull(PSSFStylePkgBase pSSFStylePkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStylePkgBase.getCreateDate() == null;
            }
            case 1: {
                return pSSFStylePkgBase.getCreateMan() == null;
            }
            case 2: {
                return pSSFStylePkgBase.getMemo() == null;
            }
            case 3: {
                return pSSFStylePkgBase.getOrderValue() == null;
            }
            case 4: {
                return pSSFStylePkgBase.getPSSFPkgId() == null;
            }
            case 5: {
                return pSSFStylePkgBase.getPSSFPkgName() == null;
            }
            case 6: {
                return pSSFStylePkgBase.getPSSFPkgVerId() == null;
            }
            case 7: {
                return pSSFStylePkgBase.getPSSFPkgVerName() == null;
            }
            case 8: {
                return pSSFStylePkgBase.getPSSFStyleId() == null;
            }
            case 9: {
                return pSSFStylePkgBase.getPSSFStyleName() == null;
            }
            case 10: {
                return pSSFStylePkgBase.getPSSFStylePkgId() == null;
            }
            case 11: {
                return pSSFStylePkgBase.getPSSFStylePkgName() == null;
            }
            case 12: {
                return pSSFStylePkgBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSFStylePkgBase.getUpdateMan() == null;
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
        return PSSFStylePkgBase.contains(this, n);
    }

    private static boolean contains(PSSFStylePkgBase pSSFStylePkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStylePkgBase.isCreateDateDirty();
            }
            case 1: {
                return pSSFStylePkgBase.isCreateManDirty();
            }
            case 2: {
                return pSSFStylePkgBase.isMemoDirty();
            }
            case 3: {
                return pSSFStylePkgBase.isOrderValueDirty();
            }
            case 4: {
                return pSSFStylePkgBase.isPSSFPkgIdDirty();
            }
            case 5: {
                return pSSFStylePkgBase.isPSSFPkgNameDirty();
            }
            case 6: {
                return pSSFStylePkgBase.isPSSFPkgVerIdDirty();
            }
            case 7: {
                return pSSFStylePkgBase.isPSSFPkgVerNameDirty();
            }
            case 8: {
                return pSSFStylePkgBase.isPSSFStyleIdDirty();
            }
            case 9: {
                return pSSFStylePkgBase.isPSSFStyleNameDirty();
            }
            case 10: {
                return pSSFStylePkgBase.isPSSFStylePkgIdDirty();
            }
            case 11: {
                return pSSFStylePkgBase.isPSSFStylePkgNameDirty();
            }
            case 12: {
                return pSSFStylePkgBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSFStylePkgBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFStylePkgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFStylePkgBase pSSFStylePkgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFStylePkgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFStylePkgBase.getJSONValue((Object)pSSFStylePkgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFStylePkgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFStylePkgBase.getJSONValue((Object)pSSFStylePkgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFStylePkgBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFStylePkgBase.getJSONValue((Object)pSSFStylePkgBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFStylePkgBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSFStylePkgBase.getJSONValue((Object)pSSFStylePkgBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSFStylePkgBase.getPSSFPkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgid", (Object)PSSFStylePkgBase.getJSONValue((Object)pSSFStylePkgBase.getPSSFPkgId()), (boolean)false);
        }
        if (bl || pSSFStylePkgBase.getPSSFPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgname", (Object)PSSFStylePkgBase.getJSONValue((Object)pSSFStylePkgBase.getPSSFPkgName()), (boolean)false);
        }
        if (bl || pSSFStylePkgBase.getPSSFPkgVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgverid", (Object)PSSFStylePkgBase.getJSONValue((Object)pSSFStylePkgBase.getPSSFPkgVerId()), (boolean)false);
        }
        if (bl || pSSFStylePkgBase.getPSSFPkgVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgvername", (Object)PSSFStylePkgBase.getJSONValue((Object)pSSFStylePkgBase.getPSSFPkgVerName()), (boolean)false);
        }
        if (bl || pSSFStylePkgBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSFStylePkgBase.getJSONValue((Object)pSSFStylePkgBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFStylePkgBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSFStylePkgBase.getJSONValue((Object)pSSFStylePkgBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFStylePkgBase.getPSSFStylePkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylepkgid", (Object)PSSFStylePkgBase.getJSONValue((Object)pSSFStylePkgBase.getPSSFStylePkgId()), (boolean)false);
        }
        if (bl || pSSFStylePkgBase.getPSSFStylePkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylepkgname", (Object)PSSFStylePkgBase.getJSONValue((Object)pSSFStylePkgBase.getPSSFStylePkgName()), (boolean)false);
        }
        if (bl || pSSFStylePkgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFStylePkgBase.getJSONValue((Object)pSSFStylePkgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFStylePkgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFStylePkgBase.getJSONValue((Object)pSSFStylePkgBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFStylePkgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFStylePkgBase pSSFStylePkgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFStylePkgBase.getCreateDate() != null) {
            object = pSSFStylePkgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStylePkgBase.getCreateMan() != null) {
            object = pSSFStylePkgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePkgBase.getMemo() != null) {
            object = pSSFStylePkgBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePkgBase.getOrderValue() != null) {
            object = pSSFStylePkgBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFStylePkgBase.getPSSFPkgId() != null) {
            object = pSSFStylePkgBase.getPSSFPkgId();
            xmlNode.setAttribute(FIELD_PSSFPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePkgBase.getPSSFPkgName() != null) {
            object = pSSFStylePkgBase.getPSSFPkgName();
            xmlNode.setAttribute(FIELD_PSSFPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePkgBase.getPSSFPkgVerId() != null) {
            object = pSSFStylePkgBase.getPSSFPkgVerId();
            xmlNode.setAttribute(FIELD_PSSFPKGVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePkgBase.getPSSFPkgVerName() != null) {
            object = pSSFStylePkgBase.getPSSFPkgVerName();
            xmlNode.setAttribute(FIELD_PSSFPKGVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePkgBase.getPSSFStyleId() != null) {
            object = pSSFStylePkgBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePkgBase.getPSSFStyleName() != null) {
            object = pSSFStylePkgBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePkgBase.getPSSFStylePkgId() != null) {
            object = pSSFStylePkgBase.getPSSFStylePkgId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePkgBase.getPSSFStylePkgName() != null) {
            object = pSSFStylePkgBase.getPSSFStylePkgName();
            xmlNode.setAttribute(FIELD_PSSFSTYLEPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStylePkgBase.getUpdateDate() != null) {
            object = pSSFStylePkgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStylePkgBase.getUpdateMan() != null) {
            object = pSSFStylePkgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFStylePkgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFStylePkgBase pSSFStylePkgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFStylePkgBase.isCreateDateDirty() && (bl || pSSFStylePkgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFStylePkgBase.getCreateDate());
        }
        if (pSSFStylePkgBase.isCreateManDirty() && (bl || pSSFStylePkgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFStylePkgBase.getCreateMan());
        }
        if (pSSFStylePkgBase.isMemoDirty() && (bl || pSSFStylePkgBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFStylePkgBase.getMemo());
        }
        if (pSSFStylePkgBase.isOrderValueDirty() && (bl || pSSFStylePkgBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSFStylePkgBase.getOrderValue());
        }
        if (pSSFStylePkgBase.isPSSFPkgIdDirty() && (bl || pSSFStylePkgBase.getPSSFPkgId() != null)) {
            iDataObject.set(FIELD_PSSFPKGID, (Object)pSSFStylePkgBase.getPSSFPkgId());
        }
        if (pSSFStylePkgBase.isPSSFPkgNameDirty() && (bl || pSSFStylePkgBase.getPSSFPkgName() != null)) {
            iDataObject.set(FIELD_PSSFPKGNAME, (Object)pSSFStylePkgBase.getPSSFPkgName());
        }
        if (pSSFStylePkgBase.isPSSFPkgVerIdDirty() && (bl || pSSFStylePkgBase.getPSSFPkgVerId() != null)) {
            iDataObject.set(FIELD_PSSFPKGVERID, (Object)pSSFStylePkgBase.getPSSFPkgVerId());
        }
        if (pSSFStylePkgBase.isPSSFPkgVerNameDirty() && (bl || pSSFStylePkgBase.getPSSFPkgVerName() != null)) {
            iDataObject.set(FIELD_PSSFPKGVERNAME, (Object)pSSFStylePkgBase.getPSSFPkgVerName());
        }
        if (pSSFStylePkgBase.isPSSFStyleIdDirty() && (bl || pSSFStylePkgBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSFStylePkgBase.getPSSFStyleId());
        }
        if (pSSFStylePkgBase.isPSSFStyleNameDirty() && (bl || pSSFStylePkgBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSFStylePkgBase.getPSSFStyleName());
        }
        if (pSSFStylePkgBase.isPSSFStylePkgIdDirty() && (bl || pSSFStylePkgBase.getPSSFStylePkgId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEPKGID, (Object)pSSFStylePkgBase.getPSSFStylePkgId());
        }
        if (pSSFStylePkgBase.isPSSFStylePkgNameDirty() && (bl || pSSFStylePkgBase.getPSSFStylePkgName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEPKGNAME, (Object)pSSFStylePkgBase.getPSSFStylePkgName());
        }
        if (pSSFStylePkgBase.isUpdateDateDirty() && (bl || pSSFStylePkgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFStylePkgBase.getUpdateDate());
        }
        if (pSSFStylePkgBase.isUpdateManDirty() && (bl || pSSFStylePkgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFStylePkgBase.getUpdateMan());
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
        return PSSFStylePkgBase.remove(this, n);
    }

    private static boolean remove(PSSFStylePkgBase pSSFStylePkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFStylePkgBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSFStylePkgBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSFStylePkgBase.resetMemo();
                return true;
            }
            case 3: {
                pSSFStylePkgBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSSFStylePkgBase.resetPSSFPkgId();
                return true;
            }
            case 5: {
                pSSFStylePkgBase.resetPSSFPkgName();
                return true;
            }
            case 6: {
                pSSFStylePkgBase.resetPSSFPkgVerId();
                return true;
            }
            case 7: {
                pSSFStylePkgBase.resetPSSFPkgVerName();
                return true;
            }
            case 8: {
                pSSFStylePkgBase.resetPSSFStyleId();
                return true;
            }
            case 9: {
                pSSFStylePkgBase.resetPSSFStyleName();
                return true;
            }
            case 10: {
                pSSFStylePkgBase.resetPSSFStylePkgId();
                return true;
            }
            case 11: {
                pSSFStylePkgBase.resetPSSFStylePkgName();
                return true;
            }
            case 12: {
                pSSFStylePkgBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSFStylePkgBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFPkgVer getPSSFPkgVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgVer();
        }
        if (this.getPSSFPkgVerId() == null) {
            return null;
        }
        Integer n = this.objPSSFPkgVerLock;
        synchronized (n) {
            if (this.pssfpkgver != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFPkgVerId(), (Object)this.pssfpkgver.getPSSFPkgVerId()) != 0L) {
                this.pssfpkgver = null;
            }
            if (this.pssfpkgver == null) {
                PSSFPkgVer pSSFPkgVer = new PSSFPkgVer();
                pSSFPkgVer.setPSSFPkgVerId(this.getPSSFPkgVerId());
                PSSFPkgVerService pSSFPkgVerService = (PSSFPkgVerService)ServiceGlobal.getService(PSSFPkgVerService.class, (SessionFactory)this.getSessionFactory());
                pSSFPkgVerService.autoGet(pSSFPkgVer);
                this.pssfpkgver = pSSFPkgVer;
            }
            return this.pssfpkgver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFPkg getPSSFPkg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkg();
        }
        if (this.getPSSFPkgId() == null) {
            return null;
        }
        Integer n = this.objPSSFPkgLock;
        synchronized (n) {
            if (this.pssfpkg != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFPkgId(), (Object)this.pssfpkg.getPSSFPkgId()) != 0L) {
                this.pssfpkg = null;
            }
            if (this.pssfpkg == null) {
                PSSFPkg pSSFPkg = new PSSFPkg();
                pSSFPkg.setPSSFPkgId(this.getPSSFPkgId());
                PSSFPkgService pSSFPkgService = (PSSFPkgService)ServiceGlobal.getService(PSSFPkgService.class, (SessionFactory)this.getSessionFactory());
                pSSFPkgService.autoGet(pSSFPkg);
                this.pssfpkg = pSSFPkg;
            }
            return this.pssfpkg;
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
                pSSFStyleService.autoGet(pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
        }
    }

    private PSSFStylePkgBase getProxyEntity() {
        return this.proxyPSSFStylePkgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFStylePkgBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFStylePkgBase) {
            this.proxyPSSFStylePkgBase = (PSSFStylePkgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStylePkgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PSSFPKGID, 4);
        fieldIndexMap.put(FIELD_PSSFPKGNAME, 5);
        fieldIndexMap.put(FIELD_PSSFPKGVERID, 6);
        fieldIndexMap.put(FIELD_PSSFPKGVERNAME, 7);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 8);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 9);
        fieldIndexMap.put(FIELD_PSSFSTYLEPKGID, 10);
        fieldIndexMap.put(FIELD_PSSFSTYLEPKGNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

