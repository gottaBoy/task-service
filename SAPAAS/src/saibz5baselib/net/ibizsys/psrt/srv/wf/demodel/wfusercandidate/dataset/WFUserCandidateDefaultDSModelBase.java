/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfusercandidate.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="9f2a5bbda357d70344cb5debd7d05c71",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="DAEA0DFB-06AD-4D74-BF65-A7D8780794F1",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFUserCandidateDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFUserCandidateDefaultDSModelBase() {
        super();

        this.initAnnotation(WFUserCandidateDefaultDSModelBase.class);
    }




}