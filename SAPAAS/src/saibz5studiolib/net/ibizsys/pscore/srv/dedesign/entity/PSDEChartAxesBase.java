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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChart;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEChartAxesBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEChartAxesBase.class);
    public static final String FIELD_AXESDATA = "AXESDATA";
    public static final String FIELD_AXESDATA2 = "AXESDATA2";
    public static final String FIELD_AXESMAXVALUE = "AXESMAXVALUE";
    public static final String FIELD_AXESMINVALUE = "AXESMINVALUE";
    public static final String FIELD_AXESPOS = "AXESPOS";
    public static final String FIELD_AXESTYPE = "AXESTYPE";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_COORDINATESYSTEMID = "COORDINATESYSTEMID";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATASHOWMODE = "DATASHOWMODE";
    public static final String FIELD_DYNACLASS = "DYNACLASS";
    public static final String FIELD_FIELDS = "FIELDS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDECHARTAXESID = "PSDECHARTAXESID";
    public static final String FIELD_PSDECHARTAXESNAME = "PSDECHARTAXESNAME";
    public static final String FIELD_PSDECHARTID = "PSDECHARTID";
    public static final String FIELD_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_AXESDATA = 0;
    private static final int INDEX_AXESDATA2 = 1;
    private static final int INDEX_AXESMAXVALUE = 2;
    private static final int INDEX_AXESMINVALUE = 3;
    private static final int INDEX_AXESPOS = 4;
    private static final int INDEX_AXESTYPE = 5;
    private static final int INDEX_CAPPSLANRESID = 6;
    private static final int INDEX_CAPPSLANRESNAME = 7;
    private static final int INDEX_CAPTION = 8;
    private static final int INDEX_COORDINATESYSTEMID = 9;
    private static final int INDEX_CREATEDATE = 10;
    private static final int INDEX_CREATEMAN = 11;
    private static final int INDEX_DATASHOWMODE = 12;
    private static final int INDEX_DYNACLASS = 13;
    private static final int INDEX_FIELDS = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_ORDERVALUE = 16;
    private static final int INDEX_PSDECHARTAXESID = 17;
    private static final int INDEX_PSDECHARTAXESNAME = 18;
    private static final int INDEX_PSDECHARTID = 19;
    private static final int INDEX_PSDECHARTNAME = 20;
    private static final int INDEX_PSDEID = 21;
    private static final int INDEX_PSSYSDYNAMODELID = 22;
    private static final int INDEX_PSSYSDYNAMODELNAME = 23;
    private static final int INDEX_PSSYSPFPLUGINID = 24;
    private static final int INDEX_PSSYSPFPLUGINNAME = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USERCAT = 28;
    private static final int INDEX_USERPARAMS = 29;
    private static final int INDEX_USERTAG = 30;
    private static final int INDEX_USERTAG2 = 31;
    private static final int INDEX_USERTAG3 = 32;
    private static final int INDEX_USERTAG4 = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEChartAxesBase proxyPSDEChartAxesBase = null;
    private boolean axesdataDirtyFlag = false;
    private boolean axesdata2DirtyFlag = false;
    private boolean axesmaxvalueDirtyFlag = false;
    private boolean axesminvalueDirtyFlag = false;
    private boolean axesposDirtyFlag = false;
    private boolean axestypeDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean coordinatesystemidDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean datashowmodeDirtyFlag = false;
    private boolean dynaclassDirtyFlag = false;
    private boolean fieldsDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdechartaxesidDirtyFlag = false;
    private boolean psdechartaxesnameDirtyFlag = false;
    private boolean psdechartidDirtyFlag = false;
    private boolean psdechartnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="axesdata")
    private String axesdata;
    @Column(name="axesdata2")
    private String axesdata2;
    @Column(name="axesmaxvalue")
    private Double axesmaxvalue;
    @Column(name="axesminvalue")
    private Double axesminvalue;
    @Column(name="axespos")
    private String axespos;
    @Column(name="axestype")
    private String axestype;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="coordinatesystemid")
    private Integer coordinatesystemid;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="datashowmode")
    private Integer datashowmode;
    @Column(name="dynaclass")
    private String dynaclass;
    @Column(name="fields")
    private String fields;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdechartaxesid")
    private String psdechartaxesid;
    @Column(name="psdechartaxesname")
    private String psdechartaxesname;
    @Column(name="psdechartid")
    private String psdechartid;
    @Column(name="psdechartname")
    private String psdechartname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
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
    private Integer objPSDEChartLock = new Integer(1);
    private PSDEChart psdechart = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;

    public void setAxesData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAxesData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.axesdata = string;
        this.axesdataDirtyFlag = true;
    }

    public String getAxesData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAxesData();
        }
        return this.axesdata;
    }

    public boolean isAxesDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAxesDataDirty();
        }
        return this.axesdataDirtyFlag;
    }

    public void resetAxesData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAxesData();
            return;
        }
        this.axesdataDirtyFlag = false;
        this.axesdata = null;
    }

    public void setAxesData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAxesData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.axesdata2 = string;
        this.axesdata2DirtyFlag = true;
    }

    public String getAxesData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAxesData2();
        }
        return this.axesdata2;
    }

    public boolean isAxesData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAxesData2Dirty();
        }
        return this.axesdata2DirtyFlag;
    }

    public void resetAxesData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAxesData2();
            return;
        }
        this.axesdata2DirtyFlag = false;
        this.axesdata2 = null;
    }

    public void setAxesMaxValue(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAxesMaxValue(d);
            return;
        }
        this.axesmaxvalue = d;
        this.axesmaxvalueDirtyFlag = true;
    }

    public Double getAxesMaxValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAxesMaxValue();
        }
        return this.axesmaxvalue;
    }

    public boolean isAxesMaxValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAxesMaxValueDirty();
        }
        return this.axesmaxvalueDirtyFlag;
    }

    public void resetAxesMaxValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAxesMaxValue();
            return;
        }
        this.axesmaxvalueDirtyFlag = false;
        this.axesmaxvalue = null;
    }

    public void setAxesMinValue(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAxesMinValue(d);
            return;
        }
        this.axesminvalue = d;
        this.axesminvalueDirtyFlag = true;
    }

    public Double getAxesMinValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAxesMinValue();
        }
        return this.axesminvalue;
    }

    public boolean isAxesMinValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAxesMinValueDirty();
        }
        return this.axesminvalueDirtyFlag;
    }

    public void resetAxesMinValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAxesMinValue();
            return;
        }
        this.axesminvalueDirtyFlag = false;
        this.axesminvalue = null;
    }

    public void setAxesPos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAxesPos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.axespos = string;
        this.axesposDirtyFlag = true;
    }

    public String getAxesPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAxesPos();
        }
        return this.axespos;
    }

    public boolean isAxesPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAxesPosDirty();
        }
        return this.axesposDirtyFlag;
    }

    public void resetAxesPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAxesPos();
            return;
        }
        this.axesposDirtyFlag = false;
        this.axespos = null;
    }

    public void setAxesType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAxesType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.axestype = string;
        this.axestypeDirtyFlag = true;
    }

    public String getAxesType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAxesType();
        }
        return this.axestype;
    }

    public boolean isAxesTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAxesTypeDirty();
        }
        return this.axestypeDirtyFlag;
    }

    public void resetAxesType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAxesType();
            return;
        }
        this.axestypeDirtyFlag = false;
        this.axestype = null;
    }

    public void setCapPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresid = string;
        this.cappslanresidDirtyFlag = true;
    }

    public String getCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResId();
        }
        return this.cappslanresid;
    }

    public boolean isCapPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResIdDirty();
        }
        return this.cappslanresidDirtyFlag;
    }

    public void resetCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResId();
            return;
        }
        this.cappslanresidDirtyFlag = false;
        this.cappslanresid = null;
    }

    public void setCapPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresname = string;
        this.cappslanresnameDirtyFlag = true;
    }

    public String getCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResName();
        }
        return this.cappslanresname;
    }

    public boolean isCapPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResNameDirty();
        }
        return this.cappslanresnameDirtyFlag;
    }

    public void resetCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResName();
            return;
        }
        this.cappslanresnameDirtyFlag = false;
        this.cappslanresname = null;
    }

    public void setCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.caption = string;
        this.captionDirtyFlag = true;
    }

    public String getCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCaption();
        }
        return this.caption;
    }

    public boolean isCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCaptionDirty();
        }
        return this.captionDirtyFlag;
    }

    public void resetCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCaption();
            return;
        }
        this.captionDirtyFlag = false;
        this.caption = null;
    }

    public void setCoordinateSystemId(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCoordinateSystemId(n);
            return;
        }
        this.coordinatesystemid = n;
        this.coordinatesystemidDirtyFlag = true;
    }

    public Integer getCoordinateSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCoordinateSystemId();
        }
        return this.coordinatesystemid;
    }

    public boolean isCoordinateSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCoordinateSystemIdDirty();
        }
        return this.coordinatesystemidDirtyFlag;
    }

    public void resetCoordinateSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCoordinateSystemId();
            return;
        }
        this.coordinatesystemidDirtyFlag = false;
        this.coordinatesystemid = null;
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

    public void setDataShowMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataShowMode(n);
            return;
        }
        this.datashowmode = n;
        this.datashowmodeDirtyFlag = true;
    }

    public Integer getDataShowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataShowMode();
        }
        return this.datashowmode;
    }

    public boolean isDataShowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataShowModeDirty();
        }
        return this.datashowmodeDirtyFlag;
    }

    public void resetDataShowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataShowMode();
            return;
        }
        this.datashowmodeDirtyFlag = false;
        this.datashowmode = null;
    }

    public void setDynaClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynaclass = string;
        this.dynaclassDirtyFlag = true;
    }

    public String getDynaClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaClass();
        }
        return this.dynaclass;
    }

    public boolean isDynaClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaClassDirty();
        }
        return this.dynaclassDirtyFlag;
    }

    public void resetDynaClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaClass();
            return;
        }
        this.dynaclassDirtyFlag = false;
        this.dynaclass = null;
    }

    public void setFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fields = string;
        this.fieldsDirtyFlag = true;
    }

    public String getFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFields();
        }
        return this.fields;
    }

    public boolean isFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldsDirty();
        }
        return this.fieldsDirtyFlag;
    }

    public void resetFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFields();
            return;
        }
        this.fieldsDirtyFlag = false;
        this.fields = null;
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

    public void setPSDEChartAxesId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartAxesId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartaxesid = string;
        this.psdechartaxesidDirtyFlag = true;
    }

    public String getPSDEChartAxesId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartAxesId();
        }
        return this.psdechartaxesid;
    }

    public boolean isPSDEChartAxesIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartAxesIdDirty();
        }
        return this.psdechartaxesidDirtyFlag;
    }

    public void resetPSDEChartAxesId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartAxesId();
            return;
        }
        this.psdechartaxesidDirtyFlag = false;
        this.psdechartaxesid = null;
    }

    public void setPSDEChartAxesName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartAxesName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartaxesname = string;
        this.psdechartaxesnameDirtyFlag = true;
    }

    public String getPSDEChartAxesName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartAxesName();
        }
        return this.psdechartaxesname;
    }

    public boolean isPSDEChartAxesNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartAxesNameDirty();
        }
        return this.psdechartaxesnameDirtyFlag;
    }

    public void resetPSDEChartAxesName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartAxesName();
            return;
        }
        this.psdechartaxesnameDirtyFlag = false;
        this.psdechartaxesname = null;
    }

    public void setPSDEChartId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartid = string;
        this.psdechartidDirtyFlag = true;
    }

    public String getPSDEChartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartId();
        }
        return this.psdechartid;
    }

    public boolean isPSDEChartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartIdDirty();
        }
        return this.psdechartidDirtyFlag;
    }

    public void resetPSDEChartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartId();
            return;
        }
        this.psdechartidDirtyFlag = false;
        this.psdechartid = null;
    }

    public void setPSDEChartName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEChartName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdechartname = string;
        this.psdechartnameDirtyFlag = true;
    }

    public String getPSDEChartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChartName();
        }
        return this.psdechartname;
    }

    public boolean isPSDEChartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEChartNameDirty();
        }
        return this.psdechartnameDirtyFlag;
    }

    public void resetPSDEChartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEChartName();
            return;
        }
        this.psdechartnameDirtyFlag = false;
        this.psdechartname = null;
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

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
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

    protected void onReset() {
        PSDEChartAxesBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEChartAxesBase pSDEChartAxesBase) {
        pSDEChartAxesBase.resetAxesData();
        pSDEChartAxesBase.resetAxesData2();
        pSDEChartAxesBase.resetAxesMaxValue();
        pSDEChartAxesBase.resetAxesMinValue();
        pSDEChartAxesBase.resetAxesPos();
        pSDEChartAxesBase.resetAxesType();
        pSDEChartAxesBase.resetCapPSLanResId();
        pSDEChartAxesBase.resetCapPSLanResName();
        pSDEChartAxesBase.resetCaption();
        pSDEChartAxesBase.resetCoordinateSystemId();
        pSDEChartAxesBase.resetCreateDate();
        pSDEChartAxesBase.resetCreateMan();
        pSDEChartAxesBase.resetDataShowMode();
        pSDEChartAxesBase.resetDynaClass();
        pSDEChartAxesBase.resetFields();
        pSDEChartAxesBase.resetMemo();
        pSDEChartAxesBase.resetOrderValue();
        pSDEChartAxesBase.resetPSDEChartAxesId();
        pSDEChartAxesBase.resetPSDEChartAxesName();
        pSDEChartAxesBase.resetPSDEChartId();
        pSDEChartAxesBase.resetPSDEChartName();
        pSDEChartAxesBase.resetPSDEId();
        pSDEChartAxesBase.resetPSSysDynaModelId();
        pSDEChartAxesBase.resetPSSysDynaModelName();
        pSDEChartAxesBase.resetPSSysPFPluginId();
        pSDEChartAxesBase.resetPSSysPFPluginName();
        pSDEChartAxesBase.resetUpdateDate();
        pSDEChartAxesBase.resetUpdateMan();
        pSDEChartAxesBase.resetUserCat();
        pSDEChartAxesBase.resetUserParams();
        pSDEChartAxesBase.resetUserTag();
        pSDEChartAxesBase.resetUserTag2();
        pSDEChartAxesBase.resetUserTag3();
        pSDEChartAxesBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAxesDataDirty()) {
            hashMap.put(FIELD_AXESDATA, this.getAxesData());
        }
        if (!bl || this.isAxesData2Dirty()) {
            hashMap.put(FIELD_AXESDATA2, this.getAxesData2());
        }
        if (!bl || this.isAxesMaxValueDirty()) {
            hashMap.put(FIELD_AXESMAXVALUE, this.getAxesMaxValue());
        }
        if (!bl || this.isAxesMinValueDirty()) {
            hashMap.put(FIELD_AXESMINVALUE, this.getAxesMinValue());
        }
        if (!bl || this.isAxesPosDirty()) {
            hashMap.put(FIELD_AXESPOS, this.getAxesPos());
        }
        if (!bl || this.isAxesTypeDirty()) {
            hashMap.put(FIELD_AXESTYPE, this.getAxesType());
        }
        if (!bl || this.isCapPSLanResIdDirty()) {
            hashMap.put(FIELD_CAPPSLANRESID, this.getCapPSLanResId());
        }
        if (!bl || this.isCapPSLanResNameDirty()) {
            hashMap.put(FIELD_CAPPSLANRESNAME, this.getCapPSLanResName());
        }
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
        }
        if (!bl || this.isCoordinateSystemIdDirty()) {
            hashMap.put(FIELD_COORDINATESYSTEMID, this.getCoordinateSystemId());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDataShowModeDirty()) {
            hashMap.put(FIELD_DATASHOWMODE, this.getDataShowMode());
        }
        if (!bl || this.isDynaClassDirty()) {
            hashMap.put(FIELD_DYNACLASS, this.getDynaClass());
        }
        if (!bl || this.isFieldsDirty()) {
            hashMap.put(FIELD_FIELDS, this.getFields());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEChartAxesIdDirty()) {
            hashMap.put(FIELD_PSDECHARTAXESID, this.getPSDEChartAxesId());
        }
        if (!bl || this.isPSDEChartAxesNameDirty()) {
            hashMap.put(FIELD_PSDECHARTAXESNAME, this.getPSDEChartAxesName());
        }
        if (!bl || this.isPSDEChartIdDirty()) {
            hashMap.put(FIELD_PSDECHARTID, this.getPSDEChartId());
        }
        if (!bl || this.isPSDEChartNameDirty()) {
            hashMap.put(FIELD_PSDECHARTNAME, this.getPSDEChartName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
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
        return PSDEChartAxesBase.get(this, n);
    }

    private static Object get(PSDEChartAxesBase pSDEChartAxesBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEChartAxesBase.getAxesData();
            }
            case 1: {
                return pSDEChartAxesBase.getAxesData2();
            }
            case 2: {
                return pSDEChartAxesBase.getAxesMaxValue();
            }
            case 3: {
                return pSDEChartAxesBase.getAxesMinValue();
            }
            case 4: {
                return pSDEChartAxesBase.getAxesPos();
            }
            case 5: {
                return pSDEChartAxesBase.getAxesType();
            }
            case 6: {
                return pSDEChartAxesBase.getCapPSLanResId();
            }
            case 7: {
                return pSDEChartAxesBase.getCapPSLanResName();
            }
            case 8: {
                return pSDEChartAxesBase.getCaption();
            }
            case 9: {
                return pSDEChartAxesBase.getCoordinateSystemId();
            }
            case 10: {
                return pSDEChartAxesBase.getCreateDate();
            }
            case 11: {
                return pSDEChartAxesBase.getCreateMan();
            }
            case 12: {
                return pSDEChartAxesBase.getDataShowMode();
            }
            case 13: {
                return pSDEChartAxesBase.getDynaClass();
            }
            case 14: {
                return pSDEChartAxesBase.getFields();
            }
            case 15: {
                return pSDEChartAxesBase.getMemo();
            }
            case 16: {
                return pSDEChartAxesBase.getOrderValue();
            }
            case 17: {
                return pSDEChartAxesBase.getPSDEChartAxesId();
            }
            case 18: {
                return pSDEChartAxesBase.getPSDEChartAxesName();
            }
            case 19: {
                return pSDEChartAxesBase.getPSDEChartId();
            }
            case 20: {
                return pSDEChartAxesBase.getPSDEChartName();
            }
            case 21: {
                return pSDEChartAxesBase.getPSDEId();
            }
            case 22: {
                return pSDEChartAxesBase.getPSSysDynaModelId();
            }
            case 23: {
                return pSDEChartAxesBase.getPSSysDynaModelName();
            }
            case 24: {
                return pSDEChartAxesBase.getPSSysPFPluginId();
            }
            case 25: {
                return pSDEChartAxesBase.getPSSysPFPluginName();
            }
            case 26: {
                return pSDEChartAxesBase.getUpdateDate();
            }
            case 27: {
                return pSDEChartAxesBase.getUpdateMan();
            }
            case 28: {
                return pSDEChartAxesBase.getUserCat();
            }
            case 29: {
                return pSDEChartAxesBase.getUserParams();
            }
            case 30: {
                return pSDEChartAxesBase.getUserTag();
            }
            case 31: {
                return pSDEChartAxesBase.getUserTag2();
            }
            case 32: {
                return pSDEChartAxesBase.getUserTag3();
            }
            case 33: {
                return pSDEChartAxesBase.getUserTag4();
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
        PSDEChartAxesBase.set(this, n, object);
    }

    private static void set(PSDEChartAxesBase pSDEChartAxesBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEChartAxesBase.setAxesData(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEChartAxesBase.setAxesData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEChartAxesBase.setAxesMaxValue(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 3: {
                pSDEChartAxesBase.setAxesMinValue(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 4: {
                pSDEChartAxesBase.setAxesPos(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEChartAxesBase.setAxesType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEChartAxesBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEChartAxesBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEChartAxesBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEChartAxesBase.setCoordinateSystemId(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEChartAxesBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDEChartAxesBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEChartAxesBase.setDataShowMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEChartAxesBase.setDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEChartAxesBase.setFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEChartAxesBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEChartAxesBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDEChartAxesBase.setPSDEChartAxesId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEChartAxesBase.setPSDEChartAxesName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEChartAxesBase.setPSDEChartId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEChartAxesBase.setPSDEChartName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEChartAxesBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEChartAxesBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEChartAxesBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEChartAxesBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEChartAxesBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEChartAxesBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSDEChartAxesBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEChartAxesBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEChartAxesBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEChartAxesBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEChartAxesBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEChartAxesBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEChartAxesBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDEChartAxesBase.isNull(this, n);
    }

    private static boolean isNull(PSDEChartAxesBase pSDEChartAxesBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEChartAxesBase.getAxesData() == null;
            }
            case 1: {
                return pSDEChartAxesBase.getAxesData2() == null;
            }
            case 2: {
                return pSDEChartAxesBase.getAxesMaxValue() == null;
            }
            case 3: {
                return pSDEChartAxesBase.getAxesMinValue() == null;
            }
            case 4: {
                return pSDEChartAxesBase.getAxesPos() == null;
            }
            case 5: {
                return pSDEChartAxesBase.getAxesType() == null;
            }
            case 6: {
                return pSDEChartAxesBase.getCapPSLanResId() == null;
            }
            case 7: {
                return pSDEChartAxesBase.getCapPSLanResName() == null;
            }
            case 8: {
                return pSDEChartAxesBase.getCaption() == null;
            }
            case 9: {
                return pSDEChartAxesBase.getCoordinateSystemId() == null;
            }
            case 10: {
                return pSDEChartAxesBase.getCreateDate() == null;
            }
            case 11: {
                return pSDEChartAxesBase.getCreateMan() == null;
            }
            case 12: {
                return pSDEChartAxesBase.getDataShowMode() == null;
            }
            case 13: {
                return pSDEChartAxesBase.getDynaClass() == null;
            }
            case 14: {
                return pSDEChartAxesBase.getFields() == null;
            }
            case 15: {
                return pSDEChartAxesBase.getMemo() == null;
            }
            case 16: {
                return pSDEChartAxesBase.getOrderValue() == null;
            }
            case 17: {
                return pSDEChartAxesBase.getPSDEChartAxesId() == null;
            }
            case 18: {
                return pSDEChartAxesBase.getPSDEChartAxesName() == null;
            }
            case 19: {
                return pSDEChartAxesBase.getPSDEChartId() == null;
            }
            case 20: {
                return pSDEChartAxesBase.getPSDEChartName() == null;
            }
            case 21: {
                return pSDEChartAxesBase.getPSDEId() == null;
            }
            case 22: {
                return pSDEChartAxesBase.getPSSysDynaModelId() == null;
            }
            case 23: {
                return pSDEChartAxesBase.getPSSysDynaModelName() == null;
            }
            case 24: {
                return pSDEChartAxesBase.getPSSysPFPluginId() == null;
            }
            case 25: {
                return pSDEChartAxesBase.getPSSysPFPluginName() == null;
            }
            case 26: {
                return pSDEChartAxesBase.getUpdateDate() == null;
            }
            case 27: {
                return pSDEChartAxesBase.getUpdateMan() == null;
            }
            case 28: {
                return pSDEChartAxesBase.getUserCat() == null;
            }
            case 29: {
                return pSDEChartAxesBase.getUserParams() == null;
            }
            case 30: {
                return pSDEChartAxesBase.getUserTag() == null;
            }
            case 31: {
                return pSDEChartAxesBase.getUserTag2() == null;
            }
            case 32: {
                return pSDEChartAxesBase.getUserTag3() == null;
            }
            case 33: {
                return pSDEChartAxesBase.getUserTag4() == null;
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
        return PSDEChartAxesBase.contains(this, n);
    }

    private static boolean contains(PSDEChartAxesBase pSDEChartAxesBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEChartAxesBase.isAxesDataDirty();
            }
            case 1: {
                return pSDEChartAxesBase.isAxesData2Dirty();
            }
            case 2: {
                return pSDEChartAxesBase.isAxesMaxValueDirty();
            }
            case 3: {
                return pSDEChartAxesBase.isAxesMinValueDirty();
            }
            case 4: {
                return pSDEChartAxesBase.isAxesPosDirty();
            }
            case 5: {
                return pSDEChartAxesBase.isAxesTypeDirty();
            }
            case 6: {
                return pSDEChartAxesBase.isCapPSLanResIdDirty();
            }
            case 7: {
                return pSDEChartAxesBase.isCapPSLanResNameDirty();
            }
            case 8: {
                return pSDEChartAxesBase.isCaptionDirty();
            }
            case 9: {
                return pSDEChartAxesBase.isCoordinateSystemIdDirty();
            }
            case 10: {
                return pSDEChartAxesBase.isCreateDateDirty();
            }
            case 11: {
                return pSDEChartAxesBase.isCreateManDirty();
            }
            case 12: {
                return pSDEChartAxesBase.isDataShowModeDirty();
            }
            case 13: {
                return pSDEChartAxesBase.isDynaClassDirty();
            }
            case 14: {
                return pSDEChartAxesBase.isFieldsDirty();
            }
            case 15: {
                return pSDEChartAxesBase.isMemoDirty();
            }
            case 16: {
                return pSDEChartAxesBase.isOrderValueDirty();
            }
            case 17: {
                return pSDEChartAxesBase.isPSDEChartAxesIdDirty();
            }
            case 18: {
                return pSDEChartAxesBase.isPSDEChartAxesNameDirty();
            }
            case 19: {
                return pSDEChartAxesBase.isPSDEChartIdDirty();
            }
            case 20: {
                return pSDEChartAxesBase.isPSDEChartNameDirty();
            }
            case 21: {
                return pSDEChartAxesBase.isPSDEIdDirty();
            }
            case 22: {
                return pSDEChartAxesBase.isPSSysDynaModelIdDirty();
            }
            case 23: {
                return pSDEChartAxesBase.isPSSysDynaModelNameDirty();
            }
            case 24: {
                return pSDEChartAxesBase.isPSSysPFPluginIdDirty();
            }
            case 25: {
                return pSDEChartAxesBase.isPSSysPFPluginNameDirty();
            }
            case 26: {
                return pSDEChartAxesBase.isUpdateDateDirty();
            }
            case 27: {
                return pSDEChartAxesBase.isUpdateManDirty();
            }
            case 28: {
                return pSDEChartAxesBase.isUserCatDirty();
            }
            case 29: {
                return pSDEChartAxesBase.isUserParamsDirty();
            }
            case 30: {
                return pSDEChartAxesBase.isUserTagDirty();
            }
            case 31: {
                return pSDEChartAxesBase.isUserTag2Dirty();
            }
            case 32: {
                return pSDEChartAxesBase.isUserTag3Dirty();
            }
            case 33: {
                return pSDEChartAxesBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEChartAxesBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEChartAxesBase pSDEChartAxesBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEChartAxesBase.getAxesData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"axesdata", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getAxesData()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getAxesData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"axesdata2", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getAxesData2()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getAxesMaxValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"axesmaxvalue", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getAxesMaxValue()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getAxesMinValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"axesminvalue", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getAxesMinValue()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getAxesPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"axespos", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getAxesPos()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getAxesType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"axestype", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getAxesType()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getCaption()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getCoordinateSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"coordinatesystemid", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getCoordinateSystemId()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getDataShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datashowmode", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getDataShowMode()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaclass", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getDynaClass()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fields", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getFields()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getPSDEChartAxesId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartaxesid", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getPSDEChartAxesId()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getPSDEChartAxesName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartaxesname", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getPSDEChartAxesName()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getPSDEChartId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartid", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getPSDEChartId()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getPSDEChartName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdechartname", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getPSDEChartName()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEChartAxesBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEChartAxesBase.getJSONValue((Object)pSDEChartAxesBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEChartAxesBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEChartAxesBase pSDEChartAxesBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEChartAxesBase.getAxesData() != null) {
            object = pSDEChartAxesBase.getAxesData();
            xmlNode.setAttribute(FIELD_AXESDATA, (String)(object == null ? "" : object));
        }
        if (bl || pSDEChartAxesBase.getAxesData2() != null) {
            object = pSDEChartAxesBase.getAxesData2();
            xmlNode.setAttribute(FIELD_AXESDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getAxesMaxValue() != null) {
            object = pSDEChartAxesBase.getAxesMaxValue();
            xmlNode.setAttribute(FIELD_AXESMAXVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartAxesBase.getAxesMinValue() != null) {
            object = pSDEChartAxesBase.getAxesMinValue();
            xmlNode.setAttribute(FIELD_AXESMINVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartAxesBase.getAxesPos() != null) {
            object = pSDEChartAxesBase.getAxesPos();
            xmlNode.setAttribute(FIELD_AXESPOS, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getAxesType() != null) {
            object = pSDEChartAxesBase.getAxesType();
            xmlNode.setAttribute(FIELD_AXESTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getCapPSLanResId() != null) {
            object = pSDEChartAxesBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getCapPSLanResName() != null) {
            object = pSDEChartAxesBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getCaption() != null) {
            object = pSDEChartAxesBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getCoordinateSystemId() != null) {
            object = pSDEChartAxesBase.getCoordinateSystemId();
            xmlNode.setAttribute(FIELD_COORDINATESYSTEMID, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartAxesBase.getCreateDate() != null) {
            object = pSDEChartAxesBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEChartAxesBase.getCreateMan() != null) {
            object = pSDEChartAxesBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getDataShowMode() != null) {
            object = pSDEChartAxesBase.getDataShowMode();
            xmlNode.setAttribute(FIELD_DATASHOWMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartAxesBase.getDynaClass() != null) {
            object = pSDEChartAxesBase.getDynaClass();
            xmlNode.setAttribute(FIELD_DYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getFields() != null) {
            object = pSDEChartAxesBase.getFields();
            xmlNode.setAttribute(FIELD_FIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getMemo() != null) {
            object = pSDEChartAxesBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getOrderValue() != null) {
            object = pSDEChartAxesBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEChartAxesBase.getPSDEChartAxesId() != null) {
            object = pSDEChartAxesBase.getPSDEChartAxesId();
            xmlNode.setAttribute(FIELD_PSDECHARTAXESID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getPSDEChartAxesName() != null) {
            object = pSDEChartAxesBase.getPSDEChartAxesName();
            xmlNode.setAttribute(FIELD_PSDECHARTAXESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getPSDEChartId() != null) {
            object = pSDEChartAxesBase.getPSDEChartId();
            xmlNode.setAttribute(FIELD_PSDECHARTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getPSDEChartName() != null) {
            object = pSDEChartAxesBase.getPSDEChartName();
            xmlNode.setAttribute(FIELD_PSDECHARTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getPSDEId() != null) {
            object = pSDEChartAxesBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getPSSysDynaModelId() != null) {
            object = pSDEChartAxesBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getPSSysDynaModelName() != null) {
            object = pSDEChartAxesBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getPSSysPFPluginId() != null) {
            object = pSDEChartAxesBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getPSSysPFPluginName() != null) {
            object = pSDEChartAxesBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getUpdateDate() != null) {
            object = pSDEChartAxesBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEChartAxesBase.getUpdateMan() != null) {
            object = pSDEChartAxesBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getUserCat() != null) {
            object = pSDEChartAxesBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getUserParams() != null) {
            object = pSDEChartAxesBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getUserTag() != null) {
            object = pSDEChartAxesBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getUserTag2() != null) {
            object = pSDEChartAxesBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getUserTag3() != null) {
            object = pSDEChartAxesBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEChartAxesBase.getUserTag4() != null) {
            object = pSDEChartAxesBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEChartAxesBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEChartAxesBase pSDEChartAxesBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEChartAxesBase.isAxesDataDirty() && (bl || pSDEChartAxesBase.getAxesData() != null)) {
            iDataObject.set(FIELD_AXESDATA, (Object)pSDEChartAxesBase.getAxesData());
        }
        if (pSDEChartAxesBase.isAxesData2Dirty() && (bl || pSDEChartAxesBase.getAxesData2() != null)) {
            iDataObject.set(FIELD_AXESDATA2, (Object)pSDEChartAxesBase.getAxesData2());
        }
        if (pSDEChartAxesBase.isAxesMaxValueDirty() && (bl || pSDEChartAxesBase.getAxesMaxValue() != null)) {
            iDataObject.set(FIELD_AXESMAXVALUE, (Object)pSDEChartAxesBase.getAxesMaxValue());
        }
        if (pSDEChartAxesBase.isAxesMinValueDirty() && (bl || pSDEChartAxesBase.getAxesMinValue() != null)) {
            iDataObject.set(FIELD_AXESMINVALUE, (Object)pSDEChartAxesBase.getAxesMinValue());
        }
        if (pSDEChartAxesBase.isAxesPosDirty() && (bl || pSDEChartAxesBase.getAxesPos() != null)) {
            iDataObject.set(FIELD_AXESPOS, (Object)pSDEChartAxesBase.getAxesPos());
        }
        if (pSDEChartAxesBase.isAxesTypeDirty() && (bl || pSDEChartAxesBase.getAxesType() != null)) {
            iDataObject.set(FIELD_AXESTYPE, (Object)pSDEChartAxesBase.getAxesType());
        }
        if (pSDEChartAxesBase.isCapPSLanResIdDirty() && (bl || pSDEChartAxesBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDEChartAxesBase.getCapPSLanResId());
        }
        if (pSDEChartAxesBase.isCapPSLanResNameDirty() && (bl || pSDEChartAxesBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDEChartAxesBase.getCapPSLanResName());
        }
        if (pSDEChartAxesBase.isCaptionDirty() && (bl || pSDEChartAxesBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDEChartAxesBase.getCaption());
        }
        if (pSDEChartAxesBase.isCoordinateSystemIdDirty() && (bl || pSDEChartAxesBase.getCoordinateSystemId() != null)) {
            iDataObject.set(FIELD_COORDINATESYSTEMID, (Object)pSDEChartAxesBase.getCoordinateSystemId());
        }
        if (pSDEChartAxesBase.isCreateDateDirty() && (bl || pSDEChartAxesBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEChartAxesBase.getCreateDate());
        }
        if (pSDEChartAxesBase.isCreateManDirty() && (bl || pSDEChartAxesBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEChartAxesBase.getCreateMan());
        }
        if (pSDEChartAxesBase.isDataShowModeDirty() && (bl || pSDEChartAxesBase.getDataShowMode() != null)) {
            iDataObject.set(FIELD_DATASHOWMODE, (Object)pSDEChartAxesBase.getDataShowMode());
        }
        if (pSDEChartAxesBase.isDynaClassDirty() && (bl || pSDEChartAxesBase.getDynaClass() != null)) {
            iDataObject.set(FIELD_DYNACLASS, (Object)pSDEChartAxesBase.getDynaClass());
        }
        if (pSDEChartAxesBase.isFieldsDirty() && (bl || pSDEChartAxesBase.getFields() != null)) {
            iDataObject.set(FIELD_FIELDS, (Object)pSDEChartAxesBase.getFields());
        }
        if (pSDEChartAxesBase.isMemoDirty() && (bl || pSDEChartAxesBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEChartAxesBase.getMemo());
        }
        if (pSDEChartAxesBase.isOrderValueDirty() && (bl || pSDEChartAxesBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEChartAxesBase.getOrderValue());
        }
        if (pSDEChartAxesBase.isPSDEChartAxesIdDirty() && (bl || pSDEChartAxesBase.getPSDEChartAxesId() != null)) {
            iDataObject.set(FIELD_PSDECHARTAXESID, (Object)pSDEChartAxesBase.getPSDEChartAxesId());
        }
        if (pSDEChartAxesBase.isPSDEChartAxesNameDirty() && (bl || pSDEChartAxesBase.getPSDEChartAxesName() != null)) {
            iDataObject.set(FIELD_PSDECHARTAXESNAME, (Object)pSDEChartAxesBase.getPSDEChartAxesName());
        }
        if (pSDEChartAxesBase.isPSDEChartIdDirty() && (bl || pSDEChartAxesBase.getPSDEChartId() != null)) {
            iDataObject.set(FIELD_PSDECHARTID, (Object)pSDEChartAxesBase.getPSDEChartId());
        }
        if (pSDEChartAxesBase.isPSDEChartNameDirty() && (bl || pSDEChartAxesBase.getPSDEChartName() != null)) {
            iDataObject.set(FIELD_PSDECHARTNAME, (Object)pSDEChartAxesBase.getPSDEChartName());
        }
        if (pSDEChartAxesBase.isPSDEIdDirty() && (bl || pSDEChartAxesBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEChartAxesBase.getPSDEId());
        }
        if (pSDEChartAxesBase.isPSSysDynaModelIdDirty() && (bl || pSDEChartAxesBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEChartAxesBase.getPSSysDynaModelId());
        }
        if (pSDEChartAxesBase.isPSSysDynaModelNameDirty() && (bl || pSDEChartAxesBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEChartAxesBase.getPSSysDynaModelName());
        }
        if (pSDEChartAxesBase.isPSSysPFPluginIdDirty() && (bl || pSDEChartAxesBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEChartAxesBase.getPSSysPFPluginId());
        }
        if (pSDEChartAxesBase.isPSSysPFPluginNameDirty() && (bl || pSDEChartAxesBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEChartAxesBase.getPSSysPFPluginName());
        }
        if (pSDEChartAxesBase.isUpdateDateDirty() && (bl || pSDEChartAxesBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEChartAxesBase.getUpdateDate());
        }
        if (pSDEChartAxesBase.isUpdateManDirty() && (bl || pSDEChartAxesBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEChartAxesBase.getUpdateMan());
        }
        if (pSDEChartAxesBase.isUserCatDirty() && (bl || pSDEChartAxesBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEChartAxesBase.getUserCat());
        }
        if (pSDEChartAxesBase.isUserParamsDirty() && (bl || pSDEChartAxesBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEChartAxesBase.getUserParams());
        }
        if (pSDEChartAxesBase.isUserTagDirty() && (bl || pSDEChartAxesBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEChartAxesBase.getUserTag());
        }
        if (pSDEChartAxesBase.isUserTag2Dirty() && (bl || pSDEChartAxesBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEChartAxesBase.getUserTag2());
        }
        if (pSDEChartAxesBase.isUserTag3Dirty() && (bl || pSDEChartAxesBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEChartAxesBase.getUserTag3());
        }
        if (pSDEChartAxesBase.isUserTag4Dirty() && (bl || pSDEChartAxesBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEChartAxesBase.getUserTag4());
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
        return PSDEChartAxesBase.remove(this, n);
    }

    private static boolean remove(PSDEChartAxesBase pSDEChartAxesBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEChartAxesBase.resetAxesData();
                return true;
            }
            case 1: {
                pSDEChartAxesBase.resetAxesData2();
                return true;
            }
            case 2: {
                pSDEChartAxesBase.resetAxesMaxValue();
                return true;
            }
            case 3: {
                pSDEChartAxesBase.resetAxesMinValue();
                return true;
            }
            case 4: {
                pSDEChartAxesBase.resetAxesPos();
                return true;
            }
            case 5: {
                pSDEChartAxesBase.resetAxesType();
                return true;
            }
            case 6: {
                pSDEChartAxesBase.resetCapPSLanResId();
                return true;
            }
            case 7: {
                pSDEChartAxesBase.resetCapPSLanResName();
                return true;
            }
            case 8: {
                pSDEChartAxesBase.resetCaption();
                return true;
            }
            case 9: {
                pSDEChartAxesBase.resetCoordinateSystemId();
                return true;
            }
            case 10: {
                pSDEChartAxesBase.resetCreateDate();
                return true;
            }
            case 11: {
                pSDEChartAxesBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSDEChartAxesBase.resetDataShowMode();
                return true;
            }
            case 13: {
                pSDEChartAxesBase.resetDynaClass();
                return true;
            }
            case 14: {
                pSDEChartAxesBase.resetFields();
                return true;
            }
            case 15: {
                pSDEChartAxesBase.resetMemo();
                return true;
            }
            case 16: {
                pSDEChartAxesBase.resetOrderValue();
                return true;
            }
            case 17: {
                pSDEChartAxesBase.resetPSDEChartAxesId();
                return true;
            }
            case 18: {
                pSDEChartAxesBase.resetPSDEChartAxesName();
                return true;
            }
            case 19: {
                pSDEChartAxesBase.resetPSDEChartId();
                return true;
            }
            case 20: {
                pSDEChartAxesBase.resetPSDEChartName();
                return true;
            }
            case 21: {
                pSDEChartAxesBase.resetPSDEId();
                return true;
            }
            case 22: {
                pSDEChartAxesBase.resetPSSysDynaModelId();
                return true;
            }
            case 23: {
                pSDEChartAxesBase.resetPSSysDynaModelName();
                return true;
            }
            case 24: {
                pSDEChartAxesBase.resetPSSysPFPluginId();
                return true;
            }
            case 25: {
                pSDEChartAxesBase.resetPSSysPFPluginName();
                return true;
            }
            case 26: {
                pSDEChartAxesBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSDEChartAxesBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSDEChartAxesBase.resetUserCat();
                return true;
            }
            case 29: {
                pSDEChartAxesBase.resetUserParams();
                return true;
            }
            case 30: {
                pSDEChartAxesBase.resetUserTag();
                return true;
            }
            case 31: {
                pSDEChartAxesBase.resetUserTag2();
                return true;
            }
            case 32: {
                pSDEChartAxesBase.resetUserTag3();
                return true;
            }
            case 33: {
                pSDEChartAxesBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEChart getPSDEChart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEChart();
        }
        if (this.getPSDEChartId() == null) {
            return null;
        }
        Integer n = this.objPSDEChartLock;
        synchronized (n) {
            if (this.psdechart != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEChartId(), (Object)this.psdechart.getPSDEChartId()) != 0L) {
                this.psdechart = null;
            }
            if (this.psdechart == null) {
                PSDEChart pSDEChart = new PSDEChart();
                pSDEChart.setPSDEChartId(this.getPSDEChartId());
                PSDEChartService pSDEChartService = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
                pSDEChartService.autoGet((IEntity)pSDEChart);
                this.psdechart = pSDEChart;
            }
            return this.psdechart;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getCapPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanRes();
        }
        if (this.getCapPSLanResId() == null) {
            return null;
        }
        Integer n = this.objCapPSLanResLock;
        synchronized (n) {
            if (this.cappslanres != null && DataTypeHelper.compare((int)25, (Object)this.getCapPSLanResId(), (Object)this.cappslanres.getPSLanguageResId()) != 0L) {
                this.cappslanres = null;
            }
            if (this.cappslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getCapPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.cappslanres = pSLanguageRes;
            }
            return this.cappslanres;
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
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    private PSDEChartAxesBase getProxyEntity() {
        return this.proxyPSDEChartAxesBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEChartAxesBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEChartAxesBase) {
            this.proxyPSDEChartAxesBase = (PSDEChartAxesBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AXESDATA, 0);
        fieldIndexMap.put(FIELD_AXESDATA2, 1);
        fieldIndexMap.put(FIELD_AXESMAXVALUE, 2);
        fieldIndexMap.put(FIELD_AXESMINVALUE, 3);
        fieldIndexMap.put(FIELD_AXESPOS, 4);
        fieldIndexMap.put(FIELD_AXESTYPE, 5);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 6);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 7);
        fieldIndexMap.put(FIELD_CAPTION, 8);
        fieldIndexMap.put(FIELD_COORDINATESYSTEMID, 9);
        fieldIndexMap.put(FIELD_CREATEDATE, 10);
        fieldIndexMap.put(FIELD_CREATEMAN, 11);
        fieldIndexMap.put(FIELD_DATASHOWMODE, 12);
        fieldIndexMap.put(FIELD_DYNACLASS, 13);
        fieldIndexMap.put(FIELD_FIELDS, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_ORDERVALUE, 16);
        fieldIndexMap.put(FIELD_PSDECHARTAXESID, 17);
        fieldIndexMap.put(FIELD_PSDECHARTAXESNAME, 18);
        fieldIndexMap.put(FIELD_PSDECHARTID, 19);
        fieldIndexMap.put(FIELD_PSDECHARTNAME, 20);
        fieldIndexMap.put(FIELD_PSDEID, 21);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 22);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 24);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USERCAT, 28);
        fieldIndexMap.put(FIELD_USERPARAMS, 29);
        fieldIndexMap.put(FIELD_USERTAG, 30);
        fieldIndexMap.put(FIELD_USERTAG2, 31);
        fieldIndexMap.put(FIELD_USERTAG3, 32);
        fieldIndexMap.put(FIELD_USERTAG4, 33);
    }
}

