/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Custom;

import SA.SRFDA.PS.Core.Control.Custom.IPSCustomControl;
import SA.SRFDA.PS.Core.Control.Custom.IPSCustomControlParam;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSAjaxControlImpl;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSControl", typevalues={"CUSTOM"})
public class PSCustomControlImpl
extends PSAjaxControlImpl
implements IPSCustomControl {
    private IPSCustomControlParam iPSCustomControlParam = null;
    protected IPSDEDataSet iPSDEDataSet = null;
    protected IPSDEAction iPSDEAction = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSControlContainer(iPSControlContainer);
        if (iPSControlParam != null) {
            this.iPSCustomControlParam = (IPSCustomControlParam)iPSControlParam;
        }
        this.setName(strName);
        if (!StringHelper.isNullOrEmpty((String)this.iPSCustomControlParam.getPSDEId())) {
            this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.iPSCustomControlParam.getPSDEId()));
            if (!StringHelper.isNullOrEmpty((String)this.iPSCustomControlParam.getPSDEDataSetId())) {
                this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.iPSCustomControlParam.getPSDEDataSetId());
            }
            if (!StringHelper.isNullOrEmpty((String)this.iPSCustomControlParam.getPSDEActionId())) {
                this.iPSDEAction = this.getPSDataEntity().getPSDEAction(this.iPSCustomControlParam.getPSDEActionId());
            }
        }
        super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.iPSCustomControlParam.getPSSysPFPluginId())) {
            this.iPSSysPFPlugin = this.getPSAppView().getPSApplication().getPSSystem().getPSSysPFPlugin(this.iPSCustomControlParam.getPSSysPFPluginId());
            this.getPSAppView().registerPSSysPFPlugin(this.iPSSysPFPlugin);
        }
        super.onInit();
    }

    @Override
    protected String onGetControlType() {
        return "CUSTOM";
    }

    @Override
    public String getModelScope() {
        return "VIEW";
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.iPSCustomControlParam;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6807\u8bb0")
    public String getCustomTag() {
        return this.iPSCustomControlParam.getCtrlParam();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6807\u8bb02")
    public String getCustomTag2() {
        return this.iPSCustomControlParam.getCtrlParam2();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u7ed3\u679c\u96c6\u5bf9\u8c61", hideempty=true)
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61", hideempty=true)
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    public boolean hasCtrlModel() {
        return false;
    }

    @Override
    public String getModelType() {
        return "PSCUSTOMCONTROL";
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u7c7b\u578b", hideempty2=true)
    public String getPredefinedType() {
        if (this.iPSCustomControlParam != null) {
            return this.iPSCustomControlParam.getPredefinedType();
        }
        return "";
    }
}

