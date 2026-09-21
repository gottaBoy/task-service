/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.view.IViewWizardGroup
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSViewWizardGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.view.IViewWizardGroup;

@PSModelPFIgnoreMeta
public interface IPSViewWizardGroup
extends IViewWizardGroup,
IPSSystemObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSViewWizardGroup var3) throws Exception;
}

