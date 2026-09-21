/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBar;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSysSearchBar;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSysSearchBarObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSObjectImpl;

public abstract class PSSysSearchBarObjectImpl
extends PSObjectImpl
implements IPSSysSearchBarObject {
    private IPSSysSearchBar iPSSysSearchBar = null;

    @Override
    public IPSSysSearchBar getPSSysSearchBar() {
        return this.iPSSysSearchBar;
    }

    protected void setPSSysSearchBar(IPSSysSearchBar iPSSysSearchBar) {
        this.iPSSysSearchBar = iPSSysSearchBar;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysSearchBar().getPSSysModelInstId();
    }

    @Override
    public IPSSearchBar getPSSearchBar() {
        return this.getPSSysSearchBar();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysSearchBar().getPSAppView().getPSSystem());
    }
}

