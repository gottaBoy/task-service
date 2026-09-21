/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.common.entity.SysAdmin;
import net.ibizsys.psrt.srv.common.service.SysAdminService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class SysAdminFuncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(SysAdminFuncBase.class);
    public static final String FIELD_ADMINOBJECT = "ADMINOBJECT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FUNCID = "FUNCID";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAM = "PARAM";
    public static final String FIELD_SYSADMINFUNCID = "SYSADMINFUNCID";
    public static final String FIELD_SYSADMINFUNCNAME = "SYSADMINFUNCNAME";
    public static final String FIELD_SYSADMINID = "SYSADMINID";
    public static final String FIELD_SYSADMINNAME = "SYSADMINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ADMINOBJECT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_FUNCID = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PARAM = 5;
    private static final int INDEX_SYSADMINFUNCID = 6;
    private static final int INDEX_SYSADMINFUNCNAME = 7;
    private static final int INDEX_SYSADMINID = 8;
    private static final int INDEX_SYSADMINNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private SysAdminFuncBase proxySysAdminFuncBase = null;
    private boolean adminobjectDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean funcidDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramDirtyFlag = false;
    private boolean sysadminfuncidDirtyFlag = false;
    private boolean sysadminfuncnameDirtyFlag = false;
    private boolean sysadminidDirtyFlag = false;
    private boolean sysadminnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="adminobject")
    private String adminobject;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="funcid")
    private String funcid;
    @Column(name="memo")
    private String memo;
    @Column(name="param")
    private String param;
    @Column(name="sysadminfuncid")
    private String sysadminfuncid;
    @Column(name="sysadminfuncname")
    private String sysadminfuncname;
    @Column(name="sysadminid")
    private String sysadminid;
    @Column(name="sysadminname")
    private String sysadminname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objSysAdminLock = new Integer(1);
    private SysAdmin sysadmin = null;

    static {
        fieldIndexMap.put(FIELD_ADMINOBJECT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FUNCID, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PARAM, 5);
        fieldIndexMap.put(FIELD_SYSADMINFUNCID, 6);
        fieldIndexMap.put(FIELD_SYSADMINFUNCNAME, 7);
        fieldIndexMap.put(FIELD_SYSADMINID, 8);
        fieldIndexMap.put(FIELD_SYSADMINNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }

    public void setAdminObject(String adminobject) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminObject(adminobject);
            return;
        }
        if (adminobject != null && (adminobject = StringHelper.trimRight(adminobject)).length() == 0) {
            adminobject = null;
        }
        this.adminobject = adminobject;
        this.adminobjectDirtyFlag = true;
    }

    public String getAdminObject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminObject();
        }
        return this.adminobject;
    }

    public boolean isAdminObjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminObjectDirty();
        }
        return this.adminobjectDirtyFlag;
    }

    public void resetAdminObject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminObject();
            return;
        }
        this.adminobjectDirtyFlag = false;
        this.adminobject = null;
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
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

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
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

    public void setFuncId(String funcid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncId(funcid);
            return;
        }
        if (funcid != null && (funcid = StringHelper.trimRight(funcid)).length() == 0) {
            funcid = null;
        }
        this.funcid = funcid;
        this.funcidDirtyFlag = true;
    }

    public String getFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncId();
        }
        return this.funcid;
    }

    public boolean isFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncIdDirty();
        }
        return this.funcidDirtyFlag;
    }

    public void resetFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncId();
            return;
        }
        this.funcidDirtyFlag = false;
        this.funcid = null;
    }

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
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

    public void setParam(String param) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam(param);
            return;
        }
        if (param != null && (param = StringHelper.trimRight(param)).length() == 0) {
            param = null;
        }
        this.param = param;
        this.paramDirtyFlag = true;
    }

    public String getParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam();
        }
        return this.param;
    }

    public boolean isParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDirty();
        }
        return this.paramDirtyFlag;
    }

    public void resetParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam();
            return;
        }
        this.paramDirtyFlag = false;
        this.param = null;
    }

    public void setSysAdminFuncId(String sysadminfuncid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysAdminFuncId(sysadminfuncid);
            return;
        }
        if (sysadminfuncid != null && (sysadminfuncid = StringHelper.trimRight(sysadminfuncid)).length() == 0) {
            sysadminfuncid = null;
        }
        this.sysadminfuncid = sysadminfuncid;
        this.sysadminfuncidDirtyFlag = true;
    }

    public String getSysAdminFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysAdminFuncId();
        }
        return this.sysadminfuncid;
    }

    public boolean isSysAdminFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysAdminFuncIdDirty();
        }
        return this.sysadminfuncidDirtyFlag;
    }

    public void resetSysAdminFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysAdminFuncId();
            return;
        }
        this.sysadminfuncidDirtyFlag = false;
        this.sysadminfuncid = null;
    }

    public void setSysAdminFuncName(String sysadminfuncname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysAdminFuncName(sysadminfuncname);
            return;
        }
        if (sysadminfuncname != null && (sysadminfuncname = StringHelper.trimRight(sysadminfuncname)).length() == 0) {
            sysadminfuncname = null;
        }
        this.sysadminfuncname = sysadminfuncname;
        this.sysadminfuncnameDirtyFlag = true;
    }

    public String getSysAdminFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysAdminFuncName();
        }
        return this.sysadminfuncname;
    }

    public boolean isSysAdminFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysAdminFuncNameDirty();
        }
        return this.sysadminfuncnameDirtyFlag;
    }

    public void resetSysAdminFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysAdminFuncName();
            return;
        }
        this.sysadminfuncnameDirtyFlag = false;
        this.sysadminfuncname = null;
    }

    public void setSysAdminId(String sysadminid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysAdminId(sysadminid);
            return;
        }
        if (sysadminid != null && (sysadminid = StringHelper.trimRight(sysadminid)).length() == 0) {
            sysadminid = null;
        }
        this.sysadminid = sysadminid;
        this.sysadminidDirtyFlag = true;
    }

    public String getSysAdminId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysAdminId();
        }
        return this.sysadminid;
    }

    public boolean isSysAdminIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysAdminIdDirty();
        }
        return this.sysadminidDirtyFlag;
    }

    public void resetSysAdminId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysAdminId();
            return;
        }
        this.sysadminidDirtyFlag = false;
        this.sysadminid = null;
    }

    public void setSysAdminName(String sysadminname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysAdminName(sysadminname);
            return;
        }
        if (sysadminname != null && (sysadminname = StringHelper.trimRight(sysadminname)).length() == 0) {
            sysadminname = null;
        }
        this.sysadminname = sysadminname;
        this.sysadminnameDirtyFlag = true;
    }

    public String getSysAdminName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysAdminName();
        }
        return this.sysadminname;
    }

    public boolean isSysAdminNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysAdminNameDirty();
        }
        return this.sysadminnameDirtyFlag;
    }

    public void resetSysAdminName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysAdminName();
            return;
        }
        this.sysadminnameDirtyFlag = false;
        this.sysadminname = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
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

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
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

    @Override
    protected void onReset() {
        SysAdminFuncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(SysAdminFuncBase et) {
        et.resetAdminObject();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetFuncId();
        et.resetMemo();
        et.resetParam();
        et.resetSysAdminFuncId();
        et.resetSysAdminFuncName();
        et.resetSysAdminId();
        et.resetSysAdminName();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isAdminObjectDirty()) {
            params.put(FIELD_ADMINOBJECT, this.getAdminObject());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isFuncIdDirty()) {
            params.put(FIELD_FUNCID, this.getFuncId());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isParamDirty()) {
            params.put(FIELD_PARAM, this.getParam());
        }
        if (!bDirtyOnly || this.isSysAdminFuncIdDirty()) {
            params.put(FIELD_SYSADMINFUNCID, this.getSysAdminFuncId());
        }
        if (!bDirtyOnly || this.isSysAdminFuncNameDirty()) {
            params.put(FIELD_SYSADMINFUNCNAME, this.getSysAdminFuncName());
        }
        if (!bDirtyOnly || this.isSysAdminIdDirty()) {
            params.put(FIELD_SYSADMINID, this.getSysAdminId());
        }
        if (!bDirtyOnly || this.isSysAdminNameDirty()) {
            params.put(FIELD_SYSADMINNAME, this.getSysAdminName());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return SysAdminFuncBase.get(this, index);
    }

    private static Object get(SysAdminFuncBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAdminObject();
            }
            case 1: {
                return et.getCreateDate();
            }
            case 2: {
                return et.getCreateMan();
            }
            case 3: {
                return et.getFuncId();
            }
            case 4: {
                return et.getMemo();
            }
            case 5: {
                return et.getParam();
            }
            case 6: {
                return et.getSysAdminFuncId();
            }
            case 7: {
                return et.getSysAdminFuncName();
            }
            case 8: {
                return et.getSysAdminId();
            }
            case 9: {
                return et.getSysAdminName();
            }
            case 10: {
                return et.getUpdateDate();
            }
            case 11: {
                return et.getUpdateMan();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        SysAdminFuncBase.set(this, index, objValue);
    }

    private static void set(SysAdminFuncBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setAdminObject(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 2: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setFuncId(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setParam(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setSysAdminFuncId(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setSysAdminFuncName(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setSysAdminId(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setSysAdminName(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 11: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return SysAdminFuncBase.isNull(this, index);
    }

    private static boolean isNull(SysAdminFuncBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAdminObject() == null;
            }
            case 1: {
                return et.getCreateDate() == null;
            }
            case 2: {
                return et.getCreateMan() == null;
            }
            case 3: {
                return et.getFuncId() == null;
            }
            case 4: {
                return et.getMemo() == null;
            }
            case 5: {
                return et.getParam() == null;
            }
            case 6: {
                return et.getSysAdminFuncId() == null;
            }
            case 7: {
                return et.getSysAdminFuncName() == null;
            }
            case 8: {
                return et.getSysAdminId() == null;
            }
            case 9: {
                return et.getSysAdminName() == null;
            }
            case 10: {
                return et.getUpdateDate() == null;
            }
            case 11: {
                return et.getUpdateMan() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return SysAdminFuncBase.contains(this, index);
    }

    private static boolean contains(SysAdminFuncBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isAdminObjectDirty();
            }
            case 1: {
                return et.isCreateDateDirty();
            }
            case 2: {
                return et.isCreateManDirty();
            }
            case 3: {
                return et.isFuncIdDirty();
            }
            case 4: {
                return et.isMemoDirty();
            }
            case 5: {
                return et.isParamDirty();
            }
            case 6: {
                return et.isSysAdminFuncIdDirty();
            }
            case 7: {
                return et.isSysAdminFuncNameDirty();
            }
            case 8: {
                return et.isSysAdminIdDirty();
            }
            case 9: {
                return et.isSysAdminNameDirty();
            }
            case 10: {
                return et.isUpdateDateDirty();
            }
            case 11: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        SysAdminFuncBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(SysAdminFuncBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getAdminObject() != null) {
            JSONObjectHelper.put(json, "adminobject", SysAdminFuncBase.getJSONValue(et.getAdminObject()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", SysAdminFuncBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", SysAdminFuncBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getFuncId() != null) {
            JSONObjectHelper.put(json, "funcid", SysAdminFuncBase.getJSONValue(et.getFuncId()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", SysAdminFuncBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getParam() != null) {
            JSONObjectHelper.put(json, "param", SysAdminFuncBase.getJSONValue(et.getParam()), false);
        }
        if (bIncEmpty || et.getSysAdminFuncId() != null) {
            JSONObjectHelper.put(json, "sysadminfuncid", SysAdminFuncBase.getJSONValue(et.getSysAdminFuncId()), false);
        }
        if (bIncEmpty || et.getSysAdminFuncName() != null) {
            JSONObjectHelper.put(json, "sysadminfuncname", SysAdminFuncBase.getJSONValue(et.getSysAdminFuncName()), false);
        }
        if (bIncEmpty || et.getSysAdminId() != null) {
            JSONObjectHelper.put(json, "sysadminid", SysAdminFuncBase.getJSONValue(et.getSysAdminId()), false);
        }
        if (bIncEmpty || et.getSysAdminName() != null) {
            JSONObjectHelper.put(json, "sysadminname", SysAdminFuncBase.getJSONValue(et.getSysAdminName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", SysAdminFuncBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", SysAdminFuncBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        SysAdminFuncBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(SysAdminFuncBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getAdminObject() != null) {
            obj = et.getAdminObject();
            node.setAttribute(FIELD_ADMINOBJECT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getFuncId() != null) {
            obj = et.getFuncId();
            node.setAttribute(FIELD_FUNCID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getParam() != null) {
            obj = et.getParam();
            node.setAttribute(FIELD_PARAM, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSysAdminFuncId() != null) {
            obj = et.getSysAdminFuncId();
            node.setAttribute(FIELD_SYSADMINFUNCID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSysAdminFuncName() != null) {
            obj = et.getSysAdminFuncName();
            node.setAttribute(FIELD_SYSADMINFUNCNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSysAdminId() != null) {
            obj = et.getSysAdminId();
            node.setAttribute(FIELD_SYSADMINID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSysAdminName() != null) {
            obj = et.getSysAdminName();
            node.setAttribute(FIELD_SYSADMINNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        SysAdminFuncBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(SysAdminFuncBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isAdminObjectDirty() && (bIncEmpty || et.getAdminObject() != null)) {
            dst.set(FIELD_ADMINOBJECT, et.getAdminObject());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isFuncIdDirty() && (bIncEmpty || et.getFuncId() != null)) {
            dst.set(FIELD_FUNCID, et.getFuncId());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isParamDirty() && (bIncEmpty || et.getParam() != null)) {
            dst.set(FIELD_PARAM, et.getParam());
        }
        if (et.isSysAdminFuncIdDirty() && (bIncEmpty || et.getSysAdminFuncId() != null)) {
            dst.set(FIELD_SYSADMINFUNCID, et.getSysAdminFuncId());
        }
        if (et.isSysAdminFuncNameDirty() && (bIncEmpty || et.getSysAdminFuncName() != null)) {
            dst.set(FIELD_SYSADMINFUNCNAME, et.getSysAdminFuncName());
        }
        if (et.isSysAdminIdDirty() && (bIncEmpty || et.getSysAdminId() != null)) {
            dst.set(FIELD_SYSADMINID, et.getSysAdminId());
        }
        if (et.isSysAdminNameDirty() && (bIncEmpty || et.getSysAdminName() != null)) {
            dst.set(FIELD_SYSADMINNAME, et.getSysAdminName());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return SysAdminFuncBase.remove(this, index);
    }

    private static boolean remove(SysAdminFuncBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetAdminObject();
                return true;
            }
            case 1: {
                et.resetCreateDate();
                return true;
            }
            case 2: {
                et.resetCreateMan();
                return true;
            }
            case 3: {
                et.resetFuncId();
                return true;
            }
            case 4: {
                et.resetMemo();
                return true;
            }
            case 5: {
                et.resetParam();
                return true;
            }
            case 6: {
                et.resetSysAdminFuncId();
                return true;
            }
            case 7: {
                et.resetSysAdminFuncName();
                return true;
            }
            case 8: {
                et.resetSysAdminId();
                return true;
            }
            case 9: {
                et.resetSysAdminName();
                return true;
            }
            case 10: {
                et.resetUpdateDate();
                return true;
            }
            case 11: {
                et.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SysAdmin getSysAdmin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysAdmin();
        }
        if (this.getSysAdminId() == null) {
            return null;
        }
        Integer n = this.objSysAdminLock;
        synchronized (n) {
            if (this.sysadmin != null && DataTypeHelper.compare(25, (Object)this.getSysAdminId(), (Object)this.sysadmin.getSysAdminId()) != 0L) {
                this.sysadmin = null;
            }
            if (this.sysadmin == null) {
                SysAdmin sysadmin = new SysAdmin();
                sysadmin.setSysAdminId(this.getSysAdminId());
                SysAdminService service = (SysAdminService)ServiceGlobal.getService(SysAdminService.class, this.getSessionFactory());
                service.autoGet(sysadmin);
                this.sysadmin = sysadmin;
            }
            return this.sysadmin;
        }
    }

    private SysAdminFuncBase getProxyEntity() {
        return this.proxySysAdminFuncBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxySysAdminFuncBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof SysAdminFuncBase) {
            this.proxySysAdminFuncBase = (SysAdminFuncBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.SysAdminFuncService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

