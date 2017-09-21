package com.example.persist;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;

/**
 * Created by ycwu on 2017/9/21.
 */
public class PersistInitializer {
    @Inject
    public PersistInitializer(PersistService persistService) {
        persistService.start();
    }
}
