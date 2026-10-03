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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVer;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSaaSSysAPIBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSaaSSysAPIBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSSAASSYSAPIID = "PSSAASSYSAPIID";
    public static final String FIELD_PSSAASSYSAPINAME = "PSSAASSYSAPINAME";
    public static final String FIELD_PSSAASSYSVERID = "PSSAASSYSVERID";
    public static final String FIELD_PSSAASSYSVERNAME = "PSSAASSYSVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSSAASSYSAPIID = 2;
    private static final int INDEX_PSSAASSYSAPINAME = 3;
    private static final int INDEX_PSSAASSYSVERID = 4;
    private static final int INDEX_PSSAASSYSVERNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSaaSSysAPIBase proxyPSSaaSSysAPIBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pssaassysapiidDirtyFlag = false;
    private boolean pssaassysapinameDirtyFlag = false;
    private boolean pssaassysveridDirtyFlag = false;
    private boolean pssaassysvernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pssaassysapiid")
    private String pssaassysapiid;
    @Column(name="pssaassysapiname")
    private String pssaassysapiname;
    @Column(name="pssaassysverid")
    private String pssaassysverid;
    @Column(name="pssaassysvername")
    private String pssaassysvername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSaaSSysVerLock = new Integer(1);
    private PSSaaSSysVer pssaassysver = null;

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

    public void setPSSaaSSysAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysapiid = string;
        this.pssaassysapiidDirtyFlag = true;
    }

    public String getPSSaaSSysAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysAPIId();
        }
        return this.pssaassysapiid;
    }

    public boolean isPSSaaSSysAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysAPIIdDirty();
        }
        return this.pssaassysapiidDirtyFlag;
    }

    public void resetPSSaaSSysAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysAPIId();
            return;
        }
        this.pssaassysapiidDirtyFlag = false;
        this.pssaassysapiid = null;
    }

    public void setPSSaaSSysAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysapiname = string;
        this.pssaassysapinameDirtyFlag = true;
    }

    public String getPSSaaSSysAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysAPIName();
        }
        return this.pssaassysapiname;
    }

    public boolean isPSSaaSSysAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysAPINameDirty();
        }
        return this.pssaassysapinameDirtyFlag;
    }

    public void resetPSSaaSSysAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysAPIName();
            return;
        }
        this.pssaassysapinameDirtyFlag = false;
        this.pssaassysapiname = null;
    }

    public void setPSSaaSSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysverid = string;
        this.pssaassysveridDirtyFlag = true;
    }

    public String getPSSaaSSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysVerId();
        }
        return this.pssaassysverid;
    }

    public boolean isPSSaaSSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysVerIdDirty();
        }
        return this.pssaassysveridDirtyFlag;
    }

    public void resetPSSaaSSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysVerId();
            return;
        }
        this.pssaassysveridDirtyFlag = false;
        this.pssaassysverid = null;
    }

    public void setPSSaaSSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysvername = string;
        this.pssaassysvernameDirtyFlag = true;
    }

    public String getPSSaaSSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysVerName();
        }
        return this.pssaassysvername;
    }

    public boolean isPSSaaSSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysVerNameDirty();
        }
        return this.pssaassysvernameDirtyFlag;
    }

    public void resetPSSaaSSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysVerName();
            return;
        }
        this.pssaassysvernameDirtyFlag = false;
        this.pssaassysvername = null;
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
        PSSaaSSysAPIBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSaaSSysAPIBase pSSaaSSysAPIBase) {
        pSSaaSSysAPIBase.resetCreateDate();
        pSSaaSSysAPIBase.resetCreateMan();
        pSSaaSSysAPIBase.resetPSSaaSSysAPIId();
        pSSaaSSysAPIBase.resetPSSaaSSysAPIName();
        pSSaaSSysAPIBase.resetPSSaaSSysVerId();
        pSSaaSSysAPIBase.resetPSSaaSSysVerName();
        pSSaaSSysAPIBase.resetUpdateDate();
        pSSaaSSysAPIBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSSaaSSysAPIIdDirty()) {
            hashMap.put(FIELD_PSSAASSYSAPIID, this.getPSSaaSSysAPIId());
        }
        if (!bl || this.isPSSaaSSysAPINameDirty()) {
            hashMap.put(FIELD_PSSAASSYSAPINAME, this.getPSSaaSSysAPIName());
        }
        if (!bl || this.isPSSaaSSysVerIdDirty()) {
            hashMap.put(FIELD_PSSAASSYSVERID, this.getPSSaaSSysVerId());
        }
        if (!bl || this.isPSSaaSSysVerNameDirty()) {
            hashMap.put(FIELD_PSSAASSYSVERNAME, this.getPSSaaSSysVerName());
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
        return PSSaaSSysAPIBase.get(this, n);
    }

    private static Object get(PSSaaSSysAPIBase pSSaaSSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSaaSSysAPIBase.getCreateDate();
            }
            case 1: {
                return pSSaaSSysAPIBase.getCreateMan();
            }
            case 2: {
                return pSSaaSSysAPIBase.getPSSaaSSysAPIId();
            }
            case 3: {
                return pSSaaSSysAPIBase.getPSSaaSSysAPIName();
            }
            case 4: {
                return pSSaaSSysAPIBase.getPSSaaSSysVerId();
            }
            case 5: {
                return pSSaaSSysAPIBase.getPSSaaSSysVerName();
            }
            case 6: {
                return pSSaaSSysAPIBase.getUpdateDate();
            }
            case 7: {
                return pSSaaSSysAPIBase.getUpdateMan();
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
        PSSaaSSysAPIBase.set(this, n, object);
    }

    private static void set(PSSaaSSysAPIBase pSSaaSSysAPIBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSaaSSysAPIBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSaaSSysAPIBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSaaSSysAPIBase.setPSSaaSSysAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSaaSSysAPIBase.setPSSaaSSysAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSaaSSysAPIBase.setPSSaaSSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSaaSSysAPIBase.setPSSaaSSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSaaSSysAPIBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSaaSSysAPIBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSaaSSysAPIBase.isNull(this, n);
    }

    private static boolean isNull(PSSaaSSysAPIBase pSSaaSSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSaaSSysAPIBase.getCreateDate() == null;
            }
            case 1: {
                return pSSaaSSysAPIBase.getCreateMan() == null;
            }
            case 2: {
                return pSSaaSSysAPIBase.getPSSaaSSysAPIId() == null;
            }
            case 3: {
                return pSSaaSSysAPIBase.getPSSaaSSysAPIName() == null;
            }
            case 4: {
                return pSSaaSSysAPIBase.getPSSaaSSysVerId() == null;
            }
            case 5: {
                return pSSaaSSysAPIBase.getPSSaaSSysVerName() == null;
            }
            case 6: {
                return pSSaaSSysAPIBase.getUpdateDate() == null;
            }
            case 7: {
                return pSSaaSSysAPIBase.getUpdateMan() == null;
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
        return PSSaaSSysAPIBase.contains(this, n);
    }

    private static boolean contains(PSSaaSSysAPIBase pSSaaSSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSaaSSysAPIBase.isCreateDateDirty();
            }
            case 1: {
                return pSSaaSSysAPIBase.isCreateManDirty();
            }
            case 2: {
                return pSSaaSSysAPIBase.isPSSaaSSysAPIIdDirty();
            }
            case 3: {
                return pSSaaSSysAPIBase.isPSSaaSSysAPINameDirty();
            }
            case 4: {
                return pSSaaSSysAPIBase.isPSSaaSSysVerIdDirty();
            }
            case 5: {
                return pSSaaSSysAPIBase.isPSSaaSSysVerNameDirty();
            }
            case 6: {
                return pSSaaSSysAPIBase.isUpdateDateDirty();
            }
            case 7: {
                return pSSaaSSysAPIBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSaaSSysAPIBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSaaSSysAPIBase pSSaaSSysAPIBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSaaSSysAPIBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSaaSSysAPIBase.getJSONValue((Object)pSSaaSSysAPIBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSaaSSysAPIBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSaaSSysAPIBase.getJSONValue((Object)pSSaaSSysAPIBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSaaSSysAPIBase.getPSSaaSSysAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysapiid", (Object)PSSaaSSysAPIBase.getJSONValue((Object)pSSaaSSysAPIBase.getPSSaaSSysAPIId()), (boolean)false);
        }
        if (bl || pSSaaSSysAPIBase.getPSSaaSSysAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysapiname", (Object)PSSaaSSysAPIBase.getJSONValue((Object)pSSaaSSysAPIBase.getPSSaaSSysAPIName()), (boolean)false);
        }
        if (bl || pSSaaSSysAPIBase.getPSSaaSSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysverid", (Object)PSSaaSSysAPIBase.getJSONValue((Object)pSSaaSSysAPIBase.getPSSaaSSysVerId()), (boolean)false);
        }
        if (bl || pSSaaSSysAPIBase.getPSSaaSSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysvername", (Object)PSSaaSSysAPIBase.getJSONValue((Object)pSSaaSSysAPIBase.getPSSaaSSysVerName()), (boolean)false);
        }
        if (bl || pSSaaSSysAPIBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSaaSSysAPIBase.getJSONValue((Object)pSSaaSSysAPIBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSaaSSysAPIBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSaaSSysAPIBase.getJSONValue((Object)pSSaaSSysAPIBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSaaSSysAPIBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSaaSSysAPIBase pSSaaSSysAPIBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSaaSSysAPIBase.getCreateDate() != null) {
            object = pSSaaSSysAPIBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSaaSSysAPIBase.getCreateMan() != null) {
            object = pSSaaSSysAPIBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysAPIBase.getPSSaaSSysAPIId() != null) {
            object = pSSaaSSysAPIBase.getPSSaaSSysAPIId();
            xmlNode.setAttribute(FIELD_PSSAASSYSAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysAPIBase.getPSSaaSSysAPIName() != null) {
            object = pSSaaSSysAPIBase.getPSSaaSSysAPIName();
            xmlNode.setAttribute(FIELD_PSSAASSYSAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysAPIBase.getPSSaaSSysVerId() != null) {
            object = pSSaaSSysAPIBase.getPSSaaSSysVerId();
            xmlNode.setAttribute(FIELD_PSSAASSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysAPIBase.getPSSaaSSysVerName() != null) {
            object = pSSaaSSysAPIBase.getPSSaaSSysVerName();
            xmlNode.setAttribute(FIELD_PSSAASSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysAPIBase.getUpdateDate() != null) {
            object = pSSaaSSysAPIBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSaaSSysAPIBase.getUpdateMan() != null) {
            object = pSSaaSSysAPIBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSaaSSysAPIBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSaaSSysAPIBase pSSaaSSysAPIBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSaaSSysAPIBase.isCreateDateDirty() && (bl || pSSaaSSysAPIBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSaaSSysAPIBase.getCreateDate());
        }
        if (pSSaaSSysAPIBase.isCreateManDirty() && (bl || pSSaaSSysAPIBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSaaSSysAPIBase.getCreateMan());
        }
        if (pSSaaSSysAPIBase.isPSSaaSSysAPIIdDirty() && (bl || pSSaaSSysAPIBase.getPSSaaSSysAPIId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSAPIID, (Object)pSSaaSSysAPIBase.getPSSaaSSysAPIId());
        }
        if (pSSaaSSysAPIBase.isPSSaaSSysAPINameDirty() && (bl || pSSaaSSysAPIBase.getPSSaaSSysAPIName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSAPINAME, (Object)pSSaaSSysAPIBase.getPSSaaSSysAPIName());
        }
        if (pSSaaSSysAPIBase.isPSSaaSSysVerIdDirty() && (bl || pSSaaSSysAPIBase.getPSSaaSSysVerId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSVERID, (Object)pSSaaSSysAPIBase.getPSSaaSSysVerId());
        }
        if (pSSaaSSysAPIBase.isPSSaaSSysVerNameDirty() && (bl || pSSaaSSysAPIBase.getPSSaaSSysVerName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSVERNAME, (Object)pSSaaSSysAPIBase.getPSSaaSSysVerName());
        }
        if (pSSaaSSysAPIBase.isUpdateDateDirty() && (bl || pSSaaSSysAPIBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSaaSSysAPIBase.getUpdateDate());
        }
        if (pSSaaSSysAPIBase.isUpdateManDirty() && (bl || pSSaaSSysAPIBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSaaSSysAPIBase.getUpdateMan());
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
        return PSSaaSSysAPIBase.remove(this, n);
    }

    private static boolean remove(PSSaaSSysAPIBase pSSaaSSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSaaSSysAPIBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSaaSSysAPIBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSaaSSysAPIBase.resetPSSaaSSysAPIId();
                return true;
            }
            case 3: {
                pSSaaSSysAPIBase.resetPSSaaSSysAPIName();
                return true;
            }
            case 4: {
                pSSaaSSysAPIBase.resetPSSaaSSysVerId();
                return true;
            }
            case 5: {
                pSSaaSSysAPIBase.resetPSSaaSSysVerName();
                return true;
            }
            case 6: {
                pSSaaSSysAPIBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSSaaSSysAPIBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSaaSSysVer getPSSaaSSysVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysVer();
        }
        if (this.getPSSaaSSysVerId() == null) {
            return null;
        }
        Integer n = this.objPSSaaSSysVerLock;
        synchronized (n) {
            if (this.pssaassysver != null && DataTypeHelper.compare((int)25, (Object)this.getPSSaaSSysVerId(), (Object)this.pssaassysver.getPSSaaSSysVerId()) != 0L) {
                this.pssaassysver = null;
            }
            if (this.pssaassysver == null) {
                PSSaaSSysVer pSSaaSSysVer = new PSSaaSSysVer();
                pSSaaSSysVer.setPSSaaSSysVerId(this.getPSSaaSSysVerId());
                PSSaaSSysVerService pSSaaSSysVerService = (PSSaaSSysVerService)ServiceGlobal.getService(PSSaaSSysVerService.class, (SessionFactory)this.getSessionFactory());
                pSSaaSSysVerService.autoGet(pSSaaSSysVer);
                this.pssaassysver = pSSaaSSysVer;
            }
            return this.pssaassysver;
        }
    }

    private PSSaaSSysAPIBase getProxyEntity() {
        return this.proxyPSSaaSSysAPIBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSaaSSysAPIBase = null;
        if (iDataObject != null && iDataObject instanceof PSSaaSSysAPIBase) {
            this.proxyPSSaaSSysAPIBase = (PSSaaSSysAPIBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAPIService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSSAASSYSAPIID, 2);
        fieldIndexMap.put(FIELD_PSSAASSYSAPINAME, 3);
        fieldIndexMap.put(FIELD_PSSAASSYSVERID, 4);
        fieldIndexMap.put(FIELD_PSSAASSYSVERNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

