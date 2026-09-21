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
import java.util.List;
import net.ibizsys.modelapi.dto.PSAppPVPartDTO;
import net.ibizsys.modelapi.dto.PSAppViewDTO;

public class PSAppPortalViewDTO
extends PSAppViewDTO {
    public static final String FIELD_COLMODEL = "colmodel";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTPAGE = "defaultpage";
    public static final String FIELD_ENABLECUSTOMIZE = "enablecustomize";
    public static final String FIELD_FLEXALIGN = "flexalign";
    public static final String FIELD_FLEXDIR = "flexdir";
    public static final String FIELD_FLEXVALIGN = "flexvalign";
    public static final String FIELD_LAYOUTMODE = "layoutmode";
    public static final String FIELD_PSAPPPORTALVIEWID = "psappportalviewid";
    public static final String FIELD_PSAPPPORTALVIEWNAME = "psappportalviewname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    private List<PSAppPVPartDTO> psapppvparts;

    @JsonIgnore
    public String getColModel() {
        Object objValue = this.get(FIELD_COLMODEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="colmodel")
    public void setColModel(String colModel) {
        this.set(FIELD_COLMODEL, colModel);
    }

    @JsonIgnore
    public boolean isColModelDirty() {
        return this.contains(FIELD_COLMODEL);
    }

    @Override
    @JsonIgnore
    public Timestamp getCreateDate() {
        Object objValue = this.get(FIELD_CREATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @Override
    @JsonProperty(value="createdate")
    public void setCreateDate(Timestamp createDate) {
        this.set(FIELD_CREATEDATE, createDate);
    }

    @Override
    @JsonIgnore
    public boolean isCreateDateDirty() {
        return this.contains(FIELD_CREATEDATE);
    }

    @Override
    @JsonIgnore
    public String getCreateMan() {
        Object objValue = this.get(FIELD_CREATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @Override
    @JsonProperty(value="createman")
    public void setCreateMan(String createMan) {
        this.set(FIELD_CREATEMAN, createMan);
    }

    @Override
    @JsonIgnore
    public boolean isCreateManDirty() {
        return this.contains(FIELD_CREATEMAN);
    }

    @JsonIgnore
    public Integer getDefaultPage() {
        Object objValue = this.get(FIELD_DEFAULTPAGE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultpage")
    public void setDefaultPage(Integer defaultPage) {
        this.set(FIELD_DEFAULTPAGE, defaultPage);
    }

    @JsonIgnore
    public boolean isDefaultPageDirty() {
        return this.contains(FIELD_DEFAULTPAGE);
    }

    @JsonIgnore
    public Integer getEnableCustomize() {
        Object objValue = this.get(FIELD_ENABLECUSTOMIZE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablecustomize")
    public void setEnableCustomize(Integer enableCustomize) {
        this.set(FIELD_ENABLECUSTOMIZE, enableCustomize);
    }

    @JsonIgnore
    public boolean isEnableCustomizeDirty() {
        return this.contains(FIELD_ENABLECUSTOMIZE);
    }

    @JsonIgnore
    public String getFlexAlign() {
        Object objValue = this.get(FIELD_FLEXALIGN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="flexalign")
    public void setFlexAlign(String flexAlign) {
        this.set(FIELD_FLEXALIGN, flexAlign);
    }

    @JsonIgnore
    public boolean isFlexAlignDirty() {
        return this.contains(FIELD_FLEXALIGN);
    }

    @JsonIgnore
    public String getFlexDir() {
        Object objValue = this.get(FIELD_FLEXDIR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="flexdir")
    public void setFlexDir(String flexDir) {
        this.set(FIELD_FLEXDIR, flexDir);
    }

    @JsonIgnore
    public boolean isFlexDirDirty() {
        return this.contains(FIELD_FLEXDIR);
    }

    @JsonIgnore
    public String getFlexVAlign() {
        Object objValue = this.get(FIELD_FLEXVALIGN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="flexvalign")
    public void setFlexVAlign(String flexVAlign) {
        this.set(FIELD_FLEXVALIGN, flexVAlign);
    }

    @JsonIgnore
    public boolean isFlexVAlignDirty() {
        return this.contains(FIELD_FLEXVALIGN);
    }

    @JsonIgnore
    public String getLayoutMode() {
        Object objValue = this.get(FIELD_LAYOUTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="layoutmode")
    public void setLayoutMode(String layoutMode) {
        this.set(FIELD_LAYOUTMODE, layoutMode);
    }

    @JsonIgnore
    public boolean isLayoutModeDirty() {
        return this.contains(FIELD_LAYOUTMODE);
    }

    @JsonIgnore
    public String getPSAppPortalViewId() {
        Object objValue = this.get(FIELD_PSAPPPORTALVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappportalviewid")
    public void setPSAppPortalViewId(String pSAppPortalViewId) {
        this.set(FIELD_PSAPPPORTALVIEWID, pSAppPortalViewId);
    }

    @JsonIgnore
    public boolean isPSAppPortalViewIdDirty() {
        return this.contains(FIELD_PSAPPPORTALVIEWID);
    }

    @JsonIgnore
    public String getPSAppPortalViewName() {
        Object objValue = this.get(FIELD_PSAPPPORTALVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappportalviewname")
    public void setPSAppPortalViewName(String pSAppPortalViewName) {
        this.set(FIELD_PSAPPPORTALVIEWNAME, pSAppPortalViewName);
    }

    @JsonIgnore
    public boolean isPSAppPortalViewNameDirty() {
        return this.contains(FIELD_PSAPPPORTALVIEWNAME);
    }

    @Override
    @JsonIgnore
    public Timestamp getUpdateDate() {
        Object objValue = this.get(FIELD_UPDATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @Override
    @JsonProperty(value="updatedate")
    public void setUpdateDate(Timestamp updateDate) {
        this.set(FIELD_UPDATEDATE, updateDate);
    }

    @Override
    @JsonIgnore
    public boolean isUpdateDateDirty() {
        return this.contains(FIELD_UPDATEDATE);
    }

    @Override
    @JsonIgnore
    public String getUpdateMan() {
        Object objValue = this.get(FIELD_UPDATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @Override
    @JsonProperty(value="updateman")
    public void setUpdateMan(String updateMan) {
        this.set(FIELD_UPDATEMAN, updateMan);
    }

    @Override
    @JsonIgnore
    public boolean isUpdateManDirty() {
        return this.contains(FIELD_UPDATEMAN);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSAppPortalViewId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSAppPortalViewId(strValue);
    }

    @JsonProperty(value="psapppvparts")
    public List<PSAppPVPartDTO> getPsapppvparts() {
        return this.psapppvparts;
    }

    @JsonProperty(value="psapppvparts")
    public void setPsapppvparts(List<PSAppPVPartDTO> psapppvparts) {
        this.psapppvparts = psapppvparts;
    }
}

