/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnAS;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnASGroup;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnASGroupItem;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDepSlnASItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnASGroupItemImpl
extends PSObjectImpl
implements IPSDepSlnASGroupItem {
    private static final Log log = LogFactory.getLog(PSDepSlnASGroupItemImpl.class);
    protected PSDepSlnASItem psDepSlnASItem = null;
    private IPSDepSlnASGroup iPSDepSlnASGroup = null;
    private IPSDepSlnAS iPSDepSlnAS = null;
    private boolean bBackupMode = false;
    private int nWeight = -1;
    private int nMaxFails = -1;
    private int nFailTimeout = -1;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDepSlnASGroup iPSDepSlnASGroup, PSDepSlnASItem psDepSlnASItem) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDepSlnASItem = psDepSlnASItem;
        this.iPSDepSlnASGroup = iPSDepSlnASGroup;
        this.setId(this.psDepSlnASItem.getPSDEPSLNASITEMID());
        this.setName(this.psDepSlnASItem.getPSDEPSLNASITEMNAME());
        this.setPSObjectData(this.psDepSlnASItem);
        if (!this.psDepSlnASItem.isBACKUPMODENull()) {
            this.bBackupMode = this.psDepSlnASItem.getBACKUPMODE();
        }
        if (!this.psDepSlnASItem.isWEIGHTNull()) {
            this.nWeight = this.psDepSlnASItem.getWEIGHT();
        }
        if (!this.psDepSlnASItem.isMAXFAILSNull()) {
            this.nMaxFails = this.psDepSlnASItem.getMAXFAILS();
        }
        if (!this.psDepSlnASItem.isFAILTIMEOUTNull()) {
            this.nFailTimeout = this.psDepSlnASItem.getFAILTIMEOUT();
        }
        this.iPSDepSlnAS = this.iPSDepSlnASGroup.getPSDepSln().getPSDepSlnAS(this.psDepSlnASItem.getPSDEPSLNASID());
        this.onInit();
    }

    @Override
    public IPSDepSlnASGroup getPSDepSlnASGroup() {
        return this.iPSDepSlnASGroup;
    }

    @Override
    public IPSDepSlnAS getPSDepSlnAS() {
        return this.iPSDepSlnAS;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDepSlnASGroup.getPSSysModelInstId();
    }

    @Override
    public boolean isBackup() {
        return this.bBackupMode;
    }

    @Override
    public int getWeight() {
        return this.nWeight;
    }

    @Override
    public int getMaxFails() {
        return this.nMaxFails;
    }

    @Override
    public int getFailTimeout() {
        return this.nFailTimeout;
    }
}

