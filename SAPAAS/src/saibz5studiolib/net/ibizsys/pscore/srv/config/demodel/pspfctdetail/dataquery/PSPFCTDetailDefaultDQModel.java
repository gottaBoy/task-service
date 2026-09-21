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
package net.ibizsys.pscore.srv.config.demodel.pspfctdetail.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="34737302-0F90-49A7-8474-5F9AB47EE7F5", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGICNAME`, t1.`MEMO`, t1.`PSPFCTDETAILID`, t1.`PSPFCTDETAILNAME`, t1.`PSPFCTRLTEMPLID`, t11.`PSPFCTRLTEMPLNAME`, t1.`PUBOBJ`, t1.`TEMPLCODE2`, t1.`TEMPLCODE3`, t1.`TEMPLCODE4`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSPFCTDETAIL` t1  LEFT JOIN T_SRFPSPFCTRLTEMPL t11 ON t1.PSPFCTRLTEMPLID = t11.PSPFCTRLTEMPLID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.`TEMPLCODE`", showorder=-1), @DEDataQueryCodeExp(name="TEMPLDESC", expression="t1.`TEMPLDESC`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSPFCTDETAILID", expression="t1.`PSPFCTDETAILID`", showorder=4), @DEDataQueryCodeExp(name="PSPFCTDETAILNAME", expression="t1.`PSPFCTDETAILNAME`", showorder=5), @DEDataQueryCodeExp(name="PSPFCTRLTEMPLID", expression="t1.`PSPFCTRLTEMPLID`", showorder=6), @DEDataQueryCodeExp(name="PSPFCTRLTEMPLNAME", expression="t11.`PSPFCTRLTEMPLNAME`", showorder=7), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.`PUBOBJ`", showorder=8), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.`TEMPLCODE2`", showorder=9), @DEDataQueryCodeExp(name="TEMPLCODE3", expression="t1.`TEMPLCODE3`", showorder=10), @DEDataQueryCodeExp(name="TEMPLCODE4", expression="t1.`TEMPLCODE4`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOGICNAME, t1.MEMO, t1.PSPFCTDETAILID, t1.PSPFCTDETAILNAME, t1.PSPFCTRLTEMPLID, t11.PSPFCTRLTEMPLNAME, t1.PUBOBJ, t1.TEMPLCODE2, t1.TEMPLCODE3, t1.TEMPLCODE4, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSPFCTDETAIL t1  LEFT JOIN T_SRFPSPFCTRLTEMPL t11 ON t1.PSPFCTRLTEMPLID = t11.PSPFCTRLTEMPLID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.TEMPLCODE", showorder=-1), @DEDataQueryCodeExp(name="TEMPLDESC", expression="t1.TEMPLDESC", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSPFCTDETAILID", expression="t1.PSPFCTDETAILID", showorder=4), @DEDataQueryCodeExp(name="PSPFCTDETAILNAME", expression="t1.PSPFCTDETAILNAME", showorder=5), @DEDataQueryCodeExp(name="PSPFCTRLTEMPLID", expression="t1.PSPFCTRLTEMPLID", showorder=6), @DEDataQueryCodeExp(name="PSPFCTRLTEMPLNAME", expression="t11.PSPFCTRLTEMPLNAME", showorder=7), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.PUBOBJ", showorder=8), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.TEMPLCODE2", showorder=9), @DEDataQueryCodeExp(name="TEMPLCODE3", expression="t1.TEMPLCODE3", showorder=10), @DEDataQueryCodeExp(name="TEMPLCODE4", expression="t1.TEMPLCODE4", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=14)}, conds={})})
public class PSPFCTDetailDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFCTDetailDefaultDQModel() {
        this.initAnnotation(PSPFCTDetailDefaultDQModel.class);
    }
}

