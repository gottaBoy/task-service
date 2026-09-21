/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Database.IPSSystemDBConfig
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class PSIBiz5SysDBCfgCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSystemDBConfig iPSSystemDBConfig = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSystemDBCfgss = this.iPSSystem.getAllPSSystemDBConfigs();
        if (psSystemDBCfgss != null) {
            while (psSystemDBCfgss.hasNext()) {
                IPSSystemDBConfig iPSSystemDBConfig;
                this.iPSSystemDBConfig = iPSSystemDBConfig = (IPSSystemDBConfig)psSystemDBCfgss.next();
                this.onGenerateCode(iPSSystemDBConfig);
            }
        }
    }

    protected void onGenerateCode(IPSSystemDBConfig iPSSystemDBConfig) throws Exception {
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        return null;
    }

    protected void onClose() {
        this.iPSSystemDBConfig = null;
        super.onClose();
    }
}

