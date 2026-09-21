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
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.service.PSSubDEService;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubDEViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubDEViewBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSSUBDEID = "PSSUBDEID";
    public static final String FIELD_PSSUBDENAME = "PSSUBDENAME";
    public static final String FIELD_PSSUBDEVIEWID = "PSSUBDEVIEWID";
    public static final String FIELD_PSSUBDEVIEWNAME = "PSSUBDEVIEWNAME";
    public static final String FIELD_PSSUBSYSID = "PSSUBSYSID";
    public static final String FIELD_PSSUBSYSNAME = "PSSUBSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VIEWTYPE = "VIEWTYPE";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEVIEWBASEID = 4;
    private static final int INDEX_PSSUBDEID = 5;
    private static final int INDEX_PSSUBDENAME = 6;
    private static final int INDEX_PSSUBDEVIEWID = 7;
    private static final int INDEX_PSSUBDEVIEWNAME = 8;
    private static final int INDEX_PSSUBSYSID = 9;
    private static final int INDEX_PSSUBSYSNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VIEWTYPE = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubDEViewBase proxyPSSubDEViewBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean pssubdeidDirtyFlag = false;
    private boolean pssubdenameDirtyFlag = false;
    private boolean pssubdeviewidDirtyFlag = false;
    private boolean pssubdeviewnameDirtyFlag = false;
    private boolean pssubsysidDirtyFlag = false;
    private boolean pssubsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean viewtypeDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="pssubdeid")
    private String pssubdeid;
    @Column(name="pssubdename")
    private String pssubdename;
    @Column(name="pssubdeviewid")
    private String pssubdeviewid;
    @Column(name="pssubdeviewname")
    private String pssubdeviewname;
    @Column(name="pssubsysid")
    private String pssubsysid;
    @Column(name="pssubsysname")
    private String pssubsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="viewtype")
    private String viewtype;
    private Integer objPSSubDELock = new Integer(1);
    private PSSubDE pssubde = null;
    private Integer objPSSubSysLock = new Integer(1);
    private PSSubSys pssubsys = null;

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

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
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

    public void setPSSubDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubdeviewid = string;
        this.pssubdeviewidDirtyFlag = true;
    }

    public String getPSSubDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubDEViewId();
        }
        return this.pssubdeviewid;
    }

    public boolean isPSSubDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubDEViewIdDirty();
        }
        return this.pssubdeviewidDirtyFlag;
    }

    public void resetPSSubDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubDEViewId();
            return;
        }
        this.pssubdeviewidDirtyFlag = false;
        this.pssubdeviewid = null;
    }

    public void setPSSubDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubdeviewname = string;
        this.pssubdeviewnameDirtyFlag = true;
    }

    public String getPSSubDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubDEViewName();
        }
        return this.pssubdeviewname;
    }

    public boolean isPSSubDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubDEViewNameDirty();
        }
        return this.pssubdeviewnameDirtyFlag;
    }

    public void resetPSSubDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubDEViewName();
            return;
        }
        this.pssubdeviewnameDirtyFlag = false;
        this.pssubdeviewname = null;
    }

    public void setPSSubSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysid = string;
        this.pssubsysidDirtyFlag = true;
    }

    public String getPSSubSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysId();
        }
        return this.pssubsysid;
    }

    public boolean isPSSubSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysIdDirty();
        }
        return this.pssubsysidDirtyFlag;
    }

    public void resetPSSubSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysId();
            return;
        }
        this.pssubsysidDirtyFlag = false;
        this.pssubsysid = null;
    }

    public void setPSSubSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysname = string;
        this.pssubsysnameDirtyFlag = true;
    }

    public String getPSSubSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysName();
        }
        return this.pssubsysname;
    }

    public boolean isPSSubSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysNameDirty();
        }
        return this.pssubsysnameDirtyFlag;
    }

    public void resetPSSubSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysName();
            return;
        }
        this.pssubsysnameDirtyFlag = false;
        this.pssubsysname = null;
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

    public void setViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewtype = string;
        this.viewtypeDirtyFlag = true;
    }

    public String getViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewType();
        }
        return this.viewtype;
    }

    public boolean isViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewTypeDirty();
        }
        return this.viewtypeDirtyFlag;
    }

    public void resetViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewType();
            return;
        }
        this.viewtypeDirtyFlag = false;
        this.viewtype = null;
    }

    protected void onReset() {
        PSSubDEViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubDEViewBase pSSubDEViewBase) {
        pSSubDEViewBase.resetCodeName();
        pSSubDEViewBase.resetCreateDate();
        pSSubDEViewBase.resetCreateMan();
        pSSubDEViewBase.resetMemo();
        pSSubDEViewBase.resetPSDEViewBaseId();
        pSSubDEViewBase.resetPSSubDEId();
        pSSubDEViewBase.resetPSSubDEName();
        pSSubDEViewBase.resetPSSubDEViewId();
        pSSubDEViewBase.resetPSSubDEViewName();
        pSSubDEViewBase.resetPSSubSysId();
        pSSubDEViewBase.resetPSSubSysName();
        pSSubDEViewBase.resetUpdateDate();
        pSSubDEViewBase.resetUpdateMan();
        pSSubDEViewBase.resetViewType();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSSubDEIdDirty()) {
            hashMap.put(FIELD_PSSUBDEID, this.getPSSubDEId());
        }
        if (!bl || this.isPSSubDENameDirty()) {
            hashMap.put(FIELD_PSSUBDENAME, this.getPSSubDEName());
        }
        if (!bl || this.isPSSubDEViewIdDirty()) {
            hashMap.put(FIELD_PSSUBDEVIEWID, this.getPSSubDEViewId());
        }
        if (!bl || this.isPSSubDEViewNameDirty()) {
            hashMap.put(FIELD_PSSUBDEVIEWNAME, this.getPSSubDEViewName());
        }
        if (!bl || this.isPSSubSysIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSID, this.getPSSubSysId());
        }
        if (!bl || this.isPSSubSysNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSNAME, this.getPSSubSysName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isViewTypeDirty()) {
            hashMap.put(FIELD_VIEWTYPE, this.getViewType());
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
        return PSSubDEViewBase.get(this, n);
    }

    private static Object get(PSSubDEViewBase pSSubDEViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubDEViewBase.getCodeName();
            }
            case 1: {
                return pSSubDEViewBase.getCreateDate();
            }
            case 2: {
                return pSSubDEViewBase.getCreateMan();
            }
            case 3: {
                return pSSubDEViewBase.getMemo();
            }
            case 4: {
                return pSSubDEViewBase.getPSDEViewBaseId();
            }
            case 5: {
                return pSSubDEViewBase.getPSSubDEId();
            }
            case 6: {
                return pSSubDEViewBase.getPSSubDEName();
            }
            case 7: {
                return pSSubDEViewBase.getPSSubDEViewId();
            }
            case 8: {
                return pSSubDEViewBase.getPSSubDEViewName();
            }
            case 9: {
                return pSSubDEViewBase.getPSSubSysId();
            }
            case 10: {
                return pSSubDEViewBase.getPSSubSysName();
            }
            case 11: {
                return pSSubDEViewBase.getUpdateDate();
            }
            case 12: {
                return pSSubDEViewBase.getUpdateMan();
            }
            case 13: {
                return pSSubDEViewBase.getViewType();
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
        PSSubDEViewBase.set(this, n, object);
    }

    private static void set(PSSubDEViewBase pSSubDEViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubDEViewBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSubDEViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSubDEViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSubDEViewBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSubDEViewBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSubDEViewBase.setPSSubDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSubDEViewBase.setPSSubDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSubDEViewBase.setPSSubDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubDEViewBase.setPSSubDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubDEViewBase.setPSSubSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubDEViewBase.setPSSubSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSubDEViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSubDEViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSubDEViewBase.setViewType(DataObject.getStringValue((Object)object));
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
        return PSSubDEViewBase.isNull(this, n);
    }

    private static boolean isNull(PSSubDEViewBase pSSubDEViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubDEViewBase.getCodeName() == null;
            }
            case 1: {
                return pSSubDEViewBase.getCreateDate() == null;
            }
            case 2: {
                return pSSubDEViewBase.getCreateMan() == null;
            }
            case 3: {
                return pSSubDEViewBase.getMemo() == null;
            }
            case 4: {
                return pSSubDEViewBase.getPSDEViewBaseId() == null;
            }
            case 5: {
                return pSSubDEViewBase.getPSSubDEId() == null;
            }
            case 6: {
                return pSSubDEViewBase.getPSSubDEName() == null;
            }
            case 7: {
                return pSSubDEViewBase.getPSSubDEViewId() == null;
            }
            case 8: {
                return pSSubDEViewBase.getPSSubDEViewName() == null;
            }
            case 9: {
                return pSSubDEViewBase.getPSSubSysId() == null;
            }
            case 10: {
                return pSSubDEViewBase.getPSSubSysName() == null;
            }
            case 11: {
                return pSSubDEViewBase.getUpdateDate() == null;
            }
            case 12: {
                return pSSubDEViewBase.getUpdateMan() == null;
            }
            case 13: {
                return pSSubDEViewBase.getViewType() == null;
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
        return PSSubDEViewBase.contains(this, n);
    }

    private static boolean contains(PSSubDEViewBase pSSubDEViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubDEViewBase.isCodeNameDirty();
            }
            case 1: {
                return pSSubDEViewBase.isCreateDateDirty();
            }
            case 2: {
                return pSSubDEViewBase.isCreateManDirty();
            }
            case 3: {
                return pSSubDEViewBase.isMemoDirty();
            }
            case 4: {
                return pSSubDEViewBase.isPSDEViewBaseIdDirty();
            }
            case 5: {
                return pSSubDEViewBase.isPSSubDEIdDirty();
            }
            case 6: {
                return pSSubDEViewBase.isPSSubDENameDirty();
            }
            case 7: {
                return pSSubDEViewBase.isPSSubDEViewIdDirty();
            }
            case 8: {
                return pSSubDEViewBase.isPSSubDEViewNameDirty();
            }
            case 9: {
                return pSSubDEViewBase.isPSSubSysIdDirty();
            }
            case 10: {
                return pSSubDEViewBase.isPSSubSysNameDirty();
            }
            case 11: {
                return pSSubDEViewBase.isUpdateDateDirty();
            }
            case 12: {
                return pSSubDEViewBase.isUpdateManDirty();
            }
            case 13: {
                return pSSubDEViewBase.isViewTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubDEViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubDEViewBase pSSubDEViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubDEViewBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSubDEViewBase.getJSONValue((Object)pSSubDEViewBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSubDEViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubDEViewBase.getJSONValue((Object)pSSubDEViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubDEViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubDEViewBase.getJSONValue((Object)pSSubDEViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubDEViewBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubDEViewBase.getJSONValue((Object)pSSubDEViewBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubDEViewBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSSubDEViewBase.getJSONValue((Object)pSSubDEViewBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSSubDEViewBase.getPSSubDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubdeid", (Object)PSSubDEViewBase.getJSONValue((Object)pSSubDEViewBase.getPSSubDEId()), (boolean)false);
        }
        if (bl || pSSubDEViewBase.getPSSubDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubdename", (Object)PSSubDEViewBase.getJSONValue((Object)pSSubDEViewBase.getPSSubDEName()), (boolean)false);
        }
        if (bl || pSSubDEViewBase.getPSSubDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubdeviewid", (Object)PSSubDEViewBase.getJSONValue((Object)pSSubDEViewBase.getPSSubDEViewId()), (boolean)false);
        }
        if (bl || pSSubDEViewBase.getPSSubDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubdeviewname", (Object)PSSubDEViewBase.getJSONValue((Object)pSSubDEViewBase.getPSSubDEViewName()), (boolean)false);
        }
        if (bl || pSSubDEViewBase.getPSSubSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysid", (Object)PSSubDEViewBase.getJSONValue((Object)pSSubDEViewBase.getPSSubSysId()), (boolean)false);
        }
        if (bl || pSSubDEViewBase.getPSSubSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysname", (Object)PSSubDEViewBase.getJSONValue((Object)pSSubDEViewBase.getPSSubSysName()), (boolean)false);
        }
        if (bl || pSSubDEViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubDEViewBase.getJSONValue((Object)pSSubDEViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubDEViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubDEViewBase.getJSONValue((Object)pSSubDEViewBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSubDEViewBase.getViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewtype", (Object)PSSubDEViewBase.getJSONValue((Object)pSSubDEViewBase.getViewType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubDEViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubDEViewBase pSSubDEViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubDEViewBase.getCodeName() != null) {
            object = pSSubDEViewBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEViewBase.getCreateDate() != null) {
            object = pSSubDEViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubDEViewBase.getCreateMan() != null) {
            object = pSSubDEViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEViewBase.getMemo() != null) {
            object = pSSubDEViewBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEViewBase.getPSDEViewBaseId() != null) {
            object = pSSubDEViewBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEViewBase.getPSSubDEId() != null) {
            object = pSSubDEViewBase.getPSSubDEId();
            xmlNode.setAttribute(FIELD_PSSUBDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEViewBase.getPSSubDEName() != null) {
            object = pSSubDEViewBase.getPSSubDEName();
            xmlNode.setAttribute(FIELD_PSSUBDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEViewBase.getPSSubDEViewId() != null) {
            object = pSSubDEViewBase.getPSSubDEViewId();
            xmlNode.setAttribute(FIELD_PSSUBDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEViewBase.getPSSubDEViewName() != null) {
            object = pSSubDEViewBase.getPSSubDEViewName();
            xmlNode.setAttribute(FIELD_PSSUBDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEViewBase.getPSSubSysId() != null) {
            object = pSSubDEViewBase.getPSSubSysId();
            xmlNode.setAttribute(FIELD_PSSUBSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEViewBase.getPSSubSysName() != null) {
            object = pSSubDEViewBase.getPSSubSysName();
            xmlNode.setAttribute(FIELD_PSSUBSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEViewBase.getUpdateDate() != null) {
            object = pSSubDEViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubDEViewBase.getUpdateMan() != null) {
            object = pSSubDEViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubDEViewBase.getViewType() != null) {
            object = pSSubDEViewBase.getViewType();
            xmlNode.setAttribute(FIELD_VIEWTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubDEViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubDEViewBase pSSubDEViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubDEViewBase.isCodeNameDirty() && (bl || pSSubDEViewBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSubDEViewBase.getCodeName());
        }
        if (pSSubDEViewBase.isCreateDateDirty() && (bl || pSSubDEViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubDEViewBase.getCreateDate());
        }
        if (pSSubDEViewBase.isCreateManDirty() && (bl || pSSubDEViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubDEViewBase.getCreateMan());
        }
        if (pSSubDEViewBase.isMemoDirty() && (bl || pSSubDEViewBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubDEViewBase.getMemo());
        }
        if (pSSubDEViewBase.isPSDEViewBaseIdDirty() && (bl || pSSubDEViewBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSSubDEViewBase.getPSDEViewBaseId());
        }
        if (pSSubDEViewBase.isPSSubDEIdDirty() && (bl || pSSubDEViewBase.getPSSubDEId() != null)) {
            iDataObject.set(FIELD_PSSUBDEID, (Object)pSSubDEViewBase.getPSSubDEId());
        }
        if (pSSubDEViewBase.isPSSubDENameDirty() && (bl || pSSubDEViewBase.getPSSubDEName() != null)) {
            iDataObject.set(FIELD_PSSUBDENAME, (Object)pSSubDEViewBase.getPSSubDEName());
        }
        if (pSSubDEViewBase.isPSSubDEViewIdDirty() && (bl || pSSubDEViewBase.getPSSubDEViewId() != null)) {
            iDataObject.set(FIELD_PSSUBDEVIEWID, (Object)pSSubDEViewBase.getPSSubDEViewId());
        }
        if (pSSubDEViewBase.isPSSubDEViewNameDirty() && (bl || pSSubDEViewBase.getPSSubDEViewName() != null)) {
            iDataObject.set(FIELD_PSSUBDEVIEWNAME, (Object)pSSubDEViewBase.getPSSubDEViewName());
        }
        if (pSSubDEViewBase.isPSSubSysIdDirty() && (bl || pSSubDEViewBase.getPSSubSysId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSID, (Object)pSSubDEViewBase.getPSSubSysId());
        }
        if (pSSubDEViewBase.isPSSubSysNameDirty() && (bl || pSSubDEViewBase.getPSSubSysName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSNAME, (Object)pSSubDEViewBase.getPSSubSysName());
        }
        if (pSSubDEViewBase.isUpdateDateDirty() && (bl || pSSubDEViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubDEViewBase.getUpdateDate());
        }
        if (pSSubDEViewBase.isUpdateManDirty() && (bl || pSSubDEViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubDEViewBase.getUpdateMan());
        }
        if (pSSubDEViewBase.isViewTypeDirty() && (bl || pSSubDEViewBase.getViewType() != null)) {
            iDataObject.set(FIELD_VIEWTYPE, (Object)pSSubDEViewBase.getViewType());
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
        return PSSubDEViewBase.remove(this, n);
    }

    private static boolean remove(PSSubDEViewBase pSSubDEViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubDEViewBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSubDEViewBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSubDEViewBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSubDEViewBase.resetMemo();
                return true;
            }
            case 4: {
                pSSubDEViewBase.resetPSDEViewBaseId();
                return true;
            }
            case 5: {
                pSSubDEViewBase.resetPSSubDEId();
                return true;
            }
            case 6: {
                pSSubDEViewBase.resetPSSubDEName();
                return true;
            }
            case 7: {
                pSSubDEViewBase.resetPSSubDEViewId();
                return true;
            }
            case 8: {
                pSSubDEViewBase.resetPSSubDEViewName();
                return true;
            }
            case 9: {
                pSSubDEViewBase.resetPSSubSysId();
                return true;
            }
            case 10: {
                pSSubDEViewBase.resetPSSubSysName();
                return true;
            }
            case 11: {
                pSSubDEViewBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSSubDEViewBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSSubDEViewBase.resetViewType();
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSys getPSSubSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSys();
        }
        if (this.getPSSubSysId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysLock;
        synchronized (n) {
            if (this.pssubsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysId(), (Object)this.pssubsys.getPSSubSysId()) != 0L) {
                this.pssubsys = null;
            }
            if (this.pssubsys == null) {
                PSSubSys pSSubSys = new PSSubSys();
                pSSubSys.setPSSubSysId(this.getPSSubSysId());
                PSSubSysService pSSubSysService = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysService.autoGet((IEntity)pSSubSys);
                this.pssubsys = pSSubSys;
            }
            return this.pssubsys;
        }
    }

    private PSSubDEViewBase getProxyEntity() {
        return this.proxyPSSubDEViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubDEViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubDEViewBase) {
            this.proxyPSSubDEViewBase = (PSSubDEViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubDEViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 4);
        fieldIndexMap.put(FIELD_PSSUBDEID, 5);
        fieldIndexMap.put(FIELD_PSSUBDENAME, 6);
        fieldIndexMap.put(FIELD_PSSUBDEVIEWID, 7);
        fieldIndexMap.put(FIELD_PSSUBDEVIEWNAME, 8);
        fieldIndexMap.put(FIELD_PSSUBSYSID, 9);
        fieldIndexMap.put(FIELD_PSSUBSYSNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VIEWTYPE, 13);
    }
}

