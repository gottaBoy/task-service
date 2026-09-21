/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEActionWizard
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardItem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.SF.IPSSFCodeObject;
import SA.SRFDA.PS.Data.PSDEActionWizard;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEActionWizard;

@PSModelPFIgnoreMeta
@PSModelIgnoreMeta
public interface IPSDEActionWizard
extends IPSDataEntityObject,
IDEActionWizard,
IPSSFCodeObject {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEActionWizard var3) throws Exception;

    public int getDynamicMode();

    public Iterator<IPSDEActionWizardItem> getPSDEActionWizardItems();
}

