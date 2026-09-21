/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.AppMenu;

import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.Control.Menu.PSAppMenuImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.Iterator;

public class PSAppMenuModelImpl
extends PSAppMenuImpl
implements IPSAppMenuModel {
    @Override
    @PSModelRTMeta(description="\u83dc\u5355\u9879\u96c6\u5408", child=true)
    public Iterator<IPSAppMenuItem> getPSAppMenuItems() throws Exception {
        return super.getPSAppMenuItems();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSApplication();
    }
}

