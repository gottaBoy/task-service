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
package net.ibizsys.pscore.srv.dynasys.demodel.psdynaworkflow.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="35818EED-D16F-4794-8C88-CB9E20B0D1C9", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DYNAMODELFLAG`, t1.`ENABLEMOB`, t1.`LOCKFLAG`, t1.`MEMO`, t1.`PSDENAME`, t1.`PSDYNAINSTID`, t1.`PSDYNAWORKFLOWID`, t1.`PSDYNAWORKFLOWNAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`SRCPSDYNADETEMPLID`, t1.`SRCPSDYNADETEMPLNAME`, t1.`SRCPSDYNAWORKFLOWID`, t1.`SRCPSDYNAWORKFLOWNAME`, t1.`SRCTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDYNAWORKFLOW` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DYNAMODELFLAG", expression="t1.`DYNAMODELFLAG`", showorder=2), @DEDataQueryCodeExp(name="ENABLEMOB", expression="t1.`ENABLEMOB`", showorder=3), @DEDataQueryCodeExp(name="LOCKFLAG", expression="t1.`LOCKFLAG`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.`PSDENAME`", showorder=6), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.`PSDYNAINSTID`", showorder=7), @DEDataQueryCodeExp(name="PSDYNAWORKFLOWID", expression="t1.`PSDYNAWORKFLOWID`", showorder=8), @DEDataQueryCodeExp(name="PSDYNAWORKFLOWNAME", expression="t1.`PSDYNAWORKFLOWNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=10), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=11), @DEDataQueryCodeExp(name="SRCPSDYNADETEMPLID", expression="t1.`SRCPSDYNADETEMPLID`", showorder=12), @DEDataQueryCodeExp(name="SRCPSDYNADETEMPLNAME", expression="t1.`SRCPSDYNADETEMPLNAME`", showorder=13), @DEDataQueryCodeExp(name="SRCPSDYNAWORKFLOWID", expression="t1.`SRCPSDYNAWORKFLOWID`", showorder=14), @DEDataQueryCodeExp(name="SRCPSDYNAWORKFLOWNAME", expression="t1.`SRCPSDYNAWORKFLOWNAME`", showorder=15), @DEDataQueryCodeExp(name="SRCTYPE", expression="t1.`SRCTYPE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=18), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=19)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DYNAMODELFLAG, t1.ENABLEMOB, t1.LOCKFLAG, t1.MEMO, t1.PSDENAME, t1.PSDYNAINSTID, t1.PSDYNAWORKFLOWID, t1.PSDYNAWORKFLOWNAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.SRCPSDYNADETEMPLID, t1.SRCPSDYNADETEMPLNAME, t1.SRCPSDYNAWORKFLOWID, t1.SRCPSDYNAWORKFLOWNAME, t1.SRCTYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDYNAWORKFLOW t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DYNAMODELFLAG", expression="t1.DYNAMODELFLAG", showorder=2), @DEDataQueryCodeExp(name="ENABLEMOB", expression="t1.ENABLEMOB", showorder=3), @DEDataQueryCodeExp(name="LOCKFLAG", expression="t1.LOCKFLAG", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.PSDENAME", showorder=6), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.PSDYNAINSTID", showorder=7), @DEDataQueryCodeExp(name="PSDYNAWORKFLOWID", expression="t1.PSDYNAWORKFLOWID", showorder=8), @DEDataQueryCodeExp(name="PSDYNAWORKFLOWNAME", expression="t1.PSDYNAWORKFLOWNAME", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=10), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=11), @DEDataQueryCodeExp(name="SRCPSDYNADETEMPLID", expression="t1.SRCPSDYNADETEMPLID", showorder=12), @DEDataQueryCodeExp(name="SRCPSDYNADETEMPLNAME", expression="t1.SRCPSDYNADETEMPLNAME", showorder=13), @DEDataQueryCodeExp(name="SRCPSDYNAWORKFLOWID", expression="t1.SRCPSDYNAWORKFLOWID", showorder=14), @DEDataQueryCodeExp(name="SRCPSDYNAWORKFLOWNAME", expression="t1.SRCPSDYNAWORKFLOWNAME", showorder=15), @DEDataQueryCodeExp(name="SRCTYPE", expression="t1.SRCTYPE", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=18), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=19)}, conds={})})
public class PSDynaWorkflowDefaultDQModel
extends DEDataQueryModelBase {
    public PSDynaWorkflowDefaultDQModel() {
        this.initAnnotation(PSDynaWorkflowDefaultDQModel.class);
    }
}

