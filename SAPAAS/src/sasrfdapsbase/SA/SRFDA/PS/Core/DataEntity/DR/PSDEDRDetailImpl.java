/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDetail;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRGroup;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDataRelation;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPDTView;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Data.PSDEDRDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
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
    private int nCounterMode = 0;
    private String strEnableMode = null;
    private IPSDEAction testPSDEAction = null;
    private IPSDEOPPriv iPSDEOPPriv = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private String strPSDETreeId = null;
    private IPSSysImage iPSSysImage = null;
    private IPSDEDRGroup iPSDEDRGroup = null;
    private String strPSDEDRGroupId = null;
    private int nOrderValue = 99999;
    private IPSDELogic testPSDELogic = null;
    private IPSSysUniRes testPSSysUniRes = null;
    private String strTestScriptCode = null;
    private IPSSysPFPlugin headerPSSysPFPlugin = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataRelation iPSDEDR, PSDEDRDetail psDEDRDetail) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEDR(iPSDEDR);
            this.setPSDEDRDetailData(psDEDRDetail);
            this.setId(this.psDEDRDetail.getPSDEDRDETAILID());
            this.setName(this.psDEDRDetail.getPSDEDRDETAILNAME());
            this.setPSObjectData(this.psDEDRDetail);
            this.strCaption = psDEDRDetail.getCAPTION();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRDetail.getDETAILTYPE())) {
                this.strDetailType = this.psDEDRDetail.getDETAILTYPE();
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strDetailType, (String)"DRITEM", (boolean)true) == 0) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRDetail.getPSDEDRITEMID())) {
                    this.iPSDEDRItem = iPSDEDR.getPSDataEntity().getPSDEDRItem(this.psDEDRDetail.getPSDEDRITEMID());
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getMemo())) {
                        this.setMemo(this.iPSDEDRItem.getMemo());
                    }
                }
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strDetailType, (String)"PDTVIEW", (boolean)true) == 0 && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRDetail.getPSSYSPDTVIEWID())) {
                this.iPSSysPDTView = iPSDEDR.getPSDataEntity().getPSSystem().getPSSysPDTView(this.psDEDRDetail.getPSSYSPDTVIEWID());
            }
            this.strPSDEDRGroupId = this.psDEDRDetail.getPSDEDRGROUPID();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDEDRGroupId()) && this.iPSDEDRItem != null) {
                this.strPSDEDRGroupId = this.iPSDEDRItem.getPSDEDRGroupId();
                if (this.strPSDEDRGroupId == null) {
                    this.strPSDEDRGroupId = "";
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDEDRGroupId())) {
                this.iPSDEDRGroup = this.iPSDEDR.getPSDataEntity().getPSDEDRGroup(this.getPSDEDRGroupId());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRDetail.getCOUNTERID())) {
                this.strCounterId = this.psDEDRDetail.getCOUNTERID();
            } else if (this.iPSDEDRItem != null) {
                this.strCounterId = this.iPSDEDRItem.getCounterId();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCounterId)) {
                if (!this.psDEDRDetail.isCOUNTERMODENull() && this.psDEDRDetail.getCOUNTERMODE() >= 0) {
                    this.nCounterMode = this.psDEDRDetail.getCOUNTERMODE();
                } else if (this.iPSDEDRItem != null) {
                    this.nCounterMode = this.iPSDEDRItem.getCounterMode();
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRDetail.getENABLEMODE())) {
                this.strEnableMode = this.psDEDRDetail.getENABLEMODE();
            } else if (this.iPSDEDRItem != null) {
                this.strEnableMode = this.iPSDEDRItem.getEnableMode();
            }
            if ("CUSTOM".equals(this.getEnableMode())) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRDetail.getTESTPSDEACTIONID())) {
                    this.testPSDEAction = this.iPSDEDR.getPSDataEntity().getPSDEAction(this.psDEDRDetail.getTESTPSDEACTIONID());
                } else if (this.iPSDEDRItem != null) {
                    this.testPSDEAction = this.iPSDEDRItem.getTestPSDEAction();
                }
                if (this.testPSDEAction == null) {
                    throw new Exception("\u672a\u6307\u5b9a\u542f\u7528\u5224\u65ad\u884c\u4e3a");
                }
            } else if ("DEOPPRIV".equals(this.getEnableMode())) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRDetail.getPSDEOPPRIVID())) {
                    this.iPSDEOPPriv = this.iPSDEDR.getPSDataEntity().getPSSystem().getPSDEOPPriv(this.psDEDRDetail.getPSDEOPPRIVID());
                } else if (this.iPSDEDRItem != null) {
                    this.iPSDEOPPriv = this.iPSDEDRItem.getTestPSDEOPPriv();
                }
                if (this.iPSDEOPPriv == null) {
                    throw new Exception("\u672a\u6307\u5b9a\u542f\u7528\u5224\u65ad\u64cd\u4f5c\u6807\u8bc6");
                }
            } else if ("DELOGIC".equals(this.getEnableMode())) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRDetail.getTESTPSDELOGICID())) {
                    this.testPSDELogic = this.iPSDEDR.getPSDataEntity().getPSDELogic(this.psDEDRDetail.getTESTPSDELOGICID());
                } else if (this.iPSDEDRItem != null) {
                    this.testPSDELogic = this.iPSDEDRItem.getTestPSDELogic();
                }
                if (this.testPSDELogic == null) {
                    throw new Exception("\u672a\u6307\u5b9a\u542f\u7528\u5224\u65ad\u903b\u8f91");
                }
            } else if ("SCRIPT".equals(this.getEnableMode())) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRDetail.getTESTCUSTOMCODE())) {
                    this.strTestScriptCode = this.psDEDRDetail.getTESTCUSTOMCODE();
                } else if (this.iPSDEDRItem != null) {
                    this.strTestScriptCode = this.iPSDEDRItem.getTestScriptCode();
                }
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strTestScriptCode)) {
                    throw new Exception("\u672a\u6307\u5b9a\u542f\u7528\u5224\u65ad\u811a\u672c");
                }
            } else if ("UNIRES".equals(this.getEnableMode())) {
                this.testPSSysUniRes = this.iPSDEDRItem.getTestPSSysUniRes();
                if (this.testPSSysUniRes == null) {
                    throw new Exception("\u672a\u6307\u5b9a\u542f\u7528\u7edf\u4e00\u8d44\u6e90");
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRDetail.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.iPSDEDR.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEDRDetail.getCAPPSLANRESID());
            } else if (this.iPSDEDRItem != null) {
                this.capPSLanguageRes = this.iPSDEDRItem.getCapPSLanguageRes();
            } else if (this.iPSSysPDTView != null) {
                this.capPSLanguageRes = this.iPSSysPDTView.getCapPSLanguageRes();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRDetail.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.iPSDEDR.getPSDataEntity().getPSSystem().getPSSysImage(this.psDEDRDetail.getPSSYSIMAGEID());
            }
            if (!this.psDEDRDetail.isORDERVALUENull() && this.psDEDRDetail.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psDEDRDetail.getORDERVALUE();
            }
            this.strPSDETreeId = this.psDEDRDetail.getPSDETREEVIEWID();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRDetail.getHEADERPSSYSPFPLUGINID())) {
                this.headerPSSysPFPlugin = this.iPSDEDR.getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEDRDetail.getHEADERPSSYSPFPLUGINID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u539f\u59cb\u6807\u9898", fields={"CAPTION"})
    public String getOriginCaption() {
        return this.strCaption;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"CAPTION"})
    public String getCaption() {
        return this.getCaption("");
    }

    @Override
    public String getCaption(String strLanguage) {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCaption)) {
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

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u7ec4")
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

    @Override
    public String getPSDEDRGroupId() {
        return this.strPSDEDRGroupId;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u5206\u7ec4")
    public IPSDEDRGroup getPSDEDRGroup() {
        return this.iPSDEDRGroup;
    }

    @Override
    public String getPSDEViewId() {
        if (this.iPSDEDRItem != null) {
            return this.iPSDEDRItem.getPSDEViewId();
        }
        if (this.getPSSysPDTView() != null) {
            return this.getPSSysPDTView().getPSDEViewBaseId();
        }
        return "";
    }

    @Override
    public String getPSDEDRItemId() {
        return this.psDEDRDetail.getPSDEDRITEMID();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u754c\u9762\u9879", ignorepf=true, dumpref=true, from="IPSDataEntity", fields={"PSDEDRITEMID"})
    public IPSDEDRItem getPSDEDRItem() {
        return this.iPSDEDRItem;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDR.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u7c7b\u578b", codelist="DEDRDetailType", fields={"DETAILTYPE"})
    public String getDetailType() {
        return this.strDetailType;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe", hideempty=true)
    public IPSSysPDTView getPSSysPDTView() {
        return this.iPSSysPDTView;
    }

    @Override
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

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6a21\u5f0f", codelist="DEDRDetailEnableMode", fields={"ENABLEMODE"})
    public String getEnableMode() {
        return this.strEnableMode;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u9879\u6807\u8bc6", fields={"COUNTERID"})
    public String getCounterId() {
        return this.strCounterId;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6a21\u5f0f", codelist="DETreeNodeCounterMode", ignoredumpvalues="0", fields={"COUNTERMODE"})
    public int getCounterMode() {
        return this.nCounterMode;
    }

    @Override
    @PSModelRTMeta(description="\u5224\u65ad\u8f93\u51fa\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getTestPSDEAction() {
        return this.testPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5224\u65ad\u8f93\u51fa\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6", ignorepf=true, fields={"PSDEOPPRIVID"})
    public IPSDEOPPriv getTestPSDEOPPriv() {
        return this.iPSDEOPPriv;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5c55\u5f00\u6811\u89c6\u56fe\u6807\u8bc6", dump=false)
    public String getPSDETreeId() {
        return this.strPSDETreeId;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDR().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEDR().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEDR().getModelId(), (Object)this.getId());
    }

    @Override
    public String getModelType() {
        return "PSDEDRDETAIL";
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", fields={"ORDERVALUE"}, ignoredumpvalues="99999")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u5904\u7406\u903b\u8f91", dumpref=true, ignorepf=true, fields={"TESTPSDELOGICID"}, from="IPSDataEntity")
    public IPSDELogic getTestPSDELogic() {
        return this.testPSDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7edf\u4e00\u8d44\u6e90", fields={"PSSYSUNIRESID"})
    public IPSSysUniRes getTestPSSysUniRes() {
        return this.testPSSysUniRes;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u811a\u672c", fields={"TESTCUSTOMCODE"})
    public String getTestScriptCode() {
        return this.strTestScriptCode;
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6807\u8bb0", fields={"DETAILTAG"})
    public String getDetailTag() {
        return this.psDEDRDetail.getDETAILTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6807\u8bb02", fields={"DETAILTAG2"})
    public String getDetailTag2() {
        return this.psDEDRDetail.getDETAILTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6570\u636e", fields={"DATA"})
    public String getData() {
        return this.psDEDRDetail.getDATA();
    }

    @Override
    @PSModelRTMeta(description="\u5934\u90e8\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getHeaderPSSysPFPlugin() {
        if (this.headerPSSysPFPlugin != null) {
            return this.headerPSSysPFPlugin;
        }
        if (this.iPSDEDRItem != null) {
            return this.iPSDEDRItem.getHeaderPSSysPFPlugin();
        }
        return null;
    }
}

