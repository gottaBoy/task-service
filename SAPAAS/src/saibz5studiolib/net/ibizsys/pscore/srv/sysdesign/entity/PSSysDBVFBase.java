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
package net.ibizsys.pscore.srv.sysdesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.config.entity.PSDBValueFunc;
import net.ibizsys.pscore.srv.config.service.PSDBValueFuncService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVFCode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFCodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBVFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDBVFBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_INPUTSTDDATATYPE = "INPUTSTDDATATYPE";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_OUTPUTSTDDATATYPE = "OUTPUTSTDDATATYPE";
    public static final String FIELD_OUTPUTVALUEFORMAT = "OUTPUTVALUEFORMAT";
    public static final String FIELD_PSDBVFID = "PSDBVFID";
    public static final String FIELD_PSDBVFNAME = "PSDBVFNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDBVFID = "PSSYSDBVFID";
    public static final String FIELD_PSSYSDBVFNAME = "PSSYSDBVFNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_UXCODENAME = "UXCODENAME";
    public static final String FIELD_VFTAG = "VFTAG";
    public static final String FIELD_VFTAG2 = "VFTAG2";
    public static final String FIELD_VFTYPE = "VFTYPE";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMCODE = 3;
    private static final int INDEX_CUSTOMMODE = 4;
    private static final int INDEX_INPUTSTDDATATYPE = 5;
    private static final int INDEX_LOGICNAME = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_OUTPUTSTDDATATYPE = 9;
    private static final int INDEX_OUTPUTVALUEFORMAT = 10;
    private static final int INDEX_PSDBVFID = 11;
    private static final int INDEX_PSDBVFNAME = 12;
    private static final int INDEX_PSMODULEID = 13;
    private static final int INDEX_PSMODULENAME = 14;
    private static final int INDEX_PSSYSDBVFID = 15;
    private static final int INDEX_PSSYSDBVFNAME = 16;
    private static final int INDEX_PSSYSDYNAMODELID = 17;
    private static final int INDEX_PSSYSDYNAMODELNAME = 18;
    private static final int INDEX_PSSYSSFPLUGINID = 19;
    private static final int INDEX_PSSYSSFPLUGINNAME = 20;
    private static final int INDEX_PSSYSTEMID = 21;
    private static final int INDEX_PSSYSTEMNAME = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_USERCAT = 25;
    private static final int INDEX_USERTAG = 26;
    private static final int INDEX_USERTAG2 = 27;
    private static final int INDEX_USERTAG3 = 28;
    private static final int INDEX_USERTAG4 = 29;
    private static final int INDEX_UXCODENAME = 30;
    private static final int INDEX_VFTAG = 31;
    private static final int INDEX_VFTAG2 = 32;
    private static final int INDEX_VFTYPE = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDBVFBase proxyPSSysDBVFBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean inputstddatatypeDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean outputstddatatypeDirtyFlag = false;
    private boolean outputvalueformatDirtyFlag = false;
    private boolean psdbvfidDirtyFlag = false;
    private boolean psdbvfnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdbvfidDirtyFlag = false;
    private boolean pssysdbvfnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean uxcodenameDirtyFlag = false;
    private boolean vftagDirtyFlag = false;
    private boolean vftag2DirtyFlag = false;
    private boolean vftypeDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
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
    @Column(name="psdbvfid")
    private String psdbvfid;
    @Column(name="psdbvfname")
    private String psdbvfname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdbvfid")
    private String pssysdbvfid;
    @Column(name="pssysdbvfname")
    private String pssysdbvfname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="uxcodename")
    private String uxcodename;
    @Column(name="vftag")
    private String vftag;
    @Column(name="vftag2")
    private String vftag2;
    @Column(name="vftype")
    private String vftype;
    private Integer objPSDBVFLock = new Integer(1);
    private PSDBValueFunc psdbvf = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysDBVFCodesLock = new Integer(1);
    private ArrayList<PSSysDBVFCode> pssysdbvfcodes = null;

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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
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

    public void setPSDBVFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBVFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvfid = string;
        this.psdbvfidDirtyFlag = true;
    }

    public String getPSDBVFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBVFId();
        }
        return this.psdbvfid;
    }

    public boolean isPSDBVFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBVFIdDirty();
        }
        return this.psdbvfidDirtyFlag;
    }

    public void resetPSDBVFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBVFId();
            return;
        }
        this.psdbvfidDirtyFlag = false;
        this.psdbvfid = null;
    }

    public void setPSDBVFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBVFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvfname = string;
        this.psdbvfnameDirtyFlag = true;
    }

    public String getPSDBVFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBVFName();
        }
        return this.psdbvfname;
    }

    public boolean isPSDBVFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBVFNameDirty();
        }
        return this.psdbvfnameDirtyFlag;
    }

    public void resetPSDBVFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBVFName();
            return;
        }
        this.psdbvfnameDirtyFlag = false;
        this.psdbvfname = null;
    }

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSSysDBVFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBVFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbvfid = string;
        this.pssysdbvfidDirtyFlag = true;
    }

    public String getPSSysDBVFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVFId();
        }
        return this.pssysdbvfid;
    }

    public boolean isPSSysDBVFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBVFIdDirty();
        }
        return this.pssysdbvfidDirtyFlag;
    }

    public void resetPSSysDBVFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBVFId();
            return;
        }
        this.pssysdbvfidDirtyFlag = false;
        this.pssysdbvfid = null;
    }

    public void setPSSysDBVFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBVFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbvfname = string;
        this.pssysdbvfnameDirtyFlag = true;
    }

    public String getPSSysDBVFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVFName();
        }
        return this.pssysdbvfname;
    }

    public boolean isPSSysDBVFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBVFNameDirty();
        }
        return this.pssysdbvfnameDirtyFlag;
    }

    public void resetPSSysDBVFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBVFName();
            return;
        }
        this.pssysdbvfnameDirtyFlag = false;
        this.pssysdbvfname = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
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

    public void setVFTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVFTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vftag = string;
        this.vftagDirtyFlag = true;
    }

    public String getVFTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVFTag();
        }
        return this.vftag;
    }

    public boolean isVFTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVFTagDirty();
        }
        return this.vftagDirtyFlag;
    }

    public void resetVFTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVFTag();
            return;
        }
        this.vftagDirtyFlag = false;
        this.vftag = null;
    }

    public void setVFTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVFTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vftag2 = string;
        this.vftag2DirtyFlag = true;
    }

    public String getVFTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVFTag2();
        }
        return this.vftag2;
    }

    public boolean isVFTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVFTag2Dirty();
        }
        return this.vftag2DirtyFlag;
    }

    public void resetVFTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVFTag2();
            return;
        }
        this.vftag2DirtyFlag = false;
        this.vftag2 = null;
    }

    public void setVFType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVFType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vftype = string;
        this.vftypeDirtyFlag = true;
    }

    public String getVFType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVFType();
        }
        return this.vftype;
    }

    public boolean isVFTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVFTypeDirty();
        }
        return this.vftypeDirtyFlag;
    }

    public void resetVFType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVFType();
            return;
        }
        this.vftypeDirtyFlag = false;
        this.vftype = null;
    }

    protected void onReset() {
        PSSysDBVFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDBVFBase pSSysDBVFBase) {
        pSSysDBVFBase.resetCodeName();
        pSSysDBVFBase.resetCreateDate();
        pSSysDBVFBase.resetCreateMan();
        pSSysDBVFBase.resetCustomCode();
        pSSysDBVFBase.resetCustomMode();
        pSSysDBVFBase.resetInputStdDataType();
        pSSysDBVFBase.resetLogicName();
        pSSysDBVFBase.resetMemo();
        pSSysDBVFBase.resetOrderValue();
        pSSysDBVFBase.resetOutputStdDataType();
        pSSysDBVFBase.resetOutputValueFormat();
        pSSysDBVFBase.resetPSDBVFId();
        pSSysDBVFBase.resetPSDBVFName();
        pSSysDBVFBase.resetPSModuleId();
        pSSysDBVFBase.resetPSModuleName();
        pSSysDBVFBase.resetPSSysDBVFId();
        pSSysDBVFBase.resetPSSysDBVFName();
        pSSysDBVFBase.resetPSSysDynaModelId();
        pSSysDBVFBase.resetPSSysDynaModelName();
        pSSysDBVFBase.resetPSSysSFPluginId();
        pSSysDBVFBase.resetPSSysSFPluginName();
        pSSysDBVFBase.resetPSSystemId();
        pSSysDBVFBase.resetPSSystemName();
        pSSysDBVFBase.resetUpdateDate();
        pSSysDBVFBase.resetUpdateMan();
        pSSysDBVFBase.resetUserCat();
        pSSysDBVFBase.resetUserTag();
        pSSysDBVFBase.resetUserTag2();
        pSSysDBVFBase.resetUserTag3();
        pSSysDBVFBase.resetUserTag4();
        pSSysDBVFBase.resetUXCodeName();
        pSSysDBVFBase.resetVFTag();
        pSSysDBVFBase.resetVFTag2();
        pSSysDBVFBase.resetVFType();
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
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
        if (!bl || this.isPSDBVFIdDirty()) {
            hashMap.put(FIELD_PSDBVFID, this.getPSDBVFId());
        }
        if (!bl || this.isPSDBVFNameDirty()) {
            hashMap.put(FIELD_PSDBVFNAME, this.getPSDBVFName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysDBVFIdDirty()) {
            hashMap.put(FIELD_PSSYSDBVFID, this.getPSSysDBVFId());
        }
        if (!bl || this.isPSSysDBVFNameDirty()) {
            hashMap.put(FIELD_PSSYSDBVFNAME, this.getPSSysDBVFName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        if (!bl || this.isUXCodeNameDirty()) {
            hashMap.put(FIELD_UXCODENAME, this.getUXCodeName());
        }
        if (!bl || this.isVFTagDirty()) {
            hashMap.put(FIELD_VFTAG, this.getVFTag());
        }
        if (!bl || this.isVFTag2Dirty()) {
            hashMap.put(FIELD_VFTAG2, this.getVFTag2());
        }
        if (!bl || this.isVFTypeDirty()) {
            hashMap.put(FIELD_VFTYPE, this.getVFType());
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
        return PSSysDBVFBase.get(this, n);
    }

    private static Object get(PSSysDBVFBase pSSysDBVFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBVFBase.getCodeName();
            }
            case 1: {
                return pSSysDBVFBase.getCreateDate();
            }
            case 2: {
                return pSSysDBVFBase.getCreateMan();
            }
            case 3: {
                return pSSysDBVFBase.getCustomCode();
            }
            case 4: {
                return pSSysDBVFBase.getCustomMode();
            }
            case 5: {
                return pSSysDBVFBase.getInputStdDataType();
            }
            case 6: {
                return pSSysDBVFBase.getLogicName();
            }
            case 7: {
                return pSSysDBVFBase.getMemo();
            }
            case 8: {
                return pSSysDBVFBase.getOrderValue();
            }
            case 9: {
                return pSSysDBVFBase.getOutputStdDataType();
            }
            case 10: {
                return pSSysDBVFBase.getOutputValueFormat();
            }
            case 11: {
                return pSSysDBVFBase.getPSDBVFId();
            }
            case 12: {
                return pSSysDBVFBase.getPSDBVFName();
            }
            case 13: {
                return pSSysDBVFBase.getPSModuleId();
            }
            case 14: {
                return pSSysDBVFBase.getPSModuleName();
            }
            case 15: {
                return pSSysDBVFBase.getPSSysDBVFId();
            }
            case 16: {
                return pSSysDBVFBase.getPSSysDBVFName();
            }
            case 17: {
                return pSSysDBVFBase.getPSSysDynaModelId();
            }
            case 18: {
                return pSSysDBVFBase.getPSSysDynaModelName();
            }
            case 19: {
                return pSSysDBVFBase.getPSSysSFPluginId();
            }
            case 20: {
                return pSSysDBVFBase.getPSSysSFPluginName();
            }
            case 21: {
                return pSSysDBVFBase.getPSSystemId();
            }
            case 22: {
                return pSSysDBVFBase.getPSSystemName();
            }
            case 23: {
                return pSSysDBVFBase.getUpdateDate();
            }
            case 24: {
                return pSSysDBVFBase.getUpdateMan();
            }
            case 25: {
                return pSSysDBVFBase.getUserCat();
            }
            case 26: {
                return pSSysDBVFBase.getUserTag();
            }
            case 27: {
                return pSSysDBVFBase.getUserTag2();
            }
            case 28: {
                return pSSysDBVFBase.getUserTag3();
            }
            case 29: {
                return pSSysDBVFBase.getUserTag4();
            }
            case 30: {
                return pSSysDBVFBase.getUXCodeName();
            }
            case 31: {
                return pSSysDBVFBase.getVFTag();
            }
            case 32: {
                return pSSysDBVFBase.getVFTag2();
            }
            case 33: {
                return pSSysDBVFBase.getVFType();
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
        PSSysDBVFBase.set(this, n, object);
    }

    private static void set(PSSysDBVFBase pSSysDBVFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBVFBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysDBVFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysDBVFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDBVFBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDBVFBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysDBVFBase.setInputStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysDBVFBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDBVFBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDBVFBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysDBVFBase.setOutputStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysDBVFBase.setOutputValueFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDBVFBase.setPSDBVFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDBVFBase.setPSDBVFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDBVFBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDBVFBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDBVFBase.setPSSysDBVFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDBVFBase.setPSSysDBVFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDBVFBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysDBVFBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysDBVFBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysDBVFBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysDBVFBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysDBVFBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysDBVFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSSysDBVFBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysDBVFBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysDBVFBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysDBVFBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysDBVFBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysDBVFBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysDBVFBase.setUXCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysDBVFBase.setVFTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysDBVFBase.setVFTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysDBVFBase.setVFType(DataObject.getStringValue((Object)object));
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
        return PSSysDBVFBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDBVFBase pSSysDBVFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBVFBase.getCodeName() == null;
            }
            case 1: {
                return pSSysDBVFBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysDBVFBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysDBVFBase.getCustomCode() == null;
            }
            case 4: {
                return pSSysDBVFBase.getCustomMode() == null;
            }
            case 5: {
                return pSSysDBVFBase.getInputStdDataType() == null;
            }
            case 6: {
                return pSSysDBVFBase.getLogicName() == null;
            }
            case 7: {
                return pSSysDBVFBase.getMemo() == null;
            }
            case 8: {
                return pSSysDBVFBase.getOrderValue() == null;
            }
            case 9: {
                return pSSysDBVFBase.getOutputStdDataType() == null;
            }
            case 10: {
                return pSSysDBVFBase.getOutputValueFormat() == null;
            }
            case 11: {
                return pSSysDBVFBase.getPSDBVFId() == null;
            }
            case 12: {
                return pSSysDBVFBase.getPSDBVFName() == null;
            }
            case 13: {
                return pSSysDBVFBase.getPSModuleId() == null;
            }
            case 14: {
                return pSSysDBVFBase.getPSModuleName() == null;
            }
            case 15: {
                return pSSysDBVFBase.getPSSysDBVFId() == null;
            }
            case 16: {
                return pSSysDBVFBase.getPSSysDBVFName() == null;
            }
            case 17: {
                return pSSysDBVFBase.getPSSysDynaModelId() == null;
            }
            case 18: {
                return pSSysDBVFBase.getPSSysDynaModelName() == null;
            }
            case 19: {
                return pSSysDBVFBase.getPSSysSFPluginId() == null;
            }
            case 20: {
                return pSSysDBVFBase.getPSSysSFPluginName() == null;
            }
            case 21: {
                return pSSysDBVFBase.getPSSystemId() == null;
            }
            case 22: {
                return pSSysDBVFBase.getPSSystemName() == null;
            }
            case 23: {
                return pSSysDBVFBase.getUpdateDate() == null;
            }
            case 24: {
                return pSSysDBVFBase.getUpdateMan() == null;
            }
            case 25: {
                return pSSysDBVFBase.getUserCat() == null;
            }
            case 26: {
                return pSSysDBVFBase.getUserTag() == null;
            }
            case 27: {
                return pSSysDBVFBase.getUserTag2() == null;
            }
            case 28: {
                return pSSysDBVFBase.getUserTag3() == null;
            }
            case 29: {
                return pSSysDBVFBase.getUserTag4() == null;
            }
            case 30: {
                return pSSysDBVFBase.getUXCodeName() == null;
            }
            case 31: {
                return pSSysDBVFBase.getVFTag() == null;
            }
            case 32: {
                return pSSysDBVFBase.getVFTag2() == null;
            }
            case 33: {
                return pSSysDBVFBase.getVFType() == null;
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
        return PSSysDBVFBase.contains(this, n);
    }

    private static boolean contains(PSSysDBVFBase pSSysDBVFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBVFBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysDBVFBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysDBVFBase.isCreateManDirty();
            }
            case 3: {
                return pSSysDBVFBase.isCustomCodeDirty();
            }
            case 4: {
                return pSSysDBVFBase.isCustomModeDirty();
            }
            case 5: {
                return pSSysDBVFBase.isInputStdDataTypeDirty();
            }
            case 6: {
                return pSSysDBVFBase.isLogicNameDirty();
            }
            case 7: {
                return pSSysDBVFBase.isMemoDirty();
            }
            case 8: {
                return pSSysDBVFBase.isOrderValueDirty();
            }
            case 9: {
                return pSSysDBVFBase.isOutputStdDataTypeDirty();
            }
            case 10: {
                return pSSysDBVFBase.isOutputValueFormatDirty();
            }
            case 11: {
                return pSSysDBVFBase.isPSDBVFIdDirty();
            }
            case 12: {
                return pSSysDBVFBase.isPSDBVFNameDirty();
            }
            case 13: {
                return pSSysDBVFBase.isPSModuleIdDirty();
            }
            case 14: {
                return pSSysDBVFBase.isPSModuleNameDirty();
            }
            case 15: {
                return pSSysDBVFBase.isPSSysDBVFIdDirty();
            }
            case 16: {
                return pSSysDBVFBase.isPSSysDBVFNameDirty();
            }
            case 17: {
                return pSSysDBVFBase.isPSSysDynaModelIdDirty();
            }
            case 18: {
                return pSSysDBVFBase.isPSSysDynaModelNameDirty();
            }
            case 19: {
                return pSSysDBVFBase.isPSSysSFPluginIdDirty();
            }
            case 20: {
                return pSSysDBVFBase.isPSSysSFPluginNameDirty();
            }
            case 21: {
                return pSSysDBVFBase.isPSSystemIdDirty();
            }
            case 22: {
                return pSSysDBVFBase.isPSSystemNameDirty();
            }
            case 23: {
                return pSSysDBVFBase.isUpdateDateDirty();
            }
            case 24: {
                return pSSysDBVFBase.isUpdateManDirty();
            }
            case 25: {
                return pSSysDBVFBase.isUserCatDirty();
            }
            case 26: {
                return pSSysDBVFBase.isUserTagDirty();
            }
            case 27: {
                return pSSysDBVFBase.isUserTag2Dirty();
            }
            case 28: {
                return pSSysDBVFBase.isUserTag3Dirty();
            }
            case 29: {
                return pSSysDBVFBase.isUserTag4Dirty();
            }
            case 30: {
                return pSSysDBVFBase.isUXCodeNameDirty();
            }
            case 31: {
                return pSSysDBVFBase.isVFTagDirty();
            }
            case 32: {
                return pSSysDBVFBase.isVFTag2Dirty();
            }
            case 33: {
                return pSSysDBVFBase.isVFTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDBVFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDBVFBase pSSysDBVFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDBVFBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getInputStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inputstddatatype", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getInputStdDataType()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getOutputStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outputstddatatype", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getOutputStdDataType()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getOutputValueFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outputvalueformat", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getOutputValueFormat()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getPSDBVFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvfid", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getPSDBVFId()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getPSDBVFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvfname", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getPSDBVFName()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getPSSysDBVFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvfid", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getPSSysDBVFId()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getPSSysDBVFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvfname", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getPSSysDBVFName()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getUXCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uxcodename", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getUXCodeName()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getVFTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vftag", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getVFTag()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getVFTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vftag2", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getVFTag2()), (boolean)false);
        }
        if (bl || pSSysDBVFBase.getVFType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vftype", (Object)PSSysDBVFBase.getJSONValue((Object)pSSysDBVFBase.getVFType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDBVFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDBVFBase pSSysDBVFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDBVFBase.getCodeName() != null) {
            object = pSSysDBVFBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getCreateDate() != null) {
            object = pSSysDBVFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBVFBase.getCreateMan() != null) {
            object = pSSysDBVFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getCustomCode() != null) {
            object = pSSysDBVFBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getCustomMode() != null) {
            object = pSSysDBVFBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBVFBase.getInputStdDataType() != null) {
            object = pSSysDBVFBase.getInputStdDataType();
            xmlNode.setAttribute(FIELD_INPUTSTDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBVFBase.getLogicName() != null) {
            object = pSSysDBVFBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getMemo() != null) {
            object = pSSysDBVFBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getOrderValue() != null) {
            object = pSSysDBVFBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBVFBase.getOutputStdDataType() != null) {
            object = pSSysDBVFBase.getOutputStdDataType();
            xmlNode.setAttribute(FIELD_OUTPUTSTDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBVFBase.getOutputValueFormat() != null) {
            object = pSSysDBVFBase.getOutputValueFormat();
            xmlNode.setAttribute(FIELD_OUTPUTVALUEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getPSDBVFId() != null) {
            object = pSSysDBVFBase.getPSDBVFId();
            xmlNode.setAttribute(FIELD_PSDBVFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getPSDBVFName() != null) {
            object = pSSysDBVFBase.getPSDBVFName();
            xmlNode.setAttribute(FIELD_PSDBVFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getPSModuleId() != null) {
            object = pSSysDBVFBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getPSModuleName() != null) {
            object = pSSysDBVFBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getPSSysDBVFId() != null) {
            object = pSSysDBVFBase.getPSSysDBVFId();
            xmlNode.setAttribute(FIELD_PSSYSDBVFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getPSSysDBVFName() != null) {
            object = pSSysDBVFBase.getPSSysDBVFName();
            xmlNode.setAttribute(FIELD_PSSYSDBVFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getPSSysDynaModelId() != null) {
            object = pSSysDBVFBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getPSSysDynaModelName() != null) {
            object = pSSysDBVFBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getPSSysSFPluginId() != null) {
            object = pSSysDBVFBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getPSSysSFPluginName() != null) {
            object = pSSysDBVFBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getPSSystemId() != null) {
            object = pSSysDBVFBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getPSSystemName() != null) {
            object = pSSysDBVFBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getUpdateDate() != null) {
            object = pSSysDBVFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBVFBase.getUpdateMan() != null) {
            object = pSSysDBVFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getUserCat() != null) {
            object = pSSysDBVFBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getUserTag() != null) {
            object = pSSysDBVFBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getUserTag2() != null) {
            object = pSSysDBVFBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getUserTag3() != null) {
            object = pSSysDBVFBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getUserTag4() != null) {
            object = pSSysDBVFBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getUXCodeName() != null) {
            object = pSSysDBVFBase.getUXCodeName();
            xmlNode.setAttribute(FIELD_UXCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getVFTag() != null) {
            object = pSSysDBVFBase.getVFTag();
            xmlNode.setAttribute(FIELD_VFTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getVFTag2() != null) {
            object = pSSysDBVFBase.getVFTag2();
            xmlNode.setAttribute(FIELD_VFTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBVFBase.getVFType() != null) {
            object = pSSysDBVFBase.getVFType();
            xmlNode.setAttribute(FIELD_VFTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDBVFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDBVFBase pSSysDBVFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDBVFBase.isCodeNameDirty() && (bl || pSSysDBVFBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysDBVFBase.getCodeName());
        }
        if (pSSysDBVFBase.isCreateDateDirty() && (bl || pSSysDBVFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDBVFBase.getCreateDate());
        }
        if (pSSysDBVFBase.isCreateManDirty() && (bl || pSSysDBVFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDBVFBase.getCreateMan());
        }
        if (pSSysDBVFBase.isCustomCodeDirty() && (bl || pSSysDBVFBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysDBVFBase.getCustomCode());
        }
        if (pSSysDBVFBase.isCustomModeDirty() && (bl || pSSysDBVFBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysDBVFBase.getCustomMode());
        }
        if (pSSysDBVFBase.isInputStdDataTypeDirty() && (bl || pSSysDBVFBase.getInputStdDataType() != null)) {
            iDataObject.set(FIELD_INPUTSTDDATATYPE, (Object)pSSysDBVFBase.getInputStdDataType());
        }
        if (pSSysDBVFBase.isLogicNameDirty() && (bl || pSSysDBVFBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysDBVFBase.getLogicName());
        }
        if (pSSysDBVFBase.isMemoDirty() && (bl || pSSysDBVFBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDBVFBase.getMemo());
        }
        if (pSSysDBVFBase.isOrderValueDirty() && (bl || pSSysDBVFBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysDBVFBase.getOrderValue());
        }
        if (pSSysDBVFBase.isOutputStdDataTypeDirty() && (bl || pSSysDBVFBase.getOutputStdDataType() != null)) {
            iDataObject.set(FIELD_OUTPUTSTDDATATYPE, (Object)pSSysDBVFBase.getOutputStdDataType());
        }
        if (pSSysDBVFBase.isOutputValueFormatDirty() && (bl || pSSysDBVFBase.getOutputValueFormat() != null)) {
            iDataObject.set(FIELD_OUTPUTVALUEFORMAT, (Object)pSSysDBVFBase.getOutputValueFormat());
        }
        if (pSSysDBVFBase.isPSDBVFIdDirty() && (bl || pSSysDBVFBase.getPSDBVFId() != null)) {
            iDataObject.set(FIELD_PSDBVFID, (Object)pSSysDBVFBase.getPSDBVFId());
        }
        if (pSSysDBVFBase.isPSDBVFNameDirty() && (bl || pSSysDBVFBase.getPSDBVFName() != null)) {
            iDataObject.set(FIELD_PSDBVFNAME, (Object)pSSysDBVFBase.getPSDBVFName());
        }
        if (pSSysDBVFBase.isPSModuleIdDirty() && (bl || pSSysDBVFBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysDBVFBase.getPSModuleId());
        }
        if (pSSysDBVFBase.isPSModuleNameDirty() && (bl || pSSysDBVFBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysDBVFBase.getPSModuleName());
        }
        if (pSSysDBVFBase.isPSSysDBVFIdDirty() && (bl || pSSysDBVFBase.getPSSysDBVFId() != null)) {
            iDataObject.set(FIELD_PSSYSDBVFID, (Object)pSSysDBVFBase.getPSSysDBVFId());
        }
        if (pSSysDBVFBase.isPSSysDBVFNameDirty() && (bl || pSSysDBVFBase.getPSSysDBVFName() != null)) {
            iDataObject.set(FIELD_PSSYSDBVFNAME, (Object)pSSysDBVFBase.getPSSysDBVFName());
        }
        if (pSSysDBVFBase.isPSSysDynaModelIdDirty() && (bl || pSSysDBVFBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysDBVFBase.getPSSysDynaModelId());
        }
        if (pSSysDBVFBase.isPSSysDynaModelNameDirty() && (bl || pSSysDBVFBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysDBVFBase.getPSSysDynaModelName());
        }
        if (pSSysDBVFBase.isPSSysSFPluginIdDirty() && (bl || pSSysDBVFBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysDBVFBase.getPSSysSFPluginId());
        }
        if (pSSysDBVFBase.isPSSysSFPluginNameDirty() && (bl || pSSysDBVFBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysDBVFBase.getPSSysSFPluginName());
        }
        if (pSSysDBVFBase.isPSSystemIdDirty() && (bl || pSSysDBVFBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysDBVFBase.getPSSystemId());
        }
        if (pSSysDBVFBase.isPSSystemNameDirty() && (bl || pSSysDBVFBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysDBVFBase.getPSSystemName());
        }
        if (pSSysDBVFBase.isUpdateDateDirty() && (bl || pSSysDBVFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDBVFBase.getUpdateDate());
        }
        if (pSSysDBVFBase.isUpdateManDirty() && (bl || pSSysDBVFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDBVFBase.getUpdateMan());
        }
        if (pSSysDBVFBase.isUserCatDirty() && (bl || pSSysDBVFBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysDBVFBase.getUserCat());
        }
        if (pSSysDBVFBase.isUserTagDirty() && (bl || pSSysDBVFBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysDBVFBase.getUserTag());
        }
        if (pSSysDBVFBase.isUserTag2Dirty() && (bl || pSSysDBVFBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysDBVFBase.getUserTag2());
        }
        if (pSSysDBVFBase.isUserTag3Dirty() && (bl || pSSysDBVFBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysDBVFBase.getUserTag3());
        }
        if (pSSysDBVFBase.isUserTag4Dirty() && (bl || pSSysDBVFBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysDBVFBase.getUserTag4());
        }
        if (pSSysDBVFBase.isUXCodeNameDirty() && (bl || pSSysDBVFBase.getUXCodeName() != null)) {
            iDataObject.set(FIELD_UXCODENAME, (Object)pSSysDBVFBase.getUXCodeName());
        }
        if (pSSysDBVFBase.isVFTagDirty() && (bl || pSSysDBVFBase.getVFTag() != null)) {
            iDataObject.set(FIELD_VFTAG, (Object)pSSysDBVFBase.getVFTag());
        }
        if (pSSysDBVFBase.isVFTag2Dirty() && (bl || pSSysDBVFBase.getVFTag2() != null)) {
            iDataObject.set(FIELD_VFTAG2, (Object)pSSysDBVFBase.getVFTag2());
        }
        if (pSSysDBVFBase.isVFTypeDirty() && (bl || pSSysDBVFBase.getVFType() != null)) {
            iDataObject.set(FIELD_VFTYPE, (Object)pSSysDBVFBase.getVFType());
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
        return PSSysDBVFBase.remove(this, n);
    }

    private static boolean remove(PSSysDBVFBase pSSysDBVFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBVFBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysDBVFBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysDBVFBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysDBVFBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSSysDBVFBase.resetCustomMode();
                return true;
            }
            case 5: {
                pSSysDBVFBase.resetInputStdDataType();
                return true;
            }
            case 6: {
                pSSysDBVFBase.resetLogicName();
                return true;
            }
            case 7: {
                pSSysDBVFBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysDBVFBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSSysDBVFBase.resetOutputStdDataType();
                return true;
            }
            case 10: {
                pSSysDBVFBase.resetOutputValueFormat();
                return true;
            }
            case 11: {
                pSSysDBVFBase.resetPSDBVFId();
                return true;
            }
            case 12: {
                pSSysDBVFBase.resetPSDBVFName();
                return true;
            }
            case 13: {
                pSSysDBVFBase.resetPSModuleId();
                return true;
            }
            case 14: {
                pSSysDBVFBase.resetPSModuleName();
                return true;
            }
            case 15: {
                pSSysDBVFBase.resetPSSysDBVFId();
                return true;
            }
            case 16: {
                pSSysDBVFBase.resetPSSysDBVFName();
                return true;
            }
            case 17: {
                pSSysDBVFBase.resetPSSysDynaModelId();
                return true;
            }
            case 18: {
                pSSysDBVFBase.resetPSSysDynaModelName();
                return true;
            }
            case 19: {
                pSSysDBVFBase.resetPSSysSFPluginId();
                return true;
            }
            case 20: {
                pSSysDBVFBase.resetPSSysSFPluginName();
                return true;
            }
            case 21: {
                pSSysDBVFBase.resetPSSystemId();
                return true;
            }
            case 22: {
                pSSysDBVFBase.resetPSSystemName();
                return true;
            }
            case 23: {
                pSSysDBVFBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSSysDBVFBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSSysDBVFBase.resetUserCat();
                return true;
            }
            case 26: {
                pSSysDBVFBase.resetUserTag();
                return true;
            }
            case 27: {
                pSSysDBVFBase.resetUserTag2();
                return true;
            }
            case 28: {
                pSSysDBVFBase.resetUserTag3();
                return true;
            }
            case 29: {
                pSSysDBVFBase.resetUserTag4();
                return true;
            }
            case 30: {
                pSSysDBVFBase.resetUXCodeName();
                return true;
            }
            case 31: {
                pSSysDBVFBase.resetVFTag();
                return true;
            }
            case 32: {
                pSSysDBVFBase.resetVFTag2();
                return true;
            }
            case 33: {
                pSSysDBVFBase.resetVFType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBValueFunc getPSDBVF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBVF();
        }
        if (this.getPSDBVFId() == null) {
            return null;
        }
        Integer n = this.objPSDBVFLock;
        synchronized (n) {
            if (this.psdbvf != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBVFId(), (Object)this.psdbvf.getPSDBValueFuncId()) != 0L) {
                this.psdbvf = null;
            }
            if (this.psdbvf == null) {
                PSDBValueFunc pSDBValueFunc = new PSDBValueFunc();
                pSDBValueFunc.setPSDBValueFuncId(this.getPSDBVFId());
                PSDBValueFuncService pSDBValueFuncService = (PSDBValueFuncService)ServiceGlobal.getService(PSDBValueFuncService.class, (SessionFactory)this.getSessionFactory());
                pSDBValueFuncService.autoGet((IEntity)pSDBValueFunc);
                this.psdbvf = pSDBValueFunc;
            }
            return this.psdbvf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysDBVFCode> getPSSysDBVFCodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVFCodes();
        }
        if (this.getPSSysDBVFId() == null) {
            return null;
        }
        PSSysDBVFCodeService pSSysDBVFCodeService = (PSSysDBVFCodeService)ServiceGlobal.getService(PSSysDBVFCodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDBVFCodesLock;
        synchronized (n) {
            if (this.pssysdbvfcodes == null) {
                this.pssysdbvfcodes = pSSysDBVFCodeService.selectByPSSysDBVF(this);
            }
            return this.pssysdbvfcodes;
        }
    }

    private PSSysDBVFBase getProxyEntity() {
        return this.proxyPSSysDBVFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDBVFBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDBVFBase) {
            this.proxyPSSysDBVFBase = (PSSysDBVFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 3);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 4);
        fieldIndexMap.put(FIELD_INPUTSTDDATATYPE, 5);
        fieldIndexMap.put(FIELD_LOGICNAME, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_OUTPUTSTDDATATYPE, 9);
        fieldIndexMap.put(FIELD_OUTPUTVALUEFORMAT, 10);
        fieldIndexMap.put(FIELD_PSDBVFID, 11);
        fieldIndexMap.put(FIELD_PSDBVFNAME, 12);
        fieldIndexMap.put(FIELD_PSMODULEID, 13);
        fieldIndexMap.put(FIELD_PSMODULENAME, 14);
        fieldIndexMap.put(FIELD_PSSYSDBVFID, 15);
        fieldIndexMap.put(FIELD_PSSYSDBVFNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 17);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 18);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 19);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_USERCAT, 25);
        fieldIndexMap.put(FIELD_USERTAG, 26);
        fieldIndexMap.put(FIELD_USERTAG2, 27);
        fieldIndexMap.put(FIELD_USERTAG3, 28);
        fieldIndexMap.put(FIELD_USERTAG4, 29);
        fieldIndexMap.put(FIELD_UXCODENAME, 30);
        fieldIndexMap.put(FIELD_VFTAG, 31);
        fieldIndexMap.put(FIELD_VFTAG2, 32);
        fieldIndexMap.put(FIELD_VFTYPE, 33);
    }
}

