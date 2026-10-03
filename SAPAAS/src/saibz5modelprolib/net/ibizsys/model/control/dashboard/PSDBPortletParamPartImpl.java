/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.dashboard.IPSDBAppMenuPortletPartParam
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPartParam
 *  net.ibizsys.model.control.dashboard.IPSDBSysPortletPartParam
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSMDAjaxControlParamImpl;
import net.ibizsys.model.control.dashboard.IPSDBAppMenuPortletPartParam;
import net.ibizsys.model.control.dashboard.IPSDBPortletPartParam;
import net.ibizsys.model.control.dashboard.IPSDBSysPortletPartParam;
import net.ibizsys.paas.util.StringHelper;

public class PSDBPortletParamPartImpl
extends PSMDAjaxControlParamImpl
implements IPSDBPortletPartParam,
IPSDBAppMenuPortletPartParam,
IPSDBSysPortletPartParam {
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
            if (!StringHelper.isNullOrEmpty((String)iPSPortletParam.getTitle())) {
                this.setTitle(iPSPortletParam.getTitle());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSPortletParam.getTitlePSLanguageResId())) {
                this.setTitlePSLanguageResId(iPSPortletParam.getTitlePSLanguageResId());
            }
        }
        if (iPSControlParam instanceof IPSDBSysPortletPartParam) {
            IPSDBSysPortletPartParam sysPortletParam = (IPSDBSysPortletPartParam)iPSControlParam;
            if (!StringHelper.isNullOrEmpty((String)sysPortletParam.getPSSysPortletId())) {
                this.setPSSysPortletId(sysPortletParam.getPSSysPortletId());
            }
        }
        if (iPSControlParam instanceof IPSDBAppMenuPortletPartParam) {
            IPSDBAppMenuPortletPartParam appMenuPortletParam = (IPSDBAppMenuPortletPartParam)iPSControlParam;
            if (StringHelper.isNullOrEmpty((String)this.getPSAppMenuId())) {
                this.setPSAppMenuId(appMenuPortletParam.getPSAppMenuId());
            }
            if (StringHelper.isNullOrEmpty((String)this.getAMListStyle())) {
                this.setAMListStyle(appMenuPortletParam.getAMListStyle());
            }
            if (StringHelper.isNullOrEmpty((String)this.getAMPSSysPFPluginId())) {
                this.setAMPSSysPFPluginId(appMenuPortletParam.getAMPSSysPFPluginId());
            }
        }
    }

    public String getPSSysPortletId() {
        return this.strPSSysPortletId;
    }

    public int getColumnId() {
        return this.nColumnId;
    }

    public void setPSSysPortletId(String strPSSysPortletId) {
        this.strPSSysPortletId = strPSSysPortletId;
    }

    public void setColumnId(int nColumnId) {
        this.nColumnId = nColumnId;
    }

    public String getPortletType() {
        return this.strPortletType;
    }

    public void setPortletType(String strPortletType) {
        this.strPortletType = strPortletType;
    }

    public int getColumnSpan() {
        return this.nColumnSpan;
    }

    public void setColumnSpan(int nColumnSpan) {
        this.nColumnSpan = nColumnSpan;
    }

    public int getColXS() {
        return this.nColXS;
    }

    public int getColSM() {
        return this.nColSM;
    }

    public int getColMD() {
        return this.nColMD;
    }

    public int getColLG() {
        return this.nColLG;
    }

    public int getColXSOffset() {
        return this.nColXSOffset;
    }

    public int getColSMOffset() {
        return this.nColSMOffset;
    }

    public int getColMDOffset() {
        return this.nColMDOffset;
    }

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

    public boolean isNewRowMode() {
        return this.bNewRowMode;
    }

    public void setNewRowMode(boolean bNewRowMode) {
        this.bNewRowMode = bNewRowMode;
    }

    public String getPSAppMenuId() {
        return this.strPSAppMenuId;
    }

    public void setPSAppMenuId(String strPSAppMenuId) {
        this.strPSAppMenuId = strPSAppMenuId;
    }

    public String getAMPSSysPFPluginId() {
        return this.strAMPSSysPFPluginId;
    }

    public String getAMListStyle() {
        return this.strAMListStyle;
    }

    public void setAMPSSysPFPluginId(String strAMPSSysPFPluginId) {
        this.strAMPSSysPFPluginId = strAMPSSysPFPluginId;
    }

    public void setAMListStyle(String strAMListStyle) {
        this.strAMListStyle = strAMListStyle;
    }

    public String getTitle() {
        return this.strTitle;
    }

    public void setTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    public String getTitlePSLanguageResId() {
        return this.strTitlePSLanguageResId;
    }

    public void setTitlePSLanguageResId(String strTitlePSLanguageResId) {
        this.strTitlePSLanguageResId = strTitlePSLanguageResId;
    }

    public Boolean getShowTitleBar() {
        return this.bShowTitleBar;
    }

    public void setShowTitleBar(Boolean bShowTitleBar) {
        this.bShowTitleBar = bShowTitleBar;
    }
}
