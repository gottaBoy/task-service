/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnAS;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnASGroup;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnDBInst;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnHost;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnMQInst;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSys;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSysAS;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSysDB;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSysMQ;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDepSln;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSDepSln
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, PSDepSln var2) throws Exception;

    public Iterator<IPSDepSlnHost> getAllPSDepSlnHosts() throws Exception;

    public IPSDepSlnHost getPSDepSlnHost(String var1) throws Exception;

    public void resetPSDepSlnHost(String var1) throws Exception;

    public void resetAllPSDepSlnHosts();

    public Iterator<IPSDepSlnDBInst> getAllPSDepSlnDBInsts() throws Exception;

    public IPSDepSlnDBInst getPSDepSlnDBInst(String var1) throws Exception;

    public void resetPSDepSlnDBInst(String var1) throws Exception;

    public void resetAllPSDepSlnDBInsts();

    public Iterator<IPSDepSlnMQInst> getAllPSDepSlnMQInsts() throws Exception;

    public IPSDepSlnMQInst getPSDepSlnMQInst(String var1) throws Exception;

    public void resetPSDepSlnMQInst(String var1) throws Exception;

    public void resetAllPSDepSlnMQInsts();

    public Iterator<IPSDepSlnAS> getAllPSDepSlnASes() throws Exception;

    public IPSDepSlnAS getPSDepSlnAS(String var1) throws Exception;

    public void resetPSDepSlnAS(String var1) throws Exception;

    public void resetAllPSDepSlnASes();

    public Iterator<IPSDepSlnASGroup> getAllPSDepSlnASGroups() throws Exception;

    public IPSDepSlnASGroup getPSDepSlnASGroup(String var1) throws Exception;

    public void resetPSDepSlnASGroup(String var1) throws Exception;

    public void resetAllPSDepSlnASGroups();

    public Iterator<IPSDepSlnSys> getAllPSDepSlnSyses() throws Exception;

    public IPSDepSlnSys getPSDepSlnSys(String var1) throws Exception;

    public void resetPSDepSlnSys(String var1) throws Exception;

    public void resetAllPSDepSlnSyses();

    public Iterator<IPSDepSlnSysDB> getAllPSDepSlnSysDBs() throws Exception;

    public IPSDepSlnSysDB getPSDepSlnSysDB(String var1) throws Exception;

    public void resetPSDepSlnSysDB(String var1) throws Exception;

    public void resetAllPSDepSlnSysDBs();

    public Iterator<IPSDepSlnSysMQ> getAllPSDepSlnSysMQs() throws Exception;

    public IPSDepSlnSysMQ getPSDepSlnSysMQ(String var1) throws Exception;

    public void resetPSDepSlnSysMQ(String var1) throws Exception;

    public void resetAllPSDepSlnSysMQs();

    public Iterator<IPSDepSlnSysAS> getAllPSDepSlnSysASes() throws Exception;

    public IPSDepSlnSysAS getPSDepSlnSysAS(String var1) throws Exception;

    public void resetPSDepSlnSysAS(String var1) throws Exception;

    public void resetAllPSDepSlnSysASes();
}

