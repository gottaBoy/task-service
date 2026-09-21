/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBAppMenuPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBAppMenuPortletPartParam;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBPortletPartImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.Control.Menu.PSAppMenuParamImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSPortletType;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSDBPortletPart", typevalues={"APPMENU"})
public class PSDBAppMenuPortletPartImpl
extends PSDBPortletPartImpl
implements IPSDBAppMenuPortletPart {
    private static final Log log = LogFactory.getLog(PSDBAppMenuPortletPartImpl.class);
    protected IPSAppMenu iPSAppMenu = null;
    private IPSDBAppMenuPortletPartParam iPSDBAppMenuPortletPartParam = null;
    private static final String APPMENU = "_appmenu";
    private IPSSysPFPlugin amPSSysPFPlugin = null;
    private IPSPortletType iPSPortletType;
    private IPSAppView IPSAppFuncPickupView = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            this.iPSDBAppMenuPortletPartParam = (IPSDBAppMenuPortletPartParam)iPSControlParam;
            this.setId(StringHelper.format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
            this.setName(strName);
            PSAppMenuParamImpl psAppMenuParamImpl = new PSAppMenuParamImpl();
            if (!StringHelper.isNullOrEmpty((String)this.iPSDBAppMenuPortletPartParam.getPSAppMenuId())) {
                this.setId(this.iPSDBAppMenuPortletPartParam.getPSAppMenuId());
                psAppMenuParamImpl.setPSAppMenuId(this.iPSDBAppMenuPortletPartParam.getPSAppMenuId());
                if (this.getPSAppView() != null && this.getPSAppView().getPSPFStyle().getPFEngineVer() >= 20) {
                    psAppMenuParamImpl.setPSSysPFPluginId(this.iPSDBAppMenuPortletPartParam.getAMPSSysPFPluginId());
                    psAppMenuParamImpl.setAppMenuStyle(this.iPSDBAppMenuPortletPartParam.getAMListStyle());
                }
                this.iPSAppMenu = (IPSAppMenu)this.registerPSControl(String.valueOf(this.getName()) + APPMENU, "APPMENU", psAppMenuParamImpl);
                if (!StringHelper.isNullOrEmpty((String)this.iPSDBAppMenuPortletPartParam.getAMPSSysPFPluginId())) {
                    this.amPSSysPFPlugin = this.getPSAppView().getPSApplication() != null ? this.getPSAppView().getPSSystem().getPSSysPFPlugin(this.iPSDBAppMenuPortletPartParam.getAMPSSysPFPluginId()) : this.getPSAppView().getPSSystem().getPSSysPFPlugin(this.iPSDBAppMenuPortletPartParam.getAMPSSysPFPluginId());
                    this.getPSAppView().registerPSSysPFPlugin(this.amPSSysPFPlugin);
                }
            }
            this.iPSPortletType = this.getPSModelStorage().getPSPortletType(this.getPortletType());
            super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
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
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.iPSAppMenu.getCodeName();
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.iPSDBAppMenuPortletPartParam.getPSAppFuncPickupViewId())) {
            this.IPSAppFuncPickupView = this.getPSAppView().getPSApplication().getPSAppView(this.iPSDBAppMenuPortletPartParam.getPSAppFuncPickupViewId(), false);
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u90e8\u4ef6", dumpref=true, modelreftype="LINK", from="__self__", from_method="getPSControl", fields={"PSAPPMENUID"})
    public IPSControl getContentPSControl() {
        return this.getPSAppMenu();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u770b\u677f\u90e8\u4ef6\u7c7b\u578b", codelist="PortletType3", fields={"PVPARTTYPE"})
    public String getPortletType() {
        return "APPMENU";
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u83dc\u5355\u5bf9\u8c61")
    public IPSAppMenu getPSAppMenu() {
        return this.iPSAppMenu;
    }

    @Override
    public IPSSysPFPlugin getAMSysPFPlugin() {
        return this.amPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u83dc\u5355\u7ed8\u5236\u63d2\u4ef6", hideempty2=true)
    public IPSSysPFPlugin getAMPSSysPFPlugin() {
        return this.amPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u83dc\u5355\u5217\u8868\u6837\u5f0f", hideempty2=true)
    public String getAMListStyle() {
        return this.iPSDBAppMenuPortletPartParam.getAMListStyle();
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934")
    public String getTitle() {
        if (StringHelper.isNullOrEmpty((String)super.getTitle()) && this.getPSAppMenu() != null) {
            return this.getPSAppMenu().getName();
        }
        return super.getTitle();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u83dc\u5355\u529f\u80fd\u9009\u62e9\u89c6\u56fe")
    public IPSAppView getPSAppFuncPickupView() {
        return this.IPSAppFuncPickupView;
    }

    @Override
    public IPSPortletType getPSPortetType() {
        return this.iPSPortletType;
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppView().getFullModelName(), (Object)this.getModelName());
    }
}

