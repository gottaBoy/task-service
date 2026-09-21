/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.drctrl.IPSDEDRBarParam
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.drctrl.IPSDEDRBarParam;
import net.ibizsys.model.control.drctrl.PSDEDRCtrlParamImpl;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRBarParamImpl
extends PSDEDRCtrlParamImpl
implements IPSDEDRBarParam {
    private static final Log log = LogFactory.getLog(PSDEDRBarParamImpl.class);
    private String strPSSysCounterId = "";
    private String strTitle = "";
    private String strTitlePSLanguageResId = "";
    private Boolean bShowTitle = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strPSSysCounterId = this.psDEViewCtrl.getPSSYSCOUNTERID();
        this.strTitle = this.psDEViewCtrl.getCAPTION();
        this.strTitlePSLanguageResId = this.psDEViewCtrl.getCAPPSLANRESID();
        if (!this.psDEViewCtrl.isCTRLPARAM11Null()) {
            this.bShowTitle = this.psDEViewCtrl.getCTRLPARAM11() == 1;
        }
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEDRBarParam) {
            IPSDEDRBarParam iPSDEDRBarParam = (IPSDEDRBarParam)iPSControlParam;
            if (StringHelper.isNullOrEmpty((String)this.getPSSysCounterId())) {
                this.setPSSysCounterId(iPSDEDRBarParam.getPSSysCounterId());
            }
            if (StringHelper.isNullOrEmpty((String)this.getTitle())) {
                this.setTitle(iPSDEDRBarParam.getTitle());
            }
            if (StringHelper.isNullOrEmpty((String)this.getTitlePSLanguageResId())) {
                this.setTitlePSLanguageResId(iPSDEDRBarParam.getTitlePSLanguageResId());
            }
            if (this.isShowTitle() == null) {
                this.setShowTitle(iPSDEDRBarParam.isShowTitle());
            }
        }
    }

    @Override
    public String getPSSysCounterId() {
        return this.strPSSysCounterId;
    }

    @Override
    protected void setPSSysCounterId(String strPSSysCounterId) {
        this.strPSSysCounterId = strPSSysCounterId;
    }

    public String getTitle() {
        return this.strTitle;
    }

    protected void setTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    public String getTitlePSLanguageResId() {
        return this.strTitlePSLanguageResId;
    }

    protected void setTitlePSLanguageResId(String strTitlePSLanguageResId) {
        this.strTitlePSLanguageResId = strTitlePSLanguageResId;
    }

    public Boolean isShowTitle() {
        return this.bShowTitle;
    }

    protected void setShowTitle(Boolean bShowTitle) {
        this.bShowTitle = bShowTitle;
    }
}

