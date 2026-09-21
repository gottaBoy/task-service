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
package net.ibizsys.pscore.srv.paasmgr.entity;

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

public abstract class PSSvrProviderBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSvrProviderBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSVRPROVIDERID = "PSSVRPROVIDERID";
    public static final String FIELD_PSSVRPROVIDERNAME = "PSSVRPROVIDERNAME";
    public static final String FIELD_SPSN = "SPSN";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSVRPROVIDERID = 3;
    private static final int INDEX_PSSVRPROVIDERNAME = 4;
    private static final int INDEX_SPSN = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSvrProviderBase proxyPSSvrProviderBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssvrprovideridDirtyFlag = false;
    private boolean pssvrprovidernameDirtyFlag = false;
    private boolean spsnDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssvrproviderid")
    private String pssvrproviderid;
    @Column(name="pssvrprovidername")
    private String pssvrprovidername;
    @Column(name="spsn")
    private String spsn;
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

    public void setPSSvrProviderId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrProviderId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrproviderid = string;
        this.pssvrprovideridDirtyFlag = true;
    }

    public String getPSSvrProviderId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrProviderId();
        }
        return this.pssvrproviderid;
    }

    public boolean isPSSvrProviderIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrProviderIdDirty();
        }
        return this.pssvrprovideridDirtyFlag;
    }

    public void resetPSSvrProviderId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrProviderId();
            return;
        }
        this.pssvrprovideridDirtyFlag = false;
        this.pssvrproviderid = null;
    }

    public void setPSSvrProviderName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrProviderName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrprovidername = string;
        this.pssvrprovidernameDirtyFlag = true;
    }

    public String getPSSvrProviderName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrProviderName();
        }
        return this.pssvrprovidername;
    }

    public boolean isPSSvrProviderNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrProviderNameDirty();
        }
        return this.pssvrprovidernameDirtyFlag;
    }

    public void resetPSSvrProviderName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrProviderName();
            return;
        }
        this.pssvrprovidernameDirtyFlag = false;
        this.pssvrprovidername = null;
    }

    public void setSPSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSPSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.spsn = string;
        this.spsnDirtyFlag = true;
    }

    public String getSPSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSPSN();
        }
        return this.spsn;
    }

    public boolean isSPSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSPSNDirty();
        }
        return this.spsnDirtyFlag;
    }

    public void resetSPSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSPSN();
            return;
        }
        this.spsnDirtyFlag = false;
        this.spsn = null;
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
        PSSvrProviderBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSvrProviderBase pSSvrProviderBase) {
        pSSvrProviderBase.resetCreateDate();
        pSSvrProviderBase.resetCreateMan();
        pSSvrProviderBase.resetMemo();
        pSSvrProviderBase.resetPSSvrProviderId();
        pSSvrProviderBase.resetPSSvrProviderName();
        pSSvrProviderBase.resetSPSN();
        pSSvrProviderBase.resetUpdateDate();
        pSSvrProviderBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSvrProviderIdDirty()) {
            hashMap.put(FIELD_PSSVRPROVIDERID, this.getPSSvrProviderId());
        }
        if (!bl || this.isPSSvrProviderNameDirty()) {
            hashMap.put(FIELD_PSSVRPROVIDERNAME, this.getPSSvrProviderName());
        }
        if (!bl || this.isSPSNDirty()) {
            hashMap.put(FIELD_SPSN, this.getSPSN());
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
        return PSSvrProviderBase.get(this, n);
    }

    private static Object get(PSSvrProviderBase pSSvrProviderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSvrProviderBase.getCreateDate();
            }
            case 1: {
                return pSSvrProviderBase.getCreateMan();
            }
            case 2: {
                return pSSvrProviderBase.getMemo();
            }
            case 3: {
                return pSSvrProviderBase.getPSSvrProviderId();
            }
            case 4: {
                return pSSvrProviderBase.getPSSvrProviderName();
            }
            case 5: {
                return pSSvrProviderBase.getSPSN();
            }
            case 6: {
                return pSSvrProviderBase.getUpdateDate();
            }
            case 7: {
                return pSSvrProviderBase.getUpdateMan();
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
        PSSvrProviderBase.set(this, n, object);
    }

    private static void set(PSSvrProviderBase pSSvrProviderBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSvrProviderBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSvrProviderBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSvrProviderBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSvrProviderBase.setPSSvrProviderId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSvrProviderBase.setPSSvrProviderName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSvrProviderBase.setSPSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSvrProviderBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSvrProviderBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSvrProviderBase.isNull(this, n);
    }

    private static boolean isNull(PSSvrProviderBase pSSvrProviderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSvrProviderBase.getCreateDate() == null;
            }
            case 1: {
                return pSSvrProviderBase.getCreateMan() == null;
            }
            case 2: {
                return pSSvrProviderBase.getMemo() == null;
            }
            case 3: {
                return pSSvrProviderBase.getPSSvrProviderId() == null;
            }
            case 4: {
                return pSSvrProviderBase.getPSSvrProviderName() == null;
            }
            case 5: {
                return pSSvrProviderBase.getSPSN() == null;
            }
            case 6: {
                return pSSvrProviderBase.getUpdateDate() == null;
            }
            case 7: {
                return pSSvrProviderBase.getUpdateMan() == null;
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
        return PSSvrProviderBase.contains(this, n);
    }

    private static boolean contains(PSSvrProviderBase pSSvrProviderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSvrProviderBase.isCreateDateDirty();
            }
            case 1: {
                return pSSvrProviderBase.isCreateManDirty();
            }
            case 2: {
                return pSSvrProviderBase.isMemoDirty();
            }
            case 3: {
                return pSSvrProviderBase.isPSSvrProviderIdDirty();
            }
            case 4: {
                return pSSvrProviderBase.isPSSvrProviderNameDirty();
            }
            case 5: {
                return pSSvrProviderBase.isSPSNDirty();
            }
            case 6: {
                return pSSvrProviderBase.isUpdateDateDirty();
            }
            case 7: {
                return pSSvrProviderBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSvrProviderBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSvrProviderBase pSSvrProviderBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSvrProviderBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSvrProviderBase.getJSONValue((Object)pSSvrProviderBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSvrProviderBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSvrProviderBase.getJSONValue((Object)pSSvrProviderBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSvrProviderBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSvrProviderBase.getJSONValue((Object)pSSvrProviderBase.getMemo()), (boolean)false);
        }
        if (bl || pSSvrProviderBase.getPSSvrProviderId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrproviderid", (Object)PSSvrProviderBase.getJSONValue((Object)pSSvrProviderBase.getPSSvrProviderId()), (boolean)false);
        }
        if (bl || pSSvrProviderBase.getPSSvrProviderName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrprovidername", (Object)PSSvrProviderBase.getJSONValue((Object)pSSvrProviderBase.getPSSvrProviderName()), (boolean)false);
        }
        if (bl || pSSvrProviderBase.getSPSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"spsn", (Object)PSSvrProviderBase.getJSONValue((Object)pSSvrProviderBase.getSPSN()), (boolean)false);
        }
        if (bl || pSSvrProviderBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSvrProviderBase.getJSONValue((Object)pSSvrProviderBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSvrProviderBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSvrProviderBase.getJSONValue((Object)pSSvrProviderBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSvrProviderBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSvrProviderBase pSSvrProviderBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSvrProviderBase.getCreateDate() != null) {
            object = pSSvrProviderBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSvrProviderBase.getCreateMan() != null) {
            object = pSSvrProviderBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSvrProviderBase.getMemo() != null) {
            object = pSSvrProviderBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSvrProviderBase.getPSSvrProviderId() != null) {
            object = pSSvrProviderBase.getPSSvrProviderId();
            xmlNode.setAttribute(FIELD_PSSVRPROVIDERID, object == null ? "" : (String)object);
        }
        if (bl || pSSvrProviderBase.getPSSvrProviderName() != null) {
            object = pSSvrProviderBase.getPSSvrProviderName();
            xmlNode.setAttribute(FIELD_PSSVRPROVIDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSvrProviderBase.getSPSN() != null) {
            object = pSSvrProviderBase.getSPSN();
            xmlNode.setAttribute(FIELD_SPSN, object == null ? "" : (String)object);
        }
        if (bl || pSSvrProviderBase.getUpdateDate() != null) {
            object = pSSvrProviderBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSvrProviderBase.getUpdateMan() != null) {
            object = pSSvrProviderBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSvrProviderBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSvrProviderBase pSSvrProviderBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSvrProviderBase.isCreateDateDirty() && (bl || pSSvrProviderBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSvrProviderBase.getCreateDate());
        }
        if (pSSvrProviderBase.isCreateManDirty() && (bl || pSSvrProviderBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSvrProviderBase.getCreateMan());
        }
        if (pSSvrProviderBase.isMemoDirty() && (bl || pSSvrProviderBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSvrProviderBase.getMemo());
        }
        if (pSSvrProviderBase.isPSSvrProviderIdDirty() && (bl || pSSvrProviderBase.getPSSvrProviderId() != null)) {
            iDataObject.set(FIELD_PSSVRPROVIDERID, (Object)pSSvrProviderBase.getPSSvrProviderId());
        }
        if (pSSvrProviderBase.isPSSvrProviderNameDirty() && (bl || pSSvrProviderBase.getPSSvrProviderName() != null)) {
            iDataObject.set(FIELD_PSSVRPROVIDERNAME, (Object)pSSvrProviderBase.getPSSvrProviderName());
        }
        if (pSSvrProviderBase.isSPSNDirty() && (bl || pSSvrProviderBase.getSPSN() != null)) {
            iDataObject.set(FIELD_SPSN, (Object)pSSvrProviderBase.getSPSN());
        }
        if (pSSvrProviderBase.isUpdateDateDirty() && (bl || pSSvrProviderBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSvrProviderBase.getUpdateDate());
        }
        if (pSSvrProviderBase.isUpdateManDirty() && (bl || pSSvrProviderBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSvrProviderBase.getUpdateMan());
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
        return PSSvrProviderBase.remove(this, n);
    }

    private static boolean remove(PSSvrProviderBase pSSvrProviderBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSvrProviderBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSvrProviderBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSvrProviderBase.resetMemo();
                return true;
            }
            case 3: {
                pSSvrProviderBase.resetPSSvrProviderId();
                return true;
            }
            case 4: {
                pSSvrProviderBase.resetPSSvrProviderName();
                return true;
            }
            case 5: {
                pSSvrProviderBase.resetSPSN();
                return true;
            }
            case 6: {
                pSSvrProviderBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSSvrProviderBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSvrProviderBase getProxyEntity() {
        return this.proxyPSSvrProviderBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSvrProviderBase = null;
        if (iDataObject != null && iDataObject instanceof PSSvrProviderBase) {
            this.proxyPSSvrProviderBase = (PSSvrProviderBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrProviderService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSVRPROVIDERID, 3);
        fieldIndexMap.put(FIELD_PSSVRPROVIDERNAME, 4);
        fieldIndexMap.put(FIELD_SPSN, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

