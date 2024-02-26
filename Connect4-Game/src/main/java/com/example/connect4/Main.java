package com.example.connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    private Controller controller;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Hello-view.fxml"));
        GridPane rootGridPane = fxmlLoader.load();

        controller = fxmlLoader.getController();
        controller.createPlayground();

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(stage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    private MenuBar createMenu(){

        //file menu
        Menu fileMenu = new Menu("File");

        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(actionEvent -> controller.resetGame());

        MenuItem resetGame = new MenuItem("Reset game");
        resetGame.setOnAction(actionEvent -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exitGame = new MenuItem("Exit game");
        exitGame.setOnAction(actionEvent -> exitGame());

        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);

        //help menu

        Menu helpMenu = new Menu("Help");

        MenuItem aboutGame = new MenuItem("About Game");
        aboutGame.setOnAction(actionEvent -> aboutGame());

        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem aboutMe = new MenuItem("About me");
        aboutMe.setOnAction(actionEvent -> aboutMe());

        helpMenu.getItems().addAll(aboutGame,separator,aboutMe);


        MenuBar menuBar = new MenuBar();

        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Faiz khan");
        alert.setContentText("""
                I love to play around with code and create games.
                connect 4 is one of them. in free time,
                I like to spend time with nears and dears.""");
        alert.show();
    }

    private void aboutGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect game");
        alert.setHeaderText("How to play");
        alert.setContentText("""
                 Connect Four is a two-player connection game in which the
                 players first choose a color and then take turns dropping
                 colored discs from the top into a seven - column, six-row
                 vertically suspended grid. The pieces fall straight down,
                 occupying the next available space within the column. The
                 objective of game is to be the first to form a horizontal,
                 vertical, or diagonal line of four of one's own discs.
                 Connect Four is a solved game.The first player can always
                 win by playing the right moves.""");

        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {
    }

    public static void main(String[] args) {
        launch();
    }
}