/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBar;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBarGroup;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBarItem;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRGroup;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class PSDEDRBarGroupImpl
extends PSObjectImpl
implements IPSDEDRBarGroup {
    private IPSDEDRBar iPSDEDRBar;
    private IPSDEDRGroup iPSDEDRGroup;
    protected ArrayList<IPSDEDRBarItem> psDEDRBarItemList = new ArrayList();
    private IPSSysPFPlugin headerPSSysPFPlugin = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDRBar iPSDEDRBar, IPSDEDRGroup iPSDEDRGroup) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSDEDRBar = iPSDEDRBar;
        this.iPSDEDRGroup = iPSDEDRGroup;
        this.setId(this.iPSDEDRGroup.getId());
        this.setName(this.iPSDEDRGroup.getName());
        if (this.getCapPSLanguageRes() != null) {
            iPSDEDRBar.getPSAppView().getPSApplication().getPSLanguageRes(this.getCapPSLanguageRes().getId());
        }
        if (this.iPSDEDRGroup.getHeaderPSSysPFPlugin() != null) {
            this.headerPSSysPFPlugin = this.iPSDEDRBar.getPSAppView().getPSApplication().getPSSysPFPlugin(this.iPSDEDRGroup.getHeaderPSSysPFPlugin().getId(), "DEDRGROUPHEADER", null, null);
        }
        this.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u680f")
    public IPSDEDRBar getPSDEDRBar() {
        return this.iPSDEDRBar;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"psdedrgroupname"})
    public String getCaption() {
        return this.iPSDEDRGroup.getCaption(this.iPSDEDRBar.getPSAppView().getLanguage());
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u680f\u9879\u96c6\u5408")
    public Iterator<IPSDEDRBarItem> getPSDEDRBarItems() {
        return this.psDEDRBarItemList.iterator();
    }

    public void addPSDEDRBarItem(IPSDEDRBarItem iPSDEDRBarItem) {
        this.psDEDRBarItemList.add(iPSDEDRBarItem);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5173\u7cfb\u5206\u7ec4\u5bf9\u8c61")
    public IPSDEDRGroup getPSDEDRGroup() {
        return this.iPSDEDRGroup;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDRBar.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u5206\u7ec4", fields={"hiddenflag"})
    public boolean isHidden() {
        return this.getPSDEDRGroup().isHidden();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u7cfb\u7edf\u5bf9\u8c61", fields={"cappslanresid"})
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.iPSDEDRGroup.getCapPSLanguageRes();
    }

    @Override
    public String getModelType() {
        return "PSDEDRBARGROUP";
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEDRBar().getModelId(), (Object)this.getId());
    }

    @Override
    public String getCodeName() {
        return this.iPSDEDRGroup.getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u56fe\u7247\u8d44\u6e90\u5bf9\u8c61", fields={"pssysimageid"})
    public IPSSysImage getPSSysImage() {
        return this.getPSDEDRGroup().getPSSysImage();
    }

    @Override
    @PSModelRTMeta(description="\u5934\u90e8\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getHeaderPSSysPFPlugin() {
        return this.headerPSSysPFPlugin;
    }
}

