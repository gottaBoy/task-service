/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEFInputTip
 *  net.ibizsys.paas.demodel.DEFInputTipSetModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.util;

import net.ibizsys.paas.core.IDEFInputTip;
import net.ibizsys.paas.demodel.DEFInputTipSetModel;
import net.ibizsys.pscore.srv.util.PSSysRTDEFInputTipHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysRTDEFInputTipSetModel
extends DEFInputTipSetModel {
    private static final Log log = LogFactory.getLog(PSSysRTDEFInputTipSetModel.class);

    public IDEFInputTip getDEFInputTip(String string, boolean bl) throws Exception {
        IDEFInputTip iDEFInputTip = PSSysRTDEFInputTipHelper.getDEFInputTip(string);
        return iDEFInputTip;
    }

    public void prepareDEFInputTips() throws Exception {
    }

    public void resetAll() {
        try {
            PSSysRTDEFInputTipHelper.reload();
        }
        catch (Exception exception) {
            log.error((Object)exception);
        }
    }
}

