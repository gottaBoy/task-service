/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdpolicyowner.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="f19ecba385e1fe480789956e5f638b78",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="D365105B-BF2D-435F-A0E1-C5C4A6AC7816",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class TSSDPolicyOwnerDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public TSSDPolicyOwnerDefaultDSModelBase() {
        super();

        this.initAnnotation(TSSDPolicyOwnerDefaultDSModelBase.class);
    }




}