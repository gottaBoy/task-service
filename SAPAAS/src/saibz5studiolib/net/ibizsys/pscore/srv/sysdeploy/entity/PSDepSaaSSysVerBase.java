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
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVer;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSaaSSysVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSaaSSysVerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEPSAASSYSVERID = "PSDEPSAASSYSVERID";
    public static final String FIELD_PSDEPSAASSYSVERNAME = "PSDEPSAASSYSVERNAME";
    public static final String FIELD_PSSAASSYSVERID = "PSSAASSYSVERID";
    public static final String FIELD_PSSAASSYSVERNAME = "PSSAASSYSVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEPSAASSYSVERID = 2;
    private static final int INDEX_PSDEPSAASSYSVERNAME = 3;
    private static final int INDEX_PSSAASSYSVERID = 4;
    private static final int INDEX_PSSAASSYSVERNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSaaSSysVerBase proxyPSDepSaaSSysVerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdepsaassysveridDirtyFlag = false;
    private boolean psdepsaassysvernameDirtyFlag = false;
    private boolean pssaassysveridDirtyFlag = false;
    private boolean pssaassysvernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdepsaassysverid")
    private String psdepsaassysverid;
    @Column(name="psdepsaassysvername")
    private String psdepsaassysvername;
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

    public void setPSDepSaaSSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSaaSSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsaassysverid = string;
        this.psdepsaassysveridDirtyFlag = true;
    }

    public String getPSDepSaaSSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSaaSSysVerId();
        }
        return this.psdepsaassysverid;
    }

    public boolean isPSDepSaaSSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSaaSSysVerIdDirty();
        }
        return this.psdepsaassysveridDirtyFlag;
    }

    public void resetPSDepSaaSSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSaaSSysVerId();
            return;
        }
        this.psdepsaassysveridDirtyFlag = false;
        this.psdepsaassysverid = null;
    }

    public void setPSDepSaaSSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSaaSSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsaassysvername = string;
        this.psdepsaassysvernameDirtyFlag = true;
    }

    public String getPSDepSaaSSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSaaSSysVerName();
        }
        return this.psdepsaassysvername;
    }

    public boolean isPSDepSaaSSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSaaSSysVerNameDirty();
        }
        return this.psdepsaassysvernameDirtyFlag;
    }

    public void resetPSDepSaaSSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSaaSSysVerName();
            return;
        }
        this.psdepsaassysvernameDirtyFlag = false;
        this.psdepsaassysvername = null;
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
        PSDepSaaSSysVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSaaSSysVerBase pSDepSaaSSysVerBase) {
        pSDepSaaSSysVerBase.resetCreateDate();
        pSDepSaaSSysVerBase.resetCreateMan();
        pSDepSaaSSysVerBase.resetPSDepSaaSSysVerId();
        pSDepSaaSSysVerBase.resetPSDepSaaSSysVerName();
        pSDepSaaSSysVerBase.resetPSSaaSSysVerId();
        pSDepSaaSSysVerBase.resetPSSaaSSysVerName();
        pSDepSaaSSysVerBase.resetUpdateDate();
        pSDepSaaSSysVerBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDepSaaSSysVerIdDirty()) {
            hashMap.put(FIELD_PSDEPSAASSYSVERID, this.getPSDepSaaSSysVerId());
        }
        if (!bl || this.isPSDepSaaSSysVerNameDirty()) {
            hashMap.put(FIELD_PSDEPSAASSYSVERNAME, this.getPSDepSaaSSysVerName());
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
        return PSDepSaaSSysVerBase.get(this, n);
    }

    private static Object get(PSDepSaaSSysVerBase pSDepSaaSSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSaaSSysVerBase.getCreateDate();
            }
            case 1: {
                return pSDepSaaSSysVerBase.getCreateMan();
            }
            case 2: {
                return pSDepSaaSSysVerBase.getPSDepSaaSSysVerId();
            }
            case 3: {
                return pSDepSaaSSysVerBase.getPSDepSaaSSysVerName();
            }
            case 4: {
                return pSDepSaaSSysVerBase.getPSSaaSSysVerId();
            }
            case 5: {
                return pSDepSaaSSysVerBase.getPSSaaSSysVerName();
            }
            case 6: {
                return pSDepSaaSSysVerBase.getUpdateDate();
            }
            case 7: {
                return pSDepSaaSSysVerBase.getUpdateMan();
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
        PSDepSaaSSysVerBase.set(this, n, object);
    }

    private static void set(PSDepSaaSSysVerBase pSDepSaaSSysVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSaaSSysVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSaaSSysVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSaaSSysVerBase.setPSDepSaaSSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSaaSSysVerBase.setPSDepSaaSSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSaaSSysVerBase.setPSSaaSSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSaaSSysVerBase.setPSSaaSSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSaaSSysVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDepSaaSSysVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSaaSSysVerBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSaaSSysVerBase pSDepSaaSSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSaaSSysVerBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSaaSSysVerBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSaaSSysVerBase.getPSDepSaaSSysVerId() == null;
            }
            case 3: {
                return pSDepSaaSSysVerBase.getPSDepSaaSSysVerName() == null;
            }
            case 4: {
                return pSDepSaaSSysVerBase.getPSSaaSSysVerId() == null;
            }
            case 5: {
                return pSDepSaaSSysVerBase.getPSSaaSSysVerName() == null;
            }
            case 6: {
                return pSDepSaaSSysVerBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDepSaaSSysVerBase.getUpdateMan() == null;
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
        return PSDepSaaSSysVerBase.contains(this, n);
    }

    private static boolean contains(PSDepSaaSSysVerBase pSDepSaaSSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSaaSSysVerBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSaaSSysVerBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSaaSSysVerBase.isPSDepSaaSSysVerIdDirty();
            }
            case 3: {
                return pSDepSaaSSysVerBase.isPSDepSaaSSysVerNameDirty();
            }
            case 4: {
                return pSDepSaaSSysVerBase.isPSSaaSSysVerIdDirty();
            }
            case 5: {
                return pSDepSaaSSysVerBase.isPSSaaSSysVerNameDirty();
            }
            case 6: {
                return pSDepSaaSSysVerBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDepSaaSSysVerBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSaaSSysVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSaaSSysVerBase pSDepSaaSSysVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSaaSSysVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSaaSSysVerBase.getJSONValue((Object)pSDepSaaSSysVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSaaSSysVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSaaSSysVerBase.getJSONValue((Object)pSDepSaaSSysVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSaaSSysVerBase.getPSDepSaaSSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsaassysverid", (Object)PSDepSaaSSysVerBase.getJSONValue((Object)pSDepSaaSSysVerBase.getPSDepSaaSSysVerId()), (boolean)false);
        }
        if (bl || pSDepSaaSSysVerBase.getPSDepSaaSSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsaassysvername", (Object)PSDepSaaSSysVerBase.getJSONValue((Object)pSDepSaaSSysVerBase.getPSDepSaaSSysVerName()), (boolean)false);
        }
        if (bl || pSDepSaaSSysVerBase.getPSSaaSSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysverid", (Object)PSDepSaaSSysVerBase.getJSONValue((Object)pSDepSaaSSysVerBase.getPSSaaSSysVerId()), (boolean)false);
        }
        if (bl || pSDepSaaSSysVerBase.getPSSaaSSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysvername", (Object)PSDepSaaSSysVerBase.getJSONValue((Object)pSDepSaaSSysVerBase.getPSSaaSSysVerName()), (boolean)false);
        }
        if (bl || pSDepSaaSSysVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSaaSSysVerBase.getJSONValue((Object)pSDepSaaSSysVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSaaSSysVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSaaSSysVerBase.getJSONValue((Object)pSDepSaaSSysVerBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSaaSSysVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSaaSSysVerBase pSDepSaaSSysVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSaaSSysVerBase.getCreateDate() != null) {
            object = pSDepSaaSSysVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSaaSSysVerBase.getCreateMan() != null) {
            object = pSDepSaaSSysVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysVerBase.getPSDepSaaSSysVerId() != null) {
            object = pSDepSaaSSysVerBase.getPSDepSaaSSysVerId();
            xmlNode.setAttribute(FIELD_PSDEPSAASSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysVerBase.getPSDepSaaSSysVerName() != null) {
            object = pSDepSaaSSysVerBase.getPSDepSaaSSysVerName();
            xmlNode.setAttribute(FIELD_PSDEPSAASSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysVerBase.getPSSaaSSysVerId() != null) {
            object = pSDepSaaSSysVerBase.getPSSaaSSysVerId();
            xmlNode.setAttribute(FIELD_PSSAASSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysVerBase.getPSSaaSSysVerName() != null) {
            object = pSDepSaaSSysVerBase.getPSSaaSSysVerName();
            xmlNode.setAttribute(FIELD_PSSAASSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysVerBase.getUpdateDate() != null) {
            object = pSDepSaaSSysVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSaaSSysVerBase.getUpdateMan() != null) {
            object = pSDepSaaSSysVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSaaSSysVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSaaSSysVerBase pSDepSaaSSysVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSaaSSysVerBase.isCreateDateDirty() && (bl || pSDepSaaSSysVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSaaSSysVerBase.getCreateDate());
        }
        if (pSDepSaaSSysVerBase.isCreateManDirty() && (bl || pSDepSaaSSysVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSaaSSysVerBase.getCreateMan());
        }
        if (pSDepSaaSSysVerBase.isPSDepSaaSSysVerIdDirty() && (bl || pSDepSaaSSysVerBase.getPSDepSaaSSysVerId() != null)) {
            iDataObject.set(FIELD_PSDEPSAASSYSVERID, (Object)pSDepSaaSSysVerBase.getPSDepSaaSSysVerId());
        }
        if (pSDepSaaSSysVerBase.isPSDepSaaSSysVerNameDirty() && (bl || pSDepSaaSSysVerBase.getPSDepSaaSSysVerName() != null)) {
            iDataObject.set(FIELD_PSDEPSAASSYSVERNAME, (Object)pSDepSaaSSysVerBase.getPSDepSaaSSysVerName());
        }
        if (pSDepSaaSSysVerBase.isPSSaaSSysVerIdDirty() && (bl || pSDepSaaSSysVerBase.getPSSaaSSysVerId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSVERID, (Object)pSDepSaaSSysVerBase.getPSSaaSSysVerId());
        }
        if (pSDepSaaSSysVerBase.isPSSaaSSysVerNameDirty() && (bl || pSDepSaaSSysVerBase.getPSSaaSSysVerName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSVERNAME, (Object)pSDepSaaSSysVerBase.getPSSaaSSysVerName());
        }
        if (pSDepSaaSSysVerBase.isUpdateDateDirty() && (bl || pSDepSaaSSysVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSaaSSysVerBase.getUpdateDate());
        }
        if (pSDepSaaSSysVerBase.isUpdateManDirty() && (bl || pSDepSaaSSysVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSaaSSysVerBase.getUpdateMan());
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
        return PSDepSaaSSysVerBase.remove(this, n);
    }

    private static boolean remove(PSDepSaaSSysVerBase pSDepSaaSSysVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSaaSSysVerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSaaSSysVerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSaaSSysVerBase.resetPSDepSaaSSysVerId();
                return true;
            }
            case 3: {
                pSDepSaaSSysVerBase.resetPSDepSaaSSysVerName();
                return true;
            }
            case 4: {
                pSDepSaaSSysVerBase.resetPSSaaSSysVerId();
                return true;
            }
            case 5: {
                pSDepSaaSSysVerBase.resetPSSaaSSysVerName();
                return true;
            }
            case 6: {
                pSDepSaaSSysVerBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDepSaaSSysVerBase.resetUpdateMan();
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

    private PSDepSaaSSysVerBase getProxyEntity() {
        return this.proxyPSDepSaaSSysVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSaaSSysVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSaaSSysVerBase) {
            this.proxyPSDepSaaSSysVerBase = (PSDepSaaSSysVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSaaSSysVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEPSAASSYSVERID, 2);
        fieldIndexMap.put(FIELD_PSDEPSAASSYSVERNAME, 3);
        fieldIndexMap.put(FIELD_PSSAASSYSVERID, 4);
        fieldIndexMap.put(FIELD_PSSAASSYSVERNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

