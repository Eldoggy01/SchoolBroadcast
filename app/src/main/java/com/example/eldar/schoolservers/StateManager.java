package com.example.eldar.schoolservers;

class StateManager {
    private static final StateManager ourInstance = new StateManager();

   private EnumState state;

    static StateManager getInstance() {
        return ourInstance;
    }

    private StateManager() {
    }

    public EnumState getState(){
        return state;
    }

    public void setState(EnumState state) {
        this.state = state;
    }
}
