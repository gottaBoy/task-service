import userCustom_en_US from '@locale/lanres/userCustom/userCustom_en_US';;
import commonLogic from '@/locale/logic/common/common-logic';


function getAppLocale() {
    const data: any = {
        app: {
            commonWords: {
                error: "Error",
                success: "Success",
                ok: "OK",
                cancel: "Cancel",
                save: "Save",
                codeNotExist: 'Code list does not exist',
                reqException: "Request exception",
                sysException: "System abnormality",
                warning: "Warning",
                wrong: "Error",
                rulesException: "Abnormal value check rule",
                saveSuccess: "Saved successfully",
                saveFailed: "Save failed",
                deleteSuccess: "Successfully deleted!",
                deleteError: "Failed to delete",
                delDataFail: "Failed to delete data",
                noData: "No data",
                startsuccess: "Start successful",
                submitsuccess: "Submit successful",
                loadmore: "Load more",
                nomore: "No more",
                other: "other",
                filter: 'filter',
                recentSearch: 'Recent search',
                chooseOne: 'Choose One',
                noAction: 'NO Action',
                noAssign: "No application function specified",
                serverException: 'Server exception',
                yes: "Yes",
                no: "No"
            },
            local: {
                new: "New",
                add: "Add",
            },
            gridpage: {
                choicecolumns: 'Choice columns',
                refresh: 'refresh',
                show: 'Show',
                records: 'records',
                totle: 'totle',
            },
            tabpage: {
                sureclosetip: {
                    title: 'Close warning',
                    content: 'Form data Changed, are sure close?',
                },
                closeall: 'Close all',
                closeother: 'Close other',
            },
            fileUpload: {
                caption: 'Upload',
            },
            searchForm: {
                title: 'Conditional search',
                searchButton: {
                    search: 'Search',
                    reset: 'Reset'
                }
            },
            form: {
                rules: {
                    'required': 'cannot be empty',
                    'string': 'must be a string',
                    'number': 'must be a number'
                }
            },
            portlet: {
                noextensions: "No Extensions",
            },
            formpage: {
                error: "Error",
                desc1: "Operation failed, failed to find current form item",
                desc2: "Can't continue",
                notconfig: {
                    loadaction: "View form loadAction parameter is not configured",
                    loaddraftaction: "View form loaddraftAction parameter is not configured",
                    actionname: "View form actionName parameter is not configured",
                    removeaction: "View form removeAction parameter is not configured",
                },
                saveerror: "Error saving data",
                savecontent: "The data is inconsistent. The background data may have been modified. Do you want to reload the data?",
                valuecheckex: "Value rule check exception",
                savesuccess: "Saved successfully!",
                deletesuccess: "Successfully deleted!",
                workflow: {
                    starterror: "Workflow started successfully",
                    startsuccess: "Workflow failed to start",
                    submiterror: "Workflow submission failed",
                    submitsuccess: "Workflow submitted successfully",
                },
                updateerror: "Form item update failed",
            },
            viewName: {
                meditView: 'Multi form editing view'
            },
            components: {
                app_icon_menu: {
                    statusValue_open: 'open',
                    statusValue_close: 'close',
                },
                app_search_history: {
                    remind: 'remind',
                    clear: 'Do you want to clear the search history?'
                }
            },
            button: {
                cancel: 'Cancel',
                confirm: 'Confirm',
                back: 'Back',
                loadmore: 'Load more',
                previousStep: 'Previous step',
                nextStep: 'Next step',
                finish: 'finish',
            },
            loadding: 'Loadding',
            fastsearch: 'Quick search',
            pulling_text: 'Pull down to refresh',
            ctrl: {
                form: "Form",
                multieditviewpanel: "multieditviewpanel",
                searchform: "searchform",
            },
            view: "View",
            notConfig: " Parameter not configured",
            message: {
                success: "successfully",
                fail: "failed",
                savedSuccess: "Saved successfully",
                deleteSccess: "successfully deleted",
                warning: " Warning ",
                confirmToDelete: "Confirm to delete",
                unrecoverable: " Will the delete operation be unrecoverable ",
                totle: " A total of ",
                data: " data"
            },
            statusMessage: {
                200: 'The server successfully returned the requested data',
                201: 'New or modified data is successful.',
                202: 'The request has been queued in the background (asynchronous task).',
                204: 'The data was deleted successfully.',
                400: 'There was an error in the request issued, and the server did not create or modify data.',
                401: 'The user does not have permission (token, user name, wrong password).',
                403: 'The user is authorized, but access is prohibited.',
                404: 'The request issued was for a non-existent record, and the server did not operate.',
                405: 'Method not allowed',
                406: 'The requested format is not available.',
                410: 'The requested resource is permanently deleted and will no longer be available.',
                422: 'When creating an object, a validation error occurred.',
                500: 'An error occurred on the server, please check the server.',
                502: 'Gateway error.',
                503: 'The service is unavailable, the server is temporarily overloaded or maintained.',
                504: 'Gateway timeout.',
            },
            errorMessage: {
                100: 'unknown',
                101: 'Request error',
                5001: 'Data does not exist',
                5002: 'Data already exists and cannot be recreated',
                5003: 'New creation failed',
                5004: 'The data does not exist and cannot be saved',
                5005: 'Data deletion failed'
            },
            title: {
                choose: 'Choose',
                customDashboard: 'Custom dashboard',
                styleSetting: 'Style setting'
            },
            pickupviewpanel: {
                havechosen: 'Chosen:'
            },
            error: {
                batchError: 'Batch operation failed',
                systemError: 'Error, system exception',
                systemErrorRetry: 'The system is abnormal, please try again!',
                dataError: 'data is abnormal',
                loadPanelError: 'Loading panel model is abnormal',
                unopendata: "There is no opendata",
                unnewdata: "There is no newdata",
                unremove: "Don't remove",
                unrefresh: "There is no refresh",
            },
            warn: {
                notSupportThisMode: 'Does not support this mode to open',
                editLogicNotExist: 'Edit application interface logic does not exist',
                newLogicNotExist: 'New application interface logic does not exist',
                addNNInBatches: 'Add N:N relationship when adding in batches',
                unbatchadd: 'Only supports batch addition but not implemented',
                dynaViewNotFound: 'Process function operation view not found',
                markAsFailRead: 'Failed to mark to-do task as read',
                getDataWarn: 'Get data abnormal'
            },
            log: {
                redirection: 'Redirection...'
            },
            success: {
                submitSuccess: 'Submit data successfully'
            }
        },
        userCustom: userCustom_en_US,
    }
    return data;
}
export default getAppLocale;