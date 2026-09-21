/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.MBList
 *  SA.SRFDA.Ctrl.Data.MBPanel
 *  SA.SRFDA.Ctrl.IDAMBConfigHelperContext
 *  SA.SRFDA.Ctrl.IDEHelper
 */
package SA.SRFDA.Mobile.Ctrl;

import SA.SRFDA.Ctrl.Data.MBList;
import SA.SRFDA.Ctrl.Data.MBPanel;
import SA.SRFDA.Ctrl.IDAMBConfigHelperContext;
import SA.SRFDA.Ctrl.IDEHelper;

public class DAMBConfigHelperContext
implements IDAMBConfigHelperContext {
    private IDEHelper iDEHelper = null;
    private MBList mbList = null;
    private MBPanel mbPanel = null;

    public IDEHelper getDEHelper() {
        return this.iDEHelper;
    }

    public MBList getMBList() {
        return this.mbList;
    }

    public MBPanel getMBPanel() {
        return this.mbPanel;
    }

    public void setDEHelper(IDEHelper iDEHelper) {
        this.iDEHelper = iDEHelper;
    }

    public void setMBList(MBList mbList) {
        this.mbList = mbList;
    }

    public void setMBPanel(MBPanel mbPanel) {
        this.mbPanel = mbPanel;
    }
}

