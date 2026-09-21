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
package SA.SRFDA.PS.Core.CodeList;

import SA.SRFDA.PS.Core.CodeList.IPSThreshold;
import SA.SRFDA.PS.Core.CodeList.IPSThresholdGroup;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Data.PSThreshold;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSThresholdImpl
extends PSObjectImpl
implements IPSThreshold {
    private static final Log log = LogFactory.getLog(PSThresholdImpl.class);
    private IPSThresholdGroup iPSThresholdGroup = null;
    private PSThreshold psThreshold = null;
    protected String strCodeName = "";
    private IPSSysCss iPSSysCss = null;
    private IPSSysImage iPSSysImage = null;
    private String strColor = null;
    private String strBKColor = null;
    private IPSLanguageRes textPSLanguageRes = null;
    private String strData = null;
    private String strTooltip = null;
    private IPSLanguageRes tooltipPSLanguageRes = null;
    private Double fBeginValue = null;
    private Double fEndValue = null;
    private boolean bIncludeBeginValue = true;
    private boolean bIncludeEndValue = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSThresholdGroup iPSThresholdGroup, PSThreshold psThreshold) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSThresholdGroup(iPSThresholdGroup);
            this.psThreshold = psThreshold;
            this.setId(this.psThreshold.getPSTHRESHOLDID());
            this.setName(this.psThreshold.getPSTHRESHOLDNAME());
            this.setPSObjectData(this.psThreshold);
            this.strCodeName = this.psThreshold.getCODENAME();
            if (!this.psThreshold.isBEGINVALUENull()) {
                this.fBeginValue = this.psThreshold.getBEGINVALUE();
            }
            if (!this.psThreshold.isENDVALUENull()) {
                this.fEndValue = this.psThreshold.getENDVALUE();
            }
            if (!this.psThreshold.isINCBEGINVALUENull()) {
                this.bIncludeBeginValue = this.psThreshold.getINCBEGINVALUE();
            }
            if (!this.psThreshold.isINCENDVALUENull()) {
                this.bIncludeEndValue = this.psThreshold.getINCENDVALUE();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psThreshold.getCOLOR())) {
                this.strColor = this.psThreshold.getCOLOR();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psThreshold.getBKCOLOR())) {
                this.strBKColor = this.psThreshold.getBKCOLOR();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psThreshold.getPSSYSCSSID())) {
                this.iPSSysCss = this.iPSThresholdGroup.getPSSystem().getPSSysCss(this.psThreshold.getPSSYSCSSID());
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psThreshold.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.iPSThresholdGroup.getPSSystem().getPSSysImage(this.psThreshold.getPSSYSIMAGEID());
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psThreshold.getTEXTPSLANRESID())) {
                this.textPSLanguageRes = this.iPSThresholdGroup.getPSSystem().getPSLanguageRes(this.psThreshold.getTEXTPSLANRESID());
            }
            this.strData = this.psThreshold.getDATA();
            this.strTooltip = this.psThreshold.getTOOLTIPINFO();
            if (!StringHelper.IsNullOrEmpty((String)this.psThreshold.getTIPPSLANRESID())) {
                this.tooltipPSLanguageRes = this.iPSThresholdGroup.getPSSystem().getPSLanguageRes(this.psThreshold.getTIPPSLANRESID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
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
    public String getName() {
        return super.getName();
    }

    public IPSThresholdGroup getPSThresholdGroup() {
        return this.iPSThresholdGroup;
    }

    protected void setPSThresholdGroup(IPSThresholdGroup iPSThresholdGroup) {
        this.iPSThresholdGroup = iPSThresholdGroup;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c")
    public String getText() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u989c\u8272", hideempty2=true)
    public String getColor() {
        return this.strColor;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSThresholdGroup.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6837\u5f0f")
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getTextPSLanguageRes() {
        return this.textPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e", hideempty=true)
    public String getData() {
        return this.strData;
    }

    @Override
    public String getTextLanResTag() {
        if (this.getTextPSLanguageRes() != null) {
            return this.getTextPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    public String getModelType() {
        return "PSTHRESHOLD";
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSThresholdGroup().getModelId(), (Object)this.getId());
    }

    @Override
    public String getFullModelName() {
        return net.ibizsys.paas.util.StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSThresholdGroup().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSThresholdGroup().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90", hideempty=true)
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return this.tooltipPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u4fe1\u606f", hideempty2=true)
    public String getTooltip() {
        return this.strTooltip;
    }

    @Override
    @PSModelRTMeta(description="\u80cc\u666f\u989c\u8272", hideempty2=true)
    public String getBKColor() {
        return this.strBKColor;
    }

    @Override
    @PSModelRTMeta(description="\u9608\u503c\u9879\u6807\u8bb0", hideempty2=true)
    public String getThresholdTag() {
        return this.psThreshold.getTHRESHOLDTAG();
    }

    @Override
    @PSModelRTMeta(description="\u9608\u503c\u9879\u6807\u8bb02", hideempty2=true)
    public String getThresholdTag2() {
        return this.psThreshold.getTHRESHOLDTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5f00\u59cb\u503c")
    public Double getBeginValue() {
        return this.fBeginValue;
    }

    @Override
    @PSModelRTMeta(description="\u7ed3\u675f\u503c")
    public Double getEndValue() {
        return this.fEndValue;
    }

    @Override
    @PSModelRTMeta(description="\u5305\u542b\u5f00\u59cb\u503c", ignoredumpvalues="false")
    public boolean isIncludeBeginValue() {
        return this.bIncludeBeginValue;
    }

    @Override
    @PSModelRTMeta(description="\u5305\u542b\u7ed3\u675f\u503c", ignoredumpvalues="false")
    public boolean isIncludeEndValue() {
        return this.bIncludeEndValue;
    }
}

