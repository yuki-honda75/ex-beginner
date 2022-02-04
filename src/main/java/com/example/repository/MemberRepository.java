package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Member;

@Repository
public class MemberRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Member> MEMBE_ROW_MAPPER 
		= new BeanPropertyRowMapper<>(Member.class);
	
	public List<Member> findByName(String name) {
		String sql = "SELECT name FROM members WHERE name LIKE :name";
		name = "%" + name + "%";
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", name);
		
		List<Member> memberList = template.query(sql, param, MEMBE_ROW_MAPPER);
		
		return memberList;
	}
}
