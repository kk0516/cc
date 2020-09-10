package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService  cservice;

    @GetMapping("list")
    public ResponseEntity<List<Category>> list(@RequestParam("pid") Long pid) {
        if (pid == null || pid.longValue() < 0) {
            // 响应400，相当于ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return ResponseEntity.badRequest().build();

        }
        List<Category> categories = this.cservice.queryCategoriesByPid(pid);
        if(CollectionUtils.isEmpty(categories)){
            return  ResponseEntity .notFound().build();
        }
        return  ResponseEntity.ok(categories);
    }

}
