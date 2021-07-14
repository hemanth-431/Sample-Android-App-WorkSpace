package com.example.splashliter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class GooglePay extends AppCompatActivity {
EditText amount,note,name,upivertualid;
Button send;
String TAG="main";
final int UPI_PAYMENT=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_pay);

        send=findViewById(R.id.send);
        amount=findViewById(R.id.amount_et);
        name=findViewById(R.id.name);
        note=findViewById(R.id.note);
        upivertualid=findViewById(R.id.upi_id);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(name.getText().toString().trim())){
                    Toast.makeText(GooglePay.this,"Name is Invalid", Toast.LENGTH_LONG).show();

                }else if(TextUtils.isEmpty(upivertualid.getText().toString().trim()))
                {
                    Toast.makeText(GooglePay.this,"UPI ID is Invalid", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(note.getText().toString().trim()))
                {
                    Toast.makeText(GooglePay.this,"Note is Invalid", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(amount.getText().toString().trim()))
                {
                    Toast.makeText(GooglePay.this,"Amount is Invalid", Toast.LENGTH_LONG).show();
                }else {
                    payUsingUpi(name.getText().toString(),upivertualid.getText().toString(),note.getText().toString(),amount.getText().toString());
                }
            }

             void payUsingUpi(String name, String upiId, String note, String amount) {
Log.e("main ","name "+name +"--up--"+upiId+"--"+note+"--"+amount);
                 Uri uri =Uri.parse("upi://pay").buildUpon()
                                 .appendQueryParameter("pa", upiId)
                                 .appendQueryParameter("pn", name)
                              //   .appendQueryParameter("mc", "your-merchant-code")
                              //   .appendQueryParameter("tr", "your-transaction-ref-id")
                                 .appendQueryParameter("tn", note)
                                 .appendQueryParameter("am", amount)
                                 .appendQueryParameter("cu", "INR")
                               //  .appendQueryParameter("url", "your-transaction-url")
                                 .build();
                 Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
                upiPayIntent.setData(uri);

                Intent chooser=Intent.createChooser(upiPayIntent,"Pay with");
                if(null!=chooser.resolveActivity(getPackageManager())){
                    startActivityForResult(chooser,UPI_PAYMENT);
                }
                else
                {
                    Toast.makeText(GooglePay.this,"NO UPI app fount,please install one to continue",Toast.LENGTH_LONG).show();
                }

            }


        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("main ","response "+resultCode);
        switch (requestCode){
            case UPI_PAYMENT:
                if((RESULT_OK==resultCode)||(requestCode==11)){
                    if(data!=null){
                        String trxt=data.getStringExtra("response");
                        Log.e("UPI","onActivityResult: "+trxt);
                        ArrayList<String> dataList=new ArrayList<>();
                        dataList.add(trxt);
                        upiPaymentDataOperation(dataList);
                    }
                }else {
                    Log.e("UPI","onActivityResult: "+"Return data is null");
                    ArrayList<String> dataList=new ArrayList<>();
                    dataList.add("nothing");
                    upiPaymentDataOperation(dataList);
                }
                break;
        }

    }
    private void upiPaymentDataOperation(ArrayList<String> data)
    {
        if(isConnectionAvailable(GooglePay.this)){
            String str=data.get(0);
            Log.e("UPIPAY","upiPaymentDataOperation: "+str);
            String paymentcancel="";
            if(str==null) str="discard";
            String status="";
            String approvalRefNo="";
            String response[]=str.split("&");
            for (int i=0;i<response.length;i++)
            {
                String equalstr[]=response[i].split("=");
                if(equalstr.length >= 2) {
                    if (equalstr[0].toLowerCase().equals("Status".toLowerCase())) {
                        status = equalstr[1].toLowerCase();
                    }
                    else if (equalstr[0].toLowerCase().equals("ApprovalRefNo".toLowerCase()) || equalstr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                        approvalRefNo = equalstr[1];
                    }
                }
                else {
                    paymentcancel = "Payment cancelled by user.";
                }
            }


            if (status.equals("success")) {
                //Code to handle successful transaction here.
                Toast.makeText(GooglePay.this, "Transaction successful.", Toast.LENGTH_SHORT).show();
                Log.e("UPI", "payment successfull: "+approvalRefNo);
            }
            else if("Payment cancelled by user.".equals(paymentcancel)) {
                Toast.makeText(GooglePay.this, "Payment cancelled by user.", Toast.LENGTH_SHORT).show();
                Log.e("UPI", "Cancelled by user: "+approvalRefNo);
            }
            else {
                Toast.makeText(GooglePay.this, "Transaction failed.Please try again", Toast.LENGTH_SHORT).show();
                Log.e("UPI", "failed payment: "+approvalRefNo);
            }
        } else {
            Log.e("UPI", "Internet issue: ");
            Toast.makeText(GooglePay.this, "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isConnectionAvailable(GooglePay googlePay) {
        ConnectivityManager connectivityManager = (ConnectivityManager) googlePay.getSystemService(GooglePay.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()
                    && netInfo.isConnectedOrConnecting()
                    && netInfo.isAvailable()) {
                return true;
            }
        }
        return false;

    }


}
