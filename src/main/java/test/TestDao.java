/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.aldroid.hormid.core.database.BaseDaoI;
import com.aldroid.hormid.user.bean.UserBean;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 *
 * @author renaldo
 */
@Repository
public interface TestDao extends BaseDaoI<UserBean>{
    final String TEST = "select 'halo_test' from dual";
    
    abstract UserBean selectByPublicId(@Param("publicid") int publicid) throws Exception;


    @Select(TEST)
    public List<String> selectDual() throws Exception;
}