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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppViewStyleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppViewStyleBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPVIEWSTYLEID = "PSAPPVIEWSTYLEID";
    public static final String FIELD_PSAPPVIEWSTYLENAME = "PSAPPVIEWSTYLENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSAPPVIEWSTYLEID = 3;
    private static final int INDEX_PSAPPVIEWSTYLENAME = 4;
    private static final int INDEX_PSSYSAPPID = 5;
    private static final int INDEX_PSSYSAPPNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_USERPARAMS = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppViewStyleBase proxyPSAppViewStyleBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappviewstyleidDirtyFlag = false;
    private boolean psappviewstylenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psappviewstyleid")
    private String psappviewstyleid;
    @Column(name="psappviewstylename")
    private String psappviewstylename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;

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

    public void setPSAppViewStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewstyleid = string;
        this.psappviewstyleidDirtyFlag = true;
    }

    public String getPSAppViewStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewStyleId();
        }
        return this.psappviewstyleid;
    }

    public boolean isPSAppViewStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewStyleIdDirty();
        }
        return this.psappviewstyleidDirtyFlag;
    }

    public void resetPSAppViewStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewStyleId();
            return;
        }
        this.psappviewstyleidDirtyFlag = false;
        this.psappviewstyleid = null;
    }

    public void setPSAppViewStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewstylename = string;
        this.psappviewstylenameDirtyFlag = true;
    }

    public String getPSAppViewStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewStyleName();
        }
        return this.psappviewstylename;
    }

    public boolean isPSAppViewStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewStyleNameDirty();
        }
        return this.psappviewstylenameDirtyFlag;
    }

    public void resetPSAppViewStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewStyleName();
            return;
        }
        this.psappviewstylenameDirtyFlag = false;
        this.psappviewstylename = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
    }

    protected void onReset() {
        PSAppViewStyleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppViewStyleBase pSAppViewStyleBase) {
        pSAppViewStyleBase.resetCreateDate();
        pSAppViewStyleBase.resetCreateMan();
        pSAppViewStyleBase.resetMemo();
        pSAppViewStyleBase.resetPSAppViewStyleId();
        pSAppViewStyleBase.resetPSAppViewStyleName();
        pSAppViewStyleBase.resetPSSysAppId();
        pSAppViewStyleBase.resetPSSysAppName();
        pSAppViewStyleBase.resetUpdateDate();
        pSAppViewStyleBase.resetUpdateMan();
        pSAppViewStyleBase.resetUserParams();
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
        if (!bl || this.isPSAppViewStyleIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWSTYLEID, this.getPSAppViewStyleId());
        }
        if (!bl || this.isPSAppViewStyleNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWSTYLENAME, this.getPSAppViewStyleName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSAppViewStyleBase.get(this, n);
    }

    private static Object get(PSAppViewStyleBase pSAppViewStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewStyleBase.getCreateDate();
            }
            case 1: {
                return pSAppViewStyleBase.getCreateMan();
            }
            case 2: {
                return pSAppViewStyleBase.getMemo();
            }
            case 3: {
                return pSAppViewStyleBase.getPSAppViewStyleId();
            }
            case 4: {
                return pSAppViewStyleBase.getPSAppViewStyleName();
            }
            case 5: {
                return pSAppViewStyleBase.getPSSysAppId();
            }
            case 6: {
                return pSAppViewStyleBase.getPSSysAppName();
            }
            case 7: {
                return pSAppViewStyleBase.getUpdateDate();
            }
            case 8: {
                return pSAppViewStyleBase.getUpdateMan();
            }
            case 9: {
                return pSAppViewStyleBase.getUserParams();
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
        PSAppViewStyleBase.set(this, n, object);
    }

    private static void set(PSAppViewStyleBase pSAppViewStyleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppViewStyleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAppViewStyleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppViewStyleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppViewStyleBase.setPSAppViewStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppViewStyleBase.setPSAppViewStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppViewStyleBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppViewStyleBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppViewStyleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSAppViewStyleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppViewStyleBase.setUserParams(DataObject.getStringValue((Object)object));
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
        return PSAppViewStyleBase.isNull(this, n);
    }

    private static boolean isNull(PSAppViewStyleBase pSAppViewStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewStyleBase.getCreateDate() == null;
            }
            case 1: {
                return pSAppViewStyleBase.getCreateMan() == null;
            }
            case 2: {
                return pSAppViewStyleBase.getMemo() == null;
            }
            case 3: {
                return pSAppViewStyleBase.getPSAppViewStyleId() == null;
            }
            case 4: {
                return pSAppViewStyleBase.getPSAppViewStyleName() == null;
            }
            case 5: {
                return pSAppViewStyleBase.getPSSysAppId() == null;
            }
            case 6: {
                return pSAppViewStyleBase.getPSSysAppName() == null;
            }
            case 7: {
                return pSAppViewStyleBase.getUpdateDate() == null;
            }
            case 8: {
                return pSAppViewStyleBase.getUpdateMan() == null;
            }
            case 9: {
                return pSAppViewStyleBase.getUserParams() == null;
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
        return PSAppViewStyleBase.contains(this, n);
    }

    private static boolean contains(PSAppViewStyleBase pSAppViewStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewStyleBase.isCreateDateDirty();
            }
            case 1: {
                return pSAppViewStyleBase.isCreateManDirty();
            }
            case 2: {
                return pSAppViewStyleBase.isMemoDirty();
            }
            case 3: {
                return pSAppViewStyleBase.isPSAppViewStyleIdDirty();
            }
            case 4: {
                return pSAppViewStyleBase.isPSAppViewStyleNameDirty();
            }
            case 5: {
                return pSAppViewStyleBase.isPSSysAppIdDirty();
            }
            case 6: {
                return pSAppViewStyleBase.isPSSysAppNameDirty();
            }
            case 7: {
                return pSAppViewStyleBase.isUpdateDateDirty();
            }
            case 8: {
                return pSAppViewStyleBase.isUpdateManDirty();
            }
            case 9: {
                return pSAppViewStyleBase.isUserParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppViewStyleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppViewStyleBase pSAppViewStyleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppViewStyleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppViewStyleBase.getJSONValue((Object)pSAppViewStyleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppViewStyleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppViewStyleBase.getJSONValue((Object)pSAppViewStyleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppViewStyleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppViewStyleBase.getJSONValue((Object)pSAppViewStyleBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppViewStyleBase.getPSAppViewStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewstyleid", (Object)PSAppViewStyleBase.getJSONValue((Object)pSAppViewStyleBase.getPSAppViewStyleId()), (boolean)false);
        }
        if (bl || pSAppViewStyleBase.getPSAppViewStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewstylename", (Object)PSAppViewStyleBase.getJSONValue((Object)pSAppViewStyleBase.getPSAppViewStyleName()), (boolean)false);
        }
        if (bl || pSAppViewStyleBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppViewStyleBase.getJSONValue((Object)pSAppViewStyleBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppViewStyleBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppViewStyleBase.getJSONValue((Object)pSAppViewStyleBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppViewStyleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppViewStyleBase.getJSONValue((Object)pSAppViewStyleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppViewStyleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppViewStyleBase.getJSONValue((Object)pSAppViewStyleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppViewStyleBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSAppViewStyleBase.getJSONValue((Object)pSAppViewStyleBase.getUserParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppViewStyleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppViewStyleBase pSAppViewStyleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppViewStyleBase.getCreateDate() != null) {
            object = pSAppViewStyleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppViewStyleBase.getCreateMan() != null) {
            object = pSAppViewStyleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewStyleBase.getMemo() != null) {
            object = pSAppViewStyleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewStyleBase.getPSAppViewStyleId() != null) {
            object = pSAppViewStyleBase.getPSAppViewStyleId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewStyleBase.getPSAppViewStyleName() != null) {
            object = pSAppViewStyleBase.getPSAppViewStyleName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewStyleBase.getPSSysAppId() != null) {
            object = pSAppViewStyleBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewStyleBase.getPSSysAppName() != null) {
            object = pSAppViewStyleBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewStyleBase.getUpdateDate() != null) {
            object = pSAppViewStyleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppViewStyleBase.getUpdateMan() != null) {
            object = pSAppViewStyleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppViewStyleBase.getUserParams() != null) {
            object = pSAppViewStyleBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppViewStyleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppViewStyleBase pSAppViewStyleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppViewStyleBase.isCreateDateDirty() && (bl || pSAppViewStyleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppViewStyleBase.getCreateDate());
        }
        if (pSAppViewStyleBase.isCreateManDirty() && (bl || pSAppViewStyleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppViewStyleBase.getCreateMan());
        }
        if (pSAppViewStyleBase.isMemoDirty() && (bl || pSAppViewStyleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppViewStyleBase.getMemo());
        }
        if (pSAppViewStyleBase.isPSAppViewStyleIdDirty() && (bl || pSAppViewStyleBase.getPSAppViewStyleId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWSTYLEID, (Object)pSAppViewStyleBase.getPSAppViewStyleId());
        }
        if (pSAppViewStyleBase.isPSAppViewStyleNameDirty() && (bl || pSAppViewStyleBase.getPSAppViewStyleName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWSTYLENAME, (Object)pSAppViewStyleBase.getPSAppViewStyleName());
        }
        if (pSAppViewStyleBase.isPSSysAppIdDirty() && (bl || pSAppViewStyleBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppViewStyleBase.getPSSysAppId());
        }
        if (pSAppViewStyleBase.isPSSysAppNameDirty() && (bl || pSAppViewStyleBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppViewStyleBase.getPSSysAppName());
        }
        if (pSAppViewStyleBase.isUpdateDateDirty() && (bl || pSAppViewStyleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppViewStyleBase.getUpdateDate());
        }
        if (pSAppViewStyleBase.isUpdateManDirty() && (bl || pSAppViewStyleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppViewStyleBase.getUpdateMan());
        }
        if (pSAppViewStyleBase.isUserParamsDirty() && (bl || pSAppViewStyleBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSAppViewStyleBase.getUserParams());
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
        return PSAppViewStyleBase.remove(this, n);
    }

    private static boolean remove(PSAppViewStyleBase pSAppViewStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppViewStyleBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAppViewStyleBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAppViewStyleBase.resetMemo();
                return true;
            }
            case 3: {
                pSAppViewStyleBase.resetPSAppViewStyleId();
                return true;
            }
            case 4: {
                pSAppViewStyleBase.resetPSAppViewStyleName();
                return true;
            }
            case 5: {
                pSAppViewStyleBase.resetPSSysAppId();
                return true;
            }
            case 6: {
                pSAppViewStyleBase.resetPSSysAppName();
                return true;
            }
            case 7: {
                pSAppViewStyleBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSAppViewStyleBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSAppViewStyleBase.resetUserParams();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    private PSAppViewStyleBase getProxyEntity() {
        return this.proxyPSAppViewStyleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppViewStyleBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppViewStyleBase) {
            this.proxyPSAppViewStyleBase = (PSAppViewStyleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewStyleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSAPPVIEWSTYLEID, 3);
        fieldIndexMap.put(FIELD_PSAPPVIEWSTYLENAME, 4);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 5);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_USERPARAMS, 9);
    }
}

