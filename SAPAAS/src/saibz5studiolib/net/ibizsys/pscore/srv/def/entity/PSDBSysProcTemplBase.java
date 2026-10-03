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
package net.ibizsys.pscore.srv.def.entity;

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
import net.ibizsys.pscore.srv.config.service.PSDBTypeService;
import net.ibizsys.pscore.srv.def.entity.PSDBSysProcType;
import net.ibizsys.pscore.srv.def.service.PSDBSysProcTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBSysProcTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDBSysProcTemplBase.class);
    public static final String FIELD_CODETEMPL = "CODETEMPL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDBSYSPROCTEMPLID = "PSDBSYSPROCTEMPLID";
    public static final String FIELD_PSDBSYSPROCTEMPLNAME = "PSDBSYSPROCTEMPLNAME";
    public static final String FIELD_PSDBSYSPROCTYPEID = "PSDBSYSPROCTYPEID";
    public static final String FIELD_PSDBSYSPROCTYPENAME = "PSDBSYSPROCTYPENAME";
    public static final String FIELD_PSDBTYPEID = "PSDBTYPEID";
    public static final String FIELD_PSDBTYPENAME = "PSDBTYPENAME";
    public static final String FIELD_PUBOBJ = "PUBOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODETEMPL = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDBSYSPROCTEMPLID = 4;
    private static final int INDEX_PSDBSYSPROCTEMPLNAME = 5;
    private static final int INDEX_PSDBSYSPROCTYPEID = 6;
    private static final int INDEX_PSDBSYSPROCTYPENAME = 7;
    private static final int INDEX_PSDBTYPEID = 8;
    private static final int INDEX_PSDBTYPENAME = 9;
    private static final int INDEX_PUBOBJ = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDBSysProcTemplBase proxyPSDBSysProcTemplBase = null;
    private boolean codetemplDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdbsysproctemplidDirtyFlag = false;
    private boolean psdbsysproctemplnameDirtyFlag = false;
    private boolean psdbsysproctypeidDirtyFlag = false;
    private boolean psdbsysproctypenameDirtyFlag = false;
    private boolean psdbtypeidDirtyFlag = false;
    private boolean psdbtypenameDirtyFlag = false;
    private boolean pubobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codetempl")
    private String codetempl;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdbsysproctemplid")
    private String psdbsysproctemplid;
    @Column(name="psdbsysproctemplname")
    private String psdbsysproctemplname;
    @Column(name="psdbsysproctypeid")
    private String psdbsysproctypeid;
    @Column(name="psdbsysproctypename")
    private String psdbsysproctypename;
    @Column(name="psdbtypeid")
    private String psdbtypeid;
    @Column(name="psdbtypename")
    private String psdbtypename;
    @Column(name="pubobj")
    private String pubobj;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDBSysProcTypeLock = new Integer(1);
    private PSDBSysProcType psdbsysproctype = null;
    private Integer objPSDBTypeLock = new Integer(1);
    private PSDBType psdbtype = null;

    public void setCodeTempl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeTempl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codetempl = string;
        this.codetemplDirtyFlag = true;
    }

    public String getCodeTempl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeTempl();
        }
        return this.codetempl;
    }

    public boolean isCodeTemplDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeTemplDirty();
        }
        return this.codetemplDirtyFlag;
    }

    public void resetCodeTempl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeTempl();
            return;
        }
        this.codetemplDirtyFlag = false;
        this.codetempl = null;
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

    public void setPSDBSysProcTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBSysProcTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbsysproctemplid = string;
        this.psdbsysproctemplidDirtyFlag = true;
    }

    public String getPSDBSysProcTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBSysProcTemplId();
        }
        return this.psdbsysproctemplid;
    }

    public boolean isPSDBSysProcTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBSysProcTemplIdDirty();
        }
        return this.psdbsysproctemplidDirtyFlag;
    }

    public void resetPSDBSysProcTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBSysProcTemplId();
            return;
        }
        this.psdbsysproctemplidDirtyFlag = false;
        this.psdbsysproctemplid = null;
    }

    public void setPSDBSysProcTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBSysProcTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbsysproctemplname = string;
        this.psdbsysproctemplnameDirtyFlag = true;
    }

    public String getPSDBSysProcTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBSysProcTemplName();
        }
        return this.psdbsysproctemplname;
    }

    public boolean isPSDBSysProcTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBSysProcTemplNameDirty();
        }
        return this.psdbsysproctemplnameDirtyFlag;
    }

    public void resetPSDBSysProcTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBSysProcTemplName();
            return;
        }
        this.psdbsysproctemplnameDirtyFlag = false;
        this.psdbsysproctemplname = null;
    }

    public void setPSDBSysProcTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBSysProcTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbsysproctypeid = string;
        this.psdbsysproctypeidDirtyFlag = true;
    }

    public String getPSDBSysProcTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBSysProcTypeId();
        }
        return this.psdbsysproctypeid;
    }

    public boolean isPSDBSysProcTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBSysProcTypeIdDirty();
        }
        return this.psdbsysproctypeidDirtyFlag;
    }

    public void resetPSDBSysProcTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBSysProcTypeId();
            return;
        }
        this.psdbsysproctypeidDirtyFlag = false;
        this.psdbsysproctypeid = null;
    }

    public void setPSDBSysProcTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBSysProcTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbsysproctypename = string;
        this.psdbsysproctypenameDirtyFlag = true;
    }

    public String getPSDBSysProcTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBSysProcTypeName();
        }
        return this.psdbsysproctypename;
    }

    public boolean isPSDBSysProcTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBSysProcTypeNameDirty();
        }
        return this.psdbsysproctypenameDirtyFlag;
    }

    public void resetPSDBSysProcTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBSysProcTypeName();
            return;
        }
        this.psdbsysproctypenameDirtyFlag = false;
        this.psdbsysproctypename = null;
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
        PSDBSysProcTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDBSysProcTemplBase pSDBSysProcTemplBase) {
        pSDBSysProcTemplBase.resetCodeTempl();
        pSDBSysProcTemplBase.resetCreateDate();
        pSDBSysProcTemplBase.resetCreateMan();
        pSDBSysProcTemplBase.resetMemo();
        pSDBSysProcTemplBase.resetPSDBSysProcTemplId();
        pSDBSysProcTemplBase.resetPSDBSysProcTemplName();
        pSDBSysProcTemplBase.resetPSDBSysProcTypeId();
        pSDBSysProcTemplBase.resetPSDBSysProcTypeName();
        pSDBSysProcTemplBase.resetPSDBTypeId();
        pSDBSysProcTemplBase.resetPSDBTypeName();
        pSDBSysProcTemplBase.resetPubObj();
        pSDBSysProcTemplBase.resetUpdateDate();
        pSDBSysProcTemplBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeTemplDirty()) {
            hashMap.put(FIELD_CODETEMPL, this.getCodeTempl());
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
        if (!bl || this.isPSDBSysProcTemplIdDirty()) {
            hashMap.put(FIELD_PSDBSYSPROCTEMPLID, this.getPSDBSysProcTemplId());
        }
        if (!bl || this.isPSDBSysProcTemplNameDirty()) {
            hashMap.put(FIELD_PSDBSYSPROCTEMPLNAME, this.getPSDBSysProcTemplName());
        }
        if (!bl || this.isPSDBSysProcTypeIdDirty()) {
            hashMap.put(FIELD_PSDBSYSPROCTYPEID, this.getPSDBSysProcTypeId());
        }
        if (!bl || this.isPSDBSysProcTypeNameDirty()) {
            hashMap.put(FIELD_PSDBSYSPROCTYPENAME, this.getPSDBSysProcTypeName());
        }
        if (!bl || this.isPSDBTypeIdDirty()) {
            hashMap.put(FIELD_PSDBTYPEID, this.getPSDBTypeId());
        }
        if (!bl || this.isPSDBTypeNameDirty()) {
            hashMap.put(FIELD_PSDBTYPENAME, this.getPSDBTypeName());
        }
        if (!bl || this.isPubObjDirty()) {
            hashMap.put(FIELD_PUBOBJ, this.getPubObj());
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
        return PSDBSysProcTemplBase.get(this, n);
    }

    private static Object get(PSDBSysProcTemplBase pSDBSysProcTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBSysProcTemplBase.getCodeTempl();
            }
            case 1: {
                return pSDBSysProcTemplBase.getCreateDate();
            }
            case 2: {
                return pSDBSysProcTemplBase.getCreateMan();
            }
            case 3: {
                return pSDBSysProcTemplBase.getMemo();
            }
            case 4: {
                return pSDBSysProcTemplBase.getPSDBSysProcTemplId();
            }
            case 5: {
                return pSDBSysProcTemplBase.getPSDBSysProcTemplName();
            }
            case 6: {
                return pSDBSysProcTemplBase.getPSDBSysProcTypeId();
            }
            case 7: {
                return pSDBSysProcTemplBase.getPSDBSysProcTypeName();
            }
            case 8: {
                return pSDBSysProcTemplBase.getPSDBTypeId();
            }
            case 9: {
                return pSDBSysProcTemplBase.getPSDBTypeName();
            }
            case 10: {
                return pSDBSysProcTemplBase.getPubObj();
            }
            case 11: {
                return pSDBSysProcTemplBase.getUpdateDate();
            }
            case 12: {
                return pSDBSysProcTemplBase.getUpdateMan();
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
        PSDBSysProcTemplBase.set(this, n, object);
    }

    private static void set(PSDBSysProcTemplBase pSDBSysProcTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDBSysProcTemplBase.setCodeTempl(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDBSysProcTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDBSysProcTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDBSysProcTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDBSysProcTemplBase.setPSDBSysProcTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDBSysProcTemplBase.setPSDBSysProcTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDBSysProcTemplBase.setPSDBSysProcTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDBSysProcTemplBase.setPSDBSysProcTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDBSysProcTemplBase.setPSDBTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDBSysProcTemplBase.setPSDBTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDBSysProcTemplBase.setPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDBSysProcTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDBSysProcTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDBSysProcTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSDBSysProcTemplBase pSDBSysProcTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBSysProcTemplBase.getCodeTempl() == null;
            }
            case 1: {
                return pSDBSysProcTemplBase.getCreateDate() == null;
            }
            case 2: {
                return pSDBSysProcTemplBase.getCreateMan() == null;
            }
            case 3: {
                return pSDBSysProcTemplBase.getMemo() == null;
            }
            case 4: {
                return pSDBSysProcTemplBase.getPSDBSysProcTemplId() == null;
            }
            case 5: {
                return pSDBSysProcTemplBase.getPSDBSysProcTemplName() == null;
            }
            case 6: {
                return pSDBSysProcTemplBase.getPSDBSysProcTypeId() == null;
            }
            case 7: {
                return pSDBSysProcTemplBase.getPSDBSysProcTypeName() == null;
            }
            case 8: {
                return pSDBSysProcTemplBase.getPSDBTypeId() == null;
            }
            case 9: {
                return pSDBSysProcTemplBase.getPSDBTypeName() == null;
            }
            case 10: {
                return pSDBSysProcTemplBase.getPubObj() == null;
            }
            case 11: {
                return pSDBSysProcTemplBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDBSysProcTemplBase.getUpdateMan() == null;
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
        return PSDBSysProcTemplBase.contains(this, n);
    }

    private static boolean contains(PSDBSysProcTemplBase pSDBSysProcTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBSysProcTemplBase.isCodeTemplDirty();
            }
            case 1: {
                return pSDBSysProcTemplBase.isCreateDateDirty();
            }
            case 2: {
                return pSDBSysProcTemplBase.isCreateManDirty();
            }
            case 3: {
                return pSDBSysProcTemplBase.isMemoDirty();
            }
            case 4: {
                return pSDBSysProcTemplBase.isPSDBSysProcTemplIdDirty();
            }
            case 5: {
                return pSDBSysProcTemplBase.isPSDBSysProcTemplNameDirty();
            }
            case 6: {
                return pSDBSysProcTemplBase.isPSDBSysProcTypeIdDirty();
            }
            case 7: {
                return pSDBSysProcTemplBase.isPSDBSysProcTypeNameDirty();
            }
            case 8: {
                return pSDBSysProcTemplBase.isPSDBTypeIdDirty();
            }
            case 9: {
                return pSDBSysProcTemplBase.isPSDBTypeNameDirty();
            }
            case 10: {
                return pSDBSysProcTemplBase.isPubObjDirty();
            }
            case 11: {
                return pSDBSysProcTemplBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDBSysProcTemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDBSysProcTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDBSysProcTemplBase pSDBSysProcTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDBSysProcTemplBase.getCodeTempl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codetempl", (Object)PSDBSysProcTemplBase.getJSONValue((Object)pSDBSysProcTemplBase.getCodeTempl()), (boolean)false);
        }
        if (bl || pSDBSysProcTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDBSysProcTemplBase.getJSONValue((Object)pSDBSysProcTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDBSysProcTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDBSysProcTemplBase.getJSONValue((Object)pSDBSysProcTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDBSysProcTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDBSysProcTemplBase.getJSONValue((Object)pSDBSysProcTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSDBSysProcTemplBase.getPSDBSysProcTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbsysproctemplid", (Object)PSDBSysProcTemplBase.getJSONValue((Object)pSDBSysProcTemplBase.getPSDBSysProcTemplId()), (boolean)false);
        }
        if (bl || pSDBSysProcTemplBase.getPSDBSysProcTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbsysproctemplname", (Object)PSDBSysProcTemplBase.getJSONValue((Object)pSDBSysProcTemplBase.getPSDBSysProcTemplName()), (boolean)false);
        }
        if (bl || pSDBSysProcTemplBase.getPSDBSysProcTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbsysproctypeid", (Object)PSDBSysProcTemplBase.getJSONValue((Object)pSDBSysProcTemplBase.getPSDBSysProcTypeId()), (boolean)false);
        }
        if (bl || pSDBSysProcTemplBase.getPSDBSysProcTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbsysproctypename", (Object)PSDBSysProcTemplBase.getJSONValue((Object)pSDBSysProcTemplBase.getPSDBSysProcTypeName()), (boolean)false);
        }
        if (bl || pSDBSysProcTemplBase.getPSDBTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbtypeid", (Object)PSDBSysProcTemplBase.getJSONValue((Object)pSDBSysProcTemplBase.getPSDBTypeId()), (boolean)false);
        }
        if (bl || pSDBSysProcTemplBase.getPSDBTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbtypename", (Object)PSDBSysProcTemplBase.getJSONValue((Object)pSDBSysProcTemplBase.getPSDBTypeName()), (boolean)false);
        }
        if (bl || pSDBSysProcTemplBase.getPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubobj", (Object)PSDBSysProcTemplBase.getJSONValue((Object)pSDBSysProcTemplBase.getPubObj()), (boolean)false);
        }
        if (bl || pSDBSysProcTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDBSysProcTemplBase.getJSONValue((Object)pSDBSysProcTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDBSysProcTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDBSysProcTemplBase.getJSONValue((Object)pSDBSysProcTemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDBSysProcTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDBSysProcTemplBase pSDBSysProcTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDBSysProcTemplBase.getCodeTempl() != null) {
            object = pSDBSysProcTemplBase.getCodeTempl();
            xmlNode.setAttribute(FIELD_CODETEMPL, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTemplBase.getCreateDate() != null) {
            object = pSDBSysProcTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBSysProcTemplBase.getCreateMan() != null) {
            object = pSDBSysProcTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTemplBase.getMemo() != null) {
            object = pSDBSysProcTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTemplBase.getPSDBSysProcTemplId() != null) {
            object = pSDBSysProcTemplBase.getPSDBSysProcTemplId();
            xmlNode.setAttribute(FIELD_PSDBSYSPROCTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTemplBase.getPSDBSysProcTemplName() != null) {
            object = pSDBSysProcTemplBase.getPSDBSysProcTemplName();
            xmlNode.setAttribute(FIELD_PSDBSYSPROCTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTemplBase.getPSDBSysProcTypeId() != null) {
            object = pSDBSysProcTemplBase.getPSDBSysProcTypeId();
            xmlNode.setAttribute(FIELD_PSDBSYSPROCTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTemplBase.getPSDBSysProcTypeName() != null) {
            object = pSDBSysProcTemplBase.getPSDBSysProcTypeName();
            xmlNode.setAttribute(FIELD_PSDBSYSPROCTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTemplBase.getPSDBTypeId() != null) {
            object = pSDBSysProcTemplBase.getPSDBTypeId();
            xmlNode.setAttribute(FIELD_PSDBTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTemplBase.getPSDBTypeName() != null) {
            object = pSDBSysProcTemplBase.getPSDBTypeName();
            xmlNode.setAttribute(FIELD_PSDBTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTemplBase.getPubObj() != null) {
            object = pSDBSysProcTemplBase.getPubObj();
            xmlNode.setAttribute(FIELD_PUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTemplBase.getUpdateDate() != null) {
            object = pSDBSysProcTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBSysProcTemplBase.getUpdateMan() != null) {
            object = pSDBSysProcTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDBSysProcTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDBSysProcTemplBase pSDBSysProcTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDBSysProcTemplBase.isCodeTemplDirty() && (bl || pSDBSysProcTemplBase.getCodeTempl() != null)) {
            iDataObject.set(FIELD_CODETEMPL, (Object)pSDBSysProcTemplBase.getCodeTempl());
        }
        if (pSDBSysProcTemplBase.isCreateDateDirty() && (bl || pSDBSysProcTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDBSysProcTemplBase.getCreateDate());
        }
        if (pSDBSysProcTemplBase.isCreateManDirty() && (bl || pSDBSysProcTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDBSysProcTemplBase.getCreateMan());
        }
        if (pSDBSysProcTemplBase.isMemoDirty() && (bl || pSDBSysProcTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDBSysProcTemplBase.getMemo());
        }
        if (pSDBSysProcTemplBase.isPSDBSysProcTemplIdDirty() && (bl || pSDBSysProcTemplBase.getPSDBSysProcTemplId() != null)) {
            iDataObject.set(FIELD_PSDBSYSPROCTEMPLID, (Object)pSDBSysProcTemplBase.getPSDBSysProcTemplId());
        }
        if (pSDBSysProcTemplBase.isPSDBSysProcTemplNameDirty() && (bl || pSDBSysProcTemplBase.getPSDBSysProcTemplName() != null)) {
            iDataObject.set(FIELD_PSDBSYSPROCTEMPLNAME, (Object)pSDBSysProcTemplBase.getPSDBSysProcTemplName());
        }
        if (pSDBSysProcTemplBase.isPSDBSysProcTypeIdDirty() && (bl || pSDBSysProcTemplBase.getPSDBSysProcTypeId() != null)) {
            iDataObject.set(FIELD_PSDBSYSPROCTYPEID, (Object)pSDBSysProcTemplBase.getPSDBSysProcTypeId());
        }
        if (pSDBSysProcTemplBase.isPSDBSysProcTypeNameDirty() && (bl || pSDBSysProcTemplBase.getPSDBSysProcTypeName() != null)) {
            iDataObject.set(FIELD_PSDBSYSPROCTYPENAME, (Object)pSDBSysProcTemplBase.getPSDBSysProcTypeName());
        }
        if (pSDBSysProcTemplBase.isPSDBTypeIdDirty() && (bl || pSDBSysProcTemplBase.getPSDBTypeId() != null)) {
            iDataObject.set(FIELD_PSDBTYPEID, (Object)pSDBSysProcTemplBase.getPSDBTypeId());
        }
        if (pSDBSysProcTemplBase.isPSDBTypeNameDirty() && (bl || pSDBSysProcTemplBase.getPSDBTypeName() != null)) {
            iDataObject.set(FIELD_PSDBTYPENAME, (Object)pSDBSysProcTemplBase.getPSDBTypeName());
        }
        if (pSDBSysProcTemplBase.isPubObjDirty() && (bl || pSDBSysProcTemplBase.getPubObj() != null)) {
            iDataObject.set(FIELD_PUBOBJ, (Object)pSDBSysProcTemplBase.getPubObj());
        }
        if (pSDBSysProcTemplBase.isUpdateDateDirty() && (bl || pSDBSysProcTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDBSysProcTemplBase.getUpdateDate());
        }
        if (pSDBSysProcTemplBase.isUpdateManDirty() && (bl || pSDBSysProcTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDBSysProcTemplBase.getUpdateMan());
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
        return PSDBSysProcTemplBase.remove(this, n);
    }

    private static boolean remove(PSDBSysProcTemplBase pSDBSysProcTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDBSysProcTemplBase.resetCodeTempl();
                return true;
            }
            case 1: {
                pSDBSysProcTemplBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDBSysProcTemplBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDBSysProcTemplBase.resetMemo();
                return true;
            }
            case 4: {
                pSDBSysProcTemplBase.resetPSDBSysProcTemplId();
                return true;
            }
            case 5: {
                pSDBSysProcTemplBase.resetPSDBSysProcTemplName();
                return true;
            }
            case 6: {
                pSDBSysProcTemplBase.resetPSDBSysProcTypeId();
                return true;
            }
            case 7: {
                pSDBSysProcTemplBase.resetPSDBSysProcTypeName();
                return true;
            }
            case 8: {
                pSDBSysProcTemplBase.resetPSDBTypeId();
                return true;
            }
            case 9: {
                pSDBSysProcTemplBase.resetPSDBTypeName();
                return true;
            }
            case 10: {
                pSDBSysProcTemplBase.resetPubObj();
                return true;
            }
            case 11: {
                pSDBSysProcTemplBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDBSysProcTemplBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBSysProcType getPSDBSysProcType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBSysProcType();
        }
        if (this.getPSDBSysProcTypeId() == null) {
            return null;
        }
        Integer n = this.objPSDBSysProcTypeLock;
        synchronized (n) {
            if (this.psdbsysproctype != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBSysProcTypeId(), (Object)this.psdbsysproctype.getPSDBSysProcTypeId()) != 0L) {
                this.psdbsysproctype = null;
            }
            if (this.psdbsysproctype == null) {
                PSDBSysProcType pSDBSysProcType = new PSDBSysProcType();
                pSDBSysProcType.setPSDBSysProcTypeId(this.getPSDBSysProcTypeId());
                PSDBSysProcTypeService pSDBSysProcTypeService = (PSDBSysProcTypeService)ServiceGlobal.getService(PSDBSysProcTypeService.class, (SessionFactory)this.getSessionFactory());
                pSDBSysProcTypeService.autoGet(pSDBSysProcType);
                this.psdbsysproctype = pSDBSysProcType;
            }
            return this.psdbsysproctype;
        }
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

    private PSDBSysProcTemplBase getProxyEntity() {
        return this.proxyPSDBSysProcTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDBSysProcTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSDBSysProcTemplBase) {
            this.proxyPSDBSysProcTemplBase = (PSDBSysProcTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSDBSysProcTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODETEMPL, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDBSYSPROCTEMPLID, 4);
        fieldIndexMap.put(FIELD_PSDBSYSPROCTEMPLNAME, 5);
        fieldIndexMap.put(FIELD_PSDBSYSPROCTYPEID, 6);
        fieldIndexMap.put(FIELD_PSDBSYSPROCTYPENAME, 7);
        fieldIndexMap.put(FIELD_PSDBTYPEID, 8);
        fieldIndexMap.put(FIELD_PSDBTYPENAME, 9);
        fieldIndexMap.put(FIELD_PUBOBJ, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

