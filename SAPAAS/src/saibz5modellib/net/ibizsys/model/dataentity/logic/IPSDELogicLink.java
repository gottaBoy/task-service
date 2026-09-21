/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.logic;

import java.util.Iterator;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCond;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkGroupCond;
import net.ibizsys.model.dataentity.logic.IPSDELogicNode;

public interface IPSDELogicLink
extends IPSModelObject {
    public IPSDELogicLinkGroupCond getPSDELogicLinkGroupCond();

    public IPSDELogicNode getDstPSDELogicNode() throws Exception;

    public IPSDELogicNode getSrcPSDELogicNode() throws Exception;

    public IPSDELogic getPSDELogic();

    public Iterator<IPSDELogicLinkCond> getAllPSDELogicLinkConds();
}

