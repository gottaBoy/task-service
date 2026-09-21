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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVF;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBVFCodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDBVFCodeBase.class);
    public static final String FIELD_CALLCODE = "CALLCODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBTYPE = "DBTYPE";
    public static final String FIELD_FUNCCODE = "FUNCCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSDBVFCODEID = "PSSYSDBVFCODEID";
    public static final String FIELD_PSSYSDBVFCODENAME = "PSSYSDBVFCODENAME";
    public static final String FIELD_PSSYSDBVFID = "PSSYSDBVFID";
    public static final String FIELD_PSSYSDBVFNAME = "PSSYSDBVFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CALLCODE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DBTYPE = 3;
    private static final int INDEX_FUNCCODE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSSYSDBVFCODEID = 6;
    private static final int INDEX_PSSYSDBVFCODENAME = 7;
    private static final int INDEX_PSSYSDBVFID = 8;
    private static final int INDEX_PSSYSDBVFNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDBVFCodeBase proxyPSSysDBVFCodeBase = null;
    private boolean callcodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbtypeDirtyFlag = false;
    private boolean funccodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysdbvfcodeidDirtyFlag = false;
    private boolean pssysdbvfcodenameDirtyFlag = false;
    private boolean pssysdbvfidDirtyFlag = false;
    private boolean pssysdbvfnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="callcode")
    private String callcode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbtype")
    private String dbtype;
    @Column(name="funccode")
    private String funccode;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysdbvfcodeid")
    private String pssysdbvfcodeid;
    @Column(name="pssysdbvfcodename")
    private String pssysdbvfcodename;
    @Column(name="pssysdbvfid")
    private String pssysdbvfid;
    @Column(name="pssysdbvfname")
    private String pssysdbvfname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSysDBVFLock = new Integer(1);
    private PSSysDBVF pssysdbvf = null;

    public void setCallCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCallCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.callcode = string;
        this.callcodeDirtyFlag = true;
    }

    public String getCallCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCallCode();
        }
        return this.callcode;
    }

    public boolean isCallCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCallCodeDirty();
        }
        return this.callcodeDirtyFlag;
    }

    public void resetCallCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCallCode();
            return;
        }
        this.callcodeDirtyFlag = false;
        this.callcode = null;
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

    public void setDBType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbtype = string;
        this.dbtypeDirtyFlag = true;
    }

    public String getDBType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBType();
        }
        return this.dbtype;
    }

    public boolean isDBTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBTypeDirty();
        }
        return this.dbtypeDirtyFlag;
    }

    public void resetDBType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBType();
            return;
        }
        this.dbtypeDirtyFlag = false;
        this.dbtype = null;
    }

    public void setFuncCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funccode = string;
        this.funccodeDirtyFlag = true;
    }

    public String getFuncCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncCode();
        }
        return this.funccode;
    }

    public boolean isFuncCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncCodeDirty();
        }
        return this.funccodeDirtyFlag;
    }

    public void resetFuncCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncCode();
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

    public void setPSSysDBVFCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBVFCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbvfcodeid = string;
        this.pssysdbvfcodeidDirtyFlag = true;
    }

    public String getPSSysDBVFCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVFCodeId();
        }
        return this.pssysdbvfcodeid;
    }

    public boolean isPSSysDBVFCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBVFCodeIdDirty();
        }
        return this.pssysdbvfcodeidDirtyFlag;
    }

    public void resetPSSysDBVFCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBVFCodeId();
            return;
        }
        this.pssysdbvfcodeidDirtyFlag = false;
        this.pssysdbvfcodeid = null;
    }

    public void setPSSysDBVFCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBVFCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbvfcodename = string;
        this.pssysdbvfcodenameDirtyFlag = true;
    }

    public String getPSSysDBVFCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVFCodeName();
        }
        return this.pssysdbvfcodename;
    }

    public boolean isPSSysDBVFCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBVFCodeNameDirty();
        }
        return this.pssysdbvfcodenameDirtyFlag;
    }

    public void resetPSSysDBVFCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBVFCodeName();
            return;
        }
        this.pssysdbvfcodenameDirtyFlag = false;
        this.pssysdbvfcodename = null;
    }

    public void setPSSysDBVFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBVFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbvfid = string;
        this.pssysdbvfidDirtyFlag = true;
    }

    public String getPSSysDBVFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVFId();
        }
        return this.pssysdbvfid;
    }

    public boolean isPSSysDBVFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBVFIdDirty();
        }
        return this.pssysdbvfidDirtyFlag;
    }

    public void resetPSSysDBVFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBVFId();
            return;
        }
        this.pssysdbvfidDirtyFlag = false;
        this.pssysdbvfid = null;
    }

    public void setPSSysDBVFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBVFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbvfname = string;
        this.pssysdbvfnameDirtyFlag = true;
    }

    public String getPSSysDBVFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVFName();
        }
        return this.pssysdbvfname;
    }

    public boolean isPSSysDBVFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBVFNameDirty();
        }
        return this.pssysdbvfnameDirtyFlag;
    }

    public void resetPSSysDBVFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBVFName();
            return;
        }
        this.pssysdbvfnameDirtyFlag = false;
        this.pssysdbvfname = null;
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
        PSSysDBVFCodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDBVFCodeBase pSSysDBVFCodeBase) {
        pSSysDBVFCodeBase.resetCallCode();
        pSSysDBVFCodeBase.resetCreateDate();
        pSSysDBVFCodeBase.resetCreateMan();
        pSSysDBVFCodeBase.resetDBType();
        pSSysDBVFCodeBase.resetFuncCode();
        pSSysDBVFCodeBase.resetMemo();
        pSSysDBVFCodeBase.resetPSSysDBVFCodeId();
        pSSysDBVFCodeBase.resetPSSysDBVFCodeName();
        pSSysDBVFCodeBase.resetPSSysDBVFId();
        pSSysDBVFCodeBase.resetPSSysDBVFName();
        pSSysDBVFCodeBase.resetUpdateDate();
        pSSysDBVFCodeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCallCodeDirty()) {
            hashMap.put(FIELD_CALLCODE, this.getCallCode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDBTypeDirty()) {
            hashMap.put(FIELD_DBTYPE, this.getDBType());
        }
        if (!bl || this.isFuncCodeDirty()) {
            hashMap.put(FIELD_FUNCCODE, this.getFuncCode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysDBVFCodeIdDirty()) {
            hashMap.put(FIELD_PSSYSDBVFCODEID, this.getPSSysDBVFCodeId());
        }
        if (!bl || this.isPSSysDBVFCodeNameDirty()) {
            hashMap.put(FIELD_PSSYSDBVFCODENAME, this.getPSSysDBVFCodeName());
        }
        if (!bl || this.isPSSysDBVFIdDirty()) {
            hashMap.put(FIELD_PSSYSDBVFID, this.getPSSysDBVFId());
        }
        if (!bl || this.isPSSysDBVFNameDirty()) {
            hashMap.put(FIELD_PSSYSDBVFNAME, this.getPSSysDBVFName());
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
        return PSSysDBVFCodeBase.get(this, n);
    }

    private static Object get(PSSysDBVFCodeBase pSSysDBVFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBVFCodeBase.getCallCode();
            }
            case 1: {
                return pSSysDBVFCodeBase.getCreateDate();
            }
            case 2: {
                return pSSysDBVFCodeBase.getCreateMan();
            }
            case 3: {
                return pSSysDBVFCodeBase.getDBType();
            }
            case 4: {
                return pSSysDBVFCodeBase.getFuncCode();
            }
            case 5: {
                return pSSysDBVFCodeBase.getMemo();
            }
            case 6: {
                return pSSysDBVFCodeBase.getPSSysDBVFCodeId();
            }
            case 7: {
                return pSSysDBVFCodeBase.getPSSysDBVFCodeName();
            }
            case 8: {
                return pSSysDBVFCodeBase.getPSSysDBVFId();
            }
            case 9: {
                return pSSysDBVFCodeBase.getPSSysDBVFName();
            }
            case 10: {
                return pSSysDBVFCodeBase.getUpdateDate();
            }
            case 11: {
                return pSSysDBVFCodeBase.getUpdateMan();
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
        PSSysDBVFCodeBase.set(this, n, object);
    }

    private static void set(PSSysDBVFCodeBase pSSysDBVFCodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBVFCodeBase.setCallCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysDBVFCodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysDBVFCodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDBVFCodeBase.setDBType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDBVFCodeBase.setFuncCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDBVFCodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDBVFCodeBase.setPSSysDBVFCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDBVFCodeBase.setPSSysDBVFCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDBVFCodeBase.setPSSysDBVFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDBVFCodeBase.setPSSysDBVFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDBVFCodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysDBVFCodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysDBVFCodeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDBVFCodeBase pSSysDBVFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBVFCodeBase.getCallCode() == null;
            }
            case 1: {
                return pSSysDBVFCodeBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysDBVFCodeBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysDBVFCodeBase.getDBType() == null;
            }
            case 4: {
                return pSSysDBVFCodeBase.getFuncCode() == null;
            }
            case 5: {
                return pSSysDBVFCodeBase.getMemo() == null;
            }
            case 6: {
                return pSSysDBVFCodeBase.getPSSysDBVFCodeId() == null;
            }
            case 7: {
                return pSSysDBVFCodeBase.getPSSysDBVFCodeName() == null;
            }
            case 8: {
                return pSSysDBVFCodeBase.getPSSysDBVFId() == null;
            }
            case 9: {
                return pSSysDBVFCodeBase.getPSSysDBVFName() == null;
            }
            case 10: {
                return pSSysDBVFCodeBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysDBVFCodeBase.getUpdateMan() == null;
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
        return PSSysDBVFCodeBase.contains(this, n);
    }

    private static boolean contains(PSSysDBVFCodeBase pSSysDBVFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBVFCodeBase.isCallCodeDirty();
            }
            case 1: {
                return pSSysDBVFCodeBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysDBVFCodeBase.isCreateManDirty();
            }
            case 3: {
                return pSSysDBVFCodeBase.isDBTypeDirty();
            }
            case 4: {
                return pSSysDBVFCodeBase.isFuncCodeDirty();
            }
            case 5: {
                return pSSysDBVFCodeBase.isMemoDirty();
            }
            case 6: {
                return pSSysDBVFCodeBase.isPSSysDBVFCodeIdDirty();
            }
            case 7: {
                return pSSysDBVFCodeBase.isPSSysDBVFCodeNameDirty();
            }
            case 8: {
                return pSSysDBVFCodeBase.isPSSysDBVFIdDirty();
            }
            case 9: {
                return pSSysDBVFCodeBase.isPSSysDBVFNameDirty();
            }
            case 10: {
                return pSSysDBVFCodeBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysDBVFCodeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDBVFCodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDBVFCodeBase pSSysDBVFCodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDBVFCodeBase.getCallCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"callcode", (Object)PSSysDBVFCodeBase.getJSONValue((Object)pSSysDBVFCodeBase.getCallCode()), (boolean)false);
        }
        if (bl || pSSysDBVFCodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDBVFCodeBase.getJSONValue((Object)pSSysDBVFCodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDBVFCodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDBVFCodeBase.getJSONValue((Object)pSSysDBVFCodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDBVFCodeBase.getDBType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtype", (Object)PSSysDBVFCodeBase.getJSONValue((Object)pSSysDBVFCodeBase.getDBType()), (boolean)false);
        }
        if (bl || pSSysDBVFCodeBase.getFuncCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funccode", (Object)PSSysDBVFCodeBase.getJSONValue((Object)pSSysDBVFCodeBase.getFuncCode()), (boolean)false);
        }
        if (bl || pSSysDBVFCodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDBVFCodeBase.getJSONValue((Object)pSSysDBVFCodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDBVFCodeBase.getPSSysDBVFCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvfcodeid", (Object)PSSysDBVFCodeBase.getJSONValue((Object)pSSysDBVFCodeBase.getPSSysDBVFCodeId()), (boolean)false);
        }
        if (bl || pSSysDBVFCodeBase.getPSSysDBVFCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvfcodename", (Object)PSSysDBVFCodeBase.getJSONValue((Object)pSSysDBVFCodeBase.getPSSysDBVFCodeName()), (boolean)false);
        }
        if (bl || pSSysDBVFCodeBase.getPSSysDBVFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvfid", (Object)PSSysDBVFCodeBase.getJSONValue((Object)pSSysDBVFCodeBase.getPSSysDBVFId()), (boolean)false);
        }
        if (bl || pSSysDBVFCodeBase.getPSSysDBVFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvfname", (Object)PSSysDBVFCodeBase.getJSONValue((Object)pSSysDBVFCodeBase.getPSSysDBVFName()), (boolean)false);
        }
        if (bl || pSSysDBVFCodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDBVFCodeBase.getJSONValue((Object)pSSysDBVFCodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDBVFCodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDBVFCodeBase.getJSONValue((Object)pSSysDBVFCodeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDBVFCodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDBVFCodeBase pSSysDBVFCodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDBVFCodeBase.getCallCode() != null) {
            object = pSSysDBVFCodeBase.getCallCode();
            xmlNode.setAttribute(FIELD_CALLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFCodeBase.getCreateDate() != null) {
            object = pSSysDBVFCodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBVFCodeBase.getCreateMan() != null) {
            object = pSSysDBVFCodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFCodeBase.getDBType() != null) {
            object = pSSysDBVFCodeBase.getDBType();
            xmlNode.setAttribute(FIELD_DBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFCodeBase.getFuncCode() != null) {
            object = pSSysDBVFCodeBase.getFuncCode();
            xmlNode.setAttribute(FIELD_FUNCCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFCodeBase.getMemo() != null) {
            object = pSSysDBVFCodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFCodeBase.getPSSysDBVFCodeId() != null) {
            object = pSSysDBVFCodeBase.getPSSysDBVFCodeId();
            xmlNode.setAttribute(FIELD_PSSYSDBVFCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFCodeBase.getPSSysDBVFCodeName() != null) {
            object = pSSysDBVFCodeBase.getPSSysDBVFCodeName();
            xmlNode.setAttribute(FIELD_PSSYSDBVFCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFCodeBase.getPSSysDBVFId() != null) {
            object = pSSysDBVFCodeBase.getPSSysDBVFId();
            xmlNode.setAttribute(FIELD_PSSYSDBVFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFCodeBase.getPSSysDBVFName() != null) {
            object = pSSysDBVFCodeBase.getPSSysDBVFName();
            xmlNode.setAttribute(FIELD_PSSYSDBVFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFCodeBase.getUpdateDate() != null) {
            object = pSSysDBVFCodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBVFCodeBase.getUpdateMan() != null) {
            object = pSSysDBVFCodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDBVFCodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDBVFCodeBase pSSysDBVFCodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDBVFCodeBase.isCallCodeDirty() && (bl || pSSysDBVFCodeBase.getCallCode() != null)) {
            iDataObject.set(FIELD_CALLCODE, (Object)pSSysDBVFCodeBase.getCallCode());
        }
        if (pSSysDBVFCodeBase.isCreateDateDirty() && (bl || pSSysDBVFCodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDBVFCodeBase.getCreateDate());
        }
        if (pSSysDBVFCodeBase.isCreateManDirty() && (bl || pSSysDBVFCodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDBVFCodeBase.getCreateMan());
        }
        if (pSSysDBVFCodeBase.isDBTypeDirty() && (bl || pSSysDBVFCodeBase.getDBType() != null)) {
            iDataObject.set(FIELD_DBTYPE, (Object)pSSysDBVFCodeBase.getDBType());
        }
        if (pSSysDBVFCodeBase.isFuncCodeDirty() && (bl || pSSysDBVFCodeBase.getFuncCode() != null)) {
            iDataObject.set(FIELD_FUNCCODE, (Object)pSSysDBVFCodeBase.getFuncCode());
        }
        if (pSSysDBVFCodeBase.isMemoDirty() && (bl || pSSysDBVFCodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDBVFCodeBase.getMemo());
        }
        if (pSSysDBVFCodeBase.isPSSysDBVFCodeIdDirty() && (bl || pSSysDBVFCodeBase.getPSSysDBVFCodeId() != null)) {
            iDataObject.set(FIELD_PSSYSDBVFCODEID, (Object)pSSysDBVFCodeBase.getPSSysDBVFCodeId());
        }
        if (pSSysDBVFCodeBase.isPSSysDBVFCodeNameDirty() && (bl || pSSysDBVFCodeBase.getPSSysDBVFCodeName() != null)) {
            iDataObject.set(FIELD_PSSYSDBVFCODENAME, (Object)pSSysDBVFCodeBase.getPSSysDBVFCodeName());
        }
        if (pSSysDBVFCodeBase.isPSSysDBVFIdDirty() && (bl || pSSysDBVFCodeBase.getPSSysDBVFId() != null)) {
            iDataObject.set(FIELD_PSSYSDBVFID, (Object)pSSysDBVFCodeBase.getPSSysDBVFId());
        }
        if (pSSysDBVFCodeBase.isPSSysDBVFNameDirty() && (bl || pSSysDBVFCodeBase.getPSSysDBVFName() != null)) {
            iDataObject.set(FIELD_PSSYSDBVFNAME, (Object)pSSysDBVFCodeBase.getPSSysDBVFName());
        }
        if (pSSysDBVFCodeBase.isUpdateDateDirty() && (bl || pSSysDBVFCodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDBVFCodeBase.getUpdateDate());
        }
        if (pSSysDBVFCodeBase.isUpdateManDirty() && (bl || pSSysDBVFCodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDBVFCodeBase.getUpdateMan());
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
        return PSSysDBVFCodeBase.remove(this, n);
    }

    private static boolean remove(PSSysDBVFCodeBase pSSysDBVFCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBVFCodeBase.resetCallCode();
                return true;
            }
            case 1: {
                pSSysDBVFCodeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysDBVFCodeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysDBVFCodeBase.resetDBType();
                return true;
            }
            case 4: {
                pSSysDBVFCodeBase.resetFuncCode();
                return true;
            }
            case 5: {
                pSSysDBVFCodeBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysDBVFCodeBase.resetPSSysDBVFCodeId();
                return true;
            }
            case 7: {
                pSSysDBVFCodeBase.resetPSSysDBVFCodeName();
                return true;
            }
            case 8: {
                pSSysDBVFCodeBase.resetPSSysDBVFId();
                return true;
            }
            case 9: {
                pSSysDBVFCodeBase.resetPSSysDBVFName();
                return true;
            }
            case 10: {
                pSSysDBVFCodeBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysDBVFCodeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBVF getPSSysDBVF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVF();
        }
        if (this.getPSSysDBVFId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBVFLock;
        synchronized (n) {
            if (this.pssysdbvf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBVFId(), (Object)this.pssysdbvf.getPSSysDBVFId()) != 0L) {
                this.pssysdbvf = null;
            }
            if (this.pssysdbvf == null) {
                PSSysDBVF pSSysDBVF = new PSSysDBVF();
                pSSysDBVF.setPSSysDBVFId(this.getPSSysDBVFId());
                PSSysDBVFService pSSysDBVFService = (PSSysDBVFService)ServiceGlobal.getService(PSSysDBVFService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBVFService.autoGet((IEntity)pSSysDBVF);
                this.pssysdbvf = pSSysDBVF;
            }
            return this.pssysdbvf;
        }
    }

    private PSSysDBVFCodeBase getProxyEntity() {
        return this.proxyPSSysDBVFCodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDBVFCodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDBVFCodeBase) {
            this.proxyPSSysDBVFCodeBase = (PSSysDBVFCodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFCodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CALLCODE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DBTYPE, 3);
        fieldIndexMap.put(FIELD_FUNCCODE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSSYSDBVFCODEID, 6);
        fieldIndexMap.put(FIELD_PSSYSDBVFCODENAME, 7);
        fieldIndexMap.put(FIELD_PSSYSDBVFID, 8);
        fieldIndexMap.put(FIELD_PSSYSDBVFNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

