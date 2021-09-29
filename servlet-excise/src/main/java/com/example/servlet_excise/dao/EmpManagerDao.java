package com.example.servlet_excise.dao;

import com.example.servlet_excise.entity.EmpManager;

public interface EmpManagerDao {
    public EmpManager select(String username);
}
