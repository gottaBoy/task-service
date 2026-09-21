/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormUserControl;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormDetailImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Properties;
import net.ibizsys.pscore.srv.util.PropertiesHelper;

public class PSDEFormUserControlImpl
extends PSDEFormDetailImpl
implements IPSDEFormUserControl {
    private String strRawContent = "";
    private Properties ctrlParams = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getEDITORPARAMS())) {
            this.ctrlParams = PropertiesHelper.load((String)this.psDEFormDetail.getEDITORPARAMS());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getRAWCONTENT())) {
            this.strRawContent = this.psDEFormDetail.getRAWCONTENT();
        }
        super.onInit();
    }

    @Override
    public String getRawContent() {
        return this.strRawContent;
    }

    @Override
    public IPSSysPFPlugin getRenderPSSysPFPlugin() {
        return this.getPSSysPFPlugin();
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
    }

    @Override
    public String getModelType() {
        return "PSDEFORMDETAIL_USERCONTROL";
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u7c7b\u578b", fields={"PREDEFINEDTYPE"})
    public String getPredefinedType() {
        return super.getPredefinedType();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u53c2\u6570\u96c6\u5408")
    public Properties getCtrlParams() {
        return this.ctrlParams;
    }
}

