/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.panel.IPanelField;
import net.ibizsys.paas.ctrlmodel.IPanelModel;

public interface IPanelFieldModel
extends IPanelField {
    public static final Integer OUTPUTCODELISTCONFIGMODE_NONE = 0;
    public static final Integer OUTPUTCODELISTCONFIGMODE_SELECTEDONLY = 1;
    public static final Integer OUTPUTCODELISTCONFIGMODE_INCLUDECHILD = 2;

    public IPanelModel getPanelModel();

    public boolean isOutputCodeListConfig();

    public int getOutputCodeListConfigMode();
}

