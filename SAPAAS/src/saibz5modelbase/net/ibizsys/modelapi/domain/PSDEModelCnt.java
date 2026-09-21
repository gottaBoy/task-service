/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 */
package net.ibizsys.modelapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.File;
import java.sql.Timestamp;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEModelCnt
extends PSModelBase {
    public static final String FIELD_CLCNT = "clcnt";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEACCNT = "deaccnt";
    public static final String FIELD_DEACTIONCNT = "deactioncnt";
    public static final String FIELD_DECALENDARCNT = "decalendarcnt";
    public static final String FIELD_DECHARTCNT = "dechartcnt";
    public static final String FIELD_DEDASHBOARDCNT = "dedashboardcnt";
    public static final String FIELD_DEDATAVIEWCNT = "dedataviewcnt";
    public static final String FIELD_DEDQCNT = "dedqcnt";
    public static final String FIELD_DEDRCNT = "dedrcnt";
    public static final String FIELD_DEDRGRPCNT = "dedrgrpcnt";
    public static final String FIELD_DEDRITEMCNT = "dedritemcnt";
    public static final String FIELD_DEFIELDCNT = "defieldcnt";
    public static final String FIELD_DEFORMCNT = "deformcnt";
    public static final String FIELD_DEGRIDCNT = "degridcnt";
    public static final String FIELD_DELISTCNT = "delistcnt";
    public static final String FIELD_DELOGICCNT = "delogiccnt";
    public static final String FIELD_DEMAPVIEWCNT = "demapviewcnt";
    public static final String FIELD_DEOPPRIVCNT = "deopprivcnt";
    public static final String FIELD_DEPANELCNT = "depanelcnt";
    public static final String FIELD_DEPORTLETCNT = "deportletcnt";
    public static final String FIELD_DERCNT = "dercnt";
    public static final String FIELD_DERCNT2 = "dercnt2";
    public static final String FIELD_DEREPORTCNT = "dereportcnt";
    public static final String FIELD_DESEARCHBARCNT = "desearchbarcnt";
    public static final String FIELD_DETOOLBARCNT = "detoolbarcnt";
    public static final String FIELD_DETREECNT = "detreecnt";
    public static final String FIELD_DEUACNT = "deuacnt";
    public static final String FIELD_DEUAGRPCNT = "deuagrpcnt";
    public static final String FIELD_DEWFCNT = "dewfcnt";
    public static final String FIELD_INDEXCNT = "indexcnt";
    public static final String FIELD_PSDEMODELCNTID = "psdemodelcntid";
    public static final String FIELD_PSDEMODELCNTNAME = "psdemodelcntname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";

    @JsonIgnore
    public Integer getCLCnt() {
        Object objValue = this.get(FIELD_CLCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="clcnt")
    public void setCLCnt(Integer cLCnt) {
        this.set(FIELD_CLCNT, cLCnt);
    }

    @JsonIgnore
    public boolean isCLCntDirty() {
        return this.contains(FIELD_CLCNT);
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
    public Integer getDEACCnt() {
        Object objValue = this.get(FIELD_DEACCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="deaccnt")
    public void setDEACCnt(Integer dEACCnt) {
        this.set(FIELD_DEACCNT, dEACCnt);
    }

    @JsonIgnore
    public boolean isDEACCntDirty() {
        return this.contains(FIELD_DEACCNT);
    }

    @JsonIgnore
    public Integer getDEActionCnt() {
        Object objValue = this.get(FIELD_DEACTIONCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="deactioncnt")
    public void setDEActionCnt(Integer dEActionCnt) {
        this.set(FIELD_DEACTIONCNT, dEActionCnt);
    }

    @JsonIgnore
    public boolean isDEActionCntDirty() {
        return this.contains(FIELD_DEACTIONCNT);
    }

    @JsonIgnore
    public Integer getDECalendarCnt() {
        Object objValue = this.get(FIELD_DECALENDARCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="decalendarcnt")
    public void setDECalendarCnt(Integer dECalendarCnt) {
        this.set(FIELD_DECALENDARCNT, dECalendarCnt);
    }

    @JsonIgnore
    public boolean isDECalendarCntDirty() {
        return this.contains(FIELD_DECALENDARCNT);
    }

    @JsonIgnore
    public Integer getDEChartCnt() {
        Object objValue = this.get(FIELD_DECHARTCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dechartcnt")
    public void setDEChartCnt(Integer dEChartCnt) {
        this.set(FIELD_DECHARTCNT, dEChartCnt);
    }

    @JsonIgnore
    public boolean isDEChartCntDirty() {
        return this.contains(FIELD_DECHARTCNT);
    }

    @JsonIgnore
    public Integer getDEDashboardCnt() {
        Object objValue = this.get(FIELD_DEDASHBOARDCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dedashboardcnt")
    public void setDEDashboardCnt(Integer dEDashboardCnt) {
        this.set(FIELD_DEDASHBOARDCNT, dEDashboardCnt);
    }

    @JsonIgnore
    public boolean isDEDashboardCntDirty() {
        return this.contains(FIELD_DEDASHBOARDCNT);
    }

    @JsonIgnore
    public Integer getDEDataViewCnt() {
        Object objValue = this.get(FIELD_DEDATAVIEWCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dedataviewcnt")
    public void setDEDataViewCnt(Integer dEDataViewCnt) {
        this.set(FIELD_DEDATAVIEWCNT, dEDataViewCnt);
    }

    @JsonIgnore
    public boolean isDEDataViewCntDirty() {
        return this.contains(FIELD_DEDATAVIEWCNT);
    }

    @JsonIgnore
    public Integer getDEDQCnt() {
        Object objValue = this.get(FIELD_DEDQCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dedqcnt")
    public void setDEDQCnt(Integer dEDQCnt) {
        this.set(FIELD_DEDQCNT, dEDQCnt);
    }

    @JsonIgnore
    public boolean isDEDQCntDirty() {
        return this.contains(FIELD_DEDQCNT);
    }

    @JsonIgnore
    public Integer getDEDRCnt() {
        Object objValue = this.get(FIELD_DEDRCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dedrcnt")
    public void setDEDRCnt(Integer dEDRCnt) {
        this.set(FIELD_DEDRCNT, dEDRCnt);
    }

    @JsonIgnore
    public boolean isDEDRCntDirty() {
        return this.contains(FIELD_DEDRCNT);
    }

    @JsonIgnore
    public Integer getDEDRGrpCnt() {
        Object objValue = this.get(FIELD_DEDRGRPCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dedrgrpcnt")
    public void setDEDRGrpCnt(Integer dEDRGrpCnt) {
        this.set(FIELD_DEDRGRPCNT, dEDRGrpCnt);
    }

    @JsonIgnore
    public boolean isDEDRGrpCntDirty() {
        return this.contains(FIELD_DEDRGRPCNT);
    }

    @JsonIgnore
    public Integer getDEDRItemCnt() {
        Object objValue = this.get(FIELD_DEDRITEMCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dedritemcnt")
    public void setDEDRItemCnt(Integer dEDRItemCnt) {
        this.set(FIELD_DEDRITEMCNT, dEDRItemCnt);
    }

    @JsonIgnore
    public boolean isDEDRItemCntDirty() {
        return this.contains(FIELD_DEDRITEMCNT);
    }

    @JsonIgnore
    public Integer getDEFieldCnt() {
        Object objValue = this.get(FIELD_DEFIELDCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defieldcnt")
    public void setDEFieldCnt(Integer dEFieldCnt) {
        this.set(FIELD_DEFIELDCNT, dEFieldCnt);
    }

    @JsonIgnore
    public boolean isDEFieldCntDirty() {
        return this.contains(FIELD_DEFIELDCNT);
    }

    @JsonIgnore
    public Integer getDEFormCnt() {
        Object objValue = this.get(FIELD_DEFORMCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="deformcnt")
    public void setDEFormCnt(Integer dEFormCnt) {
        this.set(FIELD_DEFORMCNT, dEFormCnt);
    }

    @JsonIgnore
    public boolean isDEFormCntDirty() {
        return this.contains(FIELD_DEFORMCNT);
    }

    @JsonIgnore
    public Integer getDEGridCnt() {
        Object objValue = this.get(FIELD_DEGRIDCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="degridcnt")
    public void setDEGridCnt(Integer dEGridCnt) {
        this.set(FIELD_DEGRIDCNT, dEGridCnt);
    }

    @JsonIgnore
    public boolean isDEGridCntDirty() {
        return this.contains(FIELD_DEGRIDCNT);
    }

    @JsonIgnore
    public Integer getDEListCnt() {
        Object objValue = this.get(FIELD_DELISTCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="delistcnt")
    public void setDEListCnt(Integer dEListCnt) {
        this.set(FIELD_DELISTCNT, dEListCnt);
    }

    @JsonIgnore
    public boolean isDEListCntDirty() {
        return this.contains(FIELD_DELISTCNT);
    }

    @JsonIgnore
    public Integer getDELogicCnt() {
        Object objValue = this.get(FIELD_DELOGICCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="delogiccnt")
    public void setDELogicCnt(Integer dELogicCnt) {
        this.set(FIELD_DELOGICCNT, dELogicCnt);
    }

    @JsonIgnore
    public boolean isDELogicCntDirty() {
        return this.contains(FIELD_DELOGICCNT);
    }

    @JsonIgnore
    public Integer getDEMapViewCnt() {
        Object objValue = this.get(FIELD_DEMAPVIEWCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="demapviewcnt")
    public void setDEMapViewCnt(Integer dEMapViewCnt) {
        this.set(FIELD_DEMAPVIEWCNT, dEMapViewCnt);
    }

    @JsonIgnore
    public boolean isDEMapViewCntDirty() {
        return this.contains(FIELD_DEMAPVIEWCNT);
    }

    @JsonIgnore
    public Integer getDEOPPrivCnt() {
        Object objValue = this.get(FIELD_DEOPPRIVCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="deopprivcnt")
    public void setDEOPPrivCnt(Integer dEOPPrivCnt) {
        this.set(FIELD_DEOPPRIVCNT, dEOPPrivCnt);
    }

    @JsonIgnore
    public boolean isDEOPPrivCntDirty() {
        return this.contains(FIELD_DEOPPRIVCNT);
    }

    @JsonIgnore
    public Integer getDEPanelCnt() {
        Object objValue = this.get(FIELD_DEPANELCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="depanelcnt")
    public void setDEPanelCnt(Integer dEPanelCnt) {
        this.set(FIELD_DEPANELCNT, dEPanelCnt);
    }

    @JsonIgnore
    public boolean isDEPanelCntDirty() {
        return this.contains(FIELD_DEPANELCNT);
    }

    @JsonIgnore
    public Integer getDEPortletCnt() {
        Object objValue = this.get(FIELD_DEPORTLETCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="deportletcnt")
    public void setDEPortletCnt(Integer dEPortletCnt) {
        this.set(FIELD_DEPORTLETCNT, dEPortletCnt);
    }

    @JsonIgnore
    public boolean isDEPortletCntDirty() {
        return this.contains(FIELD_DEPORTLETCNT);
    }

    @JsonIgnore
    public Integer getDERCnt() {
        Object objValue = this.get(FIELD_DERCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dercnt")
    public void setDERCnt(Integer dERCnt) {
        this.set(FIELD_DERCNT, dERCnt);
    }

    @JsonIgnore
    public boolean isDERCntDirty() {
        return this.contains(FIELD_DERCNT);
    }

    @JsonIgnore
    public Integer getDERCnt2() {
        Object objValue = this.get(FIELD_DERCNT2);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dercnt2")
    public void setDERCnt2(Integer dERCnt2) {
        this.set(FIELD_DERCNT2, dERCnt2);
    }

    @JsonIgnore
    public boolean isDERCnt2Dirty() {
        return this.contains(FIELD_DERCNT2);
    }

    @JsonIgnore
    public Integer getDEReportCnt() {
        Object objValue = this.get(FIELD_DEREPORTCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dereportcnt")
    public void setDEReportCnt(Integer dEReportCnt) {
        this.set(FIELD_DEREPORTCNT, dEReportCnt);
    }

    @JsonIgnore
    public boolean isDEReportCntDirty() {
        return this.contains(FIELD_DEREPORTCNT);
    }

    @JsonIgnore
    public Integer getDESearchBarCnt() {
        Object objValue = this.get(FIELD_DESEARCHBARCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="desearchbarcnt")
    public void setDESearchBarCnt(Integer dESearchBarCnt) {
        this.set(FIELD_DESEARCHBARCNT, dESearchBarCnt);
    }

    @JsonIgnore
    public boolean isDESearchBarCntDirty() {
        return this.contains(FIELD_DESEARCHBARCNT);
    }

    @JsonIgnore
    public Integer getDEToolbarCnt() {
        Object objValue = this.get(FIELD_DETOOLBARCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="detoolbarcnt")
    public void setDEToolbarCnt(Integer dEToolbarCnt) {
        this.set(FIELD_DETOOLBARCNT, dEToolbarCnt);
    }

    @JsonIgnore
    public boolean isDEToolbarCntDirty() {
        return this.contains(FIELD_DETOOLBARCNT);
    }

    @JsonIgnore
    public Integer getDETreeCnt() {
        Object objValue = this.get(FIELD_DETREECNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="detreecnt")
    public void setDETreeCnt(Integer dETreeCnt) {
        this.set(FIELD_DETREECNT, dETreeCnt);
    }

    @JsonIgnore
    public boolean isDETreeCntDirty() {
        return this.contains(FIELD_DETREECNT);
    }

    @JsonIgnore
    public Integer getDEUACnt() {
        Object objValue = this.get(FIELD_DEUACNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="deuacnt")
    public void setDEUACnt(Integer dEUACnt) {
        this.set(FIELD_DEUACNT, dEUACnt);
    }

    @JsonIgnore
    public boolean isDEUACntDirty() {
        return this.contains(FIELD_DEUACNT);
    }

    @JsonIgnore
    public Integer getDEUAGrpCnt() {
        Object objValue = this.get(FIELD_DEUAGRPCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="deuagrpcnt")
    public void setDEUAGrpCnt(Integer dEUAGrpCnt) {
        this.set(FIELD_DEUAGRPCNT, dEUAGrpCnt);
    }

    @JsonIgnore
    public boolean isDEUAGrpCntDirty() {
        return this.contains(FIELD_DEUAGRPCNT);
    }

    @JsonIgnore
    public Integer getDEWFCnt() {
        Object objValue = this.get(FIELD_DEWFCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dewfcnt")
    public void setDEWFCnt(Integer dEWFCnt) {
        this.set(FIELD_DEWFCNT, dEWFCnt);
    }

    @JsonIgnore
    public boolean isDEWFCntDirty() {
        return this.contains(FIELD_DEWFCNT);
    }

    @JsonIgnore
    public Integer getIndexCnt() {
        Object objValue = this.get(FIELD_INDEXCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="indexcnt")
    public void setIndexCnt(Integer indexCnt) {
        this.set(FIELD_INDEXCNT, indexCnt);
    }

    @JsonIgnore
    public boolean isIndexCntDirty() {
        return this.contains(FIELD_INDEXCNT);
    }

    @JsonIgnore
    public String getPSDEModelCntId() {
        Object objValue = this.get(FIELD_PSDEMODELCNTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdemodelcntid")
    public void setPSDEModelCntId(String pSDEModelCntId) {
        this.set(FIELD_PSDEMODELCNTID, pSDEModelCntId);
    }

    @JsonIgnore
    public boolean isPSDEModelCntIdDirty() {
        return this.contains(FIELD_PSDEMODELCNTID);
    }

    @JsonIgnore
    public String getPSDEModelCntName() {
        Object objValue = this.get(FIELD_PSDEMODELCNTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdemodelcntname")
    public void setPSDEModelCntName(String pSDEModelCntName) {
        this.set(FIELD_PSDEMODELCNTNAME, pSDEModelCntName);
    }

    @JsonIgnore
    public boolean isPSDEModelCntNameDirty() {
        return this.contains(FIELD_PSDEMODELCNTNAME);
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
    public String getSrfkey() {
        return this.getPSDEModelCntId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEModelCntId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDEMODELCNT";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEModelCnt item = (PSDEModelCnt)MAPPER.readValue(new File(strJsonFilePath), PSDEModelCnt.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEModelCnt) {
            PSDEModelCnt pSDEModelCnt = (PSDEModelCnt)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEModelCnt) {
            PSDEModelCnt pSDEModelCnt = (PSDEModelCnt)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

