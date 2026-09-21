/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSTemplDataCtrlBase;
import java.io.File;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSSFTemplDataCtrlBase
extends PSTemplDataCtrlBase {
    @Override
    protected String getRootFolder() throws Exception {
        return StringHelper.format((String)"%1$s%2$sPSSF", (Object)this.strCodeFolder, (Object)File.separator);
    }
}

