/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.UML;

import SA.SRFDA.PS.Core.IPSModelDiffable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqItem;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.UML.IPSSysUseCaseRS;
import SA.SRFDA.PS.Core.UML.IPSUMLObject;
import SA.SRFDA.PS.Data.PSSysUserCase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysUseCase
extends IPSSystemObject,
IPSModelDiffable,
IPSUMLObject,
IPSSysSFPubObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysUserCase var3) throws Exception;

    public String getUseCaseSN();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public String getUseCaseTag();

    public String getUseCaseTag2();

    public Iterator<IPSSysUseCaseRS> getFromPSSysUseCaseRSs() throws Exception;

    public Iterator<IPSSysUseCaseRS> getToPSSysUseCaseRSs() throws Exception;

    public String getContent();

    public Iterator<IPSSysReqItem> getPSSysReqItems() throws Exception;
}

