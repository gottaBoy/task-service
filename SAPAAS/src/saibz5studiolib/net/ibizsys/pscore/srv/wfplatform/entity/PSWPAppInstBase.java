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
package net.ibizsys.pscore.srv.wfplatform.entity;

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
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPApp;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPAppInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWPAppInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSWPAPPID = "PSWPAPPID";
    public static final String FIELD_PSWPAPPINSTID = "PSWPAPPINSTID";
    public static final String FIELD_PSWPAPPINSTNAME = "PSWPAPPINSTNAME";
    public static final String FIELD_PSWPAPPNAME = "PSWPAPPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSWPAPPID = 2;
    private static final int INDEX_PSWPAPPINSTID = 3;
    private static final int INDEX_PSWPAPPINSTNAME = 4;
    private static final int INDEX_PSWPAPPNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWPAppInstBase proxyPSWPAppInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pswpappidDirtyFlag = false;
    private boolean pswpappinstidDirtyFlag = false;
    private boolean pswpappinstnameDirtyFlag = false;
    private boolean pswpappnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pswpappid")
    private String pswpappid;
    @Column(name="pswpappinstid")
    private String pswpappinstid;
    @Column(name="pswpappinstname")
    private String pswpappinstname;
    @Column(name="pswpappname")
    private String pswpappname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSWPAppLock = new Integer(1);
    private PSWPApp pswpapp = null;

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

    public void setPSWPAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpappid = string;
        this.pswpappidDirtyFlag = true;
    }

    public String getPSWPAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppId();
        }
        return this.pswpappid;
    }

    public boolean isPSWPAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPAppIdDirty();
        }
        return this.pswpappidDirtyFlag;
    }

    public void resetPSWPAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPAppId();
            return;
        }
        this.pswpappidDirtyFlag = false;
        this.pswpappid = null;
    }

    public void setPSWPAppInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPAppInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpappinstid = string;
        this.pswpappinstidDirtyFlag = true;
    }

    public String getPSWPAppInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppInstId();
        }
        return this.pswpappinstid;
    }

    public boolean isPSWPAppInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPAppInstIdDirty();
        }
        return this.pswpappinstidDirtyFlag;
    }

    public void resetPSWPAppInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPAppInstId();
            return;
        }
        this.pswpappinstidDirtyFlag = false;
        this.pswpappinstid = null;
    }

    public void setPSWPAppInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPAppInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpappinstname = string;
        this.pswpappinstnameDirtyFlag = true;
    }

    public String getPSWPAppInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppInstName();
        }
        return this.pswpappinstname;
    }

    public boolean isPSWPAppInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPAppInstNameDirty();
        }
        return this.pswpappinstnameDirtyFlag;
    }

    public void resetPSWPAppInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPAppInstName();
            return;
        }
        this.pswpappinstnameDirtyFlag = false;
        this.pswpappinstname = null;
    }

    public void setPSWPAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpappname = string;
        this.pswpappnameDirtyFlag = true;
    }

    public String getPSWPAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppName();
        }
        return this.pswpappname;
    }

    public boolean isPSWPAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPAppNameDirty();
        }
        return this.pswpappnameDirtyFlag;
    }

    public void resetPSWPAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPAppName();
            return;
        }
        this.pswpappnameDirtyFlag = false;
        this.pswpappname = null;
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
        PSWPAppInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWPAppInstBase pSWPAppInstBase) {
        pSWPAppInstBase.resetCreateDate();
        pSWPAppInstBase.resetCreateMan();
        pSWPAppInstBase.resetPSWPAppId();
        pSWPAppInstBase.resetPSWPAppInstId();
        pSWPAppInstBase.resetPSWPAppInstName();
        pSWPAppInstBase.resetPSWPAppName();
        pSWPAppInstBase.resetUpdateDate();
        pSWPAppInstBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSWPAppIdDirty()) {
            hashMap.put(FIELD_PSWPAPPID, this.getPSWPAppId());
        }
        if (!bl || this.isPSWPAppInstIdDirty()) {
            hashMap.put(FIELD_PSWPAPPINSTID, this.getPSWPAppInstId());
        }
        if (!bl || this.isPSWPAppInstNameDirty()) {
            hashMap.put(FIELD_PSWPAPPINSTNAME, this.getPSWPAppInstName());
        }
        if (!bl || this.isPSWPAppNameDirty()) {
            hashMap.put(FIELD_PSWPAPPNAME, this.getPSWPAppName());
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
        return PSWPAppInstBase.get(this, n);
    }

    private static Object get(PSWPAppInstBase pSWPAppInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPAppInstBase.getCreateDate();
            }
            case 1: {
                return pSWPAppInstBase.getCreateMan();
            }
            case 2: {
                return pSWPAppInstBase.getPSWPAppId();
            }
            case 3: {
                return pSWPAppInstBase.getPSWPAppInstId();
            }
            case 4: {
                return pSWPAppInstBase.getPSWPAppInstName();
            }
            case 5: {
                return pSWPAppInstBase.getPSWPAppName();
            }
            case 6: {
                return pSWPAppInstBase.getUpdateDate();
            }
            case 7: {
                return pSWPAppInstBase.getUpdateMan();
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
        PSWPAppInstBase.set(this, n, object);
    }

    private static void set(PSWPAppInstBase pSWPAppInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWPAppInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWPAppInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWPAppInstBase.setPSWPAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWPAppInstBase.setPSWPAppInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWPAppInstBase.setPSWPAppInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWPAppInstBase.setPSWPAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWPAppInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSWPAppInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWPAppInstBase.isNull(this, n);
    }

    private static boolean isNull(PSWPAppInstBase pSWPAppInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPAppInstBase.getCreateDate() == null;
            }
            case 1: {
                return pSWPAppInstBase.getCreateMan() == null;
            }
            case 2: {
                return pSWPAppInstBase.getPSWPAppId() == null;
            }
            case 3: {
                return pSWPAppInstBase.getPSWPAppInstId() == null;
            }
            case 4: {
                return pSWPAppInstBase.getPSWPAppInstName() == null;
            }
            case 5: {
                return pSWPAppInstBase.getPSWPAppName() == null;
            }
            case 6: {
                return pSWPAppInstBase.getUpdateDate() == null;
            }
            case 7: {
                return pSWPAppInstBase.getUpdateMan() == null;
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
        return PSWPAppInstBase.contains(this, n);
    }

    private static boolean contains(PSWPAppInstBase pSWPAppInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPAppInstBase.isCreateDateDirty();
            }
            case 1: {
                return pSWPAppInstBase.isCreateManDirty();
            }
            case 2: {
                return pSWPAppInstBase.isPSWPAppIdDirty();
            }
            case 3: {
                return pSWPAppInstBase.isPSWPAppInstIdDirty();
            }
            case 4: {
                return pSWPAppInstBase.isPSWPAppInstNameDirty();
            }
            case 5: {
                return pSWPAppInstBase.isPSWPAppNameDirty();
            }
            case 6: {
                return pSWPAppInstBase.isUpdateDateDirty();
            }
            case 7: {
                return pSWPAppInstBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWPAppInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWPAppInstBase pSWPAppInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWPAppInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWPAppInstBase.getJSONValue((Object)pSWPAppInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWPAppInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWPAppInstBase.getJSONValue((Object)pSWPAppInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWPAppInstBase.getPSWPAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpappid", (Object)PSWPAppInstBase.getJSONValue((Object)pSWPAppInstBase.getPSWPAppId()), (boolean)false);
        }
        if (bl || pSWPAppInstBase.getPSWPAppInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpappinstid", (Object)PSWPAppInstBase.getJSONValue((Object)pSWPAppInstBase.getPSWPAppInstId()), (boolean)false);
        }
        if (bl || pSWPAppInstBase.getPSWPAppInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpappinstname", (Object)PSWPAppInstBase.getJSONValue((Object)pSWPAppInstBase.getPSWPAppInstName()), (boolean)false);
        }
        if (bl || pSWPAppInstBase.getPSWPAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpappname", (Object)PSWPAppInstBase.getJSONValue((Object)pSWPAppInstBase.getPSWPAppName()), (boolean)false);
        }
        if (bl || pSWPAppInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWPAppInstBase.getJSONValue((Object)pSWPAppInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWPAppInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWPAppInstBase.getJSONValue((Object)pSWPAppInstBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWPAppInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWPAppInstBase pSWPAppInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWPAppInstBase.getCreateDate() != null) {
            object = pSWPAppInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPAppInstBase.getCreateMan() != null) {
            object = pSWPAppInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWPAppInstBase.getPSWPAppId() != null) {
            object = pSWPAppInstBase.getPSWPAppId();
            xmlNode.setAttribute(FIELD_PSWPAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSWPAppInstBase.getPSWPAppInstId() != null) {
            object = pSWPAppInstBase.getPSWPAppInstId();
            xmlNode.setAttribute(FIELD_PSWPAPPINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWPAppInstBase.getPSWPAppInstName() != null) {
            object = pSWPAppInstBase.getPSWPAppInstName();
            xmlNode.setAttribute(FIELD_PSWPAPPINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPAppInstBase.getPSWPAppName() != null) {
            object = pSWPAppInstBase.getPSWPAppName();
            xmlNode.setAttribute(FIELD_PSWPAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPAppInstBase.getUpdateDate() != null) {
            object = pSWPAppInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPAppInstBase.getUpdateMan() != null) {
            object = pSWPAppInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWPAppInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWPAppInstBase pSWPAppInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWPAppInstBase.isCreateDateDirty() && (bl || pSWPAppInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWPAppInstBase.getCreateDate());
        }
        if (pSWPAppInstBase.isCreateManDirty() && (bl || pSWPAppInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWPAppInstBase.getCreateMan());
        }
        if (pSWPAppInstBase.isPSWPAppIdDirty() && (bl || pSWPAppInstBase.getPSWPAppId() != null)) {
            iDataObject.set(FIELD_PSWPAPPID, (Object)pSWPAppInstBase.getPSWPAppId());
        }
        if (pSWPAppInstBase.isPSWPAppInstIdDirty() && (bl || pSWPAppInstBase.getPSWPAppInstId() != null)) {
            iDataObject.set(FIELD_PSWPAPPINSTID, (Object)pSWPAppInstBase.getPSWPAppInstId());
        }
        if (pSWPAppInstBase.isPSWPAppInstNameDirty() && (bl || pSWPAppInstBase.getPSWPAppInstName() != null)) {
            iDataObject.set(FIELD_PSWPAPPINSTNAME, (Object)pSWPAppInstBase.getPSWPAppInstName());
        }
        if (pSWPAppInstBase.isPSWPAppNameDirty() && (bl || pSWPAppInstBase.getPSWPAppName() != null)) {
            iDataObject.set(FIELD_PSWPAPPNAME, (Object)pSWPAppInstBase.getPSWPAppName());
        }
        if (pSWPAppInstBase.isUpdateDateDirty() && (bl || pSWPAppInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWPAppInstBase.getUpdateDate());
        }
        if (pSWPAppInstBase.isUpdateManDirty() && (bl || pSWPAppInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWPAppInstBase.getUpdateMan());
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
        return PSWPAppInstBase.remove(this, n);
    }

    private static boolean remove(PSWPAppInstBase pSWPAppInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWPAppInstBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWPAppInstBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWPAppInstBase.resetPSWPAppId();
                return true;
            }
            case 3: {
                pSWPAppInstBase.resetPSWPAppInstId();
                return true;
            }
            case 4: {
                pSWPAppInstBase.resetPSWPAppInstName();
                return true;
            }
            case 5: {
                pSWPAppInstBase.resetPSWPAppName();
                return true;
            }
            case 6: {
                pSWPAppInstBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSWPAppInstBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWPApp getPSWPApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPApp();
        }
        if (this.getPSWPAppId() == null) {
            return null;
        }
        Integer n = this.objPSWPAppLock;
        synchronized (n) {
            if (this.pswpapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSWPAppId(), (Object)this.pswpapp.getPSWPAppId()) != 0L) {
                this.pswpapp = null;
            }
            if (this.pswpapp == null) {
                PSWPApp pSWPApp = new PSWPApp();
                pSWPApp.setPSWPAppId(this.getPSWPAppId());
                PSWPAppService pSWPAppService = (PSWPAppService)ServiceGlobal.getService(PSWPAppService.class, (SessionFactory)this.getSessionFactory());
                pSWPAppService.autoGet((IEntity)pSWPApp);
                this.pswpapp = pSWPApp;
            }
            return this.pswpapp;
        }
    }

    private PSWPAppInstBase getProxyEntity() {
        return this.proxyPSWPAppInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWPAppInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSWPAppInstBase) {
            this.proxyPSWPAppInstBase = (PSWPAppInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPAppInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSWPAPPID, 2);
        fieldIndexMap.put(FIELD_PSWPAPPINSTID, 3);
        fieldIndexMap.put(FIELD_PSWPAPPINSTNAME, 4);
        fieldIndexMap.put(FIELD_PSWPAPPNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

