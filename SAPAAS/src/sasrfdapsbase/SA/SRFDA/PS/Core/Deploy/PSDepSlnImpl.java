/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSln;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnAS;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnASGroup;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnDBInst;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnHost;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnMQInst;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSys;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSysAS;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSysDB;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSysMQ;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnASGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnASGroupGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnDBInstGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnHostGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnMQInstGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnSysASGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnSysDBGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnSysGlobalModel;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnSysMQGlobalModel;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDepSln;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public class PSDepSlnImpl
extends PSObjectImpl
implements IPSDepSln {
    protected PSDepSln psDepSln = null;
    private String strCodeName = "";
    private PSDepSlnHostGlobalModel psDepSlnHostGlobalModel = new PSDepSlnHostGlobalModel();
    private PSDepSlnDBInstGlobalModel psDepSlnDBInstGlobalModel = new PSDepSlnDBInstGlobalModel();
    private PSDepSlnMQInstGlobalModel psDepSlnMQInstGlobalModel = new PSDepSlnMQInstGlobalModel();
    private PSDepSlnASGlobalModel psDepSlnASGlobalModel = new PSDepSlnASGlobalModel();
    private PSDepSlnASGroupGlobalModel psDepSlnASGroupGlobalModel = new PSDepSlnASGroupGlobalModel();
    private PSDepSlnSysGlobalModel psDepSlnSysGlobalModel = new PSDepSlnSysGlobalModel();
    private PSDepSlnSysMQGlobalModel psDepSlnSysMQGlobalModel = new PSDepSlnSysMQGlobalModel();
    private PSDepSlnSysDBGlobalModel psDepSlnSysDBGlobalModel = new PSDepSlnSysDBGlobalModel();
    private PSDepSlnSysASGlobalModel psDepSlnSysASGlobalModel = new PSDepSlnSysASGlobalModel();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDepSln psDepSln) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDepSln = psDepSln;
        this.setId(this.psDepSln.getPSDEPSLNID());
        this.setName(this.psDepSln.getPSDEPSLNNAME());
        this.setPSObjectData(this.psDepSln);
        this.psDepSlnHostGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psDepSlnDBInstGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psDepSlnMQInstGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psDepSlnASGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psDepSlnASGroupGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psDepSlnSysGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psDepSlnSysMQGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psDepSlnSysDBGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psDepSlnSysASGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        this.psDepSlnHostGlobalModel.getAllModelHelpers();
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEPSLN";
    }

    @Override
    public Iterator<IPSDepSlnHost> getAllPSDepSlnHosts() throws Exception {
        return this.psDepSlnHostGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDepSlnHost getPSDepSlnHost(String strDepSlnHostId) throws Exception {
        return (IPSDepSlnHost)this.psDepSlnHostGlobalModel.FindModelHelper(strDepSlnHostId);
    }

    @Override
    public void resetPSDepSlnHost(String strDepSlnHostId) throws Exception {
        this.psDepSlnHostGlobalModel.ResetModel(strDepSlnHostId);
    }

    @Override
    public void resetAllPSDepSlnHosts() {
        this.psDepSlnHostGlobalModel.ResetAll();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public Iterator<IPSDepSlnMQInst> getAllPSDepSlnMQInsts() throws Exception {
        return this.psDepSlnMQInstGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDepSlnMQInst getPSDepSlnMQInst(String strDepSlnMQInstId) throws Exception {
        return (IPSDepSlnMQInst)this.psDepSlnMQInstGlobalModel.FindModelHelper(strDepSlnMQInstId);
    }

    @Override
    public void resetPSDepSlnMQInst(String strDepSlnMQInstId) throws Exception {
        this.psDepSlnMQInstGlobalModel.ResetModel(strDepSlnMQInstId);
    }

    @Override
    public void resetAllPSDepSlnMQInsts() {
        this.psDepSlnMQInstGlobalModel.ResetAll();
    }

    @Override
    public Iterator<IPSDepSlnDBInst> getAllPSDepSlnDBInsts() throws Exception {
        return this.psDepSlnDBInstGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDepSlnDBInst getPSDepSlnDBInst(String strDepSlnDBInstId) throws Exception {
        return (IPSDepSlnDBInst)this.psDepSlnDBInstGlobalModel.FindModelHelper(strDepSlnDBInstId);
    }

    @Override
    public void resetPSDepSlnDBInst(String strDepSlnDBInstId) throws Exception {
        this.psDepSlnDBInstGlobalModel.ResetModel(strDepSlnDBInstId);
    }

    @Override
    public void resetAllPSDepSlnDBInsts() {
        this.psDepSlnDBInstGlobalModel.ResetAll();
    }

    @Override
    public Iterator<IPSDepSlnAS> getAllPSDepSlnASes() throws Exception {
        return this.psDepSlnASGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDepSlnAS getPSDepSlnAS(String strDepSlnASId) throws Exception {
        return (IPSDepSlnAS)this.psDepSlnASGlobalModel.FindModelHelper(strDepSlnASId);
    }

    @Override
    public void resetPSDepSlnAS(String strDepSlnASId) throws Exception {
        this.psDepSlnASGlobalModel.ResetModel(strDepSlnASId);
    }

    @Override
    public void resetAllPSDepSlnASes() {
        this.psDepSlnASGlobalModel.ResetAll();
    }

    @Override
    public Iterator<IPSDepSlnASGroup> getAllPSDepSlnASGroups() throws Exception {
        return this.psDepSlnASGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDepSlnASGroup getPSDepSlnASGroup(String strDepSlnASGroupId) throws Exception {
        return (IPSDepSlnASGroup)this.psDepSlnASGroupGlobalModel.FindModelHelper(strDepSlnASGroupId);
    }

    @Override
    public void resetPSDepSlnASGroup(String strDepSlnASGroupId) throws Exception {
        this.psDepSlnASGroupGlobalModel.ResetModel(strDepSlnASGroupId);
    }

    @Override
    public void resetAllPSDepSlnASGroups() {
        this.psDepSlnASGroupGlobalModel.ResetAll();
    }

    @Override
    public Iterator<IPSDepSlnSys> getAllPSDepSlnSyses() throws Exception {
        return this.psDepSlnSysGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDepSlnSys getPSDepSlnSys(String strDepSlnSysId) throws Exception {
        return (IPSDepSlnSys)this.psDepSlnSysGlobalModel.FindModelHelper(strDepSlnSysId);
    }

    @Override
    public void resetPSDepSlnSys(String strDepSlnSysId) throws Exception {
        this.psDepSlnSysGlobalModel.ResetModel(strDepSlnSysId);
    }

    @Override
    public void resetAllPSDepSlnSyses() {
        this.psDepSlnSysGlobalModel.ResetAll();
    }

    @Override
    public Iterator<IPSDepSlnSysDB> getAllPSDepSlnSysDBs() throws Exception {
        return this.psDepSlnSysDBGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDepSlnSysDB getPSDepSlnSysDB(String strDepSlnSysDBId) throws Exception {
        return (IPSDepSlnSysDB)this.psDepSlnSysDBGlobalModel.FindModelHelper(strDepSlnSysDBId);
    }

    @Override
    public void resetPSDepSlnSysDB(String strDepSlnSysDBId) throws Exception {
        this.psDepSlnSysDBGlobalModel.ResetModel(strDepSlnSysDBId);
    }

    @Override
    public void resetAllPSDepSlnSysDBs() {
        this.psDepSlnSysDBGlobalModel.ResetAll();
    }

    @Override
    public Iterator<IPSDepSlnSysMQ> getAllPSDepSlnSysMQs() throws Exception {
        return this.psDepSlnSysMQGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDepSlnSysMQ getPSDepSlnSysMQ(String strDepSlnSysMQId) throws Exception {
        return (IPSDepSlnSysMQ)this.psDepSlnSysMQGlobalModel.FindModelHelper(strDepSlnSysMQId);
    }

    @Override
    public void resetPSDepSlnSysMQ(String strDepSlnSysMQId) throws Exception {
        this.psDepSlnSysMQGlobalModel.ResetModel(strDepSlnSysMQId);
    }

    @Override
    public void resetAllPSDepSlnSysMQs() {
        this.psDepSlnSysMQGlobalModel.ResetAll();
    }

    @Override
    public Iterator<IPSDepSlnSysAS> getAllPSDepSlnSysASes() throws Exception {
        return this.psDepSlnSysASGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDepSlnSysAS getPSDepSlnSysAS(String strDepSlnSysASId) throws Exception {
        return (IPSDepSlnSysAS)this.psDepSlnSysASGlobalModel.FindModelHelper(strDepSlnSysASId);
    }

    @Override
    public void resetPSDepSlnSysAS(String strDepSlnSysASId) throws Exception {
        this.psDepSlnSysASGlobalModel.ResetModel(strDepSlnSysASId);
    }

    @Override
    public void resetAllPSDepSlnSysASes() {
        this.psDepSlnSysASGlobalModel.ResetAll();
    }
}

