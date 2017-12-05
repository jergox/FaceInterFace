package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller implements Initializable {

	@FXML
	private Label logoLabel;

	@FXML
	private Pane spinnerPane;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private Label descriptionLabel;

	@FXML
	private Label nameLabel;

	Main main;
	Stage stage;
	
	@FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;

	public void main(Stage stage, Main main) {
		this.main = main;
		this.stage = stage;
	}

	public void showMenu() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("login.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage sendStage = new Stage();
			sendStage.setTitle("Main Menu");
			Scene scene=new Scene(page);
			sendStage.setScene(scene);
			sendStage.show();
			System.out.println("second stage ok");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		TranslateTransition translateTransition = new TranslateTransition(
				Duration.seconds(0.5), logoLabel);
		translateTransition.setByY(700);
		translateTransition.play();

		TranslateTransition translateTransition0 = new TranslateTransition(
				Duration.seconds(0.5), nameLabel);
		translateTransition0.setByY(700);
		translateTransition0.play();

		TranslateTransition translateTransition00 = new TranslateTransition(
				Duration.seconds(0.5), descriptionLabel);
		translateTransition00.setByY(700);
		translateTransition00.play();

		translateTransition
				.setOnFinished(event -> {
					TranslateTransition translateTransition1 = new TranslateTransition(
							Duration.seconds(1), logoLabel);
					translateTransition1.setByY(-700);
					translateTransition1.play();

					translateTransition1.setOnFinished(event1 -> {

						nameLabel.setVisible(true);

						TranslateTransition translateTransition11 = new TranslateTransition(
								Duration.seconds(1), nameLabel);
						translateTransition11.setByY(-700);
						translateTransition11.play();

						translateTransition11.setOnFinished(event2 -> {

							descriptionLabel.setVisible(true);
							TranslateTransition translateTransition111 = new TranslateTransition(
									Duration.seconds(1), descriptionLabel);
							translateTransition111.setByY(-700);
							translateTransition111.play();

							translateTransition111.setOnFinished(event4 -> {

									FadeTransition fadeTransition1 = new FadeTransition(
											Duration.seconds(1), rootPane);
									fadeTransition1.setFromValue(1);
									fadeTransition1.setToValue(0.1);
									fadeTransition1.play();

									fadeTransition1.setOnFinished(event5 -> {
										main.closeStage();
										showMenu();
										System.out
												.println("------- splash screen is closed --------");
										fondoTransicion();
//									});

								});

							});

						});
					});

				});

	}
	
	private void fondoTransicion(){
		pane1.setStyle("-fx-background-image: url('1.jpg')");
        pane2.setStyle("-fx-background-image: url('2.jpg')");
        pane3.setStyle("-fx-background-image: url('3.jpg')");
        pane4.setStyle("-fx-background-image: url('4.jpg')");

        backgroundAnimation();
	}
	
	private void backgroundAnimation() {

        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(3),pane4);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        fadeTransition.setOnFinished(event -> {

            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(3),pane3);
            fadeTransition1.setFromValue(1);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                FadeTransition fadeTransition2=new FadeTransition(Duration.seconds(3),pane2);
                fadeTransition2.setFromValue(1);
                fadeTransition2.setToValue(0);
                fadeTransition2.play();

                fadeTransition2.setOnFinished(event2 -> {

                   FadeTransition fadeTransition0 =new FadeTransition(Duration.seconds(3),pane2);
                    fadeTransition0.setToValue(1);
                    fadeTransition0.setFromValue(0);
                    fadeTransition0.play();

                    fadeTransition0.setOnFinished(event3 -> {

                        FadeTransition fadeTransition11 =new FadeTransition(Duration.seconds(3),pane3);
                        fadeTransition11.setToValue(1);
                        fadeTransition11.setFromValue(0);
                        fadeTransition11.play();

                        fadeTransition11.setOnFinished(event4 -> {

                            FadeTransition fadeTransition22 =new FadeTransition(Duration.seconds(3),pane4);
                            fadeTransition22.setToValue(1);
                            fadeTransition22.setFromValue(0);
                            fadeTransition22.play();

                            fadeTransition22.setOnFinished(event5 -> {
                                backgroundAnimation();
                            });

                        });

                    });

                });
            });

        });

    }
}