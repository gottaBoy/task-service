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
import net.ibizsys.pscore.srv.config.service.PSSFPkgService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFPkgVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFPkgVerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCID = "PSDCID";
    public static final String FIELD_PSDCNAME = "PSDCNAME";
    public static final String FIELD_PSSFPKGID = "PSSFPKGID";
    public static final String FIELD_PSSFPKGNAME = "PSSFPKGNAME";
    public static final String FIELD_PSSFPKGVERID = "PSSFPKGVERID";
    public static final String FIELD_PSSFPKGVERNAME = "PSSFPKGVERNAME";
    public static final String FIELD_SUBSYSVER = "SUBSYSVER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VERPARAM = "VERPARAM";
    public static final String FIELD_VERTAG = "VERTAG";
    public static final String FIELD_VERTAG2 = "VERTAG2";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCID = 3;
    private static final int INDEX_PSDCNAME = 4;
    private static final int INDEX_PSSFPKGID = 5;
    private static final int INDEX_PSSFPKGNAME = 6;
    private static final int INDEX_PSSFPKGVERID = 7;
    private static final int INDEX_PSSFPKGVERNAME = 8;
    private static final int INDEX_SUBSYSVER = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VERPARAM = 12;
    private static final int INDEX_VERTAG = 13;
    private static final int INDEX_VERTAG2 = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFPkgVerBase proxyPSSFPkgVerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcidDirtyFlag = false;
    private boolean psdcnameDirtyFlag = false;
    private boolean pssfpkgidDirtyFlag = false;
    private boolean pssfpkgnameDirtyFlag = false;
    private boolean pssfpkgveridDirtyFlag = false;
    private boolean pssfpkgvernameDirtyFlag = false;
    private boolean subsysverDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean verparamDirtyFlag = false;
    private boolean vertagDirtyFlag = false;
    private boolean vertag2DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcid")
    private String psdcid;
    @Column(name="psdcname")
    private String psdcname;
    @Column(name="pssfpkgid")
    private String pssfpkgid;
    @Column(name="pssfpkgname")
    private String pssfpkgname;
    @Column(name="pssfpkgverid")
    private String pssfpkgverid;
    @Column(name="pssfpkgvername")
    private String pssfpkgvername;
    @Column(name="subsysver")
    private Integer subsysver;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="verparam")
    private String verparam;
    @Column(name="vertag")
    private String vertag;
    @Column(name="vertag2")
    private String vertag2;
    private Integer objPSDCLock = new Integer(1);
    private PSDevCenter psdc = null;
    private Integer objPSSFPkgLock = new Integer(1);
    private PSSFPkg pssfpkg = null;

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

    public void setSubSysVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubSysVer(n);
            return;
        }
        this.subsysver = n;
        this.subsysverDirtyFlag = true;
    }

    public Integer getSubSysVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubSysVer();
        }
        return this.subsysver;
    }

    public boolean isSubSysVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubSysVerDirty();
        }
        return this.subsysverDirtyFlag;
    }

    public void resetSubSysVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubSysVer();
            return;
        }
        this.subsysverDirtyFlag = false;
        this.subsysver = null;
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

    public void setVerParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.verparam = string;
        this.verparamDirtyFlag = true;
    }

    public String getVerParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerParam();
        }
        return this.verparam;
    }

    public boolean isVerParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerParamDirty();
        }
        return this.verparamDirtyFlag;
    }

    public void resetVerParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerParam();
            return;
        }
        this.verparamDirtyFlag = false;
        this.verparam = null;
    }

    public void setVerTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vertag = string;
        this.vertagDirtyFlag = true;
    }

    public String getVerTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerTag();
        }
        return this.vertag;
    }

    public boolean isVerTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerTagDirty();
        }
        return this.vertagDirtyFlag;
    }

    public void resetVerTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerTag();
            return;
        }
        this.vertagDirtyFlag = false;
        this.vertag = null;
    }

    public void setVerTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVerTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vertag2 = string;
        this.vertag2DirtyFlag = true;
    }

    public String getVerTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVerTag2();
        }
        return this.vertag2;
    }

    public boolean isVerTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVerTag2Dirty();
        }
        return this.vertag2DirtyFlag;
    }

    public void resetVerTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVerTag2();
            return;
        }
        this.vertag2DirtyFlag = false;
        this.vertag2 = null;
    }

    protected void onReset() {
        PSSFPkgVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFPkgVerBase pSSFPkgVerBase) {
        pSSFPkgVerBase.resetCreateDate();
        pSSFPkgVerBase.resetCreateMan();
        pSSFPkgVerBase.resetMemo();
        pSSFPkgVerBase.resetPSDCId();
        pSSFPkgVerBase.resetPSDCName();
        pSSFPkgVerBase.resetPSSFPkgId();
        pSSFPkgVerBase.resetPSSFPkgName();
        pSSFPkgVerBase.resetPSSFPkgVerId();
        pSSFPkgVerBase.resetPSSFPkgVerName();
        pSSFPkgVerBase.resetSubSysVer();
        pSSFPkgVerBase.resetUpdateDate();
        pSSFPkgVerBase.resetUpdateMan();
        pSSFPkgVerBase.resetVerParam();
        pSSFPkgVerBase.resetVerTag();
        pSSFPkgVerBase.resetVerTag2();
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
        if (!bl || this.isPSDCIdDirty()) {
            hashMap.put(FIELD_PSDCID, this.getPSDCId());
        }
        if (!bl || this.isPSDCNameDirty()) {
            hashMap.put(FIELD_PSDCNAME, this.getPSDCName());
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
        if (!bl || this.isSubSysVerDirty()) {
            hashMap.put(FIELD_SUBSYSVER, this.getSubSysVer());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isVerParamDirty()) {
            hashMap.put(FIELD_VERPARAM, this.getVerParam());
        }
        if (!bl || this.isVerTagDirty()) {
            hashMap.put(FIELD_VERTAG, this.getVerTag());
        }
        if (!bl || this.isVerTag2Dirty()) {
            hashMap.put(FIELD_VERTAG2, this.getVerTag2());
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
        return PSSFPkgVerBase.get(this, n);
    }

    private static Object get(PSSFPkgVerBase pSSFPkgVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPkgVerBase.getCreateDate();
            }
            case 1: {
                return pSSFPkgVerBase.getCreateMan();
            }
            case 2: {
                return pSSFPkgVerBase.getMemo();
            }
            case 3: {
                return pSSFPkgVerBase.getPSDCId();
            }
            case 4: {
                return pSSFPkgVerBase.getPSDCName();
            }
            case 5: {
                return pSSFPkgVerBase.getPSSFPkgId();
            }
            case 6: {
                return pSSFPkgVerBase.getPSSFPkgName();
            }
            case 7: {
                return pSSFPkgVerBase.getPSSFPkgVerId();
            }
            case 8: {
                return pSSFPkgVerBase.getPSSFPkgVerName();
            }
            case 9: {
                return pSSFPkgVerBase.getSubSysVer();
            }
            case 10: {
                return pSSFPkgVerBase.getUpdateDate();
            }
            case 11: {
                return pSSFPkgVerBase.getUpdateMan();
            }
            case 12: {
                return pSSFPkgVerBase.getVerParam();
            }
            case 13: {
                return pSSFPkgVerBase.getVerTag();
            }
            case 14: {
                return pSSFPkgVerBase.getVerTag2();
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
        PSSFPkgVerBase.set(this, n, object);
    }

    private static void set(PSSFPkgVerBase pSSFPkgVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFPkgVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFPkgVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFPkgVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFPkgVerBase.setPSDCId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFPkgVerBase.setPSDCName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFPkgVerBase.setPSSFPkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFPkgVerBase.setPSSFPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFPkgVerBase.setPSSFPkgVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFPkgVerBase.setPSSFPkgVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFPkgVerBase.setSubSysVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSFPkgVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSFPkgVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFPkgVerBase.setVerParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSFPkgVerBase.setVerTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSFPkgVerBase.setVerTag2(DataObject.getStringValue((Object)object));
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
        return PSSFPkgVerBase.isNull(this, n);
    }

    private static boolean isNull(PSSFPkgVerBase pSSFPkgVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPkgVerBase.getCreateDate() == null;
            }
            case 1: {
                return pSSFPkgVerBase.getCreateMan() == null;
            }
            case 2: {
                return pSSFPkgVerBase.getMemo() == null;
            }
            case 3: {
                return pSSFPkgVerBase.getPSDCId() == null;
            }
            case 4: {
                return pSSFPkgVerBase.getPSDCName() == null;
            }
            case 5: {
                return pSSFPkgVerBase.getPSSFPkgId() == null;
            }
            case 6: {
                return pSSFPkgVerBase.getPSSFPkgName() == null;
            }
            case 7: {
                return pSSFPkgVerBase.getPSSFPkgVerId() == null;
            }
            case 8: {
                return pSSFPkgVerBase.getPSSFPkgVerName() == null;
            }
            case 9: {
                return pSSFPkgVerBase.getSubSysVer() == null;
            }
            case 10: {
                return pSSFPkgVerBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSFPkgVerBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSFPkgVerBase.getVerParam() == null;
            }
            case 13: {
                return pSSFPkgVerBase.getVerTag() == null;
            }
            case 14: {
                return pSSFPkgVerBase.getVerTag2() == null;
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
        return PSSFPkgVerBase.contains(this, n);
    }

    private static boolean contains(PSSFPkgVerBase pSSFPkgVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPkgVerBase.isCreateDateDirty();
            }
            case 1: {
                return pSSFPkgVerBase.isCreateManDirty();
            }
            case 2: {
                return pSSFPkgVerBase.isMemoDirty();
            }
            case 3: {
                return pSSFPkgVerBase.isPSDCIdDirty();
            }
            case 4: {
                return pSSFPkgVerBase.isPSDCNameDirty();
            }
            case 5: {
                return pSSFPkgVerBase.isPSSFPkgIdDirty();
            }
            case 6: {
                return pSSFPkgVerBase.isPSSFPkgNameDirty();
            }
            case 7: {
                return pSSFPkgVerBase.isPSSFPkgVerIdDirty();
            }
            case 8: {
                return pSSFPkgVerBase.isPSSFPkgVerNameDirty();
            }
            case 9: {
                return pSSFPkgVerBase.isSubSysVerDirty();
            }
            case 10: {
                return pSSFPkgVerBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSFPkgVerBase.isUpdateManDirty();
            }
            case 12: {
                return pSSFPkgVerBase.isVerParamDirty();
            }
            case 13: {
                return pSSFPkgVerBase.isVerTagDirty();
            }
            case 14: {
                return pSSFPkgVerBase.isVerTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFPkgVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFPkgVerBase pSSFPkgVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFPkgVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFPkgVerBase.getJSONValue((Object)pSSFPkgVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFPkgVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFPkgVerBase.getJSONValue((Object)pSSFPkgVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFPkgVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFPkgVerBase.getJSONValue((Object)pSSFPkgVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFPkgVerBase.getPSDCId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcid", (Object)PSSFPkgVerBase.getJSONValue((Object)pSSFPkgVerBase.getPSDCId()), (boolean)false);
        }
        if (bl || pSSFPkgVerBase.getPSDCName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcname", (Object)PSSFPkgVerBase.getJSONValue((Object)pSSFPkgVerBase.getPSDCName()), (boolean)false);
        }
        if (bl || pSSFPkgVerBase.getPSSFPkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgid", (Object)PSSFPkgVerBase.getJSONValue((Object)pSSFPkgVerBase.getPSSFPkgId()), (boolean)false);
        }
        if (bl || pSSFPkgVerBase.getPSSFPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgname", (Object)PSSFPkgVerBase.getJSONValue((Object)pSSFPkgVerBase.getPSSFPkgName()), (boolean)false);
        }
        if (bl || pSSFPkgVerBase.getPSSFPkgVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgverid", (Object)PSSFPkgVerBase.getJSONValue((Object)pSSFPkgVerBase.getPSSFPkgVerId()), (boolean)false);
        }
        if (bl || pSSFPkgVerBase.getPSSFPkgVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgvername", (Object)PSSFPkgVerBase.getJSONValue((Object)pSSFPkgVerBase.getPSSFPkgVerName()), (boolean)false);
        }
        if (bl || pSSFPkgVerBase.getSubSysVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subsysver", (Object)PSSFPkgVerBase.getJSONValue((Object)pSSFPkgVerBase.getSubSysVer()), (boolean)false);
        }
        if (bl || pSSFPkgVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFPkgVerBase.getJSONValue((Object)pSSFPkgVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFPkgVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFPkgVerBase.getJSONValue((Object)pSSFPkgVerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFPkgVerBase.getVerParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"verparam", (Object)PSSFPkgVerBase.getJSONValue((Object)pSSFPkgVerBase.getVerParam()), (boolean)false);
        }
        if (bl || pSSFPkgVerBase.getVerTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag", (Object)PSSFPkgVerBase.getJSONValue((Object)pSSFPkgVerBase.getVerTag()), (boolean)false);
        }
        if (bl || pSSFPkgVerBase.getVerTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag2", (Object)PSSFPkgVerBase.getJSONValue((Object)pSSFPkgVerBase.getVerTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFPkgVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFPkgVerBase pSSFPkgVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFPkgVerBase.getCreateDate() != null) {
            object = pSSFPkgVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPkgVerBase.getCreateMan() != null) {
            object = pSSFPkgVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgVerBase.getMemo() != null) {
            object = pSSFPkgVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgVerBase.getPSDCId() != null) {
            object = pSSFPkgVerBase.getPSDCId();
            xmlNode.setAttribute(FIELD_PSDCID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgVerBase.getPSDCName() != null) {
            object = pSSFPkgVerBase.getPSDCName();
            xmlNode.setAttribute(FIELD_PSDCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgVerBase.getPSSFPkgId() != null) {
            object = pSSFPkgVerBase.getPSSFPkgId();
            xmlNode.setAttribute(FIELD_PSSFPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgVerBase.getPSSFPkgName() != null) {
            object = pSSFPkgVerBase.getPSSFPkgName();
            xmlNode.setAttribute(FIELD_PSSFPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgVerBase.getPSSFPkgVerId() != null) {
            object = pSSFPkgVerBase.getPSSFPkgVerId();
            xmlNode.setAttribute(FIELD_PSSFPKGVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgVerBase.getPSSFPkgVerName() != null) {
            object = pSSFPkgVerBase.getPSSFPkgVerName();
            xmlNode.setAttribute(FIELD_PSSFPKGVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgVerBase.getSubSysVer() != null) {
            object = pSSFPkgVerBase.getSubSysVer();
            xmlNode.setAttribute(FIELD_SUBSYSVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFPkgVerBase.getUpdateDate() != null) {
            object = pSSFPkgVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPkgVerBase.getUpdateMan() != null) {
            object = pSSFPkgVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgVerBase.getVerParam() != null) {
            object = pSSFPkgVerBase.getVerParam();
            xmlNode.setAttribute(FIELD_VERPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgVerBase.getVerTag() != null) {
            object = pSSFPkgVerBase.getVerTag();
            xmlNode.setAttribute(FIELD_VERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgVerBase.getVerTag2() != null) {
            object = pSSFPkgVerBase.getVerTag2();
            xmlNode.setAttribute(FIELD_VERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFPkgVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFPkgVerBase pSSFPkgVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFPkgVerBase.isCreateDateDirty() && (bl || pSSFPkgVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFPkgVerBase.getCreateDate());
        }
        if (pSSFPkgVerBase.isCreateManDirty() && (bl || pSSFPkgVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFPkgVerBase.getCreateMan());
        }
        if (pSSFPkgVerBase.isMemoDirty() && (bl || pSSFPkgVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFPkgVerBase.getMemo());
        }
        if (pSSFPkgVerBase.isPSDCIdDirty() && (bl || pSSFPkgVerBase.getPSDCId() != null)) {
            iDataObject.set(FIELD_PSDCID, (Object)pSSFPkgVerBase.getPSDCId());
        }
        if (pSSFPkgVerBase.isPSDCNameDirty() && (bl || pSSFPkgVerBase.getPSDCName() != null)) {
            iDataObject.set(FIELD_PSDCNAME, (Object)pSSFPkgVerBase.getPSDCName());
        }
        if (pSSFPkgVerBase.isPSSFPkgIdDirty() && (bl || pSSFPkgVerBase.getPSSFPkgId() != null)) {
            iDataObject.set(FIELD_PSSFPKGID, (Object)pSSFPkgVerBase.getPSSFPkgId());
        }
        if (pSSFPkgVerBase.isPSSFPkgNameDirty() && (bl || pSSFPkgVerBase.getPSSFPkgName() != null)) {
            iDataObject.set(FIELD_PSSFPKGNAME, (Object)pSSFPkgVerBase.getPSSFPkgName());
        }
        if (pSSFPkgVerBase.isPSSFPkgVerIdDirty() && (bl || pSSFPkgVerBase.getPSSFPkgVerId() != null)) {
            iDataObject.set(FIELD_PSSFPKGVERID, (Object)pSSFPkgVerBase.getPSSFPkgVerId());
        }
        if (pSSFPkgVerBase.isPSSFPkgVerNameDirty() && (bl || pSSFPkgVerBase.getPSSFPkgVerName() != null)) {
            iDataObject.set(FIELD_PSSFPKGVERNAME, (Object)pSSFPkgVerBase.getPSSFPkgVerName());
        }
        if (pSSFPkgVerBase.isSubSysVerDirty() && (bl || pSSFPkgVerBase.getSubSysVer() != null)) {
            iDataObject.set(FIELD_SUBSYSVER, (Object)pSSFPkgVerBase.getSubSysVer());
        }
        if (pSSFPkgVerBase.isUpdateDateDirty() && (bl || pSSFPkgVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFPkgVerBase.getUpdateDate());
        }
        if (pSSFPkgVerBase.isUpdateManDirty() && (bl || pSSFPkgVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFPkgVerBase.getUpdateMan());
        }
        if (pSSFPkgVerBase.isVerParamDirty() && (bl || pSSFPkgVerBase.getVerParam() != null)) {
            iDataObject.set(FIELD_VERPARAM, (Object)pSSFPkgVerBase.getVerParam());
        }
        if (pSSFPkgVerBase.isVerTagDirty() && (bl || pSSFPkgVerBase.getVerTag() != null)) {
            iDataObject.set(FIELD_VERTAG, (Object)pSSFPkgVerBase.getVerTag());
        }
        if (pSSFPkgVerBase.isVerTag2Dirty() && (bl || pSSFPkgVerBase.getVerTag2() != null)) {
            iDataObject.set(FIELD_VERTAG2, (Object)pSSFPkgVerBase.getVerTag2());
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
        return PSSFPkgVerBase.remove(this, n);
    }

    private static boolean remove(PSSFPkgVerBase pSSFPkgVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFPkgVerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSFPkgVerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSFPkgVerBase.resetMemo();
                return true;
            }
            case 3: {
                pSSFPkgVerBase.resetPSDCId();
                return true;
            }
            case 4: {
                pSSFPkgVerBase.resetPSDCName();
                return true;
            }
            case 5: {
                pSSFPkgVerBase.resetPSSFPkgId();
                return true;
            }
            case 6: {
                pSSFPkgVerBase.resetPSSFPkgName();
                return true;
            }
            case 7: {
                pSSFPkgVerBase.resetPSSFPkgVerId();
                return true;
            }
            case 8: {
                pSSFPkgVerBase.resetPSSFPkgVerName();
                return true;
            }
            case 9: {
                pSSFPkgVerBase.resetSubSysVer();
                return true;
            }
            case 10: {
                pSSFPkgVerBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSFPkgVerBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSFPkgVerBase.resetVerParam();
                return true;
            }
            case 13: {
                pSSFPkgVerBase.resetVerTag();
                return true;
            }
            case 14: {
                pSSFPkgVerBase.resetVerTag2();
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdc = pSDevCenter;
            }
            return this.psdc;
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

    private PSSFPkgVerBase getProxyEntity() {
        return this.proxyPSSFPkgVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFPkgVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFPkgVerBase) {
            this.proxyPSSFPkgVerBase = (PSSFPkgVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPkgVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCID, 3);
        fieldIndexMap.put(FIELD_PSDCNAME, 4);
        fieldIndexMap.put(FIELD_PSSFPKGID, 5);
        fieldIndexMap.put(FIELD_PSSFPKGNAME, 6);
        fieldIndexMap.put(FIELD_PSSFPKGVERID, 7);
        fieldIndexMap.put(FIELD_PSSFPKGVERNAME, 8);
        fieldIndexMap.put(FIELD_SUBSYSVER, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VERPARAM, 12);
        fieldIndexMap.put(FIELD_VERTAG, 13);
        fieldIndexMap.put(FIELD_VERTAG2, 14);
    }
}

