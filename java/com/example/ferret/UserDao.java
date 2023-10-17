package com.example.ferret;

import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static final String TAG = "CRUD User";

    public static int insertUser(User mUser , Context mContext) {

        int vResponse = 0;
        String mSql;
        try{

            mSql = "INSERT INTO usuario (nome_usuario, email, senha, nivel_acesso, status_usuario, telefone, token) VALUES (?, ?, ?, 'Membro', 'ativo', '000', ?)";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1,mUser.getNome_usuario());
            mPreparedStatement.setString(2,mUser.getEmail());
            mPreparedStatement.setString(3,mUser.getSenha());
            mPreparedStatement.setString(4,mUser.getReset_password_otp());
            mPreparedStatement.setLong(5,mUser.getReset_password_created_at());
            mPreparedStatement.setString(7, mUser.getToken());

            vResponse = mPreparedStatement.executeUpdate();
        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return vResponse;
    }
    public static int insertUserProfile(User mUser , Context mContext) {

        int vResponse = 0;
        String mSql;
        try{

            mSql = "INSERT INTO usuario (nome_usuario, email, senha, nivel_acesso, status_usuario, telefone, token) VALUES (?, ?, ?, 'Membro', 'ativo', '000', ?)";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1,mUser.getNome_usuario());
            mPreparedStatement.setString(2,mUser.getEmail());
            mPreparedStatement.setString(3,mUser.getSenha());
            mPreparedStatement.setString(7, mUser.getToken());

            vResponse = mPreparedStatement.executeUpdate();
        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return vResponse;
    }
    public static String recoveryToken(User mUser , Context mContext) {

        String vResponse = "";
        String mSql;
        try{

            mSql = "SELECT id, email, token usuario  WHERE email = ?";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1,mUser.getEmail());

            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mResultSet.next();
            vResponse = mResultSet.getString(3);

        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return vResponse;
    }

    public  static int updateUser(User mUser , Context mContext) {

        int vResponse = 0;
        String mSql;

        try{
            mSql = "UPDATE usuario SET nome_usuario=?, email=?, senha=?, nivel_acesso=?, telefone=?, status_usuario=?, reset_password_otp=?, reset_password_created_at=?, token=? WHERE id=?";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1,mUser.getNome_usuario());
            mPreparedStatement.setString(2,mUser.getEmail());
            mPreparedStatement.setString(3,mUser.getSenha());
            mPreparedStatement.setString(4,mUser.getNivel_acesso());
            mPreparedStatement.setString(5,mUser.getTelefone());
            mPreparedStatement.setString(6,mUser.getStatus_usuario());
            mPreparedStatement.setString(7,mUser.getReset_password_otp());
            mPreparedStatement.setLong(8,mUser.getReset_password_created_at());
            mPreparedStatement.setString(9,mUser.getToken());
            mPreparedStatement.setInt(10,mUser.getId());


        } catch (Exception e){
            Log.e(TAG , e.getMessage());}

        return vResponse;

    }
    public  static int updatePassword(User mUser , Context mContext) {

        int vResponse = 0;
        String mSql;

        try{
            mSql = "UPDATE usuario SET senha=? WHERE email=?";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);


            mPreparedStatement.setString(1,mUser.getEmail());
            mPreparedStatement.setString(2,mUser.getSenha());



        } catch (Exception e){
            Log.e(TAG , e.getMessage());}

        return vResponse;

    }

    public  static int deleteUser(User mUser , Context mContext) {

        int vResponse = 0;
        String mSql;

        try{
            mSql = "DELETE FROM usuario WHERE id=?";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);


            mPreparedStatement.setInt(1,mUser.getId());

            vResponse = mPreparedStatement.executeUpdate();


        } catch (Exception e){
            Log.e(TAG , e.getMessage());}

        return vResponse;

    }

    public  static int deleteAllUser(Context mContext) {

        int vResponse = 0;
        String mSql;

        try{
            mSql = "DELETE FROM usuario ";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            vResponse = mPreparedStatement.executeUpdate();


        } catch (Exception e){
            Log.e(TAG , e.getMessage());}

        return vResponse;

    }

    public static List<User> listAllUser(Context mContext){
        List<User> mUserList = null;
        String mSql;
        try {
            mSql = "SELECT id, nome_usuario, email, senha, nivel_acesso, telefone, status_usuario, reset_password_otp, reset_password_created_at, Token  FROM usuario ORDER BY name ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mUserList = new ArrayList<User>();
            while (mResultSet.next()) {
                mUserList.add(new User(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getString(6),
                        mResultSet.getString(7),
                        mResultSet.getString(8),
                        mResultSet.getLong(9), ""
                ));
            }
        }catch (Exception e){
            Log.e(TAG , e.getMessage());
        }
        return mUserList;
    }

    public static List<User> searchUsersByName(String mName , Context mContext){
        List<User> mUserList = null;
        String mSql;
        try {
            mSql = "SELECT d, nome_usuario, email, senha, nivel_acesso, telefone, status_usuario, reset_password_otp, reset_password_created_at, Token FROM usuario WHERE nome_usuario LIKE '%" + mName + " ORDER BY nome_usuario ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mUserList = new ArrayList<User>();
            while (mResultSet.next()) {
                mUserList.add(new User(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getString(6),
                        mResultSet.getString(7),
                        mResultSet.getString(8),
                        mResultSet.getLong(9), ""));

            }
        }catch (Exception e){
            Log.e(TAG , e.getMessage());
        }
        return mUserList;
    }


//    public static String authenticateUser(User mUser , Context mContext ){
//        String mResponse = "";
//        String mSql = "SELECT id , nome_usuario, email, foto, senha, nivel_acesso , telefone, status_usuario FROM usuario WHERE email LIKE ?";
//        try{
//            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
//            mPreparedStatement.setString(1, mUser.getSenha());
//            mPreparedStatement.setString(2, mUser.getEmail());
//            ResultSet mResultSet = mPreparedStatement.executeQuery();
//            while (mResultSet.next()){
//                mResponse = mResultSet.getString(1);
////                mResponse = mResultSet.getString("fullname");
//            }


    public static String authenticateUser(User mUser, Context mContext) {
        String mResponse = "";
        String mSql;
        try {

            //https://alvinalexander.com/blog/post/jdbc/jdbc-preparedstatement-select-like/

            mSql ="SELECT id , nome_usuario, email, foto, senha, nivel_acesso , telefone, status_usuario FROM usuario WHERE senha LIKE ? AND email LIKE ?";
            //mSql = "SELECT id, nome, email, password FROM Adotante WHERE senha = ? and email = ?";

            //https://pt.stackoverflow.com/questions/369624/statement-ou-preparedstatement-por-qual-motivo-evitar-usar-o-statement

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
//            mPreparedStatement.setString(1, "%" + mUser.getSenha() + "%");
//            mPreparedStatement.setString(2, "%" + mUser.getEmail() + "%");
            mPreparedStatement.setString(1, mUser.getSenha());
            mPreparedStatement.setString(2, mUser.getEmail());
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                mResponse = mResultSet.getString(2); // veja o objeto 'mSql'
            }


        } catch (Exception e){
            mResponse = "Exception";
            Log.e(TAG , e.getMessage());
            e.printStackTrace();
        }
        return mResponse;
    }



}