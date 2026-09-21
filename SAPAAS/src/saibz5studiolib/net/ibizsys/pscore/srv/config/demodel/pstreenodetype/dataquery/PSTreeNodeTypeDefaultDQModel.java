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
package net.ibizsys.pscore.srv.config.demodel.pstreenodetype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="9EC7ED69-BB57-493D-9AAB-F93BE6E46351", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSTREENODETYPEID`, t1.`PSTREENODETYPENAME`, t1.`TREENODEOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSTREENODETYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSTREENODETYPEID", expression="t1.`PSTREENODETYPEID`", showorder=3), @DEDataQueryCodeExp(name="PSTREENODETYPENAME", expression="t1.`PSTREENODETYPENAME`", showorder=4), @DEDataQueryCodeExp(name="TREENODEOBJ", expression="t1.`TREENODEOBJ`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSTREENODETYPEID, t1.PSTREENODETYPENAME, t1.TREENODEOBJ, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSTREENODETYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSTREENODETYPEID", expression="t1.PSTREENODETYPEID", showorder=3), @DEDataQueryCodeExp(name="PSTREENODETYPENAME", expression="t1.PSTREENODETYPENAME", showorder=4), @DEDataQueryCodeExp(name="TREENODEOBJ", expression="t1.TREENODEOBJ", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSTreeNodeTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSTreeNodeTypeDefaultDQModel() {
        this.initAnnotation(PSTreeNodeTypeDefaultDQModel.class);
    }
}

