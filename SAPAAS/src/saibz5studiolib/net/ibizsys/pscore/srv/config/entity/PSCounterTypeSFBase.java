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
import net.ibizsys.pscore.srv.config.entity.PSCounterType;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.service.PSCounterTypeService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCounterTypeSFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCounterTypeSFBase.class);
    public static final String FIELD_BASEOBJ = "BASEOBJ";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCOUNTERTYPEID = "PSCOUNTERTYPEID";
    public static final String FIELD_PSCOUNTERTYPENAME = "PSCOUNTERTYPENAME";
    public static final String FIELD_PSCOUNTERTYPESFID = "PSCOUNTERTYPESFID";
    public static final String FIELD_PSCOUNTERTYPESFNAME = "PSCOUNTERTYPESFNAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BASEOBJ = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSCOUNTERTYPEID = 4;
    private static final int INDEX_PSCOUNTERTYPENAME = 5;
    private static final int INDEX_PSCOUNTERTYPESFID = 6;
    private static final int INDEX_PSCOUNTERTYPESFNAME = 7;
    private static final int INDEX_PSSFID = 8;
    private static final int INDEX_PSSFNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCounterTypeSFBase proxyPSCounterTypeSFBase = null;
    private boolean baseobjDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pscountertypeidDirtyFlag = false;
    private boolean pscountertypenameDirtyFlag = false;
    private boolean pscountertypesfidDirtyFlag = false;
    private boolean pscountertypesfnameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="baseobj")
    private String baseobj;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pscountertypeid")
    private String pscountertypeid;
    @Column(name="pscountertypename")
    private String pscountertypename;
    @Column(name="pscountertypesfid")
    private String pscountertypesfid;
    @Column(name="pscountertypesfname")
    private String pscountertypesfname;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSCounterTypeLock = new Integer(1);
    private PSCounterType pscountertype = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;

    public void setBaseObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.baseobj = string;
        this.baseobjDirtyFlag = true;
    }

    public String getBaseObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseObj();
        }
        return this.baseobj;
    }

    public boolean isBaseObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseObjDirty();
        }
        return this.baseobjDirtyFlag;
    }

    public void resetBaseObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseObj();
            return;
        }
        this.baseobjDirtyFlag = false;
        this.baseobj = null;
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

    public void setPSCounterTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCounterTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscountertypeid = string;
        this.pscountertypeidDirtyFlag = true;
    }

    public String getPSCounterTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCounterTypeId();
        }
        return this.pscountertypeid;
    }

    public boolean isPSCounterTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCounterTypeIdDirty();
        }
        return this.pscountertypeidDirtyFlag;
    }

    public void resetPSCounterTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCounterTypeId();
            return;
        }
        this.pscountertypeidDirtyFlag = false;
        this.pscountertypeid = null;
    }

    public void setPSCounterTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCounterTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscountertypename = string;
        this.pscountertypenameDirtyFlag = true;
    }

    public String getPSCounterTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCounterTypeName();
        }
        return this.pscountertypename;
    }

    public boolean isPSCounterTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCounterTypeNameDirty();
        }
        return this.pscountertypenameDirtyFlag;
    }

    public void resetPSCounterTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCounterTypeName();
            return;
        }
        this.pscountertypenameDirtyFlag = false;
        this.pscountertypename = null;
    }

    public void setPSCounterTypeSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCounterTypeSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscountertypesfid = string;
        this.pscountertypesfidDirtyFlag = true;
    }

    public String getPSCounterTypeSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCounterTypeSFId();
        }
        return this.pscountertypesfid;
    }

    public boolean isPSCounterTypeSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCounterTypeSFIdDirty();
        }
        return this.pscountertypesfidDirtyFlag;
    }

    public void resetPSCounterTypeSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCounterTypeSFId();
            return;
        }
        this.pscountertypesfidDirtyFlag = false;
        this.pscountertypesfid = null;
    }

    public void setPSCounterTypeSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCounterTypeSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscountertypesfname = string;
        this.pscountertypesfnameDirtyFlag = true;
    }

    public String getPSCounterTypeSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCounterTypeSFName();
        }
        return this.pscountertypesfname;
    }

    public boolean isPSCounterTypeSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCounterTypeSFNameDirty();
        }
        return this.pscountertypesfnameDirtyFlag;
    }

    public void resetPSCounterTypeSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCounterTypeSFName();
            return;
        }
        this.pscountertypesfnameDirtyFlag = false;
        this.pscountertypesfname = null;
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
        PSCounterTypeSFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCounterTypeSFBase pSCounterTypeSFBase) {
        pSCounterTypeSFBase.resetBaseObj();
        pSCounterTypeSFBase.resetCreateDate();
        pSCounterTypeSFBase.resetCreateMan();
        pSCounterTypeSFBase.resetMemo();
        pSCounterTypeSFBase.resetPSCounterTypeId();
        pSCounterTypeSFBase.resetPSCounterTypeName();
        pSCounterTypeSFBase.resetPSCounterTypeSFId();
        pSCounterTypeSFBase.resetPSCounterTypeSFName();
        pSCounterTypeSFBase.resetPSSFId();
        pSCounterTypeSFBase.resetPSSFName();
        pSCounterTypeSFBase.resetUpdateDate();
        pSCounterTypeSFBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBaseObjDirty()) {
            hashMap.put(FIELD_BASEOBJ, this.getBaseObj());
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
        if (!bl || this.isPSCounterTypeIdDirty()) {
            hashMap.put(FIELD_PSCOUNTERTYPEID, this.getPSCounterTypeId());
        }
        if (!bl || this.isPSCounterTypeNameDirty()) {
            hashMap.put(FIELD_PSCOUNTERTYPENAME, this.getPSCounterTypeName());
        }
        if (!bl || this.isPSCounterTypeSFIdDirty()) {
            hashMap.put(FIELD_PSCOUNTERTYPESFID, this.getPSCounterTypeSFId());
        }
        if (!bl || this.isPSCounterTypeSFNameDirty()) {
            hashMap.put(FIELD_PSCOUNTERTYPESFNAME, this.getPSCounterTypeSFName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
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
        return PSCounterTypeSFBase.get(this, n);
    }

    private static Object get(PSCounterTypeSFBase pSCounterTypeSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCounterTypeSFBase.getBaseObj();
            }
            case 1: {
                return pSCounterTypeSFBase.getCreateDate();
            }
            case 2: {
                return pSCounterTypeSFBase.getCreateMan();
            }
            case 3: {
                return pSCounterTypeSFBase.getMemo();
            }
            case 4: {
                return pSCounterTypeSFBase.getPSCounterTypeId();
            }
            case 5: {
                return pSCounterTypeSFBase.getPSCounterTypeName();
            }
            case 6: {
                return pSCounterTypeSFBase.getPSCounterTypeSFId();
            }
            case 7: {
                return pSCounterTypeSFBase.getPSCounterTypeSFName();
            }
            case 8: {
                return pSCounterTypeSFBase.getPSSFId();
            }
            case 9: {
                return pSCounterTypeSFBase.getPSSFName();
            }
            case 10: {
                return pSCounterTypeSFBase.getUpdateDate();
            }
            case 11: {
                return pSCounterTypeSFBase.getUpdateMan();
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
        PSCounterTypeSFBase.set(this, n, object);
    }

    private static void set(PSCounterTypeSFBase pSCounterTypeSFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCounterTypeSFBase.setBaseObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCounterTypeSFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSCounterTypeSFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCounterTypeSFBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCounterTypeSFBase.setPSCounterTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCounterTypeSFBase.setPSCounterTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCounterTypeSFBase.setPSCounterTypeSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCounterTypeSFBase.setPSCounterTypeSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCounterTypeSFBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCounterTypeSFBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCounterTypeSFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSCounterTypeSFBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCounterTypeSFBase.isNull(this, n);
    }

    private static boolean isNull(PSCounterTypeSFBase pSCounterTypeSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCounterTypeSFBase.getBaseObj() == null;
            }
            case 1: {
                return pSCounterTypeSFBase.getCreateDate() == null;
            }
            case 2: {
                return pSCounterTypeSFBase.getCreateMan() == null;
            }
            case 3: {
                return pSCounterTypeSFBase.getMemo() == null;
            }
            case 4: {
                return pSCounterTypeSFBase.getPSCounterTypeId() == null;
            }
            case 5: {
                return pSCounterTypeSFBase.getPSCounterTypeName() == null;
            }
            case 6: {
                return pSCounterTypeSFBase.getPSCounterTypeSFId() == null;
            }
            case 7: {
                return pSCounterTypeSFBase.getPSCounterTypeSFName() == null;
            }
            case 8: {
                return pSCounterTypeSFBase.getPSSFId() == null;
            }
            case 9: {
                return pSCounterTypeSFBase.getPSSFName() == null;
            }
            case 10: {
                return pSCounterTypeSFBase.getUpdateDate() == null;
            }
            case 11: {
                return pSCounterTypeSFBase.getUpdateMan() == null;
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
        return PSCounterTypeSFBase.contains(this, n);
    }

    private static boolean contains(PSCounterTypeSFBase pSCounterTypeSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCounterTypeSFBase.isBaseObjDirty();
            }
            case 1: {
                return pSCounterTypeSFBase.isCreateDateDirty();
            }
            case 2: {
                return pSCounterTypeSFBase.isCreateManDirty();
            }
            case 3: {
                return pSCounterTypeSFBase.isMemoDirty();
            }
            case 4: {
                return pSCounterTypeSFBase.isPSCounterTypeIdDirty();
            }
            case 5: {
                return pSCounterTypeSFBase.isPSCounterTypeNameDirty();
            }
            case 6: {
                return pSCounterTypeSFBase.isPSCounterTypeSFIdDirty();
            }
            case 7: {
                return pSCounterTypeSFBase.isPSCounterTypeSFNameDirty();
            }
            case 8: {
                return pSCounterTypeSFBase.isPSSFIdDirty();
            }
            case 9: {
                return pSCounterTypeSFBase.isPSSFNameDirty();
            }
            case 10: {
                return pSCounterTypeSFBase.isUpdateDateDirty();
            }
            case 11: {
                return pSCounterTypeSFBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCounterTypeSFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCounterTypeSFBase pSCounterTypeSFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCounterTypeSFBase.getBaseObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseobj", (Object)PSCounterTypeSFBase.getJSONValue((Object)pSCounterTypeSFBase.getBaseObj()), (boolean)false);
        }
        if (bl || pSCounterTypeSFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCounterTypeSFBase.getJSONValue((Object)pSCounterTypeSFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCounterTypeSFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCounterTypeSFBase.getJSONValue((Object)pSCounterTypeSFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCounterTypeSFBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCounterTypeSFBase.getJSONValue((Object)pSCounterTypeSFBase.getMemo()), (boolean)false);
        }
        if (bl || pSCounterTypeSFBase.getPSCounterTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscountertypeid", (Object)PSCounterTypeSFBase.getJSONValue((Object)pSCounterTypeSFBase.getPSCounterTypeId()), (boolean)false);
        }
        if (bl || pSCounterTypeSFBase.getPSCounterTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscountertypename", (Object)PSCounterTypeSFBase.getJSONValue((Object)pSCounterTypeSFBase.getPSCounterTypeName()), (boolean)false);
        }
        if (bl || pSCounterTypeSFBase.getPSCounterTypeSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscountertypesfid", (Object)PSCounterTypeSFBase.getJSONValue((Object)pSCounterTypeSFBase.getPSCounterTypeSFId()), (boolean)false);
        }
        if (bl || pSCounterTypeSFBase.getPSCounterTypeSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscountertypesfname", (Object)PSCounterTypeSFBase.getJSONValue((Object)pSCounterTypeSFBase.getPSCounterTypeSFName()), (boolean)false);
        }
        if (bl || pSCounterTypeSFBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSCounterTypeSFBase.getJSONValue((Object)pSCounterTypeSFBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSCounterTypeSFBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSCounterTypeSFBase.getJSONValue((Object)pSCounterTypeSFBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSCounterTypeSFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCounterTypeSFBase.getJSONValue((Object)pSCounterTypeSFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCounterTypeSFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCounterTypeSFBase.getJSONValue((Object)pSCounterTypeSFBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCounterTypeSFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCounterTypeSFBase pSCounterTypeSFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCounterTypeSFBase.getBaseObj() != null) {
            object = pSCounterTypeSFBase.getBaseObj();
            xmlNode.setAttribute(FIELD_BASEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeSFBase.getCreateDate() != null) {
            object = pSCounterTypeSFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCounterTypeSFBase.getCreateMan() != null) {
            object = pSCounterTypeSFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeSFBase.getMemo() != null) {
            object = pSCounterTypeSFBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeSFBase.getPSCounterTypeId() != null) {
            object = pSCounterTypeSFBase.getPSCounterTypeId();
            xmlNode.setAttribute(FIELD_PSCOUNTERTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeSFBase.getPSCounterTypeName() != null) {
            object = pSCounterTypeSFBase.getPSCounterTypeName();
            xmlNode.setAttribute(FIELD_PSCOUNTERTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeSFBase.getPSCounterTypeSFId() != null) {
            object = pSCounterTypeSFBase.getPSCounterTypeSFId();
            xmlNode.setAttribute(FIELD_PSCOUNTERTYPESFID, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeSFBase.getPSCounterTypeSFName() != null) {
            object = pSCounterTypeSFBase.getPSCounterTypeSFName();
            xmlNode.setAttribute(FIELD_PSCOUNTERTYPESFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeSFBase.getPSSFId() != null) {
            object = pSCounterTypeSFBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeSFBase.getPSSFName() != null) {
            object = pSCounterTypeSFBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCounterTypeSFBase.getUpdateDate() != null) {
            object = pSCounterTypeSFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCounterTypeSFBase.getUpdateMan() != null) {
            object = pSCounterTypeSFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCounterTypeSFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCounterTypeSFBase pSCounterTypeSFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCounterTypeSFBase.isBaseObjDirty() && (bl || pSCounterTypeSFBase.getBaseObj() != null)) {
            iDataObject.set(FIELD_BASEOBJ, (Object)pSCounterTypeSFBase.getBaseObj());
        }
        if (pSCounterTypeSFBase.isCreateDateDirty() && (bl || pSCounterTypeSFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCounterTypeSFBase.getCreateDate());
        }
        if (pSCounterTypeSFBase.isCreateManDirty() && (bl || pSCounterTypeSFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCounterTypeSFBase.getCreateMan());
        }
        if (pSCounterTypeSFBase.isMemoDirty() && (bl || pSCounterTypeSFBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCounterTypeSFBase.getMemo());
        }
        if (pSCounterTypeSFBase.isPSCounterTypeIdDirty() && (bl || pSCounterTypeSFBase.getPSCounterTypeId() != null)) {
            iDataObject.set(FIELD_PSCOUNTERTYPEID, (Object)pSCounterTypeSFBase.getPSCounterTypeId());
        }
        if (pSCounterTypeSFBase.isPSCounterTypeNameDirty() && (bl || pSCounterTypeSFBase.getPSCounterTypeName() != null)) {
            iDataObject.set(FIELD_PSCOUNTERTYPENAME, (Object)pSCounterTypeSFBase.getPSCounterTypeName());
        }
        if (pSCounterTypeSFBase.isPSCounterTypeSFIdDirty() && (bl || pSCounterTypeSFBase.getPSCounterTypeSFId() != null)) {
            iDataObject.set(FIELD_PSCOUNTERTYPESFID, (Object)pSCounterTypeSFBase.getPSCounterTypeSFId());
        }
        if (pSCounterTypeSFBase.isPSCounterTypeSFNameDirty() && (bl || pSCounterTypeSFBase.getPSCounterTypeSFName() != null)) {
            iDataObject.set(FIELD_PSCOUNTERTYPESFNAME, (Object)pSCounterTypeSFBase.getPSCounterTypeSFName());
        }
        if (pSCounterTypeSFBase.isPSSFIdDirty() && (bl || pSCounterTypeSFBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSCounterTypeSFBase.getPSSFId());
        }
        if (pSCounterTypeSFBase.isPSSFNameDirty() && (bl || pSCounterTypeSFBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSCounterTypeSFBase.getPSSFName());
        }
        if (pSCounterTypeSFBase.isUpdateDateDirty() && (bl || pSCounterTypeSFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCounterTypeSFBase.getUpdateDate());
        }
        if (pSCounterTypeSFBase.isUpdateManDirty() && (bl || pSCounterTypeSFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCounterTypeSFBase.getUpdateMan());
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
        return PSCounterTypeSFBase.remove(this, n);
    }

    private static boolean remove(PSCounterTypeSFBase pSCounterTypeSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCounterTypeSFBase.resetBaseObj();
                return true;
            }
            case 1: {
                pSCounterTypeSFBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSCounterTypeSFBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSCounterTypeSFBase.resetMemo();
                return true;
            }
            case 4: {
                pSCounterTypeSFBase.resetPSCounterTypeId();
                return true;
            }
            case 5: {
                pSCounterTypeSFBase.resetPSCounterTypeName();
                return true;
            }
            case 6: {
                pSCounterTypeSFBase.resetPSCounterTypeSFId();
                return true;
            }
            case 7: {
                pSCounterTypeSFBase.resetPSCounterTypeSFName();
                return true;
            }
            case 8: {
                pSCounterTypeSFBase.resetPSSFId();
                return true;
            }
            case 9: {
                pSCounterTypeSFBase.resetPSSFName();
                return true;
            }
            case 10: {
                pSCounterTypeSFBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSCounterTypeSFBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCounterType getPSCounterType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCounterType();
        }
        if (this.getPSCounterTypeId() == null) {
            return null;
        }
        Integer n = this.objPSCounterTypeLock;
        synchronized (n) {
            if (this.pscountertype != null && DataTypeHelper.compare((int)25, (Object)this.getPSCounterTypeId(), (Object)this.pscountertype.getPSCounterTypeId()) != 0L) {
                this.pscountertype = null;
            }
            if (this.pscountertype == null) {
                PSCounterType pSCounterType = new PSCounterType();
                pSCounterType.setPSCounterTypeId(this.getPSCounterTypeId());
                PSCounterTypeService pSCounterTypeService = (PSCounterTypeService)ServiceGlobal.getService(PSCounterTypeService.class, (SessionFactory)this.getSessionFactory());
                pSCounterTypeService.autoGet((IEntity)pSCounterType);
                this.pscountertype = pSCounterType;
            }
            return this.pscountertype;
        }
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

    private PSCounterTypeSFBase getProxyEntity() {
        return this.proxyPSCounterTypeSFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCounterTypeSFBase = null;
        if (iDataObject != null && iDataObject instanceof PSCounterTypeSFBase) {
            this.proxyPSCounterTypeSFBase = (PSCounterTypeSFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCounterTypeSFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BASEOBJ, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSCOUNTERTYPEID, 4);
        fieldIndexMap.put(FIELD_PSCOUNTERTYPENAME, 5);
        fieldIndexMap.put(FIELD_PSCOUNTERTYPESFID, 6);
        fieldIndexMap.put(FIELD_PSCOUNTERTYPESFNAME, 7);
        fieldIndexMap.put(FIELD_PSSFID, 8);
        fieldIndexMap.put(FIELD_PSSFNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

