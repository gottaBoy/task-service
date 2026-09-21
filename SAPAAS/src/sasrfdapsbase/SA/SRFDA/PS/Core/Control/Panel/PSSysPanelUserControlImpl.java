/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelUserControl;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelItemImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Properties;
import net.ibizsys.pscore.srv.util.PropertiesHelper;

@PSModelImplementMeta(implement="IPSPanelItem", typevalues={"USERCONTROL"})
public class PSSysPanelUserControlImpl
extends PSSysPanelItemImpl
implements IPSSysPanelUserControl {
    private String strSampleContent = "";
    private Properties ctrlParams = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getITEMPARAMS())) {
            this.ctrlParams = PropertiesHelper.load((String)this.psSysPanelItem.getITEMPARAMS());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getHTMLCONTENT())) {
            this.strSampleContent = this.psSysPanelItem.getHTMLCONTENT();
        }
        super.onInit();
    }

    @Override
    public String getSampleContent() {
        return this.strSampleContent;
    }

    @Override
    public void fillPSPanelFields(ArrayList<IPSPanelField> psSysViewPanelFieldList) {
    }

    @Override
    public String getModelType() {
        return "PSSYSVIEWPANELITEM_USERCONTROL";
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

