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
package net.ibizsys.pscore.srv.def.entity;

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
import net.ibizsys.pscore.srv.def.entity.PSDBSysProcTempl;
import net.ibizsys.pscore.srv.def.service.PSDBSysProcTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBSPPartTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDBSPPartTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDBSPPARTTEMPLID = "PSDBSPPARTTEMPLID";
    public static final String FIELD_PSDBSPPARTTEMPLNAME = "PSDBSPPARTTEMPLNAME";
    public static final String FIELD_PSDBSYSPROCTEMPLID = "PSDBSYSPROCTEMPLID";
    public static final String FIELD_PSDBSYSPROCTEMPLNAME = "PSDBSYSPROCTEMPLNAME";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDBSPPARTTEMPLID = 3;
    private static final int INDEX_PSDBSPPARTTEMPLNAME = 4;
    private static final int INDEX_PSDBSYSPROCTEMPLID = 5;
    private static final int INDEX_PSDBSYSPROCTEMPLNAME = 6;
    private static final int INDEX_TEMPLCODE = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDBSPPartTemplBase proxyPSDBSPPartTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdbspparttemplidDirtyFlag = false;
    private boolean psdbspparttemplnameDirtyFlag = false;
    private boolean psdbsysproctemplidDirtyFlag = false;
    private boolean psdbsysproctemplnameDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdbspparttemplid")
    private String psdbspparttemplid;
    @Column(name="psdbspparttemplname")
    private String psdbspparttemplname;
    @Column(name="psdbsysproctemplid")
    private String psdbsysproctemplid;
    @Column(name="psdbsysproctemplname")
    private String psdbsysproctemplname;
    @Column(name="templcode")
    private String templcode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDBSysProcTemplLock = new Integer(1);
    private PSDBSysProcTempl psdbsysproctempl = null;

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

    public void setPSDBSPPartTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBSPPartTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbspparttemplid = string;
        this.psdbspparttemplidDirtyFlag = true;
    }

    public String getPSDBSPPartTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBSPPartTemplId();
        }
        return this.psdbspparttemplid;
    }

    public boolean isPSDBSPPartTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBSPPartTemplIdDirty();
        }
        return this.psdbspparttemplidDirtyFlag;
    }

    public void resetPSDBSPPartTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBSPPartTemplId();
            return;
        }
        this.psdbspparttemplidDirtyFlag = false;
        this.psdbspparttemplid = null;
    }

    public void setPSDBSPPartTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBSPPartTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbspparttemplname = string;
        this.psdbspparttemplnameDirtyFlag = true;
    }

    public String getPSDBSPPartTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBSPPartTemplName();
        }
        return this.psdbspparttemplname;
    }

    public boolean isPSDBSPPartTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBSPPartTemplNameDirty();
        }
        return this.psdbspparttemplnameDirtyFlag;
    }

    public void resetPSDBSPPartTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBSPPartTemplName();
            return;
        }
        this.psdbspparttemplnameDirtyFlag = false;
        this.psdbspparttemplname = null;
    }

    public void setPSDBSysProcTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBSysProcTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbsysproctemplid = string;
        this.psdbsysproctemplidDirtyFlag = true;
    }

    public String getPSDBSysProcTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBSysProcTemplId();
        }
        return this.psdbsysproctemplid;
    }

    public boolean isPSDBSysProcTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBSysProcTemplIdDirty();
        }
        return this.psdbsysproctemplidDirtyFlag;
    }

    public void resetPSDBSysProcTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBSysProcTemplId();
            return;
        }
        this.psdbsysproctemplidDirtyFlag = false;
        this.psdbsysproctemplid = null;
    }

    public void setPSDBSysProcTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBSysProcTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbsysproctemplname = string;
        this.psdbsysproctemplnameDirtyFlag = true;
    }

    public String getPSDBSysProcTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBSysProcTemplName();
        }
        return this.psdbsysproctemplname;
    }

    public boolean isPSDBSysProcTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBSysProcTemplNameDirty();
        }
        return this.psdbsysproctemplnameDirtyFlag;
    }

    public void resetPSDBSysProcTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBSysProcTemplName();
            return;
        }
        this.psdbsysproctemplnameDirtyFlag = false;
        this.psdbsysproctemplname = null;
    }

    public void setTemplCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode = string;
        this.templcodeDirtyFlag = true;
    }

    public String getTemplCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode();
        }
        return this.templcode;
    }

    public boolean isTemplCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeDirty();
        }
        return this.templcodeDirtyFlag;
    }

    public void resetTemplCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode();
            return;
        }
        this.templcodeDirtyFlag = false;
        this.templcode = null;
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
        PSDBSPPartTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDBSPPartTemplBase pSDBSPPartTemplBase) {
        pSDBSPPartTemplBase.resetCreateDate();
        pSDBSPPartTemplBase.resetCreateMan();
        pSDBSPPartTemplBase.resetMemo();
        pSDBSPPartTemplBase.resetPSDBSPPartTemplId();
        pSDBSPPartTemplBase.resetPSDBSPPartTemplName();
        pSDBSPPartTemplBase.resetPSDBSysProcTemplId();
        pSDBSPPartTemplBase.resetPSDBSysProcTemplName();
        pSDBSPPartTemplBase.resetTemplCode();
        pSDBSPPartTemplBase.resetUpdateDate();
        pSDBSPPartTemplBase.resetUpdateMan();
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
        if (!bl || this.isPSDBSPPartTemplIdDirty()) {
            hashMap.put(FIELD_PSDBSPPARTTEMPLID, this.getPSDBSPPartTemplId());
        }
        if (!bl || this.isPSDBSPPartTemplNameDirty()) {
            hashMap.put(FIELD_PSDBSPPARTTEMPLNAME, this.getPSDBSPPartTemplName());
        }
        if (!bl || this.isPSDBSysProcTemplIdDirty()) {
            hashMap.put(FIELD_PSDBSYSPROCTEMPLID, this.getPSDBSysProcTemplId());
        }
        if (!bl || this.isPSDBSysProcTemplNameDirty()) {
            hashMap.put(FIELD_PSDBSYSPROCTEMPLNAME, this.getPSDBSysProcTemplName());
        }
        if (!bl || this.isTemplCodeDirty()) {
            hashMap.put(FIELD_TEMPLCODE, this.getTemplCode());
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
        return PSDBSPPartTemplBase.get(this, n);
    }

    private static Object get(PSDBSPPartTemplBase pSDBSPPartTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBSPPartTemplBase.getCreateDate();
            }
            case 1: {
                return pSDBSPPartTemplBase.getCreateMan();
            }
            case 2: {
                return pSDBSPPartTemplBase.getMemo();
            }
            case 3: {
                return pSDBSPPartTemplBase.getPSDBSPPartTemplId();
            }
            case 4: {
                return pSDBSPPartTemplBase.getPSDBSPPartTemplName();
            }
            case 5: {
                return pSDBSPPartTemplBase.getPSDBSysProcTemplId();
            }
            case 6: {
                return pSDBSPPartTemplBase.getPSDBSysProcTemplName();
            }
            case 7: {
                return pSDBSPPartTemplBase.getTemplCode();
            }
            case 8: {
                return pSDBSPPartTemplBase.getUpdateDate();
            }
            case 9: {
                return pSDBSPPartTemplBase.getUpdateMan();
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
        PSDBSPPartTemplBase.set(this, n, object);
    }

    private static void set(PSDBSPPartTemplBase pSDBSPPartTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDBSPPartTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDBSPPartTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDBSPPartTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDBSPPartTemplBase.setPSDBSPPartTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDBSPPartTemplBase.setPSDBSPPartTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDBSPPartTemplBase.setPSDBSysProcTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDBSPPartTemplBase.setPSDBSysProcTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDBSPPartTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDBSPPartTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDBSPPartTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDBSPPartTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSDBSPPartTemplBase pSDBSPPartTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBSPPartTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSDBSPPartTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSDBSPPartTemplBase.getMemo() == null;
            }
            case 3: {
                return pSDBSPPartTemplBase.getPSDBSPPartTemplId() == null;
            }
            case 4: {
                return pSDBSPPartTemplBase.getPSDBSPPartTemplName() == null;
            }
            case 5: {
                return pSDBSPPartTemplBase.getPSDBSysProcTemplId() == null;
            }
            case 6: {
                return pSDBSPPartTemplBase.getPSDBSysProcTemplName() == null;
            }
            case 7: {
                return pSDBSPPartTemplBase.getTemplCode() == null;
            }
            case 8: {
                return pSDBSPPartTemplBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDBSPPartTemplBase.getUpdateMan() == null;
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
        return PSDBSPPartTemplBase.contains(this, n);
    }

    private static boolean contains(PSDBSPPartTemplBase pSDBSPPartTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBSPPartTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSDBSPPartTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSDBSPPartTemplBase.isMemoDirty();
            }
            case 3: {
                return pSDBSPPartTemplBase.isPSDBSPPartTemplIdDirty();
            }
            case 4: {
                return pSDBSPPartTemplBase.isPSDBSPPartTemplNameDirty();
            }
            case 5: {
                return pSDBSPPartTemplBase.isPSDBSysProcTemplIdDirty();
            }
            case 6: {
                return pSDBSPPartTemplBase.isPSDBSysProcTemplNameDirty();
            }
            case 7: {
                return pSDBSPPartTemplBase.isTemplCodeDirty();
            }
            case 8: {
                return pSDBSPPartTemplBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDBSPPartTemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDBSPPartTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDBSPPartTemplBase pSDBSPPartTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDBSPPartTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDBSPPartTemplBase.getJSONValue((Object)pSDBSPPartTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDBSPPartTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDBSPPartTemplBase.getJSONValue((Object)pSDBSPPartTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDBSPPartTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDBSPPartTemplBase.getJSONValue((Object)pSDBSPPartTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSDBSPPartTemplBase.getPSDBSPPartTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbspparttemplid", (Object)PSDBSPPartTemplBase.getJSONValue((Object)pSDBSPPartTemplBase.getPSDBSPPartTemplId()), (boolean)false);
        }
        if (bl || pSDBSPPartTemplBase.getPSDBSPPartTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbspparttemplname", (Object)PSDBSPPartTemplBase.getJSONValue((Object)pSDBSPPartTemplBase.getPSDBSPPartTemplName()), (boolean)false);
        }
        if (bl || pSDBSPPartTemplBase.getPSDBSysProcTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbsysproctemplid", (Object)PSDBSPPartTemplBase.getJSONValue((Object)pSDBSPPartTemplBase.getPSDBSysProcTemplId()), (boolean)false);
        }
        if (bl || pSDBSPPartTemplBase.getPSDBSysProcTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbsysproctemplname", (Object)PSDBSPPartTemplBase.getJSONValue((Object)pSDBSPPartTemplBase.getPSDBSysProcTemplName()), (boolean)false);
        }
        if (bl || pSDBSPPartTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSDBSPPartTemplBase.getJSONValue((Object)pSDBSPPartTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSDBSPPartTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDBSPPartTemplBase.getJSONValue((Object)pSDBSPPartTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDBSPPartTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDBSPPartTemplBase.getJSONValue((Object)pSDBSPPartTemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDBSPPartTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDBSPPartTemplBase pSDBSPPartTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDBSPPartTemplBase.getCreateDate() != null) {
            object = pSDBSPPartTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBSPPartTemplBase.getCreateMan() != null) {
            object = pSDBSPPartTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBSPPartTemplBase.getMemo() != null) {
            object = pSDBSPPartTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDBSPPartTemplBase.getPSDBSPPartTemplId() != null) {
            object = pSDBSPPartTemplBase.getPSDBSPPartTemplId();
            xmlNode.setAttribute(FIELD_PSDBSPPARTTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDBSPPartTemplBase.getPSDBSPPartTemplName() != null) {
            object = pSDBSPPartTemplBase.getPSDBSPPartTemplName();
            xmlNode.setAttribute(FIELD_PSDBSPPARTTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBSPPartTemplBase.getPSDBSysProcTemplId() != null) {
            object = pSDBSPPartTemplBase.getPSDBSysProcTemplId();
            xmlNode.setAttribute(FIELD_PSDBSYSPROCTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDBSPPartTemplBase.getPSDBSysProcTemplName() != null) {
            object = pSDBSPPartTemplBase.getPSDBSysProcTemplName();
            xmlNode.setAttribute(FIELD_PSDBSYSPROCTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBSPPartTemplBase.getTemplCode() != null) {
            object = pSDBSPPartTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDBSPPartTemplBase.getUpdateDate() != null) {
            object = pSDBSPPartTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBSPPartTemplBase.getUpdateMan() != null) {
            object = pSDBSPPartTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDBSPPartTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDBSPPartTemplBase pSDBSPPartTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDBSPPartTemplBase.isCreateDateDirty() && (bl || pSDBSPPartTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDBSPPartTemplBase.getCreateDate());
        }
        if (pSDBSPPartTemplBase.isCreateManDirty() && (bl || pSDBSPPartTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDBSPPartTemplBase.getCreateMan());
        }
        if (pSDBSPPartTemplBase.isMemoDirty() && (bl || pSDBSPPartTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDBSPPartTemplBase.getMemo());
        }
        if (pSDBSPPartTemplBase.isPSDBSPPartTemplIdDirty() && (bl || pSDBSPPartTemplBase.getPSDBSPPartTemplId() != null)) {
            iDataObject.set(FIELD_PSDBSPPARTTEMPLID, (Object)pSDBSPPartTemplBase.getPSDBSPPartTemplId());
        }
        if (pSDBSPPartTemplBase.isPSDBSPPartTemplNameDirty() && (bl || pSDBSPPartTemplBase.getPSDBSPPartTemplName() != null)) {
            iDataObject.set(FIELD_PSDBSPPARTTEMPLNAME, (Object)pSDBSPPartTemplBase.getPSDBSPPartTemplName());
        }
        if (pSDBSPPartTemplBase.isPSDBSysProcTemplIdDirty() && (bl || pSDBSPPartTemplBase.getPSDBSysProcTemplId() != null)) {
            iDataObject.set(FIELD_PSDBSYSPROCTEMPLID, (Object)pSDBSPPartTemplBase.getPSDBSysProcTemplId());
        }
        if (pSDBSPPartTemplBase.isPSDBSysProcTemplNameDirty() && (bl || pSDBSPPartTemplBase.getPSDBSysProcTemplName() != null)) {
            iDataObject.set(FIELD_PSDBSYSPROCTEMPLNAME, (Object)pSDBSPPartTemplBase.getPSDBSysProcTemplName());
        }
        if (pSDBSPPartTemplBase.isTemplCodeDirty() && (bl || pSDBSPPartTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSDBSPPartTemplBase.getTemplCode());
        }
        if (pSDBSPPartTemplBase.isUpdateDateDirty() && (bl || pSDBSPPartTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDBSPPartTemplBase.getUpdateDate());
        }
        if (pSDBSPPartTemplBase.isUpdateManDirty() && (bl || pSDBSPPartTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDBSPPartTemplBase.getUpdateMan());
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
        return PSDBSPPartTemplBase.remove(this, n);
    }

    private static boolean remove(PSDBSPPartTemplBase pSDBSPPartTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDBSPPartTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDBSPPartTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDBSPPartTemplBase.resetMemo();
                return true;
            }
            case 3: {
                pSDBSPPartTemplBase.resetPSDBSPPartTemplId();
                return true;
            }
            case 4: {
                pSDBSPPartTemplBase.resetPSDBSPPartTemplName();
                return true;
            }
            case 5: {
                pSDBSPPartTemplBase.resetPSDBSysProcTemplId();
                return true;
            }
            case 6: {
                pSDBSPPartTemplBase.resetPSDBSysProcTemplName();
                return true;
            }
            case 7: {
                pSDBSPPartTemplBase.resetTemplCode();
                return true;
            }
            case 8: {
                pSDBSPPartTemplBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDBSPPartTemplBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBSysProcTempl getPSDBSysProcTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBSysProcTempl();
        }
        if (this.getPSDBSysProcTemplId() == null) {
            return null;
        }
        Integer n = this.objPSDBSysProcTemplLock;
        synchronized (n) {
            if (this.psdbsysproctempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBSysProcTemplId(), (Object)this.psdbsysproctempl.getPSDBSysProcTemplId()) != 0L) {
                this.psdbsysproctempl = null;
            }
            if (this.psdbsysproctempl == null) {
                PSDBSysProcTempl pSDBSysProcTempl = new PSDBSysProcTempl();
                pSDBSysProcTempl.setPSDBSysProcTemplId(this.getPSDBSysProcTemplId());
                PSDBSysProcTemplService pSDBSysProcTemplService = (PSDBSysProcTemplService)ServiceGlobal.getService(PSDBSysProcTemplService.class, (SessionFactory)this.getSessionFactory());
                pSDBSysProcTemplService.autoGet((IEntity)pSDBSysProcTempl);
                this.psdbsysproctempl = pSDBSysProcTempl;
            }
            return this.psdbsysproctempl;
        }
    }

    private PSDBSPPartTemplBase getProxyEntity() {
        return this.proxyPSDBSPPartTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDBSPPartTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSDBSPPartTemplBase) {
            this.proxyPSDBSPPartTemplBase = (PSDBSPPartTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSDBSPPartTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDBSPPARTTEMPLID, 3);
        fieldIndexMap.put(FIELD_PSDBSPPARTTEMPLNAME, 4);
        fieldIndexMap.put(FIELD_PSDBSYSPROCTEMPLID, 5);
        fieldIndexMap.put(FIELD_PSDBSYSPROCTEMPLNAME, 6);
        fieldIndexMap.put(FIELD_TEMPLCODE, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

