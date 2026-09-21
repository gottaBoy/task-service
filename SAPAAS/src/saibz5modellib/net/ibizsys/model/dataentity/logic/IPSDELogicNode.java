/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.logic;

import java.util.Iterator;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.logic.IPSDELogicLink;
import net.ibizsys.model.dataentity.logic.IPSDELogicNodeParam;
import net.ibizsys.model.dataentity.logic.IPSDELogicParam;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.wf.IPSWorkflow;

public interface IPSDELogicNode
extends IPSModelObject {
    public Iterator<IPSDELogicLink> getPSDELogicLinks();

    public Iterator<IPSDELogicNodeParam> getPSDELogicNodeParams();

    public String getLogicNodeType();

    public IPSDELogic getPSDELogic();

    public String getCodeName();

    public boolean isParallelOutput();

    public IPSDataEntity getDstPSDataEntity() throws Exception;

    public IPSDEAction getDstPSDEAction() throws Exception;

    public IPSDELogicParam getDstPSDELogicParam() throws Exception;

    public Object getParam(String var1, Object var2);

    public IPSDELogicParam getSrcPSDELogicParam() throws Exception;

    public IPSWorkflow getPSWorkflow() throws Exception;

    public IPSDEWF getPSDEWF() throws Exception;
}

