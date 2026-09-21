/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.MBList
 *  SA.SRFDA.Ctrl.Data.MBPanel
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.Mobile.Panel;

import SA.SRFDA.Ctrl.Data.MBList;
import SA.SRFDA.Ctrl.Data.MBPanel;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Mobile.Panel.IMobilePanel;
import SA.SRFDA.Mobile.UIPart.BaseMobileUIPart;
import SA.SRFDA.Mobile.UIPart.IMobilePublishContext;
import SA.SRFDA.Mobile.UIPart.IMobileUIPart;
import SA.SRFDA.Mobile.UIPart.MobileList;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Hashtable;
import java.util.Vector;

public abstract class BaseMobilePanel
extends BaseMobileUIPart
implements IMobilePanel {
    protected MBPanel mbPanel = null;
    private boolean bCalcRelatedParts = false;
    protected Vector<String> relatedParts = new Vector();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IDEHelper iDEHelper, String strId, MBPanel mbPanel) throws Exception {
        this.mbPanel = mbPanel;
        if (this.mbPanel == null) {
            throw new Exception("\u79fb\u52a8\u9762\u677f\u5bf9\u8c61\u65e0\u6548");
        }
        this.BaseInit(iDAGlobalHelper, iDEHelper, strId);
    }

    @Override
    protected String OnUIPartCodeGetExtendClass(IMobilePublishContext context) {
        return "Ext.Panel";
    }

    @Override
    public void CalcRelatedParts(Vector<String> relatedParts) throws Exception {
        if (!this.bCalcRelatedParts) {
            this.OnCalcRelatedParts();
            this.bCalcRelatedParts = true;
        }
        for (String strPartId : this.relatedParts) {
            relatedParts.add(strPartId);
        }
    }

    protected void OnCalcRelatedParts() throws Exception {
    }

    @Override
    public void GetRelatedUIParts(Vector<IMobileUIPart> relatedUIParts) throws Exception {
        BaseMobilePanel.GetRelatedUIParts(this, relatedUIParts);
    }

    private static void GetRelatedUIParts(IMobilePanel mobilePanel, Vector<IMobileUIPart> relatedUIParts) throws Exception {
        Hashtable<String, IMobileUIPart> loadedUIParts = new Hashtable<String, IMobileUIPart>();
        loadedUIParts.put(mobilePanel.getId(), mobilePanel);
        Vector<String> relatedUIPartIds = new Vector<String>();
        mobilePanel.CalcRelatedParts(relatedUIPartIds);
        Hashtable<String, IDEHelper> deHelperMap = new Hashtable<String, IDEHelper>();
        deHelperMap.put(mobilePanel.getDEHelper().getId(), mobilePanel.getDEHelper());
        while (relatedUIPartIds.size() > 0) {
            String strUIPartId = relatedUIPartIds.remove(0);
            if (loadedUIParts.containsKey(strUIPartId)) continue;
            IMobileUIPart mobileUIPart = BaseMobilePanel.CreateMobileUIPart(mobilePanel.getDAGlobalHelper(), strUIPartId, deHelperMap);
            loadedUIParts.put(mobileUIPart.getId(), mobileUIPart);
            relatedUIParts.add(mobileUIPart);
            if (!(mobileUIPart instanceof IMobilePanel)) continue;
            IMobilePanel loadMobilePanel = (IMobilePanel)mobileUIPart;
            loadMobilePanel.CalcRelatedParts(relatedUIPartIds);
        }
    }

    private static IMobileUIPart CreateMobileUIPart(ISRFDAGlobalHelper iDAGlobalHelper, String strUIPartId, Hashtable<String, IDEHelper> deHelperMap) throws Exception {
        String[] items = strUIPartId.split("[;]");
        if (items.length != 3) {
            throw new Exception(StringHelper.Format((String)"\u79fb\u52a8\u5e94\u7528\u90e8\u4ef6\u6807\u8bc6[%1$s]\u65e0\u6548", (Object)strUIPartId));
        }
        String strUIPartTypeId = items[0];
        String strDEId = items[1];
        String strRealUIPartId = items[2];
        IDEHelper iDEHelper = null;
        if (!deHelperMap.containsKey(strDEId)) {
            iDEHelper = iDAGlobalHelper.getDAModelStorage().FindDEHelper(strDEId);
            if (iDEHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
            }
            deHelperMap.put(strDEId, iDEHelper);
        } else {
            iDEHelper = deHelperMap.get(strDEId);
        }
        if (StringHelper.Compare((String)strUIPartTypeId, (String)"DE0431", (boolean)true) == 0) {
            MBPanel mbPanel = iDAGlobalHelper.getDAModelStorage().FindMBPanel(strRealUIPartId);
            if (mbPanel == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u79fb\u52a8\u5e94\u7528\u9762\u677f\u5bf9\u8c61[%1$s]", (Object)strRealUIPartId));
            }
            IMobilePanel mobilePanel = BaseMobilePanel.CreateMobilePanel(iDAGlobalHelper, iDEHelper, mbPanel);
            mobilePanel.Init(iDAGlobalHelper, iDEHelper, strUIPartId, mbPanel);
            return mobilePanel;
        }
        if (StringHelper.Compare((String)strUIPartTypeId, (String)"DE0410", (boolean)true) == 0) {
            MBList mbList = new MBList();
            CallResult callResult = iDAGlobalHelper.getDAModelHelper().GetMBList(strRealUIPartId, mbList);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u79fb\u52a8\u5e94\u7528\u5217\u8868\u5bf9\u8c61[%1$s]", (Object)strRealUIPartId));
            }
            MobileList mobileList = new MobileList();
            mobileList.Init(iDAGlobalHelper, iDEHelper, strUIPartId, mbList);
            return mobileList;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u79fb\u52a8\u5e94\u7528\u754c\u9762\u5bf9\u8c61[%1$s]", (Object)strUIPartId));
    }

    public static IMobilePanel CreateMobilePanel(ISRFDAGlobalHelper iDAGlobalHelper, IDEHelper iDEHelper, MBPanel mbPanel) throws Exception {
        String strTemplObject = mbPanel.GetParamStringValue("TEMPLOBJECT", "");
        if (StringHelper.IsNullOrEmpty((String)strTemplObject)) {
            strTemplObject = mbPanel.getPANELOBJECT();
        }
        if (StringHelper.IsNullOrEmpty((String)strTemplObject)) {
            throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u79fb\u52a8\u9762\u677f\u5bf9\u5e94\u7684\u5bf9\u8c61");
        }
        Object objMobilePanel = ObjectHelper.Create((String)strTemplObject);
        if (objMobilePanel == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u79fb\u52a8\u9762\u677f\u5bf9\u8c61[%1$s]", (Object)strTemplObject));
        }
        if (!(objMobilePanel instanceof IMobilePanel)) {
            throw new Exception(StringHelper.Format((String)"\u79fb\u52a8\u9762\u677f\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strTemplObject));
        }
        IMobilePanel mobilePanel = (IMobilePanel)objMobilePanel;
        mobilePanel.Init(iDAGlobalHelper, iDEHelper, BaseMobilePanel.CalcUIPartUniqueId("DE0431", iDEHelper.getId(), mbPanel.getMBPANELID()), mbPanel);
        return mobilePanel;
    }

    @Override
    protected String OnGetPublishJSFileName() {
        return StringHelper.Format((String)"MBP_%1$s_%2$s.js", (Object)this.getDEHelper().getName(), (Object)this.mbPanel.getMBPANELID());
    }
}

