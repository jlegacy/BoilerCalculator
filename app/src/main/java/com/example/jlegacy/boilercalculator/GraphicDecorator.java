package com.example.jlegacy.boilercalculator;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jlegacy on 2/5/2015.
 */
public class GraphicDecorator extends FireTubeDecorator {

    public GraphicDecorator(IFireTubeObject myBaseObject) {
        super(myBaseObject);
    }

    public static Point PointOnCircle(float radius, float angleInDegrees, Point origin) {
        // Convert from degrees to radians via multiplication by PI/180
        float x = (float) (radius * Math.cos(angleInDegrees * Math.PI / 180)) + (float) origin.x;
        float y = (float) (radius * Math.sin(angleInDegrees * Math.PI / 180)) + (float) origin.y;

        return new Point(x, y);

    }

    public static boolean checkDistance(double fireTubeMaxDistance, Point passedPoints) {
        double distance = Math.sqrt(Math.pow((500 - passedPoints.x), 2) + Math.pow((500 - passedPoints.y), 2));
        if (distance < fireTubeMaxDistance) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkFireTubeArray(List<SearchPoints> searchPoints, Point passedPoints) {

        for (SearchPoints s : searchPoints) {
            if (s.point.x == (passedPoints.x) && s.point.y == (passedPoints.y)) {
                return true;
            }
        }

        return false;


    }

    @Override
    public FireTubeObject createFireTubeObject(InputObject obj) {
        return addGraphics(myBaseObject.createFireTubeObject(obj));
    }

    private FireTubeObject addGraphics(FireTubeObject inputObj) {

        List<SearchPoints> myPoints = new ArrayList<>();

        inputObj.points = new ArrayList<Point>();
        double pi = 3.141592653589793;

        Point passedPoint = new Point(500, 500);

        SearchPoints initPoint = new SearchPoints();
        initPoint.point = new Point(500, 500);
        initPoint.processed = false;
        myPoints.add(initPoint);

        for (int z = 0; z < myPoints.size(); z++) {

            if (myPoints.get(z).processed == false) {
                passedPoint = new Point(myPoints.get(z).point.x, myPoints.get(z).point.y);
                myPoints.get(z).processed = true;
                for (float degrees = 0; degrees < 360; degrees = degrees + 60) {
                    Point createPoint = PointOnCircle((float) inputObj.fireTubeDistanceBetweenCenters, degrees, passedPoint);
                    if (checkDistance(inputObj.fireTubeMaxDistance, createPoint)) {
                        if (!checkFireTubeArray(myPoints, createPoint)) {
                            SearchPoints addPoints = new SearchPoints();
                            addPoints.point = new Point(createPoint.x, createPoint.y);
                            addPoints.processed = false;
                            myPoints.add(addPoints);
                        }
                    }
                }

            }
        }

        inputObj.numberOfFireTubes = myPoints.size();
        inputObj.totalHeatSquareInches = myPoints.size() * 2 * pi * (inputObj.diameterOfFiretube / 2) * inputObj.heightOfFiretube;
        inputObj.workingHeatSquareInches = inputObj.totalHeatSquareInches * .66;
        inputObj.totalLengthTubeFeet = (myPoints.size() * inputObj.heightOfFiretube) / 12;
        return inputObj;
    }

    class SearchPoints {
        Point point;
        Boolean processed;
    }


}
