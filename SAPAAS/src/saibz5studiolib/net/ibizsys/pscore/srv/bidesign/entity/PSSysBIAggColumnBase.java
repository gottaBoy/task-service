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
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIAggTable;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeDimension;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeLevel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasure;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggTableService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeLevelService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBIAggColumnBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBIAggColumnBase.class);
    public static final String FIELD_BIAGGCOLUMNTAG = "BIAGGCOLUMNTAG";
    public static final String FIELD_BIAGGCOLUMNTAG2 = "BIAGGCOLUMNTAG2";
    public static final String FIELD_BIAGGCOLUMNTYPE = "BIAGGCOLUMNTYPE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_DEFAULTVALUETYPE = "DVT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSBIAGGCOLUMNID = "PSSYSBIAGGCOLUMNID";
    public static final String FIELD_PSSYSBIAGGCOLUMNNAME = "PSSYSBIAGGCOLUMNNAME";
    public static final String FIELD_PSSYSBIAGGTABLEID = "PSSYSBIAGGTABLEID";
    public static final String FIELD_PSSYSBIAGGTABLENAME = "PSSYSBIAGGTABLENAME";
    public static final String FIELD_PSSYSBICUBEDIMENSIONID = "PSSYSBICUBEDIMENSIONID";
    public static final String FIELD_PSSYSBICUBEDIMENSIONNAME = "PSSYSBICUBEDIMENSIONNAME";
    public static final String FIELD_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String FIELD_PSSYSBICUBELEVELID = "PSSYSBICUBELEVELID";
    public static final String FIELD_PSSYSBICUBELEVELNAME = "PSSYSBICUBELEVELNAME";
    public static final String FIELD_PSSYSBICUBEMEASUREID = "PSSYSBICUBEMEASUREID";
    public static final String FIELD_PSSYSBICUBEMEASURENAME = "PSSYSBICUBEMEASURENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BIAGGCOLUMNTAG = 0;
    private static final int INDEX_BIAGGCOLUMNTAG2 = 1;
    private static final int INDEX_BIAGGCOLUMNTYPE = 2;
    private static final int INDEX_CODENAME = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_DEFAULTVALUE = 6;
    private static final int INDEX_DEFAULTVALUETYPE = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_PSDEFID = 9;
    private static final int INDEX_PSDEFNAME = 10;
    private static final int INDEX_PSDEID = 11;
    private static final int INDEX_PSSYSBIAGGCOLUMNID = 12;
    private static final int INDEX_PSSYSBIAGGCOLUMNNAME = 13;
    private static final int INDEX_PSSYSBIAGGTABLEID = 14;
    private static final int INDEX_PSSYSBIAGGTABLENAME = 15;
    private static final int INDEX_PSSYSBICUBEDIMENSIONID = 16;
    private static final int INDEX_PSSYSBICUBEDIMENSIONNAME = 17;
    private static final int INDEX_PSSYSBICUBEID = 18;
    private static final int INDEX_PSSYSBICUBELEVELID = 19;
    private static final int INDEX_PSSYSBICUBELEVELNAME = 20;
    private static final int INDEX_PSSYSBICUBEMEASUREID = 21;
    private static final int INDEX_PSSYSBICUBEMEASURENAME = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final int INDEX_USERCAT = 25;
    private static final int INDEX_USERTAG = 26;
    private static final int INDEX_USERTAG2 = 27;
    private static final int INDEX_USERTAG3 = 28;
    private static final int INDEX_USERTAG4 = 29;
    private static final int INDEX_VALIDFLAG = 30;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBIAggColumnBase proxyPSSysBIAggColumnBase = null;
    private boolean biaggcolumntagDirtyFlag = false;
    private boolean biaggcolumntag2DirtyFlag = false;
    private boolean biaggcolumntypeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean defaultvaluetypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssysbiaggcolumnidDirtyFlag = false;
    private boolean pssysbiaggcolumnnameDirtyFlag = false;
    private boolean pssysbiaggtableidDirtyFlag = false;
    private boolean pssysbiaggtablenameDirtyFlag = false;
    private boolean pssysbicubedimensionidDirtyFlag = false;
    private boolean pssysbicubedimensionnameDirtyFlag = false;
    private boolean pssysbicubeidDirtyFlag = false;
    private boolean pssysbicubelevelidDirtyFlag = false;
    private boolean pssysbicubelevelnameDirtyFlag = false;
    private boolean pssysbicubemeasureidDirtyFlag = false;
    private boolean pssysbicubemeasurenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="biaggcolumntag")
    private String biaggcolumntag;
    @Column(name="biaggcolumntag2")
    private String biaggcolumntag2;
    @Column(name="biaggcolumntype")
    private String biaggcolumntype;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultvalue")
    private String defaultvalue;
    @Column(name="defaultvaluetype")
    private String defaultvaluetype;
    @Column(name="memo")
    private String memo;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssysbiaggcolumnid")
    private String pssysbiaggcolumnid;
    @Column(name="pssysbiaggcolumnname")
    private String pssysbiaggcolumnname;
    @Column(name="pssysbiaggtableid")
    private String pssysbiaggtableid;
    @Column(name="pssysbiaggtablename")
    private String pssysbiaggtablename;
    @Column(name="pssysbicubedimensionid")
    private String pssysbicubedimensionid;
    @Column(name="pssysbicubedimensionname")
    private String pssysbicubedimensionname;
    @Column(name="pssysbicubeid")
    private String pssysbicubeid;
    @Column(name="pssysbicubelevelid")
    private String pssysbicubelevelid;
    @Column(name="pssysbicubelevelname")
    private String pssysbicubelevelname;
    @Column(name="pssysbicubemeasureid")
    private String pssysbicubemeasureid;
    @Column(name="pssysbicubemeasurename")
    private String pssysbicubemeasurename;
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
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSSysBIAggTableLock = new Integer(1);
    private PSSysBIAggTable pssysbiaggtable = null;
    private Integer objPSSysBICubeDimensionLock = new Integer(1);
    private PSSysBICubeDimension pssysbicubedimension = null;
    private Integer objPSSysBICubeLevelLock = new Integer(1);
    private PSSysBICubeLevel pssysbicubelevel = null;
    private Integer objPSSysBICubeMeasureLock = new Integer(1);
    private PSSysBICubeMeasure pssysbicubemeasure = null;

    public void setBIAggColumnTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIAggColumnTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.biaggcolumntag = string;
        this.biaggcolumntagDirtyFlag = true;
    }

    public String getBIAggColumnTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIAggColumnTag();
        }
        return this.biaggcolumntag;
    }

    public boolean isBIAggColumnTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIAggColumnTagDirty();
        }
        return this.biaggcolumntagDirtyFlag;
    }

    public void resetBIAggColumnTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIAggColumnTag();
            return;
        }
        this.biaggcolumntagDirtyFlag = false;
        this.biaggcolumntag = null;
    }

    public void setBIAggColumnTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIAggColumnTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.biaggcolumntag2 = string;
        this.biaggcolumntag2DirtyFlag = true;
    }

    public String getBIAggColumnTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIAggColumnTag2();
        }
        return this.biaggcolumntag2;
    }

    public boolean isBIAggColumnTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIAggColumnTag2Dirty();
        }
        return this.biaggcolumntag2DirtyFlag;
    }

    public void resetBIAggColumnTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIAggColumnTag2();
            return;
        }
        this.biaggcolumntag2DirtyFlag = false;
        this.biaggcolumntag2 = null;
    }

    public void setBIAggColumnType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIAggColumnType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.biaggcolumntype = string;
        this.biaggcolumntypeDirtyFlag = true;
    }

    public String getBIAggColumnType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIAggColumnType();
        }
        return this.biaggcolumntype;
    }

    public boolean isBIAggColumnTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIAggColumnTypeDirty();
        }
        return this.biaggcolumntypeDirtyFlag;
    }

    public void resetBIAggColumnType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIAggColumnType();
            return;
        }
        this.biaggcolumntypeDirtyFlag = false;
        this.biaggcolumntype = null;
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

    public void setDefaultValueType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultValueType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultvaluetype = string;
        this.defaultvaluetypeDirtyFlag = true;
    }

    public String getDefaultValueType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultValueType();
        }
        return this.defaultvaluetype;
    }

    public boolean isDefaultValueTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultValueTypeDirty();
        }
        return this.defaultvaluetypeDirtyFlag;
    }

    public void resetDefaultValueType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultValueType();
            return;
        }
        this.defaultvaluetypeDirtyFlag = false;
        this.defaultvaluetype = null;
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

    public void setPSSysBIAggColumnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIAggColumnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbiaggcolumnid = string;
        this.pssysbiaggcolumnidDirtyFlag = true;
    }

    public String getPSSysBIAggColumnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIAggColumnId();
        }
        return this.pssysbiaggcolumnid;
    }

    public boolean isPSSysBIAggColumnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIAggColumnIdDirty();
        }
        return this.pssysbiaggcolumnidDirtyFlag;
    }

    public void resetPSSysBIAggColumnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIAggColumnId();
            return;
        }
        this.pssysbiaggcolumnidDirtyFlag = false;
        this.pssysbiaggcolumnid = null;
    }

    public void setPSSysBIAggColumnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIAggColumnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbiaggcolumnname = string;
        this.pssysbiaggcolumnnameDirtyFlag = true;
    }

    public String getPSSysBIAggColumnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIAggColumnName();
        }
        return this.pssysbiaggcolumnname;
    }

    public boolean isPSSysBIAggColumnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIAggColumnNameDirty();
        }
        return this.pssysbiaggcolumnnameDirtyFlag;
    }

    public void resetPSSysBIAggColumnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIAggColumnName();
            return;
        }
        this.pssysbiaggcolumnnameDirtyFlag = false;
        this.pssysbiaggcolumnname = null;
    }

    public void setPSSysBIAggTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIAggTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbiaggtableid = string;
        this.pssysbiaggtableidDirtyFlag = true;
    }

    public String getPSSysBIAggTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIAggTableId();
        }
        return this.pssysbiaggtableid;
    }

    public boolean isPSSysBIAggTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIAggTableIdDirty();
        }
        return this.pssysbiaggtableidDirtyFlag;
    }

    public void resetPSSysBIAggTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIAggTableId();
            return;
        }
        this.pssysbiaggtableidDirtyFlag = false;
        this.pssysbiaggtableid = null;
    }

    public void setPSSysBIAggTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIAggTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbiaggtablename = string;
        this.pssysbiaggtablenameDirtyFlag = true;
    }

    public String getPSSysBIAggTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIAggTableName();
        }
        return this.pssysbiaggtablename;
    }

    public boolean isPSSysBIAggTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIAggTableNameDirty();
        }
        return this.pssysbiaggtablenameDirtyFlag;
    }

    public void resetPSSysBIAggTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIAggTableName();
            return;
        }
        this.pssysbiaggtablenameDirtyFlag = false;
        this.pssysbiaggtablename = null;
    }

    public void setPSSysBICubeDimensionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeDimensionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubedimensionid = string;
        this.pssysbicubedimensionidDirtyFlag = true;
    }

    public String getPSSysBICubeDimensionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeDimensionId();
        }
        return this.pssysbicubedimensionid;
    }

    public boolean isPSSysBICubeDimensionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeDimensionIdDirty();
        }
        return this.pssysbicubedimensionidDirtyFlag;
    }

    public void resetPSSysBICubeDimensionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeDimensionId();
            return;
        }
        this.pssysbicubedimensionidDirtyFlag = false;
        this.pssysbicubedimensionid = null;
    }

    public void setPSSysBICubeDimensionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeDimensionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubedimensionname = string;
        this.pssysbicubedimensionnameDirtyFlag = true;
    }

    public String getPSSysBICubeDimensionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeDimensionName();
        }
        return this.pssysbicubedimensionname;
    }

    public boolean isPSSysBICubeDimensionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeDimensionNameDirty();
        }
        return this.pssysbicubedimensionnameDirtyFlag;
    }

    public void resetPSSysBICubeDimensionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeDimensionName();
            return;
        }
        this.pssysbicubedimensionnameDirtyFlag = false;
        this.pssysbicubedimensionname = null;
    }

    public void setPSSysBICubeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubeid = string;
        this.pssysbicubeidDirtyFlag = true;
    }

    public String getPSSysBICubeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeId();
        }
        return this.pssysbicubeid;
    }

    public boolean isPSSysBICubeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeIdDirty();
        }
        return this.pssysbicubeidDirtyFlag;
    }

    public void resetPSSysBICubeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeId();
            return;
        }
        this.pssysbicubeidDirtyFlag = false;
        this.pssysbicubeid = null;
    }

    public void setPSSysBICubeLevelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeLevelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubelevelid = string;
        this.pssysbicubelevelidDirtyFlag = true;
    }

    public String getPSSysBICubeLevelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeLevelId();
        }
        return this.pssysbicubelevelid;
    }

    public boolean isPSSysBICubeLevelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeLevelIdDirty();
        }
        return this.pssysbicubelevelidDirtyFlag;
    }

    public void resetPSSysBICubeLevelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeLevelId();
            return;
        }
        this.pssysbicubelevelidDirtyFlag = false;
        this.pssysbicubelevelid = null;
    }

    public void setPSSysBICubeLevelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeLevelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubelevelname = string;
        this.pssysbicubelevelnameDirtyFlag = true;
    }

    public String getPSSysBICubeLevelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeLevelName();
        }
        return this.pssysbicubelevelname;
    }

    public boolean isPSSysBICubeLevelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeLevelNameDirty();
        }
        return this.pssysbicubelevelnameDirtyFlag;
    }

    public void resetPSSysBICubeLevelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeLevelName();
            return;
        }
        this.pssysbicubelevelnameDirtyFlag = false;
        this.pssysbicubelevelname = null;
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
        PSSysBIAggColumnBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBIAggColumnBase pSSysBIAggColumnBase) {
        pSSysBIAggColumnBase.resetBIAggColumnTag();
        pSSysBIAggColumnBase.resetBIAggColumnTag2();
        pSSysBIAggColumnBase.resetBIAggColumnType();
        pSSysBIAggColumnBase.resetCodeName();
        pSSysBIAggColumnBase.resetCreateDate();
        pSSysBIAggColumnBase.resetCreateMan();
        pSSysBIAggColumnBase.resetDefaultValue();
        pSSysBIAggColumnBase.resetDefaultValueType();
        pSSysBIAggColumnBase.resetMemo();
        pSSysBIAggColumnBase.resetPSDEFId();
        pSSysBIAggColumnBase.resetPSDEFName();
        pSSysBIAggColumnBase.resetPSDEId();
        pSSysBIAggColumnBase.resetPSSysBIAggColumnId();
        pSSysBIAggColumnBase.resetPSSysBIAggColumnName();
        pSSysBIAggColumnBase.resetPSSysBIAggTableId();
        pSSysBIAggColumnBase.resetPSSysBIAggTableName();
        pSSysBIAggColumnBase.resetPSSysBICubeDimensionId();
        pSSysBIAggColumnBase.resetPSSysBICubeDimensionName();
        pSSysBIAggColumnBase.resetPSSysBICubeId();
        pSSysBIAggColumnBase.resetPSSysBICubeLevelId();
        pSSysBIAggColumnBase.resetPSSysBICubeLevelName();
        pSSysBIAggColumnBase.resetPSSysBICubeMeasureId();
        pSSysBIAggColumnBase.resetPSSysBICubeMeasureName();
        pSSysBIAggColumnBase.resetUpdateDate();
        pSSysBIAggColumnBase.resetUpdateMan();
        pSSysBIAggColumnBase.resetUserCat();
        pSSysBIAggColumnBase.resetUserTag();
        pSSysBIAggColumnBase.resetUserTag2();
        pSSysBIAggColumnBase.resetUserTag3();
        pSSysBIAggColumnBase.resetUserTag4();
        pSSysBIAggColumnBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBIAggColumnTagDirty()) {
            hashMap.put(FIELD_BIAGGCOLUMNTAG, this.getBIAggColumnTag());
        }
        if (!bl || this.isBIAggColumnTag2Dirty()) {
            hashMap.put(FIELD_BIAGGCOLUMNTAG2, this.getBIAggColumnTag2());
        }
        if (!bl || this.isBIAggColumnTypeDirty()) {
            hashMap.put(FIELD_BIAGGCOLUMNTYPE, this.getBIAggColumnType());
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
        if (!bl || this.isDefaultValueDirty()) {
            hashMap.put(FIELD_DEFAULTVALUE, this.getDefaultValue());
        }
        if (!bl || this.isDefaultValueTypeDirty()) {
            hashMap.put(FIELD_DEFAULTVALUETYPE, this.getDefaultValueType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
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
        if (!bl || this.isPSSysBIAggColumnIdDirty()) {
            hashMap.put(FIELD_PSSYSBIAGGCOLUMNID, this.getPSSysBIAggColumnId());
        }
        if (!bl || this.isPSSysBIAggColumnNameDirty()) {
            hashMap.put(FIELD_PSSYSBIAGGCOLUMNNAME, this.getPSSysBIAggColumnName());
        }
        if (!bl || this.isPSSysBIAggTableIdDirty()) {
            hashMap.put(FIELD_PSSYSBIAGGTABLEID, this.getPSSysBIAggTableId());
        }
        if (!bl || this.isPSSysBIAggTableNameDirty()) {
            hashMap.put(FIELD_PSSYSBIAGGTABLENAME, this.getPSSysBIAggTableName());
        }
        if (!bl || this.isPSSysBICubeDimensionIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEDIMENSIONID, this.getPSSysBICubeDimensionId());
        }
        if (!bl || this.isPSSysBICubeDimensionNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEDIMENSIONNAME, this.getPSSysBICubeDimensionName());
        }
        if (!bl || this.isPSSysBICubeIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEID, this.getPSSysBICubeId());
        }
        if (!bl || this.isPSSysBICubeLevelIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBELEVELID, this.getPSSysBICubeLevelId());
        }
        if (!bl || this.isPSSysBICubeLevelNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBELEVELNAME, this.getPSSysBICubeLevelName());
        }
        if (!bl || this.isPSSysBICubeMeasureIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEMEASUREID, this.getPSSysBICubeMeasureId());
        }
        if (!bl || this.isPSSysBICubeMeasureNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEMEASURENAME, this.getPSSysBICubeMeasureName());
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
        return PSSysBIAggColumnBase.get(this, n);
    }

    private static Object get(PSSysBIAggColumnBase pSSysBIAggColumnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIAggColumnBase.getBIAggColumnTag();
            }
            case 1: {
                return pSSysBIAggColumnBase.getBIAggColumnTag2();
            }
            case 2: {
                return pSSysBIAggColumnBase.getBIAggColumnType();
            }
            case 3: {
                return pSSysBIAggColumnBase.getCodeName();
            }
            case 4: {
                return pSSysBIAggColumnBase.getCreateDate();
            }
            case 5: {
                return pSSysBIAggColumnBase.getCreateMan();
            }
            case 6: {
                return pSSysBIAggColumnBase.getDefaultValue();
            }
            case 7: {
                return pSSysBIAggColumnBase.getDefaultValueType();
            }
            case 8: {
                return pSSysBIAggColumnBase.getMemo();
            }
            case 9: {
                return pSSysBIAggColumnBase.getPSDEFId();
            }
            case 10: {
                return pSSysBIAggColumnBase.getPSDEFName();
            }
            case 11: {
                return pSSysBIAggColumnBase.getPSDEId();
            }
            case 12: {
                return pSSysBIAggColumnBase.getPSSysBIAggColumnId();
            }
            case 13: {
                return pSSysBIAggColumnBase.getPSSysBIAggColumnName();
            }
            case 14: {
                return pSSysBIAggColumnBase.getPSSysBIAggTableId();
            }
            case 15: {
                return pSSysBIAggColumnBase.getPSSysBIAggTableName();
            }
            case 16: {
                return pSSysBIAggColumnBase.getPSSysBICubeDimensionId();
            }
            case 17: {
                return pSSysBIAggColumnBase.getPSSysBICubeDimensionName();
            }
            case 18: {
                return pSSysBIAggColumnBase.getPSSysBICubeId();
            }
            case 19: {
                return pSSysBIAggColumnBase.getPSSysBICubeLevelId();
            }
            case 20: {
                return pSSysBIAggColumnBase.getPSSysBICubeLevelName();
            }
            case 21: {
                return pSSysBIAggColumnBase.getPSSysBICubeMeasureId();
            }
            case 22: {
                return pSSysBIAggColumnBase.getPSSysBICubeMeasureName();
            }
            case 23: {
                return pSSysBIAggColumnBase.getUpdateDate();
            }
            case 24: {
                return pSSysBIAggColumnBase.getUpdateMan();
            }
            case 25: {
                return pSSysBIAggColumnBase.getUserCat();
            }
            case 26: {
                return pSSysBIAggColumnBase.getUserTag();
            }
            case 27: {
                return pSSysBIAggColumnBase.getUserTag2();
            }
            case 28: {
                return pSSysBIAggColumnBase.getUserTag3();
            }
            case 29: {
                return pSSysBIAggColumnBase.getUserTag4();
            }
            case 30: {
                return pSSysBIAggColumnBase.getValidFlag();
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
        PSSysBIAggColumnBase.set(this, n, object);
    }

    private static void set(PSSysBIAggColumnBase pSSysBIAggColumnBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBIAggColumnBase.setBIAggColumnTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBIAggColumnBase.setBIAggColumnTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBIAggColumnBase.setBIAggColumnType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBIAggColumnBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBIAggColumnBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSSysBIAggColumnBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBIAggColumnBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBIAggColumnBase.setDefaultValueType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBIAggColumnBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBIAggColumnBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBIAggColumnBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBIAggColumnBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBIAggColumnBase.setPSSysBIAggColumnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBIAggColumnBase.setPSSysBIAggColumnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBIAggColumnBase.setPSSysBIAggTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBIAggColumnBase.setPSSysBIAggTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBIAggColumnBase.setPSSysBICubeDimensionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysBIAggColumnBase.setPSSysBICubeDimensionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBIAggColumnBase.setPSSysBICubeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBIAggColumnBase.setPSSysBICubeLevelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysBIAggColumnBase.setPSSysBICubeLevelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBIAggColumnBase.setPSSysBICubeMeasureId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBIAggColumnBase.setPSSysBICubeMeasureName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBIAggColumnBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSSysBIAggColumnBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysBIAggColumnBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysBIAggColumnBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysBIAggColumnBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysBIAggColumnBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysBIAggColumnBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysBIAggColumnBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysBIAggColumnBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBIAggColumnBase pSSysBIAggColumnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIAggColumnBase.getBIAggColumnTag() == null;
            }
            case 1: {
                return pSSysBIAggColumnBase.getBIAggColumnTag2() == null;
            }
            case 2: {
                return pSSysBIAggColumnBase.getBIAggColumnType() == null;
            }
            case 3: {
                return pSSysBIAggColumnBase.getCodeName() == null;
            }
            case 4: {
                return pSSysBIAggColumnBase.getCreateDate() == null;
            }
            case 5: {
                return pSSysBIAggColumnBase.getCreateMan() == null;
            }
            case 6: {
                return pSSysBIAggColumnBase.getDefaultValue() == null;
            }
            case 7: {
                return pSSysBIAggColumnBase.getDefaultValueType() == null;
            }
            case 8: {
                return pSSysBIAggColumnBase.getMemo() == null;
            }
            case 9: {
                return pSSysBIAggColumnBase.getPSDEFId() == null;
            }
            case 10: {
                return pSSysBIAggColumnBase.getPSDEFName() == null;
            }
            case 11: {
                return pSSysBIAggColumnBase.getPSDEId() == null;
            }
            case 12: {
                return pSSysBIAggColumnBase.getPSSysBIAggColumnId() == null;
            }
            case 13: {
                return pSSysBIAggColumnBase.getPSSysBIAggColumnName() == null;
            }
            case 14: {
                return pSSysBIAggColumnBase.getPSSysBIAggTableId() == null;
            }
            case 15: {
                return pSSysBIAggColumnBase.getPSSysBIAggTableName() == null;
            }
            case 16: {
                return pSSysBIAggColumnBase.getPSSysBICubeDimensionId() == null;
            }
            case 17: {
                return pSSysBIAggColumnBase.getPSSysBICubeDimensionName() == null;
            }
            case 18: {
                return pSSysBIAggColumnBase.getPSSysBICubeId() == null;
            }
            case 19: {
                return pSSysBIAggColumnBase.getPSSysBICubeLevelId() == null;
            }
            case 20: {
                return pSSysBIAggColumnBase.getPSSysBICubeLevelName() == null;
            }
            case 21: {
                return pSSysBIAggColumnBase.getPSSysBICubeMeasureId() == null;
            }
            case 22: {
                return pSSysBIAggColumnBase.getPSSysBICubeMeasureName() == null;
            }
            case 23: {
                return pSSysBIAggColumnBase.getUpdateDate() == null;
            }
            case 24: {
                return pSSysBIAggColumnBase.getUpdateMan() == null;
            }
            case 25: {
                return pSSysBIAggColumnBase.getUserCat() == null;
            }
            case 26: {
                return pSSysBIAggColumnBase.getUserTag() == null;
            }
            case 27: {
                return pSSysBIAggColumnBase.getUserTag2() == null;
            }
            case 28: {
                return pSSysBIAggColumnBase.getUserTag3() == null;
            }
            case 29: {
                return pSSysBIAggColumnBase.getUserTag4() == null;
            }
            case 30: {
                return pSSysBIAggColumnBase.getValidFlag() == null;
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
        return PSSysBIAggColumnBase.contains(this, n);
    }

    private static boolean contains(PSSysBIAggColumnBase pSSysBIAggColumnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIAggColumnBase.isBIAggColumnTagDirty();
            }
            case 1: {
                return pSSysBIAggColumnBase.isBIAggColumnTag2Dirty();
            }
            case 2: {
                return pSSysBIAggColumnBase.isBIAggColumnTypeDirty();
            }
            case 3: {
                return pSSysBIAggColumnBase.isCodeNameDirty();
            }
            case 4: {
                return pSSysBIAggColumnBase.isCreateDateDirty();
            }
            case 5: {
                return pSSysBIAggColumnBase.isCreateManDirty();
            }
            case 6: {
                return pSSysBIAggColumnBase.isDefaultValueDirty();
            }
            case 7: {
                return pSSysBIAggColumnBase.isDefaultValueTypeDirty();
            }
            case 8: {
                return pSSysBIAggColumnBase.isMemoDirty();
            }
            case 9: {
                return pSSysBIAggColumnBase.isPSDEFIdDirty();
            }
            case 10: {
                return pSSysBIAggColumnBase.isPSDEFNameDirty();
            }
            case 11: {
                return pSSysBIAggColumnBase.isPSDEIdDirty();
            }
            case 12: {
                return pSSysBIAggColumnBase.isPSSysBIAggColumnIdDirty();
            }
            case 13: {
                return pSSysBIAggColumnBase.isPSSysBIAggColumnNameDirty();
            }
            case 14: {
                return pSSysBIAggColumnBase.isPSSysBIAggTableIdDirty();
            }
            case 15: {
                return pSSysBIAggColumnBase.isPSSysBIAggTableNameDirty();
            }
            case 16: {
                return pSSysBIAggColumnBase.isPSSysBICubeDimensionIdDirty();
            }
            case 17: {
                return pSSysBIAggColumnBase.isPSSysBICubeDimensionNameDirty();
            }
            case 18: {
                return pSSysBIAggColumnBase.isPSSysBICubeIdDirty();
            }
            case 19: {
                return pSSysBIAggColumnBase.isPSSysBICubeLevelIdDirty();
            }
            case 20: {
                return pSSysBIAggColumnBase.isPSSysBICubeLevelNameDirty();
            }
            case 21: {
                return pSSysBIAggColumnBase.isPSSysBICubeMeasureIdDirty();
            }
            case 22: {
                return pSSysBIAggColumnBase.isPSSysBICubeMeasureNameDirty();
            }
            case 23: {
                return pSSysBIAggColumnBase.isUpdateDateDirty();
            }
            case 24: {
                return pSSysBIAggColumnBase.isUpdateManDirty();
            }
            case 25: {
                return pSSysBIAggColumnBase.isUserCatDirty();
            }
            case 26: {
                return pSSysBIAggColumnBase.isUserTagDirty();
            }
            case 27: {
                return pSSysBIAggColumnBase.isUserTag2Dirty();
            }
            case 28: {
                return pSSysBIAggColumnBase.isUserTag3Dirty();
            }
            case 29: {
                return pSSysBIAggColumnBase.isUserTag4Dirty();
            }
            case 30: {
                return pSSysBIAggColumnBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBIAggColumnBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBIAggColumnBase pSSysBIAggColumnBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBIAggColumnBase.getBIAggColumnTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"biaggcolumntag", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getBIAggColumnTag()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getBIAggColumnTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"biaggcolumntag2", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getBIAggColumnTag2()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getBIAggColumnType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"biaggcolumntype", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getBIAggColumnType()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getDefaultValueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dvt", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getDefaultValueType()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBIAggColumnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbiaggcolumnid", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getPSSysBIAggColumnId()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBIAggColumnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbiaggcolumnname", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getPSSysBIAggColumnName()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBIAggTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbiaggtableid", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getPSSysBIAggTableId()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBIAggTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbiaggtablename", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getPSSysBIAggTableName()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBICubeDimensionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubedimensionid", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getPSSysBICubeDimensionId()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBICubeDimensionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubedimensionname", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getPSSysBICubeDimensionName()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBICubeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubeid", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getPSSysBICubeId()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBICubeLevelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubelevelid", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getPSSysBICubeLevelId()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBICubeLevelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubelevelname", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getPSSysBICubeLevelName()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBICubeMeasureId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubemeasureid", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getPSSysBICubeMeasureId()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBICubeMeasureName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubemeasurename", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getPSSysBICubeMeasureName()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysBIAggColumnBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysBIAggColumnBase.getJSONValue((Object)pSSysBIAggColumnBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBIAggColumnBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBIAggColumnBase pSSysBIAggColumnBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBIAggColumnBase.getBIAggColumnTag() != null) {
            object = pSSysBIAggColumnBase.getBIAggColumnTag();
            xmlNode.setAttribute(FIELD_BIAGGCOLUMNTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIAggColumnBase.getBIAggColumnTag2() != null) {
            object = pSSysBIAggColumnBase.getBIAggColumnTag2();
            xmlNode.setAttribute(FIELD_BIAGGCOLUMNTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIAggColumnBase.getBIAggColumnType() != null) {
            object = pSSysBIAggColumnBase.getBIAggColumnType();
            xmlNode.setAttribute(FIELD_BIAGGCOLUMNTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIAggColumnBase.getCodeName() != null) {
            object = pSSysBIAggColumnBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getCreateDate() != null) {
            object = pSSysBIAggColumnBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBIAggColumnBase.getCreateMan() != null) {
            object = pSSysBIAggColumnBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getDefaultValue() != null) {
            object = pSSysBIAggColumnBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getDefaultValueType() != null) {
            object = pSSysBIAggColumnBase.getDefaultValueType();
            xmlNode.setAttribute("DEFAULTVALUETYPE", object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getMemo() != null) {
            object = pSSysBIAggColumnBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getPSDEFId() != null) {
            object = pSSysBIAggColumnBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getPSDEFName() != null) {
            object = pSSysBIAggColumnBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getPSDEId() != null) {
            object = pSSysBIAggColumnBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBIAggColumnId() != null) {
            object = pSSysBIAggColumnBase.getPSSysBIAggColumnId();
            xmlNode.setAttribute(FIELD_PSSYSBIAGGCOLUMNID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBIAggColumnName() != null) {
            object = pSSysBIAggColumnBase.getPSSysBIAggColumnName();
            xmlNode.setAttribute(FIELD_PSSYSBIAGGCOLUMNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBIAggTableId() != null) {
            object = pSSysBIAggColumnBase.getPSSysBIAggTableId();
            xmlNode.setAttribute(FIELD_PSSYSBIAGGTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBIAggTableName() != null) {
            object = pSSysBIAggColumnBase.getPSSysBIAggTableName();
            xmlNode.setAttribute(FIELD_PSSYSBIAGGTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBICubeDimensionId() != null) {
            object = pSSysBIAggColumnBase.getPSSysBICubeDimensionId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEDIMENSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBICubeDimensionName() != null) {
            object = pSSysBIAggColumnBase.getPSSysBICubeDimensionName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEDIMENSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBICubeId() != null) {
            object = pSSysBIAggColumnBase.getPSSysBICubeId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBICubeLevelId() != null) {
            object = pSSysBIAggColumnBase.getPSSysBICubeLevelId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBELEVELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBICubeLevelName() != null) {
            object = pSSysBIAggColumnBase.getPSSysBICubeLevelName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBELEVELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBICubeMeasureId() != null) {
            object = pSSysBIAggColumnBase.getPSSysBICubeMeasureId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEMEASUREID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getPSSysBICubeMeasureName() != null) {
            object = pSSysBIAggColumnBase.getPSSysBICubeMeasureName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEMEASURENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getUpdateDate() != null) {
            object = pSSysBIAggColumnBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBIAggColumnBase.getUpdateMan() != null) {
            object = pSSysBIAggColumnBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getUserCat() != null) {
            object = pSSysBIAggColumnBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getUserTag() != null) {
            object = pSSysBIAggColumnBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getUserTag2() != null) {
            object = pSSysBIAggColumnBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getUserTag3() != null) {
            object = pSSysBIAggColumnBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getUserTag4() != null) {
            object = pSSysBIAggColumnBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIAggColumnBase.getValidFlag() != null) {
            object = pSSysBIAggColumnBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBIAggColumnBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBIAggColumnBase pSSysBIAggColumnBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBIAggColumnBase.isBIAggColumnTagDirty() && (bl || pSSysBIAggColumnBase.getBIAggColumnTag() != null)) {
            iDataObject.set(FIELD_BIAGGCOLUMNTAG, (Object)pSSysBIAggColumnBase.getBIAggColumnTag());
        }
        if (pSSysBIAggColumnBase.isBIAggColumnTag2Dirty() && (bl || pSSysBIAggColumnBase.getBIAggColumnTag2() != null)) {
            iDataObject.set(FIELD_BIAGGCOLUMNTAG2, (Object)pSSysBIAggColumnBase.getBIAggColumnTag2());
        }
        if (pSSysBIAggColumnBase.isBIAggColumnTypeDirty() && (bl || pSSysBIAggColumnBase.getBIAggColumnType() != null)) {
            iDataObject.set(FIELD_BIAGGCOLUMNTYPE, (Object)pSSysBIAggColumnBase.getBIAggColumnType());
        }
        if (pSSysBIAggColumnBase.isCodeNameDirty() && (bl || pSSysBIAggColumnBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBIAggColumnBase.getCodeName());
        }
        if (pSSysBIAggColumnBase.isCreateDateDirty() && (bl || pSSysBIAggColumnBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBIAggColumnBase.getCreateDate());
        }
        if (pSSysBIAggColumnBase.isCreateManDirty() && (bl || pSSysBIAggColumnBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBIAggColumnBase.getCreateMan());
        }
        if (pSSysBIAggColumnBase.isDefaultValueDirty() && (bl || pSSysBIAggColumnBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSSysBIAggColumnBase.getDefaultValue());
        }
        if (pSSysBIAggColumnBase.isDefaultValueTypeDirty() && (bl || pSSysBIAggColumnBase.getDefaultValueType() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUETYPE, (Object)pSSysBIAggColumnBase.getDefaultValueType());
        }
        if (pSSysBIAggColumnBase.isMemoDirty() && (bl || pSSysBIAggColumnBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBIAggColumnBase.getMemo());
        }
        if (pSSysBIAggColumnBase.isPSDEFIdDirty() && (bl || pSSysBIAggColumnBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSSysBIAggColumnBase.getPSDEFId());
        }
        if (pSSysBIAggColumnBase.isPSDEFNameDirty() && (bl || pSSysBIAggColumnBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSSysBIAggColumnBase.getPSDEFName());
        }
        if (pSSysBIAggColumnBase.isPSDEIdDirty() && (bl || pSSysBIAggColumnBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysBIAggColumnBase.getPSDEId());
        }
        if (pSSysBIAggColumnBase.isPSSysBIAggColumnIdDirty() && (bl || pSSysBIAggColumnBase.getPSSysBIAggColumnId() != null)) {
            iDataObject.set(FIELD_PSSYSBIAGGCOLUMNID, (Object)pSSysBIAggColumnBase.getPSSysBIAggColumnId());
        }
        if (pSSysBIAggColumnBase.isPSSysBIAggColumnNameDirty() && (bl || pSSysBIAggColumnBase.getPSSysBIAggColumnName() != null)) {
            iDataObject.set(FIELD_PSSYSBIAGGCOLUMNNAME, (Object)pSSysBIAggColumnBase.getPSSysBIAggColumnName());
        }
        if (pSSysBIAggColumnBase.isPSSysBIAggTableIdDirty() && (bl || pSSysBIAggColumnBase.getPSSysBIAggTableId() != null)) {
            iDataObject.set(FIELD_PSSYSBIAGGTABLEID, (Object)pSSysBIAggColumnBase.getPSSysBIAggTableId());
        }
        if (pSSysBIAggColumnBase.isPSSysBIAggTableNameDirty() && (bl || pSSysBIAggColumnBase.getPSSysBIAggTableName() != null)) {
            iDataObject.set(FIELD_PSSYSBIAGGTABLENAME, (Object)pSSysBIAggColumnBase.getPSSysBIAggTableName());
        }
        if (pSSysBIAggColumnBase.isPSSysBICubeDimensionIdDirty() && (bl || pSSysBIAggColumnBase.getPSSysBICubeDimensionId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEDIMENSIONID, (Object)pSSysBIAggColumnBase.getPSSysBICubeDimensionId());
        }
        if (pSSysBIAggColumnBase.isPSSysBICubeDimensionNameDirty() && (bl || pSSysBIAggColumnBase.getPSSysBICubeDimensionName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEDIMENSIONNAME, (Object)pSSysBIAggColumnBase.getPSSysBICubeDimensionName());
        }
        if (pSSysBIAggColumnBase.isPSSysBICubeIdDirty() && (bl || pSSysBIAggColumnBase.getPSSysBICubeId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEID, (Object)pSSysBIAggColumnBase.getPSSysBICubeId());
        }
        if (pSSysBIAggColumnBase.isPSSysBICubeLevelIdDirty() && (bl || pSSysBIAggColumnBase.getPSSysBICubeLevelId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBELEVELID, (Object)pSSysBIAggColumnBase.getPSSysBICubeLevelId());
        }
        if (pSSysBIAggColumnBase.isPSSysBICubeLevelNameDirty() && (bl || pSSysBIAggColumnBase.getPSSysBICubeLevelName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBELEVELNAME, (Object)pSSysBIAggColumnBase.getPSSysBICubeLevelName());
        }
        if (pSSysBIAggColumnBase.isPSSysBICubeMeasureIdDirty() && (bl || pSSysBIAggColumnBase.getPSSysBICubeMeasureId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEMEASUREID, (Object)pSSysBIAggColumnBase.getPSSysBICubeMeasureId());
        }
        if (pSSysBIAggColumnBase.isPSSysBICubeMeasureNameDirty() && (bl || pSSysBIAggColumnBase.getPSSysBICubeMeasureName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEMEASURENAME, (Object)pSSysBIAggColumnBase.getPSSysBICubeMeasureName());
        }
        if (pSSysBIAggColumnBase.isUpdateDateDirty() && (bl || pSSysBIAggColumnBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBIAggColumnBase.getUpdateDate());
        }
        if (pSSysBIAggColumnBase.isUpdateManDirty() && (bl || pSSysBIAggColumnBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBIAggColumnBase.getUpdateMan());
        }
        if (pSSysBIAggColumnBase.isUserCatDirty() && (bl || pSSysBIAggColumnBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBIAggColumnBase.getUserCat());
        }
        if (pSSysBIAggColumnBase.isUserTagDirty() && (bl || pSSysBIAggColumnBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBIAggColumnBase.getUserTag());
        }
        if (pSSysBIAggColumnBase.isUserTag2Dirty() && (bl || pSSysBIAggColumnBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBIAggColumnBase.getUserTag2());
        }
        if (pSSysBIAggColumnBase.isUserTag3Dirty() && (bl || pSSysBIAggColumnBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBIAggColumnBase.getUserTag3());
        }
        if (pSSysBIAggColumnBase.isUserTag4Dirty() && (bl || pSSysBIAggColumnBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBIAggColumnBase.getUserTag4());
        }
        if (pSSysBIAggColumnBase.isValidFlagDirty() && (bl || pSSysBIAggColumnBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysBIAggColumnBase.getValidFlag());
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
        return PSSysBIAggColumnBase.remove(this, n);
    }

    private static boolean remove(PSSysBIAggColumnBase pSSysBIAggColumnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBIAggColumnBase.resetBIAggColumnTag();
                return true;
            }
            case 1: {
                pSSysBIAggColumnBase.resetBIAggColumnTag2();
                return true;
            }
            case 2: {
                pSSysBIAggColumnBase.resetBIAggColumnType();
                return true;
            }
            case 3: {
                pSSysBIAggColumnBase.resetCodeName();
                return true;
            }
            case 4: {
                pSSysBIAggColumnBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSSysBIAggColumnBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSSysBIAggColumnBase.resetDefaultValue();
                return true;
            }
            case 7: {
                pSSysBIAggColumnBase.resetDefaultValueType();
                return true;
            }
            case 8: {
                pSSysBIAggColumnBase.resetMemo();
                return true;
            }
            case 9: {
                pSSysBIAggColumnBase.resetPSDEFId();
                return true;
            }
            case 10: {
                pSSysBIAggColumnBase.resetPSDEFName();
                return true;
            }
            case 11: {
                pSSysBIAggColumnBase.resetPSDEId();
                return true;
            }
            case 12: {
                pSSysBIAggColumnBase.resetPSSysBIAggColumnId();
                return true;
            }
            case 13: {
                pSSysBIAggColumnBase.resetPSSysBIAggColumnName();
                return true;
            }
            case 14: {
                pSSysBIAggColumnBase.resetPSSysBIAggTableId();
                return true;
            }
            case 15: {
                pSSysBIAggColumnBase.resetPSSysBIAggTableName();
                return true;
            }
            case 16: {
                pSSysBIAggColumnBase.resetPSSysBICubeDimensionId();
                return true;
            }
            case 17: {
                pSSysBIAggColumnBase.resetPSSysBICubeDimensionName();
                return true;
            }
            case 18: {
                pSSysBIAggColumnBase.resetPSSysBICubeId();
                return true;
            }
            case 19: {
                pSSysBIAggColumnBase.resetPSSysBICubeLevelId();
                return true;
            }
            case 20: {
                pSSysBIAggColumnBase.resetPSSysBICubeLevelName();
                return true;
            }
            case 21: {
                pSSysBIAggColumnBase.resetPSSysBICubeMeasureId();
                return true;
            }
            case 22: {
                pSSysBIAggColumnBase.resetPSSysBICubeMeasureName();
                return true;
            }
            case 23: {
                pSSysBIAggColumnBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSSysBIAggColumnBase.resetUpdateMan();
                return true;
            }
            case 25: {
                pSSysBIAggColumnBase.resetUserCat();
                return true;
            }
            case 26: {
                pSSysBIAggColumnBase.resetUserTag();
                return true;
            }
            case 27: {
                pSSysBIAggColumnBase.resetUserTag2();
                return true;
            }
            case 28: {
                pSSysBIAggColumnBase.resetUserTag3();
                return true;
            }
            case 29: {
                pSSysBIAggColumnBase.resetUserTag4();
                return true;
            }
            case 30: {
                pSSysBIAggColumnBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSSysBIAggTable getPSSysBIAggTable() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIAggTable();
        }
        if (this.getPSSysBIAggTableId() == null) {
            return null;
        }
        Integer n = this.objPSSysBIAggTableLock;
        synchronized (n) {
            if (this.pssysbiaggtable != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBIAggTableId(), (Object)this.pssysbiaggtable.getPSSysBIAggTableId()) != 0L) {
                this.pssysbiaggtable = null;
            }
            if (this.pssysbiaggtable == null) {
                PSSysBIAggTable pSSysBIAggTable = new PSSysBIAggTable();
                pSSysBIAggTable.setPSSysBIAggTableId(this.getPSSysBIAggTableId());
                PSSysBIAggTableService pSSysBIAggTableService = (PSSysBIAggTableService)ServiceGlobal.getService(PSSysBIAggTableService.class, (SessionFactory)this.getSessionFactory());
                pSSysBIAggTableService.autoGet(pSSysBIAggTable);
                this.pssysbiaggtable = pSSysBIAggTable;
            }
            return this.pssysbiaggtable;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBICubeDimension getPSSysBICubeDimension() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeDimension();
        }
        if (this.getPSSysBICubeDimensionId() == null) {
            return null;
        }
        Integer n = this.objPSSysBICubeDimensionLock;
        synchronized (n) {
            if (this.pssysbicubedimension != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBICubeDimensionId(), (Object)this.pssysbicubedimension.getPSSysBICubeDimensionId()) != 0L) {
                this.pssysbicubedimension = null;
            }
            if (this.pssysbicubedimension == null) {
                PSSysBICubeDimension pSSysBICubeDimension = new PSSysBICubeDimension();
                pSSysBICubeDimension.setPSSysBICubeDimensionId(this.getPSSysBICubeDimensionId());
                PSSysBICubeDimensionService pSSysBICubeDimensionService = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
                pSSysBICubeDimensionService.autoGet(pSSysBICubeDimension);
                this.pssysbicubedimension = pSSysBICubeDimension;
            }
            return this.pssysbicubedimension;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBICubeLevel getPSSysBICubeLevel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeLevel();
        }
        if (this.getPSSysBICubeLevelId() == null) {
            return null;
        }
        Integer n = this.objPSSysBICubeLevelLock;
        synchronized (n) {
            if (this.pssysbicubelevel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBICubeLevelId(), (Object)this.pssysbicubelevel.getPSSysBICubeLevelId()) != 0L) {
                this.pssysbicubelevel = null;
            }
            if (this.pssysbicubelevel == null) {
                PSSysBICubeLevel pSSysBICubeLevel = new PSSysBICubeLevel();
                pSSysBICubeLevel.setPSSysBICubeLevelId(this.getPSSysBICubeLevelId());
                PSSysBICubeLevelService pSSysBICubeLevelService = (PSSysBICubeLevelService)ServiceGlobal.getService(PSSysBICubeLevelService.class, (SessionFactory)this.getSessionFactory());
                pSSysBICubeLevelService.autoGet(pSSysBICubeLevel);
                this.pssysbicubelevel = pSSysBICubeLevel;
            }
            return this.pssysbicubelevel;
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

    private PSSysBIAggColumnBase getProxyEntity() {
        return this.proxyPSSysBIAggColumnBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBIAggColumnBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBIAggColumnBase) {
            this.proxyPSSysBIAggColumnBase = (PSSysBIAggColumnBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggColumnService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BIAGGCOLUMNTAG, 0);
        fieldIndexMap.put(FIELD_BIAGGCOLUMNTAG2, 1);
        fieldIndexMap.put(FIELD_BIAGGCOLUMNTYPE, 2);
        fieldIndexMap.put(FIELD_CODENAME, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 6);
        fieldIndexMap.put(FIELD_DEFAULTVALUETYPE, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_PSDEFID, 9);
        fieldIndexMap.put(FIELD_PSDEFNAME, 10);
        fieldIndexMap.put(FIELD_PSDEID, 11);
        fieldIndexMap.put(FIELD_PSSYSBIAGGCOLUMNID, 12);
        fieldIndexMap.put(FIELD_PSSYSBIAGGCOLUMNNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSBIAGGTABLEID, 14);
        fieldIndexMap.put(FIELD_PSSYSBIAGGTABLENAME, 15);
        fieldIndexMap.put(FIELD_PSSYSBICUBEDIMENSIONID, 16);
        fieldIndexMap.put(FIELD_PSSYSBICUBEDIMENSIONNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSBICUBEID, 18);
        fieldIndexMap.put(FIELD_PSSYSBICUBELEVELID, 19);
        fieldIndexMap.put(FIELD_PSSYSBICUBELEVELNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSBICUBEMEASUREID, 21);
        fieldIndexMap.put(FIELD_PSSYSBICUBEMEASURENAME, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
        fieldIndexMap.put(FIELD_USERCAT, 25);
        fieldIndexMap.put(FIELD_USERTAG, 26);
        fieldIndexMap.put(FIELD_USERTAG2, 27);
        fieldIndexMap.put(FIELD_USERTAG3, 28);
        fieldIndexMap.put(FIELD_USERTAG4, 29);
        fieldIndexMap.put(FIELD_VALIDFLAG, 30);
    }
}

