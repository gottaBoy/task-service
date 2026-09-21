/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.Util.PSDevSlnSysModelStorage;
import java.util.List;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;

public class PSDevSlnSysModelStorage3
extends PSDevSlnSysModelStorage {
    public PSDevSlnSysModelStorage3(PSDevSlnSys psDevSlnSys) throws Exception {
        super(psDevSlnSys);
    }

    @Override
    protected void prepareModelList(List<String> modelList) {
        super.prepareModelList(modelList);
        modelList.add("PSDEDATASET");
        modelList.add("PSDEACTION");
        modelList.add("PSDEOPPRIV");
        modelList.add("PSSUBSYSSERVICEAPI");
        modelList.add("PSSUBSYSSADE");
        modelList.add("PSSUBSYSSADERS");
        modelList.add("PSSUBSYSSADETAIL");
        modelList.add("PSDEFSFITEM");
        modelList.add("PSDEACTIONPARAM");
    }
}

