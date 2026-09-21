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
package net.ibizsys.pscore.srv.systest.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSampleValue;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSampleValueService;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTCInputBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysTCInputBase.class);
    public static final String FIELD_ACTIONPARAMS = "ACTIONPARAMS";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_DEFPSSYSSAMPLEVALUEID = "DEFPSSYSSAMPLEVALUEID";
    public static final String FIELD_DEFPSSYSSAMPLEVALUENAME = "DEFPSSYSSAMPLEVALUENAME";
    public static final String FIELD_DEFVALUE = "DEFVALUE";
    public static final String FIELD_INPUTTAG = "INPUTTAG";
    public static final String FIELD_INPUTTAG2 = "INPUTTAG2";
    public static final String FIELD_INPUTTAG3 = "INPUTTAG3";
    public static final String FIELD_INPUTTAG4 = "INPUTTAG4";
    public static final String FIELD_INPUTTYPE = "INPUTTYPE";
    public static final String FIELD_INPUTVALUES = "INPUTVALUES";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSTCINPUTID = "PSSYSTCINPUTID";
    public static final String FIELD_PSSYSTCINPUTNAME = "PSSYSTCINPUTNAME";
    public static final String FIELD_PSSYSTESTCASEID = "PSSYSTESTCASEID";
    public static final String FIELD_PSSYSTESTCASENAME = "PSSYSTESTCASENAME";
    public static final String FIELD_PSSYSTESTDATAID = "PSSYSTESTDATAID";
    public static final String FIELD_PSSYSTESTDATANAME = "PSSYSTESTDATANAME";
    public static final String FIELD_TARGETTYPE = "TARGETTYPE";
    public static final String FIELD_TESTDATASN = "TESTDATASN";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ACTIONPARAMS = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMCODE = 3;
    private static final int INDEX_DEFPSSYSSAMPLEVALUEID = 4;
    private static final int INDEX_DEFPSSYSSAMPLEVALUENAME = 5;
    private static final int INDEX_DEFVALUE = 6;
    private static final int INDEX_INPUTTAG = 7;
    private static final int INDEX_INPUTTAG2 = 8;
    private static final int INDEX_INPUTTAG3 = 9;
    private static final int INDEX_INPUTTAG4 = 10;
    private static final int INDEX_INPUTTYPE = 11;
    private static final int INDEX_INPUTVALUES = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_ORDERVALUE = 14;
    private static final int INDEX_PSDEACTIONID = 15;
    private static final int INDEX_PSDEACTIONNAME = 16;
    private static final int INDEX_PSDEFID = 17;
    private static final int INDEX_PSDEID = 18;
    private static final int INDEX_PSSYSTCINPUTID = 19;
    private static final int INDEX_PSSYSTCINPUTNAME = 20;
    private static final int INDEX_PSSYSTESTCASEID = 21;
    private static final int INDEX_PSSYSTESTCASENAME = 22;
    private static final int INDEX_PSSYSTESTDATAID = 23;
    private static final int INDEX_PSSYSTESTDATANAME = 24;
    private static final int INDEX_TARGETTYPE = 25;
    private static final int INDEX_TESTDATASN = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_USERCAT = 29;
    private static final int INDEX_USERTAG = 30;
    private static final int INDEX_USERTAG2 = 31;
    private static final int INDEX_USERTAG3 = 32;
    private static final int INDEX_USERTAG4 = 33;
    private static final int INDEX_VALIDFLAG = 34;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysTCInputBase proxyPSSysTCInputBase = null;
    private boolean actionparamsDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean defpssyssamplevalueidDirtyFlag = false;
    private boolean defpssyssamplevaluenameDirtyFlag = false;
    private boolean defvalueDirtyFlag = false;
    private boolean inputtagDirtyFlag = false;
    private boolean inputtag2DirtyFlag = false;
    private boolean inputtag3DirtyFlag = false;
    private boolean inputtag4DirtyFlag = false;
    private boolean inputtypeDirtyFlag = false;
    private boolean inputvaluesDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssystcinputidDirtyFlag = false;
    private boolean pssystcinputnameDirtyFlag = false;
    private boolean pssystestcaseidDirtyFlag = false;
    private boolean pssystestcasenameDirtyFlag = false;
    private boolean pssystestdataidDirtyFlag = false;
    private boolean pssystestdatanameDirtyFlag = false;
    private boolean targettypeDirtyFlag = false;
    private boolean testdatasnDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="actionparams")
    private String actionparams;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="defpssyssamplevalueid")
    private String defpssyssamplevalueid;
    @Column(name="defpssyssamplevaluename")
    private String defpssyssamplevaluename;
    @Column(name="defvalue")
    private String defvalue;
    @Column(name="inputtag")
    private String inputtag;
    @Column(name="inputtag2")
    private String inputtag2;
    @Column(name="inputtag3")
    private String inputtag3;
    @Column(name="inputtag4")
    private String inputtag4;
    @Column(name="inputtype")
    private String inputtype;
    @Column(name="inputvalues")
    private String inputvalues;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssystcinputid")
    private String pssystcinputid;
    @Column(name="pssystcinputname")
    private String pssystcinputname;
    @Column(name="pssystestcaseid")
    private String pssystestcaseid;
    @Column(name="pssystestcasename")
    private String pssystestcasename;
    @Column(name="pssystestdataid")
    private String pssystestdataid;
    @Column(name="pssystestdataname")
    private String pssystestdataname;
    @Column(name="targettype")
    private String targettype;
    @Column(name="testdatasn")
    private Integer testdatasn;
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
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objDEFPSSysSampleValueLock = new Integer(1);
    private PSSysSampleValue defpssyssamplevalue = null;
    private Integer objPSSysTestCaseLock = new Integer(1);
    private PSSysTestCase pssystestcase = null;
    private Integer objPSSysTestDataLock = new Integer(1);
    private PSSysTestData pssystestdata = null;

    public void setActionParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionparams = string;
        this.actionparamsDirtyFlag = true;
    }

    public String getActionParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionParams();
        }
        return this.actionparams;
    }

    public boolean isActionParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionParamsDirty();
        }
        return this.actionparamsDirtyFlag;
    }

    public void resetActionParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionParams();
            return;
        }
        this.actionparamsDirtyFlag = false;
        this.actionparams = null;
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

    public void setDEFPSSysSampleValueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFPSSysSampleValueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defpssyssamplevalueid = string;
        this.defpssyssamplevalueidDirtyFlag = true;
    }

    public String getDEFPSSysSampleValueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFPSSysSampleValueId();
        }
        return this.defpssyssamplevalueid;
    }

    public boolean isDEFPSSysSampleValueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFPSSysSampleValueIdDirty();
        }
        return this.defpssyssamplevalueidDirtyFlag;
    }

    public void resetDEFPSSysSampleValueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFPSSysSampleValueId();
            return;
        }
        this.defpssyssamplevalueidDirtyFlag = false;
        this.defpssyssamplevalueid = null;
    }

    public void setDEFPSSysSampleValueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFPSSysSampleValueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defpssyssamplevaluename = string;
        this.defpssyssamplevaluenameDirtyFlag = true;
    }

    public String getDEFPSSysSampleValueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFPSSysSampleValueName();
        }
        return this.defpssyssamplevaluename;
    }

    public boolean isDEFPSSysSampleValueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFPSSysSampleValueNameDirty();
        }
        return this.defpssyssamplevaluenameDirtyFlag;
    }

    public void resetDEFPSSysSampleValueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFPSSysSampleValueName();
            return;
        }
        this.defpssyssamplevaluenameDirtyFlag = false;
        this.defpssyssamplevaluename = null;
    }

    public void setDEFValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defvalue = string;
        this.defvalueDirtyFlag = true;
    }

    public String getDEFValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFValue();
        }
        return this.defvalue;
    }

    public boolean isDEFValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFValueDirty();
        }
        return this.defvalueDirtyFlag;
    }

    public void resetDEFValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFValue();
            return;
        }
        this.defvalueDirtyFlag = false;
        this.defvalue = null;
    }

    public void setInputTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInputTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inputtag = string;
        this.inputtagDirtyFlag = true;
    }

    public String getInputTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInputTag();
        }
        return this.inputtag;
    }

    public boolean isInputTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInputTagDirty();
        }
        return this.inputtagDirtyFlag;
    }

    public void resetInputTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInputTag();
            return;
        }
        this.inputtagDirtyFlag = false;
        this.inputtag = null;
    }

    public void setInputTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInputTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inputtag2 = string;
        this.inputtag2DirtyFlag = true;
    }

    public String getInputTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInputTag2();
        }
        return this.inputtag2;
    }

    public boolean isInputTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInputTag2Dirty();
        }
        return this.inputtag2DirtyFlag;
    }

    public void resetInputTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInputTag2();
            return;
        }
        this.inputtag2DirtyFlag = false;
        this.inputtag2 = null;
    }

    public void setInputTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInputTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inputtag3 = string;
        this.inputtag3DirtyFlag = true;
    }

    public String getInputTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInputTag3();
        }
        return this.inputtag3;
    }

    public boolean isInputTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInputTag3Dirty();
        }
        return this.inputtag3DirtyFlag;
    }

    public void resetInputTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInputTag3();
            return;
        }
        this.inputtag3DirtyFlag = false;
        this.inputtag3 = null;
    }

    public void setInputTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInputTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inputtag4 = string;
        this.inputtag4DirtyFlag = true;
    }

    public String getInputTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInputTag4();
        }
        return this.inputtag4;
    }

    public boolean isInputTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInputTag4Dirty();
        }
        return this.inputtag4DirtyFlag;
    }

    public void resetInputTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInputTag4();
            return;
        }
        this.inputtag4DirtyFlag = false;
        this.inputtag4 = null;
    }

    public void setInputType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInputType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inputtype = string;
        this.inputtypeDirtyFlag = true;
    }

    public String getInputType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInputType();
        }
        return this.inputtype;
    }

    public boolean isInputTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInputTypeDirty();
        }
        return this.inputtypeDirtyFlag;
    }

    public void resetInputType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInputType();
            return;
        }
        this.inputtypeDirtyFlag = false;
        this.inputtype = null;
    }

    public void setInputValues(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInputValues(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inputvalues = string;
        this.inputvaluesDirtyFlag = true;
    }

    public String getInputValues() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInputValues();
        }
        return this.inputvalues;
    }

    public boolean isInputValuesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInputValuesDirty();
        }
        return this.inputvaluesDirtyFlag;
    }

    public void resetInputValues() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInputValues();
            return;
        }
        this.inputvaluesDirtyFlag = false;
        this.inputvalues = null;
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

    public void setPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionname = string;
        this.psdeactionnameDirtyFlag = true;
    }

    public String getPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionName();
        }
        return this.psdeactionname;
    }

    public boolean isPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionNameDirty();
        }
        return this.psdeactionnameDirtyFlag;
    }

    public void resetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionName();
            return;
        }
        this.psdeactionnameDirtyFlag = false;
        this.psdeactionname = null;
    }

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
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

    public void setPSSysTCInputId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTCInputId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystcinputid = string;
        this.pssystcinputidDirtyFlag = true;
    }

    public String getPSSysTCInputId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTCInputId();
        }
        return this.pssystcinputid;
    }

    public boolean isPSSysTCInputIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTCInputIdDirty();
        }
        return this.pssystcinputidDirtyFlag;
    }

    public void resetPSSysTCInputId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTCInputId();
            return;
        }
        this.pssystcinputidDirtyFlag = false;
        this.pssystcinputid = null;
    }

    public void setPSSysTCInputName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTCInputName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystcinputname = string;
        this.pssystcinputnameDirtyFlag = true;
    }

    public String getPSSysTCInputName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTCInputName();
        }
        return this.pssystcinputname;
    }

    public boolean isPSSysTCInputNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTCInputNameDirty();
        }
        return this.pssystcinputnameDirtyFlag;
    }

    public void resetPSSysTCInputName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTCInputName();
            return;
        }
        this.pssystcinputnameDirtyFlag = false;
        this.pssystcinputname = null;
    }

    public void setPSSysTestCaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestCaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestcaseid = string;
        this.pssystestcaseidDirtyFlag = true;
    }

    public String getPSSysTestCaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCaseId();
        }
        return this.pssystestcaseid;
    }

    public boolean isPSSysTestCaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestCaseIdDirty();
        }
        return this.pssystestcaseidDirtyFlag;
    }

    public void resetPSSysTestCaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestCaseId();
            return;
        }
        this.pssystestcaseidDirtyFlag = false;
        this.pssystestcaseid = null;
    }

    public void setPSSysTestCaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestCaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestcasename = string;
        this.pssystestcasenameDirtyFlag = true;
    }

    public String getPSSysTestCaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCaseName();
        }
        return this.pssystestcasename;
    }

    public boolean isPSSysTestCaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestCaseNameDirty();
        }
        return this.pssystestcasenameDirtyFlag;
    }

    public void resetPSSysTestCaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestCaseName();
            return;
        }
        this.pssystestcasenameDirtyFlag = false;
        this.pssystestcasename = null;
    }

    public void setPSSysTestDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestdataid = string;
        this.pssystestdataidDirtyFlag = true;
    }

    public String getPSSysTestDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestDataId();
        }
        return this.pssystestdataid;
    }

    public boolean isPSSysTestDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestDataIdDirty();
        }
        return this.pssystestdataidDirtyFlag;
    }

    public void resetPSSysTestDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestDataId();
            return;
        }
        this.pssystestdataidDirtyFlag = false;
        this.pssystestdataid = null;
    }

    public void setPSSysTestDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestdataname = string;
        this.pssystestdatanameDirtyFlag = true;
    }

    public String getPSSysTestDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestDataName();
        }
        return this.pssystestdataname;
    }

    public boolean isPSSysTestDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestDataNameDirty();
        }
        return this.pssystestdatanameDirtyFlag;
    }

    public void resetPSSysTestDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestDataName();
            return;
        }
        this.pssystestdatanameDirtyFlag = false;
        this.pssystestdataname = null;
    }

    public void setTargetType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTargetType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.targettype = string;
        this.targettypeDirtyFlag = true;
    }

    public String getTargetType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTargetType();
        }
        return this.targettype;
    }

    public boolean isTargetTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTargetTypeDirty();
        }
        return this.targettypeDirtyFlag;
    }

    public void resetTargetType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTargetType();
            return;
        }
        this.targettypeDirtyFlag = false;
        this.targettype = null;
    }

    public void setTestDataSN(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestDataSN(n);
            return;
        }
        this.testdatasn = n;
        this.testdatasnDirtyFlag = true;
    }

    public Integer getTestDataSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestDataSN();
        }
        return this.testdatasn;
    }

    public boolean isTestDataSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestDataSNDirty();
        }
        return this.testdatasnDirtyFlag;
    }

    public void resetTestDataSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestDataSN();
            return;
        }
        this.testdatasnDirtyFlag = false;
        this.testdatasn = null;
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
        PSSysTCInputBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysTCInputBase pSSysTCInputBase) {
        pSSysTCInputBase.resetActionParams();
        pSSysTCInputBase.resetCreateDate();
        pSSysTCInputBase.resetCreateMan();
        pSSysTCInputBase.resetCustomCode();
        pSSysTCInputBase.resetDEFPSSysSampleValueId();
        pSSysTCInputBase.resetDEFPSSysSampleValueName();
        pSSysTCInputBase.resetDEFValue();
        pSSysTCInputBase.resetInputTag();
        pSSysTCInputBase.resetInputTag2();
        pSSysTCInputBase.resetInputTag3();
        pSSysTCInputBase.resetInputTag4();
        pSSysTCInputBase.resetInputType();
        pSSysTCInputBase.resetInputValues();
        pSSysTCInputBase.resetMemo();
        pSSysTCInputBase.resetOrderValue();
        pSSysTCInputBase.resetPSDEActionId();
        pSSysTCInputBase.resetPSDEActionName();
        pSSysTCInputBase.resetPSDEFId();
        pSSysTCInputBase.resetPSDEId();
        pSSysTCInputBase.resetPSSysTCInputId();
        pSSysTCInputBase.resetPSSysTCInputName();
        pSSysTCInputBase.resetPSSysTestCaseId();
        pSSysTCInputBase.resetPSSysTestCaseName();
        pSSysTCInputBase.resetPSSysTestDataId();
        pSSysTCInputBase.resetPSSysTestDataName();
        pSSysTCInputBase.resetTargetType();
        pSSysTCInputBase.resetTestDataSN();
        pSSysTCInputBase.resetUpdateDate();
        pSSysTCInputBase.resetUpdateMan();
        pSSysTCInputBase.resetUserCat();
        pSSysTCInputBase.resetUserTag();
        pSSysTCInputBase.resetUserTag2();
        pSSysTCInputBase.resetUserTag3();
        pSSysTCInputBase.resetUserTag4();
        pSSysTCInputBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionParamsDirty()) {
            hashMap.put(FIELD_ACTIONPARAMS, this.getActionParams());
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
        if (!bl || this.isDEFPSSysSampleValueIdDirty()) {
            hashMap.put(FIELD_DEFPSSYSSAMPLEVALUEID, this.getDEFPSSysSampleValueId());
        }
        if (!bl || this.isDEFPSSysSampleValueNameDirty()) {
            hashMap.put(FIELD_DEFPSSYSSAMPLEVALUENAME, this.getDEFPSSysSampleValueName());
        }
        if (!bl || this.isDEFValueDirty()) {
            hashMap.put(FIELD_DEFVALUE, this.getDEFValue());
        }
        if (!bl || this.isInputTagDirty()) {
            hashMap.put(FIELD_INPUTTAG, this.getInputTag());
        }
        if (!bl || this.isInputTag2Dirty()) {
            hashMap.put(FIELD_INPUTTAG2, this.getInputTag2());
        }
        if (!bl || this.isInputTag3Dirty()) {
            hashMap.put(FIELD_INPUTTAG3, this.getInputTag3());
        }
        if (!bl || this.isInputTag4Dirty()) {
            hashMap.put(FIELD_INPUTTAG4, this.getInputTag4());
        }
        if (!bl || this.isInputTypeDirty()) {
            hashMap.put(FIELD_INPUTTYPE, this.getInputType());
        }
        if (!bl || this.isInputValuesDirty()) {
            hashMap.put(FIELD_INPUTVALUES, this.getInputValues());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSSysTCInputIdDirty()) {
            hashMap.put(FIELD_PSSYSTCINPUTID, this.getPSSysTCInputId());
        }
        if (!bl || this.isPSSysTCInputNameDirty()) {
            hashMap.put(FIELD_PSSYSTCINPUTNAME, this.getPSSysTCInputName());
        }
        if (!bl || this.isPSSysTestCaseIdDirty()) {
            hashMap.put(FIELD_PSSYSTESTCASEID, this.getPSSysTestCaseId());
        }
        if (!bl || this.isPSSysTestCaseNameDirty()) {
            hashMap.put(FIELD_PSSYSTESTCASENAME, this.getPSSysTestCaseName());
        }
        if (!bl || this.isPSSysTestDataIdDirty()) {
            hashMap.put(FIELD_PSSYSTESTDATAID, this.getPSSysTestDataId());
        }
        if (!bl || this.isPSSysTestDataNameDirty()) {
            hashMap.put(FIELD_PSSYSTESTDATANAME, this.getPSSysTestDataName());
        }
        if (!bl || this.isTargetTypeDirty()) {
            hashMap.put(FIELD_TARGETTYPE, this.getTargetType());
        }
        if (!bl || this.isTestDataSNDirty()) {
            hashMap.put(FIELD_TESTDATASN, this.getTestDataSN());
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
        return PSSysTCInputBase.get(this, n);
    }

    private static Object get(PSSysTCInputBase pSSysTCInputBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTCInputBase.getActionParams();
            }
            case 1: {
                return pSSysTCInputBase.getCreateDate();
            }
            case 2: {
                return pSSysTCInputBase.getCreateMan();
            }
            case 3: {
                return pSSysTCInputBase.getCustomCode();
            }
            case 4: {
                return pSSysTCInputBase.getDEFPSSysSampleValueId();
            }
            case 5: {
                return pSSysTCInputBase.getDEFPSSysSampleValueName();
            }
            case 6: {
                return pSSysTCInputBase.getDEFValue();
            }
            case 7: {
                return pSSysTCInputBase.getInputTag();
            }
            case 8: {
                return pSSysTCInputBase.getInputTag2();
            }
            case 9: {
                return pSSysTCInputBase.getInputTag3();
            }
            case 10: {
                return pSSysTCInputBase.getInputTag4();
            }
            case 11: {
                return pSSysTCInputBase.getInputType();
            }
            case 12: {
                return pSSysTCInputBase.getInputValues();
            }
            case 13: {
                return pSSysTCInputBase.getMemo();
            }
            case 14: {
                return pSSysTCInputBase.getOrderValue();
            }
            case 15: {
                return pSSysTCInputBase.getPSDEActionId();
            }
            case 16: {
                return pSSysTCInputBase.getPSDEActionName();
            }
            case 17: {
                return pSSysTCInputBase.getPSDEFId();
            }
            case 18: {
                return pSSysTCInputBase.getPSDEId();
            }
            case 19: {
                return pSSysTCInputBase.getPSSysTCInputId();
            }
            case 20: {
                return pSSysTCInputBase.getPSSysTCInputName();
            }
            case 21: {
                return pSSysTCInputBase.getPSSysTestCaseId();
            }
            case 22: {
                return pSSysTCInputBase.getPSSysTestCaseName();
            }
            case 23: {
                return pSSysTCInputBase.getPSSysTestDataId();
            }
            case 24: {
                return pSSysTCInputBase.getPSSysTestDataName();
            }
            case 25: {
                return pSSysTCInputBase.getTargetType();
            }
            case 26: {
                return pSSysTCInputBase.getTestDataSN();
            }
            case 27: {
                return pSSysTCInputBase.getUpdateDate();
            }
            case 28: {
                return pSSysTCInputBase.getUpdateMan();
            }
            case 29: {
                return pSSysTCInputBase.getUserCat();
            }
            case 30: {
                return pSSysTCInputBase.getUserTag();
            }
            case 31: {
                return pSSysTCInputBase.getUserTag2();
            }
            case 32: {
                return pSSysTCInputBase.getUserTag3();
            }
            case 33: {
                return pSSysTCInputBase.getUserTag4();
            }
            case 34: {
                return pSSysTCInputBase.getValidFlag();
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
        PSSysTCInputBase.set(this, n, object);
    }

    private static void set(PSSysTCInputBase pSSysTCInputBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysTCInputBase.setActionParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysTCInputBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysTCInputBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysTCInputBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysTCInputBase.setDEFPSSysSampleValueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysTCInputBase.setDEFPSSysSampleValueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysTCInputBase.setDEFValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysTCInputBase.setInputTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysTCInputBase.setInputTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysTCInputBase.setInputTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysTCInputBase.setInputTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysTCInputBase.setInputType(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysTCInputBase.setInputValues(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysTCInputBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysTCInputBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSysTCInputBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysTCInputBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysTCInputBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysTCInputBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysTCInputBase.setPSSysTCInputId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysTCInputBase.setPSSysTCInputName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysTCInputBase.setPSSysTestCaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysTCInputBase.setPSSysTestCaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysTCInputBase.setPSSysTestDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysTCInputBase.setPSSysTestDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysTCInputBase.setTargetType(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysTCInputBase.setTestDataSN(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSSysTCInputBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSSysTCInputBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysTCInputBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysTCInputBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysTCInputBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysTCInputBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysTCInputBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysTCInputBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysTCInputBase.isNull(this, n);
    }

    private static boolean isNull(PSSysTCInputBase pSSysTCInputBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTCInputBase.getActionParams() == null;
            }
            case 1: {
                return pSSysTCInputBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysTCInputBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysTCInputBase.getCustomCode() == null;
            }
            case 4: {
                return pSSysTCInputBase.getDEFPSSysSampleValueId() == null;
            }
            case 5: {
                return pSSysTCInputBase.getDEFPSSysSampleValueName() == null;
            }
            case 6: {
                return pSSysTCInputBase.getDEFValue() == null;
            }
            case 7: {
                return pSSysTCInputBase.getInputTag() == null;
            }
            case 8: {
                return pSSysTCInputBase.getInputTag2() == null;
            }
            case 9: {
                return pSSysTCInputBase.getInputTag3() == null;
            }
            case 10: {
                return pSSysTCInputBase.getInputTag4() == null;
            }
            case 11: {
                return pSSysTCInputBase.getInputType() == null;
            }
            case 12: {
                return pSSysTCInputBase.getInputValues() == null;
            }
            case 13: {
                return pSSysTCInputBase.getMemo() == null;
            }
            case 14: {
                return pSSysTCInputBase.getOrderValue() == null;
            }
            case 15: {
                return pSSysTCInputBase.getPSDEActionId() == null;
            }
            case 16: {
                return pSSysTCInputBase.getPSDEActionName() == null;
            }
            case 17: {
                return pSSysTCInputBase.getPSDEFId() == null;
            }
            case 18: {
                return pSSysTCInputBase.getPSDEId() == null;
            }
            case 19: {
                return pSSysTCInputBase.getPSSysTCInputId() == null;
            }
            case 20: {
                return pSSysTCInputBase.getPSSysTCInputName() == null;
            }
            case 21: {
                return pSSysTCInputBase.getPSSysTestCaseId() == null;
            }
            case 22: {
                return pSSysTCInputBase.getPSSysTestCaseName() == null;
            }
            case 23: {
                return pSSysTCInputBase.getPSSysTestDataId() == null;
            }
            case 24: {
                return pSSysTCInputBase.getPSSysTestDataName() == null;
            }
            case 25: {
                return pSSysTCInputBase.getTargetType() == null;
            }
            case 26: {
                return pSSysTCInputBase.getTestDataSN() == null;
            }
            case 27: {
                return pSSysTCInputBase.getUpdateDate() == null;
            }
            case 28: {
                return pSSysTCInputBase.getUpdateMan() == null;
            }
            case 29: {
                return pSSysTCInputBase.getUserCat() == null;
            }
            case 30: {
                return pSSysTCInputBase.getUserTag() == null;
            }
            case 31: {
                return pSSysTCInputBase.getUserTag2() == null;
            }
            case 32: {
                return pSSysTCInputBase.getUserTag3() == null;
            }
            case 33: {
                return pSSysTCInputBase.getUserTag4() == null;
            }
            case 34: {
                return pSSysTCInputBase.getValidFlag() == null;
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
        return PSSysTCInputBase.contains(this, n);
    }

    private static boolean contains(PSSysTCInputBase pSSysTCInputBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTCInputBase.isActionParamsDirty();
            }
            case 1: {
                return pSSysTCInputBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysTCInputBase.isCreateManDirty();
            }
            case 3: {
                return pSSysTCInputBase.isCustomCodeDirty();
            }
            case 4: {
                return pSSysTCInputBase.isDEFPSSysSampleValueIdDirty();
            }
            case 5: {
                return pSSysTCInputBase.isDEFPSSysSampleValueNameDirty();
            }
            case 6: {
                return pSSysTCInputBase.isDEFValueDirty();
            }
            case 7: {
                return pSSysTCInputBase.isInputTagDirty();
            }
            case 8: {
                return pSSysTCInputBase.isInputTag2Dirty();
            }
            case 9: {
                return pSSysTCInputBase.isInputTag3Dirty();
            }
            case 10: {
                return pSSysTCInputBase.isInputTag4Dirty();
            }
            case 11: {
                return pSSysTCInputBase.isInputTypeDirty();
            }
            case 12: {
                return pSSysTCInputBase.isInputValuesDirty();
            }
            case 13: {
                return pSSysTCInputBase.isMemoDirty();
            }
            case 14: {
                return pSSysTCInputBase.isOrderValueDirty();
            }
            case 15: {
                return pSSysTCInputBase.isPSDEActionIdDirty();
            }
            case 16: {
                return pSSysTCInputBase.isPSDEActionNameDirty();
            }
            case 17: {
                return pSSysTCInputBase.isPSDEFIdDirty();
            }
            case 18: {
                return pSSysTCInputBase.isPSDEIdDirty();
            }
            case 19: {
                return pSSysTCInputBase.isPSSysTCInputIdDirty();
            }
            case 20: {
                return pSSysTCInputBase.isPSSysTCInputNameDirty();
            }
            case 21: {
                return pSSysTCInputBase.isPSSysTestCaseIdDirty();
            }
            case 22: {
                return pSSysTCInputBase.isPSSysTestCaseNameDirty();
            }
            case 23: {
                return pSSysTCInputBase.isPSSysTestDataIdDirty();
            }
            case 24: {
                return pSSysTCInputBase.isPSSysTestDataNameDirty();
            }
            case 25: {
                return pSSysTCInputBase.isTargetTypeDirty();
            }
            case 26: {
                return pSSysTCInputBase.isTestDataSNDirty();
            }
            case 27: {
                return pSSysTCInputBase.isUpdateDateDirty();
            }
            case 28: {
                return pSSysTCInputBase.isUpdateManDirty();
            }
            case 29: {
                return pSSysTCInputBase.isUserCatDirty();
            }
            case 30: {
                return pSSysTCInputBase.isUserTagDirty();
            }
            case 31: {
                return pSSysTCInputBase.isUserTag2Dirty();
            }
            case 32: {
                return pSSysTCInputBase.isUserTag3Dirty();
            }
            case 33: {
                return pSSysTCInputBase.isUserTag4Dirty();
            }
            case 34: {
                return pSSysTCInputBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysTCInputBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysTCInputBase pSSysTCInputBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysTCInputBase.getActionParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionparams", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getActionParams()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getDEFPSSysSampleValueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defpssyssamplevalueid", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getDEFPSSysSampleValueId()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getDEFPSSysSampleValueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defpssyssamplevaluename", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getDEFPSSysSampleValueName()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getDEFValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defvalue", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getDEFValue()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getInputTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inputtag", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getInputTag()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getInputTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inputtag2", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getInputTag2()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getInputTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inputtag3", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getInputTag3()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getInputTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inputtag4", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getInputTag4()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getInputType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inputtype", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getInputType()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getInputValues() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inputvalues", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getInputValues()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getPSSysTCInputId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystcinputid", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getPSSysTCInputId()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getPSSysTCInputName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystcinputname", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getPSSysTCInputName()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getPSSysTestCaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestcaseid", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getPSSysTestCaseId()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getPSSysTestCaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestcasename", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getPSSysTestCaseName()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getPSSysTestDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestdataid", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getPSSysTestDataId()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getPSSysTestDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestdataname", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getPSSysTestDataName()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getTargetType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"targettype", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getTargetType()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getTestDataSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testdatasn", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getTestDataSN()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysTCInputBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysTCInputBase.getJSONValue((Object)pSSysTCInputBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysTCInputBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysTCInputBase pSSysTCInputBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysTCInputBase.getActionParams() != null) {
            object = pSSysTCInputBase.getActionParams();
            xmlNode.setAttribute(FIELD_ACTIONPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getCreateDate() != null) {
            object = pSSysTCInputBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTCInputBase.getCreateMan() != null) {
            object = pSSysTCInputBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getCustomCode() != null) {
            object = pSSysTCInputBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getDEFPSSysSampleValueId() != null) {
            object = pSSysTCInputBase.getDEFPSSysSampleValueId();
            xmlNode.setAttribute(FIELD_DEFPSSYSSAMPLEVALUEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getDEFPSSysSampleValueName() != null) {
            object = pSSysTCInputBase.getDEFPSSysSampleValueName();
            xmlNode.setAttribute(FIELD_DEFPSSYSSAMPLEVALUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getDEFValue() != null) {
            object = pSSysTCInputBase.getDEFValue();
            xmlNode.setAttribute(FIELD_DEFVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getInputTag() != null) {
            object = pSSysTCInputBase.getInputTag();
            xmlNode.setAttribute(FIELD_INPUTTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getInputTag2() != null) {
            object = pSSysTCInputBase.getInputTag2();
            xmlNode.setAttribute(FIELD_INPUTTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getInputTag3() != null) {
            object = pSSysTCInputBase.getInputTag3();
            xmlNode.setAttribute(FIELD_INPUTTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getInputTag4() != null) {
            object = pSSysTCInputBase.getInputTag4();
            xmlNode.setAttribute(FIELD_INPUTTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getInputType() != null) {
            object = pSSysTCInputBase.getInputType();
            xmlNode.setAttribute(FIELD_INPUTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getInputValues() != null) {
            object = pSSysTCInputBase.getInputValues();
            xmlNode.setAttribute(FIELD_INPUTVALUES, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getMemo() != null) {
            object = pSSysTCInputBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getOrderValue() != null) {
            object = pSSysTCInputBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTCInputBase.getPSDEActionId() != null) {
            object = pSSysTCInputBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getPSDEActionName() != null) {
            object = pSSysTCInputBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getPSDEFId() != null) {
            object = pSSysTCInputBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getPSDEId() != null) {
            object = pSSysTCInputBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getPSSysTCInputId() != null) {
            object = pSSysTCInputBase.getPSSysTCInputId();
            xmlNode.setAttribute(FIELD_PSSYSTCINPUTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getPSSysTCInputName() != null) {
            object = pSSysTCInputBase.getPSSysTCInputName();
            xmlNode.setAttribute(FIELD_PSSYSTCINPUTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getPSSysTestCaseId() != null) {
            object = pSSysTCInputBase.getPSSysTestCaseId();
            xmlNode.setAttribute(FIELD_PSSYSTESTCASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getPSSysTestCaseName() != null) {
            object = pSSysTCInputBase.getPSSysTestCaseName();
            xmlNode.setAttribute(FIELD_PSSYSTESTCASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getPSSysTestDataId() != null) {
            object = pSSysTCInputBase.getPSSysTestDataId();
            xmlNode.setAttribute(FIELD_PSSYSTESTDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getPSSysTestDataName() != null) {
            object = pSSysTCInputBase.getPSSysTestDataName();
            xmlNode.setAttribute(FIELD_PSSYSTESTDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getTargetType() != null) {
            object = pSSysTCInputBase.getTargetType();
            xmlNode.setAttribute(FIELD_TARGETTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getTestDataSN() != null) {
            object = pSSysTCInputBase.getTestDataSN();
            xmlNode.setAttribute(FIELD_TESTDATASN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTCInputBase.getUpdateDate() != null) {
            object = pSSysTCInputBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTCInputBase.getUpdateMan() != null) {
            object = pSSysTCInputBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getUserCat() != null) {
            object = pSSysTCInputBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getUserTag() != null) {
            object = pSSysTCInputBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getUserTag2() != null) {
            object = pSSysTCInputBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getUserTag3() != null) {
            object = pSSysTCInputBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getUserTag4() != null) {
            object = pSSysTCInputBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysTCInputBase.getValidFlag() != null) {
            object = pSSysTCInputBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysTCInputBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysTCInputBase pSSysTCInputBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysTCInputBase.isActionParamsDirty() && (bl || pSSysTCInputBase.getActionParams() != null)) {
            iDataObject.set(FIELD_ACTIONPARAMS, (Object)pSSysTCInputBase.getActionParams());
        }
        if (pSSysTCInputBase.isCreateDateDirty() && (bl || pSSysTCInputBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysTCInputBase.getCreateDate());
        }
        if (pSSysTCInputBase.isCreateManDirty() && (bl || pSSysTCInputBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysTCInputBase.getCreateMan());
        }
        if (pSSysTCInputBase.isCustomCodeDirty() && (bl || pSSysTCInputBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysTCInputBase.getCustomCode());
        }
        if (pSSysTCInputBase.isDEFPSSysSampleValueIdDirty() && (bl || pSSysTCInputBase.getDEFPSSysSampleValueId() != null)) {
            iDataObject.set(FIELD_DEFPSSYSSAMPLEVALUEID, (Object)pSSysTCInputBase.getDEFPSSysSampleValueId());
        }
        if (pSSysTCInputBase.isDEFPSSysSampleValueNameDirty() && (bl || pSSysTCInputBase.getDEFPSSysSampleValueName() != null)) {
            iDataObject.set(FIELD_DEFPSSYSSAMPLEVALUENAME, (Object)pSSysTCInputBase.getDEFPSSysSampleValueName());
        }
        if (pSSysTCInputBase.isDEFValueDirty() && (bl || pSSysTCInputBase.getDEFValue() != null)) {
            iDataObject.set(FIELD_DEFVALUE, (Object)pSSysTCInputBase.getDEFValue());
        }
        if (pSSysTCInputBase.isInputTagDirty() && (bl || pSSysTCInputBase.getInputTag() != null)) {
            iDataObject.set(FIELD_INPUTTAG, (Object)pSSysTCInputBase.getInputTag());
        }
        if (pSSysTCInputBase.isInputTag2Dirty() && (bl || pSSysTCInputBase.getInputTag2() != null)) {
            iDataObject.set(FIELD_INPUTTAG2, (Object)pSSysTCInputBase.getInputTag2());
        }
        if (pSSysTCInputBase.isInputTag3Dirty() && (bl || pSSysTCInputBase.getInputTag3() != null)) {
            iDataObject.set(FIELD_INPUTTAG3, (Object)pSSysTCInputBase.getInputTag3());
        }
        if (pSSysTCInputBase.isInputTag4Dirty() && (bl || pSSysTCInputBase.getInputTag4() != null)) {
            iDataObject.set(FIELD_INPUTTAG4, (Object)pSSysTCInputBase.getInputTag4());
        }
        if (pSSysTCInputBase.isInputTypeDirty() && (bl || pSSysTCInputBase.getInputType() != null)) {
            iDataObject.set(FIELD_INPUTTYPE, (Object)pSSysTCInputBase.getInputType());
        }
        if (pSSysTCInputBase.isInputValuesDirty() && (bl || pSSysTCInputBase.getInputValues() != null)) {
            iDataObject.set(FIELD_INPUTVALUES, (Object)pSSysTCInputBase.getInputValues());
        }
        if (pSSysTCInputBase.isMemoDirty() && (bl || pSSysTCInputBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysTCInputBase.getMemo());
        }
        if (pSSysTCInputBase.isOrderValueDirty() && (bl || pSSysTCInputBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysTCInputBase.getOrderValue());
        }
        if (pSSysTCInputBase.isPSDEActionIdDirty() && (bl || pSSysTCInputBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSSysTCInputBase.getPSDEActionId());
        }
        if (pSSysTCInputBase.isPSDEActionNameDirty() && (bl || pSSysTCInputBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSSysTCInputBase.getPSDEActionName());
        }
        if (pSSysTCInputBase.isPSDEFIdDirty() && (bl || pSSysTCInputBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSSysTCInputBase.getPSDEFId());
        }
        if (pSSysTCInputBase.isPSDEIdDirty() && (bl || pSSysTCInputBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysTCInputBase.getPSDEId());
        }
        if (pSSysTCInputBase.isPSSysTCInputIdDirty() && (bl || pSSysTCInputBase.getPSSysTCInputId() != null)) {
            iDataObject.set(FIELD_PSSYSTCINPUTID, (Object)pSSysTCInputBase.getPSSysTCInputId());
        }
        if (pSSysTCInputBase.isPSSysTCInputNameDirty() && (bl || pSSysTCInputBase.getPSSysTCInputName() != null)) {
            iDataObject.set(FIELD_PSSYSTCINPUTNAME, (Object)pSSysTCInputBase.getPSSysTCInputName());
        }
        if (pSSysTCInputBase.isPSSysTestCaseIdDirty() && (bl || pSSysTCInputBase.getPSSysTestCaseId() != null)) {
            iDataObject.set(FIELD_PSSYSTESTCASEID, (Object)pSSysTCInputBase.getPSSysTestCaseId());
        }
        if (pSSysTCInputBase.isPSSysTestCaseNameDirty() && (bl || pSSysTCInputBase.getPSSysTestCaseName() != null)) {
            iDataObject.set(FIELD_PSSYSTESTCASENAME, (Object)pSSysTCInputBase.getPSSysTestCaseName());
        }
        if (pSSysTCInputBase.isPSSysTestDataIdDirty() && (bl || pSSysTCInputBase.getPSSysTestDataId() != null)) {
            iDataObject.set(FIELD_PSSYSTESTDATAID, (Object)pSSysTCInputBase.getPSSysTestDataId());
        }
        if (pSSysTCInputBase.isPSSysTestDataNameDirty() && (bl || pSSysTCInputBase.getPSSysTestDataName() != null)) {
            iDataObject.set(FIELD_PSSYSTESTDATANAME, (Object)pSSysTCInputBase.getPSSysTestDataName());
        }
        if (pSSysTCInputBase.isTargetTypeDirty() && (bl || pSSysTCInputBase.getTargetType() != null)) {
            iDataObject.set(FIELD_TARGETTYPE, (Object)pSSysTCInputBase.getTargetType());
        }
        if (pSSysTCInputBase.isTestDataSNDirty() && (bl || pSSysTCInputBase.getTestDataSN() != null)) {
            iDataObject.set(FIELD_TESTDATASN, (Object)pSSysTCInputBase.getTestDataSN());
        }
        if (pSSysTCInputBase.isUpdateDateDirty() && (bl || pSSysTCInputBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysTCInputBase.getUpdateDate());
        }
        if (pSSysTCInputBase.isUpdateManDirty() && (bl || pSSysTCInputBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysTCInputBase.getUpdateMan());
        }
        if (pSSysTCInputBase.isUserCatDirty() && (bl || pSSysTCInputBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysTCInputBase.getUserCat());
        }
        if (pSSysTCInputBase.isUserTagDirty() && (bl || pSSysTCInputBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysTCInputBase.getUserTag());
        }
        if (pSSysTCInputBase.isUserTag2Dirty() && (bl || pSSysTCInputBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysTCInputBase.getUserTag2());
        }
        if (pSSysTCInputBase.isUserTag3Dirty() && (bl || pSSysTCInputBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysTCInputBase.getUserTag3());
        }
        if (pSSysTCInputBase.isUserTag4Dirty() && (bl || pSSysTCInputBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysTCInputBase.getUserTag4());
        }
        if (pSSysTCInputBase.isValidFlagDirty() && (bl || pSSysTCInputBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysTCInputBase.getValidFlag());
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
        return PSSysTCInputBase.remove(this, n);
    }

    private static boolean remove(PSSysTCInputBase pSSysTCInputBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysTCInputBase.resetActionParams();
                return true;
            }
            case 1: {
                pSSysTCInputBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysTCInputBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysTCInputBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSSysTCInputBase.resetDEFPSSysSampleValueId();
                return true;
            }
            case 5: {
                pSSysTCInputBase.resetDEFPSSysSampleValueName();
                return true;
            }
            case 6: {
                pSSysTCInputBase.resetDEFValue();
                return true;
            }
            case 7: {
                pSSysTCInputBase.resetInputTag();
                return true;
            }
            case 8: {
                pSSysTCInputBase.resetInputTag2();
                return true;
            }
            case 9: {
                pSSysTCInputBase.resetInputTag3();
                return true;
            }
            case 10: {
                pSSysTCInputBase.resetInputTag4();
                return true;
            }
            case 11: {
                pSSysTCInputBase.resetInputType();
                return true;
            }
            case 12: {
                pSSysTCInputBase.resetInputValues();
                return true;
            }
            case 13: {
                pSSysTCInputBase.resetMemo();
                return true;
            }
            case 14: {
                pSSysTCInputBase.resetOrderValue();
                return true;
            }
            case 15: {
                pSSysTCInputBase.resetPSDEActionId();
                return true;
            }
            case 16: {
                pSSysTCInputBase.resetPSDEActionName();
                return true;
            }
            case 17: {
                pSSysTCInputBase.resetPSDEFId();
                return true;
            }
            case 18: {
                pSSysTCInputBase.resetPSDEId();
                return true;
            }
            case 19: {
                pSSysTCInputBase.resetPSSysTCInputId();
                return true;
            }
            case 20: {
                pSSysTCInputBase.resetPSSysTCInputName();
                return true;
            }
            case 21: {
                pSSysTCInputBase.resetPSSysTestCaseId();
                return true;
            }
            case 22: {
                pSSysTCInputBase.resetPSSysTestCaseName();
                return true;
            }
            case 23: {
                pSSysTCInputBase.resetPSSysTestDataId();
                return true;
            }
            case 24: {
                pSSysTCInputBase.resetPSSysTestDataName();
                return true;
            }
            case 25: {
                pSSysTCInputBase.resetTargetType();
                return true;
            }
            case 26: {
                pSSysTCInputBase.resetTestDataSN();
                return true;
            }
            case 27: {
                pSSysTCInputBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSSysTCInputBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSSysTCInputBase.resetUserCat();
                return true;
            }
            case 30: {
                pSSysTCInputBase.resetUserTag();
                return true;
            }
            case 31: {
                pSSysTCInputBase.resetUserTag2();
                return true;
            }
            case 32: {
                pSSysTCInputBase.resetUserTag3();
                return true;
            }
            case 33: {
                pSSysTCInputBase.resetUserTag4();
                return true;
            }
            case 34: {
                pSSysTCInputBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAction();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSampleValue getDEFPSSysSampleValue() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFPSSysSampleValue();
        }
        if (this.getDEFPSSysSampleValueId() == null) {
            return null;
        }
        Integer n = this.objDEFPSSysSampleValueLock;
        synchronized (n) {
            if (this.defpssyssamplevalue != null && DataTypeHelper.compare((int)25, (Object)this.getDEFPSSysSampleValueId(), (Object)this.defpssyssamplevalue.getPSSysSampleValueId()) != 0L) {
                this.defpssyssamplevalue = null;
            }
            if (this.defpssyssamplevalue == null) {
                PSSysSampleValue pSSysSampleValue = new PSSysSampleValue();
                pSSysSampleValue.setPSSysSampleValueId(this.getDEFPSSysSampleValueId());
                PSSysSampleValueService pSSysSampleValueService = (PSSysSampleValueService)ServiceGlobal.getService(PSSysSampleValueService.class, (SessionFactory)this.getSessionFactory());
                pSSysSampleValueService.autoGet((IEntity)pSSysSampleValue);
                this.defpssyssamplevalue = pSSysSampleValue;
            }
            return this.defpssyssamplevalue;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTestCase getPSSysTestCase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCase();
        }
        if (this.getPSSysTestCaseId() == null) {
            return null;
        }
        Integer n = this.objPSSysTestCaseLock;
        synchronized (n) {
            if (this.pssystestcase != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTestCaseId(), (Object)this.pssystestcase.getPSSysTestCaseId()) != 0L) {
                this.pssystestcase = null;
            }
            if (this.pssystestcase == null) {
                PSSysTestCase pSSysTestCase = new PSSysTestCase();
                pSSysTestCase.setPSSysTestCaseId(this.getPSSysTestCaseId());
                PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
                pSSysTestCaseService.autoGet((IEntity)pSSysTestCase);
                this.pssystestcase = pSSysTestCase;
            }
            return this.pssystestcase;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTestData getPSSysTestData() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestData();
        }
        if (this.getPSSysTestDataId() == null) {
            return null;
        }
        Integer n = this.objPSSysTestDataLock;
        synchronized (n) {
            if (this.pssystestdata != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTestDataId(), (Object)this.pssystestdata.getPSSysTestDataId()) != 0L) {
                this.pssystestdata = null;
            }
            if (this.pssystestdata == null) {
                PSSysTestData pSSysTestData = new PSSysTestData();
                pSSysTestData.setPSSysTestDataId(this.getPSSysTestDataId());
                PSSysTestDataService pSSysTestDataService = (PSSysTestDataService)ServiceGlobal.getService(PSSysTestDataService.class, (SessionFactory)this.getSessionFactory());
                pSSysTestDataService.autoGet((IEntity)pSSysTestData);
                this.pssystestdata = pSSysTestData;
            }
            return this.pssystestdata;
        }
    }

    private PSSysTCInputBase getProxyEntity() {
        return this.proxyPSSysTCInputBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysTCInputBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysTCInputBase) {
            this.proxyPSSysTCInputBase = (PSSysTCInputBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTCInputService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONPARAMS, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 3);
        fieldIndexMap.put(FIELD_DEFPSSYSSAMPLEVALUEID, 4);
        fieldIndexMap.put(FIELD_DEFPSSYSSAMPLEVALUENAME, 5);
        fieldIndexMap.put(FIELD_DEFVALUE, 6);
        fieldIndexMap.put(FIELD_INPUTTAG, 7);
        fieldIndexMap.put(FIELD_INPUTTAG2, 8);
        fieldIndexMap.put(FIELD_INPUTTAG3, 9);
        fieldIndexMap.put(FIELD_INPUTTAG4, 10);
        fieldIndexMap.put(FIELD_INPUTTYPE, 11);
        fieldIndexMap.put(FIELD_INPUTVALUES, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_ORDERVALUE, 14);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 15);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 16);
        fieldIndexMap.put(FIELD_PSDEFID, 17);
        fieldIndexMap.put(FIELD_PSDEID, 18);
        fieldIndexMap.put(FIELD_PSSYSTCINPUTID, 19);
        fieldIndexMap.put(FIELD_PSSYSTCINPUTNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSTESTCASEID, 21);
        fieldIndexMap.put(FIELD_PSSYSTESTCASENAME, 22);
        fieldIndexMap.put(FIELD_PSSYSTESTDATAID, 23);
        fieldIndexMap.put(FIELD_PSSYSTESTDATANAME, 24);
        fieldIndexMap.put(FIELD_TARGETTYPE, 25);
        fieldIndexMap.put(FIELD_TESTDATASN, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_USERCAT, 29);
        fieldIndexMap.put(FIELD_USERTAG, 30);
        fieldIndexMap.put(FIELD_USERTAG2, 31);
        fieldIndexMap.put(FIELD_USERTAG3, 32);
        fieldIndexMap.put(FIELD_USERTAG4, 33);
        fieldIndexMap.put(FIELD_VALIDFLAG, 34);
    }
}

