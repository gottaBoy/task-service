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
import net.ibizsys.pscore.srv.config.entity.PSViewLogicType;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.service.PSViewLogicTypeService;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewTypeLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSViewTypeLogicBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSVIEWLOGICTYPEID = "PSVIEWLOGICTYPEID";
    public static final String FIELD_PSVIEWLOGICTYPENAME = "PSVIEWLOGICTYPENAME";
    public static final String FIELD_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String FIELD_PSVIEWTYPELOGICID = "PSVIEWTYPELOGICID";
    public static final String FIELD_PSVIEWTYPELOGICNAME = "PSVIEWTYPELOGICNAME";
    public static final String FIELD_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSVIEWLOGICTYPEID = 3;
    private static final int INDEX_PSVIEWLOGICTYPENAME = 4;
    private static final int INDEX_PSVIEWTYPEID = 5;
    private static final int INDEX_PSVIEWTYPELOGICID = 6;
    private static final int INDEX_PSVIEWTYPELOGICNAME = 7;
    private static final int INDEX_PSVIEWTYPENAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSViewTypeLogicBase proxyPSViewTypeLogicBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psviewlogictypeidDirtyFlag = false;
    private boolean psviewlogictypenameDirtyFlag = false;
    private boolean psviewtypeidDirtyFlag = false;
    private boolean psviewtypelogicidDirtyFlag = false;
    private boolean psviewtypelogicnameDirtyFlag = false;
    private boolean psviewtypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psviewlogictypeid")
    private String psviewlogictypeid;
    @Column(name="psviewlogictypename")
    private String psviewlogictypename;
    @Column(name="psviewtypeid")
    private String psviewtypeid;
    @Column(name="psviewtypelogicid")
    private String psviewtypelogicid;
    @Column(name="psviewtypelogicname")
    private String psviewtypelogicname;
    @Column(name="psviewtypename")
    private String psviewtypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSViewLogicTypeLock = new Integer(1);
    private PSViewLogicType psviewlogictype = null;
    private Integer objPSViewTypeLock = new Integer(1);
    private PSViewType psviewtype = null;

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

    public void setPSViewLogicTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewLogicTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewlogictypeid = string;
        this.psviewlogictypeidDirtyFlag = true;
    }

    public String getPSViewLogicTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicTypeId();
        }
        return this.psviewlogictypeid;
    }

    public boolean isPSViewLogicTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewLogicTypeIdDirty();
        }
        return this.psviewlogictypeidDirtyFlag;
    }

    public void resetPSViewLogicTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewLogicTypeId();
            return;
        }
        this.psviewlogictypeidDirtyFlag = false;
        this.psviewlogictypeid = null;
    }

    public void setPSViewLogicTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewLogicTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewlogictypename = string;
        this.psviewlogictypenameDirtyFlag = true;
    }

    public String getPSViewLogicTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicTypeName();
        }
        return this.psviewlogictypename;
    }

    public boolean isPSViewLogicTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewLogicTypeNameDirty();
        }
        return this.psviewlogictypenameDirtyFlag;
    }

    public void resetPSViewLogicTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewLogicTypeName();
            return;
        }
        this.psviewlogictypenameDirtyFlag = false;
        this.psviewlogictypename = null;
    }

    public void setPSViewTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypeid = string;
        this.psviewtypeidDirtyFlag = true;
    }

    public String getPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeId();
        }
        return this.psviewtypeid;
    }

    public boolean isPSViewTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeIdDirty();
        }
        return this.psviewtypeidDirtyFlag;
    }

    public void resetPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeId();
            return;
        }
        this.psviewtypeidDirtyFlag = false;
        this.psviewtypeid = null;
    }

    public void setPSViewTypeLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypelogicid = string;
        this.psviewtypelogicidDirtyFlag = true;
    }

    public String getPSViewTypeLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeLogicId();
        }
        return this.psviewtypelogicid;
    }

    public boolean isPSViewTypeLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeLogicIdDirty();
        }
        return this.psviewtypelogicidDirtyFlag;
    }

    public void resetPSViewTypeLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeLogicId();
            return;
        }
        this.psviewtypelogicidDirtyFlag = false;
        this.psviewtypelogicid = null;
    }

    public void setPSViewTypeLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypelogicname = string;
        this.psviewtypelogicnameDirtyFlag = true;
    }

    public String getPSViewTypeLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeLogicName();
        }
        return this.psviewtypelogicname;
    }

    public boolean isPSViewTypeLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeLogicNameDirty();
        }
        return this.psviewtypelogicnameDirtyFlag;
    }

    public void resetPSViewTypeLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeLogicName();
            return;
        }
        this.psviewtypelogicnameDirtyFlag = false;
        this.psviewtypelogicname = null;
    }

    public void setPSViewTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypename = string;
        this.psviewtypenameDirtyFlag = true;
    }

    public String getPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeName();
        }
        return this.psviewtypename;
    }

    public boolean isPSViewTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeNameDirty();
        }
        return this.psviewtypenameDirtyFlag;
    }

    public void resetPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeName();
            return;
        }
        this.psviewtypenameDirtyFlag = false;
        this.psviewtypename = null;
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
        PSViewTypeLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSViewTypeLogicBase pSViewTypeLogicBase) {
        pSViewTypeLogicBase.resetCreateDate();
        pSViewTypeLogicBase.resetCreateMan();
        pSViewTypeLogicBase.resetMemo();
        pSViewTypeLogicBase.resetPSViewLogicTypeId();
        pSViewTypeLogicBase.resetPSViewLogicTypeName();
        pSViewTypeLogicBase.resetPSViewTypeId();
        pSViewTypeLogicBase.resetPSViewTypeLogicId();
        pSViewTypeLogicBase.resetPSViewTypeLogicName();
        pSViewTypeLogicBase.resetPSViewTypeName();
        pSViewTypeLogicBase.resetUpdateDate();
        pSViewTypeLogicBase.resetUpdateMan();
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
        if (!bl || this.isPSViewLogicTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWLOGICTYPEID, this.getPSViewLogicTypeId());
        }
        if (!bl || this.isPSViewLogicTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWLOGICTYPENAME, this.getPSViewLogicTypeName());
        }
        if (!bl || this.isPSViewTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWTYPEID, this.getPSViewTypeId());
        }
        if (!bl || this.isPSViewTypeLogicIdDirty()) {
            hashMap.put(FIELD_PSVIEWTYPELOGICID, this.getPSViewTypeLogicId());
        }
        if (!bl || this.isPSViewTypeLogicNameDirty()) {
            hashMap.put(FIELD_PSVIEWTYPELOGICNAME, this.getPSViewTypeLogicName());
        }
        if (!bl || this.isPSViewTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWTYPENAME, this.getPSViewTypeName());
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
        return PSViewTypeLogicBase.get(this, n);
    }

    private static Object get(PSViewTypeLogicBase pSViewTypeLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewTypeLogicBase.getCreateDate();
            }
            case 1: {
                return pSViewTypeLogicBase.getCreateMan();
            }
            case 2: {
                return pSViewTypeLogicBase.getMemo();
            }
            case 3: {
                return pSViewTypeLogicBase.getPSViewLogicTypeId();
            }
            case 4: {
                return pSViewTypeLogicBase.getPSViewLogicTypeName();
            }
            case 5: {
                return pSViewTypeLogicBase.getPSViewTypeId();
            }
            case 6: {
                return pSViewTypeLogicBase.getPSViewTypeLogicId();
            }
            case 7: {
                return pSViewTypeLogicBase.getPSViewTypeLogicName();
            }
            case 8: {
                return pSViewTypeLogicBase.getPSViewTypeName();
            }
            case 9: {
                return pSViewTypeLogicBase.getUpdateDate();
            }
            case 10: {
                return pSViewTypeLogicBase.getUpdateMan();
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
        PSViewTypeLogicBase.set(this, n, object);
    }

    private static void set(PSViewTypeLogicBase pSViewTypeLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSViewTypeLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSViewTypeLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSViewTypeLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSViewTypeLogicBase.setPSViewLogicTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSViewTypeLogicBase.setPSViewLogicTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSViewTypeLogicBase.setPSViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSViewTypeLogicBase.setPSViewTypeLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSViewTypeLogicBase.setPSViewTypeLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSViewTypeLogicBase.setPSViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSViewTypeLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSViewTypeLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSViewTypeLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSViewTypeLogicBase pSViewTypeLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewTypeLogicBase.getCreateDate() == null;
            }
            case 1: {
                return pSViewTypeLogicBase.getCreateMan() == null;
            }
            case 2: {
                return pSViewTypeLogicBase.getMemo() == null;
            }
            case 3: {
                return pSViewTypeLogicBase.getPSViewLogicTypeId() == null;
            }
            case 4: {
                return pSViewTypeLogicBase.getPSViewLogicTypeName() == null;
            }
            case 5: {
                return pSViewTypeLogicBase.getPSViewTypeId() == null;
            }
            case 6: {
                return pSViewTypeLogicBase.getPSViewTypeLogicId() == null;
            }
            case 7: {
                return pSViewTypeLogicBase.getPSViewTypeLogicName() == null;
            }
            case 8: {
                return pSViewTypeLogicBase.getPSViewTypeName() == null;
            }
            case 9: {
                return pSViewTypeLogicBase.getUpdateDate() == null;
            }
            case 10: {
                return pSViewTypeLogicBase.getUpdateMan() == null;
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
        return PSViewTypeLogicBase.contains(this, n);
    }

    private static boolean contains(PSViewTypeLogicBase pSViewTypeLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewTypeLogicBase.isCreateDateDirty();
            }
            case 1: {
                return pSViewTypeLogicBase.isCreateManDirty();
            }
            case 2: {
                return pSViewTypeLogicBase.isMemoDirty();
            }
            case 3: {
                return pSViewTypeLogicBase.isPSViewLogicTypeIdDirty();
            }
            case 4: {
                return pSViewTypeLogicBase.isPSViewLogicTypeNameDirty();
            }
            case 5: {
                return pSViewTypeLogicBase.isPSViewTypeIdDirty();
            }
            case 6: {
                return pSViewTypeLogicBase.isPSViewTypeLogicIdDirty();
            }
            case 7: {
                return pSViewTypeLogicBase.isPSViewTypeLogicNameDirty();
            }
            case 8: {
                return pSViewTypeLogicBase.isPSViewTypeNameDirty();
            }
            case 9: {
                return pSViewTypeLogicBase.isUpdateDateDirty();
            }
            case 10: {
                return pSViewTypeLogicBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSViewTypeLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSViewTypeLogicBase pSViewTypeLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSViewTypeLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSViewTypeLogicBase.getJSONValue((Object)pSViewTypeLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSViewTypeLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSViewTypeLogicBase.getJSONValue((Object)pSViewTypeLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSViewTypeLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSViewTypeLogicBase.getJSONValue((Object)pSViewTypeLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSViewTypeLogicBase.getPSViewLogicTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewlogictypeid", (Object)PSViewTypeLogicBase.getJSONValue((Object)pSViewTypeLogicBase.getPSViewLogicTypeId()), (boolean)false);
        }
        if (bl || pSViewTypeLogicBase.getPSViewLogicTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewlogictypename", (Object)PSViewTypeLogicBase.getJSONValue((Object)pSViewTypeLogicBase.getPSViewLogicTypeName()), (boolean)false);
        }
        if (bl || pSViewTypeLogicBase.getPSViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypeid", (Object)PSViewTypeLogicBase.getJSONValue((Object)pSViewTypeLogicBase.getPSViewTypeId()), (boolean)false);
        }
        if (bl || pSViewTypeLogicBase.getPSViewTypeLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypelogicid", (Object)PSViewTypeLogicBase.getJSONValue((Object)pSViewTypeLogicBase.getPSViewTypeLogicId()), (boolean)false);
        }
        if (bl || pSViewTypeLogicBase.getPSViewTypeLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypelogicname", (Object)PSViewTypeLogicBase.getJSONValue((Object)pSViewTypeLogicBase.getPSViewTypeLogicName()), (boolean)false);
        }
        if (bl || pSViewTypeLogicBase.getPSViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypename", (Object)PSViewTypeLogicBase.getJSONValue((Object)pSViewTypeLogicBase.getPSViewTypeName()), (boolean)false);
        }
        if (bl || pSViewTypeLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSViewTypeLogicBase.getJSONValue((Object)pSViewTypeLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSViewTypeLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSViewTypeLogicBase.getJSONValue((Object)pSViewTypeLogicBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSViewTypeLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSViewTypeLogicBase pSViewTypeLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSViewTypeLogicBase.getCreateDate() != null) {
            object = pSViewTypeLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewTypeLogicBase.getCreateMan() != null) {
            object = pSViewTypeLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeLogicBase.getMemo() != null) {
            object = pSViewTypeLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeLogicBase.getPSViewLogicTypeId() != null) {
            object = pSViewTypeLogicBase.getPSViewLogicTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWLOGICTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeLogicBase.getPSViewLogicTypeName() != null) {
            object = pSViewTypeLogicBase.getPSViewLogicTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWLOGICTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeLogicBase.getPSViewTypeId() != null) {
            object = pSViewTypeLogicBase.getPSViewTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeLogicBase.getPSViewTypeLogicId() != null) {
            object = pSViewTypeLogicBase.getPSViewTypeLogicId();
            xmlNode.setAttribute(FIELD_PSVIEWTYPELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeLogicBase.getPSViewTypeLogicName() != null) {
            object = pSViewTypeLogicBase.getPSViewTypeLogicName();
            xmlNode.setAttribute(FIELD_PSVIEWTYPELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeLogicBase.getPSViewTypeName() != null) {
            object = pSViewTypeLogicBase.getPSViewTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeLogicBase.getUpdateDate() != null) {
            object = pSViewTypeLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewTypeLogicBase.getUpdateMan() != null) {
            object = pSViewTypeLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSViewTypeLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSViewTypeLogicBase pSViewTypeLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSViewTypeLogicBase.isCreateDateDirty() && (bl || pSViewTypeLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSViewTypeLogicBase.getCreateDate());
        }
        if (pSViewTypeLogicBase.isCreateManDirty() && (bl || pSViewTypeLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSViewTypeLogicBase.getCreateMan());
        }
        if (pSViewTypeLogicBase.isMemoDirty() && (bl || pSViewTypeLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSViewTypeLogicBase.getMemo());
        }
        if (pSViewTypeLogicBase.isPSViewLogicTypeIdDirty() && (bl || pSViewTypeLogicBase.getPSViewLogicTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWLOGICTYPEID, (Object)pSViewTypeLogicBase.getPSViewLogicTypeId());
        }
        if (pSViewTypeLogicBase.isPSViewLogicTypeNameDirty() && (bl || pSViewTypeLogicBase.getPSViewLogicTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWLOGICTYPENAME, (Object)pSViewTypeLogicBase.getPSViewLogicTypeName());
        }
        if (pSViewTypeLogicBase.isPSViewTypeIdDirty() && (bl || pSViewTypeLogicBase.getPSViewTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPEID, (Object)pSViewTypeLogicBase.getPSViewTypeId());
        }
        if (pSViewTypeLogicBase.isPSViewTypeLogicIdDirty() && (bl || pSViewTypeLogicBase.getPSViewTypeLogicId() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPELOGICID, (Object)pSViewTypeLogicBase.getPSViewTypeLogicId());
        }
        if (pSViewTypeLogicBase.isPSViewTypeLogicNameDirty() && (bl || pSViewTypeLogicBase.getPSViewTypeLogicName() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPELOGICNAME, (Object)pSViewTypeLogicBase.getPSViewTypeLogicName());
        }
        if (pSViewTypeLogicBase.isPSViewTypeNameDirty() && (bl || pSViewTypeLogicBase.getPSViewTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPENAME, (Object)pSViewTypeLogicBase.getPSViewTypeName());
        }
        if (pSViewTypeLogicBase.isUpdateDateDirty() && (bl || pSViewTypeLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSViewTypeLogicBase.getUpdateDate());
        }
        if (pSViewTypeLogicBase.isUpdateManDirty() && (bl || pSViewTypeLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSViewTypeLogicBase.getUpdateMan());
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
        return PSViewTypeLogicBase.remove(this, n);
    }

    private static boolean remove(PSViewTypeLogicBase pSViewTypeLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSViewTypeLogicBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSViewTypeLogicBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSViewTypeLogicBase.resetMemo();
                return true;
            }
            case 3: {
                pSViewTypeLogicBase.resetPSViewLogicTypeId();
                return true;
            }
            case 4: {
                pSViewTypeLogicBase.resetPSViewLogicTypeName();
                return true;
            }
            case 5: {
                pSViewTypeLogicBase.resetPSViewTypeId();
                return true;
            }
            case 6: {
                pSViewTypeLogicBase.resetPSViewTypeLogicId();
                return true;
            }
            case 7: {
                pSViewTypeLogicBase.resetPSViewTypeLogicName();
                return true;
            }
            case 8: {
                pSViewTypeLogicBase.resetPSViewTypeName();
                return true;
            }
            case 9: {
                pSViewTypeLogicBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSViewTypeLogicBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewLogicType getPSViewLogicType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicType();
        }
        if (this.getPSViewLogicTypeId() == null) {
            return null;
        }
        Integer n = this.objPSViewLogicTypeLock;
        synchronized (n) {
            if (this.psviewlogictype != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewLogicTypeId(), (Object)this.psviewlogictype.getPSViewLogicTypeId()) != 0L) {
                this.psviewlogictype = null;
            }
            if (this.psviewlogictype == null) {
                PSViewLogicType pSViewLogicType = new PSViewLogicType();
                pSViewLogicType.setPSViewLogicTypeId(this.getPSViewLogicTypeId());
                PSViewLogicTypeService pSViewLogicTypeService = (PSViewLogicTypeService)ServiceGlobal.getService(PSViewLogicTypeService.class, (SessionFactory)this.getSessionFactory());
                pSViewLogicTypeService.autoGet(pSViewLogicType);
                this.psviewlogictype = pSViewLogicType;
            }
            return this.psviewlogictype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewType getPSViewType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewType();
        }
        if (this.getPSViewTypeId() == null) {
            return null;
        }
        Integer n = this.objPSViewTypeLock;
        synchronized (n) {
            if (this.psviewtype != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewTypeId(), (Object)this.psviewtype.getPSViewTypeId()) != 0L) {
                this.psviewtype = null;
            }
            if (this.psviewtype == null) {
                PSViewType pSViewType = new PSViewType();
                pSViewType.setPSViewTypeId(this.getPSViewTypeId());
                PSViewTypeService pSViewTypeService = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class, (SessionFactory)this.getSessionFactory());
                pSViewTypeService.autoGet(pSViewType);
                this.psviewtype = pSViewType;
            }
            return this.psviewtype;
        }
    }

    private PSViewTypeLogicBase getProxyEntity() {
        return this.proxyPSViewTypeLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSViewTypeLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSViewTypeLogicBase) {
            this.proxyPSViewTypeLogicBase = (PSViewTypeLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewTypeLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSVIEWLOGICTYPEID, 3);
        fieldIndexMap.put(FIELD_PSVIEWLOGICTYPENAME, 4);
        fieldIndexMap.put(FIELD_PSVIEWTYPEID, 5);
        fieldIndexMap.put(FIELD_PSVIEWTYPELOGICID, 6);
        fieldIndexMap.put(FIELD_PSVIEWTYPELOGICNAME, 7);
        fieldIndexMap.put(FIELD_PSVIEWTYPENAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

