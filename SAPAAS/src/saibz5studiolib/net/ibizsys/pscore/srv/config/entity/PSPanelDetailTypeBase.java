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

public abstract class PSPanelDetailTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPanelDetailTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DETAILOBJ = "DETAILOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPANELDETAILTYPEID = "PSPANELDETAILTYPEID";
    public static final String FIELD_PSPANELDETAILTYPENAME = "PSPANELDETAILTYPENAME";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DETAILOBJ = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSPANELDETAILTYPEID = 4;
    private static final int INDEX_PSPANELDETAILTYPENAME = 5;
    private static final int INDEX_TYPEOBJ = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPanelDetailTypeBase proxyPSPanelDetailTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean detailobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspaneldetailtypeidDirtyFlag = false;
    private boolean pspaneldetailtypenameDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="detailobj")
    private String detailobj;
    @Column(name="memo")
    private String memo;
    @Column(name="pspaneldetailtypeid")
    private String pspaneldetailtypeid;
    @Column(name="pspaneldetailtypename")
    private String pspaneldetailtypename;
    @Column(name="typeobj")
    private String typeobj;
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

    public void setDetailOBJ(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailOBJ(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailobj = string;
        this.detailobjDirtyFlag = true;
    }

    public String getDetailOBJ() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailOBJ();
        }
        return this.detailobj;
    }

    public boolean isDetailOBJDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailOBJDirty();
        }
        return this.detailobjDirtyFlag;
    }

    public void resetDetailOBJ() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailOBJ();
            return;
        }
        this.detailobjDirtyFlag = false;
        this.detailobj = null;
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

    public void setPSPanelDetailTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelDetailTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspaneldetailtypeid = string;
        this.pspaneldetailtypeidDirtyFlag = true;
    }

    public String getPSPanelDetailTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelDetailTypeId();
        }
        return this.pspaneldetailtypeid;
    }

    public boolean isPSPanelDetailTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelDetailTypeIdDirty();
        }
        return this.pspaneldetailtypeidDirtyFlag;
    }

    public void resetPSPanelDetailTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelDetailTypeId();
            return;
        }
        this.pspaneldetailtypeidDirtyFlag = false;
        this.pspaneldetailtypeid = null;
    }

    public void setPSPanelDetailTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelDetailTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspaneldetailtypename = string;
        this.pspaneldetailtypenameDirtyFlag = true;
    }

    public String getPSPanelDetailTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelDetailTypeName();
        }
        return this.pspaneldetailtypename;
    }

    public boolean isPSPanelDetailTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelDetailTypeNameDirty();
        }
        return this.pspaneldetailtypenameDirtyFlag;
    }

    public void resetPSPanelDetailTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelDetailTypeName();
            return;
        }
        this.pspaneldetailtypenameDirtyFlag = false;
        this.pspaneldetailtypename = null;
    }

    public void setTypeObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeobj = string;
        this.typeobjDirtyFlag = true;
    }

    public String getTypeObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeObj();
        }
        return this.typeobj;
    }

    public boolean isTypeObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeObjDirty();
        }
        return this.typeobjDirtyFlag;
    }

    public void resetTypeObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeObj();
            return;
        }
        this.typeobjDirtyFlag = false;
        this.typeobj = null;
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
        PSPanelDetailTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPanelDetailTypeBase pSPanelDetailTypeBase) {
        pSPanelDetailTypeBase.resetCreateDate();
        pSPanelDetailTypeBase.resetCreateMan();
        pSPanelDetailTypeBase.resetDetailOBJ();
        pSPanelDetailTypeBase.resetMemo();
        pSPanelDetailTypeBase.resetPSPanelDetailTypeId();
        pSPanelDetailTypeBase.resetPSPanelDetailTypeName();
        pSPanelDetailTypeBase.resetTypeObj();
        pSPanelDetailTypeBase.resetUpdateDate();
        pSPanelDetailTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDetailOBJDirty()) {
            hashMap.put(FIELD_DETAILOBJ, this.getDetailOBJ());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSPanelDetailTypeIdDirty()) {
            hashMap.put(FIELD_PSPANELDETAILTYPEID, this.getPSPanelDetailTypeId());
        }
        if (!bl || this.isPSPanelDetailTypeNameDirty()) {
            hashMap.put(FIELD_PSPANELDETAILTYPENAME, this.getPSPanelDetailTypeName());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
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
        return PSPanelDetailTypeBase.get(this, n);
    }

    private static Object get(PSPanelDetailTypeBase pSPanelDetailTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelDetailTypeBase.getCreateDate();
            }
            case 1: {
                return pSPanelDetailTypeBase.getCreateMan();
            }
            case 2: {
                return pSPanelDetailTypeBase.getDetailOBJ();
            }
            case 3: {
                return pSPanelDetailTypeBase.getMemo();
            }
            case 4: {
                return pSPanelDetailTypeBase.getPSPanelDetailTypeId();
            }
            case 5: {
                return pSPanelDetailTypeBase.getPSPanelDetailTypeName();
            }
            case 6: {
                return pSPanelDetailTypeBase.getTypeObj();
            }
            case 7: {
                return pSPanelDetailTypeBase.getUpdateDate();
            }
            case 8: {
                return pSPanelDetailTypeBase.getUpdateMan();
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
        PSPanelDetailTypeBase.set(this, n, object);
    }

    private static void set(PSPanelDetailTypeBase pSPanelDetailTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPanelDetailTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPanelDetailTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPanelDetailTypeBase.setDetailOBJ(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPanelDetailTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPanelDetailTypeBase.setPSPanelDetailTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPanelDetailTypeBase.setPSPanelDetailTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPanelDetailTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPanelDetailTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSPanelDetailTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPanelDetailTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSPanelDetailTypeBase pSPanelDetailTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelDetailTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSPanelDetailTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSPanelDetailTypeBase.getDetailOBJ() == null;
            }
            case 3: {
                return pSPanelDetailTypeBase.getMemo() == null;
            }
            case 4: {
                return pSPanelDetailTypeBase.getPSPanelDetailTypeId() == null;
            }
            case 5: {
                return pSPanelDetailTypeBase.getPSPanelDetailTypeName() == null;
            }
            case 6: {
                return pSPanelDetailTypeBase.getTypeObj() == null;
            }
            case 7: {
                return pSPanelDetailTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSPanelDetailTypeBase.getUpdateMan() == null;
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
        return PSPanelDetailTypeBase.contains(this, n);
    }

    private static boolean contains(PSPanelDetailTypeBase pSPanelDetailTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelDetailTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSPanelDetailTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSPanelDetailTypeBase.isDetailOBJDirty();
            }
            case 3: {
                return pSPanelDetailTypeBase.isMemoDirty();
            }
            case 4: {
                return pSPanelDetailTypeBase.isPSPanelDetailTypeIdDirty();
            }
            case 5: {
                return pSPanelDetailTypeBase.isPSPanelDetailTypeNameDirty();
            }
            case 6: {
                return pSPanelDetailTypeBase.isTypeObjDirty();
            }
            case 7: {
                return pSPanelDetailTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSPanelDetailTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPanelDetailTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPanelDetailTypeBase pSPanelDetailTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPanelDetailTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPanelDetailTypeBase.getJSONValue((Object)pSPanelDetailTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPanelDetailTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPanelDetailTypeBase.getJSONValue((Object)pSPanelDetailTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPanelDetailTypeBase.getDetailOBJ() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailobj", (Object)PSPanelDetailTypeBase.getJSONValue((Object)pSPanelDetailTypeBase.getDetailOBJ()), (boolean)false);
        }
        if (bl || pSPanelDetailTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPanelDetailTypeBase.getJSONValue((Object)pSPanelDetailTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSPanelDetailTypeBase.getPSPanelDetailTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspaneldetailtypeid", (Object)PSPanelDetailTypeBase.getJSONValue((Object)pSPanelDetailTypeBase.getPSPanelDetailTypeId()), (boolean)false);
        }
        if (bl || pSPanelDetailTypeBase.getPSPanelDetailTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspaneldetailtypename", (Object)PSPanelDetailTypeBase.getJSONValue((Object)pSPanelDetailTypeBase.getPSPanelDetailTypeName()), (boolean)false);
        }
        if (bl || pSPanelDetailTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSPanelDetailTypeBase.getJSONValue((Object)pSPanelDetailTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSPanelDetailTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPanelDetailTypeBase.getJSONValue((Object)pSPanelDetailTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPanelDetailTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPanelDetailTypeBase.getJSONValue((Object)pSPanelDetailTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPanelDetailTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPanelDetailTypeBase pSPanelDetailTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPanelDetailTypeBase.getCreateDate() != null) {
            object = pSPanelDetailTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelDetailTypeBase.getCreateMan() != null) {
            object = pSPanelDetailTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPanelDetailTypeBase.getDetailOBJ() != null) {
            object = pSPanelDetailTypeBase.getDetailOBJ();
            xmlNode.setAttribute(FIELD_DETAILOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPanelDetailTypeBase.getMemo() != null) {
            object = pSPanelDetailTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPanelDetailTypeBase.getPSPanelDetailTypeId() != null) {
            object = pSPanelDetailTypeBase.getPSPanelDetailTypeId();
            xmlNode.setAttribute(FIELD_PSPANELDETAILTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelDetailTypeBase.getPSPanelDetailTypeName() != null) {
            object = pSPanelDetailTypeBase.getPSPanelDetailTypeName();
            xmlNode.setAttribute(FIELD_PSPANELDETAILTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelDetailTypeBase.getTypeObj() != null) {
            object = pSPanelDetailTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPanelDetailTypeBase.getUpdateDate() != null) {
            object = pSPanelDetailTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelDetailTypeBase.getUpdateMan() != null) {
            object = pSPanelDetailTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPanelDetailTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPanelDetailTypeBase pSPanelDetailTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPanelDetailTypeBase.isCreateDateDirty() && (bl || pSPanelDetailTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPanelDetailTypeBase.getCreateDate());
        }
        if (pSPanelDetailTypeBase.isCreateManDirty() && (bl || pSPanelDetailTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPanelDetailTypeBase.getCreateMan());
        }
        if (pSPanelDetailTypeBase.isDetailOBJDirty() && (bl || pSPanelDetailTypeBase.getDetailOBJ() != null)) {
            iDataObject.set(FIELD_DETAILOBJ, (Object)pSPanelDetailTypeBase.getDetailOBJ());
        }
        if (pSPanelDetailTypeBase.isMemoDirty() && (bl || pSPanelDetailTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPanelDetailTypeBase.getMemo());
        }
        if (pSPanelDetailTypeBase.isPSPanelDetailTypeIdDirty() && (bl || pSPanelDetailTypeBase.getPSPanelDetailTypeId() != null)) {
            iDataObject.set(FIELD_PSPANELDETAILTYPEID, (Object)pSPanelDetailTypeBase.getPSPanelDetailTypeId());
        }
        if (pSPanelDetailTypeBase.isPSPanelDetailTypeNameDirty() && (bl || pSPanelDetailTypeBase.getPSPanelDetailTypeName() != null)) {
            iDataObject.set(FIELD_PSPANELDETAILTYPENAME, (Object)pSPanelDetailTypeBase.getPSPanelDetailTypeName());
        }
        if (pSPanelDetailTypeBase.isTypeObjDirty() && (bl || pSPanelDetailTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSPanelDetailTypeBase.getTypeObj());
        }
        if (pSPanelDetailTypeBase.isUpdateDateDirty() && (bl || pSPanelDetailTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPanelDetailTypeBase.getUpdateDate());
        }
        if (pSPanelDetailTypeBase.isUpdateManDirty() && (bl || pSPanelDetailTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPanelDetailTypeBase.getUpdateMan());
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
        return PSPanelDetailTypeBase.remove(this, n);
    }

    private static boolean remove(PSPanelDetailTypeBase pSPanelDetailTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPanelDetailTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPanelDetailTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPanelDetailTypeBase.resetDetailOBJ();
                return true;
            }
            case 3: {
                pSPanelDetailTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSPanelDetailTypeBase.resetPSPanelDetailTypeId();
                return true;
            }
            case 5: {
                pSPanelDetailTypeBase.resetPSPanelDetailTypeName();
                return true;
            }
            case 6: {
                pSPanelDetailTypeBase.resetTypeObj();
                return true;
            }
            case 7: {
                pSPanelDetailTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSPanelDetailTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSPanelDetailTypeBase getProxyEntity() {
        return this.proxyPSPanelDetailTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPanelDetailTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSPanelDetailTypeBase) {
            this.proxyPSPanelDetailTypeBase = (PSPanelDetailTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPanelDetailTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DETAILOBJ, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSPANELDETAILTYPEID, 4);
        fieldIndexMap.put(FIELD_PSPANELDETAILTYPENAME, 5);
        fieldIndexMap.put(FIELD_TYPEOBJ, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

