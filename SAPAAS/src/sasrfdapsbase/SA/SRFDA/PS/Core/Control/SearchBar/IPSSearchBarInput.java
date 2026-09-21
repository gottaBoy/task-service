/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarItem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;

@PSModelIgnoreMeta
public interface IPSSearchBarInput
extends IPSSearchBarItem {
    public static final String INPUT_RADIOBUTTONLIST = "RADIOBUTTONLIST";
    public static final String INPUT_CHECKBOXLIST = "CHECKBOXLIST";
    public static final String INPUT_CHECKBOX = "CHECKBOX";
    public static final String INPUT_TEXTBOX = "TEXTBOX";

    public String getInputType();

    public IPSLanguageRes getPHPSLanguageRes();

    public String getPHLanResTag();

    public String getPlaceHolder();

    public IPSCodeList getPSCodeList();
}

