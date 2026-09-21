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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdmitemlog.dataexport;

import net.ibizsys.paas.core.IDEDataExport;
import net.ibizsys.paas.core.IDEDataExportItem;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.datamodel.DataItemParamModel;
import net.ibizsys.paas.demodel.DEDataExportItemModel;
import net.ibizsys.paas.demodel.DEDataExportModelBase;

public abstract class PSSysDMItemLogFullDataExportModelBase
extends DEDataExportModelBase {
    public PSSysDMItemLogFullDataExportModelBase() {
        this.setId("55DBC825-8B0F-467B-BC41-52561C8B150F");
        this.setName("Full");
    }

    protected void prepareDEDataExportItemModels() throws Exception {
        DataItemParamModel dataItemParamModel;
        DEDataExportItemModel dEDataExportItemModel;
        IDEDataExportItem iDEDataExportItem = null;
        iDEDataExportItem = this.createDEDataExportItem("pssystemdbcfgname");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("pssystemdbcfgname");
            dEDataExportItemModel.setCaption("\u7cfb\u7edf\u6570\u636e\u5e93");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("PSSYSTEMDBCFGNAME");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dataItemParamModel.setCodeListId("A335BC40-8D49-42A5-9087-A8749CD87732");
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("pssysdmitemlogname");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("pssysdmitemlogname");
            dEDataExportItemModel.setCaption("\u5bf9\u8c61\u540d\u79f0");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("PSSYSDMITEMLOGNAME");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("dbobjtype");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("dbobjtype");
            dEDataExportItemModel.setCaption("\u5bf9\u8c61\u7c7b\u578b");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("DBOBJTYPE");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dataItemParamModel.setCodeListId("57947d48899296a511a4d188cae75a53");
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
        iDEDataExportItem = this.createDEDataExportItem("psobjname");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("psobjname");
            dEDataExportItemModel.setCaption("\u6a21\u578b\u540d\u79f0");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("PSOBJNAME");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("newsql");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("newsql");
            dEDataExportItemModel.setCaption("\u5f53\u524dSQL");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("NEWSQL");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("oldsql");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("oldsql");
            dEDataExportItemModel.setCaption("\u539f\u6709SQL");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("OLDSQL");
            dataItemParamModel.setFormat("%1$s");
            dataItemParamModel.setDataItem((IDataItem)dEDataExportItemModel);
            dEDataExportItemModel.addDataItemParam((IDataItemParam)dataItemParamModel);
            dEDataExportItemModel.init((IDEDataExport)this);
            iDEDataExportItem = dEDataExportItemModel;
        }
        this.registerDEDataExportItem(iDEDataExportItem);
        iDEDataExportItem = this.createDEDataExportItem("fixsql");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("fixsql");
            dEDataExportItemModel.setCaption("\u4fee\u590dSQL");
            dataItemParamModel = new DataItemParamModel();
            dataItemParamModel.setName("FIXSQL");
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
        iDEDataExportItem = this.createDEDataExportItem("updatedate");
        if (iDEDataExportItem == null) {
            dEDataExportItemModel = new DEDataExportItemModel();
            dEDataExportItemModel.setName("updatedate");
            dEDataExportItemModel.setCaption("\u53d8\u66f4\u65f6\u95f4");
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

