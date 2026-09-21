/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSTreeExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSExpBarParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelRTIgnoreMeta
public class PSTreeExpBarParamImpl
extends PSExpBarParamImpl
implements IPSTreeExpBarParam {
    private static final Log log = LogFactory.getLog(PSExpBarParamImpl.class);
    private String strPSDETreeId = "";
    private Boolean bEnableEdit = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strPSDETreeId = this.psDEViewCtrl.getPSDETREEVIEWID();
        if (!this.psDEViewCtrl.isCTRLPARAM6Null()) {
            this.setEnableEdit(this.psDEViewCtrl.getCTRLPARAM6());
        }
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSTreeExpBarParam) {
            IPSTreeExpBarParam iPSExpBarParam = (IPSTreeExpBarParam)iPSControlParam;
            if (StringHelper.isNullOrEmpty((String)this.getPSDETreeId())) {
                this.setPSDETreeId(iPSExpBarParam.getPSDETreeId());
            }
            if (this.isEnableEdit() == null) {
                this.setEnableEdit(iPSExpBarParam.isEnableEdit());
            }
        }
    }

    @Override
    public String getPSDETreeId() {
        return this.strPSDETreeId;
    }

    protected void setPSDETreeId(String strPSDETreeId) {
        this.strPSDETreeId = strPSDETreeId;
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

