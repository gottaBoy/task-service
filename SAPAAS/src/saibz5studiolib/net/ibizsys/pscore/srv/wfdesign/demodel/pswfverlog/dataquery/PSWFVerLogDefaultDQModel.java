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
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfverlog.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="57FD78AF-ADD4-46D1-9F3B-BC0A03A9E342", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`BACKDATATAG`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DYNAMODELFLAG`, t1.`MEMO`, t1.`PSDYNAINSTID`, t1.`PSWFVERLOGID`, t1.`PSWFVERLOGNAME`, t1.`PSWFVERSIONID`, t1.`PSWFVERSIONNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSWFVERLOG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BACKUPDATA", expression="t1.`BACKUPDATA`", showorder=-1), @DEDataQueryCodeExp(name="BACKDATATAG", expression="t1.`BACKDATATAG`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="DYNAMODELFLAG", expression="t1.`DYNAMODELFLAG`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.`PSDYNAINSTID`", showorder=5), @DEDataQueryCodeExp(name="PSWFVERLOGID", expression="t1.`PSWFVERLOGID`", showorder=6), @DEDataQueryCodeExp(name="PSWFVERLOGNAME", expression="t1.`PSWFVERLOGNAME`", showorder=7), @DEDataQueryCodeExp(name="PSWFVERSIONID", expression="t1.`PSWFVERSIONID`", showorder=8), @DEDataQueryCodeExp(name="PSWFVERSIONNAME", expression="t1.`PSWFVERSIONNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.BACKDATATAG, t1.CREATEDATE, t1.CREATEMAN, t1.DYNAMODELFLAG, t1.MEMO, t1.PSDYNAINSTID, t1.PSWFVERLOGID, t1.PSWFVERLOGNAME, t1.PSWFVERSIONID, t1.PSWFVERSIONNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSWFVERLOG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BACKUPDATA", expression="t1.BACKUPDATA", showorder=-1), @DEDataQueryCodeExp(name="BACKDATATAG", expression="t1.BACKDATATAG", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="DYNAMODELFLAG", expression="t1.DYNAMODELFLAG", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.PSDYNAINSTID", showorder=5), @DEDataQueryCodeExp(name="PSWFVERLOGID", expression="t1.PSWFVERLOGID", showorder=6), @DEDataQueryCodeExp(name="PSWFVERLOGNAME", expression="t1.PSWFVERLOGNAME", showorder=7), @DEDataQueryCodeExp(name="PSWFVERSIONID", expression="t1.PSWFVERSIONID", showorder=8), @DEDataQueryCodeExp(name="PSWFVERSIONNAME", expression="t1.PSWFVERSIONNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSWFVerLogDefaultDQModel
extends DEDataQueryModelBase {
    public PSWFVerLogDefaultDQModel() {
        this.initAnnotation(PSWFVerLogDefaultDQModel.class);
    }
}

