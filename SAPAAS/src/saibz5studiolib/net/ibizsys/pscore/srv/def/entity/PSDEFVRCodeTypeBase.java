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
package net.ibizsys.pscore.srv.def.entity;

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

public abstract class PSDEFVRCodeTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFVRCodeTypeBase.class);
    public static final String FIELD_CODETYPE = "CODETYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MAINTYPE = "MAINTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEFVRCODETYPEID = "PSDEFVRCODETYPEID";
    public static final String FIELD_PSDEFVRCODETYPENAME = "PSDEFVRCODETYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODETYPE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MAINTYPE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEFVRCODETYPEID = 5;
    private static final int INDEX_PSDEFVRCODETYPENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFVRCodeTypeBase proxyPSDEFVRCodeTypeBase = null;
    private boolean codetypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean maintypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdefvrcodetypeidDirtyFlag = false;
    private boolean psdefvrcodetypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codetype")
    private String codetype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="maintype")
    private String maintype;
    @Column(name="memo")
    private String memo;
    @Column(name="psdefvrcodetypeid")
    private String psdefvrcodetypeid;
    @Column(name="psdefvrcodetypename")
    private String psdefvrcodetypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public void setCodeType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codetype = string;
        this.codetypeDirtyFlag = true;
    }

    public String getCodeType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeType();
        }
        return this.codetype;
    }

    public boolean isCodeTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeTypeDirty();
        }
        return this.codetypeDirtyFlag;
    }

    public void resetCodeType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeType();
            return;
        }
        this.codetypeDirtyFlag = false;
        this.codetype = null;
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

    public void setMainType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMainType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maintype = string;
        this.maintypeDirtyFlag = true;
    }

    public String getMainType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMainType();
        }
        return this.maintype;
    }

    public boolean isMainTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMainTypeDirty();
        }
        return this.maintypeDirtyFlag;
    }

    public void resetMainType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMainType();
            return;
        }
        this.maintypeDirtyFlag = false;
        this.maintype = null;
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

    public void setPSDEFVRCodeTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRCodeTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrcodetypeid = string;
        this.psdefvrcodetypeidDirtyFlag = true;
    }

    public String getPSDEFVRCodeTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRCodeTypeId();
        }
        return this.psdefvrcodetypeid;
    }

    public boolean isPSDEFVRCodeTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRCodeTypeIdDirty();
        }
        return this.psdefvrcodetypeidDirtyFlag;
    }

    public void resetPSDEFVRCodeTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRCodeTypeId();
            return;
        }
        this.psdefvrcodetypeidDirtyFlag = false;
        this.psdefvrcodetypeid = null;
    }

    public void setPSDEFVRCodeTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRCodeTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrcodetypename = string;
        this.psdefvrcodetypenameDirtyFlag = true;
    }

    public String getPSDEFVRCodeTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRCodeTypeName();
        }
        return this.psdefvrcodetypename;
    }

    public boolean isPSDEFVRCodeTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRCodeTypeNameDirty();
        }
        return this.psdefvrcodetypenameDirtyFlag;
    }

    public void resetPSDEFVRCodeTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRCodeTypeName();
            return;
        }
        this.psdefvrcodetypenameDirtyFlag = false;
        this.psdefvrcodetypename = null;
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
        PSDEFVRCodeTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFVRCodeTypeBase pSDEFVRCodeTypeBase) {
        pSDEFVRCodeTypeBase.resetCodeType();
        pSDEFVRCodeTypeBase.resetCreateDate();
        pSDEFVRCodeTypeBase.resetCreateMan();
        pSDEFVRCodeTypeBase.resetMainType();
        pSDEFVRCodeTypeBase.resetMemo();
        pSDEFVRCodeTypeBase.resetPSDEFVRCodeTypeId();
        pSDEFVRCodeTypeBase.resetPSDEFVRCodeTypeName();
        pSDEFVRCodeTypeBase.resetUpdateDate();
        pSDEFVRCodeTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeTypeDirty()) {
            hashMap.put(FIELD_CODETYPE, this.getCodeType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMainTypeDirty()) {
            hashMap.put(FIELD_MAINTYPE, this.getMainType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEFVRCodeTypeIdDirty()) {
            hashMap.put(FIELD_PSDEFVRCODETYPEID, this.getPSDEFVRCodeTypeId());
        }
        if (!bl || this.isPSDEFVRCodeTypeNameDirty()) {
            hashMap.put(FIELD_PSDEFVRCODETYPENAME, this.getPSDEFVRCodeTypeName());
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
        return PSDEFVRCodeTypeBase.get(this, n);
    }

    private static Object get(PSDEFVRCodeTypeBase pSDEFVRCodeTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFVRCodeTypeBase.getCodeType();
            }
            case 1: {
                return pSDEFVRCodeTypeBase.getCreateDate();
            }
            case 2: {
                return pSDEFVRCodeTypeBase.getCreateMan();
            }
            case 3: {
                return pSDEFVRCodeTypeBase.getMainType();
            }
            case 4: {
                return pSDEFVRCodeTypeBase.getMemo();
            }
            case 5: {
                return pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeId();
            }
            case 6: {
                return pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeName();
            }
            case 7: {
                return pSDEFVRCodeTypeBase.getUpdateDate();
            }
            case 8: {
                return pSDEFVRCodeTypeBase.getUpdateMan();
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
        PSDEFVRCodeTypeBase.set(this, n, object);
    }

    private static void set(PSDEFVRCodeTypeBase pSDEFVRCodeTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFVRCodeTypeBase.setCodeType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEFVRCodeTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEFVRCodeTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFVRCodeTypeBase.setMainType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFVRCodeTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFVRCodeTypeBase.setPSDEFVRCodeTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFVRCodeTypeBase.setPSDEFVRCodeTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFVRCodeTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDEFVRCodeTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEFVRCodeTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFVRCodeTypeBase pSDEFVRCodeTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFVRCodeTypeBase.getCodeType() == null;
            }
            case 1: {
                return pSDEFVRCodeTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEFVRCodeTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEFVRCodeTypeBase.getMainType() == null;
            }
            case 4: {
                return pSDEFVRCodeTypeBase.getMemo() == null;
            }
            case 5: {
                return pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeId() == null;
            }
            case 6: {
                return pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeName() == null;
            }
            case 7: {
                return pSDEFVRCodeTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSDEFVRCodeTypeBase.getUpdateMan() == null;
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
        return PSDEFVRCodeTypeBase.contains(this, n);
    }

    private static boolean contains(PSDEFVRCodeTypeBase pSDEFVRCodeTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFVRCodeTypeBase.isCodeTypeDirty();
            }
            case 1: {
                return pSDEFVRCodeTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEFVRCodeTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSDEFVRCodeTypeBase.isMainTypeDirty();
            }
            case 4: {
                return pSDEFVRCodeTypeBase.isMemoDirty();
            }
            case 5: {
                return pSDEFVRCodeTypeBase.isPSDEFVRCodeTypeIdDirty();
            }
            case 6: {
                return pSDEFVRCodeTypeBase.isPSDEFVRCodeTypeNameDirty();
            }
            case 7: {
                return pSDEFVRCodeTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSDEFVRCodeTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFVRCodeTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFVRCodeTypeBase pSDEFVRCodeTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFVRCodeTypeBase.getCodeType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codetype", (Object)PSDEFVRCodeTypeBase.getJSONValue((Object)pSDEFVRCodeTypeBase.getCodeType()), (boolean)false);
        }
        if (bl || pSDEFVRCodeTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFVRCodeTypeBase.getJSONValue((Object)pSDEFVRCodeTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFVRCodeTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFVRCodeTypeBase.getJSONValue((Object)pSDEFVRCodeTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFVRCodeTypeBase.getMainType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maintype", (Object)PSDEFVRCodeTypeBase.getJSONValue((Object)pSDEFVRCodeTypeBase.getMainType()), (boolean)false);
        }
        if (bl || pSDEFVRCodeTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFVRCodeTypeBase.getJSONValue((Object)pSDEFVRCodeTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrcodetypeid", (Object)PSDEFVRCodeTypeBase.getJSONValue((Object)pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeId()), (boolean)false);
        }
        if (bl || pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrcodetypename", (Object)PSDEFVRCodeTypeBase.getJSONValue((Object)pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeName()), (boolean)false);
        }
        if (bl || pSDEFVRCodeTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFVRCodeTypeBase.getJSONValue((Object)pSDEFVRCodeTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFVRCodeTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFVRCodeTypeBase.getJSONValue((Object)pSDEFVRCodeTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFVRCodeTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFVRCodeTypeBase pSDEFVRCodeTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFVRCodeTypeBase.getCodeType() != null) {
            object = pSDEFVRCodeTypeBase.getCodeType();
            xmlNode.setAttribute(FIELD_CODETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCodeTypeBase.getCreateDate() != null) {
            object = pSDEFVRCodeTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFVRCodeTypeBase.getCreateMan() != null) {
            object = pSDEFVRCodeTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCodeTypeBase.getMainType() != null) {
            object = pSDEFVRCodeTypeBase.getMainType();
            xmlNode.setAttribute(FIELD_MAINTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCodeTypeBase.getMemo() != null) {
            object = pSDEFVRCodeTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeId() != null) {
            object = pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeId();
            xmlNode.setAttribute(FIELD_PSDEFVRCODETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeName() != null) {
            object = pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeName();
            xmlNode.setAttribute(FIELD_PSDEFVRCODETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRCodeTypeBase.getUpdateDate() != null) {
            object = pSDEFVRCodeTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFVRCodeTypeBase.getUpdateMan() != null) {
            object = pSDEFVRCodeTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFVRCodeTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFVRCodeTypeBase pSDEFVRCodeTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFVRCodeTypeBase.isCodeTypeDirty() && (bl || pSDEFVRCodeTypeBase.getCodeType() != null)) {
            iDataObject.set(FIELD_CODETYPE, (Object)pSDEFVRCodeTypeBase.getCodeType());
        }
        if (pSDEFVRCodeTypeBase.isCreateDateDirty() && (bl || pSDEFVRCodeTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFVRCodeTypeBase.getCreateDate());
        }
        if (pSDEFVRCodeTypeBase.isCreateManDirty() && (bl || pSDEFVRCodeTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFVRCodeTypeBase.getCreateMan());
        }
        if (pSDEFVRCodeTypeBase.isMainTypeDirty() && (bl || pSDEFVRCodeTypeBase.getMainType() != null)) {
            iDataObject.set(FIELD_MAINTYPE, (Object)pSDEFVRCodeTypeBase.getMainType());
        }
        if (pSDEFVRCodeTypeBase.isMemoDirty() && (bl || pSDEFVRCodeTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFVRCodeTypeBase.getMemo());
        }
        if (pSDEFVRCodeTypeBase.isPSDEFVRCodeTypeIdDirty() && (bl || pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeId() != null)) {
            iDataObject.set(FIELD_PSDEFVRCODETYPEID, (Object)pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeId());
        }
        if (pSDEFVRCodeTypeBase.isPSDEFVRCodeTypeNameDirty() && (bl || pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeName() != null)) {
            iDataObject.set(FIELD_PSDEFVRCODETYPENAME, (Object)pSDEFVRCodeTypeBase.getPSDEFVRCodeTypeName());
        }
        if (pSDEFVRCodeTypeBase.isUpdateDateDirty() && (bl || pSDEFVRCodeTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFVRCodeTypeBase.getUpdateDate());
        }
        if (pSDEFVRCodeTypeBase.isUpdateManDirty() && (bl || pSDEFVRCodeTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFVRCodeTypeBase.getUpdateMan());
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
        return PSDEFVRCodeTypeBase.remove(this, n);
    }

    private static boolean remove(PSDEFVRCodeTypeBase pSDEFVRCodeTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFVRCodeTypeBase.resetCodeType();
                return true;
            }
            case 1: {
                pSDEFVRCodeTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEFVRCodeTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEFVRCodeTypeBase.resetMainType();
                return true;
            }
            case 4: {
                pSDEFVRCodeTypeBase.resetMemo();
                return true;
            }
            case 5: {
                pSDEFVRCodeTypeBase.resetPSDEFVRCodeTypeId();
                return true;
            }
            case 6: {
                pSDEFVRCodeTypeBase.resetPSDEFVRCodeTypeName();
                return true;
            }
            case 7: {
                pSDEFVRCodeTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSDEFVRCodeTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDEFVRCodeTypeBase getProxyEntity() {
        return this.proxyPSDEFVRCodeTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFVRCodeTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFVRCodeTypeBase) {
            this.proxyPSDEFVRCodeTypeBase = (PSDEFVRCodeTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSDEFVRCodeTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODETYPE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MAINTYPE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEFVRCODETYPEID, 5);
        fieldIndexMap.put(FIELD_PSDEFVRCODETYPENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

