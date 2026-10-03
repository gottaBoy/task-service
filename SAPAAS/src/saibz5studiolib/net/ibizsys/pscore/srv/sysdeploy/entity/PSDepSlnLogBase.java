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
package net.ibizsys.pscore.srv.sysdeploy.entity;

import java.io.Serializable;
import java.sql.Timestamp;
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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnLogBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNLOGID = "PSDEPSLNLOGID";
    public static final String FIELD_PSDEPSLNLOGNAME = "PSDEPSLNLOGNAME";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEPSLNID = 2;
    private static final int INDEX_PSDEPSLNLOGID = 3;
    private static final int INDEX_PSDEPSLNLOGNAME = 4;
    private static final int INDEX_PSDEPSLNNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnLogBase proxyPSDepSlnLogBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnlogidDirtyFlag = false;
    private boolean psdepslnlognameDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnlogid")
    private String psdepslnlogid;
    @Column(name="psdepslnlogname")
    private String psdepslnlogname;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;

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

    public void setPSDepSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnid = string;
        this.psdepslnidDirtyFlag = true;
    }

    public String getPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnId();
        }
        return this.psdepslnid;
    }

    public boolean isPSDepSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnIdDirty();
        }
        return this.psdepslnidDirtyFlag;
    }

    public void resetPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnId();
            return;
        }
        this.psdepslnidDirtyFlag = false;
        this.psdepslnid = null;
    }

    public void setPSDepSlnLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnlogid = string;
        this.psdepslnlogidDirtyFlag = true;
    }

    public String getPSDepSlnLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnLogId();
        }
        return this.psdepslnlogid;
    }

    public boolean isPSDepSlnLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnLogIdDirty();
        }
        return this.psdepslnlogidDirtyFlag;
    }

    public void resetPSDepSlnLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnLogId();
            return;
        }
        this.psdepslnlogidDirtyFlag = false;
        this.psdepslnlogid = null;
    }

    public void setPSDepSlnLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnlogname = string;
        this.psdepslnlognameDirtyFlag = true;
    }

    public String getPSDepSlnLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnLogName();
        }
        return this.psdepslnlogname;
    }

    public boolean isPSDepSlnLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnLogNameDirty();
        }
        return this.psdepslnlognameDirtyFlag;
    }

    public void resetPSDepSlnLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnLogName();
            return;
        }
        this.psdepslnlognameDirtyFlag = false;
        this.psdepslnlogname = null;
    }

    public void setPSDepSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnname = string;
        this.psdepslnnameDirtyFlag = true;
    }

    public String getPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnName();
        }
        return this.psdepslnname;
    }

    public boolean isPSDepSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnNameDirty();
        }
        return this.psdepslnnameDirtyFlag;
    }

    public void resetPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnName();
            return;
        }
        this.psdepslnnameDirtyFlag = false;
        this.psdepslnname = null;
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
        PSDepSlnLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnLogBase pSDepSlnLogBase) {
        pSDepSlnLogBase.resetCreateDate();
        pSDepSlnLogBase.resetCreateMan();
        pSDepSlnLogBase.resetPSDepSlnId();
        pSDepSlnLogBase.resetPSDepSlnLogId();
        pSDepSlnLogBase.resetPSDepSlnLogName();
        pSDepSlnLogBase.resetPSDepSlnName();
        pSDepSlnLogBase.resetUpdateDate();
        pSDepSlnLogBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnLogIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNLOGID, this.getPSDepSlnLogId());
        }
        if (!bl || this.isPSDepSlnLogNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNLOGNAME, this.getPSDepSlnLogName());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
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
        return PSDepSlnLogBase.get(this, n);
    }

    private static Object get(PSDepSlnLogBase pSDepSlnLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnLogBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnLogBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnLogBase.getPSDepSlnId();
            }
            case 3: {
                return pSDepSlnLogBase.getPSDepSlnLogId();
            }
            case 4: {
                return pSDepSlnLogBase.getPSDepSlnLogName();
            }
            case 5: {
                return pSDepSlnLogBase.getPSDepSlnName();
            }
            case 6: {
                return pSDepSlnLogBase.getUpdateDate();
            }
            case 7: {
                return pSDepSlnLogBase.getUpdateMan();
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
        PSDepSlnLogBase.set(this, n, object);
    }

    private static void set(PSDepSlnLogBase pSDepSlnLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnLogBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnLogBase.setPSDepSlnLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnLogBase.setPSDepSlnLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnLogBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnLogBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnLogBase pSDepSlnLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnLogBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnLogBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnLogBase.getPSDepSlnId() == null;
            }
            case 3: {
                return pSDepSlnLogBase.getPSDepSlnLogId() == null;
            }
            case 4: {
                return pSDepSlnLogBase.getPSDepSlnLogName() == null;
            }
            case 5: {
                return pSDepSlnLogBase.getPSDepSlnName() == null;
            }
            case 6: {
                return pSDepSlnLogBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDepSlnLogBase.getUpdateMan() == null;
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
        return PSDepSlnLogBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnLogBase pSDepSlnLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnLogBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnLogBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnLogBase.isPSDepSlnIdDirty();
            }
            case 3: {
                return pSDepSlnLogBase.isPSDepSlnLogIdDirty();
            }
            case 4: {
                return pSDepSlnLogBase.isPSDepSlnLogNameDirty();
            }
            case 5: {
                return pSDepSlnLogBase.isPSDepSlnNameDirty();
            }
            case 6: {
                return pSDepSlnLogBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDepSlnLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnLogBase pSDepSlnLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnLogBase.getJSONValue((Object)pSDepSlnLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnLogBase.getJSONValue((Object)pSDepSlnLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnLogBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnLogBase.getJSONValue((Object)pSDepSlnLogBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnLogBase.getPSDepSlnLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnlogid", (Object)PSDepSlnLogBase.getJSONValue((Object)pSDepSlnLogBase.getPSDepSlnLogId()), (boolean)false);
        }
        if (bl || pSDepSlnLogBase.getPSDepSlnLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnlogname", (Object)PSDepSlnLogBase.getJSONValue((Object)pSDepSlnLogBase.getPSDepSlnLogName()), (boolean)false);
        }
        if (bl || pSDepSlnLogBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnLogBase.getJSONValue((Object)pSDepSlnLogBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnLogBase.getJSONValue((Object)pSDepSlnLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnLogBase.getJSONValue((Object)pSDepSlnLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnLogBase pSDepSlnLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnLogBase.getCreateDate() != null) {
            object = pSDepSlnLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnLogBase.getCreateMan() != null) {
            object = pSDepSlnLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnLogBase.getPSDepSlnId() != null) {
            object = pSDepSlnLogBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnLogBase.getPSDepSlnLogId() != null) {
            object = pSDepSlnLogBase.getPSDepSlnLogId();
            xmlNode.setAttribute(FIELD_PSDEPSLNLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnLogBase.getPSDepSlnLogName() != null) {
            object = pSDepSlnLogBase.getPSDepSlnLogName();
            xmlNode.setAttribute(FIELD_PSDEPSLNLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnLogBase.getPSDepSlnName() != null) {
            object = pSDepSlnLogBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnLogBase.getUpdateDate() != null) {
            object = pSDepSlnLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnLogBase.getUpdateMan() != null) {
            object = pSDepSlnLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnLogBase pSDepSlnLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnLogBase.isCreateDateDirty() && (bl || pSDepSlnLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnLogBase.getCreateDate());
        }
        if (pSDepSlnLogBase.isCreateManDirty() && (bl || pSDepSlnLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnLogBase.getCreateMan());
        }
        if (pSDepSlnLogBase.isPSDepSlnIdDirty() && (bl || pSDepSlnLogBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnLogBase.getPSDepSlnId());
        }
        if (pSDepSlnLogBase.isPSDepSlnLogIdDirty() && (bl || pSDepSlnLogBase.getPSDepSlnLogId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNLOGID, (Object)pSDepSlnLogBase.getPSDepSlnLogId());
        }
        if (pSDepSlnLogBase.isPSDepSlnLogNameDirty() && (bl || pSDepSlnLogBase.getPSDepSlnLogName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNLOGNAME, (Object)pSDepSlnLogBase.getPSDepSlnLogName());
        }
        if (pSDepSlnLogBase.isPSDepSlnNameDirty() && (bl || pSDepSlnLogBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnLogBase.getPSDepSlnName());
        }
        if (pSDepSlnLogBase.isUpdateDateDirty() && (bl || pSDepSlnLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnLogBase.getUpdateDate());
        }
        if (pSDepSlnLogBase.isUpdateManDirty() && (bl || pSDepSlnLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnLogBase.getUpdateMan());
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
        return PSDepSlnLogBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnLogBase pSDepSlnLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnLogBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnLogBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnLogBase.resetPSDepSlnId();
                return true;
            }
            case 3: {
                pSDepSlnLogBase.resetPSDepSlnLogId();
                return true;
            }
            case 4: {
                pSDepSlnLogBase.resetPSDepSlnLogName();
                return true;
            }
            case 5: {
                pSDepSlnLogBase.resetPSDepSlnName();
                return true;
            }
            case 6: {
                pSDepSlnLogBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDepSlnLogBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSln getPSDepSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSln();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnLock;
        synchronized (n) {
            if (this.psdepsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnId(), (Object)this.psdepsln.getPSDepSlnId()) != 0L) {
                this.psdepsln = null;
            }
            if (this.psdepsln == null) {
                PSDepSln pSDepSln = new PSDepSln();
                pSDepSln.setPSDepSlnId(this.getPSDepSlnId());
                PSDepSlnService pSDepSlnService = (PSDepSlnService)ServiceGlobal.getService(PSDepSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnService.autoGet(pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
    }

    private PSDepSlnLogBase getProxyEntity() {
        return this.proxyPSDepSlnLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnLogBase) {
            this.proxyPSDepSlnLogBase = (PSDepSlnLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 2);
        fieldIndexMap.put(FIELD_PSDEPSLNLOGID, 3);
        fieldIndexMap.put(FIELD_PSDEPSLNLOGNAME, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

