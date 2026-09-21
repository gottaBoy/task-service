/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBEditFormPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBSysPortletPartImpl;
import SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm;
import SA.SRFDA.PS.Core.Control.Form.PSDEEditFormParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDEEditFormPortlet;

@PSModelIgnoreMeta
public class PSDBEditFormPortletPartImpl
extends PSDBSysPortletPartImpl
implements IPSDBEditFormPortletPart {
    public static final String FORMNAME = "_form";
    private IPSDEEditForm iPSDEEditForm = null;

    @Override
    protected void onInit() throws Exception {
        IPSSysDEEditFormPortlet iPSSysDEEditFormPortlet = (IPSSysDEEditFormPortlet)this.iPSSysPortlet;
        PSDEEditFormParamImpl psDEEditFormParamImpl = new PSDEEditFormParamImpl();
        psDEEditFormParamImpl.setPSDEFormId(iPSSysDEEditFormPortlet.getPSDEEditFormId());
        if (iPSSysDEEditFormPortlet.getHeight() > 0) {
            psDEEditFormParamImpl.setHeight(Double.valueOf(iPSSysDEEditFormPortlet.getHeight()));
        }
        this.iPSDEEditForm = (IPSDEEditForm)this.registerPSControl(String.valueOf(this.getName()) + FORMNAME, "FORM", psDEEditFormParamImpl);
        super.onInit();
    }

    @Override
    public IPSDEEditForm getPSDEEditForm() {
        return this.iPSDEEditForm;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u90e8\u4ef6")
    public IPSControl getContentPSControl() {
        return this.getPSDEEditForm();
    }
}

