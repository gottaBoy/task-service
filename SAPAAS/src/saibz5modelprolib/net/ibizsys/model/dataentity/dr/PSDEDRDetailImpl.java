/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 *  net.ibizsys.model.dataentity.dr.IPSDEDRDetail
 *  net.ibizsys.model.dataentity.dr.IPSDEDRItem
 *  net.ibizsys.model.dataentity.dr.IPSDEDataRelation
 *  net.ibizsys.model.dataentity.priv.IPSDEOPPriv
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.model.res.IPSSysPDTView
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.dr;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.dr.IPSDEDRDetail;
import net.ibizsys.model.dataentity.dr.IPSDEDRItem;
import net.ibizsys.model.dataentity.dr.IPSDEDataRelation;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.entity.PSDEDRDetail;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.res.IPSSysPDTView;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRDetailImpl
extends PSObjectImpl
implements IPSDEDRDetail {
    private static final Log log = LogFactory.getLog(PSDEDRDetailImpl.class);
    private IPSDEDataRelation iPSDEDR = null;
    private PSDEDRDetail psDEDRDetail = null;
    protected IPSDEDRItem iPSDEDRItem = null;
    private String strCaption = "";
    private String strDetailType = "DRITEM";
    private IPSSysPDTView iPSSysPDTView = null;
    private String strCounterId = null;
    private String strEnableMode = null;
    private IPSDEAction testPSDEAction = null;
    private IPSDEOPPriv iPSDEOPPriv = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private String strPSDETreeId = null;
    private IPSSysImage iPSSysImage = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEDataRelation iPSDEDR, PSDEDRDetail psDEDRDetail) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDEDR(iPSDEDR);
            this.setPSDEDRDetailData(psDEDRDetail);
            this.setId(this.psDEDRDetail.getPSDEDRDETAILID());
            this.setName(this.psDEDRDetail.getPSDEDRDETAILNAME());
            this.setPSObjectData(this.psDEDRDetail);
            this.strCaption = psDEDRDetail.getCAPTION();
            if (!StringHelper.isNullOrEmpty((String)this.psDEDRDetail.getDETAILTYPE())) {
                this.strDetailType = this.psDEDRDetail.getDETAILTYPE();
            }
            if (StringHelper.compare((String)this.strDetailType, (String)"DRITEM", (boolean)true) == 0) {
                if (!StringHelper.isNullOrEmpty((String)this.psDEDRDetail.getPSDEDRITEMID())) {
                    this.iPSDEDRItem = iPSDEDR.getPSDataEntity().getPSDEDRItem(this.psDEDRDetail.getPSDEDRITEMID());
                }
            } else if (StringHelper.compare((String)this.strDetailType, (String)"PDTVIEW", (boolean)true) == 0 && !StringHelper.isNullOrEmpty((String)this.psDEDRDetail.getPSSYSPDTVIEWID())) {
                this.iPSSysPDTView = iPSDEDR.getPSDataEntity().getPSSystem().getPSSysPDTView(this.psDEDRDetail.getPSSYSPDTVIEWID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDRDetail.getCOUNTERID())) {
                this.strCounterId = this.psDEDRDetail.getCOUNTERID();
            } else if (this.iPSDEDRItem != null) {
                this.strCounterId = this.iPSDEDRItem.getCounterId();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDRDetail.getENABLEMODE())) {
                this.strEnableMode = this.psDEDRDetail.getENABLEMODE();
            } else if (this.iPSDEDRItem != null) {
                this.strEnableMode = this.iPSDEDRItem.getEnableMode();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDRDetail.getTESTPSDEACTIONID())) {
                this.testPSDEAction = this.iPSDEDR.getPSDataEntity().getPSDEAction(this.psDEDRDetail.getTESTPSDEACTIONID());
            } else if (this.iPSDEDRItem != null) {
                this.testPSDEAction = this.iPSDEDRItem.getTestPSDEAction();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDRDetail.getPSDEOPPRIVID())) {
                this.iPSDEOPPriv = this.iPSDEDR.getPSDataEntity().getPSSystem().getPSDEOPPriv(this.psDEDRDetail.getPSDEOPPRIVID());
            } else if (this.iPSDEDRItem != null) {
                this.iPSDEOPPriv = this.iPSDEDRItem.getTestPSDEOPPriv();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDRDetail.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.iPSDEDR.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEDRDetail.getCAPPSLANRESID());
            } else if (this.iPSDEDRItem != null) {
                this.capPSLanguageRes = this.iPSDEDRItem.getCapPSLanguageRes();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDRDetail.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.iPSDEDR.getPSDataEntity().getPSSystem().getPSSysImage(this.psDEDRDetail.getPSSYSIMAGEID());
            }
            this.strPSDETreeId = this.psDEDRDetail.getPSDETREEVIEWID();
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.strCaption;
    }

    public String getCaption(String strLanguage) {
        if (StringHelper.isNullOrEmpty((String)this.strCaption)) {
            return this.onGetCaption(strLanguage);
        }
        return this.strCaption;
    }

    protected String onGetCaption(String strLanguage) {
        if (this.iPSDEDRItem != null) {
            return this.iPSDEDRItem.getCaption(strLanguage);
        }
        if (this.iPSSysPDTView != null) {
            return this.iPSSysPDTView.getCaption(strLanguage);
        }
        return this.psDEDRDetail.getPSDEDRDETAILNAME();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u7ec4\u5bf9\u8c61")
    public IPSDEDataRelation getPSDEDR() {
        return this.iPSDEDR;
    }

    protected void setPSDEDR(IPSDEDataRelation iPSDEDR) {
        this.iPSDEDR = iPSDEDR;
    }

    public PSDEDRDetail getPSDEDRDetailData() {
        return this.psDEDRDetail;
    }

    protected void setPSDEDRDetailData(PSDEDRDetail psDEDRDetail) {
        this.psDEDRDetail = psDEDRDetail;
    }

    public String getPSDEDRGroupId() {
        return this.getPSDEDRDetailData().getPSDEDRGROUPID();
    }

    public String getPSDEViewId() {
        if (this.iPSDEDRItem != null) {
            return this.iPSDEDRItem.getPSDEViewId();
        }
        if (this.getPSSysPDTView() != null) {
            return this.getPSSysPDTView().getPSDEViewBaseId();
        }
        return "";
    }

    public String getPSDEDRItemId() {
        return this.psDEDRDetail.getPSDEDRITEMID();
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u5173\u7cfb\u89c6\u56fe\u9879")
    public IPSDEDRItem getPSDEDRItem() {
        return this.iPSDEDRItem;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSDEDR);
    }

    @PSModelRTMeta(description="\u6210\u5458\u7c7b\u578b", codelist="DEDRDetailType")
    public String getDetailType() {
        return this.strDetailType;
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe", hideempty=true)
    public IPSSysPDTView getPSSysPDTView() {
        return this.iPSSysPDTView;
    }

    @PSModelRTMeta(description="\u6210\u5458\u56fe\u6807\u8d44\u6e90\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        if (this.iPSSysImage != null) {
            return this.iPSSysImage;
        }
        if (this.iPSDEDRItem != null) {
            return this.iPSDEDRItem.getPSSysImage();
        }
        return null;
    }

    @PSModelRTMeta(description="\u542f\u7528\u6a21\u5f0f", codelist="DEDRDetailEnableMode")
    public String getEnableMode() {
        return this.strEnableMode;
    }

    @PSModelRTMeta(description="\u8ba1\u6570\u9879\u6807\u8bc6")
    public String getCounterId() {
        return this.strCounterId;
    }

    @PSModelRTMeta(description="\u5224\u65ad\u8f93\u51fa\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getTestPSDEAction() {
        return this.testPSDEAction;
    }

    @PSModelRTMeta(description="\u5224\u65ad\u8f93\u51fa\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6")
    public IPSDEOPPriv getTestPSDEOPPriv() {
        return this.iPSDEOPPriv;
    }

    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }
}

