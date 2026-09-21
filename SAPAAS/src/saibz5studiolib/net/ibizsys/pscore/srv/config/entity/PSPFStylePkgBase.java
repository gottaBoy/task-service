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
import net.ibizsys.pscore.srv.config.entity.PSPFPkg;
import net.ibizsys.pscore.srv.config.entity.PSPFPkgVer;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFPkgService;
import net.ibizsys.pscore.srv.config.service.PSPFPkgVerService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFStylePkgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFStylePkgBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSPFPKGID = "PSPFPKGID";
    public static final String FIELD_PSPFPKGNAME = "PSPFPKGNAME";
    public static final String FIELD_PSPFPKGVERID = "PSPFPKGVERID";
    public static final String FIELD_PSPFPKGVERNAME = "PSPFPKGVERNAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSPFSTYLEPKGID = "PSPFSTYLEPKGID";
    public static final String FIELD_PSPFSTYLEPKGNAME = "PSPFSTYLEPKGNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PSPFPKGID = 4;
    private static final int INDEX_PSPFPKGNAME = 5;
    private static final int INDEX_PSPFPKGVERID = 6;
    private static final int INDEX_PSPFPKGVERNAME = 7;
    private static final int INDEX_PSPFSTYLEID = 8;
    private static final int INDEX_PSPFSTYLENAME = 9;
    private static final int INDEX_PSPFSTYLEPKGID = 10;
    private static final int INDEX_PSPFSTYLEPKGNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFStylePkgBase proxyPSPFStylePkgBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pspfpkgidDirtyFlag = false;
    private boolean pspfpkgnameDirtyFlag = false;
    private boolean pspfpkgveridDirtyFlag = false;
    private boolean pspfpkgvernameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pspfstylepkgidDirtyFlag = false;
    private boolean pspfstylepkgnameDirtyFlag = false;
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
    @Column(name="pspfpkgid")
    private String pspfpkgid;
    @Column(name="pspfpkgname")
    private String pspfpkgname;
    @Column(name="pspfpkgverid")
    private String pspfpkgverid;
    @Column(name="pspfpkgvername")
    private String pspfpkgvername;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="pspfstylepkgid")
    private String pspfstylepkgid;
    @Column(name="pspfstylepkgname")
    private String pspfstylepkgname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSPFPkgVerLock = new Integer(1);
    private PSPFPkgVer pspfpkgver = null;
    private Integer objPSPFPkgLock = new Integer(1);
    private PSPFPkg pspfpkg = null;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;

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

    public void setPSPFPkgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPkgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpkgid = string;
        this.pspfpkgidDirtyFlag = true;
    }

    public String getPSPFPkgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgId();
        }
        return this.pspfpkgid;
    }

    public boolean isPSPFPkgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPkgIdDirty();
        }
        return this.pspfpkgidDirtyFlag;
    }

    public void resetPSPFPkgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPkgId();
            return;
        }
        this.pspfpkgidDirtyFlag = false;
        this.pspfpkgid = null;
    }

    public void setPSPFPkgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPkgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpkgname = string;
        this.pspfpkgnameDirtyFlag = true;
    }

    public String getPSPFPkgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgName();
        }
        return this.pspfpkgname;
    }

    public boolean isPSPFPkgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPkgNameDirty();
        }
        return this.pspfpkgnameDirtyFlag;
    }

    public void resetPSPFPkgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPkgName();
            return;
        }
        this.pspfpkgnameDirtyFlag = false;
        this.pspfpkgname = null;
    }

    public void setPSPFPkgVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPkgVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpkgverid = string;
        this.pspfpkgveridDirtyFlag = true;
    }

    public String getPSPFPkgVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgVerId();
        }
        return this.pspfpkgverid;
    }

    public boolean isPSPFPkgVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPkgVerIdDirty();
        }
        return this.pspfpkgveridDirtyFlag;
    }

    public void resetPSPFPkgVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPkgVerId();
            return;
        }
        this.pspfpkgveridDirtyFlag = false;
        this.pspfpkgverid = null;
    }

    public void setPSPFPkgVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPkgVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpkgvername = string;
        this.pspfpkgvernameDirtyFlag = true;
    }

    public String getPSPFPkgVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgVerName();
        }
        return this.pspfpkgvername;
    }

    public boolean isPSPFPkgVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPkgVerNameDirty();
        }
        return this.pspfpkgvernameDirtyFlag;
    }

    public void resetPSPFPkgVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPkgVerName();
            return;
        }
        this.pspfpkgvernameDirtyFlag = false;
        this.pspfpkgvername = null;
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

    public void setPSPFStylePkgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStylePkgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylepkgid = string;
        this.pspfstylepkgidDirtyFlag = true;
    }

    public String getPSPFStylePkgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStylePkgId();
        }
        return this.pspfstylepkgid;
    }

    public boolean isPSPFStylePkgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStylePkgIdDirty();
        }
        return this.pspfstylepkgidDirtyFlag;
    }

    public void resetPSPFStylePkgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStylePkgId();
            return;
        }
        this.pspfstylepkgidDirtyFlag = false;
        this.pspfstylepkgid = null;
    }

    public void setPSPFStylePkgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStylePkgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylepkgname = string;
        this.pspfstylepkgnameDirtyFlag = true;
    }

    public String getPSPFStylePkgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStylePkgName();
        }
        return this.pspfstylepkgname;
    }

    public boolean isPSPFStylePkgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStylePkgNameDirty();
        }
        return this.pspfstylepkgnameDirtyFlag;
    }

    public void resetPSPFStylePkgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStylePkgName();
            return;
        }
        this.pspfstylepkgnameDirtyFlag = false;
        this.pspfstylepkgname = null;
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
        PSPFStylePkgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFStylePkgBase pSPFStylePkgBase) {
        pSPFStylePkgBase.resetCreateDate();
        pSPFStylePkgBase.resetCreateMan();
        pSPFStylePkgBase.resetMemo();
        pSPFStylePkgBase.resetOrderValue();
        pSPFStylePkgBase.resetPSPFPkgId();
        pSPFStylePkgBase.resetPSPFPkgName();
        pSPFStylePkgBase.resetPSPFPkgVerId();
        pSPFStylePkgBase.resetPSPFPkgVerName();
        pSPFStylePkgBase.resetPSPFStyleId();
        pSPFStylePkgBase.resetPSPFStyleName();
        pSPFStylePkgBase.resetPSPFStylePkgId();
        pSPFStylePkgBase.resetPSPFStylePkgName();
        pSPFStylePkgBase.resetUpdateDate();
        pSPFStylePkgBase.resetUpdateMan();
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
        if (!bl || this.isPSPFPkgIdDirty()) {
            hashMap.put(FIELD_PSPFPKGID, this.getPSPFPkgId());
        }
        if (!bl || this.isPSPFPkgNameDirty()) {
            hashMap.put(FIELD_PSPFPKGNAME, this.getPSPFPkgName());
        }
        if (!bl || this.isPSPFPkgVerIdDirty()) {
            hashMap.put(FIELD_PSPFPKGVERID, this.getPSPFPkgVerId());
        }
        if (!bl || this.isPSPFPkgVerNameDirty()) {
            hashMap.put(FIELD_PSPFPKGVERNAME, this.getPSPFPkgVerName());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
        }
        if (!bl || this.isPSPFStylePkgIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEPKGID, this.getPSPFStylePkgId());
        }
        if (!bl || this.isPSPFStylePkgNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLEPKGNAME, this.getPSPFStylePkgName());
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
        return PSPFStylePkgBase.get(this, n);
    }

    private static Object get(PSPFStylePkgBase pSPFStylePkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStylePkgBase.getCreateDate();
            }
            case 1: {
                return pSPFStylePkgBase.getCreateMan();
            }
            case 2: {
                return pSPFStylePkgBase.getMemo();
            }
            case 3: {
                return pSPFStylePkgBase.getOrderValue();
            }
            case 4: {
                return pSPFStylePkgBase.getPSPFPkgId();
            }
            case 5: {
                return pSPFStylePkgBase.getPSPFPkgName();
            }
            case 6: {
                return pSPFStylePkgBase.getPSPFPkgVerId();
            }
            case 7: {
                return pSPFStylePkgBase.getPSPFPkgVerName();
            }
            case 8: {
                return pSPFStylePkgBase.getPSPFStyleId();
            }
            case 9: {
                return pSPFStylePkgBase.getPSPFStyleName();
            }
            case 10: {
                return pSPFStylePkgBase.getPSPFStylePkgId();
            }
            case 11: {
                return pSPFStylePkgBase.getPSPFStylePkgName();
            }
            case 12: {
                return pSPFStylePkgBase.getUpdateDate();
            }
            case 13: {
                return pSPFStylePkgBase.getUpdateMan();
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
        PSPFStylePkgBase.set(this, n, object);
    }

    private static void set(PSPFStylePkgBase pSPFStylePkgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFStylePkgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFStylePkgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFStylePkgBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFStylePkgBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSPFStylePkgBase.setPSPFPkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFStylePkgBase.setPSPFPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFStylePkgBase.setPSPFPkgVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFStylePkgBase.setPSPFPkgVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFStylePkgBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFStylePkgBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFStylePkgBase.setPSPFStylePkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFStylePkgBase.setPSPFStylePkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFStylePkgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSPFStylePkgBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFStylePkgBase.isNull(this, n);
    }

    private static boolean isNull(PSPFStylePkgBase pSPFStylePkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStylePkgBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFStylePkgBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFStylePkgBase.getMemo() == null;
            }
            case 3: {
                return pSPFStylePkgBase.getOrderValue() == null;
            }
            case 4: {
                return pSPFStylePkgBase.getPSPFPkgId() == null;
            }
            case 5: {
                return pSPFStylePkgBase.getPSPFPkgName() == null;
            }
            case 6: {
                return pSPFStylePkgBase.getPSPFPkgVerId() == null;
            }
            case 7: {
                return pSPFStylePkgBase.getPSPFPkgVerName() == null;
            }
            case 8: {
                return pSPFStylePkgBase.getPSPFStyleId() == null;
            }
            case 9: {
                return pSPFStylePkgBase.getPSPFStyleName() == null;
            }
            case 10: {
                return pSPFStylePkgBase.getPSPFStylePkgId() == null;
            }
            case 11: {
                return pSPFStylePkgBase.getPSPFStylePkgName() == null;
            }
            case 12: {
                return pSPFStylePkgBase.getUpdateDate() == null;
            }
            case 13: {
                return pSPFStylePkgBase.getUpdateMan() == null;
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
        return PSPFStylePkgBase.contains(this, n);
    }

    private static boolean contains(PSPFStylePkgBase pSPFStylePkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFStylePkgBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFStylePkgBase.isCreateManDirty();
            }
            case 2: {
                return pSPFStylePkgBase.isMemoDirty();
            }
            case 3: {
                return pSPFStylePkgBase.isOrderValueDirty();
            }
            case 4: {
                return pSPFStylePkgBase.isPSPFPkgIdDirty();
            }
            case 5: {
                return pSPFStylePkgBase.isPSPFPkgNameDirty();
            }
            case 6: {
                return pSPFStylePkgBase.isPSPFPkgVerIdDirty();
            }
            case 7: {
                return pSPFStylePkgBase.isPSPFPkgVerNameDirty();
            }
            case 8: {
                return pSPFStylePkgBase.isPSPFStyleIdDirty();
            }
            case 9: {
                return pSPFStylePkgBase.isPSPFStyleNameDirty();
            }
            case 10: {
                return pSPFStylePkgBase.isPSPFStylePkgIdDirty();
            }
            case 11: {
                return pSPFStylePkgBase.isPSPFStylePkgNameDirty();
            }
            case 12: {
                return pSPFStylePkgBase.isUpdateDateDirty();
            }
            case 13: {
                return pSPFStylePkgBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFStylePkgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFStylePkgBase pSPFStylePkgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFStylePkgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFStylePkgBase.getJSONValue((Object)pSPFStylePkgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFStylePkgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFStylePkgBase.getJSONValue((Object)pSPFStylePkgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFStylePkgBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFStylePkgBase.getJSONValue((Object)pSPFStylePkgBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFStylePkgBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSPFStylePkgBase.getJSONValue((Object)pSPFStylePkgBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSPFStylePkgBase.getPSPFPkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgid", (Object)PSPFStylePkgBase.getJSONValue((Object)pSPFStylePkgBase.getPSPFPkgId()), (boolean)false);
        }
        if (bl || pSPFStylePkgBase.getPSPFPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgname", (Object)PSPFStylePkgBase.getJSONValue((Object)pSPFStylePkgBase.getPSPFPkgName()), (boolean)false);
        }
        if (bl || pSPFStylePkgBase.getPSPFPkgVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgverid", (Object)PSPFStylePkgBase.getJSONValue((Object)pSPFStylePkgBase.getPSPFPkgVerId()), (boolean)false);
        }
        if (bl || pSPFStylePkgBase.getPSPFPkgVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgvername", (Object)PSPFStylePkgBase.getJSONValue((Object)pSPFStylePkgBase.getPSPFPkgVerName()), (boolean)false);
        }
        if (bl || pSPFStylePkgBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFStylePkgBase.getJSONValue((Object)pSPFStylePkgBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFStylePkgBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFStylePkgBase.getJSONValue((Object)pSPFStylePkgBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFStylePkgBase.getPSPFStylePkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylepkgid", (Object)PSPFStylePkgBase.getJSONValue((Object)pSPFStylePkgBase.getPSPFStylePkgId()), (boolean)false);
        }
        if (bl || pSPFStylePkgBase.getPSPFStylePkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylepkgname", (Object)PSPFStylePkgBase.getJSONValue((Object)pSPFStylePkgBase.getPSPFStylePkgName()), (boolean)false);
        }
        if (bl || pSPFStylePkgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFStylePkgBase.getJSONValue((Object)pSPFStylePkgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFStylePkgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFStylePkgBase.getJSONValue((Object)pSPFStylePkgBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFStylePkgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFStylePkgBase pSPFStylePkgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFStylePkgBase.getCreateDate() != null) {
            object = pSPFStylePkgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFStylePkgBase.getCreateMan() != null) {
            object = pSPFStylePkgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePkgBase.getMemo() != null) {
            object = pSPFStylePkgBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePkgBase.getOrderValue() != null) {
            object = pSPFStylePkgBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFStylePkgBase.getPSPFPkgId() != null) {
            object = pSPFStylePkgBase.getPSPFPkgId();
            xmlNode.setAttribute(FIELD_PSPFPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePkgBase.getPSPFPkgName() != null) {
            object = pSPFStylePkgBase.getPSPFPkgName();
            xmlNode.setAttribute(FIELD_PSPFPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePkgBase.getPSPFPkgVerId() != null) {
            object = pSPFStylePkgBase.getPSPFPkgVerId();
            xmlNode.setAttribute(FIELD_PSPFPKGVERID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePkgBase.getPSPFPkgVerName() != null) {
            object = pSPFStylePkgBase.getPSPFPkgVerName();
            xmlNode.setAttribute(FIELD_PSPFPKGVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePkgBase.getPSPFStyleId() != null) {
            object = pSPFStylePkgBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePkgBase.getPSPFStyleName() != null) {
            object = pSPFStylePkgBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePkgBase.getPSPFStylePkgId() != null) {
            object = pSPFStylePkgBase.getPSPFStylePkgId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePkgBase.getPSPFStylePkgName() != null) {
            object = pSPFStylePkgBase.getPSPFStylePkgName();
            xmlNode.setAttribute(FIELD_PSPFSTYLEPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFStylePkgBase.getUpdateDate() != null) {
            object = pSPFStylePkgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFStylePkgBase.getUpdateMan() != null) {
            object = pSPFStylePkgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFStylePkgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFStylePkgBase pSPFStylePkgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFStylePkgBase.isCreateDateDirty() && (bl || pSPFStylePkgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFStylePkgBase.getCreateDate());
        }
        if (pSPFStylePkgBase.isCreateManDirty() && (bl || pSPFStylePkgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFStylePkgBase.getCreateMan());
        }
        if (pSPFStylePkgBase.isMemoDirty() && (bl || pSPFStylePkgBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFStylePkgBase.getMemo());
        }
        if (pSPFStylePkgBase.isOrderValueDirty() && (bl || pSPFStylePkgBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSPFStylePkgBase.getOrderValue());
        }
        if (pSPFStylePkgBase.isPSPFPkgIdDirty() && (bl || pSPFStylePkgBase.getPSPFPkgId() != null)) {
            iDataObject.set(FIELD_PSPFPKGID, (Object)pSPFStylePkgBase.getPSPFPkgId());
        }
        if (pSPFStylePkgBase.isPSPFPkgNameDirty() && (bl || pSPFStylePkgBase.getPSPFPkgName() != null)) {
            iDataObject.set(FIELD_PSPFPKGNAME, (Object)pSPFStylePkgBase.getPSPFPkgName());
        }
        if (pSPFStylePkgBase.isPSPFPkgVerIdDirty() && (bl || pSPFStylePkgBase.getPSPFPkgVerId() != null)) {
            iDataObject.set(FIELD_PSPFPKGVERID, (Object)pSPFStylePkgBase.getPSPFPkgVerId());
        }
        if (pSPFStylePkgBase.isPSPFPkgVerNameDirty() && (bl || pSPFStylePkgBase.getPSPFPkgVerName() != null)) {
            iDataObject.set(FIELD_PSPFPKGVERNAME, (Object)pSPFStylePkgBase.getPSPFPkgVerName());
        }
        if (pSPFStylePkgBase.isPSPFStyleIdDirty() && (bl || pSPFStylePkgBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFStylePkgBase.getPSPFStyleId());
        }
        if (pSPFStylePkgBase.isPSPFStyleNameDirty() && (bl || pSPFStylePkgBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFStylePkgBase.getPSPFStyleName());
        }
        if (pSPFStylePkgBase.isPSPFStylePkgIdDirty() && (bl || pSPFStylePkgBase.getPSPFStylePkgId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEPKGID, (Object)pSPFStylePkgBase.getPSPFStylePkgId());
        }
        if (pSPFStylePkgBase.isPSPFStylePkgNameDirty() && (bl || pSPFStylePkgBase.getPSPFStylePkgName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEPKGNAME, (Object)pSPFStylePkgBase.getPSPFStylePkgName());
        }
        if (pSPFStylePkgBase.isUpdateDateDirty() && (bl || pSPFStylePkgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFStylePkgBase.getUpdateDate());
        }
        if (pSPFStylePkgBase.isUpdateManDirty() && (bl || pSPFStylePkgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFStylePkgBase.getUpdateMan());
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
        return PSPFStylePkgBase.remove(this, n);
    }

    private static boolean remove(PSPFStylePkgBase pSPFStylePkgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFStylePkgBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFStylePkgBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFStylePkgBase.resetMemo();
                return true;
            }
            case 3: {
                pSPFStylePkgBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSPFStylePkgBase.resetPSPFPkgId();
                return true;
            }
            case 5: {
                pSPFStylePkgBase.resetPSPFPkgName();
                return true;
            }
            case 6: {
                pSPFStylePkgBase.resetPSPFPkgVerId();
                return true;
            }
            case 7: {
                pSPFStylePkgBase.resetPSPFPkgVerName();
                return true;
            }
            case 8: {
                pSPFStylePkgBase.resetPSPFStyleId();
                return true;
            }
            case 9: {
                pSPFStylePkgBase.resetPSPFStyleName();
                return true;
            }
            case 10: {
                pSPFStylePkgBase.resetPSPFStylePkgId();
                return true;
            }
            case 11: {
                pSPFStylePkgBase.resetPSPFStylePkgName();
                return true;
            }
            case 12: {
                pSPFStylePkgBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSPFStylePkgBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPkgVer getPSPFPkgVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkgVer();
        }
        if (this.getPSPFPkgVerId() == null) {
            return null;
        }
        Integer n = this.objPSPFPkgVerLock;
        synchronized (n) {
            if (this.pspfpkgver != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPkgVerId(), (Object)this.pspfpkgver.getPSPFPkgVerId()) != 0L) {
                this.pspfpkgver = null;
            }
            if (this.pspfpkgver == null) {
                PSPFPkgVer pSPFPkgVer = new PSPFPkgVer();
                pSPFPkgVer.setPSPFPkgVerId(this.getPSPFPkgVerId());
                PSPFPkgVerService pSPFPkgVerService = (PSPFPkgVerService)ServiceGlobal.getService(PSPFPkgVerService.class, (SessionFactory)this.getSessionFactory());
                pSPFPkgVerService.autoGet((IEntity)pSPFPkgVer);
                this.pspfpkgver = pSPFPkgVer;
            }
            return this.pspfpkgver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPkg getPSPFPkg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPkg();
        }
        if (this.getPSPFPkgId() == null) {
            return null;
        }
        Integer n = this.objPSPFPkgLock;
        synchronized (n) {
            if (this.pspfpkg != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPkgId(), (Object)this.pspfpkg.getPSPFPkgId()) != 0L) {
                this.pspfpkg = null;
            }
            if (this.pspfpkg == null) {
                PSPFPkg pSPFPkg = new PSPFPkg();
                pSPFPkg.setPSPFPkgId(this.getPSPFPkgId());
                PSPFPkgService pSPFPkgService = (PSPFPkgService)ServiceGlobal.getService(PSPFPkgService.class, (SessionFactory)this.getSessionFactory());
                pSPFPkgService.autoGet((IEntity)pSPFPkg);
                this.pspfpkg = pSPFPkg;
            }
            return this.pspfpkg;
        }
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
                pSPFStyleService.autoGet((IEntity)pSPFStyle);
                this.pspfstyle = pSPFStyle;
            }
            return this.pspfstyle;
        }
    }

    private PSPFStylePkgBase getProxyEntity() {
        return this.proxyPSPFStylePkgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFStylePkgBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFStylePkgBase) {
            this.proxyPSPFStylePkgBase = (PSPFStylePkgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStylePkgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PSPFPKGID, 4);
        fieldIndexMap.put(FIELD_PSPFPKGNAME, 5);
        fieldIndexMap.put(FIELD_PSPFPKGVERID, 6);
        fieldIndexMap.put(FIELD_PSPFPKGVERNAME, 7);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 8);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 9);
        fieldIndexMap.put(FIELD_PSPFSTYLEPKGID, 10);
        fieldIndexMap.put(FIELD_PSPFSTYLEPKGNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

