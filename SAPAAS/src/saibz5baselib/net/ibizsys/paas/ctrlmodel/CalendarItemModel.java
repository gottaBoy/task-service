/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.control.calendar.CalendarItem;
import net.ibizsys.paas.control.calendar.ICalendarItem;
import net.ibizsys.paas.control.calendar.ICalendarItemDataItem;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.ctrlhandler.ICalendarItemFetchContext;
import net.ibizsys.paas.ctrlmodel.ICalendarItemModel;
import net.ibizsys.paas.ctrlmodel.ICalendarModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

public class CalendarItemModel
extends ModelBaseImpl
implements ICalendarItemModel {
    protected ArrayList<ICalendarItemDataItem> calendarItemDataItemList = new ArrayList();
    protected HashMap<String, ICalendarItemDataItem> calendarItemDataItemMap = new HashMap();
    private ICalendarModel iCalendarModel = null;
    private String strIconCls = "";
    private String strColor = "";
    private String strBKColor = "";
    private String strIconPath = "";
    private String strItemType = "";
    private String strDEName = "";
    private String strDEDataSetName = "";
    private String strIdField = "";
    private String strTextField = "";
    private String strIconField = "";
    private String strContentField = "";
    private String strTipsField = "";
    private String strBeginTimeField = "";
    private String strEndTimeField = "";
    private String strColorField = "";
    private String strBKColorField = "";
    private String strCreateDEActionName = "";
    private String strCreateDataAccessAction = "";
    private String strUpdateDEActionName = "";
    private String strUpdateDataAccessAction = "";
    private String strRemoveDEActionName = "";
    private String strRemoveDataAccessAction = "";
    private String strActiveDataDELogicId = null;
    private String strLevelField = "";
    private int nMaxSize = -1;

    public void init(ICalendarModel iCalendarModel) throws Exception {
        this.iCalendarModel = iCalendarModel;
        this.onInit();
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public ICalendarModel getCalendarModel() {
        return this.iCalendarModel;
    }

    @Override
    public String getColor() {
        return this.strColor;
    }

    public void setColor(String strColor) {
        this.strColor = strColor;
    }

    @Override
    public String getBKColor() {
        return this.strBKColor;
    }

    public void setBKColor(String strBKColor) {
        this.strBKColor = strBKColor;
    }

    @Override
    public String getIconCls() {
        return this.strIconCls;
    }

    public void setIconCls(String strIconCls) {
        this.strIconCls = strIconCls;
    }

    @Override
    public String getItemType() {
        return this.strItemType;
    }

    public void setItemType(String strItemType) {
        this.strItemType = strItemType;
    }

    @Override
    public String getDEName() {
        return this.strDEName;
    }

    public void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    @Override
    public String getIconPath() {
        return this.strIconPath;
    }

    public void setIconPath(String strIconPath) {
        this.strIconPath = strIconPath;
    }

    public void registerCalendarItemDataItem(ICalendarItemDataItem iCalendarItemDataItem) {
        this.calendarItemDataItemList.add(iCalendarItemDataItem);
        this.calendarItemDataItemMap.put(iCalendarItemDataItem.getName().toLowerCase(), iCalendarItemDataItem);
    }

    @Override
    public ICalendarItemDataItem getCalendarItemDataItem(String strName) throws Exception {
        ICalendarItemDataItem iCalendarItemDataItem = this.calendarItemDataItemMap.get(strName.toLowerCase());
        if (iCalendarItemDataItem == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u9879[%1$s]", strName));
        }
        return iCalendarItemDataItem;
    }

    @Override
    public Iterator<ICalendarItemDataItem> getCalendarItemDataItems() {
        return this.calendarItemDataItemList.iterator();
    }

    @Override
    public String getDEDataSetName() {
        return this.strDEDataSetName;
    }

    @Override
    public String getIdField() {
        return this.strIdField;
    }

    @Override
    public String getTextField() {
        return this.strTextField;
    }

    @Override
    public String getIconField() {
        return this.strIconField;
    }

    @Override
    public String getContentField() {
        return this.strContentField;
    }

    public void setDEDataSetName(String strDEDataSetName) {
        this.strDEDataSetName = strDEDataSetName;
    }

    public void setIdField(String strIdField) {
        this.strIdField = strIdField;
    }

    public void setTextField(String strTextField) {
        this.strTextField = strTextField;
    }

    public void setIconField(String strIconField) {
        this.strIconField = strIconField;
    }

    public void setContentField(String strContentField) {
        this.strContentField = strContentField;
    }

    @Override
    public void fillFetchResult(ICalendarItemFetchContext iCalendarItemFetchContext, ArrayList<ICalendarItem> calendarItemList, IDataTable dt) throws Exception {
        CalendarItemModel.fillFetchResult(this, iCalendarItemFetchContext, calendarItemList, dt);
    }

    public static void fillFetchResult(ICalendarItemModel iCalendarItemModel, ICalendarItemFetchContext iCalendarItemFetchContext, ArrayList<ICalendarItem> calendarItemList, IDataTable dt) throws Exception {
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(iCalendarItemModel.getDEName());
        String strIdField = iDataEntityModel.getKeyDEField().getName();
        if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getIdField())) {
            strIdField = iDataEntityModel.getDEField(iCalendarItemModel.getIdField(), false).getName();
        }
        String strTextField = iDataEntityModel.getMajorDEField().getName();
        if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getTextField())) {
            strTextField = iDataEntityModel.getDEField(iCalendarItemModel.getTextField(), false).getName();
        }
        String strContentField = "";
        if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getContentField())) {
            strContentField = iDataEntityModel.getDEField(iCalendarItemModel.getContentField(), false).getName();
        }
        String strTipsField = "";
        if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getTipsField())) {
            strTipsField = iDataEntityModel.getDEField(iCalendarItemModel.getTipsField(), false).getName();
        }
        String strIconField = "";
        if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getIconField())) {
            strIconField = iDataEntityModel.getDEField(iCalendarItemModel.getIconField(), false).getName();
        }
        String strBeginTimeField = "";
        if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getBeginTimeField())) {
            strBeginTimeField = iDataEntityModel.getDEField(iCalendarItemModel.getBeginTimeField(), false).getName();
        }
        String strEndTimeField = "";
        if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getEndTimeField())) {
            strEndTimeField = iDataEntityModel.getDEField(iCalendarItemModel.getEndTimeField(), false).getName();
        }
        String strColorField = "";
        if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getColorField())) {
            strColorField = iDataEntityModel.getDEField(iCalendarItemModel.getColorField(), false).getName();
        }
        String strBKColorField = "";
        if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getBKColorField())) {
            strBKColorField = iDataEntityModel.getDEField(iCalendarItemModel.getBKColorField(), false).getName();
        }
        if (dt.getCachedRowCount() == -1) {
            IDataRow iDataRow;
            while ((iDataRow = dt.next()) != null) {
                CalendarItem calendarItem = new CalendarItem();
                CalendarItemModel.fillCalendarItem(calendarItem, iCalendarItemModel, iCalendarItemFetchContext, iDataRow, strIdField, strTextField, strContentField, strTipsField, strBeginTimeField, strEndTimeField, strIconField, strColorField, strBKColorField);
                calendarItemList.add(calendarItem);
            }
        } else {
            int nRows = dt.getCachedRowCount();
            int i = 0;
            while (i < nRows) {
                IDataRow iDataRow = dt.getCachedRow(i);
                CalendarItem calendarItem = new CalendarItem();
                CalendarItemModel.fillCalendarItem(calendarItem, iCalendarItemModel, iCalendarItemFetchContext, iDataRow, strIdField, strTextField, strContentField, strTipsField, strBeginTimeField, strEndTimeField, strIconField, strColorField, strBKColorField);
                calendarItemList.add(calendarItem);
                ++i;
            }
        }
    }

    public static void fillCalendarItem(CalendarItem calendarItem, ICalendarItemModel iCalendarItemModel, ICalendarItemFetchContext iCalendarItemFetchContext, ISimpleDataObject iDataRow, String strIdField, String strTextField, String strContentField, String strTipsField, String strBeginTimeField, String strEndTimeField, String strIconField, String strColorField, String strBKColorField) throws Exception {
        String strNodeId = iCalendarItemModel.getItemType();
        if (StringHelper.isNullOrEmpty(strNodeId)) {
            strNodeId = iCalendarItemModel.getId();
        }
        strNodeId = String.valueOf(strNodeId) + ";";
        if (!StringHelper.isNullOrEmpty(strIdField)) {
            strNodeId = String.valueOf(strNodeId) + (String)iDataRow.get(strIdField);
        }
        calendarItem.setId(strNodeId);
        calendarItem.setItemType(iCalendarItemModel.getItemType());
        if (!StringHelper.isNullOrEmpty(strTextField)) {
            calendarItem.setText((String)iDataRow.get(strTextField));
        }
        if (!StringHelper.isNullOrEmpty(strContentField)) {
            calendarItem.setContent((String)iDataRow.get(strContentField));
        }
        if (!StringHelper.isNullOrEmpty(strTipsField)) {
            calendarItem.setTips((String)iDataRow.get(strTipsField));
        }
        if (!StringHelper.isNullOrEmpty(strBeginTimeField)) {
            calendarItem.setBeginTime(DataObject.getTimestampValue(iDataRow.get(strBeginTimeField)));
        }
        if (!StringHelper.isNullOrEmpty(strEndTimeField)) {
            calendarItem.setEndTime(DataObject.getTimestampValue(iDataRow.get(strEndTimeField)));
        }
        if (!StringHelper.isNullOrEmpty(strColorField)) {
            calendarItem.setColor((String)iDataRow.get(strColorField));
        }
        if (StringHelper.isNullOrEmpty(calendarItem.getColor())) {
            calendarItem.setColor(iCalendarItemModel.getColor());
        }
        if (!StringHelper.isNullOrEmpty(strBKColorField)) {
            calendarItem.setBKColor((String)iDataRow.get(strBKColorField));
        }
        if (StringHelper.isNullOrEmpty(calendarItem.getBKColor())) {
            calendarItem.setBKColor(iCalendarItemModel.getBKColor());
        }
        if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getIconCls())) {
            calendarItem.setIconCssClass(iCalendarItemModel.getIconCls());
        } else {
            String strIconPath = "";
            if (!StringHelper.isNullOrEmpty(strIconField)) {
                strIconPath = (String)iDataRow.get(strIconField);
            }
            if (StringHelper.isNullOrEmpty(strIconPath)) {
                strIconPath = iCalendarItemModel.getIconPath();
            }
            if (!StringHelper.isNullOrEmpty(strIconPath)) {
                calendarItem.setIcon(iCalendarItemModel.getCalendarModel().getViewController().getAppModel().getAppPFHelper().mapImageRealUrl(strIconPath));
            }
        }
        calendarItem.setTagValue("srfkey", iDataRow.get(strIdField));
        calendarItem.setTagValue("srfmajortext", iDataRow.get(strTextField));
        Iterator<ICalendarItemDataItem> calendarItemDataItems = iCalendarItemModel.getCalendarItemDataItems();
        if (calendarItemDataItems != null) {
            while (calendarItemDataItems.hasNext()) {
                ICalendarItemDataItem iCalendarItemDataItem = calendarItemDataItems.next();
                Object objValue = iCalendarItemDataItem.getValue(WebContext.getCurrent(), iDataRow);
                calendarItem.setTagValue(iCalendarItemDataItem.getName(), objValue);
            }
        }
        calendarItem.setDataSource(iDataRow);
    }

    @Override
    public String getBeginTimeField() {
        return this.strBeginTimeField;
    }

    public void setBeginTimeField(String strBeginTimeField) {
        this.strBeginTimeField = strBeginTimeField;
    }

    @Override
    public String getCreateDEActionName() {
        return this.strCreateDEActionName;
    }

    public void setCreateDEActionName(String strCreateDEActionName) {
        this.strCreateDEActionName = strCreateDEActionName;
    }

    @Override
    public String getCreateDataAccessAction() {
        return this.strCreateDataAccessAction;
    }

    public void setCreateDataAccessAction(String strCreateDataAccessAction) {
        this.strCreateDataAccessAction = strCreateDataAccessAction;
    }

    @Override
    public String getUpdateDEActionName() {
        return this.strUpdateDEActionName;
    }

    public void setUpdateDEActionName(String strUpdateDEActionName) {
        this.strUpdateDEActionName = strUpdateDEActionName;
    }

    @Override
    public String getUpdateDataAccessAction() {
        return this.strUpdateDataAccessAction;
    }

    public void setUpdateDataAccessAction(String strUpdateDataAccessAction) {
        this.strUpdateDataAccessAction = strUpdateDataAccessAction;
    }

    @Override
    public String getRemoveDEActionName() {
        return this.strRemoveDEActionName;
    }

    public void setRemoveDEActionName(String strRemoveDEActionName) {
        this.strRemoveDEActionName = strRemoveDEActionName;
    }

    @Override
    public String getRemoveDataAccessAction() {
        return this.strRemoveDataAccessAction;
    }

    public void setRemoveDataAccessAction(String strRemoveDataAccessAction) {
        this.strRemoveDataAccessAction = strRemoveDataAccessAction;
    }

    @Override
    public String getActiveDataDELogicId() {
        return this.strActiveDataDELogicId;
    }

    public void setActiveDataDELogicId(String strActiveDataDELogicId) {
        this.strActiveDataDELogicId = strActiveDataDELogicId;
    }

    @Override
    public String getEndTimeField() {
        return this.strEndTimeField;
    }

    public void setEndTimeField(String strEndTimeField) {
        this.strEndTimeField = strEndTimeField;
    }

    @Override
    public String getColorField() {
        return this.strColorField;
    }

    public void setColorField(String strColorField) {
        this.strColorField = strColorField;
    }

    @Override
    public String getBKColorField() {
        return this.strBKColorField;
    }

    public void setBKColorField(String strBKColorField) {
        this.strBKColorField = strBKColorField;
    }

    @Override
    public int getMaxSize() {
        return this.nMaxSize;
    }

    public void setMaxSize(int nMaxSize) {
        this.nMaxSize = nMaxSize;
    }

    @Override
    public String getTipsField() {
        return this.strTipsField;
    }

    public void setTipsField(String strTipsField) {
        this.strTipsField = strTipsField;
    }

    @Override
    public String getLevelField() {
        return this.strLevelField;
    }

    public void setLevelField(String strLevelField) {
        this.strLevelField = strLevelField;
    }

    @Override
    public void fillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception {
        if (iDataObject == null) {
            throw new Exception(StringHelper.format("\u6570\u636e\u5bf9\u8c61\u65e0\u6548"));
        }
        IWebContext iWebContext = this.getCalendarModel().getViewController().getWebContext();
        String strText = iWebContext.getPostValue("text");
        String strContent = iWebContext.getPostValue("content");
        String strBeginTime = iWebContext.getPostValue("begintime");
        String strEndTime = iWebContext.getPostValue("endtime");
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(this.getDEName());
        String strTextField = iDataEntityModel.getMajorDEField().getName();
        if (!StringHelper.isNullOrEmpty(this.getTextField())) {
            strTextField = iDataEntityModel.getDEField(this.getTextField(), false).getName();
        }
        String strContentField = "";
        if (!StringHelper.isNullOrEmpty(this.getContentField())) {
            strContentField = iDataEntityModel.getDEField(this.getContentField(), false).getName();
        }
        String strBeginTimeField = "";
        if (!StringHelper.isNullOrEmpty(this.getBeginTimeField())) {
            strBeginTimeField = iDataEntityModel.getDEField(this.getBeginTimeField(), false).getName();
        }
        String strEndTimeField = "";
        if (!StringHelper.isNullOrEmpty(this.getEndTimeField())) {
            strEndTimeField = iDataEntityModel.getDEField(this.getEndTimeField(), false).getName();
        }
        if (!(StringHelper.isNullOrEmpty(strTextField) || strText == null && bIgnoreEmpty)) {
            iDataObject.set(strTextField, strText);
        }
        if (!(StringHelper.isNullOrEmpty(strContentField) || strContent == null && bIgnoreEmpty)) {
            iDataObject.set(strContentField, strContent);
        }
        if (!(StringHelper.isNullOrEmpty(strBeginTimeField) || strBeginTime == null && bIgnoreEmpty)) {
            iDataObject.set(strBeginTimeField, strBeginTime);
        }
        if (!(StringHelper.isNullOrEmpty(strEndTimeField) || strEndTime == null && bIgnoreEmpty)) {
            iDataObject.set(strEndTimeField, strEndTime);
        }
    }

    @Override
    public ICalendarItem getCalendarItem(IDataObject iDataObject, boolean bUpdate) throws Exception {
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(this.getDEName());
        String strIdField = iDataEntityModel.getKeyDEField().getName();
        if (!StringHelper.isNullOrEmpty(this.getIdField())) {
            strIdField = iDataEntityModel.getDEField(this.getIdField(), false).getName();
        }
        String strTextField = iDataEntityModel.getMajorDEField().getName();
        if (!StringHelper.isNullOrEmpty(this.getTextField())) {
            strTextField = iDataEntityModel.getDEField(this.getTextField(), false).getName();
        }
        String strContentField = "";
        if (!StringHelper.isNullOrEmpty(this.getContentField())) {
            strContentField = iDataEntityModel.getDEField(this.getContentField(), false).getName();
        }
        String strTipsField = "";
        if (!StringHelper.isNullOrEmpty(this.getTipsField())) {
            strTipsField = iDataEntityModel.getDEField(this.getTipsField(), false).getName();
        }
        String strIconField = "";
        if (!StringHelper.isNullOrEmpty(this.getIconField())) {
            strIconField = iDataEntityModel.getDEField(this.getIconField(), false).getName();
        }
        String strBeginTimeField = "";
        if (!StringHelper.isNullOrEmpty(this.getBeginTimeField())) {
            strBeginTimeField = iDataEntityModel.getDEField(this.getBeginTimeField(), false).getName();
        }
        String strEndTimeField = "";
        if (!StringHelper.isNullOrEmpty(this.getEndTimeField())) {
            strEndTimeField = iDataEntityModel.getDEField(this.getEndTimeField(), false).getName();
        }
        String strColorField = "";
        if (!StringHelper.isNullOrEmpty(this.getColorField())) {
            strColorField = iDataEntityModel.getDEField(this.getColorField(), false).getName();
        }
        String strBKColorField = "";
        if (!StringHelper.isNullOrEmpty(this.getBKColorField())) {
            strBKColorField = iDataEntityModel.getDEField(this.getBKColorField(), false).getName();
        }
        CalendarItem calendarItem = new CalendarItem();
        CalendarItemModel.fillCalendarItem(calendarItem, this, null, iDataObject, strIdField, strTextField, strContentField, strTipsField, strBeginTimeField, strEndTimeField, strIconField, strColorField, strBKColorField);
        return calendarItem;
    }
}

