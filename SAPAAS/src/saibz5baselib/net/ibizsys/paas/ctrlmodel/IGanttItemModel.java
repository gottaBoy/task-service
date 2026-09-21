/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.gantt.IGanttItem;
import net.ibizsys.paas.control.gantt.IGanttItemDataItem;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.ctrlhandler.IGanttItemFetchContext;
import net.ibizsys.paas.ctrlmodel.IGanttModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataTable;

public interface IGanttItemModel
extends IModelBase {
    public IGanttModel getGanttModel();

    public String getDEName();

    public void fillFetchResult(IGanttItemFetchContext var1, ArrayList<IGanttItem> var2, IDataTable var3) throws Exception;

    public String getIconCls();

    public String getIconPath();

    public String getItemType();

    public IGanttItemDataItem getGanttItemDataItem(String var1) throws Exception;

    public Iterator<IGanttItemDataItem> getGanttItemDataItems();

    public String getDEDataSetName();

    public String getIdField();

    public String getTextField();

    public String getIconField();

    public String getCreateDEActionName();

    public String getCreateDataAccessAction();

    public String getUpdateDEActionName();

    public String getUpdateDataAccessAction();

    public String getRemoveDEActionName();

    public String getRemoveDataAccessAction();

    public String getActiveDataDELogicId();

    public String getTipsField();

    public String getContentField();

    public String getBeginTimeField();

    public String getEndTimeField();

    public String getColorField();

    public String getBKColorField();

    public int getMaxSize();

    public String getColor();

    public String getBKColor();

    public String getPIdField();

    public String getOrderValueField();

    public String getLevelField();

    public String getTotalField();

    public String getFinishField();

    public void fillInputValues(IDataObject var1, boolean var2, boolean var3) throws Exception;

    public IGanttItem getGanttItem(IDataObject var1, boolean var2) throws Exception;
}

