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
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeDimension;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeLevel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasure;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReport;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReportItem;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeLevelService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBIReportItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBIReportItemBase.class);
    public static final String FIELD_AGGTYPE = "AGGTYPE";
    public static final String FIELD_BIREPITEMPARAMS = "BIREPITEMPARAMS";
    public static final String FIELD_BIREPITEMTAG = "BIREPITEMTAG";
    public static final String FIELD_BIREPITEMTAG2 = "BIREPITEMTAG2";
    public static final String FIELD_BIREPITEMTYPE = "BIREPITEMTYPE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_HALIGN = "HALIGN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PLACEMENT = "PLACEMENT";
    public static final String FIELD_PLACETYPE = "PLACETYPE";
    public static final String FIELD_PPSSYSBIREPORTITEMID = "PPSSYSBIREPORTITEMID";
    public static final String FIELD_PPSSYSBIREPORTITEMNAME = "PPSSYSBIREPORTITEMNAME";
    public static final String FIELD_PSSYSBICUBEDIMENSIONID = "PSSYSBICUBEDIMENSIONID";
    public static final String FIELD_PSSYSBICUBEDIMENSIONNAME = "PSSYSBICUBEDIMENSIONNAME";
    public static final String FIELD_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String FIELD_PSSYSBICUBELEVELID = "PSSYSBICUBELEVELID";
    public static final String FIELD_PSSYSBICUBELEVELNAME = "PSSYSBICUBELEVELNAME";
    public static final String FIELD_PSSYSBICUBEMEASUREID = "PSSYSBICUBEMEASUREID";
    public static final String FIELD_PSSYSBICUBEMEASURENAME = "PSSYSBICUBEMEASURENAME";
    public static final String FIELD_PSSYSBICUBENAME = "PSSYSBICUBENAME";
    public static final String FIELD_PSSYSBIREPORTID = "PSSYSBIREPORTID";
    public static final String FIELD_PSSYSBIREPORTITEMID = "PSSYSBIREPORTITEMID";
    public static final String FIELD_PSSYSBIREPORTITEMNAME = "PSSYSBIREPORTITEMNAME";
    public static final String FIELD_PSSYSBIREPORTNAME = "PSSYSBIREPORTNAME";
    public static final String FIELD_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String FIELD_REFPSSYSBICUBEMEASUREID = "REFPSSYSBICUBEMEASUREID";
    public static final String FIELD_REFPSSYSBICUBEMEASURENAME = "REFPSSYSBICUBEMEASURENAME";
    public static final String FIELD_REFTYPE = "REFTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALIGN = "VALIGN";
    public static final String FIELD_VALUEFORMAT = "VALUEFORMAT";
    public static final String FIELD_WIDTH = "WIDTH";
    public static final String FIELD_WIDTHUNIT = "WIDTHUNIT";
    private static final int INDEX_AGGTYPE = 0;
    private static final int INDEX_BIREPITEMPARAMS = 1;
    private static final int INDEX_BIREPITEMTAG = 2;
    private static final int INDEX_BIREPITEMTAG2 = 3;
    private static final int INDEX_BIREPITEMTYPE = 4;
    private static final int INDEX_CODENAME = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_DATA = 8;
    private static final int INDEX_HALIGN = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_ORDERVALUE = 11;
    private static final int INDEX_PLACEMENT = 12;
    private static final int INDEX_PLACETYPE = 13;
    private static final int INDEX_PPSSYSBIREPORTITEMID = 14;
    private static final int INDEX_PPSSYSBIREPORTITEMNAME = 15;
    private static final int INDEX_PSSYSBICUBEDIMENSIONID = 16;
    private static final int INDEX_PSSYSBICUBEDIMENSIONNAME = 17;
    private static final int INDEX_PSSYSBICUBEID = 18;
    private static final int INDEX_PSSYSBICUBELEVELID = 19;
    private static final int INDEX_PSSYSBICUBELEVELNAME = 20;
    private static final int INDEX_PSSYSBICUBEMEASUREID = 21;
    private static final int INDEX_PSSYSBICUBEMEASURENAME = 22;
    private static final int INDEX_PSSYSBICUBENAME = 23;
    private static final int INDEX_PSSYSBIREPORTID = 24;
    private static final int INDEX_PSSYSBIREPORTITEMID = 25;
    private static final int INDEX_PSSYSBIREPORTITEMNAME = 26;
    private static final int INDEX_PSSYSBIREPORTNAME = 27;
    private static final int INDEX_PSSYSBISCHEMEID = 28;
    private static final int INDEX_REFPSSYSBICUBEMEASUREID = 29;
    private static final int INDEX_REFPSSYSBICUBEMEASURENAME = 30;
    private static final int INDEX_REFTYPE = 31;
    private static final int INDEX_UPDATEDATE = 32;
    private static final int INDEX_UPDATEMAN = 33;
    private static final int INDEX_USERCAT = 34;
    private static final int INDEX_USERTAG = 35;
    private static final int INDEX_USERTAG2 = 36;
    private static final int INDEX_USERTAG3 = 37;
    private static final int INDEX_USERTAG4 = 38;
    private static final int INDEX_VALIDFLAG = 39;
    private static final int INDEX_VALIGN = 40;
    private static final int INDEX_VALUEFORMAT = 41;
    private static final int INDEX_WIDTH = 42;
    private static final int INDEX_WIDTHUNIT = 43;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBIReportItemBase proxyPSSysBIReportItemBase = null;
    private boolean aggtypeDirtyFlag = false;
    private boolean birepitemparamsDirtyFlag = false;
    private boolean birepitemtagDirtyFlag = false;
    private boolean birepitemtag2DirtyFlag = false;
    private boolean birepitemtypeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean halignDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean placementDirtyFlag = false;
    private boolean placetypeDirtyFlag = false;
    private boolean ppssysbireportitemidDirtyFlag = false;
    private boolean ppssysbireportitemnameDirtyFlag = false;
    private boolean pssysbicubedimensionidDirtyFlag = false;
    private boolean pssysbicubedimensionnameDirtyFlag = false;
    private boolean pssysbicubeidDirtyFlag = false;
    private boolean pssysbicubelevelidDirtyFlag = false;
    private boolean pssysbicubelevelnameDirtyFlag = false;
    private boolean pssysbicubemeasureidDirtyFlag = false;
    private boolean pssysbicubemeasurenameDirtyFlag = false;
    private boolean pssysbicubenameDirtyFlag = false;
    private boolean pssysbireportidDirtyFlag = false;
    private boolean pssysbireportitemidDirtyFlag = false;
    private boolean pssysbireportitemnameDirtyFlag = false;
    private boolean pssysbireportnameDirtyFlag = false;
    private boolean pssysbischemeidDirtyFlag = false;
    private boolean refpssysbicubemeasureidDirtyFlag = false;
    private boolean refpssysbicubemeasurenameDirtyFlag = false;
    private boolean reftypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valignDirtyFlag = false;
    private boolean valueformatDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    private boolean widthunitDirtyFlag = false;
    @Column(name="aggtype")
    private String aggtype;
    @Column(name="birepitemparams")
    private String birepitemparams;
    @Column(name="birepitemtag")
    private String birepitemtag;
    @Column(name="birepitemtag2")
    private String birepitemtag2;
    @Column(name="birepitemtype")
    private String birepitemtype;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="data")
    private String data;
    @Column(name="halign")
    private String halign;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="placement")
    private String placement;
    @Column(name="placetype")
    private String placetype;
    @Column(name="ppssysbireportitemid")
    private String ppssysbireportitemid;
    @Column(name="ppssysbireportitemname")
    private String ppssysbireportitemname;
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
    @Column(name="pssysbicubename")
    private String pssysbicubename;
    @Column(name="pssysbireportid")
    private String pssysbireportid;
    @Column(name="pssysbireportitemid")
    private String pssysbireportitemid;
    @Column(name="pssysbireportitemname")
    private String pssysbireportitemname;
    @Column(name="pssysbireportname")
    private String pssysbireportname;
    @Column(name="pssysbischemeid")
    private String pssysbischemeid;
    @Column(name="refpssysbicubemeasureid")
    private String refpssysbicubemeasureid;
    @Column(name="refpssysbicubemeasurename")
    private String refpssysbicubemeasurename;
    @Column(name="reftype")
    private String reftype;
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
    @Column(name="valign")
    private String valign;
    @Column(name="valueformat")
    private String valueformat;
    @Column(name="width")
    private Integer width;
    @Column(name="widthunit")
    private String widthunit;
    private Integer objPSSysBICubeDimensionLock = new Integer(1);
    private PSSysBICubeDimension pssysbicubedimension = null;
    private Integer objPSSysBICubeLevelLock = new Integer(1);
    private PSSysBICubeLevel pssysbicubelevel = null;
    private Integer objPSSysBICubeMeasureLock = new Integer(1);
    private PSSysBICubeMeasure pssysbicubemeasure = null;
    private Integer objRefPSSysBICubeMeasureLock = new Integer(1);
    private PSSysBICubeMeasure refpssysbicubemeasure = null;
    private Integer objPSSysBICubeLock = new Integer(1);
    private PSSysBICube pssysbicube = null;
    private Integer objPPSSysBIReportItemLock = new Integer(1);
    private PSSysBIReportItem ppssysbireportitem = null;
    private Integer objPSSysBIReportLock = new Integer(1);
    private PSSysBIReport pssysbireport = null;

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

    public void setBIRepItemParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIRepItemParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.birepitemparams = string;
        this.birepitemparamsDirtyFlag = true;
    }

    public String getBIRepItemParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIRepItemParams();
        }
        return this.birepitemparams;
    }

    public boolean isBIRepItemParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIRepItemParamsDirty();
        }
        return this.birepitemparamsDirtyFlag;
    }

    public void resetBIRepItemParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIRepItemParams();
            return;
        }
        this.birepitemparamsDirtyFlag = false;
        this.birepitemparams = null;
    }

    public void setBIRepItemTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIRepItemTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.birepitemtag = string;
        this.birepitemtagDirtyFlag = true;
    }

    public String getBIRepItemTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIRepItemTag();
        }
        return this.birepitemtag;
    }

    public boolean isBIRepItemTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIRepItemTagDirty();
        }
        return this.birepitemtagDirtyFlag;
    }

    public void resetBIRepItemTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIRepItemTag();
            return;
        }
        this.birepitemtagDirtyFlag = false;
        this.birepitemtag = null;
    }

    public void setBIRepItemTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIRepItemTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.birepitemtag2 = string;
        this.birepitemtag2DirtyFlag = true;
    }

    public String getBIRepItemTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIRepItemTag2();
        }
        return this.birepitemtag2;
    }

    public boolean isBIRepItemTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIRepItemTag2Dirty();
        }
        return this.birepitemtag2DirtyFlag;
    }

    public void resetBIRepItemTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIRepItemTag2();
            return;
        }
        this.birepitemtag2DirtyFlag = false;
        this.birepitemtag2 = null;
    }

    public void setBIRepItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIRepItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.birepitemtype = string;
        this.birepitemtypeDirtyFlag = true;
    }

    public String getBIRepItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIRepItemType();
        }
        return this.birepitemtype;
    }

    public boolean isBIRepItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIRepItemTypeDirty();
        }
        return this.birepitemtypeDirtyFlag;
    }

    public void resetBIRepItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIRepItemType();
            return;
        }
        this.birepitemtypeDirtyFlag = false;
        this.birepitemtype = null;
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

    public void setHAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.halign = string;
        this.halignDirtyFlag = true;
    }

    public String getHAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHAlign();
        }
        return this.halign;
    }

    public boolean isHAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHAlignDirty();
        }
        return this.halignDirtyFlag;
    }

    public void resetHAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHAlign();
            return;
        }
        this.halignDirtyFlag = false;
        this.halign = null;
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

    public void setPlacement(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPlacement(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.placement = string;
        this.placementDirtyFlag = true;
    }

    public String getPlacement() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPlacement();
        }
        return this.placement;
    }

    public boolean isPlacementDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPlacementDirty();
        }
        return this.placementDirtyFlag;
    }

    public void resetPlacement() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPlacement();
            return;
        }
        this.placementDirtyFlag = false;
        this.placement = null;
    }

    public void setPlaceType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPlaceType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.placetype = string;
        this.placetypeDirtyFlag = true;
    }

    public String getPlaceType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPlaceType();
        }
        return this.placetype;
    }

    public boolean isPlaceTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPlaceTypeDirty();
        }
        return this.placetypeDirtyFlag;
    }

    public void resetPlaceType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPlaceType();
            return;
        }
        this.placetypeDirtyFlag = false;
        this.placetype = null;
    }

    public void setPPSSysBIReportItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysBIReportItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysbireportitemid = string;
        this.ppssysbireportitemidDirtyFlag = true;
    }

    public String getPPSSysBIReportItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysBIReportItemId();
        }
        return this.ppssysbireportitemid;
    }

    public boolean isPPSSysBIReportItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysBIReportItemIdDirty();
        }
        return this.ppssysbireportitemidDirtyFlag;
    }

    public void resetPPSSysBIReportItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysBIReportItemId();
            return;
        }
        this.ppssysbireportitemidDirtyFlag = false;
        this.ppssysbireportitemid = null;
    }

    public void setPPSSysBIReportItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysBIReportItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysbireportitemname = string;
        this.ppssysbireportitemnameDirtyFlag = true;
    }

    public String getPPSSysBIReportItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysBIReportItemName();
        }
        return this.ppssysbireportitemname;
    }

    public boolean isPPSSysBIReportItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysBIReportItemNameDirty();
        }
        return this.ppssysbireportitemnameDirtyFlag;
    }

    public void resetPPSSysBIReportItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysBIReportItemName();
            return;
        }
        this.ppssysbireportitemnameDirtyFlag = false;
        this.ppssysbireportitemname = null;
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

    public void setPSSysBIReportId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIReportId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbireportid = string;
        this.pssysbireportidDirtyFlag = true;
    }

    public String getPSSysBIReportId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIReportId();
        }
        return this.pssysbireportid;
    }

    public boolean isPSSysBIReportIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIReportIdDirty();
        }
        return this.pssysbireportidDirtyFlag;
    }

    public void resetPSSysBIReportId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIReportId();
            return;
        }
        this.pssysbireportidDirtyFlag = false;
        this.pssysbireportid = null;
    }

    public void setPSSysBIReportItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIReportItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbireportitemid = string;
        this.pssysbireportitemidDirtyFlag = true;
    }

    public String getPSSysBIReportItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIReportItemId();
        }
        return this.pssysbireportitemid;
    }

    public boolean isPSSysBIReportItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIReportItemIdDirty();
        }
        return this.pssysbireportitemidDirtyFlag;
    }

    public void resetPSSysBIReportItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIReportItemId();
            return;
        }
        this.pssysbireportitemidDirtyFlag = false;
        this.pssysbireportitemid = null;
    }

    public void setPSSysBIReportItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIReportItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbireportitemname = string;
        this.pssysbireportitemnameDirtyFlag = true;
    }

    public String getPSSysBIReportItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIReportItemName();
        }
        return this.pssysbireportitemname;
    }

    public boolean isPSSysBIReportItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIReportItemNameDirty();
        }
        return this.pssysbireportitemnameDirtyFlag;
    }

    public void resetPSSysBIReportItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIReportItemName();
            return;
        }
        this.pssysbireportitemnameDirtyFlag = false;
        this.pssysbireportitemname = null;
    }

    public void setPSSysBIReportName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIReportName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbireportname = string;
        this.pssysbireportnameDirtyFlag = true;
    }

    public String getPSSysBIReportName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIReportName();
        }
        return this.pssysbireportname;
    }

    public boolean isPSSysBIReportNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIReportNameDirty();
        }
        return this.pssysbireportnameDirtyFlag;
    }

    public void resetPSSysBIReportName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIReportName();
            return;
        }
        this.pssysbireportnameDirtyFlag = false;
        this.pssysbireportname = null;
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

    public void setRefPSSysBICubeMeasureId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysBICubeMeasureId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssysbicubemeasureid = string;
        this.refpssysbicubemeasureidDirtyFlag = true;
    }

    public String getRefPSSysBICubeMeasureId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysBICubeMeasureId();
        }
        return this.refpssysbicubemeasureid;
    }

    public boolean isRefPSSysBICubeMeasureIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysBICubeMeasureIdDirty();
        }
        return this.refpssysbicubemeasureidDirtyFlag;
    }

    public void resetRefPSSysBICubeMeasureId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysBICubeMeasureId();
            return;
        }
        this.refpssysbicubemeasureidDirtyFlag = false;
        this.refpssysbicubemeasureid = null;
    }

    public void setRefPSSysBICubeMeasureName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysBICubeMeasureName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssysbicubemeasurename = string;
        this.refpssysbicubemeasurenameDirtyFlag = true;
    }

    public String getRefPSSysBICubeMeasureName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysBICubeMeasureName();
        }
        return this.refpssysbicubemeasurename;
    }

    public boolean isRefPSSysBICubeMeasureNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysBICubeMeasureNameDirty();
        }
        return this.refpssysbicubemeasurenameDirtyFlag;
    }

    public void resetRefPSSysBICubeMeasureName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysBICubeMeasureName();
            return;
        }
        this.refpssysbicubemeasurenameDirtyFlag = false;
        this.refpssysbicubemeasurename = null;
    }

    public void setRefType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reftype = string;
        this.reftypeDirtyFlag = true;
    }

    public String getRefType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefType();
        }
        return this.reftype;
    }

    public boolean isRefTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefTypeDirty();
        }
        return this.reftypeDirtyFlag;
    }

    public void resetRefType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefType();
            return;
        }
        this.reftypeDirtyFlag = false;
        this.reftype = null;
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

    public void setVAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valign = string;
        this.valignDirtyFlag = true;
    }

    public String getVAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVAlign();
        }
        return this.valign;
    }

    public boolean isVAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVAlignDirty();
        }
        return this.valignDirtyFlag;
    }

    public void resetVAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVAlign();
            return;
        }
        this.valignDirtyFlag = false;
        this.valign = null;
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

    public void setWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidth(n);
            return;
        }
        this.width = n;
        this.widthDirtyFlag = true;
    }

    public Integer getWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidth();
        }
        return this.width;
    }

    public boolean isWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthDirty();
        }
        return this.widthDirtyFlag;
    }

    public void resetWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidth();
            return;
        }
        this.widthDirtyFlag = false;
        this.width = null;
    }

    public void setWidthUnit(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidthUnit(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.widthunit = string;
        this.widthunitDirtyFlag = true;
    }

    public String getWidthUnit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidthUnit();
        }
        return this.widthunit;
    }

    public boolean isWidthUnitDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthUnitDirty();
        }
        return this.widthunitDirtyFlag;
    }

    public void resetWidthUnit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidthUnit();
            return;
        }
        this.widthunitDirtyFlag = false;
        this.widthunit = null;
    }

    protected void onReset() {
        PSSysBIReportItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBIReportItemBase pSSysBIReportItemBase) {
        pSSysBIReportItemBase.resetAggType();
        pSSysBIReportItemBase.resetBIRepItemParams();
        pSSysBIReportItemBase.resetBIRepItemTag();
        pSSysBIReportItemBase.resetBIRepItemTag2();
        pSSysBIReportItemBase.resetBIRepItemType();
        pSSysBIReportItemBase.resetCodeName();
        pSSysBIReportItemBase.resetCreateDate();
        pSSysBIReportItemBase.resetCreateMan();
        pSSysBIReportItemBase.resetData();
        pSSysBIReportItemBase.resetHAlign();
        pSSysBIReportItemBase.resetMemo();
        pSSysBIReportItemBase.resetOrderValue();
        pSSysBIReportItemBase.resetPlacement();
        pSSysBIReportItemBase.resetPlaceType();
        pSSysBIReportItemBase.resetPPSSysBIReportItemId();
        pSSysBIReportItemBase.resetPPSSysBIReportItemName();
        pSSysBIReportItemBase.resetPSSysBICubeDimensionId();
        pSSysBIReportItemBase.resetPSSysBICubeDimensionName();
        pSSysBIReportItemBase.resetPSSysBICubeId();
        pSSysBIReportItemBase.resetPSSysBICubeLevelId();
        pSSysBIReportItemBase.resetPSSysBICubeLevelName();
        pSSysBIReportItemBase.resetPSSysBICubeMeasureId();
        pSSysBIReportItemBase.resetPSSysBICubeMeasureName();
        pSSysBIReportItemBase.resetPSSysBICubeName();
        pSSysBIReportItemBase.resetPSSysBIReportId();
        pSSysBIReportItemBase.resetPSSysBIReportItemId();
        pSSysBIReportItemBase.resetPSSysBIReportItemName();
        pSSysBIReportItemBase.resetPSSysBIReportName();
        pSSysBIReportItemBase.resetPSSysBISchemeId();
        pSSysBIReportItemBase.resetRefPSSysBICubeMeasureId();
        pSSysBIReportItemBase.resetRefPSSysBICubeMeasureName();
        pSSysBIReportItemBase.resetRefType();
        pSSysBIReportItemBase.resetUpdateDate();
        pSSysBIReportItemBase.resetUpdateMan();
        pSSysBIReportItemBase.resetUserCat();
        pSSysBIReportItemBase.resetUserTag();
        pSSysBIReportItemBase.resetUserTag2();
        pSSysBIReportItemBase.resetUserTag3();
        pSSysBIReportItemBase.resetUserTag4();
        pSSysBIReportItemBase.resetValidFlag();
        pSSysBIReportItemBase.resetVAlign();
        pSSysBIReportItemBase.resetValueFormat();
        pSSysBIReportItemBase.resetWidth();
        pSSysBIReportItemBase.resetWidthUnit();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAggTypeDirty()) {
            hashMap.put(FIELD_AGGTYPE, this.getAggType());
        }
        if (!bl || this.isBIRepItemParamsDirty()) {
            hashMap.put(FIELD_BIREPITEMPARAMS, this.getBIRepItemParams());
        }
        if (!bl || this.isBIRepItemTagDirty()) {
            hashMap.put(FIELD_BIREPITEMTAG, this.getBIRepItemTag());
        }
        if (!bl || this.isBIRepItemTag2Dirty()) {
            hashMap.put(FIELD_BIREPITEMTAG2, this.getBIRepItemTag2());
        }
        if (!bl || this.isBIRepItemTypeDirty()) {
            hashMap.put(FIELD_BIREPITEMTYPE, this.getBIRepItemType());
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
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isHAlignDirty()) {
            hashMap.put(FIELD_HALIGN, this.getHAlign());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPlacementDirty()) {
            hashMap.put(FIELD_PLACEMENT, this.getPlacement());
        }
        if (!bl || this.isPlaceTypeDirty()) {
            hashMap.put(FIELD_PLACETYPE, this.getPlaceType());
        }
        if (!bl || this.isPPSSysBIReportItemIdDirty()) {
            hashMap.put(FIELD_PPSSYSBIREPORTITEMID, this.getPPSSysBIReportItemId());
        }
        if (!bl || this.isPPSSysBIReportItemNameDirty()) {
            hashMap.put(FIELD_PPSSYSBIREPORTITEMNAME, this.getPPSSysBIReportItemName());
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
        if (!bl || this.isPSSysBICubeNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBENAME, this.getPSSysBICubeName());
        }
        if (!bl || this.isPSSysBIReportIdDirty()) {
            hashMap.put(FIELD_PSSYSBIREPORTID, this.getPSSysBIReportId());
        }
        if (!bl || this.isPSSysBIReportItemIdDirty()) {
            hashMap.put(FIELD_PSSYSBIREPORTITEMID, this.getPSSysBIReportItemId());
        }
        if (!bl || this.isPSSysBIReportItemNameDirty()) {
            hashMap.put(FIELD_PSSYSBIREPORTITEMNAME, this.getPSSysBIReportItemName());
        }
        if (!bl || this.isPSSysBIReportNameDirty()) {
            hashMap.put(FIELD_PSSYSBIREPORTNAME, this.getPSSysBIReportName());
        }
        if (!bl || this.isPSSysBISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMEID, this.getPSSysBISchemeId());
        }
        if (!bl || this.isRefPSSysBICubeMeasureIdDirty()) {
            hashMap.put(FIELD_REFPSSYSBICUBEMEASUREID, this.getRefPSSysBICubeMeasureId());
        }
        if (!bl || this.isRefPSSysBICubeMeasureNameDirty()) {
            hashMap.put(FIELD_REFPSSYSBICUBEMEASURENAME, this.getRefPSSysBICubeMeasureName());
        }
        if (!bl || this.isRefTypeDirty()) {
            hashMap.put(FIELD_REFTYPE, this.getRefType());
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
        if (!bl || this.isVAlignDirty()) {
            hashMap.put(FIELD_VALIGN, this.getVAlign());
        }
        if (!bl || this.isValueFormatDirty()) {
            hashMap.put(FIELD_VALUEFORMAT, this.getValueFormat());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
        }
        if (!bl || this.isWidthUnitDirty()) {
            hashMap.put(FIELD_WIDTHUNIT, this.getWidthUnit());
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
        return PSSysBIReportItemBase.get(this, n);
    }

    private static Object get(PSSysBIReportItemBase pSSysBIReportItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIReportItemBase.getAggType();
            }
            case 1: {
                return pSSysBIReportItemBase.getBIRepItemParams();
            }
            case 2: {
                return pSSysBIReportItemBase.getBIRepItemTag();
            }
            case 3: {
                return pSSysBIReportItemBase.getBIRepItemTag2();
            }
            case 4: {
                return pSSysBIReportItemBase.getBIRepItemType();
            }
            case 5: {
                return pSSysBIReportItemBase.getCodeName();
            }
            case 6: {
                return pSSysBIReportItemBase.getCreateDate();
            }
            case 7: {
                return pSSysBIReportItemBase.getCreateMan();
            }
            case 8: {
                return pSSysBIReportItemBase.getData();
            }
            case 9: {
                return pSSysBIReportItemBase.getHAlign();
            }
            case 10: {
                return pSSysBIReportItemBase.getMemo();
            }
            case 11: {
                return pSSysBIReportItemBase.getOrderValue();
            }
            case 12: {
                return pSSysBIReportItemBase.getPlacement();
            }
            case 13: {
                return pSSysBIReportItemBase.getPlaceType();
            }
            case 14: {
                return pSSysBIReportItemBase.getPPSSysBIReportItemId();
            }
            case 15: {
                return pSSysBIReportItemBase.getPPSSysBIReportItemName();
            }
            case 16: {
                return pSSysBIReportItemBase.getPSSysBICubeDimensionId();
            }
            case 17: {
                return pSSysBIReportItemBase.getPSSysBICubeDimensionName();
            }
            case 18: {
                return pSSysBIReportItemBase.getPSSysBICubeId();
            }
            case 19: {
                return pSSysBIReportItemBase.getPSSysBICubeLevelId();
            }
            case 20: {
                return pSSysBIReportItemBase.getPSSysBICubeLevelName();
            }
            case 21: {
                return pSSysBIReportItemBase.getPSSysBICubeMeasureId();
            }
            case 22: {
                return pSSysBIReportItemBase.getPSSysBICubeMeasureName();
            }
            case 23: {
                return pSSysBIReportItemBase.getPSSysBICubeName();
            }
            case 24: {
                return pSSysBIReportItemBase.getPSSysBIReportId();
            }
            case 25: {
                return pSSysBIReportItemBase.getPSSysBIReportItemId();
            }
            case 26: {
                return pSSysBIReportItemBase.getPSSysBIReportItemName();
            }
            case 27: {
                return pSSysBIReportItemBase.getPSSysBIReportName();
            }
            case 28: {
                return pSSysBIReportItemBase.getPSSysBISchemeId();
            }
            case 29: {
                return pSSysBIReportItemBase.getRefPSSysBICubeMeasureId();
            }
            case 30: {
                return pSSysBIReportItemBase.getRefPSSysBICubeMeasureName();
            }
            case 31: {
                return pSSysBIReportItemBase.getRefType();
            }
            case 32: {
                return pSSysBIReportItemBase.getUpdateDate();
            }
            case 33: {
                return pSSysBIReportItemBase.getUpdateMan();
            }
            case 34: {
                return pSSysBIReportItemBase.getUserCat();
            }
            case 35: {
                return pSSysBIReportItemBase.getUserTag();
            }
            case 36: {
                return pSSysBIReportItemBase.getUserTag2();
            }
            case 37: {
                return pSSysBIReportItemBase.getUserTag3();
            }
            case 38: {
                return pSSysBIReportItemBase.getUserTag4();
            }
            case 39: {
                return pSSysBIReportItemBase.getValidFlag();
            }
            case 40: {
                return pSSysBIReportItemBase.getVAlign();
            }
            case 41: {
                return pSSysBIReportItemBase.getValueFormat();
            }
            case 42: {
                return pSSysBIReportItemBase.getWidth();
            }
            case 43: {
                return pSSysBIReportItemBase.getWidthUnit();
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
        PSSysBIReportItemBase.set(this, n, object);
    }

    private static void set(PSSysBIReportItemBase pSSysBIReportItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBIReportItemBase.setAggType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBIReportItemBase.setBIRepItemParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBIReportItemBase.setBIRepItemTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBIReportItemBase.setBIRepItemTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBIReportItemBase.setBIRepItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBIReportItemBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBIReportItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSysBIReportItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBIReportItemBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBIReportItemBase.setHAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBIReportItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBIReportItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysBIReportItemBase.setPlacement(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBIReportItemBase.setPlaceType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBIReportItemBase.setPPSSysBIReportItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBIReportItemBase.setPPSSysBIReportItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBIReportItemBase.setPSSysBICubeDimensionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysBIReportItemBase.setPSSysBICubeDimensionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBIReportItemBase.setPSSysBICubeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBIReportItemBase.setPSSysBICubeLevelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysBIReportItemBase.setPSSysBICubeLevelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBIReportItemBase.setPSSysBICubeMeasureId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBIReportItemBase.setPSSysBICubeMeasureName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBIReportItemBase.setPSSysBICubeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBIReportItemBase.setPSSysBIReportId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysBIReportItemBase.setPSSysBIReportItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysBIReportItemBase.setPSSysBIReportItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysBIReportItemBase.setPSSysBIReportName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysBIReportItemBase.setPSSysBISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysBIReportItemBase.setRefPSSysBICubeMeasureId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysBIReportItemBase.setRefPSSysBICubeMeasureName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysBIReportItemBase.setRefType(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysBIReportItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 33: {
                pSSysBIReportItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysBIReportItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysBIReportItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysBIReportItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysBIReportItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysBIReportItemBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysBIReportItemBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSSysBIReportItemBase.setVAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysBIReportItemBase.setValueFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysBIReportItemBase.setWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSSysBIReportItemBase.setWidthUnit(DataObject.getStringValue((Object)object));
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
        return PSSysBIReportItemBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBIReportItemBase pSSysBIReportItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIReportItemBase.getAggType() == null;
            }
            case 1: {
                return pSSysBIReportItemBase.getBIRepItemParams() == null;
            }
            case 2: {
                return pSSysBIReportItemBase.getBIRepItemTag() == null;
            }
            case 3: {
                return pSSysBIReportItemBase.getBIRepItemTag2() == null;
            }
            case 4: {
                return pSSysBIReportItemBase.getBIRepItemType() == null;
            }
            case 5: {
                return pSSysBIReportItemBase.getCodeName() == null;
            }
            case 6: {
                return pSSysBIReportItemBase.getCreateDate() == null;
            }
            case 7: {
                return pSSysBIReportItemBase.getCreateMan() == null;
            }
            case 8: {
                return pSSysBIReportItemBase.getData() == null;
            }
            case 9: {
                return pSSysBIReportItemBase.getHAlign() == null;
            }
            case 10: {
                return pSSysBIReportItemBase.getMemo() == null;
            }
            case 11: {
                return pSSysBIReportItemBase.getOrderValue() == null;
            }
            case 12: {
                return pSSysBIReportItemBase.getPlacement() == null;
            }
            case 13: {
                return pSSysBIReportItemBase.getPlaceType() == null;
            }
            case 14: {
                return pSSysBIReportItemBase.getPPSSysBIReportItemId() == null;
            }
            case 15: {
                return pSSysBIReportItemBase.getPPSSysBIReportItemName() == null;
            }
            case 16: {
                return pSSysBIReportItemBase.getPSSysBICubeDimensionId() == null;
            }
            case 17: {
                return pSSysBIReportItemBase.getPSSysBICubeDimensionName() == null;
            }
            case 18: {
                return pSSysBIReportItemBase.getPSSysBICubeId() == null;
            }
            case 19: {
                return pSSysBIReportItemBase.getPSSysBICubeLevelId() == null;
            }
            case 20: {
                return pSSysBIReportItemBase.getPSSysBICubeLevelName() == null;
            }
            case 21: {
                return pSSysBIReportItemBase.getPSSysBICubeMeasureId() == null;
            }
            case 22: {
                return pSSysBIReportItemBase.getPSSysBICubeMeasureName() == null;
            }
            case 23: {
                return pSSysBIReportItemBase.getPSSysBICubeName() == null;
            }
            case 24: {
                return pSSysBIReportItemBase.getPSSysBIReportId() == null;
            }
            case 25: {
                return pSSysBIReportItemBase.getPSSysBIReportItemId() == null;
            }
            case 26: {
                return pSSysBIReportItemBase.getPSSysBIReportItemName() == null;
            }
            case 27: {
                return pSSysBIReportItemBase.getPSSysBIReportName() == null;
            }
            case 28: {
                return pSSysBIReportItemBase.getPSSysBISchemeId() == null;
            }
            case 29: {
                return pSSysBIReportItemBase.getRefPSSysBICubeMeasureId() == null;
            }
            case 30: {
                return pSSysBIReportItemBase.getRefPSSysBICubeMeasureName() == null;
            }
            case 31: {
                return pSSysBIReportItemBase.getRefType() == null;
            }
            case 32: {
                return pSSysBIReportItemBase.getUpdateDate() == null;
            }
            case 33: {
                return pSSysBIReportItemBase.getUpdateMan() == null;
            }
            case 34: {
                return pSSysBIReportItemBase.getUserCat() == null;
            }
            case 35: {
                return pSSysBIReportItemBase.getUserTag() == null;
            }
            case 36: {
                return pSSysBIReportItemBase.getUserTag2() == null;
            }
            case 37: {
                return pSSysBIReportItemBase.getUserTag3() == null;
            }
            case 38: {
                return pSSysBIReportItemBase.getUserTag4() == null;
            }
            case 39: {
                return pSSysBIReportItemBase.getValidFlag() == null;
            }
            case 40: {
                return pSSysBIReportItemBase.getVAlign() == null;
            }
            case 41: {
                return pSSysBIReportItemBase.getValueFormat() == null;
            }
            case 42: {
                return pSSysBIReportItemBase.getWidth() == null;
            }
            case 43: {
                return pSSysBIReportItemBase.getWidthUnit() == null;
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
        return PSSysBIReportItemBase.contains(this, n);
    }

    private static boolean contains(PSSysBIReportItemBase pSSysBIReportItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIReportItemBase.isAggTypeDirty();
            }
            case 1: {
                return pSSysBIReportItemBase.isBIRepItemParamsDirty();
            }
            case 2: {
                return pSSysBIReportItemBase.isBIRepItemTagDirty();
            }
            case 3: {
                return pSSysBIReportItemBase.isBIRepItemTag2Dirty();
            }
            case 4: {
                return pSSysBIReportItemBase.isBIRepItemTypeDirty();
            }
            case 5: {
                return pSSysBIReportItemBase.isCodeNameDirty();
            }
            case 6: {
                return pSSysBIReportItemBase.isCreateDateDirty();
            }
            case 7: {
                return pSSysBIReportItemBase.isCreateManDirty();
            }
            case 8: {
                return pSSysBIReportItemBase.isDataDirty();
            }
            case 9: {
                return pSSysBIReportItemBase.isHAlignDirty();
            }
            case 10: {
                return pSSysBIReportItemBase.isMemoDirty();
            }
            case 11: {
                return pSSysBIReportItemBase.isOrderValueDirty();
            }
            case 12: {
                return pSSysBIReportItemBase.isPlacementDirty();
            }
            case 13: {
                return pSSysBIReportItemBase.isPlaceTypeDirty();
            }
            case 14: {
                return pSSysBIReportItemBase.isPPSSysBIReportItemIdDirty();
            }
            case 15: {
                return pSSysBIReportItemBase.isPPSSysBIReportItemNameDirty();
            }
            case 16: {
                return pSSysBIReportItemBase.isPSSysBICubeDimensionIdDirty();
            }
            case 17: {
                return pSSysBIReportItemBase.isPSSysBICubeDimensionNameDirty();
            }
            case 18: {
                return pSSysBIReportItemBase.isPSSysBICubeIdDirty();
            }
            case 19: {
                return pSSysBIReportItemBase.isPSSysBICubeLevelIdDirty();
            }
            case 20: {
                return pSSysBIReportItemBase.isPSSysBICubeLevelNameDirty();
            }
            case 21: {
                return pSSysBIReportItemBase.isPSSysBICubeMeasureIdDirty();
            }
            case 22: {
                return pSSysBIReportItemBase.isPSSysBICubeMeasureNameDirty();
            }
            case 23: {
                return pSSysBIReportItemBase.isPSSysBICubeNameDirty();
            }
            case 24: {
                return pSSysBIReportItemBase.isPSSysBIReportIdDirty();
            }
            case 25: {
                return pSSysBIReportItemBase.isPSSysBIReportItemIdDirty();
            }
            case 26: {
                return pSSysBIReportItemBase.isPSSysBIReportItemNameDirty();
            }
            case 27: {
                return pSSysBIReportItemBase.isPSSysBIReportNameDirty();
            }
            case 28: {
                return pSSysBIReportItemBase.isPSSysBISchemeIdDirty();
            }
            case 29: {
                return pSSysBIReportItemBase.isRefPSSysBICubeMeasureIdDirty();
            }
            case 30: {
                return pSSysBIReportItemBase.isRefPSSysBICubeMeasureNameDirty();
            }
            case 31: {
                return pSSysBIReportItemBase.isRefTypeDirty();
            }
            case 32: {
                return pSSysBIReportItemBase.isUpdateDateDirty();
            }
            case 33: {
                return pSSysBIReportItemBase.isUpdateManDirty();
            }
            case 34: {
                return pSSysBIReportItemBase.isUserCatDirty();
            }
            case 35: {
                return pSSysBIReportItemBase.isUserTagDirty();
            }
            case 36: {
                return pSSysBIReportItemBase.isUserTag2Dirty();
            }
            case 37: {
                return pSSysBIReportItemBase.isUserTag3Dirty();
            }
            case 38: {
                return pSSysBIReportItemBase.isUserTag4Dirty();
            }
            case 39: {
                return pSSysBIReportItemBase.isValidFlagDirty();
            }
            case 40: {
                return pSSysBIReportItemBase.isVAlignDirty();
            }
            case 41: {
                return pSSysBIReportItemBase.isValueFormatDirty();
            }
            case 42: {
                return pSSysBIReportItemBase.isWidthDirty();
            }
            case 43: {
                return pSSysBIReportItemBase.isWidthUnitDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBIReportItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBIReportItemBase pSSysBIReportItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBIReportItemBase.getAggType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggtype", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getAggType()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getBIRepItemParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"birepitemparams", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getBIRepItemParams()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getBIRepItemTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"birepitemtag", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getBIRepItemTag()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getBIRepItemTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"birepitemtag2", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getBIRepItemTag2()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getBIRepItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"birepitemtype", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getBIRepItemType()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getData()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getHAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"halign", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getHAlign()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPlacement() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"placement", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPlacement()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPlaceType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"placetype", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPlaceType()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPPSSysBIReportItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysbireportitemid", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPPSSysBIReportItemId()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPPSSysBIReportItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysbireportitemname", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPPSSysBIReportItemName()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeDimensionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubedimensionid", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPSSysBICubeDimensionId()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeDimensionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubedimensionname", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPSSysBICubeDimensionName()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubeid", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPSSysBICubeId()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeLevelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubelevelid", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPSSysBICubeLevelId()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeLevelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubelevelname", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPSSysBICubeLevelName()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeMeasureId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubemeasureid", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPSSysBICubeMeasureId()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeMeasureName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubemeasurename", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPSSysBICubeMeasureName()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubename", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPSSysBICubeName()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBIReportId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbireportid", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPSSysBIReportId()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBIReportItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbireportitemid", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPSSysBIReportItemId()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBIReportItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbireportitemname", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPSSysBIReportItemName()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBIReportName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbireportname", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPSSysBIReportName()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemeid", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getPSSysBISchemeId()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getRefPSSysBICubeMeasureId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssysbicubemeasureid", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getRefPSSysBICubeMeasureId()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getRefPSSysBICubeMeasureName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssysbicubemeasurename", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getRefPSSysBICubeMeasureName()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getRefType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reftype", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getRefType()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getVAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valign", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getVAlign()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getValueFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueformat", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getValueFormat()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getWidth()), (boolean)false);
        }
        if (bl || pSSysBIReportItemBase.getWidthUnit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"widthunit", (Object)PSSysBIReportItemBase.getJSONValue((Object)pSSysBIReportItemBase.getWidthUnit()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBIReportItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBIReportItemBase pSSysBIReportItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBIReportItemBase.getAggType() != null) {
            object = pSSysBIReportItemBase.getAggType();
            xmlNode.setAttribute(FIELD_AGGTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIReportItemBase.getBIRepItemParams() != null) {
            object = pSSysBIReportItemBase.getBIRepItemParams();
            xmlNode.setAttribute(FIELD_BIREPITEMPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIReportItemBase.getBIRepItemTag() != null) {
            object = pSSysBIReportItemBase.getBIRepItemTag();
            xmlNode.setAttribute(FIELD_BIREPITEMTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIReportItemBase.getBIRepItemTag2() != null) {
            object = pSSysBIReportItemBase.getBIRepItemTag2();
            xmlNode.setAttribute(FIELD_BIREPITEMTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIReportItemBase.getBIRepItemType() != null) {
            object = pSSysBIReportItemBase.getBIRepItemType();
            xmlNode.setAttribute(FIELD_BIREPITEMTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIReportItemBase.getCodeName() != null) {
            object = pSSysBIReportItemBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getCreateDate() != null) {
            object = pSSysBIReportItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBIReportItemBase.getCreateMan() != null) {
            object = pSSysBIReportItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getData() != null) {
            object = pSSysBIReportItemBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getHAlign() != null) {
            object = pSSysBIReportItemBase.getHAlign();
            xmlNode.setAttribute(FIELD_HALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getMemo() != null) {
            object = pSSysBIReportItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getOrderValue() != null) {
            object = pSSysBIReportItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBIReportItemBase.getPlacement() != null) {
            object = pSSysBIReportItemBase.getPlacement();
            xmlNode.setAttribute(FIELD_PLACEMENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPlaceType() != null) {
            object = pSSysBIReportItemBase.getPlaceType();
            xmlNode.setAttribute(FIELD_PLACETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPPSSysBIReportItemId() != null) {
            object = pSSysBIReportItemBase.getPPSSysBIReportItemId();
            xmlNode.setAttribute(FIELD_PPSSYSBIREPORTITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPPSSysBIReportItemName() != null) {
            object = pSSysBIReportItemBase.getPPSSysBIReportItemName();
            xmlNode.setAttribute(FIELD_PPSSYSBIREPORTITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeDimensionId() != null) {
            object = pSSysBIReportItemBase.getPSSysBICubeDimensionId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEDIMENSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeDimensionName() != null) {
            object = pSSysBIReportItemBase.getPSSysBICubeDimensionName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEDIMENSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeId() != null) {
            object = pSSysBIReportItemBase.getPSSysBICubeId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeLevelId() != null) {
            object = pSSysBIReportItemBase.getPSSysBICubeLevelId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBELEVELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeLevelName() != null) {
            object = pSSysBIReportItemBase.getPSSysBICubeLevelName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBELEVELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeMeasureId() != null) {
            object = pSSysBIReportItemBase.getPSSysBICubeMeasureId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEMEASUREID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeMeasureName() != null) {
            object = pSSysBIReportItemBase.getPSSysBICubeMeasureName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEMEASURENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBICubeName() != null) {
            object = pSSysBIReportItemBase.getPSSysBICubeName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBIReportId() != null) {
            object = pSSysBIReportItemBase.getPSSysBIReportId();
            xmlNode.setAttribute(FIELD_PSSYSBIREPORTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBIReportItemId() != null) {
            object = pSSysBIReportItemBase.getPSSysBIReportItemId();
            xmlNode.setAttribute(FIELD_PSSYSBIREPORTITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBIReportItemName() != null) {
            object = pSSysBIReportItemBase.getPSSysBIReportItemName();
            xmlNode.setAttribute(FIELD_PSSYSBIREPORTITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBIReportName() != null) {
            object = pSSysBIReportItemBase.getPSSysBIReportName();
            xmlNode.setAttribute(FIELD_PSSYSBIREPORTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getPSSysBISchemeId() != null) {
            object = pSSysBIReportItemBase.getPSSysBISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getRefPSSysBICubeMeasureId() != null) {
            object = pSSysBIReportItemBase.getRefPSSysBICubeMeasureId();
            xmlNode.setAttribute(FIELD_REFPSSYSBICUBEMEASUREID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getRefPSSysBICubeMeasureName() != null) {
            object = pSSysBIReportItemBase.getRefPSSysBICubeMeasureName();
            xmlNode.setAttribute(FIELD_REFPSSYSBICUBEMEASURENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getRefType() != null) {
            object = pSSysBIReportItemBase.getRefType();
            xmlNode.setAttribute(FIELD_REFTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getUpdateDate() != null) {
            object = pSSysBIReportItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBIReportItemBase.getUpdateMan() != null) {
            object = pSSysBIReportItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getUserCat() != null) {
            object = pSSysBIReportItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getUserTag() != null) {
            object = pSSysBIReportItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getUserTag2() != null) {
            object = pSSysBIReportItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getUserTag3() != null) {
            object = pSSysBIReportItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getUserTag4() != null) {
            object = pSSysBIReportItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getValidFlag() != null) {
            object = pSSysBIReportItemBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBIReportItemBase.getVAlign() != null) {
            object = pSSysBIReportItemBase.getVAlign();
            xmlNode.setAttribute(FIELD_VALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getValueFormat() != null) {
            object = pSSysBIReportItemBase.getValueFormat();
            xmlNode.setAttribute(FIELD_VALUEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportItemBase.getWidth() != null) {
            object = pSSysBIReportItemBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBIReportItemBase.getWidthUnit() != null) {
            object = pSSysBIReportItemBase.getWidthUnit();
            xmlNode.setAttribute(FIELD_WIDTHUNIT, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBIReportItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBIReportItemBase pSSysBIReportItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBIReportItemBase.isAggTypeDirty() && (bl || pSSysBIReportItemBase.getAggType() != null)) {
            iDataObject.set(FIELD_AGGTYPE, (Object)pSSysBIReportItemBase.getAggType());
        }
        if (pSSysBIReportItemBase.isBIRepItemParamsDirty() && (bl || pSSysBIReportItemBase.getBIRepItemParams() != null)) {
            iDataObject.set(FIELD_BIREPITEMPARAMS, (Object)pSSysBIReportItemBase.getBIRepItemParams());
        }
        if (pSSysBIReportItemBase.isBIRepItemTagDirty() && (bl || pSSysBIReportItemBase.getBIRepItemTag() != null)) {
            iDataObject.set(FIELD_BIREPITEMTAG, (Object)pSSysBIReportItemBase.getBIRepItemTag());
        }
        if (pSSysBIReportItemBase.isBIRepItemTag2Dirty() && (bl || pSSysBIReportItemBase.getBIRepItemTag2() != null)) {
            iDataObject.set(FIELD_BIREPITEMTAG2, (Object)pSSysBIReportItemBase.getBIRepItemTag2());
        }
        if (pSSysBIReportItemBase.isBIRepItemTypeDirty() && (bl || pSSysBIReportItemBase.getBIRepItemType() != null)) {
            iDataObject.set(FIELD_BIREPITEMTYPE, (Object)pSSysBIReportItemBase.getBIRepItemType());
        }
        if (pSSysBIReportItemBase.isCodeNameDirty() && (bl || pSSysBIReportItemBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBIReportItemBase.getCodeName());
        }
        if (pSSysBIReportItemBase.isCreateDateDirty() && (bl || pSSysBIReportItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBIReportItemBase.getCreateDate());
        }
        if (pSSysBIReportItemBase.isCreateManDirty() && (bl || pSSysBIReportItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBIReportItemBase.getCreateMan());
        }
        if (pSSysBIReportItemBase.isDataDirty() && (bl || pSSysBIReportItemBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSSysBIReportItemBase.getData());
        }
        if (pSSysBIReportItemBase.isHAlignDirty() && (bl || pSSysBIReportItemBase.getHAlign() != null)) {
            iDataObject.set(FIELD_HALIGN, (Object)pSSysBIReportItemBase.getHAlign());
        }
        if (pSSysBIReportItemBase.isMemoDirty() && (bl || pSSysBIReportItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBIReportItemBase.getMemo());
        }
        if (pSSysBIReportItemBase.isOrderValueDirty() && (bl || pSSysBIReportItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysBIReportItemBase.getOrderValue());
        }
        if (pSSysBIReportItemBase.isPlacementDirty() && (bl || pSSysBIReportItemBase.getPlacement() != null)) {
            iDataObject.set(FIELD_PLACEMENT, (Object)pSSysBIReportItemBase.getPlacement());
        }
        if (pSSysBIReportItemBase.isPlaceTypeDirty() && (bl || pSSysBIReportItemBase.getPlaceType() != null)) {
            iDataObject.set(FIELD_PLACETYPE, (Object)pSSysBIReportItemBase.getPlaceType());
        }
        if (pSSysBIReportItemBase.isPPSSysBIReportItemIdDirty() && (bl || pSSysBIReportItemBase.getPPSSysBIReportItemId() != null)) {
            iDataObject.set(FIELD_PPSSYSBIREPORTITEMID, (Object)pSSysBIReportItemBase.getPPSSysBIReportItemId());
        }
        if (pSSysBIReportItemBase.isPPSSysBIReportItemNameDirty() && (bl || pSSysBIReportItemBase.getPPSSysBIReportItemName() != null)) {
            iDataObject.set(FIELD_PPSSYSBIREPORTITEMNAME, (Object)pSSysBIReportItemBase.getPPSSysBIReportItemName());
        }
        if (pSSysBIReportItemBase.isPSSysBICubeDimensionIdDirty() && (bl || pSSysBIReportItemBase.getPSSysBICubeDimensionId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEDIMENSIONID, (Object)pSSysBIReportItemBase.getPSSysBICubeDimensionId());
        }
        if (pSSysBIReportItemBase.isPSSysBICubeDimensionNameDirty() && (bl || pSSysBIReportItemBase.getPSSysBICubeDimensionName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEDIMENSIONNAME, (Object)pSSysBIReportItemBase.getPSSysBICubeDimensionName());
        }
        if (pSSysBIReportItemBase.isPSSysBICubeIdDirty() && (bl || pSSysBIReportItemBase.getPSSysBICubeId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEID, (Object)pSSysBIReportItemBase.getPSSysBICubeId());
        }
        if (pSSysBIReportItemBase.isPSSysBICubeLevelIdDirty() && (bl || pSSysBIReportItemBase.getPSSysBICubeLevelId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBELEVELID, (Object)pSSysBIReportItemBase.getPSSysBICubeLevelId());
        }
        if (pSSysBIReportItemBase.isPSSysBICubeLevelNameDirty() && (bl || pSSysBIReportItemBase.getPSSysBICubeLevelName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBELEVELNAME, (Object)pSSysBIReportItemBase.getPSSysBICubeLevelName());
        }
        if (pSSysBIReportItemBase.isPSSysBICubeMeasureIdDirty() && (bl || pSSysBIReportItemBase.getPSSysBICubeMeasureId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEMEASUREID, (Object)pSSysBIReportItemBase.getPSSysBICubeMeasureId());
        }
        if (pSSysBIReportItemBase.isPSSysBICubeMeasureNameDirty() && (bl || pSSysBIReportItemBase.getPSSysBICubeMeasureName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEMEASURENAME, (Object)pSSysBIReportItemBase.getPSSysBICubeMeasureName());
        }
        if (pSSysBIReportItemBase.isPSSysBICubeNameDirty() && (bl || pSSysBIReportItemBase.getPSSysBICubeName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBENAME, (Object)pSSysBIReportItemBase.getPSSysBICubeName());
        }
        if (pSSysBIReportItemBase.isPSSysBIReportIdDirty() && (bl || pSSysBIReportItemBase.getPSSysBIReportId() != null)) {
            iDataObject.set(FIELD_PSSYSBIREPORTID, (Object)pSSysBIReportItemBase.getPSSysBIReportId());
        }
        if (pSSysBIReportItemBase.isPSSysBIReportItemIdDirty() && (bl || pSSysBIReportItemBase.getPSSysBIReportItemId() != null)) {
            iDataObject.set(FIELD_PSSYSBIREPORTITEMID, (Object)pSSysBIReportItemBase.getPSSysBIReportItemId());
        }
        if (pSSysBIReportItemBase.isPSSysBIReportItemNameDirty() && (bl || pSSysBIReportItemBase.getPSSysBIReportItemName() != null)) {
            iDataObject.set(FIELD_PSSYSBIREPORTITEMNAME, (Object)pSSysBIReportItemBase.getPSSysBIReportItemName());
        }
        if (pSSysBIReportItemBase.isPSSysBIReportNameDirty() && (bl || pSSysBIReportItemBase.getPSSysBIReportName() != null)) {
            iDataObject.set(FIELD_PSSYSBIREPORTNAME, (Object)pSSysBIReportItemBase.getPSSysBIReportName());
        }
        if (pSSysBIReportItemBase.isPSSysBISchemeIdDirty() && (bl || pSSysBIReportItemBase.getPSSysBISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMEID, (Object)pSSysBIReportItemBase.getPSSysBISchemeId());
        }
        if (pSSysBIReportItemBase.isRefPSSysBICubeMeasureIdDirty() && (bl || pSSysBIReportItemBase.getRefPSSysBICubeMeasureId() != null)) {
            iDataObject.set(FIELD_REFPSSYSBICUBEMEASUREID, (Object)pSSysBIReportItemBase.getRefPSSysBICubeMeasureId());
        }
        if (pSSysBIReportItemBase.isRefPSSysBICubeMeasureNameDirty() && (bl || pSSysBIReportItemBase.getRefPSSysBICubeMeasureName() != null)) {
            iDataObject.set(FIELD_REFPSSYSBICUBEMEASURENAME, (Object)pSSysBIReportItemBase.getRefPSSysBICubeMeasureName());
        }
        if (pSSysBIReportItemBase.isRefTypeDirty() && (bl || pSSysBIReportItemBase.getRefType() != null)) {
            iDataObject.set(FIELD_REFTYPE, (Object)pSSysBIReportItemBase.getRefType());
        }
        if (pSSysBIReportItemBase.isUpdateDateDirty() && (bl || pSSysBIReportItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBIReportItemBase.getUpdateDate());
        }
        if (pSSysBIReportItemBase.isUpdateManDirty() && (bl || pSSysBIReportItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBIReportItemBase.getUpdateMan());
        }
        if (pSSysBIReportItemBase.isUserCatDirty() && (bl || pSSysBIReportItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBIReportItemBase.getUserCat());
        }
        if (pSSysBIReportItemBase.isUserTagDirty() && (bl || pSSysBIReportItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBIReportItemBase.getUserTag());
        }
        if (pSSysBIReportItemBase.isUserTag2Dirty() && (bl || pSSysBIReportItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBIReportItemBase.getUserTag2());
        }
        if (pSSysBIReportItemBase.isUserTag3Dirty() && (bl || pSSysBIReportItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBIReportItemBase.getUserTag3());
        }
        if (pSSysBIReportItemBase.isUserTag4Dirty() && (bl || pSSysBIReportItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBIReportItemBase.getUserTag4());
        }
        if (pSSysBIReportItemBase.isValidFlagDirty() && (bl || pSSysBIReportItemBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysBIReportItemBase.getValidFlag());
        }
        if (pSSysBIReportItemBase.isVAlignDirty() && (bl || pSSysBIReportItemBase.getVAlign() != null)) {
            iDataObject.set(FIELD_VALIGN, (Object)pSSysBIReportItemBase.getVAlign());
        }
        if (pSSysBIReportItemBase.isValueFormatDirty() && (bl || pSSysBIReportItemBase.getValueFormat() != null)) {
            iDataObject.set(FIELD_VALUEFORMAT, (Object)pSSysBIReportItemBase.getValueFormat());
        }
        if (pSSysBIReportItemBase.isWidthDirty() && (bl || pSSysBIReportItemBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSSysBIReportItemBase.getWidth());
        }
        if (pSSysBIReportItemBase.isWidthUnitDirty() && (bl || pSSysBIReportItemBase.getWidthUnit() != null)) {
            iDataObject.set(FIELD_WIDTHUNIT, (Object)pSSysBIReportItemBase.getWidthUnit());
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
        return PSSysBIReportItemBase.remove(this, n);
    }

    private static boolean remove(PSSysBIReportItemBase pSSysBIReportItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBIReportItemBase.resetAggType();
                return true;
            }
            case 1: {
                pSSysBIReportItemBase.resetBIRepItemParams();
                return true;
            }
            case 2: {
                pSSysBIReportItemBase.resetBIRepItemTag();
                return true;
            }
            case 3: {
                pSSysBIReportItemBase.resetBIRepItemTag2();
                return true;
            }
            case 4: {
                pSSysBIReportItemBase.resetBIRepItemType();
                return true;
            }
            case 5: {
                pSSysBIReportItemBase.resetCodeName();
                return true;
            }
            case 6: {
                pSSysBIReportItemBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSSysBIReportItemBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSSysBIReportItemBase.resetData();
                return true;
            }
            case 9: {
                pSSysBIReportItemBase.resetHAlign();
                return true;
            }
            case 10: {
                pSSysBIReportItemBase.resetMemo();
                return true;
            }
            case 11: {
                pSSysBIReportItemBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSSysBIReportItemBase.resetPlacement();
                return true;
            }
            case 13: {
                pSSysBIReportItemBase.resetPlaceType();
                return true;
            }
            case 14: {
                pSSysBIReportItemBase.resetPPSSysBIReportItemId();
                return true;
            }
            case 15: {
                pSSysBIReportItemBase.resetPPSSysBIReportItemName();
                return true;
            }
            case 16: {
                pSSysBIReportItemBase.resetPSSysBICubeDimensionId();
                return true;
            }
            case 17: {
                pSSysBIReportItemBase.resetPSSysBICubeDimensionName();
                return true;
            }
            case 18: {
                pSSysBIReportItemBase.resetPSSysBICubeId();
                return true;
            }
            case 19: {
                pSSysBIReportItemBase.resetPSSysBICubeLevelId();
                return true;
            }
            case 20: {
                pSSysBIReportItemBase.resetPSSysBICubeLevelName();
                return true;
            }
            case 21: {
                pSSysBIReportItemBase.resetPSSysBICubeMeasureId();
                return true;
            }
            case 22: {
                pSSysBIReportItemBase.resetPSSysBICubeMeasureName();
                return true;
            }
            case 23: {
                pSSysBIReportItemBase.resetPSSysBICubeName();
                return true;
            }
            case 24: {
                pSSysBIReportItemBase.resetPSSysBIReportId();
                return true;
            }
            case 25: {
                pSSysBIReportItemBase.resetPSSysBIReportItemId();
                return true;
            }
            case 26: {
                pSSysBIReportItemBase.resetPSSysBIReportItemName();
                return true;
            }
            case 27: {
                pSSysBIReportItemBase.resetPSSysBIReportName();
                return true;
            }
            case 28: {
                pSSysBIReportItemBase.resetPSSysBISchemeId();
                return true;
            }
            case 29: {
                pSSysBIReportItemBase.resetRefPSSysBICubeMeasureId();
                return true;
            }
            case 30: {
                pSSysBIReportItemBase.resetRefPSSysBICubeMeasureName();
                return true;
            }
            case 31: {
                pSSysBIReportItemBase.resetRefType();
                return true;
            }
            case 32: {
                pSSysBIReportItemBase.resetUpdateDate();
                return true;
            }
            case 33: {
                pSSysBIReportItemBase.resetUpdateMan();
                return true;
            }
            case 34: {
                pSSysBIReportItemBase.resetUserCat();
                return true;
            }
            case 35: {
                pSSysBIReportItemBase.resetUserTag();
                return true;
            }
            case 36: {
                pSSysBIReportItemBase.resetUserTag2();
                return true;
            }
            case 37: {
                pSSysBIReportItemBase.resetUserTag3();
                return true;
            }
            case 38: {
                pSSysBIReportItemBase.resetUserTag4();
                return true;
            }
            case 39: {
                pSSysBIReportItemBase.resetValidFlag();
                return true;
            }
            case 40: {
                pSSysBIReportItemBase.resetVAlign();
                return true;
            }
            case 41: {
                pSSysBIReportItemBase.resetValueFormat();
                return true;
            }
            case 42: {
                pSSysBIReportItemBase.resetWidth();
                return true;
            }
            case 43: {
                pSSysBIReportItemBase.resetWidthUnit();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBICubeMeasure getRefPSSysBICubeMeasure() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysBICubeMeasure();
        }
        if (this.getRefPSSysBICubeMeasureId() == null) {
            return null;
        }
        Integer n = this.objRefPSSysBICubeMeasureLock;
        synchronized (n) {
            if (this.refpssysbicubemeasure != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSSysBICubeMeasureId(), (Object)this.refpssysbicubemeasure.getPSSysBICubeMeasureId()) != 0L) {
                this.refpssysbicubemeasure = null;
            }
            if (this.refpssysbicubemeasure == null) {
                PSSysBICubeMeasure pSSysBICubeMeasure = new PSSysBICubeMeasure();
                pSSysBICubeMeasure.setPSSysBICubeMeasureId(this.getRefPSSysBICubeMeasureId());
                PSSysBICubeMeasureService pSSysBICubeMeasureService = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
                pSSysBICubeMeasureService.autoGet(pSSysBICubeMeasure);
                this.refpssysbicubemeasure = pSSysBICubeMeasure;
            }
            return this.refpssysbicubemeasure;
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
                pSSysBICubeService.autoGet(pSSysBICube);
                this.pssysbicube = pSSysBICube;
            }
            return this.pssysbicube;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBIReportItem getPPSSysBIReportItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysBIReportItem();
        }
        if (this.getPPSSysBIReportItemId() == null) {
            return null;
        }
        Integer n = this.objPPSSysBIReportItemLock;
        synchronized (n) {
            if (this.ppssysbireportitem != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysBIReportItemId(), (Object)this.ppssysbireportitem.getPSSysBIReportItemId()) != 0L) {
                this.ppssysbireportitem = null;
            }
            if (this.ppssysbireportitem == null) {
                PSSysBIReportItem pSSysBIReportItem = new PSSysBIReportItem();
                pSSysBIReportItem.setPSSysBIReportItemId(this.getPPSSysBIReportItemId());
                PSSysBIReportItemService pSSysBIReportItemService = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysBIReportItemService.autoGet(pSSysBIReportItem);
                this.ppssysbireportitem = pSSysBIReportItem;
            }
            return this.ppssysbireportitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBIReport getPSSysBIReport() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIReport();
        }
        if (this.getPSSysBIReportId() == null) {
            return null;
        }
        Integer n = this.objPSSysBIReportLock;
        synchronized (n) {
            if (this.pssysbireport != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBIReportId(), (Object)this.pssysbireport.getPSSysBIReportId()) != 0L) {
                this.pssysbireport = null;
            }
            if (this.pssysbireport == null) {
                PSSysBIReport pSSysBIReport = new PSSysBIReport();
                pSSysBIReport.setPSSysBIReportId(this.getPSSysBIReportId());
                PSSysBIReportService pSSysBIReportService = (PSSysBIReportService)ServiceGlobal.getService(PSSysBIReportService.class, (SessionFactory)this.getSessionFactory());
                pSSysBIReportService.autoGet(pSSysBIReport);
                this.pssysbireport = pSSysBIReport;
            }
            return this.pssysbireport;
        }
    }

    private PSSysBIReportItemBase getProxyEntity() {
        return this.proxyPSSysBIReportItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBIReportItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBIReportItemBase) {
            this.proxyPSSysBIReportItemBase = (PSSysBIReportItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AGGTYPE, 0);
        fieldIndexMap.put(FIELD_BIREPITEMPARAMS, 1);
        fieldIndexMap.put(FIELD_BIREPITEMTAG, 2);
        fieldIndexMap.put(FIELD_BIREPITEMTAG2, 3);
        fieldIndexMap.put(FIELD_BIREPITEMTYPE, 4);
        fieldIndexMap.put(FIELD_CODENAME, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_DATA, 8);
        fieldIndexMap.put(FIELD_HALIGN, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_ORDERVALUE, 11);
        fieldIndexMap.put(FIELD_PLACEMENT, 12);
        fieldIndexMap.put(FIELD_PLACETYPE, 13);
        fieldIndexMap.put(FIELD_PPSSYSBIREPORTITEMID, 14);
        fieldIndexMap.put(FIELD_PPSSYSBIREPORTITEMNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSBICUBEDIMENSIONID, 16);
        fieldIndexMap.put(FIELD_PSSYSBICUBEDIMENSIONNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSBICUBEID, 18);
        fieldIndexMap.put(FIELD_PSSYSBICUBELEVELID, 19);
        fieldIndexMap.put(FIELD_PSSYSBICUBELEVELNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSBICUBEMEASUREID, 21);
        fieldIndexMap.put(FIELD_PSSYSBICUBEMEASURENAME, 22);
        fieldIndexMap.put(FIELD_PSSYSBICUBENAME, 23);
        fieldIndexMap.put(FIELD_PSSYSBIREPORTID, 24);
        fieldIndexMap.put(FIELD_PSSYSBIREPORTITEMID, 25);
        fieldIndexMap.put(FIELD_PSSYSBIREPORTITEMNAME, 26);
        fieldIndexMap.put(FIELD_PSSYSBIREPORTNAME, 27);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMEID, 28);
        fieldIndexMap.put(FIELD_REFPSSYSBICUBEMEASUREID, 29);
        fieldIndexMap.put(FIELD_REFPSSYSBICUBEMEASURENAME, 30);
        fieldIndexMap.put(FIELD_REFTYPE, 31);
        fieldIndexMap.put(FIELD_UPDATEDATE, 32);
        fieldIndexMap.put(FIELD_UPDATEMAN, 33);
        fieldIndexMap.put(FIELD_USERCAT, 34);
        fieldIndexMap.put(FIELD_USERTAG, 35);
        fieldIndexMap.put(FIELD_USERTAG2, 36);
        fieldIndexMap.put(FIELD_USERTAG3, 37);
        fieldIndexMap.put(FIELD_USERTAG4, 38);
        fieldIndexMap.put(FIELD_VALIDFLAG, 39);
        fieldIndexMap.put(FIELD_VALIGN, 40);
        fieldIndexMap.put(FIELD_VALUEFORMAT, 41);
        fieldIndexMap.put(FIELD_WIDTH, 42);
        fieldIndexMap.put(FIELD_WIDTHUNIT, 43);
    }
}

