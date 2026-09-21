/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeItem
 *  net.ibizsys.paas.sysmodel.CodeItemModel
 */
package SA.SRFDA.PS.Core.JIT.SysModel;

import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITCodeListModel;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.sysmodel.CodeItemModel;

public class PSJITCodeItemModel
extends CodeItemModel {
    private IPSJITCodeListModel iPSJITCodeListModel = null;
    private IPSCodeItem iPSCodeItem = null;
    private ICodeItem parentCodeItem = null;

    public void init(IPSJITCodeListModel iPSJITCodeListModel, ICodeItem parentCodeItem, IPSCodeItem iPSCodeItem) throws Exception {
        this.iPSJITCodeListModel = iPSJITCodeListModel;
        this.iPSCodeItem = iPSCodeItem;
        this.parentCodeItem = parentCodeItem;
        if (iPSCodeItem != null) {
            this.setRealText(iPSCodeItem.getRealText());
            this.setText(iPSCodeItem.getText());
            this.setValue(iPSCodeItem.getValue());
            this.setParentValue(iPSCodeItem.getParentValue());
            this.setTextCls(iPSCodeItem.getTextCls());
            this.setIconCls(iPSCodeItem.getIconCls());
            this.setIconClsX(iPSCodeItem.getIconClsX());
            this.setIconPath(iPSCodeItem.getIconPath());
            this.setIconPathX(iPSCodeItem.getIconPathX());
            this.setUserData(iPSCodeItem.getUserData());
            this.setUserData2(iPSCodeItem.getUserData2());
        }
    }
}

