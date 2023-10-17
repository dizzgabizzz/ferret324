package com.example.ferret;

import static android.app.ProgressDialog.show;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.example.ferret.util.TokenGenerator;

import java.util.ArrayList;


public class ResetPassword extends AppCompatActivity {


    public static final String TAG = "Reset Password Activity";

    TextView mTextViewAbandonReset, mTextViewNumberA, mTextViewNumberB, mTextVIewNumberC;

    Button mButtonSubmit, mButtonCheckNumbers, mButtonSaveNewResetPassword;

    EditText mEditTextEmailReset, mEditTextNumberA, mEditTextNumberB, mEditTextNumberC, mEditTextNewResetPassword;

    String mEmail, mToken;

    LinearLayoutCompat mLinearLayoutToken, mLinearLayoutNewResetPassword;

    ArrayList<Integer> mPositionList;

    private void performAbandonReset(){
        Intent mIntent = new Intent(getApplicationContext(), Login.class);
        startActivity(mIntent);
        finish();
    }

    public class ClickAbandon implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            performAbandonReset();;
        }
    }


    private boolean isValidEmail(String mEmail){
        if( mEmail == null || mEmail.isEmpty()){
            return false;
        }

        return Patterns.EMAIL_ADDRESS.matcher(mEmail).matches();
    }

    private void performSubmit(){
        mEmail = String.valueOf(mEditTextEmailReset.getText());
        if (!isValidEmail(mEmail)){
            String mTextMessage = getString(R.string.text_not_valid_paattern_email);
            Toast.makeText(this, mTextMessage, Toast.LENGTH_SHORT).show();
            return;

        }
        User mUser = new User(mEmail);
        mToken = UserDao.recoveryToken(mUser, getApplicationContext());
        if(mToken.equals("")){
            String mTextMessage = "Verifique se o email informado é correto";
            Toast.makeText(getApplicationContext(), mTextMessage, Toast.LENGTH_SHORT).show();
            return;

        }

        mLinearLayoutToken.setVisibility(View.VISIBLE);
        mButtonSubmit.setVisibility(View.GONE);
        mEditTextEmailReset.setEnabled(false);


        mPositionList = TokenGenerator.getRandomPositions();
        for (int i = 0 ; i <mPositionList.size() ; i++){
            switch (i){
                case 0: mTextViewNumberA.setText(""+ mPositionList.get(0));break;
                case 1: mTextViewNumberB.setText(""+ mPositionList.get(1));break;
                case 2: mTextVIewNumberC.setText(""+ mPositionList.get(2));break;
            }
        }

    }



    public class ClickButtonSubmit implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            performSubmit();
        }
    }

    private void compareNumbers(){
        String mNumberA = mToken.substring(mPositionList.get(0)-1,mPositionList.get(0));
        String mNumberB = mToken.substring(mPositionList.get(1)-1,mPositionList.get(1));
        String mNumberC = mToken.substring(mPositionList.get(2)-1,mPositionList.get(2));

        if (mEditTextNumberA.getText().toString().equals(mNumberA) && mEditTextNumberB.getText().toString().equals(mNumberB) && mEditTextNumberC.getText().toString().equals(mNumberC)){
            mLinearLayoutToken.setVisibility(View.GONE);
            mLinearLayoutNewResetPassword.setVisibility(View.VISIBLE);

        } else {
            Toast.makeText(getApplicationContext() , R.string.text_numbers_token_incorrect, Toast.LENGTH_SHORT).show();
            performAbandonReset();
        }
    }

    private void verifyInputNumbersToken(){
        if(mEditTextNumberA.getText().toString().equals("") || mEditTextNumberB.getText().toString().equals("") || mEditTextNumberC.getText().toString().equals("")){
            performAbandonReset();
        }
        compareNumbers();
    }

    public class ClickMyButtonCheck implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            verifyInputNumbersToken();
        }
    }

    private void saveNewPassword(){

        User mUser = new User(mEditTextNewResetPassword.getText().toString() , mEditTextEmailReset.getText().toString());
        int vResponse = UserDao.updatePassword(mUser, getApplicationContext());
        if ( vResponse == 1){
            String mMessage = "Senha alterada com sucesso";
            Toast.makeText(getApplicationContext(), mMessage, Toast.LENGTH_SHORT).show();
        } else {
            String mMessage = "Ocorreu um erro ao alterar a senha ";
            Toast.makeText(getApplicationContext(), mMessage, Toast.LENGTH_SHORT).show();

        }
        performAbandonReset();
    }

    public class ClickMyButtonSaveNewPassword implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            saveNewPassword();
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senha3);

        mTextViewAbandonReset =findViewById(R.id.abandoned_reset);
        mTextViewAbandonReset.setOnClickListener(new ClickAbandon());

        mButtonSubmit = findViewById(R.id.text_submit);
        mButtonSubmit.setOnClickListener(new ClickButtonSubmit());

        
    }
}

//
//
//    private void showSignUp() {
//        Intent mIntent = new Intent(getApplicationContext() , SignUpActivity1.class);
//        startActivity(mIntent);
//        finish();
//
//    }
//
//    public class ClickMyNewUser implements View.OnClickListener{
//        @Override
//        public void onClick(View v) {
//            showSignUp();
//        }
//    }
