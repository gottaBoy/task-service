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

public abstract class PSDBSysProcTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDBSysProcTypeBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDBSYSPROCTYPEID = "PSDBSYSPROCTYPEID";
    public static final String FIELD_PSDBSYSPROCTYPENAME = "PSDBSYSPROCTYPENAME";
    public static final String FIELD_RETURNRESULT = "RETURNRESULT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ICONPATH = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDBSYSPROCTYPEID = 5;
    private static final int INDEX_PSDBSYSPROCTYPENAME = 6;
    private static final int INDEX_RETURNRESULT = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDBSysProcTypeBase proxyPSDBSysProcTypeBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdbsysproctypeidDirtyFlag = false;
    private boolean psdbsysproctypenameDirtyFlag = false;
    private boolean returnresultDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="memo")
    private String memo;
    @Column(name="psdbsysproctypeid")
    private String psdbsysproctypeid;
    @Column(name="psdbsysproctypename")
    private String psdbsysproctypename;
    @Column(name="returnresult")
    private Integer returnresult;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
    }

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

    public void setPSDBSysProcTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBSysProcTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbsysproctypeid = string;
        this.psdbsysproctypeidDirtyFlag = true;
    }

    public String getPSDBSysProcTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBSysProcTypeId();
        }
        return this.psdbsysproctypeid;
    }

    public boolean isPSDBSysProcTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBSysProcTypeIdDirty();
        }
        return this.psdbsysproctypeidDirtyFlag;
    }

    public void resetPSDBSysProcTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBSysProcTypeId();
            return;
        }
        this.psdbsysproctypeidDirtyFlag = false;
        this.psdbsysproctypeid = null;
    }

    public void setPSDBSysProcTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBSysProcTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbsysproctypename = string;
        this.psdbsysproctypenameDirtyFlag = true;
    }

    public String getPSDBSysProcTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBSysProcTypeName();
        }
        return this.psdbsysproctypename;
    }

    public boolean isPSDBSysProcTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBSysProcTypeNameDirty();
        }
        return this.psdbsysproctypenameDirtyFlag;
    }

    public void resetPSDBSysProcTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBSysProcTypeName();
            return;
        }
        this.psdbsysproctypenameDirtyFlag = false;
        this.psdbsysproctypename = null;
    }

    public void setRETURNResult(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRETURNResult(n);
            return;
        }
        this.returnresult = n;
        this.returnresultDirtyFlag = true;
    }

    public Integer getRETURNResult() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRETURNResult();
        }
        return this.returnresult;
    }

    public boolean isRETURNResultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRETURNResultDirty();
        }
        return this.returnresultDirtyFlag;
    }

    public void resetRETURNResult() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRETURNResult();
            return;
        }
        this.returnresultDirtyFlag = false;
        this.returnresult = null;
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
        PSDBSysProcTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDBSysProcTypeBase pSDBSysProcTypeBase) {
        pSDBSysProcTypeBase.resetCodeName();
        pSDBSysProcTypeBase.resetCreateDate();
        pSDBSysProcTypeBase.resetCreateMan();
        pSDBSysProcTypeBase.resetIconPath();
        pSDBSysProcTypeBase.resetMemo();
        pSDBSysProcTypeBase.resetPSDBSysProcTypeId();
        pSDBSysProcTypeBase.resetPSDBSysProcTypeName();
        pSDBSysProcTypeBase.resetRETURNResult();
        pSDBSysProcTypeBase.resetUpdateDate();
        pSDBSysProcTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
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
        if (!bl || this.isPSDBSysProcTypeIdDirty()) {
            hashMap.put(FIELD_PSDBSYSPROCTYPEID, this.getPSDBSysProcTypeId());
        }
        if (!bl || this.isPSDBSysProcTypeNameDirty()) {
            hashMap.put(FIELD_PSDBSYSPROCTYPENAME, this.getPSDBSysProcTypeName());
        }
        if (!bl || this.isRETURNResultDirty()) {
            hashMap.put(FIELD_RETURNRESULT, this.getRETURNResult());
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
        return PSDBSysProcTypeBase.get(this, n);
    }

    private static Object get(PSDBSysProcTypeBase pSDBSysProcTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBSysProcTypeBase.getCodeName();
            }
            case 1: {
                return pSDBSysProcTypeBase.getCreateDate();
            }
            case 2: {
                return pSDBSysProcTypeBase.getCreateMan();
            }
            case 3: {
                return pSDBSysProcTypeBase.getIconPath();
            }
            case 4: {
                return pSDBSysProcTypeBase.getMemo();
            }
            case 5: {
                return pSDBSysProcTypeBase.getPSDBSysProcTypeId();
            }
            case 6: {
                return pSDBSysProcTypeBase.getPSDBSysProcTypeName();
            }
            case 7: {
                return pSDBSysProcTypeBase.getRETURNResult();
            }
            case 8: {
                return pSDBSysProcTypeBase.getUpdateDate();
            }
            case 9: {
                return pSDBSysProcTypeBase.getUpdateMan();
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
        PSDBSysProcTypeBase.set(this, n, object);
    }

    private static void set(PSDBSysProcTypeBase pSDBSysProcTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDBSysProcTypeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDBSysProcTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDBSysProcTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDBSysProcTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDBSysProcTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDBSysProcTypeBase.setPSDBSysProcTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDBSysProcTypeBase.setPSDBSysProcTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDBSysProcTypeBase.setRETURNResult(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDBSysProcTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDBSysProcTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDBSysProcTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDBSysProcTypeBase pSDBSysProcTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBSysProcTypeBase.getCodeName() == null;
            }
            case 1: {
                return pSDBSysProcTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSDBSysProcTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSDBSysProcTypeBase.getIconPath() == null;
            }
            case 4: {
                return pSDBSysProcTypeBase.getMemo() == null;
            }
            case 5: {
                return pSDBSysProcTypeBase.getPSDBSysProcTypeId() == null;
            }
            case 6: {
                return pSDBSysProcTypeBase.getPSDBSysProcTypeName() == null;
            }
            case 7: {
                return pSDBSysProcTypeBase.getRETURNResult() == null;
            }
            case 8: {
                return pSDBSysProcTypeBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDBSysProcTypeBase.getUpdateMan() == null;
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
        return PSDBSysProcTypeBase.contains(this, n);
    }

    private static boolean contains(PSDBSysProcTypeBase pSDBSysProcTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBSysProcTypeBase.isCodeNameDirty();
            }
            case 1: {
                return pSDBSysProcTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSDBSysProcTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSDBSysProcTypeBase.isIconPathDirty();
            }
            case 4: {
                return pSDBSysProcTypeBase.isMemoDirty();
            }
            case 5: {
                return pSDBSysProcTypeBase.isPSDBSysProcTypeIdDirty();
            }
            case 6: {
                return pSDBSysProcTypeBase.isPSDBSysProcTypeNameDirty();
            }
            case 7: {
                return pSDBSysProcTypeBase.isRETURNResultDirty();
            }
            case 8: {
                return pSDBSysProcTypeBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDBSysProcTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDBSysProcTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDBSysProcTypeBase pSDBSysProcTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDBSysProcTypeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDBSysProcTypeBase.getJSONValue((Object)pSDBSysProcTypeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDBSysProcTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDBSysProcTypeBase.getJSONValue((Object)pSDBSysProcTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDBSysProcTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDBSysProcTypeBase.getJSONValue((Object)pSDBSysProcTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDBSysProcTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSDBSysProcTypeBase.getJSONValue((Object)pSDBSysProcTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSDBSysProcTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDBSysProcTypeBase.getJSONValue((Object)pSDBSysProcTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDBSysProcTypeBase.getPSDBSysProcTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbsysproctypeid", (Object)PSDBSysProcTypeBase.getJSONValue((Object)pSDBSysProcTypeBase.getPSDBSysProcTypeId()), (boolean)false);
        }
        if (bl || pSDBSysProcTypeBase.getPSDBSysProcTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbsysproctypename", (Object)PSDBSysProcTypeBase.getJSONValue((Object)pSDBSysProcTypeBase.getPSDBSysProcTypeName()), (boolean)false);
        }
        if (bl || pSDBSysProcTypeBase.getRETURNResult() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"returnresult", (Object)PSDBSysProcTypeBase.getJSONValue((Object)pSDBSysProcTypeBase.getRETURNResult()), (boolean)false);
        }
        if (bl || pSDBSysProcTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDBSysProcTypeBase.getJSONValue((Object)pSDBSysProcTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDBSysProcTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDBSysProcTypeBase.getJSONValue((Object)pSDBSysProcTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDBSysProcTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDBSysProcTypeBase pSDBSysProcTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDBSysProcTypeBase.getCodeName() != null) {
            object = pSDBSysProcTypeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTypeBase.getCreateDate() != null) {
            object = pSDBSysProcTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBSysProcTypeBase.getCreateMan() != null) {
            object = pSDBSysProcTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTypeBase.getIconPath() != null) {
            object = pSDBSysProcTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTypeBase.getMemo() != null) {
            object = pSDBSysProcTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTypeBase.getPSDBSysProcTypeId() != null) {
            object = pSDBSysProcTypeBase.getPSDBSysProcTypeId();
            xmlNode.setAttribute(FIELD_PSDBSYSPROCTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTypeBase.getPSDBSysProcTypeName() != null) {
            object = pSDBSysProcTypeBase.getPSDBSysProcTypeName();
            xmlNode.setAttribute(FIELD_PSDBSYSPROCTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBSysProcTypeBase.getRETURNResult() != null) {
            object = pSDBSysProcTypeBase.getRETURNResult();
            xmlNode.setAttribute(FIELD_RETURNRESULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBSysProcTypeBase.getUpdateDate() != null) {
            object = pSDBSysProcTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBSysProcTypeBase.getUpdateMan() != null) {
            object = pSDBSysProcTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDBSysProcTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDBSysProcTypeBase pSDBSysProcTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDBSysProcTypeBase.isCodeNameDirty() && (bl || pSDBSysProcTypeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDBSysProcTypeBase.getCodeName());
        }
        if (pSDBSysProcTypeBase.isCreateDateDirty() && (bl || pSDBSysProcTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDBSysProcTypeBase.getCreateDate());
        }
        if (pSDBSysProcTypeBase.isCreateManDirty() && (bl || pSDBSysProcTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDBSysProcTypeBase.getCreateMan());
        }
        if (pSDBSysProcTypeBase.isIconPathDirty() && (bl || pSDBSysProcTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSDBSysProcTypeBase.getIconPath());
        }
        if (pSDBSysProcTypeBase.isMemoDirty() && (bl || pSDBSysProcTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDBSysProcTypeBase.getMemo());
        }
        if (pSDBSysProcTypeBase.isPSDBSysProcTypeIdDirty() && (bl || pSDBSysProcTypeBase.getPSDBSysProcTypeId() != null)) {
            iDataObject.set(FIELD_PSDBSYSPROCTYPEID, (Object)pSDBSysProcTypeBase.getPSDBSysProcTypeId());
        }
        if (pSDBSysProcTypeBase.isPSDBSysProcTypeNameDirty() && (bl || pSDBSysProcTypeBase.getPSDBSysProcTypeName() != null)) {
            iDataObject.set(FIELD_PSDBSYSPROCTYPENAME, (Object)pSDBSysProcTypeBase.getPSDBSysProcTypeName());
        }
        if (pSDBSysProcTypeBase.isRETURNResultDirty() && (bl || pSDBSysProcTypeBase.getRETURNResult() != null)) {
            iDataObject.set(FIELD_RETURNRESULT, (Object)pSDBSysProcTypeBase.getRETURNResult());
        }
        if (pSDBSysProcTypeBase.isUpdateDateDirty() && (bl || pSDBSysProcTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDBSysProcTypeBase.getUpdateDate());
        }
        if (pSDBSysProcTypeBase.isUpdateManDirty() && (bl || pSDBSysProcTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDBSysProcTypeBase.getUpdateMan());
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
        return PSDBSysProcTypeBase.remove(this, n);
    }

    private static boolean remove(PSDBSysProcTypeBase pSDBSysProcTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDBSysProcTypeBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDBSysProcTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDBSysProcTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDBSysProcTypeBase.resetIconPath();
                return true;
            }
            case 4: {
                pSDBSysProcTypeBase.resetMemo();
                return true;
            }
            case 5: {
                pSDBSysProcTypeBase.resetPSDBSysProcTypeId();
                return true;
            }
            case 6: {
                pSDBSysProcTypeBase.resetPSDBSysProcTypeName();
                return true;
            }
            case 7: {
                pSDBSysProcTypeBase.resetRETURNResult();
                return true;
            }
            case 8: {
                pSDBSysProcTypeBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDBSysProcTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDBSysProcTypeBase getProxyEntity() {
        return this.proxyPSDBSysProcTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDBSysProcTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDBSysProcTypeBase) {
            this.proxyPSDBSysProcTypeBase = (PSDBSysProcTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSDBSysProcTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ICONPATH, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDBSYSPROCTYPEID, 5);
        fieldIndexMap.put(FIELD_PSDBSYSPROCTYPENAME, 6);
        fieldIndexMap.put(FIELD_RETURNRESULT, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

