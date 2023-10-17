package com.example.ferret;

import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {

    public static final String TAG = "CRUD Projeto";

    public static int InsertProject(Project mProject , Context mContext) {

        int vResponse = 0;
        String mSql;
        try{

            mSql = "INSERT INTO projeto (titulo, quat_membros, descricao, data_inicio, data_fim, status_projeto, foto_projeto, usuario_id) VALUES (?, ?, ?, ?, ? , 'ativo', ?, ?)";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1,mProject.getTitulo());
            mPreparedStatement.setInt(2,mProject.getQuant_membros());
            mPreparedStatement.setString(3,mProject.getDescricao());
            mPreparedStatement.setString(4,mProject.getData_inicio());
            mPreparedStatement.setString(5,mProject.getData_fim());
            mPreparedStatement.setString(6,mProject.getStatus_projeto());
            mPreparedStatement.setLong(7,mProject.getFoto_projeto());
            mPreparedStatement.setInt(8,mProject.getUsuario_id());


            vResponse = mPreparedStatement.executeUpdate();
        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return vResponse;
    }

    public  static int updateProject(Project mProject , Context mContext) {

        int vResponse = 0;
        String mSql;

        try{
            mSql = "UPDATE projeto SET titulo=?, quant_membros=?, descricao=?, data_inicio=?, data_fim=?,status_projeto=?, foto_projeto=? WHERE id=?";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1,mProject.getTitulo());
            mPreparedStatement.setInt(2,mProject.getQuant_membros());
            mPreparedStatement.setString(3,mProject.getDescricao());
            mPreparedStatement.setString(4,mProject.getData_inicio());
            mPreparedStatement.setString(5,mProject.getData_fim());
            mPreparedStatement.setLong(6,mProject.getFoto_projeto());
            mPreparedStatement.setString(7,mProject.getStatus_projeto());
            mPreparedStatement.setInt(8,mProject.getId());


        } catch (Exception e){
            Log.e(TAG , e.getMessage());}

        return vResponse;

    }




    public static List<Project> listAllProject(Context mContext){
        List<Project> mProjectList = null;
        String mSql;
        try {
            mSql = "SELECT id, titulo, quat_membros, descricao, data_inicio, data_fim, status_projeto, foto_projeto, usuario_id FROM project ORDER BY name ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mProjectList = new ArrayList<Project>();
            while (mResultSet.next()) {
                mProjectList.add(new Project(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getInt(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getString(6),
                        mResultSet.getString(7),
                        mResultSet.getLong(8),
                        mResultSet.getInt(9)
                ));
            }
        }catch (Exception e){
            Log.e(TAG , e.getMessage());
        }
        return mProjectList;
    }

    public static List<Project> searchProjectByName(String mTitulo , Context mContext){
        List<Project> mProjectList = null;
        String mSql;
        try {
            mSql = "SELECT id, titulo, quat_membros, descricao, data_inicio, data_fim, status_projeto, foto_projeto, usuario_id FROM project WHERE titulo LIKE '%" + mTitulo + "%' ORDER BY titulo ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mProjectList = new ArrayList<Project>();
            while (mResultSet.next()) {
                mProjectList.add(new Project(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getInt(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getString(6),
                        mResultSet.getString(7),
                        mResultSet.getLong(8),
                        mResultSet.getInt(9)));
            }
        }catch (Exception e){
            Log.e(TAG , e.getMessage());
        }
        return mProjectList;
    }


}