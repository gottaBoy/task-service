/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.map.IMapItem;
import net.ibizsys.paas.control.map.IMapItemDataItem;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.ctrlhandler.IMapItemFetchContext;
import net.ibizsys.paas.ctrlmodel.IMapModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataTable;

public interface IMapItemModel
extends IModelBase {
    public IMapModel getMapModel();

    public String getDEName();

    public void fillFetchResult(IMapItemFetchContext var1, ArrayList<IMapItem> var2, IDataTable var3) throws Exception;

    public String getIconCls();

    public String getIconPath();

    public String getItemType();

    public IMapItemDataItem getMapItemDataItem(String var1) throws Exception;

    public Iterator<IMapItemDataItem> getMapItemDataItems();

    public String getDEDataSetName();

    public String getIdField();

    public String getTextField();

    public String getIconField();

    public String getRemoveDEActionName();

    public String getRemoveDataAccessAction();

    public String getActiveDataDELogicId();

    public String getTipsField();

    public String getContentField();

    public String getLongitudeField();

    public String getLatitudeField();

    public String getAltitudeField();

    public String getColorField();

    public String getBKColorField();

    public int getMaxSize();

    public String getColor();

    public String getBKColor();

    public String getBorderColor();

    public int getBorderWidth();

    public int getRadius();

    public void fillInputValues(IDataObject var1, boolean var2, boolean var3) throws Exception;

    public IMapItem getMapItem(IDataObject var1, boolean var2) throws Exception;
}

