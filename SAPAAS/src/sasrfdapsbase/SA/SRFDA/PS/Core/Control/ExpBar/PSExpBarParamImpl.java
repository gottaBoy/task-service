/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSExpBarParam;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlParamImpl;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelRTIgnoreMeta
public class PSExpBarParamImpl
extends PSMDAjaxControlParamImpl
implements IPSExpBarParam {
    private static final Log log = LogFactory.getLog(PSExpBarParamImpl.class);
    private String strPSSysCounterId = "";
    private String strTitle = "";
    private String strTitlePSLanguageResId = "";
    private Boolean bEnableCounter = null;
    private Boolean bEnableSearch = null;
    private Boolean bShowTitleBar = null;
    private String strPSDEToolbarId = "";
    private String strPSSysImageId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strPSSysCounterId = this.psDEViewCtrl.getPSSYSCOUNTERID();
        this.strPSSysImageId = this.psDEViewCtrl.getPSSYSIMAGEID();
        this.strTitle = this.psDEViewCtrl.getCAPTION();
        this.strTitlePSLanguageResId = this.psDEViewCtrl.getCAPPSLANRESID();
        if (!this.psDEViewCtrl.isCTRLPARAM8Null()) {
            this.bEnableCounter = this.psDEViewCtrl.getCTRLPARAM8() == 1;
        }
        if (!this.psDEViewCtrl.isCTRLPARAM7Null()) {
            this.bEnableSearch = this.psDEViewCtrl.getCTRLPARAM7() == 1;
        }
        if (!this.psDEViewCtrl.isCTRLPARAM11Null()) {
            this.bShowTitleBar = this.psDEViewCtrl.getCTRLPARAM11() == 1;
        }
        this.strPSDEToolbarId = this.psDEViewCtrl.getPSDETOOLBARID();
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSExpBarParam) {
            IPSExpBarParam iPSExpBarParam = (IPSExpBarParam)iPSControlParam;
            if (!StringHelper.isNullOrEmpty((String)iPSExpBarParam.getPSSysCounterId())) {
                this.setPSSysCounterId(iPSExpBarParam.getPSSysCounterId());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSExpBarParam.getPSSysImageId())) {
                this.setPSSysImageId(iPSExpBarParam.getPSSysImageId());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSExpBarParam.getTitle())) {
                this.setTitle(iPSExpBarParam.getTitle());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSExpBarParam.getTitlePSLanguageResId())) {
                this.setTitlePSLanguageResId(iPSExpBarParam.getTitlePSLanguageResId());
            }
            if (iPSExpBarParam.getEnableCounter() != null) {
                this.setEnableCounter(iPSExpBarParam.getEnableCounter());
            }
            if (iPSExpBarParam.getEnableSearch() != null) {
                this.setEnableSearch(iPSExpBarParam.getEnableSearch());
            }
            if (iPSExpBarParam.getShowTitleBar() != null) {
                this.setShowTitleBar(iPSExpBarParam.getShowTitleBar());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSExpBarParam.getPSDEToolbarId())) {
                this.setPSDEToolbarId(iPSExpBarParam.getPSDEToolbarId());
            }
        }
    }

    @Override
    public String getPSSysCounterId() {
        return this.strPSSysCounterId;
    }

    protected void setPSSysCounterId(String strPSSysCounterId) {
        this.strPSSysCounterId = strPSSysCounterId;
    }

    @Override
    public String getPSSysImageId() {
        return this.strPSSysImageId;
    }

    protected void setPSSysImageId(String strPSSysImageId) {
        this.strPSSysImageId = strPSSysImageId;
    }

    @Override
    public String getTitle() {
        return this.strTitle;
    }

    protected void setTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    @Override
    public String getTitlePSLanguageResId() {
        return this.strTitlePSLanguageResId;
    }

    protected void setTitlePSLanguageResId(String strTitlePSLanguageResId) {
        this.strTitlePSLanguageResId = strTitlePSLanguageResId;
    }

    @Override
    public Boolean getEnableCounter() {
        return this.bEnableCounter;
    }

    public void setEnableCounter(Boolean bEnableCounter) {
        this.bEnableCounter = bEnableCounter;
    }

    @Override
    public Boolean getEnableSearch() {
        return this.bEnableSearch;
    }

    public void setEnableSearch(Boolean bEnableSearch) {
        this.bEnableSearch = bEnableSearch;
    }

    @Override
    public Boolean getShowTitleBar() {
        return this.bShowTitleBar;
    }

    public void setShowTitleBar(Boolean bShowTitleBar) {
        this.bShowTitleBar = bShowTitleBar;
    }

    @Override
    public String getPSDEToolbarId() {
        return this.strPSDEToolbarId;
    }

    public void setPSDEToolbarId(String strPSDEToolbarId) {
        this.strPSDEToolbarId = strPSDEToolbarId;
    }
}

