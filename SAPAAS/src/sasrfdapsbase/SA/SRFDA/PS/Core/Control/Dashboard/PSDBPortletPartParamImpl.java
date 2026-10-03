/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBAppMenuPortletPartParam;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBAppViewPortletPartParam;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBContainerPortletPartParam;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPartParam;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBRawItemPortletPartParam;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBSysPortletPartParam;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlParamImpl;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSDBPortletPartParamImpl
extends PSMDAjaxControlParamImpl
implements IPSDBPortletPartParam,
IPSDBAppMenuPortletPartParam,
IPSDBSysPortletPartParam,
IPSDBContainerPortletPartParam,
IPSDBAppViewPortletPartParam,
IPSDBRawItemPortletPartParam {
    private String strPSSysPortletId = null;
    private int nColumnId = -1;
    private String strPortletType = null;
    private int nColumnSpan = 1;
    private int nColXS = -1;
    private int nColSM = -1;
    private int nColMD = -1;
    private int nColLG = -1;
    private int nColXSOffset = -1;
    private int nColSMOffset = -1;
    private int nColMDOffset = -1;
    private int nColLGOffset = -1;
    private Boolean bNewRowMode = false;
    private String strPSAppMenuId = null;
    private String strAMPSSysPFPluginId = null;
    private String strAMListStyle = null;
    private String strTitle = null;
    private String strTitlePSLanguageResId = null;
    private Boolean bShowTitleBar = null;
    private String strPSAppFuncPickupViewId = null;
    private String strFlexAlign = null;
    private String strFlexVAlign = null;
    private String strFlexDir = null;
    private String strBorderLayoutPos = null;
    private int nFlexGrow = -1;
    private int nFlexBasis = -1;
    private int nFlexShrink = -1;
    private String strLayoutMode = null;
    private String strEmbededPSAppViewId = null;
    private Integer nTitleBarCloseMode = null;
    private String strPSSysUniResId = null;
    private String strPSSysImageId = null;
    private String strContentType = null;
    private String strRawContent = null;
    private String strHtmlContent = null;
    private String strPSSysResourceId = null;
    private String strDynaClass = null;
    private String strHAlignSelf = null;
    private String strVAlignSelf = null;
    private Boolean bEnableAnchor = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        IPSDBPortletPartParam iPSPortletParam;
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDBPortletPartParam) {
            iPSPortletParam = (IPSDBPortletPartParam)iPSControlParam;
            if (iPSPortletParam.getColumnId() != -1) {
                this.setColumnId(iPSPortletParam.getColumnId());
            }
            if (this.getColLG() <= 0) {
                this.setColLG(iPSPortletParam.getColLG());
            }
            if (this.getColLGOffset() <= 0) {
                this.setColLGOffset(iPSPortletParam.getColLGOffset());
            }
            if (this.getColMD() <= 0) {
                this.setColMD(iPSPortletParam.getColMD());
            }
            if (this.getColMDOffset() <= 0) {
                this.setColMDOffset(iPSPortletParam.getColMDOffset());
            }
            if (this.getColSM() <= 0) {
                this.setColSM(iPSPortletParam.getColSM());
            }
            if (this.getColSMOffset() <= 0) {
                this.setColSMOffset(iPSPortletParam.getColSMOffset());
            }
            if (this.getColXS() <= 0) {
                this.setColXS(iPSPortletParam.getColXS());
            }
            if (this.getColXSOffset() <= 0) {
                this.setColXSOffset(iPSPortletParam.getColXSOffset());
            }
            if (this.bNewRowMode == null) {
                this.setNewRowMode(iPSPortletParam.isNewRowMode());
            }
            if (this.bShowTitleBar == null) {
                this.setShowTitleBar(iPSPortletParam.getShowTitleBar());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSPortletParam.getTitle())) {
                this.setTitle(iPSPortletParam.getTitle());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSPortletParam.getTitlePSLanguageResId())) {
                this.setTitlePSLanguageResId(iPSPortletParam.getTitlePSLanguageResId());
            }
            if (this.getFlexGrow() <= 0) {
                this.setFlexGrow(iPSPortletParam.getFlexGrow());
            }
            if (this.getFlexBasis() <= 0) {
                this.setFlexBasis(iPSPortletParam.getFlexBasis());
            }
            if (this.getFlexShrink() <= 0) {
                this.setFlexShrink(iPSPortletParam.getFlexShrink());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getBorderLayoutPos())) {
                this.setBorderLayoutPos(iPSPortletParam.getBorderLayoutPos());
            }
            if (this.nTitleBarCloseMode == null) {
                this.setTitleBarCloseMode(iPSPortletParam.getTitleBarCloseMode());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getPSSysUniResId())) {
                this.setPSSysUniResId(iPSPortletParam.getPSSysUniResId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getPSSysImageId())) {
                this.setPSSysImageId(iPSPortletParam.getPSSysImageId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getDynaClass())) {
                this.setDynaClass(iPSPortletParam.getDynaClass());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getVAlignSelf())) {
                this.setVAlignSelf(iPSPortletParam.getVAlignSelf());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getHAlignSelf())) {
                this.setHAlignSelf(iPSPortletParam.getHAlignSelf());
            }
            if (iPSPortletParam.isEnableAnchor() != null) {
                this.setEnableAnchor(iPSPortletParam.isEnableAnchor());
            }
        }
        if (iPSControlParam instanceof IPSDBSysPortletPartParam) {
            IPSDBSysPortletPartParam sysPortletParam = (IPSDBSysPortletPartParam)iPSControlParam;
            if (!StringHelper.IsNullOrEmpty(sysPortletParam.getPSSysPortletId())) {
                this.setPSSysPortletId(sysPortletParam.getPSSysPortletId());
            }
        }
        if (iPSControlParam instanceof IPSDBAppMenuPortletPartParam) {
            IPSDBAppMenuPortletPartParam appMenuParam = (IPSDBAppMenuPortletPartParam)iPSControlParam;
            if (StringHelper.IsNullOrEmpty((String)this.getPSAppMenuId())) {
                this.setPSAppMenuId(appMenuParam.getPSAppMenuId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getAMListStyle())) {
                this.setAMListStyle(appMenuParam.getAMListStyle());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getAMPSSysPFPluginId())) {
                this.setAMPSSysPFPluginId(appMenuParam.getAMPSSysPFPluginId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getPSAppFuncPickupViewId())) {
                this.setPSAppFuncPickupViewId(appMenuParam.getPSAppFuncPickupViewId());
            }
        }
        if (iPSControlParam instanceof IPSDBContainerPortletPartParam) {
            IPSDBContainerPortletPartParam containerParam = (IPSDBContainerPortletPartParam)iPSControlParam;
            if (StringHelper.IsNullOrEmpty((String)this.getLayoutMode())) {
                this.setLayoutMode(containerParam.getLayoutMode());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getFlexDir())) {
                this.setFlexDir(containerParam.getFlexDir());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getFlexAlign())) {
                this.setFlexAlign(containerParam.getFlexAlign());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getFlexVAlign())) {
                this.setFlexVAlign(containerParam.getFlexVAlign());
            }
        }
        if (iPSControlParam instanceof IPSDBAppViewPortletPartParam) {
            IPSDBAppViewPortletPartParam appViewParam = (IPSDBAppViewPortletPartParam)iPSControlParam;
            if (StringHelper.IsNullOrEmpty((String)this.getEmbededPSAppViewId())) {
                this.setEmbededPSAppViewId(appViewParam.getEmbededPSAppViewId());
            }
        }
        if (iPSControlParam instanceof IPSDBRawItemPortletPartParam) {
            IPSDBRawItemPortletPartParam rawItemParam = (IPSDBRawItemPortletPartParam)iPSControlParam;
            if (StringHelper.IsNullOrEmpty((String)this.getContentType())) {
                this.setContentType(rawItemParam.getContentType());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getRawContent())) {
                this.setRawContent(rawItemParam.getRawContent());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getHtmlContent())) {
                this.setHtmlContent(rawItemParam.getHtmlContent());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getPSSysResourceId())) {
                this.setPSSysResourceId(rawItemParam.getPSSysResourceId());
            }
        }
    }

    @Override
    public String getPSSysPortletId() {
        return this.strPSSysPortletId;
    }

    @Override
    public int getColumnId() {
        return this.nColumnId;
    }

    public void setPSSysPortletId(String strPSSysPortletId) {
        this.strPSSysPortletId = strPSSysPortletId;
    }

    public void setColumnId(int nColumnId) {
        this.nColumnId = nColumnId;
    }

    @Override
    public String getPortletType() {
        return this.strPortletType;
    }

    public void setPortletType(String strPortletType) {
        this.strPortletType = strPortletType;
    }

    @Override
    public int getColumnSpan() {
        return this.nColumnSpan;
    }

    public void setColumnSpan(int nColumnSpan) {
        this.nColumnSpan = nColumnSpan;
    }

    @Override
    public int getColXS() {
        return this.nColXS;
    }

    @Override
    public int getColSM() {
        return this.nColSM;
    }

    @Override
    public int getColMD() {
        return this.nColMD;
    }

    @Override
    public int getColLG() {
        return this.nColLG;
    }

    @Override
    public int getColXSOffset() {
        return this.nColXSOffset;
    }

    @Override
    public int getColSMOffset() {
        return this.nColSMOffset;
    }

    @Override
    public int getColMDOffset() {
        return this.nColMDOffset;
    }

    @Override
    public int getColLGOffset() {
        return this.nColLGOffset;
    }

    public void setColXS(int nColXS) {
        this.nColXS = nColXS;
    }

    public void setColSM(int nColSM) {
        this.nColSM = nColSM;
    }

    public void setColMD(int nColMD) {
        this.nColMD = nColMD;
    }

    public void setColLG(int nColLG) {
        this.nColLG = nColLG;
    }

    public void setColXSOffset(int nColXSOffset) {
        this.nColXSOffset = nColXSOffset;
    }

    public void setColSMOffset(int nColSMOffset) {
        this.nColSMOffset = nColSMOffset;
    }

    public void setColMDOffset(int nColMDOffset) {
        this.nColMDOffset = nColMDOffset;
    }

    public void setColLGOffset(int nColLGOffset) {
        this.nColLGOffset = nColLGOffset;
    }

    @Override
    public boolean isNewRowMode() {
        return this.bNewRowMode;
    }

    public void setNewRowMode(boolean bNewRowMode) {
        this.bNewRowMode = bNewRowMode;
    }

    @Override
    public String getPSAppMenuId() {
        return this.strPSAppMenuId;
    }

    public void setPSAppMenuId(String strPSAppMenuId) {
        this.strPSAppMenuId = strPSAppMenuId;
    }

    @Override
    public String getAMPSSysPFPluginId() {
        return this.strAMPSSysPFPluginId;
    }

    @Override
    public String getAMListStyle() {
        return this.strAMListStyle;
    }

    public void setAMPSSysPFPluginId(String strAMPSSysPFPluginId) {
        this.strAMPSSysPFPluginId = strAMPSSysPFPluginId;
    }

    public void setAMListStyle(String strAMListStyle) {
        this.strAMListStyle = strAMListStyle;
    }

    @Override
    public String getTitle() {
        return this.strTitle;
    }

    public void setTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    @Override
    public String getPSAppFuncPickupViewId() {
        return this.strPSAppFuncPickupViewId;
    }

    public void setPSAppFuncPickupViewId(String strPSAppFuncPickupViewId) {
        this.strPSAppFuncPickupViewId = strPSAppFuncPickupViewId;
    }

    @Override
    public Boolean getShowTitleBar() {
        return this.bShowTitleBar;
    }

    public void setShowTitleBar(Boolean bShowTitleBar) {
        this.bShowTitleBar = bShowTitleBar;
    }

    @Override
    public String getTitlePSLanguageResId() {
        return this.strTitlePSLanguageResId;
    }

    public void setTitlePSLanguageResId(String strTitlePSLanguageResId) {
        this.strTitlePSLanguageResId = strTitlePSLanguageResId;
    }

    @Override
    public int getFlexGrow() {
        return this.nFlexGrow;
    }

    public void setFlexGrow(int nFlexGrow) {
        this.nFlexGrow = nFlexGrow;
    }

    @Override
    public int getFlexShrink() {
        return this.nFlexShrink;
    }

    public void setFlexShrink(int nFlexShrink) {
        this.nFlexShrink = nFlexShrink;
    }

    @Override
    public int getFlexBasis() {
        return this.nFlexBasis;
    }

    public void setFlexBasis(int nFlexBasis) {
        this.nFlexBasis = nFlexBasis;
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

    public void setBorderLayoutPos(String strBorderLayoutPos) {
        this.strBorderLayoutPos = strBorderLayoutPos;
    }

    @Override
    public String getBorderLayoutPos() {
        return this.strBorderLayoutPos;
    }

    @Override
    public String getLayoutMode() {
        return this.strLayoutMode;
    }

    public void setLayoutMode(String strLayoutMode) {
        this.strLayoutMode = strLayoutMode;
    }

    @Override
    public String getEmbededPSAppViewId() {
        return this.strEmbededPSAppViewId;
    }

    public void setEmbededPSAppViewId(String strEmbededPSAppViewId) {
        this.strEmbededPSAppViewId = strEmbededPSAppViewId;
    }

    @Override
    public Integer getTitleBarCloseMode() {
        return this.nTitleBarCloseMode;
    }

    public void setTitleBarCloseMode(Integer nTitleBarCloseMode) {
        this.nTitleBarCloseMode = nTitleBarCloseMode;
    }

    @Override
    public String getPSSysUniResId() {
        return this.strPSSysUniResId;
    }

    public void setPSSysUniResId(String strPSSysUniResId) {
        this.strPSSysUniResId = strPSSysUniResId;
    }

    @Override
    public String getPSSysImageId() {
        return this.strPSSysImageId;
    }

    public void setPSSysImageId(String strPSSysImageId) {
        this.strPSSysImageId = strPSSysImageId;
    }

    @Override
    public String getContentType() {
        return this.strContentType;
    }

    @Override
    public String getRawContent() {
        return this.strRawContent;
    }

    @Override
    public String getHtmlContent() {
        return this.strHtmlContent;
    }

    @Override
    public String getPSSysResourceId() {
        return this.strPSSysResourceId;
    }

    @Override
    public String getDynaClass() {
        return this.strDynaClass;
    }

    public void setContentType(String strContentType) {
        this.strContentType = strContentType;
    }

    public void setRawContent(String strRawContent) {
        this.strRawContent = strRawContent;
    }

    public void setHtmlContent(String strHtmlContent) {
        this.strHtmlContent = strHtmlContent;
    }

    public void setPSSysResourceId(String strPSSysResourceId) {
        this.strPSSysResourceId = strPSSysResourceId;
    }

    public void setDynaClass(String strDynaClass) {
        this.strDynaClass = strDynaClass;
    }

    @Override
    public String getVAlignSelf() {
        return this.strVAlignSelf;
    }

    public void setVAlignSelf(String strVAlignSelf) {
        this.strVAlignSelf = strVAlignSelf;
    }

    @Override
    public String getHAlignSelf() {
        return this.strHAlignSelf;
    }

    public void setHAlignSelf(String strHAlignSelf) {
        this.strHAlignSelf = strHAlignSelf;
    }

    @Override
    public Boolean isEnableAnchor() {
        return this.bEnableAnchor;
    }

    public void setEnableAnchor(Boolean bEnableAnchor) {
        this.bEnableAnchor = bEnableAnchor;
    }
}
