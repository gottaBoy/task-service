/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Calendar;

import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarParam;
import SA.SRFDA.PS.Core.Control.Calendar.PSCalendarParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSSysCalendarParamImpl
extends PSCalendarParamImpl
implements IPSSysCalendarParam {
    private String strPSSysCalendarId = "";
    private Boolean bEnableEdit = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSSysCalendarId(this.psDEViewCtrl.getPSSYSCALENDARID());
        if (!this.psDEViewCtrl.isCTRLPARAM6Null()) {
            this.setEnableEdit(this.psDEViewCtrl.getCTRLPARAM6());
        }
    }

    @Override
    public String getPSSysCalendarId() {
        return this.strPSSysCalendarId;
    }

    public void setPSSysCalendarId(String strPSSysCalendarId) {
        this.strPSSysCalendarId = strPSSysCalendarId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSSysCalendarParam) {
            IPSSysCalendarParam iPSSysCalendarBarParam = (IPSSysCalendarParam)iPSControlParam;
            if (StringHelper.IsNullOrEmpty((String)this.getPSSysCalendarId())) {
                this.setPSSysCalendarId(iPSSysCalendarBarParam.getPSSysCalendarId());
            }
            if (iPSSysCalendarBarParam.isEnableEdit() != null) {
                this.setEnableEdit(iPSSysCalendarBarParam.isEnableEdit());
            }
        }
    }

    @Override
    public Boolean isEnableEdit() {
        if (this.bEnableEdit == null) {
            return null;
        }
        return this.bEnableEdit;
    }

    public void setEnableEdit(Boolean bEnableEdit) {
        this.bEnableEdit = bEnableEdit;
    }
}

