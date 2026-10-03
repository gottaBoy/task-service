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
import net.ibizsys.pscore.srv.dedesign.entity.PSDESPCode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESysProc;
import net.ibizsys.pscore.srv.dedesign.service.PSDESPCodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESysProcService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESPCodePartBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDESPCodePartBase.class);
    public static final String FIELD_CODEPART = "CODEPART";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DANGERCODE = "DANGERCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDESPCODEID = "PSDESPCODEID";
    public static final String FIELD_PSDESPCODENAME = "PSDESPCODENAME";
    public static final String FIELD_PSDESPCODEPARTID = "PSDESPCODEPARTID";
    public static final String FIELD_PSDESPCODEPARTNAME = "PSDESPCODEPARTNAME";
    public static final String FIELD_PSDESYSPROCID = "PSDESYSPROCID";
    public static final String FIELD_PSDESYSPROCNAME = "PSDESYSPROCNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODEPART = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DANGERCODE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSDESPCODEID = 6;
    private static final int INDEX_PSDESPCODENAME = 7;
    private static final int INDEX_PSDESPCODEPARTID = 8;
    private static final int INDEX_PSDESPCODEPARTNAME = 9;
    private static final int INDEX_PSDESYSPROCID = 10;
    private static final int INDEX_PSDESYSPROCNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDESPCodePartBase proxyPSDESPCodePartBase = null;
    private boolean codepartDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dangercodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdespcodeidDirtyFlag = false;
    private boolean psdespcodenameDirtyFlag = false;
    private boolean psdespcodepartidDirtyFlag = false;
    private boolean psdespcodepartnameDirtyFlag = false;
    private boolean psdesysprocidDirtyFlag = false;
    private boolean psdesysprocnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codepart")
    private String codepart;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dangercode")
    private Integer dangercode;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdespcodeid")
    private String psdespcodeid;
    @Column(name="psdespcodename")
    private String psdespcodename;
    @Column(name="psdespcodepartid")
    private String psdespcodepartid;
    @Column(name="psdespcodepartname")
    private String psdespcodepartname;
    @Column(name="psdesysprocid")
    private String psdesysprocid;
    @Column(name="psdesysprocname")
    private String psdesysprocname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPsdespcodeLock = new Integer(1);
    private PSDESPCode psdespcode = null;
    private Integer objPsdesysprocLock = new Integer(1);
    private PSDESysProc psdesysproc = null;

    public void setCodePART(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodePART(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codepart = string;
        this.codepartDirtyFlag = true;
    }

    public String getCodePART() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodePART();
        }
        return this.codepart;
    }

    public boolean isCodePARTDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodePARTDirty();
        }
        return this.codepartDirtyFlag;
    }

    public void resetCodePART() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodePART();
            return;
        }
        this.codepartDirtyFlag = false;
        this.codepart = null;
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

    public void setDangerCode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDangerCode(n);
            return;
        }
        this.dangercode = n;
        this.dangercodeDirtyFlag = true;
    }

    public Integer getDangerCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDangerCode();
        }
        return this.dangercode;
    }

    public boolean isDangerCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDangerCodeDirty();
        }
        return this.dangercodeDirtyFlag;
    }

    public void resetDangerCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDangerCode();
            return;
        }
        this.dangercodeDirtyFlag = false;
        this.dangercode = null;
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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
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

    public void setPSDESPCodePartId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESPCodePartId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdespcodepartid = string;
        this.psdespcodepartidDirtyFlag = true;
    }

    public String getPSDESPCodePartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESPCodePartId();
        }
        return this.psdespcodepartid;
    }

    public boolean isPSDESPCodePartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESPCodePartIdDirty();
        }
        return this.psdespcodepartidDirtyFlag;
    }

    public void resetPSDESPCodePartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESPCodePartId();
            return;
        }
        this.psdespcodepartidDirtyFlag = false;
        this.psdespcodepartid = null;
    }

    public void setPSDESPCodePartName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESPCodePartName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdespcodepartname = string;
        this.psdespcodepartnameDirtyFlag = true;
    }

    public String getPSDESPCodePartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESPCodePartName();
        }
        return this.psdespcodepartname;
    }

    public boolean isPSDESPCodePartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESPCodePartNameDirty();
        }
        return this.psdespcodepartnameDirtyFlag;
    }

    public void resetPSDESPCodePartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESPCodePartName();
            return;
        }
        this.psdespcodepartnameDirtyFlag = false;
        this.psdespcodepartname = null;
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
        PSDESPCodePartBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDESPCodePartBase pSDESPCodePartBase) {
        pSDESPCodePartBase.resetCodePART();
        pSDESPCodePartBase.resetCreateDate();
        pSDESPCodePartBase.resetCreateMan();
        pSDESPCodePartBase.resetDangerCode();
        pSDESPCodePartBase.resetMemo();
        pSDESPCodePartBase.resetOrderValue();
        pSDESPCodePartBase.resetPSDESPCodeId();
        pSDESPCodePartBase.resetPSDESPCodeName();
        pSDESPCodePartBase.resetPSDESPCodePartId();
        pSDESPCodePartBase.resetPSDESPCodePartName();
        pSDESPCodePartBase.resetPSDESysProcId();
        pSDESPCodePartBase.resetPSDESysProcName();
        pSDESPCodePartBase.resetUpdateDate();
        pSDESPCodePartBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodePARTDirty()) {
            hashMap.put(FIELD_CODEPART, this.getCodePART());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDangerCodeDirty()) {
            hashMap.put(FIELD_DANGERCODE, this.getDangerCode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDESPCodeIdDirty()) {
            hashMap.put(FIELD_PSDESPCODEID, this.getPSDESPCodeId());
        }
        if (!bl || this.isPSDESPCodeNameDirty()) {
            hashMap.put(FIELD_PSDESPCODENAME, this.getPSDESPCodeName());
        }
        if (!bl || this.isPSDESPCodePartIdDirty()) {
            hashMap.put(FIELD_PSDESPCODEPARTID, this.getPSDESPCodePartId());
        }
        if (!bl || this.isPSDESPCodePartNameDirty()) {
            hashMap.put(FIELD_PSDESPCODEPARTNAME, this.getPSDESPCodePartName());
        }
        if (!bl || this.isPSDESysProcIdDirty()) {
            hashMap.put(FIELD_PSDESYSPROCID, this.getPSDESysProcId());
        }
        if (!bl || this.isPSDESysProcNameDirty()) {
            hashMap.put(FIELD_PSDESYSPROCNAME, this.getPSDESysProcName());
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
        return PSDESPCodePartBase.get(this, n);
    }

    private static Object get(PSDESPCodePartBase pSDESPCodePartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESPCodePartBase.getCodePART();
            }
            case 1: {
                return pSDESPCodePartBase.getCreateDate();
            }
            case 2: {
                return pSDESPCodePartBase.getCreateMan();
            }
            case 3: {
                return pSDESPCodePartBase.getDangerCode();
            }
            case 4: {
                return pSDESPCodePartBase.getMemo();
            }
            case 5: {
                return pSDESPCodePartBase.getOrderValue();
            }
            case 6: {
                return pSDESPCodePartBase.getPSDESPCodeId();
            }
            case 7: {
                return pSDESPCodePartBase.getPSDESPCodeName();
            }
            case 8: {
                return pSDESPCodePartBase.getPSDESPCodePartId();
            }
            case 9: {
                return pSDESPCodePartBase.getPSDESPCodePartName();
            }
            case 10: {
                return pSDESPCodePartBase.getPSDESysProcId();
            }
            case 11: {
                return pSDESPCodePartBase.getPSDESysProcName();
            }
            case 12: {
                return pSDESPCodePartBase.getUpdateDate();
            }
            case 13: {
                return pSDESPCodePartBase.getUpdateMan();
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
        PSDESPCodePartBase.set(this, n, object);
    }

    private static void set(PSDESPCodePartBase pSDESPCodePartBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDESPCodePartBase.setCodePART(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDESPCodePartBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDESPCodePartBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDESPCodePartBase.setDangerCode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDESPCodePartBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDESPCodePartBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDESPCodePartBase.setPSDESPCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDESPCodePartBase.setPSDESPCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDESPCodePartBase.setPSDESPCodePartId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDESPCodePartBase.setPSDESPCodePartName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDESPCodePartBase.setPSDESysProcId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDESPCodePartBase.setPSDESysProcName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDESPCodePartBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDESPCodePartBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDESPCodePartBase.isNull(this, n);
    }

    private static boolean isNull(PSDESPCodePartBase pSDESPCodePartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESPCodePartBase.getCodePART() == null;
            }
            case 1: {
                return pSDESPCodePartBase.getCreateDate() == null;
            }
            case 2: {
                return pSDESPCodePartBase.getCreateMan() == null;
            }
            case 3: {
                return pSDESPCodePartBase.getDangerCode() == null;
            }
            case 4: {
                return pSDESPCodePartBase.getMemo() == null;
            }
            case 5: {
                return pSDESPCodePartBase.getOrderValue() == null;
            }
            case 6: {
                return pSDESPCodePartBase.getPSDESPCodeId() == null;
            }
            case 7: {
                return pSDESPCodePartBase.getPSDESPCodeName() == null;
            }
            case 8: {
                return pSDESPCodePartBase.getPSDESPCodePartId() == null;
            }
            case 9: {
                return pSDESPCodePartBase.getPSDESPCodePartName() == null;
            }
            case 10: {
                return pSDESPCodePartBase.getPSDESysProcId() == null;
            }
            case 11: {
                return pSDESPCodePartBase.getPSDESysProcName() == null;
            }
            case 12: {
                return pSDESPCodePartBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDESPCodePartBase.getUpdateMan() == null;
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
        return PSDESPCodePartBase.contains(this, n);
    }

    private static boolean contains(PSDESPCodePartBase pSDESPCodePartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESPCodePartBase.isCodePARTDirty();
            }
            case 1: {
                return pSDESPCodePartBase.isCreateDateDirty();
            }
            case 2: {
                return pSDESPCodePartBase.isCreateManDirty();
            }
            case 3: {
                return pSDESPCodePartBase.isDangerCodeDirty();
            }
            case 4: {
                return pSDESPCodePartBase.isMemoDirty();
            }
            case 5: {
                return pSDESPCodePartBase.isOrderValueDirty();
            }
            case 6: {
                return pSDESPCodePartBase.isPSDESPCodeIdDirty();
            }
            case 7: {
                return pSDESPCodePartBase.isPSDESPCodeNameDirty();
            }
            case 8: {
                return pSDESPCodePartBase.isPSDESPCodePartIdDirty();
            }
            case 9: {
                return pSDESPCodePartBase.isPSDESPCodePartNameDirty();
            }
            case 10: {
                return pSDESPCodePartBase.isPSDESysProcIdDirty();
            }
            case 11: {
                return pSDESPCodePartBase.isPSDESysProcNameDirty();
            }
            case 12: {
                return pSDESPCodePartBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDESPCodePartBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDESPCodePartBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDESPCodePartBase pSDESPCodePartBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDESPCodePartBase.getCodePART() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codepart", (Object)PSDESPCodePartBase.getJSONValue((Object)pSDESPCodePartBase.getCodePART()), (boolean)false);
        }
        if (bl || pSDESPCodePartBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDESPCodePartBase.getJSONValue((Object)pSDESPCodePartBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDESPCodePartBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDESPCodePartBase.getJSONValue((Object)pSDESPCodePartBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDESPCodePartBase.getDangerCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dangercode", (Object)PSDESPCodePartBase.getJSONValue((Object)pSDESPCodePartBase.getDangerCode()), (boolean)false);
        }
        if (bl || pSDESPCodePartBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDESPCodePartBase.getJSONValue((Object)pSDESPCodePartBase.getMemo()), (boolean)false);
        }
        if (bl || pSDESPCodePartBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDESPCodePartBase.getJSONValue((Object)pSDESPCodePartBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDESPCodePartBase.getPSDESPCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdespcodeid", (Object)PSDESPCodePartBase.getJSONValue((Object)pSDESPCodePartBase.getPSDESPCodeId()), (boolean)false);
        }
        if (bl || pSDESPCodePartBase.getPSDESPCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdespcodename", (Object)PSDESPCodePartBase.getJSONValue((Object)pSDESPCodePartBase.getPSDESPCodeName()), (boolean)false);
        }
        if (bl || pSDESPCodePartBase.getPSDESPCodePartId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdespcodepartid", (Object)PSDESPCodePartBase.getJSONValue((Object)pSDESPCodePartBase.getPSDESPCodePartId()), (boolean)false);
        }
        if (bl || pSDESPCodePartBase.getPSDESPCodePartName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdespcodepartname", (Object)PSDESPCodePartBase.getJSONValue((Object)pSDESPCodePartBase.getPSDESPCodePartName()), (boolean)false);
        }
        if (bl || pSDESPCodePartBase.getPSDESysProcId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesysprocid", (Object)PSDESPCodePartBase.getJSONValue((Object)pSDESPCodePartBase.getPSDESysProcId()), (boolean)false);
        }
        if (bl || pSDESPCodePartBase.getPSDESysProcName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesysprocname", (Object)PSDESPCodePartBase.getJSONValue((Object)pSDESPCodePartBase.getPSDESysProcName()), (boolean)false);
        }
        if (bl || pSDESPCodePartBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDESPCodePartBase.getJSONValue((Object)pSDESPCodePartBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDESPCodePartBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDESPCodePartBase.getJSONValue((Object)pSDESPCodePartBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDESPCodePartBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDESPCodePartBase pSDESPCodePartBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDESPCodePartBase.getCodePART() != null) {
            object = pSDESPCodePartBase.getCodePART();
            xmlNode.setAttribute(FIELD_CODEPART, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodePartBase.getCreateDate() != null) {
            object = pSDESPCodePartBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESPCodePartBase.getCreateMan() != null) {
            object = pSDESPCodePartBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodePartBase.getDangerCode() != null) {
            object = pSDESPCodePartBase.getDangerCode();
            xmlNode.setAttribute(FIELD_DANGERCODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESPCodePartBase.getMemo() != null) {
            object = pSDESPCodePartBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodePartBase.getOrderValue() != null) {
            object = pSDESPCodePartBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESPCodePartBase.getPSDESPCodeId() != null) {
            object = pSDESPCodePartBase.getPSDESPCodeId();
            xmlNode.setAttribute(FIELD_PSDESPCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodePartBase.getPSDESPCodeName() != null) {
            object = pSDESPCodePartBase.getPSDESPCodeName();
            xmlNode.setAttribute(FIELD_PSDESPCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodePartBase.getPSDESPCodePartId() != null) {
            object = pSDESPCodePartBase.getPSDESPCodePartId();
            xmlNode.setAttribute(FIELD_PSDESPCODEPARTID, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodePartBase.getPSDESPCodePartName() != null) {
            object = pSDESPCodePartBase.getPSDESPCodePartName();
            xmlNode.setAttribute(FIELD_PSDESPCODEPARTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodePartBase.getPSDESysProcId() != null) {
            object = pSDESPCodePartBase.getPSDESysProcId();
            xmlNode.setAttribute(FIELD_PSDESYSPROCID, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodePartBase.getPSDESysProcName() != null) {
            object = pSDESPCodePartBase.getPSDESysProcName();
            xmlNode.setAttribute(FIELD_PSDESYSPROCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESPCodePartBase.getUpdateDate() != null) {
            object = pSDESPCodePartBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESPCodePartBase.getUpdateMan() != null) {
            object = pSDESPCodePartBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDESPCodePartBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDESPCodePartBase pSDESPCodePartBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDESPCodePartBase.isCodePARTDirty() && (bl || pSDESPCodePartBase.getCodePART() != null)) {
            iDataObject.set(FIELD_CODEPART, (Object)pSDESPCodePartBase.getCodePART());
        }
        if (pSDESPCodePartBase.isCreateDateDirty() && (bl || pSDESPCodePartBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDESPCodePartBase.getCreateDate());
        }
        if (pSDESPCodePartBase.isCreateManDirty() && (bl || pSDESPCodePartBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDESPCodePartBase.getCreateMan());
        }
        if (pSDESPCodePartBase.isDangerCodeDirty() && (bl || pSDESPCodePartBase.getDangerCode() != null)) {
            iDataObject.set(FIELD_DANGERCODE, (Object)pSDESPCodePartBase.getDangerCode());
        }
        if (pSDESPCodePartBase.isMemoDirty() && (bl || pSDESPCodePartBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDESPCodePartBase.getMemo());
        }
        if (pSDESPCodePartBase.isOrderValueDirty() && (bl || pSDESPCodePartBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDESPCodePartBase.getOrderValue());
        }
        if (pSDESPCodePartBase.isPSDESPCodeIdDirty() && (bl || pSDESPCodePartBase.getPSDESPCodeId() != null)) {
            iDataObject.set(FIELD_PSDESPCODEID, (Object)pSDESPCodePartBase.getPSDESPCodeId());
        }
        if (pSDESPCodePartBase.isPSDESPCodeNameDirty() && (bl || pSDESPCodePartBase.getPSDESPCodeName() != null)) {
            iDataObject.set(FIELD_PSDESPCODENAME, (Object)pSDESPCodePartBase.getPSDESPCodeName());
        }
        if (pSDESPCodePartBase.isPSDESPCodePartIdDirty() && (bl || pSDESPCodePartBase.getPSDESPCodePartId() != null)) {
            iDataObject.set(FIELD_PSDESPCODEPARTID, (Object)pSDESPCodePartBase.getPSDESPCodePartId());
        }
        if (pSDESPCodePartBase.isPSDESPCodePartNameDirty() && (bl || pSDESPCodePartBase.getPSDESPCodePartName() != null)) {
            iDataObject.set(FIELD_PSDESPCODEPARTNAME, (Object)pSDESPCodePartBase.getPSDESPCodePartName());
        }
        if (pSDESPCodePartBase.isPSDESysProcIdDirty() && (bl || pSDESPCodePartBase.getPSDESysProcId() != null)) {
            iDataObject.set(FIELD_PSDESYSPROCID, (Object)pSDESPCodePartBase.getPSDESysProcId());
        }
        if (pSDESPCodePartBase.isPSDESysProcNameDirty() && (bl || pSDESPCodePartBase.getPSDESysProcName() != null)) {
            iDataObject.set(FIELD_PSDESYSPROCNAME, (Object)pSDESPCodePartBase.getPSDESysProcName());
        }
        if (pSDESPCodePartBase.isUpdateDateDirty() && (bl || pSDESPCodePartBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDESPCodePartBase.getUpdateDate());
        }
        if (pSDESPCodePartBase.isUpdateManDirty() && (bl || pSDESPCodePartBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDESPCodePartBase.getUpdateMan());
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
        return PSDESPCodePartBase.remove(this, n);
    }

    private static boolean remove(PSDESPCodePartBase pSDESPCodePartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDESPCodePartBase.resetCodePART();
                return true;
            }
            case 1: {
                pSDESPCodePartBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDESPCodePartBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDESPCodePartBase.resetDangerCode();
                return true;
            }
            case 4: {
                pSDESPCodePartBase.resetMemo();
                return true;
            }
            case 5: {
                pSDESPCodePartBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSDESPCodePartBase.resetPSDESPCodeId();
                return true;
            }
            case 7: {
                pSDESPCodePartBase.resetPSDESPCodeName();
                return true;
            }
            case 8: {
                pSDESPCodePartBase.resetPSDESPCodePartId();
                return true;
            }
            case 9: {
                pSDESPCodePartBase.resetPSDESPCodePartName();
                return true;
            }
            case 10: {
                pSDESPCodePartBase.resetPSDESysProcId();
                return true;
            }
            case 11: {
                pSDESPCodePartBase.resetPSDESysProcName();
                return true;
            }
            case 12: {
                pSDESPCodePartBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDESPCodePartBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDESPCode getPsdespcode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsdespcode();
        }
        if (this.getPSDESPCodeId() == null) {
            return null;
        }
        Integer n = this.objPsdespcodeLock;
        synchronized (n) {
            if (this.psdespcode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDESPCodeId(), (Object)this.psdespcode.getPSDESPCodeId()) != 0L) {
                this.psdespcode = null;
            }
            if (this.psdespcode == null) {
                PSDESPCode pSDESPCode = new PSDESPCode();
                pSDESPCode.setPSDESPCodeId(this.getPSDESPCodeId());
                PSDESPCodeService pSDESPCodeService = (PSDESPCodeService)ServiceGlobal.getService(PSDESPCodeService.class, (SessionFactory)this.getSessionFactory());
                pSDESPCodeService.autoGet(pSDESPCode);
                this.psdespcode = pSDESPCode;
            }
            return this.psdespcode;
        }
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

    private PSDESPCodePartBase getProxyEntity() {
        return this.proxyPSDESPCodePartBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDESPCodePartBase = null;
        if (iDataObject != null && iDataObject instanceof PSDESPCodePartBase) {
            this.proxyPSDESPCodePartBase = (PSDESPCodePartBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESPCodePartService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODEPART, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DANGERCODE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PSDESPCODEID, 6);
        fieldIndexMap.put(FIELD_PSDESPCODENAME, 7);
        fieldIndexMap.put(FIELD_PSDESPCODEPARTID, 8);
        fieldIndexMap.put(FIELD_PSDESPCODEPARTNAME, 9);
        fieldIndexMap.put(FIELD_PSDESYSPROCID, 10);
        fieldIndexMap.put(FIELD_PSDESYSPROCNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

