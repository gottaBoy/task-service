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
import net.ibizsys.pscore.srv.dedesign.entity.PSDESysProc;
import net.ibizsys.pscore.srv.dedesign.service.PSDESysProcService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESPCodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDESPCodeBase.class);
    public static final String FIELD_COMPILEFLAG = "COMPILEFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FULLCODE = "FULLCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDESPCODEID = "PSDESPCODEID";
    public static final String FIELD_PSDESPCODENAME = "PSDESPCODENAME";
    public static final String FIELD_PSDESYSPROCID = "PSDESYSPROCID";
    public static final String FIELD_PSDESYSPROCNAME = "PSDESYSPROCNAME";
    public static final String FIELD_SYSPROCTYPE = "SYSPROCTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCODE = "USERCODE";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    private static final int INDEX_COMPILEFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_FULLCODE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEID = 5;
    private static final int INDEX_PSDESPCODEID = 6;
    private static final int INDEX_PSDESPCODENAME = 7;
    private static final int INDEX_PSDESYSPROCID = 8;
    private static final int INDEX_PSDESYSPROCNAME = 9;
    private static final int INDEX_SYSPROCTYPE = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_USERCODE = 13;
    private static final int INDEX_USERPARAMS = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDESPCodeBase proxyPSDESPCodeBase = null;
    private boolean compileflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean fullcodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdespcodeidDirtyFlag = false;
    private boolean psdespcodenameDirtyFlag = false;
    private boolean psdesysprocidDirtyFlag = false;
    private boolean psdesysprocnameDirtyFlag = false;
    private boolean sysproctypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercodeDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    @Column(name="compileflag")
    private Integer compileflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="fullcode")
    private String fullcode;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdespcodeid")
    private String psdespcodeid;
    @Column(name="psdespcodename")
    private String psdespcodename;
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
    @Column(name="usercode")
    private String usercode;
    @Column(name="userparams")
    private String userparams;
    private Integer objPsdesysprocLock = new Integer(1);
    private PSDESysProc psdesysproc = null;

    public void setCompileFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCompileFlag(n);
            return;
        }
        this.compileflag = n;
        this.compileflagDirtyFlag = true;
    }

    public Integer getCompileFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCompileFlag();
        }
        return this.compileflag;
    }

    public boolean isCompileFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCompileFlagDirty();
        }
        return this.compileflagDirtyFlag;
    }

    public void resetCompileFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCompileFlag();
            return;
        }
        this.compileflagDirtyFlag = false;
        this.compileflag = null;
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

    public void setFULLCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFULLCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullcode = string;
        this.fullcodeDirtyFlag = true;
    }

    public String getFULLCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFULLCode();
        }
        return this.fullcode;
    }

    public boolean isFULLCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFULLCodeDirty();
        }
        return this.fullcodeDirtyFlag;
    }

    public void resetFULLCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFULLCode();
            return;
        }
        this.fullcodeDirtyFlag = false;
        this.fullcode = null;
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

    public void setPSDESPCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESPCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdespcodeid = string;
        this.psdespcodeidDirtyFlag = true;
    }

    public String getPSDESPCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESPCodeId();
        }
        return this.psdespcodeid;
    }

    public boolean isPSDESPCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESPCodeIdDirty();
        }
        return this.psdespcodeidDirtyFlag;
    }

    public void resetPSDESPCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESPCodeId();
            return;
        }
        this.psdespcodeidDirtyFlag = false;
        this.psdespcodeid = null;
    }

    public void setPSDESPCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESPCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdespcodename = string;
        this.psdespcodenameDirtyFlag = true;
    }

    public String getPSDESPCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESPCodeName();
        }
        return this.psdespcodename;
    }

    public boolean isPSDESPCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESPCodeNameDirty();
        }
        return this.psdespcodenameDirtyFlag;
    }

    public void resetPSDESPCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESPCodeName();
            return;
        }
        this.psdespcodenameDirtyFlag = false;
        this.psdespcodename = null;
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

    public void setSYSPROCType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSYSPROCType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysproctype = string;
        this.sysproctypeDirtyFlag = true;
    }

    public String getSYSPROCType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSYSPROCType();
        }
        return this.sysproctype;
    }

    public boolean isSYSPROCTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSYSPROCTypeDirty();
        }
        return this.sysproctypeDirtyFlag;
    }

    public void resetSYSPROCType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSYSPROCType();
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

    public void setUserCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercode = string;
        this.usercodeDirtyFlag = true;
    }

    public String getUserCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCode();
        }
        return this.usercode;
    }

    public boolean isUserCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCodeDirty();
        }
        return this.usercodeDirtyFlag;
    }

    public void resetUserCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCode();
            return;
        }
        this.usercodeDirtyFlag = false;
        this.usercode = null;
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
        PSDESPCodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDESPCodeBase pSDESPCodeBase) {
        pSDESPCodeBase.resetCompileFlag();
        pSDESPCodeBase.resetCreateDate();
        pSDESPCodeBase.resetCreateMan();
        pSDESPCodeBase.resetFULLCode();
        pSDESPCodeBase.resetMemo();
        pSDESPCodeBase.resetPSDEId();
        pSDESPCodeBase.resetPSDESPCodeId();
        pSDESPCodeBase.resetPSDESPCodeName();
        pSDESPCodeBase.resetPSDESysProcId();
        pSDESPCodeBase.resetPSDESysProcName();
        pSDESPCodeBase.resetSYSPROCType();
        pSDESPCodeBase.resetUpdateDate();
        pSDESPCodeBase.resetUpdateMan();
        pSDESPCodeBase.resetUserCode();
        pSDESPCodeBase.resetUserParams();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCompileFlagDirty()) {
            hashMap.put(FIELD_COMPILEFLAG, this.getCompileFlag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFULLCodeDirty()) {
            hashMap.put(FIELD_FULLCODE, this.getFULLCode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDESPCodeIdDirty()) {
            hashMap.put(FIELD_PSDESPCODEID, this.getPSDESPCodeId());
        }
        if (!bl || this.isPSDESPCodeNameDirty()) {
            hashMap.put(FIELD_PSDESPCODENAME, this.getPSDESPCodeName());
        }
        if (!bl || this.isPSDESysProcIdDirty()) {
            hashMap.put(FIELD_PSDESYSPROCID, this.getPSDESysProcId());
        }
        if (!bl || this.isPSDESysProcNameDirty()) {
            hashMap.put(FIELD_PSDESYSPROCNAME, this.getPSDESysProcName());
        }
        if (!bl || this.isSYSPROCTypeDirty()) {
            hashMap.put(FIELD_SYSPROCTYPE, this.getSYSPROCType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCodeDirty()) {
            hashMap.put(FIELD_USERCODE, this.getUserCode());
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
        return PSDESPCodeBase.get(this, n);
    }

    private static Object get(PSDESPCodeBase pSDESPCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESPCodeBase.getCompileFlag();
            }
            case 1: {
                return pSDESPCodeBase.getCreateDate();
            }
            case 2: {
                return pSDESPCodeBase.getCreateMan();
            }
            case 3: {
                return pSDESPCodeBase.getFULLCode();
            }
            case 4: {
                return pSDESPCodeBase.getMemo();
            }
            case 5: {
                return pSDESPCodeBase.getPSDEId();
            }
            case 6: {
                return pSDESPCodeBase.getPSDESPCodeId();
            }
            case 7: {
                return pSDESPCodeBase.getPSDESPCodeName();
            }
            case 8: {
                return pSDESPCodeBase.getPSDESysProcId();
            }
            case 9: {
                return pSDESPCodeBase.getPSDESysProcName();
            }
            case 10: {
                return pSDESPCodeBase.getSYSPROCType();
            }
            case 11: {
                return pSDESPCodeBase.getUpdateDate();
            }
            case 12: {
                return pSDESPCodeBase.getUpdateMan();
            }
            case 13: {
                return pSDESPCodeBase.getUserCode();
            }
            case 14: {
                return pSDESPCodeBase.getUserParams();
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
        PSDESPCodeBase.set(this, n, object);
    }

    private static void set(PSDESPCodeBase pSDESPCodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDESPCodeBase.setCompileFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDESPCodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDESPCodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDESPCodeBase.setFULLCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDESPCodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDESPCodeBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDESPCodeBase.setPSDESPCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDESPCodeBase.setPSDESPCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDESPCodeBase.setPSDESysProcId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDESPCodeBase.setPSDESysProcName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDESPCodeBase.setSYSPROCType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDESPCodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDESPCodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDESPCodeBase.setUserCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDESPCodeBase.setUserParams(DataObject.getStringValue((Object)object));
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
        return PSDESPCodeBase.isNull(this, n);
    }

    private static boolean isNull(PSDESPCodeBase pSDESPCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESPCodeBase.getCompileFlag() == null;
            }
            case 1: {
                return pSDESPCodeBase.getCreateDate() == null;
            }
            case 2: {
                return pSDESPCodeBase.getCreateMan() == null;
            }
            case 3: {
                return pSDESPCodeBase.getFULLCode() == null;
            }
            case 4: {
                return pSDESPCodeBase.getMemo() == null;
            }
            case 5: {
                return pSDESPCodeBase.getPSDEId() == null;
            }
            case 6: {
                return pSDESPCodeBase.getPSDESPCodeId() == null;
            }
            case 7: {
                return pSDESPCodeBase.getPSDESPCodeName() == null;
            }
            case 8: {
                return pSDESPCodeBase.getPSDESysProcId() == null;
            }
            case 9: {
                return pSDESPCodeBase.getPSDESysProcName() == null;
            }
            case 10: {
                return pSDESPCodeBase.getSYSPROCType() == null;
            }
            case 11: {
                return pSDESPCodeBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDESPCodeBase.getUpdateMan() == null;
            }
            case 13: {
                return pSDESPCodeBase.getUserCode() == null;
            }
            case 14: {
                return pSDESPCodeBase.getUserParams() == null;
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
        return PSDESPCodeBase.contains(this, n);
    }

    private static boolean contains(PSDESPCodeBase pSDESPCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESPCodeBase.isCompileFlagDirty();
            }
            case 1: {
                return pSDESPCodeBase.isCreateDateDirty();
            }
            case 2: {
                return pSDESPCodeBase.isCreateManDirty();
            }
            case 3: {
                return pSDESPCodeBase.isFULLCodeDirty();
            }
            case 4: {
                return pSDESPCodeBase.isMemoDirty();
            }
            case 5: {
                return pSDESPCodeBase.isPSDEIdDirty();
            }
            case 6: {
                return pSDESPCodeBase.isPSDESPCodeIdDirty();
            }
            case 7: {
                return pSDESPCodeBase.isPSDESPCodeNameDirty();
            }
            case 8: {
                return pSDESPCodeBase.isPSDESysProcIdDirty();
            }
            case 9: {
                return pSDESPCodeBase.isPSDESysProcNameDirty();
            }
            case 10: {
                return pSDESPCodeBase.isSYSPROCTypeDirty();
            }
            case 11: {
                return pSDESPCodeBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDESPCodeBase.isUpdateManDirty();
            }
            case 13: {
                return pSDESPCodeBase.isUserCodeDirty();
            }
            case 14: {
                return pSDESPCodeBase.isUserParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDESPCodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDESPCodeBase pSDESPCodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDESPCodeBase.getCompileFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"compileflag", (Object)PSDESPCodeBase.getJSONValue((Object)pSDESPCodeBase.getCompileFlag()), (boolean)false);
        }
        if (bl || pSDESPCodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDESPCodeBase.getJSONValue((Object)pSDESPCodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDESPCodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDESPCodeBase.getJSONValue((Object)pSDESPCodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDESPCodeBase.getFULLCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullcode", (Object)PSDESPCodeBase.getJSONValue((Object)pSDESPCodeBase.getFULLCode()), (boolean)false);
        }
        if (bl || pSDESPCodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDESPCodeBase.getJSONValue((Object)pSDESPCodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDESPCodeBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDESPCodeBase.getJSONValue((Object)pSDESPCodeBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDESPCodeBase.getPSDESPCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdespcodeid", (Object)PSDESPCodeBase.getJSONValue((Object)pSDESPCodeBase.getPSDESPCodeId()), (boolean)false);
        }
        if (bl || pSDESPCodeBase.getPSDESPCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdespcodename", (Object)PSDESPCodeBase.getJSONValue((Object)pSDESPCodeBase.getPSDESPCodeName()), (boolean)false);
        }
        if (bl || pSDESPCodeBase.getPSDESysProcId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesysprocid", (Object)PSDESPCodeBase.getJSONValue((Object)pSDESPCodeBase.getPSDESysProcId()), (boolean)false);
        }
        if (bl || pSDESPCodeBase.getPSDESysProcName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesysprocname", (Object)PSDESPCodeBase.getJSONValue((Object)pSDESPCodeBase.getPSDESysProcName()), (boolean)false);
        }
        if (bl || pSDESPCodeBase.getSYSPROCType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysproctype", (Object)PSDESPCodeBase.getJSONValue((Object)pSDESPCodeBase.getSYSPROCType()), (boolean)false);
        }
        if (bl || pSDESPCodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDESPCodeBase.getJSONValue((Object)pSDESPCodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDESPCodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDESPCodeBase.getJSONValue((Object)pSDESPCodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDESPCodeBase.getUserCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercode", (Object)PSDESPCodeBase.getJSONValue((Object)pSDESPCodeBase.getUserCode()), (boolean)false);
        }
        if (bl || pSDESPCodeBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDESPCodeBase.getJSONValue((Object)pSDESPCodeBase.getUserParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDESPCodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDESPCodeBase pSDESPCodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDESPCodeBase.getCompileFlag() != null) {
            object = pSDESPCodeBase.getCompileFlag();
            xmlNode.setAttribute(FIELD_COMPILEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESPCodeBase.getCreateDate() != null) {
            object = pSDESPCodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESPCodeBase.getCreateMan() != null) {
            object = pSDESPCodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodeBase.getFULLCode() != null) {
            object = pSDESPCodeBase.getFULLCode();
            xmlNode.setAttribute(FIELD_FULLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodeBase.getMemo() != null) {
            object = pSDESPCodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodeBase.getPSDEId() != null) {
            object = pSDESPCodeBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodeBase.getPSDESPCodeId() != null) {
            object = pSDESPCodeBase.getPSDESPCodeId();
            xmlNode.setAttribute(FIELD_PSDESPCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodeBase.getPSDESPCodeName() != null) {
            object = pSDESPCodeBase.getPSDESPCodeName();
            xmlNode.setAttribute(FIELD_PSDESPCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodeBase.getPSDESysProcId() != null) {
            object = pSDESPCodeBase.getPSDESysProcId();
            xmlNode.setAttribute(FIELD_PSDESYSPROCID, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodeBase.getPSDESysProcName() != null) {
            object = pSDESPCodeBase.getPSDESysProcName();
            xmlNode.setAttribute(FIELD_PSDESYSPROCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodeBase.getSYSPROCType() != null) {
            object = pSDESPCodeBase.getSYSPROCType();
            xmlNode.setAttribute(FIELD_SYSPROCTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodeBase.getUpdateDate() != null) {
            object = pSDESPCodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESPCodeBase.getUpdateMan() != null) {
            object = pSDESPCodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodeBase.getUserCode() != null) {
            object = pSDESPCodeBase.getUserCode();
            xmlNode.setAttribute(FIELD_USERCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodeBase.getUserParams() != null) {
            object = pSDESPCodeBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDESPCodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDESPCodeBase pSDESPCodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDESPCodeBase.isCompileFlagDirty() && (bl || pSDESPCodeBase.getCompileFlag() != null)) {
            iDataObject.set(FIELD_COMPILEFLAG, (Object)pSDESPCodeBase.getCompileFlag());
        }
        if (pSDESPCodeBase.isCreateDateDirty() && (bl || pSDESPCodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDESPCodeBase.getCreateDate());
        }
        if (pSDESPCodeBase.isCreateManDirty() && (bl || pSDESPCodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDESPCodeBase.getCreateMan());
        }
        if (pSDESPCodeBase.isFULLCodeDirty() && (bl || pSDESPCodeBase.getFULLCode() != null)) {
            iDataObject.set(FIELD_FULLCODE, (Object)pSDESPCodeBase.getFULLCode());
        }
        if (pSDESPCodeBase.isMemoDirty() && (bl || pSDESPCodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDESPCodeBase.getMemo());
        }
        if (pSDESPCodeBase.isPSDEIdDirty() && (bl || pSDESPCodeBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDESPCodeBase.getPSDEId());
        }
        if (pSDESPCodeBase.isPSDESPCodeIdDirty() && (bl || pSDESPCodeBase.getPSDESPCodeId() != null)) {
            iDataObject.set(FIELD_PSDESPCODEID, (Object)pSDESPCodeBase.getPSDESPCodeId());
        }
        if (pSDESPCodeBase.isPSDESPCodeNameDirty() && (bl || pSDESPCodeBase.getPSDESPCodeName() != null)) {
            iDataObject.set(FIELD_PSDESPCODENAME, (Object)pSDESPCodeBase.getPSDESPCodeName());
        }
        if (pSDESPCodeBase.isPSDESysProcIdDirty() && (bl || pSDESPCodeBase.getPSDESysProcId() != null)) {
            iDataObject.set(FIELD_PSDESYSPROCID, (Object)pSDESPCodeBase.getPSDESysProcId());
        }
        if (pSDESPCodeBase.isPSDESysProcNameDirty() && (bl || pSDESPCodeBase.getPSDESysProcName() != null)) {
            iDataObject.set(FIELD_PSDESYSPROCNAME, (Object)pSDESPCodeBase.getPSDESysProcName());
        }
        if (pSDESPCodeBase.isSYSPROCTypeDirty() && (bl || pSDESPCodeBase.getSYSPROCType() != null)) {
            iDataObject.set(FIELD_SYSPROCTYPE, (Object)pSDESPCodeBase.getSYSPROCType());
        }
        if (pSDESPCodeBase.isUpdateDateDirty() && (bl || pSDESPCodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDESPCodeBase.getUpdateDate());
        }
        if (pSDESPCodeBase.isUpdateManDirty() && (bl || pSDESPCodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDESPCodeBase.getUpdateMan());
        }
        if (pSDESPCodeBase.isUserCodeDirty() && (bl || pSDESPCodeBase.getUserCode() != null)) {
            iDataObject.set(FIELD_USERCODE, (Object)pSDESPCodeBase.getUserCode());
        }
        if (pSDESPCodeBase.isUserParamsDirty() && (bl || pSDESPCodeBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDESPCodeBase.getUserParams());
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
        return PSDESPCodeBase.remove(this, n);
    }

    private static boolean remove(PSDESPCodeBase pSDESPCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDESPCodeBase.resetCompileFlag();
                return true;
            }
            case 1: {
                pSDESPCodeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDESPCodeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDESPCodeBase.resetFULLCode();
                return true;
            }
            case 4: {
                pSDESPCodeBase.resetMemo();
                return true;
            }
            case 5: {
                pSDESPCodeBase.resetPSDEId();
                return true;
            }
            case 6: {
                pSDESPCodeBase.resetPSDESPCodeId();
                return true;
            }
            case 7: {
                pSDESPCodeBase.resetPSDESPCodeName();
                return true;
            }
            case 8: {
                pSDESPCodeBase.resetPSDESysProcId();
                return true;
            }
            case 9: {
                pSDESPCodeBase.resetPSDESysProcName();
                return true;
            }
            case 10: {
                pSDESPCodeBase.resetSYSPROCType();
                return true;
            }
            case 11: {
                pSDESPCodeBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDESPCodeBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSDESPCodeBase.resetUserCode();
                return true;
            }
            case 14: {
                pSDESPCodeBase.resetUserParams();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDESysProc getPsdesysproc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsdesysproc();
        }
        if (this.getPSDESysProcId() == null) {
            return null;
        }
        Integer n = this.objPsdesysprocLock;
        synchronized (n) {
            if (this.psdesysproc != null && DataTypeHelper.compare((int)25, (Object)this.getPSDESysProcId(), (Object)this.psdesysproc.getPSDESysProcId()) != 0L) {
                this.psdesysproc = null;
            }
            if (this.psdesysproc == null) {
                PSDESysProc pSDESysProc = new PSDESysProc();
                pSDESysProc.setPSDESysProcId(this.getPSDESysProcId());
                PSDESysProcService pSDESysProcService = (PSDESysProcService)ServiceGlobal.getService(PSDESysProcService.class, (SessionFactory)this.getSessionFactory());
                pSDESysProcService.autoGet(pSDESysProc);
                this.psdesysproc = pSDESysProc;
            }
            return this.psdesysproc;
        }
    }

    private PSDESPCodeBase getProxyEntity() {
        return this.proxyPSDESPCodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDESPCodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDESPCodeBase) {
            this.proxyPSDESPCodeBase = (PSDESPCodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESPCodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_COMPILEFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FULLCODE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEID, 5);
        fieldIndexMap.put(FIELD_PSDESPCODEID, 6);
        fieldIndexMap.put(FIELD_PSDESPCODENAME, 7);
        fieldIndexMap.put(FIELD_PSDESYSPROCID, 8);
        fieldIndexMap.put(FIELD_PSDESYSPROCNAME, 9);
        fieldIndexMap.put(FIELD_SYSPROCTYPE, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_USERCODE, 13);
        fieldIndexMap.put(FIELD_USERPARAMS, 14);
    }
}

