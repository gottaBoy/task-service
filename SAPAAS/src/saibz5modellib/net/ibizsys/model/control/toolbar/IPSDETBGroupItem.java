/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.toolbar;

import java.util.Iterator;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;

public interface IPSDETBGroupItem
extends IPSDEToolbarItem {
    public Iterator<IPSDEToolbarItem> getPSDEToolbarItems() throws Exception;

    @Override
    public IPSSysImage getPSSysImage();

    @Override
    public IPSSysCss getPSSysCss();
}

