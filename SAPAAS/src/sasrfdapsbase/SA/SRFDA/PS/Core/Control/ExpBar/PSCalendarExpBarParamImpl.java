/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSCalendarExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSExpBarParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelRTIgnoreMeta
public class PSCalendarExpBarParamImpl
extends PSExpBarParamImpl
implements IPSCalendarExpBarParam {
    private static final Log log = LogFactory.getLog(PSExpBarParamImpl.class);
    private String strPSSysCalendarId = "";
    private Boolean bEnableEdit = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strPSSysCalendarId = this.psDEViewCtrl.getPSSYSCALENDARID();
        if (!this.psDEViewCtrl.isCTRLPARAM6Null()) {
            this.setEnableEdit(this.psDEViewCtrl.getCTRLPARAM6());
        }
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSCalendarExpBarParam) {
            IPSCalendarExpBarParam iPSExpBarParam = (IPSCalendarExpBarParam)iPSControlParam;
            if (StringHelper.isNullOrEmpty((String)this.getPSSysCalendarId())) {
                this.setPSSysCalendarId(iPSExpBarParam.getPSSysCalendarId());
            }
            if (this.isEnableEdit() == null) {
                this.setEnableEdit(iPSExpBarParam.isEnableEdit());
            }
        }
    }

    @Override
    public String getPSSysCalendarId() {
        return this.strPSSysCalendarId;
    }

    protected void setPSSysCalendarId(String strPSSysCalendarId) {
        this.strPSSysCalendarId = strPSSysCalendarId;
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

