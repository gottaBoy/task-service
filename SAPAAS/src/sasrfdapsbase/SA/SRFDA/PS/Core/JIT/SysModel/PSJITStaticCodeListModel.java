/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeItem
 *  net.ibizsys.paas.sysmodel.CodeItemModel
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.JIT.SysModel;

import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITCodeListModel;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.PS.Core.JIT.SysModel.PSJITCodeItemModel;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.sysmodel.CodeItemModel;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;
import net.ibizsys.paas.util.StringHelper;

public class PSJITStaticCodeListModel
extends StaticCodeListModelBase
implements IPSJITCodeListModel {
    private IPSJITSystemModel iPSJITSystemModel = null;
    private IPSCodeList iPSCodeList = null;

    public void init(IPSJITSystemModel iPSJITSystemModel, IPSCodeList iPSCodeList) throws Exception {
        this.iPSJITSystemModel = iPSJITSystemModel;
        this.iPSCodeList = iPSCodeList;
        this.prepareCodeItems();
        this.iPSJITSystemModel.registerCodeListModel(this);
    }

    @Override
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    public IPSJITSystemModel getPSJITSystemModel() {
        return this.iPSJITSystemModel;
    }

    public String getId() {
        return this.getPSCodeList().getId();
    }

    public String getName() {
        return this.getPSCodeList().getName();
    }

    public String getCodeListType() {
        return this.getPSCodeList().getCodeListType();
    }

    public boolean isUserScope() {
        return this.getPSCodeList().isUserScope();
    }

    public String getOrMode() {
        return this.getPSCodeList().getOrMode();
    }

    public String getValueSeparator() {
        return this.getPSCodeList().getValueSeparator();
    }

    public String getTextSeparator() {
        return this.getPSCodeList().getTextSeparator();
    }

    public String getEmptyText() {
        return this.getPSCodeList().getEmptyText();
    }

    protected void prepareCodeItems() throws Exception {
        Iterator<IPSCodeItem> psCodeItems = this.getPSCodeList().getPSCodeItems();
        if (psCodeItems != null) {
            while (psCodeItems.hasNext()) {
                IPSCodeItem iPSCodeItem = psCodeItems.next();
                CodeItemModel codeItemModel = this.createCodeItemModel(iPSCodeItem);
                this.registerCodeItemModel(codeItemModel);
            }
        }
    }

    protected CodeItemModel createCodeItemModel(IPSCodeItem iPSCodeItem) throws Exception {
        PSJITCodeItemModel codeItemModel = new PSJITCodeItemModel();
        if (StringHelper.isNullOrEmpty((String)iPSCodeItem.getParentValue())) {
            codeItemModel.init(this, null, iPSCodeItem);
        } else {
            codeItemModel.init(this, (ICodeItem)this.getCodeItemModel(iPSCodeItem.getParentValue()), iPSCodeItem);
        }
        return codeItemModel;
    }
}

