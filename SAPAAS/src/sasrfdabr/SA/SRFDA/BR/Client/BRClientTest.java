/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.BR.Client;

import SA.SRFDA.BR.Client.BRClientAPI;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;

public class BRClientTest {
    public static void main(String[] args) {
        BRClientAPI brClientApi = new BRClientAPI();
        brClientApi.Init("http://localhost:8000/SAEAM/services/BRService?wsdl", false);
        BaseDataEntity param = new BaseDataEntity();
        param.SetParamValue("arg1", (Object)100);
        CallResult callResult = brClientApi.Execute("BR_0001", "BRINST001", "RULE1", param, "SYSTEM");
        int i = 0;
        i = 2;
    }
}

