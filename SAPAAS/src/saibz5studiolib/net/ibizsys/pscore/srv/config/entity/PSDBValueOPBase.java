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
package net.ibizsys.pscore.srv.config.entity;

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

public abstract class PSDBValueOPBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDBValueOPBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBFLAG = "DBFLAG";
    public static final String FIELD_DLFLAG = "DLFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String FIELD_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String FIELD_SIMPLENAME = "SIMPLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DBFLAG = 2;
    private static final int INDEX_DLFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSDBVALUEOPID = 6;
    private static final int INDEX_PSDBVALUEOPNAME = 7;
    private static final int INDEX_SIMPLENAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_VALIDFLAG = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDBValueOPBase proxyPSDBValueOPBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbflagDirtyFlag = false;
    private boolean dlflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdbvalueopidDirtyFlag = false;
    private boolean psdbvalueopnameDirtyFlag = false;
    private boolean simplenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbflag")
    private Integer dbflag;
    @Column(name="dlflag")
    private Integer dlflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdbvalueopid")
    private String psdbvalueopid;
    @Column(name="psdbvalueopname")
    private String psdbvalueopname;
    @Column(name="simplename")
    private String simplename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;

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

    public void setDBFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBFlag(n);
            return;
        }
        this.dbflag = n;
        this.dbflagDirtyFlag = true;
    }

    public Integer getDBFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBFlag();
        }
        return this.dbflag;
    }

    public boolean isDBFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBFlagDirty();
        }
        return this.dbflagDirtyFlag;
    }

    public void resetDBFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBFlag();
            return;
        }
        this.dbflagDirtyFlag = false;
        this.dbflag = null;
    }

    public void setDLFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDLFlag(n);
            return;
        }
        this.dlflag = n;
        this.dlflagDirtyFlag = true;
    }

    public Integer getDLFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDLFlag();
        }
        return this.dlflag;
    }

    public boolean isDLFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDLFlagDirty();
        }
        return this.dlflagDirtyFlag;
    }

    public void resetDLFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDLFlag();
            return;
        }
        this.dlflagDirtyFlag = false;
        this.dlflag = null;
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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
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
        PSDBValueOPBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDBValueOPBase pSDBValueOPBase) {
        pSDBValueOPBase.resetCreateDate();
        pSDBValueOPBase.resetCreateMan();
        pSDBValueOPBase.resetDBFlag();
        pSDBValueOPBase.resetDLFlag();
        pSDBValueOPBase.resetMemo();
        pSDBValueOPBase.resetOrderValue();
        pSDBValueOPBase.resetPSDBValueOPId();
        pSDBValueOPBase.resetPSDBValueOPName();
        pSDBValueOPBase.resetSimpleName();
        pSDBValueOPBase.resetUpdateDate();
        pSDBValueOPBase.resetUpdateMan();
        pSDBValueOPBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDBFlagDirty()) {
            hashMap.put(FIELD_DBFLAG, this.getDBFlag());
        }
        if (!bl || this.isDLFlagDirty()) {
            hashMap.put(FIELD_DLFLAG, this.getDLFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDBValueOPIdDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPID, this.getPSDBValueOPId());
        }
        if (!bl || this.isPSDBValueOPNameDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPNAME, this.getPSDBValueOPName());
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
        return PSDBValueOPBase.get(this, n);
    }

    private static Object get(PSDBValueOPBase pSDBValueOPBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBValueOPBase.getCreateDate();
            }
            case 1: {
                return pSDBValueOPBase.getCreateMan();
            }
            case 2: {
                return pSDBValueOPBase.getDBFlag();
            }
            case 3: {
                return pSDBValueOPBase.getDLFlag();
            }
            case 4: {
                return pSDBValueOPBase.getMemo();
            }
            case 5: {
                return pSDBValueOPBase.getOrderValue();
            }
            case 6: {
                return pSDBValueOPBase.getPSDBValueOPId();
            }
            case 7: {
                return pSDBValueOPBase.getPSDBValueOPName();
            }
            case 8: {
                return pSDBValueOPBase.getSimpleName();
            }
            case 9: {
                return pSDBValueOPBase.getUpdateDate();
            }
            case 10: {
                return pSDBValueOPBase.getUpdateMan();
            }
            case 11: {
                return pSDBValueOPBase.getValidFlag();
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
        PSDBValueOPBase.set(this, n, object);
    }

    private static void set(PSDBValueOPBase pSDBValueOPBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDBValueOPBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDBValueOPBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDBValueOPBase.setDBFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDBValueOPBase.setDLFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDBValueOPBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDBValueOPBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDBValueOPBase.setPSDBValueOPId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDBValueOPBase.setPSDBValueOPName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDBValueOPBase.setSimpleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDBValueOPBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDBValueOPBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDBValueOPBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDBValueOPBase.isNull(this, n);
    }

    private static boolean isNull(PSDBValueOPBase pSDBValueOPBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBValueOPBase.getCreateDate() == null;
            }
            case 1: {
                return pSDBValueOPBase.getCreateMan() == null;
            }
            case 2: {
                return pSDBValueOPBase.getDBFlag() == null;
            }
            case 3: {
                return pSDBValueOPBase.getDLFlag() == null;
            }
            case 4: {
                return pSDBValueOPBase.getMemo() == null;
            }
            case 5: {
                return pSDBValueOPBase.getOrderValue() == null;
            }
            case 6: {
                return pSDBValueOPBase.getPSDBValueOPId() == null;
            }
            case 7: {
                return pSDBValueOPBase.getPSDBValueOPName() == null;
            }
            case 8: {
                return pSDBValueOPBase.getSimpleName() == null;
            }
            case 9: {
                return pSDBValueOPBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDBValueOPBase.getUpdateMan() == null;
            }
            case 11: {
                return pSDBValueOPBase.getValidFlag() == null;
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
        return PSDBValueOPBase.contains(this, n);
    }

    private static boolean contains(PSDBValueOPBase pSDBValueOPBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBValueOPBase.isCreateDateDirty();
            }
            case 1: {
                return pSDBValueOPBase.isCreateManDirty();
            }
            case 2: {
                return pSDBValueOPBase.isDBFlagDirty();
            }
            case 3: {
                return pSDBValueOPBase.isDLFlagDirty();
            }
            case 4: {
                return pSDBValueOPBase.isMemoDirty();
            }
            case 5: {
                return pSDBValueOPBase.isOrderValueDirty();
            }
            case 6: {
                return pSDBValueOPBase.isPSDBValueOPIdDirty();
            }
            case 7: {
                return pSDBValueOPBase.isPSDBValueOPNameDirty();
            }
            case 8: {
                return pSDBValueOPBase.isSimpleNameDirty();
            }
            case 9: {
                return pSDBValueOPBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDBValueOPBase.isUpdateManDirty();
            }
            case 11: {
                return pSDBValueOPBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDBValueOPBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDBValueOPBase pSDBValueOPBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDBValueOPBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDBValueOPBase.getJSONValue((Object)pSDBValueOPBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDBValueOPBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDBValueOPBase.getJSONValue((Object)pSDBValueOPBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDBValueOPBase.getDBFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbflag", (Object)PSDBValueOPBase.getJSONValue((Object)pSDBValueOPBase.getDBFlag()), (boolean)false);
        }
        if (bl || pSDBValueOPBase.getDLFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dlflag", (Object)PSDBValueOPBase.getJSONValue((Object)pSDBValueOPBase.getDLFlag()), (boolean)false);
        }
        if (bl || pSDBValueOPBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDBValueOPBase.getJSONValue((Object)pSDBValueOPBase.getMemo()), (boolean)false);
        }
        if (bl || pSDBValueOPBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDBValueOPBase.getJSONValue((Object)pSDBValueOPBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDBValueOPBase.getPSDBValueOPId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopid", (Object)PSDBValueOPBase.getJSONValue((Object)pSDBValueOPBase.getPSDBValueOPId()), (boolean)false);
        }
        if (bl || pSDBValueOPBase.getPSDBValueOPName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopname", (Object)PSDBValueOPBase.getJSONValue((Object)pSDBValueOPBase.getPSDBValueOPName()), (boolean)false);
        }
        if (bl || pSDBValueOPBase.getSimpleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"simplename", (Object)PSDBValueOPBase.getJSONValue((Object)pSDBValueOPBase.getSimpleName()), (boolean)false);
        }
        if (bl || pSDBValueOPBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDBValueOPBase.getJSONValue((Object)pSDBValueOPBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDBValueOPBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDBValueOPBase.getJSONValue((Object)pSDBValueOPBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDBValueOPBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDBValueOPBase.getJSONValue((Object)pSDBValueOPBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDBValueOPBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDBValueOPBase pSDBValueOPBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDBValueOPBase.getCreateDate() != null) {
            object = pSDBValueOPBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBValueOPBase.getCreateMan() != null) {
            object = pSDBValueOPBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueOPBase.getDBFlag() != null) {
            object = pSDBValueOPBase.getDBFlag();
            xmlNode.setAttribute(FIELD_DBFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBValueOPBase.getDLFlag() != null) {
            object = pSDBValueOPBase.getDLFlag();
            xmlNode.setAttribute(FIELD_DLFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBValueOPBase.getMemo() != null) {
            object = pSDBValueOPBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueOPBase.getOrderValue() != null) {
            object = pSDBValueOPBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBValueOPBase.getPSDBValueOPId() != null) {
            object = pSDBValueOPBase.getPSDBValueOPId();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPID, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueOPBase.getPSDBValueOPName() != null) {
            object = pSDBValueOPBase.getPSDBValueOPName();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueOPBase.getSimpleName() != null) {
            object = pSDBValueOPBase.getSimpleName();
            xmlNode.setAttribute(FIELD_SIMPLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueOPBase.getUpdateDate() != null) {
            object = pSDBValueOPBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBValueOPBase.getUpdateMan() != null) {
            object = pSDBValueOPBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueOPBase.getValidFlag() != null) {
            object = pSDBValueOPBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDBValueOPBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDBValueOPBase pSDBValueOPBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDBValueOPBase.isCreateDateDirty() && (bl || pSDBValueOPBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDBValueOPBase.getCreateDate());
        }
        if (pSDBValueOPBase.isCreateManDirty() && (bl || pSDBValueOPBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDBValueOPBase.getCreateMan());
        }
        if (pSDBValueOPBase.isDBFlagDirty() && (bl || pSDBValueOPBase.getDBFlag() != null)) {
            iDataObject.set(FIELD_DBFLAG, (Object)pSDBValueOPBase.getDBFlag());
        }
        if (pSDBValueOPBase.isDLFlagDirty() && (bl || pSDBValueOPBase.getDLFlag() != null)) {
            iDataObject.set(FIELD_DLFLAG, (Object)pSDBValueOPBase.getDLFlag());
        }
        if (pSDBValueOPBase.isMemoDirty() && (bl || pSDBValueOPBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDBValueOPBase.getMemo());
        }
        if (pSDBValueOPBase.isOrderValueDirty() && (bl || pSDBValueOPBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDBValueOPBase.getOrderValue());
        }
        if (pSDBValueOPBase.isPSDBValueOPIdDirty() && (bl || pSDBValueOPBase.getPSDBValueOPId() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPID, (Object)pSDBValueOPBase.getPSDBValueOPId());
        }
        if (pSDBValueOPBase.isPSDBValueOPNameDirty() && (bl || pSDBValueOPBase.getPSDBValueOPName() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPNAME, (Object)pSDBValueOPBase.getPSDBValueOPName());
        }
        if (pSDBValueOPBase.isSimpleNameDirty() && (bl || pSDBValueOPBase.getSimpleName() != null)) {
            iDataObject.set(FIELD_SIMPLENAME, (Object)pSDBValueOPBase.getSimpleName());
        }
        if (pSDBValueOPBase.isUpdateDateDirty() && (bl || pSDBValueOPBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDBValueOPBase.getUpdateDate());
        }
        if (pSDBValueOPBase.isUpdateManDirty() && (bl || pSDBValueOPBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDBValueOPBase.getUpdateMan());
        }
        if (pSDBValueOPBase.isValidFlagDirty() && (bl || pSDBValueOPBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDBValueOPBase.getValidFlag());
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
        return PSDBValueOPBase.remove(this, n);
    }

    private static boolean remove(PSDBValueOPBase pSDBValueOPBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDBValueOPBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDBValueOPBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDBValueOPBase.resetDBFlag();
                return true;
            }
            case 3: {
                pSDBValueOPBase.resetDLFlag();
                return true;
            }
            case 4: {
                pSDBValueOPBase.resetMemo();
                return true;
            }
            case 5: {
                pSDBValueOPBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSDBValueOPBase.resetPSDBValueOPId();
                return true;
            }
            case 7: {
                pSDBValueOPBase.resetPSDBValueOPName();
                return true;
            }
            case 8: {
                pSDBValueOPBase.resetSimpleName();
                return true;
            }
            case 9: {
                pSDBValueOPBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDBValueOPBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSDBValueOPBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDBValueOPBase getProxyEntity() {
        return this.proxyPSDBValueOPBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDBValueOPBase = null;
        if (iDataObject != null && iDataObject instanceof PSDBValueOPBase) {
            this.proxyPSDBValueOPBase = (PSDBValueOPBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBValueOPService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DBFLAG, 2);
        fieldIndexMap.put(FIELD_DLFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PSDBVALUEOPID, 6);
        fieldIndexMap.put(FIELD_PSDBVALUEOPNAME, 7);
        fieldIndexMap.put(FIELD_SIMPLENAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_VALIDFLAG, 11);
    }
}

