/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.MBList;
import SA.SRFDA.Ctrl.Data.MBPanel;
import SA.SRFDA.Ctrl.IDEHelper;

public interface IDAMBConfigHelperContext {
    public IDEHelper getDEHelper();

    public MBPanel getMBPanel();

    public MBList getMBList();
}

