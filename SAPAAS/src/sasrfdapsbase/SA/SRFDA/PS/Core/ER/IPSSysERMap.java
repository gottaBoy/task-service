/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.ER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.ER.IPSERMap;
import SA.SRFDA.PS.Core.ER.IPSSysERMapNode;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysERMap;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysERMap
extends IPSERMap,
IPSSystemObject,
IPSSysSFPubObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysERMap var3) throws Exception;

    public Iterator<? extends IPSSysERMapNode> getPSSysERMapNodes();

    public IPSSystemModule getPSSystemModule();

    public Iterator<? extends IPSDERBase> getPSDERs() throws Exception;
}

