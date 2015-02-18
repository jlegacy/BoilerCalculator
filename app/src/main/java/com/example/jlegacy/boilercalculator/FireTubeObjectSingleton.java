package com.example.jlegacy.boilercalculator;

import java.util.ArrayList;

/**
 * Created by jlegacy on 2/17/2015.
 */
public class FireTubeObjectSingleton {

    ArrayList<Point> points;
    double diameterOfBoiler;
    double diameterOfFiretube;
    double heightOfFiretube;
    double clearanceDimension;
    double fireTubeDistanceBetweenCenters;
    double fireTubeMaxDistance;
    double scalingFactor;
    double fireTubeLengthMidline;
    double numberOfFireTubes;
    double workingHeatSquareInches;
    double totalHeatSquareInches;
    double totalLengthTubeFeet;

    private static FireTubeObjectSingleton instance = null;

    protected FireTubeObjectSingleton() {
        // Exists only to defeat instantiation.
    }

    public static FireTubeObjectSingleton getInstance() {
        if (instance == null) {
            instance = new FireTubeObjectSingleton();
        }
        return instance;
    }
}
