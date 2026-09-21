/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBSearchFormPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBSysPortletPartImpl;
import SA.SRFDA.PS.Core.Control.Form.IPSDESearchForm;
import SA.SRFDA.PS.Core.Control.Form.PSDESearchFormParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDESearchFormPortlet;

@PSModelIgnoreMeta
public class PSDBSearchFormPortletPartImpl
extends PSDBSysPortletPartImpl
implements IPSDBSearchFormPortletPart {
    public static final String FORMNAME = "_form";
    private IPSDESearchForm iPSDESearchForm = null;

    @Override
    protected void onInit() throws Exception {
        IPSSysDESearchFormPortlet iPSSysDESearchFormPortlet = (IPSSysDESearchFormPortlet)this.iPSSysPortlet;
        PSDESearchFormParamImpl psDESearchFormParamImpl = new PSDESearchFormParamImpl();
        psDESearchFormParamImpl.setPSDEFormId(iPSSysDESearchFormPortlet.getPSDESearchFormId());
        if (iPSSysDESearchFormPortlet.getHeight() > 0) {
            psDESearchFormParamImpl.setHeight(Double.valueOf(iPSSysDESearchFormPortlet.getHeight()));
        }
        this.iPSDESearchForm = (IPSDESearchForm)this.registerPSControl(String.valueOf(this.getName()) + FORMNAME, "SEARCHFORM", psDESearchFormParamImpl);
        super.onInit();
    }

    @Override
    public IPSDESearchForm getPSDESearchForm() {
        return this.iPSDESearchForm;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u90e8\u4ef6")
    public IPSControl getContentPSControl() {
        return this.getPSDESearchForm();
    }
}

