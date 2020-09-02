package com.example.demojdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ：fuhua zhang
 * @date ：Created in 2020/8/24 15:59
 * @description：
 * @modified By：
 * @version:
 */
@Controller
@RequestMapping("/test")
public class JdbcController {

    @Autowired
    @Qualifier("jdbcTemplate1")
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/testJdbc")
    @ResponseBody
    public void selectAll(@RequestParam(value = "sql", required = false) String sql) {

        String sqlselect = sql;
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sqlselect);

        System.out.println("sql查询到数据" + maps);

    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Map<String, Object>> selectAll1() {

        String sqlselect = "  select * from zfh.znkf_ywlx_config a left join zfh.znkf_ywlx_activity b on a.ywlxdm=b.ywlxdm limit 100 ";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sqlselect);
        if (maps != null) {
            Map<String, Object> map = maps.get(0);
            Set<String> strings = map.keySet();
            System.out.println("获取到表头" + strings);
        }

        System.out.println("sql查询到数据" + maps);
        return maps;

    }

    private String handle(String date) {

        return null;
    }
}
