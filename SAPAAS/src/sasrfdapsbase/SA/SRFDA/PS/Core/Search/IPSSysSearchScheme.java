/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Search.IPSSearchScheme;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDoc;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIBase;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysSearchScheme
extends IPSSearchScheme,
IPSSystemObject,
IPSSysSFPubObject,
IPSSubSysServiceAPIBase {
    public Iterator<? extends IPSSysSearchDoc> getAllPSSysSearchDocs() throws Exception;

    public IPSSysSearchDoc getPSSysSearchDoc(String var1) throws Exception;

    public IPSSysSearchDoc getPSSysSearchDoc(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSysSearchDE> getAllPSSysSearchDEs() throws Exception;

    public IPSSysSearchDE getPSSysSearchDE(String var1) throws Exception;

    public IPSSysSearchDE getPSSysSearchDE(String var1, boolean var2) throws Exception;

    public IPSSystemModule getPSSystemModule();

    public IPSSysSearchDoc getPSSysSearchDoc(IPSSysSearchDE var1) throws Exception;

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public IPSSysModelGroup getPSSysModelGroup();

    public String getDBObjNameCase();
}

