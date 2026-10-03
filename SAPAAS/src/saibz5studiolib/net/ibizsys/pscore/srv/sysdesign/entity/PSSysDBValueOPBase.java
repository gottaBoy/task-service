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
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import net.ibizsys.pscore.srv.config.service.PSDBValueOPService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBValueOPBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDBValueOPBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String FIELD_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String FIELD_PSSYSDBVALUEOPID = "PSSYSDBVALUEOPID";
    public static final String FIELD_PSSYSDBVALUEOPNAME = "PSSYSDBVALUEOPNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_SIMPLENAME = "SIMPLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDBVALUEOPID = 3;
    private static final int INDEX_PSDBVALUEOPNAME = 4;
    private static final int INDEX_PSSYSDBVALUEOPID = 5;
    private static final int INDEX_PSSYSDBVALUEOPNAME = 6;
    private static final int INDEX_PSSYSTEMID = 7;
    private static final int INDEX_PSSYSTEMNAME = 8;
    private static final int INDEX_SIMPLENAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDBValueOPBase proxyPSSysDBValueOPBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdbvalueopidDirtyFlag = false;
    private boolean psdbvalueopnameDirtyFlag = false;
    private boolean pssysdbvalueopidDirtyFlag = false;
    private boolean pssysdbvalueopnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean simplenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdbvalueopid")
    private String psdbvalueopid;
    @Column(name="psdbvalueopname")
    private String psdbvalueopname;
    @Column(name="pssysdbvalueopid")
    private String pssysdbvalueopid;
    @Column(name="pssysdbvalueopname")
    private String pssysdbvalueopname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="simplename")
    private String simplename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDBValueOPLock = new Integer(1);
    private PSDBValueOP psdbvalueop = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setPSDBValueOPId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueOPId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvalueopid = string;
        this.psdbvalueopidDirtyFlag = true;
    }

    public String getPSDBValueOPId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOPId();
        }
        return this.psdbvalueopid;
    }

    public boolean isPSDBValueOPIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueOPIdDirty();
        }
        return this.psdbvalueopidDirtyFlag;
    }

    public void resetPSDBValueOPId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueOPId();
            return;
        }
        this.psdbvalueopidDirtyFlag = false;
        this.psdbvalueopid = null;
    }

    public void setPSDBValueOPName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueOPName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvalueopname = string;
        this.psdbvalueopnameDirtyFlag = true;
    }

    public String getPSDBValueOPName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOPName();
        }
        return this.psdbvalueopname;
    }

    public boolean isPSDBValueOPNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueOPNameDirty();
        }
        return this.psdbvalueopnameDirtyFlag;
    }

    public void resetPSDBValueOPName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueOPName();
            return;
        }
        this.psdbvalueopnameDirtyFlag = false;
        this.psdbvalueopname = null;
    }

    public void setPSSysDBValueOPId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBValueOPId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbvalueopid = string;
        this.pssysdbvalueopidDirtyFlag = true;
    }

    public String getPSSysDBValueOPId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBValueOPId();
        }
        return this.pssysdbvalueopid;
    }

    public boolean isPSSysDBValueOPIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBValueOPIdDirty();
        }
        return this.pssysdbvalueopidDirtyFlag;
    }

    public void resetPSSysDBValueOPId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBValueOPId();
            return;
        }
        this.pssysdbvalueopidDirtyFlag = false;
        this.pssysdbvalueopid = null;
    }

    public void setPSSysDBValueOPName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBValueOPName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbvalueopname = string;
        this.pssysdbvalueopnameDirtyFlag = true;
    }

    public String getPSSysDBValueOPName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBValueOPName();
        }
        return this.pssysdbvalueopname;
    }

    public boolean isPSSysDBValueOPNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBValueOPNameDirty();
        }
        return this.pssysdbvalueopnameDirtyFlag;
    }

    public void resetPSSysDBValueOPName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBValueOPName();
            return;
        }
        this.pssysdbvalueopnameDirtyFlag = false;
        this.pssysdbvalueopname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setSimpleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSimpleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.simplename = string;
        this.simplenameDirtyFlag = true;
    }

    public String getSimpleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSimpleName();
        }
        return this.simplename;
    }

    public boolean isSimpleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSimpleNameDirty();
        }
        return this.simplenameDirtyFlag;
    }

    public void resetSimpleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSimpleName();
            return;
        }
        this.simplenameDirtyFlag = false;
        this.simplename = null;
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
        PSSysDBValueOPBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDBValueOPBase pSSysDBValueOPBase) {
        pSSysDBValueOPBase.resetCreateDate();
        pSSysDBValueOPBase.resetCreateMan();
        pSSysDBValueOPBase.resetMemo();
        pSSysDBValueOPBase.resetPSDBValueOPId();
        pSSysDBValueOPBase.resetPSDBValueOPName();
        pSSysDBValueOPBase.resetPSSysDBValueOPId();
        pSSysDBValueOPBase.resetPSSysDBValueOPName();
        pSSysDBValueOPBase.resetPSSystemId();
        pSSysDBValueOPBase.resetPSSystemName();
        pSSysDBValueOPBase.resetSimpleName();
        pSSysDBValueOPBase.resetUpdateDate();
        pSSysDBValueOPBase.resetUpdateMan();
        pSSysDBValueOPBase.resetValidFlag();
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
        if (!bl || this.isPSDBValueOPIdDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPID, this.getPSDBValueOPId());
        }
        if (!bl || this.isPSDBValueOPNameDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPNAME, this.getPSDBValueOPName());
        }
        if (!bl || this.isPSSysDBValueOPIdDirty()) {
            hashMap.put(FIELD_PSSYSDBVALUEOPID, this.getPSSysDBValueOPId());
        }
        if (!bl || this.isPSSysDBValueOPNameDirty()) {
            hashMap.put(FIELD_PSSYSDBVALUEOPNAME, this.getPSSysDBValueOPName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isSimpleNameDirty()) {
            hashMap.put(FIELD_SIMPLENAME, this.getSimpleName());
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
        return PSSysDBValueOPBase.get(this, n);
    }

    private static Object get(PSSysDBValueOPBase pSSysDBValueOPBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBValueOPBase.getCreateDate();
            }
            case 1: {
                return pSSysDBValueOPBase.getCreateMan();
            }
            case 2: {
                return pSSysDBValueOPBase.getMemo();
            }
            case 3: {
                return pSSysDBValueOPBase.getPSDBValueOPId();
            }
            case 4: {
                return pSSysDBValueOPBase.getPSDBValueOPName();
            }
            case 5: {
                return pSSysDBValueOPBase.getPSSysDBValueOPId();
            }
            case 6: {
                return pSSysDBValueOPBase.getPSSysDBValueOPName();
            }
            case 7: {
                return pSSysDBValueOPBase.getPSSystemId();
            }
            case 8: {
                return pSSysDBValueOPBase.getPSSystemName();
            }
            case 9: {
                return pSSysDBValueOPBase.getSimpleName();
            }
            case 10: {
                return pSSysDBValueOPBase.getUpdateDate();
            }
            case 11: {
                return pSSysDBValueOPBase.getUpdateMan();
            }
            case 12: {
                return pSSysDBValueOPBase.getValidFlag();
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
        PSSysDBValueOPBase.set(this, n, object);
    }

    private static void set(PSSysDBValueOPBase pSSysDBValueOPBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBValueOPBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDBValueOPBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDBValueOPBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDBValueOPBase.setPSDBValueOPId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDBValueOPBase.setPSDBValueOPName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDBValueOPBase.setPSSysDBValueOPId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDBValueOPBase.setPSSysDBValueOPName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDBValueOPBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDBValueOPBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDBValueOPBase.setSimpleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDBValueOPBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysDBValueOPBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDBValueOPBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysDBValueOPBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDBValueOPBase pSSysDBValueOPBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBValueOPBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysDBValueOPBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysDBValueOPBase.getMemo() == null;
            }
            case 3: {
                return pSSysDBValueOPBase.getPSDBValueOPId() == null;
            }
            case 4: {
                return pSSysDBValueOPBase.getPSDBValueOPName() == null;
            }
            case 5: {
                return pSSysDBValueOPBase.getPSSysDBValueOPId() == null;
            }
            case 6: {
                return pSSysDBValueOPBase.getPSSysDBValueOPName() == null;
            }
            case 7: {
                return pSSysDBValueOPBase.getPSSystemId() == null;
            }
            case 8: {
                return pSSysDBValueOPBase.getPSSystemName() == null;
            }
            case 9: {
                return pSSysDBValueOPBase.getSimpleName() == null;
            }
            case 10: {
                return pSSysDBValueOPBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysDBValueOPBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSysDBValueOPBase.getValidFlag() == null;
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
        return PSSysDBValueOPBase.contains(this, n);
    }

    private static boolean contains(PSSysDBValueOPBase pSSysDBValueOPBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBValueOPBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysDBValueOPBase.isCreateManDirty();
            }
            case 2: {
                return pSSysDBValueOPBase.isMemoDirty();
            }
            case 3: {
                return pSSysDBValueOPBase.isPSDBValueOPIdDirty();
            }
            case 4: {
                return pSSysDBValueOPBase.isPSDBValueOPNameDirty();
            }
            case 5: {
                return pSSysDBValueOPBase.isPSSysDBValueOPIdDirty();
            }
            case 6: {
                return pSSysDBValueOPBase.isPSSysDBValueOPNameDirty();
            }
            case 7: {
                return pSSysDBValueOPBase.isPSSystemIdDirty();
            }
            case 8: {
                return pSSysDBValueOPBase.isPSSystemNameDirty();
            }
            case 9: {
                return pSSysDBValueOPBase.isSimpleNameDirty();
            }
            case 10: {
                return pSSysDBValueOPBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysDBValueOPBase.isUpdateManDirty();
            }
            case 12: {
                return pSSysDBValueOPBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDBValueOPBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDBValueOPBase pSSysDBValueOPBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDBValueOPBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDBValueOPBase.getJSONValue((Object)pSSysDBValueOPBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDBValueOPBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDBValueOPBase.getJSONValue((Object)pSSysDBValueOPBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDBValueOPBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDBValueOPBase.getJSONValue((Object)pSSysDBValueOPBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDBValueOPBase.getPSDBValueOPId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopid", (Object)PSSysDBValueOPBase.getJSONValue((Object)pSSysDBValueOPBase.getPSDBValueOPId()), (boolean)false);
        }
        if (bl || pSSysDBValueOPBase.getPSDBValueOPName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopname", (Object)PSSysDBValueOPBase.getJSONValue((Object)pSSysDBValueOPBase.getPSDBValueOPName()), (boolean)false);
        }
        if (bl || pSSysDBValueOPBase.getPSSysDBValueOPId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvalueopid", (Object)PSSysDBValueOPBase.getJSONValue((Object)pSSysDBValueOPBase.getPSSysDBValueOPId()), (boolean)false);
        }
        if (bl || pSSysDBValueOPBase.getPSSysDBValueOPName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvalueopname", (Object)PSSysDBValueOPBase.getJSONValue((Object)pSSysDBValueOPBase.getPSSysDBValueOPName()), (boolean)false);
        }
        if (bl || pSSysDBValueOPBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysDBValueOPBase.getJSONValue((Object)pSSysDBValueOPBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysDBValueOPBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysDBValueOPBase.getJSONValue((Object)pSSysDBValueOPBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysDBValueOPBase.getSimpleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"simplename", (Object)PSSysDBValueOPBase.getJSONValue((Object)pSSysDBValueOPBase.getSimpleName()), (boolean)false);
        }
        if (bl || pSSysDBValueOPBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDBValueOPBase.getJSONValue((Object)pSSysDBValueOPBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDBValueOPBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDBValueOPBase.getJSONValue((Object)pSSysDBValueOPBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDBValueOPBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysDBValueOPBase.getJSONValue((Object)pSSysDBValueOPBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDBValueOPBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDBValueOPBase pSSysDBValueOPBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDBValueOPBase.getCreateDate() != null) {
            object = pSSysDBValueOPBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBValueOPBase.getCreateMan() != null) {
            object = pSSysDBValueOPBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBValueOPBase.getMemo() != null) {
            object = pSSysDBValueOPBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBValueOPBase.getPSDBValueOPId() != null) {
            object = pSSysDBValueOPBase.getPSDBValueOPId();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBValueOPBase.getPSDBValueOPName() != null) {
            object = pSSysDBValueOPBase.getPSDBValueOPName();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBValueOPBase.getPSSysDBValueOPId() != null) {
            object = pSSysDBValueOPBase.getPSSysDBValueOPId();
            xmlNode.setAttribute(FIELD_PSSYSDBVALUEOPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBValueOPBase.getPSSysDBValueOPName() != null) {
            object = pSSysDBValueOPBase.getPSSysDBValueOPName();
            xmlNode.setAttribute(FIELD_PSSYSDBVALUEOPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBValueOPBase.getPSSystemId() != null) {
            object = pSSysDBValueOPBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBValueOPBase.getPSSystemName() != null) {
            object = pSSysDBValueOPBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBValueOPBase.getSimpleName() != null) {
            object = pSSysDBValueOPBase.getSimpleName();
            xmlNode.setAttribute(FIELD_SIMPLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBValueOPBase.getUpdateDate() != null) {
            object = pSSysDBValueOPBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBValueOPBase.getUpdateMan() != null) {
            object = pSSysDBValueOPBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBValueOPBase.getValidFlag() != null) {
            object = pSSysDBValueOPBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDBValueOPBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDBValueOPBase pSSysDBValueOPBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDBValueOPBase.isCreateDateDirty() && (bl || pSSysDBValueOPBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDBValueOPBase.getCreateDate());
        }
        if (pSSysDBValueOPBase.isCreateManDirty() && (bl || pSSysDBValueOPBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDBValueOPBase.getCreateMan());
        }
        if (pSSysDBValueOPBase.isMemoDirty() && (bl || pSSysDBValueOPBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDBValueOPBase.getMemo());
        }
        if (pSSysDBValueOPBase.isPSDBValueOPIdDirty() && (bl || pSSysDBValueOPBase.getPSDBValueOPId() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPID, (Object)pSSysDBValueOPBase.getPSDBValueOPId());
        }
        if (pSSysDBValueOPBase.isPSDBValueOPNameDirty() && (bl || pSSysDBValueOPBase.getPSDBValueOPName() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPNAME, (Object)pSSysDBValueOPBase.getPSDBValueOPName());
        }
        if (pSSysDBValueOPBase.isPSSysDBValueOPIdDirty() && (bl || pSSysDBValueOPBase.getPSSysDBValueOPId() != null)) {
            iDataObject.set(FIELD_PSSYSDBVALUEOPID, (Object)pSSysDBValueOPBase.getPSSysDBValueOPId());
        }
        if (pSSysDBValueOPBase.isPSSysDBValueOPNameDirty() && (bl || pSSysDBValueOPBase.getPSSysDBValueOPName() != null)) {
            iDataObject.set(FIELD_PSSYSDBVALUEOPNAME, (Object)pSSysDBValueOPBase.getPSSysDBValueOPName());
        }
        if (pSSysDBValueOPBase.isPSSystemIdDirty() && (bl || pSSysDBValueOPBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysDBValueOPBase.getPSSystemId());
        }
        if (pSSysDBValueOPBase.isPSSystemNameDirty() && (bl || pSSysDBValueOPBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysDBValueOPBase.getPSSystemName());
        }
        if (pSSysDBValueOPBase.isSimpleNameDirty() && (bl || pSSysDBValueOPBase.getSimpleName() != null)) {
            iDataObject.set(FIELD_SIMPLENAME, (Object)pSSysDBValueOPBase.getSimpleName());
        }
        if (pSSysDBValueOPBase.isUpdateDateDirty() && (bl || pSSysDBValueOPBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDBValueOPBase.getUpdateDate());
        }
        if (pSSysDBValueOPBase.isUpdateManDirty() && (bl || pSSysDBValueOPBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDBValueOPBase.getUpdateMan());
        }
        if (pSSysDBValueOPBase.isValidFlagDirty() && (bl || pSSysDBValueOPBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysDBValueOPBase.getValidFlag());
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
        return PSSysDBValueOPBase.remove(this, n);
    }

    private static boolean remove(PSSysDBValueOPBase pSSysDBValueOPBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBValueOPBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysDBValueOPBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysDBValueOPBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysDBValueOPBase.resetPSDBValueOPId();
                return true;
            }
            case 4: {
                pSSysDBValueOPBase.resetPSDBValueOPName();
                return true;
            }
            case 5: {
                pSSysDBValueOPBase.resetPSSysDBValueOPId();
                return true;
            }
            case 6: {
                pSSysDBValueOPBase.resetPSSysDBValueOPName();
                return true;
            }
            case 7: {
                pSSysDBValueOPBase.resetPSSystemId();
                return true;
            }
            case 8: {
                pSSysDBValueOPBase.resetPSSystemName();
                return true;
            }
            case 9: {
                pSSysDBValueOPBase.resetSimpleName();
                return true;
            }
            case 10: {
                pSSysDBValueOPBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysDBValueOPBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSysDBValueOPBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBValueOP getPSDBValueOP() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOP();
        }
        if (this.getPSDBValueOPId() == null) {
            return null;
        }
        Integer n = this.objPSDBValueOPLock;
        synchronized (n) {
            if (this.psdbvalueop != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBValueOPId(), (Object)this.psdbvalueop.getPSDBValueOPId()) != 0L) {
                this.psdbvalueop = null;
            }
            if (this.psdbvalueop == null) {
                PSDBValueOP pSDBValueOP = new PSDBValueOP();
                pSDBValueOP.setPSDBValueOPId(this.getPSDBValueOPId());
                PSDBValueOPService pSDBValueOPService = (PSDBValueOPService)ServiceGlobal.getService(PSDBValueOPService.class, (SessionFactory)this.getSessionFactory());
                pSDBValueOPService.autoGet(pSDBValueOP);
                this.psdbvalueop = pSDBValueOP;
            }
            return this.psdbvalueop;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSysDBValueOPBase getProxyEntity() {
        return this.proxyPSSysDBValueOPBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDBValueOPBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDBValueOPBase) {
            this.proxyPSSysDBValueOPBase = (PSSysDBValueOPBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBValueOPService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDBVALUEOPID, 3);
        fieldIndexMap.put(FIELD_PSDBVALUEOPNAME, 4);
        fieldIndexMap.put(FIELD_PSSYSDBVALUEOPID, 5);
        fieldIndexMap.put(FIELD_PSSYSDBVALUEOPNAME, 6);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 7);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 8);
        fieldIndexMap.put(FIELD_SIMPLENAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

