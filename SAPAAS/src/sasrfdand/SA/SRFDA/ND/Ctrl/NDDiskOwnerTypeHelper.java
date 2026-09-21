/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.ND.Ctrl.INDActionContext;
import SA.SRFDA.ND.Ctrl.INDDiskOwnerTypeHelper;
import SA.SRFDA.ND.Ctrl.NDBaseObject;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Data.NDDiskOwnerType;
import SA.SRFDA.ND.Security.DefaultNDAccHelper;
import SA.SRFDA.ND.Security.INDAccHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;

public class NDDiskOwnerTypeHelper
extends NDBaseObject
implements INDDiskOwnerTypeHelper {
    protected NDDiskOwnerType ndDiskOwnerType = null;
    private INDAccHelper iNDAccHelper = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, NDDiskOwnerType ndDiskOwnerType) throws Exception {
        this.ndDiskOwnerType = ndDiskOwnerType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.ndDiskOwnerType.getNDDISKOWNERTYPEID());
        this.setName(this.ndDiskOwnerType.getNDDISKOWNERTYPENAME());
        this.iNDAccHelper = StringHelper.IsNullOrEmpty((String)this.ndDiskOwnerType.getACCHELPER()) ? new DefaultNDAccHelper() : (INDAccHelper)ObjectHelper.Create((String)this.ndDiskOwnerType.getACCHELPER());
        this.OnInit();
    }

    @Override
    public void InitNDDisk(INDActionContext iNDActionContext, NDDisk ndDisk) throws Exception {
    }

    @Override
    public INDAccHelper getNDAccHelper() throws Exception {
        return this.iNDAccHelper;
    }
}

