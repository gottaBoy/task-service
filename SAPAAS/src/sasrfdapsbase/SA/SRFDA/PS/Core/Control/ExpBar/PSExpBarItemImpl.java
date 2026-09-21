/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSExpBarItem;
import java.util.ArrayList;

public class PSExpBarItemImpl
implements IPSExpBarItem {
    protected ArrayList<IPSExpBarItem> psExpBarItems = new ArrayList();

    @Override
    public ArrayList<IPSExpBarItem> getItems() {
        return this.psExpBarItems;
    }
}

