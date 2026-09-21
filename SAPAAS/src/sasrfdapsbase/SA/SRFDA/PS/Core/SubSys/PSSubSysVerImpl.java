/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysDMItem;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysVer;
import SA.SRFDA.PS.Core.SubSys.PSSubSysDMItemGlobalModel;
import SA.SRFDA.PS.Core.SubSys.PSSubSysObjectImpl;
import SA.SRFDA.PS.Data.PSSubSysVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubSysVerImpl
extends PSSubSysObjectImpl
implements IPSSubSysVer {
    private static final Log log = LogFactory.getLog(PSSubSysVerImpl.class);
    protected PSSubSysVer psSubSysVer = null;
    protected PSSubSysDMItemGlobalModel psSubSysDMItemGlobalModel = new PSSubSysDMItemGlobalModel();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSys iPSSubSys, PSSubSysVer psSubSysVer) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSSubSys(iPSSubSys);
        this.psSubSysVer = psSubSysVer;
        this.setId(this.psSubSysVer.getPSSUBSYSVERID());
        this.setName(this.psSubSysVer.getPSSUBSYSVERNAME());
        this.setPSObjectData(this.psSubSysVer);
        this.setVersion(this.psSubSysVer.getVERSION());
        this.psSubSysDMItemGlobalModel.Init(iDAGlobalHelper, this);
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.psSubSysVer.getPSSYSMODELINSTID();
    }

    @Override
    public String getPSSystemId() {
        return "2C40DFCD-0DF5-47BF-91A5-C45F810B0001";
    }

    @Override
    public Iterator<IPSSubSysDMItem> getAllPSSubSysDMItems() throws Exception {
        return this.psSubSysDMItemGlobalModel.getAllModelHelpers();
    }
}

