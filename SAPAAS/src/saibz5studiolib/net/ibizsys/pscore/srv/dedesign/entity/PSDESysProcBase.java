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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESysProcBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDESysProcBase.class);
    public static final String FIELD_ACTIONMODE = "ACTIONMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTMODE = "DEFAULTMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDESYSPROCID = "PSDESYSPROCID";
    public static final String FIELD_PSDESYSPROCNAME = "PSDESYSPROCNAME";
    public static final String FIELD_SYSPROCTYPE = "SYSPROCTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    private static final int INDEX_ACTIONMODE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEFAULTMODE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEID = 5;
    private static final int INDEX_PSDENAME = 6;
    private static final int INDEX_PSDESYSPROCID = 7;
    private static final int INDEX_PSDESYSPROCNAME = 8;
    private static final int INDEX_SYSPROCTYPE = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERPARAMS = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDESysProcBase proxyPSDESysProcBase = null;
    private boolean actionmodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdesysprocidDirtyFlag = false;
    private boolean psdesysprocnameDirtyFlag = false;
    private boolean sysproctypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    @Column(name="actionmode")
    private String actionmode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultmode")
    private Integer defaultmode;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdesysprocid")
    private String psdesysprocid;
    @Column(name="psdesysprocname")
    private String psdesysprocname;
    @Column(name="sysproctype")
    private String sysproctype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;

    public void setActionMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionmode = string;
        this.actionmodeDirtyFlag = true;
    }

    public String getActionMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionMode();
        }
        return this.actionmode;
    }

    public boolean isActionModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionModeDirty();
        }
        return this.actionmodeDirtyFlag;
    }

    public void resetActionMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionMode();
            return;
        }
        this.actionmodeDirtyFlag = false;
        this.actionmode = null;
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

    public void setDefaultMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultMode(n);
            return;
        }
        this.defaultmode = n;
        this.defaultmodeDirtyFlag = true;
    }

    public Integer getDefaultMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultMode();
        }
        return this.defaultmode;
    }

    public boolean isDefaultModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultModeDirty();
        }
        return this.defaultmodeDirtyFlag;
    }

    public void resetDefaultMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultMode();
            return;
        }
        this.defaultmodeDirtyFlag = false;
        this.defaultmode = null;
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

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSDESysProcId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESysProcId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesysprocid = string;
        this.psdesysprocidDirtyFlag = true;
    }

    public String getPSDESysProcId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESysProcId();
        }
        return this.psdesysprocid;
    }

    public boolean isPSDESysProcIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESysProcIdDirty();
        }
        return this.psdesysprocidDirtyFlag;
    }

    public void resetPSDESysProcId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESysProcId();
            return;
        }
        this.psdesysprocidDirtyFlag = false;
        this.psdesysprocid = null;
    }

    public void setPSDESysProcName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESysProcName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesysprocname = string;
        this.psdesysprocnameDirtyFlag = true;
    }

    public String getPSDESysProcName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESysProcName();
        }
        return this.psdesysprocname;
    }

    public boolean isPSDESysProcNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESysProcNameDirty();
        }
        return this.psdesysprocnameDirtyFlag;
    }

    public void resetPSDESysProcName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESysProcName();
            return;
        }
        this.psdesysprocnameDirtyFlag = false;
        this.psdesysprocname = null;
    }

    public void setSysProcType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysProcType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysproctype = string;
        this.sysproctypeDirtyFlag = true;
    }

    public String getSysProcType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysProcType();
        }
        return this.sysproctype;
    }

    public boolean isSysProcTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysProcTypeDirty();
        }
        return this.sysproctypeDirtyFlag;
    }

    public void resetSysProcType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysProcType();
            return;
        }
        this.sysproctypeDirtyFlag = false;
        this.sysproctype = null;
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
        PSDESysProcBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDESysProcBase pSDESysProcBase) {
        pSDESysProcBase.resetActionMode();
        pSDESysProcBase.resetCreateDate();
        pSDESysProcBase.resetCreateMan();
        pSDESysProcBase.resetDefaultMode();
        pSDESysProcBase.resetMemo();
        pSDESysProcBase.resetPSDEId();
        pSDESysProcBase.resetPSDEName();
        pSDESysProcBase.resetPSDESysProcId();
        pSDESysProcBase.resetPSDESysProcName();
        pSDESysProcBase.resetSysProcType();
        pSDESysProcBase.resetUpdateDate();
        pSDESysProcBase.resetUpdateMan();
        pSDESysProcBase.resetUserParams();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionModeDirty()) {
            hashMap.put(FIELD_ACTIONMODE, this.getActionMode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultModeDirty()) {
            hashMap.put(FIELD_DEFAULTMODE, this.getDefaultMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDESysProcIdDirty()) {
            hashMap.put(FIELD_PSDESYSPROCID, this.getPSDESysProcId());
        }
        if (!bl || this.isPSDESysProcNameDirty()) {
            hashMap.put(FIELD_PSDESYSPROCNAME, this.getPSDESysProcName());
        }
        if (!bl || this.isSysProcTypeDirty()) {
            hashMap.put(FIELD_SYSPROCTYPE, this.getSysProcType());
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
        return PSDESysProcBase.get(this, n);
    }

    private static Object get(PSDESysProcBase pSDESysProcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESysProcBase.getActionMode();
            }
            case 1: {
                return pSDESysProcBase.getCreateDate();
            }
            case 2: {
                return pSDESysProcBase.getCreateMan();
            }
            case 3: {
                return pSDESysProcBase.getDefaultMode();
            }
            case 4: {
                return pSDESysProcBase.getMemo();
            }
            case 5: {
                return pSDESysProcBase.getPSDEId();
            }
            case 6: {
                return pSDESysProcBase.getPSDEName();
            }
            case 7: {
                return pSDESysProcBase.getPSDESysProcId();
            }
            case 8: {
                return pSDESysProcBase.getPSDESysProcName();
            }
            case 9: {
                return pSDESysProcBase.getSysProcType();
            }
            case 10: {
                return pSDESysProcBase.getUpdateDate();
            }
            case 11: {
                return pSDESysProcBase.getUpdateMan();
            }
            case 12: {
                return pSDESysProcBase.getUserParams();
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
        PSDESysProcBase.set(this, n, object);
    }

    private static void set(PSDESysProcBase pSDESysProcBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDESysProcBase.setActionMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDESysProcBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDESysProcBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDESysProcBase.setDefaultMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDESysProcBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDESysProcBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDESysProcBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDESysProcBase.setPSDESysProcId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDESysProcBase.setPSDESysProcName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDESysProcBase.setSysProcType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDESysProcBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDESysProcBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDESysProcBase.setUserParams(DataObject.getStringValue((Object)object));
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
        return PSDESysProcBase.isNull(this, n);
    }

    private static boolean isNull(PSDESysProcBase pSDESysProcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESysProcBase.getActionMode() == null;
            }
            case 1: {
                return pSDESysProcBase.getCreateDate() == null;
            }
            case 2: {
                return pSDESysProcBase.getCreateMan() == null;
            }
            case 3: {
                return pSDESysProcBase.getDefaultMode() == null;
            }
            case 4: {
                return pSDESysProcBase.getMemo() == null;
            }
            case 5: {
                return pSDESysProcBase.getPSDEId() == null;
            }
            case 6: {
                return pSDESysProcBase.getPSDEName() == null;
            }
            case 7: {
                return pSDESysProcBase.getPSDESysProcId() == null;
            }
            case 8: {
                return pSDESysProcBase.getPSDESysProcName() == null;
            }
            case 9: {
                return pSDESysProcBase.getSysProcType() == null;
            }
            case 10: {
                return pSDESysProcBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDESysProcBase.getUpdateMan() == null;
            }
            case 12: {
                return pSDESysProcBase.getUserParams() == null;
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
        return PSDESysProcBase.contains(this, n);
    }

    private static boolean contains(PSDESysProcBase pSDESysProcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESysProcBase.isActionModeDirty();
            }
            case 1: {
                return pSDESysProcBase.isCreateDateDirty();
            }
            case 2: {
                return pSDESysProcBase.isCreateManDirty();
            }
            case 3: {
                return pSDESysProcBase.isDefaultModeDirty();
            }
            case 4: {
                return pSDESysProcBase.isMemoDirty();
            }
            case 5: {
                return pSDESysProcBase.isPSDEIdDirty();
            }
            case 6: {
                return pSDESysProcBase.isPSDENameDirty();
            }
            case 7: {
                return pSDESysProcBase.isPSDESysProcIdDirty();
            }
            case 8: {
                return pSDESysProcBase.isPSDESysProcNameDirty();
            }
            case 9: {
                return pSDESysProcBase.isSysProcTypeDirty();
            }
            case 10: {
                return pSDESysProcBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDESysProcBase.isUpdateManDirty();
            }
            case 12: {
                return pSDESysProcBase.isUserParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDESysProcBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDESysProcBase pSDESysProcBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDESysProcBase.getActionMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionmode", (Object)PSDESysProcBase.getJSONValue((Object)pSDESysProcBase.getActionMode()), (boolean)false);
        }
        if (bl || pSDESysProcBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDESysProcBase.getJSONValue((Object)pSDESysProcBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDESysProcBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDESysProcBase.getJSONValue((Object)pSDESysProcBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDESysProcBase.getDefaultMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultmode", (Object)PSDESysProcBase.getJSONValue((Object)pSDESysProcBase.getDefaultMode()), (boolean)false);
        }
        if (bl || pSDESysProcBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDESysProcBase.getJSONValue((Object)pSDESysProcBase.getMemo()), (boolean)false);
        }
        if (bl || pSDESysProcBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDESysProcBase.getJSONValue((Object)pSDESysProcBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDESysProcBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDESysProcBase.getJSONValue((Object)pSDESysProcBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDESysProcBase.getPSDESysProcId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesysprocid", (Object)PSDESysProcBase.getJSONValue((Object)pSDESysProcBase.getPSDESysProcId()), (boolean)false);
        }
        if (bl || pSDESysProcBase.getPSDESysProcName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesysprocname", (Object)PSDESysProcBase.getJSONValue((Object)pSDESysProcBase.getPSDESysProcName()), (boolean)false);
        }
        if (bl || pSDESysProcBase.getSysProcType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysproctype", (Object)PSDESysProcBase.getJSONValue((Object)pSDESysProcBase.getSysProcType()), (boolean)false);
        }
        if (bl || pSDESysProcBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDESysProcBase.getJSONValue((Object)pSDESysProcBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDESysProcBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDESysProcBase.getJSONValue((Object)pSDESysProcBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDESysProcBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDESysProcBase.getJSONValue((Object)pSDESysProcBase.getUserParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDESysProcBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDESysProcBase pSDESysProcBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDESysProcBase.getActionMode() != null) {
            object = pSDESysProcBase.getActionMode();
            xmlNode.setAttribute(FIELD_ACTIONMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDESysProcBase.getCreateDate() != null) {
            object = pSDESysProcBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESysProcBase.getCreateMan() != null) {
            object = pSDESysProcBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESysProcBase.getDefaultMode() != null) {
            object = pSDESysProcBase.getDefaultMode();
            xmlNode.setAttribute(FIELD_DEFAULTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESysProcBase.getMemo() != null) {
            object = pSDESysProcBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDESysProcBase.getPSDEId() != null) {
            object = pSDESysProcBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDESysProcBase.getPSDEName() != null) {
            object = pSDESysProcBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESysProcBase.getPSDESysProcId() != null) {
            object = pSDESysProcBase.getPSDESysProcId();
            xmlNode.setAttribute(FIELD_PSDESYSPROCID, object == null ? "" : (String)object);
        }
        if (bl || pSDESysProcBase.getPSDESysProcName() != null) {
            object = pSDESysProcBase.getPSDESysProcName();
            xmlNode.setAttribute(FIELD_PSDESYSPROCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESysProcBase.getSysProcType() != null) {
            object = pSDESysProcBase.getSysProcType();
            xmlNode.setAttribute(FIELD_SYSPROCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDESysProcBase.getUpdateDate() != null) {
            object = pSDESysProcBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESysProcBase.getUpdateMan() != null) {
            object = pSDESysProcBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESysProcBase.getUserParams() != null) {
            object = pSDESysProcBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDESysProcBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDESysProcBase pSDESysProcBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDESysProcBase.isActionModeDirty() && (bl || pSDESysProcBase.getActionMode() != null)) {
            iDataObject.set(FIELD_ACTIONMODE, (Object)pSDESysProcBase.getActionMode());
        }
        if (pSDESysProcBase.isCreateDateDirty() && (bl || pSDESysProcBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDESysProcBase.getCreateDate());
        }
        if (pSDESysProcBase.isCreateManDirty() && (bl || pSDESysProcBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDESysProcBase.getCreateMan());
        }
        if (pSDESysProcBase.isDefaultModeDirty() && (bl || pSDESysProcBase.getDefaultMode() != null)) {
            iDataObject.set(FIELD_DEFAULTMODE, (Object)pSDESysProcBase.getDefaultMode());
        }
        if (pSDESysProcBase.isMemoDirty() && (bl || pSDESysProcBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDESysProcBase.getMemo());
        }
        if (pSDESysProcBase.isPSDEIdDirty() && (bl || pSDESysProcBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDESysProcBase.getPSDEId());
        }
        if (pSDESysProcBase.isPSDENameDirty() && (bl || pSDESysProcBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDESysProcBase.getPSDEName());
        }
        if (pSDESysProcBase.isPSDESysProcIdDirty() && (bl || pSDESysProcBase.getPSDESysProcId() != null)) {
            iDataObject.set(FIELD_PSDESYSPROCID, (Object)pSDESysProcBase.getPSDESysProcId());
        }
        if (pSDESysProcBase.isPSDESysProcNameDirty() && (bl || pSDESysProcBase.getPSDESysProcName() != null)) {
            iDataObject.set(FIELD_PSDESYSPROCNAME, (Object)pSDESysProcBase.getPSDESysProcName());
        }
        if (pSDESysProcBase.isSysProcTypeDirty() && (bl || pSDESysProcBase.getSysProcType() != null)) {
            iDataObject.set(FIELD_SYSPROCTYPE, (Object)pSDESysProcBase.getSysProcType());
        }
        if (pSDESysProcBase.isUpdateDateDirty() && (bl || pSDESysProcBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDESysProcBase.getUpdateDate());
        }
        if (pSDESysProcBase.isUpdateManDirty() && (bl || pSDESysProcBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDESysProcBase.getUpdateMan());
        }
        if (pSDESysProcBase.isUserParamsDirty() && (bl || pSDESysProcBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDESysProcBase.getUserParams());
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
        return PSDESysProcBase.remove(this, n);
    }

    private static boolean remove(PSDESysProcBase pSDESysProcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDESysProcBase.resetActionMode();
                return true;
            }
            case 1: {
                pSDESysProcBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDESysProcBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDESysProcBase.resetDefaultMode();
                return true;
            }
            case 4: {
                pSDESysProcBase.resetMemo();
                return true;
            }
            case 5: {
                pSDESysProcBase.resetPSDEId();
                return true;
            }
            case 6: {
                pSDESysProcBase.resetPSDEName();
                return true;
            }
            case 7: {
                pSDESysProcBase.resetPSDESysProcId();
                return true;
            }
            case 8: {
                pSDESysProcBase.resetPSDESysProcName();
                return true;
            }
            case 9: {
                pSDESysProcBase.resetSysProcType();
                return true;
            }
            case 10: {
                pSDESysProcBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDESysProcBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSDESysProcBase.resetUserParams();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    private PSDESysProcBase getProxyEntity() {
        return this.proxyPSDESysProcBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDESysProcBase = null;
        if (iDataObject != null && iDataObject instanceof PSDESysProcBase) {
            this.proxyPSDESysProcBase = (PSDESysProcBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESysProcService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONMODE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTMODE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEID, 5);
        fieldIndexMap.put(FIELD_PSDENAME, 6);
        fieldIndexMap.put(FIELD_PSDESYSPROCID, 7);
        fieldIndexMap.put(FIELD_PSDESYSPROCNAME, 8);
        fieldIndexMap.put(FIELD_SYSPROCTYPE, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERPARAMS, 12);
    }
}

