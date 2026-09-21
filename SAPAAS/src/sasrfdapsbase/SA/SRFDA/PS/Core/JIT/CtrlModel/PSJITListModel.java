/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.list.IList
 *  net.ibizsys.paas.control.list.IListDataItem
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.ListDataItemModel
 *  net.ibizsys.paas.ctrlmodel.ListModelBase
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.data.IDataItemParam
 *  net.ibizsys.paas.datamodel.DataItemParamModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.JIT.CtrlModel;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.List.IPSDEList;
import SA.SRFDA.PS.Core.Control.List.IPSListDataItem;
import SA.SRFDA.PS.Core.Data.IPSDataItemParam;
import SA.SRFDA.PS.Core.JIT.CtrlModel.IPSJITCtrlModel;
import java.util.Iterator;
import net.ibizsys.paas.control.list.IList;
import net.ibizsys.paas.control.list.IListDataItem;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.ListDataItemModel;
import net.ibizsys.paas.ctrlmodel.ListModelBase;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.datamodel.DataItemParamModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;

public class PSJITListModel
extends ListModelBase
implements IPSJITCtrlModel {
    private IPSControl iPSControl = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDEList getPSDEList() {
        return (IPSDEList)this.getPSControl();
    }

    public IDataEntityModel getDEModel() {
        try {
            if (this.getPSControl().getPSDataEntity() != null) {
                return this.getViewController().getSystemModel().getDataEntityModel(this.getPSControl().getPSDataEntity().getName());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return super.getDEModel();
    }

    protected void onInit() throws Exception {
        if (this.getPSDEList().getPagingSize() > 0) {
            this.setPageSize(this.getPSDEList().getPagingSize());
        }
        super.onInit();
    }

    protected void prepareListDataItemModels() throws Exception {
        super.prepareListDataItemModels();
        ListDataItemModel iListDataItem = null;
        Iterator listDataItems = this.getPSDEList().getListDataItems();
        while (listDataItems.hasNext()) {
            IPSListDataItem iListDataItem2 = (IPSListDataItem)listDataItems.next();
            iListDataItem = null;
            if (iListDataItem == null) {
                ListDataItemModel listDataItemModel = new ListDataItemModel();
                listDataItemModel.setName(iListDataItem2.getName());
                listDataItemModel.setDataType(iListDataItem2.getDataType());
                if (!StringHelper.isNullOrEmpty((String)iListDataItem2.getFormat())) {
                    listDataItemModel.setFormat(iListDataItem2.getFormat());
                }
                if (iListDataItem2.getPSCodeList() != null) {
                    listDataItemModel.setCodeListId(iListDataItem2.getPSCodeList().getId());
                }
                if (iListDataItem2.getDataItemParams() != null) {
                    IDataItemParam[] iDataItemParamArray = iListDataItem2.getDataItemParams();
                    int n = iDataItemParamArray.length;
                    int n2 = 0;
                    while (n2 < n) {
                        IDataItemParam iDataItemParam2 = iDataItemParamArray[n2];
                        IPSDataItemParam iDataItemParam = (IPSDataItemParam)iDataItemParam2;
                        DataItemParamModel dataItemParam = new DataItemParamModel();
                        if (!StringHelper.isNullOrEmpty((String)iDataItemParam.getName())) {
                            dataItemParam.setName(iDataItemParam.getName());
                        }
                        if (!StringHelper.isNullOrEmpty((String)iDataItemParam.getFormat())) {
                            dataItemParam.setFormat(iDataItemParam.getFormat());
                        }
                        dataItemParam.setDataItem((IDataItem)listDataItemModel);
                        if (iDataItemParam.getPSCodeList() != null && StringHelper.compare((String)iDataItemParam.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)false) == 0) {
                            dataItemParam.setCodeListId(iDataItemParam.getPSCodeList().getId());
                        }
                        listDataItemModel.addDataItemParam((IDataItemParam)dataItemParam);
                        ++n2;
                    }
                }
                listDataItemModel.init((IList)this);
                iListDataItem = listDataItemModel;
            }
            this.registerListDataItem((IListDataItem)iListDataItem);
        }
    }
}

