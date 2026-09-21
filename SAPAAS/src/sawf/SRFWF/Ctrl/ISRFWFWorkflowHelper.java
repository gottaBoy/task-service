/*
 * Decompiled with CFR 0.152.
 */
package SRFWF.Ctrl;

import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Model.WFInteractiveProcessConfig;
import java.util.Properties;

public interface ISRFWFWorkflowHelper {
    public void Init(Properties var1);

    public WFInteractiveProcessConfig ReCalcInteractiveProcess(ISRFWFContext var1, WFInteractiveProcessConfig var2) throws Exception;
}

