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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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

public abstract class PSDSSysAppBarFilterBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDSSysAppBarFilterBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDSSYSAPPBARFILTERID = "PSDSSYSAPPBARFILTERID";
    public static final String FIELD_PSDSSYSAPPBARFILTERNAME = "PSDSSYSAPPBARFILTERNAME";
    public static final String FIELD_PSDSSYSAPPBARID = "PSDSSYSAPPBARID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDSSYSAPPBARFILTERID = 2;
    private static final int INDEX_PSDSSYSAPPBARFILTERNAME = 3;
    private static final int INDEX_PSDSSYSAPPBARID = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDSSysAppBarFilterBase proxyPSDSSysAppBarFilterBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdssysappbarfilteridDirtyFlag = false;
    private boolean psdssysappbarfilternameDirtyFlag = false;
    private boolean psdssysappbaridDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdssysappbarfilterid")
    private String psdssysappbarfilterid;
    @Column(name="psdssysappbarfiltername")
    private String psdssysappbarfiltername;
    @Column(name="psdssysappbarid")
    private String psdssysappbarid;
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

    public void setPSDSSysAppBarFilterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSSysAppBarFilterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdssysappbarfilterid = string;
        this.psdssysappbarfilteridDirtyFlag = true;
    }

    public String getPSDSSysAppBarFilterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSSysAppBarFilterId();
        }
        return this.psdssysappbarfilterid;
    }

    public boolean isPSDSSysAppBarFilterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSSysAppBarFilterIdDirty();
        }
        return this.psdssysappbarfilteridDirtyFlag;
    }

    public void resetPSDSSysAppBarFilterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSSysAppBarFilterId();
            return;
        }
        this.psdssysappbarfilteridDirtyFlag = false;
        this.psdssysappbarfilterid = null;
    }

    public void setPSDSSysAppBarFilterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSSysAppBarFilterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdssysappbarfiltername = string;
        this.psdssysappbarfilternameDirtyFlag = true;
    }

    public String getPSDSSysAppBarFilterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSSysAppBarFilterName();
        }
        return this.psdssysappbarfiltername;
    }

    public boolean isPSDSSysAppBarFilterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSSysAppBarFilterNameDirty();
        }
        return this.psdssysappbarfilternameDirtyFlag;
    }

    public void resetPSDSSysAppBarFilterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSSysAppBarFilterName();
            return;
        }
        this.psdssysappbarfilternameDirtyFlag = false;
        this.psdssysappbarfiltername = null;
    }

    public void setPSDSSysAppBarId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSSysAppBarId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdssysappbarid = string;
        this.psdssysappbaridDirtyFlag = true;
    }

    public String getPSDSSysAppBarId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSSysAppBarId();
        }
        return this.psdssysappbarid;
    }

    public boolean isPSDSSysAppBarIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSSysAppBarIdDirty();
        }
        return this.psdssysappbaridDirtyFlag;
    }

    public void resetPSDSSysAppBarId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSSysAppBarId();
            return;
        }
        this.psdssysappbaridDirtyFlag = false;
        this.psdssysappbarid = null;
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
        PSDSSysAppBarFilterBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDSSysAppBarFilterBase pSDSSysAppBarFilterBase) {
        pSDSSysAppBarFilterBase.resetCreateDate();
        pSDSSysAppBarFilterBase.resetCreateMan();
        pSDSSysAppBarFilterBase.resetPSDSSysAppBarFilterId();
        pSDSSysAppBarFilterBase.resetPSDSSysAppBarFilterName();
        pSDSSysAppBarFilterBase.resetPSDSSysAppBarId();
        pSDSSysAppBarFilterBase.resetUpdateDate();
        pSDSSysAppBarFilterBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDSSysAppBarFilterIdDirty()) {
            hashMap.put(FIELD_PSDSSYSAPPBARFILTERID, this.getPSDSSysAppBarFilterId());
        }
        if (!bl || this.isPSDSSysAppBarFilterNameDirty()) {
            hashMap.put(FIELD_PSDSSYSAPPBARFILTERNAME, this.getPSDSSysAppBarFilterName());
        }
        if (!bl || this.isPSDSSysAppBarIdDirty()) {
            hashMap.put(FIELD_PSDSSYSAPPBARID, this.getPSDSSysAppBarId());
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
        return PSDSSysAppBarFilterBase.get(this, n);
    }

    private static Object get(PSDSSysAppBarFilterBase pSDSSysAppBarFilterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSSysAppBarFilterBase.getCreateDate();
            }
            case 1: {
                return pSDSSysAppBarFilterBase.getCreateMan();
            }
            case 2: {
                return pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterId();
            }
            case 3: {
                return pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterName();
            }
            case 4: {
                return pSDSSysAppBarFilterBase.getPSDSSysAppBarId();
            }
            case 5: {
                return pSDSSysAppBarFilterBase.getUpdateDate();
            }
            case 6: {
                return pSDSSysAppBarFilterBase.getUpdateMan();
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
        PSDSSysAppBarFilterBase.set(this, n, object);
    }

    private static void set(PSDSSysAppBarFilterBase pSDSSysAppBarFilterBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDSSysAppBarFilterBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDSSysAppBarFilterBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDSSysAppBarFilterBase.setPSDSSysAppBarFilterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDSSysAppBarFilterBase.setPSDSSysAppBarFilterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDSSysAppBarFilterBase.setPSDSSysAppBarId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDSSysAppBarFilterBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDSSysAppBarFilterBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDSSysAppBarFilterBase.isNull(this, n);
    }

    private static boolean isNull(PSDSSysAppBarFilterBase pSDSSysAppBarFilterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSSysAppBarFilterBase.getCreateDate() == null;
            }
            case 1: {
                return pSDSSysAppBarFilterBase.getCreateMan() == null;
            }
            case 2: {
                return pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterId() == null;
            }
            case 3: {
                return pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterName() == null;
            }
            case 4: {
                return pSDSSysAppBarFilterBase.getPSDSSysAppBarId() == null;
            }
            case 5: {
                return pSDSSysAppBarFilterBase.getUpdateDate() == null;
            }
            case 6: {
                return pSDSSysAppBarFilterBase.getUpdateMan() == null;
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
        return PSDSSysAppBarFilterBase.contains(this, n);
    }

    private static boolean contains(PSDSSysAppBarFilterBase pSDSSysAppBarFilterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSSysAppBarFilterBase.isCreateDateDirty();
            }
            case 1: {
                return pSDSSysAppBarFilterBase.isCreateManDirty();
            }
            case 2: {
                return pSDSSysAppBarFilterBase.isPSDSSysAppBarFilterIdDirty();
            }
            case 3: {
                return pSDSSysAppBarFilterBase.isPSDSSysAppBarFilterNameDirty();
            }
            case 4: {
                return pSDSSysAppBarFilterBase.isPSDSSysAppBarIdDirty();
            }
            case 5: {
                return pSDSSysAppBarFilterBase.isUpdateDateDirty();
            }
            case 6: {
                return pSDSSysAppBarFilterBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDSSysAppBarFilterBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDSSysAppBarFilterBase pSDSSysAppBarFilterBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDSSysAppBarFilterBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDSSysAppBarFilterBase.getJSONValue((Object)pSDSSysAppBarFilterBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDSSysAppBarFilterBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDSSysAppBarFilterBase.getJSONValue((Object)pSDSSysAppBarFilterBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdssysappbarfilterid", (Object)PSDSSysAppBarFilterBase.getJSONValue((Object)pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterId()), (boolean)false);
        }
        if (bl || pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdssysappbarfiltername", (Object)PSDSSysAppBarFilterBase.getJSONValue((Object)pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterName()), (boolean)false);
        }
        if (bl || pSDSSysAppBarFilterBase.getPSDSSysAppBarId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdssysappbarid", (Object)PSDSSysAppBarFilterBase.getJSONValue((Object)pSDSSysAppBarFilterBase.getPSDSSysAppBarId()), (boolean)false);
        }
        if (bl || pSDSSysAppBarFilterBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDSSysAppBarFilterBase.getJSONValue((Object)pSDSSysAppBarFilterBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDSSysAppBarFilterBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDSSysAppBarFilterBase.getJSONValue((Object)pSDSSysAppBarFilterBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDSSysAppBarFilterBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDSSysAppBarFilterBase pSDSSysAppBarFilterBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDSSysAppBarFilterBase.getCreateDate() != null) {
            object = pSDSSysAppBarFilterBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSSysAppBarFilterBase.getCreateMan() != null) {
            object = pSDSSysAppBarFilterBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterId() != null) {
            object = pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterId();
            xmlNode.setAttribute(FIELD_PSDSSYSAPPBARFILTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterName() != null) {
            object = pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterName();
            xmlNode.setAttribute(FIELD_PSDSSYSAPPBARFILTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarFilterBase.getPSDSSysAppBarId() != null) {
            object = pSDSSysAppBarFilterBase.getPSDSSysAppBarId();
            xmlNode.setAttribute(FIELD_PSDSSYSAPPBARID, object == null ? "" : (String)object);
        }
        if (bl || pSDSSysAppBarFilterBase.getUpdateDate() != null) {
            object = pSDSSysAppBarFilterBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSSysAppBarFilterBase.getUpdateMan() != null) {
            object = pSDSSysAppBarFilterBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDSSysAppBarFilterBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDSSysAppBarFilterBase pSDSSysAppBarFilterBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDSSysAppBarFilterBase.isCreateDateDirty() && (bl || pSDSSysAppBarFilterBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDSSysAppBarFilterBase.getCreateDate());
        }
        if (pSDSSysAppBarFilterBase.isCreateManDirty() && (bl || pSDSSysAppBarFilterBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDSSysAppBarFilterBase.getCreateMan());
        }
        if (pSDSSysAppBarFilterBase.isPSDSSysAppBarFilterIdDirty() && (bl || pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterId() != null)) {
            iDataObject.set(FIELD_PSDSSYSAPPBARFILTERID, (Object)pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterId());
        }
        if (pSDSSysAppBarFilterBase.isPSDSSysAppBarFilterNameDirty() && (bl || pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterName() != null)) {
            iDataObject.set(FIELD_PSDSSYSAPPBARFILTERNAME, (Object)pSDSSysAppBarFilterBase.getPSDSSysAppBarFilterName());
        }
        if (pSDSSysAppBarFilterBase.isPSDSSysAppBarIdDirty() && (bl || pSDSSysAppBarFilterBase.getPSDSSysAppBarId() != null)) {
            iDataObject.set(FIELD_PSDSSYSAPPBARID, (Object)pSDSSysAppBarFilterBase.getPSDSSysAppBarId());
        }
        if (pSDSSysAppBarFilterBase.isUpdateDateDirty() && (bl || pSDSSysAppBarFilterBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDSSysAppBarFilterBase.getUpdateDate());
        }
        if (pSDSSysAppBarFilterBase.isUpdateManDirty() && (bl || pSDSSysAppBarFilterBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDSSysAppBarFilterBase.getUpdateMan());
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
        return PSDSSysAppBarFilterBase.remove(this, n);
    }

    private static boolean remove(PSDSSysAppBarFilterBase pSDSSysAppBarFilterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDSSysAppBarFilterBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDSSysAppBarFilterBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDSSysAppBarFilterBase.resetPSDSSysAppBarFilterId();
                return true;
            }
            case 3: {
                pSDSSysAppBarFilterBase.resetPSDSSysAppBarFilterName();
                return true;
            }
            case 4: {
                pSDSSysAppBarFilterBase.resetPSDSSysAppBarId();
                return true;
            }
            case 5: {
                pSDSSysAppBarFilterBase.resetUpdateDate();
                return true;
            }
            case 6: {
                pSDSSysAppBarFilterBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDSSysAppBarFilterBase getProxyEntity() {
        return this.proxyPSDSSysAppBarFilterBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDSSysAppBarFilterBase = null;
        if (iDataObject != null && iDataObject instanceof PSDSSysAppBarFilterBase) {
            this.proxyPSDSSysAppBarFilterBase = (PSDSSysAppBarFilterBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSDSSysAppBarFilterService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDSSYSAPPBARFILTERID, 2);
        fieldIndexMap.put(FIELD_PSDSSYSAPPBARFILTERNAME, 3);
        fieldIndexMap.put(FIELD_PSDSSYSAPPBARID, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
    }
}

