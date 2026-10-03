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
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelAPI;
import net.ibizsys.pscore.srv.config.entity.PSModelField;
import net.ibizsys.pscore.srv.config.service.PSModelAPIService;
import net.ibizsys.pscore.srv.config.service.PSModelFieldService;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelFuncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelFuncBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FUNCDESC = "FUNCDESC";
    public static final String FIELD_FUNCSN = "FUNCSN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODELAPIID = "PSMODELAPIID";
    public static final String FIELD_PSMODELAPINAME = "PSMODELAPINAME";
    public static final String FIELD_PSMODELFIELDID = "PSMODELFIELDID";
    public static final String FIELD_PSMODELFIELDNAME = "PSMODELFIELDNAME";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_PSSYSMODELFUNCID = "PSSYSMODELFUNCID";
    public static final String FIELD_PSSYSMODELFUNCNAME = "PSSYSMODELFUNCNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_FUNCDESC = 2;
    private static final int INDEX_FUNCSN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSMODELAPIID = 6;
    private static final int INDEX_PSMODELAPINAME = 7;
    private static final int INDEX_PSMODELFIELDID = 8;
    private static final int INDEX_PSMODELFIELDNAME = 9;
    private static final int INDEX_PSMODELID = 10;
    private static final int INDEX_PSMODELNAME = 11;
    private static final int INDEX_PSSYSMODELFUNCID = 12;
    private static final int INDEX_PSSYSMODELFUNCNAME = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_VALIDFLAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelFuncBase proxyPSSysModelFuncBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean funcdescDirtyFlag = false;
    private boolean funcsnDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmodelapiidDirtyFlag = false;
    private boolean psmodelapinameDirtyFlag = false;
    private boolean psmodelfieldidDirtyFlag = false;
    private boolean psmodelfieldnameDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean pssysmodelfuncidDirtyFlag = false;
    private boolean pssysmodelfuncnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="funcdesc")
    private String funcdesc;
    @Column(name="funcsn")
    private String funcsn;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmodelapiid")
    private String psmodelapiid;
    @Column(name="psmodelapiname")
    private String psmodelapiname;
    @Column(name="psmodelfieldid")
    private String psmodelfieldid;
    @Column(name="psmodelfieldname")
    private String psmodelfieldname;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="pssysmodelfuncid")
    private String pssysmodelfuncid;
    @Column(name="pssysmodelfuncname")
    private String pssysmodelfuncname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSModelApiLock = new Integer(1);
    private PSModelAPI psmodelapi = null;
    private Integer objPSModelFieldLock = new Integer(1);
    private PSModelField psmodelfield = null;
    private Integer objPSModelLock = new Integer(1);
    private PSModel psmodel = null;

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

    public void setFuncDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funcdesc = string;
        this.funcdescDirtyFlag = true;
    }

    public String getFuncDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncDesc();
        }
        return this.funcdesc;
    }

    public boolean isFuncDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncDescDirty();
        }
        return this.funcdescDirtyFlag;
    }

    public void resetFuncDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncDesc();
            return;
        }
        this.funcdescDirtyFlag = false;
        this.funcdesc = null;
    }

    public void setFuncSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFuncSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.funcsn = string;
        this.funcsnDirtyFlag = true;
    }

    public String getFuncSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFuncSN();
        }
        return this.funcsn;
    }

    public boolean isFuncSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFuncSNDirty();
        }
        return this.funcsnDirtyFlag;
    }

    public void resetFuncSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFuncSN();
            return;
        }
        this.funcsnDirtyFlag = false;
        this.funcsn = null;
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

    public void setPSModelAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapiid = string;
        this.psmodelapiidDirtyFlag = true;
    }

    public String getPSModelAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIId();
        }
        return this.psmodelapiid;
    }

    public boolean isPSModelAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPIIdDirty();
        }
        return this.psmodelapiidDirtyFlag;
    }

    public void resetPSModelAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIId();
            return;
        }
        this.psmodelapiidDirtyFlag = false;
        this.psmodelapiid = null;
    }

    public void setPSModelAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapiname = string;
        this.psmodelapinameDirtyFlag = true;
    }

    public String getPSModelAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIName();
        }
        return this.psmodelapiname;
    }

    public boolean isPSModelAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPINameDirty();
        }
        return this.psmodelapinameDirtyFlag;
    }

    public void resetPSModelAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIName();
            return;
        }
        this.psmodelapinameDirtyFlag = false;
        this.psmodelapiname = null;
    }

    public void setPSModelFieldId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelFieldId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelfieldid = string;
        this.psmodelfieldidDirtyFlag = true;
    }

    public String getPSModelFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelFieldId();
        }
        return this.psmodelfieldid;
    }

    public boolean isPSModelFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelFieldIdDirty();
        }
        return this.psmodelfieldidDirtyFlag;
    }

    public void resetPSModelFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelFieldId();
            return;
        }
        this.psmodelfieldidDirtyFlag = false;
        this.psmodelfieldid = null;
    }

    public void setPSModelFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelfieldname = string;
        this.psmodelfieldnameDirtyFlag = true;
    }

    public String getPSModelFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelFieldName();
        }
        return this.psmodelfieldname;
    }

    public boolean isPSModelFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelFieldNameDirty();
        }
        return this.psmodelfieldnameDirtyFlag;
    }

    public void resetPSModelFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelFieldName();
            return;
        }
        this.psmodelfieldnameDirtyFlag = false;
        this.psmodelfieldname = null;
    }

    public void setPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelid = string;
        this.psmodelidDirtyFlag = true;
    }

    public String getPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelId();
        }
        return this.psmodelid;
    }

    public boolean isPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelIdDirty();
        }
        return this.psmodelidDirtyFlag;
    }

    public void resetPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelId();
            return;
        }
        this.psmodelidDirtyFlag = false;
        this.psmodelid = null;
    }

    public void setPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelname = string;
        this.psmodelnameDirtyFlag = true;
    }

    public String getPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelName();
        }
        return this.psmodelname;
    }

    public boolean isPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelNameDirty();
        }
        return this.psmodelnameDirtyFlag;
    }

    public void resetPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelName();
            return;
        }
        this.psmodelnameDirtyFlag = false;
        this.psmodelname = null;
    }

    public void setPSSysModelFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelfuncid = string;
        this.pssysmodelfuncidDirtyFlag = true;
    }

    public String getPSSysModelFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelFuncId();
        }
        return this.pssysmodelfuncid;
    }

    public boolean isPSSysModelFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelFuncIdDirty();
        }
        return this.pssysmodelfuncidDirtyFlag;
    }

    public void resetPSSysModelFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelFuncId();
            return;
        }
        this.pssysmodelfuncidDirtyFlag = false;
        this.pssysmodelfuncid = null;
    }

    public void setPSSysModelFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelfuncname = string;
        this.pssysmodelfuncnameDirtyFlag = true;
    }

    public String getPSSysModelFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelFuncName();
        }
        return this.pssysmodelfuncname;
    }

    public boolean isPSSysModelFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelFuncNameDirty();
        }
        return this.pssysmodelfuncnameDirtyFlag;
    }

    public void resetPSSysModelFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelFuncName();
            return;
        }
        this.pssysmodelfuncnameDirtyFlag = false;
        this.pssysmodelfuncname = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSSysModelFuncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelFuncBase pSSysModelFuncBase) {
        pSSysModelFuncBase.resetCreateDate();
        pSSysModelFuncBase.resetCreateMan();
        pSSysModelFuncBase.resetFuncDesc();
        pSSysModelFuncBase.resetFuncSN();
        pSSysModelFuncBase.resetMemo();
        pSSysModelFuncBase.resetOrderValue();
        pSSysModelFuncBase.resetPSModelAPIId();
        pSSysModelFuncBase.resetPSModelAPIName();
        pSSysModelFuncBase.resetPSModelFieldId();
        pSSysModelFuncBase.resetPSModelFieldName();
        pSSysModelFuncBase.resetPSModelId();
        pSSysModelFuncBase.resetPSModelName();
        pSSysModelFuncBase.resetPSSysModelFuncId();
        pSSysModelFuncBase.resetPSSysModelFuncName();
        pSSysModelFuncBase.resetUpdateDate();
        pSSysModelFuncBase.resetUpdateMan();
        pSSysModelFuncBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFuncDescDirty()) {
            hashMap.put(FIELD_FUNCDESC, this.getFuncDesc());
        }
        if (!bl || this.isFuncSNDirty()) {
            hashMap.put(FIELD_FUNCSN, this.getFuncSN());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSModelAPIIdDirty()) {
            hashMap.put(FIELD_PSMODELAPIID, this.getPSModelAPIId());
        }
        if (!bl || this.isPSModelAPINameDirty()) {
            hashMap.put(FIELD_PSMODELAPINAME, this.getPSModelAPIName());
        }
        if (!bl || this.isPSModelFieldIdDirty()) {
            hashMap.put(FIELD_PSMODELFIELDID, this.getPSModelFieldId());
        }
        if (!bl || this.isPSModelFieldNameDirty()) {
            hashMap.put(FIELD_PSMODELFIELDNAME, this.getPSModelFieldName());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
        }
        if (!bl || this.isPSSysModelFuncIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELFUNCID, this.getPSSysModelFuncId());
        }
        if (!bl || this.isPSSysModelFuncNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELFUNCNAME, this.getPSSysModelFuncName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSSysModelFuncBase.get(this, n);
    }

    private static Object get(PSSysModelFuncBase pSSysModelFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelFuncBase.getCreateDate();
            }
            case 1: {
                return pSSysModelFuncBase.getCreateMan();
            }
            case 2: {
                return pSSysModelFuncBase.getFuncDesc();
            }
            case 3: {
                return pSSysModelFuncBase.getFuncSN();
            }
            case 4: {
                return pSSysModelFuncBase.getMemo();
            }
            case 5: {
                return pSSysModelFuncBase.getOrderValue();
            }
            case 6: {
                return pSSysModelFuncBase.getPSModelAPIId();
            }
            case 7: {
                return pSSysModelFuncBase.getPSModelAPIName();
            }
            case 8: {
                return pSSysModelFuncBase.getPSModelFieldId();
            }
            case 9: {
                return pSSysModelFuncBase.getPSModelFieldName();
            }
            case 10: {
                return pSSysModelFuncBase.getPSModelId();
            }
            case 11: {
                return pSSysModelFuncBase.getPSModelName();
            }
            case 12: {
                return pSSysModelFuncBase.getPSSysModelFuncId();
            }
            case 13: {
                return pSSysModelFuncBase.getPSSysModelFuncName();
            }
            case 14: {
                return pSSysModelFuncBase.getUpdateDate();
            }
            case 15: {
                return pSSysModelFuncBase.getUpdateMan();
            }
            case 16: {
                return pSSysModelFuncBase.getValidFlag();
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
        PSSysModelFuncBase.set(this, n, object);
    }

    private static void set(PSSysModelFuncBase pSSysModelFuncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelFuncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelFuncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelFuncBase.setFuncDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelFuncBase.setFuncSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelFuncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelFuncBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelFuncBase.setPSModelAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelFuncBase.setPSModelAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelFuncBase.setPSModelFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelFuncBase.setPSModelFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysModelFuncBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysModelFuncBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysModelFuncBase.setPSSysModelFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysModelFuncBase.setPSSysModelFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysModelFuncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSSysModelFuncBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysModelFuncBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysModelFuncBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelFuncBase pSSysModelFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelFuncBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysModelFuncBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysModelFuncBase.getFuncDesc() == null;
            }
            case 3: {
                return pSSysModelFuncBase.getFuncSN() == null;
            }
            case 4: {
                return pSSysModelFuncBase.getMemo() == null;
            }
            case 5: {
                return pSSysModelFuncBase.getOrderValue() == null;
            }
            case 6: {
                return pSSysModelFuncBase.getPSModelAPIId() == null;
            }
            case 7: {
                return pSSysModelFuncBase.getPSModelAPIName() == null;
            }
            case 8: {
                return pSSysModelFuncBase.getPSModelFieldId() == null;
            }
            case 9: {
                return pSSysModelFuncBase.getPSModelFieldName() == null;
            }
            case 10: {
                return pSSysModelFuncBase.getPSModelId() == null;
            }
            case 11: {
                return pSSysModelFuncBase.getPSModelName() == null;
            }
            case 12: {
                return pSSysModelFuncBase.getPSSysModelFuncId() == null;
            }
            case 13: {
                return pSSysModelFuncBase.getPSSysModelFuncName() == null;
            }
            case 14: {
                return pSSysModelFuncBase.getUpdateDate() == null;
            }
            case 15: {
                return pSSysModelFuncBase.getUpdateMan() == null;
            }
            case 16: {
                return pSSysModelFuncBase.getValidFlag() == null;
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
        return PSSysModelFuncBase.contains(this, n);
    }

    private static boolean contains(PSSysModelFuncBase pSSysModelFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelFuncBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysModelFuncBase.isCreateManDirty();
            }
            case 2: {
                return pSSysModelFuncBase.isFuncDescDirty();
            }
            case 3: {
                return pSSysModelFuncBase.isFuncSNDirty();
            }
            case 4: {
                return pSSysModelFuncBase.isMemoDirty();
            }
            case 5: {
                return pSSysModelFuncBase.isOrderValueDirty();
            }
            case 6: {
                return pSSysModelFuncBase.isPSModelAPIIdDirty();
            }
            case 7: {
                return pSSysModelFuncBase.isPSModelAPINameDirty();
            }
            case 8: {
                return pSSysModelFuncBase.isPSModelFieldIdDirty();
            }
            case 9: {
                return pSSysModelFuncBase.isPSModelFieldNameDirty();
            }
            case 10: {
                return pSSysModelFuncBase.isPSModelIdDirty();
            }
            case 11: {
                return pSSysModelFuncBase.isPSModelNameDirty();
            }
            case 12: {
                return pSSysModelFuncBase.isPSSysModelFuncIdDirty();
            }
            case 13: {
                return pSSysModelFuncBase.isPSSysModelFuncNameDirty();
            }
            case 14: {
                return pSSysModelFuncBase.isUpdateDateDirty();
            }
            case 15: {
                return pSSysModelFuncBase.isUpdateManDirty();
            }
            case 16: {
                return pSSysModelFuncBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelFuncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelFuncBase pSSysModelFuncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelFuncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getFuncDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcdesc", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getFuncDesc()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getFuncSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcsn", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getFuncSN()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getPSModelAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapiid", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getPSModelAPIId()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getPSModelAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapiname", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getPSModelAPIName()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getPSModelFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelfieldid", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getPSModelFieldId()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getPSModelFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelfieldname", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getPSModelFieldName()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getPSSysModelFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelfuncid", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getPSSysModelFuncId()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getPSSysModelFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelfuncname", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getPSSysModelFuncName()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysModelFuncBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysModelFuncBase.getJSONValue((Object)pSSysModelFuncBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelFuncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelFuncBase pSSysModelFuncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelFuncBase.getCreateDate() != null) {
            object = pSSysModelFuncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelFuncBase.getCreateMan() != null) {
            object = pSSysModelFuncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncBase.getFuncDesc() != null) {
            object = pSSysModelFuncBase.getFuncDesc();
            xmlNode.setAttribute(FIELD_FUNCDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncBase.getFuncSN() != null) {
            object = pSSysModelFuncBase.getFuncSN();
            xmlNode.setAttribute(FIELD_FUNCSN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncBase.getMemo() != null) {
            object = pSSysModelFuncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncBase.getOrderValue() != null) {
            object = pSSysModelFuncBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelFuncBase.getPSModelAPIId() != null) {
            object = pSSysModelFuncBase.getPSModelAPIId();
            xmlNode.setAttribute(FIELD_PSMODELAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncBase.getPSModelAPIName() != null) {
            object = pSSysModelFuncBase.getPSModelAPIName();
            xmlNode.setAttribute(FIELD_PSMODELAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncBase.getPSModelFieldId() != null) {
            object = pSSysModelFuncBase.getPSModelFieldId();
            xmlNode.setAttribute(FIELD_PSMODELFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncBase.getPSModelFieldName() != null) {
            object = pSSysModelFuncBase.getPSModelFieldName();
            xmlNode.setAttribute(FIELD_PSMODELFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncBase.getPSModelId() != null) {
            object = pSSysModelFuncBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncBase.getPSModelName() != null) {
            object = pSSysModelFuncBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncBase.getPSSysModelFuncId() != null) {
            object = pSSysModelFuncBase.getPSSysModelFuncId();
            xmlNode.setAttribute(FIELD_PSSYSMODELFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncBase.getPSSysModelFuncName() != null) {
            object = pSSysModelFuncBase.getPSSysModelFuncName();
            xmlNode.setAttribute(FIELD_PSSYSMODELFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncBase.getUpdateDate() != null) {
            object = pSSysModelFuncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelFuncBase.getUpdateMan() != null) {
            object = pSSysModelFuncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelFuncBase.getValidFlag() != null) {
            object = pSSysModelFuncBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelFuncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelFuncBase pSSysModelFuncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelFuncBase.isCreateDateDirty() && (bl || pSSysModelFuncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelFuncBase.getCreateDate());
        }
        if (pSSysModelFuncBase.isCreateManDirty() && (bl || pSSysModelFuncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelFuncBase.getCreateMan());
        }
        if (pSSysModelFuncBase.isFuncDescDirty() && (bl || pSSysModelFuncBase.getFuncDesc() != null)) {
            iDataObject.set(FIELD_FUNCDESC, (Object)pSSysModelFuncBase.getFuncDesc());
        }
        if (pSSysModelFuncBase.isFuncSNDirty() && (bl || pSSysModelFuncBase.getFuncSN() != null)) {
            iDataObject.set(FIELD_FUNCSN, (Object)pSSysModelFuncBase.getFuncSN());
        }
        if (pSSysModelFuncBase.isMemoDirty() && (bl || pSSysModelFuncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysModelFuncBase.getMemo());
        }
        if (pSSysModelFuncBase.isOrderValueDirty() && (bl || pSSysModelFuncBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysModelFuncBase.getOrderValue());
        }
        if (pSSysModelFuncBase.isPSModelAPIIdDirty() && (bl || pSSysModelFuncBase.getPSModelAPIId() != null)) {
            iDataObject.set(FIELD_PSMODELAPIID, (Object)pSSysModelFuncBase.getPSModelAPIId());
        }
        if (pSSysModelFuncBase.isPSModelAPINameDirty() && (bl || pSSysModelFuncBase.getPSModelAPIName() != null)) {
            iDataObject.set(FIELD_PSMODELAPINAME, (Object)pSSysModelFuncBase.getPSModelAPIName());
        }
        if (pSSysModelFuncBase.isPSModelFieldIdDirty() && (bl || pSSysModelFuncBase.getPSModelFieldId() != null)) {
            iDataObject.set(FIELD_PSMODELFIELDID, (Object)pSSysModelFuncBase.getPSModelFieldId());
        }
        if (pSSysModelFuncBase.isPSModelFieldNameDirty() && (bl || pSSysModelFuncBase.getPSModelFieldName() != null)) {
            iDataObject.set(FIELD_PSMODELFIELDNAME, (Object)pSSysModelFuncBase.getPSModelFieldName());
        }
        if (pSSysModelFuncBase.isPSModelIdDirty() && (bl || pSSysModelFuncBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSSysModelFuncBase.getPSModelId());
        }
        if (pSSysModelFuncBase.isPSModelNameDirty() && (bl || pSSysModelFuncBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSSysModelFuncBase.getPSModelName());
        }
        if (pSSysModelFuncBase.isPSSysModelFuncIdDirty() && (bl || pSSysModelFuncBase.getPSSysModelFuncId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELFUNCID, (Object)pSSysModelFuncBase.getPSSysModelFuncId());
        }
        if (pSSysModelFuncBase.isPSSysModelFuncNameDirty() && (bl || pSSysModelFuncBase.getPSSysModelFuncName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELFUNCNAME, (Object)pSSysModelFuncBase.getPSSysModelFuncName());
        }
        if (pSSysModelFuncBase.isUpdateDateDirty() && (bl || pSSysModelFuncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelFuncBase.getUpdateDate());
        }
        if (pSSysModelFuncBase.isUpdateManDirty() && (bl || pSSysModelFuncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelFuncBase.getUpdateMan());
        }
        if (pSSysModelFuncBase.isValidFlagDirty() && (bl || pSSysModelFuncBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysModelFuncBase.getValidFlag());
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
        return PSSysModelFuncBase.remove(this, n);
    }

    private static boolean remove(PSSysModelFuncBase pSSysModelFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelFuncBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysModelFuncBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysModelFuncBase.resetFuncDesc();
                return true;
            }
            case 3: {
                pSSysModelFuncBase.resetFuncSN();
                return true;
            }
            case 4: {
                pSSysModelFuncBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysModelFuncBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSSysModelFuncBase.resetPSModelAPIId();
                return true;
            }
            case 7: {
                pSSysModelFuncBase.resetPSModelAPIName();
                return true;
            }
            case 8: {
                pSSysModelFuncBase.resetPSModelFieldId();
                return true;
            }
            case 9: {
                pSSysModelFuncBase.resetPSModelFieldName();
                return true;
            }
            case 10: {
                pSSysModelFuncBase.resetPSModelId();
                return true;
            }
            case 11: {
                pSSysModelFuncBase.resetPSModelName();
                return true;
            }
            case 12: {
                pSSysModelFuncBase.resetPSSysModelFuncId();
                return true;
            }
            case 13: {
                pSSysModelFuncBase.resetPSSysModelFuncName();
                return true;
            }
            case 14: {
                pSSysModelFuncBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSSysModelFuncBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSSysModelFuncBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelAPI getPSModelApi() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelApi();
        }
        if (this.getPSModelAPIId() == null) {
            return null;
        }
        Integer n = this.objPSModelApiLock;
        synchronized (n) {
            if (this.psmodelapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelAPIId(), (Object)this.psmodelapi.getPSModelAPIId()) != 0L) {
                this.psmodelapi = null;
            }
            if (this.psmodelapi == null) {
                PSModelAPI pSModelAPI = new PSModelAPI();
                pSModelAPI.setPSModelAPIId(this.getPSModelAPIId());
                PSModelAPIService pSModelAPIService = (PSModelAPIService)ServiceGlobal.getService(PSModelAPIService.class, (SessionFactory)this.getSessionFactory());
                pSModelAPIService.autoGet(pSModelAPI);
                this.psmodelapi = pSModelAPI;
            }
            return this.psmodelapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelField getPSModelField() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelField();
        }
        if (this.getPSModelFieldId() == null) {
            return null;
        }
        Integer n = this.objPSModelFieldLock;
        synchronized (n) {
            if (this.psmodelfield != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelFieldId(), (Object)this.psmodelfield.getPSModelFieldId()) != 0L) {
                this.psmodelfield = null;
            }
            if (this.psmodelfield == null) {
                PSModelField pSModelField = new PSModelField();
                pSModelField.setPSModelFieldId(this.getPSModelFieldId());
                PSModelFieldService pSModelFieldService = (PSModelFieldService)ServiceGlobal.getService(PSModelFieldService.class, (SessionFactory)this.getSessionFactory());
                pSModelFieldService.autoGet(pSModelField);
                this.psmodelfield = pSModelField;
            }
            return this.psmodelfield;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModel getPSModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModel();
        }
        if (this.getPSModelId() == null) {
            return null;
        }
        Integer n = this.objPSModelLock;
        synchronized (n) {
            if (this.psmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelId(), (Object)this.psmodel.getPSModelId()) != 0L) {
                this.psmodel = null;
            }
            if (this.psmodel == null) {
                PSModel pSModel = new PSModel();
                pSModel.setPSModelId(this.getPSModelId());
                PSModelService pSModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
                pSModelService.autoGet(pSModel);
                this.psmodel = pSModel;
            }
            return this.psmodel;
        }
    }

    private PSSysModelFuncBase getProxyEntity() {
        return this.proxyPSSysModelFuncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelFuncBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelFuncBase) {
            this.proxyPSSysModelFuncBase = (PSSysModelFuncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysModelFuncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_FUNCDESC, 2);
        fieldIndexMap.put(FIELD_FUNCSN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PSMODELAPIID, 6);
        fieldIndexMap.put(FIELD_PSMODELAPINAME, 7);
        fieldIndexMap.put(FIELD_PSMODELFIELDID, 8);
        fieldIndexMap.put(FIELD_PSMODELFIELDNAME, 9);
        fieldIndexMap.put(FIELD_PSMODELID, 10);
        fieldIndexMap.put(FIELD_PSMODELNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSMODELFUNCID, 12);
        fieldIndexMap.put(FIELD_PSSYSMODELFUNCNAME, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_VALIDFLAG, 16);
    }
}

