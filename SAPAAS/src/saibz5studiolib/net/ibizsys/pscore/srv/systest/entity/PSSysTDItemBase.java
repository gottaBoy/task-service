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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSampleValue;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSampleValueService;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTDItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysTDItemBase.class);
    public static final String FIELD_BADVALUE = "BADVALUE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSSAMPLEVALUEID = "PSSYSSAMPLEVALUEID";
    public static final String FIELD_PSSYSSAMPLEVALUENAME = "PSSYSSAMPLEVALUENAME";
    public static final String FIELD_PSSYSTDITEMID = "PSSYSTDITEMID";
    public static final String FIELD_PSSYSTDITEMNAME = "PSSYSTDITEMNAME";
    public static final String FIELD_PSSYSTESTDATAID = "PSSYSTESTDATAID";
    public static final String FIELD_PSSYSTESTDATANAME = "PSSYSTESTDATANAME";
    public static final String FIELD_REFPSDEDATASETID = "REFPSDEDATASETID";
    public static final String FIELD_REFPSDEDATASETNAME = "REFPSDEDATASETNAME";
    public static final String FIELD_REFPSDEID = "REFPSDEID";
    public static final String FIELD_REFPSDENAME = "REFPSDENAME";
    public static final String FIELD_REFPSSYSTESTDATAID = "REFPSSYSTESTDATAID";
    public static final String FIELD_REFPSSYSTESTDATANAME = "REFPSSYSTESTDATANAME";
    public static final String FIELD_STDDATATYPE = "STDDATATYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUE = "VALUE";
    public static final String FIELD_VALUERANGE = "VALUERANGE";
    public static final String FIELD_VALUETYPE = "VALUETYPE";
    private static final int INDEX_BADVALUE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PSCODELISTID = 5;
    private static final int INDEX_PSCODELISTNAME = 6;
    private static final int INDEX_PSDEFID = 7;
    private static final int INDEX_PSDEFNAME = 8;
    private static final int INDEX_PSDEID = 9;
    private static final int INDEX_PSSYSSAMPLEVALUEID = 10;
    private static final int INDEX_PSSYSSAMPLEVALUENAME = 11;
    private static final int INDEX_PSSYSTDITEMID = 12;
    private static final int INDEX_PSSYSTDITEMNAME = 13;
    private static final int INDEX_PSSYSTESTDATAID = 14;
    private static final int INDEX_PSSYSTESTDATANAME = 15;
    private static final int INDEX_REFPSDEDATASETID = 16;
    private static final int INDEX_REFPSDEDATASETNAME = 17;
    private static final int INDEX_REFPSDEID = 18;
    private static final int INDEX_REFPSDENAME = 19;
    private static final int INDEX_REFPSSYSTESTDATAID = 20;
    private static final int INDEX_REFPSSYSTESTDATANAME = 21;
    private static final int INDEX_STDDATATYPE = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_USERCAT = 25;
    private static final int INDEX_USERTAG = 26;
    private static final int INDEX_USERTAG2 = 27;
    private static final int INDEX_USERTAG3 = 28;
    private static final int INDEX_USERTAG4 = 29;
    private static final int INDEX_VALIDFLAG = 30;
    private static final int INDEX_VALUE = 31;
    private static final int INDEX_VALUERANGE = 32;
    private static final int INDEX_VALUETYPE = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysTDItemBase proxyPSSysTDItemBase = null;
    private boolean badvalueDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssyssamplevalueidDirtyFlag = false;
    private boolean pssyssamplevaluenameDirtyFlag = false;
    private boolean pssystditemidDirtyFlag = false;
    private boolean pssystditemnameDirtyFlag = false;
    private boolean pssystestdataidDirtyFlag = false;
    private boolean pssystestdatanameDirtyFlag = false;
    private boolean refpsdedatasetidDirtyFlag = false;
    private boolean refpsdedatasetnameDirtyFlag = false;
    private boolean refpsdeidDirtyFlag = false;
    private boolean refpsdenameDirtyFlag = false;
    private boolean refpssystestdataidDirtyFlag = false;
    private boolean refpssystestdatanameDirtyFlag = false;
    private boolean stddatatypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valueDirtyFlag = false;
    private boolean valuerangeDirtyFlag = false;
    private boolean valuetypeDirtyFlag = false;
    @Column(name="badvalue")
    private String badvalue;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssyssamplevalueid")
    private String pssyssamplevalueid;
    @Column(name="pssyssamplevaluename")
    private String pssyssamplevaluename;
    @Column(name="pssystditemid")
    private String pssystditemid;
    @Column(name="pssystditemname")
    private String pssystditemname;
    @Column(name="pssystestdataid")
    private String pssystestdataid;
    @Column(name="pssystestdataname")
    private String pssystestdataname;
    @Column(name="refpsdedatasetid")
    private String refpsdedatasetid;
    @Column(name="refpsdedatasetname")
    private String refpsdedatasetname;
    @Column(name="refpsdeid")
    private String refpsdeid;
    @Column(name="refpsdename")
    private String refpsdename;
    @Column(name="refpssystestdataid")
    private String refpssystestdataid;
    @Column(name="refpssystestdataname")
    private String refpssystestdataname;
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
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="value")
    private String value;
    @Column(name="valuerange")
    private String valuerange;
    @Column(name="valuetype")
    private String valuetype;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objRefPSDELock = new Integer(1);
    private PSDataEntity refpsde = null;
    private Integer objRefPSDEDataSetLock = new Integer(1);
    private PSDEDataSet refpsdedataset = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSSysSampleValueLock = new Integer(1);
    private PSSysSampleValue pssyssamplevalue = null;
    private Integer objPSSysTestDataLock = new Integer(1);
    private PSSysTestData pssystestdata = null;
    private Integer objRefPSSysTestDataLock = new Integer(1);
    private PSSysTestData refpssystestdata = null;

    public void setBadValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBadValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.badvalue = string;
        this.badvalueDirtyFlag = true;
    }

    public String getBadValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBadValue();
        }
        return this.badvalue;
    }

    public boolean isBadValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBadValueDirty();
        }
        return this.badvalueDirtyFlag;
    }

    public void resetBadValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBadValue();
            return;
        }
        this.badvalueDirtyFlag = false;
        this.badvalue = null;
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

    public void setPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistid = string;
        this.pscodelistidDirtyFlag = true;
    }

    public String getPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListId();
        }
        return this.pscodelistid;
    }

    public boolean isPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListIdDirty();
        }
        return this.pscodelistidDirtyFlag;
    }

    public void resetPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListId();
            return;
        }
        this.pscodelistidDirtyFlag = false;
        this.pscodelistid = null;
    }

    public void setPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistname = string;
        this.pscodelistnameDirtyFlag = true;
    }

    public String getPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListName();
        }
        return this.pscodelistname;
    }

    public boolean isPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListNameDirty();
        }
        return this.pscodelistnameDirtyFlag;
    }

    public void resetPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListName();
            return;
        }
        this.pscodelistnameDirtyFlag = false;
        this.pscodelistname = null;
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

    public void setPSSysSampleValueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSampleValueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssamplevalueid = string;
        this.pssyssamplevalueidDirtyFlag = true;
    }

    public String getPSSysSampleValueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSampleValueId();
        }
        return this.pssyssamplevalueid;
    }

    public boolean isPSSysSampleValueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSampleValueIdDirty();
        }
        return this.pssyssamplevalueidDirtyFlag;
    }

    public void resetPSSysSampleValueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSampleValueId();
            return;
        }
        this.pssyssamplevalueidDirtyFlag = false;
        this.pssyssamplevalueid = null;
    }

    public void setPSSysSampleValueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSampleValueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssamplevaluename = string;
        this.pssyssamplevaluenameDirtyFlag = true;
    }

    public String getPSSysSampleValueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSampleValueName();
        }
        return this.pssyssamplevaluename;
    }

    public boolean isPSSysSampleValueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSampleValueNameDirty();
        }
        return this.pssyssamplevaluenameDirtyFlag;
    }

    public void resetPSSysSampleValueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSampleValueName();
            return;
        }
        this.pssyssamplevaluenameDirtyFlag = false;
        this.pssyssamplevaluename = null;
    }

    public void setPSSysTDItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTDItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystditemid = string;
        this.pssystditemidDirtyFlag = true;
    }

    public String getPSSysTDItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTDItemId();
        }
        return this.pssystditemid;
    }

    public boolean isPSSysTDItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTDItemIdDirty();
        }
        return this.pssystditemidDirtyFlag;
    }

    public void resetPSSysTDItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTDItemId();
            return;
        }
        this.pssystditemidDirtyFlag = false;
        this.pssystditemid = null;
    }

    public void setPSSysTDItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTDItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystditemname = string;
        this.pssystditemnameDirtyFlag = true;
    }

    public String getPSSysTDItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTDItemName();
        }
        return this.pssystditemname;
    }

    public boolean isPSSysTDItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTDItemNameDirty();
        }
        return this.pssystditemnameDirtyFlag;
    }

    public void resetPSSysTDItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTDItemName();
            return;
        }
        this.pssystditemnameDirtyFlag = false;
        this.pssystditemname = null;
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

    public void setRefPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdedatasetid = string;
        this.refpsdedatasetidDirtyFlag = true;
    }

    public String getRefPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEDataSetId();
        }
        return this.refpsdedatasetid;
    }

    public boolean isRefPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEDataSetIdDirty();
        }
        return this.refpsdedatasetidDirtyFlag;
    }

    public void resetRefPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEDataSetId();
            return;
        }
        this.refpsdedatasetidDirtyFlag = false;
        this.refpsdedatasetid = null;
    }

    public void setRefPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdedatasetname = string;
        this.refpsdedatasetnameDirtyFlag = true;
    }

    public String getRefPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEDataSetName();
        }
        return this.refpsdedatasetname;
    }

    public boolean isRefPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEDataSetNameDirty();
        }
        return this.refpsdedatasetnameDirtyFlag;
    }

    public void resetRefPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEDataSetName();
            return;
        }
        this.refpsdedatasetnameDirtyFlag = false;
        this.refpsdedatasetname = null;
    }

    public void setRefPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdeid = string;
        this.refpsdeidDirtyFlag = true;
    }

    public String getRefPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEId();
        }
        return this.refpsdeid;
    }

    public boolean isRefPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEIdDirty();
        }
        return this.refpsdeidDirtyFlag;
    }

    public void resetRefPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEId();
            return;
        }
        this.refpsdeidDirtyFlag = false;
        this.refpsdeid = null;
    }

    public void setRefPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdename = string;
        this.refpsdenameDirtyFlag = true;
    }

    public String getRefPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEName();
        }
        return this.refpsdename;
    }

    public boolean isRefPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDENameDirty();
        }
        return this.refpsdenameDirtyFlag;
    }

    public void resetRefPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEName();
            return;
        }
        this.refpsdenameDirtyFlag = false;
        this.refpsdename = null;
    }

    public void setRefPSSysTestDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysTestDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssystestdataid = string;
        this.refpssystestdataidDirtyFlag = true;
    }

    public String getRefPSSysTestDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysTestDataId();
        }
        return this.refpssystestdataid;
    }

    public boolean isRefPSSysTestDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysTestDataIdDirty();
        }
        return this.refpssystestdataidDirtyFlag;
    }

    public void resetRefPSSysTestDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysTestDataId();
            return;
        }
        this.refpssystestdataidDirtyFlag = false;
        this.refpssystestdataid = null;
    }

    public void setRefPSSysTestDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysTestDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssystestdataname = string;
        this.refpssystestdatanameDirtyFlag = true;
    }

    public String getRefPSSysTestDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysTestDataName();
        }
        return this.refpssystestdataname;
    }

    public boolean isRefPSSysTestDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysTestDataNameDirty();
        }
        return this.refpssystestdatanameDirtyFlag;
    }

    public void resetRefPSSysTestDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysTestDataName();
            return;
        }
        this.refpssystestdatanameDirtyFlag = false;
        this.refpssystestdataname = null;
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

    public void setValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.value = string;
        this.valueDirtyFlag = true;
    }

    public String getValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValue();
        }
        return this.value;
    }

    public boolean isValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueDirty();
        }
        return this.valueDirtyFlag;
    }

    public void resetValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValue();
            return;
        }
        this.valueDirtyFlag = false;
        this.value = null;
    }

    public void setValueRange(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueRange(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuerange = string;
        this.valuerangeDirtyFlag = true;
    }

    public String getValueRange() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueRange();
        }
        return this.valuerange;
    }

    public boolean isValueRangeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueRangeDirty();
        }
        return this.valuerangeDirtyFlag;
    }

    public void resetValueRange() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueRange();
            return;
        }
        this.valuerangeDirtyFlag = false;
        this.valuerange = null;
    }

    public void setValueType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuetype = string;
        this.valuetypeDirtyFlag = true;
    }

    public String getValueType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueType();
        }
        return this.valuetype;
    }

    public boolean isValueTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueTypeDirty();
        }
        return this.valuetypeDirtyFlag;
    }

    public void resetValueType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueType();
            return;
        }
        this.valuetypeDirtyFlag = false;
        this.valuetype = null;
    }

    protected void onReset() {
        PSSysTDItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysTDItemBase pSSysTDItemBase) {
        pSSysTDItemBase.resetBadValue();
        pSSysTDItemBase.resetCreateDate();
        pSSysTDItemBase.resetCreateMan();
        pSSysTDItemBase.resetMemo();
        pSSysTDItemBase.resetOrderValue();
        pSSysTDItemBase.resetPSCodeListId();
        pSSysTDItemBase.resetPSCodeListName();
        pSSysTDItemBase.resetPSDEFId();
        pSSysTDItemBase.resetPSDEFName();
        pSSysTDItemBase.resetPSDEId();
        pSSysTDItemBase.resetPSSysSampleValueId();
        pSSysTDItemBase.resetPSSysSampleValueName();
        pSSysTDItemBase.resetPSSysTDItemId();
        pSSysTDItemBase.resetPSSysTDItemName();
        pSSysTDItemBase.resetPSSysTestDataId();
        pSSysTDItemBase.resetPSSysTestDataName();
        pSSysTDItemBase.resetRefPSDEDataSetId();
        pSSysTDItemBase.resetRefPSDEDataSetName();
        pSSysTDItemBase.resetRefPSDEId();
        pSSysTDItemBase.resetRefPSDEName();
        pSSysTDItemBase.resetRefPSSysTestDataId();
        pSSysTDItemBase.resetRefPSSysTestDataName();
        pSSysTDItemBase.resetStdDataType();
        pSSysTDItemBase.resetUpdateDate();
        pSSysTDItemBase.resetUpdateMan();
        pSSysTDItemBase.resetUserCat();
        pSSysTDItemBase.resetUserTag();
        pSSysTDItemBase.resetUserTag2();
        pSSysTDItemBase.resetUserTag3();
        pSSysTDItemBase.resetUserTag4();
        pSSysTDItemBase.resetValidFlag();
        pSSysTDItemBase.resetValue();
        pSSysTDItemBase.resetValueRange();
        pSSysTDItemBase.resetValueType();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBadValueDirty()) {
            hashMap.put(FIELD_BADVALUE, this.getBadValue());
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
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
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
        if (!bl || this.isPSSysSampleValueIdDirty()) {
            hashMap.put(FIELD_PSSYSSAMPLEVALUEID, this.getPSSysSampleValueId());
        }
        if (!bl || this.isPSSysSampleValueNameDirty()) {
            hashMap.put(FIELD_PSSYSSAMPLEVALUENAME, this.getPSSysSampleValueName());
        }
        if (!bl || this.isPSSysTDItemIdDirty()) {
            hashMap.put(FIELD_PSSYSTDITEMID, this.getPSSysTDItemId());
        }
        if (!bl || this.isPSSysTDItemNameDirty()) {
            hashMap.put(FIELD_PSSYSTDITEMNAME, this.getPSSysTDItemName());
        }
        if (!bl || this.isPSSysTestDataIdDirty()) {
            hashMap.put(FIELD_PSSYSTESTDATAID, this.getPSSysTestDataId());
        }
        if (!bl || this.isPSSysTestDataNameDirty()) {
            hashMap.put(FIELD_PSSYSTESTDATANAME, this.getPSSysTestDataName());
        }
        if (!bl || this.isRefPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_REFPSDEDATASETID, this.getRefPSDEDataSetId());
        }
        if (!bl || this.isRefPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_REFPSDEDATASETNAME, this.getRefPSDEDataSetName());
        }
        if (!bl || this.isRefPSDEIdDirty()) {
            hashMap.put(FIELD_REFPSDEID, this.getRefPSDEId());
        }
        if (!bl || this.isRefPSDENameDirty()) {
            hashMap.put(FIELD_REFPSDENAME, this.getRefPSDEName());
        }
        if (!bl || this.isRefPSSysTestDataIdDirty()) {
            hashMap.put(FIELD_REFPSSYSTESTDATAID, this.getRefPSSysTestDataId());
        }
        if (!bl || this.isRefPSSysTestDataNameDirty()) {
            hashMap.put(FIELD_REFPSSYSTESTDATANAME, this.getRefPSSysTestDataName());
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
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isValueDirty()) {
            hashMap.put(FIELD_VALUE, this.getValue());
        }
        if (!bl || this.isValueRangeDirty()) {
            hashMap.put(FIELD_VALUERANGE, this.getValueRange());
        }
        if (!bl || this.isValueTypeDirty()) {
            hashMap.put(FIELD_VALUETYPE, this.getValueType());
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
        return PSSysTDItemBase.get(this, n);
    }

    private static Object get(PSSysTDItemBase pSSysTDItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTDItemBase.getBadValue();
            }
            case 1: {
                return pSSysTDItemBase.getCreateDate();
            }
            case 2: {
                return pSSysTDItemBase.getCreateMan();
            }
            case 3: {
                return pSSysTDItemBase.getMemo();
            }
            case 4: {
                return pSSysTDItemBase.getOrderValue();
            }
            case 5: {
                return pSSysTDItemBase.getPSCodeListId();
            }
            case 6: {
                return pSSysTDItemBase.getPSCodeListName();
            }
            case 7: {
                return pSSysTDItemBase.getPSDEFId();
            }
            case 8: {
                return pSSysTDItemBase.getPSDEFName();
            }
            case 9: {
                return pSSysTDItemBase.getPSDEId();
            }
            case 10: {
                return pSSysTDItemBase.getPSSysSampleValueId();
            }
            case 11: {
                return pSSysTDItemBase.getPSSysSampleValueName();
            }
            case 12: {
                return pSSysTDItemBase.getPSSysTDItemId();
            }
            case 13: {
                return pSSysTDItemBase.getPSSysTDItemName();
            }
            case 14: {
                return pSSysTDItemBase.getPSSysTestDataId();
            }
            case 15: {
                return pSSysTDItemBase.getPSSysTestDataName();
            }
            case 16: {
                return pSSysTDItemBase.getRefPSDEDataSetId();
            }
            case 17: {
                return pSSysTDItemBase.getRefPSDEDataSetName();
            }
            case 18: {
                return pSSysTDItemBase.getRefPSDEId();
            }
            case 19: {
                return pSSysTDItemBase.getRefPSDEName();
            }
            case 20: {
                return pSSysTDItemBase.getRefPSSysTestDataId();
            }
            case 21: {
                return pSSysTDItemBase.getRefPSSysTestDataName();
            }
            case 22: {
                return pSSysTDItemBase.getStdDataType();
            }
            case 23: {
                return pSSysTDItemBase.getUpdateDate();
            }
            case 24: {
                return pSSysTDItemBase.getUpdateMan();
            }
            case 25: {
                return pSSysTDItemBase.getUserCat();
            }
            case 26: {
                return pSSysTDItemBase.getUserTag();
            }
            case 27: {
                return pSSysTDItemBase.getUserTag2();
            }
            case 28: {
                return pSSysTDItemBase.getUserTag3();
            }
            case 29: {
                return pSSysTDItemBase.getUserTag4();
            }
            case 30: {
                return pSSysTDItemBase.getValidFlag();
            }
            case 31: {
                return pSSysTDItemBase.getValue();
            }
            case 32: {
                return pSSysTDItemBase.getValueRange();
            }
            case 33: {
                return pSSysTDItemBase.getValueType();
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
        PSSysTDItemBase.set(this, n, object);
    }

    private static void set(PSSysTDItemBase pSSysTDItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysTDItemBase.setBadValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysTDItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysTDItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysTDItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysTDItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysTDItemBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysTDItemBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysTDItemBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysTDItemBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysTDItemBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysTDItemBase.setPSSysSampleValueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysTDItemBase.setPSSysSampleValueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysTDItemBase.setPSSysTDItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysTDItemBase.setPSSysTDItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysTDItemBase.setPSSysTestDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysTDItemBase.setPSSysTestDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysTDItemBase.setRefPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysTDItemBase.setRefPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysTDItemBase.setRefPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysTDItemBase.setRefPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysTDItemBase.setRefPSSysTestDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysTDItemBase.setRefPSSysTestDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysTDItemBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSSysTDItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSSysTDItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysTDItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysTDItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysTDItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysTDItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysTDItemBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysTDItemBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSSysTDItemBase.setValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysTDItemBase.setValueRange(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysTDItemBase.setValueType(DataObject.getStringValue((Object)object));
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
        return PSSysTDItemBase.isNull(this, n);
    }

    private static boolean isNull(PSSysTDItemBase pSSysTDItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTDItemBase.getBadValue() == null;
            }
            case 1: {
                return pSSysTDItemBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysTDItemBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysTDItemBase.getMemo() == null;
            }
            case 4: {
                return pSSysTDItemBase.getOrderValue() == null;
            }
            case 5: {
                return pSSysTDItemBase.getPSCodeListId() == null;
            }
            case 6: {
                return pSSysTDItemBase.getPSCodeListName() == null;
            }
            case 7: {
                return pSSysTDItemBase.getPSDEFId() == null;
            }
            case 8: {
                return pSSysTDItemBase.getPSDEFName() == null;
            }
            case 9: {
                return pSSysTDItemBase.getPSDEId() == null;
            }
            case 10: {
                return pSSysTDItemBase.getPSSysSampleValueId() == null;
            }
            case 11: {
                return pSSysTDItemBase.getPSSysSampleValueName() == null;
            }
            case 12: {
                return pSSysTDItemBase.getPSSysTDItemId() == null;
            }
            case 13: {
                return pSSysTDItemBase.getPSSysTDItemName() == null;
            }
            case 14: {
                return pSSysTDItemBase.getPSSysTestDataId() == null;
            }
            case 15: {
                return pSSysTDItemBase.getPSSysTestDataName() == null;
            }
            case 16: {
                return pSSysTDItemBase.getRefPSDEDataSetId() == null;
            }
            case 17: {
                return pSSysTDItemBase.getRefPSDEDataSetName() == null;
            }
            case 18: {
                return pSSysTDItemBase.getRefPSDEId() == null;
            }
            case 19: {
                return pSSysTDItemBase.getRefPSDEName() == null;
            }
            case 20: {
                return pSSysTDItemBase.getRefPSSysTestDataId() == null;
            }
            case 21: {
                return pSSysTDItemBase.getRefPSSysTestDataName() == null;
            }
            case 22: {
                return pSSysTDItemBase.getStdDataType() == null;
            }
            case 23: {
                return pSSysTDItemBase.getUpdateDate() == null;
            }
            case 24: {
                return pSSysTDItemBase.getUpdateMan() == null;
            }
            case 25: {
                return pSSysTDItemBase.getUserCat() == null;
            }
            case 26: {
                return pSSysTDItemBase.getUserTag() == null;
            }
            case 27: {
                return pSSysTDItemBase.getUserTag2() == null;
            }
            case 28: {
                return pSSysTDItemBase.getUserTag3() == null;
            }
            case 29: {
                return pSSysTDItemBase.getUserTag4() == null;
            }
            case 30: {
                return pSSysTDItemBase.getValidFlag() == null;
            }
            case 31: {
                return pSSysTDItemBase.getValue() == null;
            }
            case 32: {
                return pSSysTDItemBase.getValueRange() == null;
            }
            case 33: {
                return pSSysTDItemBase.getValueType() == null;
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
        return PSSysTDItemBase.contains(this, n);
    }

    private static boolean contains(PSSysTDItemBase pSSysTDItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTDItemBase.isBadValueDirty();
            }
            case 1: {
                return pSSysTDItemBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysTDItemBase.isCreateManDirty();
            }
            case 3: {
                return pSSysTDItemBase.isMemoDirty();
            }
            case 4: {
                return pSSysTDItemBase.isOrderValueDirty();
            }
            case 5: {
                return pSSysTDItemBase.isPSCodeListIdDirty();
            }
            case 6: {
                return pSSysTDItemBase.isPSCodeListNameDirty();
            }
            case 7: {
                return pSSysTDItemBase.isPSDEFIdDirty();
            }
            case 8: {
                return pSSysTDItemBase.isPSDEFNameDirty();
            }
            case 9: {
                return pSSysTDItemBase.isPSDEIdDirty();
            }
            case 10: {
                return pSSysTDItemBase.isPSSysSampleValueIdDirty();
            }
            case 11: {
                return pSSysTDItemBase.isPSSysSampleValueNameDirty();
            }
            case 12: {
                return pSSysTDItemBase.isPSSysTDItemIdDirty();
            }
            case 13: {
                return pSSysTDItemBase.isPSSysTDItemNameDirty();
            }
            case 14: {
                return pSSysTDItemBase.isPSSysTestDataIdDirty();
            }
            case 15: {
                return pSSysTDItemBase.isPSSysTestDataNameDirty();
            }
            case 16: {
                return pSSysTDItemBase.isRefPSDEDataSetIdDirty();
            }
            case 17: {
                return pSSysTDItemBase.isRefPSDEDataSetNameDirty();
            }
            case 18: {
                return pSSysTDItemBase.isRefPSDEIdDirty();
            }
            case 19: {
                return pSSysTDItemBase.isRefPSDENameDirty();
            }
            case 20: {
                return pSSysTDItemBase.isRefPSSysTestDataIdDirty();
            }
            case 21: {
                return pSSysTDItemBase.isRefPSSysTestDataNameDirty();
            }
            case 22: {
                return pSSysTDItemBase.isStdDataTypeDirty();
            }
            case 23: {
                return pSSysTDItemBase.isUpdateDateDirty();
            }
            case 24: {
                return pSSysTDItemBase.isUpdateManDirty();
            }
            case 25: {
                return pSSysTDItemBase.isUserCatDirty();
            }
            case 26: {
                return pSSysTDItemBase.isUserTagDirty();
            }
            case 27: {
                return pSSysTDItemBase.isUserTag2Dirty();
            }
            case 28: {
                return pSSysTDItemBase.isUserTag3Dirty();
            }
            case 29: {
                return pSSysTDItemBase.isUserTag4Dirty();
            }
            case 30: {
                return pSSysTDItemBase.isValidFlagDirty();
            }
            case 31: {
                return pSSysTDItemBase.isValueDirty();
            }
            case 32: {
                return pSSysTDItemBase.isValueRangeDirty();
            }
            case 33: {
                return pSSysTDItemBase.isValueTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysTDItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysTDItemBase pSSysTDItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysTDItemBase.getBadValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"badvalue", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getBadValue()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getPSSysSampleValueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssamplevalueid", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getPSSysSampleValueId()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getPSSysSampleValueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssamplevaluename", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getPSSysSampleValueName()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getPSSysTDItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystditemid", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getPSSysTDItemId()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getPSSysTDItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystditemname", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getPSSysTDItemName()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getPSSysTestDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestdataid", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getPSSysTestDataId()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getPSSysTestDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystestdataname", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getPSSysTestDataName()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getRefPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdedatasetid", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getRefPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getRefPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdedatasetname", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getRefPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getRefPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeid", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getRefPSDEId()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getRefPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdename", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getRefPSDEName()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getRefPSSysTestDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssystestdataid", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getRefPSSysTestDataId()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getRefPSSysTestDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssystestdataname", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getRefPSSysTestDataName()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getValue()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getValueRange() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuerange", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getValueRange()), (boolean)false);
        }
        if (bl || pSSysTDItemBase.getValueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuetype", (Object)PSSysTDItemBase.getJSONValue((Object)pSSysTDItemBase.getValueType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysTDItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysTDItemBase pSSysTDItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysTDItemBase.getBadValue() != null) {
            object = pSSysTDItemBase.getBadValue();
            xmlNode.setAttribute(FIELD_BADVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getCreateDate() != null) {
            object = pSSysTDItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTDItemBase.getCreateMan() != null) {
            object = pSSysTDItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getMemo() != null) {
            object = pSSysTDItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getOrderValue() != null) {
            object = pSSysTDItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTDItemBase.getPSCodeListId() != null) {
            object = pSSysTDItemBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getPSCodeListName() != null) {
            object = pSSysTDItemBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getPSDEFId() != null) {
            object = pSSysTDItemBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getPSDEFName() != null) {
            object = pSSysTDItemBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getPSDEId() != null) {
            object = pSSysTDItemBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getPSSysSampleValueId() != null) {
            object = pSSysTDItemBase.getPSSysSampleValueId();
            xmlNode.setAttribute(FIELD_PSSYSSAMPLEVALUEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getPSSysSampleValueName() != null) {
            object = pSSysTDItemBase.getPSSysSampleValueName();
            xmlNode.setAttribute(FIELD_PSSYSSAMPLEVALUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getPSSysTDItemId() != null) {
            object = pSSysTDItemBase.getPSSysTDItemId();
            xmlNode.setAttribute(FIELD_PSSYSTDITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getPSSysTDItemName() != null) {
            object = pSSysTDItemBase.getPSSysTDItemName();
            xmlNode.setAttribute(FIELD_PSSYSTDITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getPSSysTestDataId() != null) {
            object = pSSysTDItemBase.getPSSysTestDataId();
            xmlNode.setAttribute(FIELD_PSSYSTESTDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getPSSysTestDataName() != null) {
            object = pSSysTDItemBase.getPSSysTestDataName();
            xmlNode.setAttribute(FIELD_PSSYSTESTDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getRefPSDEDataSetId() != null) {
            object = pSSysTDItemBase.getRefPSDEDataSetId();
            xmlNode.setAttribute(FIELD_REFPSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getRefPSDEDataSetName() != null) {
            object = pSSysTDItemBase.getRefPSDEDataSetName();
            xmlNode.setAttribute(FIELD_REFPSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getRefPSDEId() != null) {
            object = pSSysTDItemBase.getRefPSDEId();
            xmlNode.setAttribute(FIELD_REFPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getRefPSDEName() != null) {
            object = pSSysTDItemBase.getRefPSDEName();
            xmlNode.setAttribute(FIELD_REFPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getRefPSSysTestDataId() != null) {
            object = pSSysTDItemBase.getRefPSSysTestDataId();
            xmlNode.setAttribute(FIELD_REFPSSYSTESTDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getRefPSSysTestDataName() != null) {
            object = pSSysTDItemBase.getRefPSSysTestDataName();
            xmlNode.setAttribute(FIELD_REFPSSYSTESTDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getStdDataType() != null) {
            object = pSSysTDItemBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTDItemBase.getUpdateDate() != null) {
            object = pSSysTDItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTDItemBase.getUpdateMan() != null) {
            object = pSSysTDItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getUserCat() != null) {
            object = pSSysTDItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getUserTag() != null) {
            object = pSSysTDItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getUserTag2() != null) {
            object = pSSysTDItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getUserTag3() != null) {
            object = pSSysTDItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getUserTag4() != null) {
            object = pSSysTDItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getValidFlag() != null) {
            object = pSSysTDItemBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTDItemBase.getValue() != null) {
            object = pSSysTDItemBase.getValue();
            xmlNode.setAttribute(FIELD_VALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getValueRange() != null) {
            object = pSSysTDItemBase.getValueRange();
            xmlNode.setAttribute(FIELD_VALUERANGE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTDItemBase.getValueType() != null) {
            object = pSSysTDItemBase.getValueType();
            xmlNode.setAttribute(FIELD_VALUETYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysTDItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysTDItemBase pSSysTDItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysTDItemBase.isBadValueDirty() && (bl || pSSysTDItemBase.getBadValue() != null)) {
            iDataObject.set(FIELD_BADVALUE, (Object)pSSysTDItemBase.getBadValue());
        }
        if (pSSysTDItemBase.isCreateDateDirty() && (bl || pSSysTDItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysTDItemBase.getCreateDate());
        }
        if (pSSysTDItemBase.isCreateManDirty() && (bl || pSSysTDItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysTDItemBase.getCreateMan());
        }
        if (pSSysTDItemBase.isMemoDirty() && (bl || pSSysTDItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysTDItemBase.getMemo());
        }
        if (pSSysTDItemBase.isOrderValueDirty() && (bl || pSSysTDItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysTDItemBase.getOrderValue());
        }
        if (pSSysTDItemBase.isPSCodeListIdDirty() && (bl || pSSysTDItemBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSSysTDItemBase.getPSCodeListId());
        }
        if (pSSysTDItemBase.isPSCodeListNameDirty() && (bl || pSSysTDItemBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSSysTDItemBase.getPSCodeListName());
        }
        if (pSSysTDItemBase.isPSDEFIdDirty() && (bl || pSSysTDItemBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSSysTDItemBase.getPSDEFId());
        }
        if (pSSysTDItemBase.isPSDEFNameDirty() && (bl || pSSysTDItemBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSSysTDItemBase.getPSDEFName());
        }
        if (pSSysTDItemBase.isPSDEIdDirty() && (bl || pSSysTDItemBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysTDItemBase.getPSDEId());
        }
        if (pSSysTDItemBase.isPSSysSampleValueIdDirty() && (bl || pSSysTDItemBase.getPSSysSampleValueId() != null)) {
            iDataObject.set(FIELD_PSSYSSAMPLEVALUEID, (Object)pSSysTDItemBase.getPSSysSampleValueId());
        }
        if (pSSysTDItemBase.isPSSysSampleValueNameDirty() && (bl || pSSysTDItemBase.getPSSysSampleValueName() != null)) {
            iDataObject.set(FIELD_PSSYSSAMPLEVALUENAME, (Object)pSSysTDItemBase.getPSSysSampleValueName());
        }
        if (pSSysTDItemBase.isPSSysTDItemIdDirty() && (bl || pSSysTDItemBase.getPSSysTDItemId() != null)) {
            iDataObject.set(FIELD_PSSYSTDITEMID, (Object)pSSysTDItemBase.getPSSysTDItemId());
        }
        if (pSSysTDItemBase.isPSSysTDItemNameDirty() && (bl || pSSysTDItemBase.getPSSysTDItemName() != null)) {
            iDataObject.set(FIELD_PSSYSTDITEMNAME, (Object)pSSysTDItemBase.getPSSysTDItemName());
        }
        if (pSSysTDItemBase.isPSSysTestDataIdDirty() && (bl || pSSysTDItemBase.getPSSysTestDataId() != null)) {
            iDataObject.set(FIELD_PSSYSTESTDATAID, (Object)pSSysTDItemBase.getPSSysTestDataId());
        }
        if (pSSysTDItemBase.isPSSysTestDataNameDirty() && (bl || pSSysTDItemBase.getPSSysTestDataName() != null)) {
            iDataObject.set(FIELD_PSSYSTESTDATANAME, (Object)pSSysTDItemBase.getPSSysTestDataName());
        }
        if (pSSysTDItemBase.isRefPSDEDataSetIdDirty() && (bl || pSSysTDItemBase.getRefPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_REFPSDEDATASETID, (Object)pSSysTDItemBase.getRefPSDEDataSetId());
        }
        if (pSSysTDItemBase.isRefPSDEDataSetNameDirty() && (bl || pSSysTDItemBase.getRefPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_REFPSDEDATASETNAME, (Object)pSSysTDItemBase.getRefPSDEDataSetName());
        }
        if (pSSysTDItemBase.isRefPSDEIdDirty() && (bl || pSSysTDItemBase.getRefPSDEId() != null)) {
            iDataObject.set(FIELD_REFPSDEID, (Object)pSSysTDItemBase.getRefPSDEId());
        }
        if (pSSysTDItemBase.isRefPSDENameDirty() && (bl || pSSysTDItemBase.getRefPSDEName() != null)) {
            iDataObject.set(FIELD_REFPSDENAME, (Object)pSSysTDItemBase.getRefPSDEName());
        }
        if (pSSysTDItemBase.isRefPSSysTestDataIdDirty() && (bl || pSSysTDItemBase.getRefPSSysTestDataId() != null)) {
            iDataObject.set(FIELD_REFPSSYSTESTDATAID, (Object)pSSysTDItemBase.getRefPSSysTestDataId());
        }
        if (pSSysTDItemBase.isRefPSSysTestDataNameDirty() && (bl || pSSysTDItemBase.getRefPSSysTestDataName() != null)) {
            iDataObject.set(FIELD_REFPSSYSTESTDATANAME, (Object)pSSysTDItemBase.getRefPSSysTestDataName());
        }
        if (pSSysTDItemBase.isStdDataTypeDirty() && (bl || pSSysTDItemBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSSysTDItemBase.getStdDataType());
        }
        if (pSSysTDItemBase.isUpdateDateDirty() && (bl || pSSysTDItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysTDItemBase.getUpdateDate());
        }
        if (pSSysTDItemBase.isUpdateManDirty() && (bl || pSSysTDItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysTDItemBase.getUpdateMan());
        }
        if (pSSysTDItemBase.isUserCatDirty() && (bl || pSSysTDItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysTDItemBase.getUserCat());
        }
        if (pSSysTDItemBase.isUserTagDirty() && (bl || pSSysTDItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysTDItemBase.getUserTag());
        }
        if (pSSysTDItemBase.isUserTag2Dirty() && (bl || pSSysTDItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysTDItemBase.getUserTag2());
        }
        if (pSSysTDItemBase.isUserTag3Dirty() && (bl || pSSysTDItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysTDItemBase.getUserTag3());
        }
        if (pSSysTDItemBase.isUserTag4Dirty() && (bl || pSSysTDItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysTDItemBase.getUserTag4());
        }
        if (pSSysTDItemBase.isValidFlagDirty() && (bl || pSSysTDItemBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysTDItemBase.getValidFlag());
        }
        if (pSSysTDItemBase.isValueDirty() && (bl || pSSysTDItemBase.getValue() != null)) {
            iDataObject.set(FIELD_VALUE, (Object)pSSysTDItemBase.getValue());
        }
        if (pSSysTDItemBase.isValueRangeDirty() && (bl || pSSysTDItemBase.getValueRange() != null)) {
            iDataObject.set(FIELD_VALUERANGE, (Object)pSSysTDItemBase.getValueRange());
        }
        if (pSSysTDItemBase.isValueTypeDirty() && (bl || pSSysTDItemBase.getValueType() != null)) {
            iDataObject.set(FIELD_VALUETYPE, (Object)pSSysTDItemBase.getValueType());
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
        return PSSysTDItemBase.remove(this, n);
    }

    private static boolean remove(PSSysTDItemBase pSSysTDItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysTDItemBase.resetBadValue();
                return true;
            }
            case 1: {
                pSSysTDItemBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysTDItemBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysTDItemBase.resetMemo();
                return true;
            }
            case 4: {
                pSSysTDItemBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSSysTDItemBase.resetPSCodeListId();
                return true;
            }
            case 6: {
                pSSysTDItemBase.resetPSCodeListName();
                return true;
            }
            case 7: {
                pSSysTDItemBase.resetPSDEFId();
                return true;
            }
            case 8: {
                pSSysTDItemBase.resetPSDEFName();
                return true;
            }
            case 9: {
                pSSysTDItemBase.resetPSDEId();
                return true;
            }
            case 10: {
                pSSysTDItemBase.resetPSSysSampleValueId();
                return true;
            }
            case 11: {
                pSSysTDItemBase.resetPSSysSampleValueName();
                return true;
            }
            case 12: {
                pSSysTDItemBase.resetPSSysTDItemId();
                return true;
            }
            case 13: {
                pSSysTDItemBase.resetPSSysTDItemName();
                return true;
            }
            case 14: {
                pSSysTDItemBase.resetPSSysTestDataId();
                return true;
            }
            case 15: {
                pSSysTDItemBase.resetPSSysTestDataName();
                return true;
            }
            case 16: {
                pSSysTDItemBase.resetRefPSDEDataSetId();
                return true;
            }
            case 17: {
                pSSysTDItemBase.resetRefPSDEDataSetName();
                return true;
            }
            case 18: {
                pSSysTDItemBase.resetRefPSDEId();
                return true;
            }
            case 19: {
                pSSysTDItemBase.resetRefPSDEName();
                return true;
            }
            case 20: {
                pSSysTDItemBase.resetRefPSSysTestDataId();
                return true;
            }
            case 21: {
                pSSysTDItemBase.resetRefPSSysTestDataName();
                return true;
            }
            case 22: {
                pSSysTDItemBase.resetStdDataType();
                return true;
            }
            case 23: {
                pSSysTDItemBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSSysTDItemBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSSysTDItemBase.resetUserCat();
                return true;
            }
            case 26: {
                pSSysTDItemBase.resetUserTag();
                return true;
            }
            case 27: {
                pSSysTDItemBase.resetUserTag2();
                return true;
            }
            case 28: {
                pSSysTDItemBase.resetUserTag3();
                return true;
            }
            case 29: {
                pSSysTDItemBase.resetUserTag4();
                return true;
            }
            case 30: {
                pSSysTDItemBase.resetValidFlag();
                return true;
            }
            case 31: {
                pSSysTDItemBase.resetValue();
                return true;
            }
            case 32: {
                pSSysTDItemBase.resetValueRange();
                return true;
            }
            case 33: {
                pSSysTDItemBase.resetValueType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeList();
        }
        if (this.getPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objPSCodeListLock;
        synchronized (n) {
            if (this.pscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSCodeListId(), (Object)this.pscodelist.getPSCodeListId()) != 0L) {
                this.pscodelist = null;
            }
            if (this.pscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet((IEntity)pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getRefPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDE();
        }
        if (this.getRefPSDEId() == null) {
            return null;
        }
        Integer n = this.objRefPSDELock;
        synchronized (n) {
            if (this.refpsde != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDEId(), (Object)this.refpsde.getPSDataEntityId()) != 0L) {
                this.refpsde = null;
            }
            if (this.refpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getRefPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.refpsde = pSDataEntity;
            }
            return this.refpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getRefPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEDataSet();
        }
        if (this.getRefPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objRefPSDEDataSetLock;
        synchronized (n) {
            if (this.refpsdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDEDataSetId(), (Object)this.refpsdedataset.getPSDEDataSetId()) != 0L) {
                this.refpsdedataset = null;
            }
            if (this.refpsdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getRefPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.refpsdedataset = pSDEDataSet;
            }
            return this.refpsdedataset;
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
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSampleValue getPSSysSampleValue() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSampleValue();
        }
        if (this.getPSSysSampleValueId() == null) {
            return null;
        }
        Integer n = this.objPSSysSampleValueLock;
        synchronized (n) {
            if (this.pssyssamplevalue != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSampleValueId(), (Object)this.pssyssamplevalue.getPSSysSampleValueId()) != 0L) {
                this.pssyssamplevalue = null;
            }
            if (this.pssyssamplevalue == null) {
                PSSysSampleValue pSSysSampleValue = new PSSysSampleValue();
                pSSysSampleValue.setPSSysSampleValueId(this.getPSSysSampleValueId());
                PSSysSampleValueService pSSysSampleValueService = (PSSysSampleValueService)ServiceGlobal.getService(PSSysSampleValueService.class, (SessionFactory)this.getSessionFactory());
                pSSysSampleValueService.autoGet((IEntity)pSSysSampleValue);
                this.pssyssamplevalue = pSSysSampleValue;
            }
            return this.pssyssamplevalue;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTestData getRefPSSysTestData() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysTestData();
        }
        if (this.getRefPSSysTestDataId() == null) {
            return null;
        }
        Integer n = this.objRefPSSysTestDataLock;
        synchronized (n) {
            if (this.refpssystestdata != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSSysTestDataId(), (Object)this.refpssystestdata.getPSSysTestDataId()) != 0L) {
                this.refpssystestdata = null;
            }
            if (this.refpssystestdata == null) {
                PSSysTestData pSSysTestData = new PSSysTestData();
                pSSysTestData.setPSSysTestDataId(this.getRefPSSysTestDataId());
                PSSysTestDataService pSSysTestDataService = (PSSysTestDataService)ServiceGlobal.getService(PSSysTestDataService.class, (SessionFactory)this.getSessionFactory());
                pSSysTestDataService.autoGet((IEntity)pSSysTestData);
                this.refpssystestdata = pSSysTestData;
            }
            return this.refpssystestdata;
        }
    }

    private PSSysTDItemBase getProxyEntity() {
        return this.proxyPSSysTDItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysTDItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysTDItemBase) {
            this.proxyPSSysTDItemBase = (PSSysTDItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTDItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BADVALUE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSCODELISTID, 5);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 6);
        fieldIndexMap.put(FIELD_PSDEFID, 7);
        fieldIndexMap.put(FIELD_PSDEFNAME, 8);
        fieldIndexMap.put(FIELD_PSDEID, 9);
        fieldIndexMap.put(FIELD_PSSYSSAMPLEVALUEID, 10);
        fieldIndexMap.put(FIELD_PSSYSSAMPLEVALUENAME, 11);
        fieldIndexMap.put(FIELD_PSSYSTDITEMID, 12);
        fieldIndexMap.put(FIELD_PSSYSTDITEMNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSTESTDATAID, 14);
        fieldIndexMap.put(FIELD_PSSYSTESTDATANAME, 15);
        fieldIndexMap.put(FIELD_REFPSDEDATASETID, 16);
        fieldIndexMap.put(FIELD_REFPSDEDATASETNAME, 17);
        fieldIndexMap.put(FIELD_REFPSDEID, 18);
        fieldIndexMap.put(FIELD_REFPSDENAME, 19);
        fieldIndexMap.put(FIELD_REFPSSYSTESTDATAID, 20);
        fieldIndexMap.put(FIELD_REFPSSYSTESTDATANAME, 21);
        fieldIndexMap.put(FIELD_STDDATATYPE, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_USERCAT, 25);
        fieldIndexMap.put(FIELD_USERTAG, 26);
        fieldIndexMap.put(FIELD_USERTAG2, 27);
        fieldIndexMap.put(FIELD_USERTAG3, 28);
        fieldIndexMap.put(FIELD_USERTAG4, 29);
        fieldIndexMap.put(FIELD_VALIDFLAG, 30);
        fieldIndexMap.put(FIELD_VALUE, 31);
        fieldIndexMap.put(FIELD_VALUERANGE, 32);
        fieldIndexMap.put(FIELD_VALUETYPE, 33);
    }
}

