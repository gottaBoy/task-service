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
import net.ibizsys.pscore.srv.wfplatform.entity.PSWFEngine;
import net.ibizsys.pscore.srv.wfplatform.service.PSWFEngineService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPEngineInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWPEngineInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSWPENGINEID = "PSWPENGINEID";
    public static final String FIELD_PSWPENGINEINSTID = "PSWPENGINEINSTID";
    public static final String FIELD_PSWPENGINEINSTNAME = "PSWPENGINEINSTNAME";
    public static final String FIELD_PSWPENGINENAME = "PSWPENGINENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSWPENGINEID = 2;
    private static final int INDEX_PSWPENGINEINSTID = 3;
    private static final int INDEX_PSWPENGINEINSTNAME = 4;
    private static final int INDEX_PSWPENGINENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWPEngineInstBase proxyPSWPEngineInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pswpengineidDirtyFlag = false;
    private boolean pswpengineinstidDirtyFlag = false;
    private boolean pswpengineinstnameDirtyFlag = false;
    private boolean pswpenginenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pswpengineid")
    private String pswpengineid;
    @Column(name="pswpengineinstid")
    private String pswpengineinstid;
    @Column(name="pswpengineinstname")
    private String pswpengineinstname;
    @Column(name="pswpenginename")
    private String pswpenginename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSWPEngineLock = new Integer(1);
    private PSWFEngine pswpengine = null;

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

    public void setPSWPEngineId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPEngineId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpengineid = string;
        this.pswpengineidDirtyFlag = true;
    }

    public String getPSWPEngineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPEngineId();
        }
        return this.pswpengineid;
    }

    public boolean isPSWPEngineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPEngineIdDirty();
        }
        return this.pswpengineidDirtyFlag;
    }

    public void resetPSWPEngineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPEngineId();
            return;
        }
        this.pswpengineidDirtyFlag = false;
        this.pswpengineid = null;
    }

    public void setPSWPEngineInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPEngineInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpengineinstid = string;
        this.pswpengineinstidDirtyFlag = true;
    }

    public String getPSWPEngineInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPEngineInstId();
        }
        return this.pswpengineinstid;
    }

    public boolean isPSWPEngineInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPEngineInstIdDirty();
        }
        return this.pswpengineinstidDirtyFlag;
    }

    public void resetPSWPEngineInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPEngineInstId();
            return;
        }
        this.pswpengineinstidDirtyFlag = false;
        this.pswpengineinstid = null;
    }

    public void setPSWPEngineInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPEngineInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpengineinstname = string;
        this.pswpengineinstnameDirtyFlag = true;
    }

    public String getPSWPEngineInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPEngineInstName();
        }
        return this.pswpengineinstname;
    }

    public boolean isPSWPEngineInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPEngineInstNameDirty();
        }
        return this.pswpengineinstnameDirtyFlag;
    }

    public void resetPSWPEngineInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPEngineInstName();
            return;
        }
        this.pswpengineinstnameDirtyFlag = false;
        this.pswpengineinstname = null;
    }

    public void setPSWPEngineName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPEngineName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpenginename = string;
        this.pswpenginenameDirtyFlag = true;
    }

    public String getPSWPEngineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPEngineName();
        }
        return this.pswpenginename;
    }

    public boolean isPSWPEngineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPEngineNameDirty();
        }
        return this.pswpenginenameDirtyFlag;
    }

    public void resetPSWPEngineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPEngineName();
            return;
        }
        this.pswpenginenameDirtyFlag = false;
        this.pswpenginename = null;
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
        PSWPEngineInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWPEngineInstBase pSWPEngineInstBase) {
        pSWPEngineInstBase.resetCreateDate();
        pSWPEngineInstBase.resetCreateMan();
        pSWPEngineInstBase.resetPSWPEngineId();
        pSWPEngineInstBase.resetPSWPEngineInstId();
        pSWPEngineInstBase.resetPSWPEngineInstName();
        pSWPEngineInstBase.resetPSWPEngineName();
        pSWPEngineInstBase.resetUpdateDate();
        pSWPEngineInstBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSWPEngineIdDirty()) {
            hashMap.put(FIELD_PSWPENGINEID, this.getPSWPEngineId());
        }
        if (!bl || this.isPSWPEngineInstIdDirty()) {
            hashMap.put(FIELD_PSWPENGINEINSTID, this.getPSWPEngineInstId());
        }
        if (!bl || this.isPSWPEngineInstNameDirty()) {
            hashMap.put(FIELD_PSWPENGINEINSTNAME, this.getPSWPEngineInstName());
        }
        if (!bl || this.isPSWPEngineNameDirty()) {
            hashMap.put(FIELD_PSWPENGINENAME, this.getPSWPEngineName());
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
        return PSWPEngineInstBase.get(this, n);
    }

    private static Object get(PSWPEngineInstBase pSWPEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPEngineInstBase.getCreateDate();
            }
            case 1: {
                return pSWPEngineInstBase.getCreateMan();
            }
            case 2: {
                return pSWPEngineInstBase.getPSWPEngineId();
            }
            case 3: {
                return pSWPEngineInstBase.getPSWPEngineInstId();
            }
            case 4: {
                return pSWPEngineInstBase.getPSWPEngineInstName();
            }
            case 5: {
                return pSWPEngineInstBase.getPSWPEngineName();
            }
            case 6: {
                return pSWPEngineInstBase.getUpdateDate();
            }
            case 7: {
                return pSWPEngineInstBase.getUpdateMan();
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
        PSWPEngineInstBase.set(this, n, object);
    }

    private static void set(PSWPEngineInstBase pSWPEngineInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWPEngineInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWPEngineInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWPEngineInstBase.setPSWPEngineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWPEngineInstBase.setPSWPEngineInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWPEngineInstBase.setPSWPEngineInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWPEngineInstBase.setPSWPEngineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWPEngineInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSWPEngineInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWPEngineInstBase.isNull(this, n);
    }

    private static boolean isNull(PSWPEngineInstBase pSWPEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPEngineInstBase.getCreateDate() == null;
            }
            case 1: {
                return pSWPEngineInstBase.getCreateMan() == null;
            }
            case 2: {
                return pSWPEngineInstBase.getPSWPEngineId() == null;
            }
            case 3: {
                return pSWPEngineInstBase.getPSWPEngineInstId() == null;
            }
            case 4: {
                return pSWPEngineInstBase.getPSWPEngineInstName() == null;
            }
            case 5: {
                return pSWPEngineInstBase.getPSWPEngineName() == null;
            }
            case 6: {
                return pSWPEngineInstBase.getUpdateDate() == null;
            }
            case 7: {
                return pSWPEngineInstBase.getUpdateMan() == null;
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
        return PSWPEngineInstBase.contains(this, n);
    }

    private static boolean contains(PSWPEngineInstBase pSWPEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPEngineInstBase.isCreateDateDirty();
            }
            case 1: {
                return pSWPEngineInstBase.isCreateManDirty();
            }
            case 2: {
                return pSWPEngineInstBase.isPSWPEngineIdDirty();
            }
            case 3: {
                return pSWPEngineInstBase.isPSWPEngineInstIdDirty();
            }
            case 4: {
                return pSWPEngineInstBase.isPSWPEngineInstNameDirty();
            }
            case 5: {
                return pSWPEngineInstBase.isPSWPEngineNameDirty();
            }
            case 6: {
                return pSWPEngineInstBase.isUpdateDateDirty();
            }
            case 7: {
                return pSWPEngineInstBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWPEngineInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWPEngineInstBase pSWPEngineInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWPEngineInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWPEngineInstBase.getJSONValue((Object)pSWPEngineInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWPEngineInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWPEngineInstBase.getJSONValue((Object)pSWPEngineInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWPEngineInstBase.getPSWPEngineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpengineid", (Object)PSWPEngineInstBase.getJSONValue((Object)pSWPEngineInstBase.getPSWPEngineId()), (boolean)false);
        }
        if (bl || pSWPEngineInstBase.getPSWPEngineInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpengineinstid", (Object)PSWPEngineInstBase.getJSONValue((Object)pSWPEngineInstBase.getPSWPEngineInstId()), (boolean)false);
        }
        if (bl || pSWPEngineInstBase.getPSWPEngineInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpengineinstname", (Object)PSWPEngineInstBase.getJSONValue((Object)pSWPEngineInstBase.getPSWPEngineInstName()), (boolean)false);
        }
        if (bl || pSWPEngineInstBase.getPSWPEngineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpenginename", (Object)PSWPEngineInstBase.getJSONValue((Object)pSWPEngineInstBase.getPSWPEngineName()), (boolean)false);
        }
        if (bl || pSWPEngineInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWPEngineInstBase.getJSONValue((Object)pSWPEngineInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWPEngineInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWPEngineInstBase.getJSONValue((Object)pSWPEngineInstBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWPEngineInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWPEngineInstBase pSWPEngineInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWPEngineInstBase.getCreateDate() != null) {
            object = pSWPEngineInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPEngineInstBase.getCreateMan() != null) {
            object = pSWPEngineInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWPEngineInstBase.getPSWPEngineId() != null) {
            object = pSWPEngineInstBase.getPSWPEngineId();
            xmlNode.setAttribute(FIELD_PSWPENGINEID, object == null ? "" : (String)object);
        }
        if (bl || pSWPEngineInstBase.getPSWPEngineInstId() != null) {
            object = pSWPEngineInstBase.getPSWPEngineInstId();
            xmlNode.setAttribute(FIELD_PSWPENGINEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWPEngineInstBase.getPSWPEngineInstName() != null) {
            object = pSWPEngineInstBase.getPSWPEngineInstName();
            xmlNode.setAttribute(FIELD_PSWPENGINEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPEngineInstBase.getPSWPEngineName() != null) {
            object = pSWPEngineInstBase.getPSWPEngineName();
            xmlNode.setAttribute(FIELD_PSWPENGINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPEngineInstBase.getUpdateDate() != null) {
            object = pSWPEngineInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPEngineInstBase.getUpdateMan() != null) {
            object = pSWPEngineInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWPEngineInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWPEngineInstBase pSWPEngineInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWPEngineInstBase.isCreateDateDirty() && (bl || pSWPEngineInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWPEngineInstBase.getCreateDate());
        }
        if (pSWPEngineInstBase.isCreateManDirty() && (bl || pSWPEngineInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWPEngineInstBase.getCreateMan());
        }
        if (pSWPEngineInstBase.isPSWPEngineIdDirty() && (bl || pSWPEngineInstBase.getPSWPEngineId() != null)) {
            iDataObject.set(FIELD_PSWPENGINEID, (Object)pSWPEngineInstBase.getPSWPEngineId());
        }
        if (pSWPEngineInstBase.isPSWPEngineInstIdDirty() && (bl || pSWPEngineInstBase.getPSWPEngineInstId() != null)) {
            iDataObject.set(FIELD_PSWPENGINEINSTID, (Object)pSWPEngineInstBase.getPSWPEngineInstId());
        }
        if (pSWPEngineInstBase.isPSWPEngineInstNameDirty() && (bl || pSWPEngineInstBase.getPSWPEngineInstName() != null)) {
            iDataObject.set(FIELD_PSWPENGINEINSTNAME, (Object)pSWPEngineInstBase.getPSWPEngineInstName());
        }
        if (pSWPEngineInstBase.isPSWPEngineNameDirty() && (bl || pSWPEngineInstBase.getPSWPEngineName() != null)) {
            iDataObject.set(FIELD_PSWPENGINENAME, (Object)pSWPEngineInstBase.getPSWPEngineName());
        }
        if (pSWPEngineInstBase.isUpdateDateDirty() && (bl || pSWPEngineInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWPEngineInstBase.getUpdateDate());
        }
        if (pSWPEngineInstBase.isUpdateManDirty() && (bl || pSWPEngineInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWPEngineInstBase.getUpdateMan());
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
        return PSWPEngineInstBase.remove(this, n);
    }

    private static boolean remove(PSWPEngineInstBase pSWPEngineInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWPEngineInstBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWPEngineInstBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWPEngineInstBase.resetPSWPEngineId();
                return true;
            }
            case 3: {
                pSWPEngineInstBase.resetPSWPEngineInstId();
                return true;
            }
            case 4: {
                pSWPEngineInstBase.resetPSWPEngineInstName();
                return true;
            }
            case 5: {
                pSWPEngineInstBase.resetPSWPEngineName();
                return true;
            }
            case 6: {
                pSWPEngineInstBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSWPEngineInstBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFEngine getPSWPEngine() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPEngine();
        }
        if (this.getPSWPEngineId() == null) {
            return null;
        }
        Integer n = this.objPSWPEngineLock;
        synchronized (n) {
            if (this.pswpengine != null && DataTypeHelper.compare((int)25, (Object)this.getPSWPEngineId(), (Object)this.pswpengine.getPSWPEngineId()) != 0L) {
                this.pswpengine = null;
            }
            if (this.pswpengine == null) {
                PSWFEngine pSWFEngine = new PSWFEngine();
                pSWFEngine.setPSWPEngineId(this.getPSWPEngineId());
                PSWFEngineService pSWFEngineService = (PSWFEngineService)ServiceGlobal.getService(PSWFEngineService.class, (SessionFactory)this.getSessionFactory());
                pSWFEngineService.autoGet((IEntity)pSWFEngine);
                this.pswpengine = pSWFEngine;
            }
            return this.pswpengine;
        }
    }

    private PSWPEngineInstBase getProxyEntity() {
        return this.proxyPSWPEngineInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWPEngineInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSWPEngineInstBase) {
            this.proxyPSWPEngineInstBase = (PSWPEngineInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPEngineInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSWPENGINEID, 2);
        fieldIndexMap.put(FIELD_PSWPENGINEINSTID, 3);
        fieldIndexMap.put(FIELD_PSWPENGINEINSTNAME, 4);
        fieldIndexMap.put(FIELD_PSWPENGINENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

