/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevUserModelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevUserModelBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MARKFLAG = "MARKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVUSERMODELID = "PSDEVUSERMODELID";
    public static final String FIELD_PSDEVUSERMODELNAME = "PSDEVUSERMODELNAME";
    public static final String FIELD_PSMODELTYPE = "PSMODELTYPE";
    public static final String FIELD_PSMODELTYPENAME = "PSMODELTYPENAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MARKFLAG = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEVUSERMODELID = 4;
    private static final int INDEX_PSDEVUSERMODELNAME = 5;
    private static final int INDEX_PSMODELTYPE = 6;
    private static final int INDEX_PSMODELTYPENAME = 7;
    private static final int INDEX_PSOBJID = 8;
    private static final int INDEX_PSOBJNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevUserModelBase proxyPSDevUserModelBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean markflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevusermodelidDirtyFlag = false;
    private boolean psdevusermodelnameDirtyFlag = false;
    private boolean psmodeltypeDirtyFlag = false;
    private boolean psmodeltypenameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="markflag")
    private Integer markflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevusermodelid")
    private String psdevusermodelid;
    @Column(name="psdevusermodelname")
    private String psdevusermodelname;
    @Column(name="psmodeltype")
    private String psmodeltype;
    @Column(name="psmodeltypename")
    private String psmodeltypename;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

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

    public void setMarkFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMarkFlag(n);
            return;
        }
        this.markflag = n;
        this.markflagDirtyFlag = true;
    }

    public Integer getMarkFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMarkFlag();
        }
        return this.markflag;
    }

    public boolean isMarkFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMarkFlagDirty();
        }
        return this.markflagDirtyFlag;
    }

    public void resetMarkFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMarkFlag();
            return;
        }
        this.markflagDirtyFlag = false;
        this.markflag = null;
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

    public void setPSDevUserModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevusermodelid = string;
        this.psdevusermodelidDirtyFlag = true;
    }

    public String getPSDevUserModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserModelId();
        }
        return this.psdevusermodelid;
    }

    public boolean isPSDevUserModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserModelIdDirty();
        }
        return this.psdevusermodelidDirtyFlag;
    }

    public void resetPSDevUserModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserModelId();
            return;
        }
        this.psdevusermodelidDirtyFlag = false;
        this.psdevusermodelid = null;
    }

    public void setPSDevUserModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevusermodelname = string;
        this.psdevusermodelnameDirtyFlag = true;
    }

    public String getPSDevUserModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserModelName();
        }
        return this.psdevusermodelname;
    }

    public boolean isPSDevUserModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserModelNameDirty();
        }
        return this.psdevusermodelnameDirtyFlag;
    }

    public void resetPSDevUserModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserModelName();
            return;
        }
        this.psdevusermodelnameDirtyFlag = false;
        this.psdevusermodelname = null;
    }

    public void setPSModelType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodeltype = string;
        this.psmodeltypeDirtyFlag = true;
    }

    public String getPSModelType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelType();
        }
        return this.psmodeltype;
    }

    public boolean isPSModelTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelTypeDirty();
        }
        return this.psmodeltypeDirtyFlag;
    }

    public void resetPSModelType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelType();
            return;
        }
        this.psmodeltypeDirtyFlag = false;
        this.psmodeltype = null;
    }

    public void setPSModelTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodeltypename = string;
        this.psmodeltypenameDirtyFlag = true;
    }

    public String getPSModelTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelTypeName();
        }
        return this.psmodeltypename;
    }

    public boolean isPSModelTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelTypeNameDirty();
        }
        return this.psmodeltypenameDirtyFlag;
    }

    public void resetPSModelTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelTypeName();
            return;
        }
        this.psmodeltypenameDirtyFlag = false;
        this.psmodeltypename = null;
    }

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
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
        PSDevUserModelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevUserModelBase pSDevUserModelBase) {
        pSDevUserModelBase.resetCreateDate();
        pSDevUserModelBase.resetCreateMan();
        pSDevUserModelBase.resetMarkFlag();
        pSDevUserModelBase.resetMemo();
        pSDevUserModelBase.resetPSDevUserModelId();
        pSDevUserModelBase.resetPSDevUserModelName();
        pSDevUserModelBase.resetPSModelType();
        pSDevUserModelBase.resetPSModelTypeName();
        pSDevUserModelBase.resetPSObjId();
        pSDevUserModelBase.resetPSObjName();
        pSDevUserModelBase.resetUpdateDate();
        pSDevUserModelBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMarkFlagDirty()) {
            hashMap.put(FIELD_MARKFLAG, this.getMarkFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevUserModelIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERMODELID, this.getPSDevUserModelId());
        }
        if (!bl || this.isPSDevUserModelNameDirty()) {
            hashMap.put(FIELD_PSDEVUSERMODELNAME, this.getPSDevUserModelName());
        }
        if (!bl || this.isPSModelTypeDirty()) {
            hashMap.put(FIELD_PSMODELTYPE, this.getPSModelType());
        }
        if (!bl || this.isPSModelTypeNameDirty()) {
            hashMap.put(FIELD_PSMODELTYPENAME, this.getPSModelTypeName());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
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
        return PSDevUserModelBase.get(this, n);
    }

    private static Object get(PSDevUserModelBase pSDevUserModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserModelBase.getCreateDate();
            }
            case 1: {
                return pSDevUserModelBase.getCreateMan();
            }
            case 2: {
                return pSDevUserModelBase.getMarkFlag();
            }
            case 3: {
                return pSDevUserModelBase.getMemo();
            }
            case 4: {
                return pSDevUserModelBase.getPSDevUserModelId();
            }
            case 5: {
                return pSDevUserModelBase.getPSDevUserModelName();
            }
            case 6: {
                return pSDevUserModelBase.getPSModelType();
            }
            case 7: {
                return pSDevUserModelBase.getPSModelTypeName();
            }
            case 8: {
                return pSDevUserModelBase.getPSObjId();
            }
            case 9: {
                return pSDevUserModelBase.getPSObjName();
            }
            case 10: {
                return pSDevUserModelBase.getUpdateDate();
            }
            case 11: {
                return pSDevUserModelBase.getUpdateMan();
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
        PSDevUserModelBase.set(this, n, object);
    }

    private static void set(PSDevUserModelBase pSDevUserModelBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevUserModelBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevUserModelBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevUserModelBase.setMarkFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDevUserModelBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevUserModelBase.setPSDevUserModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevUserModelBase.setPSDevUserModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevUserModelBase.setPSModelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevUserModelBase.setPSModelTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevUserModelBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevUserModelBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevUserModelBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDevUserModelBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevUserModelBase.isNull(this, n);
    }

    private static boolean isNull(PSDevUserModelBase pSDevUserModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserModelBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevUserModelBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevUserModelBase.getMarkFlag() == null;
            }
            case 3: {
                return pSDevUserModelBase.getMemo() == null;
            }
            case 4: {
                return pSDevUserModelBase.getPSDevUserModelId() == null;
            }
            case 5: {
                return pSDevUserModelBase.getPSDevUserModelName() == null;
            }
            case 6: {
                return pSDevUserModelBase.getPSModelType() == null;
            }
            case 7: {
                return pSDevUserModelBase.getPSModelTypeName() == null;
            }
            case 8: {
                return pSDevUserModelBase.getPSObjId() == null;
            }
            case 9: {
                return pSDevUserModelBase.getPSObjName() == null;
            }
            case 10: {
                return pSDevUserModelBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDevUserModelBase.getUpdateMan() == null;
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
        return PSDevUserModelBase.contains(this, n);
    }

    private static boolean contains(PSDevUserModelBase pSDevUserModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserModelBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevUserModelBase.isCreateManDirty();
            }
            case 2: {
                return pSDevUserModelBase.isMarkFlagDirty();
            }
            case 3: {
                return pSDevUserModelBase.isMemoDirty();
            }
            case 4: {
                return pSDevUserModelBase.isPSDevUserModelIdDirty();
            }
            case 5: {
                return pSDevUserModelBase.isPSDevUserModelNameDirty();
            }
            case 6: {
                return pSDevUserModelBase.isPSModelTypeDirty();
            }
            case 7: {
                return pSDevUserModelBase.isPSModelTypeNameDirty();
            }
            case 8: {
                return pSDevUserModelBase.isPSObjIdDirty();
            }
            case 9: {
                return pSDevUserModelBase.isPSObjNameDirty();
            }
            case 10: {
                return pSDevUserModelBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDevUserModelBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevUserModelBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevUserModelBase pSDevUserModelBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevUserModelBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevUserModelBase.getJSONValue((Object)pSDevUserModelBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevUserModelBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevUserModelBase.getJSONValue((Object)pSDevUserModelBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevUserModelBase.getMarkFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"markflag", (Object)PSDevUserModelBase.getJSONValue((Object)pSDevUserModelBase.getMarkFlag()), (boolean)false);
        }
        if (bl || pSDevUserModelBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevUserModelBase.getJSONValue((Object)pSDevUserModelBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevUserModelBase.getPSDevUserModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevusermodelid", (Object)PSDevUserModelBase.getJSONValue((Object)pSDevUserModelBase.getPSDevUserModelId()), (boolean)false);
        }
        if (bl || pSDevUserModelBase.getPSDevUserModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevusermodelname", (Object)PSDevUserModelBase.getJSONValue((Object)pSDevUserModelBase.getPSDevUserModelName()), (boolean)false);
        }
        if (bl || pSDevUserModelBase.getPSModelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodeltype", (Object)PSDevUserModelBase.getJSONValue((Object)pSDevUserModelBase.getPSModelType()), (boolean)false);
        }
        if (bl || pSDevUserModelBase.getPSModelTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodeltypename", (Object)PSDevUserModelBase.getJSONValue((Object)pSDevUserModelBase.getPSModelTypeName()), (boolean)false);
        }
        if (bl || pSDevUserModelBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSDevUserModelBase.getJSONValue((Object)pSDevUserModelBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSDevUserModelBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSDevUserModelBase.getJSONValue((Object)pSDevUserModelBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSDevUserModelBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevUserModelBase.getJSONValue((Object)pSDevUserModelBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevUserModelBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevUserModelBase.getJSONValue((Object)pSDevUserModelBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevUserModelBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevUserModelBase pSDevUserModelBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevUserModelBase.getCreateDate() != null) {
            object = pSDevUserModelBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevUserModelBase.getCreateMan() != null) {
            object = pSDevUserModelBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserModelBase.getMarkFlag() != null) {
            object = pSDevUserModelBase.getMarkFlag();
            xmlNode.setAttribute(FIELD_MARKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevUserModelBase.getMemo() != null) {
            object = pSDevUserModelBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserModelBase.getPSDevUserModelId() != null) {
            object = pSDevUserModelBase.getPSDevUserModelId();
            xmlNode.setAttribute(FIELD_PSDEVUSERMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserModelBase.getPSDevUserModelName() != null) {
            object = pSDevUserModelBase.getPSDevUserModelName();
            xmlNode.setAttribute(FIELD_PSDEVUSERMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserModelBase.getPSModelType() != null) {
            object = pSDevUserModelBase.getPSModelType();
            xmlNode.setAttribute(FIELD_PSMODELTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserModelBase.getPSModelTypeName() != null) {
            object = pSDevUserModelBase.getPSModelTypeName();
            xmlNode.setAttribute(FIELD_PSMODELTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserModelBase.getPSObjId() != null) {
            object = pSDevUserModelBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserModelBase.getPSObjName() != null) {
            object = pSDevUserModelBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserModelBase.getUpdateDate() != null) {
            object = pSDevUserModelBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevUserModelBase.getUpdateMan() != null) {
            object = pSDevUserModelBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevUserModelBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevUserModelBase pSDevUserModelBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevUserModelBase.isCreateDateDirty() && (bl || pSDevUserModelBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevUserModelBase.getCreateDate());
        }
        if (pSDevUserModelBase.isCreateManDirty() && (bl || pSDevUserModelBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevUserModelBase.getCreateMan());
        }
        if (pSDevUserModelBase.isMarkFlagDirty() && (bl || pSDevUserModelBase.getMarkFlag() != null)) {
            iDataObject.set(FIELD_MARKFLAG, (Object)pSDevUserModelBase.getMarkFlag());
        }
        if (pSDevUserModelBase.isMemoDirty() && (bl || pSDevUserModelBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevUserModelBase.getMemo());
        }
        if (pSDevUserModelBase.isPSDevUserModelIdDirty() && (bl || pSDevUserModelBase.getPSDevUserModelId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERMODELID, (Object)pSDevUserModelBase.getPSDevUserModelId());
        }
        if (pSDevUserModelBase.isPSDevUserModelNameDirty() && (bl || pSDevUserModelBase.getPSDevUserModelName() != null)) {
            iDataObject.set(FIELD_PSDEVUSERMODELNAME, (Object)pSDevUserModelBase.getPSDevUserModelName());
        }
        if (pSDevUserModelBase.isPSModelTypeDirty() && (bl || pSDevUserModelBase.getPSModelType() != null)) {
            iDataObject.set(FIELD_PSMODELTYPE, (Object)pSDevUserModelBase.getPSModelType());
        }
        if (pSDevUserModelBase.isPSModelTypeNameDirty() && (bl || pSDevUserModelBase.getPSModelTypeName() != null)) {
            iDataObject.set(FIELD_PSMODELTYPENAME, (Object)pSDevUserModelBase.getPSModelTypeName());
        }
        if (pSDevUserModelBase.isPSObjIdDirty() && (bl || pSDevUserModelBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSDevUserModelBase.getPSObjId());
        }
        if (pSDevUserModelBase.isPSObjNameDirty() && (bl || pSDevUserModelBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSDevUserModelBase.getPSObjName());
        }
        if (pSDevUserModelBase.isUpdateDateDirty() && (bl || pSDevUserModelBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevUserModelBase.getUpdateDate());
        }
        if (pSDevUserModelBase.isUpdateManDirty() && (bl || pSDevUserModelBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevUserModelBase.getUpdateMan());
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
        return PSDevUserModelBase.remove(this, n);
    }

    private static boolean remove(PSDevUserModelBase pSDevUserModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevUserModelBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevUserModelBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevUserModelBase.resetMarkFlag();
                return true;
            }
            case 3: {
                pSDevUserModelBase.resetMemo();
                return true;
            }
            case 4: {
                pSDevUserModelBase.resetPSDevUserModelId();
                return true;
            }
            case 5: {
                pSDevUserModelBase.resetPSDevUserModelName();
                return true;
            }
            case 6: {
                pSDevUserModelBase.resetPSModelType();
                return true;
            }
            case 7: {
                pSDevUserModelBase.resetPSModelTypeName();
                return true;
            }
            case 8: {
                pSDevUserModelBase.resetPSObjId();
                return true;
            }
            case 9: {
                pSDevUserModelBase.resetPSObjName();
                return true;
            }
            case 10: {
                pSDevUserModelBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDevUserModelBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDevUserModelBase getProxyEntity() {
        return this.proxyPSDevUserModelBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevUserModelBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevUserModelBase) {
            this.proxyPSDevUserModelBase = (PSDevUserModelBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserModelService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MARKFLAG, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEVUSERMODELID, 4);
        fieldIndexMap.put(FIELD_PSDEVUSERMODELNAME, 5);
        fieldIndexMap.put(FIELD_PSMODELTYPE, 6);
        fieldIndexMap.put(FIELD_PSMODELTYPENAME, 7);
        fieldIndexMap.put(FIELD_PSOBJID, 8);
        fieldIndexMap.put(FIELD_PSOBJNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

