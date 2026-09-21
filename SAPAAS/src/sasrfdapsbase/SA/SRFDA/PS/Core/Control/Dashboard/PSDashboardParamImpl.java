/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboardParam;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlParamImpl;
import SA.SRFramework.Utility.StringHelper;

public class PSDashboardParamImpl
extends PSMDAjaxControlParamImpl
implements IPSDashboardParam {
    private double[] columnModels = null;
    protected String strLayoutMode = "";
    private String strFlexAlign = null;
    private String strFlexVAlign = null;
    private String strFlexDir = null;
    private Boolean bEnableCustomized = null;
    private Integer nCustomizeMode = null;
    private String strDashboardStyle = null;
    private String strDashboardTag = null;
    private String strDashboardTag2 = null;
    private Boolean bShowDashboardNavBar = null;
    private String strNavBarPos = null;
    private String strNavBarStyle = null;
    private Double fNavBarWidth = null;
    private Double fNavBarHeight = null;
    private String strNavBarPSSysCssId = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDashboardParam) {
            IPSDashboardParam iPSDashboardParam = (IPSDashboardParam)iPSControlParam;
            if (iPSDashboardParam.getColumnModels() != null) {
                this.setColumnModels(iPSDashboardParam.getColumnModels());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDashboardParam.getLayoutMode())) {
                this.setLayoutMode(iPSDashboardParam.getLayoutMode());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDashboardParam.getFlexDir())) {
                this.setFlexDir(iPSDashboardParam.getFlexDir());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDashboardParam.getFlexAlign())) {
                this.setFlexAlign(iPSDashboardParam.getFlexAlign());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDashboardParam.getFlexVAlign())) {
                this.setFlexVAlign(iPSDashboardParam.getFlexVAlign());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDashboardParam.getDashboardStyle())) {
                this.setDashboardStyle(iPSDashboardParam.getDashboardStyle());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDashboardParam.getDashboardTag())) {
                this.setDashboardTag(iPSDashboardParam.getDashboardTag());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDashboardParam.getDashboardTag2())) {
                this.setDashboardTag2(iPSDashboardParam.getDashboardTag2());
            }
            if (iPSDashboardParam.isEnableCustomized() != null) {
                this.setEnableCustomized(iPSDashboardParam.isEnableCustomized());
            }
            if (iPSDashboardParam.getCustomizeMode() != null) {
                this.setCustomizeMode(iPSDashboardParam.getCustomizeMode());
            }
            if (iPSDashboardParam.isShowDashboardNavBar() != null) {
                this.setShowDashboardNavBar(iPSDashboardParam.isShowDashboardNavBar());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDashboardParam.getNavBarPos())) {
                this.setNavBarPos(iPSDashboardParam.getNavBarPos());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDashboardParam.getNavBarStyle())) {
                this.setNavBarStyle(iPSDashboardParam.getNavBarStyle());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDashboardParam.getNavBarPSSysCssId())) {
                this.setNavBarPSSysCssId(iPSDashboardParam.getNavBarPSSysCssId());
            }
            if (iPSDashboardParam.getNavBarHeight() != null) {
                this.setNavBarHeight(iPSDashboardParam.getNavBarHeight());
            }
            if (iPSDashboardParam.getNavBarWidth() != null) {
                this.setNavBarWidth(iPSDashboardParam.getNavBarWidth());
            }
        }
    }

    @Override
    public double[] getColumnModels() {
        return this.columnModels;
    }

    public void setColumnModels(double[] columnModels) {
        this.columnModels = columnModels;
    }

    @Override
    public String getLayoutMode() {
        return this.strLayoutMode;
    }

    public void setLayoutMode(String strLayoutMode) {
        this.strLayoutMode = strLayoutMode;
    }

    @Override
    public String getFlexVAlign() {
        return this.strFlexVAlign;
    }

    public void setFlexVAlign(String strFlexVAlign) {
        this.strFlexVAlign = strFlexVAlign;
    }

    @Override
    public String getFlexAlign() {
        return this.strFlexAlign;
    }

    public void setFlexAlign(String strFlexAlign) {
        this.strFlexAlign = strFlexAlign;
    }

    @Override
    public String getFlexDir() {
        return this.strFlexDir;
    }

    public void setFlexDir(String strFlexDir) {
        this.strFlexDir = strFlexDir;
    }

    @Override
    public Boolean isEnableCustomized() {
        if (this.bEnableCustomized == null) {
            return null;
        }
        return this.bEnableCustomized;
    }

    public void setEnableCustomized(Boolean bEnableCustomized) {
        this.bEnableCustomized = bEnableCustomized;
    }

    @Override
    public Integer getCustomizeMode() {
        return this.nCustomizeMode;
    }

    public void setCustomizeMode(Integer nCustomizeMode) {
        this.nCustomizeMode = nCustomizeMode;
    }

    @Override
    public String getDashboardStyle() {
        return this.strDashboardStyle;
    }

    public void setDashboardStyle(String strDashboardStyle) {
        this.strDashboardStyle = strDashboardStyle;
    }

    @Override
    public String getDashboardTag() {
        return this.strDashboardTag;
    }

    public void setDashboardTag(String strDashboardTag) {
        this.strDashboardTag = strDashboardTag;
    }

    @Override
    public String getDashboardTag2() {
        return this.strDashboardTag2;
    }

    public void setDashboardTag2(String strDashboardTag2) {
        this.strDashboardTag2 = strDashboardTag2;
    }

    @Override
    public Boolean isShowDashboardNavBar() {
        if (this.bShowDashboardNavBar == null) {
            return null;
        }
        return this.bShowDashboardNavBar;
    }

    public void setShowDashboardNavBar(Boolean bShowDashboardNavBar) {
        this.bShowDashboardNavBar = bShowDashboardNavBar;
    }

    @Override
    public String getNavBarPos() {
        return this.strNavBarPos;
    }

    public void setNavBarPos(String strNavBarPos) {
        this.strNavBarPos = strNavBarPos;
    }

    @Override
    public String getNavBarStyle() {
        return this.strNavBarStyle;
    }

    public void setNavBarStyle(String strNavBarStyle) {
        this.strNavBarStyle = strNavBarStyle;
    }

    @Override
    public String getNavBarPSSysCssId() {
        return this.strNavBarPSSysCssId;
    }

    public void setNavBarPSSysCssId(String strNavBarPSSysCssId) {
        this.strNavBarPSSysCssId = strNavBarPSSysCssId;
    }

    @Override
    public Double getNavBarHeight() {
        return this.fNavBarHeight;
    }

    public void setNavBarHeight(Double fNavBarHeight) {
        this.fNavBarHeight = fNavBarHeight;
    }

    @Override
    public Double getNavBarWidth() {
        return this.fNavBarWidth;
    }

    public void setNavBarWidth(Double fNavBarWidth) {
        this.fNavBarWidth = fNavBarWidth;
    }
}

