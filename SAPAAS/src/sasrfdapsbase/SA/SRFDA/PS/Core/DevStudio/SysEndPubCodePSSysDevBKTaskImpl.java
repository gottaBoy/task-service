/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.SysTemplV2PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysDynaInst;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SysEndPubCodePSSysDevBKTaskImpl
extends SysTemplV2PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SysEndPubCodePSSysDevBKTaskImpl.class);

    @Override
    protected String getCommand(IPSDevSlnSys iPSDevSlnSys, IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst) throws Exception {
        String strCommandFile = this.getCommandFile(iPSDevSlnSys, iPSDevSlnSysDynaInst);
        if (this.getPSSysRunSession() != null) {
            return StringHelper.format((String)"%1$s end %2$s", (Object)strCommandFile, (Object)this.getPSSysRunSession().getRunMode());
        }
        return StringHelper.format((String)"%1$s end", (Object)strCommandFile);
    }
}

