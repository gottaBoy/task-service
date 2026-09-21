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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBProc;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBProcService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBProcParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDBProcParamBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_LENGTH = "LENGTH";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMDIR = "PARAMDIR";
    public static final String FIELD_PRECISION2 = "PRECISION2";
    public static final String FIELD_PSSYSDBPROCID = "PSSYSDBPROCID";
    public static final String FIELD_PSSYSDBPROCNAME = "PSSYSDBPROCNAME";
    public static final String FIELD_PSSYSDBPROCPARAMID = "PSSYSDBPROCPARAMID";
    public static final String FIELD_PSSYSDBPROCPARAMNAME = "PSSYSDBPROCPARAMNAME";
    public static final String FIELD_STDDATATYPE = "STDDATATYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEFAULTVALUE = 2;
    private static final int INDEX_LENGTH = 3;
    private static final int INDEX_LOGICNAME = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PARAMDIR = 7;
    private static final int INDEX_PRECISION2 = 8;
    private static final int INDEX_PSSYSDBPROCID = 9;
    private static final int INDEX_PSSYSDBPROCNAME = 10;
    private static final int INDEX_PSSYSDBPROCPARAMID = 11;
    private static final int INDEX_PSSYSDBPROCPARAMNAME = 12;
    private static final int INDEX_STDDATATYPE = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_USERCAT = 16;
    private static final int INDEX_USERTAG = 17;
    private static final int INDEX_USERTAG2 = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDBProcParamBase proxyPSSysDBProcParamBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean lengthDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramdirDirtyFlag = false;
    private boolean precision2DirtyFlag = false;
    private boolean pssysdbprocidDirtyFlag = false;
    private boolean pssysdbprocnameDirtyFlag = false;
    private boolean pssysdbprocparamidDirtyFlag = false;
    private boolean pssysdbprocparamnameDirtyFlag = false;
    private boolean stddatatypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultvalue")
    private String defaultvalue;
    @Column(name="length")
    private Integer length;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="paramdir")
    private Integer paramdir;
    @Column(name="precision2")
    private Integer precision2;
    @Column(name="pssysdbprocid")
    private String pssysdbprocid;
    @Column(name="pssysdbprocname")
    private String pssysdbprocname;
    @Column(name="pssysdbprocparamid")
    private String pssysdbprocparamid;
    @Column(name="pssysdbprocparamname")
    private String pssysdbprocparamname;
    @Column(name="stddatatype")
    private Integer stddatatype;
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
    private Integer objPSSysDBProcLock = new Integer(1);
    private PSSysDBProc pssysdbproc = null;

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

    public void setDefaultValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultvalue = string;
        this.defaultvalueDirtyFlag = true;
    }

    public String getDefaultValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultValue();
        }
        return this.defaultvalue;
    }

    public boolean isDefaultValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultValueDirty();
        }
        return this.defaultvalueDirtyFlag;
    }

    public void resetDefaultValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultValue();
            return;
        }
        this.defaultvalueDirtyFlag = false;
        this.defaultvalue = null;
    }

    public void setLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLength(n);
            return;
        }
        this.length = n;
        this.lengthDirtyFlag = true;
    }

    public Integer getLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLength();
        }
        return this.length;
    }

    public boolean isLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLengthDirty();
        }
        return this.lengthDirtyFlag;
    }

    public void resetLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLength();
            return;
        }
        this.lengthDirtyFlag = false;
        this.length = null;
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

    public void setParamDIR(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamDIR(n);
            return;
        }
        this.paramdir = n;
        this.paramdirDirtyFlag = true;
    }

    public Integer getParamDIR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamDIR();
        }
        return this.paramdir;
    }

    public boolean isParamDIRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDIRDirty();
        }
        return this.paramdirDirtyFlag;
    }

    public void resetParamDIR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamDIR();
            return;
        }
        this.paramdirDirtyFlag = false;
        this.paramdir = null;
    }

    public void setPrecision2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrecision2(n);
            return;
        }
        this.precision2 = n;
        this.precision2DirtyFlag = true;
    }

    public Integer getPrecision2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrecision2();
        }
        return this.precision2;
    }

    public boolean isPrecision2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrecision2Dirty();
        }
        return this.precision2DirtyFlag;
    }

    public void resetPrecision2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrecision2();
            return;
        }
        this.precision2DirtyFlag = false;
        this.precision2 = null;
    }

    public void setPSSysDBProcId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBProcId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbprocid = string;
        this.pssysdbprocidDirtyFlag = true;
    }

    public String getPSSysDBProcId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBProcId();
        }
        return this.pssysdbprocid;
    }

    public boolean isPSSysDBProcIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBProcIdDirty();
        }
        return this.pssysdbprocidDirtyFlag;
    }

    public void resetPSSysDBProcId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBProcId();
            return;
        }
        this.pssysdbprocidDirtyFlag = false;
        this.pssysdbprocid = null;
    }

    public void setPSSysDBProcName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBProcName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbprocname = string;
        this.pssysdbprocnameDirtyFlag = true;
    }

    public String getPSSysDBProcName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBProcName();
        }
        return this.pssysdbprocname;
    }

    public boolean isPSSysDBProcNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBProcNameDirty();
        }
        return this.pssysdbprocnameDirtyFlag;
    }

    public void resetPSSysDBProcName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBProcName();
            return;
        }
        this.pssysdbprocnameDirtyFlag = false;
        this.pssysdbprocname = null;
    }

    public void setPSSysDBProcParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBProcParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbprocparamid = string;
        this.pssysdbprocparamidDirtyFlag = true;
    }

    public String getPSSysDBProcParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBProcParamId();
        }
        return this.pssysdbprocparamid;
    }

    public boolean isPSSysDBProcParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBProcParamIdDirty();
        }
        return this.pssysdbprocparamidDirtyFlag;
    }

    public void resetPSSysDBProcParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBProcParamId();
            return;
        }
        this.pssysdbprocparamidDirtyFlag = false;
        this.pssysdbprocparamid = null;
    }

    public void setPSSysDBProcParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBProcParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbprocparamname = string;
        this.pssysdbprocparamnameDirtyFlag = true;
    }

    public String getPSSysDBProcParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBProcParamName();
        }
        return this.pssysdbprocparamname;
    }

    public boolean isPSSysDBProcParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBProcParamNameDirty();
        }
        return this.pssysdbprocparamnameDirtyFlag;
    }

    public void resetPSSysDBProcParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBProcParamName();
            return;
        }
        this.pssysdbprocparamnameDirtyFlag = false;
        this.pssysdbprocparamname = null;
    }

    public void setStdDataType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStdDataType(n);
            return;
        }
        this.stddatatype = n;
        this.stddatatypeDirtyFlag = true;
    }

    public Integer getStdDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStdDataType();
        }
        return this.stddatatype;
    }

    public boolean isStdDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStdDataTypeDirty();
        }
        return this.stddatatypeDirtyFlag;
    }

    public void resetStdDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStdDataType();
            return;
        }
        this.stddatatypeDirtyFlag = false;
        this.stddatatype = null;
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

    protected void onReset() {
        PSSysDBProcParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDBProcParamBase pSSysDBProcParamBase) {
        pSSysDBProcParamBase.resetCreateDate();
        pSSysDBProcParamBase.resetCreateMan();
        pSSysDBProcParamBase.resetDefaultValue();
        pSSysDBProcParamBase.resetLength();
        pSSysDBProcParamBase.resetLogicName();
        pSSysDBProcParamBase.resetMemo();
        pSSysDBProcParamBase.resetOrderValue();
        pSSysDBProcParamBase.resetParamDIR();
        pSSysDBProcParamBase.resetPrecision2();
        pSSysDBProcParamBase.resetPSSysDBProcId();
        pSSysDBProcParamBase.resetPSSysDBProcName();
        pSSysDBProcParamBase.resetPSSysDBProcParamId();
        pSSysDBProcParamBase.resetPSSysDBProcParamName();
        pSSysDBProcParamBase.resetStdDataType();
        pSSysDBProcParamBase.resetUpdateDate();
        pSSysDBProcParamBase.resetUpdateMan();
        pSSysDBProcParamBase.resetUserCat();
        pSSysDBProcParamBase.resetUserTag();
        pSSysDBProcParamBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultValueDirty()) {
            hashMap.put(FIELD_DEFAULTVALUE, this.getDefaultValue());
        }
        if (!bl || this.isLengthDirty()) {
            hashMap.put(FIELD_LENGTH, this.getLength());
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
        if (!bl || this.isParamDIRDirty()) {
            hashMap.put(FIELD_PARAMDIR, this.getParamDIR());
        }
        if (!bl || this.isPrecision2Dirty()) {
            hashMap.put(FIELD_PRECISION2, this.getPrecision2());
        }
        if (!bl || this.isPSSysDBProcIdDirty()) {
            hashMap.put(FIELD_PSSYSDBPROCID, this.getPSSysDBProcId());
        }
        if (!bl || this.isPSSysDBProcNameDirty()) {
            hashMap.put(FIELD_PSSYSDBPROCNAME, this.getPSSysDBProcName());
        }
        if (!bl || this.isPSSysDBProcParamIdDirty()) {
            hashMap.put(FIELD_PSSYSDBPROCPARAMID, this.getPSSysDBProcParamId());
        }
        if (!bl || this.isPSSysDBProcParamNameDirty()) {
            hashMap.put(FIELD_PSSYSDBPROCPARAMNAME, this.getPSSysDBProcParamName());
        }
        if (!bl || this.isStdDataTypeDirty()) {
            hashMap.put(FIELD_STDDATATYPE, this.getStdDataType());
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
        return PSSysDBProcParamBase.get(this, n);
    }

    private static Object get(PSSysDBProcParamBase pSSysDBProcParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBProcParamBase.getCreateDate();
            }
            case 1: {
                return pSSysDBProcParamBase.getCreateMan();
            }
            case 2: {
                return pSSysDBProcParamBase.getDefaultValue();
            }
            case 3: {
                return pSSysDBProcParamBase.getLength();
            }
            case 4: {
                return pSSysDBProcParamBase.getLogicName();
            }
            case 5: {
                return pSSysDBProcParamBase.getMemo();
            }
            case 6: {
                return pSSysDBProcParamBase.getOrderValue();
            }
            case 7: {
                return pSSysDBProcParamBase.getParamDIR();
            }
            case 8: {
                return pSSysDBProcParamBase.getPrecision2();
            }
            case 9: {
                return pSSysDBProcParamBase.getPSSysDBProcId();
            }
            case 10: {
                return pSSysDBProcParamBase.getPSSysDBProcName();
            }
            case 11: {
                return pSSysDBProcParamBase.getPSSysDBProcParamId();
            }
            case 12: {
                return pSSysDBProcParamBase.getPSSysDBProcParamName();
            }
            case 13: {
                return pSSysDBProcParamBase.getStdDataType();
            }
            case 14: {
                return pSSysDBProcParamBase.getUpdateDate();
            }
            case 15: {
                return pSSysDBProcParamBase.getUpdateMan();
            }
            case 16: {
                return pSSysDBProcParamBase.getUserCat();
            }
            case 17: {
                return pSSysDBProcParamBase.getUserTag();
            }
            case 18: {
                return pSSysDBProcParamBase.getUserTag2();
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
        PSSysDBProcParamBase.set(this, n, object);
    }

    private static void set(PSSysDBProcParamBase pSSysDBProcParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBProcParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDBProcParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDBProcParamBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDBProcParamBase.setLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysDBProcParamBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDBProcParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDBProcParamBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysDBProcParamBase.setParamDIR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysDBProcParamBase.setPrecision2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysDBProcParamBase.setPSSysDBProcId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDBProcParamBase.setPSSysDBProcName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDBProcParamBase.setPSSysDBProcParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDBProcParamBase.setPSSysDBProcParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDBProcParamBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysDBProcParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSSysDBProcParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDBProcParamBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDBProcParamBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysDBProcParamBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSSysDBProcParamBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDBProcParamBase pSSysDBProcParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBProcParamBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysDBProcParamBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysDBProcParamBase.getDefaultValue() == null;
            }
            case 3: {
                return pSSysDBProcParamBase.getLength() == null;
            }
            case 4: {
                return pSSysDBProcParamBase.getLogicName() == null;
            }
            case 5: {
                return pSSysDBProcParamBase.getMemo() == null;
            }
            case 6: {
                return pSSysDBProcParamBase.getOrderValue() == null;
            }
            case 7: {
                return pSSysDBProcParamBase.getParamDIR() == null;
            }
            case 8: {
                return pSSysDBProcParamBase.getPrecision2() == null;
            }
            case 9: {
                return pSSysDBProcParamBase.getPSSysDBProcId() == null;
            }
            case 10: {
                return pSSysDBProcParamBase.getPSSysDBProcName() == null;
            }
            case 11: {
                return pSSysDBProcParamBase.getPSSysDBProcParamId() == null;
            }
            case 12: {
                return pSSysDBProcParamBase.getPSSysDBProcParamName() == null;
            }
            case 13: {
                return pSSysDBProcParamBase.getStdDataType() == null;
            }
            case 14: {
                return pSSysDBProcParamBase.getUpdateDate() == null;
            }
            case 15: {
                return pSSysDBProcParamBase.getUpdateMan() == null;
            }
            case 16: {
                return pSSysDBProcParamBase.getUserCat() == null;
            }
            case 17: {
                return pSSysDBProcParamBase.getUserTag() == null;
            }
            case 18: {
                return pSSysDBProcParamBase.getUserTag2() == null;
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
        return PSSysDBProcParamBase.contains(this, n);
    }

    private static boolean contains(PSSysDBProcParamBase pSSysDBProcParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBProcParamBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysDBProcParamBase.isCreateManDirty();
            }
            case 2: {
                return pSSysDBProcParamBase.isDefaultValueDirty();
            }
            case 3: {
                return pSSysDBProcParamBase.isLengthDirty();
            }
            case 4: {
                return pSSysDBProcParamBase.isLogicNameDirty();
            }
            case 5: {
                return pSSysDBProcParamBase.isMemoDirty();
            }
            case 6: {
                return pSSysDBProcParamBase.isOrderValueDirty();
            }
            case 7: {
                return pSSysDBProcParamBase.isParamDIRDirty();
            }
            case 8: {
                return pSSysDBProcParamBase.isPrecision2Dirty();
            }
            case 9: {
                return pSSysDBProcParamBase.isPSSysDBProcIdDirty();
            }
            case 10: {
                return pSSysDBProcParamBase.isPSSysDBProcNameDirty();
            }
            case 11: {
                return pSSysDBProcParamBase.isPSSysDBProcParamIdDirty();
            }
            case 12: {
                return pSSysDBProcParamBase.isPSSysDBProcParamNameDirty();
            }
            case 13: {
                return pSSysDBProcParamBase.isStdDataTypeDirty();
            }
            case 14: {
                return pSSysDBProcParamBase.isUpdateDateDirty();
            }
            case 15: {
                return pSSysDBProcParamBase.isUpdateManDirty();
            }
            case 16: {
                return pSSysDBProcParamBase.isUserCatDirty();
            }
            case 17: {
                return pSSysDBProcParamBase.isUserTagDirty();
            }
            case 18: {
                return pSSysDBProcParamBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDBProcParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDBProcParamBase pSSysDBProcParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDBProcParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"length", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getLength()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getParamDIR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramdir", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getParamDIR()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getPrecision2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"precision2", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getPrecision2()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getPSSysDBProcId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbprocid", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getPSSysDBProcId()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getPSSysDBProcName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbprocname", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getPSSysDBProcName()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getPSSysDBProcParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbprocparamid", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getPSSysDBProcParamId()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getPSSysDBProcParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbprocparamname", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getPSSysDBProcParamName()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysDBProcParamBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysDBProcParamBase.getJSONValue((Object)pSSysDBProcParamBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDBProcParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDBProcParamBase pSSysDBProcParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDBProcParamBase.getCreateDate() != null) {
            object = pSSysDBProcParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBProcParamBase.getCreateMan() != null) {
            object = pSSysDBProcParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcParamBase.getDefaultValue() != null) {
            object = pSSysDBProcParamBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcParamBase.getLength() != null) {
            object = pSSysDBProcParamBase.getLength();
            xmlNode.setAttribute(FIELD_LENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBProcParamBase.getLogicName() != null) {
            object = pSSysDBProcParamBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcParamBase.getMemo() != null) {
            object = pSSysDBProcParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcParamBase.getOrderValue() != null) {
            object = pSSysDBProcParamBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBProcParamBase.getParamDIR() != null) {
            object = pSSysDBProcParamBase.getParamDIR();
            xmlNode.setAttribute(FIELD_PARAMDIR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBProcParamBase.getPrecision2() != null) {
            object = pSSysDBProcParamBase.getPrecision2();
            xmlNode.setAttribute(FIELD_PRECISION2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBProcParamBase.getPSSysDBProcId() != null) {
            object = pSSysDBProcParamBase.getPSSysDBProcId();
            xmlNode.setAttribute(FIELD_PSSYSDBPROCID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcParamBase.getPSSysDBProcName() != null) {
            object = pSSysDBProcParamBase.getPSSysDBProcName();
            xmlNode.setAttribute(FIELD_PSSYSDBPROCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcParamBase.getPSSysDBProcParamId() != null) {
            object = pSSysDBProcParamBase.getPSSysDBProcParamId();
            xmlNode.setAttribute(FIELD_PSSYSDBPROCPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcParamBase.getPSSysDBProcParamName() != null) {
            object = pSSysDBProcParamBase.getPSSysDBProcParamName();
            xmlNode.setAttribute(FIELD_PSSYSDBPROCPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcParamBase.getStdDataType() != null) {
            object = pSSysDBProcParamBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBProcParamBase.getUpdateDate() != null) {
            object = pSSysDBProcParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBProcParamBase.getUpdateMan() != null) {
            object = pSSysDBProcParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcParamBase.getUserCat() != null) {
            object = pSSysDBProcParamBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcParamBase.getUserTag() != null) {
            object = pSSysDBProcParamBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBProcParamBase.getUserTag2() != null) {
            object = pSSysDBProcParamBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDBProcParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDBProcParamBase pSSysDBProcParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDBProcParamBase.isCreateDateDirty() && (bl || pSSysDBProcParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDBProcParamBase.getCreateDate());
        }
        if (pSSysDBProcParamBase.isCreateManDirty() && (bl || pSSysDBProcParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDBProcParamBase.getCreateMan());
        }
        if (pSSysDBProcParamBase.isDefaultValueDirty() && (bl || pSSysDBProcParamBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSSysDBProcParamBase.getDefaultValue());
        }
        if (pSSysDBProcParamBase.isLengthDirty() && (bl || pSSysDBProcParamBase.getLength() != null)) {
            iDataObject.set(FIELD_LENGTH, (Object)pSSysDBProcParamBase.getLength());
        }
        if (pSSysDBProcParamBase.isLogicNameDirty() && (bl || pSSysDBProcParamBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysDBProcParamBase.getLogicName());
        }
        if (pSSysDBProcParamBase.isMemoDirty() && (bl || pSSysDBProcParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDBProcParamBase.getMemo());
        }
        if (pSSysDBProcParamBase.isOrderValueDirty() && (bl || pSSysDBProcParamBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysDBProcParamBase.getOrderValue());
        }
        if (pSSysDBProcParamBase.isParamDIRDirty() && (bl || pSSysDBProcParamBase.getParamDIR() != null)) {
            iDataObject.set(FIELD_PARAMDIR, (Object)pSSysDBProcParamBase.getParamDIR());
        }
        if (pSSysDBProcParamBase.isPrecision2Dirty() && (bl || pSSysDBProcParamBase.getPrecision2() != null)) {
            iDataObject.set(FIELD_PRECISION2, (Object)pSSysDBProcParamBase.getPrecision2());
        }
        if (pSSysDBProcParamBase.isPSSysDBProcIdDirty() && (bl || pSSysDBProcParamBase.getPSSysDBProcId() != null)) {
            iDataObject.set(FIELD_PSSYSDBPROCID, (Object)pSSysDBProcParamBase.getPSSysDBProcId());
        }
        if (pSSysDBProcParamBase.isPSSysDBProcNameDirty() && (bl || pSSysDBProcParamBase.getPSSysDBProcName() != null)) {
            iDataObject.set(FIELD_PSSYSDBPROCNAME, (Object)pSSysDBProcParamBase.getPSSysDBProcName());
        }
        if (pSSysDBProcParamBase.isPSSysDBProcParamIdDirty() && (bl || pSSysDBProcParamBase.getPSSysDBProcParamId() != null)) {
            iDataObject.set(FIELD_PSSYSDBPROCPARAMID, (Object)pSSysDBProcParamBase.getPSSysDBProcParamId());
        }
        if (pSSysDBProcParamBase.isPSSysDBProcParamNameDirty() && (bl || pSSysDBProcParamBase.getPSSysDBProcParamName() != null)) {
            iDataObject.set(FIELD_PSSYSDBPROCPARAMNAME, (Object)pSSysDBProcParamBase.getPSSysDBProcParamName());
        }
        if (pSSysDBProcParamBase.isStdDataTypeDirty() && (bl || pSSysDBProcParamBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSSysDBProcParamBase.getStdDataType());
        }
        if (pSSysDBProcParamBase.isUpdateDateDirty() && (bl || pSSysDBProcParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDBProcParamBase.getUpdateDate());
        }
        if (pSSysDBProcParamBase.isUpdateManDirty() && (bl || pSSysDBProcParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDBProcParamBase.getUpdateMan());
        }
        if (pSSysDBProcParamBase.isUserCatDirty() && (bl || pSSysDBProcParamBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysDBProcParamBase.getUserCat());
        }
        if (pSSysDBProcParamBase.isUserTagDirty() && (bl || pSSysDBProcParamBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysDBProcParamBase.getUserTag());
        }
        if (pSSysDBProcParamBase.isUserTag2Dirty() && (bl || pSSysDBProcParamBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysDBProcParamBase.getUserTag2());
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
        return PSSysDBProcParamBase.remove(this, n);
    }

    private static boolean remove(PSSysDBProcParamBase pSSysDBProcParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBProcParamBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysDBProcParamBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysDBProcParamBase.resetDefaultValue();
                return true;
            }
            case 3: {
                pSSysDBProcParamBase.resetLength();
                return true;
            }
            case 4: {
                pSSysDBProcParamBase.resetLogicName();
                return true;
            }
            case 5: {
                pSSysDBProcParamBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysDBProcParamBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSSysDBProcParamBase.resetParamDIR();
                return true;
            }
            case 8: {
                pSSysDBProcParamBase.resetPrecision2();
                return true;
            }
            case 9: {
                pSSysDBProcParamBase.resetPSSysDBProcId();
                return true;
            }
            case 10: {
                pSSysDBProcParamBase.resetPSSysDBProcName();
                return true;
            }
            case 11: {
                pSSysDBProcParamBase.resetPSSysDBProcParamId();
                return true;
            }
            case 12: {
                pSSysDBProcParamBase.resetPSSysDBProcParamName();
                return true;
            }
            case 13: {
                pSSysDBProcParamBase.resetStdDataType();
                return true;
            }
            case 14: {
                pSSysDBProcParamBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSSysDBProcParamBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSSysDBProcParamBase.resetUserCat();
                return true;
            }
            case 17: {
                pSSysDBProcParamBase.resetUserTag();
                return true;
            }
            case 18: {
                pSSysDBProcParamBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBProc getPSSysDBProc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBProc();
        }
        if (this.getPSSysDBProcId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBProcLock;
        synchronized (n) {
            if (this.pssysdbproc != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBProcId(), (Object)this.pssysdbproc.getPSSysDBProcId()) != 0L) {
                this.pssysdbproc = null;
            }
            if (this.pssysdbproc == null) {
                PSSysDBProc pSSysDBProc = new PSSysDBProc();
                pSSysDBProc.setPSSysDBProcId(this.getPSSysDBProcId());
                PSSysDBProcService pSSysDBProcService = (PSSysDBProcService)ServiceGlobal.getService(PSSysDBProcService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBProcService.autoGet((IEntity)pSSysDBProc);
                this.pssysdbproc = pSSysDBProc;
            }
            return this.pssysdbproc;
        }
    }

    private PSSysDBProcParamBase getProxyEntity() {
        return this.proxyPSSysDBProcParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDBProcParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDBProcParamBase) {
            this.proxyPSSysDBProcParamBase = (PSSysDBProcParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBProcParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 2);
        fieldIndexMap.put(FIELD_LENGTH, 3);
        fieldIndexMap.put(FIELD_LOGICNAME, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PARAMDIR, 7);
        fieldIndexMap.put(FIELD_PRECISION2, 8);
        fieldIndexMap.put(FIELD_PSSYSDBPROCID, 9);
        fieldIndexMap.put(FIELD_PSSYSDBPROCNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSDBPROCPARAMID, 11);
        fieldIndexMap.put(FIELD_PSSYSDBPROCPARAMNAME, 12);
        fieldIndexMap.put(FIELD_STDDATATYPE, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_USERCAT, 16);
        fieldIndexMap.put(FIELD_USERTAG, 17);
        fieldIndexMap.put(FIELD_USERTAG2, 18);
    }
}

