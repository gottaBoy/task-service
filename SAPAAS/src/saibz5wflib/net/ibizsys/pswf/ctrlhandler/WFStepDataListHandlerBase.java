/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetCond
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEWF
 *  net.ibizsys.paas.ctrlhandler.ListHandlerBase
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 */
package net.ibizsys.pswf.ctrlhandler;

import java.util.ArrayList;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.ctrlhandler.ListHandlerBase;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

public abstract class WFStepDataListHandlerBase
extends ListHandlerBase {
    protected void onFillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        super.onFillDEDataSetFetchContext(deDataSetFetchContextImpl);
        String strParentDEId = WebContext.getParentDEId((IWebContext)this.getWebContext());
        if (StringHelper.isNullOrEmpty((String)strParentDEId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7236\u5b9e\u4f53\u6807\u8bc6");
        }
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)strParentDEId);
        IDEWF iDEWF = iDataEntityModel.getDefaultDEWF();
        if (iDEWF == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u652f\u6301\u5de5\u4f5c\u6d41", (Object)iDataEntityModel.getName()));
        }
        String strParentKey = WebContext.getParentKey((IWebContext)this.getWebContext());
        if (StringHelper.isNullOrEmpty((String)strParentKey)) {
            deDataSetFetchContextImpl.setCancel(true);
            return;
        }
        deDataSetFetchContextImpl.setPageSize(9999);
        deDataSetFetchContextImpl.setSort("createdate");
        deDataSetFetchContextImpl.setSortDir("asc");
        IEntity activeUserData = iDataEntityModel.createEntity();
        activeUserData.set(iDataEntityModel.getKeyDEField().getName(), (Object)strParentKey);
        iDataEntityModel.getService(this.getSessionFactory()).get(activeUserData);
        StringBuilderEx script = new StringBuilderEx();
        String strWFInstFieldExp = iDEWF.getWFInstField();
        if (!StringHelper.isNullOrEmpty((String)strWFInstFieldExp)) {
            script.append(" INNER JOIN T_SRFWFINSTANCE wf1 ON ${srfdefieldexp('%1$s')} = wf1.WFINSTANCEID ", (Object)strWFInstFieldExp);
            deDataSetFetchContextImpl.setJoinScript(script.toString());
            String strActiveWFInstId = DataObject.getStringValue((IDataObject)activeUserData, (String)iDEWF.getWFInstField(), null);
            String strCondition = "";
            strCondition = !StringHelper.isNullOrEmpty((String)strActiveWFInstId) ? StringHelper.format((String)"(wf1.USERDATA='%1$s' AND wf1.USERDATA4='%2$s' AND wf1.WFINSTANCEID= '%3$s') OR (wf1.USERDATA2='%1$s' AND wf1.PWFINSTANCEID= '%3$s') ", (Object)strParentKey, (Object)strParentDEId, (Object)strActiveWFInstId) : StringHelper.format((String)"(wf1.USERDATA='%1$s' AND wf1.USERDATA4='%2$s') OR (wf1.USERDATA2='%1$s' AND wf1.USERDATA3='%2$s') ", (Object)strParentKey, (Object)strParentDEId);
            ArrayList userConditionList = deDataSetFetchContextImpl.getConditionList();
            DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
            deDataSetCondImpl.setCondType("CUSTOM");
            deDataSetCondImpl.setCustomCond(strCondition);
            userConditionList.add(deDataSetCondImpl);
        }
    }
}

