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
import net.ibizsys.pscore.srv.config.entity.PSDBType;
import net.ibizsys.pscore.srv.config.entity.PSDBValueFunc;
import net.ibizsys.pscore.srv.config.service.PSDBTypeService;
import net.ibizsys.pscore.srv.config.service.PSDBValueFuncService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBVFCodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDBVFCodeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FUNCCODE = "FUNCCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDBTYPEID = "PSDBTYPEID";
    public static final String FIELD_PSDBTYPENAME = "PSDBTYPENAME";
    public static final String FIELD_PSDBVFCODEID = "PSDBVFCODEID";
    public static final String FIELD_PSDBVFCODENAME = "PSDBVFCODENAME";
    public static final String FIELD_PSDBVFID = "PSDBVFID";
    public static final String FIELD_PSDBVFNAME = "PSDBVFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_FUNCCODE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDBTYPEID = 4;
    private static final int INDEX_PSDBTYPENAME = 5;
    private static final int INDEX_PSDBVFCODEID = 6;
    private static final int INDEX_PSDBVFCODENAME = 7;
    private static final int INDEX_PSDBVFID = 8;
    private static final int INDEX_PSDBVFNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDBVFCodeBase proxyPSDBVFCodeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean funccodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdbtypeidDirtyFlag = false;
    private boolean psdbtypenameDirtyFlag = false;
    private boolean psdbvfcodeidDirtyFlag = false;
    private boolean psdbvfcodenameDirtyFlag = false;
    private boolean psdbvfidDirtyFlag = false;
    private boolean psdbvfnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="funccode")
    private String funccode;
    @Column(name="memo")
    private String memo;
    @Column(name="psdbtypeid")
    private String psdbtypeid;
    @Column(name="psdbtypename")
    private String psdbtypename;
    @Column(name="psdbvfcodeid")
    private String psdbvfcodeid;
    @Column(name="psdbvfcodename")
    private String psdbvfcodename;
    @Column(name="psdbvfid")
    private String psdbvfid;
    @Column(name="psdbvfname")
    private String psdbvfname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDBTypeLock = new Integer(1);
    private PSDBType psdbtype = null;
    private Integer objPSDBVFLock = new Integer(1);
    private PSDBValueFunc psdbvf = null;

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

    public void setFUNCCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFUNCCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funccode = string;
        this.funccodeDirtyFlag = true;
    }

    public String getFUNCCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFUNCCode();
        }
        return this.funccode;
    }

    public boolean isFUNCCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFUNCCodeDirty();
        }
        return this.funccodeDirtyFlag;
    }

    public void resetFUNCCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFUNCCode();
            return;
        }
        this.funccodeDirtyFlag = false;
        this.funccode = null;
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

    public void setPSDBTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbtypeid = string;
        this.psdbtypeidDirtyFlag = true;
    }

    public String getPSDBTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBTypeId();
        }
        return this.psdbtypeid;
    }

    public boolean isPSDBTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBTypeIdDirty();
        }
        return this.psdbtypeidDirtyFlag;
    }

    public void resetPSDBTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBTypeId();
            return;
        }
        this.psdbtypeidDirtyFlag = false;
        this.psdbtypeid = null;
    }

    public void setPSDBTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbtypename = string;
        this.psdbtypenameDirtyFlag = true;
    }

    public String getPSDBTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBTypeName();
        }
        return this.psdbtypename;
    }

    public boolean isPSDBTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBTypeNameDirty();
        }
        return this.psdbtypenameDirtyFlag;
    }

    public void resetPSDBTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBTypeName();
            return;
        }
        this.psdbtypenameDirtyFlag = false;
        this.psdbtypename = null;
    }

    public void setPSDBVFCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBVFCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvfcodeid = string;
        this.psdbvfcodeidDirtyFlag = true;
    }

    public String getPSDBVFCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBVFCodeId();
        }
        return this.psdbvfcodeid;
    }

    public boolean isPSDBVFCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBVFCodeIdDirty();
        }
        return this.psdbvfcodeidDirtyFlag;
    }

    public void resetPSDBVFCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBVFCodeId();
            return;
        }
        this.psdbvfcodeidDirtyFlag = false;
        this.psdbvfcodeid = null;
    }

    public void setPSDBVFCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBVFCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvfcodename = string;
        this.psdbvfcodenameDirtyFlag = true;
    }

    public String getPSDBVFCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBVFCodeName();
        }
        return this.psdbvfcodename;
    }

    public boolean isPSDBVFCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBVFCodeNameDirty();
        }
        return this.psdbvfcodenameDirtyFlag;
    }

    public void resetPSDBVFCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBVFCodeName();
            return;
        }
        this.psdbvfcodenameDirtyFlag = false;
        this.psdbvfcodename = null;
    }

    public void setPSDBVFID(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBVFID(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvfid = string;
        this.psdbvfidDirtyFlag = true;
    }

    public String getPSDBVFID() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBVFID();
        }
        return this.psdbvfid;
    }

    public boolean isPSDBVFIDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBVFIDDirty();
        }
        return this.psdbvfidDirtyFlag;
    }

    public void resetPSDBVFID() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBVFID();
            return;
        }
        this.psdbvfidDirtyFlag = false;
        this.psdbvfid = null;
    }

    public void setPSDBVFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBVFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvfname = string;
        this.psdbvfnameDirtyFlag = true;
    }

    public String getPSDBVFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBVFName();
        }
        return this.psdbvfname;
    }

    public boolean isPSDBVFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBVFNameDirty();
        }
        return this.psdbvfnameDirtyFlag;
    }

    public void resetPSDBVFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBVFName();
            return;
        }
        this.psdbvfnameDirtyFlag = false;
        this.psdbvfname = null;
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
        PSDBVFCodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDBVFCodeBase pSDBVFCodeBase) {
        pSDBVFCodeBase.resetCreateDate();
        pSDBVFCodeBase.resetCreateMan();
        pSDBVFCodeBase.resetFUNCCode();
        pSDBVFCodeBase.resetMemo();
        pSDBVFCodeBase.resetPSDBTypeId();
        pSDBVFCodeBase.resetPSDBTypeName();
        pSDBVFCodeBase.resetPSDBVFCodeId();
        pSDBVFCodeBase.resetPSDBVFCodeName();
        pSDBVFCodeBase.resetPSDBVFID();
        pSDBVFCodeBase.resetPSDBVFName();
        pSDBVFCodeBase.resetUpdateDate();
        pSDBVFCodeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFUNCCodeDirty()) {
            hashMap.put(FIELD_FUNCCODE, this.getFUNCCode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDBTypeIdDirty()) {
            hashMap.put(FIELD_PSDBTYPEID, this.getPSDBTypeId());
        }
        if (!bl || this.isPSDBTypeNameDirty()) {
            hashMap.put(FIELD_PSDBTYPENAME, this.getPSDBTypeName());
        }
        if (!bl || this.isPSDBVFCodeIdDirty()) {
            hashMap.put(FIELD_PSDBVFCODEID, this.getPSDBVFCodeId());
        }
        if (!bl || this.isPSDBVFCodeNameDirty()) {
            hashMap.put(FIELD_PSDBVFCODENAME, this.getPSDBVFCodeName());
        }
        if (!bl || this.isPSDBVFIDDirty()) {
            hashMap.put(FIELD_PSDBVFID, this.getPSDBVFID());
        }
        if (!bl || this.isPSDBVFNameDirty()) {
            hashMap.put(FIELD_PSDBVFNAME, this.getPSDBVFName());
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
        return PSDBVFCodeBase.get(this, n);
    }

    private static Object get(PSDBVFCodeBase pSDBVFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBVFCodeBase.getCreateDate();
            }
            case 1: {
                return pSDBVFCodeBase.getCreateMan();
            }
            case 2: {
                return pSDBVFCodeBase.getFUNCCode();
            }
            case 3: {
                return pSDBVFCodeBase.getMemo();
            }
            case 4: {
                return pSDBVFCodeBase.getPSDBTypeId();
            }
            case 5: {
                return pSDBVFCodeBase.getPSDBTypeName();
            }
            case 6: {
                return pSDBVFCodeBase.getPSDBVFCodeId();
            }
            case 7: {
                return pSDBVFCodeBase.getPSDBVFCodeName();
            }
            case 8: {
                return pSDBVFCodeBase.getPSDBVFID();
            }
            case 9: {
                return pSDBVFCodeBase.getPSDBVFName();
            }
            case 10: {
                return pSDBVFCodeBase.getUpdateDate();
            }
            case 11: {
                return pSDBVFCodeBase.getUpdateMan();
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
        PSDBVFCodeBase.set(this, n, object);
    }

    private static void set(PSDBVFCodeBase pSDBVFCodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDBVFCodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDBVFCodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDBVFCodeBase.setFUNCCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDBVFCodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDBVFCodeBase.setPSDBTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDBVFCodeBase.setPSDBTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDBVFCodeBase.setPSDBVFCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDBVFCodeBase.setPSDBVFCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDBVFCodeBase.setPSDBVFID(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDBVFCodeBase.setPSDBVFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDBVFCodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDBVFCodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDBVFCodeBase.isNull(this, n);
    }

    private static boolean isNull(PSDBVFCodeBase pSDBVFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBVFCodeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDBVFCodeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDBVFCodeBase.getFUNCCode() == null;
            }
            case 3: {
                return pSDBVFCodeBase.getMemo() == null;
            }
            case 4: {
                return pSDBVFCodeBase.getPSDBTypeId() == null;
            }
            case 5: {
                return pSDBVFCodeBase.getPSDBTypeName() == null;
            }
            case 6: {
                return pSDBVFCodeBase.getPSDBVFCodeId() == null;
            }
            case 7: {
                return pSDBVFCodeBase.getPSDBVFCodeName() == null;
            }
            case 8: {
                return pSDBVFCodeBase.getPSDBVFID() == null;
            }
            case 9: {
                return pSDBVFCodeBase.getPSDBVFName() == null;
            }
            case 10: {
                return pSDBVFCodeBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDBVFCodeBase.getUpdateMan() == null;
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
        return PSDBVFCodeBase.contains(this, n);
    }

    private static boolean contains(PSDBVFCodeBase pSDBVFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBVFCodeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDBVFCodeBase.isCreateManDirty();
            }
            case 2: {
                return pSDBVFCodeBase.isFUNCCodeDirty();
            }
            case 3: {
                return pSDBVFCodeBase.isMemoDirty();
            }
            case 4: {
                return pSDBVFCodeBase.isPSDBTypeIdDirty();
            }
            case 5: {
                return pSDBVFCodeBase.isPSDBTypeNameDirty();
            }
            case 6: {
                return pSDBVFCodeBase.isPSDBVFCodeIdDirty();
            }
            case 7: {
                return pSDBVFCodeBase.isPSDBVFCodeNameDirty();
            }
            case 8: {
                return pSDBVFCodeBase.isPSDBVFIDDirty();
            }
            case 9: {
                return pSDBVFCodeBase.isPSDBVFNameDirty();
            }
            case 10: {
                return pSDBVFCodeBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDBVFCodeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDBVFCodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDBVFCodeBase pSDBVFCodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDBVFCodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDBVFCodeBase.getJSONValue((Object)pSDBVFCodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDBVFCodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDBVFCodeBase.getJSONValue((Object)pSDBVFCodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDBVFCodeBase.getFUNCCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funccode", (Object)PSDBVFCodeBase.getJSONValue((Object)pSDBVFCodeBase.getFUNCCode()), (boolean)false);
        }
        if (bl || pSDBVFCodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDBVFCodeBase.getJSONValue((Object)pSDBVFCodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDBVFCodeBase.getPSDBTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbtypeid", (Object)PSDBVFCodeBase.getJSONValue((Object)pSDBVFCodeBase.getPSDBTypeId()), (boolean)false);
        }
        if (bl || pSDBVFCodeBase.getPSDBTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbtypename", (Object)PSDBVFCodeBase.getJSONValue((Object)pSDBVFCodeBase.getPSDBTypeName()), (boolean)false);
        }
        if (bl || pSDBVFCodeBase.getPSDBVFCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvfcodeid", (Object)PSDBVFCodeBase.getJSONValue((Object)pSDBVFCodeBase.getPSDBVFCodeId()), (boolean)false);
        }
        if (bl || pSDBVFCodeBase.getPSDBVFCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvfcodename", (Object)PSDBVFCodeBase.getJSONValue((Object)pSDBVFCodeBase.getPSDBVFCodeName()), (boolean)false);
        }
        if (bl || pSDBVFCodeBase.getPSDBVFID() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvfid", (Object)PSDBVFCodeBase.getJSONValue((Object)pSDBVFCodeBase.getPSDBVFID()), (boolean)false);
        }
        if (bl || pSDBVFCodeBase.getPSDBVFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvfname", (Object)PSDBVFCodeBase.getJSONValue((Object)pSDBVFCodeBase.getPSDBVFName()), (boolean)false);
        }
        if (bl || pSDBVFCodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDBVFCodeBase.getJSONValue((Object)pSDBVFCodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDBVFCodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDBVFCodeBase.getJSONValue((Object)pSDBVFCodeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDBVFCodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDBVFCodeBase pSDBVFCodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDBVFCodeBase.getCreateDate() != null) {
            object = pSDBVFCodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBVFCodeBase.getCreateMan() != null) {
            object = pSDBVFCodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBVFCodeBase.getFUNCCode() != null) {
            object = pSDBVFCodeBase.getFUNCCode();
            xmlNode.setAttribute(FIELD_FUNCCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDBVFCodeBase.getMemo() != null) {
            object = pSDBVFCodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDBVFCodeBase.getPSDBTypeId() != null) {
            object = pSDBVFCodeBase.getPSDBTypeId();
            xmlNode.setAttribute(FIELD_PSDBTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDBVFCodeBase.getPSDBTypeName() != null) {
            object = pSDBVFCodeBase.getPSDBTypeName();
            xmlNode.setAttribute(FIELD_PSDBTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBVFCodeBase.getPSDBVFCodeId() != null) {
            object = pSDBVFCodeBase.getPSDBVFCodeId();
            xmlNode.setAttribute(FIELD_PSDBVFCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDBVFCodeBase.getPSDBVFCodeName() != null) {
            object = pSDBVFCodeBase.getPSDBVFCodeName();
            xmlNode.setAttribute(FIELD_PSDBVFCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBVFCodeBase.getPSDBVFID() != null) {
            object = pSDBVFCodeBase.getPSDBVFID();
            xmlNode.setAttribute(FIELD_PSDBVFID, object == null ? "" : (String)object);
        }
        if (bl || pSDBVFCodeBase.getPSDBVFName() != null) {
            object = pSDBVFCodeBase.getPSDBVFName();
            xmlNode.setAttribute(FIELD_PSDBVFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBVFCodeBase.getUpdateDate() != null) {
            object = pSDBVFCodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBVFCodeBase.getUpdateMan() != null) {
            object = pSDBVFCodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDBVFCodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDBVFCodeBase pSDBVFCodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDBVFCodeBase.isCreateDateDirty() && (bl || pSDBVFCodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDBVFCodeBase.getCreateDate());
        }
        if (pSDBVFCodeBase.isCreateManDirty() && (bl || pSDBVFCodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDBVFCodeBase.getCreateMan());
        }
        if (pSDBVFCodeBase.isFUNCCodeDirty() && (bl || pSDBVFCodeBase.getFUNCCode() != null)) {
            iDataObject.set(FIELD_FUNCCODE, (Object)pSDBVFCodeBase.getFUNCCode());
        }
        if (pSDBVFCodeBase.isMemoDirty() && (bl || pSDBVFCodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDBVFCodeBase.getMemo());
        }
        if (pSDBVFCodeBase.isPSDBTypeIdDirty() && (bl || pSDBVFCodeBase.getPSDBTypeId() != null)) {
            iDataObject.set(FIELD_PSDBTYPEID, (Object)pSDBVFCodeBase.getPSDBTypeId());
        }
        if (pSDBVFCodeBase.isPSDBTypeNameDirty() && (bl || pSDBVFCodeBase.getPSDBTypeName() != null)) {
            iDataObject.set(FIELD_PSDBTYPENAME, (Object)pSDBVFCodeBase.getPSDBTypeName());
        }
        if (pSDBVFCodeBase.isPSDBVFCodeIdDirty() && (bl || pSDBVFCodeBase.getPSDBVFCodeId() != null)) {
            iDataObject.set(FIELD_PSDBVFCODEID, (Object)pSDBVFCodeBase.getPSDBVFCodeId());
        }
        if (pSDBVFCodeBase.isPSDBVFCodeNameDirty() && (bl || pSDBVFCodeBase.getPSDBVFCodeName() != null)) {
            iDataObject.set(FIELD_PSDBVFCODENAME, (Object)pSDBVFCodeBase.getPSDBVFCodeName());
        }
        if (pSDBVFCodeBase.isPSDBVFIDDirty() && (bl || pSDBVFCodeBase.getPSDBVFID() != null)) {
            iDataObject.set(FIELD_PSDBVFID, (Object)pSDBVFCodeBase.getPSDBVFID());
        }
        if (pSDBVFCodeBase.isPSDBVFNameDirty() && (bl || pSDBVFCodeBase.getPSDBVFName() != null)) {
            iDataObject.set(FIELD_PSDBVFNAME, (Object)pSDBVFCodeBase.getPSDBVFName());
        }
        if (pSDBVFCodeBase.isUpdateDateDirty() && (bl || pSDBVFCodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDBVFCodeBase.getUpdateDate());
        }
        if (pSDBVFCodeBase.isUpdateManDirty() && (bl || pSDBVFCodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDBVFCodeBase.getUpdateMan());
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
        return PSDBVFCodeBase.remove(this, n);
    }

    private static boolean remove(PSDBVFCodeBase pSDBVFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDBVFCodeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDBVFCodeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDBVFCodeBase.resetFUNCCode();
                return true;
            }
            case 3: {
                pSDBVFCodeBase.resetMemo();
                return true;
            }
            case 4: {
                pSDBVFCodeBase.resetPSDBTypeId();
                return true;
            }
            case 5: {
                pSDBVFCodeBase.resetPSDBTypeName();
                return true;
            }
            case 6: {
                pSDBVFCodeBase.resetPSDBVFCodeId();
                return true;
            }
            case 7: {
                pSDBVFCodeBase.resetPSDBVFCodeName();
                return true;
            }
            case 8: {
                pSDBVFCodeBase.resetPSDBVFID();
                return true;
            }
            case 9: {
                pSDBVFCodeBase.resetPSDBVFName();
                return true;
            }
            case 10: {
                pSDBVFCodeBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDBVFCodeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBType getPSDBType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBType();
        }
        if (this.getPSDBTypeId() == null) {
            return null;
        }
        Integer n = this.objPSDBTypeLock;
        synchronized (n) {
            if (this.psdbtype != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBTypeId(), (Object)this.psdbtype.getPSDBTypeId()) != 0L) {
                this.psdbtype = null;
            }
            if (this.psdbtype == null) {
                PSDBType pSDBType = new PSDBType();
                pSDBType.setPSDBTypeId(this.getPSDBTypeId());
                PSDBTypeService pSDBTypeService = (PSDBTypeService)ServiceGlobal.getService(PSDBTypeService.class, (SessionFactory)this.getSessionFactory());
                pSDBTypeService.autoGet(pSDBType);
                this.psdbtype = pSDBType;
            }
            return this.psdbtype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBValueFunc getPSDBVF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBVF();
        }
        if (this.getPSDBVFID() == null) {
            return null;
        }
        Integer n = this.objPSDBVFLock;
        synchronized (n) {
            if (this.psdbvf != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBVFID(), (Object)this.psdbvf.getPSDBValueFuncId()) != 0L) {
                this.psdbvf = null;
            }
            if (this.psdbvf == null) {
                PSDBValueFunc pSDBValueFunc = new PSDBValueFunc();
                pSDBValueFunc.setPSDBValueFuncId(this.getPSDBVFID());
                PSDBValueFuncService pSDBValueFuncService = (PSDBValueFuncService)ServiceGlobal.getService(PSDBValueFuncService.class, (SessionFactory)this.getSessionFactory());
                pSDBValueFuncService.autoGet(pSDBValueFunc);
                this.psdbvf = pSDBValueFunc;
            }
            return this.psdbvf;
        }
    }

    private PSDBVFCodeBase getProxyEntity() {
        return this.proxyPSDBVFCodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDBVFCodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDBVFCodeBase) {
            this.proxyPSDBVFCodeBase = (PSDBVFCodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBVFCodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_FUNCCODE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDBTYPEID, 4);
        fieldIndexMap.put(FIELD_PSDBTYPENAME, 5);
        fieldIndexMap.put(FIELD_PSDBVFCODEID, 6);
        fieldIndexMap.put(FIELD_PSDBVFCODENAME, 7);
        fieldIndexMap.put(FIELD_PSDBVFID, 8);
        fieldIndexMap.put(FIELD_PSDBVFNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

