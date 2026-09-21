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
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestModule;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestPrj;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestModuleService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestPrjService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTestModuleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysTestModuleBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODULETAG = "MODULETAG";
    public static final String FIELD_MODULETAG2 = "MODULETAG2";
    public static final String FIELD_MODULETYPE = "MODULETYPE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSSYSTESTMODULEID = "PPSSYSTESTMODULEID";
    public static final String FIELD_PPSSYSTESTMODULENAME = "PPSSYSTESTMODULENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_PSSYSTESTDATAID = "PSSYSTESTDATAID";
    public static final String FIELD_PSSYSTESTDATANAME = "PSSYSTESTDATANAME";
    public static final String FIELD_PSSYSTESTMODULEID = "PSSYSTESTMODULEID";
    public static final String FIELD_PSSYSTESTMODULENAME = "PSSYSTESTMODULENAME";
    public static final String FIELD_PSSYSTESTPRJID = "PSSYSTESTPRJID";
    public static final String FIELD_PSSYSTESTPRJNAME = "PSSYSTESTPRJNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_UTILPARAMS = "UTILPARAMS";
    public static final String FIELD_UTILTAG = "UTILTAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DATA = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MODULETAG = 5;
    private static final int INDEX_MODULETAG2 = 6;
    private static final int INDEX_MODULETYPE = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PPSSYSTESTMODULEID = 9;
    private static final int INDEX_PPSSYSTESTMODULENAME = 10;
    private static final int INDEX_PSSYSAPPID = 11;
    private static final int INDEX_PSSYSSERVICEAPIID = 12;
    private static final int INDEX_PSSYSTESTDATAID = 13;
    private static final int INDEX_PSSYSTESTDATANAME = 14;
    private static final int INDEX_PSSYSTESTMODULEID = 15;
    private static final int INDEX_PSSYSTESTMODULENAME = 16;
    private static final int INDEX_PSSYSTESTPRJID = 17;
    private static final int INDEX_PSSYSTESTPRJNAME = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERPARAMS = 22;
    private static final int INDEX_USERTAG = 23;
    private static final int INDEX_USERTAG2 = 24;
    private static final int INDEX_USERTAG3 = 25;
    private static final int INDEX_USERTAG4 = 26;
    private static final int INDEX_UTILPARAMS = 27;
    private static final int INDEX_UTILTAG = 28;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysTestModuleBase proxyPSSysTestModuleBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean moduletagDirtyFlag = false;
    private boolean moduletag2DirtyFlag = false;
    private boolean moduletypeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppssystestmoduleidDirtyFlag = false;
    private boolean ppssystestmodulenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean pssystestdataidDirtyFlag = false;
    private boolean pssystestdatanameDirtyFlag = false;
    private boolean pssystestmoduleidDirtyFlag = false;
    private boolean pssystestmodulenameDirtyFlag = false;
    private boolean pssystestprjidDirtyFlag = false;
    private boolean pssystestprjnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean utilparamsDirtyFlag = false;
    private boolean utiltagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="data")
    private String data;
    @Column(name="memo")
    private String memo;
    @Column(name="moduletag")
    private String moduletag;
    @Column(name="moduletag2")
    private String moduletag2;
    @Column(name="moduletype")
    private String moduletype;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppssystestmoduleid")
    private String ppssystestmoduleid;
    @Column(name="ppssystestmodulename")
    private String ppssystestmodulename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysserviceapiid")
    private String pssysserviceapiid;
    @Column(name="pssystestdataid")
    private String pssystestdataid;
    @Column(name="pssystestdataname")
    private String pssystestdataname;
    @Column(name="pssystestmoduleid")
    private String pssystestmoduleid;
    @Column(name="pssystestmodulename")
    private String pssystestmodulename;
    @Column(name="pssystestprjid")
    private String pssystestprjid;
    @Column(name="pssystestprjname")
    private String pssystestprjname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="utilparams")
    private String utilparams;
    @Column(name="utiltag")
    private String utiltag;
    private Integer objPSSysTestDataLock = new Integer(1);
    private PSSysTestData pssystestdata = null;
    private Integer objPPSSysTestModuleLock = new Integer(1);
    private PSSysTestModule ppssystestmodule = null;
    private Integer objPSSysTestPrjLock = new Integer(1);
    private PSSysTestPrj pssystestprj = null;
    private Integer objPSSysTestCasesLock = new Integer(1);
    private ArrayList<PSSysTestCase> pssystestcases = null;
    private Integer objPSSysTestModulesLock = new Integer(1);
    private ArrayList<PSSysTestModule> pssystestmodules = null;

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

    public void setData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data = string;
        this.dataDirtyFlag = true;
    }

    public String getData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData();
        }
        return this.data;
    }

    public boolean isDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataDirty();
        }
        return this.dataDirtyFlag;
    }

    public void resetData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData();
            return;
        }
        this.dataDirtyFlag = false;
        this.data = null;
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

    public void setModuleTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.moduletag = string;
        this.moduletagDirtyFlag = true;
    }

    public String getModuleTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleTag();
        }
        return this.moduletag;
    }

    public boolean isModuleTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleTagDirty();
        }
        return this.moduletagDirtyFlag;
    }

    public void resetModuleTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleTag();
            return;
        }
        this.moduletagDirtyFlag = false;
        this.moduletag = null;
    }

    public void setModuleTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.moduletag2 = string;
        this.moduletag2DirtyFlag = true;
    }

    public String getModuleTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleTag2();
        }
        return this.moduletag2;
    }

    public boolean isModuleTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleTag2Dirty();
        }
        return this.moduletag2DirtyFlag;
    }

    public void resetModuleTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleTag2();
            return;
        }
        this.moduletag2DirtyFlag = false;
        this.moduletag2 = null;
    }

    public void setModuleType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModuleType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.moduletype = string;
        this.moduletypeDirtyFlag = true;
    }

    public String getModuleType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModuleType();
        }
        return this.moduletype;
    }

    public boolean isModuleTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModuleTypeDirty();
        }
        return this.moduletypeDirtyFlag;
    }

    public void resetModuleType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModuleType();
            return;
        }
        this.moduletypeDirtyFlag = false;
        this.moduletype = null;
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

    public void setPPSSysTestModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysTestModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssystestmoduleid = string;
        this.ppssystestmoduleidDirtyFlag = true;
    }

    public String getPPSSysTestModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysTestModuleId();
        }
        return this.ppssystestmoduleid;
    }

    public boolean isPPSSysTestModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysTestModuleIdDirty();
        }
        return this.ppssystestmoduleidDirtyFlag;
    }

    public void resetPPSSysTestModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysTestModuleId();
            return;
        }
        this.ppssystestmoduleidDirtyFlag = false;
        this.ppssystestmoduleid = null;
    }

    public void setPPSSysTestModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysTestModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssystestmodulename = string;
        this.ppssystestmodulenameDirtyFlag = true;
    }

    public String getPPSSysTestModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysTestModuleName();
        }
        return this.ppssystestmodulename;
    }

    public boolean isPPSSysTestModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysTestModuleNameDirty();
        }
        return this.ppssystestmodulenameDirtyFlag;
    }

    public void resetPPSSysTestModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysTestModuleName();
            return;
        }
        this.ppssystestmodulenameDirtyFlag = false;
        this.ppssystestmodulename = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiid = string;
        this.pssysserviceapiidDirtyFlag = true;
    }

    public String getPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIId();
        }
        return this.pssysserviceapiid;
    }

    public boolean isPSSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPIIdDirty();
        }
        return this.pssysserviceapiidDirtyFlag;
    }

    public void resetPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIId();
            return;
        }
        this.pssysserviceapiidDirtyFlag = false;
        this.pssysserviceapiid = null;
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

    public void setPSSysTestModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestmoduleid = string;
        this.pssystestmoduleidDirtyFlag = true;
    }

    public String getPSSysTestModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestModuleId();
        }
        return this.pssystestmoduleid;
    }

    public boolean isPSSysTestModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestModuleIdDirty();
        }
        return this.pssystestmoduleidDirtyFlag;
    }

    public void resetPSSysTestModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestModuleId();
            return;
        }
        this.pssystestmoduleidDirtyFlag = false;
        this.pssystestmoduleid = null;
    }

    public void setPSSysTestModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestmodulename = string;
        this.pssystestmodulenameDirtyFlag = true;
    }

    public String getPSSysTestModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestModuleName();
        }
        return this.pssystestmodulename;
    }

    public boolean isPSSysTestModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestModuleNameDirty();
        }
        return this.pssystestmodulenameDirtyFlag;
    }

    public void resetPSSysTestModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestModuleName();
            return;
        }
        this.pssystestmodulenameDirtyFlag = false;
        this.pssystestmodulename = null;
    }

    public void setPSSysTestPrjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestPrjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestprjid = string;
        this.pssystestprjidDirtyFlag = true;
    }

    public String getPSSysTestPrjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestPrjId();
        }
        return this.pssystestprjid;
    }

    public boolean isPSSysTestPrjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestPrjIdDirty();
        }
        return this.pssystestprjidDirtyFlag;
    }

    public void resetPSSysTestPrjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestPrjId();
            return;
        }
        this.pssystestprjidDirtyFlag = false;
        this.pssystestprjid = null;
    }

    public void setPSSysTestPrjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTestPrjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystestprjname = string;
        this.pssystestprjnameDirtyFlag = true;
    }

    public String getPSSysTestPrjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestPrjName();
        }
        return this.pssystestprjname;
    }

    public boolean isPSSysTestPrjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTestPrjNameDirty();
        }
        return this.pssystestprjnameDirtyFlag;
    }

    public void resetPSSysTestPrjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTestPrjName();
            return;
        }
        this.pssystestprjnameDirtyFlag = false;
        this.pssystestprjname = null;
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

    public void setUtilParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparams = string;
        this.utilparamsDirtyFlag = true;
    }

    public String getUtilParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParams();
        }
        return this.utilparams;
    }

    public boolean isUtilParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParamsDirty();
        }
        return this.utilparamsDirtyFlag;
    }

    public void resetUtilParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParams();
            return;
        }
        this.utilparamsDirtyFlag = false;
        this.utilparams = null;
    }

    public void setUtilTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utiltag = string;
        this.utiltagDirtyFlag = true;
    }

    public String getUtilTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilTag();
        }
        return this.utiltag;
    }

    public boolean isUtilTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilTagDirty();
        }
        return this.utiltagDirtyFlag;
    }

    public void resetUtilTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilTag();
            return;
        }
        this.utiltagDirtyFlag = false;
        this.utiltag = null;
    }

    protected void onReset() {
        PSSysTestModuleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysTestModuleBase pSSysTestModuleBase) {
        pSSysTestModuleBase.resetCodeName();
        pSSysTestModuleBase.resetCreateDate();
        pSSysTestModuleBase.resetCreateMan();
        pSSysTestModuleBase.resetData();
        pSSysTestModuleBase.resetMemo();
        pSSysTestModuleBase.resetModuleTag();
        pSSysTestModuleBase.resetModuleTag2();
        pSSysTestModuleBase.resetModuleType();
        pSSysTestModuleBase.resetOrderValue();
        pSSysTestModuleBase.resetPPSSysTestModuleId();
        pSSysTestModuleBase.resetPPSSysTestModuleName();
        pSSysTestModuleBase.resetPSSysAppId();
        pSSysTestModuleBase.resetPSSysServiceAPIId();
        pSSysTestModuleBase.resetPSSysTestDataId();
        pSSysTestModuleBase.resetPSSysTestDataName();
        pSSysTestModuleBase.resetPSSysTestModuleId();
        pSSysTestModuleBase.resetPSSysTestModuleName();
        pSSysTestModuleBase.resetPSSysTestPrjId();
        pSSysTestModuleBase.resetPSSysTestPrjName();
        pSSysTestModuleBase.resetUpdateDate();
        pSSysTestModuleBase.resetUpdateMan();
        pSSysTestModuleBase.resetUserCat();
        pSSysTestModuleBase.resetUserParams();
        pSSysTestModuleBase.resetUserTag();
        pSSysTestModuleBase.resetUserTag2();
        pSSysTestModuleBase.resetUserTag3();
        pSSysTestModuleBase.resetUserTag4();
        pSSysTestModuleBase.resetUtilParams();
        pSSysTestModuleBase.resetUtilTag();
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
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModuleTagDirty()) {
            hashMap.put(FIELD_MODULETAG, this.getModuleTag());
        }
        if (!bl || this.isModuleTag2Dirty()) {
            hashMap.put(FIELD_MODULETAG2, this.getModuleTag2());
        }
        if (!bl || this.isModuleTypeDirty()) {
            hashMap.put(FIELD_MODULETYPE, this.getModuleType());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSSysTestModuleIdDirty()) {
            hashMap.put(FIELD_PPSSYSTESTMODULEID, this.getPPSSysTestModuleId());
        }
        if (!bl || this.isPPSSysTestModuleNameDirty()) {
            hashMap.put(FIELD_PPSSYSTESTMODULENAME, this.getPPSSysTestModuleName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPIID, this.getPSSysServiceAPIId());
        }
        if (!bl || this.isPSSysTestDataIdDirty()) {
            hashMap.put(FIELD_PSSYSTESTDATAID, this.getPSSysTestDataId());
        }
        if (!bl || this.isPSSysTestDataNameDirty()) {
            hashMap.put(FIELD_PSSYSTESTDATANAME, this.getPSSysTestDataName());
        }
        if (!bl || this.isPSSysTestModuleIdDirty()) {
            hashMap.put(FIELD_PSSYSTESTMODULEID, this.getPSSysTestModuleId());
        }
        if (!bl || this.isPSSysTestModuleNameDirty()) {
            hashMap.put(FIELD_PSSYSTESTMODULENAME, this.getPSSysTestModuleName());
        }
        if (!bl || this.isPSSysTestPrjIdDirty()) {
            hashMap.put(FIELD_PSSYSTESTPRJID, this.getPSSysTestPrjId());
        }
        if (!bl || this.isPSSysTestPrjNameDirty()) {
            hashMap.put(FIELD_PSSYSTESTPRJNAME, this.getPSSysTestPrjName());
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
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        if (!bl || this.isUtilParamsDirty()) {
            hashMap.put(FIELD_UTILPARAMS, this.getUtilParams());
        }
        if (!bl || this.isUtilTagDirty()) {
            hashMap.put(FIELD_UTILTAG, this.getUtilTag());
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
        return PSSysTestModuleBase.get(this, n);
    }

    private static Object get(PSSysTestModuleBase pSSysTestModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTestModuleBase.getCodeName();
            }
            case 1: {
                return pSSysTestModuleBase.getCreateDate();
            }
            case 2: {
                return pSSysTestModuleBase.getCreateMan();
            }
            case 3: {
                return pSSysTestModuleBase.getData();
            }
            case 4: {
                return pSSysTestModuleBase.getMemo();
            }
            case 5: {
                return pSSysTestModuleBase.getModuleTag();
            }
            case 6: {
                return pSSysTestModuleBase.getModuleTag2();
            }
            case 7: {
                return pSSysTestModuleBase.getModuleType();
            }
            case 8: {
                return pSSysTestModuleBase.getOrderValue();
            }
            case 9: {
                return pSSysTestModuleBase.getPPSSysTestModuleId();
            }
            case 10: {
                return pSSysTestModuleBase.getPPSSysTestModuleName();
            }
            case 11: {
                return pSSysTestModuleBase.getPSSysAppId();
            }
            case 12: {
                return pSSysTestModuleBase.getPSSysServiceAPIId();
            }
            case 13: {
                return pSSysTestModuleBase.getPSSysTestDataId();
            }
            case 14: {
                return pSSysTestModuleBase.getPSSysTestDataName();
            }
            case 15: {
                return pSSysTestModuleBase.getPSSysTestModuleId();
            }
            case 16: {
                return pSSysTestModuleBase.getPSSysTestModuleName();
            }
            case 17: {
                return pSSysTestModuleBase.getPSSysTestPrjId();
            }
            case 18: {
                return pSSysTestModuleBase.getPSSysTestPrjName();
            }
            case 19: {
                return pSSysTestModuleBase.getUpdateDate();
            }
            case 20: {
                return pSSysTestModuleBase.getUpdateMan();
            }
            case 21: {
                return pSSysTestModuleBase.getUserCat();
            }
            case 22: {
                return pSSysTestModuleBase.getUserParams();
            }
            case 23: {
                return pSSysTestModuleBase.getUserTag();
            }
            case 24: {
                return pSSysTestModuleBase.getUserTag2();
            }
            case 25: {
                return pSSysTestModuleBase.getUserTag3();
            }
            case 26: {
                return pSSysTestModuleBase.getUserTag4();
            }
            case 27: {
                return pSSysTestModuleBase.getUtilParams();
            }
            case 28: {
                return pSSysTestModuleBase.getUtilTag();
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
        PSSysTestModuleBase.set(this, n, object);
    }

    private static void set(PSSysTestModuleBase pSSysTestModuleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysTestModuleBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysTestModuleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysTestModuleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysTestModuleBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysTestModuleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysTestModuleBase.setModuleTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysTestModuleBase.setModuleTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysTestModuleBase.setModuleType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysTestModuleBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysTestModuleBase.setPPSSysTestModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysTestModuleBase.setPPSSysTestModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysTestModuleBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysTestModuleBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysTestModuleBase.setPSSysTestDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysTestModuleBase.setPSSysTestDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysTestModuleBase.setPSSysTestModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysTestModuleBase.setPSSysTestModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysTestModuleBase.setPSSysTestPrjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysTestModuleBase.setPSSysTestPrjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysTestModuleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSSysTestModuleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysTestModuleBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysTestModuleBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysTestModuleBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysTestModuleBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysTestModuleBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysTestModuleBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysTestModuleBase.setUtilParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysTestModuleBase.setUtilTag(DataObject.getStringValue((Object)object));
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
        return PSSysTestModuleBase.isNull(this, n);
    }

    private static boolean isNull(PSSysTestModuleBase pSSysTestModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTestModuleBase.getCodeName() == null;
            }
            case 1: {
                return pSSysTestModuleBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysTestModuleBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysTestModuleBase.getData() == null;
            }
            case 4: {
                return pSSysTestModuleBase.getMemo() == null;
            }
            case 5: {
                return pSSysTestModuleBase.getModuleTag() == null;
            }
            case 6: {
                return pSSysTestModuleBase.getModuleTag2() == null;
            }
            case 7: {
                return pSSysTestModuleBase.getModuleType() == null;
            }
            case 8: {
                return pSSysTestModuleBase.getOrderValue() == null;
            }
            case 9: {
                return pSSysTestModuleBase.getPPSSysTestModuleId() == null;
            }
            case 10: {
                return pSSysTestModuleBase.getPPSSysTestModuleName() == null;
            }
            case 11: {
                return pSSysTestModuleBase.getPSSysAppId() == null;
            }
            case 12: {
                return pSSysTestModuleBase.getPSSysServiceAPIId() == null;
            }
            case 13: {
                return pSSysTestModuleBase.getPSSysTestDataId() == null;
            }
            case 14: {
                return pSSysTestModuleBase.getPSSysTestDataName() == null;
            }
            case 15: {
                return pSSysTestModuleBase.getPSSysTestModuleId() == null;
            }
            case 16: {
                return pSSysTestModuleBase.getPSSysTestModuleName() == null;
            }
            case 17: {
                return pSSysTestModuleBase.getPSSysTestPrjId() == null;
            }
            case 18: {
                return pSSysTestModuleBase.getPSSysTestPrjName() == null;
            }
            case 19: {
                return pSSysTestModuleBase.getUpdateDate() == null;
            }
            case 20: {
                return pSSysTestModuleBase.getUpdateMan() == null;
            }
            case 21: {
                return pSSysTestModuleBase.getUserCat() == null;
            }
            case 22: {
                return pSSysTestModuleBase.getUserParams() == null;
            }
            case 23: {
                return pSSysTestModuleBase.getUserTag() == null;
            }
            case 24: {
                return pSSysTestModuleBase.getUserTag2() == null;
            }
            case 25: {
                return pSSysTestModuleBase.getUserTag3() == null;
            }
            case 26: {
                return pSSysTestModuleBase.getUserTag4() == null;
            }
            case 27: {
                return pSSysTestModuleBase.getUtilParams() == null;
            }
            case 28: {
                return pSSysTestModuleBase.getUtilTag() == null;
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
        return PSSysTestModuleBase.contains(this, n);
    }

    private static boolean contains(PSSysTestModuleBase pSSysTestModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTestModuleBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysTestModuleBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysTestModuleBase.isCreateManDirty();
            }
            case 3: {
                return pSSysTestModuleBase.isDataDirty();
            }
            case 4: {
                return pSSysTestModuleBase.isMemoDirty();
            }
            case 5: {
                return pSSysTestModuleBase.isModuleTagDirty();
            }
            case 6: {
                return pSSysTestModuleBase.isModuleTag2Dirty();
            }
            case 7: {
                return pSSysTestModuleBase.isModuleTypeDirty();
            }
            case 8: {
                return pSSysTestModuleBase.isOrderValueDirty();
            }
            case 9: {
                return pSSysTestModuleBase.isPPSSysTestModuleIdDirty();
            }
            case 10: {
                return pSSysTestModuleBase.isPPSSysTestModuleNameDirty();
            }
            case 11: {
                return pSSysTestModuleBase.isPSSysAppIdDirty();
            }
            case 12: {
                return pSSysTestModuleBase.isPSSysServiceAPIIdDirty();
            }
            case 13: {
                return pSSysTestModuleBase.isPSSysTestDataIdDirty();
            }
            case 14: {
                return pSSysTestModuleBase.isPSSysTestDataNameDirty();
            }
            case 15: {
                return pSSysTestModuleBase.isPSSysTestModuleIdDirty();
            }
            case 16: {
                return pSSysTestModuleBase.isPSSysTestModuleNameDirty();
            }
            case 17: {
                return pSSysTestModuleBase.isPSSysTestPrjIdDirty();
            }
            case 18: {
                return pSSysTestModuleBase.isPSSysTestPrjNameDirty();
            }
            case 19: {
                return pSSysTestModuleBase.isUpdateDateDirty();
            }
            case 20: {
                return pSSysTestModuleBase.isUpdateManDirty();
            }
            case 21: {
                return pSSysTestModuleBase.isUserCatDirty();
            }
            case 22: {
                return pSSysTestModuleBase.isUserParamsDirty();
            }
            case 23: {
                return pSSysTestModuleBase.isUserTagDirty();
            }
            case 24: {
                return pSSysTestModuleBase.isUserTag2Dirty();
            }
            case 25: {
                return pSSysTestModuleBase.isUserTag3Dirty();
            }
            case 26: {
                return pSSysTestModuleBase.isUserTag4Dirty();
            }
            case 27: {
                return pSSysTestModuleBase.isUtilParamsDirty();
            }
            case 28: {
                return pSSysTestModuleBase.isUtilTagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysTestModuleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysTestModuleBase pSSysTestModuleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysTestModuleBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getData()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getModuleTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"moduletag", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getModuleTag()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getModuleTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"moduletag2", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getModuleTag2()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getModuleType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"moduletype", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getModuleType()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getPPSSysTestModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssystestmoduleid", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getPPSSysTestModuleId()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getPPSSysTestModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssystestmodulename", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getPPSSysTestModuleName()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getPSSysTestDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestdataid", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getPSSysTestDataId()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getPSSysTestDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestdataname", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getPSSysTestDataName()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getPSSysTestModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestmoduleid", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getPSSysTestModuleId()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getPSSysTestModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestmodulename", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getPSSysTestModuleName()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getPSSysTestPrjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestprjid", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getPSSysTestPrjId()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getPSSysTestPrjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestprjname", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getPSSysTestPrjName()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getUserParams()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getUtilParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparams", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getUtilParams()), (boolean)false);
        }
        if (bl || pSSysTestModuleBase.getUtilTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utiltag", (Object)PSSysTestModuleBase.getJSONValue((Object)pSSysTestModuleBase.getUtilTag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysTestModuleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysTestModuleBase pSSysTestModuleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysTestModuleBase.getCodeName() != null) {
            object = pSSysTestModuleBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getCreateDate() != null) {
            object = pSSysTestModuleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTestModuleBase.getCreateMan() != null) {
            object = pSSysTestModuleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getData() != null) {
            object = pSSysTestModuleBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getMemo() != null) {
            object = pSSysTestModuleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getModuleTag() != null) {
            object = pSSysTestModuleBase.getModuleTag();
            xmlNode.setAttribute(FIELD_MODULETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getModuleTag2() != null) {
            object = pSSysTestModuleBase.getModuleTag2();
            xmlNode.setAttribute(FIELD_MODULETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getModuleType() != null) {
            object = pSSysTestModuleBase.getModuleType();
            xmlNode.setAttribute(FIELD_MODULETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getOrderValue() != null) {
            object = pSSysTestModuleBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTestModuleBase.getPPSSysTestModuleId() != null) {
            object = pSSysTestModuleBase.getPPSSysTestModuleId();
            xmlNode.setAttribute(FIELD_PPSSYSTESTMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getPPSSysTestModuleName() != null) {
            object = pSSysTestModuleBase.getPPSSysTestModuleName();
            xmlNode.setAttribute(FIELD_PPSSYSTESTMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getPSSysAppId() != null) {
            object = pSSysTestModuleBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getPSSysServiceAPIId() != null) {
            object = pSSysTestModuleBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getPSSysTestDataId() != null) {
            object = pSSysTestModuleBase.getPSSysTestDataId();
            xmlNode.setAttribute(FIELD_PSSYSTESTDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getPSSysTestDataName() != null) {
            object = pSSysTestModuleBase.getPSSysTestDataName();
            xmlNode.setAttribute(FIELD_PSSYSTESTDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getPSSysTestModuleId() != null) {
            object = pSSysTestModuleBase.getPSSysTestModuleId();
            xmlNode.setAttribute(FIELD_PSSYSTESTMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getPSSysTestModuleName() != null) {
            object = pSSysTestModuleBase.getPSSysTestModuleName();
            xmlNode.setAttribute(FIELD_PSSYSTESTMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getPSSysTestPrjId() != null) {
            object = pSSysTestModuleBase.getPSSysTestPrjId();
            xmlNode.setAttribute(FIELD_PSSYSTESTPRJID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getPSSysTestPrjName() != null) {
            object = pSSysTestModuleBase.getPSSysTestPrjName();
            xmlNode.setAttribute(FIELD_PSSYSTESTPRJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getUpdateDate() != null) {
            object = pSSysTestModuleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTestModuleBase.getUpdateMan() != null) {
            object = pSSysTestModuleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getUserCat() != null) {
            object = pSSysTestModuleBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getUserParams() != null) {
            object = pSSysTestModuleBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getUserTag() != null) {
            object = pSSysTestModuleBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getUserTag2() != null) {
            object = pSSysTestModuleBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getUserTag3() != null) {
            object = pSSysTestModuleBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getUserTag4() != null) {
            object = pSSysTestModuleBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getUtilParams() != null) {
            object = pSSysTestModuleBase.getUtilParams();
            xmlNode.setAttribute(FIELD_UTILPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysTestModuleBase.getUtilTag() != null) {
            object = pSSysTestModuleBase.getUtilTag();
            xmlNode.setAttribute(FIELD_UTILTAG, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysTestModuleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysTestModuleBase pSSysTestModuleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysTestModuleBase.isCodeNameDirty() && (bl || pSSysTestModuleBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysTestModuleBase.getCodeName());
        }
        if (pSSysTestModuleBase.isCreateDateDirty() && (bl || pSSysTestModuleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysTestModuleBase.getCreateDate());
        }
        if (pSSysTestModuleBase.isCreateManDirty() && (bl || pSSysTestModuleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysTestModuleBase.getCreateMan());
        }
        if (pSSysTestModuleBase.isDataDirty() && (bl || pSSysTestModuleBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSSysTestModuleBase.getData());
        }
        if (pSSysTestModuleBase.isMemoDirty() && (bl || pSSysTestModuleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysTestModuleBase.getMemo());
        }
        if (pSSysTestModuleBase.isModuleTagDirty() && (bl || pSSysTestModuleBase.getModuleTag() != null)) {
            iDataObject.set(FIELD_MODULETAG, (Object)pSSysTestModuleBase.getModuleTag());
        }
        if (pSSysTestModuleBase.isModuleTag2Dirty() && (bl || pSSysTestModuleBase.getModuleTag2() != null)) {
            iDataObject.set(FIELD_MODULETAG2, (Object)pSSysTestModuleBase.getModuleTag2());
        }
        if (pSSysTestModuleBase.isModuleTypeDirty() && (bl || pSSysTestModuleBase.getModuleType() != null)) {
            iDataObject.set(FIELD_MODULETYPE, (Object)pSSysTestModuleBase.getModuleType());
        }
        if (pSSysTestModuleBase.isOrderValueDirty() && (bl || pSSysTestModuleBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysTestModuleBase.getOrderValue());
        }
        if (pSSysTestModuleBase.isPPSSysTestModuleIdDirty() && (bl || pSSysTestModuleBase.getPPSSysTestModuleId() != null)) {
            iDataObject.set(FIELD_PPSSYSTESTMODULEID, (Object)pSSysTestModuleBase.getPPSSysTestModuleId());
        }
        if (pSSysTestModuleBase.isPPSSysTestModuleNameDirty() && (bl || pSSysTestModuleBase.getPPSSysTestModuleName() != null)) {
            iDataObject.set(FIELD_PPSSYSTESTMODULENAME, (Object)pSSysTestModuleBase.getPPSSysTestModuleName());
        }
        if (pSSysTestModuleBase.isPSSysAppIdDirty() && (bl || pSSysTestModuleBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysTestModuleBase.getPSSysAppId());
        }
        if (pSSysTestModuleBase.isPSSysServiceAPIIdDirty() && (bl || pSSysTestModuleBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSSysTestModuleBase.getPSSysServiceAPIId());
        }
        if (pSSysTestModuleBase.isPSSysTestDataIdDirty() && (bl || pSSysTestModuleBase.getPSSysTestDataId() != null)) {
            iDataObject.set(FIELD_PSSYSTESTDATAID, (Object)pSSysTestModuleBase.getPSSysTestDataId());
        }
        if (pSSysTestModuleBase.isPSSysTestDataNameDirty() && (bl || pSSysTestModuleBase.getPSSysTestDataName() != null)) {
            iDataObject.set(FIELD_PSSYSTESTDATANAME, (Object)pSSysTestModuleBase.getPSSysTestDataName());
        }
        if (pSSysTestModuleBase.isPSSysTestModuleIdDirty() && (bl || pSSysTestModuleBase.getPSSysTestModuleId() != null)) {
            iDataObject.set(FIELD_PSSYSTESTMODULEID, (Object)pSSysTestModuleBase.getPSSysTestModuleId());
        }
        if (pSSysTestModuleBase.isPSSysTestModuleNameDirty() && (bl || pSSysTestModuleBase.getPSSysTestModuleName() != null)) {
            iDataObject.set(FIELD_PSSYSTESTMODULENAME, (Object)pSSysTestModuleBase.getPSSysTestModuleName());
        }
        if (pSSysTestModuleBase.isPSSysTestPrjIdDirty() && (bl || pSSysTestModuleBase.getPSSysTestPrjId() != null)) {
            iDataObject.set(FIELD_PSSYSTESTPRJID, (Object)pSSysTestModuleBase.getPSSysTestPrjId());
        }
        if (pSSysTestModuleBase.isPSSysTestPrjNameDirty() && (bl || pSSysTestModuleBase.getPSSysTestPrjName() != null)) {
            iDataObject.set(FIELD_PSSYSTESTPRJNAME, (Object)pSSysTestModuleBase.getPSSysTestPrjName());
        }
        if (pSSysTestModuleBase.isUpdateDateDirty() && (bl || pSSysTestModuleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysTestModuleBase.getUpdateDate());
        }
        if (pSSysTestModuleBase.isUpdateManDirty() && (bl || pSSysTestModuleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysTestModuleBase.getUpdateMan());
        }
        if (pSSysTestModuleBase.isUserCatDirty() && (bl || pSSysTestModuleBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysTestModuleBase.getUserCat());
        }
        if (pSSysTestModuleBase.isUserParamsDirty() && (bl || pSSysTestModuleBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSSysTestModuleBase.getUserParams());
        }
        if (pSSysTestModuleBase.isUserTagDirty() && (bl || pSSysTestModuleBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysTestModuleBase.getUserTag());
        }
        if (pSSysTestModuleBase.isUserTag2Dirty() && (bl || pSSysTestModuleBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysTestModuleBase.getUserTag2());
        }
        if (pSSysTestModuleBase.isUserTag3Dirty() && (bl || pSSysTestModuleBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysTestModuleBase.getUserTag3());
        }
        if (pSSysTestModuleBase.isUserTag4Dirty() && (bl || pSSysTestModuleBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysTestModuleBase.getUserTag4());
        }
        if (pSSysTestModuleBase.isUtilParamsDirty() && (bl || pSSysTestModuleBase.getUtilParams() != null)) {
            iDataObject.set(FIELD_UTILPARAMS, (Object)pSSysTestModuleBase.getUtilParams());
        }
        if (pSSysTestModuleBase.isUtilTagDirty() && (bl || pSSysTestModuleBase.getUtilTag() != null)) {
            iDataObject.set(FIELD_UTILTAG, (Object)pSSysTestModuleBase.getUtilTag());
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
        return PSSysTestModuleBase.remove(this, n);
    }

    private static boolean remove(PSSysTestModuleBase pSSysTestModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysTestModuleBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysTestModuleBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysTestModuleBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysTestModuleBase.resetData();
                return true;
            }
            case 4: {
                pSSysTestModuleBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysTestModuleBase.resetModuleTag();
                return true;
            }
            case 6: {
                pSSysTestModuleBase.resetModuleTag2();
                return true;
            }
            case 7: {
                pSSysTestModuleBase.resetModuleType();
                return true;
            }
            case 8: {
                pSSysTestModuleBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSSysTestModuleBase.resetPPSSysTestModuleId();
                return true;
            }
            case 10: {
                pSSysTestModuleBase.resetPPSSysTestModuleName();
                return true;
            }
            case 11: {
                pSSysTestModuleBase.resetPSSysAppId();
                return true;
            }
            case 12: {
                pSSysTestModuleBase.resetPSSysServiceAPIId();
                return true;
            }
            case 13: {
                pSSysTestModuleBase.resetPSSysTestDataId();
                return true;
            }
            case 14: {
                pSSysTestModuleBase.resetPSSysTestDataName();
                return true;
            }
            case 15: {
                pSSysTestModuleBase.resetPSSysTestModuleId();
                return true;
            }
            case 16: {
                pSSysTestModuleBase.resetPSSysTestModuleName();
                return true;
            }
            case 17: {
                pSSysTestModuleBase.resetPSSysTestPrjId();
                return true;
            }
            case 18: {
                pSSysTestModuleBase.resetPSSysTestPrjName();
                return true;
            }
            case 19: {
                pSSysTestModuleBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSSysTestModuleBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSSysTestModuleBase.resetUserCat();
                return true;
            }
            case 22: {
                pSSysTestModuleBase.resetUserParams();
                return true;
            }
            case 23: {
                pSSysTestModuleBase.resetUserTag();
                return true;
            }
            case 24: {
                pSSysTestModuleBase.resetUserTag2();
                return true;
            }
            case 25: {
                pSSysTestModuleBase.resetUserTag3();
                return true;
            }
            case 26: {
                pSSysTestModuleBase.resetUserTag4();
                return true;
            }
            case 27: {
                pSSysTestModuleBase.resetUtilParams();
                return true;
            }
            case 28: {
                pSSysTestModuleBase.resetUtilTag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTestModule getPPSSysTestModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysTestModule();
        }
        if (this.getPPSSysTestModuleId() == null) {
            return null;
        }
        Integer n = this.objPPSSysTestModuleLock;
        synchronized (n) {
            if (this.ppssystestmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysTestModuleId(), (Object)this.ppssystestmodule.getPSSysTestModuleId()) != 0L) {
                this.ppssystestmodule = null;
            }
            if (this.ppssystestmodule == null) {
                PSSysTestModule pSSysTestModule = new PSSysTestModule();
                pSSysTestModule.setPSSysTestModuleId(this.getPPSSysTestModuleId());
                PSSysTestModuleService pSSysTestModuleService = (PSSysTestModuleService)ServiceGlobal.getService(PSSysTestModuleService.class, (SessionFactory)this.getSessionFactory());
                pSSysTestModuleService.autoGet((IEntity)pSSysTestModule);
                this.ppssystestmodule = pSSysTestModule;
            }
            return this.ppssystestmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTestPrj getPSSysTestPrj() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestPrj();
        }
        if (this.getPSSysTestPrjId() == null) {
            return null;
        }
        Integer n = this.objPSSysTestPrjLock;
        synchronized (n) {
            if (this.pssystestprj != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTestPrjId(), (Object)this.pssystestprj.getPSSysTestPrjId()) != 0L) {
                this.pssystestprj = null;
            }
            if (this.pssystestprj == null) {
                PSSysTestPrj pSSysTestPrj = new PSSysTestPrj();
                pSSysTestPrj.setPSSysTestPrjId(this.getPSSysTestPrjId());
                PSSysTestPrjService pSSysTestPrjService = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
                pSSysTestPrjService.autoGet((IEntity)pSSysTestPrj);
                this.pssystestprj = pSSysTestPrj;
            }
            return this.pssystestprj;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTestCase> getPSSysTestCases() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestCases();
        }
        if (this.getPSSysTestModuleId() == null) {
            return null;
        }
        PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTestCasesLock;
        synchronized (n) {
            if (this.pssystestcases == null) {
                this.pssystestcases = pSSysTestCaseService.selectByPSSysTestModule(this);
            }
            return this.pssystestcases;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysTestModule> getPSSysTestModules() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTestModules();
        }
        if (this.getPSSysTestModuleId() == null) {
            return null;
        }
        PSSysTestModuleService pSSysTestModuleService = (PSSysTestModuleService)ServiceGlobal.getService(PSSysTestModuleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysTestModulesLock;
        synchronized (n) {
            if (this.pssystestmodules == null) {
                this.pssystestmodules = pSSysTestModuleService.selectByPPSSysTestModule(this);
            }
            return this.pssystestmodules;
        }
    }

    private PSSysTestModuleBase getProxyEntity() {
        return this.proxyPSSysTestModuleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysTestModuleBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysTestModuleBase) {
            this.proxyPSSysTestModuleBase = (PSSysTestModuleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestModuleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DATA, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MODULETAG, 5);
        fieldIndexMap.put(FIELD_MODULETAG2, 6);
        fieldIndexMap.put(FIELD_MODULETYPE, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PPSSYSTESTMODULEID, 9);
        fieldIndexMap.put(FIELD_PPSSYSTESTMODULENAME, 10);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 11);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 12);
        fieldIndexMap.put(FIELD_PSSYSTESTDATAID, 13);
        fieldIndexMap.put(FIELD_PSSYSTESTDATANAME, 14);
        fieldIndexMap.put(FIELD_PSSYSTESTMODULEID, 15);
        fieldIndexMap.put(FIELD_PSSYSTESTMODULENAME, 16);
        fieldIndexMap.put(FIELD_PSSYSTESTPRJID, 17);
        fieldIndexMap.put(FIELD_PSSYSTESTPRJNAME, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERPARAMS, 22);
        fieldIndexMap.put(FIELD_USERTAG, 23);
        fieldIndexMap.put(FIELD_USERTAG2, 24);
        fieldIndexMap.put(FIELD_USERTAG3, 25);
        fieldIndexMap.put(FIELD_USERTAG4, 26);
        fieldIndexMap.put(FIELD_UTILPARAMS, 27);
        fieldIndexMap.put(FIELD_UTILTAG, 28);
    }
}

