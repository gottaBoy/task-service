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

public abstract class PSDEFVRTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFVRTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PROCESSOBJ = "PROCESSOBJ";
    public static final String FIELD_PSDEFVRTYPEID = "PSDEFVRTYPEID";
    public static final String FIELD_PSDEFVRTYPENAME = "PSDEFVRTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ICONPATH = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PROCESSOBJ = 4;
    private static final int INDEX_PSDEFVRTYPEID = 5;
    private static final int INDEX_PSDEFVRTYPENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFVRTypeBase proxyPSDEFVRTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean processobjDirtyFlag = false;
    private boolean psdefvrtypeidDirtyFlag = false;
    private boolean psdefvrtypenameDirtyFlag = false;
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
    @Column(name="psdefvrtypeid")
    private String psdefvrtypeid;
    @Column(name="psdefvrtypename")
    private String psdefvrtypename;
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

    public void setPSDEFVRTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrtypeid = string;
        this.psdefvrtypeidDirtyFlag = true;
    }

    public String getPSDEFVRTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRTypeId();
        }
        return this.psdefvrtypeid;
    }

    public boolean isPSDEFVRTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRTypeIdDirty();
        }
        return this.psdefvrtypeidDirtyFlag;
    }

    public void resetPSDEFVRTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRTypeId();
            return;
        }
        this.psdefvrtypeidDirtyFlag = false;
        this.psdefvrtypeid = null;
    }

    public void setPSDEFVRTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrtypename = string;
        this.psdefvrtypenameDirtyFlag = true;
    }

    public String getPSDEFVRTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRTypeName();
        }
        return this.psdefvrtypename;
    }

    public boolean isPSDEFVRTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRTypeNameDirty();
        }
        return this.psdefvrtypenameDirtyFlag;
    }

    public void resetPSDEFVRTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRTypeName();
            return;
        }
        this.psdefvrtypenameDirtyFlag = false;
        this.psdefvrtypename = null;
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
        PSDEFVRTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFVRTypeBase pSDEFVRTypeBase) {
        pSDEFVRTypeBase.resetCreateDate();
        pSDEFVRTypeBase.resetCreateMan();
        pSDEFVRTypeBase.resetIconPath();
        pSDEFVRTypeBase.resetMemo();
        pSDEFVRTypeBase.resetProcessObj();
        pSDEFVRTypeBase.resetPSDEFVRTypeId();
        pSDEFVRTypeBase.resetPSDEFVRTypeName();
        pSDEFVRTypeBase.resetUpdateDate();
        pSDEFVRTypeBase.resetUpdateMan();
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
        if (!bl || this.isPSDEFVRTypeIdDirty()) {
            hashMap.put(FIELD_PSDEFVRTYPEID, this.getPSDEFVRTypeId());
        }
        if (!bl || this.isPSDEFVRTypeNameDirty()) {
            hashMap.put(FIELD_PSDEFVRTYPENAME, this.getPSDEFVRTypeName());
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
        return PSDEFVRTypeBase.get(this, n);
    }

    private static Object get(PSDEFVRTypeBase pSDEFVRTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFVRTypeBase.getCreateDate();
            }
            case 1: {
                return pSDEFVRTypeBase.getCreateMan();
            }
            case 2: {
                return pSDEFVRTypeBase.getIconPath();
            }
            case 3: {
                return pSDEFVRTypeBase.getMemo();
            }
            case 4: {
                return pSDEFVRTypeBase.getProcessObj();
            }
            case 5: {
                return pSDEFVRTypeBase.getPSDEFVRTypeId();
            }
            case 6: {
                return pSDEFVRTypeBase.getPSDEFVRTypeName();
            }
            case 7: {
                return pSDEFVRTypeBase.getUpdateDate();
            }
            case 8: {
                return pSDEFVRTypeBase.getUpdateMan();
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
        PSDEFVRTypeBase.set(this, n, object);
    }

    private static void set(PSDEFVRTypeBase pSDEFVRTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFVRTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEFVRTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFVRTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFVRTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFVRTypeBase.setProcessObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFVRTypeBase.setPSDEFVRTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFVRTypeBase.setPSDEFVRTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFVRTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDEFVRTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEFVRTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFVRTypeBase pSDEFVRTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFVRTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEFVRTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEFVRTypeBase.getIconPath() == null;
            }
            case 3: {
                return pSDEFVRTypeBase.getMemo() == null;
            }
            case 4: {
                return pSDEFVRTypeBase.getProcessObj() == null;
            }
            case 5: {
                return pSDEFVRTypeBase.getPSDEFVRTypeId() == null;
            }
            case 6: {
                return pSDEFVRTypeBase.getPSDEFVRTypeName() == null;
            }
            case 7: {
                return pSDEFVRTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSDEFVRTypeBase.getUpdateMan() == null;
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
        return PSDEFVRTypeBase.contains(this, n);
    }

    private static boolean contains(PSDEFVRTypeBase pSDEFVRTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFVRTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEFVRTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDEFVRTypeBase.isIconPathDirty();
            }
            case 3: {
                return pSDEFVRTypeBase.isMemoDirty();
            }
            case 4: {
                return pSDEFVRTypeBase.isProcessObjDirty();
            }
            case 5: {
                return pSDEFVRTypeBase.isPSDEFVRTypeIdDirty();
            }
            case 6: {
                return pSDEFVRTypeBase.isPSDEFVRTypeNameDirty();
            }
            case 7: {
                return pSDEFVRTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSDEFVRTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFVRTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFVRTypeBase pSDEFVRTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFVRTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFVRTypeBase.getJSONValue((Object)pSDEFVRTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFVRTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFVRTypeBase.getJSONValue((Object)pSDEFVRTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFVRTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSDEFVRTypeBase.getJSONValue((Object)pSDEFVRTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSDEFVRTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFVRTypeBase.getJSONValue((Object)pSDEFVRTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFVRTypeBase.getProcessObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"processobj", (Object)PSDEFVRTypeBase.getJSONValue((Object)pSDEFVRTypeBase.getProcessObj()), (boolean)false);
        }
        if (bl || pSDEFVRTypeBase.getPSDEFVRTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrtypeid", (Object)PSDEFVRTypeBase.getJSONValue((Object)pSDEFVRTypeBase.getPSDEFVRTypeId()), (boolean)false);
        }
        if (bl || pSDEFVRTypeBase.getPSDEFVRTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrtypename", (Object)PSDEFVRTypeBase.getJSONValue((Object)pSDEFVRTypeBase.getPSDEFVRTypeName()), (boolean)false);
        }
        if (bl || pSDEFVRTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFVRTypeBase.getJSONValue((Object)pSDEFVRTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFVRTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFVRTypeBase.getJSONValue((Object)pSDEFVRTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFVRTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFVRTypeBase pSDEFVRTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFVRTypeBase.getCreateDate() != null) {
            object = pSDEFVRTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFVRTypeBase.getCreateMan() != null) {
            object = pSDEFVRTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRTypeBase.getIconPath() != null) {
            object = pSDEFVRTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRTypeBase.getMemo() != null) {
            object = pSDEFVRTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRTypeBase.getProcessObj() != null) {
            object = pSDEFVRTypeBase.getProcessObj();
            xmlNode.setAttribute(FIELD_PROCESSOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRTypeBase.getPSDEFVRTypeId() != null) {
            object = pSDEFVRTypeBase.getPSDEFVRTypeId();
            xmlNode.setAttribute(FIELD_PSDEFVRTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRTypeBase.getPSDEFVRTypeName() != null) {
            object = pSDEFVRTypeBase.getPSDEFVRTypeName();
            xmlNode.setAttribute(FIELD_PSDEFVRTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRTypeBase.getUpdateDate() != null) {
            object = pSDEFVRTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFVRTypeBase.getUpdateMan() != null) {
            object = pSDEFVRTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFVRTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFVRTypeBase pSDEFVRTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFVRTypeBase.isCreateDateDirty() && (bl || pSDEFVRTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFVRTypeBase.getCreateDate());
        }
        if (pSDEFVRTypeBase.isCreateManDirty() && (bl || pSDEFVRTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFVRTypeBase.getCreateMan());
        }
        if (pSDEFVRTypeBase.isIconPathDirty() && (bl || pSDEFVRTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSDEFVRTypeBase.getIconPath());
        }
        if (pSDEFVRTypeBase.isMemoDirty() && (bl || pSDEFVRTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFVRTypeBase.getMemo());
        }
        if (pSDEFVRTypeBase.isProcessObjDirty() && (bl || pSDEFVRTypeBase.getProcessObj() != null)) {
            iDataObject.set(FIELD_PROCESSOBJ, (Object)pSDEFVRTypeBase.getProcessObj());
        }
        if (pSDEFVRTypeBase.isPSDEFVRTypeIdDirty() && (bl || pSDEFVRTypeBase.getPSDEFVRTypeId() != null)) {
            iDataObject.set(FIELD_PSDEFVRTYPEID, (Object)pSDEFVRTypeBase.getPSDEFVRTypeId());
        }
        if (pSDEFVRTypeBase.isPSDEFVRTypeNameDirty() && (bl || pSDEFVRTypeBase.getPSDEFVRTypeName() != null)) {
            iDataObject.set(FIELD_PSDEFVRTYPENAME, (Object)pSDEFVRTypeBase.getPSDEFVRTypeName());
        }
        if (pSDEFVRTypeBase.isUpdateDateDirty() && (bl || pSDEFVRTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFVRTypeBase.getUpdateDate());
        }
        if (pSDEFVRTypeBase.isUpdateManDirty() && (bl || pSDEFVRTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFVRTypeBase.getUpdateMan());
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
        return PSDEFVRTypeBase.remove(this, n);
    }

    private static boolean remove(PSDEFVRTypeBase pSDEFVRTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFVRTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEFVRTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEFVRTypeBase.resetIconPath();
                return true;
            }
            case 3: {
                pSDEFVRTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEFVRTypeBase.resetProcessObj();
                return true;
            }
            case 5: {
                pSDEFVRTypeBase.resetPSDEFVRTypeId();
                return true;
            }
            case 6: {
                pSDEFVRTypeBase.resetPSDEFVRTypeName();
                return true;
            }
            case 7: {
                pSDEFVRTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSDEFVRTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDEFVRTypeBase getProxyEntity() {
        return this.proxyPSDEFVRTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFVRTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFVRTypeBase) {
            this.proxyPSDEFVRTypeBase = (PSDEFVRTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEFVRTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ICONPATH, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PROCESSOBJ, 4);
        fieldIndexMap.put(FIELD_PSDEFVRTYPEID, 5);
        fieldIndexMap.put(FIELD_PSDEFVRTYPENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

