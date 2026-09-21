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
package net.ibizsys.pscore.srv.config.demodel.psctrlmsgtag.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="8547BBB2-4E3F-4554-A32D-0087EAC3F503", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONTENT`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGICNAME`, t1.`MEMO`, t1.`PSCTRLMSGTAGID`, t1.`PSCTRLMSGTAGNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSCTRLMSGTAG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSCTRLMSGTAGID", expression="t1.`PSCTRLMSGTAGID`", showorder=5), @DEDataQueryCodeExp(name="PSCTRLMSGTAGNAME", expression="t1.`PSCTRLMSGTAGNAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CONTENT, t1.CREATEDATE, t1.CREATEMAN, t1.LOGICNAME, t1.MEMO, t1.PSCTRLMSGTAGID, t1.PSCTRLMSGTAGNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSCTRLMSGTAG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSCTRLMSGTAGID", expression="t1.PSCTRLMSGTAGID", showorder=5), @DEDataQueryCodeExp(name="PSCTRLMSGTAGNAME", expression="t1.PSCTRLMSGTAGNAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=9)}, conds={})})
public class PSCtrlMsgTagDefaultDQModel
extends DEDataQueryModelBase {
    public PSCtrlMsgTagDefaultDQModel() {
        this.initAnnotation(PSCtrlMsgTagDefaultDQModel.class);
    }
}

