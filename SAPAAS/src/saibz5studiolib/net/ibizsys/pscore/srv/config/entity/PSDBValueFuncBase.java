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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBValueFuncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDBValueFuncBase.class);
    public static final String FIELD_ALLDCFLAG = "ALLDCFLAG";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FUNCSN = "FUNCSN";
    public static final String FIELD_INPUTSTDDATATYPE = "INPUTSTDDATATYPE";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_OUTPUTSTDDATATYPE = "OUTPUTSTDDATATYPE";
    public static final String FIELD_OUTPUTVALUEFORMAT = "OUTPUTVALUEFORMAT";
    public static final String FIELD_PSDBVALUEFUNCID = "PSDBVALUEFUNCID";
    public static final String FIELD_PSDBVALUEFUNCNAME = "PSDBVALUEFUNCNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UXCODENAME = "UXCODENAME";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLDCFLAG = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_FUNCSN = 4;
    private static final int INDEX_INPUTSTDDATATYPE = 5;
    private static final int INDEX_LOGICNAME = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_OUTPUTSTDDATATYPE = 9;
    private static final int INDEX_OUTPUTVALUEFORMAT = 10;
    private static final int INDEX_PSDBVALUEFUNCID = 11;
    private static final int INDEX_PSDBVALUEFUNCNAME = 12;
    private static final int INDEX_PSDEVCENTERID = 13;
    private static final int INDEX_PSDEVCENTERNAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_UXCODENAME = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDBValueFuncBase proxyPSDBValueFuncBase = null;
    private boolean alldcflagDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean funcsnDirtyFlag = false;
    private boolean inputstddatatypeDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean outputstddatatypeDirtyFlag = false;
    private boolean outputvalueformatDirtyFlag = false;
    private boolean psdbvaluefuncidDirtyFlag = false;
    private boolean psdbvaluefuncnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean uxcodenameDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="alldcflag")
    private Integer alldcflag;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="funcsn")
    private String funcsn;
    @Column(name="inputstddatatype")
    private Integer inputstddatatype;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="outputstddatatype")
    private Integer outputstddatatype;
    @Column(name="outputvalueformat")
    private String outputvalueformat;
    @Column(name="psdbvaluefuncid")
    private String psdbvaluefuncid;
    @Column(name="psdbvaluefuncname")
    private String psdbvaluefuncname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="uxcodename")
    private String uxcodename;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

    public void setAllDCFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllDCFlag(n);
            return;
        }
        this.alldcflag = n;
        this.alldcflagDirtyFlag = true;
    }

    public Integer getAllDCFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllDCFlag();
        }
        return this.alldcflag;
    }

    public boolean isAllDCFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllDCFlagDirty();
        }
        return this.alldcflagDirtyFlag;
    }

    public void resetAllDCFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllDCFlag();
            return;
        }
        this.alldcflagDirtyFlag = false;
        this.alldcflag = null;
    }

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

    public void setInputStdDataType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInputStdDataType(n);
            return;
        }
        this.inputstddatatype = n;
        this.inputstddatatypeDirtyFlag = true;
    }

    public Integer getInputStdDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInputStdDataType();
        }
        return this.inputstddatatype;
    }

    public boolean isInputStdDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInputStdDataTypeDirty();
        }
        return this.inputstddatatypeDirtyFlag;
    }

    public void resetInputStdDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInputStdDataType();
            return;
        }
        this.inputstddatatypeDirtyFlag = false;
        this.inputstddatatype = null;
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

    public void setOutputStdDataType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutputStdDataType(n);
            return;
        }
        this.outputstddatatype = n;
        this.outputstddatatypeDirtyFlag = true;
    }

    public Integer getOutputStdDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutputStdDataType();
        }
        return this.outputstddatatype;
    }

    public boolean isOutputStdDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutputStdDataTypeDirty();
        }
        return this.outputstddatatypeDirtyFlag;
    }

    public void resetOutputStdDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutputStdDataType();
            return;
        }
        this.outputstddatatypeDirtyFlag = false;
        this.outputstddatatype = null;
    }

    public void setOutputValueFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutputValueFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outputvalueformat = string;
        this.outputvalueformatDirtyFlag = true;
    }

    public String getOutputValueFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutputValueFormat();
        }
        return this.outputvalueformat;
    }

    public boolean isOutputValueFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutputValueFormatDirty();
        }
        return this.outputvalueformatDirtyFlag;
    }

    public void resetOutputValueFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutputValueFormat();
            return;
        }
        this.outputvalueformatDirtyFlag = false;
        this.outputvalueformat = null;
    }

    public void setPSDBValueFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvaluefuncid = string;
        this.psdbvaluefuncidDirtyFlag = true;
    }

    public String getPSDBValueFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueFuncId();
        }
        return this.psdbvaluefuncid;
    }

    public boolean isPSDBValueFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueFuncIdDirty();
        }
        return this.psdbvaluefuncidDirtyFlag;
    }

    public void resetPSDBValueFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueFuncId();
            return;
        }
        this.psdbvaluefuncidDirtyFlag = false;
        this.psdbvaluefuncid = null;
    }

    public void setPSDBValueFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvaluefuncname = string;
        this.psdbvaluefuncnameDirtyFlag = true;
    }

    public String getPSDBValueFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueFuncName();
        }
        return this.psdbvaluefuncname;
    }

    public boolean isPSDBValueFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueFuncNameDirty();
        }
        return this.psdbvaluefuncnameDirtyFlag;
    }

    public void resetPSDBValueFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueFuncName();
            return;
        }
        this.psdbvaluefuncnameDirtyFlag = false;
        this.psdbvaluefuncname = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
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

    public void setUXCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUXCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uxcodename = string;
        this.uxcodenameDirtyFlag = true;
    }

    public String getUXCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUXCodeName();
        }
        return this.uxcodename;
    }

    public boolean isUXCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUXCodeNameDirty();
        }
        return this.uxcodenameDirtyFlag;
    }

    public void resetUXCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUXCodeName();
            return;
        }
        this.uxcodenameDirtyFlag = false;
        this.uxcodename = null;
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
        PSDBValueFuncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDBValueFuncBase pSDBValueFuncBase) {
        pSDBValueFuncBase.resetAllDCFlag();
        pSDBValueFuncBase.resetCodeName();
        pSDBValueFuncBase.resetCreateDate();
        pSDBValueFuncBase.resetCreateMan();
        pSDBValueFuncBase.resetFuncSN();
        pSDBValueFuncBase.resetInputStdDataType();
        pSDBValueFuncBase.resetLogicName();
        pSDBValueFuncBase.resetMemo();
        pSDBValueFuncBase.resetOrderValue();
        pSDBValueFuncBase.resetOutputStdDataType();
        pSDBValueFuncBase.resetOutputValueFormat();
        pSDBValueFuncBase.resetPSDBValueFuncId();
        pSDBValueFuncBase.resetPSDBValueFuncName();
        pSDBValueFuncBase.resetPSDevCenterId();
        pSDBValueFuncBase.resetPSDevCenterName();
        pSDBValueFuncBase.resetUpdateDate();
        pSDBValueFuncBase.resetUpdateMan();
        pSDBValueFuncBase.resetUXCodeName();
        pSDBValueFuncBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllDCFlagDirty()) {
            hashMap.put(FIELD_ALLDCFLAG, this.getAllDCFlag());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFuncSNDirty()) {
            hashMap.put(FIELD_FUNCSN, this.getFuncSN());
        }
        if (!bl || this.isInputStdDataTypeDirty()) {
            hashMap.put(FIELD_INPUTSTDDATATYPE, this.getInputStdDataType());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isOutputStdDataTypeDirty()) {
            hashMap.put(FIELD_OUTPUTSTDDATATYPE, this.getOutputStdDataType());
        }
        if (!bl || this.isOutputValueFormatDirty()) {
            hashMap.put(FIELD_OUTPUTVALUEFORMAT, this.getOutputValueFormat());
        }
        if (!bl || this.isPSDBValueFuncIdDirty()) {
            hashMap.put(FIELD_PSDBVALUEFUNCID, this.getPSDBValueFuncId());
        }
        if (!bl || this.isPSDBValueFuncNameDirty()) {
            hashMap.put(FIELD_PSDBVALUEFUNCNAME, this.getPSDBValueFuncName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUXCodeNameDirty()) {
            hashMap.put(FIELD_UXCODENAME, this.getUXCodeName());
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
        return PSDBValueFuncBase.get(this, n);
    }

    private static Object get(PSDBValueFuncBase pSDBValueFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBValueFuncBase.getAllDCFlag();
            }
            case 1: {
                return pSDBValueFuncBase.getCodeName();
            }
            case 2: {
                return pSDBValueFuncBase.getCreateDate();
            }
            case 3: {
                return pSDBValueFuncBase.getCreateMan();
            }
            case 4: {
                return pSDBValueFuncBase.getFuncSN();
            }
            case 5: {
                return pSDBValueFuncBase.getInputStdDataType();
            }
            case 6: {
                return pSDBValueFuncBase.getLogicName();
            }
            case 7: {
                return pSDBValueFuncBase.getMemo();
            }
            case 8: {
                return pSDBValueFuncBase.getOrderValue();
            }
            case 9: {
                return pSDBValueFuncBase.getOutputStdDataType();
            }
            case 10: {
                return pSDBValueFuncBase.getOutputValueFormat();
            }
            case 11: {
                return pSDBValueFuncBase.getPSDBValueFuncId();
            }
            case 12: {
                return pSDBValueFuncBase.getPSDBValueFuncName();
            }
            case 13: {
                return pSDBValueFuncBase.getPSDevCenterId();
            }
            case 14: {
                return pSDBValueFuncBase.getPSDevCenterName();
            }
            case 15: {
                return pSDBValueFuncBase.getUpdateDate();
            }
            case 16: {
                return pSDBValueFuncBase.getUpdateMan();
            }
            case 17: {
                return pSDBValueFuncBase.getUXCodeName();
            }
            case 18: {
                return pSDBValueFuncBase.getValidFlag();
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
        PSDBValueFuncBase.set(this, n, object);
    }

    private static void set(PSDBValueFuncBase pSDBValueFuncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDBValueFuncBase.setAllDCFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDBValueFuncBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDBValueFuncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDBValueFuncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDBValueFuncBase.setFuncSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDBValueFuncBase.setInputStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDBValueFuncBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDBValueFuncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDBValueFuncBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDBValueFuncBase.setOutputStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDBValueFuncBase.setOutputValueFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDBValueFuncBase.setPSDBValueFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDBValueFuncBase.setPSDBValueFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDBValueFuncBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDBValueFuncBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDBValueFuncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSDBValueFuncBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDBValueFuncBase.setUXCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDBValueFuncBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDBValueFuncBase.isNull(this, n);
    }

    private static boolean isNull(PSDBValueFuncBase pSDBValueFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBValueFuncBase.getAllDCFlag() == null;
            }
            case 1: {
                return pSDBValueFuncBase.getCodeName() == null;
            }
            case 2: {
                return pSDBValueFuncBase.getCreateDate() == null;
            }
            case 3: {
                return pSDBValueFuncBase.getCreateMan() == null;
            }
            case 4: {
                return pSDBValueFuncBase.getFuncSN() == null;
            }
            case 5: {
                return pSDBValueFuncBase.getInputStdDataType() == null;
            }
            case 6: {
                return pSDBValueFuncBase.getLogicName() == null;
            }
            case 7: {
                return pSDBValueFuncBase.getMemo() == null;
            }
            case 8: {
                return pSDBValueFuncBase.getOrderValue() == null;
            }
            case 9: {
                return pSDBValueFuncBase.getOutputStdDataType() == null;
            }
            case 10: {
                return pSDBValueFuncBase.getOutputValueFormat() == null;
            }
            case 11: {
                return pSDBValueFuncBase.getPSDBValueFuncId() == null;
            }
            case 12: {
                return pSDBValueFuncBase.getPSDBValueFuncName() == null;
            }
            case 13: {
                return pSDBValueFuncBase.getPSDevCenterId() == null;
            }
            case 14: {
                return pSDBValueFuncBase.getPSDevCenterName() == null;
            }
            case 15: {
                return pSDBValueFuncBase.getUpdateDate() == null;
            }
            case 16: {
                return pSDBValueFuncBase.getUpdateMan() == null;
            }
            case 17: {
                return pSDBValueFuncBase.getUXCodeName() == null;
            }
            case 18: {
                return pSDBValueFuncBase.getValidFlag() == null;
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
        return PSDBValueFuncBase.contains(this, n);
    }

    private static boolean contains(PSDBValueFuncBase pSDBValueFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBValueFuncBase.isAllDCFlagDirty();
            }
            case 1: {
                return pSDBValueFuncBase.isCodeNameDirty();
            }
            case 2: {
                return pSDBValueFuncBase.isCreateDateDirty();
            }
            case 3: {
                return pSDBValueFuncBase.isCreateManDirty();
            }
            case 4: {
                return pSDBValueFuncBase.isFuncSNDirty();
            }
            case 5: {
                return pSDBValueFuncBase.isInputStdDataTypeDirty();
            }
            case 6: {
                return pSDBValueFuncBase.isLogicNameDirty();
            }
            case 7: {
                return pSDBValueFuncBase.isMemoDirty();
            }
            case 8: {
                return pSDBValueFuncBase.isOrderValueDirty();
            }
            case 9: {
                return pSDBValueFuncBase.isOutputStdDataTypeDirty();
            }
            case 10: {
                return pSDBValueFuncBase.isOutputValueFormatDirty();
            }
            case 11: {
                return pSDBValueFuncBase.isPSDBValueFuncIdDirty();
            }
            case 12: {
                return pSDBValueFuncBase.isPSDBValueFuncNameDirty();
            }
            case 13: {
                return pSDBValueFuncBase.isPSDevCenterIdDirty();
            }
            case 14: {
                return pSDBValueFuncBase.isPSDevCenterNameDirty();
            }
            case 15: {
                return pSDBValueFuncBase.isUpdateDateDirty();
            }
            case 16: {
                return pSDBValueFuncBase.isUpdateManDirty();
            }
            case 17: {
                return pSDBValueFuncBase.isUXCodeNameDirty();
            }
            case 18: {
                return pSDBValueFuncBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDBValueFuncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDBValueFuncBase pSDBValueFuncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDBValueFuncBase.getAllDCFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alldcflag", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getAllDCFlag()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getFuncSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"funcsn", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getFuncSN()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getInputStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inputstddatatype", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getInputStdDataType()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getMemo()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getOutputStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outputstddatatype", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getOutputStdDataType()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getOutputValueFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outputvalueformat", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getOutputValueFormat()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getPSDBValueFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvaluefuncid", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getPSDBValueFuncId()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getPSDBValueFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvaluefuncname", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getPSDBValueFuncName()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getUXCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uxcodename", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getUXCodeName()), (boolean)false);
        }
        if (bl || pSDBValueFuncBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDBValueFuncBase.getJSONValue((Object)pSDBValueFuncBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDBValueFuncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDBValueFuncBase pSDBValueFuncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDBValueFuncBase.getAllDCFlag() != null) {
            object = pSDBValueFuncBase.getAllDCFlag();
            xmlNode.setAttribute(FIELD_ALLDCFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBValueFuncBase.getCodeName() != null) {
            object = pSDBValueFuncBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueFuncBase.getCreateDate() != null) {
            object = pSDBValueFuncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBValueFuncBase.getCreateMan() != null) {
            object = pSDBValueFuncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueFuncBase.getFuncSN() != null) {
            object = pSDBValueFuncBase.getFuncSN();
            xmlNode.setAttribute(FIELD_FUNCSN, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueFuncBase.getInputStdDataType() != null) {
            object = pSDBValueFuncBase.getInputStdDataType();
            xmlNode.setAttribute(FIELD_INPUTSTDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBValueFuncBase.getLogicName() != null) {
            object = pSDBValueFuncBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueFuncBase.getMemo() != null) {
            object = pSDBValueFuncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueFuncBase.getOrderValue() != null) {
            object = pSDBValueFuncBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBValueFuncBase.getOutputStdDataType() != null) {
            object = pSDBValueFuncBase.getOutputStdDataType();
            xmlNode.setAttribute(FIELD_OUTPUTSTDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBValueFuncBase.getOutputValueFormat() != null) {
            object = pSDBValueFuncBase.getOutputValueFormat();
            xmlNode.setAttribute(FIELD_OUTPUTVALUEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueFuncBase.getPSDBValueFuncId() != null) {
            object = pSDBValueFuncBase.getPSDBValueFuncId();
            xmlNode.setAttribute(FIELD_PSDBVALUEFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueFuncBase.getPSDBValueFuncName() != null) {
            object = pSDBValueFuncBase.getPSDBValueFuncName();
            xmlNode.setAttribute(FIELD_PSDBVALUEFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueFuncBase.getPSDevCenterId() != null) {
            object = pSDBValueFuncBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueFuncBase.getPSDevCenterName() != null) {
            object = pSDBValueFuncBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueFuncBase.getUpdateDate() != null) {
            object = pSDBValueFuncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBValueFuncBase.getUpdateMan() != null) {
            object = pSDBValueFuncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueFuncBase.getUXCodeName() != null) {
            object = pSDBValueFuncBase.getUXCodeName();
            xmlNode.setAttribute(FIELD_UXCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBValueFuncBase.getValidFlag() != null) {
            object = pSDBValueFuncBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDBValueFuncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDBValueFuncBase pSDBValueFuncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDBValueFuncBase.isAllDCFlagDirty() && (bl || pSDBValueFuncBase.getAllDCFlag() != null)) {
            iDataObject.set(FIELD_ALLDCFLAG, (Object)pSDBValueFuncBase.getAllDCFlag());
        }
        if (pSDBValueFuncBase.isCodeNameDirty() && (bl || pSDBValueFuncBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDBValueFuncBase.getCodeName());
        }
        if (pSDBValueFuncBase.isCreateDateDirty() && (bl || pSDBValueFuncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDBValueFuncBase.getCreateDate());
        }
        if (pSDBValueFuncBase.isCreateManDirty() && (bl || pSDBValueFuncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDBValueFuncBase.getCreateMan());
        }
        if (pSDBValueFuncBase.isFuncSNDirty() && (bl || pSDBValueFuncBase.getFuncSN() != null)) {
            iDataObject.set(FIELD_FUNCSN, (Object)pSDBValueFuncBase.getFuncSN());
        }
        if (pSDBValueFuncBase.isInputStdDataTypeDirty() && (bl || pSDBValueFuncBase.getInputStdDataType() != null)) {
            iDataObject.set(FIELD_INPUTSTDDATATYPE, (Object)pSDBValueFuncBase.getInputStdDataType());
        }
        if (pSDBValueFuncBase.isLogicNameDirty() && (bl || pSDBValueFuncBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDBValueFuncBase.getLogicName());
        }
        if (pSDBValueFuncBase.isMemoDirty() && (bl || pSDBValueFuncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDBValueFuncBase.getMemo());
        }
        if (pSDBValueFuncBase.isOrderValueDirty() && (bl || pSDBValueFuncBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDBValueFuncBase.getOrderValue());
        }
        if (pSDBValueFuncBase.isOutputStdDataTypeDirty() && (bl || pSDBValueFuncBase.getOutputStdDataType() != null)) {
            iDataObject.set(FIELD_OUTPUTSTDDATATYPE, (Object)pSDBValueFuncBase.getOutputStdDataType());
        }
        if (pSDBValueFuncBase.isOutputValueFormatDirty() && (bl || pSDBValueFuncBase.getOutputValueFormat() != null)) {
            iDataObject.set(FIELD_OUTPUTVALUEFORMAT, (Object)pSDBValueFuncBase.getOutputValueFormat());
        }
        if (pSDBValueFuncBase.isPSDBValueFuncIdDirty() && (bl || pSDBValueFuncBase.getPSDBValueFuncId() != null)) {
            iDataObject.set(FIELD_PSDBVALUEFUNCID, (Object)pSDBValueFuncBase.getPSDBValueFuncId());
        }
        if (pSDBValueFuncBase.isPSDBValueFuncNameDirty() && (bl || pSDBValueFuncBase.getPSDBValueFuncName() != null)) {
            iDataObject.set(FIELD_PSDBVALUEFUNCNAME, (Object)pSDBValueFuncBase.getPSDBValueFuncName());
        }
        if (pSDBValueFuncBase.isPSDevCenterIdDirty() && (bl || pSDBValueFuncBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDBValueFuncBase.getPSDevCenterId());
        }
        if (pSDBValueFuncBase.isPSDevCenterNameDirty() && (bl || pSDBValueFuncBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDBValueFuncBase.getPSDevCenterName());
        }
        if (pSDBValueFuncBase.isUpdateDateDirty() && (bl || pSDBValueFuncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDBValueFuncBase.getUpdateDate());
        }
        if (pSDBValueFuncBase.isUpdateManDirty() && (bl || pSDBValueFuncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDBValueFuncBase.getUpdateMan());
        }
        if (pSDBValueFuncBase.isUXCodeNameDirty() && (bl || pSDBValueFuncBase.getUXCodeName() != null)) {
            iDataObject.set(FIELD_UXCODENAME, (Object)pSDBValueFuncBase.getUXCodeName());
        }
        if (pSDBValueFuncBase.isValidFlagDirty() && (bl || pSDBValueFuncBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDBValueFuncBase.getValidFlag());
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
        return PSDBValueFuncBase.remove(this, n);
    }

    private static boolean remove(PSDBValueFuncBase pSDBValueFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDBValueFuncBase.resetAllDCFlag();
                return true;
            }
            case 1: {
                pSDBValueFuncBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDBValueFuncBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDBValueFuncBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDBValueFuncBase.resetFuncSN();
                return true;
            }
            case 5: {
                pSDBValueFuncBase.resetInputStdDataType();
                return true;
            }
            case 6: {
                pSDBValueFuncBase.resetLogicName();
                return true;
            }
            case 7: {
                pSDBValueFuncBase.resetMemo();
                return true;
            }
            case 8: {
                pSDBValueFuncBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSDBValueFuncBase.resetOutputStdDataType();
                return true;
            }
            case 10: {
                pSDBValueFuncBase.resetOutputValueFormat();
                return true;
            }
            case 11: {
                pSDBValueFuncBase.resetPSDBValueFuncId();
                return true;
            }
            case 12: {
                pSDBValueFuncBase.resetPSDBValueFuncName();
                return true;
            }
            case 13: {
                pSDBValueFuncBase.resetPSDevCenterId();
                return true;
            }
            case 14: {
                pSDBValueFuncBase.resetPSDevCenterName();
                return true;
            }
            case 15: {
                pSDBValueFuncBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSDBValueFuncBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSDBValueFuncBase.resetUXCodeName();
                return true;
            }
            case 18: {
                pSDBValueFuncBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSDBValueFuncBase getProxyEntity() {
        return this.proxyPSDBValueFuncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDBValueFuncBase = null;
        if (iDataObject != null && iDataObject instanceof PSDBValueFuncBase) {
            this.proxyPSDBValueFuncBase = (PSDBValueFuncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBValueFuncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLDCFLAG, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_FUNCSN, 4);
        fieldIndexMap.put(FIELD_INPUTSTDDATATYPE, 5);
        fieldIndexMap.put(FIELD_LOGICNAME, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_OUTPUTSTDDATATYPE, 9);
        fieldIndexMap.put(FIELD_OUTPUTVALUEFORMAT, 10);
        fieldIndexMap.put(FIELD_PSDBVALUEFUNCID, 11);
        fieldIndexMap.put(FIELD_PSDBVALUEFUNCNAME, 12);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_UXCODENAME, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

