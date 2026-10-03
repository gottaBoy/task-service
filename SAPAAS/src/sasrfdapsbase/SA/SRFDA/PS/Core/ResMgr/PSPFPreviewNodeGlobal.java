/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.config.entity.PSPFPreviewNode
 *  net.ibizsys.pscore.srv.config.service.PSPFPreviewNodeService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSPFPreviewAction
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.ResMgr;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPreviewNode;
import net.ibizsys.pscore.srv.config.service.PSPFPreviewNodeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPFPreviewAction;
import org.hibernate.SessionFactory;

public class PSPFPreviewNodeGlobal {
    private static PSPFPreviewNodeGlobal psPFPreviewNodeGlobal = null;
    private HashMap<String, PSPFPreviewNode> psPFPreviewNodeMap = new HashMap();
    private String strPSTaskServerId = null;

    public static void setCurrent(PSPFPreviewNodeGlobal psPFPreviewNodeGlobal) {
        PSPFPreviewNodeGlobal.psPFPreviewNodeGlobal = psPFPreviewNodeGlobal;
    }

    public static PSPFPreviewNodeGlobal getCurrent() {
        return psPFPreviewNodeGlobal;
    }

    public void init(String strPSTaskServerId) throws Exception {
        this.strPSTaskServerId = strPSTaskServerId;
        this.reload();
    }

    public synchronized void reload() throws Exception {
        this.psPFPreviewNodeMap.clear();
        PSPFPreviewNodeService psPFPreviewNodeService = (PSPFPreviewNodeService)ServiceGlobal.getService(PSPFPreviewNodeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSTASKSERVERID", (Object)this.strPSTaskServerId);
        ArrayList<PSPFPreviewNode> psPFPreviewNodeList = psPFPreviewNodeService.select((ISelectCond)selectCond);
        for (PSPFPreviewNode psPFPreviewNode : psPFPreviewNodeList) {
            if (psPFPreviewNode.getASState() != 20 && psPFPreviewNode.getASState() != 30) continue;
            this.psPFPreviewNodeMap.put(psPFPreviewNode.getPSPFPreviewNodeId(), psPFPreviewNode);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPreviewNode getPSPFPreviewNode(PSPFPreviewAction psPFPreviewAction) throws Exception {
        String strTag = KeyValueHelper.genUniqueId((String)"PSPFPREVIEWACTION", (String)psPFPreviewAction.getPSDevSlnSysId(), (String)psPFPreviewAction.getPSObjType(), (String)psPFPreviewAction.getPSObjId(), (String)psPFPreviewAction.getActionParam());
        PSPFPreviewNode psPFPreviewNode = null;
        HashMap<String, PSPFPreviewNode> hashMap = this.psPFPreviewNodeMap;
        synchronized (hashMap) {
            for (Map.Entry<String, PSPFPreviewNode> entry : this.psPFPreviewNodeMap.entrySet()) {
                if (StringHelper.compare((String)entry.getValue().getCreateMan(), (String)strTag, (boolean)true) != 0) continue;
                psPFPreviewNode = this.psPFPreviewNodeMap.remove(entry.getKey());
                break;
            }
            if (psPFPreviewNode == null) {
                for (Map.Entry<String, PSPFPreviewNode> entry : this.psPFPreviewNodeMap.entrySet()) {
                    if (StringHelper.compare((String)entry.getValue().getPSPFId(), (String)psPFPreviewAction.getPSPFId(), (boolean)true) != 0 || entry.getValue().getLastPreviewTime() != null && entry.getValue().getLastPreviewTime().getTime() + 60000L >= System.currentTimeMillis()) continue;
                    psPFPreviewNode = this.psPFPreviewNodeMap.remove(entry.getKey());
                    break;
                }
            }
        }
        if (psPFPreviewNode == null) {
            return psPFPreviewNode;
        }
        PSPFPreviewNode psPFPreviewNode2 = new PSPFPreviewNode();
        psPFPreviewNode2.setPSPFPreviewNodeId(psPFPreviewNode.getPSPFPreviewNodeId());
        psPFPreviewNode2.setLastPreviewTime(new Timestamp(System.currentTimeMillis()));
        PSPFPreviewNodeService psPFPreviewNodeService = (PSPFPreviewNodeService)ServiceGlobal.getService(PSPFPreviewNodeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psPFPreviewNodeService.update(psPFPreviewNode2);
        psPFPreviewNode2.setCreateMan(strTag);
        HashMap<String, PSPFPreviewNode> hashMap2 = this.psPFPreviewNodeMap;
        synchronized (hashMap2) {
            this.psPFPreviewNodeMap.put(psPFPreviewNode2.getPSPFPreviewNodeId(), psPFPreviewNode2);
        }
        return psPFPreviewNode;
    }
}
