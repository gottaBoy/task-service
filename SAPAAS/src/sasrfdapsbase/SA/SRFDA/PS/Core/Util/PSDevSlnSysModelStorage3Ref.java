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

public class PSDevSlnSysModelStorage3Ref
extends PSDevSlnSysModelStorage {
    public PSDevSlnSysModelStorage3Ref(PSDevSlnSys psDevSlnSys) throws Exception {
        super(psDevSlnSys);
    }

    @Override
    protected void prepareModelList(List<String> modelList) {
        super.prepareModelList(modelList);
        modelList.add("PSDEDATASET");
        modelList.add("PSDEACTION");
        modelList.add("PSDEOPPRIV");
        modelList.add("PSSYSSERVICEAPI");
        modelList.add("PSDESERVICEAPI");
        modelList.add("PSDESARS");
        modelList.add("PSDESADETAIL");
        modelList.add("PSDEFSFITEM");
        modelList.add("PSDEACTIONPARAM");
    }
}

