package com.ghj.annotation;

import com.ghj.common.MapperScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(MapperScan.class)
public @interface EnableMapper {
}
