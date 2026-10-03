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
import net.ibizsys.pscore.srv.config.entity.PSSFCodeType;
import net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFCodeTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFCodeTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSFCODETEMPLID = "PSSFCODETEMPLID";
    public static final String FIELD_PSSFCODETEMPLNAME = "PSSFCODETEMPLNAME";
    public static final String FIELD_PSSFCODETYPEID = "PSSFCODETYPEID";
    public static final String FIELD_PSSFCODETYPENAME = "PSSFCODETYPENAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_TEMPLDESC = "TEMPLDESC";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGICNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSSFCODETEMPLID = 4;
    private static final int INDEX_PSSFCODETEMPLNAME = 5;
    private static final int INDEX_PSSFCODETYPEID = 6;
    private static final int INDEX_PSSFCODETYPENAME = 7;
    private static final int INDEX_PSSFSTYLEID = 8;
    private static final int INDEX_TEMPLCODE = 9;
    private static final int INDEX_TEMPLCODE2 = 10;
    private static final int INDEX_TEMPLDESC = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_VALIDFLAG = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFCodeTemplBase proxyPSSFCodeTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssfcodetemplidDirtyFlag = false;
    private boolean pssfcodetemplnameDirtyFlag = false;
    private boolean pssfcodetypeidDirtyFlag = false;
    private boolean pssfcodetypenameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean templdescDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="pssfcodetemplid")
    private String pssfcodetemplid;
    @Column(name="pssfcodetemplname")
    private String pssfcodetemplname;
    @Column(name="pssfcodetypeid")
    private String pssfcodetypeid;
    @Column(name="pssfcodetypename")
    private String pssfcodetypename;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="templcode")
    private String templcode;
    @Column(name="templcode2")
    private String templcode2;
    @Column(name="templdesc")
    private String templdesc;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSFCodeTypeLock = new Integer(1);
    private PSSFCodeType pssfcodetype = null;

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

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setPSSFCodeTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFCodeTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfcodetemplid = string;
        this.pssfcodetemplidDirtyFlag = true;
    }

    public String getPSSFCodeTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeTemplId();
        }
        return this.pssfcodetemplid;
    }

    public boolean isPSSFCodeTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFCodeTemplIdDirty();
        }
        return this.pssfcodetemplidDirtyFlag;
    }

    public void resetPSSFCodeTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFCodeTemplId();
            return;
        }
        this.pssfcodetemplidDirtyFlag = false;
        this.pssfcodetemplid = null;
    }

    public void setPSSFCodeTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFCodeTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfcodetemplname = string;
        this.pssfcodetemplnameDirtyFlag = true;
    }

    public String getPSSFCodeTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeTemplName();
        }
        return this.pssfcodetemplname;
    }

    public boolean isPSSFCodeTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFCodeTemplNameDirty();
        }
        return this.pssfcodetemplnameDirtyFlag;
    }

    public void resetPSSFCodeTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFCodeTemplName();
            return;
        }
        this.pssfcodetemplnameDirtyFlag = false;
        this.pssfcodetemplname = null;
    }

    public void setPSSFCodeTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFCodeTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfcodetypeid = string;
        this.pssfcodetypeidDirtyFlag = true;
    }

    public String getPSSFCodeTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeTypeId();
        }
        return this.pssfcodetypeid;
    }

    public boolean isPSSFCodeTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFCodeTypeIdDirty();
        }
        return this.pssfcodetypeidDirtyFlag;
    }

    public void resetPSSFCodeTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFCodeTypeId();
            return;
        }
        this.pssfcodetypeidDirtyFlag = false;
        this.pssfcodetypeid = null;
    }

    public void setPSSFCodeTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFCodeTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfcodetypename = string;
        this.pssfcodetypenameDirtyFlag = true;
    }

    public String getPSSFCodeTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeTypeName();
        }
        return this.pssfcodetypename;
    }

    public boolean isPSSFCodeTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFCodeTypeNameDirty();
        }
        return this.pssfcodetypenameDirtyFlag;
    }

    public void resetPSSFCodeTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFCodeTypeName();
            return;
        }
        this.pssfcodetypenameDirtyFlag = false;
        this.pssfcodetypename = null;
    }

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
    }

    public void setTemplCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode = string;
        this.templcodeDirtyFlag = true;
    }

    public String getTemplCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode();
        }
        return this.templcode;
    }

    public boolean isTemplCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeDirty();
        }
        return this.templcodeDirtyFlag;
    }

    public void resetTemplCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode();
            return;
        }
        this.templcodeDirtyFlag = false;
        this.templcode = null;
    }

    public void setTemplCode2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode2 = string;
        this.templcode2DirtyFlag = true;
    }

    public String getTemplCode2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode2();
        }
        return this.templcode2;
    }

    public boolean isTemplCode2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode2Dirty();
        }
        return this.templcode2DirtyFlag;
    }

    public void resetTemplCode2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode2();
            return;
        }
        this.templcode2DirtyFlag = false;
        this.templcode2 = null;
    }

    public void setTemplDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templdesc = string;
        this.templdescDirtyFlag = true;
    }

    public String getTemplDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplDesc();
        }
        return this.templdesc;
    }

    public boolean isTemplDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplDescDirty();
        }
        return this.templdescDirtyFlag;
    }

    public void resetTemplDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplDesc();
            return;
        }
        this.templdescDirtyFlag = false;
        this.templdesc = null;
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
        PSSFCodeTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFCodeTemplBase pSSFCodeTemplBase) {
        pSSFCodeTemplBase.resetCreateDate();
        pSSFCodeTemplBase.resetCreateMan();
        pSSFCodeTemplBase.resetLogicName();
        pSSFCodeTemplBase.resetMemo();
        pSSFCodeTemplBase.resetPSSFCodeTemplId();
        pSSFCodeTemplBase.resetPSSFCodeTemplName();
        pSSFCodeTemplBase.resetPSSFCodeTypeId();
        pSSFCodeTemplBase.resetPSSFCodeTypeName();
        pSSFCodeTemplBase.resetPSSFStyleId();
        pSSFCodeTemplBase.resetTemplCode();
        pSSFCodeTemplBase.resetTemplCode2();
        pSSFCodeTemplBase.resetTemplDesc();
        pSSFCodeTemplBase.resetUpdateDate();
        pSSFCodeTemplBase.resetUpdateMan();
        pSSFCodeTemplBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSFCodeTemplIdDirty()) {
            hashMap.put(FIELD_PSSFCODETEMPLID, this.getPSSFCodeTemplId());
        }
        if (!bl || this.isPSSFCodeTemplNameDirty()) {
            hashMap.put(FIELD_PSSFCODETEMPLNAME, this.getPSSFCodeTemplName());
        }
        if (!bl || this.isPSSFCodeTypeIdDirty()) {
            hashMap.put(FIELD_PSSFCODETYPEID, this.getPSSFCodeTypeId());
        }
        if (!bl || this.isPSSFCodeTypeNameDirty()) {
            hashMap.put(FIELD_PSSFCODETYPENAME, this.getPSSFCodeTypeName());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isTemplCodeDirty()) {
            hashMap.put(FIELD_TEMPLCODE, this.getTemplCode());
        }
        if (!bl || this.isTemplCode2Dirty()) {
            hashMap.put(FIELD_TEMPLCODE2, this.getTemplCode2());
        }
        if (!bl || this.isTemplDescDirty()) {
            hashMap.put(FIELD_TEMPLDESC, this.getTemplDesc());
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
        return PSSFCodeTemplBase.get(this, n);
    }

    private static Object get(PSSFCodeTemplBase pSSFCodeTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFCodeTemplBase.getCreateDate();
            }
            case 1: {
                return pSSFCodeTemplBase.getCreateMan();
            }
            case 2: {
                return pSSFCodeTemplBase.getLogicName();
            }
            case 3: {
                return pSSFCodeTemplBase.getMemo();
            }
            case 4: {
                return pSSFCodeTemplBase.getPSSFCodeTemplId();
            }
            case 5: {
                return pSSFCodeTemplBase.getPSSFCodeTemplName();
            }
            case 6: {
                return pSSFCodeTemplBase.getPSSFCodeTypeId();
            }
            case 7: {
                return pSSFCodeTemplBase.getPSSFCodeTypeName();
            }
            case 8: {
                return pSSFCodeTemplBase.getPSSFStyleId();
            }
            case 9: {
                return pSSFCodeTemplBase.getTemplCode();
            }
            case 10: {
                return pSSFCodeTemplBase.getTemplCode2();
            }
            case 11: {
                return pSSFCodeTemplBase.getTemplDesc();
            }
            case 12: {
                return pSSFCodeTemplBase.getUpdateDate();
            }
            case 13: {
                return pSSFCodeTemplBase.getUpdateMan();
            }
            case 14: {
                return pSSFCodeTemplBase.getValidFlag();
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
        PSSFCodeTemplBase.set(this, n, object);
    }

    private static void set(PSSFCodeTemplBase pSSFCodeTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFCodeTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFCodeTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFCodeTemplBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFCodeTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFCodeTemplBase.setPSSFCodeTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFCodeTemplBase.setPSSFCodeTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFCodeTemplBase.setPSSFCodeTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFCodeTemplBase.setPSSFCodeTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFCodeTemplBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFCodeTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFCodeTemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFCodeTemplBase.setTemplDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFCodeTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSFCodeTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSFCodeTemplBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSFCodeTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSSFCodeTemplBase pSSFCodeTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFCodeTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSSFCodeTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSSFCodeTemplBase.getLogicName() == null;
            }
            case 3: {
                return pSSFCodeTemplBase.getMemo() == null;
            }
            case 4: {
                return pSSFCodeTemplBase.getPSSFCodeTemplId() == null;
            }
            case 5: {
                return pSSFCodeTemplBase.getPSSFCodeTemplName() == null;
            }
            case 6: {
                return pSSFCodeTemplBase.getPSSFCodeTypeId() == null;
            }
            case 7: {
                return pSSFCodeTemplBase.getPSSFCodeTypeName() == null;
            }
            case 8: {
                return pSSFCodeTemplBase.getPSSFStyleId() == null;
            }
            case 9: {
                return pSSFCodeTemplBase.getTemplCode() == null;
            }
            case 10: {
                return pSSFCodeTemplBase.getTemplCode2() == null;
            }
            case 11: {
                return pSSFCodeTemplBase.getTemplDesc() == null;
            }
            case 12: {
                return pSSFCodeTemplBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSFCodeTemplBase.getUpdateMan() == null;
            }
            case 14: {
                return pSSFCodeTemplBase.getValidFlag() == null;
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
        return PSSFCodeTemplBase.contains(this, n);
    }

    private static boolean contains(PSSFCodeTemplBase pSSFCodeTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFCodeTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSSFCodeTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSSFCodeTemplBase.isLogicNameDirty();
            }
            case 3: {
                return pSSFCodeTemplBase.isMemoDirty();
            }
            case 4: {
                return pSSFCodeTemplBase.isPSSFCodeTemplIdDirty();
            }
            case 5: {
                return pSSFCodeTemplBase.isPSSFCodeTemplNameDirty();
            }
            case 6: {
                return pSSFCodeTemplBase.isPSSFCodeTypeIdDirty();
            }
            case 7: {
                return pSSFCodeTemplBase.isPSSFCodeTypeNameDirty();
            }
            case 8: {
                return pSSFCodeTemplBase.isPSSFStyleIdDirty();
            }
            case 9: {
                return pSSFCodeTemplBase.isTemplCodeDirty();
            }
            case 10: {
                return pSSFCodeTemplBase.isTemplCode2Dirty();
            }
            case 11: {
                return pSSFCodeTemplBase.isTemplDescDirty();
            }
            case 12: {
                return pSSFCodeTemplBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSFCodeTemplBase.isUpdateManDirty();
            }
            case 14: {
                return pSSFCodeTemplBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFCodeTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFCodeTemplBase pSSFCodeTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFCodeTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFCodeTemplBase.getJSONValue((Object)pSSFCodeTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFCodeTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFCodeTemplBase.getJSONValue((Object)pSSFCodeTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFCodeTemplBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSFCodeTemplBase.getJSONValue((Object)pSSFCodeTemplBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSFCodeTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFCodeTemplBase.getJSONValue((Object)pSSFCodeTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFCodeTemplBase.getPSSFCodeTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodetemplid", (Object)PSSFCodeTemplBase.getJSONValue((Object)pSSFCodeTemplBase.getPSSFCodeTemplId()), (boolean)false);
        }
        if (bl || pSSFCodeTemplBase.getPSSFCodeTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodetemplname", (Object)PSSFCodeTemplBase.getJSONValue((Object)pSSFCodeTemplBase.getPSSFCodeTemplName()), (boolean)false);
        }
        if (bl || pSSFCodeTemplBase.getPSSFCodeTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodetypeid", (Object)PSSFCodeTemplBase.getJSONValue((Object)pSSFCodeTemplBase.getPSSFCodeTypeId()), (boolean)false);
        }
        if (bl || pSSFCodeTemplBase.getPSSFCodeTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfcodetypename", (Object)PSSFCodeTemplBase.getJSONValue((Object)pSSFCodeTemplBase.getPSSFCodeTypeName()), (boolean)false);
        }
        if (bl || pSSFCodeTemplBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSFCodeTemplBase.getJSONValue((Object)pSSFCodeTemplBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFCodeTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSSFCodeTemplBase.getJSONValue((Object)pSSFCodeTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSSFCodeTemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSSFCodeTemplBase.getJSONValue((Object)pSSFCodeTemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSSFCodeTemplBase.getTemplDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templdesc", (Object)PSSFCodeTemplBase.getJSONValue((Object)pSSFCodeTemplBase.getTemplDesc()), (boolean)false);
        }
        if (bl || pSSFCodeTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFCodeTemplBase.getJSONValue((Object)pSSFCodeTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFCodeTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFCodeTemplBase.getJSONValue((Object)pSSFCodeTemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFCodeTemplBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSFCodeTemplBase.getJSONValue((Object)pSSFCodeTemplBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFCodeTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFCodeTemplBase pSSFCodeTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFCodeTemplBase.getCreateDate() != null) {
            object = pSSFCodeTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFCodeTemplBase.getCreateMan() != null) {
            object = pSSFCodeTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTemplBase.getLogicName() != null) {
            object = pSSFCodeTemplBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTemplBase.getMemo() != null) {
            object = pSSFCodeTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTemplBase.getPSSFCodeTemplId() != null) {
            object = pSSFCodeTemplBase.getPSSFCodeTemplId();
            xmlNode.setAttribute(FIELD_PSSFCODETEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTemplBase.getPSSFCodeTemplName() != null) {
            object = pSSFCodeTemplBase.getPSSFCodeTemplName();
            xmlNode.setAttribute(FIELD_PSSFCODETEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTemplBase.getPSSFCodeTypeId() != null) {
            object = pSSFCodeTemplBase.getPSSFCodeTypeId();
            xmlNode.setAttribute(FIELD_PSSFCODETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTemplBase.getPSSFCodeTypeName() != null) {
            object = pSSFCodeTemplBase.getPSSFCodeTypeName();
            xmlNode.setAttribute(FIELD_PSSFCODETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTemplBase.getPSSFStyleId() != null) {
            object = pSSFCodeTemplBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTemplBase.getTemplCode() != null) {
            object = pSSFCodeTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTemplBase.getTemplCode2() != null) {
            object = pSSFCodeTemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTemplBase.getTemplDesc() != null) {
            object = pSSFCodeTemplBase.getTemplDesc();
            xmlNode.setAttribute(FIELD_TEMPLDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTemplBase.getUpdateDate() != null) {
            object = pSSFCodeTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFCodeTemplBase.getUpdateMan() != null) {
            object = pSSFCodeTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFCodeTemplBase.getValidFlag() != null) {
            object = pSSFCodeTemplBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFCodeTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFCodeTemplBase pSSFCodeTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFCodeTemplBase.isCreateDateDirty() && (bl || pSSFCodeTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFCodeTemplBase.getCreateDate());
        }
        if (pSSFCodeTemplBase.isCreateManDirty() && (bl || pSSFCodeTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFCodeTemplBase.getCreateMan());
        }
        if (pSSFCodeTemplBase.isLogicNameDirty() && (bl || pSSFCodeTemplBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSFCodeTemplBase.getLogicName());
        }
        if (pSSFCodeTemplBase.isMemoDirty() && (bl || pSSFCodeTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFCodeTemplBase.getMemo());
        }
        if (pSSFCodeTemplBase.isPSSFCodeTemplIdDirty() && (bl || pSSFCodeTemplBase.getPSSFCodeTemplId() != null)) {
            iDataObject.set(FIELD_PSSFCODETEMPLID, (Object)pSSFCodeTemplBase.getPSSFCodeTemplId());
        }
        if (pSSFCodeTemplBase.isPSSFCodeTemplNameDirty() && (bl || pSSFCodeTemplBase.getPSSFCodeTemplName() != null)) {
            iDataObject.set(FIELD_PSSFCODETEMPLNAME, (Object)pSSFCodeTemplBase.getPSSFCodeTemplName());
        }
        if (pSSFCodeTemplBase.isPSSFCodeTypeIdDirty() && (bl || pSSFCodeTemplBase.getPSSFCodeTypeId() != null)) {
            iDataObject.set(FIELD_PSSFCODETYPEID, (Object)pSSFCodeTemplBase.getPSSFCodeTypeId());
        }
        if (pSSFCodeTemplBase.isPSSFCodeTypeNameDirty() && (bl || pSSFCodeTemplBase.getPSSFCodeTypeName() != null)) {
            iDataObject.set(FIELD_PSSFCODETYPENAME, (Object)pSSFCodeTemplBase.getPSSFCodeTypeName());
        }
        if (pSSFCodeTemplBase.isPSSFStyleIdDirty() && (bl || pSSFCodeTemplBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSFCodeTemplBase.getPSSFStyleId());
        }
        if (pSSFCodeTemplBase.isTemplCodeDirty() && (bl || pSSFCodeTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSSFCodeTemplBase.getTemplCode());
        }
        if (pSSFCodeTemplBase.isTemplCode2Dirty() && (bl || pSSFCodeTemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSSFCodeTemplBase.getTemplCode2());
        }
        if (pSSFCodeTemplBase.isTemplDescDirty() && (bl || pSSFCodeTemplBase.getTemplDesc() != null)) {
            iDataObject.set(FIELD_TEMPLDESC, (Object)pSSFCodeTemplBase.getTemplDesc());
        }
        if (pSSFCodeTemplBase.isUpdateDateDirty() && (bl || pSSFCodeTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFCodeTemplBase.getUpdateDate());
        }
        if (pSSFCodeTemplBase.isUpdateManDirty() && (bl || pSSFCodeTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFCodeTemplBase.getUpdateMan());
        }
        if (pSSFCodeTemplBase.isValidFlagDirty() && (bl || pSSFCodeTemplBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSFCodeTemplBase.getValidFlag());
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
        return PSSFCodeTemplBase.remove(this, n);
    }

    private static boolean remove(PSSFCodeTemplBase pSSFCodeTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFCodeTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSFCodeTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSFCodeTemplBase.resetLogicName();
                return true;
            }
            case 3: {
                pSSFCodeTemplBase.resetMemo();
                return true;
            }
            case 4: {
                pSSFCodeTemplBase.resetPSSFCodeTemplId();
                return true;
            }
            case 5: {
                pSSFCodeTemplBase.resetPSSFCodeTemplName();
                return true;
            }
            case 6: {
                pSSFCodeTemplBase.resetPSSFCodeTypeId();
                return true;
            }
            case 7: {
                pSSFCodeTemplBase.resetPSSFCodeTypeName();
                return true;
            }
            case 8: {
                pSSFCodeTemplBase.resetPSSFStyleId();
                return true;
            }
            case 9: {
                pSSFCodeTemplBase.resetTemplCode();
                return true;
            }
            case 10: {
                pSSFCodeTemplBase.resetTemplCode2();
                return true;
            }
            case 11: {
                pSSFCodeTemplBase.resetTemplDesc();
                return true;
            }
            case 12: {
                pSSFCodeTemplBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSFCodeTemplBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSSFCodeTemplBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFCodeType getPSSFCodeType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCodeType();
        }
        if (this.getPSSFCodeTypeId() == null) {
            return null;
        }
        Integer n = this.objPSSFCodeTypeLock;
        synchronized (n) {
            if (this.pssfcodetype != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFCodeTypeId(), (Object)this.pssfcodetype.getPSSFCodeTypeId()) != 0L) {
                this.pssfcodetype = null;
            }
            if (this.pssfcodetype == null) {
                PSSFCodeType pSSFCodeType = new PSSFCodeType();
                pSSFCodeType.setPSSFCodeTypeId(this.getPSSFCodeTypeId());
                PSSFCodeTypeService pSSFCodeTypeService = (PSSFCodeTypeService)ServiceGlobal.getService(PSSFCodeTypeService.class, (SessionFactory)this.getSessionFactory());
                pSSFCodeTypeService.autoGet(pSSFCodeType);
                this.pssfcodetype = pSSFCodeType;
            }
            return this.pssfcodetype;
        }
    }

    private PSSFCodeTemplBase getProxyEntity() {
        return this.proxyPSSFCodeTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFCodeTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFCodeTemplBase) {
            this.proxyPSSFCodeTemplBase = (PSSFCodeTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFCodeTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGICNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSSFCODETEMPLID, 4);
        fieldIndexMap.put(FIELD_PSSFCODETEMPLNAME, 5);
        fieldIndexMap.put(FIELD_PSSFCODETYPEID, 6);
        fieldIndexMap.put(FIELD_PSSFCODETYPENAME, 7);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 8);
        fieldIndexMap.put(FIELD_TEMPLCODE, 9);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 10);
        fieldIndexMap.put(FIELD_TEMPLDESC, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_VALIDFLAG, 14);
    }
}

