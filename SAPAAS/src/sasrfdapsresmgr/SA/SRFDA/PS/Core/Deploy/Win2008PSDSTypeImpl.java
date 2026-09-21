/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl
 *  SA.SRFDA.PS.Data.PSDevServer
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.WindowsOSPSDSTypeImplBase;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.List;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer;

public class Win2008PSDSTypeImpl
extends WindowsOSPSDSTypeImplBase {
    public void initBookingRes(SA.SRFDA.PS.Data.PSDevServer psDevServerV3) throws Exception {
        PSDevServer psDevServer = new PSDevServer();
        PSDEDataCtrl.convertEntity2((BaseDataEntity)psDevServerV3, (IEntity)psDevServer);
        this.resetUserConnections(psDevServer);
        this.changeUserPassword(psDevServer);
        this.shutdownServer(psDevServer, true);
        this.updateServerConfig(psDevServer);
        this.startupServer(psDevServer);
        super.initBookingRes(psDevServerV3);
    }

    protected void startupServer(PSDevServer psDevServer) throws Exception {
    }

    protected void updateServerConfig(PSDevServer psDevServer) throws Exception {
    }

    protected void shutdownServer(PSDevServer psDevServer, boolean bEmptyFolder) throws Exception {
    }

    public void uninitBookingRes(SA.SRFDA.PS.Data.PSDevServer psDevServerV3) throws Exception {
        PSDevServer psDevServer = new PSDevServer();
        PSDEDataCtrl.convertEntity2((BaseDataEntity)psDevServerV3, (IEntity)psDevServer);
        this.resetUserConnections(psDevServer);
        this.changeUserPassword(psDevServer);
        this.shutdownServer(psDevServer, false);
        super.uninitBookingRes(psDevServerV3);
    }

    public void updateTomcatPort(PSDevServer psDevServer, String strFolder, List<String> portMapList) throws Exception {
    }
}

