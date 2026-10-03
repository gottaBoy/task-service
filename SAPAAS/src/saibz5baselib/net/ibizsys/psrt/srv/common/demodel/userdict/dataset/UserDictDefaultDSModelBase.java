/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userdict.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="de0f12cf67b20fb12eb5454093998c74",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="5FD03BE2-5AFA-4929-A01E-D63C3A76E241",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class UserDictDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public UserDictDefaultDSModelBase() {
        super();

        this.initAnnotation(UserDictDefaultDSModelBase.class);
    }




}