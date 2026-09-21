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

public abstract class PSDEActionTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEActionTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PROCESSOBJ = "PROCESSOBJ";
    public static final String FIELD_PSDEACTIONTYPEID = "PSDEACTIONTYPEID";
    public static final String FIELD_PSDEACTIONTYPENAME = "PSDEACTIONTYPENAME";
    public static final String FIELD_TYPEPARAM = "TYPEPARAM";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ICONPATH = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PROCESSOBJ = 4;
    private static final int INDEX_PSDEACTIONTYPEID = 5;
    private static final int INDEX_PSDEACTIONTYPENAME = 6;
    private static final int INDEX_TYPEPARAM = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEActionTypeBase proxyPSDEActionTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean processobjDirtyFlag = false;
    private boolean psdeactiontypeidDirtyFlag = false;
    private boolean psdeactiontypenameDirtyFlag = false;
    private boolean typeparamDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="memo")
    private String memo;
    @Column(name="processobj")
    private String processobj;
    @Column(name="psdeactiontypeid")
    private String psdeactiontypeid;
    @Column(name="psdeactiontypename")
    private String psdeactiontypename;
    @Column(name="typeparam")
    private String typeparam;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

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

    public void setProcessObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProcessObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.processobj = string;
        this.processobjDirtyFlag = true;
    }

    public String getProcessObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProcessObj();
        }
        return this.processobj;
    }

    public boolean isProcessObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProcessObjDirty();
        }
        return this.processobjDirtyFlag;
    }

    public void resetProcessObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProcessObj();
            return;
        }
        this.processobjDirtyFlag = false;
        this.processobj = null;
    }

    public void setPSDEActionTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactiontypeid = string;
        this.psdeactiontypeidDirtyFlag = true;
    }

    public String getPSDEActionTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionTypeId();
        }
        return this.psdeactiontypeid;
    }

    public boolean isPSDEActionTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionTypeIdDirty();
        }
        return this.psdeactiontypeidDirtyFlag;
    }

    public void resetPSDEActionTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionTypeId();
            return;
        }
        this.psdeactiontypeidDirtyFlag = false;
        this.psdeactiontypeid = null;
    }

    public void setPSDEActionTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactiontypename = string;
        this.psdeactiontypenameDirtyFlag = true;
    }

    public String getPSDEActionTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionTypeName();
        }
        return this.psdeactiontypename;
    }

    public boolean isPSDEActionTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionTypeNameDirty();
        }
        return this.psdeactiontypenameDirtyFlag;
    }

    public void resetPSDEActionTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionTypeName();
            return;
        }
        this.psdeactiontypenameDirtyFlag = false;
        this.psdeactiontypename = null;
    }

    public void setTypeParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparam = string;
        this.typeparamDirtyFlag = true;
    }

    public String getTypeParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParam();
        }
        return this.typeparam;
    }

    public boolean isTypeParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParamDirty();
        }
        return this.typeparamDirtyFlag;
    }

    public void resetTypeParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParam();
            return;
        }
        this.typeparamDirtyFlag = false;
        this.typeparam = null;
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
        PSDEActionTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEActionTypeBase pSDEActionTypeBase) {
        pSDEActionTypeBase.resetCreateDate();
        pSDEActionTypeBase.resetCreateMan();
        pSDEActionTypeBase.resetIconPath();
        pSDEActionTypeBase.resetMemo();
        pSDEActionTypeBase.resetProcessObj();
        pSDEActionTypeBase.resetPSDEActionTypeId();
        pSDEActionTypeBase.resetPSDEActionTypeName();
        pSDEActionTypeBase.resetTypeParam();
        pSDEActionTypeBase.resetUpdateDate();
        pSDEActionTypeBase.resetUpdateMan();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isProcessObjDirty()) {
            hashMap.put(FIELD_PROCESSOBJ, this.getProcessObj());
        }
        if (!bl || this.isPSDEActionTypeIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONTYPEID, this.getPSDEActionTypeId());
        }
        if (!bl || this.isPSDEActionTypeNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONTYPENAME, this.getPSDEActionTypeName());
        }
        if (!bl || this.isTypeParamDirty()) {
            hashMap.put(FIELD_TYPEPARAM, this.getTypeParam());
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
        return PSDEActionTypeBase.get(this, n);
    }

    private static Object get(PSDEActionTypeBase pSDEActionTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionTypeBase.getCreateDate();
            }
            case 1: {
                return pSDEActionTypeBase.getCreateMan();
            }
            case 2: {
                return pSDEActionTypeBase.getIconPath();
            }
            case 3: {
                return pSDEActionTypeBase.getMemo();
            }
            case 4: {
                return pSDEActionTypeBase.getProcessObj();
            }
            case 5: {
                return pSDEActionTypeBase.getPSDEActionTypeId();
            }
            case 6: {
                return pSDEActionTypeBase.getPSDEActionTypeName();
            }
            case 7: {
                return pSDEActionTypeBase.getTypeParam();
            }
            case 8: {
                return pSDEActionTypeBase.getUpdateDate();
            }
            case 9: {
                return pSDEActionTypeBase.getUpdateMan();
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
        PSDEActionTypeBase.set(this, n, object);
    }

    private static void set(PSDEActionTypeBase pSDEActionTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEActionTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEActionTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEActionTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEActionTypeBase.setProcessObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEActionTypeBase.setPSDEActionTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEActionTypeBase.setPSDEActionTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEActionTypeBase.setTypeParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEActionTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDEActionTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEActionTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDEActionTypeBase pSDEActionTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEActionTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEActionTypeBase.getIconPath() == null;
            }
            case 3: {
                return pSDEActionTypeBase.getMemo() == null;
            }
            case 4: {
                return pSDEActionTypeBase.getProcessObj() == null;
            }
            case 5: {
                return pSDEActionTypeBase.getPSDEActionTypeId() == null;
            }
            case 6: {
                return pSDEActionTypeBase.getPSDEActionTypeName() == null;
            }
            case 7: {
                return pSDEActionTypeBase.getTypeParam() == null;
            }
            case 8: {
                return pSDEActionTypeBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDEActionTypeBase.getUpdateMan() == null;
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
        return PSDEActionTypeBase.contains(this, n);
    }

    private static boolean contains(PSDEActionTypeBase pSDEActionTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEActionTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEActionTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDEActionTypeBase.isIconPathDirty();
            }
            case 3: {
                return pSDEActionTypeBase.isMemoDirty();
            }
            case 4: {
                return pSDEActionTypeBase.isProcessObjDirty();
            }
            case 5: {
                return pSDEActionTypeBase.isPSDEActionTypeIdDirty();
            }
            case 6: {
                return pSDEActionTypeBase.isPSDEActionTypeNameDirty();
            }
            case 7: {
                return pSDEActionTypeBase.isTypeParamDirty();
            }
            case 8: {
                return pSDEActionTypeBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDEActionTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEActionTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEActionTypeBase pSDEActionTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEActionTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEActionTypeBase.getJSONValue((Object)pSDEActionTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEActionTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEActionTypeBase.getJSONValue((Object)pSDEActionTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEActionTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSDEActionTypeBase.getJSONValue((Object)pSDEActionTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSDEActionTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEActionTypeBase.getJSONValue((Object)pSDEActionTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEActionTypeBase.getProcessObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"processobj", (Object)PSDEActionTypeBase.getJSONValue((Object)pSDEActionTypeBase.getProcessObj()), (boolean)false);
        }
        if (bl || pSDEActionTypeBase.getPSDEActionTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactiontypeid", (Object)PSDEActionTypeBase.getJSONValue((Object)pSDEActionTypeBase.getPSDEActionTypeId()), (boolean)false);
        }
        if (bl || pSDEActionTypeBase.getPSDEActionTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactiontypename", (Object)PSDEActionTypeBase.getJSONValue((Object)pSDEActionTypeBase.getPSDEActionTypeName()), (boolean)false);
        }
        if (bl || pSDEActionTypeBase.getTypeParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparam", (Object)PSDEActionTypeBase.getJSONValue((Object)pSDEActionTypeBase.getTypeParam()), (boolean)false);
        }
        if (bl || pSDEActionTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEActionTypeBase.getJSONValue((Object)pSDEActionTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEActionTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEActionTypeBase.getJSONValue((Object)pSDEActionTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEActionTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEActionTypeBase pSDEActionTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEActionTypeBase.getCreateDate() != null) {
            object = pSDEActionTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionTypeBase.getCreateMan() != null) {
            object = pSDEActionTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTypeBase.getIconPath() != null) {
            object = pSDEActionTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTypeBase.getMemo() != null) {
            object = pSDEActionTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTypeBase.getProcessObj() != null) {
            object = pSDEActionTypeBase.getProcessObj();
            xmlNode.setAttribute(FIELD_PROCESSOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTypeBase.getPSDEActionTypeId() != null) {
            object = pSDEActionTypeBase.getPSDEActionTypeId();
            xmlNode.setAttribute(FIELD_PSDEACTIONTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTypeBase.getPSDEActionTypeName() != null) {
            object = pSDEActionTypeBase.getPSDEActionTypeName();
            xmlNode.setAttribute(FIELD_PSDEACTIONTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTypeBase.getTypeParam() != null) {
            object = pSDEActionTypeBase.getTypeParam();
            xmlNode.setAttribute(FIELD_TYPEPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDEActionTypeBase.getUpdateDate() != null) {
            object = pSDEActionTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEActionTypeBase.getUpdateMan() != null) {
            object = pSDEActionTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEActionTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEActionTypeBase pSDEActionTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEActionTypeBase.isCreateDateDirty() && (bl || pSDEActionTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEActionTypeBase.getCreateDate());
        }
        if (pSDEActionTypeBase.isCreateManDirty() && (bl || pSDEActionTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEActionTypeBase.getCreateMan());
        }
        if (pSDEActionTypeBase.isIconPathDirty() && (bl || pSDEActionTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSDEActionTypeBase.getIconPath());
        }
        if (pSDEActionTypeBase.isMemoDirty() && (bl || pSDEActionTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEActionTypeBase.getMemo());
        }
        if (pSDEActionTypeBase.isProcessObjDirty() && (bl || pSDEActionTypeBase.getProcessObj() != null)) {
            iDataObject.set(FIELD_PROCESSOBJ, (Object)pSDEActionTypeBase.getProcessObj());
        }
        if (pSDEActionTypeBase.isPSDEActionTypeIdDirty() && (bl || pSDEActionTypeBase.getPSDEActionTypeId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONTYPEID, (Object)pSDEActionTypeBase.getPSDEActionTypeId());
        }
        if (pSDEActionTypeBase.isPSDEActionTypeNameDirty() && (bl || pSDEActionTypeBase.getPSDEActionTypeName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONTYPENAME, (Object)pSDEActionTypeBase.getPSDEActionTypeName());
        }
        if (pSDEActionTypeBase.isTypeParamDirty() && (bl || pSDEActionTypeBase.getTypeParam() != null)) {
            iDataObject.set(FIELD_TYPEPARAM, (Object)pSDEActionTypeBase.getTypeParam());
        }
        if (pSDEActionTypeBase.isUpdateDateDirty() && (bl || pSDEActionTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEActionTypeBase.getUpdateDate());
        }
        if (pSDEActionTypeBase.isUpdateManDirty() && (bl || pSDEActionTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEActionTypeBase.getUpdateMan());
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
        return PSDEActionTypeBase.remove(this, n);
    }

    private static boolean remove(PSDEActionTypeBase pSDEActionTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEActionTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEActionTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEActionTypeBase.resetIconPath();
                return true;
            }
            case 3: {
                pSDEActionTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEActionTypeBase.resetProcessObj();
                return true;
            }
            case 5: {
                pSDEActionTypeBase.resetPSDEActionTypeId();
                return true;
            }
            case 6: {
                pSDEActionTypeBase.resetPSDEActionTypeName();
                return true;
            }
            case 7: {
                pSDEActionTypeBase.resetTypeParam();
                return true;
            }
            case 8: {
                pSDEActionTypeBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDEActionTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDEActionTypeBase getProxyEntity() {
        return this.proxyPSDEActionTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEActionTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEActionTypeBase) {
            this.proxyPSDEActionTypeBase = (PSDEActionTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEActionTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ICONPATH, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PROCESSOBJ, 4);
        fieldIndexMap.put(FIELD_PSDEACTIONTYPEID, 5);
        fieldIndexMap.put(FIELD_PSDEACTIONTYPENAME, 6);
        fieldIndexMap.put(FIELD_TYPEPARAM, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

