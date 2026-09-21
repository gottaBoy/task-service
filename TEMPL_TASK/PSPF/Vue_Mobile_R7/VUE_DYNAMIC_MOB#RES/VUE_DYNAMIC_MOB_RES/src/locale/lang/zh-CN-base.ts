import userCustom_zh_CN from '@locale/lanres/userCustom/userCustom_zh_CN';
function getAppLocale(){
    const data: any = {
        app: {
            commonWords: {
                error: "失败",
                success: "成功",
                ok: "确认",
                cancel: "取消",
                save: "保存",
                codeNotExist: "代码表不存在",
                reqException: "请求异常",
                sysException: "系统异常",
                warning: "警告",
                wrong: "错误",
                rulesException: "值规则校验异常",
                saveSuccess: "保存成功",
                saveFailed: "保存失败",
                deleteSuccess: "删除成功",
                deleteError: "删除失败",
                delDataFail: "删除数据失败",
                noData: "暂无数据",
                startsuccess: "启动成功",
                submitsuccess: "提交成功",
                loadmore: "加载更多",
                nomore: "没有更多了",
                other: "其他",
                filter: '过滤',
                recentSearch: '最近搜索',
                chooseOne: '请选择一条',
                noAction: '行为不存在',
                noAssign: "未指定应用功能",
                serverException: '服务器异常',
                yes: "是",
                no: "否"
            },
            local: {
                new: "新建",
                add: "增加",
            },
            gridpage: {
                choicecolumns: '选择列',
                refresh: '刷新',
                show: '显示',
                records: '条',
                totle: '共',
            },
            tabpage: {
                sureclosetip: {
                    title: '关闭提醒',
                    content: '表单数据已经修改，确定要关闭？',
                },
                closeall: '关闭所有',
                closeother: '关闭其他',
            },
            fileUpload: {
                caption: '上传',
            },
            searchForm: {
                title: '条件搜索',
                searchButton: {
                    search: '搜索',
                    reset: '重置'
                }
            },
            form: {
                rules: {
                    'required': '值不能为空',
                    'string': '值必须为字符串',
                    'number': '值必须为数值'
                }
            },
            portlet: {
                noextensions: "无扩展插件",
            },
            formpage: {
                desc1: "操作失败,未能找到当前表单项",
                desc2: "无法继续操作",
                notconfig: {
                    loadaction: "视图表单loadAction参数未配置",
                    loaddraftaction: "视图表单loaddraftAction参数未配置",
                    actionname: "视图表单'+actionName+'参数未配置",
                    removeaction: "视图表单removeAction参数未配置",
                },
                saveerror: "保存数据发生错误",
                savecontent: "数据不一致，可能后台数据已经被修改,是否要重新加载数据？",
                valuecheckex: "值规则校验异常",
                savesuccess: "保存成功！",
                deletesuccess: "删除成功！",
                workflow: {
                    starterror: "工作流启动失败",
                    startsuccess: "工作流启动成功",
                    submiterror: "工作流提交失败",
                    submitsuccess: "工作流提交成功",
                },
                updateerror: "表单项更新失败",
            },
            viewName: {
                meditView: '多表单编辑视图'
            },
            components: {
                app_icon_menu: {
                    statusValue_open: '展开',
                    statusValue_close: '收回',
                },
                app_search_history: {
                    remind: '提醒',
                    clear: '是否清除搜索历史？'
                }
            },

            button: {
                cancel: '取消',
                confirm: '确认',
                back: '返回',
                loadmore: '加载更多',
                previousStep: '上一步',
                nextStep: '下一步',
                finish: '完成',
            },
            loadding: '加载中',
            fastsearch: '快速搜索',
            pulling_text: '下拉刷新',
            ctrl: {
                form: "表单",
                multieditviewpanel: "多编辑面板",
                searchform: "搜索表单",
            },
            view: "视图",
            notConfig: "参数未配置",
            message: {
                success: "成功",
                fail: "失败",
                savedSuccess: "保存成功",
                deleteSccess: "删除成功",
                warning: "警告",
                confirmToDelete: "确认删除 ",
                unrecoverable: " 删除操作将不可恢复",
                totle: "共",
                data: "条数据"
            },
            statusMessage: {
                200: '服务器成功返回请求的数据。',
                201: '新建或修改数据成功。',
                202: '一个请求已经进入后台排队（异步任务）。',
                204: '删除数据成功。',
                400: '发出的请求有错误，服务器没有进行新建或修改数据的操作。',
                401: '用户没有权限（令牌、用户名、密码错误）。',
                403: '用户得到授权，但是访问是被禁止的。',
                404: '发出的请求针对的是不存在的记录，服务器没有进行操作。',
                405: '方法不被允许',
                406: '请求的格式不可得。',
                410: '请求的资源被永久删除，且不会再得到的。',
                422: '当创建一个对象时，发生一个验证错误。',
                500: '服务器发生错误，请检查服务器。',
                502: '网关错误。',
                503: '服务不可用，服务器暂时过载或维护。',
                504: '网关超时。',
            },
            errorMessage: {
                100: '未知',
                101: '请求发生错误',
                5001: '数据不存在',
                5002: '数据已存在，无法重复创建',
                5003: '新建失败',
                5004: '数据不存在，无法保存',
                5005: '数据删除失败'
            },
            title: {
                choose: '选择',
                customDashboard: '自定义仪表盘',
                styleSetting: '风格设置'
            },
            pickupviewpanel: {
                havechosen: '已选择:'
            },
            error: {
                batchError: '批处理操作失败',
                systemError: '错误，系统异常',
                systemErrorRetry: '系统异常，请重试!',
                dataError: 'data数据异常',
                loadPanelError: '加载面板模型异常',
                unopendata: "没有opendata",
                unnewdata: "没有newdata",
                unremove: "没有remove",
                unrefresh: "没有refresh",
            },
            warn: {
                notSupportThisMode: '不支持该模式打开',
                editLogicNotExist: '编辑应用界面逻辑不存在',
                newLogicNotExist: '新建应用界面逻辑不存在',
                addNNInBatches: '批量添加需添加N:N关系',
                unbatchadd: '只支持批添加未实现',
                dynaViewNotFound: '未找到流程功能操作视图',
                markAsFailRead: '将待办任务标记为已读失败',
                getDataWarn: '获取数据异常'
            },
            log: {
                redirection: '重定向跳转......'
            },
            success: {
                submitSuccess: '提交数据成功'
            }
        },
        userCustom: userCustom_zh_CN
    }
    return data;
}
export default getAppLocale;