package com.example.eldar.schoolservers;

import java.io.Serializable;

public interface ViewCallback {
    void onStatusChanged(Serializable newStatus);
}