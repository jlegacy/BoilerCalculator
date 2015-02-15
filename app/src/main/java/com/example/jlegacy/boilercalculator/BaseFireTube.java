package com.example.jlegacy.boilercalculator;

import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by jlegacy on 1/24/2015.
 */
public class BaseFireTube implements IFireTubeObject {

   @Override
    public FireTubeObject createFireTubeObject(InputObject obj) {

        double pi = 3.141592653589793;

        FireTubeObject myObject = new FireTubeObject();

        myObject.diameterOfBoiler = obj.diameterOfBoiler;
        myObject.diameterOfFiretube = obj.diameterOfFiretube;
        myObject.heightOfFiretube = obj.heightOfFiretube;

        myObject.clearanceDimension = obj.diameterOfFiretube * .25;
        myObject.fireTubeDistanceBetweenCenters = myObject.diameterOfFiretube + myObject.clearanceDimension;
        myObject.fireTubeMaxDistance = ((obj.diameterOfBoiler) / 2) - (obj.diameterOfFiretube);

        myObject.scalingFactor = obj.diameterOfBoiler / 400;
        myObject.fireTubeLengthMidline = (Math.sqrt((Math.pow((myObject.fireTubeDistanceBetweenCenters), 2)) - (Math.pow((myObject.fireTubeDistanceBetweenCenters / 2), 2))));
        myObject.totalHeatSquareInches = (2 * pi * ((obj.diameterOfFiretube) / 2) * obj.heightOfFiretube) * myObject.numberOfFireTubes;
        myObject.workingHeatSquareInches = .66 *  myObject.totalHeatSquareInches;
        myObject.totalLengthTubeFeet = (myObject.numberOfFireTubes * obj.heightOfFiretube) / 12;

        return myObject;
    }

}
