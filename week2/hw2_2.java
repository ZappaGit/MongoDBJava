package com.tengen;

import com.mongodb.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: diego
 * Date: 10/22/13
 * Time: 8:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveLowest {
    public static void main(final String[] args) throws IOException {
        MongoClient client = new MongoClient();//new MongoClientURI("mongodb://localhost"));
        DB numbersDB = client.getDB("students");
        DBCollection grades = numbersDB.getCollection("grades");

        //group by student, sort by score
        BasicDBObject sortList = new BasicDBObject("student_id",1).append("score",1);

        DBCursor cursor = grades.find(new BasicDBObject("type", "homework")).sort(sortList);

        Object studentId = -1;

        for (DBObject entry: cursor) {
            if (!entry.get("student_id").equals(studentId)){
                System.out.println("Removing: " + entry);
                Object id = entry.get("_id");
                grades.remove(new BasicDBObject("_id", id));
            }
            studentId = entry.get("student_id");
        }

    }
}

