module at.ac.fhcampuswien.fhmdb {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.jfoenix;
    requires okhttp3;
    requires com.google.gson;
    requires ormlite.jdbc;
    requires java.sql;

    opens at.ac.fhcampuswien.fhmdb.models to com.google.gson;
    opens at.ac.fhcampuswien.fhmdb.database to ormlite.jdbc;

    opens at.ac.fhcampuswien.fhmdb to javafx.fxml;
    exports at.ac.fhcampuswien.fhmdb.models;
    exports at.ac.fhcampuswien.fhmdb;
    exports at.ac.fhcampuswien.fhmdb.controllers;
    opens at.ac.fhcampuswien.fhmdb.controllers to javafx.fxml;
    exports at.ac.fhcampuswien.fhmdb.factoryPattern;
    opens at.ac.fhcampuswien.fhmdb.factoryPattern to javafx.fxml;
    exports at.ac.fhcampuswien.fhmdb.statePattern;
    opens at.ac.fhcampuswien.fhmdb.statePattern to com.google.gson;
    exports at.ac.fhcampuswien.fhmdb.enums;
    opens at.ac.fhcampuswien.fhmdb.enums to com.google.gson;
}