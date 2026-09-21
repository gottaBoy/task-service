/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Database.IPSSystemDBConfig
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysDBCfgCodePublisherImpl;
import java.util.HashMap;

public class PSIBiz5SysDMItemPublisherImpl
extends PSIBiz5SysDBCfgCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSSystemDBConfig iPSSystemDBConfig) throws Exception {
        HashMap params = new HashMap();
        this.savePSSysSFCode(this.iPSSystemDBConfig, null, params);
    }
}

