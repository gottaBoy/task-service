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
package net.ibizsys.pscore.srv.dedesign.entity;

import java.io.Serializable;
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
import net.ibizsys.pscore.srv.config.entity.PSDEFDataType;
import net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFieldImpBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFieldImpBase.class);
    public static final String FIELD_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String FIELD_IMPORTKEY = "IMPORTKEY";
    public static final String FIELD_IMPORTORDER = "IMPORTORDER";
    public static final String FIELD_IMPORTTAG = "IMPORTTAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_PHYSICALFIELD = "PHYSICALFIELD";
    public static final String FIELD_PSDATATYPEID = "PSDATATYPEID";
    public static final String FIELD_PSDATATYPENAME = "PSDATATYPENAME";
    public static final String FIELD_PSDEFIELDID = "PSDEFIELDID";
    public static final String FIELD_PSDEFIELDNAME = "PSDEFIELDNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    private static final int INDEX_ALLOWEMPTY = 0;
    private static final int INDEX_IMPORTKEY = 1;
    private static final int INDEX_IMPORTORDER = 2;
    private static final int INDEX_IMPORTTAG = 3;
    private static final int INDEX_LOGICNAME = 4;
    private static final int INDEX_PHYSICALFIELD = 5;
    private static final int INDEX_PSDATATYPEID = 6;
    private static final int INDEX_PSDATATYPENAME = 7;
    private static final int INDEX_PSDEFIELDID = 8;
    private static final int INDEX_PSDEFIELDNAME = 9;
    private static final int INDEX_PSDEID = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFieldImpBase proxyPSDEFieldImpBase = null;
    private boolean allowemptyDirtyFlag = false;
    private boolean importkeyDirtyFlag = false;
    private boolean importorderDirtyFlag = false;
    private boolean importtagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean physicalfieldDirtyFlag = false;
    private boolean psdatatypeidDirtyFlag = false;
    private boolean psdatatypenameDirtyFlag = false;
    private boolean psdefieldidDirtyFlag = false;
    private boolean psdefieldnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    @Column(name="allowempty")
    private Integer allowempty;
    @Column(name="importkey")
    private Integer importkey;
    @Column(name="importorder")
    private Integer importorder;
    @Column(name="importtag")
    private String importtag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="physicalfield")
    private Integer physicalfield;
    @Column(name="psdatatypeid")
    private String psdatatypeid;
    @Column(name="psdatatypename")
    private String psdatatypename;
    @Column(name="psdefieldid")
    private String psdefieldid;
    @Column(name="psdefieldname")
    private String psdefieldname;
    @Column(name="psdeid")
    private String psdeid;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDataTypeLock = new Integer(1);
    private PSDEFDataType psdatatype = null;

    public void setAllowEmpty(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllowEmpty(n);
            return;
        }
        this.allowempty = n;
        this.allowemptyDirtyFlag = true;
    }

    public Integer getAllowEmpty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllowEmpty();
        }
        return this.allowempty;
    }

    public boolean isAllowEmptyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllowEmptyDirty();
        }
        return this.allowemptyDirtyFlag;
    }

    public void resetAllowEmpty() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllowEmpty();
            return;
        }
        this.allowemptyDirtyFlag = false;
        this.allowempty = null;
    }

    public void setImportKey(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImportKey(n);
            return;
        }
        this.importkey = n;
        this.importkeyDirtyFlag = true;
    }

    public Integer getImportKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImportKey();
        }
        return this.importkey;
    }

    public boolean isImportKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImportKeyDirty();
        }
        return this.importkeyDirtyFlag;
    }

    public void resetImportKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImportKey();
            return;
        }
        this.importkeyDirtyFlag = false;
        this.importkey = null;
    }

    public void setImportOrder(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImportOrder(n);
            return;
        }
        this.importorder = n;
        this.importorderDirtyFlag = true;
    }

    public Integer getImportOrder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImportOrder();
        }
        return this.importorder;
    }

    public boolean isImportOrderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImportOrderDirty();
        }
        return this.importorderDirtyFlag;
    }

    public void resetImportOrder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImportOrder();
            return;
        }
        this.importorderDirtyFlag = false;
        this.importorder = null;
    }

    public void setImportTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImportTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.importtag = string;
        this.importtagDirtyFlag = true;
    }

    public String getImportTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImportTag();
        }
        return this.importtag;
    }

    public boolean isImportTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImportTagDirty();
        }
        return this.importtagDirtyFlag;
    }

    public void resetImportTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImportTag();
            return;
        }
        this.importtagDirtyFlag = false;
        this.importtag = null;
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

    public void setPhysicalField(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPhysicalField(n);
            return;
        }
        this.physicalfield = n;
        this.physicalfieldDirtyFlag = true;
    }

    public Integer getPhysicalField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPhysicalField();
        }
        return this.physicalfield;
    }

    public boolean isPhysicalFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPhysicalFieldDirty();
        }
        return this.physicalfieldDirtyFlag;
    }

    public void resetPhysicalField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPhysicalField();
            return;
        }
        this.physicalfieldDirtyFlag = false;
        this.physicalfield = null;
    }

    public void setPSDataTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdatatypeid = string;
        this.psdatatypeidDirtyFlag = true;
    }

    public String getPSDataTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataTypeId();
        }
        return this.psdatatypeid;
    }

    public boolean isPSDataTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataTypeIdDirty();
        }
        return this.psdatatypeidDirtyFlag;
    }

    public void resetPSDataTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataTypeId();
            return;
        }
        this.psdatatypeidDirtyFlag = false;
        this.psdatatypeid = null;
    }

    public void setPSDataTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdatatypename = string;
        this.psdatatypenameDirtyFlag = true;
    }

    public String getPSDataTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataTypeName();
        }
        return this.psdatatypename;
    }

    public boolean isPSDataTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataTypeNameDirty();
        }
        return this.psdatatypenameDirtyFlag;
    }

    public void resetPSDataTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataTypeName();
            return;
        }
        this.psdatatypenameDirtyFlag = false;
        this.psdatatypename = null;
    }

    public void setPSDEFieldId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFieldId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefieldid = string;
        this.psdefieldidDirtyFlag = true;
    }

    public String getPSDEFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFieldId();
        }
        return this.psdefieldid;
    }

    public boolean isPSDEFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFieldIdDirty();
        }
        return this.psdefieldidDirtyFlag;
    }

    public void resetPSDEFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFieldId();
            return;
        }
        this.psdefieldidDirtyFlag = false;
        this.psdefieldid = null;
    }

    public void setPSDEFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.psdefieldname = string;
        this.psdefieldnameDirtyFlag = true;
    }

    public String getPSDEFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFieldName();
        }
        return this.psdefieldname;
    }

    public boolean isPSDEFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFieldNameDirty();
        }
        return this.psdefieldnameDirtyFlag;
    }

    public void resetPSDEFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFieldName();
            return;
        }
        this.psdefieldnameDirtyFlag = false;
        this.psdefieldname = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    protected void onReset() {
        PSDEFieldImpBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFieldImpBase pSDEFieldImpBase) {
        pSDEFieldImpBase.resetAllowEmpty();
        pSDEFieldImpBase.resetImportKey();
        pSDEFieldImpBase.resetImportOrder();
        pSDEFieldImpBase.resetImportTag();
        pSDEFieldImpBase.resetLogicName();
        pSDEFieldImpBase.resetPhysicalField();
        pSDEFieldImpBase.resetPSDataTypeId();
        pSDEFieldImpBase.resetPSDataTypeName();
        pSDEFieldImpBase.resetPSDEFieldId();
        pSDEFieldImpBase.resetPSDEFieldName();
        pSDEFieldImpBase.resetPSDEId();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllowEmptyDirty()) {
            hashMap.put(FIELD_ALLOWEMPTY, this.getAllowEmpty());
        }
        if (!bl || this.isImportKeyDirty()) {
            hashMap.put(FIELD_IMPORTKEY, this.getImportKey());
        }
        if (!bl || this.isImportOrderDirty()) {
            hashMap.put(FIELD_IMPORTORDER, this.getImportOrder());
        }
        if (!bl || this.isImportTagDirty()) {
            hashMap.put(FIELD_IMPORTTAG, this.getImportTag());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isPhysicalFieldDirty()) {
            hashMap.put(FIELD_PHYSICALFIELD, this.getPhysicalField());
        }
        if (!bl || this.isPSDataTypeIdDirty()) {
            hashMap.put(FIELD_PSDATATYPEID, this.getPSDataTypeId());
        }
        if (!bl || this.isPSDataTypeNameDirty()) {
            hashMap.put(FIELD_PSDATATYPENAME, this.getPSDataTypeName());
        }
        if (!bl || this.isPSDEFieldIdDirty()) {
            hashMap.put(FIELD_PSDEFIELDID, this.getPSDEFieldId());
        }
        if (!bl || this.isPSDEFieldNameDirty()) {
            hashMap.put(FIELD_PSDEFIELDNAME, this.getPSDEFieldName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
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
        return PSDEFieldImpBase.get(this, n);
    }

    private static Object get(PSDEFieldImpBase pSDEFieldImpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFieldImpBase.getAllowEmpty();
            }
            case 1: {
                return pSDEFieldImpBase.getImportKey();
            }
            case 2: {
                return pSDEFieldImpBase.getImportOrder();
            }
            case 3: {
                return pSDEFieldImpBase.getImportTag();
            }
            case 4: {
                return pSDEFieldImpBase.getLogicName();
            }
            case 5: {
                return pSDEFieldImpBase.getPhysicalField();
            }
            case 6: {
                return pSDEFieldImpBase.getPSDataTypeId();
            }
            case 7: {
                return pSDEFieldImpBase.getPSDataTypeName();
            }
            case 8: {
                return pSDEFieldImpBase.getPSDEFieldId();
            }
            case 9: {
                return pSDEFieldImpBase.getPSDEFieldName();
            }
            case 10: {
                return pSDEFieldImpBase.getPSDEId();
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
        PSDEFieldImpBase.set(this, n, object);
    }

    private static void set(PSDEFieldImpBase pSDEFieldImpBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFieldImpBase.setAllowEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEFieldImpBase.setImportKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDEFieldImpBase.setImportOrder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDEFieldImpBase.setImportTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFieldImpBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFieldImpBase.setPhysicalField(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEFieldImpBase.setPSDataTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFieldImpBase.setPSDataTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFieldImpBase.setPSDEFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEFieldImpBase.setPSDEFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFieldImpBase.setPSDEId(DataObject.getStringValue((Object)object));
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
        return PSDEFieldImpBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFieldImpBase pSDEFieldImpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFieldImpBase.getAllowEmpty() == null;
            }
            case 1: {
                return pSDEFieldImpBase.getImportKey() == null;
            }
            case 2: {
                return pSDEFieldImpBase.getImportOrder() == null;
            }
            case 3: {
                return pSDEFieldImpBase.getImportTag() == null;
            }
            case 4: {
                return pSDEFieldImpBase.getLogicName() == null;
            }
            case 5: {
                return pSDEFieldImpBase.getPhysicalField() == null;
            }
            case 6: {
                return pSDEFieldImpBase.getPSDataTypeId() == null;
            }
            case 7: {
                return pSDEFieldImpBase.getPSDataTypeName() == null;
            }
            case 8: {
                return pSDEFieldImpBase.getPSDEFieldId() == null;
            }
            case 9: {
                return pSDEFieldImpBase.getPSDEFieldName() == null;
            }
            case 10: {
                return pSDEFieldImpBase.getPSDEId() == null;
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
        return PSDEFieldImpBase.contains(this, n);
    }

    private static boolean contains(PSDEFieldImpBase pSDEFieldImpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFieldImpBase.isAllowEmptyDirty();
            }
            case 1: {
                return pSDEFieldImpBase.isImportKeyDirty();
            }
            case 2: {
                return pSDEFieldImpBase.isImportOrderDirty();
            }
            case 3: {
                return pSDEFieldImpBase.isImportTagDirty();
            }
            case 4: {
                return pSDEFieldImpBase.isLogicNameDirty();
            }
            case 5: {
                return pSDEFieldImpBase.isPhysicalFieldDirty();
            }
            case 6: {
                return pSDEFieldImpBase.isPSDataTypeIdDirty();
            }
            case 7: {
                return pSDEFieldImpBase.isPSDataTypeNameDirty();
            }
            case 8: {
                return pSDEFieldImpBase.isPSDEFieldIdDirty();
            }
            case 9: {
                return pSDEFieldImpBase.isPSDEFieldNameDirty();
            }
            case 10: {
                return pSDEFieldImpBase.isPSDEIdDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFieldImpBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFieldImpBase pSDEFieldImpBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFieldImpBase.getAllowEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowempty", (Object)PSDEFieldImpBase.getJSONValue((Object)pSDEFieldImpBase.getAllowEmpty()), (boolean)false);
        }
        if (bl || pSDEFieldImpBase.getImportKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"importkey", (Object)PSDEFieldImpBase.getJSONValue((Object)pSDEFieldImpBase.getImportKey()), (boolean)false);
        }
        if (bl || pSDEFieldImpBase.getImportOrder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"importorder", (Object)PSDEFieldImpBase.getJSONValue((Object)pSDEFieldImpBase.getImportOrder()), (boolean)false);
        }
        if (bl || pSDEFieldImpBase.getImportTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"importtag", (Object)PSDEFieldImpBase.getJSONValue((Object)pSDEFieldImpBase.getImportTag()), (boolean)false);
        }
        if (bl || pSDEFieldImpBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEFieldImpBase.getJSONValue((Object)pSDEFieldImpBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEFieldImpBase.getPhysicalField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"physicalfield", (Object)PSDEFieldImpBase.getJSONValue((Object)pSDEFieldImpBase.getPhysicalField()), (boolean)false);
        }
        if (bl || pSDEFieldImpBase.getPSDataTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdatatypeid", (Object)PSDEFieldImpBase.getJSONValue((Object)pSDEFieldImpBase.getPSDataTypeId()), (boolean)false);
        }
        if (bl || pSDEFieldImpBase.getPSDataTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdatatypename", (Object)PSDEFieldImpBase.getJSONValue((Object)pSDEFieldImpBase.getPSDataTypeName()), (boolean)false);
        }
        if (bl || pSDEFieldImpBase.getPSDEFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefieldid", (Object)PSDEFieldImpBase.getJSONValue((Object)pSDEFieldImpBase.getPSDEFieldId()), (boolean)false);
        }
        if (bl || pSDEFieldImpBase.getPSDEFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefieldname", (Object)PSDEFieldImpBase.getJSONValue((Object)pSDEFieldImpBase.getPSDEFieldName()), (boolean)false);
        }
        if (bl || pSDEFieldImpBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEFieldImpBase.getJSONValue((Object)pSDEFieldImpBase.getPSDEId()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFieldImpBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFieldImpBase pSDEFieldImpBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFieldImpBase.getAllowEmpty() != null) {
            object = pSDEFieldImpBase.getAllowEmpty();
            xmlNode.setAttribute(FIELD_ALLOWEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldImpBase.getImportKey() != null) {
            object = pSDEFieldImpBase.getImportKey();
            xmlNode.setAttribute(FIELD_IMPORTKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldImpBase.getImportOrder() != null) {
            object = pSDEFieldImpBase.getImportOrder();
            xmlNode.setAttribute(FIELD_IMPORTORDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldImpBase.getImportTag() != null) {
            object = pSDEFieldImpBase.getImportTag();
            xmlNode.setAttribute(FIELD_IMPORTTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldImpBase.getLogicName() != null) {
            object = pSDEFieldImpBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldImpBase.getPhysicalField() != null) {
            object = pSDEFieldImpBase.getPhysicalField();
            xmlNode.setAttribute(FIELD_PHYSICALFIELD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFieldImpBase.getPSDataTypeId() != null) {
            object = pSDEFieldImpBase.getPSDataTypeId();
            xmlNode.setAttribute(FIELD_PSDATATYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldImpBase.getPSDataTypeName() != null) {
            object = pSDEFieldImpBase.getPSDataTypeName();
            xmlNode.setAttribute(FIELD_PSDATATYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldImpBase.getPSDEFieldId() != null) {
            object = pSDEFieldImpBase.getPSDEFieldId();
            xmlNode.setAttribute(FIELD_PSDEFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldImpBase.getPSDEFieldName() != null) {
            object = pSDEFieldImpBase.getPSDEFieldName();
            xmlNode.setAttribute(FIELD_PSDEFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFieldImpBase.getPSDEId() != null) {
            object = pSDEFieldImpBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFieldImpBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFieldImpBase pSDEFieldImpBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFieldImpBase.isAllowEmptyDirty() && (bl || pSDEFieldImpBase.getAllowEmpty() != null)) {
            iDataObject.set(FIELD_ALLOWEMPTY, (Object)pSDEFieldImpBase.getAllowEmpty());
        }
        if (pSDEFieldImpBase.isImportKeyDirty() && (bl || pSDEFieldImpBase.getImportKey() != null)) {
            iDataObject.set(FIELD_IMPORTKEY, (Object)pSDEFieldImpBase.getImportKey());
        }
        if (pSDEFieldImpBase.isImportOrderDirty() && (bl || pSDEFieldImpBase.getImportOrder() != null)) {
            iDataObject.set(FIELD_IMPORTORDER, (Object)pSDEFieldImpBase.getImportOrder());
        }
        if (pSDEFieldImpBase.isImportTagDirty() && (bl || pSDEFieldImpBase.getImportTag() != null)) {
            iDataObject.set(FIELD_IMPORTTAG, (Object)pSDEFieldImpBase.getImportTag());
        }
        if (pSDEFieldImpBase.isLogicNameDirty() && (bl || pSDEFieldImpBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEFieldImpBase.getLogicName());
        }
        if (pSDEFieldImpBase.isPhysicalFieldDirty() && (bl || pSDEFieldImpBase.getPhysicalField() != null)) {
            iDataObject.set(FIELD_PHYSICALFIELD, (Object)pSDEFieldImpBase.getPhysicalField());
        }
        if (pSDEFieldImpBase.isPSDataTypeIdDirty() && (bl || pSDEFieldImpBase.getPSDataTypeId() != null)) {
            iDataObject.set(FIELD_PSDATATYPEID, (Object)pSDEFieldImpBase.getPSDataTypeId());
        }
        if (pSDEFieldImpBase.isPSDataTypeNameDirty() && (bl || pSDEFieldImpBase.getPSDataTypeName() != null)) {
            iDataObject.set(FIELD_PSDATATYPENAME, (Object)pSDEFieldImpBase.getPSDataTypeName());
        }
        if (pSDEFieldImpBase.isPSDEFieldIdDirty() && (bl || pSDEFieldImpBase.getPSDEFieldId() != null)) {
            iDataObject.set(FIELD_PSDEFIELDID, (Object)pSDEFieldImpBase.getPSDEFieldId());
        }
        if (pSDEFieldImpBase.isPSDEFieldNameDirty() && (bl || pSDEFieldImpBase.getPSDEFieldName() != null)) {
            iDataObject.set(FIELD_PSDEFIELDNAME, (Object)pSDEFieldImpBase.getPSDEFieldName());
        }
        if (pSDEFieldImpBase.isPSDEIdDirty() && (bl || pSDEFieldImpBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEFieldImpBase.getPSDEId());
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
        return PSDEFieldImpBase.remove(this, n);
    }

    private static boolean remove(PSDEFieldImpBase pSDEFieldImpBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFieldImpBase.resetAllowEmpty();
                return true;
            }
            case 1: {
                pSDEFieldImpBase.resetImportKey();
                return true;
            }
            case 2: {
                pSDEFieldImpBase.resetImportOrder();
                return true;
            }
            case 3: {
                pSDEFieldImpBase.resetImportTag();
                return true;
            }
            case 4: {
                pSDEFieldImpBase.resetLogicName();
                return true;
            }
            case 5: {
                pSDEFieldImpBase.resetPhysicalField();
                return true;
            }
            case 6: {
                pSDEFieldImpBase.resetPSDataTypeId();
                return true;
            }
            case 7: {
                pSDEFieldImpBase.resetPSDataTypeName();
                return true;
            }
            case 8: {
                pSDEFieldImpBase.resetPSDEFieldId();
                return true;
            }
            case 9: {
                pSDEFieldImpBase.resetPSDEFieldName();
                return true;
            }
            case 10: {
                pSDEFieldImpBase.resetPSDEId();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFDataType getPSDataType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataType();
        }
        if (this.getPSDataTypeId() == null) {
            return null;
        }
        Integer n = this.objPSDataTypeLock;
        synchronized (n) {
            if (this.psdatatype != null && DataTypeHelper.compare((int)25, (Object)this.getPSDataTypeId(), (Object)this.psdatatype.getPSDEFDataTypeId()) != 0L) {
                this.psdatatype = null;
            }
            if (this.psdatatype == null) {
                PSDEFDataType pSDEFDataType = new PSDEFDataType();
                pSDEFDataType.setPSDEFDataTypeId(this.getPSDataTypeId());
                PSDEFDataTypeService pSDEFDataTypeService = (PSDEFDataTypeService)ServiceGlobal.getService(PSDEFDataTypeService.class, (SessionFactory)this.getSessionFactory());
                pSDEFDataTypeService.autoGet(pSDEFDataType);
                this.psdatatype = pSDEFDataType;
            }
            return this.psdatatype;
        }
    }

    private PSDEFieldImpBase getProxyEntity() {
        return this.proxyPSDEFieldImpBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFieldImpBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFieldImpBase) {
            this.proxyPSDEFieldImpBase = (PSDEFieldImpBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldImpService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWEMPTY, 0);
        fieldIndexMap.put(FIELD_IMPORTKEY, 1);
        fieldIndexMap.put(FIELD_IMPORTORDER, 2);
        fieldIndexMap.put(FIELD_IMPORTTAG, 3);
        fieldIndexMap.put(FIELD_LOGICNAME, 4);
        fieldIndexMap.put(FIELD_PHYSICALFIELD, 5);
        fieldIndexMap.put(FIELD_PSDATATYPEID, 6);
        fieldIndexMap.put(FIELD_PSDATATYPENAME, 7);
        fieldIndexMap.put(FIELD_PSDEFIELDID, 8);
        fieldIndexMap.put(FIELD_PSDEFIELDNAME, 9);
        fieldIndexMap.put(FIELD_PSDEID, 10);
    }
}

