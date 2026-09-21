/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlParamImpl;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSysSearchBarParam;
import SA.SRFramework.Utility.StringHelper;

public class PSSysSearchBarParamImpl
extends PSControlParamImpl
implements IPSSysSearchBarParam {
    private String strPSSysSearchBarId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSSysSearchBarId(this.psDEViewCtrl.getPSSYSSEARCHBARID());
    }

    @Override
    public String getPSSysSearchBarId() {
        return this.strPSSysSearchBarId;
    }

    public void setPSSysSearchBarId(String strPSSysSearchBarId) {
        this.strPSSysSearchBarId = strPSSysSearchBarId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSSysSearchBarParam) {
            IPSSysSearchBarParam iPSSysSearchBarBarParam = (IPSSysSearchBarParam)iPSControlParam;
            if (StringHelper.IsNullOrEmpty((String)this.getPSSysSearchBarId())) {
                this.setPSSysSearchBarId(iPSSysSearchBarBarParam.getPSSysSearchBarId());
            }
        }
    }
}

