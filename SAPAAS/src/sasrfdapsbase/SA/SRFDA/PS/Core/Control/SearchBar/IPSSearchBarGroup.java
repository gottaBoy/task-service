/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarItem;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import java.util.Iterator;

public interface IPSSearchBarGroup
extends IPSSearchBarItem {
    public boolean isAddSeparator();

    public String getTooltip();

    public IPSLanguageRes getTooltipPSLanguageRes();

    public double getWidth();

    public boolean isDefaultGroup();

    public Iterator<IPSDEDQCondition> getFilterPSDEDQConditions();

    public IPSDEDataSet getFilterPSDEDataSet();
}

