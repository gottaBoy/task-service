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

public abstract class PSPanelLNTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPanelLNTypeBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_ITEMOBJ = "ITEMOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSPANELLNTYPEID = "PSPANELLNTYPEID";
    public static final String FIELD_PSPANELLNTYPENAME = "PSPANELLNTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ICONPATH = 3;
    private static final int INDEX_ITEMOBJ = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSPANELLNTYPEID = 7;
    private static final int INDEX_PSPANELLNTYPENAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPanelLNTypeBase proxyPSPanelLNTypeBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean itemobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pspanellntypeidDirtyFlag = false;
    private boolean pspanellntypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="itemobj")
    private String itemobj;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pspanellntypeid")
    private String pspanellntypeid;
    @Column(name="pspanellntypename")
    private String pspanellntypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setItemObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemobj = string;
        this.itemobjDirtyFlag = true;
    }

    public String getItemObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemObj();
        }
        return this.itemobj;
    }

    public boolean isItemObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemObjDirty();
        }
        return this.itemobjDirtyFlag;
    }

    public void resetItemObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemObj();
            return;
        }
        this.itemobjDirtyFlag = false;
        this.itemobj = null;
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

    public void setPSPanelLNTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLNTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellntypeid = string;
        this.pspanellntypeidDirtyFlag = true;
    }

    public String getPSPanelLNTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLNTypeId();
        }
        return this.pspanellntypeid;
    }

    public boolean isPSPanelLNTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLNTypeIdDirty();
        }
        return this.pspanellntypeidDirtyFlag;
    }

    public void resetPSPanelLNTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLNTypeId();
            return;
        }
        this.pspanellntypeidDirtyFlag = false;
        this.pspanellntypeid = null;
    }

    public void setPSPanelLNTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLNTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellntypename = string;
        this.pspanellntypenameDirtyFlag = true;
    }

    public String getPSPanelLNTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLNTypeName();
        }
        return this.pspanellntypename;
    }

    public boolean isPSPanelLNTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLNTypeNameDirty();
        }
        return this.pspanellntypenameDirtyFlag;
    }

    public void resetPSPanelLNTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLNTypeName();
            return;
        }
        this.pspanellntypenameDirtyFlag = false;
        this.pspanellntypename = null;
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
        PSPanelLNTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPanelLNTypeBase pSPanelLNTypeBase) {
        pSPanelLNTypeBase.resetCodeName();
        pSPanelLNTypeBase.resetCreateDate();
        pSPanelLNTypeBase.resetCreateMan();
        pSPanelLNTypeBase.resetIconPath();
        pSPanelLNTypeBase.resetItemObj();
        pSPanelLNTypeBase.resetMemo();
        pSPanelLNTypeBase.resetOrderValue();
        pSPanelLNTypeBase.resetPSPanelLNTypeId();
        pSPanelLNTypeBase.resetPSPanelLNTypeName();
        pSPanelLNTypeBase.resetUpdateDate();
        pSPanelLNTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isItemObjDirty()) {
            hashMap.put(FIELD_ITEMOBJ, this.getItemObj());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSPanelLNTypeIdDirty()) {
            hashMap.put(FIELD_PSPANELLNTYPEID, this.getPSPanelLNTypeId());
        }
        if (!bl || this.isPSPanelLNTypeNameDirty()) {
            hashMap.put(FIELD_PSPANELLNTYPENAME, this.getPSPanelLNTypeName());
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
        return PSPanelLNTypeBase.get(this, n);
    }

    private static Object get(PSPanelLNTypeBase pSPanelLNTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLNTypeBase.getCodeName();
            }
            case 1: {
                return pSPanelLNTypeBase.getCreateDate();
            }
            case 2: {
                return pSPanelLNTypeBase.getCreateMan();
            }
            case 3: {
                return pSPanelLNTypeBase.getIconPath();
            }
            case 4: {
                return pSPanelLNTypeBase.getItemObj();
            }
            case 5: {
                return pSPanelLNTypeBase.getMemo();
            }
            case 6: {
                return pSPanelLNTypeBase.getOrderValue();
            }
            case 7: {
                return pSPanelLNTypeBase.getPSPanelLNTypeId();
            }
            case 8: {
                return pSPanelLNTypeBase.getPSPanelLNTypeName();
            }
            case 9: {
                return pSPanelLNTypeBase.getUpdateDate();
            }
            case 10: {
                return pSPanelLNTypeBase.getUpdateMan();
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
        PSPanelLNTypeBase.set(this, n, object);
    }

    private static void set(PSPanelLNTypeBase pSPanelLNTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLNTypeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPanelLNTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSPanelLNTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPanelLNTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPanelLNTypeBase.setItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPanelLNTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPanelLNTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSPanelLNTypeBase.setPSPanelLNTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPanelLNTypeBase.setPSPanelLNTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPanelLNTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSPanelLNTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPanelLNTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSPanelLNTypeBase pSPanelLNTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLNTypeBase.getCodeName() == null;
            }
            case 1: {
                return pSPanelLNTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSPanelLNTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSPanelLNTypeBase.getIconPath() == null;
            }
            case 4: {
                return pSPanelLNTypeBase.getItemObj() == null;
            }
            case 5: {
                return pSPanelLNTypeBase.getMemo() == null;
            }
            case 6: {
                return pSPanelLNTypeBase.getOrderValue() == null;
            }
            case 7: {
                return pSPanelLNTypeBase.getPSPanelLNTypeId() == null;
            }
            case 8: {
                return pSPanelLNTypeBase.getPSPanelLNTypeName() == null;
            }
            case 9: {
                return pSPanelLNTypeBase.getUpdateDate() == null;
            }
            case 10: {
                return pSPanelLNTypeBase.getUpdateMan() == null;
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
        return PSPanelLNTypeBase.contains(this, n);
    }

    private static boolean contains(PSPanelLNTypeBase pSPanelLNTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLNTypeBase.isCodeNameDirty();
            }
            case 1: {
                return pSPanelLNTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSPanelLNTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSPanelLNTypeBase.isIconPathDirty();
            }
            case 4: {
                return pSPanelLNTypeBase.isItemObjDirty();
            }
            case 5: {
                return pSPanelLNTypeBase.isMemoDirty();
            }
            case 6: {
                return pSPanelLNTypeBase.isOrderValueDirty();
            }
            case 7: {
                return pSPanelLNTypeBase.isPSPanelLNTypeIdDirty();
            }
            case 8: {
                return pSPanelLNTypeBase.isPSPanelLNTypeNameDirty();
            }
            case 9: {
                return pSPanelLNTypeBase.isUpdateDateDirty();
            }
            case 10: {
                return pSPanelLNTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPanelLNTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPanelLNTypeBase pSPanelLNTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPanelLNTypeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSPanelLNTypeBase.getJSONValue((Object)pSPanelLNTypeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSPanelLNTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPanelLNTypeBase.getJSONValue((Object)pSPanelLNTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPanelLNTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPanelLNTypeBase.getJSONValue((Object)pSPanelLNTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPanelLNTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSPanelLNTypeBase.getJSONValue((Object)pSPanelLNTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSPanelLNTypeBase.getItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemobj", (Object)PSPanelLNTypeBase.getJSONValue((Object)pSPanelLNTypeBase.getItemObj()), (boolean)false);
        }
        if (bl || pSPanelLNTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPanelLNTypeBase.getJSONValue((Object)pSPanelLNTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSPanelLNTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSPanelLNTypeBase.getJSONValue((Object)pSPanelLNTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSPanelLNTypeBase.getPSPanelLNTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellntypeid", (Object)PSPanelLNTypeBase.getJSONValue((Object)pSPanelLNTypeBase.getPSPanelLNTypeId()), (boolean)false);
        }
        if (bl || pSPanelLNTypeBase.getPSPanelLNTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellntypename", (Object)PSPanelLNTypeBase.getJSONValue((Object)pSPanelLNTypeBase.getPSPanelLNTypeName()), (boolean)false);
        }
        if (bl || pSPanelLNTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPanelLNTypeBase.getJSONValue((Object)pSPanelLNTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPanelLNTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPanelLNTypeBase.getJSONValue((Object)pSPanelLNTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPanelLNTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPanelLNTypeBase pSPanelLNTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPanelLNTypeBase.getCodeName() != null) {
            object = pSPanelLNTypeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNTypeBase.getCreateDate() != null) {
            object = pSPanelLNTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLNTypeBase.getCreateMan() != null) {
            object = pSPanelLNTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNTypeBase.getIconPath() != null) {
            object = pSPanelLNTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNTypeBase.getItemObj() != null) {
            object = pSPanelLNTypeBase.getItemObj();
            xmlNode.setAttribute(FIELD_ITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNTypeBase.getMemo() != null) {
            object = pSPanelLNTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNTypeBase.getOrderValue() != null) {
            object = pSPanelLNTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelLNTypeBase.getPSPanelLNTypeId() != null) {
            object = pSPanelLNTypeBase.getPSPanelLNTypeId();
            xmlNode.setAttribute(FIELD_PSPANELLNTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNTypeBase.getPSPanelLNTypeName() != null) {
            object = pSPanelLNTypeBase.getPSPanelLNTypeName();
            xmlNode.setAttribute(FIELD_PSPANELLNTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNTypeBase.getUpdateDate() != null) {
            object = pSPanelLNTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLNTypeBase.getUpdateMan() != null) {
            object = pSPanelLNTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPanelLNTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPanelLNTypeBase pSPanelLNTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPanelLNTypeBase.isCodeNameDirty() && (bl || pSPanelLNTypeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSPanelLNTypeBase.getCodeName());
        }
        if (pSPanelLNTypeBase.isCreateDateDirty() && (bl || pSPanelLNTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPanelLNTypeBase.getCreateDate());
        }
        if (pSPanelLNTypeBase.isCreateManDirty() && (bl || pSPanelLNTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPanelLNTypeBase.getCreateMan());
        }
        if (pSPanelLNTypeBase.isIconPathDirty() && (bl || pSPanelLNTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSPanelLNTypeBase.getIconPath());
        }
        if (pSPanelLNTypeBase.isItemObjDirty() && (bl || pSPanelLNTypeBase.getItemObj() != null)) {
            iDataObject.set(FIELD_ITEMOBJ, (Object)pSPanelLNTypeBase.getItemObj());
        }
        if (pSPanelLNTypeBase.isMemoDirty() && (bl || pSPanelLNTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPanelLNTypeBase.getMemo());
        }
        if (pSPanelLNTypeBase.isOrderValueDirty() && (bl || pSPanelLNTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSPanelLNTypeBase.getOrderValue());
        }
        if (pSPanelLNTypeBase.isPSPanelLNTypeIdDirty() && (bl || pSPanelLNTypeBase.getPSPanelLNTypeId() != null)) {
            iDataObject.set(FIELD_PSPANELLNTYPEID, (Object)pSPanelLNTypeBase.getPSPanelLNTypeId());
        }
        if (pSPanelLNTypeBase.isPSPanelLNTypeNameDirty() && (bl || pSPanelLNTypeBase.getPSPanelLNTypeName() != null)) {
            iDataObject.set(FIELD_PSPANELLNTYPENAME, (Object)pSPanelLNTypeBase.getPSPanelLNTypeName());
        }
        if (pSPanelLNTypeBase.isUpdateDateDirty() && (bl || pSPanelLNTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPanelLNTypeBase.getUpdateDate());
        }
        if (pSPanelLNTypeBase.isUpdateManDirty() && (bl || pSPanelLNTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPanelLNTypeBase.getUpdateMan());
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
        return PSPanelLNTypeBase.remove(this, n);
    }

    private static boolean remove(PSPanelLNTypeBase pSPanelLNTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLNTypeBase.resetCodeName();
                return true;
            }
            case 1: {
                pSPanelLNTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSPanelLNTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSPanelLNTypeBase.resetIconPath();
                return true;
            }
            case 4: {
                pSPanelLNTypeBase.resetItemObj();
                return true;
            }
            case 5: {
                pSPanelLNTypeBase.resetMemo();
                return true;
            }
            case 6: {
                pSPanelLNTypeBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSPanelLNTypeBase.resetPSPanelLNTypeId();
                return true;
            }
            case 8: {
                pSPanelLNTypeBase.resetPSPanelLNTypeName();
                return true;
            }
            case 9: {
                pSPanelLNTypeBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSPanelLNTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSPanelLNTypeBase getProxyEntity() {
        return this.proxyPSPanelLNTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPanelLNTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSPanelLNTypeBase) {
            this.proxyPSPanelLNTypeBase = (PSPanelLNTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPanelLNTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ICONPATH, 3);
        fieldIndexMap.put(FIELD_ITEMOBJ, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSPANELLNTYPEID, 7);
        fieldIndexMap.put(FIELD_PSPANELLNTYPENAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

