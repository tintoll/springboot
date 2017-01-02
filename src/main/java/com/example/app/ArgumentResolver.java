package com.example.app;

import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * Created by tinoll on 2017. 1. 3..
 */
@Component
public interface ArgumentResolver {
    Argument resolve(InputStream stream);
}
