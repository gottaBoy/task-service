/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataExport
 *  net.ibizsys.paas.core.IDEDataExportItem
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.data.IDataItemParam
 *  net.ibizsys.paas.datamodel.DataItemParamModel
 *  net.ibizsys.paas.demodel.DEDataExportItemModel
 *  net.ibizsys.paas.demodel.DEDataExportModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pslanguageitem.dataexport;

import net.ibizsys.paas.core.IDEDataExport;
import net.ibizsys.paas.core.IDEDataExportItem;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.datamodel.DataItemParamModel;
import net.ibizsys.paas.demodel.DEDataExportItemModel;
import net.ibizsys.paas.demodel.DEDataExportModelBase;

public abstract class PSLanguageItemDefaultDataExportModelBase
extends DEDataExportModelBase {
    public PSLanguageItemDefaultDataExportModelBase() {
        this.setId("E1AE0BB9-F277-4E35-A813-D3CC089B50BE");
        this.setName("Default");
    }

    protected void prepareDEDataExportItemModels() throws Exception {
        DataItemParamModel dataItemParamModel;
        DEDataExportItemModel dEDataExportItemModel;
        IDEDataExportItem iDEDataExportItem = null;
        iDEDataExportItem = this.createDEDataExportItem("pslanguageitemname");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("pslanguageitemname");
            dEDataExportItemModel.setCaption("\u8bed\u8a00\u5b9a\u4e49\u9879\u6807\u8bc6");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("PSLANGUAGEITEMNAME");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("pslanguagename");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("pslanguagename");
            dEDataExportItemModel.setCaption("\u8bed\u8a00");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("PSLANGUAGENAME");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("psmodulename");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("psmodulename");
            dEDataExportItemModel.setCaption("\u7cfb\u7edf\u6a21\u5757");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("PSMODULENAME");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("pslanguageresname");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("pslanguageresname");
            dEDataExportItemModel.setCaption("\u8bed\u8a00\u8d44\u6e90");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("PSLANGUAGERESNAME");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("lanrestag");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("lanrestag");
            dEDataExportItemModel.setCaption("\u8bed\u8a00\u8d44\u6e90\u6807\u8bc6");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("LANRESTAG");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("defcontent");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("defcontent");
            dEDataExportItemModel.setCaption("\u9ed8\u8ba4\u5185\u5bb9");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("DEFCONTENT");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("content");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("content");
            dEDataExportItemModel.setCaption("\u5185\u5bb9");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("CONTENT");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("memo");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("memo");
            dEDataExportItemModel.setCaption("\u5907\u6ce8");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("MEMO");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("updateman");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("updateman");
            dEDataExportItemModel.setCaption("\u66f4\u65b0\u4eba");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("UPDATEMAN");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dataItemParamModel.setCodeListId("0d24b61528cddc9996607e38caaa347b");
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("updatedate");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("updatedate");
            dEDataExportItemModel.setCaption("\u66f4\u65b0\u65f6\u95f4");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("UPDATEDATE");
            dataItemParamModel.setFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
    }
}

