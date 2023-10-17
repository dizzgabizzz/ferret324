package com.example.ferret;
import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ferret.Activity.ProfileActivity;
import com.example.ferret.ProductAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class ProjectActivity extends AppCompatActivity {

    private static final String TAG = "ProductActivity";


    public String TEXT_SEARCH_RESULT = "my text search";
    public ProductAdapter mProductAdapter;

    TextView mTextViewUserName;

    ExtendedFloatingActionButton mFloatingActionButtonAction;
    FloatingActionButton mFloatingActionButtonLogout;

    TextView mFabLogout;

    TextView mTextViewAddProduct, mTextViewLogout, mTextViewFinalize;

    Boolean isAllFabsVisible;

    SharedPreferences mSharedPreferences;


    ActivityResultLauncher<Intent> mActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Bundle mBundleResponse = result.getData().getExtras();
                        int vId = mBundleResponse.getInt("EXTRA_ID", -1);
                        String mTitulo = mBundleResponse.getString("EXTRA_TITULO");
                        int vquat_membros = mBundleResponse.getInt("EXTRA_QUANT_MEMBROS", 1);
                        String mDescricao = mBundleResponse.getString("EXTRA_DESCRICAO");
                        String mData_inicio = mBundleResponse.getString("EXTRA_DATA_INICIO");
                        String mData_fim = mBundleResponse.getString("EXTRA_DATA_FIM");
                        String mStatus_usuario = mBundleResponse.getString("EXTRA_STATUS_USUARIO");
                        long mFoto_usuario = mBundleResponse.getLong("EXTRA_FOTO_USUARIO");
                        int mUsuario_id = mBundleResponse.getInt("EXTRA_USUARIO_ID", -1);

                        String mMessage = "CRUD message";

                    }
                }
            });

                private View.OnClickListener onItemClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RecyclerView.ViewHolder mViewHolder = (RecyclerView.ViewHolder) view.getTag();
                        int vPosition = mViewHolder.getAdapterPosition();
                        Intent mIntent = new Intent(getApplicationContext(), ProjectAddEditActivity.class);
                        mIntent.putExtra("EXTRA_ID", mProductAdapter.getProjectAt(vPosition).getId());
                        mIntent.putExtra("EXTRA_TITULO", mProductAdapter.getProjectAt(vPosition).getTitulo());
                        mIntent.putExtra("EXTRA_QUANT_MEMBROS", mProductAdapter.getProjectAt(vPosition).getQuant_membros());
                        mIntent.putExtra("EXTRA_DESCRICAO", mProductAdapter.getProjectAt(vPosition).getDescricao());
                        mIntent.putExtra("EXTRA_DATA_INICIO", mProductAdapter.getProjectAt(vPosition).getData_inicio());
                        mIntent.putExtra("EXTRA_DATA_FIM", mProductAdapter.getProjectAt(vPosition).getData_fim());
                        mIntent.putExtra("EXTRA_STATUS_USUARIO", mProductAdapter.getProjectAt(vPosition).getStatus_projeto());
                        mIntent.putExtra("EXTRA_FOTO_PROJETO", mProductAdapter.getProjectAt(vPosition).getFoto_projeto());
                        mIntent.putExtra("EXTRA_USUARIO_ID", mProductAdapter.getProjectAt(vPosition).getUsuario_id());
                        mActivityResultLauncher.launch(mIntent);
                    }

                };


                private void setupRecyclerView() {
                    RecyclerView mRecyclerView = findViewById(R.id.recyclerView_products);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    mRecyclerView.setHasFixedSize(true);
//        mProductAdapter = new ProductAdapter(getApplicationContext(), ProductDao.listAllProducts(getApplicationContext()) ); //aqui é o segredo
                    mProductAdapter = new ProductAdapter(getApplicationContext(), ProjectDao.listAllProject(getApplicationContext())); //aqui é o segredo   - nv2 na classe ProductAdapter
                    // https://stackoverflow.com/questions/25187400/updating-textview-on-activity-once-data-in-adapter-class-is-changed resposta do mmlooloo em 07-08-2014
                    mRecyclerView.setAdapter(mProductAdapter);

                    //tem mais código aqui veja TaskActivity.java do app Gerenciamento de tarefas
                    mProductAdapter.setProjectList(ProjectDao.listAllProject(getApplicationContext()));

                    mProductAdapter.setOnItemClickListener(onItemClickListener);

                    //  mProductAdapter.setOnLongClickListener(onLongItemClickListener);

                    // 17-03 https://codeburst.io/android-swipe-menu-with-recyclerview-8f28a235ff28  botoes para editar e deletar

                }

    private void verifyNotLogged(){

        if(mSharedPreferences.getString("logged", "false").equals("false")){
            showLogin();
        } else {
            mTextViewUserName.setText(mSharedPreferences.getString("username", ""));
            //setupRecycler();
        }


    }


    private  void showLogin(){
        Intent mIntent = new Intent(getApplicationContext(), Login.class);
        startActivity(mIntent);
        finish();
    }


    private void exitLogoff(){
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putString("logged", "false");
        mEditor.putString("email", "");
        mEditor.putString("fullName", "");
        mEditor.apply();
        showLogin();
    }

    public class ClickMyButtonLogout implements View

            .OnClickListener{
        @Override
        public void onClick(View view) {
            exitLogoff();
        }
    }


    private void changeStateFabsAndTexts() {
                    if (!isAllFabsVisible) {
                        mFloatingActionButtonLogout.show();
                        mTextViewLogout.setVisibility(View.VISIBLE);
                        mFloatingActionButtonAction.extend();
                        isAllFabsVisible = true;
                    } else {
                        mFloatingActionButtonLogout.hide();
                        mTextViewLogout.setVisibility(View.GONE);
                        mFloatingActionButtonAction.shrink();
                        isAllFabsVisible = false;


                    }
                }





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mFabLogout = findViewById(R.id.fab_exit_app);
        mFabLogout.setOnClickListener(new ClickMyButtonLogout());

        isAllFabsVisible = false;

        mFloatingActionButtonAction.shrink(); //estado reduzido inicialmente

        //https://stackoverflow.com/questions/30699302/android-design-support-library-expandable-floating-action-buttonfab-menu

        // https://medium.com/nerd-for-tech/how-to-add-extended-floating-action-button-in-android-android-studio-java-481cc9b3cdcb
        // https://www.youtube.com/watch?v=AIMZBwORt1k&t=548s



    }
}
