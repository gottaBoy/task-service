/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfucpolicy.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="fa6ff2a161c8371f494e170dde6ddb53",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="7476674A-5DBF-4358-BABB-C92BBE4804C3",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFUCPolicyDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFUCPolicyDefaultDSModelBase() {
        super();

        this.initAnnotation(WFUCPolicyDefaultDSModelBase.class);
    }




}