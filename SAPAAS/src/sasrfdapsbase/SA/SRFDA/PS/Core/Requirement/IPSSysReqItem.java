/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Requirement;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqModule;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.UML.IPSSysUseCase;
import SA.SRFDA.PS.Data.PSSysReqItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysReqItem
extends IPSSystemObject,
IPSSysSFPubObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysReqItem var3) throws Exception;

    public IPSSysReqModule getPSSysReqModule();

    @Override
    public String getCodeName();

    public String getContent();

    public String getItemTag();

    public String getItemTag2();

    public int getVer();

    public IPSSysUseCase getPSSysUseCase();

    public IPSSystemModule getPSSystemModule();

    public String getItemSN();

    public void registerRefPSModelObject(IPSModelObject var1);

    public Iterator<IPSModelObject> getRefPSModelObjects();
}

