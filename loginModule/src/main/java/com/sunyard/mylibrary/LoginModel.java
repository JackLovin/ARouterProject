package com.sunyard.mylibrary;



/**
 * @describe
 * @anthor jokerlover
 * @email:shengj.chen@sunyard.com
 * @time 2020/6/2 1:57 PM
 */
public class LoginModel {

    public void getAccountData(String accountName, String password, ILoginCallback callback) {

        if ("01".equals(accountName) && !"0000".equals(password)) {
            callback.onFailed("请输入正确的密码");
        } else if ("01".equals(accountName) && "0000".equals(password)) {
            callback.onSuccess(true);
        } else {
            callback.onFailed("请输入正确的操作员号");
        }

    }
}