/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel.toolbar;

import java.util.Iterator;
import net.ibizsys.paas.ctrlmodel.toolbar.IDynaToolbarItemModel;

public interface IDynaToolbarItemsModel
extends IDynaToolbarItemModel {
    public Iterator<IDynaToolbarItemModel> getItemModels();

    public String getShowMode();

    public String getCaption();

    public String getCapLanResTag();

    public String getTooltip();

    public String getTooltipLanResTag();
}

