/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.UML;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.UML.IPSSysUCMapNode;
import SA.SRFDA.PS.Core.UML.IPSSysUseCaseRS;
import SA.SRFDA.PS.Core.UML.IPSUMLObject;
import SA.SRFDA.PS.Data.PSSysUCMap;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysUCMap
extends IPSSystemObject,
IPSSysSFPubObject,
IPSUMLObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysUCMap var3) throws Exception;

    public Iterator<? extends IPSSysUCMapNode> getPSSysUCMapNodes();

    public IPSSystemModule getPSSystemModule();

    @Override
    public String getCodeName();

    public String getUCMapSN();

    public Iterator<? extends IPSSysUseCaseRS> getPSSysUseCaseRSs() throws Exception;
}

