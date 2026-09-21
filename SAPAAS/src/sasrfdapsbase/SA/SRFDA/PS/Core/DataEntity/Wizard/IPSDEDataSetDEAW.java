/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataSetDEAW
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizard;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import net.ibizsys.paas.core.IDEDataSetDEAW;

@PSModelPFIgnoreMeta
@PSModelIgnoreMeta
public interface IPSDEDataSetDEAW
extends IPSDEActionWizard,
IDEDataSetDEAW {
    public IPSDataEntity getAWPSDE();

    public IPSDEDataSet getAWPSDEDataSet();

    public IPSDEField getAWNamePSDEField();

    public IPSDEField getAWKeywordPSDEField();

    public IPSDEField getAWSortPSDEField();

    public IPSDataEntity getAWIPSDE();

    public IPSDEDataSet getAWIPSDEDataSet();

    public IPSDEField getAWINamePSDEField();

    public IPSDEField getAWIValuePSDEField();

    public IPSDEField getAWIFKeyPSDEField();

    public IPSDEField getAWIContentPSDEField();

    public IPSDEField getAWIUrlPSDEField();

    public IPSDEField getAWISortPSDEField();
}

