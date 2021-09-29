package com.example.servlet_excise.dao;

import com.example.servlet_excise.entity.Emp;

import java.util.List;

public interface EmpDao {
    public List<Emp> selectAll();
    public int update(Emp emp);
    public int delete(int id);
    public Emp select(int id);
}
