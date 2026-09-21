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

public abstract class PSDEGCTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEGCTypeBase.class);
    public static final String FIELD_COLUMNOBJ = "COLUMNOBJ";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEGCTYPEID = "PSDEGCTYPEID";
    public static final String FIELD_PSDEGCTYPENAME = "PSDEGCTYPENAME";
    public static final String FIELD_TREECOLUMNOBJ = "TREECOLUMNOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_COLUMNOBJ = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEGCTYPEID = 4;
    private static final int INDEX_PSDEGCTYPENAME = 5;
    private static final int INDEX_TREECOLUMNOBJ = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEGCTypeBase proxyPSDEGCTypeBase = null;
    private boolean columnobjDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdegctypeidDirtyFlag = false;
    private boolean psdegctypenameDirtyFlag = false;
    private boolean treecolumnobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="columnobj")
    private String columnobj;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdegctypeid")
    private String psdegctypeid;
    @Column(name="psdegctypename")
    private String psdegctypename;
    @Column(name="treecolumnobj")
    private String treecolumnobj;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public void setCOLUMNOBJ(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCOLUMNOBJ(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.columnobj = string;
        this.columnobjDirtyFlag = true;
    }

    public String getCOLUMNOBJ() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCOLUMNOBJ();
        }
        return this.columnobj;
    }

    public boolean isCOLUMNOBJDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCOLUMNOBJDirty();
        }
        return this.columnobjDirtyFlag;
    }

    public void resetCOLUMNOBJ() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCOLUMNOBJ();
            return;
        }
        this.columnobjDirtyFlag = false;
        this.columnobj = null;
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

    public void setPSDEGCTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGCTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegctypeid = string;
        this.psdegctypeidDirtyFlag = true;
    }

    public String getPSDEGCTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGCTypeId();
        }
        return this.psdegctypeid;
    }

    public boolean isPSDEGCTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGCTypeIdDirty();
        }
        return this.psdegctypeidDirtyFlag;
    }

    public void resetPSDEGCTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGCTypeId();
            return;
        }
        this.psdegctypeidDirtyFlag = false;
        this.psdegctypeid = null;
    }

    public void setPSDEGCTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGCTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegctypename = string;
        this.psdegctypenameDirtyFlag = true;
    }

    public String getPSDEGCTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGCTypeName();
        }
        return this.psdegctypename;
    }

    public boolean isPSDEGCTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGCTypeNameDirty();
        }
        return this.psdegctypenameDirtyFlag;
    }

    public void resetPSDEGCTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGCTypeName();
            return;
        }
        this.psdegctypenameDirtyFlag = false;
        this.psdegctypename = null;
    }

    public void setTreeColumnObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTreeColumnObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.treecolumnobj = string;
        this.treecolumnobjDirtyFlag = true;
    }

    public String getTreeColumnObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTreeColumnObj();
        }
        return this.treecolumnobj;
    }

    public boolean isTreeColumnObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTreeColumnObjDirty();
        }
        return this.treecolumnobjDirtyFlag;
    }

    public void resetTreeColumnObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTreeColumnObj();
            return;
        }
        this.treecolumnobjDirtyFlag = false;
        this.treecolumnobj = null;
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
        PSDEGCTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEGCTypeBase pSDEGCTypeBase) {
        pSDEGCTypeBase.resetCOLUMNOBJ();
        pSDEGCTypeBase.resetCreateDate();
        pSDEGCTypeBase.resetCreateMan();
        pSDEGCTypeBase.resetMemo();
        pSDEGCTypeBase.resetPSDEGCTypeId();
        pSDEGCTypeBase.resetPSDEGCTypeName();
        pSDEGCTypeBase.resetTreeColumnObj();
        pSDEGCTypeBase.resetUpdateDate();
        pSDEGCTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCOLUMNOBJDirty()) {
            hashMap.put(FIELD_COLUMNOBJ, this.getCOLUMNOBJ());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEGCTypeIdDirty()) {
            hashMap.put(FIELD_PSDEGCTYPEID, this.getPSDEGCTypeId());
        }
        if (!bl || this.isPSDEGCTypeNameDirty()) {
            hashMap.put(FIELD_PSDEGCTYPENAME, this.getPSDEGCTypeName());
        }
        if (!bl || this.isTreeColumnObjDirty()) {
            hashMap.put(FIELD_TREECOLUMNOBJ, this.getTreeColumnObj());
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
        return PSDEGCTypeBase.get(this, n);
    }

    private static Object get(PSDEGCTypeBase pSDEGCTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGCTypeBase.getCOLUMNOBJ();
            }
            case 1: {
                return pSDEGCTypeBase.getCreateDate();
            }
            case 2: {
                return pSDEGCTypeBase.getCreateMan();
            }
            case 3: {
                return pSDEGCTypeBase.getMemo();
            }
            case 4: {
                return pSDEGCTypeBase.getPSDEGCTypeId();
            }
            case 5: {
                return pSDEGCTypeBase.getPSDEGCTypeName();
            }
            case 6: {
                return pSDEGCTypeBase.getTreeColumnObj();
            }
            case 7: {
                return pSDEGCTypeBase.getUpdateDate();
            }
            case 8: {
                return pSDEGCTypeBase.getUpdateMan();
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
        PSDEGCTypeBase.set(this, n, object);
    }

    private static void set(PSDEGCTypeBase pSDEGCTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEGCTypeBase.setCOLUMNOBJ(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEGCTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEGCTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEGCTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEGCTypeBase.setPSDEGCTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEGCTypeBase.setPSDEGCTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEGCTypeBase.setTreeColumnObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEGCTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDEGCTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEGCTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDEGCTypeBase pSDEGCTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGCTypeBase.getCOLUMNOBJ() == null;
            }
            case 1: {
                return pSDEGCTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEGCTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEGCTypeBase.getMemo() == null;
            }
            case 4: {
                return pSDEGCTypeBase.getPSDEGCTypeId() == null;
            }
            case 5: {
                return pSDEGCTypeBase.getPSDEGCTypeName() == null;
            }
            case 6: {
                return pSDEGCTypeBase.getTreeColumnObj() == null;
            }
            case 7: {
                return pSDEGCTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSDEGCTypeBase.getUpdateMan() == null;
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
        return PSDEGCTypeBase.contains(this, n);
    }

    private static boolean contains(PSDEGCTypeBase pSDEGCTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGCTypeBase.isCOLUMNOBJDirty();
            }
            case 1: {
                return pSDEGCTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEGCTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSDEGCTypeBase.isMemoDirty();
            }
            case 4: {
                return pSDEGCTypeBase.isPSDEGCTypeIdDirty();
            }
            case 5: {
                return pSDEGCTypeBase.isPSDEGCTypeNameDirty();
            }
            case 6: {
                return pSDEGCTypeBase.isTreeColumnObjDirty();
            }
            case 7: {
                return pSDEGCTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSDEGCTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEGCTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEGCTypeBase pSDEGCTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEGCTypeBase.getCOLUMNOBJ() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"columnobj", (Object)PSDEGCTypeBase.getJSONValue((Object)pSDEGCTypeBase.getCOLUMNOBJ()), (boolean)false);
        }
        if (bl || pSDEGCTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEGCTypeBase.getJSONValue((Object)pSDEGCTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEGCTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEGCTypeBase.getJSONValue((Object)pSDEGCTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEGCTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEGCTypeBase.getJSONValue((Object)pSDEGCTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEGCTypeBase.getPSDEGCTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegctypeid", (Object)PSDEGCTypeBase.getJSONValue((Object)pSDEGCTypeBase.getPSDEGCTypeId()), (boolean)false);
        }
        if (bl || pSDEGCTypeBase.getPSDEGCTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegctypename", (Object)PSDEGCTypeBase.getJSONValue((Object)pSDEGCTypeBase.getPSDEGCTypeName()), (boolean)false);
        }
        if (bl || pSDEGCTypeBase.getTreeColumnObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"treecolumnobj", (Object)PSDEGCTypeBase.getJSONValue((Object)pSDEGCTypeBase.getTreeColumnObj()), (boolean)false);
        }
        if (bl || pSDEGCTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEGCTypeBase.getJSONValue((Object)pSDEGCTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEGCTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEGCTypeBase.getJSONValue((Object)pSDEGCTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEGCTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEGCTypeBase pSDEGCTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEGCTypeBase.getCOLUMNOBJ() != null) {
            object = pSDEGCTypeBase.getCOLUMNOBJ();
            xmlNode.setAttribute(FIELD_COLUMNOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEGCTypeBase.getCreateDate() != null) {
            object = pSDEGCTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGCTypeBase.getCreateMan() != null) {
            object = pSDEGCTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGCTypeBase.getMemo() != null) {
            object = pSDEGCTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEGCTypeBase.getPSDEGCTypeId() != null) {
            object = pSDEGCTypeBase.getPSDEGCTypeId();
            xmlNode.setAttribute(FIELD_PSDEGCTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGCTypeBase.getPSDEGCTypeName() != null) {
            object = pSDEGCTypeBase.getPSDEGCTypeName();
            xmlNode.setAttribute(FIELD_PSDEGCTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGCTypeBase.getTreeColumnObj() != null) {
            object = pSDEGCTypeBase.getTreeColumnObj();
            xmlNode.setAttribute(FIELD_TREECOLUMNOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEGCTypeBase.getUpdateDate() != null) {
            object = pSDEGCTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGCTypeBase.getUpdateMan() != null) {
            object = pSDEGCTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEGCTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEGCTypeBase pSDEGCTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEGCTypeBase.isCOLUMNOBJDirty() && (bl || pSDEGCTypeBase.getCOLUMNOBJ() != null)) {
            iDataObject.set(FIELD_COLUMNOBJ, (Object)pSDEGCTypeBase.getCOLUMNOBJ());
        }
        if (pSDEGCTypeBase.isCreateDateDirty() && (bl || pSDEGCTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEGCTypeBase.getCreateDate());
        }
        if (pSDEGCTypeBase.isCreateManDirty() && (bl || pSDEGCTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEGCTypeBase.getCreateMan());
        }
        if (pSDEGCTypeBase.isMemoDirty() && (bl || pSDEGCTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEGCTypeBase.getMemo());
        }
        if (pSDEGCTypeBase.isPSDEGCTypeIdDirty() && (bl || pSDEGCTypeBase.getPSDEGCTypeId() != null)) {
            iDataObject.set(FIELD_PSDEGCTYPEID, (Object)pSDEGCTypeBase.getPSDEGCTypeId());
        }
        if (pSDEGCTypeBase.isPSDEGCTypeNameDirty() && (bl || pSDEGCTypeBase.getPSDEGCTypeName() != null)) {
            iDataObject.set(FIELD_PSDEGCTYPENAME, (Object)pSDEGCTypeBase.getPSDEGCTypeName());
        }
        if (pSDEGCTypeBase.isTreeColumnObjDirty() && (bl || pSDEGCTypeBase.getTreeColumnObj() != null)) {
            iDataObject.set(FIELD_TREECOLUMNOBJ, (Object)pSDEGCTypeBase.getTreeColumnObj());
        }
        if (pSDEGCTypeBase.isUpdateDateDirty() && (bl || pSDEGCTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEGCTypeBase.getUpdateDate());
        }
        if (pSDEGCTypeBase.isUpdateManDirty() && (bl || pSDEGCTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEGCTypeBase.getUpdateMan());
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
        return PSDEGCTypeBase.remove(this, n);
    }

    private static boolean remove(PSDEGCTypeBase pSDEGCTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEGCTypeBase.resetCOLUMNOBJ();
                return true;
            }
            case 1: {
                pSDEGCTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEGCTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEGCTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEGCTypeBase.resetPSDEGCTypeId();
                return true;
            }
            case 5: {
                pSDEGCTypeBase.resetPSDEGCTypeName();
                return true;
            }
            case 6: {
                pSDEGCTypeBase.resetTreeColumnObj();
                return true;
            }
            case 7: {
                pSDEGCTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSDEGCTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDEGCTypeBase getProxyEntity() {
        return this.proxyPSDEGCTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEGCTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEGCTypeBase) {
            this.proxyPSDEGCTypeBase = (PSDEGCTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEGCTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_COLUMNOBJ, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEGCTYPEID, 4);
        fieldIndexMap.put(FIELD_PSDEGCTYPENAME, 5);
        fieldIndexMap.put(FIELD_TREECOLUMNOBJ, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

