package com.example.eldar.schoolservers;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class StateManager {
    private static final StateManager ourInstance = new StateManager();

    private List<EnumState> stateList = new LinkedList<>(Arrays.asList(EnumState.values()));
    private Iterator<EnumState> iter = stateList.iterator();
    private EnumState state = iter.next();

    static StateManager getInstance() {
        return ourInstance;
    }

    private StateManager() {
    }

    public EnumState getState() {
        return state;
    }

    public void changeState() {
        if (!iter.hasNext()) {
            iter = stateList.iterator();
        }
        this.state = iter.next();
    }


    private enum EnumState {
        A, B, C, D, E;
    }
}
