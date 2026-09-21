/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.IPSControlItem;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarObject;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;

public interface IPSSearchBarItem
extends IPSSearchBarObject,
IPSControlItem {
    public static final String ITEMTYPE_FILTER = "FILTER";
    public static final String ITEMTYPE_QUICKSEARCH = "QUICKSEARCH";
    public static final String ITEMTYPE_GROUP = "GROUP";
    public static final int COUNTERMODE_NONE = 0;
    public static final int COUNTERMODE_HIDEZERO = 1;

    public String getItemType();

    public IPSDEField getPSDEField();

    public IPSAppDEField getPSAppDEField();

    public String getData();

    public String getCaption();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getCapLanResTag();

    public IPSSysImage getPSSysImage();

    public IPSSysCss getPSSysCss();

    public IPSSysCss getLabelPSSysCss();

    public String getDynaClass();

    public String getCssStyle();

    public String getLabelCssStyle();

    public String getLabelDynaClass();

    public IPSSysCounter getPSSysCounter();

    public String getCounterId();

    public int getCounterMode();

    public IPSAppCounterRef getPSAppCounterRef();
}

