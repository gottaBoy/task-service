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

public abstract class PSChartTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSChartTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLOBJ = "CTRLOBJ";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCHARTTYPEID = "PSCHARTTYPEID";
    public static final String FIELD_PSCHARTTYPENAME = "PSCHARTTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CTRLOBJ = 2;
    private static final int INDEX_ENABLE = 3;
    private static final int INDEX_ICONPATH = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSCHARTTYPEID = 6;
    private static final int INDEX_PSCHARTTYPENAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_VALIDFLAG = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSChartTypeBase proxyPSChartTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlobjDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pscharttypeidDirtyFlag = false;
    private boolean pscharttypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrlobj")
    private String ctrlobj;
    @Column(name="enable")
    private Integer enable;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="memo")
    private String memo;
    @Column(name="pscharttypeid")
    private String pscharttypeid;
    @Column(name="pscharttypename")
    private String pscharttypename;
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

    public void setCtrlObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlobj = string;
        this.ctrlobjDirtyFlag = true;
    }

    public String getCtrlObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlObj();
        }
        return this.ctrlobj;
    }

    public boolean isCtrlObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlObjDirty();
        }
        return this.ctrlobjDirtyFlag;
    }

    public void resetCtrlObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlObj();
            return;
        }
        this.ctrlobjDirtyFlag = false;
        this.ctrlobj = null;
    }

    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
    }

    public void setIconPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpath = string;
        this.iconpathDirtyFlag = true;
    }

    public String getIconPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPath();
        }
        return this.iconpath;
    }

    public boolean isIconPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathDirty();
        }
        return this.iconpathDirtyFlag;
    }

    public void resetIconPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPath();
            return;
        }
        this.iconpathDirtyFlag = false;
        this.iconpath = null;
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

    public void setPSChartTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSChartTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscharttypeid = string;
        this.pscharttypeidDirtyFlag = true;
    }

    public String getPSChartTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSChartTypeId();
        }
        return this.pscharttypeid;
    }

    public boolean isPSChartTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSChartTypeIdDirty();
        }
        return this.pscharttypeidDirtyFlag;
    }

    public void resetPSChartTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSChartTypeId();
            return;
        }
        this.pscharttypeidDirtyFlag = false;
        this.pscharttypeid = null;
    }

    public void setPSChartTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSChartTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscharttypename = string;
        this.pscharttypenameDirtyFlag = true;
    }

    public String getPSChartTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSChartTypeName();
        }
        return this.pscharttypename;
    }

    public boolean isPSChartTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSChartTypeNameDirty();
        }
        return this.pscharttypenameDirtyFlag;
    }

    public void resetPSChartTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSChartTypeName();
            return;
        }
        this.pscharttypenameDirtyFlag = false;
        this.pscharttypename = null;
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
        PSChartTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSChartTypeBase pSChartTypeBase) {
        pSChartTypeBase.resetCreateDate();
        pSChartTypeBase.resetCreateMan();
        pSChartTypeBase.resetCtrlObj();
        pSChartTypeBase.resetEnable();
        pSChartTypeBase.resetIconPath();
        pSChartTypeBase.resetMemo();
        pSChartTypeBase.resetPSChartTypeId();
        pSChartTypeBase.resetPSChartTypeName();
        pSChartTypeBase.resetUpdateDate();
        pSChartTypeBase.resetUpdateMan();
        pSChartTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlObjDirty()) {
            hashMap.put(FIELD_CTRLOBJ, this.getCtrlObj());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSChartTypeIdDirty()) {
            hashMap.put(FIELD_PSCHARTTYPEID, this.getPSChartTypeId());
        }
        if (!bl || this.isPSChartTypeNameDirty()) {
            hashMap.put(FIELD_PSCHARTTYPENAME, this.getPSChartTypeName());
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
        return PSChartTypeBase.get(this, n);
    }

    private static Object get(PSChartTypeBase pSChartTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSChartTypeBase.getCreateDate();
            }
            case 1: {
                return pSChartTypeBase.getCreateMan();
            }
            case 2: {
                return pSChartTypeBase.getCtrlObj();
            }
            case 3: {
                return pSChartTypeBase.getEnable();
            }
            case 4: {
                return pSChartTypeBase.getIconPath();
            }
            case 5: {
                return pSChartTypeBase.getMemo();
            }
            case 6: {
                return pSChartTypeBase.getPSChartTypeId();
            }
            case 7: {
                return pSChartTypeBase.getPSChartTypeName();
            }
            case 8: {
                return pSChartTypeBase.getUpdateDate();
            }
            case 9: {
                return pSChartTypeBase.getUpdateMan();
            }
            case 10: {
                return pSChartTypeBase.getValidFlag();
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
        PSChartTypeBase.set(this, n, object);
    }

    private static void set(PSChartTypeBase pSChartTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSChartTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSChartTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSChartTypeBase.setCtrlObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSChartTypeBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSChartTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSChartTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSChartTypeBase.setPSChartTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSChartTypeBase.setPSChartTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSChartTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSChartTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSChartTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSChartTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSChartTypeBase pSChartTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSChartTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSChartTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSChartTypeBase.getCtrlObj() == null;
            }
            case 3: {
                return pSChartTypeBase.getEnable() == null;
            }
            case 4: {
                return pSChartTypeBase.getIconPath() == null;
            }
            case 5: {
                return pSChartTypeBase.getMemo() == null;
            }
            case 6: {
                return pSChartTypeBase.getPSChartTypeId() == null;
            }
            case 7: {
                return pSChartTypeBase.getPSChartTypeName() == null;
            }
            case 8: {
                return pSChartTypeBase.getUpdateDate() == null;
            }
            case 9: {
                return pSChartTypeBase.getUpdateMan() == null;
            }
            case 10: {
                return pSChartTypeBase.getValidFlag() == null;
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
        return PSChartTypeBase.contains(this, n);
    }

    private static boolean contains(PSChartTypeBase pSChartTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSChartTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSChartTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSChartTypeBase.isCtrlObjDirty();
            }
            case 3: {
                return pSChartTypeBase.isEnableDirty();
            }
            case 4: {
                return pSChartTypeBase.isIconPathDirty();
            }
            case 5: {
                return pSChartTypeBase.isMemoDirty();
            }
            case 6: {
                return pSChartTypeBase.isPSChartTypeIdDirty();
            }
            case 7: {
                return pSChartTypeBase.isPSChartTypeNameDirty();
            }
            case 8: {
                return pSChartTypeBase.isUpdateDateDirty();
            }
            case 9: {
                return pSChartTypeBase.isUpdateManDirty();
            }
            case 10: {
                return pSChartTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSChartTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSChartTypeBase pSChartTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSChartTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSChartTypeBase.getJSONValue((Object)pSChartTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSChartTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSChartTypeBase.getJSONValue((Object)pSChartTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSChartTypeBase.getCtrlObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlobj", (Object)PSChartTypeBase.getJSONValue((Object)pSChartTypeBase.getCtrlObj()), (boolean)false);
        }
        if (bl || pSChartTypeBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSChartTypeBase.getJSONValue((Object)pSChartTypeBase.getEnable()), (boolean)false);
        }
        if (bl || pSChartTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSChartTypeBase.getJSONValue((Object)pSChartTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSChartTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSChartTypeBase.getJSONValue((Object)pSChartTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSChartTypeBase.getPSChartTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscharttypeid", (Object)PSChartTypeBase.getJSONValue((Object)pSChartTypeBase.getPSChartTypeId()), (boolean)false);
        }
        if (bl || pSChartTypeBase.getPSChartTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscharttypename", (Object)PSChartTypeBase.getJSONValue((Object)pSChartTypeBase.getPSChartTypeName()), (boolean)false);
        }
        if (bl || pSChartTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSChartTypeBase.getJSONValue((Object)pSChartTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSChartTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSChartTypeBase.getJSONValue((Object)pSChartTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSChartTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSChartTypeBase.getJSONValue((Object)pSChartTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSChartTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSChartTypeBase pSChartTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSChartTypeBase.getCreateDate() != null) {
            object = pSChartTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSChartTypeBase.getCreateMan() != null) {
            object = pSChartTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSChartTypeBase.getCtrlObj() != null) {
            object = pSChartTypeBase.getCtrlObj();
            xmlNode.setAttribute(FIELD_CTRLOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSChartTypeBase.getEnable() != null) {
            object = pSChartTypeBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSChartTypeBase.getIconPath() != null) {
            object = pSChartTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSChartTypeBase.getMemo() != null) {
            object = pSChartTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSChartTypeBase.getPSChartTypeId() != null) {
            object = pSChartTypeBase.getPSChartTypeId();
            xmlNode.setAttribute(FIELD_PSCHARTTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSChartTypeBase.getPSChartTypeName() != null) {
            object = pSChartTypeBase.getPSChartTypeName();
            xmlNode.setAttribute(FIELD_PSCHARTTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSChartTypeBase.getUpdateDate() != null) {
            object = pSChartTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSChartTypeBase.getUpdateMan() != null) {
            object = pSChartTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSChartTypeBase.getValidFlag() != null) {
            object = pSChartTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSChartTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSChartTypeBase pSChartTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSChartTypeBase.isCreateDateDirty() && (bl || pSChartTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSChartTypeBase.getCreateDate());
        }
        if (pSChartTypeBase.isCreateManDirty() && (bl || pSChartTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSChartTypeBase.getCreateMan());
        }
        if (pSChartTypeBase.isCtrlObjDirty() && (bl || pSChartTypeBase.getCtrlObj() != null)) {
            iDataObject.set(FIELD_CTRLOBJ, (Object)pSChartTypeBase.getCtrlObj());
        }
        if (pSChartTypeBase.isEnableDirty() && (bl || pSChartTypeBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSChartTypeBase.getEnable());
        }
        if (pSChartTypeBase.isIconPathDirty() && (bl || pSChartTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSChartTypeBase.getIconPath());
        }
        if (pSChartTypeBase.isMemoDirty() && (bl || pSChartTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSChartTypeBase.getMemo());
        }
        if (pSChartTypeBase.isPSChartTypeIdDirty() && (bl || pSChartTypeBase.getPSChartTypeId() != null)) {
            iDataObject.set(FIELD_PSCHARTTYPEID, (Object)pSChartTypeBase.getPSChartTypeId());
        }
        if (pSChartTypeBase.isPSChartTypeNameDirty() && (bl || pSChartTypeBase.getPSChartTypeName() != null)) {
            iDataObject.set(FIELD_PSCHARTTYPENAME, (Object)pSChartTypeBase.getPSChartTypeName());
        }
        if (pSChartTypeBase.isUpdateDateDirty() && (bl || pSChartTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSChartTypeBase.getUpdateDate());
        }
        if (pSChartTypeBase.isUpdateManDirty() && (bl || pSChartTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSChartTypeBase.getUpdateMan());
        }
        if (pSChartTypeBase.isValidFlagDirty() && (bl || pSChartTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSChartTypeBase.getValidFlag());
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
        return PSChartTypeBase.remove(this, n);
    }

    private static boolean remove(PSChartTypeBase pSChartTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSChartTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSChartTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSChartTypeBase.resetCtrlObj();
                return true;
            }
            case 3: {
                pSChartTypeBase.resetEnable();
                return true;
            }
            case 4: {
                pSChartTypeBase.resetIconPath();
                return true;
            }
            case 5: {
                pSChartTypeBase.resetMemo();
                return true;
            }
            case 6: {
                pSChartTypeBase.resetPSChartTypeId();
                return true;
            }
            case 7: {
                pSChartTypeBase.resetPSChartTypeName();
                return true;
            }
            case 8: {
                pSChartTypeBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSChartTypeBase.resetUpdateMan();
                return true;
            }
            case 10: {
                pSChartTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSChartTypeBase getProxyEntity() {
        return this.proxyPSChartTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSChartTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSChartTypeBase) {
            this.proxyPSChartTypeBase = (PSChartTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSChartTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CTRLOBJ, 2);
        fieldIndexMap.put(FIELD_ENABLE, 3);
        fieldIndexMap.put(FIELD_ICONPATH, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSCHARTTYPEID, 6);
        fieldIndexMap.put(FIELD_PSCHARTTYPENAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_VALIDFLAG, 10);
    }
}

