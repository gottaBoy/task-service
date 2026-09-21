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

public abstract class PSTreeNodeTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSTreeNodeTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSTREENODETYPEID = "PSTREENODETYPEID";
    public static final String FIELD_PSTREENODETYPENAME = "PSTREENODETYPENAME";
    public static final String FIELD_TREENODEOBJ = "TREENODEOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSTREENODETYPEID = 3;
    private static final int INDEX_PSTREENODETYPENAME = 4;
    private static final int INDEX_TREENODEOBJ = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSTreeNodeTypeBase proxyPSTreeNodeTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pstreenodetypeidDirtyFlag = false;
    private boolean pstreenodetypenameDirtyFlag = false;
    private boolean treenodeobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pstreenodetypeid")
    private String pstreenodetypeid;
    @Column(name="pstreenodetypename")
    private String pstreenodetypename;
    @Column(name="treenodeobj")
    private String treenodeobj;
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

    public void setPSTreeNodeTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTreeNodeTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstreenodetypeid = string;
        this.pstreenodetypeidDirtyFlag = true;
    }

    public String getPSTreeNodeTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTreeNodeTypeId();
        }
        return this.pstreenodetypeid;
    }

    public boolean isPSTreeNodeTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTreeNodeTypeIdDirty();
        }
        return this.pstreenodetypeidDirtyFlag;
    }

    public void resetPSTreeNodeTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTreeNodeTypeId();
            return;
        }
        this.pstreenodetypeidDirtyFlag = false;
        this.pstreenodetypeid = null;
    }

    public void setPSTreeNodeTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTreeNodeTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstreenodetypename = string;
        this.pstreenodetypenameDirtyFlag = true;
    }

    public String getPSTreeNodeTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTreeNodeTypeName();
        }
        return this.pstreenodetypename;
    }

    public boolean isPSTreeNodeTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTreeNodeTypeNameDirty();
        }
        return this.pstreenodetypenameDirtyFlag;
    }

    public void resetPSTreeNodeTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTreeNodeTypeName();
            return;
        }
        this.pstreenodetypenameDirtyFlag = false;
        this.pstreenodetypename = null;
    }

    public void setTreeNodeObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTreeNodeObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.treenodeobj = string;
        this.treenodeobjDirtyFlag = true;
    }

    public String getTreeNodeObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTreeNodeObj();
        }
        return this.treenodeobj;
    }

    public boolean isTreeNodeObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTreeNodeObjDirty();
        }
        return this.treenodeobjDirtyFlag;
    }

    public void resetTreeNodeObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTreeNodeObj();
            return;
        }
        this.treenodeobjDirtyFlag = false;
        this.treenodeobj = null;
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
        PSTreeNodeTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSTreeNodeTypeBase pSTreeNodeTypeBase) {
        pSTreeNodeTypeBase.resetCreateDate();
        pSTreeNodeTypeBase.resetCreateMan();
        pSTreeNodeTypeBase.resetMemo();
        pSTreeNodeTypeBase.resetPSTreeNodeTypeId();
        pSTreeNodeTypeBase.resetPSTreeNodeTypeName();
        pSTreeNodeTypeBase.resetTreeNodeObj();
        pSTreeNodeTypeBase.resetUpdateDate();
        pSTreeNodeTypeBase.resetUpdateMan();
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
        if (!bl || this.isPSTreeNodeTypeIdDirty()) {
            hashMap.put(FIELD_PSTREENODETYPEID, this.getPSTreeNodeTypeId());
        }
        if (!bl || this.isPSTreeNodeTypeNameDirty()) {
            hashMap.put(FIELD_PSTREENODETYPENAME, this.getPSTreeNodeTypeName());
        }
        if (!bl || this.isTreeNodeObjDirty()) {
            hashMap.put(FIELD_TREENODEOBJ, this.getTreeNodeObj());
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
        return PSTreeNodeTypeBase.get(this, n);
    }

    private static Object get(PSTreeNodeTypeBase pSTreeNodeTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSTreeNodeTypeBase.getCreateDate();
            }
            case 1: {
                return pSTreeNodeTypeBase.getCreateMan();
            }
            case 2: {
                return pSTreeNodeTypeBase.getMemo();
            }
            case 3: {
                return pSTreeNodeTypeBase.getPSTreeNodeTypeId();
            }
            case 4: {
                return pSTreeNodeTypeBase.getPSTreeNodeTypeName();
            }
            case 5: {
                return pSTreeNodeTypeBase.getTreeNodeObj();
            }
            case 6: {
                return pSTreeNodeTypeBase.getUpdateDate();
            }
            case 7: {
                return pSTreeNodeTypeBase.getUpdateMan();
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
        PSTreeNodeTypeBase.set(this, n, object);
    }

    private static void set(PSTreeNodeTypeBase pSTreeNodeTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSTreeNodeTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSTreeNodeTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSTreeNodeTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSTreeNodeTypeBase.setPSTreeNodeTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSTreeNodeTypeBase.setPSTreeNodeTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSTreeNodeTypeBase.setTreeNodeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSTreeNodeTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSTreeNodeTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSTreeNodeTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSTreeNodeTypeBase pSTreeNodeTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSTreeNodeTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSTreeNodeTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSTreeNodeTypeBase.getMemo() == null;
            }
            case 3: {
                return pSTreeNodeTypeBase.getPSTreeNodeTypeId() == null;
            }
            case 4: {
                return pSTreeNodeTypeBase.getPSTreeNodeTypeName() == null;
            }
            case 5: {
                return pSTreeNodeTypeBase.getTreeNodeObj() == null;
            }
            case 6: {
                return pSTreeNodeTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSTreeNodeTypeBase.getUpdateMan() == null;
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
        return PSTreeNodeTypeBase.contains(this, n);
    }

    private static boolean contains(PSTreeNodeTypeBase pSTreeNodeTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSTreeNodeTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSTreeNodeTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSTreeNodeTypeBase.isMemoDirty();
            }
            case 3: {
                return pSTreeNodeTypeBase.isPSTreeNodeTypeIdDirty();
            }
            case 4: {
                return pSTreeNodeTypeBase.isPSTreeNodeTypeNameDirty();
            }
            case 5: {
                return pSTreeNodeTypeBase.isTreeNodeObjDirty();
            }
            case 6: {
                return pSTreeNodeTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSTreeNodeTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSTreeNodeTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSTreeNodeTypeBase pSTreeNodeTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSTreeNodeTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSTreeNodeTypeBase.getJSONValue((Object)pSTreeNodeTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSTreeNodeTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSTreeNodeTypeBase.getJSONValue((Object)pSTreeNodeTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSTreeNodeTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSTreeNodeTypeBase.getJSONValue((Object)pSTreeNodeTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSTreeNodeTypeBase.getPSTreeNodeTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstreenodetypeid", (Object)PSTreeNodeTypeBase.getJSONValue((Object)pSTreeNodeTypeBase.getPSTreeNodeTypeId()), (boolean)false);
        }
        if (bl || pSTreeNodeTypeBase.getPSTreeNodeTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstreenodetypename", (Object)PSTreeNodeTypeBase.getJSONValue((Object)pSTreeNodeTypeBase.getPSTreeNodeTypeName()), (boolean)false);
        }
        if (bl || pSTreeNodeTypeBase.getTreeNodeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"treenodeobj", (Object)PSTreeNodeTypeBase.getJSONValue((Object)pSTreeNodeTypeBase.getTreeNodeObj()), (boolean)false);
        }
        if (bl || pSTreeNodeTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSTreeNodeTypeBase.getJSONValue((Object)pSTreeNodeTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSTreeNodeTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSTreeNodeTypeBase.getJSONValue((Object)pSTreeNodeTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSTreeNodeTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSTreeNodeTypeBase pSTreeNodeTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSTreeNodeTypeBase.getCreateDate() != null) {
            object = pSTreeNodeTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSTreeNodeTypeBase.getCreateMan() != null) {
            object = pSTreeNodeTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSTreeNodeTypeBase.getMemo() != null) {
            object = pSTreeNodeTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSTreeNodeTypeBase.getPSTreeNodeTypeId() != null) {
            object = pSTreeNodeTypeBase.getPSTreeNodeTypeId();
            xmlNode.setAttribute(FIELD_PSTREENODETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSTreeNodeTypeBase.getPSTreeNodeTypeName() != null) {
            object = pSTreeNodeTypeBase.getPSTreeNodeTypeName();
            xmlNode.setAttribute(FIELD_PSTREENODETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSTreeNodeTypeBase.getTreeNodeObj() != null) {
            object = pSTreeNodeTypeBase.getTreeNodeObj();
            xmlNode.setAttribute(FIELD_TREENODEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSTreeNodeTypeBase.getUpdateDate() != null) {
            object = pSTreeNodeTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSTreeNodeTypeBase.getUpdateMan() != null) {
            object = pSTreeNodeTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSTreeNodeTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSTreeNodeTypeBase pSTreeNodeTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSTreeNodeTypeBase.isCreateDateDirty() && (bl || pSTreeNodeTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSTreeNodeTypeBase.getCreateDate());
        }
        if (pSTreeNodeTypeBase.isCreateManDirty() && (bl || pSTreeNodeTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSTreeNodeTypeBase.getCreateMan());
        }
        if (pSTreeNodeTypeBase.isMemoDirty() && (bl || pSTreeNodeTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSTreeNodeTypeBase.getMemo());
        }
        if (pSTreeNodeTypeBase.isPSTreeNodeTypeIdDirty() && (bl || pSTreeNodeTypeBase.getPSTreeNodeTypeId() != null)) {
            iDataObject.set(FIELD_PSTREENODETYPEID, (Object)pSTreeNodeTypeBase.getPSTreeNodeTypeId());
        }
        if (pSTreeNodeTypeBase.isPSTreeNodeTypeNameDirty() && (bl || pSTreeNodeTypeBase.getPSTreeNodeTypeName() != null)) {
            iDataObject.set(FIELD_PSTREENODETYPENAME, (Object)pSTreeNodeTypeBase.getPSTreeNodeTypeName());
        }
        if (pSTreeNodeTypeBase.isTreeNodeObjDirty() && (bl || pSTreeNodeTypeBase.getTreeNodeObj() != null)) {
            iDataObject.set(FIELD_TREENODEOBJ, (Object)pSTreeNodeTypeBase.getTreeNodeObj());
        }
        if (pSTreeNodeTypeBase.isUpdateDateDirty() && (bl || pSTreeNodeTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSTreeNodeTypeBase.getUpdateDate());
        }
        if (pSTreeNodeTypeBase.isUpdateManDirty() && (bl || pSTreeNodeTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSTreeNodeTypeBase.getUpdateMan());
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
        return PSTreeNodeTypeBase.remove(this, n);
    }

    private static boolean remove(PSTreeNodeTypeBase pSTreeNodeTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSTreeNodeTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSTreeNodeTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSTreeNodeTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSTreeNodeTypeBase.resetPSTreeNodeTypeId();
                return true;
            }
            case 4: {
                pSTreeNodeTypeBase.resetPSTreeNodeTypeName();
                return true;
            }
            case 5: {
                pSTreeNodeTypeBase.resetTreeNodeObj();
                return true;
            }
            case 6: {
                pSTreeNodeTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSTreeNodeTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSTreeNodeTypeBase getProxyEntity() {
        return this.proxyPSTreeNodeTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSTreeNodeTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSTreeNodeTypeBase) {
            this.proxyPSTreeNodeTypeBase = (PSTreeNodeTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSTreeNodeTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSTREENODETYPEID, 3);
        fieldIndexMap.put(FIELD_PSTREENODETYPENAME, 4);
        fieldIndexMap.put(FIELD_TREENODEOBJ, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

