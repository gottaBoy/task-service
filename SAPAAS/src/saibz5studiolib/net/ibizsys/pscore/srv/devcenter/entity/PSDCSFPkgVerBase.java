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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSFPkg;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSFPkgService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSFPkgVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCSFPkgVerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCSFPKGID = "PSDCSFPKGID";
    public static final String FIELD_PSDCSFPKGNAME = "PSDCSFPKGNAME";
    public static final String FIELD_PSDCSFPKGVERID = "PSDCSFPKGVERID";
    public static final String FIELD_PSDCSFPKGVERNAME = "PSDCSFPKGVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VERPARAM = "VERPARAM";
    public static final String FIELD_VERTAG = "VERTAG";
    public static final String FIELD_VERTAG2 = "VERTAG2";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCSFPKGID = 3;
    private static final int INDEX_PSDCSFPKGNAME = 4;
    private static final int INDEX_PSDCSFPKGVERID = 5;
    private static final int INDEX_PSDCSFPKGVERNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_VERPARAM = 9;
    private static final int INDEX_VERTAG = 10;
    private static final int INDEX_VERTAG2 = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCSFPkgVerBase proxyPSDCSFPkgVerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcsfpkgidDirtyFlag = false;
    private boolean psdcsfpkgnameDirtyFlag = false;
    private boolean psdcsfpkgveridDirtyFlag = false;
    private boolean psdcsfpkgvernameDirtyFlag = false;
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
    @Column(name="psdcsfpkgid")
    private String psdcsfpkgid;
    @Column(name="psdcsfpkgname")
    private String psdcsfpkgname;
    @Column(name="psdcsfpkgverid")
    private String psdcsfpkgverid;
    @Column(name="psdcsfpkgvername")
    private String psdcsfpkgvername;
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
    private Integer objPSDCSFPkgLock = new Integer(1);
    private PSDCSFPkg psdcsfpkg = null;

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

    public void setPSDCSFPkgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSFPkgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsfpkgid = string;
        this.psdcsfpkgidDirtyFlag = true;
    }

    public String getPSDCSFPkgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSFPkgId();
        }
        return this.psdcsfpkgid;
    }

    public boolean isPSDCSFPkgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSFPkgIdDirty();
        }
        return this.psdcsfpkgidDirtyFlag;
    }

    public void resetPSDCSFPkgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSFPkgId();
            return;
        }
        this.psdcsfpkgidDirtyFlag = false;
        this.psdcsfpkgid = null;
    }

    public void setPSDCSFPkgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSFPkgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsfpkgname = string;
        this.psdcsfpkgnameDirtyFlag = true;
    }

    public String getPSDCSFPkgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSFPkgName();
        }
        return this.psdcsfpkgname;
    }

    public boolean isPSDCSFPkgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSFPkgNameDirty();
        }
        return this.psdcsfpkgnameDirtyFlag;
    }

    public void resetPSDCSFPkgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSFPkgName();
            return;
        }
        this.psdcsfpkgnameDirtyFlag = false;
        this.psdcsfpkgname = null;
    }

    public void setPSDCSFPkgVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSFPkgVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsfpkgverid = string;
        this.psdcsfpkgveridDirtyFlag = true;
    }

    public String getPSDCSFPkgVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSFPkgVerId();
        }
        return this.psdcsfpkgverid;
    }

    public boolean isPSDCSFPkgVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSFPkgVerIdDirty();
        }
        return this.psdcsfpkgveridDirtyFlag;
    }

    public void resetPSDCSFPkgVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSFPkgVerId();
            return;
        }
        this.psdcsfpkgveridDirtyFlag = false;
        this.psdcsfpkgverid = null;
    }

    public void setPSDCSFPkgVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSFPkgVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsfpkgvername = string;
        this.psdcsfpkgvernameDirtyFlag = true;
    }

    public String getPSDCSFPkgVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSFPkgVerName();
        }
        return this.psdcsfpkgvername;
    }

    public boolean isPSDCSFPkgVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSFPkgVerNameDirty();
        }
        return this.psdcsfpkgvernameDirtyFlag;
    }

    public void resetPSDCSFPkgVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSFPkgVerName();
            return;
        }
        this.psdcsfpkgvernameDirtyFlag = false;
        this.psdcsfpkgvername = null;
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
        PSDCSFPkgVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCSFPkgVerBase pSDCSFPkgVerBase) {
        pSDCSFPkgVerBase.resetCreateDate();
        pSDCSFPkgVerBase.resetCreateMan();
        pSDCSFPkgVerBase.resetMemo();
        pSDCSFPkgVerBase.resetPSDCSFPkgId();
        pSDCSFPkgVerBase.resetPSDCSFPkgName();
        pSDCSFPkgVerBase.resetPSDCSFPkgVerId();
        pSDCSFPkgVerBase.resetPSDCSFPkgVerName();
        pSDCSFPkgVerBase.resetUpdateDate();
        pSDCSFPkgVerBase.resetUpdateMan();
        pSDCSFPkgVerBase.resetVerParam();
        pSDCSFPkgVerBase.resetVerTag();
        pSDCSFPkgVerBase.resetVerTag2();
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
        if (!bl || this.isPSDCSFPkgIdDirty()) {
            hashMap.put(FIELD_PSDCSFPKGID, this.getPSDCSFPkgId());
        }
        if (!bl || this.isPSDCSFPkgNameDirty()) {
            hashMap.put(FIELD_PSDCSFPKGNAME, this.getPSDCSFPkgName());
        }
        if (!bl || this.isPSDCSFPkgVerIdDirty()) {
            hashMap.put(FIELD_PSDCSFPKGVERID, this.getPSDCSFPkgVerId());
        }
        if (!bl || this.isPSDCSFPkgVerNameDirty()) {
            hashMap.put(FIELD_PSDCSFPKGVERNAME, this.getPSDCSFPkgVerName());
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
        return PSDCSFPkgVerBase.get(this, n);
    }

    private static Object get(PSDCSFPkgVerBase pSDCSFPkgVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSFPkgVerBase.getCreateDate();
            }
            case 1: {
                return pSDCSFPkgVerBase.getCreateMan();
            }
            case 2: {
                return pSDCSFPkgVerBase.getMemo();
            }
            case 3: {
                return pSDCSFPkgVerBase.getPSDCSFPkgId();
            }
            case 4: {
                return pSDCSFPkgVerBase.getPSDCSFPkgName();
            }
            case 5: {
                return pSDCSFPkgVerBase.getPSDCSFPkgVerId();
            }
            case 6: {
                return pSDCSFPkgVerBase.getPSDCSFPkgVerName();
            }
            case 7: {
                return pSDCSFPkgVerBase.getUpdateDate();
            }
            case 8: {
                return pSDCSFPkgVerBase.getUpdateMan();
            }
            case 9: {
                return pSDCSFPkgVerBase.getVerParam();
            }
            case 10: {
                return pSDCSFPkgVerBase.getVerTag();
            }
            case 11: {
                return pSDCSFPkgVerBase.getVerTag2();
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
        PSDCSFPkgVerBase.set(this, n, object);
    }

    private static void set(PSDCSFPkgVerBase pSDCSFPkgVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCSFPkgVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCSFPkgVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCSFPkgVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCSFPkgVerBase.setPSDCSFPkgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCSFPkgVerBase.setPSDCSFPkgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCSFPkgVerBase.setPSDCSFPkgVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCSFPkgVerBase.setPSDCSFPkgVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCSFPkgVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDCSFPkgVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCSFPkgVerBase.setVerParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCSFPkgVerBase.setVerTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCSFPkgVerBase.setVerTag2(DataObject.getStringValue((Object)object));
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
        return PSDCSFPkgVerBase.isNull(this, n);
    }

    private static boolean isNull(PSDCSFPkgVerBase pSDCSFPkgVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSFPkgVerBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCSFPkgVerBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCSFPkgVerBase.getMemo() == null;
            }
            case 3: {
                return pSDCSFPkgVerBase.getPSDCSFPkgId() == null;
            }
            case 4: {
                return pSDCSFPkgVerBase.getPSDCSFPkgName() == null;
            }
            case 5: {
                return pSDCSFPkgVerBase.getPSDCSFPkgVerId() == null;
            }
            case 6: {
                return pSDCSFPkgVerBase.getPSDCSFPkgVerName() == null;
            }
            case 7: {
                return pSDCSFPkgVerBase.getUpdateDate() == null;
            }
            case 8: {
                return pSDCSFPkgVerBase.getUpdateMan() == null;
            }
            case 9: {
                return pSDCSFPkgVerBase.getVerParam() == null;
            }
            case 10: {
                return pSDCSFPkgVerBase.getVerTag() == null;
            }
            case 11: {
                return pSDCSFPkgVerBase.getVerTag2() == null;
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
        return PSDCSFPkgVerBase.contains(this, n);
    }

    private static boolean contains(PSDCSFPkgVerBase pSDCSFPkgVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSFPkgVerBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCSFPkgVerBase.isCreateManDirty();
            }
            case 2: {
                return pSDCSFPkgVerBase.isMemoDirty();
            }
            case 3: {
                return pSDCSFPkgVerBase.isPSDCSFPkgIdDirty();
            }
            case 4: {
                return pSDCSFPkgVerBase.isPSDCSFPkgNameDirty();
            }
            case 5: {
                return pSDCSFPkgVerBase.isPSDCSFPkgVerIdDirty();
            }
            case 6: {
                return pSDCSFPkgVerBase.isPSDCSFPkgVerNameDirty();
            }
            case 7: {
                return pSDCSFPkgVerBase.isUpdateDateDirty();
            }
            case 8: {
                return pSDCSFPkgVerBase.isUpdateManDirty();
            }
            case 9: {
                return pSDCSFPkgVerBase.isVerParamDirty();
            }
            case 10: {
                return pSDCSFPkgVerBase.isVerTagDirty();
            }
            case 11: {
                return pSDCSFPkgVerBase.isVerTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCSFPkgVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCSFPkgVerBase pSDCSFPkgVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCSFPkgVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCSFPkgVerBase.getJSONValue((Object)pSDCSFPkgVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCSFPkgVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCSFPkgVerBase.getJSONValue((Object)pSDCSFPkgVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCSFPkgVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCSFPkgVerBase.getJSONValue((Object)pSDCSFPkgVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCSFPkgVerBase.getPSDCSFPkgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsfpkgid", (Object)PSDCSFPkgVerBase.getJSONValue((Object)pSDCSFPkgVerBase.getPSDCSFPkgId()), (boolean)false);
        }
        if (bl || pSDCSFPkgVerBase.getPSDCSFPkgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsfpkgname", (Object)PSDCSFPkgVerBase.getJSONValue((Object)pSDCSFPkgVerBase.getPSDCSFPkgName()), (boolean)false);
        }
        if (bl || pSDCSFPkgVerBase.getPSDCSFPkgVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsfpkgverid", (Object)PSDCSFPkgVerBase.getJSONValue((Object)pSDCSFPkgVerBase.getPSDCSFPkgVerId()), (boolean)false);
        }
        if (bl || pSDCSFPkgVerBase.getPSDCSFPkgVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsfpkgvername", (Object)PSDCSFPkgVerBase.getJSONValue((Object)pSDCSFPkgVerBase.getPSDCSFPkgVerName()), (boolean)false);
        }
        if (bl || pSDCSFPkgVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCSFPkgVerBase.getJSONValue((Object)pSDCSFPkgVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCSFPkgVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCSFPkgVerBase.getJSONValue((Object)pSDCSFPkgVerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCSFPkgVerBase.getVerParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"verparam", (Object)PSDCSFPkgVerBase.getJSONValue((Object)pSDCSFPkgVerBase.getVerParam()), (boolean)false);
        }
        if (bl || pSDCSFPkgVerBase.getVerTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag", (Object)PSDCSFPkgVerBase.getJSONValue((Object)pSDCSFPkgVerBase.getVerTag()), (boolean)false);
        }
        if (bl || pSDCSFPkgVerBase.getVerTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vertag2", (Object)PSDCSFPkgVerBase.getJSONValue((Object)pSDCSFPkgVerBase.getVerTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCSFPkgVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCSFPkgVerBase pSDCSFPkgVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCSFPkgVerBase.getCreateDate() != null) {
            object = pSDCSFPkgVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSFPkgVerBase.getCreateMan() != null) {
            object = pSDCSFPkgVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgVerBase.getMemo() != null) {
            object = pSDCSFPkgVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgVerBase.getPSDCSFPkgId() != null) {
            object = pSDCSFPkgVerBase.getPSDCSFPkgId();
            xmlNode.setAttribute(FIELD_PSDCSFPKGID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgVerBase.getPSDCSFPkgName() != null) {
            object = pSDCSFPkgVerBase.getPSDCSFPkgName();
            xmlNode.setAttribute(FIELD_PSDCSFPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgVerBase.getPSDCSFPkgVerId() != null) {
            object = pSDCSFPkgVerBase.getPSDCSFPkgVerId();
            xmlNode.setAttribute(FIELD_PSDCSFPKGVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgVerBase.getPSDCSFPkgVerName() != null) {
            object = pSDCSFPkgVerBase.getPSDCSFPkgVerName();
            xmlNode.setAttribute(FIELD_PSDCSFPKGVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgVerBase.getUpdateDate() != null) {
            object = pSDCSFPkgVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSFPkgVerBase.getUpdateMan() != null) {
            object = pSDCSFPkgVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgVerBase.getVerParam() != null) {
            object = pSDCSFPkgVerBase.getVerParam();
            xmlNode.setAttribute(FIELD_VERPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgVerBase.getVerTag() != null) {
            object = pSDCSFPkgVerBase.getVerTag();
            xmlNode.setAttribute(FIELD_VERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCSFPkgVerBase.getVerTag2() != null) {
            object = pSDCSFPkgVerBase.getVerTag2();
            xmlNode.setAttribute(FIELD_VERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCSFPkgVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCSFPkgVerBase pSDCSFPkgVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCSFPkgVerBase.isCreateDateDirty() && (bl || pSDCSFPkgVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCSFPkgVerBase.getCreateDate());
        }
        if (pSDCSFPkgVerBase.isCreateManDirty() && (bl || pSDCSFPkgVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCSFPkgVerBase.getCreateMan());
        }
        if (pSDCSFPkgVerBase.isMemoDirty() && (bl || pSDCSFPkgVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCSFPkgVerBase.getMemo());
        }
        if (pSDCSFPkgVerBase.isPSDCSFPkgIdDirty() && (bl || pSDCSFPkgVerBase.getPSDCSFPkgId() != null)) {
            iDataObject.set(FIELD_PSDCSFPKGID, (Object)pSDCSFPkgVerBase.getPSDCSFPkgId());
        }
        if (pSDCSFPkgVerBase.isPSDCSFPkgNameDirty() && (bl || pSDCSFPkgVerBase.getPSDCSFPkgName() != null)) {
            iDataObject.set(FIELD_PSDCSFPKGNAME, (Object)pSDCSFPkgVerBase.getPSDCSFPkgName());
        }
        if (pSDCSFPkgVerBase.isPSDCSFPkgVerIdDirty() && (bl || pSDCSFPkgVerBase.getPSDCSFPkgVerId() != null)) {
            iDataObject.set(FIELD_PSDCSFPKGVERID, (Object)pSDCSFPkgVerBase.getPSDCSFPkgVerId());
        }
        if (pSDCSFPkgVerBase.isPSDCSFPkgVerNameDirty() && (bl || pSDCSFPkgVerBase.getPSDCSFPkgVerName() != null)) {
            iDataObject.set(FIELD_PSDCSFPKGVERNAME, (Object)pSDCSFPkgVerBase.getPSDCSFPkgVerName());
        }
        if (pSDCSFPkgVerBase.isUpdateDateDirty() && (bl || pSDCSFPkgVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCSFPkgVerBase.getUpdateDate());
        }
        if (pSDCSFPkgVerBase.isUpdateManDirty() && (bl || pSDCSFPkgVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCSFPkgVerBase.getUpdateMan());
        }
        if (pSDCSFPkgVerBase.isVerParamDirty() && (bl || pSDCSFPkgVerBase.getVerParam() != null)) {
            iDataObject.set(FIELD_VERPARAM, (Object)pSDCSFPkgVerBase.getVerParam());
        }
        if (pSDCSFPkgVerBase.isVerTagDirty() && (bl || pSDCSFPkgVerBase.getVerTag() != null)) {
            iDataObject.set(FIELD_VERTAG, (Object)pSDCSFPkgVerBase.getVerTag());
        }
        if (pSDCSFPkgVerBase.isVerTag2Dirty() && (bl || pSDCSFPkgVerBase.getVerTag2() != null)) {
            iDataObject.set(FIELD_VERTAG2, (Object)pSDCSFPkgVerBase.getVerTag2());
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
        return PSDCSFPkgVerBase.remove(this, n);
    }

    private static boolean remove(PSDCSFPkgVerBase pSDCSFPkgVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCSFPkgVerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCSFPkgVerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCSFPkgVerBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCSFPkgVerBase.resetPSDCSFPkgId();
                return true;
            }
            case 4: {
                pSDCSFPkgVerBase.resetPSDCSFPkgName();
                return true;
            }
            case 5: {
                pSDCSFPkgVerBase.resetPSDCSFPkgVerId();
                return true;
            }
            case 6: {
                pSDCSFPkgVerBase.resetPSDCSFPkgVerName();
                return true;
            }
            case 7: {
                pSDCSFPkgVerBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSDCSFPkgVerBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSDCSFPkgVerBase.resetVerParam();
                return true;
            }
            case 10: {
                pSDCSFPkgVerBase.resetVerTag();
                return true;
            }
            case 11: {
                pSDCSFPkgVerBase.resetVerTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCSFPkg getPSDCSFPkg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSFPkg();
        }
        if (this.getPSDCSFPkgId() == null) {
            return null;
        }
        Integer n = this.objPSDCSFPkgLock;
        synchronized (n) {
            if (this.psdcsfpkg != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCSFPkgId(), (Object)this.psdcsfpkg.getPSDCSFPkgId()) != 0L) {
                this.psdcsfpkg = null;
            }
            if (this.psdcsfpkg == null) {
                PSDCSFPkg pSDCSFPkg = new PSDCSFPkg();
                pSDCSFPkg.setPSDCSFPkgId(this.getPSDCSFPkgId());
                PSDCSFPkgService pSDCSFPkgService = (PSDCSFPkgService)ServiceGlobal.getService(PSDCSFPkgService.class, (SessionFactory)this.getSessionFactory());
                pSDCSFPkgService.autoGet((IEntity)pSDCSFPkg);
                this.psdcsfpkg = pSDCSFPkg;
            }
            return this.psdcsfpkg;
        }
    }

    private PSDCSFPkgVerBase getProxyEntity() {
        return this.proxyPSDCSFPkgVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCSFPkgVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCSFPkgVerBase) {
            this.proxyPSDCSFPkgVerBase = (PSDCSFPkgVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSFPkgVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCSFPKGID, 3);
        fieldIndexMap.put(FIELD_PSDCSFPKGNAME, 4);
        fieldIndexMap.put(FIELD_PSDCSFPKGVERID, 5);
        fieldIndexMap.put(FIELD_PSDCSFPKGVERNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_VERPARAM, 9);
        fieldIndexMap.put(FIELD_VERTAG, 10);
        fieldIndexMap.put(FIELD_VERTAG2, 11);
    }
}

