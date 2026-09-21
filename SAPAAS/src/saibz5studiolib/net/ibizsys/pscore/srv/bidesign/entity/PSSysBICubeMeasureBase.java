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
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICube;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSThresholdGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBICubeMeasureBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBICubeMeasureBase.class);
    public static final String FIELD_AGGTYPE = "AGGTYPE";
    public static final String FIELD_BICUBEMEASURETAG = "BICUBEMEASURETAG";
    public static final String FIELD_BICUBEMEASURETAG2 = "BICUBEMEASURETAG2";
    public static final String FIELD_BIMEASUREGROUP = "BIMEASUREGROUP";
    public static final String FIELD_BIMEASURETYPE = "BIMEASURETYPE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DRILLDETAILCUSTOMCOND = "DRILLDETAILCUSTOMCOND";
    public static final String FIELD_DRILLDETAILCUSTOMTYPE = "DRILLDETAILCUSTOMTYPE";
    public static final String FIELD_DRILLDETAILPSDEVIEWID = "DRILLDETAILPSDEVIEWID";
    public static final String FIELD_DRILLDETAILPSDEVIEWNAME = "DRILLDETAILPSDEVIEWNAME";
    public static final String FIELD_DRILLDOWNCUSTOMCOND = "DRILLDOWNCUSTOMCOND";
    public static final String FIELD_DRILLDOWNCUSTOMTYPE = "DRILLDOWNCUSTOMTYPE";
    public static final String FIELD_DRILLDOWNPSDEVIEWID = "DRILLDOWNPSDEVIEWID";
    public static final String FIELD_DRILLDOWNPSDEVIEWNAME = "DRILLDOWNPSDEVIEWNAME";
    public static final String FIELD_HIDDENDATAITEM = "HIDDENDATAITEM";
    public static final String FIELD_JSONFORMAT = "JSONFORMAT";
    public static final String FIELD_MEASUREFORMULA = "MEASUREFORMULA";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMPSDEUIACTIONID = "PARAMPSDEUIACTIONID";
    public static final String FIELD_PARAMPSDEUIACTIONNAME = "PARAMPSDEUIACTIONNAME";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String FIELD_PSSYSBICUBEMEASUREID = "PSSYSBICUBEMEASUREID";
    public static final String FIELD_PSSYSBICUBEMEASURENAME = "PSSYSBICUBEMEASURENAME";
    public static final String FIELD_PSSYSBICUBENAME = "PSSYSBICUBENAME";
    public static final String FIELD_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String FIELD_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String FIELD_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String FIELD_PSTHRESHOLDGROUPID = "PSTHRESHOLDGROUPID";
    public static final String FIELD_PSTHRESHOLDGROUPNAME = "PSTHRESHOLDGROUPNAME";
    public static final String FIELD_STDDATATYPE = "STDDATATYPE";
    public static final String FIELD_TEXTTEMPLATE = "TEXTTEMPLATE";
    public static final String FIELD_TIPTEMPLATE = "TIPTEMPLATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUEFORMAT = "VALUEFORMAT";
    private static final int INDEX_AGGTYPE = 0;
    private static final int INDEX_BICUBEMEASURETAG = 1;
    private static final int INDEX_BICUBEMEASURETAG2 = 2;
    private static final int INDEX_BIMEASUREGROUP = 3;
    private static final int INDEX_BIMEASURETYPE = 4;
    private static final int INDEX_CODENAME = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_DRILLDETAILCUSTOMCOND = 8;
    private static final int INDEX_DRILLDETAILCUSTOMTYPE = 9;
    private static final int INDEX_DRILLDETAILPSDEVIEWID = 10;
    private static final int INDEX_DRILLDETAILPSDEVIEWNAME = 11;
    private static final int INDEX_DRILLDOWNCUSTOMCOND = 12;
    private static final int INDEX_DRILLDOWNCUSTOMTYPE = 13;
    private static final int INDEX_DRILLDOWNPSDEVIEWID = 14;
    private static final int INDEX_DRILLDOWNPSDEVIEWNAME = 15;
    private static final int INDEX_HIDDENDATAITEM = 16;
    private static final int INDEX_JSONFORMAT = 17;
    private static final int INDEX_MEASUREFORMULA = 18;
    private static final int INDEX_MEMO = 19;
    private static final int INDEX_ORDERVALUE = 20;
    private static final int INDEX_PARAMPSDEUIACTIONID = 21;
    private static final int INDEX_PARAMPSDEUIACTIONNAME = 22;
    private static final int INDEX_PSCODELISTID = 23;
    private static final int INDEX_PSCODELISTNAME = 24;
    private static final int INDEX_PSDEFID = 25;
    private static final int INDEX_PSDEFNAME = 26;
    private static final int INDEX_PSDEID = 27;
    private static final int INDEX_PSSYSBICUBEID = 28;
    private static final int INDEX_PSSYSBICUBEMEASUREID = 29;
    private static final int INDEX_PSSYSBICUBEMEASURENAME = 30;
    private static final int INDEX_PSSYSBICUBENAME = 31;
    private static final int INDEX_PSSYSBISCHEMEID = 32;
    private static final int INDEX_PSSYSTRANSLATORID = 33;
    private static final int INDEX_PSSYSTRANSLATORNAME = 34;
    private static final int INDEX_PSTHRESHOLDGROUPID = 35;
    private static final int INDEX_PSTHRESHOLDGROUPNAME = 36;
    private static final int INDEX_STDDATATYPE = 37;
    private static final int INDEX_TEXTTEMPLATE = 38;
    private static final int INDEX_TIPTEMPLATE = 39;
    private static final int INDEX_UPDATEDATE = 40;
    private static final int INDEX_UPDATEMAN = 41;
    private static final int INDEX_USERCAT = 42;
    private static final int INDEX_USERTAG = 43;
    private static final int INDEX_USERTAG2 = 44;
    private static final int INDEX_USERTAG3 = 45;
    private static final int INDEX_USERTAG4 = 46;
    private static final int INDEX_VALIDFLAG = 47;
    private static final int INDEX_VALUEFORMAT = 48;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBICubeMeasureBase proxyPSSysBICubeMeasureBase = null;
    private boolean aggtypeDirtyFlag = false;
    private boolean bicubemeasuretagDirtyFlag = false;
    private boolean bicubemeasuretag2DirtyFlag = false;
    private boolean bimeasuregroupDirtyFlag = false;
    private boolean bimeasuretypeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean drilldetailcustomcondDirtyFlag = false;
    private boolean drilldetailcustomtypeDirtyFlag = false;
    private boolean drilldetailpsdeviewidDirtyFlag = false;
    private boolean drilldetailpsdeviewnameDirtyFlag = false;
    private boolean drilldowncustomcondDirtyFlag = false;
    private boolean drilldowncustomtypeDirtyFlag = false;
    private boolean drilldownpsdeviewidDirtyFlag = false;
    private boolean drilldownpsdeviewnameDirtyFlag = false;
    private boolean hiddendataitemDirtyFlag = false;
    private boolean jsonformatDirtyFlag = false;
    private boolean measureformulaDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean parampsdeuiactionidDirtyFlag = false;
    private boolean parampsdeuiactionnameDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssysbicubeidDirtyFlag = false;
    private boolean pssysbicubemeasureidDirtyFlag = false;
    private boolean pssysbicubemeasurenameDirtyFlag = false;
    private boolean pssysbicubenameDirtyFlag = false;
    private boolean pssysbischemeidDirtyFlag = false;
    private boolean pssystranslatoridDirtyFlag = false;
    private boolean pssystranslatornameDirtyFlag = false;
    private boolean psthresholdgroupidDirtyFlag = false;
    private boolean psthresholdgroupnameDirtyFlag = false;
    private boolean stddatatypeDirtyFlag = false;
    private boolean texttemplateDirtyFlag = false;
    private boolean tiptemplateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valueformatDirtyFlag = false;
    @Column(name="aggtype")
    private String aggtype;
    @Column(name="bicubemeasuretag")
    private String bicubemeasuretag;
    @Column(name="bicubemeasuretag2")
    private String bicubemeasuretag2;
    @Column(name="bimeasuregroup")
    private String bimeasuregroup;
    @Column(name="bimeasuretype")
    private String bimeasuretype;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="drilldetailcustomcond")
    private String drilldetailcustomcond;
    @Column(name="drilldetailcustomtype")
    private String drilldetailcustomtype;
    @Column(name="drilldetailpsdeviewid")
    private String drilldetailpsdeviewid;
    @Column(name="drilldetailpsdeviewname")
    private String drilldetailpsdeviewname;
    @Column(name="drilldowncustomcond")
    private String drilldowncustomcond;
    @Column(name="drilldowncustomtype")
    private String drilldowncustomtype;
    @Column(name="drilldownpsdeviewid")
    private String drilldownpsdeviewid;
    @Column(name="drilldownpsdeviewname")
    private String drilldownpsdeviewname;
    @Column(name="hiddendataitem")
    private Integer hiddendataitem;
    @Column(name="jsonformat")
    private String jsonformat;
    @Column(name="measureformula")
    private String measureformula;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="parampsdeuiactionid")
    private String parampsdeuiactionid;
    @Column(name="parampsdeuiactionname")
    private String parampsdeuiactionname;
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
    @Column(name="pssysbicubeid")
    private String pssysbicubeid;
    @Column(name="pssysbicubemeasureid")
    private String pssysbicubemeasureid;
    @Column(name="pssysbicubemeasurename")
    private String pssysbicubemeasurename;
    @Column(name="pssysbicubename")
    private String pssysbicubename;
    @Column(name="pssysbischemeid")
    private String pssysbischemeid;
    @Column(name="pssystranslatorid")
    private String pssystranslatorid;
    @Column(name="pssystranslatorname")
    private String pssystranslatorname;
    @Column(name="psthresholdgroupid")
    private String psthresholdgroupid;
    @Column(name="psthresholdgroupname")
    private String psthresholdgroupname;
    @Column(name="stddatatype")
    private Integer stddatatype;
    @Column(name="texttemplate")
    private String texttemplate;
    @Column(name="tiptemplate")
    private String tiptemplate;
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
    @Column(name="valueformat")
    private String valueformat;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objParamPSDEUIActionLock = new Integer(1);
    private PSDEUIAction parampsdeuiaction = null;
    private Integer objDrillDetailPSDEViewLock = new Integer(1);
    private PSDEViewBase drilldetailpsdeview = null;
    private Integer objDrillDownPSDEViewLock = new Integer(1);
    private PSDEViewBase drilldownpsdeview = null;
    private Integer objPSSysBICubeLock = new Integer(1);
    private PSSysBICube pssysbicube = null;
    private Integer objPSSysTranslatorLock = new Integer(1);
    private PSSysTranslator pssystranslator = null;
    private Integer objPSThresholdGroupLock = new Integer(1);
    private PSThresholdGroup psthresholdgroup = null;

    public void setAggType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggtype = string;
        this.aggtypeDirtyFlag = true;
    }

    public String getAggType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggType();
        }
        return this.aggtype;
    }

    public boolean isAggTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggTypeDirty();
        }
        return this.aggtypeDirtyFlag;
    }

    public void resetAggType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggType();
            return;
        }
        this.aggtypeDirtyFlag = false;
        this.aggtype = null;
    }

    public void setBICubeMeasureTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBICubeMeasureTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bicubemeasuretag = string;
        this.bicubemeasuretagDirtyFlag = true;
    }

    public String getBICubeMeasureTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBICubeMeasureTag();
        }
        return this.bicubemeasuretag;
    }

    public boolean isBICubeMeasureTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBICubeMeasureTagDirty();
        }
        return this.bicubemeasuretagDirtyFlag;
    }

    public void resetBICubeMeasureTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBICubeMeasureTag();
            return;
        }
        this.bicubemeasuretagDirtyFlag = false;
        this.bicubemeasuretag = null;
    }

    public void setBICubeMeasureTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBICubeMeasureTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bicubemeasuretag2 = string;
        this.bicubemeasuretag2DirtyFlag = true;
    }

    public String getBICubeMeasureTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBICubeMeasureTag2();
        }
        return this.bicubemeasuretag2;
    }

    public boolean isBICubeMeasureTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBICubeMeasureTag2Dirty();
        }
        return this.bicubemeasuretag2DirtyFlag;
    }

    public void resetBICubeMeasureTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBICubeMeasureTag2();
            return;
        }
        this.bicubemeasuretag2DirtyFlag = false;
        this.bicubemeasuretag2 = null;
    }

    public void setBIMeasureGroup(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIMeasureGroup(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bimeasuregroup = string;
        this.bimeasuregroupDirtyFlag = true;
    }

    public String getBIMeasureGroup() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIMeasureGroup();
        }
        return this.bimeasuregroup;
    }

    public boolean isBIMeasureGroupDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIMeasureGroupDirty();
        }
        return this.bimeasuregroupDirtyFlag;
    }

    public void resetBIMeasureGroup() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIMeasureGroup();
            return;
        }
        this.bimeasuregroupDirtyFlag = false;
        this.bimeasuregroup = null;
    }

    public void setBIMeasureType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIMeasureType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bimeasuretype = string;
        this.bimeasuretypeDirtyFlag = true;
    }

    public String getBIMeasureType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIMeasureType();
        }
        return this.bimeasuretype;
    }

    public boolean isBIMeasureTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIMeasureTypeDirty();
        }
        return this.bimeasuretypeDirtyFlag;
    }

    public void resetBIMeasureType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIMeasureType();
            return;
        }
        this.bimeasuretypeDirtyFlag = false;
        this.bimeasuretype = null;
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

    public void setDrillDetailCustomCond(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDrillDetailCustomCond(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drilldetailcustomcond = string;
        this.drilldetailcustomcondDirtyFlag = true;
    }

    public String getDrillDetailCustomCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDetailCustomCond();
        }
        return this.drilldetailcustomcond;
    }

    public boolean isDrillDetailCustomCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDrillDetailCustomCondDirty();
        }
        return this.drilldetailcustomcondDirtyFlag;
    }

    public void resetDrillDetailCustomCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDrillDetailCustomCond();
            return;
        }
        this.drilldetailcustomcondDirtyFlag = false;
        this.drilldetailcustomcond = null;
    }

    public void setDrillDetailCustomType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDrillDetailCustomType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drilldetailcustomtype = string;
        this.drilldetailcustomtypeDirtyFlag = true;
    }

    public String getDrillDetailCustomType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDetailCustomType();
        }
        return this.drilldetailcustomtype;
    }

    public boolean isDrillDetailCustomTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDrillDetailCustomTypeDirty();
        }
        return this.drilldetailcustomtypeDirtyFlag;
    }

    public void resetDrillDetailCustomType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDrillDetailCustomType();
            return;
        }
        this.drilldetailcustomtypeDirtyFlag = false;
        this.drilldetailcustomtype = null;
    }

    public void setDrillDetailPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDrillDetailPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drilldetailpsdeviewid = string;
        this.drilldetailpsdeviewidDirtyFlag = true;
    }

    public String getDrillDetailPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDetailPSDEViewId();
        }
        return this.drilldetailpsdeviewid;
    }

    public boolean isDrillDetailPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDrillDetailPSDEViewIdDirty();
        }
        return this.drilldetailpsdeviewidDirtyFlag;
    }

    public void resetDrillDetailPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDrillDetailPSDEViewId();
            return;
        }
        this.drilldetailpsdeviewidDirtyFlag = false;
        this.drilldetailpsdeviewid = null;
    }

    public void setDrillDetailPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDrillDetailPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drilldetailpsdeviewname = string;
        this.drilldetailpsdeviewnameDirtyFlag = true;
    }

    public String getDrillDetailPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDetailPSDEViewName();
        }
        return this.drilldetailpsdeviewname;
    }

    public boolean isDrillDetailPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDrillDetailPSDEViewNameDirty();
        }
        return this.drilldetailpsdeviewnameDirtyFlag;
    }

    public void resetDrillDetailPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDrillDetailPSDEViewName();
            return;
        }
        this.drilldetailpsdeviewnameDirtyFlag = false;
        this.drilldetailpsdeviewname = null;
    }

    public void setDrillDownCustomCond(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDrillDownCustomCond(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drilldowncustomcond = string;
        this.drilldowncustomcondDirtyFlag = true;
    }

    public String getDrillDownCustomCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDownCustomCond();
        }
        return this.drilldowncustomcond;
    }

    public boolean isDrillDownCustomCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDrillDownCustomCondDirty();
        }
        return this.drilldowncustomcondDirtyFlag;
    }

    public void resetDrillDownCustomCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDrillDownCustomCond();
            return;
        }
        this.drilldowncustomcondDirtyFlag = false;
        this.drilldowncustomcond = null;
    }

    public void setDrillDownCustomType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDrillDownCustomType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drilldowncustomtype = string;
        this.drilldowncustomtypeDirtyFlag = true;
    }

    public String getDrillDownCustomType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDownCustomType();
        }
        return this.drilldowncustomtype;
    }

    public boolean isDrillDownCustomTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDrillDownCustomTypeDirty();
        }
        return this.drilldowncustomtypeDirtyFlag;
    }

    public void resetDrillDownCustomType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDrillDownCustomType();
            return;
        }
        this.drilldowncustomtypeDirtyFlag = false;
        this.drilldowncustomtype = null;
    }

    public void setDrillDownPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDrillDownPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drilldownpsdeviewid = string;
        this.drilldownpsdeviewidDirtyFlag = true;
    }

    public String getDrillDownPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDownPSDEViewId();
        }
        return this.drilldownpsdeviewid;
    }

    public boolean isDrillDownPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDrillDownPSDEViewIdDirty();
        }
        return this.drilldownpsdeviewidDirtyFlag;
    }

    public void resetDrillDownPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDrillDownPSDEViewId();
            return;
        }
        this.drilldownpsdeviewidDirtyFlag = false;
        this.drilldownpsdeviewid = null;
    }

    public void setDrillDownPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDrillDownPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drilldownpsdeviewname = string;
        this.drilldownpsdeviewnameDirtyFlag = true;
    }

    public String getDrillDownPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDownPSDEViewName();
        }
        return this.drilldownpsdeviewname;
    }

    public boolean isDrillDownPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDrillDownPSDEViewNameDirty();
        }
        return this.drilldownpsdeviewnameDirtyFlag;
    }

    public void resetDrillDownPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDrillDownPSDEViewName();
            return;
        }
        this.drilldownpsdeviewnameDirtyFlag = false;
        this.drilldownpsdeviewname = null;
    }

    public void setHiddenDataItem(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHiddenDataItem(n);
            return;
        }
        this.hiddendataitem = n;
        this.hiddendataitemDirtyFlag = true;
    }

    public Integer getHiddenDataItem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHiddenDataItem();
        }
        return this.hiddendataitem;
    }

    public boolean isHiddenDataItemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHiddenDataItemDirty();
        }
        return this.hiddendataitemDirtyFlag;
    }

    public void resetHiddenDataItem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHiddenDataItem();
            return;
        }
        this.hiddendataitemDirtyFlag = false;
        this.hiddendataitem = null;
    }

    public void setJsonFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJsonFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jsonformat = string;
        this.jsonformatDirtyFlag = true;
    }

    public String getJsonFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJsonFormat();
        }
        return this.jsonformat;
    }

    public boolean isJsonFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJsonFormatDirty();
        }
        return this.jsonformatDirtyFlag;
    }

    public void resetJsonFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJsonFormat();
            return;
        }
        this.jsonformatDirtyFlag = false;
        this.jsonformat = null;
    }

    public void setMeasureFormula(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMeasureFormula(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.measureformula = string;
        this.measureformulaDirtyFlag = true;
    }

    public String getMeasureFormula() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMeasureFormula();
        }
        return this.measureformula;
    }

    public boolean isMeasureFormulaDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMeasureFormulaDirty();
        }
        return this.measureformulaDirtyFlag;
    }

    public void resetMeasureFormula() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMeasureFormula();
            return;
        }
        this.measureformulaDirtyFlag = false;
        this.measureformula = null;
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

    public void setParamPSDEUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamPSDEUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.parampsdeuiactionid = string;
        this.parampsdeuiactionidDirtyFlag = true;
    }

    public String getParamPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSDEUIActionId();
        }
        return this.parampsdeuiactionid;
    }

    public boolean isParamPSDEUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamPSDEUIActionIdDirty();
        }
        return this.parampsdeuiactionidDirtyFlag;
    }

    public void resetParamPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamPSDEUIActionId();
            return;
        }
        this.parampsdeuiactionidDirtyFlag = false;
        this.parampsdeuiactionid = null;
    }

    public void setParamPSDEUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamPSDEUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.parampsdeuiactionname = string;
        this.parampsdeuiactionnameDirtyFlag = true;
    }

    public String getParamPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSDEUIActionName();
        }
        return this.parampsdeuiactionname;
    }

    public boolean isParamPSDEUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamPSDEUIActionNameDirty();
        }
        return this.parampsdeuiactionnameDirtyFlag;
    }

    public void resetParamPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamPSDEUIActionName();
            return;
        }
        this.parampsdeuiactionnameDirtyFlag = false;
        this.parampsdeuiactionname = null;
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

    public void setPSSysBICubeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubename = string;
        this.pssysbicubenameDirtyFlag = true;
    }

    public String getPSSysBICubeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeName();
        }
        return this.pssysbicubename;
    }

    public boolean isPSSysBICubeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeNameDirty();
        }
        return this.pssysbicubenameDirtyFlag;
    }

    public void resetPSSysBICubeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeName();
            return;
        }
        this.pssysbicubenameDirtyFlag = false;
        this.pssysbicubename = null;
    }

    public void setPSSysBISchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBISchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbischemeid = string;
        this.pssysbischemeidDirtyFlag = true;
    }

    public String getPSSysBISchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBISchemeId();
        }
        return this.pssysbischemeid;
    }

    public boolean isPSSysBISchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBISchemeIdDirty();
        }
        return this.pssysbischemeidDirtyFlag;
    }

    public void resetPSSysBISchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBISchemeId();
            return;
        }
        this.pssysbischemeidDirtyFlag = false;
        this.pssysbischemeid = null;
    }

    public void setPSSysTranslatorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorid = string;
        this.pssystranslatoridDirtyFlag = true;
    }

    public String getPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorId();
        }
        return this.pssystranslatorid;
    }

    public boolean isPSSysTranslatorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorIdDirty();
        }
        return this.pssystranslatoridDirtyFlag;
    }

    public void resetPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorId();
            return;
        }
        this.pssystranslatoridDirtyFlag = false;
        this.pssystranslatorid = null;
    }

    public void setPSSysTranslatorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorname = string;
        this.pssystranslatornameDirtyFlag = true;
    }

    public String getPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorName();
        }
        return this.pssystranslatorname;
    }

    public boolean isPSSysTranslatorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorNameDirty();
        }
        return this.pssystranslatornameDirtyFlag;
    }

    public void resetPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorName();
            return;
        }
        this.pssystranslatornameDirtyFlag = false;
        this.pssystranslatorname = null;
    }

    public void setPSThresholdGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSThresholdGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psthresholdgroupid = string;
        this.psthresholdgroupidDirtyFlag = true;
    }

    public String getPSThresholdGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSThresholdGroupId();
        }
        return this.psthresholdgroupid;
    }

    public boolean isPSThresholdGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSThresholdGroupIdDirty();
        }
        return this.psthresholdgroupidDirtyFlag;
    }

    public void resetPSThresholdGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSThresholdGroupId();
            return;
        }
        this.psthresholdgroupidDirtyFlag = false;
        this.psthresholdgroupid = null;
    }

    public void setPSThresholdGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSThresholdGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psthresholdgroupname = string;
        this.psthresholdgroupnameDirtyFlag = true;
    }

    public String getPSThresholdGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSThresholdGroupName();
        }
        return this.psthresholdgroupname;
    }

    public boolean isPSThresholdGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSThresholdGroupNameDirty();
        }
        return this.psthresholdgroupnameDirtyFlag;
    }

    public void resetPSThresholdGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSThresholdGroupName();
            return;
        }
        this.psthresholdgroupnameDirtyFlag = false;
        this.psthresholdgroupname = null;
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

    public void setTextTemplate(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextTemplate(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.texttemplate = string;
        this.texttemplateDirtyFlag = true;
    }

    public String getTextTemplate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextTemplate();
        }
        return this.texttemplate;
    }

    public boolean isTextTemplateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextTemplateDirty();
        }
        return this.texttemplateDirtyFlag;
    }

    public void resetTextTemplate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextTemplate();
            return;
        }
        this.texttemplateDirtyFlag = false;
        this.texttemplate = null;
    }

    public void setTipTemplate(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipTemplate(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tiptemplate = string;
        this.tiptemplateDirtyFlag = true;
    }

    public String getTipTemplate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipTemplate();
        }
        return this.tiptemplate;
    }

    public boolean isTipTemplateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipTemplateDirty();
        }
        return this.tiptemplateDirtyFlag;
    }

    public void resetTipTemplate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipTemplate();
            return;
        }
        this.tiptemplateDirtyFlag = false;
        this.tiptemplate = null;
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

    public void setValueFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valueformat = string;
        this.valueformatDirtyFlag = true;
    }

    public String getValueFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueFormat();
        }
        return this.valueformat;
    }

    public boolean isValueFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueFormatDirty();
        }
        return this.valueformatDirtyFlag;
    }

    public void resetValueFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueFormat();
            return;
        }
        this.valueformatDirtyFlag = false;
        this.valueformat = null;
    }

    protected void onReset() {
        PSSysBICubeMeasureBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBICubeMeasureBase pSSysBICubeMeasureBase) {
        pSSysBICubeMeasureBase.resetAggType();
        pSSysBICubeMeasureBase.resetBICubeMeasureTag();
        pSSysBICubeMeasureBase.resetBICubeMeasureTag2();
        pSSysBICubeMeasureBase.resetBIMeasureGroup();
        pSSysBICubeMeasureBase.resetBIMeasureType();
        pSSysBICubeMeasureBase.resetCodeName();
        pSSysBICubeMeasureBase.resetCreateDate();
        pSSysBICubeMeasureBase.resetCreateMan();
        pSSysBICubeMeasureBase.resetDrillDetailCustomCond();
        pSSysBICubeMeasureBase.resetDrillDetailCustomType();
        pSSysBICubeMeasureBase.resetDrillDetailPSDEViewId();
        pSSysBICubeMeasureBase.resetDrillDetailPSDEViewName();
        pSSysBICubeMeasureBase.resetDrillDownCustomCond();
        pSSysBICubeMeasureBase.resetDrillDownCustomType();
        pSSysBICubeMeasureBase.resetDrillDownPSDEViewId();
        pSSysBICubeMeasureBase.resetDrillDownPSDEViewName();
        pSSysBICubeMeasureBase.resetHiddenDataItem();
        pSSysBICubeMeasureBase.resetJsonFormat();
        pSSysBICubeMeasureBase.resetMeasureFormula();
        pSSysBICubeMeasureBase.resetMemo();
        pSSysBICubeMeasureBase.resetOrderValue();
        pSSysBICubeMeasureBase.resetParamPSDEUIActionId();
        pSSysBICubeMeasureBase.resetParamPSDEUIActionName();
        pSSysBICubeMeasureBase.resetPSCodeListId();
        pSSysBICubeMeasureBase.resetPSCodeListName();
        pSSysBICubeMeasureBase.resetPSDEFId();
        pSSysBICubeMeasureBase.resetPSDEFName();
        pSSysBICubeMeasureBase.resetPSDEId();
        pSSysBICubeMeasureBase.resetPSSysBICubeId();
        pSSysBICubeMeasureBase.resetPSSysBICubeMeasureId();
        pSSysBICubeMeasureBase.resetPSSysBICubeMeasureName();
        pSSysBICubeMeasureBase.resetPSSysBICubeName();
        pSSysBICubeMeasureBase.resetPSSysBISchemeId();
        pSSysBICubeMeasureBase.resetPSSysTranslatorId();
        pSSysBICubeMeasureBase.resetPSSysTranslatorName();
        pSSysBICubeMeasureBase.resetPSThresholdGroupId();
        pSSysBICubeMeasureBase.resetPSThresholdGroupName();
        pSSysBICubeMeasureBase.resetStdDataType();
        pSSysBICubeMeasureBase.resetTextTemplate();
        pSSysBICubeMeasureBase.resetTipTemplate();
        pSSysBICubeMeasureBase.resetUpdateDate();
        pSSysBICubeMeasureBase.resetUpdateMan();
        pSSysBICubeMeasureBase.resetUserCat();
        pSSysBICubeMeasureBase.resetUserTag();
        pSSysBICubeMeasureBase.resetUserTag2();
        pSSysBICubeMeasureBase.resetUserTag3();
        pSSysBICubeMeasureBase.resetUserTag4();
        pSSysBICubeMeasureBase.resetValidFlag();
        pSSysBICubeMeasureBase.resetValueFormat();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAggTypeDirty()) {
            hashMap.put(FIELD_AGGTYPE, this.getAggType());
        }
        if (!bl || this.isBICubeMeasureTagDirty()) {
            hashMap.put(FIELD_BICUBEMEASURETAG, this.getBICubeMeasureTag());
        }
        if (!bl || this.isBICubeMeasureTag2Dirty()) {
            hashMap.put(FIELD_BICUBEMEASURETAG2, this.getBICubeMeasureTag2());
        }
        if (!bl || this.isBIMeasureGroupDirty()) {
            hashMap.put(FIELD_BIMEASUREGROUP, this.getBIMeasureGroup());
        }
        if (!bl || this.isBIMeasureTypeDirty()) {
            hashMap.put(FIELD_BIMEASURETYPE, this.getBIMeasureType());
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
        if (!bl || this.isDrillDetailCustomCondDirty()) {
            hashMap.put(FIELD_DRILLDETAILCUSTOMCOND, this.getDrillDetailCustomCond());
        }
        if (!bl || this.isDrillDetailCustomTypeDirty()) {
            hashMap.put(FIELD_DRILLDETAILCUSTOMTYPE, this.getDrillDetailCustomType());
        }
        if (!bl || this.isDrillDetailPSDEViewIdDirty()) {
            hashMap.put(FIELD_DRILLDETAILPSDEVIEWID, this.getDrillDetailPSDEViewId());
        }
        if (!bl || this.isDrillDetailPSDEViewNameDirty()) {
            hashMap.put(FIELD_DRILLDETAILPSDEVIEWNAME, this.getDrillDetailPSDEViewName());
        }
        if (!bl || this.isDrillDownCustomCondDirty()) {
            hashMap.put(FIELD_DRILLDOWNCUSTOMCOND, this.getDrillDownCustomCond());
        }
        if (!bl || this.isDrillDownCustomTypeDirty()) {
            hashMap.put(FIELD_DRILLDOWNCUSTOMTYPE, this.getDrillDownCustomType());
        }
        if (!bl || this.isDrillDownPSDEViewIdDirty()) {
            hashMap.put(FIELD_DRILLDOWNPSDEVIEWID, this.getDrillDownPSDEViewId());
        }
        if (!bl || this.isDrillDownPSDEViewNameDirty()) {
            hashMap.put(FIELD_DRILLDOWNPSDEVIEWNAME, this.getDrillDownPSDEViewName());
        }
        if (!bl || this.isHiddenDataItemDirty()) {
            hashMap.put(FIELD_HIDDENDATAITEM, this.getHiddenDataItem());
        }
        if (!bl || this.isJsonFormatDirty()) {
            hashMap.put(FIELD_JSONFORMAT, this.getJsonFormat());
        }
        if (!bl || this.isMeasureFormulaDirty()) {
            hashMap.put(FIELD_MEASUREFORMULA, this.getMeasureFormula());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isParamPSDEUIActionIdDirty()) {
            hashMap.put(FIELD_PARAMPSDEUIACTIONID, this.getParamPSDEUIActionId());
        }
        if (!bl || this.isParamPSDEUIActionNameDirty()) {
            hashMap.put(FIELD_PARAMPSDEUIACTIONNAME, this.getParamPSDEUIActionName());
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
        if (!bl || this.isPSSysBICubeIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEID, this.getPSSysBICubeId());
        }
        if (!bl || this.isPSSysBICubeMeasureIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEMEASUREID, this.getPSSysBICubeMeasureId());
        }
        if (!bl || this.isPSSysBICubeMeasureNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEMEASURENAME, this.getPSSysBICubeMeasureName());
        }
        if (!bl || this.isPSSysBICubeNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBENAME, this.getPSSysBICubeName());
        }
        if (!bl || this.isPSSysBISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMEID, this.getPSSysBISchemeId());
        }
        if (!bl || this.isPSSysTranslatorIdDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORID, this.getPSSysTranslatorId());
        }
        if (!bl || this.isPSSysTranslatorNameDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORNAME, this.getPSSysTranslatorName());
        }
        if (!bl || this.isPSThresholdGroupIdDirty()) {
            hashMap.put(FIELD_PSTHRESHOLDGROUPID, this.getPSThresholdGroupId());
        }
        if (!bl || this.isPSThresholdGroupNameDirty()) {
            hashMap.put(FIELD_PSTHRESHOLDGROUPNAME, this.getPSThresholdGroupName());
        }
        if (!bl || this.isStdDataTypeDirty()) {
            hashMap.put(FIELD_STDDATATYPE, this.getStdDataType());
        }
        if (!bl || this.isTextTemplateDirty()) {
            hashMap.put(FIELD_TEXTTEMPLATE, this.getTextTemplate());
        }
        if (!bl || this.isTipTemplateDirty()) {
            hashMap.put(FIELD_TIPTEMPLATE, this.getTipTemplate());
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
        if (!bl || this.isValueFormatDirty()) {
            hashMap.put(FIELD_VALUEFORMAT, this.getValueFormat());
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
        return PSSysBICubeMeasureBase.get(this, n);
    }

    private static Object get(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeMeasureBase.getAggType();
            }
            case 1: {
                return pSSysBICubeMeasureBase.getBICubeMeasureTag();
            }
            case 2: {
                return pSSysBICubeMeasureBase.getBICubeMeasureTag2();
            }
            case 3: {
                return pSSysBICubeMeasureBase.getBIMeasureGroup();
            }
            case 4: {
                return pSSysBICubeMeasureBase.getBIMeasureType();
            }
            case 5: {
                return pSSysBICubeMeasureBase.getCodeName();
            }
            case 6: {
                return pSSysBICubeMeasureBase.getCreateDate();
            }
            case 7: {
                return pSSysBICubeMeasureBase.getCreateMan();
            }
            case 8: {
                return pSSysBICubeMeasureBase.getDrillDetailCustomCond();
            }
            case 9: {
                return pSSysBICubeMeasureBase.getDrillDetailCustomType();
            }
            case 10: {
                return pSSysBICubeMeasureBase.getDrillDetailPSDEViewId();
            }
            case 11: {
                return pSSysBICubeMeasureBase.getDrillDetailPSDEViewName();
            }
            case 12: {
                return pSSysBICubeMeasureBase.getDrillDownCustomCond();
            }
            case 13: {
                return pSSysBICubeMeasureBase.getDrillDownCustomType();
            }
            case 14: {
                return pSSysBICubeMeasureBase.getDrillDownPSDEViewId();
            }
            case 15: {
                return pSSysBICubeMeasureBase.getDrillDownPSDEViewName();
            }
            case 16: {
                return pSSysBICubeMeasureBase.getHiddenDataItem();
            }
            case 17: {
                return pSSysBICubeMeasureBase.getJsonFormat();
            }
            case 18: {
                return pSSysBICubeMeasureBase.getMeasureFormula();
            }
            case 19: {
                return pSSysBICubeMeasureBase.getMemo();
            }
            case 20: {
                return pSSysBICubeMeasureBase.getOrderValue();
            }
            case 21: {
                return pSSysBICubeMeasureBase.getParamPSDEUIActionId();
            }
            case 22: {
                return pSSysBICubeMeasureBase.getParamPSDEUIActionName();
            }
            case 23: {
                return pSSysBICubeMeasureBase.getPSCodeListId();
            }
            case 24: {
                return pSSysBICubeMeasureBase.getPSCodeListName();
            }
            case 25: {
                return pSSysBICubeMeasureBase.getPSDEFId();
            }
            case 26: {
                return pSSysBICubeMeasureBase.getPSDEFName();
            }
            case 27: {
                return pSSysBICubeMeasureBase.getPSDEId();
            }
            case 28: {
                return pSSysBICubeMeasureBase.getPSSysBICubeId();
            }
            case 29: {
                return pSSysBICubeMeasureBase.getPSSysBICubeMeasureId();
            }
            case 30: {
                return pSSysBICubeMeasureBase.getPSSysBICubeMeasureName();
            }
            case 31: {
                return pSSysBICubeMeasureBase.getPSSysBICubeName();
            }
            case 32: {
                return pSSysBICubeMeasureBase.getPSSysBISchemeId();
            }
            case 33: {
                return pSSysBICubeMeasureBase.getPSSysTranslatorId();
            }
            case 34: {
                return pSSysBICubeMeasureBase.getPSSysTranslatorName();
            }
            case 35: {
                return pSSysBICubeMeasureBase.getPSThresholdGroupId();
            }
            case 36: {
                return pSSysBICubeMeasureBase.getPSThresholdGroupName();
            }
            case 37: {
                return pSSysBICubeMeasureBase.getStdDataType();
            }
            case 38: {
                return pSSysBICubeMeasureBase.getTextTemplate();
            }
            case 39: {
                return pSSysBICubeMeasureBase.getTipTemplate();
            }
            case 40: {
                return pSSysBICubeMeasureBase.getUpdateDate();
            }
            case 41: {
                return pSSysBICubeMeasureBase.getUpdateMan();
            }
            case 42: {
                return pSSysBICubeMeasureBase.getUserCat();
            }
            case 43: {
                return pSSysBICubeMeasureBase.getUserTag();
            }
            case 44: {
                return pSSysBICubeMeasureBase.getUserTag2();
            }
            case 45: {
                return pSSysBICubeMeasureBase.getUserTag3();
            }
            case 46: {
                return pSSysBICubeMeasureBase.getUserTag4();
            }
            case 47: {
                return pSSysBICubeMeasureBase.getValidFlag();
            }
            case 48: {
                return pSSysBICubeMeasureBase.getValueFormat();
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
        PSSysBICubeMeasureBase.set(this, n, object);
    }

    private static void set(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBICubeMeasureBase.setAggType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBICubeMeasureBase.setBICubeMeasureTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBICubeMeasureBase.setBICubeMeasureTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBICubeMeasureBase.setBIMeasureGroup(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBICubeMeasureBase.setBIMeasureType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBICubeMeasureBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBICubeMeasureBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSysBICubeMeasureBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBICubeMeasureBase.setDrillDetailCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBICubeMeasureBase.setDrillDetailCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBICubeMeasureBase.setDrillDetailPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBICubeMeasureBase.setDrillDetailPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBICubeMeasureBase.setDrillDownCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBICubeMeasureBase.setDrillDownCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBICubeMeasureBase.setDrillDownPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBICubeMeasureBase.setDrillDownPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBICubeMeasureBase.setHiddenDataItem(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSysBICubeMeasureBase.setJsonFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBICubeMeasureBase.setMeasureFormula(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBICubeMeasureBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysBICubeMeasureBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSSysBICubeMeasureBase.setParamPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBICubeMeasureBase.setParamPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBICubeMeasureBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBICubeMeasureBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysBICubeMeasureBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysBICubeMeasureBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysBICubeMeasureBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysBICubeMeasureBase.setPSSysBICubeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysBICubeMeasureBase.setPSSysBICubeMeasureId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysBICubeMeasureBase.setPSSysBICubeMeasureName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysBICubeMeasureBase.setPSSysBICubeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysBICubeMeasureBase.setPSSysBISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysBICubeMeasureBase.setPSSysTranslatorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysBICubeMeasureBase.setPSSysTranslatorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysBICubeMeasureBase.setPSThresholdGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysBICubeMeasureBase.setPSThresholdGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysBICubeMeasureBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSSysBICubeMeasureBase.setTextTemplate(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysBICubeMeasureBase.setTipTemplate(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysBICubeMeasureBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 41: {
                pSSysBICubeMeasureBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysBICubeMeasureBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysBICubeMeasureBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysBICubeMeasureBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysBICubeMeasureBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysBICubeMeasureBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysBICubeMeasureBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 48: {
                pSSysBICubeMeasureBase.setValueFormat(DataObject.getStringValue((Object)object));
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
        return PSSysBICubeMeasureBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeMeasureBase.getAggType() == null;
            }
            case 1: {
                return pSSysBICubeMeasureBase.getBICubeMeasureTag() == null;
            }
            case 2: {
                return pSSysBICubeMeasureBase.getBICubeMeasureTag2() == null;
            }
            case 3: {
                return pSSysBICubeMeasureBase.getBIMeasureGroup() == null;
            }
            case 4: {
                return pSSysBICubeMeasureBase.getBIMeasureType() == null;
            }
            case 5: {
                return pSSysBICubeMeasureBase.getCodeName() == null;
            }
            case 6: {
                return pSSysBICubeMeasureBase.getCreateDate() == null;
            }
            case 7: {
                return pSSysBICubeMeasureBase.getCreateMan() == null;
            }
            case 8: {
                return pSSysBICubeMeasureBase.getDrillDetailCustomCond() == null;
            }
            case 9: {
                return pSSysBICubeMeasureBase.getDrillDetailCustomType() == null;
            }
            case 10: {
                return pSSysBICubeMeasureBase.getDrillDetailPSDEViewId() == null;
            }
            case 11: {
                return pSSysBICubeMeasureBase.getDrillDetailPSDEViewName() == null;
            }
            case 12: {
                return pSSysBICubeMeasureBase.getDrillDownCustomCond() == null;
            }
            case 13: {
                return pSSysBICubeMeasureBase.getDrillDownCustomType() == null;
            }
            case 14: {
                return pSSysBICubeMeasureBase.getDrillDownPSDEViewId() == null;
            }
            case 15: {
                return pSSysBICubeMeasureBase.getDrillDownPSDEViewName() == null;
            }
            case 16: {
                return pSSysBICubeMeasureBase.getHiddenDataItem() == null;
            }
            case 17: {
                return pSSysBICubeMeasureBase.getJsonFormat() == null;
            }
            case 18: {
                return pSSysBICubeMeasureBase.getMeasureFormula() == null;
            }
            case 19: {
                return pSSysBICubeMeasureBase.getMemo() == null;
            }
            case 20: {
                return pSSysBICubeMeasureBase.getOrderValue() == null;
            }
            case 21: {
                return pSSysBICubeMeasureBase.getParamPSDEUIActionId() == null;
            }
            case 22: {
                return pSSysBICubeMeasureBase.getParamPSDEUIActionName() == null;
            }
            case 23: {
                return pSSysBICubeMeasureBase.getPSCodeListId() == null;
            }
            case 24: {
                return pSSysBICubeMeasureBase.getPSCodeListName() == null;
            }
            case 25: {
                return pSSysBICubeMeasureBase.getPSDEFId() == null;
            }
            case 26: {
                return pSSysBICubeMeasureBase.getPSDEFName() == null;
            }
            case 27: {
                return pSSysBICubeMeasureBase.getPSDEId() == null;
            }
            case 28: {
                return pSSysBICubeMeasureBase.getPSSysBICubeId() == null;
            }
            case 29: {
                return pSSysBICubeMeasureBase.getPSSysBICubeMeasureId() == null;
            }
            case 30: {
                return pSSysBICubeMeasureBase.getPSSysBICubeMeasureName() == null;
            }
            case 31: {
                return pSSysBICubeMeasureBase.getPSSysBICubeName() == null;
            }
            case 32: {
                return pSSysBICubeMeasureBase.getPSSysBISchemeId() == null;
            }
            case 33: {
                return pSSysBICubeMeasureBase.getPSSysTranslatorId() == null;
            }
            case 34: {
                return pSSysBICubeMeasureBase.getPSSysTranslatorName() == null;
            }
            case 35: {
                return pSSysBICubeMeasureBase.getPSThresholdGroupId() == null;
            }
            case 36: {
                return pSSysBICubeMeasureBase.getPSThresholdGroupName() == null;
            }
            case 37: {
                return pSSysBICubeMeasureBase.getStdDataType() == null;
            }
            case 38: {
                return pSSysBICubeMeasureBase.getTextTemplate() == null;
            }
            case 39: {
                return pSSysBICubeMeasureBase.getTipTemplate() == null;
            }
            case 40: {
                return pSSysBICubeMeasureBase.getUpdateDate() == null;
            }
            case 41: {
                return pSSysBICubeMeasureBase.getUpdateMan() == null;
            }
            case 42: {
                return pSSysBICubeMeasureBase.getUserCat() == null;
            }
            case 43: {
                return pSSysBICubeMeasureBase.getUserTag() == null;
            }
            case 44: {
                return pSSysBICubeMeasureBase.getUserTag2() == null;
            }
            case 45: {
                return pSSysBICubeMeasureBase.getUserTag3() == null;
            }
            case 46: {
                return pSSysBICubeMeasureBase.getUserTag4() == null;
            }
            case 47: {
                return pSSysBICubeMeasureBase.getValidFlag() == null;
            }
            case 48: {
                return pSSysBICubeMeasureBase.getValueFormat() == null;
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
        return PSSysBICubeMeasureBase.contains(this, n);
    }

    private static boolean contains(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeMeasureBase.isAggTypeDirty();
            }
            case 1: {
                return pSSysBICubeMeasureBase.isBICubeMeasureTagDirty();
            }
            case 2: {
                return pSSysBICubeMeasureBase.isBICubeMeasureTag2Dirty();
            }
            case 3: {
                return pSSysBICubeMeasureBase.isBIMeasureGroupDirty();
            }
            case 4: {
                return pSSysBICubeMeasureBase.isBIMeasureTypeDirty();
            }
            case 5: {
                return pSSysBICubeMeasureBase.isCodeNameDirty();
            }
            case 6: {
                return pSSysBICubeMeasureBase.isCreateDateDirty();
            }
            case 7: {
                return pSSysBICubeMeasureBase.isCreateManDirty();
            }
            case 8: {
                return pSSysBICubeMeasureBase.isDrillDetailCustomCondDirty();
            }
            case 9: {
                return pSSysBICubeMeasureBase.isDrillDetailCustomTypeDirty();
            }
            case 10: {
                return pSSysBICubeMeasureBase.isDrillDetailPSDEViewIdDirty();
            }
            case 11: {
                return pSSysBICubeMeasureBase.isDrillDetailPSDEViewNameDirty();
            }
            case 12: {
                return pSSysBICubeMeasureBase.isDrillDownCustomCondDirty();
            }
            case 13: {
                return pSSysBICubeMeasureBase.isDrillDownCustomTypeDirty();
            }
            case 14: {
                return pSSysBICubeMeasureBase.isDrillDownPSDEViewIdDirty();
            }
            case 15: {
                return pSSysBICubeMeasureBase.isDrillDownPSDEViewNameDirty();
            }
            case 16: {
                return pSSysBICubeMeasureBase.isHiddenDataItemDirty();
            }
            case 17: {
                return pSSysBICubeMeasureBase.isJsonFormatDirty();
            }
            case 18: {
                return pSSysBICubeMeasureBase.isMeasureFormulaDirty();
            }
            case 19: {
                return pSSysBICubeMeasureBase.isMemoDirty();
            }
            case 20: {
                return pSSysBICubeMeasureBase.isOrderValueDirty();
            }
            case 21: {
                return pSSysBICubeMeasureBase.isParamPSDEUIActionIdDirty();
            }
            case 22: {
                return pSSysBICubeMeasureBase.isParamPSDEUIActionNameDirty();
            }
            case 23: {
                return pSSysBICubeMeasureBase.isPSCodeListIdDirty();
            }
            case 24: {
                return pSSysBICubeMeasureBase.isPSCodeListNameDirty();
            }
            case 25: {
                return pSSysBICubeMeasureBase.isPSDEFIdDirty();
            }
            case 26: {
                return pSSysBICubeMeasureBase.isPSDEFNameDirty();
            }
            case 27: {
                return pSSysBICubeMeasureBase.isPSDEIdDirty();
            }
            case 28: {
                return pSSysBICubeMeasureBase.isPSSysBICubeIdDirty();
            }
            case 29: {
                return pSSysBICubeMeasureBase.isPSSysBICubeMeasureIdDirty();
            }
            case 30: {
                return pSSysBICubeMeasureBase.isPSSysBICubeMeasureNameDirty();
            }
            case 31: {
                return pSSysBICubeMeasureBase.isPSSysBICubeNameDirty();
            }
            case 32: {
                return pSSysBICubeMeasureBase.isPSSysBISchemeIdDirty();
            }
            case 33: {
                return pSSysBICubeMeasureBase.isPSSysTranslatorIdDirty();
            }
            case 34: {
                return pSSysBICubeMeasureBase.isPSSysTranslatorNameDirty();
            }
            case 35: {
                return pSSysBICubeMeasureBase.isPSThresholdGroupIdDirty();
            }
            case 36: {
                return pSSysBICubeMeasureBase.isPSThresholdGroupNameDirty();
            }
            case 37: {
                return pSSysBICubeMeasureBase.isStdDataTypeDirty();
            }
            case 38: {
                return pSSysBICubeMeasureBase.isTextTemplateDirty();
            }
            case 39: {
                return pSSysBICubeMeasureBase.isTipTemplateDirty();
            }
            case 40: {
                return pSSysBICubeMeasureBase.isUpdateDateDirty();
            }
            case 41: {
                return pSSysBICubeMeasureBase.isUpdateManDirty();
            }
            case 42: {
                return pSSysBICubeMeasureBase.isUserCatDirty();
            }
            case 43: {
                return pSSysBICubeMeasureBase.isUserTagDirty();
            }
            case 44: {
                return pSSysBICubeMeasureBase.isUserTag2Dirty();
            }
            case 45: {
                return pSSysBICubeMeasureBase.isUserTag3Dirty();
            }
            case 46: {
                return pSSysBICubeMeasureBase.isUserTag4Dirty();
            }
            case 47: {
                return pSSysBICubeMeasureBase.isValidFlagDirty();
            }
            case 48: {
                return pSSysBICubeMeasureBase.isValueFormatDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBICubeMeasureBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBICubeMeasureBase.getAggType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggtype", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getAggType()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getBICubeMeasureTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bicubemeasuretag", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getBICubeMeasureTag()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getBICubeMeasureTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bicubemeasuretag2", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getBICubeMeasureTag2()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getBIMeasureGroup() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bimeasuregroup", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getBIMeasureGroup()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getBIMeasureType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bimeasuretype", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getBIMeasureType()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDetailCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drilldetailcustomcond", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getDrillDetailCustomCond()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDetailCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drilldetailcustomtype", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getDrillDetailCustomType()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDetailPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drilldetailpsdeviewid", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getDrillDetailPSDEViewId()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDetailPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drilldetailpsdeviewname", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getDrillDetailPSDEViewName()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDownCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drilldowncustomcond", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getDrillDownCustomCond()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDownCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drilldowncustomtype", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getDrillDownCustomType()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDownPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drilldownpsdeviewid", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getDrillDownPSDEViewId()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDownPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drilldownpsdeviewname", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getDrillDownPSDEViewName()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getHiddenDataItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hiddendataitem", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getHiddenDataItem()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getJsonFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jsonformat", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getJsonFormat()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getMeasureFormula() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"measureformula", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getMeasureFormula()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getParamPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"parampsdeuiactionid", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getParamPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getParamPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"parampsdeuiactionname", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getParamPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getPSSysBICubeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubeid", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getPSSysBICubeId()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getPSSysBICubeMeasureId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubemeasureid", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getPSSysBICubeMeasureId()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getPSSysBICubeMeasureName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubemeasurename", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getPSSysBICubeMeasureName()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getPSSysBICubeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubename", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getPSSysBICubeName()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getPSSysBISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemeid", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getPSSysBISchemeId()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getPSSysTranslatorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorid", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getPSSysTranslatorId()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getPSSysTranslatorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorname", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getPSSysTranslatorName()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getPSThresholdGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psthresholdgroupid", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getPSThresholdGroupId()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getPSThresholdGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psthresholdgroupname", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getPSThresholdGroupName()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getTextTemplate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"texttemplate", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getTextTemplate()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getTipTemplate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tiptemplate", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getTipTemplate()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysBICubeMeasureBase.getValueFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueformat", (Object)PSSysBICubeMeasureBase.getJSONValue((Object)pSSysBICubeMeasureBase.getValueFormat()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBICubeMeasureBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBICubeMeasureBase.getAggType() != null) {
            object = pSSysBICubeMeasureBase.getAggType();
            xmlNode.setAttribute(FIELD_AGGTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBICubeMeasureBase.getBICubeMeasureTag() != null) {
            object = pSSysBICubeMeasureBase.getBICubeMeasureTag();
            xmlNode.setAttribute(FIELD_BICUBEMEASURETAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBICubeMeasureBase.getBICubeMeasureTag2() != null) {
            object = pSSysBICubeMeasureBase.getBICubeMeasureTag2();
            xmlNode.setAttribute(FIELD_BICUBEMEASURETAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBICubeMeasureBase.getBIMeasureGroup() != null) {
            object = pSSysBICubeMeasureBase.getBIMeasureGroup();
            xmlNode.setAttribute(FIELD_BIMEASUREGROUP, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBICubeMeasureBase.getBIMeasureType() != null) {
            object = pSSysBICubeMeasureBase.getBIMeasureType();
            xmlNode.setAttribute(FIELD_BIMEASURETYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBICubeMeasureBase.getCodeName() != null) {
            object = pSSysBICubeMeasureBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getCreateDate() != null) {
            object = pSSysBICubeMeasureBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBICubeMeasureBase.getCreateMan() != null) {
            object = pSSysBICubeMeasureBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDetailCustomCond() != null) {
            object = pSSysBICubeMeasureBase.getDrillDetailCustomCond();
            xmlNode.setAttribute(FIELD_DRILLDETAILCUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDetailCustomType() != null) {
            object = pSSysBICubeMeasureBase.getDrillDetailCustomType();
            xmlNode.setAttribute(FIELD_DRILLDETAILCUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDetailPSDEViewId() != null) {
            object = pSSysBICubeMeasureBase.getDrillDetailPSDEViewId();
            xmlNode.setAttribute(FIELD_DRILLDETAILPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDetailPSDEViewName() != null) {
            object = pSSysBICubeMeasureBase.getDrillDetailPSDEViewName();
            xmlNode.setAttribute(FIELD_DRILLDETAILPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDownCustomCond() != null) {
            object = pSSysBICubeMeasureBase.getDrillDownCustomCond();
            xmlNode.setAttribute(FIELD_DRILLDOWNCUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDownCustomType() != null) {
            object = pSSysBICubeMeasureBase.getDrillDownCustomType();
            xmlNode.setAttribute(FIELD_DRILLDOWNCUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDownPSDEViewId() != null) {
            object = pSSysBICubeMeasureBase.getDrillDownPSDEViewId();
            xmlNode.setAttribute(FIELD_DRILLDOWNPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getDrillDownPSDEViewName() != null) {
            object = pSSysBICubeMeasureBase.getDrillDownPSDEViewName();
            xmlNode.setAttribute(FIELD_DRILLDOWNPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getHiddenDataItem() != null) {
            object = pSSysBICubeMeasureBase.getHiddenDataItem();
            xmlNode.setAttribute(FIELD_HIDDENDATAITEM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeMeasureBase.getJsonFormat() != null) {
            object = pSSysBICubeMeasureBase.getJsonFormat();
            xmlNode.setAttribute(FIELD_JSONFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getMeasureFormula() != null) {
            object = pSSysBICubeMeasureBase.getMeasureFormula();
            xmlNode.setAttribute(FIELD_MEASUREFORMULA, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getMemo() != null) {
            object = pSSysBICubeMeasureBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getOrderValue() != null) {
            object = pSSysBICubeMeasureBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeMeasureBase.getParamPSDEUIActionId() != null) {
            object = pSSysBICubeMeasureBase.getParamPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PARAMPSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getParamPSDEUIActionName() != null) {
            object = pSSysBICubeMeasureBase.getParamPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PARAMPSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getPSCodeListId() != null) {
            object = pSSysBICubeMeasureBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getPSCodeListName() != null) {
            object = pSSysBICubeMeasureBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getPSDEFId() != null) {
            object = pSSysBICubeMeasureBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getPSDEFName() != null) {
            object = pSSysBICubeMeasureBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getPSDEId() != null) {
            object = pSSysBICubeMeasureBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getPSSysBICubeId() != null) {
            object = pSSysBICubeMeasureBase.getPSSysBICubeId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getPSSysBICubeMeasureId() != null) {
            object = pSSysBICubeMeasureBase.getPSSysBICubeMeasureId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEMEASUREID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getPSSysBICubeMeasureName() != null) {
            object = pSSysBICubeMeasureBase.getPSSysBICubeMeasureName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEMEASURENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getPSSysBICubeName() != null) {
            object = pSSysBICubeMeasureBase.getPSSysBICubeName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getPSSysBISchemeId() != null) {
            object = pSSysBICubeMeasureBase.getPSSysBISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getPSSysTranslatorId() != null) {
            object = pSSysBICubeMeasureBase.getPSSysTranslatorId();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getPSSysTranslatorName() != null) {
            object = pSSysBICubeMeasureBase.getPSSysTranslatorName();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getPSThresholdGroupId() != null) {
            object = pSSysBICubeMeasureBase.getPSThresholdGroupId();
            xmlNode.setAttribute(FIELD_PSTHRESHOLDGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getPSThresholdGroupName() != null) {
            object = pSSysBICubeMeasureBase.getPSThresholdGroupName();
            xmlNode.setAttribute(FIELD_PSTHRESHOLDGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getStdDataType() != null) {
            object = pSSysBICubeMeasureBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeMeasureBase.getTextTemplate() != null) {
            object = pSSysBICubeMeasureBase.getTextTemplate();
            xmlNode.setAttribute(FIELD_TEXTTEMPLATE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getTipTemplate() != null) {
            object = pSSysBICubeMeasureBase.getTipTemplate();
            xmlNode.setAttribute(FIELD_TIPTEMPLATE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getUpdateDate() != null) {
            object = pSSysBICubeMeasureBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBICubeMeasureBase.getUpdateMan() != null) {
            object = pSSysBICubeMeasureBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getUserCat() != null) {
            object = pSSysBICubeMeasureBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getUserTag() != null) {
            object = pSSysBICubeMeasureBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getUserTag2() != null) {
            object = pSSysBICubeMeasureBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getUserTag3() != null) {
            object = pSSysBICubeMeasureBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getUserTag4() != null) {
            object = pSSysBICubeMeasureBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeMeasureBase.getValidFlag() != null) {
            object = pSSysBICubeMeasureBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeMeasureBase.getValueFormat() != null) {
            object = pSSysBICubeMeasureBase.getValueFormat();
            xmlNode.setAttribute(FIELD_VALUEFORMAT, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBICubeMeasureBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBICubeMeasureBase.isAggTypeDirty() && (bl || pSSysBICubeMeasureBase.getAggType() != null)) {
            iDataObject.set(FIELD_AGGTYPE, (Object)pSSysBICubeMeasureBase.getAggType());
        }
        if (pSSysBICubeMeasureBase.isBICubeMeasureTagDirty() && (bl || pSSysBICubeMeasureBase.getBICubeMeasureTag() != null)) {
            iDataObject.set(FIELD_BICUBEMEASURETAG, (Object)pSSysBICubeMeasureBase.getBICubeMeasureTag());
        }
        if (pSSysBICubeMeasureBase.isBICubeMeasureTag2Dirty() && (bl || pSSysBICubeMeasureBase.getBICubeMeasureTag2() != null)) {
            iDataObject.set(FIELD_BICUBEMEASURETAG2, (Object)pSSysBICubeMeasureBase.getBICubeMeasureTag2());
        }
        if (pSSysBICubeMeasureBase.isBIMeasureGroupDirty() && (bl || pSSysBICubeMeasureBase.getBIMeasureGroup() != null)) {
            iDataObject.set(FIELD_BIMEASUREGROUP, (Object)pSSysBICubeMeasureBase.getBIMeasureGroup());
        }
        if (pSSysBICubeMeasureBase.isBIMeasureTypeDirty() && (bl || pSSysBICubeMeasureBase.getBIMeasureType() != null)) {
            iDataObject.set(FIELD_BIMEASURETYPE, (Object)pSSysBICubeMeasureBase.getBIMeasureType());
        }
        if (pSSysBICubeMeasureBase.isCodeNameDirty() && (bl || pSSysBICubeMeasureBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBICubeMeasureBase.getCodeName());
        }
        if (pSSysBICubeMeasureBase.isCreateDateDirty() && (bl || pSSysBICubeMeasureBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBICubeMeasureBase.getCreateDate());
        }
        if (pSSysBICubeMeasureBase.isCreateManDirty() && (bl || pSSysBICubeMeasureBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBICubeMeasureBase.getCreateMan());
        }
        if (pSSysBICubeMeasureBase.isDrillDetailCustomCondDirty() && (bl || pSSysBICubeMeasureBase.getDrillDetailCustomCond() != null)) {
            iDataObject.set(FIELD_DRILLDETAILCUSTOMCOND, (Object)pSSysBICubeMeasureBase.getDrillDetailCustomCond());
        }
        if (pSSysBICubeMeasureBase.isDrillDetailCustomTypeDirty() && (bl || pSSysBICubeMeasureBase.getDrillDetailCustomType() != null)) {
            iDataObject.set(FIELD_DRILLDETAILCUSTOMTYPE, (Object)pSSysBICubeMeasureBase.getDrillDetailCustomType());
        }
        if (pSSysBICubeMeasureBase.isDrillDetailPSDEViewIdDirty() && (bl || pSSysBICubeMeasureBase.getDrillDetailPSDEViewId() != null)) {
            iDataObject.set(FIELD_DRILLDETAILPSDEVIEWID, (Object)pSSysBICubeMeasureBase.getDrillDetailPSDEViewId());
        }
        if (pSSysBICubeMeasureBase.isDrillDetailPSDEViewNameDirty() && (bl || pSSysBICubeMeasureBase.getDrillDetailPSDEViewName() != null)) {
            iDataObject.set(FIELD_DRILLDETAILPSDEVIEWNAME, (Object)pSSysBICubeMeasureBase.getDrillDetailPSDEViewName());
        }
        if (pSSysBICubeMeasureBase.isDrillDownCustomCondDirty() && (bl || pSSysBICubeMeasureBase.getDrillDownCustomCond() != null)) {
            iDataObject.set(FIELD_DRILLDOWNCUSTOMCOND, (Object)pSSysBICubeMeasureBase.getDrillDownCustomCond());
        }
        if (pSSysBICubeMeasureBase.isDrillDownCustomTypeDirty() && (bl || pSSysBICubeMeasureBase.getDrillDownCustomType() != null)) {
            iDataObject.set(FIELD_DRILLDOWNCUSTOMTYPE, (Object)pSSysBICubeMeasureBase.getDrillDownCustomType());
        }
        if (pSSysBICubeMeasureBase.isDrillDownPSDEViewIdDirty() && (bl || pSSysBICubeMeasureBase.getDrillDownPSDEViewId() != null)) {
            iDataObject.set(FIELD_DRILLDOWNPSDEVIEWID, (Object)pSSysBICubeMeasureBase.getDrillDownPSDEViewId());
        }
        if (pSSysBICubeMeasureBase.isDrillDownPSDEViewNameDirty() && (bl || pSSysBICubeMeasureBase.getDrillDownPSDEViewName() != null)) {
            iDataObject.set(FIELD_DRILLDOWNPSDEVIEWNAME, (Object)pSSysBICubeMeasureBase.getDrillDownPSDEViewName());
        }
        if (pSSysBICubeMeasureBase.isHiddenDataItemDirty() && (bl || pSSysBICubeMeasureBase.getHiddenDataItem() != null)) {
            iDataObject.set(FIELD_HIDDENDATAITEM, (Object)pSSysBICubeMeasureBase.getHiddenDataItem());
        }
        if (pSSysBICubeMeasureBase.isJsonFormatDirty() && (bl || pSSysBICubeMeasureBase.getJsonFormat() != null)) {
            iDataObject.set(FIELD_JSONFORMAT, (Object)pSSysBICubeMeasureBase.getJsonFormat());
        }
        if (pSSysBICubeMeasureBase.isMeasureFormulaDirty() && (bl || pSSysBICubeMeasureBase.getMeasureFormula() != null)) {
            iDataObject.set(FIELD_MEASUREFORMULA, (Object)pSSysBICubeMeasureBase.getMeasureFormula());
        }
        if (pSSysBICubeMeasureBase.isMemoDirty() && (bl || pSSysBICubeMeasureBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBICubeMeasureBase.getMemo());
        }
        if (pSSysBICubeMeasureBase.isOrderValueDirty() && (bl || pSSysBICubeMeasureBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysBICubeMeasureBase.getOrderValue());
        }
        if (pSSysBICubeMeasureBase.isParamPSDEUIActionIdDirty() && (bl || pSSysBICubeMeasureBase.getParamPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PARAMPSDEUIACTIONID, (Object)pSSysBICubeMeasureBase.getParamPSDEUIActionId());
        }
        if (pSSysBICubeMeasureBase.isParamPSDEUIActionNameDirty() && (bl || pSSysBICubeMeasureBase.getParamPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PARAMPSDEUIACTIONNAME, (Object)pSSysBICubeMeasureBase.getParamPSDEUIActionName());
        }
        if (pSSysBICubeMeasureBase.isPSCodeListIdDirty() && (bl || pSSysBICubeMeasureBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSSysBICubeMeasureBase.getPSCodeListId());
        }
        if (pSSysBICubeMeasureBase.isPSCodeListNameDirty() && (bl || pSSysBICubeMeasureBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSSysBICubeMeasureBase.getPSCodeListName());
        }
        if (pSSysBICubeMeasureBase.isPSDEFIdDirty() && (bl || pSSysBICubeMeasureBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSSysBICubeMeasureBase.getPSDEFId());
        }
        if (pSSysBICubeMeasureBase.isPSDEFNameDirty() && (bl || pSSysBICubeMeasureBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSSysBICubeMeasureBase.getPSDEFName());
        }
        if (pSSysBICubeMeasureBase.isPSDEIdDirty() && (bl || pSSysBICubeMeasureBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysBICubeMeasureBase.getPSDEId());
        }
        if (pSSysBICubeMeasureBase.isPSSysBICubeIdDirty() && (bl || pSSysBICubeMeasureBase.getPSSysBICubeId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEID, (Object)pSSysBICubeMeasureBase.getPSSysBICubeId());
        }
        if (pSSysBICubeMeasureBase.isPSSysBICubeMeasureIdDirty() && (bl || pSSysBICubeMeasureBase.getPSSysBICubeMeasureId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEMEASUREID, (Object)pSSysBICubeMeasureBase.getPSSysBICubeMeasureId());
        }
        if (pSSysBICubeMeasureBase.isPSSysBICubeMeasureNameDirty() && (bl || pSSysBICubeMeasureBase.getPSSysBICubeMeasureName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEMEASURENAME, (Object)pSSysBICubeMeasureBase.getPSSysBICubeMeasureName());
        }
        if (pSSysBICubeMeasureBase.isPSSysBICubeNameDirty() && (bl || pSSysBICubeMeasureBase.getPSSysBICubeName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBENAME, (Object)pSSysBICubeMeasureBase.getPSSysBICubeName());
        }
        if (pSSysBICubeMeasureBase.isPSSysBISchemeIdDirty() && (bl || pSSysBICubeMeasureBase.getPSSysBISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMEID, (Object)pSSysBICubeMeasureBase.getPSSysBISchemeId());
        }
        if (pSSysBICubeMeasureBase.isPSSysTranslatorIdDirty() && (bl || pSSysBICubeMeasureBase.getPSSysTranslatorId() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORID, (Object)pSSysBICubeMeasureBase.getPSSysTranslatorId());
        }
        if (pSSysBICubeMeasureBase.isPSSysTranslatorNameDirty() && (bl || pSSysBICubeMeasureBase.getPSSysTranslatorName() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORNAME, (Object)pSSysBICubeMeasureBase.getPSSysTranslatorName());
        }
        if (pSSysBICubeMeasureBase.isPSThresholdGroupIdDirty() && (bl || pSSysBICubeMeasureBase.getPSThresholdGroupId() != null)) {
            iDataObject.set(FIELD_PSTHRESHOLDGROUPID, (Object)pSSysBICubeMeasureBase.getPSThresholdGroupId());
        }
        if (pSSysBICubeMeasureBase.isPSThresholdGroupNameDirty() && (bl || pSSysBICubeMeasureBase.getPSThresholdGroupName() != null)) {
            iDataObject.set(FIELD_PSTHRESHOLDGROUPNAME, (Object)pSSysBICubeMeasureBase.getPSThresholdGroupName());
        }
        if (pSSysBICubeMeasureBase.isStdDataTypeDirty() && (bl || pSSysBICubeMeasureBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSSysBICubeMeasureBase.getStdDataType());
        }
        if (pSSysBICubeMeasureBase.isTextTemplateDirty() && (bl || pSSysBICubeMeasureBase.getTextTemplate() != null)) {
            iDataObject.set(FIELD_TEXTTEMPLATE, (Object)pSSysBICubeMeasureBase.getTextTemplate());
        }
        if (pSSysBICubeMeasureBase.isTipTemplateDirty() && (bl || pSSysBICubeMeasureBase.getTipTemplate() != null)) {
            iDataObject.set(FIELD_TIPTEMPLATE, (Object)pSSysBICubeMeasureBase.getTipTemplate());
        }
        if (pSSysBICubeMeasureBase.isUpdateDateDirty() && (bl || pSSysBICubeMeasureBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBICubeMeasureBase.getUpdateDate());
        }
        if (pSSysBICubeMeasureBase.isUpdateManDirty() && (bl || pSSysBICubeMeasureBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBICubeMeasureBase.getUpdateMan());
        }
        if (pSSysBICubeMeasureBase.isUserCatDirty() && (bl || pSSysBICubeMeasureBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBICubeMeasureBase.getUserCat());
        }
        if (pSSysBICubeMeasureBase.isUserTagDirty() && (bl || pSSysBICubeMeasureBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBICubeMeasureBase.getUserTag());
        }
        if (pSSysBICubeMeasureBase.isUserTag2Dirty() && (bl || pSSysBICubeMeasureBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBICubeMeasureBase.getUserTag2());
        }
        if (pSSysBICubeMeasureBase.isUserTag3Dirty() && (bl || pSSysBICubeMeasureBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBICubeMeasureBase.getUserTag3());
        }
        if (pSSysBICubeMeasureBase.isUserTag4Dirty() && (bl || pSSysBICubeMeasureBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBICubeMeasureBase.getUserTag4());
        }
        if (pSSysBICubeMeasureBase.isValidFlagDirty() && (bl || pSSysBICubeMeasureBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysBICubeMeasureBase.getValidFlag());
        }
        if (pSSysBICubeMeasureBase.isValueFormatDirty() && (bl || pSSysBICubeMeasureBase.getValueFormat() != null)) {
            iDataObject.set(FIELD_VALUEFORMAT, (Object)pSSysBICubeMeasureBase.getValueFormat());
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
        return PSSysBICubeMeasureBase.remove(this, n);
    }

    private static boolean remove(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBICubeMeasureBase.resetAggType();
                return true;
            }
            case 1: {
                pSSysBICubeMeasureBase.resetBICubeMeasureTag();
                return true;
            }
            case 2: {
                pSSysBICubeMeasureBase.resetBICubeMeasureTag2();
                return true;
            }
            case 3: {
                pSSysBICubeMeasureBase.resetBIMeasureGroup();
                return true;
            }
            case 4: {
                pSSysBICubeMeasureBase.resetBIMeasureType();
                return true;
            }
            case 5: {
                pSSysBICubeMeasureBase.resetCodeName();
                return true;
            }
            case 6: {
                pSSysBICubeMeasureBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSSysBICubeMeasureBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSSysBICubeMeasureBase.resetDrillDetailCustomCond();
                return true;
            }
            case 9: {
                pSSysBICubeMeasureBase.resetDrillDetailCustomType();
                return true;
            }
            case 10: {
                pSSysBICubeMeasureBase.resetDrillDetailPSDEViewId();
                return true;
            }
            case 11: {
                pSSysBICubeMeasureBase.resetDrillDetailPSDEViewName();
                return true;
            }
            case 12: {
                pSSysBICubeMeasureBase.resetDrillDownCustomCond();
                return true;
            }
            case 13: {
                pSSysBICubeMeasureBase.resetDrillDownCustomType();
                return true;
            }
            case 14: {
                pSSysBICubeMeasureBase.resetDrillDownPSDEViewId();
                return true;
            }
            case 15: {
                pSSysBICubeMeasureBase.resetDrillDownPSDEViewName();
                return true;
            }
            case 16: {
                pSSysBICubeMeasureBase.resetHiddenDataItem();
                return true;
            }
            case 17: {
                pSSysBICubeMeasureBase.resetJsonFormat();
                return true;
            }
            case 18: {
                pSSysBICubeMeasureBase.resetMeasureFormula();
                return true;
            }
            case 19: {
                pSSysBICubeMeasureBase.resetMemo();
                return true;
            }
            case 20: {
                pSSysBICubeMeasureBase.resetOrderValue();
                return true;
            }
            case 21: {
                pSSysBICubeMeasureBase.resetParamPSDEUIActionId();
                return true;
            }
            case 22: {
                pSSysBICubeMeasureBase.resetParamPSDEUIActionName();
                return true;
            }
            case 23: {
                pSSysBICubeMeasureBase.resetPSCodeListId();
                return true;
            }
            case 24: {
                pSSysBICubeMeasureBase.resetPSCodeListName();
                return true;
            }
            case 25: {
                pSSysBICubeMeasureBase.resetPSDEFId();
                return true;
            }
            case 26: {
                pSSysBICubeMeasureBase.resetPSDEFName();
                return true;
            }
            case 27: {
                pSSysBICubeMeasureBase.resetPSDEId();
                return true;
            }
            case 28: {
                pSSysBICubeMeasureBase.resetPSSysBICubeId();
                return true;
            }
            case 29: {
                pSSysBICubeMeasureBase.resetPSSysBICubeMeasureId();
                return true;
            }
            case 30: {
                pSSysBICubeMeasureBase.resetPSSysBICubeMeasureName();
                return true;
            }
            case 31: {
                pSSysBICubeMeasureBase.resetPSSysBICubeName();
                return true;
            }
            case 32: {
                pSSysBICubeMeasureBase.resetPSSysBISchemeId();
                return true;
            }
            case 33: {
                pSSysBICubeMeasureBase.resetPSSysTranslatorId();
                return true;
            }
            case 34: {
                pSSysBICubeMeasureBase.resetPSSysTranslatorName();
                return true;
            }
            case 35: {
                pSSysBICubeMeasureBase.resetPSThresholdGroupId();
                return true;
            }
            case 36: {
                pSSysBICubeMeasureBase.resetPSThresholdGroupName();
                return true;
            }
            case 37: {
                pSSysBICubeMeasureBase.resetStdDataType();
                return true;
            }
            case 38: {
                pSSysBICubeMeasureBase.resetTextTemplate();
                return true;
            }
            case 39: {
                pSSysBICubeMeasureBase.resetTipTemplate();
                return true;
            }
            case 40: {
                pSSysBICubeMeasureBase.resetUpdateDate();
                return true;
            }
            case 41: {
                pSSysBICubeMeasureBase.resetUpdateMan();
                return true;
            }
            case 42: {
                pSSysBICubeMeasureBase.resetUserCat();
                return true;
            }
            case 43: {
                pSSysBICubeMeasureBase.resetUserTag();
                return true;
            }
            case 44: {
                pSSysBICubeMeasureBase.resetUserTag2();
                return true;
            }
            case 45: {
                pSSysBICubeMeasureBase.resetUserTag3();
                return true;
            }
            case 46: {
                pSSysBICubeMeasureBase.resetUserTag4();
                return true;
            }
            case 47: {
                pSSysBICubeMeasureBase.resetValidFlag();
                return true;
            }
            case 48: {
                pSSysBICubeMeasureBase.resetValueFormat();
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
    public PSDEUIAction getParamPSDEUIAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSDEUIAction();
        }
        if (this.getParamPSDEUIActionId() == null) {
            return null;
        }
        Integer n = this.objParamPSDEUIActionLock;
        synchronized (n) {
            if (this.parampsdeuiaction != null && DataTypeHelper.compare((int)25, (Object)this.getParamPSDEUIActionId(), (Object)this.parampsdeuiaction.getPSDEUIActionId()) != 0L) {
                this.parampsdeuiaction = null;
            }
            if (this.parampsdeuiaction == null) {
                PSDEUIAction pSDEUIAction = new PSDEUIAction();
                pSDEUIAction.setPSDEUIActionId(this.getParamPSDEUIActionId());
                PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEUIActionService.autoGet((IEntity)pSDEUIAction);
                this.parampsdeuiaction = pSDEUIAction;
            }
            return this.parampsdeuiaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getDrillDetailPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDetailPSDEView();
        }
        if (this.getDrillDetailPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objDrillDetailPSDEViewLock;
        synchronized (n) {
            if (this.drilldetailpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getDrillDetailPSDEViewId(), (Object)this.drilldetailpsdeview.getPSDEViewBaseId()) != 0L) {
                this.drilldetailpsdeview = null;
            }
            if (this.drilldetailpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getDrillDetailPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.drilldetailpsdeview = pSDEViewBase;
            }
            return this.drilldetailpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getDrillDownPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDownPSDEView();
        }
        if (this.getDrillDownPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objDrillDownPSDEViewLock;
        synchronized (n) {
            if (this.drilldownpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getDrillDownPSDEViewId(), (Object)this.drilldownpsdeview.getPSDEViewBaseId()) != 0L) {
                this.drilldownpsdeview = null;
            }
            if (this.drilldownpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getDrillDownPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.drilldownpsdeview = pSDEViewBase;
            }
            return this.drilldownpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBICube getPSSysBICube() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICube();
        }
        if (this.getPSSysBICubeId() == null) {
            return null;
        }
        Integer n = this.objPSSysBICubeLock;
        synchronized (n) {
            if (this.pssysbicube != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBICubeId(), (Object)this.pssysbicube.getPSSysBICubeId()) != 0L) {
                this.pssysbicube = null;
            }
            if (this.pssysbicube == null) {
                PSSysBICube pSSysBICube = new PSSysBICube();
                pSSysBICube.setPSSysBICubeId(this.getPSSysBICubeId());
                PSSysBICubeService pSSysBICubeService = (PSSysBICubeService)ServiceGlobal.getService(PSSysBICubeService.class, (SessionFactory)this.getSessionFactory());
                pSSysBICubeService.autoGet((IEntity)pSSysBICube);
                this.pssysbicube = pSSysBICube;
            }
            return this.pssysbicube;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTranslator getPSSysTranslator() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslator();
        }
        if (this.getPSSysTranslatorId() == null) {
            return null;
        }
        Integer n = this.objPSSysTranslatorLock;
        synchronized (n) {
            if (this.pssystranslator != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTranslatorId(), (Object)this.pssystranslator.getPSSysTranslatorId()) != 0L) {
                this.pssystranslator = null;
            }
            if (this.pssystranslator == null) {
                PSSysTranslator pSSysTranslator = new PSSysTranslator();
                pSSysTranslator.setPSSysTranslatorId(this.getPSSysTranslatorId());
                PSSysTranslatorService pSSysTranslatorService = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
                pSSysTranslatorService.autoGet((IEntity)pSSysTranslator);
                this.pssystranslator = pSSysTranslator;
            }
            return this.pssystranslator;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSThresholdGroup getPSThresholdGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSThresholdGroup();
        }
        if (this.getPSThresholdGroupId() == null) {
            return null;
        }
        Integer n = this.objPSThresholdGroupLock;
        synchronized (n) {
            if (this.psthresholdgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSThresholdGroupId(), (Object)this.psthresholdgroup.getPSThresholdGroupId()) != 0L) {
                this.psthresholdgroup = null;
            }
            if (this.psthresholdgroup == null) {
                PSThresholdGroup pSThresholdGroup = new PSThresholdGroup();
                pSThresholdGroup.setPSThresholdGroupId(this.getPSThresholdGroupId());
                PSThresholdGroupService pSThresholdGroupService = (PSThresholdGroupService)ServiceGlobal.getService(PSThresholdGroupService.class, (SessionFactory)this.getSessionFactory());
                pSThresholdGroupService.autoGet((IEntity)pSThresholdGroup);
                this.psthresholdgroup = pSThresholdGroup;
            }
            return this.psthresholdgroup;
        }
    }

    private PSSysBICubeMeasureBase getProxyEntity() {
        return this.proxyPSSysBICubeMeasureBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBICubeMeasureBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBICubeMeasureBase) {
            this.proxyPSSysBICubeMeasureBase = (PSSysBICubeMeasureBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AGGTYPE, 0);
        fieldIndexMap.put(FIELD_BICUBEMEASURETAG, 1);
        fieldIndexMap.put(FIELD_BICUBEMEASURETAG2, 2);
        fieldIndexMap.put(FIELD_BIMEASUREGROUP, 3);
        fieldIndexMap.put(FIELD_BIMEASURETYPE, 4);
        fieldIndexMap.put(FIELD_CODENAME, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_DRILLDETAILCUSTOMCOND, 8);
        fieldIndexMap.put(FIELD_DRILLDETAILCUSTOMTYPE, 9);
        fieldIndexMap.put(FIELD_DRILLDETAILPSDEVIEWID, 10);
        fieldIndexMap.put(FIELD_DRILLDETAILPSDEVIEWNAME, 11);
        fieldIndexMap.put(FIELD_DRILLDOWNCUSTOMCOND, 12);
        fieldIndexMap.put(FIELD_DRILLDOWNCUSTOMTYPE, 13);
        fieldIndexMap.put(FIELD_DRILLDOWNPSDEVIEWID, 14);
        fieldIndexMap.put(FIELD_DRILLDOWNPSDEVIEWNAME, 15);
        fieldIndexMap.put(FIELD_HIDDENDATAITEM, 16);
        fieldIndexMap.put(FIELD_JSONFORMAT, 17);
        fieldIndexMap.put(FIELD_MEASUREFORMULA, 18);
        fieldIndexMap.put(FIELD_MEMO, 19);
        fieldIndexMap.put(FIELD_ORDERVALUE, 20);
        fieldIndexMap.put(FIELD_PARAMPSDEUIACTIONID, 21);
        fieldIndexMap.put(FIELD_PARAMPSDEUIACTIONNAME, 22);
        fieldIndexMap.put(FIELD_PSCODELISTID, 23);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 24);
        fieldIndexMap.put(FIELD_PSDEFID, 25);
        fieldIndexMap.put(FIELD_PSDEFNAME, 26);
        fieldIndexMap.put(FIELD_PSDEID, 27);
        fieldIndexMap.put(FIELD_PSSYSBICUBEID, 28);
        fieldIndexMap.put(FIELD_PSSYSBICUBEMEASUREID, 29);
        fieldIndexMap.put(FIELD_PSSYSBICUBEMEASURENAME, 30);
        fieldIndexMap.put(FIELD_PSSYSBICUBENAME, 31);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMEID, 32);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORID, 33);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORNAME, 34);
        fieldIndexMap.put(FIELD_PSTHRESHOLDGROUPID, 35);
        fieldIndexMap.put(FIELD_PSTHRESHOLDGROUPNAME, 36);
        fieldIndexMap.put(FIELD_STDDATATYPE, 37);
        fieldIndexMap.put(FIELD_TEXTTEMPLATE, 38);
        fieldIndexMap.put(FIELD_TIPTEMPLATE, 39);
        fieldIndexMap.put(FIELD_UPDATEDATE, 40);
        fieldIndexMap.put(FIELD_UPDATEMAN, 41);
        fieldIndexMap.put(FIELD_USERCAT, 42);
        fieldIndexMap.put(FIELD_USERTAG, 43);
        fieldIndexMap.put(FIELD_USERTAG2, 44);
        fieldIndexMap.put(FIELD_USERTAG3, 45);
        fieldIndexMap.put(FIELD_USERTAG4, 46);
        fieldIndexMap.put(FIELD_VALIDFLAG, 47);
        fieldIndexMap.put(FIELD_VALUEFORMAT, 48);
    }
}

