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

public abstract class PSRobotTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSRobotTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MAXENERGY = "MAXENERGY";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSROBOTTYPEID = "PSROBOTTYPEID";
    public static final String FIELD_PSROBOTTYPENAME = "PSROBOTTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MAXENERGY = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSROBOTTYPEID = 4;
    private static final int INDEX_PSROBOTTYPENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_USERTAG = 8;
    private static final int INDEX_USERTAG2 = 9;
    private static final int INDEX_VALIDFLAG = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSRobotTypeBase proxyPSRobotTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean maxenergyDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psrobottypeidDirtyFlag = false;
    private boolean psrobottypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="maxenergy")
    private Integer maxenergy;
    @Column(name="memo")
    private String memo;
    @Column(name="psrobottypeid")
    private String psrobottypeid;
    @Column(name="psrobottypename")
    private String psrobottypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
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

    public void setMaxEnergy(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxEnergy(n);
            return;
        }
        this.maxenergy = n;
        this.maxenergyDirtyFlag = true;
    }

    public Integer getMaxEnergy() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxEnergy();
        }
        return this.maxenergy;
    }

    public boolean isMaxEnergyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxEnergyDirty();
        }
        return this.maxenergyDirtyFlag;
    }

    public void resetMaxEnergy() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxEnergy();
            return;
        }
        this.maxenergyDirtyFlag = false;
        this.maxenergy = null;
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

    public void setPSRobotTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobottypeid = string;
        this.psrobottypeidDirtyFlag = true;
    }

    public String getPSRobotTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotTypeId();
        }
        return this.psrobottypeid;
    }

    public boolean isPSRobotTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotTypeIdDirty();
        }
        return this.psrobottypeidDirtyFlag;
    }

    public void resetPSRobotTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotTypeId();
            return;
        }
        this.psrobottypeidDirtyFlag = false;
        this.psrobottypeid = null;
    }

    public void setPSRobotTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobottypename = string;
        this.psrobottypenameDirtyFlag = true;
    }

    public String getPSRobotTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotTypeName();
        }
        return this.psrobottypename;
    }

    public boolean isPSRobotTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotTypeNameDirty();
        }
        return this.psrobottypenameDirtyFlag;
    }

    public void resetPSRobotTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotTypeName();
            return;
        }
        this.psrobottypenameDirtyFlag = false;
        this.psrobottypename = null;
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

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
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
        PSRobotTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSRobotTypeBase pSRobotTypeBase) {
        pSRobotTypeBase.resetCreateDate();
        pSRobotTypeBase.resetCreateMan();
        pSRobotTypeBase.resetMaxEnergy();
        pSRobotTypeBase.resetMemo();
        pSRobotTypeBase.resetPSRobotTypeId();
        pSRobotTypeBase.resetPSRobotTypeName();
        pSRobotTypeBase.resetUpdateDate();
        pSRobotTypeBase.resetUpdateMan();
        pSRobotTypeBase.resetUserTag();
        pSRobotTypeBase.resetUserTag2();
        pSRobotTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMaxEnergyDirty()) {
            hashMap.put(FIELD_MAXENERGY, this.getMaxEnergy());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSRobotTypeIdDirty()) {
            hashMap.put(FIELD_PSROBOTTYPEID, this.getPSRobotTypeId());
        }
        if (!bl || this.isPSRobotTypeNameDirty()) {
            hashMap.put(FIELD_PSROBOTTYPENAME, this.getPSRobotTypeName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSRobotTypeBase.get(this, n);
    }

    private static Object get(PSRobotTypeBase pSRobotTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotTypeBase.getCreateDate();
            }
            case 1: {
                return pSRobotTypeBase.getCreateMan();
            }
            case 2: {
                return pSRobotTypeBase.getMaxEnergy();
            }
            case 3: {
                return pSRobotTypeBase.getMemo();
            }
            case 4: {
                return pSRobotTypeBase.getPSRobotTypeId();
            }
            case 5: {
                return pSRobotTypeBase.getPSRobotTypeName();
            }
            case 6: {
                return pSRobotTypeBase.getUpdateDate();
            }
            case 7: {
                return pSRobotTypeBase.getUpdateMan();
            }
            case 8: {
                return pSRobotTypeBase.getUserTag();
            }
            case 9: {
                return pSRobotTypeBase.getUserTag2();
            }
            case 10: {
                return pSRobotTypeBase.getValidFlag();
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
        PSRobotTypeBase.set(this, n, object);
    }

    private static void set(PSRobotTypeBase pSRobotTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSRobotTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSRobotTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSRobotTypeBase.setMaxEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSRobotTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSRobotTypeBase.setPSRobotTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSRobotTypeBase.setPSRobotTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSRobotTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSRobotTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSRobotTypeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSRobotTypeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSRobotTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSRobotTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSRobotTypeBase pSRobotTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSRobotTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSRobotTypeBase.getMaxEnergy() == null;
            }
            case 3: {
                return pSRobotTypeBase.getMemo() == null;
            }
            case 4: {
                return pSRobotTypeBase.getPSRobotTypeId() == null;
            }
            case 5: {
                return pSRobotTypeBase.getPSRobotTypeName() == null;
            }
            case 6: {
                return pSRobotTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSRobotTypeBase.getUpdateMan() == null;
            }
            case 8: {
                return pSRobotTypeBase.getUserTag() == null;
            }
            case 9: {
                return pSRobotTypeBase.getUserTag2() == null;
            }
            case 10: {
                return pSRobotTypeBase.getValidFlag() == null;
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
        return PSRobotTypeBase.contains(this, n);
    }

    private static boolean contains(PSRobotTypeBase pSRobotTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSRobotTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSRobotTypeBase.isMaxEnergyDirty();
            }
            case 3: {
                return pSRobotTypeBase.isMemoDirty();
            }
            case 4: {
                return pSRobotTypeBase.isPSRobotTypeIdDirty();
            }
            case 5: {
                return pSRobotTypeBase.isPSRobotTypeNameDirty();
            }
            case 6: {
                return pSRobotTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSRobotTypeBase.isUpdateManDirty();
            }
            case 8: {
                return pSRobotTypeBase.isUserTagDirty();
            }
            case 9: {
                return pSRobotTypeBase.isUserTag2Dirty();
            }
            case 10: {
                return pSRobotTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSRobotTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSRobotTypeBase pSRobotTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSRobotTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSRobotTypeBase.getJSONValue((Object)pSRobotTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSRobotTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSRobotTypeBase.getJSONValue((Object)pSRobotTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSRobotTypeBase.getMaxEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxenergy", (Object)PSRobotTypeBase.getJSONValue((Object)pSRobotTypeBase.getMaxEnergy()), (boolean)false);
        }
        if (bl || pSRobotTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSRobotTypeBase.getJSONValue((Object)pSRobotTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSRobotTypeBase.getPSRobotTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobottypeid", (Object)PSRobotTypeBase.getJSONValue((Object)pSRobotTypeBase.getPSRobotTypeId()), (boolean)false);
        }
        if (bl || pSRobotTypeBase.getPSRobotTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobottypename", (Object)PSRobotTypeBase.getJSONValue((Object)pSRobotTypeBase.getPSRobotTypeName()), (boolean)false);
        }
        if (bl || pSRobotTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSRobotTypeBase.getJSONValue((Object)pSRobotTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSRobotTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSRobotTypeBase.getJSONValue((Object)pSRobotTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSRobotTypeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSRobotTypeBase.getJSONValue((Object)pSRobotTypeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSRobotTypeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSRobotTypeBase.getJSONValue((Object)pSRobotTypeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSRobotTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSRobotTypeBase.getJSONValue((Object)pSRobotTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSRobotTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSRobotTypeBase pSRobotTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSRobotTypeBase.getCreateDate() != null) {
            object = pSRobotTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRobotTypeBase.getCreateMan() != null) {
            object = pSRobotTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeBase.getMaxEnergy() != null) {
            object = pSRobotTypeBase.getMaxEnergy();
            xmlNode.setAttribute(FIELD_MAXENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRobotTypeBase.getMemo() != null) {
            object = pSRobotTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeBase.getPSRobotTypeId() != null) {
            object = pSRobotTypeBase.getPSRobotTypeId();
            xmlNode.setAttribute(FIELD_PSROBOTTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeBase.getPSRobotTypeName() != null) {
            object = pSRobotTypeBase.getPSRobotTypeName();
            xmlNode.setAttribute(FIELD_PSROBOTTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeBase.getUpdateDate() != null) {
            object = pSRobotTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRobotTypeBase.getUpdateMan() != null) {
            object = pSRobotTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeBase.getUserTag() != null) {
            object = pSRobotTypeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeBase.getUserTag2() != null) {
            object = pSRobotTypeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSRobotTypeBase.getValidFlag() != null) {
            object = pSRobotTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSRobotTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSRobotTypeBase pSRobotTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSRobotTypeBase.isCreateDateDirty() && (bl || pSRobotTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSRobotTypeBase.getCreateDate());
        }
        if (pSRobotTypeBase.isCreateManDirty() && (bl || pSRobotTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSRobotTypeBase.getCreateMan());
        }
        if (pSRobotTypeBase.isMaxEnergyDirty() && (bl || pSRobotTypeBase.getMaxEnergy() != null)) {
            iDataObject.set(FIELD_MAXENERGY, (Object)pSRobotTypeBase.getMaxEnergy());
        }
        if (pSRobotTypeBase.isMemoDirty() && (bl || pSRobotTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSRobotTypeBase.getMemo());
        }
        if (pSRobotTypeBase.isPSRobotTypeIdDirty() && (bl || pSRobotTypeBase.getPSRobotTypeId() != null)) {
            iDataObject.set(FIELD_PSROBOTTYPEID, (Object)pSRobotTypeBase.getPSRobotTypeId());
        }
        if (pSRobotTypeBase.isPSRobotTypeNameDirty() && (bl || pSRobotTypeBase.getPSRobotTypeName() != null)) {
            iDataObject.set(FIELD_PSROBOTTYPENAME, (Object)pSRobotTypeBase.getPSRobotTypeName());
        }
        if (pSRobotTypeBase.isUpdateDateDirty() && (bl || pSRobotTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSRobotTypeBase.getUpdateDate());
        }
        if (pSRobotTypeBase.isUpdateManDirty() && (bl || pSRobotTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSRobotTypeBase.getUpdateMan());
        }
        if (pSRobotTypeBase.isUserTagDirty() && (bl || pSRobotTypeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSRobotTypeBase.getUserTag());
        }
        if (pSRobotTypeBase.isUserTag2Dirty() && (bl || pSRobotTypeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSRobotTypeBase.getUserTag2());
        }
        if (pSRobotTypeBase.isValidFlagDirty() && (bl || pSRobotTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSRobotTypeBase.getValidFlag());
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
        return PSRobotTypeBase.remove(this, n);
    }

    private static boolean remove(PSRobotTypeBase pSRobotTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSRobotTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSRobotTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSRobotTypeBase.resetMaxEnergy();
                return true;
            }
            case 3: {
                pSRobotTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSRobotTypeBase.resetPSRobotTypeId();
                return true;
            }
            case 5: {
                pSRobotTypeBase.resetPSRobotTypeName();
                return true;
            }
            case 6: {
                pSRobotTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSRobotTypeBase.resetUpdateMan();
                return true;
            }
            case 8: {
                pSRobotTypeBase.resetUserTag();
                return true;
            }
            case 9: {
                pSRobotTypeBase.resetUserTag2();
                return true;
            }
            case 10: {
                pSRobotTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSRobotTypeBase getProxyEntity() {
        return this.proxyPSRobotTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSRobotTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSRobotTypeBase) {
            this.proxyPSRobotTypeBase = (PSRobotTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSRobotTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MAXENERGY, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSROBOTTYPEID, 4);
        fieldIndexMap.put(FIELD_PSROBOTTYPENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_USERTAG, 8);
        fieldIndexMap.put(FIELD_USERTAG2, 9);
        fieldIndexMap.put(FIELD_VALIDFLAG, 10);
    }
}

