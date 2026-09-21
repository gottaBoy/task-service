/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBListPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBSysPortletPartImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.List.IPSList;
import SA.SRFDA.PS.Core.Control.List.PSDEListParamImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDEListPortlet;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDBPortletPart", typevalues={"LIST"})
public class PSDBListPortletPartImpl
extends PSDBSysPortletPartImpl
implements IPSDBListPortletPart {
    public static final String LISTNAME = "_list";
    private IPSList iPSList = null;

    @Override
    protected void onInit() throws Exception {
        IPSSysDEListPortlet iPSSysDEListPortlet = (IPSSysDEListPortlet)this.iPSSysPortlet;
        PSDEListParamImpl psDEListParamImpl = new PSDEListParamImpl();
        psDEListParamImpl.setPSDEListId(iPSSysDEListPortlet.getPSDEListId());
        psDEListParamImpl.setPSDEDataSetId(iPSSysDEListPortlet.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)psDEListParamImpl.getPSDEDataSetId())) {
            psDEListParamImpl.setCustomCond(iPSSysDEListPortlet.getCustomCond());
        }
        psDEListParamImpl.setActiveDataPSDELogicId(iPSSysDEListPortlet.getActiveDataPSDELogicId());
        if (iPSSysDEListPortlet.getHeight() > 0) {
            psDEListParamImpl.setHeight(Double.valueOf(iPSSysDEListPortlet.getHeight()));
        }
        this.iPSList = (IPSList)this.registerPSControl(String.valueOf(this.getName()) + LISTNAME, "LIST", psDEListParamImpl);
        super.onInit();
    }

    @Override
    public IPSList getPSList() {
        return this.iPSList;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u90e8\u4ef6", dumpref=true, modelreftype="LINK", from="__self__", from_method="getPSControl")
    public IPSControl getContentPSControl() {
        return this.getPSList();
    }
}

