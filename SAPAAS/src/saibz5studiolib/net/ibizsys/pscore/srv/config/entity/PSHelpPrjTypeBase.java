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
import net.ibizsys.pscore.srv.config.entity.PSHelpPrjTempl;
import net.ibizsys.pscore.srv.config.service.PSHelpPrjTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpPrjTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSHelpPrjTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PRJOBJ = "PRJOBJ";
    public static final String FIELD_PSHELPPRJTEMPLID = "PSHELPPRJTEMPLID";
    public static final String FIELD_PSHELPPRJTEMPLNAME = "PSHELPPRJTEMPLNAME";
    public static final String FIELD_PSHELPPRJTYPEID = "PSHELPPRJTYPEID";
    public static final String FIELD_PSHELPPRJTYPENAME = "PSHELPPRJTYPENAME";
    public static final String FIELD_PUBOBJ = "PUBOBJ";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PRJOBJ = 3;
    private static final int INDEX_PSHELPPRJTEMPLID = 4;
    private static final int INDEX_PSHELPPRJTEMPLNAME = 5;
    private static final int INDEX_PSHELPPRJTYPEID = 6;
    private static final int INDEX_PSHELPPRJTYPENAME = 7;
    private static final int INDEX_PUBOBJ = 8;
    private static final int INDEX_TYPEOBJ = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSHelpPrjTypeBase proxyPSHelpPrjTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean prjobjDirtyFlag = false;
    private boolean pshelpprjtemplidDirtyFlag = false;
    private boolean pshelpprjtemplnameDirtyFlag = false;
    private boolean pshelpprjtypeidDirtyFlag = false;
    private boolean pshelpprjtypenameDirtyFlag = false;
    private boolean pubobjDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="prjobj")
    private String prjobj;
    @Column(name="pshelpprjtemplid")
    private String pshelpprjtemplid;
    @Column(name="pshelpprjtemplname")
    private String pshelpprjtemplname;
    @Column(name="pshelpprjtypeid")
    private String pshelpprjtypeid;
    @Column(name="pshelpprjtypename")
    private String pshelpprjtypename;
    @Column(name="pubobj")
    private String pubobj;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSHelpPrjTemplLock = new Integer(1);
    private PSHelpPrjTempl pshelpprjtempl = null;

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

    public void setPrjObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrjObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.prjobj = string;
        this.prjobjDirtyFlag = true;
    }

    public String getPrjObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrjObj();
        }
        return this.prjobj;
    }

    public boolean isPrjObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrjObjDirty();
        }
        return this.prjobjDirtyFlag;
    }

    public void resetPrjObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrjObj();
            return;
        }
        this.prjobjDirtyFlag = false;
        this.prjobj = null;
    }

    public void setPSHelpPrjTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpPrjTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpprjtemplid = string;
        this.pshelpprjtemplidDirtyFlag = true;
    }

    public String getPSHelpPrjTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpPrjTemplId();
        }
        return this.pshelpprjtemplid;
    }

    public boolean isPSHelpPrjTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpPrjTemplIdDirty();
        }
        return this.pshelpprjtemplidDirtyFlag;
    }

    public void resetPSHelpPrjTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpPrjTemplId();
            return;
        }
        this.pshelpprjtemplidDirtyFlag = false;
        this.pshelpprjtemplid = null;
    }

    public void setPSHelpPrjTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpPrjTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpprjtemplname = string;
        this.pshelpprjtemplnameDirtyFlag = true;
    }

    public String getPSHelpPrjTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpPrjTemplName();
        }
        return this.pshelpprjtemplname;
    }

    public boolean isPSHelpPrjTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpPrjTemplNameDirty();
        }
        return this.pshelpprjtemplnameDirtyFlag;
    }

    public void resetPSHelpPrjTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpPrjTemplName();
            return;
        }
        this.pshelpprjtemplnameDirtyFlag = false;
        this.pshelpprjtemplname = null;
    }

    public void setPSHelpPrjTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpPrjTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpprjtypeid = string;
        this.pshelpprjtypeidDirtyFlag = true;
    }

    public String getPSHelpPrjTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpPrjTypeId();
        }
        return this.pshelpprjtypeid;
    }

    public boolean isPSHelpPrjTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpPrjTypeIdDirty();
        }
        return this.pshelpprjtypeidDirtyFlag;
    }

    public void resetPSHelpPrjTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpPrjTypeId();
            return;
        }
        this.pshelpprjtypeidDirtyFlag = false;
        this.pshelpprjtypeid = null;
    }

    public void setPSHelpPrjTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSHelpPrjTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pshelpprjtypename = string;
        this.pshelpprjtypenameDirtyFlag = true;
    }

    public String getPSHelpPrjTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpPrjTypeName();
        }
        return this.pshelpprjtypename;
    }

    public boolean isPSHelpPrjTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSHelpPrjTypeNameDirty();
        }
        return this.pshelpprjtypenameDirtyFlag;
    }

    public void resetPSHelpPrjTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSHelpPrjTypeName();
            return;
        }
        this.pshelpprjtypenameDirtyFlag = false;
        this.pshelpprjtypename = null;
    }

    public void setPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pubobj = string;
        this.pubobjDirtyFlag = true;
    }

    public String getPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubObj();
        }
        return this.pubobj;
    }

    public boolean isPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubObjDirty();
        }
        return this.pubobjDirtyFlag;
    }

    public void resetPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubObj();
            return;
        }
        this.pubobjDirtyFlag = false;
        this.pubobj = null;
    }

    public void setTypeObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeobj = string;
        this.typeobjDirtyFlag = true;
    }

    public String getTypeObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeObj();
        }
        return this.typeobj;
    }

    public boolean isTypeObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeObjDirty();
        }
        return this.typeobjDirtyFlag;
    }

    public void resetTypeObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeObj();
            return;
        }
        this.typeobjDirtyFlag = false;
        this.typeobj = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSHelpPrjTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSHelpPrjTypeBase pSHelpPrjTypeBase) {
        pSHelpPrjTypeBase.resetCreateDate();
        pSHelpPrjTypeBase.resetCreateMan();
        pSHelpPrjTypeBase.resetMemo();
        pSHelpPrjTypeBase.resetPrjObj();
        pSHelpPrjTypeBase.resetPSHelpPrjTemplId();
        pSHelpPrjTypeBase.resetPSHelpPrjTemplName();
        pSHelpPrjTypeBase.resetPSHelpPrjTypeId();
        pSHelpPrjTypeBase.resetPSHelpPrjTypeName();
        pSHelpPrjTypeBase.resetPubObj();
        pSHelpPrjTypeBase.resetTypeObj();
        pSHelpPrjTypeBase.resetUpdateDate();
        pSHelpPrjTypeBase.resetUpdateMan();
        pSHelpPrjTypeBase.resetValidFlag();
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
        if (!bl || this.isPrjObjDirty()) {
            hashMap.put(FIELD_PRJOBJ, this.getPrjObj());
        }
        if (!bl || this.isPSHelpPrjTemplIdDirty()) {
            hashMap.put(FIELD_PSHELPPRJTEMPLID, this.getPSHelpPrjTemplId());
        }
        if (!bl || this.isPSHelpPrjTemplNameDirty()) {
            hashMap.put(FIELD_PSHELPPRJTEMPLNAME, this.getPSHelpPrjTemplName());
        }
        if (!bl || this.isPSHelpPrjTypeIdDirty()) {
            hashMap.put(FIELD_PSHELPPRJTYPEID, this.getPSHelpPrjTypeId());
        }
        if (!bl || this.isPSHelpPrjTypeNameDirty()) {
            hashMap.put(FIELD_PSHELPPRJTYPENAME, this.getPSHelpPrjTypeName());
        }
        if (!bl || this.isPubObjDirty()) {
            hashMap.put(FIELD_PUBOBJ, this.getPubObj());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSHelpPrjTypeBase.get(this, n);
    }

    private static Object get(PSHelpPrjTypeBase pSHelpPrjTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpPrjTypeBase.getCreateDate();
            }
            case 1: {
                return pSHelpPrjTypeBase.getCreateMan();
            }
            case 2: {
                return pSHelpPrjTypeBase.getMemo();
            }
            case 3: {
                return pSHelpPrjTypeBase.getPrjObj();
            }
            case 4: {
                return pSHelpPrjTypeBase.getPSHelpPrjTemplId();
            }
            case 5: {
                return pSHelpPrjTypeBase.getPSHelpPrjTemplName();
            }
            case 6: {
                return pSHelpPrjTypeBase.getPSHelpPrjTypeId();
            }
            case 7: {
                return pSHelpPrjTypeBase.getPSHelpPrjTypeName();
            }
            case 8: {
                return pSHelpPrjTypeBase.getPubObj();
            }
            case 9: {
                return pSHelpPrjTypeBase.getTypeObj();
            }
            case 10: {
                return pSHelpPrjTypeBase.getUpdateDate();
            }
            case 11: {
                return pSHelpPrjTypeBase.getUpdateMan();
            }
            case 12: {
                return pSHelpPrjTypeBase.getValidFlag();
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
        PSHelpPrjTypeBase.set(this, n, object);
    }

    private static void set(PSHelpPrjTypeBase pSHelpPrjTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSHelpPrjTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSHelpPrjTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSHelpPrjTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSHelpPrjTypeBase.setPrjObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSHelpPrjTypeBase.setPSHelpPrjTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSHelpPrjTypeBase.setPSHelpPrjTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSHelpPrjTypeBase.setPSHelpPrjTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSHelpPrjTypeBase.setPSHelpPrjTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSHelpPrjTypeBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSHelpPrjTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSHelpPrjTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSHelpPrjTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSHelpPrjTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSHelpPrjTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSHelpPrjTypeBase pSHelpPrjTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpPrjTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSHelpPrjTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSHelpPrjTypeBase.getMemo() == null;
            }
            case 3: {
                return pSHelpPrjTypeBase.getPrjObj() == null;
            }
            case 4: {
                return pSHelpPrjTypeBase.getPSHelpPrjTemplId() == null;
            }
            case 5: {
                return pSHelpPrjTypeBase.getPSHelpPrjTemplName() == null;
            }
            case 6: {
                return pSHelpPrjTypeBase.getPSHelpPrjTypeId() == null;
            }
            case 7: {
                return pSHelpPrjTypeBase.getPSHelpPrjTypeName() == null;
            }
            case 8: {
                return pSHelpPrjTypeBase.getPubObj() == null;
            }
            case 9: {
                return pSHelpPrjTypeBase.getTypeObj() == null;
            }
            case 10: {
                return pSHelpPrjTypeBase.getUpdateDate() == null;
            }
            case 11: {
                return pSHelpPrjTypeBase.getUpdateMan() == null;
            }
            case 12: {
                return pSHelpPrjTypeBase.getValidFlag() == null;
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
        return PSHelpPrjTypeBase.contains(this, n);
    }

    private static boolean contains(PSHelpPrjTypeBase pSHelpPrjTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSHelpPrjTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSHelpPrjTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSHelpPrjTypeBase.isMemoDirty();
            }
            case 3: {
                return pSHelpPrjTypeBase.isPrjObjDirty();
            }
            case 4: {
                return pSHelpPrjTypeBase.isPSHelpPrjTemplIdDirty();
            }
            case 5: {
                return pSHelpPrjTypeBase.isPSHelpPrjTemplNameDirty();
            }
            case 6: {
                return pSHelpPrjTypeBase.isPSHelpPrjTypeIdDirty();
            }
            case 7: {
                return pSHelpPrjTypeBase.isPSHelpPrjTypeNameDirty();
            }
            case 8: {
                return pSHelpPrjTypeBase.isPubObjDirty();
            }
            case 9: {
                return pSHelpPrjTypeBase.isTypeObjDirty();
            }
            case 10: {
                return pSHelpPrjTypeBase.isUpdateDateDirty();
            }
            case 11: {
                return pSHelpPrjTypeBase.isUpdateManDirty();
            }
            case 12: {
                return pSHelpPrjTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSHelpPrjTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSHelpPrjTypeBase pSHelpPrjTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSHelpPrjTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSHelpPrjTypeBase.getJSONValue((Object)pSHelpPrjTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSHelpPrjTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSHelpPrjTypeBase.getJSONValue((Object)pSHelpPrjTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSHelpPrjTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSHelpPrjTypeBase.getJSONValue((Object)pSHelpPrjTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSHelpPrjTypeBase.getPrjObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"prjobj", (Object)PSHelpPrjTypeBase.getJSONValue((Object)pSHelpPrjTypeBase.getPrjObj()), (boolean)false);
        }
        if (bl || pSHelpPrjTypeBase.getPSHelpPrjTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpprjtemplid", (Object)PSHelpPrjTypeBase.getJSONValue((Object)pSHelpPrjTypeBase.getPSHelpPrjTemplId()), (boolean)false);
        }
        if (bl || pSHelpPrjTypeBase.getPSHelpPrjTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpprjtemplname", (Object)PSHelpPrjTypeBase.getJSONValue((Object)pSHelpPrjTypeBase.getPSHelpPrjTemplName()), (boolean)false);
        }
        if (bl || pSHelpPrjTypeBase.getPSHelpPrjTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpprjtypeid", (Object)PSHelpPrjTypeBase.getJSONValue((Object)pSHelpPrjTypeBase.getPSHelpPrjTypeId()), (boolean)false);
        }
        if (bl || pSHelpPrjTypeBase.getPSHelpPrjTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pshelpprjtypename", (Object)PSHelpPrjTypeBase.getJSONValue((Object)pSHelpPrjTypeBase.getPSHelpPrjTypeName()), (boolean)false);
        }
        if (bl || pSHelpPrjTypeBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSHelpPrjTypeBase.getJSONValue((Object)pSHelpPrjTypeBase.getPubObj()), (boolean)false);
        }
        if (bl || pSHelpPrjTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSHelpPrjTypeBase.getJSONValue((Object)pSHelpPrjTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSHelpPrjTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSHelpPrjTypeBase.getJSONValue((Object)pSHelpPrjTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSHelpPrjTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSHelpPrjTypeBase.getJSONValue((Object)pSHelpPrjTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSHelpPrjTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSHelpPrjTypeBase.getJSONValue((Object)pSHelpPrjTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSHelpPrjTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSHelpPrjTypeBase pSHelpPrjTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSHelpPrjTypeBase.getCreateDate() != null) {
            object = pSHelpPrjTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpPrjTypeBase.getCreateMan() != null) {
            object = pSHelpPrjTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTypeBase.getMemo() != null) {
            object = pSHelpPrjTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTypeBase.getPrjObj() != null) {
            object = pSHelpPrjTypeBase.getPrjObj();
            xmlNode.setAttribute(FIELD_PRJOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTypeBase.getPSHelpPrjTemplId() != null) {
            object = pSHelpPrjTypeBase.getPSHelpPrjTemplId();
            xmlNode.setAttribute(FIELD_PSHELPPRJTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTypeBase.getPSHelpPrjTemplName() != null) {
            object = pSHelpPrjTypeBase.getPSHelpPrjTemplName();
            xmlNode.setAttribute(FIELD_PSHELPPRJTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTypeBase.getPSHelpPrjTypeId() != null) {
            object = pSHelpPrjTypeBase.getPSHelpPrjTypeId();
            xmlNode.setAttribute(FIELD_PSHELPPRJTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTypeBase.getPSHelpPrjTypeName() != null) {
            object = pSHelpPrjTypeBase.getPSHelpPrjTypeName();
            xmlNode.setAttribute(FIELD_PSHELPPRJTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTypeBase.getPubObj() != null) {
            object = pSHelpPrjTypeBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTypeBase.getTypeObj() != null) {
            object = pSHelpPrjTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTypeBase.getUpdateDate() != null) {
            object = pSHelpPrjTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSHelpPrjTypeBase.getUpdateMan() != null) {
            object = pSHelpPrjTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSHelpPrjTypeBase.getValidFlag() != null) {
            object = pSHelpPrjTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSHelpPrjTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSHelpPrjTypeBase pSHelpPrjTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSHelpPrjTypeBase.isCreateDateDirty() && (bl || pSHelpPrjTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSHelpPrjTypeBase.getCreateDate());
        }
        if (pSHelpPrjTypeBase.isCreateManDirty() && (bl || pSHelpPrjTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSHelpPrjTypeBase.getCreateMan());
        }
        if (pSHelpPrjTypeBase.isMemoDirty() && (bl || pSHelpPrjTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSHelpPrjTypeBase.getMemo());
        }
        if (pSHelpPrjTypeBase.isPrjObjDirty() && (bl || pSHelpPrjTypeBase.getPrjObj() != null)) {
            iDataObject.set(FIELD_PRJOBJ, (Object)pSHelpPrjTypeBase.getPrjObj());
        }
        if (pSHelpPrjTypeBase.isPSHelpPrjTemplIdDirty() && (bl || pSHelpPrjTypeBase.getPSHelpPrjTemplId() != null)) {
            iDataObject.set(FIELD_PSHELPPRJTEMPLID, (Object)pSHelpPrjTypeBase.getPSHelpPrjTemplId());
        }
        if (pSHelpPrjTypeBase.isPSHelpPrjTemplNameDirty() && (bl || pSHelpPrjTypeBase.getPSHelpPrjTemplName() != null)) {
            iDataObject.set(FIELD_PSHELPPRJTEMPLNAME, (Object)pSHelpPrjTypeBase.getPSHelpPrjTemplName());
        }
        if (pSHelpPrjTypeBase.isPSHelpPrjTypeIdDirty() && (bl || pSHelpPrjTypeBase.getPSHelpPrjTypeId() != null)) {
            iDataObject.set(FIELD_PSHELPPRJTYPEID, (Object)pSHelpPrjTypeBase.getPSHelpPrjTypeId());
        }
        if (pSHelpPrjTypeBase.isPSHelpPrjTypeNameDirty() && (bl || pSHelpPrjTypeBase.getPSHelpPrjTypeName() != null)) {
            iDataObject.set(FIELD_PSHELPPRJTYPENAME, (Object)pSHelpPrjTypeBase.getPSHelpPrjTypeName());
        }
        if (pSHelpPrjTypeBase.isPubObjDirty() && (bl || pSHelpPrjTypeBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSHelpPrjTypeBase.getPubObj());
        }
        if (pSHelpPrjTypeBase.isTypeObjDirty() && (bl || pSHelpPrjTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSHelpPrjTypeBase.getTypeObj());
        }
        if (pSHelpPrjTypeBase.isUpdateDateDirty() && (bl || pSHelpPrjTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSHelpPrjTypeBase.getUpdateDate());
        }
        if (pSHelpPrjTypeBase.isUpdateManDirty() && (bl || pSHelpPrjTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSHelpPrjTypeBase.getUpdateMan());
        }
        if (pSHelpPrjTypeBase.isValidFlagDirty() && (bl || pSHelpPrjTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSHelpPrjTypeBase.getValidFlag());
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
        return PSHelpPrjTypeBase.remove(this, n);
    }

    private static boolean remove(PSHelpPrjTypeBase pSHelpPrjTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSHelpPrjTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSHelpPrjTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSHelpPrjTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSHelpPrjTypeBase.resetPrjObj();
                return true;
            }
            case 4: {
                pSHelpPrjTypeBase.resetPSHelpPrjTemplId();
                return true;
            }
            case 5: {
                pSHelpPrjTypeBase.resetPSHelpPrjTemplName();
                return true;
            }
            case 6: {
                pSHelpPrjTypeBase.resetPSHelpPrjTypeId();
                return true;
            }
            case 7: {
                pSHelpPrjTypeBase.resetPSHelpPrjTypeName();
                return true;
            }
            case 8: {
                pSHelpPrjTypeBase.resetPubObj();
                return true;
            }
            case 9: {
                pSHelpPrjTypeBase.resetTypeObj();
                return true;
            }
            case 10: {
                pSHelpPrjTypeBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSHelpPrjTypeBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSHelpPrjTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSHelpPrjTempl getPSHelpPrjTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSHelpPrjTempl();
        }
        if (this.getPSHelpPrjTemplId() == null) {
            return null;
        }
        Integer n = this.objPSHelpPrjTemplLock;
        synchronized (n) {
            if (this.pshelpprjtempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSHelpPrjTemplId(), (Object)this.pshelpprjtempl.getPSHelpPrjTemplId()) != 0L) {
                this.pshelpprjtempl = null;
            }
            if (this.pshelpprjtempl == null) {
                PSHelpPrjTempl pSHelpPrjTempl = new PSHelpPrjTempl();
                pSHelpPrjTempl.setPSHelpPrjTemplId(this.getPSHelpPrjTemplId());
                PSHelpPrjTemplService pSHelpPrjTemplService = (PSHelpPrjTemplService)ServiceGlobal.getService(PSHelpPrjTemplService.class, (SessionFactory)this.getSessionFactory());
                pSHelpPrjTemplService.autoGet(pSHelpPrjTempl);
                this.pshelpprjtempl = pSHelpPrjTempl;
            }
            return this.pshelpprjtempl;
        }
    }

    private PSHelpPrjTypeBase getProxyEntity() {
        return this.proxyPSHelpPrjTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSHelpPrjTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSHelpPrjTypeBase) {
            this.proxyPSHelpPrjTypeBase = (PSHelpPrjTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSHelpPrjTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PRJOBJ, 3);
        fieldIndexMap.put(FIELD_PSHELPPRJTEMPLID, 4);
        fieldIndexMap.put(FIELD_PSHELPPRJTEMPLNAME, 5);
        fieldIndexMap.put(FIELD_PSHELPPRJTYPEID, 6);
        fieldIndexMap.put(FIELD_PSHELPPRJTYPENAME, 7);
        fieldIndexMap.put(FIELD_PUBOBJ, 8);
        fieldIndexMap.put(FIELD_TYPEOBJ, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

