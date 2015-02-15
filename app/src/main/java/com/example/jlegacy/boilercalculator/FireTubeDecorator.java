package com.example.jlegacy.boilercalculator;

/**
 * Created by jlegacy on 2/5/2015.
 */
abstract class FireTubeDecorator implements IFireTubeObject {
    protected IFireTubeObject myBaseObject;

    public FireTubeDecorator(IFireTubeObject myInputObj)
    {
        this.myBaseObject = myInputObj;
    }

    public FireTubeObject createFireTubeObject(InputObject obj) {
        return myBaseObject.createFireTubeObject(obj);
    }
}
