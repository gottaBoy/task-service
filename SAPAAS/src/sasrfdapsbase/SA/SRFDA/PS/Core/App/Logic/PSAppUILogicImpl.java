/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.App.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefView;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.Res.PSSysViewLogicImpl;
import SA.SRFDA.PS.Data.PSSysViewLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pscore.srv.util.Inflector;

public class PSAppUILogicImpl
extends PSSysViewLogicImpl
implements IPSAppUILogic {
    private IPSApplication iPSApplication = null;
    private ArrayList<IPSAppUILogicRefView> psAppUILogicRefViewList = null;
    private boolean bBuiltinLogic = false;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEUILogic iPSAppDEUILogic = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private String strCodeName = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSSysViewLogic psSysViewLogic) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSApplication(iPSApplication);
        this.init(iDAGlobalHelper, iPSApplication.getPSSystem(), psSysViewLogic);
    }

    @Override
    protected void onInit() throws Exception {
        if (StringHelper.Compare((String)this.getViewLogicType(), (String)"DEUILOGIC", (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)this.getPSDEId())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u6807\u8bc6");
            }
            if (StringHelper.IsNullOrEmpty((String)this.getPSDEUILogicId())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u6807\u8bc6");
            }
            IPSDataEntity iPSDataEntity = this.getPSApplication().getPSSystem().getPSDataEntity2(this.getPSDEId());
            this.iPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(iPSDataEntity, true);
            if (this.iPSAppDataEntity != null) {
                this.iPSAppDEUILogic = this.iPSAppDataEntity.getPSAppDEUILogic(this.getPSDEUILogicId());
            }
        } else if (StringHelper.Compare((String)this.getViewLogicType(), (String)"PFPLUGIN", (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)this.getPSSysPFPluginId())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5e94\u7528\u6269\u5c55\u63d2\u4ef6");
            }
            this.iPSSysPFPlugin = this.getPSApplication().getPSSysPFPlugin(this.getPSSysPFPluginId(), "APPUILOGIC", null, null);
            String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPluginId(), (String)this.getPSApplication().getPSPFStyle().getPSPF().getId());
            IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
            if (iPSSysPFPluginTempl != null) {
                LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
                params.put("app", this.getPSApplication());
                this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this, params);
            }
        }
        super.onInit();
        this.strCodeName = this.getPSSystemModule() != null ? String.format("%1$s__%2$s", this.getPSSystemModule().getCodeName(), super.getCodeName()) : super.getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5efa\u903b\u8f91", ignoredumpvalues="true")
    public boolean isBuiltinLogic() {
        return this.bBuiltinLogic;
    }

    protected void setBuiltinLogic(boolean bBuiltinLogic) {
        this.bBuiltinLogic = bBuiltinLogic;
    }

    @Deprecated
    public Iterator<IPSAppUILogicRefView> getPSAppViewLogicRefViews() {
        return this.getPSAppUILogicRefViews();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u754c\u9762\u903b\u8f91\u5f15\u7528\u89c6\u56fe\u96c6\u5408", child=true, modeltype="SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefViewBase")
    public Iterator<IPSAppUILogicRefView> getPSAppUILogicRefViews() {
        if (this.psAppUILogicRefViewList == null || this.psAppUILogicRefViewList.size() == 0) {
            return null;
        }
        return this.psAppUILogicRefViewList.iterator();
    }

    protected void registerPSAppUILogicRefView(IPSAppUILogicRefView iPSAppUILogicRefView) {
        if (this.psAppUILogicRefViewList == null) {
            this.psAppUILogicRefViewList = new ArrayList();
        }
        this.psAppUILogicRefViewList.add(iPSAppUILogicRefView);
    }

    @Override
    public IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    protected void setPSApplication(IPSApplication iPSApplication) {
        this.iPSApplication = iPSApplication;
    }

    @Override
    public String getModelType() {
        return "PSAPPUILOGIC";
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)this.getId());
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    protected void setPSAppDataEntity(IPSAppDataEntity iPSAppDataEntity) {
        this.iPSAppDataEntity = iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEUILogic getPSAppDEUILogic() {
        return this.iPSAppDEUILogic;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6", hideempty=true)
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSApplication();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u52a8\u6001\u6a21\u578b", dump=false)
    public boolean isEnableDynaModel() {
        if (this.getPSApplication() != null && !this.getPSApplication().isEnableDynaSys()) {
            return false;
        }
        return this.onGetEnableDynaModel();
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6a21\u5f0f", dump=false, codelist="DynaInstMode3")
    public int getDynaInstMode() {
        if (this.getPSApplication() != null && !this.getPSApplication().isEnableDynaModel()) {
            return 0;
        }
        return this.onGetDynaInstMode();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0", dump=false, hideempty2=true)
    public String getDynaInstTag() {
        if (this.getDynaInstMode() == 0) {
            return "";
        }
        return this.onGetDynaInstTag();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb02", dump=false, hideempty2=true)
    public String getDynaInstTag2() {
        if (this.getDynaInstMode() == 0) {
            return "";
        }
        return this.onGetDynaInstTag2();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b", ignoredumpvalues="false")
    public boolean isDynaInstModel() {
        return !StringHelper.IsNullOrEmpty((String)this.getPSDynaInstId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    @Override
    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    @Override
    protected String calcCodeName() {
        return this.strCodeName;
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSApplication() != null) {
            return String.format("%1$s/%2$s", this.getPSApplication().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

