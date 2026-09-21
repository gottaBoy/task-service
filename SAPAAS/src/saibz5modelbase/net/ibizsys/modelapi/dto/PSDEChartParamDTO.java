/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 */
package net.ibizsys.modelapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDEChartParamDTO
extends PSModelDTOBase {
    public static final String FIELD_BARCATEGORYGAP = "barcategorygap";
    public static final String FIELD_BARGAP = "bargap";
    public static final String FIELD_BARMAXWIDTH = "barmaxwidth";
    public static final String FIELD_BARMINHEIGHT = "barminheight";
    public static final String FIELD_BARMINWIDTH = "barminwidth";
    public static final String FIELD_BARWIDTH = "barwidth";
    public static final String FIELD_BOTTOMPOS = "bottompos";
    public static final String FIELD_BOXWIDTHS = "boxwidths";
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_CENTER = "center";
    public static final String FIELD_CHARTTYPE = "charttype";
    public static final String FIELD_CLOCKWISE = "clockwise";
    public static final String FIELD_COORDINATESYSTEM = "coordinatesystem";
    public static final String FIELD_COORDINATESYSTEMID = "coordinatesystemid";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CSPSSYSDYNAMODELID = "cspssysdynamodelid";
    public static final String FIELD_CSPSSYSDYNAMODELNAME = "cspssysdynamodelname";
    public static final String FIELD_CSPSSYSPFPLUGINID = "cspssyspfpluginid";
    public static final String FIELD_CSPSSYSPFPLUGINNAME = "cspssyspfpluginname";
    public static final String FIELD_DATAFIELD = "datafield";
    public static final String FIELD_DYNACLASS = "dynaclass";
    public static final String FIELD_ENDANGLE = "endangle";
    public static final String FIELD_EXTFIELD = "extfield";
    public static final String FIELD_EXTFIELD2 = "extfield2";
    public static final String FIELD_EXTFIELD3 = "extfield3";
    public static final String FIELD_EXTFIELD4 = "extfield4";
    public static final String FIELD_FUNNELALIGN = "funnelalign";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_LEFTPOS = "leftpos";
    public static final String FIELD_MAPTYPE = "maptype";
    public static final String FIELD_MAXSIZE = "maxsize";
    public static final String FIELD_MAXVALUE = "maxvalue";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINANGLE = "minangle";
    public static final String FIELD_MINSHOWLABELANGLE = "minshowlabelangle";
    public static final String FIELD_MINSIZE = "minsize";
    public static final String FIELD_MINVALUE = "minvalue";
    public static final String FIELD_NAVVIEWFILTER = "navviewfilter";
    public static final String FIELD_NAVVIEWPARAM = "navviewparam";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDECHARTID = "psdechartid";
    public static final String FIELD_PSDECHARTNAME = "psdechartname";
    public static final String FIELD_PSDECHARTPARAMID = "psdechartparamid";
    public static final String FIELD_PSDECHARTPARAMNAME = "psdechartparamname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDERID = "psderid";
    public static final String FIELD_PSDERNAME = "psdername";
    public static final String FIELD_PSDEVIEWBASEID = "psdeviewbaseid";
    public static final String FIELD_PSDEVIEWBASENAME = "psdeviewbasename";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_RADIUS = "radius";
    public static final String FIELD_RIGHTPOS = "rightpos";
    public static final String FIELD_ROSETYPE = "rosetype";
    public static final String FIELD_SAMPLEDATA = "sampledata";
    public static final String FIELD_SERIESFIELD = "seriesfield";
    public static final String FIELD_SERIESLAYOUTBY = "serieslayoutby";
    public static final String FIELD_SERIESPARAM = "seriesparam";
    public static final String FIELD_SERIESPARAM10 = "seriesparam10";
    public static final String FIELD_SERIESPARAM11 = "seriesparam11";
    public static final String FIELD_SERIESPARAM12 = "seriesparam12";
    public static final String FIELD_SERIESPARAM2 = "seriesparam2";
    public static final String FIELD_SERIESPARAM3 = "seriesparam3";
    public static final String FIELD_SERIESPARAM4 = "seriesparam4";
    public static final String FIELD_SERIESPARAM5 = "seriesparam5";
    public static final String FIELD_SERIESPARAM6 = "seriesparam6";
    public static final String FIELD_SERIESPARAM7 = "seriesparam7";
    public static final String FIELD_SERIESPARAM8 = "seriesparam8";
    public static final String FIELD_SERIESPARAM9 = "seriesparam9";
    public static final String FIELD_SFPSCODELISTID = "sfpscodelistid";
    public static final String FIELD_SFPSCODELISTNAME = "sfpscodelistname";
    public static final String FIELD_SORTDIR = "sortdir";
    public static final String FIELD_SPLITNUMBER = "splitnumber";
    public static final String FIELD_STACK = "stack";
    public static final String FIELD_STARTANGLE = "startangle";
    public static final String FIELD_STEP = "step";
    public static final String FIELD_TAGFIELD = "tagfield";
    public static final String FIELD_TIMEGROUP = "timegroup";
    public static final String FIELD_TOPPOS = "toppos";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_WIDTH = "width";
    public static final String FIELD_XFIELD = "xfield";
    public static final String FIELD_XFPSCODELISTID = "xfpscodelistid";
    public static final String FIELD_XFPSCODELISTNAME = "xfpscodelistname";
    public static final String FIELD_XPSDECHARTAXESID = "xpsdechartaxesid";
    public static final String FIELD_XPSDECHARTAXESNAME = "xpsdechartaxesname";
    public static final String FIELD_YFIELD = "yfield";
    public static final String FIELD_YPSDECHARTAXESID = "ypsdechartaxesid";
    public static final String FIELD_YPSDECHARTAXESNAME = "ypsdechartaxesname";
    public static final String FIELD_ZFIELD = "zfield";

    @JsonIgnore
    public String getBarCategoryGap() {
        Object objValue = this.get(FIELD_BARCATEGORYGAP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="barcategorygap")
    public void setBarCategoryGap(String barCategoryGap) {
        this.set(FIELD_BARCATEGORYGAP, barCategoryGap);
    }

    @JsonIgnore
    public boolean isBarCategoryGapDirty() {
        return this.contains(FIELD_BARCATEGORYGAP);
    }

    @JsonIgnore
    public String getBarGap() {
        Object objValue = this.get(FIELD_BARGAP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bargap")
    public void setBarGap(String barGap) {
        this.set(FIELD_BARGAP, barGap);
    }

    @JsonIgnore
    public boolean isBarGapDirty() {
        return this.contains(FIELD_BARGAP);
    }

    @JsonIgnore
    public String getBarMaxWidth() {
        Object objValue = this.get(FIELD_BARMAXWIDTH);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="barmaxwidth")
    public void setBarMaxWidth(String barMaxWidth) {
        this.set(FIELD_BARMAXWIDTH, barMaxWidth);
    }

    @JsonIgnore
    public boolean isBarMaxWidthDirty() {
        return this.contains(FIELD_BARMAXWIDTH);
    }

    @JsonIgnore
    public String getBarMinHeight() {
        Object objValue = this.get(FIELD_BARMINHEIGHT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="barminheight")
    public void setBarMinHeight(String barMinHeight) {
        this.set(FIELD_BARMINHEIGHT, barMinHeight);
    }

    @JsonIgnore
    public boolean isBarMinHeightDirty() {
        return this.contains(FIELD_BARMINHEIGHT);
    }

    @JsonIgnore
    public String getBarMinWidth() {
        Object objValue = this.get(FIELD_BARMINWIDTH);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="barminwidth")
    public void setBarMinWidth(String barMinWidth) {
        this.set(FIELD_BARMINWIDTH, barMinWidth);
    }

    @JsonIgnore
    public boolean isBarMinWidthDirty() {
        return this.contains(FIELD_BARMINWIDTH);
    }

    @JsonIgnore
    public String getBarWidth() {
        Object objValue = this.get(FIELD_BARWIDTH);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="barwidth")
    public void setBarWidth(String barWidth) {
        this.set(FIELD_BARWIDTH, barWidth);
    }

    @JsonIgnore
    public boolean isBarWidthDirty() {
        return this.contains(FIELD_BARWIDTH);
    }

    @JsonIgnore
    public String getBottomPos() {
        Object objValue = this.get(FIELD_BOTTOMPOS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bottompos")
    public void setBottomPos(String bottomPos) {
        this.set(FIELD_BOTTOMPOS, bottomPos);
    }

    @JsonIgnore
    public boolean isBottomPosDirty() {
        return this.contains(FIELD_BOTTOMPOS);
    }

    @JsonIgnore
    public String getBoxWidths() {
        Object objValue = this.get(FIELD_BOXWIDTHS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="boxwidths")
    public void setBoxWidths(String boxWidths) {
        this.set(FIELD_BOXWIDTHS, boxWidths);
    }

    @JsonIgnore
    public boolean isBoxWidthsDirty() {
        return this.contains(FIELD_BOXWIDTHS);
    }

    @JsonIgnore
    public String getCapPSLanResId() {
        Object objValue = this.get(FIELD_CAPPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cappslanresid")
    public void setCapPSLanResId(String capPSLanResId) {
        this.set(FIELD_CAPPSLANRESID, capPSLanResId);
    }

    @JsonIgnore
    public boolean isCapPSLanResIdDirty() {
        return this.contains(FIELD_CAPPSLANRESID);
    }

    @JsonIgnore
    public String getCapPSLanResName() {
        Object objValue = this.get(FIELD_CAPPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cappslanresname")
    public void setCapPSLanResName(String capPSLanResName) {
        this.set(FIELD_CAPPSLANRESNAME, capPSLanResName);
    }

    @JsonIgnore
    public boolean isCapPSLanResNameDirty() {
        return this.contains(FIELD_CAPPSLANRESNAME);
    }

    @JsonIgnore
    public String getCaption() {
        Object objValue = this.get(FIELD_CAPTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="caption")
    public void setCaption(String caption) {
        this.set(FIELD_CAPTION, caption);
    }

    @JsonIgnore
    public boolean isCaptionDirty() {
        return this.contains(FIELD_CAPTION);
    }

    @JsonIgnore
    public String getCenter() {
        Object objValue = this.get(FIELD_CENTER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="center")
    public void setCenter(String center) {
        this.set(FIELD_CENTER, center);
    }

    @JsonIgnore
    public boolean isCenterDirty() {
        return this.contains(FIELD_CENTER);
    }

    @JsonIgnore
    public String getChartType() {
        Object objValue = this.get(FIELD_CHARTTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="charttype")
    public void setChartType(String chartType) {
        this.set(FIELD_CHARTTYPE, chartType);
    }

    @JsonIgnore
    public boolean isChartTypeDirty() {
        return this.contains(FIELD_CHARTTYPE);
    }

    @JsonIgnore
    public Integer getClockWise() {
        Object objValue = this.get(FIELD_CLOCKWISE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="clockwise")
    public void setClockWise(Integer clockWise) {
        this.set(FIELD_CLOCKWISE, clockWise);
    }

    @JsonIgnore
    public boolean isClockWiseDirty() {
        return this.contains(FIELD_CLOCKWISE);
    }

    @JsonIgnore
    public String getCoordinateSystem() {
        Object objValue = this.get(FIELD_COORDINATESYSTEM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="coordinatesystem")
    public void setCoordinateSystem(String coordinateSystem) {
        this.set(FIELD_COORDINATESYSTEM, coordinateSystem);
    }

    @JsonIgnore
    public boolean isCoordinateSystemDirty() {
        return this.contains(FIELD_COORDINATESYSTEM);
    }

    @JsonIgnore
    public Integer getCoordinateSystemId() {
        Object objValue = this.get(FIELD_COORDINATESYSTEMID);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="coordinatesystemid")
    public void setCoordinateSystemId(Integer coordinateSystemId) {
        this.set(FIELD_COORDINATESYSTEMID, coordinateSystemId);
    }

    @JsonIgnore
    public boolean isCoordinateSystemIdDirty() {
        return this.contains(FIELD_COORDINATESYSTEMID);
    }

    @JsonIgnore
    public Timestamp getCreateDate() {
        Object objValue = this.get(FIELD_CREATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="createdate")
    public void setCreateDate(Timestamp createDate) {
        this.set(FIELD_CREATEDATE, createDate);
    }

    @JsonIgnore
    public boolean isCreateDateDirty() {
        return this.contains(FIELD_CREATEDATE);
    }

    @JsonIgnore
    public String getCreateMan() {
        Object objValue = this.get(FIELD_CREATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createman")
    public void setCreateMan(String createMan) {
        this.set(FIELD_CREATEMAN, createMan);
    }

    @JsonIgnore
    public boolean isCreateManDirty() {
        return this.contains(FIELD_CREATEMAN);
    }

    @JsonIgnore
    public String getCSPSSysDynaModelId() {
        Object objValue = this.get(FIELD_CSPSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cspssysdynamodelid")
    public void setCSPSSysDynaModelId(String cSPSSysDynaModelId) {
        this.set(FIELD_CSPSSYSDYNAMODELID, cSPSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isCSPSSysDynaModelIdDirty() {
        return this.contains(FIELD_CSPSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getCSPSSysDynaModelName() {
        Object objValue = this.get(FIELD_CSPSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cspssysdynamodelname")
    public void setCSPSSysDynaModelName(String cSPSSysDynaModelName) {
        this.set(FIELD_CSPSSYSDYNAMODELNAME, cSPSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isCSPSSysDynaModelNameDirty() {
        return this.contains(FIELD_CSPSSYSDYNAMODELNAME);
    }

    @JsonIgnore
    public String getCSPSSysPFPluginId() {
        Object objValue = this.get(FIELD_CSPSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cspssyspfpluginid")
    public void setCSPSSysPFPluginId(String cSPSSysPFPluginId) {
        this.set(FIELD_CSPSSYSPFPLUGINID, cSPSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isCSPSSysPFPluginIdDirty() {
        return this.contains(FIELD_CSPSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getCSPSSysPFPluginName() {
        Object objValue = this.get(FIELD_CSPSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cspssyspfpluginname")
    public void setCSPSSysPFPluginName(String cSPSSysPFPluginName) {
        this.set(FIELD_CSPSSYSPFPLUGINNAME, cSPSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isCSPSSysPFPluginNameDirty() {
        return this.contains(FIELD_CSPSSYSPFPLUGINNAME);
    }

    @JsonIgnore
    public String getDataField() {
        Object objValue = this.get(FIELD_DATAFIELD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="datafield")
    public void setDataField(String dataField) {
        this.set(FIELD_DATAFIELD, dataField);
    }

    @JsonIgnore
    public boolean isDataFieldDirty() {
        return this.contains(FIELD_DATAFIELD);
    }

    @JsonIgnore
    public String getDynaClass() {
        Object objValue = this.get(FIELD_DYNACLASS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynaclass")
    public void setDynaClass(String dynaClass) {
        this.set(FIELD_DYNACLASS, dynaClass);
    }

    @JsonIgnore
    public boolean isDynaClassDirty() {
        return this.contains(FIELD_DYNACLASS);
    }

    @JsonIgnore
    public Integer getEndAngle() {
        Object objValue = this.get(FIELD_ENDANGLE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="endangle")
    public void setEndAngle(Integer endAngle) {
        this.set(FIELD_ENDANGLE, endAngle);
    }

    @JsonIgnore
    public boolean isEndAngleDirty() {
        return this.contains(FIELD_ENDANGLE);
    }

    @JsonIgnore
    public String getExtField() {
        Object objValue = this.get(FIELD_EXTFIELD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extfield")
    public void setExtField(String extField) {
        this.set(FIELD_EXTFIELD, extField);
    }

    @JsonIgnore
    public boolean isExtFieldDirty() {
        return this.contains(FIELD_EXTFIELD);
    }

    @JsonIgnore
    public String getExtField2() {
        Object objValue = this.get(FIELD_EXTFIELD2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extfield2")
    public void setExtField2(String extField2) {
        this.set(FIELD_EXTFIELD2, extField2);
    }

    @JsonIgnore
    public boolean isExtField2Dirty() {
        return this.contains(FIELD_EXTFIELD2);
    }

    @JsonIgnore
    public String getExtField3() {
        Object objValue = this.get(FIELD_EXTFIELD3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extfield3")
    public void setExtField3(String extField3) {
        this.set(FIELD_EXTFIELD3, extField3);
    }

    @JsonIgnore
    public boolean isExtField3Dirty() {
        return this.contains(FIELD_EXTFIELD3);
    }

    @JsonIgnore
    public String getExtField4() {
        Object objValue = this.get(FIELD_EXTFIELD4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extfield4")
    public void setExtField4(String extField4) {
        this.set(FIELD_EXTFIELD4, extField4);
    }

    @JsonIgnore
    public boolean isExtField4Dirty() {
        return this.contains(FIELD_EXTFIELD4);
    }

    @JsonIgnore
    public String getFunnelAlign() {
        Object objValue = this.get(FIELD_FUNNELALIGN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="funnelalign")
    public void setFunnelAlign(String funnelAlign) {
        this.set(FIELD_FUNNELALIGN, funnelAlign);
    }

    @JsonIgnore
    public boolean isFunnelAlignDirty() {
        return this.contains(FIELD_FUNNELALIGN);
    }

    @JsonIgnore
    public String getHeight() {
        Object objValue = this.get(FIELD_HEIGHT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="height")
    public void setHeight(String height) {
        this.set(FIELD_HEIGHT, height);
    }

    @JsonIgnore
    public boolean isHeightDirty() {
        return this.contains(FIELD_HEIGHT);
    }

    @JsonIgnore
    public String getLeftPos() {
        Object objValue = this.get(FIELD_LEFTPOS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="leftpos")
    public void setLeftPos(String leftPos) {
        this.set(FIELD_LEFTPOS, leftPos);
    }

    @JsonIgnore
    public boolean isLeftPosDirty() {
        return this.contains(FIELD_LEFTPOS);
    }

    @JsonIgnore
    public String getMapType() {
        Object objValue = this.get(FIELD_MAPTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="maptype")
    public void setMapType(String mapType) {
        this.set(FIELD_MAPTYPE, mapType);
    }

    @JsonIgnore
    public boolean isMapTypeDirty() {
        return this.contains(FIELD_MAPTYPE);
    }

    @JsonIgnore
    public String getMaxSize() {
        Object objValue = this.get(FIELD_MAXSIZE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="maxsize")
    public void setMaxSize(String maxSize) {
        this.set(FIELD_MAXSIZE, maxSize);
    }

    @JsonIgnore
    public boolean isMaxSizeDirty() {
        return this.contains(FIELD_MAXSIZE);
    }

    @JsonIgnore
    public Integer getMaxValue() {
        Object objValue = this.get(FIELD_MAXVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="maxvalue")
    public void setMaxValue(Integer maxValue) {
        this.set(FIELD_MAXVALUE, maxValue);
    }

    @JsonIgnore
    public boolean isMaxValueDirty() {
        return this.contains(FIELD_MAXVALUE);
    }

    @JsonIgnore
    public String getMemo() {
        Object objValue = this.get(FIELD_MEMO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="memo")
    public void setMemo(String memo) {
        this.set(FIELD_MEMO, memo);
    }

    @JsonIgnore
    public boolean isMemoDirty() {
        return this.contains(FIELD_MEMO);
    }

    @JsonIgnore
    public Integer getMinAngle() {
        Object objValue = this.get(FIELD_MINANGLE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="minangle")
    public void setMinAngle(Integer minAngle) {
        this.set(FIELD_MINANGLE, minAngle);
    }

    @JsonIgnore
    public boolean isMinAngleDirty() {
        return this.contains(FIELD_MINANGLE);
    }

    @JsonIgnore
    public Integer getMinShowLabelAngle() {
        Object objValue = this.get(FIELD_MINSHOWLABELANGLE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="minshowlabelangle")
    public void setMinShowLabelAngle(Integer minShowLabelAngle) {
        this.set(FIELD_MINSHOWLABELANGLE, minShowLabelAngle);
    }

    @JsonIgnore
    public boolean isMinShowLabelAngleDirty() {
        return this.contains(FIELD_MINSHOWLABELANGLE);
    }

    @JsonIgnore
    public String getMinSize() {
        Object objValue = this.get(FIELD_MINSIZE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minsize")
    public void setMinSize(String minSize) {
        this.set(FIELD_MINSIZE, minSize);
    }

    @JsonIgnore
    public boolean isMinSizeDirty() {
        return this.contains(FIELD_MINSIZE);
    }

    @JsonIgnore
    public Integer getMinValue() {
        Object objValue = this.get(FIELD_MINVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="minvalue")
    public void setMinValue(Integer minValue) {
        this.set(FIELD_MINVALUE, minValue);
    }

    @JsonIgnore
    public boolean isMinValueDirty() {
        return this.contains(FIELD_MINVALUE);
    }

    @JsonIgnore
    public String getNavViewFilter() {
        Object objValue = this.get(FIELD_NAVVIEWFILTER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navviewfilter")
    public void setNavViewFilter(String navViewFilter) {
        this.set(FIELD_NAVVIEWFILTER, navViewFilter);
    }

    @JsonIgnore
    public boolean isNavViewFilterDirty() {
        return this.contains(FIELD_NAVVIEWFILTER);
    }

    @JsonIgnore
    public String getNavViewParam() {
        Object objValue = this.get(FIELD_NAVVIEWPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navviewparam")
    public void setNavViewParam(String navViewParam) {
        this.set(FIELD_NAVVIEWPARAM, navViewParam);
    }

    @JsonIgnore
    public boolean isNavViewParamDirty() {
        return this.contains(FIELD_NAVVIEWPARAM);
    }

    @JsonIgnore
    public Integer getOrderValue() {
        Object objValue = this.get(FIELD_ORDERVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ordervalue")
    public void setOrderValue(Integer orderValue) {
        this.set(FIELD_ORDERVALUE, orderValue);
    }

    @JsonIgnore
    public boolean isOrderValueDirty() {
        return this.contains(FIELD_ORDERVALUE);
    }

    @JsonIgnore
    public String getPSDEChartId() {
        Object objValue = this.get(FIELD_PSDECHARTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdechartid")
    public void setPSDEChartId(String pSDEChartId) {
        this.set(FIELD_PSDECHARTID, pSDEChartId);
    }

    @JsonIgnore
    public boolean isPSDEChartIdDirty() {
        return this.contains(FIELD_PSDECHARTID);
    }

    @JsonIgnore
    public String getPSDEChartName() {
        Object objValue = this.get(FIELD_PSDECHARTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdechartname")
    public void setPSDEChartName(String pSDEChartName) {
        this.set(FIELD_PSDECHARTNAME, pSDEChartName);
    }

    @JsonIgnore
    public boolean isPSDEChartNameDirty() {
        return this.contains(FIELD_PSDECHARTNAME);
    }

    @JsonIgnore
    public String getPSDEChartParamId() {
        Object objValue = this.get(FIELD_PSDECHARTPARAMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdechartparamid")
    public void setPSDEChartParamId(String pSDEChartParamId) {
        this.set(FIELD_PSDECHARTPARAMID, pSDEChartParamId);
    }

    @JsonIgnore
    public boolean isPSDEChartParamIdDirty() {
        return this.contains(FIELD_PSDECHARTPARAMID);
    }

    @JsonIgnore
    public String getPSDEChartParamName() {
        Object objValue = this.get(FIELD_PSDECHARTPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdechartparamname")
    public void setPSDEChartParamName(String pSDEChartParamName) {
        this.set(FIELD_PSDECHARTPARAMNAME, pSDEChartParamName);
    }

    @JsonIgnore
    public boolean isPSDEChartParamNameDirty() {
        return this.contains(FIELD_PSDECHARTPARAMNAME);
    }

    @JsonIgnore
    public String getPSDEId() {
        Object objValue = this.get(FIELD_PSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeid")
    public void setPSDEId(String pSDEId) {
        this.set(FIELD_PSDEID, pSDEId);
    }

    @JsonIgnore
    public boolean isPSDEIdDirty() {
        return this.contains(FIELD_PSDEID);
    }

    @JsonIgnore
    public String getPSDERId() {
        Object objValue = this.get(FIELD_PSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psderid")
    public void setPSDERId(String pSDERId) {
        this.set(FIELD_PSDERID, pSDERId);
    }

    @JsonIgnore
    public boolean isPSDERIdDirty() {
        return this.contains(FIELD_PSDERID);
    }

    @JsonIgnore
    public String getPSDERName() {
        Object objValue = this.get(FIELD_PSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdername")
    public void setPSDERName(String pSDERName) {
        this.set(FIELD_PSDERNAME, pSDERName);
    }

    @JsonIgnore
    public boolean isPSDERNameDirty() {
        return this.contains(FIELD_PSDERNAME);
    }

    @JsonIgnore
    public String getPSDEViewBaseId() {
        Object objValue = this.get(FIELD_PSDEVIEWBASEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewbaseid")
    public void setPSDEViewBaseId(String pSDEViewBaseId) {
        this.set(FIELD_PSDEVIEWBASEID, pSDEViewBaseId);
    }

    @JsonIgnore
    public boolean isPSDEViewBaseIdDirty() {
        return this.contains(FIELD_PSDEVIEWBASEID);
    }

    @JsonIgnore
    public String getPSDEViewBaseName() {
        Object objValue = this.get(FIELD_PSDEVIEWBASENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewbasename")
    public void setPSDEViewBaseName(String pSDEViewBaseName) {
        this.set(FIELD_PSDEVIEWBASENAME, pSDEViewBaseName);
    }

    @JsonIgnore
    public boolean isPSDEViewBaseNameDirty() {
        return this.contains(FIELD_PSDEVIEWBASENAME);
    }

    @JsonIgnore
    public String getPSSysDynaModelId() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelid")
    public void setPSSysDynaModelId(String pSSysDynaModelId) {
        this.set(FIELD_PSSYSDYNAMODELID, pSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelIdDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getPSSysDynaModelName() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelname")
    public void setPSSysDynaModelName(String pSSysDynaModelName) {
        this.set(FIELD_PSSYSDYNAMODELNAME, pSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelNameDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELNAME);
    }

    @JsonIgnore
    public String getPSSysPFPluginId() {
        Object objValue = this.get(FIELD_PSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpluginid")
    public void setPSSysPFPluginId(String pSSysPFPluginId) {
        this.set(FIELD_PSSYSPFPLUGINID, pSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isPSSysPFPluginIdDirty() {
        return this.contains(FIELD_PSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getPSSysPFPluginName() {
        Object objValue = this.get(FIELD_PSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpluginname")
    public void setPSSysPFPluginName(String pSSysPFPluginName) {
        this.set(FIELD_PSSYSPFPLUGINNAME, pSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isPSSysPFPluginNameDirty() {
        return this.contains(FIELD_PSSYSPFPLUGINNAME);
    }

    @JsonIgnore
    public String getRadius() {
        Object objValue = this.get(FIELD_RADIUS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="radius")
    public void setRadius(String radius) {
        this.set(FIELD_RADIUS, radius);
    }

    @JsonIgnore
    public boolean isRadiusDirty() {
        return this.contains(FIELD_RADIUS);
    }

    @JsonIgnore
    public String getRightPos() {
        Object objValue = this.get(FIELD_RIGHTPOS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rightpos")
    public void setRightPos(String rightPos) {
        this.set(FIELD_RIGHTPOS, rightPos);
    }

    @JsonIgnore
    public boolean isRightPosDirty() {
        return this.contains(FIELD_RIGHTPOS);
    }

    @JsonIgnore
    public String getRoseType() {
        Object objValue = this.get(FIELD_ROSETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rosetype")
    public void setRoseType(String roseType) {
        this.set(FIELD_ROSETYPE, roseType);
    }

    @JsonIgnore
    public boolean isRoseTypeDirty() {
        return this.contains(FIELD_ROSETYPE);
    }

    @JsonIgnore
    public String getSampleData() {
        Object objValue = this.get(FIELD_SAMPLEDATA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sampledata")
    public void setSampleData(String sampleData) {
        this.set(FIELD_SAMPLEDATA, sampleData);
    }

    @JsonIgnore
    public boolean isSampleDataDirty() {
        return this.contains(FIELD_SAMPLEDATA);
    }

    @JsonIgnore
    public String getSeriesField() {
        Object objValue = this.get(FIELD_SERIESFIELD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="seriesfield")
    public void setSeriesField(String seriesField) {
        this.set(FIELD_SERIESFIELD, seriesField);
    }

    @JsonIgnore
    public boolean isSeriesFieldDirty() {
        return this.contains(FIELD_SERIESFIELD);
    }

    @JsonIgnore
    public String getSeriesLayoutBy() {
        Object objValue = this.get(FIELD_SERIESLAYOUTBY);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="serieslayoutby")
    public void setSeriesLayoutBy(String seriesLayoutBy) {
        this.set(FIELD_SERIESLAYOUTBY, seriesLayoutBy);
    }

    @JsonIgnore
    public boolean isSeriesLayoutByDirty() {
        return this.contains(FIELD_SERIESLAYOUTBY);
    }

    @JsonIgnore
    public String getSeriesParam() {
        Object objValue = this.get(FIELD_SERIESPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="seriesparam")
    public void setSeriesParam(String seriesParam) {
        this.set(FIELD_SERIESPARAM, seriesParam);
    }

    @JsonIgnore
    public boolean isSeriesParamDirty() {
        return this.contains(FIELD_SERIESPARAM);
    }

    @JsonIgnore
    public Double getSeriesParam10() {
        Object objValue = this.get(FIELD_SERIESPARAM10);
        if (objValue == null) {
            return null;
        }
        return (Double)objValue;
    }

    @JsonProperty(value="seriesparam10")
    public void setSeriesParam10(Double seriesParam10) {
        this.set(FIELD_SERIESPARAM10, seriesParam10);
    }

    @JsonIgnore
    public boolean isSeriesParam10Dirty() {
        return this.contains(FIELD_SERIESPARAM10);
    }

    @JsonIgnore
    public Integer getSeriesParam11() {
        Object objValue = this.get(FIELD_SERIESPARAM11);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="seriesparam11")
    public void setSeriesParam11(Integer seriesParam11) {
        this.set(FIELD_SERIESPARAM11, seriesParam11);
    }

    @JsonIgnore
    public boolean isSeriesParam11Dirty() {
        return this.contains(FIELD_SERIESPARAM11);
    }

    @JsonIgnore
    public Integer getSeriesParam12() {
        Object objValue = this.get(FIELD_SERIESPARAM12);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="seriesparam12")
    public void setSeriesParam12(Integer seriesParam12) {
        this.set(FIELD_SERIESPARAM12, seriesParam12);
    }

    @JsonIgnore
    public boolean isSeriesParam12Dirty() {
        return this.contains(FIELD_SERIESPARAM12);
    }

    @JsonIgnore
    public String getSeriesParam2() {
        Object objValue = this.get(FIELD_SERIESPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="seriesparam2")
    public void setSeriesParam2(String seriesParam2) {
        this.set(FIELD_SERIESPARAM2, seriesParam2);
    }

    @JsonIgnore
    public boolean isSeriesParam2Dirty() {
        return this.contains(FIELD_SERIESPARAM2);
    }

    @JsonIgnore
    public String getSeriesParam3() {
        Object objValue = this.get(FIELD_SERIESPARAM3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="seriesparam3")
    public void setSeriesParam3(String seriesParam3) {
        this.set(FIELD_SERIESPARAM3, seriesParam3);
    }

    @JsonIgnore
    public boolean isSeriesParam3Dirty() {
        return this.contains(FIELD_SERIESPARAM3);
    }

    @JsonIgnore
    public String getSeriesParam4() {
        Object objValue = this.get(FIELD_SERIESPARAM4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="seriesparam4")
    public void setSeriesParam4(String seriesParam4) {
        this.set(FIELD_SERIESPARAM4, seriesParam4);
    }

    @JsonIgnore
    public boolean isSeriesParam4Dirty() {
        return this.contains(FIELD_SERIESPARAM4);
    }

    @JsonIgnore
    public Integer getSeriesParam5() {
        Object objValue = this.get(FIELD_SERIESPARAM5);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="seriesparam5")
    public void setSeriesParam5(Integer seriesParam5) {
        this.set(FIELD_SERIESPARAM5, seriesParam5);
    }

    @JsonIgnore
    public boolean isSeriesParam5Dirty() {
        return this.contains(FIELD_SERIESPARAM5);
    }

    @JsonIgnore
    public Integer getSeriesParam6() {
        Object objValue = this.get(FIELD_SERIESPARAM6);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="seriesparam6")
    public void setSeriesParam6(Integer seriesParam6) {
        this.set(FIELD_SERIESPARAM6, seriesParam6);
    }

    @JsonIgnore
    public boolean isSeriesParam6Dirty() {
        return this.contains(FIELD_SERIESPARAM6);
    }

    @JsonIgnore
    public Integer getSeriesParam7() {
        Object objValue = this.get(FIELD_SERIESPARAM7);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="seriesparam7")
    public void setSeriesParam7(Integer seriesParam7) {
        this.set(FIELD_SERIESPARAM7, seriesParam7);
    }

    @JsonIgnore
    public boolean isSeriesParam7Dirty() {
        return this.contains(FIELD_SERIESPARAM7);
    }

    @JsonIgnore
    public Integer getSeriesParam8() {
        Object objValue = this.get(FIELD_SERIESPARAM8);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="seriesparam8")
    public void setSeriesParam8(Integer seriesParam8) {
        this.set(FIELD_SERIESPARAM8, seriesParam8);
    }

    @JsonIgnore
    public boolean isSeriesParam8Dirty() {
        return this.contains(FIELD_SERIESPARAM8);
    }

    @JsonIgnore
    public Double getSeriesParam9() {
        Object objValue = this.get(FIELD_SERIESPARAM9);
        if (objValue == null) {
            return null;
        }
        return (Double)objValue;
    }

    @JsonProperty(value="seriesparam9")
    public void setSeriesParam9(Double seriesParam9) {
        this.set(FIELD_SERIESPARAM9, seriesParam9);
    }

    @JsonIgnore
    public boolean isSeriesParam9Dirty() {
        return this.contains(FIELD_SERIESPARAM9);
    }

    @JsonIgnore
    public String getSFPSCodeListId() {
        Object objValue = this.get(FIELD_SFPSCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sfpscodelistid")
    public void setSFPSCodeListId(String sFPSCodeListId) {
        this.set(FIELD_SFPSCODELISTID, sFPSCodeListId);
    }

    @JsonIgnore
    public boolean isSFPSCodeListIdDirty() {
        return this.contains(FIELD_SFPSCODELISTID);
    }

    @JsonIgnore
    public String getSFPSCodeListName() {
        Object objValue = this.get(FIELD_SFPSCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sfpscodelistname")
    public void setSFPSCodeListName(String sFPSCodeListName) {
        this.set(FIELD_SFPSCODELISTNAME, sFPSCodeListName);
    }

    @JsonIgnore
    public boolean isSFPSCodeListNameDirty() {
        return this.contains(FIELD_SFPSCODELISTNAME);
    }

    @JsonIgnore
    public String getSortDir() {
        Object objValue = this.get(FIELD_SORTDIR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sortdir")
    public void setSortDir(String sortDir) {
        this.set(FIELD_SORTDIR, sortDir);
    }

    @JsonIgnore
    public boolean isSortDirDirty() {
        return this.contains(FIELD_SORTDIR);
    }

    @JsonIgnore
    public Integer getSplitNumber() {
        Object objValue = this.get(FIELD_SPLITNUMBER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="splitnumber")
    public void setSplitNumber(Integer splitNumber) {
        this.set(FIELD_SPLITNUMBER, splitNumber);
    }

    @JsonIgnore
    public boolean isSplitNumberDirty() {
        return this.contains(FIELD_SPLITNUMBER);
    }

    @JsonIgnore
    public Integer getStack() {
        Object objValue = this.get(FIELD_STACK);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="stack")
    public void setStack(Integer stack) {
        this.set(FIELD_STACK, stack);
    }

    @JsonIgnore
    public boolean isStackDirty() {
        return this.contains(FIELD_STACK);
    }

    @JsonIgnore
    public Integer getStartAngle() {
        Object objValue = this.get(FIELD_STARTANGLE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="startangle")
    public void setStartAngle(Integer startAngle) {
        this.set(FIELD_STARTANGLE, startAngle);
    }

    @JsonIgnore
    public boolean isStartAngleDirty() {
        return this.contains(FIELD_STARTANGLE);
    }

    @JsonIgnore
    public String getStep() {
        Object objValue = this.get(FIELD_STEP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="step")
    public void setStep(String step) {
        this.set(FIELD_STEP, step);
    }

    @JsonIgnore
    public boolean isStepDirty() {
        return this.contains(FIELD_STEP);
    }

    @JsonIgnore
    public String getTagField() {
        Object objValue = this.get(FIELD_TAGFIELD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tagfield")
    public void setTagField(String tagField) {
        this.set(FIELD_TAGFIELD, tagField);
    }

    @JsonIgnore
    public boolean isTagFieldDirty() {
        return this.contains(FIELD_TAGFIELD);
    }

    @JsonIgnore
    public String getTimeGroup() {
        Object objValue = this.get(FIELD_TIMEGROUP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="timegroup")
    public void setTimeGroup(String timeGroup) {
        this.set(FIELD_TIMEGROUP, timeGroup);
    }

    @JsonIgnore
    public boolean isTimeGroupDirty() {
        return this.contains(FIELD_TIMEGROUP);
    }

    @JsonIgnore
    public String getTopPos() {
        Object objValue = this.get(FIELD_TOPPOS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="toppos")
    public void setTopPos(String topPos) {
        this.set(FIELD_TOPPOS, topPos);
    }

    @JsonIgnore
    public boolean isTopPosDirty() {
        return this.contains(FIELD_TOPPOS);
    }

    @JsonIgnore
    public Timestamp getUpdateDate() {
        Object objValue = this.get(FIELD_UPDATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="updatedate")
    public void setUpdateDate(Timestamp updateDate) {
        this.set(FIELD_UPDATEDATE, updateDate);
    }

    @JsonIgnore
    public boolean isUpdateDateDirty() {
        return this.contains(FIELD_UPDATEDATE);
    }

    @JsonIgnore
    public String getUpdateMan() {
        Object objValue = this.get(FIELD_UPDATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updateman")
    public void setUpdateMan(String updateMan) {
        this.set(FIELD_UPDATEMAN, updateMan);
    }

    @JsonIgnore
    public boolean isUpdateManDirty() {
        return this.contains(FIELD_UPDATEMAN);
    }

    @JsonIgnore
    public String getUserCat() {
        Object objValue = this.get(FIELD_USERCAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usercat")
    public void setUserCat(String userCat) {
        this.set(FIELD_USERCAT, userCat);
    }

    @JsonIgnore
    public boolean isUserCatDirty() {
        return this.contains(FIELD_USERCAT);
    }

    @JsonIgnore
    public String getUserParams() {
        Object objValue = this.get(FIELD_USERPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userparams")
    public void setUserParams(String userParams) {
        this.set(FIELD_USERPARAMS, userParams);
    }

    @JsonIgnore
    public boolean isUserParamsDirty() {
        return this.contains(FIELD_USERPARAMS);
    }

    @JsonIgnore
    public String getUserTag() {
        Object objValue = this.get(FIELD_USERTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag")
    public void setUserTag(String userTag) {
        this.set(FIELD_USERTAG, userTag);
    }

    @JsonIgnore
    public boolean isUserTagDirty() {
        return this.contains(FIELD_USERTAG);
    }

    @JsonIgnore
    public String getUserTag2() {
        Object objValue = this.get(FIELD_USERTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag2")
    public void setUserTag2(String userTag2) {
        this.set(FIELD_USERTAG2, userTag2);
    }

    @JsonIgnore
    public boolean isUserTag2Dirty() {
        return this.contains(FIELD_USERTAG2);
    }

    @JsonIgnore
    public String getUserTag3() {
        Object objValue = this.get(FIELD_USERTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag3")
    public void setUserTag3(String userTag3) {
        this.set(FIELD_USERTAG3, userTag3);
    }

    @JsonIgnore
    public boolean isUserTag3Dirty() {
        return this.contains(FIELD_USERTAG3);
    }

    @JsonIgnore
    public String getUserTag4() {
        Object objValue = this.get(FIELD_USERTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag4")
    public void setUserTag4(String userTag4) {
        this.set(FIELD_USERTAG4, userTag4);
    }

    @JsonIgnore
    public boolean isUserTag4Dirty() {
        return this.contains(FIELD_USERTAG4);
    }

    @JsonIgnore
    public String getWidth() {
        Object objValue = this.get(FIELD_WIDTH);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="width")
    public void setWidth(String width) {
        this.set(FIELD_WIDTH, width);
    }

    @JsonIgnore
    public boolean isWidthDirty() {
        return this.contains(FIELD_WIDTH);
    }

    @JsonIgnore
    public String getXField() {
        Object objValue = this.get(FIELD_XFIELD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="xfield")
    public void setXField(String xField) {
        this.set(FIELD_XFIELD, xField);
    }

    @JsonIgnore
    public boolean isXFieldDirty() {
        return this.contains(FIELD_XFIELD);
    }

    @JsonIgnore
    public String getXFPSCodeListId() {
        Object objValue = this.get(FIELD_XFPSCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="xfpscodelistid")
    public void setXFPSCodeListId(String xFPSCodeListId) {
        this.set(FIELD_XFPSCODELISTID, xFPSCodeListId);
    }

    @JsonIgnore
    public boolean isXFPSCodeListIdDirty() {
        return this.contains(FIELD_XFPSCODELISTID);
    }

    @JsonIgnore
    public String getXFPSCodeListName() {
        Object objValue = this.get(FIELD_XFPSCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="xfpscodelistname")
    public void setXFPSCodeListName(String xFPSCodeListName) {
        this.set(FIELD_XFPSCODELISTNAME, xFPSCodeListName);
    }

    @JsonIgnore
    public boolean isXFPSCodeListNameDirty() {
        return this.contains(FIELD_XFPSCODELISTNAME);
    }

    @JsonIgnore
    public String getXPSDEChartAxesId() {
        Object objValue = this.get(FIELD_XPSDECHARTAXESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="xpsdechartaxesid")
    public void setXPSDEChartAxesId(String xPSDEChartAxesId) {
        this.set(FIELD_XPSDECHARTAXESID, xPSDEChartAxesId);
    }

    @JsonIgnore
    public boolean isXPSDEChartAxesIdDirty() {
        return this.contains(FIELD_XPSDECHARTAXESID);
    }

    @JsonIgnore
    public String getXPSDEChartAxesName() {
        Object objValue = this.get(FIELD_XPSDECHARTAXESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="xpsdechartaxesname")
    public void setXPSDEChartAxesName(String xPSDEChartAxesName) {
        this.set(FIELD_XPSDECHARTAXESNAME, xPSDEChartAxesName);
    }

    @JsonIgnore
    public boolean isXPSDEChartAxesNameDirty() {
        return this.contains(FIELD_XPSDECHARTAXESNAME);
    }

    @JsonIgnore
    public String getYField() {
        Object objValue = this.get(FIELD_YFIELD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="yfield")
    public void setYField(String yField) {
        this.set(FIELD_YFIELD, yField);
    }

    @JsonIgnore
    public boolean isYFieldDirty() {
        return this.contains(FIELD_YFIELD);
    }

    @JsonIgnore
    public String getYPSDEChartAxesId() {
        Object objValue = this.get(FIELD_YPSDECHARTAXESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ypsdechartaxesid")
    public void setYPSDEChartAxesId(String yPSDEChartAxesId) {
        this.set(FIELD_YPSDECHARTAXESID, yPSDEChartAxesId);
    }

    @JsonIgnore
    public boolean isYPSDEChartAxesIdDirty() {
        return this.contains(FIELD_YPSDECHARTAXESID);
    }

    @JsonIgnore
    public String getYPSDEChartAxesName() {
        Object objValue = this.get(FIELD_YPSDECHARTAXESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ypsdechartaxesname")
    public void setYPSDEChartAxesName(String yPSDEChartAxesName) {
        this.set(FIELD_YPSDECHARTAXESNAME, yPSDEChartAxesName);
    }

    @JsonIgnore
    public boolean isYPSDEChartAxesNameDirty() {
        return this.contains(FIELD_YPSDECHARTAXESNAME);
    }

    @JsonIgnore
    public String getZField() {
        Object objValue = this.get(FIELD_ZFIELD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="zfield")
    public void setZField(String zField) {
        this.set(FIELD_ZFIELD, zField);
    }

    @JsonIgnore
    public boolean isZFieldDirty() {
        return this.contains(FIELD_ZFIELD);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEChartParamId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEChartParamId(strValue);
    }
}

