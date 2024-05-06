package com.test.FWD.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.FWD.dtos.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper extends BaseMapper<User> {




}
