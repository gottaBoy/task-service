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
package net.ibizsys.pscore.srv.config.demodel.psctrltypemsgtag.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="26CE3D3A-5DA5-4F6D-BB9C-2A57E441A4D6", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONTENT`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSCTRLMSGTAGID`, t11.`PSCTRLMSGTAGNAME`, t1.`PSCTRLTYPEID`, t1.`PSCTRLTYPEMSGTAGID`, t1.`PSCTRLTYPEMSGTAGNAME`, t21.`PSCTRLTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSCTRLTYPEMSGTAG` t1  LEFT JOIN T_SRFPSCTRLMSGTAG t11 ON t1.PSCTRLMSGTAGID = t11.PSCTRLMSGTAGID  LEFT JOIN T_SRFPSCTRLTYPE t21 ON t1.PSCTRLTYPEID = t21.PSCTRLTYPEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSCTRLMSGTAGID", expression="t1.`PSCTRLMSGTAGID`", showorder=4), @DEDataQueryCodeExp(name="PSCTRLMSGTAGNAME", expression="t11.`PSCTRLMSGTAGNAME`", showorder=5), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.`PSCTRLTYPEID`", showorder=6), @DEDataQueryCodeExp(name="PSCTRLTYPEMSGTAGID", expression="t1.`PSCTRLTYPEMSGTAGID`", showorder=7), @DEDataQueryCodeExp(name="PSCTRLTYPEMSGTAGNAME", expression="t1.`PSCTRLTYPEMSGTAGNAME`", showorder=8), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t21.`PSCTRLTYPENAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CONTENT, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSCTRLMSGTAGID, t11.PSCTRLMSGTAGNAME, t1.PSCTRLTYPEID, t1.PSCTRLTYPEMSGTAGID, t1.PSCTRLTYPEMSGTAGNAME, t21.PSCTRLTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSCTRLTYPEMSGTAG t1  LEFT JOIN T_SRFPSCTRLMSGTAG t11 ON t1.PSCTRLMSGTAGID = t11.PSCTRLMSGTAGID  LEFT JOIN T_SRFPSCTRLTYPE t21 ON t1.PSCTRLTYPEID = t21.PSCTRLTYPEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSCTRLMSGTAGID", expression="t1.PSCTRLMSGTAGID", showorder=4), @DEDataQueryCodeExp(name="PSCTRLMSGTAGNAME", expression="t11.PSCTRLMSGTAGNAME", showorder=5), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.PSCTRLTYPEID", showorder=6), @DEDataQueryCodeExp(name="PSCTRLTYPEMSGTAGID", expression="t1.PSCTRLTYPEMSGTAGID", showorder=7), @DEDataQueryCodeExp(name="PSCTRLTYPEMSGTAGNAME", expression="t1.PSCTRLTYPEMSGTAGNAME", showorder=8), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t21.PSCTRLTYPENAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSCtrlTypeMsgTagDefaultDQModel
extends DEDataQueryModelBase {
    public PSCtrlTypeMsgTagDefaultDQModel() {
        this.initAnnotation(PSCtrlTypeMsgTagDefaultDQModel.class);
    }
}

