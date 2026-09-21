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

public abstract class PSDEJoinTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEJoinTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_MAINFLAG = "MAINFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEJOINTYPEID = "PSDEJOINTYPEID";
    public static final String FIELD_PSDEJOINTYPENAME = "PSDEJOINTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ICONPATH = 2;
    private static final int INDEX_MAINFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSDEJOINTYPEID = 6;
    private static final int INDEX_PSDEJOINTYPENAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_VALIDFLAG = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEJoinTypeBase proxyPSDEJoinTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean mainflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdejointypeidDirtyFlag = false;
    private boolean psdejointypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="mainflag")
    private Integer mainflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdejointypeid")
    private String psdejointypeid;
    @Column(name="psdejointypename")
    private String psdejointypename;
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

    public void setMainFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainFlag(n);
            return;
        }
        this.mainflag = n;
        this.mainflagDirtyFlag = true;
    }

    public Integer getMainFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainFlag();
        }
        return this.mainflag;
    }

    public boolean isMainFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainFlagDirty();
        }
        return this.mainflagDirtyFlag;
    }

    public void resetMainFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainFlag();
            return;
        }
        this.mainflagDirtyFlag = false;
        this.mainflag = null;
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

    public void setPSDEJoinTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEJoinTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdejointypeid = string;
        this.psdejointypeidDirtyFlag = true;
    }

    public String getPSDEJoinTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEJoinTypeId();
        }
        return this.psdejointypeid;
    }

    public boolean isPSDEJoinTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEJoinTypeIdDirty();
        }
        return this.psdejointypeidDirtyFlag;
    }

    public void resetPSDEJoinTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEJoinTypeId();
            return;
        }
        this.psdejointypeidDirtyFlag = false;
        this.psdejointypeid = null;
    }

    public void setPSDEJoinTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEJoinTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdejointypename = string;
        this.psdejointypenameDirtyFlag = true;
    }

    public String getPSDEJoinTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEJoinTypeName();
        }
        return this.psdejointypename;
    }

    public boolean isPSDEJoinTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEJoinTypeNameDirty();
        }
        return this.psdejointypenameDirtyFlag;
    }

    public void resetPSDEJoinTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEJoinTypeName();
            return;
        }
        this.psdejointypenameDirtyFlag = false;
        this.psdejointypename = null;
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
        PSDEJoinTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEJoinTypeBase pSDEJoinTypeBase) {
        pSDEJoinTypeBase.resetCreateDate();
        pSDEJoinTypeBase.resetCreateMan();
        pSDEJoinTypeBase.resetIconPath();
        pSDEJoinTypeBase.resetMainFlag();
        pSDEJoinTypeBase.resetMemo();
        pSDEJoinTypeBase.resetOrderValue();
        pSDEJoinTypeBase.resetPSDEJoinTypeId();
        pSDEJoinTypeBase.resetPSDEJoinTypeName();
        pSDEJoinTypeBase.resetUpdateDate();
        pSDEJoinTypeBase.resetUpdateMan();
        pSDEJoinTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isMainFlagDirty()) {
            hashMap.put(FIELD_MAINFLAG, this.getMainFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEJoinTypeIdDirty()) {
            hashMap.put(FIELD_PSDEJOINTYPEID, this.getPSDEJoinTypeId());
        }
        if (!bl || this.isPSDEJoinTypeNameDirty()) {
            hashMap.put(FIELD_PSDEJOINTYPENAME, this.getPSDEJoinTypeName());
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
        return PSDEJoinTypeBase.get(this, n);
    }

    private static Object get(PSDEJoinTypeBase pSDEJoinTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEJoinTypeBase.getCreateDate();
            }
            case 1: {
                return pSDEJoinTypeBase.getCreateMan();
            }
            case 2: {
                return pSDEJoinTypeBase.getIconPath();
            }
            case 3: {
                return pSDEJoinTypeBase.getMainFlag();
            }
            case 4: {
                return pSDEJoinTypeBase.getMemo();
            }
            case 5: {
                return pSDEJoinTypeBase.getOrderValue();
            }
            case 6: {
                return pSDEJoinTypeBase.getPSDEJoinTypeId();
            }
            case 7: {
                return pSDEJoinTypeBase.getPSDEJoinTypeName();
            }
            case 8: {
                return pSDEJoinTypeBase.getUpdateDate();
            }
            case 9: {
                return pSDEJoinTypeBase.getUpdateMan();
            }
            case 10: {
                return pSDEJoinTypeBase.getValidFlag();
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
        PSDEJoinTypeBase.set(this, n, object);
    }

    private static void set(PSDEJoinTypeBase pSDEJoinTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEJoinTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEJoinTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEJoinTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEJoinTypeBase.setMainFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEJoinTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEJoinTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEJoinTypeBase.setPSDEJoinTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEJoinTypeBase.setPSDEJoinTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEJoinTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDEJoinTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEJoinTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEJoinTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDEJoinTypeBase pSDEJoinTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEJoinTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEJoinTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEJoinTypeBase.getIconPath() == null;
            }
            case 3: {
                return pSDEJoinTypeBase.getMainFlag() == null;
            }
            case 4: {
                return pSDEJoinTypeBase.getMemo() == null;
            }
            case 5: {
                return pSDEJoinTypeBase.getOrderValue() == null;
            }
            case 6: {
                return pSDEJoinTypeBase.getPSDEJoinTypeId() == null;
            }
            case 7: {
                return pSDEJoinTypeBase.getPSDEJoinTypeName() == null;
            }
            case 8: {
                return pSDEJoinTypeBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDEJoinTypeBase.getUpdateMan() == null;
            }
            case 10: {
                return pSDEJoinTypeBase.getValidFlag() == null;
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
        return PSDEJoinTypeBase.contains(this, n);
    }

    private static boolean contains(PSDEJoinTypeBase pSDEJoinTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEJoinTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEJoinTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDEJoinTypeBase.isIconPathDirty();
            }
            case 3: {
                return pSDEJoinTypeBase.isMainFlagDirty();
            }
            case 4: {
                return pSDEJoinTypeBase.isMemoDirty();
            }
            case 5: {
                return pSDEJoinTypeBase.isOrderValueDirty();
            }
            case 6: {
                return pSDEJoinTypeBase.isPSDEJoinTypeIdDirty();
            }
            case 7: {
                return pSDEJoinTypeBase.isPSDEJoinTypeNameDirty();
            }
            case 8: {
                return pSDEJoinTypeBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDEJoinTypeBase.isUpdateManDirty();
            }
            case 10: {
                return pSDEJoinTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEJoinTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEJoinTypeBase pSDEJoinTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEJoinTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEJoinTypeBase.getJSONValue((Object)pSDEJoinTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEJoinTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEJoinTypeBase.getJSONValue((Object)pSDEJoinTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEJoinTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSDEJoinTypeBase.getJSONValue((Object)pSDEJoinTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSDEJoinTypeBase.getMainFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mainflag", (Object)PSDEJoinTypeBase.getJSONValue((Object)pSDEJoinTypeBase.getMainFlag()), (boolean)false);
        }
        if (bl || pSDEJoinTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEJoinTypeBase.getJSONValue((Object)pSDEJoinTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEJoinTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEJoinTypeBase.getJSONValue((Object)pSDEJoinTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEJoinTypeBase.getPSDEJoinTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdejointypeid", (Object)PSDEJoinTypeBase.getJSONValue((Object)pSDEJoinTypeBase.getPSDEJoinTypeId()), (boolean)false);
        }
        if (bl || pSDEJoinTypeBase.getPSDEJoinTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdejointypename", (Object)PSDEJoinTypeBase.getJSONValue((Object)pSDEJoinTypeBase.getPSDEJoinTypeName()), (boolean)false);
        }
        if (bl || pSDEJoinTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEJoinTypeBase.getJSONValue((Object)pSDEJoinTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEJoinTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEJoinTypeBase.getJSONValue((Object)pSDEJoinTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEJoinTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEJoinTypeBase.getJSONValue((Object)pSDEJoinTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEJoinTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEJoinTypeBase pSDEJoinTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEJoinTypeBase.getCreateDate() != null) {
            object = pSDEJoinTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEJoinTypeBase.getCreateMan() != null) {
            object = pSDEJoinTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEJoinTypeBase.getIconPath() != null) {
            object = pSDEJoinTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDEJoinTypeBase.getMainFlag() != null) {
            object = pSDEJoinTypeBase.getMainFlag();
            xmlNode.setAttribute(FIELD_MAINFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEJoinTypeBase.getMemo() != null) {
            object = pSDEJoinTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEJoinTypeBase.getOrderValue() != null) {
            object = pSDEJoinTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEJoinTypeBase.getPSDEJoinTypeId() != null) {
            object = pSDEJoinTypeBase.getPSDEJoinTypeId();
            xmlNode.setAttribute(FIELD_PSDEJOINTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEJoinTypeBase.getPSDEJoinTypeName() != null) {
            object = pSDEJoinTypeBase.getPSDEJoinTypeName();
            xmlNode.setAttribute(FIELD_PSDEJOINTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEJoinTypeBase.getUpdateDate() != null) {
            object = pSDEJoinTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEJoinTypeBase.getUpdateMan() != null) {
            object = pSDEJoinTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEJoinTypeBase.getValidFlag() != null) {
            object = pSDEJoinTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEJoinTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEJoinTypeBase pSDEJoinTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEJoinTypeBase.isCreateDateDirty() && (bl || pSDEJoinTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEJoinTypeBase.getCreateDate());
        }
        if (pSDEJoinTypeBase.isCreateManDirty() && (bl || pSDEJoinTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEJoinTypeBase.getCreateMan());
        }
        if (pSDEJoinTypeBase.isIconPathDirty() && (bl || pSDEJoinTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSDEJoinTypeBase.getIconPath());
        }
        if (pSDEJoinTypeBase.isMainFlagDirty() && (bl || pSDEJoinTypeBase.getMainFlag() != null)) {
            iDataObject.set(FIELD_MAINFLAG, (Object)pSDEJoinTypeBase.getMainFlag());
        }
        if (pSDEJoinTypeBase.isMemoDirty() && (bl || pSDEJoinTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEJoinTypeBase.getMemo());
        }
        if (pSDEJoinTypeBase.isOrderValueDirty() && (bl || pSDEJoinTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEJoinTypeBase.getOrderValue());
        }
        if (pSDEJoinTypeBase.isPSDEJoinTypeIdDirty() && (bl || pSDEJoinTypeBase.getPSDEJoinTypeId() != null)) {
            iDataObject.set(FIELD_PSDEJOINTYPEID, (Object)pSDEJoinTypeBase.getPSDEJoinTypeId());
        }
        if (pSDEJoinTypeBase.isPSDEJoinTypeNameDirty() && (bl || pSDEJoinTypeBase.getPSDEJoinTypeName() != null)) {
            iDataObject.set(FIELD_PSDEJOINTYPENAME, (Object)pSDEJoinTypeBase.getPSDEJoinTypeName());
        }
        if (pSDEJoinTypeBase.isUpdateDateDirty() && (bl || pSDEJoinTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEJoinTypeBase.getUpdateDate());
        }
        if (pSDEJoinTypeBase.isUpdateManDirty() && (bl || pSDEJoinTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEJoinTypeBase.getUpdateMan());
        }
        if (pSDEJoinTypeBase.isValidFlagDirty() && (bl || pSDEJoinTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEJoinTypeBase.getValidFlag());
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
        return PSDEJoinTypeBase.remove(this, n);
    }

    private static boolean remove(PSDEJoinTypeBase pSDEJoinTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEJoinTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEJoinTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEJoinTypeBase.resetIconPath();
                return true;
            }
            case 3: {
                pSDEJoinTypeBase.resetMainFlag();
                return true;
            }
            case 4: {
                pSDEJoinTypeBase.resetMemo();
                return true;
            }
            case 5: {
                pSDEJoinTypeBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSDEJoinTypeBase.resetPSDEJoinTypeId();
                return true;
            }
            case 7: {
                pSDEJoinTypeBase.resetPSDEJoinTypeName();
                return true;
            }
            case 8: {
                pSDEJoinTypeBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDEJoinTypeBase.resetUpdateMan();
                return true;
            }
            case 10: {
                pSDEJoinTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDEJoinTypeBase getProxyEntity() {
        return this.proxyPSDEJoinTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEJoinTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEJoinTypeBase) {
            this.proxyPSDEJoinTypeBase = (PSDEJoinTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEJoinTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ICONPATH, 2);
        fieldIndexMap.put(FIELD_MAINFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PSDEJOINTYPEID, 6);
        fieldIndexMap.put(FIELD_PSDEJOINTYPENAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_VALIDFLAG, 10);
    }
}

