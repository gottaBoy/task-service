/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEActionWizardGroup
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroupDetail;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEAWGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEActionWizardGroup;

@PSModelPFIgnoreMeta
@PSModelIgnoreMeta
public interface IPSDEActionWizardGroup
extends IPSDataEntityObject,
IDEActionWizardGroup {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEAWGroup var3) throws Exception;

    public Iterator<IPSDEActionWizardGroupDetail> getPSDEActionWizardGroupDetails();
}

