/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSWFExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSExpBarParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelRTIgnoreMeta
public class PSWFExpBarParamImpl
extends PSExpBarParamImpl
implements IPSWFExpBarParam {
    private static final Log log = LogFactory.getLog(PSWFExpBarParamImpl.class);
    private boolean bOutputMyWorkFirst = false;
    private String strMyWorkName = "";
    private boolean bExpandMyWork = true;
    private boolean bOutputMyHistoryWork = false;
    private String strWFDataSector = "MY";
    private String strMyHistoryWorkName = "";
    private boolean bOutputWFParallelFolder = true;
    private boolean bOutputMyDataWFSteps = true;
    private boolean bHasOutputMyDataWFStepsParam = false;
    private boolean bHasOutputMyWorkFirstParam = false;

    @Override
    protected void onInit() throws Exception {
        if (!this.psDEViewCtrl.isCTRLPARAM5Null()) {
            this.markOutputMyDataWFStepsParam(true);
            this.setOutputMyDataWFSteps(this.psDEViewCtrl.getCTRLPARAM5());
        }
        if (!this.psDEViewCtrl.isCTRLPARAM6Null()) {
            this.markOutputMyWorkFirstParam(true);
            this.setOutputMyWorkFirst(this.psDEViewCtrl.getCTRLPARAM6());
        }
        super.onInit();
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSWFExpBarParam) {
            IPSWFExpBarParam iPSWFExpBarParam = (IPSWFExpBarParam)iPSControlParam;
            if (iPSWFExpBarParam.hasOutputMyDataWFStepsParam()) {
                this.setOutputMyDataWFSteps(iPSWFExpBarParam.isOutputMyDataWFSteps());
            }
            if (iPSWFExpBarParam.hasOutputMyWorkFirstParam()) {
                this.setOutputMyWorkFirst(iPSWFExpBarParam.isOutputMyWorkFirst());
            }
        }
    }

    @Override
    public boolean isExpandMyWork() {
        return this.bExpandMyWork;
    }

    @Override
    public boolean isOutputMyHistoryWork() {
        return this.bOutputMyHistoryWork;
    }

    @Override
    public String getWFDataSector() {
        return this.strWFDataSector;
    }

    @Override
    public String getMyHistoryWorkName() {
        return this.strMyHistoryWorkName;
    }

    @Override
    public boolean isOutputWFParallelFolder() {
        return this.bOutputWFParallelFolder;
    }

    protected void setExpandMyWork(boolean bExpandMyWork) {
        this.bExpandMyWork = bExpandMyWork;
    }

    protected void setOutputMyHistoryWork(boolean bOutputMyHistoryWork) {
        this.bOutputMyHistoryWork = bOutputMyHistoryWork;
    }

    protected void setWFDataSector(String strWFDataSector) {
        this.strWFDataSector = strWFDataSector;
    }

    protected void setMyHistoryWorkName(String strMyHistoryWorkName) {
        this.strMyHistoryWorkName = strMyHistoryWorkName;
    }

    protected void setOutputWFParallelFolder(boolean bOutputWFParallelFolder) {
        this.bOutputWFParallelFolder = bOutputWFParallelFolder;
    }

    @Override
    public boolean isOutputMyWorkFirst() {
        return this.bOutputMyWorkFirst;
    }

    protected void setOutputMyWorkFirst(boolean bOutputMyWorkFirst) {
        this.bOutputMyWorkFirst = bOutputMyWorkFirst;
    }

    @Override
    public boolean hasOutputMyWorkFirstParam() {
        return this.bHasOutputMyWorkFirstParam;
    }

    protected void markOutputMyWorkFirstParam(boolean bHasOutputMyWorkFirstParam) {
        this.bHasOutputMyWorkFirstParam = bHasOutputMyWorkFirstParam;
    }

    @Override
    public String getMyWorkName() {
        return this.strMyWorkName;
    }

    protected void setMyWorkName(String strMyWorkName) {
        this.strMyWorkName = strMyWorkName;
    }

    @Override
    public boolean isOutputMyDataWFSteps() {
        return this.bOutputMyDataWFSteps;
    }

    protected void setOutputMyDataWFSteps(boolean bOutputMyDataWFSteps) {
        this.bOutputMyDataWFSteps = bOutputMyDataWFSteps;
    }

    @Override
    public boolean hasOutputMyDataWFStepsParam() {
        return this.bHasOutputMyDataWFStepsParam;
    }

    protected void markOutputMyDataWFStepsParam(boolean bHasOutputMyDataWFStepsParam) {
        this.bHasOutputMyDataWFStepsParam = bHasOutputMyDataWFStepsParam;
    }
}

