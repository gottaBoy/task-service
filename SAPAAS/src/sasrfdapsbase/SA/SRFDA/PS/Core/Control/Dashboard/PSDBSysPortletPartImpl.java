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

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBSysPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBSysPortletPartParam;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBPortletPartImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlParamRuntime;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSPortletType;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPortlet;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDBSysPortletPartImpl
extends PSDBPortletPartImpl
implements IPSDBSysPortletPart {
    private static final Log log = LogFactory.getLog(PSDBSysPortletPartImpl.class);
    protected IPSSysPortlet iPSSysPortlet = null;
    private IPSDBSysPortletPartParam iPSDBSysPortletPartParam = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            this.iPSDBSysPortletPartParam = (IPSDBSysPortletPartParam)iPSControlParam;
            this.setId(this.iPSDBSysPortletPartParam.getPSSysPortletId());
            this.setName(strName);
            this.iPSSysPortlet = iPSControlContainer.getPSAppView().getPSApplication().getPSSystem().getPSSysPortlet(this.iPSDBSysPortletPartParam.getPSSysPortletId());
            if (StringHelper.compare((String)this.iPSSysPortlet.getTemplEngine(), (String)"V2", (boolean)false) == 0) {
                this.setPSDataEntity(this.iPSSysPortlet.getPSDataEntity());
            }
            if (this.iPSSysPortlet.getPSSysPFPlugin() != null && iPSControlParam instanceof IPSControlParamRuntime) {
                IPSControlParamRuntime iPSControlParamRuntime = (IPSControlParamRuntime)((Object)iPSControlParam);
                iPSControlParamRuntime.setPSSysPFPluginId(this.iPSSysPortlet.getPSSysPFPlugin().getId());
            }
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
    protected void onInit() throws Exception {
        super.onInit();
        if (this.getPSUIActionGroup() == null && !StringHelper.isNullOrEmpty((String)this.getPSSysPortlet().getPSDEUIActionGroupId())) {
            IPSDEUIActionGroup iPSUIActionGroup = null;
            if (this.getPSAppDataEntity() != null) {
                iPSUIActionGroup = this.getPSAppDataEntity().getPSAppDEUIActionGroup(this.getPSSysPortlet().getPSDEUIActionGroupId(), true, this);
            }
            if (iPSUIActionGroup == null) {
                iPSUIActionGroup = this.getPSDataEntity() != null ? this.getPSDataEntity().getPSDEUIActionGroup(this.getPSSysPortlet().getPSDEUIActionGroupId()) : this.getPSApplication().getPSAppDEUIActionGroup(this.getPSSysPortlet().getPSDEUIActionGroupId());
            }
            if (iPSUIActionGroup != null) {
                this.setPSUIActionGroup(iPSUIActionGroup);
                this.setActionGroupExtractMode(this.getPSSysPortlet().getActionGroupExtractMode());
            }
        }
    }

    @Override
    protected String getPSAjaxControlHandlerId() {
        String strPSAjaxControlHandlerId = super.getPSAjaxControlHandlerId();
        if (StringHelper.isNullOrEmpty((String)strPSAjaxControlHandlerId)) {
            return this.iPSSysPortlet.getPSACHandlerId();
        }
        return strPSAjaxControlHandlerId;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.iPSSysPortlet.getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u95e8\u6237\u90e8\u4ef6\u7c7b\u578b", codelist="PortletType3")
    public String getPortletType() {
        return this.iPSSysPortlet.getPortletType();
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934")
    public String getTitle() {
        if (StringHelper.isNullOrEmpty((String)super.getTitle())) {
            return this.iPSSysPortlet.getTitle();
        }
        return super.getTitle();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6")
    public IPSSysPortlet getPSSysPortlet() {
        return this.iPSSysPortlet;
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6")
    public double getHeight() {
        if (this.iPSDBSysPortletPartParam.getHeight() != null) {
            return this.iPSDBSysPortletPartParam.getHeight();
        }
        return this.getPSSysPortlet().getHeight();
    }

    @Override
    @PSModelRTMeta(description="\u5237\u65b0\u95f4\u9694\uff08ms\uff09", ignoredumpvalues="0;-1")
    public long getTimer() {
        return this.getPSSysPortlet().getReloadTimer();
    }

    @Override
    public IPSPortletType getPSPortetType() {
        return this.getPSSysPortlet().getPSPortletType();
    }

    @Override
    protected boolean onGetShowTitleBar() {
        return this.iPSSysPortlet.isShowTitleBar();
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", hideempty2=true)
    public IPSLanguageRes getTitlePSLanguageRes() {
        IPSLanguageRes iPSLanguageRes = super.getTitlePSLanguageRes();
        if (iPSLanguageRes != null) {
            return iPSLanguageRes;
        }
        return this.getPSSysPortlet().getTitlePSLanguageRes();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppView().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        IPSSysPFPlugin iPSSysPFPlugin = super.getPSSysPFPlugin();
        if (iPSSysPFPlugin != null) {
            return iPSSysPFPlugin;
        }
        return this.getPSSysPortlet().getPSSysPFPlugin();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90")
    public IPSSysUniRes getPSSysUniRes() {
        IPSSysUniRes iPSSysUniRes = super.getPSSysUniRes();
        if (iPSSysUniRes != null) {
            return iPSSysUniRes;
        }
        return this.getPSSysPortlet().getPSSysUniRes();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u56fe\u7247")
    public IPSSysImage getPSSysImage() {
        IPSSysImage iPSSysImage = super.getPSSysImage();
        if (iPSSysImage != null) {
            return iPSSysImage;
        }
        return this.getPSSysPortlet().getPSSysImage();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u6837\u5f0f")
    public IPSSysCss getPSSysCss() {
        IPSSysCss iPSSysCss = super.getPSSysCss();
        if (iPSSysCss != null) {
            return iPSSysCss;
        }
        return this.getPSSysPortlet().getPSSysCss();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u96c6\u5408", hideempty2=true, child=true, dumpref=false, modelreftype="IGNOREDESIGN")
    public Iterator<IPSControl> getPSControls() {
        return super.getPSControls();
    }
}

