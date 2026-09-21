/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u641c\u7d22\u8868\u5355\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEForm")
public interface IPSDESearchForm
extends IPSDEForm {
    public static final String SEARCHBUTTONSTYLE_DEFAULT = "DEFAULT";
    public static final String SEARCHBUTTONSTYLE_NONE = "NONE";
    public static final String SEARCHBUTTONSTYLE_SEARCHONLY = "SEARCHONLY";
    public static final String SEARCHBUTTONSTYLE_USER = "USER";
    public static final String SEARCHBUTTONSTYLE_USER2 = "USER2";
    public static final String SEARCHBUTTONPOS_RIGHT = "RIGHT";
    public static final String SEARCHBUTTONPOS_BOTTOM = "BOTTOM";

    public boolean isEnableAdvanceSearch();

    public boolean isEnableAutoSearch();

    public boolean isEnableFilterSave();

    public String getSearchButtonStyle();

    public IPSControlAction getCreatePSControlAction();

    public IPSControlAction getUpdatePSControlAction();

    public IPSControlAction getRemovePSControlAction();

    public IPSControlAction getGetPSControlAction();

    public IPSControlAction getGetDraftPSControlAction();

    public IPSControlAction getSearchPSControlAction();

    public IPSControlAction getFetchPSControlAction();

    public String getSearchButtonPos();
}

