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

public abstract class PSDERTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDERTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEROBJ = "DEROBJ";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDERTYPEID = "PSDERTYPEID";
    public static final String FIELD_PSDERTYPENAME = "PSDERTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEROBJ = 2;
    private static final int INDEX_ICONPATH = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSDERTYPEID = 6;
    private static final int INDEX_PSDERTYPENAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_VALIDFLAG = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDERTypeBase proxyPSDERTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean derobjDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdertypeidDirtyFlag = false;
    private boolean psdertypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="derobj")
    private String derobj;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdertypeid")
    private String psdertypeid;
    @Column(name="psdertypename")
    private String psdertypename;
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

    public void setDERObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDERObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.derobj = string;
        this.derobjDirtyFlag = true;
    }

    public String getDERObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDERObj();
        }
        return this.derobj;
    }

    public boolean isDERObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDERObjDirty();
        }
        return this.derobjDirtyFlag;
    }

    public void resetDERObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDERObj();
            return;
        }
        this.derobjDirtyFlag = false;
        this.derobj = null;
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

    public void setPSDERTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdertypeid = string;
        this.psdertypeidDirtyFlag = true;
    }

    public String getPSDERTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERTypeId();
        }
        return this.psdertypeid;
    }

    public boolean isPSDERTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERTypeIdDirty();
        }
        return this.psdertypeidDirtyFlag;
    }

    public void resetPSDERTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERTypeId();
            return;
        }
        this.psdertypeidDirtyFlag = false;
        this.psdertypeid = null;
    }

    public void setPSDERTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdertypename = string;
        this.psdertypenameDirtyFlag = true;
    }

    public String getPSDERTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERTypeName();
        }
        return this.psdertypename;
    }

    public boolean isPSDERTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERTypeNameDirty();
        }
        return this.psdertypenameDirtyFlag;
    }

    public void resetPSDERTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERTypeName();
            return;
        }
        this.psdertypenameDirtyFlag = false;
        this.psdertypename = null;
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
        PSDERTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDERTypeBase pSDERTypeBase) {
        pSDERTypeBase.resetCreateDate();
        pSDERTypeBase.resetCreateMan();
        pSDERTypeBase.resetDERObj();
        pSDERTypeBase.resetIconPath();
        pSDERTypeBase.resetMemo();
        pSDERTypeBase.resetOrderValue();
        pSDERTypeBase.resetPSDERTypeId();
        pSDERTypeBase.resetPSDERTypeName();
        pSDERTypeBase.resetUpdateDate();
        pSDERTypeBase.resetUpdateMan();
        pSDERTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDERObjDirty()) {
            hashMap.put(FIELD_DEROBJ, this.getDERObj());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDERTypeIdDirty()) {
            hashMap.put(FIELD_PSDERTYPEID, this.getPSDERTypeId());
        }
        if (!bl || this.isPSDERTypeNameDirty()) {
            hashMap.put(FIELD_PSDERTYPENAME, this.getPSDERTypeName());
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
        return PSDERTypeBase.get(this, n);
    }

    private static Object get(PSDERTypeBase pSDERTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERTypeBase.getCreateDate();
            }
            case 1: {
                return pSDERTypeBase.getCreateMan();
            }
            case 2: {
                return pSDERTypeBase.getDERObj();
            }
            case 3: {
                return pSDERTypeBase.getIconPath();
            }
            case 4: {
                return pSDERTypeBase.getMemo();
            }
            case 5: {
                return pSDERTypeBase.getOrderValue();
            }
            case 6: {
                return pSDERTypeBase.getPSDERTypeId();
            }
            case 7: {
                return pSDERTypeBase.getPSDERTypeName();
            }
            case 8: {
                return pSDERTypeBase.getUpdateDate();
            }
            case 9: {
                return pSDERTypeBase.getUpdateMan();
            }
            case 10: {
                return pSDERTypeBase.getValidFlag();
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
        PSDERTypeBase.set(this, n, object);
    }

    private static void set(PSDERTypeBase pSDERTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDERTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDERTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDERTypeBase.setDERObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDERTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDERTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDERTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDERTypeBase.setPSDERTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDERTypeBase.setPSDERTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDERTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDERTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDERTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDERTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDERTypeBase pSDERTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDERTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDERTypeBase.getDERObj() == null;
            }
            case 3: {
                return pSDERTypeBase.getIconPath() == null;
            }
            case 4: {
                return pSDERTypeBase.getMemo() == null;
            }
            case 5: {
                return pSDERTypeBase.getOrderValue() == null;
            }
            case 6: {
                return pSDERTypeBase.getPSDERTypeId() == null;
            }
            case 7: {
                return pSDERTypeBase.getPSDERTypeName() == null;
            }
            case 8: {
                return pSDERTypeBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDERTypeBase.getUpdateMan() == null;
            }
            case 10: {
                return pSDERTypeBase.getValidFlag() == null;
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
        return PSDERTypeBase.contains(this, n);
    }

    private static boolean contains(PSDERTypeBase pSDERTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDERTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDERTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDERTypeBase.isDERObjDirty();
            }
            case 3: {
                return pSDERTypeBase.isIconPathDirty();
            }
            case 4: {
                return pSDERTypeBase.isMemoDirty();
            }
            case 5: {
                return pSDERTypeBase.isOrderValueDirty();
            }
            case 6: {
                return pSDERTypeBase.isPSDERTypeIdDirty();
            }
            case 7: {
                return pSDERTypeBase.isPSDERTypeNameDirty();
            }
            case 8: {
                return pSDERTypeBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDERTypeBase.isUpdateManDirty();
            }
            case 10: {
                return pSDERTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDERTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDERTypeBase pSDERTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDERTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDERTypeBase.getJSONValue((Object)pSDERTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDERTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDERTypeBase.getJSONValue((Object)pSDERTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDERTypeBase.getDERObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"derobj", (Object)PSDERTypeBase.getJSONValue((Object)pSDERTypeBase.getDERObj()), (boolean)false);
        }
        if (bl || pSDERTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSDERTypeBase.getJSONValue((Object)pSDERTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSDERTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDERTypeBase.getJSONValue((Object)pSDERTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDERTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDERTypeBase.getJSONValue((Object)pSDERTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDERTypeBase.getPSDERTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdertypeid", (Object)PSDERTypeBase.getJSONValue((Object)pSDERTypeBase.getPSDERTypeId()), (boolean)false);
        }
        if (bl || pSDERTypeBase.getPSDERTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdertypename", (Object)PSDERTypeBase.getJSONValue((Object)pSDERTypeBase.getPSDERTypeName()), (boolean)false);
        }
        if (bl || pSDERTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDERTypeBase.getJSONValue((Object)pSDERTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDERTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDERTypeBase.getJSONValue((Object)pSDERTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDERTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDERTypeBase.getJSONValue((Object)pSDERTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDERTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDERTypeBase pSDERTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDERTypeBase.getCreateDate() != null) {
            object = pSDERTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERTypeBase.getCreateMan() != null) {
            object = pSDERTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERTypeBase.getDERObj() != null) {
            object = pSDERTypeBase.getDERObj();
            xmlNode.setAttribute(FIELD_DEROBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDERTypeBase.getIconPath() != null) {
            object = pSDERTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDERTypeBase.getMemo() != null) {
            object = pSDERTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDERTypeBase.getOrderValue() != null) {
            object = pSDERTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDERTypeBase.getPSDERTypeId() != null) {
            object = pSDERTypeBase.getPSDERTypeId();
            xmlNode.setAttribute(FIELD_PSDERTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDERTypeBase.getPSDERTypeName() != null) {
            object = pSDERTypeBase.getPSDERTypeName();
            xmlNode.setAttribute(FIELD_PSDERTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDERTypeBase.getUpdateDate() != null) {
            object = pSDERTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDERTypeBase.getUpdateMan() != null) {
            object = pSDERTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDERTypeBase.getValidFlag() != null) {
            object = pSDERTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDERTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDERTypeBase pSDERTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDERTypeBase.isCreateDateDirty() && (bl || pSDERTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDERTypeBase.getCreateDate());
        }
        if (pSDERTypeBase.isCreateManDirty() && (bl || pSDERTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDERTypeBase.getCreateMan());
        }
        if (pSDERTypeBase.isDERObjDirty() && (bl || pSDERTypeBase.getDERObj() != null)) {
            iDataObject.set(FIELD_DEROBJ, (Object)pSDERTypeBase.getDERObj());
        }
        if (pSDERTypeBase.isIconPathDirty() && (bl || pSDERTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSDERTypeBase.getIconPath());
        }
        if (pSDERTypeBase.isMemoDirty() && (bl || pSDERTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDERTypeBase.getMemo());
        }
        if (pSDERTypeBase.isOrderValueDirty() && (bl || pSDERTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDERTypeBase.getOrderValue());
        }
        if (pSDERTypeBase.isPSDERTypeIdDirty() && (bl || pSDERTypeBase.getPSDERTypeId() != null)) {
            iDataObject.set(FIELD_PSDERTYPEID, (Object)pSDERTypeBase.getPSDERTypeId());
        }
        if (pSDERTypeBase.isPSDERTypeNameDirty() && (bl || pSDERTypeBase.getPSDERTypeName() != null)) {
            iDataObject.set(FIELD_PSDERTYPENAME, (Object)pSDERTypeBase.getPSDERTypeName());
        }
        if (pSDERTypeBase.isUpdateDateDirty() && (bl || pSDERTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDERTypeBase.getUpdateDate());
        }
        if (pSDERTypeBase.isUpdateManDirty() && (bl || pSDERTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDERTypeBase.getUpdateMan());
        }
        if (pSDERTypeBase.isValidFlagDirty() && (bl || pSDERTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDERTypeBase.getValidFlag());
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
        return PSDERTypeBase.remove(this, n);
    }

    private static boolean remove(PSDERTypeBase pSDERTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDERTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDERTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDERTypeBase.resetDERObj();
                return true;
            }
            case 3: {
                pSDERTypeBase.resetIconPath();
                return true;
            }
            case 4: {
                pSDERTypeBase.resetMemo();
                return true;
            }
            case 5: {
                pSDERTypeBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSDERTypeBase.resetPSDERTypeId();
                return true;
            }
            case 7: {
                pSDERTypeBase.resetPSDERTypeName();
                return true;
            }
            case 8: {
                pSDERTypeBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDERTypeBase.resetUpdateMan();
                return true;
            }
            case 10: {
                pSDERTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDERTypeBase getProxyEntity() {
        return this.proxyPSDERTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDERTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDERTypeBase) {
            this.proxyPSDERTypeBase = (PSDERTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDERTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEROBJ, 2);
        fieldIndexMap.put(FIELD_ICONPATH, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PSDERTYPEID, 6);
        fieldIndexMap.put(FIELD_PSDERTYPENAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_VALIDFLAG, 10);
    }
}

