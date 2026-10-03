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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESAVRBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDESAVRBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEFVRID = "PSDEFVRID";
    public static final String FIELD_PSDEFVRNAME = "PSDEFVRNAME";
    public static final String FIELD_PSDESAVRID = "PSDESAVRID";
    public static final String FIELD_PSDESAVRNAME = "PSDESAVRNAME";
    public static final String FIELD_PSDESERVICEAPIID = "PSDESERVICEAPIID";
    public static final String FIELD_PSDESERVICEAPINAME = "PSDESERVICEAPINAME";
    public static final String FIELD_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String FIELD_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VRTYPE = "VRTYPE";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PSDEFVRID = 5;
    private static final int INDEX_PSDEFVRNAME = 6;
    private static final int INDEX_PSDESAVRID = 7;
    private static final int INDEX_PSDESAVRNAME = 8;
    private static final int INDEX_PSDESERVICEAPIID = 9;
    private static final int INDEX_PSDESERVICEAPINAME = 10;
    private static final int INDEX_PSSYSVALUERULEID = 11;
    private static final int INDEX_PSSYSVALUERULENAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERCAT = 15;
    private static final int INDEX_USERTAG = 16;
    private static final int INDEX_USERTAG2 = 17;
    private static final int INDEX_USERTAG3 = 18;
    private static final int INDEX_USERTAG4 = 19;
    private static final int INDEX_VALIDFLAG = 20;
    private static final int INDEX_VRTYPE = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDESAVRBase proxyPSDESAVRBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdefvridDirtyFlag = false;
    private boolean psdefvrnameDirtyFlag = false;
    private boolean psdesavridDirtyFlag = false;
    private boolean psdesavrnameDirtyFlag = false;
    private boolean psdeserviceapiidDirtyFlag = false;
    private boolean psdeserviceapinameDirtyFlag = false;
    private boolean pssysvalueruleidDirtyFlag = false;
    private boolean pssysvaluerulenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean vrtypeDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdefvrid")
    private String psdefvrid;
    @Column(name="psdefvrname")
    private String psdefvrname;
    @Column(name="psdesavrid")
    private String psdesavrid;
    @Column(name="psdesavrname")
    private String psdesavrname;
    @Column(name="psdeserviceapiid")
    private String psdeserviceapiid;
    @Column(name="psdeserviceapiname")
    private String psdeserviceapiname;
    @Column(name="pssysvalueruleid")
    private String pssysvalueruleid;
    @Column(name="pssysvaluerulename")
    private String pssysvaluerulename;
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
    @Column(name="vrtype")
    private String vrtype;
    private Integer objPSDEFVRLock = new Integer(1);
    private PSDEFValueRule psdefvr = null;
    private Integer objPSDEServiceAPILock = new Integer(1);
    private PSDEServiceAPI psdeserviceapi = null;
    private Integer objPSSysValueRuleLock = new Integer(1);
    private PSSysValueRule pssysvaluerule = null;

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

    public void setPSDEFVRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrid = string;
        this.psdefvridDirtyFlag = true;
    }

    public String getPSDEFVRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRId();
        }
        return this.psdefvrid;
    }

    public boolean isPSDEFVRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRIdDirty();
        }
        return this.psdefvridDirtyFlag;
    }

    public void resetPSDEFVRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRId();
            return;
        }
        this.psdefvridDirtyFlag = false;
        this.psdefvrid = null;
    }

    public void setPSDEFVRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrname = string;
        this.psdefvrnameDirtyFlag = true;
    }

    public String getPSDEFVRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRName();
        }
        return this.psdefvrname;
    }

    public boolean isPSDEFVRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRNameDirty();
        }
        return this.psdefvrnameDirtyFlag;
    }

    public void resetPSDEFVRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRName();
            return;
        }
        this.psdefvrnameDirtyFlag = false;
        this.psdefvrname = null;
    }

    public void setPSDESAVRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESAVRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesavrid = string;
        this.psdesavridDirtyFlag = true;
    }

    public String getPSDESAVRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESAVRId();
        }
        return this.psdesavrid;
    }

    public boolean isPSDESAVRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESAVRIdDirty();
        }
        return this.psdesavridDirtyFlag;
    }

    public void resetPSDESAVRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESAVRId();
            return;
        }
        this.psdesavridDirtyFlag = false;
        this.psdesavrid = null;
    }

    public void setPSDESAVRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESAVRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdesavrname = string;
        this.psdesavrnameDirtyFlag = true;
    }

    public String getPSDESAVRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESAVRName();
        }
        return this.psdesavrname;
    }

    public boolean isPSDESAVRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESAVRNameDirty();
        }
        return this.psdesavrnameDirtyFlag;
    }

    public void resetPSDESAVRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESAVRName();
            return;
        }
        this.psdesavrnameDirtyFlag = false;
        this.psdesavrname = null;
    }

    public void setPSDEServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeserviceapiid = string;
        this.psdeserviceapiidDirtyFlag = true;
    }

    public String getPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEServiceAPIId();
        }
        return this.psdeserviceapiid;
    }

    public boolean isPSDEServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEServiceAPIIdDirty();
        }
        return this.psdeserviceapiidDirtyFlag;
    }

    public void resetPSDEServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEServiceAPIId();
            return;
        }
        this.psdeserviceapiidDirtyFlag = false;
        this.psdeserviceapiid = null;
    }

    public void setPSDEServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeserviceapiname = string;
        this.psdeserviceapinameDirtyFlag = true;
    }

    public String getPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEServiceAPIName();
        }
        return this.psdeserviceapiname;
    }

    public boolean isPSDEServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEServiceAPINameDirty();
        }
        return this.psdeserviceapinameDirtyFlag;
    }

    public void resetPSDEServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEServiceAPIName();
            return;
        }
        this.psdeserviceapinameDirtyFlag = false;
        this.psdeserviceapiname = null;
    }

    public void setPSSysValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysvalueruleid = string;
        this.pssysvalueruleidDirtyFlag = true;
    }

    public String getPSSysValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRuleId();
        }
        return this.pssysvalueruleid;
    }

    public boolean isPSSysValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysValueRuleIdDirty();
        }
        return this.pssysvalueruleidDirtyFlag;
    }

    public void resetPSSysValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysValueRuleId();
            return;
        }
        this.pssysvalueruleidDirtyFlag = false;
        this.pssysvalueruleid = null;
    }

    public void setPSSysValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysvaluerulename = string;
        this.pssysvaluerulenameDirtyFlag = true;
    }

    public String getPSSysValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRuleName();
        }
        return this.pssysvaluerulename;
    }

    public boolean isPSSysValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysValueRuleNameDirty();
        }
        return this.pssysvaluerulenameDirtyFlag;
    }

    public void resetPSSysValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysValueRuleName();
            return;
        }
        this.pssysvaluerulenameDirtyFlag = false;
        this.pssysvaluerulename = null;
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

    public void setVRType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVRType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vrtype = string;
        this.vrtypeDirtyFlag = true;
    }

    public String getVRType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVRType();
        }
        return this.vrtype;
    }

    public boolean isVRTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVRTypeDirty();
        }
        return this.vrtypeDirtyFlag;
    }

    public void resetVRType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVRType();
            return;
        }
        this.vrtypeDirtyFlag = false;
        this.vrtype = null;
    }

    protected void onReset() {
        PSDESAVRBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDESAVRBase pSDESAVRBase) {
        pSDESAVRBase.resetCodeName();
        pSDESAVRBase.resetCreateDate();
        pSDESAVRBase.resetCreateMan();
        pSDESAVRBase.resetMemo();
        pSDESAVRBase.resetOrderValue();
        pSDESAVRBase.resetPSDEFVRId();
        pSDESAVRBase.resetPSDEFVRName();
        pSDESAVRBase.resetPSDESAVRId();
        pSDESAVRBase.resetPSDESAVRName();
        pSDESAVRBase.resetPSDEServiceAPIId();
        pSDESAVRBase.resetPSDEServiceAPIName();
        pSDESAVRBase.resetPSSysValueRuleId();
        pSDESAVRBase.resetPSSysValueRuleName();
        pSDESAVRBase.resetUpdateDate();
        pSDESAVRBase.resetUpdateMan();
        pSDESAVRBase.resetUserCat();
        pSDESAVRBase.resetUserTag();
        pSDESAVRBase.resetUserTag2();
        pSDESAVRBase.resetUserTag3();
        pSDESAVRBase.resetUserTag4();
        pSDESAVRBase.resetValidFlag();
        pSDESAVRBase.resetVRType();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEFVRIdDirty()) {
            hashMap.put(FIELD_PSDEFVRID, this.getPSDEFVRId());
        }
        if (!bl || this.isPSDEFVRNameDirty()) {
            hashMap.put(FIELD_PSDEFVRNAME, this.getPSDEFVRName());
        }
        if (!bl || this.isPSDESAVRIdDirty()) {
            hashMap.put(FIELD_PSDESAVRID, this.getPSDESAVRId());
        }
        if (!bl || this.isPSDESAVRNameDirty()) {
            hashMap.put(FIELD_PSDESAVRNAME, this.getPSDESAVRName());
        }
        if (!bl || this.isPSDEServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSDESERVICEAPIID, this.getPSDEServiceAPIId());
        }
        if (!bl || this.isPSDEServiceAPINameDirty()) {
            hashMap.put(FIELD_PSDESERVICEAPINAME, this.getPSDEServiceAPIName());
        }
        if (!bl || this.isPSSysValueRuleIdDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULEID, this.getPSSysValueRuleId());
        }
        if (!bl || this.isPSSysValueRuleNameDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULENAME, this.getPSSysValueRuleName());
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
        if (!bl || this.isVRTypeDirty()) {
            hashMap.put(FIELD_VRTYPE, this.getVRType());
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
        return PSDESAVRBase.get(this, n);
    }

    private static Object get(PSDESAVRBase pSDESAVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESAVRBase.getCodeName();
            }
            case 1: {
                return pSDESAVRBase.getCreateDate();
            }
            case 2: {
                return pSDESAVRBase.getCreateMan();
            }
            case 3: {
                return pSDESAVRBase.getMemo();
            }
            case 4: {
                return pSDESAVRBase.getOrderValue();
            }
            case 5: {
                return pSDESAVRBase.getPSDEFVRId();
            }
            case 6: {
                return pSDESAVRBase.getPSDEFVRName();
            }
            case 7: {
                return pSDESAVRBase.getPSDESAVRId();
            }
            case 8: {
                return pSDESAVRBase.getPSDESAVRName();
            }
            case 9: {
                return pSDESAVRBase.getPSDEServiceAPIId();
            }
            case 10: {
                return pSDESAVRBase.getPSDEServiceAPIName();
            }
            case 11: {
                return pSDESAVRBase.getPSSysValueRuleId();
            }
            case 12: {
                return pSDESAVRBase.getPSSysValueRuleName();
            }
            case 13: {
                return pSDESAVRBase.getUpdateDate();
            }
            case 14: {
                return pSDESAVRBase.getUpdateMan();
            }
            case 15: {
                return pSDESAVRBase.getUserCat();
            }
            case 16: {
                return pSDESAVRBase.getUserTag();
            }
            case 17: {
                return pSDESAVRBase.getUserTag2();
            }
            case 18: {
                return pSDESAVRBase.getUserTag3();
            }
            case 19: {
                return pSDESAVRBase.getUserTag4();
            }
            case 20: {
                return pSDESAVRBase.getValidFlag();
            }
            case 21: {
                return pSDESAVRBase.getVRType();
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
        PSDESAVRBase.set(this, n, object);
    }

    private static void set(PSDESAVRBase pSDESAVRBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDESAVRBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDESAVRBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDESAVRBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDESAVRBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDESAVRBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDESAVRBase.setPSDEFVRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDESAVRBase.setPSDEFVRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDESAVRBase.setPSDESAVRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDESAVRBase.setPSDESAVRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDESAVRBase.setPSDEServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDESAVRBase.setPSDEServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDESAVRBase.setPSSysValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDESAVRBase.setPSSysValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDESAVRBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDESAVRBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDESAVRBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDESAVRBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDESAVRBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDESAVRBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDESAVRBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDESAVRBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDESAVRBase.setVRType(DataObject.getStringValue((Object)object));
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
        return PSDESAVRBase.isNull(this, n);
    }

    private static boolean isNull(PSDESAVRBase pSDESAVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESAVRBase.getCodeName() == null;
            }
            case 1: {
                return pSDESAVRBase.getCreateDate() == null;
            }
            case 2: {
                return pSDESAVRBase.getCreateMan() == null;
            }
            case 3: {
                return pSDESAVRBase.getMemo() == null;
            }
            case 4: {
                return pSDESAVRBase.getOrderValue() == null;
            }
            case 5: {
                return pSDESAVRBase.getPSDEFVRId() == null;
            }
            case 6: {
                return pSDESAVRBase.getPSDEFVRName() == null;
            }
            case 7: {
                return pSDESAVRBase.getPSDESAVRId() == null;
            }
            case 8: {
                return pSDESAVRBase.getPSDESAVRName() == null;
            }
            case 9: {
                return pSDESAVRBase.getPSDEServiceAPIId() == null;
            }
            case 10: {
                return pSDESAVRBase.getPSDEServiceAPIName() == null;
            }
            case 11: {
                return pSDESAVRBase.getPSSysValueRuleId() == null;
            }
            case 12: {
                return pSDESAVRBase.getPSSysValueRuleName() == null;
            }
            case 13: {
                return pSDESAVRBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDESAVRBase.getUpdateMan() == null;
            }
            case 15: {
                return pSDESAVRBase.getUserCat() == null;
            }
            case 16: {
                return pSDESAVRBase.getUserTag() == null;
            }
            case 17: {
                return pSDESAVRBase.getUserTag2() == null;
            }
            case 18: {
                return pSDESAVRBase.getUserTag3() == null;
            }
            case 19: {
                return pSDESAVRBase.getUserTag4() == null;
            }
            case 20: {
                return pSDESAVRBase.getValidFlag() == null;
            }
            case 21: {
                return pSDESAVRBase.getVRType() == null;
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
        return PSDESAVRBase.contains(this, n);
    }

    private static boolean contains(PSDESAVRBase pSDESAVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDESAVRBase.isCodeNameDirty();
            }
            case 1: {
                return pSDESAVRBase.isCreateDateDirty();
            }
            case 2: {
                return pSDESAVRBase.isCreateManDirty();
            }
            case 3: {
                return pSDESAVRBase.isMemoDirty();
            }
            case 4: {
                return pSDESAVRBase.isOrderValueDirty();
            }
            case 5: {
                return pSDESAVRBase.isPSDEFVRIdDirty();
            }
            case 6: {
                return pSDESAVRBase.isPSDEFVRNameDirty();
            }
            case 7: {
                return pSDESAVRBase.isPSDESAVRIdDirty();
            }
            case 8: {
                return pSDESAVRBase.isPSDESAVRNameDirty();
            }
            case 9: {
                return pSDESAVRBase.isPSDEServiceAPIIdDirty();
            }
            case 10: {
                return pSDESAVRBase.isPSDEServiceAPINameDirty();
            }
            case 11: {
                return pSDESAVRBase.isPSSysValueRuleIdDirty();
            }
            case 12: {
                return pSDESAVRBase.isPSSysValueRuleNameDirty();
            }
            case 13: {
                return pSDESAVRBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDESAVRBase.isUpdateManDirty();
            }
            case 15: {
                return pSDESAVRBase.isUserCatDirty();
            }
            case 16: {
                return pSDESAVRBase.isUserTagDirty();
            }
            case 17: {
                return pSDESAVRBase.isUserTag2Dirty();
            }
            case 18: {
                return pSDESAVRBase.isUserTag3Dirty();
            }
            case 19: {
                return pSDESAVRBase.isUserTag4Dirty();
            }
            case 20: {
                return pSDESAVRBase.isValidFlagDirty();
            }
            case 21: {
                return pSDESAVRBase.isVRTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDESAVRBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDESAVRBase pSDESAVRBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDESAVRBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getMemo()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getPSDEFVRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrid", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getPSDEFVRId()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getPSDEFVRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrname", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getPSDEFVRName()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getPSDESAVRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesavrid", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getPSDESAVRId()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getPSDESAVRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdesavrname", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getPSDESAVRName()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getPSDEServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeserviceapiid", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getPSDEServiceAPIId()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getPSDEServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeserviceapiname", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getPSDEServiceAPIName()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getPSSysValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvalueruleid", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getPSSysValueRuleId()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getPSSysValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvaluerulename", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getPSSysValueRuleName()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDESAVRBase.getVRType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vrtype", (Object)PSDESAVRBase.getJSONValue((Object)pSDESAVRBase.getVRType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDESAVRBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDESAVRBase pSDESAVRBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDESAVRBase.getCodeName() != null) {
            object = pSDESAVRBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getCreateDate() != null) {
            object = pSDESAVRBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESAVRBase.getCreateMan() != null) {
            object = pSDESAVRBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getMemo() != null) {
            object = pSDESAVRBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getOrderValue() != null) {
            object = pSDESAVRBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESAVRBase.getPSDEFVRId() != null) {
            object = pSDESAVRBase.getPSDEFVRId();
            xmlNode.setAttribute(FIELD_PSDEFVRID, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getPSDEFVRName() != null) {
            object = pSDESAVRBase.getPSDEFVRName();
            xmlNode.setAttribute(FIELD_PSDEFVRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getPSDESAVRId() != null) {
            object = pSDESAVRBase.getPSDESAVRId();
            xmlNode.setAttribute(FIELD_PSDESAVRID, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getPSDESAVRName() != null) {
            object = pSDESAVRBase.getPSDESAVRName();
            xmlNode.setAttribute(FIELD_PSDESAVRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getPSDEServiceAPIId() != null) {
            object = pSDESAVRBase.getPSDEServiceAPIId();
            xmlNode.setAttribute(FIELD_PSDESERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getPSDEServiceAPIName() != null) {
            object = pSDESAVRBase.getPSDEServiceAPIName();
            xmlNode.setAttribute(FIELD_PSDESERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getPSSysValueRuleId() != null) {
            object = pSDESAVRBase.getPSSysValueRuleId();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getPSSysValueRuleName() != null) {
            object = pSDESAVRBase.getPSSysValueRuleName();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getUpdateDate() != null) {
            object = pSDESAVRBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDESAVRBase.getUpdateMan() != null) {
            object = pSDESAVRBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getUserCat() != null) {
            object = pSDESAVRBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getUserTag() != null) {
            object = pSDESAVRBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getUserTag2() != null) {
            object = pSDESAVRBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getUserTag3() != null) {
            object = pSDESAVRBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getUserTag4() != null) {
            object = pSDESAVRBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDESAVRBase.getValidFlag() != null) {
            object = pSDESAVRBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDESAVRBase.getVRType() != null) {
            object = pSDESAVRBase.getVRType();
            xmlNode.setAttribute(FIELD_VRTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDESAVRBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDESAVRBase pSDESAVRBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDESAVRBase.isCodeNameDirty() && (bl || pSDESAVRBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDESAVRBase.getCodeName());
        }
        if (pSDESAVRBase.isCreateDateDirty() && (bl || pSDESAVRBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDESAVRBase.getCreateDate());
        }
        if (pSDESAVRBase.isCreateManDirty() && (bl || pSDESAVRBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDESAVRBase.getCreateMan());
        }
        if (pSDESAVRBase.isMemoDirty() && (bl || pSDESAVRBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDESAVRBase.getMemo());
        }
        if (pSDESAVRBase.isOrderValueDirty() && (bl || pSDESAVRBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDESAVRBase.getOrderValue());
        }
        if (pSDESAVRBase.isPSDEFVRIdDirty() && (bl || pSDESAVRBase.getPSDEFVRId() != null)) {
            iDataObject.set(FIELD_PSDEFVRID, (Object)pSDESAVRBase.getPSDEFVRId());
        }
        if (pSDESAVRBase.isPSDEFVRNameDirty() && (bl || pSDESAVRBase.getPSDEFVRName() != null)) {
            iDataObject.set(FIELD_PSDEFVRNAME, (Object)pSDESAVRBase.getPSDEFVRName());
        }
        if (pSDESAVRBase.isPSDESAVRIdDirty() && (bl || pSDESAVRBase.getPSDESAVRId() != null)) {
            iDataObject.set(FIELD_PSDESAVRID, (Object)pSDESAVRBase.getPSDESAVRId());
        }
        if (pSDESAVRBase.isPSDESAVRNameDirty() && (bl || pSDESAVRBase.getPSDESAVRName() != null)) {
            iDataObject.set(FIELD_PSDESAVRNAME, (Object)pSDESAVRBase.getPSDESAVRName());
        }
        if (pSDESAVRBase.isPSDEServiceAPIIdDirty() && (bl || pSDESAVRBase.getPSDEServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSDESERVICEAPIID, (Object)pSDESAVRBase.getPSDEServiceAPIId());
        }
        if (pSDESAVRBase.isPSDEServiceAPINameDirty() && (bl || pSDESAVRBase.getPSDEServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSDESERVICEAPINAME, (Object)pSDESAVRBase.getPSDEServiceAPIName());
        }
        if (pSDESAVRBase.isPSSysValueRuleIdDirty() && (bl || pSDESAVRBase.getPSSysValueRuleId() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULEID, (Object)pSDESAVRBase.getPSSysValueRuleId());
        }
        if (pSDESAVRBase.isPSSysValueRuleNameDirty() && (bl || pSDESAVRBase.getPSSysValueRuleName() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULENAME, (Object)pSDESAVRBase.getPSSysValueRuleName());
        }
        if (pSDESAVRBase.isUpdateDateDirty() && (bl || pSDESAVRBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDESAVRBase.getUpdateDate());
        }
        if (pSDESAVRBase.isUpdateManDirty() && (bl || pSDESAVRBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDESAVRBase.getUpdateMan());
        }
        if (pSDESAVRBase.isUserCatDirty() && (bl || pSDESAVRBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDESAVRBase.getUserCat());
        }
        if (pSDESAVRBase.isUserTagDirty() && (bl || pSDESAVRBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDESAVRBase.getUserTag());
        }
        if (pSDESAVRBase.isUserTag2Dirty() && (bl || pSDESAVRBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDESAVRBase.getUserTag2());
        }
        if (pSDESAVRBase.isUserTag3Dirty() && (bl || pSDESAVRBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDESAVRBase.getUserTag3());
        }
        if (pSDESAVRBase.isUserTag4Dirty() && (bl || pSDESAVRBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDESAVRBase.getUserTag4());
        }
        if (pSDESAVRBase.isValidFlagDirty() && (bl || pSDESAVRBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDESAVRBase.getValidFlag());
        }
        if (pSDESAVRBase.isVRTypeDirty() && (bl || pSDESAVRBase.getVRType() != null)) {
            iDataObject.set(FIELD_VRTYPE, (Object)pSDESAVRBase.getVRType());
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
        return PSDESAVRBase.remove(this, n);
    }

    private static boolean remove(PSDESAVRBase pSDESAVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDESAVRBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDESAVRBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDESAVRBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDESAVRBase.resetMemo();
                return true;
            }
            case 4: {
                pSDESAVRBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSDESAVRBase.resetPSDEFVRId();
                return true;
            }
            case 6: {
                pSDESAVRBase.resetPSDEFVRName();
                return true;
            }
            case 7: {
                pSDESAVRBase.resetPSDESAVRId();
                return true;
            }
            case 8: {
                pSDESAVRBase.resetPSDESAVRName();
                return true;
            }
            case 9: {
                pSDESAVRBase.resetPSDEServiceAPIId();
                return true;
            }
            case 10: {
                pSDESAVRBase.resetPSDEServiceAPIName();
                return true;
            }
            case 11: {
                pSDESAVRBase.resetPSSysValueRuleId();
                return true;
            }
            case 12: {
                pSDESAVRBase.resetPSSysValueRuleName();
                return true;
            }
            case 13: {
                pSDESAVRBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDESAVRBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSDESAVRBase.resetUserCat();
                return true;
            }
            case 16: {
                pSDESAVRBase.resetUserTag();
                return true;
            }
            case 17: {
                pSDESAVRBase.resetUserTag2();
                return true;
            }
            case 18: {
                pSDESAVRBase.resetUserTag3();
                return true;
            }
            case 19: {
                pSDESAVRBase.resetUserTag4();
                return true;
            }
            case 20: {
                pSDESAVRBase.resetValidFlag();
                return true;
            }
            case 21: {
                pSDESAVRBase.resetVRType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFValueRule getPSDEFVR() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVR();
        }
        if (this.getPSDEFVRId() == null) {
            return null;
        }
        Integer n = this.objPSDEFVRLock;
        synchronized (n) {
            if (this.psdefvr != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFVRId(), (Object)this.psdefvr.getPSDEFValueRuleId()) != 0L) {
                this.psdefvr = null;
            }
            if (this.psdefvr == null) {
                PSDEFValueRule pSDEFValueRule = new PSDEFValueRule();
                pSDEFValueRule.setPSDEFValueRuleId(this.getPSDEFVRId());
                PSDEFValueRuleService pSDEFValueRuleService = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSDEFValueRuleService.autoGet(pSDEFValueRule);
                this.psdefvr = pSDEFValueRule;
            }
            return this.psdefvr;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEServiceAPI getPSDEServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEServiceAPI();
        }
        if (this.getPSDEServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSDEServiceAPILock;
        synchronized (n) {
            if (this.psdeserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEServiceAPIId(), (Object)this.psdeserviceapi.getPSDEServiceAPIId()) != 0L) {
                this.psdeserviceapi = null;
            }
            if (this.psdeserviceapi == null) {
                PSDEServiceAPI pSDEServiceAPI = new PSDEServiceAPI();
                pSDEServiceAPI.setPSDEServiceAPIId(this.getPSDEServiceAPIId());
                PSDEServiceAPIService pSDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSDEServiceAPIService.autoGet(pSDEServiceAPI);
                this.psdeserviceapi = pSDEServiceAPI;
            }
            return this.psdeserviceapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysValueRule getPSSysValueRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRule();
        }
        if (this.getPSSysValueRuleId() == null) {
            return null;
        }
        Integer n = this.objPSSysValueRuleLock;
        synchronized (n) {
            if (this.pssysvaluerule != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysValueRuleId(), (Object)this.pssysvaluerule.getPSSysValueRuleId()) != 0L) {
                this.pssysvaluerule = null;
            }
            if (this.pssysvaluerule == null) {
                PSSysValueRule pSSysValueRule = new PSSysValueRule();
                pSSysValueRule.setPSSysValueRuleId(this.getPSSysValueRuleId());
                PSSysValueRuleService pSSysValueRuleService = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSSysValueRuleService.autoGet(pSSysValueRule);
                this.pssysvaluerule = pSSysValueRule;
            }
            return this.pssysvaluerule;
        }
    }

    private PSDESAVRBase getProxyEntity() {
        return this.proxyPSDESAVRBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDESAVRBase = null;
        if (iDataObject != null && iDataObject instanceof PSDESAVRBase) {
            this.proxyPSDESAVRBase = (PSDESAVRBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESAVRService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSDEFVRID, 5);
        fieldIndexMap.put(FIELD_PSDEFVRNAME, 6);
        fieldIndexMap.put(FIELD_PSDESAVRID, 7);
        fieldIndexMap.put(FIELD_PSDESAVRNAME, 8);
        fieldIndexMap.put(FIELD_PSDESERVICEAPIID, 9);
        fieldIndexMap.put(FIELD_PSDESERVICEAPINAME, 10);
        fieldIndexMap.put(FIELD_PSSYSVALUERULEID, 11);
        fieldIndexMap.put(FIELD_PSSYSVALUERULENAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERCAT, 15);
        fieldIndexMap.put(FIELD_USERTAG, 16);
        fieldIndexMap.put(FIELD_USERTAG2, 17);
        fieldIndexMap.put(FIELD_USERTAG3, 18);
        fieldIndexMap.put(FIELD_USERTAG4, 19);
        fieldIndexMap.put(FIELD_VALIDFLAG, 20);
        fieldIndexMap.put(FIELD_VRTYPE, 21);
    }
}

