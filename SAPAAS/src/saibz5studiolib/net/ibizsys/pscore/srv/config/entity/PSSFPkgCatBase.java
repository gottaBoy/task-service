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
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFPkgCatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFPkgCatBase.class);
    public static final String FIELD_CATTAG = "CATTAG";
    public static final String FIELD_CATTAG2 = "CATTAG2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFPKGCATID = "PSSFPKGCATID";
    public static final String FIELD_PSSFPKGCATNAME = "PSSFPKGCATNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CATTAG = 0;
    private static final int INDEX_CATTAG2 = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSSFID = 5;
    private static final int INDEX_PSSFNAME = 6;
    private static final int INDEX_PSSFPKGCATID = 7;
    private static final int INDEX_PSSFPKGCATNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFPkgCatBase proxyPSSFPkgCatBase = null;
    private boolean cattagDirtyFlag = false;
    private boolean cattag2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfpkgcatidDirtyFlag = false;
    private boolean pssfpkgcatnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="cattag")
    private String cattag;
    @Column(name="cattag2")
    private String cattag2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssfpkgcatid")
    private String pssfpkgcatid;
    @Column(name="pssfpkgcatname")
    private String pssfpkgcatname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;

    public void setCatTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCatTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cattag = string;
        this.cattagDirtyFlag = true;
    }

    public String getCatTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCatTag();
        }
        return this.cattag;
    }

    public boolean isCatTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCatTagDirty();
        }
        return this.cattagDirtyFlag;
    }

    public void resetCatTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCatTag();
            return;
        }
        this.cattagDirtyFlag = false;
        this.cattag = null;
    }

    public void setCatTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCatTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cattag2 = string;
        this.cattag2DirtyFlag = true;
    }

    public String getCatTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCatTag2();
        }
        return this.cattag2;
    }

    public boolean isCatTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCatTag2Dirty();
        }
        return this.cattag2DirtyFlag;
    }

    public void resetCatTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCatTag2();
            return;
        }
        this.cattag2DirtyFlag = false;
        this.cattag2 = null;
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

    public void setPSSFPkgCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPkgCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpkgcatid = string;
        this.pssfpkgcatidDirtyFlag = true;
    }

    public String getPSSFPkgCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgCatId();
        }
        return this.pssfpkgcatid;
    }

    public boolean isPSSFPkgCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPkgCatIdDirty();
        }
        return this.pssfpkgcatidDirtyFlag;
    }

    public void resetPSSFPkgCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPkgCatId();
            return;
        }
        this.pssfpkgcatidDirtyFlag = false;
        this.pssfpkgcatid = null;
    }

    public void setPSSFPkgCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPkgCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpkgcatname = string;
        this.pssfpkgcatnameDirtyFlag = true;
    }

    public String getPSSFPkgCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPkgCatName();
        }
        return this.pssfpkgcatname;
    }

    public boolean isPSSFPkgCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPkgCatNameDirty();
        }
        return this.pssfpkgcatnameDirtyFlag;
    }

    public void resetPSSFPkgCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPkgCatName();
            return;
        }
        this.pssfpkgcatnameDirtyFlag = false;
        this.pssfpkgcatname = null;
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
        PSSFPkgCatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFPkgCatBase pSSFPkgCatBase) {
        pSSFPkgCatBase.resetCatTag();
        pSSFPkgCatBase.resetCatTag2();
        pSSFPkgCatBase.resetCreateDate();
        pSSFPkgCatBase.resetCreateMan();
        pSSFPkgCatBase.resetMemo();
        pSSFPkgCatBase.resetPSSFId();
        pSSFPkgCatBase.resetPSSFName();
        pSSFPkgCatBase.resetPSSFPkgCatId();
        pSSFPkgCatBase.resetPSSFPkgCatName();
        pSSFPkgCatBase.resetUpdateDate();
        pSSFPkgCatBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCatTagDirty()) {
            hashMap.put(FIELD_CATTAG, this.getCatTag());
        }
        if (!bl || this.isCatTag2Dirty()) {
            hashMap.put(FIELD_CATTAG2, this.getCatTag2());
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
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSFPkgCatIdDirty()) {
            hashMap.put(FIELD_PSSFPKGCATID, this.getPSSFPkgCatId());
        }
        if (!bl || this.isPSSFPkgCatNameDirty()) {
            hashMap.put(FIELD_PSSFPKGCATNAME, this.getPSSFPkgCatName());
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
        return PSSFPkgCatBase.get(this, n);
    }

    private static Object get(PSSFPkgCatBase pSSFPkgCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPkgCatBase.getCatTag();
            }
            case 1: {
                return pSSFPkgCatBase.getCatTag2();
            }
            case 2: {
                return pSSFPkgCatBase.getCreateDate();
            }
            case 3: {
                return pSSFPkgCatBase.getCreateMan();
            }
            case 4: {
                return pSSFPkgCatBase.getMemo();
            }
            case 5: {
                return pSSFPkgCatBase.getPSSFId();
            }
            case 6: {
                return pSSFPkgCatBase.getPSSFName();
            }
            case 7: {
                return pSSFPkgCatBase.getPSSFPkgCatId();
            }
            case 8: {
                return pSSFPkgCatBase.getPSSFPkgCatName();
            }
            case 9: {
                return pSSFPkgCatBase.getUpdateDate();
            }
            case 10: {
                return pSSFPkgCatBase.getUpdateMan();
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
        PSSFPkgCatBase.set(this, n, object);
    }

    private static void set(PSSFPkgCatBase pSSFPkgCatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFPkgCatBase.setCatTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSFPkgCatBase.setCatTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFPkgCatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSSFPkgCatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFPkgCatBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFPkgCatBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFPkgCatBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFPkgCatBase.setPSSFPkgCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFPkgCatBase.setPSSFPkgCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFPkgCatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSSFPkgCatBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSFPkgCatBase.isNull(this, n);
    }

    private static boolean isNull(PSSFPkgCatBase pSSFPkgCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPkgCatBase.getCatTag() == null;
            }
            case 1: {
                return pSSFPkgCatBase.getCatTag2() == null;
            }
            case 2: {
                return pSSFPkgCatBase.getCreateDate() == null;
            }
            case 3: {
                return pSSFPkgCatBase.getCreateMan() == null;
            }
            case 4: {
                return pSSFPkgCatBase.getMemo() == null;
            }
            case 5: {
                return pSSFPkgCatBase.getPSSFId() == null;
            }
            case 6: {
                return pSSFPkgCatBase.getPSSFName() == null;
            }
            case 7: {
                return pSSFPkgCatBase.getPSSFPkgCatId() == null;
            }
            case 8: {
                return pSSFPkgCatBase.getPSSFPkgCatName() == null;
            }
            case 9: {
                return pSSFPkgCatBase.getUpdateDate() == null;
            }
            case 10: {
                return pSSFPkgCatBase.getUpdateMan() == null;
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
        return PSSFPkgCatBase.contains(this, n);
    }

    private static boolean contains(PSSFPkgCatBase pSSFPkgCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPkgCatBase.isCatTagDirty();
            }
            case 1: {
                return pSSFPkgCatBase.isCatTag2Dirty();
            }
            case 2: {
                return pSSFPkgCatBase.isCreateDateDirty();
            }
            case 3: {
                return pSSFPkgCatBase.isCreateManDirty();
            }
            case 4: {
                return pSSFPkgCatBase.isMemoDirty();
            }
            case 5: {
                return pSSFPkgCatBase.isPSSFIdDirty();
            }
            case 6: {
                return pSSFPkgCatBase.isPSSFNameDirty();
            }
            case 7: {
                return pSSFPkgCatBase.isPSSFPkgCatIdDirty();
            }
            case 8: {
                return pSSFPkgCatBase.isPSSFPkgCatNameDirty();
            }
            case 9: {
                return pSSFPkgCatBase.isUpdateDateDirty();
            }
            case 10: {
                return pSSFPkgCatBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFPkgCatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFPkgCatBase pSSFPkgCatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFPkgCatBase.getCatTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cattag", (Object)PSSFPkgCatBase.getJSONValue((Object)pSSFPkgCatBase.getCatTag()), (boolean)false);
        }
        if (bl || pSSFPkgCatBase.getCatTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cattag2", (Object)PSSFPkgCatBase.getJSONValue((Object)pSSFPkgCatBase.getCatTag2()), (boolean)false);
        }
        if (bl || pSSFPkgCatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFPkgCatBase.getJSONValue((Object)pSSFPkgCatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFPkgCatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFPkgCatBase.getJSONValue((Object)pSSFPkgCatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFPkgCatBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFPkgCatBase.getJSONValue((Object)pSSFPkgCatBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFPkgCatBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFPkgCatBase.getJSONValue((Object)pSSFPkgCatBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFPkgCatBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSFPkgCatBase.getJSONValue((Object)pSSFPkgCatBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSFPkgCatBase.getPSSFPkgCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgcatid", (Object)PSSFPkgCatBase.getJSONValue((Object)pSSFPkgCatBase.getPSSFPkgCatId()), (boolean)false);
        }
        if (bl || pSSFPkgCatBase.getPSSFPkgCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpkgcatname", (Object)PSSFPkgCatBase.getJSONValue((Object)pSSFPkgCatBase.getPSSFPkgCatName()), (boolean)false);
        }
        if (bl || pSSFPkgCatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFPkgCatBase.getJSONValue((Object)pSSFPkgCatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFPkgCatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFPkgCatBase.getJSONValue((Object)pSSFPkgCatBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFPkgCatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFPkgCatBase pSSFPkgCatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFPkgCatBase.getCatTag() != null) {
            object = pSSFPkgCatBase.getCatTag();
            xmlNode.setAttribute(FIELD_CATTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSFPkgCatBase.getCatTag2() != null) {
            object = pSSFPkgCatBase.getCatTag2();
            xmlNode.setAttribute(FIELD_CATTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgCatBase.getCreateDate() != null) {
            object = pSSFPkgCatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPkgCatBase.getCreateMan() != null) {
            object = pSSFPkgCatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgCatBase.getMemo() != null) {
            object = pSSFPkgCatBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgCatBase.getPSSFId() != null) {
            object = pSSFPkgCatBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgCatBase.getPSSFName() != null) {
            object = pSSFPkgCatBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgCatBase.getPSSFPkgCatId() != null) {
            object = pSSFPkgCatBase.getPSSFPkgCatId();
            xmlNode.setAttribute(FIELD_PSSFPKGCATID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgCatBase.getPSSFPkgCatName() != null) {
            object = pSSFPkgCatBase.getPSSFPkgCatName();
            xmlNode.setAttribute(FIELD_PSSFPKGCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPkgCatBase.getUpdateDate() != null) {
            object = pSSFPkgCatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPkgCatBase.getUpdateMan() != null) {
            object = pSSFPkgCatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFPkgCatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFPkgCatBase pSSFPkgCatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFPkgCatBase.isCatTagDirty() && (bl || pSSFPkgCatBase.getCatTag() != null)) {
            iDataObject.set(FIELD_CATTAG, (Object)pSSFPkgCatBase.getCatTag());
        }
        if (pSSFPkgCatBase.isCatTag2Dirty() && (bl || pSSFPkgCatBase.getCatTag2() != null)) {
            iDataObject.set(FIELD_CATTAG2, (Object)pSSFPkgCatBase.getCatTag2());
        }
        if (pSSFPkgCatBase.isCreateDateDirty() && (bl || pSSFPkgCatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFPkgCatBase.getCreateDate());
        }
        if (pSSFPkgCatBase.isCreateManDirty() && (bl || pSSFPkgCatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFPkgCatBase.getCreateMan());
        }
        if (pSSFPkgCatBase.isMemoDirty() && (bl || pSSFPkgCatBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFPkgCatBase.getMemo());
        }
        if (pSSFPkgCatBase.isPSSFIdDirty() && (bl || pSSFPkgCatBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFPkgCatBase.getPSSFId());
        }
        if (pSSFPkgCatBase.isPSSFNameDirty() && (bl || pSSFPkgCatBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSFPkgCatBase.getPSSFName());
        }
        if (pSSFPkgCatBase.isPSSFPkgCatIdDirty() && (bl || pSSFPkgCatBase.getPSSFPkgCatId() != null)) {
            iDataObject.set(FIELD_PSSFPKGCATID, (Object)pSSFPkgCatBase.getPSSFPkgCatId());
        }
        if (pSSFPkgCatBase.isPSSFPkgCatNameDirty() && (bl || pSSFPkgCatBase.getPSSFPkgCatName() != null)) {
            iDataObject.set(FIELD_PSSFPKGCATNAME, (Object)pSSFPkgCatBase.getPSSFPkgCatName());
        }
        if (pSSFPkgCatBase.isUpdateDateDirty() && (bl || pSSFPkgCatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFPkgCatBase.getUpdateDate());
        }
        if (pSSFPkgCatBase.isUpdateManDirty() && (bl || pSSFPkgCatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFPkgCatBase.getUpdateMan());
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
        return PSSFPkgCatBase.remove(this, n);
    }

    private static boolean remove(PSSFPkgCatBase pSSFPkgCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFPkgCatBase.resetCatTag();
                return true;
            }
            case 1: {
                pSSFPkgCatBase.resetCatTag2();
                return true;
            }
            case 2: {
                pSSFPkgCatBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSSFPkgCatBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSSFPkgCatBase.resetMemo();
                return true;
            }
            case 5: {
                pSSFPkgCatBase.resetPSSFId();
                return true;
            }
            case 6: {
                pSSFPkgCatBase.resetPSSFName();
                return true;
            }
            case 7: {
                pSSFPkgCatBase.resetPSSFPkgCatId();
                return true;
            }
            case 8: {
                pSSFPkgCatBase.resetPSSFPkgCatName();
                return true;
            }
            case 9: {
                pSSFPkgCatBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSSFPkgCatBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSSFPkgCatBase getProxyEntity() {
        return this.proxyPSSFPkgCatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFPkgCatBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFPkgCatBase) {
            this.proxyPSSFPkgCatBase = (PSSFPkgCatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPkgCatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CATTAG, 0);
        fieldIndexMap.put(FIELD_CATTAG2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSSFID, 5);
        fieldIndexMap.put(FIELD_PSSFNAME, 6);
        fieldIndexMap.put(FIELD_PSSFPKGCATID, 7);
        fieldIndexMap.put(FIELD_PSSFPKGCATNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

