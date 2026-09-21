/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.WizardPanel;

import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5411\u5bfc\u9762\u677f\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3", model="PSDEWizard")
public interface IPSWizardPanel
extends IPSAjaxControl,
IPSControlContainer {
    public String getWizardStyle();
}

