/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.template.SimpleCollection
 *  freemarker.template.SimpleHash
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WS.Ctrl.WSHelper;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.WS.Common.SRFWSGlobal;
import SA.SRFDA.WS.Ctrl.Data.WSChannel;
import SA.SRFDA.WS.Ctrl.Data.WSWPNavBar;
import SA.SRFDA.WS.Ctrl.IWSPageHelper;
import SA.SRFDA.WS.Ctrl.WSHelper.BaseWSWebPartHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Utility.StringHelper;
import freemarker.template.SimpleCollection;
import freemarker.template.SimpleHash;
import java.util.Map;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WSWPNavBarHelper
extends BaseWSWebPartHelper {
    Log log = LogFactory.getLog(WSWPNavBarHelper.class);
    int nLevel = 1;
    WSWPNavBar wsWPNavBar = null;

    @Override
    protected void OnFillIndexDataEntity(DataRow dr) throws Exception {
        this.wsWPNavBar = new WSWPNavBar();
        this.wsWPNavBar.FromDataRow(dr);
    }

    @Override
    protected void FillPageWebPartModelContext(Map<String, Object> pageWebPartModellMap) {
        String strPWSChannelId = this.getWSChannelId();
        pageWebPartModellMap.put(this.wsWebPart.getWSWBTYPENAME(), this.OnGetNavBarModel(strPWSChannelId));
    }

    protected Object OnGetNavBarModel(String strPWSChannelId) {
        Vector<SimpleHash> shList = new Vector<SimpleHash>();
        Vector<WSChannel> channels = new Vector<WSChannel>();
        try {
            this.SelectWSChannels(strPWSChannelId, channels);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (channels.size() <= 0) {
            this.nLevel = 1;
        }
        boolean bIsShowSubNavBar = this.wsWPNavBar.getISSHOWSUBNAVBAR();
        for (WSChannel wsChannel : channels) {
            SimpleHash sh = new SimpleHash();
            String strWSChannelId = wsChannel.getWSCHANNELID();
            sh.put("ID", (Object)strWSChannelId);
            sh.put("NAME", (Object)wsChannel.getWSCHANNELNAME());
            String strDefaultWSPageId = wsChannel.getDEFAULTWSPAGEID();
            sh.put("DEFAULTWSPAGEID", (Object)strDefaultWSPageId);
            IWSPageHelper wsPageHelper = null;
            if (!StringHelper.IsNullOrEmpty((String)strDefaultWSPageId)) {
                try {
                    wsPageHelper = this.getWSModelStorage().FindWSWebSiteHelper(wsChannel.getWSWEBSITEID()).FindWSPageHelper(strDefaultWSPageId);
                }
                catch (Exception e) {
                    e.printStackTrace();
                    this.log.debug((Object)StringHelper.Format((String)"[%1$s]\u83b7\u53d6\u9891\u9053\u9ed8\u8ba4\u9875\u9762\u8f85\u52a9\u5bf9\u8c61\u53d1\u751f\u9519\u8bef", (Object)this.getClass().getName()));
                }
            }
            String strHref = "#";
            String strTarget = "";
            if (wsPageHelper != null) {
                strHref = StringHelper.Format((String)"../%1$s", (Object)wsPageHelper.getPublishedPageUrl());
                strTarget = wsPageHelper.getWSPage().getTARGET();
            }
            sh.put("HREF", (Object)strHref);
            sh.put("TARGET", (Object)strTarget);
            if (bIsShowSubNavBar) {
                sh.put(StringHelper.Format((String)"SUBNAVBAR%1$s", (Object)(this.nLevel - 1)), this.OnGetNavBarModel(strWSChannelId));
            }
            shList.add(sh);
        }
        ++this.nLevel;
        return new SimpleCollection(shList);
    }

    protected void SelectWSChannels(String strPWSChannelId, Vector<WSChannel> channels) throws Exception {
        IDEHelper iDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(SRFWSGlobal.DEID_WSCHANNEL);
        if (iDEHelper == null) {
            throw new Exception(StringHelper.Format((String)"[%1$s]\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.getClass().getName(), (Object)SRFWSGlobal.DEID_WSCHANNEL));
        }
        String strSql = StringHelper.Format((String)"select * from %1$s where ", (Object)iDEHelper.getDataEntity().getVIEWNAME());
        strSql = String.valueOf(strSql) + StringHelper.Format((String)"wswebsiteid = '%1$s' ", (Object)this.getWSPageHelper().getWSPage().getWSWEBSITEID());
        strSql = StringHelper.IsNullOrEmpty((String)strPWSChannelId) ? String.valueOf(strSql) + StringHelper.Format((String)"and %1$s is null ", (Object)"PWSCHANNELID", (Object)strPWSChannelId) : String.valueOf(strSql) + StringHelper.Format((String)"and %1$s = '%2$s'", (Object)"PWSCHANNELID", (Object)strPWSChannelId);
        strSql = String.valueOf(strSql) + " order by orderno asc";
        SelectResult selectResult = null;
        try {
            selectResult = this.iDAGlobalHelper.getDBCaller(iDEHelper.GetDBStorage()).CallRaw2(strSql);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (selectResult == null) {
            throw new Exception(StringHelper.Format((String)"\u6267\u884c\u5b9e\u4f53[%1$s]\u67e5\u8be2[%2$s]\u53d1\u751f\u9519\u8bef", (Object)SRFWSGlobal.DEID_WSCHANNEL, (Object)strSql));
        }
        for (Object obj : selectResult.getMainTable().getRows()) {
            DataRow dr = (DataRow)obj;
            WSChannel wsChannel = new WSChannel();
            wsChannel.FromDataRow(dr);
            channels.add(wsChannel);
        }
    }

    protected String getWSChannelId() {
        return this.wsWPNavBar.getWSCHANNELID();
    }
}

