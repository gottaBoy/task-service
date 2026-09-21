/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSPortletType;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPortlet;
import SA.SRFDA.PS.Core.Res.IPSSysPortletCat;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysPortlet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSysPortletImpl
extends PSSystemObjectImpl
implements IPSSysPortlet {
    private static final Log log = LogFactory.getLog(PSSysPortletImpl.class);
    protected PSSysPortlet psSysPortlet = null;
    private int nReloadTimer = 0;
    private boolean bShowTitleBar = true;
    private IPSSysPFPlugin titlePSSysPFPlugin = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private Properties baseClassParams = null;
    private IPSPortletType iPSPortletType = null;
    private int nHeight = 300;
    private IPSLanguageRes titlePSLanguageRes = null;
    private String strEmptyText = null;
    private IPSLanguageRes emptyTextPSLanguageRes = null;
    private String strPSACHandlerId = null;
    private IPSSysUniRes iPSSysUniRes = null;
    private IPSSystemModule iPSSystemModule = null;
    private IPSSysPortletCat iPSSysPortletCat = null;
    private int nDashboardScope = 3;
    private String strActionGroupExtractMode = "ITEM";
    private String strPortletStyle = "DEFAULT";
    private IPSDataEntity iPSDataEntity = null;
    private String strTemplEngine = "DEFAULT";
    private IPSSysImage iPSSysImage = null;
    private IPSSysCss iPSSysCss = null;
    private Properties portletParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysPortlet psSysPortlet) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysPortlet = psSysPortlet;
            this.setId(this.psSysPortlet.getPSSYSPORTLETID());
            this.setName(this.psSysPortlet.getPSSYSPORTLETNAME());
            this.iPSPortletType = this.getPSModelStorage().getPSPortletType(this.getPortletType());
            this.setPSObjectData(this.psSysPortlet);
            if (this.getPSDataEntity() == null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPortlet.getPSDEID())) {
                this.setPSDataEntity(this.getPSSystem().getPSDataEntity2(this.psSysPortlet.getPSDEID()));
            }
            if (this.psSysPortlet.getRELOADTIMER() > 0) {
                this.nReloadTimer = this.psSysPortlet.getRELOADTIMER();
            }
            if (!this.psSysPortlet.isSHOWTITLEBARNull()) {
                this.bShowTitleBar = this.psSysPortlet.getSHOWTITLEBAR();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPortlet.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysPortlet.getPSMODULEID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPortlet.getPSSYSPORTLETCATID())) {
                this.iPSSysPortletCat = this.getPSSystem().getPSSysPortletCat(this.psSysPortlet.getPSSYSPORTLETCATID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPortlet.getPSSYSPFPLUGINID())) {
                this.iPSSysPFPlugin = this.getPSSystem().getPSSysPFPlugin(this.psSysPortlet.getPSSYSPFPLUGINID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPortlet.getTITLEPSSYSPFPLUGINID())) {
                this.titlePSSysPFPlugin = this.getPSSystem().getPSSysPFPlugin(this.psSysPortlet.getTITLEPSSYSPFPLUGINID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPortlet.getTITLEPSLANRESID())) {
                this.titlePSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psSysPortlet.getTITLEPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPortlet.getPSSYSUNIRESID())) {
                this.iPSSysUniRes = this.getPSSystem().getPSSysUniRes(this.psSysPortlet.getPSSYSUNIRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPortlet.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSSystem().getPSSysImage(this.psSysPortlet.getPSSYSIMAGEID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPortlet.getPSSYSCSSID())) {
                this.iPSSysCss = this.getPSSystem().getPSSysCss(this.psSysPortlet.getPSSYSCSSID());
            }
            if (!this.psSysPortlet.isHEIGHTNull()) {
                this.nHeight = this.psSysPortlet.getHEIGHT();
                if (this.nHeight <= 0) {
                    this.nHeight = 0;
                }
            }
            this.strEmptyText = this.psSysPortlet.getEMPTYTEXT();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPortlet.getEMPTYTEXTPSLANRESID())) {
                this.emptyTextPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psSysPortlet.getEMPTYTEXTPSLANRESID());
            }
            if (!this.psSysPortlet.isDASHBOARDSCOPENull()) {
                this.nDashboardScope = this.psSysPortlet.getDASHBOARDSCOPE();
            } else if (this.getPSDataEntity() == null) {
                this.nDashboardScope = 1;
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPortlet.getPORTLETSTYLE())) {
                this.strPortletStyle = this.psSysPortlet.getPORTLETSTYLE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPortlet.getTEMPLENGINE())) {
                this.strTemplEngine = this.psSysPortlet.getTEMPLENGINE();
            } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDEUIActionGroupId())) {
                this.strTemplEngine = "V2";
            }
            this.strPSACHandlerId = this.psSysPortlet.getPSACHANDLERID();
            this.baseClassParams = PropertiesHelper.Load((String)this.psSysPortlet.getBASECLSPARAMS());
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPortlet.getGROUPEXTRACTMODE())) {
                this.strActionGroupExtractMode = this.psSysPortlet.getGROUPEXTRACTMODE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysPortlet.getPORTLETPARAMS())) {
                this.portletParams = PropertiesHelper.Load((String)this.psSysPortlet.getPORTLETPARAMS());
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
    @PSModelRTMeta(description="\u90e8\u4ef6\u7c7b\u578b", codelist="PortletType", fields={"PORTLETTYPE"})
    public String getPortletType() {
        return this.psSysPortlet.getPORTLETTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.psSysPortlet.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934", fields={"LOGICNAME"})
    public String getTitle() {
        return this.psSysPortlet.getLOGICNAME();
    }

    @Override
    public IPSLanguageRes getTitlePSIpsLanguageRes() {
        return this.getTitlePSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u5237\u65b0\u95f4\u9694\uff08\u6beb\u79d2\uff09", fields={"RELOADTIMER"})
    public int getReloadTimer() {
        return this.nReloadTimer;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u62ac\u5934\u680f", fields={"SHOWTITLEBAR"})
    public boolean isShowTitleBar() {
        return this.bShowTitleBar;
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u7ed8\u5236\u5e94\u7528\u63d2\u4ef6")
    public IPSSysPFPlugin getTitlePSSysPFPlugin() {
        return this.titlePSSysPFPlugin;
    }

    @Override
    public String getBaseClass(String strPSSFStyleId) throws Exception {
        String strBaseClass = PropertiesHelper.GetProperty((Properties)this.baseClassParams, (String)strPSSFStyleId);
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strBaseClass)) {
            return strBaseClass;
        }
        return this.iPSPortletType.getBaseClass(strPSSFStyleId);
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6", fields={"HEIGHT"})
    public int getHeight() {
        return this.nHeight;
    }

    @Override
    public IPSPortletType getPSPortletType() {
        return this.iPSPortletType;
    }

    @Override
    public String getModelType() {
        return "PSSYSPORTLET";
    }

    @Override
    @PSModelRTMeta(description="\u7a7a\u767d\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90", fields={"EMPTYTEXTPSLANRESID"})
    public IPSLanguageRes getEmptyTextPSLanguageRes() {
        return this.emptyTextPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u7a7a\u767d\u663e\u793a\u5185\u5bb9", fields={"EMPTYTEXT"})
    public String getEmptyText() {
        return this.strEmptyText;
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", fields={"TITLEPSLANRESID"})
    public IPSLanguageRes getTitlePSLanguageRes() {
        return this.titlePSLanguageRes;
    }

    @Override
    public String getPSACHandlerId() {
        return this.strPSACHandlerId;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90", fields={"PSSYSUNIRESID"})
    public IPSSysUniRes getPSSysUniRes() {
        return this.iPSSysUniRes;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u95e8\u6237\u90e8\u4ef6\u5206\u7c7b", fields={"PSSYSPORTLETCATID"})
    public IPSSysPortletCat getPSSysPortletCat() {
        return this.iPSSysPortletCat;
    }

    @Override
    public String getPSDEUIActionGroupId() {
        return this.psSysPortlet.getPSDEUAGROUPID();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5e94\u7528\u5168\u5c40\u6570\u636e\u770b\u677f", fields={"DASHBOARDSCOPE"})
    public boolean isEnableAppDashboard() {
        return (this.getDashboardScope() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5b9e\u4f53\u6570\u636e\u770b\u677f", fields={"DASHBOARDSCOPE"})
    public boolean isEnableDEDashboard() {
        if (this.getPSDataEntity() == null) {
            return false;
        }
        return (this.getDashboardScope() & 2) == 2;
    }

    @Override
    public int getDashboardScope() {
        return this.nDashboardScope;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5c55\u5f00\u6a21\u5f0f", codelist="UGExtractMode", fields={"GROUPEXTRACTMODE"})
    public String getActionGroupExtractMode() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDEUIActionGroupId())) {
            return "";
        }
        return this.strActionGroupExtractMode;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u6837\u5f0f", codelist="FormDetailStyle", fields={"PORTLETSTYLE"})
    public String getPortletStyle() {
        return this.strPortletStyle;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5b9e\u4f53")
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) {
        this.iPSDataEntity = iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u677f\u5f15\u64ce", fields={"TEMPLENGINE"})
    public String getTemplEngine() {
        return this.strTemplEngine;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u56fe\u7247", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u754c\u9762\u6837\u5f0f\u8868", fields={"PSSYSCSSID"})
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u52a8\u6001\u53c2\u6570", hideempty=true, fields={"PORTLETPARAMS"})
    public Properties getPortletParams() {
        return this.portletParams;
    }
}

