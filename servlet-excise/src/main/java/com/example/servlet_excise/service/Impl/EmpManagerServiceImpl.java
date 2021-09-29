package com.example.servlet_excise.service.Impl;

import com.example.servlet_excise.dao.EmpManagerDao;
import com.example.servlet_excise.dao.Impl.EmpManagerDaoImpl;
import com.example.servlet_excise.entity.EmpManager;
import com.example.servlet_excise.service.EmpManagerService;
import com.example.servlet_excise.utils.DbUtils;

public class EmpManagerServiceImpl implements EmpManagerService {
    @Override
    public EmpManager login(String username, String password) {
        EmpManager empManager=null;
        try{
            DbUtils.begin();
            EmpManagerDao empManagerDao =new EmpManagerDaoImpl();
            EmpManager temp = empManagerDao.select(username);
            if(temp!=null) {
                if (temp.getPassword().equals(password)) {
                    empManager = temp;
                }
            }
            DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollback();
            e.printStackTrace();
        }
        return empManager;
    }
}
