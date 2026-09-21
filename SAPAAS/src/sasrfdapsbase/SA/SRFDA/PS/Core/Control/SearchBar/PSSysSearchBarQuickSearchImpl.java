/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarQuickSearch;
import SA.SRFDA.PS.Core.Control.SearchBar.PSSysSearchBarItemImplBase;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSSysSearchBarQuickSearchImpl
extends PSSysSearchBarItemImplBase
implements IPSSearchBarQuickSearch {
    private IPSDEFSearchMode iPSDEFSearchMode = null;

    @Override
    protected void onInit() throws Exception {
        if (this.getPSDEField() != null && !StringHelper.isNullOrEmpty((String)this.psSysSearchBarItem.getPSDEFSFITEMID())) {
            this.iPSDEFSearchMode = this.getPSDEField().getPSDEFSearchMode(this.psSysSearchBarItem.getPSDEFSFITEMID());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f", child=true)
    public IPSDEFSearchMode getPSDEFSearchMode() {
        return this.iPSDEFSearchMode;
    }

    @Override
    public String getModelType() {
        return "PSSYSSEARCHBARQUICKSEARCH";
    }
}

