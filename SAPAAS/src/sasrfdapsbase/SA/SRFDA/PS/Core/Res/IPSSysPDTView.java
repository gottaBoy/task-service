/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysPDTView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public interface IPSSysPDTView
extends IPSSystemObject,
IPSSysSFPubObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysPDTView var3) throws Exception;

    public String getPSPDTViewId();

    public String getPSDEViewBaseId();

    public String getMobPSDEViewBaseId();

    public String getCaption(String var1);

    public String getCaption();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public IPSLanguageRes getCapPSLanguageRes();

    public boolean isFromDEViewToPDTView();

    public IPSDataEntity getViewPSDataEntity() throws Exception;

    public String getViewCodeName();

    public IPSDataEntity getMobViewPSDataEntity() throws Exception;

    public String getMobViewCodeName();
}

