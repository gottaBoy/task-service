/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParamBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDELogicNodeService
extends PSDELogicNodeServiceBase {
    private static final Log log = LogFactory.getLog(PSDELogicNodeService.class);

    @Override
    protected void onAfterGetDraftTemp(PSDELogicNode pSDELogicNode) throws Exception {
        String string = pSDELogicNode.getCodeName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSDELogicNodeDefaultCodeName(pSDELogicNode);
        }
        super.onAfterGetDraftTemp(pSDELogicNode);
    }

    protected void fillPSDELogicNodeDefaultCodeName(PSDELogicNode pSDELogicNode) throws Exception {
        int n = 1;
        String string = pSDELogicNode.getLogicNodeType();
        String string2 = string;
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return;
        }
        string2 = string2.toLowerCase();
        PSDELogic pSDELogic = new PSDELogic();
        pSDELogic.setPSDELogicId(pSDELogicNode.getPSDELogicId());
        ArrayList<PSDELogicNode> arrayList = null;
        arrayList = pSDELogic.getPSDELogicId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSDELogic(pSDELogic) : this.selectByPSDELogic(pSDELogic);
        HashMap<String, PSDELogicNode> hashMap = new HashMap<String, PSDELogicNode>();
        for (PSDELogicNode pSDELogicNode2 : arrayList) {
            hashMap.put(pSDELogicNode2.getCodeName().toLowerCase(), pSDELogicNode2);
        }
        Object object;
        while (true) {
            if (!hashMap.containsKey(object = StringHelper.format((String)"%1$s%2$s", (Object)string2, (Object)(n == 0 ? "" : Integer.valueOf(n))))) break;
            ++n;
        }
        object = ((String)object).substring(0, 1).toUpperCase() + ((String)object).substring(1);
        pSDELogicNode.setCodeName((String)object);
    }

    protected boolean onFillEntityKeyValue(PSDELogicNode pSDELogicNode, boolean bl) throws Exception {
        if (StringHelper.compare((String)pSDELogicNode.getLogicNodeType(), (String)"BEGIN", (boolean)true) == 0) {
            pSDELogicNode.setPSDELogicNodeId(pSDELogicNode.getPSDELogicId());
            return true;
        }
        return super.onFillEntityKeyValue(pSDELogicNode, bl);
    }

    @Override
    public Object getDataContextValue(PSDELogicNode pSDELogicNode, String string, IDataContextParam iDataContextParam) throws Exception {
        if (iDataContextParam != null && StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEACTION", (boolean)true) == 0) {
            return pSDELogicNode.getDstPSDEId();
        }
        return super.getDataContextValue(pSDELogicNode, string, iDataContextParam);
    }

    @Override
    protected void importCurXmlModel(PSDELogicNode pSDELogicNode, XmlNode xmlNode) throws Exception {
        Object object;
        PSDELogicParamService pSDELogicParamService = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
        String string = xmlNode.getAttribute("SRCPSDLPARAMNAME", "");
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSDELogicParam sourceParam = new PSDELogicParam();
            sourceParam.setPSDELogicParamName(string);
            sourceParam.setPSDELogicId(pSDELogicNode.getPSDELogicId());
            pSDELogicParamService.selectTemp(sourceParam, false);
            pSDELogicNode.setSrcPSDLParamId(sourceParam.getPSDELogicParamId());
            xmlNode.setAttribute("SRCPSDLPARAMID", sourceParam.getPSDELogicParamId());
        }
        if (!StringHelper.isNullOrEmpty((String)(object = xmlNode.getAttribute("DSTPSDLPARAMNAME", "")))) {
            PSDELogicParam pSDELogicParam = new PSDELogicParam();
            pSDELogicParam.setPSDELogicParamName((String)object);
            pSDELogicParam.setPSDELogicId(pSDELogicNode.getPSDELogicId());
            pSDELogicParamService.selectTemp(pSDELogicParam, false);
            pSDELogicNode.setDstPSDLParamId(pSDELogicParam.getPSDELogicParamId());
            xmlNode.setAttribute("DSTPSDLPARAMID", pSDELogicParam.getPSDELogicParamId());
        }
        super.importCurXmlModel(pSDELogicNode, xmlNode);
    }
}
