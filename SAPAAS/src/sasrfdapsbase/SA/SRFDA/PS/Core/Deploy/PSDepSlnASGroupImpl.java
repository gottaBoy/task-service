/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSASGroup;
import SA.SRFDA.PS.Core.Deploy.IPSDepSln;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnASGroup;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnASGroupItem;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnASGroupItemImpl;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnResObjectImpl;
import SA.SRFDA.PS.Data.PSDCASGroup;
import SA.SRFDA.PS.Data.PSDepSlnASGrp;
import SA.SRFDA.PS.Data.PSDepSlnASItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnASGroupImpl
extends PSDepSlnResObjectImpl
implements IPSDepSlnASGroup {
    private static final Log log = LogFactory.getLog(PSDepSlnASGroupImpl.class);
    protected PSDepSlnASGrp psDepSlnASGrp = null;
    private ArrayList<IPSDepSlnASGroupItem> psDepSlnASGroupItemList = new ArrayList();
    protected PSDCASGroup psDCASGroup = null;
    private IPSASGroup iPSASGroup = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDepSln iPSDepSln, PSDepSlnASGrp psDepSlnASGrp) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDepSln(iPSDepSln);
        this.psDepSlnASGrp = psDepSlnASGrp;
        this.setId(this.psDepSlnASGrp.getPSDEPSLNASGRPID());
        this.setName(this.psDepSlnASGrp.getPSDEPSLNASGRPNAME());
        this.setPSObjectData(this.psDepSlnASGrp);
        if (!this.psDepSlnASGrp.isENABLELOCALMODENull()) {
            this.setEnableLocalDeploy(this.psDepSlnASGrp.getENABLELOCALMODE());
        }
        if (!this.psDepSlnASGrp.isENABLEREMOTEMODENull()) {
            this.setEnableRemoteDeploy(this.psDepSlnASGrp.getENABLEREMOTEMODE());
        }
        if (this.isEnableRemoteDeploy()) {
            if (!StringHelper.isNullOrEmpty((String)this.psDepSlnASGrp.getPSDCASGROUPID())) {
                this.psDCASGroup = new PSDCASGroup();
                CallResult callResult = this.getPSModelHelper().getPSDCASGroup(this.psDepSlnASGrp.getPSDCASGROUPID(), this.psDCASGroup);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u4e2d\u5fc3\u5e94\u7528\u5bb9\u5668\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.psDepSlnASGrp.getPSDCASGROUPID(), (Object)callResult.getErrorInfo()));
                }
                if (!StringHelper.isNullOrEmpty((String)this.psDCASGroup.getPSASGROUPID())) {
                    this.iPSASGroup = this.getPSModelStorage().getPSASGroup(this.psDCASGroup.getPSASGROUPID());
                }
            }
            if (this.iPSASGroup == null) {
                throw new Exception("\u6ca1\u6709\u4e3a\u4e91\u7aef\u90e8\u7f72\u6307\u5b9a\u4e91\u7aef\u8d44\u6e90");
            }
        }
        if (this.isEnableLocalDeploy()) {
            this.setPSDepSlnHostId(this.psDepSlnASGrp.getPSDEPSLNHOSTID());
            if (this.getPSDepSlnHost() == null) {
                throw new Exception("\u6ca1\u6709\u4e3a\u672c\u5730\u90e8\u7f72\u6307\u5b9a\u4e3b\u673a\u8d44\u6e90");
            }
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSDepSlnASItems();
        super.onInit();
    }

    protected void onPreparePSDepSlnASItems() throws Exception {
        ArrayList<PSDepSlnASItem> psDepSlnASItemList = this.psDepSlnASGrp.getPSDepSlnASItems(false);
        if (psDepSlnASItemList == null) {
            return;
        }
        for (PSDepSlnASItem psDepSlnASItem : psDepSlnASItemList) {
            PSDepSlnASGroupItemImpl iPSDepSlnASGroupItem = new PSDepSlnASGroupItemImpl();
            iPSDepSlnASGroupItem.init(this.getDAGlobalHelper(), this, psDepSlnASItem);
            this.psDepSlnASGroupItemList.add(iPSDepSlnASGroupItem);
        }
    }

    @Override
    public String getModelType() {
        return "PSDEPSLNASGRP";
    }

    @Override
    public Iterator<IPSDepSlnASGroupItem> getPSDepSlnASGroupItems() {
        return this.psDepSlnASGroupItemList.iterator();
    }

    @Override
    public String getGroupMode() {
        return this.psDepSlnASGrp.getGROUPMODE();
    }

    @Override
    public String getASType(boolean bRemote) throws Exception {
        if (bRemote) {
            if (!this.isEnableRemoteDeploy()) {
                throw new Exception("\u4e0d\u652f\u6301\u4e91\u7aef\u90e8\u7f72");
            }
            return this.iPSASGroup.getASType();
        }
        if (!this.isEnableLocalDeploy()) {
            throw new Exception("\u4e0d\u652f\u6301\u672c\u5730\u90e8\u7f72");
        }
        return this.psDepSlnASGrp.getASTYPE();
    }

    @Override
    public int getHttpPort(boolean bRemote) throws Exception {
        if (bRemote) {
            if (!this.isEnableRemoteDeploy()) {
                throw new Exception("\u4e0d\u652f\u6301\u4e91\u7aef\u90e8\u7f72");
            }
            return this.iPSASGroup.getHttpPort();
        }
        if (!this.isEnableLocalDeploy()) {
            throw new Exception("\u4e0d\u652f\u6301\u672c\u5730\u90e8\u7f72");
        }
        return this.psDepSlnASGrp.getHTTPPORT();
    }

    @Override
    public int getHttpsPort(boolean bRemote) throws Exception {
        if (bRemote) {
            if (!this.isEnableRemoteDeploy()) {
                throw new Exception("\u4e0d\u652f\u6301\u4e91\u7aef\u90e8\u7f72");
            }
            return this.iPSASGroup.getHttpsPort();
        }
        if (!this.isEnableLocalDeploy()) {
            throw new Exception("\u4e0d\u652f\u6301\u672c\u5730\u90e8\u7f72");
        }
        return this.psDepSlnASGrp.getHTTPSPORT();
    }
}

