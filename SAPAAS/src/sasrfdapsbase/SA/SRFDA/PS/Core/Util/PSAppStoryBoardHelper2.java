/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItem
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItemRS
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Util.PSAppStoryBoardHelper;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItemRS;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard;

public class PSAppStoryBoardHelper2
extends PSAppStoryBoardHelper {
    @Override
    public PSAppSBItem getPSAppSBItem(IPSAppView iPSAppView, boolean bCheck, PSAppStoryBoard psAppStoryBoard, Map<String, PSAppSBItem> psAppSBItemMap, List<PSAppSBItemRS> psAppSBItemRSList) throws Exception {
        PSAppSBItem psAppSBItem = super.getPSAppSBItem(iPSAppView, bCheck, psAppStoryBoard, psAppSBItemMap, psAppSBItemRSList);
        if (psAppSBItem != null && "APPVIEW".equals(psAppSBItem.getItemType())) {
            psAppSBItem.setItemTag(iPSAppView.getDynaModelFilePath());
            if (iPSAppView instanceof IPSAppDEView) {
                psAppSBItem.setItemTag2(((IPSAppDEView)iPSAppView).getPSDEViewId());
            }
        }
        return psAppSBItem;
    }

    @Override
    protected String getPSAppSBItemId(PSAppSBItem psAppSBItem) {
        if ("APPVIEW".equals(psAppSBItem.getItemType())) {
            return KeyValueHelper.genUniqueId((String)psAppSBItem.getItemType(), (String)psAppSBItem.getPSAppViewId());
        }
        return super.getPSAppSBItemId(psAppSBItem);
    }

    @Override
    protected String getPSAppSBItemRSId(PSAppSBItemRS psAppSBItemRS) {
        return KeyValueHelper.genUniqueId((String)psAppSBItemRS.getRSType(), (String)psAppSBItemRS.getRSTag(), (String)psAppSBItemRS.getPPSAppSBItemId(), (String)psAppSBItemRS.getCPSAppSBItemId(), (String)psAppSBItemRS.getPSAppSBItemRSName());
    }
}

