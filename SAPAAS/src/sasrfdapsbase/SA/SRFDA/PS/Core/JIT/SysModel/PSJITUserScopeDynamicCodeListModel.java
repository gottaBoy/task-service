/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.UserScopeDynamicCodeListModelBase
 */
package SA.SRFDA.PS.Core.JIT.SysModel;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITCodeListModel;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import net.ibizsys.paas.sysmodel.UserScopeDynamicCodeListModelBase;

public class PSJITUserScopeDynamicCodeListModel
extends UserScopeDynamicCodeListModelBase
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
    }
}

