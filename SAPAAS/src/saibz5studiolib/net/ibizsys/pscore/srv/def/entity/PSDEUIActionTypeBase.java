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

public abstract class PSDEUIActionTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEUIActionTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEUIACTIONTYPEID = "PSDEUIACTIONTYPEID";
    public static final String FIELD_PSDEUIACTIONTYPENAME = "PSDEUIACTIONTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ICONPATH = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEUIACTIONTYPEID = 4;
    private static final int INDEX_PSDEUIACTIONTYPENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEUIActionTypeBase proxyPSDEUIActionTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeuiactiontypeidDirtyFlag = false;
    private boolean psdeuiactiontypenameDirtyFlag = false;
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
    @Column(name="psdeuiactiontypeid")
    private String psdeuiactiontypeid;
    @Column(name="psdeuiactiontypename")
    private String psdeuiactiontypename;
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

    public void setPSDEUIActionTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactiontypeid = string;
        this.psdeuiactiontypeidDirtyFlag = true;
    }

    public String getPSDEUIActionTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionTypeId();
        }
        return this.psdeuiactiontypeid;
    }

    public boolean isPSDEUIActionTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionTypeIdDirty();
        }
        return this.psdeuiactiontypeidDirtyFlag;
    }

    public void resetPSDEUIActionTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionTypeId();
            return;
        }
        this.psdeuiactiontypeidDirtyFlag = false;
        this.psdeuiactiontypeid = null;
    }

    public void setPSDEUIActionTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactiontypename = string;
        this.psdeuiactiontypenameDirtyFlag = true;
    }

    public String getPSDEUIActionTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionTypeName();
        }
        return this.psdeuiactiontypename;
    }

    public boolean isPSDEUIActionTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionTypeNameDirty();
        }
        return this.psdeuiactiontypenameDirtyFlag;
    }

    public void resetPSDEUIActionTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionTypeName();
            return;
        }
        this.psdeuiactiontypenameDirtyFlag = false;
        this.psdeuiactiontypename = null;
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
        PSDEUIActionTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEUIActionTypeBase pSDEUIActionTypeBase) {
        pSDEUIActionTypeBase.resetCreateDate();
        pSDEUIActionTypeBase.resetCreateMan();
        pSDEUIActionTypeBase.resetIconPath();
        pSDEUIActionTypeBase.resetMemo();
        pSDEUIActionTypeBase.resetPSDEUIActionTypeId();
        pSDEUIActionTypeBase.resetPSDEUIActionTypeName();
        pSDEUIActionTypeBase.resetUpdateDate();
        pSDEUIActionTypeBase.resetUpdateMan();
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
        if (!bl || this.isPSDEUIActionTypeIdDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONTYPEID, this.getPSDEUIActionTypeId());
        }
        if (!bl || this.isPSDEUIActionTypeNameDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONTYPENAME, this.getPSDEUIActionTypeName());
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
        return PSDEUIActionTypeBase.get(this, n);
    }

    private static Object get(PSDEUIActionTypeBase pSDEUIActionTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUIActionTypeBase.getCreateDate();
            }
            case 1: {
                return pSDEUIActionTypeBase.getCreateMan();
            }
            case 2: {
                return pSDEUIActionTypeBase.getIconPath();
            }
            case 3: {
                return pSDEUIActionTypeBase.getMemo();
            }
            case 4: {
                return pSDEUIActionTypeBase.getPSDEUIActionTypeId();
            }
            case 5: {
                return pSDEUIActionTypeBase.getPSDEUIActionTypeName();
            }
            case 6: {
                return pSDEUIActionTypeBase.getUpdateDate();
            }
            case 7: {
                return pSDEUIActionTypeBase.getUpdateMan();
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
        PSDEUIActionTypeBase.set(this, n, object);
    }

    private static void set(PSDEUIActionTypeBase pSDEUIActionTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEUIActionTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEUIActionTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEUIActionTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEUIActionTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEUIActionTypeBase.setPSDEUIActionTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEUIActionTypeBase.setPSDEUIActionTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEUIActionTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDEUIActionTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEUIActionTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDEUIActionTypeBase pSDEUIActionTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUIActionTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEUIActionTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEUIActionTypeBase.getIconPath() == null;
            }
            case 3: {
                return pSDEUIActionTypeBase.getMemo() == null;
            }
            case 4: {
                return pSDEUIActionTypeBase.getPSDEUIActionTypeId() == null;
            }
            case 5: {
                return pSDEUIActionTypeBase.getPSDEUIActionTypeName() == null;
            }
            case 6: {
                return pSDEUIActionTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDEUIActionTypeBase.getUpdateMan() == null;
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
        return PSDEUIActionTypeBase.contains(this, n);
    }

    private static boolean contains(PSDEUIActionTypeBase pSDEUIActionTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUIActionTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEUIActionTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDEUIActionTypeBase.isIconPathDirty();
            }
            case 3: {
                return pSDEUIActionTypeBase.isMemoDirty();
            }
            case 4: {
                return pSDEUIActionTypeBase.isPSDEUIActionTypeIdDirty();
            }
            case 5: {
                return pSDEUIActionTypeBase.isPSDEUIActionTypeNameDirty();
            }
            case 6: {
                return pSDEUIActionTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDEUIActionTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEUIActionTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEUIActionTypeBase pSDEUIActionTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEUIActionTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEUIActionTypeBase.getJSONValue((Object)pSDEUIActionTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEUIActionTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEUIActionTypeBase.getJSONValue((Object)pSDEUIActionTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEUIActionTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSDEUIActionTypeBase.getJSONValue((Object)pSDEUIActionTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSDEUIActionTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEUIActionTypeBase.getJSONValue((Object)pSDEUIActionTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEUIActionTypeBase.getPSDEUIActionTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactiontypeid", (Object)PSDEUIActionTypeBase.getJSONValue((Object)pSDEUIActionTypeBase.getPSDEUIActionTypeId()), (boolean)false);
        }
        if (bl || pSDEUIActionTypeBase.getPSDEUIActionTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactiontypename", (Object)PSDEUIActionTypeBase.getJSONValue((Object)pSDEUIActionTypeBase.getPSDEUIActionTypeName()), (boolean)false);
        }
        if (bl || pSDEUIActionTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEUIActionTypeBase.getJSONValue((Object)pSDEUIActionTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEUIActionTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEUIActionTypeBase.getJSONValue((Object)pSDEUIActionTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEUIActionTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEUIActionTypeBase pSDEUIActionTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEUIActionTypeBase.getCreateDate() != null) {
            object = pSDEUIActionTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUIActionTypeBase.getCreateMan() != null) {
            object = pSDEUIActionTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionTypeBase.getIconPath() != null) {
            object = pSDEUIActionTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionTypeBase.getMemo() != null) {
            object = pSDEUIActionTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionTypeBase.getPSDEUIActionTypeId() != null) {
            object = pSDEUIActionTypeBase.getPSDEUIActionTypeId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionTypeBase.getPSDEUIActionTypeName() != null) {
            object = pSDEUIActionTypeBase.getPSDEUIActionTypeName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUIActionTypeBase.getUpdateDate() != null) {
            object = pSDEUIActionTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUIActionTypeBase.getUpdateMan() != null) {
            object = pSDEUIActionTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEUIActionTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEUIActionTypeBase pSDEUIActionTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEUIActionTypeBase.isCreateDateDirty() && (bl || pSDEUIActionTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEUIActionTypeBase.getCreateDate());
        }
        if (pSDEUIActionTypeBase.isCreateManDirty() && (bl || pSDEUIActionTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEUIActionTypeBase.getCreateMan());
        }
        if (pSDEUIActionTypeBase.isIconPathDirty() && (bl || pSDEUIActionTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSDEUIActionTypeBase.getIconPath());
        }
        if (pSDEUIActionTypeBase.isMemoDirty() && (bl || pSDEUIActionTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEUIActionTypeBase.getMemo());
        }
        if (pSDEUIActionTypeBase.isPSDEUIActionTypeIdDirty() && (bl || pSDEUIActionTypeBase.getPSDEUIActionTypeId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONTYPEID, (Object)pSDEUIActionTypeBase.getPSDEUIActionTypeId());
        }
        if (pSDEUIActionTypeBase.isPSDEUIActionTypeNameDirty() && (bl || pSDEUIActionTypeBase.getPSDEUIActionTypeName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONTYPENAME, (Object)pSDEUIActionTypeBase.getPSDEUIActionTypeName());
        }
        if (pSDEUIActionTypeBase.isUpdateDateDirty() && (bl || pSDEUIActionTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEUIActionTypeBase.getUpdateDate());
        }
        if (pSDEUIActionTypeBase.isUpdateManDirty() && (bl || pSDEUIActionTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEUIActionTypeBase.getUpdateMan());
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
        return PSDEUIActionTypeBase.remove(this, n);
    }

    private static boolean remove(PSDEUIActionTypeBase pSDEUIActionTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEUIActionTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEUIActionTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEUIActionTypeBase.resetIconPath();
                return true;
            }
            case 3: {
                pSDEUIActionTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEUIActionTypeBase.resetPSDEUIActionTypeId();
                return true;
            }
            case 5: {
                pSDEUIActionTypeBase.resetPSDEUIActionTypeName();
                return true;
            }
            case 6: {
                pSDEUIActionTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDEUIActionTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDEUIActionTypeBase getProxyEntity() {
        return this.proxyPSDEUIActionTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEUIActionTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEUIActionTypeBase) {
            this.proxyPSDEUIActionTypeBase = (PSDEUIActionTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSDEUIActionTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ICONPATH, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEUIACTIONTYPEID, 4);
        fieldIndexMap.put(FIELD_PSDEUIACTIONTYPENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

