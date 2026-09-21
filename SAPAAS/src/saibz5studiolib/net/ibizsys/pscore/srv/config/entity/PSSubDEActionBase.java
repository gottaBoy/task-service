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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSubDE;
import net.ibizsys.pscore.srv.config.service.PSSubDEService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubDEActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubDEActionBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSSUBDEACTIONID = "PSSUBDEACTIONID";
    public static final String FIELD_PSSUBDEACTIONNAME = "PSSUBDEACTIONNAME";
    public static final String FIELD_PSSUBDEID = "PSSUBDEID";
    public static final String FIELD_PSSUBDENAME = "PSSUBDENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_LOGICNAME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEACTIONID = 5;
    private static final int INDEX_PSSUBDEACTIONID = 6;
    private static final int INDEX_PSSUBDEACTIONNAME = 7;
    private static final int INDEX_PSSUBDEID = 8;
    private static final int INDEX_PSSUBDENAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubDEActionBase proxyPSSubDEActionBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean pssubdeactionidDirtyFlag = false;
    private boolean pssubdeactionnameDirtyFlag = false;
    private boolean pssubdeidDirtyFlag = false;
    private boolean pssubdenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="pssubdeactionid")
    private String pssubdeactionid;
    @Column(name="pssubdeactionname")
    private String pssubdeactionname;
    @Column(name="pssubdeid")
    private String pssubdeid;
    @Column(name="pssubdename")
    private String pssubdename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSubDELock = new Integer(1);
    private PSSubDE pssubde = null;

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

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionid = string;
        this.psdeactionidDirtyFlag = true;
    }

    public String getPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionId();
        }
        return this.psdeactionid;
    }

    public boolean isPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionIdDirty();
        }
        return this.psdeactionidDirtyFlag;
    }

    public void resetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionId();
            return;
        }
        this.psdeactionidDirtyFlag = false;
        this.psdeactionid = null;
    }

    public void setPSSubDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubdeactionid = string;
        this.pssubdeactionidDirtyFlag = true;
    }

    public String getPSSubDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubDEActionId();
        }
        return this.pssubdeactionid;
    }

    public boolean isPSSubDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubDEActionIdDirty();
        }
        return this.pssubdeactionidDirtyFlag;
    }

    public void resetPSSubDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubDEActionId();
            return;
        }
        this.pssubdeactionidDirtyFlag = false;
        this.pssubdeactionid = null;
    }

    public void setPSSubDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubdeactionname = string;
        this.pssubdeactionnameDirtyFlag = true;
    }

    public String getPSSubDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubDEActionName();
        }
        return this.pssubdeactionname;
    }

    public boolean isPSSubDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubDEActionNameDirty();
        }
        return this.pssubdeactionnameDirtyFlag;
    }

    public void resetPSSubDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubDEActionName();
            return;
        }
        this.pssubdeactionnameDirtyFlag = false;
        this.pssubdeactionname = null;
    }

    public void setPSSubDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubdeid = string;
        this.pssubdeidDirtyFlag = true;
    }

    public String getPSSubDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubDEId();
        }
        return this.pssubdeid;
    }

    public boolean isPSSubDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubDEIdDirty();
        }
        return this.pssubdeidDirtyFlag;
    }

    public void resetPSSubDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubDEId();
            return;
        }
        this.pssubdeidDirtyFlag = false;
        this.pssubdeid = null;
    }

    public void setPSSubDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubdename = string;
        this.pssubdenameDirtyFlag = true;
    }

    public String getPSSubDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubDEName();
        }
        return this.pssubdename;
    }

    public boolean isPSSubDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubDENameDirty();
        }
        return this.pssubdenameDirtyFlag;
    }

    public void resetPSSubDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubDEName();
            return;
        }
        this.pssubdenameDirtyFlag = false;
        this.pssubdename = null;
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
        PSSubDEActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubDEActionBase pSSubDEActionBase) {
        pSSubDEActionBase.resetCodeName();
        pSSubDEActionBase.resetCreateDate();
        pSSubDEActionBase.resetCreateMan();
        pSSubDEActionBase.resetLogicName();
        pSSubDEActionBase.resetMemo();
        pSSubDEActionBase.resetPSDEActionId();
        pSSubDEActionBase.resetPSSubDEActionId();
        pSSubDEActionBase.resetPSSubDEActionName();
        pSSubDEActionBase.resetPSSubDEId();
        pSSubDEActionBase.resetPSSubDEName();
        pSSubDEActionBase.resetUpdateDate();
        pSSubDEActionBase.resetUpdateMan();
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
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSSubDEActionIdDirty()) {
            hashMap.put(FIELD_PSSUBDEACTIONID, this.getPSSubDEActionId());
        }
        if (!bl || this.isPSSubDEActionNameDirty()) {
            hashMap.put(FIELD_PSSUBDEACTIONNAME, this.getPSSubDEActionName());
        }
        if (!bl || this.isPSSubDEIdDirty()) {
            hashMap.put(FIELD_PSSUBDEID, this.getPSSubDEId());
        }
        if (!bl || this.isPSSubDENameDirty()) {
            hashMap.put(FIELD_PSSUBDENAME, this.getPSSubDEName());
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
        return PSSubDEActionBase.get(this, n);
    }

    private static Object get(PSSubDEActionBase pSSubDEActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubDEActionBase.getCodeName();
            }
            case 1: {
                return pSSubDEActionBase.getCreateDate();
            }
            case 2: {
                return pSSubDEActionBase.getCreateMan();
            }
            case 3: {
                return pSSubDEActionBase.getLogicName();
            }
            case 4: {
                return pSSubDEActionBase.getMemo();
            }
            case 5: {
                return pSSubDEActionBase.getPSDEActionId();
            }
            case 6: {
                return pSSubDEActionBase.getPSSubDEActionId();
            }
            case 7: {
                return pSSubDEActionBase.getPSSubDEActionName();
            }
            case 8: {
                return pSSubDEActionBase.getPSSubDEId();
            }
            case 9: {
                return pSSubDEActionBase.getPSSubDEName();
            }
            case 10: {
                return pSSubDEActionBase.getUpdateDate();
            }
            case 11: {
                return pSSubDEActionBase.getUpdateMan();
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
        PSSubDEActionBase.set(this, n, object);
    }

    private static void set(PSSubDEActionBase pSSubDEActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubDEActionBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSubDEActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSubDEActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSubDEActionBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSubDEActionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSubDEActionBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSubDEActionBase.setPSSubDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSubDEActionBase.setPSSubDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubDEActionBase.setPSSubDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubDEActionBase.setPSSubDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubDEActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSubDEActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSubDEActionBase.isNull(this, n);
    }

    private static boolean isNull(PSSubDEActionBase pSSubDEActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubDEActionBase.getCodeName() == null;
            }
            case 1: {
                return pSSubDEActionBase.getCreateDate() == null;
            }
            case 2: {
                return pSSubDEActionBase.getCreateMan() == null;
            }
            case 3: {
                return pSSubDEActionBase.getLogicName() == null;
            }
            case 4: {
                return pSSubDEActionBase.getMemo() == null;
            }
            case 5: {
                return pSSubDEActionBase.getPSDEActionId() == null;
            }
            case 6: {
                return pSSubDEActionBase.getPSSubDEActionId() == null;
            }
            case 7: {
                return pSSubDEActionBase.getPSSubDEActionName() == null;
            }
            case 8: {
                return pSSubDEActionBase.getPSSubDEId() == null;
            }
            case 9: {
                return pSSubDEActionBase.getPSSubDEName() == null;
            }
            case 10: {
                return pSSubDEActionBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSubDEActionBase.getUpdateMan() == null;
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
        return PSSubDEActionBase.contains(this, n);
    }

    private static boolean contains(PSSubDEActionBase pSSubDEActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubDEActionBase.isCodeNameDirty();
            }
            case 1: {
                return pSSubDEActionBase.isCreateDateDirty();
            }
            case 2: {
                return pSSubDEActionBase.isCreateManDirty();
            }
            case 3: {
                return pSSubDEActionBase.isLogicNameDirty();
            }
            case 4: {
                return pSSubDEActionBase.isMemoDirty();
            }
            case 5: {
                return pSSubDEActionBase.isPSDEActionIdDirty();
            }
            case 6: {
                return pSSubDEActionBase.isPSSubDEActionIdDirty();
            }
            case 7: {
                return pSSubDEActionBase.isPSSubDEActionNameDirty();
            }
            case 8: {
                return pSSubDEActionBase.isPSSubDEIdDirty();
            }
            case 9: {
                return pSSubDEActionBase.isPSSubDENameDirty();
            }
            case 10: {
                return pSSubDEActionBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSubDEActionBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubDEActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubDEActionBase pSSubDEActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubDEActionBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSubDEActionBase.getJSONValue((Object)pSSubDEActionBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSubDEActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubDEActionBase.getJSONValue((Object)pSSubDEActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubDEActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubDEActionBase.getJSONValue((Object)pSSubDEActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubDEActionBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSubDEActionBase.getJSONValue((Object)pSSubDEActionBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSubDEActionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubDEActionBase.getJSONValue((Object)pSSubDEActionBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubDEActionBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSSubDEActionBase.getJSONValue((Object)pSSubDEActionBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSSubDEActionBase.getPSSubDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubdeactionid", (Object)PSSubDEActionBase.getJSONValue((Object)pSSubDEActionBase.getPSSubDEActionId()), (boolean)false);
        }
        if (bl || pSSubDEActionBase.getPSSubDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubdeactionname", (Object)PSSubDEActionBase.getJSONValue((Object)pSSubDEActionBase.getPSSubDEActionName()), (boolean)false);
        }
        if (bl || pSSubDEActionBase.getPSSubDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubdeid", (Object)PSSubDEActionBase.getJSONValue((Object)pSSubDEActionBase.getPSSubDEId()), (boolean)false);
        }
        if (bl || pSSubDEActionBase.getPSSubDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubdename", (Object)PSSubDEActionBase.getJSONValue((Object)pSSubDEActionBase.getPSSubDEName()), (boolean)false);
        }
        if (bl || pSSubDEActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubDEActionBase.getJSONValue((Object)pSSubDEActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubDEActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubDEActionBase.getJSONValue((Object)pSSubDEActionBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubDEActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubDEActionBase pSSubDEActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubDEActionBase.getCodeName() != null) {
            object = pSSubDEActionBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEActionBase.getCreateDate() != null) {
            object = pSSubDEActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubDEActionBase.getCreateMan() != null) {
            object = pSSubDEActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEActionBase.getLogicName() != null) {
            object = pSSubDEActionBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEActionBase.getMemo() != null) {
            object = pSSubDEActionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEActionBase.getPSDEActionId() != null) {
            object = pSSubDEActionBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEActionBase.getPSSubDEActionId() != null) {
            object = pSSubDEActionBase.getPSSubDEActionId();
            xmlNode.setAttribute(FIELD_PSSUBDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEActionBase.getPSSubDEActionName() != null) {
            object = pSSubDEActionBase.getPSSubDEActionName();
            xmlNode.setAttribute(FIELD_PSSUBDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEActionBase.getPSSubDEId() != null) {
            object = pSSubDEActionBase.getPSSubDEId();
            xmlNode.setAttribute(FIELD_PSSUBDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEActionBase.getPSSubDEName() != null) {
            object = pSSubDEActionBase.getPSSubDEName();
            xmlNode.setAttribute(FIELD_PSSUBDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEActionBase.getUpdateDate() != null) {
            object = pSSubDEActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubDEActionBase.getUpdateMan() != null) {
            object = pSSubDEActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubDEActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubDEActionBase pSSubDEActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubDEActionBase.isCodeNameDirty() && (bl || pSSubDEActionBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSubDEActionBase.getCodeName());
        }
        if (pSSubDEActionBase.isCreateDateDirty() && (bl || pSSubDEActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubDEActionBase.getCreateDate());
        }
        if (pSSubDEActionBase.isCreateManDirty() && (bl || pSSubDEActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubDEActionBase.getCreateMan());
        }
        if (pSSubDEActionBase.isLogicNameDirty() && (bl || pSSubDEActionBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSubDEActionBase.getLogicName());
        }
        if (pSSubDEActionBase.isMemoDirty() && (bl || pSSubDEActionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubDEActionBase.getMemo());
        }
        if (pSSubDEActionBase.isPSDEActionIdDirty() && (bl || pSSubDEActionBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSSubDEActionBase.getPSDEActionId());
        }
        if (pSSubDEActionBase.isPSSubDEActionIdDirty() && (bl || pSSubDEActionBase.getPSSubDEActionId() != null)) {
            iDataObject.set(FIELD_PSSUBDEACTIONID, (Object)pSSubDEActionBase.getPSSubDEActionId());
        }
        if (pSSubDEActionBase.isPSSubDEActionNameDirty() && (bl || pSSubDEActionBase.getPSSubDEActionName() != null)) {
            iDataObject.set(FIELD_PSSUBDEACTIONNAME, (Object)pSSubDEActionBase.getPSSubDEActionName());
        }
        if (pSSubDEActionBase.isPSSubDEIdDirty() && (bl || pSSubDEActionBase.getPSSubDEId() != null)) {
            iDataObject.set(FIELD_PSSUBDEID, (Object)pSSubDEActionBase.getPSSubDEId());
        }
        if (pSSubDEActionBase.isPSSubDENameDirty() && (bl || pSSubDEActionBase.getPSSubDEName() != null)) {
            iDataObject.set(FIELD_PSSUBDENAME, (Object)pSSubDEActionBase.getPSSubDEName());
        }
        if (pSSubDEActionBase.isUpdateDateDirty() && (bl || pSSubDEActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubDEActionBase.getUpdateDate());
        }
        if (pSSubDEActionBase.isUpdateManDirty() && (bl || pSSubDEActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubDEActionBase.getUpdateMan());
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
        return PSSubDEActionBase.remove(this, n);
    }

    private static boolean remove(PSSubDEActionBase pSSubDEActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubDEActionBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSubDEActionBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSubDEActionBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSubDEActionBase.resetLogicName();
                return true;
            }
            case 4: {
                pSSubDEActionBase.resetMemo();
                return true;
            }
            case 5: {
                pSSubDEActionBase.resetPSDEActionId();
                return true;
            }
            case 6: {
                pSSubDEActionBase.resetPSSubDEActionId();
                return true;
            }
            case 7: {
                pSSubDEActionBase.resetPSSubDEActionName();
                return true;
            }
            case 8: {
                pSSubDEActionBase.resetPSSubDEId();
                return true;
            }
            case 9: {
                pSSubDEActionBase.resetPSSubDEName();
                return true;
            }
            case 10: {
                pSSubDEActionBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSubDEActionBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubDE getPSSubDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubDE();
        }
        if (this.getPSSubDEId() == null) {
            return null;
        }
        Integer n = this.objPSSubDELock;
        synchronized (n) {
            if (this.pssubde != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubDEId(), (Object)this.pssubde.getPSSubDEId()) != 0L) {
                this.pssubde = null;
            }
            if (this.pssubde == null) {
                PSSubDE pSSubDE = new PSSubDE();
                pSSubDE.setPSSubDEId(this.getPSSubDEId());
                PSSubDEService pSSubDEService = (PSSubDEService)ServiceGlobal.getService(PSSubDEService.class, (SessionFactory)this.getSessionFactory());
                pSSubDEService.autoGet((IEntity)pSSubDE);
                this.pssubde = pSSubDE;
            }
            return this.pssubde;
        }
    }

    private PSSubDEActionBase getProxyEntity() {
        return this.proxyPSSubDEActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubDEActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubDEActionBase) {
            this.proxyPSSubDEActionBase = (PSSubDEActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubDEActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOGICNAME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 5);
        fieldIndexMap.put(FIELD_PSSUBDEACTIONID, 6);
        fieldIndexMap.put(FIELD_PSSUBDEACTIONNAME, 7);
        fieldIndexMap.put(FIELD_PSSUBDEID, 8);
        fieldIndexMap.put(FIELD_PSSUBDENAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

