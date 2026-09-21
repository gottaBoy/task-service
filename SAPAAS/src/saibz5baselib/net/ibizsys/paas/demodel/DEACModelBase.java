/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.demodel;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.datamodel.DataItemModel3;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.IDEACModeModel;
import net.ibizsys.paas.util.DataItemHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.sf.json.JSONObject;

public abstract class DEACModelBase
extends ModelBase3Impl
implements IDEACModeModel {
    private IDataEntity iDataEntity = null;
    private DEACMode deACMode = null;
    private String strMinorSortField = "";
    private String strMinorSortDir = "";
    private ArrayList<IDataItem> dataItemList = new ArrayList();

    @Override
    public void init(IDataEntity iDataEntity) throws Exception {
        this.setDataEntity(iDataEntity);
        this.onInit();
    }

    @Override
    public String getMinorSortField() {
        return this.strMinorSortField;
    }

    @Override
    public String getMinorSortDir() {
        return this.strMinorSortDir;
    }

    protected void setMinorSortField(String strMinorSortField) {
        this.strMinorSortField = strMinorSortField;
    }

    protected void setMinorSortDir(String strMinorSortDir) {
        this.strMinorSortDir = strMinorSortDir;
    }

    protected void initAnnotation(Class c) {
        Annotation[] annotations = c.getAnnotations();
        if (annotations != null) {
            Annotation[] annotationArray = annotations;
            int n = annotations.length;
            int n2 = 0;
            while (n2 < n) {
                Annotation annotation = annotationArray[n2];
                if (annotation instanceof DEACMode) {
                    this.prepareDEACMode((DEACMode)annotation);
                }
                ++n2;
            }
        }
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    protected void setDataEntity(IDataEntity iDataEntity) {
        this.iDataEntity = iDataEntity;
    }

    protected void prepareDEACMode(DEACMode deACMode) {
        this.deACMode = deACMode;
        DataItem[] dataItemArray = deACMode.dataitems();
        int n = dataItemArray.length;
        int n2 = 0;
        while (n2 < n) {
            DataItem dataItem = dataItemArray[n2];
            this.registerDataItem(this.createDataItem(dataItem));
            ++n2;
        }
    }

    protected void registerDataItem(IDataItem iDataItem) {
        this.dataItemList.add(iDataItem);
    }

    protected IDataItem createDataItem(DataItem dataItem) {
        DataItemModel3 dataItemModel = new DataItemModel3();
        dataItemModel.init(dataItem);
        return dataItemModel;
    }

    @Override
    public String getId() {
        return this.deACMode.id();
    }

    @Override
    public String getName() {
        return this.deACMode.name();
    }

    @Override
    public Iterator<IDataItem> getDataItems() {
        return this.dataItemList.iterator();
    }

    @Override
    public void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt, IWebContext iWebContext) throws Exception {
        if (dt.getCachedRowCount() == -1) {
            IDataRow iDataRow;
            while ((iDataRow = dt.next()) != null) {
                JSONObject jo = new JSONObject();
                for (IDataItem iDataItem : this.dataItemList) {
                    Object objValue = this.getDataItemValue(iDataItem, iDataRow, iWebContext);
                    jo.put(iDataItem.getName(), JSONObjectHelper.stripQuotes(objValue, true));
                }
                fetchResult.getRows().add(jo);
            }
        } else {
            int nRows = dt.getCachedRowCount();
            int i = 0;
            while (i < nRows) {
                IDataRow iDataRow = dt.getCachedRow(i);
                JSONObject jo = new JSONObject();
                for (IDataItem iDataItem : this.dataItemList) {
                    Object objValue = this.getDataItemValue(iDataItem, iDataRow, iWebContext);
                    jo.put(iDataItem.getName(), JSONObjectHelper.stripQuotes(objValue, true));
                }
                fetchResult.getRows().add(jo);
                ++i;
            }
        }
    }

    protected Object getDataItemValue(IDataItem iDataItem, IDataRow iDataRow, IWebContext iWebContext) throws Exception {
        return DataItemHelper.getValue2(iDataItem, iWebContext, iDataRow);
    }

    @Override
    public boolean isDefaultMode() {
        return this.deACMode.defaultmode();
    }
}

