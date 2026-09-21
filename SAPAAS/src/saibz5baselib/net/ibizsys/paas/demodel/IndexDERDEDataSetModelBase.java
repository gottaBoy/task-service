/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.impl.SimpleDataRowImpl;
import net.ibizsys.paas.demodel.PredefinedDEDataSetModelBase;
import net.ibizsys.paas.util.StringHelper;

public abstract class IndexDERDEDataSetModelBase
extends PredefinedDEDataSetModelBase {
    protected abstract ICodeList getCodeList() throws Exception;

    @Override
    protected void onFillDataRowList(ArrayList<IDataRow> dataRowList) throws Exception {
        IViewController iViewController = ViewController.getCurrent();
        Iterator<ICodeItem> codeItems = this.getCodeList().getCodeItems();
        while (codeItems.hasNext()) {
            ICodeItem iCodeItem = codeItems.next();
            SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
            simpleDataRowImpl.set("srfmajortext", iCodeItem.getRealText());
            simpleDataRowImpl.set("srfkey", iCodeItem.getValue());
            simpleDataRowImpl.set("srfcolor", iCodeItem.getColor());
            if (iViewController != null) {
                simpleDataRowImpl.set("srficonpath", iViewController.getAppModel().getAppPFHelper().mapImageRealUrl(iCodeItem.getIconPath()));
            } else {
                simpleDataRowImpl.set("srficonpath", iCodeItem.getIconPath());
            }
            simpleDataRowImpl.set("srficoncls", iCodeItem.getIconCls());
            int i = 2;
            while (i <= 4) {
                if (iViewController != null) {
                    simpleDataRowImpl.set(StringHelper.format("srficonpath%1$s", i), iViewController.getAppModel().getAppPFHelper().mapImageRealUrl(iCodeItem.getIconPath(i)));
                } else {
                    simpleDataRowImpl.set(StringHelper.format("srficonpath%1$s", i), iCodeItem.getIconPath(i));
                }
                simpleDataRowImpl.set(StringHelper.format("srficoncls%1$s", i), iCodeItem.getIconCls(i));
                ++i;
            }
            simpleDataRowImpl.set("srfmemo", iCodeItem.getMemo());
            simpleDataRowImpl.set(this.getDataEntity().getKeyDEField().getName().toLowerCase(), iCodeItem.getValue());
            if (this.getDataEntity().getMajorDEField() != null) {
                simpleDataRowImpl.set(this.getDataEntity().getMajorDEField().getName().toLowerCase(), iCodeItem.getRealText());
            }
            dataRowList.add(simpleDataRowImpl);
        }
    }
}

