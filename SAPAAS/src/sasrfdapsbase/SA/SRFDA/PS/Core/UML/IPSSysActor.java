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
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.UML.IPSSysUseCaseRS;
import SA.SRFDA.PS.Core.UML.IPSUMLObject;
import SA.SRFDA.PS.Data.PSSysActor;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysActor
extends IPSSystemObject,
IPSModelDiffable,
IPSUMLObject,
IPSSysSFPubObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysActor var3) throws Exception;

    public Iterator<IPSSysUseCaseRS> getFromPSSysUseCaseRSs() throws Exception;

    public Iterator<IPSSysUseCaseRS> getToPSSysUseCaseRSs() throws Exception;

    public String getActorSN();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public String getActorTag();

    public String getActorTag2();

    public String getContent();
}

