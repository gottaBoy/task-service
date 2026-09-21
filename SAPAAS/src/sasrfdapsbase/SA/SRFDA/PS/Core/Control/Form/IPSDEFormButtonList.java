/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormButton;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5b9e\u4f53\u8868\u5355\u6309\u94ae\u5217\u8868\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"BUTTONLIST"})
public interface IPSDEFormButtonList
extends IPSDEFormDetail {
    public static final String BUTTONLISTTYPE_UIACTIONGROUP = "UIACTIONGROUP";
    public static final String BUTTONLISTTYPE_BUTTONS = "BUTTONS";

    public IPSUIActionGroup getPSUIActionGroup();

    public String getActionGroupExtractMode();

    public Iterator<IPSDEFormButton> getPSDEFormButtons();

    public String getButtonListType();
}

