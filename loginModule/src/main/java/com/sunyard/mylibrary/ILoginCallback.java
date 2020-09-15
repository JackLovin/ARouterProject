package com.sunyard.mylibrary;


/**
 * @describe
 * @anthor jokerlover
 * @email:shengj.chen@sunyard.com
 * @time 2020/6/2 1:58 PM
 */
public interface ILoginCallback {
     void onSuccess(Boolean isLogin);
     void onFailed(String failMessage);
}
