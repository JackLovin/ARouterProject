package com.sunyard.commonmodule;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.sunyard.commonmodule.base.IBaseActivity;


public class DialogUtil {

    private static final String TAG = "DialogUtil";

    public interface OnResultListener {
        void onResult(String result);
    }

    public interface OnPinResultListener extends OnResultListener {
        void onClose();
    }

    public interface OnDialogListener {

        void onPositive();

    }

    public interface OnDialogListeners {

        void onPositive();
        void onCancle();

    }

    public interface OnAlertDialogListener{
        void onPositive();
        void onCancel();
    }

    public static AlertDialog showConfirmDialog(Context context, String message, final OnDialogListener listener) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog alertDialog =
                builder.setMessage(message)
                        .setCancelable(false)
                        .setPositiveButton("是", (dialog, which) -> {
                            listener.onPositive();
                            dialog.dismiss();
                        })
                        .setNegativeButton("否", (dialog, which) -> dialog.dismiss())
                        .create();
        return alertDialog;
    }

    public static AlertDialog showTipDialog(Context context, String message, final OnAlertDialogListener listener) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog alertDialog =
                builder.setMessage(message)
                        .setCancelable(false)
                        .setPositiveButton("是", (dialog, which) -> {
                            listener.onPositive();
                            dialog.dismiss();
                        })
                        .setNegativeButton("否", (dialog, which) -> {
                            listener.onCancel();
                            dialog.dismiss();
                        })
                        .create();
        return alertDialog;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                       提示信息Dialog                                        //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public static AlertDialog showInfoDialog(IBaseActivity activity, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        final View view = LayoutInflater.from(activity).inflate(R.layout.dialog_info, null);
        final TextView tvInfo = view.findViewById(R.id.tv_info);
        tvInfo.setText(message);
        final Button btConfirm = view.findViewById(R.id.bt_confirm);

        final AlertDialog alertDialog = builder.setView(view)
                .setIcon(R.drawable.ic_notifications)
                .setTitle(title)
                .create();
        btConfirm.setOnClickListener(v -> alertDialog.dismiss());

        alertDialog.show();
        return alertDialog;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                         成功Dialog                                          //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public static void showSuccessDialog(Activity context, String msg, OnDialogListener listener) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_success, null);
        final TextView tvTitle = view.findViewById(R.id.tv_message);
        final Button btConfirm = view.findViewById(R.id.bt_confirm);
        tvTitle.setText(msg);

        final AlertDialog alertDialog = builder.setView(view)
                .create();
        alertDialog.setCancelable(false);
        btConfirm.setOnClickListener(v -> {
            alertDialog.dismiss();
            if (listener != null) {
                listener.onPositive();
            }
        });
        if (alertDialog != null||alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
        alertDialog.show();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
    }
    public static void showDialog(Activity context, String msg, OnDialogListeners listener) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        final View view = LayoutInflater.from(context).inflate(R.layout.dialog, null);
        final TextView tvTitle = view.findViewById(R.id.tv_message);
        final Button btConfirm = view.findViewById(R.id.bt_confirm);
        final Button btCancle = view.findViewById(R.id.bt_cancle);
        tvTitle.setText(msg);

        final AlertDialog alertDialog = builder.setView(view)
                .create();
        alertDialog.setCancelable(false);
        btConfirm.setOnClickListener(v -> {
            alertDialog.dismiss();
            if (listener != null) {
                listener.onPositive();
            }
        });   btCancle.setOnClickListener(v -> {
            alertDialog.dismiss();
            if (listener != null) {
                listener.onCancle();
            }
        });
        alertDialog.show();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                         失败Dialog                                          //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public static AlertDialog showFailureDialog(Activity context, String msg, OnDialogListener listener) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_failed, null);
        final TextView tvTitle = view.findViewById(R.id.tv_message);
        final Button btConfirm = view.findViewById(R.id.bt_confirm);
        tvTitle.setText(msg);

        final AlertDialog dialog = builder.setView(view)
                .create();
        dialog.setCancelable(false);
        btConfirm.setOnClickListener(v -> {
            dialog.dismiss();
            if (listener != null) {
                listener.onPositive();
            }
        });
        if (dialog != null||dialog.isShowing()) {
            dialog.dismiss();
        }
        dialog.show();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);

        return dialog;
    }
    //                                         加载Dialog                                          //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public static Dialog createLoadingDialog(Activity context, CharSequence msg) {

        final QMUITipDialog dialog = new QMUITipDialog(context, R.style.BackgroundTipDialog);
        dialog.setCancelable(false);

        dialog.setContentView(R.layout.dialog_material_progress);
        TextView tvTip = dialog.findViewById(R.id.tv_tip);
        tvTip.setText(msg);

        return dialog;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public static class QMUITipDialog extends Dialog {

        final static int COUNTS = 14;
        final static long DURATION = 1000;
        private long[] mHits = new long[COUNTS];

        public QMUITipDialog(Context context) {
            this(context, R.style.TipDialog);
        }

        public QMUITipDialog(Context context, int themeResId) {
            super(context, themeResId);

            setCanceledOnTouchOutside(false);

            // 避免意外bug，这里留后门
            setOnKeyListener((dialog, keyCode, event) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);
                    mHits[mHits.length - 1] = SystemClock.uptimeMillis();
                    if (DURATION >= (SystemClock.uptimeMillis() - mHits[0])) {
                        dismiss();
                    }
                }
                return false;
            });
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            initDialogWidth();
        }

        private void initDialogWidth() {
            Window window = getWindow();
            if (window != null) {
                WindowManager.LayoutParams wmLp = window.getAttributes();
                wmLp.width = ViewGroup.LayoutParams.MATCH_PARENT;
                window.setAttributes(wmLp);
            }
        }
    }
}
