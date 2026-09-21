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
import net.ibizsys.pscore.srv.config.service.PSPFPkgService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPkgVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFPkgVerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PKGPARAM = "PKGPARAM";
    public static final String FIELD_PKGPARAM2 = "PKGPARAM2";
    public static final String FIELD_PKGPARAM3 = "PKGPARAM3";
    public static final String FIELD_PKGPARAM4 = "PKGPARAM4";
    public static final String FIELD_PSDCID = "PSDCID";
    public static final String FIELD_PSDCNAME = "PSDCNAME";
    public static final String FIELD_PSPFPKGID = "PSPFPKGID";
    public static final String FIELD_PSPFPKGNAME = "PSPFPKGNAME";
    public static final String FIELD_PSPFPKGVERID = "PSPFPKGVERID";
    public static final String FIELD_PSPFPKGVERNAME = "PSPFPKGVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PKGPARAM = 3;
    private static final int INDEX_PKGPARAM2 = 4;
    private static final int INDEX_PKGPARAM3 = 5;
    private static final int INDEX_PKGPARAM4 = 6;
    private static final int INDEX_PSDCID = 7;
    private static final int INDEX_PSDCNAME = 8;
    private static final int INDEX_PSPFPKGID = 9;
    private static final int INDEX_PSPFPKGNAME = 10;
    private static final int INDEX_PSPFPKGVERID = 11;
    private static final int INDEX_PSPFPKGVERNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFPkgVerBase proxyPSPFPkgVerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pkgparamDirtyFlag = false;
    private boolean pkgparam2DirtyFlag = false;
    private boolean pkgparam3DirtyFlag = false;
    private boolean pkgparam4DirtyFlag = false;
    private boolean psdcidDirtyFlag = false;
    private boolean psdcnameDirtyFlag = false;
    private boolean pspfpkgidDirtyFlag = false;
    private boolean pspfpkgnameDirtyFlag = false;
    private boolean pspfpkgveridDirtyFlag = false;
    private boolean pspfpkgvernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pkgparam")
    private String pkgparam;
    @Column(name="pkgparam2")
    private String pkgparam2;
    @Column(name="pkgparam3")
    private String pkgparam3;
    @Column(name="pkgparam4")
    private String pkgparam4;
    @Column(name="psdcid")
    private String psdcid;
    @Column(name="psdcname")
    private String psdcname;
    @Column(name="pspfpkgid")
    private String pspfpkgid;
    @Column(name="pspfpkgname")
    private String pspfpkgname;
    @Column(name="pspfpkgverid")
    private String pspfpkgverid;
    @Column(name="pspfpkgvername")
    private String pspfpkgvername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCLock = new Integer(1);
    private PSDevCenter psdc = null;
    private Integer objPSPFPkgLock = new Integer(1);
    private PSPFPkg pspfpkg = null;

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

    public void setPkgParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgparam = string;
        this.pkgparamDirtyFlag = true;
    }

    public String getPkgParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgParam();
        }
        return this.pkgparam;
    }

    public boolean isPkgParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgParamDirty();
        }
        return this.pkgparamDirtyFlag;
    }

    public void resetPkgParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgParam();
            return;
        }
        this.pkgparamDirtyFlag = false;
        this.pkgparam = null;
    }

    public void setPkgParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgparam2 = string;
        this.pkgparam2DirtyFlag = true;
    }

    public String getPkgParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgParam2();
        }
        return this.pkgparam2;
    }

    public boolean isPkgParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgParam2Dirty();
        }
        return this.pkgparam2DirtyFlag;
    }

    public void resetPkgParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgParam2();
            return;
        }
        this.pkgparam2DirtyFlag = false;
        this.pkgparam2 = null;
    }

    public void setPkgParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgparam3 = string;
        this.pkgparam3DirtyFlag = true;
    }

    public String getPkgParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgParam3();
        }
        return this.pkgparam3;
    }

    public boolean isPkgParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgParam3Dirty();
        }
        return this.pkgparam3DirtyFlag;
    }

    public void resetPkgParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgParam3();
            return;
        }
        this.pkgparam3DirtyFlag = false;
        this.pkgparam3 = null;
    }

    public void setPkgParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPkgParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pkgparam4 = string;
        this.pkgparam4DirtyFlag = true;
    }

    public String getPkgParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPkgParam4();
        }
        return this.pkgparam4;
    }

    public boolean isPkgParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPkgParam4Dirty();
        }
        return this.pkgparam4DirtyFlag;
    }

    public void resetPkgParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPkgParam4();
            return;
        }
        this.pkgparam4DirtyFlag = false;
        this.pkgparam4 = null;
    }

    public void setPSDCId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcid = string;
        this.psdcidDirtyFlag = true;
    }

    public String getPSDCId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCId();
        }
        return this.psdcid;
    }

    public boolean isPSDCIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCIdDirty();
        }
        return this.psdcidDirtyFlag;
    }

    public void resetPSDCId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCId();
            return;
        }
        this.psdcidDirtyFlag = false;
        this.psdcid = null;
    }

    public void setPSDCName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcname = string;
        this.psdcnameDirtyFlag = true;
    }

    public String getPSDCName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCName();
        }
        return this.psdcname;
    }

    public boolean isPSDCNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCNameDirty();
        }
        return this.psdcnameDirtyFlag;
    }

    public void resetPSDCName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCName();
            return;
        }
        this.psdcnameDirtyFlag = false;
        this.psdcname = null;
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
        PSPFPkgVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFPkgVerBase pSPFPkgVerBase) {
        pSPFPkgVerBase.resetCreateDate();
        pSPFPkgVerBase.resetCreateMan();
        pSPFPkgVerBase.resetMemo();
        pSPFPkgVerBase.resetPkgParam();
        pSPFPkgVerBase.resetPkgParam2();
        pSPFPkgVerBase.resetPkgParam3();
        pSPFPkgVerBase.resetPkgParam4();
        pSPFPkgVerBase.resetPSDCId();
        pSPFPkgVerBase.resetPSDCName();
        pSPFPkgVerBase.resetPSPFPkgId();
        pSPFPkgVerBase.resetPSPFPkgName();
        pSPFPkgVerBase.resetPSPFPkgVerId();
        pSPFPkgVerBase.resetPSPFPkgVerName();
        pSPFPkgVerBase.resetUpdateDate();
        pSPFPkgVerBase.resetUpdateMan();
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
        if (!bl || this.isPkgParamDirty()) {
            hashMap.put(FIELD_PKGPARAM, this.getPkgParam());
        }
        if (!bl || this.isPkgParam2Dirty()) {
            hashMap.put(FIELD_PKGPARAM2, this.getPkgParam2());
        }
        if (!bl || this.isPkgParam3Dirty()) {
            hashMap.put(FIELD_PKGPARAM3, this.getPkgParam3());
        }
        if (!bl || this.isPkgParam4Dirty()) {
            hashMap.put(FIELD_PKGPARAM4, this.getPkgParam4());
        }
        if (!bl || this.isPSDCIdDirty()) {
            hashMap.put(FIELD_PSDCID, this.getPSDCId());
        }
        if (!bl || this.isPSDCNameDirty()) {
            hashMap.put(FIELD_PSDCNAME, this.getPSDCName());
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
        return PSPFPkgVerBase.get(this, n);
    }

    private static Object get(PSPFPkgVerBase pSPFPkgVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPkgVerBase.getCreateDate();
            }
            case 1: {
                return pSPFPkgVerBase.getCreateMan();
            }
            case 2: {
                return pSPFPkgVerBase.getMemo();
            }
            case 3: {
                return pSPFPkgVerBase.getPkgParam();
            }
            case 4: {
                return pSPFPkgVerBase.getPkgParam2();
            }
            case 5: {
                return pSPFPkgVerBase.getPkgParam3();
            }
            case 6: {
                return pSPFPkgVerBase.getPkgParam4();
            }
            case 7: {
                return pSPFPkgVerBase.getPSDCId();
            }
            case 8: {
                return pSPFPkgVerBase.getPSDCName();
            }
            case 9: {
                return pSPFPkgVerBase.getPSPFPkgId();
            }
            case 10: {
                return pSPFPkgVerBase.getPSPFPkgName();
            }
            case 11: {
                return pSPFPkgVerBase.getPSPFPkgVerId();
            }
            case 12: {
                return pSPFPkgVerBase.getPSPFPkgVerName();
            }
            case 13: {
                return pSPFPkgVerBase.getUpdateDate();
            }
            case 14: {
                return pSPFPkgVerBase.getUpdateMan();
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
        PSPFPkgVerBase.set(this, n, object);
    }

    private static void set(PSPFPkgVerBase pSPFPkgVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFPkgVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFPkgVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFPkgVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFPkgVerBase.setPkgParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFPkgVerBase.setPkgParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFPkgVerBase.setPkgParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFPkgVerBase.setPkgParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFPkgVerBase.setPSDCId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFPkgVerBase.setPSDCName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFPkgVerBase.setPSPFPkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFPkgVerBase.setPSPFPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFPkgVerBase.setPSPFPkgVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFPkgVerBase.setPSPFPkgVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFPkgVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSPFPkgVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFPkgVerBase.isNull(this, n);
    }

    private static boolean isNull(PSPFPkgVerBase pSPFPkgVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPkgVerBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFPkgVerBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFPkgVerBase.getMemo() == null;
            }
            case 3: {
                return pSPFPkgVerBase.getPkgParam() == null;
            }
            case 4: {
                return pSPFPkgVerBase.getPkgParam2() == null;
            }
            case 5: {
                return pSPFPkgVerBase.getPkgParam3() == null;
            }
            case 6: {
                return pSPFPkgVerBase.getPkgParam4() == null;
            }
            case 7: {
                return pSPFPkgVerBase.getPSDCId() == null;
            }
            case 8: {
                return pSPFPkgVerBase.getPSDCName() == null;
            }
            case 9: {
                return pSPFPkgVerBase.getPSPFPkgId() == null;
            }
            case 10: {
                return pSPFPkgVerBase.getPSPFPkgName() == null;
            }
            case 11: {
                return pSPFPkgVerBase.getPSPFPkgVerId() == null;
            }
            case 12: {
                return pSPFPkgVerBase.getPSPFPkgVerName() == null;
            }
            case 13: {
                return pSPFPkgVerBase.getUpdateDate() == null;
            }
            case 14: {
                return pSPFPkgVerBase.getUpdateMan() == null;
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
        return PSPFPkgVerBase.contains(this, n);
    }

    private static boolean contains(PSPFPkgVerBase pSPFPkgVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPkgVerBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFPkgVerBase.isCreateManDirty();
            }
            case 2: {
                return pSPFPkgVerBase.isMemoDirty();
            }
            case 3: {
                return pSPFPkgVerBase.isPkgParamDirty();
            }
            case 4: {
                return pSPFPkgVerBase.isPkgParam2Dirty();
            }
            case 5: {
                return pSPFPkgVerBase.isPkgParam3Dirty();
            }
            case 6: {
                return pSPFPkgVerBase.isPkgParam4Dirty();
            }
            case 7: {
                return pSPFPkgVerBase.isPSDCIdDirty();
            }
            case 8: {
                return pSPFPkgVerBase.isPSDCNameDirty();
            }
            case 9: {
                return pSPFPkgVerBase.isPSPFPkgIdDirty();
            }
            case 10: {
                return pSPFPkgVerBase.isPSPFPkgNameDirty();
            }
            case 11: {
                return pSPFPkgVerBase.isPSPFPkgVerIdDirty();
            }
            case 12: {
                return pSPFPkgVerBase.isPSPFPkgVerNameDirty();
            }
            case 13: {
                return pSPFPkgVerBase.isUpdateDateDirty();
            }
            case 14: {
                return pSPFPkgVerBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFPkgVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFPkgVerBase pSPFPkgVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFPkgVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFPkgVerBase.getJSONValue((Object)pSPFPkgVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFPkgVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFPkgVerBase.getJSONValue((Object)pSPFPkgVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFPkgVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFPkgVerBase.getJSONValue((Object)pSPFPkgVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFPkgVerBase.getPkgParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam", (Object)PSPFPkgVerBase.getJSONValue((Object)pSPFPkgVerBase.getPkgParam()), (boolean)false);
        }
        if (bl || pSPFPkgVerBase.getPkgParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam2", (Object)PSPFPkgVerBase.getJSONValue((Object)pSPFPkgVerBase.getPkgParam2()), (boolean)false);
        }
        if (bl || pSPFPkgVerBase.getPkgParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam3", (Object)PSPFPkgVerBase.getJSONValue((Object)pSPFPkgVerBase.getPkgParam3()), (boolean)false);
        }
        if (bl || pSPFPkgVerBase.getPkgParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkgparam4", (Object)PSPFPkgVerBase.getJSONValue((Object)pSPFPkgVerBase.getPkgParam4()), (boolean)false);
        }
        if (bl || pSPFPkgVerBase.getPSDCId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcid", (Object)PSPFPkgVerBase.getJSONValue((Object)pSPFPkgVerBase.getPSDCId()), (boolean)false);
        }
        if (bl || pSPFPkgVerBase.getPSDCName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcname", (Object)PSPFPkgVerBase.getJSONValue((Object)pSPFPkgVerBase.getPSDCName()), (boolean)false);
        }
        if (bl || pSPFPkgVerBase.getPSPFPkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgid", (Object)PSPFPkgVerBase.getJSONValue((Object)pSPFPkgVerBase.getPSPFPkgId()), (boolean)false);
        }
        if (bl || pSPFPkgVerBase.getPSPFPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgname", (Object)PSPFPkgVerBase.getJSONValue((Object)pSPFPkgVerBase.getPSPFPkgName()), (boolean)false);
        }
        if (bl || pSPFPkgVerBase.getPSPFPkgVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgverid", (Object)PSPFPkgVerBase.getJSONValue((Object)pSPFPkgVerBase.getPSPFPkgVerId()), (boolean)false);
        }
        if (bl || pSPFPkgVerBase.getPSPFPkgVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpkgvername", (Object)PSPFPkgVerBase.getJSONValue((Object)pSPFPkgVerBase.getPSPFPkgVerName()), (boolean)false);
        }
        if (bl || pSPFPkgVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFPkgVerBase.getJSONValue((Object)pSPFPkgVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFPkgVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFPkgVerBase.getJSONValue((Object)pSPFPkgVerBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFPkgVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFPkgVerBase pSPFPkgVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFPkgVerBase.getCreateDate() != null) {
            object = pSPFPkgVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPkgVerBase.getCreateMan() != null) {
            object = pSPFPkgVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerBase.getMemo() != null) {
            object = pSPFPkgVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerBase.getPkgParam() != null) {
            object = pSPFPkgVerBase.getPkgParam();
            xmlNode.setAttribute(FIELD_PKGPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerBase.getPkgParam2() != null) {
            object = pSPFPkgVerBase.getPkgParam2();
            xmlNode.setAttribute(FIELD_PKGPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerBase.getPkgParam3() != null) {
            object = pSPFPkgVerBase.getPkgParam3();
            xmlNode.setAttribute(FIELD_PKGPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerBase.getPkgParam4() != null) {
            object = pSPFPkgVerBase.getPkgParam4();
            xmlNode.setAttribute(FIELD_PKGPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerBase.getPSDCId() != null) {
            object = pSPFPkgVerBase.getPSDCId();
            xmlNode.setAttribute(FIELD_PSDCID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerBase.getPSDCName() != null) {
            object = pSPFPkgVerBase.getPSDCName();
            xmlNode.setAttribute(FIELD_PSDCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerBase.getPSPFPkgId() != null) {
            object = pSPFPkgVerBase.getPSPFPkgId();
            xmlNode.setAttribute(FIELD_PSPFPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerBase.getPSPFPkgName() != null) {
            object = pSPFPkgVerBase.getPSPFPkgName();
            xmlNode.setAttribute(FIELD_PSPFPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerBase.getPSPFPkgVerId() != null) {
            object = pSPFPkgVerBase.getPSPFPkgVerId();
            xmlNode.setAttribute(FIELD_PSPFPKGVERID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerBase.getPSPFPkgVerName() != null) {
            object = pSPFPkgVerBase.getPSPFPkgVerName();
            xmlNode.setAttribute(FIELD_PSPFPKGVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPkgVerBase.getUpdateDate() != null) {
            object = pSPFPkgVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPkgVerBase.getUpdateMan() != null) {
            object = pSPFPkgVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFPkgVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFPkgVerBase pSPFPkgVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFPkgVerBase.isCreateDateDirty() && (bl || pSPFPkgVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFPkgVerBase.getCreateDate());
        }
        if (pSPFPkgVerBase.isCreateManDirty() && (bl || pSPFPkgVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFPkgVerBase.getCreateMan());
        }
        if (pSPFPkgVerBase.isMemoDirty() && (bl || pSPFPkgVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFPkgVerBase.getMemo());
        }
        if (pSPFPkgVerBase.isPkgParamDirty() && (bl || pSPFPkgVerBase.getPkgParam() != null)) {
            iDataObject.set(FIELD_PKGPARAM, (Object)pSPFPkgVerBase.getPkgParam());
        }
        if (pSPFPkgVerBase.isPkgParam2Dirty() && (bl || pSPFPkgVerBase.getPkgParam2() != null)) {
            iDataObject.set(FIELD_PKGPARAM2, (Object)pSPFPkgVerBase.getPkgParam2());
        }
        if (pSPFPkgVerBase.isPkgParam3Dirty() && (bl || pSPFPkgVerBase.getPkgParam3() != null)) {
            iDataObject.set(FIELD_PKGPARAM3, (Object)pSPFPkgVerBase.getPkgParam3());
        }
        if (pSPFPkgVerBase.isPkgParam4Dirty() && (bl || pSPFPkgVerBase.getPkgParam4() != null)) {
            iDataObject.set(FIELD_PKGPARAM4, (Object)pSPFPkgVerBase.getPkgParam4());
        }
        if (pSPFPkgVerBase.isPSDCIdDirty() && (bl || pSPFPkgVerBase.getPSDCId() != null)) {
            iDataObject.set(FIELD_PSDCID, (Object)pSPFPkgVerBase.getPSDCId());
        }
        if (pSPFPkgVerBase.isPSDCNameDirty() && (bl || pSPFPkgVerBase.getPSDCName() != null)) {
            iDataObject.set(FIELD_PSDCNAME, (Object)pSPFPkgVerBase.getPSDCName());
        }
        if (pSPFPkgVerBase.isPSPFPkgIdDirty() && (bl || pSPFPkgVerBase.getPSPFPkgId() != null)) {
            iDataObject.set(FIELD_PSPFPKGID, (Object)pSPFPkgVerBase.getPSPFPkgId());
        }
        if (pSPFPkgVerBase.isPSPFPkgNameDirty() && (bl || pSPFPkgVerBase.getPSPFPkgName() != null)) {
            iDataObject.set(FIELD_PSPFPKGNAME, (Object)pSPFPkgVerBase.getPSPFPkgName());
        }
        if (pSPFPkgVerBase.isPSPFPkgVerIdDirty() && (bl || pSPFPkgVerBase.getPSPFPkgVerId() != null)) {
            iDataObject.set(FIELD_PSPFPKGVERID, (Object)pSPFPkgVerBase.getPSPFPkgVerId());
        }
        if (pSPFPkgVerBase.isPSPFPkgVerNameDirty() && (bl || pSPFPkgVerBase.getPSPFPkgVerName() != null)) {
            iDataObject.set(FIELD_PSPFPKGVERNAME, (Object)pSPFPkgVerBase.getPSPFPkgVerName());
        }
        if (pSPFPkgVerBase.isUpdateDateDirty() && (bl || pSPFPkgVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFPkgVerBase.getUpdateDate());
        }
        if (pSPFPkgVerBase.isUpdateManDirty() && (bl || pSPFPkgVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFPkgVerBase.getUpdateMan());
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
        return PSPFPkgVerBase.remove(this, n);
    }

    private static boolean remove(PSPFPkgVerBase pSPFPkgVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFPkgVerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFPkgVerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFPkgVerBase.resetMemo();
                return true;
            }
            case 3: {
                pSPFPkgVerBase.resetPkgParam();
                return true;
            }
            case 4: {
                pSPFPkgVerBase.resetPkgParam2();
                return true;
            }
            case 5: {
                pSPFPkgVerBase.resetPkgParam3();
                return true;
            }
            case 6: {
                pSPFPkgVerBase.resetPkgParam4();
                return true;
            }
            case 7: {
                pSPFPkgVerBase.resetPSDCId();
                return true;
            }
            case 8: {
                pSPFPkgVerBase.resetPSDCName();
                return true;
            }
            case 9: {
                pSPFPkgVerBase.resetPSPFPkgId();
                return true;
            }
            case 10: {
                pSPFPkgVerBase.resetPSPFPkgName();
                return true;
            }
            case 11: {
                pSPFPkgVerBase.resetPSPFPkgVerId();
                return true;
            }
            case 12: {
                pSPFPkgVerBase.resetPSPFPkgVerName();
                return true;
            }
            case 13: {
                pSPFPkgVerBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSPFPkgVerBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDC() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDC();
        }
        if (this.getPSDCId() == null) {
            return null;
        }
        Integer n = this.objPSDCLock;
        synchronized (n) {
            if (this.psdc != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCId(), (Object)this.psdc.getPSDevCenterId()) != 0L) {
                this.psdc = null;
            }
            if (this.psdc == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDCId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdc = pSDevCenter;
            }
            return this.psdc;
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

    private PSPFPkgVerBase getProxyEntity() {
        return this.proxyPSPFPkgVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFPkgVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFPkgVerBase) {
            this.proxyPSPFPkgVerBase = (PSPFPkgVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPkgVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PKGPARAM, 3);
        fieldIndexMap.put(FIELD_PKGPARAM2, 4);
        fieldIndexMap.put(FIELD_PKGPARAM3, 5);
        fieldIndexMap.put(FIELD_PKGPARAM4, 6);
        fieldIndexMap.put(FIELD_PSDCID, 7);
        fieldIndexMap.put(FIELD_PSDCNAME, 8);
        fieldIndexMap.put(FIELD_PSPFPKGID, 9);
        fieldIndexMap.put(FIELD_PSPFPKGNAME, 10);
        fieldIndexMap.put(FIELD_PSPFPKGVERID, 11);
        fieldIndexMap.put(FIELD_PSPFPKGVERNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

