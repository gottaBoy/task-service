/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwdelogicnode.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B6735020-F1B5-433A-9D13-3DDE667CD068", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`LOGICNODETYPE`, t1.`PSDELOGICID`, t1.`PSDELOGICNODEID`, t1.`PSDELOGICNODENAME`, t1.`SRFDRAFTFLAG` FROM `T_SRFPSDELOGICNODE_TMP` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="LOGICNODETYPE", expression="t1.`LOGICNODETYPE`", showorder=0), @DEDataQueryCodeExp(name="PSDELOGICID", expression="t1.`PSDELOGICID`", showorder=1), @DEDataQueryCodeExp(name="PSDELOGICNODEID", expression="t1.`PSDELOGICNODEID`", showorder=2), @DEDataQueryCodeExp(name="PSDELOGICNODENAME", expression="t1.`PSDELOGICNODENAME`", showorder=3), @DEDataQueryCodeExp(name="SRFDRAFTFLAG", expression="t1.`SRFDRAFTFLAG`", showorder=4)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.LOGICNODETYPE, t1.PSDELOGICID, t1.PSDELOGICNODEID, t1.PSDELOGICNODENAME, t1.SRFDRAFTFLAG FROM T_SRFPSDELOGICNODE_TMP t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="LOGICNODETYPE", expression="t1.LOGICNODETYPE", showorder=0), @DEDataQueryCodeExp(name="PSDELOGICID", expression="t1.PSDELOGICID", showorder=1), @DEDataQueryCodeExp(name="PSDELOGICNODEID", expression="t1.PSDELOGICNODEID", showorder=2), @DEDataQueryCodeExp(name="PSDELOGICNODENAME", expression="t1.PSDELOGICNODENAME", showorder=3), @DEDataQueryCodeExp(name="SRFDRAFTFLAG", expression="t1.SRFDRAFTFLAG", showorder=4)}, conds={})})
public class PSUWDELogicNodeDefaultDQModel
extends DEDataQueryModelBase {
    public PSUWDELogicNodeDefaultDQModel() {
        this.initAnnotation(PSUWDELogicNodeDefaultDQModel.class);
    }
}

