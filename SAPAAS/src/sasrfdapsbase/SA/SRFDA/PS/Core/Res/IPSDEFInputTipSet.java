/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEFInputTipSet
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSDEFInputTipSet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEFInputTipSet;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u5c5e\u6027\u63d0\u793a\u96c6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEFInputTipSet")
public interface IPSDEFInputTipSet
extends IPSSystemObject,
IDEFInputTipSet {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSDEFInputTipSet var3) throws Exception;

    public IPSDataEntity getPSDataEntity();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDEField getUniqueTagPSDEField();

    public IPSDEField getLinkPSDEField();

    public IPSDEField getEnableClosePSDEField();

    public IPSDEField getContentPSDEField();

    public IPSSystemModule getPSSystemModule();

    @Override
    public String getCodeName();

    public String getUniqueTag();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSXCodeObject getRender();
}

