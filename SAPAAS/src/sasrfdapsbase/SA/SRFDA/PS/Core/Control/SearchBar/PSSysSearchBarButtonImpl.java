/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.Control.SearchBar.IPSSysSearchBarButton;
import SA.SRFDA.PS.Core.Control.SearchBar.PSSysSearchBarItemImplBase;

public class PSSysSearchBarButtonImpl
extends PSSysSearchBarItemImplBase
implements IPSSysSearchBarButton {
    private String strButtonType = null;

    @Override
    protected void onInit() throws Exception {
        this.strButtonType = this.psSysSearchBarItem.getITEMSUBTYPE().replace("BUTTON_", "");
        super.onInit();
    }

    @Override
    public String getButtonType() {
        return this.strButtonType;
    }
}

