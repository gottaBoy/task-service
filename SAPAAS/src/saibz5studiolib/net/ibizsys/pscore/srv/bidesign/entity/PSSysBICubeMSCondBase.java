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
package net.ibizsys.pscore.srv.bidesign.entity;

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
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMSCond;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasure;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSCondService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import net.ibizsys.pscore.srv.config.entity.PSVarType;
import net.ibizsys.pscore.srv.config.service.PSDBValueOPService;
import net.ibizsys.pscore.srv.config.service.PSVarTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVF;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBICubeMSCondBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBICubeMSCondBase.class);
    public static final String FIELD_CONDTYPE = "CONDTYPE";
    public static final String FIELD_CONDVALUE = "CONDVALUE";
    public static final String FIELD_CONDVALUETEXT = "CONDVALUETEXT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String FIELD_GROUPOP = "GROUPOP";
    public static final String FIELD_IGNOREEMPTY = "IGNOREEMPTY";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSSYSBICUBEMSCONDID = "PPSSYSBICUBEMSCONDID";
    public static final String FIELD_PPSSYSBICUBEMSCONDNAME = "PPSSYSBICUBEMSCONDNAME";
    public static final String FIELD_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String FIELD_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSBICUBEMEASUREID = "PSSYSBICUBEMEASUREID";
    public static final String FIELD_PSSYSBICUBEMEASURENAME = "PSSYSBICUBEMEASURENAME";
    public static final String FIELD_PSSYSBICUBEMSCONDID = "PSSYSBICUBEMSCONDID";
    public static final String FIELD_PSSYSBICUBEMSCONDNAME = "PSSYSBICUBEMSCONDNAME";
    public static final String FIELD_PSSYSDBVFID = "PSSYSDBVFID";
    public static final String FIELD_PSSYSDBVFNAME = "PSSYSDBVFNAME";
    public static final String FIELD_PSVARTYPEID = "PSVARTYPEID";
    public static final String FIELD_PSVARTYPENAME = "PSVARTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CONDTYPE = 0;
    private static final int INDEX_CONDVALUE = 1;
    private static final int INDEX_CONDVALUETEXT = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_CUSTOMCOND = 5;
    private static final int INDEX_CUSTOMTYPE = 6;
    private static final int INDEX_GROUPNOTFLAG = 7;
    private static final int INDEX_GROUPOP = 8;
    private static final int INDEX_IGNOREEMPTY = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_ORDERVALUE = 11;
    private static final int INDEX_PPSSYSBICUBEMSCONDID = 12;
    private static final int INDEX_PPSSYSBICUBEMSCONDNAME = 13;
    private static final int INDEX_PSDBVALUEOPID = 14;
    private static final int INDEX_PSDBVALUEOPNAME = 15;
    private static final int INDEX_PSDEFID = 16;
    private static final int INDEX_PSDEFNAME = 17;
    private static final int INDEX_PSDEID = 18;
    private static final int INDEX_PSSYSBICUBEMEASUREID = 19;
    private static final int INDEX_PSSYSBICUBEMEASURENAME = 20;
    private static final int INDEX_PSSYSBICUBEMSCONDID = 21;
    private static final int INDEX_PSSYSBICUBEMSCONDNAME = 22;
    private static final int INDEX_PSSYSDBVFID = 23;
    private static final int INDEX_PSSYSDBVFNAME = 24;
    private static final int INDEX_PSVARTYPEID = 25;
    private static final int INDEX_PSVARTYPENAME = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_USERCAT = 29;
    private static final int INDEX_USERTAG = 30;
    private static final int INDEX_USERTAG2 = 31;
    private static final int INDEX_USERTAG3 = 32;
    private static final int INDEX_USERTAG4 = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBICubeMSCondBase proxyPSSysBICubeMSCondBase = null;
    private boolean condtypeDirtyFlag = false;
    private boolean condvalueDirtyFlag = false;
    private boolean condvaluetextDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean groupnotflagDirtyFlag = false;
    private boolean groupopDirtyFlag = false;
    private boolean ignoreemptyDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppssysbicubemscondidDirtyFlag = false;
    private boolean ppssysbicubemscondnameDirtyFlag = false;
    private boolean psdbvalueopidDirtyFlag = false;
    private boolean psdbvalueopnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssysbicubemeasureidDirtyFlag = false;
    private boolean pssysbicubemeasurenameDirtyFlag = false;
    private boolean pssysbicubemscondidDirtyFlag = false;
    private boolean pssysbicubemscondnameDirtyFlag = false;
    private boolean pssysdbvfidDirtyFlag = false;
    private boolean pssysdbvfnameDirtyFlag = false;
    private boolean psvartypeidDirtyFlag = false;
    private boolean psvartypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="condtype")
    private String condtype;
    @Column(name="condvalue")
    private String condvalue;
    @Column(name="condvaluetext")
    private String condvaluetext;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcond")
    private String customcond;
    @Column(name="customtype")
    private String customtype;
    @Column(name="groupnotflag")
    private Integer groupnotflag;
    @Column(name="groupop")
    private String groupop;
    @Column(name="ignoreempty")
    private Integer ignoreempty;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppssysbicubemscondid")
    private String ppssysbicubemscondid;
    @Column(name="ppssysbicubemscondname")
    private String ppssysbicubemscondname;
    @Column(name="psdbvalueopid")
    private String psdbvalueopid;
    @Column(name="psdbvalueopname")
    private String psdbvalueopname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssysbicubemeasureid")
    private String pssysbicubemeasureid;
    @Column(name="pssysbicubemeasurename")
    private String pssysbicubemeasurename;
    @Column(name="pssysbicubemscondid")
    private String pssysbicubemscondid;
    @Column(name="pssysbicubemscondname")
    private String pssysbicubemscondname;
    @Column(name="pssysdbvfid")
    private String pssysdbvfid;
    @Column(name="pssysdbvfname")
    private String pssysdbvfname;
    @Column(name="psvartypeid")
    private String psvartypeid;
    @Column(name="psvartypename")
    private String psvartypename;
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
    private Integer objPSDBValueOPLock = new Integer(1);
    private PSDBValueOP psdbvalueop = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSSysBICubeMeasureLock = new Integer(1);
    private PSSysBICubeMeasure pssysbicubemeasure = null;
    private Integer objPPSSysBICubeMSCondLock = new Integer(1);
    private PSSysBICubeMSCond ppssysbicubemscond = null;
    private Integer objPSSysDBVFLock = new Integer(1);
    private PSSysDBVF pssysdbvf = null;
    private Integer objPSVarTypeLock = new Integer(1);
    private PSVarType psvartype = null;

    public void setCondType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condtype = string;
        this.condtypeDirtyFlag = true;
    }

    public String getCondType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondType();
        }
        return this.condtype;
    }

    public boolean isCondTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondTypeDirty();
        }
        return this.condtypeDirtyFlag;
    }

    public void resetCondType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondType();
            return;
        }
        this.condtypeDirtyFlag = false;
        this.condtype = null;
    }

    public void setCondValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condvalue = string;
        this.condvalueDirtyFlag = true;
    }

    public String getCondValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondValue();
        }
        return this.condvalue;
    }

    public boolean isCondValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondValueDirty();
        }
        return this.condvalueDirtyFlag;
    }

    public void resetCondValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondValue();
            return;
        }
        this.condvalueDirtyFlag = false;
        this.condvalue = null;
    }

    public void setCondValueText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondValueText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condvaluetext = string;
        this.condvaluetextDirtyFlag = true;
    }

    public String getCondValueText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondValueText();
        }
        return this.condvaluetext;
    }

    public boolean isCondValueTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondValueTextDirty();
        }
        return this.condvaluetextDirtyFlag;
    }

    public void resetCondValueText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondValueText();
            return;
        }
        this.condvaluetextDirtyFlag = false;
        this.condvaluetext = null;
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

    public void setCustomCond(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCond(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcond = string;
        this.customcondDirtyFlag = true;
    }

    public String getCustomCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCond();
        }
        return this.customcond;
    }

    public boolean isCustomCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCondDirty();
        }
        return this.customcondDirtyFlag;
    }

    public void resetCustomCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCond();
            return;
        }
        this.customcondDirtyFlag = false;
        this.customcond = null;
    }

    public void setCustomType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customtype = string;
        this.customtypeDirtyFlag = true;
    }

    public String getCustomType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomType();
        }
        return this.customtype;
    }

    public boolean isCustomTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomTypeDirty();
        }
        return this.customtypeDirtyFlag;
    }

    public void resetCustomType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomType();
            return;
        }
        this.customtypeDirtyFlag = false;
        this.customtype = null;
    }

    public void setGroupNotFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupNotFlag(n);
            return;
        }
        this.groupnotflag = n;
        this.groupnotflagDirtyFlag = true;
    }

    public Integer getGroupNotFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupNotFlag();
        }
        return this.groupnotflag;
    }

    public boolean isGroupNotFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupNotFlagDirty();
        }
        return this.groupnotflagDirtyFlag;
    }

    public void resetGroupNotFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupNotFlag();
            return;
        }
        this.groupnotflagDirtyFlag = false;
        this.groupnotflag = null;
    }

    public void setGroupOP(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupOP(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupop = string;
        this.groupopDirtyFlag = true;
    }

    public String getGroupOP() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupOP();
        }
        return this.groupop;
    }

    public boolean isGroupOPDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupOPDirty();
        }
        return this.groupopDirtyFlag;
    }

    public void resetGroupOP() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupOP();
            return;
        }
        this.groupopDirtyFlag = false;
        this.groupop = null;
    }

    public void setIgnoreEmpty(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreEmpty(n);
            return;
        }
        this.ignoreempty = n;
        this.ignoreemptyDirtyFlag = true;
    }

    public Integer getIgnoreEmpty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreEmpty();
        }
        return this.ignoreempty;
    }

    public boolean isIgnoreEmptyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreEmptyDirty();
        }
        return this.ignoreemptyDirtyFlag;
    }

    public void resetIgnoreEmpty() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreEmpty();
            return;
        }
        this.ignoreemptyDirtyFlag = false;
        this.ignoreempty = null;
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

    public void setPPSSysBICubeMSCondId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysBICubeMSCondId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysbicubemscondid = string;
        this.ppssysbicubemscondidDirtyFlag = true;
    }

    public String getPPSSysBICubeMSCondId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysBICubeMSCondId();
        }
        return this.ppssysbicubemscondid;
    }

    public boolean isPPSSysBICubeMSCondIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysBICubeMSCondIdDirty();
        }
        return this.ppssysbicubemscondidDirtyFlag;
    }

    public void resetPPSSysBICubeMSCondId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysBICubeMSCondId();
            return;
        }
        this.ppssysbicubemscondidDirtyFlag = false;
        this.ppssysbicubemscondid = null;
    }

    public void setPPSSysBICubeMSCondName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysBICubeMSCondName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysbicubemscondname = string;
        this.ppssysbicubemscondnameDirtyFlag = true;
    }

    public String getPPSSysBICubeMSCondName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysBICubeMSCondName();
        }
        return this.ppssysbicubemscondname;
    }

    public boolean isPPSSysBICubeMSCondNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysBICubeMSCondNameDirty();
        }
        return this.ppssysbicubemscondnameDirtyFlag;
    }

    public void resetPPSSysBICubeMSCondName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysBICubeMSCondName();
            return;
        }
        this.ppssysbicubemscondnameDirtyFlag = false;
        this.ppssysbicubemscondname = null;
    }

    public void setPSDBValueOPId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueOPId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvalueopid = string;
        this.psdbvalueopidDirtyFlag = true;
    }

    public String getPSDBValueOPId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOPId();
        }
        return this.psdbvalueopid;
    }

    public boolean isPSDBValueOPIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueOPIdDirty();
        }
        return this.psdbvalueopidDirtyFlag;
    }

    public void resetPSDBValueOPId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueOPId();
            return;
        }
        this.psdbvalueopidDirtyFlag = false;
        this.psdbvalueopid = null;
    }

    public void setPSDBValueOPName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueOPName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvalueopname = string;
        this.psdbvalueopnameDirtyFlag = true;
    }

    public String getPSDBValueOPName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOPName();
        }
        return this.psdbvalueopname;
    }

    public boolean isPSDBValueOPNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueOPNameDirty();
        }
        return this.psdbvalueopnameDirtyFlag;
    }

    public void resetPSDBValueOPName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueOPName();
            return;
        }
        this.psdbvalueopnameDirtyFlag = false;
        this.psdbvalueopname = null;
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

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
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

    public void setPSSysBICubeMeasureId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeMeasureId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubemeasureid = string;
        this.pssysbicubemeasureidDirtyFlag = true;
    }

    public String getPSSysBICubeMeasureId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeMeasureId();
        }
        return this.pssysbicubemeasureid;
    }

    public boolean isPSSysBICubeMeasureIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeMeasureIdDirty();
        }
        return this.pssysbicubemeasureidDirtyFlag;
    }

    public void resetPSSysBICubeMeasureId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeMeasureId();
            return;
        }
        this.pssysbicubemeasureidDirtyFlag = false;
        this.pssysbicubemeasureid = null;
    }

    public void setPSSysBICubeMeasureName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeMeasureName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubemeasurename = string;
        this.pssysbicubemeasurenameDirtyFlag = true;
    }

    public String getPSSysBICubeMeasureName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeMeasureName();
        }
        return this.pssysbicubemeasurename;
    }

    public boolean isPSSysBICubeMeasureNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeMeasureNameDirty();
        }
        return this.pssysbicubemeasurenameDirtyFlag;
    }

    public void resetPSSysBICubeMeasureName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeMeasureName();
            return;
        }
        this.pssysbicubemeasurenameDirtyFlag = false;
        this.pssysbicubemeasurename = null;
    }

    public void setPSSysBICubeMSCondId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeMSCondId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubemscondid = string;
        this.pssysbicubemscondidDirtyFlag = true;
    }

    public String getPSSysBICubeMSCondId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeMSCondId();
        }
        return this.pssysbicubemscondid;
    }

    public boolean isPSSysBICubeMSCondIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeMSCondIdDirty();
        }
        return this.pssysbicubemscondidDirtyFlag;
    }

    public void resetPSSysBICubeMSCondId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeMSCondId();
            return;
        }
        this.pssysbicubemscondidDirtyFlag = false;
        this.pssysbicubemscondid = null;
    }

    public void setPSSysBICubeMSCondName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeMSCondName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubemscondname = string;
        this.pssysbicubemscondnameDirtyFlag = true;
    }

    public String getPSSysBICubeMSCondName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeMSCondName();
        }
        return this.pssysbicubemscondname;
    }

    public boolean isPSSysBICubeMSCondNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeMSCondNameDirty();
        }
        return this.pssysbicubemscondnameDirtyFlag;
    }

    public void resetPSSysBICubeMSCondName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeMSCondName();
            return;
        }
        this.pssysbicubemscondnameDirtyFlag = false;
        this.pssysbicubemscondname = null;
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

    public void setPSVarTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVarTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvartypeid = string;
        this.psvartypeidDirtyFlag = true;
    }

    public String getPSVarTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVarTypeId();
        }
        return this.psvartypeid;
    }

    public boolean isPSVarTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVarTypeIdDirty();
        }
        return this.psvartypeidDirtyFlag;
    }

    public void resetPSVarTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVarTypeId();
            return;
        }
        this.psvartypeidDirtyFlag = false;
        this.psvartypeid = null;
    }

    public void setPSVARTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVARTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvartypename = string;
        this.psvartypenameDirtyFlag = true;
    }

    public String getPSVARTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVARTypeName();
        }
        return this.psvartypename;
    }

    public boolean isPSVARTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVARTypeNameDirty();
        }
        return this.psvartypenameDirtyFlag;
    }

    public void resetPSVARTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVARTypeName();
            return;
        }
        this.psvartypenameDirtyFlag = false;
        this.psvartypename = null;
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

    protected void onReset() {
        PSSysBICubeMSCondBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBICubeMSCondBase pSSysBICubeMSCondBase) {
        pSSysBICubeMSCondBase.resetCondType();
        pSSysBICubeMSCondBase.resetCondValue();
        pSSysBICubeMSCondBase.resetCondValueText();
        pSSysBICubeMSCondBase.resetCreateDate();
        pSSysBICubeMSCondBase.resetCreateMan();
        pSSysBICubeMSCondBase.resetCustomCond();
        pSSysBICubeMSCondBase.resetCustomType();
        pSSysBICubeMSCondBase.resetGroupNotFlag();
        pSSysBICubeMSCondBase.resetGroupOP();
        pSSysBICubeMSCondBase.resetIgnoreEmpty();
        pSSysBICubeMSCondBase.resetMemo();
        pSSysBICubeMSCondBase.resetOrderValue();
        pSSysBICubeMSCondBase.resetPPSSysBICubeMSCondId();
        pSSysBICubeMSCondBase.resetPPSSysBICubeMSCondName();
        pSSysBICubeMSCondBase.resetPSDBValueOPId();
        pSSysBICubeMSCondBase.resetPSDBValueOPName();
        pSSysBICubeMSCondBase.resetPSDEFId();
        pSSysBICubeMSCondBase.resetPSDEFName();
        pSSysBICubeMSCondBase.resetPSDEId();
        pSSysBICubeMSCondBase.resetPSSysBICubeMeasureId();
        pSSysBICubeMSCondBase.resetPSSysBICubeMeasureName();
        pSSysBICubeMSCondBase.resetPSSysBICubeMSCondId();
        pSSysBICubeMSCondBase.resetPSSysBICubeMSCondName();
        pSSysBICubeMSCondBase.resetPSSysDBVFId();
        pSSysBICubeMSCondBase.resetPSSysDBVFName();
        pSSysBICubeMSCondBase.resetPSVarTypeId();
        pSSysBICubeMSCondBase.resetPSVARTypeName();
        pSSysBICubeMSCondBase.resetUpdateDate();
        pSSysBICubeMSCondBase.resetUpdateMan();
        pSSysBICubeMSCondBase.resetUserCat();
        pSSysBICubeMSCondBase.resetUserTag();
        pSSysBICubeMSCondBase.resetUserTag2();
        pSSysBICubeMSCondBase.resetUserTag3();
        pSSysBICubeMSCondBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCondTypeDirty()) {
            hashMap.put(FIELD_CONDTYPE, this.getCondType());
        }
        if (!bl || this.isCondValueDirty()) {
            hashMap.put(FIELD_CONDVALUE, this.getCondValue());
        }
        if (!bl || this.isCondValueTextDirty()) {
            hashMap.put(FIELD_CONDVALUETEXT, this.getCondValueText());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCondDirty()) {
            hashMap.put(FIELD_CUSTOMCOND, this.getCustomCond());
        }
        if (!bl || this.isCustomTypeDirty()) {
            hashMap.put(FIELD_CUSTOMTYPE, this.getCustomType());
        }
        if (!bl || this.isGroupNotFlagDirty()) {
            hashMap.put(FIELD_GROUPNOTFLAG, this.getGroupNotFlag());
        }
        if (!bl || this.isGroupOPDirty()) {
            hashMap.put(FIELD_GROUPOP, this.getGroupOP());
        }
        if (!bl || this.isIgnoreEmptyDirty()) {
            hashMap.put(FIELD_IGNOREEMPTY, this.getIgnoreEmpty());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSSysBICubeMSCondIdDirty()) {
            hashMap.put(FIELD_PPSSYSBICUBEMSCONDID, this.getPPSSysBICubeMSCondId());
        }
        if (!bl || this.isPPSSysBICubeMSCondNameDirty()) {
            hashMap.put(FIELD_PPSSYSBICUBEMSCONDNAME, this.getPPSSysBICubeMSCondName());
        }
        if (!bl || this.isPSDBValueOPIdDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPID, this.getPSDBValueOPId());
        }
        if (!bl || this.isPSDBValueOPNameDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPNAME, this.getPSDBValueOPName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSSysBICubeMeasureIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEMEASUREID, this.getPSSysBICubeMeasureId());
        }
        if (!bl || this.isPSSysBICubeMeasureNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEMEASURENAME, this.getPSSysBICubeMeasureName());
        }
        if (!bl || this.isPSSysBICubeMSCondIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEMSCONDID, this.getPSSysBICubeMSCondId());
        }
        if (!bl || this.isPSSysBICubeMSCondNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEMSCONDNAME, this.getPSSysBICubeMSCondName());
        }
        if (!bl || this.isPSSysDBVFIdDirty()) {
            hashMap.put(FIELD_PSSYSDBVFID, this.getPSSysDBVFId());
        }
        if (!bl || this.isPSSysDBVFNameDirty()) {
            hashMap.put(FIELD_PSSYSDBVFNAME, this.getPSSysDBVFName());
        }
        if (!bl || this.isPSVarTypeIdDirty()) {
            hashMap.put(FIELD_PSVARTYPEID, this.getPSVarTypeId());
        }
        if (!bl || this.isPSVARTypeNameDirty()) {
            hashMap.put(FIELD_PSVARTYPENAME, this.getPSVARTypeName());
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
        return PSSysBICubeMSCondBase.get(this, n);
    }

    private static Object get(PSSysBICubeMSCondBase pSSysBICubeMSCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeMSCondBase.getCondType();
            }
            case 1: {
                return pSSysBICubeMSCondBase.getCondValue();
            }
            case 2: {
                return pSSysBICubeMSCondBase.getCondValueText();
            }
            case 3: {
                return pSSysBICubeMSCondBase.getCreateDate();
            }
            case 4: {
                return pSSysBICubeMSCondBase.getCreateMan();
            }
            case 5: {
                return pSSysBICubeMSCondBase.getCustomCond();
            }
            case 6: {
                return pSSysBICubeMSCondBase.getCustomType();
            }
            case 7: {
                return pSSysBICubeMSCondBase.getGroupNotFlag();
            }
            case 8: {
                return pSSysBICubeMSCondBase.getGroupOP();
            }
            case 9: {
                return pSSysBICubeMSCondBase.getIgnoreEmpty();
            }
            case 10: {
                return pSSysBICubeMSCondBase.getMemo();
            }
            case 11: {
                return pSSysBICubeMSCondBase.getOrderValue();
            }
            case 12: {
                return pSSysBICubeMSCondBase.getPPSSysBICubeMSCondId();
            }
            case 13: {
                return pSSysBICubeMSCondBase.getPPSSysBICubeMSCondName();
            }
            case 14: {
                return pSSysBICubeMSCondBase.getPSDBValueOPId();
            }
            case 15: {
                return pSSysBICubeMSCondBase.getPSDBValueOPName();
            }
            case 16: {
                return pSSysBICubeMSCondBase.getPSDEFId();
            }
            case 17: {
                return pSSysBICubeMSCondBase.getPSDEFName();
            }
            case 18: {
                return pSSysBICubeMSCondBase.getPSDEId();
            }
            case 19: {
                return pSSysBICubeMSCondBase.getPSSysBICubeMeasureId();
            }
            case 20: {
                return pSSysBICubeMSCondBase.getPSSysBICubeMeasureName();
            }
            case 21: {
                return pSSysBICubeMSCondBase.getPSSysBICubeMSCondId();
            }
            case 22: {
                return pSSysBICubeMSCondBase.getPSSysBICubeMSCondName();
            }
            case 23: {
                return pSSysBICubeMSCondBase.getPSSysDBVFId();
            }
            case 24: {
                return pSSysBICubeMSCondBase.getPSSysDBVFName();
            }
            case 25: {
                return pSSysBICubeMSCondBase.getPSVarTypeId();
            }
            case 26: {
                return pSSysBICubeMSCondBase.getPSVARTypeName();
            }
            case 27: {
                return pSSysBICubeMSCondBase.getUpdateDate();
            }
            case 28: {
                return pSSysBICubeMSCondBase.getUpdateMan();
            }
            case 29: {
                return pSSysBICubeMSCondBase.getUserCat();
            }
            case 30: {
                return pSSysBICubeMSCondBase.getUserTag();
            }
            case 31: {
                return pSSysBICubeMSCondBase.getUserTag2();
            }
            case 32: {
                return pSSysBICubeMSCondBase.getUserTag3();
            }
            case 33: {
                return pSSysBICubeMSCondBase.getUserTag4();
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
        PSSysBICubeMSCondBase.set(this, n, object);
    }

    private static void set(PSSysBICubeMSCondBase pSSysBICubeMSCondBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBICubeMSCondBase.setCondType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBICubeMSCondBase.setCondValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBICubeMSCondBase.setCondValueText(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBICubeMSCondBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSysBICubeMSCondBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBICubeMSCondBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBICubeMSCondBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBICubeMSCondBase.setGroupNotFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysBICubeMSCondBase.setGroupOP(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBICubeMSCondBase.setIgnoreEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysBICubeMSCondBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBICubeMSCondBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysBICubeMSCondBase.setPPSSysBICubeMSCondId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBICubeMSCondBase.setPPSSysBICubeMSCondName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBICubeMSCondBase.setPSDBValueOPId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBICubeMSCondBase.setPSDBValueOPName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBICubeMSCondBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysBICubeMSCondBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBICubeMSCondBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBICubeMSCondBase.setPSSysBICubeMeasureId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysBICubeMSCondBase.setPSSysBICubeMeasureName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBICubeMSCondBase.setPSSysBICubeMSCondId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBICubeMSCondBase.setPSSysBICubeMSCondName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBICubeMSCondBase.setPSSysDBVFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBICubeMSCondBase.setPSSysDBVFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysBICubeMSCondBase.setPSVarTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysBICubeMSCondBase.setPSVARTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysBICubeMSCondBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSSysBICubeMSCondBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysBICubeMSCondBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysBICubeMSCondBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysBICubeMSCondBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysBICubeMSCondBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysBICubeMSCondBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysBICubeMSCondBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBICubeMSCondBase pSSysBICubeMSCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeMSCondBase.getCondType() == null;
            }
            case 1: {
                return pSSysBICubeMSCondBase.getCondValue() == null;
            }
            case 2: {
                return pSSysBICubeMSCondBase.getCondValueText() == null;
            }
            case 3: {
                return pSSysBICubeMSCondBase.getCreateDate() == null;
            }
            case 4: {
                return pSSysBICubeMSCondBase.getCreateMan() == null;
            }
            case 5: {
                return pSSysBICubeMSCondBase.getCustomCond() == null;
            }
            case 6: {
                return pSSysBICubeMSCondBase.getCustomType() == null;
            }
            case 7: {
                return pSSysBICubeMSCondBase.getGroupNotFlag() == null;
            }
            case 8: {
                return pSSysBICubeMSCondBase.getGroupOP() == null;
            }
            case 9: {
                return pSSysBICubeMSCondBase.getIgnoreEmpty() == null;
            }
            case 10: {
                return pSSysBICubeMSCondBase.getMemo() == null;
            }
            case 11: {
                return pSSysBICubeMSCondBase.getOrderValue() == null;
            }
            case 12: {
                return pSSysBICubeMSCondBase.getPPSSysBICubeMSCondId() == null;
            }
            case 13: {
                return pSSysBICubeMSCondBase.getPPSSysBICubeMSCondName() == null;
            }
            case 14: {
                return pSSysBICubeMSCondBase.getPSDBValueOPId() == null;
            }
            case 15: {
                return pSSysBICubeMSCondBase.getPSDBValueOPName() == null;
            }
            case 16: {
                return pSSysBICubeMSCondBase.getPSDEFId() == null;
            }
            case 17: {
                return pSSysBICubeMSCondBase.getPSDEFName() == null;
            }
            case 18: {
                return pSSysBICubeMSCondBase.getPSDEId() == null;
            }
            case 19: {
                return pSSysBICubeMSCondBase.getPSSysBICubeMeasureId() == null;
            }
            case 20: {
                return pSSysBICubeMSCondBase.getPSSysBICubeMeasureName() == null;
            }
            case 21: {
                return pSSysBICubeMSCondBase.getPSSysBICubeMSCondId() == null;
            }
            case 22: {
                return pSSysBICubeMSCondBase.getPSSysBICubeMSCondName() == null;
            }
            case 23: {
                return pSSysBICubeMSCondBase.getPSSysDBVFId() == null;
            }
            case 24: {
                return pSSysBICubeMSCondBase.getPSSysDBVFName() == null;
            }
            case 25: {
                return pSSysBICubeMSCondBase.getPSVarTypeId() == null;
            }
            case 26: {
                return pSSysBICubeMSCondBase.getPSVARTypeName() == null;
            }
            case 27: {
                return pSSysBICubeMSCondBase.getUpdateDate() == null;
            }
            case 28: {
                return pSSysBICubeMSCondBase.getUpdateMan() == null;
            }
            case 29: {
                return pSSysBICubeMSCondBase.getUserCat() == null;
            }
            case 30: {
                return pSSysBICubeMSCondBase.getUserTag() == null;
            }
            case 31: {
                return pSSysBICubeMSCondBase.getUserTag2() == null;
            }
            case 32: {
                return pSSysBICubeMSCondBase.getUserTag3() == null;
            }
            case 33: {
                return pSSysBICubeMSCondBase.getUserTag4() == null;
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
        return PSSysBICubeMSCondBase.contains(this, n);
    }

    private static boolean contains(PSSysBICubeMSCondBase pSSysBICubeMSCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeMSCondBase.isCondTypeDirty();
            }
            case 1: {
                return pSSysBICubeMSCondBase.isCondValueDirty();
            }
            case 2: {
                return pSSysBICubeMSCondBase.isCondValueTextDirty();
            }
            case 3: {
                return pSSysBICubeMSCondBase.isCreateDateDirty();
            }
            case 4: {
                return pSSysBICubeMSCondBase.isCreateManDirty();
            }
            case 5: {
                return pSSysBICubeMSCondBase.isCustomCondDirty();
            }
            case 6: {
                return pSSysBICubeMSCondBase.isCustomTypeDirty();
            }
            case 7: {
                return pSSysBICubeMSCondBase.isGroupNotFlagDirty();
            }
            case 8: {
                return pSSysBICubeMSCondBase.isGroupOPDirty();
            }
            case 9: {
                return pSSysBICubeMSCondBase.isIgnoreEmptyDirty();
            }
            case 10: {
                return pSSysBICubeMSCondBase.isMemoDirty();
            }
            case 11: {
                return pSSysBICubeMSCondBase.isOrderValueDirty();
            }
            case 12: {
                return pSSysBICubeMSCondBase.isPPSSysBICubeMSCondIdDirty();
            }
            case 13: {
                return pSSysBICubeMSCondBase.isPPSSysBICubeMSCondNameDirty();
            }
            case 14: {
                return pSSysBICubeMSCondBase.isPSDBValueOPIdDirty();
            }
            case 15: {
                return pSSysBICubeMSCondBase.isPSDBValueOPNameDirty();
            }
            case 16: {
                return pSSysBICubeMSCondBase.isPSDEFIdDirty();
            }
            case 17: {
                return pSSysBICubeMSCondBase.isPSDEFNameDirty();
            }
            case 18: {
                return pSSysBICubeMSCondBase.isPSDEIdDirty();
            }
            case 19: {
                return pSSysBICubeMSCondBase.isPSSysBICubeMeasureIdDirty();
            }
            case 20: {
                return pSSysBICubeMSCondBase.isPSSysBICubeMeasureNameDirty();
            }
            case 21: {
                return pSSysBICubeMSCondBase.isPSSysBICubeMSCondIdDirty();
            }
            case 22: {
                return pSSysBICubeMSCondBase.isPSSysBICubeMSCondNameDirty();
            }
            case 23: {
                return pSSysBICubeMSCondBase.isPSSysDBVFIdDirty();
            }
            case 24: {
                return pSSysBICubeMSCondBase.isPSSysDBVFNameDirty();
            }
            case 25: {
                return pSSysBICubeMSCondBase.isPSVarTypeIdDirty();
            }
            case 26: {
                return pSSysBICubeMSCondBase.isPSVARTypeNameDirty();
            }
            case 27: {
                return pSSysBICubeMSCondBase.isUpdateDateDirty();
            }
            case 28: {
                return pSSysBICubeMSCondBase.isUpdateManDirty();
            }
            case 29: {
                return pSSysBICubeMSCondBase.isUserCatDirty();
            }
            case 30: {
                return pSSysBICubeMSCondBase.isUserTagDirty();
            }
            case 31: {
                return pSSysBICubeMSCondBase.isUserTag2Dirty();
            }
            case 32: {
                return pSSysBICubeMSCondBase.isUserTag3Dirty();
            }
            case 33: {
                return pSSysBICubeMSCondBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBICubeMSCondBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBICubeMSCondBase pSSysBICubeMSCondBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBICubeMSCondBase.getCondType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condtype", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getCondType()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getCondValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condvalue", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getCondValue()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getCondValueText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condvaluetext", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getCondValueText()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getCustomType()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getGroupNotFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupnotflag", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getGroupNotFlag()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getGroupOP() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupop", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getGroupOP()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getIgnoreEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreempty", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getIgnoreEmpty()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getPPSSysBICubeMSCondId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysbicubemscondid", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getPPSSysBICubeMSCondId()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getPPSSysBICubeMSCondName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysbicubemscondname", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getPPSSysBICubeMSCondName()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getPSDBValueOPId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopid", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getPSDBValueOPId()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getPSDBValueOPName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopname", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getPSDBValueOPName()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getPSSysBICubeMeasureId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubemeasureid", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getPSSysBICubeMeasureId()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getPSSysBICubeMeasureName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubemeasurename", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getPSSysBICubeMeasureName()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getPSSysBICubeMSCondId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubemscondid", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getPSSysBICubeMSCondId()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getPSSysBICubeMSCondName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubemscondname", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getPSSysBICubeMSCondName()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getPSSysDBVFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvfid", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getPSSysDBVFId()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getPSSysDBVFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvfname", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getPSSysDBVFName()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getPSVarTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvartypeid", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getPSVarTypeId()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getPSVARTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvartypename", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getPSVARTypeName()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBICubeMSCondBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBICubeMSCondBase.getJSONValue((Object)pSSysBICubeMSCondBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBICubeMSCondBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBICubeMSCondBase pSSysBICubeMSCondBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBICubeMSCondBase.getCondType() != null) {
            object = pSSysBICubeMSCondBase.getCondType();
            xmlNode.setAttribute(FIELD_CONDTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBICubeMSCondBase.getCondValue() != null) {
            object = pSSysBICubeMSCondBase.getCondValue();
            xmlNode.setAttribute(FIELD_CONDVALUE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBICubeMSCondBase.getCondValueText() != null) {
            object = pSSysBICubeMSCondBase.getCondValueText();
            xmlNode.setAttribute(FIELD_CONDVALUETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getCreateDate() != null) {
            object = pSSysBICubeMSCondBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBICubeMSCondBase.getCreateMan() != null) {
            object = pSSysBICubeMSCondBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getCustomCond() != null) {
            object = pSSysBICubeMSCondBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getCustomType() != null) {
            object = pSSysBICubeMSCondBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getGroupNotFlag() != null) {
            object = pSSysBICubeMSCondBase.getGroupNotFlag();
            xmlNode.setAttribute(FIELD_GROUPNOTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeMSCondBase.getGroupOP() != null) {
            object = pSSysBICubeMSCondBase.getGroupOP();
            xmlNode.setAttribute(FIELD_GROUPOP, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getIgnoreEmpty() != null) {
            object = pSSysBICubeMSCondBase.getIgnoreEmpty();
            xmlNode.setAttribute(FIELD_IGNOREEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeMSCondBase.getMemo() != null) {
            object = pSSysBICubeMSCondBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getOrderValue() != null) {
            object = pSSysBICubeMSCondBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeMSCondBase.getPPSSysBICubeMSCondId() != null) {
            object = pSSysBICubeMSCondBase.getPPSSysBICubeMSCondId();
            xmlNode.setAttribute(FIELD_PPSSYSBICUBEMSCONDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getPPSSysBICubeMSCondName() != null) {
            object = pSSysBICubeMSCondBase.getPPSSysBICubeMSCondName();
            xmlNode.setAttribute(FIELD_PPSSYSBICUBEMSCONDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getPSDBValueOPId() != null) {
            object = pSSysBICubeMSCondBase.getPSDBValueOPId();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getPSDBValueOPName() != null) {
            object = pSSysBICubeMSCondBase.getPSDBValueOPName();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getPSDEFId() != null) {
            object = pSSysBICubeMSCondBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getPSDEFName() != null) {
            object = pSSysBICubeMSCondBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getPSDEId() != null) {
            object = pSSysBICubeMSCondBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getPSSysBICubeMeasureId() != null) {
            object = pSSysBICubeMSCondBase.getPSSysBICubeMeasureId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEMEASUREID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getPSSysBICubeMeasureName() != null) {
            object = pSSysBICubeMSCondBase.getPSSysBICubeMeasureName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEMEASURENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getPSSysBICubeMSCondId() != null) {
            object = pSSysBICubeMSCondBase.getPSSysBICubeMSCondId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEMSCONDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getPSSysBICubeMSCondName() != null) {
            object = pSSysBICubeMSCondBase.getPSSysBICubeMSCondName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEMSCONDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getPSSysDBVFId() != null) {
            object = pSSysBICubeMSCondBase.getPSSysDBVFId();
            xmlNode.setAttribute(FIELD_PSSYSDBVFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getPSSysDBVFName() != null) {
            object = pSSysBICubeMSCondBase.getPSSysDBVFName();
            xmlNode.setAttribute(FIELD_PSSYSDBVFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getPSVarTypeId() != null) {
            object = pSSysBICubeMSCondBase.getPSVarTypeId();
            xmlNode.setAttribute(FIELD_PSVARTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getPSVARTypeName() != null) {
            object = pSSysBICubeMSCondBase.getPSVARTypeName();
            xmlNode.setAttribute(FIELD_PSVARTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getUpdateDate() != null) {
            object = pSSysBICubeMSCondBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBICubeMSCondBase.getUpdateMan() != null) {
            object = pSSysBICubeMSCondBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getUserCat() != null) {
            object = pSSysBICubeMSCondBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getUserTag() != null) {
            object = pSSysBICubeMSCondBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getUserTag2() != null) {
            object = pSSysBICubeMSCondBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getUserTag3() != null) {
            object = pSSysBICubeMSCondBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMSCondBase.getUserTag4() != null) {
            object = pSSysBICubeMSCondBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBICubeMSCondBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBICubeMSCondBase pSSysBICubeMSCondBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBICubeMSCondBase.isCondTypeDirty() && (bl || pSSysBICubeMSCondBase.getCondType() != null)) {
            iDataObject.set(FIELD_CONDTYPE, (Object)pSSysBICubeMSCondBase.getCondType());
        }
        if (pSSysBICubeMSCondBase.isCondValueDirty() && (bl || pSSysBICubeMSCondBase.getCondValue() != null)) {
            iDataObject.set(FIELD_CONDVALUE, (Object)pSSysBICubeMSCondBase.getCondValue());
        }
        if (pSSysBICubeMSCondBase.isCondValueTextDirty() && (bl || pSSysBICubeMSCondBase.getCondValueText() != null)) {
            iDataObject.set(FIELD_CONDVALUETEXT, (Object)pSSysBICubeMSCondBase.getCondValueText());
        }
        if (pSSysBICubeMSCondBase.isCreateDateDirty() && (bl || pSSysBICubeMSCondBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBICubeMSCondBase.getCreateDate());
        }
        if (pSSysBICubeMSCondBase.isCreateManDirty() && (bl || pSSysBICubeMSCondBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBICubeMSCondBase.getCreateMan());
        }
        if (pSSysBICubeMSCondBase.isCustomCondDirty() && (bl || pSSysBICubeMSCondBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSSysBICubeMSCondBase.getCustomCond());
        }
        if (pSSysBICubeMSCondBase.isCustomTypeDirty() && (bl || pSSysBICubeMSCondBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSSysBICubeMSCondBase.getCustomType());
        }
        if (pSSysBICubeMSCondBase.isGroupNotFlagDirty() && (bl || pSSysBICubeMSCondBase.getGroupNotFlag() != null)) {
            iDataObject.set(FIELD_GROUPNOTFLAG, (Object)pSSysBICubeMSCondBase.getGroupNotFlag());
        }
        if (pSSysBICubeMSCondBase.isGroupOPDirty() && (bl || pSSysBICubeMSCondBase.getGroupOP() != null)) {
            iDataObject.set(FIELD_GROUPOP, (Object)pSSysBICubeMSCondBase.getGroupOP());
        }
        if (pSSysBICubeMSCondBase.isIgnoreEmptyDirty() && (bl || pSSysBICubeMSCondBase.getIgnoreEmpty() != null)) {
            iDataObject.set(FIELD_IGNOREEMPTY, (Object)pSSysBICubeMSCondBase.getIgnoreEmpty());
        }
        if (pSSysBICubeMSCondBase.isMemoDirty() && (bl || pSSysBICubeMSCondBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBICubeMSCondBase.getMemo());
        }
        if (pSSysBICubeMSCondBase.isOrderValueDirty() && (bl || pSSysBICubeMSCondBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysBICubeMSCondBase.getOrderValue());
        }
        if (pSSysBICubeMSCondBase.isPPSSysBICubeMSCondIdDirty() && (bl || pSSysBICubeMSCondBase.getPPSSysBICubeMSCondId() != null)) {
            iDataObject.set(FIELD_PPSSYSBICUBEMSCONDID, (Object)pSSysBICubeMSCondBase.getPPSSysBICubeMSCondId());
        }
        if (pSSysBICubeMSCondBase.isPPSSysBICubeMSCondNameDirty() && (bl || pSSysBICubeMSCondBase.getPPSSysBICubeMSCondName() != null)) {
            iDataObject.set(FIELD_PPSSYSBICUBEMSCONDNAME, (Object)pSSysBICubeMSCondBase.getPPSSysBICubeMSCondName());
        }
        if (pSSysBICubeMSCondBase.isPSDBValueOPIdDirty() && (bl || pSSysBICubeMSCondBase.getPSDBValueOPId() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPID, (Object)pSSysBICubeMSCondBase.getPSDBValueOPId());
        }
        if (pSSysBICubeMSCondBase.isPSDBValueOPNameDirty() && (bl || pSSysBICubeMSCondBase.getPSDBValueOPName() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPNAME, (Object)pSSysBICubeMSCondBase.getPSDBValueOPName());
        }
        if (pSSysBICubeMSCondBase.isPSDEFIdDirty() && (bl || pSSysBICubeMSCondBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSSysBICubeMSCondBase.getPSDEFId());
        }
        if (pSSysBICubeMSCondBase.isPSDEFNameDirty() && (bl || pSSysBICubeMSCondBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSSysBICubeMSCondBase.getPSDEFName());
        }
        if (pSSysBICubeMSCondBase.isPSDEIdDirty() && (bl || pSSysBICubeMSCondBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysBICubeMSCondBase.getPSDEId());
        }
        if (pSSysBICubeMSCondBase.isPSSysBICubeMeasureIdDirty() && (bl || pSSysBICubeMSCondBase.getPSSysBICubeMeasureId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEMEASUREID, (Object)pSSysBICubeMSCondBase.getPSSysBICubeMeasureId());
        }
        if (pSSysBICubeMSCondBase.isPSSysBICubeMeasureNameDirty() && (bl || pSSysBICubeMSCondBase.getPSSysBICubeMeasureName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEMEASURENAME, (Object)pSSysBICubeMSCondBase.getPSSysBICubeMeasureName());
        }
        if (pSSysBICubeMSCondBase.isPSSysBICubeMSCondIdDirty() && (bl || pSSysBICubeMSCondBase.getPSSysBICubeMSCondId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEMSCONDID, (Object)pSSysBICubeMSCondBase.getPSSysBICubeMSCondId());
        }
        if (pSSysBICubeMSCondBase.isPSSysBICubeMSCondNameDirty() && (bl || pSSysBICubeMSCondBase.getPSSysBICubeMSCondName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEMSCONDNAME, (Object)pSSysBICubeMSCondBase.getPSSysBICubeMSCondName());
        }
        if (pSSysBICubeMSCondBase.isPSSysDBVFIdDirty() && (bl || pSSysBICubeMSCondBase.getPSSysDBVFId() != null)) {
            iDataObject.set(FIELD_PSSYSDBVFID, (Object)pSSysBICubeMSCondBase.getPSSysDBVFId());
        }
        if (pSSysBICubeMSCondBase.isPSSysDBVFNameDirty() && (bl || pSSysBICubeMSCondBase.getPSSysDBVFName() != null)) {
            iDataObject.set(FIELD_PSSYSDBVFNAME, (Object)pSSysBICubeMSCondBase.getPSSysDBVFName());
        }
        if (pSSysBICubeMSCondBase.isPSVarTypeIdDirty() && (bl || pSSysBICubeMSCondBase.getPSVarTypeId() != null)) {
            iDataObject.set(FIELD_PSVARTYPEID, (Object)pSSysBICubeMSCondBase.getPSVarTypeId());
        }
        if (pSSysBICubeMSCondBase.isPSVARTypeNameDirty() && (bl || pSSysBICubeMSCondBase.getPSVARTypeName() != null)) {
            iDataObject.set(FIELD_PSVARTYPENAME, (Object)pSSysBICubeMSCondBase.getPSVARTypeName());
        }
        if (pSSysBICubeMSCondBase.isUpdateDateDirty() && (bl || pSSysBICubeMSCondBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBICubeMSCondBase.getUpdateDate());
        }
        if (pSSysBICubeMSCondBase.isUpdateManDirty() && (bl || pSSysBICubeMSCondBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBICubeMSCondBase.getUpdateMan());
        }
        if (pSSysBICubeMSCondBase.isUserCatDirty() && (bl || pSSysBICubeMSCondBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBICubeMSCondBase.getUserCat());
        }
        if (pSSysBICubeMSCondBase.isUserTagDirty() && (bl || pSSysBICubeMSCondBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBICubeMSCondBase.getUserTag());
        }
        if (pSSysBICubeMSCondBase.isUserTag2Dirty() && (bl || pSSysBICubeMSCondBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBICubeMSCondBase.getUserTag2());
        }
        if (pSSysBICubeMSCondBase.isUserTag3Dirty() && (bl || pSSysBICubeMSCondBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBICubeMSCondBase.getUserTag3());
        }
        if (pSSysBICubeMSCondBase.isUserTag4Dirty() && (bl || pSSysBICubeMSCondBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBICubeMSCondBase.getUserTag4());
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
        return PSSysBICubeMSCondBase.remove(this, n);
    }

    private static boolean remove(PSSysBICubeMSCondBase pSSysBICubeMSCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBICubeMSCondBase.resetCondType();
                return true;
            }
            case 1: {
                pSSysBICubeMSCondBase.resetCondValue();
                return true;
            }
            case 2: {
                pSSysBICubeMSCondBase.resetCondValueText();
                return true;
            }
            case 3: {
                pSSysBICubeMSCondBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSysBICubeMSCondBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSysBICubeMSCondBase.resetCustomCond();
                return true;
            }
            case 6: {
                pSSysBICubeMSCondBase.resetCustomType();
                return true;
            }
            case 7: {
                pSSysBICubeMSCondBase.resetGroupNotFlag();
                return true;
            }
            case 8: {
                pSSysBICubeMSCondBase.resetGroupOP();
                return true;
            }
            case 9: {
                pSSysBICubeMSCondBase.resetIgnoreEmpty();
                return true;
            }
            case 10: {
                pSSysBICubeMSCondBase.resetMemo();
                return true;
            }
            case 11: {
                pSSysBICubeMSCondBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSSysBICubeMSCondBase.resetPPSSysBICubeMSCondId();
                return true;
            }
            case 13: {
                pSSysBICubeMSCondBase.resetPPSSysBICubeMSCondName();
                return true;
            }
            case 14: {
                pSSysBICubeMSCondBase.resetPSDBValueOPId();
                return true;
            }
            case 15: {
                pSSysBICubeMSCondBase.resetPSDBValueOPName();
                return true;
            }
            case 16: {
                pSSysBICubeMSCondBase.resetPSDEFId();
                return true;
            }
            case 17: {
                pSSysBICubeMSCondBase.resetPSDEFName();
                return true;
            }
            case 18: {
                pSSysBICubeMSCondBase.resetPSDEId();
                return true;
            }
            case 19: {
                pSSysBICubeMSCondBase.resetPSSysBICubeMeasureId();
                return true;
            }
            case 20: {
                pSSysBICubeMSCondBase.resetPSSysBICubeMeasureName();
                return true;
            }
            case 21: {
                pSSysBICubeMSCondBase.resetPSSysBICubeMSCondId();
                return true;
            }
            case 22: {
                pSSysBICubeMSCondBase.resetPSSysBICubeMSCondName();
                return true;
            }
            case 23: {
                pSSysBICubeMSCondBase.resetPSSysDBVFId();
                return true;
            }
            case 24: {
                pSSysBICubeMSCondBase.resetPSSysDBVFName();
                return true;
            }
            case 25: {
                pSSysBICubeMSCondBase.resetPSVarTypeId();
                return true;
            }
            case 26: {
                pSSysBICubeMSCondBase.resetPSVARTypeName();
                return true;
            }
            case 27: {
                pSSysBICubeMSCondBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSSysBICubeMSCondBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSSysBICubeMSCondBase.resetUserCat();
                return true;
            }
            case 30: {
                pSSysBICubeMSCondBase.resetUserTag();
                return true;
            }
            case 31: {
                pSSysBICubeMSCondBase.resetUserTag2();
                return true;
            }
            case 32: {
                pSSysBICubeMSCondBase.resetUserTag3();
                return true;
            }
            case 33: {
                pSSysBICubeMSCondBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBValueOP getPSDBValueOP() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOP();
        }
        if (this.getPSDBValueOPId() == null) {
            return null;
        }
        Integer n = this.objPSDBValueOPLock;
        synchronized (n) {
            if (this.psdbvalueop != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBValueOPId(), (Object)this.psdbvalueop.getPSDBValueOPId()) != 0L) {
                this.psdbvalueop = null;
            }
            if (this.psdbvalueop == null) {
                PSDBValueOP pSDBValueOP = new PSDBValueOP();
                pSDBValueOP.setPSDBValueOPId(this.getPSDBValueOPId());
                PSDBValueOPService pSDBValueOPService = (PSDBValueOPService)ServiceGlobal.getService(PSDBValueOPService.class, (SessionFactory)this.getSessionFactory());
                pSDBValueOPService.autoGet(pSDBValueOP);
                this.psdbvalueop = pSDBValueOP;
            }
            return this.psdbvalueop;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBICubeMeasure getPSSysBICubeMeasure() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeMeasure();
        }
        if (this.getPSSysBICubeMeasureId() == null) {
            return null;
        }
        Integer n = this.objPSSysBICubeMeasureLock;
        synchronized (n) {
            if (this.pssysbicubemeasure != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBICubeMeasureId(), (Object)this.pssysbicubemeasure.getPSSysBICubeMeasureId()) != 0L) {
                this.pssysbicubemeasure = null;
            }
            if (this.pssysbicubemeasure == null) {
                PSSysBICubeMeasure pSSysBICubeMeasure = new PSSysBICubeMeasure();
                pSSysBICubeMeasure.setPSSysBICubeMeasureId(this.getPSSysBICubeMeasureId());
                PSSysBICubeMeasureService pSSysBICubeMeasureService = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
                pSSysBICubeMeasureService.autoGet(pSSysBICubeMeasure);
                this.pssysbicubemeasure = pSSysBICubeMeasure;
            }
            return this.pssysbicubemeasure;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBICubeMSCond getPPSSysBICubeMSCond() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysBICubeMSCond();
        }
        if (this.getPPSSysBICubeMSCondId() == null) {
            return null;
        }
        Integer n = this.objPPSSysBICubeMSCondLock;
        synchronized (n) {
            if (this.ppssysbicubemscond != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysBICubeMSCondId(), (Object)this.ppssysbicubemscond.getPSSysBICubeMSCondId()) != 0L) {
                this.ppssysbicubemscond = null;
            }
            if (this.ppssysbicubemscond == null) {
                PSSysBICubeMSCond pSSysBICubeMSCond = new PSSysBICubeMSCond();
                pSSysBICubeMSCond.setPSSysBICubeMSCondId(this.getPPSSysBICubeMSCondId());
                PSSysBICubeMSCondService pSSysBICubeMSCondService = (PSSysBICubeMSCondService)ServiceGlobal.getService(PSSysBICubeMSCondService.class, (SessionFactory)this.getSessionFactory());
                pSSysBICubeMSCondService.autoGet(pSSysBICubeMSCond);
                this.ppssysbicubemscond = pSSysBICubeMSCond;
            }
            return this.ppssysbicubemscond;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBVF getPSSysDBVF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVF();
        }
        if (this.getPSSysDBVFId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBVFLock;
        synchronized (n) {
            if (this.pssysdbvf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBVFId(), (Object)this.pssysdbvf.getPSSysDBVFId()) != 0L) {
                this.pssysdbvf = null;
            }
            if (this.pssysdbvf == null) {
                PSSysDBVF pSSysDBVF = new PSSysDBVF();
                pSSysDBVF.setPSSysDBVFId(this.getPSSysDBVFId());
                PSSysDBVFService pSSysDBVFService = (PSSysDBVFService)ServiceGlobal.getService(PSSysDBVFService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBVFService.autoGet(pSSysDBVF);
                this.pssysdbvf = pSSysDBVF;
            }
            return this.pssysdbvf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSVarType getPSVarType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVarType();
        }
        if (this.getPSVarTypeId() == null) {
            return null;
        }
        Integer n = this.objPSVarTypeLock;
        synchronized (n) {
            if (this.psvartype != null && DataTypeHelper.compare((int)25, (Object)this.getPSVarTypeId(), (Object)this.psvartype.getPSVarTypeId()) != 0L) {
                this.psvartype = null;
            }
            if (this.psvartype == null) {
                PSVarType pSVarType = new PSVarType();
                pSVarType.setPSVarTypeId(this.getPSVarTypeId());
                PSVarTypeService pSVarTypeService = (PSVarTypeService)ServiceGlobal.getService(PSVarTypeService.class, (SessionFactory)this.getSessionFactory());
                pSVarTypeService.autoGet(pSVarType);
                this.psvartype = pSVarType;
            }
            return this.psvartype;
        }
    }

    private PSSysBICubeMSCondBase getProxyEntity() {
        return this.proxyPSSysBICubeMSCondBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBICubeMSCondBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBICubeMSCondBase) {
            this.proxyPSSysBICubeMSCondBase = (PSSysBICubeMSCondBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSCondService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONDTYPE, 0);
        fieldIndexMap.put(FIELD_CONDVALUE, 1);
        fieldIndexMap.put(FIELD_CONDVALUETEXT, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 5);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 6);
        fieldIndexMap.put(FIELD_GROUPNOTFLAG, 7);
        fieldIndexMap.put(FIELD_GROUPOP, 8);
        fieldIndexMap.put(FIELD_IGNOREEMPTY, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_ORDERVALUE, 11);
        fieldIndexMap.put(FIELD_PPSSYSBICUBEMSCONDID, 12);
        fieldIndexMap.put(FIELD_PPSSYSBICUBEMSCONDNAME, 13);
        fieldIndexMap.put(FIELD_PSDBVALUEOPID, 14);
        fieldIndexMap.put(FIELD_PSDBVALUEOPNAME, 15);
        fieldIndexMap.put(FIELD_PSDEFID, 16);
        fieldIndexMap.put(FIELD_PSDEFNAME, 17);
        fieldIndexMap.put(FIELD_PSDEID, 18);
        fieldIndexMap.put(FIELD_PSSYSBICUBEMEASUREID, 19);
        fieldIndexMap.put(FIELD_PSSYSBICUBEMEASURENAME, 20);
        fieldIndexMap.put(FIELD_PSSYSBICUBEMSCONDID, 21);
        fieldIndexMap.put(FIELD_PSSYSBICUBEMSCONDNAME, 22);
        fieldIndexMap.put(FIELD_PSSYSDBVFID, 23);
        fieldIndexMap.put(FIELD_PSSYSDBVFNAME, 24);
        fieldIndexMap.put(FIELD_PSVARTYPEID, 25);
        fieldIndexMap.put(FIELD_PSVARTYPENAME, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_USERCAT, 29);
        fieldIndexMap.put(FIELD_USERTAG, 30);
        fieldIndexMap.put(FIELD_USERTAG2, 31);
        fieldIndexMap.put(FIELD_USERTAG3, 32);
        fieldIndexMap.put(FIELD_USERTAG4, 33);
    }
}

