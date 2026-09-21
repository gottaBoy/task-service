/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDELogic
 */
package net.ibizsys.model.dataentity.logic;

import java.util.Iterator;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.logic.IPSDELogicLink;
import net.ibizsys.model.dataentity.logic.IPSDELogicNode;
import net.ibizsys.model.dataentity.logic.IPSDELogicParam;
import net.ibizsys.paas.core.IDELogic;

public interface IPSDELogic
extends IPSDataEntityObject,
IDELogic {
    public String getLogicType();

    public String getCodeName();

    public String getLogicName();

    public IPSDELogicNode getStartPSDELogicNode();

    public Iterator<IPSDELogicNode> getPSDELogicNodes();

    public Iterator<IPSDELogicParam> getPSDELogicParams();

    public IPSDELogicParam getPSDELogicParam(String var1) throws Exception;

    public IPSDELogicNode getPSDELogicNode(String var1) throws Exception;

    public Iterator<IPSDELogicLink> getPSDELogicLinks();

    public int getExtendMode();
}

