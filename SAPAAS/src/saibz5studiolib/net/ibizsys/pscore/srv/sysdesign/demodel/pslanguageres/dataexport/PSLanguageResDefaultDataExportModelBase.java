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
package net.ibizsys.pscore.srv.sysdesign.demodel.pslanguageres.dataexport;

import net.ibizsys.paas.core.IDEDataExport;
import net.ibizsys.paas.core.IDEDataExportItem;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.datamodel.DataItemParamModel;
import net.ibizsys.paas.demodel.DEDataExportItemModel;
import net.ibizsys.paas.demodel.DEDataExportModelBase;

public abstract class PSLanguageResDefaultDataExportModelBase
extends DEDataExportModelBase {
    public PSLanguageResDefaultDataExportModelBase() {
        this.setId("27D0268B-CC1E-4818-9EF6-EDBA7A4F3E7B");
        this.setName("Default");
    }

    protected void prepareDEDataExportItemModels() throws Exception {
        DataItemParamModel dataItemParamModel;
        DEDataExportItemModel dEDataExportItemModel;
        IDEDataExportItem iDEDataExportItem = null;
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
        iDEDataExportItem = this.createDEDataExportItem("pslanguageresname");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("pslanguageresname");
            dEDataExportItemModel.setCaption("\u8d44\u6e90\u540d\u79f0");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("PSLANGUAGERESNAME");
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
        iDEDataExportItem = this.createDEDataExportItem("lanrestype");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("lanrestype");
            dEDataExportItemModel.setCaption("\u8d44\u6e90\u7c7b\u578b");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("LANRESTYPE");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dataItemParamModel.setCodeListId("8d3b4c9afc144220b6ca8822295511dd");
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("userdata");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("userdata");
            dEDataExportItemModel.setCaption("\u7528\u6237\u6807\u8bc6");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("USERDATA");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("codename");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("codename");
            dEDataExportItemModel.setCaption("\u4ee3\u7801\u6807\u8bc6");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("CODENAME");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("shorttag");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("shorttag");
            dEDataExportItemModel.setCaption("\u77ed\u6807\u8bc6");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("SHORTTAG");
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
        iDEDataExportItem = this.createDEDataExportItem("psdename");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("psdename");
            dEDataExportItemModel.setCaption("\u5b9e\u4f53");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("PSDENAME");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("pslanitemscnt");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("pslanitemscnt");
            dEDataExportItemModel.setCaption("\u8bed\u8a00\u9879\u8ba1\u6570");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("PSLANITEMSCNT");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("apprefflag");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("apprefflag");
            dEDataExportItemModel.setCaption("\u5e94\u7528\u5f15\u7528\u6807\u8bb0");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("APPREFFLAG");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dataItemParamModel.setCodeListId("ef840879ae68b1f9c3fbf21c7abdf0f9");
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

