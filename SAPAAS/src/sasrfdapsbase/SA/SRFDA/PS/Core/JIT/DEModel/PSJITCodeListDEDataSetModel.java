/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.demodel.CodeListDEDataSetModelBase
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDEModel;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.demodel.CodeListDEDataSetModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;

public class PSJITCodeListDEDataSetModel
extends CodeListDEDataSetModelBase {
    private IPSJITDEModel iPSJITDEModel = null;
    private IPSDEDataSet iPSDEDataSet = null;

    public void init(IPSJITDEModel iPSJITDEModel, IPSDEDataSet iPSDEDataSet) throws Exception {
        this.iPSJITDEModel = iPSJITDEModel;
        this.iPSDEDataSet = iPSDEDataSet;
        this.init((IDataEntity)iPSJITDEModel);
    }

    public String getId() {
        return this.iPSDEDataSet.getId();
    }

    public String getName() {
        return this.iPSDEDataSet.getName();
    }

    protected ICodeList getCodeList() throws Exception {
        IPSDataEntity ipsDataEntity = this.iPSJITDEModel.getPSDataEntity();
        if (StringHelper.compare((String)this.iPSDEDataSet.getPredefinedType(), (String)"INDEXDE", (boolean)true) == 0 && ipsDataEntity.getIndexTypePSDEField() != null && ipsDataEntity.getIndexTypePSDEField().getPSCodeList() != null) {
            return CodeListGlobal.getCodeList((String)ipsDataEntity.getIndexTypePSDEField().getPSCodeList().getId());
        }
        if (StringHelper.compare((String)this.iPSDEDataSet.getPredefinedType(), (String)"MULTIFORM", (boolean)true) == 0 && ipsDataEntity.getFormTypePSDEField() != null && ipsDataEntity.getFormTypePSDEField().getPSCodeList() != null) {
            return CodeListGlobal.getCodeList((String)ipsDataEntity.getFormTypePSDEField().getPSCodeList().getId());
        }
        if (StringHelper.compare((String)this.iPSDEDataSet.getPredefinedType(), (String)"CODELIST", (boolean)true) == 0 && this.iPSDEDataSet.getPSCodeList() != null) {
            return CodeListGlobal.getCodeList((String)this.iPSDEDataSet.getPSCodeList().getId());
        }
        return null;
    }
}

